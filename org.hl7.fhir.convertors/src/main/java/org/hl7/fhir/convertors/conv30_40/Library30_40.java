package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;

public class Library30_40 {

    public static org.hl7.fhir.dstu3.model.Library convertLibrary(org.hl7.fhir.r4.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Library tgt = new org.hl7.fhir.dstu3.model.Library();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_40.convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_40.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic()) tgt.addTopic(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.AUTHOR);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.EDITOR);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.REVIEWER);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.ENDORSER);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_40.convertRelatedArtifact(t));
        for (org.hl7.fhir.r4.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(VersionConvertor_30_40.convertParameterDefinition(t));
        for (org.hl7.fhir.r4.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(VersionConvertor_30_40.convertDataRequirement(t));
        for (org.hl7.fhir.r4.model.Attachment t : src.getContent()) tgt.addContent(VersionConvertor_30_40.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Library convertLibrary(org.hl7.fhir.dstu3.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Library tgt = new org.hl7.fhir.r4.model.Library();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_40.convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_40.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
            if (t.getType() == ContributorType.AUTHOR)
                for (ContactDetail c : t.getContact()) tgt.addAuthor(VersionConvertor_30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.EDITOR)
                for (ContactDetail c : t.getContact()) tgt.addEditor(VersionConvertor_30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.REVIEWER)
                for (ContactDetail c : t.getContact()) tgt.addReviewer(VersionConvertor_30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.ENDORSER)
                for (ContactDetail c : t.getContact()) tgt.addEndorser(VersionConvertor_30_40.convertContactDetail(c));
        }
        for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_40.convertRelatedArtifact(t));
        for (org.hl7.fhir.dstu3.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(VersionConvertor_30_40.convertParameterDefinition(t));
        for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(VersionConvertor_30_40.convertDataRequirement(t));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getContent()) tgt.addContent(VersionConvertor_30_40.convertAttachment(t));
        return tgt;
    }
}