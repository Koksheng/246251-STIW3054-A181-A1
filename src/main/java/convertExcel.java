
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

public class convertExcel {
    public static void convert() throws IOException{
        
            Product product = new Product();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("List Products");
            
            Row rowHeading = sheet.createRow(0);
            rowHeading.createCell(0).setCellValue("Table Hearder");
            rowHeading.createCell(1).setCellValue("Table Data");
            
            //Set Font
            for(int i=0; i<2; i++){
                CellStyle stylerowHeading = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short) 11);
                stylerowHeading.setFont(font);
                stylerowHeading.setVerticalAlignment(CellStyle.ALIGN_CENTER);
                rowHeading.getCell(i).setCellStyle(stylerowHeading);
            }
            
            int r =1;
            for(Product result : crawler.crawlData()){
                Row row = sheet.createRow(r++);
                //Th Column
                Cell cellId = row.createCell(0);
                cellId.setCellValue(result.getTh());
                //Td Column
                Cell cellName = row.createCell(1);
                cellName.setCellValue(result.getTd()); 
            }
            //Autofit
            for(int i=0; i<6; i++){
                sheet.autoSizeColumn(i);
            }
            //save to Excel file
            FileOutputStream out = new FileOutputStream(new File("D:\\Users\\User\\Documents\\NetBeansProjects\\Assignment1\\listProducts.xls"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Convert into Excel successfully...");  
    }
}
