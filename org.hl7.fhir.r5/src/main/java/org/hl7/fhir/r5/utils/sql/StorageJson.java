package org.hl7.fhir.r5.utils.sql;

import java.util.List;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonBoolean;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonNumber;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonString;

public class StorageJson implements Storage {

  private String name; 
  private JsonArray rows;
  
  @Override
  public boolean supportsArrays() {
    return true;
  }

  @Override
  public Store createStore(String name, List<Column> columns) {
    this.name = name;
    this.rows = new JsonArray();
    return new Store(name); // we're not doing anything with this
  }

  @Override
  public void addRow(Store store, List<Cell> cells) {
    JsonObject row = new JsonObject();
    rows.add(row);
    for (Cell cell : cells) {
      if (cell.getValues().size() == 0) {
        row.add(cell.getColumn().getName(), new JsonNull());
      } else if (cell.getValues().size() == 1) {
        row.add(cell.getColumn().getName(), makeJsonNode(cell.getValues().get(0)));
      } else {
        JsonArray arr = new JsonArray();
        row.add(cell.getColumn().getName(), arr);
        for (Value value : cell.getValues()) {
          arr.add(makeJsonNode(value));
        }
      }
    }
  }

  private JsonElement makeJsonNode(Value value) {
    if (value == null) {
      return new JsonNull();
    } else if (value.getValueInt() != null) {
      return new JsonNumber(value.getValueInt().intValue());
    }
    if (value.getValueBoolean() != null) {
      return new JsonBoolean(value.getValueBoolean().booleanValue());
    }
    if (value.getValueDecimal() != null) {
      return new JsonNumber(value.getValueDecimal().toPlainString());
    }
    return new JsonString(value.getValueString());
  }

  @Override
  public void finish(Store store) {
    // nothing
  }

  public String getName() {
    return name;
  }

  public JsonArray getRows() {
    return rows;
  }

  @Override
  public boolean supportsComplexTypes() {
    return true;
  }

  @Override
  public boolean needsName() {
    return false;
  }

  @Override
  public String getKeyForSourceResource(Base res) {
    return res.getIdBase();
  }

  @Override
  public String getKeyForTargetResource(Base res) {
    return res.fhirType()+"/"+res.getIdBase();
  }

}
