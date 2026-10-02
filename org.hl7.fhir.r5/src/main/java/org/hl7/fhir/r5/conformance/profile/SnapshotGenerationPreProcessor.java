package org.hl7.fhir.r5.conformance.profile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.SourcedChildDefinitions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
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

import org.hl7.fhir.r5.utils.TypesUtilities;
import org.hl7.fhir.utilities.UserDataNames;
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

  private IWorkerContext context;
  private ProfileUtilities utils;

  public SnapshotGenerationPreProcessor(ProfileUtilities utils) {
    super();
    this.utils = utils;
    this.context = utils.getContext();
  }

  public void process(StructureDefinitionDifferentialComponent diff, StructureDefinition srcOriginal) {
    StructureDefinition srcWrapper = shallowClone(srcOriginal, diff); 
    markExtensions(diff, srcWrapper);  
    if (srcWrapper.hasExtension(ExtensionDefinitions.EXT_ADDITIONAL_BASE)) {
       insertMissingSparseElements(diff.getElement(), srcWrapper.getTypeName());
       for (Extension ext : srcWrapper.getExtensionsByUrl(ExtensionDefinitions.EXT_ADDITIONAL_BASE)) {
         StructureDefinition ab = context.fetchResource(StructureDefinition.class, ext.getValue().primitiveValue(), ExtensionUtilities.getVersionResolutionRules(ext.getValue()));
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
      merged.setMinElement(source.getMin() > base.getMin() ? source.getMinElement().copy() : base.getMinElement().copy());      
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
      merged.setPattern(checkPatternValues(baseSD.getVersionedUrl(), source.getPath()+".pattern", source.getPattern(), base.getPattern(), true));
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
      merged.setMaxLengthElement(source.getMaxLength() < base.getMaxLength() ? source.getMaxLengthElement().copy() : base.getMaxLengthElement().copy());            
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
      StructureDefinition sd1 = context.fetchResource(StructureDefinition.class, t1.getProfile().get(0).asStringValue(), ExtensionUtilities.getVersionResolutionRules(t1.getProfile().get(0)));
      if (sd1 == null) {
        throw new FHIRException("Unknown type profile at '"+path+"': "+t1.getProfile().get(0).asStringValue());                
      }
      StructureDefinition sd2 = context.fetchResource(StructureDefinition.class, t2.getProfile().get(0).asStringValue(), ExtensionUtilities.getVersionResolutionRules(t2.getProfile().get(0)));
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
      StructureDefinition base = context.fetchResource(StructureDefinition.class, url, IWorkerContext.VersionResolutionRules.defaultRule());
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
        if (!Utilities.stringsEqual(q1.getUnit(), q2.getUnit())) {
          throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+"."+property+".unit", q1.getUnit(), q2.getUnit()));
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
        // A repeating child merges as a union: every value in a pattern has to be present
        // in the instance, so satisfying both bases means satisfying both lists. Only a
        // single-valued child has to be reconciled value by value.
        if (p1.getMaxCardinality() == 1) {
          replaceChild(merged, p1.getName(), Collections.singletonList((Base) checkPatternValues(
              vurl, path+"."+p1.getName(), (DataType) p1.getValues().get(0), (DataType) p2.getValues().get(0), extras)));
        } else {
          List<Base> union = new ArrayList<>();
          for (Base b : p1.getValues()) {
            union.add(b.copy()); // copies: the values belong to the profile they came from
          }
          for (Base b : p2.getValues()) {
            if (!containsDeep(union, b)) {
              if (!extras) {
                // v1 is a fixed value: it's exact, so it can't take on values it doesn't already have
                throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+"."+p1.getName(), "(not present)", b.toString()));
              }
              union.add(b.copy());
            }
          }
          replaceChild(merged, p1.getName(), union);
        }
      } else if (p2.hasValues()) {
        if (!extras) {
          throw new FHIRException(context.formatMessage(I18nConstants.SD_ADDITIONAL_BASE_INCOMPATIBLE_VALUES, vurl, path+"."+p1.getName(), "null", v2.primitiveValue()));            
        }
        List<Base> copies = new ArrayList<>();
        for (Base b : p2.getValues()) {
          copies.add(b.copy());
        }
        replaceChild(merged, p1.getName(), copies);
      }
    }
    return merged;
  }

  private boolean containsDeep(List<Base> list, Base value) {
    for (Base b : list) {
      if (b.equalsDeep(value)) {
        return true;
      }
    }
    return false;
  }

  /**
   * setProperty appends for a repeating child, and merged starts life as a copy of v1, so
   * setting a merged child straight onto it would leave the copy's own value in place
   * beside it. Clear what the copy brought over first.
   */
  private void replaceChild(Base merged, String name, List<Base> values) {
    Property existing = merged.getChildByName(name);
    if (existing != null && existing.hasValues()) {
      for (Base b : new ArrayList<>(existing.getValues())) {
        merged.removeChild(name, b);
      }
    }
    for (Base b : values) {
      merged.setProperty(name, b);
    }
  }


  private void markExtensions(StructureDefinitionDifferentialComponent diff, StructureDefinition src) {
    // note: the rules on a slicer apply to all its slices, but they are not copied into the slices
    for (ElementDefinition ed : diff.getElement()) {
      ProfileUtilities.markExtensions(ed, false, src);
    }
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
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //single literal character split
      String[] pathCurrent = list.get(i).getPath().split("\\.");
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //single literal character split
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
