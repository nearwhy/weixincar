package com.palm360.airport.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.model.Usercomment;
import com.palm360.airport.service.UserCommentService;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.AirportResult;
import com.palm360.airport.util.exception.AirportRuntimeException;

/**
 * 用户留言.controller
 * 
 * @author xzl
 * 
 */
@Controller("userCommentController")
public class UserCommentController extends BaseController {

	@Autowired
	private UserCommentService userCommentService;

	/**
	 * 添加留言回复
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save_comment_{type}_{typeId}", method = RequestMethod.POST)
	public ModelAndView saveComment(HttpServletRequest request, @PathVariable String type, @PathVariable Integer typeId) {

		if (null == typeId) {
			throw new AirportRuntimeException("user.err.comment.type.id.isrequired");
		}

		if (StringUtils.isBlank(type)) {
			throw new AirportRuntimeException("user.err.comment.type.isrequired");
		}

		String commentStr = request.getParameter("comment");

		if (StringUtils.isBlank(commentStr)) {
			throw new AirportRuntimeException("user.err.comment.isrequired");
		}

		String uuid = request.getParameter("uuid");

		if (StringUtils.isBlank(uuid)) {
			throw new AirportRuntimeException("system.err.unkown");
		}

		UserInfo ui = (UserInfo) request.getSession().getAttribute(SESSION_KEY_USERINFO);
		if (null == ui) {
			throw new AirportRuntimeException("system.err.user.session");
		}

		Usercomment comment = new Usercomment();
		comment.setComment(commentStr);
		if (StringUtils.containsOnly(type, "commodity")) {
			comment.setCommodityid(typeId);
		} else if (StringUtils.containsOnly(type, "merchant")) {
			comment.setMerchantid(typeId);
		} else {
			throw new AirportRuntimeException("system.err.unkown");
		}
		comment.setUserid(ui.getUserID());
		comment.setUuid(uuid);
		Usercomment uc = userCommentService.addUserComment(comment);

		AirportResult ar = new AirportResult();
		ar.setRsObject(uc);
		return new ModelAndView("", MODEL_NAME_RESULT, ar);
	}

	/**
	 * 查询留言回复，可分页
	 * 
	 * @param request
	 * @param type
	 * @param typeId
	 * @return
	 */
	@RequestMapping(value = "/query_comment_{type}_{typeId}_{page}_{size}", method = RequestMethod.GET)
	public ModelAndView queryComment(HttpServletRequest request, @PathVariable String type, @PathVariable Integer typeId, @PathVariable Integer page, @PathVariable Integer size) {

		if (null == typeId) {
			throw new AirportRuntimeException("user.err.comment.type.id.isrequired");
		}

		if (StringUtils.isBlank(type)) {
			throw new AirportRuntimeException("user.err.comment.type.isrequired");
		}

		if (null == page || page < 1) {
			page = 1;
		}

		if (null == size || size < 1) {
			size = 10;
		}

		Usercomment param = new Usercomment();
		if (StringUtils.containsOnly(type, "commodity")) {// 对商品查询
			param.setCommodityid(typeId);
		} else if (StringUtils.containsOnly(type, "merchant")) {// 对商户查询
			param.setMerchantid(typeId);
		} else {
			throw new AirportRuntimeException("system.err.unkown");
		}
		param.setUpdatetime(null);
		param.setFlag(null);
		AirportQueryP qp = new AirportQueryP();
		qp.setValue(new Object[] { "*" });
		qp.setSize(size);// 一页多少个，size在前page在后
		qp.setPage(page);// 页数
		qp.setParams(param);// 查询参数
		qp.setOrderBy("UpdateTime");// 根据时间排序
		qp.setAsc(false);// 倒序
		List<Usercomment> ucs = userCommentService.queryUserComments(qp);

		AirportResult ar = new AirportResult();
		ar.setRsObject(ucs);
		return new ModelAndView("", MODEL_NAME_RESULT, ar);
	}

	/**
	 * 获取回复
	 * 
	 * @param request
	 * @param commentId
	 * @return
	 */
	@RequestMapping(value = "/get_comment_{commentId}", method = RequestMethod.GET)
	public ModelAndView getComment(HttpServletRequest request, @PathVariable Integer commentId) {

		if (null == commentId) {
			throw new AirportRuntimeException("user.err.comment.id.isrequired");
		}

		Usercomment comment = new Usercomment();
		comment.setCommentid(commentId);
		comment = userCommentService.getUserComment(comment);

		if (null == comment) {
			throw new AirportRuntimeException("user.err.comment.notexist");
		}

		AirportResult ar = new AirportResult();
		ar.setRsObject(comment);
		return new ModelAndView("", MODEL_NAME_RESULT, ar);
	}
}
