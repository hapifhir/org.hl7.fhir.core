package org.hl7.fhir.r4b.utils.validation.constants;

public enum CodedContentValidationPolicy {
  /**
   * don't validate the code
   */
  IGNORE,  
  
  /**
   * validate the code against the underlying code systems
   */
  CODE,    
  
  /**
   * validate the code against the value set too. 
   * Note that this isn't much faster than just validating the code since 
   * the expensive part is hitting the terminology server (if necessary) 
   * and that has to be done for the code part too
   */
  VALUESET //  
}
