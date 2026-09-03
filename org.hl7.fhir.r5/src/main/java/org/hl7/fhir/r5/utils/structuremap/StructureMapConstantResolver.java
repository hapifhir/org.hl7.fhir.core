package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapConstComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Resolves and caches {@code let} constants declared at the {@link StructureMap} level.
 * Implements the lazy-evaluation and circular-reference rules from the FHIR Mapping Language
 * specification: each constant is evaluated on first reference, the result is cached, and
 * cycles are detected and reported as an error. The same instance is shared across every
 * {@link Variables} copy made during a single {@code transform} call so the cache and the
 * in-progress set survive rule-level scope changes.
 */
class StructureMapConstantResolver {

  private final StructureMap map;
  private final FHIRPathEngine fpe;
  private final Map<String, List<Base>> cache = new HashMap<>();
  private final Set<String> evaluating = new LinkedHashSet<>();

  StructureMapConstantResolver(StructureMap map, FHIRPathEngine fpe) {
    this.map = map;
    this.fpe = fpe;
  }

  boolean has(String name) {
    return find(name) != null;
  }

  List<Base> resolve(String name) {
    if (cache.containsKey(name)) {
      return cache.get(name);
    }
    StructureMapConstComponent target = find(name);
    if (target == null) {
      return Collections.emptyList();
    }
    if (evaluating.contains(name)) {
      throw new FHIRException("Circular reference detected while evaluating constant '" + name
        + "' (chain: " + String.join(" -> ", evaluating) + " -> " + name + ")");
    }
    evaluating.add(name);
    try {
      // Constants cannot see source/target variables, only other constants.
      Variables vars = new Variables();
      vars.setConstants(this);
      ExpressionNode expr = fpe.parse(target.getValue());
      List<Base> raw = fpe.evaluate(vars, null, null, new BooleanType(false), expr);
      List<Base> result = raw == null ? Collections.<Base>emptyList()
        : Collections.unmodifiableList(new ArrayList<>(raw));
      cache.put(name, result);
      return result;
    } finally {
      evaluating.remove(name);
    }
  }

  private StructureMapConstComponent find(String name) {
    for (StructureMapConstComponent c : map.getConst()) {
      if (name.equals(c.getName())) {
        return c;
      }
    }
    return null;
  }
}
