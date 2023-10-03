package org.hl7.fhir.r5.utils.sql;

import java.util.List;

import org.hl7.fhir.r5.model.Base;

public interface Storage {

  boolean supportsArrays();
  boolean supportsComplexTypes();
  
  Store createStore(String name, List<Column> columns);
  void addRow(Store store, List<Cell> cells);
  void finish(Store store);
  boolean needsName();
  String getKeyForSourceResource(Base res);
  String getKeyForTargetResource(Base res);
}
