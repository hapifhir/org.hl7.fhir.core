package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Requirements.ConformanceExpectation;
import org.hl7.fhir.model.core.Requirements.RequirementsStatementComponent;

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

public class Requirements40_N {

  public static final String URL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.url";
  public static final String VERSION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.version";
  public static final String NAME_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.name";
  public static final String TITLE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.title";
  public static final String STATUS_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.status";
  public static final String EXPERIMENTAL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.experimental";
  public static final String DATE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.date";
  public static final String PUBLISHER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.publisher";
  public static final String CONTACT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.contact";
  public static final String DESCRIPTION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.description";
  public static final String USE_CONTEXT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.useContext";
  public static final String JURISDICTION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.jurisdiction";
  public static final String PURPOSE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.purpose";
  public static final String COPYRIGHT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyright";
  public static final String COPYRIGHT_LABEL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.copyrightLabel";
  public static final String DERIVED_FROM_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.derivedFrom";
  public static final String ACTOR_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.actor";
  public static final String REFERENCE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.reference";
  public static final String STATEMENT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement";

  private static final String[] IGNORED_EXTENSION_URLS = new String[]{
    URL_EXTENSION_URL,
    VERSION_EXTENSION_URL,
    NAME_EXTENSION_URL,
    TITLE_EXTENSION_URL,
    STATUS_EXTENSION_URL,
    EXPERIMENTAL_EXTENSION_URL,
    DATE_EXTENSION_URL,
    PUBLISHER_EXTENSION_URL,
    CONTACT_EXTENSION_URL,
    DESCRIPTION_EXTENSION_URL,
    USE_CONTEXT_EXTENSION_URL,
    JURISDICTION_EXTENSION_URL,
    PURPOSE_EXTENSION_URL,
    COPYRIGHT_EXTENSION_URL,
    COPYRIGHT_LABEL_EXTENSION_URL,
    DERIVED_FROM_EXTENSION_URL,
    ACTOR_EXTENSION_URL,
    REFERENCE_EXTENSION_URL,
    STATEMENT_EXTENSION_URL
  };

