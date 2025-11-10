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
import org.hl7.fhir.r5.conformance.profile.CompliesWithChecker;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IssueMessage;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.DefinitionNavigator;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

/**
 * todo:
 *
 * Update the publisher so that if it sees must-support on an repeating element, it will hint the author that this should be clarified in the must-support documentation, and if it sees a mix of must-support values on slicer and slices, this will become warning. Same for obligations that don't make clear whether they apply to the set or the individual elements. Make an IG parameter so authors can advise the validator that they do, in fact, document this for must-support
 * from FHIR-50391
 */
public class StructureDefinitionValidator extends BaseValidator {

  public class SourcedInvariant {

    private String sd;
    private String ed;
    private String inv;
    protected SourcedInvariant(String sd, String ed, String inv) {
      super();
      this.sd = sd;
      this.ed = ed;
      this.inv = inv;
    }
    public String getSd() {
      return sd;
    }
    public String getEd() {
      return ed;
    }
    public String getInv() {
      return inv;
    }
  }

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
    StructureDefinition base = null;
    String typeName = null;
    boolean experimental = false;
    String url = null;
    try {
      url = src.getNamedChildValue("url", false);

      sd = loadAsSD(src);
      ok = checkExtensionContext(errors, src, stack) && ok;

      List<ElementDefinition> snapshot = sd.getSnapshot().getElement();
      sd.setSnapshot(null);
      typeName = sd.getTypeName();
      experimental = "true".equals(src.getNamedChildValue("experimental", false));
      base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      if (warning(errors, NO_RULE_DATE, IssueType.NOTFOUND, stack.getLiteralPath(), base != null, I18nConstants.UNABLE_TO_FIND_BASE__FOR_, sd.getBaseDefinition(), "StructureDefinition, so can't check the differential")) {
        ok = rule(errors, "2025-07-15", IssueType.BUSINESSRULE, stack.getLiteralPath(), !base.hasUserData(UserDataNames.RESOURCE_INTERNAL_USE_ONLY), I18nConstants.RESOURCE_INTERNAL_USE_ONLY, "Structure", base.getSourcePackage() != null ? base.getSourcePackage().getVID() : "??") && ok;
        if (rule(errors, NO_RULE_DATE, IssueType.NOTFOUND, stack.getLiteralPath(), sd.hasDerivation(), I18nConstants.SD_MUST_HAVE_DERIVATION, sd.getUrl())) {
          checkTypeParameters(errors, stack, base, sd);
          boolean bok = base.getAbstract() || sd.hasKind() && sd.getKind() == base.getKind();
          ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), bok, I18nConstants.SD_CONSTRAINED_KIND_NO_MATCH, sd.getKind().toCode(), base.getKind().toCode(), base.getType(), base.getUrl()) && ok;
          if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
            ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), sd.hasType() && sd.getType().equals(base.getType()), I18nConstants.SD_CONSTRAINED_TYPE_NO_MATCH, sd.getType(), base.getType()) && ok;
            if (!src.hasUserData(UserDataNames.SNAPSHOT_ERRORS)) { // if it does, we've already logged these errors elsewhere
              List<ValidationMessage> msgs = new ArrayList<>();
              ProfileUtilities pu = new ProfileUtilities(context, msgs, null);
              pu.setForPublication(settings.isForPublication());
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
            } else {
              var snap = (StructureDefinitionSnapshotComponent) src.getUserData(UserDataNames.SNAPSHOT_DETAILS);
              sd.setSnapshot(snap);
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
        warning(errors, "2024-09-17", IssueType.BUSINESSRULE, stack.getLiteralPath(), !base.getExperimental() || experimental, I18nConstants.SD_BASE_EXPERIMENTAL, sd.getBaseDefinition());
      }
    } catch (Exception e) {
      if (settings.isDebug()) { 
        e.printStackTrace();
      }
      rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.ERROR_GENERATING_SNAPSHOT, e.getMessage());
      ok = false;
    }
    if (sd != null && base != null) {
      try {
        String abstractV = src.getNamedChildValue("abstract");
        if ("true".equals(abstractV)) {
          String burl = src.getNamedChildValue("url");
          if  (burl != null) {
            boolean bok = false;
            for (StructureDefinition sdb : context.fetchResourcesByType(StructureDefinition.class)) {
              if (burl.equals(sdb.getBaseDefinitionNoVersion())) {
                bok = true;
              }
            }
            warning(errors, "2024-12-31", IssueType.NOTFOUND, stack.getLiteralPath(), bok, I18nConstants.SD_DERIVATION_NO_CONCRETE, typeName);
          }
        }
        List<Element> differentials = src.getChildrenByName("differential");
        List<Element> snapshots = src.getChildrenByName("snapshot");
        boolean logical = "logical".equals(src.getNamedChildValue("kind", false));
        boolean constraint = "constraint".equals(src.getNamedChildValue("derivation", false));
        for (Element differential : differentials) {
          ok = validateElementList(errors, differential, stack.push(differential, -1, null, null), false, snapshots.size() > 0, sd, typeName, logical, constraint, src.getNamedChildValue("type", false), src.getNamedChildValue("url", false), src.getNamedChildValue("version", false), src.getNamedChildValue("type", false), base, experimental) && ok;
        }
        for (Element snapshotE : snapshots) {
          ok = validateElementList(errors, snapshotE, stack.push(snapshotE, -1, null, null), true, true, sd, typeName, logical, constraint, src.getNamedChildValue("type", false), src.getNamedChildValue("url", false), src.getNamedChildValue("version", false), src.getNamedChildValue("type", false), base, experimental) && ok;
        }
        if (!(differentials.isEmpty()  && snapshots.isEmpty())) {
          for (ElementDefinition ed : sd.getSnapshot().getElement()) {
            NodeStack snStack = stack.push(snapshots.isEmpty() ? differentials.get(0) : snapshots.get(0), -1, null, null);
            ok = validateSDElement(errors, ed, sd.getSnapshot().getElement(), snStack) && ok;
          }
        }

        // obligation profile support
        if (src.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_NEW, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_OLD)) {
          Element ext = src.getExtension(ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_NEW, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_OLD);
          Element value = ext.getNamedChild("value", false);
          if (value != null && "true".equals(value.primitiveValue())) {
            if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), "constraint".equals(src.getNamedChildValue("derivation", false)), I18nConstants.SD_OBGLIGATION_PROFILE_DERIVATION)) {
              if (warning(errors, "2023-05-27", IssueType.NOTFOUND, stack.getLiteralPath(), base != null, I18nConstants.SD_OBGLIGATION_PROFILE_UKNOWN, src.getNamedChildValue("baseDefinition", false))) {
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
          if (Utilities.existsInList(extension.getNamedChildValue("url", false), ExtensionDefinitions.EXT_OBLIGATION_INHERITS_NEW, ExtensionDefinitions.EXT_OBLIGATION_INHERITS_OLD)) {
            ok = validateInheritsObligationProfile(errors, extension, stack.push(extension, c, null, null), src) && ok;
          }
          c++;
        }

        List<Element> contextInvariants = src.getChildren("contextInvariant");
        c = 0;
        for (Element contextInvariant : contextInvariants) {
          ok = validateContextInvariant(errors, contextInvariant, src, stack.push(contextInvariant, c, null, null)) && ok;
          c++;
        }

        // if this is defining an extension, make sure that the extension fixed value matches the URL
        String type = src.getNamedChildValue("type", false);
        if ("Extension".equals(type)) {
          String baseD = src.getNamedChildValue("baseDefinition", false);
          if ("http://hl7.org/fhir/StructureDefinition/Extension".equals(baseD) && url != null) {
            String fixedUrl = getFixedValue(src);
            if (rule(errors, "2023-08-05", IssueType.INVALID, stack.getLiteralPath(), fixedUrl != null, I18nConstants.SD_EXTENSION_URL_MISSING, url)) {
              ok = rule(errors, "2023-08-05", IssueType.INVALID, stack.getLiteralPath(), url.equals(fixedUrl), I18nConstants.SD_EXTENSION_URL_MISMATCH, url, fixedUrl) && ok;
            } else {
              ok = false;
            }
          }
        }

        if (sd.hasExtension(ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE)) {
          for (Extension ext : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_SD_COMPLIES_WITH_PROFILE)) {
            String curl = ext.getValue().primitiveValue();
            StructureDefinition auth = context.fetchResource(StructureDefinition.class, curl, null, sd);
            if (auth == null) {
              ok = rule(errors, "2025-03-30", IssueType.INVALID, stack.getLiteralPath(), false, I18nConstants.SD_EXTENSION_COMPLIES_WITH_UNKNOWN, curl) && ok;
            } else {
              List<ValidationMessage> messages = new CompliesWithChecker(context).checkCompliesWith(sd, auth);
              IssueSeverity level = IssueSeverity.INFORMATION;
              for (ValidationMessage vm : messages) {
                level = IssueSeverity.max(level, vm.getLevel());
              }
              if (level == IssueSeverity.ERROR) {
                rule(errors, "2025-03-30", IssueType.INVALID, stack.getLiteralPath(), false, messages, I18nConstants.SD_EXTENSION_COMPLIES_WITH_ERROR, curl);
              } else if (level == IssueSeverity.WARNING) {
                warning(errors, "2025-03-30", IssueType.INVALID, stack.getLiteralPath(), false, messages, I18nConstants.SD_EXTENSION_COMPLIES_WITH_WARNING, curl);              
              }            
            }
          }
        }
      } catch (Exception e) {
        if (settings.isDebug()) { 
          e.printStackTrace();
        }
        rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.ERROR_PROCESSING_SNAPSHOT, e.getMessage());
        ok = false;
      }
    }
    return ok;
  }

  private boolean checkTypeParameters(List<ValidationMessage> errors, NodeStack stack, StructureDefinition base, StructureDefinition derived) {
    String bt = ExtensionUtilities.readStringExtension(base, ExtensionDefinitions.EXT_TYPE_PARAMETER);
    if (bt == null) {
      return true;
    } else {
      if (rule(errors, "2024-05-29", IssueType.INVALID, stack.getLiteralPath(), derived.hasExtension(ExtensionDefinitions.EXT_TYPE_PARAMETER), I18nConstants.SD_TYPE_PARAMETER_MISSING, base.getVersionedUrl(), bt, derived.getVersionedUrl())) {
        String dt = ExtensionUtilities.readStringExtension(derived, ExtensionDefinitions.EXT_TYPE_PARAMETER);
        StructureDefinition bsd = context.fetchTypeDefinition(bt);
        StructureDefinition dsd = context.fetchTypeDefinition(dt);
        if (rule(errors, "2024-05-29", IssueType.INVALID, stack.getLiteralPath(), bsd != null, I18nConstants.SD_TYPE_PARAMETER_UNKNOWN, base.getVersionedUrl(), bt) && 
            rule(errors, "2024-05-29", IssueType.INVALID, stack.getLiteralPath(), dsd != null, I18nConstants.SD_TYPE_PARAMETER_UNKNOWN, derived.getVersionedUrl(), dt)) {
          StructureDefinition t = dsd;
          while (t != bsd && t != null) {
            t = context.fetchResource(StructureDefinition.class, t.getBaseDefinition());
          }
          return rule(errors, "2024-05-29", IssueType.INVALID, stack.getLiteralPath(), t != null, I18nConstants.SD_TYPE_PARAMETER_INVALID, base.getVersionedUrl(), bt, derived.getVersionedUrl(), dt);
        }
      }
      return false;
    }
  }

  private String getFixedValue(Element src) {
    Element diff = src.getNamedChild("differential", false);
    if (diff != null) {
      for (Element ed : diff.getChildrenByName("element")) {
        String path = ed.getNamedChildValue("path", false);
        if ("Extension.url".equals(path)) {
          return ed.getNamedChildValue("fixed", false);
        }
      }
    }
    return null;
  }

  private boolean validateInheritsObligationProfile(List<ValidationMessage> errors, Element extension, NodeStack stack, Element src) {
    String tgt = extension.getNamedChildValue("value", false);
    if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), tgt != null, 
        I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_NO_TARGET)) {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, tgt);
      if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), src != null, 
          I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_TARGET_NOT_FOUND, tgt))  {
        if (rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), ExtensionUtilities.readBoolExtension(sd, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_NEW, ExtensionDefinitions.EXT_OBLIGATION_PROFILE_FLAG_OLD),
            I18nConstants.SD_OBGLIGATION_INHERITS_PROFILE_NOT_RIGHT_TYPE, tgt)) {
          String base = src.getNamedChildValue("baseDefinition", false);
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
    String id = element.getNamedChildValue("id", false);
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
          String url = child.getNamedChildValue("url", false);
          if (Utilities.existsInList(url, ExtensionDefinitions.EXT_OBLIGATION_CORE, ExtensionDefinitions.EXT_OBLIGATION_TOOLS)) {
            // this is ok, and it doesn't matter what's in the obligation
          } else {
            ok = false;
            rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), false, 
                I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL, id, child.getName()+"#"+url);
          }
        } else if (child.getName().equals("mustSupport")) {
          // this is ok, and there's nothing to check 
        } else if (child.getName().equals("min")) {
          // this is ok, and what there is to be checked will be checked elsewhere
        } else if (child.getName().equals("max")) {
          // this is ok, and what there is to be checked will be checked elsewhere
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
        String url = child.getNamedChildValue("url", false);
        if ("http://hl7.org/fhir/tools/StructureDefinition/additional-binding".equals(url) && !VersionUtilities.isR5Plus(context.getVersion())) {
          Element purpose = child.getExtension("purpose");
          if (purpose != null) { // should be an error elsewhere
            String code = purpose.getNamedChildValue("value", false);

            ok = rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), !Utilities.existsInList(code, "maximum", "required", "extensible"), 
                I18nConstants.SD_OBGLIGATION_PROFILE_INVALID_BINDING_CODE, id, code) && ok;
          }
        } else {
          ok = false;
          rule(errors, "2023-05-27", IssueType.INVALID, stack.getLiteralPath(), false, 
              I18nConstants.SD_OBGLIGATION_PROFILE_ILLEGAL, id, child.getName()+"#"+url);
        }
      } else if (child.getName().equals("additional") && VersionUtilities.isR5Plus(context.getVersion())) {
        String code = child.getNamedChildValue("purpose", false);
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

  private boolean checkExtensionContext(List<ValidationMessage> errors, Element src, NodeStack stack) throws IOException {
    boolean ok = true;
    String type = src.getNamedChildValue("type", false);
    List<Element> eclist = src.getChildren("context");
    List<Element> cilist = src.getChildren("contextInvariant");
    int i = 0;
    for (Element ec : eclist) {
      NodeStack n = stack.push(ec, i, null, null);
      if ("Extension".equals(type)) {
        String ct = null;
        String cv = null; 
        if (VersionUtilities.isR4Plus(context.getVersion())) {
          ct = ec.getNamedChildValue("type", false);
          cv = ec.getNamedChildValue("expression", false);          
        } else {
          ct = src.getNamedChildValue("contextType", false); /// todo - this doesn't have the right value
          cv = ec.primitiveValue();
        }
        if ("element".equals(ct)) {
          ok = checkElementDefinition(errors, n, ec, cv) && ok;
        }
        if ("element".equals(ct) && "Element".equals(cv)) {
          warning(errors, "2023-04-23", IssueType.BUSINESSRULE, n.getLiteralPath(), false, I18nConstants.SD_CONTEXT_SHOULD_NOT_BE_ELEMENT, cv, src.getNamedChildValue("id", false));
        } else if ("fhirpath".equals(ct)) {        	
          warning(errors, "2023-12-05", IssueType.BUSINESSRULE, n.getLiteralPath(), !isElement(cv), I18nConstants.SD_CONTEXT_SHOULD_NOT_BE_FHIRPATH, cv, src.getNamedChildValue("id", false));
        }
      } else if (!hasJsonName(src)) { // special case: if there's a json name, it can be used as an extension
        ok = rule(errors, "2023-04-23", IssueType.INVALID, n.getLiteralPath(), false, I18nConstants.SD_NO_CONTEXT_WHEN_NOT_EXTENSION, type) && ok;
      }
      i++;
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

  private boolean checkElementDefinition(List<ValidationMessage> errors, NodeStack n, Element ec, String path) throws IOException {
    boolean ok = true;
    String startVer;
    String endVer;
    Element ext = ec.getExtension(ExtensionDefinitions.EXT_FHIRVERSION_SPECIFIC_USE);
    if (ext != null && ext.hasExtension(ExtensionDefinitions.EXT_FHIRVERSION_SPECIFIC_USE_START)) {
      startVer = ext.getExtensionString(ExtensionDefinitions.EXT_FHIRVERSION_SPECIFIC_USE_START);
    } else {
      startVer = settings.getMinVersion();
      if (startVer == null) {
        startVer = context.getVersion();
      }
    }

    if (ext != null && ext.hasExtension(ExtensionDefinitions.EXT_FHIRVERSION_SPECIFIC_USE_END)) {
      endVer = ext.getExtensionString(ExtensionDefinitions.EXT_FHIRVERSION_SPECIFIC_USE_END);
    } else {
      endVer = settings.getMaxVersion();
      if (endVer == null) {
        endVer = context.getVersion();
      }
    }
    List<String> versionList = VersionUtilities.iterateCorePublishedVersions(startVer, endVer);
    for (String v : versionList) {
      IWorkerContext ctxt;
      if (VersionUtilities.versionMatches(v, context.getVersion())) {
        ctxt = context;
      } else {
        if (!session.getOtherVersions().containsKey(v)) {
          FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
          NpmPackage npm = pcm.loadPackage(VersionUtilities.packageForVersion(v));
          SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true)
            .fromPackage(npm, ValidatorUtils.loaderForVersion(v), false);
          session.getOtherVersions().put(v, swc);
        }
        ctxt = session.getOtherVersions().get(v);
      }
      try {
        String pp = (path.contains("#") ? path.substring(path.indexOf("#") + 1) : path);
        String[] p = pp.split("\\.");
        String url = path.contains("#") ? path.substring(0, path.indexOf("#")) : "http://hl7.org/fhir/StructureDefinition/" + p[0];

        StructureDefinition sd = ctxt.fetchResource(StructureDefinition.class, url);
        if (sd == null && url.equals("http://hl7.org/fhir/StructureDefinition/CanonicalResource")) {
          // this is a hack for the fact that CanonicalResource wasn't properly defined in R3-R5
          sd = ctxt.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/CodeSystem");
          pp = pp.replace("CanonicalResource", "CodeSystem");
          p = pp.split("\\.");
        }
        if (sd == null && url.equals("http://hl7.org/fhir/StructureDefinition/MetadataResource")) {
          // this is a hack for the fact that MetadataResource wasn't properly defined in R3-R5
          sd = ctxt.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/PlanDefinition");
          pp = pp.replace("MetadataResource", "PlanDefinition");
          p = pp.split("\\.");
        }
        if (sd == null) {
          ok = false;
          rule(errors, "2025-07-25", IssueType.INVALID, n.getLiteralPath(), false, versionList.size() == 1 ? I18nConstants.SD_CONTEXT_SHOULD_ELEMENT_NOT_FOUND : I18nConstants.SD_CONTEXT_SHOULD_ELEMENT_NOT_FOUND_VER, path, ctxt.getVersion());
        } else {
          DefinitionNavigator dn = new DefinitionNavigator(ctxt, sd, false, true);
          for (int i = 1; i < p.length; i++) {
            if (dn != null) {
              dn = dn.childByName(p[i]);
            }
          }
          if (dn == null) {
            ok = false;
            rule(errors, "2025-07-25", IssueType.INVALID, n.getLiteralPath(), false, versionList.size() == 1 ? I18nConstants.SD_CONTEXT_SHOULD_ELEMENT_NOT_FOUND : I18nConstants.SD_CONTEXT_SHOULD_ELEMENT_NOT_FOUND_VER, path, ctxt.getVersion());
          }
        }
      } catch (Exception e) {
        ok = false;
        rule(errors, "2025-07-25", IssueType.INVALID, n.getLiteralPath(), false, versionList.size() == 1 ? I18nConstants.SD_CONTEXT_SHOULD_ELEMENT_NOT_FOUND : I18nConstants.SD_CONTEXT_SHOULD_ELEMENT_NOT_FOUND_VER, path, ctxt.getVersion());
      }
    }
    return ok;
  }

  private boolean hasJsonName(Element sd) {
    Element rootDefn = null;
    if (sd.hasChild("snapshot")) {
      Element snapshot = sd.getNamedChild("snapshot");
      if (snapshot.hasChildren("element")) {
        rootDefn = snapshot.getChildren("element").get(0);
      }
    }
    if (rootDefn == null && sd.hasChild("differential")) {
      Element differential = sd.getNamedChild("differential");
      if (differential.hasChildren("element")) {
        rootDefn = differential.getChildren("element").get(0);
      }
    }
    if (rootDefn != null) {
      return rootDefn.hasExtension(ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED);
    } else {
      return false;
    }
  }

  private boolean isElement(String cv) {
    String tn = cv.contains(".") ? cv.substring(0, cv.indexOf(".")) : cv;
    StructureDefinition sd = context.fetchTypeDefinition(tn);
    if (sd != null) {
      return sd.getSnapshot().getElementByPath(cv) != null;
    } else {
      return false;
    }
  }

  private boolean validateElementList(List<ValidationMessage> errors, Element elementList, NodeStack stack, boolean snapshot, boolean hasSnapshot, StructureDefinition sd, String typeName, boolean logical, boolean constraint, String rootPath, 
      String profileUrl, String profileVersion, String profileType, StructureDefinition base, boolean experimental) {
    Map<String, SourcedInvariant> invariantMap = new HashMap<>();
    boolean ok = true;
    List<Element> elements = elementList.getChildrenByName("element");
    int cc = 0;
    for (Element element : elements) {
      ok = validateElementDefinition(errors, elements, element, stack.push(element, cc, null, null), snapshot, hasSnapshot, sd, typeName, logical, constraint, invariantMap, rootPath, profileUrl, profileVersion, profileType, base, experimental) && ok;
      cc++;
    }    
    return ok;
  }

  private boolean validateElementDefinition(List<ValidationMessage> errors, List<Element> elements, Element element, NodeStack stack, boolean snapshot, boolean hasSnapshot, StructureDefinition sd, String typeName, boolean logical, boolean constraint, Map<String, SourcedInvariant> invariantMap, String rootPath, String profileUrl, String profileVersion, String profileType, StructureDefinition base, boolean experimental) {
    boolean ok = true;
    boolean typeMustSupport = false;
    String path = element.getNamedChildValue("path", false);
    ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, stack.getLiteralPath(), typeName == null || path == null || path.equals(typeName) || path.startsWith(typeName+"."), I18nConstants.SD_PATH_TYPE_MISMATCH, typeName, path) && ok;
    if (!snapshot) {
      ok = rule(errors, "2023-01-17", IssueType.INVALID, stack.getLiteralPath(), path.contains(".") || !element.hasChild("slicing", false), I18nConstants.SD_NO_SLICING_ON_ROOT, path) && ok;
    }
    ok = rule(errors, "2023-05-22", IssueType.NOTFOUND, stack.getLiteralPath(), snapshot || !constraint || !element.hasChild("meaningWhenMissing", false) || meaningWhenMissingAllowed(element), I18nConstants.SD_ELEMENT_NOT_IN_CONSTRAINT, "meaningWhenMissing", path) && ok;

    List<Element> types = element.getChildrenByName("type");
    Set<String> typeCodes = new HashSet<>();
    Set<String> characteristics = new HashSet<>();
    boolean characteristicsValid = false;
    if (!path.contains(".")) {
      typeCodes.add(path); // root is type
      addCharacteristics(characteristics, path);
      characteristicsValid = true;
    }
    
    if (element.hasChild("slicing")) {
      Element slicing = element.getNamedChild("slicing");
      NodeStack sStack = stack.push(slicing, -1, null, null);
      
      // validating slicing. 
      // slicing can only be present if base cardinality > 1, but we can't always know that on the differential - though we can look it up 
      String tn = path.contains(".") ? path.substring(0, path.indexOf(".")) : path;
      StructureDefinition tsd = context.fetchTypeDefinition(tn);
      ElementDefinition ted = null;
      if (tsd != null) {
        ted = tsd.getSnapshot().getElementByPath(path);
        if (ted != null) {
          ok = rule(errors, "2022-11-02", IssueType.NOTFOUND, sStack, canSlice(ted), I18nConstants.SD_PATH_NO_SLICING, path) && ok;
        }
      }
      int i = 0;
      for (Element discriminator : slicing.getChildren("discriminator")) {
        NodeStack dStack = sStack.push(discriminator, i, null, null);
        String type = discriminator.getNamedChildValue("type");        
        if (VersionUtilities.isR5Plus(context.getVersion())) {
          warning(errors, "2024-11-06", IssueType.BUSINESSRULE, dStack, !"pattern".equals(type), I18nConstants.SD_PATH_SLICING_DEPRECATED_R5, type);
        } else {
          hint(errors, "2024-11-06", IssueType.BUSINESSRULE, dStack, !"pattern".equals(type), I18nConstants.SD_PATH_SLICING_DEPRECATED, type);
        }
        String pathExp = discriminator.getNamedChildValue("path");
        if (ted != null) {
          TypeDetails td = getTypesForElement(elements, element, tn, tsd.getUrl());
          if (!td.isEmpty()) {
            List<IssueMessage> warnings = new ArrayList<IssueMessage>();
            try {
              TypeDetails eval = fpe.checkOnTypes(this, "Resource", tn, td, fpe.parse(pathExp), warnings, true);
              if (eval.isEmpty()) {
                ok = rule(errors, "2024-11-06", IssueType.INVALID, dStack, false, I18nConstants.SD_PATH_NOT_VALID, pathExp, path) && ok;
              } 
            } catch (Exception e) {
                ok = rule(errors, "2024-11-06", IssueType.INVALID, dStack, false, I18nConstants.SD_PATH_ERROR, pathExp, path, e.getMessage()) && ok;                
            }
          }
        }
      }
    }

    if (!snapshot && (element.hasChild("fixed") || element.hasChild("pattern")) && base != null) {
      ElementDefinition ed = getDefinitionFromBase(base, element.getNamedChildValue("id"), element.getNamedChildValue("path"));
      if (ed != null && (ed.hasFixed() || ed.hasPattern())) {
        if (ed.hasFixed()) {
          Element fixed = element.getNamedChild("fixed");
          if (fixed != null) {
            NodeStack fn = stack.push(fixed, 0, null, null);            
            if (rule(errors, "2024-03-26", IssueType.INVALID, fn, fixed.fhirType().equals(ed.getFixed().fhirType()), I18nConstants.SD_ELEMENT_FIXED_WRONG_TYPE, fixed.fhirType(), ed.getFixed().fhirType())) {
              ok = ((org.hl7.fhir.validation.instance.InstanceValidator) parent).checkFixedValue(errors, path, fixed, ed.getFixed(), base.getVersionedUrl(), "fixed", element, false, context.formatMessage(I18nConstants.SD_ELEMENT_REASON_DERIVED, base.getVersionedUrl())) && ok;

            } else {
              ok = false;
            }
          }
        } else {
          Element pattern = element.getNamedChild("pattern");
          if (pattern != null) {
            NodeStack fn = stack.push(pattern, 0, null, null);  
            if (rule(errors, "2024-03-26", IssueType.INVALID, fn, ed.hasFixed(), I18nConstants.SD_ELEMENT_PATTERN_NO_FIXED, pattern.fhirType())) {
              if (rule(errors, "2024-03-26", IssueType.INVALID, fn, pattern.fhirType().equals(ed.getFixed().fhirType()), I18nConstants.SD_ELEMENT_PATTERN_WRONG_TYPE, pattern.fhirType(), ed.getFixed().fhirType())) {
                ok = ((org.hl7.fhir.validation.instance.InstanceValidator) parent).checkFixedValue(errors, path, pattern, ed.getFixed(), base.getVersionedUrl(), "pattern", element, true, context.formatMessage(I18nConstants.SD_ELEMENT_REASON_DERIVED, base.getVersionedUrl())) && ok;
              } else {
                ok = false;
              }
            } else {
              ok = false;
            }
          }
        }
      }
    }
    for (Element type : types) {
      if (hasMustSupportExtension(type)) {
        typeMustSupport = true;
      }
      String tc = type.getChildValue("code");
      if (type.hasExtension(ExtensionDefinitions.EXT_FHIR_TYPE)) {
        Base tcv = type.getExtensionValue(ExtensionDefinitions.EXT_FHIR_TYPE);
        if (tcv != null) {
          tc = tcv.primitiveValue();
        }
      }
      if (Utilities.noString(tc) && type.hasChild("code", false)) {
        if (VersionUtilities.isR4Plus(context.getVersion())) {
          ok = rule(errors, "2023-03-16", IssueType.INVALID, stack.getLiteralPath(), false, I18nConstants.SD_NO_TYPE_CODE_ON_CODE, path, sd.getId()) && ok;
        }
      }
      if (!Utilities.noString(tc)) {
        typeCodes.add(tc);
        Set<String> tcharacteristics = new HashSet<>();
        StructureDefinition tsd = context.fetchTypeDefinition(tc);
        if (tsd != null) {
          checkTypeParameters(errors, stack, type, tc, tsd, path, sd);
          characteristicsValid = true;
          if (tsd.hasExtension(ExtensionDefinitions.EXT_TYPE_CHARACTERISTICS)) {        
            for (Extension ext : tsd.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_CHARACTERISTICS)) {
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
        }
        // check the stated profile - must be a constraint on the type 
        if (snapshot || sd != null) {
          ok = validateElementType(errors, type, stack.push(type, -1, null, null), sd, path, logical) && ok;
        }
      }
    }
    if (typeMustSupport) {
      if (snapshot) {
        warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), "true".equals(element.getChildValue("mustSupport")), I18nConstants.SD_NESTED_MUST_SUPPORT_SNAPSHOT, path);
      } else {
        hint(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), hasSnapshot || "true".equals(element.getChildValue("mustSupport")), I18nConstants.SD_NESTED_MUST_SUPPORT_DIFF, path);        
      }
    }
    if (element.hasChild("binding", false)) {
      if (!typeCodes.isEmpty() && characteristicsValid) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("can-bind") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Binding", typeCodes) && ok;
      }
      Element binding = element.getNamedChild("binding", false);
      ok = validateBinding(errors, binding, stack.push(binding, -1, null, null), typeCodes, snapshot, path, experimental, sd) && ok;
    } else {
      // this is a good idea but there's plenty of cases where the rule isn't met; maybe one day it's worth investing the time to exclude these cases and bring this rule back
      //      String bt = boundType(typeCodes);
      //      hint(errors, UNKNOWN_DATE_TIME, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || bt == null, I18nConstants.SD_ED_SHOULD_BIND, element.getNamedChildValue("path", false), bt);              
    }
    if (!typeCodes.isEmpty() && characteristicsValid) {
      if (element.hasChild("maxLength", false)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-length") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MaxLength", typeCodes) && ok;      
      }
      if (element.hasExtension(ExtensionDefinitions.EXT_MIN_LENGTH)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-length") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MinLength Extension", typeCodes) && ok;      
      }
      if (element.hasChild("minValue", false)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-range") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MinValue", typeCodes) && ok;      
      }
      if (element.hasChild("maxValue", false)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-range") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "MaxValue", typeCodes) && ok;      
      }
      if (element.hasExtension(ExtensionDefinitions.EXT_MAX_DECIMALS)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("is-continuous") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Max Decimal Places Extension", typeCodes) && ok;      
      }
      if (element.hasExtension(ExtensionDefinitions.EXT_MAX_SIZE)) {
        ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), characteristics.contains("has-size") , I18nConstants.SD_ILLEGAL_CHARACTERISTICS, "Max Size", typeCodes) && ok;      
      }
    }
    // in a snapshot, we validate that fixedValue, pattern, and defaultValue, if present, are all of the right type
    if (snapshot && (element.getIdBase() != null) && (element.getIdBase().contains("."))) {
      if (rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), !typeCodes.isEmpty() || element.hasChild("contentReference", false), I18nConstants.SD_NO_TYPES_OR_CONTENTREF, element.getIdBase())) {     
        // if we see fixed[x] or pattern[x] applied to a repeating element, we'll give the user a hint
        boolean repeating = !Utilities.existsInList(element.getChildValue("max"), "0", "1");

        Element v = element.getNamedChild("defaultValue", false);
        if (v != null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "defaultValue", v.fhirType(), typeCodes) && ok;
        }
        v = element.getNamedChild("fixed", false);
        if (v != null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), typeCodes.contains(v.fhirType()), I18nConstants.SD_VALUE_TYPE_IILEGAL, element.getIdBase(), "fixed", v.fhirType(), typeCodes) && ok;
          hint(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_HINT, element.getIdBase(), "fixed");
          if (context.isPrimitiveType(v.fhirType())) {
            warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), !repeating, I18nConstants.SD_VALUE_TYPE_REPEAT_WARNING_DOTNET, element.getIdBase(), "fixed");
          } else {
            warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.push(v, -1, null, null).getLiteralPath(), false, I18nConstants.SD_VALUE_COMPLEX_FIXED, v.fhirType());            
          }
        }
        v = element.getNamedChild("pattern", false);
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
      ok = validateElementDefinitionInvariant(errors, invariant, stack.push(invariant, cc, null, null), invariantMap, elements, element, element.getNamedChildValue("path", false), rootPath, profileUrl, profileVersion, profileType, snapshot, base) && ok;
      cc++;
    }    
    if (snapshot) {
      if (constraint) {
        if (path.contains(".")) {
          // nothing
        } else {
          ok = prohibited(errors, stack, "constraint", element, "sliceName", "slicing", "requirements", "nameReference", "defaultValue", "meaningWhenMissing", "fixed", "pattern", "example", "minValue", "maxValue", "maxLength") && ok;
        }
      } else {
        if (path.contains(".")) {
          ok = required(errors, stack,  "specialization", element, "min", "max") && ok;
          ok = prohibited(errors, stack,  "specialization", element, "sliceName", /* allowed in element on .extension "slicing", */
              "fixed", "pattern", "minValue", "maxValue") && ok; // "maxLength" - was prohibited, but it's used like this in the core spec.
        } else {
          ok = prohibited(errors, stack,  "specialization", element, "sliceName", "slicing", "requirements", "nameReference", "defaultValue", "fixed", "pattern", "example", "minValue", "maxValue"/*, "maxLength"*/) && ok;
        }      
      }
    }
    return ok;
  }


  private boolean validateSDElement(List<ValidationMessage> errors, ElementDefinition element, List<ElementDefinition> elements, NodeStack stack) {
    boolean ok = true;
    
    if (element.hasSlicing()) {

      boolean ms = element.getMustSupport();
      List<ElementDefinition> slices = getSlices(element, elements);
      for (ElementDefinition slice : slices) {
        boolean mss = slice.getMustSupport();
        warning(errors, "2024-11-06", IssueType.INVALID, stack, !ms || mss, I18nConstants.SD_PATH_SLICE_INCONSISTENT_MS, slice.getSliceName(), element.getPath());
        for (TypeRefComponent tr : slice.getType()) {
          if (!hasTypeByCode(tr.getWorkingCode(), element)) {            
            warning(errors, "2024-11-06", IssueType.INVALID, stack, !ms || mss, I18nConstants.SD_PATH_SLICE_INCONSISTENT_TYPE, slice.getSliceName(), element.getPath(), tr.getWorkingCode(), element.typeSummary());
          }
        }
        // todo: other checks such as obligations, bindings
      }
    }
    return ok;
  }

  private boolean hasTypeByCode(String workingCode, ElementDefinition element) {
    for (TypeRefComponent tr : element.getType()) {
      if (tr.getWorkingCode().equals(workingCode)) {
        return true;
      }
    }
    return false;
  }

  private List<ElementDefinition> getSlices(ElementDefinition element, List<ElementDefinition> elements) {
    String path = element.getPath();
    int index = elements.indexOf(element)+1;
    List<ElementDefinition> result = new ArrayList<>();
    while (index < elements.size()) {
      String spath = elements.get(index).getPath();
      if (spath.length() < path.length()) {
        break; // end of that element
      } else if (spath.equals(path)) {
        result.add(elements.get(index));
      }
      index++;
    } 
    return result;
  }

  private boolean prohibited(List<ValidationMessage> errors, NodeStack stack, String mode, Element element, String... names) {
    boolean ok = true;
    for (String name : names) {
      List<Element> c = element.getChildren(name);
      ok = rule(errors, "2025-03-01", IssueType.EXCEPTION, stack, c.isEmpty(), I18nConstants.SD_TABLE_PROHIBITED, name, element.getNamedChildValue("path"), mode) && ok; 
    }
    return ok;
  }

  private boolean required(List<ValidationMessage> errors, NodeStack stack, String mode, Element element, String... names) {
    boolean ok = true;
    for (String name : names) {
      List<Element> c = element.getChildren(name);
      ok = rule(errors, "2025-03-01", IssueType.EXCEPTION, stack, !c.isEmpty(), I18nConstants.SD_TABLE_REQUIRED, name, element.getNamedChildValue("path"), mode) && ok; 
    }
    return ok;
  }

  private boolean canSlice(ElementDefinition ted) {
    return !("1".equals(ted.getMax())) || ted.getPath().contains("[x]");
  }

  private boolean checkTypeParameters(List<ValidationMessage> errors, NodeStack stack, Element typeE, String tc, StructureDefinition tsd, String path, StructureDefinition sd) {
    boolean ok = true;
    if (tsd.hasExtension(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
      List<Element> extensions = typeE.getChildrenByName("extension");
      for (Extension ext : tsd.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
        String name = ext.getExtensionString("name");
        String type = ext.getExtensionString("type");
        StructureDefinition psd = context.fetchTypeDefinition(type);
        if (psd != null && name != null) {
          boolean found = false;
          for (Element e : extensions) {
            if (ExtensionDefinitions.EXT_TYPE_PARAMETER.equals(e.getNamedChildValue("url"))) {
              if (!e.hasExtension("name")) {
                rule(errors, "2024-12-31", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.SD_TYPE_PARAMETER_UNKNOWN, tc, "no name");
              } else {
                String ename = e.getExtensionValue("name").primitiveValue();
                if (name.equals(ename)) {
                  found = true;
                  String etype = e.getExtensionValue("type").primitiveValue();
                  for (Extension ex : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_PARAMETER)) {
                    String tn = ex.getExtensionString("name");
                    if (tn != null && tn.equals(etype)) {
                      etype = ex.getExtensionString("type");
                      break;
                    }
                  }
                  StructureDefinition esd = context.fetchTypeDefinition(etype);
                  if (rule(errors, "2024-05-29", IssueType.BUSINESSRULE, stack.getLiteralPath(), esd != null, I18nConstants.SD_TYPE_PARAMETER_UNKNOWN, tc, etype)) {
                    StructureDefinition t = esd;
                    while (t != null && t != psd) {
                      t = context.fetchResource(StructureDefinition.class, t.getBaseDefinition());
                    }
                    ok = rule(errors, "2024-05-29", IssueType.BUSINESSRULE, stack.getLiteralPath(), t != null, I18nConstants.SD_TYPE_PARAMETER_INVALID_REF, tc, etype, tsd.getVersionedUrl(), name, type) & ok;
                    if (t != null) {
                      if (!sd.getAbstract() && esd.getAbstract()) {
                        warning(errors, "2024-05-29", IssueType.BUSINESSRULE, stack.getLiteralPath(), t != null, I18nConstants.SD_TYPE_PARAMETER_ABSTRACT_WARNING, tc, etype, tsd.getVersionedUrl(), name, type);
                      }
                    }
                  } else {
                    ok = false;
                  }
                }              
              }
            }
          }
          ok = rule(errors, "2024-05-29", IssueType.BUSINESSRULE, stack.getLiteralPath(), found, I18nConstants.SD_TYPE_PARAM_NOT_SPECIFIED, tc, tsd.getVersionedUrl(), name, path) && ok;
        }
      }
    }    
    return ok;
  }

  private ElementDefinition getDefinitionFromBase(StructureDefinition base, String id, String path) {
    ElementDefinition ed = null;
    if (id != null) {
      ed = base.getSnapshot().getElementById(id);
    }
    if (path != null) {
      ed = base.getSnapshot().getElementById(path);
    }
    return ed;
  }

  private boolean validateElementDefinitionInvariant(List<ValidationMessage> errors, Element invariant, NodeStack stack, Map<String, SourcedInvariant> invariantMap, List<Element> elements, Element element, 
      String path, String rootPath, String profileUrl, String profileVersion, String profileType, boolean snapshot, StructureDefinition base) {
    boolean ok = true;
    String key = invariant.getNamedChildValue("key", false); 
    String expression = invariant.getNamedChildValue("expression", false);
    String source = invariant.getNamedChildValue("source", false);
    if (warning(errors, "2023-06-19", IssueType.INFORMATIONAL, stack, !Utilities.noString(key), I18nConstants.ED_INVARIANT_NO_KEY)) {
      if (hint(errors, "2023-06-19", IssueType.INFORMATIONAL, stack, !Utilities.noString(expression) || VersionUtilities.isR5Plus(context.getVersion()), I18nConstants.ED_INVARIANT_NO_EXPRESSION, key)) { // not for R5 - there's an invariant
        if (snapshot) {// we just don't have enough information to figure out the context in a differential
          if (!Utilities.noString(expression)) {
            if (invariantMap.containsKey(key)) {
              // it's legal - and common - for a list of elements to contain the same invariant more than once, but it's not valid if it's not always the same 
              ok = rule(errors, "2023-06-19", IssueType.INVALID, stack, expression.equals(invariantMap.get(key).getInv()) || "ele-1".equals(key), I18nConstants.ED_INVARIANT_EXPRESSION_CONFLICT, key, expression, invariantMap.get(key).getInv());
            } else {
              invariantMap.put(key, new SourcedInvariant(profileUrl, path, expression));
            }
            if (Utilities.noString(source) || (source.equals(profileUrl))) { // no need to revalidate FHIRPath from elsewhere 
              try {
                // we have to figure out the context, and we might be in type slicing. 
                String exp = expression;
                Element te = element;
                TypeDetails types = getTypesForElement(elements, te, profileType, profileUrl);
                while (types.isEmpty() && te != null) {
                  Element oldte = te;
                  te = getParent(elements, te);
                  if (te != null) {
                    exp = tail(oldte, te)+".all("+exp+")";
                    types = getTypesForElement(elements, te, profileType, profileUrl);
                  }
                }
                if (types.isEmpty()) {
                  // we got to the root before finding anything typed
                  types.addType(elements.get(0).getNamedChildValue("path", false));
                }
        
                List<IssueMessage> warnings = new ArrayList<>();
                ValidationContext vc = new ValidationContext(invariant);
                if (Utilities.existsInList(rootPath, context.getResourceNames())) {
                  fpe.checkOnTypes(vc, "Resource", rootPath, types, fpe.parse(exp), warnings);
                } else {
                  StructureDefinition sd = context.fetchTypeDefinition(rootPath);
                  if (sd != null && sd.getKind() == StructureDefinitionKind.RESOURCE) {
                    fpe.checkOnTypes(vc, "Resource", rootPath, types, fpe.parse(exp), warnings);
                  } else if (sd != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
                    String tn = ExtensionUtilities.readStringExtension(sd, ExtensionDefinitions.EXT_LOGICAL_CONTAINER);
                    fpe.checkOnTypes(vc, "Resource", tn == null ? rootPath : tn, types, fpe.parse(exp), warnings);
                  } else {
                    fpe.checkOnTypes(vc, "Resource", "DomainResource", types, fpe.parse(exp), warnings);
                  }
                }
                for (IssueMessage s : warnings) {
                  warning(errors, "2023-07-27", IssueType.BUSINESSRULE, stack, s.getId(), false, key+": "+s.getMessage());
                }
              } catch (Exception e) {
                if (settings.isDebug()) {
                  e.printStackTrace();
                }
                ok = rule(errors, "2023-06-19", IssueType.INVALID, stack, false, I18nConstants.ED_INVARIANT_EXPRESSION_ERROR, key, expression, e.getMessage()) && ok;
              }         
            }        
          }
        } else {   
          if (rule(errors, "2023-07-27", IssueType.INVALID, stack, source == null || matchesCanonical(source, profileUrl, profileVersion), I18nConstants.ED_INVARIANT_DIFF_NO_SOURCE, key, source, profileUrl)) {
            SourcedInvariant inv = findInvariantInBase(base, key);
            if (rule(errors, "2023-07-27", IssueType.INVALID, stack, inv == null || inv.getInv().equals(expression), I18nConstants.ED_INVARIANT_KEY_ALREADY_USED, key, inv == null ? "??" : inv.getSd(), inv == null  ? "??" : inv.getInv())) {
              if (invariantMap.containsKey(key)) { 
                SourcedInvariant src = invariantMap.get(key);
                ok = rule(errors, "2023-07-27", IssueType.INVALID, stack, expression.equals(src.getInv()), I18nConstants.ED_INVARIANT_KEY_ALREADY_USED, key, src.getEd(), src.getInv()) && ok;
                
              } else {
                invariantMap.put(key, new SourcedInvariant(profileUrl, path, expression));
              }
            } else {
              ok = false;
            }
          } else {
            ok = false;
          }

        }
      }
    }
    return ok;
  }

  private boolean matchesCanonical(String source, String profileUrl, String profileVersion) {
    return source.equals(profileUrl) || (profileVersion != null && source.equals(profileUrl+"|"+profileVersion));
  }

  private boolean validateContextInvariant(List<ValidationMessage> errors, Element invariant, Element sd, NodeStack stack) {
    boolean ok = true;
    String expression = invariant.getValue();
    if (!Utilities.noString(expression)) {
      // we have to figure out the context, and we might be in type slicing. 
      String exp = expression;
      List<String> types = listTypeContexts(sd);
      if (types.size() == 0) {
        hint(errors, "2023-10-31", IssueType.INFORMATIONAL, stack, false, I18nConstants.UNABLE_TO_DETERMINE_TYPE_CONTEXT_INV, listContexts(sd));
      } else 
        try {
          List<IssueMessage> warnings = new ArrayList<>();
          ValidationContext vc = new ValidationContext(invariant);
          fpe.checkOnTypes(vc, "Resource", "DomainResource", types, fpe.parse(exp), warnings);
          for (IssueMessage s : warnings) {
            warning(errors, "2023-07-27", IssueType.BUSINESSRULE, stack, s.getId(), false, s.getMessage());
          }
        } catch (Exception e) {
          if (settings.isDebug()) {
            e.printStackTrace();
          }
          ok = rule(errors, "2023-06-19", IssueType.INVALID, stack, false, I18nConstants.ED_CONTEXT_INVARIANT_EXPRESSION_ERROR, expression, e.getMessage()) && ok;
        }         
    }        
    return ok;
  }

  private Object listContexts(Element sd) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (Element e : sd.getChildren("context")) {
      b.append(e.getNamedChildValue("type", false)+"="+e.getNamedChildValue("expression", false));
    }
    return b.toString();
  }

  private List<String> listTypeContexts(Element sd) {
    List<String> types = new ArrayList<>();
    for (Element e : sd.getChildren("context")) {
      switch (e.getNamedChildValue("type", false)) {
      case "fhirpath" :
        break;
      case "element" :
        types.add(e.getNamedChildValue("expression", false));
        break;
      case "extension" :
        // this isn't defined?
        types.add(e.getNamedChildValue("Extension", false));
        types.add(e.getNamedChildValue("Extension.value", false));
        break;
      default:
      }
    }
    return types;
  }

  private SourcedInvariant findInvariantInBase(StructureDefinition base, String key) {
    if (base != null) {
      for (ElementDefinition ed : base.getSnapshot().getElement()) {
        for (ElementDefinitionConstraintComponent inv : ed.getConstraint()) {
          if (key.equals(inv.getKey())) {
            return new SourcedInvariant(base.getVersionedUrl(), ed.getPath(), inv.getExpression());
          }
        }
      }
    }
    for (StructureDefinition sd : cu.allBaseStructures()) {
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        for (ElementDefinitionConstraintComponent inv : ed.getConstraint()) {
          if (key.equals(inv.getKey())) {
            return new SourcedInvariant(sd.getVersionedUrl(), ed.getPath(), inv.getExpression());
          }
        }
      }   
    }
    return null;
  }


  private boolean typesHaveInvariant(Map<String, String> invMap, String key, String expression) {
    if (invMap.containsKey(key)) {
      return !expression.equals(invMap.get(key));
    } else {
      return false;
    }
  }

  private String tail(Element te, Element newte) {
    String p = te.getNamedChildValue("path", false);
    String pn = newte.getNamedChildValue("path", false);
    return p.substring(pn.length()+1);
  }

  private Element getParent(List<Element> elements, Element te) {
    int i = elements.indexOf(te) - 1;
    String path = te.getNamedChildValue("path", false);
    while (i >= 0) {
      String p = elements.get(i).getNamedChildValue("path", false);
      if (path.startsWith(p+".")) {
        return elements.get(i);
      }
      i--;
    }
    return null;
  }

  private TypeDetails getTypesForElement(List<Element> elements, Element element, String profileType, String profileUrl) {
    TypeDetails types = new TypeDetails(CollectionStatus.SINGLETON);
    if (element.hasChild("path", false) && !element.getNamedChildValue("path", false).contains(".")) {
      String t = element.getNamedChildValue("path", false);
      if (profileType.equals(t)) {
        types.addType(profileType, profileUrl);
      } else if (profileType.endsWith("/"+t)) {
        types.addType(profileType, profileUrl);
      } else {
        throw new Error("Error: this should not happen: '"+t+"' vs '"+profileType+"'?");
      }      
    } else {
      for (Element tr : element.getChildrenByName("type")) {
        String t = tr.getNamedChildValue("code", false);
        if (t.startsWith("http://hl7.org/fhirpath")) {
          t = tr.getExtensionValue("http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type").primitiveValue();
        }
        if (t != null) {
          if (isAbstractType(t) && hasChildren(element, elements) ) {
            if (!Utilities.isAbsoluteUrl(profileType)) {
              types.addType(profileUrl+ "#"+element.getNamedChildValue("path", false));
            } else {
              types.addType(profileType+"#"+element.getNamedChildValue("path", false));              
            }
          } else {
            types.addType(t);
          }
        }
      }
    }
    return types;
  }

  private boolean hasChildren(Element element, List<Element> elements) {
    int i = elements.indexOf(element);
    String path = element.getNamedChildValue("path", false)+".";
    while (i < elements.size()) {
      String p = elements.get(i).getNamedChildValue("path", false)+".";
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
    String path = element.getNamedChildValue("path", false);
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
        if (sd.hasExtension(ExtensionDefinitions.EXT_BINDING_STYLE)) {
          return tc;          
        }
        for (Extension ext : sd.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_CHARACTERISTICS)) {
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

  private boolean validateBinding(List<ValidationMessage> errors, Element binding, NodeStack stack, Set<String> typeCodes, boolean snapshot, String path, boolean experimental, StructureDefinition profile) {
    boolean ok = true;
    if (bindableType(typeCodes) == null) {
      ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot, I18nConstants.SD_ED_BIND_NO_BINDABLE, path, typeCodes.toString()) && ok;
    } 
    if (!snapshot) {
      Set<String> bindables = getListofBindableTypes(typeCodes);    
      hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), bindables.size() <= 1, I18nConstants.SD_ED_BIND_MULTIPLE_TYPES, path, typeCodes.toString());
    }

    if (binding.hasChild("valueSet", false)) {
      Element valueSet = binding.getNamedChild("valueSet", false);
      String ref = valueSet.hasPrimitiveValue() ? valueSet.primitiveValue() : valueSet.getNamedChildValue("reference", false);
      if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || ref != null, I18nConstants.SD_ED_SHOULD_BIND_WITH_VS, path)) {
        Resource vs = context.fetchResource(Resource.class, ref);

        // just because we can't resolve it directly doesn't mean that terminology server can't. Check with it

        if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs != null || serverSupportsValueSet(ref), I18nConstants.SD_ED_BIND_UNKNOWN_VS, path, ref)) {
          if (vs != null) {
            ok = rule(errors, "2025-07-15", IssueType.BUSINESSRULE, stack.getLiteralPath(), !vs.hasUserData(UserDataNames.RESOURCE_INTERNAL_USE_ONLY), I18nConstants.RESOURCE_INTERNAL_USE_ONLY, "ValueSet", vs.getSourcePackage() != null ? vs.getSourcePackage().getVID() : "??") && ok;
            if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs instanceof ValueSet, I18nConstants.SD_ED_BIND_NOT_VS, path, ref, vs.fhirType())) {
              ValueSet vsr = (ValueSet) vs;
              if (!"example".equals(binding.getNamedChildValue("strength"))) {
                warning(errors, "2024-09-17", IssueType.BUSINESSRULE, stack.getLiteralPath(), !vsr.getExperimental() || experimental, I18nConstants.SD_ED_EXPERIMENTAL_BINDING, path, ref);
              }
            } else {
              ok = false;
            }
          }
        }
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !"http://loinc.org/vs".equals(ref), I18nConstants.SD_ED_BIND_ALL_LOINC_CODES, ref);
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !"http://snomed.info/sct?fhir_vs".equals(ref), I18nConstants.SD_ED_BIND_ALLSCT_CODES, ref);
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !"http://hl7.org/fhir/ValueSet/cpt-all".equals(ref), I18nConstants.SD_ED_BIND_ALL_CPT_CODES, ref);
      }
    } 
    if (binding.hasChildren("additional")) {
      int i = 0;
      for (Element ab : binding.getChildren("additional")) {
         ok = validateAdditionalBinding(errors, ab, stack.push(ab, i, null, null), snapshot, path, experimental) && ok;
         i++;
      }
    }
    if (binding.hasExtension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) {
      int i = 0;
      for (Element ab : binding.getChildren("extension")) {
        String url = ab.getNamedChildValue("url");
        if (ExtensionDefinitions.EXT_BINDING_ADDITIONAL.equals(url)) {
           ok = validateAdditionalBindingExtension(errors, ab, stack.push(ab, i, null, null), snapshot, path, experimental, profile) && ok;
        }
        i++;
      }      
    }
    return ok;
  }
  
  private boolean validateAdditionalBinding(List<ValidationMessage> errors, Element binding, NodeStack stack, boolean snapshot, String path, boolean experimental) {
    boolean ok = true;

    if (binding.hasChild("valueSet", false)) {
      Element valueSet = binding.getNamedChild("valueSet", false);
      String ref = valueSet.hasPrimitiveValue() ? valueSet.primitiveValue() : valueSet.getNamedChildValue("reference", false);
      if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || ref != null, I18nConstants.SD_ED_SHOULD_BIND_WITH_VS, path)) {
        Resource vs = context.fetchResource(Resource.class, ref);

        // just because we can't resolve it directly doesn't mean that terminology server can't. Check with it

        if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs != null || serverSupportsValueSet(ref), I18nConstants.SD_ED_BIND_UNKNOWN_VS, path, ref)) {
          if (vs != null) {
            ok = rule(errors, "2025-07-15", IssueType.BUSINESSRULE, stack.getLiteralPath(), !vs.hasUserData(UserDataNames.RESOURCE_INTERNAL_USE_ONLY), I18nConstants.RESOURCE_INTERNAL_USE_ONLY, "ValueSet", vs.getSourcePackage() != null ? vs.getSourcePackage().getVID() : "??") && ok;
            if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs instanceof ValueSet, I18nConstants.SD_ED_BIND_NOT_VS, path, ref, vs.fhirType())) {
              ValueSet vsr = (ValueSet) vs;
              warning(errors, "2024-09-17", IssueType.BUSINESSRULE, stack.getLiteralPath(), !vsr.getExperimental() || experimental, I18nConstants.SD_ED_EXPERIMENTAL_BINDING, path, ref);
            } else {
              ok = false;
            }
          }
        }
      }
    } 
    if (binding.hasChildren("usage")) {
      for (Element usage : binding.getChildren("usage")) {
        // warning(errors, "2024-09-20", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, "test");    
        // TODO
      }
    }
    return ok;
  }

  private boolean validateAdditionalBindingExtension(List<ValidationMessage> errors, Element binding, NodeStack stack, boolean snapshot, String path, boolean experimental, StructureDefinition profile) {
    boolean ok = true;

    if (binding.hasExtension("valueSet")) {
      Element valueSet = binding.getExtension("valueSet");
      Element vv = valueSet.getNamedChild("value");
      String ref = vv.hasPrimitiveValue() ? vv.primitiveValue() : vv.getNamedChildValue("reference", false);
      if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !snapshot || ref != null, I18nConstants.SD_ED_SHOULD_BIND_WITH_VS, path)) {
        Resource vs = context.fetchResource(Resource.class, ref);

        // just because we can't resolve it directly doesn't mean that terminology server can't. Check with it

        if (warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs != null || serverSupportsValueSet(ref), I18nConstants.SD_ED_BIND_UNKNOWN_VS, path, ref)) {
          if (vs != null) {
            if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs instanceof ValueSet, I18nConstants.SD_ED_BIND_NOT_VS, path, ref, vs.fhirType())) {              
              ValueSet vsr = (ValueSet) vs;
              warning(errors, "2024-09-17", IssueType.BUSINESSRULE, stack.getLiteralPath(), !vsr.getExperimental() || experimental, I18nConstants.SD_ED_EXPERIMENTAL_BINDING, path, ref);
            } else {
              ok = false;
            }
          }
        }
      }
    } 
    if (binding.hasExtension("usage")) {
      int i = 0;
      for (Element usage : binding.getChildren("extension")) {
        String url = usage.getNamedChildValue("url");
        if ("usage".equals(url)) {
          Element uv = usage.getNamedChild("value");  
          ok = validateAdditionalBindingUsage(errors, uv, stack.push(uv, -1, null, null), path, profile) && ok;
        }
        i++;
      }      
    }
    return ok;
  }

  private boolean validateAdditionalBindingUsage(List<ValidationMessage> errors, Element usage, NodeStack stack, String path, StructureDefinition profile) {
    boolean ok = true;
    Element cc = usage.getNamedChild("code");
    if (cc != null) {
      String system = cc.getNamedChildValue("system");
      String code = cc.getNamedChildValue("code");
      if (system != null && system.equals(profile.getUrl())) {
        ElementDefinition ed = profile.getDifferential().getElementByPath(code);
        if (ed == null) {
          ed = profile.getSnapshot().getElementByPath(code);          
        }
        if (ed == null) {
          ok = false;
          rule(errors, "2024-09-17", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.SD_ED_ADDITIONAL_BINDING_USAGE_INVALID_ELEMENT, system, code);
        } else {
          if (usage.hasChild("value")) {
            String t = usage.getNamedChild("value").fhirType();
            ok = rule(errors, "2024-09-20", IssueType.BUSINESSRULE, stack.getLiteralPath(), "CodeableConcept".equals(t), I18nConstants.SD_ED_ADDITIONAL_BINDING_USAGE_INVALID_TYPE, t, "CodeableConcept") && ok;
          }
        }
      } else {
        hint(errors, "2024-09-17", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.SD_ED_ADDITIONAL_BINDING_USAGE_UNKNOWN, system, code);
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
    ValidationResult vr = context.validateCode(new ValidationOptions(FhirPublication.R5).withCheckValueSetOnly().withNoClient(), new Coding("http://loinc.org", "5792-7", null), new ValueSet().setUrl(ref));
    return vr.getErrorClass() == null || vr.getErrorClass() == TerminologyServiceErrorClass.UNKNOWN;
  }

  private boolean validateElementType(List<ValidationMessage> errors, Element type, NodeStack stack, StructureDefinition sd, String path, boolean logical) {
    boolean ok = true;
    String code = type.getNamedChildValue("code", false);
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
    BooleanHolder errored = new BooleanHolder();
    if (code.equals("Reference")) {
      if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        ok = rule(errors, "2025-07-15", IssueType.BUSINESSRULE, stack.getLiteralPath(), !sd.hasUserData(UserDataNames.RESOURCE_INTERNAL_USE_ONLY), I18nConstants.RESOURCE_INTERNAL_USE_ONLY, "Structure", sd.getSourcePackage() != null ? sd.getSourcePackage().getVID() : "??") && ok;
        StructureDefinition t = determineBaseType(sd);
        if (t == null) {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), false, I18nConstants.SD_ED_TYPE_PROFILE_NOTYPE, p) && ok;
        } else {
          ok = rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd.getKind() == StructureDefinitionKind.RESOURCE, I18nConstants.SD_ED_TYPE_PROFILE_WRONG, p, t, code, path) && ok;
        }
      }
    } else {
      if (sd == null ) {
        sd = getXverExt(errors, stack.getLiteralPath(), profile, p, errored);
      }
      if (warning(errors, NO_RULE_DATE, IssueType.EXCEPTION, stack.getLiteralPath(), sd != null, I18nConstants.SD_ED_TYPE_PROFILE_UNKNOWN, p)) {
        ok = rule(errors, "2025-07-15", IssueType.BUSINESSRULE, stack.getLiteralPath(), !sd.hasUserData(UserDataNames.RESOURCE_INTERNAL_USE_ONLY), I18nConstants.RESOURCE_INTERNAL_USE_ONLY, "Structure", sd.getSourcePackage() != null ? sd.getSourcePackage().getVID() : "??") && ok;
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
    BooleanHolder errored = new BooleanHolder();
    if (sd == null ) {
      sd = getXverExt(errors, stack.getLiteralPath(), profile, p, errored);
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
    for (Extension ext : t.getExtensionsByUrl(ExtensionDefinitions.EXT_TYPE_CHARACTERISTICS)) {
      if (ext.hasValue()) { 
        String c = ext.getValue().primitiveValue();
        if ("can-be-target".equals(c)) {
          return true;
        }
      }
    }
    if (ExtensionUtilities.readBoolExtension(t,  ExtensionDefinitions.EXT_LOGICAL_TARGET)) {
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
    if ("true".equals(getExtensionValue(type, ExtensionDefinitions.EXT_MUST_SUPPORT))) {
      return true;
    }
    List<Element> profiles = type.getChildrenByName("profile");
    for (Element profile : profiles) {
      if ("true".equals(getExtensionValue(profile, ExtensionDefinitions.EXT_MUST_SUPPORT))) {
        return true;
      }
    }
    profiles = type.getChildrenByName("targetProfile");
    for (Element profile : profiles) {
      if ("true".equals(getExtensionValue(profile, ExtensionDefinitions.EXT_MUST_SUPPORT))) {
        return true;
      }
    }
    return false;
  }

  private String getExtensionValue(Element element, String url) {
    List<Element> extensions = element.getChildrenByName("extension");
    for (Element extension : extensions) {
      if (url.equals(extension.getNamedChildValue("url", false))) {
        return extension.getNamedChildValue("value", false);
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
