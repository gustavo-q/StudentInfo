package dao;/**
 * @author shkstart
 * @create 2020-11-08 16:39
 */

import model.Admin;
import model.Student;
import model.StudentClass;
import util.StringUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: StudentInfo
 *
 * @description:
 *
 * @author: wwq
 *
 * @create: 2020-11-08 16:39
 **/
public class StudentDao extends BaseDao{

    public boolean addStudent(Student scl){
        String sql ="insert into s_student values(null,?,?,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1,scl.getName());
            prst.setInt(2,scl.getClassId());
            prst.setString(3,scl.getSex());
            prst.setString(4,scl.getPassword());
            if (prst.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //查询
    public List<Student> getStudentList(Student student){
        List<Student> retList = new ArrayList<Student>();
        StringBuffer sqlString = new StringBuffer("select * from s_student");
        if (!StringUtil.isEmpty(student.getName())){
            sqlString.append( " and name like '%" + student.getName() +"%'");
        }
        if (student.getClassId() != 0){
            sqlString.append(" and  classId ="+student.getClassId());
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and","where"));
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()){
                Student sc = new Student();
                sc.setId(executeQuery.getInt("id"));
                sc.setName(executeQuery.getString("name"));
                sc.setClassId(executeQuery.getInt("classId"));
                sc.setSex(executeQuery.getString("sex"));
                sc.setPassword(executeQuery.getString("password"));
                retList.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retList;
    }

    //删除
    public boolean deleteStudent(int id){
        String sql = "delete from s_student where id=?";
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


    //修改更新数据
    public boolean update(Student student){
        String sql = "update s_student set name=?,classId=?,sex=?,password=? where id =?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getClassId());
            preparedStatement.setString(3,student.getSex());
            preparedStatement.setString(4,student.getPassword());

            preparedStatement.setInt(5,student.getId());
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    //学生修改密码
    public String editPassword(Student student,String newPassword){
        String sql ="select * from s_student where name=? and password=?";
        PreparedStatement prst = null;
        int id = 0;
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1,student.getName());
            prst.setString(2,student.getPassword());
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
        String sqlString = "update s_student set password = ? where id =?";
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


    //登录检测
    public Student login(Student student){
        String sql ="select * from s_student where name=? and password=?";
        Student studentRst = null;
        try {
            PreparedStatement  prst =con.prepareStatement(sql);//把sql语句传个数据库操作对象
            prst.setString(1,student.getName());
            prst.setString(2,student.getPassword());
            ResultSet excuteQuery = prst.executeQuery();
            if (excuteQuery.next()){
                studentRst = new Student();
                studentRst.setName(excuteQuery.getString("name"));
                studentRst.setPassword(excuteQuery.getString("password"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return studentRst;

    }

}
