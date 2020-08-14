package org.hl7.fhir.validation.instance.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Measure;
import org.hl7.fhir.r5.model.Measure.MeasureGroupComponent;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.xml.sax.SAXException;

public class MeasureContext {


  public static final String USER_DATA_ELM = "validator.ELM";
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
    for (Attachment att : l.getContent()) {
      if ("application/elm+xml".equals(att.getContentType())) {
        try {
          l.setUserData(USER_DATA_ELM, XMLUtil.parseToDom(att.getData(), true));
        } catch (Exception e) {
          l.setUserData(USER_DATA_ELM, e.getMessage());
        }
      }
    }
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
  public List<Library> libraries() {
    return libs;
  }

}