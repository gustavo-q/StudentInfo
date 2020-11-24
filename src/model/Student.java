package model;/**
 * @author shkstart
 * @create 2020-11-08 16:36
 */

/**
 * @program: StudentInfo
 *
 * @description: 学生类
 *
 * @author: wwq
 *
 * @create: 2020-11-08 16:36
 **/
public class Student {
    private int id;
    private String name;
    private int classId;
    private String sex;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
