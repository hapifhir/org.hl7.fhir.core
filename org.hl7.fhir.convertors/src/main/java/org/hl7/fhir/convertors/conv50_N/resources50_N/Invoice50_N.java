package org.hl7.fhir.convertors.conv50_N.resources50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Invoice50_N {

  public static org.hl7.fhir.model.core.Invoice convertInvoice(org.hl7.fhir.r5.model.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Invoice tgt = new org.hl7.fhir.model.core.Invoice();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertInvoiceStatus(src.getStatusElement()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getAccount()));
    for (org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent t : src.getLineItem())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.r5.model.MonetaryComponent t : src.getTotalPriceComponent())
      tgt.addTotalPriceComponent(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.MonetaryComponent50_N.convertMonetaryComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Money50_N.convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Money50_N.convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Annotation50_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice convertInvoice(org.hl7.fhir.model.core.Invoice src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice tgt = new org.hl7.fhir.r5.model.Invoice();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertInvoiceStatus(src.getStatusElement()));
    if (src.hasCancelledReason())
      tgt.setCancelledReasonElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCancelledReasonElement()));
    if (src.hasType())
      tgt.setType(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getSubject()));
    if (src.hasRecipient())
      tgt.setRecipient(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getRecipient()));
    if (src.hasDate())
      tgt.setDateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertInvoiceParticipantComponent(t));
    if (src.hasIssuer())
      tgt.setIssuer(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getIssuer()));
    if (src.hasAccount())
      tgt.setAccount(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getAccount()));
    for (org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent t : src.getLineItemList())
      tgt.addLineItem(convertInvoiceLineItemComponent(t));
    for (org.hl7.fhir.model.core.MonetaryComponent t : src.getTotalPriceComponentList())
      tgt.addTotalPriceComponent(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.MonetaryComponent50_N.convertMonetaryComponent(t));
    if (src.hasTotalNet())
      tgt.setTotalNet(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Money50_N.convertMoney(src.getTotalNet()));
    if (src.hasTotalGross())
      tgt.setTotalGross(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Money50_N.convertMoney(src.getTotalGross()));
    if (src.hasPaymentTerms())
      tgt.setPaymentTermsElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getPaymentTermsElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList())
      tgt.addNote(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Annotation50_N.convertAnnotation(t));
    return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Invoice.InvoiceStatus> convertInvoiceStatus(
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Invoice.InvoiceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Invoice.InvoiceStatus> tgt =
      new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Invoice.InvoiceStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Invoice.InvoiceStatus> convertInvoiceStatus(
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Invoice.InvoiceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Invoice.InvoiceStatus> tgt =
      new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Invoice.InvoiceStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT -> tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.DRAFT);
        case ISSUED -> tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.ISSUED);
        case BALANCED -> tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.BALANCED);
        case CANCELLED -> tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.CANCELLED);
        case ENTEREDINERROR -> tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.ENTEREDINERROR);
        default -> tgt.setValue(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.NULL);
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(
    org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent tgt =
      new org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent convertInvoiceParticipantComponent(
    org.hl7.fhir.model.core.Invoice.InvoiceParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent tgt =
      new org.hl7.fhir.r5.model.Invoice.InvoiceParticipantComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getRole()));
    if (src.hasActor())
      tgt.setActor(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(
    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent tgt =
      new org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.PositiveInt50_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getServiced()));
    if (src.hasChargeItem())
      tgt.setChargeItem(ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getChargeItem()));
    for (org.hl7.fhir.r5.model.MonetaryComponent t : src.getPriceComponent())
      tgt.addPriceComponent(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.MonetaryComponent50_N.convertMonetaryComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent convertInvoiceLineItemComponent(
    org.hl7.fhir.model.core.Invoice.InvoiceLineItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent tgt =
      new org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.PositiveInt50_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getServiced()));
    if (src.hasChargeItem())
      tgt.setChargeItem(ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getChargeItem()));
    for (org.hl7.fhir.model.core.MonetaryComponent t : src.getPriceComponentList())
      tgt.addPriceComponent(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.MonetaryComponent50_N.convertMonetaryComponent(t));
    return tgt;
  }
}
