/*
 * Created by JFormDesigner on Wed Nov 11 20:49:57 CST 2020
 */

package view;

import dao.ClassDao;
import dao.StudentDao;
import model.Student;
import model.StudentClass;
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
public class StudentMangeFrm extends JInternalFrame {
    private List<StudentClass> classList;


    public StudentMangeFrm() {
        this.setBounds(100, 50, 800, 500);
        initComponents();
        setTable(new Student());
        setStudentClassInfo();
    }

    //查询
    private void button1ActionPerformed(ActionEvent e) {
        Student s = new Student();
        StudentClass sc = (StudentClass) comboBox1.getSelectedItem();
        s.setName(textField1.getText().toString());
        s.setClassId(sc.getId());
        setTable(s);
    }

    //显示班级列表数据
    private void setStudentClassInfo() {
        ClassDao classDao = new ClassDao();
        classList = classDao.getClassList(new StudentClass());
        for (StudentClass sc : classList) {
            comboBox1.addItem(sc);
            comboBox2.addItem(sc);
        }
        classDao.closeDao();
    }

    //表格显示数据
    private void setTable(Student student) {
        DefaultTableModel dft = (DefaultTableModel) table1.getModel();
        dft.setRowCount(0);
        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.getStudentList(student);
        for (Student s : studentList) {
            Vector v = new Vector();
            v.add(s.getId());
            v.add(s.getName());
            v.add(getClassNameById(s.getClassId()));
            v.add(s.getSex());
            v.add(s.getPassword());
            dft.addRow(v);
        }

        studentDao.closeDao();
        setAuthority();
    }

    //显示表格中的班级
    private String getClassNameById(int id) {
        ClassDao classDao = new ClassDao();
        classList = classDao.getClassList(new StudentClass());
        for (StudentClass sc : classList) {
            if (sc.getId() == id) return sc.getName();
        }
        return "";
    }

