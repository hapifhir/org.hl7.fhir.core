package org.hl7.fhir.r5.testfactory.dataprovider;

import java.sql.DriverManager;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public abstract class TableDataProvider {

  public abstract List<String> columns();
  public abstract boolean nextRow() throws FHIRException;
  public abstract List<String> cells() throws FHIRException;
  public abstract String cell(String name) throws FHIRException;
  public abstract void reset() throws FHIRException;


  public static TableDataProvider forFile(String path) throws FHIRException {
    try {
      String filename = path;
      String sheetname = null;

      if (path.contains(";")) {
        filename = path.substring(0, path.indexOf(";"));
        sheetname = path.substring(path.indexOf(";")+1);
      }
      String extension = Utilities.getFileExtension(filename);
      if (Utilities.existsInList(extension, "csv", "txt")) {
        return new CSVDataProvider(filename);
      } else if (Utilities.existsInList(extension, "xlsx")) {
        return new ExcelDataProvider(filename, sheetname);
      } else if (Utilities.existsInList(extension, "db")) {
        return new SQLDataProvider(DriverManager.getConnection("jdbc:sqlite:"+filename), sheetname);
      } else {
        throw new FHIRException("Unknown File Type "+path);
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

}
