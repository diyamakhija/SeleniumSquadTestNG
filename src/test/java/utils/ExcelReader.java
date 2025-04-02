package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelReader {

    private static Map<String, List<Map<String, String>>> excelData = new HashMap<>();

    public static Map<String, List<Map<String, String>>> getData(String filePath) {
        if (excelData.isEmpty()) {
            try (FileInputStream fis = new FileInputStream(new File(filePath));
                 Workbook workbook = new XSSFWorkbook(fis)) {

                for (Sheet sheet : workbook) {
                    Row firstRow = sheet.getRow(0);
                    List<Map<String, String>> rows = new ArrayList<>();

                    for (Row row : sheet) {
                        if (row.getRowNum() != 0) {
                            boolean isRowPresent = false;
                            Map<String, String> rowData = new HashMap<>();

                            for (Cell cell : row) {
                                Cell header = firstRow.getCell(cell.getColumnIndex());
                                String cellValue = getCellValue(cell).trim();
                                if (header != null && !cellValue.isEmpty()) {
                                    isRowPresent = true;
                                    rowData.put(getCellValue(header).trim(), cellValue);
                                }
                            }

                            if (isRowPresent) {
                                rows.add(rowData);
                            }
                        }
                    }
                    excelData.put(sheet.getSheetName(), rows);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return excelData;
    }

    private static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "Unknown";
        }
    }
    
} 
