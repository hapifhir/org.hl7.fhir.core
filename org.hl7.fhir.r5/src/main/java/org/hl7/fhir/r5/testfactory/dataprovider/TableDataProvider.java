package org.hl7.fhir.r5.testfactory.dataprovider;

import java.sql.DriverManager;
import java.util.List;
import java.util.Locale;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

@MarkedToMoveToAdjunctPackage
public abstract class TableDataProvider {

  public abstract List<String> columns();
  public abstract boolean nextRow() throws FHIRException;
  public abstract List<String> cells() throws FHIRException;
  public abstract String cell(String name) throws FHIRException;
  public abstract void reset() throws FHIRException;

  public record SheetInfo(String sheet, String range){
    public static SheetInfo fromString(String string) {
      if (string.contains("!")) {
        final int splitIndex = string.indexOf("!");
        if (splitIndex + 1 < string.length()) {
          final String sheetName = string.substring(0, splitIndex);
          final String range = string.substring(splitIndex + 1);
          return new SheetInfo(sheetName, range);
        }
      }
      return new SheetInfo(string, null);
    }
  }

  public static TableDataProvider forFile(String path, SheetInfo sheetInfo, Locale locale) throws FHIRException {
    try {
      String extension = Utilities.getFileExtension(path);
      if (Utilities.existsInList(extension, "csv", "txt")) {
        return new CSVDataProvider(path);
      } else if (Utilities.existsInList(extension, "xlsx")) {
        return new ExcelDataProvider(path, sheetInfo.sheet, sheetInfo.range, locale);
      } else if (Utilities.existsInList(extension, "db")) {
        return new SQLDataProvider(DriverManager.getConnection("jdbc:sqlite:"+ path), sheetInfo.sheet);
      } else {
        throw new FHIRException("Unknown File Type "+ path);
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

}
