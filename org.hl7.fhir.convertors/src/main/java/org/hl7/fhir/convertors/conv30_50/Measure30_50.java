package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;

public class Measure30_50 {

    public static org.hl7.fhir.r5.model.Measure convertMeasure(org.hl7.fhir.dstu3.model.Measure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure tgt = new org.hl7.fhir.r5.model.Measure();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasType())
            for (org.hl7.fhir.dstu3.model.CodeableConcept concept : src.getType()) tgt.addType(VersionConvertor_30_50.convertCodeableConcept(concept));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_50.convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_50.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_50.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
            if (t.getType() == ContributorType.AUTHOR)
                if (t.hasContact())
                    for (ContactDetail c : t.getContact()) tgt.addAuthor(VersionConvertor_30_50.convertContactDetail(c));
                else
                    tgt.addAuthor(new org.hl7.fhir.r5.model.ContactDetail().setName(t.getName()));
            if (t.getType() == ContributorType.EDITOR)
                if (t.hasContact())
                    for (ContactDetail c : t.getContact()) tgt.addEditor(VersionConvertor_30_50.convertContactDetail(c).setName(t.hasName() ? t.getName() : null));
                else
                    tgt.addAuthor(new org.hl7.fhir.r5.model.ContactDetail().setName(t.getName()));
            if (t.getType() == ContributorType.REVIEWER)
                if (t.hasContact())
                    for (ContactDetail c : t.getContact()) tgt.addReviewer(VersionConvertor_30_50.convertContactDetail(c).setName(t.hasName() ? t.getName() : null));
                else
                    tgt.addAuthor(new org.hl7.fhir.r5.model.ContactDetail().setName(t.getName()));
            if (t.getType() == ContributorType.ENDORSER)
                if (t.hasContact())
                    for (ContactDetail c : t.getContact()) tgt.addEndorser(VersionConvertor_30_50.convertContactDetail(c).setName(t.hasName() ? t.getName() : null));
                else
                    tgt.addAuthor(new org.hl7.fhir.r5.model.ContactDetail().setName(t.getName()));
        }
        for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.dstu3.model.Reference r : src.getLibrary()) tgt.addLibrary(r.getReference());
        if (src.hasDisclaimer())
            tgt.setDisclaimerElement(VersionConvertor_30_50.convertMarkdown(src.getDisclaimerElement()));
        if (src.hasScoring())
            tgt.setScoring(VersionConvertor_30_50.convertCodeableConcept(src.getScoring()));
        if (src.hasCompositeScoring())
            tgt.setCompositeScoring(VersionConvertor_30_50.convertCodeableConcept(src.getCompositeScoring()));
        if (src.hasRiskAdjustment())
            tgt.setRiskAdjustmentElement(VersionConvertor_30_50.convertString(src.getRiskAdjustmentElement()));
        if (src.hasRateAggregation())
            tgt.setRateAggregationElement(VersionConvertor_30_50.convertString(src.getRateAggregationElement()));
        if (src.hasRationale())
            tgt.setRationaleElement(VersionConvertor_30_50.convertMarkdown(src.getRationaleElement()));
        if (src.hasClinicalRecommendationStatement())
            tgt.setClinicalRecommendationStatementElement(VersionConvertor_30_50.convertMarkdown(src.getClinicalRecommendationStatementElement()));
        if (src.hasImprovementNotation()) {
            if (src.getImprovementNotation().toLowerCase().contains("increase") || src.getImprovementNotation().toLowerCase().contains("higher"))
                tgt.setImprovementNotation(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new org.hl7.fhir.r5.model.Coding().setCode("increase").setSystem("http://terminology.hl7.org/CodeSystem/measure-improvement-notation")).setText(src.getImprovementNotation()));
            else if (src.getImprovementNotation().toLowerCase().contains("decrease") || src.getImprovementNotation().toLowerCase().contains("lower"))
                tgt.setImprovementNotation(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new org.hl7.fhir.r5.model.Coding().setCode("decrease").setSystem("http://terminology.hl7.org/CodeSystem/measure-improvement-notation")).setText(src.getImprovementNotation()));
            else
                tgt.setImprovementNotation(new org.hl7.fhir.r5.model.CodeableConcept().setText(src.getImprovementNotation()));
        }
        for (org.hl7.fhir.dstu3.model.MarkdownType m : src.getDefinition()) tgt.addDefinition(m.getValue());
        if (src.hasGuidance())
            tgt.setGuidanceElement(VersionConvertor_30_50.convertMarkdown(src.getGuidanceElement()));
        for (org.hl7.fhir.dstu3.model.Measure.MeasureGroupComponent g : src.getGroup()) tgt.addGroup(convertMeasureGroup(g));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Measure convertMeasure(org.hl7.fhir.r5.model.Measure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Measure tgt = new org.hl7.fhir.dstu3.model.Measure();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasType())
            for (org.hl7.fhir.r5.model.CodeableConcept concept : src.getType()) tgt.addType(VersionConvertor_30_50.convertCodeableConcept(concept));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_50.convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_50.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_50.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        if (src.hasAuthor())
            for (org.hl7.fhir.r5.model.ContactDetail c : src.getAuthor()) {
                ContactDetail cd = VersionConvertor_30_50.convertContactDetail(c);
                Contributor con = new Contributor().setType(ContributorType.AUTHOR);
                if (cd.hasName())
                    con.setName(cd.getName());
                tgt.addContributor(con);
            }
        if (src.hasEditor())
            for (org.hl7.fhir.r5.model.ContactDetail c : src.getAuthor()) {
                ContactDetail cd = VersionConvertor_30_50.convertContactDetail(c);
                Contributor con = new Contributor().setType(ContributorType.EDITOR);
                if (cd.hasName())
                    con.setName(cd.getName());
                tgt.addContributor(con);
            }
        if (src.hasReviewer())
            for (org.hl7.fhir.r5.model.ContactDetail c : src.getAuthor()) {
                ContactDetail cd = VersionConvertor_30_50.convertContactDetail(c);
                Contributor con = new Contributor().setType(ContributorType.REVIEWER);
                if (cd.hasName())
                    con.setName(cd.getName());
                tgt.addContributor(con);
            }
        if (src.hasEndorser())
            for (org.hl7.fhir.r5.model.ContactDetail c : src.getAuthor()) {
                ContactDetail cd = VersionConvertor_30_50.convertContactDetail(c);
                Contributor con = new Contributor().setType(ContributorType.ENDORSER);
                if (cd.hasName())
                    con.setName(cd.getName());
                tgt.addContributor(con);
            }
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.CanonicalType r : src.getLibrary()) tgt.addLibrary(VersionConvertor_30_50.convertCanonicalToReference(r));
        if (src.hasDisclaimer())
            tgt.setDisclaimerElement(VersionConvertor_30_50.convertMarkdown(src.getDisclaimerElement()));
        if (src.hasScoring())
            tgt.setScoring(VersionConvertor_30_50.convertCodeableConcept(src.getScoring()));
        if (src.hasCompositeScoring())
            tgt.setCompositeScoring(VersionConvertor_30_50.convertCodeableConcept(src.getCompositeScoring()));
        if (src.hasRiskAdjustment())
            tgt.setRiskAdjustmentElement(VersionConvertor_30_50.convertString(src.getRiskAdjustmentElement()));
        if (src.hasRateAggregation())
            tgt.setRateAggregationElement(VersionConvertor_30_50.convertString(src.getRateAggregationElement()));
        if (src.hasRationale())
            tgt.setRationaleElement(VersionConvertor_30_50.convertMarkdown(src.getRationaleElement()));
        if (src.hasClinicalRecommendationStatement())
            tgt.setClinicalRecommendationStatementElement(VersionConvertor_30_50.convertMarkdown(src.getClinicalRecommendationStatementElement()));
        if (src.hasImprovementNotation())
            for (org.hl7.fhir.r5.model.Coding cc : src.getImprovementNotation().getCoding()) {
                if (cc.hasCode() && cc.getCode().equals("increase"))
                    tgt.setImprovementNotation(cc.getCode());
                else if (cc.hasCode() && cc.getCode().equals("decrease"))
                    tgt.setImprovementNotation(cc.getCode());
            }
        for (org.hl7.fhir.r5.model.MarkdownType m : src.getDefinition()) tgt.addDefinition(m.getValue());
        if (src.hasGuidance())
            tgt.setGuidanceElement(VersionConvertor_30_50.convertMarkdown(src.getGuidanceElement()));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupComponent g : src.getGroup()) tgt.addGroup(convertMeasureGroup(g));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Measure.MeasureGroupComponent convertMeasureGroup(org.hl7.fhir.r5.model.Measure.MeasureGroupComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.dstu3.model.Measure.MeasureGroupComponent();
        if (src.hasCode() && src.getCode().hasCoding())
            tgt.setIdentifier(new org.hl7.fhir.dstu3.model.Identifier().setValue(src.getCode().getCodingFirstRep().getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent p : src.getPopulation()) tgt.addPopulation(convertMeasureGroupPopulation(p));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent s : src.getStratifier()) tgt.addStratifier(convertMeasureGroupStratifier(s));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupComponent convertMeasureGroup(org.hl7.fhir.dstu3.model.Measure.MeasureGroupComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupComponent();
        if (src.hasIdentifier())
            tgt.setCode(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new org.hl7.fhir.r5.model.Coding().setCode(src.getIdentifier().getValue())));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.Measure.MeasureGroupPopulationComponent p : src.getPopulation()) tgt.addPopulation(convertMeasureGroupPopulation(p));
        for (org.hl7.fhir.dstu3.model.Measure.MeasureGroupStratifierComponent s : src.getStratifier()) tgt.addStratifier(convertMeasureGroupStratifier(s));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulation(org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.dstu3.model.Measure.MeasureGroupPopulationComponent();
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasCriteria() && src.getCriteria().hasExpression())
            tgt.setCriteria(src.getCriteria().getExpression());
        if (src.hasCriteria() && src.getCriteria().hasName()) {
            tgt.setName(src.getCriteria().getName());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulation(org.hl7.fhir.dstu3.model.Measure.MeasureGroupPopulationComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent();
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(new org.hl7.fhir.r5.model.Expression().setExpression(src.getCriteria()));
        if (src.hasName()) {
            if (tgt.hasCriteria())
                tgt.getCriteria().setName(src.getName());
            else
                tgt.setCriteria(new org.hl7.fhir.r5.model.Expression().setName(src.getName()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifier(org.hl7.fhir.dstu3.model.Measure.MeasureGroupStratifierComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent();
        if (src.hasIdentifier())
            tgt.setCode(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new org.hl7.fhir.r5.model.Coding().setCode(src.getIdentifier().getValue())));
        if (src.hasCriteria())
            tgt.setCriteria(new org.hl7.fhir.r5.model.Expression().setExpression(src.getCriteria()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifier(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.dstu3.model.Measure.MeasureGroupStratifierComponent();
        if (src.hasCode() && src.getCode().hasCoding())
            tgt.setIdentifier(new org.hl7.fhir.dstu3.model.Identifier().setValue(src.getCode().getCodingFirstRep().getCode()));
        if (src.hasCriteria() && src.getCriteria().hasExpression())
            tgt.setCriteria(src.getCriteria().getExpression());
        return tgt;
    }
}