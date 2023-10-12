/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caldeira.contact.scrapper.spreadsheet.service;

import com.caldeira.resources.view.SuccessFrame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alscaldeira
 */
public class ExcelService {
     
    public void generateSpreadsheet(List<String> urls) {
        
        XSSFWorkbook wb = new XSSFWorkbook();
        try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        XSSFSheet sheet = wb.createSheet();
        Map<String, String> data = new TreeMap<>();
        
        String now = getFormattedDate();
        data.put( "URL", "Data de extração" );
        for(String url : urls)
            data.put( url, now );
        
        Set<String> keyset = data.keySet(); 
        int rownum = 0;
        for(Map.Entry<String, String> entry : data.entrySet()) {
            int cellnum = 0;
            // Creating a new row in the sheet
            XSSFRow row = sheet.createRow(rownum++);
            // This line creates a cell in the next column of that row
            XSSFCell cell = row.createCell(cellnum++); 
            cell.setCellValue(entry.getKey());
            cell = row.createCell(cellnum++); 
            cell.setCellValue(entry.getValue());
        }
        
        new SuccessFrame(wb);
    }
    
    private String getFormattedDate() {
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        sb.append("/");
        sb.append(calendar.get(Calendar.MONTH));
        sb.append("/");
        sb.append(calendar.get(Calendar.YEAR));
        
        sb.append(" ");
        sb.append(calendar.get(Calendar.HOUR_OF_DAY));
        sb.append(":");
        sb.append(calendar.get(Calendar.MINUTE));
        
        return sb.toString();
    }
    
}
