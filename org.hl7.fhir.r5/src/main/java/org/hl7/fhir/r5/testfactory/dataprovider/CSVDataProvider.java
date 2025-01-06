package org.hl7.fhir.r5.testfactory.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CSVReader;

public class CSVDataProvider extends TableDataProvider {

  private CSVReader csv;
  private List<String> cols = new ArrayList<String>();
  private int counter;
  private String filename;
  
  protected CSVDataProvider(String filename) throws FHIRException, FileNotFoundException, IOException {
    super();
    
    this.filename = filename;
    reset();
  }

  @Override
  public List<String> columns() {
    return cols;
  }

  @Override
  public boolean nextRow() throws FHIRException {
    try {
      counter++;
      return csv.line(); 
    } catch (IOException e) {
      throw new FHIRException("Error moving to next row: " + e.getMessage(), e);
    }
  }

  @Override
  public List<String> cells() {
    List<String> cells = new ArrayList<String>();
    cells.add(""+counter);      
    for (String s : csv.getCells()) {
      cells.add(s.trim());      
    }
    return cells;
  }

  @Override
  public String cell(String name) {
    if ("counter".equals(name)) {
      return ""+counter;      
    } else {
      return csv.cell(name).trim();
    }
  }

  @Override
  public void reset() throws FHIRException {
    try {
      this.csv = new CSVReader(new FileInputStream(filename));

      cols.add("counter");
      for (String s : csv.readHeaders()) {
        cols.add(s.trim());
      }
    } catch (Exception e) {
      throw new FHIRException("Error moving to next row: " + e.getMessage(), e);
    }
  }

}
