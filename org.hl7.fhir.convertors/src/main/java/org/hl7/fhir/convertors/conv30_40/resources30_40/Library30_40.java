package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ParameterDefinition30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.RelatedArtifact30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.TriggerDefinition30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Library30_40 {

    public static org.hl7.fhir.dstu3.model.Library convertLibrary(org.hl7.fhir.r4.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Library tgt = new org.hl7.fhir.dstu3.model.Library();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(String30_40.convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic()) tgt.addTopic(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.AUTHOR);
            c.addContact(ContactDetail30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.EDITOR);
            c.addContact(ContactDetail30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.REVIEWER);
            c.addContact(ContactDetail30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.ENDORSER);
            c.addContact(ContactDetail30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(RelatedArtifact30_40.convertRelatedArtifact(t));
        for (org.hl7.fhir.r4.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(ParameterDefinition30_40.convertParameterDefinition(t));
        for (org.hl7.fhir.r4.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(TriggerDefinition30_40.convertDataRequirement(t));
        for (org.hl7.fhir.r4.model.Attachment t : src.getContent()) tgt.addContent(Attachment30_40.convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Library convertLibrary(org.hl7.fhir.dstu3.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Library tgt = new org.hl7.fhir.r4.model.Library();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(String30_40.convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
            if (t.getType() == ContributorType.AUTHOR)
                for (ContactDetail c : t.getContact()) tgt.addAuthor(ContactDetail30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.EDITOR)
                for (ContactDetail c : t.getContact()) tgt.addEditor(ContactDetail30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.REVIEWER)
                for (ContactDetail c : t.getContact()) tgt.addReviewer(ContactDetail30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.ENDORSER)
                for (ContactDetail c : t.getContact()) tgt.addEndorser(ContactDetail30_40.convertContactDetail(c));
        }
        for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(RelatedArtifact30_40.convertRelatedArtifact(t));
        for (org.hl7.fhir.dstu3.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(ParameterDefinition30_40.convertParameterDefinition(t));
        for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(TriggerDefinition30_40.convertDataRequirement(t));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getContent()) tgt.addContent(Attachment30_40.convertAttachment(t));
        return tgt;
    }
}