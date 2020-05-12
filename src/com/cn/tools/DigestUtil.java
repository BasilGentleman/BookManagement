package com.cn.tools;

import java.security.MessageDigest;
/**
 * 字符创加密
 * @author mac
 *
 */
public class DigestUtil {
	 public final static String md5Hex(String str) {
	        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	        try {
	            // 获得MD5摘要算法的 MessageDigest 对象
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 使用指定的字节更新摘要信息
	            md.update(str.getBytes());//md.update(s.getBytes("utf-8"));
	            // 获得密文
	            byte[] digest = md.digest();
	            // 把密文转换成十六进制的字符串形式
	            char md5str[] = new char[32];
	            int k = 0;
	            for (int i = 0; i < digest.length; i++) {
	                byte byte0 = digest[i];
	                md5str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                md5str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(md5str);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            return null;
	        }
	    }

}
