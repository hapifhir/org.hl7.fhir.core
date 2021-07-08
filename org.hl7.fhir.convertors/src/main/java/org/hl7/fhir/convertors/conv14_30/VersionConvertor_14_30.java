package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Extension14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Meta14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Narrative14_30;
import org.hl7.fhir.convertors.conv14_30.resources14_30.*;
import org.hl7.fhir.dstu2016may.model.CodeableConcept;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

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

public class VersionConvertor_14_30 {

  static public void copyDomainResource(org.hl7.fhir.dstu2016may.model.DomainResource src, org.hl7.fhir.dstu3.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    tgt.setText(Narrative14_30.convertNarrative(src.getText()));
    for (org.hl7.fhir.dstu2016may.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
    for (org.hl7.fhir.dstu2016may.model.Extension t : src.getExtension()) tgt.addExtension(Extension14_30.convertExtension(t));
    for (org.hl7.fhir.dstu2016may.model.Extension t : src.getModifierExtension())
      tgt.addModifierExtension(Extension14_30.convertExtension(t));
  }

  static public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.dstu2016may.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative14_30.convertNarrative(src.getText()));
    for (org.hl7.fhir.dstu3.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
    for (org.hl7.fhir.dstu3.model.Extension t : src.getExtension()) tgt.addExtension(Extension14_30.convertExtension(t));
    for (org.hl7.fhir.dstu3.model.Extension t : src.getModifierExtension())
      tgt.addModifierExtension(Extension14_30.convertExtension(t));
  }

  static public void copyResource(org.hl7.fhir.dstu2016may.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    tgt.setMeta(Meta14_30.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  static public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta14_30.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  static public boolean isJurisdiction(CodeableConcept t) {
    return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2016may.model.Parameters)
      return Parameters14_30.convertParameters((org.hl7.fhir.dstu2016may.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Bundle)
      return Bundle14_30.convertBundle((org.hl7.fhir.dstu2016may.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CodeSystem)
      return CodeSystem14_30.convertCodeSystem((org.hl7.fhir.dstu2016may.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.CompartmentDefinition)
      return CompartmentDefinition14_30.convertCompartmentDefinition((org.hl7.fhir.dstu2016may.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ConceptMap)
      return ConceptMap14_30.convertConceptMap((org.hl7.fhir.dstu2016may.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Conformance)
      return Conformance14_30.convertConformance((org.hl7.fhir.dstu2016may.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.DataElement)
      return DataElement14_30.convertDataElement((org.hl7.fhir.dstu2016may.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ImplementationGuide)
      return ImplementationGuide14_30.convertImplementationGuide((org.hl7.fhir.dstu2016may.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.NamingSystem)
      return NamingSystem14_30.convertNamingSystem((org.hl7.fhir.dstu2016may.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OperationDefinition)
      return OperationDefinition14_30.convertOperationDefinition((org.hl7.fhir.dstu2016may.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.OperationOutcome)
      return OperationOutcome14_30.convertOperationOutcome((org.hl7.fhir.dstu2016may.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.Questionnaire)
      return Questionnaire14_30.convertQuestionnaire((org.hl7.fhir.dstu2016may.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.QuestionnaireResponse)
      return QuestionnaireResponse14_30.convertQuestionnaireResponse((org.hl7.fhir.dstu2016may.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.SearchParameter)
      return SearchParameter14_30.convertSearchParameter((org.hl7.fhir.dstu2016may.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.StructureDefinition)
      return StructureDefinition14_30.convertStructureDefinition((org.hl7.fhir.dstu2016may.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.TestScript)
      return TestScript14_30.convertTestScript((org.hl7.fhir.dstu2016may.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu2016may.model.ValueSet)
      return ValueSet14_30.convertValueSet((org.hl7.fhir.dstu2016may.model.ValueSet) src);
    throw new FHIRException("Unknown resource " + src.fhirType());
  }

  public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
      return Parameters14_30.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
      return Bundle14_30.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeSystem)
      return CodeSystem14_30.convertCodeSystem((org.hl7.fhir.dstu3.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CompartmentDefinition)
      return CompartmentDefinition14_30.convertCompartmentDefinition((org.hl7.fhir.dstu3.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
      return ConceptMap14_30.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
      return Conformance14_30.convertConformance((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
      return DataElement14_30.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
      return ImplementationGuide14_30.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
      return NamingSystem14_30.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
      return OperationDefinition14_30.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
      return OperationOutcome14_30.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
      return Questionnaire14_30.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
      return QuestionnaireResponse14_30.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
      return SearchParameter14_30.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
      return StructureDefinition14_30.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
      return TestScript14_30.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
      return ValueSet14_30.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src);
    throw new FHIRException("Unknown resource " + src.fhirType());
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Bundle", "CodeSystem", "CompartmentDefinition", "ConceptMap", "CapabilityStatement", "DataElement", "ImplementationGuide", "NamingSystem", "OperationDefinition", "OperationOutcome", "Questionnaire", "QuestionnaireResponse", "SearchParameter", "StructureDefinition", "TestScript", "ValueSet");
  }
}