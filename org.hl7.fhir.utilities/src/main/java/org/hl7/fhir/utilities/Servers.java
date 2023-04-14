package org.hl7.fhir.utilities;

public class Servers {

  public static final String TX_SERVER_PROD = "http://tx.fhir.org";
  public static final String TX_SERVER_DEV = "http://tx-dev.fhir.org";
  public static final String TX_SERVER_LOCAL = "http://local.fhir.org";
  
  public static boolean isTxFhirOrg(String s) {
    return Utilities.existsInList(s.replace("https://", "http://"), TX_SERVER_PROD, TX_SERVER_DEV, TX_SERVER_LOCAL);
  }

}
