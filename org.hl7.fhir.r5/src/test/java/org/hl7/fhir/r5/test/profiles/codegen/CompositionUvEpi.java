package org.hl7.fhir.r5.test.profiles.codegen;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.Nullable;
import java.util.Date;


import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEInstance;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.gen.PEGeneratedBase;
import org.hl7.fhir.r5.profilemodel.gen.Min;
import org.hl7.fhir.r5.profilemodel.gen.Max;
import org.hl7.fhir.r5.profilemodel.gen.Label;
import org.hl7.fhir.r5.profilemodel.gen.Doco;
import org.hl7.fhir.r5.profilemodel.gen.BindingStrength;
import org.hl7.fhir.r5.profilemodel.gen.ValueSet;
import org.hl7.fhir.r5.profilemodel.gen.MustSupport;
import org.hl7.fhir.r5.profilemodel.gen.Definition;


// Generated by the HAPI Java Profile Generator, 5/11/24, 6:00 pm

/**
 * A set of healthcare-related information that is assembled together into a single 
 * logical package that provides a single coherent statement of meaning, 
 * establishes its own context and that has clinical attestation with regard to who 
 * is making the statement. A Composition defines the structure and narrative 
 * content necessary for a document. However, a Composition alone does not 
 * constitute a document. Rather, the Composition must be the first entry in a 
 * Bundle where Bundle.type=document, and any other resources referenced from 
 * Composition must be included as subsequent entries in the Bundle (for example 
 * Patient, Practitioner, Encounter, etc.).
 *
 */
public class CompositionUvEpi extends PEGeneratedBase {

  public static final String CANONICAL_URL = "http://hl7.org/fhir/uv/emedicinal-product-info/StructureDefinition/Composition-uv-epi|1.0.0";

  public enum CompositionStatus {
    REGISTERED, // "Registered" = http://hl7.org/fhir/composition-status#registered
    PARTIAL, // "Partial" = http://hl7.org/fhir/composition-status#partial
    PRELIMINARY, // "Preliminary" = http://hl7.org/fhir/composition-status#preliminary
    FINAL, // "Final" = http://hl7.org/fhir/composition-status#final
    AMENDED, // "Amended" = http://hl7.org/fhir/composition-status#amended
    CORRECTED, // "Corrected" = http://hl7.org/fhir/composition-status#corrected
    APPENDED, // "Appended" = http://hl7.org/fhir/composition-status#appended
    CANCELLED, // "Cancelled" = http://hl7.org/fhir/composition-status#cancelled
    ENTEREDINERROR, // "Entered in Error" = http://hl7.org/fhir/composition-status#entered-in-error
    DEPRECATED, // "Deprecated" = http://hl7.org/fhir/composition-status#deprecated
    UNKNOWN; // "Unknown" = http://hl7.org/fhir/composition-status#unknown

    public static CompositionStatus fromCode(String s) {
      switch (s) {
      case "registered": return REGISTERED;
      case "partial": return PARTIAL;
      case "preliminary": return PRELIMINARY;
      case "final": return FINAL;
      case "amended": return AMENDED;
      case "corrected": return CORRECTED;
      case "appended": return APPENDED;
      case "cancelled": return CANCELLED;
      case "entered-in-error": return ENTEREDINERROR;
      case "deprecated": return DEPRECATED;
      case "unknown": return UNKNOWN;
      default: return null;
      }
    }

    public static CompositionStatus fromCoding(Coding c) {
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "registered".equals(c.getCode())) {
        return REGISTERED;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "partial".equals(c.getCode())) {
        return PARTIAL;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "preliminary".equals(c.getCode())) {
        return PRELIMINARY;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "final".equals(c.getCode())) {
        return FINAL;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "amended".equals(c.getCode())) {
        return AMENDED;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "corrected".equals(c.getCode())) {
        return CORRECTED;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "appended".equals(c.getCode())) {
        return APPENDED;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "cancelled".equals(c.getCode())) {
        return CANCELLED;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "entered-in-error".equals(c.getCode())) {
        return ENTEREDINERROR;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "deprecated".equals(c.getCode())) {
        return DEPRECATED;
      }
      if ("http://hl7.org/fhir/composition-status".equals(c.getSystem()) && "unknown".equals(c.getCode())) {
        return UNKNOWN;
      }
      return null;
    }

