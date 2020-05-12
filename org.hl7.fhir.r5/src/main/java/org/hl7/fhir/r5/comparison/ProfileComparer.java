package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.CanonicalResourceComparison;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.OldProfileComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.DefinitionNavigator;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.model.ValueSet;

public class ProfileComparer extends CanonicalResourceComparer {

  public class ProfileComparison extends CanonicalResourceComparison<StructureDefinition> {

    private StructuralMatch<ElementDefinition> combined;                                             

    public ProfileComparison(StructureDefinition left, StructureDefinition right) {
      super(left, right);
      combined = new StructuralMatch<ElementDefinition>(); // base
    }

    public StructuralMatch<ElementDefinition> getCombined() {
      return combined;
    }
  }

  public ProfileComparer(ComparisonSession session) {
    super(session);
  }

  @Override
  protected String fhirType() {
    return "StructureDefinition";
  }

  public ProfileComparison compare(StructureDefinition left, StructureDefinition right) throws DefinitionException, FHIRFormatError, IOException {
    check(left, "left");
    check(right, "right");

    ProfileComparison res = new ProfileComparison(left, right);
    session.identify(res);
    StructureDefinition sd = new StructureDefinition();
    res.setUnion(sd);
    session.identify(sd);
    sd.setName("Union"+left.getName()+"And"+right.getName());
    sd.setTitle("Union of "+left.getTitle()+" And "+right.getTitle());
    sd.setStatus(left.getStatus());
    sd.setDate(new Date());

    StructureDefinition sd1 = new StructureDefinition();
    res.setIntersection(sd1);
    session.identify(sd1);
    sd1.setName("Intersection"+left.getName()+"And"+right.getName());
    sd1.setTitle("Intersection of "+left.getTitle()+" And "+right.getTitle());
    sd1.setStatus(left.getStatus());
    sd1.setDate(new Date());

    compareMetadata(left, right, res.getMetadata(), res);
    comparePrimitives("fhirVersion", left.getFhirVersionElement(), right.getFhirVersionElement(), res.getMetadata(), IssueSeverity.WARNING, res);
    comparePrimitives("kind", left.getKindElement(), right.getKindElement(), res.getMetadata(), IssueSeverity.WARNING, res);
    comparePrimitives("abstract", left.getAbstractElement(), right.getAbstractElement(), res.getMetadata(), IssueSeverity.WARNING, res);
    comparePrimitives("type", left.getTypeElement(), right.getTypeElement(), res.getMetadata(), IssueSeverity.ERROR, res);
    comparePrimitives("baseDefinition", left.getBaseDefinitionElement(), right.getBaseDefinitionElement(), res.getMetadata(), IssueSeverity.ERROR, res);

    if (left.getType().equals(right.getType())) {
      DefinitionNavigator ln = new DefinitionNavigator(session.getContext(), left);
      DefinitionNavigator rn = new DefinitionNavigator(session.getContext(), right);
      StructuralMatch<ElementDefinition> sm = new StructuralMatch<ElementDefinition>(ln.current(), rn.current());
      compareElements(res, sm, ln.path(), null, ln, rn);
    }
    return res;
  }

