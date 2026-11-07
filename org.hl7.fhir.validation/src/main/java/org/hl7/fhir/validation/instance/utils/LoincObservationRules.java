package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.fhir.ucum.UcumService;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;

/**
 * What a LOINC code says about the Observation that uses it - the kind of value (SCALE_TYP), the
 * units (PROPERTY, EXAMPLE_UCUM_UNITS, UNITSREQUIRED), whether it's a panel (PanelType) or only
 * for ordering (ORDER_OBS), and its timing (TIME_ASPCT). Used by the checks on Observation
 * instances (ObservationValidator) and on profiles of Observation that fix a LOINC code
 * (StructureDefinitionValidator); this class knows the rules, and they report the problems.
 *
 * The properties come from the terminology server, in one $lookup per code (cached)
 */
public class LoincObservationRules {

  public static final String LOINC = "http://loinc.org";
  public static final String UCUM = "http://unitsofmeasure.org";

  /** the LOINC properties the checks use - asked for together, in one $lookup per code */
  private static final Set<String> LOOKUP = Set.of("PROPERTY", "EXAMPLE_UCUM_UNITS", "SCALE_TYP", "ORDER_OBS", "PanelType", "UNITSREQUIRED", "TIME_ASPCT");

  /**
   * What a LOINC PROPERTY axis value (the Part's display - e.g. MCnc) measures: a unit it is
   * measured in (any unit for it can be converted to this one), and, for an amount of substance
   * or a number of things, which of the two it is - UCUM treats a mole as a number (6.02e23),
   * so it can't tell mmol/L from 10*9/L, and these are told apart by the unit's name
   */
  private static class LoincProperty {
    private final String unit;
    private final String name;
    private final Boolean substance; // true: a unit of moles (mol, eq, osm); false: not one; null: either
    private LoincProperty(String unit, String name, Boolean substance) {
      this.unit = unit;
      this.name = name;
      this.substance = substance;
    }
  }

  private static final Map<String, LoincProperty> LOINC_PROPERTIES = new HashMap<>();
  static {
    LOINC_PROPERTIES.put("MCnc", new LoincProperty("g/L", "mass concentration", false));
    LOINC_PROPERTIES.put("SCnc", new LoincProperty("mol/L", "substance concentration", true));
    LOINC_PROPERTIES.put("NCnc", new LoincProperty("/L", "number concentration", false));
    LOINC_PROPERTIES.put("CCnc", new LoincProperty("kat/L", "catalytic concentration", null));
    LOINC_PROPERTIES.put("MCnt", new LoincProperty("g/kg", "mass content", false));
    LOINC_PROPERTIES.put("SCnt", new LoincProperty("mol/kg", "substance content", true));
    LOINC_PROPERTIES.put("CCnt", new LoincProperty("kat/kg", "catalytic content", null));
    LOINC_PROPERTIES.put("Mass", new LoincProperty("g", "mass", false));
    LOINC_PROPERTIES.put("Sub", new LoincProperty("mol", "amount of substance", true));
    LOINC_PROPERTIES.put("Vol", new LoincProperty("L", "volume", null));
    LOINC_PROPERTIES.put("Len", new LoincProperty("m", "length", null));
    LOINC_PROPERTIES.put("Area", new LoincProperty("m2", "area", null));
    LOINC_PROPERTIES.put("Time", new LoincProperty("s", "time", null));
    LOINC_PROPERTIES.put("Pres", new LoincProperty("Pa", "pressure", null));
    LOINC_PROPERTIES.put("MRat", new LoincProperty("g/s", "mass rate", false));
    LOINC_PROPERTIES.put("SRat", new LoincProperty("mol/s", "substance rate", true));
    LOINC_PROPERTIES.put("VRat", new LoincProperty("L/s", "volume rate", null));
    LOINC_PROPERTIES.put("CRat", new LoincProperty("kat", "catalytic rate", null));
    LOINC_PROPERTIES.put("Vel", new LoincProperty("m/s", "velocity", null));
    LOINC_PROPERTIES.put("Freq", new LoincProperty("/s", "frequency", null));
    LOINC_PROPERTIES.put("Visc", new LoincProperty("Pa.s", "viscosity", null));
    // fractions and ratios have no dimension - %, mg/g, mmol/mol - whatever they are of
    for (String p : new String[] { "MFr", "SFr", "NFr", "VFr", "CFr", "MRto", "SRto", "NRto", "VRto" }) {
      LOINC_PROPERTIES.put(p, new LoincProperty("1", "a ratio or fraction", null));
    }
  }

