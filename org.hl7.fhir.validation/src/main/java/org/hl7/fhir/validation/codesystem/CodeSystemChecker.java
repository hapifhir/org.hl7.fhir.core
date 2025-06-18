package org.hl7.fhir.validation.codesystem;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.CodeValidationRule;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyFilterType;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public abstract class CodeSystemChecker extends BaseValidator {

  public class StringWithFlag {

    private String msg;
    private boolean fail;
    public StringWithFlag(String msg, boolean fail) {
      super();
      this.msg = msg;
      this.fail = fail;
    }
    public String getMsg() {
      return msg;
    }
    public boolean isFail() {
      return fail;
    }

  }
  private boolean noDisplay = false;
  private boolean hasDisplay = false;
  protected List<ValidationMessage> errors;

  protected CodeSystemChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, session);
    this.errors = errors;
  }

  public void checkConcept(String code, String display) {
    if (Utilities.noString(display)) {
      noDisplay = true;
    } else {
      hasDisplay = true;
    }      
  }

  public void finish(Element inc, NodeStack stack) {
    hint(errors, "2023-07-21", IssueType.BUSINESSRULE, inc.line(), inc.col(), stack.getLiteralPath(), !(noDisplay && hasDisplay), I18nConstants.VALUESET_CONCEPT_DISPLAY_PRESENCE_MIXED);           
  }

  /** 
   * these are true in all code systems
   * 
   * @param knownNames
   */
  public void listPropertyNames(List<String> knownNames) {
    knownNames.add("concept");
    knownNames.add("code");
    knownNames.add("status");
    knownNames.add("inactive");
    knownNames.add("effectiveDate");
    knownNames.add("deprecationDate");
    knownNames.add("retirementDate");
    knownNames.add("notSelectable");
    knownNames.add("synonym");
    knownNames.add("comment");
    knownNames.add("itemWeight");
  } 


  protected void addName(List<String> knownNames, String code) {
    if (code != null && !knownNames.contains(code)) {
      knownNames.add(code);
    }    
  }

  protected EnumSet<PropertyOperation> addToOps(EnumSet<PropertyOperation> set, PropertyOperation... ops) {
    for (PropertyOperation op : ops) {
      set.add(op);
    }
    return set;
  }

  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {
    switch (property) {
    case "concept" :
      return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, 
          VersionUtilities.isR5Plus(context.getVersion()) ?
              addToOps(ops, PropertyOperation.Equals, PropertyOperation.In, PropertyOperation.IsA, PropertyOperation.DescendentOf,  
                  PropertyOperation.DescendentLeaf, PropertyOperation.IsNotA,  PropertyOperation.Generalizes, PropertyOperation.ChildOf, PropertyOperation.NotIn) :      
                    addToOps(ops, PropertyOperation.Equals, PropertyOperation.In, PropertyOperation.IsA, PropertyOperation.DescendentOf,   
                        PropertyOperation.IsNotA,  PropertyOperation.Generalizes, PropertyOperation.NotIn));
    case "code" : 
      return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.Error, 
          VersionUtilities.isR5Plus(context.getVersion()) ?
              addToOps(ops, PropertyOperation.RegEx, PropertyOperation.Equals, PropertyOperation.In, PropertyOperation.IsA, PropertyOperation.DescendentOf,  
                  PropertyOperation.DescendentLeaf, PropertyOperation.IsNotA,  PropertyOperation.Generalizes, PropertyOperation.ChildOf, PropertyOperation.NotIn) :      
                    addToOps(ops, PropertyOperation.RegEx, PropertyOperation.Equals, PropertyOperation.In, PropertyOperation.IsA, PropertyOperation.DescendentOf,   
                        PropertyOperation.IsNotA,  PropertyOperation.Generalizes, PropertyOperation.NotIn));
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
    return null;
  }

  public String checkFilterValue(String system, String version, String property, String op, String value, PropertyValidationRules rules) {
    return null;
  }

  public StringWithFlag checkFilterValue(String system, String version, String property, String op, String value,
      PropertyValidationRules rules, ValidationOptions options) {
    return null;
  }

}