package org.hl7.fhir.r4.utils.sql;

import java.util.List;

import org.hl7.fhir.r4.utils.sql.Validator.TrueFalseOrUnknown;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.utils.sql.Cell;
import org.hl7.fhir.r4.utils.sql.Column;
import org.hl7.fhir.r4.utils.sql.Store;

@MarkedToMoveToAdjunctPackage
public interface Storage {

  TrueFalseOrUnknown supportsArrays();
  TrueFalseOrUnknown supportsComplexTypes();
  
  Store createStore(String name, List<Column> columns);
  void addRow(Store store, List<Cell> cells);
  void finish(Store store);
  TrueFalseOrUnknown needsName();
  String getKeyForSourceResource(Base res);
  String getKeyForTargetResource(Base res);
}