  /** the scales whose values are checked, and the types of value that don't fit them */
  public enum Scale {
    QUANTITATIVE, CODED, NARRATIVE, DOCUMENT;
  }

  /** a LOINC code, and what the terminology server says about it */
  public class Code {
    private final String version;
    private final String desc;
    private final Map<String, List<String>> props;

    private Code(String code, String version, String display, Map<String, List<String>> props) {
      this.version = version;
      this.desc = display == null ? code : code + " ('" + display + "')";
      this.props = props;
    }

    /** the code and its display, for messages */
    public String getDesc() {
      return desc;
    }

    /** the property's (first) value */
    private String first(String name) {
      List<String> l = props.get(name);
      return l == null || l.isEmpty() ? null : l.get(0);
    }

    /** the name of the Part that is the property's value (e.g. Qn for SCALE_TYP LP7753-9) */
    private String part(String name) {
      String v = first(name);
      return v == null ? null : partName(v, version);
    }

    /** the PanelType (Panel, Convenience group, Organizer), or null if the code isn't a panel */
    public String getPanelType() {
      return first("PanelType");
    }

    /** an order-only code (ORDER_OBS = Order) that isn't a panel - panels usually are order-only too */
    public boolean isOrderOnly() {
      return "Order".equals(first("ORDER_OBS")) && getPanelType() == null;
    }

    public boolean isUnitsRequired() {
      return "Y".equals(first("UNITSREQUIRED"));
    }

    /** the name of the scale (Qn, Ord, Nom...) */
    public String getScaleName() {
      return part("SCALE_TYP");
    }

    /** the scale, if it's one whose values are checked */
    public Scale getScale() {
      String s = getScaleName();
      if (s == null) {
        return null;
      }
      switch (s) {
      case "Qn": return Scale.QUANTITATIVE;
      case "Ord":
      case "Nom": return Scale.CODED;
      case "Nar": return Scale.NARRATIVE;
      case "Doc": return Scale.DOCUMENT;
      default: return null; // OrdQn, SemiQn, Multi, Set... take more than one type of value
      }
    }

    /** the TIME_ASPCT (Pt, 24H...) */
    public String getTimeAspect() {
      return part("TIME_ASPCT");
    }

    /** a point in time (Pt) */
    public boolean isPointInTime() {
      return "Pt".equals(getTimeAspect());
    }

    /**
     * a collection over a stated number of hours - 24H, 12H... Survey questions have periods too
     * (12Mo: in the last 12 months), but those are look-back periods, and the answer is still
     * given at a point in time
     */
    public boolean isTimed() {
      String t = getTimeAspect();
      return t != null && t.matches("\\d+H");
    }
  }

  /** what's wrong with a unit: it's not a unit of what the code measures */
  public static class UnitProblem {
    private final String propertyName; // e.g. mass concentration, if the PROPERTY is known
    private final String property; // e.g. MCnc
    private final String expected; // a unit it should be like

    private UnitProblem(String propertyName, String property, String expected) {
      this.propertyName = propertyName;
      this.property = property;
      this.expected = expected;
    }

    /** true: what the code measures is known (getPropertyName(), getProperty()); false: only the example unit */
    public boolean hasProperty() {
      return propertyName != null;
    }

    public String getPropertyName() {
      return propertyName;
    }

    public String getProperty() {
      return property;
    }

    public String getExpected() {
      return expected;
    }
  }

  private final IWorkerContext context;
  private final ValidationOptions options;

  public LoincObservationRules(IWorkerContext context, ValidationOptions options) {
    this.context = context;
    this.options = options;
  }

