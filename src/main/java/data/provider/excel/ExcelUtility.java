package data.provider.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

    public static ExcelUtility create(String fileName){
        return new ExcelUtility(fileName);
    }

    public static ExcelUtility create(String fileName, String sheetName){
        return new ExcelUtility(fileName, sheetName);
    }

    private String filePath;
    private String sheetName;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private boolean isFileExist = false;

    private FileInputStream inputStream=null;

    private ExcelUtility(String filePath, String sheetName){
        this.filePath = filePath;
        this.sheetName = sheetName;
        createExcelFile();
    }

    private ExcelUtility(String filePath){
        this(filePath, "sheet1");
    }

    public ExcelUtility setSheetName(String sheetName){
        this.sheetName = sheetName;
        return this;
    }

    private void createExcelFile(){
        File file = new File(filePath);
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(filePath);
                workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet(sheetName);
            } catch (IOException | InvalidFormatException e) /* create kabul etmedigi icin invalid exception ekledin*/ {
                e.printStackTrace();
            }
            isFileExist = true;
        }else{
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(sheetName);
        }
    }

    public ExcelUtility setHeader(List<String> headers){
        if (!isFileExist) {
            Row row = sheet.createRow(0);
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers.get(i));
            }
        }
        return this;
    }

    public ExcelUtility writeData(List<List<String>> rows){
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            for (int j = 0; j < rows.get(i).size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rows.get(i).get(j));
            }
        }
        return this;
    }

    public void writeExcel(){
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> getData() {
        List<List<String>> lists = new ArrayList<>();

        int rowCount = sheet.getPhysicalNumberOfRows();

        for(int i = 0; i < rowCount; i++) {
            List<String> rowList = new ArrayList<>();
            Row row = sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();

            for(int j = 0; j < cellCount; j++) {
                rowList.add(row.getCell(j).toString());
            }
            lists.add(rowList);
        }
        return lists;
    }


    public List<String> getHeader() {
        List<String> list = new ArrayList<>();

        sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(0);

        int cellCount = row.getPhysicalNumberOfCells();

        for(int i = 0; i < cellCount; i++) {
            list.add(row.getCell(i).toString());
        }
        return list;
    }

    public List<String> getRow(int rowNumber) {
        List<String> list = new ArrayList<>();

        sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rowNumber);

        int cellCount = row.getPhysicalNumberOfCells();

        for(int i = 0; i < cellCount; i++) {
            list.add(row.getCell(i).toString());
        }
        return list;
    }

    public List<String> getColumn(int colNum) {
        List<String> list = new ArrayList<>();

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colNumExcel = sheet.getRow(0).getPhysicalNumberOfCells();
        colNum = Math.min(colNum, colNumExcel)-1;
        for(int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            list.add(row.getCell(colNum).toString());
        }
        return list;
    }
}
