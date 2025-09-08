package org.hl7.fhir.r5.context;

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManagerFactory;

import java.util.List;

public class CoreVersionPinner {

  IWorkerContext context;
  public CoreVersionPinner(IWorkerContext context) {
    this.context = context;
  }

  public void pinCoreVersions(List<CodeSystem> cslist, List<ValueSet> vslist, List<StructureDefinition> sdList) {
    for (CodeSystem cs : cslist) {
      pinCoreVersionVS(cs.getValueSetElement());
      // this is for thoroughness, though there are no supplements in nay core version
      pinCoreVersionCS(cs.getSupplementsElement());
    }
    for (ValueSet vs : vslist) {
      for (ValueSet.ConceptSetComponent vsi : vs.getCompose().getInclude()) {
        pinCoreVersions(vsi);
      }
      for (ValueSet.ConceptSetComponent vsi : vs.getCompose().getExclude()) {
        pinCoreVersions(vsi);
      }
    }
    for (StructureDefinition sd : sdList) {
      pinCoreVersionSD(sd.getBaseDefinitionElement());
      for (ElementDefinition ed : sd.getDifferential().getElement()) {
        pinCoreVersions(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        pinCoreVersions(ed);
      }
    }
  }

  private void pinCoreVersions(ElementDefinition ed) {
    for (ElementDefinition.TypeRefComponent tr : ed.getType()) {
      for (CanonicalType ct : tr.getProfile()) {
        pinCoreVersionSD(ct);
      }
      for (CanonicalType ct : tr.getTargetProfile()) {
        pinCoreVersionSD(ct);
      }
    }
    // for thoroughness - this is only defined in R5 but not used in core, and it's pinned there
    for (CanonicalType ct : ed.getValueAlternatives()) {
      pinCoreVersionSD(ct);
    }
    if (ed.hasBinding()) {
      pinCoreVersionVS(ed.getBinding().getValueSetElement());
      for (ElementDefinition.ElementDefinitionBindingAdditionalComponent adb : ed.getBinding().getAdditional()) {
        pinCoreVersionVS(adb.getValueSetElement());
      }
    }

  }

  private void pinCoreVersions(ValueSet.ConceptSetComponent vsi) {
    for (CanonicalType ct : vsi.getValueSet()) {
      pinCoreVersionVS(ct);
    }
    if (vsi.hasSystem() && !vsi.hasVersion()) {
      CodeSystem cs = context.fetchResource(CodeSystem.class, vsi.getSystem());
      if (cs != null && cs.hasVersion() && !vsi.getSystem().contains("terminology.hl7.org")) {
        vsi.setVersion(cs.getVersion());
        vsi.getVersionElement().setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

  private void pinCoreVersionCS(CanonicalType ct) {
    if (ct.hasValue() && !ct.getValue().contains("|") && !ct.getValue().contains("terminology.hl7.org")) {
      CodeSystem cs = context.fetchResource(CodeSystem.class, ct.getValue());
      if (cs != null && cs.hasVersion()) {
        ct.setValue(ct.getValue() + "|" + cs.getVersion());
        ct.setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

  private void pinCoreVersionVS(CanonicalType ct) {
    if (ct.hasValue() && !ct.getValue().contains("|") && !ct.getValue().contains("terminology.hl7.org")) {
      ValueSet vs = context.fetchResource(ValueSet.class, ct.getValue());
      if (vs != null && vs.hasVersion()) {
        ct.setValue(ct.getValue() + "|" + vs.getVersion());
        ct.setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

  private void pinCoreVersionSD(CanonicalType ct) {
    if (ct.hasValue() && !ct.getValue().contains("|")) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, ct.getValue());
      if (sd != null && sd.hasVersion()) {
        ct.setValue(ct.getValue() + "|" + sd.getVersion());
        ct.setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

}
