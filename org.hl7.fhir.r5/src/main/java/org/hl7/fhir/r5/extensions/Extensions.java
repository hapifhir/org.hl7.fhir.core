package org.hl7.fhir.r5.extensions;

import java.math.BigDecimal;
import java.util.List;

// generated

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0




import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;

public class Extensions {
  
// -- Capabilities -------------------------------------
// http://fhir-registry.smarthealthit.org/StructureDefinition/capabilities|0.1.0
// Capabilities

  public static Extension makeCapabilities(String value) {
    return new Extension(ExtensionConstants.EXT_CAPABILITIES).setValue(new CodeType(value));
  }

// -- ObjectClass -------------------------------------
// http://hl7.org/fhir/StructureDefinition/11179-objectClass|0.1.0
// object class

  public static Extension makeObjectClass(Coding value) {
    return new Extension(ExtensionConstants.EXT_OBJECT_CLASS).setValue(value);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent setObjectClass(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context, Coding value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBJECT_CLASS, value);
    return context;
  }

  public static Coding getObjectClass(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context) {
    return ExtensionsUtils.getExtension(Coding.class, context, ExtensionConstants.EXT_OBJECT_CLASS);
  }

// -- ObjectClassProperty -------------------------------------
// http://hl7.org/fhir/StructureDefinition/11179-objectClassProperty|0.1.0
// object class property

  public static Extension makeObjectClassProperty(Coding value) {
    return new Extension(ExtensionConstants.EXT_OBJECT_CLASS_PROPERTY).setValue(value);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent setObjectClassProperty(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context, Coding value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBJECT_CLASS_PROPERTY, value);
    return context;
  }

  public static Coding getObjectClassProperty(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context) {
    return ExtensionsUtils.getExtension(Coding.class, context, ExtensionConstants.EXT_OBJECT_CLASS_PROPERTY);
  }

// -- PermittedValueConceptmap -------------------------------------
// http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap|0.1.0
// Permitted Value Conceptmap

  public static Extension makePermittedValueConceptmap(String value) {
    return new Extension(ExtensionConstants.EXT_PERMITTED_VALUE_CONCEPTMAP).setValue(new CanonicalType(value));
  }

// -- PermittedValueValueset -------------------------------------
// http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset|0.1.0
// Permitted Value Valueset

  public static Extension makePermittedValueValueset(String value) {
    return new Extension(ExtensionConstants.EXT_PERMITTED_VALUE_VALUESET).setValue(new CanonicalType(value));
  }

// -- Datatype -------------------------------------
// http://hl7.org/fhir/StructureDefinition/_datatype|0.1.0
// Datatype

  public static Extension makeDatatype(String value) {
    return new Extension(ExtensionConstants.EXT_DATATYPE).setValue(new StringType(value));
  }

  public static Base setDatatype(Base context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DATATYPE, new StringType(value));
    return context;
  }

  public static String getDatatype(Base context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DATATYPE);
  }

// -- AdditionalIdentifier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/additionalIdentifier|0.1.0
// additional identifier

  public static Extension makeAdditionalIdentifier(Identifier value) {
    return new Extension(ExtensionConstants.EXT_ADDITIONAL_IDENTIFIER).setValue(value);
  }

  public static Reference addAdditionalIdentifier(Reference context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADDITIONAL_IDENTIFIER, value);
    return context;
  }

  public static List<Identifier> getAdditionalIdentifierList(Reference context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_ADDITIONAL_IDENTIFIER);
  }

// -- Abatement -------------------------------------
// http://hl7.org/fhir/StructureDefinition/allergyintolerance-abatement|0.1.0
// Abatement

  public static Extension makeAbatementDateTime(String value) {
    return new Extension(ExtensionConstants.EXT_ABATEMENT).setValue(new DateTimeType(value));
  }

  public static Extension makeAbatement(Age value) {
    return new Extension(ExtensionConstants.EXT_ABATEMENT).setValue(value);
  }

  public static Extension makeAbatement(Period value) {
    return new Extension(ExtensionConstants.EXT_ABATEMENT).setValue(value);
  }

  public static Extension makeAbatement(Range value) {
    return new Extension(ExtensionConstants.EXT_ABATEMENT).setValue(value);
  }

  public static Extension makeAbatementString(String value) {
    return new Extension(ExtensionConstants.EXT_ABATEMENT).setValue(new StringType(value));
  }

  public static AllergyIntolerance setAbatementDateTime(AllergyIntolerance context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ABATEMENT, new DateTimeType(value));
    return context;
  }

  public static String getAbatementString(AllergyIntolerance context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ABATEMENT);
  }

  public static AllergyIntolerance setAbatement(AllergyIntolerance context, Age value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ABATEMENT, value);
    return context;
  }

  public static Age getAbatementAge(AllergyIntolerance context) {
    return ExtensionsUtils.getExtension(Age.class, context, ExtensionConstants.EXT_ABATEMENT);
  }

  public static AllergyIntolerance setAbatement(AllergyIntolerance context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ABATEMENT, value);
    return context;
  }

  public static Period getAbatementPeriod(AllergyIntolerance context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_ABATEMENT);
  }

  public static AllergyIntolerance setAbatement(AllergyIntolerance context, Range value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ABATEMENT, value);
    return context;
  }

  public static Range getAbatementRange(AllergyIntolerance context) {
    return ExtensionsUtils.getExtension(Range.class, context, ExtensionConstants.EXT_ABATEMENT);
  }

  public static AllergyIntolerance setAbatementString(AllergyIntolerance context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ABATEMENT, new StringType(value));
    return context;
  }

// -- AIAssertedDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/allergyintolerance-assertedDate|0.1.0
// AllergyIntolerance AssertedDate

  public static Extension makeAIAssertedDate(String value) {
    return new Extension(ExtensionConstants.EXT_AIASSERTED_DATE).setValue(new DateTimeType(value));
  }

  public static AllergyIntolerance setAIAssertedDate(AllergyIntolerance context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIASSERTED_DATE, new DateTimeType(value));
    return context;
  }

  public static String getAIAssertedDate(AllergyIntolerance context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_AIASSERTED_DATE);
  }

// -- AICertainty -------------------------------------
// http://hl7.org/fhir/StructureDefinition/allergyintolerance-certainty|0.1.0
// AllergyIntolerance Certainty

  public static Extension makeAICertainty(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_AICERTAINTY).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAICertainty(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AICERTAINTY, value);
    return context;
  }

  public static CodeableConcept getAICertainty(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_AICERTAINTY);
  }

// -- AIDuration -------------------------------------
// http://hl7.org/fhir/StructureDefinition/allergyintolerance-duration|0.1.0
// AllergyIntolerance Duration

  public static Extension makeAIDuration(Duration value) {
    return new Extension(ExtensionConstants.EXT_AIDURATION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAIDuration(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, Duration value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIDURATION, value);
    return context;
  }

  public static Duration getAIDuration(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtension(Duration.class, context, ExtensionConstants.EXT_AIDURATION);
  }

// -- AIReasonRefuted -------------------------------------
// http://hl7.org/fhir/StructureDefinition/allergyintolerance-reasonRefuted|0.1.0
// AllergyIntolerance Reason Refuted

  public static Extension makeAIReasonRefuted(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_AIREASON_REFUTED).setValue(value);
  }

  public static AllergyIntolerance setAIReasonRefuted(AllergyIntolerance context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIREASON_REFUTED, value);
    return context;
  }

  public static CodeableConcept getAIReasonRefuted(AllergyIntolerance context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_AIREASON_REFUTED);
  }

// -- AIResolutionAge -------------------------------------
// http://hl7.org/fhir/StructureDefinition/allergyintolerance-resolutionAge|0.1.0
// AllergyIntolerance Resolution Age

  public static Extension makeAIResolutionAge(Age value) {
    return new Extension(ExtensionConstants.EXT_AIRESOLUTION_AGE).setValue(value);
  }

  public static AllergyIntolerance setAIResolutionAge(AllergyIntolerance context, Age value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIRESOLUTION_AGE, value);
    return context;
  }

  public static Age getAIResolutionAge(AllergyIntolerance context) {
    return ExtensionsUtils.getExtension(Age.class, context, ExtensionConstants.EXT_AIRESOLUTION_AGE);
  }

// -- AlternateCanonical -------------------------------------
// http://hl7.org/fhir/StructureDefinition/alternate-canonical|0.1.0
// Alternate Canonical

  public static Extension makeAlternateCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_ALTERNATE_CANONICAL).setValue(new CanonicalType(value));
  }

  public static CanonicalType setAlternateCanonical(CanonicalType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ALTERNATE_CANONICAL, new CanonicalType(value));
    return context;
  }

  public static String getAlternateCanonical(CanonicalType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ALTERNATE_CANONICAL);
  }

// -- AlternateCodes -------------------------------------
// http://hl7.org/fhir/StructureDefinition/alternate-codes|0.1.0
// Alternate Codes

  public static Extension makeAlternateCodes(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ALTERNATE_CODES).setValue(value);
  }

  public static CodeType addAlternateCodes(CodeType context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ALTERNATE_CODES, value);
    return context;
  }

  public static List<CodeableConcept> getAlternateCodesList(CodeType context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_ALTERNATE_CODES);
  }

// -- AlternateReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/alternate-reference|0.1.0
// Alternate Reference

  public static Extension makeAlternateReference(Reference value) {
    return new Extension(ExtensionConstants.EXT_ALTERNATE_REFERENCE).setValue(value);
  }

  public static Reference setAlternateReference(Reference context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ALTERNATE_REFERENCE, value);
    return context;
  }

  public static Reference getAlternateReference(Reference context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_ALTERNATE_REFERENCE);
  }

// -- ArtifactAuthor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-author|0.1.0
// Artifact Author

  public static Extension makeArtifactAuthor(ContactDetail value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_AUTHOR).setValue(value);
  }

  public static DomainResource addArtifactAuthor(DomainResource context, ContactDetail value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_AUTHOR, value);
    return context;
  }

  public static List<ContactDetail> getArtifactAuthorList(DomainResource context) {
    return ExtensionsUtils.getExtensionList(ContactDetail.class, context, ExtensionConstants.EXT_ARTIFACT_AUTHOR);
  }

// -- ArtifactContact -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-contact|0.1.0
// Artifact Contact

  public static Extension makeArtifactContact(ContactDetail value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_CONTACT).setValue(value);
  }

  public static Element addArtifactContact(Element context, ContactDetail value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_CONTACT, value);
    return context;
  }

  public static List<ContactDetail> getArtifactContactList(Element context) {
    return ExtensionsUtils.getExtensionList(ContactDetail.class, context, ExtensionConstants.EXT_ARTIFACT_CONTACT);
  }

// -- ContactDetailReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-contactDetailReference|0.1.0
// contact detail reference

  public static Extension makeContactDetailReference(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_DETAIL_REFERENCE).setValue(value);
  }

  public static ContactDetail setContactDetailReference(ContactDetail context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_DETAIL_REFERENCE, value);
    return context;
  }

  public static Reference getContactDetailReference(ContactDetail context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CONTACT_DETAIL_REFERENCE);
  }

// -- ArtifactCopyright -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-copyright|0.1.0
// Artifact Copyright

  public static Extension makeArtifactCopyright(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_COPYRIGHT).setValue(new MarkdownType(value));
  }

  public static Element setArtifactCopyright(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_COPYRIGHT, new MarkdownType(value));
    return context;
  }

  public static String getArtifactCopyright(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_COPYRIGHT);
  }

// -- ArtifactCopyrightLabel -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-copyrightLabel|0.1.0
// Artifact Copyright Label

  public static Extension makeArtifactCopyrightLabel(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_COPYRIGHT_LABEL).setValue(new StringType(value));
  }

  public static Element setArtifactCopyrightLabel(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_COPYRIGHT_LABEL, new StringType(value));
    return context;
  }

  public static String getArtifactCopyrightLabel(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_COPYRIGHT_LABEL);
  }

// -- ArtifactDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-date|0.1.0
// Artifact Date

  public static Extension makeArtifactDate(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_DATE).setValue(new DateTimeType(value));
  }

  public static Element setArtifactDate(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_DATE, new DateTimeType(value));
    return context;
  }

  public static String getArtifactDate(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_DATE);
  }

// -- ArtifactDescription -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-description|0.1.0
// Artifact Description

  public static Extension makeArtifactDescription(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_DESCRIPTION).setValue(new MarkdownType(value));
  }

  public static Element setArtifactDescription(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_DESCRIPTION, new MarkdownType(value));
    return context;
  }

  public static String getArtifactDescription(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_DESCRIPTION);
  }

// -- ArtifactEditor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-editor|0.1.0
// Artifact Editor

  public static Extension makeArtifactEditor(ContactDetail value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_EDITOR).setValue(value);
  }

  public static Element addArtifactEditor(Element context, ContactDetail value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_EDITOR, value);
    return context;
  }

  public static List<ContactDetail> getArtifactEditorList(Element context) {
    return ExtensionsUtils.getExtensionList(ContactDetail.class, context, ExtensionConstants.EXT_ARTIFACT_EDITOR);
  }

// -- ArtifactEndorser -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-endorser|0.1.0
// Artifact Endorser

  public static Extension makeArtifactEndorser(ContactDetail value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_ENDORSER).setValue(value);
  }

  public static Element addArtifactEndorser(Element context, ContactDetail value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_ENDORSER, value);
    return context;
  }

  public static List<ContactDetail> getArtifactEndorserList(Element context) {
    return ExtensionsUtils.getExtensionList(ContactDetail.class, context, ExtensionConstants.EXT_ARTIFACT_ENDORSER);
  }

// -- ArtifactExperimental -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-experimental|0.1.0
// Artifact Experimental

  public static Extension makeArtifactExperimental(boolean value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_EXPERIMENTAL).setValue(new BooleanType(value));
  }

  public static Element setArtifactExperimental(Element context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_EXPERIMENTAL, new BooleanType(value));
    return context;
  }

  public static Boolean getArtifactExperimental(Element context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_ARTIFACT_EXPERIMENTAL);
  }

// -- ArtifactIdentifier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-identifier|0.1.0
// Artifact Identifier

  public static Extension makeArtifactIdentifier(Identifier value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_IDENTIFIER).setValue(value);
  }

  public static Element addArtifactIdentifier(Element context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_IDENTIFIER, value);
    return context;
  }

  public static List<Identifier> getArtifactIdentifierList(Element context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_ARTIFACT_IDENTIFIER);
  }

// -- ArtifactJurisdiction -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-jurisdiction|0.1.0
// Artifact Jurisdiction

  public static Extension makeArtifactJurisdiction(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_JURISDICTION).setValue(value);
  }

  public static Element addArtifactJurisdiction(Element context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_JURISDICTION, value);
    return context;
  }

  public static List<CodeableConcept> getArtifactJurisdictionList(Element context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_ARTIFACT_JURISDICTION);
  }

// -- KnowledgeCapability -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-knowledgeCapability|0.1.0
// knowledge capability

  public static Extension makeKnowledgeCapability(String value) {
    return new Extension(ExtensionConstants.EXT_KNOWLEDGE_CAPABILITY).setValue(new CodeType(value));
  }

  public static Element addKnowledgeCapability(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_KNOWLEDGE_CAPABILITY, new CodeType(value));
    return context;
  }

  public static List<String> getKnowledgeCapabilityList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_KNOWLEDGE_CAPABILITY);
  }

// -- KnowledgeRepresentationLevel -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-knowledgeRepresentationLevel|0.1.0
// knowledge representation level

  public static Extension makeKnowledgeRepresentationLevel(String value) {
    return new Extension(ExtensionConstants.EXT_KNOWLEDGE_REPRESENTATION_LEVEL).setValue(new CodeType(value));
  }

  public static Element addKnowledgeRepresentationLevel(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_KNOWLEDGE_REPRESENTATION_LEVEL, new CodeType(value));
    return context;
  }

  public static List<String> getKnowledgeRepresentationLevelList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_KNOWLEDGE_REPRESENTATION_LEVEL);
  }

// -- ArtifactName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-name|0.1.0
// ArtifactName

  public static Extension makeArtifactName(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_NAME).setValue(new StringType(value));
  }

  public static Element setArtifactName(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_NAME, new StringType(value));
    return context;
  }

  public static String getArtifactName(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_NAME);
  }

// -- PeriodDuration -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-periodDuration|0.1.0
// period duration

  public static Extension makePeriodDuration(Duration value) {
    return new Extension(ExtensionConstants.EXT_PERIOD_DURATION).setValue(value);
  }

  public static Period setPeriodDuration(Period context, Duration value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PERIOD_DURATION, value);
    return context;
  }

  public static Duration getPeriodDuration(Period context) {
    return ExtensionsUtils.getExtension(Duration.class, context, ExtensionConstants.EXT_PERIOD_DURATION);
  }

// -- ArtifactPublisher -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-publisher|0.1.0
// Artifact Publisher

  public static Extension makeArtifactPublisher(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_PUBLISHER).setValue(new StringType(value));
  }

  public static Element setArtifactPublisher(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_PUBLISHER, new StringType(value));
    return context;
  }

  public static String getArtifactPublisher(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_PUBLISHER);
  }

// -- ArtifactPurpose -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-purpose|0.1.0
// Artifact Purpose

  public static Extension makeArtifactPurpose(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_PURPOSE).setValue(new MarkdownType(value));
  }

  public static Element setArtifactPurpose(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_PURPOSE, new MarkdownType(value));
    return context;
  }

  public static String getArtifactPurpose(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_PURPOSE);
  }

// -- ArtifactRelatedArtifact -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-relatedArtifact|0.1.0
// Artifact related artifact

  public static Extension makeArtifactRelatedArtifact(RelatedArtifact value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_RELATED_ARTIFACT).setValue(value);
  }

  public static Element addArtifactRelatedArtifact(Element context, RelatedArtifact value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_RELATED_ARTIFACT, value);
    return context;
  }

  public static List<RelatedArtifact> getArtifactRelatedArtifactList(Element context) {
    return ExtensionsUtils.getExtensionList(RelatedArtifact.class, context, ExtensionConstants.EXT_ARTIFACT_RELATED_ARTIFACT);
  }

// -- ArtifactReviewer -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-reviewer|0.1.0
// Artifact Reviewer

  public static Extension makeArtifactReviewer(ContactDetail value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_REVIEWER).setValue(value);
  }

  public static Element addArtifactReviewer(Element context, ContactDetail value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_REVIEWER, value);
    return context;
  }

  public static List<ContactDetail> getArtifactReviewerList(Element context) {
    return ExtensionsUtils.getExtensionList(ContactDetail.class, context, ExtensionConstants.EXT_ARTIFACT_REVIEWER);
  }

// -- ArtifactStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-status|0.1.0
// Artifact Status

  public static Extension makeArtifactStatus(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_STATUS).setValue(new CodeType(value));
  }

  public static Element setArtifactStatus(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_STATUS, new CodeType(value));
    return context;
  }

  public static String getArtifactStatus(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_STATUS);
  }

// -- ArtifactTitle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-title|0.1.0
// Artifact Title

  public static Extension makeArtifactTitle(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_TITLE).setValue(new StringType(value));
  }

  public static Element setArtifactTitle(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_TITLE, new StringType(value));
    return context;
  }

  public static String getArtifactTitle(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_TITLE);
  }

// -- ArtifactTopic -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-topic|0.1.0
// Artifact Topic

  public static Extension makeArtifactTopic(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_TOPIC).setValue(value);
  }

  public static Element addArtifactTopic(Element context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_TOPIC, value);
    return context;
  }

  public static List<CodeableConcept> getArtifactTopicList(Element context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_ARTIFACT_TOPIC);
  }

// -- ArtifactUrl -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-url|0.1.0
// Artifact URL

  public static Extension makeArtifactUrl(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_URL).setValue(new UriType(value));
  }

  public static Element setArtifactUrl(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_URL, new UriType(value));
    return context;
  }

  public static String getArtifactUrl(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_URL);
  }

// -- ArtifactUseContext -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-useContext|0.1.0
// Artifact use context

  public static Extension makeArtifactUseContext(UsageContext value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_USE_CONTEXT).setValue(value);
  }

  public static Element addArtifactUseContext(Element context, UsageContext value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ARTIFACT_USE_CONTEXT, value);
    return context;
  }

  public static List<UsageContext> getArtifactUseContextList(Element context) {
    return ExtensionsUtils.getExtensionList(UsageContext.class, context, ExtensionConstants.EXT_ARTIFACT_USE_CONTEXT);
  }

// -- ArtifactVersion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-version|0.1.0
// ArtifactVersion

  public static Extension makeArtifactVersion(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_VERSION).setValue(new StringType(value));
  }

  public static Element setArtifactVersion(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_VERSION, new StringType(value));
    return context;
  }

  public static String getArtifactVersion(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_VERSION);
  }

// -- ArtifactVersionAlgorithm -------------------------------------
// http://hl7.org/fhir/StructureDefinition/artifact-versionAlgorithm|0.1.0
// Artifact Version Algorithm

  public static Extension makeArtifactVersionAlgorithm(String value) {
    return new Extension(ExtensionConstants.EXT_ARTIFACT_VERSION_ALGORITHM).setValue(new StringType(value));
  }

  public static Element setArtifactVersionAlgorithm(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ARTIFACT_VERSION_ALGORITHM, new StringType(value));
    return context;
  }

  public static String getArtifactVersionAlgorithm(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ARTIFACT_VERSION_ALGORITHM);
  }

// -- AEAccession -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-Accession|0.1.0
// AuditEvent Accession

  public static Extension makeAEAccession(Identifier value) {
    return new Extension(ExtensionConstants.EXT_AEACCESSION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent addAEAccession(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AEACCESSION, value);
    return context;
  }

  public static List<Identifier> getAEAccessionList(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_AEACCESSION);
  }

// -- AEAlternativeUserID -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-AlternativeUserID|0.1.0
// AuditEvent Alternative User ID

  public static Extension makeAEAlternativeUserID(Identifier value) {
    return new Extension(ExtensionConstants.EXT_AEALTERNATIVE_USER_I_D).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent addAEAlternativeUserID(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AEALTERNATIVE_USER_I_D, value);
    return context;
  }

  public static List<Identifier> getAEAlternativeUserIDList(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_AEALTERNATIVE_USER_I_D);
  }

// -- AEAnonymized -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-Anonymized|0.1.0
// AuditEvent Anonymized

  public static Extension makeAEAnonymized(boolean value) {
    return new Extension(ExtensionConstants.EXT_AEANONYMIZED).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent setAEAnonymized(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AEANONYMIZED, new BooleanType(value));
    return context;
  }

  public static Boolean getAEAnonymized(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_AEANONYMIZED);
  }

// -- AEEncrypted -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-Encrypted|0.1.0
// AuditEvent Encrypted

  public static Extension makeAEEncrypted(boolean value) {
    return new Extension(ExtensionConstants.EXT_AEENCRYPTED).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent setAEEncrypted(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AEENCRYPTED, new BooleanType(value));
    return context;
  }

  public static Boolean getAEEncrypted(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_AEENCRYPTED);
  }

// -- AEInstance -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-Instance|0.1.0
// AuditEvent Instance

  public static Extension makeAEInstance(Identifier value) {
    return new Extension(ExtensionConstants.EXT_AEINSTANCE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent addAEInstance(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AEINSTANCE, value);
    return context;
  }

  public static List<Identifier> getAEInstanceList(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_AEINSTANCE);
  }

// -- AELifecycle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-Lifecycle|0.1.0
// AuditEvent Lifecycle

  public static Extension makeAELifecycle(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_AELIFECYCLE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent addAELifecycle(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AELIFECYCLE, value);
    return context;
  }

  public static List<CodeableConcept> getAELifecycleList(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_AELIFECYCLE);
  }

// -- AEMPPS -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-MPPS|0.1.0
// AuditEvent MPPS

  public static Extension makeAEMPPS(Identifier value) {
    return new Extension(ExtensionConstants.EXT_AEMPPS).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent addAEMPPS(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AEMPPS, value);
    return context;
  }

  public static List<Identifier> getAEMPPSList(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_AEMPPS);
  }

// -- AENumberOfInstances -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-NumberOfInstances|0.1.0
// AuditEvent Number Of Instances

  public static Extension makeAENumberOfInstances(int value) {
    return new Extension(ExtensionConstants.EXT_AENUMBER_OF_INSTANCES).setValue(new IntegerType(value));
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent setAENumberOfInstances(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AENUMBER_OF_INSTANCES, new IntegerType(value));
    return context;
  }

  public static Integer getAENumberOfInstances(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_AENUMBER_OF_INSTANCES);
  }

// -- AEParticipantObjectContainsStudy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-ParticipantObjectContainsStudy|0.1.0
// AuditEvent Participant Object Contains Study

  public static Extension makeAEParticipantObjectContainsStudy(Identifier value) {
    return new Extension(ExtensionConstants.EXT_AEPARTICIPANT_OBJECT_CONTAINS_STUDY).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent setAEParticipantObjectContainsStudy(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, Identifier value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AEPARTICIPANT_OBJECT_CONTAINS_STUDY, value);
    return context;
  }

  public static Identifier getAEParticipantObjectContainsStudy(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtension(Identifier.class, context, ExtensionConstants.EXT_AEPARTICIPANT_OBJECT_CONTAINS_STUDY);
  }

// -- AESOPClass -------------------------------------
// http://hl7.org/fhir/StructureDefinition/auditevent-SOPClass|0.1.0
// AuditEvent SOPClass

  public static Extension makeAESOPClass(Reference value) {
    return new Extension(ExtensionConstants.EXT_AESOPCLASS).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent addAESOPClass(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AESOPCLASS, value);
    return context;
  }

  public static List<Reference> getAESOPClassList(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_AESOPCLASS);
  }

// -- BDPCollectionProcedure -------------------------------------
// http://hl7.org/fhir/StructureDefinition/biologicallyderivedproduct-collection-procedure|0.1.0
// BiologicallyDerivedProduct Collection Procedure

  public static Extension makeBDPCollectionProcedure(Reference value) {
    return new Extension(ExtensionConstants.EXT_BDPCOLLECTION_PROCEDURE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent addBDPCollectionProcedure(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BDPCOLLECTION_PROCEDURE, value);
    return context;
  }

  public static List<Reference> getBDPCollectionProcedureList(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BDPCOLLECTION_PROCEDURE);
  }

// -- BDPManipulation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/biologicallyderivedproduct-manipulation|0.1.0
// BiologicallyDerivedProduct Manipulation

  public static Extension makeBDPManipulation(DataType value) {
    return new Extension(ExtensionConstants.EXT_BDPMANIPULATION).setValue(value);
  }

  public static BiologicallyDerivedProduct setBDPManipulation(BiologicallyDerivedProduct context, DataType value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_BDPMANIPULATION, value);
    return context;
  }

  public static DataType getBDPManipulation(BiologicallyDerivedProduct context) {
    return ExtensionsUtils.getExtension(DataType.class, context, ExtensionConstants.EXT_BDPMANIPULATION);
  }

// -- BDPProcessing -------------------------------------
// http://hl7.org/fhir/StructureDefinition/biologicallyderivedproduct-processing|0.1.0
// BiologicallyDerivedProduct Processing

  public static Extension makeBDPProcessing(DataType value) {
    return new Extension(ExtensionConstants.EXT_BDPPROCESSING).setValue(value);
  }

  public static BiologicallyDerivedProduct addBDPProcessing(BiologicallyDerivedProduct context, DataType value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BDPPROCESSING, value);
    return context;
  }

  public static List<DataType> getBDPProcessingList(BiologicallyDerivedProduct context) {
    return ExtensionsUtils.getExtensionList(DataType.class, context, ExtensionConstants.EXT_BDPPROCESSING);
  }

// -- BodyStructureReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/bodySite|0.1.0
// BodyStructure Reference

  public static Extension makeBodyStructureReference(Reference value) {
    return new Extension(ExtensionConstants.EXT_BODY_STRUCTURE_REFERENCE).setValue(value);
  }

  public static Element setBodyStructureReference(Element context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_BODY_STRUCTURE_REFERENCE, value);
    return context;
  }

  public static Reference getBodyStructureReference(Element context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_BODY_STRUCTURE_REFERENCE);
  }

// -- CRShortDescription -------------------------------------
// http://hl7.org/fhir/StructureDefinition/canonicalresource-short-description|0.1.0
// CanonicalResource Short Description

  public static Extension makeCRShortDescription(String value) {
    return new Extension(ExtensionConstants.EXT_CRSHORT_DESCRIPTION).setValue(new StringType(value));
  }

  public static CanonicalResource addCRShortDescription(CanonicalResource context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CRSHORT_DESCRIPTION, new StringType(value));
    return context;
  }

  public static List<String> getCRShortDescriptionList(CanonicalResource context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CRSHORT_DESCRIPTION);
  }

// -- CSDeclaredProfile -------------------------------------
// http://hl7.org/fhir/StructureDefinition/capabilitystatement-declared-profile|0.1.0
// CapabilityStatement Declared Profile

  public static Extension makeCSDeclaredProfile(String value) {
    return new Extension(ExtensionConstants.EXT_CSDECLARED_PROFILE).setValue(new CanonicalType(value));
  }

// -- CSExpectation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation|0.1.0
// CapabilityStatement Expectation

  public static Extension makeCSExpectation(String value) {
    return new Extension(ExtensionConstants.EXT_CSEXPECTATION).setValue(new CodeType(value));
  }

  public static CanonicalType setCSExpectation(CanonicalType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSEXPECTATION, new CodeType(value));
    return context;
  }

  public static String getCSExpectation(CanonicalType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSEXPECTATION);
  }

  public static CodeType setCSExpectation(CodeType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSEXPECTATION, new CodeType(value));
    return context;
  }

  public static String getCSExpectation(CodeType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSEXPECTATION);
  }

  public static Extension setCSExpectation(Extension context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSEXPECTATION, new CodeType(value));
    return context;
  }

  public static String getCSExpectation(Extension context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSEXPECTATION);
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent setCSExpectation(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSEXPECTATION, new CodeType(value));
    return context;
  }

  public static String getCSExpectation(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSEXPECTATION);
  }

// -- CSProhibited -------------------------------------
// http://hl7.org/fhir/StructureDefinition/capabilitystatement-prohibited|0.1.0
// CapabilityStatement Prohibition

  public static Extension makeCSProhibited(boolean value) {
    return new Extension(ExtensionConstants.EXT_CSPROHIBITED).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent setCSProhibited(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSPROHIBITED, new BooleanType(value));
    return context;
  }

  public static Boolean getCSProhibited(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_CSPROHIBITED);
  }

// -- CSSearchMode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/capabilitystatement-search-mode|0.1.0
// CapabilityStatement Search Mode

  public static Extension makeCSSearchMode(String value) {
    return new Extension(ExtensionConstants.EXT_CSSEARCH_MODE).setValue(new CodeType(value));
  }

// -- CSSupportedSystem -------------------------------------
// http://hl7.org/fhir/StructureDefinition/capabilitystatement-supported-system|0.1.0
// CapabilityStatement Supported CodeSystem

  public static Extension makeCSSupportedSystem(String value) {
    return new Extension(ExtensionConstants.EXT_CSSUPPORTED_SYSTEM).setValue(new UriType(value));
  }

  public static CapabilityStatement addCSSupportedSystem(CapabilityStatement context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CSSUPPORTED_SYSTEM, new UriType(value));
    return context;
  }

  public static List<String> getCSSupportedSystemList(CapabilityStatement context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CSSUPPORTED_SYSTEM);
  }

// -- CSWebsocket -------------------------------------
// http://hl7.org/fhir/StructureDefinition/capabilitystatement-websocket|0.1.0
// CapabilityStatement WebSocket

  public static Extension makeCSWebsocket(String value) {
    return new Extension(ExtensionConstants.EXT_CSWEBSOCKET).setValue(new UriType(value));
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent setCSWebsocket(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSWEBSOCKET, new UriType(value));
    return context;
  }

  public static String getCSWebsocket(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSWEBSOCKET);
  }

// -- CPActivityTitle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/careplan-activity-title|0.1.0
// CarePlan Activity Title

  public static Extension makeCPActivityTitle(String value) {
    return new Extension(ExtensionConstants.EXT_CPACTIVITY_TITLE).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent setCPActivityTitle(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CPACTIVITY_TITLE, new StringType(value));
    return context;
  }

  public static String getCPActivityTitle(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CPACTIVITY_TITLE);
  }

// -- CTAlias -------------------------------------
// http://hl7.org/fhir/StructureDefinition/careteam-alias|0.1.0
// CareTeam Alias

  public static Extension makeCTAlias(String value) {
    return new Extension(ExtensionConstants.EXT_CTALIAS).setValue(new StringType(value));
  }

  public static CareTeam addCTAlias(CareTeam context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CTALIAS, new StringType(value));
    return context;
  }

  public static List<String> getCTAliasList(CareTeam context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CTALIAS);
  }

// -- CharacteristicExpression -------------------------------------
// http://hl7.org/fhir/StructureDefinition/characteristicExpression|0.1.0
// Characteristic Expression

  public static Extension makeCharacteristicExpression(Expression value) {
    return new Extension(ExtensionConstants.EXT_CHARACTERISTIC_EXPRESSION).setValue(value);
  }

  public static Group setCharacteristicExpression(Group context, Expression value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CHARACTERISTIC_EXPRESSION, value);
    return context;
  }

  public static Expression getCharacteristicExpression(Group context) {
    return ExtensionsUtils.getExtension(Expression.class, context, ExtensionConstants.EXT_CHARACTERISTIC_EXPRESSION);
  }

// -- CSAuthoritativeSource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-authoritativeSource|0.1.0
// CodeSystem Authoritative Source

  public static Extension makeCSAuthoritativeSource(String value) {
    return new Extension(ExtensionConstants.EXT_CSAUTHORITATIVE_SOURCE).setValue(new UriType(value));
  }

  public static CodeSystem setCSAuthoritativeSource(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSAUTHORITATIVE_SOURCE, new UriType(value));
    return context;
  }

  public static String getCSAuthoritativeSource(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSAUTHORITATIVE_SOURCE);
  }

// -- CSConceptComments -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-concept-comments|0.1.0
// CodeSystem Concept Comment

  public static Extension makeCSConceptComments(String value) {
    return new Extension(ExtensionConstants.EXT_CSCONCEPT_COMMENTS).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent setCSConceptComments(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSCONCEPT_COMMENTS, new StringType(value));
    return context;
  }

  public static String getCSConceptComments(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSCONCEPT_COMMENTS);
  }

