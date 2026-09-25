package org.hl7.fhir.validation.instance;

import java.io.IOException;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * Turns the {@code $…$} markers a matchetype is written with into the extensions
 * {@link MatchetypeValidator} reads.
 * <p>
 * A matchetype is authored as ordinary JSON with a few extra properties:
 * <pre>
 *   { "$optional$": true, "name": "displayLanguage", … }   this array item need not be present
 *   { "$optional$": "!tx.fhir.org", … }                    … unless the comparison runs in that mode
 *   { "$only$": "version:4", … }                           present in that version only, absent otherwise
 *   { "$optional-properties$": ["display"], … }            these properties need not be present
 *   { "$count-arrays$": ["contains"], … }                  compare these arrays by count only
 * </pre>
 * The comparer works on the element model, where such properties do not exist: it looks for
 * extensions instead. Nothing converted between the two, so a matchetype written the documented
 * way had its optionality silently ignored - an absent optional item failed as an array count
 * difference, and an absent optional property as a missing element.
 * <p>
 * The conversion happens on the matchetype only, never on the resource being compared, and the
 * extensions it adds are in the {@code matchetype} namespace, which the comparer excludes from
 * the comparison itself.
 */
public class MatchetypeMarkers {

  private static final String PREFIX = "http://hl7.org/fhir/tools/StructureDefinition/";
  /** An array item that need not be present. Boolean, or a mode filter such as "tx.fhir.org". */
  public static final String EXT_OPTIONAL = PREFIX + "matchetype-optional";
  /**
   * An item that belongs to exactly one version or mode: required when its filter passes,
   * and not to be present at all when it does not.
   */
  public static final String EXT_ONLY = PREFIX + "matchetype-only";
  /**
   * Properties that need not be present, comma separated. A URL of its own rather than the one
   * above, because an object can be optional AND have optional properties, and the element model
   * returns the first extension with a given URL.
   */
  public static final String EXT_OPTIONAL_PROPERTIES = PREFIX + "matchetype-optional-properties";
  /** Arrays compared by count rather than item by item, comma separated. */
  public static final String EXT_COUNT_ARRAYS = PREFIX + "matchetype-count";

  private static final String MARKER_OPTIONAL = "$optional$";
  private static final String MARKER_ONLY = "$only$";
  private static final String MARKER_OPTIONAL_PROPERTIES = "$optional-properties$";
  private static final String MARKER_COUNT_ARRAYS = "$count-arrays$";
  private static final String COMMENTS = "fhir_comments";

  /**
   * Convert a matchetype's markers. Returns the JSON unchanged if it carries none, so a
   * matchetype authored with the extensions directly is unaffected.
   */
  public static byte[] toExtensions(byte[] json) throws IOException {
    try {
      JsonObject obj = JsonParser.parseObject(json);
      if (!convert(obj)) {
        return json;
      }
      return JsonParser.composeBytes(obj);
    } catch (JsonException e) {
      // Not JSON we can read: leave it to the parser to report properly.
      return json;
    }
  }

  /** @return true when anything was converted */
  private static boolean convert(JsonObject obj) {
    boolean changed = false;

    if (obj.has(MARKER_OPTIONAL)) {
      JsonElement value = obj.get(MARKER_OPTIONAL);
      obj.remove(MARKER_OPTIONAL);
      if (value.isJsonBoolean()) {
        addExtension(obj, EXT_OPTIONAL, "valueBoolean", value.asJsonBoolean().asBoolean());
      } else {
        addExtension(obj, EXT_OPTIONAL, "valueString", value.asString());
      }
      changed = true;
    }
    if (obj.has(MARKER_ONLY)) {
      String filter = obj.asString(MARKER_ONLY);
      obj.remove(MARKER_ONLY);
      addExtension(obj, EXT_ONLY, "valueString", filter);
      changed = true;
    }
    if (obj.has(MARKER_OPTIONAL_PROPERTIES)) {
      String names = join(obj.getJsonArray(MARKER_OPTIONAL_PROPERTIES));
      obj.remove(MARKER_OPTIONAL_PROPERTIES);
      addExtension(obj, EXT_OPTIONAL_PROPERTIES, "valueString", names);
      changed = true;
    }
    if (obj.has(MARKER_COUNT_ARRAYS)) {
      String names = join(obj.getJsonArray(MARKER_COUNT_ARRAYS));
      obj.remove(MARKER_COUNT_ARRAYS);
      addExtension(obj, EXT_COUNT_ARRAYS, "valueString", names);
      changed = true;
    }
    if (obj.has(COMMENTS)) {
      // the pre-R4 JSON comment convention, which the runner's comparer ignores as well
      obj.remove(COMMENTS);
      changed = true;
    }

    for (JsonProperty p : obj.getProperties()) {
      JsonElement value = p.getValue();
      if (value.isJsonObject()) {
        changed = convert(value.asJsonObject()) || changed;
      } else if (value.isJsonArray()) {
        for (JsonElement e : value.asJsonArray()) {
          if (e.isJsonObject()) {
            changed = convert(e.asJsonObject()) || changed;
          }
        }
      }
    }
    return changed;
  }

  private static String join(JsonArray arr) {
    return CommaSeparatedStringBuilder.join(",", arr.asStrings());
  }

  private static void addExtension(JsonObject obj, String url, String valueName, String value) {
    JsonObject ext = new JsonObject();
    ext.set("url", url);
    ext.set(valueName, value);
    obj.forceArray(0, "extension").add(ext);
  }

  private static void addExtension(JsonObject obj, String url, String valueName, boolean value) {
    JsonObject ext = new JsonObject();
    ext.set("url", url);
    ext.set(valueName, value);
    obj.forceArray(0, "extension").add(ext);
  }
}
