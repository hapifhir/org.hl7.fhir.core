package org.hl7.fhir.utilities;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;

public class Utilities {

  static final String C_TEMP_DIR = "c:\\temp";

  /**
   * Returns the plural form of the word in the string.
   * <p>
   * Examples:
   *
   * <pre>
   *   inflector.pluralize(&quot;post&quot;)               #=&gt; &quot;posts&quot;
   *   inflector.pluralize(&quot;octopus&quot;)            #=&gt; &quot;octopi&quot;
   *   inflector.pluralize(&quot;sheep&quot;)              #=&gt; &quot;sheep&quot;
   *   inflector.pluralize(&quot;words&quot;)              #=&gt; &quot;words&quot;
   *   inflector.pluralize(&quot;the blue mailman&quot;)   #=&gt; &quot;the blue mailmen&quot;
   *   inflector.pluralize(&quot;CamelOctopus&quot;)       #=&gt; &quot;CamelOctopi&quot;
   * </pre>
   * <p>
   * <p>
   * <p>
   * Note that if the {@link Object#toString()} is called on the supplied object, so this method works for non-strings, too.
   *
   * @param word the word that is to be pluralized.
   * @return the pluralized form of the word, or the word itself if it could not be pluralized
   * @see Inflector#singularize(Object)
   */
  public static String pluralizeMe(String word) {
    Inflector inf = new Inflector();
    return inf.pluralize(word);
  }

  public static String pluralize(String word, int count) {
    if (count == 1)
      return word;
    Inflector inf = new Inflector();
    return inf.pluralize(word);
  }

  public static String singularise(String word) {
    Inflector inf = new Inflector();
    return inf.singularize(word);
  }

  
  public static boolean isInteger(String string) {
    if (isBlank(string)) {
      return false;
    }
    String value = string.startsWith("-") ? string.substring(1) : string;
    if (Utilities.noString(value)) {
      return false;
    }
    for (char next : value.toCharArray()) {
      if (!Character.isDigit(next)) {
        return false;
      }
    }
    // check bounds -2,147,483,648..2,147,483,647
    if (value.length() > 10)
      return false;
    if (string.startsWith("-")) {
      if (value.length() == 10 && string.compareTo("2147483648") > 0)
        return false;
    } else {
      if (value.length() == 10 && string.compareTo("2147483647") > 0)
        return false;
    }
    return true;
  }

  public static boolean isLong(String string) {
    if (isBlank(string)) {
      return false;
    }
    String value = string.startsWith("-") ? string.substring(1) : string;
    for (char next : value.toCharArray()) {
      if (!Character.isDigit(next)) {
        return false;
      }
    }
    // check bounds  -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807
    if (value.length() > 20)
      return false;
    if (string.startsWith("-")) {
      if (value.length() == 20 && string.compareTo("9223372036854775808") > 0)
        return false;
    } else {
      if (value.length() == 20 && string.compareTo("9223372036854775807") > 0)
        return false;
    }
    return true;
  }

