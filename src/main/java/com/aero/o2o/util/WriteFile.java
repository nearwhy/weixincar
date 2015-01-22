package com.aero.o2o.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public static void writeFile(String fileName,String str){
	    try
	    {
	    	/**
	    	 * FileWriter中的2个参数分别表示  fileName文件名  true表示追加 加上此属性值不会被覆盖
	    	 */
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
	        out.write(str);
	        out.newLine();
	        //out.write("ttttt"); 
	        out.close();
	    } 
	    catch (IOException e) {
	    }
	}
	public static void main(String[] args)
	{
		writeFile("C:/test/text2.txt","qqqqq====5=");

	}
}
