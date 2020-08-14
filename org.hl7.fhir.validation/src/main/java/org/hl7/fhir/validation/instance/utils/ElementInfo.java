package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.util.List;

public class ElementInfo {

  public List<ValidationMessage> sliceInfo;
  public int index; // order of definition in overall order. all slices get the index of the slicing definition
  public int sliceindex; // order of the definition in the slices (if slice != null)
  public int count;
  public ElementDefinition definition;
  public ElementDefinition slice;
  public boolean additionalSlice; // If true, indicates that this element is an additional slice
  private Element element;
  private String name;
  private String path;

  public ElementInfo(String name, Element element, String path, int count) {
    this.name = name;
    this.element = element;
    this.path = path;
    this.count = count;
  }

    public List<ValidationMessage> getSliceInfo() {
        return sliceInfo;
    }

    public ElementInfo setSliceInfo(List<ValidationMessage> sliceInfo) {
        this.sliceInfo = sliceInfo;
        return this;
    }

    public int getIndex() {
        return index;
    }

    public ElementInfo setIndex(int index) {
        this.index = index;
        return this;
    }

    public int getSliceindex() {
        return sliceindex;
    }

    public ElementInfo setSliceindex(int sliceindex) {
        this.sliceindex = sliceindex;
        return this;
    }

    public int getCount() {
        return count;
    }

    public ElementInfo setCount(int count) {
        this.count = count;
        return this;
    }

    public ElementDefinition getDefinition() {
        return definition;
    }

    public ElementInfo setDefinition(ElementDefinition definition) {
        this.definition = definition;
        return this;
    }

    public ElementDefinition getSlice() {
        return slice;
    }

    public ElementInfo setSlice(ElementDefinition slice) {
        this.slice = slice;
        return this;
    }

    public boolean isAdditionalSlice() {
        return additionalSlice;
    }

    public ElementInfo setAdditionalSlice(boolean additionalSlice) {
        this.additionalSlice = additionalSlice;
        return this;
    }

    public Element getElement() {
        return element;
    }

    public ElementInfo setElement(Element element) {
        this.element = element;
        return this;
    }

    public String getName() {
        return name;
    }

    public ElementInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPath() {
        return path;
    }

    public ElementInfo setPath(String path) {
        this.path = path;
        return this;
    }

    public int col() {
    return element.col();
  }

  public int line() {
    return element.line();
  }

  @Override
  public String toString() {
    return path;
  }
}