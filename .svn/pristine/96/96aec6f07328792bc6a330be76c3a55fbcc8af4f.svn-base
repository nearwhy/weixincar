package com.aero.o2o.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
public class XmlUtils {
 
	private static Logger log = Logger.getLogger(XmlUtils.class);

	 
 /***
  * 
  * @param in InputStream
  * @return
  * @throws ParserConfigurationException
  * @throws SAXException
  * @throws IOException
  */
	public static Map readStringXmlOutomapByList(InputStream in) throws ParserConfigurationException, SAXException, IOException{
		Map map = new HashMap();
		//Document document = null;
		try {
			 // 读取并解析XML文档
			 //SAXReader就是一个管道，用一个流的方式，把xml文件读出来
			SAXReader reader = new SAXReader(); 
			 // xml表示你要解析的xml文档
			Document document = reader.read(in);
			Element rootElt = document.getRootElement(); // 获取根节点
            Iterator iter = rootElt.elementIterator(); // 获取根节点下的子节点
            //循环第一级子节点
            while (iter.hasNext()) {
				Element itemEle = (Element) iter.next();
				///循环第二级子节点
				Iterator<?> iter1 =itemEle.elementIterator();
				while (iter1.hasNext()){
					Element secnd =(Element)iter1.next();
					Iterator<?> iter2 =secnd.elementIterator();
					////循环第三级子节点 
					while(iter2.hasNext()){
						Element newEl =(Element)iter2.next();
						///节点值
						map.put(newEl.getName(), newEl.getData().toString());
					 }
					////取得节点值 
					map.put(secnd.getName(), secnd.getData().toString());
				}
				 
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		
		
		return map;
	}
	/*** 
	  * 
	  * @param xml xml字符串 
	  * @param s   节点名称 
	  * @return
	  * @throws ParserConfigurationException
	  * @throws SAXException
	  * @throws IOException
	  */
	public static Map readStringXmlOutomapByString(String xml) throws ParserConfigurationException, SAXException, IOException{
		Map<String, String> map = new HashMap<String, String>();
		 Document document = null;
		try {
		   document = DocumentHelper.parseText(xml); // 将字符串转为XML
		   Element rootElt = document.getRootElement(); // 获取根节点
           Iterator<?> iter = rootElt.elementIterator(); // 获取根节点下的子节点
           while (iter.hasNext()) {
					Element itemEle = (Element) iter.next();
					
					map.put(itemEle.getName(), itemEle.getData().toString());
					Iterator<?> iter1 =itemEle.elementIterator();
					while (iter1.hasNext()){
						Element dd =(Element)iter1.next();
						Iterator<?> iter2 =dd.elementIterator();
						while(iter2.hasNext()){
							Element newEl =(Element)iter2.next();
							map.put(newEl.getName(), newEl.getData().toString());
						 }
						map.put(dd.getName(), dd.getData().toString());
					} 
				}
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		
		
		return map;
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

//		// 下面是需要解析的xml字符串例子
//		String xmlString = "<html>" + "<head>" + "<title>dom4j解析一个例子</title>"
//				+ "<script>" + "<username>yangrong</username>"
//				+ "<password>123456</password>" + "</script>" + "</head>"
//				+ "<body>" + "<result>0</result>" + "<form>"
//				+ "<banlce>1000</banlce>" + "<subID>36242519880716</subID>"
//				+ "</form>" + "</body>" + "</html>";
//				
		 String dfd = "d:\\c.xml";
		
		// Map mp = readStringXmlOutomapByList(dfd);
	
		 String ds = readFileByLines(dfd);
		 System.out.println(ds);
		  Map mp = readStringXmlOutomapByString(ds);
		  System.out.println(mp);
		 
		 
	}
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer document = new StringBuffer();  
        try {
            reader = new BufferedReader(new FileReader(file));
          
            String line = null;  
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null) {
                   document.append(line.toString().trim());  
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return document.toString();
    }
}
