package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.elementmodel.Element;

public class IndexedElement {
  private int index;
  private Element match;
  private Element entry;

    public int getIndex() {
        return index;
    }

    public IndexedElement setIndex(int index) {
        this.index = index;
        return this;
    }

    public Element getMatch() {
        return match;
    }

    public IndexedElement setMatch(Element match) {
        this.match = match;
        return this;
    }

    public Element getEntry() {
        return entry;
    }

    public IndexedElement setEntry(Element entry) {
        this.entry = entry;
        return this;
    }

    public IndexedElement(int index, Element match, Element entry) {
    super();
    this.index = index;
    this.match = match;
    this.entry = entry;
  }

}