package dao;/**
 * @author shkstart
 * @create 2020-10-27 23:05
 */

import util.Dbutil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: StudentInfo
 *
 * @description:
 *
 * @author: wwq
 *
 * @create: 2020-10-27 23:05
 **/
public class BaseDao {
    public Connection con = new Dbutil().getCon();
    public void closeDao(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
