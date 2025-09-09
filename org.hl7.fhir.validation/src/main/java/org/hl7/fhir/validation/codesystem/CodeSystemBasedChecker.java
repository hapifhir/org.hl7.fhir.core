package org.hl7.fhir.validation.codesystem;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.CodeValidationRule;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyFilterType;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;

public class CodeSystemBasedChecker extends CodeSystemChecker {

  private CodeSystem cs;

  public CodeSystemBasedChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, CodeSystem cs, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
    this.cs = cs;
  }

  @Override
  public void listPropertyNames(List<String> knownNames) {
    super.listPropertyNames(knownNames);
    if (cs.hasHierarchyMeaning()) {
      knownNames.add("parent");
      knownNames.add("child");
      knownNames.add("partOf");
    }
    for (CodeSystemFilterComponent f : cs.getFilter()) {
      addName(knownNames, f.getCode());
    }
    for (PropertyComponent p : cs.getProperty()) {
      addName(knownNames, p.getCode());
    }
  }

  @Override
  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {

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
            boolean external = !settings.isForPublication() || cs.getWebPath() == null || Utilities.isAbsoluteUrl(cs.getWebPath());
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
    
    return super.rulesForFilter(property, ops);
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
  
}
