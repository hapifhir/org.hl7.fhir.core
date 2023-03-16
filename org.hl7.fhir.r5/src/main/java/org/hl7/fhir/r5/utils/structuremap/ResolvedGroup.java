package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent;

public class ResolvedGroup {
  private StructureMap.StructureMapGroupComponent targetGroup;
  private StructureMap targetMap;
  
  public ResolvedGroup(StructureMap targetMap, StructureMapGroupComponent targetGroup) {
    super();
    this.targetMap = targetMap;
    this.targetGroup = targetGroup;
  }
  
  public StructureMap.StructureMapGroupComponent getTargetGroup() {
    return targetGroup;
  }
  public StructureMap getTargetMap() {
    return targetMap;
  }

  public void setTargetGroup(StructureMap.StructureMapGroupComponent targetGroup) {
    this.targetGroup = targetGroup;
  }

  public void setTargetMap(StructureMap targetMap) {
    this.targetMap = targetMap;
  }
  
  
}
