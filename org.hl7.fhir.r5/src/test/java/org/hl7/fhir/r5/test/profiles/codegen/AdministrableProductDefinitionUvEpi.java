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


// Generated by the HAPI Java Profile Generator, 2/11/24, 10:50 pm

/**
 * A medicinal product in the final form which is suitable for administering to a 
 * patient (after any mixing of multiple components, dissolution etc. has been 
 * performed).
 *
 */
public class AdministrableProductDefinitionUvEpi extends PEGeneratedBase {

  public static final String CANONICAL_URL = "http://hl7.org/fhir/uv/emedicinal-product-info/StructureDefinition/AdministrableProductDefinition-uv-epi|1.0.0";

  public enum PublicationStatus {
    DRAFT, // "Draft" = http://hl7.org/fhir/publication-status#draft
    ACTIVE, // "Active" = http://hl7.org/fhir/publication-status#active
    RETIRED, // "Retired" = http://hl7.org/fhir/publication-status#retired
    UNKNOWN; // "Unknown" = http://hl7.org/fhir/publication-status#unknown

    public static PublicationStatus fromCode(String s) {
      switch (s) {
      case "draft": return DRAFT;
      case "active": return ACTIVE;
      case "retired": return RETIRED;
      case "unknown": return UNKNOWN;
      default: return null;
      }
    }

    public static PublicationStatus fromCoding(Coding c) {
      if ("http://hl7.org/fhir/publication-status".equals(c.getSystem()) && "draft".equals(c.getCode())) {
        return DRAFT;
      }
      if ("http://hl7.org/fhir/publication-status".equals(c.getSystem()) && "active".equals(c.getCode())) {
        return ACTIVE;
      }
      if ("http://hl7.org/fhir/publication-status".equals(c.getSystem()) && "retired".equals(c.getCode())) {
        return RETIRED;
      }
      if ("http://hl7.org/fhir/publication-status".equals(c.getSystem()) && "unknown".equals(c.getCode())) {
        return UNKNOWN;
      }
      return null;
    }

    public static PublicationStatus fromCodeableConcept(CodeableConcept cc) {
      for (Coding c : cc.getCoding()) {
        PublicationStatus v = fromCoding(c);
        if (v != null) {
          return v;
        }
      }
      return null;
    }

    public String toDisplay() {
      switch (this) {
      case DRAFT: return "Draft";
      case ACTIVE: return "Active";
      case RETIRED: return "Retired";
      case UNKNOWN: return "Unknown";
      default: return null;
      }
    }

    public String toCode() {
      switch (this) {
      case DRAFT: return "draft";
      case ACTIVE: return "active";
      case RETIRED: return "retired";
      case UNKNOWN: return "unknown";
      default: return null;
      }
    }

