package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;

public class ProfiledElement {

  ProfiledElementBuilder builder;
  String name;
  StructureDefinition baseStructure;
  ElementDefinition baseDefinition;
  StructureDefinition profileStructure;
  ElementDefinition profiledDefinition;
  Base data; // might be null if we're not attached to an instance
  private List<ProfiledElement> children;
  private Object sliceDefinition;
  
  /**
   * Don't create one of these directly - always use the public methods on ProfiledElementBuilder
   *  
   * @param builder
   * @param baseElement
   * @param profiledElement
   * @param data
   */
  protected ProfiledElement(ProfiledElementBuilder builder, String name, ElementDefinition baseDefinition,
      ElementDefinition profiledDefinition, Base data) {
    super();
    this.builder = builder;
    this.name = name;
    this.baseDefinition = baseDefinition;
    this.profiledDefinition = profiledDefinition;
    this.data = data;
  }

  protected ProfiledElement(ProfiledElementBuilder builder, String name, StructureDefinition base, ElementDefinition baseDefinition, 
      StructureDefinition profile, ElementDefinition profiledDefinition) {
    this.builder = builder;
    this.name = name;
    this.baseStructure = base;
    this.baseDefinition = baseDefinition;
    this.profileStructure = profile;
    this.profiledDefinition = profiledDefinition;
  }

  public ProfiledElement(ProfiledElementBuilder builder, String name, StructureDefinition base, ElementDefinition baseDefinition, 
            StructureDefinition profile, ElementDefinition profiledDefinition, ElementDefinition sliceDefinition) {
    this.builder = builder;
    this.name = name;
    this.baseStructure = base;
    this.baseDefinition = baseDefinition;
    this.profileStructure = profile;
    this.profiledDefinition = profiledDefinition;
    this.sliceDefinition = sliceDefinition;
  }

  /** 
   * @return The name of the element or slice in the profile (always unique amongst children)
   */
  public String name() {
    return name;
  }

  /**
   * @return The name of the element in the resource (may be different to the slice name)
   */
  public String schemaName() {
    return baseDefinition.getName();
  }
  
  /**
   * @return a list of types. There is always at least one type; it might be Element, Type, BackboneElement or BackboneType
   */
  public List<String> types() {
    List<String> res = new ArrayList<>();
    if (!profiledDefinition.hasType()) {
      if (!profiledDefinition.getPath().contains(".")) {
        res.add(profileStructure.getType());
      } else {
        throw new DefinitionException("What?");
      }
    } else {
      for (TypeRefComponent t : profiledDefinition.getType()) {
        if (t.hasProfile()) {
          for (CanonicalType u : t.getProfile()) {
            res.add(t.getWorkingCode()+"["+u.getValue()+"]");
          }
        } else {
          res.add(t.getWorkingCode());
        }
      }
    }
    return res;
  }
  
  /**
   * @return The minimum number of repeats allowed
   */
  public int min() {
    return profiledDefinition.getMin();
  }
  
  /**
   * @return the maximum number of repeats allowed
   */
  public int max() {
    return "*".equals(profiledDefinition.getMax()) ? Integer.MAX_VALUE : Integer.parseInt(profiledDefinition.getMax());
  }
  
  /**
   * @return the definition of the element in the profile (fully populated)
   */
  public ElementDefinition definition() {
    return profiledDefinition;
  }
  
  /**
   * @return the definition of the element in the base specification
   */
  public ElementDefinition baseDefinition() {
    return baseDefinition;
  }
  
  /**
   * @return the short documentation of the definition (shown in the profile table view)
   */
  public String shortDocumentation() {
    return profiledDefinition.getShort();
  }
  
  /**
   * @return the full definition of the element (markdown syntax)
   */
  public String documentation() {
    return profiledDefinition.getDefinition();
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
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public List<ProfiledElement> children(String type) {
    if (children == null) {
      if (!profiledDefinition.hasType() && profileStructure.getType().equals(type)) {
        children = builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, null);            
      } else {
        for (TypeRefComponent t : profiledDefinition.getType()) {
          if (t.hasProfile()) {
            for (CanonicalType u : t.getProfile()) {
              if ((t.getWorkingCode()+"["+u.getValue()+"]").equals(type)) {
                children = builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, t, u);            
              }
            }
          } else {
            if (t.getWorkingCode().equals(type)) {
              children = builder.listChildren(baseStructure, baseDefinition, profileStructure, profiledDefinition, t);
            }
          }
        }
      }
    }
    if (children != null) {
      return children;
    }
    throw new DefinitionException("Unable to understand type '"+type+"'");
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

  @Override
  public String toString() {
    return name+"("+schemaName()+"):"+types().toString()+" ["+min()+":"+max()+"] \""+shortDocumentation()+"\"";
  }
  
}


