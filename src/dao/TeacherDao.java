package dao;/**
 * @author shkstart
 * @create 2020-11-17 20:02
 */

import model.Student;
import model.Teacher;
import util.StringUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: StudentInfo
 * @description: 老师类
 * @author: wwq
 * @create: 2020-11-17 20:02
 **/
public class TeacherDao extends BaseDao {


    //添加老师
    public boolean addTeacher(Teacher scl) {
        String sql = "insert into s_teacher values(null,?,?,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, scl.getName());
            prst.setString(2, scl.getSex());
            prst.setString(3, scl.getTitle());
            prst.setString(4, scl.getPassword());
            if (prst.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //老师列表
    //查询
    public List<Teacher> getTeacherList(Teacher teacher) {
        List<Teacher> retList = new ArrayList<Teacher>();
        StringBuffer sqlString = new StringBuffer("select * from s_teacher");
        if (!StringUtil.isEmpty(teacher.getName())) {
            sqlString.append(" and name like '%" + teacher.getName() + "%'");
        }

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                Teacher sc = new Teacher();
                sc.setId(executeQuery.getInt("id"));
                sc.setName(executeQuery.getString("name"));
                sc.setPassword(executeQuery.getString("password"));
                sc.setSex(executeQuery.getString("sex"));
                sc.setTitle(executeQuery.getString("title"));
                retList.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retList;
    }


    //修改更新数据
    public boolean update(Teacher teacher) {
        String sql = "update s_teacher set name=?,sex=?,title=?,password=? where id =?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSex());
            preparedStatement.setString(3, teacher.getTitle());
            preparedStatement.setString(4, teacher.getPassword());

            preparedStatement.setInt(5, teacher.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //删除数据
    public boolean deleteTeacher(int id) {
        String sql = "delete from s_teacher where id=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Teacher login(Teacher teacherTmp) {
        String sql ="select * from s_teacher where name=? and password=?";
        Teacher teacherRst = null;
        try {
            PreparedStatement  prst =con.prepareStatement(sql);//把sql语句传个数据库操作对象
            prst.setString(1,teacherTmp.getName());
            prst.setString(2,teacherTmp.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if (excuteQuery.next()){
                teacherRst = new Teacher();
                teacherRst.setName(excuteQuery.getString("name"));
                teacherRst.setPassword(excuteQuery.getString("password"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return teacherRst;
    }

    //教师修改密码
    public Object editPassword(Teacher teacherTmp, String newPassword) {
        String sql ="select * from s_teacher where name=? and password=?";
        PreparedStatement prst = null;
        int id = 0;
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1,teacherTmp.getName());
            prst.setString(2,teacherTmp.getPassword());
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
        String sqlString = "update s_teacher set password = ? where id =?";
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

