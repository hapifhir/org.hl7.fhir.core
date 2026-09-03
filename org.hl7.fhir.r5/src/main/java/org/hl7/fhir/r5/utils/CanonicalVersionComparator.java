package org.hl7.fhir.r5.utils;

import java.text.Collator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.StringType;

public class CanonicalVersionComparator implements Comparator<CanonicalResource> {
  NaturalOrderComparator natComp = new NaturalOrderComparator();
  final Collator stringComp = Collator.getInstance();

  public static final String URL_VERSION_ALG = "http://hl7.org/fhir/version-algorithm";

  // Algorithm names
  public static final String ALPHA = "alpha"; 
  public static final String DATE = "date"; 
  public static final String INTEGER = "integer"; 
  public static final String MAJMIN = "major-minor"; 
  public static final String NATURAL = "natural"; 
  public static final String SCTURL = "sct-url"; 
  public static final String SEMVER4 = "semver4"; 
  public static final String SEMVER = "semver"; 
  public static final String USDATE = "us-date"; 
  
  public static final String PATTERN_SEMVER4 = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)$";
  public static final String PATTERN_SEMVER = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$";
  public static final String PATTERN_MAJMIN = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)$";
  public static final String PATTERN_SCT = "^http\\:\\/\\/snomed\\.info\\/sct\\/(\\d+)(\\/version\\/(\\d{8}))?$";

  public CanonicalVersionComparator() {
    // This strategy mean it'll ignore the accents and the case
    stringComp.setStrength(Collator.PRIMARY);  
  }
  
  @Override
  public int compare(CanonicalResource c1, CanonicalResource c2) {
    String code;
    
    if (!c1.hasUrl() || !c2.hasUrl())
      throw new NullPointerException("Unable to compare versions unless canonicals are present " + c1.getUrl() + "; " + c2.getUrl());
    
    if (!c1.hasUrl() || !c2.hasUrl() || !c1.getUrl().equals(c2.getUrl()))
      throw new IllegalArgumentException("Unable to compare versions unless canonicals the same " + c1.getUrl() + "; " + c2.getUrl());
    
    if (!c1.hasVersion() || !c2.hasVersion())
      throw new NullPointerException("Unable to compare versions for canonical " + c1.getUrl() + " when not all instances have versions.");
    
    String v1 = c1.getVersion();
    String v2 = c2.getVersion();
    checkAlg(c1.getVersionAlgorithm(), c1.getUrl());
    checkAlg(c2.getVersionAlgorithm(), c2.getUrl());
    String c1Alg = c1.hasVersionAlgorithm() ? ((Coding)c1.getVersionAlgorithm()).getCode(): null;
    String c2Alg = c2.hasVersionAlgorithm() ? ((Coding)c2.getVersionAlgorithm()).getCode(): null;

    if (c1Alg!=null || c2Alg!=null) {
      // At least one declared algorithm (we won't infer)
      if (c1Alg!=null && c2Alg!=null) {
        // Both have algorithms, see if they're the same
        if (c1Alg.equals(c2Alg)) 
          code = c1Alg;
        else
          throw new IllegalArgumentException("Two resources with the same canonical " + c1.getUrl() + " have different versionAlgorithms (version " + v1 + " and " + v2);
      } else {
        // Algorithm is whichever one is specified
        code = c1Alg!=null ? c1Alg : c2Alg;
      }
    } else {
      c1Alg = inferVersionAlgorithm(v1);
      c2Alg = inferVersionAlgorithm(v2);
      if (c1Alg.equals(c2Alg)) {
        // Inferred algorithms match, so that's what we use
        code = c1Alg;
      } else {
        // Because these are inferred, not declared, we could have inferred wrong, so we'll go with
        // the more generic of the two inferred algorithms between the versions
        if ((c1Alg.equals(DATE) || c1Alg.equals(USDATE)) && c2Alg.equals(INTEGER) && v1.matches("\\d+"))
          code = INTEGER;
        else if ((c2Alg.equals(DATE) || c2Alg.equals(USDATE)) && c1Alg.equals(INTEGER) && v2.matches("\\d+"))
          code = INTEGER;
        else if (c1Alg.equals(ALPHA) || c2Alg.equals(ALPHA))
          code = ALPHA;
        else
          throw new IllegalArgumentException("For canonical " + c1.getUrl() + ", there are different inferred version algorithms: " + v1 + " - " + c1Alg + "; " + v2 + " - " + c2Alg);
      }
    }

    switch (code) {
      case INTEGER:
        int int1 = Integer.parseInt(v1);
        int int2 = Integer.parseInt(v2);
        return Integer.compare(int1,  int2);
      
      case MAJMIN:
      case SEMVER:
      case SEMVER4:
        checkNodal(code, v1);
        checkNodal(code, v2);
        return nodalCompare(v1, v2);
      
      case ALPHA:
        return stringComp.compare(v1, v2);
      
      case DATE:
      case USDATE:
        String pattern1 = patternForDate(v1, code.equals(USDATE));
        String pattern2 = patternForDate(v2, code.equals(USDATE));
        try {
            LocalDate date1 = LocalDate.parse(v1, DateTimeFormatter.ofPattern(pattern1).withResolverStyle(ResolverStyle.STRICT));
            LocalDate date2 = LocalDate.parse(v2, DateTimeFormatter.ofPattern(pattern2).withResolverStyle(ResolverStyle.STRICT));
            return date1.compareTo(date2);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error parsing date versions for canonical " + c1.getUrl() + " - " + v1 + ";" + v2 + " - " + e.getMessage());
        }
        
      case SCTURL:
        Pattern snomedVer = Pattern.compile(PATTERN_SCT);
        Matcher m1 = snomedVer.matcher(v1);
        Matcher m2 = snomedVer.matcher(v2);
        if (!m1.find())
          throw new IllegalArgumentException("SNOMED version syntax is not legal for resource with canonical " + c1.getUrl() + " and version: " + v1);
        if (!m2.find())
          throw new IllegalArgumentException("SNOMED version syntax is not legal for resource with canonical " + c1.getUrl() + " and version: " + v2);
        if (!m1.group(1).equals(m2.group(1)))
          throw new IllegalArgumentException("Unable to compare SNOMED versions from different editions for canonical " + c1.getUrl() + ": " + v1 + "; " + v2);
        String ver1 = m1.group(3);
        String ver2 = m2.group(3);
        if (ver1 == null || ver2 == null)
          throw new IllegalArgumentException("SNOMED versions don't actually declare versions for canonical " + c1.getUrl() + ": " + v1 + "; " + v2);
        try {
          LocalDate date1 = LocalDate.parse(ver1, DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT));
          LocalDate date2 = LocalDate.parse(ver2, DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT));
          return date1.compareTo(date2);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("The 'version' part of an SCT URL must be yyyymmdd for canonical " + c1.getUrl() + " - " + v1 + ";" + v2 + " - " + e.getMessage());
        }

      case NATURAL:
        return natComp.compare(v1, v2);
            
      default:
        throw  new IllegalArgumentException("Unsupported comparison agorithm code " + code + " for canonical "+ c1.getUrl());
    }
  }

  /*
   * Determines the regex pattern for a version based on what separators are present and whether the date is standard or US form
   */
  private String patternForDate(String version, boolean isUsDate) {
    String pattern = "";
    if (isUsDate) {
      if (version.contains("/"))
        pattern = "MM/dd/uuuu";
      else if (version.contains("."))
        pattern = "MM.dd.uuuu";
      else if (version.contains("-"))
        pattern = "MM-dd-uuuu";
      else
        pattern = "MMdduuuu";
    } else {
      if (version.contains("/"))
        pattern = "uuuu/MM/dd";
      else if (version.contains("."))
        pattern = "uuuu.MM.dd";
      else if (version.contains("-"))
        pattern = "uuuu-MM-dd";
      else
        pattern = "uuuuMMdd";      
    }
    return pattern;
  }

  private void checkNodal(String code, String version) throws IllegalArgumentException {
    switch (code) {
      case MAJMIN:
        if (!version.matches(PATTERN_MAJMIN))
          throw new IllegalArgumentException("Version asserts algorithm of Major-minor, but doesn't match the required syntax: " + version);
        break;
      case SEMVER:
        if (!version.matches(PATTERN_SEMVER))
          throw new IllegalArgumentException("Version asserts algorithm of 'semver', but doesn't match the required syntax: " + version);
        break;
      case SEMVER4:
        if (!version.matches(PATTERN_SEMVER4))
          throw new IllegalArgumentException("Version asserts algorithm of 4-node semver, but doesn't match the required syntax: " + version);
        break;
    }
  }
  
  /*
   * Ensure if an algorithm is present that it's a coded algorithm from the standard code system - otherwise we don't know how to compare
   */
  private void checkAlg(DataType versionAlg, String url) {
    if (versionAlg instanceof StringType)
      throw new IllegalArgumentException("String version algorithms cannot be compared for canonical " + url + " - " + versionAlg);
    Coding codedAlg = (Coding)versionAlg;
    if (!codedAlg.hasSystem() || !codedAlg.getSystem().equals(URL_VERSION_ALG))
      throw new IllegalArgumentException("Version algorithms not from the " + URL_VERSION_ALG + " cannot be compared for canonical " + url + " - " + versionAlg);    
  }
  
  /*
   * Guesses the intended algorithm for a version based on the pattern it follows
   */
  public static String inferVersionAlgorithm(String version) {
    String algCode = "";
    if (version.matches(PATTERN_SCT)) {
      algCode = SCTURL;
    } else if (version.matches("^(19|20)\\d\\d\\-(1[0-2]|0[1-9])\\-(3[0-1]|[1-2][0-9]|0[1-9])$") ||
               version.matches("^(19|20)\\d\\d\\.(1[0-2]|0[1-9])\\.(3[0-1]|[1-2][0-9]|0[1-9])$") ||
               version.matches("^(19|20)\\d\\d\\/(1[0-2]|0[1-9])\\/(3[0-1]|[1-2][0-9]|0[1-9])$")) {
        algCode = DATE;
    } else if (version.matches("^(19|20)\\d\\d(1[0-2]|0[1-9])(3[0-1]|[1-2][0-9]|0[1-9])$")) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT);

      try {
          LocalDate date = LocalDate.parse(version, formatter);
          algCode = DATE;
      } catch (DateTimeParseException e) {
          algCode = INTEGER;
      }
    } else if (version.matches("^(1[0-2]|0[1-9])\\-(3[0-1]|[1-2][0-9]|0[1-9])\\-(19|20)\\d\\d$") ||
               version.matches("^(1[0-2]|0[1-9])\\.(3[0-1]|[1-2][0-9]|0[1-9])\\.(19|20)\\d\\d$") ||
               version.matches("^(1[0-2]|0[1-9])\\/(3[0-1]|[1-2][0-9]|0[1-9])\\/(19|20)\\d\\d$")) {
      algCode = USDATE;      
    } else if (version.matches("^(1[0-2]|0[1-9])(3[0-1]|[1-2][0-9]|0[1-9])(19|20)\\d\\d$")) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdduuuu").withResolverStyle(ResolverStyle.STRICT);

      try {
          LocalDate date = LocalDate.parse(version, formatter);
          algCode = USDATE;
      } catch (DateTimeParseException e) {
          algCode = INTEGER;
      }
    } else if (version.contains(".")) {
      if (version.matches(PATTERN_SEMVER4))
        algCode = SEMVER4;
      else if (version.matches(PATTERN_SEMVER))
        algCode = SEMVER;
      else if (version.matches(PATTERN_MAJMIN))
        algCode = MAJMIN;
      else
        algCode = ALPHA;
    } else if (version.matches("0|[1-9]\\d*"))
      algCode = INTEGER;
    else
      algCode = ALPHA;
    return algCode;
  }

  /*
   * Handles comparison of 2-node, 3-node, or 4-node dot-separated semver-type versions
   * The content in each node needs to be numeric, with the exception of the last which
   * can have a tail that is delimited either by '+' or '-' and is compared alphabetically.
   * nodes with a tail come before nodes without a tail.
   * 
   *  The comparison checks nodes in order.  If they differ, the result is the comparison
   *  of that set of nodes handled as integers.  If they're equal, the comparison moves to the 
   *  next set of nodes. 
   */
  public int nodalCompare(String v1, String v2) throws IllegalArgumentException {
    
    
    String [] parts1 = v1.split("\\.");
    String [] parts2 = v2.split("\\.");
    for (int i = 0; i < parts1.length; i++) {
      String comp1 = parts1[i];
      String comp2 = parts2[i];
      String tail1 = null;
      String tail2 = null;
      if (i==parts1.length - 1) {
        if (comp1.contains("+")) {
          tail1 = "+" + StringUtils.substringAfter(comp1, "+");
          comp1 = StringUtils.substringBefore(comp1, "+");
        } else if (comp1.contains("-")) {
          tail1 = "-" + StringUtils.substringAfter(comp1, "-");
          comp1 = StringUtils.substringBefore(comp1, "-");
        }
        if (comp2.contains("+")) {
          tail2 = "+" + StringUtils.substringAfter(comp2, "+");
          comp2 = StringUtils.substringBefore(comp2, "+");
        } else if (comp2.contains("-")) {
          tail2 = "-" + StringUtils.substringAfter(comp2, "-");
          comp2 = StringUtils.substringBefore(comp2, "-");
        }
      }
      if (!comp1.equals(comp2)) {
        int int1 = Integer.parseInt(comp1);
        int int2 = Integer.parseInt(comp2);
        return Integer.compare(int1, int2);
      }
      if (tail1 != null || tail2 != null) {
        if (tail1==null)
          return 1;
        else if (tail2==null)
          return -1;
        else
          return stringComp.compare(tail1, tail2);
      }
    }
    
    return 0;
  }    
}