// -- CSConceptOrder -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-conceptOrder|0.1.0
// CodeSystem ConceptOrder

  public static Extension makeCSConceptOrder(int value) {
    return new Extension(ExtensionConstants.EXT_CSCONCEPT_ORDER).setValue(new IntegerType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent setCSConceptOrder(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSCONCEPT_ORDER, new IntegerType(value));
    return context;
  }

  public static Integer getCSConceptOrder(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_CSCONCEPT_ORDER);
  }

// -- CSKeyWord -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-keyWord|0.1.0
// CodeSystem KeyWord

  public static Extension makeCSKeyWord(String value) {
    return new Extension(ExtensionConstants.EXT_CSKEY_WORD).setValue(new StringType(value));
  }

  public static CodeSystem addCSKeyWord(CodeSystem context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CSKEY_WORD, new StringType(value));
    return context;
  }

  public static List<String> getCSKeyWordList(CodeSystem context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CSKEY_WORD);
  }

// -- CSLabel -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-label|0.1.0
// CodeSystem Label

  public static Extension makeCSLabel(String value) {
    return new Extension(ExtensionConstants.EXT_CSLABEL).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent setCSLabel(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSLABEL, new StringType(value));
    return context;
  }

  public static String getCSLabel(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSLABEL);
  }

// -- CSMap -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-map|0.1.0
// CodeSystem Map

  public static Extension makeCSMap(String value) {
    return new Extension(ExtensionConstants.EXT_CSMAP).setValue(new CanonicalType(value));
  }

  public static CodeSystem setCSMap(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSMAP, new CanonicalType(value));
    return context;
  }

  public static String getCSMap(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSMAP);
  }

// -- CSPropertiesMode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-properties-mode|0.1.0
// CodeSystem Properties Mode

  public static Extension makeCSPropertiesMode(String value) {
    return new Extension(ExtensionConstants.EXT_CSPROPERTIES_MODE).setValue(new CodeType(value));
  }

  public static CodeSystem setCSPropertiesMode(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSPROPERTIES_MODE, new CodeType(value));
    return context;
  }

  public static String getCSPropertiesMode(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSPROPERTIES_MODE);
  }

// -- CSReplacedby -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-replacedby|0.1.0
// CodeSystem Replacedby

  public static Extension makeCSReplacedby(Coding value) {
    return new Extension(ExtensionConstants.EXT_CSREPLACEDBY).setValue(value);
  }

  public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent setCSReplacedby(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context, Coding value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSREPLACEDBY, value);
    return context;
  }

  public static Coding getCSReplacedby(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent context) {
    return ExtensionsUtils.getExtension(Coding.class, context, ExtensionConstants.EXT_CSREPLACEDBY);
  }

// -- CSSourceReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-sourceReference|0.1.0
// CodeSystem Source Reference

  public static Extension makeCSSourceReference(String value) {
    return new Extension(ExtensionConstants.EXT_CSSOURCE_REFERENCE).setValue(new UriType(value));
  }

  public static CodeSystem setCSSourceReference(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSSOURCE_REFERENCE, new UriType(value));
    return context;
  }

  public static String getCSSourceReference(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSSOURCE_REFERENCE);
  }

// -- CSTrustedExpansion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-trusted-expansion|0.1.0
// CodeSystem Trusted Expansion

  public static Extension makeCSTrustedExpansion(String value) {
    return new Extension(ExtensionConstants.EXT_CSTRUSTED_EXPANSION).setValue(new UriType(value));
  }

  public static CodeSystem addCSTrustedExpansion(CodeSystem context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CSTRUSTED_EXPANSION, new UriType(value));
    return context;
  }

  public static List<String> getCSTrustedExpansionList(CodeSystem context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CSTRUSTED_EXPANSION);
  }

// -- CSUseMarkdown -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown|0.1.0
// CodeSystem Use Markdown

  public static Extension makeCSUseMarkdown(boolean value) {
    return new Extension(ExtensionConstants.EXT_CSUSE_MARKDOWN).setValue(new BooleanType(value));
  }

  public static CodeSystem setCSUseMarkdown(CodeSystem context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSUSE_MARKDOWN, new BooleanType(value));
    return context;
  }

  public static Boolean getCSUseMarkdown(CodeSystem context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_CSUSE_MARKDOWN);
  }

// -- CSWarning -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-warning|0.1.0
// CodeSystem Warning

  public static Extension makeCSWarning(String value) {
    return new Extension(ExtensionConstants.EXT_CSWARNING).setValue(new MarkdownType(value));
  }

  public static CodeSystem setCSWarning(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSWARNING, new MarkdownType(value));
    return context;
  }

  public static String getCSWarning(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSWARNING);
  }

// -- CSWorkflowStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/codesystem-workflowStatus|0.1.0
// CodeSystem Workflow Status

  public static Extension makeCSWorkflowStatus(String value) {
    return new Extension(ExtensionConstants.EXT_CSWORKFLOW_STATUS).setValue(new StringType(value));
  }

  public static CodeSystem setCSWorkflowStatus(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSWORKFLOW_STATUS, new StringType(value));
    return context;
  }

  public static String getCSWorkflowStatus(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSWORKFLOW_STATUS);
  }

// -- CodingConformance -------------------------------------
// http://hl7.org/fhir/StructureDefinition/coding-conformance|0.1.0
// Coding Conformance

  public static Extension makeCodingConformance(String value) {
    return new Extension(ExtensionConstants.EXT_CODING_CONFORMANCE).setValue(new CanonicalType(value));
  }

  public static Coding addCodingConformance(Coding context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CODING_CONFORMANCE, new CanonicalType(value));
    return context;
  }

  public static List<String> getCodingConformanceList(Coding context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CODING_CONFORMANCE);
  }

// -- CodingPurpose -------------------------------------
// http://hl7.org/fhir/StructureDefinition/coding-purpose|0.1.0
// Coding Purpose

  public static Extension makeCodingPurpose(Coding value) {
    return new Extension(ExtensionConstants.EXT_CODING_PURPOSE).setValue(value);
  }

  public static Coding addCodingPurpose(Coding context, Coding value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CODING_PURPOSE, value);
    return context;
  }

  public static List<Coding> getCodingPurposeList(Coding context) {
    return ExtensionsUtils.getExtensionList(Coding.class, context, ExtensionConstants.EXT_CODING_PURPOSE);
  }

// -- Sctdescid -------------------------------------
// http://hl7.org/fhir/StructureDefinition/coding-sctdescid|0.1.0
// SNOMED CT Description Id

  public static Extension makeSctdescid(String value) {
    return new Extension(ExtensionConstants.EXT_SCTDESCID).setValue(new IdType(value));
  }

  public static Coding setSctdescid(Coding context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SCTDESCID, new IdType(value));
    return context;
  }

  public static String getSctdescid(Coding context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SCTDESCID);
  }

// -- CMedia -------------------------------------
// http://hl7.org/fhir/StructureDefinition/communication-media|0.1.0
// Communication Media

  public static Extension makeCMedia(Attachment value) {
    return new Extension(ExtensionConstants.EXT_CMEDIA).setValue(value);
  }

  public static Communication addCMedia(Communication context, Attachment value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CMEDIA, value);
    return context;
  }

  public static List<Attachment> getCMediaList(Communication context) {
    return ExtensionsUtils.getExtensionList(Attachment.class, context, ExtensionConstants.EXT_CMEDIA);
  }

// -- CRInitiatingLocation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/communicationrequest-initiatingLocation|0.1.0
// CommunicationRequest Initiating Location

  public static Extension makeCRInitiatingLocation(Reference value) {
    return new Extension(ExtensionConstants.EXT_CRINITIATING_LOCATION).setValue(value);
  }

  public static CommunicationRequest setCRInitiatingLocation(CommunicationRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CRINITIATING_LOCATION, value);
    return context;
  }

  public static Reference getCRInitiatingLocation(CommunicationRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CRINITIATING_LOCATION);
  }

// -- COtherConfidentiality -------------------------------------
// http://hl7.org/fhir/StructureDefinition/composition-clinicaldocument-otherConfidentiality|0.1.0
// Composition Other Confidentiality

  public static Extension makeCOtherConfidentiality(Coding value) {
    return new Extension(ExtensionConstants.EXT_COTHER_CONFIDENTIALITY).setValue(value);
  }

  public static Composition addCOtherConfidentiality(Composition context, Coding value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COTHER_CONFIDENTIALITY, value);
    return context;
  }

  public static List<Coding> getCOtherConfidentialityList(Composition context) {
    return ExtensionsUtils.getExtensionList(Coding.class, context, ExtensionConstants.EXT_COTHER_CONFIDENTIALITY);
  }

// -- CDVersionNumber -------------------------------------
// http://hl7.org/fhir/StructureDefinition/composition-clinicaldocument-versionNumber|0.1.0
// Composition Version Number

  public static Extension makeCDVersionNumber(String value) {
    return new Extension(ExtensionConstants.EXT_CDVERSION_NUMBER).setValue(new StringType(value));
  }

  public static Composition setCDVersionNumber(Composition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CDVERSION_NUMBER, new StringType(value));
    return context;
  }

  public static String getCDVersionNumber(Composition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CDVERSION_NUMBER);
  }

// -- CSectionSubject -------------------------------------
// http://hl7.org/fhir/StructureDefinition/composition-section-subject|0.1.0
// Composition Section Subject

  public static Extension makeCSectionSubject(String value) {
    return new Extension(ExtensionConstants.EXT_CSECTION_SUBJECT).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.Composition.SectionComponent setCSectionSubject(org.hl7.fhir.r5.model.Composition.SectionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CSECTION_SUBJECT, new StringType(value));
    return context;
  }

  public static String getCSectionSubject(org.hl7.fhir.r5.model.Composition.SectionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CSECTION_SUBJECT);
  }

// -- CMBidirectional -------------------------------------
// http://hl7.org/fhir/StructureDefinition/concept-bidirectional|0.1.0
// ConceptMap Bi-directional

  public static Extension makeCMBidirectional(boolean value) {
    return new Extension(ExtensionConstants.EXT_CMBIDIRECTIONAL).setValue(new BooleanType(value));
  }

  public static ConceptMap setCMBidirectional(ConceptMap context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CMBIDIRECTIONAL, new BooleanType(value));
    return context;
  }

  public static Boolean getCMBidirectional(ConceptMap context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_CMBIDIRECTIONAL);
  }

// -- ConditionAssertedDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-assertedDate|0.1.0
// Condition Asserted Date

  public static Extension makeConditionAssertedDate(String value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_ASSERTED_DATE).setValue(new DateTimeType(value));
  }

  public static Condition setConditionAssertedDate(Condition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONDITION_ASSERTED_DATE, new DateTimeType(value));
    return context;
  }

  public static String getConditionAssertedDate(Condition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONDITION_ASSERTED_DATE);
  }

// -- ConditionDiseaseCourse -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-diseaseCourse|0.1.0
// Condition Disease Course

  public static Extension makeConditionDiseaseCourse(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_DISEASE_COURSE).setValue(value);
  }

  public static Condition setConditionDiseaseCourse(Condition context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONDITION_DISEASE_COURSE, value);
    return context;
  }

  public static CodeableConcept getConditionDiseaseCourse(Condition context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_CONDITION_DISEASE_COURSE);
  }

// -- ConditionDueTo -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-dueTo|0.1.0
// Condition Due To

  public static Extension makeConditionDueTo(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_DUE_TO).setValue(value);
  }

  public static Extension makeConditionDueTo(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_DUE_TO).setValue(value);
  }

  public static Condition addConditionDueTo(Condition context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONDITION_DUE_TO, value);
    return context;
  }

  public static List<CodeableConcept> getConditionDueToCodeableConceptList(Condition context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_CONDITION_DUE_TO);
  }

  public static Condition addConditionDueTo(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONDITION_DUE_TO, value);
    return context;
  }

  public static List<Reference> getConditionDueToReferenceList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_CONDITION_DUE_TO);
  }

// -- ConditionOccurredFollowing -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-occurredFollowing|0.1.0
// Condition Occurred Following

  public static Extension makeConditionOccurredFollowing(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_OCCURRED_FOLLOWING).setValue(value);
  }

  public static Extension makeConditionOccurredFollowing(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_OCCURRED_FOLLOWING).setValue(value);
  }

  public static Condition addConditionOccurredFollowing(Condition context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONDITION_OCCURRED_FOLLOWING, value);
    return context;
  }

  public static List<CodeableConcept> getConditionOccurredFollowingCodeableConceptList(Condition context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_CONDITION_OCCURRED_FOLLOWING);
  }

  public static Condition addConditionOccurredFollowing(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONDITION_OCCURRED_FOLLOWING, value);
    return context;
  }

  public static List<Reference> getConditionOccurredFollowingReferenceList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_CONDITION_OCCURRED_FOLLOWING);
  }

// -- ConditionOutcome -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-outcome|0.1.0
// Condition Outcome

  public static Extension makeConditionOutcome(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_OUTCOME).setValue(value);
  }

  public static Condition setConditionOutcome(Condition context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONDITION_OUTCOME, value);
    return context;
  }

  public static CodeableConcept getConditionOutcome(Condition context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_CONDITION_OUTCOME);
  }

// -- ConditionRelated -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-related|0.1.0
// Condition Related

  public static Extension makeConditionRelated(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_RELATED).setValue(value);
  }

  public static Condition addConditionRelated(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONDITION_RELATED, value);
    return context;
  }

  public static List<Reference> getConditionRelatedList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_CONDITION_RELATED);
  }

// -- ConditionReviewed -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-reviewed|0.1.0
// Condition Reviewed

  public static Extension makeConditionReviewed(String value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_REVIEWED).setValue(new DateTimeType(value));
  }

  public static Condition setConditionReviewed(Condition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONDITION_REVIEWED, new DateTimeType(value));
    return context;
  }

  public static String getConditionReviewed(Condition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONDITION_REVIEWED);
  }

// -- ConditionRuledOut -------------------------------------
// http://hl7.org/fhir/StructureDefinition/condition-ruledOut|0.1.0
// Condition Ruled Out

  public static Extension makeConditionRuledOut(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONDITION_RULED_OUT).setValue(value);
  }

  public static Condition addConditionRuledOut(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONDITION_RULED_OUT, value);
    return context;
  }

  public static List<Reference> getConditionRuledOutList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_CONDITION_RULED_OUT);
  }

// -- ConsentNotificationEndpoint -------------------------------------
// http://hl7.org/fhir/StructureDefinition/consent-NotificationEndpoint|0.1.0
// Consent Disclosure Notification Endpoint

  public static Extension makeConsentNotificationEndpoint(String value) {
    return new Extension(ExtensionConstants.EXT_CONSENT_NOTIFICATION_ENDPOINT).setValue(new UriType(value));
  }

  public static Consent setConsentNotificationEndpoint(Consent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONSENT_NOTIFICATION_ENDPOINT, new UriType(value));
    return context;
  }

  public static String getConsentNotificationEndpoint(Consent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONSENT_NOTIFICATION_ENDPOINT);
  }

// -- ConsentResearchStudyContext -------------------------------------
// http://hl7.org/fhir/StructureDefinition/consent-ResearchStudyContext|0.1.0
// Consent Research Study Context

  public static Extension makeConsentResearchStudyContext(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONSENT_RESEARCH_STUDY_CONTEXT).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionComponent setConsentResearchStudyContext(org.hl7.fhir.r5.model.Consent.ProvisionComponent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONSENT_RESEARCH_STUDY_CONTEXT, value);
    return context;
  }

  public static Reference getConsentResearchStudyContext(org.hl7.fhir.r5.model.Consent.ProvisionComponent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CONSENT_RESEARCH_STUDY_CONTEXT);
  }

// -- ConsentTranscriber -------------------------------------
// http://hl7.org/fhir/StructureDefinition/consent-Transcriber|0.1.0
// Consent Transcriber

  public static Extension makeConsentTranscriber(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONSENT_TRANSCRIBER).setValue(value);
  }

  public static Consent setConsentTranscriber(Consent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONSENT_TRANSCRIBER, value);
    return context;
  }

  public static Reference getConsentTranscriber(Consent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CONSENT_TRANSCRIBER);
  }

// -- ConsentWitness -------------------------------------
// http://hl7.org/fhir/StructureDefinition/consent-Witness|0.1.0
// Consent Witness

  public static Extension makeConsentWitness(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONSENT_WITNESS).setValue(value);
  }

  public static Consent setConsentWitness(Consent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONSENT_WITNESS, value);
    return context;
  }

  public static Reference getConsentWitness(Consent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CONSENT_WITNESS);
  }

// -- ConsentLocation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/consent-location|0.1.0
// Consent Location of Access restriction

  public static Extension makeConsentLocation(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONSENT_LOCATION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionComponent addConsentLocation(org.hl7.fhir.r5.model.Consent.ProvisionComponent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CONSENT_LOCATION, value);
    return context;
  }

  public static List<Reference> getConsentLocationList(org.hl7.fhir.r5.model.Consent.ProvisionComponent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_CONSENT_LOCATION);
  }

// -- ContactPointArea -------------------------------------
// http://hl7.org/fhir/StructureDefinition/contactpoint-area|0.1.0
// ContactPoint Area

  public static Extension makeContactPointArea(String value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_POINT_AREA).setValue(new StringType(value));
  }

  public static ContactPoint setContactPointArea(ContactPoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_POINT_AREA, new StringType(value));
    return context;
  }

  public static String getContactPointArea(ContactPoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTACT_POINT_AREA);
  }

// -- ContactPointComment -------------------------------------
// http://hl7.org/fhir/StructureDefinition/contactpoint-comment|0.1.0
// ContactPoint Comment

  public static Extension makeContactPointComment(String value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_POINT_COMMENT).setValue(new StringType(value));
  }

  public static ContactPoint setContactPointComment(ContactPoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_POINT_COMMENT, new StringType(value));
    return context;
  }

  public static String getContactPointComment(ContactPoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTACT_POINT_COMMENT);
  }

  public static ExtendedContactDetail setContactPointComment(ExtendedContactDetail context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_POINT_COMMENT, new StringType(value));
    return context;
  }

  public static String getContactPointComment(ExtendedContactDetail context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTACT_POINT_COMMENT);
  }

// -- ContactPointCountry -------------------------------------
// http://hl7.org/fhir/StructureDefinition/contactpoint-country|0.1.0
// ContactPoint Country

  public static Extension makeContactPointCountry(String value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_POINT_COUNTRY).setValue(new StringType(value));
  }

  public static ContactPoint setContactPointCountry(ContactPoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_POINT_COUNTRY, new StringType(value));
    return context;
  }

  public static String getContactPointCountry(ContactPoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTACT_POINT_COUNTRY);
  }

// -- ContactPointExtension -------------------------------------
// http://hl7.org/fhir/StructureDefinition/contactpoint-extension|0.1.0
// ContactPoint Extension

  public static Extension makeContactPointExtension(String value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_POINT_EXTENSION).setValue(new StringType(value));
  }

  public static ContactPoint setContactPointExtension(ContactPoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_POINT_EXTENSION, new StringType(value));
    return context;
  }

  public static String getContactPointExtension(ContactPoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTACT_POINT_EXTENSION);
  }

// -- ContactPointLocal -------------------------------------
// http://hl7.org/fhir/StructureDefinition/contactpoint-local|0.1.0
// ContactPoint Local

  public static Extension makeContactPointLocal(String value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_POINT_LOCAL).setValue(new StringType(value));
  }

  public static ContactPoint setContactPointLocal(ContactPoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_POINT_LOCAL, new StringType(value));
    return context;
  }

  public static String getContactPointLocal(ContactPoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTACT_POINT_LOCAL);
  }

// -- AlternativeExpression -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-alternativeExpression|0.1.0
// Alternative expression

  public static Extension makeAlternativeExpression(Expression value) {
    return new Extension(ExtensionConstants.EXT_ALTERNATIVE_EXPRESSION).setValue(value);
  }

  public static Expression setAlternativeExpression(Expression context, Expression value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ALTERNATIVE_EXPRESSION, value);
    return context;
  }

  public static Expression getAlternativeExpression(Expression context) {
    return ExtensionsUtils.getExtension(Expression.class, context, ExtensionConstants.EXT_ALTERNATIVE_EXPRESSION);
  }

// -- CalculatedValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-calculatedValue|0.1.0
// calculated value

  public static Extension makeCalculatedValue(Expression value) {
    return new Extension(ExtensionConstants.EXT_CALCULATED_VALUE).setValue(value);
  }

  public static Element addCalculatedValue(Element context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CALCULATED_VALUE, value);
    return context;
  }

  public static List<Expression> getCalculatedValueList(Element context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_CALCULATED_VALUE);
  }

// -- CdsHooksEndpoint -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-cdsHooksEndpoint|0.1.0
// cds hooks endpoint

  public static Extension makeCdsHooksEndpoint(String value) {
    return new Extension(ExtensionConstants.EXT_CDS_HOOKS_ENDPOINT).setValue(new UriType(value));
  }

  public static PlanDefinition setCdsHooksEndpoint(PlanDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CDS_HOOKS_ENDPOINT, new UriType(value));
    return context;
  }

  public static String getCdsHooksEndpoint(PlanDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CDS_HOOKS_ENDPOINT);
  }

// -- CQFCitation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-citation|0.1.0
// CQF Citation

  public static Extension makeCQFCitation(String value) {
    return new Extension(ExtensionConstants.EXT_CQFCITATION).setValue(new StringType(value));
  }

  public static Element setCQFCitation(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CQFCITATION, new StringType(value));
    return context;
  }

  public static String getCQFCitation(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CQFCITATION);
  }

// -- ContactAddress -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-contactAddress|0.1.0
// Contact address

  public static Extension makeContactAddress(Address value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_ADDRESS).setValue(value);
  }

  public static ContactDetail setContactAddress(ContactDetail context, Address value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_ADDRESS, value);
    return context;
  }

  public static Address getContactAddress(ContactDetail context) {
    return ExtensionsUtils.getExtension(Address.class, context, ExtensionConstants.EXT_CONTACT_ADDRESS);
  }

// -- ContactReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-contactReference|0.1.0
// Contact Reference

  public static Extension makeContactReference(Reference value) {
    return new Extension(ExtensionConstants.EXT_CONTACT_REFERENCE).setValue(value);
  }

  public static ContactDetail setContactReference(ContactDetail context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTACT_REFERENCE, value);
    return context;
  }

  public static Reference getContactReference(ContactDetail context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CONTACT_REFERENCE);
  }

// -- ContributionTime -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-contributionTime|0.1.0
// Contribution time

  public static Extension makeContributionTime(String value) {
    return new Extension(ExtensionConstants.EXT_CONTRIBUTION_TIME).setValue(new DateTimeType(value));
  }

  public static ContactDetail setContributionTime(ContactDetail context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CONTRIBUTION_TIME, new DateTimeType(value));
    return context;
  }

  public static String getContributionTime(ContactDetail context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CONTRIBUTION_TIME);
  }

// -- CQFCQLOptions -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-cqlOptions|0.1.0
// CQF CQL Options

  public static Extension makeCQFCQLOptions(Reference value) {
    return new Extension(ExtensionConstants.EXT_CQFCQLOPTIONS).setValue(value);
  }

  public static Library setCQFCQLOptions(Library context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CQFCQLOPTIONS, value);
    return context;
  }

  public static Reference getCQFCQLOptions(Library context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_CQFCQLOPTIONS);
  }

// -- DirectReferenceCode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-directReferenceCode|0.1.0
// direct reference code

  public static Extension makeDirectReferenceCode(Coding value) {
    return new Extension(ExtensionConstants.EXT_DIRECT_REFERENCE_CODE).setValue(value);
  }

  public static Element addDirectReferenceCode(Element context, Coding value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DIRECT_REFERENCE_CODE, value);
    return context;
  }

  public static List<Coding> getDirectReferenceCodeList(Element context) {
    return ExtensionsUtils.getExtensionList(Coding.class, context, ExtensionConstants.EXT_DIRECT_REFERENCE_CODE);
  }

// -- EncounterClass -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-encounterClass|0.1.0
// encounter class

  public static Extension makeEncounterClass(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ENCOUNTER_CLASS).setValue(value);
  }

  public static Basic setEncounterClass(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENCOUNTER_CLASS, value);
    return context;
  }

  public static CodeableConcept getEncounterClass(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_ENCOUNTER_CLASS);
  }

// -- EncounterType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-encounterType|0.1.0
// encounter type

  public static Extension makeEncounterType(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ENCOUNTER_TYPE).setValue(value);
  }

  public static Basic setEncounterType(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENCOUNTER_TYPE, value);
    return context;
  }

  public static CodeableConcept getEncounterType(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_ENCOUNTER_TYPE);
  }

// -- CQFExpression -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-expression|0.1.0
// CQF Expression

  public static Extension makeCQFExpression(Expression value) {
    return new Extension(ExtensionConstants.EXT_CQFEXPRESSION).setValue(value);
  }

  public static Element setCQFExpression(Element context, Expression value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CQFEXPRESSION, value);
    return context;
  }

  public static Expression getCQFExpression(Element context) {
    return ExtensionsUtils.getExtension(Expression.class, context, ExtensionConstants.EXT_CQFEXPRESSION);
  }

// -- InitialValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-initialValue|0.1.0
// initial value

  public static Extension makeInitialValue(Expression value) {
    return new Extension(ExtensionConstants.EXT_INITIAL_VALUE).setValue(value);
  }

  public static Element addInitialValue(Element context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_INITIAL_VALUE, value);
    return context;
  }

  public static List<Expression> getInitialValueList(Element context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_INITIAL_VALUE);
  }

// -- InitiatingOrganization -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-initiatingOrganization|0.1.0
// initiating organization

  public static Extension makeInitiatingOrganization(Reference value) {
    return new Extension(ExtensionConstants.EXT_INITIATING_ORGANIZATION).setValue(value);
  }

  public static Basic setInitiatingOrganization(Basic context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_INITIATING_ORGANIZATION, value);
    return context;
  }

  public static Reference getInitiatingOrganization(Basic context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_INITIATING_ORGANIZATION);
  }

// -- InitiatingPerson -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-initiatingPerson|0.1.0
// initiating person

  public static Extension makeInitiatingPerson(Reference value) {
    return new Extension(ExtensionConstants.EXT_INITIATING_PERSON).setValue(value);
  }

  public static Basic setInitiatingPerson(Basic context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_INITIATING_PERSON, value);
    return context;
  }

  public static Reference getInitiatingPerson(Basic context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_INITIATING_PERSON);
  }

// -- InputParameters -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-inputParameters|0.1.0
// input parameters

  public static Extension makeInputParameters(Reference value) {
    return new Extension(ExtensionConstants.EXT_INPUT_PARAMETERS).setValue(value);
  }

  public static Element setInputParameters(Element context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_INPUT_PARAMETERS, value);
    return context;
  }

  public static Reference getInputParameters(Element context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_INPUT_PARAMETERS);
  }

// -- IsPrefetchToken -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-isPrefetchToken|0.1.0
// Is prefetch token

  public static Extension makeIsPrefetchToken(boolean value) {
    return new Extension(ExtensionConstants.EXT_IS_PREFETCH_TOKEN).setValue(new BooleanType(value));
  }

  public static ParameterDefinition setIsPrefetchToken(ParameterDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_IS_PREFETCH_TOKEN, new BooleanType(value));
    return context;
  }

  public static Boolean getIsPrefetchToken(ParameterDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_IS_PREFETCH_TOKEN);
  }

// -- CQFKnowledgeCapability -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-knowledgeCapability|0.1.0
// knowledge capability

  public static Extension makeCQFKnowledgeCapability(String value) {
    return new Extension(ExtensionConstants.EXT_CQFKNOWLEDGE_CAPABILITY).setValue(new CodeType(value));
  }

  public static Element addCQFKnowledgeCapability(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CQFKNOWLEDGE_CAPABILITY, new CodeType(value));
    return context;
  }

  public static List<String> getCQFKnowledgeCapabilityList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CQFKNOWLEDGE_CAPABILITY);
  }

// -- CQFKnowledgeRepresentationLevel -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-knowledgeRepresentationLevel|0.1.0
// knowledge representation level

  public static Extension makeCQFKnowledgeRepresentationLevel(String value) {
    return new Extension(ExtensionConstants.EXT_CQFKNOWLEDGE_REPRESENTATION_LEVEL).setValue(new CodeType(value));
  }

  public static Element addCQFKnowledgeRepresentationLevel(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CQFKNOWLEDGE_REPRESENTATION_LEVEL, new CodeType(value));
    return context;
  }

  public static List<String> getCQFKnowledgeRepresentationLevelList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CQFKNOWLEDGE_REPRESENTATION_LEVEL);
  }

// -- CQFLibrary -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-library|0.1.0
// CQF Library

  public static Extension makeCQFLibrary(String value) {
    return new Extension(ExtensionConstants.EXT_CQFLIBRARY).setValue(new CanonicalType(value));
  }

  public static Element addCQFLibrary(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CQFLIBRARY, new CanonicalType(value));
    return context;
  }

  public static List<String> getCQFLibraryList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_CQFLIBRARY);
  }

// -- ParameterDefinition -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-parameterDefinition|0.1.0
// Parameter definition

  public static Extension makeParameterDefinition(ParameterDefinition value) {
    return new Extension(ExtensionConstants.EXT_PARAMETER_DEFINITION).setValue(value);
  }

  public static TriggerDefinition addParameterDefinition(TriggerDefinition context, ParameterDefinition value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PARAMETER_DEFINITION, value);
    return context;
  }

  public static List<ParameterDefinition> getParameterDefinitionList(TriggerDefinition context) {
    return ExtensionsUtils.getExtensionList(ParameterDefinition.class, context, ExtensionConstants.EXT_PARAMETER_DEFINITION);
  }

// -- QualityOfEvidence -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-qualityOfEvidence|0.1.0
// quality of evidence

  public static Extension makeQualityOfEvidence(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_QUALITY_OF_EVIDENCE).setValue(value);
  }

  public static Element setQualityOfEvidence(Element context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QUALITY_OF_EVIDENCE, value);
    return context;
  }

  public static CodeableConcept getQualityOfEvidence(Element context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_QUALITY_OF_EVIDENCE);
  }

// -- ReceivingOrganization -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-receivingOrganization|0.1.0
// receiving organization

  public static Extension makeReceivingOrganization(Reference value) {
    return new Extension(ExtensionConstants.EXT_RECEIVING_ORGANIZATION).setValue(value);
  }

  public static Basic setReceivingOrganization(Basic context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RECEIVING_ORGANIZATION, value);
    return context;
  }

  public static Reference getReceivingOrganization(Basic context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_RECEIVING_ORGANIZATION);
  }

// -- ReceivingPerson -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-receivingPerson|0.1.0
// receiving person

  public static Extension makeReceivingPerson(Reference value) {
    return new Extension(ExtensionConstants.EXT_RECEIVING_PERSON).setValue(value);
  }

  public static Basic setReceivingPerson(Basic context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RECEIVING_PERSON, value);
    return context;
  }

  public static Reference getReceivingPerson(Basic context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_RECEIVING_PERSON);
  }

// -- RecipientLanguage -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-recipientLanguage|0.1.0
// recipient language

  public static Extension makeRecipientLanguage(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_RECIPIENT_LANGUAGE).setValue(value);
  }

  public static Basic setRecipientLanguage(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RECIPIENT_LANGUAGE, value);
    return context;
  }

  public static CodeableConcept getRecipientLanguage(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_RECIPIENT_LANGUAGE);
  }

// -- RecipientType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-recipientType|0.1.0
// recipient type

  public static Extension makeRecipientType(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_RECIPIENT_TYPE).setValue(value);
  }

  public static Basic setRecipientType(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RECIPIENT_TYPE, value);
    return context;
  }

  public static CodeableConcept getRecipientType(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_RECIPIENT_TYPE);
  }

// -- StrengthOfRecommendation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-strengthOfRecommendation|0.1.0
// strength of recommendation

  public static Extension makeStrengthOfRecommendation(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_STRENGTH_OF_RECOMMENDATION).setValue(value);
  }

  public static Element setStrengthOfRecommendation(Element context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_STRENGTH_OF_RECOMMENDATION, value);
    return context;
  }

  public static CodeableConcept getStrengthOfRecommendation(Element context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_STRENGTH_OF_RECOMMENDATION);
  }

// -- SupportedCqlVersion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-supportedCqlVersion|0.1.0
// supported cql version

  public static Extension makeSupportedCqlVersion(String value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CQL_VERSION).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent addSupportedCqlVersion(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SUPPORTED_CQL_VERSION, new StringType(value));
    return context;
  }

  public static List<String> getSupportedCqlVersionList(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SUPPORTED_CQL_VERSION);
  }

// -- SystemUserLanguage -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-systemUserLanguage|0.1.0
// system user language

  public static Extension makeSystemUserLanguage(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SYSTEM_USER_LANGUAGE).setValue(value);
  }

  public static Basic setSystemUserLanguage(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SYSTEM_USER_LANGUAGE, value);
    return context;
  }

  public static CodeableConcept getSystemUserLanguage(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_SYSTEM_USER_LANGUAGE);
  }

// -- SystemUserTaskContext -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-systemUserTaskContext|0.1.0
// system user task context

  public static Extension makeSystemUserTaskContext(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SYSTEM_USER_TASK_CONTEXT).setValue(value);
  }

  public static Basic setSystemUserTaskContext(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SYSTEM_USER_TASK_CONTEXT, value);
    return context;
  }

  public static CodeableConcept getSystemUserTaskContext(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_SYSTEM_USER_TASK_CONTEXT);
  }

// -- SystemUserType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqf-systemUserType|0.1.0
// system user type

  public static Extension makeSystemUserType(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SYSTEM_USER_TYPE).setValue(value);
  }

  public static Basic setSystemUserType(Basic context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SYSTEM_USER_TYPE, value);
    return context;
  }

  public static CodeableConcept getSystemUserType(Basic context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_SYSTEM_USER_TYPE);
  }

// -- CValidityPeriod -------------------------------------
// http://hl7.org/fhir/StructureDefinition/cqm-ValidityPeriod|0.1.0
// Composition Validity Period

  public static Extension makeCValidityPeriod(String value) {
    return new Extension(ExtensionConstants.EXT_CVALIDITY_PERIOD).setValue(new DateTimeType(value));
  }

  public static Composition setCValidityPeriod(Composition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_CVALIDITY_PERIOD, new DateTimeType(value));
    return context;
  }

  public static String getCValidityPeriod(Composition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_CVALIDITY_PERIOD);
  }