    //删除数据
    private void button3ActionPerformed(ActionEvent e) {
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
            return;
        }
        Student student = new Student();
        student.setId(Integer.parseInt(table1.getValueAt(row, 0).toString()));
        StudentDao studentDao = new StudentDao();
        if (studentDao.deleteStudent(student.getId())) {
            JOptionPane.showMessageDialog(this, "删除成功！");
        } else {
            JOptionPane.showMessageDialog(this, "删除失败！");
        }
        studentDao.closeDao();
        setTable(student);

    }


    //把数据显示在输入框
    private void table1MouseClicked(MouseEvent e) {
        DefaultTableModel dft = (DefaultTableModel) table1.getModel();
        textField3.setText(dft.getValueAt(table1.getSelectedRow(), 1).toString());

        passwordField1.setText(dft.getValueAt(table1.getSelectedRow(), 4).toString());
        String className = dft.getValueAt(table1.getSelectedRow(), 2).toString();
        for (int i = 0; i < comboBox2.getItemCount(); i++) {
            StudentClass sc = (StudentClass) comboBox2.getItemAt(i);
            if (className.equals(sc.getName())) {
                comboBox2.setSelectedIndex(i);
            }
        }
        String sex = dft.getValueAt(table1.getSelectedRow(), 3).toString();

        if (sex.equals(radioButton1.getText())) {
            radioButton1.setSelected(true);
            radioButton2.setSelected(false);
        } else {
            radioButton1.setSelected(false);
            radioButton2.setSelected(true);
        }
    }


    //确认修改数据
    private void button2ActionPerformed(ActionEvent e) {
        String studentName = textField3.getText();
        String studentPassword = passwordField1.getText().toString();
        if (table1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
            return;
        }
        if (StringUtil.isEmpty(studentName)) {
            JOptionPane.showMessageDialog(this, "请输入学生姓名！");
            return;
        }
        if (StringUtil.isEmpty(studentPassword)) {
            JOptionPane.showMessageDialog(this, "请填写密码！");
            return;
        }
        Student student = new Student();
        student.setName(studentName);
        student.setPassword(studentPassword);
        StudentClass sc = (StudentClass) comboBox2.getSelectedItem();
        student.setClassId(sc.getId());
        student.setId(Integer.parseInt(table1.getValueAt(table1.getSelectedRow(), 0).toString()));
        if (radioButton1.isSelected()) student.setSex(radioButton1.getText().toString());
        if (radioButton2.isSelected()) student.setSex(radioButton2.getText().toString());
        StudentDao studentDao = new StudentDao();
        if (studentDao.update(student)) {
            JOptionPane.showMessageDialog(this, "修改成功！");
        } else {
            JOptionPane.showMessageDialog(this, "修改失败！");
        }
        studentDao.closeDao();
        setTable(new Student());
    }

    private void setAuthority() {
        if ("学生".equals(MainFrm.userType.getName())) {
            Student s = (Student) MainFrm.userObject;
            textField1.setText(s.getName());
            textField1.setEnabled(false);
            button3.setEnabled(false);
            for (int i = 0; i < comboBox2.getItemCount(); i++) {
                StudentClass sc = (StudentClass) comboBox2.getItemAt(i);
                if (sc.getId() == s.getClassId()) {
                    comboBox2.setSelectedIndex(i);
                    break;
                }
            }
            comboBox1.setEnabled(false);
            for (int i = 0;i<comboBox1.getItemCount();i++){
                StudentClass sc = (StudentClass)comboBox1.getItemAt(i);
                if (sc.getId() == s.getClassId()){
                    comboBox1.setSelectedIndex(i);
                    break;
                }
            }
        }
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
        textField3 = new JTextField();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label5 = new JLabel();
        comboBox2 = new JComboBox();
        label6 = new JLabel();
        passwordField1 = new JPasswordField();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setVisible(true);
        setPreferredSize(new Dimension(700, 500));
        setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u5b66\u751f.png")));

        //---- label2 ----
        label2.setText("\u6240\u5c5e\u73ed\u7ea7\uff1a");
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7.png")));

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u67e5\u8be2.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {


            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                    },
                    new String[]{
                            "\u5b66\u751f\u7f16\u53f7", "\u5b66\u751f\u59d3\u540d", "\u6240\u5c5e\u73ed\u7ea7", "\u5b66\u751f\u6027\u522b", "\u767b\u9646\u5bc6\u7801"
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
        label3.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u5b66\u751f.png")));

        //---- label4 ----
        label4.setText("\u5b66\u751f\u6027\u522b\uff1a");
        label4.setIcon(new ImageIcon(getClass().getResource("/images/\u6027\u522b.png")));

        //---- radioButton1 ----
        radioButton1.setText("\u7537");
        radioButton1.setSelected(true);

        //---- radioButton2 ----
        radioButton2.setText("\u5973");

        //---- label5 ----
        label5.setText("\u6240\u5c5e\u73ed\u7ea7\uff1a");
        label5.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7.png")));

        //---- label6 ----
        label6.setText("\u767b\u5f55\u5bc6\u7801\uff1a");
        label6.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6 \u7801 .png")));

        //---- button2 ----
        button2.setText("\u786e\u8ba4\u4fee\u6539");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4.png")));
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("\u5220\u9664");
        button3.setIcon(new ImageIcon(getClass().getResource("/images/\u5220\u9664\u7b5b\u9009\u9879.png")));
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(button1)
                                .addContainerGap(99, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(radioButton1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(radioButton2))
                                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                                .addGap(64, 64, 64)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addContainerGap(69, Short.MAX_VALUE)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2)
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1))
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button2)
                                        .addComponent(label4)
                                        .addComponent(radioButton2)
                                        .addComponent(radioButton1)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(button3)
                                                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label5))
                                                .addGap(16, 16, 16))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label6))
                                                .addContainerGap(15, Short.MAX_VALUE))))
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
    private JTextField textField3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label5;
    private JComboBox comboBox2;
    private JLabel label6;
    private JPasswordField passwordField1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
