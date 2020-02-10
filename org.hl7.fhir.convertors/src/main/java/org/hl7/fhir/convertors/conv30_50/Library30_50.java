package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Library30_50 {

    public static org.hl7.fhir.dstu3.model.Library convertLibrary(org.hl7.fhir.r5.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Library tgt = new org.hl7.fhir.dstu3.model.Library();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasUsageElement())
            tgt.setUsageElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getUsageElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasApprovalDateElement())
            tgt.setApprovalDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getApprovalDateElement()));
        if (src.hasLastReviewDateElement())
            tgt.setLastReviewDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        if (src.hasTopic()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic()) tgt.addTopic(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.AUTHOR);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.EDITOR);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.REVIEWER);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.ENDORSER);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        if (src.hasRelatedArtifact()) {
            for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_50.convertRelatedArtifact(t));
        }
        if (src.hasParameter()) {
            for (org.hl7.fhir.r5.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(VersionConvertor_30_50.convertParameterDefinition(t));
        }
        if (src.hasDataRequirement()) {
            for (org.hl7.fhir.r5.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(VersionConvertor_30_50.convertDataRequirement(t));
        }
        if (src.hasContent()) {
            for (org.hl7.fhir.r5.model.Attachment t : src.getContent()) tgt.addContent(VersionConvertor_30_50.convertAttachment(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Library convertLibrary(org.hl7.fhir.dstu3.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Library tgt = new org.hl7.fhir.r5.model.Library();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasUsageElement())
            tgt.setUsageElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getUsageElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasApprovalDateElement())
            tgt.setApprovalDateElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getApprovalDateElement()));
        if (src.hasLastReviewDateElement())
            tgt.setLastReviewDateElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
            if (t.getType() == ContributorType.AUTHOR)
                for (ContactDetail c : t.getContact()) tgt.addAuthor(VersionConvertor_30_50.convertContactDetail(c));
            if (t.getType() == ContributorType.EDITOR)
                for (ContactDetail c : t.getContact()) tgt.addEditor(VersionConvertor_30_50.convertContactDetail(c));
            if (t.getType() == ContributorType.REVIEWER)
                for (ContactDetail c : t.getContact()) tgt.addReviewer(VersionConvertor_30_50.convertContactDetail(c));
            if (t.getType() == ContributorType.ENDORSER)
                for (ContactDetail c : t.getContact()) tgt.addEndorser(VersionConvertor_30_50.convertContactDetail(c));
        }
        if (src.hasRelatedArtifact()) {
            for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_50.convertRelatedArtifact(t));
        }
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(VersionConvertor_30_50.convertParameterDefinition(t));
        }
        if (src.hasDataRequirement()) {
            for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(VersionConvertor_30_50.convertDataRequirement(t));
        }
        if (src.hasContent()) {
            for (org.hl7.fhir.dstu3.model.Attachment t : src.getContent()) tgt.addContent(VersionConvertor_30_50.convertAttachment(t));
        }
        return tgt;
    }
}
