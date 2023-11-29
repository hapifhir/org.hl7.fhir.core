package org.hl7.fhir.validation.ipa;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.instance.InstanceValidator;

/**
 * You give this validator three parameters:
 *   URL of server
 *   access token for the server (most be already logged in)
 *   patient ID - the patient ID that was authorised by the log in
 *   
 * @author grahamegrieve
 *
 */
public class IPAValidator {

  public class ValidationNode {

    public ValidationNode(String string) {
      // TODO Auto-generated constructor stub
    }

    public List<ValidationMessage> getIssues() {
      // TODO Auto-generated method stub
      return null;
    }

    public String getName() {
      // TODO Auto-generated method stub
      return null;
    }

  }

  private String address;
  private String token;
  private String urn;
  private InstanceValidator validator;
  
  public IPAValidator(String address, String token, String urn, InstanceValidator validator) {
    super();
    this.address = address;
    this.token = token;
    this.urn = urn;
    this.validator = validator;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getToken() {
    return token;
  }
  
  public void setToken(String token) {
    this.token = token;
  }
  
  public String getUrn() {
    return urn;
  }
  
  public void setUrn(String urn) {
    this.urn = urn;
  }
  
  public InstanceValidator getValidator() {
    return validator;
  }
  
  public void setValidator(InstanceValidator validator) {
    this.validator = validator;
  }

  public void validate() {
    List<Element> patients = searchPatients();
    if (patients.size() > 0) {
      
    // validate all resources and links
    // validate search parameters
    // check self links
    
//    AllergyIntolerance  patient patient+clinical-status
//    Condition patient patient+category, patient+clinical-status, patient+code, patient+onset-date, patient+category+clinical_status
//    DocumentReference _id, patient, patient+category, patient+type  patient+category+date, patient+status, patient+type+period
//    Immunization  patient patient+date, patient+status
//    MedicationRequest patient patient+intent, patient+intent+authoredon, patient+intent+status
//    MedicationStatement subject subject+status
//    Observation patient+category, patient+code, patient+category+date patient+category+status, patient+code+date
//    Patient _id, identifier birthdate, family, gender, given, name, family+gender, birthdate+family, birthdate+name, gender+name
    
    }
    
    
    
  }

  private List<Element> searchPatients() {
    ValidationNode vn = new ValidationNode("Patient Search");
    log("Searching Patients");
    Element bundle = makeRequest(vn, "/Patient");
    List<Element> list = new ArrayList<>();
    if (bundle != null) {
      checkSelfLink(vn, bundle, null);
      List<Element> entries = bundle.getChildren("entry");
      int i = 0;
      for (Element entry : entries) {
        Element resource = entry.getNamedChild("resource", false);
        if (resource != null && resource.fhirType().equals("Patient")) {
          validator.validate(this, vn.getIssues(), "Bundle.entry["+i+"].resource", resource, "http://hl7.org/fhir/uv/ipa/StructureDefinition/ipa-patient");        
          list.add(resource);
        }
      }
    }
    if (list.size() > 1) {
      vn.getIssues().add(new ValidationMessage(Source.IPAValidator, IssueType.EXCEPTION, "patient.search", 
          "Multiple Patients found; check that this is an expected outcome",
          IssueSeverity.WARNING));              
    } else if (list.size() == 0) {
      vn.getIssues().add(new ValidationMessage(Source.IPAValidator, IssueType.EXCEPTION, "patient.search", 
          "No Patients found, unable to continue",
          IssueSeverity.ERROR));              
    }
    return list;
  }

  private void checkSelfLink(ValidationNode vn, Element bundle, Map<String, String> params) {
    // we check that there's a self link 
    Element sl = null;
    for (Element e : bundle.getChildren("link")) {
      if ("self".equals(e.getNamedChildValue("relation", false))) {
        sl = e.getNamedChild("url", false);
      }
    }
    if (sl == null) {
      vn.getIssues().add(new ValidationMessage(Source.IPAValidator, IssueType.EXCEPTION, vn.getName(), 
          "Self link not found in search result",
          IssueSeverity.ERROR));                    
    } else if (params != null) {
      // we check that all the provided params are in the self link
    }
  }

  private Element makeRequest(ValidationNode vn, String url)  {
    try {
      SimpleHTTPClient http = new SimpleHTTPClient();
      HTTPResult result = http.get(url, "application/fhir+json");
      if (result.getCode() >= 300) {
        vn.getIssues().add(new ValidationMessage(Source.IPAValidator, IssueType.EXCEPTION, "http.request", 
            "HTTP Return code is "+result.getCode()+" "+result.getMessage(),
            IssueSeverity.FATAL));        
        return null;
      } else if (result.getContent() == null || result.getContent().length == 0) {
        vn.getIssues().add(new ValidationMessage(Source.IPAValidator, IssueType.EXCEPTION, "http.request", 
            "No Content Returned",
            IssueSeverity.FATAL));        
        return null;
      } else {
        return new JsonParser(validator.getContext()).parse(new ByteArrayInputStream(result.getContent())).get(0).getElement();
      }
    } catch (Exception e) {
      vn.getIssues().add(new ValidationMessage(Source.IPAValidator, IssueType.EXCEPTION, "http.request", e.getMessage(),
          IssueSeverity.FATAL));
      return null;
    }
    
  }

  private void log(String msg) {
    System.out.println(msg);
  }
}
