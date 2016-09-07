package cn.com.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/** @Description 
 *  TODO: 数据工具
 *    
 * @author 周华波Jays 
 * @Email jayszxs@outlook.com 
 * @QQ 794378359 
 * @version 2016年7月21日
 */
public abstract class DBUtil {

	private static Properties pop;
	private static final String ACTIONPATH = "config.properties";
	
	private DBUtil() {

	}
	
	// 这样只读取一次
	static {
		pop = new Properties();
		
		String path = null;
		try {
			path = DBUtil.class.getClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String path = "/var/local/tomcat/webapps/OnlineChat/WEB-INF/classes/";
		
		try {
			pop.load(new FileReader(new File(path + ACTIONPATH)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建连接
	 * @return
	 */
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName(pop.getProperty("DRV"));
			
			conn = DriverManager.getConnection(pop.getProperty("URL"), pop.getProperty("USER"), pop.getProperty("PWD"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 连接关闭
	 * @param rs
	 * @param pstm
	 * @param conn
	 */
	public static void free(ResultSet rs, PreparedStatement pstm, Connection conn) {
		//boolean bool = false;
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return bool;		
	}
	
	
	public static void free(PreparedStatement pstm, Connection conn) {
		//boolean bool = false;
		
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return bool;		
	}

}
