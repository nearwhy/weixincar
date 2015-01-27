package com.aero.o2o.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 读取 Excel公共类
 * @author tz
 * @since 2012-09-06
 */
public class Excel2JSON {
	private static int SHEET_INDEX =0;
	private static int MAX_COLUMN_NUM =0;
	private Workbook wb = null;
	private String[] header = null;
	private int[]  valClos = null;
	private int[]  castClos = null;
	/*
	 * null constructor
	 */
	public Excel2JSON(){
		
	}
	
	/**
	 * 
	 * @param file
	 * @param maxColumn excel最大列数
	 * @param header excel标题
	 * @paramvalClos 需要验证不能为空的列
	 * @param castClos 需要验证不能转换为数值的列 
	 * @throws Exception 
	 */
	public Excel2JSON(File file, int maxColumn) throws Exception{
		
		InputStream in = null;
		try {
			if (file == null)
				throw new Exception("请选择要上传的文件");
			String fileName = file.getName();
			String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
			try {
				in = new FileInputStream(file);
			} catch (IOException e1) {
				throw new Exception("读取文件是出错");
			}

			if (maxColumn < 0)
				throw new Exception("最大行数不能小于0");
			else {
				Excel2JSON.MAX_COLUMN_NUM = maxColumn;
				this.header = header;
				this.valClos = valClos;
				this.castClos = castClos;
			}
			if ("xls".equals(extension)) {
				try {
					this.wb = new HSSFWorkbook(in);
				} catch (Exception e) {
				}
			} else if ("xlsx".equals(extension)) {
				try {
					this.wb = new XSSFWorkbook(in);
				} catch (Exception e) {
					throw new Exception("不支持的文件类型");
				}
			} else {
				
				throw new Exception("不支持的文件类型");
			}

		} catch (Exception e) {
			throw e;
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}
	} 
	
	  /**
	   * 取Excel所有数据，包含header
	   * @return  List<String[]>
	   * @param sheetIndex sheet位置
	   * @param row 前几行忽略
	 * @throws Exception 
	   */
	public List<Object[]> getAllData(int no) throws Exception {
		List<Object[]> dataList =null;
		try {
			dataList = new ArrayList<Object[]>();
			Sheet sheet = this.wb.getSheetAt(Excel2JSON.SHEET_INDEX);

			// 循环sheet下的所有行
			for (Row row : sheet) {
				// 前两行数据位标题忽略
				if (row.getRowNum() < no)
					continue;

				Object[] singleRow = new Object[Excel2JSON.MAX_COLUMN_NUM];
				int n = 0;

				// 循环某行下的所有列
				for (int i = 0; i < Excel2JSON.MAX_COLUMN_NUM; i++) {
					Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BLANK:// 处理空格
						singleRow[n] = "";
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						singleRow[n] = cell.getBooleanCellValue();
						break;
					// 数值
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							singleRow[n] = cell.getDateCellValue();
						} else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp = cell.getStringCellValue();
							// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
							if (temp.indexOf(".") > -1) {
								singleRow[n] = new Double(temp);
							} else {
								singleRow[n] = new Integer(temp);
							}
						}
						break;
					case Cell.CELL_TYPE_STRING:
						singleRow[n] =  cell.getStringCellValue().trim();
						break;
					case Cell.CELL_TYPE_ERROR:
						singleRow[n] = "";
						break;
					default:
						singleRow[n] = "";
						break;
					}
					n++;
				}

				if ("".equals(singleRow[0])) {
					continue;
				}// 如果第一行为空，跳过
				System.out.println("singleRow:"+singleRow[0]+singleRow[1]);
				// 验证
//				this._validateExcel(row.getRowNum() + 1, singleRow, valClos, castClos);

				dataList.add(singleRow);
			}
			
			if(dataList.size() < 1 )
				throw new Exception("请先填写数据再上传！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return dataList;
	}  
	 
	 /**
	  * 
	  * @param str 读入excel时，某行数据
	  * @param valClos 需要验证不能为空的列
	  * @param castClos 需要验证不能转换为数值的列 
	  */
	 private void _validateExcel(int rowNum, String[] str, int[] valClos, int[] castClos) throws Exception{
		 if(str ==null || str.length < 1) return;
		 
		 //忽略空行
		 int count = 0;
		 for(String s : str){
			 if("".equals(s))
				 count++;
		 }
		 if( count == str.length)
			 return;
		 
		 //验证不为空
		 if(valClos != null && valClos.length > 0){
			 for(int i = 0 ; i < valClos.length ; i++){
				 int col = valClos[i];
				 if(str[col].equals("")){
					 throw new Exception();
				 }
			 } 
		 }
		 
		 //验证书写错误，不能转换为数值
		 if(castClos != null && valClos.length > 0){
			 for(int j = 0 ; j < castClos.length ; j++){
				 int col =0;//列号 0~N
				try{
					col = castClos[j]; //
					Double.parseDouble(str[col]);
				}catch(Exception e){
					 throw new Exception("第"+rowNum+"行,"+header[col]+"："+str[col]+",格式有误");
				}
			 }
		 }
	 }
	 
	 
	 public static void main(String args[]) throws Exception{
		 File file = new File("/Users/caidi/Documents/work/weixincar/test.xlsx");
		 Excel2JSON excel = new Excel2JSON(file, 8);
		 
		 List<Object[]> list= excel.getAllData(2);
		 List<JSONObject> jsonList = new ArrayList<JSONObject>();
		 for(int i=1;i<list.size();i++){
			 JSONObject json = new JSONObject();
			 for(int j=1;j<list.get(0).length;j++){
				 json.put(list.get(0)[j], list.get(i)[j]);
			 }
			 jsonList.add(json);
		 }
	 }
	 
	 public static void run(String airport,String fName,String fname2,int colum)throws Exception{

		 File file = new File("E:\\3.0\\机场通道和通道口数据zz\\"+airport+"\\"+fName+".xlsx");
		 Excel2JSON excel = new Excel2JSON(file, colum);
		 
		 List<Object[]> list= excel.getAllData(2);
		 List<JSONObject> jsonList = new ArrayList<JSONObject>();
		 for(int i=1;i<list.size();i++){
			 JSONObject json = new JSONObject();
			 for(int j=1;j<list.get(0).length;j++){
				 json.put(list.get(0)[j], list.get(i)[j]);
			 }
			 jsonList.add(json);
		 }
	 }
	 
	 public static Excel2JSON pic() throws Exception{
		 File file = new File("D:\\work\\AirPort\\airportback\\数据\\nopic@ali.xlsx");
		 Excel2JSON excel = new Excel2JSON(file, 2);
		 return excel;
		 
	 }
}
