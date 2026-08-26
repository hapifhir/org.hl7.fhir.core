package org.hl7.fhir.convertors.conv50_N.datatypes50_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Extension50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Element50_N {

  public final BaseAdvisor_50_N advisor;

  public Element50_N(BaseAdvisor_50_N advisor) {
    this.advisor = advisor;
  }

  public static boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.r5.model.Element src,
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
          tgt.addExtension(Extension50_N.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.model.core.Element src,
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
          tgt.addExtension(Extension50_N.convertExtension(e));
        }
      });
  }
}
