package functionality;

import java.awt.Color;
import java.awt.Font;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ihorg
 */
public class GetSetInformation {
    private  static Integer rowCount,colCount,currentRow,currentId;
    private  static Integer appTheme, appLanguage, appTextSize, appTextType, appTextFont;
    private static String userAccess;
    public static String generalPath = "C:\\Users\\ihorg\\Documents\\NetBeansProjects\\DVDB\\src\\images";
        public static void setRowCount(Integer rowCount) {
            GetSetInformation.rowCount = rowCount;
        }

        public static Integer getRowCount() {
            return rowCount;
        }
        public static void setColCount(Integer colCount) {
            GetSetInformation.colCount = colCount;
        }

        public static Integer getColCount() {
            return colCount;
        }
        
        public static void setCurrentRow(Integer currentRow) {
            GetSetInformation.currentRow = currentRow;
        }

        public static Integer getCurrentRow() {
            return currentRow;
        }
        
        public static void setCurrentId(Integer currentId) {
            GetSetInformation.currentId = currentId;
        }

        public static Integer getCurrentId() {
            return currentId;
        }
        
        public static void setUserAccess(String userAccess) {
            GetSetInformation.userAccess = userAccess;
        }

        public static String getUserAccess() {
            return userAccess;
        }
        
        public static void setAppTheme(Integer appTheme) {
            GetSetInformation.appTheme = appTheme;
        }

        public static Integer getAppTheme() {
            return appTheme;
        }
        
        public static void setAppLanguage(Integer appLanguage) {
            GetSetInformation.appLanguage = appLanguage;
        }

        public static Integer getAppLanguage() {
            return appLanguage;
        }
        
        public static void setAppTextSize(Integer appTextSize) {
            GetSetInformation.appTextSize = appTextSize;
        }

        public static Integer getAppTextSize() {
            return appTextSize;
        }
        
        public static void setAppTextType(Integer appTextType) {
            GetSetInformation.appTextType = appTextType;
        }

        public static Integer getAppTextType() {
            return appTextType;
        }
        
        public static void setAppTextFont(Integer appTextFont) {
            GetSetInformation.appTextFont = appTextFont;
        }

        public static Integer getAppTextFont() {
            return appTextFont;
        }

         //GET ALL
        public static Color getFormBackground() {
            Color formBackground;
            if(GetSetInformation.getAppTheme() == 0){
                formBackground = new Color(255,255,255);
            } else {
                formBackground = new Color(23,33,43);
            }
            return formBackground;
        }
        public static Color getForeGround() {
            Color foreGround;
            if(GetSetInformation.getAppTheme() == 0){
                foreGround = new Color(0,0,0);
            } else {
                foreGround = new Color(127,145,164);
            }
            return foreGround;
        }
        public static Color getElementBackground() {
            Color elementBackground;
            if(GetSetInformation.getAppTheme() == 0){
                elementBackground = new Color(255,255,255);
            } else {
                elementBackground = new Color(36,47,61);
            }
            return elementBackground;
        }
        public static Integer getTextSize() {
            Integer text_size = 1;
            if(GetSetInformation.getAppTextSize() == 0){
                text_size = 10;
            } else if(GetSetInformation.getAppTextSize() == 1) {
                text_size = 12;
            } else {
                text_size = 14;
            }
            return text_size;
        }
        public static Integer getTextType() {
            Integer text_type = 1;
            if(GetSetInformation.getAppTextType()==0){
                text_type = Font.PLAIN;
            } else if(GetSetInformation.getAppTextType()==1) {
                text_type = Font.BOLD;
            } else {
                text_type = Font.ITALIC;
            }
            return text_type;
        }
        public static String getTextFont() {
            String text_font = "";
            if(GetSetInformation.getAppTextFont()==1){
                text_font = "Tahoma";
            } else if(GetSetInformation.getAppTextFont()==2) {
                text_font = "Times New Roman";
            }  else if(GetSetInformation.getAppTextFont()==3) {
                text_font = "Arial";
            } else {
                text_font = "Calibri";
            }
            return text_font;
        }
}
