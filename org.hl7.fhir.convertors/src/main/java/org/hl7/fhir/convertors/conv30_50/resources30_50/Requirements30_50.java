package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Id30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Requirements.ConformanceExpectation;
import org.hl7.fhir.r5.model.Requirements.RequirementsStatementComponent;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.model.UsageContext;

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
public class Requirements30_50 {

  public static org.hl7.fhir.r5.model.Requirements convertRequirements(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
      throw new FHIRException("Error in logic: this basic resource is not an Requirements");
    }
    org.hl7.fhir.r5.model.Requirements tgt = new org.hl7.fhir.r5.model.Requirements();
    //FIXME add ignore
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));

    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.url")) {
      tgt.setUrlElement(Uri30_50.convertUri((org.hl7.fhir.dstu3.model.UriType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.url").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.version")) {
      tgt.setVersionElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.version").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.name")) {
      tgt.setNameElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.name").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.title")) {
      tgt.setTitleElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.title").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.status")) {
      tgt.setStatus(PublicationStatus.fromCode(src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.status").getValue().primitiveValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.experimental")) {
      tgt.setExperimentalElement(Boolean30_50.convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.experimental").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.date")) {
      tgt.setDateElement(DateTime30_50.convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.date").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.publisher")) {
      tgt.setPublisherElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.publisher").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.contact")) {
      tgt.addContact(ContactDetail30_50.convertContactDetail((org.hl7.fhir.dstu3.model.ContactDetail) ext.getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.description")) {
      tgt.setPublisherElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.description").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.useContext")) {
      tgt.addUseContext(UsageContext30_50.convertUsageContext((org.hl7.fhir.dstu3.model.UsageContext) ext.getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.jurisdiction")) {
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) ext.getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.purpose")) {
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.purpose").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyright")) {
      tgt.setCopyrightElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyright").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyrightLabel")) {
      tgt.setCopyrightLabelElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyrightLabel").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.derivedFrom")) {
      tgt.getDerivedFrom().add(Uri30_50.convertCanonical((org.hl7.fhir.dstu3.model.UriType) ext.getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.actor")) {
      tgt.getActor().add(Uri30_50.convertCanonical((org.hl7.fhir.dstu3.model.UriType) ext.getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement")) {
      convertRequirementsStatement(ext, tgt.addStatement());
    }
    return tgt;
  }


  public static org.hl7.fhir.dstu3.model.Basic convertRequirements(org.hl7.fhir.r5.model.Requirements src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("Requirements"); // note use of R5 type system
    
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasUrl()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.url", Uri30_50.convertUri(src.getUrlElement()));
    }
    if (src.hasVersion()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.version", String30_50.convertString(src.getVersionElement()));
    }
    if (src.hasName()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.name", String30_50.convertString(src.getNameElement()));
    }
    if (src.hasTitle()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.title", String30_50.convertString(src.getTitleElement()));
    }
    if (src.hasStatus()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.status", new org.hl7.fhir.dstu3.model.CodeType(src.getStatus().toCode()));
    }
    if (src.hasExperimental()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.experimental", Boolean30_50.convertBoolean(src.getExperimentalElement()));
    }
    if (src.hasDate()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.date", DateTime30_50.convertDateTime(src.getDateElement()));
    }
    if (src.hasPublisher()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.publisher", String30_50.convertString(src.getPublisherElement()));
    }
    for (ContactDetail cd : src.getContact()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.contact", ContactDetail30_50.convertContactDetail(cd));
    }
    if (src.hasDescription()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.description", MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    }
    for (UsageContext cd : src.getUseContext()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.useContext", UsageContext30_50.convertUsageContext(cd));
    }
    for (CodeableConcept cd : src.getJurisdiction()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.jurisdiction", CodeableConcept30_50.convertCodeableConcept(cd));
    }
    if (src.hasPurpose()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.purpose", MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    }
    if (src.hasCopyright()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyright", MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
    }
    if (src.hasCopyrightLabel()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyrightLabel", String30_50.convertString(src.getCopyrightLabelElement()));
    }
    for (CanonicalType ref : src.getDerivedFrom()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.derivedFrom", Uri30_50.convertCanonical(ref));
    }
    for (CanonicalType ref : src.getActor()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.actor", Uri30_50.convertCanonical(ref));
    }
    for (RequirementsStatementComponent ref : src.getStatement()) {
      org.hl7.fhir.dstu3.model.Extension tgte = new org.hl7.fhir.dstu3.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement");
      tgt.addExtension(tgte);
      convertRequirementsStatement(ref, tgte);
    }

    return tgt;
  }

  private static void convertRequirementsStatement(RequirementsStatementComponent src, Extension tgt) {
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasKey()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.key", Id30_50.convertId(src.getKeyElement()));
    }
    if (src.hasLabel()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label", String30_50.convertString(src.getLabelElement()));
    }
    for (Enumeration<ConformanceExpectation> t : src.getConformance()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.conformance", new org.hl7.fhir.dstu3.model.CodeType(t.getCode()));
    }
    if (src.hasRequirement()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement", MarkDown30_50.convertMarkdown(src.getRequirementElement()));
    }
    if (src.hasDerivedFrom()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom", String30_50.convertString(src.getDerivedFromElement()));
    }
    for (UrlType ref : src.getSatisfiedBy()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.satisfiedBy", Uri30_50.convertUrl(ref));
    }
    for (UrlType ref : src.getReference()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.reference", Uri30_50.convertUrl(ref));
    }
    for (Reference ref : src.getSource()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.source", Reference30_50.convertReference(ref));
    }
  }


  private static void convertRequirementsStatement(Extension src, RequirementsStatementComponent tgt) {
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.key",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.conformance",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.satisfiedBy",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.reference",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.source"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.key")) {
      tgt.setKeyElement(Id30_50.convertId((org.hl7.fhir.dstu3.model.IdType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.key").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label")) {
      tgt.setLabelElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.conformance")) {
      tgt.addConformance(ConformanceExpectation.fromCode(ext.getValue().primitiveValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement")) {
      tgt.setRequirementElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom")) {
      tgt.setDerivedFromElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.satisfiedBy")) {
      tgt.getSatisfiedBy().add(Uri30_50.convertUrl((org.hl7.fhir.dstu3.model.UriType) ext.getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.reference")) {
      tgt.getReference().add(Uri30_50.convertUrl((org.hl7.fhir.dstu3.model.UriType) ext.getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.source")) {
      tgt.getSource().add(Reference30_50.convertReference((org.hl7.fhir.dstu3.model.Reference) ext.getValue()));
    }
  }
}