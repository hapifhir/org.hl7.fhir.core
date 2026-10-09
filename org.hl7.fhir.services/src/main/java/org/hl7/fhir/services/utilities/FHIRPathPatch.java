package org.hl7.fhir.services.utilities;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.ObjectConverter;
import org.hl7.fhir.services.elementmodel.Property;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Parameters.ParametersParameterComponent;
import org.hl7.fhir.utilities.Utilities;

/**
 * Applies a <a href="http://hl7.org/fhir/fhirpatch.html">FHIRPath Patch</a> to a resource held
 * in the element model.
 * <p>
 * The patch is the standard {@code Parameters} document a FHIR server accepts on {@code PATCH}:
 * one {@code operation} parameter per change, each with a {@code type} part (one of
 * {@code add}, {@code insert}, {@code delete}, {@code replace}, {@code move}), a {@code path}
 * part holding a FHIRPath expression, and the further parts that operation needs:
 * <ul>
 *   <li>{@code add}: {@code path} selects the element that gets a new child; {@code name} is the
 *       child's element name; {@code value} is its value.</li>
 *   <li>{@code insert}: {@code path} names a repeating element (for example {@code Patient.name});
 *       {@code index} is the 0-based position the new entry takes; {@code value} is its value.</li>
 *   <li>{@code delete}: {@code path} selects at most one element, which is removed. Selecting
 *       nothing is a no-op.</li>
 *   <li>{@code replace}: {@code path} selects exactly one element; {@code value} replaces its
 *       content.</li>
 *   <li>{@code move}: {@code path} names a repeating element; the entry at {@code source} is moved
 *       to {@code destination}.</li>
 * </ul>
 * A {@code value} part carries either a typed {@code value[x]} (a primitive or a complex data
 * type) or, for a complex value built inline, nested {@code part}s named after the child
 * elements, themselves carrying a value or further parts.
 * <p>
 * Operations are applied in order. The first one that fails throws a {@link FHIRException}
 * describing the operation and the reason; the resource is then partly patched, so callers
 * that need atomicity should work on a copy.
 */
public class FHIRPathPatch {

  private final FHIRPathEngine fpe;
  private final ObjectConverter converter;

  public FHIRPathPatch(IWorkerContext context) {
    this.fpe = new FHIRPathEngine(context);
    this.converter = new ObjectConverter(context);
  }

  /**
   * Apply {@code patch} to {@code resource} in place, and return {@code resource}.
   */
  public Element apply(Element resource, Parameters patch) throws FHIRException {
    for (ParametersParameterComponent op : patch.getParameterList()) {
      if (!"operation".equals(op.getName())) {
        throw new FHIRException("FHIRPath Patch: expected a parameter named 'operation' but found '" + op.getName() + "'");
      }
      String type = requiredPart(op, "type");
      String path = requiredPart(op, "path");
      switch (type) {
      case "add":
        add(resource, path, requiredPart(op, "name"), part(op, "value"));
        break;
      case "insert":
        insert(resource, path, requiredInt(op, "index"), part(op, "value"));
        break;
      case "delete":
        delete(resource, path);
        break;
      case "replace":
        replace(resource, path, part(op, "value"));
        break;
      case "move":
        move(resource, path, requiredInt(op, "source"), requiredInt(op, "destination"));
        break;
      default:
        throw new FHIRException("FHIRPath Patch: unknown operation type '" + type + "' (expected add, insert, delete, replace or move)");
      }
    }
    return resource;
  }

  // -- the five operations --------------------------------------------------------------------

  private void add(Element root, String path, String name, ParametersParameterComponent value) {
    Element parent = single(root, path, "add");
    Property p = childProperty(parent, name);
    if (p == null) {
      throw new FHIRException("FHIRPath Patch: add at " + path + ": " + parent.fhirType() + " has no element named '" + name + "'");
    }
    if (!p.isList() && parent.hasChild(name)) {
      throw new FHIRException("FHIRPath Patch: add at " + path + ": '" + name + "' is already present and is not a list; use replace");
    }
    Element child = parent.addElement(name);
    fill(child, value, "add");
    parent.numberChildren();
  }

