package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Money10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Account10_30 {

  public static org.hl7.fhir.dstu2.model.Account convertAccount(org.hl7.fhir.dstu3.model.Account src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Account tgt = new org.hl7.fhir.dstu2.model.Account();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(convertAccountStatus(src.getStatusElement()));
    if (src.hasActive())
      tgt.setActivePeriod(Period10_30.convertPeriod(src.getActive()));
    if (src.hasBalance())
      tgt.setBalance(Money10_30.convertMoney(src.getBalance()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasOwner())
      tgt.setOwner(Reference10_30.convertReference(src.getOwner()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Account convertAccount(org.hl7.fhir.dstu2.model.Account src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Account tgt = new org.hl7.fhir.dstu3.model.Account();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasName())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(convertAccountStatus(src.getStatusElement()));
    if (src.hasActivePeriod())
      tgt.setActive(Period10_30.convertPeriod(src.getActivePeriod()));
    if (src.hasBalance())
      tgt.setBalance(Money10_30.convertMoney(src.getBalance()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasOwner())
      tgt.setOwner(Reference10_30.convertReference(src.getOwner()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Account.AccountStatus> convertAccountStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Account.AccountStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Account.AccountStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Account.AccountStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Account.AccountStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Account.AccountStatus.INACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Account.AccountStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Account.AccountStatus> convertAccountStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Account.AccountStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Account.AccountStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Account.AccountStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Account.AccountStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Account.AccountStatus.INACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Account.AccountStatus.NULL);
        break;
    }
    return tgt;
  }
}