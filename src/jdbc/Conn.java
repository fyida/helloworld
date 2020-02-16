package jdbc;

import java.sql.*;
public class Conn {
	Connection con;
	Statement stmt=null;
	public void getConnection() {
		//Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. 
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin
        try {
            con = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java?useSSL=false&serverTimezone=UTC",
                            "root", "admin");
  
            System.out.println("连接成功，获取连接对象： " + con);
            stmt=con.createStatement();
            System.out.println("获取 Statement对象： " + stmt);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	public void insertlast(String name,float hp,int damage)  {
		try {
			String sql = "insert into hero values(null,"+"'"+name+"'"+","+hp+","+damage+")";
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		//System.out.println("执行插入语句成功");
	}
	public void close() {
    	// 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
        // 先关闭Statement
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        // 后关闭Connection
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	}
	public static void main(String[] args) {
		Conn c=new Conn();
		c.getConnection();
		for(int i=0;i<100;i++) {
			String name="英雄"+(i+1);
			c.insertlast( name, 313.0f, 50);
		}
        c.close();
	}

}
