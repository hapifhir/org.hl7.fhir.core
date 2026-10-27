package org.hl7.fhir.services.utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.PropertyComponent;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.ConceptMap.AdditionalAttributeComponent;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.model.core.DomainResource;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.NamingSystem;
import org.hl7.fhir.model.core.OperationDefinition;
import org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.model.core.Questionnaire;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemEnableWhenComponent;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemInitialComponent;
import org.hl7.fhir.model.core.Reference;
import org.hl7.fhir.model.core.RelatedArtifact;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.SearchParameter;
import org.hl7.fhir.model.core.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.fml.StructureMap;
import org.hl7.fhir.model.core.UriType;
import org.hl7.fhir.model.core.UsageContext;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.ValueSet.ConceptSetComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionPropertyComponent;

import org.hl7.fhir.utilities.Utilities;


@Slf4j
public class ResourceDependencyWalker {

  public interface IResourceDependencyNotifier {
    public void seeResource(Resource resource, String summaryId);
    public void brokenLink(String link);
  }
  
  public class NullResourceDependencyNotifier implements IResourceDependencyNotifier {

    @Override
    public void seeResource(Resource resource, String summaryId) {
      log.info(summaryId);
    }

    @Override
    public void brokenLink(String link) {
      log.error("Broken Link: " +link);
    }
  }
  
  private IResourceDependencyNotifier notifier = new NullResourceDependencyNotifier();
  private IWorkerContext context;
  private Set<String> processedLinks = new HashSet<>();
  private Set<Resource> processedResources = new HashSet<>();
  // Off by default: walking into StructureMap rule expressions catches ConceptMaps
  // referenced via `translate(<canonical>, ...)` and similar in-rule URLs, but
  // surfaces a lot of churn that callers don't always want.
  private boolean includeRuleReferences = false;
  
  public ResourceDependencyWalker(IWorkerContext context, IResourceDependencyNotifier notifier) {
    super();
    this.notifier = notifier;
    this.context = context;
  }

  public ResourceDependencyWalker(IWorkerContext context) {
    super();
    this.context = context;
  }

  /**
   * When true, the walker also follows ConceptMap and similar canonical URLs
   * that appear as parameters of rule-level transforms inside a {@link StructureMap}
   * (notably {@code translate(<concept-map>, code, ...)}). Default: false.
   */
  public ResourceDependencyWalker setIncludeRuleReferences(boolean includeRuleReferences) {
    this.includeRuleReferences = includeRuleReferences;
    return this;
  }
  
  private void notify(Resource resource, String prefix) {
    String summary = null;
    if (resource instanceof CanonicalResource) {
      summary = ((CanonicalResource) resource).getVersionedUrl();
    } else {
      summary = resource.fhirType()+"/"+resource.getIdPart();
    }
    if (resource.getSourcePackage() != null) {
      summary = summary + " from "+resource.getSourcePackage();
    }
    notifier.seeResource(resource, prefix+summary);
  }
    
  public void walk(Resource res) {
    notify(res, "Find Dependencies for ");
    processedResources.add(res);
    doWalk(res);
  }

  private void walkIntoLink(String value, CanonicalResource source) {
    if (value != null ) {
      String key = source.getSourcePackage() == null ? value : value+" from "+source.getSourcePackage().getVID();
      if (!processedLinks.contains(key)) {
        processedLinks.add(key);
        Resource tgt = context.fetchResource(Resource.class, value, VersionResolutionRules.defaultRule(), null, source);
        if (tgt == null && Utilities.charCount(value, '/') == 1) {
          tgt = context.fetchResourceById(value.substring(0, value.indexOf('/')), value.substring(value.indexOf('/')+1));
        }
        if (tgt == null) {
          notifier.brokenLink(key);
        } else {
          if (!processedResources.contains(tgt) && !isCore(tgt)) {
            processedResources.add(tgt);
            notify(tgt, "Depends On ");
            doWalk(tgt);
          }
        }
      }
    }
  }

  private boolean isCore(Resource tgt) {
    return tgt.hasSourcePackage() && "hl7.fhir.r5.core".equals(tgt.getSourcePackage().getId());
  }

