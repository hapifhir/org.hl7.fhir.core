package org.hl7.fhir.r5.utils.sql;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public enum ColumnKind {
  String, DateTime, Integer, Decimal, Binary, Time, Boolean, Complex, Null
}
