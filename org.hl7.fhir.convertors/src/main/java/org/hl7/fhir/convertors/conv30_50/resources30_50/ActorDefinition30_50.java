package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
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
public class ActorDefinition30_50 {

  public static org.hl7.fhir.r5.model.ActorDefinition convertActorDefinition(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "ActorDefinition")) {
      throw new FHIRException("Error in logic: this basic resource is not an ActorDefinition");
    }
    org.hl7.fhir.r5.model.ActorDefinition tgt = new org.hl7.fhir.r5.model.ActorDefinition();
    //FIXME add ignore
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));

    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.url")) {
      tgt.setUrlElement(Uri30_50.convertUri((org.hl7.fhir.dstu3.model.UriType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.url").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.version")) {
      tgt.setVersionElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.version").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.name")) {
      tgt.setNameElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.name").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.title")) {
      tgt.setTitleElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.title").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.status")) {
      tgt.setStatus(PublicationStatus.fromCode(src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.status").getValue().primitiveValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.experimental")) {
      tgt.setExperimentalElement(Boolean30_50.convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.experimental").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.date")) {
      tgt.setDateElement(DateTime30_50.convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.date").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.publisher")) {
      tgt.setPublisherElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.publisher").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.contact")) {
      tgt.addContact(ContactDetail30_50.convertContactDetail((org.hl7.fhir.dstu3.model.ContactDetail) ext.getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.description")) {
      tgt.setPublisherElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.description").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.useContext")) {
      tgt.addUseContext(UsageContext30_50.convertUsageContext((org.hl7.fhir.dstu3.model.UsageContext) ext.getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.jurisdiction")) {
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) ext.getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.purpose")) {
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.purpose").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.copyright")) {
      tgt.setCopyrightElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.copyright").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.copyrightLabel")) {
      tgt.setCopyrightLabelElement(String30_50.convertString((org.hl7.fhir.dstu3.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.copyrightLabel").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.type")) {
      tgt.setType(ExampleScenarioActorType.fromCode(src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.type").getValue().primitiveValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.documentation")) {
      tgt.setDocumentationElement(MarkDown30_50.convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.documentation").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.reference")) {
      tgt.getReference().add(Uri30_50.convertUrl((org.hl7.fhir.dstu3.model.UriType) ext.getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.capabilities")) {
      tgt.setCapabilitiesElement(Uri30_50.convertCanonical((org.hl7.fhir.dstu3.model.UriType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.capabilities").getValue()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.derivedFrom")) {
      tgt.getDerivedFrom().add(Uri30_50.convertCanonical((org.hl7.fhir.dstu3.model.UriType) ext.getValue()));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Basic convertActorDefinition(org.hl7.fhir.r5.model.ActorDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("ActorDefinition"); // note use of R5 type system
    
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasUrl()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.url", Uri30_50.convertUri(src.getUrlElement()));
    }
    if (src.hasVersion()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.version", String30_50.convertString(src.getVersionElement()));
    }
    if (src.hasName()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.name", String30_50.convertString(src.getNameElement()));
    }
    if (src.hasTitle()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.title", String30_50.convertString(src.getTitleElement()));
    }
    if (src.hasStatus()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.status", new org.hl7.fhir.dstu3.model.CodeType(src.getStatus().toCode()));
    }
    if (src.hasExperimental()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.experimental", Boolean30_50.convertBoolean(src.getExperimentalElement()));
    }
    if (src.hasDate()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.date", DateTime30_50.convertDateTime(src.getDateElement()));
    }
    if (src.hasPublisher()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.publisher", String30_50.convertString(src.getPublisherElement()));
    }
    for (ContactDetail cd : src.getContact()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.contact", ContactDetail30_50.convertContactDetail(cd));
    }
    if (src.hasDescription()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.description", MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    }
    for (UsageContext cd : src.getUseContext()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.useContext", UsageContext30_50.convertUsageContext(cd));
    }
    for (CodeableConcept cd : src.getJurisdiction()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.jurisdiction", CodeableConcept30_50.convertCodeableConcept(cd));
    }
    if (src.hasPurpose()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.purpose", MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    }
    if (src.hasCopyright()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.copyright", MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
    }
    if (src.hasCopyrightLabel()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.copyrightLabel", String30_50.convertString(src.getCopyrightLabelElement()));
    }
    if (src.hasType()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.type", new org.hl7.fhir.dstu3.model.CodeType(src.getType().toCode()));
    }
    if (src.hasDocumentation()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.documentation", MarkDown30_50.convertMarkdown(src.getDocumentationElement()));
    }   
    for (UrlType ref : src.getReference()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.reference", Uri30_50.convertUrl(ref));
    }
    if (src.hasCapabilities()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.capabilities", Uri30_50.convertCanonical(src.getCapabilitiesElement()));
    }   
    for (CanonicalType ct : src.getDerivedFrom()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-ActorDefinition.derivedFrom", Uri30_50.convertCanonical(ct));
    }

    return tgt;
  }

}