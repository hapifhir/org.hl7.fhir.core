package org.hl7.fhir.validation.instance.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FHIRPathExpressionFixerTest {

  private static final String ELD19 = "path.matches('^[^\\\\s\\\\.,:;\\\\\\'\"\\\\/|?!@#$%&*()\\\\[\\\\]{}]{1,64}(\\\\.[^\\\\s\\\\.,:;\\\\\\'\"\\\\/|?!@#$%&*()\\\\[\\\\]{}]{1,64}(\\\\[x\\\\])?(\\\\:[^\\\\s\\\\.]+)?)*$')";
  private static final String R4_OFFSET = "offset.empty() or (when.exists() and ((when in ('C' | 'CM' | 'CD' | 'CV')).not()))";
  private static final String R4_OFFSET_FIXED = "offset.empty() or (when.exists() and when.select($this in ('C' | 'CM' | 'CD' | 'CV')).allFalse())";
  private static final String REF1_R4 = "reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))";
  private static final String PROB = "probability is decimal implies (probability as decimal) <= 100";
  private static final String PROB_FIXED = "(probability.exists() and (probability is decimal)) implies ((probability as decimal) <= 100)";

  static Stream<Arguments> cases() {
    return Stream.of(
      // expression only
      Arguments.of("telecom or endpoint", null, "4.0.1", "telecom.exists() or endpoint.exists()"),
      Arguments.of("telecom or endpoint", "org-1", "5.0.0", "telecom.exists() or endpoint.exists()"),
      Arguments.of("hasValue() or (children().count() > id.count())", "ele-1", "4.0.1", "hasValue() or (children().count() > id.count())"),
      Arguments.of("", "ele-1", "4.0.1", ""),
      // first rule wins for ref-1 (the later R3 variant is shadowed)
      Arguments.of(REF1_R4, "ref-1", "3.0.2", "reference.exists() implies (reference = '#' or (" + REF1_R4 + "))"),
      // first rule wins for name.matches
      Arguments.of("name.matches('[A-Z]([A-Za-z0-9_]){0,254}')", "cnl-0", "5.0.0", "name.exists() implies name.matches('^[A-Z]([A-Za-z0-9_]){0,254}$')"),
      // version dependent
      Arguments.of("x", "opd-3", "5.0.0", "targetProfile.exists() implies (type = 'Reference' or type = 'canonical' or type.memberOf('http://hl7.org/fhir/ValueSet/all-resource-types'))"),
      Arguments.of("x", "opd-3", "4.3.0", "targetProfile.exists() implies (type = 'Reference' or type = 'canonical' or type.memberOf('http://hl7.org/fhir/ValueSet/resource-types'))"),
      Arguments.of("x", "opd-3", "3.0.2", "x"),
      Arguments.of(R4_OFFSET, "tim-9", "4.0.1", R4_OFFSET_FIXED),
      Arguments.of(R4_OFFSET, "tim-9", "5.0.0", R4_OFFSET),
      Arguments.of("x", "eld-19", "4.0.1", ELD19),
      Arguments.of("x", "eld-19", "5.0.0", "x"),
      // key rules
      Arguments.of("htmlChecks()", "txt-2", "4.0.1", "htmlChecks2()"),
      Arguments.of("text.`div`.exists()", "dom-6", "5.0.0", "(%rootResource != $this) or text.`div`.exists()"),
      Arguments.of("probability is decimal implies probability.as(decimal) <= 100", "ras-2", "3.0.2", "probability.empty() or (probability is decimal implies probability.as(decimal) <= 100)"),
      Arguments.of("probability is decimal implies probability.as(decimal) <= 100", null, "3.0.2", "probability is decimal implies probability.as(decimal) <= 100"),
      // precedence between key and expression rules is as per the original if-chain
      Arguments.of(PROB, "txt-2", "4.0.1", PROB_FIXED),
      Arguments.of("telecom or endpoint", "txt-2", "4.0.1", "htmlChecks2()"),
      Arguments.of(REF1_R4, "eld-19", "4.0.1", "reference.exists() implies (reference = '#' or (" + REF1_R4 + "))"),
      Arguments.of(R4_OFFSET, "eld-19", "4.0.1", R4_OFFSET_FIXED),
      Arguments.of("telecom or endpoint", "eld-19", "4.0.1", ELD19),
      Arguments.of("telecom or endpoint", "eld-19", "5.0.0", "telecom.exists() or endpoint.exists()"),
      Arguments.of(PROB, "opd-3", "5.0.0", "targetProfile.exists() implies (type = 'Reference' or type = 'canonical' or type.memberOf('http://hl7.org/fhir/ValueSet/all-resource-types'))")
    );
  }

  @ParameterizedTest
  @MethodSource("cases")
  void testFixExpr(String expr, String key, String version, String expected) {
    assertEquals(expected, FHIRPathExpressionFixer.fixExpr(expr, key, version));
  }

  @Test
  void testUnchangedExpressionIsSameInstance() {
    String expr = new String("hasValue() or (children().count() > id.count())");
    assertSame(expr, FHIRPathExpressionFixer.fixExpr(expr, "ele-1", "4.0.1"));
  }

  @Test
  void testNullExpression() {
    assertNull(FHIRPathExpressionFixer.fixExpr(null, "ele-1", "4.0.1"));
    assertEquals("htmlChecks2()", FHIRPathExpressionFixer.fixExpr(null, "txt-2", "4.0.1"));
  }
}
