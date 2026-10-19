package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Parameters.ParametersParameterComponent;
import org.junit.jupiter.api.Test;

/**
 * Parameters are sorted at every level the same way - including the parts of a parameter, or of
 * a part, that has nothing to be compared with
 */
class TxTesterSortersTests {

  private List<String> names(List<ParametersParameterComponent> list) {
    return list.stream().map(ParametersParameterComponent::getName).collect(Collectors.toList());
  }

  private ParametersParameterComponent part(ParametersParameterComponent p, String name) {
    return p.addPart().setName(name);
  }

  @Test
  void partsOfALoneParameterAreSortedAtEveryLevel() {
    Parameters po = new Parameters();
    ParametersParameterComponent only = po.addParameter().setName("only");
    ParametersParameterComponent b = part(only, "b");
    ParametersParameterComponent a = part(only, "a");
    part(a, "z");
    part(a, "y");
    // a lone part, whose own parts are out of order
    ParametersParameterComponent lone = part(b, "lone");
    part(lone, "q");
    part(lone, "p");

    TxTesterSorters.sortParameters(po);

    assertEquals(List.of("a", "b"), names(only.getPartList()));
    assertEquals(List.of("y", "z"), names(only.getPartList().get(0).getPartList()));
    assertEquals(List.of("p", "q"), names(only.getPartList().get(1).getPartList().get(0).getPartList()));
  }

  @Test
  void level3PartsAreSortedLikeLevel2() {
    Parameters po = new Parameters();
    ParametersParameterComponent p2 = po.addParameter().setName("second");
    ParametersParameterComponent p1 = po.addParameter().setName("first");
    ParametersParameterComponent prop = part(p1, "property");
    ParametersParameterComponent sub2 = part(prop, "subproperty");
    sub2.addPart().setName("code").setValue(new org.hl7.fhir.model.core.CodeType("zeta"));
    ParametersParameterComponent sub1 = part(prop, "subproperty");
    sub1.addPart().setName("code").setValue(new org.hl7.fhir.model.core.CodeType("alpha"));
    part(prop, "code").setValue(new org.hl7.fhir.model.core.CodeType("c"));
    part(p2, "x");

    TxTesterSorters.sortParameters(po);

    assertEquals(List.of("first", "second"), names(po.getParameterList()));
    List<ParametersParameterComponent> parts = po.getParameterList().get(0).getPartList().get(0).getPartList();
    assertEquals(List.of("code", "subproperty", "subproperty"), names(parts));
    // subproperties sorted by their code, as properties are at level 2
    assertEquals("alpha", parts.get(1).getPart("code").getValue().primitiveValue());
    assertEquals("zeta", parts.get(2).getPart("code").getValue().primitiveValue());
  }
}