// -- DataAbsentReason -------------------------------------
// http://hl7.org/fhir/StructureDefinition/data-absent-reason|0.1.0
// Data Absent Reason

  public static Extension makeDataAbsentReason(String value) {
    return new Extension(ExtensionConstants.EXT_DATA_ABSENT_REASON).setValue(new CodeType(value));
  }

  public static Element setDataAbsentReason(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DATA_ABSENT_REASON, new CodeType(value));
    return context;
  }

  public static String getDataAbsentReason(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DATA_ABSENT_REASON);
  }

// -- DesignNote -------------------------------------
// http://hl7.org/fhir/StructureDefinition/designNote|0.1.0
// Design Note

  public static Extension makeDesignNote(String value) {
    return new Extension(ExtensionConstants.EXT_DESIGN_NOTE).setValue(new MarkdownType(value));
  }

  public static ElementDefinition setDesignNote(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DESIGN_NOTE, new MarkdownType(value));
    return context;
  }

  public static String getDesignNote(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DESIGN_NOTE);
  }

  public static Questionnaire setDesignNote(Questionnaire context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DESIGN_NOTE, new MarkdownType(value));
    return context;
  }

  public static String getDesignNote(Questionnaire context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DESIGN_NOTE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setDesignNote(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DESIGN_NOTE, new MarkdownType(value));
    return context;
  }

  public static String getDesignNote(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DESIGN_NOTE);
  }

// -- DevCommercialBrand -------------------------------------
// http://hl7.org/fhir/StructureDefinition/device-commercialBrand|0.1.0
// Device Commercial Brand

  public static Extension makeDevCommercialBrand(String value) {
    return new Extension(ExtensionConstants.EXT_DEV_COMMERCIAL_BRAND).setValue(new StringType(value));
  }

  public static Device setDevCommercialBrand(Device context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DEV_COMMERCIAL_BRAND, new StringType(value));
    return context;
  }

  public static String getDevCommercialBrand(Device context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DEV_COMMERCIAL_BRAND);
  }

  public static DeviceDefinition setDevCommercialBrand(DeviceDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DEV_COMMERCIAL_BRAND, new StringType(value));
    return context;
  }

  public static String getDevCommercialBrand(DeviceDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DEV_COMMERCIAL_BRAND);
  }

// -- DevImplantStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/device-implantStatus|0.1.0
// Device Implantable Status

  public static Extension makeDevImplantStatus(String value) {
    return new Extension(ExtensionConstants.EXT_DEV_IMPLANT_STATUS).setValue(new CodeType(value));
  }

  public static Device setDevImplantStatus(Device context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DEV_IMPLANT_STATUS, new CodeType(value));
    return context;
  }

  public static String getDevImplantStatus(Device context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DEV_IMPLANT_STATUS);
  }

// -- DRAddendumOf -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-addendumOf|0.1.0
// DiagnosticReport Addendum Of

  public static Extension makeDRAddendumOf(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRADDENDUM_OF).setValue(value);
  }

  public static DiagnosticReport setDRAddendumOf(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DRADDENDUM_OF, value);
    return context;
  }

  public static Reference getDRAddendumOf(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_DRADDENDUM_OF);
  }

// -- DRExtends -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-extends|0.1.0
// DiagnosticReport Extends

  public static Extension makeDRExtends(Reference value) {
    return new Extension(ExtensionConstants.EXT_DREXTENDS).setValue(value);
  }

  public static DiagnosticReport setDRExtends(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DREXTENDS, value);
    return context;
  }

  public static Reference getDRExtends(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_DREXTENDS);
  }

// -- DRFocus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-focus|0.1.0
// DiagnosticReport Delta

  public static Extension makeDRFocus(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRFOCUS).setValue(value);
  }

  public static DiagnosticReport addDRFocus(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DRFOCUS, value);
    return context;
  }

  public static List<Reference> getDRFocusList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_DRFOCUS);
  }

// -- DRLocationPerformed -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-locationPerformed|0.1.0
// DiagnosticReport Location Performed

  public static Extension makeDRLocationPerformed(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRLOCATION_PERFORMED).setValue(value);
  }

  public static DiagnosticReport setDRLocationPerformed(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DRLOCATION_PERFORMED, value);
    return context;
  }

  public static Reference getDRLocationPerformed(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_DRLOCATION_PERFORMED);
  }

// -- DRReplaces -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-replaces|0.1.0
// DiagnosticReport Replaces

  public static Extension makeDRReplaces(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRREPLACES).setValue(value);
  }

  public static DiagnosticReport setDRReplaces(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DRREPLACES, value);
    return context;
  }

  public static Reference getDRReplaces(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_DRREPLACES);
  }

// -- DRRisk -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-risk|0.1.0
// DiagnosticReport Risk

  public static Extension makeDRRisk(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRRISK).setValue(value);
  }

  public static DiagnosticReport addDRRisk(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DRRISK, value);
    return context;
  }

  public static List<Reference> getDRRiskList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_DRRISK);
  }

  public static Observation addDRRisk(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DRRISK, value);
    return context;
  }

  public static List<Reference> getDRRiskList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_DRRISK);
  }

// -- DRSummaryOf -------------------------------------
// http://hl7.org/fhir/StructureDefinition/diagnosticReport-summaryOf|0.1.0
// DocumentReference Summary Of

  public static Extension makeDRSummaryOf(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRSUMMARY_OF).setValue(value);
  }

  public static DiagnosticReport setDRSummaryOf(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DRSUMMARY_OF, value);
    return context;
  }

  public static Reference getDRSummaryOf(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_DRSUMMARY_OF);
  }

// -- DisplayName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/display|0.1.0
// Display Name

  public static Extension makeDisplayName(String value) {
    return new Extension(ExtensionConstants.EXT_DISPLAY_NAME).setValue(new StringType(value));
  }

  public static CanonicalType setDisplayName(CanonicalType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DISPLAY_NAME, new StringType(value));
    return context;
  }

  public static String getDisplayName(CanonicalType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DISPLAY_NAME);
  }

// -- DRSourcepatient -------------------------------------
// http://hl7.org/fhir/StructureDefinition/documentreference-sourcepatient|0.1.0
// DocumentReference Source Patient

  public static Extension makeDRSourcepatient(Reference value) {
    return new Extension(ExtensionConstants.EXT_DRSOURCEPATIENT).setValue(value);
  }

  public static DocumentReference setDRSourcepatient(DocumentReference context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DRSOURCEPATIENT, value);
    return context;
  }

  public static Reference getDRSourcepatient(DocumentReference context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_DRSOURCEPATIENT);
  }

// -- DRThumbnail -------------------------------------
// http://hl7.org/fhir/StructureDefinition/documentreference-thumbnail|0.1.0
// DocumentReference Thumbnail

  public static Extension makeDRThumbnail(boolean value) {
    return new Extension(ExtensionConstants.EXT_DRTHUMBNAIL).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent setDRThumbnail(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DRTHUMBNAIL, new BooleanType(value));
    return context;
  }

  public static Boolean getDRThumbnail(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_DRTHUMBNAIL);
  }

// -- AllowedUnits -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits|0.1.0
// Allowed Units

  public static Extension makeAllowedUnits(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ALLOWED_UNITS).setValue(value);
  }

  public static Extension makeAllowedUnits(String value) {
    return new Extension(ExtensionConstants.EXT_ALLOWED_UNITS).setValue(new CanonicalType(value));
  }

  public static ElementDefinition setAllowedUnits(ElementDefinition context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ALLOWED_UNITS, value);
    return context;
  }

  public static CodeableConcept getAllowedUnitsCodeableConcept(ElementDefinition context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_ALLOWED_UNITS);
  }

  public static ElementDefinition setAllowedUnits(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ALLOWED_UNITS, new CanonicalType(value));
    return context;
  }

  public static String getAllowedUnitsString(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ALLOWED_UNITS);
  }

// -- BestPractice -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-bestpractice|0.1.0
// Best Practice

  public static Extension makeBestPractice(boolean value) {
    return new Extension(ExtensionConstants.EXT_BEST_PRACTICE).setValue(new BooleanType(value));
  }

  public static Extension makeBestPractice(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_BEST_PRACTICE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent setBestPractice(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_BEST_PRACTICE, new BooleanType(value));
    return context;
  }

  public static Boolean getBestPracticeBoolean(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_BEST_PRACTICE);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent setBestPractice(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_BEST_PRACTICE, value);
    return context;
  }

  public static CodeableConcept getBestPracticeCodeableConcept(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_BEST_PRACTICE);
  }

// -- BestPracticeExplanation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-bestpractice-explanation|0.1.0
// Best Practice Explanation

  public static Extension makeBestPracticeExplanation(String value) {
    return new Extension(ExtensionConstants.EXT_BEST_PRACTICE_EXPLANATION).setValue(new MarkdownType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent setBestPracticeExplanation(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_BEST_PRACTICE_EXPLANATION, new MarkdownType(value));
    return context;
  }

  public static String getBestPracticeExplanation(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_BEST_PRACTICE_EXPLANATION);
  }

// -- BindingName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-bindingName|0.1.0
// Binding name

  public static Extension makeBindingName(String value) {
    return new Extension(ExtensionConstants.EXT_BINDING_NAME).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent setBindingName(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_BINDING_NAME, new StringType(value));
    return context;
  }

  public static String getBindingName(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_BINDING_NAME);
  }

// -- Conceptmap -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-conceptmap|0.1.0
// Conceptmap

  public static Extension makeConceptmap(String value) {
    return new Extension(ExtensionConstants.EXT_CONCEPTMAP).setValue(new CanonicalType(value));
  }

// -- DefaultType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-defaulttype|0.1.0
// Default Type

  public static Extension makeDefaultType(String value) {
    return new Extension(ExtensionConstants.EXT_DEFAULT_TYPE).setValue(new CanonicalType(value));
  }

  public static ElementDefinition setDefaultType(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DEFAULT_TYPE, new CanonicalType(value));
    return context;
  }

  public static String getDefaultType(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_DEFAULT_TYPE);
  }

// -- Equivalence -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-equivalence|0.1.0
// Equivalence

  public static Extension makeEquivalence(String value) {
    return new Extension(ExtensionConstants.EXT_EQUIVALENCE).setValue(new CodeType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent setEquivalence(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EQUIVALENCE, new CodeType(value));
    return context;
  }

  public static String getEquivalence(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_EQUIVALENCE);
  }

// -- GraphConstraint -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-graphConstraint|0.1.0
// Graph constraint

  public static Extension makeGraphConstraint(String value) {
    return new Extension(ExtensionConstants.EXT_GRAPH_CONSTRAINT).setValue(new CanonicalType(value));
  }

// -- Identifier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-identifier|0.1.0
// Identifier

  public static Extension makeIdentifier(Identifier value) {
    return new Extension(ExtensionConstants.EXT_IDENTIFIER).setValue(value);
  }

  public static ElementDefinition addIdentifier(ElementDefinition context, Identifier value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_IDENTIFIER, value);
    return context;
  }

  public static List<Identifier> getIdentifierList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionList(Identifier.class, context, ExtensionConstants.EXT_IDENTIFIER);
  }

// -- InheritedExtensibleValueSet -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet|0.1.0
// Inherited extensible value set

  public static Extension makeInheritedExtensibleValueSetUri(String value) {
    return new Extension(ExtensionConstants.EXT_INHERITED_EXTENSIBLE_VALUE_SET).setValue(new UriType(value));
  }

  public static Extension makeInheritedExtensibleValueSetCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_INHERITED_EXTENSIBLE_VALUE_SET).setValue(new CanonicalType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent addInheritedExtensibleValueSetUri(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_INHERITED_EXTENSIBLE_VALUE_SET, new UriType(value));
    return context;
  }

  public static List<String> getInheritedExtensibleValueSetStringList(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_INHERITED_EXTENSIBLE_VALUE_SET);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent addInheritedExtensibleValueSetCanonical(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_INHERITED_EXTENSIBLE_VALUE_SET, new CanonicalType(value));
    return context;
  }

// -- IsCommonBinding -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-isCommonBinding|0.1.0
// Is common binding

  public static Extension makeIsCommonBinding(boolean value) {
    return new Extension(ExtensionConstants.EXT_IS_COMMON_BINDING).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent setIsCommonBinding(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_IS_COMMON_BINDING, new BooleanType(value));
    return context;
  }

  public static Boolean getIsCommonBinding(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_IS_COMMON_BINDING);
  }

// -- MaxValueSet -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet|0.1.0
// Max value set

  public static Extension makeMaxValueSetUri(String value) {
    return new Extension(ExtensionConstants.EXT_MAX_VALUE_SET).setValue(new UriType(value));
  }

  public static Extension makeMaxValueSetCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_MAX_VALUE_SET).setValue(new CanonicalType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent setMaxValueSetUri(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_VALUE_SET, new UriType(value));
    return context;
  }

  public static String getMaxValueSetString(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_MAX_VALUE_SET);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent setMaxValueSetCanonical(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_VALUE_SET, new CanonicalType(value));
    return context;
  }

// -- MinValueSet -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet|0.1.0
// Min value set

  public static Extension makeMinValueSetUri(String value) {
    return new Extension(ExtensionConstants.EXT_MIN_VALUE_SET).setValue(new UriType(value));
  }

  public static Extension makeMinValueSetCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_MIN_VALUE_SET).setValue(new CanonicalType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent setMinValueSetUri(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MIN_VALUE_SET, new UriType(value));
    return context;
  }

  public static String getMinValueSetString(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_MIN_VALUE_SET);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent setMinValueSetCanonical(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MIN_VALUE_SET, new CanonicalType(value));
    return context;
  }

// -- Namespace -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace|0.1.0
// Namespace

  public static Extension makeNamespace(String value) {
    return new Extension(ExtensionConstants.EXT_NAMESPACE).setValue(new UriType(value));
  }

  public static ElementDefinition setNamespace(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NAMESPACE, new UriType(value));
    return context;
  }

  public static String getNamespace(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NAMESPACE);
  }

  public static StructureDefinition setNamespace(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NAMESPACE, new UriType(value));
    return context;
  }

  public static String getNamespace(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NAMESPACE);
  }

// -- Pattern -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-pattern|0.1.0
// Pattern

  public static Extension makePattern(String value) {
    return new Extension(ExtensionConstants.EXT_PATTERN).setValue(new CanonicalType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setPattern(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PATTERN, new CanonicalType(value));
    return context;
  }

  public static String getPattern(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PATTERN);
  }

// -- ProfileElement -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-profile-element|0.1.0
// Profile Element

  public static Extension makeProfileElement(String value) {
    return new Extension(ExtensionConstants.EXT_PROFILE_ELEMENT).setValue(new StringType(value));
  }

// -- Question -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-question|0.1.0
// Question

  public static Extension makeQuestion(String value) {
    return new Extension(ExtensionConstants.EXT_QUESTION).setValue(new StringType(value));
  }

  public static ElementDefinition addQuestion(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QUESTION, new StringType(value));
    return context;
  }

  public static List<String> getQuestionList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QUESTION);
  }

// -- Selector -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-selector|0.1.0
// Selector

  public static Extension makeSelector(String value) {
    return new Extension(ExtensionConstants.EXT_SELECTOR).setValue(new StringType(value));
  }

  public static ElementDefinition setSelector(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SELECTOR, new StringType(value));
    return context;
  }

  public static String getSelector(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SELECTOR);
  }

// -- Suppress -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-suppress|0.1.0
// Suppress

  public static Extension makeSuppress(boolean value) {
    return new Extension(ExtensionConstants.EXT_SUPPRESS).setValue(new BooleanType(value));
  }

  public static Coding setSuppress(Coding context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPRESS, new BooleanType(value));
    return context;
  }

  public static Boolean getSuppress(Coding context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SUPPRESS);
  }

  public static MarkdownType setSuppress(MarkdownType context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPRESS, new BooleanType(value));
    return context;
  }

  public static Boolean getSuppress(MarkdownType context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SUPPRESS);
  }

  public static StringType setSuppress(StringType context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPRESS, new BooleanType(value));
    return context;
  }

  public static Boolean getSuppress(StringType context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SUPPRESS);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent setSuppress(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPRESS, new BooleanType(value));
    return context;
  }

  public static Boolean getSuppress(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SUPPRESS);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent setSuppress(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPRESS, new BooleanType(value));
    return context;
  }

  public static Boolean getSuppress(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SUPPRESS);
  }

// -- Translatable -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-translatable|0.1.0
// Translatable

  public static Extension makeTranslatable(boolean value) {
    return new Extension(ExtensionConstants.EXT_TRANSLATABLE).setValue(new BooleanType(value));
  }

  public static ElementDefinition setTranslatable(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRANSLATABLE, new BooleanType(value));
    return context;
  }

  public static Boolean getTranslatable(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_TRANSLATABLE);
  }

// -- TypeMustSupport -------------------------------------
// http://hl7.org/fhir/StructureDefinition/elementdefinition-type-must-support|0.1.0
// Type must support

  public static Extension makeTypeMustSupport(boolean value) {
    return new Extension(ExtensionConstants.EXT_TYPE_MUST_SUPPORT).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setTypeMustSupport(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TYPE_MUST_SUPPORT, new BooleanType(value));
    return context;
  }

  public static Boolean getTypeMustSupport(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_TYPE_MUST_SUPPORT);
  }

// -- EncAssociatedEncounter -------------------------------------
// http://hl7.org/fhir/StructureDefinition/encounter-associatedEncounter|0.1.0
// Encounter Associated Encounter

  public static Extension makeEncAssociatedEncounter(Reference value) {
    return new Extension(ExtensionConstants.EXT_ENC_ASSOCIATED_ENCOUNTER).setValue(value);
  }

  public static Encounter setEncAssociatedEncounter(Encounter context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENC_ASSOCIATED_ENCOUNTER, value);
    return context;
  }

  public static Reference getEncAssociatedEncounter(Encounter context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_ENC_ASSOCIATED_ENCOUNTER);
  }

// -- EncModeOfArrival -------------------------------------
// http://hl7.org/fhir/StructureDefinition/encounter-modeOfArrival|0.1.0
// Encounter Mode Of Arrival

  public static Extension makeEncModeOfArrival(Coding value) {
    return new Extension(ExtensionConstants.EXT_ENC_MODE_OF_ARRIVAL).setValue(value);
  }

  public static Encounter setEncModeOfArrival(Encounter context, Coding value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENC_MODE_OF_ARRIVAL, value);
    return context;
  }

  public static Coding getEncModeOfArrival(Encounter context) {
    return ExtensionsUtils.getExtension(Coding.class, context, ExtensionConstants.EXT_ENC_MODE_OF_ARRIVAL);
  }

// -- EncReasonCancelled -------------------------------------
// http://hl7.org/fhir/StructureDefinition/encounter-reasonCancelled|0.1.0
// Encounter Reason Cancelled

  public static Extension makeEncReasonCancelled(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_ENC_REASON_CANCELLED).setValue(value);
  }

  public static Encounter setEncReasonCancelled(Encounter context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENC_REASON_CANCELLED, value);
    return context;
  }

  public static CodeableConcept getEncReasonCancelled(Encounter context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_ENC_REASON_CANCELLED);
  }

// -- EntryFormat -------------------------------------
// http://hl7.org/fhir/StructureDefinition/entryFormat|0.1.0
// entry format

  public static Extension makeEntryFormat(String value) {
    return new Extension(ExtensionConstants.EXT_ENTRY_FORMAT).setValue(new StringType(value));
  }

  public static ElementDefinition setEntryFormat(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENTRY_FORMAT, new StringType(value));
    return context;
  }

  public static String getEntryFormat(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ENTRY_FORMAT);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setEntryFormat(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENTRY_FORMAT, new StringType(value));
    return context;
  }

  public static String getEntryFormat(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ENTRY_FORMAT);
  }

// -- BasedOn -------------------------------------
// http://hl7.org/fhir/StructureDefinition/event-basedOn|0.1.0
// based on

  public static Extension makeBasedOn(Reference value) {
    return new Extension(ExtensionConstants.EXT_BASED_ON).setValue(value);
  }

  public static ChargeItem addBasedOn(ChargeItem context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(ChargeItem context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static ClinicalImpression addBasedOn(ClinicalImpression context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(ClinicalImpression context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static Composition addBasedOn(Composition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(Composition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static Condition addBasedOn(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static Consent addBasedOn(Consent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(Consent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static Coverage addBasedOn(Coverage context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(Coverage context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static DetectedIssue addBasedOn(DetectedIssue context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(DetectedIssue context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static EpisodeOfCare addBasedOn(EpisodeOfCare context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(EpisodeOfCare context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static ExplanationOfBenefit addBasedOn(ExplanationOfBenefit context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(ExplanationOfBenefit context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static FamilyMemberHistory addBasedOn(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static ImmunizationEvaluation addBasedOn(ImmunizationEvaluation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(ImmunizationEvaluation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static InventoryReport addBasedOn(InventoryReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(InventoryReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static MedicationStatement addBasedOn(MedicationStatement context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(MedicationStatement context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static PaymentNotice addBasedOn(PaymentNotice context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(PaymentNotice context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

  public static PaymentReconciliation addBasedOn(PaymentReconciliation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BASED_ON, value);
    return context;
  }

  public static List<Reference> getBasedOnList(PaymentReconciliation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_BASED_ON);
  }

// -- EventHistory -------------------------------------
// http://hl7.org/fhir/StructureDefinition/event-eventHistory|0.1.0
// event history

  public static Extension makeEventHistory(Reference value) {
    return new Extension(ExtensionConstants.EXT_EVENT_HISTORY).setValue(value);
  }

  public static DeviceUsage addEventHistory(DeviceUsage context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EVENT_HISTORY, value);
    return context;
  }

  public static List<Reference> getEventHistoryList(DeviceUsage context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EVENT_HISTORY);
  }

  public static DiagnosticReport addEventHistory(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EVENT_HISTORY, value);
    return context;
  }

  public static List<Reference> getEventHistoryList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EVENT_HISTORY);
  }

  public static Observation addEventHistory(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EVENT_HISTORY, value);
    return context;
  }

  public static List<Reference> getEventHistoryList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EVENT_HISTORY);
  }

  public static SupplyDelivery addEventHistory(SupplyDelivery context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EVENT_HISTORY, value);
    return context;
  }

  public static List<Reference> getEventHistoryList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EVENT_HISTORY);
  }

  public static Task addEventHistory(Task context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EVENT_HISTORY, value);
    return context;
  }

  public static List<Reference> getEventHistoryList(Task context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EVENT_HISTORY);
  }

// -- EventLocation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/event-location|0.1.0
// Event Location

  public static Extension makeEventLocation(Reference value) {
    return new Extension(ExtensionConstants.EXT_EVENT_LOCATION).setValue(value);
  }

  public static DiagnosticReport setEventLocation(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_LOCATION, value);
    return context;
  }

  public static Reference getEventLocation(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_EVENT_LOCATION);
  }

  public static DocumentReference setEventLocation(DocumentReference context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_LOCATION, value);
    return context;
  }

  public static Reference getEventLocation(DocumentReference context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_EVENT_LOCATION);
  }

  public static Observation setEventLocation(Observation context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_LOCATION, value);
    return context;
  }

  public static Reference getEventLocation(Observation context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_EVENT_LOCATION);
  }

  public static SupplyDelivery setEventLocation(SupplyDelivery context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_LOCATION, value);
    return context;
  }

  public static Reference getEventLocation(SupplyDelivery context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_EVENT_LOCATION);
  }

// -- PartOf -------------------------------------
// http://hl7.org/fhir/StructureDefinition/event-partOf|0.1.0
// part of

  public static Extension makePartOf(Reference value) {
    return new Extension(ExtensionConstants.EXT_PART_OF).setValue(value);
  }

  public static Condition addPartOf(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PART_OF, value);
    return context;
  }

  public static List<Reference> getPartOfList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PART_OF);
  }

  public static DiagnosticReport addPartOf(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PART_OF, value);
    return context;
  }

  public static List<Reference> getPartOfList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PART_OF);
  }

// -- PerformerFunction -------------------------------------
// http://hl7.org/fhir/StructureDefinition/event-performerFunction|0.1.0
// performer function

  public static Extension makePerformerFunction(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PERFORMER_FUNCTION).setValue(value);
  }

  public static Reference setPerformerFunction(Reference context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PERFORMER_FUNCTION, value);
    return context;
  }

  public static CodeableConcept getPerformerFunction(Reference context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PERFORMER_FUNCTION);
  }

// -- EventStatusReason -------------------------------------
// http://hl7.org/fhir/StructureDefinition/event-statusReason|0.1.0
// status reason

  public static Extension makeEventStatusReason(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_EVENT_STATUS_REASON).setValue(value);
  }

  public static DeviceUsage setEventStatusReason(DeviceUsage context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getEventStatusReason(DeviceUsage context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_EVENT_STATUS_REASON);
  }

  public static DiagnosticReport setEventStatusReason(DiagnosticReport context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getEventStatusReason(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_EVENT_STATUS_REASON);
  }

  public static DocumentReference setEventStatusReason(DocumentReference context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getEventStatusReason(DocumentReference context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_EVENT_STATUS_REASON);
  }

  public static Observation setEventStatusReason(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getEventStatusReason(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_EVENT_STATUS_REASON);
  }

  public static SupplyDelivery setEventStatusReason(SupplyDelivery context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EVENT_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getEventStatusReason(SupplyDelivery context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_EVENT_STATUS_REASON);
  }

// -- ExtendedContactAvailability -------------------------------------
// http://hl7.org/fhir/StructureDefinition/extended-contact-availability|0.1.0
// Extended Contact Availability

  public static Extension makeExtendedContactAvailability(Availability value) {
    return new Extension(ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY).setValue(value);
  }

  public static Address setExtendedContactAvailability(Address context, Availability value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY, value);
    return context;
  }

  public static Availability getExtendedContactAvailability(Address context) {
    return ExtensionsUtils.getExtension(Availability.class, context, ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY);
  }

  public static ContactDetail setExtendedContactAvailability(ContactDetail context, Availability value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY, value);
    return context;
  }

  public static Availability getExtendedContactAvailability(ContactDetail context) {
    return ExtensionsUtils.getExtension(Availability.class, context, ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY);
  }

  public static ExtendedContactDetail setExtendedContactAvailability(ExtendedContactDetail context, Availability value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY, value);
    return context;
  }

  public static Availability getExtendedContactAvailability(ExtendedContactDetail context) {
    return ExtensionsUtils.getExtension(Availability.class, context, ExtensionConstants.EXT_EXTENDED_CONTACT_AVAILABILITY);
  }

// -- QuantityTranslation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/extension-quantity-translation|0.1.0
// Quantity Translation

  public static Extension makeQuantityTranslation(Quantity value) {
    return new Extension(ExtensionConstants.EXT_QUANTITY_TRANSLATION).setValue(value);
  }

  public static Quantity addQuantityTranslation(Quantity context, Quantity value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QUANTITY_TRANSLATION, value);
    return context;
  }

  public static List<Quantity> getQuantityTranslationList(Quantity context) {
    return ExtensionsUtils.getExtensionList(Quantity.class, context, ExtensionConstants.EXT_QUANTITY_TRANSLATION);
  }

// -- FMHObservation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/family-member-history-genetics-observation|0.1.0
// FamilyMemberHistory Observation

  public static Extension makeFMHObservation(Reference value) {
    return new Extension(ExtensionConstants.EXT_FMHOBSERVATION).setValue(value);
  }

  public static FamilyMemberHistory addFMHObservation(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FMHOBSERVATION, value);
    return context;
  }

  public static List<Reference> getFMHObservationList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FMHOBSERVATION);
  }

// -- FMHAbatement -------------------------------------
// http://hl7.org/fhir/StructureDefinition/familymemberhistory-abatement|0.1.0
// FamilyMemberHistory Abatement

  public static Extension makeFMHAbatement(String value) {
    return new Extension(ExtensionConstants.EXT_FMHABATEMENT).setValue(new DateType(value));
  }

  public static Extension makeFMHAbatement(Age value) {
    return new Extension(ExtensionConstants.EXT_FMHABATEMENT).setValue(value);
  }

  public static Extension makeFMHAbatement(boolean value) {
    return new Extension(ExtensionConstants.EXT_FMHABATEMENT).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent setFMHAbatement(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FMHABATEMENT, new DateType(value));
    return context;
  }

  public static String getFMHAbatementString(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_FMHABATEMENT);
  }

  public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent setFMHAbatement(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context, Age value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FMHABATEMENT, value);
    return context;
  }

  public static Age getFMHAbatementAge(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context) {
    return ExtensionsUtils.getExtension(Age.class, context, ExtensionConstants.EXT_FMHABATEMENT);
  }

  public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent setFMHAbatement(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FMHABATEMENT, new BooleanType(value));
    return context;
  }

  public static Boolean getFMHAbatementBoolean(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_FMHABATEMENT);
  }

// -- FMHPatientRecord -------------------------------------
// http://hl7.org/fhir/StructureDefinition/familymemberhistory-patient-record|0.1.0
// FamilyMemberHistory Patient Record

  public static Extension makeFMHPatientRecord(Reference value) {
    return new Extension(ExtensionConstants.EXT_FMHPATIENT_RECORD).setValue(value);
  }

  public static FamilyMemberHistory addFMHPatientRecord(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FMHPATIENT_RECORD, value);
    return context;
  }

  public static List<Reference> getFMHPatientRecordList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FMHPATIENT_RECORD);
  }

// -- FMHSeverity -------------------------------------
// http://hl7.org/fhir/StructureDefinition/familymemberhistory-severity|0.1.0
// FamilyMemberHistory Severity

  public static Extension makeFMHSeverity(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_FMHSEVERITY).setValue(value);
  }

  public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent setFMHSeverity(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FMHSEVERITY, value);
    return context;
  }

  public static CodeableConcept getFMHSeverity(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_FMHSEVERITY);
  }

// -- FMHType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/familymemberhistory-type|0.1.0
// FamilyMemberHistory Type

  public static Extension makeFMHType(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_FMHTYPE).setValue(value);
  }

  public static FamilyMemberHistory setFMHType(FamilyMemberHistory context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FMHTYPE, value);
    return context;
  }

  public static CodeableConcept getFMHType(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_FMHTYPE);
  }

// -- FirstCreated -------------------------------------
// http://hl7.org/fhir/StructureDefinition/firstCreated|0.1.0
// First created

  public static Extension makeFirstCreated(String value) {
    return new Extension(ExtensionConstants.EXT_FIRST_CREATED).setValue(new InstantType(value));
  }

  public static Meta setFirstCreated(Meta context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FIRST_CREATED, new InstantType(value));
    return context;
  }

  public static String getFirstCreated(Meta context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_FIRST_CREATED);
  }

// -- FlagDetail -------------------------------------
// http://hl7.org/fhir/StructureDefinition/flag-detail|0.1.0
// Flag details

  public static Extension makeFlagDetail(Reference value) {
    return new Extension(ExtensionConstants.EXT_FLAG_DETAIL).setValue(value);
  }

  public static Flag addFlagDetail(Flag context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FLAG_DETAIL, value);
    return context;
  }

  public static List<Reference> getFlagDetailList(Flag context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FLAG_DETAIL);
  }

// -- FlagPriority -------------------------------------
// http://hl7.org/fhir/StructureDefinition/flag-priority|0.1.0
// Flag Priority

  public static Extension makeFlagPriority(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_FLAG_PRIORITY).setValue(value);
  }

  public static Flag setFlagPriority(Flag context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_FLAG_PRIORITY, value);
    return context;
  }

  public static CodeableConcept getFlagPriority(Flag context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_FLAG_PRIORITY);
  }

// -- GoalReasonRejected -------------------------------------
// http://hl7.org/fhir/StructureDefinition/goal-reasonRejected|0.1.0
// Goal Reason Rejected

  public static Extension makeGoalReasonRejected(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_GOAL_REASON_REJECTED).setValue(value);
  }

  public static Goal setGoalReasonRejected(Goal context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GOAL_REASON_REJECTED, value);
    return context;
  }

  public static CodeableConcept getGoalReasonRejected(Goal context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_GOAL_REASON_REJECTED);
  }

// -- BundleHttpResponseHeader -------------------------------------
// http://hl7.org/fhir/StructureDefinition/http-response-header|0.1.0
// Bundle HTTP Response header

  public static Extension makeBundleHttpResponseHeader(String value) {
    return new Extension(ExtensionConstants.EXT_BUNDLE_HTTP_RESPONSE_HEADER).setValue(new StringType(value));
  }

// -- AssemblyOrder -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-assembly-order|0.1.0
// Assembly Order

  public static Extension makeAssemblyOrder(String value) {
    return new Extension(ExtensionConstants.EXT_ASSEMBLY_ORDER).setValue(new CodeType(value));
  }

  public static HumanName setAssemblyOrder(HumanName context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ASSEMBLY_ORDER, new CodeType(value));
    return context;
  }

  public static String getAssemblyOrder(HumanName context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ASSEMBLY_ORDER);
  }

// -- FathersFamily -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-fathers-family|0.1.0
// Fathers Family

  public static Extension makeFathersFamily(String value) {
    return new Extension(ExtensionConstants.EXT_FATHERS_FAMILY).setValue(new StringType(value));
  }

  public static StringType addFathersFamily(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FATHERS_FAMILY, new StringType(value));
    return context;
  }

  public static List<String> getFathersFamilyList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_FATHERS_FAMILY);
  }

// -- MothersFamily -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-mothers-family|0.1.0
// Mothers Family

  public static Extension makeMothersFamily(String value) {
    return new Extension(ExtensionConstants.EXT_MOTHERS_FAMILY).setValue(new StringType(value));
  }

  public static StringType addMothersFamily(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MOTHERS_FAMILY, new StringType(value));
    return context;
  }

  public static List<String> getMothersFamilyList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_MOTHERS_FAMILY);
  }

// -- OwnName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-own-name|0.1.0
// Own Name

  public static Extension makeOwnName(String value) {
    return new Extension(ExtensionConstants.EXT_OWN_NAME).setValue(new StringType(value));
  }

  public static StringType setOwnName(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OWN_NAME, new StringType(value));
    return context;
  }

  public static String getOwnName(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OWN_NAME);
  }

// -- OwnPrefix -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-own-prefix|0.1.0
// Own Prefix

  public static Extension makeOwnPrefix(String value) {
    return new Extension(ExtensionConstants.EXT_OWN_PREFIX).setValue(new StringType(value));
  }

  public static StringType setOwnPrefix(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OWN_PREFIX, new StringType(value));
    return context;
  }

  public static String getOwnPrefix(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OWN_PREFIX);
  }

