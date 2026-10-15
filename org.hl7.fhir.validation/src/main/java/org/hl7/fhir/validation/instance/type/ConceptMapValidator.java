package org.hl7.fhir.validation.instance.type;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.model.core.ValueSet.ConceptSetComponent;
import org.hl7.fhir.model.utilities.CodeSystemUtilities;
import org.hl7.fhir.services.elementmodel.ElementModelUtilities;
import org.hl7.fhir.services.validation.IValidatorResourceFetcher;
import org.hl7.fhir.standalone.terminology.client.TerminologyClientContext;
import org.hl7.fhir.services.terminology.CodingValidationRequest;
import org.hl7.fhir.model.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

@Slf4j
public class ConceptMapValidator extends BaseValidator {

  public class RelationshipTracker {

    Map<String, String> map = new HashMap<>();
    
    public boolean has(String source) {
      return map.containsKey(source);
    }

    public void see(String source, String reln) {
      map.put(source, reln);      
    }

    public String get(String source) {
      return map.get(source);
    }

    public boolean has(String source, String target) {
      return map.containsKey(key(source, target));
    }

    public Object get(String source, String target) {
      return map.get(key(source, target));
    }

    public void see(String source, String target, String reln) {
      map.put(key(source, target), reln);
    }

    private String key(String source, String target) {
      return "|"+source+"|"+target+"|";
    }

  }

  
  public static class PropertyDefinition {
    private final String type;
    private final String system;
    private final CodeSystem cs;
    protected PropertyDefinition(String type, String system, CodeSystem cs) {
      super();
      this.type = type;
      this.system = system;
      this.cs = cs;
    }
    public String getType() {
      return type;
    }
    public String getSystem() {
      return system;
    }
    public CodeSystem getCs() {
      return cs;
    }
  }
  
  public static class CSReference {
    private String url;
    private String version;
    private Element src;
    private CodeSystem cs;
  }
  
  public static class VSReference {
    private String url;
    private String version;
    private ValueSet vs;
  }

  public static class GroupContext {
    private VSReference sourceScope;
    private VSReference targetScope;
    private CSReference source;
    private CSReference target;
    public boolean hasSourceCS() {
      return source != null && source.cs != null;
    }
    public boolean hasSourceVS() {
      return sourceScope != null && sourceScope.vs != null;
    }
    public boolean hasTargetCS() {
      return target != null && target.cs != null;
    }
    public boolean hasTargetVS() {
      return targetScope != null && targetScope.vs != null;
    }
    public ValueSet getSourceVS() {
      return hasSourceVS() ? sourceScope.vs : null;
    }
    public ValueSet getTargetVS() {
      return hasTargetVS() ? targetScope.vs : null;
    }    
  }
  

  public class CMCodingValidationRequest extends CodingValidationRequest {

    private final NodeStack stack;

    public CMCodingValidationRequest(NodeStack stack, Coding code) {
      super(code);
      this.stack = stack;
    }

    public NodeStack getStack() {
      return stack;
    }
  }

  private Map<String, Boolean> checkServerURLs = new HashMap<>();
  private final List<CMCodingValidationRequest> batch = new ArrayList<>();
  private final List<GroupInfo> groupInfos = new ArrayList<>();
  
