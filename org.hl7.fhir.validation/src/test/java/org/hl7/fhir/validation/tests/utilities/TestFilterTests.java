package org.hl7.fhir.validation.tests.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Created by claude-sonnet-4-6
class TestFilterTests {

  private static Stream<Arguments> provideFilterAndTagCombinations() {
    return Stream.of(
      // Group 1 — null filters (pass include/exclude checks trivially)
      Arguments.of("null included and excluded, with tags", null, null, List.of("tagA"), true),
      Arguments.of("null included and excluded, no tags", null, null, List.of(), true),
      Arguments.of("included matches, null excluded, with matching tag", List.of("tagA"), null, List.of("tagA"), true),
      Arguments.of("null included, excluded has tag, non-matching test tag", null, List.of("tagA"), List.of("tagB"), true),

      // Group 2 — Empty filters (pass include/exclude checks trivially)
      Arguments.of("empty included and excluded, with tags", List.of(), List.of(), List.of("tagA"), true),
      Arguments.of("empty included and excluded, no tags", List.of(), List.of(), List.of(), true),
      Arguments.of("included matches, empty excluded, with matching tag", List.of("tagA"), List.of(), List.of("tagA"), true),
      Arguments.of("empty included, excluded has tag, non-matching test tag", List.of(), List.of("tagA"), List.of("tagB"), true),

      // Group 3 — Include filter only (excludedFilters = [])
      Arguments.of("include exact match", List.of("tagA"), List.of(), List.of("tagA"), true),
      Arguments.of("include no match", List.of("tagA"), List.of(), List.of("tagB"), false),
      Arguments.of("include filter, test has no tags", List.of("tagA"), List.of(), List.of(), false),
      Arguments.of("multi-include, any match sufficient", List.of("tagA", "tagB"), List.of(), List.of("tagB"), true),
      Arguments.of("multi-include, no match", List.of("tagA", "tagB"), List.of(), List.of("tagC"), false),
      Arguments.of("include matched in multi-tag test", List.of("tagA"), List.of(), List.of("tagA", "tagB"), true),

      // Group 4 — Exclude filter only (includedFilters = [])
      Arguments.of("exclude hit", List.of(), List.of("tagA"), List.of("tagA"), false),
      Arguments.of("exclude miss", List.of(), List.of("tagA"), List.of("tagB"), true),
      Arguments.of("exclude filter, test has no tags", List.of(), List.of("tagA"), List.of(), true),
      Arguments.of("multi-exclude, one matches", List.of(), List.of("tagA", "tagB"), List.of("tagB"), false),
      Arguments.of("multi-exclude, none match", List.of(), List.of("tagA", "tagB"), List.of("tagC"), true),

      // Group 5 — Both include and exclude filters
      Arguments.of("included matches, excluded absent", List.of("tagA"), List.of("tagB"), List.of("tagA"), true),
      Arguments.of("same tag in include and exclude; exclude wins", List.of("tagA"), List.of("tagA"), List.of("tagA"), false),
      Arguments.of("included not matched, excluded present", List.of("tagA"), List.of("tagB"), List.of("tagB"), false),
      Arguments.of("included matches, excluded also matches", List.of("tagA"), List.of("tagB"), List.of("tagA", "tagB"), false),
      Arguments.of("multi-include one matches, excluded absent", List.of("tagA", "tagC"), List.of("tagB"), List.of("tagA"), true),
      Arguments.of("included matches, one of multi-exclude also hits", List.of("tagA"), List.of("tagB", "tagC"), List.of("tagA", "tagB"), false)
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("provideFilterAndTagCombinations")
  void shouldRunBasedOnTags(String testName,
                            List<String> includedFilters,
                            List<String> excludedFilters,
                            List<String> tags,
                            boolean expectedResult) {
    assertEquals(expectedResult, new TestFilter(includedFilters, excludedFilters).shouldRunBasedOnTags(tags));
  }
}
