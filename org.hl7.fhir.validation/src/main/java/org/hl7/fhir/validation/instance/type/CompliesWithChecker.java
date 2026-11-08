package org.hl7.fhir.validation.instance.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.model.core.ElementDefinition.SlicingRules;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.Enumerations.BindingStrength;
import org.hl7.fhir.model.utilities.TerminologyUtilities;
import org.hl7.fhir.model.utilities.ValueSetUtilities;
import org.hl7.fhir.services.terminology.ExpansionOptions;
import org.hl7.fhir.services.terminology.ITerminologyClientManager;
import org.hl7.fhir.services.terminology.ValueSetExpansionOutcome;
import org.hl7.fhir.services.utilities.DefinitionNavigator;
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

  public List<ValidationMessage> checkCompliesWith(StructureDefinition claimee, StructureDefinition authority) throws IOException {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    
    DefinitionNavigator claimeeNavigator = new DefinitionNavigator(context, claimee, false, true);
    DefinitionNavigator authorityNavigator = new DefinitionNavigator(context, authority, false, true);

    String claimeePath = claimee.getType();
    if (!claimeePath.equals(authority.getType())) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_WRONG_TYPE, claimeePath, authority.getType()), IssueSeverity.ERROR));
    } else {
      checkCompliesWith(messages, claimeePath, claimeeNavigator, authorityNavigator, false);
    }
    return messages;
  }

  private void checkCompliesWith(List<ValidationMessage> messages, String claimeePath, DefinitionNavigator claimeeNavigator, DefinitionNavigator authorityNavigator, boolean isSlice) throws IOException {
    ElementDefinition claimeeElement = claimeeNavigator.current();
    ElementDefinition authorityElement = authorityNavigator.current();
    if (checkElementComplies(messages, claimeePath, claimeeElement, authorityElement, claimeeNavigator.getStructure(), authorityNavigator.getStructure(), isSlice)) {

      // if the type and children are the same on both sides, we can stop checking 
      if (!typesIdentical(claimeeElement, authorityElement) || claimeeNavigator.hasInlineChildren() || authorityNavigator.hasInlineChildren()) {
        // in principle, there is always children, but if the profile 
        // doesn't walk into them, and there's more than one type, the 
        // 
        for (int i = 0; i < authorityNavigator.children().size(); i++) {
          DefinitionNavigator authorityChild = authorityNavigator.children().get(i);
          checkCompilesWith(messages, claimeePath, claimeeNavigator, authorityChild);
        }
      }
    }
  }

  private void checkCompilesWith(List<ValidationMessage> messages, String claimeePath, DefinitionNavigator claimeeNavigator, DefinitionNavigator authorityChild) throws IOException {
    DefinitionNavigator claimeeChild = claimeeNavigator.childByName(authorityChild.current().getName());
    String claimeePathInner = claimeePath+"."+authorityChild.current().getName();
    if (claimeeChild == null) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePathInner, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_MISSING, authorityChild.globalPath()), IssueSeverity.ERROR));
    } else if (authorityChild.sliced() || claimeeChild.sliced()) {
      if (!claimeeChild.hasSlices()) {
        if (authorityChild.hasSlices()) {
          // do we care? if the authority slicing is closed, or any are mandatory
          boolean wecare = authorityChild.current().getSlicing().getRules() == SlicingRules.CLOSED;
          for (DefinitionNavigator anSlice : authorityChild.slices()) {
            wecare = wecare || anSlice.current().getMin() > 0;
          }
          if (wecare) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePathInner,
              context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_UNSLICED, claimeePathInner), IssueSeverity.ERROR));
          }
        } 
        checkCompliesWith(messages, claimeePathInner, claimeeChild, authorityChild, false);
     } else if (!authorityChild.hasSlices()) {
        for (DefinitionNavigator cc : claimeeChild.slices()) {
          checkCompliesWith(messages, claimeePathInner+":"+claimeeChild.current().getSliceName(), cc, authorityChild, true);
        }
      } else {
        checkByDiscriminator(messages, authorityChild, claimeePathInner, claimeeChild);
      }
    } else {
      checkCompliesWith(messages, claimeePathInner, claimeeChild, authorityChild, false);
    }
  }

  private void checkByDiscriminator(List<ValidationMessage> messages, DefinitionNavigator authorityChild, String claimeePath, DefinitionNavigator claimeeChild) throws IOException {
    List<ElementDefinitionSlicingDiscriminatorComponent> discriminators = new ArrayList<>();
    if (slicingCompliesWith(messages, claimeePath, authorityChild.current(), claimeeChild.current(), discriminators)) {
      List<DefinitionNavigator> processed = new ArrayList<DefinitionNavigator>();
      for (DefinitionNavigator authoritySlice : authorityChild.slices()) {
        String slicePath = claimeePath +":"+authoritySlice.current().getSliceName();
        List<DiscriminatorData> discriminatorValues = new ArrayList<>();
        List<DefinitionNavigator> cnSlices = findMatchingSlices(messages, claimeePath, slicePath, claimeeChild.slices(), discriminators, authoritySlice, discriminatorValues);
        if (cnSlices.isEmpty() && authoritySlice.current().getSlicing().getRules() != SlicingRules.CLOSED) {
          // if it's closed, then we just don't have any. But if it's not closed, we need the slice
          // because we don't know what constraints the authoritySlice is going to make. It's possible it won't
          // make any - it just exists and does nothing but then why does it exist?
          if (discriminatorValues.stream().anyMatch(d -> d != null && d.isUnknown())) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath,
              context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_NO_DISCRIMINATOR_VALUE, slicePath, discriminatorsToString(discriminators)), IssueSeverity.WARNING));
          } else if (hasAnyConstraints(authoritySlice)) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath,
              context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_NO_SLICE, slicePath, discriminatorsToString(discriminators),
                valuesToString(discriminatorValues)), IssueSeverity.ERROR));
          }
        }
        // when several claimee slices match one authority slice, their cardinalities add up
        boolean several = cnSlices.size() > 1;
        long minSum = 0;
        long maxSum = 0;
        boolean unbounded = false;
        CommaSeparatedStringBuilder sliceNames = new CommaSeparatedStringBuilder("|");
        for (DefinitionNavigator claimeeSlice : cnSlices) {
          String claimeeSlicePath = claimeePath +":"+claimeeSlice.current().getSliceName();
          if (!processed.contains(claimeeSlice)) {
            // it's weird if it does - is that a problem?
            processed.add(claimeeSlice);
          }
          checkCompliesWith(messages, claimeeSlicePath, claimeeSlice, authoritySlice, several);
          sliceNames.append(claimeeSlice.current().getSliceName());
          minSum += claimeeSlice.current().getMin();
          if ("*".equals(claimeeSlice.current().getMax())) {
            unbounded = true;
          } else {
            maxSum += claimeeSlice.current().getMaxAsInt();
          }
        }
        if (several) {
          ElementDefinition authority = authoritySlice.current();
          String slicesPath = claimeePath + ":" + sliceNames.toString();
          if (authority.getMin() > minSum) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "min", authority.getMin(), minSum, slicesPath), IssueSeverity.ERROR));
          }
          if (!"*".equals(authority.getMax()) && (unbounded || authority.getMaxAsInt() < maxSum)) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "max", authority.getMax(), unbounded ? "*" : maxSum, slicesPath), IssueSeverity.ERROR));
          }
        }
      }
      for (DefinitionNavigator cnSlice : claimeeChild.slices()) {
        if (!processed.contains(cnSlice)) {
          if (authorityChild.current().getSlicing().getRules() != SlicingRules.OPEN) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath,
                context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_EXTRA_SLICE, claimeePath, cnSlice.current().getSliceName()), IssueSeverity.ERROR));
          }
          String slicePath = claimeePath +":"+cnSlice.current().getSliceName();
          checkCompliesWith(messages, slicePath, cnSlice, authorityChild, true);
        }
      }
    }
  }

  /**
   * Return true if definitionNavigator has any constraints.
   *
   * @param authoritySlice the definitionNavigator to check
   *
   * @implNote for now, we just expect that it does, and return true. There's some weird condition where
   * the slice might exist for no reason - that would actually be ok. but determining that this
   * is the case is not simple, and since it's a weird corner case, why spend the effort?
   */
  private boolean hasAnyConstraints(DefinitionNavigator authoritySlice) {
    return true;
  }

  private Object discriminatorsToString(List<ElementDefinitionSlicingDiscriminatorComponent> discriminators) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|"); 
    for (ElementDefinitionSlicingDiscriminatorComponent dt : discriminators) {
      b.append(dt.getType().toCode()+":"+dt.getPath());
    }
    return b.toString();
  }

  private String valuesToString(List<DiscriminatorData> diffValues) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|"); 
    for (DiscriminatorData dt : diffValues) {
      if (dt != null) {
        b.append(dt.describe());
      }
    }
    return b.toString();
  }

  private List<DefinitionNavigator> findMatchingSlices(List<ValidationMessage> messages, String claimeePath, String slicePath, List<DefinitionNavigator> slices, List<ElementDefinitionSlicingDiscriminatorComponent> discriminators, DefinitionNavigator anSlice, List<DiscriminatorData> discriminatorValues) {
    List<DefinitionNavigator> list = new ArrayList<DefinitionNavigator>();
    for (ElementDefinitionSlicingDiscriminatorComponent ad : discriminators) {
      // first, determine the values for each of the discriminators in the authority slice
      discriminatorValues.add(getDisciminatorValue(messages, claimeePath, slicePath, anSlice, ad));
    }
    for (DefinitionNavigator slice : slices) {
      List<DiscriminatorData> values = new ArrayList<>();
      for (ElementDefinitionSlicingDiscriminatorComponent ad : discriminators) {
        // first, determine the values for each of the discriminators in the authority slice
        values.add(getDisciminatorValue(messages, claimeePath, slicePath, slice, ad));
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

  private boolean isMatch(ElementDefinitionSlicingDiscriminatorComponent discriminator, DiscriminatorData dt1, DiscriminatorData dt2) {
    if (dt1 == null) {
      return dt2 == null;
    } else if (dt2 == null) {
      return false;
    } else {
      switch (discriminator.getType()) {
      case EXISTS: return false;
      case NULL: return false;
      case POSITION: return false;
      case PROFILE: 
        if (dt1.profiles == null || dt2.profiles == null) {
          return false;
        }
        // each profile of the claimee slice has to be, derive from, impose or claim to comply with
        // one of the profiles of the authority slice. A broader claimee slice doesn't match
        for (CanonicalType ct : dt2.profiles) {
          if (dt1.profileUrls().stream().anyMatch(a -> sameCanonical(ct.asStringValue(), a))) {
            continue;
          }
          StructureDefinition sd2 = context.fetchResourceRaw(StructureDefinition.class, ct.asStringValue(), ExtensionUtilities.getVersionResolutionRules(ct));
          if (sd2 == null || !conformsTo(sd2, dt1.profileUrls(), new HashSet<>(), null)) {
            return false;
          }
        }
        return true;
      case TYPE: return dt1.value != null && dt2.value != null && dt1.value.primitiveValue().equals(dt2.value.primitiveValue());
      case PATTERN:
        if (dt1.value != null && dt2.value != null) {
          return dt1.value.equalsDeep(dt2.value); // todo: revise this?
        } else if (dt1.vs != null && dt2.vs != null) {
          return ValueSetUtilities.expansionsOverlap(dt1.vs, dt2.vs);
        } else {
          return false;
        }
      case VALUE:
        if (dt1.value != null && dt2.value != null) {
          return dt1.value.equalsDeep(dt2.value);
        } else if (dt1.vs != null && dt2.vs != null) {
          return ValueSetUtilities.expansionsOverlap(dt1.vs, dt2.vs);
        } else {
          return false;
        }
      default:
        return false;
      
      }
    }
  }

  private DiscriminatorData getDisciminatorValue(List<ValidationMessage> messages, String claimeePath, String slicePath, DefinitionNavigator authoritySlice, ElementDefinitionSlicingDiscriminatorComponent authorityDiscriminator) {
    switch (authorityDiscriminator.getType()) {
    case EXISTS: return new DiscriminatorData(getExistsDiscriminatorValue(authoritySlice, authorityDiscriminator.getPath()));
    case NULL:throw new FHIRException("Discriminator type 'Null' Not supported yet");
    case POSITION:throw new FHIRException("Discriminator type 'Position' Not supported yet");
    case PROFILE: return new DiscriminatorData(getProfileDiscriminatorValue(authoritySlice, authorityDiscriminator.getPath()));
    case TYPE: return new DiscriminatorData(getTypeDiscriminatorValue(authoritySlice, authorityDiscriminator.getPath()));
    case PATTERN:
    case VALUE: return getValueDiscriminatorValue(messages, claimeePath, slicePath, authoritySlice, authorityDiscriminator.getPath());
    default:
      throw new FHIRException("Not supported yet");    
    }
  }

  private List<CanonicalType> getProfileDiscriminatorValue(DefinitionNavigator authoritySlice, String authorityPath) {
    // for resolve(), the profiles are the target profiles of the reference
    boolean resolve = "resolve()".equals(authorityPath) || authorityPath.endsWith(".resolve()");
    String path = !resolve ? authorityPath : "resolve()".equals(authorityPath) ? "$this" : authorityPath.substring(0, authorityPath.length() - ".resolve()".length());
    DefinitionNavigator pathDN = getByPath(authoritySlice, path);
    ElementDefinition ed = pathDN == null ? null : pathDN.current();
    if (resolve && (ed == null || !ed.hasType() || !ed.getTypeFirstRep().hasTargetProfile()) && ("reference".equals(path) || path.endsWith(".reference"))) {
      // for a CodeableReference, the target profiles are on the CodeableReference itself
      DefinitionNavigator parentDN = getByPath(authoritySlice, "reference".equals(path) ? "$this" : path.substring(0, path.length() - ".reference".length()));
      if (parentDN != null) {
        ed = parentDN.current();
      }
    }
    if (ed == null || !ed.hasType()) {
      return null;
    }
    List<CanonicalType> profiles = new ArrayList<>();
    for (TypeRefComponent tr : ed.getTypeList()) {
      if (resolve) {
        if (tr.hasTargetProfile()) {
          profiles.addAll(tr.getTargetProfileList());
        } else {
          // no target profile, so any resource can be the target
          profiles.add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/Resource"));
        }
      } else if (tr.hasProfile()) {
        profiles.addAll(tr.getProfileList());
      } else {
        // no profile, so the slice is only constrained to the type itself
        StructureDefinition sd = context.fetchTypeDefinition(tr.getWorkingCode());
        if (sd == null) {
          return null;
        }
        profiles.add(new CanonicalType(sd.getUrl()));
      }
    }
    return profiles;
  }

  private DataType getExistsDiscriminatorValue(DefinitionNavigator authoritySlice, String authorityPath) {
    DefinitionNavigator pathDN = getByPath(authoritySlice, authorityPath);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    DataType dt = new BooleanType("1".equals(ed.getMax()));
    return dt;
  }

  private DataType getTypeDiscriminatorValue(DefinitionNavigator authoritySlice, String authorityPath) {
    DefinitionNavigator pathDN = getByPath(authoritySlice, authorityPath);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    DataType dt = new StringType(ed.typeSummary());
    return dt;
  }
  
  private DiscriminatorData getValueDiscriminatorValue(List<ValidationMessage> messages, String claimeePath, String slicePath, DefinitionNavigator authoritySlice, String authorityPath) {
    DefinitionNavigator pathDN = getByPath(authoritySlice, authorityPath);
    if (pathDN == null) {
      return null;
    }
    ElementDefinition ed = pathDN.current();
    DataType dt = ed.hasFixed() ? ed.getFixed() : ed.getPattern();
    if (dt != null) {
      return new DiscriminatorData(dt);
    }
    if (dt == null && ed.hasBinding() && ed.getBinding().getStrength() == BindingStrength.REQUIRED) {
      ValueSetExpansionOutcome exp = context.expandVS(new ExpansionOptions().withHierarchical(false), ed.getBinding().getValueSet());
      if (exp.isOk()) {
        return new DiscriminatorData(exp.getValueset());
      } else {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, slicePath,
          context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_NO_EXPAND, ed.getBinding().getValueSet(), exp.getError()), IssueSeverity.WARNING));
        return null;
      }
    }
    messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath,
       context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_NO_VALUE, slicePath), IssueSeverity.ERROR));
    return null;
  }

  private DefinitionNavigator getByPath(DefinitionNavigator focus, String claimeePath) {
    String segment = claimeePath.contains(".") ? claimeePath.substring(0, claimeePath.indexOf(".")) : claimeePath;
    if ("$this".equals(segment)) {
      return focus;
    }
    DefinitionNavigator p = focus.childByName(segment);
    if (p != null && claimeePath.contains(".")) {
      return getByPath(p, claimeePath.substring(claimeePath.indexOf(".")+1)); 
    } else {
      // we might need to look at the profile pointed to from the type

      return p;
    }
  }

  private boolean slicingCompliesWith(List<ValidationMessage> messages, String claimeePath, ElementDefinition authority, ElementDefinition claimee, List<ElementDefinitionSlicingDiscriminatorComponent> discriminators) {
    // the child must be sliced the same as the authority
    if (!(authority.getSlicing().getRules() == SlicingRules.OPEN || claimee.getSlicing().getRules() == authority.getSlicing().getRules())) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_RULES, claimeePath, authority.getSlicing().getRules().toCode(), claimee.getSlicing().getRules().toCode()), IssueSeverity.ERROR));
      return false;
    } else if (authority.getSlicing().getOrdered() && !claimee.getSlicing().getOrdered()) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_ORDER, claimeePath), IssueSeverity.ERROR));      
      return false;
    } else {
      // every discriminator that the authority has, the child has to have. The order of discriminators doesn't matter
      for (ElementDefinitionSlicingDiscriminatorComponent ad : authority.getSlicing().getDiscriminatorList()) {
        discriminators.add(ad);
        ElementDefinitionSlicingDiscriminatorComponent cd = null;
        for (ElementDefinitionSlicingDiscriminatorComponent t : claimee.getSlicing().getDiscriminatorList()) {
          if (t.getType() == ad.getType() && t.getPath().equals(ad.getPath())) {
            cd = t;
          }
        }
        if (cd == null) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_SLICING_DISCRIMINATOR, claimeePath, ad.getType(), ad.getPath()), IssueSeverity.ERROR));
          return false;
        }
      }
      return true;
    }
  }

  private boolean checkElementComplies(List<ValidationMessage> messages, String claimeePath, ElementDefinition claimee, ElementDefinition authority, StructureDefinition claimeeProfile, StructureDefinition authorityProfile, boolean inSlice) throws IOException {
    boolean doInner = true;
    if (!inSlice) {
      if (authority.getMin() > claimee.getMin()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "min", authority.getMin(), claimee.getMin(), claimee.getId()), IssueSeverity.ERROR));
      }
    }
    if (authority.getMaxAsInt() < claimee.getMaxAsInt()) {
      messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "max", authority.getMax(), claimee.getMax(), claimee.getId()), IssueSeverity.ERROR));
    }
    if (authority.hasFixed()) {
      if (!claimee.hasFixed()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "fixed", authority.getFixed(), null, claimee.getId()), IssueSeverity.ERROR));
      } else if (!compliesWith(authority.getFixed(), claimee.getFixed())) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "fixed", authority.getFixed(), claimee.getFixed(), claimee.getId()), IssueSeverity.ERROR));
      }
    } else if (authority.hasPattern()) {
      if (!claimee.hasFixed() && !claimee.hasPattern()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "pattern", authority.getPattern(), null, claimee.getId()), IssueSeverity.ERROR));
      } else if (claimee.hasFixed()) {
        if (!compliesWith(authority.getPattern(), claimee.getFixed())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "pattern", authority.getPattern(), claimee.getFixed(), claimee.getId()), IssueSeverity.ERROR));
        }
      } else { // if (claimee.hasPattern())
        if (!compliesWith(authority.getPattern(), claimee.getPattern())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "pattern", authority.getPattern(), claimee.getPattern(), claimee.getId()), IssueSeverity.ERROR));
        }
      }
    }
    if (!"Resource.id".equals(claimee.getBase().getPath())) { // tricky... there's definitional problems with Resource.id for legacy reasons, but whatever issues there are aren't due to anything the profile did
      for (TypeRefComponent tr : claimee.getTypeList()) {
        if (!hasType(tr, authority.getTypeList())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_BAD_TYPE, tr.getWorkingCode()), IssueSeverity.ERROR));        
        } else {
          checkTargetProfiles(messages, claimeePath, tr, authority.getTypeList());
        }
        doInner = false;
      }
    }
    if (authority.hasMinValue()) {
      if (notGreaterThan(authority.getMinValue(), claimee.getMinValue())) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "minValue", authority.getMinValue(), claimee.getMinValue(), claimee.getId()), IssueSeverity.ERROR));
      }
    }
    if (authority.hasMaxValue()) {
      if (notLessThan(authority.getMaxValue(), claimee.getMaxValue())) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "maxValue", authority.getMaxValue(), claimee.getMaxValue(), claimee.getId()), IssueSeverity.ERROR));
      }
    }
    if (authority.hasMaxLength()) {
      if (authority.getMaxLength() < claimee.getMaxLength()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "maxLength", authority.getMaxValue(), claimee.getMaxValue(), claimee.getId()), IssueSeverity.ERROR));
      }
    }
    if (authority.hasMustHaveValue()) {
      if (authority.getMustHaveValue() && !claimee.getMustHaveValue()) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "mustHaveValue", authority.getMustHaveValue(), claimee.getMustHaveValue(), claimee.getId()), IssueSeverity.ERROR));
      }
    }
    if (authority.hasValueAlternatives()) {
      for (CanonicalType ct : claimee.getValueAlternativesList()) {
        if (!hasCanonical(ct, authority.getValueAlternativesList())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_BAD_ELEMENT, "valueAlternatives", ct.toString()), IssueSeverity.ERROR));
        }
      }
    }
    for (ElementDefinitionConstraintComponent cc : authority.getConstraintList()) {
      if (cc.getSeverity() == ConstraintSeverity.ERROR) {
        if (!hasConstraint(cc, claimee.getConstraintList())) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_MISSING_ELEMENT, "constraint", cc.getExpression()), IssueSeverity.ERROR));
        }        
      }
    }

    if (authority.hasBinding() && authority.getBinding().hasValueSet() && (authority.getBinding().getStrength() == BindingStrength.REQUIRED || authority.getBinding().getStrength() == BindingStrength.EXTENSIBLE)) {
      if (!claimee.hasBinding()) {
        if (isBindableType(claimee)) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "binding", authority.getBinding().getValueSet(), "null", claimee.getId()), IssueSeverity.ERROR));
        }
      } else if (claimee.getBinding().getStrength() != BindingStrength.REQUIRED && claimee.getBinding().getStrength() != BindingStrength.EXTENSIBLE) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "binding.strength", authority.getBinding().getStrength(), claimee.getBinding().getStrength(), claimee.getId()), IssueSeverity.ERROR));
      } else if (claimee.getBinding().getStrength() == BindingStrength.EXTENSIBLE && authority.getBinding().getStrength() == BindingStrength.REQUIRED) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NOT_VALID, "binding.strength", authority.getBinding().getStrength(), claimee.getBinding().getStrength(), claimee.getId()), IssueSeverity.ERROR));
      } else if (!claimee.getBinding().getValueSet().equals(authority.getBinding().getValueSet())) {
        ValueSet cVS = context.fetchResource(ValueSet.class, claimee.getBinding().getValueSet(), ExtensionUtilities.getVersionResolutionRules(claimee.getBinding().getValueSetElement()), null, claimeeProfile);
        ValueSet aVS = context.fetchResource(ValueSet.class, authority.getBinding().getValueSet(), ExtensionUtilities.getVersionResolutionRules(authority.getBinding().getValueSetElement()), null, authorityProfile);
        if (aVS == null || cVS == null) {
          if (aVS == null) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS, authority.getBinding().getValueSet()), IssueSeverity.WARNING));
          } else {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS, claimee.getBinding().getValueSet()), IssueSeverity.WARNING));
          }
        } else {
          if (sameValueSets(cVS, aVS)) {
            // no message
          } else {
            ITerminologyClientManager terminologyClientManager = context.getTerminologyClientManager();
            ITerminologyClientN client = terminologyClientManager != null ? terminologyClientManager.getMasterClient() : null;
            if (client != null && TerminologyUtilities.supportsOperation(client.getCapabilitiesStatement(), "ValueSet", "$compare")) {
              Parameters params = client.getValueSetRelationship(cVS, aVS);
              throw new Error("not done yet");
            } else {
              ValueSetExpansionOutcome cExp = context.expandVS(cVS, true, false);
              ValueSetExpansionOutcome aExp = context.expandVS(aVS, true, false);
              if (!cExp.isOk() || !aExp.isOk()) {
                if (!aExp.isOk()) {
                  messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS_EXP, aVS.getVersionedUrl(), aExp.getError()), IssueSeverity.WARNING));
                }
                if (!cExp.isOk()) {
                  messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS_EXP, cVS.getVersionedUrl(), cExp.getError()), IssueSeverity.WARNING));
                }
              } else {
                Set<String> wrong = ValueSetUtilities.checkExpansionSubset(aExp.getValueset(), cExp.getValueset());
                if (!wrong.isEmpty()) {
                  messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_NO_VS_NO, cVS.getVersionedUrl(), aVS.getVersionedUrl(),
                    CommaSeparatedStringBuilder.joinToLimit(", ", 5, "etc", wrong)), claimee.getBinding().getStrength() == BindingStrength.REQUIRED ? IssueSeverity.ERROR : IssueSeverity.WARNING));
                }
              }
            }
          }
        }
      }
    }
    return doInner;
  }

  private boolean sameValueSets(ValueSet claimeeVS, ValueSet authorityVS) {
    return claimeeVS.getVersionedUrl() != null && claimeeVS.getVersionedUrl().equals(authorityVS.getVersionedUrl());
  }

  private boolean isBindableType(ElementDefinition c) {
    for (TypeRefComponent t : c.getTypeList()) {
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
    if (c.getTypeList().size() != a.getTypeList().size()) {
      return false;
    }
    for (TypeRefComponent ct : c.getTypeList()) {
      TypeRefComponent at = getType(a.getTypeList(), ct.getCode());
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
        // target profiles are checked separately in checkTargetProfiles
        if (ok) {
          return true;
        }
      }
    }
    return false;
  }

  private void checkTargetProfiles(List<ValidationMessage> messages, String claimeePath, TypeRefComponent tr, List<TypeRefComponent> types) {
    List<String> allowed = new ArrayList<>();
    for (TypeRefComponent t : types) {
      if (t.getWorkingCode().equals(tr.getWorkingCode())) {
        if (!t.hasTargetProfile()) {
          // the claimed profile doesn't restrict the targets
          return;
        }
        for (CanonicalType ct : t.getTargetProfileList()) {
          allowed.add(ct.getValue());
        }
      }
    }
    if (allowed.isEmpty()) {
      return;
    }
    if (!tr.hasTargetProfile()) {
      // any target is allowed in this profile
      String anyTarget = "http://hl7.org/fhir/StructureDefinition/Resource";
      if (!allowed.contains(anyTarget)) {
        messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_BAD_TARGET, anyTarget, tr.getWorkingCode(), CommaSeparatedStringBuilder.join(", ", allowed)), IssueSeverity.ERROR));
      }
    } else {
      for (CanonicalType ct : tr.getTargetProfileList()) {
        if (allowed.stream().anyMatch(a -> sameCanonical(ct.getValue(), a))) {
          continue;
        }
        StructureDefinition sd = context.fetchResourceRaw(StructureDefinition.class, ct.getValue(), ExtensionUtilities.getVersionResolutionRules(ct));
        List<String> unknown = new ArrayList<>();
        if (sd == null) {
          messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_TARGET_UNKNOWN, ct.getValue(), ct.getValue()), IssueSeverity.WARNING));
        } else if (!conformsTo(sd, allowed, new HashSet<>(), unknown)) {
          if (unknown.isEmpty()) {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_BAD_TARGET, ct.getValue(), tr.getWorkingCode(), CommaSeparatedStringBuilder.join(", ", allowed)), IssueSeverity.ERROR));
          } else {
            messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, claimeePath, context.formatMessage(I18nConstants.PROFILE_COMPLIES_WITH_TARGET_UNKNOWN, CommaSeparatedStringBuilder.join(", ", unknown), ct.getValue()), IssueSeverity.WARNING));
          }
        }
      }
    }
  }

  /**
   * true if sd is one of the allowed profiles, or derives from, imposes or claims to comply with one of them.
   * Profiles that can't be found on the way are added to unknown, if it's not null
   */
  private boolean conformsTo(StructureDefinition sd, List<String> allowed, Set<String> visited, List<String> unknown) {
    if (!visited.add(sd.getVersionedUrl())) {
      return false;
    }
    if (allowed.stream().anyMatch(a -> sameCanonical(sd.getVersionedUrl(), a))) {
      return true;
    }
    if (sd.hasBaseDefinition() && linkConformsTo(sd.getBaseDefinition(), sd.getBaseDefinitionElement(), allowed, visited, unknown)) {
      return true;
    }
    for (Extension ex : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_IMPOSE_PROFILE, ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE)) {
      if (ex.getValue() != null && ex.getValue().primitiveValue() != null && linkConformsTo(ex.getValue().primitiveValue(), ex.getValue(), allowed, visited, unknown)) {
        return true;
      }
    }
    return false;
  }

  /**
   * conformsTo for the profile at url, which is the base, an imposed or a claimed profile of another profile
   */
  private boolean linkConformsTo(String url, Element source, List<String> allowed, Set<String> visited, List<String> unknown) {
    if (allowed.stream().anyMatch(a -> sameCanonical(url, a))) {
      return true;
    }
    StructureDefinition sd = context.fetchResourceRaw(StructureDefinition.class, url, ExtensionUtilities.getVersionResolutionRules(source));
    if (sd == null) {
      if (unknown != null && !unknown.contains(url)) {
        unknown.add(url);
      }
      return false;
    }
    return conformsTo(sd, allowed, visited, unknown);
  }

  private boolean sameCanonical(String c1, String c2) {
    if (c1 == null || c2 == null) {
      return false;
    }
    if (c1.equals(c2)) {
      return true;
    }
    // an unversioned reference matches any version
    if (!c1.contains("|") || !c2.contains("|")) {
      String u1 = c1.contains("|") ? c1.substring(0, c1.indexOf("|")) : c1;
      String u2 = c2.contains("|") ? c2.substring(0, c2.indexOf("|")) : c2;
      return u1.equals(u2);
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
    for (Property p : authority.getChildren()) {
      if (p.hasValues()) {
        Property pt = test.getNamedProperty(p.getName(), true);
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

  private static class DiscriminatorData {
    private ValueSet vs;
    private DataType value;
    private List<CanonicalType> profiles;

    public DiscriminatorData(DataType value) {
      this.value = value;
    }

    public DiscriminatorData(ValueSet vs) {
      this.vs = vs;
    }

    public DiscriminatorData(List<CanonicalType> profiles) {
      this.profiles = profiles;
    }

    public boolean isUnknown() {
      return value == null && vs == null && profiles == null;
    }

    public List<String> profileUrls() {
      List<String> urls = new ArrayList<>();
      for (CanonicalType ct : profiles) {
        urls.add(ct.asStringValue());
      }
      return urls;
    }

    public String describe() {
      if (profiles != null) {
        return CommaSeparatedStringBuilder.join(" or ", profileUrls());
      } else if (value != null) {
        return value.toString();
      } else if (vs != null) {
        return vs.present();
      } else {
        return "?";
      }
    }
  }
}
