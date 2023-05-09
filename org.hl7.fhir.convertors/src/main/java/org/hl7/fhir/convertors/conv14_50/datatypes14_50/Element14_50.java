package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Element14_50 {

  public final BaseAdvisor_14_50 advisor;

  public Element14_50(BaseAdvisor_14_50 advisor) {
    this.advisor = advisor;
  }

  public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }


  public void copyElement(org.hl7.fhir.dstu2016may.model.Element src,
                          org.hl7.fhir.r5.model.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.r5.model.Extension convertedExtension = new org.hl7.fhir.r5.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension14_50.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.r5.model.Element src,
                          org.hl7.fhir.dstu2016may.model.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.dstu2016may.model.Extension convertedExtension = new org.hl7.fhir.dstu2016may.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension14_50.convertExtension(e));
        }
      });
  }
}
