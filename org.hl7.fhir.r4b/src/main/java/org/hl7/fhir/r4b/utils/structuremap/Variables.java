package org.hl7.fhir.r4b.utils.structuremap;

import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Variables {
  private List<Variable> list = new ArrayList<Variable>();

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
    return result;
  }

  public Base get(VariableMode mode, String name) {
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
    return "source variables [" + s.toString() + "], target variables [" + t.toString() + "], shared variables ["
        + sh.toString() + "]";
  }

}
