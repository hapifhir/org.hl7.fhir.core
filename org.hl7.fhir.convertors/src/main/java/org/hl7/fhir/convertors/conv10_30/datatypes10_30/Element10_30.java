package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.exceptions.FHIRException;


public class Element10_30 {

  public final BaseAdvisor_10_30 advisor;

  public Element10_30(BaseAdvisor_10_30 advisor) {
    this.advisor = advisor;
  }

  public boolean isExemptExtension(String url, String[] extensionUrlsToIgnore) {
    return Arrays.asList(extensionUrlsToIgnore).contains(url);
  }

  public void copyElement(org.hl7.fhir.dstu2.model.Element src,
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
          tgt.addExtension(Extension10_30.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.dstu3.model.Element src,
                          org.hl7.fhir.dstu2.model.Element tgt,
                          String path,
                          String... extensionUrlsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionUrlsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.dstu2.model.Extension convertedExtension = new org.hl7.fhir.dstu2.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension10_30.convertExtension(e));
        }
      });
  }

  public void copyElement(org.hl7.fhir.dstu3.model.DomainResource src,
                          org.hl7.fhir.dstu2.model.Element tgt,
                          String path,
                          String... extensionsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    src.getExtension().stream()
      .filter(e -> !isExemptExtension(e.getUrl(), extensionsToIgnore))
      .forEach(e -> {
        if (advisor.useAdvisorForExtension(path, e)) {
          org.hl7.fhir.dstu2.model.Extension convertedExtension = new org.hl7.fhir.dstu2.model.Extension();
          advisor.handleExtension(path, e, convertedExtension);
          tgt.addExtension(convertedExtension);
        } else {
          tgt.addExtension(Extension10_30.convertExtension(e));
        }
      });
  }
}