// -- PartnerName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-partner-name|0.1.0
// Partner Name

  public static Extension makePartnerName(String value) {
    return new Extension(ExtensionConstants.EXT_PARTNER_NAME).setValue(new StringType(value));
  }

  public static StringType setPartnerName(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PARTNER_NAME, new StringType(value));
    return context;
  }

  public static String getPartnerName(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PARTNER_NAME);
  }

// -- PartnerPrefix -------------------------------------
// http://hl7.org/fhir/StructureDefinition/humanname-partner-prefix|0.1.0
// Partner Prefix

  public static Extension makePartnerPrefix(String value) {
    return new Extension(ExtensionConstants.EXT_PARTNER_PREFIX).setValue(new StringType(value));
  }

  public static StringType setPartnerPrefix(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PARTNER_PREFIX, new StringType(value));
    return context;
  }

  public static String getPartnerPrefix(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PARTNER_PREFIX);
  }

// -- IDCheckDigit -------------------------------------
// http://hl7.org/fhir/StructureDefinition/identifier-checkDigit|0.1.0
// ID Check digit

  public static Extension makeIDCheckDigit(String value) {
    return new Extension(ExtensionConstants.EXT_IDCHECK_DIGIT).setValue(new StringType(value));
  }

  public static Identifier setIDCheckDigit(Identifier context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_IDCHECK_DIGIT, new StringType(value));
    return context;
  }

  public static String getIDCheckDigit(Identifier context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_IDCHECK_DIGIT);
  }

// -- ValidDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/identifier-validDate|0.1.0
// Valid date

  public static Extension makeValidDate(String value) {
    return new Extension(ExtensionConstants.EXT_VALID_DATE).setValue(new DateTimeType(value));
  }

  public static Identifier addValidDate(Identifier context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VALID_DATE, new DateTimeType(value));
    return context;
  }

  public static List<String> getValidDateList(Identifier context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_VALID_DATE);
  }

// -- ImmProcedure -------------------------------------
// http://hl7.org/fhir/StructureDefinition/immunization-procedure|0.1.0
// Immunization Procedure

  public static Extension makeImmProcedure(CodeableReference value) {
    return new Extension(ExtensionConstants.EXT_IMM_PROCEDURE).setValue(value);
  }

  public static Immunization setImmProcedure(Immunization context, CodeableReference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_IMM_PROCEDURE, value);
    return context;
  }

  public static CodeableReference getImmProcedure(Immunization context) {
    return ExtensionsUtils.getExtension(CodeableReference.class, context, ExtensionConstants.EXT_IMM_PROCEDURE);
  }

// -- ADUse -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-AD-use|0.1.0
// AD Use

  public static Extension makeADUse(String value) {
    return new Extension(ExtensionConstants.EXT_ADUSE).setValue(new CodeType(value));
  }

  public static Address setADUse(Address context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ADUSE, new CodeType(value));
    return context;
  }

  public static String getADUse(Address context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ADUSE);
  }

// -- ADXPAdditionalLocator -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-additionalLocator|0.1.0
// ADXP Additional Locator

  public static Extension makeADXPAdditionalLocator(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPADDITIONAL_LOCATOR).setValue(new StringType(value));
  }

  public static StringType addADXPAdditionalLocator(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPADDITIONAL_LOCATOR, new StringType(value));
    return context;
  }

  public static List<String> getADXPAdditionalLocatorList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPADDITIONAL_LOCATOR);
  }

// -- ADXPBuildingNumberSuffix -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-buildingNumberSuffix|0.1.0
// ADXP Building Number Suffix

  public static Extension makeADXPBuildingNumberSuffix(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPBUILDING_NUMBER_SUFFIX).setValue(new StringType(value));
  }

  public static StringType addADXPBuildingNumberSuffix(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPBUILDING_NUMBER_SUFFIX, new StringType(value));
    return context;
  }

  public static List<String> getADXPBuildingNumberSuffixList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPBUILDING_NUMBER_SUFFIX);
  }

// -- ADXPCareOf -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-careOf|0.1.0
// ADXP Care Of

  public static Extension makeADXPCareOf(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPCARE_OF).setValue(new StringType(value));
  }

  public static StringType addADXPCareOf(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPCARE_OF, new StringType(value));
    return context;
  }

  public static List<String> getADXPCareOfList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPCARE_OF);
  }

// -- ADXPCensusTract -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-censusTract|0.1.0
// ADXP Census Tract

  public static Extension makeADXPCensusTract(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPCENSUS_TRACT).setValue(new StringType(value));
  }

  public static StringType addADXPCensusTract(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPCENSUS_TRACT, new StringType(value));
    return context;
  }

  public static List<String> getADXPCensusTractList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPCENSUS_TRACT);
  }

// -- ADXPDelimiter -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-delimiter|0.1.0
// ADXP Delimiter

  public static Extension makeADXPDelimiter(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIMITER).setValue(new StringType(value));
  }

  public static StringType addADXPDelimiter(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIMITER, new StringType(value));
    return context;
  }

  public static List<String> getADXPDelimiterList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIMITER);
  }

// -- ADXPDeliveryAddressLine -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryAddressLine|0.1.0
// ADXP Delivery Address Line

  public static Extension makeADXPDeliveryAddressLine(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIVERY_ADDRESS_LINE).setValue(new StringType(value));
  }

  public static StringType addADXPDeliveryAddressLine(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIVERY_ADDRESS_LINE, new StringType(value));
    return context;
  }

  public static List<String> getADXPDeliveryAddressLineList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIVERY_ADDRESS_LINE);
  }

// -- ADXPDeliveryInstallationArea -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryInstallationArea|0.1.0
// ADXP Delivery Installation Area

  public static Extension makeADXPDeliveryInstallationArea(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_AREA).setValue(new StringType(value));
  }

  public static StringType addADXPDeliveryInstallationArea(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_AREA, new StringType(value));
    return context;
  }

  public static List<String> getADXPDeliveryInstallationAreaList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_AREA);
  }

// -- ADXPDeliveryInstallationQualifier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryInstallationQualifier|0.1.0
// ADXP Delivery Installation Qualifier

  public static Extension makeADXPDeliveryInstallationQualifier(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_QUALIFIER).setValue(new StringType(value));
  }

  public static StringType addADXPDeliveryInstallationQualifier(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_QUALIFIER, new StringType(value));
    return context;
  }

  public static List<String> getADXPDeliveryInstallationQualifierList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_QUALIFIER);
  }

// -- ADXPDeliveryInstallationType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryInstallationType|0.1.0
// ADXP Delivery Installation Type

  public static Extension makeADXPDeliveryInstallationType(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_TYPE).setValue(new StringType(value));
  }

  public static StringType addADXPDeliveryInstallationType(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_TYPE, new StringType(value));
    return context;
  }

  public static List<String> getADXPDeliveryInstallationTypeList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIVERY_INSTALLATION_TYPE);
  }

// -- ADXPDeliveryMode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryMode|0.1.0
// ADXP Delivery Mode

  public static Extension makeADXPDeliveryMode(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIVERY_MODE).setValue(new StringType(value));
  }

  public static StringType addADXPDeliveryMode(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIVERY_MODE, new StringType(value));
    return context;
  }

  public static List<String> getADXPDeliveryModeList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIVERY_MODE);
  }

// -- ADXPDeliveryModeIdentifier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-deliveryModeIdentifier|0.1.0
// ADXP Delivery Mode Identifier

  public static Extension makeADXPDeliveryModeIdentifier(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDELIVERY_MODE_IDENTIFIER).setValue(new StringType(value));
  }

  public static StringType addADXPDeliveryModeIdentifier(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDELIVERY_MODE_IDENTIFIER, new StringType(value));
    return context;
  }

  public static List<String> getADXPDeliveryModeIdentifierList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDELIVERY_MODE_IDENTIFIER);
  }

// -- ADXPDirection -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-direction|0.1.0
// ADXP Direction

  public static Extension makeADXPDirection(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPDIRECTION).setValue(new StringType(value));
  }

  public static StringType addADXPDirection(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPDIRECTION, new StringType(value));
    return context;
  }

  public static List<String> getADXPDirectionList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPDIRECTION);
  }

// -- ADXPHouseNumber -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-houseNumber|0.1.0
// ADXP House Number

  public static Extension makeADXPHouseNumber(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPHOUSE_NUMBER).setValue(new StringType(value));
  }

  public static StringType addADXPHouseNumber(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPHOUSE_NUMBER, new StringType(value));
    return context;
  }

  public static List<String> getADXPHouseNumberList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPHOUSE_NUMBER);
  }

// -- ADXPHouseNumberNumeric -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-houseNumberNumeric|0.1.0
// ADXP House Number Numeric

  public static Extension makeADXPHouseNumberNumeric(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPHOUSE_NUMBER_NUMERIC).setValue(new StringType(value));
  }

  public static StringType addADXPHouseNumberNumeric(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPHOUSE_NUMBER_NUMERIC, new StringType(value));
    return context;
  }

  public static List<String> getADXPHouseNumberNumericList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPHOUSE_NUMBER_NUMERIC);
  }

// -- ADXPPostBox -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-postBox|0.1.0
// ADXP Post Box

  public static Extension makeADXPPostBox(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPPOST_BOX).setValue(new StringType(value));
  }

  public static StringType addADXPPostBox(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPPOST_BOX, new StringType(value));
    return context;
  }

  public static List<String> getADXPPostBoxList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPPOST_BOX);
  }

// -- ADXPPrecinct -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-precinct|0.1.0
// ADXP Precinct

  public static Extension makeADXPPrecinct(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPPRECINCT).setValue(new StringType(value));
  }

  public static Address addADXPPrecinct(Address context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPPRECINCT, new StringType(value));
    return context;
  }

  public static List<String> getADXPPrecinctList(Address context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPPRECINCT);
  }

// -- ADXPStreetAddressLine -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetAddressLine|0.1.0
// ADXP Street Address Line

  public static Extension makeADXPStreetAddressLine(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPSTREET_ADDRESS_LINE).setValue(new StringType(value));
  }

  public static StringType addADXPStreetAddressLine(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPSTREET_ADDRESS_LINE, new StringType(value));
    return context;
  }

  public static List<String> getADXPStreetAddressLineList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPSTREET_ADDRESS_LINE);
  }

// -- ADXPStreetName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetName|0.1.0
// ADXP Street Name

  public static Extension makeADXPStreetName(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPSTREET_NAME).setValue(new StringType(value));
  }

  public static StringType addADXPStreetName(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPSTREET_NAME, new StringType(value));
    return context;
  }

  public static List<String> getADXPStreetNameList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPSTREET_NAME);
  }

// -- ADXPStreetNameBase -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetNameBase|0.1.0
// ADXP Street Name Base

  public static Extension makeADXPStreetNameBase(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPSTREET_NAME_BASE).setValue(new StringType(value));
  }

  public static StringType addADXPStreetNameBase(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPSTREET_NAME_BASE, new StringType(value));
    return context;
  }

  public static List<String> getADXPStreetNameBaseList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPSTREET_NAME_BASE);
  }

// -- ADXPStreetNameType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetNameType|0.1.0
// ADXP Street Name Type

  public static Extension makeADXPStreetNameType(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPSTREET_NAME_TYPE).setValue(new StringType(value));
  }

  public static StringType addADXPStreetNameType(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPSTREET_NAME_TYPE, new StringType(value));
    return context;
  }

  public static List<String> getADXPStreetNameTypeList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPSTREET_NAME_TYPE);
  }

// -- ADXPUnitID -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-unitID|0.1.0
// ADXP Unit ID

  public static Extension makeADXPUnitID(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPUNIT_I_D).setValue(new StringType(value));
  }

  public static StringType addADXPUnitID(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPUNIT_I_D, new StringType(value));
    return context;
  }

  public static List<String> getADXPUnitIDList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPUNIT_I_D);
  }

// -- ADXPUnitType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-unitType|0.1.0
// ADXP Unit Type

  public static Extension makeADXPUnitType(String value) {
    return new Extension(ExtensionConstants.EXT_ADXPUNIT_TYPE).setValue(new StringType(value));
  }

  public static StringType addADXPUnitType(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADXPUNIT_TYPE, new StringType(value));
    return context;
  }

  public static List<String> getADXPUnitTypeList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADXPUNIT_TYPE);
  }

// -- ENQualifier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-EN-qualifier|0.1.0
// EN Qualifier

  public static Extension makeENQualifier(String value) {
    return new Extension(ExtensionConstants.EXT_ENQUALIFIER).setValue(new CodeType(value));
  }

  public static StringType addENQualifier(StringType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ENQUALIFIER, new CodeType(value));
    return context;
  }

  public static List<String> getENQualifierList(StringType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ENQUALIFIER);
  }

// -- ENRepresentation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-EN-representation|0.1.0
// EN Representation

  public static Extension makeENRepresentation(String value) {
    return new Extension(ExtensionConstants.EXT_ENREPRESENTATION).setValue(new CodeType(value));
  }

  public static HumanName setENRepresentation(HumanName context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENREPRESENTATION, new CodeType(value));
    return context;
  }

  public static String getENRepresentation(HumanName context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ENREPRESENTATION);
  }

// -- ENUse -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-EN-use|0.1.0
// EN use

  public static Extension makeENUse(String value) {
    return new Extension(ExtensionConstants.EXT_ENUSE).setValue(new CodeType(value));
  }

  public static HumanName setENUse(HumanName context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ENUSE, new CodeType(value));
    return context;
  }

  public static String getENUse(HumanName context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ENUSE);
  }

// -- TELAddress -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-TEL-address|0.1.0
// TEL address

  public static Extension makeTELAddress(String value) {
    return new Extension(ExtensionConstants.EXT_TELADDRESS).setValue(new UrlType(value));
  }

  public static ContactPoint setTELAddress(ContactPoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TELADDRESS, new UrlType(value));
    return context;
  }

  public static String getTELAddress(ContactPoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TELADDRESS);
  }

// -- CodedString -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-codedString|0.1.0
// Coded string

  public static Extension makeCodedString(Coding value) {
    return new Extension(ExtensionConstants.EXT_CODED_STRING).setValue(value);
  }

  public static StringType addCodedString(StringType context, Coding value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_CODED_STRING, value);
    return context;
  }

  public static List<Coding> getCodedStringList(StringType context) {
    return ExtensionsUtils.getExtensionList(Coding.class, context, ExtensionConstants.EXT_CODED_STRING);
  }

// -- NullFlavor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-nullFlavor|0.1.0
// null flavor

  public static Extension makeNullFlavor(String value) {
    return new Extension(ExtensionConstants.EXT_NULL_FLAVOR).setValue(new CodeType(value));
  }

  public static Element setNullFlavor(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NULL_FLAVOR, new CodeType(value));
    return context;
  }

  public static String getNullFlavor(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NULL_FLAVOR);
  }

// -- Preferred -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-preferred|0.1.0
// Preferred

  public static Extension makePreferred(boolean value) {
    return new Extension(ExtensionConstants.EXT_PREFERRED).setValue(new BooleanType(value));
  }

  public static Address setPreferred(Address context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PREFERRED, new BooleanType(value));
    return context;
  }

  public static Boolean getPreferred(Address context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PREFERRED);
  }

  public static ContactPoint setPreferred(ContactPoint context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PREFERRED, new BooleanType(value));
    return context;
  }

  public static Boolean getPreferred(ContactPoint context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PREFERRED);
  }

  public static ExtendedContactDetail setPreferred(ExtendedContactDetail context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PREFERRED, new BooleanType(value));
    return context;
  }

  public static Boolean getPreferred(ExtendedContactDetail context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PREFERRED);
  }

// -- Uncertainty -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-uncertainty|0.1.0
// Uncertainty

  public static Extension makeUncertainty(float value) {
    return new Extension(ExtensionConstants.EXT_UNCERTAINTY).setValue(new DecimalType(value));
  }

  public static Quantity setUncertainty(Quantity context, float value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_UNCERTAINTY, new DecimalType(value));
    return context;
  }

  public static BigDecimal getUncertainty(Quantity context) {
    return ExtensionsUtils.getExtensionFloat(context, ExtensionConstants.EXT_UNCERTAINTY);
  }

// -- UncertaintyType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/iso21090-uncertaintyType|0.1.0
// Uncertainty type

  public static Extension makeUncertaintyType(String value) {
    return new Extension(ExtensionConstants.EXT_UNCERTAINTY_TYPE).setValue(new CodeType(value));
  }

  public static Quantity setUncertaintyType(Quantity context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_UNCERTAINTY_TYPE, new CodeType(value));
    return context;
  }

  public static String getUncertaintyType(Quantity context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_UNCERTAINTY_TYPE);
  }

// -- ItemWeight -------------------------------------
// http://hl7.org/fhir/StructureDefinition/itemWeight|0.1.0
// Item Weight

  public static Extension makeItemWeight(float value) {
    return new Extension(ExtensionConstants.EXT_ITEM_WEIGHT).setValue(new DecimalType(value));
  }

  public static Coding setItemWeight(Coding context, float value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ITEM_WEIGHT, new DecimalType(value));
    return context;
  }

  public static BigDecimal getItemWeight(Coding context) {
    return ExtensionsUtils.getExtensionFloat(context, ExtensionConstants.EXT_ITEM_WEIGHT);
  }

// -- HumanLanguage -------------------------------------
// http://hl7.org/fhir/StructureDefinition/language|0.1.0
// Human Language

  public static Extension makeHumanLanguage(String value) {
    return new Extension(ExtensionConstants.EXT_HUMAN_LANGUAGE).setValue(new CodeType(value));
  }

  public static Address setHumanLanguage(Address context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_HUMAN_LANGUAGE, new CodeType(value));
    return context;
  }

  public static String getHumanLanguage(Address context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_HUMAN_LANGUAGE);
  }

  public static Annotation setHumanLanguage(Annotation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_HUMAN_LANGUAGE, new CodeType(value));
    return context;
  }

  public static String getHumanLanguage(Annotation context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_HUMAN_LANGUAGE);
  }

  public static HumanName setHumanLanguage(HumanName context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_HUMAN_LANGUAGE, new CodeType(value));
    return context;
  }

  public static String getHumanLanguage(HumanName context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_HUMAN_LANGUAGE);
  }

  public static MarkdownType setHumanLanguage(MarkdownType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_HUMAN_LANGUAGE, new CodeType(value));
    return context;
  }

  public static String getHumanLanguage(MarkdownType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_HUMAN_LANGUAGE);
  }

  public static StringType setHumanLanguage(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_HUMAN_LANGUAGE, new CodeType(value));
    return context;
  }

  public static String getHumanLanguage(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_HUMAN_LANGUAGE);
  }

// -- LargeValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/largeValue|0.1.0
// Large Value

  public static Extension makeLargeValue(float value) {
    return new Extension(ExtensionConstants.EXT_LARGE_VALUE).setValue(new DecimalType(value));
  }

  public static IntegerType setLargeValue(IntegerType context, float value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LARGE_VALUE, new DecimalType(value));
    return context;
  }

  public static BigDecimal getLargeValue(IntegerType context) {
    return ExtensionsUtils.getExtensionFloat(context, ExtensionConstants.EXT_LARGE_VALUE);
  }

// -- LastSourceSync -------------------------------------
// http://hl7.org/fhir/StructureDefinition/lastSourceSync|0.1.0
// Last source sync

  public static Extension makeLastSourceSync(String value) {
    return new Extension(ExtensionConstants.EXT_LAST_SOURCE_SYNC).setValue(new DateTimeType(value));
  }

  public static Meta setLastSourceSync(Meta context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LAST_SOURCE_SYNC, new DateTimeType(value));
    return context;
  }

  public static String getLastSourceSync(Meta context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_LAST_SOURCE_SYNC);
  }

// -- ListCategory -------------------------------------
// http://hl7.org/fhir/StructureDefinition/list-category|0.1.0
// List Category

  public static Extension makeListCategory(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_LIST_CATEGORY).setValue(value);
  }

  public static ListResource setListCategory(ListResource context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LIST_CATEGORY, value);
    return context;
  }

  public static CodeableConcept getListCategory(ListResource context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_LIST_CATEGORY);
  }

// -- ListChangeBase -------------------------------------
// http://hl7.org/fhir/StructureDefinition/list-changeBase|0.1.0
// List Change Base

  public static Extension makeListChangeBase(Reference value) {
    return new Extension(ExtensionConstants.EXT_LIST_CHANGE_BASE).setValue(value);
  }

  public static ListResource setListChangeBase(ListResource context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LIST_CHANGE_BASE, value);
    return context;
  }

  public static Reference getListChangeBase(ListResource context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_LIST_CHANGE_BASE);
  }

// -- ListFor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/list-for|0.1.0
// List For Extension

  public static Extension makeListFor(Reference value) {
    return new Extension(ExtensionConstants.EXT_LIST_FOR).setValue(value);
  }

  public static ListResource addListFor(ListResource context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_LIST_FOR, value);
    return context;
  }

  public static List<Reference> getListForList(ListResource context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_LIST_FOR);
  }

// -- LocBoundaryGeojson -------------------------------------
// http://hl7.org/fhir/StructureDefinition/location-boundary-geojson|0.1.0
// Location Boundary (GeoJSON)

  public static Extension makeLocBoundaryGeojson(Attachment value) {
    return new Extension(ExtensionConstants.EXT_LOC_BOUNDARY_GEOJSON).setValue(value);
  }

  public static Location setLocBoundaryGeojson(Location context, Attachment value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LOC_BOUNDARY_GEOJSON, value);
    return context;
  }

  public static Attachment getLocBoundaryGeojson(Location context) {
    return ExtensionsUtils.getExtension(Attachment.class, context, ExtensionConstants.EXT_LOC_BOUNDARY_GEOJSON);
  }

// -- LocCommunication -------------------------------------
// http://hl7.org/fhir/StructureDefinition/location-communication|0.1.0
// Location Communication

  public static Extension makeLocCommunication(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_LOC_COMMUNICATION).setValue(value);
  }

  public static Location setLocCommunication(Location context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LOC_COMMUNICATION, value);
    return context;
  }

  public static CodeableConcept getLocCommunication(Location context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_LOC_COMMUNICATION);
  }

// -- BundleLocationDistance -------------------------------------
// http://hl7.org/fhir/StructureDefinition/location-distance|0.1.0
// Bundle Location Distance

  public static Extension makeBundleLocationDistance(Distance value) {
    return new Extension(ExtensionConstants.EXT_BUNDLE_LOCATION_DISTANCE).setValue(value);
  }

// -- BundleMatchGrade -------------------------------------
// http://hl7.org/fhir/StructureDefinition/match-grade|0.1.0
// Bundle Match Grade

  public static Extension makeBundleMatchGrade(String value) {
    return new Extension(ExtensionConstants.EXT_BUNDLE_MATCH_GRADE).setValue(new CodeType(value));
  }

// -- MaxDecimalPlaces -------------------------------------
// http://hl7.org/fhir/StructureDefinition/maxDecimalPlaces|0.1.0
// max decimal places

  public static Extension makeMaxDecimalPlaces(int value) {
    return new Extension(ExtensionConstants.EXT_MAX_DECIMAL_PLACES).setValue(new IntegerType(value));
  }

  public static ElementDefinition setMaxDecimalPlaces(ElementDefinition context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_DECIMAL_PLACES, new IntegerType(value));
    return context;
  }

  public static Integer getMaxDecimalPlaces(ElementDefinition context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_MAX_DECIMAL_PLACES);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setMaxDecimalPlaces(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_DECIMAL_PLACES, new IntegerType(value));
    return context;
  }

  public static Integer getMaxDecimalPlaces(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_MAX_DECIMAL_PLACES);
  }

// -- MaxSize -------------------------------------
// http://hl7.org/fhir/StructureDefinition/maxSize|0.1.0
// max size

  public static Extension makeMaxSize(float value) {
    return new Extension(ExtensionConstants.EXT_MAX_SIZE).setValue(new DecimalType(value));
  }

  public static ElementDefinition setMaxSize(ElementDefinition context, float value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_SIZE, new DecimalType(value));
    return context;
  }

  public static BigDecimal getMaxSize(ElementDefinition context) {
    return ExtensionsUtils.getExtensionFloat(context, ExtensionConstants.EXT_MAX_SIZE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setMaxSize(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, float value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_SIZE, new DecimalType(value));
    return context;
  }

  public static BigDecimal getMaxSize(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionFloat(context, ExtensionConstants.EXT_MAX_SIZE);
  }

// -- MaxValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/maxValue|0.1.0
// max value

  public static Extension makeMaxValue(DataType value) {
    return new Extension(ExtensionConstants.EXT_MAX_VALUE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setMaxValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, DataType value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MAX_VALUE, value);
    return context;
  }

  public static DataType getMaxValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtension(DataType.class, context, ExtensionConstants.EXT_MAX_VALUE);
  }

// -- MedQuantityRemaining -------------------------------------
// http://hl7.org/fhir/StructureDefinition/medicationdispense-quantityRemaining|0.1.0
// MedicationDispense Quantity Remaining

  public static Extension makeMedQuantityRemaining(Quantity value) {
    return new Extension(ExtensionConstants.EXT_MED_QUANTITY_REMAINING).setValue(value);
  }

  public static MedicationDispense setMedQuantityRemaining(MedicationDispense context, Quantity value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MED_QUANTITY_REMAINING, value);
    return context;
  }

  public static Quantity getMedQuantityRemaining(MedicationDispense context) {
    return ExtensionsUtils.getExtension(Quantity.class, context, ExtensionConstants.EXT_MED_QUANTITY_REMAINING);
  }

// -- MedRefillsRemaining -------------------------------------
// http://hl7.org/fhir/StructureDefinition/medicationdispense-refillsRemaining|0.1.0
// MedicationDispense Refills Remaining

  public static Extension makeMedRefillsRemaining(int value) {
    return new Extension(ExtensionConstants.EXT_MED_REFILLS_REMAINING).setValue(new IntegerType(value));
  }

  public static MedicationDispense setMedRefillsRemaining(MedicationDispense context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MED_REFILLS_REMAINING, new IntegerType(value));
    return context;
  }

  public static Integer getMedRefillsRemaining(MedicationDispense context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_MED_REFILLS_REMAINING);
  }

// -- MsgResponseRequest -------------------------------------
// http://hl7.org/fhir/StructureDefinition/messageheader-response-request|0.1.0
// MessageHeader Response Request

  public static Extension makeMsgResponseRequest(String value) {
    return new Extension(ExtensionConstants.EXT_MSG_RESPONSE_REQUEST).setValue(new CodeType(value));
  }

  public static MessageHeader setMsgResponseRequest(MessageHeader context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MSG_RESPONSE_REQUEST, new CodeType(value));
    return context;
  }

  public static String getMsgResponseRequest(MessageHeader context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_MSG_RESPONSE_REQUEST);
  }

// -- MimeType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/mimeType|0.1.0
// mime type

  public static Extension makeMimeType(String value) {
    return new Extension(ExtensionConstants.EXT_MIME_TYPE).setValue(new CodeType(value));
  }

  public static ElementDefinition addMimeType(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MIME_TYPE, new CodeType(value));
    return context;
  }

  public static List<String> getMimeTypeList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_MIME_TYPE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addMimeType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MIME_TYPE, new CodeType(value));
    return context;
  }

  public static List<String> getMimeTypeList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_MIME_TYPE);
  }

// -- MinLength -------------------------------------
// http://hl7.org/fhir/StructureDefinition/minLength|0.1.0
// min length

  public static Extension makeMinLength(int value) {
    return new Extension(ExtensionConstants.EXT_MIN_LENGTH).setValue(new IntegerType(value));
  }

  public static ElementDefinition setMinLength(ElementDefinition context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MIN_LENGTH, new IntegerType(value));
    return context;
  }

  public static Integer getMinLength(ElementDefinition context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_MIN_LENGTH);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setMinLength(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MIN_LENGTH, new IntegerType(value));
    return context;
  }

  public static Integer getMinLength(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_MIN_LENGTH);
  }

// -- MinValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/minValue|0.1.0
// min value

  public static Extension makeMinValue(DataType value) {
    return new Extension(ExtensionConstants.EXT_MIN_VALUE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setMinValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, DataType value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MIN_VALUE, value);
    return context;
  }

  public static DataType getMinValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtension(DataType.class, context, ExtensionConstants.EXT_MIN_VALUE);
  }

// -- NSCheckDigit -------------------------------------
// http://hl7.org/fhir/StructureDefinition/namingsystem-checkDigit|0.1.0
// NamingSystem Check Digit

  public static Extension makeNSCheckDigit(String value) {
    return new Extension(ExtensionConstants.EXT_NSCHECK_DIGIT).setValue(new StringType(value));
  }

  public static NamingSystem setNSCheckDigit(NamingSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NSCHECK_DIGIT, new StringType(value));
    return context;
  }

  public static String getNSCheckDigit(NamingSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NSCHECK_DIGIT);
  }

// -- NarrativeLink -------------------------------------
// http://hl7.org/fhir/StructureDefinition/narrativeLink|0.1.0
// Narrative Link

  public static Extension makeNarrativeLink(String value) {
    return new Extension(ExtensionConstants.EXT_NARRATIVE_LINK).setValue(new UrlType(value));
  }

  public static Element setNarrativeLink(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NARRATIVE_LINK, new UrlType(value));
    return context;
  }

  public static String getNarrativeLink(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NARRATIVE_LINK);
  }

// -- PatNoFixedAddress -------------------------------------
// http://hl7.org/fhir/StructureDefinition/no-fixed-address|0.1.0
// Patient No Fixed Address

  public static Extension makePatNoFixedAddress(boolean value) {
    return new Extension(ExtensionConstants.EXT_PAT_NO_FIXED_ADDRESS).setValue(new BooleanType(value));
  }

  public static Address setPatNoFixedAddress(Address context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_NO_FIXED_ADDRESS, new BooleanType(value));
    return context;
  }

  public static Boolean getPatNoFixedAddress(Address context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PAT_NO_FIXED_ADDRESS);
  }

// -- NttAdaptiveFeedingDevice -------------------------------------
// http://hl7.org/fhir/StructureDefinition/nutritionorder-adaptiveFeedingDevice|0.1.0
// NutritionOrder Adaptive Feeding Device

  public static Extension makeNttAdaptiveFeedingDevice(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_NTT_ADAPTIVE_FEEDING_DEVICE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent addNttAdaptiveFeedingDevice(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_NTT_ADAPTIVE_FEEDING_DEVICE, value);
    return context;
  }

  public static List<CodeableConcept> getNttAdaptiveFeedingDeviceList(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_NTT_ADAPTIVE_FEEDING_DEVICE);
  }

// -- ObsBodyPosition -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-bodyPosition|0.1.0
// Observation Body Position

  public static Extension makeObsBodyPosition(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_OBS_BODY_POSITION).setValue(value);
  }

  public static Observation setObsBodyPosition(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_BODY_POSITION, value);
    return context;
  }

  public static CodeableConcept getObsBodyPosition(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_BODY_POSITION);
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent setObsBodyPosition(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_BODY_POSITION, value);
    return context;
  }

  public static CodeableConcept getObsBodyPosition(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_BODY_POSITION);
  }

// -- ObsDelta -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-delta|0.1.0
// Observation Delta

  public static Extension makeObsDelta(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_OBS_DELTA).setValue(value);
  }

  public static Observation setObsDelta(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_DELTA, value);
    return context;
  }

  public static CodeableConcept getObsDelta(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_DELTA);
  }

// -- ObsDeviceCode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-deviceCode|0.1.0
// Observation Device Code

  public static Extension makeObsDeviceCode(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_OBS_DEVICE_CODE).setValue(value);
  }

  public static Observation setObsDeviceCode(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_DEVICE_CODE, value);
    return context;
  }

  public static CodeableConcept getObsDeviceCode(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_DEVICE_CODE);
  }

// -- ObsFocusCode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-focusCode|0.1.0
// Observation Focal Subject Code

  public static Extension makeObsFocusCode(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_OBS_FOCUS_CODE).setValue(value);
  }

  public static Observation setObsFocusCode(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_FOCUS_CODE, value);
    return context;
  }

  public static CodeableConcept getObsFocusCode(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_FOCUS_CODE);
  }

// -- ObsGatewayDevice -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-gatewayDevice|0.1.0
// Observation Gateway Device

  public static Extension makeObsGatewayDevice(Reference value) {
    return new Extension(ExtensionConstants.EXT_OBS_GATEWAY_DEVICE).setValue(value);
  }

  public static Observation setObsGatewayDevice(Observation context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_GATEWAY_DEVICE, value);
    return context;
  }

  public static Reference getObsGatewayDevice(Observation context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_OBS_GATEWAY_DEVICE);
  }

// -- ObsPrecondition -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-precondition|0.1.0
// Observation Precondition

  public static Extension makeObsPrecondition(Reference value) {
    return new Extension(ExtensionConstants.EXT_OBS_PRECONDITION).setValue(value);
  }

  public static Observation addObsPrecondition(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_OBS_PRECONDITION, value);
    return context;
  }

  public static List<Reference> getObsPreconditionList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_OBS_PRECONDITION);
  }

// -- ObsReagent -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-reagent|0.1.0
// Observation Reagent

  public static Extension makeObsReagent(Reference value) {
    return new Extension(ExtensionConstants.EXT_OBS_REAGENT).setValue(value);
  }

  public static Observation addObsReagent(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_OBS_REAGENT, value);
    return context;
  }

  public static List<Reference> getObsReagentList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_OBS_REAGENT);
  }

// -- ObsReplaces -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-replaces|0.1.0
// Observation Replaces

  public static Extension makeObsReplaces(Reference value) {
    return new Extension(ExtensionConstants.EXT_OBS_REPLACES).setValue(value);
  }

  public static Observation addObsReplaces(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_OBS_REPLACES, value);
    return context;
  }

  public static List<Reference> getObsReplacesList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_OBS_REPLACES);
  }

// -- ObsSecondaryFinding -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-secondaryFinding|0.1.0
// Observation Secondary Finding

  public static Extension makeObsSecondaryFinding(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_OBS_SECONDARY_FINDING).setValue(value);
  }

  public static Observation setObsSecondaryFinding(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_SECONDARY_FINDING, value);
    return context;
  }

  public static CodeableConcept getObsSecondaryFinding(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_SECONDARY_FINDING);
  }

