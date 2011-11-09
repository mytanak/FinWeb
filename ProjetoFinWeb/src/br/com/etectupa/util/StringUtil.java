package br.com.etectupa.util;

public class StringUtil {
	public static String SomenteNumeros(String str)
	{
		try
		{
			str = str.replaceAll("[^0-9]", str);
			return str;
		}
		catch (Exception ex)
		{
			return "";
		}
		
	}  
}
