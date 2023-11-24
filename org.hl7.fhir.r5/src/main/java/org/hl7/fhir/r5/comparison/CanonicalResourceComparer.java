package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public abstract class CanonicalResourceComparer extends ResourceComparer {


  public enum ChangeAnalysisState {
    Unknown, NotChanged, Changed, CannotEvaluate;

    boolean noteable() {
      return this == Changed || this == CannotEvaluate;
    }
  }


  public abstract class CanonicalResourceComparison<T extends CanonicalResource> extends ResourceComparison {
    protected T left;
    protected T right;
    protected T union;
    protected T intersection;
    
    private ChangeAnalysisState changedMetadata = ChangeAnalysisState.Unknown; 
    private ChangeAnalysisState changedDefinitions = ChangeAnalysisState.Unknown;
    private ChangeAnalysisState changedContent = ChangeAnalysisState.Unknown;
    private ChangeAnalysisState changedContentInterpretation = ChangeAnalysisState.Unknown;

    protected Map<String, StructuralMatch<String>> metadata = new HashMap<>();
    private List<String> chMetadataFields;                                             

    public CanonicalResourceComparison(T left, T right) {
      super(left.getId(), right.getId());
      this.left = left;
      this.right = right;
    }

    public T getLeft() {
      return left;
    }

    public T getRight() {
      return right;
    }

    public T getUnion() {
      return union;
    }

    public T getIntersection() {
      return intersection;
    }

    public Map<String, StructuralMatch<String>> getMetadata() {
      return metadata;
    }

    public void setLeft(T left) {
      this.left = left;
    }

    public void setRight(T right) {
      this.right = right;
    }

    public void setUnion(T union) {
      this.union = union;
    }

    public void setIntersection(T intersection) {
      this.intersection = intersection;
    }

    private ChangeAnalysisState updateState(ChangeAnalysisState newState, ChangeAnalysisState oldState) {
      switch (newState) {
      case CannotEvaluate:
        return ChangeAnalysisState.CannotEvaluate;
      case Changed:
        if (oldState != ChangeAnalysisState.CannotEvaluate) {
          return ChangeAnalysisState.Changed;
        }
        break;
      case NotChanged:
        if (oldState == ChangeAnalysisState.Unknown) {
          return ChangeAnalysisState.NotChanged;
        }
        break;
      case Unknown:
      default:
        break;
      }
      return oldState;
    }
    
    public void updatedMetadataState(ChangeAnalysisState state) {
      changedMetadata = updateState(state, changedMetadata);
    }

    public void updateDefinitionsState(ChangeAnalysisState state) {
      changedDefinitions = updateState(state, changedDefinitions);
    }

    public void updateContentState(ChangeAnalysisState state) {
      changedContent = updateState(state, changedContent);
    }

    public void updateContentInterpretationState(ChangeAnalysisState state) {
      changedContentInterpretation = updateState(state, changedContentInterpretation);
    }

    public void updatedMetadataState(boolean changed, List<String> chMetadataFields) {
      changedMetadata = updateState(changed ? ChangeAnalysisState.Changed : ChangeAnalysisState.NotChanged, changedMetadata);
      this.chMetadataFields = chMetadataFields;
    }

    public void updateDefinitionsState(boolean changed) {
      changedDefinitions = updateState(changed ? ChangeAnalysisState.Changed : ChangeAnalysisState.NotChanged, changedDefinitions);
    }

    public void updateContentState(boolean changed) {
      changedContent = updateState(changed ? ChangeAnalysisState.Changed : ChangeAnalysisState.NotChanged, changedContent);
    }

    public void updateContentInterpretationState(boolean changed) {
      changedContentInterpretation = updateState(changed ? ChangeAnalysisState.Changed : ChangeAnalysisState.NotChanged, changedContentInterpretation);
    }

    public boolean anyUpdates() {
      return changedMetadata.noteable() || changedDefinitions.noteable() || changedContent.noteable() || changedContentInterpretation.noteable();
    }
    
    
    public ChangeAnalysisState getChangedMetadata() {
      return changedMetadata;
    }

    public ChangeAnalysisState getChangedDefinitions() {
      return changedDefinitions;
    }

    public ChangeAnalysisState getChangedContent() {
      return changedContent;
    }

    public ChangeAnalysisState getChangedContentInterpretation() {
      return changedContentInterpretation;
    }

    @Override
    protected String toTable() {
      String s = "";
      s = s + refCell(left);
      s = s + refCell(right);
      s = s + "<td><a href=\""+getId()+".html\">Comparison</a></td>";
      s = s + "<td><a href=\""+getId()+"-union.html\">Union</a></td>";
      s = s + "<td><a href=\""+getId()+"-intersection.html\">Intersection</a></td>";
      s = s + "<td>"+outcomeSummary()+"</td>";
      return "<tr style=\"background-color: "+color()+"\">"+s+"</tr>\r\n";
    }

    @Override
    protected void countMessages(MessageCounts cnts) {
      for (StructuralMatch<String> sm : metadata.values()) {
        sm.countMessages(cnts);
      }
    }
    
    protected String changeSummary() {
      if (!(changedMetadata.noteable() || changedDefinitions.noteable() || changedContent.noteable() || changedContentInterpretation.noteable())) {
        return null;
      };
      CommaSeparatedStringBuilder bc = new CommaSeparatedStringBuilder();
      if (changedMetadata == ChangeAnalysisState.CannotEvaluate) {
        bc.append("Metadata");
      }
      if (changedDefinitions == ChangeAnalysisState.CannotEvaluate) {
        bc.append("Definitions");
      }
      if (changedContent == ChangeAnalysisState.CannotEvaluate) {
        bc.append("Content");
      }
      if (changedContentInterpretation == ChangeAnalysisState.CannotEvaluate) {
        bc.append("Interpretation");
      }
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      if (changedMetadata == ChangeAnalysisState.Changed) {
        b.append("Metadata");
      }
      if (changedDefinitions == ChangeAnalysisState.Changed) {
        b.append("Definitions");
      }
      if (changedContent == ChangeAnalysisState.Changed) {
        b.append("Content");
      }
      if (changedContentInterpretation == ChangeAnalysisState.Changed) {
        b.append("Interpretation");
      }
      return (bc.length() == 0 ? "" : "Error Checking: "+bc.toString()+"; ")+ "Changed: "+b.toString();     
    }

    public String getMetadataFieldsAsText() {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      if (chMetadataFields != null) {
        for (String s : chMetadataFields) {
          b.append(s);
        }
      }
      return b.toString();
    }

    public boolean noUpdates() {
      return !(changedMetadata.noteable() || changedDefinitions.noteable() || !changedContent.noteable() || !changedContentInterpretation.noteable());
    }

    public boolean noChangeOtherThanMetadata(String[] metadataFields) {
      if (changedDefinitions.noteable() || changedContent.noteable() || changedContentInterpretation.noteable()) {
        return false;
      }
      if (!changedMetadata.noteable()) {
        return true;
      }
      for (String s : this.chMetadataFields) {
        if (!Utilities.existsInList(s, metadataFields)) {
          return false;
        }
      }
      return true;
    }
  }

  public CanonicalResourceComparer(ComparisonSession session) {
    super(session);
  }

  protected boolean compareMetadata(CanonicalResource left, CanonicalResource right, Map<String, StructuralMatch<String>> comp, CanonicalResourceComparison<? extends CanonicalResource> res, List<String> changes, Base parent) {
    var changed = false;
    if (comparePrimitivesWithTracking("url", left.getUrlElement(), right.getUrlElement(), comp, IssueSeverity.ERROR, res, parent)) {
      changed = true;
      changes.add("url");
    }
    if (!session.isAnnotate()) {
      if (comparePrimitivesWithTracking("version", left.getVersionElement(), right.getVersionElement(), comp, IssueSeverity.ERROR, res, parent)) {
        changed = true;
        changes.add("version");
      }
    }
    if (comparePrimitivesWithTracking("name", left.getNameElement(), right.getNameElement(), comp, IssueSeverity.INFORMATION, res, parent)) {
      changed = true;
      changes.add("name");
    }
    if (comparePrimitivesWithTracking("title", left.getTitleElement(), right.getTitleElement(), comp, IssueSeverity.INFORMATION, res, parent)) {
      changed = true;
      changes.add("title");
    }
    if (comparePrimitivesWithTracking("status", left.getStatusElement(), right.getStatusElement(), comp, IssueSeverity.INFORMATION, res, parent)) {
      changed = true;
      changes.add("status");
    }
    if (comparePrimitivesWithTracking("experimental", left.getExperimentalElement(), right.getExperimentalElement(), comp, IssueSeverity.WARNING, res, parent)) {
      changed = true;
      changes.add("experimental");
    }
    if (!session.isAnnotate()) {
      if (comparePrimitivesWithTracking("date", left.getDateElement(), right.getDateElement(), comp, IssueSeverity.INFORMATION, res, parent)) {
        changed = true;
        changes.add("date");
      }
    }
    if (comparePrimitivesWithTracking("publisher", left.getPublisherElement(), right.getPublisherElement(), comp, IssueSeverity.INFORMATION, res, parent)) {
      changed = true;
      changes.add("publisher");
    }
    if (comparePrimitivesWithTracking("description", left.getDescriptionElement(), right.getDescriptionElement(), comp, IssueSeverity.NULL, res, parent)) {
      changed = true;
      changes.add("description");
    }
    if (comparePrimitivesWithTracking("purpose", left.getPurposeElement(), right.getPurposeElement(), comp, IssueSeverity.NULL, res, parent)) {
      changed = true;
      changes.add("purpose");
    }
    if (comparePrimitivesWithTracking("copyright", left.getCopyrightElement(), right.getCopyrightElement(), comp, IssueSeverity.INFORMATION, res, parent)) {
      changed = true;
      changes.add("copyright");
    }
    if (compareCodeableConceptList("jurisdiction", left.getJurisdiction(), right.getJurisdiction(), comp, IssueSeverity.INFORMATION, res, res.getUnion().getJurisdiction(), res.getIntersection().getJurisdiction())) {
      changed = true;
      changes.add("jurisdiction");
    }
    return changed;
  }

  protected boolean compareCodeableConceptList(String name, List<CodeableConcept> left, List<CodeableConcept> right, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, List<CodeableConcept> union, List<CodeableConcept> intersection ) {
    boolean result = false;
    List<CodeableConcept> matchR = new ArrayList<>();
    StructuralMatch<String> combined = new StructuralMatch<String>();
    for (CodeableConcept l : left) {
      CodeableConcept r = findCodeableConceptInList(right, l);
      if (r == null) {
        union.add(l);
        result = true;
        combined.getChildren().add(new StructuralMatch<String>(gen(l), vm(IssueSeverity.INFORMATION, "Removed the item '"+gen(l)+"'", fhirType()+"."+name, res.getMessages())));
      } else {
        matchR.add(r);
        union.add(r);
        intersection.add(r);
        StructuralMatch<String> sm = new StructuralMatch<String>(gen(l), gen(r));
        combined.getChildren().add(sm);
        if (sm.isDifferent()) {
          result = true;
        }
      }
    }
    for (CodeableConcept r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        result = true;
        combined.getChildren().add(new StructuralMatch<String>(vm(IssueSeverity.INFORMATION, "Added the item '"+gen(r)+"'", fhirType()+"."+name, res.getMessages()), gen(r)));        
      }
    }    
    comp.put(name, combined);  
    return result;
  }
  

  private CodeableConcept findCodeableConceptInList(List<CodeableConcept> list, CodeableConcept item) {
    for (CodeableConcept t : list) {
      if (t.matches(item)) {
        return t;
      }
    }
    return null;
  }
  
  protected String gen(CodeableConcept cc) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (Coding c : cc.getCoding()) {
      b.append(gen(c));
    }
    return b.toString();
  }

  protected String gen(Coding c) {
    return c.getSystem()+(c.hasVersion() ? "|"+c.getVersion() : "")+"#"+c.getCode();
  }

  protected void compareCanonicalList(String name, List<CanonicalType> left, List<CanonicalType> right, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, List<CanonicalType> union, List<CanonicalType> intersection ) {
    List<CanonicalType> matchR = new ArrayList<>();
    StructuralMatch<String> combined = new StructuralMatch<String>();
    for (CanonicalType l : left) {
      CanonicalType r = findCanonicalInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<String>(l.getValue(), vm(IssueSeverity.INFORMATION, "Removed the item '"+l.getValue()+"'", fhirType()+"."+name, res.getMessages())));
      } else {
        matchR.add(r);
        union.add(r);
        intersection.add(r);
        StructuralMatch<String> sm = new StructuralMatch<String>(l.getValue(), r.getValue());
        combined.getChildren().add(sm);
      }
    }
    for (CanonicalType r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<String>(vm(IssueSeverity.INFORMATION, "Added the item '"+r.getValue()+"'", fhirType()+"."+name, res.getMessages()), r.getValue()));        
      }
    }    
    comp.put(name, combined);    
  }
  
  private CanonicalType findCanonicalInList(List<CanonicalType> list, CanonicalType item) {
    for (CanonicalType t : list) {
      if (t.getValue().equals(item.getValue())) {
        return t;
      }
    }
    return null;
  }

  protected void compareCodeList(String name, List<CodeType> left, List<CodeType> right, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, List<CodeType> union, List<CodeType> intersection ) {
    List<CodeType> matchR = new ArrayList<>();
    StructuralMatch<String> combined = new StructuralMatch<String>();
    for (CodeType l : left) {
      CodeType r = findCodeInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<String>(l.getValue(), vm(IssueSeverity.INFORMATION, "Removed the item '"+l.getValue()+"'", fhirType()+"."+name, res.getMessages())));
      } else {
        matchR.add(r);
        union.add(r);
        intersection.add(r);
        StructuralMatch<String> sm = new StructuralMatch<String>(l.getValue(), r.getValue());
        combined.getChildren().add(sm);
      }
    }
    for (CodeType r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<String>(vm(IssueSeverity.INFORMATION, "Added the item '"+r.getValue()+"'", fhirType()+"."+name, res.getMessages()), r.getValue()));        
      }
    }    
    comp.put(name, combined);    
  }
  
  private CodeType findCodeInList(List<CodeType> list, CodeType item) {
    for (CodeType t : list) {
      if (t.getValue().equals(item.getValue())) {
        return t;
      }
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  protected boolean comparePrimitives(String name, PrimitiveType l, PrimitiveType r, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res) {
    StructuralMatch<String> match = null;
    if (l.isEmpty() && r.isEmpty()) {
      match = new StructuralMatch<>(null, null, null);
    } else if (l.isEmpty()) {
      match = new StructuralMatch<>(null, r.primitiveValue(), vmI(IssueSeverity.INFORMATION, "Added the item '"+r.primitiveValue()+"'", fhirType()+"."+name));
    } else if (r.isEmpty()) {
      match = new StructuralMatch<>(l.primitiveValue(), null, vmI(IssueSeverity.INFORMATION, "Removed the item '"+l.primitiveValue()+"'", fhirType()+"."+name));
    } else if (!l.hasValue() && !r.hasValue()) {
      match = new StructuralMatch<>(null, null, vmI(IssueSeverity.INFORMATION, "No Value", fhirType()+"."+name));
    } else if (!l.hasValue()) {
      match = new StructuralMatch<>(null, r.primitiveValue(), vmI(IssueSeverity.INFORMATION, "No Value on Left", fhirType()+"."+name));
    } else if (!r.hasValue()) {
      match = new StructuralMatch<>(l.primitiveValue(), null, vmI(IssueSeverity.INFORMATION, "No Value on Right", fhirType()+"."+name));
    } else if (l.getValue().equals(r.getValue())) {
      match = new StructuralMatch<>(l.primitiveValue(), r.primitiveValue(), null);
    } else {
      match = new StructuralMatch<>(l.primitiveValue(), r.primitiveValue(), vmI(level, "Values Differ", fhirType()+"."+name));
      if (level != IssueSeverity.NULL) {
        res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, fhirType()+"."+name, "Values for "+name+" differ: '"+l.primitiveValue()+"' vs '"+r.primitiveValue()+"'", level));
      }
    } 
    comp.put(name, match);  
    return match.isDifferent();
  }


  protected boolean comparePrimitivesWithTracking(String name, List< ? extends PrimitiveType> ll, List<? extends PrimitiveType> rl, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, Base parent) {
    boolean def = false;
    
    List<PrimitiveType> matchR = new ArrayList<>();
    for (PrimitiveType l : ll) {
      PrimitiveType r = findInList(rl, l);
      if (r == null) {
        session.markDeleted(parent, "element", l);
      } else {
        matchR.add(r);
        def = comparePrimitivesWithTracking(name, l, r, comp, level, res, parent) || def;
      }
    }
    for (PrimitiveType r : rl) {
      if (!matchR.contains(r)) {
        session.markAdded(r);
      }
    }
    return def;    
  }
  
  private PrimitiveType findInList(List<? extends PrimitiveType> rl, PrimitiveType l) {
    for (PrimitiveType r : rl) {
      if (r.equalsDeep(l)) {
        return r;
      }
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  protected boolean comparePrimitivesWithTracking(String name, PrimitiveType l, PrimitiveType r, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, Base parent) {
    StructuralMatch<String> match = null;
    if (l.isEmpty() && r.isEmpty()) {
      match = new StructuralMatch<>(null, null, null);
    } else if (l.isEmpty()) {
      match = new StructuralMatch<>(null, r.primitiveValue(), vmI(IssueSeverity.INFORMATION, "Added the item '"+r.primitiveValue()+"'", fhirType()+"."+name));
      session.markAdded(r);
    } else if (r.isEmpty()) {
      match = new StructuralMatch<>(l.primitiveValue(), null, vmI(IssueSeverity.INFORMATION, "Removed the item '"+l.primitiveValue()+"'", fhirType()+"."+name));
      session.markDeleted(parent, name, l);
    } else if (!l.hasValue() && !r.hasValue()) {
      match = new StructuralMatch<>(null, null, vmI(IssueSeverity.INFORMATION, "No Value", fhirType()+"."+name));
    } else if (!l.hasValue()) {
      match = new StructuralMatch<>(null, r.primitiveValue(), vmI(IssueSeverity.INFORMATION, "No Value on Left", fhirType()+"."+name));
      session.markAdded(r);
    } else if (!r.hasValue()) {
      match = new StructuralMatch<>(l.primitiveValue(), null, vmI(IssueSeverity.INFORMATION, "No Value on Right", fhirType()+"."+name));
      session.markDeleted(parent, name, l);
    } else if (l.getValue().equals(r.getValue())) {
      match = new StructuralMatch<>(l.primitiveValue(), r.primitiveValue(), null);
    } else {
      session.markChanged(r, l);
      match = new StructuralMatch<>(l.primitiveValue(), r.primitiveValue(), vmI(level, "Values Differ", fhirType()+"."+name));
      if (level != IssueSeverity.NULL && res != null) {
        res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, fhirType()+"."+name, "Values for "+name+" differ: '"+l.primitiveValue()+"' vs '"+r.primitiveValue()+"'", level));
      }
    } 
    if (comp != null) {
      comp.put(name, match);
    }
    return match.isDifferent();
  }
  

  protected boolean compareDataTypesWithTracking(String name, List< ? extends DataType> ll, List<? extends DataType> rl, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, Base parent) {
    boolean def = false;
    
    List<DataType> matchR = new ArrayList<>();
    for (DataType l : ll) {
      DataType r = findInList(rl, l);
      if (r == null) {
        session.markDeleted(parent, "element", l);
      } else {
        matchR.add(r);
        def = compareDataTypesWithTracking(name, l, r, comp, level, res, parent) || def;
      }
    }
    for (DataType r : rl) {
      if (!matchR.contains(r)) {
        session.markAdded(r);
      }
    }
    return def;    
  }
  
  private DataType findInList(List<? extends DataType> rl, DataType l) {
    for (DataType r : rl) {
      if (r.equalsDeep(l)) {
        return r;
      }
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  protected boolean compareDataTypesWithTracking(String name, DataType l, DataType r, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, Base parent) {
    StructuralMatch<String> match = null;
    boolean le = l == null || l.isEmpty();
    boolean re = r == null || r.isEmpty(); 
    if (le && re) {
      match = new StructuralMatch<>(null, null, null);
    } else if (le) {
      match = new StructuralMatch<>(null, r.primitiveValue(), vmI(IssueSeverity.INFORMATION, "Added the item '"+r.fhirType()+"'", fhirType()+"."+name));
      session.markAdded(r);
    } else if (re) {
      match = new StructuralMatch<>(l.primitiveValue(), null, vmI(IssueSeverity.INFORMATION, "Removed the item '"+l.fhirType()+"'", fhirType()+"."+name));
      session.markDeleted(parent, name, l);
    } else if (l.equalsDeep(r)) {
      match = new StructuralMatch<>(l.primitiveValue(), r.primitiveValue(), null);
    } else {
      session.markChanged(r, l);
      match = new StructuralMatch<>(l.fhirType(), r.fhirType(), vmI(level, "Values Differ", fhirType()+"."+name));
      if (level != IssueSeverity.NULL && res != null) {
        res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, fhirType()+"."+name, "Values for "+name+" differ: '"+l.fhirType()+"' vs '"+r.fhirType()+"'", level));
      }
    } 
    if (comp != null) {
      comp.put(name, match);
    }
    return match.isDifferent();
  }

  protected abstract String fhirType();

  public XhtmlNode renderMetadata(CanonicalResourceComparison<? extends CanonicalResource> comparison, String id, String prefix) throws FHIRException, IOException {
    // columns: code, display (left|right), properties (left|right)
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(Utilities.path("[tmp]", "compare"), false);
    TableModel model = gen.new TableModel(id, true);
    model.setAlternating(true);
    model.getTitles().add(gen.new Title(null, null, "Name", "Property Name", null, 100));
    model.getTitles().add(gen.new Title(null, null, "Value", "The value of the property", null, 200, 2));
    model.getTitles().add(gen.new Title(null, null, "Comments", "Additional information about the comparison", null, 200));

    for (String n : sorted(comparison.getMetadata().keySet())) {
      StructuralMatch<String> t = comparison.getMetadata().get(n);
      addRow(gen, model.getRows(), n, t);
    }
    return gen.generate(model, prefix, 0, null);
  }

  private void addRow(HierarchicalTableGenerator gen, List<Row> rows, String name, StructuralMatch<String> t) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, name, null, null));
    if (t.hasLeft() && t.hasRight()) {
      if (t.getLeft().equals(t.getRight())) {
        r.getCells().add(gen.new Cell(null, null, t.getLeft(), null, null).span(2));        
      } else {
        r.getCells().add(gen.new Cell(null, null, t.getLeft(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));        
        r.getCells().add(gen.new Cell(null, null, t.getRight(), null, null).setStyle("background-color: "+COLOR_DIFFERENT));
      }
    } else if (t.hasLeft()) {
      r.setColor(COLOR_NO_ROW_RIGHT);
      r.getCells().add(gen.new Cell(null, null, t.getLeft(), null, null));        
      r.getCells().add(missingCell(gen));        
    } else if (t.hasRight()) {        
      r.setColor(COLOR_NO_ROW_LEFT);
      r.getCells().add(missingCell(gen));        
      r.getCells().add(gen.new Cell(null, null, t.getRight(), null, null));        
    } else {
      r.getCells().add(missingCell(gen).span(2));
    }
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    int i = 0;
    for (StructuralMatch<String> c : t.getChildren()) {
      addRow(gen, r.getSubRows(), name+"["+i+"]", c);
      i++;
    }
  }


  private List<String> sorted(Set<String> keys) {
    List<String> res = new ArrayList<>();
    res.addAll(keys);
    Collections.sort(res);
    return res;
  }


}