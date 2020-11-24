package dao;/**
 * @author shkstart
 * @create 2020-11-05 15:40
 */

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
 * @description:班级信息与数据库的操作
 *
 * @author: wwq
 *
 * @create: 2020-11-05 15:40
 **/
public class ClassDao extends BaseDao{

    //添加
    public boolean addClass(StudentClass scl){
        String sql ="insert into s_class values(null,?,?)";
        try {
           PreparedStatement prst = con.prepareStatement(sql);
           prst.setString(1,scl.getName());
           prst.setString(2,scl.getInfo());
           if (prst.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //查询
    public List<StudentClass> getClassList(StudentClass studentClass){
        List<StudentClass> retList = new ArrayList<StudentClass>();
        String sqlString = "select * from s_class";
        if (!StringUtil.isEmpty(studentClass.getName())){
            sqlString += " where name like '%"+studentClass.getName()+"%'";
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlString);
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()){
                StudentClass sc = new StudentClass();
                sc.setId(executeQuery.getInt("id"));
                sc.setName(executeQuery.getString("name"));
                sc.setInfo(executeQuery.getString("info"));
                retList.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retList;
    }


    //删除
    public boolean delete(int id){
        String sql = "delete from s_class where id=?";
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

    //更新
    public boolean update(StudentClass studentClass){
        String sql = "update s_class set name=?,info=? where id =?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,studentClass.getName());
            preparedStatement.setString(2,studentClass.getInfo());
            preparedStatement.setInt(3,studentClass.getId());
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


}