// -- ObsSequelTo -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-sequelTo|0.1.0
// Observation Sequel To

  public static Extension makeObsSequelTo(Reference value) {
    return new Extension(ExtensionConstants.EXT_OBS_SEQUEL_TO).setValue(value);
  }

  public static Observation addObsSequelTo(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_OBS_SEQUEL_TO, value);
    return context;
  }

  public static List<Reference> getObsSequelToList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_OBS_SEQUEL_TO);
  }

// -- ObsSpecimenCode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-specimenCode|0.1.0
// Observation Specimen Code

  public static Extension makeObsSpecimenCode(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_OBS_SPECIMEN_CODE).setValue(value);
  }

  public static Observation setObsSpecimenCode(Observation context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OBS_SPECIMEN_CODE, value);
    return context;
  }

  public static CodeableConcept getObsSpecimenCode(Observation context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_OBS_SPECIMEN_CODE);
  }

// -- ObsTimeOffset -------------------------------------
// http://hl7.org/fhir/StructureDefinition/observation-timeOffset|0.1.0
// Observation Time Offset

  public static Extension makeObsTimeOffset(int value) {
    return new Extension(ExtensionConstants.EXT_OBS_TIME_OFFSET).setValue(new IntegerType(value));
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationComponentComponent addObsTimeOffset(org.hl7.fhir.r5.model.Observation.ObservationComponentComponent context, int value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_OBS_TIME_OFFSET, new IntegerType(value));
    return context;
  }

  public static List<Integer> getObsTimeOffsetList(org.hl7.fhir.r5.model.Observation.ObservationComponentComponent context) {
    return ExtensionsUtils.getExtensionIntList(context, ExtensionConstants.EXT_OBS_TIME_OFFSET);
  }

// -- AIAdministration -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-administration|0.1.0
// AllergyIntolerance Administration

  public static Extension makeAIAdministration(Reference value) {
    return new Extension(ExtensionConstants.EXT_AIADMINISTRATION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAIAdministration(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIADMINISTRATION, value);
    return context;
  }

  public static Reference getAIAdministration(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_AIADMINISTRATION);
  }

// -- AICareplan -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-careplan|0.1.0
// AllergyIntolerance Careplan

  public static Extension makeAICareplan(Reference value) {
    return new Extension(ExtensionConstants.EXT_AICAREPLAN).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAICareplan(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AICAREPLAN, value);
    return context;
  }

  public static Reference getAICareplan(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_AICAREPLAN);
  }

// -- AIExposureDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-exposureDate|0.1.0
// AllergyIntolerance Exposure Date

  public static Extension makeAIExposureDate(String value) {
    return new Extension(ExtensionConstants.EXT_AIEXPOSURE_DATE).setValue(new DateTimeType(value));
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAIExposureDate(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIEXPOSURE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getAIExposureDate(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_AIEXPOSURE_DATE);
  }

// -- AIExposureDescription -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-exposureDescription|0.1.0
// AllergyIntolerance ExposureDescription

  public static Extension makeAIExposureDescription(String value) {
    return new Extension(ExtensionConstants.EXT_AIEXPOSURE_DESCRIPTION).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAIExposureDescription(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIEXPOSURE_DESCRIPTION, new StringType(value));
    return context;
  }

  public static String getAIExposureDescription(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_AIEXPOSURE_DESCRIPTION);
  }

// -- AIExposureDuration -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-exposureDuration|0.1.0
// AllergyIntolerance Exposure Duration

  public static Extension makeAIExposureDuration(Duration value) {
    return new Extension(ExtensionConstants.EXT_AIEXPOSURE_DURATION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAIExposureDuration(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, Duration value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIEXPOSURE_DURATION, value);
    return context;
  }

  public static Duration getAIExposureDuration(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtension(Duration.class, context, ExtensionConstants.EXT_AIEXPOSURE_DURATION);
  }

// -- AILocation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-location|0.1.0
// AllergyIntolerance Location

  public static Extension makeAILocation(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_AILOCATION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent addAILocation(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_AILOCATION, value);
    return context;
  }

  public static List<CodeableConcept> getAILocationList(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_AILOCATION);
  }

// -- AIManagement -------------------------------------
// http://hl7.org/fhir/StructureDefinition/openEHR-management|0.1.0
// AllergyIntolerance Management

  public static Extension makeAIManagement(String value) {
    return new Extension(ExtensionConstants.EXT_AIMANAGEMENT).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent setAIManagement(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_AIMANAGEMENT, new StringType(value));
    return context;
  }

  public static String getAIManagement(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_AIMANAGEMENT);
  }

// -- ODProfile -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationdefinition-profile|0.1.0
// OperationDefinition Profile

  public static Extension makeODProfile(String value) {
    return new Extension(ExtensionConstants.EXT_ODPROFILE).setValue(new UriType(value));
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent addODProfile(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ODPROFILE, new UriType(value));
    return context;
  }

  public static List<String> getODProfileList(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ODPROFILE);
  }

// -- OOAuthority -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-authority|0.1.0
// OperationOutcome Authority for Rule

  public static Extension makeOOAuthority(String value) {
    return new Extension(ExtensionConstants.EXT_OOAUTHORITY).setValue(new UriType(value));
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOOAuthority(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OOAUTHORITY, new UriType(value));
    return context;
  }

  public static String getOOAuthority(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OOAUTHORITY);
  }

// -- OODetectedIssue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-detectedIssue|0.1.0
// OperationOutcome Detected Clinical Issue

  public static Extension makeOODetectedIssue(Reference value) {
    return new Extension(ExtensionConstants.EXT_OODETECTED_ISSUE).setValue(value);
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOODetectedIssue(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OODETECTED_ISSUE, value);
    return context;
  }

  public static Reference getOODetectedIssue(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_OODETECTED_ISSUE);
  }

// -- OOSourceFile -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-file|0.1.0
// OperationOutcome Source File

  public static Extension makeOOSourceFile(String value) {
    return new Extension(ExtensionConstants.EXT_OOSOURCE_FILE).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOOSourceFile(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OOSOURCE_FILE, new StringType(value));
    return context;
  }

  public static String getOOSourceFile(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OOSOURCE_FILE);
  }

// -- OOIssueCol -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col|0.1.0
// OperationOutcome Column of Issue

  public static Extension makeOOIssueCol(String value) {
    return new Extension(ExtensionConstants.EXT_OOISSUE_COL).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOOIssueCol(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OOISSUE_COL, new StringType(value));
    return context;
  }

  public static String getOOIssueCol(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OOISSUE_COL);
  }

// -- OOIssueline -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line|0.1.0
// OperationOutcome Line of Issue

  public static Extension makeOOIssueline(String value) {
    return new Extension(ExtensionConstants.EXT_OOISSUELINE).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOOIssueline(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OOISSUELINE, new StringType(value));
    return context;
  }

  public static String getOOIssueline(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OOISSUELINE);
  }

// -- OOIssuesource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source|0.1.0
// OperationOutcome Source of Issue

  public static Extension makeOOIssuesource(String value) {
    return new Extension(ExtensionConstants.EXT_OOISSUESOURCE).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOOIssuesource(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OOISSUESOURCE, new StringType(value));
    return context;
  }

  public static String getOOIssuesource(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OOISSUESOURCE);
  }

// -- OOIssueSource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id|0.1.0
// OperationOutcome Source of Issue

  public static Extension makeOOIssueSource(String value) {
    return new Extension(ExtensionConstants.EXT_OOISSUE_SOURCE).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent setOOIssueSource(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_OOISSUE_SOURCE, new StringType(value));
    return context;
  }

  public static String getOOIssueSource(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_OOISSUE_SOURCE);
  }

// -- OrgPeriod -------------------------------------
// http://hl7.org/fhir/StructureDefinition/organization-period|0.1.0
// Organization Period

  public static Extension makeOrgPeriod(Period value) {
    return new Extension(ExtensionConstants.EXT_ORG_PERIOD).setValue(value);
  }

  public static Organization setOrgPeriod(Organization context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ORG_PERIOD, value);
    return context;
  }

  public static Period getOrgPeriod(Organization context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_ORG_PERIOD);
  }

// -- OrgPreferredContact -------------------------------------
// http://hl7.org/fhir/StructureDefinition/organization-preferredContact|0.1.0
// Organization Preferred Contact

  public static Extension makeOrgPreferredContact(boolean value) {
    return new Extension(ExtensionConstants.EXT_ORG_PREFERRED_CONTACT).setValue(new BooleanType(value));
  }

  public static ExtendedContactDetail setOrgPreferredContact(ExtendedContactDetail context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ORG_PREFERRED_CONTACT, new BooleanType(value));
    return context;
  }

  public static Boolean getOrgPreferredContact(ExtendedContactDetail context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_ORG_PREFERRED_CONTACT);
  }

// -- OrgPrimaryInd -------------------------------------
// http://hl7.org/fhir/StructureDefinition/organizationaffiliation-primaryInd|0.1.0
// Organization Primary Indicator

  public static Extension makeOrgPrimaryInd(boolean value) {
    return new Extension(ExtensionConstants.EXT_ORG_PRIMARY_IND).setValue(new BooleanType(value));
  }

  public static CodeableConcept setOrgPrimaryInd(CodeableConcept context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ORG_PRIMARY_IND, new BooleanType(value));
    return context;
  }

  public static Boolean getOrgPrimaryInd(CodeableConcept context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_ORG_PRIMARY_IND);
  }

// -- OriginalText -------------------------------------
// http://hl7.org/fhir/StructureDefinition/originalText|0.1.0
// Original Text

  public static Extension makeOriginalTextString(String value) {
    return new Extension(ExtensionConstants.EXT_ORIGINAL_TEXT).setValue(new StringType(value));
  }

  public static Extension makeOriginalTextUrl(String value) {
    return new Extension(ExtensionConstants.EXT_ORIGINAL_TEXT).setValue(new UrlType(value));
  }

  public static Element setOriginalTextString(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ORIGINAL_TEXT, new StringType(value));
    return context;
  }

  public static String getOriginalTextString(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_ORIGINAL_TEXT);
  }

  public static Element setOriginalTextUrl(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_ORIGINAL_TEXT, new UrlType(value));
    return context;
  }

// -- ParametersDefinition -------------------------------------
// http://hl7.org/fhir/StructureDefinition/parameters-definition|0.1.0
// Parameters Definition for parameter

  public static Extension makeParametersDefinition(ParameterDefinition value) {
    return new Extension(ExtensionConstants.EXT_PARAMETERS_DEFINITION).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent setParametersDefinition(org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent context, ParameterDefinition value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PARAMETERS_DEFINITION, value);
    return context;
  }

  public static ParameterDefinition getParametersDefinition(org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent context) {
    return ExtensionsUtils.getExtension(ParameterDefinition.class, context, ExtensionConstants.EXT_PARAMETERS_DEFINITION);
  }

// -- ParamFullUrl -------------------------------------
// http://hl7.org/fhir/StructureDefinition/parameters-fullUrl|0.1.0
// Parameters FullUrl for resource

  public static Extension makeParamFullUrl(String value) {
    return new Extension(ExtensionConstants.EXT_PARAM_FULL_URL).setValue(new UriType(value));
  }

  public static org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent setParamFullUrl(org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PARAM_FULL_URL, new UriType(value));
    return context;
  }

  public static String getParamFullUrl(org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PARAM_FULL_URL);
  }

// -- PatAdoptionInfo -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-adoptionInfo|0.1.0
// Patient Adoption Info

  public static Extension makePatAdoptionInfo(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PAT_ADOPTION_INFO).setValue(value);
  }

  public static Patient setPatAdoptionInfo(Patient context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_ADOPTION_INFO, value);
    return context;
  }

  public static CodeableConcept getPatAdoptionInfo(Patient context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PAT_ADOPTION_INFO);
  }

// -- PatBirthPlace -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-birthPlace|0.1.0
// Patient Birth Place

  public static Extension makePatBirthPlace(Address value) {
    return new Extension(ExtensionConstants.EXT_PAT_BIRTH_PLACE).setValue(value);
  }

  public static Patient setPatBirthPlace(Patient context, Address value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_BIRTH_PLACE, value);
    return context;
  }

  public static Address getPatBirthPlace(Patient context) {
    return ExtensionsUtils.getExtension(Address.class, context, ExtensionConstants.EXT_PAT_BIRTH_PLACE);
  }

// -- PatBirthTime -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-birthTime|0.1.0
// Patient Birth Time

  public static Extension makePatBirthTime(String value) {
    return new Extension(ExtensionConstants.EXT_PAT_BIRTH_TIME).setValue(new DateTimeType(value));
  }

  public static DateType setPatBirthTime(DateType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_BIRTH_TIME, new DateTimeType(value));
    return context;
  }

  public static String getPatBirthTime(DateType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PAT_BIRTH_TIME);
  }

// -- PatCadavericDonor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-cadavericDonor|0.1.0
// Patient Is-Cadaveric Donor

  public static Extension makePatCadavericDonor(boolean value) {
    return new Extension(ExtensionConstants.EXT_PAT_CADAVERIC_DONOR).setValue(new BooleanType(value));
  }

  public static Patient setPatCadavericDonor(Patient context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_CADAVERIC_DONOR, new BooleanType(value));
    return context;
  }

  public static Boolean getPatCadavericDonor(Patient context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PAT_CADAVERIC_DONOR);
  }

// -- PatCongregation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-congregation|0.1.0
// Patient Congregation

  public static Extension makePatCongregation(String value) {
    return new Extension(ExtensionConstants.EXT_PAT_CONGREGATION).setValue(new StringType(value));
  }

  public static Patient setPatCongregation(Patient context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_CONGREGATION, new StringType(value));
    return context;
  }

  public static String getPatCongregation(Patient context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PAT_CONGREGATION);
  }

// -- PatDisability -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-disability|0.1.0
// Patient Disability

  public static Extension makePatDisability(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PAT_DISABILITY).setValue(value);
  }

  public static Patient addPatDisability(Patient context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PAT_DISABILITY, value);
    return context;
  }

  public static List<CodeableConcept> getPatDisabilityList(Patient context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_PAT_DISABILITY);
  }

// -- PatImportance -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-importance|0.1.0
// Patient Importance

  public static Extension makePatImportance(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PAT_IMPORTANCE).setValue(value);
  }

  public static Patient setPatImportance(Patient context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_IMPORTANCE, value);
    return context;
  }

  public static CodeableConcept getPatImportance(Patient context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PAT_IMPORTANCE);
  }

// -- PatInterpreterRequired -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-interpreterRequired|0.1.0
// Patient Interpreter Required

  public static Extension makePatInterpreterRequired(boolean value) {
    return new Extension(ExtensionConstants.EXT_PAT_INTERPRETER_REQUIRED).setValue(new BooleanType(value));
  }

  public static Patient setPatInterpreterRequired(Patient context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_INTERPRETER_REQUIRED, new BooleanType(value));
    return context;
  }

  public static Boolean getPatInterpreterRequired(Patient context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PAT_INTERPRETER_REQUIRED);
  }

// -- PatMothersMaidenName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-mothersMaidenName|0.1.0
// Patient Mother's Maiden Name

  public static Extension makePatMothersMaidenName(String value) {
    return new Extension(ExtensionConstants.EXT_PAT_MOTHERS_MAIDEN_NAME).setValue(new StringType(value));
  }

  public static Patient setPatMothersMaidenName(Patient context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_MOTHERS_MAIDEN_NAME, new StringType(value));
    return context;
  }

  public static String getPatMothersMaidenName(Patient context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PAT_MOTHERS_MAIDEN_NAME);
  }

// -- PatMultipleBirthTotal -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-multipleBirthTotal|0.1.0
// Patient Multiple Birth Total

  public static Extension makePatMultipleBirthTotal(int value) {
    return new Extension(ExtensionConstants.EXT_PAT_MULTIPLE_BIRTH_TOTAL).setValue(new PositiveIntType(value));
  }

  public static DataType setPatMultipleBirthTotal(DataType context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PAT_MULTIPLE_BIRTH_TOTAL, new PositiveIntType(value));
    return context;
  }

  public static Integer getPatMultipleBirthTotal(DataType context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_PAT_MULTIPLE_BIRTH_TOTAL);
  }

// -- PatPreferenceType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-preferenceType|0.1.0
// Patient Preference Type

  public static Extension makePatPreferenceType(Coding value) {
    return new Extension(ExtensionConstants.EXT_PAT_PREFERENCE_TYPE).setValue(value);
  }

// -- PatRelatedPerson -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-relatedPerson|0.1.0
// Patient Related Person

  public static Extension makePatRelatedPerson(Reference value) {
    return new Extension(ExtensionConstants.EXT_PAT_RELATED_PERSON).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Patient.ContactComponent addPatRelatedPerson(org.hl7.fhir.r5.model.Patient.ContactComponent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PAT_RELATED_PERSON, value);
    return context;
  }

  public static List<Reference> getPatRelatedPersonList(org.hl7.fhir.r5.model.Patient.ContactComponent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PAT_RELATED_PERSON);
  }

// -- PatReligion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/patient-religion|0.1.0
// Patient Religion

  public static Extension makePatReligion(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PAT_RELIGION).setValue(value);
  }

  public static Patient addPatReligion(Patient context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PAT_RELIGION, value);
    return context;
  }

  public static List<CodeableConcept> getPatReligionList(Patient context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_PAT_RELIGION);
  }

// -- PRAnimalSpecies -------------------------------------
// http://hl7.org/fhir/StructureDefinition/practitioner-animalSpecies|0.1.0
// Practitioner Animal Species

  public static Extension makePRAnimalSpecies(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PRANIMAL_SPECIES).setValue(value);
  }

  public static Practitioner setPRAnimalSpecies(Practitioner context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRANIMAL_SPECIES, value);
    return context;
  }

  public static CodeableConcept getPRAnimalSpecies(Practitioner context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRANIMAL_SPECIES);
  }

  public static RelatedPerson setPRAnimalSpecies(RelatedPerson context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRANIMAL_SPECIES, value);
    return context;
  }

  public static CodeableConcept getPRAnimalSpecies(RelatedPerson context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRANIMAL_SPECIES);
  }

// -- PRJobTitle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/practitioner-job-title|0.1.0
// Practitioner Job title

  public static Extension makePRJobTitle(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PRJOB_TITLE).setValue(value);
  }

  public static Practitioner setPRJobTitle(Practitioner context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRJOB_TITLE, value);
    return context;
  }

  public static CodeableConcept getPRJobTitle(Practitioner context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRJOB_TITLE);
  }

  public static PractitionerRole setPRJobTitle(PractitionerRole context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRJOB_TITLE, value);
    return context;
  }

  public static CodeableConcept getPRJobTitle(PractitionerRole context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRJOB_TITLE);
  }

// -- PRPrimaryInd -------------------------------------
// http://hl7.org/fhir/StructureDefinition/practitionerrole-primaryInd|0.1.0
// PractitionerRole Primary Indicator

  public static Extension makePRPrimaryInd(boolean value) {
    return new Extension(ExtensionConstants.EXT_PRPRIMARY_IND).setValue(new BooleanType(value));
  }

  public static CodeableConcept setPRPrimaryInd(CodeableConcept context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRPRIMARY_IND, new BooleanType(value));
    return context;
  }

  public static Boolean getPRPrimaryInd(CodeableConcept context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_PRPRIMARY_IND);
  }

// -- PRApproachBodyStructure -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-approachBodyStructure|0.1.0
// Procedure Approach Body Structure

  public static Extension makePRApproachBodyStructure(Reference value) {
    return new Extension(ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE).setValue(value);
  }

  public static DeviceRequest addPRApproachBodyStructure(DeviceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE, value);
    return context;
  }

  public static List<Reference> getPRApproachBodyStructureList(DeviceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE);
  }

  public static DeviceUsage addPRApproachBodyStructure(DeviceUsage context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE, value);
    return context;
  }

  public static List<Reference> getPRApproachBodyStructureList(DeviceUsage context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE);
  }

  public static Procedure addPRApproachBodyStructure(Procedure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE, value);
    return context;
  }

  public static List<Reference> getPRApproachBodyStructureList(Procedure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE);
  }

  public static ServiceRequest addPRApproachBodyStructure(ServiceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE, value);
    return context;
  }

  public static List<Reference> getPRApproachBodyStructureList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRAPPROACH_BODY_STRUCTURE);
  }

// -- PRCausedBy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-causedBy|0.1.0
// Procedure Caused By

  public static Extension makePRCausedBy(Reference value) {
    return new Extension(ExtensionConstants.EXT_PRCAUSED_BY).setValue(value);
  }

  public static Procedure addPRCausedBy(Procedure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRCAUSED_BY, value);
    return context;
  }

  public static List<Reference> getPRCausedByList(Procedure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRCAUSED_BY);
  }

// -- PRDirectedBy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-directedBy|0.1.0
// Procedure Directed By

  public static Extension makePRDirectedBy(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PRDIRECTED_BY).setValue(value);
  }

  public static Extension makePRDirectedBy(Reference value) {
    return new Extension(ExtensionConstants.EXT_PRDIRECTED_BY).setValue(value);
  }

  public static Procedure setPRDirectedBy(Procedure context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRDIRECTED_BY, value);
    return context;
  }

  public static CodeableConcept getPRDirectedByCodeableConcept(Procedure context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRDIRECTED_BY);
  }

  public static Procedure setPRDirectedBy(Procedure context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRDIRECTED_BY, value);
    return context;
  }

  public static Reference getPRDirectedByReference(Procedure context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_PRDIRECTED_BY);
  }

  public static ServiceRequest setPRDirectedBy(ServiceRequest context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRDIRECTED_BY, value);
    return context;
  }

  public static CodeableConcept getPRDirectedByCodeableConcept(ServiceRequest context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRDIRECTED_BY);
  }

  public static ServiceRequest setPRDirectedBy(ServiceRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRDIRECTED_BY, value);
    return context;
  }

  public static Reference getPRDirectedByReference(ServiceRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_PRDIRECTED_BY);
  }

// -- PRIncisionDateTime -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-incisionDateTime|0.1.0
// Procedure Incision DateTime

  public static Extension makePRIncisionDateTime(String value) {
    return new Extension(ExtensionConstants.EXT_PRINCISION_DATE_TIME).setValue(new DateTimeType(value));
  }

  public static Procedure setPRIncisionDateTime(Procedure context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRINCISION_DATE_TIME, new DateTimeType(value));
    return context;
  }

  public static String getPRIncisionDateTime(Procedure context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_PRINCISION_DATE_TIME);
  }

// -- PRMethod -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-method|0.1.0
// Procedure Method

  public static Extension makePRMethod(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PRMETHOD).setValue(value);
  }

  public static Procedure addPRMethod(Procedure context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRMETHOD, value);
    return context;
  }

  public static List<CodeableConcept> getPRMethodList(Procedure context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_PRMETHOD);
  }

// -- PRProgressStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-progressStatus|0.1.0
// Procedure Progress Status

  public static Extension makePRProgressStatus(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_PRPROGRESS_STATUS).setValue(value);
  }

  public static Procedure setPRProgressStatus(Procedure context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRPROGRESS_STATUS, value);
    return context;
  }

  public static CodeableConcept getPRProgressStatus(Procedure context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_PRPROGRESS_STATUS);
  }

// -- PRTargetBodyStructure -------------------------------------
// http://hl7.org/fhir/StructureDefinition/procedure-targetBodyStructure|0.1.0
// Procedure Target Body Structure

  public static Extension makePRTargetBodyStructure(Reference value) {
    return new Extension(ExtensionConstants.EXT_PRTARGET_BODY_STRUCTURE).setValue(value);
  }

  public static Procedure addPRTargetBodyStructure(Procedure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRTARGET_BODY_STRUCTURE, value);
    return context;
  }

  public static List<Reference> getPRTargetBodyStructureList(Procedure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRTARGET_BODY_STRUCTURE);
  }

  public static ServiceRequest addPRTargetBodyStructure(ServiceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PRTARGET_BODY_STRUCTURE, value);
    return context;
  }

  public static List<Reference> getPRTargetBodyStructureList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_PRTARGET_BODY_STRUCTURE);
  }

// -- Precision -------------------------------------
// http://hl7.org/fhir/StructureDefinition/quantity-precision|0.1.0
// Precision

  public static Extension makePrecision(int value) {
    return new Extension(ExtensionConstants.EXT_PRECISION).setValue(new IntegerType(value));
  }

  public static DecimalType setPrecision(DecimalType context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PRECISION, new IntegerType(value));
    return context;
  }

  public static Integer getPrecision(DecimalType context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_PRECISION);
  }

// -- QBaseType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-baseType|0.1.0
// Questionnaire Base Type

  public static Extension makeQBaseType(String value) {
    return new Extension(ExtensionConstants.EXT_QBASE_TYPE).setValue(new CodeType(value));
  }

  public static ElementDefinition setQBaseType(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QBASE_TYPE, new CodeType(value));
    return context;
  }

  public static String getQBaseType(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QBASE_TYPE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQBaseType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QBASE_TYPE, new CodeType(value));
    return context;
  }

  public static String getQBaseType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QBASE_TYPE);
  }

// -- QChoiceOrientation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-choiceOrientation|0.1.0
// Questionnaire ChoiceOrientation

  public static Extension makeQChoiceOrientation(String value) {
    return new Extension(ExtensionConstants.EXT_QCHOICE_ORIENTATION).setValue(new CodeType(value));
  }

  public static ElementDefinition setQChoiceOrientation(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QCHOICE_ORIENTATION, new CodeType(value));
    return context;
  }

  public static String getQChoiceOrientation(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QCHOICE_ORIENTATION);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQChoiceOrientation(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QCHOICE_ORIENTATION, new CodeType(value));
    return context;
  }

  public static String getQChoiceOrientation(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QCHOICE_ORIENTATION);
  }

// -- QDefinitionBased -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-definitionBased|0.1.0
// Questionnaire is Definition Based

  public static Extension makeQDefinitionBased(boolean value) {
    return new Extension(ExtensionConstants.EXT_QDEFINITION_BASED).setValue(new BooleanType(value));
  }

  public static Questionnaire setQDefinitionBased(Questionnaire context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QDEFINITION_BASED, new BooleanType(value));
    return context;
  }

  public static Boolean getQDefinitionBased(Questionnaire context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_QDEFINITION_BASED);
  }

// -- QDisplayCategory -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-displayCategory|0.1.0
// Questionnaire Display Category

  public static Extension makeQDisplayCategory(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_QDISPLAY_CATEGORY).setValue(value);
  }

  public static ElementDefinition setQDisplayCategory(ElementDefinition context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QDISPLAY_CATEGORY, value);
    return context;
  }

  public static CodeableConcept getQDisplayCategory(ElementDefinition context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_QDISPLAY_CATEGORY);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQDisplayCategory(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QDISPLAY_CATEGORY, value);
    return context;
  }

  public static CodeableConcept getQDisplayCategory(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_QDISPLAY_CATEGORY);
  }

// -- QFhirType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-fhirType|0.1.0
// Questionnaire FHIR Type

  public static Extension makeQFhirType(String value) {
    return new Extension(ExtensionConstants.EXT_QFHIR_TYPE).setValue(new StringType(value));
  }

  public static ElementDefinition setQFhirType(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QFHIR_TYPE, new StringType(value));
    return context;
  }

  public static String getQFhirType(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QFHIR_TYPE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQFhirType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QFHIR_TYPE, new StringType(value));
    return context;
  }

  public static String getQFhirType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QFHIR_TYPE);
  }

// -- QHidden -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-hidden|0.1.0
// Questionnaire Hidden

  public static Extension makeQHidden(boolean value) {
    return new Extension(ExtensionConstants.EXT_QHIDDEN).setValue(new BooleanType(value));
  }

  public static ElementDefinition setQHidden(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QHIDDEN, new BooleanType(value));
    return context;
  }

  public static Boolean getQHidden(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_QHIDDEN);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQHidden(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QHIDDEN, new BooleanType(value));
    return context;
  }

  public static Boolean getQHidden(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_QHIDDEN);
  }

// -- QItemControl -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-itemControl|0.1.0
// Questionnaire Item Control

  public static Extension makeQItemControl(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_QITEM_CONTROL).setValue(value);
  }

  public static ElementDefinition setQItemControl(ElementDefinition context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QITEM_CONTROL, value);
    return context;
  }

  public static CodeableConcept getQItemControl(ElementDefinition context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_QITEM_CONTROL);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQItemControl(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QITEM_CONTROL, value);
    return context;
  }

  public static CodeableConcept getQItemControl(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_QITEM_CONTROL);
  }

// -- QMaxOccurs -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-maxOccurs|0.1.0
// Questionnaire Max Occurs

  public static Extension makeQMaxOccurs(int value) {
    return new Extension(ExtensionConstants.EXT_QMAX_OCCURS).setValue(new IntegerType(value));
  }

  public static ElementDefinition setQMaxOccurs(ElementDefinition context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QMAX_OCCURS, new IntegerType(value));
    return context;
  }

  public static Integer getQMaxOccurs(ElementDefinition context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_QMAX_OCCURS);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQMaxOccurs(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QMAX_OCCURS, new IntegerType(value));
    return context;
  }

  public static Integer getQMaxOccurs(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_QMAX_OCCURS);
  }

// -- QMinOccurs -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-minOccurs|0.1.0
// Questionnaire Min Occurs

  public static Extension makeQMinOccurs(int value) {
    return new Extension(ExtensionConstants.EXT_QMIN_OCCURS).setValue(new IntegerType(value));
  }

  public static ElementDefinition setQMinOccurs(ElementDefinition context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QMIN_OCCURS, new IntegerType(value));
    return context;
  }

  public static Integer getQMinOccurs(ElementDefinition context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_QMIN_OCCURS);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQMinOccurs(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QMIN_OCCURS, new IntegerType(value));
    return context;
  }

  public static Integer getQMinOccurs(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_QMIN_OCCURS);
  }

// -- QOptionExclusive -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-optionExclusive|0.1.0
// Questionnaire Option Exclusive

  public static Extension makeQOptionExclusive(boolean value) {
    return new Extension(ExtensionConstants.EXT_QOPTION_EXCLUSIVE).setValue(new BooleanType(value));
  }

// -- QOptionPrefix -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-optionPrefix|0.1.0
// Questionnaire Option Prefix

  public static Extension makeQOptionPrefix(String value) {
    return new Extension(ExtensionConstants.EXT_QOPTION_PREFIX).setValue(new StringType(value));
  }

// -- QOptionRestriction -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-optionRestriction|0.1.0
// Questionnaire Option Restriction

  public static Extension makeQOptionRestriction(DataType value) {
    return new Extension(ExtensionConstants.EXT_QOPTION_RESTRICTION).setValue(value);
  }

  public static ElementDefinition addQOptionRestriction(ElementDefinition context, DataType value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QOPTION_RESTRICTION, value);
    return context;
  }

  public static List<DataType> getQOptionRestrictionList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionList(DataType.class, context, ExtensionConstants.EXT_QOPTION_RESTRICTION);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addQOptionRestriction(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, DataType value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QOPTION_RESTRICTION, value);
    return context;
  }

  public static List<DataType> getQOptionRestrictionList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionList(DataType.class, context, ExtensionConstants.EXT_QOPTION_RESTRICTION);
  }

// -- ReferenceFilter -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-referenceFilter|0.1.0
// referenceFilter

  public static Extension makeReferenceFilter(String value) {
    return new Extension(ExtensionConstants.EXT_REFERENCE_FILTER).setValue(new StringType(value));
  }

  public static ElementDefinition setReferenceFilter(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_REFERENCE_FILTER, new StringType(value));
    return context;
  }

  public static String getReferenceFilter(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_REFERENCE_FILTER);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setReferenceFilter(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_REFERENCE_FILTER, new StringType(value));
    return context;
  }

  public static String getReferenceFilter(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_REFERENCE_FILTER);
  }

// -- QReferenceProfile -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-referenceProfile|0.1.0
// Questionnaire Reference Profile

  public static Extension makeQReferenceProfile(String value) {
    return new Extension(ExtensionConstants.EXT_QREFERENCE_PROFILE).setValue(new CanonicalType(value));
  }

  public static ElementDefinition addQReferenceProfile(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QREFERENCE_PROFILE, new CanonicalType(value));
    return context;
  }

  public static List<String> getQReferenceProfileList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QREFERENCE_PROFILE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addQReferenceProfile(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QREFERENCE_PROFILE, new CanonicalType(value));
    return context;
  }

  public static List<String> getQReferenceProfileList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QREFERENCE_PROFILE);
  }

// -- QReferenceResource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-referenceResource|0.1.0
// Questionnaire Reference Resource

  public static Extension makeQReferenceResource(String value) {
    return new Extension(ExtensionConstants.EXT_QREFERENCE_RESOURCE).setValue(new CodeType(value));
  }

  public static ElementDefinition addQReferenceResource(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QREFERENCE_RESOURCE, new CodeType(value));
    return context;
  }

  public static List<String> getQReferenceResourceList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QREFERENCE_RESOURCE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addQReferenceResource(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QREFERENCE_RESOURCE, new CodeType(value));
    return context;
  }

  public static List<String> getQReferenceResourceList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QREFERENCE_RESOURCE);
  }

// -- QSignatureRequired -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-signatureRequired|0.1.0
// Questionnaire Signature Required

  public static Extension makeQSignatureRequired(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_QSIGNATURE_REQUIRED).setValue(value);
  }

  public static ElementDefinition addQSignatureRequired(ElementDefinition context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QSIGNATURE_REQUIRED, value);
    return context;
  }

  public static List<CodeableConcept> getQSignatureRequiredList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_QSIGNATURE_REQUIRED);
  }

  public static Questionnaire addQSignatureRequired(Questionnaire context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QSIGNATURE_REQUIRED, value);
    return context;
  }

  public static List<CodeableConcept> getQSignatureRequiredList(Questionnaire context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_QSIGNATURE_REQUIRED);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addQSignatureRequired(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QSIGNATURE_REQUIRED, value);
    return context;
  }

  public static List<CodeableConcept> getQSignatureRequiredList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_QSIGNATURE_REQUIRED);
  }

// -- QSliderStepValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-sliderStepValue|0.1.0
// Questionnaire Slider Step Value

  public static Extension makeQSliderStepValue(int value) {
    return new Extension(ExtensionConstants.EXT_QSLIDER_STEP_VALUE).setValue(new IntegerType(value));
  }

  public static ElementDefinition setQSliderStepValue(ElementDefinition context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QSLIDER_STEP_VALUE, new IntegerType(value));
    return context;
  }

  public static Integer getQSliderStepValue(ElementDefinition context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_QSLIDER_STEP_VALUE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQSliderStepValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QSLIDER_STEP_VALUE, new IntegerType(value));
    return context;
  }

  public static Integer getQSliderStepValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_QSLIDER_STEP_VALUE);
  }

