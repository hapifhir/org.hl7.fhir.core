package org.hl7.fhir.convertors.conv40_50.datatypes40_50;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Element40_50 {

  public final BaseAdvisor_40_50 advisor;

  public Element40_50(BaseAdvisor_40_50 advisor) {
    this.advisor = advisor;
  }

  public static boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.r4.model.Element src,
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
          tgt.addExtension(Extension40_50.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.r5.model.Element src,
                          org.hl7.fhir.r4.model.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.r4.model.Extension convertedExtension = new org.hl7.fhir.r4.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension40_50.convertExtension(e));
        }
      });
  }
}
