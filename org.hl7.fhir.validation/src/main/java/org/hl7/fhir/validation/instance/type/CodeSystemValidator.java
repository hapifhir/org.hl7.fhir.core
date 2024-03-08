package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import org.hl7.fhir.validation.instance.type.CodeSystemValidator.KnownProperty;
import org.hl7.fhir.validation.instance.type.CodeSystemValidator.PropertyDef;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class CodeSystemValidator  extends BaseValidator {

  public enum KnownProperty {
    Status, Inactive, EffectiveDate, DeprecationDate, RetirementDate, NotSelectable, Parent, Child, PartOf, Synonym, Comment, ItemWeight;

    String getType() {
      switch (this) {
      case Child: return "code";
      case Comment: return "string";
      case DeprecationDate: return "dateTime";
      case EffectiveDate: return "dateTime";
      case Inactive: return "boolean";
      case ItemWeight: return "decimal";
      case NotSelectable: return "boolean";
      case Parent: return "code";
      case PartOf: return "code";
      case RetirementDate: return "dateTime";
      case Status: return "code";
      case Synonym: return "code";
      default: return null;      
      }
    }

    String getCode() {
      return Utilities.uncapitalize(this.toString());
    }

    String getUri() {
      return "http://hl7.org/fhir/concept-properties#"+ getCode();
    }

  }

  public class PropertyDef {
    private String uri;
    private String code;
    private String type;
    protected PropertyDef(String uri, String code, String type) {
      super();
      this.uri = uri;
      this.code = code;
      this.type = type;
    }
    public String getUri() {
      return uri;
    }
    public String getCode() {
      return code;
    }
    public String getType() {
      return type;
    }

  }

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
    
    Map<String, PropertyDef> properties = new HashMap<>();
    List<Element> propertyElements = cs.getChildrenByName("property");
    int i = 0;
    for (Element propertyElement : propertyElements) {
      ok = checkPropertyDefinition(errors, cs,  stack.push(propertyElement, i, null, null), "true".equals(caseSensitive), hierarchyMeaning, csB, propertyElement, properties) && ok;
      i++;
    }

    Set<String> codes = new HashSet<>();
    
    List<Element> concepts = cs.getChildrenByName("concept");
    i = 0;
    for (Element concept : concepts) {
      ok = checkConcept(errors, cs,  stack.push(concept, i, null, null), "true".equals(caseSensitive), hierarchyMeaning, csB, concept, codes, properties) && ok;
      i++;
    }
    
    return ok;
  }


  private boolean  checkPropertyDefinition(List<ValidationMessage> errors, Element cs, NodeStack stack, boolean equals, String hierarchyMeaning, CodeSystem csB, Element property, Map<String, PropertyDef> properties) {
    boolean ok = true;
    String uri = property.getNamedChildValue("uri");
    String code = property.getNamedChildValue("code");
    String type = property.getNamedChildValue("type");
    PropertyDef pd = new PropertyDef(uri, code, type);
    KnownProperty ukp = null;
    KnownProperty ckp = null;
    
    if (uri != null) {
      if (rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), !properties.containsKey(uri), I18nConstants.CODESYSTEM_PROPERTY_DUPLICATE_URI, uri)) {         
        properties.put(uri, pd);
      } else {
        ok = false;
      }
      if (uri.contains("hl7.org/fhir")) {
        switch (uri) {
        case "http://hl7.org/fhir/concept-properties#status" :
          ukp = KnownProperty.Status;
          break;
        case "http://hl7.org/fhir/concept-properties#inactive" :
          ukp = KnownProperty.Inactive;
          break;
        case "http://hl7.org/fhir/concept-properties#effectiveDate" :
          ukp = KnownProperty.EffectiveDate;
          break;
        case "http://hl7.org/fhir/concept-properties#deprecationDate" :
          ukp = KnownProperty.DeprecationDate;
          break;
        case "http://hl7.org/fhir/concept-properties#retirementDate" :
          ukp = KnownProperty.RetirementDate;
          break;
        case "http://hl7.org/fhir/concept-properties#notSelectable" :
          ukp = KnownProperty.NotSelectable;
          break;
        case "http://hl7.org/fhir/concept-properties#parent" :
          ukp = KnownProperty.Parent;
          break;
        case "http://hl7.org/fhir/concept-properties#child" :
          ukp = KnownProperty.Child;
          break;
        case "http://hl7.org/fhir/concept-properties#partOf" :
          ukp = KnownProperty.PartOf;
          break;
        case "http://hl7.org/fhir/concept-properties#synonym" :
          ukp = KnownProperty.Synonym;
          break;
        case "http://hl7.org/fhir/concept-properties#comment" :
          ukp = KnownProperty.Comment;
          break;
        case "http://hl7.org/fhir/concept-properties#itemWeight" :
          ukp = KnownProperty.ItemWeight;
          break;
        default:
          ok = false;
          rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_PROPERTY_BAD_HL7_URI, uri);
        }
        warning(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), ukp != KnownProperty.Synonym, I18nConstants.CODESYSTEM_PROPERTY_SYNONYM_DEPRECATED);
      }
    }    
    if (code != null) {
      if (rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), !properties.containsKey(code), I18nConstants.CODESYSTEM_PROPERTY_DUPLICATE_CODE, code)) {         
        properties.put(code, pd);
      } else {
        ok = false;
      }
      switch (code) {
      case "status" :
        ckp = KnownProperty.Status;
        break;
      case "inactive" :
        ckp = KnownProperty.Inactive;
        break;
      case "effectiveDate" :
        ckp = KnownProperty.EffectiveDate;
        break;
      case "deprecationDate" :
        ckp = KnownProperty.DeprecationDate;
        break;
      case "retirementDate" :
        ckp = KnownProperty.RetirementDate;
        break;
      case "notSelectable" :
        ckp = KnownProperty.NotSelectable;
        break;
      case "parent" :
        ckp = KnownProperty.Parent;
        break;
      case "child" :
        ckp = KnownProperty.Child;
        break;
      case "partOf" :
        ckp = KnownProperty.PartOf;
        break;
      case "synonym" :
        ckp = KnownProperty.Synonym;
        break;
      case "comment" :
        ckp = KnownProperty.Comment;
        break;
      case "itemWeight" :
        ckp = KnownProperty.ItemWeight;
        break;
      default:
        // no rules around codes... 
      }
    }
    if (ukp != null) {
      ok = rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), ckp == null || ckp == ukp, I18nConstants.CODESYSTEM_PROPERTY_URI_CODE_MISMATCH, uri, ukp.getCode(), code) && ok;
      if (type != null) {
        ok = rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), type.equals(ukp.getType()), I18nConstants.CODESYSTEM_PROPERTY_URI_TYPE_MISMATCH, uri, ukp.getType(),type) && ok;
      }
    }
    if (uri == null) {
      if (ckp == null) {
        hint(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_PROPERTY_UNKNOWN_CODE, code);
      } else {
        warning(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_PROPERTY_KNOWN_CODE_SUGGESTIVE, code, ckp.getUri());
        if (type != null) {
          warning(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), type.equals(ckp.getType()), I18nConstants.CODESYSTEM_PROPERTY_CODE_TYPE_MISMATCH, code, ckp.getType(), type);
        }
      }
    }
    return ok;
  }

  private boolean checkConcept(List<ValidationMessage> errors, Element cs, NodeStack stack, boolean caseSensitive, String hierarchyMeaning, CodeSystem csB, Element concept, Set<String> codes, Map<String, PropertyDef> properties) {
    boolean ok = true;
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

    List<Element> propertyElements = concept.getChildrenByName("property");
    int i = 0;
    for (Element propertyElement : propertyElements) {
      ok = checkPropertyValue(errors, cs, stack.push(propertyElement, i, null, null), propertyElement, properties) && ok;
      i++;
    }

    List<Element> designations = concept.getChildrenByName("designation");
    i = 0;
    for (Element designation : designations) {
      ok = checkDesignation(errors, cs, stack.push(designation, i, null, null), concept, designation) && ok;
      i++;
    }
    
    List<Element> concepts = concept.getChildrenByName("concept");
    i = 0;
    for (Element child : concepts) {
      ok = checkConcept(errors, cs,  stack.push(concept, i, null, null), caseSensitive, hierarchyMeaning, csB, child, codes, properties) && ok;
      i++;
    }
    return ok;
  }

  private boolean checkDesignation(List<ValidationMessage> errors, Element cs, NodeStack stack, Element concept, Element designation) {
    boolean ok = true;
    
    String rlang = cs.getNamedChildValue("language");
    String display = concept.getNamedChildValue("display");
    String lang = designation.getNamedChildValue("language");
    List<Element> uses = new ArrayList<Element>();
    designation.getNamedChildren("additionalUse", uses);
    Element use = designation.getNamedChild("use");
    if (use != null) {
      uses.add(0, use);
    }
    String value = designation.getNamedChildValue("value");
    
    if (uses.isEmpty()) {
      // if we have no uses, we're kind of implying that it's the base display, so it should be the same
      if (rlang == null && lang == null) {
        ok = rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), display == null || display.equals(value), I18nConstants.CODESYSTEM_DESIGNATION_DISP_CLASH_NO_LANG, value, display) && ok;
      } else if (rlang != null && ((lang == null) || rlang.equals(lang))) {
        ok = rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), display == null || display.equals(value), I18nConstants.CODESYSTEM_DESIGNATION_DISP_CLASH_LANG, value, display, rlang) && ok;        
      }
    } else {
      // .... do we care?
    }
    
    return ok;
  }

  private boolean checkPropertyValue(List<ValidationMessage> errors, Element cs, NodeStack stack, Element property, Map<String, PropertyDef> properties) {
    boolean ok = true;

    String code = property.getNamedChildValue("code");
    Element value = property.getNamedChild("value");
    if (code != null) {
      PropertyDef defn = properties.get(code);
      if (rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), defn != null, I18nConstants.CODESYSTEM_PROPERTY_UNDEFINED, code) &&
          rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), value != null, I18nConstants.CODESYSTEM_PROPERTY_NO_VALUE, code) &&
          rule(errors, "2024-03-06", IssueType.BUSINESSRULE, cs.line(), cs.col(), stack.getLiteralPath(), value.fhirType().equals(defn.type), I18nConstants.CODESYSTEM_PROPERTY_WRONG_TYPE, code, value.fhirType(), defn.type)) {
            // nothing?
      } else {
        ok = false;
      }
    }
    return ok;
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