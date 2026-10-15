package org.hl7.fhir.services.fml;

import java.util.IdentityHashMap;
import java.util.Map;

import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.model.fml.StructureMap;

public class TransformContext {
  private Object appInfo;
  // constants belong to the map that declares them. Each map whose groups run during the transform
  // gets one resolver, so its constants are evaluated at most once per transform
  private final Map<StructureMap, StructureMapConstantResolver> constants = new IdentityHashMap<>();

  public TransformContext(Object appInfo) {
    super();
    this.appInfo = appInfo;
  }

  public Object getAppInfo() {
    return appInfo;
  }

  /**
   * The constant resolver for a map, or null if it has no constants
   */
  StructureMapConstantResolver getConstants(StructureMap map, FHIRPathEngine fpe) {
    if (map == null || !map.hasConst()) {
      return null;
    }
    return constants.computeIfAbsent(map, m -> new StructureMapConstantResolver(m, fpe));
  }

}