    public static CompositionStatus fromCodeableConcept(CodeableConcept cc) {
      for (Coding c : cc.getCoding()) {
        CompositionStatus v = fromCoding(c);
        if (v != null) {
          return v;
        }
      }
      return null;
    }

    public String toDisplay() {
      switch (this) {
      case REGISTERED: return "Registered";
      case PARTIAL: return "Partial";
      case PRELIMINARY: return "Preliminary";
      case FINAL: return "Final";
      case AMENDED: return "Amended";
      case CORRECTED: return "Corrected";
      case APPENDED: return "Appended";
      case CANCELLED: return "Cancelled";
      case ENTEREDINERROR: return "Entered in Error";
      case DEPRECATED: return "Deprecated";
      case UNKNOWN: return "Unknown";
      default: return null;
      }
    }

    public String toCode() {
      switch (this) {
      case REGISTERED: return "registered";
      case PARTIAL: return "partial";
      case PRELIMINARY: return "preliminary";
      case FINAL: return "final";
      case AMENDED: return "amended";
      case CORRECTED: return "corrected";
      case APPENDED: return "appended";
      case CANCELLED: return "cancelled";
      case ENTEREDINERROR: return "entered-in-error";
      case DEPRECATED: return "deprecated";
      case UNKNOWN: return "unknown";
      default: return null;
      }
    }

    public Coding toCoding() {
      switch (this) {
      case REGISTERED: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("registered");
      case PARTIAL: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("partial");
      case PRELIMINARY: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("preliminary");
      case FINAL: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("final");
      case AMENDED: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("amended");
      case CORRECTED: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("corrected");
      case APPENDED: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("appended");
      case CANCELLED: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("cancelled");
      case ENTEREDINERROR: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("entered-in-error");
      case DEPRECATED: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("deprecated");
      case UNKNOWN: return new Coding().setSystem("http://hl7.org/fhir/composition-status").setCode("unknown");
      default: return null;
      }
    }

