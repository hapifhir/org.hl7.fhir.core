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


public class OperationDefinition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition tgt = new org.hl7.fhir.r5.model.OperationDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasKind())
      tgt.setKind(convertOperationKind(src.getKind()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getResource())
      tgt.getResource().add(convertCode(t));
    if (src.hasSystem())
      tgt.setSystemElement(convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r5.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition tgt = new org.hl7.fhir.r4.model.OperationDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasKind())
      tgt.setKind(convertOperationKind(src.getKind()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getResource())
      tgt.getResource().add(convertCode(t));
    if (src.hasSystem())
      tgt.setSystemElement(convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.r4.model.OperationDefinition.OperationKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case OPERATION: return org.hl7.fhir.r5.model.OperationDefinition.OperationKind.OPERATION;
    case QUERY: return org.hl7.fhir.r5.model.OperationDefinition.OperationKind.QUERY;
    default: return org.hl7.fhir.r5.model.OperationDefinition.OperationKind.NULL;
  }
}

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.r5.model.OperationDefinition.OperationKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case OPERATION: return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.OPERATION;
    case QUERY: return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.QUERY;
    default: return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.NULL;
  }
}

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUse(convertOperationParameterUse(src.getUse()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchType(Enumerations.convertSearchParamType(src.getSearchType()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUse(convertOperationParameterUse(src.getUse()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchType(Enumerations.convertSearchParamType(src.getSearchType()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case IN: return org.hl7.fhir.r5.model.OperationDefinition.OperationParameterUse.IN;
    case OUT: return org.hl7.fhir.r5.model.OperationDefinition.OperationParameterUse.OUT;
    default: return org.hl7.fhir.r5.model.OperationDefinition.OperationParameterUse.NULL;
  }
}

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.r5.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case IN: return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.IN;
    case OUT: return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.OUT;
    default: return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.NULL;
  }
}

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    copyElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrength(Enumerations.convertBindingStrength(src.getStrength()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    copyElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrength(Enumerations.convertBindingStrength(src.getStrength()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    copyElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    copyElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.StringType t : src.getParameterName())
      tgt.getParameterName().add(convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.StringType t : src.getParameterName())
      tgt.getParameterName().add(convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    return tgt;
  }


}
