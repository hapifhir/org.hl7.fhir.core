package org.hl7.fhir.convertors.conv40_50;

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


public class SearchParameter extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.SearchParameter convertSearchParameter(org.hl7.fhir.r4.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SearchParameter tgt = new org.hl7.fhir.r5.model.SearchParameter();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFromElement(convertCanonical(src.getDerivedFromElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
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
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getBase())
      tgt.getBase().add(convertCode(t));
    if (src.hasType())
      tgt.setType(Enumerations.convertSearchParamType(src.getType()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getTarget())
      tgt.getTarget().add(convertCode(t));
    if (src.hasMultipleOr())
      tgt.setMultipleOrElement(convertBoolean(src.getMultipleOrElement()));
    if (src.hasMultipleAnd())
      tgt.setMultipleAndElement(convertBoolean(src.getMultipleAndElement()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> t : src.getComparator())
      tgt.addComparator(convertSearchComparator(t.getValue()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> t : src.getModifier())
      tgt.addModifier(convertSearchModifierCode(t.getValue()));
    for (org.hl7.fhir.r4.model.StringType t : src.getChain())
      tgt.getChain().add(convertString(t));
    for (org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SearchParameter convertSearchParameter(org.hl7.fhir.r5.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SearchParameter tgt = new org.hl7.fhir.r4.model.SearchParameter();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFromElement(convertCanonical(src.getDerivedFromElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
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
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getBase())
      tgt.getBase().add(convertCode(t));
    if (src.hasType())
      tgt.setType(Enumerations.convertSearchParamType(src.getType()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getTarget())
      tgt.getTarget().add(convertCode(t));
    if (src.hasMultipleOr())
      tgt.setMultipleOrElement(convertBoolean(src.getMultipleOrElement()));
    if (src.hasMultipleAnd())
      tgt.setMultipleAndElement(convertBoolean(src.getMultipleAndElement()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> t : src.getComparator())
      tgt.addComparator(convertSearchComparator(t.getValue()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> t : src.getModifier())
      tgt.addModifier(convertSearchModifierCode(t.getValue()));
    for (org.hl7.fhir.r5.model.StringType t : src.getChain())
      tgt.getChain().add(convertString(t));
    for (org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NORMAL: return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NORMAL;
    case PHONETIC: return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.PHONETIC;
    case NEARBY: return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NEARBY;
    case DISTANCE: return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.DISTANCE;
    case OTHER: return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.OTHER;
    default: return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NORMAL: return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NORMAL;
    case PHONETIC: return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.PHONETIC;
    case NEARBY: return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NEARBY;
    case DISTANCE: return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.DISTANCE;
    case OTHER: return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.OTHER;
    default: return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.SearchParameter.SearchComparator convertSearchComparator(org.hl7.fhir.r4.model.SearchParameter.SearchComparator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EQ: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EQ;
    case NE: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NE;
    case GT: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GT;
    case LT: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LT;
    case GE: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GE;
    case LE: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LE;
    case SA: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.SA;
    case EB: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EB;
    case AP: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.AP;
    default: return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NULL;
  }
}

  public static org.hl7.fhir.r4.model.SearchParameter.SearchComparator convertSearchComparator(org.hl7.fhir.r5.model.SearchParameter.SearchComparator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EQ: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EQ;
    case NE: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NE;
    case GT: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GT;
    case LT: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LT;
    case GE: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GE;
    case LE: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LE;
    case SA: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.SA;
    case EB: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EB;
    case AP: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.AP;
    default: return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NULL;
  }
}

  public static org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode convertSearchModifierCode(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MISSING: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.MISSING;
    case EXACT: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.EXACT;
    case CONTAINS: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.CONTAINS;
    case NOT: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOT;
    case TEXT: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TEXT;
    case IN: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.IN;
    case NOTIN: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOTIN;
    case BELOW: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.BELOW;
    case ABOVE: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.ABOVE;
    case TYPE: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TYPE;
    case IDENTIFIER: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.IDENTIFIER;
    case OFTYPE: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.OFTYPE;
    default: return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode convertSearchModifierCode(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MISSING: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.MISSING;
    case EXACT: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.EXACT;
    case CONTAINS: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.CONTAINS;
    case NOT: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOT;
    case TEXT: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TEXT;
    case IN: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.IN;
    case NOTIN: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOTIN;
    case BELOW: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.BELOW;
    case ABOVE: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.ABOVE;
    case TYPE: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TYPE;
    case IDENTIFIER: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.IDENTIFIER;
    case OFTYPE: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.OFTYPE;
    default: return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent();
    copyElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent();
    copyElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    return tgt;
  }


}
