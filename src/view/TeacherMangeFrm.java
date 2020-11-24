/*
 * Created by JFormDesigner on Tue Nov 17 20:06:07 CST 2020
 */

package view;

import dao.ClassDao;
import dao.TeacherDao;
import model.Teacher;
import sun.applet.Main;
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
public class TeacherMangeFrm extends JInternalFrame {
    public TeacherMangeFrm() {
        setBounds(100,50,765,570);
        initComponents();
        setTable(new Teacher());
    }

    //查询
    private void button1ActionPerformed(ActionEvent e) {
        Teacher t = new Teacher();
        t.setName(textField1.getText().toString());
        setTable(t);
    }

    //表格显示数据
    private void setTable(Teacher teacher){
        if ("教师".equals(MainFrm.userType.getName())){
           Teacher tLogined = (Teacher) MainFrm.userObject;
           teacher.setName(tLogined.getName());
            textField1.setText(teacher.getName());
        }
        DefaultTableModel dft =(DefaultTableModel)table1.getModel();
        dft.setRowCount(0);
        TeacherDao teacherDao = new TeacherDao();
        List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
        for (Teacher s: teacherList){
            Vector v = new Vector();
            v.add(s.getId());
            v.add(s.getName());
            v.add(s.getPassword());
            v.add(s.getSex());
            v.add(s.getTitle());
            dft.addRow(v);
        }
        teacherDao.closeDao();
        setAuthority();
    }





    //删除数据
    private void button3ActionPerformed(ActionEvent e) {
        int row = table1.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(this,"请选中要删除的数据！");
            return;
        }
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(table1.getValueAt(row,0).toString()));
        TeacherDao teacherDao = new TeacherDao();
        if (teacherDao.deleteTeacher(teacher.getId())){
            JOptionPane.showMessageDialog(this,"删除成功！");
        }else {
            JOptionPane.showMessageDialog(this,"删除失败！");
        }
        teacherDao.closeDao();
        setTable(teacher);

    }



    //把数据显示在输入框
    private void table1MouseClicked(MouseEvent e) {
        DefaultTableModel dft = (DefaultTableModel)table1.getModel();
        textField2.setText(dft.getValueAt(table1.getSelectedRow(),1).toString());
        textField4.setText(dft.getValueAt(table1.getSelectedRow(),2).toString());
        String sex = dft.getValueAt(table1.getSelectedRow(),3).toString();
        if (sex.equals(radioButton1.getText()))
        {radioButton1.setSelected(true) ;
            radioButton2.setSelected(false);
        }else {
            radioButton1.setSelected(false) ;
            radioButton2.setSelected(true);
        }
        textField5.setText(dft.getValueAt(table1.getSelectedRow(),4).toString());
    }


    //确认修改数据
    private void button2ActionPerformed(ActionEvent e) {
        String TeacherName = textField2.getText();
        String TeacherPassword = textField4.getText().toString();
        if (table1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this,"请选中要删除的数据！");
            return;
        }
        if (StringUtil.isEmpty(TeacherName)){
            JOptionPane.showMessageDialog(this,"请输入学生姓名！");
            return;
        }
        if (StringUtil.isEmpty(TeacherPassword)){
            JOptionPane.showMessageDialog(this,"请填写密码！");
            return;
        }
        String title = textField5.getText();
        Teacher teacher = new Teacher();
        teacher.setId(Integer.parseInt(table1.getValueAt(table1.getSelectedRow(), 0).toString()));
        teacher.setName(TeacherName);
        teacher.setPassword(TeacherPassword);
        if (radioButton1.isSelected()) teacher.setSex(radioButton1.getText().toString());
        if (radioButton2.isSelected()) teacher.setSex(radioButton2.getText().toString());
        teacher.setTitle(title);
        TeacherDao teacherDao = new TeacherDao();
        if (teacherDao.update(teacher)){
            JOptionPane.showMessageDialog(this,"修改成功！");
        }else{
            JOptionPane.showMessageDialog(this,"修改失败！");
        }
        teacherDao.closeDao();
        setTable(new Teacher());
    }


    private void setAuthority(){
        if ("教师".equals(MainFrm.userType.getName())){
            button3.setEnabled(false);
            textField1.setEnabled(false);
        }
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label7 = new JLabel();
        textField5 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u6559\u5e08\u540d\u5b57\uff1a");

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
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "\u6559\u5e08ID", "\u6559\u5ba4\u540d\u5b57", "\u767b\u5f55\u5bc6\u7801", "\u6559\u5e08\u6027\u522b", "\u6559\u5e08\u804c\u79f0"
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

        //---- label2 ----
        label2.setText("\u6559\u5e08\u540d\u5b57\uff1a");

        //---- label5 ----
        label5.setText("\u767b\u5f55\u5bc6\u7801\uff1a");

        //---- label6 ----
        label6.setText("\u6559\u5e08\u6027\u522b\uff1a");

        //---- radioButton1 ----
        radioButton1.setText("\u7537");

        //---- radioButton2 ----
        radioButton2.setText("\u5973");

        //---- label7 ----
        label7.setText("\u6559\u5e08\u804c\u79f0\uff1a");

        //---- button2 ----
        button2.setText("\u786e\u8ba4\u4fee\u6539");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("\u5220\u9664\u4fe1\u606f");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(195, 195, 195)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGap(59, 59, 59)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label6, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addComponent(label7, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(radioButton1)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioButton2))
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                            .addGap(57, 57, 57)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6)
                        .addComponent(radioButton1)
                        .addComponent(radioButton2)
                        .addComponent(button2))
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3))
                    .addContainerGap(62, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label7;
    private JTextField textField5;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
