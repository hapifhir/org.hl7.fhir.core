package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;

public class EntrySummary {

    Element entry;
    Element resource;
    List<EntrySummary> targets = new ArrayList<>();
    private int index;

    public Element getEntry() {
        return entry;
    }

    public EntrySummary setEntry(Element entry) {
        this.entry = entry;
        return this;
    }

    public Element getResource() {
        return resource;
    }

    public EntrySummary setResource(Element resource) {
        this.resource = resource;
        return this;
    }

    public List<EntrySummary> getTargets() {
        return targets;
    }

    public EntrySummary setTargets(List<EntrySummary> targets) {
        this.targets = targets;
        return this;
    }

    public EntrySummary(int i, Element entry, Element resource) {
      this.index = i;
      this.entry = entry;
      this.resource = resource;
    }

    public String dbg() {
      return ""+index+"="+ entry.getChildValue("fullUrl")+" | "+resource.getIdBase() + "("+resource.fhirType()+")";
    }

    public String getIndex() {
      return Integer.toString(index);
    }
}