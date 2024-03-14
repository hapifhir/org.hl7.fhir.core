package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.codesystem.CodeSystemChecker;
import org.hl7.fhir.validation.codesystem.GeneralCodeSystemChecker;
import org.hl7.fhir.validation.codesystem.SnomedCTChecker;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class ValueSetValidator extends BaseValidator {
  public enum PropertyOperation {
    Equals, IsA, DescendentOf, IsNotA, RegEx, In, NotIn, Generalizes, ChildOf, DescendentLeaf, Exists;

    public String toString() {
      switch (this) {
      case ChildOf: return "child-of";
      case DescendentLeaf: return "descendent-leaf";
      case DescendentOf: return "descendent-of";
      case Equals: return "=";
      case Exists: return "exists";
      case Generalizes: return "generalizes";
      case In: return "in";
      case IsA: return "is-a";
      case IsNotA: return "is-not-a";
      case NotIn: return "not-in";
      case RegEx: return "regex";
      default: return "?";
      }
    }

  }
  
  public enum CodeValidationRule {
    Warning, Error, None

  }

  public class PropertyValidationRules {
    private PropertyFilterType type;
    private CodeValidationRule codeValidation; 
    private EnumSet<PropertyOperation> ops;
    
    protected PropertyValidationRules(PropertyFilterType type, CodeValidationRule codeValidation, PropertyOperation... ops) {
      super();
      this.type = type;
      this.codeValidation = codeValidation;
      this.ops = EnumSet.noneOf(PropertyOperation.class);
      for (PropertyOperation op : ops) {
        this.ops.add(op);
      }
    }
    public PropertyValidationRules(PropertyFilterType type, CodeValidationRule codeValidation, EnumSet<PropertyOperation> ops) {
      super();
      this.type = type;
      this.codeValidation = codeValidation;
      this.ops = ops;
    }

    public PropertyFilterType getType() {
      return type;
    }
    public EnumSet<PropertyOperation> getOps() {
      return ops;
    }
    public CodeValidationRule getCodeValidation() {
      return codeValidation;
    }

  }

  public enum PropertyFilterType {
    Boolean, Integer, Decimal, Code, DateTime, Coding
  }

  private static final int TOO_MANY_CODES_TO_VALIDATE = 1000;

  private CodeSystemChecker getSystemValidator(String system, List<ValidationMessage> errors) {
    if (system == null) {
      return new GeneralCodeSystemChecker(context, xverManager, debug, errors);
    }
    switch (system) {
    case "http://snomed.info/sct" :return new SnomedCTChecker(context, xverManager, debug, errors);
    default: return new GeneralCodeSystemChecker(context, xverManager, debug, errors);
    }
  }

  public class VSCodingValidationRequest extends CodingValidationRequest {

    private NodeStack stack;

    public VSCodingValidationRequest(NodeStack stack, Coding code) {
      super(code);
      this.stack = stack;
    }

    public NodeStack getStack() {
      return stack;
    }

  }

  public ValueSetValidator(InstanceValidator parent) {
    super(parent);
  }

  public boolean validateValueSet(ValidationContext valContext, List<ValidationMessage> errors, Element vs, NodeStack stack) {
    boolean ok = true;
    if (!VersionUtilities.isR2Ver(context.getVersion())) {
      List<Element> composes = vs.getChildrenByName("compose");
      int cc = 0;
      for (Element compose : composes) {
        ok = validateValueSetCompose(valContext, errors, compose, stack.push(compose, composes.size() > 1 ? cc : -1, null, null), vs.getNamedChildValue("url", false), "retired".equals(vs.getNamedChildValue("url", false)), vs) & ok;
        cc++;
      }
    }
    if (!stack.isContained()) {
      ok = checkShareableValueSet(errors, vs, stack) && ok;
    }
    return ok;
  }

  private boolean checkShareableValueSet(List<ValidationMessage> errors, Element vs, NodeStack stack) {
    if (parent.isForPublication()) { 
      if (isHL7(vs)) {
        boolean ok = true;
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("url", false), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("version", false), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("title", false), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "title") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("name", false), I18nConstants.VALUESET_SHAREABLE_EXTRA_MISSING_HL7, "name");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("status", false), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("experimental", false), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("description", false), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "description") && ok;
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("url", false), I18nConstants.VALUESET_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("version", false), I18nConstants.VALUESET_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("title", false), I18nConstants.VALUESET_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("name", false), I18nConstants.VALUESET_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("status", false), I18nConstants.VALUESET_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("experimental", false), I18nConstants.VALUESET_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, stack, vs.hasChild("description", false), I18nConstants.VALUESET_SHAREABLE_MISSING, "description");
      }
    }
    return true;
  }


  private boolean validateValueSetCompose(ValidationContext valContext, List<ValidationMessage> errors, Element compose, NodeStack stack, String vsid, boolean retired, Element vsSrc) {
    boolean ok = true;
    List<Element> includes = compose.getChildrenByName("include");
    int ci = 0;
    for (Element include : includes) {
      ok = validateValueSetInclude(valContext, errors, include, stack.push(include, ci, null, null), vsid, retired, vsSrc) && ok;
      ci++;
    }    
    List<Element> excludes = compose.getChildrenByName("exclude");
    int ce = 0;
    for (Element exclude : excludes) {
      ok = validateValueSetInclude(valContext, errors, exclude, stack.push(exclude, ce, null, null), vsid, retired, vsSrc) && ok;
      ce++;
    }    
    return ok;
  }

  private boolean validateValueSetInclude(ValidationContext valContext, List<ValidationMessage> errors, Element include, NodeStack stack, String vsid, boolean retired,  Element vsSrc) {
    boolean ok = true;
    String system = include.getChildValue("system");
    String version = include.getChildValue("version");
    List<Element> valuesets = include.getChildrenByName("valueSet");
    int i = 0;
    for (Element ve : valuesets) {
      String v = ve.getValue();
      ValueSet vs = context.findTxResource(ValueSet.class, v);
      if (vs == null) {
        NodeStack ns = stack.push(ve, i, ve.getProperty().getDefinition(), ve.getProperty().getDefinition());

        Resource rs = context.fetchResource(Resource.class, v);
        if (rs != null) {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns.getLiteralPath(), false, I18nConstants.VALUESET_REFERENCE_INVALID_TYPE, v, rs.fhirType());                      
        } else { 
          // todo: it's possible, at this point, that the txx server knows the value set, but it's not in scope
          // should we handle this case?
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, ns.getLiteralPath(), false, I18nConstants.VALUESET_REFERENCE_UNKNOWN, v);            
        }
      }
      i++;
    }
    if (valuesets.size() > 1) {
      warning(errors, NO_RULE_DATE, IssueType.INFORMATIONAL, stack, false, I18nConstants.VALUESET_IMPORT_UNION_INTERSECTION);                  
    }
    if (system != null) {
      rule(errors, "2024-03-06", IssueType.INVALID, stack, Utilities.isAbsoluteUrl(system), system.startsWith("#") ? I18nConstants.VALUESET_INCLUDE_SYSTEM_ABSOLUTE_FRAG : I18nConstants.VALUESET_INCLUDE_SYSTEM_ABSOLUTE, system);
      if (system.startsWith("#")) {
        List<Element> cs = new ArrayList<>();
        for (Element contained : vsSrc.getChildrenByName("contained")) {
          if (("#"+contained.getIdBase()).equals(system)) {
            ok = false; // see absolute check above.

            if (rule(errors, "2024-02-10", IssueType.INVALID, stack, "CodeSystem".equals(contained.fhirType()), I18nConstants.VALUESET_INCLUDE_CS_NOT_CS, system, contained.fhirType())) {
              if (version == null || version.equals(contained.getChildValue("version"))) {
                cs.add(contained);
              }            
            } 
          }
        }
        if (cs.isEmpty()) {
          ok = rule(errors, "2024-02-10", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_NOT_FOUND : I18nConstants.VALUESET_INCLUDE_CSVER_NOT_FOUND, system, version) && ok;   
        } else {
          ok = rule(errors, "2024-02-10", IssueType.INVALID, stack, cs.size() == 1, version == null ? I18nConstants.VALUESET_INCLUDE_CS_MULTI_FOUND : I18nConstants.VALUESET_INCLUDE_CSVER_MULTI_FOUND, system, version) && ok;   
        }
      }
      if (version == null) {
        CodeSystem cs = context.fetchCodeSystem(system);
        if (cs != null && !CodeSystemUtilities.isExemptFromMultipleVersionChecking(system)) {
          Set<String> possibleVersions = fetcher.fetchCanonicalResourceVersions(null, valContext.getAppContext(), system);
          warning(errors, NO_RULE_DATE, IssueType.INVALID,  stack, possibleVersions.size() <= 1, I18nConstants.TYPE_SPECIFIC_CHECKS_DT_CANONICAL_MULTIPLE_POSSIBLE_VERSIONS, 
              system, cs.getVersion(), CommaSeparatedStringBuilder.join(", ", Utilities.sorted(possibleVersions)));
        }
      }
    }
    List<Element> concepts = include.getChildrenByName("concept");
    List<Element> filters = include.getChildrenByName("filter");

    CodeSystemChecker slv = getSystemValidator(system, errors);
    CodeSystem cs = null;
    if (!Utilities.noString(system)) {
      cs = context.fetchCodeSystem(system, version);
      if (cs != null) { // if it's null, we can't analyse this
        switch (cs.getContent()) {
        case EXAMPLE:
          warning(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_CONTENT : I18nConstants.VALUESET_INCLUDE_CSVER_CONTENT, system, cs.getContent().toCode(), version);             
          break;
        case FRAGMENT:
          hint(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_CONTENT : I18nConstants.VALUESET_INCLUDE_CSVER_CONTENT, system, cs.getContent().toCode(), version);             
          break;
        case SUPPLEMENT:
          ok = rule(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_SUPPLEMENT : I18nConstants.VALUESET_INCLUDE_CSVER_SUPPLEMENT, system, cs.getSupplements(), version) && ok;             
          break;
        default:
          break;
        }
      } 

      boolean systemOk = true;
      int cc = 0;
      List<VSCodingValidationRequest> batch = new ArrayList<>();
      boolean first = true;
      for (Element concept : concepts) {
        // we treat the first differently because we want to know if the system is worth validating. if it is, then we batch the rest
        if (first) {
          systemOk = validateValueSetIncludeConcept(errors, concept, stack, stack.push(concept, cc, null, null), system, version, slv);
          first = false;
        } else if (systemOk) {
          batch.add(prepareValidateValueSetIncludeConcept(errors, concept, stack.push(concept, cc, null, null), system, version, slv));
        }
        cc++;
      }    
      if (((InstanceValidator) parent).isValidateValueSetCodesOnTxServer() && batch.size() > 0 & !context.isNoTerminologyServer()) {
        if (batch.size() > TOO_MANY_CODES_TO_VALIDATE) {
          ok = hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_INC_TOO_MANY_CODES, batch.size()) && ok;
        } else {
          long t = System.currentTimeMillis();
          if (parent.isDebug()) {
            System.out.println("  : Validate "+batch.size()+" codes from "+system+" for "+vsid);
          }
          try {
            context.validateCodeBatch(ValidationOptions.defaults(), batch, null);
            if (parent.isDebug()) {
              System.out.println("  :   .. "+(System.currentTimeMillis()-t)+"ms");
            }
            for (VSCodingValidationRequest cv : batch) {
              if (version == null) {
                warningOrHint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, cv.getStack().getLiteralPath(), cv.getResult().isOk(), !retired, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, cv.getCoding().getCode());
              } else {
                warningOrHint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, cv.getStack().getLiteralPath(), cv.getResult().isOk(), !retired, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, cv.getCoding().getCode());
              }
            }
          } catch (Exception e) {
            ok = false;
            VSCodingValidationRequest cv = batch.get(0);
            rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, cv.getStack().getLiteralPath(), false, e.getMessage());
          }
        }
      }

      int cf = 0;
      for (Element filter : filters) {
        ok = validateValueSetIncludeFilter(errors, filter, stack.push(filter, cf, null, null), system, version, cs, slv) & ok;
        cf++;
      }    
      slv.finish(include, stack);
    } else {
      warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, filters.size() == 0 && concepts.size() == 0, I18nConstants.VALUESET_NO_SYSTEM_WARNING);      
    }
    return ok;
  }


  private boolean validateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stackInc, NodeStack stack, String system, String version, CodeSystemChecker slv) {
    String code = concept.getChildValue("code");
    String display = concept.getChildValue("display");
    slv.checkConcept(code, display);

    if (version == null) {
      ValidationResult vv = context.validateCode(ValidationOptions.defaults(), new Coding(system, code, null), null);
      if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
        if (isExampleUrl(system)) {
          if (isAllowExamples()) {
            hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stackInc.getLiteralPath(), false, I18nConstants.VALUESET_EXAMPLE_SYSTEM_HINT, system);
          } else {
            rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stackInc.getLiteralPath(), false, I18nConstants.VALUESET_EXAMPLE_SYSTEM_ERROR, system);
          }
        } else {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stackInc.getLiteralPath(), false, I18nConstants.VALUESET_UNC_SYSTEM_WARNING, system, vv.getMessage());
        }
        return false;
      } else {
        boolean ok = vv.isOk();
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, code);
        if (vv.getMessage() != null) {
          hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, false, vv.getMessage());
        }
      }
    } else {
      ValidationResult vv = context.validateCode(ValidationOptions.defaults(), new Coding(system, code, null).setVersion(version), null);
      if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stackInc.getLiteralPath(), false, I18nConstants.VALUESET_UNC_SYSTEM_WARNING_VER, system+"#"+version, vv.getMessage());            
        return false;        
      } else {
        boolean ok = vv.isOk();
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, code);
        if (vv.getMessage() != null) {
          hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, false, vv.getMessage());
        }
      }
    }
    return true;
  }

  private VSCodingValidationRequest prepareValidateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String system, String version, CodeSystemChecker slv) {
    String code = concept.getChildValue("code");
    String display = concept.getChildValue("display");
    slv.checkConcept(code, display);

    Coding c = new Coding(system, code, null);
    if (version != null) {
      c.setVersion(version);
    }
    return new VSCodingValidationRequest(stack, c);
  }

  private boolean validateValueSetIncludeFilter(List<ValidationMessage> errors, Element filter, NodeStack stack, String system, String version, CodeSystem cs, CodeSystemChecker slv) {
    boolean ok = true;
    String property = filter.getChildValue("property");
    String op = filter.getChildValue("op");
    String value = filter.getChildValue("value");

    if (property != null) {
      List<String> knownNames = new ArrayList<>();
      knownNames.add("concept");
      knownNames.add("code");
      knownNames.add("status");
      knownNames.add("inactive");
      knownNames.add("effectiveDate");
      knownNames.add("deprecationDate");
      knownNames.add("retirementDate");
      knownNames.add("notSelectable");
      if (cs == null || cs.hasHierarchyMeaning()) {
        knownNames.add("parent");
        knownNames.add("child");
        knownNames.add("partOf");
      }
      knownNames.add("synonym");
      knownNames.add("comment");
      knownNames.add("itemWeight");
      if (cs != null) {
        for (CodeSystemFilterComponent f : cs.getFilter()) {
          addName(knownNames, f.getCode());
        }
        for (PropertyComponent p : cs.getProperty()) {
          addName(knownNames, p.getCode());
        }
      }
      for (String s : getSystemKnownNames(system)) {
        addName(knownNames, s);        
      }
      boolean pok = false;
      if (cs == null) {
        pok = hint(errors, "2024-03-09", IssueType.INVALID, stack, knownNames.contains(property), I18nConstants.VALUESET_UNKNOWN_FILTER_PROPERTY_NO_CS, property, system, CommaSeparatedStringBuilder.join(",", knownNames));        
      } else {
        pok = warning(errors, "2024-03-09", IssueType.INVALID, stack, knownNames.contains(property), I18nConstants.VALUESET_UNKNOWN_FILTER_PROPERTY, property, system, CommaSeparatedStringBuilder.join(",", knownNames));
      }
      if (pok) {
        PropertyValidationRules rules = rulesForFilter(system, cs, property);
        if (rules != null) {
          if (!rules.getOps().isEmpty()) {
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, opInSet(op, rules.getOps()), I18nConstants.VALUESET_BAD_FILTER_OP, op, property, CommaSeparatedStringBuilder.join(",", rules.getOps())) && ok;
          }

          if ("exists".equals(op)) {
            ok = checkFilterValue(errors, stack, system, version, ok, property, op, value, PropertyFilterType.Boolean, null) && ok;
          } else if ("regex".equals(op)) {
            String err = null;
            try {
              Pattern.compile(value);
            } catch (PatternSyntaxException e) {
              err = e.getMessage();
            }            
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, err == null, I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_REGEX, property, value, err) && ok;
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, !"concept".equals(property), I18nConstants.VALUESET_BAD_PROPERTY_NO_REGEX, property) && ok;
          } else if (Utilities.existsInList(op, "in", "not-in")) {
            for (String v : value.split("\\,")) {
              ok = checkFilterValue(errors, stack, system, version, ok, property, op, v, rules.getType(), rules.getCodeValidation()) && ok;
            }
          } else {
            ok = checkFilterValue(errors, stack, system, version, ok, property, op, value, rules.getType(), rules.getCodeValidation()) && ok;
          }
        }
      }
    }

    return ok;
  }

  private boolean opInSet(String op, EnumSet<PropertyOperation> ops) {
    switch (op) {
    case "=": return ops.contains(PropertyOperation.Equals); 
    case "is-a": return ops.contains(PropertyOperation.IsA); 
    case "descendent-of": return ops.contains(PropertyOperation.DescendentOf);  
    case "is-not-a": return ops.contains(PropertyOperation.IsNotA); 
    case "regex": return ops.contains(PropertyOperation.RegEx);  
    case "in": return ops.contains(PropertyOperation.In);   
    case "not-in": return ops.contains(PropertyOperation.NotIn);  
    case "generalizes": return ops.contains(PropertyOperation.Generalizes);  
    case "child-of": return ops.contains(PropertyOperation.ChildOf);  
    case "descendent-leaf": return ops.contains(PropertyOperation.DescendentLeaf); 
    case "exists": return ops.contains(PropertyOperation.Exists);
    }
    return false;
  }

  private boolean checkFilterValue(List<ValidationMessage> errors, NodeStack stack, String system, String version,boolean ok, String property, String op, String value, PropertyFilterType type, CodeValidationRule cr) {
    if (type != null) {
      if (!Utilities.existsInList(op, "in", "not-in")) {
        hint(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(), !value.contains(","), I18nConstants.VALUESET_BAD_FILTER_VALUE_HAS_COMMA, type.toString());
      }
      switch (type) {
      case Boolean:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, 
            Utilities.existsInList(value, "true", "false"), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_BOOLEAN, property, value) && ok;
        break;
      case Code:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, 
            value.trim().equals(value), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_CODE, property, value) && ok;
        if (cr == CodeValidationRule.Error || cr == CodeValidationRule.Warning) {
          ValidationResult vr = context.validateCode(baseOptions, system, version, value, null);
          if (cr == CodeValidationRule.Error) {
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(), vr.isOk(), I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE, property, value, system, vr.getMessage()) && ok;
          } else {
            warning(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(), vr.isOk(), I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE, property, value, system, vr.getMessage());
          }
        }
        break;
      case DateTime:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(),
            value.matches("([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)(-(0[1-9]|1[0-2])(-(0[1-9]|[1-2][0-9]|3[0-1])(T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]+)?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?)?)?)?"), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_DATETIME, property, value) && ok;
        break;
      case Decimal:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(),
            Utilities.isDecimal(value, true), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_DECIMAL, property, value) && ok;
        break;
      case Integer:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(),
            Utilities.isInteger(value), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_INTEGER, property, value) && ok;
        break;
      case Coding :
        Coding code = Coding.fromLiteral(value);
        if (code == null) {
          ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, false, I18nConstants.VALUESET_BAD_FILTER_VALUE_CODED, property, value) && ok;
        } else {
          ValidationResult vr = context.validateCode(baseOptions, code, null);
          ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, vr.isOk(), I18nConstants.VALUESET_BAD_FILTER_VALUE_CODED_INVALID, property, value, vr.getMessage()) && ok;
        }
        break;
      default:
        break;        
      }
    }
    return ok;
  }

  private PropertyValidationRules rulesForFilter(String system, CodeSystem cs, String property) {
    var ops = EnumSet.noneOf(PropertyOperation.class);
    
    if (cs != null) {

      for (CodeSystemFilterComponent f : cs.getFilter()) {
        if (property.equals(f.getCode())) {
          for (Enumeration<FilterOperator> op : f.getOperator()) {
            ops.add(toOp(op));
          }
        }
      }

      for (PropertyComponent p : cs.getProperty()) {
        if (property.equals(p.getCode())) {
          if (p.getType() != null) {
            switch (p.getType()) {
            case BOOLEAN: return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
            case CODE: 
              // the definitions say " a code that identifies a concept defined in the code system" -> ValidCode.
              // but many people have ignored that and defined a property as 'code' because it's from a list of values that are otherwise undefined
              boolean external = !forPublication || cs.getWebPath() == null || Utilities.isAbsoluteUrl(cs.getWebPath());
              return new PropertyValidationRules(PropertyFilterType.Code, external ? CodeValidationRule.Warning : CodeValidationRule.Error, ops); // valid code... the definitions say that, but people were missing that in the pastm 
            case CODING: return new PropertyValidationRules(PropertyFilterType.Coding, null, ops);
            case DATETIME: return new PropertyValidationRules(PropertyFilterType.DateTime, null, ops);
            case DECIMAL: return new PropertyValidationRules(PropertyFilterType.Decimal, null, ops);
            case INTEGER: return new PropertyValidationRules(PropertyFilterType.Integer, null, ops);
            case STRING: return null;
            }
          }
        }
      }
    }

    switch (property) {
    case "concept" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In, PropertyOperation.IsA, PropertyOperation.DescendentOf, PropertyOperation.DescendentLeaf, PropertyOperation.IsNotA, PropertyOperation.NotIn));
    case "code" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.Equals, PropertyOperation.RegEx));
    case "status" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops);
    case "inactive" : return new PropertyValidationRules(PropertyFilterType.Boolean,null,  ops);
    case "effectiveDate" : return new PropertyValidationRules(PropertyFilterType.DateTime, null, ops);
    case "deprecationDate" : return new PropertyValidationRules(PropertyFilterType.DateTime, null, ops);
    case "retirementDate" : return new PropertyValidationRules(PropertyFilterType.DateTime, null, ops);
    case "notSelectable" : return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
    case "parent" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, ops);
    case "child" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, ops);
    case "partOf" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, ops);
    case "synonym" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops); // ? none?
    case "comment" : return null;
    case "itemWeight" : return new PropertyValidationRules(PropertyFilterType.Decimal, null, ops);
    }
    switch (system) {
    case "http://loinc.org" : 
      if (Utilities.existsInList(property, "copyright", "STATUS", "CLASS", "CONSUMER_NAME", "ORDER_OBS", "DOCUMENT_SECTION", "SCALE_TYP")) { 
        return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None);
      } else if ("CLASSTYPE".equals(property)) {
        return new PropertyValidationRules(PropertyFilterType.Integer, null, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
      } else { 
        return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
      }
    case "http://snomed.info/sct": 
      switch (property) {
      case "constraint": return null; // for now 
      case "expressions": return new PropertyValidationRules(PropertyFilterType.Boolean, null, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
      default:
        return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, addToOps(ops, PropertyOperation.Equals, PropertyOperation.In));
      }
    case "http://www.nlm.nih.gov/research/umls/rxnorm" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops);
    case "http://unitsofmeasure.org" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops); 
    case "http://www.ama-assn.org/go/cpt" : 
      switch (property) {
      case "modifier": return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
      case "kind" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops); // for now
      case "modified": return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
      case "code" : return null;
      case "telemedicine": return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
      case "orthopox" : return new PropertyValidationRules(PropertyFilterType.Boolean,null,  ops);
      }
    }
    if (ops != null) {
      return new PropertyValidationRules(null, null, ops);
    } else {
      return null;
    }

  }


  private EnumSet<PropertyOperation> addToOps(EnumSet<PropertyOperation> set, PropertyOperation... ops) {
    for (PropertyOperation op : ops) {
      set.add(op);
    }
    return set;
  }

  private PropertyOperation toOp(Enumeration<FilterOperator> op) {
    switch (op.getValue()) {
    case CHILDOF: return PropertyOperation.ChildOf;
    case DESCENDENTLEAF: return PropertyOperation.DescendentLeaf;
    case DESCENDENTOF: return PropertyOperation.DescendentOf;
    case EQUAL: return PropertyOperation.Equals;
    case EXISTS: return PropertyOperation.Exists;
    case GENERALIZES: return PropertyOperation.Generalizes;
    case IN: return PropertyOperation.In;
    case ISA: return PropertyOperation.IsA;
    case ISNOTA: return PropertyOperation.IsNotA;
    case NOTIN: return PropertyOperation.NotIn;
    case REGEX: return PropertyOperation.RegEx;
    default: return null;
    }      
  }
  
  private void addName(List<String> knownNames, String code) {
    if (code != null && !knownNames.contains(code)) {
      knownNames.add(code);
    }    
  }

  private String[] getSystemKnownNames(String system) {
    switch (system) {
    case "http://loinc.org" : return new String[] {"parent", "ancestor", "copyright", "STATUS", "COMPONENT", "PROPERTY", "TIME_ASPCT", "SYSTEM", "SCALE_TYP", "METHOD_TYP", "CLASS", "CONSUMER_NAME", "CLASSTYPE", "ORDER_OBS", "DOCUMENT_SECTION"};

    case "http://snomed.info/sct": return  new String[] { "constraint", "expressions", "410662002", "42752001", "47429007", "116676008", "116686009", "118168003", "118169006", "118170007", "118171006", "127489000", "131195008",
        "246075003", "246090004", "246093002", "246112005", "246454002", "246456000", "246501002", "246513007", "246514001", "255234002", "260507000",
        "260686004", "260870009", "263502005", "272741003", "288556008", "363589002", "363698007", "363699004", "363700003", "363701004", "363702006",
        "363703001", "363704007", "363705008", "363709002", "363710007", "363713009", "363714003", "370129005", "370130000", "370131001", "370132008",
        "370133003", "370134009", "370135005", "371881003", "405813007", "405814001", "405815000", "405816004", "408729009", "408730004", "408731000",
        "408732007", "410675002", "411116001", "418775008", "419066007", "424226004", "424244007", "424361007", "424876005", "425391005", "609096000",
        "704319004", "704320005", "704321009", "704322002", "704323007", "704324001", "704325000", "704326004", "704327008", "704346009", "704347000",
        "704647008", "718497002", "719715003", "719722006", "726542003", "726633004", "732943007", "732945000", "732947008", "733722007", "733725009",
        "733928003", "733930001", "733931002", "733932009", "733933004", "734136001", "734137005", "736472000", "736473005", "736474004", "736475003",
        "736476002", "736518005", "738774007", "762705008", "762706009", "762949000", "762951001", "763032000", "766939001", "774081006", "774158006",
        "774159003", "774160008", "774163005", "827081001", "836358009", "840560000", "860779006", "860781008", "1003703000", "1003735000", "1142135004",
        "1142136003", "1142137007", "1142138002", "1142139005", "1142140007", "1142141006", "1142142004", "1142143009", "1148793005", "1148965004",
        "1148967007", "1148968002", "1148969005", "1149366004", "1149367008", "1230370004", "320091000221107" }; 
    // list from http://tx.fhir.org/r4/ValueSet/$expand?url=http://snomed.info/sct?fhir_vs=isa/410662002

    case "http://www.nlm.nih.gov/research/umls/rxnorm" : return  new String[] { "STY", "SAB", "TTY", "SY", "SIB", "RN", "PAR", "CHD", "RB", "RO", "IN", "PIN", "MIN", "BN", "SCD", "SBD", "GPCK", "BPCK", "SCDC", "SCDF", "SCDFP", "SCDG", "SCDGP", "SBDC", "SBDF", "SBDFP", "SBDG", "DF", "DFG" };
    case "http://unitsofmeasure.org" : return new String[] { "property", "canonical" };
    case "http://www.ama-assn.org/go/cpt" : return new String[] { "modifier", "kind", "modified", "code", "telemedicine", "orthopox" };
    case "urn:ietf:bcp:47" :  return new String[] {"language", "region", "script", "variant", "extension", "ext-lang", "private-use" };
    default: return new String[] { };      
    }
  }
}
