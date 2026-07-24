package org.hl7.fhir.r5.testfactory;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;

/**
 * Applies a sequence of {@code set} / {@code add} / {@code remove} operations to an
 * existing Element-model FHIR resource. Companion to {@link ProfileBasedFactory},
 * which synthesises a fresh resource from a profile; this class mutates one that
 * already exists. Both share the same path / parts vocabulary.
 *
 * <h3>Operations payload</h3>
 * Each entry is a JSON object:
 * <pre>
 *   { "op": "set",    "path": "AllergyIntolerance.recordedDate", "value": "2026-04-01" }
 *   { "op": "set",    "path": "AllergyIntolerance.code.coding",
 *                     "parts": [ {"name":"system","value":"..."}, {"name":"code","value":"..."} ] }
 *   { "op": "add",    "path": "AllergyIntolerance.note",
 *                     "parts": [ {"name":"text","value":"..."} ] }
 *   { "op": "remove", "path": "AllergyIntolerance.clinicalStatus" }
 * </pre>
 *
 * <h3>Path syntax</h3>
 * Dotted segments, optionally with {@code [i]} for an explicit index
 * (e.g. {@code AllergyIntolerance.code.coding[0].system}). The first segment may
 * be the resourceType ({@code AllergyIntolerance.code...}) or omitted
 * ({@code code....}). Polymorphic types ({@code value[x]}) must be spelled out
 * with the concrete element name (e.g. {@code Observation.valueQuantity}).
 *
 * <h3>Semantics</h3>
 * <ul>
 *   <li>{@code set}: navigate to (or create) the target element and write the value.
 *       For list elements without an explicit index, the FIRST entry is targeted.
 *       For an explicit {@code [i]}, the entry at that index must already exist.</li>
 *   <li>{@code add}: append a new entry at the (parent of the) target. Only valid
 *       for list elements. Explicit indexes are not permitted on add.</li>
 *   <li>{@code remove}: delete the matched element. With an explicit index, only
 *       that one entry is removed; otherwise all entries with that name are removed.</li>
 * </ul>
 *
 * Profile-aware constraint enforcement (slicing, value sets, cardinality) is the
 * responsibility of the caller; this class only mutates the element tree.
 */
@MarkedToMoveToAdjunctPackage
public class ProfileBasedManipulator {

  @SuppressWarnings("unused")
  private final FHIRPathEngine fpe;

  public ProfileBasedManipulator(FHIRPathEngine fpe) {
    this.fpe = fpe;
  }

  public Element apply(Element root, JsonArray operations) {
    if (operations == null || operations.size() == 0) return root;
    String resourceType = root.fhirType();
    for (JsonElement el : operations) {
      if (!el.isJsonObject()) {
        throw new FHIRException("manipulate: operation entries must be JSON objects");
      }
      applyOne(root, resourceType, el.asJsonObject());
    }
    return root;
  }

  private void applyOne(Element root, String resourceType, JsonObject op) {
    String kind = op.asString("op");
    String path = op.asString("path");
    if (kind == null || kind.isEmpty()) throw new FHIRException("manipulate: missing 'op'");
    if (path == null || path.isEmpty()) throw new FHIRException("manipulate: missing 'path'");
    List<PathSegment> segments = parsePath(path, resourceType);
    switch (kind.toLowerCase()) {
      case "set":
        applySet(root, segments, op);
        break;
      case "add":
        applyAdd(root, segments, op);
        break;
      case "remove":
      case "delete":
        applyRemove(root, segments);
        break;
      default:
        throw new FHIRException("manipulate: unknown op '" + kind + "' (expected set, add, remove)");
    }
  }

  // ------------------------------------------------------------------
  // Operations
  // ------------------------------------------------------------------

  private void applySet(Element root, List<PathSegment> segments, JsonObject op) {
    Element target = walkOrCreate(root, segments, false);
    writeValueOrParts(target, op);
  }

  private void applyAdd(Element root, List<PathSegment> segments, JsonObject op) {
    if (segments.isEmpty()) throw new FHIRException("manipulate add: empty path");
    PathSegment last = segments.get(segments.size() - 1);
    if (last.index >= 0) {
      throw new FHIRException("manipulate add: explicit [i] index is not permitted on 'add' targets");
    }
    Element parent = walkOrCreate(root, segments.subList(0, segments.size() - 1), true);
    Element appended;
    try {
      appended = parent.addElement(last.name);
    } catch (Error e) {
      // Element.addElement throws Error("... is not a list, so can't add an element")
      throw new FHIRException("manipulate add: " + e.getMessage());
    }
    writeValueOrParts(appended, op);
  }

  private void applyRemove(Element root, List<PathSegment> segments) {
    if (segments.isEmpty()) throw new FHIRException("manipulate remove: empty path");
    PathSegment last = segments.get(segments.size() - 1);
    Element parent = walkExisting(root, segments.subList(0, segments.size() - 1));
    if (parent == null) return;
    List<Element> matches = parent.getChildren(last.name);
    if (matches == null || matches.isEmpty()) return;
    if (last.index >= 0) {
      if (last.index < matches.size()) {
        parent.removeChild(matches.get(last.index));
      }
      return;
    }
    // Snapshot — removeChild may mutate the underlying list while we iterate.
    List<Element> snapshot = new ArrayList<>(matches);
    for (Element child : snapshot) {
      parent.removeChild(child);
    }
  }

