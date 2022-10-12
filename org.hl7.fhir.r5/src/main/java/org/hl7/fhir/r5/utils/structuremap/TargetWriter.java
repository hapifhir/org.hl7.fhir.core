package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetWriter {
  private Map<String, String> newResources = new HashMap<String, String>();
  private List<StringPair> assignments = new ArrayList<StringPair>();
  private List<StringPair> keyProps = new ArrayList<StringPair>();
  private CommaSeparatedStringBuilder txt = new CommaSeparatedStringBuilder();

  public void newResource(String var, String name) {
    newResources.put(var, name);
    txt.append("new " + name);
  }

  public void valueAssignment(String context, String desc) {
    assignments.add(new StringPair(context, desc));
    txt.append(desc);
  }

  public void keyAssignment(String context, String desc) {
    keyProps.add(new StringPair(context, desc));
    txt.append(desc);
  }

  public void commit(XhtmlNode xt) {
    if (newResources.size() == 1 && assignments.size() == 1 && newResources.containsKey(assignments.get(0).getName()) && keyProps.size() == 1 && newResources.containsKey(keyProps.get(0).getName())) {
      xt.addText("new " + assignments.get(0).getValue() + " (" + keyProps.get(0).getValue().substring(keyProps.get(0).getValue().indexOf(".") + 1) + ")");
    } else if (newResources.size() == 1 && assignments.size() == 1 && newResources.containsKey(assignments.get(0).getName()) && keyProps.size() == 0) {
      xt.addText("new " + assignments.get(0).getValue());
    } else {
      xt.addText(txt.toString());
    }
  }
}
