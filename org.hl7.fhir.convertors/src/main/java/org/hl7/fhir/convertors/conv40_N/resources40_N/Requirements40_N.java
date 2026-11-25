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
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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


  // Requirements is new in R5, so it's a Basic in R4. identifier is Basic's; everything else is a cross-version extension.
  // R6 changed actor (canonical -> backbone) and statement, and added imports: those are 6.0 extensions. R4 Basics
  // written by older versions of this convertor (5.0 actor canonicals and statements) are still read
  private static final String[] V5 = {"url", "version", "versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher",
    "contact", "description", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "derivedFrom", "reference"};
  private static final String[] V6 = {"imports", "actor", "statement"};

  public static org.hl7.fhir.model.core.Requirements convertRequirements(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
      throw new FHIRException("Error in logic: this basic resource is not an Requirements");
    }
    org.hl7.fhir.model.core.Requirements tgt = new org.hl7.fhir.model.core.Requirements();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("Requirements", "5.0", V5, CrossVersionElements40_N.urls("Requirements", "6.0", V6, ACTOR_EXTENSION_URL, STATEMENT_EXTENSION_URL)));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    // the older form
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(ACTOR_EXTENSION_URL)) {
      tgt.addActor().setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) ext.getValue()));
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
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    return tgt;
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