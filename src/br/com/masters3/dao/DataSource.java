package br.com.masters3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class DataSource {
	
	private Connection connection;
	
	private String url;
	private String hostname;
	private String username;
	private String password;
	private String database;
	private int    port;
	
	public DataSource() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			hostname = "oracle.fiap.com.br";
			port     = 1521;
			username = "pf0709";
			password = "Fgrd32i";
			database = "orcl";
			
			url = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
			
			
			connection = DriverManager.getConnection(url,username,password);
			if (connection != null) {
				System.out.println("Conectado com Sucesso");
			}
			else {
				System.out.println("Falhou na conexao");
			}
		}
		catch(Exception ex) {
			System.out.println("Datasource ERRO: "+ex.getMessage());
		
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
