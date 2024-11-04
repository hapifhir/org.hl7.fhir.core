package org.hl7.fhir.r5.test.profiles;

/*
 * Licensed under CC0 1.0 Universal (CC0 1.0).
 *
 * The person who associated a work with this deed has dedicated the work to the 
 * public domain by waiving all of his or her rights to the work worldwide under 
 * copyright law, including all related and neighboring rights, to the extent 
 * allowed by law.
 *
 * You can copy, modify, distribute and perform the work, even for commercial 
 * purposes, all without asking permission. See Other Information below.
 *
 */
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


/*
Licensed under CC0 1.0 Universal (CC0 1.0).
The person who associated a work with this deed has dedicated the work to the public domain by waiving all of his or her rights to the work worldwide under copyright law, including all related and neighboring rights, to the extent allowed by law.
You can copy, modify, distribute and perform the work, even for commercial purposes, all without asking permission. See Other Information below.
 */

// Generated by the HAPI Java Profile Generator, {date}

/**
 * Test Observation Profile.
 *
 */
public class TestProfile extends PEGeneratedBase {

  public static final String CANONICAL_URL = "http://hl7.org/fhir/test/StructureDefinition/pe-profile1|0.1";

  public enum ProfileObservationCategoryCode {
    LABORATORY, // "Laboratory" = http://terminology.hl7.org/CodeSystem/observation-category#laboratory
    IMAGING; // "Imaging" = http://terminology.hl7.org/CodeSystem/observation-category#imaging

    public static ProfileObservationCategoryCode fromCode(String s) {
      switch (s) {
      case "laboratory": return LABORATORY;
      case "imaging": return IMAGING;
      default: return null;
      }
    }

    public static ProfileObservationCategoryCode fromCoding(Coding c) {
      if ("http://terminology.hl7.org/CodeSystem/observation-category".equals(c.getSystem()) && "laboratory".equals(c.getCode())) {
        return LABORATORY;
      }
      if ("http://terminology.hl7.org/CodeSystem/observation-category".equals(c.getSystem()) && "imaging".equals(c.getCode())) {
        return IMAGING;
      }
      return null;
    }

    public static ProfileObservationCategoryCode fromCodeableConcept(CodeableConcept cc) {
      for (Coding c : cc.getCoding()) {
        ProfileObservationCategoryCode v = fromCoding(c);
        if (v != null) {
          return v;
        }
      }
      return null;
    }

    public String toDisplay() {
      switch (this) {
      case LABORATORY: return "Laboratory";
      case IMAGING: return "Imaging";
      default: return null;
      }
    }

    public String toCode() {
      switch (this) {
      case LABORATORY: return "laboratory";
      case IMAGING: return "imaging";
      default: return null;
      }
    }

