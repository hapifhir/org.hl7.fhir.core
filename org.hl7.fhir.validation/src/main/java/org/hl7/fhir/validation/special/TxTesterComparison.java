package org.hl7.fhir.validation.special;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.model.JsonString;

/**
 * Makes the 'comparison' form of a failed test's actual response: the actual response with the
 * values that the expected response only matches by pattern put back as those patterns, so that
 * a diff of expected against comparison shows just the differences that matter.
 *
 * - a string the expected response gives as $external:N...$ becomes that token, and the server's
 *   actual wording is kept (see getMessages) to go into the comparison copy of the externals file
 * - any other pattern ($uuid$, $instant$, $id$, $choice:...$ etc.) is put back when the actual
 *   value matches it; a value that doesn't match stays as it is, so it shows in the diff
 *
 * This is presentation only, and best effort: it doesn't decide whether the test passes. Where
 * the actual response has a different shape from the expected one, it is left as it is.
 */
public class TxTesterComparison {

  private static final String EXTERNAL = "$external:";

  // the comparison that decides what lines up with what. It has no externals, so an $external$
  // matches any wording (or any that has the token's fragments) - the wording is the thing that
  // differs, and it mustn't stop the rest of an item lining up
  private final CompareUtilities lenient;
  private final Map<String, String> messages = new LinkedHashMap<>();

  public TxTesterComparison(Set<String> modes, Map<String, String> variables) {
    lenient = new CompareUtilities(modes, null, variables);
  }

  /**
   * The server's wording for each $external:N$ the expected response uses, by N.
   */
  public Map<String, String> getMessages() {
    return messages;
  }

  public JsonElement normalise(JsonElement expected, JsonElement actual) {
    if (expected == null || actual == null) {
      return actual == null ? null : actual.deepCopy();
    }
    if (expected.isJsonObject() && actual.isJsonObject()) {
      return normaliseObject(expected.asJsonObject(), actual.asJsonObject());
    } else if (expected.isJsonArray() && actual.isJsonArray()) {
      return normaliseArray(expected.asJsonArray(), actual.asJsonArray());
    } else if (expected.isJsonString() && actual.isJsonPrimitive()) {
      return normaliseString(expected.asJsonString().getValue(), actual);
    } else {
      return actual.deepCopy();
    }
  }

  private JsonObject normaliseObject(JsonObject expected, JsonObject actual) {
    JsonObject result = new JsonObject();
    for (JsonProperty p : actual.getProperties()) {
      JsonElement e = expected.get(p.getName());
      if (e != null && !lenient.isProhibitedItem(e)) {
        result.add(p.getName(), normalise(e, p.getValue()));
      } else {
        result.add(p.getName(), p.getValue().deepCopy());
      }
    }
    return result;
  }

  /**
   * Line the actual items up with the expected ones the way the comparison does: in order, with
   * expected items that are optional (or only for another version or mode) skipped when the
   * actual item isn't one of them. An actual item that matches nothing - which is the case being
   * looked at, since the test failed - is lined up with the remaining expected item it shares the
   * most plain values with (the same parameter name, extension url, code...), or else the next
   * one, so that its patterns still get put back where they can be.
   */
  private JsonArray normaliseArray(JsonArray expected, JsonArray actual) {
    List<JsonElement> items = new ArrayList<>();
    for (JsonElement e : expected) {
      if (!lenient.isProhibitedItem(e)) {
        items.add(e);
      }
    }
    JsonArray result = new JsonArray();
    int i = 0;
    for (JsonElement a : actual) {
      int found = -1;
      for (int j = i; j < items.size(); j++) {
        if (fits(items.get(j), a)) {
          found = j;
          break;
        } else if (!isOptional(items.get(j))) {
          break;
        }
      }
      if (found < 0) {
        found = closest(items, i, a);
      }
      if (found >= 0) {
        result.add(normalise(items.get(found), a));
        i = found + 1;
      } else if (i < items.size()) {
        result.add(normalise(items.get(i), a));
        i++;
      } else {
        result.add(a.deepCopy());
      }
    }
    return result;
  }

  /**
   * The remaining expected item (from start) that has the most plain values in common with the
   * actual one, or -1 if none has any.
   */
  private int closest(List<JsonElement> items, int start, JsonElement actual) {
    if (!actual.isJsonObject()) {
      return -1;
    }
    int best = -1;
    int bestScore = 0;
    for (int j = start; j < items.size(); j++) {
      int score = sharedValues(items.get(j), actual.asJsonObject());
      if (score > bestScore) {
        best = j;
        bestScore = score;
      }
    }
    return best;
  }

  private int sharedValues(JsonElement expected, JsonObject actual) {
    if (!expected.isJsonObject()) {
      return 0;
    }
    int score = 0;
    for (JsonProperty p : expected.asJsonObject().getProperties()) {
      JsonElement a = actual.get(p.getName());
      if (a != null && p.getValue().isJsonPrimitive() && a.isJsonPrimitive()) {
        String ev = p.getValue().asJsonPrimitive().getValue();
        if (ev != null && !ev.startsWith("$") && ev.equals(a.asJsonPrimitive().getValue())) {
          score++;
        }
      }
    }
    return score;
  }

  private JsonElement normaliseString(String expected, JsonElement actual) {
    String value = actual.isJsonString() ? actual.asJsonString().getValue() : actual.asJsonPrimitive().getValue();
    if (expected.startsWith(EXTERNAL) && expected.endsWith("$") && expected.length() > EXTERNAL.length() + 1) {
      String n = expected.substring(EXTERNAL.length(), expected.length() - 1);
      if (n.contains(":")) {
        n = n.substring(0, n.indexOf(":"));
      }
      if (!messages.containsKey(n)) {
        messages.put(n, value);
      }
      return new JsonString(expected);
    } else if (expected.length() > 1 && expected.startsWith("$") && expected.endsWith("$") && fits(new JsonString(expected), actual)) {
      return new JsonString(expected);
    } else {
      return actual.deepCopy();
    }
  }

  private boolean fits(JsonElement expected, JsonElement actual) {
    try {
      return lenient.compareJsonElements("comparison", "", expected, actual) == null;
    } catch (Exception e) {
      return false;
    }
  }

  private boolean isOptional(JsonElement e) {
    return e.isJsonObject() && (e.asJsonObject().has("$optional$") || e.asJsonObject().has("$only$"));
  }
}
