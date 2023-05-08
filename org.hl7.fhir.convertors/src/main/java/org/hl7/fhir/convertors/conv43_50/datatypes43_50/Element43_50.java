package org.hl7.fhir.convertors.conv43_50.datatypes43_50;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Extension43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Element43_50 {

  public final BaseAdvisor_43_50 advisor;

  public Element43_50(BaseAdvisor_43_50 advisor) {
    this.advisor = advisor;
  }

  public static boolean isExemptExtension(String url, String[] extensionUrlsToIgnore) {
    return Arrays.asList(extensionUrlsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.r4b.model.Element src,
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
          tgt.addExtension(Extension43_50.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.r5.model.Element src,
                          org.hl7.fhir.r4b.model.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.r4b.model.Extension convertedExtension = new org.hl7.fhir.r4b.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension43_50.convertExtension(e));
        }
      });
  }
}
