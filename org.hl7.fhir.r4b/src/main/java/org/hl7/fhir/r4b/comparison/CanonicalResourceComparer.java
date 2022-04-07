package org.hl7.fhir.r4b.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.comparison.ResourceComparer.MessageCounts;
import org.hl7.fhir.r4b.model.CanonicalResource;
import org.hl7.fhir.r4b.model.CanonicalType;
import org.hl7.fhir.r4b.model.CapabilityStatement;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r4b.model.CodeableConcept;
import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.PrimitiveType;
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


  public abstract class CanonicalResourceComparison<T extends CanonicalResource> extends ResourceComparison {
    protected T left;
    protected T right;
    protected T union;
    protected T intersection;
    protected Map<String, StructuralMatch<String>> metadata = new HashMap<>();                                             

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

    @Override
    protected String toTable() {
      String s = "";
      s = s + refCell(left);
      s = s + refCell(right);
      s = s + "<td><a href=\""+getId()+".html\">Comparison</a></td>";
      s = s + "<td>"+outcomeSummary()+"</td>";
      return "<tr style=\"background-color: "+color()+"\">"+s+"</tr>\r\n";
    }

    @Override
    protected void countMessages(MessageCounts cnts) {
      for (StructuralMatch<String> sm : metadata.values()) {
        sm.countMessages(cnts);
      }
    }
  }

  public CanonicalResourceComparer(ComparisonSession session) {
    super(session);
  }

  protected void compareMetadata(CanonicalResource left, CanonicalResource right, Map<String, StructuralMatch<String>> comp, CanonicalResourceComparison<? extends CanonicalResource> res) {
    comparePrimitives("url", left.getUrlElement(), right.getUrlElement(), comp, IssueSeverity.ERROR, res);
    comparePrimitives("version", left.getVersionElement(), right.getVersionElement(), comp, IssueSeverity.ERROR, res);
    comparePrimitives("name", left.getNameElement(), right.getNameElement(), comp, IssueSeverity.INFORMATION, res);
    comparePrimitives("title", left.getTitleElement(), right.getTitleElement(), comp, IssueSeverity.INFORMATION, res);
    comparePrimitives("status", left.getStatusElement(), right.getStatusElement(), comp, IssueSeverity.INFORMATION, res);
    comparePrimitives("experimental", left.getExperimentalElement(), right.getExperimentalElement(), comp, IssueSeverity.WARNING, res);
    comparePrimitives("date", left.getDateElement(), right.getDateElement(), comp, IssueSeverity.INFORMATION, res);
    comparePrimitives("publisher", left.getPublisherElement(), right.getPublisherElement(), comp, IssueSeverity.INFORMATION, res);
    comparePrimitives("description", left.getDescriptionElement(), right.getDescriptionElement(), comp, IssueSeverity.NULL, res);
    comparePrimitives("purpose", left.getPurposeElement(), right.getPurposeElement(), comp, IssueSeverity.NULL, res);
    comparePrimitives("copyright", left.getCopyrightElement(), right.getCopyrightElement(), comp, IssueSeverity.INFORMATION, res);
    compareCodeableConceptList("jurisdiction", left.getJurisdiction(), right.getJurisdiction(), comp, IssueSeverity.INFORMATION, res, res.getUnion().getJurisdiction(), res.getIntersection().getJurisdiction());
  }

  protected void compareCodeableConceptList(String name, List<CodeableConcept> left, List<CodeableConcept> right, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res, List<CodeableConcept> union, List<CodeableConcept> intersection ) {
    List<CodeableConcept> matchR = new ArrayList<>();
    StructuralMatch<String> combined = new StructuralMatch<String>();
    for (CodeableConcept l : left) {
      CodeableConcept r = findCodeableConceptInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<String>(gen(l), vm(IssueSeverity.INFORMATION, "Removed the item '"+gen(l)+"'", fhirType()+"."+name, res.getMessages())));
      } else {
        matchR.add(r);
        union.add(r);
        intersection.add(r);
        StructuralMatch<String> sm = new StructuralMatch<String>(gen(l), gen(r));
        combined.getChildren().add(sm);
      }
    }
    for (CodeableConcept r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<String>(vm(IssueSeverity.INFORMATION, "Added the item '"+gen(r)+"'", fhirType()+"."+name, res.getMessages()), gen(r)));        
      }
    }    
    comp.put(name, combined);    
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
  protected void comparePrimitives(String name, PrimitiveType l, PrimitiveType r, Map<String, StructuralMatch<String>> comp, IssueSeverity level, CanonicalResourceComparison<? extends CanonicalResource> res) {
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