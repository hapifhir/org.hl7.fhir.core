package org.hl7.fhir.validation.instance.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.extensions.ExtensionConstants;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.ExpressionNode;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
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

  public StructureDefinitionValidator(BaseValidator parent, FHIRPathEngine fpe, boolean wantCheckSnapshotUnchanged) {
    super(parent);
    this.fpe = fpe;
    this.wantCheckSnapshotUnchanged = wantCheckSnapshotUnchanged;
  }
  
  public boolean validateStructureDefinition(List<ValidationMessage> errors, Element src, NodeStack stack)  {
    boolean ok = true;
    StructureDefinition sd = null;
    String typeName = null;
    try {
      String url = src.getNamedChildValue("url");
      
      sd = loadAsSD(src);
      ok = checkExtensionContext(errors, src, stack) && ok;
      
      List<ElementDefinition> snapshot = sd.getSnapshot().getElement();
      sd.setSnapshot(null);
      typeName = sd.getTypeName();
      StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      if (warning(errors, NO_RULE_DATE, IssueType.NOTFOUND, stack.getLiteralPath(), base != null, I18nConstants.UNABLE_TO_FIND_BASE__FOR_, sd.getBaseDefinition(), "StructureDefinition, so can't check the differential")) {
        if (rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, stack.getLiteralPath(), sd.hasDerivation(), I18nConstants.SD_MUST_HAVE_DERIVATION, sd.getUrl())) {
          boolean bok = base.getAbstract() || sd.hasKind() && sd.getKind() == base.getKind();
          ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), bok, I18nConstants.SD_CONSTRAINED_KIND_NO_MATCH, sd.getKind().toCode(), base.getKind().toCode(), base.getType(), base.getUrl()) && ok;
          if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
            ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), sd.hasType() && sd.getType().equals(base.getType()), I18nConstants.SD_CONSTRAINED_TYPE_NO_MATCH, sd.getType(), base.getType()) && ok;
            if (!src.hasUserData("profileutils.snapshot.errors")) { // if it does, we've already logged these errors elsewhere
              List<ValidationMessage> msgs = new ArrayList<>();
              ProfileUtilities pu = new ProfileUtilities(context, msgs, null);
              pu.setForPublication(forPublication);
              pu.setXver(xverManager);
              pu.setNewSlicingProcessing(!sd.hasFhirVersion() || VersionUtilities.isR4Plus(sd.getFhirVersion().toCode()));
              pu.generateSnapshot(base, sd, sd.getUrl(), "http://hl7.org/fhir/R4/", sd.getName());
              if (msgs.size() > 0) {
                for (ValidationMessage msg : msgs) {
                  // we need to set the location for the context 
                  String loc = msg.getLocation();
                  if (loc.startsWith("StructureDefinition.")) {
                    msg.setLocation(stack.getLiteralPath()+loc.substring(loc.indexOf(".")));
                  } else {
                    msg.setLocation(stack.getLiteralPath());
                  }
                  errors.add(msg);
                  ok = (!msg.isError()) && ok;
                }
              }
              if (!snapshot.isEmpty() && wantCheckSnapshotUnchanged) {
                int was = snapshot.size();
                int is = sd.getSnapshot().getElement().size();
                ok = rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, stack.getLiteralPath(), was == is, I18nConstants.SNAPSHOT_EXISTING_PROBLEM, was, is) && ok;
              }
            }
          } else {
            ok = rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, stack.getLiteralPath(), sd.hasType() && !sd.getType().equals(base.getType()), I18nConstants.SD_SPECIALIZED_TYPE_MATCHES, sd.getType(), base.getType()) && ok;
          }
        } else {
          ok = false;
        }
        if ("constraint".equals(src.getChildValue("derivation"))) {
          ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), base.getKindElement().primitiveValue().equals(src.getChildValue("kind")), 
              I18nConstants.SD_DERIVATION_KIND_MISMATCH, base.getKindElement().primitiveValue(), src.getChildValue("kind")) && ok;
        }
      }

      List<Element> differentials = src.getChildrenByName("differential");
      List<Element> snapshots = src.getChildrenByName("snapshot");
      boolean logical = "logical".equals(src.getNamedChildValue("kind"));
      boolean constraint = "constraint".equals(src.getNamedChildValue("derivation"));
      for (Element differential : differentials) {
        ok = validateElementList(errors, differential, stack.push(differential, -1, null, null), false, snapshots.size() > 0, sd, typeName, logical, constraint, src.getNamedChildValue("type"), src.getNamedChildValue("url"), src.getNamedChildValue("type"), base) && ok;
      }
      for (Element snapshotE : snapshots) {
        ok = validateElementList(errors, snapshotE, stack.push(snapshotE, -1, null, null), true, true, sd, typeName, logical, constraint, src.getNamedChildValue("type"), src.getNamedChildValue("url"), src.getNamedChildValue("type"), base) && ok;
      }
      
      // obligation profile support
      if (src.hasExtension(ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG)) {
        Element ext = src.getExtension(ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG);
        Element value = ext.getNamedChild("value");
        if (value != null && "true".equals(value.primitiveValue())) {
          if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), "constraint".equals(src.getNamedChildValue("derivation")), I18nConstants.SD_OBGLIGATION_PROFILE_DERIVATION)) {
            if (warning(errors, "2023-05-27", IssueType.NOTFOUND, stack.getLiteralPath(), base != null, I18nConstants.SD_OBGLIGATION_PROFILE_UKNOWN, src.getNamedChildValue("baseDefinition"))) {
              for (Element differential : differentials) {
                ok = validateObligationProfile(errors, differential, stack.push(differential, -1, null, null), base) && ok;
              }
            }
          } else {
            ok = false;
          }
        }
      }
      List<Element> extensions = src.getChildren("extension");
      int c = 0;
      for (Element extension : extensions) {
        if (ToolingExtensions.EXT_OBLIGATION_INHERITS.equals(extension.getNamedChildValue("url"))) {
          ok = validateInheritsObligationProfile(errors, extension, stack.push(extension, c, null, null), src) && ok;
        }
        c++;
      }
      
      // if this is defining an extension, make sure that the extension fixed value matches the URL
      String type = src.getNamedChildValue("type");
      if ("Extension".equals(type)) {
        String baseD = src.getNamedChildValue("baseDefinition");
        if ("http://hl7.org/fhir/StructureDefinition/Extension".equals(baseD) && url != null) {
          String fixedUrl = getFixedValue(src);
          if (rule(errors, "2023-08-05", IssueType.INVALID, stack.getLiteralPath(), fixedUrl != null, I18nConstants.SD_EXTENSION_URL_MISSING, url)) {
            ok = rule(errors, "2023-08-05", IssueType.INVALID, stack.getLiteralPath(), url.equals(fixedUrl), I18nConstants.SD_EXTENSION_URL_MISMATCH, url, fixedUrl) && ok;
          } else {
            ok = false;
          }
        }
      }
    } catch (Exception e) {
      rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.ERROR_GENERATING_SNAPSHOT, e.getMessage());
      ok = false;
    }
    return ok;
  }
  

  private String getFixedValue(Element src) {
    Element diff = src.getNamedChild("differential");
    if (diff != null) {
      for (Element ed : diff.getChildrenByName("element")) {
        String path = ed.getNamedChildValue("path");
        if ("Extension.url".equals(path)) {
          return ed.getNamedChildValue("fixed");
        }
      }
    }
    return null;
  }

  private boolean validateInheritsObligationProfile(List<ValidationMessage> errors, Element extension, NodeStack stack, Element src) {
    String tgt = extension.getNamedChildValue("value");
    if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), tgt != null, 
        I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_NO_TARGET)) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, tgt);
      if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), src != null, 
          I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_TARGET_NOT_FOUND, tgt))  {
        if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), ToolingExtensions.readBoolExtension(sd, ToolingExtensions.EXT_OBLIGATION_PROFILE_FLAG), 
            I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_NOT_RIGHT_TYPE, tgt)) {
          String base = src.getNamedChildValue("baseDefinition");
          if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), base != null && base.equals(sd.getBaseDefinition()), 
              I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_NOT_RIGHT_BASE, tgt, sd.getBaseDefinition(), base)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean validateObligationProfile(List<ValidationMessage> errors, Element elementList, NodeStack stack, StructureDefinition base) {
    boolean ok = true;
    List<Element> elements = elementList.getChildrenByName("element");
    int cc = 0;
    for (Element element : elements) {
      ok = validateObligationProfileElement(errors, element, stack.push(element, cc, null, null), base) && ok;
      cc++;
    }    
    return ok;
  }

  private boolean validateObligationProfileElement(List<ValidationMessage> errors, Element element, NodeStack push, StructureDefinition base) {
    // rules: it must exist in the base snapshot 
    // it must only add must-support, obligations and extra bindings
    String id = element.getNamedChildValue("id");
    ElementDefinition bd = base.getSnapshot().getElementById(id);
    if (rule(errors, "2023-05-27", IssueType.INVALID, push.getLiteralPath(), bd != null, I18nConstants.SD_OBGLIGATION_PROFILE_UNMATCHED, id, base.getVersionedUrl())) {
      boolean ok = true;
      String name = null;
      int c = 0;
      for (Element child : element.getChildren()) {
        if (child.getName().equals(name)) {
          c++;
        } else {
          name = child.getName();
          c = 0;
        }
        NodeStack stack = push.push(child, c, null, null);
        if (child.getName().equals("extension")) {
          String url = child.getNamedChildValue("url");
          if (Utilities.existsInList(url, ToolingExtensions.EXT_OBLIGATION_CORE, ToolingExtensions.EXT_OBLIGATION_TOOLS)) {
            // this is ok, and it doesn't matter what's in the obligation
          } else {
            ok = false;
            rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), false, 
                I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL, id, child.getName()+"#"+url);
          }
        } else if (child.getName().equals("mustSupport")) {
          // this is ok, and there's nothing to check 
        } else if (child.getName().equals("id")) {
          // this is ok (it must have this), and there's nothing to check 
        } else if (child.getName().equals("binding")) {
          if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), bd.hasBinding(), 
                I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL_BINDING, id)) {
            ok = validateObligationProfileElementBinding(errors, child, stack, id, bd)  && ok;
          } else {
            ok = false;
          }
        } else if (child.getName().equals("path")) {
          ok = rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), child.primitiveValue().equals(bd.getPath()), 
              I18nConstants.SD_OBGLIGATION_PROFILE_PATH_WRONG, id, child.primitiveValue(), bd.getPath()) && ok;
        } else {
          ok = false;
          rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), false, 
              I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL, id, child.getName());
        }
      }
      return ok;
    } else {
      return false;
    }
  }
  
  private boolean validateObligationProfileElementBinding(List<ValidationMessage> errors, Element element, NodeStack nstack, String id, ElementDefinition bd) {
    // rules can only have additional bindings 
    boolean ok = true;
    String name = null;
    int c = 0;
    for (Element child : element.getChildren()) {
      if (child.getName().equals(name)) {
        c++;
      } else {
        name = child.getName();
        c = 0;
      }
      NodeStack stack = nstack.push(child, c, null, null);
      if (child.getName().equals("extension")) {
        String url = child.getNamedChildValue("url");
        if ("http://hl7.org/fhir/tools/StructureDefinition/additional-binding".equals(url) && !VersionUtilities.isR5Plus(context.getVersion())) {
          Element purpose = child.getExtension("purpose");
          if (purpose != null) { // should be an error elsewhere
            String code = purpose.getNamedChildValue("value");

            ok = rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), !Utilities.existsInList(code, "maximum", "required", "extensible"), 
                I18nConstants.SD_OBGLIGATION_PROFILE_INVALID_BINDING_CODE, id, code) && ok;
          }
        } else {
          ok = false;
          rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), false, 
              I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL, id, child.getName()+"#"+url);
        }
      } else if (child.getName().equals("additional") && VersionUtilities.isR5Plus(context.getVersion())) {
        String code = child.getNamedChildValue("purpose");
        ok = rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), !Utilities.existsInList(code, "maximum", "required", "extensible"), 
            I18nConstants.SD_OBGLIGATION_PROFILE_INVALID_BINDING_CODE, id, code) && ok;
      } else if (child.getName().equals("strength")) {
        // this has to be repeated, and has to be the same as the derivation
        String strengthBase = bd.getBinding().getStrengthElement().asStringValue();
        String strengthDerived = child.primitiveValue();
        ok = rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), strengthBase != null && strengthBase.equals(strengthDerived), 
            I18nConstants.SD_OBGLIGATION_PROFILE_INVALID_BINDING_STRENGTH, id, strengthDerived, strengthBase) && ok;        
      } else {
        ok = false;
        rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), false, 
            I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL_ON_BINDING, id, child.getName());
      }
    }
    return ok;
  }

  private boolean checkExtensionContext(List<ValidationMessage> errors, Element src, NodeStack stack) {
    boolean ok = true;
    String type = src.getNamedChildValue("type");
    List<Element> eclist = src.getChildren("context");
    List<Element> cilist = src.getChildren("contextInvariant");
    int i = 0;
    for (Element ec : eclist) {
      NodeStack n = stack.push(ec, i, null, null);
      if ("Extension".equals(type)) {
        String ct = null;
        String cv = null; 
        if (VersionUtilities.isR4Plus(context.getVersion())) {
          ct = ec.getNamedChildValue("type");
          cv = ec.getNamedChildValue("expression");          
        } else {
          ct = src.getNamedChildValue("contextType"); /// todo - this doesn't have the right value
          cv = ec.primitiveValue();
        }
        if ("element".equals(ct) && "Element".equals(cv)) {
          warning(errors, "2023-04-23", IssueType.BUSINESSRULE, n.getLiteralPath(), false, I18nConstants.SD_CONTEXT_SHOULD_NOT_BE_ELEMENT, cv);
        }          
      } else {
        ok = rule(errors, "2023-04-23", IssueType.INVALID, n.getLiteralPath(), false, I18nConstants.SD_NO_CONTEXT_WHEN_NOT_EXTENSION, type) && ok;
      }
    }
    i = 0;
    for (Element ci : cilist) {
      NodeStack n = stack.push(ci, i, null, null);
      if ("Extension".equals(type)) {
          
      } else {
        ok = rule(errors, "2023-04-23", IssueType.INVALID, n.getLiteralPath(), false, I18nConstants.SD_NO_CONTEXT_INV_WHEN_NOT_EXTENSION, type) && ok;
      }
    }
    return ok;
  }

  private boolean validateElementList(List<ValidationMessage> errors, Element elementList, NodeStack stack, boolean snapshot, boolean hasSnapshot, StructureDefinition sd, String typeName, boolean logical, boolean constraint, String rootPath, String profileUrl, String profileType, StructureDefinition base) {
    Map<String, String> invariantMap = new HashMap<>();
    boolean ok = true;
    List<Element> elements = elementList.getChildrenByName("element");
    int cc = 0;
    for (Element element : elements) {
      ok = validateElementDefinition(errors, elements, element, stack.push(element, cc, null, null), snapshot, hasSnapshot, sd, typeName, logical, constraint, invariantMap, rootPath, profileUrl, profileType, base) && ok;
      cc++;
    }    
    return ok;
  }

  private boolean validateElementDefinition(List<ValidationMessage> errors, List<Element> elements, Element element, NodeStack stack, boolean snapshot, boolean hasSnapshot, StructureDefinition sd, String typeName, boolean logical, boolean constraint, Map<String, String> invariantMap, String rootPath, String profileUrl, String profileType, StructureDefinition base) {
    boolean ok = true;
    boolean typeMustSupport = false;
    String path = element.getNamedChildValue("path");
    ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), typeName == null || path == null || path.equals(typeName) || path.startsWith(typeName+"."), I18nConstants.SD_PATH_TYPE_MISMATCH, typeName, path) && ok;
    if (!snapshot) {
      ok = rule(errors, "2023-01-17", IssueType.INVALID, stack.getLiteralPath(), path.contains(".") || !element.hasChild("slicing"), I18nConstants.SD_NO_SLICING_ON_ROOT, path) && ok;
    }
    ok = rule(errors, "2023-05-22", IssueType.NOTFOUND, stack.getLiteralPath(), snapshot || !constraint || !element.hasChild("meaningWhenMissing") || meaningWhenMissingAllowed(element), I18nConstants.SD_ELEMENT_NOT_IN_CONSTRAINT, "meaningWhenMissing", path) && ok;
    
    List<Element> types = element.getChildrenByName("type");
    Set<String> typeCodes = new HashSet<>();
    Set<String> characteristics = new HashSet<>();
    if (!path.contains(".")) {
      typeCodes.add(path); // root is type
      addCharacteristics(characteristics, path);
    }
    
    for (Element type : types) {
      if (hasMustSupportExtension(type)) {
        typeMustSupport = true;
      }
      String tc = type.getChildValue("code");
      if (type.hasExtension(ToolingExtensions.EXT_FHIR_TYPE)) {
        Base tcv = type.getExtensionValue(ToolingExtensions.EXT_FHIR_TYPE);
        if (tcv != null) {
          tc = tcv.primitiveValue();
        }
      }
      if (Utilities.noString(tc) && type.hasChild("code")) {
        if (VersionUtilities.isR4Plus(context.getVersion())) {
          ok = rule(errors, "2023-03-16", IssueType.INVALID, stack.getLiteralPath(), false, I18nConstants.SD_NO_TYPE_CODE_ON_CODE, path, sd.getId()) && ok;
        }
      }
      if (!Utilities.noString(tc)) {
        typeCodes.add(tc);
        Set<String> tcharacteristics = new HashSet<>();
        StructureDefinition tsd = context.fetchTypeDefinition(tc);
        if (tsd != null && tsd.hasExtension(ToolingExtensions.EXT_TYPE_CHARACTERISTICS)) {
          for (Extension ext : tsd.getExtensionsByUrl(ToolingExtensions.EXT_TYPE_CHARACTERISTICS)) {
            tcharacteristics.add(ext.getValue().primitiveValue());
          }
        } else {
          // nothing specified, so infer from known types
          addCharacteristics(tcharacteristics, tc);
        }
        characteristics.addAll(tcharacteristics);
        if (type.hasChildren("targetProfile")) {
          ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), tcharacteristics.contains("has-target") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "targetProfile", tc) && ok;
        }
        // check the stated profile - must be a constraint on the type 
        if (snapshot || sd != null) {
          ok = validateElementType(errors, type, stack.push(type, -1, null, null), sd, path, logical) && ok;
        }
      }
    }
    if (typeMustSupport) {
      if (snapshot) {
        ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), "true".equals(element.getChildValue("mustSupport")), I18nConstants.SD_NESTED_MUST_SUPPORT_SNAPSHOT, path) && ok;
      } else {
        hint(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), hasSnapshot || "true".equals(element.getChildValue("mustSupport")), I18nConstants.SD_NESTED_MUST_SUPPORT_DIFF, path);        
      }
    }
    if (element.hasChild("binding")) {
      if (!typeCodes.isEmpty()) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("can-bind") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Binding", typeCodes) && ok;
      }
      Element binding = element.getNamedChild("binding");
      ok = validateBinding(errors, binding, stack.push(binding, -1, null, null), typeCodes, snapshot, path) && ok;
    } else {
      // this is a good idea but there's plenty of cases where the rule isn't met; maybe one day it's worth investing the time to exclude these cases and bring this rule back
//      String bt = boundType(typeCodes);
//      hint(errors, UNKNOWN_DATE_TIME, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || bt == null, I18nConstants.SD_ED_SHOULD_BIND, element.getNamedChildValue("path"), bt);              
    }
    if (!typeCodes.isEmpty()) {
      if (element.hasChild("maxLength")) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-length") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MaxLength", typeCodes) && ok;      
      }
      if (element.hasExtension(ToolingExtensions.EXT_MIN_LENGTH)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-length") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MinLength Extension", typeCodes) && ok;      
      }
      if (element.hasChild("minValue")) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-range") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MinValue", typeCodes) && ok;      
      }
      if (element.hasChild("maxValue")) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-range") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MaxValue", typeCodes) && ok;      
      }
      if (element.hasExtension(ToolingExtensions.EXT_MAX_DECIMALS)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("is-continuous") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Max Decimal Places Extension", typeCodes) && ok;      
      }
      if (element.hasExtension(ToolingExtensions.EXT_MAX_SIZE)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-size") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Max Size", typeCodes) && ok;      
      }
    }
    // in a snapshot, we validate that fixedValue, pattern, and defaultValue, if present, are all of the right type
    if (snapshot && (element.getIdBase() != null) && (element.getIdBase().contains("."))) {
      if (rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), !typeCodes.isEmpty() || element.hasChild("contentReference"), I18nConstants.SD_NO_TYPES_OR_CONTENTREF, element.getIdBase())) {     
        // if we see fixed[x] or pattern[x] applied to a repeating element, we'll give the user a hint
        boolean repeating = !Utilities.existsInList(element.getChildValue("max"), "0", "1");
        
        Element v = element.getNamedChild("defaultValue");
        if (v != null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "defaultValue", v.fhirType(), typeCodes) && ok;
        }
        v = element.getNamedChild("fixed");
        if (v != null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "fixed", v.fhirType(), typeCodes) && ok;
          hint(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_HINT, element.getIdBase(), "fixed");
          if (context.isPrimitiveType(v.fhirType())) {
            warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_WARNING_DOTNET, element.getIdBase(), "fixed");
          } else {
            warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), false, I18nConstants.SD_VALUE_COMPLEX_FIXED, v.fhirType());            
          }
        }
        v = element.getNamedChild("pattern");
        if (v != null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "pattern", v.fhirType(), typeCodes) && ok;
          hint(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_HINT, element.getIdBase(), "pattern");
          if (context.isPrimitiveType(v.fhirType())) {
            warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_WARNING_DOTNET, element.getIdBase(), "pattern");
          }
        }
      } else {
        ok = false;
      }
      // if we see fixed[x] or pattern[x] applied to a repeating element, we'll give the user a hint
    }
    List<Element> constraints = element.getChildrenByName("constraint");
    int cc = 0;
    for (Element invariant : constraints) {
      ok = validateElementDefinitionInvariant(errors, invariant, stack.push(invariant, cc, null, null), invariantMap, elements, element, element.getNamedChildValue("path"), rootPath, profileUrl, profileType, snapshot, base) && ok;
      cc++;
    }    
    return ok;
  }
  
  private boolean validateElementDefinitionInvariant(List<ValidationMessage> errors, Element invariant, NodeStack stack, Map<String, String> invariantMap, List<Element> elements, Element element, 
      String path, String rootPath, String profileUrl, String profileType, boolean snapshot, StructureDefinition base) {
    boolean ok = true;
    String key = invariant.getNamedChildValue("key"); 
    String expression = invariant.getNamedChildValue("expression");
    String source = invariant.getNamedChildValue("source");
    if (warning(errors, "2023-06-19", IssueType.INFORMATIONAL, stack, !Utilities.noString(key), I18nConstants.ED_INVARIANT_NO_KEY)) {
      if (hint(errors, "2023-06-19", IssueType.INFORMATIONAL, stack, !Utilities.noString(expression) || VersionUtilities.isR5Plus(context.getVersion()), I18nConstants.ED_INVARIANT_NO_EXPRESSION, key)) { // not for R5 - there's an invariant
        if (snapshot) {// we just don't have enough information to figure out the context in a differential
          if (!Utilities.noString(expression)) {
            if (invariantMap.containsKey(key)) {
              // it's legal - and common - for a list of elements to contain the same invariant more than once, but it's not valid if it's not always the same 
              ok = rule(errors, "2023-06-19", IssueType.INVALID, stack, expression.equals(invariantMap.get(key)) || "ele-1".equals(key), I18nConstants.ED_INVARIANT_EXPRESSION_CONFLICT, key, expression, invariantMap.get(key));
            } else {
              invariantMap.put(key, expression);
            }
            if (Utilities.noString(source) || (source.equals(profileUrl))) { // no need to revalidate FHIRPath from elsewhere 
              try {
                // we have to figure out the context, and we might be in type slicing. 
                String exp = expression;
                Element te = element;
                List<String> types = getTypesForElement(elements, te, profileType);
                while (types.size() == 0 && te != null) {
                  Element oldte = te;
                  te = getParent(elements, te);
                  if (te != null) {
                    exp = tail(oldte, te)+".all("+exp+")";
                    types = getTypesForElement(elements, te, profileType);
                  }
                }
                if (types.size() == 0) {
                  // we got to the root before finding anything typed
                  types.add(elements.get(0).getNamedChildValue("path"));
                }
                List<String> warnings = new ArrayList<>();
                if (Utilities.existsInList(rootPath, context.getResourceNames())) {
                  fpe.checkOnTypes(invariant, rootPath, types, fpe.parse(exp), warnings);
                } else {
                  fpe.checkOnTypes(invariant, "DomainResource", types, fpe.parse(exp), warnings);
                }
                for (String s : warnings) {
                  warning(errors, "2023-07-27", IssueType.BUSINESSRULE, stack, false, key+": "+s);
                }
              } catch (Exception e) {
                if (debug) {
                  e.printStackTrace();
                }
                ok = rule(errors, "2023-06-19", IssueType.INVALID, stack, false, I18nConstants.ED_INVARIANT_EXPRESSION_ERROR, key, expression, e.getMessage()) && ok;
              }         
            }        
          }
        } else {          
          ok = rule(errors, "2023-07-27", IssueType.INVALID, stack, source == null || source.equals(profileUrl), I18nConstants.ED_INVARIANT_DIFF_NO_SOURCE, key, source) &&
              rule(errors, "2023-07-27", IssueType.INVALID, stack, !haseHasInvariant(base, key), I18nConstants.ED_INVARIANT_KEY_ALREADY_USED, key, base.getVersionedUrl());
          
        }
      }
    }
    return ok;
  }

  private boolean haseHasInvariant(StructureDefinition base, String key) {
    for (ElementDefinition ed : base.getSnapshot().getElement()) {
      for (ElementDefinitionConstraintComponent inv : ed.getConstraint()) {
        if (key.equals(inv.getKey())) {
          return true;
        }
      }
    }
    return false;
  }

  private String tail(Element te, Element newte) {
    String p = te.getNamedChildValue("path");
    String pn = newte.getNamedChildValue("path");
    return p.substring(pn.length()+1);
  }

  private Element getParent(List<Element> elements, Element te) {
   int i = elements.indexOf(te) - 1;
   String path = te.getNamedChildValue("path");
   while (i >= 0) {
     String p = elements.get(i).getNamedChildValue("path");
     if (path.startsWith(p+".")) {
       return elements.get(i);
     }
     i--;
   }
   return null;
  }

  private List<String> getTypesForElement(List<Element> elements, Element element, String profileType) {
    List<String> types = new ArrayList<>();
    if (element.hasChild("path") && !element.getNamedChildValue("path").contains(".")) {
      types.add(element.getNamedChildValue("path"));
    } else {
      for (Element tr : element.getChildrenByName("type")) {
        String t = tr.getNamedChildValue("code");
        if (t.startsWith("http://hl7.org/fhirpath")) {
          t = tr.getExtensionValue("http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type").primitiveValue();
        }
        if (t != null) {
          if (isAbstractType(t) && hasChildren(element, elements) ) {
            if (!Utilities.isAbsoluteUrl(profileType)) {
              types.add(element.getNamedChildValue("path"));
            } else {
              types.add(profileType+"#"+element.getNamedChildValue("path"));              
            }
          } else {
            types.add(t);
          }
        }
      }
    }
    return types;
  }

  private boolean hasChildren(Element element, List<Element> elements) {
    int i = elements.indexOf(element);
    String path = element.getNamedChildValue("path")+".";
    while (i < elements.size()) {
      String p = elements.get(i).getNamedChildValue("path")+".";
      if (p.startsWith(path)) {
        return true;
      }
    }
    return false;
  }

  private boolean isAbstractType(String t) {
    StructureDefinition sd = context.fetchTypeDefinition(t);
    return sd != null && sd.getAbstract();
  }

  private boolean meaningWhenMissingAllowed(Element element) {
    // allowed to use meaningWhenMissing on the root of an element to say what it means when the extension
    // is not present.
    String path = element.getNamedChildValue("path");
    return path != null && ("Extension".equals(path) || (path.endsWith(".extension")));
  }

  private boolean addCharacteristics(Set<String> set, String tc) {
    switch (tc) {
    case "boolean" : return addCharacteristicsForType(set);
    case "integer" : return addCharacteristicsForType(set, "has-range", "has-length");
    case "integer64" : return addCharacteristicsForType(set, "has-range", "has-length");
    case "decimal" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "base64Binary" : return addCharacteristicsForType(set, "has-size");
    case "instant" : return addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "string" : return addCharacteristicsForType(set, "has-length", "do-translations", "can-bind");
    case "uri" : return addCharacteristicsForType(set, "has-length", "can-bind");
    case "date" :return  addCharacteristicsForType(set, "has-range", "has-length");
    case "dateTime" : return addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "time" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "has-length");
    case "canonical" :return  addCharacteristicsForType(set, "has-target", "has-length");
    case "code" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "id" :return  addCharacteristicsForType(set, "has-length");
    case "markdown" :return  addCharacteristicsForType(set, "do-translations", "has-length");
    case "oid" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "positiveInt" :return  addCharacteristicsForType(set, "has-range", "has-length");
    case "unsignedInt" :return  addCharacteristicsForType(set, "has-range", "has-length");
    case "url" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "uuid" :return  addCharacteristicsForType(set, "has-length", "can-bind");
    case "xhtml" :return  addCharacteristicsForType(set);
    case "Address" :return  addCharacteristicsForType(set, "do-translations");
    case "Age" : return addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "Annotation" :return  addCharacteristicsForType(set);
    case "Attachment" :return  addCharacteristicsForType(set, "has-size", "do-translations");
    case "CodeableConcept" :return  addCharacteristicsForType(set, "can-bind", "do-translations");
    case "CodeableReference" : return addCharacteristicsForType(set, "has-target", "can-bind", "do-translations");
    case "Coding" : return addCharacteristicsForType(set, "can-bind", "do-translations");
    case "ContactPoint" :return  addCharacteristicsForType(set);
    case "Count" :return  addCharacteristicsForType(set, "has-range");
    case "Distance" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "Duration" : return addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "HumanName" :return  addCharacteristicsForType(set);
    case "Identifier" : return addCharacteristicsForType(set);
    case "Money" : return addCharacteristicsForType(set, "has-range", "is-continuous");
    case "Period" : return addCharacteristicsForType(set);
    case "Quantity" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "Range" :return  addCharacteristicsForType(set, "has-units", "can-bind", "has-units");
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
    case "MoneyQuantity" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "SimpleQuantity" :return  addCharacteristicsForType(set, "has-range", "is-continuous", "can-bind", "has-units");
    case "MarketingStatus" :return  addCharacteristicsForType(set);
    case "ExtendedContactDetail" :return  addCharacteristicsForType(set);
    case "VirtualServiceDetail" :return  addCharacteristicsForType(set);
    case "Availability" :return  addCharacteristicsForType(set);
    case "MonetaryComponent" :return  addCharacteristicsForType(set);
    case "ElementDefinition" :return  addCharacteristicsForType(set);

    case "BackboneElement" :return  addCharacteristicsForType(set);
    case "Element" :return  addCharacteristicsForType(set);
    case "Base" :return  addCharacteristicsForType(set);
    default:
//      if (!context.getResourceNames().contains(tc)) {
//        System.out.println("Unhandled data type in addCharacteristics: "+tc);        
//      }
      return addCharacteristicsForType(set);
    }
  }


  private boolean addCharacteristicsForType(Set<String> set, String... cl) {
    for (String c : cl) {
      set.add(c);
    }
    return true;
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
      while (sd != null) {
        if (sd.hasExtension(ToolingExtensions.EXT_BINDING_STYLE)) {
          return tc;          
        }
        for (Extension ext : sd.getExtensionsByUrl(ToolingExtensions.EXT_TYPE_CHARACTERISTICS)) {
          if ("can-bind".equals(ext.getValue().primitiveValue())) {
            return tc;
          }
        }
        if (Utilities.existsInList(sd.getType(), "string", "uri", "CodeableConcept", "Quantity", "CodeableReference")) {
          return tc;
        }
        sd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      }
    }
    return null;
  }

  private boolean validateBinding(List<ValidationMessage> errors, Element binding, NodeStack stack, Set<String> typeCodes, boolean snapshot, String path) {
    boolean ok = true;
    if (bindableType(typeCodes) == null) {
      ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot, I18nConstants.SD_ED_BIND_NO_BINDABLE, path, typeCodes.toString()) && ok;
    } 
    if (!snapshot) {
      Set<String> bindables = getListofBindableTypes(typeCodes);    
      hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), bindables.size() <= 1, I18nConstants.SD_ED_BIND_MULTIPLE_TYPES, path, typeCodes.toString());
    }
    
    if (binding.hasChild("valueSet")) {
      Element valueSet = binding.getNamedChild("valueSet");
      String ref = valueSet.hasPrimitiveValue() ? valueSet.primitiveValue() : valueSet.getNamedChildValue("reference");
      if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || ref != null, I18nConstants.SD_ED_SHOULD_BIND_WITH_VS, path)) {
        Resource vs = context.fetchResource(Resource.class, ref);
        
        // just because we can't resolve it directly doesn't mean that terminology server can't. Check with it
        
        if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs != null || serverSupportsValueSet(ref), I18nConstants.SD_ED_BIND_UNKNOWN_VS, path, ref)) {
          if (vs != null) {
            ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs instanceof ValueSet, I18nConstants.SD_ED_BIND_NOT_VS, path, ref, vs.fhirType()) && ok;
          }
        }
      }
    } 
    return ok;
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
    ValidationResult vr = context.validateCode(new ValidationOptions().withCheckValueSetOnly().withVsAsUrl().withNoClient(), new Coding("http://loinc.org", "5792-7", null), new ValueSet().setUrl(ref));
    return vr.getErrorClass() == null || vr.getErrorClass() == TerminologyServiceErrorClass.UNKNOWN;
  }

  private boolean validateElementType(List<ValidationMessage> errors, Element type, NodeStack stack, StructureDefinition sd, String path, boolean logical) {
    boolean ok = true;
    String code = type.getNamedChildValue("code");
    if (code == null && path != null) {
      code = getTypeCodeFromSD(sd, path);
    } else {
      Set<String> types = getTypeCodesFromSD(sd, path);
      ok = rulePlural(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), types.isEmpty() || types.contains(code), types.size(), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TYPE, code, types.toString(), sd.getVersionedUrl());
    }
    if (code != null) {
      List<Element> profiles = type.getChildrenByName("profile");
      if (VersionUtilities.isR2Ver(context.getVersion()) || VersionUtilities.isR2BVer(context.getVersion()) ) {
        for (Element profile : profiles) {
          ok = validateProfileTypeOrTarget(errors, profile, code, stack.push(profile, -1, null, null), path) && ok;
        }
        
      } else {
        for (Element profile : profiles) {
          ok = validateTypeProfile(errors, profile, code, stack.push(profile, -1, null, null), path, sd) && ok;
        }
        profiles = type.getChildrenByName("targetProfile");
        for (Element profile : profiles) {
          ok = validateTargetProfile(errors, profile, code, stack.push(profile, -1, null, null), path, logical) && ok;
        }
      }
    }
    return ok;
  }

  private boolean validateProfileTypeOrTarget(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path) {
    boolean ok = true;
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (code.equals("Reference")) {
      if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd.getKind() == StructureDefinitionKind.RESOURCE, I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path) && ok;
        }
      }
    } else {
      if (sd == null ) {
        sd = getXverExt(errors, stack.getLiteralPath(), profile, p);
      }
      if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), isInstanceOf(t, code), I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path) && ok;
          if (t.getType().equals("Extension")) {
            boolean isModifierDefinition = checkIsModifierExtension(sd);
            boolean isModifierContext = path.endsWith(".modifierExtension");
            if (isModifierDefinition) {
              ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_NOT_MODIFIER, p, t, code, path) && ok;            
            } else {
              ok =rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), !isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_IS_MODIFIER, p, t, code, path) && ok;
            }          
          }
        }
      }      
    }
    return ok;
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

  private Set<String> getTypeCodesFromSD(StructureDefinition sd, String path) {
    Set<String> codes = new HashSet<>();
    for (ElementDefinition t : sd.getSnapshot().getElement()) {
      if (t.hasPath() && t.getPath().equals(path)) {
        for (TypeRefComponent tr : t.getType()) {
          codes.add(tr.getCode());
        }
      }
    }
    return codes;
  }

  private boolean validateTypeProfile(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path, StructureDefinition source) {
    boolean ok = true;
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (sd == null ) {
      sd = getXverExt(errors, stack.getLiteralPath(), profile, p);
    }
    if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
      StructureDefinition t = determineBaseType(sd);
      if (t == null) {
        ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p) && ok;
      } else if (!isInstanceOf(t, code)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path) && ok;
      } else {
        if (t.getType().equals("Extension")) {
          checkDefinitionStatus(errors, profile, path, sd, source, context.formatMessage(I18nConstants.MSG_DEPENDS_ON_EXTENSION));
          boolean isModifierDefinition = checkIsModifierExtension(sd);
          boolean isModifierContext = path.endsWith(".modifierExtension");
          if (isModifierDefinition) {
            ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_NOT_MODIFIER, p, t, code, path) && ok;            
          } else {
            ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), !isModifierContext, I18nConstants.SD_ED_TYPE_PROFILE_IS_MODIFIER, p, t, code, path) && ok;
          }          
        } else {
          checkDefinitionStatus(errors, profile, path, sd, source, context.formatMessage(I18nConstants.MSG_DEPENDS_ON_PROFILE));
        }
      }
    }
    return ok;
  }

  private boolean checkIsModifierExtension(StructureDefinition t) {
    return t.getSnapshot().getElementFirstRep().getIsModifier();
  }

  private boolean validateTargetProfile(List<ValidationMessage> errors, Element profile, String code, NodeStack stack, String path, boolean logical) {
    boolean ok = true;
    String p = profile.primitiveValue();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
    if (code.equals("Reference") || code.equals("CodeableReference")) {
      if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), (sd.getKind() == StructureDefinitionKind.RESOURCE) || (logical && isReferenceableTarget(t)), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Resource") && ok;
        }
      }
    } else if (code.equals("canonical")) {
      if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p) && ok;
        } else if (!VersionUtilities.isR5Plus(context.getVersion())) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(t.getType()) || "Resource".equals(t.getType()), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Canonical Resource") && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), Utilities.existsInList(t.getType(), "Resource", "CanonicalResource") || VersionUtilities.getCanonicalResourceNames(context.getVersion()).contains(t.getType()), I18nConstants.SD_ED_TYPE_PROFILE_WRONG_TARGET, p, t, code, path, "Canonical Resource") && ok;
        }  
      }
    } else {
      ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_NO_TARGET_PROFILE, code) && ok;
    }
    return ok;
  }

  private boolean isReferenceableTarget(StructureDefinition t) {
    for (Extension ext : t.getExtensionsByUrl(ExtensionConstants.EXT_SDTYPE_CHARACTERISTICS)) {
      if (ext.hasValue()) { 
      String c = ext.getValue().primitiveValue();
        if ("can-be-target".equals(c)) {
          return true;
        }
      }
    }
    if (ToolingExtensions.readBoolExtension(t,  "http://hl7.org/fhir/tools/StructureDefinition/logical-target")) {
      return true;
    }
    return false;
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
