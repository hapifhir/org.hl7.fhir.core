package org.hl7.fhir.r5.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.AdditionalAttributeComponent;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent;
import org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;

public class ResourceMinifier {

  private static final List<String> VALIDATION_EXTENSIONS =
      Arrays.asList(ToolingExtensions.EXT_OBLIGATION_INHERITS, ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG);

  public boolean isMinified(String resName) {
    return Utilities.existsInList(resName, "StructureDefinition", "CodeSystem", "ValueSet", "CapabilityStatement",
       "ConceptMap", "NamingSystem", "OperationDefinition", "SearchParameter", "Questionnaire");
  }
  
  public boolean minify(Resource res) {
    if (res instanceof StructureDefinition) {
      return minifySD((StructureDefinition) res);
    } else if (res instanceof ValueSet) {
      minifyVS((ValueSet) res);
    } else if (res instanceof CodeSystem) {
      minifyCS((CodeSystem) res);
    } else if (res instanceof CapabilityStatement) {
      minifyCS((CapabilityStatement) res);
    } else if (res instanceof ConceptMap) {
      minifyCM((ConceptMap) res);
    } else if (res instanceof NamingSystem) {
      minifyNS((NamingSystem) res);
    } else if (res instanceof OperationDefinition) {
      minifyOD((OperationDefinition) res);
    } else if (res instanceof Questionnaire) {
      minifyQ((Questionnaire) res);
    } else if (res instanceof SearchParameter) {
      minifySP((SearchParameter) res);
    }
    return true;
  }

  private void minifySP(SearchParameter sp) {
    minCR(sp);
    // nothing
  }

  private void minifyQ(Questionnaire q) {
    minCR(q);

    q.setApprovalDate(null);
    q.setLastReviewDate(null);
    q.setEffectivePeriod(null);
    q.setCode(null);
    for (QuestionnaireItemComponent item : q.getItem()) {
      minifyQItem(item);
      
    }
  }

  private void minifyQItem(QuestionnaireItemComponent item) {
    item.setCode(null);
    item.setPrefix(null);
    item.setText(null);
    for (QuestionnaireItemComponent child : item.getItem()) {
      minifyQItem(child);
    }
  }

  private void minifyOD(OperationDefinition od) {
    minCR(od);
    od.setComment(null);
    for (OperationDefinitionParameterComponent p : od.getParameter()) {
      minifyODP(p);
    }
    for (OperationDefinitionOverloadComponent ol : od.getOverload()) {
      ol.setComment(null);
    }
  }

  private void minifyODP(OperationDefinitionParameterComponent p) {
    p.setDocumentation(null);
    for (OperationDefinitionParameterComponent pp : p.getPart()) {
      minifyODP(pp);
    }
  }

