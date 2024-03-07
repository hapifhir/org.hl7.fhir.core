package org.hl7.fhir.validation.instance.type;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class CodeSystemValidator  extends BaseValidator {

  public CodeSystemValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateCodeSystem(ValidationContext valContext, List<ValidationMessage> errors, Element cs, NodeStack stack, ValidationOptions options) {
    boolean ok = true;
    String url = cs.getNamedChildValue("url", false);
    String content = cs.getNamedChildValue("content", false);
    String caseSensitive = cs.getNamedChildValue("caseSensitive", false);
    String hierarchyMeaning = cs.getNamedChildValue("hierarchyMeaning", false);
    String supp = cs.getNamedChildValue("supplements", false);
    int count = countConcepts(cs); 
    CodeSystem csB = null;
    
    metaChecks(errors, cs, stack, url, content, caseSensitive, hierarchyMeaning, !Utilities.noString(supp), count, supp);

    String vsu = cs.getNamedChildValue("valueSet", false);
    if (!Utilities.noString(vsu)) {
      if ("supplement".equals(content)) {
        csB = context.fetchCodeSystem(supp);
        if (csB != null) {
          if (csB.hasValueSet()) {
            warning(errors, "2024-03-06", IssueType.BUSINESSRULE, stack.getLiteralPath(), vsu.equals(vsu), I18nConstants.CODESYSTEM_CS_NO_VS_SUPPLEMENT2, csB.getValueSet());            
          } else {
            warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_NO_VS_SUPPLEMENT1);
          }
        } else {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), "complete".equals(content), I18nConstants.CODESYSTEM_CS_NO_VS_NOTCOMPLETE);
        }        
      } else { 
        hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), "complete".equals(content), I18nConstants.CODESYSTEM_CS_NO_VS_NOTCOMPLETE);
      }
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

    if ("supplement".equals(content) || supp != null) {      
      if (rule(errors, "2024-03-06", IssueType.BUSINESSRULE, stack.getLiteralPath(), !Utilities.noString(supp), I18nConstants.CODESYSTEM_CS_SUPP_NO_SUPP)) {
        if (context.supportsSystem(supp, options.getFhirVersion())) {
          List<Element> concepts = cs.getChildrenByName("concept");
          int ce = 0;
          for (Element concept : concepts) {
            NodeStack nstack = stack.push(concept, ce, null, null);
            if (ce == 0) {
              rule(errors, "2023-08-15", IssueType.INVALID, nstack,  !"not-present".equals(content), I18nConstants.CODESYSTEM_CS_COUNT_NO_CONTENT_ALLOWED);            
            }
            ok = validateSupplementConcept(errors, concept, nstack, supp, options) && ok;
            ce++;
          }    
        } else {
          if (cs.hasChildren("concept")) {
            warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_SUPP_CANT_CHECK, supp);
          }
        }
      } else {
        ok = false;
      }
    }

    if (!stack.isContained()) {
      ok = checkShareableCodeSystem(errors, cs, stack) && ok;
    } else {
      // we approve of contained code systems in two circumstances:
      //   * inside a questionnaire for a code system only used by that questionnaire
      //   * inside a supplement, for creating properties in the supplement// otherwise, we put a hint on it that this is probably a bad idea 
      boolean isInQ = valContext.getRootResource() != null && valContext.getRootResource().fhirType().equals("Questionnaire");
      boolean isSuppProp = valContext.getRootResource() != null && valContext.getRootResource().fhirType().equals("CodeSystem"); // todo add more checks
      hint(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), !isInQ && !isSuppProp, I18nConstants.CODESYSTEM_NOT_CONTAINED);      
    }
    
    Set<String> codes = new HashSet<>();
    
    List<Element> concepts = cs.getChildrenByName("concept");
    int i = 0;
    for (Element concept : concepts) {
      checkConcept(errors, cs,  stack.push(concept, i, null, null), "true".equals(caseSensitive), hierarchyMeaning, csB, concept, codes);
      i++;
    }
    
    return ok;
  }


  private void checkConcept(List<ValidationMessage> errors, Element cs, NodeStack stack, boolean caseSensitive, String hierarchyMeaning, CodeSystem csB, Element concept, Set<String> codes) {
    String code = concept.getNamedChildValue("code");
    String display = concept.getNamedChildValue("display");

    if (csB != null && !Utilities.noString(display)) {
      ConceptDefinitionComponent b = CodeSystemUtilities.findCode(csB.getConcept(), code);
      if (b != null && !b.getDisplay().equalsIgnoreCase(display)) {
        String lang = cs.getNamedChildValue("language");
        if ((lang == null && !csB.hasLanguage()) || 
            csB.getLanguage().equals(lang)) {
          // nothing new language wise, and the display doesn't match
          hint(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_SUPP_NO_DISPLAY, display, b.getDisplay(), lang == null? "undefined" : lang);        
        }
      }
    }
    
    // todo: check that all the properties are defined. 
    // check that all the defined properties have values 
    // check the designations have values, and the use/language don't conflict 
    
    
    List<Element> concepts = concept.getChildrenByName("concept");
    int i = 0;
    for (Element child : concepts) {
      checkConcept(errors, cs,  stack.push(concept, i, null, null), caseSensitive, hierarchyMeaning, csB, child, codes);
      i++;
    }
    
  }

  private boolean checkShareableCodeSystem(List<ValidationMessage> errors, Element cs, NodeStack stack) {
    if (parent.isForPublication()) { 
      if (isHL7(cs)) {
        boolean ok = true;
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "title") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name", false), I18nConstants.CODESYSTEM_SHAREABLE_EXTRA_MISSING_HL7, "name");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "description") && ok; 
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("content", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "content") && ok; 
        if (!"supplement".equals(cs.getChildValue("content"))) {
          ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("caseSensitive", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING_HL7, "caseSensitive") && ok;
        }
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("url", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("version", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("title", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("name", false), I18nConstants.CODESYSTEM_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("status", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("experimental", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("description", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "description"); 
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("content", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "content"); 
        if (!"supplement".equals(cs.getChildValue("content"))) {
          warning(errors, NO_RULE_DATE, IssueType.REQUIRED, cs.line(), cs.col(), stack.getLiteralPath(), cs.hasChild("caseSensitive", false), I18nConstants.CODESYSTEM_SHAREABLE_MISSING, "caseSensitive");
        }
      }
    }
    return true;
  }
  
  private void metaChecks(List<ValidationMessage> errors, Element cs, NodeStack stack, String url,  String content, String caseSensitive, String hierarchyMeaning, boolean isSupplement, int count, String supp) {
    if (forPublication && (url.contains("hl7.org"))) {
      hint(errors, "2024-03-07", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), url.contains("terminology.hl7.org") || url.contains("hl7.org/cda/stds/core"), I18nConstants.CODESYSTEM_THO_CHECK);
    }
    if (isSupplement) {
      if (!"supplement".equals(content)) {
        NodeStack s = stack.push(cs.getNamedChild("content", false), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL_WRONG);
      }
      if (!Utilities.noString(caseSensitive)) {
        NodeStack s = stack.push(cs.getNamedChild("caseSensitive", false), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL, "caseSensitive");
      }
      if (!Utilities.noString(hierarchyMeaning)) {
        NodeStack s = stack.push(cs.getNamedChild("hierarchyMeaning", false), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL, "hierarchyMeaning");
      }

    } else {
      boolean isHL7 = url != null && (url.contains("hl7.org") || url.contains("fhir.org"));
      if (Utilities.noString(content)) {
        NodeStack s = stack;
        Element c = cs.getNamedChild("content", false);
        if (c != null) {
          s = stack.push(c, -1, null, null);
        }
        if (isHL7) {
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_MISSING_ELEMENT_SHALL, "content");
        } else {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_NONHL7_MISSING_ELEMENT, "content");          
        } 
      } else if ("supplement".equals(content)) {
        NodeStack s = stack.push(cs.getNamedChild("content", false), -1, null, null);
        rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, s.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_HL7_PRESENT_ELEMENT_SUPPL_MISSING);        
      }
      if (Utilities.noString(caseSensitive)) {
        NodeStack s = stack;
        Element c = cs.getNamedChild("caseSensitive", false);
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
        Element c = cs.getNamedChild("hierarchyMeaning", false);
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

    if (cs.hasChild("count", false)) {
      int statedCount = Utilities.parseInt(cs.getNamedChildValue("count", false), -1);
      if (statedCount > -1 && content != null) { // error elsewhere
        var nstack = stack.push(cs.getNamedChild("count", false), -1, null, null);
        switch (content) {
        case "complete": 
          rule(errors, "2023-08-15", IssueType.INVALID, nstack, count == statedCount, I18nConstants.CODESYSTEM_CS_COUNT_COMPLETE_WRONG, count, statedCount);
          break;
        case "example":
        case "fragment":
          warning(errors, "2023-08-15", IssueType.INVALID, nstack, count < statedCount, I18nConstants.CODESYSTEM_CS_COUNT_FRAGMENT_WRONG, count, statedCount);
          break;
        case "not-present":
          if (cs.hasChildren("concept")) {
            hint(errors, "2023-08-15", IssueType.INVALID, stack.push(cs.getNamedChild("concept", false), -1, null, null), statedCount > 0, I18nConstants.CODESYSTEM_CS_COUNT_NOTPRESENT_ZERO, statedCount);
          }
          break;
        case "supplement": 
          CodeSystem css = context.fetchCodeSystem(supp);
          if (css != null) {
            rule(errors, "2023-08-15", IssueType.INVALID, nstack, count == css.getCount(), I18nConstants.CODESYSTEM_CS_COUNT_SUPPLEMENT_WRONG, css.getCount(), statedCount);
          }
          break;
        default: 
          // do nothing
        }
      }
    }

    if ("not-present".equals(content)) {
      List<Element> concepts = cs.getChildrenByName("concept");
      if (concepts.size() > 0) {
        rule(errors, "2023-08-15", IssueType.INVALID, stack.push(concepts.get(0), 0, null, null), false, I18nConstants.CODESYSTEM_CS_COUNT_NO_CONTENT_ALLOWED);                    
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
      org.hl7.fhir.r5.terminologies.utilities.ValidationResult res = context.validateCode(options, systemFromCanonical(supp), versionFromCanonical(supp), code, null);
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