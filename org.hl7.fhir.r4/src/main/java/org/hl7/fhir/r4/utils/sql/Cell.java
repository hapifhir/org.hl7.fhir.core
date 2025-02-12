package org.hl7.fhir.r4.utils.sql;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.utils.sql.Cell;
import org.hl7.fhir.r4.utils.sql.Column;
import org.hl7.fhir.r4.utils.sql.Value;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;


@MarkedToMoveToAdjunctPackage
public class Cell {
  private Column column; 
  private List<Value> values = new ArrayList<>();

  public Cell(Column column) {
    super();
    this.column = column;
  }
  
  public Cell(Column column, Value value) {
    super();
    this.column = column;
    this.values.add(value);
  }
  
  public Column getColumn() {
    return column;
  }
  
  public List<Value> getValues() {
    return values;
  }

  public Cell copy() {
    Cell cell = new Cell(column);
    for (Value v : values) {
      cell.values.add(v); // values are immutable, so we don't need to clone them
    }
    return cell;
  }


}
