package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/**
 * 数据库连接池工具
 * @author Administrator
 */
public class DruidUtil {
	private static DataSource ds;
	static{
		//--1.加载配置文件信息
		Properties ps = new Properties();   //--Map<Object,object>
		//--2.建立到配置文件的流
		InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		//--3.读取配置文件的数据
		try {
			ps.load(in);   //简单的读取配置文件的信息
			//--4.通过配置信息建立数据源对象DataSource（其实就是连接池对象）
			ds = DruidDataSourceFactory.createDataSource(ps);
		} catch (Exception e) {
			System.out.println("建立数据源对象DataSoure异常");
		}
		
	}
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = ds.getConnection();    //通过连接池获取连接对象
		} catch (SQLException e) {
			System.out.println("JDBC获取连接异常");
		}
		return con;
	}
	public static void close(Statement stmt,Connection con){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs ,Statement stmt,Connection con){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