  public static boolean isHex(String string) {
    try {
      int i = Integer.parseInt(string, 16);
      return i != i + 1;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isValidId(String id) {
    return id.matches("[A-Za-z0-9\\-\\.]{1,64}");
  }

  public static String[] concatStringArray(String[] array1, String[] array2) {
    String[] result = new String[array1.length + array2.length];
    System.arraycopy(array1, 0, result, 0, array1.length);
    System.arraycopy(array2, 0, result, array1.length, array2.length);
    return result;
  }

  private static final Set<String> EXCLUDED_FILES = Set.of(
    "arch-uml1.png", "arch-uml2.png", "arch-uml3.png", "change.png", "conformance-module-resources.png", "dt-map.png",
    "fhr.icns", "financial-module.png", "genomics-image10.png", "genomics-image16.png", "genomics-image19.png", "genomics-image24.png", "medication-definition-and-prescribing-resources.png", "pkb.png", "res-map.png", "sdmap.details",
    "terminology-module-relationships.png", "togaf.png", "workflow-relations.png", "xver-paths-1.0.json", "xver-paths-1.4.json", "xver-paths-3.0.json", "xver-paths-4.0.json", "xver-paths-5.0.json", "zachman.png",
    "13f2d978-cac6-493f-a3cf-16c32e3ad411.png", "951ae1e2-60d2-457e-9ce2-42e37f122808.gif", "action-and-activity-definition.png", "administration-module-interactions.png", "administration-module-person.png", "administration-module-prov-dir.png", "administration-module-research.png", "administration-module-scheduling.png", "basic-product-structure-simpler.png", "basic-product-structure-simplest.png",
    "basic-product-structure.png", "cands1.png", "cands2.png", "claim-3-tiers.png", "clinicalreasoning-cdshooks-approach.png", "clinicalreasoning-components-diagram.jpg", "clinicalreasoning-ig-types.png",
    "clinicalreasoning-knowledge-artifact-distribution.png", "clinicalreasoning-knowledge-artifact-types.png", "clinicalreasoning-measure-report-individual.png", "clinicalreasoning-measure-report-patient-list.png", "clinicalreasoning-measure-report-population.png", "clinicalreasoning-measure-structure.png", "'complex-pack-2(mix-and-device).png'", "'complex-pack-3(tablet-and-cream).png'",
    "consent-provisions-example.png", "consent-provisions.png", "diagnostic-module-resources.png", "examplescenario-example-laborder.png", "examplescenario-example.png", "framework-2.png", "genomics-image02.png", "genomics-image03.png", "genomics-image04.png",
    "genomics-image07.png", "genomics-image08.png", "genomics-image09.png", "genomics-image11.png", "genomics-image13.png", "genomics-image14.png", "genomics-image17.png", "genomics-image18.png", "genomics-image21.png", "genomics-image23.png",
    "genomics-image25.png", "genomics-image29.png", "genomics-image30.png", "genomics-image36.png", "genomics-image37.png", "icon-administration.png", "icon-clinical.png", "icon-documentation.png", "icon-fhir-720.png", "icon-implementation.png",
    "icon-infrastructure.png", "layout.png", "legal_state_machine_final.png", "manufactured-item-components.png", "manufactured-item-without-components.png", "packages-and-backbone.png", "packages-for-products-1.png", "parent-child-structure-1.png", "parent-child-structure-2.png",
    "parent-child-structure-3.png", "researchstudy-profile-proposal.png", "researchstudy-state-machine.png", "researchsubject-state-machine.png", "saif.png", "security-layout.png", "shot.png", "slicing.png", "spec.internals", "treestructure.png", "validation-oo.json",
    "watermark.png", "workflow-optionb.png", "workflow-optionc.png", "workflow-optionf.png", "workflow-optiong.png", "workflow-optionh-a.png", "workflow-optionh.png", "workflow-optioni.png", "workflow-optionl.png", "administration.jpg"
  );

  // work around bad practices in past binary handling
  public static boolean isProhibitedBinaryFile(String k) {
    return !EXCLUDED_FILES.contains(k);
  }

  public static String insertBreakingSpaces(String text, Set<Character> breakingChars) {
    if (text == null || text.isEmpty() || breakingChars == null || breakingChars.isEmpty()) {
      return text;
    }

    StringBuilder result = new StringBuilder();
    int charsSinceLastBreak = 0;

    for (int i = 0; i < text.length(); i++) {
      char currentChar = text.charAt(i);
      result.append(currentChar);
      charsSinceLastBreak++;

      // If we've gone 20+ chars and current char is a breaking char, insert zero-width space
      if (charsSinceLastBreak >= 20 && breakingChars.contains(currentChar)) {
        result.append('\u200B');
        charsSinceLastBreak = 0;
      }
    }

    return result.toString();
  }

  public enum DecimalStatus {
    BLANK, SYNTAX, RANGE, OK
  }

  public static boolean isDecimal(String value, boolean allowExponent, boolean allowLeadingZero) {
    DecimalStatus ds = checkDecimal(value, allowExponent, true);
    return ds == DecimalStatus.OK || ds == DecimalStatus.RANGE;
  }

  public static boolean isDecimal(String value, boolean allowExponent) {
    DecimalStatus ds = checkDecimal(value, allowExponent, false);
    return ds == DecimalStatus.OK || ds == DecimalStatus.RANGE;
  }

  public static DecimalStatus checkDecimal(String value, boolean allowExponent, boolean allowLeadingZero) {
    if (isBlank(value)) {
      return DecimalStatus.BLANK;
    }

    // check for leading zeros
    if (!allowLeadingZero) {
      if (value.startsWith("0") && !"0".equals(value) && !value.startsWith("0."))
        return DecimalStatus.SYNTAX;
      if (value.startsWith("-0") && !"-0".equals(value) && !value.startsWith("-0."))
        return DecimalStatus.SYNTAX;
      if (value.startsWith("+0") && !"+0".equals(value) && !value.startsWith("+0."))
        return DecimalStatus.SYNTAX;
    }

    // check for trailing dot
    if (value.endsWith(".")) {
      return DecimalStatus.SYNTAX;
    }

    boolean havePeriod = false;
    boolean haveExponent = false;
    boolean haveSign = false;
    boolean haveDigits = false;
    int preDecLength = 0;
    int postDecLength = 0;
    int exponentLength = 0;
    int length = 0;
    for (char next : value.toCharArray()) {
      if (next == '.') {
        if (!haveDigits || havePeriod || haveExponent)
          return DecimalStatus.SYNTAX;
        havePeriod = true;
        preDecLength = length;
        length = 0;
      } else if (next == '-' || next == '+') {
        if (haveDigits || haveSign)
          return DecimalStatus.SYNTAX;
        haveSign = true;
      } else if (next == 'e' || next == 'E') {
        if (!haveDigits || haveExponent || !allowExponent)
          return DecimalStatus.SYNTAX;
        haveExponent = true;
        haveSign = false;
        haveDigits = false;
        if (havePeriod)
          postDecLength = length;
        else
          preDecLength = length;
        length = 0;
      } else if (!Character.isDigit(next)) {
        return DecimalStatus.SYNTAX;
      } else {
        haveDigits = true;
        length++;
      }
    }
    if (haveExponent && !haveDigits)
      return DecimalStatus.SYNTAX;
    if (haveExponent)
      exponentLength = length;
    else if (havePeriod)
      postDecLength = length;
    else
      preDecLength = length;

    // now, bounds checking - these are arbitrary
    if (exponentLength > 4)
      return DecimalStatus.RANGE;
    if (preDecLength + postDecLength > 18)
      return DecimalStatus.RANGE;

    return DecimalStatus.OK;
  }

  public static String camelCase(String value) {
    return new Inflector().camelCase(value.trim().replace(" ", "_"), false);
  }

  public static String upperCamelCase(String value) {
    return new Inflector().upperCamelCase(value.trim().replace(" ", "_"));
  }

  public static String escapeXml(String doco) {
    if (doco == null)
      return "";

    StringBuilder b = new StringBuilder();
    for (char c : doco.toCharArray()) {
      if (c == '<')
        b.append("&lt;");
      else if (c == '>')
        b.append("&gt;");
      else if (c == '&')
        b.append("&amp;");
      else if (c == '"')
        b.append("&quot;");
      else
        b.append(c);
    }
    return b.toString();
  }

  public static String escapeXmlText(String doco) {
    if (doco == null)
      return "";

    StringBuilder b = new StringBuilder();
    for (char c : doco.toCharArray()) {
      if (c == '<')
        b.append("&lt;");
      else if (c == '>')
        b.append("&gt;");
      else if (c == '&')
        b.append("&amp;");
      else
        b.append(c);
    }
    return b.toString();
  }

  public static String titleize(String s) {
    StringBuilder b = new StringBuilder();
    boolean up = true;
    for (char c : s.toCharArray()) {
      if (up)
        b.append(Character.toUpperCase(c));
      else
        b.append(c);
      up = c == ' ';
    }
    return b.toString();
  }

  public static String capitalize(String s) {
    if (s == null) return null;
    if (s.length() == 0) return s;
    if (s.length() == 1) return s.toUpperCase();

    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }


  public static String asCSV(List<String> strings) {
    StringBuilder s = new StringBuilder();
    boolean first = true;
    for (String n : strings) {
      if (!first)
        s.append(",");
      s.append(n);
      first = false;
    }
    return s.toString();
  }

  public static String asHtmlBr(String prefix, List<String> strings) {
    StringBuilder s = new StringBuilder();
    boolean first = true;
    for (String n : strings) {
      if (!first)
        s.append("<br/>");
      s.append(prefix);
      s.append(n);
      first = false;
    }
    return s.toString();
  }

  public static String generateUniqueRandomUUIDPath(String path) throws IOException {
    String randomUUIDPath = null;

    while (randomUUIDPath == null) {
      final String uuid = UUID.randomUUID().toString().toLowerCase();
      final String pathCandidate = Utilities.path(path, uuid);

      if (!ManagedFileAccess.file(pathCandidate).exists()) {
        randomUUIDPath = pathCandidate;
      }
    }

    return randomUUIDPath;
  }

  public static String cleanupTextString(String contents) {
    if (contents == null || contents.trim().equals(""))
      return null;
    else
      return contents.trim();
  }

  public static boolean noString(String v) {
    return v == null || v.equals("");
  }

  public static String appendSlash(String definitions) {
    return definitions.endsWith(File.separator) ? definitions : definitions + File.separator;
  }

  public static String appendForwardSlash(String definitions) {
    if (definitions == null) {
      return "/";
    }
    return definitions.endsWith("/") ? definitions : definitions + "/";
  }

  public static String systemEol() {
    return System.getProperty("line.separator");
  }

  public static String normaliseEolns(String value) {
    return value.replace("\r\n", "\r").replace("\n", "\r").replace("\r", "\r\n");
  }

  public static String unescapeXml(String xml) throws FHIRException {
    if (xml == null)
      return null;

    StringBuilder b = new StringBuilder();
    int i = 0;
    while (i < xml.length()) {
      if (xml.charAt(i) == '&') {
        StringBuilder e = new StringBuilder();
        i++;
        while (xml.charAt(i) != ';') {
          e.append(xml.charAt(i));
          i++;
        }
        if (e.toString().equals("lt"))
          b.append("<");
        else if (e.toString().equals("gt"))
          b.append(">");
        else if (e.toString().equals("amp"))
          b.append("&");
        else if (e.toString().equals("quot"))
          b.append("\"");
        else if (e.toString().equals("mu"))
          b.append((char) 956);
        else
          throw new FHIRException("unknown XML entity \"" + e.toString() + "\"");
      } else
        b.append(xml.charAt(i));
      i++;
    }
    return b.toString();
  }


    
  public static String unescapeJson(String json) throws FHIRException {
    if (json == null)
      return null;

    StringBuilder b = new StringBuilder();
    int i = 0;
    while (i < json.length()) {
      if (json.charAt(i) == '\\') {
        i++;
        char ch = json.charAt(i);
        switch (ch) {
        case '"':
          b.append('b');
          break;
        case '\\':
          b.append('\\');
          break;
        case '/':
          b.append('/');
          break;
        case 'b':
          b.append('\b');
          break;
        case 'f':
          b.append('\f');
          break;
        case 'n':
          b.append('\n');
          break;
        case 'r':
          b.append('\r');
          break;
        case 't':
          b.append('\t');
          break;
        case 'u':
          String hex = json.substring(i + 1, i + 5);
          b.append(Character.toString(Integer.parseInt(hex, 16)));
          break;
        default:
          throw new FHIRException("Unknown JSON escape \\" + ch);
        }
      } else
        b.append(json.charAt(i));
      i++;
    }
    return b.toString();
  }


  public static boolean isPlural(String word) {
    word = word.toLowerCase();
    if ("restricts".equals(word) || "contains".equals(word) || "data".equals(word) || "specimen".equals(word) || "replaces".equals(word) || "addresses".equals(word)
        || "supplementalData".equals(word) || "instantiates".equals(word) || "imports".equals(word) || "covers".equals(word))
      return false;
    Inflector inf = new Inflector();
    return !inf.singularize(word).equals(word);
  }


  public static String padRight(String src, char c, int len) {
    StringBuilder s = new StringBuilder();
    if (src != null) {
      s.append(src);
      for (int i = 0; i < len - src.length(); i++)
        s.append(c);
    }
    return s.toString();
  }

  public static String padRight(int num, char c, int len) {
    return padRight(Integer.toString(num), c, len);
  }


  public static String padLeft(String src, char c, int len) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < len - src.length(); i++)
      s.append(c);
    s.append(src);
    return s.toString();
  }

