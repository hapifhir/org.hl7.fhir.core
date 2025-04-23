package org.hl7.fhir.r5.conformance.profile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.SourcedChildDefinitions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent;
import org.hl7.fhir.r5.utils.TypesUtilities;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;

/**
 * when a slice is encountered, it may have additional details defined after the slice that must be merged into 
 * each of the slices. That's kind of multiple inheritance, and fiendishly complicated to add to the snapshot generator
 * 
 * This class pre-processes the differential, finding the slices that have these trailing properties, and 
 * filling them out in the slices that follow
 * 
 * There's potential problems here, mostly around slicing extensions (other kind of slicing isn't allowed)
 * and also the merging logic might need to be sophisticated.
 * 
 */
public class SnapshotGenerationPreProcessor {


  public class ElementAnalysis {
    private StructureDefinition structure;
    private ElementDefinition element;
    private String type;
    public SourcedChildDefinitions children;
    protected ElementAnalysis(StructureDefinition structure, ElementDefinition element, String type) {
      super();
      this.structure = structure;
      this.element = element;
      this.type = type;
    }
    public StructureDefinition getStructure() {
      return structure;
    }
    public ElementDefinition getElement() {
      return element;
    }
    public SourcedChildDefinitions getChildren() {
      return children;
    }
    public void setChildren(SourcedChildDefinitions children) {
      this.children = children;
    }
    public String getType() {
      return type;
    }
    public String summary() {
      return element.getName()+":"+type;
    }
  }

  public class SliceInfo {
    SliceInfo parent;
    String path;
    boolean closed;
    ElementDefinition slicer;
    List<ElementDefinition> sliceStuff;
    List<ElementDefinition> slices;

    public SliceInfo(SliceInfo parent, ElementDefinition ed) {
      this.parent = parent;
      path = ed.getPath();
      slicer = ed;
      sliceStuff = new ArrayList<>();
      if (parent != null) {
        parent.add(ed);
      }
    }

    public void newSlice(ElementDefinition ed) {
      if (slices == null) {
        slices = new ArrayList<ElementDefinition>();
      }
      slices.add(ed);
      if (parent != null) {
        parent.add(ed);
      }
    }
    public void add(ElementDefinition ed) {
      if (slices == null) {
        sliceStuff.add(ed);
      }      
      if (parent != null) {
        parent.add(ed);
      }
    }
  }

  private IWorkerContext context;
  private ProfileUtilities utils;
  Set<String> typeNames;
  private List<SliceInfo> slicings = new ArrayList<>();

  public SnapshotGenerationPreProcessor(ProfileUtilities utils) {
    super();
    this.utils = utils;
    this.context = utils.getContext();
  }

  public void process(StructureDefinitionDifferentialComponent diff) {
    // first pass, divide it up 
    for (int cursor = 0; cursor < diff.getElement().size(); cursor++) {      
      ElementDefinition ed = diff.getElement().get(cursor);

      SliceInfo si = getSlicing(ed);
      if (si == null) {
        if (ed.hasSlicing() && !isExtensionSlicing(ed)) {
          si = new SliceInfo(null, ed);
          slicings.add(si);
        } else {
          // ignore this
        }
      } else {
        if (ed.hasSliceName() && ed.getPath().equals(si.path)) {
          si.newSlice(ed);
        } else if (ed.hasSlicing() && !isExtensionSlicing(ed)) {
          si = new SliceInfo(si, ed);
          slicings.add(si);
        } else {
          si.add(ed);
        }
      }
    }       

    for (SliceInfo si : slicings) {
      if (!si.sliceStuff.isEmpty() && si.slices != null) {
        for (ElementDefinition ed : si.sliceStuff) {
          if (ed.hasSlicing() && !isExtensionSlicing(ed)) {
            String message = context.formatMessage(I18nConstants.UNSUPPORTED_SLICING_COMPLEXITY, si.slicer.getPath(), ed.getPath(), ed.getSlicing().summary());
            System.out.println(message);
            return;
          }
        }
      }
    }

    // working backward
    for (int i = slicings.size() - 1; i >= 0; i--) {
      SliceInfo si = slicings.get(i);
      if (!si.sliceStuff.isEmpty() && si.slices != null) {
        // for each actual slice, we need to merge sliceStuff in
        for (ElementDefinition slice : si.slices) {
          mergeElements(diff.getElement(), si.sliceStuff, slice, si.slicer);
        }
      } else {
        // we just ignore these - nothing to do
      }
    }

  }

