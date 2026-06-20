package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.model.*;

import java.util.List;

public class ImplicitCodeSystemSupport {
  public static CodeSystem convertStructure(StructureDefinition sd) {
    CodeSystem cs = new CodeSystem();
    copyMetadata(sd, cs);
    cs.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    cs.setCaseSensitive(true);
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      CodeSystem.ConceptDefinitionComponent cc = cs.addConcept();
      cc.setCode(ed.getId());
      cc.setDisplay(ed.hasLabel() ? ed.getLabel() : ed.getShort());
      cc.setDefinition(ed.getDefinition());
    }

    return cs;
  }

  private static void copyMetadata(CanonicalResource src, CodeSystem cs) {
    cs.setIdElement(src.getIdElement());
    cs.setLanguageElement(src.getLanguageElement());
    cs.setMeta(src.getMeta());
    cs.setUrlElement(src.getUrlElement());
    cs.setVersionElement(src.getVersionElement());
    cs.setNameElement(src.getNameElement());
    cs.setTitleElement(src.getTitleElement());
    cs.setStatusElement(src.getStatusElement());
    cs.setCopyrightElement(src.getCopyrightElement());
    cs.setDateElement(src.getDateElement());
    cs.setPurposeElement(src.getPurposeElement());
    cs.setVersionAlgorithm(src.getVersionAlgorithm());
    cs.setVersionElement(src.getVersionElement());
    cs.setIdentifier(src.getIdentifier());
    cs.setExperimentalElement(src.getExperimentalElement());
    cs.setPublisherElement(src.getPublisherElement());
    cs.setContact(src.getContact());
    cs.setJurisdiction(src.getJurisdiction());
    cs.setCopyrightLabelElement(src.getCopyrightLabelElement());
  }

  public static CodeSystem convertQuestionnaire(Questionnaire q) {
    CodeSystem cs = new CodeSystem();
    copyMetadata(q, cs);
    cs.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    cs.setCaseSensitive(true);
    cs.setHierarchyMeaning(CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
    for (var i : q.getItem()) {
      processQuestionnaireItem(cs.getConcept(), i);
    }

    return cs;
  }

  private static void processQuestionnaireItem(List<CodeSystem.ConceptDefinitionComponent> list, Questionnaire.QuestionnaireItemComponent i) {
    CodeSystem.ConceptDefinitionComponent cc = new CodeSystem.ConceptDefinitionComponent();
    list.add(cc);
    cc.setCode(i.getLinkId());
    cc.setDisplay(i.getText());
    for (var ci : i.getItem()) {
      processQuestionnaireItem(cc.getConcept(), ci);
    }
  }

  public static CodeSystem convertRequirements(Requirements r) {
    CodeSystem cs = new CodeSystem();
    copyMetadata(r, cs);
    cs.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    cs.setCaseSensitive(true);
    for (Requirements.RequirementsStatementComponent stmt : r.getStatement()) {
      CodeSystem.ConceptDefinitionComponent cc = cs.addConcept();
      cc.setCode(stmt.getKey());
      cc.setDisplay(stmt.hasLabel() ? stmt.getLabel() : stmt.getKey());
      cc.setDefinition(stmt.getRequirement());
    }
    return cs;
  }

  public static CodeSystem convertMeasure(Measure m) {
    CodeSystem cs = new CodeSystem();
    copyMetadata(m, cs);
    cs.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    cs.setCaseSensitive(true);
    cs.setHierarchyMeaning(CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
    for (Measure.MeasureGroupComponent grp : m.getGroup()) {
      CodeSystem.ConceptDefinitionComponent cgrp = cs.addConcept();
      cgrp.setCode(grp.getLinkId());
      cgrp.setDisplay(grp.getCode().getText());
      cgrp.setDefinition(grp.getDescription());
      for (var pop : grp.getPopulation()) {
        CodeSystem.ConceptDefinitionComponent cc = cgrp.addConcept();
        cc.setCode(pop.getLinkId());
        cc.setDisplay(pop.getCode().getText());
        cc.setDefinition(pop.getDescription());
      }
      for (var str : grp.getStratifier()) {
        CodeSystem.ConceptDefinitionComponent cc = cgrp.addConcept();
        cc.setCode(str.getLinkId());
        cc.setDisplay(str.getCode().getText());
        cc.setDefinition(str.getDescription());
        for (var comp : str.getComponent()) {
          CodeSystem.ConceptDefinitionComponent cc2 = cc.addConcept();
          cc2.setCode(comp.getLinkId());
          cc2.setDisplay(comp.getCode().getText());
          cc2.setDefinition(comp.getDescription());
        }
      }
    }
    return cs;
  }
}
