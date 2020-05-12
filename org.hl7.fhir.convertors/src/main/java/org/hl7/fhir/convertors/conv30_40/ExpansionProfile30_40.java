package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus;
import org.hl7.fhir.dstu3.model.ExpansionProfile.DesignationIncludeDesignationComponent;
import org.hl7.fhir.dstu3.model.ExpansionProfile.SystemVersionProcessingMode;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Type;

public class ExpansionProfile30_40 {

    public static org.hl7.fhir.r4.model.Parameters convertExpansionProfile(org.hl7.fhir.dstu3.model.ExpansionProfile src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Parameters tgt = new org.hl7.fhir.r4.model.Parameters();
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

    public static org.hl7.fhir.dstu3.model.ExpansionProfile convertExpansionProfile(org.hl7.fhir.r4.model.Parameters src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ExpansionProfile tgt = new org.hl7.fhir.dstu3.model.ExpansionProfile();
        if (src.hasParameter("profile-url"))
            tgt.setUrl(src.getParameter("profile-url").primitiveValue());
        if (src.hasParameter("profile-version"))
            tgt.setVersion(src.getParameter("profile-version").primitiveValue());
        if (src.hasParameter("profile-name"))
            tgt.setName(src.getParameter("profile-name").primitiveValue());
        if (src.hasParameter("profile-status"))
            tgt.setStatus(PublicationStatus.fromCode(src.getParameter("profile-status").primitiveValue()));
        for (Type t : src.getParameters("system-version")) {
            String[] v = t.primitiveValue().split("\\|");
            tgt.addFixedVersion().setSystem(v[0]).setVersion(v[1]).setMode(SystemVersionProcessingMode.DEFAULT);
        }
        for (Type t : src.getParameters("force-system-version")) {
            String[] v = t.primitiveValue().split("\\|");
            tgt.addFixedVersion().setSystem(v[0]).setVersion(v[1]).setMode(SystemVersionProcessingMode.OVERRIDE);
        }
        for (Type t : src.getParameters("check-system-version")) {
            String[] v = t.primitiveValue().split("\\|");
            tgt.addFixedVersion().setSystem(v[0]).setVersion(v[1]).setMode(SystemVersionProcessingMode.CHECK);
        }
        for (Type t : src.getParameters("exclude-system")) {
            String[] v = t.primitiveValue().split("\\|");
            tgt.getExcludedSystem().setSystem(v[0]).setVersion(v[1]);
        }
        if (src.hasParameter("includeDesignations"))
            tgt.setIncludeDesignations(src.getParameterBool(""));
        for (Type t : src.getParameters("designation")) {
            String[] v = t.primitiveValue().split("\\|");
            if ("urn:ietf:bcp:47".equals(v[0]))
                tgt.getDesignation().getInclude().addDesignation().setLanguage(v[1]);
            else
                tgt.getDesignation().getInclude().addDesignation().getUse().setSystem(v[0]).setCode(v[1]);
        }
        if (src.hasParameter("includeDefinition"))
            tgt.setIncludeDefinition(src.getParameterBool("includeDefinition"));
        if (src.hasParameter("activeOnly"))
            tgt.setActiveOnly(src.getParameterBool("activeOnly"));
        if (src.hasParameter("excludeNested"))
            tgt.setExcludeNested(src.getParameterBool("excludeNested"));
        if (src.hasParameter("excludeNotForUI"))
            tgt.setExcludeNotForUI(src.getParameterBool("excludeNotForUI"));
        if (src.hasParameter("excludeNotForUI"))
            tgt.setExcludePostCoordinated(src.getParameterBool("excludeNotForUI"));
        if (src.hasParameter("displayLanguage"))
            tgt.setDisplayLanguage(src.getParameter("displayLanguage").primitiveValue());
        if (src.hasParameter("limitedExpansion"))
            tgt.setLimitedExpansion(src.getParameterBool("getParameterBool"));
        return tgt;
    }
}