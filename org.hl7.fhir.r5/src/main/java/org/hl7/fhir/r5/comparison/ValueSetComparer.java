package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.renderers.CodeSystemRenderer;
import org.hl7.fhir.r5.renderers.ValueSetRenderer;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class ValueSetComparer extends CanonicalResourceComparer {

  public class ValueSetComparison extends CanonicalResourceComparison<ValueSet> {

    public ValueSetComparison(ValueSet left, ValueSet right) {
      super(left, right);
    }
    
    private StructuralMatch<Element> includes = new StructuralMatch<>();       
    private StructuralMatch<Element> excludes = new StructuralMatch<>();       
    private StructuralMatch<ValueSetExpansionContainsComponent> expansion;
    
    public StructuralMatch<Element> getIncludes() {
      return includes;
    }
    
    public StructuralMatch<Element> getExcludes() {
      return excludes;
    }
    
    public StructuralMatch<ValueSetExpansionContainsComponent> getExpansion() {
      return expansion;
    }         

    public StructuralMatch<ValueSetExpansionContainsComponent> forceExpansion() {
      if (expansion == null) {
        expansion = new StructuralMatch<>();
      }
      return expansion;
    }

    @Override
    protected String abbreviation() {
      return "vs";
    }

    @Override
    protected String summary() {
      String res = "ValueSet: "+left.present()+" vs "+right.present();
      String ch = changeSummary();
      if (ch != null) {
        res = res + ". "+ch;
      }
      return res;
    }

    @Override
    protected String fhirType() {
      return "ValueSet";
    }         
    @Override
    protected void countMessages(MessageCounts cnts) {
      super.countMessages(cnts);
      if (includes != null) {
        includes.countMessages(cnts);
      }
      if (excludes != null) {
        excludes.countMessages(cnts);
      }
      if (expansion != null) {
        expansion.countMessages(cnts);
      }
    }

  }
  
  public ValueSetComparer(ComparisonSession session) {
    super(session);
  }

  public ValueSetComparison compare(ValueSet left, ValueSet right) {  
    if (left == null)
      throw new DefinitionException("No ValueSet provided (left)");
    if (right == null)
      throw new DefinitionException("No ValueSet provided (right)");
    
    ValueSetComparison res = new ValueSetComparison(left, right);
    session.identify(res);
    ValueSet vs = new ValueSet();
    res.setUnion(vs);
    session.identify(vs);
    vs.setName("Union"+left.getName()+"And"+right.getName());
    vs.setTitle("Union of "+left.getTitle()+" And "+right.getTitle());
    vs.setStatus(left.getStatus());
    vs.setDate(new Date());
   
    ValueSet vs1 = new ValueSet();
    res.setIntersection(vs1);
    session.identify(vs1);
    vs1.setName("Intersection"+left.getName()+"And"+right.getName());
    vs1.setTitle("Intersection of "+left.getTitle()+" And "+right.getTitle());
    vs1.setStatus(left.getStatus());
    vs1.setDate(new Date());
   
    List<String> chMetadata = new ArrayList<>();
    var ch = compareMetadata(left, right, res.getMetadata(), res, chMetadata, right);
    var def = false;
    if (comparePrimitives("immutable", left.getImmutableElement(), right.getImmutableElement(), res.getMetadata(), IssueSeverity.WARNING, res)) {
      ch = true;
      chMetadata.add("immutable");
    }
    if (left.hasCompose() || right.hasCompose()) {
      if (comparePrimitives("compose.lockedDate", left.getCompose().getLockedDateElement(), right.getCompose().getLockedDateElement(), res.getMetadata(), IssueSeverity.WARNING, res)) {
        ch = true;
        chMetadata.add("compose.lockedDate");
      }
      def = comparePrimitives("compose.inactive", left.getCompose().getInactiveElement(), right.getCompose().getInactiveElement(), res.getMetadata(), IssueSeverity.WARNING, res) || def;      
    }
    res.updatedMetadataState(ch, chMetadata);
        
    def = compareCompose(left.getCompose(), right.getCompose(), res, res.getUnion().getCompose(), res.getIntersection().getCompose()) || def;
    res.updateDefinitionsState(def);
//    compareExpansions(left, right, res);
    session.annotate(right, res);
    return res;
  }

  private boolean compareCompose(ValueSetComposeComponent left, ValueSetComposeComponent right, ValueSetComparison res, ValueSetComposeComponent union, ValueSetComposeComponent intersection) {
    boolean def = false;
    // first, the includes
    List<ConceptSetComponent> matchR = new ArrayList<>();
    for (ConceptSetComponent l : left.getInclude()) {
      ConceptSetComponent r = findInList(right.getInclude(), l, left.getInclude());
      if (r == null) {
        union.getInclude().add(l);
        res.updateContentState(true);
        res.getIncludes().getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed Include", "ValueSet.compose.include")));
        session.markDeleted(right,  "include", l);
      } else {
        matchR.add(r);
        ConceptSetComponent csM = new ConceptSetComponent();
        ConceptSetComponent csI = new ConceptSetComponent();
        union.getInclude().add(csM);
        intersection.getInclude().add(csI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        res.getIncludes().getChildren().add(sm);
        def = compareDefinitions("ValueSet.compose.include["+right.getInclude().indexOf(r)+"]", l, r, sm, csM, csI, res) || def;
      }
    }
    for (ConceptSetComponent r : right.getInclude()) {
      if (!matchR.contains(r)) {
        union.getInclude().add(r);
        res.updateContentState(true);
        res.getIncludes().getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added Include", "ValueSet.compose.include"), r));  
        session.markAdded(r);
      }
    }
    
    // now. the excludes
    matchR.clear();
    for (ConceptSetComponent l : left.getExclude()) {
      ConceptSetComponent r = findInList(right.getExclude(), l, left.getExclude());
      if (r == null) {
        union.getExclude().add(l);
        res.updateContentState(true);
        res.getExcludes().getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed Exclude", "ValueSet.compose.exclude")));
      } else {
        matchR.add(r);
        ConceptSetComponent csM = new ConceptSetComponent();
        ConceptSetComponent csI = new ConceptSetComponent();
        union.getExclude().add(csM);
        intersection.getExclude().add(csI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        res.getExcludes().getChildren().add(sm);
        def = compareDefinitions("ValueSet.compose.exclude["+right.getExclude().indexOf(r)+"]", l, r, sm, csM, csI, res) || def;
      }
    }
    for (ConceptSetComponent r : right.getExclude()) {
      if (!matchR.contains(r)) {
        union.getExclude().add(r);
        res.updateContentState(true);
        res.getExcludes().getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added Exclude", "ValueSet.compose.exclude"), r));        
      }
    }
    return def;
  }

  private ConceptSetComponent findInList(List<ConceptSetComponent> matches, ConceptSetComponent item, List<ConceptSetComponent> source) {
    if (matches.size() == 1 && source.size() == 1) {
      return matches.get(0);      
    }
    int matchCount = countMatchesBySystem(matches, item); 
    int sourceCount = countMatchesBySystem(source, item); 

    if (matchCount == 1 && sourceCount == 1) {
      for (ConceptSetComponent t : matches) {
        if (t.getSystem() != null && t.getSystem().equals(item.getSystem())) {
          return t;
        }
      }
    }
    // if there's more than one candidate match by system, then we look for a full match
    for (ConceptSetComponent t : matches) {
      if (t.equalsDeep(item)) {
        return t;
      }
    }
    return null;
  }

  private int countMatchesBySystem(List<ConceptSetComponent> list, ConceptSetComponent item) {
    int c = 0;
    for (ConceptSetComponent t : list) {
      if (t.hasSystem() && t.getSystem().equals(item.getSystem())) {
        c++;
      }
    }
    return c;
  }


  private boolean compareDefinitions(String path, ConceptSetComponent left, ConceptSetComponent right, StructuralMatch<Element> combined, ConceptSetComponent union, ConceptSetComponent intersection, ValueSetComparison res) {
    boolean def = false;
    // system must match, but the rest might not. we're going to do the full comparison whatever, so the outcome looks consistent to the user    
    List<CanonicalType> matchVSR = new ArrayList<>();
    for (CanonicalType l : left.getValueSet()) {
      CanonicalType r = findInList(right.getValueSet(), l, left.getValueSet());
      if (r == null) {
        union.getValueSet().add(l);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.ERROR, "Removed ValueSet", "ValueSet.compose.include.valueSet")));
        if (session.isAnnotate()) {
          session.markDeleted(right,  "valueset", l);
        }
      } else {
        matchVSR.add(r);
        if (l.getValue().equals(r.getValue())) {
          union.getValueSet().add(l);
          intersection.getValueSet().add(l);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r, null);
          combined.getChildren().add(sm);          
        } else {
          // it's not possible to get here?
          union.getValueSet().add(l);
          union.getValueSet().add(r);
          res.updateContentState(true);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r, vmI(IssueSeverity.WARNING, "Values are different", "ValueSet.compose.include.valueSet"));
          combined.getChildren().add(sm);            
          if (session.isAnnotate()) {
            session.markChanged(r,  l);
          }           

        }
      }
    }
    for (CanonicalType r : right.getValueSet()) {
      if (!matchVSR.contains(r)) {
        union.getValueSet().add(r);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.ERROR, "Add ValueSet", "ValueSet.compose.include.valueSet"), r));  
        session.markAdded(r);
      }
    }
    
    List<ConceptReferenceComponent> matchCR = new ArrayList<>();
    for (ConceptReferenceComponent l : left.getConcept()) {
      ConceptReferenceComponent r = findInList(right.getConcept(), l, left.getConcept());
      if (r == null) {
        union.getConcept().add(l);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.ERROR, "Removed this Concept", "ValueSet.compose.include.concept")));
        res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, "Code "+l.getCode()+" removed", IssueSeverity.ERROR));
        session.markDeleted(right,"concept", l);
      } else {
        matchCR.add(r);
        if (l.getCode().equals(r.getCode())) {
          ConceptReferenceComponent cu = new ConceptReferenceComponent();
          ConceptReferenceComponent ci = new ConceptReferenceComponent();
          union.getConcept().add(cu);
          intersection.getConcept().add(ci);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
          combined.getChildren().add(sm);
          def = compareConcepts(path+".concept["+right.getConcept().indexOf(r)+"]", l, r, sm, cu, ci, res) || def;
        } else {
          // not that it's possible to get here?
          union.getConcept().add(l);
          union.getConcept().add(r);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r, vmI(IssueSeverity.WARNING, "Concepts are different", "ValueSet.compose.include.concept"));
          combined.getChildren().add(sm);
          res.updateContentState(true);
          compareConcepts(path+".concept["+right.getConcept().indexOf(r)+"]", l, r, sm, null, null, res);
          session.markChanged(r, l);
        }
      }
    }
    for (ConceptReferenceComponent r : right.getConcept()) {
      if (!matchCR.contains(r)) {
        union.getConcept().add(r);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.ERROR, "Added this Concept", "ValueSet.compose.include.concept"), r)); 
        res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, "Code "+r.getCode()+" added", IssueSeverity.ERROR));
        session.markAdded(r);
      }
    }
    
    List<ConceptSetFilterComponent> matchFR = new ArrayList<>();
    for (ConceptSetFilterComponent l : left.getFilter()) {
      ConceptSetFilterComponent r = findInList(right.getFilter(), l, left.getFilter());
      if (r == null) {
        union.getFilter().add(l);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.ERROR, "Removed this item", "ValueSet.compose.include.filter")));
        session.markDeleted(right, "filter", l);
      } else {
        matchFR.add(r);
        if (l.getProperty().equals(r.getProperty()) && l.getOp().equals(r.getOp())) {
          ConceptSetFilterComponent cu = new ConceptSetFilterComponent();
          ConceptSetFilterComponent ci = new ConceptSetFilterComponent();
          union.getFilter().add(cu);
          intersection.getFilter().add(ci);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
          combined.getChildren().add(sm);
          if (compareFilters(l, r, sm, cu, ci)) {
            res.updateContentState(true);       
            session.markChanged(r, l);
          }
        } else {
          union.getFilter().add(l);
          union.getFilter().add(r);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r, vmI(IssueSeverity.WARNING, "Codes are different", "ValueSet.compose.include.filter"));
          res.updateContentState(true);            
          combined.getChildren().add(sm);
          compareFilters(l, r, sm, null, null);
        }
      }
    }
    for (ConceptSetFilterComponent r : right.getFilter()) {
      if (!matchFR.contains(r)) {
        union.getFilter().add(r);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.ERROR, "Added this item", "ValueSet.compose.include.filter"), r));  
        session.markAdded(r);
      }
    }
    return def;
  }

  private boolean compareConcepts(String path, ConceptReferenceComponent l, ConceptReferenceComponent r, StructuralMatch<Element> sm, ConceptReferenceComponent cu,  ConceptReferenceComponent ci, ValueSetComparison res) {
    boolean def = false;
    sm.getChildren().add(new StructuralMatch<Element>(l.getCodeElement(), r.getCodeElement(), l.getCode().equals(r.getCode()) ? null : vmI(IssueSeverity.INFORMATION, "Codes do not match", "ValueSet.compose.include.concept")));
    if (ci != null) {
      ci.setCode(l.getCode());
      cu.setCode(l.getCode());
    }
    if (l.hasDisplay() && r.hasDisplay()) {
      sm.getChildren().add(new StructuralMatch<Element>(l.getDisplayElement(), r.getDisplayElement(), l.getDisplay().equals(r.getDisplay()) ? null : vmI(IssueSeverity.INFORMATION, "Displays do not match", "ValueSet.compose.include.concept")));
      if (ci != null) {
        ci.setDisplay(r.getDisplay());
        cu.setDisplay(r.getDisplay());
      }
      def = !l.getDisplay().equals(r.getDisplay());
      if (def) {
        res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, "Code "+l.getCode()+" display changed from '"+l.getDisplay()+"' to '"+r.getDisplay()+"'", IssueSeverity.WARNING));
        session.markChanged(r.getDisplayElement(),  l.getDisplayElement());
      }
    } else if (l.hasDisplay()) {
      session.markDeleted(r, "display", l.getDisplayElement());
      res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, "Code "+l.getCode()+" display '"+l.getDisplay()+"' removed", IssueSeverity.WARNING));
      sm.getChildren().add(new StructuralMatch<Element>(l.getDisplayElement(), null, vmI(IssueSeverity.INFORMATION, "Display Removed", "ValueSet.compose.include.concept")));
      if (ci != null) {
        ci.setDisplay(l.getDisplay());
        cu.setDisplay(l.getDisplay());
      }
      def = true;
    } else if (r.hasDisplay()) {
      session.markAdded(r.getDisplayElement());
      res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path, "Code "+l.getCode()+" display '"+r.getDisplay()+"' added", IssueSeverity.WARNING));
      sm.getChildren().add(new StructuralMatch<Element>(null, r.getDisplayElement(), vmI(IssueSeverity.INFORMATION, "Display added", "ValueSet.compose.include.concept")));
      if (ci != null) {
        ci.setDisplay(r.getDisplay());
        cu.setDisplay(r.getDisplay());
      }
      def = true;
    } else {
      sm.getChildren().add(new StructuralMatch<Element>(null, null, vmI(IssueSeverity.INFORMATION, "No Display", "ValueSet.compose.include.concept")));
    }
    return def;
  }

  private boolean compareFilters(ConceptSetFilterComponent l, ConceptSetFilterComponent r, StructuralMatch<Element> sm, ConceptSetFilterComponent cu,  ConceptSetFilterComponent ci) {
    sm.getChildren().add(new StructuralMatch<Element>(l.getPropertyElement(), r.getPropertyElement(), l.getProperty().equals(r.getProperty()) ? null : vmI(IssueSeverity.INFORMATION, "Properties do not match", "ValueSet.compose.include.concept")));
    sm.getChildren().add(new StructuralMatch<Element>(l.getOpElement(), r.getOpElement(), l.getOp().equals(r.getOp()) ? null : vmI(IssueSeverity.INFORMATION, "Filter Operations do not match", "ValueSet.compose.include.concept")));
    sm.getChildren().add(new StructuralMatch<Element>(l.getValueElement(), r.getValueElement(), l.getValue().equals(r.getValue()) ? null : vmI(IssueSeverity.INFORMATION, "Values do not match", "ValueSet.compose.include.concept")));
    if (ci != null) {
      ci.setProperty(l.getProperty());
      ci.setOp(l.getOp());
      ci.setValue(l.getValue());
      cu.setProperty(l.getProperty());
      cu.setOp(l.getOp());
      cu.setValue(l.getValue());
    }
    return !l.getValue().equals(r.getValue());
  }
  
  private CanonicalType findInList(List<CanonicalType> matches, CanonicalType item, List<CanonicalType> source) {
    if (matches.size() == 1 && source.size() == 1) {
      return matches.get(0);      
    }
    for (CanonicalType t : matches) {
      if (t.getValue().equals(item.getValue())) {
        return t;
      }
    }
    return null;
  }

  private ConceptReferenceComponent findInList(List<ConceptReferenceComponent> matches, ConceptReferenceComponent item, List<ConceptReferenceComponent> source) {
    if (matches.size() == 1 && source.size() == 1) {
      return matches.get(0);      
    }
    for (ConceptReferenceComponent t : matches) {
      if (t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }

  private ConceptSetFilterComponent findInList(List<ConceptSetFilterComponent> matches, ConceptSetFilterComponent item, List<ConceptSetFilterComponent> source) {
    if (matches.size() == 1 && source.size() == 1) {
      return matches.get(0);      
    }
    for (ConceptSetFilterComponent t : matches) {
      if (t.getProperty().equals(item.getProperty()) && t.getOp().equals(item.getOp()) ) {
        return t;
      }
    }
    return null;
  }

  private void compareExpansions(ValueSet left, ValueSet right, ValueSetComparison res) {
    ValueSet expL = left.hasExpansion() ? left : expand(left, res, "left", session.getContextLeft());
    ValueSet expR = right.hasExpansion() ? right : expand(right, res, "right", session.getContextRight());
    if (expL != null && expR != null) {
      // ignore the parameters for now
      compareConcepts(expL.getExpansion().getContains(), expR.getExpansion().getContains(), res.forceExpansion(), res.getUnion().getExpansion().getContains(), res.getIntersection().getExpansion().getContains(), "ValueSet.expansion.contains", res);
    }
  }
  
  private ValueSet expand(ValueSet vs, ValueSetComparison res, String name, IWorkerContext ctxt) {
    ValueSetExpansionOutcome vse = ctxt.expandVS(vs, true, false);
    if (vse.getValueset() != null) {
      return vse.getValueset();
    } else {
      res.getMessages().add(new ValidationMessage(Source.TerminologyEngine, IssueType.EXCEPTION, "ValueSet", "Error Expanding "+name+":"+vse.getError(), IssueSeverity.ERROR));
      return null;
    }
  }  

  private void compareConcepts(List<ValueSetExpansionContainsComponent> left, List<ValueSetExpansionContainsComponent> right, StructuralMatch<ValueSetExpansionContainsComponent> combined, List<ValueSetExpansionContainsComponent> union, List<ValueSetExpansionContainsComponent> intersection, String path, ValueSetComparison res) {
    List<ValueSetExpansionContainsComponent> matchR = new ArrayList<>();
    for (ValueSetExpansionContainsComponent l : left) {
      ValueSetExpansionContainsComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<ValueSetExpansionContainsComponent>(l, vmI(IssueSeverity.INFORMATION, "Removed from expansion", path)));
      } else {
        matchR.add(r);
        ValueSetExpansionContainsComponent ccU = merge(l, r);
        ValueSetExpansionContainsComponent ccI = intersect(l, r);
        union.add(ccU);
        intersection.add(ccI);
        StructuralMatch<ValueSetExpansionContainsComponent> sm = new StructuralMatch<ValueSetExpansionContainsComponent>(l, r);
        compareItem(sm.getMessages(), path, l, r, res);
        combined.getChildren().add(sm);
        compareConcepts(l.getContains(), r.getContains(), sm, ccU.getContains(), ccI.getContains(), path+".where(code = '"+l.getCode()+"').contains", res);
      }
    }
    for (ValueSetExpansionContainsComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<ValueSetExpansionContainsComponent>(vmI(IssueSeverity.INFORMATION, "Added to expansion", path), r));        
      }
    }
  }

  private void compareItem(List<ValidationMessage> msgs, String path, ValueSetExpansionContainsComponent l, ValueSetExpansionContainsComponent r, ValueSetComparison res) {
    compareStrings(path, msgs, l.getDisplay(), r.getDisplay(), "display", IssueSeverity.WARNING, res);
  }

  private void compareStrings(String path, List<ValidationMessage> msgs, String left, String right, String name, IssueSeverity level, ValueSetComparison res) {
    if (!Utilities.noString(right)) {
      if (Utilities.noString(left)) {
        msgs.add(vmI(level, "Value for "+name+" added", path));
      } else if (!left.equals(right)) {
        if (level != IssueSeverity.NULL) {
          res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+".name", "Changed value for "+name+": '"+left+"' vs '"+right+"'", level));
        }
        msgs.add(vmI(level, name+" changed from left to right", path));
      }
    } else if (!Utilities.noString(left)) {
      msgs.add(vmI(level, "Value for "+name+" removed", path));
    }
  }

  private ValueSetExpansionContainsComponent findInList(List<ValueSetExpansionContainsComponent> list, ValueSetExpansionContainsComponent item) {
    for (ValueSetExpansionContainsComponent t : list) {
      if (t.getSystem().equals(item.getSystem()) && t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }

  private ValueSetExpansionContainsComponent intersect(ValueSetExpansionContainsComponent l, ValueSetExpansionContainsComponent r) {
    ValueSetExpansionContainsComponent res = new ValueSetExpansionContainsComponent();
    if (l.hasAbstract() && r.hasAbstract()) {
      res.setAbstract(l.getAbstract());
    }
    if (l.hasCode() && r.hasCode()) {
      res.setCode(l.getCode());
    }
    if (l.hasSystem() && r.hasSystem()) {
      res.setSystem(l.getSystem());
    }
    if (l.hasVersion() && r.hasVersion()) {
      res.setVersion(l.getVersion());
    }
    if (l.hasDisplay() && r.hasDisplay()) {
      res.setDisplay(l.getDisplay());
    }
    return res;
  }

  private ValueSetExpansionContainsComponent merge(ValueSetExpansionContainsComponent l, ValueSetExpansionContainsComponent r) {
    ValueSetExpansionContainsComponent res = new ValueSetExpansionContainsComponent();
    if (l.hasAbstract()) {
      res.setAbstract(l.getAbstract());
    } else if (r.hasAbstract()) {
      res.setAbstract(r.getAbstract());
    }
    if (l.hasCode()) {
      res.setCode(l.getCode());
    } else if (r.hasCode()) {
      res.setCode(r.getCode());
    }
    if (l.hasSystem()) {
      res.setSystem(l.getSystem());
    } else if (r.hasSystem()) {
      res.setSystem(r.getSystem());
    }
    if (l.hasVersion()) {
      res.setVersion(l.getVersion());
    } else if (r.hasVersion()) {
      res.setVersion(r.getVersion());
    }
    if (l.hasDisplay()) {
      res.setDisplay(l.getDisplay());
    } else if (r.hasDisplay()) {
      res.setDisplay(r.getDisplay());
    }
    return res;
  }

  @Override
  protected String fhirType() {
    return "ValueSet";
  }

  public XhtmlNode renderCompose(ValueSetComparison csc, String id, String prefix) throws FHIRException, IOException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(new RenderingI18nContext(), Utilities.path("[tmp]", "comparison"), false, "c");
    TableModel model = gen.new TableModel(id, true);
    model.setAlternating(true);
    model.getTitles().add(gen.new Title(null, null, "Item", "The type of item being compared", null, 100));
    model.getTitles().add(gen.new Title(null, null, "Property", "The system for the concept", null, 100, 2));
    model.getTitles().add(gen.new Title(null, null, "Value", "The display for the concept", null, 200, 2));
    model.getTitles().add(gen.new Title(null, null, "Comments", "Additional information about the comparison", null, 200));
    for (StructuralMatch<Element> t : csc.getIncludes().getChildren()) {
      addComposeRow(gen, model.getRows(), t, "include");
    }
    for (StructuralMatch<Element> t : csc.getExcludes().getChildren()) {
      addComposeRow(gen, model.getRows(), t, "exclude");
    }
    return gen.generate(model, prefix, 0, null);
  }

  private void addComposeRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, String name) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, name, null, null));
    if (t.hasLeft() && t.hasRight()) {
      ConceptSetComponent csL = (ConceptSetComponent) t.getLeft();
      ConceptSetComponent csR = (ConceptSetComponent) t.getRight();
      if (csL.hasSystem() && csL.getSystem().equals(csR.getSystem())) {
        r.getCells().add(gen.new Cell(null, null, csL.getSystem(), null, null).span(2).center());        
      } else {
        r.getCells().add(gen.new Cell(null, null, csL.getSystem(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
        r.getCells().add(gen.new Cell(null, null, csR.getSystem(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
      }
      
      if (csL.hasVersion() && csR.hasVersion()) {
        if (csL.getVersion().equals(csR.getVersion())) {
          r.getCells().add(gen.new Cell(null, null, csL.getVersion(), null, null).span(2).center());        
        } else {
          r.getCells().add(gen.new Cell(null, null, csL.getVersion(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
          r.getCells().add(gen.new Cell(null, null, csR.getVersion(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
        }
      } else if (csL.hasVersion()) {
        r.getCells().add(gen.new Cell(null, null, csL.getVersion(), null, null));        
        r.getCells().add(missingCell(gen, COLOR_NO_CELL_RIGHT));        
      } else if (csR.hasVersion()) {        
        r.getCells().add(missingCell(gen, COLOR_NO_CELL_LEFT));        
        r.getCells().add(gen.new Cell(null, null, csR.getVersion(), null, null));        
      } else {
        r.getCells().add(missingCell(gen).span(2).center());
      }

    } else if (t.hasLeft()) {
      r.setColor(COLOR_NO_ROW_RIGHT);
      ConceptSetComponent cs = (ConceptSetComponent) t.getLeft();
      r.getCells().add(gen.new Cell(null, null, cs.getSystem(), null, null));
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, cs.hasVersion() ? "Version: "+cs.getVersion() : "", null, null));
      r.getCells().add(missingCell(gen));
    } else {
      r.setColor(COLOR_NO_ROW_LEFT);
      ConceptSetComponent cs = (ConceptSetComponent) t.getRight();
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, cs.getSystem(), null, null));
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, cs.hasVersion() ? "Version: "+cs.getVersion() : "", null, null));
    }
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    for (StructuralMatch<Element> c : t.getChildren()) {
      if (c.either() instanceof ConceptReferenceComponent) {
        addSetConceptRow(gen, r.getSubRows(), c);
      } else {
        addSetFilterRow(gen, r.getSubRows(), c);
      }
    }
  }
  
  private void addSetConceptRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "Concept", null, null));
    if (t.hasLeft() && t.hasRight()) {
      ConceptReferenceComponent csL = (ConceptReferenceComponent) t.getLeft();
      ConceptReferenceComponent csR = (ConceptReferenceComponent) t.getRight();
      // we assume both have codes 
      if (csL.getCode().equals(csR.getCode())) {
        r.getCells().add(gen.new Cell(null, null, csL.getCode(), null, null).span(2).center());        
      } else {
        r.getCells().add(gen.new Cell(null, null, csL.getCode(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
        r.getCells().add(gen.new Cell(null, null, csR.getCode(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
      }
      
      if (csL.hasDisplay() && csR.hasDisplay()) {
        if (csL.getDisplay().equals(csR.getDisplay())) {
          r.getCells().add(gen.new Cell(null, null, csL.getDisplay(), null, null).span(2).center());        
        } else {
          r.getCells().add(gen.new Cell(null, null, csL.getDisplay(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
          r.getCells().add(gen.new Cell(null, null, csR.getDisplay(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
        }
      } else if (csL.hasDisplay()) {
        r.getCells().add(gen.new Cell(null, null, csL.getDisplay(), null, null));        
        r.getCells().add(missingCell(gen, COLOR_NO_CELL_RIGHT));        
      } else if (csR.hasDisplay()) {        
        r.getCells().add(missingCell(gen, COLOR_NO_CELL_LEFT));        
        r.getCells().add(gen.new Cell(null, null, csR.getDisplay(), null, null));        
      } else {
        r.getCells().add(missingCell(gen).span(2).center());
      }

    } else if (t.hasLeft()) {
      r.setColor(COLOR_NO_ROW_RIGHT);
      ConceptReferenceComponent cs = (ConceptReferenceComponent) t.getLeft();
      r.getCells().add(gen.new Cell(null, null, cs.getCode(), null, null));
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, cs.hasDisplay() ? "Version: "+cs.getDisplay() : "", null, null));
      r.getCells().add(missingCell(gen));
    } else {
      r.setColor(COLOR_NO_ROW_LEFT);
      ConceptReferenceComponent cs = (ConceptReferenceComponent) t.getRight();
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, cs.getCode(), null, null));
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, cs.hasDisplay() ? "Version: "+cs.getDisplay() : "", null, null));
    }
    r.getCells().add(cellForMessages(gen, t.getMessages()));

  }
  
  private void addSetFilterRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t) {
//    Row r = gen.new Row();
//    rows.add(r);
//    r.getCells().add(gen.new Cell(null, null, "Filter", null, null));
//    if (t.hasLeft() && t.hasRight()) {
//      ConceptSetComponent csL = (ConceptSetComponent) t.getLeft();
//      ConceptSetComponent csR = (ConceptSetComponent) t.getRight();
//      // we assume both have systems 
//      if (csL.getSystem().equals(csR.getSystem())) {
//        r.getCells().add(gen.new Cell(null, null, csL.getSystem(), null, null).span(2).center());        
//      } else {
//        r.getCells().add(gen.new Cell(null, null, csL.getSystem(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
//        r.getCells().add(gen.new Cell(null, null, csR.getSystem(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
//      }
//      
//      if (csL.hasVersion() && csR.hasVersion()) {
//        if (csL.getVersion().equals(csR.getVersion())) {
//          r.getCells().add(gen.new Cell(null, null, csL.getVersion(), null, null).span(2).center());        
//        } else {
//          r.getCells().add(gen.new Cell(null, null, csL.getVersion(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
//          r.getCells().add(gen.new Cell(null, null, csR.getVersion(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
//        }
//      } else if (csL.hasVersion()) {
//        r.getCells().add(gen.new Cell(null, null, csL.getVersion(), null, null));        
//        r.getCells().add(missingCell(gen, COLOR_NO_CELL_RIGHT));        
//      } else if (csR.hasVersion()) {        
//        r.getCells().add(missingCell(gen, COLOR_NO_CELL_LEFT));        
//        r.getCells().add(gen.new Cell(null, null, csR.getVersion(), null, null));        
//      } else {
//        r.getCells().add(missingCell(gen).span(2).center());
//      }
//
//    } else if (t.hasLeft()) {
//      r.setColor(COLOR_NO_ROW_RIGHT);
//      ConceptSetComponent cs = (ConceptSetComponent) t.getLeft();
//      r.getCells().add(gen.new Cell(null, null, cs.getSystem(), null, null));
//      r.getCells().add(missingCell(gen));
//      r.getCells().add(gen.new Cell(null, null, cs.hasVersion() ? "Version: "+cs.getVersion() : "", null, null));
//      r.getCells().add(missingCell(gen));
//    } else {
//      r.setColor(COLOR_NO_ROW_LEFT);
//      ConceptSetComponent cs = (ConceptSetComponent) t.getRight();
//      r.getCells().add(missingCell(gen));
//      r.getCells().add(gen.new Cell(null, null, cs.getSystem(), null, null));
//      r.getCells().add(missingCell(gen));
//      r.getCells().add(gen.new Cell(null, null, cs.hasVersion() ? "Version: "+cs.getVersion() : "", null, null));
//    }
//    r.getCells().add(gen.new Cell(null, null, t.getError(), null, null));

  }
  
  public XhtmlNode renderExpansion(ValueSetComparison csc, String id, String prefix) throws IOException {
    if (csc.getExpansion() == null) {
      XhtmlNode p = new XhtmlNode(NodeType.Element, "p");
      p.tx("Unable to generate expansion - see errors");
      return p;
    }
    if (csc.getExpansion().getChildren().isEmpty()) {
      XhtmlNode p = new XhtmlNode(NodeType.Element, "p");
      p.tx("Expansion is empty");
      return p;      
    }
    // columns: code(+system), version, display , abstract, inactive,
    boolean hasSystem = csc.getExpansion().getChildren().isEmpty() ? false : getSystemVaries(csc.getExpansion(), csc.getExpansion().getChildren().get(0).either().getSystem());
    boolean hasVersion = findVersion(csc.getExpansion());
    boolean hasAbstract = findAbstract(csc.getExpansion());
    boolean hasInactive = findInactive(csc.getExpansion());

    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(new RenderingI18nContext(), Utilities.path("[tmp]", "comparison"), false, "c");
    TableModel model = gen.new TableModel(id, true);
    model.setAlternating(true);
    if (hasSystem) {
      model.getTitles().add(gen.new Title(null, null, "System", "The code for the concept", null, 100));
    }
    model.getTitles().add(gen.new Title(null, null, "Code", "The system for the concept", null, 100));
    model.getTitles().add(gen.new Title(null, null, "Display", "The display for the concept", null, 200, 2));
//    if (hasVersion) {
//      model.getTitles().add(gen.new Title(null, null, "Version", "The version for the concept", null, 200, 2));
//    }
//    if (hasAbstract) {
//      model.getTitles().add(gen.new Title(null, null, "Abstract", "The abstract flag for the concept", null, 200, 2));
//    }
//    if (hasInactive) {
//      model.getTitles().add(gen.new Title(null, null, "Inactive", "The inactive flag for the concept", null, 200, 2));
//    }
    model.getTitles().add(gen.new Title(null, null, "Comments", "Additional information about the comparison", null, 200));
    for (StructuralMatch<ValueSetExpansionContainsComponent> t : csc.getExpansion().getChildren()) {
      addExpansionRow(gen, model.getRows(), t, hasSystem, hasVersion, hasAbstract, hasInactive);
    }
    return gen.generate(model, prefix, 0, null);
  }

  private void addExpansionRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<ValueSetExpansionContainsComponent> t, boolean hasSystem, boolean hasVersion, boolean hasAbstract, boolean hasInactive) {
    Row r = gen.new Row();
    rows.add(r);
    if (hasSystem) {
      r.getCells().add(gen.new Cell(null, null, t.either().getSystem(), null, null));
    }
    r.getCells().add(gen.new Cell(null, null, t.either().getCode(), null, null));
    if (t.hasLeft() && t.hasRight()) {
      if (t.getLeft().hasDisplay() && t.getRight().hasDisplay()) {
        if (t.getLeft().getDisplay().equals(t.getRight().getDisplay())) {
          r.getCells().add(gen.new Cell(null, null, t.getLeft().getDisplay(), null, null).span(2).center());        
        } else {
          r.getCells().add(gen.new Cell(null, null, t.getLeft().getDisplay(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
          r.getCells().add(gen.new Cell(null, null, t.getRight().getDisplay(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
        }
      } else if (t.getLeft().hasDisplay()) {
        r.getCells().add(gen.new Cell(null, null, t.getLeft().getDisplay(), null, null));        
        r.getCells().add(missingCell(gen, COLOR_NO_CELL_RIGHT));        
      } else if (t.getRight().hasDisplay()) {        
        r.getCells().add(missingCell(gen, COLOR_NO_CELL_LEFT));        
        r.getCells().add(gen.new Cell(null, null, t.getRight().getDisplay(), null, null));        
      } else {
        r.getCells().add(missingCell(gen).span(2).center());
      }

    } else if (t.hasLeft()) {
      r.setColor(COLOR_NO_ROW_RIGHT);
      r.getCells().add(gen.new Cell(null, null, t.either().getDisplay(), null, null));
      r.getCells().add(missingCell(gen));
    } else {
      r.setColor(COLOR_NO_ROW_LEFT);
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, t.either().getDisplay(), null, null));
    }
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    for (StructuralMatch<ValueSetExpansionContainsComponent> c : t.getChildren()) {
      addExpansionRow(gen, r.getSubRows(), c, hasSystem, hasVersion, hasAbstract, hasInactive);
    }
  }

  private boolean getSystemVaries(StructuralMatch<ValueSetExpansionContainsComponent> list, String system) {
    for (StructuralMatch<ValueSetExpansionContainsComponent> t : list.getChildren()) {
      if (t.hasLeft() && !system.equals(t.getLeft().getSystem())) {
        return true;
      }
      if (t.hasRight() && !system.equals(t.getRight().getSystem())) {
        return true;
      }
      if (getSystemVaries(t, system)) {
        return true;
      }
    }
    return false;
  }

  private boolean findInactive(StructuralMatch<ValueSetExpansionContainsComponent> list) {
    for (StructuralMatch<ValueSetExpansionContainsComponent> t : list.getChildren()) {
      if (t.hasLeft() && t.getLeft().getInactive()) {
        return true;
      }
      if (t.hasRight() && t.getRight().getInactive()) {
        return true;
      }
      if (findInactive(t)) {
        return true;
      }
    }
    return false;
  }

  private boolean findAbstract(StructuralMatch<ValueSetExpansionContainsComponent> list) {
    for (StructuralMatch<ValueSetExpansionContainsComponent> t : list.getChildren()) {
      if (t.hasLeft() && t.getLeft().getAbstract()) {
        return true;
      }
      if (t.hasRight() && t.getRight().getAbstract()) {
        return true;
      }
      if (findAbstract(t)) {
        return true;
      }
    }
    return false;
  }

  private boolean findVersion(StructuralMatch<ValueSetExpansionContainsComponent> list) {
    for (StructuralMatch<ValueSetExpansionContainsComponent> t : list.getChildren()) {
      if (t.hasLeft() && t.getLeft().hasVersion()) {
        return true;
      }
      if (t.hasRight() && t.getRight().hasVersion()) {
        return true;
      }
      if (findVersion(t)) {
        return true;
      }
    }
    return false;
  }


  public XhtmlNode renderUnion(ValueSetComparison comp, String id, String prefix, String corePath) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    ValueSetRenderer vsr = new ValueSetRenderer(new RenderingContext(session.getContextLeft(), null, new ValidationOptions(), corePath, prefix, session.getContextLeft().getLocale(), ResourceRendererMode.TECHNICAL, GenerationRules.IG_PUBLISHER));
    return vsr.buildNarrative(ResourceWrapper.forResource(vsr.getContext(), comp.union));
  }

  public XhtmlNode renderIntersection(ValueSetComparison comp, String id, String prefix, String corePath) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    ValueSetRenderer vsr = new ValueSetRenderer(new RenderingContext(session.getContextLeft(), null, new ValidationOptions(), corePath, prefix, session.getContextLeft().getLocale(), ResourceRendererMode.TECHNICAL, GenerationRules.IG_PUBLISHER));
    return vsr.buildNarrative(ResourceWrapper.forResource(vsr.getContext(), comp.intersection));
  }
  
}