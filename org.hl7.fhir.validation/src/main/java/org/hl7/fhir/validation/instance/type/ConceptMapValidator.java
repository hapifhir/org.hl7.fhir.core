package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.CodingValidationRequest;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.VSCodingValidationRequest;
import org.hl7.fhir.validation.instance.utils.NodeStack;


public class ConceptMapValidator  extends BaseValidator {

  private static final int TOO_MANY_CODES_TO_VALIDATE = 500;
  
  public static class PropertyDefinition {
    private String type;
    private String system;
    private CodeSystem cs;
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
    
  }
  

  public class CMCodingValidationRequest extends CodingValidationRequest {

    private NodeStack stack;

    public CMCodingValidationRequest(NodeStack stack, Coding code, ValueSet vs) {
      super(code, vs);
      this.stack = stack;
    }

    public NodeStack getStack() {
      return stack;
    }
  }

  private List<CMCodingValidationRequest> batch = new ArrayList<>();
  
  public ConceptMapValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateConceptMap(List<ValidationMessage> errors, Element cm, NodeStack stack, ValidationOptions options) {
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
    VSReference sourceScope = readVSReference(cm, "sourceScope", "source");
    VSReference targetScope = readVSReference(cm, "targetScope", "target");

    List<Element> groups = cm.getChildrenByName("group");
    int ci = 0;
    for (Element group : groups) {
      ok = validateGroup(errors, group, stack.push(group, ci, null, null), props, attribs, options, sourceScope, targetScope) && ok;
      ci++;
    }    

    if (!stack.isContained()) {
      ok = checkShareableConceptMap(errors, cm, stack) && ok;
    }
    
    if (!batch.isEmpty()) {
      if (batch.size() > TOO_MANY_CODES_TO_VALIDATE) {
        ok = hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CONCEPTMAP_VS_TOO_MANY_CODES, batch.size()) && ok;
      } else {
        try {
          long t = System.currentTimeMillis();
          context.validateCodeBatch(ValidationOptions.defaults(), batch, null);
          if (isDebug()) {
            System.out.println("  :   .. "+(System.currentTimeMillis()-t)+"ms");
          }
          for (CMCodingValidationRequest cv : batch) {
            if (cv.getCoding().getVersion() == null) {
              ok = rule(errors, "2023-09-06", IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.CONCEPTMAP_VS_INVALID_CONCEPT_CODE, cv.getCoding().getSystem(), cv.getCoding().getCode(), cv.getVsObj().getUrl()) && ok;
            } else {
              ok = rule(errors, "2023-09-06", IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.CONCEPTMAP_VS_INVALID_CONCEPT_CODE_VER, cv.getCoding().getSystem(), cv.getCoding().getVersion(), cv.getCoding().getCode(), cv.getVsObj().getUrl()) && ok;
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


  private VSReference readVSReference(Element cm, String... names) {
    for (String n : names) {
      if (cm.hasChild(n)) {
        Element e = cm.getNamedChild(n);
        String ref = null;
        if (e.isPrimitive()) {
          ref = e.primitiveValue();
        } else if (e.hasChild("reference")) {
          ref = e.getNamedChildValue("reference");
        }
        if (ref != null) {
          VSReference res = new VSReference();
          if (ref.contains("|")) {
            res.url = ref.substring(0, ref.indexOf("|"));
            res.version = ref.substring(ref.indexOf("|")+1);
            res.vs = context.fetchResource(ValueSet.class, res.url, res.version);            
          } else {
            res.url = ref;
            res.vs = context.fetchResource(ValueSet.class, res.url);
          }
          return res;
        }
      }
    }
    return null;
  }

  private boolean validateGroup(List<ValidationMessage> errors, Element grp, NodeStack stack, Map<String, PropertyDefinition> props, Map<String, String> attribs, ValidationOptions options, VSReference sourceScope, VSReference targetScope) {
    boolean ok = true;
    GroupContext ctxt = new GroupContext();
    ctxt.sourceScope = sourceScope;
    ctxt.targetScope = targetScope;
    
    Element e = grp.getNamedChild("source");
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_MISSING)) {
      ctxt.source = readCSReference(e, grp.getNamedChild("sourceVersion"));
      if (ctxt.source.cs != null) {
        if (ctxt.source.cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
          ctxt.source.cs = null;
        } else if (!warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), isOkCodeSystem(ctxt.source.cs), I18nConstants.CONCEPTMAP_GROUP_SOURCE_INCOMPLETE, e.getValue(), ctxt.source.cs.getContent().toCode())) {
          ctxt.source.cs = null;
        }
      } else {
        warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), sourceScope != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_UNKNOWN, e.getValue());
      }
    }
    e = grp.getNamedChild("target");
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_MISSING)) {
      ctxt.target = readCSReference(e, grp.getNamedChild("targetVersion"));
      if (ctxt.target.cs != null) {                              
        if (ctxt.target.cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
          ctxt.target.cs = null;
        } else if (!warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), isOkCodeSystem(ctxt.target.cs), I18nConstants.CONCEPTMAP_GROUP_TARGET_INCOMPLETE, e.getValue(), ctxt.target.cs.getContent().toCode())) {
          ctxt.target.cs = null;
        }
      } else {
        warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), targetScope != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_UNKNOWN, e.getValue());                              
        
      }
    }
    List<Element> elements = grp.getChildrenByName("element");
    int ci = 0;
    for (Element element : elements) {
      ok = validateGroupElement(errors, element, stack.push(element, ci, null, null), props, attribs, options, ctxt) && ok;
      ci++;
    }    
    return ok;
  }

  private CSReference readCSReference(Element ref, Element version) {
    CSReference res = new CSReference();
    res.url = ref.primitiveValue();
    if (version != null) {
      res.version = version.primitiveValue(); 
    } else if (res.url.contains("|")) {
      res.version = res.url.substring(res.url.indexOf("|")+1);
      res.url = res.url.substring(0, res.url.indexOf("|"));
    }
    res.cs = context.fetchCodeSystem(res.url, res.version);
    return res;
  }

  private boolean isOkCodeSystem(CodeSystem tgtCS) {
    return tgtCS.getContent() != CodeSystemContentMode.EXAMPLE && tgtCS.getContent() != CodeSystemContentMode.FRAGMENT;
  }

  private boolean validateGroupElement(List<ValidationMessage> errors, Element src, NodeStack stack, Map<String, PropertyDefinition> props, Map<String, String> attribs, ValidationOptions options, GroupContext ctxt) {
    boolean ok = true;
    
    Element code = src.getNamedChild("code");
    if (code != null) {
      NodeStack cstack = stack.push(code, -1, null, null);
      if (ctxt.hasSourceCS()) {
        String c = code.getValue();
        ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(ctxt.source.cs, c);
        if (warningOrError(ctxt.source.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID, c, ctxt.source.cs.getVersionedUrl())) {
          Element display = src.getNamedChild("display");
          if (display != null) {
            warning(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), CodeSystemUtilities.checkDisplay(ctxt.source.cs, cd, display.getValue()), I18nConstants.CONCEPTMAP_GROUP_SOURCE_DISPLAY_INVALID, display.getValue(), CodeSystemUtilities.getDisplays(ctxt.source.cs, cd));
          }
          if (ctxt.hasSourceVS() && ctxt.source != null) {
            ValidationResult vr = context.validateCode(options.withCheckValueSetOnly().withNoServer(), ctxt.source.url, ctxt.source.version, c, null, ctxt.sourceScope.vs);
            if (!warningOrError(ctxt.source.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-09-06", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID_VS, c, ctxt.sourceScope.vs.getVersionedUrl())) {
              ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) & ok;
            }
          }
        } else {
          ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) & ok;
        }
      } else {
        addToBatch(code, cstack, ctxt.source, ctxt.sourceScope);
      }
    }
    
    List<Element> targets = src.getChildrenByName("target");
    int ci = 0;
    for (Element target : targets) {
      ok = validateGroupElementTarget(errors, target, stack.push(target, ci, null, null), props, attribs, options, ctxt) && ok;
      ci++;
    }    
    return ok;
  }
  
  private boolean validateGroupElementTarget(List<ValidationMessage> errors, Element tgt, NodeStack stack, Map<String, PropertyDefinition> props, Map<String, String> attribs, ValidationOptions options, GroupContext ctxt) {
    boolean ok = true;

    Element code = tgt.getNamedChild("code");
    if (code != null) {
      NodeStack cstack = stack.push(code, -1, null, null);
      if (ctxt.hasTargetCS()) {
        String c = code.getValue();
        ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(ctxt.target.cs, c);
        if (warningOrError(ctxt.target.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_INVALID, c, ctxt.target.cs.getVersionedUrl())) {
          Element display = tgt.getNamedChild("display");
          if (display != null) {          
            warning(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), CodeSystemUtilities.checkDisplay(ctxt.target.cs, cd, display.getValue()), I18nConstants.CONCEPTMAP_GROUP_TARGET_DISPLAY_INVALID, display.getValue(), CodeSystemUtilities.getDisplays(ctxt.target.cs, cd));
          }
          if (ctxt.hasTargetVS() && ctxt.target != null) {
            ValidationResult vr = context.validateCode(options.withCheckValueSetOnly().withNoServer(), ctxt.target.url, ctxt.target.version, c, null, ctxt.targetScope.vs);
            if (!warningOrError(ctxt.target.cs.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-09-06", IssueType.REQUIRED, code.line(), code.col(), cstack.getLiteralPath(), vr.isOk(), I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID_VS, c, ctxt.targetScope.vs.getVersionedUrl())) {
              ok = (ctxt.target.cs.getContent() != CodeSystemContentMode.COMPLETE) && ok;
            }
          }
        } else {
          ok = (ctxt.source.cs.getContent() != CodeSystemContentMode.COMPLETE) & ok;
        }
      } else {
        addToBatch(code, cstack, ctxt.target, ctxt.targetScope);
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
    Element codeE = property.getNamedChild("code");
    Element valueE = property.getNamedChild("value");
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
    Element codeE = attribute.getNamedChild("attribute");
    Element valueE = attribute.getNamedChild("value");
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
    if (parent.isForPublication()) { 
      if (isHL7(cs)) {
        boolean ok = true;
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "title") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.CONCEPTMAP_SHAREABLE_EXTRA_MISSING_HL7, "name");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "description") && ok; 
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.CONCEPTMAP_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "description"); 
      }
    }
    return true;
  }



  private void addToBatch(Element code, NodeStack stack, CSReference system, VSReference scope) {
    if (scope != null && scope.vs != null && system != null) {
      Coding c = new Coding(system.url, code.primitiveValue(), null).setVersion(system.version);
      batch.add(new CMCodingValidationRequest(stack, c, scope.vs));
    }    
  }

}