  private void mergeElements(List<ElementDefinition> elements, List<ElementDefinition> allSlices, ElementDefinition slice, ElementDefinition slicer) {
    // we have
    //   elements - the list of all the elements
    //   allSlices which is the content defined for all the slices
    //   slice -the anchor element for the slice

    int sliceIndex = elements.indexOf(slice);
    int startOfSlice = sliceIndex + 1;
    int endOfSlice = findEndOfSlice(elements, slice);

    Set<String> missing = new HashSet<>();
    // the simple case is that all the stuff in allSlices exists between startOfSlice and endOfSlice
    boolean allFound = true;
    for (int i = 0; i < allSlices.size(); i++) {
      boolean found = false;
      for (int j = startOfSlice; j <= endOfSlice; j++) {
        if (elements.get(j).getPath().equals(allSlices.get(i).getPath())) {
          found = true;
          break;
        }
      }
      if (!found) {
        missing.add(allSlices.get(i).getPath());
        allFound = false;
      }
    }

    if (allFound) {
      // then we just merge it in
      for (int j = startOfSlice; j <= endOfSlice; j++) {
        for (int i = 0; i < allSlices.size(); i++) {
          if (elements.get(j).getPath().equals(allSlices.get(i).getPath())) {
            merge(elements.get(j), allSlices.get(i));
          }
        }
      }
    } else {
      Set<ElementDefinition> handled = new HashSet<>();
      
      // merge the simple stuff
      for (int j = startOfSlice; j <= endOfSlice; j++) {
        for (int i = 0; i < allSlices.size(); i++) {
          if (elements.get(j).getPath().equals(allSlices.get(i).getPath())) {
            handled.add(allSlices.get(i));
            merge(elements.get(j), allSlices.get(i));
          }
        }
      }
      
      // we have a lot of work to do
      // the challenge is that the things missing from startOfSlice..endOfSlice have to injected in the correct order 
      // which means that we need to know the definitions
      // and is extra tricky because we're sparse. so we just use the stated path
      for (ElementDefinition ed : allSlices) {
        if (!handled.contains(ed)) {
          List<ElementAnalysis> edDef = analysePath(ed);
          String id = ed.getId().replace(slicer.getId(), slice.getId());
          int index = determineInsertionPoint(elements, startOfSlice, endOfSlice, id, ed.getPath(), edDef);
          ElementDefinition edc = ed.copy();
          edc.setUserData(UserDataNames.SNAPSHOT_PREPROCESS_INJECTED, true);
          edc.setId(id);
          elements.add(index, edc);
          endOfSlice++;
        }
      }
    }   
    
  }

  private int determineInsertionPoint(List<ElementDefinition> elements, int startOfSlice, int endOfSlice, String id, String path, List<ElementAnalysis> edDef) {
    // we work backwards through the id, looking for peers (this is the only way we can manage slicing)
    String[] p = id.split("\\.");
    for (int i = p.length-1; i >= 1; i--) {
      String subId = p[0];
      for (int j = 1; j <= i; j++) {
        subId += "."+p[j];
      }
      List<ElementDefinition> peers = findPeers(elements, startOfSlice, endOfSlice, subId);
      if (!peers.isEmpty()) {
        // Once we find some, we figure out the insertion point - before one of them, or after the last? 
        for (ElementDefinition ed : peers) {
          if (comesAfterThis(id, path, edDef, ed)) {
            return elements.indexOf(ed);
          }
        }
        return elements.indexOf(peers.get(peers.size() -1))+1;
      }
    }
    return endOfSlice+1;
  }

  private List<ElementDefinition> findPeers(List<ElementDefinition> elements, int startOfSlice, int endOfSlice, String subId) {
    List<ElementDefinition> peers =  new ArrayList<>();
    for (int i = startOfSlice; i <= endOfSlice; i++) {
      ElementDefinition ed = elements.get(i);
      if (ed.getId().startsWith(subId)) {
        peers.add(ed);
      }
    }
    return peers;
  }

  private String summary(List<ElementAnalysis> edDef) {
    List<String> s = new ArrayList<>();
    for (ElementAnalysis ed : edDef) {
      s.add(ed.summary());
    }
    
    return CommaSeparatedStringBuilder.join(",", s);
  }

