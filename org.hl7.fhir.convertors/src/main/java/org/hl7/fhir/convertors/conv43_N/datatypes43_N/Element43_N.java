package org.hl7.fhir.convertors.conv43_N.datatypes43_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Extension43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Element43_N {

  public final BaseAdvisor_43_N advisor;

  public Element43_N(BaseAdvisor_43_N advisor) {
    this.advisor = advisor;
  }

  public static boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.r4b.model.Element src,
                          org.hl7.fhir.model.core.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.model.core.Extension convertedExtension = new org.hl7.fhir.model.core.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension43_N.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.model.core.Element src,
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
          tgt.addExtension(Extension43_N.convertExtension(e));
        }
      });
  }
}
