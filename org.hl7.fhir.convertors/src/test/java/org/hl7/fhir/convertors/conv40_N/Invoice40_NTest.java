package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Invoice40_NTest {

  @Test
  @DisplayName("R4 Invoice converts to and from the compatibility model")
  void testInvoiceRoundTrip() throws Exception {
    org.hl7.fhir.r4.model.Invoice src = new org.hl7.fhir.r4.model.Invoice();
    src.setId("invoice-1");
    src.addIdentifier().setSystem("http://example.org/invoices").setValue("INV-1");
    src.setStatus(org.hl7.fhir.r4.model.Invoice.InvoiceStatus.ISSUED);
    src.setCancelledReason("duplicate");
    src.setSubject(new org.hl7.fhir.r4.model.Reference("Patient/p1"));
    src.setRecipient(new org.hl7.fhir.r4.model.Reference("Organization/recipient"));
    src.setDateElement(new org.hl7.fhir.r4.model.DateTimeType("2024-01-02"));
    src.addParticipant().setActor(new org.hl7.fhir.r4.model.Reference("Practitioner/p1"));
    src.setIssuer(new org.hl7.fhir.r4.model.Reference("Organization/issuer"));
    src.setAccount(new org.hl7.fhir.r4.model.Reference("Account/a1"));

    org.hl7.fhir.r4.model.Invoice.InvoiceLineItemComponent lineItem = src.addLineItem().setSequence(1);
    lineItem.setChargeItem(new org.hl7.fhir.r4.model.CodeableConcept().setText("Consultation"));
    lineItem.addPriceComponent()
      .setType(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.BASE)
      .setAmount(new org.hl7.fhir.r4.model.Money().setCurrency("USD").setValue(100));
    src.addTotalPriceComponent()
      .setType(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.TAX)
      .setAmount(new org.hl7.fhir.r4.model.Money().setCurrency("USD").setValue(10));
    src.setTotalNet(new org.hl7.fhir.r4.model.Money().setCurrency("USD").setValue(100));
    src.setTotalGross(new org.hl7.fhir.r4.model.Money().setCurrency("USD").setValue(110));
    src.setPaymentTerms("Payment due within 30 days");
    src.addNote().setText("Invoice note");

    org.hl7.fhir.model.core.Invoice converted =
      (org.hl7.fhir.model.core.Invoice) VersionConvertorFactory_40_N.convertResource(src);

    assertEquals("invoice-1", converted.getId());
    assertEquals("INV-1", converted.getIdentifierList().get(0).getValue());
    assertEquals(org.hl7.fhir.model.core.Invoice.InvoiceStatus.ISSUED, converted.getStatusElement().getValue());
    assertEquals("Patient/p1", converted.getSubject().getReference());
    assertEquals("Practitioner/p1", converted.getParticipantList().get(0).getActor().getReference());
    assertEquals(1, converted.getLineItemList().get(0).getSequence());
    assertEquals("Consultation", ((org.hl7.fhir.model.core.CodeableConcept) converted.getLineItemList().get(0).getChargeItem()).getText());
    assertEquals(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.BASE,
      converted.getLineItemList().get(0).getPriceComponentList().get(0).getType());
    assertEquals("110", converted.getTotalGross().getValue().toPlainString());
    assertEquals("Invoice note", converted.getNoteList().get(0).getText());

    org.hl7.fhir.r4.model.Invoice back =
      (org.hl7.fhir.r4.model.Invoice) VersionConvertorFactory_40_N.convertResource(converted);
    assertNotNull(back);
    assertTrue(src.equalsDeep(back), "the Invoice should round-trip without losing fields");
  }

  @Test
  @DisplayName("R4 deduction price components map to the R6 discount code")
  void testDeductionPriceComponent() throws Exception {
    org.hl7.fhir.r4.model.Invoice src = new org.hl7.fhir.r4.model.Invoice();
    src.addTotalPriceComponent()
      .setType(org.hl7.fhir.r4.model.Invoice.InvoicePriceComponentType.DEDUCTION);

    org.hl7.fhir.model.core.Invoice converted =
      (org.hl7.fhir.model.core.Invoice) VersionConvertorFactory_40_N.convertResource(src);

    assertEquals(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.DISCOUNT,
      converted.getTotalPriceComponentList().get(0).getType());
  }
}
