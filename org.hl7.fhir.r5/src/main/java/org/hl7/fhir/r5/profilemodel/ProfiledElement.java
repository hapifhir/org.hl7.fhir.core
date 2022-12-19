package org.hl7.fhir.r5.profilemodel;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ValueSet;

public class ProfiledElement {

  /** 
   * @return The name of the element or slice in the profile (always unique amongst children)
   */
  public String name() {
    throw new NotImplementedException("Not done yet");
  }

  /**
   * @return The name of the element in the resource (may be different to the slice name)
   */
  public String schemaName() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return a list of types. There is always at least one type; it might be Element, Type, BackboneElement or BackboneType
   */
  public List<String> types() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return The minimum number of repeats allowed
   */
  public int min() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return the maximum number of repeats allowed
   */
  public int max() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return the definition of the element in the profile (fully populated)
   */
  public ElementDefinition definition() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return the definition of the element in the base specification
   */
  public ElementDefinition baseDefinition() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return the short documentation of the definition (shown in the profile table view)
   */
  public String shortDocumentation() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return the full definition of the element (markdown syntax)
   */
  public String documentation() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return if the base definition 
   */
  public ValueSet expansion() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @param type - one of the types listed in types()
   * @return - the list of children for the nominated type
   * 
   * Note that the children returned from this instance can run off the 
   * end of the data provided, and then inDataMode() is false
   */
  public List<ProfiledElement> children(String type) {
    throw new NotImplementedException("Not done yet");
  }
  
  // -- instance data ---------------------------------------
  
  /** 
   * true if the profiled element is part of a tree built based on 
   * a resource 
   */
  public void inDataMode() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * return a list of profiled elements that are instances of 
   * of this element - these are attached to acual underlying data in the resource
   * @return
   */
  public List<ProfiledElement> instances() {
    throw new NotImplementedException("Not done yet");
  };
  
  /**
   * Create a new instance of data that conforms to this profiled element 
   * 
   * @return
   */
  public ProfiledElement addInstance(){
    throw new NotImplementedException("Not done yet");
  }

  /**
   * @return true if this element can have a primitive value 
   * 
   *  Note that an element can have extensions as well as a value, so that doesn't mean it can't have children
   */
  public boolean canHavePrimitiveValue() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return true if this element has a primitive value  
   * 
   *  Note that an element can have extensions as well as a value, so that doesn't mean it can't have children
   */
  public boolean hasPrimitiveValue() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return true if this element has a primitive value  
   * 
   *  Note that an element can have extensions as well as a value, so that doesn't mean it can't have children
   */
  public String getPrimitiveValue() {
    throw new NotImplementedException("Not done yet");
  }
  
  /**
   * @return true if this element has a primitive value  
   * 
   *  Note that an element can have extensions as well as a value, so that doesn't mean it can't have children
   */
  public String setPrimitiveValue() {
    throw new NotImplementedException("Not done yet");
  }
  
  
}


