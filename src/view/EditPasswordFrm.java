/*
 * Created by JFormDesigner on Thu Oct 29 16:54:44 CST 2020
 */

package view;

import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Student;
import model.Teacher;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class EditPasswordFrm extends JInternalFrame {
    public EditPasswordFrm() {
        this.setBounds(200,100,450,350);
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }

    private void button1ActionPerformed(ActionEvent e) {
        String oldPassword =textField1.getText().toString();
        String newPassword = textField2.getText().toString();
        String conformPassword = textField3.getText().toString();
        if (StringUtil.isEmpty(oldPassword)){
            JOptionPane.showMessageDialog(this,"请输入原密码！");
            return;
        }
        if (StringUtil.isEmpty(newPassword)){
            JOptionPane.showMessageDialog(this,"请输入新密码！");
            return;
        }
        if (StringUtil.isEmpty(conformPassword)){
            JOptionPane.showMessageDialog(this,"请输入确认密码！");
            return;
        }
        if (!newPassword.equals(conformPassword)){
            JOptionPane.showMessageDialog(this,"两次密码输入不一致！");
            return;
        }
        if ("系统管理员".equals(MainFrm.userType.getName())){

           AdminDao adminDao = new AdminDao();
           Admin adminTmp = new Admin();
           Admin admin= (Admin) MainFrm.userObject;
           adminTmp.setName(admin.getName());
           adminTmp.setPassword(oldPassword);
           JOptionPane.showMessageDialog(this,adminDao.editPassword(adminTmp,newPassword));
           adminDao.closeDao();
           return;
        }
        if ("学生".equals(MainFrm.userType.getName())){

            StudentDao studentDao = new StudentDao();
            Student studentTmp = new Student();
            Student student= (Student) MainFrm.userObject;
            studentTmp.setName(student.getName());
            studentTmp.setPassword(oldPassword);
            JOptionPane.showMessageDialog(this,studentDao.editPassword(studentTmp,newPassword));
            studentDao.closeDao();
            return;
        }
        if ("教师".equals(MainFrm.userType.getName())){

            TeacherDao teacherDao = new TeacherDao();
            Teacher teacherTmp = new Teacher();
            Teacher teacher= (Teacher) MainFrm.userObject;
            teacherTmp.setName(teacher.getName());
            teacherTmp.setPassword(oldPassword);
            JOptionPane.showMessageDialog(this,teacherDao.editPassword(teacherTmp,newPassword));
            teacherDao.closeDao();
            return;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("\u4fee\u6539\u5bc6\u7801");
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new Dimension(450, 350));
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5f53\u524d\u7528\u6237\uff1a");
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237.png")));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

        //---- label3 ----
        label3.setText("\u539f\u5bc6\u7801   \uff1a");
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6 \u7801 .png")));
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

        //---- label4 ----
        label4.setText("\u65b0\u5bc6\u7801   \uff1a");
        label4.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539\u5bc6\u7801.png")));
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- label5 ----
        label5.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label5.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539\u5bc6\u7801.png")));
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u786e\u8ba4.png")));
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(button1)))
                    .addGap(54, 54, 54)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(button2)))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        if ("系统管理员".equals(MainFrm.userType.getName())){
            Admin admin = (Admin)MainFrm.userObject;
            label2.setText("[系统管理员]"+admin.getName());
        }
        if ("学生".equals(MainFrm.userType.getName())){
            Student student = (Student) MainFrm.userObject;
            label2.setText("[学生]"+student.getName());
        }
        if ("教师".equals(MainFrm.userType.getName())){
            Teacher teacher = (Teacher) MainFrm.userObject;
            label2.setText("[教师]"+teacher.getName());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
