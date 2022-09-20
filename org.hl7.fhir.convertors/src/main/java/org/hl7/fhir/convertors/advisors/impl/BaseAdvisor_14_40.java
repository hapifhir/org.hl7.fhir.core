package org.hl7.fhir.convertors.advisors.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor40;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Type;

public class BaseAdvisor_14_40 extends BaseAdvisor40<org.hl7.fhir.dstu2016may.model.Extension> {

  final List<String> conformanceIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");
  private final List<String> ignoredUrls = new ArrayList<>(Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"));
  private final List<Class<?>> ignoredExtensionTypes = new ArrayList<>(Collections.singletonList(Expression.class));

  public BaseAdvisor_14_40() {
  }

  public BaseAdvisor_14_40(Boolean failFast) {
    this.failFast = failFast;
  }


  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
    List<String> paths = Arrays.asList(path.split(","));
    if ((paths.get(paths.size() - 1).equals("Conformance")) && (conformanceIgnoredUrls.contains(url))) {
      return true;
    } else {
      return this.ignoredUrls.contains(url);
    }
  }

  public boolean ignoreType(@Nonnull String path, @Nonnull Type type) {
    return ignoredExtensionTypes.contains(type.getClass());
  }
}
