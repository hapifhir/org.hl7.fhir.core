package org.hl7.fhir.validation.instance.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class ConceptMapValidator  extends BaseValidator {

  private InstanceValidator parent;

  public ConceptMapValidator(IWorkerContext context, TimeTracker timeTracker, InstanceValidator parent, XVerExtensionManager xverManager, Coding jurisdiction) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
    this.parent = parent;
  }

  public boolean validateConceptMap(List<ValidationMessage> errors, Element cm, NodeStack stack, ValidationOptions options) {
    boolean ok = true;
    Map<String, String> props = new HashMap<>();
    Map<String, String> attribs = new HashMap<>();
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


  private boolean validateGroup(List<ValidationMessage> errors, Element grp, NodeStack stack, Map<String, String> props, Map<String, String> attribs) {
    boolean ok = true;
    CodeSystem srcCS = null;
    CodeSystem tgtCS = null;
    Element e = grp.getNamedChild("source");
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_MISSING)) {
      srcCS = context.fetchCodeSystem(e.getValue());
      warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), srcCS != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_UNKNOWN, e.getValue());                      
    }
    e = grp.getNamedChild("target");
    if (warning(errors, "2023-03-05", IssueType.REQUIRED, grp.line(), grp.col(), stack.getLiteralPath(), e != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_MISSING)) {
      tgtCS = context.fetchCodeSystem(e.getValue());
      warning(errors, "2023-03-05", IssueType.NOTFOUND, grp.line(), grp.col(), stack.push(e, -1, null, null).getLiteralPath(), tgtCS != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_UNKNOWN, e.getValue());                      
    }
    List<Element> elements = grp.getChildrenByName("element");
    int ci = 0;
    for (Element element : elements) {
      ok = validateGroupElement(errors, element, stack.push(element, ci, null, null), srcCS, tgtCS, props, attribs) && ok;
      ci++;
    }    
    return ok;
  }

  private boolean validateGroupElement(List<ValidationMessage> errors, Element src, NodeStack stack, CodeSystem srcCS, CodeSystem tgtCS, Map<String, String> props, Map<String, String> attribs) {
    boolean ok = true;
    
    Element code = src.getNamedChild("code");
    if (code != null && srcCS != null) {
      String c = code.getValue();
      ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(srcCS, c);
      if (rule(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_SOURCE_CODE_INVALID, c, srcCS.getVersionedUrl())) {
        Element display = src.getNamedChild("display");
        if (display != null) {
          List<String> displays = CodeSystemUtilities.getDisplays(srcCS, cd);
          ok = rule(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), displays.contains(display.getValue()), I18nConstants.CONCEPTMAP_GROUP_SOURCE_DISPLAY_INVALID, display.getValue(), displays) && ok;
        }
      } else {
        ok = false;
      }
    }
    
    List<Element> targets = src.getChildrenByName("target");
    int ci = 0;
    for (Element target : targets) {
      ok = validateGroupTargetElement(errors, target, stack.push(target, ci, null, null), srcCS, tgtCS, props, attribs) && ok;
      ci++;
    }    
    return ok;
  }
  
  private boolean validateGroupTargetElement(List<ValidationMessage> errors, Element tgt, NodeStack stack, CodeSystem srcCS, CodeSystem tgtCS, Map<String, String> props, Map<String, String> attribs) {
    boolean ok = true;

    Element code = tgt.getNamedChild("code");
    if (code != null && tgtCS != null) {
      String c = code.getValue();
      ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(tgtCS, c);
      if (rule(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), cd != null, I18nConstants.CONCEPTMAP_GROUP_TARGET_CODE_INVALID, c, tgtCS.getVersionedUrl())) {
        Element display = tgt.getNamedChild("display");
        if (display != null) {
          List<String> displays = CodeSystemUtilities.getDisplays(tgtCS, cd);
          ok = rule(errors, "2023-03-05", IssueType.REQUIRED, code.line(), code.col(), stack.push(code, -1, null, null).getLiteralPath(), displays.contains(display.getValue()), I18nConstants.CONCEPTMAP_GROUP_TARGET_DISPLAY_INVALID, display.getValue(), displays) && ok;
        }
      } else {
        ok = false;
      }
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
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("content"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "content") && ok; 
        if (!"supplement".equals(cs.getChildValue("content"))) {
          ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("caseSensitive"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING_HL7, "caseSensitive") && ok;
        }
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.CONCEPTMAP_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "description"); 
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("content"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "content"); 
        if (!"supplement".equals(cs.getChildValue("content"))) {
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("caseSensitive"), I18nConstants.CONCEPTMAP_SHAREABLE_MISSING, "caseSensitive");
        }
      }
    }
    return true;
  }


}