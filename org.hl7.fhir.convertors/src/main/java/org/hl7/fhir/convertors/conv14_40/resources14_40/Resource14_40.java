package org.hl7.fhir.convertors.conv14_40.resources14_40;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_40;
import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Extension14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Meta14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Narrative14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Resource14_40 {

  public final BaseAdvisor_14_40 advisor;

  public Resource14_40(BaseAdvisor_14_40 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.dstu2016may.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    tgt.setMeta(Meta14_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta14_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2016may.model.Parameters)
      return Parameters14_40.convertParameters((org.hl7.fhir.dstu2016may.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Bundle)
      return Bundle14_40.convertBundle((org.hl7.fhir.dstu2016may.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeSystem)
      return CodeSystem14_40.convertCodeSystem((org.hl7.fhir.dstu2016may.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CompartmentDefinition)
      return CompartmentDefinition14_40.convertCompartmentDefinition((org.hl7.fhir.dstu2016may.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ConceptMap)
      return ConceptMap14_40.convertConceptMap((org.hl7.fhir.dstu2016may.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Conformance)
      return Conformance14_40.convertConformance((org.hl7.fhir.dstu2016may.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DataElement)
      return DataElement14_40.convertDataElement((org.hl7.fhir.dstu2016may.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ImplementationGuide)
      return ImplementationGuide14_40.convertImplementationGuide((org.hl7.fhir.dstu2016may.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.NamingSystem)
      return NamingSystem14_40.convertNamingSystem((org.hl7.fhir.dstu2016may.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OperationDefinition)
      return OperationDefinition14_40.convertOperationDefinition((org.hl7.fhir.dstu2016may.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OperationOutcome)
      return OperationOutcome14_40.convertOperationOutcome((org.hl7.fhir.dstu2016may.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Questionnaire)
      return Questionnaire14_40.convertQuestionnaire((org.hl7.fhir.dstu2016may.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.QuestionnaireResponse)
      return QuestionnaireResponse14_40.convertQuestionnaireResponse((org.hl7.fhir.dstu2016may.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.SearchParameter)
      return SearchParameter14_40.convertSearchParameter((org.hl7.fhir.dstu2016may.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StructureDefinition)
      return StructureDefinition14_40.convertStructureDefinition((org.hl7.fhir.dstu2016may.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StructureMap)
      return StructureMap14_40.convertStructureMap((org.hl7.fhir.dstu2016may.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ValueSet)
      return ValueSet14_40.convertValueSet((org.hl7.fhir.dstu2016may.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R2B to R4");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Parameters)
      return Parameters14_40.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4.model.Bundle)
      return Bundle14_40.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
      return CodeSystem14_40.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
      return CompartmentDefinition14_40.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
      return ConceptMap14_40.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
      return Conformance14_40.convertConformance((org.hl7.fhir.r4.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
      return ImplementationGuide14_40.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
      return NamingSystem14_40.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
      return OperationDefinition14_40.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
      return OperationOutcome14_40.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
      return Questionnaire14_40.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
      return QuestionnaireResponse14_40.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
      return SearchParameter14_40.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
      return StructureDefinition14_40.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureMap)
      return StructureMap14_40.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4.model.ValueSet)
      return ValueSet14_40.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R2B");
    } else {
      return null;
    }
  }

  public void copyDomainResource(
    org.hl7.fhir.dstu2016may.model.DomainResource src,
    org.hl7.fhir.r4.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext14_40.INSTANCE.path(), extension)) {
        org.hl7.fhir.r4.model.Extension convertExtension = new org.hl7.fhir.r4.model.Extension();
        advisor.handleExtension(ConversionContext14_40.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext14_40.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension14_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext14_40.INSTANCE.path(), extension))
      .map(Extension14_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(
    org.hl7.fhir.r4.model.DomainResource src,
    org.hl7.fhir.dstu2016may.model.DomainResource tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext14_40.INSTANCE.path(), extension)) {
        org.hl7.fhir.dstu2016may.model.Extension convertExtension = new org.hl7.fhir.dstu2016may.model.Extension();
        advisor.handleExtension(ConversionContext14_40.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext14_40.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension14_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext14_40.INSTANCE.path(), extension))
      .map(Extension14_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

}
