package org.hl7.fhir.validation.instance.type;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ValueSet;
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

public class CodeSystemValidator  extends BaseValidator {

  private InstanceValidator parent;

  public CodeSystemValidator(IWorkerContext context, boolean debug, TimeTracker timeTracker, InstanceValidator parent, XVerExtensionManager xverManager, Coding jurisdiction) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
    this.jurisdiction = jurisdiction;
    this.parent = parent;

  }

  public boolean validateCodeSystem(List<ValidationMessage> errors, Element cs, NodeStack stack, ValidationOptions options) {
    boolean ok = true;
    String url = cs.getNamedChildValue("url");
    String content = cs.getNamedChildValue("content");
    String caseSensitive = cs.getNamedChildValue("caseSensitive");
    String hierarchyMeaning = cs.getNamedChildValue("hierarchyMeaning");
    String supp = cs.getNamedChildValue("supplements");

    metaChecks(errors, cs, stack, url, content, caseSensitive, hierarchyMeaning, !Utilities.noString(supp));

    String vsu = cs.getNamedChildValue("valueSet");
    if (!Utilities.noString(vsu)) {
      hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), "complete".equals(content), I18nConstants.CODESYSTEM_CS_NO_VS_NOTCOMPLETE);
      ValueSet vs;
      try {
        vs = context.fetchResourceWithException(ValueSet.class, vsu);
      } catch (FHIRException e) {
        vs = null;
      }
      if (vs != null) {
        if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.hasCompose(), I18nConstants.CODESYSTEM_CS_VS_INVALID, url, vsu)) { 
          if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getCompose().getInclude().size() == 1, I18nConstants.CODESYSTEM_CS_VS_INVALID, url, vsu)) {
            if (rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getCompose().getInclude().get(0).getSystem().equals(url), I18nConstants.CODESYSTEM_CS_VS_WRONGSYSTEM, url, vsu, vs.getCompose().getInclude().get(0).getSystem())) {
              ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), !vs.getCompose().getInclude().get(0).hasValueSet()
                  && !vs.getCompose().getInclude().get(0).hasConcept() && !vs.getCompose().getInclude().get(0).hasFilter(), I18nConstants.CODESYSTEM_CS_VS_INCLUDEDETAILS, url, vsu) && ok;
              if (vs.hasExpansion()) {
                int count = countConcepts(cs); 
                ok = rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getExpansion().getContains().size() == count, I18nConstants.CODESYSTEM_CS_VS_EXP_MISMATCH, url, vsu, count, vs.getExpansion().getContains().size()) && ok;
              }
            } else {
              ok = false;
            }
          } else {
            ok = false;
          }
        } else {
          ok = false;
        }
      }
    } // todo... try getting the value set the other way...

    if (supp != null) {
      if (context.supportsSystem(supp)) {
        List<Element> concepts = cs.getChildrenByName("concept");
        int ce = 0;
        for (Element concept : concepts) {
          ok = validateSupplementConcept(errors, concept, stack.push(concept, ce, null, null), supp, options) && ok;
          ce++;
        }    
      } else {
        if (cs.hasChildren("concept")) {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_SUPP_CANT_CHECK, supp);
        }
      }
    }

    if (!stack.isContained()) {
      ok = checkShareableCodeSystem(errors, cs, stack) && ok;
    }
    return ok;
  }


  private boolean checkShareableCodeSystem(List<ValidationMessage> errors, Element cs, NodeStack stack) {
    if (parent.isForPublication()) { 
      if (isHL7(cs)) {
        boolean ok = true;
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "title") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.CODESYSTEM_SHAREABLE_EXTRA_MISSING_HL7, "name");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "description") && ok; 
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("content"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "content") && ok; 
        if (!"supplement".equals(cs.getChildValue("content"))) {
          ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("caseSensitive"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "caseSensitive") && ok;
        }
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name"), I18nConstants.CODESYSTEM_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "description"); 
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("content"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "content"); 
        if (!"supplement".equals(cs.getChildValue("content"))) {
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("caseSensitive"), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "caseSensitive");
        }
      }
    }
    return true;
  }
  
  private void metaChecks(List<ValidationMessage> errors, Element cs, NodeStack stack, String url,  String content, String caseSensitive, String hierarchyMeaning, boolean isSupplement) {
    if (isSupplement) {
      if (!"supplement".equals(content)) {
        NodeStack s = stack.push(cs.getNamedChild("content"), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL_WRONG);
      }
      if (!Utilities.noString(caseSensitive)) {
        NodeStack s = stack.push(cs.getNamedChild("caseSensitive"), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL, "caseSensitive");
      }
      if (!Utilities.noString(hierarchyMeaning)) {
        NodeStack s = stack.push(cs.getNamedChild("hierarchyMeaning"), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL, "hierarchyMeaning");
      }

    } else {
      boolean isHL7 = url != null && (url.contains("hl7.org") || url.contains("fhir.org"));
      if (Utilities.noString(content)) {
        NodeStack s = stack;
        Element c = cs.getNamedChild("content");
        if (c != null) {
          s = stack.push(c, -1, null, null);
        }
        if (isHL7) {
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_MISSING_ELEMENT_SHALL, "content");
        } else {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_NONHL7_MISSING_ELEMENT, "content");          
        } 
      } else if ("supplement".equals(content)) {
        NodeStack s = stack.push(cs.getNamedChild("content"), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL_MISSING);        
      }
      if (Utilities.noString(caseSensitive)) {
        NodeStack s = stack;
        Element c = cs.getNamedChild("caseSensitive");
        if (c != null) {
          s = stack.push(c, -1, null, null);
        }
        if (isHL7) {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_MISSING_ELEMENT_SHOULD, "caseSensitive");
        } else {
          hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_NONHL7_MISSING_ELEMENT, "caseSensitive");          
        } 
      }      
      if (Utilities.noString(hierarchyMeaning) && hasHeirarchy(cs)) {
        NodeStack s = stack;
        Element c = cs.getNamedChild("hierarchyMeaning");
        if (c != null) {
          s = stack.push(c, -1, null, null);
        }
        if (isHL7) {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_MISSING_ELEMENT_SHOULD, "hierarchyMeaning");
        } else {
          hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_NONHL7_MISSING_ELEMENT, "hierarchyMeaning");          
        } 
      }     
    }
  }


  private boolean hasHeirarchy(Element cs) {
    for (Element c : cs.getChildren("concept")) {
      if (c.hasChildren("concept")) {
        return true;
      }
    }
    return false;
  }

  private boolean validateSupplementConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String supp, ValidationOptions options) {
    String code = concept.getChildValue("code");
    if (!Utilities.noString(code)) {
      org.hl7.fhir.r5.context.IWorkerContext.ValidationResult res = context.validateCode(options, systemFromCanonical(supp), versionFromCanonical(supp), code, null);
      return rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), res.isOk(), I18nConstants.CODESYSTEM_CS_SUPP_INVALID_CODE, supp, code);
    } else {
      return true;
    }

  }

  private int countConcepts(Element cs) {
    List<Element> concepts = cs.getChildrenByName("concept");
    int res = concepts.size();
    for (Element concept : concepts) {
      res = res + countConcepts(concept);
    }
    return res;
  }


}