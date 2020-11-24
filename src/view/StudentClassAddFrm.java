/*
 * Created by JFormDesigner on Thu Nov 05 15:49:20 CST 2020
 */

package view;

import dao.ClassDao;
import model.StudentClass;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 1
 */
public class StudentClassAddFrm extends JInternalFrame {
    public StudentClassAddFrm() {

        this.setBounds(200,100,400,300);
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        textArea1.setText("");
    }

    private void button1ActionPerformed(ActionEvent e) {
        String className = textField1.getText().toString();
        String classInfo = textArea1.getText().toString();
        if (StringUtil.isEmpty(className)){
            JOptionPane.showMessageDialog(this,"班级名称不能为空");
            return;
        }
        StudentClass scl = new StudentClass();
        scl.setName(className);
        scl.setInfo(classInfo);
        ClassDao classDao = new ClassDao();
        if (classDao.addClass(scl)){
            JOptionPane.showMessageDialog(this,"班级添加成功！");

        }else {
            JOptionPane.showMessageDialog(this,"班级添加失败！");
        }
        classDao.closeDao();
        button2ActionPerformed(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u73ed\u7ea7\u4fe1\u606f");
        setPreferredSize(new Dimension(400, 300));
        setMaximizable(true);
        setClosable(true);
        setVisible(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u73ed\u7ea7\u540d\u79f0\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u540d\u79f0.png")));

        //---- label2 ----
        label2.setText("\u73ed\u7ea7\u4fe1\u606f\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        label2.setIcon(new ImageIcon(getClass().getResource("/images/\u73ed\u7ea7\u4fe1\u606f.png")));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.setIcon(new ImageIcon(getClass().getResource("/images/\u63d0 \u4ea4.png")));
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
                            .addGap(46, 46, 46)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(26, 26, 26)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane1)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(button1)
                            .addGap(81, 81, 81)
                            .addComponent(button2)))
                    .addContainerGap(56, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
