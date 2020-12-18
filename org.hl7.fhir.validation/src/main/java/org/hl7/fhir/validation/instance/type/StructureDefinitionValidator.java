package org.hl7.fhir.validation.instance.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
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

  public StructureDefinitionValidator(IWorkerContext context, TimeTracker timeTracker, FHIRPathEngine fpe, boolean wantCheckSnapshotUnchanged, XVerExtensionManager xverManager) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.fpe = fpe;
    this.timeTracker = timeTracker;
    this.wantCheckSnapshotUnchanged = wantCheckSnapshotUnchanged;
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
            pu.generateSnapshot(base, sd, sd.getUrl(), "http://hl7.org/fhir", sd.getName());
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
    for (Element type : types) {
      if (hasMustSupportExtension(type)) {
        typeMustSupport = true;
      }
      typeCodes.add(type.getChildValue("code"));
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
      Element binding = element.getNamedChild("binding");
      validateBinding(errors, binding, stack.push(binding, -1, null, null), typeCodes, snapshot, element.getNamedChildValue("path"));
    } else {
      // this is a good idea but there's plenty of cases where the rule isn't met; maybe one day it's worth investing the time to exclude these cases and bring this rule back
//      String bt = boundType(typeCodes);
//      hint(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || bt == null, I18nConstants.SD_ED_SHOULD_BIND, element.getNamedChildValue("path"), bt);              
    }
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
    }
    return null;
  }

  private void validateBinding(List<ValidationMessage> errors, Element binding, NodeStack stack, Set<String> typeCodes, boolean snapshot, String path) {
    rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || bindableType(typeCodes) != null, I18nConstants.SD_ED_BIND_NO_BINDABLE, path, typeCodes.toString());
    if (binding.hasChild("valueSet")) {
      Element valueSet = binding.getNamedChild("valueSet");
      String ref = valueSet.hasPrimitiveValue() ? valueSet.primitiveValue() : valueSet.getNamedChildValue("reference");
      if (warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || ref != null, I18nConstants.SD_ED_SHOULD_BIND_WITH_VS, path)) {
        Resource vs = context.fetchResource(Resource.class, ref);
        if (warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs != null, I18nConstants.SD_ED_BIND_UNKNOWN_VS, path, ref)) {
          rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs instanceof ValueSet, I18nConstants.SD_ED_BIND_NOT_VS, path, ref, vs.fhirType());
        }
      }
    } 
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
        String t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), code.equals(t), I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd.getKind() == StructureDefinitionKind.RESOURCE, I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path);
        }
      }
    } else {
      if (sd == null ) {
        sd = getXverExt(errors, stack.getLiteralPath(), profile, p);
      }
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        String t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), code.equals(t), I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), isInstanceOf(t, code), I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path);
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
      String t = determineBaseType(sd);
      if (t == null) {
        rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), code.equals(t), I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
      } else {
        rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), isInstanceOf(t, code), I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path);
      }
    }
  }

  private void validateTargetProfile(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path) {
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (code.equals("Reference")) {
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        String t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), code.equals(t), I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd.getKind() == StructureDefinitionKind.RESOURCE, I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Resource");
        }
      }
    } else if (code.equals("canonical")) {
      if (warning(errors, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        String t = determineBaseType(sd);
        if (t == null) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), code.equals(t), I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p);
        } else if (!VersionUtilities.isR5Ver(context.getVersion())) {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(t) || "Resource".equals(t), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Canonical Resource");
        } else {
          rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(t), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Canonical Resource");
        }  
      }
    } else {
      rule(errors, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_NO_TARGET_PROFILE, code);
    }
  }

  private boolean isInstanceOf(String t, String code) {
    StructureDefinition sd = context.fetchTypeDefinition(t);
    while (sd != null) {
      if (sd.getType().equals(code)) {
        return true;
      }
      sd = sd.hasBaseDefinition() ? context.fetchResource(StructureDefinition.class, sd.getBaseDefinition()) : null;
      if (!(VersionUtilities.isR2Ver(context.getVersion()) || VersionUtilities.isR2BVer(context.getVersion())) && sd != null && !sd.getAbstract()) {
        sd = null;
      }
    }
    
    return false;
  }

  private String determineBaseType(StructureDefinition sd) {
    while (sd != null && !sd.hasType() && sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
      sd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    }
    return sd == null ? null : sd.getType();
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
      return (StructureDefinition) VersionConvertor_10_50.convertResource(r2);
    }
    if (VersionUtilities.isR2BVer(context.getVersion())) {
      org.hl7.fhir.dstu2016may.model.Resource r2b = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertor_14_50.convertResource(r2b);
    }
    if (VersionUtilities.isR3Ver(context.getVersion())) {
      org.hl7.fhir.dstu3.model.Resource r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertor_30_50.convertResource(r3, false);
    }
    if (VersionUtilities.isR4Ver(context.getVersion())) {
      org.hl7.fhir.r4.model.Resource r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(bs.toByteArray());
      return (StructureDefinition) VersionConvertor_40_50.convertResource(r4);
    }
    return (StructureDefinition) new org.hl7.fhir.r5.formats.JsonParser().parse(bs.toByteArray());
  }

}
