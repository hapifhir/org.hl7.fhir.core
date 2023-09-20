package org.hl7.fhir.utilities;

public class HL7WorkGroups {

  public static class HL7WorkGroup {
    private String link;
    private String name;
    private String code;
    
    
    protected HL7WorkGroup(String code, String name, String link) {
      super();
      this.code = code;
      this.name = name;
      this.link = link;
    }
    public String getLink() {
      return link;
    }
    public String getName() {
      return name;
    }
    public String getCode() {
      return code;
    }
  }

  public static HL7WorkGroup find(String wg) {
   String name = nameForWG(wg);
   String url = urlForWG(wg);
   if (name != null) {
     return new HL7WorkGroup(wg, name, url);
   } else {
     return null;
   }
  }
  

  private static String urlForWG(String wg) {
    switch (wg) {
    case "cbcc": return "http://www.hl7.org/Special/committees/homehealth";
    case "cds": return "http://www.hl7.org/Special/committees/dss";
    case "cqi": return "http://www.hl7.org/Special/committees/cqi";
    case "cic" : return "http://www.hl7.org/Special/committees/cic";
    case "cg": return "http://www.hl7.org/Special/committees/clingenomics";
    case "dev": return "http://www.hl7.org/Special/committees/healthcaredevices";
    case "ehr": return "http://www.hl7.org/special/committees/ehr";
    case "fhir": return "http://www.hl7.org/Special/committees/fiwg";
    case "fm": return "http://www.hl7.org/Special/committees/fm";
    case "hsi": return "http://www.hl7.org/Special/committees/hsi";
    case "ii": return "http://www.hl7.org/Special/committees/imagemgt";
    case "inm": return "http://www.hl7.org/special/committees/inm";
    case "mnm": return "http://www.hl7.org/special/committees/mnm";
    case "its": return "http://www.hl7.org/special/committees/xml";
    case "oo": return "http://www.hl7.org/Special/committees/orders";
    case "pa": return "http://www.hl7.org/Special/committees/pafm";
    case "pc": return "http://www.hl7.org/Special/committees/patientcare";
    case "pe": return "http://www.hl7.org/Special/committees/patientempowerment";
    case "pher": return "http://www.hl7.org/Special/committees/pher";
    case "phx": return "http://www.hl7.org/Special/committees/medication";
    case "brr": return "http://www.hl7.org/Special/committees/rcrim";
    case "sd": return "http://www.hl7.org/Special/committees/structure";
    case "sec": return "http://www.hl7.org/Special/committees/secure";
    case "us": return "http://www.hl7.org/Special/Committees/usrealm";
    case "vocab": return "http://www.hl7.org/Special/committees/Vocab";
    case "aid": return "http://www.hl7.org/Special/committees/java";
    }
    return null;
  }

  private static String nameForWG(String wg) {
    switch (wg) {

    case "cbcc": return "Community Based Collaborative Care";
    case "cds": return "Clinical Decision Support";
    case "cic" : return "Clinical Interoperability Council";
    case "cqi": return "Clinical Quality Information";
    case "cg": return "Clinical Genomics";
    case "dev": return "Health Care Devices";
    case "ehr": return "Electronic Health Records";
    case "fhir": return "FHIR Infrastructure";
    case "fm": return "Financial Management";
    case "hsi": return "Health Standards Integration";
    case "ii": return "Imaging Integration";
    case "inm": return "Infrastructure And Messaging";
    case "mnm": return "Modeling and Methodology";
    case "its": return "Implementable Technology Specifications";
    case "oo": return "Orders and Observations";
    case "pa": return "Patient Administration";
    case "pc": return "Patient Care";
    case "pe": return "Patient Empowerment";
    case "pher": return "Public Health and Emergency Response";
    case "phx": return "Pharmacy";
    case "brr": return "Biomedical Research and Regulation";
    case "sd": return "Structured Documents";
    case "sec": return "Security";
    case "us": return "US Realm Taskforce";
    case "vocab": return "Terminology Infrastructure";
    case "aid": return "Application Implementation and Design";
    }
    return null;
  }
  
  
}
