package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_50;
import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Extension14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Meta14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Narrative14_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Arrays;

public class Resource14_50 {

  public final BaseAdvisor_14_50 advisor;

  public Resource14_50(BaseAdvisor_14_50 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.dstu2016may.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta14_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta14_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2016may.model.Parameters)
      return Parameters14_50.convertParameters((org.hl7.fhir.dstu2016may.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Bundle)
      return Bundle14_50.convertBundle((org.hl7.fhir.dstu2016may.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeSystem)
      return CodeSystem14_50.convertCodeSystem((org.hl7.fhir.dstu2016may.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CompartmentDefinition)
      return CompartmentDefinition14_50.convertCompartmentDefinition((org.hl7.fhir.dstu2016may.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ConceptMap)
      return ConceptMap14_50.convertConceptMap((org.hl7.fhir.dstu2016may.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Conformance)
      return Conformance14_50.convertConformance((org.hl7.fhir.dstu2016may.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DataElement)
      return DataElement14_50.convertDataElement((org.hl7.fhir.dstu2016may.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ImplementationGuide)
      return ImplementationGuide14_50.convertImplementationGuide((org.hl7.fhir.dstu2016may.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.NamingSystem)
      return NamingSystem14_50.convertNamingSystem((org.hl7.fhir.dstu2016may.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OperationDefinition)
      return OperationDefinition14_50.convertOperationDefinition((org.hl7.fhir.dstu2016may.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OperationOutcome)
      return OperationOutcome14_50.convertOperationOutcome((org.hl7.fhir.dstu2016may.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Questionnaire)
      return Questionnaire14_50.convertQuestionnaire((org.hl7.fhir.dstu2016may.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.QuestionnaireResponse)
      return QuestionnaireResponse14_50.convertQuestionnaireResponse((org.hl7.fhir.dstu2016may.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.SearchParameter)
      return SearchParameter14_50.convertSearchParameter((org.hl7.fhir.dstu2016may.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StructureDefinition)
      return StructureDefinition14_50.convertStructureDefinition((org.hl7.fhir.dstu2016may.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StructureMap)
      return StructureMap14_50.convertStructureMap((org.hl7.fhir.dstu2016may.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ValueSet)
      return ValueSet14_50.convertValueSet((org.hl7.fhir.dstu2016may.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R2B to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters)
      return Parameters14_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle14_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem14_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition14_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap14_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return Conformance14_50.convertConformance((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide14_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem14_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition14_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome14_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire14_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse14_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter14_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition14_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap14_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet14_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R2B");
    } else {
      return null;
    }
  }

  public void copyDomainResource(
    org.hl7.fhir.dstu2016may.model.DomainResource src,
    org.hl7.fhir.r5.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext14_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension(ConversionContext14_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext14_50.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension14_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext14_50.INSTANCE.path(), extension))
      .map(Extension14_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(
    org.hl7.fhir.r5.model.DomainResource src,
    org.hl7.fhir.dstu2016may.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext14_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.dstu2016may.model.Extension convertExtension = new org.hl7.fhir.dstu2016may.model.Extension();
        advisor.handleExtension(ConversionContext14_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext14_50.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension14_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext14_50.INSTANCE.path(), extension))
      .map(Extension14_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
