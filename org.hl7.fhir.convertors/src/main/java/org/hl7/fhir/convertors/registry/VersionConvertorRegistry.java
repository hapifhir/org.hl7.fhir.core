package org.hl7.fhir.convertors.registry;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.igs.VersionConvertorIGBase;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.VersionUtilities;

import java.util.ArrayList;
import java.util.List;

public class VersionConvertorRegistry {

  private List<VersionConvertorIGBase> registeredConvertors = new ArrayList<>();

  public void register(VersionConvertorIGBase convertor) {
    registeredConvertors.add(convertor);
  }

  public boolean isHandled(String resourceType, String version) {
    if (VersionUtilities.isR4Ver(version)) {
      for (VersionConvertorIGBase converterIGBase : registeredConvertors) {
        if (converterIGBase.handlesR5ToR4(resourceType)) {
          return true;
        }
      }
    } else if (VersionUtilities.isR5Ver(version)) {
      for (VersionConvertorIGBase converterIGBase : registeredConvertors) {
        if (converterIGBase.handlesR5ToR5(resourceType)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * This method converts from R5 to R5, but it does something very specific: it converts
   * from the additional resource definition to whatever is appropriate in R5.
   *
   * in the future, this will become an R6 based conversion, not R5
   *
   * @param source
   * @return
   */
  public org.hl7.fhir.r5.model.Resource convertToR5(org.hl7.fhir.r5.model.Resource source) {
    for (VersionConvertorIGBase converterIGBase : registeredConvertors) {
      if (converterIGBase.handlesR5ToR5(source.fhirType())) {
        return converterIGBase.convertR5ToR5(source);
      }
    }
    return source;
  }

  public org.hl7.fhir.r4.model.Resource convertToR4(org.hl7.fhir.r5.model.Resource source) {
    for (VersionConvertorIGBase converterIGBase : registeredConvertors) {
      if (converterIGBase.handlesR5ToR4(source.fhirType())) {
        return converterIGBase.convertR5ToR4(source);
      }
    }
    return  VersionConvertorFactory_40_50.convertResource(source);
  }

  public org.hl7.fhir.dstu3.model.Resource convertToR3(org.hl7.fhir.r5.model.Resource source) {
    throw new FHIRException("Converting resources to R3 Not supported (nor planned)");
  }

}