// -- QSupportLink -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-supportLink|0.1.0
// Questionnaire Support Link

  public static Extension makeQSupportLink(String value) {
    return new Extension(ExtensionConstants.EXT_QSUPPORT_LINK).setValue(new UriType(value));
  }

  public static ElementDefinition addQSupportLink(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QSUPPORT_LINK, new UriType(value));
    return context;
  }

  public static List<String> getQSupportLinkList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QSUPPORT_LINK);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addQSupportLink(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QSUPPORT_LINK, new UriType(value));
    return context;
  }

  public static List<String> getQSupportLinkList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_QSUPPORT_LINK);
  }

// -- QUnit -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-unit|0.1.0
// Questionnaire Unit

  public static Extension makeQUnit(Coding value) {
    return new Extension(ExtensionConstants.EXT_QUNIT).setValue(value);
  }

  public static ElementDefinition setQUnit(ElementDefinition context, Coding value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QUNIT, value);
    return context;
  }

  public static Coding getQUnit(ElementDefinition context) {
    return ExtensionsUtils.getExtension(Coding.class, context, ExtensionConstants.EXT_QUNIT);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQUnit(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, Coding value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QUNIT, value);
    return context;
  }

  public static Coding getQUnit(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtension(Coding.class, context, ExtensionConstants.EXT_QUNIT);
  }

// -- QRUnitOption -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-unitOption|0.1.0
// QuestionnaireResponse Unit Option

  public static Extension makeQRUnitOption(Coding value) {
    return new Extension(ExtensionConstants.EXT_QRUNIT_OPTION).setValue(value);
  }

  public static ElementDefinition addQRUnitOption(ElementDefinition context, Coding value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QRUNIT_OPTION, value);
    return context;
  }

  public static List<Coding> getQRUnitOptionList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionList(Coding.class, context, ExtensionConstants.EXT_QRUNIT_OPTION);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addQRUnitOption(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, Coding value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QRUNIT_OPTION, value);
    return context;
  }

  public static List<Coding> getQRUnitOptionList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionList(Coding.class, context, ExtensionConstants.EXT_QRUNIT_OPTION);
  }

// -- QRUnitValueSet -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-unitValueSet|0.1.0
// QuestionnaireResponse Unit ValueSet

  public static Extension makeQRUnitValueSet(String value) {
    return new Extension(ExtensionConstants.EXT_QRUNIT_VALUE_SET).setValue(new CanonicalType(value));
  }

  public static ElementDefinition setQRUnitValueSet(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRUNIT_VALUE_SET, new CanonicalType(value));
    return context;
  }

  public static String getQRUnitValueSet(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QRUNIT_VALUE_SET);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQRUnitValueSet(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRUNIT_VALUE_SET, new CanonicalType(value));
    return context;
  }

  public static String getQRUnitValueSet(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QRUNIT_VALUE_SET);
  }

// -- QRUsageMode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaire-usageMode|0.1.0
// QuestionnaireResponse Usage Mode

  public static Extension makeQRUsageMode(String value) {
    return new Extension(ExtensionConstants.EXT_QRUSAGE_MODE).setValue(new CodeType(value));
  }

  public static ElementDefinition setQRUsageMode(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRUSAGE_MODE, new CodeType(value));
    return context;
  }

  public static String getQRUsageMode(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QRUSAGE_MODE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent setQRUsageMode(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRUSAGE_MODE, new CodeType(value));
    return context;
  }

  public static String getQRUsageMode(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_QRUSAGE_MODE);
  }

// -- QRAuthor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaireresponse-author|0.1.0
// QuestionnaireResponse Author

  public static Extension makeQRAuthor(Reference value) {
    return new Extension(ExtensionConstants.EXT_QRAUTHOR).setValue(value);
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent setQRAuthor(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRAUTHOR, value);
    return context;
  }

  public static Reference getQRAuthor(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_QRAUTHOR);
  }

// -- QRCompletionMode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaireresponse-completionMode|0.1.0
// QuestionnaireResponse Completion Mode

  public static Extension makeQRCompletionMode(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_QRCOMPLETION_MODE).setValue(value);
  }

  public static QuestionnaireResponse setQRCompletionMode(QuestionnaireResponse context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRCOMPLETION_MODE, value);
    return context;
  }

  public static CodeableConcept getQRCompletionMode(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_QRCOMPLETION_MODE);
  }

// -- QRReason -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaireresponse-reason|0.1.0
// QuestionnaireResponse Reason

  public static Extension makeQRReason(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_QRREASON).setValue(value);
  }

  public static QuestionnaireResponse addQRReason(QuestionnaireResponse context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QRREASON, value);
    return context;
  }

  public static List<CodeableConcept> getQRReasonList(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_QRREASON);
  }

// -- QRReviewer -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaireresponse-reviewer|0.1.0
// QuestionnaireResponse Reviewer

  public static Extension makeQRReviewer(Reference value) {
    return new Extension(ExtensionConstants.EXT_QRREVIEWER).setValue(value);
  }

  public static QuestionnaireResponse setQRReviewer(QuestionnaireResponse context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_QRREVIEWER, value);
    return context;
  }

  public static Reference getQRReviewer(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_QRREVIEWER);
  }

// -- QRSignature -------------------------------------
// http://hl7.org/fhir/StructureDefinition/questionnaireresponse-signature|0.1.0
// QuestionnaireResponse Signature

  public static Extension makeQRSignature(Signature value) {
    return new Extension(ExtensionConstants.EXT_QRSIGNATURE).setValue(value);
  }

  public static QuestionnaireResponse addQRSignature(QuestionnaireResponse context, Signature value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QRSIGNATURE, value);
    return context;
  }

  public static List<Signature> getQRSignatureList(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionList(Signature.class, context, ExtensionConstants.EXT_QRSIGNATURE);
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent addQRSignature(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent context, Signature value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_QRSIGNATURE, value);
    return context;
  }

  public static List<Signature> getQRSignatureList(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent context) {
    return ExtensionsUtils.getExtensionList(Signature.class, context, ExtensionConstants.EXT_QRSIGNATURE);
  }

// -- ReferencesContained -------------------------------------
// http://hl7.org/fhir/StructureDefinition/referencesContained|0.1.0
// References Contained

  public static Extension makeReferencesContained(Reference value) {
    return new Extension(ExtensionConstants.EXT_REFERENCES_CONTAINED).setValue(value);
  }

  public static Expression addReferencesContained(Expression context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REFERENCES_CONTAINED, value);
    return context;
  }

  public static List<Reference> getReferencesContainedList(Expression context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_REFERENCES_CONTAINED);
  }

// -- RenderedValue -------------------------------------
// http://hl7.org/fhir/StructureDefinition/rendered-value|0.1.0
// Rendered Value

  public static Extension makeRenderedValue(String value) {
    return new Extension(ExtensionConstants.EXT_RENDERED_VALUE).setValue(new StringType(value));
  }

  public static CanonicalType setRenderedValue(CanonicalType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(CanonicalType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static CodeType setRenderedValue(CodeType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(CodeType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static DateTimeType setRenderedValue(DateTimeType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(DateTimeType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static DateType setRenderedValue(DateType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(DateType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static DecimalType setRenderedValue(DecimalType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(DecimalType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static InstantType setRenderedValue(InstantType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(InstantType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static IntegerType setRenderedValue(IntegerType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(IntegerType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static StringType setRenderedValue(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

  public static TimeType setRenderedValue(TimeType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERED_VALUE, new StringType(value));
    return context;
  }

  public static String getRenderedValue(TimeType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERED_VALUE);
  }

// -- Markdown -------------------------------------
// http://hl7.org/fhir/StructureDefinition/rendering-markdown|0.1.0
// Markdown

  public static Extension makeMarkdown(String value) {
    return new Extension(ExtensionConstants.EXT_MARKDOWN).setValue(new MarkdownType(value));
  }

  public static StringType setMarkdown(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_MARKDOWN, new MarkdownType(value));
    return context;
  }

  public static String getMarkdown(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_MARKDOWN);
  }

// -- RenderingStyle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/rendering-style|0.1.0
// Rendering Style

  public static Extension makeRenderingStyle(String value) {
    return new Extension(ExtensionConstants.EXT_RENDERING_STYLE).setValue(new StringType(value));
  }

  public static Element setRenderingStyle(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERING_STYLE, new StringType(value));
    return context;
  }

  public static String getRenderingStyle(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERING_STYLE);
  }

// -- StyleSensitive -------------------------------------
// http://hl7.org/fhir/StructureDefinition/rendering-styleSensitive|0.1.0
// style sensitive

  public static Extension makeStyleSensitive(boolean value) {
    return new Extension(ExtensionConstants.EXT_STYLE_SENSITIVE).setValue(new BooleanType(value));
  }

  public static Element setStyleSensitive(Element context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_STYLE_SENSITIVE, new BooleanType(value));
    return context;
  }

  public static Boolean getStyleSensitive(Element context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_STYLE_SENSITIVE);
  }

// -- XhtmlRepresentation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/rendering-xhtml|0.1.0
// XHTML Representation

  public static Extension makeXhtmlRepresentation(String value) {
    return new Extension(ExtensionConstants.EXT_XHTML_REPRESENTATION).setValue(new StringType(value));
  }

  public static StringType setXhtmlRepresentation(StringType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_XHTML_REPRESENTATION, new StringType(value));
    return context;
  }

  public static String getXhtmlRepresentation(StringType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_XHTML_REPRESENTATION);
  }

// -- Replaces -------------------------------------
// http://hl7.org/fhir/StructureDefinition/replaces|0.1.0
// Replaces

  public static Extension makeReplaces(String value) {
    return new Extension(ExtensionConstants.EXT_REPLACES).setValue(new CanonicalType(value));
  }

  public static ActivityDefinition addReplaces(ActivityDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ActivityDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ActorDefinition addReplaces(ActorDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ActorDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static CapabilityStatement addReplaces(CapabilityStatement context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(CapabilityStatement context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ChargeItemDefinition addReplaces(ChargeItemDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ChargeItemDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static Citation addReplaces(Citation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(Citation context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static CodeSystem addReplaces(CodeSystem context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(CodeSystem context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static CompartmentDefinition addReplaces(CompartmentDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(CompartmentDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ConceptMap addReplaces(ConceptMap context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ConceptMap context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ConditionDefinition addReplaces(ConditionDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ConditionDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static EventDefinition addReplaces(EventDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(EventDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static Evidence addReplaces(Evidence context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(Evidence context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static EvidenceReport addReplaces(EvidenceReport context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(EvidenceReport context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static EvidenceVariable addReplaces(EvidenceVariable context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(EvidenceVariable context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ExampleScenario addReplaces(ExampleScenario context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ExampleScenario context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static GraphDefinition addReplaces(GraphDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(GraphDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ImplementationGuide addReplaces(ImplementationGuide context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ImplementationGuide context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static Library addReplaces(Library context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(Library context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static Measure addReplaces(Measure context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(Measure context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static MessageDefinition addReplaces(MessageDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(MessageDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static NamingSystem addReplaces(NamingSystem context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(NamingSystem context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ObservationDefinition addReplaces(ObservationDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ObservationDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static OperationDefinition addReplaces(OperationDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(OperationDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static PlanDefinition addReplaces(PlanDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(PlanDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static Questionnaire addReplaces(Questionnaire context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(Questionnaire context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static Requirements addReplaces(Requirements context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(Requirements context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static SearchParameter addReplaces(SearchParameter context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(SearchParameter context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static SpecimenDefinition addReplaces(SpecimenDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(SpecimenDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static StructureDefinition addReplaces(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static StructureMap addReplaces(StructureMap context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(StructureMap context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static SubscriptionTopic addReplaces(SubscriptionTopic context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(SubscriptionTopic context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static TerminologyCapabilities addReplaces(TerminologyCapabilities context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(TerminologyCapabilities context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static TestScript addReplaces(TestScript context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(TestScript context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

  public static ValueSet addReplaces(ValueSet context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REPLACES, new CanonicalType(value));
    return context;
  }

  public static List<String> getReplacesList(ValueSet context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_REPLACES);
  }

// -- DoNotPerform -------------------------------------
// http://hl7.org/fhir/StructureDefinition/request-doNotPerform|0.1.0
// do not perform

  public static Extension makeDoNotPerform(boolean value) {
    return new Extension(ExtensionConstants.EXT_DO_NOT_PERFORM).setValue(new BooleanType(value));
  }

  public static NutritionOrder setDoNotPerform(NutritionOrder context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_DO_NOT_PERFORM, new BooleanType(value));
    return context;
  }

  public static Boolean getDoNotPerform(NutritionOrder context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_DO_NOT_PERFORM);
  }

// -- RequestInsurance -------------------------------------
// http://hl7.org/fhir/StructureDefinition/request-insurance|0.1.0
// Request Insurance

  public static Extension makeRequestInsurance(Reference value) {
    return new Extension(ExtensionConstants.EXT_REQUEST_INSURANCE).setValue(value);
  }

  public static NutritionOrder addRequestInsurance(NutritionOrder context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REQUEST_INSURANCE, value);
    return context;
  }

  public static List<Reference> getRequestInsuranceList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_REQUEST_INSURANCE);
  }

// -- PerformerOrder -------------------------------------
// http://hl7.org/fhir/StructureDefinition/request-performerOrder|0.1.0
// performer order

  public static Extension makePerformerOrder(int value) {
    return new Extension(ExtensionConstants.EXT_PERFORMER_ORDER).setValue(new IntegerType(value));
  }

  public static CodeableReference setPerformerOrder(CodeableReference context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PERFORMER_ORDER, new IntegerType(value));
    return context;
  }

  public static Integer getPerformerOrder(CodeableReference context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_PERFORMER_ORDER);
  }

  public static Reference setPerformerOrder(Reference context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_PERFORMER_ORDER, new IntegerType(value));
    return context;
  }

  public static Integer getPerformerOrder(Reference context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_PERFORMER_ORDER);
  }

// -- RelevantHistory -------------------------------------
// http://hl7.org/fhir/StructureDefinition/request-relevantHistory|0.1.0
// relevant history

  public static Extension makeRelevantHistory(Reference value) {
    return new Extension(ExtensionConstants.EXT_RELEVANT_HISTORY).setValue(value);
  }

  public static CarePlan addRelevantHistory(CarePlan context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RELEVANT_HISTORY, value);
    return context;
  }

  public static List<Reference> getRelevantHistoryList(CarePlan context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RELEVANT_HISTORY);
  }

  public static CommunicationRequest addRelevantHistory(CommunicationRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RELEVANT_HISTORY, value);
    return context;
  }

  public static List<Reference> getRelevantHistoryList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RELEVANT_HISTORY);
  }

  public static NutritionOrder addRelevantHistory(NutritionOrder context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RELEVANT_HISTORY, value);
    return context;
  }

  public static List<Reference> getRelevantHistoryList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RELEVANT_HISTORY);
  }

// -- RequestReplaces -------------------------------------
// http://hl7.org/fhir/StructureDefinition/request-replaces|0.1.0
// Request Replaces

  public static Extension makeRequestReplaces(Reference value) {
    return new Extension(ExtensionConstants.EXT_REQUEST_REPLACES).setValue(value);
  }

  public static NutritionOrder addRequestReplaces(NutritionOrder context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REQUEST_REPLACES, value);
    return context;
  }

  public static List<Reference> getRequestReplacesList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_REQUEST_REPLACES);
  }

  public static SupplyRequest addRequestReplaces(SupplyRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REQUEST_REPLACES, value);
    return context;
  }

  public static List<Reference> getRequestReplacesList(SupplyRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_REQUEST_REPLACES);
  }

  public static Task addRequestReplaces(Task context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_REQUEST_REPLACES, value);
    return context;
  }

  public static List<Reference> getRequestReplacesList(Task context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_REQUEST_REPLACES);
  }

// -- RequestStatusReason -------------------------------------
// http://hl7.org/fhir/StructureDefinition/request-statusReason|0.1.0
// status reason

  public static Extension makeRequestStatusReason(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_REQUEST_STATUS_REASON).setValue(value);
  }

  public static DeviceRequest setRequestStatusReason(DeviceRequest context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_REQUEST_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getRequestStatusReason(DeviceRequest context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_REQUEST_STATUS_REASON);
  }

  public static NutritionOrder setRequestStatusReason(NutritionOrder context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_REQUEST_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getRequestStatusReason(NutritionOrder context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_REQUEST_STATUS_REASON);
  }

  public static ServiceRequest setRequestStatusReason(ServiceRequest context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_REQUEST_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getRequestStatusReason(ServiceRequest context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_REQUEST_STATUS_REASON);
  }

  public static SupplyRequest setRequestStatusReason(SupplyRequest context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_REQUEST_STATUS_REASON, value);
    return context;
  }

  public static CodeableConcept getRequestStatusReason(SupplyRequest context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_REQUEST_STATUS_REASON);
  }

// -- RSStudyRegistration -------------------------------------
// http://hl7.org/fhir/StructureDefinition/researchStudy-studyRegistration|0.1.0
// ResearchStudy Study Registration

  public static Extension makeRSStudyRegistration(DataType value) {
    return new Extension(ExtensionConstants.EXT_RSSTUDY_REGISTRATION).setValue(value);
  }

  public static ResearchStudy addRSStudyRegistration(ResearchStudy context, DataType value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RSSTUDY_REGISTRATION, value);
    return context;
  }

  public static List<DataType> getRSStudyRegistrationList(ResearchStudy context) {
    return ExtensionsUtils.getExtensionList(DataType.class, context, ExtensionConstants.EXT_RSSTUDY_REGISTRATION);
  }

// -- ResolveAsVersionSpecific -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resolve-as-version-specific|0.1.0
// Resolve as version specific

  public static Extension makeResolveAsVersionSpecific(boolean value) {
    return new Extension(ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC).setValue(new BooleanType(value));
  }

  public static Reference setResolveAsVersionSpecific(Reference context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC, new BooleanType(value));
    return context;
  }

  public static Boolean getResolveAsVersionSpecific(Reference context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC);
  }

  public static UriType setResolveAsVersionSpecific(UriType context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC, new BooleanType(value));
    return context;
  }

  public static Boolean getResolveAsVersionSpecific(UriType context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC);
  }

  public static UrlType setResolveAsVersionSpecific(UrlType context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC, new BooleanType(value));
    return context;
  }

  public static Boolean getResolveAsVersionSpecific(UrlType context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_RESOLVE_AS_VERSION_SPECIFIC);
  }

// -- ResourceApprovalDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resource-approvalDate|0.1.0
// Resource Approval Date

  public static Extension makeResourceApprovalDate(String value) {
    return new Extension(ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE).setValue(new DateType(value));
  }

  public static CapabilityStatement setResourceApprovalDate(CapabilityStatement context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(CapabilityStatement context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static CodeSystem setResourceApprovalDate(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static CompartmentDefinition setResourceApprovalDate(CompartmentDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(CompartmentDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static ConceptMap setResourceApprovalDate(ConceptMap context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(ConceptMap context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static ImplementationGuide setResourceApprovalDate(ImplementationGuide context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(ImplementationGuide context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static NamingSystem setResourceApprovalDate(NamingSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(NamingSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static OperationDefinition setResourceApprovalDate(OperationDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(OperationDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static SearchParameter setResourceApprovalDate(SearchParameter context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(SearchParameter context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static StructureDefinition setResourceApprovalDate(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static StructureMap setResourceApprovalDate(StructureMap context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(StructureMap context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

  public static ValueSet setResourceApprovalDate(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE, new DateType(value));
    return context;
  }

  public static String getResourceApprovalDate(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_APPROVAL_DATE);
  }

// -- ResourceEffectivePeriod -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resource-effectivePeriod|0.1.0
// Resource Effective Period

  public static Extension makeResourceEffectivePeriod(Period value) {
    return new Extension(ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD).setValue(value);
  }

  public static CapabilityStatement setResourceEffectivePeriod(CapabilityStatement context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(CapabilityStatement context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static CodeSystem setResourceEffectivePeriod(CodeSystem context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(CodeSystem context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static CompartmentDefinition setResourceEffectivePeriod(CompartmentDefinition context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(CompartmentDefinition context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static ConceptMap setResourceEffectivePeriod(ConceptMap context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(ConceptMap context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static ImplementationGuide setResourceEffectivePeriod(ImplementationGuide context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(ImplementationGuide context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static NamingSystem setResourceEffectivePeriod(NamingSystem context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(NamingSystem context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static OperationDefinition setResourceEffectivePeriod(OperationDefinition context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(OperationDefinition context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static SearchParameter setResourceEffectivePeriod(SearchParameter context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(SearchParameter context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static StructureDefinition setResourceEffectivePeriod(StructureDefinition context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(StructureDefinition context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static StructureMap setResourceEffectivePeriod(StructureMap context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(StructureMap context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

  public static ValueSet setResourceEffectivePeriod(ValueSet context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD, value);
    return context;
  }

  public static Period getResourceEffectivePeriod(ValueSet context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_RESOURCE_EFFECTIVE_PERIOD);
  }

// -- ResourceInstanceDescription -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resource-instance-description|0.1.0
// Resource instance description

  public static Extension makeResourceInstanceDescription(String value) {
    return new Extension(ExtensionConstants.EXT_RESOURCE_INSTANCE_DESCRIPTION).setValue(new MarkdownType(value));
  }

  public static Resource setResourceInstanceDescription(Resource context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_INSTANCE_DESCRIPTION, new MarkdownType(value));
    return context;
  }

  public static String getResourceInstanceDescription(Resource context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_INSTANCE_DESCRIPTION);
  }

// -- ResourceInstanceName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resource-instance-name|0.1.0
// Resource instance name

  public static Extension makeResourceInstanceName(String value) {
    return new Extension(ExtensionConstants.EXT_RESOURCE_INSTANCE_NAME).setValue(new StringType(value));
  }

  public static Resource setResourceInstanceName(Resource context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESOURCE_INSTANCE_NAME, new StringType(value));
    return context;
  }

  public static String getResourceInstanceName(Resource context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESOURCE_INSTANCE_NAME);
  }

// -- ReslastReviewDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resource-lastReviewDate|0.1.0
// Resource Last Review Date

  public static Extension makeReslastReviewDate(String value) {
    return new Extension(ExtensionConstants.EXT_RESLAST_REVIEW_DATE).setValue(new DateType(value));
  }

  public static CapabilityStatement setReslastReviewDate(CapabilityStatement context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(CapabilityStatement context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static CodeSystem setReslastReviewDate(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static CompartmentDefinition setReslastReviewDate(CompartmentDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(CompartmentDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static ConceptMap setReslastReviewDate(ConceptMap context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(ConceptMap context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static ImplementationGuide setReslastReviewDate(ImplementationGuide context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(ImplementationGuide context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static NamingSystem setReslastReviewDate(NamingSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(NamingSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static OperationDefinition setReslastReviewDate(OperationDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(OperationDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static SearchParameter setReslastReviewDate(SearchParameter context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(SearchParameter context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static StructureDefinition setReslastReviewDate(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static StructureMap setReslastReviewDate(StructureMap context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(StructureMap context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

  public static ValueSet setReslastReviewDate(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE, new DateType(value));
    return context;
  }

  public static String getReslastReviewDate(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RESLAST_REVIEW_DATE);
  }

// -- SRPertainsToGoal -------------------------------------
// http://hl7.org/fhir/StructureDefinition/resource-pertainsToGoal|0.1.0
// ServiceRequest Pertains To Goal

  public static Extension makeSRPertainsToGoal(Reference value) {
    return new Extension(ExtensionConstants.EXT_SRPERTAINS_TO_GOAL).setValue(value);
  }

  public static Resource addSRPertainsToGoal(Resource context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SRPERTAINS_TO_GOAL, value);
    return context;
  }

  public static List<Reference> getSRPertainsToGoalList(Resource context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SRPERTAINS_TO_GOAL);
  }

// -- SRPrecondition -------------------------------------
// http://hl7.org/fhir/StructureDefinition/servicerequest-precondition|0.1.0
// ServiceRequest Precondition

  public static Extension makeSRPrecondition(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SRPRECONDITION).setValue(value);
  }

  public static ServiceRequest addSRPrecondition(ServiceRequest context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SRPRECONDITION, value);
    return context;
  }

  public static List<CodeableConcept> getSRPreconditionList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_SRPRECONDITION);
  }

// -- SRQuestionnaireRequest -------------------------------------
// http://hl7.org/fhir/StructureDefinition/servicerequest-questionnaireRequest|0.1.0
// ServiceRequest Questionnaire Requested

  public static Extension makeSRQuestionnaireRequest(Reference value) {
    return new Extension(ExtensionConstants.EXT_SRQUESTIONNAIRE_REQUEST).setValue(value);
  }

  public static ServiceRequest setSRQuestionnaireRequest(ServiceRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SRQUESTIONNAIRE_REQUEST, value);
    return context;
  }

  public static Reference getSRQuestionnaireRequest(ServiceRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_SRQUESTIONNAIRE_REQUEST);
  }

// -- SpecCollectionPriority -------------------------------------
// http://hl7.org/fhir/StructureDefinition/specimen-collectionPriority|0.1.0
// Specimen Collection Priority

  public static Extension makeSpecCollectionPriority(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SPEC_COLLECTION_PRIORITY).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent setSpecCollectionPriority(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SPEC_COLLECTION_PRIORITY, value);
    return context;
  }

  public static CodeableConcept getSpecCollectionPriority(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_SPEC_COLLECTION_PRIORITY);
  }

// -- SpecIsDryWeight -------------------------------------
// http://hl7.org/fhir/StructureDefinition/specimen-isDryWeight|0.1.0
// Specimen Is Dry Weight

  public static Extension makeSpecIsDryWeight(boolean value) {
    return new Extension(ExtensionConstants.EXT_SPEC_IS_DRY_WEIGHT).setValue(new BooleanType(value));
  }

// -- SpecProcessingTime -------------------------------------
// http://hl7.org/fhir/StructureDefinition/specimen-processingTime|0.1.0
// Specimen Processing Time

  public static Extension makeSpecProcessingTime(Period value) {
    return new Extension(ExtensionConstants.EXT_SPEC_PROCESSING_TIME).setValue(value);
  }

  public static Extension makeSpecProcessingTime(Duration value) {
    return new Extension(ExtensionConstants.EXT_SPEC_PROCESSING_TIME).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent setSpecProcessingTime(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SPEC_PROCESSING_TIME, value);
    return context;
  }

  public static Period getSpecProcessingTimePeriod(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_SPEC_PROCESSING_TIME);
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent setSpecProcessingTime(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent context, Duration value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SPEC_PROCESSING_TIME, value);
    return context;
  }

  public static Duration getSpecProcessingTimeDuration(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent context) {
    return ExtensionsUtils.getExtension(Duration.class, context, ExtensionConstants.EXT_SPEC_PROCESSING_TIME);
  }

// -- SpecSequenceNumber -------------------------------------
// http://hl7.org/fhir/StructureDefinition/specimen-sequenceNumber|0.1.0
// Specimen Sequence Number

  public static Extension makeSpecSequenceNumber(int value) {
    return new Extension(ExtensionConstants.EXT_SPEC_SEQUENCE_NUMBER).setValue(new IntegerType(value));
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent setSpecSequenceNumber(org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SPEC_SEQUENCE_NUMBER, new IntegerType(value));
    return context;
  }

  public static Integer getSpecSequenceNumber(org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_SPEC_SEQUENCE_NUMBER);
  }

// -- SpecSpecialHandling -------------------------------------
// http://hl7.org/fhir/StructureDefinition/specimen-specialHandling|0.1.0
// Specimen Special handling

  public static Extension makeSpecSpecialHandling(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SPEC_SPECIAL_HANDLING).setValue(value);
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent addSpecSpecialHandling(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent context, CodeableConcept value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SPEC_SPECIAL_HANDLING, value);
    return context;
  }

  public static List<CodeableConcept> getSpecSpecialHandlingList(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableConcept.class, context, ExtensionConstants.EXT_SPEC_SPECIAL_HANDLING);
  }

// -- SDAncestor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-ancestor|0.1.0
// StructureDefinition Ancestor

  public static Extension makeSDAncestor(String value) {
    return new Extension(ExtensionConstants.EXT_SDANCESTOR).setValue(new UriType(value));
  }

  public static StructureDefinition addSDAncestor(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SDANCESTOR, new UriType(value));
    return context;
  }

  public static List<String> getSDAncestorList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SDANCESTOR);
  }

// -- SDApplicableVersion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-applicable-version|0.1.0
// StructureDefinition Applicable Version

  public static Extension makeSDApplicableVersion(String value) {
    return new Extension(ExtensionConstants.EXT_SDAPPLICABLE_VERSION).setValue(new CodeType(value));
  }

  public static StructureDefinition addSDApplicableVersion(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SDAPPLICABLE_VERSION, new CodeType(value));
    return context;
  }

  public static List<String> getSDApplicableVersionList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SDAPPLICABLE_VERSION);
  }

// -- SDCategory -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-category|0.1.0
// StructureDefinition Category

  public static Extension makeSDCategory(String value) {
    return new Extension(ExtensionConstants.EXT_SDCATEGORY).setValue(new StringType(value));
  }

  public static StructureDefinition setSDCategory(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDCATEGORY, new StringType(value));
    return context;
  }

  public static String getSDCategory(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDCATEGORY);
  }

// -- SDCodegenSuper -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-codegen-super|0.1.0
// StructureDefinition Codegen Super

  public static Extension makeSDCodegenSuper(String value) {
    return new Extension(ExtensionConstants.EXT_SDCODEGEN_SUPER).setValue(new StringType(value));
  }

  public static CanonicalType setSDCodegenSuper(CanonicalType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDCODEGEN_SUPER, new StringType(value));
    return context;
  }

  public static String getSDCodegenSuper(CanonicalType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDCODEGEN_SUPER);
  }

// -- SDcompliesWithProfile -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-compliesWithProfile|0.1.0
// StructureDefinition Compiles With Profile

  public static Extension makeSDcompliesWithProfile(String value) {
    return new Extension(ExtensionConstants.EXT_SDCOMPLIES_WITH_PROFILE).setValue(new CanonicalType(value));
  }

  public static StructureDefinition addSDcompliesWithProfile(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SDCOMPLIES_WITH_PROFILE, new CanonicalType(value));
    return context;
  }

  public static List<String> getSDcompliesWithProfileList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SDCOMPLIES_WITH_PROFILE);
  }

// -- SDStatusDerivation -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-conformance-derivedFrom|0.1.0
// StructureDefinition Status Derivation

  public static Extension makeSDStatusDerivation(String value) {
    return new Extension(ExtensionConstants.EXT_SDSTATUS_DERIVATION).setValue(new CanonicalType(value));
  }

  public static Element addSDStatusDerivation(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SDSTATUS_DERIVATION, new CanonicalType(value));
    return context;
  }

  public static List<String> getSDStatusDerivationList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SDSTATUS_DERIVATION);
  }

  public static Resource addSDStatusDerivation(Resource context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SDSTATUS_DERIVATION, new CanonicalType(value));
    return context;
  }

  public static List<String> getSDStatusDerivationList(Resource context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SDSTATUS_DERIVATION);
  }

// -- SDDisplayHint -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-display-hint|0.1.0
// StructureDefinition Display Hint

  public static Extension makeSDDisplayHint(String value) {
    return new Extension(ExtensionConstants.EXT_SDDISPLAY_HINT).setValue(new StringType(value));
  }

  public static ElementDefinition setSDDisplayHint(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDDISPLAY_HINT, new StringType(value));
    return context;
  }

  public static String getSDDisplayHint(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDDISPLAY_HINT);
  }

// -- SDExplicitTypeName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-explicit-type-name|0.1.0
// StructureDefinition Explicit Type Name

  public static Extension makeSDExplicitTypeName(String value) {
    return new Extension(ExtensionConstants.EXT_SDEXPLICIT_TYPE_NAME).setValue(new StringType(value));
  }

  public static ElementDefinition setSDExplicitTypeName(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDEXPLICIT_TYPE_NAME, new StringType(value));
    return context;
  }

  public static String getSDExplicitTypeName(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDEXPLICIT_TYPE_NAME);
  }

// -- SDExtensionMeaning -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-extension-meaning|0.1.0
// StructureDefinition Extension Meaning

  public static Extension makeSDExtensionMeaning(CodeableConcept value) {
    return new Extension(ExtensionConstants.EXT_SDEXTENSION_MEANING).setValue(value);
  }

  public static Extension setSDExtensionMeaning(Extension context, CodeableConcept value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDEXTENSION_MEANING, value);
    return context;
  }

  public static CodeableConcept getSDExtensionMeaning(Extension context) {
    return ExtensionsUtils.getExtension(CodeableConcept.class, context, ExtensionConstants.EXT_SDEXTENSION_MEANING);
  }

// -- SDFhirType -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type|0.1.0
// StructureDefinition FHIR Type

  public static Extension makeSDFhirType(String value) {
    return new Extension(ExtensionConstants.EXT_SDFHIR_TYPE).setValue(new UrlType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setSDFhirType(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDFHIR_TYPE, new UrlType(value));
    return context;
  }

  public static String getSDFhirType(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDFHIR_TYPE);
  }

// -- SDFmm -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-fmm|0.1.0
// StructureDefinition FMM Level

  public static Extension makeSDFmm(int value) {
    return new Extension(ExtensionConstants.EXT_SDFMM).setValue(new IntegerType(value));
  }

  public static Element setSDFmm(Element context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDFMM, new IntegerType(value));
    return context;
  }

  public static Integer getSDFmm(Element context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_SDFMM);
  }

// -- SDFmmNoWarnings -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-fmm-no-warnings|0.1.0
// StructureDefinition FMM If No Warnings

  public static Extension makeSDFmmNoWarnings(int value) {
    return new Extension(ExtensionConstants.EXT_SDFMM_NO_WARNINGS).setValue(new IntegerType(value));
  }

  public static StructureDefinition setSDFmmNoWarnings(StructureDefinition context, int value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDFMM_NO_WARNINGS, new IntegerType(value));
    return context;
  }

  public static Integer getSDFmmNoWarnings(StructureDefinition context) {
    return ExtensionsUtils.getExtensionInt(context, ExtensionConstants.EXT_SDFMM_NO_WARNINGS);
  }

// -- SDFmmSupportDoco -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-fmm-support|0.1.0
// StructureDefinition FMM Supporting Documentation

  public static Extension makeSDFmmSupportDoco(String value) {
    return new Extension(ExtensionConstants.EXT_SDFMM_SUPPORT_DOCO).setValue(new MarkdownType(value));
  }

  public static Element setSDFmmSupportDoco(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDFMM_SUPPORT_DOCO, new MarkdownType(value));
    return context;
  }

  public static String getSDFmmSupportDoco(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDFMM_SUPPORT_DOCO);
  }

// -- SDHierarchy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-hierarchy|0.1.0
// StructureDefinition Hierarchy

  public static Extension makeSDHierarchy(boolean value) {
    return new Extension(ExtensionConstants.EXT_SDHIERARCHY).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setSDHierarchy(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDHIERARCHY, new BooleanType(value));
    return context;
  }

  public static Boolean getSDHierarchy(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SDHIERARCHY);
  }

// -- SDimposeProfile -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-imposeProfile|0.1.0
// StructureDefinition Dependent Profiles

  public static Extension makeSDimposeProfile(String value) {
    return new Extension(ExtensionConstants.EXT_SDIMPOSE_PROFILE).setValue(new CanonicalType(value));
  }

  public static StructureDefinition addSDimposeProfile(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SDIMPOSE_PROFILE, new CanonicalType(value));
    return context;
  }

  public static List<String> getSDimposeProfileList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SDIMPOSE_PROFILE);
  }

// -- SDInheritanceControl -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-inheritance-control|0.1.0
// StructureDefinition Inheritance Control (for Extensions)

  public static Extension makeSDInheritanceControl(String value) {
    return new Extension(ExtensionConstants.EXT_SDINHERITANCE_CONTROL).setValue(new CodeType(value));
  }

  public static StructureDefinition setSDInheritanceControl(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDINHERITANCE_CONTROL, new CodeType(value));
    return context;
  }

  public static String getSDInheritanceControl(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDINHERITANCE_CONTROL);
  }

// -- SDInterface -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-interface|0.1.0
// StructureDefinition Interface

  public static Extension makeSDInterface(boolean value) {
    return new Extension(ExtensionConstants.EXT_SDINTERFACE).setValue(new BooleanType(value));
  }

  public static StructureDefinition setSDInterface(StructureDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDINTERFACE, new BooleanType(value));
    return context;
  }

  public static Boolean getSDInterface(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SDINTERFACE);
  }

// -- SDNormativeVersion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-normative-version|0.1.0
// StructureDefinition First Normative Version

  public static Extension makeSDNormativeVersion(String value) {
    return new Extension(ExtensionConstants.EXT_SDNORMATIVE_VERSION).setValue(new CodeType(value));
  }

  public static CanonicalResource setSDNormativeVersion(CanonicalResource context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDNORMATIVE_VERSION, new CodeType(value));
    return context;
  }

  public static String getSDNormativeVersion(CanonicalResource context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDNORMATIVE_VERSION);
  }

  public static ElementDefinition setSDNormativeVersion(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDNORMATIVE_VERSION, new CodeType(value));
    return context;
  }

  public static String getSDNormativeVersion(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDNORMATIVE_VERSION);
  }

// -- SDSecurityCategory -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-security-category|0.1.0
// StructureDefinition Security Category

  public static Extension makeSDSecurityCategory(String value) {
    return new Extension(ExtensionConstants.EXT_SDSECURITY_CATEGORY).setValue(new CodeType(value));
  }

  public static StructureDefinition setSDSecurityCategory(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDSECURITY_CATEGORY, new CodeType(value));
    return context;
  }

  public static String getSDSecurityCategory(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDSECURITY_CATEGORY);
  }

// -- SDStandardsStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status|0.1.0
// StructureDefinition Standards Status

  public static Extension makeSDStandardsStatus(String value) {
    return new Extension(ExtensionConstants.EXT_SDSTANDARDS_STATUS).setValue(new CodeType(value));
  }

  public static Element setSDStandardsStatus(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDSTANDARDS_STATUS, new CodeType(value));
    return context;
  }

  public static String getSDStandardsStatus(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDSTANDARDS_STATUS);
  }

// -- SDStandardsStatusReason -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status-reason|0.1.0
// StructureDefinition Standards Status Reason

  public static Extension makeSDStandardsStatusReason(String value) {
    return new Extension(ExtensionConstants.EXT_SDSTANDARDS_STATUS_REASON).setValue(new MarkdownType(value));
  }

  public static Element setSDStandardsStatusReason(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDSTANDARDS_STATUS_REASON, new MarkdownType(value));
    return context;
  }

  public static String getSDStandardsStatusReason(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDSTANDARDS_STATUS_REASON);
  }

// -- SDSummary -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-summary|0.1.0
// Structure Definition Summary

  public static Extension makeSDSummary(String value) {
    return new Extension(ExtensionConstants.EXT_SDSUMMARY).setValue(new MarkdownType(value));
  }

  public static StructureDefinition setSDSummary(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDSUMMARY, new MarkdownType(value));
    return context;
  }

  public static String getSDSummary(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDSUMMARY);
  }

// -- SDTableName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-table-name|0.1.0
// StructureDefinition Table Name

  public static Extension makeSDTableName(String value) {
    return new Extension(ExtensionConstants.EXT_SDTABLE_NAME).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent setSDTableName(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDTABLE_NAME, new StringType(value));
    return context;
  }

  public static String getSDTableName(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDTABLE_NAME);
  }

// -- SDTemplateStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-template-status|0.1.0
// StructureDefinition Template Status

  public static Extension makeSDTemplateStatus(String value) {
    return new Extension(ExtensionConstants.EXT_SDTEMPLATE_STATUS).setValue(new CodeType(value));
  }

  public static StructureDefinition setSDTemplateStatus(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDTEMPLATE_STATUS, new CodeType(value));
    return context;
  }

  public static String getSDTemplateStatus(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDTEMPLATE_STATUS);
  }

// -- SDTypeCharacteristics -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-type-characteristics|0.1.0
// Structure Type Characterstics (Constraint Control)

  public static Extension makeSDTypeCharacteristics(String value) {
    return new Extension(ExtensionConstants.EXT_SDTYPE_CHARACTERISTICS).setValue(new CodeType(value));
  }

  public static StructureDefinition setSDTypeCharacteristics(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDTYPE_CHARACTERISTICS, new CodeType(value));
    return context;
  }

  public static String getSDTypeCharacteristics(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDTYPE_CHARACTERISTICS);
  }

// -- SDWorkGroup -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-wg|0.1.0
// StructureDefinition Work Group

  public static Extension makeSDWorkGroup(String value) {
    return new Extension(ExtensionConstants.EXT_SDWORK_GROUP).setValue(new CodeType(value));
  }

  public static Element setSDWorkGroup(Element context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDWORK_GROUP, new CodeType(value));
    return context;
  }

  public static String getSDWorkGroup(Element context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SDWORK_GROUP);
  }

// -- SDXmlHasNoOrder -------------------------------------
// http://hl7.org/fhir/StructureDefinition/structuredefinition-xml-no-order|0.1.0
// StructureDefinition Xml Has No Order

  public static Extension makeSDXmlHasNoOrder(boolean value) {
    return new Extension(ExtensionConstants.EXT_SDXML_HAS_NO_ORDER).setValue(new BooleanType(value));
  }

  public static StructureDefinition setSDXmlHasNoOrder(StructureDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SDXML_HAS_NO_ORDER, new BooleanType(value));
    return context;
  }

  public static Boolean getSDXmlHasNoOrder(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SDXML_HAS_NO_ORDER);
  }

