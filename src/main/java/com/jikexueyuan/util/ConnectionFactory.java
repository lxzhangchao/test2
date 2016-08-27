package com.jikexueyuan.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.lang.String;
import javax.xml.parsers.FactoryConfigurationError;

public class ConnectionFactory {
	private static String driver;
	private static String dburl; 
	private static String user;
	private static String password;
	private static final ConnectionFactory factory= new ConnectionFactory();
	private Connection conn;
	static{
		Properties prop=new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader()
.getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
System.out.println("====================�����ļ���ȡ����================");		
	}
	driver = prop.getProperty("driver");
	dburl = prop.getProperty("dburl");
	user = prop.getProperty("user");
	password = prop.getProperty("password");
	System.out.println(driver);
	}
	public static ConnectionFactory getInstance(){
		return factory;
	}
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}


}
