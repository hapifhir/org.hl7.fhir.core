package org.hl7.fhir.convertors.conv14_30.datatypes14_30;

import java.util.Arrays;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Element14_30 {

  public final BaseAdvisor_14_30 advisor;

  public Element14_30(BaseAdvisor_14_30 advisor) {
    this.advisor = advisor;
  }

  public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.dstu2016may.model.Element src,
                          org.hl7.fhir.dstu3.model.Element tgt,
                          String path,
                          String... extensionsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionsToIgnore)
        && (!(e.getUrl().equals(VersionConvertorConstants.PROFILE_EXTENSION)
        || e.getUrl().equals(VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION)
        || e.getUrl().equals(VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION))))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.dstu3.model.Extension convertedExtension = new org.hl7.fhir.dstu3.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension14_30.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.dstu3.model.Element src,
                          org.hl7.fhir.dstu2016may.model.Element tgt,
                          String path,
                          String... extensionsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.dstu2016may.model.Extension convertedExtension = new org.hl7.fhir.dstu2016may.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension14_30.convertExtension(e));
        }
      });
  }
}