  /**
   * Composes a path string using by concatenating the passed arguments.
   *
   * This method enables all checks for unintended path locations.
   *
   * @param args
   * @return
   * @throws IOException
   * @see PathBuilder#buildPath(String...)
   */
  public static String path(String... args) throws IOException {
    return PathBuilder.getPathBuilder().buildPath(args);
  }

  public static File pathFile(String... args) throws IOException {
    return ManagedFileAccess.file(PathBuilder.getPathBuilder().buildPath(args));
  }

  public static String path(File f, String... args) throws IOException {
    String[] a = new String[args.length+1];
    a[0] = f.getAbsolutePath();
    for (int i = 0; i < args.length; i++) {
      a[i+1] = args[i];
    }
    return PathBuilder.getPathBuilder().buildPath(a);
  }

  public static String forcePath(String... args) throws IOException {
    String path = path(args);
    String folder = FileUtilities.getDirectoryForFile(path);
    FileUtilities.createDirectory(folder);
    return path;
  }

  /**
     * Composes a path string using by concatenating the passed arguments.
     *
     * This method does not check for unintentional access to areas of the file
     * system outside of the first entry. ONLY USE THIS METHOD IN CASES WHERE YOU
     * ARE CERTAIN THE COMPOSED PATH IS NOT MALICIOUS.
     *
     * @param args
     * @return
     * @throws IOException
     *
     * @see PathBuilder#buildPath(String...)
     */
    @Deprecated
    public static String uncheckedPath(String... args) throws IOException {
      return PathBuilder.getPathBuilder()
          .withRequireNonRootFirstEntry(false)
          .withRequireNonNullNonEmptyFirstEntry(false)
          .withRequirePathIsChildOfTarget(false)
          .buildPath(args);
    }




  public static String pathURL(String... args) {
    StringBuilder s = new StringBuilder();
    boolean d = false;
    for (String arg : args) {
      if (arg != null) {
        if (!d)
          d = !noString(arg);
        else if (s.toString() != null && !s.toString().endsWith("/") && !arg.startsWith("/") && !arg.startsWith("?") && !arg.startsWith("&"))
          s.append("/");
        s.append(arg);
      }
    }
    return s.toString();
  }

