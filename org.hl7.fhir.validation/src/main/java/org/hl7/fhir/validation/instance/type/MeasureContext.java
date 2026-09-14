package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.model.core.Attachment;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.Library;
import org.hl7.fhir.model.core.Measure;
import org.hl7.fhir.model.core.Measure.MeasureGroupComponent;
import org.hl7.fhir.utilities.xml.XMLUtil;

public class MeasureContext {


  public static final String USER_DATA_ELM = "validator.ELM";
  // Measure.group.scoring only exists from R5; before that, the CQM IG carries group level scoring in this extension
  public static final String EXT_CQM_SCORING = "http://hl7.org/fhir/uv/cqm/StructureDefinition/cqm-scoring";
  // root level Measure.scoring only exists before R6; when a Measure is converted up from
  // an earlier version, it is carried in the matching cross-version extension
  public static final String[] EXT_XVER_SCORING = {
      "http://hl7.org/fhir/4.0/StructureDefinition/extension-Measure.scoring",
      "http://hl7.org/fhir/4.3/StructureDefinition/extension-Measure.scoring",
      "http://hl7.org/fhir/5.0/StructureDefinition/extension-Measure.scoring"
  };
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
    for (Attachment att : l.getContentList()) {
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
    return measure.getGroupList();
  }

  public Measure measure() {
    return measure;
  }
  
  public String reportType() {
    return report.getChildValue("type");
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

  public String scoring() {
    for (String url : EXT_XVER_SCORING) {
      if (measure.hasExtension(url)) {
        DataType v = measure.getExtensionByUrl(url).getValue();
        if (v instanceof CodeableConcept) {
          return ((CodeableConcept) v).getCodingFirstRep().getCode();
        }
      }
    }
    return null;
  }

  public List<Library> libraries() {
    return libs;
  }

}