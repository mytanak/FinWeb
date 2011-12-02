package br.com.etectupa.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Biblioteca {
	public static java.sql.Date Today() {
		Date dataUtil = new Date();
		java.sql.Date data = new java.sql.Date(dataUtil.getTime());
		return data;
	}
	
	public static int retornaDia(Date data) {
		GregorianCalendar gc = new GregorianCalendar();		
		gc.setTime(data);
		int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);   
		return dia;
	}
	
	public static int retornaMes(Date data) {
		GregorianCalendar gc = new GregorianCalendar();		
		gc.setTime(data);
		int mes = gc.get(GregorianCalendar.MONTH);
		mes ++;
		return mes;
	}
	
	public static String retornaMesStr(Date data) {
		GregorianCalendar gc = new GregorianCalendar();		
		gc.setTime(data);
		int mes = gc.get(GregorianCalendar.MONTH);
		mes ++;
		
		String mesStr = retornaMesStr(mes);
		
		return mesStr;
	}

	public static String retornaMesStr(int mes) {
		String mesStr = "";
		
		switch (mes) {
		case 1:
			mesStr = "Janeiro";
			break;
		case 2:
			mesStr = "Fevereiro";
			break;
		case 3:
			mesStr = "Março";
			break;
		case 4:
			mesStr = "Abril";
			break;
		case 5:
			mesStr = "Maio";
			break;			
		case 6:
			mesStr = "Junho";
			break;
		case 7:
			mesStr = "Julho";
			break;
		case 8:
			mesStr = "Agosto";
			break;
		case 9:
			mesStr = "Setembro";
			break;
		case 10:
			mesStr = "Outubro";
			break;
		case 11:
			mesStr = "Novembro";
			break;			
		case 12:
			mesStr = "Dezembro";
			break;
		}
		return mesStr;
	}
	
	public static String retornaMesAbrevStr(int mes) {
		String mesStr = "";
		
		switch (mes) {
		case 1:
			mesStr = "Jan";
			break;
		case 2:
			mesStr = "Fev";
			break;
		case 3:
			mesStr = "Mar";
			break;
		case 4:
			mesStr = "Abr";
			break;
		case 5:
			mesStr = "Mai";
			break;			
		case 6:
			mesStr = "Jun";
			break;
		case 7:
			mesStr = "Jul";
			break;
		case 8:
			mesStr = "Ago";
			break;
		case 9:
			mesStr = "Set";
			break;
		case 10:
			mesStr = "Out";
			break;
		case 11:
			mesStr = "Nov";
			break;			
		case 12:
			mesStr = "Dez";
			break;
		}
		return mesStr;
	}	
	public static int retornaAno(Date data) {
		GregorianCalendar gc = new GregorianCalendar();		
		gc.setTime(data);
		int ano = gc.get(GregorianCalendar.YEAR);   
		return ano;
	}
	
	public static String primeiroDiaMes(Integer Ano, Integer Mes) {
		Calendar cal = new GregorianCalendar(Ano, Mes - 1, 1);
		Integer dia = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		return strZero(dia.toString(),2) + "/" + strZero(Mes.toString(),2) + "/" + strZero(Ano.toString(), 4);
	}

	public static String ultimoDiaMes(Integer Ano, Integer Mes) {
		Calendar cal = new GregorianCalendar(Ano, Mes - 1, 1);
		Integer dia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return strZero(dia.toString(),2) + "/" + strZero(Mes.toString(),2) + "/" + strZero(Ano.toString(), 4);
	}

	public static String retornaDataStr(Integer Ano, Integer Mes, Integer Dia) {		
		return strZero(Dia.toString(), 2) + "/" + strZero(Mes.toString(), 2) + "/" + strZero(Ano.toString(), 4);
	}
	
	public static String strZero(String str, Integer qtde) {
		int zeros = qtde - str.length();
		String result = "";
		for (int i = 0; i < zeros; i++) {
			result += "0";
		}
		
		result += str;
		
		return result;
	}

}
