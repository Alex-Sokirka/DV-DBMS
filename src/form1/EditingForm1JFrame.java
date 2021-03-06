/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form1;

import functionality.AddingForm;
import functionality.GetSetInformation;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ihorg
 */
public class EditingForm1JFrame extends javax.swing.JFrame {
   
    //VARIABLES
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static String[][] tableDataArr;
    private static AddingForm addingForm;
    private static final String tableName = "clients";
    private static Integer currentRow,currentId;
    private static final String host = "smtp.gmail.com";
    private static final String sender = "ihorgalyn452@gmail.com";
    private static final String password = "vamga2003";
    private static String recipient = "";
    private static final String subject = "Додавання до клієнтської бази";
    private static String text = "";
    private static final String image = GetSetInformation.generalPath+"\\photodb\\approved.png";

    /**
     * Creates new form EditingForm1JFrame
     */
    public EditingForm1JFrame() {
        initComponents();
        setInterfaceSettings();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        tableDataArr = new String[GetSetInformation.getRowCount()][GetSetInformation.getColCount()];
        currentRow = GetSetInformation.getCurrentRow();
        currentId = GetSetInformation.getCurrentId();
        DataPreparing();
        addingForm = new AddingForm();
        setDataOnTextFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        save = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        exit = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Редагування запису клієнта");

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photodb/save.png"))); // NOI18N
        save.setContentAreaFilled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photodb/cancel.png"))); // NOI18N
        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel2.setText("Прізвище");

        jLabel3.setText("Ім'я");

        jLabel4.setText("По батькові");

        jLabel5.setText("Відвідування");

        jLabel6.setText("Місто");

        jLabel7.setText("Дата народження");

        jLabel8.setText("Телефон");

        prev.setText("<");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel9.setText("Пошта");

        jLabel10.setText("Стать");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("чол");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("жін");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //DATA PREPARING
    private void DataPreparing() {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dvdb","Halyn","123");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from "+tableName);
            while(rs.next()) {
                for(int j = 0;j<GetSetInformation.getColCount();j++){
                    tableDataArr[rs.getRow()-1][j] = rs.getString(j+1);
                }
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    //SETS DATA ON TEXTFIELDS
    private void setDataOnTextFields() {
        jTextField1.setText(tableDataArr[currentRow][1]);
        jTextField2.setText(tableDataArr[currentRow][2]);
        jTextField3.setText(tableDataArr[currentRow][3]);
        jTextField4.setText(tableDataArr[currentRow][4]);
        jTextField5.setText(tableDataArr[currentRow][5]);
        jTextField6.setText(tableDataArr[currentRow][6]);
        jTextField7.setText(tableDataArr[currentRow][7]);
        jTextField8.setText(tableDataArr[currentRow][8]);
        if(tableDataArr[currentRow][9].equals("чол")){
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
        }
    }
    //SAVE
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            stmt = conn.createStatement();
            jRadioButton1.setActionCommand("чол");
            jRadioButton2.setActionCommand("жін");
            recipient = jTextField8.getText();
            text = jTextField1.getText()+" "+jTextField2.getText()+", Вітаємо, вас додано до клієнтської бази медичного центру \"ДВ\"";
            String gender = buttonGroup1.getSelection().getActionCommand();
            String s = "update "+tableName+" set surname ='"+jTextField1.getText()+"',name='"+jTextField2.getText()+"',mid_name='"+jTextField3.getText()+"',visit_count="+jTextField4.getText()+",city='"+jTextField5.getText()+"',date_of_birth='"+jTextField6.getText()+"',phone='"+jTextField7.getText()+"',email='"+jTextField8.getText()+"',gender='"+gender+"' where act_id ="+currentId;
            stmt.executeUpdate(s);   
            addingForm.sendMessageToEmail(host, sender, password, recipient, subject, text, image);
        } catch (SQLException ex) {
            Logger.getLogger(EditingForm1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed
    //EXIT
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        new Form1JFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_exitActionPerformed
    //PREV
    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
       if (currentRow == 0){
           currentRow = GetSetInformation.getRowCount()-1;
           currentId = Integer.parseInt(tableDataArr[currentRow][0]);
       }
       else {
           currentRow-=1;
           currentId = Integer.parseInt(tableDataArr[currentRow][0]);
       }
       setDataOnTextFields();
    }//GEN-LAST:event_prevActionPerformed
    //NEXT
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
       if (currentRow == GetSetInformation.getRowCount()-1){
           currentRow = 0;
           currentId = Integer.parseInt(tableDataArr[currentRow][0]);
       }
       else {
           currentRow+=1;
           currentId = Integer.parseInt(tableDataArr[currentRow][0]);
       }
       setDataOnTextFields();
    }//GEN-LAST:event_nextActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditingForm1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditingForm1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditingForm1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditingForm1JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditingForm1JFrame().setVisible(true);
                
            }
        });
    }
    
    private void setInterfaceSettings() {
        //THEME
        getContentPane().setBackground(GetSetInformation.getFormBackground());
        jTextField1.setBackground(GetSetInformation.getElementBackground());
        jTextField2.setBackground(GetSetInformation.getElementBackground());
        jTextField3.setBackground(GetSetInformation.getElementBackground());
        jTextField4.setBackground(GetSetInformation.getElementBackground());
        jTextField5.setBackground(GetSetInformation.getElementBackground());
        jTextField6.setBackground(GetSetInformation.getElementBackground());
        jTextField7.setBackground(GetSetInformation.getElementBackground());
        jTextField8.setBackground(GetSetInformation.getElementBackground());
        prev.setBackground(GetSetInformation.getElementBackground());
        next.setBackground(GetSetInformation.getElementBackground());
        jTextField1.setForeground(GetSetInformation.getForeGround());
        jTextField2.setForeground(GetSetInformation.getForeGround());
        jTextField3.setForeground(GetSetInformation.getForeGround());
        jTextField4.setForeground(GetSetInformation.getForeGround());
        jTextField5.setForeground(GetSetInformation.getForeGround());
        jTextField6.setForeground(GetSetInformation.getForeGround());
        jTextField7.setForeground(GetSetInformation.getForeGround());
        jTextField8.setForeground(GetSetInformation.getForeGround());
        jLabel2.setForeground(GetSetInformation.getForeGround());
        jLabel3.setForeground(GetSetInformation.getForeGround());
        jLabel4.setForeground(GetSetInformation.getForeGround());
        jLabel5.setForeground(GetSetInformation.getForeGround());
        jLabel6.setForeground(GetSetInformation.getForeGround());
        jLabel7.setForeground(GetSetInformation.getForeGround());
        jLabel8.setForeground(GetSetInformation.getForeGround());
        jLabel9.setForeground(GetSetInformation.getForeGround());
        jLabel10.setForeground(GetSetInformation.getForeGround());
        prev.setBackground(GetSetInformation.getElementBackground());
        next.setBackground(GetSetInformation.getElementBackground());
        //LANGUAGE
        if(GetSetInformation.getAppLanguage()==1) {
            jLabel2.setText("Surname");
            jLabel3.setText("Name");
            jLabel4.setText("Mid name");
            jLabel5.setText("Visit count");
            jLabel6.setText("City");
            jLabel7.setText("Birth date");
            jLabel8.setText("Phone");
            jLabel9.setText("Email");
            jLabel10.setText("Gender");
            jRadioButton1.setText("male");
            jRadioButton2.setText("female");
        }
        //TEXT
        jLabel2.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel3.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel4.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel5.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel6.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel7.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel8.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jLabel10.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jRadioButton1.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jRadioButton2.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField1.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField2.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField3.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField4.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField5.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField6.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField7.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
        jTextField8.setFont(new Font(GetSetInformation.getTextFont(), GetSetInformation.getTextType(), GetSetInformation.getTextSize()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
