package org.hl7.fhir.validation.ipa;

import java.util.List;

import org.hl7.fhir.r4.model.Patient;
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
    List<Patient> patients = searchPatients();
    // check list of patients that have access to
    // require that at least one of the patients matches the URL
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

  private List<Patient> searchPatients() {
    
    return null;
  }
}