  private void doWalk(Resource res) {
    if (res instanceof StructureDefinition) {
      walkSD((StructureDefinition) res);
    } else if (res instanceof ValueSet) {
      walkVS((ValueSet) res);
    } else if (res instanceof CodeSystem) {
      walkCS((CodeSystem) res);
    } else if (res instanceof CapabilityStatement) {
      walkCS((CapabilityStatement) res);
    } else if (res instanceof ConceptMap) {
      walkCM((ConceptMap) res);
    } else if (res instanceof NamingSystem) {
      walkNS((NamingSystem) res);
    } else if (res instanceof OperationDefinition) {
      walkOD((OperationDefinition) res);
    } else if (res instanceof SearchParameter) {
      walkSP((SearchParameter) res);
    } else if (res instanceof Questionnaire) {
      walkQ((Questionnaire) res);
    } else if (res instanceof StructureMap) {
      walkSM((StructureMap) res);
    } else {
      throw new Error("Resource "+res.fhirType()+" not Processed yet");
    }
  }

  private void walkSM(StructureMap sm) {
    walkCR(sm);
    // The source/target StructureDefinitions referenced by `structure[].url`.
    for (StructureMap.StructureMapStructureComponent s : sm.getStructureList()) {
      walkIntoLink(s.getUrl(), sm);
    }
    // Other StructureMaps pulled in via `import`.
    walkCT(sm.getImportList(), sm);
    // Rule-level references — only when opted in (see setIncludeRuleReferences).
    if (includeRuleReferences) {
      for (StructureMap.StructureMapGroupComponent g : sm.getGroupList()) {
        for (StructureMap.StructureMapGroupRuleComponent r : g.getRuleList()) {
          walkSMRule(r, sm);
        }
      }
    }
  }

  private void walkSMRule(StructureMap.StructureMapGroupRuleComponent rule, StructureMap sm) {
    for (StructureMap.StructureMapGroupRuleTargetComponent target : rule.getTargetList()) {
      // `translate(<concept-map>, code, "code")` — the first parameter is a ConceptMap canonical.
      if (target.getTransform() == StructureMap.StructureMapTransform.TRANSLATE
          && !target.getParameterList().isEmpty()) {
        org.hl7.fhir.model.core.DataType v = target.getParameterList().get(0).getValue();
        if (v != null && v.hasPrimitiveValue()) {
          walkIntoLink(v.primitiveValue(), sm);
        }
      }
    }
    for (StructureMap.StructureMapGroupRuleComponent nested : rule.getRuleList()) {
      walkSMRule(nested, sm);
    }
  }
  

  private void walkSP(SearchParameter sp) {
    walkCR(sp);
    walkIntoLink(sp.getDerivedFrom(), sp);
    for (SearchParameterComponentComponent spc : sp.getComponentList()) {
      walkIntoLink(spc.getDefinition(), sp);
    }
  }

  private void walkQ(Questionnaire q) {
    walkCR(q);
    walkCT(q.getDerivedFromList(), q);
    for (QuestionnaireItemComponent item : q.getItemList()) {
      walkQItem(item, q);
    }
  }

  private void walkQItem(QuestionnaireItemComponent item, Questionnaire q) {
    for (UriType def : item.getDefinitionList()) {
      walkIntoLink(def.getValue(), q);
    }
    walkIntoLink(item.getAnswerValueSet(), q);
    for (QuestionnaireItemEnableWhenComponent ew : item.getEnableWhenList()) {
      if (ew.hasAnswerReference()) {
        walkIntoLink(ew.getAnswerReference().getReference(), q);
      }
    }
    for (QuestionnaireItemAnswerOptionComponent ao : item.getAnswerOptionList()) {
      if (ao.hasValueReference()) {
        walkIntoLink(ao.getValueReference().getReference(), q);
      }
    }
    for (QuestionnaireItemInitialComponent iv : item.getInitialList()) {
      if (iv.hasValueReference()) {
        walkIntoLink(iv.getValueReference().getReference(), q);
      }
    }
    for (UriType def : item.getDefinitionList()) {
      walkIntoLink(def.getValue(), q);
    }
    for (QuestionnaireItemComponent child : item.getItemList()) {
      walkQItem(child, q);
    }
  }

