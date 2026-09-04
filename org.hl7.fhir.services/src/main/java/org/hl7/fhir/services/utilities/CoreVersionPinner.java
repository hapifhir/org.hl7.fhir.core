package org.hl7.fhir.services.utilities;

import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.utilities.UserDataNames;

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
      for (ValueSet.ConceptSetComponent vsi : vs.getCompose().getIncludeList()) {
        pinCoreVersions(vsi);
      }
      for (ValueSet.ConceptSetComponent vsi : vs.getCompose().getExcludeList()) {
        pinCoreVersions(vsi);
      }
    }
    for (StructureDefinition sd : sdList) {
      pinCoreVersionSD(sd.getBaseDefinitionElement());
      for (ElementDefinition ed : sd.getDifferential().getElementList()) {
        pinCoreVersions(ed);
      }
      for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
        pinCoreVersions(ed);
      }
    }
  }

  private void pinCoreVersions(ElementDefinition ed) {
    for (ElementDefinition.TypeRefComponent tr : ed.getTypeList()) {
      for (CanonicalType ct : tr.getProfileList()) {
        pinCoreVersionSD(ct);
      }
      for (CanonicalType ct : tr.getTargetProfileList()) {
        pinCoreVersionSD(ct);
      }
    }
    // for thoroughness - this is only defined in R5 but not used in core, and it's pinned there
    for (CanonicalType ct : ed.getValueAlternativesList()) {
      pinCoreVersionSD(ct);
    }
    if (ed.hasBinding()) {
      pinCoreVersionVS(ed.getBinding().getValueSetElement());
      for (ElementDefinition.ElementDefinitionBindingAdditionalComponent adb : ed.getBinding().getAdditionalList()) {
        pinCoreVersionVS(adb.getValueSetElement());
      }
    }

  }

  private void pinCoreVersions(ValueSet.ConceptSetComponent vsi) {
    for (CanonicalType ct : vsi.getValueSetList()) {
      pinCoreVersionVS(ct);
    }
    if (vsi.hasSystem() && !vsi.hasVersion()) {
      CodeSystem cs = context.fetchResource(CodeSystem.class, vsi.getSystem(), ExtensionUtilities.getVersionResolutionRules(vsi));
      if (cs != null && cs.hasVersion() && !vsi.getSystem().contains("terminology.hl7.org")) {
        vsi.setVersion(cs.getVersion());
        vsi.getVersionElement().setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

  private void pinCoreVersionCS(CanonicalType ct) {
    if (ct.hasValue() && !ct.getValue().contains("|") && !ct.getValue().contains("terminology.hl7.org")) {
      CodeSystem cs = context.fetchResource(CodeSystem.class, ct.getValue(), ExtensionUtilities.getVersionResolutionRules(ct));
      if (cs != null && cs.hasVersion()) {
        ct.setValue(ct.getValue() + "|" + cs.getVersion());
        ct.setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

  private void pinCoreVersionVS(CanonicalType ct) {
    if (ct.hasValue() && !ct.getValue().contains("|") && !ct.getValue().contains("terminology.hl7.org")) {
      ValueSet vs = context.fetchResource(ValueSet.class, ct.getValue(), ExtensionUtilities.getVersionResolutionRules(ct));
      if (vs != null && vs.hasVersion()) {
        ct.setValue(ct.getValue() + "|" + vs.getVersion());
        ct.setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

  private void pinCoreVersionSD(CanonicalType ct) {
    if (ct.hasValue() && !ct.getValue().contains("|")) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, ct.getValue(), ExtensionUtilities.getVersionResolutionRules(ct));
      if (sd != null && sd.hasVersion()) {
        ct.setValue(ct.getValue() + "|" + sd.getVersion());
        ct.setUserData(UserDataNames.VERSION_PINNED_ON_LOAD, true);
      }
    }
  }

}