  private void insert(Element root, String path, int index, ParametersParameterComponent value) {
    ListTarget target = listTarget(root, path, "insert");
    List<Element> entries = new ArrayList<>(target.parent.getChildList().getByName(target.name));
    if (index < 0 || index > entries.size()) {
      throw new FHIRException("FHIRPath Patch: insert at " + path + ": index " + index + " is out of range (the list has " + entries.size() + " entries)");
    }
    if (!target.property.isList() && !entries.isEmpty()) {
      throw new FHIRException("FHIRPath Patch: insert at " + path + ": '" + target.name + "' is not a list and is already present; use replace");
    }
    // addElement places the new entry after the existing ones, in definition order; move it
    // earlier when the index asks for that.
    Element created = target.parent.addElement(target.name);
    if (index < entries.size()) {
      target.parent.removeChild(created);
      target.parent.getChildList().add(positionOf(target.parent, entries.get(index)), created);
    }
    fill(created, value, "insert");
    target.parent.numberChildren();
  }

  private void delete(Element root, String path) {
    List<Element> matches = evaluate(root, path);
    if (matches.isEmpty()) {
      return;
    }
    if (matches.size() > 1) {
      throw new FHIRException("FHIRPath Patch: delete at " + path + ": selects " + matches.size() + " elements; delete requires at most one");
    }
    Element target = matches.get(0);
    if (target == root) {
      throw new FHIRException("FHIRPath Patch: delete at " + path + ": cannot delete the resource itself");
    }
    Element parent = findParent(root, target);
    parent.removeChild(target);
    parent.numberChildren();
  }

  private void replace(Element root, String path, ParametersParameterComponent value) {
    Element target = single(root, path, "replace");
    if (target == root) {
      throw new FHIRException("FHIRPath Patch: replace at " + path + ": cannot replace the resource itself");
    }
    target.getChildList().clear();
    target.setValue(null);
    fill(target, value, "replace");
  }

  private void move(Element root, String path, int source, int destination) {
    ListTarget target = listTarget(root, path, "move");
    List<Element> entries = new ArrayList<>(target.parent.getChildList().getByName(target.name));
    if (source < 0 || source >= entries.size()) {
      throw new FHIRException("FHIRPath Patch: move at " + path + ": source " + source + " is out of range (the list has " + entries.size() + " entries)");
    }
    if (destination < 0 || destination >= entries.size()) {
      throw new FHIRException("FHIRPath Patch: move at " + path + ": destination " + destination + " is out of range (the list has " + entries.size() + " entries)");
    }
    if (source == destination) {
      return;
    }
    Element moving = entries.remove(source);
    target.parent.removeChild(moving);
    // destination is the index in the list after the source has been taken out
    int position = destination < entries.size()
      ? positionOf(target.parent, entries.get(destination))
      : positionOf(target.parent, entries.get(entries.size() - 1)) + 1;
    target.parent.getChildList().add(position, moving);
    target.parent.numberChildren();
  }

  // -- values ---------------------------------------------------------------------------------

  /**
   * Put the content described by {@code value} into {@code target}, an element that is empty
   * (freshly created, or cleared by replace).
   */
  private void fill(Element target, ParametersParameterComponent value, String op) {
    if (value == null) {
      throw new FHIRException("FHIRPath Patch: " + op + " requires a 'value' part");
    }
    if (value.hasValue()) {
      DataType v = value.getValue();
      if (v.isPrimitive()) {
        if (!target.isPrimitive()) {
          throw new FHIRException("FHIRPath Patch: " + op + ": '" + target.getName() + "' is a " + target.fhirType() + ", which cannot take the primitive value '" + v.primitiveValue() + "'");
        }
        target.setValue(v.primitiveValue());
      } else {
        if (target.isPrimitive()) {
          throw new FHIRException("FHIRPath Patch: " + op + ": '" + target.getName() + "' is a primitive, which cannot take a " + v.fhirType() + " value");
        }
        Element converted = converter.convert(target.getProperty(), v);
        target.getChildList().addAll(converted.getChildList());
      }
    } else if (value.hasPart()) {
      if (target.isPrimitive()) {
        throw new FHIRException("FHIRPath Patch: " + op + ": '" + target.getName() + "' is a primitive, which cannot be built from parts");
      }
      for (ParametersParameterComponent part : value.getPartList()) {
        if (childProperty(target, part.getName()) == null) {
          throw new FHIRException("FHIRPath Patch: " + op + ": " + target.fhirType() + " has no element named '" + part.getName() + "'");
        }
        fill(target.addElement(part.getName()), part, op);
      }
    } else {
      throw new FHIRException("FHIRPath Patch: " + op + ": the 'value' part has neither a value nor parts");
    }
  }

