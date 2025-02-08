package org.hl7.fhir.r5.terminologies.expansion;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class ETooCostly extends Exception {

  public ETooCostly(String msg) {
    super(msg);
  }

}