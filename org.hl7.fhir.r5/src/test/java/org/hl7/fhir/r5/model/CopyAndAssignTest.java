package org.hl7.fhir.r5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Stream;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

import org.hl7.fhir.r5.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAllEnumFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * copy() and assign() must both produce something indistinguishable from the source, and must
 * agree with each other.
 * <p>
 * The reason this needs its own test: copyValues() takes a different argument type at every level
 * of the hierarchy (Base -&gt; DataType -&gt; HumanName), so a call made through a Base reference
 * binds statically to Base.copyValues and never reaches the leaf. assign() has one signature all
 * the way down and dispatches virtually, which only works if every level's state is actually in
 * its copyValues(). The primitive types used to keep their value out of copyValues() entirely -
 * each subclass carried it across in the constructor argument of its own copy() - so anything
 * routed through copyValues() produced a valueless copy. Several classes held other state the
 * same way: CodeType.system, Enumeration's factory, IdType's parsed component parts, the date
 * precision and timezone, and Base64BinaryType's shadow value field.
 * <p>
 * "before and after" here is describe(): a full recursive dump of the tree, plus the state that
 * is real but is neither a child element nor part of equalsDeep(), which is exactly where the
 * bugs were hiding.
 */
public class CopyAndAssignTest {

  // ---------------------------------------------------------------- the subjects

  /**
   * one populated instance of every primitive type. XhtmlType is not here because its copy()
   * returns null, which is a separate question
   */
  public static Stream<Arguments> primitives() {
    List<Arguments> res = new ArrayList<>();
    res.add(decorate(new Base64BinaryType("aGVsbG8=")));
    res.add(decorate(new BooleanType("true")));
    res.add(decorate(new CanonicalType("http://example.org/fhir/StructureDefinition/x|1.2.3")));
    res.add(decorate(new CodeType("final").setSystem("http://hl7.org/fhir/observation-status")));
    res.add(decorate(new DateTimeType("2024-03-05T10:11:12.345+10:00")));
    res.add(decorate(new DateTimeType("2024-03")));  // a partial date: precision is state, not value
    res.add(decorate(new DateType("2024-03-05")));
    res.add(decorate(new DecimalType("1.2300")));    // trailing zeroes are significant in FHIR
    res.add(decorate(new IdType("http://example.org/fhir/Patient/123/_history/4")));
    res.add(decorate(new InstantType("2024-03-05T10:11:12.345Z")));
    res.add(decorate(new Integer64Type("9007199254740993")));
    res.add(decorate(new IntegerType("42")));
    res.add(decorate(new MarkdownType("# heading\n\nsome *text*")));
    res.add(decorate(new OidType("urn:oid:1.2.3.4")));
    res.add(decorate(new PositiveIntType("7")));
    res.add(decorate(sid("http://example.org/sid")));
    res.add(decorate(new StringType("hello")));
    res.add(decorate(new TimeType("10:11:12")));
    res.add(decorate(new UnsignedIntType("0")));
    res.add(decorate(new UriType("http://example.org/thing")));
    res.add(decorate(new UrlType("http://example.org/endpoint")));
    res.add(decorate(new UuidType("urn:uuid:c757873d-ec9a-4326-a141-556f43239520")));
    res.add(decorate(new Enumeration<AdministrativeGender>(new AdministrativeGenderEnumFactory(), AdministrativeGender.MALE)));
    return res.stream();
  }

  /** one populated instance of each shape of composite: datatype, backbone element, resource */
  public static Stream<Arguments> composites() {
    List<Arguments> res = new ArrayList<>();
    res.add(Arguments.of("HumanName", humanName()));
    res.add(Arguments.of("Quantity", quantity()));
    res.add(Arguments.of("Patient", patient()));
    res.add(Arguments.of("Patient.ContactComponent", patient().getContact().get(0)));
    return res.stream();
  }

  private static SidType sid(String value) {
    SidType res = new SidType();
    res.setValue(value);
    return res;
  }

