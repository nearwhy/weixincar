package com.palm360.airport.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 图片操作类
 * @author zhangtong
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
	    BufferedImage buffered_oldImage = ImageIO.read(new ByteArrayInputStream(data));  
	    int imageOldWidth = buffered_oldImage.getWidth();  
	    int imageOldHeight = buffered_oldImage.getHeight();  
	    double scale_x = (double) width / imageOldWidth;   
	    double scale_y = (double) height / imageOldHeight;  
	    double scale_xy = Math.min(scale_x, scale_y);
	    int imageNewWidth = (int) (imageOldWidth * scale_xy);  
	    int imageNewHeight = (int) (imageOldHeight * scale_xy);  
	    BufferedImage buffered_newImage = new BufferedImage(imageNewWidth, imageNewHeight, BufferedImage.TYPE_INT_RGB);  
	    buffered_newImage.getGraphics().drawImage(buffered_oldImage.getScaledInstance(imageNewWidth, imageNewHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);  
	    buffered_newImage.getGraphics().dispose();  
	    ByteArrayOutputStream outPutStream = new ByteArrayOutputStream();  
	    ImageIO.write(buffered_newImage, "jpeg", outPutStream);  
	    return outPutStream.toByteArray();  
	}  
}
