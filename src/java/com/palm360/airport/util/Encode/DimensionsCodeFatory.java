package com.palm360.airport.util.Encode;
/**
 * 生成二维码工厂，目前只支持QRCode
 * @author zhangtong
 *
 */
public class DimensionsCodeFatory {
	private static EncodeEnum encode = EncodeEnum.NONE;
	private static EncodeFormat encodeFormat = null;
	public static void main(String[] args){
		DimensionsCodeFatory.getInstance().makeCode("C:\\fdf.png", "你好，中文");
	}
	public static EncodeFormat getInstance(){
		return DimensionsCodeFatory.getInstance(EncodeEnum.QRCODE);
	}
	public static EncodeFormat getInstance(EncodeEnum encode){
		if(!DimensionsCodeFatory.encode.equals(encode)){
			encodeFormat = null;
		}
		if(EncodeEnum.NONE.equals(encode))
			return null;
		if(EncodeEnum.QRCODE.equals(encode)){
			if(encodeFormat == null){
				encodeFormat = new QRCodeEncodeFormat();				
			}
			return encodeFormat;
		}
		return null;
	}
}
