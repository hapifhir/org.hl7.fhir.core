package org.hl7.fhir.r5.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.AdditionalAttributeComponent;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.RelatedArtifact;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.utilities.Utilities;

public class ResourceDependencyWalker {

  public interface IResourceDependencyNotifier {
    public void seeResource(Resource resource, String summaryId);
    public void brokenLink(String link);
  }
  
  public class NullResourceDependencyNotifier implements IResourceDependencyNotifier {

    @Override
    public void seeResource(Resource resource, String summaryId) {
      System.out.println(summaryId);
    }

    @Override
    public void brokenLink(String link) {
      System.err.println("Broken Link: " +link);      
    }
  }
  
  private IResourceDependencyNotifier notifier = new NullResourceDependencyNotifier();
  private IWorkerContext context;
  private Set<String> processedLinks = new HashSet<>();
  private Set<Resource> processedResources = new HashSet<>();
  
  public ResourceDependencyWalker(IWorkerContext context, IResourceDependencyNotifier notifier) {
    super();
    this.notifier = notifier;
    this.context = context;
  }

  public ResourceDependencyWalker(IWorkerContext context) {
    super();
    this.context = context;
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
        Resource tgt = context.fetchResource(Resource.class, value, source);
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
    } else {
      throw new Error("Resource "+res.fhirType()+" not Processed yet");
    }
  }
  

  private void walkSP(SearchParameter sp) {
    walkCR(sp);
    walkIntoLink(sp.getDerivedFrom(), sp);
    for (SearchParameterComponentComponent spc : sp.getComponent()) {
      walkIntoLink(spc.getDefinition(), sp);
    }
  }

  private void walkQ(Questionnaire q) {
    walkCR(q);
    walkCT(q.getDerivedFrom(), q);
    for (QuestionnaireItemComponent item : q.getItem()) {
      walkQItem(item, q);
    }
  }

  private void walkQItem(QuestionnaireItemComponent item, Questionnaire q) {
    walkIntoLink(item.getDefinition(), q);
    walkIntoLink(item.getAnswerValueSet(), q);
    for (QuestionnaireItemEnableWhenComponent ew : item.getEnableWhen()) {
      if (ew.hasAnswerReference()) {
        walkIntoLink(ew.getAnswerReference().getReference(), q);
      }
    }
    for (QuestionnaireItemAnswerOptionComponent ao : item.getAnswerOption()) {
      if (ao.hasValueReference()) {
        walkIntoLink(ao.getValueReference().getReference(), q);
      }
    }
    for (QuestionnaireItemInitialComponent iv : item.getInitial()) {
      if (iv.hasValueReference()) {
        walkIntoLink(iv.getValueReference().getReference(), q);
      }
    }
    walkIntoLink(item.getDefinition(), q);
    for (QuestionnaireItemComponent child : item.getItem()) {
      walkQItem(child, q);
    }
  }

  private void walkOD(OperationDefinition od) {
    walkCR(od);
    walkIntoLink(od.getBase(), od);
    walkIntoLink(od.getInputProfile(), od);
    walkIntoLink(od.getOutputProfile(), od);

    for (OperationDefinitionParameterComponent p : od.getParameter()) {
      walkODP(od, p);
    }
  }

  private void walkODP(OperationDefinition od, OperationDefinitionParameterComponent p) {
    walkCT(p.getTargetProfile(), od);
    walkIntoLink(p.getBinding().getValueSet(), od);
    for (OperationDefinitionParameterComponent pp : p.getPart()) {
      walkODP(od, pp);
    }
  }

  private void walkNS(NamingSystem ns) {
    walkCR(ns);
  }

  private void walkCM(ConceptMap cm) {
    walkCR(cm);
    walkRA(cm.getRelatedArtifact(), cm);
    
    for (org.hl7.fhir.r5.model.ConceptMap.PropertyComponent prop : cm.getProperty()) {
     walkIntoLink(prop.getUri(), cm);
    }
    for (AdditionalAttributeComponent attr : cm.getAdditionalAttribute()) {
      walkIntoLink(attr.getUri(), cm);
    }
    walkIntoLink(cm.getSourceScope().primitiveValue(), cm);
    walkIntoLink(cm.getTargetScope().primitiveValue(), cm);
    
    for (ConceptMapGroupComponent group : cm.getGroup()) {
      walkIntoLink(group.getSource(), cm);
      walkIntoLink(group.getTarget(), cm);
      walkIntoLink(group.getUnmapped().getValueSet(), cm);
      walkIntoLink(group.getUnmapped().getOtherMap(), cm);
      for (SourceElementComponent elem : group.getElement()) {
        walkIntoLink(elem.getValueSet(), cm);
        for (TargetElementComponent tgt : elem.getTarget()) {
          walkIntoLink(tgt.getValueSet(), cm);          
        }
      }
    }
  }

  private void walkCS(CapabilityStatement cs) {
    walkCR(cs);
    walkCT(cs.getInstantiates(), cs);
    walkCT(cs.getImports(), cs);
    walkCT(cs.getImplementationGuide(), cs);
    
    for (CapabilityStatementRestComponent rest : cs.getRest()) {
      
      for (CapabilityStatementRestResourceComponent res : rest.getResource()) {
        walkIntoLink(res.getProfile(), cs);
        walkCT(res.getSupportedProfile(), cs);
        for (CapabilityStatementRestResourceSearchParamComponent srch : res.getSearchParam()) {
          walkIntoLink(srch.getDefinition(), cs);
        }
        for (CapabilityStatementRestResourceOperationComponent op : res.getOperation()) {
          walkIntoLink(op.getDefinition(), cs);
        }
      }
      for (CapabilityStatementRestResourceSearchParamComponent srch : rest.getSearchParam()) {
        walkIntoLink(srch.getDefinition(), cs);
      }
      for (CapabilityStatementRestResourceOperationComponent op : rest.getOperation()) {
        walkIntoLink(op.getDefinition(), cs);
      }
    }
  }
  
  private void walkCS(CodeSystem cs) {
    walkCR(cs);
    walkRA(cs.getRelatedArtifact(), cs);
    if (cs.hasValueSet()) {
      walkIntoLink(cs.getValueSet(), cs);
    }
    if (cs.hasSupplements()) {
      walkIntoLink(cs.getSupplements(), cs);      
    }

    for (PropertyComponent p : cs.getProperty()) {
      if (p.hasUri()) {
        walkIntoLink(p.getUri(), cs);
      }
    }
  }

  private void walkVS(ValueSet vs) {
    walkCR(vs);
    walkRA(vs.getRelatedArtifact(), vs);
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      walkVSInc(inc, vs);
    }
    for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
      walkVSInc(inc, vs);
    }
    if (vs.hasExpansion()) {
      ValueSetExpansionComponent exp = vs.getExpansion();
      for (ValueSetExpansionParameterComponent p : exp.getParameter()) {
        if (p.hasValueUriType()) {
          walkIntoLink(p.getValueUriType().primitiveValue(), vs);
        }
      }
      for (ValueSetExpansionPropertyComponent p : exp.getProperty()) {
        if (p.hasUri()) {
          walkIntoLink(p.getUri(), vs);
        }
      }
      for (ValueSetExpansionContainsComponent cc : exp.getContains()) {
        walkCC(cc, vs);
      }
    }
  }

  private void walkCC(ValueSetExpansionContainsComponent cc, ValueSet vs) {
    walkIntoLink(cc.getSystem(), vs);
    for (ValueSetExpansionContainsComponent ccc : cc.getContains()) {
      walkCC(ccc, vs);
    }
  }

  private void walkVSInc(ConceptSetComponent inc, ValueSet vs) {
    walkCT(inc.getValueSet(), vs);
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
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      walkED(ed, sd);
    }
  }

  private void walkED(ElementDefinition ed, StructureDefinition sd) {
    for (TypeRefComponent type : ed.getType()) {
      if (Utilities.isAbsoluteUrl(type.getCode())) {
        walkIntoLink(type.getCode(), sd);
      }
      walkCT(type.getProfile(), sd);
      walkCT(type.getTargetProfile(), sd);        
    }
    walkCT(ed.getValueAlternatives(), sd);        
    if (ed.hasBinding()) {
      ElementDefinitionBindingComponent b = ed.getBinding();
      if (b.hasValueSet()) {
        walkIntoLink(b.getValueSet(), sd);
      }
      for (ElementDefinitionBindingAdditionalComponent ab : b.getAdditional()) {
        if (ab.hasValueSet()) {
          walkIntoLink(ab.getValueSet(), sd);
        }
        if (ab.hasUsage()) {
          walkUsage(ab.getUsage(), sd);
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
    walkUsage(cr.getUseContext(), cr);
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
