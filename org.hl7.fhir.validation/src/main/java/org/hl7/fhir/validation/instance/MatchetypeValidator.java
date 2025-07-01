package org.hl7.fhir.validation.instance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.instance.MatchetypeValidator.NamedElementSorter;

public class MatchetypeValidator {

  public class NamedElementSorter implements Comparator<Element> {

    private String name;
    private String expr;

    public NamedElementSorter(String name, String expr) {
      this.name = name;
      this.expr = expr;
    }

    @Override
    public int compare(Element e1, Element e2) {
      if (!name.equals(e1.getName()) || !name.equals(e2.getName())) {
        return e1.getIndex() - e2.getIndex();
      } else {
        String s1 = fpe.evaluateToString(e1, expr);
        String s2 = fpe.evaluateToString(e2, expr);
        return s1.compareTo(s2);
      }
    }
  }

  private static final String EXT_OPT_MODE = "http://hl7.org/fhir/tools/StructureDefinition/matchetype";
  private static final String EXT_OPT_PROP = "http://hl7.org/fhir/tools/StructureDefinition/matchetype-optional";
  private static final String EXT_OPT_COUNT = "http://hl7.org/fhir/tools/StructureDefinition/matchetype-count";
  private static final String EXT_OPT_SORT = "http://hl7.org/fhir/tools/StructureDefinition/matchetype-sort";

  private JsonObject externals;
  private Map<String, String> variables;
  private Set<String> modes;
  private boolean patternMode; 
  private FHIRPathEngine fpe;

  public MatchetypeValidator(FHIRPathEngine fpe) {
    super();
    this.fpe = fpe;
    this.variables = new HashMap<String, String>();
  }

  public MatchetypeValidator(FHIRPathEngine fpe, Set<String> modes) {
    super();
    this.fpe = fpe;
    this.modes = modes;
    this.variables = new HashMap<String, String>();
  }

  public MatchetypeValidator(FHIRPathEngine fpe, Set<String> modes, JsonObject externals) {
    super();
    this.fpe = fpe;
    this.modes = modes;
    this.externals = externals;
    this.variables = new HashMap<String, String>();
  }

  public MatchetypeValidator(FHIRPathEngine fpe, Set<String> modes, JsonObject externals, Map<String, String> variables) {
    super();
    this.fpe = fpe;
    this.externals = externals;
    this.variables = variables;
  }

  /**
   * in pattern mode, the comparison is only looking to find the expected properties. anything else is ignored
   * @return
   */
  public boolean isPatternMode() {
    return patternMode;
  }

  public MatchetypeValidator setPatternMode(boolean patternMode) {
    this.patternMode = patternMode;
    return this;
  }

  public boolean compare(List<ValidationMessage> messages, String path, Element expectedElement, Element actualElement) {
  
    String mode = expectedElement.getExtensionString(EXT_OPT_MODE);
    if (mode != null) {
      patternMode = "partial".equals(mode);
    }
      
    return compareElements(messages, path, expectedElement, actualElement);
  }
  private boolean compareElements(List<ValidationMessage> messages, String path, Element expectedElement, Element actualElement) {
    boolean ok = true;
    doSort(actualElement, expectedElement);
    List<String> optionals = listOptionals(expectedElement);
    List<String> countOnlys = listCountOnlys(expectedElement);
    for (Property en : actualElement.children()) {
      String n = en.getName();
      if (expectedElement.hasChildren(n)) {
        Property ep = expectedElement.getChildByName(n);
        if (!compareProperties(messages, path + '.' + n, elements(ep.getValues(), true), elements(en.getValues(), false), countOnlys.contains(n), n, actualElement)) {
          ok = false;
        }
      } else if (!patternMode) {
        msg(messages, path, actualElement, "properties differ at " + path + ": unexpected element " + n);
        ok = false;
      }
    }
    for (Property en : expectedElement.children()) {
      String n = en.getName();
      if (isAllMatchetypeExtensions(en)) {
        // nothing
      } else if (!isOptional(n, optionals)) {
        if (!actualElement.hasChildren(n) && !allOptional(elements(en.getValues(), true), null, null)) {
          msg(messages, path, actualElement, "properties differ at " + path + ": missing element " + n);
          ok = false;
        }
      }
    }
    return ok;
  }

