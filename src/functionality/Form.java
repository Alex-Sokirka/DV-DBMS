package functionality;

import form1.EditingForm1JFrame;
import form1.Form1JFrame;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ihorg
 */
public class Form {
    //VARIABLES
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static JTable modelTable;
    private static String modelTableName;
    private static String[] modelHeadersNames;

    public Form(JTable table, String tableName, String[] headersNames) {
          modelTable = table;
          modelTableName = tableName;    
          modelHeadersNames = headersNames;
    }
    
    //DISPLAY TABLE
    public void displayTable() {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dvdb","Halyn","123");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from "+modelTableName);
            modelTable.setModel(DbUtils.resultSetToTableModel(rs));
            if(modelTable.getRowCount()>0){
                modelTable.setRowSelectionInterval(0, 0);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    //REFRESH TABLE
    public void refreshTable() {
        try {
            rs = stmt.executeQuery("select * from "+modelTableName);
        } catch (SQLException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            modelTable.setModel(DbUtils.resultSetToTableModel(rs));
            modelTable.removeColumn(modelTable.getColumnModel().getColumn(GetSetInformation.getColCount()-1));
            if(modelTable.getRowCount()>0){
                modelTable.setRowSelectionInterval(0, 0);
            }
        setTitlesOnHeaders();
    }
    
    //SET TITLES ON HEADERS
    public void setTitlesOnHeaders() {
        Integer col_count = GetSetInformation.getColCount();
        JTableHeader th = modelTable.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = null;
        for(int i = 0;i<col_count-1;i++)  {
            tc = tcm.getColumn(i);
            tc.setHeaderValue(modelHeadersNames[i]);
        }
    }
    
    //SINGLE FILTER
    public void singleFilter(JTextField textField, String columnName) {
        try {
            System.out.println("select * from "+modelTableName+" where "+columnName+">"+textField.getText()+"");
            rs = stmt.executeQuery("select * from "+modelTableName+" where "+columnName+">"+textField.getText()+"");
            
            modelTable.setModel(DbUtils.resultSetToTableModel(rs));
            modelTable.removeColumn(modelTable.getColumnModel().getColumn(GetSetInformation.getColCount()-1));
            if(modelTable.getRowCount()>0){
                modelTable.setRowSelectionInterval(0, 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTitlesOnHeaders();
    }
    
    //SEACRCH BY 1 COLUMN
    public void search(JTextField textField, String columnName) {
        try {
            rs = stmt.executeQuery("select * from "+modelTableName+" where "+columnName+"='"+textField.getText()+"'");
            modelTable.setModel(DbUtils.resultSetToTableModel(rs));
            modelTable.removeColumn(modelTable.getColumnModel().getColumn(GetSetInformation.getColCount()-1));
            if(modelTable.getRowCount()>0){
                modelTable.setRowSelectionInterval(0, 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTitlesOnHeaders();
    }
    
    //DELETE RECORD
    public void deleteRecord() {
        try {
            Integer currentRow = modelTable.getSelectedRow();
            String s = "delete from "+modelTableName+" where act_id ="+(modelTable.getSelectedRow()+1);
            stmt.executeUpdate(s);
            Integer row_count = modelTable.getRowCount();
            refreshTable();
            if(currentRow != row_count-1){
                for(int i=0;i<row_count-1;i++){
                    s = "update "+modelTableName+" set act_id="+(i+1)+" where id="+modelTable.getValueAt(i, 0)+"";
                    stmt.executeUpdate(s);
                }
            }
            refreshTable();
        } catch (SQLException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //DELETE IMAGE
    public void deleteImage(String imageDirectory, String imageType) {
        Integer currentRow = modelTable.getSelectedRow();
        File file = new File(GetSetInformation.generalPath+"\\"+imageDirectory+imageType+(currentRow+1)+".png");
        file.delete();
        Integer row_count = modelTable.getRowCount();
        File oldFile, newFile;
        File folder = new File(GetSetInformation.generalPath+"\\"+imageDirectory);
        File[] listOfFiles = folder.listFiles();
        if(currentRow != row_count-1){
            for(int i=0;i<listOfFiles.length;i++){
                oldFile = new File(GetSetInformation.generalPath+"\\"+imageDirectory+"\\"+listOfFiles[i].getName());
                newFile = new File(GetSetInformation.generalPath+"\\"+imageDirectory+imageType+(i+1)+".png");
                oldFile.renameTo(newFile);
            }
        }
    }
    
    //ADDING FORM OPENING
    public void addingFormOpening() {
        GetSetInformation.setRowCount(modelTable.getRowCount());
    }
    
    //EDITING FORM OPENING
    public void editingFormOpening() {
        Integer currentRow = modelTable.getSelectedRow();
        GetSetInformation.setRowCount(modelTable.getRowCount());
        GetSetInformation.setColCount(modelTable.getColumnCount());
        GetSetInformation.setCurrentRow(modelTable.getSelectedRow());
        GetSetInformation.setCurrentId((Integer) modelTable.getValueAt(currentRow, 0));
    }
    
    //FIRST
    public void firstRecord() {
        modelTable.setRowSelectionInterval(0, 0);
    }
    //PREV
    public void prevRecord() {
        Integer currentRow= modelTable.getSelectedRow();
        if(modelTable.getSelectedRow() == 0)
            modelTable.setRowSelectionInterval(modelTable.getRowCount()-1, modelTable.getRowCount()-1);
        else
            modelTable.setRowSelectionInterval(currentRow-1, currentRow-1);
    }
    //NEXT
    public void nextRecord() {
        Integer currentRow = modelTable.getSelectedRow();
        if(modelTable.getSelectedRow() == modelTable.getRowCount()-1)
            modelTable.setRowSelectionInterval(0, 0);
        else
            modelTable.setRowSelectionInterval(currentRow+1, currentRow+1);
    }
    //LAST
    public void lastRecord() {
        modelTable.setRowSelectionInterval(modelTable.getRowCount()-1, modelTable.getRowCount()-1);
    }
    
    //GRANT ADMIN ACCESS
    public void grantAdminAccess(JLabel label) {
        try {
            Integer currentRow = modelTable.getSelectedRow();
            if(currentRow != 0) {
                stmt = conn.createStatement();
                String s = "update users set access ='admin' where act_id="+(currentRow+1);
                stmt.executeUpdate(s);  
                refreshTable();
            } else {
                label.setText("Ви не можете змінювати доступ для первинного користувача!");            
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditingForm1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //GRANT READER ACCESS
    public void grantReaderAccess(JLabel label) {
        try {
            Integer currentRow = modelTable.getSelectedRow();
            if(currentRow != 0) {
                stmt = conn.createStatement();
                String s = "update users set access ='reader' where act_id="+(currentRow+1);
                stmt.executeUpdate(s);        
                refreshTable();
            } else {
                label.setText("Ви не можете змінювати доступ для первинного користувача!");            
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditingForm1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //PHOTO VIEWER FORM OPENING
    public void photoViewerFormOpening() {
        GetSetInformation.setRowCount(modelTable.getRowCount());
        GetSetInformation.setCurrentRow(modelTable.getSelectedRow());
    }
    
    //TRIPLE FILTER
    public void tripleFilter(String fPs, String sPs, String tPs, JTextField f1,JTextField f2,JTextField f3) {
        String fP="",sP="",tP="";
        try {
            if(!f1.getText().equals("")){
                fP=fPs+"="+""+f1.getText()+"";
                if(!f2.getText().equals("") || !f3.getText().equals("")) {
                    fP+=" AND ";
                }
            }
            if(!f2.getText().equals("")){
                sP=sPs+"="+"'"+f2.getText()+"'";
                if(!f3.getText().equals("")){
                    sP+=" AND ";
                }
            }
            if(!f3.getText().equals("")){
                tP=tPs+"="+"'"+f3.getText()+"'";
            }
            String s = "select * from "+modelTableName+" where "+fP+sP+tP;
            rs = stmt.executeQuery(s);
            modelTable.setModel(DbUtils.resultSetToTableModel(rs));
            modelTable.removeColumn(modelTable.getColumnModel().getColumn(GetSetInformation.getColCount()-1));
            if(modelTable.getRowCount()>0){
                modelTable.setRowSelectionInterval(0, 0);
            }   
            fP=sP=tP="";
        } catch (SQLException ex) {
            Logger.getLogger(Form1JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTitlesOnHeaders();
    }
    
    public void userAccessSettings(JButton button1, JButton button2, JButton button3) {
        if(GetSetInformation.getUserAccess().equals("reader")) {
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
        }
    }
}
