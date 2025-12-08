package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.TerminologyUtilities;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.SpecialValidationAction;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.SpecialValidationRule;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.codesystem.BCP47Checker;
import org.hl7.fhir.validation.codesystem.CPTChecker;
import org.hl7.fhir.validation.codesystem.CodeSystemBasedChecker;
import org.hl7.fhir.validation.codesystem.CodeSystemChecker;
import org.hl7.fhir.validation.codesystem.CodeSystemChecker.StringWithFlag;
import org.hl7.fhir.validation.codesystem.GeneralCodeSystemChecker;
import org.hl7.fhir.validation.codesystem.LoincChecker;
import org.hl7.fhir.validation.codesystem.RxNormChecker;
import org.hl7.fhir.validation.codesystem.SnomedCTChecker;
import org.hl7.fhir.validation.codesystem.UcumChecker;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

@Slf4j
public class ValueSetValidator extends BaseValidator {

  public class ParameterDeclaration {
    private Element ext;
    private String name;
    private String doco;
    private boolean used;
    public ParameterDeclaration(Element ext, String name, String doco) {
      super();
      this.ext = ext;
      this.name = name;
      this.doco = doco;
    }
    public String getName() {
      return name;
    }
    public String getDoco() {
      return doco;
    }
    public boolean isUsed() {
      return used;
    }
  }

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

  public static class PropertyValidationRules {
    private PropertyFilterType type;
    private CodeValidationRule codeValidation; 
    private EnumSet<PropertyOperation> ops;
    private List<String> codeList = new ArrayList<>();
    private boolean change;
    private boolean active;

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
    public List<String> getCodeList() {
      return codeList;
    }
    public PropertyValidationRules setCodes(String... values) {
      for (String v : values) {
        codeList.add(v);
      }
      return this;
    }
    public boolean isChange() {
      return change;
    }
    public PropertyValidationRules setChange(boolean change) {
      this.change = change;
      return this;
    }
    public boolean isActive() {
      return active;
    }
    public PropertyValidationRules setActive(boolean active) {
      this.active = active;
      return this;
    }

  }

  public enum PropertyFilterType {
    Boolean, Integer, Decimal, Code, DateTime, Coding, CodeList, String
  }

  private static final int TOO_MANY_CODES_TO_VALIDATE = 1000;
  private static final int VALIDATION_BATCH_SIZE = 300;


