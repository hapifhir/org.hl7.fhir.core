package org.hl7.fhir.validation.instance.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
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
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.type.ConceptMapValidator.PropertyDefinition;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class ConceptMapValidator  extends BaseValidator {

  public class PropertyDefinition {
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

  private InstanceValidator parent;

  public ConceptMapValidator(IWorkerContext context, boolean debug, TimeTracker timeTracker, InstanceValidator parent, XVerExtensionManager xverManager, Coding jurisdiction) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
    this.parent = parent;
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
    List<Element> groups = cm.getChildrenByName("group");
    int ci = 0;
    for (Element group : groups) {
      ok = validateGroup(errors, group, stack.push(group, ci, null, null), props, attribs) && ok;
      ci++;
    }    

    if (!stack.isContained()) {
      ok = checkShareableConceptMap(errors, cm, stack) && ok;
    }
    return ok;
  }


  private boolean validateGroup(List<ValidationMessage> errors, Element grp, NodeStack stack, Map<String, PropertyDefinition> props, Map<String, String> attribs) {
    boolean ok = true;
    CodeSystem srcCS = null;
    CodeSystem tgtCS = null;
    Element e = grp.getNamedChild("source");
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_MISSING)) {
      srcCS = context.fetchCodeSystem(e.getValue());
      if (warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), srcCS != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_UNKNOWN, e.getValue())) {
        if (srcCS.getContent() == CodeSystemContentMode.NOTPRESENT) {
          srcCS = null;
        } else if (!warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), isOkCodeSystem(srcCS), I18nConstants.CONCEPTMAP_GROUP_SOURCE_INCOMPLETE, e.getValue(), srcCS.getContent().toCode())) {
          srcCS = null;
        }
      };                      
    }
    e = grp.getNamedChild("target");
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_MISSING)) {
      tgtCS = context.fetchCodeSystem(e.getValue());
      if (warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), tgtCS != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_UNKNOWN, e.getValue())) {                              
        if (tgtCS.getContent() == CodeSystemContentMode.NOTPRESENT) {
          tgtCS = null;
        } else if (!warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), isOkCodeSystem(tgtCS), I18nConstants.CONCEPTMAP_GROUP_TARGET_INCOMPLETE, e.getValue(), tgtCS.getContent().toCode())) {
          tgtCS = null;
        }
      }
    }
    List<Element> elements = grp.getChildrenByName("element");
    int ci = 0;
    for (Element element : elements) {
      ok = validateGroupElement(errors, element, stack.push(element, ci, null, null), srcCS, tgtCS, props, attribs) && ok;
      ci++;
    }    
    return ok;
  }

  private boolean isOkCodeSystem(CodeSystem tgtCS) {
    return tgtCS.getContent() != CodeSystemContentMode.EXAMPLE && tgtCS.getContent() != CodeSystemContentMode.FRAGMENT;
  }

  private boolean validateGroupElement(List<ValidationMessage> errors, Element src, NodeStack stack, CodeSystem srcCS, CodeSystem tgtCS, Map<String, PropertyDefinition> props, Map<String, String> attribs) {
    boolean ok = true;
    
    Element code = src.getNamedChild("code");
    if (code != null && srcCS != null) {
      String c = code.getValue();
      ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(srcCS, c);
      if (warningOrError(srcCS.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID, c, srcCS.getVersionedUrl())) {
        Element display = src.getNamedChild("display");
        if (display != null) {
          warning(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), CodeSystemUtilities.checkDisplay(srcCS, cd, display.getValue()), I18nConstants.CONCEPTMAP_GROUP_SOURCE_DISPLAY_INVALID, display.getValue(), CodeSystemUtilities.getDisplays(srcCS, cd));
        }
      } else {
        ok = false;
      }
    }
    
    List<Element> targets = src.getChildrenByName("target");
    int ci = 0;
    for (Element target : targets) {
      ok = validateGroupElementTarget(errors, target, stack.push(target, ci, null, null), srcCS, tgtCS, props, attribs) && ok;
      ci++;
    }    
    return ok;
  }
  
  private boolean validateGroupElementTarget(List<ValidationMessage> errors, Element tgt, NodeStack stack, CodeSystem srcCS, CodeSystem tgtCS, Map<String, PropertyDefinition> props, Map<String, String> attribs) {
    boolean ok = true;

    Element code = tgt.getNamedChild("code");
    if (code != null && tgtCS != null) {
      String c = code.getValue();
      ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(tgtCS, c);
      if (warningOrError(tgtCS.getContent() == CodeSystemContentMode.COMPLETE, errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_INVALID, c, tgtCS.getVersionedUrl())) {
        Element display = tgt.getNamedChild("display");
        if (display != null) {          
          warning(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), CodeSystemUtilities.checkDisplay(tgtCS, cd, display.getValue()), I18nConstants.CONCEPTMAP_GROUP_TARGET_DISPLAY_INVALID, display.getValue(), CodeSystemUtilities.getDisplays(tgtCS, cd));
        }
      } else {
        ok = false;
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


}