  /**
   * the date types are the only primitives that carry state alongside the value - the precision,
   * the timezone, whether that timezone was written as Z, and fractional seconds finer than the
   * Date can hold. equalsDeep() compares the Date alone, so it is blind to every one of these:
   * "2024" and "2024-01-01" are the same instant. These are the corners
   */
  public static Stream<Arguments> dates() {
    List<Arguments> res = new ArrayList<>();
    // date: YEAR, MONTH and DAY precision only
    for (String s : new String[] {"2024", "2024-03", "2024-03-05", "2024-02-29", "1900-01-01", "2100-12-31"}) {
      res.add(decorate(new DateType(s)));
    }
    // dateTime: YEAR, MONTH, DAY, SECOND and MILLI (HOUR and MINUTE are not legal here)
    for (String s : new String[] {
        "2024",
        "2024-03",
        "2024-03-05",
        "2024-02-29",                        // leap day
        "2024-03-05T10:11:12Z",              // zulu
        "2024-03-05T10:11:12+00:00",         // the same instant as zulu, but not written as zulu
        "2024-03-05T10:11:12-00:00",         // and again, the other way round
        "2024-03-05T10:11:12+10:00",
        "2024-03-05T10:11:12-05:00",
        "2024-03-05T10:11:12+14:00",         // the ends of the offset range
        "2024-03-05T10:11:12-12:00",
        "2024-03-05T10:11:12",               // no timezone at all
        "2024-03-05T00:00:00Z",              // midnight
        "2024-12-31T23:59:59.999-11:00",     // year end, on the far side of the date line
        "2024-03-05T10:11:12.0+10:00",       // one fractional digit, and it is a zero
        "2024-03-05T10:11:12.345Z",
        "2024-03-05T10:11:12.1234567+10:00"  // finer than millis: only myFractionalSeconds has this
        }) {
      res.add(decorate(new DateTimeType(s)));
    }
    // instant: SECOND and MILLI only, and the timezone is required
    for (String s : new String[] {
        "2024-03-05T10:11:12Z",
        "2024-03-05T10:11:12.345Z",
        "2024-03-05T10:11:12.345+10:00",
        "2024-03-05T10:11:12-05:00"}) {
      res.add(decorate(new InstantType(s)));
    }
    // a timezone that came from a TimeZone object rather than from an offset in a string
    res.add(decorate(new DateTimeType(new Date(1709600000000L), TemporalPrecisionEnum.MILLI, TimeZone.getTimeZone("Australia/Brisbane"))));
    return res.stream();
  }

  private static Arguments decorate(PrimitiveType<?> value) {
    value.setId("id-1");
    value.addExtension("http://example.org/ext/simple", new StringType("e1"));
    value.addExtension("http://example.org/ext/number", new IntegerType(2));
    return Arguments.of(value.getClass().getSimpleName()+" ("+value.primitiveValue()+")", value);
  }

  private static HumanName humanName() {
    HumanName res = new HumanName();
    res.setId("hn-1");
    res.setUse(HumanName.NameUse.OFFICIAL);
    res.setFamily("Grieve");
    res.addGiven("Grahame");
    res.getFamilyElement().setId("fam-1");
    res.getFamilyElement().addExtension("http://example.org/ext/on-a-primitive", new BooleanType(true));
    return res;
  }

  private static Quantity quantity() {
    Quantity res = new Quantity();
    res.setValue(1.2300);
    res.setUnit("mg");
    res.setSystem("http://unitsofmeasure.org");
    res.setCode("mg");
    return res;
  }

  private static Patient patient() {
    Patient res = new Patient();
    res.setId("pat-1");
    res.addName(humanName());
    res.setGender(AdministrativeGender.MALE);
    res.setActive(true);
    res.addExtension("http://example.org/ext/on-a-resource", new StringType("r1"));
    res.addContained(new Patient().setActive(false).setId("contained-1"));
    res.addContact().setName(humanName());
    return res;
  }

  // ---------------------------------------------------------------- the comparison

  private static String describe(Base b) {
    StringBuilder sb = new StringBuilder();
    describe(b, sb, b.fhirType());
    return sb.toString();
  }

  private static void describe(Base b, StringBuilder sb, String path) {
    sb.append(path).append(" : ").append(b.fhirType());
    if (b.isPrimitive()) {
      sb.append(" = ").append(b.primitiveValue());
    }
    sb.append("\n");
    for (String s : hiddenState(b)) {
      sb.append(path).append(" # ").append(s).append("\n");
    }
    for (Property p : b.children()) {
      if (p.getValues() != null) {
        int i = 0;
        for (Base v : p.getValues()) {
          if (v != null) {
            describe(v, sb, path+"."+p.getName()+"["+i+"]");
          }
          i++;
        }
      }
    }
  }

