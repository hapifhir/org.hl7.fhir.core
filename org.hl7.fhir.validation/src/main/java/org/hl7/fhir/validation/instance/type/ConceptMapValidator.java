package org.hl7.fhir.validation.instance.type;

import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
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

  private static final int TOO_MANY_CODES_TO_VALIDATE = 500;
  
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
  
  public ConceptMapValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateConceptMap(ValidationContext valContext, List<ValidationMessage> errors, Element cm, NodeStack stack, ValidationOptions options) {
    boolean ok = true;
    Map<String, PropertyDefinition> props = new HashMap<>();
    Map<String, String> attribs = new HashMap<>();
    
    if (VersionUtilities.isR5Plus(context.getVersion())) {
      List<Element> properties = cm.getChildrenByName("property");
      int ci = 0;
      for (Element property : properties) {
        String code = property.getChildValue("code");
        String type = property.getChildValue("type");
        String system = property.getChildValue("system");
        CodeSystem cs = system != null ? context.fetchCodeSystem(system) : null;
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
      if (batch.size() > TOO_MANY_CODES_TO_VALIDATE) {
        ok = hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CONCEPTMAP_VS_TOO_MANY_CODES, batch.size()) && ok;
      } else if (!noTerminologyChecks) {
        try {
          long t = System.currentTimeMillis();
          context.validateCodeBatch(ValidationOptions.defaults(), batch, null, false);
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
    return ok;
  }


  private VSReference readVSReference(List<ValidationMessage> errors, NodeStack stack,BooleanHolder bok, Element cm, String... names) {
    for (String n : names) {
      if (cm.hasChild(n, false)) {
        Element e = cm.getNamedChild(n, false);
        String ref = null;
        if (e.isPrimitive()) {
          ref = e.primitiveValue();
        } else if (e.hasChild("reference", false)) {
          ref = e.getNamedChildValue("reference", false);
        }
        if (ref != null) {
          VSReference res = new VSReference();
          if (ref.contains("|")) {
            res.url = ref.substring(0, ref.indexOf("|"));
            res.version = ref.substring(ref.indexOf("|")+1);
            Resource r = context.fetchResource(Resource.class, res.url, res.version, null);
            if (r != null) {
              if (r instanceof ValueSet) {
                res.vs = (ValueSet) r;
              } else {
                bok.fail();
                rule(errors, "2025-12-31", IssueType.INVALID, stack.getLiteralPath()+"."+n, false, I18nConstants.CONCEPTMAP_VS_NOT_A_VS, r.fhirType());
              }
            } 
            if (res.vs == null) {
              res.vs = context.findTxResource(ValueSet.class, res.url, res.version, null);
            }
          } else {
            res.url = ref;
            Resource r = context.fetchResource(Resource.class, res.url);
            if (r != null) {
              if (r instanceof ValueSet) {
                res.vs = (ValueSet) r;
              } else {
                bok.fail();
                rule(errors, "2025-12-31", IssueType.INVALID, stack.getLiteralPath()+"."+n, false, I18nConstants.CONCEPTMAP_VS_NOT_A_VS, r.fhirType());
              }
            } 
            if (res.vs == null) {
              res.vs = context.findTxResource(ValueSet.class, res.url);
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
      if (fetcher != null && ctxt.source.version == null && ctxt.source.cs != null && !CodeSystemUtilities.isExemptFromMultipleVersionChecking(ctxt.source.url) && fetcher != null) {
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
      if (fetcher != null && ctxt.target.version == null && ctxt.target.cs != null && !CodeSystemUtilities.isExemptFromMultipleVersionChecking(ctxt.target.url)) {
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
    return ok;
  }

  private boolean isServerSideOnly(CodeSystem cs) {
    return Utilities.existsInList(cs.getUrl(), "http://snomed.info/sct", "http://loinc.org");
  }

  private CSReference readCSReference(Element ref, Element version, ValueSet vs) {
    CSReference res = new CSReference();
    res.url = ref.primitiveValue();
    if (version != null) {
      res.version = version.primitiveValue(); 
    } else if (res.url.contains("|")) {
      res.version = res.url.substring(res.url.indexOf("|")+1);
      res.url = res.url.substring(0, res.url.indexOf("|"));
    } else if (vs != null && res.url  != null) {
      for (ConceptSetComponent vsi : vs.getCompose().getInclude()) {
        if (res.url.equals(vsi.getSystem()) && vsi.hasVersion() ) {
          res.version = vsi.getVersion();
        }
      }
    }
    res.cs = context.fetchCodeSystem(res.url, res.version, vs);
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
            if (!warningOrError(ctxt.source.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-09-06", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID_VS, c, ctxt.sourceScope.vs.getVersionedUrl())) {
              ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) & ok;
            } else {
              // processConceptIssues(errors, concept, stack, system, version, vv, display);
            }
          }
        } else {
          ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) & ok;
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
        relationships.see(source, "unmapped");
      } else if (!relationships.get(source).equals("unmapped")) {
        warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, code.primitiveValue());            
      } else {
        warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION, source, code.primitiveValue());            
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
            if (!warningOrError(ctxt.target.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-09-06", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_INVALID_VS, c, ctxt.targetScope.vs.getVersionedUrl())) {
              ok = (ctxt.target.cs.getContent() != CodeSystemContentMode.COMPLETE) && ok;
            }
          }
        } else {
          ok = (ctxt.target.cs.getContent() != CodeSystemContentMode.COMPLETE) & ok;
        }
      } else {
        addToBatch(errors, baseStack, code, cstack, ctxt.target, ctxt.targetScope);
      }
    } 
    
    String target = tgt.getNamedChildValue("code");
    String tgtForMsg = target == null ? "--" : target;
    String reln = tgt.getNamedChildValue(VersionUtilities.isR5Plus(context.getVersion()) ? "relationship" : "equivalence");
    
    if (source != null && reln != null) {
      if (target == null) {
        if (!relationships.has(source)) {
          relationships.see(source, reln);
        } else if (relationships.get(source).equals(reln)) {
          warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION, source, tgtForMsg);            
        } else {
          warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, tgtForMsg, reln, relationships.get(source));            
        }
      } else {
        if (relationships.has(source)) {
          warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, tgtForMsg, reln, relationships.get(source));            
        }
        if (relationships.has(source, target)) {
          if (relationships.get(source, target).equals(reln)) {
            warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION_DIFFERENT, source, tgtForMsg, reln, relationships.get(source, target));
          } else {
            warning(errors, "2023-03-05", IssueType.BUSINESSRULE, stack, false, I18nConstants.CONCEPTMAP_GROUP_TARGET_DUPLICATION, source, tgtForMsg);            
          }
        } else {
          relationships.see(source, target, reln);
        }
      }
    }

    if (VersionUtilities.isR5Plus(context.getVersion())) {
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
                CodeSystemUtilities.findCode(defn.getCs().getConcept(), valueE.getValue()) != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_PROPERTY_CODE_INVALID, valueE.getValue(), defn.getCs().getVersionedUrl()) && ok;
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
        IWorkerContext.SystemSupportInformation txInfo = context.getTxSupportInfo(system.url, system.version);
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
}