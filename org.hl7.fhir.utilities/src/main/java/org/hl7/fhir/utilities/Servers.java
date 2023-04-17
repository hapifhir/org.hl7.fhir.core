package org.hl7.fhir.utilities;

public class Servers {

  public static final String TX_SERVER_PROD = "http://tx.fhir.org";
  public static final String TX_SERVER_DEV = "http://tx-dev.fhir.org";
  public static final String TX_SERVER_LOCAL = "http://local.fhir.org";
  public static final String TX_SERVER_LOCAL2 = "http://local.fhir.org:8090";
  
  public static boolean isTxFhirOrg(String s) {
    return Utilities.startsWithInList(s.replace("https://", "http://"), TX_SERVER_PROD, TX_SERVER_DEV, TX_SERVER_LOCAL);
  }

}
