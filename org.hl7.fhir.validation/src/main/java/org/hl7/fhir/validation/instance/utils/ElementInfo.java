package org.hl7.fhir.validation.instance.utils;

import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ElementInfo {

  private List<ValidationMessage> sliceInfo;
  private int index; // order of definition in overall order. all slices get the index of the slicing definition
  private int sliceindex; // order of the definition in the slices (if slice != null)
  private int count;
  private StructureDefinition structure;
  private ElementDefinition definition;
  private ElementDefinition slice;
  private boolean additionalSlice; // If true, indicates that this element is an additional slice
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

  public StructureDefinition getStructure() {
    return structure;
  }

  public ElementInfo setDefinition(StructureDefinition sd, ElementDefinition definition) {
    this.structure = sd;
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