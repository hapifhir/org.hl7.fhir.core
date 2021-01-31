package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;

public class EntrySummary {

    Element entry;
    Element resource;
    List<EntrySummary> targets = new ArrayList<>();

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

    public EntrySummary(Element entry, Element resource) {
        this.entry = entry;
        this.resource = resource;
    }
}