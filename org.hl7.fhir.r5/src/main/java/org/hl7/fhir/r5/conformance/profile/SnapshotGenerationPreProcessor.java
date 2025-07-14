package org.hl7.fhir.r5.conformance.profile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.SourcedChildDefinitions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent;
import org.hl7.fhir.r5.utils.DefinitionNavigator;
import org.hl7.fhir.r5.utils.ToolingExtensions;
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
@Slf4j
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

  public void process(StructureDefinitionDifferentialComponent diff, StructureDefinition srcOriginal) {
    StructureDefinition srcWrapper = shallowClone(srcOriginal, diff); 
    processSlices(diff, srcWrapper);  
    if (srcWrapper.hasExtension(ToolingExtensions.EXT_ADDITIONAL_BASE)) {
       insertMissingSparseElements(diff.getElement(), srcWrapper.getTypeName());
       for (Extension ext : srcWrapper.getExtensionsByUrl(ToolingExtensions.EXT_ADDITIONAL_BASE)) {
         StructureDefinition ab = context.fetchResource(StructureDefinition.class, ext.getValue().primitiveValue());
         if (ab == null) {
           throw new FHIRException("Unable to find additional base '"+ext.getValue().primitiveValue()+"'");
         }
         if (!srcWrapper.getType().equals(ab.getType())) {
           throw new FHIRException("Type mismatch");
         }
         SnapshotGenerationPreProcessor abpp = new SnapshotGenerationPreProcessor(utils);
         abpp.process(ab.getDifferential(), ab);
         abpp.insertMissingSparseElements(ab.getDifferential().getElement(), srcWrapper.getTypeName());
         mergeElementsFromAdditionalBase(srcWrapper, ab);         
       }
    }
  }
  
  private StructureDefinition shallowClone(StructureDefinition src, StructureDefinitionDifferentialComponent diff) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl(src.getUrl());
    sd.setVersion(src.getVersion());
    sd.setType(src.getType());
    sd.setDerivation(src.getDerivation());
    sd.setBaseDefinition(src.getBaseDefinition());
    sd.setExtension(src.getExtension());
    sd.setDifferential(diff);
    return sd;
  }

  private void mergeElementsFromAdditionalBase(StructureDefinition sourceSD, StructureDefinition baseSD) {
    List<ElementDefinition> output = new ArrayList<ElementDefinition>();
    output.add(mergeElementDefinitions(baseSD.getDifferential().getElementFirstRep(), sourceSD.getDifferential().getElementFirstRep(), baseSD));
    DefinitionNavigator base = new DefinitionNavigator(context, baseSD, true, false);
    DefinitionNavigator source = new DefinitionNavigator(context, sourceSD, true, false);
    StructureDefinition sdt = context.fetchTypeDefinition(sourceSD.getType());
    SourcedChildDefinitions children = utils.getChildMap(sdt, sdt.getSnapshot().getElementFirstRep(), false);
    mergeElements(output, base, source, children, baseSD);
    sourceSD.getDifferential().setElement(output);    
  }

  private void mergeElements(List<ElementDefinition> output, DefinitionNavigator base, DefinitionNavigator source, SourcedChildDefinitions children, StructureDefinition baseSD) {
    for (ElementDefinition child : children.getList()) {
      DefinitionNavigator baseChild = base == null ? null : base.childByName(child.getName());
      DefinitionNavigator sourceChild = source == null ? null : source.childByName(child.getName());
      if (baseChild != null && sourceChild != null) {
        if (!baseChild.hasSlices() && !sourceChild.hasSlices()) {
          output.add(mergeElementDefinitions(baseChild.current(), sourceChild.current(), baseSD));
          if (sourceChild.hasChildren() || baseChild.hasChildren()) {
            mergeElements(output, baseChild, sourceChild, getChildren(children, child, sourceChild, baseChild, baseSD), baseSD);
          }
        } else if (baseChild.hasSlices() && sourceChild.hasSlices()) {
          if (!slicingIsConsistent(baseChild.getSlicing(), sourceChild.getSlicing())) {
            throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, baseSD.getVersionedUrl(), child.getPath()+".slicing", 
                describeDiscriminators(baseChild.getSlicing()), describeDiscriminators(sourceChild.getSlicing())));                
          }
          output.add(mergeElementDefinitions(baseChild.current(), sourceChild.current(), baseSD));
          mergeElements(output, baseChild, sourceChild, getChildren(children, child, sourceChild, baseChild, baseSD), baseSD);
          List<DefinitionNavigator> handled = new ArrayList<>();
          for (DefinitionNavigator slice : sourceChild.slices()) {
            DefinitionNavigator match = getMatchingSlice(baseChild, slice, sourceChild.getSlicing());
            if (match != null) {
              handled.add(match);
              output.add(mergeElementDefinitions(match.current(), slice.current(), baseSD));
              mergeElements(output, match, slice, getChildren(children, child, match, slice, baseSD), baseSD);
            } else {
              // this slice isn't in the base 
              output.add(slice.current().copy());
              mergeElements(output, null, slice, getChildren(children, child, slice, null, baseSD), baseSD);
            }            
          }
          for (DefinitionNavigator slice : baseChild.slices()) {
            if (!handled.contains(slice)) {
              output.add(slice.current().copy());
              mergeElements(output, slice, null, getChildren(children, child, null, slice, baseSD), baseSD);
            }
          }          
        } else  if (baseChild.hasSlices()) {
          throw new FHIRException("Not done yet");
        } else { // sourceChild.hasSlices()         
          throw new FHIRException("Not done yet");
        }
      } else if (baseChild != null) {
        output.add(baseChild.current().copy());
        if (baseChild.hasChildren()) {
          mergeElements(output, baseChild, sourceChild, getChildren(children, child, null, baseChild, baseSD), baseSD);
        }
        if (baseChild.hasSlices()) {
          for (DefinitionNavigator slice : baseChild.slices()) {
            mergeElements(output, slice, null, getChildren(children, child, null, slice, baseSD), baseSD);            
          }
        }
      } else if (sourceChild != null) {
        output.add(sourceChild.current().copy());
        if (sourceChild.hasSlices()) {
          for (DefinitionNavigator slice : sourceChild.slices()) {
            mergeElements(output, null, slice, getChildren(children, child, slice, null, baseSD), baseSD);            
          }
        }
        if (sourceChild.hasChildren()) {
          mergeElements(output, baseChild, sourceChild, getChildren(children, child, sourceChild, null, baseSD), baseSD);
        }
        // slices
      } else {
        // do nothing - no match on either side
      }
    }
  }

  private DefinitionNavigator getMatchingSlice(DefinitionNavigator base, DefinitionNavigator slice, ElementDefinitionSlicingComponent slicing) {
    List<DataType> values = new ArrayList<>();
    for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) {
      values.add(getDiscriminatorValue(slice, d));
    }
    DefinitionNavigator match = null;
    for (DefinitionNavigator t : base.slices()) {
      List<DataType> values2 = new ArrayList<>();
      for (ElementDefinitionSlicingDiscriminatorComponent d : slicing.getDiscriminator()) {
        values2.add(getDiscriminatorValue(t, d));
      }
      if (valuesMatch(values, values2)) {
        if (match == null) {
          match = t;
        } else {
          throw new Error("Duplicate slice");
        }
      }      
    }    
    return match;
  }

  private DataType getDiscriminatorValue(DefinitionNavigator slice, ElementDefinitionSlicingDiscriminatorComponent d) {
    // we're not following types, because we want to stop where the differential stops. but right here and now,
    // we have to follow the types. So we're going to clone the navigator 
    DefinitionNavigator dn = new DefinitionNavigator(slice, true);
    switch (d.getType() ) {
    case EXISTS:
      throw new Error("Not supported yet");
    case NULL:
      throw new Error("Not supported yet");
    case PATTERN:
      throw new Error("Not supported yet");
    case POSITION:
      throw new Error("Not supported yet");
    case PROFILE:
      throw new Error("Not supported yet");
    case TYPE:
      if ("$this".equals(d.getPath())) {
        return new CodeType(dn.getManualType() != null ? dn.getManualType().getCode() : dn.current().typeSummary());
      } else {
        throw new Error("Not supported yet");
      }
    case VALUE:
      DefinitionNavigator child = dn.childByName(d.getPath());
      if (child != null) {
        ElementDefinition ed = child.current();
        if (ed.hasFixed()) {
          return ed.getFixed();
        } else if (ed.hasPattern()) {
          return ed.getPattern();
        }
      } else {
        return null;
      }
    default:
      throw new Error("Not supported yet");    
    }
  }

  private boolean valuesMatch(List<DataType> values1, List<DataType> values2) {
    for (int i = 0; i < values1.size(); i++) {
      DataType v1 = values1.get(i);
      DataType v2 = values2.get(i);
      if (!valuesMatch(v1, v2)) {
        return false;
      }
    }
    return true;
  }

  private boolean valuesMatch(DataType v1, DataType v2) {
    if (v1 == null && v2 == null) {
      return true;
    } else if (v1 != null && v2 != null) {
      return v1.equalsDeep(v2);
    } else {
      return false;
    }
  }

  private boolean slicingIsConsistent(ElementDefinitionSlicingComponent src, ElementDefinitionSlicingComponent base) {
    if (src.getRules() != base.getRules()) {
      return false;
    }
    if (src.getDiscriminator().size() != base.getDiscriminator().size()) {
      return false;
    }
    for (ElementDefinitionSlicingDiscriminatorComponent d1 : src.getDiscriminator()) {
      boolean found = false;
      for (ElementDefinitionSlicingDiscriminatorComponent d2 : base.getDiscriminator()) {
        found = found || (d1.getType() == d2.getType() && d1.getPath().equals(d2.getPath()));
      }
      if (!found) {
        return false;
      }
    }
    return true;
  }

  private Object describeDiscriminators(ElementDefinitionSlicingComponent slicing) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();    
    for (ElementDefinitionSlicingDiscriminatorComponent t : slicing.getDiscriminator()) {
      b.append(t.getType().toCode()+":"+t.getPath());
    }
    return (slicing.hasRules() ? slicing.getRules().toCode()+":" : "")+b.toString()+(slicing.hasOrdered() ? " (ordered)" : "");
  }

  private SourcedChildDefinitions getChildren(SourcedChildDefinitions children, ElementDefinition child, DefinitionNavigator source, DefinitionNavigator base, StructureDefinition baseSD) {
    if (child.getType().size() > 1) {
      String type = null;
      if (source != null && base != null) {
        String typeSource = statedOrImpliedType(source);
        String typeBase = statedOrImpliedType(base);
        if (typeSource != null && typeBase != null) {
          if (typeSource.equals(typeBase)) {
            type = typeSource;
          } else {
            throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, baseSD.getVersionedUrl(), child.getPath()+".type", typeSource, typeBase));
          }
        } else if (typeSource != null) {
          type = typeSource;
        } else if (typeBase != null) {
          type = typeBase;          
        }
      } else if (source != null) {
        type = statedOrImpliedType(source);       
      } else if (base != null) {
        type = statedOrImpliedType(base);        
      } else {
        // type = "DataType";
      }
      if (type == null) {          
        throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INDETERMINATE_TYPE, baseSD.getVersionedUrl(), child.getPath()+".type"));
        
      } else {
        return utils.getChildMap(children.getSource(), child, true, type);
      }
    } else {
      return utils.getChildMap(children.getSource(), child, true);
    }
  }

  private String statedOrImpliedType(DefinitionNavigator source) {
    if (source.getManualType() != null) {
      return source.getManualType().getCode();
    } else if (source.current().getType().size() == 1) {
      return source.current().getTypeFirstRep().getCode();
    } else {
      return null;
    }
  }

  private ElementDefinition mergeElementDefinitions(ElementDefinition base, ElementDefinition source, StructureDefinition baseSD) {
    ElementDefinition merged = new ElementDefinition();
    merged.setPath(source.getPath());
    if (source.hasSlicing()) {
      merged.setSlicing(source.getSlicing());
    }
    
    merged.setLabelElement(chooseProp(source.getLabelElement(),  base.getLabelElement()));
    merged.setShortElement(chooseProp(source.getShortElement(), base.getShortElement()));
    merged.setDefinitionElement(chooseProp(source.getDefinitionElement(), base.getDefinitionElement()));
    merged.setCommentElement(chooseProp(source.getCommentElement(), base.getCommentElement()));
    merged.setRequirementsElement(chooseProp(source.getRequirementsElement(), base.getRequirementsElement()));
    merged.setMeaningWhenMissingElement(chooseProp(source.getMeaningWhenMissingElement(), base.getMeaningWhenMissingElement()));
    merged.setOrderMeaningElement(chooseProp(source.getOrderMeaningElement(), base.getOrderMeaningElement()));
    merged.setMaxLengthElement(chooseProp(source.getMaxLengthElement(), base.getMaxLengthElement()));
    merged.setMustHaveValueElement(chooseProp( source.getMustHaveValueElement(), base.getMustHaveValueElement()));
    merged.setMustSupportElement(chooseProp(source.getMustSupportElement(), base.getMustSupportElement()));
    merged.setIsModifierElement(chooseProp(source.getIsModifierElement(), base.getIsModifierElement()));
    merged.setIsModifierReasonElement(chooseProp(source.getIsModifierReasonElement(), base.getIsModifierReasonElement()));
    merged.setIsSummaryElement(chooseProp(source.getIsSummaryElement(), base.getIsSummaryElement()));

    if (source.hasMin() && base.hasMin()) {
      merged.setMinElement(source.getMin() < base.getMin() ? source.getMinElement().copy() : base.getMinElement().copy());      
    } else {
      merged.setMinElement(chooseProp(source.getMinElement(), base.getMinElement().copy()));
    }
    if (source.hasMax() && base.hasMax()) {
      merged.setMaxElement(source.getMaxAsInt() < base.getMaxAsInt() ? source.getMaxElement().copy() : base.getMaxElement().copy());      
    } else {
      merged.setMaxElement(chooseProp(source.getMaxElement(), base.getMaxElement()));
    }
    
    if (source.hasFixed() || base.hasFixed()) {
      if (source.hasFixed()) {
        if (base.hasFixed()) {
          if (!source.getFixed().equalsDeep(base.getFixed())) {            
            throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, baseSD.getVersionedUrl(), source.getPath()+".fixed", source.getFixed().toString(), base.getFixed().toString()));
          } else {
            merged.setFixed(source.getFixed().copy());          
          }
        } else if (base.hasPattern()) {
          merged.setFixed(checkPatternValues(baseSD.getVersionedUrl(), source.getPath()+".fixed", source.getFixed(), base.getPattern(), false)); 
        } else {
          merged.setFixed(source.getFixed().copy());          
        }
      } else if (source.hasPattern()) { // base.hasFixed() == true
        merged.setFixed(checkPatternValues(baseSD.getVersionedUrl(), source.getPath()+".pattern", base.getFixed(), source.getPattern(), false)); 
      } else {
        merged.setFixed(base.getFixed().copy());          
      }
    } else if (source.hasPattern() && base.hasPattern()) {
      merged.setPattern(checkPatternValues(baseSD.getVersionedUrl(), source.getPath()+".pattern", source.getFixed(), base.getFixed(), true));
    } else {
      merged.setPattern(chooseProp(source.getPattern(), base.getPattern()));
    }
    
    if (source.hasMinValue() && base.hasMinValue()) {
      merged.setMinValue(isLower(baseSD.getVersionedUrl(), source.getPath(), "minValue", source.getMinValue(), base.getMinValue()) ? base.getMinValue().copy() : source.getMinValue().copy());      
    } else {
      merged.setMinValue(chooseProp(source.getMinValue(), base.getMinValue()));
    }
    if (source.hasMaxValue() && base.hasMaxValue()) {
      merged.setMaxValue(isLower(baseSD.getVersionedUrl(), source.getPath(), "maxValue", source.getMaxValue(), base.getMaxValue()) ? source.getMaxValue().copy() : base.getMaxValue().copy());            
    } else {
      merged.setMaxValue(chooseProp(source.getMaxValue(), base.getMaxValue()));
    }
    if (source.hasMaxLength() && base.hasMaxLength()) {
      merged.setMaxLengthElement(base.getMaxLength() < source.getMaxLength() ? source.getMaxLengthElement().copy() : base.getMaxLengthElement().copy());            
    } else {
      merged.setMaxLengthElement(chooseProp(source.getMaxLengthElement(), base.getMaxLengthElement().copy()));
    }
    // union
    union(merged.getAlias(), source.getAlias(), base.getAlias());
    union(merged.getCode(), source.getCode(), base.getCode());
    union(merged.getExample(), source.getExample(), base.getExample());
    union(merged.getConstraint(), source.getConstraint(), base.getConstraint());
    union(merged.getMapping(), source.getMapping(), base.getMapping());

    // intersection
    if (source.hasValueAlternatives() && base.hasValueAlternatives()) {
      for (CanonicalType st : source.getValueAlternatives()) {
        boolean exists = false;
        for (CanonicalType st2 : base.getValueAlternatives()) {
          exists = exists || st.equals(st2);
        }
        if (exists) {
          merged.getValueAlternatives().add(st.copy());
        }
      }
    } else if (source.hasValueAlternatives()) {
      for (CanonicalType st : source.getValueAlternatives()) {
        merged.getValueAlternatives().add(st.copy());
      }
    } else if (base.hasValueAlternatives()) {
      for (CanonicalType st : base.getValueAlternatives()) {
        merged.getValueAlternatives().add(st.copy());
      }
    }

    if (source.hasType() && base.hasType()) {
      for (TypeRefComponent t1 : source.getType()) {
        for (TypeRefComponent t2 : base.getType()) {
          if (Utilities.stringsEqual(t1.getWorkingCode(), t2.getWorkingCode())) {
            merged.getType().add(mergeTypes(baseSD.getVersionedUrl(), source.getPath(), t1, t2));
          }
        }
      }
      if (merged.getType().isEmpty()) {
        throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, baseSD.getVersionedUrl(), source.getPath()+".type", source.typeSummary(), base.typeSummary()));
        
      }
    } else if (source.hasType()) {
      for (TypeRefComponent st : source.getType()) {
        merged.getType().add(st.copy());
      }
    } else if (base.hasType()) {
      for (TypeRefComponent st : base.getType()) {
        merged.getType().add(st.copy());
      }
    }

    // binding
    if (source.hasBinding() && base.hasBinding()) {
      throw new Error("not done yet");
    } else if (source.hasBinding()) {
      merged.setBinding(source.getBinding().copy());
    } else if (base.hasBinding()) {
      merged.setBinding(base.getBinding().copy());
    }
    
    
    return merged;
  }

  private <T extends DataType> T chooseProp(T source, T base) {
    if (source != null && !source.isEmpty()) {
      return (T) source.copy();
    }
    if (base != null && !base.isEmpty()) {
      return (T) base.copy();
    }
    return null;
  }

  private TypeRefComponent mergeTypes(String vurl, String path, TypeRefComponent t1, TypeRefComponent t2) {
    TypeRefComponent tr = t1.copy();
    if (t1.hasProfile() && t2.hasProfile()) {
      // here, this is tricky, because we need to know what the merged additional bases of the pairings will be
      if (t1.getProfile().size() > 1 || t2.getProfile().size() > 1) {
        throw new FHIRException("Not handled yet: multiple profiles");        
      }
      StructureDefinition sd1 = context.fetchResource(StructureDefinition.class, t1.getProfile().get(0).asStringValue());
      if (sd1 == null) {
        throw new FHIRException("Unknown type profile at '"+path+"': "+t1.getProfile().get(0).asStringValue());                
      }
      StructureDefinition sd2 = context.fetchResource(StructureDefinition.class, t2.getProfile().get(0).asStringValue());
      if (sd2 == null) {
        throw new FHIRException("Unknown type profile at '"+path+"': "+t2.getProfile().get(0).asStringValue());                
      }
      tr.getProfile().clear();
      if (specialises(sd1, sd2)) { 
        // both sd1 and sd2 apply, but sd1 applies everything in sd2, so it's just sd1
        tr.getProfile().add(t1.getProfile().get(0).copy());
      } else if (specialises(sd2, sd1)) { 
        // both sd1 and sd2 apply, but sd2 applies everything in sd1, so it's just sd2
        tr.getProfile().add(t2.getProfile().get(0).copy());
      } else {
        // oh dear. We have to find a type that is both of them 
        StructureDefinition sd3 = findJointProfile(sd1, sd2);
        if (sd3 == null) {
          throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_NO_TYPE, vurl, path, sd1.getVersionedUrl(), sd2.getVersionedUrl()));
        } else {
          tr.getProfile().add(new CanonicalType(sd3.getUrl()));          
        }
      }
    } else if (t2.hasProfile()) {
      for (CanonicalType ct : t2.getProfile()) {
        tr.getProfile().add(ct.copy());
      }
    }
    if (t1.hasTargetProfile() && t2.hasTargetProfile()) {
      // here, this is tricky, because we need to know what the merged additional bases of the pairings will be
    } else if (t2.hasTargetProfile()) {
      for (CanonicalType ct : t2.getTargetProfile()) {
        tr.getTargetProfile().add(ct.copy());
      }
    }
    if (t1.hasAggregation() && t2.hasAggregation() && !t1.getAggregation().equals(t2.getAggregation())) {
      throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+".type["+tr.getWorkingCode()+"].aggregation", t1.getAggregation(), t2.getAggregation()));
    }
    if (t1.hasVersioning() && t2.hasVersioning() && t1.getVersioning() != t2.getVersioning()) {
      throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+".type["+tr.getWorkingCode()+"].aggregation", t1.getVersioning(), t2.getVersioning()));
    }
    return tr;
  }

  private StructureDefinition findJointProfile(StructureDefinition sd1, StructureDefinition sd2) {
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      boolean b1 = sd.getBaseDefinitions().contains(sd1.getUrl()) || sd.getBaseDefinitions().contains(sd1.getVersionedUrl());
      boolean b2 = sd.getBaseDefinitions().contains(sd2.getUrl()) || sd.getBaseDefinitions().contains(sd2.getVersionedUrl());
      if (b1 && b2) {
        return sd;
      }
    }
    return null;
  }

  private boolean specialises(StructureDefinition focus, StructureDefinition other) {
    // we ignore impose and compliesWith - for now?
    for (String url : focus.getBaseDefinitions()) {
      StructureDefinition base = context.fetchResource(StructureDefinition.class, url);
      if (base != null) {
        if (base == other || specialises(base, other)) {
          return true;
        }
      }
    }
    return false;
  }

  private <T extends Base> void union(List<T> merged, List<T> source, List<T> base) {
    for (T st : source) {
      merged.add((T) st.copy());
    }
    for (T st : base) {
      boolean exists = false;
      for (T st2 : merged) {
        exists = exists || st.equals(st2);
      }
      if (!exists) {
        merged.add((T) st.copy());        
      }
    }
  }

  private boolean isLower(String vurl, String path, String property, DataType v1, DataType v2) {
    if (v1 instanceof Quantity && v2 instanceof Quantity) {
      Quantity q1 = (Quantity) v1;
      Quantity q2 = (Quantity) v2;
      if (q1.hasUnit() || q2.hasUnit()) {
        if (Utilities.stringsEqual(q1.getUnit(), q2.getUnit())) {
          throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+"."+property+".unit", v1.fhirType(), v2.fhirType()));
        }
      }
      return isLower(vurl, path, property+".value", q1.getValueElement(), q2.getValueElement());
    } else if (v1.isDateTime() && v2.isDateTime()) {
      DateTimeType d1 = (DateTimeType) v1;
      DateTimeType d2 = (DateTimeType) v2;
      return d1.before(d2);      
    } else if (Utilities.isDecimal(v1.primitiveValue(), true) && Utilities.isDecimal(v2.primitiveValue(), true)) {
      BigDecimal d1 = new BigDecimal(v1.primitiveValue());
      BigDecimal d2 = new BigDecimal(v2.primitiveValue());
      return d1.compareTo(d2) < 0;
    } else {
      throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+"."+property, v1.fhirType(), v2.fhirType()));
    }
  }

  private DataType checkPatternValues(String vurl, String path, DataType v1, DataType v2, boolean extras) {
    if (!v1.fhirType().equals(v2.fhirType())) {
      throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path, v1.fhirType(), v2.fhirType()));
    }
    DataType merged = v1.copy();
    if (v1.isPrimitive()) {
      if (!Utilities.stringsEqual(v1.primitiveValue(), v2.primitiveValue())) {
        throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+".value", v1.primitiveValue(), v2.primitiveValue()));        
      }
    }
    for (Property p1 : v1.children()) {
      Property p2 = v2.getChildByName(p1.getName());
      if (p1.hasValues() && p2.hasValues()) {
        if (p1.getValues().size() > 1 || p1.getValues().size() > 2) {
          throw new Error("Not supported");          
        }
        merged.setProperty(p1.getName(), checkPatternValues(vurl, path+"."+p1.getName(), (DataType) p1.getValues().get(0), (DataType) p2.getValues().get(0), extras));
      } else if (p2.hasValues()) {
        if (!extras) {
          throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+"."+p1.getName(), "null", v2.primitiveValue()));            
        }
        if (p2.getValues().size() > 1) {
          throw new Error("Not supported");
        }
        merged.setProperty(p1.getName(), p2.getValues().get(0).copy());
      }
    }
    return merged;
  }


  private void processSlices(StructureDefinitionDifferentialComponent diff, StructureDefinition src) {
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
            log.warn(message);
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

    for (ElementDefinition ed : diff.getElement()) {
      ProfileUtilities.markExtensions(ed, false, src);
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
        if (elementsMatch(elements.get(j), allSlices.get(i))) {
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
          if (elementsMatch(elements.get(j), allSlices.get(i))) {
            merge(elements.get(j), allSlices.get(i));
          }
        }
      }
    } else {
      Set<ElementDefinition> handled = new HashSet<>();

      // merge the simple stuff
      for (int j = startOfSlice; j <= endOfSlice; j++) {
        for (int i = 0; i < allSlices.size(); i++) {
          if (elementsMatch(elements.get(j), allSlices.get(i))) {
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

  private boolean elementsMatch(ElementDefinition ed1, ElementDefinition ed2) {
    if (!pathsMatch(ed1.getPath(), ed2.getPath())) {
      return false;
    } else if (ed1.getSliceName() != null && ed2.getSliceName() != null) {
      return ed1.getSliceName().equals(ed2.getSliceName());
    } else  if (ed1.getSliceName() != null || ed2.getSliceName() != null) {
      return false;
    } else {
      return true;
    }
  }

  private boolean pathsMatch(String path1, String path2) {
    if (path1.equals(path2)) {
      return true;
    }
    if (path1.endsWith("[x]")) {
      path1 = path1.substring(0, path1.length()-3);
      if (path2.startsWith(path1)) {
        if (!path2.substring(path1.length()).contains(".")) {
          return true;
        }
      }
    }
    if (path2.endsWith("[x]")) {
      path2 = path2.substring(0, path2.length()-3);
      if (path1.startsWith(path2)) {
        if (!path1.substring(path2.length()).contains(".")) {
          return true;
        }
      }
    }
    return false;
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
        if (i == Integer.min(p1.length,  p2.length) -1 && i1 == i2) {
          if (!p1[i].contains(":") && p2[i].contains(":")) {
            // launched straight into slicing without setting it up, 
            // and now it's being set up 
            return true;
          }
        }
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
      analysePathSegment(ed, res, pn);
    }
    return res;
  }

  private void analysePathSegment(ElementDefinition ed, List<ElementAnalysis> res, String pn) {
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

  private int findEndOfSlice(List<ElementDefinition> elements, ElementDefinition slice) {
    for (int i = elements.indexOf(slice); i < elements.size(); i++) {
      ElementDefinition e = elements.get(i);
      if (!(e.getPath().startsWith(slice.getPath()+".") ||
          (e.getPath().equals(slice.getPath()) && slice.getSliceName().equals(e.getSliceName())))) {
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
    insertMissingSparseElements(list, profile.getTypeName()); 
    return list; 
  } 

  private void insertMissingSparseElements(List<ElementDefinition> list, String typeName) {
    if (list.isEmpty() || list.get(0).getPath().contains(".")) {
      ElementDefinition ed = new ElementDefinition();
      ed.setPath(typeName);
      list.add(0, ed);
    }
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
    res.setWebPath(profile.getWebPath());
    return res;
  } 

}
