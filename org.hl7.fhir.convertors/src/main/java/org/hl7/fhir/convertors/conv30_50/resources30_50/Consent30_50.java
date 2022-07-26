package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Consent30_50 {

  public static org.hl7.fhir.dstu3.model.Consent convertConsent(org.hl7.fhir.r5.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent tgt = new org.hl7.fhir.dstu3.model.Consent();
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent convertConsent(org.hl7.fhir.dstu3.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent tgt = new org.hl7.fhir.r5.model.Consent();
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ConsentPolicyBasisComponent convertConsentPolicyComponent(org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Consent.ConsentPolicyBasisComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentPolicyBasisComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasAuthority()) tgt.setRefereceElement(Uri30_50.convertUri(src.getAuthorityElement()));
    if (src.hasUri()) tgt.setUrl(src.getUri());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r5.model.Consent.ConsentPolicyBasisComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasAuthority()) tgt.setAuthorityElement(Uri30_50.convertUri(src.getReferenceElement()));
    if (src.hasUrl()) tgt.setUriElement(Uri30_50.convertUri(src.getUrlElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentDataMeaningEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.NULL);
    } else {
      switch (src.getValue()) {
        case INSTANCE:
          tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.INSTANCE);
          break;
        case RELATED:
          tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.RELATED);
          break;
        case DEPENDENTS:
          tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.DEPENDENTS);
          break;
        case AUTHOREDBY:
          tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.AUTHOREDBY);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaningEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.NULL);
    } else {
      switch (src.getValue()) {
        case INSTANCE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.INSTANCE);
          break;
        case RELATED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.RELATED);
          break;
        case DEPENDENTS:
          tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.DEPENDENTS);
          break;
        case AUTHOREDBY:
          tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.AUTHOREDBY);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.NULL);
          break;
      }
    }
    return tgt;
  }
}