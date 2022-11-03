package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus;
import org.hl7.fhir.dstu3.model.ExpansionProfile.DesignationIncludeDesignationComponent;
import org.hl7.fhir.dstu3.model.ExpansionProfile.SystemVersionProcessingMode;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DataType;

public class ExpansionProfile30_50 {

  public static org.hl7.fhir.dstu3.model.ExpansionProfile convertExpansionProfile(org.hl7.fhir.r5.model.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ExpansionProfile tgt = new org.hl7.fhir.dstu3.model.ExpansionProfile();
    if (src.hasParameterValue("profile-url"))
      tgt.setUrl(src.getParameterValue("profile-url").primitiveValue());
    if (src.hasParameterValue("profile-version"))
      tgt.setVersion(src.getParameterValue("profile-version").primitiveValue());
    if (src.hasParameterValue("profile-name"))
      tgt.setName(src.getParameterValue("profile-name").primitiveValue());
    if (src.hasParameterValue("profile-status"))
      tgt.setStatus(PublicationStatus.fromCode(src.getParameterValue("profile-status").primitiveValue()));
    for (DataType t : src.getParameterValues("system-version")) {
      String[] v = t.primitiveValue().split("\\|");
      tgt.addFixedVersion().setSystem(v[0]).setVersion(v[1]).setMode(SystemVersionProcessingMode.DEFAULT);
    }
    for (DataType t : src.getParameterValues("force-system-version")) {
      String[] v = t.primitiveValue().split("\\|");
      tgt.addFixedVersion().setSystem(v[0]).setVersion(v[1]).setMode(SystemVersionProcessingMode.OVERRIDE);
    }
    for (DataType t : src.getParameterValues("check-system-version")) {
      String[] v = t.primitiveValue().split("\\|");
      tgt.addFixedVersion().setSystem(v[0]).setVersion(v[1]).setMode(SystemVersionProcessingMode.CHECK);
    }
    for (DataType t : src.getParameterValues("exclude-system")) {
      String[] v = t.primitiveValue().split("\\|");
      tgt.getExcludedSystem().setSystem(v[0]).setVersion(v[1]);
    }
    if (src.hasParameterValue("includeDesignations"))
      tgt.setIncludeDesignations(src.getParameterBool(""));
    for (DataType t : src.getParameterValues("designation")) {
      String[] v = t.primitiveValue().split("\\|");
      if ("urn:ietf:bcp:47".equals(v[0]))
        tgt.getDesignation().getInclude().addDesignation().setLanguage(v[1]);
      else
        tgt.getDesignation().getInclude().addDesignation().getUse().setSystem(v[0]).setCode(v[1]);
    }
    if (src.hasParameterValue("includeDefinition"))
      tgt.setIncludeDefinition(src.getParameterBool("includeDefinition"));
    if (src.hasParameterValue("activeOnly"))
      tgt.setActiveOnly(src.getParameterBool("activeOnly"));
    if (src.hasParameterValue("excludeNested"))
      tgt.setExcludeNested(src.getParameterBool("excludeNested"));
    if (src.hasParameterValue("excludeNotForUI"))
      tgt.setExcludeNotForUI(src.getParameterBool("excludeNotForUI"));
    if (src.hasParameterValue("excludeNotForUI"))
      tgt.setExcludePostCoordinated(src.getParameterBool("excludeNotForUI"));
    if (src.hasParameterValue("displayLanguage"))
      tgt.setDisplayLanguage(src.getParameterValue("displayLanguage").primitiveValue());
    if (src.hasParameterValue("limitedExpansion"))
      tgt.setLimitedExpansion(src.getParameterBool("getParameterBool"));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Parameters convertExpansionProfile(org.hl7.fhir.dstu3.model.ExpansionProfile src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Parameters tgt = new org.hl7.fhir.r5.model.Parameters();
    if (src.hasUrl())
      tgt.addParameter("profile-url", src.getUrl());
    if (src.hasVersion())
      tgt.addParameter("profile-version", src.getVersion());
    if (src.hasName())
      tgt.addParameter("profile-name", src.getName());
    if (src.hasStatus())
      tgt.addParameter("profile-status", src.getStatus().toCode());
    for (org.hl7.fhir.dstu3.model.ExpansionProfile.ExpansionProfileFixedVersionComponent t : src.getFixedVersion()) {
      if (t.getMode() == SystemVersionProcessingMode.DEFAULT)
        tgt.addParameter("system-version", t.getSystem() + "|" + t.getVersion());
      else if (t.getMode() == SystemVersionProcessingMode.CHECK)
        tgt.addParameter("check-system-version", t.getSystem() + "|" + t.getVersion());
      else if (t.getMode() == SystemVersionProcessingMode.OVERRIDE)
        tgt.addParameter("force-system-version", t.getSystem() + "|" + t.getVersion());
    }
    if (src.hasExcludedSystem()) {
      tgt.addParameter("exclude-system", src.getExcludedSystem().getSystem() + "|" + src.getExcludedSystem().getVersion());
    }
    if (src.hasIncludeDesignations())
      tgt.addParameter("includeDesignations", src.getIncludeDesignations());
    for (DesignationIncludeDesignationComponent t : src.getDesignation().getInclude().getDesignation()) {
      if (t.hasLanguage())
        tgt.addParameter("designation", "urn:ietf:bcp:47|" + t.getLanguage());
      if (t.hasUse())
        tgt.addParameter("designation", t.getUse().getSystem() + "|" + t.getUse().getCode());
    }
    if (src.hasIncludeDefinition())
      tgt.addParameter("includeDefinition", src.getIncludeDefinition());
    if (src.hasActiveOnly())
      tgt.addParameter("activeOnly", src.getActiveOnly());
    if (src.hasExcludeNested())
      tgt.addParameter("excludeNested", src.getExcludeNested());
    if (src.hasExcludeNotForUI())
      tgt.addParameter("excludeNotForUI", src.getExcludeNotForUI());
    if (src.hasExcludePostCoordinated())
      tgt.addParameter("excludePostCoordinated", src.getExcludePostCoordinated());
    if (src.hasDisplayLanguage())
      tgt.addParameter("excludePostCoordinated", src.getDisplayLanguage());
    if (src.hasLimitedExpansion())
      tgt.addParameter("limitedExpansion", src.getLimitedExpansion());
    return tgt;
  }
}