  /**
   * state that is not a child element and is not compared by equalsDeep(), so nothing else in
   * this test would notice if a copy dropped it
   */
  private static List<String> hiddenState(Base b) {
    List<String> res = new ArrayList<>();
    if (b instanceof CodeType) {
      res.add("system="+((CodeType) b).getSystem());
    }
    if (b instanceof Enumeration) {
      EnumFactory<?> factory = ((Enumeration<?>) b).getEnumFactory();
      res.add("enumFactory="+(factory == null ? null : factory.getClass().getName()));
    }
    if (b instanceof BaseDateTimeType) {
      BaseDateTimeType d = (BaseDateTimeType) b;
      res.add("precision="+d.getPrecision());
      res.add("timezone="+d.getTimeZone());
      res.add("zulu="+d.isTimeZoneZulu());
      res.add("nanos="+d.getNanos());   // fractional seconds finer than the Date holds
      res.add("hasTime="+d.hasTime());
    }
    if (b instanceof IdType) {
      IdType i = (IdType) b;
      res.add("baseUrl="+i.getBaseUrl());
      res.add("resourceType="+i.getResourceType());
      res.add("idPart="+i.getIdPart());
      res.add("versionIdPart="+i.getVersionIdPart());
    }
    if (b instanceof Base64BinaryType) {
      Base64BinaryType x = (Base64BinaryType) b;
      res.add("bytes="+Arrays.hashCode(x.getValue()));
      res.add("valueAsString="+x.getValueAsString());
    }
    return res;
  }

  // ---------------------------------------------------------------- the tests

