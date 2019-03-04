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


public class ExampleScenario extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r4.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario tgt = new org.hl7.fhir.r5.model.ExampleScenario();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getWorkflow())
      tgt.getWorkflow().add(convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r5.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario tgt = new org.hl7.fhir.r4.model.ExampleScenario();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getWorkflow())
      tgt.getWorkflow().add(convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent();
    copyElement(src, tgt);
    if (src.hasActorId())
      tgt.setActorIdElement(convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setType(convertExampleScenarioActorType(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent();
    copyElement(src, tgt);
    if (src.hasActorId())
      tgt.setActorIdElement(convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setType(convertExampleScenarioActorType(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType convertExampleScenarioActorType(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PERSON: return org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.PERSON;
    case ENTITY: return org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.ENTITY;
    default: return org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType convertExampleScenarioActorType(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PERSON: return org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.PERSON;
    case ENTITY: return org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.ENTITY;
    default: return org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent();
    copyElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
    if (src.hasResourceType())
      tgt.setResourceType(convertFHIRResourceType(src.getResourceType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent();
    copyElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
    if (src.hasResourceType())
      tgt.setResourceType(convertFHIRResourceType(src.getResourceType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType convertFHIRResourceType(org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACCOUNT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ACCOUNT;
    case ACTIVITYDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ACTIVITYDEFINITION;
    case ADVERSEEVENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ADVERSEEVENT;
    case ALLERGYINTOLERANCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ALLERGYINTOLERANCE;
    case APPOINTMENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.APPOINTMENT;
    case APPOINTMENTRESPONSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.APPOINTMENTRESPONSE;
    case AUDITEVENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.AUDITEVENT;
    case BASIC: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.BASIC;
    case BINARY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.BINARY;
    case BIOLOGICALLYDERIVEDPRODUCT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.BIOLOGICALLYDERIVEDPRODUCT;
    case BODYSTRUCTURE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.BODYSTRUCTURE;
    case BUNDLE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.BUNDLE;
    case CAPABILITYSTATEMENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CAPABILITYSTATEMENT;
    case CAREPLAN: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CAREPLAN;
    case CARETEAM: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CARETEAM;
    case CATALOGENTRY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CATALOGENTRY;
    case CHARGEITEM: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CHARGEITEM;
    case CHARGEITEMDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CHARGEITEMDEFINITION;
    case CLAIM: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CLAIM;
    case CLAIMRESPONSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CLAIMRESPONSE;
    case CLINICALIMPRESSION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CLINICALIMPRESSION;
    case CODESYSTEM: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CODESYSTEM;
    case COMMUNICATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COMMUNICATION;
    case COMMUNICATIONREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COMMUNICATIONREQUEST;
    case COMPARTMENTDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COMPARTMENTDEFINITION;
    case COMPOSITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COMPOSITION;
    case CONCEPTMAP: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CONCEPTMAP;
    case CONDITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CONDITION;
    case CONSENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CONSENT;
    case CONTRACT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.CONTRACT;
    case COVERAGE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COVERAGE;
    case COVERAGEELIGIBILITYREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COVERAGEELIGIBILITYREQUEST;
    case COVERAGEELIGIBILITYRESPONSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.COVERAGEELIGIBILITYRESPONSE;
    case DETECTEDISSUE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DETECTEDISSUE;
    case DEVICE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DEVICE;
    case DEVICEDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DEVICEDEFINITION;
    case DEVICEMETRIC: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DEVICEMETRIC;
    case DEVICEREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DEVICEREQUEST;
    case DEVICEUSESTATEMENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DEVICEUSESTATEMENT;
    case DIAGNOSTICREPORT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DIAGNOSTICREPORT;
    case DOCUMENTMANIFEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DOCUMENTMANIFEST;
    case DOCUMENTREFERENCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DOCUMENTREFERENCE;
    case DOMAINRESOURCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.DOMAINRESOURCE;
    case EFFECTEVIDENCESYNTHESIS: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EFFECTEVIDENCESYNTHESIS;
    case ENCOUNTER: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ENCOUNTER;
    case ENDPOINT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ENDPOINT;
    case ENROLLMENTREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ENROLLMENTREQUEST;
    case ENROLLMENTRESPONSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ENROLLMENTRESPONSE;
    case EPISODEOFCARE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EPISODEOFCARE;
    case EVENTDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EVENTDEFINITION;
    case EVIDENCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EVIDENCE;
    case EVIDENCEVARIABLE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EVIDENCEVARIABLE;
    case EXAMPLESCENARIO: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EXAMPLESCENARIO;
    case EXPLANATIONOFBENEFIT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.EXPLANATIONOFBENEFIT;
    case FAMILYMEMBERHISTORY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.FAMILYMEMBERHISTORY;
    case FLAG: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.FLAG;
    case GOAL: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.GOAL;
    case GRAPHDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.GRAPHDEFINITION;
    case GROUP: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.GROUP;
    case GUIDANCERESPONSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.GUIDANCERESPONSE;
    case HEALTHCARESERVICE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.HEALTHCARESERVICE;
    case IMAGINGSTUDY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.IMAGINGSTUDY;
    case IMMUNIZATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.IMMUNIZATION;
    case IMMUNIZATIONEVALUATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.IMMUNIZATIONEVALUATION;
    case IMMUNIZATIONRECOMMENDATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.IMMUNIZATIONRECOMMENDATION;
    case IMPLEMENTATIONGUIDE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.IMPLEMENTATIONGUIDE;
    case INSURANCEPLAN: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.INSURANCEPLAN;
    case INVOICE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.INVOICE;
    case LIBRARY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.LIBRARY;
    case LINKAGE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.LINKAGE;
    case LIST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.LIST;
    case LOCATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.LOCATION;
    case MEASURE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEASURE;
    case MEASUREREPORT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEASUREREPORT;
    case MEDIA: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDIA;
    case MEDICATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICATION;
    case MEDICATIONADMINISTRATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICATIONADMINISTRATION;
    case MEDICATIONDISPENSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICATIONDISPENSE;
    case MEDICATIONKNOWLEDGE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICATIONKNOWLEDGE;
    case MEDICATIONREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICATIONREQUEST;
    case MEDICATIONSTATEMENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICATIONSTATEMENT;
    case MEDICINALPRODUCT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCT;
    case MEDICINALPRODUCTAUTHORIZATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTAUTHORIZATION;
    case MEDICINALPRODUCTCONTRAINDICATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTCONTRAINDICATION;
    case MEDICINALPRODUCTINDICATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTINDICATION;
    case MEDICINALPRODUCTINGREDIENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTINGREDIENT;
    case MEDICINALPRODUCTINTERACTION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTINTERACTION;
    case MEDICINALPRODUCTMANUFACTURED: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTMANUFACTURED;
    case MEDICINALPRODUCTPACKAGED: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTPACKAGED;
    case MEDICINALPRODUCTPHARMACEUTICAL: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTPHARMACEUTICAL;
    case MEDICINALPRODUCTUNDESIRABLEEFFECT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTUNDESIRABLEEFFECT;
    case MESSAGEDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MESSAGEDEFINITION;
    case MESSAGEHEADER: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MESSAGEHEADER;
    case MOLECULARSEQUENCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.MOLECULARSEQUENCE;
    case NAMINGSYSTEM: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.NAMINGSYSTEM;
    case NUTRITIONORDER: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.NUTRITIONORDER;
    case OBSERVATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.OBSERVATION;
    case OBSERVATIONDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.OBSERVATIONDEFINITION;
    case OPERATIONDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.OPERATIONDEFINITION;
    case OPERATIONOUTCOME: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.OPERATIONOUTCOME;
    case ORGANIZATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ORGANIZATION;
    case ORGANIZATIONAFFILIATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.ORGANIZATIONAFFILIATION;
    case PARAMETERS: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PARAMETERS;
    case PATIENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PATIENT;
    case PAYMENTNOTICE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PAYMENTNOTICE;
    case PAYMENTRECONCILIATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PAYMENTRECONCILIATION;
    case PERSON: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PERSON;
    case PLANDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PLANDEFINITION;
    case PRACTITIONER: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PRACTITIONER;
    case PRACTITIONERROLE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PRACTITIONERROLE;
    case PROCEDURE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PROCEDURE;
    case PROVENANCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.PROVENANCE;
    case QUESTIONNAIRE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.QUESTIONNAIRE;
    case QUESTIONNAIRERESPONSE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.QUESTIONNAIRERESPONSE;
    case RELATEDPERSON: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RELATEDPERSON;
    case REQUESTGROUP: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.REQUESTGROUP;
    case RESEARCHDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RESEARCHDEFINITION;
    case RESEARCHELEMENTDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RESEARCHELEMENTDEFINITION;
    case RESEARCHSTUDY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RESEARCHSTUDY;
    case RESEARCHSUBJECT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RESEARCHSUBJECT;
    case RESOURCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RESOURCE;
    case RISKASSESSMENT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RISKASSESSMENT;
    case RISKEVIDENCESYNTHESIS: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.RISKEVIDENCESYNTHESIS;
    case SCHEDULE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SCHEDULE;
    case SEARCHPARAMETER: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SEARCHPARAMETER;
    case SERVICEREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SERVICEREQUEST;
    case SLOT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SLOT;
    case SPECIMEN: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SPECIMEN;
    case SPECIMENDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SPECIMENDEFINITION;
    case STRUCTUREDEFINITION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.STRUCTUREDEFINITION;
    case STRUCTUREMAP: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.STRUCTUREMAP;
    case SUBSCRIPTION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSCRIPTION;
    case SUBSTANCE: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCE;
    case SUBSTANCENUCLEICACID: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCENUCLEICACID;
    case SUBSTANCEPOLYMER: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCEPOLYMER;
    case SUBSTANCEPROTEIN: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCEPROTEIN;
    case SUBSTANCEREFERENCEINFORMATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCEREFERENCEINFORMATION;
    case SUBSTANCESOURCEMATERIAL: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCESOURCEMATERIAL;
    case SUBSTANCESPECIFICATION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUBSTANCESPECIFICATION;
    case SUPPLYDELIVERY: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUPPLYDELIVERY;
    case SUPPLYREQUEST: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.SUPPLYREQUEST;
    case TASK: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.TASK;
    case TERMINOLOGYCAPABILITIES: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.TERMINOLOGYCAPABILITIES;
    case TESTREPORT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.TESTREPORT;
    case TESTSCRIPT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.TESTSCRIPT;
    case VALUESET: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.VALUESET;
    case VERIFICATIONRESULT: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.VERIFICATIONRESULT;
    case VISIONPRESCRIPTION: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.VISIONPRESCRIPTION;
    default: return org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType convertFHIRResourceType(org.hl7.fhir.r5.model.ExampleScenario.FHIRResourceType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACCOUNT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ACCOUNT;
    case ACTIVITYDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ACTIVITYDEFINITION;
    case ADVERSEEVENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ADVERSEEVENT;
    case ALLERGYINTOLERANCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ALLERGYINTOLERANCE;
    case APPOINTMENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.APPOINTMENT;
    case APPOINTMENTRESPONSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.APPOINTMENTRESPONSE;
    case AUDITEVENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.AUDITEVENT;
    case BASIC: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.BASIC;
    case BINARY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.BINARY;
    case BIOLOGICALLYDERIVEDPRODUCT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.BIOLOGICALLYDERIVEDPRODUCT;
    case BODYSTRUCTURE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.BODYSTRUCTURE;
    case BUNDLE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.BUNDLE;
    case CAPABILITYSTATEMENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CAPABILITYSTATEMENT;
    case CAREPLAN: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CAREPLAN;
    case CARETEAM: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CARETEAM;
    case CATALOGENTRY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CATALOGENTRY;
    case CHARGEITEM: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CHARGEITEM;
    case CHARGEITEMDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CHARGEITEMDEFINITION;
    case CLAIM: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CLAIM;
    case CLAIMRESPONSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CLAIMRESPONSE;
    case CLINICALIMPRESSION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CLINICALIMPRESSION;
    case CODESYSTEM: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CODESYSTEM;
    case COMMUNICATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COMMUNICATION;
    case COMMUNICATIONREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COMMUNICATIONREQUEST;
    case COMPARTMENTDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COMPARTMENTDEFINITION;
    case COMPOSITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COMPOSITION;
    case CONCEPTMAP: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CONCEPTMAP;
    case CONDITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CONDITION;
    case CONSENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CONSENT;
    case CONTRACT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.CONTRACT;
    case COVERAGE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COVERAGE;
    case COVERAGEELIGIBILITYREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COVERAGEELIGIBILITYREQUEST;
    case COVERAGEELIGIBILITYRESPONSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.COVERAGEELIGIBILITYRESPONSE;
    case DETECTEDISSUE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DETECTEDISSUE;
    case DEVICE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DEVICE;
    case DEVICEDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DEVICEDEFINITION;
    case DEVICEMETRIC: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DEVICEMETRIC;
    case DEVICEREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DEVICEREQUEST;
    case DEVICEUSESTATEMENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DEVICEUSESTATEMENT;
    case DIAGNOSTICREPORT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DIAGNOSTICREPORT;
    case DOCUMENTMANIFEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DOCUMENTMANIFEST;
    case DOCUMENTREFERENCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DOCUMENTREFERENCE;
    case DOMAINRESOURCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.DOMAINRESOURCE;
    case EFFECTEVIDENCESYNTHESIS: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EFFECTEVIDENCESYNTHESIS;
    case ENCOUNTER: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ENCOUNTER;
    case ENDPOINT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ENDPOINT;
    case ENROLLMENTREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ENROLLMENTREQUEST;
    case ENROLLMENTRESPONSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ENROLLMENTRESPONSE;
    case EPISODEOFCARE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EPISODEOFCARE;
    case EVENTDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EVENTDEFINITION;
    case EVIDENCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EVIDENCE;
    case EVIDENCEVARIABLE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EVIDENCEVARIABLE;
    case EXAMPLESCENARIO: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EXAMPLESCENARIO;
    case EXPLANATIONOFBENEFIT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.EXPLANATIONOFBENEFIT;
    case FAMILYMEMBERHISTORY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.FAMILYMEMBERHISTORY;
    case FLAG: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.FLAG;
    case GOAL: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.GOAL;
    case GRAPHDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.GRAPHDEFINITION;
    case GROUP: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.GROUP;
    case GUIDANCERESPONSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.GUIDANCERESPONSE;
    case HEALTHCARESERVICE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.HEALTHCARESERVICE;
    case IMAGINGSTUDY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.IMAGINGSTUDY;
    case IMMUNIZATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.IMMUNIZATION;
    case IMMUNIZATIONEVALUATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.IMMUNIZATIONEVALUATION;
    case IMMUNIZATIONRECOMMENDATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.IMMUNIZATIONRECOMMENDATION;
    case IMPLEMENTATIONGUIDE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.IMPLEMENTATIONGUIDE;
    case INSURANCEPLAN: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.INSURANCEPLAN;
    case INVOICE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.INVOICE;
    case LIBRARY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.LIBRARY;
    case LINKAGE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.LINKAGE;
    case LIST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.LIST;
    case LOCATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.LOCATION;
    case MEASURE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEASURE;
    case MEASUREREPORT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEASUREREPORT;
    case MEDIA: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDIA;
    case MEDICATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICATION;
    case MEDICATIONADMINISTRATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICATIONADMINISTRATION;
    case MEDICATIONDISPENSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICATIONDISPENSE;
    case MEDICATIONKNOWLEDGE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICATIONKNOWLEDGE;
    case MEDICATIONREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICATIONREQUEST;
    case MEDICATIONSTATEMENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICATIONSTATEMENT;
    case MEDICINALPRODUCT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCT;
    case MEDICINALPRODUCTAUTHORIZATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTAUTHORIZATION;
    case MEDICINALPRODUCTCONTRAINDICATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTCONTRAINDICATION;
    case MEDICINALPRODUCTINDICATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTINDICATION;
    case MEDICINALPRODUCTINGREDIENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTINGREDIENT;
    case MEDICINALPRODUCTINTERACTION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTINTERACTION;
    case MEDICINALPRODUCTMANUFACTURED: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTMANUFACTURED;
    case MEDICINALPRODUCTPACKAGED: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTPACKAGED;
    case MEDICINALPRODUCTPHARMACEUTICAL: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTPHARMACEUTICAL;
    case MEDICINALPRODUCTUNDESIRABLEEFFECT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MEDICINALPRODUCTUNDESIRABLEEFFECT;
    case MESSAGEDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MESSAGEDEFINITION;
    case MESSAGEHEADER: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MESSAGEHEADER;
    case MOLECULARSEQUENCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.MOLECULARSEQUENCE;
    case NAMINGSYSTEM: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.NAMINGSYSTEM;
    case NUTRITIONORDER: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.NUTRITIONORDER;
    case OBSERVATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.OBSERVATION;
    case OBSERVATIONDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.OBSERVATIONDEFINITION;
    case OPERATIONDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.OPERATIONDEFINITION;
    case OPERATIONOUTCOME: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.OPERATIONOUTCOME;
    case ORGANIZATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ORGANIZATION;
    case ORGANIZATIONAFFILIATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.ORGANIZATIONAFFILIATION;
    case PARAMETERS: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PARAMETERS;
    case PATIENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PATIENT;
    case PAYMENTNOTICE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PAYMENTNOTICE;
    case PAYMENTRECONCILIATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PAYMENTRECONCILIATION;
    case PERSON: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PERSON;
    case PLANDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PLANDEFINITION;
    case PRACTITIONER: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PRACTITIONER;
    case PRACTITIONERROLE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PRACTITIONERROLE;
    case PROCEDURE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PROCEDURE;
    case PROVENANCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.PROVENANCE;
    case QUESTIONNAIRE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.QUESTIONNAIRE;
    case QUESTIONNAIRERESPONSE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.QUESTIONNAIRERESPONSE;
    case RELATEDPERSON: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RELATEDPERSON;
    case REQUESTGROUP: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.REQUESTGROUP;
    case RESEARCHDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RESEARCHDEFINITION;
    case RESEARCHELEMENTDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RESEARCHELEMENTDEFINITION;
    case RESEARCHSTUDY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RESEARCHSTUDY;
    case RESEARCHSUBJECT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RESEARCHSUBJECT;
    case RESOURCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RESOURCE;
    case RISKASSESSMENT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RISKASSESSMENT;
    case RISKEVIDENCESYNTHESIS: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.RISKEVIDENCESYNTHESIS;
    case SCHEDULE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SCHEDULE;
    case SEARCHPARAMETER: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SEARCHPARAMETER;
    case SERVICEREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SERVICEREQUEST;
    case SLOT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SLOT;
    case SPECIMEN: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SPECIMEN;
    case SPECIMENDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SPECIMENDEFINITION;
    case STRUCTUREDEFINITION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.STRUCTUREDEFINITION;
    case STRUCTUREMAP: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.STRUCTUREMAP;
    case SUBSCRIPTION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSCRIPTION;
    case SUBSTANCE: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCE;
    case SUBSTANCENUCLEICACID: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCENUCLEICACID;
    case SUBSTANCEPOLYMER: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCEPOLYMER;
    case SUBSTANCEPROTEIN: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCEPROTEIN;
    case SUBSTANCEREFERENCEINFORMATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCEREFERENCEINFORMATION;
    case SUBSTANCESOURCEMATERIAL: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCESOURCEMATERIAL;
    case SUBSTANCESPECIFICATION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUBSTANCESPECIFICATION;
    case SUPPLYDELIVERY: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUPPLYDELIVERY;
    case SUPPLYREQUEST: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.SUPPLYREQUEST;
    case TASK: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.TASK;
    case TERMINOLOGYCAPABILITIES: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.TERMINOLOGYCAPABILITIES;
    case TESTREPORT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.TESTREPORT;
    case TESTSCRIPT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.TESTSCRIPT;
    case VALUESET: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.VALUESET;
    case VERIFICATIONRESULT: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.VERIFICATIONRESULT;
    case VISIONPRESCRIPTION: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.VISIONPRESCRIPTION;
    default: return org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    copyElement(src, tgt);
    if (src.hasVersionId())
      tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    copyElement(src, tgt);
    if (src.hasVersionId())
      tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    copyElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    copyElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionIdElement(convertString(src.getVersionIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent();
    copyElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent();
    copyElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasPause())
      tgt.setPauseElement(convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasPause())
      tgt.setPauseElement(convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    copyElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(convertString(src.getNumberElement()));
    if (src.hasType())
      tgt.setTypeElement(convertString(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    copyElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(convertString(src.getNumberElement()));
    if (src.hasType())
      tgt.setTypeElement(convertString(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    copyElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    copyElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }


}