  private boolean comesAfterThis(String id, String path, List<ElementAnalysis> edDef, ElementDefinition ed) {
    String[] p1 = id.split("\\.");
    String[] p2 = ed.getId().split("\\.");
    for (int i = 0; i < Integer.min(p1.length,  p2.length); i++) {
      if (!p1[i].equals(p2[i])) {
        ElementAnalysis sed = edDef.get(i-1);
        int i1 = indexOfName(sed, p1[i]);
        int i2 = indexOfName(sed, p2[i]);
        return i1 < i2;
      } else {
        // well, we just go on
      }
    }
    return p1.length < p2.length;
  }

  private int indexOfName(ElementAnalysis sed, String name) {
    if (name.contains(":")) {
      name = name.substring(0, name.indexOf(":"));
    }
    for (int i = 0; i < sed.getChildren().getList().size(); i++) {
      if (name.equals(sed.getChildren().getList().get(i).getName())) {
        return i;
      }      
    }
    return -1;
  }

  private List<ElementAnalysis> analysePath(ElementDefinition ed) {
    List<ElementAnalysis> res = new ArrayList<>();
    for (String pn : ed.getPath().split("\\.")) {
      if (res.isEmpty()) {
        StructureDefinition sd = context.fetchTypeDefinition(pn);
        if (sd == null) {
          String message = context.formatMessage(I18nConstants.UNKNOWN_TYPE__AT_, pn, ed.getId());
          throw new DefinitionException(message);
        }
        res.add(new ElementAnalysis(sd, sd.getSnapshot().getElementFirstRep(), null));
      } else {
        ElementAnalysis sed = res.get(res.size()-1);
        sed.setChildren(utils.getChildMap(sed.getStructure(), sed.getElement(), true, sed.getType()));
        ElementDefinition t = null;
        String type = null;
        for (ElementDefinition child : sed.getChildren().getList()) {
          if (pn.equals(child.getName())) {
            t = child;
            break;
          }
          if (child.getName().endsWith("[x]")) {
            String rn = child.getName().substring(0, child.getName().length()-3);
            if (pn.startsWith(rn)) {
              t = child;
              String tn = pn.substring(rn.length());
              if (TypesUtilities.isPrimitive(Utilities.uncapitalize(tn))) {
                type = Utilities.uncapitalize(tn);
              } else {
                type = tn;
              }
              break;
            }
          }
        }
        if (t == null) {
          String message = context.formatMessage(I18nConstants.UNKNOWN_PROPERTY, pn, ed.getPath());
          throw new DefinitionException("Unknown path "+pn+" in path "+ed.getPath()+": "+message);          
        } else {
          res.add(new ElementAnalysis(sed.getChildren().getSource(), t, type));
        }
      }
    }
    return res;
  }

  private int findEndOfSlice(List<ElementDefinition> elements, ElementDefinition slice) {
    for (int i = elements.indexOf(slice); i < elements.size(); i++) {
      ElementDefinition e = elements.get(i);
      if (e.getPath().length() < slice.getPath().length() || (e.getPath().equals(slice.getPath()) && !slice.getSliceName().equals(e.getSliceName()))) {
        return i-1;
      }
    }
    return elements.size() - 1;
  }