// -- TargetElement -------------------------------------
// http://hl7.org/fhir/StructureDefinition/targetElement|0.1.0
// Target element

  public static Extension makeTargetElement(String value) {
    return new Extension(ExtensionConstants.EXT_TARGET_ELEMENT).setValue(new UriType(value));
  }

  public static CanonicalType addTargetElement(CanonicalType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TARGET_ELEMENT, new UriType(value));
    return context;
  }

  public static List<String> getTargetElementList(CanonicalType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_TARGET_ELEMENT);
  }

  public static Reference addTargetElement(Reference context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TARGET_ELEMENT, new UriType(value));
    return context;
  }

  public static List<String> getTargetElementList(Reference context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_TARGET_ELEMENT);
  }

// -- TargetPath -------------------------------------
// http://hl7.org/fhir/StructureDefinition/targetPath|0.1.0
// Target path

  public static Extension makeTargetPath(String value) {
    return new Extension(ExtensionConstants.EXT_TARGET_PATH).setValue(new StringType(value));
  }

  public static CanonicalType addTargetPath(CanonicalType context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TARGET_PATH, new StringType(value));
    return context;
  }

  public static List<String> getTargetPathList(CanonicalType context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_TARGET_PATH);
  }

  public static Reference addTargetPath(Reference context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TARGET_PATH, new StringType(value));
    return context;
  }

  public static List<String> getTargetPathList(Reference context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_TARGET_PATH);
  }

// -- TaskReplaces -------------------------------------
// http://hl7.org/fhir/StructureDefinition/task-replaces|0.1.0
// Task Replaces

  public static Extension makeTaskReplaces(Reference value) {
    return new Extension(ExtensionConstants.EXT_TASK_REPLACES).setValue(value);
  }

  public static Task addTaskReplaces(Task context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TASK_REPLACES, value);
    return context;
  }

  public static List<Reference> getTaskReplacesList(Task context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_TASK_REPLACES);
  }

// -- TimezoneCode -------------------------------------
// http://hl7.org/fhir/StructureDefinition/timezone|0.1.0
// Timezone Code

  public static Extension makeTimezoneCode(String value) {
    return new Extension(ExtensionConstants.EXT_TIMEZONE_CODE).setValue(new CodeType(value));
  }

  public static DateTimeType setTimezoneCode(DateTimeType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMEZONE_CODE, new CodeType(value));
    return context;
  }

  public static String getTimezoneCode(DateTimeType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TIMEZONE_CODE);
  }

  public static DateType setTimezoneCode(DateType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMEZONE_CODE, new CodeType(value));
    return context;
  }

  public static String getTimezoneCode(DateType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TIMEZONE_CODE);
  }

  public static InstantType setTimezoneCode(InstantType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMEZONE_CODE, new CodeType(value));
    return context;
  }

  public static String getTimezoneCode(InstantType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TIMEZONE_CODE);
  }

  public static Meta setTimezoneCode(Meta context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMEZONE_CODE, new CodeType(value));
    return context;
  }

  public static String getTimezoneCode(Meta context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TIMEZONE_CODE);
  }

  public static TimeType setTimezoneCode(TimeType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMEZONE_CODE, new CodeType(value));
    return context;
  }

  public static String getTimezoneCode(TimeType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TIMEZONE_CODE);
  }

// -- TimingDayOfMonth -------------------------------------
// http://hl7.org/fhir/StructureDefinition/timing-dayOfMonth|0.1.0
// Timing day of month

  public static Extension makeTimingDayOfMonth(int value) {
    return new Extension(ExtensionConstants.EXT_TIMING_DAY_OF_MONTH).setValue(new PositiveIntType(value));
  }

  public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent addTimingDayOfMonth(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent context, int value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TIMING_DAY_OF_MONTH, new PositiveIntType(value));
    return context;
  }

  public static List<Integer> getTimingDayOfMonthList(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent context) {
    return ExtensionsUtils.getExtensionIntList(context, ExtensionConstants.EXT_TIMING_DAY_OF_MONTH);
  }

// -- TimingExact -------------------------------------
// http://hl7.org/fhir/StructureDefinition/timing-exact|0.1.0
// Timing Exact

  public static Extension makeTimingExact(boolean value) {
    return new Extension(ExtensionConstants.EXT_TIMING_EXACT).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent setTimingExact(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMING_EXACT, new BooleanType(value));
    return context;
  }

  public static Boolean getTimingExact(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_TIMING_EXACT);
  }

// -- UncertainDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/timing-uncertainDate|0.1.0
// Uncertain date

  public static Extension makeUncertainDate(Period value) {
    return new Extension(ExtensionConstants.EXT_UNCERTAIN_DATE).setValue(value);
  }

  public static DateTimeType setUncertainDate(DateTimeType context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_UNCERTAIN_DATE, value);
    return context;
  }

  public static Period getUncertainDate(DateTimeType context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_UNCERTAIN_DATE);
  }

// -- TimezoneOffset -------------------------------------
// http://hl7.org/fhir/StructureDefinition/tz-offset|0.1.0
// Timezone Offset

  public static Extension makeTimezoneOffset(String value) {
    return new Extension(ExtensionConstants.EXT_TIMEZONE_OFFSET).setValue(new StringType(value));
  }

  public static DateType setTimezoneOffset(DateType context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TIMEZONE_OFFSET, new StringType(value));
    return context;
  }

  public static String getTimezoneOffset(DateType context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TIMEZONE_OFFSET);
  }

// -- UncertainPeriod -------------------------------------
// http://hl7.org/fhir/StructureDefinition/uncertainPeriod|0.1.0
// Uncertain period

  public static Extension makeUncertainPeriod(Period value) {
    return new Extension(ExtensionConstants.EXT_UNCERTAIN_PERIOD).setValue(value);
  }

  public static DateTimeType setUncertainPeriod(DateTimeType context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_UNCERTAIN_PERIOD, value);
    return context;
  }

  public static Period getUncertainPeriod(DateTimeType context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_UNCERTAIN_PERIOD);
  }

  public static DateType setUncertainPeriod(DateType context, Period value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_UNCERTAIN_PERIOD, value);
    return context;
  }

  public static Period getUncertainPeriod(DateType context) {
    return ExtensionsUtils.getExtension(Period.class, context, ExtensionConstants.EXT_UNCERTAIN_PERIOD);
  }

// -- Group -------------------------------------
// http://hl7.org/fhir/StructureDefinition/usagecontext-group|0.1.0
// Group

  public static Extension makeGroup(String value) {
    return new Extension(ExtensionConstants.EXT_GROUP).setValue(new StringType(value));
  }

  public static UsageContext setGroup(UsageContext context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GROUP, new StringType(value));
    return context;
  }

  public static String getGroup(UsageContext context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GROUP);
  }

// -- VSAuthoritativeSource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-authoritativeSource|0.1.0
// ValueSet Authoritative Source

  public static Extension makeVSAuthoritativeSource(String value) {
    return new Extension(ExtensionConstants.EXT_VSAUTHORITATIVE_SOURCE).setValue(new UriType(value));
  }

  public static ValueSet setVSAuthoritativeSource(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSAUTHORITATIVE_SOURCE, new UriType(value));
    return context;
  }

  public static String getVSAuthoritativeSource(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSAUTHORITATIVE_SOURCE);
  }

// -- VSCaseSensitive -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-caseSensitive|0.1.0
// ValueSet Case Sensitive

  public static Extension makeVSCaseSensitive(boolean value) {
    return new Extension(ExtensionConstants.EXT_VSCASE_SENSITIVE).setValue(new BooleanType(value));
  }

// -- VSComposeCreatedBy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-compose-createdBy|0.1.0
// ValueSet Compose CreatedBy

  public static Extension makeVSComposeCreatedBy(String value) {
    return new Extension(ExtensionConstants.EXT_VSCOMPOSE_CREATED_BY).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent setVSComposeCreatedBy(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSCOMPOSE_CREATED_BY, new StringType(value));
    return context;
  }

  public static String getVSComposeCreatedBy(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSCOMPOSE_CREATED_BY);
  }

// -- VSComposeCreationDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-compose-creationDate|0.1.0
// ValueSet Compose Creation Date

  public static Extension makeVSComposeCreationDate(String value) {
    return new Extension(ExtensionConstants.EXT_VSCOMPOSE_CREATION_DATE).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent setVSComposeCreationDate(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSCOMPOSE_CREATION_DATE, new StringType(value));
    return context;
  }

  public static String getVSComposeCreationDate(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSCOMPOSE_CREATION_DATE);
  }

// -- VSIncludeVSTitle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-compose-include-valueSetTitle|0.1.0
// ValueSet Include ValueSet Title

  public static Extension makeVSIncludeVSTitle(String value) {
    return new Extension(ExtensionConstants.EXT_VSINCLUDE_V_S_TITLE).setValue(new StringType(value));
  }

// -- VSConceptComments -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-concept-comments|0.1.0
// ValueSet Concept Comments

  public static Extension makeVSConceptComments(String value) {
    return new Extension(ExtensionConstants.EXT_VSCONCEPT_COMMENTS).setValue(new StringType(value));
  }

// -- VSConceptDefinition -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-concept-definition|0.1.0
// ValueSet Concept Definition

  public static Extension makeVSConceptDefinition(String value) {
    return new Extension(ExtensionConstants.EXT_VSCONCEPT_DEFINITION).setValue(new StringType(value));
  }

// -- VSConceptOrder -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-conceptOrder|0.1.0
// ValueSet Concept Order

  public static Extension makeVSConceptOrder(int value) {
    return new Extension(ExtensionConstants.EXT_VSCONCEPT_ORDER).setValue(new IntegerType(value));
  }

// -- VSDeprecated -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-deprecated|0.1.0
// ValueSet Deprecated

  public static Extension makeVSDeprecated(boolean value) {
    return new Extension(ExtensionConstants.EXT_VSDEPRECATED).setValue(new BooleanType(value));
  }

// -- VSExpansionSource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-expansionSource|0.1.0
// ValueSet Expansion Source

  public static Extension makeVSExpansionSource(String value) {
    return new Extension(ExtensionConstants.EXT_VSEXPANSION_SOURCE).setValue(new UriType(value));
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent setVSExpansionSource(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSEXPANSION_SOURCE, new UriType(value));
    return context;
  }

  public static String getVSExpansionSource(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSEXPANSION_SOURCE);
  }

// -- VSExpression -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-expression|0.1.0
// ValueSet Expression

  public static Extension makeVSExpression(Expression value) {
    return new Extension(ExtensionConstants.EXT_VSEXPRESSION).setValue(value);
  }

  public static ValueSet setVSExpression(ValueSet context, Expression value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSEXPRESSION, value);
    return context;
  }

  public static Expression getVSExpression(ValueSet context) {
    return ExtensionsUtils.getExtension(Expression.class, context, ExtensionConstants.EXT_VSEXPRESSION);
  }

// -- VSExtensible -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-extensible|0.1.0
// ValueSet Extensible

  public static Extension makeVSExtensible(boolean value) {
    return new Extension(ExtensionConstants.EXT_VSEXTENSIBLE).setValue(new BooleanType(value));
  }

  public static ValueSet setVSExtensible(ValueSet context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSEXTENSIBLE, new BooleanType(value));
    return context;
  }

  public static Boolean getVSExtensible(ValueSet context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_VSEXTENSIBLE);
  }

// -- VSKeyword -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-keyWord|0.1.0
// ValueSet Keyword

  public static Extension makeVSKeyword(String value) {
    return new Extension(ExtensionConstants.EXT_VSKEYWORD).setValue(new StringType(value));
  }

  public static ValueSet addVSKeyword(ValueSet context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VSKEYWORD, new StringType(value));
    return context;
  }

  public static List<String> getVSKeywordList(ValueSet context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_VSKEYWORD);
  }

// -- VSLabel -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-label|0.1.0
// ValueSet Label

  public static Extension makeVSLabel(String value) {
    return new Extension(ExtensionConstants.EXT_VSLABEL).setValue(new StringType(value));
  }

// -- VSMap -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-map|0.1.0
// ValueSet Map

  public static Extension makeVSMap(String value) {
    return new Extension(ExtensionConstants.EXT_VSMAP).setValue(new CanonicalType(value));
  }

  public static ValueSet setVSMap(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSMAP, new CanonicalType(value));
    return context;
  }

  public static String getVSMap(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSMAP);
  }

// -- VSParameterSource -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-parameterSource|0.1.0
// ValueSet Parameter Source

  public static Extension makeVSParameterSource(String value) {
    return new Extension(ExtensionConstants.EXT_VSPARAMETER_SOURCE).setValue(new CodeType(value));
  }

// -- VSReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-reference|0.1.0
// ValueSet Reference

  public static Extension makeVSReference(String value) {
    return new Extension(ExtensionConstants.EXT_VSREFERENCE).setValue(new UriType(value));
  }

  public static Coding setVSReference(Coding context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSREFERENCE, new UriType(value));
    return context;
  }

  public static String getVSReference(Coding context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSREFERENCE);
  }

// -- VSRulesText -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-rules-text|0.1.0
// ValueSet Rules Text

  public static Extension makeVSRulesText(String value) {
    return new Extension(ExtensionConstants.EXT_VSRULES_TEXT).setValue(new MarkdownType(value));
  }

  public static ValueSet setVSRulesText(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSRULES_TEXT, new MarkdownType(value));
    return context;
  }

  public static String getVSRulesText(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSRULES_TEXT);
  }

// -- VSSourceReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-sourceReference|0.1.0
// ValueSet Source Reference

  public static Extension makeVSSourceReference(String value) {
    return new Extension(ExtensionConstants.EXT_VSSOURCE_REFERENCE).setValue(new UriType(value));
  }

  public static ValueSet setVSSourceReference(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSSOURCE_REFERENCE, new UriType(value));
    return context;
  }

  public static String getVSSourceReference(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSSOURCE_REFERENCE);
  }

// -- VSSpecialStatus -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-special-status|0.1.0
// ValueSet Special Status

  public static Extension makeVSSpecialStatus(String value) {
    return new Extension(ExtensionConstants.EXT_VSSPECIAL_STATUS).setValue(new StringType(value));
  }

  public static CodeSystem setVSSpecialStatus(CodeSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSSPECIAL_STATUS, new StringType(value));
    return context;
  }

  public static String getVSSpecialStatus(CodeSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSSPECIAL_STATUS);
  }

  public static ValueSet setVSSpecialStatus(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSSPECIAL_STATUS, new StringType(value));
    return context;
  }

  public static String getVSSpecialStatus(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSSPECIAL_STATUS);
  }

// -- VSSupplement -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-supplement|0.1.0
// ValueSet Supplement

  public static Extension makeVSSupplement(String value) {
    return new Extension(ExtensionConstants.EXT_VSSUPPLEMENT).setValue(new CanonicalType(value));
  }

  public static ValueSet addVSSupplement(ValueSet context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VSSUPPLEMENT, new CanonicalType(value));
    return context;
  }

  public static List<String> getVSSupplementList(ValueSet context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_VSSUPPLEMENT);
  }

// -- VSSystem -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-system|0.1.0
// ValueSet System

  public static Extension makeVSSystem(String value) {
    return new Extension(ExtensionConstants.EXT_VSSYSTEM).setValue(new CanonicalType(value));
  }

// -- VSSystemName -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-systemName|0.1.0
// ValueSet System Name

  public static Extension makeVSSystemName(String value) {
    return new Extension(ExtensionConstants.EXT_VSSYSTEM_NAME).setValue(new StringType(value));
  }

// -- VSSystemReference -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-systemRef|0.1.0
// ValueSet System Reference

  public static Extension makeVSSystemReference(String value) {
    return new Extension(ExtensionConstants.EXT_VSSYSTEM_REFERENCE).setValue(new UriType(value));
  }

// -- VSSystemTitle -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-systemTitle|0.1.0
// Value Set System Title

  public static Extension makeVSSystemTitle(String value) {
    return new Extension(ExtensionConstants.EXT_VSSYSTEM_TITLE).setValue(new StringType(value));
  }

// -- VSToocostly -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-toocostly|0.1.0
// Valueset Too Costly (Expansion Truncated)

  public static Extension makeVSToocostly(boolean value) {
    return new Extension(ExtensionConstants.EXT_VSTOOCOSTLY).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent setVSToocostly(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSTOOCOSTLY, new BooleanType(value));
    return context;
  }

  public static Boolean getVSToocostly(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_VSTOOCOSTLY);
  }

// -- VSTrustedExpansion -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-trusted-expansion|0.1.0
// Valueset Trusted Expansion

  public static Extension makeVSTrustedExpansion(String value) {
    return new Extension(ExtensionConstants.EXT_VSTRUSTED_EXPANSION).setValue(new UrlType(value));
  }

  public static ValueSet addVSTrustedExpansion(ValueSet context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VSTRUSTED_EXPANSION, new UrlType(value));
    return context;
  }

  public static List<String> getVSTrustedExpansionList(ValueSet context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_VSTRUSTED_EXPANSION);
  }

// -- VSUnclosed -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-unclosed|0.1.0
// ValueSet Unclosed

  public static Extension makeVSUnclosed(boolean value) {
    return new Extension(ExtensionConstants.EXT_VSUNCLOSED).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent setVSUnclosed(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSUNCLOSED, new BooleanType(value));
    return context;
  }

  public static Boolean getVSUnclosed(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_VSUNCLOSED);
  }

// -- VSWarning -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-warning|0.1.0
// ValueSet Warning

  public static Extension makeVSWarning(String value) {
    return new Extension(ExtensionConstants.EXT_VSWARNING).setValue(new MarkdownType(value));
  }

  public static ValueSet setVSWarning(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_VSWARNING, new MarkdownType(value));
    return context;
  }

  public static String getVSWarning(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_VSWARNING);
  }

// -- WorkflowStatusDescription -------------------------------------
// http://hl7.org/fhir/StructureDefinition/valueset-workflowStatusDescription|0.1.0
// Workflow Status Description

  public static Extension makeWorkflowStatusDescription(String value) {
    return new Extension(ExtensionConstants.EXT_WORKFLOW_STATUS_DESCRIPTION).setValue(new StringType(value));
  }

  public static ValueSet setWorkflowStatusDescription(ValueSet context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_WORKFLOW_STATUS_DESCRIPTION, new StringType(value));
    return context;
  }

  public static String getWorkflowStatusDescription(ValueSet context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_WORKFLOW_STATUS_DESCRIPTION);
  }