  public static String nmtokenize(String cs) {
    if (cs == null)
      return "";
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < cs.length(); i++) {
      char c = cs.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '-' || c == '_')
        s.append(c);
      else if (c != ' ')
        s.append("." + Integer.toString(c));
    }
    return s.toString();
  }

  public static String javaTokenize(String cs, boolean capFirst) {
    if (cs == null)
      return "";
    StringBuilder s = new StringBuilder();
    boolean upcase = capFirst;
    for (int i = 0; i < cs.length(); i++) {
      char c = cs.charAt(i);
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_') {
        if (upcase) {
          s.append(Character.toUpperCase(c));
          upcase = false;
        } else {
          s.append(c);
        }
      } else {
        upcase = true;
      }
    }
    String res = s.toString();
    if (isJavaReservedWord(res)) {
      return "_"+res;
    } else { 
      return res;
    }
  }

  public static boolean isJavaReservedWord(String word) {
    if (word.equals("abstract")) return true;   
    if (word.equals("assert")) return true;
    if (word.equals("boolean")) return true;
    if (word.equals("break")) return true;  
    if (word.equals("byte")) return true;   
    if (word.equals("case")) return true;
    if (word.equals("catch")) return true;  
    if (word.equals("char")) return true;   
    if (word.equals("class")) return true;  
    if (word.equals("const")) return true;  
    if (word.equals("continue")) return true;   
    if (word.equals("default")) return true;
    if (word.equals("double")) return true;   
    if (word.equals("do")) return true;   
    if (word.equals("else")) return true;   
    if (word.equals("enum")) return true;   
    if (word.equals("extends")) return true;  
    if (word.equals("false")) return true;
    if (word.equals("final")) return true;  
    if (word.equals("finally")) return true;  
    if (word.equals("float")) return true;  
    if (word.equals("for")) return true;  
    if (word.equals("goto")) return true;   
    if (word.equals("if")) return true;
    if (word.equals("implements")) return true;   
    if (word.equals("import")) return true;   
    if (word.equals("instanceof")) return true;   
    if (word.equals("int")) return true;  
    if (word.equals("interface")) return true;  
    if (word.equals("long")) return true;
    if (word.equals("native")) return true;   
    if (word.equals("new")) return true;  
    if (word.equals("null")) return true;   
    if (word.equals("package")) return true;  
    if (word.equals("private")) return true;  
    if (word.equals("protected")) return true;
    if (word.equals("public")) return true;   
    if (word.equals("return")) return true;   
    if (word.equals("short")) return true;  
    if (word.equals("static")) return true;   
    if (word.equals("strictfp")) return true;   
    if (word.equals("super")) return true;
    if (word.equals("switch")) return true;   
    if (word.equals("synchronized")) return true;   
    if (word.equals("this")) return true;   
    if (word.equals("throw")) return true;  
    if (word.equals("throws")) return true;   
    if (word.equals("transient")) return true;
    if (word.equals("true")) return true;   
    if (word.equals("try")) return true;  
    if (word.equals("void")) return true;   
    if (word.equals("volatile")) return true;
    if (word.equals("while")) return true;
    if (word.equals("Exception")) return true;
    return false;
  }
  public static boolean isToken(String tail) {
    if (tail == null || tail.length() == 0)
      return false;
    boolean result = isAlphabetic(tail.charAt(0));
    for (int i = 1; i < tail.length(); i++) {
      result = result && (isAlphabetic(tail.charAt(i)) || isDigit(tail.charAt(i)) || (tail.charAt(i) == '_') || (tail.charAt(i) == '[') || (tail.charAt(i) == ']'));
    }
    return result;
  }

  public static boolean isTokenChar(char ch) {
    return isAlphabetic(ch) || (ch == '_'); 
  }

  public static boolean isDigit(char c) {
    return (c >= '0') && (c <= '9');
  }


  public static boolean isAlphabetic(char c) {
    return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
  }

  public static String appendPeriod(String s) {
    if (Utilities.noString(s))
      return s;
    s = s.trim();
    if (s.endsWith(".") || s.endsWith("?"))
      return s;
    return s + ".";
  }


  public static String removePeriod(String s) {
    if (Utilities.noString(s))
      return s;
    if (s.endsWith("."))
      return s.substring(0, s.length() - 1);
    return s;
  }


  public static String stripBOM(String string) {
    return string == null ? null : string.replace("\uFEFF", "");
  }


  public static String escapeJava(String doco) {
    if (doco == null)
      return "";

    StringBuilder b = new StringBuilder();
    for (char c : doco.toCharArray()) {
      if (c == '\r')
        b.append("\\r");
      else if (c == '\n')
        b.append("\\n");
      else if (c == '"')
        b.append("\\\"");
      else if (c == '\\')
        b.append("\\\\");
      else
        b.append(c);
    }
    return b.toString();
  }


  public static String[] splitByCamelCase(String name) {
    List<String> parts = new ArrayList<String>();
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < name.length(); i++) {
      if (i > 0 && Character.isUpperCase(name.charAt(i))) {
        parts.add(b.toString());
        b = new StringBuilder();
      }
      b.append(Character.toLowerCase(name.charAt(i)));
    }
    parts.add(b.toString());
    return parts.toArray(new String[]{});
  }

  @Deprecated
  public static String encodeUri(String string) {
    return encodeUriParam(string);
  }

  public static String encodeUriParam(String key, String value) {
    new BasicNameValuePair(key, value);
    return URLEncodedUtils.format(Collections.singletonList(new BasicNameValuePair(key, value)), StandardCharsets.UTF_8);
  }

  @Deprecated
  /* The following should not be used, as encodeUriParam automatically adds the key. The implementation below is a hack
  * that ensures both methods are using apache utils to do the encoding. */
  public static String encodeUriParam(String param) {
    String dummyEncode = encodeUriParam("dummy", param);
    return dummyEncode.substring("dummy=".length());
  }

  public static String normalize(String s) {
    return normalize(s, true);
  }
  public static String normalize(String s, boolean lower) {
    if (noString(s))
      return null;
    StringBuilder b = new StringBuilder();
    boolean isWhitespace = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!isWhitespace(c)) {
        b.append(lower ? Character.toLowerCase(c) : c);
        isWhitespace = false;
      } else if (!isWhitespace) {
        if (c == '\r' || c == '\n') {
          b.append('\n');
        } else {
          b.append(' ');
        }
        isWhitespace = true;
      }
    }
    return b.toString().trim();
  }

  public static String normalizeSameCase(String s) {
    if (noString(s))
      return null;
    StringBuilder b = new StringBuilder();
    boolean isWhitespace = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!Character.isWhitespace(c)) {
        b.append(c);
        isWhitespace = false;
      } else if (!isWhitespace) {
        b.append(' ');
        isWhitespace = true;
      }
    }
    return b.toString().trim();
  }

  public static String URLEncode(String string) {
    try {
      return URLEncoder.encode(string, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new Error(e.getMessage());
    }
  }


  public static String URLDecode(String ref) {
    try {
      return URLDecoder.decode(ref, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new Error(e.getMessage());
    }
  }

  public static boolean charInSet(char value, char... array) {
    for (int i : array)
      if (value == i)
        return true;
    return false;
  }


  public static boolean charInRange(char ch, char a, char z) {
    return ch >= a && ch <= z;
  }

  public static boolean existsInList(String value, List<String> array) {
    if (value == null)
      return false;
    for (String s : array)
      if (value.equals(s))
        return true;
    return false;
  }

  public static boolean containsInList(String value, String... array) {
    if (value == null)
      return false;
    for (String s : array)
      if (value.contains(s))
        return true;
    return false;
  }

  public static boolean existsInList(String value, String... array) {
    if (value == null)
      return false;
    for (String s : array)
      if (value.equals(s))
        return true;
    return false;
  }
  
  public static boolean existsInListTrimmed(String value, String... array) {
    if (value == null)
      return false;
    for (String s : array)
      if (value.equals(s.trim()))
        return true;
    return false;
  }

  public static boolean existsInList(int value, int... array) {
    for (int i : array)
      if (value == i)
        return true;
    return false;
  }

  public static boolean existsInListNC(String value, String... array) {
    for (String s : array)
      if (value.equalsIgnoreCase(s))
        return true;
    return false;
  }

  public static String stringJoin(String sep, String... array) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(sep);
    for (String s : array)
      if (!noString(s))
        b.append(s);
    return b.toString();
  }


  public static String getFileNameForName(String name) {
    return name.toLowerCase();
  }

  public static boolean isAsciiChar(char ch) {
    return ch >= ' ' && ch <= '~';
  }


  public static boolean isURL(String s) {
    boolean ok = s.matches("^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*");
    return ok;
  }


  public static String escapeCSV(String value) {
    if (value == null)
      return "";

    StringBuilder b = new StringBuilder();
    for (char c : value.toCharArray()) {
      if (c == '"')
        b.append("\"\"");
      else if (isWhitespace(c)) 
        b.append(" ");
      else
        b.append(c);
    }
    return b.toString();
  }


  public static String escapeJson(String value) {
    return escapeJson(value, true);
  }
  
  public static String escapeJson(String value, boolean escapeUnicodeWhitespace) {
    if (value == null)
      return "";

    StringBuilder b = new StringBuilder();
    for (char c : value.toCharArray()) {
      if (c == '\r')
        b.append("\\r");
      else if (c == '\n')
        b.append("\\n");
      else if (c == '\t')
        b.append("\\t");
      else if (c == '"')
        b.append("\\\"");
      else if (c == '\\')
        b.append("\\\\");
      else if (c == ' ')
        b.append(" ");
      else if ((c == '\r' || c == '\n') || (isWhitespace(c) && escapeUnicodeWhitespace)) { 
        b.append("\\u"+Utilities.padLeft(Integer.toHexString(c), '0', 4));
      } else if (((int) c) < 32)
        b.append("\\u" + Utilities.padLeft(Integer.toHexString(c), '0', 4));
      else
        b.append(c);
    }
    return b.toString();
  }

  public static String humanize(String code) {
    StringBuilder b = new StringBuilder();
    boolean lastBreak = true;
    for (char c : code.toCharArray()) {
      if (Character.isLetter(c)) {
        if (lastBreak)
          b.append(Character.toUpperCase(c));
        else {
          if (Character.isUpperCase(c))
            b.append(" ");
          b.append(c);
        }
        lastBreak = false;
      } else {
        b.append(" ");
        lastBreak = true;
      }
    }
    if (b.length() == 0)
      return code;
    else
      return b.toString();
  }


  public static String uncapitalize(String s) {
    if (s == null) return null;
    if (s.length() == 0) return s;
    if (s.length() == 1) return s.toLowerCase();

    return s.substring(0, 1).toLowerCase() + s.substring(1);
  }

  public static int charCount(String s, char c) {
    int res = 0;
    for (char ch : s.toCharArray())
      if (ch == c)
        res++;
    return res;
  }


  public static int startCharCount(String s, char c) {
    int res = 0;
    for (char ch : s.toCharArray()) {
      if (ch == c) {
        res++;
      } else {
        break;
      }
    } 
    return res;
  }

  
  public static boolean equals(String one, String two) {
    if (one == null && two == null)
      return true;
    if (one == null || two == null)
      return false;
    return one.equals(two);
  }


  public static boolean compareIgnoreWhitespace(File f1, File f2) throws IOException {
    InputStream in1 = null;
    InputStream in2 = null;
    try {
      in1 = new BufferedInputStream(ManagedFileAccess.inStream(f1));
      in2 = new BufferedInputStream(ManagedFileAccess.inStream(f2));

      int expectedByte = in1.read();
      while (expectedByte != -1) {
        boolean w1 = Character.isWhitespace(expectedByte);
        if (w1)
          while (Character.isWhitespace(expectedByte))
            expectedByte = in1.read();
        int foundByte = in2.read();
        if (w1) {
          if (!Character.isWhitespace(foundByte))
            return false;
          while (Character.isWhitespace(foundByte))
            foundByte = in2.read();
        }
        if (expectedByte != foundByte)
          return false;
        expectedByte = in1.read();
      }
      if (in2.read() != -1) {
        return false;
      }
      return true;
    } finally {
      if (in1 != null) {
        try {
          in1.close();
        } catch (IOException e) {
        }
      }
      if (in2 != null) {
        try {
          in2.close();
        } catch (IOException e) {
        }
      }
    }
  }


  public static boolean compareIgnoreWhitespace(String fn1, String fn2) throws IOException {
    return compareIgnoreWhitespace(ManagedFileAccess.file(fn1), ManagedFileAccess.file(fn2));
  }


  public static boolean isAbsoluteUrl(String ref) {
    if (ref != null && ref.contains(":")) {
      String scheme = ref.substring(0, ref.indexOf(":"));
      String details = ref.substring(ref.indexOf(":")+1);
      return (existsInList(scheme, "http", "https", "urn", "file:") || (isToken(scheme) && scheme.equals(scheme.toLowerCase())) || Utilities.startsWithInList(ref, "urn:iso:", "urn:iso-iec:", "urn:iso-cie:", "urn:iso-astm:", "urn:iso-ieee:", "urn:iec:"))
          && details != null && details.length() > 0 && !details.contains(" "); // rfc5141
    }
    return false; 
  }

  public static boolean isAbsoluteUrlLinkable(String ref) {
    if (ref != null && ref.contains(":")) {
      String scheme = ref.substring(0, ref.indexOf(":"));
      String details = ref.substring(ref.indexOf(":")+1);
      return (existsInList(scheme, "http", "https", "ftp"))
          && details != null && details.length() > 0 && !details.contains(" "); // rfc5141
    }
    return false; 
  }

  public static boolean equivalent(String l, String r) {
    if (Utilities.noString(l) && Utilities.noString(r))
      return true;
    if (Utilities.noString(l) || Utilities.noString(r))
      return false;
    return l.toLowerCase().equals(r.toLowerCase());
  }


  public static boolean equivalentNumber(String l, String r) {
    if (Utilities.noString(l) && Utilities.noString(r))
      return true;
    if (Utilities.noString(l) || Utilities.noString(r))
      return false;
    if (!Utilities.isDecimal(l, true) || !Utilities.isDecimal(r, true))
      return false;
    BigDecimal dl = new BigDecimal(l);
    BigDecimal dr = new BigDecimal(r);
    if (dl.scale() < dr.scale()) {
      dr = dr.setScale(dl.scale(), RoundingMode.HALF_UP);
    } else if (dl.scale() > dr.scale()) {
      dl = dl.setScale(dr.scale(), RoundingMode.HALF_UP);
    }
    return dl.equals(dr);
  }

  public static String getFileExtension(String fn) {
    return fn.contains(".") ? fn.substring(fn.lastIndexOf(".") + 1) : "";
  }

  public static String unCamelCaseKeepCapitals(String name) {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (char c : name.toCharArray()) {
      if (Character.isUpperCase(c)) {
        if (!first)
          b.append(" ");
        b.append(c);
      } else
        b.append(c);
      first = false;
    }
    return b.toString();
  }

  public static String unCamelCase(String name) {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (char c : name.toCharArray()) {
      if (Character.isUpperCase(c)) {
        if (!first)
          b.append(" ");
        b.append(Character.toLowerCase(c));
      } else
        b.append(c);
      first = false;
    }
    return b.toString();
  }


  public static boolean isAbsoluteFileName(String source) {
    if (isWindows())
      return (source.length() > 2 && source.charAt(1) == ':') || source.startsWith("\\\\");
    else
      return source.startsWith("//");
  }


  public static boolean isWindows() {
    return System.getProperty("os.name").startsWith("Windows");
  }


  public static String splitLineForLength(String line, int prefixLength, int indent, int allowedLength) {
    List<String> list = new ArrayList<String>();
    while (prefixLength + line.length() > allowedLength) {
      int i = allowedLength - (list.size() == 0 ? prefixLength : indent);
      while (i > 0 && line.charAt(i) != ' ')
        i--;
      if (i == 0)
        break;
      list.add(line.substring(0, i));
      line = line.substring(i + 1);
    }
    list.add(line);
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (String s : list) {
      if (first)
        first = false;
      else
        b.append("\r\n" + padLeft("", ' ', indent));
      b.append(s);
    }
    return b.toString();
  }

  public static String makeId(String name) {
    StringBuilder b = new StringBuilder();
    for (char ch : name.toCharArray()) {
      if (ch >= 'a' && ch <= 'z')
        b.append(ch);
      else if (ch >= 'A' && ch <= 'Z')
        b.append(ch);
      else if (ch >= '0' && ch <= '9')
        b.append(ch);
      else if (ch == '-' || ch == '.')
        b.append(ch);
    }
    return b.toString();
  }


  public static String extractBaseUrl(String url) {
    if (url == null)
      return null;
    else if (url.contains("/"))
      return url.substring(0, url.lastIndexOf("/"));
    else
      return url;
  }

  public static String listCanonicalUrls(Set<String> keys) {
    return keys.toString();
  }

  public static class CaseInsensitiveSorter implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareToIgnoreCase(o2);
    }
  }

  public static List<String> sortedCaseInsensitive(Collection<String> set) {
    List<String> list = new ArrayList<>();
    for (String s : set) {
      if (s != null) {
        list.add(s);
      }
    }
    Collections.sort(list, new CaseInsensitiveSorter());
    return list;
  }

  
  public static List<String> sorted(Collection<String> set) {
    List<String> list = new ArrayList<>();
    for (String s : set) {
      if (s != null) {
        list.add(s);
      }
    }
    Collections.sort(list);
    return list;
  }

  public static List<String> sortedReverse(Collection<String> set) {
    List<String> list = new ArrayList<>();
    for (String s : set) {
      if (s != null) {
        list.add(s);
      }
    }
    Collections.sort(list);
    List<String> rlist = new ArrayList<>();
    for (int i = list.size()-1; i >= 0; i--) {
      rlist.add(list.get(i));
    }
    return rlist;
  }

  public static List<String> sorted(String[] set) {
    List<String> list = new ArrayList<>();
    for (String s : set) {
      if (s != null) {
        list.add(s);
      }
    }
    Collections.sort(list);
    return list;
  }


  public static List<String> reverseSorted(Collection<String> set) {
    List<String> list = new ArrayList<>();
    for (String s : set) {
      if (s != null) {
        list.add(s);
      }
    }
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }

  public static List<String> reverseSorted(String[] set) {
    List<String> list = new ArrayList<>();
    for (String s : set) {
      if (s != null) {
        list.add(s);
      }
    }
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }


  public static void analyseStringDiffs(Set<String> source, Set<String> target, Set<String> missed, Set<String> extra) {
    for (String s : source)
      if (!target.contains(s))
        missed.add(s);
    for (String s : target)
      if (!source.contains(s))
        extra.add(s);

  }

  /**
   * Only handles simple FHIRPath expressions of the type produced by the validator
   *
   * @param path
   * @return
   */
  public static String fhirPathToXPath(String path) {
    String[] p = path.split("\\.");
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(".");
    int i = 0;
    while (i < p.length) {
      String s = p[i];
      if (s.contains("[")) {
        String si = s.substring(s.indexOf("[") + 1, s.length() - 1);
        if (!Utilities.isInteger(si))
          throw new FHIRException("The FHIRPath expression '" + path + "' is not valid");
        s = s.substring(0, s.indexOf("[")) + "[" + Integer.toString(Integer.parseInt(si) + 1) + "]";
      }
      if (i < p.length - 1 && p[i + 1].startsWith(".ofType(")) {
        i++;
        s = s + capitalize(p[i].substring(8, p.length - 1));
      }
      b.append(s);
      i++;
    }
    return b.toString();
  }

  public static String describeDuration(Duration d) {
    if (d.toDays() > 2) {
      return String.format("%s days", d.toDays());
    } else if (d.toHours() > 2) {
      return String.format("%s hours", d.toHours());
    } else if (d.toMinutes() > 2) {
      return String.format("%s mins", d.toMinutes());
    } else {
      return String.format("%s ms", d.toMillis());
    }
  }

  public static String describeDuration(long ms) {
    long days = ms / (1000 * 60 * 60 * 24);
    long hours = ms / (1000 * 60 * 60) % 24;
    long mins = ms / (1000 * 60) % 60;
    long secs = ms / (1000) % 60;
    ms = ms % 1000;
    if (days > 0) {
      return ""+days+"d "+pad(hours,2)+":"+pad(mins,2)+":"+pad(secs,2)+"."+ms;      
    } else {
      return ""+pad(hours, 2)+":"+pad(mins,2)+":"+pad(secs,2)+"."+ms;
    }
  }

  private static String pad(long v, int i) {
    return padLeft(Long.toString(v), '0', i);
  }

  public static boolean startsWithInList(String s, String... list) {
    if (s == null) {
      return false;
    }
    for (String l : list) {
      if (l != null) {
        if (s.startsWith(l)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean startsWithInList(String s, Collection<String> list) {
    if (s == null || list == null) {
      return false;
    }
    for (String l : list) {
      if (s.startsWith(l)) {
        return true;
      }
    }
    return false;
  }

  public static boolean endsWithInList(String s, String... list) {
    if (s == null) {
      return false;
    }
    for (String l : list) {
      if (s.endsWith(l)) {
        return true;
      }
    }
    return false;
  }

  public static boolean endsWithInList(String s, Collection<String> list) {
    if (s == null) {
      return false;
    }
    for (String l : list) {
      if (s.endsWith(l)) {
        return true;
      }
    }
    return false;
  }

  public static final int ONE_MB = 1024;
  public static final String GB = "Gb";
  public static final String MB = "Mb";
  public static final String KB = "Kb";
  public static final String BT = "b";

  public static String describeSize(int length) {
    if (length < 0) throw new IllegalArgumentException("File length of < 0  passed in...");

    if (length > Math.pow(ONE_MB, 3)) {
      return length / ((long) Math.pow(ONE_MB, 3)) + GB;
    }
    if (length > Math.pow(ONE_MB, 2)) {
      return length / ((long) Math.pow(ONE_MB, 2)) + MB;
    }
    if (length > ONE_MB) {
      return length / (ONE_MB) + KB;
    }
    return length + BT;
  }

  public static String describeSize(long length) {
    if (length < 0) throw new IllegalArgumentException("File length of < 0  passed in...");

    if (length > Math.pow(ONE_MB, 3)) {
      return length / ((long) Math.pow(ONE_MB, 3)) + GB;
    }
    if (length > Math.pow(ONE_MB, 2)) {
      return length / ((long) Math.pow(ONE_MB, 2)) + MB;
    }
    if (length > ONE_MB) {
      return length / (ONE_MB) + KB;
    }
    return length + BT;
  }

  public static List<byte[]> splitBytes(byte[] array, byte[] delimiter) {
    List<byte[]> byteArrays = new LinkedList<byte[]>();
    if (delimiter.length == 0)
    {
      return byteArrays;
    }
    int begin = 0;

    outer: for (int i = 0; i < array.length - delimiter.length + 1; i++)
    {
      for (int j = 0; j < delimiter.length; j++)
      {
        if (array[i + j] != delimiter[j])
        {
          continue outer;
        }
      }

      // If delimiter is at the beginning then there will not be any data.
      if (begin < i)
        byteArrays.add(Arrays.copyOfRange(array, begin, i));
      begin = i + delimiter.length;
    }

    // delimiter at the very end with no data following?
    if (begin != array.length)
      byteArrays.add(Arrays.copyOfRange(array, begin, array.length));

    return byteArrays;
  }

  final static int[] illegalChars = {34, 60, 62, 124, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 58, 42, 63, 92, 47};

  static {
    Arrays.sort(illegalChars);
  }

  public static int findinList(String[] list, String val) {
    for (int i = 0; i < list.length; i++) {
      if (val.equals(list[i])) {
        return i;
      }
    }
    return -1;
  }

  public static String toString(String[] expected) {
    return "['"+String.join("' | '", expected)+"']";
  }

  public static String lowBoundaryForDecimal(String value, int precision) {
    if (Utilities.noString(value)) {
      throw new FHIRException("Unable to calculate lowBoundary for a null decimal string");
    }
    String e = value.contains("e") ? value.substring(value.indexOf("e")+1) : null;
    if (value.contains("e")) {
      value = value.substring(0, value.indexOf("e"));
    }    
    if (isZero(value)) {
      return applyPrecision("-0.5000000000000000000000000", precision, true);
    } else if (value.startsWith("-")) {
      return "-"+highBoundaryForDecimal(value.substring(1), precision)+(e == null ? "" : e);
    } else {
      if (value.contains(".")) {
        return applyPrecision(minusOne(value)+"50000000000000000000000000000", precision, true)+(e == null ? "" : e);
      } else {
        return applyPrecision(minusOne(value)+".50000000000000000000000000000", precision, true)+(e == null ? "" : e);
      }
    }
  }

  private static String applyPrecision(String v, int p, boolean down) {
    String nv = v;
    int dp = -1;
    if (nv.contains(".")) {
      dp = nv.indexOf(".");
      nv = nv.substring(0, dp)+nv.substring(dp+1);
    }
    String s = null;
    int d = p - getDecimalPrecision(v);
    if (d == 0) {
      s = nv;
    } else if (d > 0) {
      s = nv + padLeft("", '0', d);
    } else {
      int l = v.length();
      int ld = l+d;
      if (dp > -1) {
        ld--;
      }
      if (nv.charAt(ld) >= '5' && !down) {
        s = nv.substring(0, ld-1)+((char) (nv.charAt(ld-1)+1));
      } else {
        s = nv.substring(0, ld);
      }
    }
    if (s.endsWith(".")) {
      s = s.substring(0, s.length()-1);
    }
    return dp == -1 || dp >= s.length() ? s : s.substring(0, dp)+"."+s.substring(dp);
  }

  private static String minusOne(String value) {
    StringBuffer s = new StringBuffer(value);
    for (int i = s.length()-1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        s.setCharAt(i, '9');
      } else if (s.charAt(i) != '.') {
        s.setCharAt(i, (char) (s.charAt(i)-1));
        break;
      }
    }
    return s.toString();
  }


  public static String highBoundaryForDecimal(String value, int precision) {
    if (Utilities.noString(value)) {
      throw new FHIRException("Unable to calculate highBoundary for a null decimal string");
    }
    String e = value.contains("e") ? value.substring(value.indexOf("e")+1) : null;
    if (value.contains("e")) {
      value = value.substring(0, value.indexOf("e"));
    }
    if (isZero(value)) {
      return applyPrecision("0.50000000000000000000000000000", precision, false);
    } else if (value.startsWith("-")) {
      return "-"+lowBoundaryForDecimal(value.substring(1), precision)+(e == null ? "" : e);
    } else {
      if (value.contains(".")) {
        return applyPrecision(value+"50000000000000000000000000000", precision, false)+(e == null ? "" : e);
      } else {
        return applyPrecision(value+".50000000000000000000000000000", precision, false)+(e == null ? "" : e);
      }
    }
  }

  private static boolean isZero(String value) {
    return value.replace(".", "").replace("-", "").replace("0", "").length() == 0;
  }

  public static Integer getDecimalPrecision(String value) {
    if (value.contains("e")) {
      value = value.substring(0, value.indexOf("e"));
    }
    if (value.contains(".")) {
      return value.split("\\.")[1].length();
    } else {
      return 0;
    }
  }


  public static String padInt(int i, int len) {
    return Utilities.padLeft(Integer.toString(i), ' ', len);
  }

  public static String padInt(long i, int len) {
    return Utilities.padLeft(Long.toString(i), ' ', len);
  }

  public static Object makeSingleLine(String text) {
    text = text.replace("\r", " ");
    text = text.replace("\n", " ");
    while (text.contains("  ")) {
      text = text.replace("  ", " ");
    }
    return text;
  }

  public static int parseInt(String value, int def) {
    if (isInteger(value)) {
      return Integer.parseInt(value);
    } else {
      return def;
    }
  }

  /**
   * Appends a text from a derived element to its base element.
   *
   * @param baseText The text set in the base element, or {@code null}.
   * @param derivedText The text set in the derived element, starting with "...".
   * @return The resulting text.
   */
  public static String appendDerivedTextToBase(@Nullable final String baseText,
      final String derivedText) {
    if (baseText == null) {
      return derivedText.substring(3);
    }
    return baseText + "\r\n" + derivedText.substring(3);
  }

  public static String getRelativeUrlPath(String root, String path) {
    String res = path.substring(root.length());
    if (res.startsWith("/")) {
      res = res.substring(1);
    }
    return res;
  }

  public static boolean isValidCRName(String name) {
    return name != null && name.matches("[A-Z]([A-Za-z0-9_]){1,254}");
  }

  public static boolean isAllWhitespace(String s) {
    if (Utilities.noString(s)) {
      return true;
    }
    for (char ch : s.toCharArray()) {
      if (!isWhitespace(ch)) {
        return false;
      }
    }
    return true;
  }

  public static String trimWS(String s) {
    if (Utilities.noString(s)) {
      return s;
    }
    int start = 0;
    while (start < s.length() && isWhitespace(s.charAt(start))) {
      start++;      
    }
    if (start == s.length()) {
      return "";
    }
    int end = s.length() - 1;
    while (end >= 0 && isWhitespace(s.charAt(end))) {
      end--;      
    }
    if (start > end) {
      return "";
    }
    return s.substring(start, end+1);    
  }

  // from https://en.wikipedia.org/wiki/Whitespace_character#Unicode  
  public static boolean isWhitespace(int ch) {
    return Utilities.existsInList(ch, '\u0009', '\n', '\u000B','\u000C','\r','\u0020','\u0085','\u00A0',
        '\u1680','\u2000','\u2001','\u2002','\u2003','\u2004','\u2005','\u2006','\u2007','\u2008','\u2009','\u200A',
        '\u2028', '\u2029', '\u202F', '\u205F', '\u3000');
  }

  public static boolean stringsEqual(String s1, String s2) {
    if  (s1 == null && s2 == null) {
      return true;
    } else if (s1 == null) {
      return false;
    } else {
      return s1.equals(s2);
    }
  }

  public static String tail(String url) {
    int i = url.length()-1;
    while (i >= 0 && (isTokenChar(url.charAt(i)) || isDigit(url.charAt(i))) ) {
      i--;
    }
    if (i < 0) {
      return url;
    } else {
      return url.substring(i+1);
    }
  }

  public static List<String> strings(String... members) {
    List<String> ret = new ArrayList<>();
    for (String m : members) {
      ret.add(m);
    }
    return ret;
  }

  public static Set<String> stringSet(String... members) {
    Set<String> ret = new HashSet<>();
    for (String m : members) {
      ret.add(m);
    }
    return ret;
  }

  public static List<String> splitStrings(String src, String regex) {
    List<String> ret = new ArrayList<>();
    for (String m : src.split(regex)) {
      ret.add(m);
    }
    return ret;
  }

  public static String stripPara(String p) {
    if (noString(p)) {
      return "";
    }
    p = p.trim();
    if (p.startsWith("<p>")) {
      p = p.substring(3);
    }
    if (p.endsWith("</p>")) {
      p = p.substring(0, p.length()-4);
    }
    return p;
  }

  public static String stripAllPara(String p) {
    if (noString(p)) {
      return "";
    }
    p = p.trim();
    if (p.startsWith("<p>")) {
      p = p.substring(3);
    }
    if (p.endsWith("</p>")) {
      p = p.substring(0, p.length()-4);
    }
    p = p.replace("</p>", " ");
    p = p.replace("<p>", "");
    while (p.contains("<p ")) {
      int start = p.indexOf("<p ");
      int end = start;
      while (end < p.length() && p.charAt(end) != '>') {
        end++;
      }
      p = p.substring(start, end);
    }
    return p;
  }



  //public static boolean !isWhitespace(String s) {
  //boolean ok = true;
  //for (int i = 0; i < s.length(); i++)
  //  ok = ok && Character.isWhitespace(s.charAt(i));
  //return ok;
  //
  //}


  public static boolean isTxFhirOrgServer(String s) {
    return Utilities.startsWithInList(s.replace("https://", "http://"), FhirSettings.getTxFhirProduction(), FhirSettings.getTxFhirDevelopment(), FhirSettings.getTxFhirLocal());
  }

  public static String[] splitLines(String txt) {
    return txt.split("\\r?\\n|\\r");
  }

  public static String rightTrim(String s) {
    int i = s.length()-1;
    while (i > 0 && Character.isWhitespace(s.charAt(i))) {
      i--;
    }
    return i == 0 ? "" : s.substring(0, i+1);
  }

  public static String urlTail(String url) {
    if (url == null) {
      return null;
    }
    return url.contains("/") ? url.substring(url.lastIndexOf("/")+1) : url;
  }

  public static String escapeSql(String s) {
    return s.replace("'", "''");
  }

  public static String[] simpleSplit(String cnt, String div) {
    if (cnt == null) {
      return new String[] {};
    }
    List<String> parts = new ArrayList<>();
    int cursor = 0;
    int last = 0;
    while (cursor < cnt.length()) {
      if (matches(cnt, div, cursor)) {
        parts.add(cnt.substring(last, cursor));
        cursor = cursor + div.length();
        last = cursor;
      } else {
        cursor++;
      }
    }
    parts.add(cnt.substring(last, cursor));
    return parts.toArray(new String[] {});
  }

  private static boolean matches(String cnt, String div, int cursor) {
    if (div.length() + cursor > cnt.length()) {
      return false;
    }
    for (int i = 0; i < div.length(); i++) {
      if (cnt.charAt(cursor+i) != div.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public static String stripEoln(String text) {
    if (text == null) {
      return "";
    }
    return text.replace("\r\n",  " ").replace("\n",  " ").replace("\r",  " ");
  }

  public static String extractDomain(String source) {
    try {
      URI uri = URI.create(source);
      return uri.getHost();
    } catch (Exception e) {
      return "??";
    }
  }

  public static boolean isValidHtmlAnchorChar(char c) {
    if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
      return true;
    } 
    switch (c) {
    case '!':
    case '$':
    case '&':
    case '\'':
    case '(':
    case ')':
    case '*':
    case '+':
    case ',':
    case ';':
    case '=':
    case '.':
    case '_':
    case '-':
    case '~':
    case ':':
    case '@':
    case '/':
    case '?':
      return true;
    default:
      return false;
    }
  }

  public static boolean listValueStartsWith(String s, Set<String> list) {
    if (s == null || list == null) {
      return false;
    }
    for (String l : list) {
      if (l.startsWith(s)) {
        return true;
      }
    }
    return false;
  }

  public static String extractByRegex(String input, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      result.append(matcher.group(1)); 
    }
    return result.length() == 0 ? null : result.toString(); 
  }

  public static String getDirectoryForURL(String url) {
    return url.contains("/") && url.lastIndexOf("/") > 10 ? url.substring(0, url.lastIndexOf("/")) : url;
  }

  public static List<String> copyAdd(List<String> oldList, String newItem) {
    List<String> newList = new ArrayList<>(oldList);
    newList.add(newItem);
    return newList;
  }

  public static String limitString(String text, int length) {
    text = text.trim();
    if (text.length() > length) {
      return text.substring(0, length-1)+"...";
    } else {
      return text;
    }
  }


  
}
