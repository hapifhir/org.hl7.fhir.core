package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Library;
import org.hl7.fhir.r5.model.Measure;
import org.hl7.fhir.r5.model.Measure.MeasureGroupComponent;
import org.hl7.fhir.utilities.xml.XMLUtil;

public class MeasureContext {


  public static final String USER_DATA_ELM = "validator.ELM";
  // Measure.group.scoring only exists from R5; before that, the CQM IG carries group level scoring in this extension
  public static final String EXT_CQM_SCORING = "http://hl7.org/fhir/uv/cqm/StructureDefinition/cqm-scoring";
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
  public String scoring(MeasureGroupComponent group) {
    if (group.hasScoring()) {
      return group.getScoring().getCodingFirstRep().getCode();
    }
    if (group.hasExtension(EXT_CQM_SCORING)) {
      DataType v = group.getExtensionByUrl(EXT_CQM_SCORING).getValue();
      if (v instanceof CodeableConcept) {
        return ((CodeableConcept) v).getCodingFirstRep().getCode();
      }
    }
    return scoring();
  }
  public List<Library> libraries() {
    return libs;
  }

}