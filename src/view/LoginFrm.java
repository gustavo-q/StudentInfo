/*
 * Created by JFormDesigner on Tue Oct 27 20:07:44 CST 2020
 */

package view;

import javax.swing.event.*;
import javax.swing.plaf.*;

import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Student;
import model.Teacher;
import model.UserType;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author 1
 */
public class LoginFrm extends JFrame {
    public LoginFrm() {
        initComponents();
    }

    //重置按钮功能实现
    private void button2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
        comboBox1.setSelectedIndex(0);
    }


//登录按钮功能实现
    private void button1ActionPerformed(ActionEvent e) {

        String userName = textField1.getText().toString();
        String passWord = textField2.getText().toString();
        UserType selectedIndex = (UserType)comboBox1.getSelectedItem();
        if(StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(this,"用户名不能为空");
            return;
        }
        if(StringUtil.isEmpty(passWord)){
            JOptionPane.showMessageDialog(this,"密码不能为空");
            return;
        }
        Admin admin = null;
        Student student = null;
        Teacher teacher = null;
        if ("系统管理员".equals(selectedIndex.getName())){
            //系统管理员登录
            AdminDao adminDao = new AdminDao();
            Admin adminTmp = new Admin();
            adminTmp.setName(userName);
            adminTmp.setPassword(passWord);
            admin = adminDao.login(adminTmp);
//            System.out.println(admin.toString());
            adminDao.closeDao();
            if (admin == null){
                JOptionPane.showMessageDialog(this,"用户或密码错误！");
                return;
            }
            JOptionPane.showMessageDialog(this,"欢迎["+selectedIndex.getName()+"]:"+admin.getName()+"登录本系统！");
            this.dispose();
            new MainFrm(selectedIndex,admin).setVisible(true);
        }else if("教师".equals(selectedIndex.getName())){
            //教师登录
            TeacherDao teacherDao = new TeacherDao();
            Teacher teacherTmp = new Teacher();
            teacherTmp.setName(userName);
            teacherTmp.setPassword(passWord);
            teacher = teacherDao.login(teacherTmp);
            teacherDao.closeDao();
            if (teacher == null){
                JOptionPane.showMessageDialog(this,"用户或密码错误！");
                return;
            }
            JOptionPane.showMessageDialog(this,"欢迎["+selectedIndex.getName()+"]:"+teacher.getName()+"登录本系统！");
            this.dispose();
            new MainFrm(selectedIndex,teacher).setVisible(true);
        }else if("学生".equals(selectedIndex.getName())){
//            学生登录
            StudentDao studentDao = new StudentDao();
            Student studentTmp = new Student();
            studentTmp.setName(userName);
            studentTmp.setPassword(passWord);
            student = studentDao.login(studentTmp);
//            System.out.println(admin.toString());
            studentDao.closeDao();
            if (student == null){
                JOptionPane.showMessageDialog(this,"用户或密码错误！");
                return;
            }
            JOptionPane.showMessageDialog(this,"欢迎["+selectedIndex.getName()+"]:"+student.getName()+"登录本系统！");
            this.dispose();
            new MainFrm(selectedIndex,student).setVisible(true);
        }
    }

    private void button1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }







    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        comboBox1 = new JComboBox<>();

        //======== this ========
        setTitle("\u767b\u5f55\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u7528\u6237\u540d\uff1a");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
                label1.setIcon(new ImageIcon(getClass().getResource("/images/\u7528\u6237.png")));

                //---- label2 ----
                label2.setText("\u5bc6\u7801\uff1a");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
                label2.setIcon(new ImageIcon(getClass().getResource("/images/\u5bc6 \u7801 .png")));

                //---- label3 ----
                label3.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
                label3.setIcon(new ImageIcon(getClass().getResource("/images/\u5f3a\u529b.png")));
                label3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
                label3.setBackground(new Color(238, 238, 238));

                //---- button1 ----
                button1.setText("\u767b\u5f55");
                button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
                button1.setIcon(new ImageIcon(getClass().getResource("/images/\u767b\u5f55.png")));
                button1.addAncestorListener(new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent e) {
                        button1AncestorAdded(e);
                    }
                    @Override
                    public void ancestorMoved(AncestorEvent e) {}
                    @Override
                    public void ancestorRemoved(AncestorEvent e) {}
                });
                button1.addActionListener(e -> button1ActionPerformed(e));

                //---- button2 ----
                button2.setText("\u91cd\u7f6e");
                button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 3f));
                button2.setIcon(new ImageIcon(getClass().getResource("/images/\u91cd\u7f6e.png")));
                button2.addActionListener(e -> button2ActionPerformed(e));

                //---- label4 ----
                label4.setText("\u7528\u6237\u7c7b\u578b\uff1a");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
                label4.setIcon(new ImageIcon(getClass().getResource("/images/user-type.png")));

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel(new UserType[] {
                    UserType.ADMIN,
                        UserType.TEACHER,
                        UserType.STUDENT
                }));
                comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 3f));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(94, 94, 94)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label2)
                                                .addComponent(label1)))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(95, 95, 95)
                                            .addComponent(button1)))
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(47, Short.MAX_VALUE))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 229, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(34, 34, 34)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addGap(25, 25, 25)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addGap(26, 26, 26)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(24, 24, 24))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JComboBox<String> comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LoginFrm frame = new LoginFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