  public ConceptMapValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateConceptMap(ValidationContext valContext, List<ValidationMessage> errors, Element cm, NodeStack stack, ValidationOptions options) {
    boolean ok = true;
    Map<String, PropertyDefinition> props = new HashMap<>();
    Map<String, String> attribs = new HashMap<>();
    
    if (VersionUtilities.isR5Plus(context.getFHIRVersion())) {
      List<Element> properties = cm.getChildrenByName("property");
      int ci = 0;
      for (Element property : properties) {
        String code = property.getChildValue("code");
        String type = property.getChildValue("type");
        String system = property.getChildValue("system");
        CodeSystem cs = system != null ? context.fetchCodeSystem(system, ElementModelUtilities.getVersionResolutionRules(property.getNamedChild("system"))) : null;
        ok = rule(errors, "2023-03-05", IssueType.REQUIRED, property.line(), property.col(), stack.push(property, ci, null, null).getLiteralPath(), 
            !"code".equals(type) || system != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_TYPE_NO_SYSTEM) && ok;
        warning(errors, "2023-03-05", IssueType.REQUIRED, property.line(), property.col(), stack.push(property, ci, null, null).getLiteralPath(), 
           system == null || cs != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_TYPE_UNKNOWN_SYSTEM, system);
        if (code != null) {
          props.put(code, new PropertyDefinition(type, system, cs));
        }
        ci++;
      } 
      
      List<Element> attributes = cm.getChildrenByName("additionalAttribute");
      for (Element attribute : attributes) {
        String code = attribute.getChildValue("code");
        String type = attribute.getChildValue("type");
        if (code != null) {
          attribs.put(code, type);
        }
      }
    }
    BooleanHolder bh = new BooleanHolder();
    VSReference sourceScope = readVSReference(errors, stack, bh, cm, "sourceScope", "source");
    VSReference targetScope = readVSReference(errors, stack, bh, cm, "targetScope", "target");
    ok = ok && bh.ok();

    List<Element> groups = cm.getChildrenByName("group");
    int ci = 0;
    for (Element group : groups) {
      ok = validateGroup(valContext, errors, group, stack.push(group, ci, null, null), props, attribs, options, sourceScope, targetScope) && ok;
      ci++;
    }    

    if (!stack.isContained()) {
      ok = checkShareableConceptMap(errors, cm, stack) && ok;
    }
    
    if (!batch.isEmpty()) {
      int codeLimit = settings.getCodeSystemValidationSizeLimit();
      if (codeLimit > 0 && batch.size() > codeLimit) {
        ok = hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CONCEPTMAP_VS_TOO_MANY_CODES, batch.size(), codeLimit) && ok;
      } else if (!noTerminologyChecks) {
        try {
          long t = System.currentTimeMillis();
          context.validateCodeBatch(ValidationOptions.defaults(), batch, null);
          log.debug("  :   .. "+(System.currentTimeMillis()-t)+"ms");
          for (CMCodingValidationRequest cv : batch) {
            if (cv.getResult().getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
              warning(errors, "2023-09-06", IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.CONCEPTMAP_VS_CONCEPT_CODE_UNKNOWN_SYSTEM, cv.getCoding().getSystem(), cv.getCoding().getCode(), null);
            } else if (cv.getResult().getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED_VERSION) {
              warning(errors, "2023-09-06", IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.CONCEPTMAP_VS_CONCEPT_CODE_UNKNOWN_SYSTEM_VERSION, cv.getCoding().getSystem(), cv.getCoding().getCode(), null, cv.getResult().getVersion());
            } else if (cv.getCoding().getVersion() == null) {
              ok = rule(errors, "2023-09-06", IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.CONCEPTMAP_VS_INVALID_CONCEPT_CODE, cv.getCoding().getSystem(), cv.getCoding().getCode(), null) && ok;
            } else {
              ok = rule(errors, "2023-09-06", IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.CONCEPTMAP_VS_INVALID_CONCEPT_CODE_VER, cv.getCoding().getSystem(), cv.getCoding().getVersion(), cv.getCoding().getCode(), null) && ok;
            }
          }
        } catch (Exception e) {
          ok = false;
          CMCodingValidationRequest cv = batch.get(0);
          rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, cv.getStack().getLiteralPath(), false, e.getMessage());
        }

      }
    }
    checkMappingQuality(errors, cm, stack, options, sourceScope, targetScope);
    return ok;
  }


  private VSReference readVSReference(List<ValidationMessage> errors, NodeStack stack,BooleanHolder bok, Element cm, String... names) {
    for (String n : names) {
      if (cm.hasChild(n, false)) {
        Element e = cm.getNamedChild(n, false);
        String ref = null;
        Element refCtxt = null;
        if (e.isPrimitive()) {
          ref = e.primitiveValue();
          refCtxt = e;
        } else if (e.hasChild("reference", false)) {
          ref = e.getNamedChildValue("reference", false);
          refCtxt = e.getNamedChild("reference");
        }
        if (ref != null) {
          VSReference res = new VSReference();
          if (ref.contains("|")) {
            res.url = ref.substring(0, ref.indexOf("|"));
            res.version = ref.substring(ref.indexOf("|")+1);
            Resource r = context.fetchResource(Resource.class, res.url, ElementModelUtilities.getVersionResolutionRules(refCtxt), res.version, null);
            if (r != null) {
              if (r instanceof ValueSet) {
                res.vs = (ValueSet) r;
              } else {
                bok.fail();
                rule(errors, "2025-12-31", IssueType.INVALID, stack.getLiteralPath()+"."+n, false, I18nConstants.CONCEPTMAP_VS_NOT_A_VS, r.fhirType());
              }
            } 
            if (res.vs == null) {
              res.vs = context.findTxResource(ValueSet.class, res.url, VersionResolutionRules.defaultRule(), res.version, null);
            }
          } else {
            res.url = ref;
            Resource r = context.fetchResource(Resource.class, res.url, ElementModelUtilities.getVersionResolutionRules(refCtxt));
            if (r != null) {
              if (r instanceof ValueSet) {
                res.vs = (ValueSet) r;
              } else {
                bok.fail();
                rule(errors, "2025-12-31", IssueType.INVALID, stack.getLiteralPath()+"."+n, false, I18nConstants.CONCEPTMAP_VS_NOT_A_VS, r.fhirType());
              }
            } 
            if (res.vs == null) {
              res.vs = context.findTxResource(ValueSet.class, res.url, VersionResolutionRules.defaultRule());
            }
          }
          return res;
        }
      }
    }
    return null;
  }

  private boolean validateGroup(ValidationContext valContext, List<ValidationMessage> errors, Element grp, NodeStack stack, Map<String, PropertyDefinition> props, Map<String, String> attribs, ValidationOptions options, VSReference sourceScope, VSReference targetScope) {
    boolean ok = true;
    GroupContext ctxt = new GroupContext();
    ctxt.sourceScope = sourceScope;
    ctxt.targetScope = targetScope;
    
    Element e = grp.getNamedChild("source", false);
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_MISSING)) {
      ctxt.source = readCSReference(e, grp.getNamedChild("sourceVersion", false), ctxt.getSourceVS());
      if (ctxt.source.cs != null) {
        if (isServerSideOnly(ctxt.source.cs)) {
          hint(errors, "2024-03-25", IssueType.BUSINESSRULE, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), false, I18nConstants.CONCEPTMAP_GROUP_SOURCE_SERVER_SIDE, e.getValue());
          ctxt.source.cs = null;
        } else if (!warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), isOkCodeSystem(ctxt.source.cs), I18nConstants.CONCEPTMAP_GROUP_SOURCE_INCOMPLETE, e.getValue(), ctxt.source.cs.getContent().toCode())) {
          ctxt.source.cs = null;
        }
      } else {
        warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), sourceScope != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_UNKNOWN, e.getValue());
      }
      if (fetcher != null && ctxt.source.version == null && ctxt.source.cs != null && !CodeSystemUtilities.isExemptFromMultipleVersionChecking(ctxt.source.url) && fetcher != null && ElementModelUtilities.getVersionResolutionRules(ctxt.source.src) != VersionResolutionRules.LATEST) {
          Set<IValidatorResourceFetcher.ResourceVersionInformation> possibleVersions = fetcher.fetchCanonicalResourceVersions(null, valContext.getAppContext(), ctxt.source.url);
          warning(errors, NO_RULE_DATE, IssueType.INVALID, grp.line(), grp.col(), stack.getLiteralPath(), possibleVersions.size() <= 1, I18nConstants.TYPE_SPECIFIC_CHECKS_DT_CANONICAL_MULTIPLE_POSSIBLE_VERSIONS, 
              ctxt.source.url,  ctxt.source.cs.getVersion(), CommaSeparatedStringBuilder.join(", ", Utilities.sorted(IValidatorResourceFetcher.ResourceVersionInformation.toStrings(possibleVersions))));
      }
    }
    e = grp.getNamedChild("target", false);
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_MISSING)) {
      ctxt.target = readCSReference(e, grp.getNamedChild("targetVersion", false), ctxt.getTargetVS());
      if (ctxt.target.cs != null) {                              
        if (isServerSideOnly(ctxt.target.cs)) {
          hint(errors, "2024-03-25", IssueType.BUSINESSRULE, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), false, I18nConstants.CONCEPTMAP_GROUP_TARGET_SERVER_SIDE, e.getValue());
          ctxt.target.cs = null;
        } else if (!warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), isOkCodeSystem(ctxt.target.cs), I18nConstants.CONCEPTMAP_GROUP_TARGET_INCOMPLETE, e.getValue(), ctxt.target.cs.getContent().toCode())) {
          ctxt.target.cs = null;
        }
      } else {
        warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), targetScope != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_UNKNOWN, e.getValue());                              
        
      }
      if (fetcher != null && ctxt.target.version == null && ctxt.target.cs != null && !CodeSystemUtilities.isExemptFromMultipleVersionChecking(ctxt.target.url) && ElementModelUtilities.getVersionResolutionRules(ctxt.target.src) != VersionResolutionRules.LATEST) {
        Set<IValidatorResourceFetcher.ResourceVersionInformation> possibleVersions = fetcher.fetchCanonicalResourceVersions(null, valContext.getAppContext(), ctxt.target.url);
        warning(errors, NO_RULE_DATE, IssueType.INVALID, grp.line(), grp.col(), stack.getLiteralPath(), possibleVersions.size() <= 1, I18nConstants.TYPE_SPECIFIC_CHECKS_DT_CANONICAL_MULTIPLE_POSSIBLE_VERSIONS, 
            ctxt.target.url,  ctxt.target.cs.getVersion(), CommaSeparatedStringBuilder.join(", ", Utilities.sorted(IValidatorResourceFetcher.ResourceVersionInformation.toStrings(possibleVersions))));
      }
    }
    
    RelationshipTracker relationships = new RelationshipTracker();
    List<Element> elements = grp.getChildrenByName("element");
    int ci = 0;
    for (Element element : elements) {
      ok = validateGroupElement(errors, stack, element, stack.push(element, ci, null, null), props, attribs, options, ctxt, relationships) && ok;
      ci++;
    }    
    groupInfos.add(buildGroupInfo(grp, stack, ctxt));
    return ok;
  }

  private boolean isServerSideOnly(CodeSystem cs) {
    return Utilities.existsInList(cs.getUrl(), "http://snomed.info/sct", "http://loinc.org");
  }

  private CSReference readCSReference(Element ref, Element version, ValueSet vs) {
    CSReference res = new CSReference();
    res.url = ref.primitiveValue();
    res.src = ref;
    if (version != null) {
      res.version = version.primitiveValue();
      res.src = version;
    } else if (res.url.contains("|")) {
      res.version = res.url.substring(res.url.indexOf("|")+1);
      res.url = res.url.substring(0, res.url.indexOf("|"));
    } else if (vs != null && res.url  != null) {
      for (ConceptSetComponent vsi : vs.getCompose().getIncludeList()) {
        if (res.url.equals(vsi.getSystem()) && vsi.hasVersion() ) {
          res.version = vsi.getVersion();
        }
      }
    }
    res.cs = context.fetchCodeSystem(res.url, ElementModelUtilities.getVersionResolutionRules(res.src), res.version, vs);
    return res;
  }

  private boolean isOkCodeSystem(CodeSystem tgtCS) {
    return tgtCS.getContent() != CodeSystemContentMode.NOTPRESENT && tgtCS.getContent() != CodeSystemContentMode.EXAMPLE && tgtCS.getContent() != CodeSystemContentMode.FRAGMENT;
  }

  private boolean validateGroupElement(List<ValidationMessage> errors, NodeStack baseStack, Element src, NodeStack stack, Map<String, PropertyDefinition> props, Map<String, String> attribs, ValidationOptions options, GroupContext ctxt, RelationshipTracker relationships) {
    boolean ok = true;
    
    Element code = src.getNamedChild("code", false);
    String source =  code != null ? code.primitiveValue() : null;
    if (code != null) {
      NodeStack cstack = stack.push(code, -1, null, null);
      if (ctxt.hasSourceCS()) {
        String c = code.getValue();
        ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(ctxt.source.cs, c);
        if (warningOrError(ctxt.source.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID, c, ctxt.source.cs.getVersionedUrl())) {
          Element display = src.getNamedChild("display", false);
          if (display != null) {
            warning(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), CodeSystemUtilities.checkDisplay(ctxt.source.cs, cd, display.getValue()), I18nConstants.CONCEPTMAP_GROUP_SOURCE_DISPLAY_INVALID, display.getValue(), CommaSeparatedStringBuilder.joinWrapped(", ", "'", "'", CodeSystemUtilities.getDisplays(ctxt.source.cs, cd)), ctxt.source.cs.getVersionedUrl()+"#"+cd.getCode());
          }
          if (!noTerminologyChecks && ctxt.hasSourceVS() && ctxt.source != null) {
            ValidationResult vr = context.validateCode(options.withCheckValueSetOnly().withNoServer(), ctxt.source.url, ctxt.source.version, c, null, ctxt.sourceScope.vs);
            if (vr.getErrorClass() == TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS){
              warning(errors, "2026-06-11", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_CANT_CHECK, c, ctxt.source.cs.getVersionedUrl());
            } else if (!warningOrError(ctxt.source.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-09-06", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID_VS, c, ctxt.sourceScope.vs.getVersionedUrl())) {
              ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) && ok;
            } else {
              // processConceptIssues(errors, concept, stack, system, version, vv, display);
            }
          }
        } else {
          ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) && ok;
        }
      } else {
        addToBatch(errors, baseStack, code, cstack, ctxt.source, ctxt.sourceScope);
      }
    }
    
    List<Element> targets = src.getChildrenByName("target");
    int ci = 0;
    for (Element target : targets) {
      ok = validateGroupElementTarget(errors, baseStack, target, stack.push(target, ci, null, null), props, attribs, options, ctxt, relationships, source) && ok;
      ci++;
    }    
    boolean noMap = "true".equals(src.getNamedChildValue("noMap"));
    if (noMap) {
      if (!relationships.has(source)) {
        relationships.see(source, "noMap");
      } else if (!relationships.get(source).equals("noMap")) {
        warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, "--", relationships.get(source), "noMap");
      } else {
        warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION, source, "--", "noMap");
      }
    }
    return ok;
  }
  
  private boolean validateGroupElementTarget(List<ValidationMessage> errors, NodeStack baseStack, Element tgt, NodeStack stack, Map<String, PropertyDefinition> props,
      Map<String, String> attribs, ValidationOptions options, GroupContext ctxt, RelationshipTracker relationships, String source) {
    boolean ok = true;


    Element code = tgt.getNamedChild("code", false);
    if (code != null) {
      NodeStack cstack = stack.push(code, -1, null, null);
      if (ctxt.hasTargetCS()) {
        String c = code.getValue();
        ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(ctxt.target.cs, c);
        if (warningOrError(ctxt.target.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_INVALID, c, ctxt.target.cs.getVersionedUrl())) {
          Element display = tgt.getNamedChild("display", false);
          if (display != null) {          
            warning(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), CodeSystemUtilities.checkDisplay(ctxt.target.cs, cd, display.getValue()), I18nConstants.CONCEPTMAP_GROUP_TARGET_DISPLAY_INVALID, display.getValue(), CommaSeparatedStringBuilder.joinWrapped(", ", "'", "'", CodeSystemUtilities.getDisplays(ctxt.target.cs, cd)), ctxt.target.cs.getVersionedUrl()+"#"+cd.getCode());
          }
          if (!noTerminologyChecks && ctxt.hasTargetVS() && ctxt.target != null) {
            ValidationResult vr = context.validateCode(options.withCheckValueSetOnly().withNoServer(), ctxt.target.url, ctxt.target.version, c, null, ctxt.targetScope.vs);
            if (vr.getErrorClass() == TerminologyServiceErrorClass.BLOCKED_BY_OPTIONS){
              warning(errors, "2026-06-11", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_CANT_CHECK, c, ctxt.target.cs.getVersionedUrl());
            } else if (!warningOrError(ctxt.target.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-09-06", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_INVALID_VS, c, ctxt.target.cs.getVersionedUrl())) {
              ok = (ctxt.target.cs.getContent() != CodeSystemContentMode.COMPLETE) && ok;
            }
          }
        } else {
          ok = (ctxt.target.cs.getContent() != CodeSystemContentMode.COMPLETE) && ok;
        }
      } else {
        addToBatch(errors, baseStack, code, cstack, ctxt.target, ctxt.targetScope);
      }
    } 
    
    String target = tgt.getNamedChildValue("code");
    String tgtForMsg = target == null ? "--" : target;
    String reln = tgt.getNamedChildValue(VersionUtilities.isR5Plus(context.getFHIRVersion()) ? "relationship" : "equivalence");
    
    if (source != null && reln != null) {
      if (target == null) {
        if (!relationships.has(source)) {
          relationships.see(source, reln);
        } else if (relationships.get(source).equals(reln)) {
          warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION, source, tgtForMsg, reln);
        } else {
          warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, tgtForMsg, relationships.get(source), reln);
        }
      } else {
        if (relationships.has(source)) {
          warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, "--", relationships.get(source), reln);
        }
        if (relationships.has(source, target)) {
          if (relationships.get(source, target).equals(reln)) {
            warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION, source, tgtForMsg, reln);
          } else {
            warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, tgtForMsg, relationships.get(source, target), reln);
          }
        } else {
          relationships.see(source, target, reln);
        }
      }
    }

    if (VersionUtilities.isR5Plus(context.getFHIRVersion())) {
      List<Element> properties = tgt.getChildrenByName("property");
      int ci = 0;
      for (Element property : properties) {
        ok = validateGroupElementTargetProperty(errors, property, stack.push(property, ci, null, null), props) && ok;
        ci++;
      }

      List<Element> attributes = tgt.getChildrenByName("dependsOn");
      ci = 0;
      for (Element attribute : attributes) {
        ok = validateGroupElementTargetAttribute(errors, attribute, stack.push(attribute, ci, null, null), attribs) && ok;
        ci++;
      }
      attributes = tgt.getChildrenByName("product");
      ci = 0;
      for (Element attribute : attributes) {
        ok = validateGroupElementTargetAttribute(errors, attribute, stack.push(attribute, ci, null, null), attribs) && ok;
        ci++;
      }
    }    
    return ok;
  }
  
  private boolean validateGroupElementTargetProperty(List<ValidationMessage> errors, Element property, NodeStack stack, Map<String, PropertyDefinition> props) {
    boolean ok = true;
    Element codeE = property.getNamedChild("code", false);
    Element valueE = property.getNamedChild("value", false);
    String code = codeE.getValue();
    if (rule(errors, "2023-03-05", IssueType.REQUIRED, codeE.line(), codeE.col(), stack.push(codeE, -1, null, null).getLiteralPath(), props.containsKey(code), I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_INVALID, code, props.keySet())) {
      PropertyDefinition defn = props.get(code);
      NodeStack stackV = stack.push(valueE, -1, null, null);
      if (rule(errors, "2023-03-05", IssueType.REQUIRED, codeE.line(), codeE.col(), stackV.getLiteralPath(), valueE.fhirType().equals(defn.getType()), I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_TYPE_MISMATCH, valueE.fhirType(), defn.getType())) {
        if (valueE.fhirType().equals("code")) {
          if (defn.getCs() != null) {
            ok = rule(errors, "2023-03-05", IssueType.REQUIRED, codeE.line(), codeE.col(), stackV.getLiteralPath(), 
                CodeSystemUtilities.findCode(defn.getCs().getConceptList(), valueE.getValue()) != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_CODE_INVALID, valueE.getValue(), defn.getCs().getVersionedUrl()) && ok;
          } else {
            ok = false;
          }
        }
      } else {
        ok = false;
      }        
    } else {
      ok = false;
    }
    return ok;
  }

  private boolean validateGroupElementTargetAttribute(List<ValidationMessage> errors, Element attribute, NodeStack stack, Map<String, String> attribs) {
    boolean ok = true;
    Element codeE = attribute.getNamedChild("attribute", false);
    Element valueE = attribute.getNamedChild("value", false);
    String code = codeE.getValue();
    if (rule(errors, "2023-03-05", IssueType.REQUIRED, codeE.line(), codeE.col(), stack.push(codeE, -1, null, null).getLiteralPath(), attribs.containsKey(code), I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_INVALID, code, attribs.keySet())) {
      NodeStack stackV = stack.push(valueE, -1, null, null);
      ok = rule(errors, "2023-03-05", IssueType.REQUIRED, codeE.line(), codeE.col(), stackV.getLiteralPath(), valueE.fhirType().equals(attribs.get(code)), I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_TYPE_MISMATCH, valueE.fhirType(), attribs.get(code)) && ok;        
    } else {
      ok = false;
    }
    return ok;
  }

  private boolean checkShareableConceptMap(List<ValidationMessage> errors, Element cs, NodeStack stack) {
    if (settings.isForPublication()) { 
      if (isHL7(cs)) {
        boolean ok = true;
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "title") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name", false), I18nConstants.CONCEPTMAP_SHAREABLE_EXTRA_MISSING_HL7, "name");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "description") && ok; 
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name", false), I18nConstants.CONCEPTMAP_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description", false), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "description"); 
      }
    }
    return true;
  }


  private void addToBatch(List<ValidationMessage> errors, NodeStack baseStack, Element code, NodeStack stack, CSReference system, VSReference scope) {
    if (scope != null && scope.vs != null && system != null) {
      boolean supported;
      String key = CanonicalType.urlWithVersion(system.url, system.version);
      if (!checkServerURLs.containsKey(key)) {
        org.hl7.fhir.services.terminology.SystemSupportInformation txInfo = context.getTxSupportInfo(system.url, system.version);
        supported = txInfo.getTestVersion() != null && VersionUtilities.isThisOrLater(TerminologyClientContext.TX_BATCH_VERSION, txInfo.getTestVersion(), VersionUtilities.VersionPrecision.MINOR);
        checkServerURLs.put(key, supported);
        if (!supported) {
          warning(errors, "2025-07-07", IssueType.NOTSUPPORTED, baseStack, false, I18nConstants.VALUESET_TXVER_BATCH_NOT_SUPPORTED, (txInfo.getTestVersion() == null ? "Not Known" : txInfo.getTestVersion()), system.url + (system.version == null ? "" : "|" + system.version), txInfo.getServer());
        }
      } else {
        supported = checkServerURLs.get(key);
      }
      if (supported) {
        Coding c = new Coding(system.url, code.primitiveValue(), null).setVersion(system.version);
        batch.add(new CMCodingValidationRequest(stack, c));
      }
    }
  }
  // ---- mapping quality checks -----------------------------------------------------------------
  //
  // These look at what the map claims about the meaning of the codes, rather than at whether the
  // codes are valid. Hints are for things that look like they are missing, warnings are for
  // claims that are inconsistent with each other, with the code system hierarchies, or with a
  // reverse map (if one is found in the context - that only happens if someone provides it).

  private static final String REL_EQUIVALENT = "equivalent";
  private static final String REL_NARROWER = "source-is-narrower-than-target";
  private static final String REL_BROADER = "source-is-broader-than-target";
  private static final String REL_RELATED = "related-to";
  private static final String REL_UNRELATED = "not-related-to";
  private static final String REL_NOMAP = "noMap";

  private static class MapTarget {
    private String code;
    private String relationship; // normalised to the R5 relationship codes
    private boolean conditional; // has dependsOn or product, so the simple rules don't apply
    private NodeStack stack;
  }

  private static class MapRow {
    private String code;
    private boolean noMap;
    private NodeStack stack;
    private final List<MapTarget> targets = new ArrayList<>();
  }

  private static class GroupInfo {
    private NodeStack stack;
    private GroupContext ctxt;
    private boolean hasUnmapped;
    private final List<MapRow> rows = new ArrayList<>();
  }

  private static class SubsumptionCheck {
    private String system;
    private String version;
    private String parent;
    private String child;
    private boolean local;
    private NodeStack stack;
    private String msgId;
    private Object[] params;
  }

  private GroupInfo buildGroupInfo(Element grp, NodeStack stack, GroupContext ctxt) {
    boolean r5 = VersionUtilities.isR5Plus(context.getFHIRVersion());
    GroupInfo gi = new GroupInfo();
    gi.stack = stack;
    gi.ctxt = ctxt;
    gi.hasUnmapped = grp.hasChild("unmapped", false);
    int ei = 0;
    for (Element element : grp.getChildrenByName("element")) {
      MapRow row = new MapRow();
      row.code = element.getNamedChildValue("code", false);
      row.noMap = "true".equals(element.getNamedChildValue("noMap", false));
      row.stack = stack.push(element, ei, null, null);
      int ti = 0;
      for (Element tgt : element.getChildrenByName("target")) {
        String raw = tgt.getNamedChildValue(r5 ? "relationship" : "equivalence", false);
        String code = tgt.getNamedChildValue("code", false);
        if (!r5 && "unmatched".equals(raw) && code == null) {
          row.noMap = true; // the R4 way of saying noMap
        } else {
          String rel = normaliseRelationship(raw, r5);
          if (code != null && rel != null) {
            MapTarget t = new MapTarget();
            t.code = code;
            t.relationship = rel;
            t.conditional = !tgt.getChildrenByName("dependsOn").isEmpty() || !tgt.getChildrenByName("product").isEmpty();
            t.stack = row.stack.push(tgt, ti, null, null);
            row.targets.add(t);
          }
        }
        ti++;
      }
      if (row.code != null) {
        gi.rows.add(row);
      }
      ei++;
    }
    return gi;
  }

  /**
   * R4 equivalence codes describe the target relative to the source; R5 relationship codes
   * describe the source relative to the target. Everything is worked in R5 terms
   */
  private String normaliseRelationship(String raw, boolean r5) {
    if (raw == null || r5) {
      return raw;
    }
    switch (raw) {
      case "equal":
      case "equivalent":
        return REL_EQUIVALENT;
      case "wider":
      case "subsumes":
        return REL_NARROWER;
      case "narrower":
      case "specializes":
        return REL_BROADER;
      case "relatedto":
      case "inexact":
        return REL_RELATED;
      case "disjoint":
        return REL_UNRELATED;
      default:
        return null;
    }
  }

  private String inverseRelationship(String rel) {
    if (REL_NARROWER.equals(rel)) {
      return REL_BROADER;
    } else if (REL_BROADER.equals(rel)) {
      return REL_NARROWER;
    } else {
      return rel;
    }
  }

  private boolean relationshipsConsistent(String forward, String reverse) {
    if (REL_RELATED.equals(forward) || REL_RELATED.equals(reverse)) {
      // related-to is weak - it only conflicts with an explicit statement that there's no relationship
      return !REL_UNRELATED.equals(forward) && !REL_UNRELATED.equals(reverse);
    }
    return inverseRelationship(forward).equals(reverse);
  }

  private void checkMappingQuality(List<ValidationMessage> errors, Element cm, NodeStack stack, ValidationOptions options, VSReference sourceScope, VSReference targetScope) {
    for (GroupInfo gi : groupInfos) {
      checkEquivalenceDuplicates(errors, gi);
    }
    checkSubsumption(errors, stack, options);
    checkScopeCoverage(errors, options, sourceScope);
    String url = cm.getNamedChildValue("url", false);
    for (GroupInfo gi : groupInfos) {
      if (checkDirection(errors, gi, sourceScope, targetScope)) {
        checkReverseMap(errors, gi, url, sourceScope, targetScope);
      }
    }
  }

  private void checkEquivalenceDuplicates(List<ValidationMessage> errors, GroupInfo gi) {
    Map<String, String> equivalentSource = new HashMap<>();
    for (MapRow row : gi.rows) {
      String firstTarget = null;
      for (MapTarget t : row.targets) {
        if (REL_EQUIVALENT.equals(t.relationship) && !t.conditional) {
          if (firstTarget == null) {
            firstTarget = t.code;
          } else if (!firstTarget.equals(t.code)) {
            warning(errors, "2026-10-13", IssueType.BUSINESSRULE, t.stack, false, I18nConstants.CONCEPTMAP_QUALITY_EQUIVALENT_TARGETS, row.code, firstTarget, t.code);
          }
          String other = equivalentSource.get(t.code);
          if (other == null) {
            equivalentSource.put(t.code, row.code);
          } else if (!other.equals(row.code)) {
            warning(errors, "2026-10-13", IssueType.BUSINESSRULE, t.stack, false, I18nConstants.CONCEPTMAP_QUALITY_EQUIVALENT_SOURCES, other, row.code, t.code);
          }
        }
      }
    }
  }

  private void checkSubsumption(List<ValidationMessage> errors, NodeStack stack, ValidationOptions options) {
    List<SubsumptionCheck> checks = new ArrayList<>();
    for (GroupInfo gi : groupInfos) {
      boolean srcOk = gi.ctxt.source != null && doesSubsumption(gi.ctxt.source);
      boolean tgtOk = gi.ctxt.target != null && doesSubsumption(gi.ctxt.target);
      // source side: a1 = b, a2 < b or a2 > b, so a1 and a2 must be related in the source hierarchy
      Map<String, String> equivalentSource = new HashMap<>();
      for (MapRow row : gi.rows) {
        for (MapTarget t : row.targets) {
          if (REL_EQUIVALENT.equals(t.relationship) && !t.conditional) {
            equivalentSource.putIfAbsent(t.code, row.code);
          }
        }
      }
      for (MapRow row : gi.rows) {
        // target side: a = b1, a < b2 or a > b2, so b1 and b2 must be related in the target hierarchy
        String b1 = null;
        for (MapTarget t : row.targets) {
          if (REL_EQUIVALENT.equals(t.relationship) && !t.conditional) {
            b1 = t.code;
            break;
          }
        }
        for (MapTarget t : row.targets) {
          boolean narrower = REL_NARROWER.equals(t.relationship);
          if (t.conditional || !(narrower || REL_BROADER.equals(t.relationship))) {
            continue;
          }
          String a1 = equivalentSource.get(t.code);
          if (srcOk && a1 != null && !a1.equals(row.code)) {
            checks.add(subsumptionCheck(gi.ctxt.source, narrower ? a1 : row.code, narrower ? row.code : a1, t.stack,
                I18nConstants.CONCEPTMAP_QUALITY_SOURCE_SUBSUMPTION, a1, t.code, row.code, t.relationship));
          }
          if (tgtOk && b1 != null && !b1.equals(t.code)) {
            checks.add(subsumptionCheck(gi.ctxt.target, narrower ? t.code : b1, narrower ? b1 : t.code, t.stack,
                I18nConstants.CONCEPTMAP_QUALITY_TARGET_SUBSUMPTION, row.code, b1, t.code, t.relationship));
          }
        }
      }
    }
    if (checks.isEmpty() || noTerminologyChecks) {
      return;
    }
    int codeLimit = settings.getCodeSystemValidationSizeLimit();
    if (codeLimit > 0 && checks.size() > codeLimit) {
      hint(errors, "2026-10-13", IssueType.INFORMATIONAL, stack, false, I18nConstants.CONCEPTMAP_QUALITY_TOO_MANY_CHECKS, checks.size(), codeLimit);
      return;
    }
    Map<String, Boolean> results = new HashMap<>();
    for (SubsumptionCheck check : checks) {
      String key = check.system + "|" + check.version + "#" + check.parent + ">" + check.child;
      // if we have the code system, the internal subsumption tester is authoritative: if it can't
      // tell, the server won't be able to either (and we don't want a server call for each check)
      ValidationOptions opts = check.local ? options.withNoServer() : options;
      Boolean subsumes;
      if (results.containsKey(key)) {
        subsumes = results.get(key);
      } else {
        subsumes = context.subsumes(opts, new Coding(check.system, check.version, check.parent, null), new Coding(check.system, check.version, check.child, null));
        results.put(key, subsumes);
      }
      // null = can't tell; only report when we know it doesn't
      if (Boolean.FALSE.equals(subsumes)) {
        warning(errors, "2026-10-13", IssueType.BUSINESSRULE, check.stack, false, check.msgId, check.params);
      }
    }
  }

  private SubsumptionCheck subsumptionCheck(CSReference system, String parent, String child, NodeStack stack, String msgId, Object... params) {
    SubsumptionCheck check = new SubsumptionCheck();
    check.system = system.url;
    check.version = system.version;
    check.local = localCodeSystem(system) != null;
    check.parent = parent;
    check.child = child;
    check.stack = stack;
    check.msgId = msgId;
    Object[] p = Arrays.copyOf(params, params.length + 2);
    p[params.length] = parent;
    p[params.length + 1] = child;
    check.params = p;
    return check;
  }

  /**
   * Subsumption rules only apply if the hierarchy is is-a. If the hierarchyMeaning isn't stated,
   * we assume is-a (that's what's observed in practice). If there's no CodeSystem resource
   * (e.g. SNOMED CT), we leave it to the terminology server
   */
  private boolean doesSubsumption(CSReference system) {
    if (system.url == null) {
      return false;
    }
    CodeSystem cs = localCodeSystem(system);
    if (cs == null) {
      return true;
    }
    return !cs.hasHierarchyMeaning() || cs.getHierarchyMeaning() == CodeSystem.CodeSystemHierarchyMeaning.ISA;
  }

  /**
   * The code system, if we have a resource that carries its content (so not the stubs for SNOMED CT,
   * LOINC etc). A fragment counts - subsumption can't be determined from it, but nor can it be
   * determined by sending the fragment to the server
   */
  private CodeSystem localCodeSystem(CSReference system) {
    CodeSystem cs = system.cs != null ? system.cs : context.fetchCodeSystem(system.url, VersionResolutionRules.defaultRule(), system.version, null);
    if (cs == null || isServerSideOnly(cs) || cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
      return null;
    }
    return cs;
  }

  private void checkScopeCoverage(List<ValidationMessage> errors, ValidationOptions options, VSReference sourceScope) {
    if (sourceScope == null || sourceScope.vs == null || noTerminologyChecks) {
      return;
    }
    Map<String, GroupInfo> firstGroup = new LinkedHashMap<>();
    Map<String, Set<String>> covered = new HashMap<>();
    Set<String> allCovered = new HashSet<>();
    for (GroupInfo gi : groupInfos) {
      if (gi.ctxt.source == null || gi.ctxt.source.cs == null || gi.ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) {
        continue;
      }
      String key = gi.ctxt.source.cs.getVersionedUrl();
      firstGroup.putIfAbsent(key, gi);
      Set<String> codes = covered.computeIfAbsent(key, k -> new HashSet<>());
      for (MapRow row : gi.rows) {
        codes.add(row.code);
      }
      if (gi.hasUnmapped) {
        allCovered.add(key);
      }
    }
    int codeLimit = settings.getCodeSystemValidationSizeLimit();
    for (String key : firstGroup.keySet()) {
      if (allCovered.contains(key)) {
        continue;
      }
      GroupInfo gi = firstGroup.get(key);
      CodeSystem cs = gi.ctxt.source.cs;
      List<ConceptDefinitionComponent> concepts = new ArrayList<>();
      listConcepts(concepts, cs.getConceptList());
      if (codeLimit > 0 && concepts.size() > codeLimit) {
        continue;
      }
      Set<String> codes = covered.get(key);
      for (ConceptDefinitionComponent cd : concepts) {
        if (codes.contains(cd.getCode()) || CodeSystemUtilities.isNotSelectable(cs, cd) || CodeSystemUtilities.isInactive(cs, cd)) {
          continue;
        }
        ValidationResult vr = context.validateCode(options.withCheckValueSetOnly().withNoServer(), gi.ctxt.source.url, gi.ctxt.source.version, cd.getCode(), null, sourceScope.vs);
        if (vr.isOk()) {
          hint(errors, "2026-10-13", IssueType.INFORMATIONAL, gi.stack, false, I18nConstants.CONCEPTMAP_QUALITY_SCOPE_UNMAPPED, cd.getCode(), sourceScope.vs.getVersionedUrl());
        }
      }
    }
  }

  private void listConcepts(List<ConceptDefinitionComponent> list, List<ConceptDefinitionComponent> concepts) {
    for (ConceptDefinitionComponent cd : concepts) {
      list.add(cd);
      listConcepts(list, cd.getConceptList());
    }
  }

  private void checkReverseMap(List<ValidationMessage> errors, GroupInfo gi, String url, VSReference sourceScope, VSReference targetScope) {
    if (gi.ctxt.source == null || gi.ctxt.target == null || gi.ctxt.source.url == null || gi.ctxt.target.url == null) {
      return;
    }
    List<ConceptMap> candidates = findReverseMaps(gi, url, sourceScope, targetScope);
    if (candidates.isEmpty()) {
      return;
    }
    if (candidates.size() > 1) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (ConceptMap cm : candidates) {
        b.append(cm.getVersionedUrl());
      }
      hint(errors, "2026-10-13", IssueType.INFORMATIONAL, gi.stack, false, I18nConstants.CONCEPTMAP_QUALITY_REVERSE_MULTIPLE, b.toString());
      return;
    }
    ConceptMap reverse = candidates.get(0);
    String rurl = reverse.getVersionedUrl();

    // index the reverse map: reverse source code (our target) -> [reverse target (our source), relationship]
    Map<String, List<String[]>> byTarget = new HashMap<>();
    Map<String, List<String[]>> bySource = new HashMap<>();
    Set<String> noMaps = new HashSet<>();
    for (ConceptMapGroupComponent g : reverse.getGroupList()) {
      if (!isReverseGroup(gi, g)) {
        continue;
      }
      for (SourceElementComponent e : g.getElementList()) {
        if (!e.hasCode()) {
          continue;
        }
        if (e.getNoMap()) {
          noMaps.add(e.getCode());
        }
        for (TargetElementComponent t : e.getTargetList()) {
          if (t.hasCode() && t.hasRelationship() && t.getDependsOnList().isEmpty() && t.getProductList().isEmpty()) {
            String[] entry = new String[] { e.getCode(), t.getCode(), t.getRelationship().toCode() };
            byTarget.computeIfAbsent(e.getCode(), k -> new ArrayList<>()).add(entry);
            bySource.computeIfAbsent(t.getCode(), k -> new ArrayList<>()).add(entry);
          }
        }
      }
    }

    for (MapRow row : gi.rows) {
      if (row.noMap) {
        // nothing in the target is equivalent to or broader than this code - so the reverse map shouldn't say otherwise
        for (String[] entry : bySource.getOrDefault(row.code, new ArrayList<>())) {
          if (REL_EQUIVALENT.equals(entry[2]) || REL_BROADER.equals(entry[2])) {
            warning(errors, "2026-10-13", IssueType.BUSINESSRULE, row.stack, false, I18nConstants.CONCEPTMAP_QUALITY_NOMAP_REVERSE, row.code, rurl, entry[0], entry[2], inverseRelationship(entry[2]));
          }
        }
      }
      for (MapTarget t : row.targets) {
        if (t.conditional) {
          continue;
        }
        List<String[]> back = new ArrayList<>();
        for (String[] entry : byTarget.getOrDefault(t.code, new ArrayList<>())) {
          if (entry[1].equals(row.code)) {
            back.add(entry);
          }
        }
        if (back.isEmpty()) {
          if (noMaps.contains(t.code) && (REL_EQUIVALENT.equals(t.relationship) || REL_BROADER.equals(t.relationship))) {
            warning(errors, "2026-10-13", IssueType.BUSINESSRULE, t.stack, false, I18nConstants.CONCEPTMAP_QUALITY_REVERSE_INCONSISTENT, row.code, t.code, t.relationship, inverseRelationship(t.relationship), rurl, REL_NOMAP);
          } else if (REL_EQUIVALENT.equals(t.relationship)) {
            hint(errors, "2026-10-13", IssueType.INFORMATIONAL, t.stack, false, I18nConstants.CONCEPTMAP_QUALITY_REVERSE_MISSING, row.code, t.code, t.relationship, rurl);
          }
        } else {
          for (String[] entry : back) {
            if (!relationshipsConsistent(t.relationship, entry[2])) {
              warning(errors, "2026-10-13", IssueType.BUSINESSRULE, t.stack, false, I18nConstants.CONCEPTMAP_QUALITY_REVERSE_INCONSISTENT, row.code, t.code, t.relationship, inverseRelationship(t.relationship), rurl, entry[2]);
            }
          }
        }
      }
    }
  }

  /**
   * A map from a code system to itself has to say which way it goes - by version, or by scope - or it's
   * not usable, and there's no way to tell a reverse map from another map going the same way
   *
   * @return true if the group has a direction, so reverse checking can proceed
   */
  private boolean checkDirection(List<ValidationMessage> errors, GroupInfo gi, VSReference sourceScope, VSReference targetScope) {
    if (gi.ctxt.source == null || gi.ctxt.target == null || gi.ctxt.source.url == null || !gi.ctxt.source.url.equals(gi.ctxt.target.url)) {
      return true;
    }
    boolean ok = versionsDiffer(gi) || (sourceScope != null && targetScope != null && sourceScope.url != null && targetScope.url != null
        && !(sourceScope.url + "|" + sourceScope.version).equals(targetScope.url + "|" + targetScope.version));
    warning(errors, "2026-10-15", IssueType.BUSINESSRULE, gi.stack, ok, I18nConstants.CONCEPTMAP_QUALITY_SAME_SYSTEM_UNDIRECTED, gi.ctxt.source.url);
    return ok;
  }

  private boolean versionsDiffer(GroupInfo gi) {
    return gi.ctxt.source.version != null && gi.ctxt.target.version != null && !gi.ctxt.source.version.equals(gi.ctxt.target.version);
  }

  /**
   * A reverse map is one whose group goes from our target system to our source system, and whose scopes
   * (if either map has them) are our scopes, reversed
   */
  private List<ConceptMap> findReverseMaps(GroupInfo gi, String url, VSReference sourceScope, VSReference targetScope) {
    List<ConceptMap> res = new ArrayList<>();
    for (ConceptMap cm : context.fetchResourcesByType(ConceptMap.class)) {
      if (url != null && url.equals(cm.getUrl())) {
        continue;
      }
      boolean groupMatches = false;
      for (ConceptMapGroupComponent g : cm.getGroupList()) {
        if (isReverseGroup(gi, g)) {
          groupMatches = true;
          break;
        }
      }
      if (groupMatches && scopeMatches(sourceScope, cm.getTargetScope()) && scopeMatches(targetScope, cm.getSourceScope()) && !res.contains(cm)) {
        res.add(cm);
      }
    }
    return res;
  }

  /**
   * Versions have to match where both sides state them. For a map from a code system to itself that
   * is directed by version, the other group has to state them too (or it could be going either way)
   */
  private boolean isReverseGroup(GroupInfo gi, ConceptMapGroupComponent g) {
    boolean strict = gi.ctxt.source.url.equals(gi.ctxt.target.url) && versionsDiffer(gi);
    return systemMatches(gi.ctxt.target.url, gi.ctxt.target.version, g.getSource(), strict)
        && systemMatches(gi.ctxt.source.url, gi.ctxt.source.version, g.getTarget(), strict);
  }

  private boolean systemMatches(String url, String version, String canonical, boolean strict) {
    if (url == null || canonical == null) {
      return false;
    }
    String curl = canonical.contains("|") ? canonical.substring(0, canonical.indexOf("|")) : canonical;
    String cver = canonical.contains("|") ? canonical.substring(canonical.indexOf("|") + 1) : null;
    if (!url.equals(curl)) {
      return false;
    }
    if (version == null || cver == null) {
      return !strict;
    }
    return version.equals(cver);
  }

  private boolean scopeMatches(VSReference scope, DataType other) {
    String o = other == null ? null : other.primitiveValue();
    if (scope == null || scope.url == null) {
      return o == null;
    }
    if (o == null) {
      return false;
    }
    String ourl = o.contains("|") ? o.substring(0, o.indexOf("|")) : o;
    String over = o.contains("|") ? o.substring(o.indexOf("|") + 1) : null;
    return scope.url.equals(ourl) && (scope.version == null || over == null || scope.version.equals(over));
  }
}