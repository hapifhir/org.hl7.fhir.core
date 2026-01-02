package org.hl7.fhir.r5.terminologies;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.terminologies.utilities.VCLParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.ValueSet.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Comprehensive test suite for VCL (ValueSet Composition Language) Parser
 */
public class VCLParserTest {

  @Test
  @DisplayName("Simple codes with disjunction")
  public void testSimpleDisjunction() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(subscriber;provider)");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(2, include.getConcept().size());
    assertEquals("subscriber", include.getConcept().get(0).getCode());
    assertEquals("provider", include.getConcept().get(1).getCode());
  }

  @Test
  @DisplayName("Multiple systems with multiple codes")
  public void testMultipleSystemsWithCodes() throws VCLParser.VCLParseException {
    String vcl = "(http://loinc.org)(41995-2;4548-4;4549-2;17855-8;17856-6;62388-4;71875-9;59261-8;86910-7);" +
      "(http://snomed.info/sct)(365845005;165679005;165680008;65681007;451061000124104;451051000124101);" +
      "(http://www.ama-assn.org/go/cpt)(83036;83037;3044F;3046F)";

    ValueSet vs = VCLParser.parse(vcl);

    assertEquals(3, vs.getCompose().getInclude().size());

    // Check LOINC system
    ConceptSetComponent loincInclude = vs.getCompose().getInclude().get(0);
    assertEquals("http://loinc.org", loincInclude.getSystem());
    assertEquals(9, loincInclude.getConcept().size());
    assertEquals("41995-2", loincInclude.getConcept().get(0).getCode());

    // Check SNOMED system
    ConceptSetComponent snomedInclude = vs.getCompose().getInclude().get(1);
    assertEquals("http://snomed.info/sct", snomedInclude.getSystem());
    assertEquals(6, snomedInclude.getConcept().size());

    // Check CPT system
    ConceptSetComponent cptInclude = vs.getCompose().getInclude().get(2);
    assertEquals("http://www.ama-assn.org/go/cpt", cptInclude.getSystem());
    assertEquals(4, cptInclude.getConcept().size());
  }

  @Test
  @DisplayName("Complex expression with filters and exclusion")
  public void testComplexExpressionWithExclusion() throws VCLParser.VCLParseException {
    String vcl = "((http://snomed.info/sct)concept<<17311000168105;" +
      "(http://snomed.info/sct)(61796011000036105;923929011000036103);" +
      "(http://loinc.org)ancestor=LP185676-6)-((http://loinc.org)76573-5)";

    ValueSet vs = VCLParser.parse(vcl);

    assertEquals(3, vs.getCompose().getInclude().size());
    assertEquals(1, vs.getCompose().getExclude().size());

    // Check exclusion
    ConceptSetComponent exclude = vs.getCompose().getExclude().get(0);
    assertEquals("http://loinc.org", exclude.getSystem());
    assertEquals(1, exclude.getConcept().size());
    assertEquals("76573-5", exclude.getConcept().get(0).getCode());
  }

  @Test
  @DisplayName("Different systems with disjunction")
  public void testDifferentSystemsDisjunction() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(http://hl7.org/fhir/paymentstatus)paid;(http://hl7.org/fhir/payeetype)provider");

    assertEquals(2, vs.getCompose().getInclude().size());

    ConceptSetComponent include1 = vs.getCompose().getInclude().get(0);
    assertEquals("http://hl7.org/fhir/paymentstatus", include1.getSystem());
    assertEquals("paid", include1.getConcept().get(0).getCode());

    ConceptSetComponent include2 = vs.getCompose().getInclude().get(1);
    assertEquals("http://hl7.org/fhir/payeetype", include2.getSystem());
    assertEquals("provider", include2.getConcept().get(0).getCode());
  }

  @Test
  @DisplayName("Include valueset")
  public void testIncludeValueSet() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("^(http://hl7.org/fhir/ValueSet/payeetype)");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getValueSet().size());
    assertEquals("http://hl7.org/fhir/ValueSet/payeetype", include.getValueSet().get(0).primitiveValue());
  }

  @Test
  @DisplayName("Filter without system")
  public void testFilterWithoutSystem() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("ancestor=LP185676-6");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("ancestor", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.EQUAL, filter.getOp());
    assertEquals("LP185676-6", filter.getValue());
  }

  @Test
  @DisplayName("Regex filter")
  public void testRegexFilter() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("COMPONENT/\".*Dichloroethane.*\"");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("COMPONENT", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.REGEX, filter.getOp());
    assertEquals(".*Dichloroethane.*", filter.getValue());
  }

  @Test
  @DisplayName("Simple equality filter")
  public void testSimpleEqualityFilter() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("COMPONENT=LP15653-6");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("COMPONENT", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.EQUAL, filter.getOp());
    assertEquals("LP15653-6", filter.getValue());
  }

  @Test
  @DisplayName("Simple codes in parentheses with disjunction")
  public void testSimpleCodesInParentheses() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(10007-3;10008-1)");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(2, include.getConcept().size());
    assertEquals("10007-3", include.getConcept().get(0).getCode());
    assertEquals("10008-1", include.getConcept().get(1).getCode());
  }

  @Test
  @DisplayName("Descendant-of filter")
  public void testDescendantOfFilter() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("concept<<17311000168105");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("concept", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.ISA, filter.getOp());
    assertEquals("17311000168105", filter.getValue());
  }

  @Test
  @DisplayName("IS-A filter")
  public void testIsAFilter() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("concept<<17311000168105");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("concept", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.ISA, filter.getOp());
    assertEquals("17311000168105", filter.getValue());
  }

  @Test
  @DisplayName("IS-NOT-A filter")
  public void testIsNotAFilter() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("concept~<<929360061000036106");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("concept", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.ISNOTA, filter.getOp());
    assertEquals("929360061000036106", filter.getValue());
  }

  @Test
  @DisplayName("Simple single code")
  public void testSingleCode() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("A");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getConcept().size());
    assertEquals("A", include.getConcept().get(0).getCode());
  }

  @Test
  @DisplayName("Conjunction with comma")
  public void testConjunctionWithComma() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("A,B");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(2, include.getConcept().size());
    assertEquals("A", include.getConcept().get(0).getCode());
    assertEquals("B", include.getConcept().get(1).getCode());
  }

  @Test
  @DisplayName("Disjunction with semicolon")
  public void testDisjunctionWithSemicolon() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("A;B");

    assertEquals(2, vs.getCompose().getInclude().size());
    assertEquals("A", vs.getCompose().getInclude().get(0).getConcept().get(0).getCode());
    assertEquals("B", vs.getCompose().getInclude().get(1).getConcept().get(0).getCode());
  }

  @Test
  @DisplayName("Wildcard with system")
  public void testWildcardWithSystem() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(http://snomed.info/sct)*");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals("http://snomed.info/sct", include.getSystem());
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("concept", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.EXISTS, filter.getOp());
    assertEquals("true", filter.getValue());
  }

  @Test
  @DisplayName("Multiple status codes")
  public void testMultipleStatusCodes() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(in-progress;aborted;completed;entered-in-error)");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(4, include.getConcept().size());
    assertEquals("in-progress", include.getConcept().get(0).getCode());
    assertEquals("aborted", include.getConcept().get(1).getCode());
    assertEquals("completed", include.getConcept().get(2).getCode());
    assertEquals("entered-in-error", include.getConcept().get(3).getCode());
  }

  @Test
  @DisplayName("Include and exclude same valueset")
  public void testIncludeExcludeSameValueSet() throws VCLParser.VCLParseException, IOException {
    ValueSet vs = VCLParser.parse("(^(http://csiro.au/fhir/ValueSet/selfexclude))-(^(http://csiro.au/fhir/ValueSet/selfexclude))");

    System.out.println(new JsonParser().composeString(vs));
    assertEquals(1, vs.getCompose().getInclude().size());
    assertEquals(1, vs.getCompose().getExclude().size());

    assertEquals("http://csiro.au/fhir/ValueSet/selfexclude",
      vs.getCompose().getInclude().get(0).getValueSet().get(0).primitiveValue());
    assertEquals("http://csiro.au/fhir/ValueSet/selfexclude",
      vs.getCompose().getExclude().get(0).getValueSet().get(0).primitiveValue());
  }

  @Test
  @DisplayName("Include one valueset, exclude another")
  public void testIncludeExcludeDifferentValueSets() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(^(http://csiro.au/fhir/ValueSet/selfimport))-(^(http://csiro.au/fhir/ValueSet/selfexcludeA))");

    assertEquals(1, vs.getCompose().getInclude().size());
    assertEquals(1, vs.getCompose().getExclude().size());

    assertEquals("http://csiro.au/fhir/ValueSet/selfimport",
      vs.getCompose().getInclude().get(0).getValueSet().get(0).primitiveValue());
    assertEquals("http://csiro.au/fhir/ValueSet/selfexcludeA",
      vs.getCompose().getExclude().get(0).getValueSet().get(0).primitiveValue());
  }

  @Test
  @DisplayName("Descendant-of with quoted value")
  public void testDescendantOfWithQuotedValue() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("concept<<\"_ActNoImmunizationReason\"");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("concept", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.ISA, filter.getOp());
    assertEquals("_ActNoImmunizationReason", filter.getValue());
  }

  @Test
  @DisplayName("Equality filter with numeric code")
  public void testEqualityFilterWithNumericCode() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("has_ingredient = 1886");

    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(1, include.getFilter().size());

    ConceptSetFilterComponent filter = include.getFilter().get(0);
    assertEquals("has_ingredient", filter.getProperty());
    assertEquals(Enumerations.FilterOperator.EQUAL, filter.getOp());
    assertEquals("1886", filter.getValue());
  }

  // Tests for cases that may not be fully supported yet
  @Test
  @DisplayName("Complex filter with constraint (may fail)")
  public void testComplexConstraintFilter() throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse("(constraint=\"<< 30506011000036107 |australian product|: 700000101000036108 |hasTP| = 17311000168105 |PANADOL|\",expression=\"<< 30506011000036107 |australian product|: 700000101000036108 |hasTP| = 17311000168105 |PANADOL|\")");
    assertNotNull(vs);
    assertEquals(1, vs.getCompose().getInclude().size());
  }

