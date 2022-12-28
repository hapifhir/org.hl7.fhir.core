package org.hl7.fhir.r5.profilemodel.gen;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEInstance;

/**
 * This class is a manually written example of the code that a POJO code
 * generator for Profiles would produce 
 * 
 * @author grahamegrieve
 *
 */
public class ProfileExample extends PEGeneratedBase {

  public ProfileExample(IWorkerContext context, Observation observation) {
    super();
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION_ID, true);
    instance = builder.buildPEInstance("http://hl7.org/fhir/test/StructureDefinition/pe-profile1", "0.1", observation);
  }
  
  /**
   * Extension http://hl7.org/fhir/test/StructureDefinition/pe-extension-simple, type code
   * @return
   */
  public CodeType getSimple() {
    return (CodeType) instance.forceChild("simple").asDataType();
  }
  
  public boolean hasSimple() {
    return instance.child("simple") != null;    
  }
  
  public ProfileExample clearSimple() {
    removeChild("simple");
    return this;
  }

  /*
   * this doesn't exist, because of the way infrastructure works.
   * You get the value and set the properties
   */
//  public void setSimple() {
//    return (CodeType) instance.forceChild("simple").asDataType();
//  }
}
