package org.hl7.fhir.r5.testfactory.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

/**
 * A TableDataProvider that works with in-memory JSON array data,
 * suitable for REST API usage where data is provided inline rather than from files.
 */
public class InlineTableDataProvider extends TableDataProvider {

  private final List<String> cols;
  private final List<List<String>> rows;
  private int currentRow = -1;
  private int counter = 0;

  public InlineTableDataProvider(JsonArray data) {
    cols = new ArrayList<>();
    rows = new ArrayList<>();

    cols.add("counter");

    if (data != null && data.size() > 0) {
      // Extract column names from the first object
      JsonObject first = data.get(0).asJsonObject();
      for (String name : first.getNames()) {
        cols.add(name);
      }

      // Extract row values
      for (int i = 0; i < data.size(); i++) {
        JsonObject row = data.get(i).asJsonObject();
        List<String> values = new ArrayList<>();
        values.add(String.valueOf(i + 1)); // counter
        for (int c = 1; c < cols.size(); c++) {
          String val = row.has(cols.get(c)) ? row.asString(cols.get(c)) : "";
          values.add(val != null ? val : "");
        }
        rows.add(values);
      }
    }
  }

  @Override
  public List<String> columns() {
    return cols;
  }

  @Override
  public boolean nextRow() throws FHIRException {
    currentRow++;
    counter++;
    return currentRow < rows.size();
  }

  @Override
  public List<String> cells() throws FHIRException {
    if (currentRow < 0 || currentRow >= rows.size()) {
      throw new FHIRException("No current row");
    }
    return rows.get(currentRow);
  }

  @Override
  public String cell(String name) throws FHIRException {
    if ("counter".equals(name)) {
      return String.valueOf(counter);
    }
    if (currentRow < 0 || currentRow >= rows.size()) {
      throw new FHIRException("No current row");
    }
    int idx = cols.indexOf(name);
    if (idx < 0) {
      return "";
    }
    return rows.get(currentRow).get(idx);
  }

  @Override
  public void reset() throws FHIRException {
    currentRow = -1;
    counter = 0;
  }
}
