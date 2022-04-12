package com.saib.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Set;

public class CommonUtil {

	public static boolean isNull(Object obj) {
		boolean isNull = false;
		if (obj == null) {
			isNull = true;
		}
		return isNull;
	}
	
	public static boolean isNullOrEmty(String str) {
		boolean isNullOrEmpty = false;
		if (str == null || str.isEmpty()) {
			isNullOrEmpty = true;
		}
		return isNullOrEmpty;
	}
	
	
	
	public static boolean isNotNull(Object obj) {
		boolean isNotNull = false;
		if (obj != null) {
			isNotNull = true;
		}
		return isNotNull;
	}

	public static boolean isNotNullAndEqualWithIngoreCase(String str1, String str2) {
		boolean isNotNullAndEqualWithIngoreCase = false;
		if (str1 != null && str2 != null) {
			if (str1.trim().equalsIgnoreCase(str2.trim())) {
				isNotNullAndEqualWithIngoreCase = true;
			}
		}
		return isNotNullAndEqualWithIngoreCase;
	}

	public static boolean isNotNullAndEmpty(String text) {
		if (text != null && !text.isEmpty()) {
			return true;
		}

		return false;
	}

	public static boolean isNotNullAndEmpty(List<?> list) {

		boolean isNotNullAndEmpty = false;

		if (list != null && list.size() > 0) {
			isNotNullAndEmpty = true;
		}

		return isNotNullAndEmpty;

	}

	public static boolean isNotNullAndEmpty(Set<?> set) {

		boolean isNotNullAndEmpty = false;

		if (set != null && set.size() > 0) {
			isNotNullAndEmpty = true;
		}

		return isNotNullAndEmpty;

	}

	public static String getException(Throwable th)
	{
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		th.printStackTrace(printWriter);
		return writer.toString();

	}
	
	public static String extractStream(InputStream inputStream ) 
	{
		
		StringBuilder stringBuilder = new StringBuilder();  
	    BufferedReader bufferedReader = null;  

	    try {  
	        

	        if (inputStream != null) {  
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));  

	            char[] charBuffer = new char[128];  
	            int bytesRead = -1;  

	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {  
	                stringBuilder.append(charBuffer, 0, bytesRead);  
	            }  
	        } else {  
	            stringBuilder.append("");  
	        }  
	    } catch (IOException ex) {  
	       
	    } finally {  
	         
	    }  
	    return stringBuilder.toString();
	}
	
}