  // ------------------------------------------------------------------
  // Value writers
  // ------------------------------------------------------------------

  private void writeValueOrParts(Element target, JsonObject op) {
    boolean hasValue = op.has("value") && op.get("value").isJsonString();
    boolean hasParts = op.has("parts") && op.get("parts").isJsonArray();
    if (hasValue && hasParts) {
      throw new FHIRException("manipulate: 'value' and 'parts' are mutually exclusive in one op");
    }
    if (hasValue) {
      String value = op.asString("value");
      if (!target.isPrimitive()) {
        throw new FHIRException("manipulate: cannot 'value' a non-primitive element ("
          + target.fhirType() + "); use 'parts' instead");
      }
      target.setValue(value);
      return;
    }
    if (hasParts) {
      JsonArray parts = op.getJsonArray("parts");
      for (JsonElement pel : parts) {
        if (!pel.isJsonObject()) throw new FHIRException("manipulate: 'parts' entries must be JSON objects");
        JsonObject p = pel.asJsonObject();
        String name = p.asString("name");
        if (name == null || name.isEmpty()) throw new FHIRException("manipulate: 'parts' entry missing 'name'");
        if (!p.has("value") || !p.get("value").isJsonString()) {
          throw new FHIRException("manipulate: 'parts' entry '" + name + "' missing string 'value'");
        }
        applyPart(target, name, p.asString("value"));
      }
      return;
    }
    // No value, no parts: the op is a no-op write (target was navigated/created).
  }

  /**
   * Apply a single {@code parts} entry to {@code target}. {@code dottedName}
   * may itself be dotted (e.g. {@code coding.system}); we navigate-or-create
   * along the chain and {@code setValue} on the leaf.
   */
  private void applyPart(Element target, String dottedName, String value) {
    String[] segs = dottedName.split("\\.");
    Element cursor = target;
    for (int i = 0; i < segs.length - 1; i++) {
      cursor = cursor.forceElement(segs[i]);
    }
    Element leaf = cursor.forceElement(segs[segs.length - 1]);
    if (leaf.isPrimitive()) {
      leaf.setValue(value);
    } else {
      throw new FHIRException("manipulate: 'parts' entry '" + dottedName
        + "' targets a non-primitive element (" + leaf.fhirType() + ")");
    }
  }

  // ------------------------------------------------------------------
  // Path walking
  // ------------------------------------------------------------------

  /**
   * Walk along {@code segments}, creating elements as needed. For list-typed
   * segments without an explicit index, the FIRST entry is followed; missing
   * entries are created via {@link Element#forceElement}. With an explicit
   * index, the entry must already exist (set with {@code [i]} cannot extend
   * a list — use {@code add} for that).
   *
   * @param permitExplicitIndex when false, an explicit {@code [i]} on the
   *   final-or-only segment is rejected (used by {@code add}, which forbids
   *   it on the LAST segment but tolerates it on intermediate ones).
   */
  private Element walkOrCreate(Element root, List<PathSegment> segments, boolean permitExplicitIndex) {
    Element cursor = root;
    for (PathSegment seg : segments) {
      if (seg.index >= 0) {
        if (!permitExplicitIndex) {
          // For 'set' with [i], allow only when the entry exists.
        }
        List<Element> children = cursor.getChildren(seg.name);
        if (children == null || seg.index >= children.size()) {
          throw new FHIRException("manipulate: index [" + seg.index + "] out of range for '"
            + seg.name + "' (size=" + (children == null ? 0 : children.size()) + ")");
        }
        cursor = children.get(seg.index);
      } else {
        cursor = cursor.forceElement(seg.name);
      }
    }
    return cursor;
  }

  /** Walk along {@code segments} without creating; returns null if any segment is absent. */
  private Element walkExisting(Element root, List<PathSegment> segments) {
    Element cursor = root;
    for (PathSegment seg : segments) {
      List<Element> children = cursor.getChildren(seg.name);
      if (children == null || children.isEmpty()) return null;
      int idx = seg.index >= 0 ? seg.index : 0;
      if (idx >= children.size()) return null;
      cursor = children.get(idx);
    }
    return cursor;
  }

  private List<PathSegment> parsePath(String path, String resourceType) {
    String[] raw = path.split("\\.");
    List<PathSegment> out = new ArrayList<>(raw.length);
    int start = 0;
    if (raw.length > 0 && raw[0].equals(resourceType)) start = 1;
    for (int i = start; i < raw.length; i++) {
      out.add(PathSegment.parse(raw[i]));
    }
    if (out.isEmpty()) {
      throw new FHIRException("manipulate: path has no element segments after the resource type: " + path);
    }
    return out;
  }

  private static final class PathSegment {
    final String name;
    final int index;
    PathSegment(String name, int index) {
      this.name = name;
      this.index = index;
    }
    static PathSegment parse(String raw) {
      int br = raw.indexOf('[');
      if (br < 0) return new PathSegment(raw, -1);
      int br2 = raw.indexOf(']', br);
      if (br2 <= br) throw new FHIRException("manipulate: malformed path segment '" + raw + "'");
      String name = raw.substring(0, br);
      String idx = raw.substring(br + 1, br2);
      try {
        return new PathSegment(name, Integer.parseInt(idx));
      } catch (NumberFormatException e) {
        throw new FHIRException("manipulate: non-numeric index in path segment '" + raw + "'");
      }
    }
  }
}
