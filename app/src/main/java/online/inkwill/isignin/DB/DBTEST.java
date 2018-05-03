package online.inkwill.isignin.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Y on 2018/4/25 0025.
 */

public class DBTEST {
    public static void main(String args[]) throws SQLException
    {
        DBCon testdb = new DBCon();
        String name = "YH";

        String sql = "select * from user ";
        String sql2 = "SELECT * FROM user WHERE username = '"+name+"'";
        ResultSet rs = testdb.executeQuery(sql2);

        while (rs.next()){
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("姓名： " + rs.getString("username"));
            System.out.println("密码： " + rs.getString("password"));
        }
        //String addSql = "INSERT INTO user (name) VALUES ('张三')";
        //testdb.executeUpdate(addSql);
    }
}
