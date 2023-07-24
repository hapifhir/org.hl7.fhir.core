package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.CodingValidationRequest;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
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
import org.hl7.fhir.validation.instance.type.ValueSetValidator.SystemLevelValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class ValueSetValidator extends BaseValidator {

  public class SystemLevelValidator {
    protected List<ValidationMessage> errors; 
    protected Element inc;
    protected NodeStack stack;
    
    private boolean noDisplay = false;
    private boolean hasDisplay = false;
    protected SystemLevelValidator(List<ValidationMessage> errors, Element inc, NodeStack stack) {
      super();
      this.errors = errors;
      this.inc = inc;
      this.stack = stack;
    }
    
    public void checkConcept(String code, String display) {
      if (Utilities.noString(display)) {
        noDisplay = true;
      } else {
        hasDisplay = true;
      }      
    }
    
    public void finish() {
      hint(errors, "2023-07-21", IssueType.BUSINESSRULE, inc.line(), inc.col(), stack.getLiteralPath(), !(noDisplay && hasDisplay), I18nConstants.VALUESET_CONCEPT_DISPLAY_PRESENCE_MIXED);           
    } 
  }

  public class SnomedCTValidator extends SystemLevelValidator {
    private boolean noTag = false;
    private boolean hasTag = false;
    
    protected SnomedCTValidator(List<ValidationMessage> errors, Element inc, NodeStack stack) {
      super(errors, inc, stack);
    }
    public void checkConcept(String code, String display) {
      super.checkConcept(code, display);
      if (!Utilities.noString(display)) {
        boolean tagged = display.endsWith(")") && display.indexOf("(") > display.length() - 20;
        if (tagged) {
          hasTag = true;
        } else {
          noTag = true;
        }      
      }
    }
    public void finish() {
      hint(errors, "2023-07-21", IssueType.BUSINESSRULE, inc.line(), inc.col(), stack.getLiteralPath(), !(noTag && hasTag), I18nConstants.VALUESET_CONCEPT_DISPLAY_SCT_TAG_MIXED);           
    }
  }

  public class GeneralValidator extends SystemLevelValidator {

    protected GeneralValidator(List<ValidationMessage> errors, Element inc, NodeStack stack) {
      super(errors, inc, stack);
    }

  }

  private SystemLevelValidator getSystemValidator(String system, List<ValidationMessage> errors, Element inc, NodeStack stack) {
    if (system == null) {
      return new GeneralValidator(errors, inc, stack);
    }
    switch (system) {
    case "http://snomed.info/sct" :return new SnomedCTValidator(errors, inc, stack);
    default: return new GeneralValidator(errors, inc, stack);
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

  private InstanceValidator parent;

  public ValueSetValidator(IWorkerContext context, boolean debug, TimeTracker timeTracker, InstanceValidator parent, XVerExtensionManager xverManager, Coding jurisdiction, boolean allowExamples) {
    super(context, xverManager, debug);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
    this.parent = parent;
    this.jurisdiction = jurisdiction;
    this.allowExamples = allowExamples;
  }
  
  public boolean validateValueSet(List<ValidationMessage> errors, Element vs, NodeStack stack) {
    boolean ok = true;
    if (!VersionUtilities.isR2Ver(context.getVersion())) {
      List<Element> composes = vs.getChildrenByName("compose");
      int cc = 0;
      for (Element compose : composes) {
        ok = validateValueSetCompose(errors, compose, stack.push(compose, cc, null, null), vs.getNamedChildValue("url"), "retired".equals(vs.getNamedChildValue("url"))) & ok;
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
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("url"), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "url") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("version"), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "version") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("title"), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "title") && ok;                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("name"), I18nConstants.VALUESET_SHAREABLE_EXTRA_MISSING_HL7, "name");                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("status"), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "status") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("experimental"), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "experimental") && ok;                      
        ok = rule(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("description"), I18nConstants.VALUESET_SHAREABLE_MISSING_HL7, "description") && ok;
        return ok;
      } else {
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("url"), I18nConstants.VALUESET_SHAREABLE_MISSING, "url");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("version"), I18nConstants.VALUESET_SHAREABLE_MISSING, "version");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("title"), I18nConstants.VALUESET_SHAREABLE_MISSING, "title");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("name"), I18nConstants.VALUESET_SHAREABLE_EXTRA_MISSING, "name");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("status"), I18nConstants.VALUESET_SHAREABLE_MISSING, "status");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("experimental"), I18nConstants.VALUESET_SHAREABLE_MISSING, "experimental");                      
        warning(errors, NO_RULE_DATE, IssueType.REQUIRED, vs.line(), vs.col(), stack.getLiteralPath(), vs.hasChild("description"), I18nConstants.VALUESET_SHAREABLE_MISSING, "description");
      }
    }
    return true;
  }


  private boolean validateValueSetCompose(List<ValidationMessage> errors, Element compose, NodeStack stack, String vsid, boolean retired) {
    boolean ok = true;
    List<Element> includes = compose.getChildrenByName("include");
    int ci = 0;
    for (Element include : includes) {
      ok = validateValueSetInclude(errors, include, stack.push(include, ci, null, null), vsid, retired) && ok;
      ci++;
    }    
    List<Element> excludes = compose.getChildrenByName("exclude");
    int ce = 0;
    for (Element exclude : excludes) {
      ok = validateValueSetInclude(errors, exclude, stack.push(exclude, ce, null, null), vsid, retired) && ok;
      ce++;
    }    
    return ok;
  }
  
  private boolean validateValueSetInclude(List<ValidationMessage> errors, Element include, NodeStack stack, String vsid, boolean retired) {
    boolean ok = true;
    String system = include.getChildValue("system");
    String version = include.getChildValue("version");
    List<Element> valuesets = include.getChildrenByName("valueSet");
    int i = 0;
    for (Element ve : valuesets) {
      String v = ve.getValue();
      ValueSet vs = context.fetchResource(ValueSet.class, v);
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
      warning(errors, NO_RULE_DATE, IssueType.INFORMATIONAL, stack.getLiteralPath(), false, I18nConstants.VALUESET_IMPORT_UNION_INTERSECTION);                  
    }
    List<Element> concepts = include.getChildrenByName("concept");
    List<Element> filters = include.getChildrenByName("filter");

    SystemLevelValidator slv = getSystemValidator(system, errors, include, stack);
    if (!Utilities.noString(system)) {
      boolean systemOk = true;
      int cc = 0;
      List<VSCodingValidationRequest> batch = new ArrayList<>();
      boolean first = true;
      for (Element concept : concepts) {
        // we treat the first differently because we want to know if tbe system is worth validating. if it is, then we batch the rest
        if (first) {
          systemOk = validateValueSetIncludeConcept(errors, concept, stack, stack.push(concept, cc, null, null), system, version, slv);
          first = false;
        } else if (systemOk) {
          batch.add(prepareValidateValueSetIncludeConcept(errors, concept, stack.push(concept, cc, null, null), system, version, slv));
        }
        cc++;
      }    
      if (parent.isValidateValueSetCodesOnTxServer() && batch.size() > 0 & !context.isNoTerminologyServer()) {
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
              ok = warningOrHint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, cv.getStack().getLiteralPath(), cv.getResult().isOk(), !retired, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, cv.getCoding().getCode()) && ok;
            } else {
              ok = warningOrHint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, cv.getStack().getLiteralPath(), cv.getResult().isOk(), !retired, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, cv.getCoding().getCode()) && ok;
            }
          }
        } catch (Exception e) {
          ok = false;
          VSCodingValidationRequest cv = batch.get(0);
          rule(errors, NO_RULE_DATE, IssueType.EXCEPTION, cv.getStack().getLiteralPath(), false, e.getMessage());
        }
      }
      
      int cf = 0;
      for (Element filter : filters) {
        if (systemOk && !validateValueSetIncludeFilter(errors, include, stack.push(filter, cf, null, null), system, version, slv)) {
          systemOk = false;          
        }
        cf++;
      }    
      slv.finish();
    } else {
      warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), filters.size() == 0 && concepts.size() == 0, I18nConstants.VALUESET_NO_SYSTEM_WARNING);      
    }
    return ok;
  }


  private boolean validateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stackInc, NodeStack stack, String system, String version, SystemLevelValidator slv) {
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
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, code);
        if (vv.getMessage() != null) {
          hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), false, vv.getMessage());
        }
      }
    } else {
      ValidationResult vv = context.validateCode(ValidationOptions.defaults(), new Coding(system, code, null).setVersion(version), null);
      if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stackInc.getLiteralPath(), false, I18nConstants.VALUESET_UNC_SYSTEM_WARNING_VER, system+"#"+version, vv.getMessage());            
        return false;        
      } else {
        boolean ok = vv.isOk();
        warning(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, code);
        if (vv.getMessage() != null) {
          hint(errors, NO_RULE_DATE, IssueType.BUSINESSRULE, stack.getLiteralPath(), false, vv.getMessage());
        }
      }
    }
    return true;
  }

  private VSCodingValidationRequest prepareValidateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String system, String version, SystemLevelValidator slv) {
    String code = concept.getChildValue("code");
    String display = concept.getChildValue("display");
    slv.checkConcept(code, display);
    
    Coding c = new Coding(system, code, null);
    if (version != null) {
       c.setVersion(version);
    }
    return new VSCodingValidationRequest(stack, c);
  }

  private boolean validateValueSetIncludeFilter(List<ValidationMessage> errors, Element filter, NodeStack push, String system, String version, SystemLevelValidator slv) {
//
//    String display = concept.getChildValue("display");
//    slv.checkConcept(code, display);
    
    return true;
  }
}
