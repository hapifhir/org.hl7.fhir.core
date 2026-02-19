package org.hl7.fhir.validation.tests.utilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * This class filters tests in a similar way to surefire, using an include list and en exclude list, both collected from
 * specified env variables.
 *
 */
@Slf4j
public class TestFilter {
  private final Optional<List<String>> includedFilters ;
  private final Optional<List<String>> excludedFilters;

  /**
   *
   * @param includedEnvVariable A system environment variable that contains comma-delimited tags to include
   * @param excludedEnvVariable A system environment variable that contains comma-delimited tags to exclude
   */
  public TestFilter(final String includedEnvVariable, final String excludedEnvVariable) {
    includedFilters = getFromEnvVariable(includedEnvVariable);
    excludedFilters = getFromEnvVariable(excludedEnvVariable);
  }

  public boolean shouldRunBasedOnTags(List<String> tags) {
    return (includedFilters.isEmpty() || anyFilterMatchesDescription(includedFilters.get(), tags))
      && (excludedFilters.isEmpty() || allFiltersMatchDescription(excludedFilters.get(), tags));
  }

  private static boolean anyFilterMatchesDescription(List<String> includeTags, Collection<String> tags) {
    return includeTags.stream().anyMatch(tags::contains);
  }

  private static boolean allFiltersMatchDescription(List<String> excludeTags, Collection<String> tags) {
    return excludeTags.stream().noneMatch(tags::contains);
  }

  private Optional<List<String>> getFromEnvVariable(String key) {
    String property = System.getProperty(key);
    for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
      System.out.println("   " + entry.getKey() + " = " + entry.getValue());
    }
    log.info("getting tags from " + key + ": " + property);
    if (isBlank(property))
      return empty();
    return isBlank(property)
      ? empty()
      : of(stream(property.split("[,]+"))
      .filter(StringUtils::isNotBlank)
      .map(String::trim)
      .toList());
  }
}