  @ParameterizedTest(name = "{0}")
  @MethodSource("primitives")
  public void primitiveCopyKeepsEverything(String name, PrimitiveType<?> src) {
    assertCopyKeepsEverything(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("composites")
  public void compositeCopyKeepsEverything(String name, Base src) {
    assertCopyKeepsEverything(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("primitives")
  public void primitiveAssignKeepsEverything(String name, PrimitiveType<?> src) throws Exception {
    assertAssignKeepsEverything(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("composites")
  public void compositeAssignKeepsEverything(String name, Base src) throws Exception {
    assertAssignKeepsEverything(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("primitives")
  public void primitiveCopyAndAssignAgree(String name, PrimitiveType<?> src) throws Exception {
    assertCopyAndAssignAgree(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("composites")
  public void compositeCopyAndAssignAgree(String name, Base src) throws Exception {
    assertCopyAndAssignAgree(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("dates")
  public void dateCopyKeepsEverything(String name, PrimitiveType<?> src) {
    assertCopyKeepsEverything(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("dates")
  public void dateAssignKeepsEverything(String name, PrimitiveType<?> src) throws Exception {
    assertAssignKeepsEverything(name, src);
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("dates")
  public void dateCopyAndAssignAgree(String name, PrimitiveType<?> src) throws Exception {
    assertCopyAndAssignAgree(name, src);
  }

  private void assertCopyKeepsEverything(String name, Base src) {
    String before = describe(src);
    Base dst = src.copy();
    assertNotNull(dst, name+": copy() returned null");
    assertEquals(src.getClass(), dst.getClass(), name+": copy() returned the wrong class");
    assertNotSame(src, dst, name+": copy() returned the source itself");
    assertEquals(before, describe(dst), name+": copy() did not preserve the state");
    assertTrue(src.equalsDeep(dst), name+": the copy is not equalsDeep to its source");
    assertEquals(before, describe(src), name+": copy() modified the source");
  }

  private void assertAssignKeepsEverything(String name, Base src) throws Exception {
    String before = describe(src);
    Base dst = src.getClass().getDeclaredConstructor().newInstance();
    // deliberately through a Base reference: that is the call that used to bind to
    // Base.copyValues and stop there
    Base source = src;
    source.assign(dst);
    assertEquals(before, describe(dst), name+": assign() did not preserve the state");
    assertTrue(src.equalsDeep(dst), name+": the assigned object is not equalsDeep to its source");
    assertEquals(before, describe(src), name+": assign() modified the source");
  }

  private void assertCopyAndAssignAgree(String name, Base src) throws Exception {
    Base viaCopy = src.copy();
    Base viaAssign = src.getClass().getDeclaredConstructor().newInstance();
    Base source = src;
    source.assign(viaAssign);
    assertEquals(describe(viaCopy), describe(viaAssign), name+": copy() and assign() disagree");
  }

  // ---------------------------------------------------------------- named regressions

  @Test
  public void assignThroughABaseReferenceReachesTheLeaf() {
    // the whole point of assign(): copyValues() alone cannot do this, because the argument type
    // changes at every level of the hierarchy
    Base src = new StringType("hello");
    Base dst = new StringType();
    src.assign(dst);
    assertEquals("hello", ((StringType) dst).getValue());
  }

  @Test
  public void copyValuesCarriesThePrimitiveValue() {
    StringType src = new StringType("hello");
    StringType dst = new StringType();
    src.copyValues(dst);
    assertEquals("hello", dst.getValue());
  }

  @Test
  public void base64BinaryCopyKeepsIdAndExtensions() {
    // Base64BinaryType.copy() used to be "return new Base64BinaryType(getValue())" - no copyValues
    // call at all, so the id and the extensions were dropped
    Base64BinaryType src = new Base64BinaryType("aGVsbG8=");
    src.setId("b64-1");
    src.addExtension("http://example.org/ext", new StringType("x"));
    Base64BinaryType dst = src.copy();
    assertEquals("b64-1", dst.getId());
    assertEquals(1, dst.getExtension().size());
    assertTrue(Arrays.equals(src.getValue(), dst.getValue()));
    assertEquals(src.getValueAsString(), dst.getValueAsString());
  }

  @Test
  public void codeTypeKeepsItsSystem() {
    CodeType src = new CodeType("final");
    src.setSystem("http://hl7.org/fhir/observation-status");
    assertEquals(src.getSystem(), src.copy().getSystem());
    CodeType dst = new CodeType();
    ((Base) src).assign(dst);
    assertEquals(src.getSystem(), dst.getSystem());
  }

  @Test
  public void dateTimeKeepsPrecisionAndTimezone() {
    DateTimeType src = new DateTimeType("2024-03-05T10:11:12.345+10:00");
    DateTimeType dst = new DateTimeType();
    ((Base) src).assign(dst);
    assertEquals(src.getValueAsString(), dst.getValueAsString());
    assertEquals(src.getPrecision(), dst.getPrecision());
    assertEquals(src.getTimeZone(), dst.getTimeZone());
    // a partial date is the same instant as the full one, so equalsDeep can't see this
    assertEquals("2024-03", new DateTimeType("2024-03").copy().getValueAsString());
  }

  @Test
  public void enumerationKeepsItsFactory() {
    Enumeration<AdministrativeGender> src = new Enumeration<>(new AdministrativeGenderEnumFactory(), AdministrativeGender.MALE);
    Enumeration<AdministrativeGender> dst = new Enumeration<>();
    ((Base) src).assign(dst);
    assertNotNull(dst.getEnumFactory(), "assign() left the target without an EnumFactory");
    assertEquals("male", dst.asStringValue());
    assertEquals(AdministrativeGender.MALE, dst.getValue());
  }

  @Test
  public void enumerationKeepsACustomCode() {
    // a CUSTOM code only exists in the string form - the coerced value is the CUSTOM constant and
    // toCode() of that is null, so copying the coerced value alone would lose the real code
    boolean custom = Configuration.isAllowCustomResourceTypes();
    try {
      Configuration.setAllowCustomResourceTypes(true);
      Enumeration<VersionIndependentResourceTypesAll> src =
          new Enumeration<>(new VersionIndependentResourceTypesAllEnumFactory(), "MyCustomResource");
      src.setId("enum-1");
      assertEquals(VersionIndependentResourceTypesAll.CUSTOM, src.getValue());
      assertEquals("MyCustomResource", src.asStringValue());
      assertEquals("MyCustomResource", src.copy().asStringValue());
      assertEquals("enum-1", src.copy().getId());
      Enumeration<VersionIndependentResourceTypesAll> dst = new Enumeration<>();
      ((Base) src).assign(dst);
      assertEquals("MyCustomResource", dst.asStringValue());
    } finally {
      Configuration.setAllowCustomResourceTypes(custom);
    }
  }

  @Test
  public void idTypeKeepsItsComponentParts() {
    IdType src = new IdType("http://example.org/fhir/Patient/123/_history/4");
    IdType dst = new IdType();
    ((Base) src).assign(dst);
    assertEquals(src.getBaseUrl(), dst.getBaseUrl());
    assertEquals(src.getResourceType(), dst.getResourceType());
    assertEquals(src.getIdPart(), dst.getIdPart());
    assertEquals(src.getVersionIdPart(), dst.getVersionIdPart());
  }

  @Test
  public void dateTimeDistinguishesZuluFromAZeroOffset() {
    // the same instant written two ways: nothing but myTimeZoneZulu and the string form tells
    // them apart, and equalsDeep() compares the Date, so it says they are equal
    DateTimeType zulu = new DateTimeType("2024-03-05T10:11:12Z");
    DateTimeType zero = new DateTimeType("2024-03-05T10:11:12+00:00");
    assertTrue(zulu.equalsDeep(zero), "the fixture is wrong: these should be the same instant");
    assertTrue(zulu.copy().isTimeZoneZulu());
    assertFalse(zero.copy().isTimeZoneZulu());
    assertEquals("2024-03-05T10:11:12Z", zulu.copy().getValueAsString());
    assertEquals("2024-03-05T10:11:12+00:00", zero.copy().getValueAsString());
  }

  @Test
  public void dateTimeKeepsSubMillisecondPrecision() {
    // the Date only goes to millis - the rest lives in myFractionalSeconds
    DateTimeType src = new DateTimeType("2024-03-05T10:11:12.1234567+10:00");
    DateTimeType dst = new DateTimeType();
    ((Base) src).assign(dst);
    assertEquals("2024-03-05T10:11:12.1234567+10:00", dst.getValueAsString());
    assertEquals(src.getNanos(), dst.getNanos());
    assertEquals(Long.valueOf(123456700L), dst.getNanos());
    assertEquals(src.getNanos(), src.copy().getNanos());
  }

  @Test
  public void dateTimeWithNoTimeZoneStaysThatWay() {
    DateTimeType src = new DateTimeType("2024-03-05T10:11:12");
    assertNull(src.getTimeZone(), "the fixture is wrong: this one has no timezone");
    DateTimeType dst = new DateTimeType();
    ((Base) src).assign(dst);
    assertNull(dst.getTimeZone(), "assign() invented a timezone");
    assertEquals("2024-03-05T10:11:12", dst.getValueAsString());
    assertNull(src.copy().getTimeZone(), "copy() invented a timezone");
  }

  @Test
  public void dateTimeKeepsANamedTimeZone() {
    // a TimeZone that did not come from an offset in a string
    TimeZone tz = TimeZone.getTimeZone("Australia/Brisbane");
    DateTimeType src = new DateTimeType(new Date(1709600000000L), TemporalPrecisionEnum.MILLI, tz);
    assertEquals(tz, src.copy().getTimeZone());
    DateTimeType dst = new DateTimeType();
    ((Base) src).assign(dst);
    assertEquals(tz, dst.getTimeZone());
    assertEquals(src.getValueAsString(), dst.getValueAsString());
  }

  @ParameterizedTest
  @ValueSource(strings = {"2024", "2024-03", "2024-03-05"})
  public void partialDatesKeepTheirPrecision(String value) {
    // "2024" and "2024-01-01" are the same Date, so the precision is the only thing that says
    // which of the two this is
    DateTimeType src = new DateTimeType(value);
    DateTimeType dst = new DateTimeType();
    ((Base) src).assign(dst);
    assertEquals(src.getPrecision(), dst.getPrecision());
    assertEquals(value, dst.getValueAsString());
    assertEquals(src.getPrecision(), src.copy().getPrecision());
    assertEquals(value, src.copy().getValueAsString());
  }

  @ParameterizedTest
  @ValueSource(strings = {"2024", "2024-03", "2024-03-05"})
  public void partialDateTypesKeepTheirPrecision(String value) {
    DateType src = new DateType(value);
    DateType dst = new DateType();
    ((Base) src).assign(dst);
    assertEquals(src.getPrecision(), dst.getPrecision());
    assertEquals(value, dst.getValueAsString());
    assertEquals(src.getPrecision(), src.copy().getPrecision());
    assertEquals(value, src.copy().getValueAsString());
  }

  @Test
  public void theCopyIsIndependentOfItsSource() {
    Patient src = patient();
    Patient dst = src.copy();
    dst.getNameFirstRep().setFamily("Changed");
    dst.setId("changed");
    assertEquals("Grieve", src.getNameFirstRep().getFamily());
    assertEquals("pat-1", src.getId());
  }
}
