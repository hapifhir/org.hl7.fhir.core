package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CanonicalVersionComparatorTests {
  private CanonicalVersionComparator comp = new CanonicalVersionComparator();

  
  /*
   *  General Tests
   */
  @Test
  void testNoVer() {
    testCompare(null, CanonicalVersionComparator.INTEGER, "10", CanonicalVersionComparator.INTEGER, 0, NullPointerException.class);
  }
  
  @Test
  void testBadAlg() {
    isError("1", "BAD", "10", "BAD");
  }
  
  @Test
  void testMissingUrl() {
    Questionnaire q1 = new Questionnaire();
    q1.setUrl(null);
    q1.setVersion("1.2.3");
    q1.setVersionAlgorithm(new Coding("http://example.org", "semver", null));

    Questionnaire q2 = new Questionnaire();
    q2.setUrl("http://example.org/Questionnaire/test");
    q2.setVersion("1.2.3");
    q2.setVersionAlgorithm(new Coding(CanonicalVersionComparator.URL_VERSION_ALG, "semver", null));
    
    Assertions.assertThrows(NullPointerException.class, () -> {
      comp.compare(q1, q2);
    });
  }

  @Test
  void testNonMatchUrl() {
    Questionnaire q1 = new Questionnaire();
    q1.setUrl("http://example.org/Questionnaire/testa");
    q1.setVersion("1.2.3");
    q1.setVersionAlgorithm(new Coding("http://example.org", "semver", null));

    Questionnaire q2 = new Questionnaire();
    q2.setUrl("http://example.org/Questionnaire/testb");
    q2.setVersion("1.2.3");
    q2.setVersionAlgorithm(new Coding(CanonicalVersionComparator.URL_VERSION_ALG, "semver", null));
    
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      comp.compare(q1, q2);
    });
  }

  @Test
  void testBadSystem() {
    Questionnaire q1 = new Questionnaire();
    q1.setUrl("http://example.org/Questionnaire/test");
    q1.setVersion("1.2.3");
    q1.setVersionAlgorithm(new Coding("http://example.org", "semver", null));

    Questionnaire q2 = new Questionnaire();
    q2.setUrl("http://example.org/Questionnaire/test");
    q2.setVersion("1.2.3");
    q2.setVersionAlgorithm(new Coding(CanonicalVersionComparator.URL_VERSION_ALG, "semver", null));
    
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      comp.compare(q1, q2);
    });
  }

  @Test
  void testNotCode() {
    Questionnaire q1 = new Questionnaire();
    q1.setUrl("http://example.org/Questionnaire/test");
    q1.setVersion("1.2.3");
    q1.setVersionAlgorithm(new StringType("foo"));

    Questionnaire q2 = new Questionnaire();
    q2.setUrl("http://example.org/Questionnaire/test");
    q2.setVersion("1.2.3");
    q1.setVersionAlgorithm(new StringType("foo"));
    
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      comp.compare(q1, q2);
    });
  }

  
  /*
   *  Int tests
   */
  @Test
  void testIntBoth() {
    isLess("2", CanonicalVersionComparator.INTEGER, "10", CanonicalVersionComparator.INTEGER);
  }
  
  @Test
  void testIntLeft() {
    isLess("2", CanonicalVersionComparator.INTEGER, "10", null);
  }

  @Test
  void testIntRight() {
    isLess("2", null, "10", CanonicalVersionComparator.INTEGER);
  }

  @Test
  void testIntInfer() {
    isLess("2", null, "10", null);
  }

  @Test
  void testIntInferBadDate() {
    isGreater("20121017", null, "20120231", null);
  }

  @Test
  void testIntInferBadUSDate() {
    isGreater("20121017", null, "12322012", null);
  }

  @Test
  void testIntSwitch() {
    isGreater("10", CanonicalVersionComparator.INTEGER, "2", CanonicalVersionComparator.INTEGER);
  }

  @Test
  void testIntEqual() {
    isEqual("10", CanonicalVersionComparator.INTEGER, "10", CanonicalVersionComparator.INTEGER);
  }

  @Test
  void testIntNotInt() {
    isError("A", CanonicalVersionComparator.INTEGER, "10", CanonicalVersionComparator.INTEGER);
  }

  @Test
  void testIntDiffAlg() {
    isError("A", CanonicalVersionComparator.ALPHA, "10", CanonicalVersionComparator.INTEGER);
  }

  @Test
  void testIntInfDiffAlg() {
    isGreater("A", null, "10", null);
  }

  
  /*
   *  Date tests
   */
  @Test
  void testDtBoth() {
    isLess("2025-01-01", CanonicalVersionComparator.DATE, "2025-01-02", CanonicalVersionComparator.DATE);
  }

  @Test
  void testDtLeft() {
    isEqual("2025.01.01", CanonicalVersionComparator.DATE, "2025/01/01", null);
  }
  @Test
  void testDtRight() {
    isGreater("20250102", null, "2025-01-01", CanonicalVersionComparator.DATE);
  }

  @Test
  void testDtInfer1() {
    isEqual("2025.01.01", null, "2025-01-01", null);
  }

  @Test
  void testDtInfer2() {
    isEqual("20250101", null, "2025/01/01", null);
  }

  @Test
  void testDtBad() {
    isError("2025-02-30", CanonicalVersionComparator.DATE, "2025-01-02", CanonicalVersionComparator.DATE);
  }

  @Test
  void testDtBadToInt() {
    isGreater("20250230", null, "20250102", null);
  }

  @Test
  void testUsdtBoth() {
    isLess("01-01-2025", CanonicalVersionComparator.USDATE, "01-02-2025", CanonicalVersionComparator.USDATE);
  }

  @Test
  void testUsdtLeft() {
    isEqual("01.01.2025", CanonicalVersionComparator.USDATE, "01/01/2025", null);
  }

  @Test
  void testUsdtRight() {
    isGreater("01022025", null, "01-01-2025", CanonicalVersionComparator.USDATE);
  }

  @Test
  void testUsdtInfer() {
    isGreater("01.02.2025", null, "01-01-2025", null);
  }

  @Test
  void testUsdtInfer2() {
    isGreater("01022025", null, "01/01/2025", null);
  }

  @Test
  void testUsdtBad() {
    isError("02-30-2025", CanonicalVersionComparator.DATE, "01-02-2025", CanonicalVersionComparator.DATE);
  }

  @Test
  void testUsdtBadToInt() {
    isGreater("02302025", null, "01022025", null);
  }
  
  @Test
  void testDateMix() {
    isError("01022025", CanonicalVersionComparator.USDATE, "20250101", CanonicalVersionComparator.DATE);
  }

  
  /*
   *  MajMin tests
   */
  @Test
  void testMajMin1() {
    isGreater("10.1", CanonicalVersionComparator.MAJMIN, "2.1", CanonicalVersionComparator.MAJMIN);
  }
  
  @Test
  void testMajMin2() {
    isGreater("0.11", CanonicalVersionComparator.MAJMIN, "0.4", CanonicalVersionComparator.MAJMIN);
  }
  
  @Test
  void testMajMinBad() {
    isError("0.1.2", CanonicalVersionComparator.MAJMIN, "0.1.3", CanonicalVersionComparator.MAJMIN);
  }
  
  @Test
  void testMajMinInfer() {
    isLess("0.1", null, "0.2", null);
  }

  
  /*
   *  Semver tests
   */
  @Test
  void testSemVer1() {
    isGreater("10.1.2-foo", CanonicalVersionComparator.SEMVER, "2.1.2+bar", CanonicalVersionComparator.SEMVER);
  }
  
  @Test
  void testSemVer2() {
    isGreater("0.11.2", CanonicalVersionComparator.SEMVER, "0.4.3", CanonicalVersionComparator.SEMVER);
  }
  
  @Test
  void testSemVer3() {
    isLess("0.1.2", CanonicalVersionComparator.SEMVER, "0.1.3", CanonicalVersionComparator.SEMVER);
  }
  
  @Test
  void testSemVer4() {
    isLess("0.1.2-bar", CanonicalVersionComparator.SEMVER, "0.1.2", CanonicalVersionComparator.SEMVER);
  }

  @Test
  void testSemVer5() {
    isGreater("0.1.2-bar", CanonicalVersionComparator.SEMVER, "0.1.2-bab", CanonicalVersionComparator.SEMVER);
  }

  @Test
  void testSemVer6() {
    isLess("0.1.2+bar", CanonicalVersionComparator.SEMVER, "0.1.2-bar", CanonicalVersionComparator.SEMVER);
  }

  @Test
  void testSemVerBad() {
    isError("A.1.2-bar", CanonicalVersionComparator.SEMVER, "0.1.2", null);
  }
  
  @Test
  void testSemVerInfer() {
    isLess("0.1.2-bar", null, "0.1.2", null);
  }

  
  /*
   *  Semver4 tests
   */
  @Test
  void testSemVer41() {
    isGreater("10.1.2.8", CanonicalVersionComparator.SEMVER4, "2.1.2.8", CanonicalVersionComparator.SEMVER4);
  }
  
  @Test
  void testSemVer42() {
    isGreater("0.11.2.8", CanonicalVersionComparator.SEMVER4, "0.4.3.8", CanonicalVersionComparator.SEMVER4);
  }
  
  @Test
  void testSemVer43() {
    isLess("0.1.2.8", CanonicalVersionComparator.SEMVER4, "0.1.3.8", CanonicalVersionComparator.SEMVER4);
  }
  
  @Test
  void testSemVer44() {
    isLess("0.1.2.7", CanonicalVersionComparator.SEMVER4, "0.1.2.8", CanonicalVersionComparator.SEMVER4);
  }

  @Test
  void testSemVe4Bad() {
    isError("A.1.2.8", CanonicalVersionComparator.SEMVER4, "0.1.2.8", null);
  }
  
  @Test
  void testSemVer4Infer() {
    isLess("0.1.2.8", null, "0.1.2.9", null);
  }

  @Test
  void testSemVerMixed() {
    isError("0.1.2", null, "0.1.2.9", null);
  }

  @Test
  void testNonSem() {
    isEqual("0.1.2.3.4", null, "0.1.2.3.4", null);
  }

  @Test
  void testNonMatch() {
    isError("0.1.2", null, "0.1.2.3", null);
  }

  @Test
  void testNonMatch2() {
    isError("0.1.2", CanonicalVersionComparator.SEMVER, "0.1.2.3", CanonicalVersionComparator.SEMVER);
  }

  
  /*
   *  SCT tests
   */
  @Test
  void SCT1() {
    isLess("http://snomed.info/sct/123/version/20250101", CanonicalVersionComparator.SCTURL, "http://snomed.info/sct/123/version/20250102", CanonicalVersionComparator.SCTURL);
  }
  
  @Test
  void SCTLeft() {
    isLess("http://snomed.info/sct/123/version/20250101", CanonicalVersionComparator.SCTURL, "http://snomed.info/sct/123/version/20250102", null);
  }
  
  @Test
  void SCTRight() {
    isLess("http://snomed.info/sct/123/version/20250101", null, "http://snomed.info/sct/123/version/20250102", CanonicalVersionComparator.SCTURL);
  }
  
  @Test
  void SCTInfer() {
    isLess("http://snomed.info/sct/123/version/20250101", null, "http://snomed.info/sct/123/version/20250102", null);
  }
  
  @Test
  void SCTEqual() {
    isEqual("http://snomed.info/sct/123/version/20250101", null, "http://snomed.info/sct/123/version/20250101", null);
  }
  
  @Test
  void SCTNoVer() {
    isError("http://snomed.info/sct/123", null, "http://snomed.info/sct/123/version/20250102", null);
  }
  
  @Test
  void SCTBad1() {
    isError("http://snomed.info/sct/123/version/BAD", CanonicalVersionComparator.SCTURL, "http://snomed.info/sct/123/version/20250102", null);
  }
  
  @Test
  void SCTBad2() {
    isError("http://snomed.info/sct/123/version/20250101", CanonicalVersionComparator.SCTURL, "http://snomed.info/sct/123/version/BAD", null);
  }
  
  @Test
  void SCTBad3() {
    isError("http://snomed.info/sct/123/version/20250230", CanonicalVersionComparator.SCTURL, "http://snomed.info/sct/123/version/20250102", null);
  }
  
  @Test
  void SCTBad4() {
    isError("http://snomed.info/sct/123/version/20250101", CanonicalVersionComparator.SCTURL, "http://snomed.info/sct/456/version/20250102", null);
  }
  
  
  /*
   *  Alpha tests
   */
  @Test
  void Alpha() {
    isLess("A", CanonicalVersionComparator.ALPHA, "B", CanonicalVersionComparator.ALPHA);
  }

  @Test
  void AlphaLeft() {
    isGreater("B", CanonicalVersionComparator.ALPHA, "A", null);
  }

  @Test
  void AlphaRight() {
    isEqual("A", null, "A", CanonicalVersionComparator.ALPHA);
  }

  @Test
  void AlphaInfer() {
    isLess("A", null, "B", null);
  }

  @Test
  void AlphaCase() {
    isEqual("Honeycomb", CanonicalVersionComparator.ALPHA, "HONEYCOMB", CanonicalVersionComparator.ALPHA);
  }
  
  @Test
  void AlphaAccent() {
    isEqual("Honeycomb", CanonicalVersionComparator.ALPHA, "Honéycomb", CanonicalVersionComparator.ALPHA);
  }
  
  @Test
  void AlphaShorter() {
    isLess("Honeycomb", CanonicalVersionComparator.ALPHA, "Honeycomb1", CanonicalVersionComparator.ALPHA);
  }
  
  @Test
  void AlphaLeadWS() {
    isEqual("Honeycomb", CanonicalVersionComparator.ALPHA, " Honeycomb", CanonicalVersionComparator.ALPHA);
  }
  
  @Test
  void AlphaTrailWS() {
    isEqual("Honeycomb", CanonicalVersionComparator.ALPHA, "Honeycomb ", CanonicalVersionComparator.ALPHA);
  }
  
  @Test
  void AlphaMidWS() {
    isEqual("Honeycomb", CanonicalVersionComparator.ALPHA, "Honey comb", CanonicalVersionComparator.ALPHA);
  }
  
  @Test
  void AlphaMixed() {
    isGreater("A2", CanonicalVersionComparator.ALPHA, "A10", CanonicalVersionComparator.ALPHA);
  }
  
  
  /*
   *  Natural tests
   */
  @Test
  void Natual() {
    isLess("A", CanonicalVersionComparator.NATURAL, "B", CanonicalVersionComparator.NATURAL);
  }

  @Test
  void NatualLeft() {
    isGreater("B", CanonicalVersionComparator.NATURAL, "A", null);
  }

  @Test
  void NatualRight() {
    isEqual("A", null, "A", CanonicalVersionComparator.NATURAL);
  }

  @Test
  void NatualInfer() {
    isLess("A", null, "B", null);
  }

  @Test
  void NatualCase() {
    isGreater("Honeycomb", CanonicalVersionComparator.NATURAL, "HONEYCOMB", CanonicalVersionComparator.NATURAL);
  }
  
  @Test
  void NatualAccent() {
    isLess("Honeycomb", CanonicalVersionComparator.NATURAL, "Honéycomb", CanonicalVersionComparator.NATURAL);
  }
  
  @Test
  void NatualShorter() {
    isLess("Honeycomb", CanonicalVersionComparator.NATURAL, "Honeycomb1", CanonicalVersionComparator.NATURAL);
  }
  
  @Test
  void NatualLeadWS() {
    isLess("Honeycomb", CanonicalVersionComparator.NATURAL, " Honeycomb", CanonicalVersionComparator.NATURAL);
  }
  
  @Test
  void NatualTrailWS() {
    isLess("Honeycomb", CanonicalVersionComparator.NATURAL, "Honeycomb ", CanonicalVersionComparator.NATURAL);
  }
  
  @Test
  void NatualMidWS() {
    isLess("Honeycomb", CanonicalVersionComparator.NATURAL, "Honey comb", CanonicalVersionComparator.NATURAL);
  }
  
  @Test
  void NatualMixed() {
    isLess("A2", CanonicalVersionComparator.NATURAL, "A10", CanonicalVersionComparator.NATURAL);
  }

  
  /*
   *  Helper methods with better names
   */
  private void isLess(String version1, String alg1, String version2, String alg2) {
    testCompare(version1, alg1, version2, alg2, -1, null);
  }
  
  private void isGreater(String version1, String alg1, String version2, String alg2) {
    testCompare(version1, alg1, version2, alg2, 1, null);
  }
  
  private void isEqual(String version1, String alg1, String version2, String alg2) {
    testCompare(version1, alg1, version2, alg2, 0, null);
  }
  
  private void isError(String version1, String alg1, String version2, String alg2) {
    testCompare(version1, alg1, version2, alg2, 0, IllegalArgumentException.class);
  }

  
  /*
   * Takes 2 version strings with their algorithms and the expected comparison value or 
   * expected error class
   */
  private void testCompare(String version1, String alg1, String version2, String alg2, int expected, Class except) {
    Questionnaire q1 = new Questionnaire();
    q1.setUrl("http://example.org/Questionnaire/test");
    q1.setVersion(version1);
    q1.setVersionAlgorithm(new Coding(CanonicalVersionComparator.URL_VERSION_ALG, alg1, null));

    Questionnaire q2 = new Questionnaire();
    q2.setUrl("http://example.org/Questionnaire/test");
    q2.setVersion(version2);
    q2.setVersionAlgorithm(new Coding(CanonicalVersionComparator.URL_VERSION_ALG, alg2, null));
    
    if (except != null) {
      Assertions.assertThrows(except, () -> {
        comp.compare(q1, q2);
      });
    } else {
      Assertions.assertEquals(expected, comp.compare(q1, q2));
    }
  }


}