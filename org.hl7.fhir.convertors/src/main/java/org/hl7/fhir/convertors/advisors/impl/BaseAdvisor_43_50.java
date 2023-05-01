package org.hl7.fhir.convertors.advisors.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_43_50 extends BaseAdvisor50<org.hl7.fhir.r4b.model.Extension> {

  private static final List<String> TestScriptIgnoredUrls = Arrays.asList("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.scope");

  public BaseAdvisor_43_50() {
  }

  public BaseAdvisor_43_50(Boolean failFast) {
    this.failFast = failFast;
  }
  

  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    final List<String> paths = Arrays.asList(path.split(","));
    final String lastPath = paths.get(paths.size() - 1);
    if ((lastPath.equals("TestScript")) && (TestScriptIgnoredUrls.contains(url))) {
      return true;
    }
    else
      return false;
  }

}
