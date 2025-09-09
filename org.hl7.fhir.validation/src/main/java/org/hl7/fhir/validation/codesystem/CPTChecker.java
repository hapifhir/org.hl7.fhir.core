package org.hl7.fhir.validation.codesystem;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.CodeValidationRule;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyFilterType;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;

public class CPTChecker extends CodeSystemChecker {

  public CPTChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
  }
  
  @Override
  public void listPropertyNames(List<String> knownNames) {
    super.listPropertyNames(knownNames);
    addName(knownNames, "modifier");
    addName(knownNames, "kind");
    addName(knownNames, "modified");
    addName(knownNames, "code");
    addName(knownNames, "telemedicine");
    addName(knownNames, "orthopox");
  }

  @Override
  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {
    switch (property) {
    case "modifier": return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
    case "kind" : return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops); // for now
    case "modified": return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
    case "code" : return null;
    case "telemedicine": return new PropertyValidationRules(PropertyFilterType.Boolean, null, ops);
    case "orthopox" : return new PropertyValidationRules(PropertyFilterType.Boolean,null,  ops);
    }
    return null;
  }
  
}
