/*
 * Created by JFormDesigner on Fri Nov 20 19:17:05 CST 2020
 */

package view;

import dao.ClassDao;
import dao.CourseDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.Student;
import model.StudentClass;
import model.Teacher;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class AddCourseFrm extends JInternalFrame {
    public AddCourseFrm() {
        this.setBounds(200,50,445,440);
        initComponents();
        setTeacherCombox();
    }

    //重置
    private void button2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
        comboBox1.setSelectedIndex(0);
        textArea1.setText("");
    }

    //添加课程
    private void button1ActionPerformed(ActionEvent e) {
        String courseName = textField1.getText().toString();
        String courseInfo = textArea1.getText().toString();
        if (StringUtil.isEmpty(courseName)) {
            JOptionPane.showMessageDialog(this, "请输入课程名称：");
            return;
        }
        Teacher selectedTeacher = (Teacher)comboBox1.getSelectedItem();
        int studentMaxNum = 0;
        try {
            studentMaxNum = Integer.parseInt(textField2.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"学生人数只能输入数字！");
            return;
        }
        if (studentMaxNum<=0){
            JOptionPane.showMessageDialog(this,"学生人数只能输入大于0的数字");
            return;
        }
        Course course = new Course();
        course.setName(courseName);
        course.setMax_student_num(studentMaxNum);
        course.setInfo(courseInfo);
        course.setTeacher_id(selectedTeacher.getId());
        CourseDao courseDao = new CourseDao();
        if (courseDao.addCourse(course)){
            JOptionPane.showMessageDialog(this,"添加成功！");
        }else {
            JOptionPane.showMessageDialog(this,"添加失败！");
        }
        courseDao.closeDao();
        button2ActionPerformed(e);
    }



    //显示授课教师
    private void setTeacherCombox(){
        TeacherDao teacherDao = new TeacherDao();
        List<Teacher> teacherList = teacherDao.getTeacherList(new Teacher());
        teacherDao.closeDao();
        for (Teacher teacher : teacherList){
            comboBox1.addItem(teacher);
        }

    }

    //显示
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        comboBox1 = new JComboBox();
        label4 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setVisible(true);
        setTitle("\u6dfb\u52a0\u8bfe\u7a0b");
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bfe\u7a0b\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u6388\u8bfe\u8001\u5e08\uff1a");

        //---- label3 ----
        label3.setText("\u5b66\u751f\u4eba\u6570\uff1a");

        //---- label4 ----
        label4.setText("\u8bfe\u7a0b\u4ecb\u7ecd\uff1a");

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(27, 27, 27)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(button1)
                            .addGap(53, 53, 53)
                            .addComponent(button2)))
                    .addContainerGap(74, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(37, 37, 37))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JLabel label4;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
