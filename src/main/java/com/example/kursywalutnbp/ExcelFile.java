package com.example.kursywalutnbp;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelFile {

    private XSSFWorkbook workbook = new XSSFWorkbook();

    private XSSFSheet sheet;

    private XSSFRow xssfRow;

    private Map<Integer, String[]> currencyData = new TreeMap<>();

    private Set<Integer> keyid;

    private String path;

    private FileChooser fileChooser = new FileChooser();

    private File selectedFile;

    private final FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Plik Excel (*.xlsx)", "*.xlsx");

    public void saveExcelFile(String tableName, Map<Integer, String[]> currencyData){
        fileChooser.getExtensionFilters().add(extensionFilter);
        selectedFile = fileChooser.showSaveDialog(new Stage());

        path = tableName.replace('/', '.');
        sheet = workbook.createSheet(tableName.replace('/', '.'));
        keyid = currencyData.keySet();

        // Setting column names and style
        XSSFRow row = sheet.createRow(0);
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        row.createCell(0).setCellValue("Nazwa waluty");
        row.createCell(1).setCellValue("Kod waluty");
        row.createCell(2).setCellValue("Średni kurs");
        style.setFont(font);
        row.getCell(0).setCellStyle(style);
        row.getCell(1).setCellStyle(style);
        row.getCell(2).setCellStyle(style);

        // Setting auto-size for excel columns
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        int rowid = 1;

        for (Integer key : keyid) {

            xssfRow = sheet.createRow(rowid++);

            Object[] objectArr = currencyData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = xssfRow.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        if (selectedFile != null) {
            try {
                FileOutputStream out = new FileOutputStream(selectedFile.getAbsolutePath());
                workbook.write(out);
                fileChooser.setInitialFileName(path);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void saveExcelFileC(String tableName, Map<Integer, String[]> currencyData){
        fileChooser.getExtensionFilters().add(extensionFilter);
        selectedFile = fileChooser.showSaveDialog(new Stage());

        path = tableName.replace('/', '.');
        sheet = workbook.createSheet(tableName.replace('/', '.'));
        keyid = currencyData.keySet();

        // Setting column names and style
        XSSFRow row = sheet.createRow(0);
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        row.createCell(0).setCellValue("Nazwa waluty");
        row.createCell(1).setCellValue("Kod waluty");
        row.createCell(2).setCellValue("Kurs kupna");
        row.createCell(3).setCellValue("Kurs sprzedaży");
        style.setFont(font);
        row.getCell(0).setCellStyle(style);
        row.getCell(1).setCellStyle(style);
        row.getCell(2).setCellStyle(style);
        row.getCell(3).setCellStyle(style);

        // Setting auto-size for excel columns
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        int rowid = 1;

        for (Integer key : keyid) {

            xssfRow = sheet.createRow(rowid++);

            Object[] objectArr = currencyData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = xssfRow.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        if (selectedFile != null) {
            try {
                FileOutputStream out = new FileOutputStream(selectedFile.getAbsolutePath());
                workbook.write(out);
                fileChooser.setInitialFileName(path);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
