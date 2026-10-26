package org.hl7.fhir.r5.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base64BinaryType;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.InstantType;
import org.hl7.fhir.r5.model.Integer64Type;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.OidType;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.PositiveIntType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.model.UnsignedIntType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * isDistinct() and distinct() use a hash set when every item is a primitive that doEquals() compares by value, and compare
 * every pair otherwise. These tests check that both give the same answers as comparing every pair with '=' (which is
 * doEquals()), for collections of mixed primitive types, from the object model and from the element model
 */
class FHIRPathDistinctTests {

  private static FHIRPathEngine fp;
  private static SimpleWorkerContext context;
  private static List<Base> elementValues;

  private static ExpressionNode EQUALS;
  private static ExpressionNode IS_DISTINCT;
  private static ExpressionNode DISTINCT;

  @BeforeAll
  static void setUp() throws FHIRException, IOException {
    context = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    fp = new FHIRPathEngine(context);
    EQUALS = fp.parse("%a = %b");
    IS_DISTINCT = fp.parse("%c.isDistinct()");
    DISTINCT = fp.parse("%c.distinct()");
    elementValues = parseElementValues();
  }

  @AfterAll
  static void tearDown() {
    fp = null;
    context = null;
    elementValues = null;
  }

  // the values of the extensions in a Basic, parsed into the element model, and two complex nodes given a value
  private static List<Base> parseElementValues() throws IOException {
    String[] values = {
      "\"valueDecimal\": 1", "\"valueDecimal\": 1.0", "\"valueDecimal\": 1.00", "\"valueDecimal\": 100", "\"valueDecimal\": 10.0",
      "\"valueDecimal\": 1.50", "\"valueDecimal\": 0.0", "\"valueDecimal\": 1e2",
      "\"valueInteger\": 1", "\"valueInteger\": 100", "\"valueInteger\": 10", "\"valuePositiveInt\": 1", "\"valueUnsignedInt\": 100",
      "\"valueString\": \"1\"", "\"valueString\": \"1.0\"", "\"valueString\": \"100\"", "\"valueString\": \"a\"", "\"valueString\": \"2020\"",
      "\"valueCode\": \"a\"", "\"valueCode\": \"1\"", "\"valueUri\": \"a\"", "\"valueId\": \"a\"", "\"valueMarkdown\": \"a\"",
      "\"valueBoolean\": true", "\"valueBoolean\": false", "\"valueBase64Binary\": \"AAAA\"", "\"valueTime\": \"10:00:00\"",
      "\"valueDate\": \"2020\"", "\"valueDate\": \"2020-01-01\"", "\"valueDateTime\": \"2020-01-01T10:00:00+10:00\"",
      "\"valueDateTime\": \"2020-01-01T00:00:00Z\"", "\"valueInstant\": \"2020-01-01T00:00:00Z\"",
      "\"valueQuantity\": {\"value\": 1}", "\"valueQuantity\": {\"value\": 1.0, \"unit\": \"mg\"}", "\"valueCoding\": {\"code\": \"a\"}",
      "\"_valueString\": {\"extension\": [{\"url\": \"http://hl7.org/fhir/StructureDefinition/data-absent-reason\", \"valueCode\": \"unknown\"}]}"
    };
    String json = "{\"resourceType\": \"Basic\", \"code\": {\"text\": \"test\"}, \"extension\": ["
        + java.util.Arrays.stream(values).map(v -> "{\"url\": \"http://example.org/v\", " + v + "}").collect(Collectors.joining(", "))
        + "]}";
    Element basic = Manager.parse(context, new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON).get(0).getElement();
    List<Base> res = fp.evaluate(basic, "Basic.extension.value");
    Assertions.assertEquals(values.length, res.size());
    // complex nodes with a value, like a CDA ST: doEquals() compares these with compareDeep(), not by value
    Element code = basic.getNamedChild("code");
    code.setValue("a");
    res.add(code);
    Element extension = basic.getChildrenByName("extension").get(0);
    extension.setValue("1.0");
    res.add(extension);
    return res;
  }

