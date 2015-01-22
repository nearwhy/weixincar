package com.aero.o2o.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.util.FileCopyUtils;
/**
 * 图片操作类
 * @author zhangtong
 * @author xzl
 *
 */
public class ImageUtil {
	
	/**
	 * 讲一个图片转换到另一个等比例大小的图片
	 * @param data
	 * @param width
	 * @param height
	 * @return
	 * @throws IOException
	 */
	public static byte[] scaleImage(byte[] data, int width, int height) throws IOException {  
		ByteArrayInputStream byteArrayInputStream = null;
		ByteArrayOutputStream outPutStream = null;
		byte[] byteArr = null;
		try {
			byteArrayInputStream=  new ByteArrayInputStream(data);
			BufferedImage buffered_oldImage = ImageIO.read(byteArrayInputStream);
			int imageOldWidth = buffered_oldImage.getWidth();
			int imageOldHeight = buffered_oldImage.getHeight();

			int imageNewWidth = 0;
			int imageNewHeight = 0;

			float rate = (float) imageOldWidth / (float) imageOldHeight;// 宽高比例

			if (imageOldWidth > width && imageOldHeight <= height) {
				imageNewWidth = width;
				imageNewHeight = new Float((float) imageNewWidth / rate)
						.intValue();
			} else if ((imageOldWidth <= width && imageOldHeight > height)
					|| (imageOldWidth > width && imageOldHeight > height)) {
				imageNewHeight = height;
				imageNewWidth = new Float((float) imageNewHeight * rate)
						.intValue();
			} else {
				imageNewWidth = width;
				imageNewHeight = height;
			}

			BufferedImage buffered_newImage = new BufferedImage(imageNewWidth,
					imageNewHeight, BufferedImage.TYPE_INT_RGB);
			buffered_newImage.getGraphics().drawImage(
					buffered_oldImage.getScaledInstance(imageNewWidth,
							imageNewHeight, BufferedImage.SCALE_SMOOTH), 0, 0,
					null);
			buffered_newImage.getGraphics().dispose();
			outPutStream = new ByteArrayOutputStream();
			ImageIO.write(buffered_newImage, "jpeg", outPutStream);

			byteArr = outPutStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(outPutStream != null)
				outPutStream.close();
			if(byteArrayInputStream != null)
				byteArrayInputStream.close();
		}  
	    
	    
	    return byteArr;
	}  
	

	/**
	 * 讲一个图片转换到指定大小的图片
	 * @param data
	 * @param width
	 * @param height
	 * @return
	 * @throws IOException
	 */
	public static byte[] assignImage(byte[] data, int width, int height) throws IOException {  
		ByteArrayInputStream byteArrayInputStream = null;
		ByteArrayOutputStream outPutStream = null;
		byte[] byteArr = null;
		try {
			byteArrayInputStream=  new ByteArrayInputStream(data);
			BufferedImage buffered_oldImage = ImageIO.read(byteArrayInputStream);

			int imageNewWidth = 0;
			int imageNewHeight = 0;
			imageNewWidth = width;
			imageNewHeight = height;

			BufferedImage buffered_newImage = new BufferedImage(imageNewWidth,
					imageNewHeight, BufferedImage.TYPE_INT_RGB);
			buffered_newImage.getGraphics().drawImage(
					buffered_oldImage.getScaledInstance(imageNewWidth,
							imageNewHeight, BufferedImage.SCALE_SMOOTH), 0, 0,
					null);
			buffered_newImage.getGraphics().dispose();
			outPutStream = new ByteArrayOutputStream();
			ImageIO.write(buffered_newImage, "jpeg", outPutStream);

			byteArr = outPutStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(outPutStream != null)
				outPutStream.close();
			if(byteArrayInputStream != null)
				byteArrayInputStream.close();
		}  
	    
	    
	    return byteArr;
	}  
	
	/**
	 * 将一个图片，按照比例缩放到固定大小 并保存成另外一个名称 同时保存两个图片 一个大图一个小图
	 * 
	 * @param srcData
	 * @param destFileName
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void savePic(byte[] srcData, String photoFullPath, String photoName, int width,
			int height) throws IOException {
		
		FileCopyUtils.copy(srcData, new FileOutputStream(new File(photoFullPath + photoName + ".jpg")));
		if (width != 0 && height != 0) {
			srcData = scaleImage(srcData, width*2, height*2);
			String destPhotoName = photoFullPath + photoName + "_" + width + "_" + height + ".jpg";
			FileCopyUtils.copy(srcData, new FileOutputStream(new File(destPhotoName)));
		}
	}
	/**
	 * 将一个图片，按照固定尺寸保存为logo图片
	 * 
	 * @param srcData
	 * @param destFileName
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void saveLogoPic(byte[] srcData, String photoFullPath, String photoName, int width,
			int height) throws IOException {
		String logoPhotoName = photoFullPath + photoName + "_logo.jpg";
		File file = new File(logoPhotoName);
		if(!file.exists()){
			srcData = assignImage(srcData, width, height);
			FileCopyUtils.copy(srcData, new FileOutputStream(new File(logoPhotoName)));
		}
	}
	/**
	 * 从指定路径和文件名读取一个图片
	 * 
	 * @param path
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	public static byte[] loadPic(String path) throws IOException {
		InputStream fin = null;
		byte[] buf = null;
		try {
			File file = new File(path);
			
			fin = new FileInputStream(file);
			buf = new byte[fin.available()];
			
			fin.read(buf);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fin != null){
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return buf;
		}
	}
	
	
	public static void main(String[] args){
		InputStream fin = null;
		try {
			File file = new File("E:\\big\\1377259910.jpg");
			
			fin = new FileInputStream(file);
			byte[] buf = new byte[fin.available()];
			
			fin.read(buf);
			buf = assignImage(buf, 200, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fin != null){
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
