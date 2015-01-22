package com.aero.o2o;

/**
 * 常量
 * @author xzl
 *
 */
public final class AirportConstant {

	public static final String SESSION_KEY_USERINFO = "userInfo";
	
	public static final String MODEL_NAME_RESULT = "result";
	
	public static final String SUCCESS_BOX = "redirect:/admin/success_box.html";
	
	public static final String VERIFICATION_CODE_PASS = "airport";
	
	public static final String SESSION_KEY_BASELOG = "baseLog";
	
	public static final String SESSION_KEY_URL = "url";
	
	public static final String[] COMMODITY_EXCEL_TITLE = new String[]{"商品名称 ","商品分类","原价","现价","是否显示价格","商品图片","简介","唯一标识"}; 
	public static final String[] MERCHANT_EXCEL_TITLE = new String[]{"商户简称","商户名称 ","商户分类","商户子分类","所属航站楼","楼层","营业时间","商户经度","商户纬度","隔离区","公共设施","是否免税店","电话","地址","简介","商户图片","唯一标识","地图显示级别"}; 
	
	public static final String COUNT_DATABASE_NAME = "Analysis";
	
	public static final String REDIS_PUSH_UUID = "push_uuid";
	
	public static final String PUSH_MESSAGE = "push_message";
	
	public static final String REDIS_PUSHED_FLIGHTNO = "pushed_flightno";
	
	public static final String REDIS_SEARCHKEY_PREFIX = "searchkey";

	public static final String REDIS_SDK_APP = "sdk_app";

	public static final String REDIS_AIRPORT_THREECODE = "airport_threecode";

	public static final String REDIS_HOT_THREECODE = "airport_hot_threecode";
	
	public static final String REDIS_TASKORDER_COLLECTION = "H_task_orders";
	
	public static final Integer RECOMMENT_MERCHANT_SIZE = 50;
	
	//出行计划消息
	public static final String TRAVEL_PLANS_MESSAGE ="tp_message";
	//加密原文
	public static final String AIRPORT_COOKIE_PASSW ="b832451a-a0ca-11e2-9b17-50e549a83629";
	//第三方登陆类型QQ
	public static final int AIRPORT_THIRD_QQ = 1;
	//第三方登陆类型WEIBO
	public static final int AIRPORT_THIRD_WEIBO = 2;
	//第三方登陆类型RENREN
	public static final int AIRPORT_THIRD_RENREN = 3;
	
	//性别未知
	public static final int AIRPORT_GENDER_UNKNOWN = 0;
	//性别男
	public static final int AIRPORT_GENDER_MAN = 1;
	//性别女
	public static final int AIRPORT_GENDER_WOMAN = 2;
	//
	public static final String AIRPORT_ATTENTION = "ATTENTION_";
	
	public static String POITYPE_SORT = "451,452,455,454,453,456,458,457,459,461,460";
	
	public static final String NaviSHP = "NaviSHP.zip";
	public static final String MapFile = "map.data"; 
	public static final String SMapFile = "s_map.data"; 
	public static final String SpecialPointData = "SpecialPointData.json"; 
	public static final String GalleryData = "GalleryData.json"; 
	public static final String PoiJson = "poi.json";  
	public static final String AirportJson = "airport.json";  
	public static final String ManifestJson = "manifest.json";  
	public static final String PublicManifestJson = "public_manifest.json";  
	public static final String SdkLogFileName = "sdk_log.log.";  
}
