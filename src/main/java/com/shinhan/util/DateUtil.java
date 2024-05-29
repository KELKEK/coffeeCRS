package com.shinhan.util;
/*
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
		public static Date getUtilDate(String d) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date result = null;
			try {
				result = sdf.parse(d);
						
			}catch(ParseException e) {
				e.printStackTrace();
			}
			return result;
		}
	//문자가 들어오면 util의 data로 바꾼다.
	
	public static java.sql.Date getSQLDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date result = null;
		try {
			Date d2 = sdf.parse(d);
			result = new java.sql.Date(d2.getTime());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return result;//sql의 data를 return
	}
}*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getUtilDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = sdf.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//sql에 맞춘 날짜 결과로 바꿔줌
	//이것은 util의 Date가 아닌 sql의 Date이므로 형변환이 불가 하여 그냥 Date라 넣는게 아니라 java.sql.Date해주어야 한다.
	//다만 import해서 java.sql.date 할 수 없는 이유가 그렇게 되면 위의 getUtilDate의 Date가 모호해져서 문제가 생기게 된다.
	public static java.sql.Date getSQLDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	 
		java.sql.Date result = null;
		try {
			Date d2 = sdf.parse(d);
			result = new java.sql.Date(d2.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
