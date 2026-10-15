package org.hl7.fhir.model.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.model.core.CodeSystem.PropertyComponent;
import org.hl7.fhir.utilities.Utilities;

/**
 * The hierarchy of a code system: which concepts are the parents of which.
 * <p>
 * A code system can say this in three ways: by nesting concepts inside each other, by a concept
 * property that names a parent, and by a concept property that names a child. The parent and child
 * properties are found by their uri (http://hl7.org/fhir/concept-properties#parent and #child), not
 * by their code, since the code varies - THO's v3 code systems call the parent property 'subsumedBy',
 * for instance. Only if no property has the parent uri are properties with the code 'parent' or
 * 'subsumedBy' taken to name parents (older THO releases didn't declare the uri, or the property at
 * all); likewise 'child' if no property has the child uri.
 * <p>
 * A child statement is usually just the reverse of a parent statement that is also made, so the
 * relationships are kept as a set: saying the same thing twice, in either direction, makes one
 * relationship, not two.
 * <p>
 * This is the analysis that doesn't change while the code system doesn't. It is immutable once built,
 * so one instance can be shared between threads, and cached against the code system (see
 * {@link #USER_DATA_NAME}) as long as the code system isn't structurally changed afterwards.
 */
public class CodeSystemHierarchy {

  public static final String USER_DATA_NAME = "cs.hierarchy.analysis";
  public static final String PARENT_PROPERTY_URI = "http://hl7.org/fhir/concept-properties#parent";
  public static final String CHILD_PROPERTY_URI = "http://hl7.org/fhir/concept-properties#child";

  private final CodeSystem codeSystem;
  // code -> all its parents: by nesting, and by parent or child statements
  private final Map<String, Set<String>> parents;
  // the top level concepts that have no stated parent (in concept order)
  private final List<ConceptDefinitionComponent> roots;
  // code -> the top level concepts that are stated to be its children (in concept order)
  private final Map<String, List<ConceptDefinitionComponent>> statedChildren;

  public CodeSystemHierarchy(@Nonnull CodeSystem cs) {
    this.codeSystem = cs;
    Set<String> parentCodes = propertyCodes(cs, PARENT_PROPERTY_URI, "parent", "subsumedBy");
    Set<String> childCodes = propertyCodes(cs, CHILD_PROPERTY_URI, "child");

    Set<String> codes = new HashSet<>();
    // child -> parent, as stated by properties (either direction), in the order stated
    Map<String, Set<String>> stated = new HashMap<>();
    Map<String, Set<String>> all = new HashMap<>();
    scan(cs.getConceptList(), null, parentCodes, childCodes, codes, stated, all);

    List<ConceptDefinitionComponent> rootList = new ArrayList<>();
    Map<String, List<ConceptDefinitionComponent>> children = new HashMap<>();
    for (ConceptDefinitionComponent cd : cs.getConceptList()) {
      boolean hasParent = false;
      if (cd.hasCode()) {
        for (String p : stated.getOrDefault(cd.getCode(), Collections.emptySet())) {
          // a parent that isn't in the code system would make the concept disappear from the hierarchy
          if (codes.contains(p)) {
            hasParent = true;
            children.computeIfAbsent(p, k -> new ArrayList<>()).add(cd);
          }
        }
      }
      if (!hasParent) {
        rootList.add(cd);
      }
    }

    Map<String, Set<String>> p = new HashMap<>();
    for (Map.Entry<String, Set<String>> e : all.entrySet()) {
      p.put(e.getKey(), Collections.unmodifiableSet(e.getValue()));
    }
    this.parents = Collections.unmodifiableMap(p);
    Map<String, List<ConceptDefinitionComponent>> c = new HashMap<>();
    for (Map.Entry<String, List<ConceptDefinitionComponent>> e : children.entrySet()) {
      c.put(e.getKey(), Collections.unmodifiableList(e.getValue()));
    }
    this.statedChildren = Collections.unmodifiableMap(c);
    this.roots = Collections.unmodifiableList(rootList);
  }

