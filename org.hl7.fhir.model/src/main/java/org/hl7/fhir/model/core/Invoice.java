package org.hl7.fhir.model.core;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.Base.CopyObjectOptions;
import org.hl7.fhir.model.IModelContext;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * Compatibility representation of the R4/R5 Invoice resource for version conversion.
 */
@ResourceDef(name = "Invoice", profile = "http://hl7.org/fhir/StructureDefinition/Invoice")
public class Invoice extends DomainResource {

  public enum InvoiceStatus {
    DRAFT, ISSUED, BALANCED, CANCELLED, ENTEREDINERROR, NULL
  }

  public static class InvoiceStatusEnumFactory implements EnumFactory<InvoiceStatus> {
    private final IModelContext modelContext;

    public InvoiceStatusEnumFactory(IModelContext modelContext) {
      this.modelContext = modelContext;
    }

    public InvoiceStatusEnumFactory() {
      this(null);
    }

    @Override
    public InvoiceStatus fromCode(String code) {
      if (code == null || code.isEmpty()) return null;
      return switch (code) {
        case "draft" -> InvoiceStatus.DRAFT;
        case "issued" -> InvoiceStatus.ISSUED;
        case "balanced" -> InvoiceStatus.BALANCED;
        case "cancelled" -> InvoiceStatus.CANCELLED;
        case "entered-in-error" -> InvoiceStatus.ENTEREDINERROR;
        default -> throw new IllegalArgumentException("Unknown InvoiceStatus code '" + code + "'");
      };
    }

    public Enumeration<InvoiceStatus> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<>(modelContext, this, InvoiceStatus.NULL, code);
      String value = code.asStringValue();
      if (value == null || value.isEmpty())
        return new Enumeration<>(modelContext, this, InvoiceStatus.NULL, code);
      return new Enumeration<>(modelContext, this, fromCode(value), code);
    }

    @Override
    public String toCode(InvoiceStatus code) {
      if (code == null || code == InvoiceStatus.NULL) return null;
      return switch (code) {
        case DRAFT -> "draft";
        case ISSUED -> "issued";
        case BALANCED -> "balanced";
        case CANCELLED -> "cancelled";
        case ENTEREDINERROR -> "entered-in-error";
        case NULL -> null;
      };
    }

