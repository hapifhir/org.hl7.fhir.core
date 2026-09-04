package org.hl7.fhir.services.comparison;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.services.comparison.StructureDefinitionComparer.ProfileComparison;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.*;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    compareMetadata(left, right, res.getMetadata(), res, new ArrayList<>(), right);
    comparePrimitives("kind", left.getKindElement(), right.getKindElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    compareCanonicalList("instantiates", left.getInstantiatesList(), right.getInstantiatesList(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getInstantiatesList(), cs1.getInstantiatesList());
    compareCanonicalList("imports", left.getImportsList(), right.getImportsList(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getImportsList(), cs1.getImportsList());
    comparePrimitives("software.name", left.getSoftware().getNameElement(), right.getSoftware().getNameElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("software.version", left.getSoftware().getVersionElement(), right.getSoftware().getVersionElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("software.releaseDate", left.getSoftware().getReleaseDateElement(), right.getSoftware().getReleaseDateElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("implementation.description", left.getImplementation().getDescriptionElement(), right.getImplementation().getDescriptionElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("implementation.url", left.getImplementation().getUrlElement(), right.getImplementation().getUrlElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("fhirVersion", left.getFhirVersionElement(), right.getFhirVersionElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    compareCodeList("format", left.getFormatList(), right.getFormatList(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getFormatList(), cs1.getFormatList());
    compareEnumList("patchFormat", left.getPatchFormatList(), right.getPatchFormatList(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getPatchFormatList(), cs1.getPatchFormatList());
    compareCanonicalList("implementationGuide", left.getImplementationGuideList(), right.getImplementationGuideList(), res.getMetadata(), IssueSeverity.ERROR, res, cs.getImplementationGuideList(), cs1.getImplementationGuideList());


    compareRests(left.getRestList(), right.getRestList(), res.getCombined(), res.getUnion().getRestList(), res.getIntersection().getRestList(), res.getUnion(), res.getIntersection(), res, "CapabilityStatement.rest");
    return res;
  }

  private void compareRests(List<CapabilityStatement.CapabilityStatementRestComponent> left, List<CapabilityStatement.CapabilityStatementRestComponent> right, StructuralMatch<Element> combined, List<CapabilityStatement.CapabilityStatementRestComponent> union, List<CapabilityStatement.CapabilityStatementRestComponent> intersection, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) throws DefinitionException, FHIRFormatError, IOException {
    List<CapabilityStatement.CapabilityStatementRestComponent> matchR = new ArrayList<>();
    for (CapabilityStatement.CapabilityStatementRestComponent l : left) {
      CapabilityStatement.CapabilityStatementRestComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        CapabilityStatement.CapabilityStatementRestComponent cdM = merge(l, r, res);
        CapabilityStatement.CapabilityStatementRestComponent cdI = intersect(l, r, res);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compare(sm, l, r, path+".where(mode='"+l.getMode()+"')", res);
        combined.getChildren().add(sm);
        compareRestSecurity(l, r, sm, cdM.getSecurity(), cdI.getSecurity(), csU, csI, res, path+".security");
        compareRestResources(l, r, sm, cdM, cdI, csU, csI, res, path+".resource");
        compareSearchParams(combined, l.getSearchParamList(), r.getSearchParamList(), path, res, cdM.getSearchParamList(), cdI.getSearchParamList());
        compareOperations(combined, l.getOperationList(), r.getOperationList(), path, res, cdM.getOperationList(), cdI.getOperationList());
        compareItemPropertyList(sm, "compartment", l.getCompartmentList(), r.getCompartmentList(), path, res, cdM.getCompartmentList(), cdI.getCompartmentList(), IssueSeverity.ERROR);
      }
    }
    for (CapabilityStatement.CapabilityStatementRestComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
      }
    }
  }

  private CapabilityStatement.CapabilityStatementRestComponent findInList(List<CapabilityStatement.CapabilityStatementRestComponent> list, CapabilityStatement.CapabilityStatementRestComponent item) {
    for (CapabilityStatement.CapabilityStatementRestComponent t : list) {
      if (t.getMode().equals(item.getMode())) {
        return t;
      }
    }
    return null;
  }

  private void compare(StructuralMatch<Element> sm, CapabilityStatement.CapabilityStatementRestComponent l, CapabilityStatement.CapabilityStatementRestComponent r, String path, CapabilityStatementComparison res) {
    compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.WARNING, res);
  }

  private void compareRestSecurity(CapabilityStatement.CapabilityStatementRestComponent l, CapabilityStatement.CapabilityStatementRestComponent r, StructuralMatch<Element> smp, CapabilityStatement.CapabilityStatementRestSecurityComponent merge, CapabilityStatement.CapabilityStatementRestSecurityComponent intersect, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) {
    CapabilityStatement.CapabilityStatementRestSecurityComponent ls = l.hasSecurity() ? l.getSecurity() : null;
    CapabilityStatement.CapabilityStatementRestSecurityComponent rs = r.hasSecurity() ? r.getSecurity() : null;
    
    StructuralMatch<Element> sm = new StructuralMatch<Element>(ls, rs);
    smp.getChildren().add(sm);
    compareBooleans(path, sm.getMessages(), l.getSecurity().getCorsElement(), r.getSecurity().getCorsElement(), "security.cors", IssueSeverity.WARNING, res);
    compareStrings(path, sm.getMessages(), l.getSecurity().getDescription(), r.getSecurity().getDescription(), "security.description", IssueSeverity.INFORMATION, res);
    compareRestSecurityService(ls, rs, sm, merge, intersect, csU, csI, res, path+".security");    
  }

  private void compareRestSecurityService(CapabilityStatement.CapabilityStatementRestSecurityComponent left, CapabilityStatement.CapabilityStatementRestSecurityComponent right, StructuralMatch<Element> combined, CapabilityStatement.CapabilityStatementRestSecurityComponent union, CapabilityStatement.CapabilityStatementRestSecurityComponent intersection, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) {
    List<CodeableConcept> matchR = new ArrayList<>();
    if (left != null) {
      for (CodeableConcept l : left.getServiceList()) {
        CodeableConcept r = findInList(right.getServiceList(), l);
        if (r == null) {
          union.getServiceList().add(l);
          combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
        } else {
          matchR.add(r);
          CodeableConcept cdM = CodeableConcept.merge(l, r);
          CodeableConcept cdI = CodeableConcept.intersect(l, r);
          union.getServiceList().add(cdM);
          intersection.getServiceList().add(cdI);
          StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
          compare(sm, l, r, path, res);
          combined.getChildren().add(sm);
        }
      }
    }
    if (right != null) {
      for (CodeableConcept r : right.getServiceList()) {
        if (!matchR.contains(r)) {
          union.getServiceList().add(r);
          combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
        }
      }
    }
  }
  

  private void compare(StructuralMatch<Element> sm, CodeableConcept l, CodeableConcept r, String path, CapabilityStatementComparison res) {
    compareStrings(path, sm.getMessages(), l.getText(), r.getText(), "text", IssueSeverity.INFORMATION, res);
    List<Coding> matches = new ArrayList<>();
    for (Coding lc : l.getCodingList()) {
      boolean m = false;
      for (Coding rc : r.getCodingList()) {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //False positive: not using String.matches
        boolean codingMatches = lc.matches(rc);
        if (codingMatches) {
          matches.add(rc);
          m = true;
        }
      }
      if (!m) {
        sm.getMessages().add(vmI(IssueSeverity.INFORMATION, "Value for "+gen(lc)+" removed", path));        
      }      
    }
    for (Coding rc : r.getCodingList()) {
      if (!matches.contains(rc)) {
        sm.getMessages().add(vmI(IssueSeverity.INFORMATION, "Value for "+gen(rc)+" added", path));        
      }
    }    
  }

  private CodeableConcept findInList(List<CodeableConcept> list, CodeableConcept item) {
    for (CodeableConcept t : list) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //False positive: not using String.matches
      boolean conceptMatches = t.matches(item);
      if (conceptMatches) {
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
    List<Extension> l = left.getExtensionsByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT);
    List<Extension> r = right.getExtensionsByUrl(ExtensionDefinitions.EXT_CAP_STMT_EXPECT);
    if (l.size() == 1 || r.size() == 1) {
      if (l.size() == 0) {
        union.addExtension(r.get(0).copy(Base.COPY_DATA));
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this expectation", path), r.get(0)));        
      } else if (r.size() == 0) {
        union.addExtension(l.get(0).copy(Base.COPY_DATA));
        combined.getChildren().add(new StructuralMatch<Element>(l.get(0), vmI(IssueSeverity.INFORMATION, "Removed this expectation", path)));              
      } else if (l.size() == 1 && r.size() == 1) {
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l.get(0), r.get(0));
        combined.getChildren().add(sm);
        String ls = l.get(0).getValue().primitiveValue();
        String rs = r.get(0).getValue().primitiveValue();
        if (ls.equals(rs)) {
          union.addExtension(l.get(0).copy(Base.COPY_DATA));
          intersection.addExtension(l.get(0).copy(Base.COPY_DATA));
        } else {
          sm.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+".extension('http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation')", "Changed value for expectation: '"+ls+"' vs '"+rs+"'", IssueSeverity.WARNING));
          String lowest = lower(ls, rs) ? ls : rs;
          String highest = lower(ls, rs) ? rs : ls;
          union.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(lowest));
          intersection.addExtension(ExtensionDefinitions.EXT_CAP_STMT_EXPECT, new CodeType(highest));
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

  private CapabilityStatement.CapabilityStatementRestComponent merge(CapabilityStatement.CapabilityStatementRestComponent l, CapabilityStatement.CapabilityStatementRestComponent r, CapabilityStatementComparison res) {
    CapabilityStatement.CapabilityStatementRestComponent cd = l.copy(Base.COPY_DATA);
    if (!l.hasDocumentation() && r.hasDocumentation()) {
      cd.setDocumentation(r.getDocumentation());
    }
    if (r.hasSecurity()) {
      if (!l.getSecurity().hasCors() && r.getSecurity().hasCors()) {
        cd.getSecurity().setCors(r.getSecurity().getCors());
      }
      mergeCodeableConcepts(cd.getSecurity().getServiceList(), r.getSecurity().getServiceList());
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
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //False positive: not using String.matches
        boolean conceptMatches = t.matches(cd);
        if (conceptMatches) {
          add = false;
        }
      }
      if (add) {
        tgt.add(cd.copy(Base.COPY_DATA));
      }
    }    
  }

  private CapabilityStatement.CapabilityStatementRestComponent intersect(CapabilityStatement.CapabilityStatementRestComponent l, CapabilityStatement.CapabilityStatementRestComponent r, CapabilityStatementComparison res) {
    CapabilityStatement.CapabilityStatementRestComponent cd = l.copy(Base.COPY_DATA);
    if (l.hasDocumentation() && !r.hasDocumentation()) {
      cd.setDocumentation(null);
    }
    if (!r.hasSecurity()) {
      cd.setSecurity(null);
    } else {
      if (!r.getSecurity().hasCors()) {
        cd.getSecurity().setCorsElement(null);
      }
      intersectCodeableConcepts(cd.getSecurity().getServiceList(), r.getSecurity().getServiceList());
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
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //False positive: not using String.matches
        boolean conceptMatches = t.matches(cd);
        if (conceptMatches) {
          remove = true;
        }
      }
      if (remove) {
        toRemove.add(cd);
      }
    }    
    tgt.removeAll(toRemove);
  }

  private void compareRestResources(CapabilityStatement.CapabilityStatementRestComponent left, CapabilityStatement.CapabilityStatementRestComponent right, StructuralMatch<Element> combined, CapabilityStatement.CapabilityStatementRestComponent union, CapabilityStatement.CapabilityStatementRestComponent intersection, CapabilityStatement csU, CapabilityStatement csI, CapabilityStatementComparison res, String path) throws DefinitionException, FHIRFormatError, IOException {
    List<CapabilityStatement.CapabilityStatementRestResourceComponent> matchR = new ArrayList<>();
    for (CapabilityStatement.CapabilityStatementRestResourceComponent l : left.getResourceList()) {
      CapabilityStatement.CapabilityStatementRestResourceComponent r = findInList(right.getResourceList(), l);
      if (r == null) {
        union.getResourceList().add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        CapabilityStatement.CapabilityStatementRestResourceComponent cdM = mergeRestResource(l, r);
        CapabilityStatement.CapabilityStatementRestResourceComponent cdI = intersectRestResource(l, r);
        union.getResourceList().add(cdM);
        intersection.getResourceList().add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareRestResource(sm, l, r, path, res, cdM, cdI);
        combined.getChildren().add(sm);
      }
    }
    for (CapabilityStatement.CapabilityStatementRestResourceComponent r : right.getResourceList()) {
      if (!matchR.contains(r)) {
        union.getResourceList().add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
      }
    }
  }
  
  private void compareRestResource(StructuralMatch<Element> sm, CapabilityStatement.CapabilityStatementRestResourceComponent l, CapabilityStatement.CapabilityStatementRestResourceComponent r, String path, CapabilityStatementComparison res, CapabilityStatement.CapabilityStatementRestResourceComponent union, CapabilityStatement.CapabilityStatementRestResourceComponent intersection) throws DefinitionException, FHIRFormatError, IOException {
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
    compareItemPropertyList(sm, "referencePolicy", l.getReferencePolicyList(), r.getReferencePolicyList(), path, res, union.getReferencePolicyList(), intersection.getReferencePolicyList(), IssueSeverity.WARNING);
    compareItemPropertyList(sm, "searchInclude", l.getSearchIncludeList(), r.getSearchIncludeList(), path, res, union.getSearchIncludeList(), intersection.getSearchIncludeList(), IssueSeverity.WARNING);
    compareItemPropertyList(sm, "searchRevInclude", l.getSearchRevIncludeList(), r.getSearchRevIncludeList(), path, res, union.getSearchRevIncludeList(), intersection.getSearchRevIncludeList(), IssueSeverity.WARNING);
    compareSearchParams(sm, l.getSearchParamList(), r.getSearchParamList(), path, res, union.getSearchParamList(), intersection.getSearchParamList());
    compareOperations(sm, l.getOperationList(), r.getOperationList(), path, res, union.getOperationList(), intersection.getOperationList());
  }

  private void compareProfiles(String path, StructuralMatch<Element> combined, CanonicalType left, CanonicalType right, CapabilityStatementComparison res, CapabilityStatement.CapabilityStatementRestResourceComponent union, CapabilityStatement.CapabilityStatementRestResourceComponent intersection) throws DefinitionException, FHIRFormatError, IOException {
    if (!left.hasValue() && !right.hasValue()) {
      // nothing in this case 
    } else if (!left.hasValue()) {
      // the intersection is anything in right. The union is everything (or nothing, in this case)
      intersection.setProfileElement(right.copy(Base.COPY_DATA));
      combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.WARNING, "Added this profile", path), right).setName("profile"));        
    } else if (!right.hasValue()) {
      // the intersection is anything in right. The union is everything (or nothing, in this case)
      intersection.setProfileElement(left.copy(Base.COPY_DATA));
      combined.getChildren().add(new StructuralMatch<Element>(left, vmI(IssueSeverity.WARNING, "Removed this profile", path)).setName("profile"));        
    } else {
      // profiles on both sides...
      StructureDefinition sdLeft = session.getContextLeft().fetchResource(StructureDefinition.class, left.getValue(), ExtensionUtilities.getVersionResolutionRules(left));
      StructureDefinition sdRight = session.getContextRight().fetchResource(StructureDefinition.class, right.getValue(), ExtensionUtilities.getVersionResolutionRules(right));
      if (sdLeft == null && sdRight == null) {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.ERROR, "Cannot compare profiles because neither is known", path)).setName("profile"));        
      } else if (sdLeft == null) {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.ERROR, "Cannot compare profiles because '"+left.getValue()+"' is not known", path)).setName("profile"));        
      } else if (sdRight == null) {
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.ERROR, "Cannot compare profiles because '"+right.getValue()+"' is not known", path)).setName("profile"));                
      } else if (sdLeft.getUrl().equals(sdRight.getUrl())) {
        intersection.setProfileElement(left.copy(Base.COPY_DATA));
        union.setProfileElement(left.copy(Base.COPY_DATA));
        combined.getChildren().add(new StructuralMatch<Element>(left, right).setName("profile"));                
      } else if (profileInherits(sdLeft, sdRight, session.getContextLeft())) {
        // if left inherits from right:
        intersection.setProfileElement(left.copy(Base.COPY_DATA));
        union.setProfileElement(right.copy(Base.COPY_DATA));
        combined.getChildren().add(new StructuralMatch<Element>(left, right, vmI(IssueSeverity.WARNING, "Changed this profile to a broader profile", path)).setName("profile"));                
      } else if (profileInherits(sdRight, sdLeft, session.getContextRight())) {
        intersection.setProfileElement(right.copy(Base.COPY_DATA));
        union.setProfileElement(left.copy(Base.COPY_DATA));
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
      sdFocus = ctxt.fetchResource(StructureDefinition.class, sdFocus.getBaseDefinition(), ExtensionUtilities.getVersionResolutionRules(sdFocus.getBaseDefinitionElement()), null,  sdFocus);
    }
    return false;
  }

  private <T> void compareItemProperty(StructuralMatch<Element> combined, String name, PrimitiveType<T> left, PrimitiveType<T> right, String path, CapabilityStatementComparison res, PrimitiveType<T> union, PrimitiveType<T> intersection, IssueSeverity issueSeverity) {
    if (!left.isEmpty() || !right.isEmpty()) {
      if (left.isEmpty()) {
        union.copyValues(right, Base.COPY_DATA);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(issueSeverity, "Added this "+name, path), right).setName(name));        
      } else if (right.isEmpty()) {
        union.copyValues(left, Base.COPY_DATA);
        combined.getChildren().add(new StructuralMatch<Element>(left, vmI(issueSeverity, "Removed this expectation", path)).setName(name));              
      } else {
        StructuralMatch<Element> sm = new StructuralMatch<Element>(left, right).setName(name);
        combined.getChildren().add(sm);
        String ls = left.primitiveValue();
        String rs = right.primitiveValue();
        if (ls.equals(rs)) {
          union.copyValues(left, Base.COPY_DATA);
          intersection.copyValues(left, Base.COPY_DATA);
        } else {
          sm.getMessages().add(new ValidationMessage(Source.ProfileComparer, IssueType.INFORMATIONAL, path+"."+name, "Changed value for "+name+": '"+ls+"' vs '"+rs+"'", issueSeverity));
          union.copyValues(left, Base.COPY_DATA);
          intersection.copyValues(left, Base.COPY_DATA);
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


  private CapabilityStatement.CapabilityStatementRestResourceComponent mergeRestResource(CapabilityStatement.CapabilityStatementRestResourceComponent l, CapabilityStatement.CapabilityStatementRestResourceComponent r) {
    CapabilityStatement.CapabilityStatementRestResourceComponent res = l.copy(Base.COPY_DATA);
    // todo: compare profiles, not just copy
    if (!l.hasProfile() && r.hasProfile()) {
      res.setProfile(r.getProfile());
    }
    if (!l.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatement.CapabilityStatementRestResourceComponent intersectRestResource(CapabilityStatement.CapabilityStatementRestResourceComponent l, CapabilityStatement.CapabilityStatementRestResourceComponent r) {
    CapabilityStatement.CapabilityStatementRestResourceComponent res = new CapabilityStatement.CapabilityStatementRestResourceComponent();
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

  private CapabilityStatement.CapabilityStatementRestResourceComponent findInList(List<CapabilityStatement.CapabilityStatementRestResourceComponent> list, CapabilityStatement.CapabilityStatementRestResourceComponent item) {
    for (CapabilityStatement.CapabilityStatementRestResourceComponent t : list) {
      if (t.hasType() && t.getType().equals(item.getType())) {
        return t;
      }
    }
    return null;
  }

  private void compareRestResourceInteractions(StructuralMatch<Element> combined, CapabilityStatement.CapabilityStatementRestResourceComponent left, CapabilityStatement.CapabilityStatementRestResourceComponent right, String path, CapabilityStatementComparison res, CapabilityStatement.CapabilityStatementRestResourceComponent union, CapabilityStatement.CapabilityStatementRestResourceComponent intersection) {
    List<CapabilityStatement.ResourceInteractionComponent> matchR = new ArrayList<>();
    for (CapabilityStatement.ResourceInteractionComponent l : left.getInteractionList()) {
      CapabilityStatement.ResourceInteractionComponent r = findInList(right.getInteractionList(), l);
      if (r == null) {
        union.getInteractionList().add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this item", path)));
      } else {
        matchR.add(r);
        CapabilityStatement.ResourceInteractionComponent cdM = mergeRestResourceInteractions(l, r);
        CapabilityStatement.ResourceInteractionComponent cdI = intersectRestResourceInteractions(l, r);
        union.getInteractionList().add(cdM);
        intersection.getInteractionList().add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.INFORMATION, res);
        compareExpectations(sm, l, r, path, res, union, intersection);    
        combined.getChildren().add(sm);
      }
    }
    for (CapabilityStatement.ResourceInteractionComponent r : right.getInteractionList()) {
      if (!matchR.contains(r)) {
        union.getInteractionList().add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this concept", path), r));        
      }
    }
  }

  private CapabilityStatement.ResourceInteractionComponent mergeRestResourceInteractions(CapabilityStatement.ResourceInteractionComponent l, CapabilityStatement.ResourceInteractionComponent r) {
    CapabilityStatement.ResourceInteractionComponent res = l.copy(Base.COPY_DATA);
    if (!res.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatement.ResourceInteractionComponent intersectRestResourceInteractions(CapabilityStatement.ResourceInteractionComponent l, CapabilityStatement.ResourceInteractionComponent r) {
    CapabilityStatement.ResourceInteractionComponent res = l.copy(Base.COPY_DATA);
    if (res.hasDocumentation() && !r.hasDocumentation()) {
      res.setDocumentation(null);
    }
    return res;
  }

  private CapabilityStatement.ResourceInteractionComponent findInList(List<CapabilityStatement.ResourceInteractionComponent> list, CapabilityStatement.ResourceInteractionComponent item) {
    for (CapabilityStatement.ResourceInteractionComponent t : list) {
      if (t.hasCode() && t.getCode().equals(item.getCode())) {
        return t;
      }
    }
    return null;
  }


  private void compareSearchParams(StructuralMatch<Element> combined, List<CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent> left,  List<CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent> right, String path, CapabilityStatementComparison res,  List<CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent> union, List<CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent> intersection) {
    List<CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent> matchR = new ArrayList<>();
    for (CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent l : left) {
      CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this Search Parameter", path)));
      } else {
        matchR.add(r);
        CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent cdM = mergeSearchParams(l, r);
        CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent cdI = intersectSearchParams(l, r);
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
    for (CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this Search Parameter", path), r));        
      }
    }
  }
  
  private CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent mergeSearchParams(CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent l, CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent r) {
    CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent res = l.copy(Base.COPY_DATA);
    if (!res.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent intersectSearchParams(CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent l, CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent r) {
    CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent res = new CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    res.setName(l.getName());
    if (l.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(l.getDocumentation());
    }
    return res;
  }

  private CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent findInList(List<CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent> list, CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent item) {
    for (CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : list) {
      if (t.hasName() && t.getName().equals(item.getName())) {
        return t;
      }
    }
    return null;
  }


  private void compareOperations(StructuralMatch<Element> combined, List<CapabilityStatement.CapabilityStatementRestResourceOperationComponent> left,  List<CapabilityStatement.CapabilityStatementRestResourceOperationComponent> right, String path, CapabilityStatementComparison res,  List<CapabilityStatement.CapabilityStatementRestResourceOperationComponent> union, List<CapabilityStatement.CapabilityStatementRestResourceOperationComponent> intersection) {
    List<CapabilityStatement.CapabilityStatementRestResourceOperationComponent> matchR = new ArrayList<>();
    for (CapabilityStatement.CapabilityStatementRestResourceOperationComponent l : left) {
      CapabilityStatement.CapabilityStatementRestResourceOperationComponent r = findInList(right, l);
      if (r == null) {
        union.add(l);
        combined.getChildren().add(new StructuralMatch<Element>(l, vmI(IssueSeverity.INFORMATION, "Removed this Search Parameter", path)));
      } else {
        matchR.add(r);
        CapabilityStatement.CapabilityStatementRestResourceOperationComponent cdM = mergeOperations(l, r);
        CapabilityStatement.CapabilityStatementRestResourceOperationComponent cdI = intersectOperations(l, r);
        union.add(cdM);
        intersection.add(cdI);
        StructuralMatch<Element> sm = new StructuralMatch<Element>(l, r);
        compareStrings(path, sm.getMessages(), l.getDocumentation(), r.getDocumentation(), "documentation", IssueSeverity.INFORMATION, res);
        compareItemProperty(sm, "definition", l.getDefinitionElement(), r.getDefinitionElement(), path, res, cdM.getDefinitionElement(), cdI.getDefinitionElement(), IssueSeverity.ERROR);
        compareExpectations(sm, l, r, path, res, cdM, cdI);    
        combined.getChildren().add(sm);
      }
    }
    for (CapabilityStatement.CapabilityStatementRestResourceOperationComponent r : right) {
      if (!matchR.contains(r)) {
        union.add(r);
        combined.getChildren().add(new StructuralMatch<Element>(vmI(IssueSeverity.INFORMATION, "Added this Search Parameter", path), r));        
      }
    }
  }
  
  private CapabilityStatement.CapabilityStatementRestResourceOperationComponent mergeOperations(CapabilityStatement.CapabilityStatementRestResourceOperationComponent l, CapabilityStatement.CapabilityStatementRestResourceOperationComponent r) {
    CapabilityStatement.CapabilityStatementRestResourceOperationComponent res = l.copy(Base.COPY_DATA);
    if (!res.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(r.getDocumentation());
    }
    return res;
  }

  private CapabilityStatement.CapabilityStatementRestResourceOperationComponent intersectOperations(CapabilityStatement.CapabilityStatementRestResourceOperationComponent l, CapabilityStatement.CapabilityStatementRestResourceOperationComponent r) {
    CapabilityStatement.CapabilityStatementRestResourceOperationComponent res = new CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
    res.setName(l.getName());
    if (l.hasDocumentation() && r.hasDocumentation()) {
      res.setDocumentation(l.getDocumentation());
    }
    return res;
  }

  private CapabilityStatement.CapabilityStatementRestResourceOperationComponent findInList(List<CapabilityStatement.CapabilityStatementRestResourceOperationComponent> list, CapabilityStatement.CapabilityStatementRestResourceOperationComponent item) {
    for (CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : list) {
      if (t.hasName() && t.getName().equals(item.getName())) {
        return t;
      }
    }
    return null;
  }

  
  // 6 columns: path | left value | left doco | right value | right doco | comments
  public XhtmlNode renderStatements(CapabilityStatementComparison comparison, String id, String prefix) throws FHIRException, IOException {
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(new RenderingI18nContext(), Utilities.path("[tmp]", "compare"), false, "c");
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
    if (t.either() instanceof CapabilityStatement.CapabilityStatementRestComponent) {
      r = addRestRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatement.CapabilityStatementRestSecurityComponent) {
      r = addRestSecurityRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatement.CapabilityStatementRestResourceComponent) {
      r = addRestResourceRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatement.ResourceInteractionComponent) {
      r = addRestResourceInteractionRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent) {
      r = addRestSearchParamRow(gen, rows, t, comparison);
    } else if (t.either() instanceof CapabilityStatement.CapabilityStatementRestResourceOperationComponent) {
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
    CapabilityStatement.CapabilityStatementRestComponent left = t.hasLeft() ? (CapabilityStatement.CapabilityStatementRestComponent) t.getLeft() : null;
    CapabilityStatement.CapabilityStatementRestComponent right = t.hasRight() ? (CapabilityStatement.CapabilityStatementRestComponent) t.getRight() : null;
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
    CapabilityStatement.CapabilityStatementRestSecurityComponent left = t.hasLeft() ? (CapabilityStatement.CapabilityStatementRestSecurityComponent) t.getLeft() : null;
    CapabilityStatement.CapabilityStatementRestSecurityComponent right = t.hasRight() ? (CapabilityStatement.CapabilityStatementRestSecurityComponent) t.getRight() : null;
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
    CapabilityStatement.CapabilityStatementRestResourceComponent left = t.hasLeft() ? (CapabilityStatement.CapabilityStatementRestResourceComponent) t.getLeft() : null;
    CapabilityStatement.CapabilityStatementRestResourceComponent right = t.hasRight() ? (CapabilityStatement.CapabilityStatementRestResourceComponent) t.getRight() : null;
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
    CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent left = t.hasLeft() ? (CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent) t.getLeft() : null;
    CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent right = t.hasRight() ? (CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent) t.getRight() : null;
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
    CapabilityStatement.CapabilityStatementRestResourceOperationComponent left = t.hasLeft() ? (CapabilityStatement.CapabilityStatementRestResourceOperationComponent) t.getLeft() : null;
    CapabilityStatement.CapabilityStatementRestResourceOperationComponent right = t.hasRight() ? (CapabilityStatement.CapabilityStatementRestResourceOperationComponent) t.getRight() : null;
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
    CapabilityStatement.ResourceInteractionComponent left = t.hasLeft() ? (CapabilityStatement.ResourceInteractionComponent) t.getLeft() : null;
    CapabilityStatement.ResourceInteractionComponent right = t.hasRight() ? (CapabilityStatement.ResourceInteractionComponent) t.getRight() : null;
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
    CanonicalResource crL = left == null ? null : (CanonicalResource) session.getContextLeft().fetchResource(Resource.class, left.primitiveValue(), ExtensionUtilities.getVersionResolutionRules(left));
    CanonicalResource crR = right == null ? null : (CanonicalResource) session.getContextRight().fetchResource(Resource.class, right.primitiveValue(), ExtensionUtilities.getVersionResolutionRules(right));
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