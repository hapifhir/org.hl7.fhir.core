package org.hl7.fhir.r5.terminologies.expansion;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class OperationIsTooCostly extends Exception {

  public OperationIsTooCostly(String msg) {
    super(msg);
  }

}