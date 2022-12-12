 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */
public class GTOPMasterDataMacroCheck {
 
 
    public static void main(String[] args) {
        String excelFilePath = "D:\\Bala\\NML\\GTOP- Master register\\AAA.xls";
         
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(2);
            
            Row row = null;
            Cell cell = null;
            int rowcount = 4 ;
            int cellcount = 2 ;
            
            CellStyle style = workbook.createCellStyle();  
            style.setBorderBottom(BorderStyle.THIN);  
            
            
            int headerRow = 2;
            int headerRowCount = 1;
            for (int i = 82 ; i<=82+42 ; i++) {
            
            		System.out.println(i);
            		System.out.println(rowcount);
            		row = sheet.getRow(rowcount);
            		System.out.println(row);
            		cell = row.createCell(cellcount);
            		cell.setCellFormula("IF(TRIM(対象データ!B"+i+")=\"\",\"\",対象データ!B"+i+")");
            		cell.setCellStyle(style);
            		rowcount++;
            		//cellcount++;
            		row = sheet.getRow(rowcount);
            		cell = row.createCell(cellcount);
            		cell.setCellFormula("IF(TRIM(対象データ!C"+i+")=\"\",\"\",対象データ!C"+i+")");
            		cell.setCellStyle(style);
            		rowcount++;
            		//cellcount++;
            		row = sheet.getRow(rowcount);
            		cell = row.createCell(cellcount);
            		cell.setCellFormula("IF(TRIM(対象データ!D"+i+")=\"\",\"\",対象データ!D"+i+")");
            		cell.setCellStyle(style);
            		rowcount++;
            		//cellcount++;
            		row = sheet.getRow(rowcount);
            		cell = row.createCell(cellcount);
            		cell.setCellFormula("IF(TRIM(対象データ!E"+i+")=\"\",\"\",対象データ!E"+i+")");
            		cell.setCellStyle(style);
            		//cellcount = 2 ;
            		rowcount = rowcount + 4 ;
            		
            		
            		row = sheet.getRow(headerRow);
            		headerRow = headerRow + 7;
            		cell = row.createCell(0);
            		cell.setCellFormula(headerRowCount+"&\"レコード目\"");
            		headerRowCount++;
   		    
            }
   		  // cell.setCellFormula("SUM(C2:C5)");
 
           /* Object[][] bookData = {
                    {"The Passionate Programmer", "Chad Fowler", 16},
                    {"Software Craftmanship", "Pete McBreen", 26},
                    {"The Art of Agile Development", "James Shore", 32},
                    {"Continuous Delivery", "Jez Humble", 41},
            };
 
            int rowCount = sheet.getLastRowNum();
 
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 
            }
 */
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("JavaBooks.xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
}