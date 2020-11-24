package dao;/**
 * @author shkstart
 * @create 2020-11-20 22:49
 */

import model.Course;
import model.Student;
import util.StringUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: StudentInfo
 *
 * @description: 科目
 *
 * @author: wwq
 *
 * @create: 2020-11-20 22:49
 **/
public class CourseDao extends BaseDao{

    public boolean addCourse(Course course){
        String sql ="insert into s_course values(null,?,?,?,?,0)";
        try {
            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1,course.getName());
            prst.setInt(2,course.getTeacher_id());
            prst.setInt(3,course.getMax_student_num());
            prst.setString(4,course.getInfo());

            if (prst.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //查询
    public List<Course> getCourseList(Course course){
        List<Course> retList = new ArrayList<Course>();
        StringBuffer sqlString = new StringBuffer("select * from s_course");
        if (!StringUtil.isEmpty(course.getName())){
            sqlString.append( " and name like '%" + course.getName() +"%'");
        }
        if (course.getTeacher_id() != 0){
            sqlString.append(" and  teacher_id ="+course.getTeacher_id());
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and","where"));
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()){
                Course cs = new Course();
                cs.setId(executeQuery.getInt("id"));
                cs.setName(executeQuery.getString("name"));
                cs.setTeacher_id(executeQuery.getInt("teacher_id"));
                cs.setMax_student_num(executeQuery.getInt("max_student_num"));
                cs.setInfo(executeQuery.getString("info"));
                retList.add(cs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retList;
    }


    //删除课程
    public boolean deleteCourse(int id) {
        String sql = "delete from s_course where id=?";
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


    public boolean updateCourse(Course course) {
        String sql = "update s_course set name=?,teacher_id=?,max_student_num=?,info=?, where id =?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,course.getName());
            preparedStatement.setInt(2,course.getTeacher_id());
            preparedStatement.setInt(3,course.getMax_student_num());
            preparedStatement.setString(4,course.getInfo());

            preparedStatement.setInt(5,course.getId());
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