  /** what the terminology server says about the code; null if it doesn't know it (or there's no server) */
  public Code lookup(String code, String version, String display) {
    Map<String, List<String>> props = context.lookupProperties(options, LOINC, version, code, LOOKUP);
    return props == null ? null : new Code(code, version, display, props);
  }

  /** whether a value of this type fits the scale */
  public static boolean scaleAllows(Scale scale, String type) {
    switch (scale) {
    case QUANTITATIVE:
      // dateTime, Period and integer are fine: LOINC has quantitative dates and counts
      return !Utilities.existsInList(type, "CodeableConcept", "string", "boolean");
    case CODED:
      return !Utilities.existsInList(type, "Quantity", "Range", "Ratio", "SampledData");
    case NARRATIVE:
      return !Utilities.existsInList(type, "Quantity", "Range", "Ratio", "SampledData", "boolean", "integer");
    case DOCUMENT:
      // a document goes in a DocumentReference - but a waveform (an EKG study, say) is SampledData
      return Utilities.existsInList(type, "SampledData", "Attachment");
    default:
      return true;
    }
  }

  /**
   * Whether the unit (a UCUM code) is a unit of the kind of quantity the code is for - checked
   * against LOINC's example unit when it has one, and against what the PROPERTY axis measures.
   * Returns null when it is, or when it can't be told (arbitrary units, no UCUM service...)
   */
  public UnitProblem checkUnit(Code code, String unit) {
    UcumService ucum = context.getUcumService();
    if (ucum == null || isArbitrary(unit)) {
      return null;
    }
    List<String> examples = new ArrayList<>();
    for (String s : code.props.getOrDefault("EXAMPLE_UCUM_UNITS", new ArrayList<>())) {
      for (String u : s.split(";")) {
        if (!Utilities.noString(u.trim()) && !isArbitrary(u.trim())) {
          examples.add(u.trim());
        }
      }
    }
    String pname = code.part("PROPERTY");
    LoincProperty property = pname == null ? null : LOINC_PROPERTIES.get(pname);

    // the example unit: if the unit can't be converted to it, it's for something else
    if (!examples.isEmpty()) {
      Boolean ok = null;
      for (String ex : examples) {
        Boolean c = comparable(ucum, ex, unit);
        if (c != null) {
          ok = (ok != null && ok) || c;
        }
      }
      if (ok != null && !ok) {
        return property != null ? new UnitProblem(property.name, pname, examples.get(0)) : new UnitProblem(null, null, examples.get(0));
      }
    }
    // the property: what it measures, and for an amount of things, whether it's moles or a count
    if (property != null) {
      Boolean c = examples.isEmpty() ? comparable(ucum, property.unit, unit) : Boolean.TRUE;
      boolean ok = (c == null || c) && (property.substance == null || property.substance == isMoles(unit));
      if (!ok) {
        return new UnitProblem(property.name, pname, examples.isEmpty() ? property.unit : examples.get(0));
      }
    }
    return null;
  }

  /** whether two UCUM units measure the same thing; null if UCUM can't say (an invalid unit, say) */
  private Boolean comparable(UcumService ucum, String a, String b) {
    try {
      return ucum.isComparable(a, b);
    } catch (Exception e) {
      return null;
    }
  }

  /** a unit of moles - mol, mmol/L, meq/L, mosm/kg - as opposed to a count (10*9/L) */
  private static boolean isMoles(String unit) {
    String u = unit.replaceAll("\\{[^}]*\\}", "").replaceAll("\\[[^\\]]*\\]", "");
    return u.contains("mol") || u.contains("eq") || u.contains("osm");
  }

  /** arbitrary units ([IU], [arb'U]...) measure nothing UCUM can compare */
  public static boolean isArbitrary(String unit) {
    return unit.contains("U]");
  }

  /**
   * The name of a LOINC Part (e.g. LP6827-2 is MCnc): servers give the axes as the Part code, or
   * as its name
   */
  private String partName(String value, String version) {
    if (!value.startsWith("LP")) {
      return value;
    }
    ValidationResult vr = context.validateCode(options, LOINC, version, value, null);
    return vr != null && vr.isOk() ? vr.getDisplay() : null;
  }
}
