package br.com.etectupa.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Conecta {
	private static String USER="";
	private static String PASSWD="";
	private static String SERVER="";
	private static String DATABASE="";
	//private final static String SERVER="10.67.23.10";
	Connection connection = null;
	
	private static Conecta instance = null;
	
	/**
	 * Construtor da Classe
	 * Inicializa a conexao
	 */
	private Conecta() {
		inicializar();
	}
	
	
	/**
	 * Metodo que carrega o driver e efetua a conexao com o BD
	 */
	public void inicializar() {
		try {
			// Carregando o driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Criando a conexao jdbc
			
			SQLServerDataSource ds = new SQLServerDataSource();
			
			Properties prop = carregarConfiguracoes();
			
			USER = prop.getProperty("user");
			PASSWD = prop.getProperty("senha");
			SERVER = prop.getProperty("server");
			DATABASE = prop.getProperty("banco");
			
			ds.setServerName(SERVER);
			ds.setInstanceName("SQLEXPRESS");
			ds.setDatabaseName(DATABASE);
			ds.setUser(USER);
			ds.setPassword(PASSWD);
			
			connection = ds.getConnection();
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo chamado pelas outras classes para solicitar a conexao com o BD
	 */
	
	public Connection getConnection() {
		try {
			if(connection.isClosed()) {
				inicializar();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * Metodo chamado por outras classes para instanciar um objeto do tipo Conecta
	 * Este metodo verifica se uma instancia ja foi criada ou nao
	 */
	public static Conecta getInstance() {
		if (instance == null) 
			instance = new Conecta();
		
		return instance;
	}
	
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties carregarConfiguracoes() {
		Properties prop = new Properties();
		InputStream is = null;
		try {
			is = Conecta.class.getResourceAsStream("bd.properties");
			prop.load(is);

		} catch (IOException e) {
			e.getMessage();
		}

		return prop;
	}
	
}
