package org.hl7.fhir.r5.testfactory.dataprovider;

import org.apache.poi.ss.usermodel.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class ExcelDataProvider extends TableDataProvider {

  private Workbook workbook;
  private Sheet sheet;
  private List<String> columnHeaders;
  private int currentRowIndex = -1;
  private Map<String, Integer> columnIndexMap = new HashMap<>();
  private Row currentRow;
  private DataFormatter df = new DataFormatter();
  

  /**
   * Constructs an ExcelTableDataProvider.
   *
   * @param filename  The path to the Excel file.
   * @param sheetName The name of the sheet to read.
   * @throws IOException If an I/O error occurs.
   * @throws InvalidFormatException If the file format is invalid.
   */
  public ExcelDataProvider(String filename, String sheetName) throws IOException, InvalidFormatException {
    FileInputStream fis = new FileInputStream(new File(filename));
    this.workbook = WorkbookFactory.create(fis);
    if (sheetName != null) {
      this.sheet = workbook.getSheet(sheetName);
    }

    if (sheet == null) {
      List<String> names = new ArrayList<String>();
      for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
        names.add(workbook.getSheetName(i));
      }
      if (sheetName == null && names.size() > 0) {
        this.sheet = workbook.getSheet(names.get(0));        
      } else {
        throw new IllegalArgumentException("Sheet '" + sheetName + "' does not exist in the file. Sheet Names = "+CommaSeparatedStringBuilder.join(",", names));
      }
    }

    loadColumnHeaders();
  }


  public ExcelDataProvider(String filename) throws InvalidFormatException, IOException {
    FileInputStream fis = new FileInputStream(new File(filename));
    this.workbook = WorkbookFactory.create(fis);
    this.sheet = workbook.getSheetAt(0);
    loadColumnHeaders();
  }


  /**
   * Loads the column headers from the first row of the sheet.
   */
  private void loadColumnHeaders() {
    columnHeaders = new ArrayList<>();
    columnHeaders.add("counter");
    Row headerRow = sheet.getRow(0);
    if (headerRow != null) {
      for (Cell cell : headerRow) {
        String headerName = cell.getStringCellValue().trim();
        columnHeaders.add(headerName);
        columnIndexMap.put(headerName, cell.getColumnIndex());
      }
    }
  }

  @Override
  public List<String> columns() {
    return columnHeaders;
  }

  @Override
  public boolean nextRow() {
    currentRowIndex++;
    currentRow = sheet.getRow(currentRowIndex + 1); // Skip the header row
    return currentRow != null;
  }

  @Override
  public List<String> cells() {
    List<String> cellValues = new ArrayList<>();
    cellValues.add(""+(currentRowIndex+1));
    if (currentRow != null) {
      for (Cell cell : currentRow) {
        int i = cell.getColumnIndex();
        while (cellValues.size() <= i) {
          cellValues.add("");
        }
        cellValues.add(getCellValue(cell).trim());
      }
    }
    return cellValues;
  }

  @Override
  public String cell(String name) {
    if ("counter".equals(name)) {
      return ""+currentRowIndex;      
    } else {
      Integer columnIndex = columnIndexMap.get(name);
      if (columnIndex == null || currentRow == null) {
        return null;
      }
      Cell cell = currentRow.getCell(columnIndex);
      return cell == null ? null : getCellValue(cell).trim();
    }
  }

  /**
   * Utility method to get a cell value as a string.
   *
   * @param cell The cell.
   * @return The cell value as a string.
   */
  private String getCellValue(Cell cell) {
    switch (cell.getCellType()) {
    case STRING:
      return cell.getStringCellValue();
    case NUMERIC:
      return df.formatCellValue(cell);
    case BOOLEAN:
      return Boolean.toString(cell.getBooleanCellValue());
    case FORMULA:
      return cell.getCellFormula();
    case BLANK:
      return "";
    default:
      return "";
    }
  }

  /**
   * Closes the workbook and releases resources.
   *
   * @throws IOException If an I/O error occurs.
   */
  public void close() throws IOException {
    if (workbook != null) {
      workbook.close();
    }
  }

  @Override
  public void reset() throws FHIRException {
    currentRowIndex = -1;
  }

}
