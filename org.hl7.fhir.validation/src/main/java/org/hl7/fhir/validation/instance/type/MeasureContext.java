package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Measure;
import org.hl7.fhir.r5.model.Measure.MeasureGroupComponent;

public class MeasureContext {


  private List<Library> libs = new ArrayList<>();
  private Measure measure;
  private Element report;

  public MeasureContext() {
    
  }
  public MeasureContext(Measure measure, Element report) {
    this.measure = measure;
    this.report = report;
  }

  public void seeLibrary(Library l) {
    libs.add(l);    
  }

  public List<MeasureGroupComponent> groups() {
    return measure.getGroup();
  }

  public Measure measure() {
    return measure;
  }
  
  public String reportType() {
    return report.getChildValue("type");
  }
  public String scoring() {
    return measure.getScoring().getCodingFirstRep().getCode();
  }

}
