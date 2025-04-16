package org.hl7.fhir.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.

 */



public class OIDUtilities {

  // Simple class to hold OID information
  public static class OIDInfo {
    private String oid;
    private String name;
    private String codeSystem;
    private Integer type;

    // Getters and setters
    public String getOid() { return oid; }
    public void setOid(String oid) { this.oid = oid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCodeSystem() { return codeSystem; }
    public void setCodeSystem(String codeSystem) { this.codeSystem = codeSystem; }

    public Integer getType() { return type; }
    public void setType(Integer type) { this.type = type; }

    @Override
    public String toString() {
      return "OID: " + oid + 
          ", Name: " + name + 
          ", CodeSystem: " + codeSystem + 
          ", Type: " + type;
    }
  }

  private static final String OID_REGEX = "[0-2](\\.(0|[1-9][0-9]*))+";
  private final Map<String, OIDInfo> oidMap = new HashMap<>();


  public OIDUtilities() {
    loadOIDsFromCSV();
  }

  private void loadOIDsFromCSV() throws FHIRException {
    try {

      try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("oidregistry.csv");
          BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

        String line;
        boolean isHeaderProcessed = false;

        while ((line = reader.readLine()) != null) {
          if (!isHeaderProcessed) {
            // Skip header line
            isHeaderProcessed = true;
          } else {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
              OIDInfo info = new OIDInfo();
              info.setOid(parts[0].trim());
              info.setType(Integer.parseInt(parts[1].trim()));
              info.setName(parts[2].trim());
              info.setCodeSystem(parts[3].trim());

              // Add to map with OID as key
              oidMap.put(info.getOid(), info);
            }
          }
        }
      }
    } catch (Exception e) {
      throw new FHIRException(e);
    }
  }

  /*
  2.16.840.1.113883.3.72.5.2 - NIST owns this
  2.16.840.1.113883.4.6 - National Provider Identifier
  2.16.840.1.113883.6.21 - UB92
  2.16.840.1.113883.6.69 - NDC
   */

  public static String getUriForOid(String r) {
    if (r == null) {
      return null;
    }
    if (r.equals("2.16.840.1.113883.6.96"))
      return "http://snomed.info/sct";
    if (r.equals("2.16.840.1.113883.6.1"))
      return "http://loinc.org";
    if (r.equals("2.16.840.1.113883.6.8"))
      return "http://unitsofmeasure.org";
    if (r.equals("2.16.840.1.113883.6.3"))
      return "http://hl7.org/fhir/sid/icd-10";
    if (r.equals("2.16.840.1.113883.6.42"))
      return "http://hl7.org/fhir/sid/icd-9";
    if (r.equals("2.16.840.1.113883.6.104"))
      return "http://hl7.org/fhir/sid/icd-9";
    if (r.equals("2.16.840.1.113883.6.103"))
      return "http://hl7.org/fhir/sid/icd-9"; //todo: confirm this		
    if (r.equals("2.16.840.1.113883.6.73"))
      return "http://www.whocc.no/atc";
    if (r.equals("2.16.840.1.113883.3.26.1.1"))
      return "http://ncimeta.nci.nih.gov";
    if (r.equals("2.16.840.1.113883.3.26.1.1.1"))
      return "http://ncimeta.nci.nih.gov";
    if (r.equals("2.16.840.1.113883.6.88"))
      return "http://www.nlm.nih.gov/research/umls/rxnorm"; // todo: confirm this

    if (r.equals("2.16.840.1.113883.6.59"))
      return "http://hl7.org/fhir/sid/cvx";
    if (r.equals("2.16.840.1.113883.12.292"))
      return "http://hl7.org/fhir/sid/cvx";

    if (r.equals("2.16.840.1.113883.6.12"))
      return "http://www.ama-assn.org/go/cpt";

    return null;
  }

  public static String oidTail(String id) {
    if (id == null || !id.contains("."))
      return id;
    return id.substring(id.lastIndexOf(".") + 1);
  }

  public static String oidRoot(String id) {
    if (id == null || !id.contains("."))
      return id;
    return id.substring(0, id.indexOf("."));
  }

  public static boolean isValidOID(String oid) {
    return oid.matches(OID_REGEX);
  }

  public boolean isKnownOID(String url) {
    if (url == null || !url.startsWith("urn:oid:") ) {
      return false;
    } else {
      return oidMap.containsKey(url.substring(8));
    }
  }
}