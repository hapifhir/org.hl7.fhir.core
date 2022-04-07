package org.hl7.fhir.r4b.conformance;

import org.hl7.fhir.r4b.model.ElementDefinition;
import org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.utilities.VersionUtilities;

/**
 * This doesn't do anythign at this time
 * 
 * @author graha
 *
 */
public class StructureDefinitionHacker {

  private String version;

  public StructureDefinitionHacker(String version) {
    super();
    this.version = version;
  }

  public Resource fixSD(StructureDefinition sd) {
    return sd;
  }


}
