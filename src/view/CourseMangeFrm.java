/*
 * Created by JFormDesigner on Sat Nov 21 09:20:16 CST 2020
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
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author 1
 */
public class CourseMangeFrm extends JInternalFrame {
    private List<Teacher> teacherList;

    public CourseMangeFrm() {
        setBounds(100,50,755,535);
        initComponents();
        setTable(new Course());
        setCourseInfo();
    }

    //表格显示数据
    private void setTable(Course course){
        DefaultTableModel dft = (DefaultTableModel) table1.getModel();
        dft.setRowCount(0);
        CourseDao courseDao = new CourseDao();
        List<Course> courseList = courseDao.getCourseList(course);
        for (Course c : courseList) {
            Vector v = new Vector();
            v.add(c.getId());
            v.add(c.getName());
            v.add(getCourseNameById(c.getTeacher_id()));
            v.add(c.getMax_student_num());
            v.add(c.getInfo());
            dft.addRow(v);
        }

        courseDao.closeDao();

    }
    //显示表格中的授课老师
    private String getCourseNameById(int teacher_id) {
        TeacherDao teacherDao= new TeacherDao();
        teacherList = teacherDao.getTeacherList(new Teacher());
        for (Teacher t : teacherList) {
            if (t.getId() == teacher_id) return t.getName();
        }
        return "";
    }

    //显示授课老师列表数据
    private void setCourseInfo() {
        TeacherDao teacherDao= new TeacherDao();
        teacherList = teacherDao.getTeacherList(new Teacher());
        for (Teacher t : teacherList) {
            comboBox1.addItem(t);
            comboBox2.addItem(t);
        }
        teacherDao.closeDao();
    }

    //查询
    private void button1ActionPerformed(ActionEvent e) {
        Course c = new Course();
        Teacher t = (Teacher) comboBox1.getSelectedItem();
        c.setName(textField1.getText().toString());
        c.setTeacher_id(t.getId());
        setTable(c);
    }

    private void table1MouseClicked(MouseEvent e) {
        DefaultTableModel dft = (DefaultTableModel) table1.getModel();
        textField2.setText(dft.getValueAt(table1.getSelectedRow(), 1).toString());

        textField3.setText(dft.getValueAt(table1.getSelectedRow(), 3).toString());
        String teacherName = dft.getValueAt(table1.getSelectedRow(), 2).toString();
        for (int i = 0; i < comboBox2.getItemCount(); i++) {
            Teacher sc = (Teacher) comboBox2.getItemAt(i);
            if (teacherName.equals(sc.getName())) {
                comboBox2.setSelectedIndex(i);
            }
        }
        textArea1.setText(dft.getValueAt(table1.getSelectedRow(),4).toString());


    }

    //删除课程
    private void button3ActionPerformed(ActionEvent e) {
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
            return;
        }
        Course course = new Course();
        course.setId(Integer.parseInt(table1.getValueAt(row, 0).toString()));
        CourseDao courseDao = new CourseDao();
        if (courseDao.deleteCourse(course.getId())) {
            JOptionPane.showMessageDialog(this, "删除成功！");
        } else {
            JOptionPane.showMessageDialog(this, "删除失败！");
        }
        courseDao.closeDao();
        setTable(course);
    }

//    修改课程
    private void button2ActionPerformed(ActionEvent e) {
        int row = table1.getSelectedRow();

        if ( row== -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
            return;
        }

        String courseName = textField2.getText();
        Integer course_id = Integer.parseInt(table1.getValueAt(row,0).toString());
        if (StringUtil.isEmpty(courseName)) {
            JOptionPane.showMessageDialog(this, "请输入学生姓名！");
            return;
        }
        Teacher teacher = (Teacher)comboBox2. getSelectedItem();
       int max_student_num = 0;
        try {//不是整数报错
            max_student_num = Integer.parseInt(textField3.getText().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"学生人数请输入大于0的整数");
            return;
        }
        //小于0报错
        if (max_student_num <= 0){
            JOptionPane.showMessageDialog(this,"学生人数请输入大于0的整数");
            return;
        }
        String courseInfo = textArea1.getText().toString();
        Course course = new Course();
        course.setId(course_id);
        course.setName(courseName);
        course.setTeacher_id(teacher.getId());
        course.setMax_student_num(max_student_num);
        course.setInfo(courseInfo);
        CourseDao courseDao = new CourseDao();
        if (courseDao.updateCourse(course)) {
            JOptionPane.showMessageDialog(this, "修改成功！");
        } else {
            JOptionPane.showMessageDialog(this, "修改失败！");
        }
        courseDao.closeDao();
        setTable(new Course());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        comboBox2 = new JComboBox();
        label6 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("\u8bfe\u7a0b\u5217\u8868");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bfe\u7a0b\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u6388\u8bfe\u8001\u5e08\uff1a");

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "\u8bfe\u7a0bID", "\u8bfe\u7a0b\u540d\u79f0", "\u6388\u8bfe\u8001\u5e08", "\u5b66\u751f\u4eba\u6570", "\u8bfe\u7a0b\u4ecb\u7ecd"
                }
            ));
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- label3 ----
        label3.setText("\u8bfe\u7a0b\u540d\u79f0\uff1a");

        //---- label4 ----
        label4.setText("\u5b66\u751f\u4eba\u6570\uff1a");

        //---- label5 ----
        label5.setText("\u6388\u8bfe\u8001\u5e08\uff1a");

        //---- label6 ----
        label6.setText("\u8bfe\u7a0b\u4ecb\u7ecd\uff1a");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea1);
        }

        //---- button2 ----
        button2.setText("\u4fee\u6539");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("\u5220\u9664");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label6))
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button2)
                                .addComponent(button3)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(81, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(button1))
                    .addGap(35, 35, 35)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(button2)
                            .addGap(18, 18, 18)
                            .addComponent(button3))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JComboBox comboBox2;
    private JLabel label6;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
