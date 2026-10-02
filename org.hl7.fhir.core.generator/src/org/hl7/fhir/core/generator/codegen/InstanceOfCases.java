package org.hl7.fhir.core.generator.codegen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.StructureDefinition;

/**
 * The "} else if (x instanceof T) {" branches of a generated dispatch chain (composeType,
 * composeResource, etc).
 *
 * A specialisation has to be tested before the type it specialises - Age, Count, Distance and
 * Duration before Quantity - or the Quantity branch catches them: an Age is written as
 * onsetQuantity, and reading it back fails because Condition.onset[x] doesn't allow Quantity.
 * Appending in the order the classes are generated made that depend on the order the
 * definitions happen to be listed in the package (ballot5 had the specialisations first,
 * snapshot1 has Quantity first). So each branch goes in before the first branch for any of its
 * ancestors; everything else keeps the order it was added in.
 */
public class InstanceOfCases {

  private static class Case {
    private final String url;
    private final Set<String> ancestors;
    private final String text;

    private Case(String url, Set<String> ancestors, String text) {
      this.url = url;
      this.ancestors = ancestors;
      this.text = text;
    }
  }

  private final List<Case> cases = new ArrayList<>();

  public void add(StructureDefinition sd, Definitions definitions, String text) {
    Case c = new Case(sd.getUrl(), ancestors(sd, definitions), text);
    int i = 0;
    while (i < cases.size() && !c.ancestors.contains(cases.get(i).url)) {
      i++;
    }
    cases.add(i, c);
  }

  private Set<String> ancestors(StructureDefinition sd, Definitions definitions) {
    Set<String> res = new HashSet<>();
    while (sd != null && sd.hasBaseDefinition() && res.add(sd.getBaseDefinition())) {
      sd = definitions.getStructures().get(sd.getBaseDefinition());
    }
    return res;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < cases.size(); i++) {
      for (int j = i + 1; j < cases.size(); j++) {
        if (cases.get(j).ancestors.contains(cases.get(i).url)) {
          throw new Error("Internal error ordering instanceof branches: "+cases.get(i).url+" comes before its specialisation "+cases.get(j).url);
        }
      }
      b.append(cases.get(i).text);
    }
    return b.toString();
  }
}