  private CodeSystemChecker getSystemValidator(String system, List<ValidationMessage> errors) {
    if (system == null) {
      return new GeneralCodeSystemChecker(context, settings, xverManager, errors, session);
    }
    switch (system) {
    case "http://snomed.info/sct" :return new SnomedCTChecker(context, settings, xverManager, errors, session);
    case "http://loinc.org": return new LoincChecker(context, settings, xverManager, errors, session);
    case "http://www.nlm.nih.gov/research/umls/rxnorm": return new RxNormChecker(context, settings, xverManager, errors, session); 
    case "http://unitsofmeasure.org": return new UcumChecker(context, settings, xverManager, errors, session); 
    case "http://www.ama-assn.org/go/cpt": return new CPTChecker(context, settings, xverManager, errors, session); 
    case "urn:ietf:bcp:47": return new BCP47Checker(context, settings, xverManager, errors, session);  
    default: 
      CodeSystem cs = context.fetchCodeSystem(system);
      if (cs != null) {
        return new CodeSystemBasedChecker(context, settings, xverManager, errors, cs, session);
      } else {
        return new GeneralCodeSystemChecker(context, settings, xverManager, errors, session);
      }
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

  private FHIRPathEngine fpe;

  public ValueSetValidator(InstanceValidator parent) {
    super(parent);
    fpe = parent.getFHIRPathEngine();
  }

  public boolean validateValueSet(ValidationContext valContext, List<ValidationMessage> errors, Element vs, NodeStack stack) {
    boolean ok = true;
    if (!VersionUtilities.isR2Ver(context.getVersion())) {
      List<ParameterDeclaration> parameters = new ArrayList<ValueSetValidator.ParameterDeclaration>(); 
      int i = 0;
      for (Element ext : vs.getExtensions(ExtensionDefinitions.EXT_VALUESET_PARAMETER)) {
        Element n = ext.getExtension("name");
        if (n != null) {
          Element d = ext.getExtension("documentation");
          NodeStack estack = stack.push(ext, i, null, null);
          String name = n.getNamedChildValue("value");
          if (d == null) {                     
            warning(errors, "2025-03-22", IssueType.BUSINESSRULE, estack, name.startsWith("p-"), I18nConstants.VALUESET_PARAMETER_NO_DOCO, name);               
            parameters.add(new ParameterDeclaration(ext, n.primitiveValue(), null));            
          } else {
            parameters.add(new ParameterDeclaration(ext, name, d == null ? null : d.getNamedChildValue("value")));
          }
          hint(errors, "2025-03-22", IssueType.BUSINESSRULE, estack, name.startsWith("p-"), I18nConstants.VALUESET_PARAMETER_NAME_WARNING, name);               
        }
        i++;
      }
      List<Element> composes = vs.getChildrenByName("compose");
      int cc = 0;     
      for (Element compose : composes) {
        ok = validateValueSetCompose(valContext, errors, compose, stack.push(compose, composes.size() > 1 ? cc : -1, null, null), vs.getNamedChildValue("url", false), "retired".equals(vs.getNamedChildValue("url", false)), vs, parameters) & ok;
        cc++;
      }
      for (ParameterDeclaration p : parameters) {
        warning(errors, "2025-03-21", IssueType.BUSINESSRULE, stack.push(p.ext, i, null, null), p.used, I18nConstants.VALUESET_PARAMETER_NOT_USED, p.name);     
      }
    }
    if (!stack.isContained()) {
      ok = checkShareableValueSet(valContext, errors, vs, stack) && ok;
    }
    return ok;
  }

  private boolean checkShareableValueSet(ValidationContext valContext, List<ValidationMessage> errors, Element vs, NodeStack stack) {
    if (policyAdvisor.policyForSpecialValidation((IResourceValidator) parent, valContext.getAppContext(), SpecialValidationRule.VALUESET_METADATA_CHECKS, stack.getLiteralPath(), vs, null) == SpecialValidationAction.CHECK_RULE) {
      if (settings.isForPublication()) { 
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
    }
    return true;
  }


  private boolean validateValueSetCompose(ValidationContext valContext, List<ValidationMessage> errors, Element compose, NodeStack stack, String vsid, boolean retired, Element vsSrc, List<ParameterDeclaration> parameters) {
    boolean ok = true;
    List<Element> includes = compose.getChildrenByName("include");
    int ci = 0;
    for (Element include : includes) {
      ok = validateValueSetInclude(valContext, errors, include, stack.push(include, ci, null, null), vsid, retired, vsSrc, parameters) && ok;
      ci++;
    }    
    List<Element> excludes = compose.getChildrenByName("exclude");
    int ce = 0;
    for (Element exclude : excludes) {
      ok = validateValueSetInclude(valContext, errors, exclude, stack.push(exclude, ce, null, null), vsid, retired, vsSrc, parameters) && ok;
      ce++;
    }    
    return ok;
  }

  private boolean validateValueSetInclude(ValidationContext valContext, List<ValidationMessage> errors, Element include, NodeStack stack, String vsid, boolean retired,  Element vsSrc, List<ParameterDeclaration> parameters) {
    boolean ok = true;
    String system = include.getChildValue("system");
    String version = include.getChildValue("version");
    if (system != null && system.contains("|")) {
      String uver = system.substring(system.indexOf("|")+1);
      system = system.substring(0, system.indexOf("|"));
      if (Utilities.noString(uver)) {
         warning(errors, "2024-06-13", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_REFERENCE_INVALID_TYPE_NO_VERSION_0, system);                   
      } else if (version == null) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_REFERENCE_INVALID_TYPE_NO_VERSION_1, uver) && ok;                   
      } else if (!uver.equals(version)) {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_REFERENCE_INVALID_TYPE_NO_VERSION_2, uver, version) && ok;                   
      } else {
        ok = rule(errors, "2024-06-13", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_REFERENCE_INVALID_TYPE_NO_VERSION_3, uver) && ok;                             
      }
    }      

    if (policyAdvisor.policyForSpecialValidation((IResourceValidator) parent, valContext.getAppContext(), SpecialValidationRule.VALUESET_IMPORT_CHECKS, stack.getLiteralPath(), vsSrc, include) == SpecialValidationAction.CHECK_RULE) {
      List<Element> valuesets = include.getChildrenByName("valueSet");
      int i = 0;
      for (Element ve : valuesets) {
        String v = ve.getValue();
        ValueSet vs = context.findTxResource(ValueSet.class, v);
        if (vs == null) {
          // we couldn't find it, but it might be an implicit value set 
          ValueSetExpansionOutcome vse = context.expandVS(new ExpansionOptions().withCacheOk(true).withHierarchical(false).withMaxCount(0), v);
          if (!vse.isOk() ) {
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
        }
        i++;
      }
      if (valuesets.size() > 1) {
        warning(errors, NO_RULE_DATE, IssueType.INFORMATIONAL, stack, false, I18nConstants.VALUESET_IMPORT_UNION_INTERSECTION);                  
      }
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

        if (cs != null && !CodeSystemUtilities.isExemptFromMultipleVersionChecking(system) && fetcher != null) {
          Set<IValidatorResourceFetcher.ResourceVersionInformation> possibleVersions = fetcher.fetchCanonicalResourceVersions(null, valContext.getAppContext(), system);
          warning(errors, NO_RULE_DATE, IssueType.INVALID,  stack, possibleVersions.size() <= 1, I18nConstants.TYPE_SPECIFIC_CHECKS_DT_CANONICAL_MULTIPLE_POSSIBLE_VERSIONS,
              system, cs.getVersion(), CommaSeparatedStringBuilder.join(", ", Utilities.sorted(IValidatorResourceFetcher.ResourceVersionInformation.toStrings(possibleVersions))));
        }
      }
    }
    List<Element> concepts = include.getChildrenByName("concept");
    List<Element> filters = include.getChildrenByName("filter");

    CodeSystemChecker csChecker = getSystemValidator(system, errors);
    CodeSystem cs = null;
    if (!Utilities.noString(system)) {
      cs = context.fetchCodeSystem(system, version, null);
      if (cs == null) {
        // can we get it from a terminology server? 
        cs = context.findTxResource(CodeSystem.class, system, version, null);
      }
      boolean validateConcepts = true;
      if (cs != null) { // if it's null, we can't analyse this
        ok = rule(errors, "2025-07-15", IssueType.BUSINESSRULE, stack.getLiteralPath(), !cs.hasUserData(UserDataNames.RESOURCE_INTERNAL_USE_ONLY), I18nConstants.RESOURCE_INTERNAL_USE_ONLY, "CodeSystem", cs.getSourcePackage() != null ? cs.getSourcePackage().getVID() : "??") && ok;
        if (cs.getContent() == null) {
          warning(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_CONTENT : I18nConstants.VALUESET_INCLUDE_CSVER_CONTENT, system, "null", version);             
        } else {
          switch (cs.getContent()) {
          case EXAMPLE:
            warning(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_CONTENT : I18nConstants.VALUESET_INCLUDE_CSVER_CONTENT, system, cs.getContent().toCode(), version);             
            break;
          case FRAGMENT:
            hint(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_CONTENT : I18nConstants.VALUESET_INCLUDE_CSVER_CONTENT, system, cs.getContent().toCode(), version);             
            break;
          case SUPPLEMENT:
            validateConcepts = false;
            ok = rule(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_SUPPLEMENT : I18nConstants.VALUESET_INCLUDE_CSVER_SUPPLEMENT, system, cs.getSupplements(), version) && ok;             
            break;
          case NOTPRESENT:
            // what happens next depends on whether we can validate this codeSystem
            if (!context.getTxSupportInfo(cs.getUrl(), cs.getVersion()).isServerSide()) {
              validateConcepts = false;
              warning(errors, "2024-03-06", IssueType.INVALID, stack, false, version == null ? I18nConstants.VALUESET_INCLUDE_CS_CONTENT : I18nConstants.VALUESET_INCLUDE_CSVER_CONTENT, system, cs.getContent().toCode(), version);
            }
            break;
          default:
            break;
          }
        }
      } else {
        if (system.startsWith("urn:oid:")) {
          List<CodeSystem> csl = cu.fetchByIdentifier(CodeSystem.class, system);
          if (!csl.isEmpty()) {
            if (csl.size() == 1) {
              ok = rule(errors, "2025-01-09", IssueType.INVALID, stack, csl.isEmpty(), I18nConstants.VALUESET_INCLUDE_WRONG_CS_OID, system, csl.get(0).getUrl()) && ok;
            } else {
              List<String> ids = new ArrayList<>();
              for (CodeSystem c : csl) {
                ids.add(c.getVersionedUrl());
              }
              ok = rule(errors, "2025-01-09", IssueType.INVALID, stack, csl.isEmpty(), I18nConstants.VALUESET_INCLUDE_WRONG_CS_OID_PLURAL, system, CommaSeparatedStringBuilder.join(",", ids)) && ok;
            }
          }
        }
        ValueSet vs = context.findTxResource(ValueSet.class, system, version, null);
        if (vs != null) {
          validateConcepts = false;
          List<String> systems = TerminologyUtilities.listSystems(vs);
          if (systems.size() == 0) {
            ok = rule(errors, "2025-01-09", IssueType.INVALID, stack, false, I18nConstants.VALUESET_INCLUDE_WRONG_VS, system) && ok;
          } else if (systems.size() == 1) {
            ok = rule(errors, "2025-01-09", IssueType.INVALID, stack, false, I18nConstants.VALUESET_INCLUDE_WRONG_VS_HINT, system, systems.get(0)) && ok;
          } else { 
            ok = rule(errors, "2025-01-09", IssueType.INVALID, stack, false, I18nConstants.VALUESET_INCLUDE_WRONG_VS_MANY, system, CommaSeparatedStringBuilder.join(", ", systems)) && ok;
          }
        }
      }
      if (policyAdvisor.policyForSpecialValidation((IResourceValidator) parent, valContext.getAppContext(), SpecialValidationRule.VALUESET_SYSTEM_CHECKS, stack.getLiteralPath(), vsSrc, include) == SpecialValidationAction.CHECK_RULE) {

        if (!noTerminologyChecks && validateConcepts) {
          boolean systemOk = true;
          int cc = 0;
          List<VSCodingValidationRequest> batch = new ArrayList<>();
          boolean first = true;
          if (concepts.size() > TOO_MANY_CODES_TO_VALIDATE) {
            hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_INC_TOO_MANY_CODES, concepts.size());
          } else if (!((InstanceValidator) parent).isValidateValueSetCodesOnTxServer()) {
            hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_INC_NOT_VALIDATING, concepts.size());
          } else if (context.isNoTerminologyServer()) {
            hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_INC_NO_SERVER, concepts.size());
          } else {
            var si = context.getTxSupportInfo(system, version);
            if (concepts.size() > 1 && !si.isSupported()) {
              hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_INC_CS_NO_SUPPORT, si.getServer());
            } else if (concepts.size() > 1 && (si.getTestVersion() == null || !VersionUtilities.isThisOrLater("1.7.8", si.getTestVersion(), VersionUtilities.VersionPrecision.PATCH))) {
              hint(errors, "2023-09-06", IssueType.BUSINESSRULE, stack, false, I18nConstants.VALUESET_INC_NO_BATCH_ON_SERVER, si.getServer());
            } else {
              try {
                for (Element concept : concepts) {
                  // we treat the first differently because we want to know if the system is worth validating. if it is, then we batch the rest
                  if (first) {
                    systemOk = validateValueSetIncludeConcept(errors, concept, stack, stack.push(concept, cc, null, null), system, version, csChecker, cs != null);
                    first = false;
                  } else if (systemOk) {
                    batch.add(prepareValidateValueSetIncludeConcept(errors, concept, stack.push(concept, cc, null, null), system, version, csChecker));
                    if (batch.size() > VALIDATION_BATCH_SIZE) {
                      executeValidationBatch(errors, vsid, retired, system, version, batch, stack);
                      batch.clear();
                    }
                  }
                  cc++;
                }
                executeValidationBatch(errors, vsid, retired, system, version, batch, stack);
              } catch (Exception e) {
                ok = false;
                VSCodingValidationRequest cv = batch.get(0);
                rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, cv.getStack().getLiteralPath(), false, e.getMessage());
              }
            }
          }
        }
        int cf = 0;
        for (Element filter : filters) {
          ok = validateValueSetIncludeFilter(errors, filter, stack.push(filter, cf, null, null), system, version, cs, csChecker, parameters) & ok;
          cf++;
        }    
      }
      csChecker.finish(include, stack);
    } else {
      warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, filters.size() == 0 && concepts.size() == 0, I18nConstants.VALUESET_NO_SYSTEM_WARNING);      
    }
    return ok;
  }

  private void executeValidationBatch(List<ValidationMessage> errors, String vsid, boolean retired, String system,
      String version, List<VSCodingValidationRequest> batch, NodeStack baseStack) {
    if (batch.size() > 0) {
      IWorkerContext.SystemSupportInformation txInfo = context.getTxSupportInfo(system, version);
      if (warning(errors, "2025-07-07", IssueType.NOTSUPPORTED, baseStack,  txInfo.getTestVersion() != null && VersionUtilities.isThisOrLater(TerminologyClientContext.TX_BATCH_VERSION, txInfo.getTestVersion(), VersionUtilities.VersionPrecision.MINOR), I18nConstants.VALUESET_TXVER_BATCH_NOT_SUPPORTED, (txInfo.getTestVersion() == null ? "Not Known" : txInfo.getTestVersion()), system+(version == null ? "" : "|"+version), txInfo.getServer())) {
        long t = System.currentTimeMillis();
        log.debug("  : Validate "+batch.size()+" codes from "+system+" for "+vsid);
        context.validateCodeBatch(ValidationOptions.defaults().withExampleOK().setDisplayWarningMode(true), batch, null, false);
        log.debug("  :   .. "+(System.currentTimeMillis()-t)+"ms");
        for (VSCodingValidationRequest cv : batch) {
          if (version == null) {
            warningOrError(!retired, errors, NO_RULE_DATE, IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, cv.getCoding().getCode(), cv.getResult().getMessage());
          } else {
            warningOrError(!retired, errors, NO_RULE_DATE, IssueType.BUSINESSRULE, cv.getStack(), cv.getResult().isOk(), I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, cv.getCoding().getCode(), cv.getResult().getMessage());
          }
          processConceptIssues(errors, cv.getStack().getElement(), cv.getStack(), system, version, cv.getResult(), cv.getCoding().getDisplay());
        }
      }
    }
  }

  private boolean validateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stackInc, NodeStack stack, String system, String version, CodeSystemChecker slv, boolean locallyKnownCodeSystem) {
    String code = concept.getChildValue("code");
    String display = concept.getChildValue("display");
    slv.checkConcept(code, display);

    if (!noTerminologyChecks) {
      if (version == null) {
        ValidationResult vv = context.validateCode(ValidationOptions.defaults().withExampleOK().setDisplayWarningMode(true), new Coding(system, code, display), null);
        if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
          if (isExampleUrl(system)) {
            if (settings.isAllowExamples()) {
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
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, code, vv.getMessage());
          if (vv.hasIssues()) {
            processConceptIssues(errors, concept, stack, system, version, vv, display);
          } else if (vv.getMessage() != null) {
            hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, false, vv.getMessage());
          }
        }
      } else {
        ValidationResult vv = context.validateCode(ValidationOptions.defaults().withExampleOK().setDisplayWarningMode(true), new Coding(system, code, display).setVersion(version), null);
        if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
          warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stackInc.getLiteralPath(), false, I18nConstants.VALUESET_UNC_SYSTEM_WARNING_VER, system+"#"+version, vv.getMessage());            
          return false;        
        } else {
          boolean ok = vv.isOk();
          rule(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, code, vv.getMessage());
          if (vv.hasIssues()) {
            processConceptIssues(errors, concept, stack, system, version, vv, display);
          } else if (vv.getMessage() != null) {
            hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack, false, vv.getMessage());
          }
        }
      }
    }
    return true;
  }

  private void processConceptIssues(List<ValidationMessage> errors, Element concept, NodeStack stack, String system, String version, ValidationResult vv, String display) {
    for (OperationOutcome.OperationOutcomeIssueComponent iss : vv.getIssues()) {
      if (iss.getDetails().hasCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "invalid-code")) {
        // already handled.
      } else if (iss.getDetails().hasCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "invalid-display")) {
        hint(errors, "2025-10-30", IssueType.INFORMATIONAL, stack, false,
          version == null ? I18nConstants.VALUESET_CODE_CONCEPT_HINT :  I18nConstants.VALUESET_CODE_CONCEPT_HINT_VER, display, system, version, iss.getDetails().getText());
      } else {
        var validationMessage = buildValidationMessage(vv.getTxLink(), vv.getDiagnostics(), concept.line(), concept.col(), stack.getLiteralPath(), iss);
        errors.add(validationMessage);
      }
    }
  }

  private VSCodingValidationRequest prepareValidateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String system, String version, CodeSystemChecker slv) {
    String code = concept.getChildValue("code");
    String display = concept.getChildValue("display");
    slv.checkConcept(code, display);

    Coding c = new Coding(system, code, display);
    if (version != null) {
      c.setVersion(version);
    }
    return new VSCodingValidationRequest(stack, c);
  }

  private boolean validateValueSetIncludeFilter(List<ValidationMessage> errors, Element filter, NodeStack stack, String system, String version, CodeSystem cs, CodeSystemChecker csChecker, List<ParameterDeclaration> params) {
    boolean ok = true;
    String property = filter.getChildValue("property");
    String op = filter.getChildValue("op");
    Element ve = filter.getNamedChild("value");
    String value = ve == null ? null : ve.primitiveValue();
    Element expr = ve == null ? null : ve.getExtension(ExtensionDefinitions.EXT_CQF_EXP);
    
    if (property != null) {
      List<String> knownNames = new ArrayList<String>();
      csChecker.listPropertyNames(knownNames);

      boolean pok = false;
      if (cs == null) {
        pok = hint(errors, "2024-03-09", IssueType.INVALID, stack, knownNames.contains(property), I18nConstants.VALUESET_UNKNOWN_FILTER_PROPERTY_NO_CS, property, system, CommaSeparatedStringBuilder.join(",", knownNames));        
      } else {
        pok = warning(errors, "2024-03-09", IssueType.INVALID, stack, knownNames.contains(property), I18nConstants.VALUESET_UNKNOWN_FILTER_PROPERTY, property, system, CommaSeparatedStringBuilder.join(",", knownNames));
      }
      if (pok) {
        PropertyValidationRules rules = csChecker.rulesForFilter(property, EnumSet.noneOf(PropertyOperation.class));
        if (rules != null) {
          if (!rules.getOps().isEmpty()) {
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, opInSet(op, rules.getOps()), I18nConstants.VALUESET_BAD_FILTER_OP, op, property, CommaSeparatedStringBuilder.join(",", rules.getOps()), system) && ok;
          }

          if (value == null) {
            if (rule(errors, "2024-03-09", IssueType.INVALID, stack, expr != null && expr.hasChild("value"), I18nConstants.VALUESET_BAD_FILTER_EXPR_OR_VALUE)) {
              NodeStack estack = stack.push(expr, -1, null, null);  
              expr = expr.getNamedChild("value"); 
              estack = estack.push(expr, -1, null, null);  
              String lang = expr.getNamedChildValue("language");
              if (rule(errors, "2024-03-09", IssueType.INVALID, estack, "text/fhirpath".equals(lang), I18nConstants.VALUESET_BAD_FILTER_EXPR_LANG, lang)) {
                String expression = expr.getNamedChildValue("expression");
                ExpressionNode node = null;
                try {
                  node = fpe.parse(expression);
                } catch (Exception e) {
                  rule(errors, "2024-03-09", IssueType.EXCEPTION, estack, false, I18nConstants.VALUESET_BAD_FILTER_EXPR_VALUE, expression, e.getMessage());
                  ok = false;
                }
                if (node != null) {
                  Set<String> constants = new HashSet<>();
                  scanForConstants(constants, node);
                  for (String s : constants) {
                    String pn = s.substring(1);
                    ParameterDeclaration p = null;
                    for (ParameterDeclaration pd : params) {
                      if (pd.getName().equals(pn)) {
                        p = pd;
                      }
                    }
                    if (p == null) {
                      rule(errors, "2024-03-09", IssueType.EXCEPTION, estack, false, I18nConstants.VALUESET_BAD_FILTER_EXPR_PARAM_NAME, expression, pn);
                      ok = false;                    
                    } else {
                      p.used = true;
                    }
                  }
                }
              } else {
                ok = false;
              }
            } else {
              ok = false;
            }

          } else {
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, expr == null, I18nConstants.VALUESET_BAD_FILTER_EXPR_AND_VALUE) && ok;
            
            if (rules.isActive()) {
              StringWithFlag msg = csChecker.checkFilterValue(system, version, property, op, value, rules, ValidationOptions.defaults());
              if (msg == null) {
                // nothing
              } else if (msg.isFail()) {
                warning(errors, "2025-06-16", IssueType.INVALID, stack, msg == null, I18nConstants.VALUESET_BAD_FILTER_VALUE_CANT_CHECK, property, value, msg.getMsg());
              } else {
                ok = rule(errors, "2025-06-16", IssueType.INVALID, stack, msg == null, I18nConstants.VALUESET_BAD_FILTER_VALUE_INVALID, property, value, msg.getMsg()) && ok;                
              }
            } else if ("exists".equals(op)) {
              ok = checkFilterValue(errors, stack, system, version, ok, property, op, value,  new PropertyValidationRules(PropertyFilterType.Boolean, null)) && ok;
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
                ok = checkFilterValue(errors, stack, system, version, ok, property, op, v, rules) && ok;
              }
            } else {
              ok = checkFilterValue(errors, stack, system, version, ok, property, op, value, rules) && ok;
            }
          }
        }
      }
    }

    return ok;
  }

  private void scanForConstants(Set<String> constants, ExpressionNode node) {
    if (node.getKind() == Kind.Constant) {
      constants.add(node.getConstant().primitiveValue());
    }
    if (node.getOpNext() != null) {
      scanForConstants(constants, node.getOpNext());
    }
    if (node.getInner() != null) {
      scanForConstants(constants, node.getInner());
    }
    if (node.getGroup() != null) {
      scanForConstants(constants, node.getGroup());
    }
    if (node.getParameters() != null) {
      for (ExpressionNode p : node.getParameters()) {
        scanForConstants(constants, p);
      }
    }
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

  private boolean checkFilterValue(List<ValidationMessage> errors, NodeStack stack, String system, String version,boolean ok, String property, String op, String value, PropertyValidationRules rules) {
    if (rules.getType() != null) {
      if (!Utilities.existsInList(op, "in", "not-in")) {
        hint(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(), !value.contains(","), I18nConstants.VALUESET_BAD_FILTER_VALUE_HAS_COMMA, rules.getType().toString());
      }
      switch (rules.getType()) {
      case Boolean:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, 
            Utilities.existsInList(value, "true", "false"), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_BOOLEAN, property, value) && ok;
        break;
      case String:
        // nothing to check
        break;
      case Code:
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, 
            value.trim().equals(value), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_CODE, property, value) && ok;
        if (!noTerminologyChecks && (rules.getCodeValidation() == CodeValidationRule.Error || rules.getCodeValidation() == CodeValidationRule.Warning)) {
          ValidationResult vr = context.validateCode(settings, system, version, value, null);
          if (vr.isOk()) {
            warning(errors, "2025-06-04", IssueType.INVALID, stack.getLiteralPath(), !vr.isInactive(), I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE_INACTIVE, property, value, system);            
          } else if (rules.getCodeValidation() == CodeValidationRule.Error) {
            ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(), false, rules.isChange() ? I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE_CHANGE : I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE, property, value, system, vr.getMessage()) && ok;
          } else {
            warning(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(), false, rules.isChange() ? I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE_CHANGE : I18nConstants.VALUESET_BAD_FILTER_VALUE_VALID_CODE, property, value, system, vr.getMessage());
          }
        }
        break;
      case CodeList:
        ok = rule(errors, "2024-05-12", IssueType.INVALID, stack.getLiteralPath(), rules.getCodeList().contains(value), I18nConstants.VALUESET_BAD_FILTER_VALUE_DATETIME, property, value) && ok;
        break;        
      case DateTime:
        if (value != null && Utilities.startsWithInList(value, "eq", "ne", "gt", "lt", "ge", "le", "sa", "eb", "ap")) {
          value = value.substring(2);
        }  
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(),
            value.matches("([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)(-(0[1-9]|1[0-2])(-(0[1-9]|[1-2][0-9]|3[0-1])(T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]+)?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?)?)?)?"), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_DATETIME, property, value) && ok;
        break;
      case Decimal:
        if (value != null && Utilities.startsWithInList(value, "eq", "ne", "gt", "lt", "ge", "le", "sa", "eb", "ap")) {
          value = value.substring(2);
        }  
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(),
            Utilities.isDecimal(value, true), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_DECIMAL, property, value) && ok;
        break;
      case Integer:
        if (value != null && Utilities.startsWithInList(value, "eq", "ne", "gt", "lt", "ge", "le", "sa", "eb", "ap")) {
          value = value.substring(2);
        }  
        ok = rule(errors, "2024-03-09", IssueType.INVALID, stack.getLiteralPath(),
            Utilities.isInteger(value), 
            I18nConstants.VALUESET_BAD_FILTER_VALUE_INTEGER, property, value) && ok;
        break;
      case Coding :
        Coding code;
        if (value.matches("[a-zA-Z][a-zA-Z0-9+.-]*:[^\\s|]+\\|\\S+")) {
          warning(errors, "2025-07-10", IssueType.INVALID, stack, false, I18nConstants.VALUESET_BAD_FILTER_VALUE_CODED_LEGACY, property, value);
          code = new Coding().setSystem(value.substring(0, value.lastIndexOf("|"))).setCode(value.substring(value.lastIndexOf("|") + 1));
        } else {
          code = Coding.fromLiteral(value);
        }

        if (code == null) {
          ok = rule(errors, "2025-07-10", IssueType.INVALID, stack, false, I18nConstants.VALUESET_BAD_FILTER_VALUE_CODED, property, value) && ok;
        } else if (!noTerminologyChecks) {
          ValidationResult vr = context.validateCode(settings, code, null);
          ok = rule(errors, "2024-03-09", IssueType.INVALID, stack, vr.isOk(), I18nConstants.VALUESET_BAD_FILTER_VALUE_CODED_INVALID, property, value, vr.getMessage()) && ok;
        }
        break;
      default:
        break;        
      }
    }
    return ok;
  }


}
