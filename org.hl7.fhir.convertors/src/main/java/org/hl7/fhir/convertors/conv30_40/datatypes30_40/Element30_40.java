package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Element30_40 {

  public final BaseAdvisor_30_40 advisor;

  public Element30_40(BaseAdvisor_30_40 advisor) {
    this.advisor = advisor;
  }

  public boolean isExemptExtension(String url, String[] extensionUrlsToIgnore) {
    return Arrays.asList(extensionUrlsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.dstu3.model.Element src,
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
          tgt.addExtension(Extension30_40.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.r4.model.Element src,
                          org.hl7.fhir.dstu3.model.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.dstu3.model.Extension convertedExtension = new org.hl7.fhir.dstu3.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension30_40.convertExtension(e));
        }
      });
  }
}