  // -- paths ----------------------------------------------------------------------------------

  /** Evaluate {@code path} against {@code root}; every result must be an element. */
  private List<Element> evaluate(Element root, String path) {
    List<Base> results = fpe.evaluate(root, path);
    List<Element> elements = new ArrayList<>();
    for (Base b : results) {
      if (!(b instanceof Element)) {
        throw new FHIRException("FHIRPath Patch: path " + path + " selects a value, not an element of the resource");
      }
      elements.add((Element) b);
    }
    return elements;
  }

  private Element single(Element root, String path, String op) {
    List<Element> matches = evaluate(root, path);
    if (matches.size() != 1) {
      throw new FHIRException("FHIRPath Patch: " + op + " at " + path + ": selects " + matches.size() + " elements; " + op + " requires exactly one");
    }
    return matches.get(0);
  }

  /**
   * For insert and move the path names a list: the element that holds it, and the entries'
   * name. The list may be empty, in which case the path itself selects nothing, so the parent
   * is resolved from the path with its last segment taken off.
   */
  private ListTarget listTarget(Element root, String path, String op) {
    int dot = path.lastIndexOf('.');
    String name = dot < 0 ? null : path.substring(dot + 1);
    if (name == null || !name.matches("[A-Za-z][A-Za-z0-9]*")) {
      throw new FHIRException("FHIRPath Patch: " + op + " at " + path + ": the path must name a list, ending in an element name (for example Patient.name)");
    }
    Element parent = single(root, path.substring(0, dot), op);
    Property property = childProperty(parent, name);
    if (property == null) {
      throw new FHIRException("FHIRPath Patch: " + op + " at " + path + ": " + parent.fhirType() + " has no element named '" + name + "'");
    }
    return new ListTarget(parent, name, property);
  }

  private static final class ListTarget {
    final Element parent;
    final String name;
    final Property property;

    ListTarget(Element parent, String name, Property property) {
      this.parent = parent;
      this.name = name;
      this.property = property;
    }
  }

  // -- element helpers ------------------------------------------------------------------------

  /** The definition of {@code parent}'s child called {@code name}, allowing a choice name such as valueString. */
  private static Property childProperty(Element parent, String name) {
    for (Property p : parent.getProperty().getChildProperties(parent.getName(), parent.getType())) {
      if (p.getName().equals(name)) {
        return p;
      }
      if (p.getName().endsWith("[x]")) {
        String base = p.getName().substring(0, p.getName().length() - 3);
        if (name.startsWith(base) && name.length() > base.length()) {
          String type = name.substring(base.length());
          if (p.canBeType(type) || p.canBeType(Utilities.uncapitalize(type))) {
            return p;
          }
        }
      }
    }
    return null;
  }

  /** Position of {@code child} in {@code parent}'s full child list, by identity. */
  private static int positionOf(Element parent, Element child) {
    int i = 0;
    for (Element e : parent.getChildList()) {
      if (e == child) {
        return i;
      }
      i++;
    }
    throw new FHIRException("FHIRPath Patch: internal error - element '" + child.getName() + "' is not a child of '" + parent.getName() + "'");
  }

  /** The element whose child list holds {@code target}, found by walking down from {@code root}. */
  private static Element findParent(Element root, Element target) {
    if (root.hasChildren()) {
      for (Element child : root.getChildList()) {
        if (child == target) {
          return root;
        }
        Element found = findParent(child, target);
        if (found != null) {
          return found;
        }
      }
    }
    return null;
  }

  // -- parameter parts ------------------------------------------------------------------------

  private static ParametersParameterComponent part(ParametersParameterComponent op, String name) {
    for (ParametersParameterComponent p : op.getPartList()) {
      if (name.equals(p.getName())) {
        return p;
      }
    }
    return null;
  }

  private static String requiredPart(ParametersParameterComponent op, String name) {
    ParametersParameterComponent p = part(op, name);
    if (p == null || !p.hasValue()) {
      throw new FHIRException("FHIRPath Patch: an operation is missing its '" + name + "' part");
    }
    return p.getValue().primitiveValue();
  }

  private static int requiredInt(ParametersParameterComponent op, String name) {
    String s = requiredPart(op, name);
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      throw new FHIRException("FHIRPath Patch: the '" + name + "' part must be an integer, not '" + s + "'");
    }
  }
}