    public Coding toCoding() {
      switch (this) {
      case DRAFT: return new Coding().setSystem("http://hl7.org/fhir/publication-status").setCode("draft");
      case ACTIVE: return new Coding().setSystem("http://hl7.org/fhir/publication-status").setCode("active");
      case RETIRED: return new Coding().setSystem("http://hl7.org/fhir/publication-status").setCode("retired");
      case UNKNOWN: return new Coding().setSystem("http://hl7.org/fhir/publication-status").setCode("unknown");
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

  @Min("1") @Max("*") @Doco("An identifier for the administrable product")
  @Definition("An identifier for the administrable product.")
  private List<Identifier> identifiers = new ArrayList<>();// @NotNull  // An identifier for the administrable product

  @Min("1") @Max("1") @Doco("draft | active | retired |unknown")
  @BindingStrength("required") @ValueSet("http://hl7.org/fhir/ValueSet/publication-status|5.0.0")
  @Definition("The status of this administrable product. Enables tracking the life-cycle of the content.")
  private PublicationStatus status;// @NotNull  // draft | active | retired |unknown

  @Min("0") @Max("*") @Doco("References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product")
  @Definition("References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product.  If this administrable product describes the administration of a crushed tablet, the 'formOf' would be the product representing a distribution containing tablets and possibly also a cream.  This is distinct from the 'producedFrom' which refers to the specific components of the product that are used in this preparation, rather than the product as a whole.")
  private List<Reference> formOfs = new ArrayList<>();  // References a product from which one or more of the constituent parts of that product can be prepared and used as described by this administrable product

  @Min("0") @Max("*") @Doco("Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form")
  @Definition("Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form.  In some cases, an administrable form might use all of the items from the overall product (or there might only be one item), while in other cases, an administrable form might use only a subset of the items available in the overall product.  For example, an administrable form might involve combining a liquid and a powder available as part of an overall product, but not involve applying the also supplied cream.")
  private List<Reference> producedFroms = new ArrayList<>();  // Indicates the specific manufactured items that are part of the 'formOf' product that are used in the preparation of this specific administrable form

  @Min("0") @Max("1") @Doco("A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product")
  @Definition("A device that is integral to the medicinal product, in effect being considered as an \"ingredient\" of the medicinal product. This is not intended for devices that are just co-packaged.")
  private Reference device;  // A device that is integral to the medicinal product, in effect being considered as an "ingredient" of the medicinal product

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> properties = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> colors = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> flavors = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> scores = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> shapes = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> surfaceforms = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> sizes = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> images = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("0") @Max("*") @Doco("Characteristics e.g. a product's onset of action")
  @Definition("Characteristics e.g. a product's onset of action.")
  private List<BackboneElement> imprints = new ArrayList<>();  // Characteristics e.g. a product's onset of action

  @Min("1") @Max("*") @Doco("The path by which the product is taken into or makes contact with the body")
  @Definition("The path by which the product is taken into or makes contact with the body. In some regions this is referred to as the licenced or approved route. RouteOfAdministration cannot be used when the 'formOf' product already uses MedicinalProductDefinition.route (and vice versa).")
  private List<BackboneElement> routeOfAdministrations = new ArrayList<>();// @NotNull  // The path by which the product is taken into or makes contact with the body


  /**
   * Parameter-less constructor.
   *
   */
  public AdministrableProductDefinitionUvEpi() {
  }

  /**
   * Construct an instance of the object, and fill out all the fixed values 
   *
   */
  public AdministrableProductDefinitionUvEpi(IWorkerContext context) {
    workerContext = context;
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);
    PEInstance src = builder.buildPEInstance(CANONICAL_URL, builder.createResource(CANONICAL_URL, false));
    load(src);
  }

  /**
   * Populate an instance of the object based on this source object 
   *
   */
  public static AdministrableProductDefinitionUvEpi fromSource(IWorkerContext context, AdministrableProductDefinition source) {
    AdministrableProductDefinitionUvEpi theThing = new AdministrableProductDefinitionUvEpi();
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
      status = PublicationStatus.fromCode(src.child("status").asDataType().primitiveValue());
    }
    for (PEInstance item : src.children("formOf")) {
      formOfs.add((Reference) item.asDataType());
    }
    for (PEInstance item : src.children("producedFrom")) {
      producedFroms.add((Reference) item.asDataType());
    }
    if (src.hasChild("device")) {
      device = (Reference) src.child("device").asDataType();
    }
    for (PEInstance item : src.children("property")) {
      properties.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("color")) {
      colors.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("flavor")) {
      flavors.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("score")) {
      scores.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("shape")) {
      shapes.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("surfaceform")) {
      surfaceforms.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("size")) {
      sizes.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("image")) {
      images.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("imprint")) {
      imprints.add((BackboneElement) item.asElement());
    }
    for (PEInstance item : src.children("routeOfAdministration")) {
      routeOfAdministrations.add((BackboneElement) item.asElement());
    }

  }

  /**
   * Build a instance of the underlying object based on this wrapping object 
   *
   */
  public AdministrableProductDefinition build(IWorkerContext context) {
    workerContext = context;
    return build();
  }

