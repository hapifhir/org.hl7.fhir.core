package org.hl7.fhir.utilities;

public class HL7WorkGroups {

  public static class HL7WorkGroup {
    private String link;
    private String name;
    private String name2;
    private String code;


    protected HL7WorkGroup(String code, String name, String name2, String link) {
      super();
      this.code = code;
      this.name = name;
      this.name2 = name2;
      this.link = link;
    }
    public String getLink() {
      return link;
    }
    public String getName() {
      return name;
    }
    public String getName2() {
      return name2;
    }
    public String getCode() {
      return code;
    }
  }

  public static HL7WorkGroup find(String wg) {
    String name = nameForWG(wg);
    String name2 = name2ForWG(wg);
    String url = urlForWG(wg);
    if (name != null) {
      return new HL7WorkGroup(wg, name, name2, url);
    } else {
      return null;
    }
  }


  private static String urlForWG(String wg) {
    switch (wg) {

    case "aid": return "http://www.hl7.org/Special/committees/java";
    case "arden": return "http://www.hl7.org/Special/committees/arden";
    case "brr": return "http://www.hl7.org/Special/committees/rcrim";
    case "cbcc": return "http://www.hl7.org/Special/committees/cbcc";
    case "cdamg": return "http://www.hl7.org/Special/committees/cdamg";
    case "cds": return "http://www.hl7.org/Special/committees/dss";
    case "cg": return "http://www.hl7.org/Special/committees/clingenomics";
    case "cgp": return "http://www.hl7.org/Special/committees/cgp";
    case "cic": return "http://www.hl7.org/Special/committees/cic";
    case "cimi": return "http://www.hl7.org/Special/committees/cimi";
    case "claims": return "http://www.hl7.org/Special/committees/claims";
    case "cqi": return "http://www.hl7.org/Special/committees/cqi";
    case "dev": return "http://www.hl7.org/Special/committees/healthcaredevices";
    case "ehr": return "http://www.hl7.org/Special/committees/ehr";
    case "ec": return "http://www.hl7.org/Special/committees/emergencycare";
    case "fhir": return "http://www.hl7.org/Special/committees/fiwg";
    case "fmg": return "http://www.hl7.org/Special/committees/fhirmg";
    case "fm": return "http://www.hl7.org/Special/committees/fm";
    case "hsi": return "http://www.hl7.org/Special/committees/hsi";
    case "hsswg": return "http://www.hl7.org/Special/committees/hsswg";
    case "hta": return "http://www.hl7.org/Special/committees/termauth";
    case "ictc": return "http://www.hl7.org/Special/committees/ictc";
    case "ii": return "http://www.hl7.org/Special/committees/imagemgt";
    case "inm": return "http://www.hl7.org/Special/committees/inm";
    case "its": return "http://www.hl7.org/Special/committees/xml";
    case "lhs": return "http://www.hl7.org/Special/committees/lhs";
    case "mnm": return "http://www.hl7.org/Special/committees/mnm";
    case "mobile": return "http://www.hl7.org/Special/committees/mobile";
    case "oo": return "http://www.hl7.org/Special/committees/orders";
    case "pa": return "http://www.hl7.org/Special/committees/pafm";
    case "pe": return "http://www.hl7.org/Special/committees/patientempowerment";
    case "pc": return "http://www.hl7.org/Special/committees/patientcare";
    case "pher": return "http://www.hl7.org/Special/committees/pher";
    case "phx": return "http://www.hl7.org/Special/committees/medication";
    case "sd": return "http://www.hl7.org/Special/committees/structure";
    case "sec": return "http://www.hl7.org/Special/committees/secure";
    case "soa": return "http://www.hl7.org/Special/committees/soa";
    case "ti": return "http://www.hl7.org/Special/committees/Vocab";
    case "tsmg": return "TSMG) (http://www.hl7.org/Special/committees/tsmg";
    case "us": return "http://www.hl7.org/Special/committees/usrealm";
    case "v2": return "http://www.hl7.org/Special/committees/v2management";
    case "vocab": return "http://www.hl7.org/Special/committees/Vocab";

    }
    return null;
  }

  private static String nameForWG(String wg) {
    switch (wg) {
    case "aid": return "Application Implementation and Design";
    case "arden": return "Arden Syntax";
    case "brr": return "Biomedical Research and Regulation";
    case "cbcc": return "Community Based Collaborative Care";
    case "cdamg": return "CDA Management Group";
    case "cds": return "Clinical Decision Support";
    case "cg": return "Clinical Genomics";
    case "cgp": return "Cross-Group Projects";
    case "cic": return "Clinical Interoperability Council";
    case "cimi": return "Clinical Information Modeling Initiative";
    case "claims": return "Payer/Provider Information Exchange Work Group";
    case "cqi": return "Clinical Quality Information";
    case "dev": return "Health Care Devices";
    case "ehr": return "Electronic Health Records";
    case "ec": return "Emergency Care";
    case "fhir": return "FHIR Infrastructure";
    case "fmg": return "FHIR Management Group";
    case "fm": return "Financial Management";
    case "hsi": return "Health Standards Integration";
    case "hsswg": return "Human and Social Services";
    case "hta": return "Terminology Authority";
    case "ictc": return "Conformance";
    case "ii": return "Imaging Integration";
    case "inm": return "Infrastructure And Messaging";
    case "its": return "Implementable Technology Specifications";
    case "lhs": return "Learning Health Systems";
    case "mnm": return "Modeling and Methodology";
    case "mobile": return "Mobile Health";
    case "oo": return "Orders and Observations";
    case "pa": return "Patient Administration";
    case "pe": return "Patient Empowerment";
    case "pc": return "Patient Care";
    case "pher": return "Public Health";
    case "phx": return "Pharmacy";
    case "sd": return "Structured Documents";
    case "sec": return "Security";
    case "soa": return "Services Oriented Architecture";
    case "ti": return "Terminology Infrastructure";
    case "tsmg": return "Terminology Services Management Group (TSMG)";
    case "us": return "US Realm Steering Committee";
    case "v2": return "V2 Management Group";
    case "vocab": return "Terminology Infrastructure";
    }
    return null;
  }

  private static String name2ForWG(String wg) {
    switch (wg) {
    case "ti": return "Vocabulary";
    case "vocab": return "Vocabulary";
    }
    return null;
  }

}
