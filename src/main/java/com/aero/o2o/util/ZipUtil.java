package com.aero.o2o.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/**
 * zip操作工具类
 * @author zhangtong
 *
 */
public class ZipUtil {
	public static void main(String[] agrg) {
		List<String> list = new ArrayList<String>();
		list.add("C:\\RHDSetup.log");
		list.add("C:\\2-01.png");
		ZipUtil.compress(list, "C:\\Tomcat\\test.zip", "hehe");
	}

	/**
	 * 创建和压缩文件zip
	 * 
	 * @param fileList
	 *            要压缩的文件列表
	 * @param outputPath
	 *            要生成压缩包的文件名和文件路径
	 * @param comment
	 *            压缩包注视
	 * @return
	 */
	public static boolean compress(List<String> fileList, String outputPath,
			String comment) {
		try {
			// ZipCompress zip=new ZipCompress();
			byte b[] = new byte[512];
			FileOutputStream fileOut = new FileOutputStream(outputPath);// "Example.zip");
			CheckedOutputStream checkOut = new CheckedOutputStream(fileOut,
					new CRC32());
			ZipOutputStream zipOut = new ZipOutputStream(
					new BufferedOutputStream(checkOut));
			zipOut.setComment(comment);

			for (int i = 0; i < fileList.size(); i++) {
				InputStream in = new FileInputStream((String) fileList.get(i));
				String fileName = ((String) (fileList.get(i))).replace(
						File.separatorChar, '/');
				System.out.println("ziping " + fileName);
				fileName = fileName.substring(fileName.indexOf("/") + 1);
				ZipEntry e = new ZipEntry(fileName);
				zipOut.putNextEntry(e);
				int len = 0;
				while ((len = in.read(b)) != -1) {
					zipOut.write(b, 0, len);
				}
				zipOut.closeEntry();
			}
			zipOut.close();
			System.out.println("done!");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 解压缩文件
	 * @param zipfile 要解压的文件名
	 * @param outputDir 解压路径
	 * @return 正确返回true
	 */
	public static boolean unZip(String zipfile, String outputDir) {
		try {
			String outputDirectory = outputDir;
			ZipFile zipFile = new ZipFile(zipfile);
			Enumeration e = zipFile.entries();
			ZipEntry zipEntry = null;
			createDirectory(outputDirectory, "");
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				System.out.println("unziping " + zipEntry.getName());
				if (zipEntry.isDirectory()) {
					String name = zipEntry.getName();
					name = name.substring(0, name.length() - 1);
					File f = new File(outputDirectory + File.separator + name);
					f.mkdir();
				} else {
					String fileName = zipEntry.getName();
					// fileName = fileName.replaceAll("\", "/");
					if (fileName.indexOf("/") != -1) {
						createDirectory(outputDirectory, fileName.substring(0,
								fileName.lastIndexOf("/")));
					}

					File f = new File(outputDirectory + zipEntry.getName());

					f.createNewFile();
					InputStream in = zipFile.getInputStream(zipEntry);
					FileOutputStream out = new FileOutputStream(f);
					byte[] by = new byte[1024];
					int c;
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					out.close();
					in.close();
				}
			}
			System.out.println("done!");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 创建目录
	 * @param directory
	 * @param subDirectory
	 */
	private static void createDirectory(String directory, String subDirectory) {
		String dir[];
		File fl = new File(directory);
		try {
			if (subDirectory == "" && fl.exists() != true)
				fl.mkdir();
			else if (subDirectory != "") {
				dir = subDirectory.split("/");
				for (int i = 0; i < dir.length; i++) {
					File subFile = new File(directory + File.separator + dir[i]);
					if (subFile.exists() == false)
						subFile.mkdir();
					directory += File.separator + dir[i];
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
