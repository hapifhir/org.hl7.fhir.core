package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@MarkedToMoveToAdjunctPackage
public class Variables {
  private List<Variable> list = new ArrayList<Variable>();
  private StructureMapConstantResolver constants;

  public void add(VariableMode mode, String name, Base object) {
    Variable vv = null;
    for (Variable v : list)
      if ((v.getMode() == mode) && v.getName().equals(name))
        vv = v;
    if (vv != null)
      list.remove(vv);
    list.add(new Variable(mode, name, object));
  }

  public Variables copy() {
    Variables result = new Variables();
    result.list.addAll(list);
    result.constants = constants;
    return result;
  }

  public StructureMapConstantResolver getConstants() {
    return constants;
  }

  public void setConstants(StructureMapConstantResolver constants) {
    this.constants = constants;
  }

  /**
   * Retrieve the set of all variables contained in this instance (required for a trace debugger to have access when needed).
   * @return
   */
  public List<Variable> getVariables() {
    return Collections.unmodifiableList(list);
  }

  public Base get(VariableMode mode, String name) {
    Base variable = getLocal(mode, name);
    if (variable != null) {
      return variable;
    }
    if (constants != null) {
      var c = constants.resolve(name);
      if (c != null && c.size() > 0)
        return c.get(0);
    }
    return null;
  }

  Base getLocal(VariableMode mode, String name) {
    for (Variable v : list)
      if ((v.getMode() == mode) && v.getName().equals(name))
        return v.getObject();
    return null;
  }

  public String summary() {
    CommaSeparatedStringBuilder s = new CommaSeparatedStringBuilder();
    CommaSeparatedStringBuilder t = new CommaSeparatedStringBuilder();
    CommaSeparatedStringBuilder sh = new CommaSeparatedStringBuilder();
    for (Variable v : list)
      switch (v.getMode()) {
        case INPUT:
          s.append(v.summary());
          break;
        case OUTPUT:
          t.append(v.summary());
          break;
        case SHARED:
          sh.append(v.summary());
          break;
      }
    return "source variables [" + s.toString() + "], target variables [" + t.toString() + "], shared variables [" + sh.toString() + "]";
  }

}
