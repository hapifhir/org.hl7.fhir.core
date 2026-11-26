package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * VersionUtilities.versionMatchesGeneral, for everything but two semver versions (versionMatches is tested on its
 * own): empty values, integers, other versions that aren't semver, dates, SNOMED CT editions, and mixtures. Throughout,
 * a criteria only matches a whole part at a time
 */
class VersionMatchesGeneralTests {

  private static void check(String criteria, String candidate, boolean matches) {
    assertEquals(matches, VersionUtilities.versionMatchesGeneral(criteria, candidate), criteria + " vs " + candidate);
  }

  /** no criteria matches anything; a criteria matches nothing that's missing */
  @ParameterizedTest(name = "{0} vs {1}")
  @CsvSource(delimiter = '|', nullValues = "NULL", value = {
    "NULL    | NULL                  | true",
    "''      | NULL                  | true",
    "NULL    | ''                    | true",
    "''      | ''                    | true",
    "NULL    | 1.0.0                 | true",
    "''      | 2024-01-01            | true",
    "NULL    | http://snomed.info/sct/900000000000207008/version/20240101 | true",
    "1.0.0   | NULL                  | false",
    "1.0.0   | ''                    | false",
    "2024    | NULL                  | false",
    "abc     | ''                    | false",
  })
  void emptyValues(String criteria, String candidate, boolean matches) {
    check(criteria, candidate, matches);
  }

  /** a version always matches itself, whatever it is */
  @ParameterizedTest(name = "{0}")
  @CsvSource(delimiter = '|', value = {
    "1", "42", "v1", "R4B", "draft", "1.0", "1.0a", "2024", "202401", "20240101", "2024-01", "2024-01-01",
    "2024-01-01T10:00:00Z", "2024-01-01T10:00:00+10:00", "abc def", "http://example.org/version/2",
    "http://snomed.info/sct/900000000000207008", "http://snomed.info/sct/900000000000207008/version/20240101",
    "http://snomed.info/sct", "http://snomed.info/sct/abc"
  })
  void aVersionMatchesItself(String version) {
    check(version, version, true);
  }

  /** integers: only a whole number matches */
  @ParameterizedTest(name = "{0} vs {1}")
  @CsvSource(delimiter = '|', value = {
    "1   | 1     | true",
    "1   | 10    | false",
    "1   | 11    | false",
    "10  | 1     | false",
    "2   | 10    | false",
    "12  | 123   | false",
    "1   | 2     | false",
    "007 | 7     | false",
  })
  void integers(String criteria, String candidate, boolean matches) {
    check(criteria, candidate, matches);
  }

  /**
   * versions that aren't semver, dates or integers: the criteria has to be the start of the candidate, ending where a
   * part of it does (at a '.', '-', '_', '/', ':' or '+', or the end)
   */
  @ParameterizedTest(name = "{0} vs {1}")
  @CsvSource(delimiter = '|', value = {
    "v1          | v1.2          | true",
    "v1          | v1-beta       | true",
    "v1          | v1_2          | true",
    "v1          | v1/2          | true",
    "v1          | v1:2          | true",
    "v1          | v1+build      | true",
    "v1.         | v1.2          | true",
    "v1          | v10           | false",
    "v1          | v1beta        | false",
    "R4          | R4B           | false",
    "R4          | R4.0          | true",
    "abc         | abcd          | false",
    "abc         | ab            | false",
    "abc         | xabc          | false",
    "draft       | Draft         | false",
    "draft       | draft-2       | true",
    "release-1   | release-10    | false",
    "release-1   | release-1-rc2 | true",
    "a.b         | a.b.c         | true",
    "a.b         | a.bc          | false",
    "1.0a        | 1.0a.1        | true",
    "1.0a        | 1.0ab         | false",
  })
  void otherVersions(String criteria, String candidate, boolean matches) {
    check(criteria, candidate, matches);
  }

  /** an integer, or a semver version, against something that isn't the same kind of version */
  @ParameterizedTest(name = "{0} vs {1}")
  @CsvSource(delimiter = '|', value = {
    "1      | 1.0          | true",
    "1      | 1.0.0        | true",
    "1      | 10.0         | false",
    "1      | 1a           | false",
    "1      | 1-beta       | true",
    "1.0    | 1.0a         | false",
    "1.0    | 1.01         | false",
    "1.0.0  | 1.0.0a       | false",
    "1.0.0  | 2024-01-01   | false",
    "v1     | 1.0.0        | false",
    "1.0.0  | v1.0.0       | false",
  })
  void mixedKinds(String criteria, String candidate, boolean matches) {
    check(criteria, candidate, matches);
  }

