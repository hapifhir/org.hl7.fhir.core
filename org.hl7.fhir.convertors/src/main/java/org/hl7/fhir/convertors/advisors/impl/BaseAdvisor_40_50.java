package org.hl7.fhir.convertors.advisors.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.exceptions.FHIRException;

public class BaseAdvisor_40_50 extends BaseAdvisor50<org.hl7.fhir.r4.model.Extension> {

  private static final List<String> TestScriptIgnoredUrls = Arrays.asList("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.scope");
  private boolean produceIllegalParameters = false;

  public BaseAdvisor_40_50() {

  }

  public BaseAdvisor_40_50(Boolean failFast) {
    this.failFast = failFast;
  }

  public BaseAdvisor_40_50(Boolean failFast, Boolean produceIllegalParameters) {
    this.failFast = failFast;
    this.produceIllegalParameters = produceIllegalParameters;
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

  public boolean produceIllegalParameters() {
    return produceIllegalParameters;
  }
}
