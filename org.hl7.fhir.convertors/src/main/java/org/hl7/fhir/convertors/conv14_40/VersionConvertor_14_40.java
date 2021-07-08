package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Extension14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Meta14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Narrative14_40;
import org.hl7.fhir.convertors.conv14_40.resources14_40.*;
import org.hl7.fhir.dstu2016may.model.CodeableConcept;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification,
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
     this list of conditions and the following disclaimer in the documentation
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
     endorse or promote products derived from this software without specific
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  POSSIBILITY OF SUCH DAMAGE.
 */

public class VersionConvertor_14_40 {
  static public List<String> CANONICAL_URLS = new ArrayList<String>();

  static {
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/codesystem-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/cqif-library");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/event-instantiatesCanonical");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-allowedProfile");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-deMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-sourceStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-targetStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-unit-valueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-supplement");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-system");
  }

  static public void copyDomainResource(org.hl7.fhir.dstu2016may.model.DomainResource src,
                                        org.hl7.fhir.r4.model.DomainResource tgt,
                                        String... extensionsToIgnore) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_14_40(), extensionsToIgnore);
  }

  static public void copyDomainResource(org.hl7.fhir.dstu2016may.model.DomainResource src,
                                        org.hl7.fhir.r4.model.DomainResource tgt,
                                        BaseAdvisor_14_40 advisor,
                                        String... extensionsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension("", extension)) {//TODO add path
        org.hl7.fhir.r4.model.Extension convertExtension = new org.hl7.fhir.r4.model.Extension();
        advisor.handleExtension("", extension, convertExtension);//TODO add path
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl())) {//TODO add path
        tgt.addExtension(Extension14_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl()))//TODO add path
      .map(Extension14_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  static public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src,
                                        org.hl7.fhir.dstu2016may.model.DomainResource tgt,
                                        String... extensionsToIgnore) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_14_40(), extensionsToIgnore);
  }

  static public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src,
                                        org.hl7.fhir.dstu2016may.model.DomainResource tgt,
                                        BaseAdvisor_14_40 advisor,
                                        String... extensionsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension("", extension)) {//TODO add path
        org.hl7.fhir.dstu2016may.model.Extension convertExtension = new org.hl7.fhir.dstu2016may.model.Extension();
        advisor.handleExtension("", extension, convertExtension);//TODO add path
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl())) {//TODO add path
        tgt.addExtension(Extension14_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl()))//TODO add path
      .map(Extension14_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  static public void copyResource(org.hl7.fhir.dstu2016may.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    tgt.setMeta(Meta14_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  static public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta14_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  static public boolean isJurisdiction(CodeableConcept t) {
    return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_14_40());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src, BaseAdvisor_14_40 advisor) throws FHIRException {
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
      throw new FHIRException("Unknown resource " + src.fhirType());
    } else {
      return null;
    }
  }

  public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_14_40());
  }

  public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_14_40 advisor) throws FHIRException {
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
      throw new FHIRException("Unknown resource " + src.fhirType());
    } else {
      return null;
    }
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Bundle", "CodeSystem", "CompartmentDefinition", "ConceptMap", "CapabilityStatement", "ImplementationGuide", "NamingSystem", "OperationDefinition", "OperationOutcome", "Questionnaire", "QuestionnaireResponse", "SearchParameter", "StructureDefinition", "StructureMap", "ValueSet");
  }
}