  /**
   * dates: a part at a time. The parts are the year, month and day (written with '-', or not: 20240101), and the
   * parts of the time ('T' and ':')
   */
  @ParameterizedTest(name = "{0} vs {1}")
  @CsvSource(delimiter = '|', value = {
    "2026                | 2026-12-01                | true",
    "2026-12             | 2026-12-01                | true",
    "2026-12-01          | 2026-12-01                | true",
    "2026-1              | 2026-12                   | false",
    "2026-1              | 2026-12-01                | false",
    "2026-12-0           | 2026-12-01                | false",
    "2026-12-02          | 2026-12-01                | false",
    "2025                | 2026-12-01                | false",
    "202                 | 2026-12-01                | false",
    "2026-12-01          | 2026-12                   | false",
    "2026-12             | 2026                      | false",
    // compact (no '-')
    "2026                | 20261201                  | true",
    "202612              | 20261201                  | true",
    "20261201            | 20261201                  | true",
    "202611              | 20261201                  | false",
    "2026120             | 20261201                  | false",
    "20261               | 20261201                  | false",
    "20261202            | 20261201                  | false",
    "20261201            | 202612                    | false",
    // the same date, written both ways
    "2026-12-01          | 20261201                  | true",
    "20261201            | 2026-12-01                | true",
    "2026-12             | 20261201                  | true",
    "202612              | 2026-12-01                | true",
    // times
    "2026-12-01          | 2026-12-01T10:30:00       | true",
    "2026-12-01T10       | 2026-12-01T10:30          | true",
    "2026-12-01T10:30    | 2026-12-01T10:30:15       | true",
    "2026-12-01T1        | 2026-12-01T10:30          | false",
    "2026-12-01T10:3     | 2026-12-01T10:30          | false",
    "2026-12-01T11       | 2026-12-01T10:30          | false",
    "2026-12-01T10:30:15 | 2026-12-01T10:30          | false",
    "20261201            | 2026-12-01T10:30:00       | true",
    "2026-12-01T10:00:00Z | 2026-12-01T10:00:00+10:00 | false",
    "2026-12             | 2026-12-01T00:00:00Z      | true",
  })
  void dates(String criteria, String candidate, boolean matches) {
    check(criteria, candidate, matches);
  }

  /**
   * SNOMED CT editions (http://snomed.info/sct/[module](/version/[date])): only the same module matches. A criteria
   * with no version matches every version of the module; one with a version matches version dates as dates do
   */
  @ParameterizedTest(name = "{0} vs {1}")
  @CsvSource(delimiter = '|', value = {
    // the module
    "http://snomed.info/sct/900000000000207008                  | http://snomed.info/sct/900000000000207008/version/20240101 | true",
    "http://snomed.info/sct/900000000000207008/                 | http://snomed.info/sct/900000000000207008/version/20240101 | true",
    "http://snomed.info/sct/900000000000207008                  | http://snomed.info/sct/900000000000207008                  | true",
    "http://snomed.info/sct/900000000000207008                  | http://snomed.info/sct/900000000000207008/                 | true",
    "http://snomed.info/sct/90000000000020700                   | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/9000000000002070080                 | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/32506021000036107                   | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/731000124108                        | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008                  | http://snomed.info/sct/32506021000036107/version/20240101  | false",
    // the version
    "http://snomed.info/sct/900000000000207008/version/20240101 | http://snomed.info/sct/900000000000207008/version/20240101 | true",
    "http://snomed.info/sct/900000000000207008/version/20240101 | http://snomed.info/sct/900000000000207008/version/20240201 | false",
    "http://snomed.info/sct/900000000000207008/version/20240201 | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/2024     | http://snomed.info/sct/900000000000207008/version/20240101 | true",
    "http://snomed.info/sct/900000000000207008/version/202401   | http://snomed.info/sct/900000000000207008/version/20240101 | true",
    "http://snomed.info/sct/900000000000207008/version/202402   | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/2023     | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/2024010  | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/202      | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/20240101 | http://snomed.info/sct/900000000000207008                  | false",
    "http://snomed.info/sct/900000000000207008/version/20240101 | http://snomed.info/sct/32506021000036107/version/20240101  | false",
    "http://snomed.info/sct/32506021000036107/version/20240131  | http://snomed.info/sct/32506021000036107/version/20240131  | true",
    "http://snomed.info/sct/32506021000036107/version/202401    | http://snomed.info/sct/32506021000036107/version/20240131  | true",
    // not complete editions
    "http://snomed.info/sct/900000000000207008/version          | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/         | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/xversion/2024    | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/abc                                 | http://snomed.info/sct/abc/version/20240101                | false",
    "http://snomed.info/sct/                                    | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct                                     | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    // an edition and something that isn't one
    "20240101                                                   | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "900000000000207008                                         | http://snomed.info/sct/900000000000207008/version/20240101 | false",
    "http://snomed.info/sct/900000000000207008/version/20240101 | 20240101                                                   | false",
    "http://snomed.info/sct/900000000000207008                  | 900000000000207008                                         | false",
    "http://snomed.info/sct/900000000000207008                  | http://snomed.info/sct/900000000000207008-x                | false",
  })
  void snomedEditions(String criteria, String candidate, boolean matches) {
    check(criteria, candidate, matches);
  }
}
