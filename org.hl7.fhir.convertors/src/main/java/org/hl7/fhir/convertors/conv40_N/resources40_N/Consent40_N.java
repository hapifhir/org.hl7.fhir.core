package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Consent;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class Consent40_N {

  // a nested R4 provision type that breaks the pattern of alternating types (a modifier, on the R6 provision)
  public static final String PROVISION_TYPE_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-Consent.provision.type";

  private static org.hl7.fhir.r4.model.Consent.ConsentProvisionType opposite(org.hl7.fhir.r4.model.Consent.ConsentProvisionType type) {
    if (type == null)
      return null;
    switch (type) {
    case DENY: return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.PERMIT;
    case PERMIT: return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.DENY;
    default: return null;
    }
  }

  private static boolean isResourceType(String system) {
    return "http://hl7.org/fhir/resource-types".equals(system) || "http://hl7.org/fhir/fhir-types".equals(system);
  }

  // R6 date is a date: R4 dateTime, when it has a time
  public static final String DATETIME_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-Consent.dateTime";

  public static org.hl7.fhir.model.core.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent tgt = new org.hl7.fhir.model.core.Consent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Consent", "5.0", new String[] {"period", "sourceAttachment", "sourceReference", "provision", "grantor", "controller", "policyBasis", "policyText", "regulatoryBasis"}, CrossVersionElements40_N.urls("Consent", "6.0", new String[] {}, DATETIME_EXTENSION_URL)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "period", "policyBasis", "policyText", "regulatoryBasis");
    // R6 dropped scope, policy and policyRule
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Consent", tgt.getExtension(), "scope", "policy", "policyRule");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertConsentState(src.getStatusElement()), src.fhirType(), "status"));
    CrossVersionElements40_N.keepR4Code(src.getStatusElement(), tgt.getStatusElement(), convertConsentState(tgt.getStatusElement()), CrossVersionElements40_N.url("Consent", "4.0", "status"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    // R6 date is only a date: if R4 has a time as well, the dateTime is kept in the extension
    if (src.hasDateTime()) {
      tgt.setDateElement(DateTime40_N.convertDateTimeToDate(src.getDateTimeElement()));
      if (src.getDateTimeElement().getPrecision().compareTo(ca.uhn.fhir.model.api.TemporalPrecisionEnum.DAY) > 0)
        tgt.addExtension(DATETIME_EXTENSION_URL, DateTime40_N.convertDateTime(src.getDateTimeElement()));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addGrantee(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getOrganization()) tgt.addManager(Reference40_N.convertReference(t));
    // R4 has no grantor or controller
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "grantor", "controller");
    if (src.hasSourceAttachment())
      tgt.addSourceAttachment(Attachment40_N.convertAttachment(src.getSourceAttachment()));
    if (src.hasSourceReference())
      tgt.addSourceReference(Reference40_N.convertReference(src.getSourceReference()));
    // the other sources (R4 has only one)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "sourceAttachment", "sourceReference");
    for (org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    // the root R4 provision type is R6 decision; the types below it should alternate (see convertprovisionComponent)
    if (src.hasProvision()) {
      // a provision that's only a type is just the decision (see below)
      org.hl7.fhir.r4.model.Consent.ProvisionComponent rest = src.getProvision().copy();
      rest.setTypeElement(null);
      if (!rest.isEmpty())
        tgt.addProvision(convertprovisionComponent(src.getProvision()));
      if (src.getProvision().hasType())
        tgt.setDecisionElement(convertConsentProvisionType(src.getProvision().getTypeElement()));
    }
    // the other provisions (R4 has only one)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "provision");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.model.core.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Consent", "4.0", new String[] {"scope", "policy", "policyRule"}, DATETIME_EXTENSION_URL));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "period", "grantor", "controller", "policyBasis", "policyText", "regulatoryBasis");
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Consent", "scope", "policy", "policyRule");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertConsentState(src.getStatusElement()), src.fhirType(), "status"));
    CrossVersionElements40_N.restoreR4Code(tgt.getStatusElement(), CrossVersionElements40_N.url("Consent", "4.0", "status"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasExtension(DATETIME_EXTENSION_URL))
      tgt.setDateTimeElement(DateTime40_N.convertDateTime((org.hl7.fhir.model.core.DateTimeType) src.getExtensionByUrl(DATETIME_EXTENSION_URL).getValue()));
    else if (src.hasDate())
      tgt.setDateTimeElement(DateTime40_N.convertDateToDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getGranteeList()) tgt.addPerformer(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getManagerList()) tgt.addOrganization(Reference40_N.convertReference(t));
    // R4 source[x] is a single attachment or reference: the first, and the rest in the extension
    for (org.hl7.fhir.model.core.Attachment t : src.getSourceAttachmentList()) {
      if (!tgt.hasSource())
        tgt.setSource(Attachment40_N.convertAttachment(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Consent", "5.0", "sourceAttachment"), Attachment40_N.convertAttachment(t));
    }
    for (org.hl7.fhir.model.core.Reference t : src.getSourceReferenceList()) {
      if (!tgt.hasSource())
        tgt.setSource(Reference40_N.convertReference(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Consent", "5.0", "sourceReference"), Reference40_N.convertReference(t));
    }
    for (org.hl7.fhir.model.core.Consent.ConsentVerificationComponent t : src.getVerificationList())
      tgt.addVerification(convertConsentVerificationComponent(t));
    // R4 has a single provision: the first, and the rest in the extension
    for (org.hl7.fhir.model.core.Consent.ProvisionComponent t : src.getProvisionList()) {
      if (!tgt.hasProvision())
        tgt.setProvision(convertprovisionComponent(t, src.hasDecision() ? convertConsentProvisionType(src.getDecisionElement()).getValue() : null));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Consent", "5.0", "provision"), t));
    }
    // R4 has the decision as the type of the root provision: with no provision, a provision with just the type
    if (!tgt.hasProvision() && src.hasDecision())
      tgt.getProvision().setTypeElement(convertConsentProvisionType(src.getDecisionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentState> tgt = new Enumeration<>(new Consent.ConsentStateEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Consent.ConsentState.DRAFT);
                  break;
              case PROPOSED:
                  tgt.setValue(Consent.ConsentState.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Consent.ConsentState.ACTIVE);
                  break;
              case REJECTED:
                  tgt.setValue(Consent.ConsentState.INACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Consent.ConsentState.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Consent.ConsentState.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Consent.ConsentState.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentStateEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.model.core.Consent.ConsentVerificationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Consent.verification", "5.0", new String[] {"verifiedBy"}, CrossVersionElements40_N.urls("Consent.verification", "6.0", new String[] {"type", "date"})));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Consent.verification", "5.0", "verifiedBy");
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Consent.verification", "6.0", "type");
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean40_N.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference40_N.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.getDateList().add(DateTime40_N.convertDateTime(src.getVerificationDateElement()));
    // the other dates (R4 has only one)
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Consent.verification", "6.0", "date");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.model.core.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Consent.verification", tgt.getExtension(), "5.0", "verifiedBy");
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Consent.verification", tgt.getExtension(), "6.0", "type");
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean40_N.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference40_N.convertReference(src.getVerifiedWith()));
    for (org.hl7.fhir.model.core.DateTimeType t : src.getDateList()) {
      if (!tgt.hasVerificationDate())
        tgt.setVerificationDateElement(DateTime40_N.convertDateTime(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Consent.verification", "6.0", "date"), DateTime40_N.convertDateTime(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4.model.Consent.ProvisionComponent src) throws FHIRException {
    return convertprovisionComponent(src, null, true);
  }

  /**
   * R6 has a single decision, at the root, and the nested provisions alternate (deny, then permit, then deny...). R4
   * has a type on every provision, which should follow the same pattern. The root type is the decision (done by the
   * caller); a nested type that breaks the pattern is kept in a modifier extension
   *
   * @param expected the type the pattern says this provision has (null if there's nothing to go on)
   */
  private static org.hl7.fhir.model.core.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4.model.Consent.ProvisionComponent src, org.hl7.fhir.r4.model.Consent.ConsentProvisionType expected, boolean root) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (!root && src.hasType() && src.getType() != expected)
      tgt.addModifierExtension(PROVISION_TYPE_EXTENSION_URL, new org.hl7.fhir.model.core.CodeType(src.getTypeElement().getValueAsString()));
    org.hl7.fhir.r4.model.Consent.ConsentProvisionType childExpected = opposite(src.hasType() ? src.getType() : expected);
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding40_N.convertCoding(t));
    // R4 class is R6 resourceType when it's a resource type, and documentType otherwise
    for (org.hl7.fhir.r4.model.Coding t : src.getClass_()) {
      if (isResourceType(t.getSystem()))
        tgt.addResourceType(Coding40_N.convertCoding(t));
      else
        tgt.addDocumentType(Coding40_N.convertCoding(t));
    }
    // the ones the system doesn't sort out (see below)
    for (String name : new String[] {"resourceType", "documentType"}) {
      String url = CrossVersionElements40_N.url("Consent.provision", "5.0", name);
      CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Consent.provision", "5.0", name);
      tgt.getExtension().removeIf(e -> url.equals(e.getUrl()));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period40_N.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r4.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t, childExpected, false));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.model.core.Consent.ProvisionComponent src) throws FHIRException {
    return convertprovisionComponent(src, null);
  }

  /**
   * The reverse: every R4 provision gets its type, from the decision at the root and alternating below it, unless
   * a modifier extension says otherwise
   *
   * @param type the type the pattern gives this provision (null if there's nothing to go on)
   */
  public static org.hl7.fhir.r4.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.model.core.Consent.ProvisionComponent src, org.hl7.fhir.r4.model.Consent.ConsentProvisionType type) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r4.model.Consent.ProvisionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, PROVISION_TYPE_EXTENSION_URL);
    for (org.hl7.fhir.model.core.Extension ext : src.getModifierExtensionList()) {
      if (PROVISION_TYPE_EXTENSION_URL.equals(ext.getUrl()) && ext.hasValue())
        type = org.hl7.fhir.r4.model.Consent.ConsentProvisionType.fromCode(ext.getValue().primitiveValue());
    }
    if (type != null)
      tgt.setType(type);
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.Consent.ProvisionActorComponent t : src.getActorList())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getActionList())
      tgt.addAction(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Coding t : src.getSecurityLabelList()) tgt.addSecurityLabel(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.model.core.Coding t : src.getPurposeList()) tgt.addPurpose(Coding40_N.convertCoding(t));
    // R4 class is both; going back, the system decides which. If that wouldn't put them all back where they came from,
    // they are 5.0 extensions instead
    if (src.getResourceTypeList().stream().allMatch(c -> isResourceType(c.getSystem())))
      for (org.hl7.fhir.model.core.Coding t : src.getResourceTypeList()) tgt.addClass_(Coding40_N.convertCoding(t));
    else
      CrossVersionElements40_N.elementsToExtensionsForPath(src, "Consent.provision", tgt.getExtension(), "5.0", "resourceType");
    if (src.getDocumentTypeList().stream().noneMatch(c -> isResourceType(c.getSystem())))
      for (org.hl7.fhir.model.core.Coding t : src.getDocumentTypeList()) tgt.addClass_(Coding40_N.convertCoding(t));
    else
      CrossVersionElements40_N.elementsToExtensionsForPath(src, "Consent.provision", tgt.getExtension(), "5.0", "documentType");
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period40_N.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.model.core.Consent.ProvisionDataComponent t : src.getDataList())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.model.core.Consent.ProvisionComponent t : src.getProvisionList())
      tgt.addProvision(convertprovisionComponent(t, opposite(type)));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentProvisionType> tgt = new Enumeration<>(new Consent.ConsentProvisionTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DENY:
                  tgt.setValue(Consent.ConsentProvisionType.DENY);
                  break;
              case PERMIT:
                  tgt.setValue(Consent.ConsentProvisionType.PERMIT);
                  break;
              default:
                  tgt.setValue(Consent.ConsentProvisionType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentProvisionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentProvisionTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DENY:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentProvisionType.DENY);
                  break;
              case PERMIT:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentProvisionType.PERMIT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentProvisionType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionActorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionActorComponent convertprovisionActorComponent(org.hl7.fhir.model.core.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionDataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(CrossVersionElements40_N.toR6Code(src.getMeaningElement(), convertConsentDataMeaning(src.getMeaningElement()), src.fhirType(), "meaning"));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionDataComponent convertprovisionDataComponent(org.hl7.fhir.model.core.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(CrossVersionElements40_N.toR4Code(src.getMeaningElement(), convertConsentDataMeaning(src.getMeaningElement()), src.fhirType(), "meaning"));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentDataMeaning> tgt = new Enumeration<>(new Consent.ConsentDataMeaningEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(Consent.ConsentDataMeaning.INSTANCE);
                  break;
              case RELATED:
                  tgt.setValue(Consent.ConsentDataMeaning.RELATED);
                  break;
              case DEPENDENTS:
                  tgt.setValue(Consent.ConsentDataMeaning.DEPENDENTS);
                  break;
              case AUTHOREDBY:
                  tgt.setValue(Consent.ConsentDataMeaning.AUTHOREDBY);
                  break;
              default:
                  tgt.setValue(Consent.ConsentDataMeaning.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentDataMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentDataMeaningEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.INSTANCE);
                  break;
              case RELATED:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.RELATED);
                  break;
              case DEPENDENTS:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.DEPENDENTS);
                  break;
              case AUTHOREDBY:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.AUTHOREDBY);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.NULL);
                  break;
          }
      }
      return tgt;
  }
}
