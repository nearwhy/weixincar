package com.palm360.airport.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.persistence.Column;

import com.palm360.airport.dao.UserInfoDao;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.exception.AirportRuntimeException;
import com.palm360.airport.util.stereotype.DBIndexKey;
import com.palm360.airport.util.stereotype.EntityKeyName;
import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.ForeignKeyClass;
import com.palm360.airport.util.stereotype.ForeignKeyObject;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 系统工具类
 * 
 * @author zhangtong
 * @version 1.0
 * 
 */
public class AirPortUtil {
	
	
	public static String getColumName(Class<? extends Object> c,String filed) {
		try {
			Field f = c.getDeclaredField(filed);
			
			if(f.isAnnotationPresent(Column.class)){
				Column col = f.getAnnotation(Column.class);
				return col.name();
				
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到类所有属性的名字
	 * 
	 * @param c
	 * @return
	 */
	public static List<String> getClassFieldName(Class<? extends Object> c) {
		Field[] fields = c.getDeclaredFields();
		List<String> list = new ArrayList<String>();
		for (int i = 0, len = fields.length; i < len; i++) {
			list.add(fields[i].getName());
		}
		return list;
	}

	private static List<File> getClassPath() {
		List<File> ret = new ArrayList<File>();
		// String delim = ":";
		// if (System.getProperty("os.name").toLowerCase().indexOf("windows") !=
		// -1)
		// delim = ";";
		// for (String pro : CLASS_PATH_PROP) {
		// String[] pathes = System.getProperty(pro).split(delim);
		// for (String path : pathes){
		// System.out.println(path);
		// ret.add(new File(path));
		// }
		// }
		return ret;
	}

	private static String[] CLASS_PATH_PROP = { "java.class.path",
			"java.ext.dirs", "sun.boot.class.path", "java.library.path" };
	private static List<File> CLASS_PATH_ARRAY = getClassPath();

	public static List<String> getClassInPackage(String pkgName,
			List<File> sysPath) {
		List<String> ret = new ArrayList<String>();
		String rPath = pkgName.replace('.', '/') + "/";
		if (sysPath != null)
			CLASS_PATH_ARRAY.addAll(sysPath);
		try {
			// List<File> lf = getClassPath();
			for (File classPath : CLASS_PATH_ARRAY) {
				if (!classPath.exists())
					continue;
				if (classPath.isDirectory()) {
					File dir = new File(classPath, rPath);
					if (!dir.exists())
						continue;
					for (File file : dir.listFiles()) {
						if (file.isFile()) {
							String clsName = file.getName();
							clsName = pkgName
									+ "."
									+ clsName
											.substring(0, clsName.length() - 6);
							ret.add(clsName);
						}
					}
				} else {
					FileInputStream fis = new FileInputStream(classPath);
					JarInputStream jis = new JarInputStream(fis, false);
					JarEntry e = null;
					while ((e = jis.getNextJarEntry()) != null) {
						String eName = e.getName();
						if (eName.startsWith(rPath) && !eName.endsWith("/")) {
							ret.add(eName.replace('/', '.').substring(0,
									eName.length() - 6));
						}
						jis.closeEntry();
					}
					jis.close();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return ret;
	}

	/**
	 * 获得指定类的Key值
	 * 
	 * @param c
	 * @return
	 */
	public static String getClassEntityKey(Class<? extends Object> c) {
		if (c.isAnnotationPresent(EntityKeyName.class)) {
			EntityKeyName tkn = c.getAnnotation(EntityKeyName.class);
			return tkn.keyName();
		}
		return null;
	}

	/**
	 * 得到类中所有需要cache的属性名称
	 * 
	 * @param c
	 * @return
	 */
	public static List<String> getCachedClassFieldName(Class<? extends Object> c) {
		Field[] fields = c.getDeclaredFields();
		List<String> list = new ArrayList<String>();
		for (int i = 0, len = fields.length; i < len; i++) {
			if (!fields[i].isAnnotationPresent(NoCache.class)) {
				list.add(fields[i].getName());
			}
		}
		return list;
	}
	/**
	 * 某一个属性是否含有某注解
	 * @param c
	 * @param f
	 * @param d
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public static boolean isStereotype(Class<? extends Object> c,String f,Class<? extends Annotation> d) {
		try{
		if(c.getDeclaredField(f).isAnnotationPresent((Class<? extends Annotation>) d))return true;
		}catch(Exception e){throw new AirportRuntimeException("system.err.system", e);}
		return false;
	}
	/**
	 * 获得某个对象,某个属性的内容
	 * 
	 * @param owner
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static Object getProperty(Object owner, String fieldName) {
		try {
			
			Class<? extends Object> ownerClass = Class.forName(owner.getClass()
					.getName());
			//如果是多重属性 需要拆分一下
			if(fieldName.indexOf(".")!=-1){
				String ff = fieldName.substring(0,fieldName.indexOf("."));
				Object oc = getProperty(owner,ff);
				return getProperty(oc,fieldName.substring(fieldName.indexOf(".")+1,fieldName.length()));
			}
			Field field = ownerClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object property = null;
			if ("java.sql.Timestamp".equals(field.getType().getName())) {
				Timestamp ts = (Timestamp) field.get(owner);
				if (ts != null) {
					property = ts.getTime();
				}
			} else {
				property = field.get(owner);
			}

			field.setAccessible(false);
			return property;
		} catch (Exception e) {
			System.out.println(owner);
			throw new AirportRuntimeException("system.err.system", e);
		}
	}

	/**
	 * 判断是是数字类型
	 * 
	 * @param name
	 *            java.langInteger or int or double or float or
	 *            java.lang.Double...
	 * @return
	 */
	public static boolean isNumber(String name) {
		boolean isNumber = false;
		if ("int".equals(name) || "java.lang.Integer".equals(name)
				|| "double".equals(name) || "float".equals(name)
				|| "java.lang.Double".equals(name)
				|| "java.lang.Float".equals(name))
			isNumber = true;
		return isNumber;
	}

	/**
	 * 设置某一对象,某一个属性的值
	 * 
	 * @param owner
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 */
	public static void setProperty(Object owner, String fieldName, Object value)
			throws Exception {
		if (value == null) {
			return;
		}
		Class<? extends Object> ownerClass = Class.forName(owner.getClass()
				.getName());
		Field field = ownerClass.getDeclaredField(fieldName);
		field.setAccessible(true);
		if ("java.lang.Integer".equals(field.getType().getName())
				|| "int".equals(field.getType().getName())) {
			int val = -1;
			try {
				val = Integer.parseInt(value.toString());
			} catch (Exception e) {
			}
			field.set(owner, val);
		} else if ("java.sql.Timestamp".equals(field.getType().getName())) {
			field.set(owner, new Timestamp(Long.parseLong(value.toString())));
		}else if("java.lang.Double".equals(field.getType().getName())||
				"double".equals(field.getType().getName())){
			double val = -1;
			val = Double.parseDouble(value.toString());
			field.set(owner, val);
		}else if("java.lang.Float".equals(field.getType().getName())
				|| "float".equals(field.getType().getName())){
			float val = -1;
			val = Float.parseFloat(value.toString());
			field.set(owner, val);
		} else {
			field.set(owner, value);
		}
		field.setAccessible(false);
	}

	/**
	 * 获得带有PrimaryKey元数据描述的 属性名
	 * 
	 * @param c
	 * @return
	 */
	public static String getPrimaryKeyFromClass(Class<? extends Object> c) {
		Field[] fields = c.getDeclaredFields();

		for (int i = 0, len = fields.length; i < len; i++) {
			if (fields[i].isAnnotationPresent(PrimaryKey.class))
				return fields[i].getName();
		}
		return "";
	}

	/**
	 * 得到类中某一个属性的类型
	 * 
	 * @param c
	 * @param fieldName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public static Class<? extends Object> getPrimaryKeyType(
			Class<? extends Object> c, String fieldName) {
		try {
			return c.getDeclaredField(fieldName).getType();
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.system", e);
		}

	}

	/**
	 * 获得带有KeyNamePlus元数据描述的 属性名列表
	 * 
	 * @param c
	 * @return
	 */
	public static List<String> getDBIndexKeyFromClass(Class<? extends Object> c) {
		Field[] fields = c.getDeclaredFields();
		List<String> list = new ArrayList<String>();
		for (int i = 0, len = fields.length; i < len; i++) {
			if (fields[i].isAnnotationPresent(DBIndexKey.class))
				list.add(fields[i].getName());
		}
		return list;
	}

	/**
	 * 得到外键
	 */
	public static List<String> getForeignKey(Class<? extends Object> c) {
		List<String> rlist = new ArrayList<String>();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			if (fields[i].isAnnotationPresent(ForeignKey.class))
				rlist.add(fields[i].getName());
		}
		return rlist;
	}

	/**
	 * 获得外键对应的列表
	 */
	@Deprecated
	public static List<ForeignKeyObject> getForeignKeyClass(
			Class<? extends Object> c) {
		List<ForeignKeyObject> rlist = new ArrayList<ForeignKeyObject>();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			if (fields[i].isAnnotationPresent(ForeignKeyClass.class)) {
				ForeignKeyObject fko = new ForeignKeyObject();
				ForeignKeyClass fc = fields[i]
						.getAnnotation(ForeignKeyClass.class);
				fko.setFkId(fc.fk());
				fko.setFkFieldName(fc.fkFieldName());
				fko.setTableName(fc.tableName());
				fko.setFieldName(fields[i].getName());
				rlist.add(fko);
			}
		}
		return rlist;
	}
	public static EntityKeyName getEntityKeyNameByClassStr(String str) throws ClassNotFoundException{
		String[] names = str.split("\\$\\$");
		Class f = Class.forName(names[0]);
		if (f.isAnnotationPresent(EntityKeyName.class)) {
			EntityKeyName entity = (EntityKeyName) f
					.getAnnotation(EntityKeyName.class);
			return entity;
		}
		return null;
	}
	/**
	 * 通过类字符串，获取keyName
	 * 
	 * @param str
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static String getKeyNameByClassStr(String str)
			throws ClassNotFoundException {
		String[] names = str.split("\\$\\$");
		Class f = Class.forName(names[0]);
		if (f.isAnnotationPresent(EntityKeyName.class)) {
			EntityKeyName entity = (EntityKeyName) f
					.getAnnotation(EntityKeyName.class);
			str = entity.keyName();
		}
		return str;
	}

	public static EntityKeyName getEntityKeyNameByClass(Class f){
		if (f.isAnnotationPresent(EntityKeyName.class)) {
			EntityKeyName entity = (EntityKeyName)f.getAnnotation(EntityKeyName.class);
			return entity;
		}
		return null;
	}
	/**
	 * 通过类字符串，获取entityName
	 * 
	 * @param str
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static String getEntityNameByClassStr(String str)
			throws ClassNotFoundException {
		String[] names = str.split("\\$\\$");
		Class f = Class.forName(names[0]);
		if (f.isAnnotationPresent(EntityKeyName.class)) {
			EntityKeyName entity = (EntityKeyName) f
					.getAnnotation(EntityKeyName.class);
			str = entity.entity().getName();
		}
		return str;
	}

	/**
	 * 判断当前类是否需要缓存，不需要缓存返回true，需要返回false
	 * 
	 * @param className
	 *            类名称字符串
	 * @return boolean
	 * @throws ClassNotFoundException
	 */
	public static boolean isClassNeedCached(String className)
			throws ClassNotFoundException {
		String[] names = className.split("\\$\\$");
		Class f = Class.forName(names[0]);
		if (f.isAnnotationPresent(NoCache.class)) {
			return true;
		}
		return false;
	}

	
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	public static final String randomStringEx(int length){
		Date dt = new Date();
		String len = dt.getTime()+"";
		String str = len+AirPortUtil.randomString(length-len.length()>0?length-len.length():0);
		return str;
	}
	/**
	 * 随机生成length长度的字符串
	 * @param length
	 * @return
	 */
	public static final String randomString(int length) {
	         if (length < 1) {
	             return null;
	         }
	         if (randGen == null) {
	                randGen = new Random();
	                numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
	                   "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	                  //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	                 }
	         char [] randBuffer = new char[length];
	         for (int i=0; i<randBuffer.length; i++) {
	             randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
	         }
	         return new String(randBuffer);
	}
	
	/**
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String fillStringBefore(String str, String holder, int length) {
		if (str.length() < 1) {
			throw new AirportRuntimeException("system.err.system");
		}
		if (length <= str.length()) {
			throw new AirportRuntimeException("system.err.system");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length - str.length(); i++) {
			sb.append(holder);
		}
		sb.append(str);
		return sb.toString();
	}

	//
	// private static String[] CLASS_PATH_PROP = { "java.class.path",
	// "java.ext.dirs", "sun.boot.class.path" };
	public static void main(String[] args) {
		System.out.println(fillStringBefore("1", "@", 8));
		// System.out.println( getClassTableKey(UserInfoDao.class));

		// System.out.println(AirPortUtil.getPrimaryKeyType(UserInfo.class,
		// "userID"));
		// System.out.println(System.getProperty("java.class.path"));
		// System.out.println(System.getProperty("java.ext.dirs"));
		// System.out.println(System.getProperty("sun.boot.class.path"));
		// List<File> lf = AirPortUtil.getClassPath();
		// for(File f:lf){
		// System.out.println(f.getName());
		// }
		// List <String> cls = getClassInPackage(
		// "com.palm360.airport.daoimpl");
		// for(String s:cls){
		// System.out.println(s);
		// }
	}
}