  public static org.hl7.fhir.model.core.Requirements convertRequirements(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
      throw new FHIRException("Error in logic: this basic resource is not an Requirements");
    }
    org.hl7.fhir.model.core.Requirements tgt = new org.hl7.fhir.model.core.Requirements();

    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
    
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));

    if (src.hasExtension(URL_EXTENSION_URL)) {
      tgt.setUrlElement(Uri40_N.convertUri((org.hl7.fhir.r4.model.UriType) src.getExtensionByUrl(URL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(VERSION_EXTENSION_URL)) {
      tgt.setVersionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(VERSION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(NAME_EXTENSION_URL)) {
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(NAME_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(TITLE_EXTENSION_URL)) {
      tgt.setTitleElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TITLE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(STATUS_EXTENSION_URL)) {
      tgt.setStatus(PublicationStatus.fromCode(src.getExtensionByUrl(STATUS_EXTENSION_URL).getValue().primitiveValue()));
    }
    if (src.hasExtension(EXPERIMENTAL_EXTENSION_URL)) {
      tgt.setExperimentalElement(Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(EXPERIMENTAL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(DATE_EXTENSION_URL)) {
      tgt.setDateElement(DateTime40_N.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src.getExtensionByUrl(DATE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(PUBLISHER_EXTENSION_URL)) {
      tgt.setPublisherElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(PUBLISHER_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(CONTACT_EXTENSION_URL)) {
      tgt.addContact(ContactDetail40_N.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) ext.getValue()));
    }
    if (src.hasExtension(DESCRIPTION_EXTENSION_URL)) {
      tgt.setPublisherElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(DESCRIPTION_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(USE_CONTEXT_EXTENSION_URL)) {
      tgt.addUseContext(UsageContext40_N.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(JURISDICTION_EXTENSION_URL)) {
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    }
    if (src.hasExtension(PURPOSE_EXTENSION_URL)) {
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(PURPOSE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_EXTENSION_URL)) {
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(COPYRIGHT_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_LABEL_EXTENSION_URL)) {
      tgt.setCopyrightLabelElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(COPYRIGHT_LABEL_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(DERIVED_FROM_EXTENSION_URL)) {
      tgt.getDerivedFromList().add(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(ACTOR_EXTENSION_URL)) {
      tgt.addActor().setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(REFERENCE_EXTENSION_URL)) {
      tgt.getReferenceList().add(Url40_N.convertUrl((org.hl7.fhir.r4.model.UrlType) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(STATEMENT_EXTENSION_URL)) {
      convertRequirementsStatement(ext, tgt.addStatement());
    }
    return tgt;
  }


  public static org.hl7.fhir.r4.model.Basic convertRequirements(org.hl7.fhir.model.core.Requirements src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("Requirements"); // note use of R5 type system
    
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasUrl()) {
      tgt.addExtension(URL_EXTENSION_URL, Uri40_N.convertUri(src.getUrlElement()));
    }
    if (src.hasVersion()) {
      tgt.addExtension(VERSION_EXTENSION_URL, String40_N.convertString(src.getVersionElement()));
    }
    if (src.hasName()) {
      tgt.addExtension(NAME_EXTENSION_URL, String40_N.convertString(src.getNameElement()));
    }
    if (src.hasTitle()) {
      tgt.addExtension(TITLE_EXTENSION_URL, String40_N.convertString(src.getTitleElement()));
    }
    if (src.hasStatus()) {
      tgt.addExtension(STATUS_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getStatus().toCode()));
    }
    if (src.hasExperimental()) {
      tgt.addExtension(EXPERIMENTAL_EXTENSION_URL, Boolean40_N.convertBoolean(src.getExperimentalElement()));
    }
    if (src.hasDate()) {
      tgt.addExtension(DATE_EXTENSION_URL, DateTime40_N.convertDateTime(src.getDateElement()));
    }
    if (src.hasPublisher()) {
      tgt.addExtension(PUBLISHER_EXTENSION_URL, String40_N.convertString(src.getPublisherElement()));
    }
    for (ContactDetail cd : src.getContactList()) {
      tgt.addExtension(CONTACT_EXTENSION_URL, ContactDetail40_N.convertContactDetail(cd));
    }
    if (src.hasDescription()) {
      tgt.addExtension(DESCRIPTION_EXTENSION_URL, MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    }
    for (UsageContext cd : src.getUseContextList()) {
      tgt.addExtension(USE_CONTEXT_EXTENSION_URL, UsageContext40_N.convertUsageContext(cd));
    }
    for (CodeableConcept cd : src.getJurisdictionList()) {
      tgt.addExtension(JURISDICTION_EXTENSION_URL, CodeableConcept40_N.convertCodeableConcept(cd));
    }
    if (src.hasPurpose()) {
      tgt.addExtension(PURPOSE_EXTENSION_URL, MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    }
    if (src.hasCopyright()) {
      tgt.addExtension(COPYRIGHT_EXTENSION_URL, MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    }
    if (src.hasCopyrightLabel()) {
      tgt.addExtension(COPYRIGHT_LABEL_EXTENSION_URL, String40_N.convertString(src.getCopyrightLabelElement()));
    }
    for (CanonicalType ref : src.getDerivedFromList()) {
      tgt.addExtension(DERIVED_FROM_EXTENSION_URL, Canonical40_N.convertCanonical(ref));
    }
    for (Requirements.RequirementsActorComponent ref : src.getActorList()) {
      tgt.addExtension(ACTOR_EXTENSION_URL, Canonical40_N.convertCanonical(ref.getReferenceElement()));
    }
    for (UrlType ref : src.getReferenceList()) {
      tgt.addExtension(REFERENCE_EXTENSION_URL, Url40_N.convertUrl(ref));
    }
    for (RequirementsStatementComponent ref : src.getStatementList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(STATEMENT_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertRequirementsStatement(ref, tgte);
    }

    return tgt;
  }

  private static void convertRequirementsStatement(RequirementsStatementComponent src, Extension tgt) {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasKey()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.key", Id40_N.convertId(src.getKeyElement()));
    }
    if (src.hasLabel()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label", String40_N.convertString(src.getLabelElement()));
    }
    for (Enumeration<ConformanceExpectation> t : src.getConformanceList()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.conformance", new org.hl7.fhir.r4.model.CodeType(t.getCode()));
    }
    if (src.hasRequirement()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement", MarkDown40_N.convertMarkdown(src.getRequirementElement()));
    }
    if (src.hasDerivedFrom()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom", Canonical40_N.convertCanonical(src.getDerivedFrom().getReferenceElement()));
    }
    for (UrlType ref : src.getSatisfiedByList()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.satisfiedBy", Url40_N.convertUrl(ref));
    }
    for (UrlType ref : src.getReferenceList()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.reference", Url40_N.convertUrl(ref));
    }
    for (Reference ref : src.getSourceList()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.source", Reference40_N.convertReference(ref));
    }
  }


  private static void convertRequirementsStatement(Extension src, RequirementsStatementComponent tgt) {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, 
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
      tgt.setKeyElement(Id40_N.convertId((org.hl7.fhir.r4.model.IdType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.key").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label")) {
      tgt.setLabelElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.label").getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.conformance")) {
      tgt.addConformance(ConformanceExpectation.fromCode(ext.getValue().primitiveValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement")) {
      tgt.setRequirementElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.requirement").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom")) {
      tgt.getDerivedFrom().setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.derivedFrom").getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.satisfiedBy")) {
      tgt.getSatisfiedByList().add(Url40_N.convertUrl((org.hl7.fhir.r4.model.UrlType) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.reference")) {
      tgt.getReferenceList().add(Url40_N.convertUrl((org.hl7.fhir.r4.model.UrlType) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-Requirements.statement.source")) {
      tgt.getSourceList().add(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) ext.getValue()));
    }
  }
}