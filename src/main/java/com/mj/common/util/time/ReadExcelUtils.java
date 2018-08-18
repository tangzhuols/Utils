package com.mj.common.util.time;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils {
    private Workbook wb;
    private Sheet sheet;
    private Row row;

    public ReadExcelUtils(String filepath) {
        if (filepath != null) {
            String ext = filepath.substring(filepath.lastIndexOf("."));

            try {
                FileInputStream e = new FileInputStream(filepath);
                if (".xls".equals(ext)) {
                    this.wb = new HSSFWorkbook(e);
                } else if (".xlsx".equals(ext)) {
                    this.wb = new XSSFWorkbook(e);
                } else {
                    this.wb = null;
                }
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }
    }

    public String[] readExcelTitle() throws Exception {
        if (this.wb == null) {
            throw new Exception("Workbook对象为空！");
        } else {
            this.sheet = this.wb.getSheetAt(0);
            this.row = this.sheet.getRow(0);
            int colNum = this.row.getPhysicalNumberOfCells();
            String[] title = new String[colNum];

            for (int i = 0; i < colNum; ++i) {
                title[i] = this.row.getCell(i).getCellFormula();
            }

            return title;
        }
    }

    public Map<Integer, Map<Integer, Object>> readExcelContent() throws Exception {
        if (this.wb == null) {
            throw new Exception("Workbook对象为空！");
        } else {
            HashMap content = new HashMap();
            this.sheet = this.wb.getSheetAt(0);
            int rowNum = this.sheet.getLastRowNum();
            this.row = this.sheet.getRow(0);
            int colNum = this.row.getPhysicalNumberOfCells();

            for (int i = 1; i <= rowNum; ++i) {
                this.row = this.sheet.getRow(i);
                int j = 0;

                HashMap cellValue;
                for (cellValue = new HashMap(); j < colNum; ++j) {
                    Object obj = this.getCellFormatValue(this.row.getCell(j));
                    cellValue.put(Integer.valueOf(j), obj);
                }

                content.put(Integer.valueOf(i), cellValue);
            }

            return content;
        }
    }

    private Object getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case 0:
                case 2:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        TimeZone zone = TimeZone.getTimeZone("GMT+08:00");
                        format.setTimeZone(zone);
                        Date date = cell.getDateCellValue();
                        cellvalue = format.format(date);
                    } else {
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case 1:
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }

        return cellvalue;
    }
}