// -- Variable -------------------------------------
// http://hl7.org/fhir/StructureDefinition/variable|0.1.0
// Variable

  public static Extension makeVariable(Expression value) {
    return new Extension(ExtensionConstants.EXT_VARIABLE).setValue(value);
  }

  public static ActivityDefinition addVariable(ActivityDefinition context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(ActivityDefinition context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static Measure addVariable(Measure context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(Measure context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static PlanDefinition addVariable(PlanDefinition context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(PlanDefinition context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static Questionnaire addVariable(Questionnaire context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(Questionnaire context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static RequestOrchestration addVariable(RequestOrchestration context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupComponent addVariable(org.hl7.fhir.r5.model.Measure.MeasureGroupComponent context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(org.hl7.fhir.r5.model.Measure.MeasureGroupComponent context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent addVariable(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent addVariable(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

  public static org.hl7.fhir.r5.model.RequestOrchestration.RequestOrchestrationActionComponent addVariable(org.hl7.fhir.r5.model.RequestOrchestration.RequestOrchestrationActionComponent context, Expression value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VARIABLE, value);
    return context;
  }

  public static List<Expression> getVariableList(org.hl7.fhir.r5.model.RequestOrchestration.RequestOrchestrationActionComponent context) {
    return ExtensionsUtils.getExtensionList(Expression.class, context, ExtensionConstants.EXT_VARIABLE);
  }

// -- AdheresTo -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-adheresTo|0.1.0
// adheres to

  public static Extension makeAdheresToCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_ADHERES_TO).setValue(new CanonicalType(value));
  }

  public static Extension makeAdheresTo(Reference value) {
    return new Extension(ExtensionConstants.EXT_ADHERES_TO).setValue(value);
  }

  public static Extension makeAdheresToUri(String value) {
    return new Extension(ExtensionConstants.EXT_ADHERES_TO).setValue(new UriType(value));
  }

  public static Communication addAdheresToCanonical(Communication context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(Communication context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Communication addAdheresTo(Communication context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(Communication context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Communication addAdheresToUri(Communication context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static Condition addAdheresToCanonical(Condition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(Condition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Condition addAdheresTo(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Condition addAdheresToUri(Condition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static DiagnosticReport addAdheresToCanonical(DiagnosticReport context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static DiagnosticReport addAdheresTo(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static DiagnosticReport addAdheresToUri(DiagnosticReport context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static DocumentReference addAdheresToCanonical(DocumentReference context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(DocumentReference context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static DocumentReference addAdheresTo(DocumentReference context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(DocumentReference context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static DocumentReference addAdheresToUri(DocumentReference context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static Encounter addAdheresToCanonical(Encounter context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(Encounter context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Encounter addAdheresTo(Encounter context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(Encounter context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Encounter addAdheresToUri(Encounter context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static FamilyMemberHistory addAdheresToCanonical(FamilyMemberHistory context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static FamilyMemberHistory addAdheresTo(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static FamilyMemberHistory addAdheresToUri(FamilyMemberHistory context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static Immunization addAdheresToCanonical(Immunization context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(Immunization context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Immunization addAdheresTo(Immunization context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(Immunization context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Immunization addAdheresToUri(Immunization context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static ImmunizationEvaluation addAdheresToCanonical(ImmunizationEvaluation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(ImmunizationEvaluation context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static ImmunizationEvaluation addAdheresTo(ImmunizationEvaluation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(ImmunizationEvaluation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static ImmunizationEvaluation addAdheresToUri(ImmunizationEvaluation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static Observation addAdheresToCanonical(Observation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(Observation context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Observation addAdheresTo(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static Observation addAdheresToUri(Observation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static QuestionnaireResponse addAdheresToCanonical(QuestionnaireResponse context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static QuestionnaireResponse addAdheresTo(QuestionnaireResponse context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static QuestionnaireResponse addAdheresToUri(QuestionnaireResponse context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

  public static SupplyDelivery addAdheresToCanonical(SupplyDelivery context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new CanonicalType(value));
    return context;
  }

  public static List<String> getAdheresToStringList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static SupplyDelivery addAdheresTo(SupplyDelivery context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, value);
    return context;
  }

  public static List<Reference> getAdheresToReferenceList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_ADHERES_TO);
  }

  public static SupplyDelivery addAdheresToUri(SupplyDelivery context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ADHERES_TO, new UriType(value));
    return context;
  }

// -- WorkflowBarrier -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-barrier|0.1.0
// Workflow Barrier

  public static Extension makeWorkflowBarrier(CodeableReference value) {
    return new Extension(ExtensionConstants.EXT_WORKFLOW_BARRIER).setValue(value);
  }

  public static CommunicationRequest addWorkflowBarrier(CommunicationRequest context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_BARRIER, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowBarrierList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_BARRIER);
  }

  public static Goal addWorkflowBarrier(Goal context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_BARRIER, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowBarrierList(Goal context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_BARRIER);
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent addWorkflowBarrier(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_BARRIER, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowBarrierList(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_BARRIER);
  }

// -- CompliesWith -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-compliesWith|0.1.0
// complies with

  public static Extension makeCompliesWithCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_COMPLIES_WITH).setValue(new CanonicalType(value));
  }

  public static Extension makeCompliesWith(Reference value) {
    return new Extension(ExtensionConstants.EXT_COMPLIES_WITH).setValue(value);
  }

  public static Extension makeCompliesWithUri(String value) {
    return new Extension(ExtensionConstants.EXT_COMPLIES_WITH).setValue(new UriType(value));
  }

  public static CarePlan addCompliesWithCanonical(CarePlan context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(CarePlan context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static CarePlan addCompliesWith(CarePlan context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(CarePlan context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static CarePlan addCompliesWithUri(CarePlan context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static CommunicationRequest addCompliesWithCanonical(CommunicationRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static CommunicationRequest addCompliesWith(CommunicationRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static CommunicationRequest addCompliesWithUri(CommunicationRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static DeviceRequest addCompliesWithCanonical(DeviceRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(DeviceRequest context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static DeviceRequest addCompliesWith(DeviceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(DeviceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static DeviceRequest addCompliesWithUri(DeviceRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static ImmunizationRecommendation addCompliesWithCanonical(ImmunizationRecommendation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(ImmunizationRecommendation context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static ImmunizationRecommendation addCompliesWith(ImmunizationRecommendation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(ImmunizationRecommendation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static ImmunizationRecommendation addCompliesWithUri(ImmunizationRecommendation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static NutritionOrder addCompliesWithCanonical(NutritionOrder context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static NutritionOrder addCompliesWith(NutritionOrder context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static NutritionOrder addCompliesWithUri(NutritionOrder context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static RequestOrchestration addCompliesWithCanonical(RequestOrchestration context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static RequestOrchestration addCompliesWith(RequestOrchestration context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static RequestOrchestration addCompliesWithUri(RequestOrchestration context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static ServiceRequest addCompliesWithCanonical(ServiceRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static ServiceRequest addCompliesWith(ServiceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static ServiceRequest addCompliesWithUri(ServiceRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static SupplyRequest addCompliesWithCanonical(SupplyRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(SupplyRequest context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static SupplyRequest addCompliesWith(SupplyRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(SupplyRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static SupplyRequest addCompliesWithUri(SupplyRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

  public static Task addCompliesWithCanonical(Task context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getCompliesWithStringList(Task context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static Task addCompliesWith(Task context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, value);
    return context;
  }

  public static List<Reference> getCompliesWithReferenceList(Task context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_COMPLIES_WITH);
  }

  public static Task addCompliesWithUri(Task context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_COMPLIES_WITH, new UriType(value));
    return context;
  }

// -- EpisodeOfCare -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-episodeOfCare|0.1.0
// episode of care

  public static Extension makeEpisodeOfCare(Reference value) {
    return new Extension(ExtensionConstants.EXT_EPISODE_OF_CARE).setValue(value);
  }

  public static AdverseEvent addEpisodeOfCare(AdverseEvent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(AdverseEvent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Appointment addEpisodeOfCare(Appointment context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Appointment context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Basic addEpisodeOfCare(Basic context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Basic context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static CarePlan addEpisodeOfCare(CarePlan context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(CarePlan context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ChargeItem addEpisodeOfCare(ChargeItem context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ChargeItem context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ClinicalImpression addEpisodeOfCare(ClinicalImpression context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ClinicalImpression context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Communication addEpisodeOfCare(Communication context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Communication context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static CommunicationRequest addEpisodeOfCare(CommunicationRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Composition addEpisodeOfCare(Composition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Composition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Condition addEpisodeOfCare(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Consent addEpisodeOfCare(Consent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Consent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static DetectedIssue addEpisodeOfCare(DetectedIssue context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(DetectedIssue context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static DeviceRequest addEpisodeOfCare(DeviceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(DeviceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static DeviceUsage addEpisodeOfCare(DeviceUsage context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(DeviceUsage context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static DiagnosticReport addEpisodeOfCare(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static DocumentReference addEpisodeOfCare(DocumentReference context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(DocumentReference context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Encounter addEpisodeOfCare(Encounter context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Encounter context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static EnrollmentRequest addEpisodeOfCare(EnrollmentRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(EnrollmentRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static EnrollmentResponse addEpisodeOfCare(EnrollmentResponse context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(EnrollmentResponse context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static FamilyMemberHistory addEpisodeOfCare(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Flag addEpisodeOfCare(Flag context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Flag context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Goal addEpisodeOfCare(Goal context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Goal context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ImagingStudy addEpisodeOfCare(ImagingStudy context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ImagingStudy context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Immunization addEpisodeOfCare(Immunization context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Immunization context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ImmunizationEvaluation addEpisodeOfCare(ImmunizationEvaluation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ImmunizationEvaluation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ImmunizationRecommendation addEpisodeOfCare(ImmunizationRecommendation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ImmunizationRecommendation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Invoice addEpisodeOfCare(Invoice context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Invoice context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ListResource addEpisodeOfCare(ListResource context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ListResource context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static MeasureReport addEpisodeOfCare(MeasureReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(MeasureReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static MedicationAdministration addEpisodeOfCare(MedicationAdministration context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(MedicationAdministration context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static MedicationDispense addEpisodeOfCare(MedicationDispense context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(MedicationDispense context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static MedicationRequest addEpisodeOfCare(MedicationRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(MedicationRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static MedicationStatement addEpisodeOfCare(MedicationStatement context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(MedicationStatement context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static MolecularSequence addEpisodeOfCare(MolecularSequence context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(MolecularSequence context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static NutritionIntake addEpisodeOfCare(NutritionIntake context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(NutritionIntake context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static NutritionOrder addEpisodeOfCare(NutritionOrder context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Observation addEpisodeOfCare(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static Procedure addEpisodeOfCare(Procedure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(Procedure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static QuestionnaireResponse addEpisodeOfCare(QuestionnaireResponse context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static RequestOrchestration addEpisodeOfCare(RequestOrchestration context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ResearchSubject addEpisodeOfCare(ResearchSubject context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ResearchSubject context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static RiskAssessment addEpisodeOfCare(RiskAssessment context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(RiskAssessment context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static ServiceRequest addEpisodeOfCare(ServiceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static SupplyDelivery addEpisodeOfCare(SupplyDelivery context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static SupplyRequest addEpisodeOfCare(SupplyRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(SupplyRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

  public static VisionPrescription addEpisodeOfCare(VisionPrescription context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EPISODE_OF_CARE, value);
    return context;
  }

  public static List<Reference> getEpisodeOfCareList(VisionPrescription context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_EPISODE_OF_CARE);
  }

// -- FollowOnOf -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-followOnOf|0.1.0
// follow on of

  public static Extension makeFollowOnOf(Reference value) {
    return new Extension(ExtensionConstants.EXT_FOLLOW_ON_OF).setValue(value);
  }

  public static DeviceRequest addFollowOnOf(DeviceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FOLLOW_ON_OF, value);
    return context;
  }

  public static List<Reference> getFollowOnOfList(DeviceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FOLLOW_ON_OF);
  }

  public static Encounter addFollowOnOf(Encounter context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FOLLOW_ON_OF, value);
    return context;
  }

  public static List<Reference> getFollowOnOfList(Encounter context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FOLLOW_ON_OF);
  }

  public static Procedure addFollowOnOf(Procedure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FOLLOW_ON_OF, value);
    return context;
  }

  public static List<Reference> getFollowOnOfList(Procedure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FOLLOW_ON_OF);
  }

  public static ServiceRequest addFollowOnOf(ServiceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FOLLOW_ON_OF, value);
    return context;
  }

  public static List<Reference> getFollowOnOfList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FOLLOW_ON_OF);
  }

  public static Task addFollowOnOf(Task context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_FOLLOW_ON_OF, value);
    return context;
  }

  public static List<Reference> getFollowOnOfList(Task context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_FOLLOW_ON_OF);
  }

// -- GeneratedFrom -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-generatedFrom|0.1.0
// generated from

  public static Extension makeGeneratedFrom(String value) {
    return new Extension(ExtensionConstants.EXT_GENERATED_FROM).setValue(new CanonicalType(value));
  }

  public static CarePlan setGeneratedFrom(CarePlan context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(CarePlan context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static CommunicationRequest setGeneratedFrom(CommunicationRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static DeviceRequest setGeneratedFrom(DeviceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(DeviceRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static ImmunizationEvaluation setGeneratedFrom(ImmunizationEvaluation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(ImmunizationEvaluation context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static ImmunizationRecommendation setGeneratedFrom(ImmunizationRecommendation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(ImmunizationRecommendation context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static NutritionOrder setGeneratedFrom(NutritionOrder context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(NutritionOrder context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static RequestOrchestration setGeneratedFrom(RequestOrchestration context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static ServiceRequest setGeneratedFrom(ServiceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(ServiceRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static SupplyRequest setGeneratedFrom(SupplyRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(SupplyRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

  public static Task setGeneratedFrom(Task context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_GENERATED_FROM, new CanonicalType(value));
    return context;
  }

  public static String getGeneratedFrom(Task context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_GENERATED_FROM);
  }

// -- ProtectiveFactor -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-protectiveFactor|0.1.0
// protective factor

  public static Extension makeProtectiveFactor(CodeableReference value) {
    return new Extension(ExtensionConstants.EXT_PROTECTIVE_FACTOR).setValue(value);
  }

  public static CommunicationRequest addProtectiveFactor(CommunicationRequest context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PROTECTIVE_FACTOR, value);
    return context;
  }

  public static List<CodeableReference> getProtectiveFactorList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_PROTECTIVE_FACTOR);
  }

  public static Goal addProtectiveFactor(Goal context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PROTECTIVE_FACTOR, value);
    return context;
  }

  public static List<CodeableReference> getProtectiveFactorList(Goal context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_PROTECTIVE_FACTOR);
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent addProtectiveFactor(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PROTECTIVE_FACTOR, value);
    return context;
  }

  public static List<CodeableReference> getProtectiveFactorList(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_PROTECTIVE_FACTOR);
  }

// -- WorkflowReason -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-reason|0.1.0
// Workflow Reason

  public static Extension makeWorkflowReason(CodeableReference value) {
    return new Extension(ExtensionConstants.EXT_WORKFLOW_REASON).setValue(value);
  }

  public static DiagnosticReport addWorkflowReason(DiagnosticReport context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_REASON, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowReasonList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_REASON);
  }

  public static DocumentReference addWorkflowReason(DocumentReference context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_REASON, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowReasonList(DocumentReference context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_REASON);
  }

  public static NutritionOrder addWorkflowReason(NutritionOrder context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_REASON, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowReasonList(NutritionOrder context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_REASON);
  }

  public static Observation addWorkflowReason(Observation context, CodeableReference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_WORKFLOW_REASON, value);
    return context;
  }

  public static List<CodeableReference> getWorkflowReasonList(Observation context) {
    return ExtensionsUtils.getExtensionList(CodeableReference.class, context, ExtensionConstants.EXT_WORKFLOW_REASON);
  }

// -- RelatedArtifact -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-relatedArtifact|0.1.0
// related artifact

  public static Extension makeRelatedArtifact(RelatedArtifact value) {
    return new Extension(ExtensionConstants.EXT_RELATED_ARTIFACT).setValue(value);
  }

  public static ConceptMap addRelatedArtifact(ConceptMap context, RelatedArtifact value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RELATED_ARTIFACT, value);
    return context;
  }

  public static List<RelatedArtifact> getRelatedArtifactList(ConceptMap context) {
    return ExtensionsUtils.getExtensionList(RelatedArtifact.class, context, ExtensionConstants.EXT_RELATED_ARTIFACT);
  }

  public static DiagnosticReport addRelatedArtifact(DiagnosticReport context, RelatedArtifact value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RELATED_ARTIFACT, value);
    return context;
  }

  public static List<RelatedArtifact> getRelatedArtifactList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(RelatedArtifact.class, context, ExtensionConstants.EXT_RELATED_ARTIFACT);
  }

  public static Observation addRelatedArtifact(Observation context, RelatedArtifact value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RELATED_ARTIFACT, value);
    return context;
  }

  public static List<RelatedArtifact> getRelatedArtifactList(Observation context) {
    return ExtensionsUtils.getExtensionList(RelatedArtifact.class, context, ExtensionConstants.EXT_RELATED_ARTIFACT);
  }

// -- ReleaseDate -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-releaseDate|0.1.0
// release date

  public static Extension makeReleaseDate(String value) {
    return new Extension(ExtensionConstants.EXT_RELEASE_DATE).setValue(new DateTimeType(value));
  }

  public static Account setReleaseDate(Account context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Account context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Appointment setReleaseDate(Appointment context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Appointment context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static ArtifactAssessment setReleaseDate(ArtifactAssessment context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(ArtifactAssessment context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static CarePlan setReleaseDate(CarePlan context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(CarePlan context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static ClinicalImpression setReleaseDate(ClinicalImpression context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(ClinicalImpression context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Communication setReleaseDate(Communication context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Communication context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static CommunicationRequest setReleaseDate(CommunicationRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Contract setReleaseDate(Contract context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Contract context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static DeviceDispense setReleaseDate(DeviceDispense context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(DeviceDispense context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static DeviceRequest setReleaseDate(DeviceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(DeviceRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static DeviceUsage setReleaseDate(DeviceUsage context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(DeviceUsage context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Encounter setReleaseDate(Encounter context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Encounter context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Endpoint setReleaseDate(Endpoint context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Endpoint context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static EpisodeOfCare setReleaseDate(EpisodeOfCare context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(EpisodeOfCare context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Goal setReleaseDate(Goal context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Goal context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static MedicationAdministration setReleaseDate(MedicationAdministration context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(MedicationAdministration context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static MedicationDispense setReleaseDate(MedicationDispense context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(MedicationDispense context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static MedicationRequest setReleaseDate(MedicationRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(MedicationRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static NutritionIntake setReleaseDate(NutritionIntake context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(NutritionIntake context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static NutritionOrder setReleaseDate(NutritionOrder context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(NutritionOrder context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Procedure setReleaseDate(Procedure context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Procedure context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static RequestOrchestration setReleaseDate(RequestOrchestration context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static ServiceRequest setReleaseDate(ServiceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(ServiceRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static SupplyRequest setReleaseDate(SupplyRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(SupplyRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static Task setReleaseDate(Task context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(Task context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent setReleaseDate(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RELEASE_DATE, new DateTimeType(value));
    return context;
  }

  public static String getReleaseDate(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RELEASE_DATE);
  }

// -- ResearchStudy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-researchStudy|0.1.0
// research study

  public static Extension makeResearchStudy(Reference value) {
    return new Extension(ExtensionConstants.EXT_RESEARCH_STUDY).setValue(value);
  }

  public static Composition addResearchStudy(Composition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Composition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static Consent addResearchStudy(Consent context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Consent context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static DeviceUsage addResearchStudy(DeviceUsage context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(DeviceUsage context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static DiagnosticReport addResearchStudy(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static DocumentReference addResearchStudy(DocumentReference context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(DocumentReference context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static Encounter addResearchStudy(Encounter context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Encounter context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static FamilyMemberHistory addResearchStudy(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static Immunization addResearchStudy(Immunization context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Immunization context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static MedicationAdministration addResearchStudy(MedicationAdministration context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(MedicationAdministration context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static MedicationDispense addResearchStudy(MedicationDispense context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(MedicationDispense context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static MedicationStatement addResearchStudy(MedicationStatement context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(MedicationStatement context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static Observation addResearchStudy(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static Procedure addResearchStudy(Procedure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Procedure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static QuestionnaireResponse addResearchStudy(QuestionnaireResponse context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static RiskAssessment addResearchStudy(RiskAssessment context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(RiskAssessment context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static ServiceRequest addResearchStudy(ServiceRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(ServiceRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static SupplyDelivery addResearchStudy(SupplyDelivery context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

  public static Task addResearchStudy(Task context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_RESEARCH_STUDY, value);
    return context;
  }

  public static List<Reference> getResearchStudyList(Task context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_RESEARCH_STUDY);
  }

// -- ShallComplyWith -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-shallComplyWith|0.1.0
// shall comply with

  public static Extension makeShallComplyWithCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_SHALL_COMPLY_WITH).setValue(new CanonicalType(value));
  }

  public static Extension makeShallComplyWith(Reference value) {
    return new Extension(ExtensionConstants.EXT_SHALL_COMPLY_WITH).setValue(value);
  }

  public static Extension makeShallComplyWithUri(String value) {
    return new Extension(ExtensionConstants.EXT_SHALL_COMPLY_WITH).setValue(new UriType(value));
  }

  public static ActivityDefinition addShallComplyWithCanonical(ActivityDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(ActivityDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static ActivityDefinition addShallComplyWith(ActivityDefinition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(ActivityDefinition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static ActivityDefinition addShallComplyWithUri(ActivityDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static CommunicationRequest addShallComplyWithCanonical(CommunicationRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static CommunicationRequest addShallComplyWith(CommunicationRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static CommunicationRequest addShallComplyWithUri(CommunicationRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static Condition addShallComplyWithCanonical(Condition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(Condition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static Condition addShallComplyWith(Condition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(Condition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static Condition addShallComplyWithUri(Condition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static DiagnosticReport addShallComplyWithCanonical(DiagnosticReport context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static DiagnosticReport addShallComplyWith(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static DiagnosticReport addShallComplyWithUri(DiagnosticReport context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static DocumentReference addShallComplyWithCanonical(DocumentReference context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(DocumentReference context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static DocumentReference addShallComplyWith(DocumentReference context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(DocumentReference context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static DocumentReference addShallComplyWithUri(DocumentReference context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static Measure addShallComplyWithCanonical(Measure context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(Measure context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static Measure addShallComplyWith(Measure context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(Measure context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static Measure addShallComplyWithUri(Measure context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static Observation addShallComplyWithCanonical(Observation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(Observation context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static Observation addShallComplyWith(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static Observation addShallComplyWithUri(Observation context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static OperationDefinition addShallComplyWithCanonical(OperationDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(OperationDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static OperationDefinition addShallComplyWith(OperationDefinition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(OperationDefinition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static OperationDefinition addShallComplyWithUri(OperationDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static PlanDefinition addShallComplyWithCanonical(PlanDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(PlanDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static PlanDefinition addShallComplyWith(PlanDefinition context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(PlanDefinition context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static PlanDefinition addShallComplyWithUri(PlanDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static SupplyDelivery addShallComplyWithCanonical(SupplyDelivery context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static SupplyDelivery addShallComplyWith(SupplyDelivery context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static SupplyDelivery addShallComplyWithUri(SupplyDelivery context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

  public static SupplyRequest addShallComplyWithCanonical(SupplyRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new CanonicalType(value));
    return context;
  }

  public static List<String> getShallComplyWithStringList(SupplyRequest context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static SupplyRequest addShallComplyWith(SupplyRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, value);
    return context;
  }

  public static List<Reference> getShallComplyWithReferenceList(SupplyRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SHALL_COMPLY_WITH);
  }

  public static SupplyRequest addShallComplyWithUri(SupplyRequest context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SHALL_COMPLY_WITH, new UriType(value));
    return context;
  }

// -- SupportingInfo -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-supportingInfo|0.1.0
// supporting info

  public static Extension makeSupportingInfo(Reference value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTING_INFO).setValue(value);
  }

  public static CommunicationRequest addSupportingInfo(CommunicationRequest context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SUPPORTING_INFO, value);
    return context;
  }

  public static List<Reference> getSupportingInfoList(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SUPPORTING_INFO);
  }

  public static DiagnosticReport addSupportingInfo(DiagnosticReport context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SUPPORTING_INFO, value);
    return context;
  }

  public static List<Reference> getSupportingInfoList(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SUPPORTING_INFO);
  }

  public static DocumentReference addSupportingInfo(DocumentReference context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SUPPORTING_INFO, value);
    return context;
  }

  public static List<Reference> getSupportingInfoList(DocumentReference context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SUPPORTING_INFO);
  }

  public static Encounter addSupportingInfo(Encounter context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SUPPORTING_INFO, value);
    return context;
  }

  public static List<Reference> getSupportingInfoList(Encounter context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SUPPORTING_INFO);
  }

  public static Observation addSupportingInfo(Observation context, Reference value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_SUPPORTING_INFO, value);
    return context;
  }

  public static List<Reference> getSupportingInfoList(Observation context) {
    return ExtensionsUtils.getExtensionList(Reference.class, context, ExtensionConstants.EXT_SUPPORTING_INFO);
  }

// -- TriggeredBy -------------------------------------
// http://hl7.org/fhir/StructureDefinition/workflow-triggeredBy|0.1.0
// triggered by

  public static Extension makeTriggeredByCanonical(String value) {
    return new Extension(ExtensionConstants.EXT_TRIGGERED_BY).setValue(new CanonicalType(value));
  }

  public static Extension makeTriggeredBy(Reference value) {
    return new Extension(ExtensionConstants.EXT_TRIGGERED_BY).setValue(value);
  }

  public static Extension makeTriggeredByUri(String value) {
    return new Extension(ExtensionConstants.EXT_TRIGGERED_BY).setValue(new UriType(value));
  }

  public static CarePlan setTriggeredByCanonical(CarePlan context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(CarePlan context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static CarePlan setTriggeredBy(CarePlan context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(CarePlan context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static CarePlan setTriggeredByUri(CarePlan context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static Communication setTriggeredByCanonical(Communication context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(Communication context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Communication setTriggeredBy(Communication context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(Communication context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Communication setTriggeredByUri(Communication context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static CommunicationRequest setTriggeredByCanonical(CommunicationRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(CommunicationRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static CommunicationRequest setTriggeredBy(CommunicationRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(CommunicationRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static CommunicationRequest setTriggeredByUri(CommunicationRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static Condition setTriggeredByCanonical(Condition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(Condition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Condition setTriggeredBy(Condition context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(Condition context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Condition setTriggeredByUri(Condition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static DeviceRequest setTriggeredByCanonical(DeviceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(DeviceRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static DeviceRequest setTriggeredBy(DeviceRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(DeviceRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static DeviceRequest setTriggeredByUri(DeviceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static DiagnosticReport setTriggeredByCanonical(DiagnosticReport context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(DiagnosticReport context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static DiagnosticReport setTriggeredBy(DiagnosticReport context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(DiagnosticReport context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static DiagnosticReport setTriggeredByUri(DiagnosticReport context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static DocumentReference setTriggeredByCanonical(DocumentReference context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(DocumentReference context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static DocumentReference setTriggeredBy(DocumentReference context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(DocumentReference context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static DocumentReference setTriggeredByUri(DocumentReference context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static Encounter setTriggeredByCanonical(Encounter context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(Encounter context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Encounter setTriggeredBy(Encounter context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(Encounter context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Encounter setTriggeredByUri(Encounter context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static FamilyMemberHistory setTriggeredByCanonical(FamilyMemberHistory context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static FamilyMemberHistory setTriggeredBy(FamilyMemberHistory context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(FamilyMemberHistory context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static FamilyMemberHistory setTriggeredByUri(FamilyMemberHistory context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static Immunization setTriggeredByCanonical(Immunization context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(Immunization context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Immunization setTriggeredBy(Immunization context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(Immunization context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Immunization setTriggeredByUri(Immunization context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static ImmunizationRecommendation setTriggeredByCanonical(ImmunizationRecommendation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(ImmunizationRecommendation context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static ImmunizationRecommendation setTriggeredBy(ImmunizationRecommendation context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(ImmunizationRecommendation context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static ImmunizationRecommendation setTriggeredByUri(ImmunizationRecommendation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static NutritionOrder setTriggeredByCanonical(NutritionOrder context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(NutritionOrder context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static NutritionOrder setTriggeredBy(NutritionOrder context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(NutritionOrder context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static NutritionOrder setTriggeredByUri(NutritionOrder context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static Observation setTriggeredByCanonical(Observation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(Observation context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Observation setTriggeredBy(Observation context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(Observation context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Observation setTriggeredByUri(Observation context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static QuestionnaireResponse setTriggeredByCanonical(QuestionnaireResponse context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static QuestionnaireResponse setTriggeredBy(QuestionnaireResponse context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(QuestionnaireResponse context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static QuestionnaireResponse setTriggeredByUri(QuestionnaireResponse context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static RequestOrchestration setTriggeredByCanonical(RequestOrchestration context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(RequestOrchestration context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static RequestOrchestration setTriggeredBy(RequestOrchestration context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(RequestOrchestration context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static RequestOrchestration setTriggeredByUri(RequestOrchestration context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static ServiceRequest setTriggeredByCanonical(ServiceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(ServiceRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static ServiceRequest setTriggeredBy(ServiceRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(ServiceRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static ServiceRequest setTriggeredByUri(ServiceRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static SupplyDelivery setTriggeredByCanonical(SupplyDelivery context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(SupplyDelivery context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static SupplyDelivery setTriggeredBy(SupplyDelivery context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(SupplyDelivery context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static SupplyDelivery setTriggeredByUri(SupplyDelivery context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static SupplyRequest setTriggeredByCanonical(SupplyRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(SupplyRequest context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static SupplyRequest setTriggeredBy(SupplyRequest context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(SupplyRequest context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static SupplyRequest setTriggeredByUri(SupplyRequest context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

  public static Task setTriggeredByCanonical(Task context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new CanonicalType(value));
    return context;
  }

  public static String getTriggeredByString(Task context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Task setTriggeredBy(Task context, Reference value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, value);
    return context;
  }

  public static Reference getTriggeredByReference(Task context) {
    return ExtensionsUtils.getExtension(Reference.class, context, ExtensionConstants.EXT_TRIGGERED_BY);
  }

  public static Task setTriggeredByUri(Task context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_TRIGGERED_BY, new UriType(value));
    return context;
  }

// -- BindingDefinition -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/binding-definition|0.1.0
// Binding Definition

  public static Extension makeBindingDefinition(String value) {
    return new Extension(ExtensionConstants.EXT_BINDING_DEFINITION).setValue(new MarkdownType(value));
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent addBindingDefinition(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_BINDING_DEFINITION, new MarkdownType(value));
    return context;
  }

  public static List<String> getBindingDefinitionList(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_BINDING_DEFINITION);
  }

// -- VocabBindingStylesEXT -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/binding-style|0.1.0
// Vocab Binding Style Extension

  public static Extension makeVocabBindingStylesEXT(String value) {
    return new Extension(ExtensionConstants.EXT_VOCAB_BINDING_STYLES_E_X_T).setValue(new CodeType(value));
  }

  public static StructureDefinition addVocabBindingStylesEXT(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_VOCAB_BINDING_STYLES_E_X_T, new CodeType(value));
    return context;
  }

  public static List<String> getVocabBindingStylesEXTList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_VOCAB_BINDING_STYLES_E_X_T);
  }

// -- DateFormat -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-date-format|0.1.0
// Date Format String

  public static Extension makeDateFormat(String value) {
    return new Extension(ExtensionConstants.EXT_DATE_FORMAT).setValue(new StringType(value));
  }

  public static ElementDefinition addDateFormat(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DATE_FORMAT, new StringType(value));
    return context;
  }

  public static List<String> getDateFormatList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_DATE_FORMAT);
  }

// -- JsonPropertyName -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-json-name|0.1.0
// Json Property Name Extension

  public static Extension makeJsonPropertyName(String value) {
    return new Extension(ExtensionConstants.EXT_JSON_PROPERTY_NAME).setValue(new StringType(value));
  }

  public static ElementDefinition addJsonPropertyName(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_PROPERTY_NAME, new StringType(value));
    return context;
  }

  public static List<String> getJsonPropertyNameList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_PROPERTY_NAME);
  }

// -- ExtensionStylesEXT -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/extension-style|0.1.0
// Extension Style Extension

  public static Extension makeExtensionStylesEXT(String value) {
    return new Extension(ExtensionConstants.EXT_EXTENSION_STYLES_E_X_T).setValue(new CodeType(value));
  }

  public static StructureDefinition addExtensionStylesEXT(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EXTENSION_STYLES_E_X_T, new CodeType(value));
    return context;
  }

  public static List<String> getExtensionStylesEXTList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_EXTENSION_STYLES_E_X_T);
  }

// -- IdExpectationExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/id-expectation|0.1.0
// Id Expectation Extension

  public static Extension makeIdExpectationExt(String value) {
    return new Extension(ExtensionConstants.EXT_ID_EXPECTATION_EXT).setValue(new CodeType(value));
  }

  public static ElementDefinition addIdExpectationExt(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ID_EXPECTATION_EXT, new CodeType(value));
    return context;
  }

  public static List<String> getIdExpectationExtList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ID_EXPECTATION_EXT);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent addIdExpectationExt(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ID_EXPECTATION_EXT, new CodeType(value));
    return context;
  }

  public static List<String> getIdExpectationExtList(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ID_EXPECTATION_EXT);
  }

// -- IGPageName -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-page-name|0.1.0
// IG Page Name

  public static Extension makeIGPageName(String value) {
    return new Extension(ExtensionConstants.EXT_IGPAGE_NAME).setValue(new UrlType(value));
  }

// -- IGDependencyComment -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implementationguide-dependency-comment|0.1.0
// IG Dependency Comment

  public static Extension makeIGDependencyComment(String value) {
    return new Extension(ExtensionConstants.EXT_IGDEPENDENCY_COMMENT).setValue(new MarkdownType(value));
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent addIGDependencyComment(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_IGDEPENDENCY_COMMENT, new MarkdownType(value));
    return context;
  }

  public static List<String> getIGDependencyCommentList(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_IGDEPENDENCY_COMMENT);
  }

// -- BinaryResourceFormat -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-format|0.1.0
// Binary Resource Format

  public static Extension makeBinaryResourceFormat(String value) {
    return new Extension(ExtensionConstants.EXT_BINARY_RESOURCE_FORMAT).setValue(new CodeType(value));
  }

// -- BinaryResourceLogical -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-logical|0.1.0
// Binary Resource Logical

  public static Extension makeBinaryResourceLogical(String value) {
    return new Extension(ExtensionConstants.EXT_BINARY_RESOURCE_LOGICAL).setValue(new CanonicalType(value));
  }

// -- ImpliedStringPrefix -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implied-string-prefix|0.1.0
// Implied String Prefix

  public static Extension makeImpliedStringPrefix(String value) {
    return new Extension(ExtensionConstants.EXT_IMPLIED_STRING_PREFIX).setValue(new StringType(value));
  }

  public static ElementDefinition addImpliedStringPrefix(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_IMPLIED_STRING_PREFIX, new StringType(value));
    return context;
  }

  public static List<String> getImpliedStringPrefixList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_IMPLIED_STRING_PREFIX);
  }

// -- JsonEmptyBehavior -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-empty-behavior|0.1.0
// Json Empty Behavior Extension

  public static Extension makeJsonEmptyBehavior(String value) {
    return new Extension(ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR).setValue(new CodeType(value));
  }

  public static ElementDefinition addJsonEmptyBehavior(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR, new CodeType(value));
    return context;
  }

  public static List<String> getJsonEmptyBehaviorList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent addJsonEmptyBehavior(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR, new CodeType(value));
    return context;
  }

  public static List<String> getJsonEmptyBehaviorList(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR);
  }

// -- JsonNullableExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-nullable|0.1.0
// Json Nullable Extension

  public static Extension makeJsonNullableExt(boolean value) {
    return new Extension(ExtensionConstants.EXT_JSON_NULLABLE_EXT).setValue(new BooleanType(value));
  }

  public static ElementDefinition setJsonNullableExt(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_JSON_NULLABLE_EXT, new BooleanType(value));
    return context;
  }

  public static Boolean getJsonNullableExt(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_JSON_NULLABLE_EXT);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setJsonNullableExt(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_JSON_NULLABLE_EXT, new BooleanType(value));
    return context;
  }

  public static Boolean getJsonNullableExt(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_JSON_NULLABLE_EXT);
  }

// -- JsonPrimitiveChoiceExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-primitive-choice|0.1.0
// Json Primitive Choice Extension

  public static Extension makeJsonPrimitiveChoiceExt(boolean value) {
    return new Extension(ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT).setValue(new BooleanType(value));
  }

  public static ElementDefinition setJsonPrimitiveChoiceExt(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT, new BooleanType(value));
    return context;
  }

  public static Boolean getJsonPrimitiveChoiceExt(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setJsonPrimitiveChoiceExt(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT, new BooleanType(value));
    return context;
  }

  public static Boolean getJsonPrimitiveChoiceExt(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT);
  }

// -- JsonPropertyKey -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-property-key|0.1.0
// Json Property Key Extension

  public static Extension makeJsonPropertyKey(String value) {
    return new Extension(ExtensionConstants.EXT_JSON_PROPERTY_KEY).setValue(new CodeType(value));
  }

  public static ElementDefinition addJsonPropertyKey(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_PROPERTY_KEY, new CodeType(value));
    return context;
  }

  public static List<String> getJsonPropertyKeyList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_PROPERTY_KEY);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent addJsonPropertyKey(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_PROPERTY_KEY, new CodeType(value));
    return context;
  }

  public static List<String> getJsonPropertyKeyList(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_PROPERTY_KEY);
  }

// -- NoBinding -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/no-binding|0.1.0
// No Binding Extension

  public static Extension makeNoBinding(boolean value) {
    return new Extension(ExtensionConstants.EXT_NO_BINDING).setValue(new BooleanType(value));
  }

  public static ElementDefinition setNoBinding(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NO_BINDING, new BooleanType(value));
    return context;
  }

  public static Boolean getNoBinding(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_NO_BINDING);
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent setNoBinding(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NO_BINDING, new BooleanType(value));
    return context;
  }

  public static Boolean getNoBinding(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_NO_BINDING);
  }

// -- ProfileMapping -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/profile-mapping|0.1.0
// Profile Mapping Extension

  public static Extension makeProfileMapping(DataType value) {
    return new Extension(ExtensionConstants.EXT_PROFILE_MAPPING).setValue(value);
  }

// -- ProfileSummary -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/profile-summary|0.1.0
// ProfileSummary

  public static Extension makeProfileSummary(String value) {
    return new Extension(ExtensionConstants.EXT_PROFILE_SUMMARY).setValue(new MarkdownType(value));
  }

  public static StructureDefinition addProfileSummary(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PROFILE_SUMMARY, new MarkdownType(value));
    return context;
  }

  public static List<String> getProfileSummaryList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_PROFILE_SUMMARY);
  }

// -- SelectByMap -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/select-by-map|0.1.0
// Select By Map

  public static Extension makeSelectByMap(String value) {
    return new Extension(ExtensionConstants.EXT_SELECT_BY_MAP).setValue(new CanonicalType(value));
  }

// -- SupportedConceptRelationshipInverseName -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-mif-relationship-inverseName|0.0.34
// MIF concept relationship inverse name

  public static Extension makeSupportedConceptRelationshipInverseName(String value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_INVERSE_NAME).setValue(new StringType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent setSupportedConceptRelationshipInverseName(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_INVERSE_NAME, new StringType(value));
    return context;
  }

  public static String getSupportedConceptRelationshipInverseName(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_INVERSE_NAME);
  }

// -- SupportedConceptRelationshipIsNavigable -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-mif-relationship-isNavigable|0.0.34
// MIF concept relationship is navigable

  public static Extension makeSupportedConceptRelationshipIsNavigable(boolean value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_IS_NAVIGABLE).setValue(new BooleanType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent setSupportedConceptRelationshipIsNavigable(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_IS_NAVIGABLE, new BooleanType(value));
    return context;
  }

  public static Boolean getSupportedConceptRelationshipIsNavigable(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_IS_NAVIGABLE);
  }

// -- SupportedConceptRelationshipReflexivity -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-mif-relationship-reflexivity|0.0.34
// MIF concept relationship is reflexivity

  public static Extension makeSupportedConceptRelationshipReflexivity(String value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_REFLEXIVITY).setValue(new CodeType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent setSupportedConceptRelationshipReflexivity(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_REFLEXIVITY, new CodeType(value));
    return context;
  }

  public static String getSupportedConceptRelationshipReflexivity(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_REFLEXIVITY);
  }

// -- SupportedConceptRelationshipRelationshipKind -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-mif-relationship-relationshipKind|0.0.34
// MIF concept relationship kind

  public static Extension makeSupportedConceptRelationshipRelationshipKind(String value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_RELATIONSHIP_KIND).setValue(new CodeType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent setSupportedConceptRelationshipRelationshipKind(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_RELATIONSHIP_KIND, new CodeType(value));
    return context;
  }

  public static String getSupportedConceptRelationshipRelationshipKind(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_RELATIONSHIP_KIND);
  }

// -- SupportedConceptRelationshipSymmetry -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-mif-relationship-symmetry|0.0.34
// MIF concept relationship symmetry

  public static Extension makeSupportedConceptRelationshipSymmetry(String value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_SYMMETRY).setValue(new CodeType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent setSupportedConceptRelationshipSymmetry(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_SYMMETRY, new CodeType(value));
    return context;
  }

  public static String getSupportedConceptRelationshipSymmetry(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_SYMMETRY);
  }

// -- SupportedConceptRelationshipTransitivity -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-mif-relationship-transitivity|0.0.34
// MIF concept relationship transitivity

  public static Extension makeSupportedConceptRelationshipTransitivity(String value) {
    return new Extension(ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_TRANSITIVITY).setValue(new CodeType(value));
  }

  public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent setSupportedConceptRelationshipTransitivity(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_TRANSITIVITY, new CodeType(value));
    return context;
  }

  public static String getSupportedConceptRelationshipTransitivity(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_SUPPORTED_CONCEPT_RELATIONSHIP_TRANSITIVITY);
  }

// -- NamingSystemTitle -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-namingsystem-title|0.0.34
// NamingSystem title

  public static Extension makeNamingSystemTitle(String value) {
    return new Extension(ExtensionConstants.EXT_NAMING_SYSTEM_TITLE).setValue(new StringType(value));
  }

  public static NamingSystem setNamingSystemTitle(NamingSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NAMING_SYSTEM_TITLE, new StringType(value));
    return context;
  }

  public static String getNamingSystemTitle(NamingSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NAMING_SYSTEM_TITLE);
  }

// -- NamingSystemVersion -------------------------------------
// http://terminology.hl7.org/StructureDefinition/ext-namingsystem-version|0.0.34
// NamingSystem version

  public static Extension makeNamingSystemVersion(String value) {
    return new Extension(ExtensionConstants.EXT_NAMING_SYSTEM_VERSION).setValue(new StringType(value));
  }

  public static NamingSystem setNamingSystemVersion(NamingSystem context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NAMING_SYSTEM_VERSION, new StringType(value));
    return context;
  }

  public static String getNamingSystemVersion(NamingSystem context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NAMING_SYSTEM_VERSION);
  }



}