  /**
   * The codes of the properties that have the given uri. If there are none, the properties with any of
   * the fallback codes, whether declared or not (old THO releases use subsumedBy without declaring it)
   */
  private static Set<String> propertyCodes(CodeSystem cs, String uri, String... fallbacks) {
    Set<String> res = new HashSet<>();
    for (PropertyComponent pc : cs.getPropertyList()) {
      if (uri.equals(pc.getUri()) && pc.hasCode()) {
        res.add(pc.getCode());
      }
    }
    if (res.isEmpty()) {
      Collections.addAll(res, fallbacks);
    }
    return res;
  }

  private static void scan(List<ConceptDefinitionComponent> list, String parentCode, Set<String> parentCodes, Set<String> childCodes,
      Set<String> codes, Map<String, Set<String>> stated, Map<String, Set<String>> all) {
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasCode()) {
        String code = cd.getCode();
        codes.add(code);
        if (parentCode != null) {
          add(all, code, parentCode);
        }
        for (ConceptPropertyComponent p : cd.getPropertyList()) {
          if (!p.hasCode() || !p.hasValue() || !p.getValue().isPrimitive()) {
            continue;
          }
          String value = p.getValue().primitiveValue();
          if (Utilities.noString(value)) {
            continue;
          }
          if (parentCodes.contains(p.getCode())) {
            add(stated, code, value);
            add(all, code, value);
          } else if (childCodes.contains(p.getCode())) {
            add(stated, value, code);
            add(all, value, code);
          }
        }
      }
      scan(cd.getConceptList(), cd.hasCode() ? cd.getCode() : parentCode, parentCodes, childCodes, codes, stated, all);
    }
  }

  private static void add(Map<String, Set<String>> map, String code, String parent) {
    if (!code.equals(parent)) { // a concept is not its own parent, whatever it says
      map.computeIfAbsent(code, k -> new LinkedHashSet<>()).add(parent);
    }
  }

  /**
   * @return the analysis for the code system, building it (and caching it, if cache
   * is true) if there isn't one. A cached analysis is only used if it was built for this very object -
   * Base.copy() copies user data, so a copy of a code system carries its original's analysis
   */
  public static CodeSystemHierarchy forCodeSystem(@Nonnull CodeSystem cs, boolean cache) {
    if (!cache) {
      return new CodeSystemHierarchy(cs);
    }
    // the lock is so that two threads don't build it at the same time, and so that the user data map is
    // only changed by one thread at a time - as far as this key is concerned. Base.userData isn't
    // thread safe, so anything else that writes user data on the same code system from another thread
    // at the same time can still collide with this
    synchronized (cs) {
      Object o = cs.getUserData(USER_DATA_NAME);
      if (o instanceof CodeSystemHierarchy && ((CodeSystemHierarchy) o).codeSystem == cs) {
        return (CodeSystemHierarchy) o;
      }
      CodeSystemHierarchy res = new CodeSystemHierarchy(cs);
      cs.setUserData(USER_DATA_NAME, res);
      return res;
    }
  }

  public CodeSystem getCodeSystem() {
    return codeSystem;
  }

  /**
   * @return true if any top level concept has a stated parent, and so the concepts need to be re-arranged
   * to show the hierarchy
   */
  public boolean isRestructure() {
    return roots.size() < codeSystem.getConceptList().size();
  }

  /**
   * @return the top level concepts that don't have a stated parent, in concept order
   */
  public List<ConceptDefinitionComponent> getRoots() {
    return roots;
  }

  /**
   * @return the top level concepts that are stated (by either a parent or a child property) to be children
   * of the code, in concept order
   */
  public List<ConceptDefinitionComponent> getStatedChildren(String code) {
    return statedChildren.getOrDefault(code, Collections.emptyList());
  }

  /**
   * @return all the parents of the code - by nesting, and by parent and child properties
   */
  public Set<String> getParents(String code) {
    return parents.getOrDefault(code, Collections.emptySet());
  }

  /**
   * @return true if ancestor is an ancestor of code. Cycle safe: code systems are not supposed to contain
   * loops, but nothing stops them
   */
  public boolean hasAncestor(String code, String ancestor) {
    Set<String> visited = new HashSet<>();
    List<String> queue = new ArrayList<>();
    queue.add(code);
    for (int i = 0; i < queue.size(); i++) {
      String c = queue.get(i);
      if (visited.add(c)) {
        for (String p : getParents(c)) {
          if (p.equals(ancestor)) {
            return true;
          }
          queue.add(p);
        }
      }
    }
    return false;
  }
}
