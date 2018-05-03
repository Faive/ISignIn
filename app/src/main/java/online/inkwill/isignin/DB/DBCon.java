package online.inkwill.isignin.DB;

import java.sql.*;

public class DBCon {

	// JDBC 驱动名及数据库 URL
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://120.78.175.234:3306/signdb";
//	private final String DB_URL = "jdbc:mysql://120.78.175.234:3306/signdb?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false";

	// 数据库的用户名与密码，需要根据自己的设置
	private final String USER = "yh";
	private final String PASSWORD = "admin147";

	private Connection con = null;
	private Statement statement = null;

	public DBCon() {
		//加载驱动
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException classnotfoundexception) {
			System.out.println("Can not find driver!");
			classnotfoundexception.printStackTrace();
		}
		//连接数据库
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			statement = con.createStatement();
			System.out.println("Connect Succeed！");
		} catch (SQLException sqlexception) {
			System.out.println("Connect fail！");
			sqlexception.printStackTrace();
		}
	}
	//关闭数据库
	public void close() {
		try {
			statement.close();
			con.close();
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
	}

	//执行查询sql
	public ResultSet executeQuery(String querySql) {
		ResultSet resultset = null;
		try {

			System.out.println("DBCon executeQuery:" + querySql);

			resultset = statement.executeQuery(querySql);
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
		return resultset;
	}

	//执行增删改sql
	public void executeUpdate(String sql) {
		try {

			System.out.println("DBCon executeUpdate:" + sql);

			statement.execute(sql);
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
	}


}

/*
Create
	INSERT INTO table(column1,column2...)
	VALUES (value1,value2,...),
       (value1,value2,...),
	...;

Research
	SELECT 
	    column_1, column_2, ...
	FROM
	    table_1
	[INNER | LEFT |RIGHT] JOIN table_2 ON conditions
	WHERE
	    conditions
	GROUP BY column_1
	HAVING group_conditions
	ORDER BY column_1
	LIMIT offset, length

Update
	UPDATE [LOW_PRIORITY] [IGNORE] table_name 
	SET 
    	column_name1 = expr1,
    	column_name2 = expr2,
    	...
	WHERE
    	condition;

 Delete
 	DELETE FROM table_name
	WHERE condition;
*/
