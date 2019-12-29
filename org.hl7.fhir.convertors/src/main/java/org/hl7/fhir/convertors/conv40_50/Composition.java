package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification;
import org.hl7.fhir.convertors.VersionConvertor_40_50;


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

// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0


public class Composition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatus(convertCompositionStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor())
      tgt.addAuthor(convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.setConfidentiality(convertDocumentConfidentiality(src.getConfidentiality()));
    for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatus(convertCompositionStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor())
      tgt.addAuthor(convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.setConfidentiality(convertDocumentConfidentiality(src.getConfidentiality()));
    for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumerations.CompositionStatus convertCompositionStatus(org.hl7.fhir.r4.model.Composition.CompositionStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PRELIMINARY: return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY;
    case FINAL: return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL;
    case AMENDED: return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Composition.CompositionStatus convertCompositionStatus(org.hl7.fhir.r5.model.Enumerations.CompositionStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PRELIMINARY: return org.hl7.fhir.r4.model.Composition.CompositionStatus.PRELIMINARY;
    case FINAL: return org.hl7.fhir.r4.model.Composition.CompositionStatus.FINAL;
    case AMENDED: return org.hl7.fhir.r4.model.Composition.CompositionStatus.AMENDED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Composition.CompositionStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.Composition.CompositionStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification convertDocumentConfidentiality(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case U: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.U;
    case L: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.L;
    case M: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.M;
    case N: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.N;
    case R: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.R;
    case V: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.V;
    default: return org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Composition.DocumentConfidentiality convertDocumentConfidentiality(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case U: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.U;
    case L: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.L;
    case M: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.M;
    case N: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.N;
    case R: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.R;
    case V: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.V;
    default: return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getMode()));
    if (src.hasTime())
      tgt.setTimeElement(convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getMode()));
    if (src.hasTime())
      tgt.setTimeElement(convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PERSONAL: return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.PERSONAL;
    case PROFESSIONAL: return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.PROFESSIONAL;
    case LEGAL: return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.LEGAL;
    case OFFICIAL: return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.OFFICIAL;
    default: return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PERSONAL: return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PERSONAL;
    case PROFESSIONAL: return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PROFESSIONAL;
    case LEGAL: return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.LEGAL;
    case OFFICIAL: return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.OFFICIAL;
    default: return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(convertType(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(convertType(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType convertDocumentRelationshipType(org.hl7.fhir.r4.model.Composition.DocumentRelationshipType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REPLACES: return org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.REPLACES;
    case TRANSFORMS: return org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.TRANSFORMS;
    case SIGNS: return org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.SIGNS;
    case APPENDS: return org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.APPENDS;
    default: return org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Composition.DocumentRelationshipType convertDocumentRelationshipType(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REPLACES: return org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.REPLACES;
    case TRANSFORMS: return org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.TRANSFORMS;
    case SIGNS: return org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.SIGNS;
    case APPENDS: return org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.APPENDS;
    default: return org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail())
      tgt.addDetail(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionEventComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetail())
      tgt.addDetail(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
    copyElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor())
      tgt.addAuthor(convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(convertNarrative(src.getText()));
    if (src.hasMode())
      tgt.setMode(convertSectionMode(src.getMode()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEntry())
      tgt.addEntry(convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r5.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
    copyElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor())
      tgt.addAuthor(convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(convertNarrative(src.getText()));
    if (src.hasMode())
      tgt.setMode(convertSectionMode(src.getMode()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEntry())
      tgt.addEntry(convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumerations.ListMode convertSectionMode(org.hl7.fhir.r4.model.Composition.SectionMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case WORKING: return org.hl7.fhir.r5.model.Enumerations.ListMode.WORKING;
    case SNAPSHOT: return org.hl7.fhir.r5.model.Enumerations.ListMode.SNAPSHOT;
    case CHANGES: return org.hl7.fhir.r5.model.Enumerations.ListMode.CHANGES;
    default: return org.hl7.fhir.r5.model.Enumerations.ListMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Composition.SectionMode convertSectionMode(org.hl7.fhir.r5.model.Enumerations.ListMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case WORKING: return org.hl7.fhir.r4.model.Composition.SectionMode.WORKING;
    case SNAPSHOT: return org.hl7.fhir.r4.model.Composition.SectionMode.SNAPSHOT;
    case CHANGES: return org.hl7.fhir.r4.model.Composition.SectionMode.CHANGES;
    default: return org.hl7.fhir.r4.model.Composition.SectionMode.NULL;
  }
}


}