//  @Test
//  @DisplayName("'Of' operator (may not be supported yet)")
//  public void testOfOperator() {
//    assertThrows(VCLParser.VCLParseException.class, () -> {
//      VCLParser.parse("panadol.contains");
//    });
//  }

  @Test
  @DisplayName("Nested filters (may not be supported yet)")
  public void testNestedFilters() {
    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse("has_ingredient^(has_tradename=2201670)");
    });
  }

  @Test
  @DisplayName("Multiple filters with commas (may not be supported yet)")
  public void testMultipleFiltersWithCommas() throws VCLParser.VCLParseException {
    // This should now work since we improved the parser
    ValueSet vs = VCLParser.parse("(has_ingredient=1886, has_dose_form=317541)");
    assertNotNull(vs);
    assertEquals(1, vs.getCompose().getInclude().size());
    ConceptSetComponent include = vs.getCompose().getInclude().get(0);
    assertEquals(2, include.getFilter().size()); // Should have 2 filters

    // Check the filters
    assertEquals("has_ingredient", include.getFilter().get(0).getProperty());
    assertEquals("1886", include.getFilter().get(0).getValue());
    assertEquals("has_dose_form", include.getFilter().get(1).getProperty());
    assertEquals("317541", include.getFilter().get(1).getValue());
  }

  // Parameter tests for simple cases
  @ParameterizedTest
  @ValueSource(strings = {
    "A",
    "123456",
    "test-code",
    "\"quoted code\"",
    "*"
  })
  @DisplayName("Simple code parsing")
  public void testSimpleCodes(String code) throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse(code);
    assertNotNull(vs);
    assertEquals(1, vs.getCompose().getInclude().size());

    if (!"*".equals(code)) {
      ConceptSetComponent include = vs.getCompose().getInclude().get(0);
      if (include.getConcept().size() > 0) {
        String expectedCode = code.startsWith("\"") && code.endsWith("\"")
          ? code.substring(1, code.length() - 1)
          : code;
        assertEquals(expectedCode, include.getConcept().get(0).getCode());
      }
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {
    "^(http://hl7.org/fhir/ValueSet/test1)",
    "^(http://hl7.org/fhir/ValueSet/test2)",
    "^(http://example.org/valueset)"
  })
  @DisplayName("ValueSet includes")
  public void testValueSetIncludes(String vcl) throws VCLParser.VCLParseException {
    ValueSet vs = VCLParser.parse(vcl);
    assertNotNull(vs);
    assertEquals(1, vs.getCompose().getInclude().size());
    assertEquals(1, vs.getCompose().getInclude().get(0).getValueSet().size());
  }

  @Test
  @DisplayName("Empty expression should fail")
  public void testEmptyExpression() {
    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse("");
    });

    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse("   ");
    });

    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse(null);
    });
  }

  @Test
  @DisplayName("Invalid syntax should fail")
  public void testInvalidSyntax() {
    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse("((unclosed");
    });

    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse("A B C"); // No operators between codes
    });

    assertThrows(VCLParser.VCLParseException.class, () -> {
      VCLParser.parse("=value"); // Filter without property
    });
  }

  @Test
  @DisplayName("Complex multi-part expression")
  void testComplexExpression() {
    assertDoesNotThrow(() -> {
      VCLParser.parse("(http://example.com/cs/meds) (" +
          "     {concept<<Panadol}.container," +
          "     {Panadol_500mg_24.unit_of_use}.active_ingredient," +
          "     concept<<12345," +
          "     concept^{12346,6374673,9234983,38924839,212,43243}," +
          "     ingredient^{parent=98765, concept<<Panadol}" +
          "   )");
    });
  }

  /**
   * Helper method to print ValueSet structure for debugging
   */
  private void printValueSetStructure(ValueSet vs) {
    System.out.println("ValueSet structure:");
    System.out.println("  Includes: " + vs.getCompose().getInclude().size());
    for (int i = 0; i < vs.getCompose().getInclude().size(); i++) {
      ConceptSetComponent include = vs.getCompose().getInclude().get(i);
      System.out.printf("    Include %d: system=%s, concepts=%d, filters=%d, valueSets=%d%n",
        i, include.getSystem(), include.getConcept().size(),
        include.getFilter().size(), include.getValueSet().size());
    }
    System.out.println("  Excludes: " + vs.getCompose().getExclude().size());
    for (int i = 0; i < vs.getCompose().getExclude().size(); i++) {
      ConceptSetComponent exclude = vs.getCompose().getExclude().get(i);
      System.out.printf("    Exclude %d: system=%s, concepts=%d, filters=%d, valueSets=%d%n",
        i, exclude.getSystem(), exclude.getConcept().size(),
        exclude.getFilter().size(), exclude.getValueSet().size());
    }
  }
}