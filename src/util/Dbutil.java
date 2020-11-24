package util;/**
 * @author shkstart
 * @create 2020-10-27 23:06
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: StudentInfo
 *
 * @description: 数据库交互
 *
 * @author: wwq
 *
 * @create: 2020-10-27 23:06
 **/
public class Dbutil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_student?useUnicode=true&characterEncoding=utf8";//数据库连接地址
    private String dbUserName = "root"; //用户名
    private String dbPassword = "";//密码
    private String jdbcName = "com.mysql.jdbc.Driver"; //驱动名称
/**
 * 获取数据库连接
 *
 */
    public Connection getCon(){
        try {
            Class.forName(jdbcName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭数据库连接
     *
     */

    public void closeCon(Connection con)throws Exception{
        if (con!= null){
            con.close();
        }
    }

    public static void main(String[] args) {
        Dbutil dbutil = new Dbutil();
        try {
            dbutil.getCon();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

    }
}
