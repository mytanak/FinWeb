package br.com.etectupa.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Convert {
	public static Date StrToDate(String dataS) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data = null;		
		try {
			data = new Date(format.parse(dataS).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static java.sql.Date StrToDateSql(String dataS) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date data = null;
		try {
			data = new java.sql.Date(format.parse(dataS).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return data;
	}
}