    @Override
    public String toSystem(InvoiceStatus code) {
      return code == null || code == InvoiceStatus.NULL ? null : "http://hl7.org/fhir/invoice-status";
    }
  }

  public static class InvoiceParticipantComponent extends BackboneElement implements IBaseBackboneElement {
    private CodeableConcept role;
    private Reference actor;

    public InvoiceParticipantComponent() {
    }

    public InvoiceParticipantComponent(IModelContext modelContext) {
      super(modelContext);
    }

    public CodeableConcept getRole() {
      return role;
    }

    public boolean hasRole() {
      return role != null && !role.isEmpty();
    }

    public InvoiceParticipantComponent setRole(CodeableConcept value) {
      if (value != null) value.setModelContext(modelContext);
      role = value;
      return this;
    }

    public Reference getActor() {
      return actor;
    }

    public boolean hasActor() {
      return actor != null && !actor.isEmpty();
    }

    public InvoiceParticipantComponent setActor(Reference value) {
      if (value != null) value.setModelContext(modelContext);
      actor = value;
      return this;
    }

    @Override
    public String fhirType() {
      return "Invoice.participant";
    }

    @Override
    public InvoiceParticipantComponent copy(EnumSet<CopyObjectOptions> options) {
      InvoiceParticipantComponent dst = new InvoiceParticipantComponent(modelContext);
      copyValues(dst, options);
      dst.role = role == null ? null : role.copy(options);
      dst.actor = actor == null ? null : actor.copy(options);
      return dst;
    }
  }

  public static class InvoiceLineItemComponent extends BackboneElement implements IBaseBackboneElement {
    private PositiveIntType sequence;
    private DataType serviced;
    private DataType chargeItem;
    private List<MonetaryComponent> priceComponent;

    public InvoiceLineItemComponent() {
    }

    public InvoiceLineItemComponent(IModelContext modelContext) {
      super(modelContext);
    }

    public PositiveIntType getSequenceElement() {
      return sequence;
    }

    public boolean hasSequence() {
      return sequence != null && !sequence.isEmpty();
    }

    public InvoiceLineItemComponent setSequenceElement(PositiveIntType value) {
      if (value != null) value.setModelContext(modelContext);
      sequence = value;
      return this;
    }

    public int getSequence() {
      return sequence == null || sequence.isEmpty() ? 0 : sequence.getValue();
    }

    public InvoiceLineItemComponent setSequence(int value) {
      if (sequence == null) sequence = new PositiveIntType(modelContext);
      sequence.setValue(value);
      return this;
    }

    public DataType getServiced() {
      return serviced;
    }

    public boolean hasServiced() {
      return serviced != null && !serviced.isEmpty();
    }

    public InvoiceLineItemComponent setServiced(DataType value) {
      if (value != null) value.setModelContext(modelContext);
      serviced = value;
      return this;
    }

    public DataType getChargeItem() {
      return chargeItem;
    }

    public boolean hasChargeItem() {
      return chargeItem != null && !chargeItem.isEmpty();
    }

    public InvoiceLineItemComponent setChargeItem(DataType value) {
      if (value != null) value.setModelContext(modelContext);
      chargeItem = value;
      return this;
    }

    public List<MonetaryComponent> getPriceComponentList() {
      if (priceComponent == null) priceComponent = new ArrayList<>();
      return priceComponent;
    }

    public InvoiceLineItemComponent addPriceComponent(MonetaryComponent value) {
      if (value != null) {
        value.setModelContext(modelContext);
        getPriceComponentList().add(value);
      }
      return this;
    }

    @Override
    public String fhirType() {
      return "Invoice.lineItem";
    }

    @Override
    public InvoiceLineItemComponent copy(EnumSet<CopyObjectOptions> options) {
      InvoiceLineItemComponent dst = new InvoiceLineItemComponent(modelContext);
      copyValues(dst, options);
      dst.sequence = sequence == null ? null : sequence.copy(options);
      dst.serviced = serviced == null ? null : serviced.copy(options);
      dst.chargeItem = chargeItem == null ? null : chargeItem.copy(options);
      if (priceComponent != null) {
        dst.priceComponent = new ArrayList<>();
        priceComponent.forEach(value -> dst.priceComponent.add(value.copy(options)));
      }
      return dst;
    }
  }

  private List<Identifier> identifier;
  private Enumeration<InvoiceStatus> status;
  private StringType cancelledReason;
  private CodeableConcept type;
  private Reference subject;
  private Reference recipient;
  private DateTimeType date;
  private List<InvoiceParticipantComponent> participant;
  private Reference issuer;
  private Reference account;
  private List<InvoiceLineItemComponent> lineItem;
  private List<MonetaryComponent> totalPriceComponent;
  private Money totalNet;
  private Money totalGross;
  private MarkdownType paymentTerms;
  private List<Annotation> note;

  public Invoice() {
  }

  public Invoice(IModelContext modelContext) {
    super(modelContext);
  }

  @Override
  public String fhirType() {
    return "Invoice";
  }

  @Override
  public String getResourceType() {
    return "Invoice";
  }

  public List<Identifier> getIdentifierList() {
    if (identifier == null) identifier = new ArrayList<>();
    return identifier;
  }

  public Invoice addIdentifier(Identifier value) {
    if (value != null) {
      value.setModelContext(modelContext);
      getIdentifierList().add(value);
    }
    return this;
  }

  public Enumeration<InvoiceStatus> getStatusElement() {
    return status;
  }

  public boolean hasStatus() {
    return status != null && !status.isEmpty();
  }

  public Invoice setStatusElement(Enumeration<InvoiceStatus> value) {
    if (value != null) value.setModelContext(modelContext);
    status = value;
    return this;
  }

  public StringType getCancelledReasonElement() {
    return cancelledReason;
  }

  public boolean hasCancelledReason() {
    return cancelledReason != null && !cancelledReason.isEmpty();
  }

  public Invoice setCancelledReasonElement(StringType value) {
    if (value != null) value.setModelContext(modelContext);
    cancelledReason = value;
    return this;
  }

  public CodeableConcept getType() {
    return type;
  }

  public boolean hasType() {
    return type != null && !type.isEmpty();
  }

  public Invoice setType(CodeableConcept value) {
    if (value != null) value.setModelContext(modelContext);
    type = value;
    return this;
  }

  public Reference getSubject() {
    return subject;
  }

  public boolean hasSubject() {
    return subject != null && !subject.isEmpty();
  }

  public Invoice setSubject(Reference value) {
    if (value != null) value.setModelContext(modelContext);
    subject = value;
    return this;
  }

  public Reference getRecipient() {
    return recipient;
  }

  public boolean hasRecipient() {
    return recipient != null && !recipient.isEmpty();
  }

  public Invoice setRecipient(Reference value) {
    if (value != null) value.setModelContext(modelContext);
    recipient = value;
    return this;
  }

  public DateTimeType getDateElement() {
    return date;
  }

  public boolean hasDate() {
    return date != null && !date.isEmpty();
  }

  public Invoice setDateElement(DateTimeType value) {
    if (value != null) value.setModelContext(modelContext);
    date = value;
    return this;
  }

  public List<InvoiceParticipantComponent> getParticipantList() {
    if (participant == null) participant = new ArrayList<>();
    return participant;
  }

  public Invoice addParticipant(InvoiceParticipantComponent value) {
    if (value != null) {
      value.setModelContext(modelContext);
      getParticipantList().add(value);
    }
    return this;
  }

  public List<InvoiceParticipantComponent> getParticipant() {
    return getParticipantList();
  }

  public Reference getIssuer() {
    return issuer;
  }

  public boolean hasIssuer() {
    return issuer != null && !issuer.isEmpty();
  }

  public Invoice setIssuer(Reference value) {
    if (value != null) value.setModelContext(modelContext);
    issuer = value;
    return this;
  }

  public Reference getAccount() {
    return account;
  }

  public boolean hasAccount() {
    return account != null && !account.isEmpty();
  }

  public Invoice setAccount(Reference value) {
    if (value != null) value.setModelContext(modelContext);
    account = value;
    return this;
  }

  public List<InvoiceLineItemComponent> getLineItemList() {
    if (lineItem == null) lineItem = new ArrayList<>();
    return lineItem;
  }

  public Invoice addLineItem(InvoiceLineItemComponent value) {
    if (value != null) {
      value.setModelContext(modelContext);
      getLineItemList().add(value);
    }
    return this;
  }

  public List<InvoiceLineItemComponent> getLineItem() {
    return getLineItemList();
  }

  public List<MonetaryComponent> getTotalPriceComponentList() {
    if (totalPriceComponent == null) totalPriceComponent = new ArrayList<>();
    return totalPriceComponent;
  }

  public Invoice addTotalPriceComponent(MonetaryComponent value) {
    if (value != null) {
      value.setModelContext(modelContext);
      getTotalPriceComponentList().add(value);
    }
    return this;
  }

  public Money getTotalNet() {
    return totalNet;
  }

  public boolean hasTotalNet() {
    return totalNet != null && !totalNet.isEmpty();
  }

  public Invoice setTotalNet(Money value) {
    if (value != null) value.setModelContext(modelContext);
    totalNet = value;
    return this;
  }

  public Money getTotalGross() {
    return totalGross;
  }

  public boolean hasTotalGross() {
    return totalGross != null && !totalGross.isEmpty();
  }

  public Invoice setTotalGross(Money value) {
    if (value != null) value.setModelContext(modelContext);
    totalGross = value;
    return this;
  }

  public MarkdownType getPaymentTermsElement() {
    return paymentTerms;
  }

  public boolean hasPaymentTerms() {
    return paymentTerms != null && !paymentTerms.isEmpty();
  }

  public Invoice setPaymentTermsElement(MarkdownType value) {
    if (value != null) value.setModelContext(modelContext);
    paymentTerms = value;
    return this;
  }

  public List<Annotation> getNoteList() {
    if (note == null) note = new ArrayList<>();
    return note;
  }

  public Invoice addNote(Annotation value) {
    if (value != null) {
      value.setModelContext(modelContext);
      getNoteList().add(value);
    }
    return this;
  }

  @Override
  public Invoice copy(EnumSet<CopyObjectOptions> options) {
    Invoice dst = new Invoice(modelContext);
    copyValues(dst, options);
    return dst;
  }

  @Override
  public void assignValues(Base dst, EnumSet<CopyObjectOptions> options) {
    copyValues((Invoice) dst, options);
  }

  public void copyValues(Invoice dst, EnumSet<CopyObjectOptions> options) {
    super.copyValues(dst, options);
    if (identifier != null) {
      dst.identifier = new ArrayList<>();
      identifier.forEach(value -> dst.identifier.add(value.copy(options)));
    }
    dst.status = status == null ? null : status.copy(options);
    dst.cancelledReason = cancelledReason == null ? null : cancelledReason.copy(options);
    dst.type = type == null ? null : type.copy(options);
    dst.subject = subject == null ? null : subject.copy(options);
    dst.recipient = recipient == null ? null : recipient.copy(options);
    dst.date = date == null ? null : date.copy(options);
    if (participant != null) {
      dst.participant = new ArrayList<>();
      participant.forEach(value -> dst.participant.add(value.copy(options)));
    }
    dst.issuer = issuer == null ? null : issuer.copy(options);
    dst.account = account == null ? null : account.copy(options);
    if (lineItem != null) {
      dst.lineItem = new ArrayList<>();
      lineItem.forEach(value -> dst.lineItem.add(value.copy(options)));
    }
    if (totalPriceComponent != null) {
      dst.totalPriceComponent = new ArrayList<>();
      totalPriceComponent.forEach(value -> dst.totalPriceComponent.add(value.copy(options)));
    }
    dst.totalNet = totalNet == null ? null : totalNet.copy(options);
    dst.totalGross = totalGross == null ? null : totalGross.copy(options);
    dst.paymentTerms = paymentTerms == null ? null : paymentTerms.copy(options);
    if (note != null) {
      dst.note = new ArrayList<>();
      note.forEach(value -> dst.note.add(value.copy(options)));
    }
  }

  @Override
  public void setModelContext(IModelContext modelContext) {
    super.setModelContext(modelContext);
    if (identifier != null) identifier.forEach(value -> value.setModelContext(modelContext));
    if (status != null) status.setModelContext(modelContext);
    if (cancelledReason != null) cancelledReason.setModelContext(modelContext);
    if (type != null) type.setModelContext(modelContext);
    if (subject != null) subject.setModelContext(modelContext);
    if (recipient != null) recipient.setModelContext(modelContext);
    if (date != null) date.setModelContext(modelContext);
    if (participant != null) participant.forEach(value -> value.setModelContext(modelContext));
    if (issuer != null) issuer.setModelContext(modelContext);
    if (account != null) account.setModelContext(modelContext);
    if (lineItem != null) lineItem.forEach(value -> value.setModelContext(modelContext));
    if (totalPriceComponent != null) totalPriceComponent.forEach(value -> value.setModelContext(modelContext));
    if (totalNet != null) totalNet.setModelContext(modelContext);
    if (totalGross != null) totalGross.setModelContext(modelContext);
    if (paymentTerms != null) paymentTerms.setModelContext(modelContext);
    if (note != null) note.forEach(value -> value.setModelContext(modelContext));
  }
}
