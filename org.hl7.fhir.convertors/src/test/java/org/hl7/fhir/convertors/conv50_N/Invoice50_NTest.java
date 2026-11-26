package org.hl7.fhir.convertors.conv50_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Invoice50_NTest {

  @Test
  @DisplayName("R5 Invoice converts to and from the compatibility model")
  void testInvoiceRoundTrip() throws Exception {
    org.hl7.fhir.r5.model.Invoice src = new org.hl7.fhir.r5.model.Invoice();
    src.setId("invoice-2");
    src.addIdentifier().setSystem("http://example.org/invoices").setValue("INV-2");
    src.setStatus(org.hl7.fhir.r5.model.Invoice.InvoiceStatus.BALANCED);
    src.setSubject(new org.hl7.fhir.r5.model.Reference("Patient/p2"));
    src.setDateElement(new org.hl7.fhir.r5.model.DateTimeType("2025-02-03"));
    src.addParticipant().setActor(new org.hl7.fhir.r5.model.Reference("Practitioner/p2"));

    org.hl7.fhir.r5.model.Invoice.InvoiceLineItemComponent lineItem = src.addLineItem().setSequence(2);
    lineItem.setServiced(new org.hl7.fhir.r5.model.Period()
      .setStartElement(new org.hl7.fhir.r5.model.DateTimeType("2025-01-01"))
      .setEndElement(new org.hl7.fhir.r5.model.DateTimeType("2025-01-02")));
    lineItem.setChargeItem(new org.hl7.fhir.r5.model.CodeableConcept().setText("Procedure"));
    lineItem.addPriceComponent()
      .setType(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.BASE)
      .setAmount(new org.hl7.fhir.r5.model.Money().setCurrency("EUR").setValue(75));
    src.addTotalPriceComponent()
      .setType(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.TAX)
      .setAmount(new org.hl7.fhir.r5.model.Money().setCurrency("EUR").setValue(5));
    src.setTotalNet(new org.hl7.fhir.r5.model.Money().setCurrency("EUR").setValue(75));
    src.setTotalGross(new org.hl7.fhir.r5.model.Money().setCurrency("EUR").setValue(80));
    src.setPaymentTerms("Paid");
    src.addNote().setText("Paid in full");

    org.hl7.fhir.model.core.Invoice converted =
      (org.hl7.fhir.model.core.Invoice) VersionConvertorFactory_50_N.convertResource(src);

    assertEquals("invoice-2", converted.getId());
    assertEquals(org.hl7.fhir.model.core.Invoice.InvoiceStatus.BALANCED, converted.getStatusElement().getValue());
    assertEquals(2, converted.getLineItemList().get(0).getSequence());
    assertTrue(converted.getLineItemList().get(0).getServiced() instanceof org.hl7.fhir.model.core.Period);
    assertEquals("Procedure", ((org.hl7.fhir.model.core.CodeableConcept) converted.getLineItemList().get(0).getChargeItem()).getText());
    assertEquals(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.BASE,
      converted.getLineItemList().get(0).getPriceComponentList().get(0).getType());
    assertEquals("80", converted.getTotalGross().getValue().toPlainString());
    assertEquals("Paid in full", converted.getNoteList().get(0).getText());

    org.hl7.fhir.r5.model.Invoice back =
      (org.hl7.fhir.r5.model.Invoice) VersionConvertorFactory_50_N.convertResource(converted);
    assertNotNull(back);
    assertTrue(src.equalsDeep(back), "the Invoice should round-trip without losing fields");
  }

  @Test
  @DisplayName("R5 deduction price components map to the R6 discount code")
  void testDeductionPriceComponent() throws Exception {
    org.hl7.fhir.r5.model.Invoice src = new org.hl7.fhir.r5.model.Invoice();
    src.addTotalPriceComponent()
      .setType(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.DEDUCTION);

    org.hl7.fhir.model.core.Invoice converted =
      (org.hl7.fhir.model.core.Invoice) VersionConvertorFactory_50_N.convertResource(src);

    assertEquals(org.hl7.fhir.model.core.MonetaryComponent.PriceComponentType.DISCOUNT,
      converted.getTotalPriceComponentList().get(0).getType());
  }
}