  private void walkOD(OperationDefinition od) {
    walkCR(od);
    walkIntoLink(od.getBase(), od);
    walkIntoLink(od.getInputProfile(), od);
    walkIntoLink(od.getOutputProfile(), od);

    for (OperationDefinitionParameterComponent p : od.getParameterList()) {
      walkODP(od, p);
    }
  }

  private void walkODP(OperationDefinition od, OperationDefinitionParameterComponent p) {
    walkCT(p.getTargetProfileList(), od);
    walkIntoLink(p.getBinding().getValueSet(), od);
    for (OperationDefinitionParameterComponent pp : p.getPartList()) {
      walkODP(od, pp);
    }
  }

  private void walkNS(NamingSystem ns) {
    walkCR(ns);
  }

  private void walkCM(ConceptMap cm) {
    walkCR(cm);
    walkRA(cm.getRelatedArtifactList(), cm);
    
    for (org.hl7.fhir.model.core.ConceptMap.PropertyComponent prop : cm.getPropertyList()) {
     walkIntoLink(prop.getUri(), cm);
    }
    for (AdditionalAttributeComponent attr : cm.getAdditionalAttributeList()) {
      walkIntoLink(attr.getUri(), cm);
    }
    walkIntoLink(cm.getSourceScope().primitiveValue(), cm);
    walkIntoLink(cm.getTargetScope().primitiveValue(), cm);
    
    for (ConceptMapGroupComponent group : cm.getGroupList()) {
      walkIntoLink(group.getSource(), cm);
      walkIntoLink(group.getTarget(), cm);
      walkIntoLink(group.getUnmapped().getValueSet(), cm);
      walkIntoLink(group.getUnmapped().getOtherMap(), cm);
      for (SourceElementComponent elem : group.getElementList()) {
        walkIntoLink(elem.getValueSet(), cm);
        for (TargetElementComponent tgt : elem.getTargetList()) {
          walkIntoLink(tgt.getValueSet(), cm);          
        }
      }
    }
  }

  private void walkCS(CapabilityStatement cs) {
    walkCR(cs);
    walkCT(cs.getInstantiatesList(), cs);
    walkCT(cs.getImportsList(), cs);
    walkCT(cs.getImplementationGuideList(), cs);
    
    for (CapabilityStatementRestComponent rest : cs.getRestList()) {
      
      for (CapabilityStatementRestResourceComponent res : rest.getResourceList()) {
        walkIntoLink(res.getProfile(), cs);
        walkCT(res.getSupportedProfileList(), cs);
        for (CapabilityStatementRestResourceSearchParamComponent srch : res.getSearchParamList()) {
          walkIntoLink(srch.getDefinition(), cs);
        }
        for (CapabilityStatementRestResourceOperationComponent op : res.getOperationList()) {
          walkIntoLink(op.getDefinition(), cs);
        }
      }
      for (CapabilityStatementRestResourceSearchParamComponent srch : rest.getSearchParamList()) {
        walkIntoLink(srch.getDefinition(), cs);
      }
      for (CapabilityStatementRestResourceOperationComponent op : rest.getOperationList()) {
        walkIntoLink(op.getDefinition(), cs);
      }
    }
  }
  
  private void walkCS(CodeSystem cs) {
    walkCR(cs);
    walkRA(cs.getRelatedArtifactList(), cs);
    if (cs.hasValueSet()) {
      walkIntoLink(cs.getValueSet(), cs);
    }
    if (cs.hasSupplements()) {
      walkIntoLink(cs.getSupplements(), cs);      
    }

    for (PropertyComponent p : cs.getPropertyList()) {
      if (p.hasUri()) {
        walkIntoLink(p.getUri(), cs);
      }
    }
  }