  private void merge(ElementDefinition focus, ElementDefinition base) {
    if (base.hasLabel() && !focus.hasLabel()) {
      focus.setLabelElement(base.getLabelElement());
    }    
    if (base.hasCode() && !focus.hasCode()) {
      focus.getCode().addAll(base.getCode());
    }
    if (base.hasShort() && !focus.hasShort()) {
      focus.setShortElement(base.getShortElement());
    }    
    if (base.hasDefinition() && !focus.hasDefinition()) {
      focus.setDefinitionElement(base.getDefinitionElement());
    }    
    if (base.hasComment() && !focus.hasComment()) {
      focus.setCommentElement(base.getCommentElement());
    }    
    if (base.hasRequirements() && !focus.hasRequirements()) {
      focus.setRequirementsElement(base.getRequirementsElement());
    }    
    if (base.hasAlias() && !focus.hasAlias()) {
      focus.getAlias().addAll(base.getAlias());
    }
    if (base.hasMin() && !focus.hasMin()) {
      focus.setMinElement(base.getMinElement());
    }    
    if (base.hasMax() && !focus.hasMax()) {
      focus.setMaxElement(base.getMaxElement());
    }    
    if (base.hasType() && !focus.hasType()) {
      focus.getType().addAll(base.getType());
    }
    if (base.hasDefaultValue() && !focus.hasDefaultValue()) {
      focus.setDefaultValue(base.getDefaultValue());
    }
    if (base.hasMeaningWhenMissing() && !focus.hasMeaningWhenMissing()) {
      focus.setMeaningWhenMissingElement(base.getMeaningWhenMissingElement());
    }    
    if (base.hasOrderMeaning() && !focus.hasOrderMeaning()) {
      focus.setOrderMeaningElement(base.getOrderMeaningElement());
    }    
    if (base.hasFixed() && !focus.hasFixed()) {
      focus.setFixed(base.getFixed());
    }
    if (base.hasPattern() && !focus.hasPattern()) {
      focus.setPattern(base.getPattern());
    }
    if (base.hasExample() && !focus.hasExample()) {
      focus.getExample().addAll(base.getExample());
    }
    if (base.hasMinValue() && !focus.hasMinValue()) {
      focus.setMinValue(base.getMinValue());
    }
    if (base.hasMaxValue() && !focus.hasMaxValue()) {
      focus.setMaxValue(base.getMaxValue());
    }
    if (base.hasMaxLength() && !focus.hasMaxLength()) {
      focus.setMaxLengthElement(base.getMaxLengthElement());
    }    
    if (base.hasConstraint() && !focus.hasConstraint()) {
      focus.getConstraint().addAll(base.getConstraint());
    }
    if (base.hasMustHaveValue() && !focus.hasMustHaveValue()) {
      focus.setMustHaveValueElement(base.getMustHaveValueElement());
    }    
    if (base.hasValueAlternatives() && !focus.hasValueAlternatives()) {
      focus.getValueAlternatives().addAll(base.getValueAlternatives());
    }
    if (base.hasMustSupport() && !focus.hasMustSupport()) {
      focus.setMustSupportElement(base.getMustSupportElement());
    }    
    if (base.hasIsModifier() && !focus.hasIsModifier()) {
      focus.setIsModifierElement(base.getIsModifierElement());
    }    
    if (base.hasIsModifierReason() && !focus.hasIsModifierReason()) {
      focus.setIsModifierReasonElement(base.getIsModifierReasonElement());
    }    
    if (base.hasIsSummary() && !focus.hasIsSummary()) {
      focus.setIsSummaryElement(base.getIsSummaryElement());
    }    
    if (base.hasBinding() && !focus.hasBinding()) {
      focus.setBinding(base.getBinding());
    }
  }

  private boolean isExtensionSlicing(ElementDefinition ed) {
    if (!Utilities.existsInList(ed.getName(), "extension", "modiferExtension")) {
      return false;
    }
    if (ed.getSlicing().getRules() != SlicingRules.OPEN || (!ed.getSlicing().hasOrdered() || ed.getSlicing().getOrdered()) || ed.getSlicing().getDiscriminator().size() != 1) {
      return false;
    }
    ElementDefinitionSlicingDiscriminatorComponent d = ed.getSlicing().getDiscriminatorFirstRep();
    return d.getType() == DiscriminatorType.VALUE && "url".equals(d.getPath());
  }

  private SliceInfo getSlicing(ElementDefinition ed) {
    for (int i = slicings.size() - 1; i >= 0; i--) {
      SliceInfo si = slicings.get(i);
      if (!si.closed) {
        if (si.path.length() > ed.getPath().length()) {
          si.closed = true;
        } else if (ed.getPath().startsWith(si.path)) {
          return si;
        }
      }
    }
    return null;
  }

  public List<ElementDefinition> supplementMissingDiffElements(StructureDefinition profile) { 
    List<ElementDefinition> list = new ArrayList<>(); 
    list.addAll(profile.getDifferential().getElement()); 
    if (list.isEmpty()) { 
      ElementDefinition root = new ElementDefinition().setPath(profile.getTypeName()); 
      root.setId(profile.getTypeName()); 
      list.add(root); 
    } else { 
      if (list.get(0).getPath().contains(".")) { 
        ElementDefinition root = new ElementDefinition().setPath(profile.getTypeName()); 
        root.setId(profile.getTypeName()); 
        list.add(0, root); 
      } 
    } 
    insertMissingSparseElements(list); 
    return list; 
  } 

