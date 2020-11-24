/*
 * Created by JFormDesigner on Wed Oct 28 11:05:41 CST 2020
 */

package view;

import java.awt.event.*;

import model.StudentClass;
import model.UserType;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class MainFrm extends JFrame {
    public static UserType userType;
    public static Object userObject;



    public MainFrm(UserType userType,Object userObject) {
        this.userType = userType;
        this.userObject = userObject;
        initComponents();
        setAuthority();
    }


    //退出系统
    private void menuItem2ActionPerformed(ActionEvent e) {
//        this.dispose();
////        new LoginFrm().setVisible(true);
        if (JOptionPane.showConfirmDialog(MainFrm.this,"确认退出么？")== JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }


    //修改密码
    private void menuItem1ActionPerformed(ActionEvent e) {
        EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
        editPasswordFrm.setVisible(true);
        desktopPane1.add(editPasswordFrm);
    }

    //班级添加
    private void menuItem5ActionPerformed(ActionEvent e) {
        StudentClassAddFrm sca = new StudentClassAddFrm();
        sca.setVisible(true);
        desktopPane1.add(sca);
    }

    //班级列表
    private void menuItem6ActionPerformed(ActionEvent e) {
        ClassManageFrm cm = new ClassManageFrm();
        cm.setVisible(true);
        desktopPane1.add(cm);
    }

    //学生添加
    private void menuItem3ActionPerformed(ActionEvent e) {
        AddStudentFrm af= new AddStudentFrm();
        af.setVisible(true);
        desktopPane1.add(af);
    }

    //学生列表
    private void menuItem4ActionPerformed(ActionEvent e) {
        StudentMangeFrm smf = new StudentMangeFrm();
        smf.setVisible(true);
        desktopPane1.add(smf);
    }

    //老师添加
    private void menuItem7ActionPerformed(ActionEvent e) {
        TeacherAddFrm td= new TeacherAddFrm();
        td.setVisible(true);
        desktopPane1.add(td);
    }

    //老师列表
    private void menuItem8ActionPerformed(ActionEvent e) {
        TeacherMangeFrm tm = new TeacherMangeFrm();
        tm.setVisible(true);
        desktopPane1.add(tm);
    }

    //切换登陆
    private void menuItem9ActionPerformed(ActionEvent e) {
        LoginFrm lf = new LoginFrm();
        this.dispose();
        lf.setVisible(true);
    }



    private void setAuthority(){
        if ("学生".equals(userType.getName())){
            menu3.setEnabled(false);
            menu4.setEnabled(false);
            menuItem3.setEnabled(false);
        }
        if ("教师".equals(userType.getName())){
            menuItem7.setEnabled(false);
        }
    }

    //课程添加
    private void menuItem10ActionPerformed(ActionEvent e) {
        AddCourseFrm af = new AddCourseFrm();
        af.setVisible(true);
        desktopPane1.add(af);
    }

    //课程列表
    private void menuItem11ActionPerformed(ActionEvent e) {
        CourseMangeFrm cmf = new CourseMangeFrm();
        cmf.setVisible(true);
        desktopPane1.add(cmf);
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu4 = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu5 = new JMenu();
        menuItem10 = new JMenuItem();
        menuItem11 = new JMenuItem();
        panel1 = new JPanel();
        desktopPane1 = new JDesktopPane();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf\u8bbe\u7f6e");
                menu1.setIcon(new ImageIcon(getClass().getResource("/images/\u8bbe \u7f6e.png")));

                //---- menuItem1 ----
                menuItem1.setText("\u4fee\u6539\u5bc6\u7801");
                menuItem1.setIcon(new ImageIcon(getClass().getResource("/images/\u4fee\u6539\u5bc6\u7801.png")));
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);

                //---- menuItem9 ----
                menuItem9.setText("\u5207\u6362\u8d26\u53f7");
                menuItem9.setIcon(new ImageIcon(getClass().getResource("/images/\u5207\u6362\u8d26\u53f7.png")));
                menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
                menu1.add(menuItem9);

                //---- menuItem2 ----
                menuItem2.setText("\u9000\u51fa\u7cfb\u7edf");
                menuItem2.setIcon(new ImageIcon(getClass().getResource("/images/\u9000\u51fa.png")));
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5b66\u751f\u7ba1\u7406");
                menu2.setIcon(new ImageIcon(getClass().getResource("/images/\u57fa\u7840 \u7ba1   \u7406.png")));

                //---- menuItem3 ----
                menuItem3.setText("\u5b66\u751f\u6dfb\u52a0");
                menuItem3.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("\u5b66\u751f\u5217\u8868");
                menuItem4.setIcon(new ImageIcon(getClass().getResource("/images/\u5217\u8868.png")));
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);

            //======== menu4 ========
            {
                menu4.setText("\u8001\u5e08\u7ba1\u7406");
                menu4.setIcon(new ImageIcon(getClass().getResource("/images/\u57fa\u7840 \u7ba1   \u7406.png")));

                //---- menuItem7 ----
                menuItem7.setText("\u8001\u5e08\u6dfb\u52a0");
                menuItem7.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0.png")));
                menuItem7.addActionListener(e -> menuItem7ActionPerformed(e));
                menu4.add(menuItem7);

                //---- menuItem8 ----
                menuItem8.setText("\u8001\u5e08\u5217\u8868");
                menuItem8.setIcon(new ImageIcon(getClass().getResource("/images/\u5217\u8868.png")));
                menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                menu4.add(menuItem8);
            }
            menuBar1.add(menu4);

            //======== menu3 ========
            {
                menu3.setText("\u73ed\u7ea7\u7ba1\u7406");
                menu3.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7.png")));

                //---- menuItem5 ----
                menuItem5.setText("\u73ed\u7ea7\u6dfb\u52a0");
                menuItem5.setIcon(new ImageIcon(getClass().getResource("/images/\u6dfb\u52a0_\u73ed\u7ea7\u6dfb\u52a0.png")));
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menu3.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("\u73ed\u7ea7\u5217\u8868");
                menuItem6.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u5217\u8868.png")));
                menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
                menu3.add(menuItem6);
            }
            menuBar1.add(menu3);

            //======== menu5 ========
            {
                menu5.setText("\u8bfe\u7a0b\u7ba1\u7406");

                //---- menuItem10 ----
                menuItem10.setText("\u6dfb\u52a0\u8bfe\u7a0b");
                menuItem10.addActionListener(e -> menuItem10ActionPerformed(e));
                menu5.add(menuItem10);

                //---- menuItem11 ----
                menuItem11.setText("\u8bfe\u7a0b\u5217\u8868");
                menuItem11.addActionListener(e -> menuItem11ActionPerformed(e));
                menu5.add(menuItem11);
            }
            menuBar1.add(menu5);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //======== desktopPane1 ========
            {
                desktopPane1.setBackground(new Color(204, 204, 204));
            }
            panel1.add(desktopPane1, BorderLayout.CENTER);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem9;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenu menu4;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu5;
    private JMenuItem menuItem10;
    private JMenuItem menuItem11;
    private JPanel panel1;
    private JDesktopPane desktopPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
