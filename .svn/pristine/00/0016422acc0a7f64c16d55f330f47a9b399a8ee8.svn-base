package com.palm360.airport.model;

import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import com.palm360.airport.util.AirPortUtil;
import com.palm360.airport.util.stereotype.NoCache;

public class BaseModel {
	public static final String SPLIT="_";
	public String toString(){
		StringBuffer sb = new StringBuffer();
		List<String> list = AirPortUtil.getClassFieldName(this.getClass());
		for(String str:list){
			if(AirPortUtil.isStereotype(this.getClass(),str,NoCache.class)) 
				continue;
			Object o = AirPortUtil.getProperty(this, str);
			if(o != null){
				sb.append(str);
				sb.append(":");
				sb.append(o);
				sb.append(SPLIT);
			}
		}
		if (sb.length() > 0) {
			sb = new StringBuffer(sb.substring(0, sb.length()-1));
		}
		return sb.toString();
	}
	/**
	 * 获得短拼音
	 * ：aaa我知道了bbb<br/>
	 * <p>aaawzdlbbb
	 */
	public String getShortPinyin(String str){
		HanyuPinyinOutputFormat output = new HanyuPinyinOutputFormat();
    	output.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    	output.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    	output.setVCharType(HanyuPinyinVCharType.WITH_V);  
    	char[] cs = str.toCharArray();
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<cs.length;i++){
    		try {
    			if(cs[i]>0 && cs[i]<255){
    				sb.append(cs[i]);
    				continue;
    			}
    			String[] pinyinArray =	PinyinHelper.toHanyuPinyinStringArray(cs[i],output);
    			if(pinyinArray!=null){
    				sb.append(pinyinArray[0].charAt(0));
    			}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				
			}
    	}
    	return sb.toString();
	}
	/**
	 * 获得长拼音
	 * <p>aaa我知道了bbb</p>
	 * <p>aaawozhidaolebbb</p>
	 * @param str
	 * @return
	 */
	public String getPinyin(String str){
		HanyuPinyinOutputFormat output = new HanyuPinyinOutputFormat();
    	output.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    	try {
			return PinyinHelper.toHanyuPinyinString(str,output," ");
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			return "";
		}
	}
}