  /**
   * Build a instance of the underlying object based on this wrapping object 
   *
   */
  public AdministrableProductDefinition build() {
    AdministrableProductDefinition theThing = new AdministrableProductDefinition();
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
  public void save(IWorkerContext context, AdministrableProductDefinition dest, boolean nulls) {
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
    tgt.clear("formOf");
    for (Reference item : formOfs) {
      tgt.addChild("formOf", item);
    }
    tgt.clear("producedFrom");
    for (Reference item : producedFroms) {
      tgt.addChild("producedFrom", item);
    }
    tgt.clear("device");
    if (device != null) {
      tgt.addChild("device", device);
    }
    tgt.clear("property");
    for (BackboneElement item : properties) {
      tgt.addChild("property", item);
    }
    tgt.clear("color");
    for (BackboneElement item : colors) {
      tgt.addChild("color", item);
    }
    tgt.clear("flavor");
    for (BackboneElement item : flavors) {
      tgt.addChild("flavor", item);
    }
    tgt.clear("score");
    for (BackboneElement item : scores) {
      tgt.addChild("score", item);
    }
    tgt.clear("shape");
    for (BackboneElement item : shapes) {
      tgt.addChild("shape", item);
    }
    tgt.clear("surfaceform");
    for (BackboneElement item : surfaceforms) {
      tgt.addChild("surfaceform", item);
    }
    tgt.clear("size");
    for (BackboneElement item : sizes) {
      tgt.addChild("size", item);
    }
    tgt.clear("image");
    for (BackboneElement item : images) {
      tgt.addChild("image", item);
    }
    tgt.clear("imprint");
    for (BackboneElement item : imprints) {
      tgt.addChild("imprint", item);
    }
    tgt.clear("routeOfAdministration");
    for (BackboneElement item : routeOfAdministrations) {
      tgt.addChild("routeOfAdministration", item);
    }

  }

  public String getId() {
    return id;
  }

  public AdministrableProductDefinitionUvEpi setId(String value) {
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
   * An identifier for the administrable product.
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
   * The status of this administrable product. Enables tracking the life-cycle of the 
   * content.
   *
   */
  public PublicationStatus getStatus() {
    return status;
  }

  public AdministrableProductDefinitionUvEpi setStatus(PublicationStatus value) {
    this.status = value;
    return this;
  }

  public boolean hasStatus() {
    return status != null;
  }

  /**
   * References a product from which one or more of the constituent parts of that 
   * product can be prepared and used as described by this administrable product.  If 
   * this administrable product describes the administration of a crushed tablet, the 
   * 'formOf' would be the product representing a distribution containing tablets and 
   * possibly also a cream.  This is distinct from the 'producedFrom' which refers to 
   * the specific components of the product that are used in this preparation, rather 
   * than the product as a whole.
   *
   */
  public List<Reference> getFormOfs() {
    if (formOfs == null) { formOfs = new ArrayList<>(); }
    return formOfs;
  }

  public boolean hasFormOfs() {
    return formOfs != null && !formOfs.isEmpty();
  }

  public Reference addFormOf() {
    Reference theThing = new Reference();
    getFormOfs().add(theThing);
    return theThing;
  }

  public boolean hasFormOf(Reference item) {
    return hasFormOfs() && formOfs.contains(item);
  }

  public void removeFormOf(Reference item) {
    if (hasFormOf(item)) {
      formOfs.remove(item);
    }
  }


  /**
   * Indicates the specific manufactured items that are part of the 'formOf' product 
   * that are used in the preparation of this specific administrable form.  In some 
   * cases, an administrable form might use all of the items from the overall product 
   * (or there might only be one item), while in other cases, an administrable form 
   * might use only a subset of the items available in the overall product.  For 
   * example, an administrable form might involve combining a liquid and a powder 
   * available as part of an overall product, but not involve applying the also 
   * supplied cream.
   *
   */
  public List<Reference> getProducedFroms() {
    if (producedFroms == null) { producedFroms = new ArrayList<>(); }
    return producedFroms;
  }

  public boolean hasProducedFroms() {
    return producedFroms != null && !producedFroms.isEmpty();
  }

  public Reference addProducedFrom() {
    Reference theThing = new Reference();
    getProducedFroms().add(theThing);
    return theThing;
  }

  public boolean hasProducedFrom(Reference item) {
    return hasProducedFroms() && producedFroms.contains(item);
  }

  public void removeProducedFrom(Reference item) {
    if (hasProducedFrom(item)) {
      producedFroms.remove(item);
    }
  }


  /**
   * A device that is integral to the medicinal product, in effect being considered 
   * as an "ingredient" of the medicinal product. This is not intended for devices 
   * that are just co-packaged.
   *
   */
  public Reference getDevice() {
    if (device == null) { device = new Reference(); }
    return device;
  }

  public AdministrableProductDefinitionUvEpi setDevice(Reference value) {
    this.device = value;
    return this;
  }
  public boolean hasDevice() {
    return device != null;
  }

  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getProperties() {
    if (properties == null) { properties = new ArrayList<>(); }
    return properties;
  }

  public boolean hasProperties() {
    return properties != null && !properties.isEmpty();
  }

  public boolean hasProperty(BackboneElement item) {
    return hasProperties() && properties.contains(item);
  }

  public void removeProperty(BackboneElement item) {
    if (hasProperty(item)) {
      properties.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getColors() {
    if (colors == null) { colors = new ArrayList<>(); }
    return colors;
  }

  public boolean hasColors() {
    return colors != null && !colors.isEmpty();
  }

  public boolean hasColor(BackboneElement item) {
    return hasColors() && colors.contains(item);
  }

  public void removeColor(BackboneElement item) {
    if (hasColor(item)) {
      colors.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getFlavors() {
    if (flavors == null) { flavors = new ArrayList<>(); }
    return flavors;
  }

  public boolean hasFlavors() {
    return flavors != null && !flavors.isEmpty();
  }

  public boolean hasFlavor(BackboneElement item) {
    return hasFlavors() && flavors.contains(item);
  }

  public void removeFlavor(BackboneElement item) {
    if (hasFlavor(item)) {
      flavors.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getScores() {
    if (scores == null) { scores = new ArrayList<>(); }
    return scores;
  }

  public boolean hasScores() {
    return scores != null && !scores.isEmpty();
  }

  public boolean hasScore(BackboneElement item) {
    return hasScores() && scores.contains(item);
  }

  public void removeScore(BackboneElement item) {
    if (hasScore(item)) {
      scores.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getShapes() {
    if (shapes == null) { shapes = new ArrayList<>(); }
    return shapes;
  }

  public boolean hasShapes() {
    return shapes != null && !shapes.isEmpty();
  }

  public boolean hasShape(BackboneElement item) {
    return hasShapes() && shapes.contains(item);
  }

  public void removeShape(BackboneElement item) {
    if (hasShape(item)) {
      shapes.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getSurfaceforms() {
    if (surfaceforms == null) { surfaceforms = new ArrayList<>(); }
    return surfaceforms;
  }

  public boolean hasSurfaceforms() {
    return surfaceforms != null && !surfaceforms.isEmpty();
  }

  public boolean hasSurfaceform(BackboneElement item) {
    return hasSurfaceforms() && surfaceforms.contains(item);
  }

  public void removeSurfaceform(BackboneElement item) {
    if (hasSurfaceform(item)) {
      surfaceforms.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getSizes() {
    if (sizes == null) { sizes = new ArrayList<>(); }
    return sizes;
  }

  public boolean hasSizes() {
    return sizes != null && !sizes.isEmpty();
  }

  public boolean hasSize(BackboneElement item) {
    return hasSizes() && sizes.contains(item);
  }

  public void removeSize(BackboneElement item) {
    if (hasSize(item)) {
      sizes.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getImages() {
    if (images == null) { images = new ArrayList<>(); }
    return images;
  }

  public boolean hasImages() {
    return images != null && !images.isEmpty();
  }

  public boolean hasImage(BackboneElement item) {
    return hasImages() && images.contains(item);
  }

  public void removeImage(BackboneElement item) {
    if (hasImage(item)) {
      images.remove(item);
    }
  }


  /**
   * Characteristics e.g. a product's onset of action.
   *
   */
  public List<BackboneElement> getImprints() {
    if (imprints == null) { imprints = new ArrayList<>(); }
    return imprints;
  }

  public boolean hasImprints() {
    return imprints != null && !imprints.isEmpty();
  }

  public boolean hasImprint(BackboneElement item) {
    return hasImprints() && imprints.contains(item);
  }

  public void removeImprint(BackboneElement item) {
    if (hasImprint(item)) {
      imprints.remove(item);
    }
  }


  /**
   * The path by which the product is taken into or makes contact with the body. In 
   * some regions this is referred to as the licenced or approved route. 
   * RouteOfAdministration cannot be used when the 'formOf' product already uses 
   * MedicinalProductDefinition.route (and vice versa).
   *
   */
  public List<BackboneElement> getRouteOfAdministrations() {
    if (routeOfAdministrations == null) { routeOfAdministrations = new ArrayList<>(); }
    return routeOfAdministrations;
  }

  public boolean hasRouteOfAdministrations() {
    return routeOfAdministrations != null && !routeOfAdministrations.isEmpty();
  }

  public boolean hasRouteOfAdministration(BackboneElement item) {
    return hasRouteOfAdministrations() && routeOfAdministrations.contains(item);
  }

  public void removeRouteOfAdministration(BackboneElement item) {
    if (hasRouteOfAdministration(item)) {
      routeOfAdministrations.remove(item);
    }
  }




  public void clear() {
    id = null;
    extensions.clear();
    modifierExtensions.clear();
    identifiers.clear();
    status = null;
    formOfs.clear();
    producedFroms.clear();
    device = null;
    properties.clear();
    colors.clear();
    flavors.clear();
    scores.clear();
    shapes.clear();
    surfaceforms.clear();
    sizes.clear();
    images.clear();
    imprints.clear();
    routeOfAdministrations.clear();

  }

}