    public Coding toCoding() {
      switch (this) {
      case LABORATORY: return new Coding().setSystem("http://terminology.hl7.org/CodeSystem/observation-category").setCode("laboratory");
      case IMAGING: return new Coding().setSystem("http://terminology.hl7.org/CodeSystem/observation-category").setCode("imaging");
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

  @Min("0") @Max("*") @Doco("Extension")
  @Definition("An Extension")
  private List<Extension> extensions = new ArrayList<>();  // Extension

  @Min("0") @Max("1") @Doco("A simple extension")
  @Definition("A simple extension - an extension with just a value")
  private String simple;  // A simple extension

  @Min("0") @Max("1") @Doco("A complex extension")
  @Definition("A complex extension - an extension with 2 levels")
  private TestComplexExtension complex;  // A complex extension

  @Min("0") @Max("1") @Doco("Business Identifier for observation")
  @Definition("A unique identifier assigned to this observation.")
  private Identifier identifier;  // Business Identifier for observation

  @Min("1") @Max("1") @Doco("registered | preliminary | final | amended +")
  @BindingStrength("required") @ValueSet("http://hl7.org/fhir/ValueSet/observation-status|5.0.0")
  @Definition("The status of the result value.")
  private String status;// @NotNull  // registered | preliminary | final | amended +

  @Min("1") @Max("1") @Doco("Classification of  type of observation")
  @BindingStrength("required") @ValueSet("#vs1")
  @Definition("A code that classifies the general type of observation being made.")
  private ProfileObservationCategoryCode category;// @NotNull  // Classification of  type of observation

  @Min("1") @Max("1") @Doco("Sexual Orientation")
  @BindingStrength("example") @ValueSet("http://hl7.org/fhir/ValueSet/observation-codes")
  @Definition("Describes what was observed. Sometimes this is called the observation \"name\".")
  private CodeableConcept code;// @NotNull  // Sexual Orientation

  @Min("1") @Max("1") @Doco("Who and/or what the observation is about")
  @MustSupport(true)
  @Definition("The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation.")
  private Reference subject;// @NotNull  // Who and/or what the observation is about

  @Min("0") @Max("1") @Doco("Healthcare event during which this observation is made")
  @Definition("The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made.")
  private Reference encounter;  // Healthcare event during which this observation is made

  @Min("1") @Max("1") @Doco("Clinically relevant time/time-period for observation")
  @Definition("Time of observation")
  private Date effective;// @NotNull  // Clinically relevant time/time-period for observation

  @Min("0") @Max("*") @Doco("Who is responsible for the observation")
  @Definition("Who was responsible for asserting the observed value as \"true\".")
  private List<Reference> performers = new ArrayList<>();  // Who is responsible for the observation

  @Min("0") @Max("1") @Doco("Sexual Orientation")
  @BindingStrength("extensible") @ValueSet("http://hl7.org/fhir/us/core/ValueSet/us-core-sexual-orientation")
  @MustSupport(true)
  @Definition("The Sexual Orientation value.")
  private TestDatatypeProfile valueCodeableConcept;  // Sexual Orientation


  /**
   * Parameter-less constructor.
   *
   */
  public TestProfile() {
    initFixedValues();
  }

  /**
   * Construct an instance of the object, and fill out all the fixed values 
   *
   */
  public TestProfile(IWorkerContext context) {
    initFixedValues();
    workerContext = context;
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance src = builder.buildPEInstance(CANONICAL_URL, builder.createResource(CANONICAL_URL, false));
    load(src);
  }

  /**
   * Populate an instance of the object based on this source object 
   *
   */
  public static TestProfile fromSource(IWorkerContext context, Observation source) {
    TestProfile theThing = new TestProfile();
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
    if (src.hasChild("simple")) {
      simple = src.child("simple").asDataType().primitiveValue();
    }
    if (src.hasChild("complex")) {
      complex = TestComplexExtension.fromSource(src.child("complex"));
    }
    if (src.hasChild("identifier")) {
      identifier = (Identifier) src.child("identifier").asDataType();
    }
    if (src.hasChild("status")) {
      status = src.child("status").asDataType().primitiveValue();
    }
    if (src.hasChild("category")) {
      category = ProfileObservationCategoryCode.fromCodeableConcept((CodeableConcept) src.child("category").asDataType());
    }
    if (src.hasChild("code")) {
      code = (CodeableConcept) src.child("code").asDataType();
    }
    if (src.hasChild("subject")) {
      subject = (Reference) src.child("subject").asDataType();
    }
    if (src.hasChild("encounter")) {
      encounter = (Reference) src.child("encounter").asDataType();
    }
    if (src.hasChild("effective")) {
      effective = ((DateTimeType) src.child("effective").asDataType()).getValue();
    }
    for (PEInstance item : src.children("performer")) {
      performers.add((Reference) item.asDataType());
    }
    if (src.hasChild("valueCodeableConcept")) {
      valueCodeableConcept = TestDatatypeProfile.fromSource(src.child("valueCodeableConcept"));
    }

  }

  /**
   * Build an instance of the object based on this source object 
   *
   */
  public Observation build(IWorkerContext context) {
    workerContext = context;
    Observation theThing = new Observation();
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance tgt = builder.buildPEInstance(CANONICAL_URL, theThing);
    save(tgt, false);
    return theThing;
  }

  /**
   * Save this profile class into an existing resource (overwriting anything that 
   * exists in the profile) 
   *
   */
  public void save(IWorkerContext context, Observation dest, boolean nulls) {
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
    tgt.clear("simple");
    if (simple != null) {
      tgt.makeChild("simple").data().setProperty("value[x]", new CodeType(simple));
    }
    tgt.clear("complex");
    if (complex != null) {
      complex.save(tgt.makeChild("complex"), nulls);
    }
    tgt.clear("identifier");
    if (identifier != null) {
      tgt.addChild("identifier", identifier);
    }
    tgt.clear("status");
    if (status != null) {
      tgt.makeChild("status").data().setProperty("value", new CodeType(status));
    }
    tgt.clear("category");
    if (category != null) {
      tgt.addChild("category", category.toCodeableConcept());
    }
    tgt.clear("code");
    if (code != null) {
      tgt.addChild("code", code);
    }
    tgt.clear("subject");
    if (subject != null) {
      tgt.addChild("subject", subject);
    }
    tgt.clear("encounter");
    if (encounter != null) {
      tgt.addChild("encounter", encounter);
    }
    tgt.clear("effective");
    if (effective != null) {
      tgt.addChild("effective", new DateTimeType(effective));
    }
    tgt.clear("performer");
    for (Reference item : performers) {
      tgt.addChild("performer", item);
    }
    tgt.clear("valueCodeableConcept");
    if (valueCodeableConcept != null) {
      valueCodeableConcept.save(tgt.makeChild("valueCodeableConcept"), nulls);
    }

  }

  private void initFixedValues() {
    status = "final";

  }

  /**
   * Test Observation Profile.
   *
   */
  public String getId() {
    return id;
  }

  public TestProfile setId(String value) {
    this.id = value;
    return this;
  }

  public boolean hasId() {
    return id != null;
  }

  /**
   * Test Observation Profile.
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
   * Test Observation Profile.
   *
   */
  public String getSimple() {
    return simple;
  }

  public TestProfile setSimple(String value) {
    this.simple = value;
    return this;
  }

  public boolean hasSimple() {
    return simple != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public TestComplexExtension getComplex() {
    if (complex == null) { complex = new TestComplexExtension(); }
    return complex;
  }

  public TestProfile setComplex(TestComplexExtension value) {
    this.complex = value;
    return this;
  }
  public boolean hasComplex() {
    return complex != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public Identifier getIdentifier() {
    if (identifier == null) { identifier = new Identifier(); }
    return identifier;
  }

  public TestProfile setIdentifier(Identifier value) {
    this.identifier = value;
    return this;
  }
  public boolean hasIdentifier() {
    return identifier != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public String getStatus() {
    return status;
  }

  public boolean hasStatus() {
    return true;
  }

  /**
   * Test Observation Profile.
   *
   */
  public ProfileObservationCategoryCode getCategory() {
    return category;
  }

  public TestProfile setCategory(ProfileObservationCategoryCode value) {
    this.category = value;
    return this;
  }

  public boolean hasCategory() {
    return category != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public CodeableConcept getCode() {
    if (code == null) { code = new CodeableConcept(); }
    return code;
  }

  public boolean hasCode() {
    return code != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public Reference getSubject() {
    if (subject == null) { subject = new Reference(); }
    return subject;
  }

  public TestProfile setSubject(Reference value) {
    this.subject = value;
    return this;
  }
  public boolean hasSubject() {
    return subject != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public Reference getEncounter() {
    if (encounter == null) { encounter = new Reference(); }
    return encounter;
  }

  public TestProfile setEncounter(Reference value) {
    this.encounter = value;
    return this;
  }
  public boolean hasEncounter() {
    return encounter != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public Date getEffective() {
    return effective;
  }

  public TestProfile setEffective(Date value) {
    this.effective = value;
    return this;
  }

  public boolean hasEffective() {
    return effective != null;
  }

  /**
   * Test Observation Profile.
   *
   */
  public List<Reference> getPerformers() {
    if (performers == null) { performers = new ArrayList<>(); }
    return performers;
  }

  public boolean hasPerformers() {
    return performers != null && !performers.isEmpty();
  }

  public Reference addPerformer() {
    Reference theThing = new Reference();
    getPerformers().add(theThing);
    return theThing;
  }

  public boolean hasPerformer(Reference item) {
    return hasPerformers() && performers.contains(item);
  }

  public void removePerformer(Reference item) {
    if (hasPerformer(item)) {
      performers.remove(item);
    }
  }


  /**
   * Test Observation Profile.
   *
   */
  public TestDatatypeProfile getValueCodeableConcept() {
    if (valueCodeableConcept == null) { valueCodeableConcept = new TestDatatypeProfile(); }
    return valueCodeableConcept;
  }

  public TestProfile setValueCodeableConcept(TestDatatypeProfile value) {
    this.valueCodeableConcept = value;
    return this;
  }
  public boolean hasValueCodeableConcept() {
    return valueCodeableConcept != null;
  }



  public void clear() {
    id = null;
    extensions.clear();
    simple = null;
    complex = null;
    identifier = null;
    status = null;
    category = null;
    code = null;
    subject = null;
    encounter = null;
    effective = null;
    performers.clear();
    valueCodeableConcept = null;

  }

}