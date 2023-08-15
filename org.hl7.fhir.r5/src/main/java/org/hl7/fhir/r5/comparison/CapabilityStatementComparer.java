package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.ProfileComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.MessageCounts;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.BackboneElement;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.ToolingExtensions;
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

public class CapabilityStatementComparer extends CanonicalResourceComparer {

  
  public class CapabilityStatementComparison extends CanonicalResourceComparison<CapabilityStatement> {

    private StructuralMatch<Element> combined;                                             

    public CapabilityStatementComparison(CapabilityStatement left, CapabilityStatement right) {
      super(left, right);
      combined = new StructuralMatch<Element>(); // base
    }
      
    public StructuralMatch<Element> getCombined() {
      return combined;
    }

    @Override
    protected String abbreviation() {
      return "cps";
    }

    @Override
    protected String summary() {
      return "CapabilityStatement: "+left.present()+" vs "+right.present();
    }

    @Override
    protected String fhirType() {
      return "CapabilityStatement";
    }

    @Override
    protected void countMessages(MessageCounts cnts) {
      super.countMessages(cnts);
      combined.countMessages(cnts);
    }
  }

  public CapabilityStatementComparer(ComparisonSession session) {
    super(session);
  }

  public CapabilityStatementComparison compare(CapabilityStatement left, CapabilityStatement right) throws DefinitionException, FHIRFormatError, IOException {    
    if (left == null)
      throw new DefinitionException("No CapabilityStatement provided (left)");
    if (right == null)
      throw new DefinitionException("No CapabilityStatement provided (right)");
    
    
    CapabilityStatementComparison res = new CapabilityStatementComparison(left, right);
    session.identify(res);
    CapabilityStatement cs = new CapabilityStatement();
    res.setUnion(cs);
    session.identify(cs);
    cs.setName("Union"+left.getName()+"And"+right.getName());
    cs.setTitle("Union of "+left.getTitle()+" And "+right.getTitle());
    cs.setStatus(left.getStatus());
    cs.setDate(new Date());

    CapabilityStatement cs1 = new CapabilityStatement();
    res.setIntersection(cs1);
    session.identify(cs1);
    cs1.setName("Intersection"+left.getName()+"And"+right.getName());
    cs1.setTitle("Intersection of "+left.getTitle()+" And "+right.getTitle());
    cs1.setStatus(left.getStatus());
    cs1.setDate(new Date());

    compareMetadata(left, right, res.getMetadata(), res, new ArrayList<>());
    comparePrimitives("kind", left.getKindElement(), right.getKindElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    compareCanonicalList("instantiates", left.getInstantiates(), right.getInstantiates(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getInstantiates(), cs1.getInstantiates());
    compareCanonicalList("imports", left.getImports(), right.getImports(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getImports(), cs1.getImports());
    comparePrimitives("software.name", left.getSoftware().getNameElement(), right.getSoftware().getNameElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("software.version", left.getSoftware().getVersionElement(), right.getSoftware().getVersionElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("software.releaseDate", left.getSoftware().getReleaseDateElement(), right.getSoftware().getReleaseDateElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("implementation.description", left.getImplementation().getDescriptionElement(), right.getImplementation().getDescriptionElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("implementation.url", left.getImplementation().getUrlElement(), right.getImplementation().getUrlElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("fhirVersion", left.getFhirVersionElement(), right.getFhirVersionElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    compareCodeList("format", left.getFormat(), right.getFormat(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getFormat(), cs1.getFormat());
    compareCodeList("patchFormat", left.getPatchFormat(), right.getPatchFormat(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getPatchFormat(), cs1.getPatchFormat());
    compareCanonicalList("implementationGuide", left.getImplementationGuide(), right.getImplementationGuide(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getImplementationGuide(), cs1.getImplementationGuide());


    compareRests(left.getRest(), right.getRest(), res.getCombined(), res.getUnion().getRest(), res.getIntersection().getRest(), res.getUnion(), res.getIntersection(), res, "CapabilityStatement.rest");
    return res;
  }

  private void compareRests(List<CapabilityStatementRestComponent> left, List<CapabilityStatementRestComponent> right, StructuralMatch<Element> combined, List<CapabilityStatementRestComponent> union, List<CapabilityStatementRestComponent> intersection, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) throws DefinitionException, FHIRFormatError, IOException {
    List<CapabilityStatementRestComponent> matchR = new ArrayList<>();
    for (CapabilityStatementRestComponent l : left) {
      CapabilityStatementRestComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        CapabilityStatementRestComponent cdM = merge(l, r, res);
        CapabilityStatementRestComponent cdI = intersect(l, r, res);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compare(sm, l, r, path+".where(mode='"+l.getMode()+"')", res);
        combined.getChildren().add(sm);
        compareRestSecurity(l, r, sm, cdM.getSecurity(), cdI.getSecurity(), csU, csI, res, path+".security");
        compareRestResources(l, r, sm, cdM, cdI, csU, csI, res, path+".resource");
        compareSearchParams(combined, l.getSearchParam(), r.getSearchParam(), path, res, cdM.getSearchParam(), cdI.getSearchParam());
        compareOperations(combined, l.getOperation(), r.getOperation(), path, res, cdM.getOperation(), cdI.getOperation());
        compareItemPropertyList(sm, "compartment", l.getCompartment(), r.getCompartment(), path, res, cdM.getCompartment(), cdI.getCompartment(), IssueSeverity.ERROR);
      }
    }
    for (CapabilityStatementRestComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
      }
    }
  }

  private CapabilityStatementRestComponent findInList(List<CapabilityStatementRestComponent> list, CapabilityStatementRestComponent item) {
    for (CapabilityStatementRestComponent t : list) {
      if (t.getMode().equals(item.getMode())) {
        return t;
      }
    }
    return null;
  }

  private void compare(StructuralMatch<Element> sm, CapabilityStatementRestComponent l, CapabilityStatementRestComponent r, String path, CapabilityStatementComparison res) {
    compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.WARNING, res);
  }

  private void compareRestSecurity(CapabilityStatementRestComponent l, CapabilityStatementRestComponent r, StructuralMatch<Element> smp, CapabilityStatementRestSecurityComponent merge, CapabilityStatementRestSecurityComponent intersect, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) {
    CapabilityStatementRestSecurityComponent ls = l.hasSecurity() ? l.getSecurity() : null;
    CapabilityStatementRestSecurityComponent rs = r.hasSecurity() ? r.getSecurity() : null;
    
    StructuralMatch<Element> sm = new StructuralMatch<Element>(ls, rs);
    smp.getChildren().add(sm);
    compareBooleans(path, sm.getMessages(), l.getSecurity().getCorsElement(), r.getSecurity().getCorsElement(), "security.cors", IssueSeverity.WARNING, res);
    compareStrings(path, sm.getMessages(), l.getSecurity().getDescription(), r.getSecurity().getDescription(), "security.description", IssueSeverity.INFORMATION, res);
    compareRestSecurityService(ls, rs, sm, merge, intersect, csU, csI, res, path+".security");    
  }

  private void compareRestSecurityService(CapabilityStatementRestSecurityComponent left, CapabilityStatementRestSecurityComponent right, StructuralMatch<Element> combined, CapabilityStatementRestSecurityComponent union, CapabilityStatementRestSecurityComponent intersection, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) {
    List<CodeableConcept> matchR = new ArrayList<>();
    for (CodeableConcept l : left.getService()) {
      CodeableConcept r = findInList(right.getService(), l);
      if (r == null) {
        union.getService().add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        CodeableConcept cdM = CodeableConcept.merge(l, r);
        CodeableConcept cdI = CodeableConcept.intersect(l, r);
        union.getService().add(cdM);
        intersection.getService().add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compare(sm, l, r, path, res);
        combined.getChildren().add(sm);
      }
    }
    if (right != null) {
      for (CodeableConcept r : right.getService()) {
        if (!matchR.contains(r)) {
          union.getService().add(r);
          combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
        }
      }
    }
  }
  

  private void compare(StructuralMatch<Element> sm, CodeableConcept l, CodeableConcept r, String path, CapabilityStatementComparison res) {
    compareStrings(path, sm.getMessages(), l.getText(), r.getText(), "text", IssueSeverity.INFORMATION, res);
    List<Coding> matches = new ArrayList<>();
    for (Coding lc : l.getCoding()) {
      boolean m = false;
      for (Coding rc : r.getCoding()) {
        if (lc.matches(rc)) {
          matches.add(rc);
          m = true;
        }
      }
      if (!m) {
        sm.getMessages().add(vmI(IssueSeverity.INFORMATION, "Value for "+gen(lc)+" removed", path));        
      }      
    }
    for (Coding rc : r.getCoding()) {
      if (!matches.contains(rc)) {
        sm.getMessages().add(vmI(IssueSeverity.INFORMATION, "Value for "+gen(rc)+" added", path));        
      }
    }    
  }

  private CodeableConcept findInList(List<CodeableConcept> list, CodeableConcept item) {
    for (CodeableConcept t : list) {
      if (t.matches(item)) {
        return t;
      }
    }
    return null;
  }
  
  private void compareStrings(String path, List<ValidationMessage> msgs, String left, String right, String name, IssueSeverity level, CapabilityStatementComparison res) {
    if (!Utilities.noString(right)) {
      if (Utilities.noString(left)) {
        msgs.add(vmI(level, "Value for "+name+" added", path));
      } else if (!left.equals(right)) {
        if (level != IssueSeverity.NULL) {
          res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+"."+name, "Changed value for "+name+": '"+left+"' vs '"+right+"'", level));
        }
        msgs.add(vmI(level, name+" changed from left to right", path));
      }
    } else if (!Utilities.noString(left)) {
      msgs.add(vmI(level, "Value for "+name+" removed", path));
    }
  }

  private void compareExpectations(StructuralMatch<Element> combined, Element left, Element right, String path, CapabilityStatementComparison res, Element union, Element intersection) {
    Extension l = left.getExtensionByUrl(ToolingExtensions.EXT_CAP_STMT_EXPECT);
    Extension r = right.getExtensionByUrl(ToolingExtensions.EXT_CAP_STMT_EXPECT);
    if (l != null || r != null) {
      if (l == null) {
        union.addExtension(r.copy());
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this expectation", path), r));        
      } else if (r == null) {
        union.addExtension(l.copy());
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this expectation", path)));              
      } else {
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        combined.getChildren().add(sm);
        String ls = l.getValue().primitiveValue();
        String rs = r.getValue().primitiveValue();
        if (ls.equals(rs)) {
          union.addExtension(l.copy());
          intersection.addExtension(l.copy());
        } else {
          sm.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+".extension('http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation')", "Changed value for expectation: '"+ls+"' vs '"+rs+"'", IssueSeverity.WARNING));
          String lowest = lower(ls, rs) ? ls : rs;
          String highest = lower(ls, rs) ? rs : ls;
          union.addExtension(ToolingExtensions.EXT_CAP_STMT_EXPECT, new CodeType(lowest));
          intersection.addExtension(ToolingExtensions.EXT_CAP_STMT_EXPECT, new CodeType(highest));
        }
      }
    }
  }

  private boolean lower(String ls, String rs) {
    if (ls.equals("MAY")) {
      return true;
    }
    if (ls.equals("SHALL")) {
      return false;
    }
    if (rs.equals("MAY")) {
      return false;
    }
    if (rs.equals("SHALL")) {
      return true;
    }
    return false;
  }

  private void compareBooleans(String path, List<ValidationMessage> msgs, BooleanType left, BooleanType right, String name, IssueSeverity level, CapabilityStatementComparison res) {
    if (!right.isEmpty()) {
      if (left.isEmpty()) {
        msgs.add(vmI(level, "Value for "+name+" added", path));
      } else if (left.getValue() != right.getValue()) {
        if (level != IssueSeverity.NULL) {
          res.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+"."+name, "Changed value for "+name+": '"+left+"' vs '"+right+"'", level));
        }
        msgs.add(vmI(level, name+" changed from left to right", path));
      }
    } else if (!left.isEmpty()) {
      msgs.add(vmI(level, "Value for "+name+" removed", path));
    }
  }

  private CapabilityStatementRestComponent merge(CapabilityStatementRestComponent l, CapabilityStatementRestComponent r, CapabilityStatementComparison res) {
    CapabilityStatementRestComponent cd = l.copy();
    if (!l.hasDocumentation() && r.hasDocumentation()) {
      cd.setDocumentation(r.getDocumentation());
    }
    if (r.hasSecurity()) {
      if (!l.getSecurity().hasCors() && r.getSecurity().hasCors()) {
        cd.getSecurity().setCors(r.getSecurity().getCors());
      }
      mergeCodeableConcepts(cd.getSecurity().getService(), r.getSecurity().getService());  
      if (!l.getSecurity().hasDescription() && r.getSecurity().hasDescription()) {
        cd.getSecurity().setDescription(r.getSecurity().getDescription());
      }
    }
    return cd;
  }

  private void mergeCodeableConcepts(List<CodeableConcept> tgt, List<CodeableConcept> src) {
    for (CodeableConcept cd : src) {
      boolean add = true;
      for (CodeableConcept t : tgt) {
        if (t.matches(cd)) {
          add = false;
        }
      }
      if (add) {
        tgt.add(cd.copy());
      }
    }    
  }

  private CapabilityStatementRestComponent intersect(CapabilityStatementRestComponent l, CapabilityStatementRestComponent r, CapabilityStatementComparison res) {
    CapabilityStatementRestComponent cd = l.copy();
    if (l.hasDocumentation() && !r.hasDocumentation()) {
      cd.setDocumentation(null);
    }
    if (!r.hasSecurity()) {
      cd.setSecurity(null);
    } else {
      if (!r.getSecurity().hasCors()) {
        cd.getSecurity().setCorsElement(null);
      }
      intersectCodeableConcepts(cd.getSecurity().getService(), r.getSecurity().getService());  
      if (!r.getSecurity().hasDescription()) {
        cd.getSecurity().setDescription(null);
      }
    }
    return cd;
  }
  
  private void intersectCodeableConcepts(List<CodeableConcept> tgt, List<CodeableConcept> src) {
    List<CodeableConcept> toRemove = new ArrayList<CodeableConcept>();
    for (CodeableConcept cd : src) {
      boolean remove = false;
      for (CodeableConcept t : tgt) {
        if (t.matches(cd)) {
          remove = true;
        }
      }
      if (remove) {
        toRemove.add(cd);
      }
    }    
    tgt.removeAll(toRemove);
  }

  private void compareRestResources(CapabilityStatementRestComponent left, CapabilityStatementRestComponent right, StructuralMatch<Element> combined, CapabilityStatementRestComponent union, CapabilityStatementRestComponent intersection, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) throws DefinitionException, FHIRFormatError, IOException {
    List<CapabilityStatementRestResourceComponent> matchR = new ArrayList<>();
    for (CapabilityStatementRestResourceComponent l : left.getResource()) {
      CapabilityStatementRestResourceComponent r = findInList(right.getResource(), l);
      if (r == null) {
        union.getResource().add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        CapabilityStatementRestResourceComponent cdM = mergeRestResource(l, r);
        CapabilityStatementRestResourceComponent cdI = intersectRestResource(l, r);
        union.getResource().add(cdM);
        intersection.getResource().add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareRestResource(sm, l, r, path, res, cdM, cdI);
        combined.getChildren().add(sm);
      }
    }
    for (CapabilityStatementRestResourceComponent r : right.getResource()) {
      if (!matchR.contains(r)) {
        union.getResource().add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
      }
    }
  }
  
  private void compareRestResource(StructuralMatch<Element> sm, CapabilityStatementRestResourceComponent l, CapabilityStatementRestResourceComponent r, String path, CapabilityStatementComparison res, CapabilityStatementRestResourceComponent union, CapabilityStatementRestResourceComponent intersection) throws DefinitionException, FHIRFormatError, IOException {
    compareProfiles(path, sm, l.getProfileElement(), r.getProfileElement(), res, union, intersection);
    // todo: supported profiles
    compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.INFORMATION, res);
    compareExpectations(sm, l, r, path, res, union, intersection);    
    compareRestResourceInteractions(sm, l, r, path, res, union, intersection);
    compareItemProperty(sm, "versioning", l.getVersioningElement(), r.getVersioningElement(), path, res, union.getVersioningElement(), intersection.getVersioningElement(), IssueSeverity.WARNING);
    compareItemProperty(sm, "readHistory", l.getReadHistoryElement(), r.getReadHistoryElement(), path, res, union.getReadHistoryElement(), intersection.getReadHistoryElement(), IssueSeverity.INFORMATION);
    compareItemProperty(sm, "updateCreate", l.getUpdateCreateElement(), r.getUpdateCreateElement(), path, res, union.getUpdateCreateElement(), intersection.getUpdateCreateElement(), IssueSeverity.WARNING);
    compareItemProperty(sm, "conditionalCreate", l.getConditionalCreateElement(), r.getConditionalCreateElement(), path, res, union.getConditionalCreateElement(), intersection.getConditionalCreateElement(), IssueSeverity.WARNING);
    compareItemProperty(sm, "conditionalRead", l.getConditionalReadElement(), r.getConditionalReadElement(), path, res, union.getConditionalReadElement(), intersection.getConditionalReadElement(), IssueSeverity.WARNING);
    compareItemProperty(sm, "conditionalUpdate", l.getConditionalUpdateElement(), r.getConditionalUpdateElement(), path, res, union.getConditionalUpdateElement(), intersection.getConditionalUpdateElement(), IssueSeverity.WARNING);
    compareItemProperty(sm, "conditionalDelete", l.getConditionalDeleteElement(), r.getConditionalDeleteElement(), path, res, union.getConditionalDeleteElement(), intersection.getConditionalDeleteElement(), IssueSeverity.WARNING);
    compareItemPropertyList(sm, "referencePolicy", l.getReferencePolicy(), r.getReferencePolicy(), path, res, union.getReferencePolicy(), intersection.getReferencePolicy(), IssueSeverity.WARNING);
    compareItemPropertyList(sm, "searchInclude", l.getSearchInclude(), r.getSearchInclude(), path, res, union.getSearchInclude(), intersection.getSearchInclude(), IssueSeverity.WARNING);
    compareItemPropertyList(sm, "searchRevInclude", l.getSearchRevInclude(), r.getSearchRevInclude(), path, res, union.getSearchRevInclude(), intersection.getSearchRevInclude(), IssueSeverity.WARNING);
    compareSearchParams(sm, l.getSearchParam(), r.getSearchParam(), path, res, union.getSearchParam(), intersection.getSearchParam());
    compareOperations(sm, l.getOperation(), r.getOperation(), path, res, union.getOperation(), intersection.getOperation());
  }

  private void compareProfiles(String path, StructuralMatch<Element> combined, CanonicalType left, CanonicalType right, CapabilityStatementComparison res, CapabilityStatementRestResourceComponent union, CapabilityStatementRestResourceComponent intersection) throws DefinitionException, FHIRFormatError, IOException {
    if (!left.hasValue() && !right.hasValue()) {
      // nothing in this case 
    } else if (!left.hasValue()) {
      // the intersection is anything in right. The union is everything (or nothing, in this case)
      intersection.setProfileElement(right.copy());
      combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.WARNING, "Added this profile", path), right).setName("profile"));        
    } else if (!right.hasValue()) {
      // the intersection is anything in right. The union is everything (or nothing, in this case)
      intersection.setProfileElement(left.copy());
      combined.getChildren().add(new StructuralMatch<Element>(left, vmI(IssueSeverity.WARNING, "Removed this profile", path)).setName("profile"));        
    } else {
      // profiles on both sides...
      StructureDefinition sdLeft = session.getContextLeft().fetchResource(StructureDefinition.class, left.getValue());
      StructureDefinition sdRight = session.getContextRight().fetchResource(StructureDefinition.class, right.getValue());
      if (sdLeft == null && sdRight == null) {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.ERROR, "Cannot compare profiles because neither is known", path)).setName("profile"));        
      } else if (sdLeft == null) {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.ERROR, "Cannot compare profiles because '"+left.getValue()+"' is not known", path)).setName("profile"));        
      } else if (sdRight == null) {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.ERROR, "Cannot compare profiles because '"+right.getValue()+"' is not known", path)).setName("profile"));                
      } else if (sdLeft.getUrl().equals(sdRight.getUrl())) {
        intersection.setProfileElement(left.copy());
        union.setProfileElement(left.copy());
        combined.getChildren().add(new StructuralMatch<Element>(left, right).setName("profile"));                
      } else if (profileInherits(sdLeft, sdRight, session.getContextLeft())) {
        // if left inherits from right:
        intersection.setProfileElement(left.copy());
        union.setProfileElement(right.copy());
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.WARNING, "Changed this profile to a broader profile", path)).setName("profile"));                
      } else if (profileInherits(sdRight, sdLeft, session.getContextRight())) {
        intersection.setProfileElement(right.copy());
        union.setProfileElement(left.copy());
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.WARNING, "Changed this profile to a narrower one", path)).setName("profile"));                
      } else {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.WARNING, "Different", path)).setName("profile"));                
        ProfileComparison pc = (ProfileComparison) session.compare(sdLeft, sdRight);
        intersection.setProfile(pc.getIntersection().getUrl());
        union.setProfile(pc.getUnion().getUrl());
      }
    }
  }

  private boolean profileInherits(StructureDefinition sdFocus, StructureDefinition sdOther, IWorkerContext ctxt) {
    while (sdFocus != null) {
      if (sdFocus.getUrl().equals(sdOther.getUrl()) && sdFocus.getVersion().equals(sdOther.getVersion())) {
        return true;
      }
      sdFocus = ctxt.fetchResource(StructureDefinition.class, sdFocus.getBaseDefinition(), sdFocus);
    }
    return false;
  }

  private <T> void compareItemProperty(StructuralMatch<Element> combined, String name, PrimitiveType<T> left, PrimitiveType<T> right, String path, CapabilityStatementComparison res, PrimitiveType<T> union, PrimitiveType<T> intersection, IssueSeverity issueSeverity) {
    if (!left.isEmpty() || !right.isEmpty()) {
      if (left.isEmpty()) {
        union.copyValues(right);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(issueSeverity, "Added this "+name, path), right).setName(name));        
      } else if (right.isEmpty()) {
        union.copyValues(left);
        combined.getChildren().add(new StructuralMatch<Element>(left, vmI(issueSeverity, "Removed this expectation", path)).setName(name));              
      } else {
        StructuralMatch<Element> sm = new StructuralMatch<Element>(left, right).setName(name);
        combined.getChildren().add(sm);
        String ls = left.primitiveValue();
        String rs = right.primitiveValue();
        if (ls.equals(rs)) {
          union.copyValues(left);
          intersection.copyValues(left);
        } else {
          sm.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+"."+name, "Changed value for "+name+": '"+ls+"' vs '"+rs+"'", issueSeverity));
          union.copyValues(left);
          intersection.copyValues(left);
        }
        compareExpectations(sm, left, right, path, res, union, intersection);    
      }
    }
  }

  private <T extends Element> void compareItemPropertyList(StructuralMatch<Element> combined, String name, List<T> left, List<T> right, String path, CapabilityStatementComparison res, List<T> union, List<T> intersection, IssueSeverity issueSeverity) {
    List<T> matchR = new ArrayList<>();
    for (T l : left) {
      T r = findInListT(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(issueSeverity, "Removed this "+name, path)).setName(name));
      } else {
        matchR.add(r);
        union.add(l);
        intersection.add(l);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r).setName(name);
        combined.getChildren().add(sm);
      }
    }
    for (T r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(issueSeverity, "Added this "+name, path), r).setName(name));        
      }
    }
  }

  private <T extends Element> T findInListT(List<T> list, T item) {
    for (T t : list) {
      if (t.equalsDeep(item)) {
        return t;
      }
    }
    return null;
  }


  private CapabilityStatementRestResourceComponent mergeRestResource(CapabilityStatementRestResourceComponent l, CapabilityStatementRestResourceComponent r) {
    CapabilityStatementRestResourceComponent res = l.copy();
    // todo: compare profiles, not just copy
    if (!l.hasProfile() && r.hasProfile()) {
      res.setProfile(r.getProfile());
    }
    if (!l.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatementRestResourceComponent intersectRestResource(CapabilityStatementRestResourceComponent l, CapabilityStatementRestResourceComponent r) {
    CapabilityStatementRestResourceComponent res = new CapabilityStatementRestResourceComponent();
    res.setType(l.getType());
    // todo: compare profiles, not just copy
    if (l.hasProfile() && l.getProfile().equals(r.getProfile())) {
      res.setProfile(l.getProfile());
    }
    if (l.hasDocumentation() && l.getDocumentation().equals(r.getDocumentation())) {
      res.setDocumentation(l.getDocumentation());
    }
    return res;
  }

  private CapabilityStatementRestResourceComponent findInList(List<CapabilityStatementRestResourceComponent> list, CapabilityStatementRestResourceComponent item) {
    for (CapabilityStatementRestResourceComponent t : list) {
      if (t.hasType() && t.getType().equals(item.getType())) {
        return t;
      }
    }
    return null;
  }

  private void compareRestResourceInteractions(StructuralMatch<Element> combined, CapabilityStatementRestResourceComponent left, CapabilityStatementRestResourceComponent right, String path, CapabilityStatementComparison res, CapabilityStatementRestResourceComponent union, CapabilityStatementRestResourceComponent intersection) {
    List<ResourceInteractionComponent> matchR = new ArrayList<>();
    for (ResourceInteractionComponent l : left.getInteraction()) {
      ResourceInteractionComponent r = findInList(right.getInteraction(), l);
      if (r == null) {
        union.getInteraction().add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        ResourceInteractionComponent cdM = mergeRestResourceInteractions(l, r);
        ResourceInteractionComponent cdI = intersectRestResourceInteractions(l, r);
        union.getInteraction().add(cdM);
        intersection.getInteraction().add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.INFORMATION, res);
        compareExpectations(sm, l, r, path, res, union, intersection);    
        combined.getChildren().add(sm);
      }
    }
    for (ResourceInteractionComponent r : right.getInteraction()) {
      if (!matchR.contains(r)) {
        union.getInteraction().add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
      }
    }
  }

  private ResourceInteractionComponent mergeRestResourceInteractions(ResourceInteractionComponent l, ResourceInteractionComponent r) {
    ResourceInteractionComponent res = l.copy();
    if (!res.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private ResourceInteractionComponent intersectRestResourceInteractions(ResourceInteractionComponent l, ResourceInteractionComponent r) {
    ResourceInteractionComponent res = l.copy();
    if (res.hasDocumentation() && !r.hasDocumentation()) {
      res.setDocumentation(null);
    }
    return res;
  }

  private ResourceInteractionComponent findInList(List<ResourceInteractionComponent> list, ResourceInteractionComponent item) {
    for (ResourceInteractionComponent t : list) {
      if (t.hasCode() && t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }


  private void compareSearchParams(StructuralMatch<Element> combined, List<CapabilityStatementRestResourceSearchParamComponent> left,  List<CapabilityStatementRestResourceSearchParamComponent> right, String path, CapabilityStatementComparison res,  List<CapabilityStatementRestResourceSearchParamComponent> union, List<CapabilityStatementRestResourceSearchParamComponent> intersection) {
    List<CapabilityStatementRestResourceSearchParamComponent> matchR = new ArrayList<>();
    for (CapabilityStatementRestResourceSearchParamComponent l : left) {
      CapabilityStatementRestResourceSearchParamComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this Search Parameter", path)));
      } else {
        matchR.add(r);
        CapabilityStatementRestResourceSearchParamComponent cdM = mergeSearchParams(l, r);
        CapabilityStatementRestResourceSearchParamComponent cdI = intersectSearchParams(l, r);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.INFORMATION, res);
        compareItemProperty(sm, "type", l.getTypeElement(), r.getTypeElement(), path, res, cdM.getTypeElement(), cdI.getTypeElement(), IssueSeverity.ERROR);
        compareItemProperty(sm, "definition", l.getDefinitionElement(), r.getDefinitionElement(), path, res, cdM.getDefinitionElement(), cdI.getDefinitionElement(), IssueSeverity.ERROR);
        compareExpectations(sm, l, r, path, res, cdM, cdI);    
        combined.getChildren().add(sm);
      }
    }
    for (CapabilityStatementRestResourceSearchParamComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this Search Parameter", path), r));        
      }
    }
  }
  
  private CapabilityStatementRestResourceSearchParamComponent mergeSearchParams(CapabilityStatementRestResourceSearchParamComponent l, CapabilityStatementRestResourceSearchParamComponent r) {
    CapabilityStatementRestResourceSearchParamComponent res = l.copy();
    if (!res.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatementRestResourceSearchParamComponent intersectSearchParams(CapabilityStatementRestResourceSearchParamComponent l, CapabilityStatementRestResourceSearchParamComponent r) {
    CapabilityStatementRestResourceSearchParamComponent res = new CapabilityStatementRestResourceSearchParamComponent();
    res.setName(l.getName());
    if (l.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(l.getDocumentation());
    }
    return res;
  }

  private CapabilityStatementRestResourceSearchParamComponent findInList(List<CapabilityStatementRestResourceSearchParamComponent> list, CapabilityStatementRestResourceSearchParamComponent item) {
    for (CapabilityStatementRestResourceSearchParamComponent t : list) {
      if (t.hasName() && t.getName().equals(item.getName())) {
        return t;
      }
    }
    return null;
  }


  private void compareOperations(StructuralMatch<Element> combined, List<CapabilityStatementRestResourceOperationComponent> left,  List<CapabilityStatementRestResourceOperationComponent> right, String path, CapabilityStatementComparison res,  List<CapabilityStatementRestResourceOperationComponent> union, List<CapabilityStatementRestResourceOperationComponent> intersection) {
    List<CapabilityStatementRestResourceOperationComponent> matchR = new ArrayList<>();
    for (CapabilityStatementRestResourceOperationComponent l : left) {
      CapabilityStatementRestResourceOperationComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this Search Parameter", path)));
      } else {
        matchR.add(r);
        CapabilityStatementRestResourceOperationComponent cdM = mergeOperations(l, r);
        CapabilityStatementRestResourceOperationComponent cdI = intersectOperations(l, r);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.INFORMATION, res);
        compareItemProperty(sm, "definition", l.getDefinitionElement(), r.getDefinitionElement(), path, res, cdM.getDefinitionElement(), cdI.getDefinitionElement(), IssueSeverity.ERROR);
        compareExpectations(sm, l, r, path, res, cdM, cdI);    
        combined.getChildren().add(sm);
      }
    }
    for (CapabilityStatementRestResourceOperationComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this Search Parameter", path), r));        
      }
    }
  }
  
  private CapabilityStatementRestResourceOperationComponent mergeOperations(CapabilityStatementRestResourceOperationComponent l, CapabilityStatementRestResourceOperationComponent r) {
    CapabilityStatementRestResourceOperationComponent res = l.copy();
    if (!res.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatementRestResourceOperationComponent intersectOperations(CapabilityStatementRestResourceOperationComponent l, CapabilityStatementRestResourceOperationComponent r) {
    CapabilityStatementRestResourceOperationComponent res = new CapabilityStatementRestResourceOperationComponent();
    res.setName(l.getName());
    if (l.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(l.getDocumentation());
    }
    return res;
  }

  private CapabilityStatementRestResourceOperationComponent findInList(List<CapabilityStatementRestResourceOperationComponent> list, CapabilityStatementRestResourceOperationComponent item) {
    for (CapabilityStatementRestResourceOperationComponent t : list) {
      if (t.hasName() && t.getName().equals(item.getName())) {
        return t;
      }
    }
    return null;
  }

  
  // 6 columns: path | left value | left doco | right value | right doco | comments
  public XhtmlNode renderStatements(CapabilityStatementComparison comparison, String id, String prefix) throws FHIRException, IOException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(Utilities.path("[tmp]", "compare"), false);
    TableModel model = gen.new TableModel(id, true);
    model.setAlternating(true);
    model.getTitles().add(gen.new Title(null, null, "Type", "The type of item", null, 100));
    model.getTitles().add(gen.new Title(null, null, "Left Value", "The left value for the item", null, 200, 1));
    model.getTitles().add(gen.new Title(null, null, "Left Doco", "The left documentation for the item", null, 200, 1));
    model.getTitles().add(gen.new Title(null, null, "Right Value", "The right value for the item", null, 200, 1));
    model.getTitles().add(gen.new Title(null, null, "Right Doco", "The right documentation for the item", null, 200, 1));
    model.getTitles().add(gen.new Title(null, null, "Comments", "Additional information about the comparison", null, 200));
    for (StructuralMatch<Element> t : comparison.getCombined().getChildren()) {
      addRow(gen, model.getRows(), t, comparison);
    }
    return gen.generate(model, prefix, 0, null);
  }

  private void addRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = null;
    if (t.either() instanceof CapabilityStatementRestComponent) {
      r = addRestRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatementRestSecurityComponent) {
      r = addRestSecurityRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatementRestResourceComponent) {
      r = addRestResourceRow(gen, rows, t, comparison);
    } else if (t.either() instanceof ResourceInteractionComponent) {
      r = addRestResourceInteractionRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatementRestResourceSearchParamComponent) {
      r = addRestSearchParamRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatementRestResourceOperationComponent) {
      r = addRestOperationRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CodeableConcept) {
      r = addRestSecurityServiceRow(gen, rows, t, comparison);
    } else if (t.either() instanceof Extension) {
      r = addExtensionRow(gen, rows, t, comparison);
    } else if (t.either() instanceof PrimitiveType) {
      r = addPrimitiveTypeRow(gen, rows, t, comparison);
    } else {
      throw new Error("Not Done Yet: "+t.either().getClass().getName());
    }
    for (StructuralMatch<Element> c : t.getChildren()) {
      addRow(gen, r.getSubRows(), c, comparison);
    }
  }

  private Row addRestRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "mode", null, null));
    CapabilityStatementRestComponent left = t.hasLeft() ? (CapabilityStatementRestComponent) t.getLeft() : null;
    CapabilityStatementRestComponent right = t.hasRight() ? (CapabilityStatementRestComponent) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getMode().toCode() : "", null, null), left != null ? left.getMode().toCode() : null, right != null ? right.getMode().toCode() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getMode().toCode() : "", null, null), left != null ? left.getMode().toCode() : null, right != null ? right.getMode().toCode() : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }
  
  private Row addRestSecurityRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "security", null, null));
    CapabilityStatementRestSecurityComponent left = t.hasLeft() ? (CapabilityStatementRestSecurityComponent) t.getLeft() : null;
    CapabilityStatementRestSecurityComponent right = t.hasRight() ? (CapabilityStatementRestSecurityComponent) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getCorsElement().primitiveValue() : "", null, null), left != null ? left.getCorsElement().primitiveValue() : null, right != null ? right.getCorsElement().primitiveValue() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getDescription() : "", null, null), left != null ? left.getDescription() : null, right != null ? right.getDescription() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getCorsElement().primitiveValue() : "", null, null), left != null ? left.getCorsElement().primitiveValue() : null, right != null ? right.getCorsElement().primitiveValue() : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getDescription() : "", null, null), left != null ? left.getDescription() : null, right != null ? right.getDescription() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }

  private Row addRestResourceRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "resource", null, null));
    CapabilityStatementRestResourceComponent left = t.hasLeft() ? (CapabilityStatementRestResourceComponent) t.getLeft() : null;
    CapabilityStatementRestResourceComponent right = t.hasRight() ? (CapabilityStatementRestResourceComponent) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getType() : "", null, null), left != null ? left.getType() : null, right != null ? right.getType() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getType() : "", null, null), left != null ? left.getType() : null, right != null ? right.getType() : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }

  private Row addRestSearchParamRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "searchParam", null, null));
    CapabilityStatementRestResourceSearchParamComponent left = t.hasLeft() ? (CapabilityStatementRestResourceSearchParamComponent) t.getLeft() : null;
    CapabilityStatementRestResourceSearchParamComponent right = t.hasRight() ? (CapabilityStatementRestResourceSearchParamComponent) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getName() : "", null, null), left != null ? left.getName() : null, right != null ? right.getName() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getName() : "", null, null), left != null ? left.getName() : null, right != null ? right.getName() : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }

  private Row addRestOperationRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "operation", null, null));
    CapabilityStatementRestResourceOperationComponent left = t.hasLeft() ? (CapabilityStatementRestResourceOperationComponent) t.getLeft() : null;
    CapabilityStatementRestResourceOperationComponent right = t.hasRight() ? (CapabilityStatementRestResourceOperationComponent) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getName() : "", null, null), left != null ? left.getName() : null, right != null ? right.getName() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getName() : "", null, null), left != null ? left.getName() : null, right != null ? right.getName() : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }

  private Row addRestSecurityServiceRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "service", null, null));
    CodeableConcept left = t.hasLeft() ? (CodeableConcept) t.getLeft() : null;
    CodeableConcept right = t.hasRight() ? (CodeableConcept) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? gen(left) : "", null, null), left != null ? gen(left) : null, right != null ? gen(right) : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getText() : "", null, null), left != null ? left.getText() : null, right != null ? right.getText() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? gen(right) : "", null, null), left != null ? gen(left) : null, right != null ? gen(right) : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getText() : "", null, null), left != null ? left.getText() : null, right != null ? right.getText() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }
  
  private Row addRestResourceInteractionRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "interaction", null, null));
    ResourceInteractionComponent left = t.hasLeft() ? (ResourceInteractionComponent) t.getLeft() : null;
    ResourceInteractionComponent right = t.hasRight() ? (ResourceInteractionComponent) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getCode().getDisplay() : "", null, null), left != null ? left.getCode().getDisplay() : null, right != null ? right.getCode().getDisplay() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getCode().getDisplay() : "", null, null), left != null ? left.getCode().getDisplay() : null, right != null ? right.getCode().getDisplay() : null, false));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getDocumentation() : "", null, null), left != null ? left.getDocumentation() : null, right != null ? right.getDocumentation() : null, true));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }

  private Row addExtensionRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, "expectation", null, null));
    Extension left = t.hasLeft() ? (Extension) t.getLeft() : null;
    Extension right = t.hasRight() ? (Extension) t.getRight() : null;
    r.getCells().add(style(gen.new Cell(null, null, left != null ? left.getValue().primitiveValue() : "", null, null), left != null ? left.getValue().primitiveValue() : null, right != null ? right.getValue().primitiveValue() : null, true));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    r.getCells().add(style(gen.new Cell(null, null, right != null ? right.getValue().primitiveValue() : "", null, null), left != null ? left.getValue().primitiveValue() : null, right != null ? right.getValue().primitiveValue() : null, false));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }
  
  @SuppressWarnings("rawtypes")
  private Row addPrimitiveTypeRow(HierarchicalTableGenerator gen, List<Row> rows, StructuralMatch<Element> t, CapabilityStatementComparison comparison) {
    Row r = gen.new Row();
    rows.add(r);
    r.getCells().add(gen.new Cell(null, null, t.getName(), null, null));
    PrimitiveType left = t.hasLeft() ? (PrimitiveType) t.getLeft() : null;
    PrimitiveType right = t.hasRight() ? (PrimitiveType) t.getRight() : null;
    CanonicalResource crL = left == null ? null : (CanonicalResource) session.getContextLeft().fetchResource(Resource.class, left.primitiveValue());
    CanonicalResource crR = right == null ? null : (CanonicalResource) session.getContextRight().fetchResource(Resource.class, right.primitiveValue());
    String refL = crL != null && crL.hasWebPath() ? crL.getWebPath() : null;
    String dispL = crL != null && refL != null ? crL.present() : left == null ? "" : left.primitiveValue(); 
    String refR = crR != null && crR.hasWebPath() ? crR.getWebPath() : null;
    String dispR = crR != null && refR != null ? crR.present() : right == null ? "" : right.primitiveValue(); 
    r.getCells().add(style(gen.new Cell(null, refL, dispL, null, null), left != null ? left.primitiveValue() : null, right != null ? right.primitiveValue() : null, true));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    r.getCells().add(style(gen.new Cell(null, refR, dispR, null, null), left != null ? left.primitiveValue() : null, right != null ? right.primitiveValue() : null, false));
    r.getCells().add(gen.new Cell(null, null, "", null, null));
    r.getCells().add(cellForMessages(gen, t.getMessages()));
    return r;
  }
  
  private Cell style(Cell cell, String left, String right, boolean isLeft) {
    if (left != null && right != null) {
      if (!left.equals(right)) {
        cell.setStyle("background-color: "+COLOR_DIFFERENT);
      }
    } else if (left != null) {
      if (!isLeft) {        
        cell.setStyle("background-color: "+COLOR_NO_CELL_RIGHT);
      }
    } else if (right != null) {        
      if (isLeft) {        
        cell.setStyle("background-color: "+COLOR_NO_CELL_LEFT);
      }
    }
    return cell;
  }

  @Override
  protected String fhirType() {
    return "CapabilityStatement";
  }

}