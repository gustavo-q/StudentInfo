/*
 * Created by JFormDesigner on Sun Nov 08 16:48:11 CST 2020
 */

package view;

import dao.ClassDao;
import dao.StudentDao;
import model.Student;
import model.StudentClass;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class AddStudentFrm extends JInternalFrame {

    public AddStudentFrm() {
        this.setBounds(200, 50, 440, 330);
        initComponents();
        setStudentClassInfo();

    }


    //重置
    private void button2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        comboBox1.setSelectedIndex(0);
        passwordField1.setText("");
        radioButton1.setSelected(true);
        radioButton2.setSelected(false);


    }

    //设置所属班级
    private void setStudentClassInfo() {
        ClassDao classDao = new ClassDao();
        List<StudentClass> classList = classDao.getClassList(new StudentClass());
        for (StudentClass sc : classList) {
            comboBox1.addItem(sc);
        }
        classDao.closeDao();
    }



    //添加学生
    private void button1ActionPerformed(ActionEvent e) {

        String studentName = textField1.getText().toString();
        String studentPassword = passwordField1.getText().toString();
        if (StringUtil.isEmpty(studentName)) {
            JOptionPane.showMessageDialog(this, "请输入学生姓名：");
            return;
        }
        if (StringUtil.isEmpty(studentPassword)) {
            JOptionPane.showMessageDialog(this, "请输入密码：");
            return;
        }
        StudentClass sc = (StudentClass) comboBox1.getSelectedItem();
        String sex = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
        Student student = new Student();
        student.setName(studentName);
        student.setClassId(sc.getId());
        student.setSex(sex);
        student.setPassword(studentPassword);
        StudentDao studentDao = new StudentDao();
        if (studentDao.addStudent(student)) {
            JOptionPane.showMessageDialog(this, "添加成功！");
        } else {
            JOptionPane.showMessageDialog(this, "添加失败！");
        }
        button2ActionPerformed(e);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("\u6dfb\u52a0\u5b66\u751f");
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5b66\u751f\u59d3\u540d\uff1a");
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u5b66\u751f.png")));

        //---- label2 ----
        label2.setText("\u6240\u5c5e\u73ed\u7ea7\uff1a");
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u540d\u79f0.png")));

        //---- label3 ----
        label3.setText("\u767b\u5f55\u5bc6\u7801\uff1a");
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6 \u7801 .png")));

        //---- label4 ----
        label4.setText("\u5b66\u751f\u6027\u522b\uff1a");
        label4.setIcon(new ImageIcon(getClass().getResource("/images/\u6027\u522b.png")));

        //---- radioButton1 ----
        radioButton1.setText("\u7537");
        radioButton1.setSelected(true);

        //---- radioButton2 ----
        radioButton2.setText("\u5973");

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(button2)
                            .addGap(0, 17, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(button1))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboBox1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                    .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(radioButton1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(radioButton2)
                                    .addGap(28, 28, 28)))))
                    .addGap(115, 115, 115))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton1)
                        .addComponent(label4)
                        .addComponent(radioButton2))
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JLabel label3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