  private void doSort(Element actualElement, Element expectedElement) {
    for (Element extension : expectedElement.getChildren("extension")) {
      String url = extension.getNamedChildValue("url");
      if (EXT_OPT_SORT.equals(url)) {
        String name = null;
        String expr = null;
        for (Element extension2 : extension.getChildren("extension")) {
          String url2 = extension2.getNamedChildValue("url");
          if ("element".equals(url2)) {
            name = extension2.getNamedChildValue("value");
          } else if ("expression".equals(url2)) {
            expr = extension2.getNamedChildValue("value");
          } else {
            // nothing
          }
        }
        if (name != null && expr != null) {
          actualElement.sortChildren(new NamedElementSorter(name, expr));
        }
      }
    }
  }

  private boolean isAllMatchetypeExtensions(Property en) {
    for (Element e : elements(en.getValues(), true)) {
      if (e.fhirType().equals("Extension")) {
        String url = e.getNamedChildValue("url");
        if (Utilities.noString(url) || !url.startsWith("http://hl7.org/fhir/tools/StructureDefinition/matchetype")) {
          return false;
        }
      } else {
        return false;
      }
    }
    return en.getValues().size() > 0;
  }

  private List<String> listOptionals(Element expectedElement) {
    List<String> res = new ArrayList<>();
    if (expectedElement.hasExtension(EXT_OPT_PROP)) {
      //      res.add("$optional-properties$");
      //      res.add("$count-arrays$");
      for (String s : expectedElement.getExtensionString(EXT_OPT_PROP).split("\\,")) {
        res.add(s);
      }
    }
    return res;
  }

  private List<String> listCountOnlys(Element expectedElement) {
    List<String> res = new ArrayList<>();
    if (expectedElement.hasExtension(EXT_OPT_COUNT)) {
      for (String s : expectedElement.getExtensionString(EXT_OPT_COUNT).split("\\,")) {
        res.add(s);
      }
    }
    return res;
  }

  private boolean compareProperties(List<ValidationMessage> messages, String path, List<Element> expectedElements, List<Element> actualElements, boolean countOnly, String name, Element parent) {
    boolean ok = true;
    int as = actualElements.size();
    int es = expectedElements.size();
    if (countOnly) {
      if (as != es) {
        notEqualMessage(messages, path, parent, "item count differs at " + path, Integer.toString(es), Integer.toString(as));
        ok = false;
      }
    } else if (as <=1 && es <= 1) {
      if (!comparePropertyValue(messages, path, expectedElements.size() == 1 ? expectedElements.get(0) : null, actualElements.size() == 1 ? actualElements.get(0) : null, false, name, parent)) {
        ok = false;
      }
    } else {
      // list mode

      int expectedMin = countExpectedMin(expectedElements, name, parent);
      int oc = optionalCount(expectedElements, name, parent);

      if (patternMode) {
        int c = 0;
        for (int i = 0; i < expectedElements.size(); i++) {
          CommaSeparatedStringBuilder cs = new CommaSeparatedStringBuilder("\r\n");
          boolean bok = false;
          while (!bok && c < actualElements.size()) {
            List<ValidationMessage> vm = new ArrayList<ValidationMessage>();
            bok = comparePropertyValue(vm, path + "[" + Integer.toString(i) + "]", expectedElements.get(i), actualElements.get(c), false, null, null);
            if (!bok) {
              cs.append("actual["+c+"] != expected["+i+"]: "+msgs(vm));
            }
            c++;              
          }
          if (!bok) {   
            ok = false;
            msg(messages, path, parent, "The expected item at "+path+" at index "+i+" was not found: "+cs.toString());
          }
        }
      } else {
        if (as > es || as < expectedMin) {
          ok = false;
          notEqualMessage(messages, path, parent, "array item count differs at " + path, Integer.toString(es), Integer.toString(as));
        }
        int c = 0;
        for (int i = 0; i < es; i++) {
          if (c >= as) {
            if (i >= es - oc && isOptional(expectedElements.get(i), name, parent)) {
              ; // this is OK 
            } else {
              ok = false;
              msg(messages, path, parent, "One or more array items did not match at "+path+" starting at index "+i);
            }
          } else {
            List<ValidationMessage> vm = new ArrayList<ValidationMessage>();
            boolean bok = comparePropertyValue(vm, path + "[" + Integer.toString(i) + "]", expectedElements.get(i), actualElements.get(c), false, null, null);
            if (bok) {
              // we matched, so check the next
              c++;
            } else if (isOptional(expectedElements.get(c), name, parent)) {              
              // we didn't match, but this is optional, so we'll move past it 
            } else {
              // didn't match, and isn't optional.
              messages.addAll(vm);
              ok = false;
              break; // no reason to look any further - errors will get weird
            }
          }
        }
        if (c < as) {
          msg(messages, path, parent, "Unexpected Node found in array at '"+path+"' at index "+c);
          ok = false;
        }
      }
    }
    return ok;
  }

