package dao;/**
 * @author shkstart
 * @create 2020-10-28 10:35
 */


import model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: StudentInfo
 *
 * @description:
 *
 * @author: wwq
 *
 * @create: 2020-10-28 10:35
 **/
public class AdminDao extends BaseDao {



    /**
     * 管理员登录
     * @return
     */
    public Admin login(Admin admin){
        String sql ="select * from s_admin where name=? and password=?";
        Admin adminRst = null;
        try {
            PreparedStatement  prst =con.prepareStatement(sql);//把sql语句传个数据库操作对象
            prst.setString(1,admin.getName());
            prst.setString(2,admin.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if (excuteQuery.next()){
                adminRst = new Admin();
                adminRst.setId(excuteQuery.getInt("id"));
                adminRst.setName(excuteQuery.getString("name"));
                adminRst.setPassword(excuteQuery.getString("password"));
                adminRst.setCreateDate(excuteQuery.getString("createDate"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return adminRst;

    }


    //修改密码
    public String editPassword(Admin admin,String newPassword){
        String sql ="select * from s_admin where name=? and password=?";
        PreparedStatement prst = null;
        int id = 0;
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1,admin.getName());
            prst.setString(2,admin.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if (!excuteQuery.next()){
                String retString = "旧密码错误！";
                return retString;
            }
            id = excuteQuery.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }//把SQL语句传给数据库操作对象
        String retString ="修改失败";
        String sqlString = "update s_admin set password = ? where id =?";
        try {
            prst = con.prepareStatement(sqlString);
            prst.setString(1,newPassword);
            prst.setInt(2,id);
            int rst = prst.executeUpdate();
            if (rst > 0){
                retString ="密码修改成功！";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retString;


    }


}
