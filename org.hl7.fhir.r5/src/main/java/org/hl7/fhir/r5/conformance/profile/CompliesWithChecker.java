package org.hl7.fhir.r5.conformance.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.DefinitionNavigator;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.UUIDUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

public class CompliesWithChecker {

  private IWorkerContext context;
  private String id;

  public CompliesWithChecker(IWorkerContext context) {
    super();
    this.context = context;
    this.id = UUIDUtilities.makeUuidLC();
  }

  public List<ValidationMessage> checkCompliesWith(StructureDefinition claimee, StructureDefinition authority) {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    
    DefinitionNavigator cn = new DefinitionNavigator(context, claimee, false, true);
    DefinitionNavigator an = new DefinitionNavigator(context, authority, false, true);

    String path = claimee.getType();
    if (!path.equals(authority.getType())) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_WRONG_TYPE, path, authority.getType()), IssueSeverity.ERROR));
    } else {
      checkCompliesWith(messages, path, cn, an, false);
    }
    return messages;
  }

  private void checkCompliesWith(List<ValidationMessage> messages, String path, DefinitionNavigator claimee, DefinitionNavigator authority, boolean isSlice) {
    ElementDefinition c = claimee.current();
    ElementDefinition a = authority.current();
    if (checkElementComplies(messages, path, c, a, isSlice)) {

      // if the type and children are the same on both sides, we can stop checking 
      if (!typesIdentical(c, a) || claimee.hasInlineChildren() || authority.hasInlineChildren()) {
        // in principle, there is always children, but if the profile 
        // doesn't walk into them, and there's more than one type, the 
        // 
        for (int i = 0; i < authority.children().size(); i++) {
          DefinitionNavigator anChild = authority.children().get(i);
          checkCompilesWith(messages, path, claimee, anChild);
        }
      }
    }
  }

  private void checkCompilesWith(List<ValidationMessage> messages, String path, DefinitionNavigator claimee, DefinitionNavigator anChild) {
    DefinitionNavigator cnChild = claimee.childByName(anChild.current().getName());
    String cpath = path+"."+anChild.current().getName();
    if (cnChild == null) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, cpath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_MISSING, anChild.globalPath()), IssueSeverity.ERROR));
    } else if (anChild.sliced() || cnChild.sliced()) {
      if (!cnChild.hasSlices()) {
        if (anChild.hasSlices()) {
          // do we care? if the authority slicing is closed, or any are mandatory
          boolean wecare = anChild.current().getSlicing().getRules() == SlicingRules.CLOSED;
          for (DefinitionNavigator anSlice : anChild.slices()) {
            wecare = wecare || anSlice.current().getMin() > 0;
          }
          if (wecare) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, cpath, 
              context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_UNSLICED, cpath), IssueSeverity.ERROR));
          }
        } 
        checkCompliesWith(messages, cpath, cnChild, anChild, false);
     } else if (!anChild.hasSlices()) {
        for (DefinitionNavigator cc : cnChild.slices()) {
          checkCompliesWith(messages, cpath+":"+cnChild.current().getSliceName(), cc, anChild, true);
        }
      } else {
        checkByDiscriminator(messages, anChild, cpath, cnChild);
      }
    } else {
      checkCompliesWith(messages, cpath, cnChild, anChild, false);
    }
  }

  private void checkByDiscriminator(List<ValidationMessage> messages, DefinitionNavigator anChild, String cpath, DefinitionNavigator cnChild) {
    List<ElementDefinitionSlicingDiscriminatorComponent> discriminators = new ArrayList<>();
    if (slicingCompliesWith(messages, cpath, anChild.current(), cnChild.current(), discriminators)) {
      List<DefinitionNavigator> processed = new ArrayList<DefinitionNavigator>();
      for (DefinitionNavigator anSlice : anChild.slices()) {
        String spath = cpath +":"+anSlice.current().getSliceName();
        List<DataType> discriminatorValues = new ArrayList<>();
        List<DefinitionNavigator> cnSlices = findMatchingSlices(cnChild.slices(), discriminators, anSlice, discriminatorValues);
        if (cnSlices.isEmpty() && anSlice.current().getSlicing().getRules() != SlicingRules.CLOSED) {
          // if it's closed, then we just don't have any. But if it's not closed, we need the slice
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, cpath,
              context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_NO_SLICE, spath, discriminatorsToString(discriminators),
                  valuesToString(discriminatorValues)), IssueSeverity.ERROR));
        }
        for (DefinitionNavigator cnSlice : cnSlices) {
          spath = cpath +":"+cnSlice.current().getSliceName();
          if (!processed.contains(cnSlice)) {
            // it's weird if it does - is that a problem?
            processed.add(cnSlice);
          }
          checkCompliesWith(messages, spath, cnSlice, anSlice, false);
        }
      }
      for (DefinitionNavigator cnSlice : cnChild.slices()) {
        if (!processed.contains(cnSlice)) {
          if (anChild.current().getSlicing().getRules() != SlicingRules.OPEN) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, cpath,
                context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_EXTRA_SLICE, cpath, cnSlice.current().getSliceName()), IssueSeverity.ERROR));
          }
          String spath = cpath +":"+cnSlice.current().getSliceName();
          checkCompliesWith(messages, spath, cnSlice, anChild, true);
        }
      }
    }
  }

  private Object discriminatorsToString(List<ElementDefinitionSlicingDiscriminatorComponent> discriminators) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|"); 
    for (ElementDefinitionSlicingDiscriminatorComponent dt : discriminators) {
      b.append(dt.getType().toCode()+":"+dt.getPath());
    }
    return b.toString();
  }

  private String valuesToString(List<DataType> diffValues) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|"); 
    for (DataType dt : diffValues) {
      if (dt != null) {
        b.append(dt.toString());
      }
    }
    return b.toString();
  }

  private List<DefinitionNavigator> findMatchingSlices(List<DefinitionNavigator> slices, List<ElementDefinitionSlicingDiscriminatorComponent> discriminators, DefinitionNavigator anSlice, List<DataType> discriminatorValues) {
    List<DefinitionNavigator> list = new ArrayList<DefinitionNavigator>();
    for (ElementDefinitionSlicingDiscriminatorComponent ad : discriminators) {
      // first, determine the values for each of the discriminators in the authority slice
      discriminatorValues.add(getDisciminatorValue(anSlice, ad));
    }
    for (DefinitionNavigator slice : slices) {
      List<DataType> values = new ArrayList<>();      
      for (ElementDefinitionSlicingDiscriminatorComponent ad : discriminators) {
        // first, determine the values for each of the discriminators in the authority slice
        values.add(getDisciminatorValue(slice, ad));
      }
      boolean ok = true;
      for (int i = 0; i < discriminators.size(); i++) {
        if (!isMatch(discriminators.get(i), discriminatorValues.get(i), values.get(i))) {
          ok = false;
          break;
        }
      }
      if (ok) {
        list.add(slice);
      }
    }
    return list;
  }

  private boolean isMatch(ElementDefinitionSlicingDiscriminatorComponent discriminator, DataType dt1, DataType dt2) {
    if (dt1 == null) {
      return dt2 == null;
    } else if (dt2 == null) {
      return false;
    } else {
      switch (discriminator.getType()) {
      case EXISTS: return false;
      case NULL: return false;
      case PATTERN: return dt1.equalsDeep(dt2); // todo
      case POSITION: return false;
      case PROFILE: 
        StructureDefinition sd1 = context.fetchResource(StructureDefinition.class, dt1.primitiveValue());
        StructureDefinition sd2 = context.fetchResource(StructureDefinition.class, dt2.primitiveValue());
        if (sd1 == null || sd2 == null) {
          return false;
        }
        for (Extension ex : sd2.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE)) {
          String url = ex.getValue().primitiveValue();
          if (url != null) {
            StructureDefinition sde = sd1;
            while (sde != null) {
              if (url.equals(sde.getUrl()) || url.equals(sde.getVersionedUrl())) {
                return true;
              }
              sde = context.fetchResource(StructureDefinition.class, sde.getBaseDefinition());
            }
          }
        }
        for (Extension ex : sd2.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_IMPOSE_PROFILE)) {
          String url = ex.getValue().primitiveValue();
          if (url != null) {
            StructureDefinition sde = sd1;
            while (sde != null) {
              if (url.equals(sde.getUrl()) || url.equals(sde.getVersionedUrl())) {
                return true;
              }
              sde = context.fetchResource(StructureDefinition.class, sde.getBaseDefinition());
            }
          }
        }
        StructureDefinition sde = sd1;
        while (sde != null) {
          if (sd2.getVersionedUrl().equals(sde.getVersionedUrl())) {
            return true;
          }
          sde = context.fetchResource(StructureDefinition.class, sde.getBaseDefinition());
        }
        return false;
      case TYPE: return dt1.primitiveValue().equals(dt2.primitiveValue());
      case VALUE: return dt1.equalsDeep(dt2);
      default:
        return false;
      
      }
    }
  }

  private DataType getDisciminatorValue(DefinitionNavigator anSlice, ElementDefinitionSlicingDiscriminatorComponent ad) {
    switch (ad.getType()) {
    case EXISTS: return getExistsDiscriminatorValue(anSlice, ad.getPath());
    case NULL:throw new FHIRException("Discriminator type 'Null' Not supported yet");
    case POSITION:throw new FHIRException("Discriminator type 'Position' Not supported yet");
    case PROFILE: return getProfileDiscriminatorValue(anSlice, ad.getPath());
    case TYPE: return getTypeDiscriminatorValue(anSlice, ad.getPath());
    case PATTERN:
    case VALUE: return getValueDiscriminatorValue(anSlice, ad.getPath());
    default:
      throw new FHIRException("Not supported yet");    
    }
  }

  private DataType getProfileDiscriminatorValue(DefinitionNavigator anSlice, String path) {
    DefinitionNavigator pathDN = getByPath(anSlice, path);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    if (!ed.hasType() || !ed.getTypeFirstRep().hasProfile()) {
      return null;
    } else {
      return new CanonicalType(ed.getTypeFirstRep().getProfile().get(0).asStringValue());
    }
  }

  private DataType getExistsDiscriminatorValue(DefinitionNavigator anSlice, String path) {
    DefinitionNavigator pathDN = getByPath(anSlice, path);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    DataType dt = new BooleanType("1".equals(ed.getMax()));
    return dt;
  }

  private DataType getTypeDiscriminatorValue(DefinitionNavigator anSlice, String path) {
    DefinitionNavigator pathDN = getByPath(anSlice, path);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    DataType dt = new StringType(ed.typeSummary());
    return dt;
  }
  
  private DataType getValueDiscriminatorValue(DefinitionNavigator anSlice, String path) {
    DefinitionNavigator pathDN = getByPath(anSlice, path);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    DataType dt = ed.hasFixed() ? ed.getFixed() : ed.getPattern();
    return dt;
  }

  private DefinitionNavigator getByPath(DefinitionNavigator focus, String path) {
    String segment = path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
    if ("$this".equals(segment)) {
      return focus;
    }
    DefinitionNavigator p = focus.childByName(segment);
    if (p != null && path.contains(".")) {
      return getByPath(p, path.substring(path.indexOf(".")+1)); 
    } else {
      // we might need to look at the profile pointed to from the type

      return p;
    }
  }

  private boolean slicingCompliesWith(List<ValidationMessage> messages, String path, ElementDefinition a, ElementDefinition c, List<ElementDefinitionSlicingDiscriminatorComponent> discriminators) {
    // the child must be sliced the same as the authority
    if (!(a.getSlicing().getRules() == SlicingRules.OPEN || c.getSlicing().getRules() == a.getSlicing().getRules())) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_RULES, path, a.getSlicing().getRules().toCode(), c.getSlicing().getRules().toCode()), IssueSeverity.ERROR));      
      return false;
    } else if (a.getSlicing().getOrdered() && !c.getSlicing().getOrdered()) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_ORDER, path), IssueSeverity.ERROR));      
      return false;
    } else {
      // every discriminator that the authority has, the child has to have. The order of discriminators doesn't matter
      for (ElementDefinitionSlicingDiscriminatorComponent ad : a.getSlicing().getDiscriminator()) {
        discriminators.add(ad);
        ElementDefinitionSlicingDiscriminatorComponent cd = null;
        for (ElementDefinitionSlicingDiscriminatorComponent t : c.getSlicing().getDiscriminator()) {
          if (t.getType() == ad.getType() && t.getPath().equals(ad.getPath())) {
            cd = t;
          }
        }
        if (cd == null) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_DISCRIMINATOR, path, ad.getType(), ad.getPath()), IssueSeverity.ERROR));
          return false;
        }
      }
      return true;
    }
  }

  private boolean checkElementComplies(List<ValidationMessage> messages, String path, ElementDefinition c, ElementDefinition a, boolean inSlice) {
    boolean doInner = true;
    if (!inSlice) {
      if (a.getMin() > c.getMin()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "min", a.getMin(), c.getMin(), c.getId()), IssueSeverity.ERROR));
      }
    }
    if (a.getMaxAsInt() < c.getMaxAsInt()) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "max", a.getMax(), c.getMax(), c.getId()), IssueSeverity.ERROR));
    }
    if (a.hasFixed()) {
      if (!c.hasFixed()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "fixed", a.getFixed(), null, c.getId()), IssueSeverity.ERROR));
      } else if (!compliesWith(a.getFixed(), c.getFixed())) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "fixed", a.getFixed(), c.getFixed(), c.getId()), IssueSeverity.ERROR));
      }
    } else if (a.hasPattern()) {
      if (!c.hasFixed() && !c.hasPattern()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "pattern", a.getFixed(), null, c.getId()), IssueSeverity.ERROR));
      } else if (c.hasFixed()) {
        if (!compliesWith(a.getFixed(), c.getFixed())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "pattern", a.getFixed(), c.getFixed(), c.getId()), IssueSeverity.ERROR));
        }
      } else { // if (c.hasPattern()) 
        if (!compliesWith(a.getPattern(), c.getPattern())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "pattern", a.getFixed(), c.getPattern(), c.getId()), IssueSeverity.ERROR));
        }
      }
    }
    if (!"Resource.id".equals(c.getBase().getPath())) { // tricky... there's definitional problems with Resource.id for legacy reasons, but whatever issues there are aren't due to anything the profile did
      for (TypeRefComponent tr : c.getType()) {
        if (!hasType(tr, a.getType())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_BAD_TYPE, tr.getWorkingCode()), IssueSeverity.ERROR));        
        }
        doInner = false;
      }
    }
    if (a.hasMinValue()) {
      if (notGreaterThan(a.getMinValue(), c.getMinValue())) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "minValue", a.getMinValue(), c.getMinValue(), c.getId()), IssueSeverity.ERROR));
      }
    }
    if (a.hasMaxValue()) {
      if (notLessThan(a.getMaxValue(), c.getMaxValue())) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "maxValue", a.getMaxValue(), c.getMaxValue(), c.getId()), IssueSeverity.ERROR));
      }
    }
    if (a.hasMaxLength()) {
      if (a.getMaxLength() < c.getMaxLength()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "maxLength", a.getMaxValue(), c.getMaxValue(), c.getId()), IssueSeverity.ERROR));
      }
    }
    if (a.hasMustHaveValue()) {
      if (a.getMustHaveValue() && !c.getMustHaveValue()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "mustHaveValue", a.getMustHaveValue(), c.getMustHaveValue(), c.getId()), IssueSeverity.ERROR));
      }
    }
    if (a.hasValueAlternatives()) {
      for (CanonicalType ct : c.getValueAlternatives()) {
        if (!hasCanonical(ct, a.getValueAlternatives())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_BAD_ELEMENT, "valueAlternatives", ct.toString()), IssueSeverity.ERROR));
        }
      }
    }
    for (ElementDefinitionConstraintComponent cc : a.getConstraint()) {
      if (cc.getSeverity() == ConstraintSeverity.ERROR) {
        if (!hasConstraint(cc, c.getConstraint())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_MISSING_ELEMENT, "constraint", cc.getExpression()), IssueSeverity.ERROR));
        }        
      }
    }

    if (a.hasBinding() && a.getBinding().hasValueSet() && (a.getBinding().getStrength() == BindingStrength.REQUIRED || a.getBinding().getStrength() == BindingStrength.EXTENSIBLE)) {
      if (!c.hasBinding()) {
        if (isBindableType(c)) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "binding", a.getBinding().getValueSet(), "null", c.getId()), IssueSeverity.ERROR));
        }
      } else if (c.getBinding().getStrength() != BindingStrength.REQUIRED && c.getBinding().getStrength() != BindingStrength.EXTENSIBLE) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "binding.strength", a.getBinding().getStrength(), c.getBinding().getStrength(), c.getId()), IssueSeverity.ERROR));
      } else if (c.getBinding().getStrength() == BindingStrength.EXTENSIBLE && a.getBinding().getStrength() == BindingStrength.REQUIRED) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "binding.strength", a.getBinding().getStrength(), c.getBinding().getStrength(), c.getId()), IssueSeverity.ERROR));
      } else if (!c.getBinding().getValueSet().equals(a.getBinding().getValueSet())) {
        ValueSet cVS = context.fetchResource(ValueSet.class, c.getBinding().getValueSet());
        ValueSet aVS = context.fetchResource(ValueSet.class, a.getBinding().getValueSet());
        if (aVS == null || cVS == null) {
          if (aVS == null) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS, a.getBinding().getValueSet()), IssueSeverity.WARNING));
          } else {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS, c.getBinding().getValueSet()), IssueSeverity.WARNING));
          }
        } else {
          ValueSetExpansionOutcome cExp = context.expandVS(cVS, true, false);
          ValueSetExpansionOutcome aExp = context.expandVS(aVS, true, false);
          if (!cExp.isOk() || !aExp.isOk()) {
            if (!aExp.isOk()) {
             messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS_EXP, aVS.getVersionedUrl(), aExp.getError()), IssueSeverity.WARNING));
            } else {
              messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS_EXP, cVS.getVersionedUrl(), cExp.getError()), IssueSeverity.WARNING));  
            }            
          } else {
            Set<String> wrong = ValueSetUtilities.checkExpansionSubset(aExp.getValueset(), cExp.getValueset());
            if (!wrong.isEmpty()) {
              messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, path, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS_NO, cVS.getVersionedUrl(), aVS.getVersionedUrl(), 
                    CommaSeparatedStringBuilder.joinToLimit(", ", 5, "etc", wrong)), c.getBinding().getStrength() == BindingStrength.REQUIRED ? IssueSeverity.ERROR : IssueSeverity.WARNING));
            }
          }
        }
      }
    }
    return doInner;
  }

  private boolean isBindableType(ElementDefinition c) {
    for (TypeRefComponent t : c.getType()) {
      if (isBindableType(t.getWorkingCode())) {
        return true;
      }
    }
    return false;
  }

  private boolean isBindableType(String type) {
    if (Utilities.existsInList(type, "CodeableConcept", "Coding", "code", "CodeableReference", "string", "uri", "Quantity")) {
      return true;
    }
    StructureDefinition sd = context.fetchTypeDefinition(type);
    if (sd == null) {
      return false;
    }
    for (Extension ex : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_CHARACTERISTICS)) {
      if ("can-bind".equals(ex.getValue().primitiveValue())) {
        return true;
      }
    }
    return false;
  }

  private boolean typesIdentical(ElementDefinition c, ElementDefinition a) {
    if (c.getType().size() != a.getType().size()) {
      return false;
    }
    for (TypeRefComponent ct : c.getType()) {
      TypeRefComponent at = getType(a.getType(), ct.getCode());
      if (at == null || !at.equalsDeep(ct)) {
        return false;
      }
    }
    return true;
  }

  private TypeRefComponent getType(List<TypeRefComponent> types, String code) {
    for (TypeRefComponent t : types) {
      if (code.equals(t.getCode())) {
        return t;
      }
    }
    return null;
  }

  private boolean hasConstraint(ElementDefinitionConstraintComponent cc, List<ElementDefinitionConstraintComponent> list) {
    for (ElementDefinitionConstraintComponent  t : list) {
      if (t.getSeverity() == ConstraintSeverity.ERROR && t.getExpression().equals(cc.getExpression())) {
        return true;
      }
    }
    return false;
  }

  private boolean hasCanonical(CanonicalType ct, List<CanonicalType> list) {
    for (CanonicalType t : list) {
      if (t.hasValue() && t.getValue().equals(ct.getValue())) {
        return true;
      }
    }
    return false;
  }

  private boolean notLessThan(DataType v1, DataType v2) {
    if (v2 == null) {
      return true;
    }
    if (!v1.fhirType().equals(v2.fhirType())) {
      return true;
    }
    switch (v1.fhirType()) {
    case "date" :
    case "dateTime":
    case "instant":
      return !((DateTimeType) v1).before((DateTimeType) v2);
    case "time":
      return v1.primitiveValue().compareTo(v2.primitiveValue()) >= 0;
    case "decimal":
      return ((DecimalType) v1).compareTo((DecimalType) v2) >= 0;
    case "integer":
    case "integer64":
    case "positiveInt":
    case "unsignedInt":
      int i1 = Integer.parseInt(v1.toString());
      int i2 = Integer.parseInt(v2.toString());
      return i1 >= i2; 
    case "Quantity":
      Quantity q1 = (Quantity) v1;
      Quantity q2 = (Quantity) v2;
      
    default: 
      return true;
    }
  }

  private boolean notGreaterThan(DataType minValue, DataType minValue2) {
    // TODO Auto-generated method stub
    return false;
  }

  private boolean hasType(TypeRefComponent tr, List<TypeRefComponent> types) {
    for (TypeRefComponent t : types) {
      if (t.getWorkingCode().equals(tr.getWorkingCode())) {
        boolean ok = t.getVersioning() == tr.getVersioning();
        // we don't care about profile - that's the whole point, we just go ehad and check that
//        for (CanonicalType ct : tr.getProfile()) {
//          if (!t.hasProfile(ct.asStringValue())) {
//            ok = false;
//          }
//        }
        // todo: we have to check that the targets are compatible
//        for (CanonicalType ct : tr.getTargetProfile()) {
//          if (!t.hasTargetProfile(ct.asStringValue())) {
//            ok = false;
//          }
//        }
        if (ok) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean compliesWith(DataType authority, DataType test) {
    if (!authority.fhirType().equals(test.fhirType())) {
      return false;
    }
    if (authority.isPrimitive()) {
      if (!authority.primitiveValue().equals(test.primitiveValue())) {
        return false;
      }
    } 
    for (Property p : authority.children()) {
      if (p.hasValues()) {
        Property pt = test.getNamedProperty(p.getName());
        if (p.getValues().size() > pt.getValues().size()) {
          return false;
        } else {
          for (int i = 0; i < pt.getValues().size(); i++) {
            DataType v = (DataType) p.getValues().get(i);
            DataType vt = (DataType) pt.getValues().get(i);
            if (!compliesWith(v, vt)) {
              return false;
            }
          }
        }
      }      
    }
    return true;
  }
}
