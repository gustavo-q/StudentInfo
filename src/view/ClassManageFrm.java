/*
 * Created by JFormDesigner on Sat Nov 07 20:30:28 CST 2020
 */

package view;

import java.awt.event.*;
import java.beans.*;

import dao.ClassDao;
import model.StudentClass;
import util.StringUtil;

import java.awt.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author 1
 */
public class ClassManageFrm extends JInternalFrame {
    public ClassManageFrm() {
        this.setBounds(200,50,700,500);
        initComponents();
        setTable(new StudentClass());
    }



    //查询
    private void button1ActionPerformed(ActionEvent e) {
        StudentClass sc = new StudentClass();
        sc.setName(textField1.getText().toString());
        setTable(sc);
    }



    //把数据显示在输入框
    private void table1MouseClicked(MouseEvent e) {
        DefaultTableModel dft = (DefaultTableModel)table1.getModel();
        textField2.setText(dft.getValueAt(table1.getSelectedRow(),1).toString());
        textArea1.setText(dft.getValueAt(table1.getSelectedRow(),2).toString());
    }


    //修改数据
    private void button2ActionPerformed(ActionEvent e) {
        ClassDao classDao = new ClassDao();
        int index = table1.getSelectedRow();
        if (index == -1){
            JOptionPane.showMessageDialog(this,"请选中要修改的数据！");
            return;
        }
        DefaultTableModel dft = (DefaultTableModel)table1.getModel();
        String className = dft.getValueAt(table1.getSelectedRow(),1).toString();
        String classInfo = dft.getValueAt(table1.getSelectedRow(),2).toString();
        String editClassName = textField2.getText().toString();
        String editClassInfo = textArea1.getText().toString();
        if (StringUtil.isEmpty(editClassName)){
            JOptionPane.showMessageDialog(this,"请填写要修改的名称");
            return;
        }
        if (className.equals(editClassName) && classInfo.equals(editClassInfo)){
            JOptionPane.showMessageDialog(this,"您还没有做任何修改！");
            return;
        }
        int id = Integer.parseInt(dft.getValueAt(table1.getSelectedRow(),0).toString());
        StudentClass sc = new StudentClass();
        sc.setId(id);
        sc.setName(editClassName);
        sc.setInfo(editClassInfo);
        if (classDao.update(sc)){
            JOptionPane.showMessageDialog(this,"更新成功！");
        }else {
            JOptionPane.showMessageDialog(this,"更新失败！");
        }
        classDao.closeDao();
        setTable(new StudentClass());
    }


    //删除
    private void button3ActionPerformed(ActionEvent e) {
        int index = table1.getSelectedRow();
        if (index == -1){
            JOptionPane.showMessageDialog(this,"请选中删除的数据");
            return;
        }
        DefaultTableModel dft = (DefaultTableModel)table1.getModel();
        int id = Integer.parseInt(dft.getValueAt(table1.getSelectedRow(),0).toString());
        ClassDao classDao = new ClassDao();
        if (classDao.delete(id)){
            JOptionPane.showMessageDialog(this,"删除成功");
        }else {
            JOptionPane.showMessageDialog(this,"删除失败！");
        }
        classDao.closeDao();
        setTable(new StudentClass());
    }

    private void scrollPane1PropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void scrollPane1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }







    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setVisible(true);
        setTitle("\u73ed\u7ea7\u4fe1\u606f\u7ba1\u7406");
        setPreferredSize(new Dimension(700, 500));
        setClosable(true);
        setMaximizable(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u73ed\u7ea7\u540d\u79f0\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u540d\u79f0.png")));

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u67e5\u8be2.png")));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.addPropertyChangeListener(e -> scrollPane1PropertyChange(e));
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scrollPane1MouseClicked(e);
                }
            });

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u73ed\u7ea7\u7f16\u53f7", "\u73ed\u7ea7\u540d\u79f0", "\u73ed\u7ea7\u4fe1\u606f\u4ecb\u7ecd"
                }
            ));
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(2).setPreferredWidth(200);
            }
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- label2 ----
        label2.setText("\u73ed\u7ea7\u540d\u79f0\uff1a");
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u540d\u79f0.png")));

        //---- label3 ----
        label3.setText("\u73ed\u7ea7\u4fe1\u606f\u4ecb\u7ecd\uff1a");
        label3.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u4fe1\u606f.png")));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea1);
        }

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
                    .addGap(74, 74, 74)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addGap(29, 29, 29)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textField2)
                                    .addGap(159, 159, 159))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(scrollPane2)
                                    .addGap(47, 47, 47)
                                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(45, 45, 45)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(button1))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(84, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(button3)))
                    .addGap(0, 42, Short.MAX_VALUE))
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
    private JLabel label3;
    private JTextField textField2;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void setTable(StudentClass studentClass){
        DefaultTableModel dft =(DefaultTableModel)table1.getModel();
        dft.setRowCount(0);
        ClassDao classDao = new ClassDao();
        List<StudentClass> classList = classDao.getClassList(studentClass);
        for (StudentClass sc: classList){
            Vector v = new Vector();
            v.add(sc.getId());
            v.add(sc.getName());
            v.add(sc.getInfo());
            dft.addRow(v);
        }
        classDao.closeDao();
    }
}
