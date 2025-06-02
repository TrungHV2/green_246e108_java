package com.greenacademy.service.impl;

import com.greenacademy.model.response.CategoryResponse;
import com.greenacademy.service.ExcelService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelServiceImpl() {
        workbook = new XSSFWorkbook();
    }

    @Override
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Categories");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Id", style);
        createCell(row, 1, "Name", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        CategoryResponse categoryResponse1 = new CategoryResponse();
        categoryResponse1.setId(1);
        categoryResponse1.setName("Category 1");
        CategoryResponse categoryResponse2 = new CategoryResponse();
        categoryResponse2.setId(2);
        categoryResponse2.setName("Category 2");
        CategoryResponse categoryResponse3 = new CategoryResponse();
        categoryResponse3.setId(3);
        categoryResponse3.setName("Category 3");

        List<CategoryResponse> data = List.of(categoryResponse1, categoryResponse2, categoryResponse3);

        for (CategoryResponse item : data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, item.getId(), style);
            createCell(row, columnCount++, item.getName(), style);
        }
    }
}
