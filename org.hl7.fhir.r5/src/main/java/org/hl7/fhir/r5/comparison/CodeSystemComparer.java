package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.comparison.ResourceComparer.MessageCounts;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class CodeSystemComparer extends CanonicalResourceComparer {


  public class CodeSystemComparison extends CanonicalResourceComparison<CodeSystem> {

    private StructuralMatch<PropertyComponent> properties = new StructuralMatch<PropertyComponent>(); 
    private StructuralMatch<CodeSystemFilterComponent> filters = new StructuralMatch<CodeSystemFilterComponent>();                                             
    private StructuralMatch<ConceptDefinitionComponent> combined;                                             
    private Map<String, String> propMap = new HashMap<>(); // right to left; left retains it's name
    public CodeSystemComparison(CodeSystem left, CodeSystem right) {
      super(left, right);
      combined = new StructuralMatch<CodeSystem.ConceptDefinitionComponent>(); // base
    }

    public Map<String, String> getPropMap() {
      return propMap;
    }

    public StructuralMatch<ConceptDefinitionComponent> getCombined() {
      return combined;
    }

    public StructuralMatch<PropertyComponent> getProperties() {
      return properties;
    }

    public StructuralMatch<CodeSystemFilterComponent> getFilters() {
      return filters;
    }

    @Override
    protected String abbreviation() {
      return "cs";
    }

    @Override
    protected String summary() {
      String res = "CodeSystem: "+left.present()+" vs "+right.present();
      String ch = changeSummary();
      if (ch != null) {
        res = res + ". "+ch;
      }
      return res;
    }


    @Override
    protected String fhirType() {
      return "CodeSystem";
    }

    @Override
    protected void countMessages(MessageCounts cnts) {
      super.countMessages(cnts);
      combined.countMessages(cnts);
    }

  }

  private CodeSystem right;

  public CodeSystemComparer(ComparisonSession session) {
    super(session);
  }

  public CodeSystemComparison compare(CodeSystem left, CodeSystem right) {    
    if (left == null)
      throw new DefinitionException("No CodeSystem provided (left)");
    if (right == null)
      throw new DefinitionException("No CodeSystem provided (right)");
    
    CodeSystemComparison res = new CodeSystemComparison(left, right);
    session.identify(res);
    CodeSystem cs = new CodeSystem();
    res.setUnion(cs);
    session.identify(cs);
    cs.setName("Union"+left.getName()+"And"+right.getName());
    cs.setTitle("Union of "+left.getTitle()+" And "+right.getTitle());
    cs.setStatus(left.getStatus());
    cs.setDate(new Date());
    for (PropertyComponent pL : left.getProperty()) {
      cs.addProperty(pL.copy());
    }
    for (PropertyComponent pR : left.getProperty()) {
      PropertyComponent pL = findProperty(left, pR);
      if (pL == null) {
        String code = getUniqued(pR.getCode(), cs.getProperty());
        cs.addProperty(pR.copy().setCode(code));
      } else {
        res.getPropMap().put(pR.getCode(), pL.getCode());
      }
    }

    CodeSystem cs1 = new CodeSystem();
    res.setIntersection(cs1);
    session.identify(cs1);
    cs1.setName("Intersection"+left.getName()+"And"+right.getName());
    cs1.setTitle("Intersection of "+left.getTitle()+" And "+right.getTitle());
    cs1.setStatus(left.getStatus());
    cs1.setDate(new Date());
    cs1.getProperty().addAll(cs.getProperty());


    List<String> chMetadata = new ArrayList<>();
    boolean ch = compareMetadata(left, right, res.getMetadata(), res, chMetadata, right, session.getForVersion());
    if (comparePrimitives("versionNeeded", left.getVersionNeededElement(), right.getVersionNeededElement(), res.getMetadata(), IssueSeverity.INFORMATION, res)) {
      ch = true;
      chMetadata.add("versionNeeded");
    }
    if (comparePrimitives("compositional", left.getCompositionalElement(), right.getCompositionalElement(), res.getMetadata(), IssueSeverity.WARNING, res)) {
      ch = true;
      chMetadata.add("compositional");
    }
    res.updatedMetadataState(ch, chMetadata);
    ch = false;
    ch = comparePrimitivesWithTracking("caseSensitive", left.getCaseSensitiveElement(), right.getCaseSensitiveElement(), res.getMetadata(), IssueSeverity.ERROR, res, right, session.getForVersion()) || ch;
    ch = comparePrimitivesWithTracking("hierarchyMeaning", left.getHierarchyMeaningElement(), right.getHierarchyMeaningElement(), res.getMetadata(), IssueSeverity.ERROR, res, right, session.getForVersion()) || ch;
    ch = comparePrimitivesWithTracking("content", left.getContentElement(), right.getContentElement(), res.getMetadata(), IssueSeverity.WARNING, res, right, session.getForVersion());
    
    ch = compareProperties(left.getProperty(), right.getProperty(), res.getProperties(), res.getUnion().getProperty(), res.getIntersection().getProperty(), res.getUnion(), res.getIntersection(), res, "CodeSystem.property", right) || ch;
    ch = compareFilters(left.getFilter(), right.getFilter(), res.getFilters(), res.getUnion().getFilter(), res.getIntersection().getFilter(), res.getUnion(), res.getIntersection(), res, "CodeSystem.filter", right) || ch;
    ch = compareConcepts(left.getConcept(), right.getConcept(), res.getCombined(), res.getUnion().getConcept(), res.getIntersection().getConcept(), res.getUnion(), res.getIntersection(), res, "CodeSystem.concept", right) || ch;
    res.updateDefinitionsState(ch);

    VersionComparisonAnnotation.annotate(right, session.getForVersion(), res);
    return res;
  }

  private String getUniqued(String code, List<PropertyComponent> list) {
    int i = 0;
    while (true) {
      boolean ok = true;
      String res = code+(i == 0 ? "" : i);
      for (PropertyComponent t : list) {
        if (res.equals(t.getCode())) {
          ok = false;
        }
      }
      if (ok) {
        return res;
      }
    }
  }

  private PropertyComponent findProperty(CodeSystem left, PropertyComponent p) {
    for (PropertyComponent t : left.getProperty()) {
      if (p.hasUri() && t.hasUri() && p.getUri().equals(t.getUri())) {
        return t;
      } else if (!p.hasUri() && !t.hasUri() && p.getCode().equals(t.getCode())) {
        return t;
      }
    }
    return null;
  }

  private boolean compareProperties(List<PropertyComponent> left, List<PropertyComponent> right, StructuralMatch<PropertyComponent> combined,
    List<PropertyComponent> union, List<PropertyComponent> intersection, CodeSystem csU, CodeSystem csI, CodeSystemComparison res, String path, Base parent) {
    boolean def = false;
    List<PropertyComponent> matchR = new ArrayList<>();
    for (PropertyComponent l : left) {
      PropertyComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<CodeSystem.PropertyComponent>(l, vmI(IssueSeverity.INFORMATION, "Removed this concept", path)));
        VersionComparisonAnnotation.markDeleted(parent, session.getForVersion(), "concept", l);
      } else {
        matchR.add(r);
        PropertyComponent cdM = merge(l, r, res);
        PropertyComponent cdI = intersect(l, r, res);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<PropertyComponent> sm = new StructuralMatch<CodeSystem.PropertyComponent>(l, r);
        if (compare(sm.getMessages(), l, r, path+".where(code='"+l.getCode()+"')", res, parent)) {
          def = true;
        }
        combined.getChildren().add(sm);
      }
    }
    for (PropertyComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<CodeSystem.PropertyComponent>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));    
        VersionComparisonAnnotation.markAdded(r, session.getForVersion());     
      }
    }
    return def;
  }


  private boolean compareFilters(List<CodeSystemFilterComponent> left, List<CodeSystemFilterComponent> right, StructuralMatch<CodeSystemFilterComponent> combined,
    List<CodeSystemFilterComponent> union, List<CodeSystemFilterComponent> intersection, CodeSystem csU, CodeSystem csI, CodeSystemComparison res, String path, Base parent) {
    boolean def = false;
    List<CodeSystemFilterComponent> matchR = new ArrayList<>();
    for (CodeSystemFilterComponent l : left) {
      CodeSystemFilterComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<CodeSystem.CodeSystemFilterComponent>(l, vmI(IssueSeverity.INFORMATION, "Removed this concept", path)));
        VersionComparisonAnnotation.markDeleted(parent, session.getForVersion(), "concept", l);
      } else {
        matchR.add(r);
        CodeSystemFilterComponent cdM = merge(l, r, res);
        CodeSystemFilterComponent cdI = intersect(l, r, res);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<CodeSystemFilterComponent> sm = new StructuralMatch<CodeSystem.CodeSystemFilterComponent>(l, r);
        if (compare(sm.getMessages(), l, r, path+".where(code='"+l.getCode()+"')", res, parent)) {
          def = true;
        }
        combined.getChildren().add(sm);
      }
    }
    for (CodeSystemFilterComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<CodeSystem.CodeSystemFilterComponent>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));    
        VersionComparisonAnnotation.markAdded(r, session.getForVersion());     
      }
    }
    return def;
  }

  
  private boolean compareConcepts(List<ConceptDefinitionComponent> left, List<ConceptDefinitionComponent> right, StructuralMatch<ConceptDefinitionComponent> combined,
    List<ConceptDefinitionComponent> union, List<ConceptDefinitionComponent> intersection, CodeSystem csU, CodeSystem csI, CodeSystemComparison res, String path, Base parent) {
    boolean def = false;
    List<ConceptDefinitionComponent> matchR = new ArrayList<>();
    for (ConceptDefinitionComponent l : left) {
      ConceptDefinitionComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<CodeSystem.ConceptDefinitionComponent>(l, vmI(IssueSeverity.INFORMATION, "Removed this concept", path)));
        VersionComparisonAnnotation.markDeleted(parent, session.getForVersion(), "concept", l);
      } else {
        matchR.add(r);
        ConceptDefinitionComponent cdM = merge(l, r, csU.getProperty(), res);
        ConceptDefinitionComponent cdI = intersect(l, r, res);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<ConceptDefinitionComponent> sm = new StructuralMatch<CodeSystem.ConceptDefinitionComponent>(l, r);
        if (compare(sm.getMessages(), l, r, path+".where(code='"+l.getCode()+"')", res, parent)) {
          def = true;
        }
        combined.getChildren().add(sm);
        if (compareConcepts(l.getConcept(), r.getConcept(), sm, cdM.getConcept(), cdI.getConcept(), csU, csI, res, path+".where(code='"+l.getCode()+"').concept", r)) {
          def = true;
        }
      }
    }
    for (ConceptDefinitionComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        res.updateContentState(true);
        combined.getChildren().add(new StructuralMatch<CodeSystem.ConceptDefinitionComponent>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));    
        VersionComparisonAnnotation.markAdded(r, session.getForVersion());     
      }
    }
    return def;
  }
  
  private CodeSystemFilterComponent findInList(List<CodeSystemFilterComponent> list, CodeSystemFilterComponent item) {
    for (CodeSystemFilterComponent t : list) {
      if (t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }


  private ConceptDefinitionComponent findInList(List<ConceptDefinitionComponent> list, ConceptDefinitionComponent item) {
    for (ConceptDefinitionComponent t : list) {
      if (t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }


  private PropertyComponent findInList(List<PropertyComponent> list, PropertyComponent item) {
    for (PropertyComponent t : list) {
      if (t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }

  private boolean compare(List<ValidationMessage> msgs, ConceptDefinitionComponent l, ConceptDefinitionComponent r, String path, CodeSystemComparison res, Base parent) {
    boolean result = false;
    result = compareStrings(path, msgs, l.getDisplay(), r.getDisplay(), "display", IssueSeverity.WARNING, res, parent, l.getDisplayElement(), r.getDisplayElement()) || result;
    result = compareStrings(path, msgs, l.getDefinition(), r.getDefinition(), "definition", IssueSeverity.INFORMATION, res, parent, l.getDefinitionElement(), r.getDefinitionElement()) || result;
    // todo: designations, properties
    return result;
  }

  private boolean compare(List<ValidationMessage> msgs, PropertyComponent l, PropertyComponent r, String path, CodeSystemComparison res, Base parent) {
    boolean result = false;
    result = compareStrings(path, msgs, l.getUri(), r.getUri(), "uri", IssueSeverity.WARNING, res, parent, l.getUriElement(), r.getUriElement()) || result;
    result = compareStrings(path, msgs, l.hasType() ? l.getType().toCode() : null, r.hasType() ? r.getType().toCode() : null, "type", IssueSeverity.ERROR, res, parent, l.getTypeElement(), r.getTypeElement()) || result;
    result = compareStrings(path, msgs, l.getDescription(), r.getDescription(), "description", IssueSeverity.WARNING, res, parent, l.getDescriptionElement(), r.getDescriptionElement()) || result;
    return result;
  }

  private boolean compare(List<ValidationMessage> msgs, CodeSystemFilterComponent l, CodeSystemFilterComponent r, String path, CodeSystemComparison res, Base parent) {
    boolean result = false;
    result = compareStrings(path, msgs, l.getDescription(), r.getDescription(), "description", IssueSeverity.WARNING, res, parent, l.getDescriptionElement(), r.getDescriptionElement()) || result;
// todo: repeating
//    result = compareStrings(path, msgs, l.hasOperator() ? l.getOperator().toCode() : null, r.hasType() ? r.getType().toCode() : null, "type", IssueSeverity.ERROR, res, parent, l.getTypeElement(), r.getTypeElement()) || result;
    result = compareStrings(path, msgs, l.getValue(), r.getValue(), "value", IssueSeverity.WARNING, res, parent, l.getValueElement(), r.getValueElement()) || result;
    return result;
  }

  private boolean compareStrings(String path, List<ValidationMessage> msgs, String left, String right, String name, IssueSeverity level, CodeSystemComparison res, Base parent, Base l, Base r) {
    if (!Utilities.noString(right)) {
      if (Utilities.noString(left)) {
        msgs.add(vmI(level, "Value for "+name+" added", path));   
        VersionComparisonAnnotation.markAdded(r, session.getForVersion());     
        return true;
      } else if (!left.equals(right)) {
        if (level != IssueSeverity.NULL) {
          res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+"."+name, "Changed value for "+name+": '"+left+"' vs '"+right+"'", level));
        }
        msgs.add(vmI(level, name+" changed from left to right", path));
        VersionComparisonAnnotation.markChanged(r, session.getForVersion());   
        return true;
      }
    } else if (!Utilities.noString(left)) {
      msgs.add(vmI(level, "Value for "+name+" removed", path));
      VersionComparisonAnnotation.markDeleted(parent, session.getForVersion(), "concept", l);
      return true;
    }
    return false;
  }

  private ConceptDefinitionComponent merge(ConceptDefinitionComponent l, ConceptDefinitionComponent r, List<PropertyComponent> destProps, CodeSystemComparison res) {
    ConceptDefinitionComponent cd = l.copy();
    if (!l.hasDisplay() && r.hasDisplay()) {
      cd.setDisplay(r.getDisplay());
    }
    if (!l.hasDefinition() && r.hasDefinition()) {
      cd.setDefinition(r.getDefinition());
    }
    mergeProps(cd, l, r, destProps, res);
    mergeDesignations(cd, l, r);
    return cd;
  }

  private PropertyComponent merge(PropertyComponent l, PropertyComponent r, CodeSystemComparison res) {
    PropertyComponent cd = l.copy();
    if (!l.hasDescription() && r.hasDescription()) {
      cd.setDescription(r.getDescription());
    }
    return cd;
  }


  private CodeSystemFilterComponent merge(CodeSystemFilterComponent l, CodeSystemFilterComponent r, CodeSystemComparison res) {
    CodeSystemFilterComponent cd = l.copy();
    if (!l.hasDescription() && r.hasDescription()) {
      cd.setDescription(r.getDescription());
    }
    return cd;
  }

  private ConceptDefinitionComponent intersect(ConceptDefinitionComponent l, ConceptDefinitionComponent r, CodeSystemComparison res) {
    ConceptDefinitionComponent cd = l.copy();
    if (l.hasDisplay() && !r.hasDisplay()) {
      cd.setDisplay(null);
    }
    if (l.hasDefinition() && !r.hasDefinition()) {
      cd.setDefinition(null);
    }
    intersectProps(cd, l, r, res);
    //    mergeDesignations(cd, l, r);
    return cd;
  }

  private PropertyComponent intersect(PropertyComponent l, PropertyComponent r, CodeSystemComparison res) {
    PropertyComponent cd = l.copy();
    if (l.hasDescription() && !r.hasDescription()) {
      cd.setDescription(null);
    }
    return cd;
  }

  private CodeSystemFilterComponent intersect(CodeSystemFilterComponent l, CodeSystemFilterComponent r, CodeSystemComparison res) {
    CodeSystemFilterComponent cd = l.copy();
    if (l.hasDescription() && !r.hasDescription()) {
      cd.setDescription(null);
    }
    return cd;
  }

  private void mergeDesignations(ConceptDefinitionComponent cd, ConceptDefinitionComponent l, ConceptDefinitionComponent r) {
    for (ConceptDefinitionDesignationComponent td : l.getDesignation()) {
      if (hasDesignation(td, r.getDesignation())) {
        cd.getDesignation().add(td);
      }
    }
    for (ConceptDefinitionDesignationComponent td : r.getDesignation()) {
      if (hasDesignation(td, l.getDesignation())) {
        cd.getDesignation().add(td);
      }
    }
  }

  private boolean hasDesignation(ConceptDefinitionDesignationComponent td, List<ConceptDefinitionDesignationComponent> designation) {
    for (ConceptDefinitionDesignationComponent t : designation) {
      if (designationsMatch(td, t)) {
        return true;
      }
    }
    return false;
  }

  private boolean designationsMatch(ConceptDefinitionDesignationComponent l, ConceptDefinitionDesignationComponent r) {
    if (l.hasUse() != r.hasUse()) {
      return false;
    }
    if (l.hasLanguage() != r.hasLanguage()) {
      return false;
    }
    if (l.hasValue() != r.hasValue()) {
      return false;
    }
    if (l.hasUse()) {
      if (l.getUse().equalsDeep(r.getUse())) {
        return false;
      }
    }
    if (l.hasLanguage()) {
      if (l.getLanguageElement().equalsDeep(r.getLanguageElement())) {
        return false;
      }
    }
    if (l.hasValue()) {
      if (l.getValueElement().equalsDeep(r.getValueElement())) {
        return false;
      }
    }
    return true;
  }

  private void mergeProps(ConceptDefinitionComponent cd, ConceptDefinitionComponent l, ConceptDefinitionComponent r, List<PropertyComponent> destProps, CodeSystemComparison res) {
    List<ConceptPropertyComponent> matchR = new ArrayList<>();
    for (ConceptPropertyComponent lp : l.getProperty()) {
      ConceptPropertyComponent rp = findRightProp(r.getProperty(), lp, res);
      if (rp == null) {
        cd.getProperty().add(lp);
      } else {
        matchR.add(rp);
        cd.getProperty().add(lp);
        if (lp.getValue().equalsDeep(rp.getValue())) {
          cd.getProperty().add(rp.setCode(res.getPropMap().get(rp.getCode())));
        }
      }
    }
    for (ConceptPropertyComponent rp : r.getProperty()) {
      if (!matchR.contains(rp)) {
        cd.getProperty().add(rp.setCode(res.getPropMap().get(rp.getCode())));        
      }
    }
  }

  private void intersectProps(ConceptDefinitionComponent cd, ConceptDefinitionComponent l, ConceptDefinitionComponent r, CodeSystemComparison res) {
    for (ConceptPropertyComponent lp : l.getProperty()) {
      ConceptPropertyComponent rp = findRightProp(r.getProperty(), lp, res);
      if (rp != null) {
        cd.getProperty().add(lp);
      }
    }
  }

  private ConceptPropertyComponent findRightProp(List<ConceptPropertyComponent> rightProperties, ConceptPropertyComponent lp, CodeSystemComparison res) {
    for (ConceptPropertyComponent p : rightProperties) {
      String rp = res.getPropMap().get(p.getCode());
      if (rp != null && rp.equals(lp.getCode())) {
        return p;
      }
    }
    return null;
  }

  public XhtmlNode renderConcepts(CodeSystemComparison comparison, String id, String prefix) throws FHIRException, IOException {
    // columns: code, display (left|right), properties (left|right)
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(Utilities.path("[tmp]", "compare"), false);
    TableModel model = gen.new TableModel(id, true);
    model.setAlternating(true);
    model.getTitles().add(gen.new Title(null, null, "Code", "The code for the concept", null, 100));
    model.getTitles().add(gen.new Title(null, null, "Display", "The display for the concept", null, 200, 2));
    for (PropertyComponent p : comparison.getUnion().getProperty()) {
      model.getTitles().add(gen.new Title(null, null, p.getCode(), p.getDescription(), null, 100, 2));
    }
    model.getTitles().add(gen.new Title(null, null, "Comments", "Additional information about the comparison", null, 200));
    for (StructuralMatch<ConceptDefinitionComponent> t : comparison.getCombined().getChildren()) {
      addRow(gen, model.getRows(), t, comparison);
    }
    return gen.generate(model, prefix, 0, null);
  }

  private void addRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<ConceptDefinitionComponent> t, CodeSystemComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, t.either().getCode(), null, null));
    if (t.hasLeft() && t.hasRight()) {
      if (t.getLeft().hasDisplay() && t.getRight().hasDisplay()) {
        if (t.getLeft().getDisplay().equals(t.getRight().getDisplay())) {
          r.getCells().add(gen.new Cell(null, null, t.getLeft().getDisplay(), null, null).span(2));        
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
        r.getCells().add(missingCell(gen).span(2));
      }
      for (PropertyComponent p : comparison.getUnion().getProperty()) {
        ConceptPropertyComponent lp = getProp(t.getLeft(), p, false, comparison);
        ConceptPropertyComponent rp = getProp(t.getRight(), p, true, comparison);

        if (lp != null && rp != null) {
          if (lp.getValue().equals(rp.getValue())) {
            r.getCells().add(gen.new Cell(null, null, t.getLeft().getDisplay(), null, null).span(2));        
          } else {
            r.getCells().add(gen.new Cell(null, null, lp.getValue().toString(), null, null));        
            r.getCells().add(gen.new Cell(null, null, rp.getValue().toString(), null, null));
          }
        } else if (lp != null) {
          r.getCells().add(gen.new Cell(null, null, lp.getValue().toString(), null, null));        
          r.getCells().add(missingCell(gen, COLOR_NO_CELL_RIGHT));        
        } else if (rp != null) {        
          r.getCells().add(missingCell(gen, COLOR_NO_CELL_LEFT));        
          r.getCells().add(gen.new Cell(null, null, rp.getValue().toString(), null, null));        
        } else {
          r.getCells().add(missingCell(gen).span(2));
        }

      }
    } else if (t.hasLeft()) {
      r.setColor(COLOR_NO_ROW_RIGHT);
      r.getCells().add(gen.new Cell(null, null, t.either().getDisplay(), null, null));
      r.getCells().add(missingCell(gen));
      for (PropertyComponent p : comparison.getUnion().getProperty()) {
        r.getCells().add(propertyCell(gen, t.getLeft(), p, false, comparison));
        r.getCells().add(missingCell(gen));
      }
    } else {
      r.setColor(COLOR_NO_ROW_LEFT);
      r.getCells().add(missingCell(gen));
      r.getCells().add(gen.new Cell(null, null, t.either().getDisplay(), null, null));
      for (PropertyComponent p : comparison.getUnion().getProperty()) {
        r.getCells().add(missingCell(gen));
        r.getCells().add(propertyCell(gen, t.getLeft(), p, true, comparison));
      }
    }
    r.getCells().add(cellForMessages(gen, t.getMessages()));
  }

  private Cell propertyCell(HierarchicalTableGenerator gen, ConceptDefinitionComponent cd, PropertyComponent p, boolean right, CodeSystemComparison comp) {
    ConceptPropertyComponent cp = getProp(cd, p, right, comp);
    if (cp == null) {
      return missingCell(gen, right ? COLOR_NO_CELL_RIGHT : COLOR_NO_CELL_LEFT);
    } else {
      return gen.new Cell(null, null, cp.getValue().toString(), null, null);
    }
  }

  public ConceptPropertyComponent getProp(ConceptDefinitionComponent cd, PropertyComponent p, boolean right, CodeSystemComparison comp) {
    String c = p.getCode();
    if (right) {
      c = comp.getPropMap().get(c);
    }
    ConceptPropertyComponent cp = null;
    if (cd != null) {
      for (ConceptPropertyComponent t : cd.getProperty()) {
        if (t.hasCode() && t.getCode().equals(c)) {
          cp = t;
        }
      }
    }
    return cp;
  }

  @Override
  protected String fhirType() {
    return "CodeSystem";
  }

}