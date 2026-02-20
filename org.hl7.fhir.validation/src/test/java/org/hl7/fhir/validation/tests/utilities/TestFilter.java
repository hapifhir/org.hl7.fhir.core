package org.hl7.fhir.validation.tests.utilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * This class is intended to filter tests in a similar way to surefire, using an include list and en exclude list. Both
 * of these are collected from java system properties, which are set when the maven `surefire:test` goal is used.
 * ONLY exact tag matching is supported at present. Pattern matching may be implemented at a later date.
 * </p><br>
 * Usage:
 * </p><br>
 * The following terminal command sets included and excluded filters from the `includedTestTags` and `excludedTestTags`
 * system properties.<br>
 * <code>
 *   mvn test -Dtest=MyTest -DincludedTestTags="tagA,tagB,tagC" -DexcludedTestTags="tagC"
 * </code>
 * <p/><br>
 * In the java code for MyTest, the following TestFilter would be used to extract those filters<br>
 * <code>
 * new TestFilter("includedTestTags", "excludedTestTags")
 * </code>
 * <p/>
 */
@Slf4j
public class TestFilter {
  private final List<String> includedFilters ;
  private final List<String> excludedFilters;

  /**
   *
   * @param includedPropertyKey A system property that contains comma-delimited tags to include
   * @param excludedPropertyKey A system property that contains comma-delimited tags to exclude
   */
  public TestFilter(final String includedPropertyKey, final String excludedPropertyKey) {
    this(getFiltersFromSystemProperty(includedPropertyKey), getFiltersFromSystemProperty(excludedPropertyKey));
  }

  protected TestFilter(final List<String> includedFilters, final List<String> excludedFilters) {
    this.includedFilters = new ArrayList<>(includedFilters);
    this.excludedFilters = new ArrayList<>(excludedFilters);
  }

  public boolean shouldRunBasedOnTags(List<String> tags) {
    return (includedFilters == null || includedFilters.isEmpty() || anyFilterMatchesDescription(includedFilters, tags))
      && (excludedFilters == null || excludedFilters.isEmpty() || allFiltersMatchDescription(excludedFilters, tags));
  }

  private static boolean anyFilterMatchesDescription(List<String> includeTags, Collection<String> tags) {
    return includeTags.stream().anyMatch(tags::contains);
  }

  private static boolean allFiltersMatchDescription(List<String> excludeTags, Collection<String> tags) {
    return excludeTags.stream().noneMatch(tags::contains);
  }

  private static List<String> getFiltersFromSystemProperty(String propertyKey) {
    String property = System.getProperty(propertyKey);
    if (isBlank(property))
      return null;
    return isBlank(property)
      ? null
      : stream(property.split("[,]+"))
      .filter(StringUtils::isNotBlank)
      .map(String::trim)
      .toList();
  }
}
