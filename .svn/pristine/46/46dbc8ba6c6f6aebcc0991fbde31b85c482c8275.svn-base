package com.palm360.airport.pushservice;

import java.util.List;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

/**
 * 推送消息服务
 * @author zhangtong
 *
 */
public class PushServer {
	
	public static void SendMessageForAndroid(String message){
		//TODO mqtt是php的服务器不容易整合
		//androidpn是java的但是服务器冗余严重,第二和目前系统内部整合,还没有好办法
		//是否采用自定义推送,建立socket 长连接方式.
		//但是如果是长连接方式的话,需要占用server大量资源,大约1万人以上的话,服务器基本属于半瘫痪状态
		//也许可以采用pull方式来的,虽然比较费电.
	}
	public static void SendMessageForIOS(List<String> uuid,String message){
		for(String uid:uuid){
			SendMessageForIOS(uid,message);
		}
	}
	/**
	 * 为IOS系统推送消息
	 * @param uuid
	 * @param message
	 */
	public static void SendMessageForIOS(String uuid,String message) {
		try {
			
			  String deviceToken = uuid;//"e775b5892f3334427c14def8aa4d8189a4ec1c795020072f4baa7ee92e50b1db";;//iphone手机获取的token

			  PayLoad payLoad = new PayLoad();
			  payLoad.addAlert(message);//"我的push测试");////push的内容
			  payLoad.addBadge(1);//图标小红圈的数值
			  payLoad.addSound("default");//铃音
						
			  PushNotificationManager pushManager = PushNotificationManager.getInstance();
			  pushManager.addDevice("iPhone", deviceToken);
						
			  //Connect to APNs
			   /************************************************
              		测试的服务器地址：gateway.sandbox.push.apple.com /端口2195 
  					产品推送服务器地址：gateway.push.apple.com / 2195 
			    ***************************************************/
			  String host= "gateway.sandbox.push.apple.com";
			  int port = 2195;
			  String certificatePath= "/Users/jcjc/Desktop/push_p.p12";//导出的证书
			  String certificatePassword= "sunlg";//此处注意导出的证书密码不能为空因为空密码会报错
			  pushManager.initializeConnection(host,port, certificatePath,certificatePassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
						
			  //Send Push
			  Device client = pushManager.getDevice("iPhone");
			  pushManager.sendNotification(client, payLoad);
			  pushManager.stopConnection();

			  pushManager.removeDevice("iPhone");
			 }
			 catch (Exception e) {
			  e.printStackTrace();
			 }

	}

}
