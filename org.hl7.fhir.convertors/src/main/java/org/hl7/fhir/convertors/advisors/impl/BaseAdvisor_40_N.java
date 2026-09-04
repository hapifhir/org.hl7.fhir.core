package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisorN;
import org.hl7.fhir.exceptions.FHIRException;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class BaseAdvisor_40_N extends BaseAdvisorN<org.hl7.fhir.r4.model.Extension> {

  private static final List<String> TestScriptIgnoredUrls = Arrays.asList("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.scope");
  private boolean produceIllegalParameters = false;

  public BaseAdvisor_40_N() {

  }

  public BaseAdvisor_40_N(Boolean failFast) {
    this.failFast = failFast;
  }

  public BaseAdvisor_40_N(Boolean failFast, Boolean produceIllegalParameters) {
    this.failFast = failFast;
    this.produceIllegalParameters = produceIllegalParameters;
  }


  @Override
  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) throws FHIRException {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //single literal character split
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