  private void check(StructureDefinition sd, String name) {
    if (sd == null)
      throw new DefinitionException("No StructureDefinition provided ("+name+": "+sd.getName()+")");
    if (sd.getType().equals("Extension")) {
      throw new DefinitionException("StructureDefinition is for an extension - use ExtensionComparer instead ("+name+": "+sd.getName()+")");
    }
    if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
      throw new DefinitionException("StructureDefinition is not for an profile - can't be compared ("+name+": "+sd.getName()+")");
    }
    if (sd.getSnapshot().getElement().isEmpty())
      throw new DefinitionException("StructureDefinition snapshot is empty ("+name+": "+sd.getName()+")");
  }

  private void compareElements(ProfileComparison comp, StructuralMatch<ElementDefinition> res,  String path, String sliceName, DefinitionNavigator left, DefinitionNavigator right) throws DefinitionException, FHIRFormatError, IOException {
    assert(path != null);  
    assert(left != null);
    assert(right != null);
    assert(left.path().equals(right.path()));

    // not allowed to be different:   
    ruleEqual(comp, res, left.current().getDefaultValue(), right.current().getDefaultValue(), "defaultValue", path);
    ruleEqual(comp, res, left.current().getMeaningWhenMissingElement(), right.current().getMeaningWhenMissingElement(), "meaningWhenMissing", path);
    ruleEqual(comp, res, left.current().getIsModifierElement(), right.current().getIsModifierElement(), "isModifier", path);
    ruleEqual(comp, res, left.current().getIsSummaryElement(), right.current().getIsSummaryElement(), "isSummary", path);

    // we ignore slicing right now - we're going to clone the root one anyway, and then think about clones 
    // simple stuff
    ElementDefinition subset = new ElementDefinition();
    subset.setPath(left.path());
    if (sliceName != null)
      subset.setSliceName(sliceName);


    subset.getRepresentation().addAll(left.current().getRepresentation()); // can't be bothered even testing this one
    subset.setDefaultValue(left.current().getDefaultValue());
    subset.setMeaningWhenMissing(left.current().getMeaningWhenMissing());
    subset.setIsModifier(left.current().getIsModifier());
    subset.setIsSummary(left.current().getIsSummary());

    // descriptive properties from ElementDefinition - merge them:
    subset.setLabel(mergeText(comp, res, path, "label", left.current().getLabel(), right.current().getLabel()));
    subset.setShort(mergeText(comp, res, path, "short", left.current().getShort(), right.current().getShort()));
    subset.setDefinition(mergeText(comp, res, path, "definition", left.current().getDefinition(), right.current().getDefinition()));
    subset.setComment(mergeText(comp, res, path, "comments", left.current().getComment(), right.current().getComment()));
    subset.setRequirements(mergeText(comp, res, path, "requirements", left.current().getRequirements(), right.current().getRequirements()));
    subset.getCode().addAll(mergeCodings(left.current().getCode(), right.current().getCode()));
    subset.getAlias().addAll(mergeStrings(left.current().getAlias(), right.current().getAlias()));
    subset.getMapping().addAll(mergeMappings(left.current().getMapping(), right.current().getMapping()));
    // left will win for example
    subset.setExample(left.current().hasExample() ? left.current().getExample() : right.current().getExample());

    subset.setMustSupport(left.current().getMustSupport() || right.current().getMustSupport());
    ElementDefinition superset = subset.copy();


    // compare and intersect
    superset.setMin(unionMin(left.current().getMin(), right.current().getMin()));
    superset.setMax(unionMax(left.current().getMax(), right.current().getMax()));
    subset.setMin(intersectMin(left.current().getMin(), right.current().getMin()));
    subset.setMax(intersectMax(left.current().getMax(), right.current().getMax()));
    rule(comp, res, subset.getMax().equals("*") || Integer.parseInt(subset.getMax()) >= subset.getMin(), path, "Cardinality Mismatch: "+card(left)+"/"+card(right));

    superset.getType().addAll(unionTypes(comp, res, path, left.current().getType(), right.current().getType()));
    subset.getType().addAll(intersectTypes(comp, res, subset, path, left.current().getType(), right.current().getType()));
    rule(comp, res, !subset.getType().isEmpty() || (!left.current().hasType() && !right.current().hasType()), path, "Type Mismatch:\r\n  "+typeCode(left)+"\r\n  "+typeCode(right));
    //    <fixed[x]><!-- ?? 0..1 * Value must be exactly this --></fixed[x]>
    //    <pattern[x]><!-- ?? 0..1 * Value must have at least these property values --></pattern[x]>
    superset.setMaxLengthElement(unionMaxLength(left.current().getMaxLength(), right.current().getMaxLength()));
    subset.setMaxLengthElement(intersectMaxLength(left.current().getMaxLength(), right.current().getMaxLength()));
    if (left.current().hasBinding() || right.current().hasBinding()) {
      compareBindings(comp, res, subset, superset, path, left.current(), right.current());
    }
    // note these are backwards
    superset.getConstraint().addAll(intersectConstraints(path, left.current().getConstraint(), right.current().getConstraint()));
    subset.getConstraint().addAll(unionConstraints(comp, res, path, left.current().getConstraint(), right.current().getConstraint()));
    comp.getIntersection().getSnapshot().getElement().add(subset);
    comp.getUnion().getSnapshot().getElement().add(superset);

    // add the children
    compareChildren(comp, res, path, left, right);
//
//    // now process the slices
//    if (left.current().hasSlicing() || right.current().hasSlicing()) {
//      assert sliceName == null;
//      if (isExtension(left.path()))
//        return compareExtensions(outcome, path, superset, subset, left, right);
//      //      return true;
//      else {
//        ElementDefinitionSlicingComponent slicingL = left.current().getSlicing();
//        ElementDefinitionSlicingComponent slicingR = right.current().getSlicing();
//        // well, this is tricky. If one is sliced, and the other is not, then in general, the union just ignores the slices, and the intersection is the slices.
//        if (left.current().hasSlicing() && !right.current().hasSlicing()) { 
//          // the super set is done. Any restrictions in the slices are irrelevant to what the super set says, except that we're going sum up the value sets if we can (for documentation purposes) (todo)
//          // the minimum set is the slicing specified in the slicer
//          subset.setSlicing(slicingL);
//          // stick everything from the right to do with the slices to the subset 
//          copySlices(outcome.subset.getSnapshot().getElement(), left.getStructure().getSnapshot().getElement(), left.slices());
//        } else if (!left.current().hasSlicing() && right.current().hasSlicing()) { 
//          // the super set is done. Any restrictions in the slices are irrelevant to what the super set says, except that we're going sum up the value sets if we can (for documentation purposes) (todo)
//          // the minimum set is the slicing specified in the slicer
//          subset.setSlicing(slicingR);
//          // stick everything from the right to do with the slices to the subset 
//          copySlices(outcome.subset.getSnapshot().getElement(), right.getStructure().getSnapshot().getElement(), right.slices());
//        } else if (isTypeSlicing(slicingL) || isTypeSlicing(slicingR)) {
//          superset.getSlicing().setRules(SlicingRules.OPEN).setOrdered(false).addDiscriminator().setType(DiscriminatorType.TYPE).setPath("$this");
//          subset.getSlicing().setRules(slicingL.getRules() == SlicingRules.CLOSED || slicingR.getRules() == SlicingRules.CLOSED ? SlicingRules.OPEN : SlicingRules.CLOSED).setOrdered(false).addDiscriminator().setType(DiscriminatorType.TYPE).setPath("$this");
//
//          // the superset is the union of the types 
//          // the subset is the intersection of them 
//          List<DefinitionNavigator> handled = new ArrayList<>();
//          for (DefinitionNavigator t : left.slices()) {
//            DefinitionNavigator r = findMatchingSlice(right.slices(), t);
//            if (r == null) {
//              copySlice(outcome.superset.getSnapshot().getElement(), left.getStructure().getSnapshot().getElement(), t);              
//            } else {
//              handled.add(r);
//              ret = compareElements(outcome, path+":"+t.current().getSliceName(), t, r, t.current().getSliceName()) && ret;
//            }
//          }
//          for (DefinitionNavigator t : right.slices()) {
//            if (!handled.contains(t)) {
//              copySlice(outcome.superset.getSnapshot().getElement(), right.getStructure().getSnapshot().getElement(), t);
//            }
//          }
//        } else if (slicingMatches(slicingL, slicingR)) {
//          // if it's the same, we can try matching the slices - though we might have to give up without getting matches correct
//          // there amy be implied consistency we can't reason about 
//          throw new DefinitionException("Slicing matches but is not handled yet at "+left.current().getId()+": ("+ProfileUtilities.summarizeSlicing(slicingL)+")");
//        } else  {
//          // if the slicing is different, we can't compare them - or can we?
//          throw new DefinitionException("Slicing doesn't match at "+left.current().getId()+": ("+ProfileUtilities.summarizeSlicing(slicingL)+" / "+ProfileUtilities.summarizeSlicing(slicingR)+")");
//        }
//      }
//      // todo: name 
//    }
//    return ret;
//
//    // TODO Auto-generated method stub
//    return null;
  }

  private void compareChildren(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, DefinitionNavigator left, DefinitionNavigator right) throws DefinitionException, IOException, FHIRFormatError {
    List<DefinitionNavigator> lc = left.children();
    List<DefinitionNavigator> rc = right.children();
    // it's possible that one of these profiles walks into a data type and the other doesn't
    // if it does, we have to load the children for that data into the profile that doesn't 
    // walk into it
    if (lc.isEmpty() && !rc.isEmpty() && right.current().getType().size() == 1 && left.hasTypeChildren(right.current().getType().get(0)))
      lc = left.childrenFromType(right.current().getType().get(0));
    if (rc.isEmpty() && !lc.isEmpty() && left.current().getType().size() == 1 && right.hasTypeChildren(left.current().getType().get(0)))
      rc = right.childrenFromType(left.current().getType().get(0));
    
    List<DefinitionNavigator> matchR = new ArrayList<>();
    for (DefinitionNavigator l : lc) {
      DefinitionNavigator r = findInList(rc, l);
      if (r == null) {
        comp.getUnion().getSnapshot().getElement().add(l.current().copy());
        res.getChildren().add(new StructuralMatch<ElementDefinition>(l.current(), vmI(IssueSeverity.INFORMATION, "Removed this element", path)));
      } else {
        matchR.add(r);
        StructuralMatch<ElementDefinition> sm = new StructuralMatch<ElementDefinition>(l.current(), r.current());
        res.getChildren().add(sm);
        compareElements(comp, sm, l.path(), null, left, right);
      }
    }
    for (DefinitionNavigator r : rc) {
      if (!matchR.contains(r)) {
        comp.getUnion().getSnapshot().getElement().add(r.current().copy());
        res.getChildren().add(new StructuralMatch<ElementDefinition>(vmI(IssueSeverity.INFORMATION, "Added this element", path), r.current()));        
      }
    }
  }

  private DefinitionNavigator findInList(List<DefinitionNavigator> rc, DefinitionNavigator l) {
    for (DefinitionNavigator t : rc) {
      if (t.current().getPath().equals(l.current().getPath())) {
        return t;
      }
    }
    return null;
  }

  private void ruleEqual(ProfileComparison comp, StructuralMatch<ElementDefinition> res, DataType vLeft, DataType vRight, String name, String path) throws IOException {
    if (vLeft == null && vRight == null) {
      // nothing
    } else if (vLeft == null) {
      vm(IssueSeverity.ERROR, "Added "+name, path, comp.getMessages(), res.getMessages());
    } else if (vRight == null) {
      vm(IssueSeverity.ERROR, "Removed "+name, path, comp.getMessages(), res.getMessages());
    } else if (Base.compareDeep(vLeft, vRight, false)) {
      vm(IssueSeverity.ERROR, name+" be the same ("+toString(vLeft)+"/"+toString(vRight)+")", path, comp.getMessages(), res.getMessages());
    }
  }

  private String toString(DataType val) throws IOException {
    if (val instanceof PrimitiveType) 
      return "\"" + ((PrimitiveType) val).getValueAsString()+"\"";
    
    IParser jp = session.getContext().newJsonParser();
    return jp.composeString(val, "value");
  }
  
  private String stripLinks(String s) {
    while (s.contains("](")) {
      int i = s.indexOf("](");
      int j = s.substring(i).indexOf(")");
      if (j == -1)
        return s;
      else
        s = s.substring(0, i+1)+s.substring(i+j+1);
    }
    return s;
  }
  
  private boolean rule(ProfileComparison comp, StructuralMatch<ElementDefinition> res, boolean test, String path, String message) {
    if (!test)  {
      vm(IssueSeverity.ERROR, message, path, comp.getMessages(), res.getMessages());
    }
    return test;
  }

  private String mergeText(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, String name, String left, String right) {
    if (left == null && right == null)
      return null;
    if (left == null)
      return right;
    if (right == null)
      return left;
    left = stripLinks(left);
    right = stripLinks(right);
    if (left.equalsIgnoreCase(right))
      return left;
    if (path != null) {
      vm(IssueSeverity.ERROR, "Elements differ in definition for "+name+":\r\n  \""+left+"\"\r\n  \""+right+"\"", path, comp.getMessages(), res.getMessages());
    }
    return "left: "+left+"; right: "+right;
  }


  private List<Coding> mergeCodings(List<Coding> left, List<Coding> right) {
    List<Coding> result = new ArrayList<Coding>();
    result.addAll(left);
    for (Coding c : right) {
      boolean found = false;
      for (Coding ct : left)
        if (Utilities.equals(c.getSystem(), ct.getSystem()) && Utilities.equals(c.getCode(), ct.getCode()))
          found = true;
      if (!found)
        result.add(c);
    }
    return result;
  }


  private List<StringType> mergeStrings(List<StringType> left, List<StringType> right) {
    List<StringType> result = new ArrayList<StringType>();
    result.addAll(left);
    for (StringType c : right) {
      boolean found = false;
      for (StringType ct : left)
        if (Utilities.equals(c.getValue(), ct.getValue()))
          found = true;
      if (!found)
        result.add(c);
    }
    return result;
  }

  private List<ElementDefinitionMappingComponent> mergeMappings(List<ElementDefinitionMappingComponent> left, List<ElementDefinitionMappingComponent> right) {
    List<ElementDefinitionMappingComponent> result = new ArrayList<ElementDefinitionMappingComponent>();
    result.addAll(left);
    for (ElementDefinitionMappingComponent c : right) {
      boolean found = false;
      for (ElementDefinitionMappingComponent ct : left)
        if (Utilities.equals(c.getIdentity(), ct.getIdentity()) && Utilities.equals(c.getLanguage(), ct.getLanguage()) && Utilities.equals(c.getMap(), ct.getMap()))
          found = true;
      if (!found)
        result.add(c);
    }
    return result;
  }

  private int intersectMin(int left, int right) {
    if (left > right)
      return left;
    else
      return right;
  }

  private int unionMin(int left, int right) {
    if (left > right)
      return right;
    else
      return left;
  }

  private String intersectMax(String left, String right) {
    int l = "*".equals(left) ? Integer.MAX_VALUE : Integer.parseInt(left);
    int r = "*".equals(right) ? Integer.MAX_VALUE : Integer.parseInt(right);
    if (l < r)
      return left;
    else
      return right;
  }

  private String unionMax(String left, String right) {
    int l = "*".equals(left) ? Integer.MAX_VALUE : Integer.parseInt(left);
    int r = "*".equals(right) ? Integer.MAX_VALUE : Integer.parseInt(right);
    if (l < r)
      return right;
    else
      return left;
  }

  private IntegerType intersectMaxLength(int left, int right) {
    if (left == 0) 
      left = Integer.MAX_VALUE;
    if (right == 0) 
      right = Integer.MAX_VALUE;
    if (left < right)
      return left == Integer.MAX_VALUE ? null : new IntegerType(left);
    else
      return right == Integer.MAX_VALUE ? null : new IntegerType(right);
  }

  private IntegerType unionMaxLength(int left, int right) {
    if (left == 0) 
      left = Integer.MAX_VALUE;
    if (right == 0) 
      right = Integer.MAX_VALUE;
    if (left < right)
      return right == Integer.MAX_VALUE ? null : new IntegerType(right);
    else
      return left == Integer.MAX_VALUE ? null : new IntegerType(left);
  }

  private String card(DefinitionNavigator defn) {
    return Integer.toString(defn.current().getMin())+".."+defn.current().getMax();
  }


  private Collection<? extends TypeRefComponent> unionTypes(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, List<TypeRefComponent> left, List<TypeRefComponent> right) throws DefinitionException, IOException, FHIRFormatError {
    List<TypeRefComponent> result = new ArrayList<TypeRefComponent>();
    for (TypeRefComponent l : left) 
      checkAddTypeUnion(comp, res, path, result, l);
    for (TypeRefComponent r : right) 
      checkAddTypeUnion(comp, res, path, result, r);
    return result;
  }    

  private void checkAddTypeUnion(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, List<TypeRefComponent> results, TypeRefComponent nw) throws DefinitionException, IOException, FHIRFormatError {
    boolean pfound = false;
    boolean tfound = false;
    nw = nw.copy();
    if (nw.hasAggregation())
      throw new DefinitionException("Aggregation not supported: "+path);
    for (TypeRefComponent ex : results) {
      if (Utilities.equals(ex.getWorkingCode(), nw.getWorkingCode())) {
        if (!ex.hasProfile() && !nw.hasProfile())
          pfound = true;
        else if (!ex.hasProfile()) {
          pfound = true; 
        } else if (!nw.hasProfile()) {
          pfound = true;
          ex.setProfile(null);
        } else {
          // both have profiles. Is one derived from the other? 
          StructureDefinition sdex = session.getContext().fetchResource(StructureDefinition.class, ex.getProfile().get(0).getValue());
          StructureDefinition sdnw = session.getContext().fetchResource(StructureDefinition.class, nw.getProfile().get(0).getValue());
          if (sdex != null && sdnw != null) {
            if (sdex == sdnw) {
              pfound = true;
            } else if (derivesFrom(sdex, sdnw)) {
              ex.setProfile(nw.getProfile());
              pfound = true;
            } else if (derivesFrom(sdnw, sdex)) {
              pfound = true;
            } else if (sdnw.getSnapshot().getElement().get(0).getPath().equals(sdex.getSnapshot().getElement().get(0).getPath())) {
              ProfileComparison compP = (ProfileComparison) session.compare(sdex, sdnw);
              if (compP != null && compP.getUnion() != null) { // might be null if circular
                pfound = true;
                ex.addProfile("#"+compP.getId());
              }
            }
          }
        }        
        if (!ex.hasTargetProfile() && !nw.hasTargetProfile())
          tfound = true;
        else if (!ex.hasTargetProfile()) {
          tfound = true; 
        } else if (!nw.hasTargetProfile()) {
          tfound = true;
          ex.setTargetProfile(null);
        } else {
          // both have profiles. Is one derived from the other? 
          StructureDefinition sdex = session.getContext().fetchResource(StructureDefinition.class, ex.getTargetProfile().get(0).getValue());
          StructureDefinition sdnw = session.getContext().fetchResource(StructureDefinition.class, nw.getTargetProfile().get(0).getValue());
          if (sdex != null && sdnw != null) {
            if (sdex == sdnw) {
              tfound = true;
            } else if (derivesFrom(sdex, sdnw)) {
              ex.setTargetProfile(nw.getTargetProfile());
              tfound = true;
            } else if (derivesFrom(sdnw, sdex)) {
              tfound = true;
            } else if (sdnw.getSnapshot().getElement().get(0).getPath().equals(sdex.getSnapshot().getElement().get(0).getPath())) {
              ProfileComparison compP = (ProfileComparison) session.compare(sdex, sdnw);
              if (compP.getUnion() != null) {
                tfound = true;
                ex.addTargetProfile("#"+compP.getId());
              }
            }
          }
        }        
      }
    }
    if (!tfound || !pfound)
      results.add(nw);      
  }


  private boolean derivesFrom(StructureDefinition left, StructureDefinition right) {
    // left derives from right if it's base is the same as right
    // todo: recursive...
    return left.hasBaseDefinition() && left.getBaseDefinition().equals(right.getUrl());
  }


  private Collection<? extends TypeRefComponent> intersectTypes(ProfileComparison comp, StructuralMatch<ElementDefinition> res, ElementDefinition ed, String path, List<TypeRefComponent> left, List<TypeRefComponent> right) throws DefinitionException, IOException, FHIRFormatError {
    List<TypeRefComponent> result = new ArrayList<TypeRefComponent>();
    for (TypeRefComponent l : left) {
      if (l.hasAggregation())
        throw new DefinitionException("Aggregation not supported: "+path);
      boolean pfound = false;
      boolean tfound = false;
      TypeRefComponent c = l.copy();
      for (TypeRefComponent r : right) {
        if (r.hasAggregation())
          throw new DefinitionException("Aggregation not supported: "+path);
        if (!l.hasProfile() && !r.hasProfile()) {
          pfound = true;    
        } else if (!r.hasProfile()) {
          pfound = true; 
        } else if (!l.hasProfile()) {
          pfound = true;
          c.setProfile(r.getProfile());
        } else {
          StructureDefinition sdl = resolveProfile(comp, res, path, l.getProfile().get(0).getValue(), comp.getLeft().getName());
          StructureDefinition sdr = resolveProfile(comp, res, path, r.getProfile().get(0).getValue(), comp.getRight().getName());
          if (sdl != null && sdr != null) {
            if (sdl == sdr) {
              pfound = true;
            } else if (derivesFrom(sdl, sdr)) {
              pfound = true;
            } else if (derivesFrom(sdr, sdl)) {
              c.setProfile(r.getProfile());
              pfound = true;
            } else if (sdl.getType().equals(sdr.getType())) {
              ProfileComparison compP = (ProfileComparison) session.compare(sdl, sdr);
              if (compP != null && compP.getIntersection() != null) {
                pfound = true;
                c.addProfile("#"+compP.getId());
              }
            }
          }
        }
        if (!l.hasTargetProfile() && !r.hasTargetProfile()) {
          tfound = true;    
        } else if (!r.hasTargetProfile()) {
          tfound = true; 
        } else if (!l.hasTargetProfile()) {
          tfound = true;
          c.setTargetProfile(r.getTargetProfile());
        } else {
          StructureDefinition sdl = resolveProfile(comp, res, path, l.getTargetProfile().get(0).getValue(), comp.getLeft().getName());
          StructureDefinition sdr = resolveProfile(comp, res, path, r.getTargetProfile().get(0).getValue(), comp.getRight().getName());
          if (sdl != null && sdr != null) {
            if (sdl == sdr) {
              tfound = true;
            } else if (derivesFrom(sdl, sdr)) {
              tfound = true;
            } else if (derivesFrom(sdr, sdl)) {
              c.setTargetProfile(r.getTargetProfile());
              tfound = true;
            } else if (sdl.getType().equals(sdr.getType())) {
              ProfileComparison compP = (ProfileComparison) session.compare(sdl, sdr);
              if (compP != null && compP.getIntersection() != null) {
                tfound = true;
                c.addTargetProfile("#"+compP.getId());
              }
            }
          }
        }
      }
      if (pfound && tfound)
        result.add(c);
    }
    return result;
  }

  private String typeCode(DefinitionNavigator defn) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (TypeRefComponent t : defn.current().getType())
      b.append(t.getWorkingCode()+(t.hasProfile() ? "("+t.getProfile()+")" : "")+(t.hasTargetProfile() ? "("+t.getTargetProfile()+")" : "")); // todo: other properties
    return b.toString();
  }


  private boolean compareBindings(ProfileComparison comp, StructuralMatch<ElementDefinition> res, ElementDefinition subset, ElementDefinition superset, String path, ElementDefinition lDef, ElementDefinition rDef) throws FHIRFormatError, DefinitionException, IOException {
    assert(lDef.hasBinding() || rDef.hasBinding());
    if (!lDef.hasBinding()) {
      subset.setBinding(rDef.getBinding());
      // technically, the super set is unbound, but that's not very useful - so we use the provided on as an example
      superset.setBinding(rDef.getBinding().copy());
      superset.getBinding().setStrength(BindingStrength.EXAMPLE);
      return true;
    }
    if (!rDef.hasBinding()) {
      subset.setBinding(lDef.getBinding());
      superset.setBinding(lDef.getBinding().copy());
      superset.getBinding().setStrength(BindingStrength.EXAMPLE);
      return true;
    }
    ElementDefinitionBindingComponent left = lDef.getBinding();
    ElementDefinitionBindingComponent right = rDef.getBinding();
    if (Base.compareDeep(left, right, false)) {
      subset.setBinding(left);
      superset.setBinding(right);      
    }

    // if they're both examples/preferred then:
    // subset: left wins if they're both the same
    // superset: 
    if (isPreferredOrExample(left) && isPreferredOrExample(right)) {
      if (right.getStrength() == BindingStrength.PREFERRED && left.getStrength() == BindingStrength.EXAMPLE && !Base.compareDeep(left.getValueSet(), right.getValueSet(), false)) {
        vm(IssueSeverity.INFORMATION, "Example/preferred bindings differ at "+path+" using binding from "+comp.getRight().getName(), path, comp.getMessages(), res.getMessages());
        subset.setBinding(right);
        superset.setBinding(unionBindings(comp, res, path, left, right));
      } else {
        if ((right.getStrength() != BindingStrength.EXAMPLE || left.getStrength() != BindingStrength.EXAMPLE) && !Base.compareDeep(left.getValueSet(), right.getValueSet(), false) ) { 
          vm(IssueSeverity.INFORMATION, "Example/preferred bindings differ at "+path+" using binding from "+comp.getLeft().getName(), path, comp.getMessages(), res.getMessages());
        }
        subset.setBinding(left);
        superset.setBinding(unionBindings(comp, res, path, left, right));
      }
      return true;
    }
    // if either of them are extensible/required, then it wins
    if (isPreferredOrExample(left)) {
      subset.setBinding(right);
      superset.setBinding(unionBindings(comp, res, path, left, right));
      return true;
    }
    if (isPreferredOrExample(right)) {
      subset.setBinding(left);
      superset.setBinding(unionBindings(comp, res, path, left, right));
      return true;
    }

    // ok, both are extensible or required.
    ElementDefinitionBindingComponent subBinding = new ElementDefinitionBindingComponent();
    subset.setBinding(subBinding);
    ElementDefinitionBindingComponent superBinding = new ElementDefinitionBindingComponent();
    superset.setBinding(superBinding);
    subBinding.setDescription(mergeText(comp, res, path, "description", left.getDescription(), right.getDescription()));
    superBinding.setDescription(mergeText(comp, res, path, "description", left.getDescription(), right.getDescription()));
    if (left.getStrength() == BindingStrength.REQUIRED || right.getStrength() == BindingStrength.REQUIRED)
      subBinding.setStrength(BindingStrength.REQUIRED);
    else
      subBinding.setStrength(BindingStrength.EXTENSIBLE);
    if (left.getStrength() == BindingStrength.EXTENSIBLE || right.getStrength() == BindingStrength.EXTENSIBLE)
      superBinding.setStrength(BindingStrength.EXTENSIBLE);
    else
      superBinding.setStrength(BindingStrength.REQUIRED);

    if (Base.compareDeep(left.getValueSet(), right.getValueSet(), false)) {
      subBinding.setValueSet(left.getValueSet());
      superBinding.setValueSet(left.getValueSet());
      return true;
    } else if (!left.hasValueSet()) {
      vm(IssueSeverity.ERROR, "No left Value set at "+path, path, comp.getMessages(), res.getMessages());
      return true;      
    } else if (!right.hasValueSet()) {
      vm(IssueSeverity.ERROR, "No right Value set at "+path, path, comp.getMessages(), res.getMessages());
      return true;      
    } else {
      // ok, now we compare the value sets. This may be unresolvable. 
      ValueSet lvs = resolveVS(comp.getLeft(), left.getValueSet());
      ValueSet rvs = resolveVS(comp.getRight(), right.getValueSet());
      if (lvs == null) {
        vm(IssueSeverity.ERROR, "Unable to resolve left value set "+left.getValueSet().toString()+" at "+path, path, comp.getMessages(), res.getMessages());
        return true;
      } else if (rvs == null) {
        vm(IssueSeverity.ERROR, "Unable to resolve right value set "+right.getValueSet().toString()+" at "+path, path, comp.getMessages(), res.getMessages());
        return true;        
      } else {
        ValueSetComparison compP = (ValueSetComparison) session.compare(lvs, rvs);
        if (compP != null) {
          subBinding.setValueSet(compP.getIntersection().getUrl());
          superBinding.setValueSet(compP.getUnion().getUrl());
        }
      }
    }
    return false;
  }

  private List<ElementDefinitionConstraintComponent> intersectConstraints(String path, List<ElementDefinitionConstraintComponent> left, List<ElementDefinitionConstraintComponent> right) {
    List<ElementDefinitionConstraintComponent> result = new ArrayList<ElementDefinitionConstraintComponent>();
    for (ElementDefinitionConstraintComponent l : left) {
      boolean found = false;
      for (ElementDefinitionConstraintComponent r : right)
        if (Utilities.equals(r.getId(), l.getId()) || (Utilities.equals(r.getXpath(), l.getXpath()) && r.getSeverity() == l.getSeverity()))
          found = true;
      if (found)
        result.add(l);
    }
    return result;
  }

  // we can't really know about constraints. We create warnings, and collate them 
  private List<ElementDefinitionConstraintComponent> unionConstraints(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, List<ElementDefinitionConstraintComponent> left, List<ElementDefinitionConstraintComponent> right) {
    List<ElementDefinitionConstraintComponent> result = new ArrayList<ElementDefinitionConstraintComponent>();
    for (ElementDefinitionConstraintComponent l : left) {
      boolean found = false;
      for (ElementDefinitionConstraintComponent r : right)
        if (Utilities.equals(r.getId(), l.getId()) || (Utilities.equals(r.getXpath(), l.getXpath()) && r.getSeverity() == l.getSeverity()))
          found = true;
      if (!found) {
        vm(IssueSeverity.INFORMATION,  "StructureDefinition "+comp.getLeft().getName()+" has a constraint that is removed in "+comp.getRight().getName()+" and it is uncertain whether they are compatible ("+l.getExpression()+")", path, comp.getMessages(), res.getMessages());
      }
      result.add(l);
    }
    for (ElementDefinitionConstraintComponent r : right) {
      boolean found = false;
      for (ElementDefinitionConstraintComponent l : left)
        if (Utilities.equals(r.getId(), l.getId()) || (Utilities.equals(r.getXpath(), l.getXpath()) && r.getSeverity() == l.getSeverity()))
          found = true;
      if (!found) {
        vm(IssueSeverity.INFORMATION,  "StructureDefinition "+comp.getRight().getName()+" has added constraint that is not found in "+comp.getLeft().getName()+" and it is uncertain whether they are compatible ("+r.getExpression()+")", path, comp.getMessages(), res.getMessages());
      }
    }
    return result;
  }

  private StructureDefinition resolveProfile(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, String url, String name) {
    StructureDefinition sd = session.getContext().fetchResource(StructureDefinition.class, url);
    if (sd == null) {
      ValidationMessage vm = vmI(IssueSeverity.WARNING, "Unable to resolve profile "+url+" in profile "+name, path);
    }
    return sd;
  }



  private boolean isPreferredOrExample(ElementDefinitionBindingComponent binding) {
    return binding.getStrength() == BindingStrength.EXAMPLE || binding.getStrength() == BindingStrength.PREFERRED;
  }

  private ElementDefinitionBindingComponent unionBindings(ProfileComparison comp, StructuralMatch<ElementDefinition> res, String path, ElementDefinitionBindingComponent left, ElementDefinitionBindingComponent right) throws FHIRFormatError, DefinitionException, IOException {
    ElementDefinitionBindingComponent union = new ElementDefinitionBindingComponent();
    if (left.getStrength().compareTo(right.getStrength()) < 0)
      union.setStrength(left.getStrength());
    else
      union.setStrength(right.getStrength());
    union.setDescription(mergeText(comp, res, path, "binding.description", left.getDescription(), right.getDescription()));
    if (Base.compareDeep(left.getValueSet(), right.getValueSet(), false))
      union.setValueSet(left.getValueSet());
    else {
      ValueSet lvs = resolveVS(comp.getLeft(), left.getValueSet());
      ValueSet rvs = resolveVS(comp.getRight(), right.getValueSet());
      if (lvs != null && rvs != null) {
        ValueSetComparison compP = (ValueSetComparison) session.compare(lvs, rvs);
        if (compP != null) {
          union.setValueSet(compP.getUnion().getUrl());
        }
      } else if (lvs != null) {
        union.setValueSet(lvs.getUrl());
      } else if (rvs != null) {
        union.setValueSet(rvs.getUrl());
      }
    }
    return union;
  }

  private ValueSet resolveVS(StructureDefinition ctxtLeft, String vsRef) {
    if (vsRef == null)
      return null;
    return session.getContext().fetchResource(ValueSet.class, vsRef);
  }

  
 
  

}