  private String msgs(List<ValidationMessage> vmlist) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(";");
    for (ValidationMessage vm : vmlist) {
      b.append(vm.getMessage());
    }
    return b.toString();
  }

  private boolean comparePropertyValue(List<ValidationMessage> messages, String path, Element expected, Element actual, boolean optional, String name, Element parent) {
    if (!expected.fhirType().equals(actual.fhirType())) {
      notEqualMessage(messages, path, expected, "properties differ at " + path, expected.fhirType(), actual.fhirType());
      return false;
    }

    if (expected.isPrimitive() && actual.isPrimitive()) {
      String eValue = expected.primitiveValue();
      String aValue = actual.primitiveValue();
      if (!matches(aValue, eValue)) {
        if ("xhtml".equals(expected.fhirType())) {
          // ignore
        } else if ("base64Binary".equals(expected.fhirType())) {
          if (!sameBytes(Base64.decodeBase64(aValue), Base64.decodeBase64(eValue))) {
            notEqualMessage(messages, path, expected, actual.fhirType()+" property values differ at " + path, eValue, aValue);
            return false;
          }
        } else {
          notEqualMessage(messages, path, expected, actual.fhirType()+" property values differ at " + path, eValue, aValue);
          return false;
        }
      }
    }
    return compareElements(messages, path, expected, actual);
  }


  private boolean sameBytes(byte[] b1, byte[] b2) {
    if (b1.length == 0 || b2.length == 0)
      return false;
    if (b1.length != b2.length)
      return false;
    for (int i = 0; i < b1.length; i++)
      if (b1[i] != b2[i])
        return false;
    return true;
  }

  private int optionalCount(List<Element> arr, String name, Element parent) {
    int c = 0;
    for (Element e : arr) {
      if (isOptional(e, name, parent)) {
        c++;
      }
    }
    return c;
  }

  private boolean isOptional(Element e, String name, Element parent) {
    Element ex = (Element) e.getExtensionValue(EXT_OPT_PROP);
    if (ex != null && ("true".equals(ex.primitiveValue()) || passesOptionalFilter(ex.primitiveValue()))) {
      return true;
    }
    return false;
  }

  private boolean passesOptionalFilter(String token) {
    if (token.startsWith("!")) {
      return modes == null || !modes.contains(token.substring(1));
    } else {
      return modes != null && modes.contains(token);
    }
  }

  private int countExpectedMin(List<Element> elements, String name, Element parent) {
    int count = elements.size();
    for (Element e : elements) {
      if (isOptional(e, name, parent)) {
        count--;
      }
    }
    return count;
  }

  private boolean matches(String actualJsonString, String expectedJsonString) {
    if (expectedJsonString.startsWith("$") && expectedJsonString.endsWith("$")) {
      if (expectedJsonString.startsWith("$choice:")) {
        return Utilities.existsInList(actualJsonString, readChoices(expectedJsonString.substring(8, expectedJsonString.length()-1)));

      } else if (expectedJsonString.startsWith("$fragments:")) {
        List<String> fragments = readChoices(expectedJsonString.substring(11, expectedJsonString.length()-1));
        for (String f : fragments) {
          if (!actualJsonString.toLowerCase().contains(f.toLowerCase())) {
            return false;
          }
        }
        return true;
      } else if (expectedJsonString.startsWith("$external:")) {
        String[] cmd = expectedJsonString.substring(1, expectedJsonString.length() - 1).split("\\:");
        if (externals != null) {
          String s = externals.asString(cmd[1]);
          return actualJsonString.equals(s);
        } else if (cmd.length <= 2) {
          return true;
        } else {
          List<String> fragments = readChoices(cmd[2]);
          for (String f : fragments) {
            if (!actualJsonString.toLowerCase().contains(f.toLowerCase())) {
              return false;
            }
          }
          return true;
        }
      } else {
        switch (expectedJsonString) {
        case "$$" : return true;
        case "$instant$": return actualJsonString.matches("([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]{1,9})?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))");
        case "$date$": return actualJsonString.matches("([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])(T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]{1,9})?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00)))?");
        case "$uuid$": return actualJsonString.matches("urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
        case "$string$": return actualJsonString.equals(actualJsonString.trim());
        case "$id$": return actualJsonString.matches("[A-Za-z0-9\\-\\.]{1,64}");
        case "$url$": return actualJsonString.matches("(https?://|www\\.)[-a-zA-Z0-9+&@#/%?=~_|!:.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        case "$token$": return actualJsonString.matches("[0-9a-zA-Z_][0-9a-zA-Z_\\.\\-]*");
        case "$semver$": return actualJsonString.matches("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$");
        case "$version$": return matchesVariable(actualJsonString, "version");
        default: 
          throw new Error("Unhandled template: "+expectedJsonString);
        }
      }
    } else {
      return actualJsonString.equals(expectedJsonString);
    }
  }

  private boolean matchesVariable(String value, String name) {
    if (variables.containsKey(name)) {
      return value.equals(variables.get(name));
    } else {
      return true;
    }
  }

  private List<String> readChoices(String s) {
    List<String> list = new ArrayList<>();
    for (String p : s.split("\\|")) {
      list.add(p);
    }
    return list;
  }

  private boolean isOptional(String n, List<String> optionals) {
    return n.equals("$optional$") || optionals.contains("*")  || optionals.contains(n);
  }

  private boolean allOptional(List<Element> value, String name, Element parent) {
    for (Element e : value) {
      if (!isOptional(e, name, parent)) {
        return false;
      }
    }
    return true;
  }


  private List<Element> elements(List<Base> values, boolean expected) {
    List<Element> res = new ArrayList<>();
    for (Base b : values) {
      Element e = (Element) b;
      if (!expected || !matchetypeExtension(e)) {
        res.add(e);
      }      
    }
    return res;
  }

  private boolean matchetypeExtension(Element e) {
     if (e.fhirType().equals("Extension")) {
       String url = e.getNamedChildValue("url");
       if (!Utilities.noString(url) && url.startsWith("http://hl7.org/fhir/tools/StructureDefinition/matchetype")) {
         return true;
      }
    }
    return false;
  }

  private void msg(List<ValidationMessage> errors, String path, Element source, String message) {
    ValidationMessage validationMessage = new ValidationMessage(Source.MatchetypeValidator, IssueType.VALUE, source.line(), source.col(), path, message, IssueSeverity.ERROR);
    // validationMessage.setMessageId(id);
    // validationMessage.setRuleDate(ruleDate);
    errors.add(validationMessage);
  }



  public void notEqualMessage(List<ValidationMessage> errors, String path, Element source, final String message, final String expected, final String actual) {
    String msg = new StringBuilder()
          .append(message).append(": ")
          .append("expected ").append(presentExpected(expected)).append(" but found '").append(actual).append("'").toString();
    msg(errors, path, source, msg);
  }



  private String presentExpected(String expected) {
    if (expected == null) {
      return "null";
    } else if (expected.startsWith("$") && expected.endsWith("$")) {
      if (expected.startsWith("$choice:")) {
        return "Contains one of "+readChoices(expected.substring(8, expected.length()-1)).toString();
      } else if (expected.startsWith("$fragments:")) {
        List<String> fragments = readChoices(expected.substring(11, expected.length()-1));
        return "Contains all of "+fragments.toString();
      } else if (expected.startsWith("$external:")) {
        String[] cmd = expected.substring(1, expected.length() - 1).split(":");
        if (externals != null) {
          String s = externals.asString(cmd[1]);
          return "'"+s+"' (Ext)";
        } else {
          List<String> fragments = readChoices(cmd[2]);
          return "Contains all of "+fragments.toString()+" (because no external string provided for "+cmd[1]+")";
        }
      } else {
        switch (expected) {
        case "$$" : return "$$";
        case "$instant$": return "'An Instant'";
        case "$date$": return "'A date'";
        case "$uuid$": return "'A Uuid'";
        case "$string$": return "'A string'";
        case "$id$": return "'An Id'";
        case "$url$": return "'A URL'";
        case "$token$": return "'A Token'";
        case "$version$": return variables.containsKey("version") ? variables.get("version") : "(anything)";
        case "$semver$": return "A semver"; 
        default: return "Unhandled template: "+expected;
        }
      }
    } else {
      return "'"+expected+"'";
    }
  }
}