  private static List<Base> modelValues() {
    List<Base> res = new ArrayList<>();
    for (String s : new String[] {"1", "1.0", "1.00", "100", "10.0", "1.50", "0.0", "-0", "1e2"}) {
      res.add(new DecimalType(s));
    }
    res.add(new IntegerType(1));
    res.add(new IntegerType(100));
    res.add(new IntegerType(10));
    res.add(new PositiveIntType(1));
    res.add(new UnsignedIntType(100));
    res.add(new Integer64Type(1L));
    for (String s : new String[] {"1", "1.0", "100", "a", "A", "2020", "true", ""}) {
      res.add(new StringType(s));
    }
    res.add(new StringType());
    res.add(new CodeType("a"));
    res.add(new CodeType("1"));
    res.add(new IdType("a"));
    res.add(new UriType("a"));
    res.add(new CanonicalType("a"));
    res.add(new MarkdownType("a"));
    res.add(new OidType("urn:oid:1.2"));
    res.add(new Base64BinaryType("AAAA"));
    res.add(new BooleanType(true));
    res.add(new BooleanType(false));
    res.add(new TimeType("10:00:00"));
    res.add(new DateType("2020"));
    res.add(new DateType("2020-01-01"));
    res.add(new DateTimeType("2020-01-01T10:00:00+10:00"));
    res.add(new DateTimeType("2020-01-01T00:00:00Z"));
    res.add(new DateTimeType("2020"));
    res.add(new InstantType("2020-01-01T00:00:00Z"));
    res.add(new Quantity().setValue(BigDecimal.ONE));
    res.add(new Quantity().setValue(new BigDecimal("1.0")).setUnit("mg"));
    res.add(new Coding(null, "a", null));
    return res;
  }

  private Map<String, List<Base>> vars(String name, List<Base> value) {
    Map<String, List<Base>> map = new HashMap<>();
    map.put(name, value);
    return map;
  }

  private List<Base> evaluate(ExpressionNode node, Map<String, List<Base>> vars) {
    return fp.evaluate(null, null, null, new Patient(), node, vars);
  }

  // doEquals(), through '=': null when the answer is empty
  private Boolean equal(Base a, Base b) {
    Map<String, List<Base>> map = vars("a", List.of(a));
    map.put("b", List.of(b));
    List<Base> res = evaluate(EQUALS, map);
    return res.isEmpty() ? null : Boolean.valueOf(res.get(0).primitiveValue());
  }

  // isDistinct() as it was before the hash set: compare every pair
  private String pairwiseIsDistinct(List<Base> focus) {
    boolean distinct = true;
    for (int i = 0; i < focus.size(); i++) {
      for (int j = i + 1; j < focus.size(); j++) {
        Boolean eq = equal(focus.get(j), focus.get(i));
        if (eq == null) {
          return "{}";
        } else if (eq) {
          distinct = false;
          break;
        }
      }
    }
    return Boolean.toString(distinct);
  }

  // distinct() as it was before the hash set: keep the items that nothing after them equals
  private List<Base> pairwiseDistinct(List<Base> focus) {
    if (focus.size() <= 1) {
      return focus;
    }
    List<Base> result = new ArrayList<>();
    for (int i = 0; i < focus.size(); i++) {
      boolean found = false;
      for (int j = i + 1; j < focus.size(); j++) {
        Boolean eq = equal(focus.get(j), focus.get(i));
        if (eq == null) {
          return new ArrayList<>();
        } else if (eq) {
          found = true;
          break;
        }
      }
      if (!found) {
        result.add(focus.get(i));
      }
    }
    return result;
  }

  private String describe(List<Base> list) {
    return list.stream().map(b -> b.fhirType() + (b instanceof Element ? "(element)" : "") + ":" + b.primitiveValue()).collect(Collectors.joining(", ", "[", "]"));
  }

