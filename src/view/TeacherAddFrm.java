/*
 * Created by JFormDesigner on Tue Nov 17 20:05:48 CST 2020
 */

package view;

import dao.TeacherDao;
import model.Teacher;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class TeacherAddFrm extends JInternalFrame {
    public TeacherAddFrm() {
        setBounds(200, 50,445,340);
        initComponents();
    }

    //重置
    private void button2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        radioButton1.setSelected(true);
        radioButton2.setSelected(false);
    }

    //添加老师
    private void button1ActionPerformed(ActionEvent e) {
        String teacherName = textField1.getText().toString();
        String  passWord = textField2.getText().toString();
        String title = textField3.getText().toString();
        String sex = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
        if (StringUtil.isEmpty(teacherName)){
            JOptionPane.showMessageDialog(this,"请输入教师姓名");
        }
        if (StringUtil.isEmpty(passWord)){
            JOptionPane.showMessageDialog(this,"请输入登录密码");
        }
        if (StringUtil.isEmpty(title)){
            JOptionPane.showMessageDialog(this,"请输入教师职称");
        }
        Teacher teacher = new Teacher();
        teacher.setName(teacherName);
        teacher.setSex(sex);
        teacher.setTitle(title);
        teacher.setPassword(passWord);
        TeacherDao teacherDao = new TeacherDao();

        if (teacherDao.addTeacher(teacher)){
            JOptionPane.showMessageDialog(this,"添加成功");
        }else{
            JOptionPane.showMessageDialog(this,"添加失败");
        }
        teacherDao.closeDao();
        button2ActionPerformed(e);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setPreferredSize(new Dimension(445, 340));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8001\u5e08\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u767b\u5f55\u5bc6\u7801:");

        //---- label3 ----
        label3.setText("\u6559\u5e08\u804c\u79f0\uff1a");

        //---- textField3 ----
        textField3.setPreferredSize(new Dimension(65, 25));

        //---- label4 ----
        label4.setText("\u6559\u5e08\u6027\u522b\uff1a");
        label4.setIcon(new ImageIcon(getClass().getResource("/images/\u6027\u522b.png")));

        //---- radioButton1 ----
        radioButton1.setText("\u7537");
        radioButton1.setSelected(true);

        //---- radioButton2 ----
        radioButton2.setText("\u5973");

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
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
                            .addGap(91, 91, 91)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                            .addGap(65, 65, 65))
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(45, 45, 45)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(radioButton1)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioButton2))
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(115, 115, 115)
                                    .addComponent(button1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
                            .addGap(62, 62, 62)
                            .addComponent(button2)))
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton1)
                        .addComponent(radioButton2)
                        .addComponent(label4))
                    .addGap(36, 36, 36)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
