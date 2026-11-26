package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Money40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Invoice40_N {

  public static org.hl7.fhir.model.core.Invoice convertInvoice(org.hl7.fhir.r4.model.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Invoice tgt = new org.hl7.fhir.model.core.Invoice();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertInvoiceStatus(src.getStatusElement()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(String40_N.convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference40_N.convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(Reference40_N.convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(Reference40_N.convertReference(src.getAccount()));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent t : src.getLineItem())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getTotalPriceComponent())
      tgt.addTotalPriceComponent(convertPriceComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(Money40_N.convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(Money40_N.convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(MarkDown40_N.convertMarkdown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice convertInvoice(org.hl7.fhir.model.core.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice tgt = new org.hl7.fhir.r4.model.Invoice();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertInvoiceStatus(src.getStatusElement()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(String40_N.convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference40_N.convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(Reference40_N.convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(Reference40_N.convertReference(src.getAccount()));
    for (org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent t : src.getLineItemList())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.model.core.MonetaryComponent t : src.getTotalPriceComponentList())
      tgt.addTotalPriceComponent(convertPriceComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(Money40_N.convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(Money40_N.convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(MarkDown40_N.convertMarkdown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Invoice.InvoiceStatus> convertInvoiceStatus(
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Invoice.InvoiceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Invoice.InvoiceStatus> tgt =
      new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Invoice.InvoiceStatusEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT -> tgt.setValue(org.hl7.fhir.model.core.Invoice.InvoiceStatus.DRAFT);
        case ISSUED -> tgt.setValue(org.hl7.fhir.model.core.Invoice.InvoiceStatus.ISSUED);
        case BALANCED -> tgt.setValue(org.hl7.fhir.model.core.Invoice.InvoiceStatus.BALANCED);
        case CANCELLED -> tgt.setValue(org.hl7.fhir.model.core.Invoice.InvoiceStatus.CANCELLED);
        case ENTEREDINERROR -> tgt.setValue(org.hl7.fhir.model.core.Invoice.InvoiceStatus.ENTEREDINERROR);
        default -> tgt.setValue(org.hl7.fhir.model.core.Invoice.InvoiceStatus.NULL);
      }
    }
    return tgt;
  }

  static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Invoice.InvoiceStatus> convertInvoiceStatus(
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Invoice.InvoiceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Invoice.InvoiceStatus> tgt =
      new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Invoice.InvoiceStatusEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.DRAFT);
        case ISSUED -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.ISSUED);
        case BALANCED -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.BALANCED);
        case CANCELLED -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.CANCELLED);
        case ENTEREDINERROR -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.ENTEREDINERROR);
        default -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.NULL);
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(
    org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent tgt =
      new org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(
    org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent tgt =
      new org.hl7.fhir.r4.model.Invoice.InvoiceParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(
    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent tgt =
      new org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasChargeItem())
      tgt.setChargeItem(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getChargeItem()));
    for (org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertPriceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(
    org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent tgt =
      new org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasChargeItem())
      tgt.setChargeItem(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getChargeItem()));
    for (org.hl7.fhir.model.core.MonetaryComponent t : src.getPriceComponentList())
      tgt.addPriceComponent(convertPriceComponent(t));
    return tgt;
  }

  private static org.hl7.fhir.model.core.MonetaryComponent convertPriceComponent(
    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MonetaryComponent tgt = new org.hl7.fhir.model.core.MonetaryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertPriceComponentType(src.getTypeElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent convertPriceComponent(
    org.hl7.fhir.model.core.MonetaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent tgt =
      new org.hl7.fhir.r4.model.Invoice.InvoiceLineItemPriceComponentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertPriceComponentType(src.getTypeElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_N.convertMoney(src.getAmount()));
    return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType> convertPriceComponentType(
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType> tgt =
      new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.MonetaryComponent.PriceComponentTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case BASE -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.BASE);
        case SURCHARGE -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.SURCHARGE);
        case DEDUCTION -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.DISCOUNT);
        case DISCOUNT -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.DISCOUNT);
        case TAX -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.TAX);
        case INFORMATIONAL -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.INFORMATIONAL);
        default -> tgt.setValue(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.NULL);
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType> convertPriceComponentType(
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType> tgt =
      new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case BASE -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.BASE);
        case SURCHARGE -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.SURCHARGE);
        case DISCOUNT -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.DISCOUNT);
        case TAX -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.TAX);
        case INFORMATIONAL -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.INFORMATIONAL);
        case NULL -> tgt.setValue(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.NULL);
      }
    }
    return tgt;
  }
}