  private void insertMissingSparseElements(List<ElementDefinition> list) { 
    int i = 1; 
    while (i < list.size()) { 
      String[] pathCurrent = list.get(i).getPath().split("\\."); 
      String[] pathLast = list.get(i-1).getPath().split("\\."); 
      int firstDiff = 0; // the first entry must be a match 
      while (firstDiff < pathCurrent.length && firstDiff < pathLast.length && pathCurrent[firstDiff].equals(pathLast[firstDiff])) { 
        firstDiff++; 
      } 
      if (!(isSibling(pathCurrent, pathLast, firstDiff) || isChild(pathCurrent, pathLast, firstDiff))) { 
        // now work backwards down to lastMatch inserting missing path nodes 
        ElementDefinition parent = findParent(list, i, list.get(i).getPath()); 
        int parentDepth = Utilities.charCount(parent.getPath(), '.')+1; 
        int childDepth =  Utilities.charCount(list.get(i).getPath(), '.')+1; 
        if (childDepth > parentDepth + 1) { 
          String basePath = parent.getPath(); 
          String baseId = parent.getId(); 
          for (int index = parentDepth; index >= firstDiff; index--) { 
            String mtail = makeTail(pathCurrent, parentDepth, index); 
            ElementDefinition root = new ElementDefinition().setPath(basePath+"."+mtail); 
            root.setId(baseId+"."+mtail); 
            list.add(i, root); 
          } 
        } 
      }  
      i++; 
    } 
  } 
 

  private ElementDefinition findParent(List<ElementDefinition> list, int i, String path) { 
    while (i > 0 && !path.startsWith(list.get(i).getPath()+".")) { 
      i--; 
    } 
    return list.get(i); 
  } 
 
  private boolean isSibling(String[] pathCurrent, String[] pathLast, int firstDiff) { 
    return pathCurrent.length == pathLast.length && firstDiff == pathCurrent.length-1; 
  } 
 
 
  private boolean isChild(String[] pathCurrent, String[] pathLast, int firstDiff) { 
    return pathCurrent.length == pathLast.length+1 && firstDiff == pathLast.length; 
  } 
 
  private String makeTail(String[] pathCurrent, int start, int index) { 
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("."); 
    for (int i = start; i <= index; i++) { 
      b.append(pathCurrent[i]); 
    } 
    return b.toString(); 
  }

  public StructureDefinition trimSnapshot(StructureDefinition profile) {
    // first pass: mark elements from the diff
    Stack<ElementDefinition> stack = new Stack<ElementDefinition>();
    ElementDefinition edRoot = profile.getSnapshot().getElementFirstRep();
    if (!edRoot.hasUserData(UserDataNames.SNAPSHOT_FROM_DIFF)) {
      stack.push(edRoot);
      for (int i = 1; i < profile.getSnapshot().getElement().size(); i++) {
        ElementDefinition ed = profile.getSnapshot().getElement().get(i);
        String cpath = ed.getPath();
        boolean fromDiff = ed.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_DIFF);

        String spath = stack.peek().getPath();
        while (!(cpath.equals(spath) || cpath.startsWith(spath+"."))) {
          stack.pop();
          spath = stack.peek().getPath();
        }
        stack.push(ed);
        if (fromDiff) {
          for (int j = stack.size() - 1; j >= 0; j--) {
            if (stack.get(j).hasUserData(UserDataNames.SNAPSHOT_FROM_DIFF)) {
              break;
            } else {
              stack.get(j).setUserData(UserDataNames.SNAPSHOT_FROM_DIFF, true);
            }
          }
        }
      }
    }
    edRoot.setUserData(UserDataNames.SNAPSHOT_FROM_DIFF, true);
    
    StructureDefinition res = new StructureDefinition();
    res.setUrl(profile.getUrl());
    res.setVersion(profile.getVersion());
    res.setName(profile.getName());
    res.setBaseDefinition(profile.getBaseDefinition());
    for (ElementDefinition ed : profile.getSnapshot().getElement()) {
      if (ed.hasUserData(UserDataNames.SNAPSHOT_FROM_DIFF)) {
        res.getSnapshot().getElement().add(ed);
      }
    }
    return res;
  } 
 
}
