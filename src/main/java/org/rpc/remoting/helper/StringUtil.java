package org.rpc.remoting.helper;

/**
 * @author xingg
 *	字符串操作工具类
 */
public class StringUtil {
	
	/**
	 * 字符串为空返回true
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return	(str != null && !"".equals(str)) ? false : true;
	}
	
	/**
	 * 判断字符串是否是long类型数据
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		return str.matches("^[1-9][0-9]*$");
	}
	
	public static boolean equals(String str1,String str2){
		return  (str1!=null && str1.equals(str2)) ? true : false;
	}
}