    public CodeableConcept toCodeableConcept() {
      Coding c = toCoding();
      return c == null ? null : new CodeableConcept().addCoding(c);
    }
  }

  @Min("0") @Max("1") @Doco("")
  private String id;  // 

  @Min("0") @Max("*") @Doco("Additional content defined by implementations")
  @Definition("May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.")
  private List<Extension> extensions = new ArrayList<>();  // Additional content defined by implementations

  @Min("0") @Max("*") @Doco("Extensions that cannot be ignored")
  @Definition("May be used to represent additional information that is not part of the basic definition of the resource and that modifies the understanding of the element that contains it and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).")
  private List<Extension> modifierExtensions = new ArrayList<>();  // Extensions that cannot be ignored

  @Min("1") @Max("*") @Doco("Unique identifier only for this version of the Composition")
  @Definition("Unlike the Bundle identifier which persists, the Composition identifier does not persist across versions. Each new version of the Composition receives a new identifier.")
  private List<Identifier> identifiers = new ArrayList<>();// @NotNull  // Unique identifier only for this version of the Composition

  @Min("1") @Max("1") @Doco("preliminary|final|amended|entered-in-error|deprecated")
  @BindingStrength("required") @ValueSet("http://hl7.org/fhir/ValueSet/composition-status|5.0.0")
  @Definition("The workflow/clinical status of this composition. The status is a marker for the clinical standing of the document.")
  private CompositionStatus status;// @NotNull  // preliminary|final|amended|entered-in-error|deprecated

  @Min("1") @Max("1") @Doco("Type of ePI document template")
  @BindingStrength("preferred") @ValueSet("http://hl7.org/fhir/ValueSet/doc-typecodes")
  @Definition("Specifies the type of ePI template. For example, Package Insert, Patient Information, Summary of Product Characteristics, Human Prescription, Drug Label.")
  private CodeableConcept type;// @NotNull  // Type of ePI document template

  @Min("0") @Max("*") @Doco("The authorized medicinal product(s) that this ePI's composition is about")
  @Definition("Who or what the composition is about. The composition can be about a person, (patient or healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about a herd of livestock, or a set of patients that share a common exposure).")
  private List<Reference> subjects = new ArrayList<>();  // The authorized medicinal product(s) that this ePI's composition is about

  @Min("0") @Max("1") @Doco("Context of the Composition")
  @Definition("Describes the clinical encounter or type of care this documentation is associated with.")
  private Reference encounter;  // Context of the Composition

  @Min("1") @Max("1") @Doco("Date of last revision for this version of the authorized ePI.")
  @Definition("The composition editing time, when the composition was last logically changed by the author.")
  private Date date;// @NotNull  // Date of last revision for this version of the authorized ePI.

  @Min("0") @Max("*") @Doco("The context that the content is intended to support")
  @Definition("The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate Composition instances.")
  private List<UsageContext> useContexts = new ArrayList<>();  // The context that the content is intended to support

  @Min("1") @Max("*") @Doco("The Organization responsible for the ePI")
  @Definition("Link to the Organization resource that describes the organization responsible for the ePI (For example, Markting Authorization Holder).")
  private List<Reference> authors = new ArrayList<>();// @NotNull  // The Organization responsible for the ePI

  @Min("1") @Max("1") @Doco("Title of the ePI Document")
  @Definition("A brief summary name describing the ePI. The title should include: Proprietary Name(s) (Non-proprietary Name(s)) Dose Form, Route of Administration.")
  private String title;// @NotNull  // Title of the ePI Document

  @Min("0") @Max("*") @Doco("For any additional notes")
  @Definition("For any additional notes.")
  private List<Annotation> notes = new ArrayList<>();  // For any additional notes

  @Min("0") @Max("*") @Doco("Attests to accuracy of composition")
  @Definition("A participant who has attested to the accuracy of the composition/document.")
  private List<BackboneElement> attesters = new ArrayList<>();  // Attests to accuracy of composition

  @Min("0") @Max("1") @Doco("Organization which maintains the composition")
  @Definition("Identifies the organization or group who is responsible for ongoing maintenance of and access to the composition/document information.")
  private Reference custodian;  // Organization which maintains the composition

  @Min("0") @Max("*") @Doco("Cross-reference to anotherother ePI compositions or ePI document()s)")
  @Definition("A crossreference from this ePI's composition to another related Composition or ePI document.")
  private List<RelatedArtifact> relatesTos = new ArrayList<>();  // Cross-reference to anotherother ePI compositions or ePI document()s)

  @Min("0") @Max("*") @Doco("The clinical service(s) being documented")
  @Definition("The clinical service, such as a colonoscopy or an appendectomy, being documented.")
  private List<BackboneElement> events = new ArrayList<>();  // The clinical service(s) being documented

  @Min("1") @Max("*") @Doco("Level 1 section heading for the whole ePI")
  @Definition("This is the root or level 1 section heading in the ePI. All other section headings are sub-sections, or children, of this section heading")
  private List<BackboneElement> sections = new ArrayList<>();// @NotNull  // Level 1 section heading for the whole ePI


  /**
   * Parameter-less constructor.
   *
   */
  public CompositionUvEpi() {
  }

  /**
   * Construct an instance of the object, and fill out all the fixed values 
   *
   */
  public CompositionUvEpi(IWorkerContext context) {
    workerContext = context;
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance src = builder.buildPEInstance(CANONICAL_URL, builder.createResource(CANONICAL_URL, false));
    load(src);
  }

  /**
   * Populate an instance of the object based on this source object 
   *
   */
  public static CompositionUvEpi fromSource(IWorkerContext context, Composition source) {
    CompositionUvEpi theThing = new CompositionUvEpi();
    theThing.workerContext = context;
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance src = builder.buildPEInstance(CANONICAL_URL, source);
    theThing.load(src);
    return theThing;
  }


  public void load(PEInstance src) {
    clear();
    if (src.hasChild("id")) {
      id = ((IdType) src.child("id").asDataType()).getValue();
    }
    for (PEInstance item : src.children("extension")) {
      extensions.add((Extension) item.asDataType());
    }
    for (PEInstance item : src.children("modifierExtension")) {
      modifierExtensions.add((Extension) item.asDataType());
    }
    for (PEInstance item : src.children("identifier")) {
      identifiers.add((Identifier) item.asDataType());
    }
    if (src.hasChild("status")) {
      status = CompositionStatus.fromCode(src.child("status").asDataType().primitiveValue());
    }
    if (src.hasChild("type")) {
      type = (CodeableConcept) src.child("type").asDataType();
    }
    for (PEInstance item : src.children("subject")) {
      subjects.add((Reference) item.asDataType());
    }
    if (src.hasChild("encounter")) {
      encounter = (Reference) src.child("encounter").asDataType();
    }
    if (src.hasChild("date")) {
      date = ((DateTimeType) src.child("date").asDataType()).getValue();
    }
    for (PEInstance item : src.children("useContext")) {
      useContexts.add((UsageContext) item.asDataType());
    }
    for (PEInstance item : src.children("author")) {
      authors.add((Reference) item.asDataType());
    }
    if (src.hasChild("title")) {
      title = ((StringType) src.child("title").asDataType()).getValue();
    }
    for (PEInstance item : src.children("note")) {
      notes.add((Annotation) item.asDataType());
    }
    for (PEInstance item : src.children("attester")) {
      attesters.add((BackboneElement) item.asElement());
    }
    if (src.hasChild("custodian")) {
      custodian = (Reference) src.child("custodian").asDataType();
    }
    for (PEInstance item : src.children("relatesTo")) {
      relatesTos.add((RelatedArtifact) item.asDataType());
    }
    for (PEInstance item : src.children("event")) {
      events.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("section")) {
      sections.add((BackboneElement) item.asElement());
    }

  }

  /**
   * Build a instance of the underlying object based on this wrapping object 
   *
   */
  public Composition build(IWorkerContext context) {
    workerContext = context;
    return build();
  }

  /**
   * Build a instance of the underlying object based on this wrapping object 
   *
   */
  public Composition build() {
    Composition theThing = new Composition();
    PEBuilder builder = new PEBuilder(workerContext, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance tgt = builder.buildPEInstance(CANONICAL_URL, theThing);
    save(tgt, false);
    return theThing;
  }

  /**
   * Save this profile class into an existing resource (overwriting anything that 
   * exists in the profile) 
   *
   */
  public void save(IWorkerContext context, Composition dest, boolean nulls) {
    workerContext = context;
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance tgt = builder.buildPEInstance(CANONICAL_URL, dest);
    save(tgt, nulls);
  }

  public void save(PEInstance tgt, boolean nulls) {
    tgt.clear("id");
    if (id != null) {
      tgt.makeChild("id").data().setProperty("value", new IdType(id));
    }
    tgt.clear("extension");
    for (Extension item : extensions) {
      tgt.addChild("extension", item);
    }
    tgt.clear("modifierExtension");
    for (Extension item : modifierExtensions) {
      tgt.addChild("modifierExtension", item);
    }
    tgt.clear("identifier");
    for (Identifier item : identifiers) {
      tgt.addChild("identifier", item);
    }
    tgt.clear("status");
    if (status != null) {
      tgt.addChild("status", status.toCode());
    }
    tgt.clear("type");
    if (type != null) {
      tgt.addChild("type", type);
    }
    tgt.clear("subject");
    for (Reference item : subjects) {
      tgt.addChild("subject", item);
    }
    tgt.clear("encounter");
    if (encounter != null) {
      tgt.addChild("encounter", encounter);
    }
    tgt.clear("date");
    if (date != null) {
      tgt.addChild("date", new DateTimeType(date));
    }
    tgt.clear("useContext");
    for (UsageContext item : useContexts) {
      tgt.addChild("useContext", item);
    }
    tgt.clear("author");
    for (Reference item : authors) {
      tgt.addChild("author", item);
    }
    tgt.clear("title");
    if (title != null) {
      tgt.makeChild("title").data().setProperty("value", new StringType(title));
    }
    tgt.clear("note");
    for (Annotation item : notes) {
      tgt.addChild("note", item);
    }
    tgt.clear("attester");
    for (BackboneElement item : attesters) {
      tgt.addChild("attester", item);
    }
    tgt.clear("custodian");
    if (custodian != null) {
      tgt.addChild("custodian", custodian);
    }
    tgt.clear("relatesTo");
    for (RelatedArtifact item : relatesTos) {
      tgt.addChild("relatesTo", item);
    }
    tgt.clear("event");
    for (BackboneElement item : events) {
      tgt.addChild("event", item);
    }
    tgt.clear("section");
    for (BackboneElement item : sections) {
      tgt.addChild("section", item);
    }

  }

  public String getId() {
    return id;
  }

  public CompositionUvEpi setId(String value) {
    this.id = value;
    return this;
  }

  public boolean hasId() {
    return id != null;
  }

  /**
   * May be used to represent additional information that is not part of the basic 
   * definition of the resource. To make the use of extensions safe and managable, 
   * there is a strict set of governance applied to the definition and use of 
   * extensions. Though any implementer can define an extension, there is a set of 
   * requirements that SHALL be met as part of the definition of the extension.
   *
   */
  public List<Extension> getExtensions() {
    if (extensions == null) { extensions = new ArrayList<>(); }
    return extensions;
  }

  public boolean hasExtensions() {
    return extensions != null && !extensions.isEmpty();
  }

  public Extension addExtension() {
    Extension theThing = new Extension();
    getExtensions().add(theThing);
    return theThing;
  }

  public boolean hasExtension(Extension item) {
    return hasExtensions() && extensions.contains(item);
  }

  public void removeExtension(Extension item) {
    if (hasExtension(item)) {
      extensions.remove(item);
    }
  }


  /**
   * May be used to represent additional information that is not part of the basic 
   * definition of the resource and that modifies the understanding of the element 
   * that contains it and/or the understanding of the containing element's 
   * descendants. Usually modifier elements provide negation or qualification. To 
   * make the use of extensions safe and managable, there is a strict set of 
   * governance applied to the definition and use of extensions. Though any 
   * implementer is allowed to define an extension, there is a set of requirements 
   * that SHALL be met as part of the definition of the extension. Applications 
   * processing a resource are required to check for modifier extensions.
   *
   * 
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on Resource or 
   * DomainResource (including cannot change the meaning of modifierExtension 
   * itself).
   *
   */
  public List<Extension> getModifierExtensions() {
    if (modifierExtensions == null) { modifierExtensions = new ArrayList<>(); }
    return modifierExtensions;
  }

  public boolean hasModifierExtensions() {
    return modifierExtensions != null && !modifierExtensions.isEmpty();
  }

  public Extension addModifierExtension() {
    Extension theThing = new Extension();
    getModifierExtensions().add(theThing);
    return theThing;
  }

  public boolean hasModifierExtension(Extension item) {
    return hasModifierExtensions() && modifierExtensions.contains(item);
  }

  public void removeModifierExtension(Extension item) {
    if (hasModifierExtension(item)) {
      modifierExtensions.remove(item);
    }
  }


  /**
   * Unlike the Bundle identifier which persists, the Composition identifier does not 
   * persist across versions. Each new version of the Composition receives a new 
   * identifier.
   *
   */
  public List<Identifier> getIdentifiers() {
    if (identifiers == null) { identifiers = new ArrayList<>(); }
    return identifiers;
  }

  public boolean hasIdentifiers() {
    return identifiers != null && !identifiers.isEmpty();
  }

  public Identifier addIdentifier() {
    Identifier theThing = new Identifier();
    getIdentifiers().add(theThing);
    return theThing;
  }

  public boolean hasIdentifier(Identifier item) {
    return hasIdentifiers() && identifiers.contains(item);
  }

  public void removeIdentifier(Identifier item) {
    if (hasIdentifier(item)) {
      identifiers.remove(item);
    }
  }


  /**
   * The workflow/clinical status of this composition. The status is a marker for the 
   * clinical standing of the document.
   *
   */
  public CompositionStatus getStatus() {
    return status;
  }

  public CompositionUvEpi setStatus(CompositionStatus value) {
    this.status = value;
    return this;
  }

  public boolean hasStatus() {
    return status != null;
  }

  /**
   * Specifies the type of ePI template. For example, Package Insert, Patient 
   * Information, Summary of Product Characteristics, Human Prescription, Drug Label.
   *
   */
  public CodeableConcept getType() {
    if (type == null) { type = new CodeableConcept(); }
    return type;
  }

  public CompositionUvEpi setType(CodeableConcept value) {
    this.type = value;
    return this;
  }
  public boolean hasType() {
    return type != null;
  }

  /**
   * Who or what the composition is about. The composition can be about a person, 
   * (patient or healthcare practitioner), a device (e.g. a machine) or even a group 
   * of subjects (such as a document about a herd of livestock, or a set of patients 
   * that share a common exposure).
   *
   */
  public List<Reference> getSubjects() {
    if (subjects == null) { subjects = new ArrayList<>(); }
    return subjects;
  }

  public boolean hasSubjects() {
    return subjects != null && !subjects.isEmpty();
  }

  public Reference addSubject() {
    Reference theThing = new Reference();
    getSubjects().add(theThing);
    return theThing;
  }

  public boolean hasSubject(Reference item) {
    return hasSubjects() && subjects.contains(item);
  }

  public void removeSubject(Reference item) {
    if (hasSubject(item)) {
      subjects.remove(item);
    }
  }


  /**
   * Describes the clinical encounter or type of care this documentation is 
   * associated with.
   *
   */
  public Reference getEncounter() {
    if (encounter == null) { encounter = new Reference(); }
    return encounter;
  }

  public CompositionUvEpi setEncounter(Reference value) {
    this.encounter = value;
    return this;
  }
  public boolean hasEncounter() {
    return encounter != null;
  }

  /**
   * The composition editing time, when the composition was last logically changed by 
   * the author.
   *
   */
  public Date getDate() {
    return date;
  }

  public CompositionUvEpi setDate(Date value) {
    this.date = value;
    return this;
  }

  public boolean hasDate() {
    return date != null;
  }

  /**
   * The content was developed with a focus and intent of supporting the contexts 
   * that are listed. These contexts may be general categories (gender, age, ...) or 
   * may be references to specific programs (insurance plans, studies, ...) and may 
   * be used to assist with indexing and searching for appropriate Composition 
   * instances.
   *
   */
  public List<UsageContext> getUseContexts() {
    if (useContexts == null) { useContexts = new ArrayList<>(); }
    return useContexts;
  }

  public boolean hasUseContexts() {
    return useContexts != null && !useContexts.isEmpty();
  }

  public UsageContext addUseContext() {
    UsageContext theThing = new UsageContext();
    getUseContexts().add(theThing);
    return theThing;
  }

  public boolean hasUseContext(UsageContext item) {
    return hasUseContexts() && useContexts.contains(item);
  }

  public void removeUseContext(UsageContext item) {
    if (hasUseContext(item)) {
      useContexts.remove(item);
    }
  }


  /**
   * Link to the Organization resource that describes the organization responsible 
   * for the ePI (For example, Markting Authorization Holder).
   *
   */
  public List<Reference> getAuthors() {
    if (authors == null) { authors = new ArrayList<>(); }
    return authors;
  }

  public boolean hasAuthors() {
    return authors != null && !authors.isEmpty();
  }

  public Reference addAuthor() {
    Reference theThing = new Reference();
    getAuthors().add(theThing);
    return theThing;
  }

  public boolean hasAuthor(Reference item) {
    return hasAuthors() && authors.contains(item);
  }

  public void removeAuthor(Reference item) {
    if (hasAuthor(item)) {
      authors.remove(item);
    }
  }


  /**
   * A brief summary name describing the ePI. The title should include: Proprietary 
   * Name(s) (Non-proprietary Name(s)) Dose Form, Route of Administration.
   *
   */
  public String getTitle() {
    return title;
  }

  public CompositionUvEpi setTitle(String value) {
    this.title = value;
    return this;
  }

  public boolean hasTitle() {
    return title != null;
  }

  /**
   * For any additional notes.
   *
   */
  public List<Annotation> getNotes() {
    if (notes == null) { notes = new ArrayList<>(); }
    return notes;
  }

  public boolean hasNotes() {
    return notes != null && !notes.isEmpty();
  }

  public Annotation addNote() {
    Annotation theThing = new Annotation();
    getNotes().add(theThing);
    return theThing;
  }

  public boolean hasNote(Annotation item) {
    return hasNotes() && notes.contains(item);
  }

  public void removeNote(Annotation item) {
    if (hasNote(item)) {
      notes.remove(item);
    }
  }


  /**
   * A participant who has attested to the accuracy of the composition/document.
   *
   */
  public List<BackboneElement> getAttesters() {
    if (attesters == null) { attesters = new ArrayList<>(); }
    return attesters;
  }

  public boolean hasAttesters() {
    return attesters != null && !attesters.isEmpty();
  }

  public boolean hasAttester(BackboneElement item) {
    return hasAttesters() && attesters.contains(item);
  }

  public void removeAttester(BackboneElement item) {
    if (hasAttester(item)) {
      attesters.remove(item);
    }
  }


  /**
   * Identifies the organization or group who is responsible for ongoing maintenance 
   * of and access to the composition/document information.
   *
   */
  public Reference getCustodian() {
    if (custodian == null) { custodian = new Reference(); }
    return custodian;
  }

  public CompositionUvEpi setCustodian(Reference value) {
    this.custodian = value;
    return this;
  }
  public boolean hasCustodian() {
    return custodian != null;
  }

  /**
   * A crossreference from this ePI's composition to another related Composition or 
   * ePI document.
   *
   */
  public List<RelatedArtifact> getRelatesTos() {
    if (relatesTos == null) { relatesTos = new ArrayList<>(); }
    return relatesTos;
  }

  public boolean hasRelatesTos() {
    return relatesTos != null && !relatesTos.isEmpty();
  }

  public RelatedArtifact addRelatesTo() {
    RelatedArtifact theThing = new RelatedArtifact();
    getRelatesTos().add(theThing);
    return theThing;
  }

  public boolean hasRelatesTo(RelatedArtifact item) {
    return hasRelatesTos() && relatesTos.contains(item);
  }

  public void removeRelatesTo(RelatedArtifact item) {
    if (hasRelatesTo(item)) {
      relatesTos.remove(item);
    }
  }


  /**
   * The clinical service, such as a colonoscopy or an appendectomy, being 
   * documented.
   *
   */
  public List<BackboneElement> getEvents() {
    if (events == null) { events = new ArrayList<>(); }
    return events;
  }

  public boolean hasEvents() {
    return events != null && !events.isEmpty();
  }

  public boolean hasEvent(BackboneElement item) {
    return hasEvents() && events.contains(item);
  }

  public void removeEvent(BackboneElement item) {
    if (hasEvent(item)) {
      events.remove(item);
    }
  }


  /**
   * This is the root or level 1 section heading in the ePI. All other section 
   * headings are sub-sections, or children, of this section heading
   *
   */
  public List<BackboneElement> getSections() {
    if (sections == null) { sections = new ArrayList<>(); }
    return sections;
  }

  public boolean hasSections() {
    return sections != null && !sections.isEmpty();
  }

  public boolean hasSection(BackboneElement item) {
    return hasSections() && sections.contains(item);
  }

  public void removeSection(BackboneElement item) {
    if (hasSection(item)) {
      sections.remove(item);
    }
  }




  public void clear() {
    id = null;
    extensions.clear();
    modifierExtensions.clear();
    identifiers.clear();
    status = null;
    type = null;
    subjects.clear();
    encounter = null;
    date = null;
    useContexts.clear();
    authors.clear();
    title = null;
    notes.clear();
    attesters.clear();
    custodian = null;
    relatesTos.clear();
    events.clear();
    sections.clear();

  }

}
