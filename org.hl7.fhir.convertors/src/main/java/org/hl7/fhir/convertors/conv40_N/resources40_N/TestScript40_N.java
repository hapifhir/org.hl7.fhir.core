package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.*;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.convertors.conv40_N.resources40_N.Enumerations40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Expression;
import org.hl7.fhir.model.testing.TestScript;

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
public class TestScript40_N {

  public static org.hl7.fhir.model.testing.TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript tgt = new org.hl7.fhir.model.testing.TestScript();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE,
      CrossVersionElements40_N.url(TS, "6.0", "testSystem"), CrossVersionElements40_N.url(TS, "5.0", "copyrightLabel"));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "copyrightLabel");
    convertSystems(src, tgt);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE)) {
      // copyDomainResource was told to leave this extension out
      org.hl7.fhir.model.testing.TestScript.TestScriptScopeComponent scope = tgt.addScope();
      scope.setArtifact(ext.getExtensionString("artifact"));
      org.hl7.fhir.r4.model.Extension se = ext.getExtensionByUrl("conformance");
      if (se != null) {
        scope.setConformance(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) se.getValue()));
      }
      se = ext.getExtensionByUrl("phase");
      if (se != null) {
        scope.setPhase(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) se.getValue()));
      }
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    CrossVersionElements40_N.extraValuesToR6(src.getExtension(), tgt, "identifier", tgt.getExtension());
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getProfile()) tgt.getProfileList().add(Reference40_N.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  // R4 origin and destination are R6 testSystem. R4 numbers origins and destinations separately, and R6 numbers the
  // test systems together: origins keep their index, and destinations come after the origins (destination n is
  // testSystem [highest origin index] + n), and the operation and capability destination references move the same way.
  // The R4 profile is a 4.0 extension on the test system, and that's what says it's an origin or a destination.
  // Test systems that aren't marked as either are 6.0 extensions in R4
  private static final String TS = "TestScript";
  private static final String ORIGIN_PROFILE_URL = CrossVersionElements40_N.url("TestScript.origin", "4.0", "profile");
  private static final String DESTINATION_PROFILE_URL = CrossVersionElements40_N.url("TestScript.destination", "4.0", "profile");
  private static final String TEST_SYSTEM = "TestScript.testSystem";
  private static final ThreadLocal<Integer> DESTINATION_OFFSET = ThreadLocal.withInitial(() -> 0);

  private static void convertSystems(org.hl7.fhir.r4.model.TestScript src, org.hl7.fhir.model.testing.TestScript tgt) throws FHIRException {
    int offset = 0;
    for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      offset = Math.max(offset, t.getIndex());
    DESTINATION_OFFSET.set(offset);
    for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addTestSystem(testSystem(t, t.getIndexElement(), t.getProfile(), 0, ORIGIN_PROFILE_URL));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addTestSystem(testSystem(t, t.getIndexElement(), t.getProfile(), offset, DESTINATION_PROFILE_URL));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "testSystem");
  }

  private static org.hl7.fhir.model.testing.TestScript.TestScriptTestSystemComponent testSystem(org.hl7.fhir.r4.model.BackboneElement src,
      org.hl7.fhir.r4.model.IntegerType index, org.hl7.fhir.r4.model.Coding profile, int offset, String url) throws FHIRException {
    org.hl7.fhir.model.testing.TestScript.TestScriptTestSystemComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptTestSystemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls(TEST_SYSTEM, "6.0", new String[] {"title", "actor", "description", "url"}));
    if (index.hasValue()) {
      tgt.getIndexElement().setValue(index.getValue() + offset);
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(index, tgt.getIndexElement());
    }
    if (profile != null && !profile.isEmpty())
      tgt.addExtension(url, Coding40_N.convertCoding(profile));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, TEST_SYSTEM, "6.0", "title", "actor", "description", "url");
    if (!tgt.hasTitle())
      tgt.setTitle(titleFor(profile));
    return tgt;
  }

  // R6 test systems need a title: the profile's display or code
  private static String titleFor(org.hl7.fhir.r4.model.Coding profile) {
    return profile == null ? null : profile.hasDisplay() ? profile.getDisplay() : profile.getCode();
  }

  private static void convertSystems(org.hl7.fhir.model.testing.TestScript src, org.hl7.fhir.r4.model.TestScript tgt) throws FHIRException {
    int offset = 0;
    for (org.hl7.fhir.model.testing.TestScript.TestScriptTestSystemComponent t : src.getTestSystemList())
      if (t.hasExtension(ORIGIN_PROFILE_URL))
        offset = Math.max(offset, t.getIndex());
    DESTINATION_OFFSET.set(offset);
    for (org.hl7.fhir.model.testing.TestScript.TestScriptTestSystemComponent t : src.getTestSystemList()) {
      if (t.hasExtension(ORIGIN_PROFILE_URL))
        fromTestSystem(t, tgt.addOrigin(), 0, ORIGIN_PROFILE_URL);
      else if (t.hasExtension(DESTINATION_PROFILE_URL))
        fromTestSystem(t, tgt.addDestination(), offset, DESTINATION_PROFILE_URL);
      else
        tgt.addExtension(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url(TS, "6.0", "testSystem"), t));
    }
  }

  private static void fromTestSystem(org.hl7.fhir.model.testing.TestScript.TestScriptTestSystemComponent src, org.hl7.fhir.r4.model.BackboneElement tgt, int offset, String url) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, url);
    org.hl7.fhir.r4.model.Coding profile = Coding40_N.convertCoding((org.hl7.fhir.model.core.Coding) src.getExtensionByUrl(url).getValue());
    org.hl7.fhir.r4.model.IntegerType index = new org.hl7.fhir.r4.model.IntegerType();
    if (src.hasIndex()) {
      index.setValue(src.getIndex() - offset);
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getIndexElement(), index);
    }
    tgt.setProperty("index", index);
    tgt.setProperty("profile", profile);
    if (src.hasTitle() && !src.getTitle().equals(titleFor(profile)))
      CrossVersionElements40_N.elementsToExtensionsForPath(src, TEST_SYSTEM, tgt.getExtension(), "6.0", "title");
    CrossVersionElements40_N.elementsToExtensionsForPath(src, TEST_SYSTEM, tgt.getExtension(), "6.0", "actor", "description", "url");
  }

  private static org.hl7.fhir.model.core.IntegerType destinationToR6(org.hl7.fhir.model.core.IntegerType t) {
    if (t.hasValue())
      t.setValue(t.getValue() + DESTINATION_OFFSET.get());
    return t;
  }

  private static org.hl7.fhir.r4.model.IntegerType destinationToR4(org.hl7.fhir.r4.model.IntegerType t) {
    if (t.hasValue())
      t.setValue(t.getValue() - DESTINATION_OFFSET.get());
    return t;
  }

  public static org.hl7.fhir.r4.model.TestScript convertTestScript(org.hl7.fhir.model.testing.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "copyrightLabel");
    convertSystems(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifierFirstRep()));
    CrossVersionElements40_N.extraValuesToR4(src, "identifier", tgt.getExtension());
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (TestScript.TestScriptFixtureComponent t : src.getFixtureList())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList()) tgt.addProfile(Reference40_N.convertCanonicalToReference(t));
    for (TestScript.TestScriptVariableComponent t : src.getVariableList())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (TestScript.TestScriptTestComponent t : src.getTestList())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    for (TestScript.TestScriptScopeComponent scope : src.getScopeList()) {
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension();
      ext.setUrl(VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE);
      if (scope.hasArtifact()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("artifact");
        se.setValue(Canonical40_N.convertCanonical(scope.getArtifactElement()));
      }
      if (scope.hasConformance()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("conformance");
        se.setValue(CodeableConcept40_N.convertCodeableConcept(scope.getConformance()));
      }
      if (scope.hasPhase()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("phase");
        se.setValue(CodeableConcept40_N.convertCodeableConcept(scope.getPhase()));
      }      
    }
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptMetadataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.model.testing.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.testing.TestScript.TestScriptMetadataLinkComponent t : src.getLinkList())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.model.testing.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapabilityList())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.model.testing.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_N.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean40_N.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.IntegerType t : src.getOrigin()) tgt.getOriginList().add(Integer40_N.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(destinationToR6(Integer40_N.convertInteger(src.getDestinationElement())));
    for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.getLinkList().add(Uri40_N.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(Canonical40_N.convertCanonical(src.getCapabilitiesElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.model.testing.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_N.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean40_N.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.IntegerType t : src.getOriginList()) tgt.getOrigin().add(Integer40_N.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(destinationToR4(Integer40_N.convertInteger(src.getDestinationElement())));
    for (org.hl7.fhir.model.core.UriType t : src.getLinkList()) tgt.getLink().add(Uri40_N.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(Canonical40_N.convertCanonical(src.getCapabilitiesElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptFixtureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean40_N.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean40_N.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference40_N.convertReference(src.getResource()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.model.testing.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean40_N.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean40_N.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference40_N.convertReference(src.getResource()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptVariableComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String40_N.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpression(expressionToR6(src.getExpressionElement(), "TestScript.variable", "expression"));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(String40_N.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.model.testing.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String40_N.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(expressionToR4(src.getExpression(), "TestScript.variable", "expression"));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(String40_N.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptSetupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.model.testing.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (TestScript.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.SetupActionComponent tgt = new org.hl7.fhir.model.testing.TestScript.SetupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.model.testing.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.model.testing.TestScript.SetupActionOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding40_N.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(Code40_N.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(destinationToR6(Integer40_N.convertInteger(src.getDestinationElement())));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean40_N.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(CrossVersionElements40_N.toR6Code(src.getMethodElement(), convertTestScriptRequestMethodCode(src.getMethodElement()), src.fhirType(), "method"));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer40_N.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String40_N.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(Id40_N.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id40_N.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(Id40_N.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(String40_N.convertString(src.getUrlElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.model.testing.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding40_N.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(Code40_N.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(destinationToR4(Integer40_N.convertInteger(src.getDestinationElement())));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean40_N.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(CrossVersionElements40_N.toR4Code(src.getMethodElement(), convertTestScriptRequestMethodCode(src.getMethodElement()), src.fhirType(), "method"));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer40_N.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String40_N.convertString(src.getParamsElement()));
    for (TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeaderList())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(Id40_N.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id40_N.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(Id40_N.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(String40_N.convertString(src.getUrlElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  static public Enumeration<org.hl7.fhir.model.testing.TestScript.TestScriptRequestMethodCodeValueSet> convertTestScriptRequestMethodCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestScript.TestScriptRequestMethodCodeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DELETE:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.DELETE);
                  break;
              case GET:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.GET);
                  break;
              case OPTIONS:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.OPTIONS);
                  break;
              case PATCH:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.PATCH);
                  break;
              case POST:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.POST);
                  break;
              case PUT:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.PUT);
                  break;
              case HEAD:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.HEAD);
                  break;
              default:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(Enumeration<org.hl7.fhir.model.testing.TestScript.TestScriptRequestMethodCodeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DELETE:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.DELETE);
                  break;
              case GET:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.GET);
                  break;
              case OPTIONS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
                  break;
              case PATCH:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.PATCH);
                  break;
              case POST:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.POST);
                  break;
              case PUT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.PUT);
                  break;
              case HEAD:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.HEAD);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.model.testing.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(String40_N.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.model.testing.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(String40_N.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.model.testing.TestScript.SetupActionAssertComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(CrossVersionElements40_N.toR6Code(src.getDirectionElement(), convertAssertionDirectionType(src.getDirectionElement()), src.fhirType(), "direction"));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String40_N.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpression(expressionToR6(src.getCompareToSourceExpressionElement(), "TestScript.setup.action.assert", "compareToSourceExpression"));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String40_N.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpression(expressionToR6(src.getExpressionElement(), "TestScript.setup.action.assert", "expression"));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String40_N.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean40_N.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(CrossVersionElements40_N.toR6Code(src.getOperatorElement(), convertAssertionOperatorType(src.getOperatorElement()), src.fhirType(), "operator"));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(CrossVersionElements40_N.toR6Code(src.getRequestMethodElement(), convertTestScriptRequestMethodCode(src.getRequestMethodElement()), src.fhirType(), "requestMethod"));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(String40_N.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(CrossVersionElements40_N.toR6Code(src.getResponseElement(), convertAssertionResponseTypes(src.getResponseElement()), src.fhirType(), "response"));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String40_N.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id40_N.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean40_N.convertBoolean(src.getWarningOnlyElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.model.testing.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(CrossVersionElements40_N.toR4Code(src.getDirectionElement(), convertAssertionDirectionType(src.getDirectionElement()), src.fhirType(), "direction"));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String40_N.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(expressionToR4(src.getCompareToSourceExpression(), "TestScript.setup.action.assert", "compareToSourceExpression"));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String40_N.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(expressionToR4(src.getExpression(), "TestScript.setup.action.assert", "expression"));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String40_N.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean40_N.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(CrossVersionElements40_N.toR4Code(src.getOperatorElement(), convertAssertionOperatorType(src.getOperatorElement()), src.fhirType(), "operator"));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(CrossVersionElements40_N.toR4Code(src.getRequestMethodElement(), convertTestScriptRequestMethodCode(src.getRequestMethodElement()), src.fhirType(), "requestMethod"));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(String40_N.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(CrossVersionElements40_N.toR4Code(src.getResponseElement(), convertAssertionResponseTypes(src.getResponseElement()), src.fhirType(), "response"));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String40_N.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id40_N.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean40_N.convertBoolean(src.getWarningOnlyElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  static public Enumeration<TestScript.AssertionDirectionTypeValueSet> convertAssertionDirectionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestScript.AssertionDirectionTypeValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestScript.AssertionDirectionTypeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RESPONSE:
                  tgt.setValue(TestScript.AssertionDirectionTypeValueSet.RESPONSE);
                  break;
              case REQUEST:
                  tgt.setValue(TestScript.AssertionDirectionTypeValueSet.REQUEST);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionDirectionTypeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(Enumeration<org.hl7.fhir.model.testing.TestScript.AssertionDirectionTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionDirectionTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RESPONSE:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.RESPONSE);
                  break;
              case REQUEST:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.REQUEST);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public Enumeration<TestScript.AssertionOperatorTypeValueSet> convertAssertionOperatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestScript.AssertionOperatorTypeValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestScript.AssertionOperatorTypeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUALS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.EQUALS);
                  break;
              case NOTEQUALS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTEQUALS);
                  break;
              case IN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.IN);
                  break;
              case NOTIN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTIN);
                  break;
              case GREATERTHAN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.GREATERTHAN);
                  break;
              case LESSTHAN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.LESSTHAN);
                  break;
              case EMPTY:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.EMPTY);
                  break;
              case NOTEMPTY:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTEMPTY);
                  break;
              case CONTAINS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.CONTAINS);
                  break;
              case NOTCONTAINS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTCONTAINS);
                  break;
              case EVAL:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.EVAL);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(Enumeration<org.hl7.fhir.model.testing.TestScript.AssertionOperatorTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionOperatorTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUALS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EQUALS);
                  break;
              case NOTEQUALS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEQUALS);
                  break;
              case IN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.IN);
                  break;
              case NOTIN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTIN);
                  break;
              case GREATERTHAN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.GREATERTHAN);
                  break;
              case LESSTHAN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.LESSTHAN);
                  break;
              case EMPTY:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EMPTY);
                  break;
              case NOTEMPTY:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEMPTY);
                  break;
              case CONTAINS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.CONTAINS);
                  break;
              case NOTCONTAINS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTCONTAINS);
                  break;
              case EVAL:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EVAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public Enumeration<TestScript.AssertionResponseTypesValueSet> convertAssertionResponseTypes(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestScript.AssertionResponseTypesValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestScript.AssertionResponseTypesValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OKAY:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.OKAY);
                  break;
              case CREATED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.CREATED);
                  break;
              case NOCONTENT:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NOCONTENT);
                  break;
              case NOTMODIFIED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NOTMODIFIED);
                  break;
              case BAD:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.BADREQUEST);
                  break;
              case FORBIDDEN:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.FORBIDDEN);
                  break;
              case NOTFOUND:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NOTFOUND);
                  break;
              case METHODNOTALLOWED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.METHODNOTALLOWED);
                  break;
              case CONFLICT:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.CONFLICT);
                  break;
              case GONE:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.GONE);
                  break;
              case PRECONDITIONFAILED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.PRECONDITIONFAILED);
                  break;
              case UNPROCESSABLE:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.UNPROCESSABLECONTENT);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(Enumeration<org.hl7.fhir.model.testing.TestScript.AssertionResponseTypesValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionResponseTypesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OKAY:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.OKAY);
                  break;
              case CREATED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CREATED);
                  break;
              case NOCONTENT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOCONTENT);
                  break;
              case NOTMODIFIED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
                  break;
              case BADREQUEST:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.BAD);
                  break;
              case FORBIDDEN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.FORBIDDEN);
                  break;
              case NOTFOUND:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTFOUND);
                  break;
              case METHODNOTALLOWED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
                  break;
              case CONFLICT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CONFLICT);
                  break;
              case GONE:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.GONE);
                  break;
              case PRECONDITIONFAILED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
                  break;
              case UNPROCESSABLECONTENT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptTestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.model.testing.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (TestScript.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestActionComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.model.testing.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.model.testing.TestScript.TestScriptTeardownComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.model.testing.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.testing.TestScript.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.model.testing.TestScript.TeardownActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.model.testing.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TeardownActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  // R4 has a FHIRPath string where R6 has an Expression: R4 gets the expression, and if the R6 Expression has more than
  // that (and that its language is FHIRPath), the whole Expression as a 6.0 extension on the string
  private static org.hl7.fhir.r4.model.StringType expressionToR4(Expression src, String path, String name) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = src.hasExpressionElement() ? String40_N.convertString(src.getExpressionElement()) : new org.hl7.fhir.r4.model.StringType();
    if (src.hasName() || src.hasDescription() || src.hasReference() || src.hasId() || src.hasExtension() || !FHIRPATH.equals(src.getLanguage()))
      tgt.addExtension(CrossVersionElements40_N.url(path, "6.0", name), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src));
    return tgt;
  }

  // R4 to R6: the reverse of expressionToR4 (an R4 expression is FHIRPath)
  private static Expression expressionToR6(org.hl7.fhir.r4.model.StringType src, String path, String name) throws FHIRException {
    String url = CrossVersionElements40_N.url(path, "6.0", name);
    if (src.hasExtension(url))
      return (Expression) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(url).getValue());
    return new Expression().setLanguage(FHIRPATH).setExpressionElement(String40_N.convertString(src));
  }

  private static final String FHIRPATH = "text/fhirpath";
}