package model;/**
 * @author shkstart
 * @create 2020-11-16 21:15
 */

/**
 * @program: StudentInfo
 *
 * @description: 老师类
 *
 * @author: wwq
 *
 * @create: 2020-11-16 21:15
 **/
public class Teacher {
    private int id;
    private String name;
    private String sex;
    private String title;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