  private void walkVS(ValueSet vs) {
    walkCR(vs);
    walkRA(vs.getRelatedArtifactList(), vs);
    for (ConceptSetComponent inc : vs.getCompose().getIncludeList()) {
      walkVSInc(inc, vs);
    }
    for (ConceptSetComponent inc : vs.getCompose().getExcludeList()) {
      walkVSInc(inc, vs);
    }
    if (vs.hasExpansion()) {
      ValueSetExpansionComponent exp = vs.getExpansion();
      for (ValueSetExpansionParameterComponent p : exp.getParameterList()) {
        if (p.hasValueUriType()) {
          walkIntoLink(p.getValueUriType().primitiveValue(), vs);
        }
      }
      for (ValueSetExpansionPropertyComponent p : exp.getPropertyList()) {
        if (p.hasUri()) {
          walkIntoLink(p.getUri(), vs);
        }
      }
      for (ValueSetExpansionContainsComponent cc : exp.getContainsList()) {
        walkCC(cc, vs);
      }
    }
  }

  private void walkCC(ValueSetExpansionContainsComponent cc, ValueSet vs) {
    walkIntoLink(cc.getSystem(), vs);
    for (ValueSetExpansionContainsComponent ccc : cc.getContainsList()) {
      walkCC(ccc, vs);
    }
  }

  private void walkVSInc(ConceptSetComponent inc, ValueSet vs) {
    walkCT(inc.getValueSetList(), vs);
    walkIntoLink(inc.getSystem(), vs);
  }

  private void walkCT(List<CanonicalType> list, CanonicalResource source) {
    for (CanonicalType ct : list) {
      walkIntoLink(ct.getValue(), source);
    }
  }

  private void walkRA(List<RelatedArtifact> list, CanonicalResource source) {
    for (RelatedArtifact ra : list) {
      walkRA(ra, source);
    }
  }

  private void walkRA(RelatedArtifact ra, CanonicalResource source) {
    if (ra.hasResource()) {
      walkIntoLink(ra.getResource(), source);
    }
    if (ra.hasResourceReference()) {
      walkIntoLink(ra.getResourceReference().getReference(), source);
    }    
  }

  private void walkSD(StructureDefinition sd) {
    walkCR(sd);
    walkIntoLink(sd.getBaseDefinition(), sd);
    for (ElementDefinition ed : sd.getDifferential().getElementList()) {
      walkED(ed, sd);
    }
  }

  private void walkED(ElementDefinition ed, StructureDefinition sd) {
    for (TypeRefComponent type : ed.getTypeList()) {
      if (Utilities.isAbsoluteUrl(type.getCode())) {
        walkIntoLink(type.getCode(), sd);
      }
      walkCT(type.getProfileList(), sd);
      walkCT(type.getTargetProfileList(), sd);        
    }
    walkCT(ed.getValueAlternativesList(), sd);        
    if (ed.hasBinding()) {
      ElementDefinitionBindingComponent b = ed.getBinding();
      if (b.hasValueSet()) {
        walkIntoLink(b.getValueSet(), sd);
      }
      for (ElementDefinitionBindingAdditionalComponent ab : b.getAdditionalList()) {
        if (ab.hasValueSet()) {
          walkIntoLink(ab.getValueSet(), sd);
        }
        if (ab.hasUsage()) {
          walkUsage(ab.getUsageList(), sd);
        }
      }
    }
  }

  private void walkUsage(List<UsageContext> usageList, CanonicalResource source) {
    for (UsageContext usage : usageList) {
      walkUsage(usage, source);
    }
  }

  private void walkUsage(UsageContext usage, CanonicalResource source) {
    if (usage.hasValueReference()) {
      walkReference(usage.getValueReference(), source);
    }
  }

  private void walkReference(Reference ref, CanonicalResource source) {
    if (ref.hasReference()) {
      walkIntoLink(ref.getReference(), source);
    }
  }

  private void walkCR(CanonicalResource cr) {
    walkDR(cr);
    walkUsage(cr.getUseContextList(), cr);
  }

  private void walkDR(DomainResource dr) {
    walkRes(dr);
    for (Resource res : dr.getContained()) {
      walk(res);
    }
  }

  private void walkRes(Resource res) {
    // nothing
  }
  
  
}
