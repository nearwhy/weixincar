package com.palm360.airport.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.palm360.airport.model.OprationContentEnum;
import com.palm360.airport.model.OprationTypeEnum;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.redis.RedisUtilEx;
import com.palm360.airport.service.LogService;
import com.palm360.airport.service.UserService;
import com.palm360.airport.util.Encryption;
import com.palm360.airport.util.RandomUtil;
import com.palm360.airport.util.exception.AirportRuntimeException;

/**
 * 用户信息Service
 * 
 * @author xzl
 * 
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private LogService logService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	@Autowired
	RedisUtilEx redisUtilEx;
	
	public static void main(String[] a){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-servlet2.xml");
		UserService us= (UserService) ctx.getBean("userService");
		StopWatch sw = new StopWatch();
		
		sw.reset();
		sw.start();
		UserInfo ui =us.login("test1@xx.xx", "11111122","127.0.0.2", "fdsafdafs","iPhone");
		sw.stop();
		System.out.println("-------------"+sw.getTime());
		System.out.println(ui);
		
		System.exit(1);
	}

	/**
	 * 用户登录
	 */
	public UserInfo login(String email, String password, String loginIp,String uuid,String loginDevice) throws AirportRuntimeException {
		UserInfo ui = new UserInfo();
		ui.setEmail(email);
		
		ui = (UserInfo) userInfoDao.queryUesrInfoByEmail(ui);
		if (ui != null && null != ui.getUserID()) {
			try {
				password = Encryption.md5(password);
			} catch (NoSuchAlgorithmException e) {
				throw new AirportRuntimeException("system.err.unkown", e);
			}
			if (!password.equals(ui.getPassword())) {
				logService.writeLog(OprationTypeEnum.LOOKUP, OprationContentEnum.LOGIN, ui, "用户登录失败，密码错误", uuid, ui.getUserID());
				throw new AirportRuntimeException("user.err.password.notcorrect");
			}
			ui.setLoginIp(loginIp);
			ui.setLoginDevice(loginDevice);
			ui.setLoginUuid(uuid);
			logService.writeLog(OprationTypeEnum.LOOKUP, OprationContentEnum.LOGIN, ui, "用户登录成功", uuid, ui.getUserID());
			redisUtilEx.ModifyObject(ui, "UserInfo", ui.getUserID()+"");
			
			return ui;
		} else {
			throw new AirportRuntimeException("user.err.user.notexist");
		}

	}

	/**
	 * 用户注册
	 */
	public UserInfo register(UserInfo ui) throws AirportRuntimeException {
		UserInfo info = new UserInfo();
		info.setEmail(ui.getEmail());
		info = userInfoDao.queryUesrInfoByEmail(info);

		if (null != info && null != info.getUserID()) {
			logService.writeLog(OprationTypeEnum.LOOKUP, OprationContentEnum.REGITER, ui, "用户注册，验证用户,已经有包含的邮件了", ui.getUuid(), 0);
			throw new AirportRuntimeException("user.err.user.exist");
		}
		logService.writeLog(OprationTypeEnum.LOOKUP, OprationContentEnum.REGITER, ui, "用户注册，验证用户", ui.getUuid(), 0);
		ui = userInfoDao.AddUserInfo(ui);
		logService.writeLog(OprationTypeEnum.INSERT, OprationContentEnum.REGITER, ui, "用户注册成功", ui.getUuid(), ui.getUserID());
		return ui;
	}

	/**
	 * 忘记密码
	 */
	public boolean forgotPassword(String email, String uuid) throws AirportRuntimeException {

		UserInfo user = new UserInfo(email);

		user = userInfoDao.queryUesrInfoByEmail(user);

		if (null == user || null == user.getUserID()) {
			logService.writeLog(OprationTypeEnum.LOOKUP, OprationContentEnum.FORGETPASS, new UserInfo(email), "注册忘记密码，验证用户,已经有包含的邮件了", uuid, 0);
			throw new AirportRuntimeException("user.err.email.notexist");
		}

		String password = RandomUtil.generatePassword(8);

		UserInfo updateUser = new UserInfo();

		updateUser.setUserID(user.getUserID());

		try {

			updateUser.setPassword(Encryption.md5(password));

		} catch (NoSuchAlgorithmException e1) {

			throw new AirportRuntimeException("system.err.unkown", e1);

		}

		int count = userInfoDao.updateUserInfo(updateUser);

		if (count > 0) {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			try {
				helper.setFrom("noreply@palm360.com.cn");
				helper.setTo(email);
				helper.setSubject(messageSource.getMessage("mail.subject", null, Locale.CHINA));
				helper.setText(messageSource.getMessage("mail.text", new Object[] { user.getNickName(), password }, Locale.CHINA), true);
			} catch (MessagingException e) {
				throw new AirportRuntimeException("system.err.unkown", e);
			}
			mailSender.send(mail);
			logService.writeLog(OprationTypeEnum.SENDMAIL, OprationContentEnum.FORGETPASS, user, "注册忘记密码,对密码重新设置，并发送邮件成功", uuid, user.getUserID());
			return true;
		}
		return false;
	}

	public boolean deleteUser(int userID) throws AirportRuntimeException {
		logService.writeLog(OprationTypeEnum.DELETE, OprationContentEnum.REMOVEUSER, new UserInfo(userID), "删除用户", null, userID);
		return userInfoDao.deleteUserInfo(new UserInfo(userID)) > 0 ? true : false;
	}

	public boolean modifyUser(UserInfo ui) throws AirportRuntimeException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<UserInfo> queryUser(int start, int count) throws AirportRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	public int queryUserCount() throws AirportRuntimeException {
		// TODO Auto-generated method stub
		return 0;
	}

}