  private void minifyNS(NamingSystem ns) {
    minCR(ns);

    ns.setApprovalDate(null);
    ns.setLastReviewDate(null);
    ns.setEffectivePeriod(null);
    ns.setTopic(null);
    ns.setAuthor(null);
    ns.setEditor(null);
    ns.setReviewer(null);
    ns.setEndorser(null);
    ns.setRelatedArtifact(null);
    
    ns.setUsage(null);
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      id.setComment(null);
    }
  }

  private void minifyCM(ConceptMap cm) {
    minCR(cm);
    
    cm.setApprovalDate(null);
    cm.setLastReviewDate(null);
    cm.setEffectivePeriod(null);
    cm.setTopic(null);
    cm.setAuthor(null);
    cm.setEditor(null);
    cm.setReviewer(null);
    cm.setEndorser(null);
    cm.setRelatedArtifact(null);

    for (org.hl7.fhir.r5.model.ConceptMap.PropertyComponent prop : cm.getProperty()) {
      prop.setDescription(null);
    }
    for (AdditionalAttributeComponent attr : cm.getAdditionalAttribute()) {
      attr.setDescription(null);
    }
    for (ConceptMapGroupComponent group : cm.getGroup()) {
      for (SourceElementComponent elem : group.getElement()) {
        for (TargetElementComponent tgt : elem.getTarget()) {
          tgt.setComment(null);
        }
      }
    }
  }

  private void minifyCS(CapabilityStatement cs) {
    minCR(cs);
    
    cs.setSoftware(null);
    cs.setImplementation(null);
    for (CapabilityStatementRestComponent rest : cs.getRest()) {
      rest.setDocumentation(null);
      rest.setSecurity(null);
      for (CapabilityStatementRestResourceComponent res : rest.getResource()) {
        res.setDocumentation(null);
        for (ResourceInteractionComponent intr : res.getInteraction()) {
          intr.setDocumentation(null);
        }
        for (CapabilityStatementRestResourceSearchParamComponent srch : res.getSearchParam()) {
          srch.setDocumentation(null);
        }
        for (CapabilityStatementRestResourceOperationComponent op : res.getOperation()) {
          op.setDocumentation(null);
        }
      }
      for (SystemInteractionComponent intr : rest.getInteraction()) {
        intr.setDocumentation(null);
      }
      for (CapabilityStatementRestResourceSearchParamComponent srch : rest.getSearchParam()) {
        srch.setDocumentation(null);
      }
      for (CapabilityStatementRestResourceOperationComponent op : rest.getOperation()) {
        op.setDocumentation(null);
      }
    }
    cs.setMessaging(null);
    cs.setDocument(null);
  }
  
  private void minifyCS(CodeSystem cs) {
    minCR(cs);
    
    cs.setApprovalDate(null);
    cs.setLastReviewDate(null);
    cs.setEffectivePeriod(null);
    cs.setTopic(null);
    cs.setAuthor(null);
    cs.setEditor(null);
    cs.setReviewer(null);
    cs.setEndorser(null);
    cs.setRelatedArtifact(null);

    for (CodeSystemFilterComponent filter : cs.getFilter()) {
      filter.setDescription(null);
    }
    for (PropertyComponent prop : cs.getProperty()) {
      prop.setDescription(null);
    }
    for (ConceptDefinitionComponent cc : cs.getConcept()) {
      minify(cc);
    }
  }
  
  private void minify(ConceptDefinitionComponent cc) {
    cc.setDefinition(null);
    for (ConceptDefinitionComponent ccc : cc.getConcept()) {
      minify(ccc);
    }
  }

  private void minifyVS(ValueSet vs) {
    minCR(vs);
    
    vs.setApprovalDate(null);
    vs.setLastReviewDate(null);
    vs.setEffectivePeriod(null);
    vs.setTopic(null);
    vs.setAuthor(null);
    vs.setEditor(null);
    vs.setReviewer(null);
    vs.setEndorser(null);
    vs.setRelatedArtifact(null);
    // can't remove anything else
  }

  private boolean minifySD(StructureDefinition sd) {
    if (sd.getKind() == StructureDefinitionKind.LOGICAL) {
      return false;
    }
    minCR(sd);
    sd.setKeyword(null);
    sd.setMapping(null);
    if (sd.hasDifferential()) {
      sd.setSnapshot(null);
    }
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      minifyED(ed);
    }
    return true;
  }

  private void minifyED(ElementDefinition ed) {
    ed.setLabel(null);
    ed.setCode(null);
    ed.getSlicing().setDescription(null);
    ed.setShort(null);
    ed.setDefinition(null);
    ed.setComment(null);
    ed.setRequirements(null);
    ed.setAlias(null);
    ed.setDefaultValue(null);
    ed.setOrderMeaning(null);
    ed.setMeaningWhenMissing(null);
    ed.setExample(null);
    ed.setIsModifierReason(null);
    ed.getBinding().setDescription(null);
    for (ElementDefinitionBindingAdditionalComponent abn : ed.getBinding().getAdditional()) {
      abn.setDocumentation(null);
      abn.setShortDoco(null);
    }
    ed.setMapping(null);
    ed.setMustSupportElement(null);
  }

  private void minCR(CanonicalResource cr) {
    minDR(cr);
    cr.setIdentifier(null);
    cr.setPublisher(null);
    cr.setContact(null);
    cr.setDescription(null);
    cr.setPurpose(null);
    cr.setCopyright(null);
    cr.setCopyrightLabel(null);
  }

  private void minDR(DomainResource dr) {
    minRes(dr);
    dr.setText(null);
    List<Resource> del = new ArrayList<>();
    for (Resource res : dr.getContained()) {
      if (isMinified(res.fhirType())) {
        minify(res);
      } else {
        del.add(res);
      }
    }
    dr.getContained().removeAll(del);
    dr.getExtension().removeIf(ext -> !Utilities.existsInList(ext.getUrl(), VALIDATION_EXTENSIONS));
  }

  private void minRes(Resource res) {
    res.setMeta(null);
    res.setImplicitRules(null);
  }
  
}
