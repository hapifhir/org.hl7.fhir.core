package org.hl7.fhir.validation.service.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LaunchContextUtilitiesTests {

  private Map<String, String> parse(String... src) {
    Map<String, String> res = new LinkedHashMap<>();
    for (String s : src) {
      LaunchContextUtilities.addLaunchContext(res, s);
    }
    return res;
  }

  @Test
  void testRelativeFileName() {
    assertThat(parse("patient:patient-example.json")).containsExactly(Map.entry("patient", "patient-example.json"));
  }

  @Test
  void testAbsoluteFileName() {
    assertThat(parse("patient:/data/fhir/patient-example.json")).containsExactly(Map.entry("patient", "/data/fhir/patient-example.json"));
  }

  @Test
  void testUrlKeepsItsOwnColon() {
    // splitting on the first colon is what lets the reference keep the colons it needs
    assertThat(parse("user:http://example.org/fhir/Practitioner/1"))
      .containsExactly(Map.entry("user", "http://example.org/fhir/Practitioner/1"));
  }

  @Test
  void testWindowsPathKeepsItsDriveLetter() {
    assertThat(parse("patient:C:\\data\\patient-example.json"))
      .containsExactly(Map.entry("patient", "C:\\data\\patient-example.json"));
  }

  @Test
  void testSeveralContexts() {
    Map<String, String> res = parse("patient:patient-example.json", "user:practitioner-example.json", "encounter:enc.json");
    assertThat(res).hasSize(3);
    assertThat(res.get("patient")).isEqualTo("patient-example.json");
    assertThat(res.get("user")).isEqualTo("practitioner-example.json");
    assertThat(res.get("encounter")).isEqualTo("enc.json");
  }

  @Test
  void testTheReferenceIsNotResolvedHere() {
    // whether the reference resolves - or exists at all - is settled where the launch context is
    // used, not while reading the command line
    assertThat(parse("patient:no-such-file-anywhere.json")).containsExactly(Map.entry("patient", "no-such-file-anywhere.json"));
  }

  @Test
  void testDuplicateNameIsRejected() {
    // a map would quietly keep one of them, and a launch context that went missing without saying so
    // would make every expression that used it wrong
    assertThatThrownBy(() -> parse("patient:a.json", "patient:b.json"))
      .isInstanceOf(FHIRException.class)
      .hasMessageContaining("patient");
  }

  @ParameterizedTest(name = "{index}: rejects \"{0}\"")
  @ValueSource(strings = {
    "",
    "patient",
    ":",
    ":patient-example.json",
    "patient:"
  })
  void testRejectsMalformed(String src) {
    assertThatThrownBy(() -> parse(src)).isInstanceOf(FHIRException.class);
  }

  @Test
  void testRejectsNull() {
    assertThatThrownBy(() -> parse((String) null)).isInstanceOf(FHIRException.class);
  }
}
