package org.hl7.fhir.convertors.advisors.impl;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor50;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Expression;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseAdvisor_10_50 extends BaseAdvisor50<org.hl7.fhir.dstu2.model.Extension> {
  final List<String> conformanceIgnoredUrls = Collections.singletonList("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");
  private final List<Class<?>> ignoredExtensionTypes = new ArrayList<>(Collections.singletonList(Expression.class));

  public BaseAdvisor_10_50() {
  }

  public BaseAdvisor_10_50(Boolean failFast) {
    this.failFast = failFast;
  }

  public boolean ignoreExtension(@Nonnull String path,
                                 @Nonnull String url) {
    List<String> paths = Arrays.asList(path.split(","));
    return (paths.get(paths.size() - 1).equals("Conformance")) && (conformanceIgnoredUrls.contains(url));
  }

  public boolean ignoreType(@Nonnull String path,
                            @Nonnull DataType type) {
    return ignoredExtensionTypes.contains(type.getClass());
  }
}