  private void checkSameAsPairwise(List<Base> focus) {
    List<Base> isDistinct = evaluate(IS_DISTINCT, vars("c", focus));
    String actual = isDistinct.isEmpty() ? "{}" : isDistinct.get(0).primitiveValue();
    Assertions.assertEquals(pairwiseIsDistinct(focus), actual, "isDistinct() of " + describe(focus));

    List<Base> distinct = evaluate(DISTINCT, vars("c", focus));
    List<Base> expected = pairwiseDistinct(focus);
    Assertions.assertEquals(expected.size(), distinct.size(), "distinct() of " + describe(focus) + " gave " + describe(distinct));
    for (int i = 0; i < expected.size(); i++) {
      Assertions.assertSame(expected.get(i), distinct.get(i), "distinct() of " + describe(focus) + " gave " + describe(distinct));
    }
  }

  private boolean hashable(Base b) {
    return b.isPrimitive() && b.primitiveValue() != null && !b.hasType("date", "dateTime", "instant");
  }

  @Test
  void testRandomCollectionsGiveTheSameAnswerAsComparingEveryPair() {
    List<Base> all = new ArrayList<>(modelValues());
    all.addAll(elementValues);
    List<Base> hashable = all.stream().filter(this::hashable).collect(Collectors.toList());
    List<Base> numbers = all.stream().filter(b -> hashable(b) && b.primitiveValue().matches("[-0-9.e]*")).collect(Collectors.toList());
    Random random = new Random(20261013);
    for (int n = 0; n < 4000; n++) {
      // mostly pick from collections the hash set can be used for, or numbers, where decimals make it more complicated
      List<Base> pool = n % 3 == 0 ? all : n % 3 == 1 ? hashable : numbers;
      int size = random.nextInt(10);
      List<Base> focus = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        focus.add(pool.get(random.nextInt(pool.size())));
      }
      checkSameAsPairwise(focus);
    }
  }

  @Test
  void testDistinctKeepsTheLastOfEachValueInOrder() {
    StringType a1 = new StringType("a");
    CodeType b1 = new CodeType("b");
    StringType a2 = new StringType("a");
    IntegerType one = new IntegerType(1);
    CodeType b2 = new CodeType("b");
    DecimalType oneDecimal = new DecimalType("1.0");
    List<Base> res = evaluate(DISTINCT, vars("c", List.of(a1, b1, a2, one, b2, oneDecimal)));
    Assertions.assertEquals(3, res.size());
    Assertions.assertSame(a2, res.get(0));
    Assertions.assertSame(b2, res.get(1));
    Assertions.assertSame(oneDecimal, res.get(2));
  }

  @Test
  void testElementModelDecimalsCompareAsDecimals() {
    // decimals from a resource aren't DecimalType, but they still compare as decimals: 1, 1.0 and 1.00 are the same
    // value, and so is the integer 1
    List<Base> decimals = elementValues.subList(0, 3);
    for (Base b : decimals) {
      Assertions.assertEquals("decimal", b.fhirType());
      Assertions.assertFalse(b instanceof DecimalType);
    }
    Assertions.assertEquals("1.00", decimals.get(2).primitiveValue());
    Assertions.assertEquals(Boolean.TRUE, equal(decimals.get(1), decimals.get(2)));
    Assertions.assertEquals(Boolean.TRUE, equal(decimals.get(1), new IntegerType(1)));
    Assertions.assertEquals(Boolean.TRUE, equal(decimals.get(1), new DecimalType("1.000")));
    Assertions.assertEquals("false", evaluate(IS_DISTINCT, vars("c", decimals)).get(0).primitiveValue());
    Assertions.assertEquals(1, evaluate(DISTINCT, vars("c", decimals)).size());
    // 100 isn't 1.0
    Assertions.assertEquals(Boolean.FALSE, equal(elementValues.get(1), elementValues.get(3)));
  }

  @Test
  void testLargeCollection() {
    List<Base> focus = new ArrayList<>();
    for (int i = 0; i < 20000; i++) {
      focus.add(new StringType("v" + i));
    }
    Assertions.assertEquals("true", evaluate(IS_DISTINCT, vars("c", focus)).get(0).primitiveValue());
    Assertions.assertEquals(20000, evaluate(DISTINCT, vars("c", focus)).size());
    focus.add(new CodeType("v0"));
    Assertions.assertEquals("false", evaluate(IS_DISTINCT, vars("c", focus)).get(0).primitiveValue());
    Assertions.assertEquals(20000, evaluate(DISTINCT, vars("c", focus)).size());
  }
}
