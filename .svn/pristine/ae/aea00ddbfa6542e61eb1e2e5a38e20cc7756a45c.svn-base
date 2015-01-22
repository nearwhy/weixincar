package com.palm360.airport.util.Encode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.palm360.airport.util.AirPortUtil;


/**
 * 生成qrcode实现类
 * 
 * @author zhangtong
 * 
 */
public class QRCodeEncodeFormat implements EncodeFormat {

	/**
	 * 生成二维码(QRCode)图片
	 * 
	 * @param content
	 * @param path
	 *            C:\\
	 */
	public String makeCode(String path, String content) {
		// 编码

		try {
			path = path+AirPortUtil.randomStringEx(20)+".png";
			BitMatrix byteMatrix;
			Hashtable hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			byteMatrix = new MultiFormatWriter().encode(content,
					BarcodeFormat.QR_CODE, 140, 140, hints);
			File file = new File(path);
			MatrixToImageWriter.writeToFile(byteMatrix, "png", file);
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		// String imgPath = path +AirPortUtil.randomStringEx(20)+".png";
		// try {
		// //TODO need to make path
		// Qrcode qrcodeHandler = new Qrcode();
		// qrcodeHandler.setQrcodeErrorCorrect('M');
		// qrcodeHandler.setQrcodeEncodeMode('B');
		// qrcodeHandler.setQrcodeVersion(7);
		// System.out.println(content);
		// byte[] contentBytes = content.getBytes("utf-8");
		// BufferedImage bufImg = new BufferedImage(140, 140,
		// BufferedImage.TYPE_INT_RGB);
		//	 
		// Graphics2D gs = bufImg.createGraphics();
		//	 
		// gs.setBackground(Color.WHITE);
		// gs.clearRect(0, 0, 140, 140);
		//	 
		// // 设定图像颜色> BLACK
		// gs.setColor(Color.BLACK);
		// // 设置偏移量 不设置可能导致解析出错
		// int pixoff = 2;
		// // 输出内容> 二维码
		// if (contentBytes.length > 0 && contentBytes.length < 120) {
		// boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
		// for (int i = 0; i < codeOut.length; i++) {
		// for (int j = 0; j < codeOut.length; j++) {
		// if (codeOut[j][i]) {
		// gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
		// }
		// }
		// }
		// } else {
		// System.err.println("QRCode content bytes length = "
		// + contentBytes.length + " not in [ 0,120 ]. ");
		// }
		//	 
		// gs.dispose();
		// bufImg.flush();
		//	 
		// File imgFile = new File(imgPath);
		//	 
		// // 生成二维码QRCode图片
		// ImageIO.write(bufImg, "png", imgFile);
		//	 
		// } catch (Exception e) {
		// e.printStackTrace();
		// return null;
		// }
		//	 
		// return imgPath;
	}
}
