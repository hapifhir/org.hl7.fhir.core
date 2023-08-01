package org.hl7.fhir.validation.cli.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AsteriskFilterTests {

  private static Stream<Arguments> provideValidFiltersAndDirsForwardSlash() {
    return Stream.of(
      Arguments.of("one/*", "one/", ".*"),
      Arguments.of("/one/*", "/one/", ".*"),
      Arguments.of("/one/*.*", "/one/", ".*\\..*"),
      Arguments.of("/one/two.*", "/one/", "two\\..*"),
      Arguments.of("/one/*.two", "/one/", ".*\\.two"),
      Arguments.of("one/*/*", "one/*/", ".*"),
      Arguments.of("one/*/*.*", "one/*/", ".*\\..*"),
      Arguments.of("/one/two/*", "/one/two/",".*"),
      Arguments.of("one/two/*/*.*", "one/two/*/", ".*\\..*"),
      Arguments.of("one/two/*/three.*", "one/two/*/", "three\\..*"),
      Arguments.of("one/two/*/*.three", "one/two/*/", ".*\\.three"),
      Arguments.of("one/two/*/*.*three", "one/two/*/", ".*\\..*three"),
      Arguments.of("/one-two/*", "/one-two/", ".*"),
      Arguments.of("/one-two/three/*", "/one-two/three/", ".*")
    );
  }

  @ParameterizedTest
  @MethodSource("provideValidFiltersAndDirsForwardSlash")
  public void testValidFilterDirAndRegex(String filterString, String expectedDir, String expectedRegex) throws IOException {
    //Test with forward slash separators
    testFilterDirExtraction(filterString, expectedDir, expectedRegex);
    //Test with backward slash separators
    testFilterDirExtraction(filterString.replace('/','\\'), expectedDir.replace('/','\\'), expectedRegex.replace('/','\\'));
  }

  private static void testFilterDirExtraction(String filterString, String expectedDir, String expectedRegex) throws IOException {
    AsteriskFilter asteriskFilter = getAsteriskFilterWithoutDirValidityCheck(filterString);
   assertEquals(expectedRegex, asteriskFilter.regex);
    assertEquals(expectedDir, asteriskFilter.dir);
  }

  @ParameterizedTest
  @ValueSource(
    strings = {
      "",
      "one/",
      "one\\",
      "one/two",
      "one\\two"
    }
  )
  public void testInvalidFilterThrowsException(String filterString) {
    IOException thrown = Assertions.assertThrows(IOException.class, () -> {
      AsteriskFilter asteriskFilter = getAsteriskFilterWithoutDirValidityCheck(filterString);
    }, "NumberFormatException was expected");
  }

  @Nonnull
  private static AsteriskFilter getAsteriskFilterWithoutDirValidityCheck(String filterString) throws IOException {
    return new AsteriskFilter(filterString) {
      @Override
      protected void isDirValid() throws IOException {
        // Dont check for existent directory in this case.
      }
    };
  }
}
