package org.hl7.fhir.r5.renderers.spreadsheets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.renderers.DataRenderer;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.

 */



public class SpreadsheetGenerator {
    
  protected IWorkerContext context;

  protected XSSFWorkbook wb = new XSSFWorkbook();
  protected Map<String, CellStyle> styles;

  protected DataRenderer dr;
  
  public SpreadsheetGenerator(IWorkerContext context) {
    super();
    this.context = context;
    styles = createStyles(wb);
    dr = new DataRenderer(context);
  }

  public void finish(OutputStream outStream) throws IOException {
    wb.write(outStream);
    outStream.flush();
    outStream.close();
  }
  
  private static Map<String, CellStyle> createStyles(Workbook wb){
    Map<String, CellStyle> styles = new HashMap<>();

    CellStyle style;
    Font headerFont = wb.createFont();
    headerFont.setBold(true);
    style = createBorderedStyle(wb);
    style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    style.setVerticalAlignment(VerticalAlignment.TOP);
    style.setWrapText(true);
    style.setFont(headerFont);
    styles.put("header", style);

    style = createBorderedStyle(wb);
    style.setVerticalAlignment(VerticalAlignment.TOP);
    style.setWrapText(true);    
    styles.put("body", style);

    return styles;
  }

  private static CellStyle createBorderedStyle(Workbook wb){
    BorderStyle thin = BorderStyle.THIN;
    short black = IndexedColors.GREY_50_PERCENT.getIndex();

    CellStyle style = wb.createCellStyle();
    style.setBorderRight(thin);
    style.setRightBorderColor(black);
    style.setBorderBottom(thin);
    style.setBottomBorderColor(black);
    style.setBorderLeft(thin);
    style.setLeftBorderColor(black);
    style.setBorderTop(thin);
    style.setTopBorderColor(black);
    return style;
  }

  protected void addCell(Row row, int pos, String content) {
    addCell(row, pos, content, styles.get("body"));
  }

  protected void addCell(Row row, int pos, boolean b) {
    addCell(row, pos, b ? "Y" : "");
  }

  protected void addCell(Row row, int pos, int content) {
    addCell(row, pos, Integer.toString(content));
  }

  protected void addCell(Row row, int pos, String content, CellStyle style) {
    Cell cell = row.createCell(pos);
    cell.setCellValue(content);
    cell.setCellStyle(style);
  }

  protected int columnPixels(double columns) {
    double WIDTH_FACTOR = 256;
    double PADDING = 180;
    return (int)Math.floor(columns*WIDTH_FACTOR + PADDING);
  }

  protected void addHeaders(Sheet sheet, String... titles) {
    Row headerRow = sheet.createRow(sheet.getRow(0) == null ? 0 : sheet.getLastRowNum()+1);
    for (int i = 0; i < titles.length; i++) {
      addCell(headerRow, i, titles[i], styles.get("header"));
    }   
  }
  
  protected void addRow(Sheet sheet, String... values) {
    Row row = sheet.createRow(sheet.getLastRowNum()+1);
    
    for (int i = 0; i < values.length; i++) {
      addCell(row, i, values[i], styles.get("body"));
    }
  }
  
}