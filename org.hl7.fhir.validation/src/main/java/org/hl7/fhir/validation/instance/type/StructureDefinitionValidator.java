package org.hl7.fhir.validation.instance.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.factory.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class StructureDefinitionValidator extends BaseValidator {

  public class FhirPathSorter implements Comparator<ExpressionNode> {

    @Override
    public int compare(ExpressionNode arg0, ExpressionNode arg1) {
      return arg0.toString().compareTo(arg1.toString());
    }

  }

  private FHIRPathEngine fpe;
  private boolean wantCheckSnapshotUnchanged;

  public StructureDefinitionValidator(IWorkerContext context, TimeTracker timeTracker, FHIRPathEngine fpe, boolean wantCheckSnapshotUnchanged, XVerExtensionManager xverManager, Coding jurisdiction) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
    this.wantCheckSnapshotUnchanged = wantCheckSnapshotUnchanged;
    this.jurisdiction = jurisdiction;
  }
  
  public void validateStructureDefinition(List<ValidationMessage> errors, Element src, NodeStack stack)  {
    StructureDefinition sd = null;
    try {
      sd = loadAsSD(src);
      List<ElementDefinition> snapshot = sd.getSnapshot().getElement();
      sd.setSnapshot(null);
      StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      if (warning(errors, IssueType.NOTFOUND, stack.getLiteralPath(), base != null, I18nConstants.UNABLE_TO_FIND_BASE__FOR_, sd.getBaseDefinition(), "StructureDefinition, so can't check the differential")) {
        if (rule(errors, IssueType.NOTFOUND, stack.getLiteralPath(), sd.hasDerivation(), I18nConstants.SD_MUST_HAVE_DERIVATION, sd.getUrl())) {
          if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
            List<ValidationMessage> msgs = new ArrayList<>();
            ProfileUtilities pu = new ProfileUtilities(context, msgs, null);
            pu.setXver(xverManager);
            pu.generateSnapshot(base, sd, sd.getUrl(), "http://hl7.org/fhir/R4/", sd.getName());
            if (msgs.size() > 0) {
              for (ValidationMessage msg : msgs) {
                // we need to set the location for the context 
                String loc = msg.getLocation();
                if (loc.contains("#")) {
                  msg.setLocation(stack.getLiteralPath()+".differential.element.where(path = '"+loc.substring(loc.indexOf("#")+1)+"')");
                } else {
                  msg.setLocation(stack.getLiteralPath());
                }
                errors.add(msg);
              }
            }
            if (!snapshot.isEmpty() && wantCheckSnapshotUnchanged) {
              int was = snapshot.size();
              int is = sd.getSnapshot().getElement().size();
              rule(errors, IssueType.NOTFOUND, stack.getLiteralPath(), was == is, I18nConstants.SNAPSHOT_EXISTING_PROBLEM, was, is);
            }
          }
        }
        if ("constraint".equals(src.getChildValue("derivation"))) {
          rule(errors, IssueType.NOTFOUND, stack.getLiteralPath(), base.getKindElement().primitiveValue().equals(src.getChildValue("kind")), 
              I18nConstants.SD_DERIVATION_KIND_MISMATCH, base.getKindElement().primitiveValue(), src.getChildValue("kind"));
        }
      }
    } catch (FHIRException | IOException e) {
      rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.ERROR_GENERATING_SNAPSHOT, e.getMessage());
    }
    List<Element> differentials = src.getChildrenByName("differential");
    List<Element> snapshots = src.getChildrenByName("snapshot");
    for (Element differential : differentials) {
      validateElementList(errors, differential, stack.push(differential, -1, null, null), false, snapshots.size() > 0, sd);
    }
    for (Element snapshot : snapshots) {
      validateElementList(errors, snapshot, stack.push(snapshot, -1, null, null), true, true, sd);
    }
  }

  private void validateElementList(List<ValidationMessage> errors, Element elementList, NodeStack stack, boolean snapshot, boolean hasSnapshot, StructureDefinition sd) {
    List<Element> elements = elementList.getChildrenByName("element");
    int cc = 0;
    for (Element element : elements) {
      validateElementDefinition(errors, element, stack.push(element, cc, null, null), snapshot, hasSnapshot, sd);
      cc++;
    }    
  }

  private void validateElementDefinition(List<ValidationMessage> errors, Element element, NodeStack stack, boolean snapshot, boolean hasSnapshot, StructureDefinition sd) {
    boolean typeMustSupport = false;
    List<Element> types = element.getChildrenByName("type");
    Set<String> typeCodes = new HashSet<>();
    Set<String> characteristics = new HashSet<>();
    
    for (Element type : types) {
      if (hasMustSupportExtension(type)) {
        typeMustSupport = true;
      }
      String tc = type.getChildValue("code");
      if (type.hasExtension(ToolingExtensions.EXT_FHIR_TYPE)) {
        tc = type.getExtensionValue(ToolingExtensions.EXT_FHIR_TYPE).primitiveValue();
      }
      if (Utilities.noString(tc) && type.hasChild("code")) {
        if (type.getNamedChild("code").hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-json-type")) {
          tc = "*";
        }
      }
      typeCodes.add(tc);
      Set<String> tcharacteristics = new HashSet<>();
      addCharacteristics(tcharacteristics, tc);
      characteristics.addAll(tcharacteristics);
      if (type.hasChildren("targetProfile")) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), tcharacteristics.contains("has-target") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "targetProfile", tc);
      }
      // check the stated profile - must be a constraint on the type 
      if (snapshot || sd != null) {
        validateElementType(errors, type, stack.push(type, -1, null, null), sd, element.getChildValue("path"));
      }
    }
    if (typeMustSupport) {
      if (snapshot) {
        rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), "true".equals(element.getChildValue("mustSupport")), I18nConstants.SD_NESTED_MUST_SUPPORT_SNAPSHOT, element.getNamedChildValue("path"));
      } else {
        hint(errors, IssueType.EXCEPTION, stack.getLiteralPath(), hasSnapshot || "true".equals(element.getChildValue("mustSupport")), I18nConstants.SD_NESTED_MUST_SUPPORT_DIFF, element.getNamedChildValue("path"));        
      }
    }
    if (element.hasChild("binding")) {
      if (!typeCodes.isEmpty()) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("can-bind") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Binding", typeCodes);
      }
      Element binding = element.getNamedChild("binding");
      validateBinding(errors, binding, stack.push(binding, -1, null, null), typeCodes, snapshot, element.getNamedChildValue("path"));
    } else {
      // this is a good idea but there's plenty of cases where the rule isn't met; maybe one day it's worth investing the time to exclude these cases and bring this rule back
//      String bt = boundType(typeCodes);
//      hint(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || bt == null, I18nConstants.SD_ED_SHOULD_BIND, element.getNamedChildValue("path"), bt);              
    }
    if (!typeCodes.isEmpty()) {
      if (element.hasChild("maxLength")) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-length") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MaxLength", typeCodes);      
      }
      if (element.hasExtension(ToolingExtensions.EXT_MIN_LENGTH)) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-length") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MinLength Extension", typeCodes);      
      }
      if (element.hasChild("minValue")) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-range") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MinValue", typeCodes);      
      }
      if (element.hasChild("maxValue")) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-range") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MaxValue", typeCodes);      
      }
      if (element.hasExtension(ToolingExtensions.EXT_MAX_DECIMALS)) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("is-continuous") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Max Decimal Places Extension", typeCodes);      
      }
      if (element.hasExtension(ToolingExtensions.EXT_MAX_SIZE)) {
        rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-size") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Max Size", typeCodes);      
      }
    }
    // in a snapshot, we validate that fixedValue, pattern, and defaultValue, if present, are all of the right type
    if (snapshot && (element.getIdBase() != null) && (element.getIdBase().contains("."))) {
      if (rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), !typeCodes.isEmpty() || element.hasChild("contentReference"), I18nConstants.SD_NO_TYPES_OR_CONTENTREF, element.getIdBase())) {     
        // if we see fixed[x] or pattern[x] applied to a repeating element, we'll give the user a hint
        boolean repeating = !Utilities.existsInList(element.getChildValue("max"), "0", "1");
        
        Element v = element.getNamedChild("defaultValue");
        if (v != null) {
          rule(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "defaultValue", v.fhirType(), typeCodes);
        }
        v = element.getNamedChild("fixed");
        if (v != null) {
          rule(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "fixed", v.fhirType(), typeCodes);
          hint(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_HINT, element.getIdBase(), "fixed");
          if (isPrimitiveType(v.fhirType())) {
            warning(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_WARNING_DOTNET, element.getIdBase(), "fixed");
          } else {
            warning(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), false, I18nConstants.SD_VALUE_COMPLEX_FIXED, v.fhirType());            
          }
        }
        v = element.getNamedChild("pattern");
        if (v != null) {
          rule(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "pattern", v.fhirType(), typeCodes);
          hint(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_HINT, element.getIdBase(), "pattern");
          if (isPrimitiveType(v.fhirType())) {
            warning(errors, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_WARNING_DOTNET, element.getIdBase(), "pattern");
          }
        }
      }
      // if we see fixed[x] or pattern[x] applied to a repeating element, we'll give the user a hint
      
    }
  }
  
  private boolean addCharacteristics(Set<String> set, String tc) {
    switch (tc) {
    case "boolean" : return addCharacteristicsForType(set);
    case "integer" : return addCharacteristicsForType(set, "has-range", "has-length");
    case "integer64" : return addCharacteristicsForType(set, "has-range", "has-length");
    case "decimal" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "base64Binary" : return addCharacteristicsForType(set, "has-size");
    case "instant" : return addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "string" : return addCharacteristicsForType(set, "has-length", "do-translations");
    case "uri" : return addCharacteristicsForType(set, "has-length", "can-bind");
    case "date" :return  addCharacteristicsForType(set, "has-range", "has-length");
    case "dateTime" : return addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "time" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "canonical" :return  addCharacteristicsForType(set, "has-target", "has-length");
    case "code" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "id" :return  addCharacteristicsForType(set, "has-length");
    case "markdown" :return  addCharacteristicsForType(set, "do-translations");
    case "oid" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "positiveInt" :return  addCharacteristicsForType(set, "has-range", "has-length");
    case "unsignedInt" :return  addCharacteristicsForType(set, "has-range", "has-length");
    case "url" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "uuid" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "xhtml" :return  addCharacteristicsForType(set);
    case "Address" :return  addCharacteristicsForType(set, "do-translations");
    case "Age" : return addCharacteristicsForType(set, "has-range", "is-continuous");
    case "Annotation" :return  addCharacteristicsForType(set);
    case "Attachment" :return  addCharacteristicsForType(set, "has-size", "do-translations");
    case "CodeableConcept" :return  addCharacteristicsForType(set, "can-bind", "do-translations");
    case "CodeableReference" : return addCharacteristicsForType(set, "has-target", "can-bind", "do-translations");
    case "Coding" : return addCharacteristicsForType(set, "can-bind", "do-translations");
    case "ContactPoint" :return  addCharacteristicsForType(set);
    case "Count" :return  addCharacteristicsForType(set, "has-range");
    case "Distance" :return  addCharacteristicsForType(set, "has-range", "is-continuous");
    case "Duration" : return addCharacteristicsForType(set, "has-range", "is-continuous");
    case "HumanName" :return  addCharacteristicsForType(set);
    case "Identifier" : return addCharacteristicsForType(set);
    case "Money" : return addCharacteristicsForType(set, "has-range", "is-continuous");
    case "Period" : return addCharacteristicsForType(set);
    case "Quantity" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "Range" :return  addCharacteristicsForType(set, "has-units");
    case "Ratio" :return  addCharacteristicsForType(set, "has-units");
    case "RatioRange" : return addCharacteristicsForType(set, "has-units");
    case "Reference" : return addCharacteristicsForType(set, "has-target");
    case "SampledData" :return  addCharacteristicsForType(set);
    case "Signature" : return addCharacteristicsForType(set);
    case "Timing" : return addCharacteristicsForType(set);
    case "ContactDetail" :return  addCharacteristicsForType(set);
    case "Contributor" :return  addCharacteristicsForType(set);
    case "DataRequirement" :return  addCharacteristicsForType(set);
    case "Expression" : return addCharacteristicsForType(set);
    case "ParameterDefinition" : return addCharacteristicsForType(set);
    case "RelatedArtifact" :return  addCharacteristicsForType(set);
    case "TriggerDefinition" :return  addCharacteristicsForType(set);
    case "UsageContext" :return  addCharacteristicsForType(set);
    case "Dosage" : return addCharacteristicsForType(set);
    case "Meta" :return  addCharacteristicsForType(set);
    case "Resource" :return  addCharacteristicsForType(set);
    case "Extension" :return  addCharacteristicsForType(set, "can-bind");
    case "Narrative" :return  addCharacteristicsForType(set);
    case "Element" :return  addCharacteristicsForType(set);
    case "BackboneElement" :return  addCharacteristicsForType(set);
    default:
      if (context.getResourceNames().contains(tc)) 
        return addCharacteristicsForType(set);
      else
        throw new Error("Unhandled data type in addCharacterstics: "+tc);
    }
  }


  private boolean addCharacteristicsForType(Set<String> set, String... cl) {
    for (String c : cl) {
      set.add(c);
    }
    return true;
  }

  private boolean isPrimitiveType(String fhirType) {
    StructureDefinition sd = context.fetchTypeDefinition(fhirType);
    return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
  }

  private String boundType(Set<String> typeCodes) {
    for (String tc : typeCodes) {
      if (Utilities.existsInList(tc, "code", "Coding", "CodeableConcept", "Quantity", "CodeableReference")) {
        return tc;
      }
    }
    return null;
  }

  private String bindableType(Set<String> typeCodes) {
    String ret = boundType(typeCodes);
    if (ret != null) {
      return ret;
    }
    for (String tc : typeCodes) {
      if (Utilities.existsInList(tc, "string", "uri", "CodeableConcept", "Quantity", "CodeableReference")) {
        return tc;
      }
      StructureDefinition sd = context.fetchTypeDefinition(tc);
      if (sd != null) {
        if (sd.hasExtension(ToolingExtensions.EXT_BINDING_METHOD)) {
          return tc;          
        }
      }
    }
    return null;
  }

  private void validateBinding(List<ValidationMessage> errors, Element binding, NodeStack stack, Set<String> typeCodes, boolean snapshot, String path) {
    rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || bindableType(typeCodes) != null, I18nConstants.SD_ED_BIND_NO_BINDABLE, path, typeCodes.toString());
    if (!snapshot) {
      Set<String> bindables = getListofBindableTypes(typeCodes);    
      hint(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), bindables.size() <= 1, I18nConstants.SD_ED_BIND_MULTIPLE_TYPES, path, typeCodes.toString());
    }
    
    if (binding.hasChild("valueSet")) {
      Element valueSet = binding.getNamedChild("valueSet");
      String ref = valueSet.hasPrimitiveValue() ? valueSet.primitiveValue() : valueSet.getNamedChildValue("reference");
      if (warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || ref != null, I18nConstants.SD_ED_SHOULD_BIND_WITH_VS, path)) {
        Resource vs = context.fetchResource(Resource.class, ref);
        
        // just because we can't resolve it directly doesn't mean that terminology server can't. Check with it
        
        if (warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs != null || serverSupportsValueSet(ref), I18nConstants.SD_ED_BIND_UNKNOWN_VS, path, ref)) {
          if (vs != null) {
            rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs instanceof ValueSet, I18nConstants.SD_ED_BIND_NOT_VS, path, ref, vs.fhirType());
          }
        }
      }
    } 
  }

  private Set<String> getListofBindableTypes(Set<String> types) {
    Set<String> res = new HashSet<>();
    for (String s : types) {
      if (Utilities.existsInList(s, "code", "string", "url", "uri", "Coding", "CodeableConcept", "Quantity", "CodeableReference")) {
        res.add(s);
      }
    }
    return res;
  }

  private boolean serverSupportsValueSet(String ref) {
    ValidationResult vr = context.validateCode(new ValidationOptions().checkValueSetOnly().setVsAsUrl().noClient(), new Coding("http://loinc.org", "5792-7", null), new ValueSet().setUrl(ref));
    return vr.getErrorClass() == null;
  }

  private void validateElementType(List<ValidationMessage> errors, Element type, NodeStack stack, StructureDefinition sd, String path) {
    String code = type.getNamedChildValue("code");
    if (code == null && path != null) {
      code = getTypeCodeFromSD(sd, path);
    }
    if (code != null) {
      List<Element> profiles = type.getChildrenByName("profile");
      if (VersionUtilities.isR2Ver(context.getVersion()) || VersionUtilities.isR2BVer(context.getVersion()) ) {
        for (Element profile : profiles) {
          validateProfileTypeOrTarget(errors, profile, code, stack.push(profile, -1, null, null), path);
        }
        
      } else {
        for (Element profile : profiles) {
          validateTypeProfile(errors, profile, code, stack.push(profile, -1, null, null), path);
        }
        profiles = type.getChildrenByName("targetProfile");
        for (Element profile : profiles) {
          validateTargetProfile(errors, profile, code, stack.push(profile, -1, null, null), path);
        }
      }
    }
  }

  private void validateProfileTypeOrTarget(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path) {
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (code.equals("Reference")) {
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd.getKind() == StructureDefinitionKind.RESOURCE, I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path);
        }
      }
    } else {
      if (sd == null ) {
        sd = getXverExt(errors, stack.getLiteralPath(), profile, p);
      }
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), isInstanceOf(t, code), I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path);
          if (t.getType().equals("Extension")) {
            boolean isModifierDefinition = checkIsModifierExtension(sd);
            boolean isModifierContext = path.endsWith(".modifierExtension");
            if (isModifierDefinition) {
              rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_NOT_MODIFIER, p, t, code, path);            
            } else {
              rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), !isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_IS_MODIFIER, p, t, code, path);
            }          
          }
        }
      }      
    }
  }

  private String getTypeCodeFromSD(StructureDefinition sd, String path) {
    ElementDefinition ed = null;
    for (ElementDefinition t : sd.getSnapshot().getElement()) {
      if (t.hasPath() && t.getPath().equals(path)) {
        if (ed == null) {
          ed = t;
        } else {
          return null; // more than one match, we don't know which is which
        }
      }
    }
    return ed != null && ed.getType().size() == 1 ? ed.getTypeFirstRep().getCode() : null;
  }

  private void validateTypeProfile(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path) {
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (sd == null ) {
      sd = getXverExt(errors, stack.getLiteralPath(), profile, p);
    }
    if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
      StructureDefinition t = determineBaseType(sd);
      if (t == null) {
        rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
      } else if (!isInstanceOf(t, code)) {
        rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path);
      } else {
        if (t.getType().equals("Extension")) {
          boolean isModifierDefinition = checkIsModifierExtension(sd);
          boolean isModifierContext = path.endsWith(".modifierExtension");
          if (isModifierDefinition) {
            rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_NOT_MODIFIER, p, t, code, path);            
          } else {
            rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), !isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_IS_MODIFIER, p, t, code, path);
          }          
        }
      }
    }
  }

  private boolean checkIsModifierExtension(StructureDefinition t) {
    return t.getSnapshot().getElementFirstRep().getIsModifier();
  }

  private void validateTargetProfile(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path) {
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (code.equals("Reference") || code.equals("CodeableReference")) {
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd.getKind() == StructureDefinitionKind.RESOURCE, I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Resource");
        }
      }
    } else if (code.equals("canonical")) {
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else if (!VersionUtilities.isR5Ver(context.getVersion())) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(t.getType()) || "Resource".equals(t.getType()), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Canonical Resource");
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(t.getType()), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Canonical Resource");
        }  
      }
    } else {
      rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_NO_TARGET_PROFILE, code);
    }
  }

  private boolean isInstanceOf(StructureDefinition sd, String code) {
    while (sd != null) {
      if (sd.getType().equals(code)) {
        return true;
      }
      if (sd.getUrl().equals(code)) {
        return true;
      }
      sd = sd.hasBaseDefinition() ? context.fetchResource(StructureDefinition.class, sd.getBaseDefinition()) : null;
      if (!(VersionUtilities.isR2Ver(context.getVersion()) || VersionUtilities.isR2BVer(context.getVersion())) && sd != null && !sd.getAbstract() && sd.getKind() != StructureDefinitionKind.LOGICAL) {
        sd = null;
      }
    }
    
    return false;
  }

  private StructureDefinition determineBaseType(StructureDefinition sd) {
    while (sd != null && sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
      sd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    }
    return sd;
  }

  private boolean hasMustSupportExtension(Element type) {
    if ("true".equals(getExtensionValue(type, ToolingExtensions.EXT_MUST_SUPPORT))) {
      return true;
    }
    List<Element> profiles = type.getChildrenByName("profile");
    for (Element profile : profiles) {
      if ("true".equals(getExtensionValue(profile, ToolingExtensions.EXT_MUST_SUPPORT))) {
        return true;
      }
    }
    profiles = type.getChildrenByName("targetProfile");
    for (Element profile : profiles) {
      if ("true".equals(getExtensionValue(profile, ToolingExtensions.EXT_MUST_SUPPORT))) {
        return true;
      }
    }
    return false;
  }

  private String getExtensionValue(Element element, String url) {
    List<Element> extensions = element.getChildrenByName("extension");
    for (Element extension : extensions) {
      if (url.equals(extension.getNamedChildValue("url"))) {
        return extension.getNamedChildValue("value");
      }
    }
    return null;
  }

  private StructureDefinition loadAsSD(Element src) throws FHIRException, IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    Manager.compose(context, src, bs, FhirFormat.JSON, OutputStyle.NORMAL, null);
    if (VersionUtilities.isR2Ver(context.getVersion())) {
      org.hl7.fhir.dstu2.model.Resource r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertorFactory_10_50.convertResource(r2);
    }
    if (VersionUtilities.isR2BVer(context.getVersion())) {
      org.hl7.fhir.dstu2016may.model.Resource r2b = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertorFactory_14_50.convertResource(r2b);
    }
    if (VersionUtilities.isR3Ver(context.getVersion())) {
      org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertorFactory_30_50.convertResource(r3);
    }
    if (VersionUtilities.isR4Ver(context.getVersion())) {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertorFactory_40_50.convertResource(r4);
    }
    return (StructureDefinition) new org.hl7.fhir.r5.formats.JsonParser().parse(bs.toByteArray());
  }

}
