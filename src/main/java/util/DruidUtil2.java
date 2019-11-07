package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
/**
 * 利用线程池来实现连接池的连接
 * @author Administrator
 *
 */
public class DruidUtil2 {
	//线程池对象（其实它就是Map，Key存储线程ID 值（value）放置连接对象）
	private static ThreadLocal<Connection> threadPool = new ThreadLocal<Connection>();
	private static DataSource ds;   //数据源对象
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
	//获取连接的方法
	public  static Connection getConnection(){
		//如果从线程池中拿不到连接，就新创建一个连接，如果拿到了，就不创建连接，从线程池中去连接 
		if(threadPool.get() == null) {
			try {
				Connection con = ds.getConnection();
				con.setAutoCommit(false);
				threadPool.set(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}    
		return threadPool.get();
	}
	public static void close(Statement stmt,Connection con){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!= null){
			threadPool.remove();
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(){
		if(threadPool.get()!= null){
			try {
				threadPool.get().commit();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				threadPool.get().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			threadPool.remove();
		}
	}
}
