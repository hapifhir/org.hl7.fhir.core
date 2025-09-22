package org.hl7.fhir.validation.codesystem;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyOperation;
import org.hl7.fhir.validation.instance.type.ValueSetValidator.PropertyValidationRules;

public class BCP47Checker extends CodeSystemChecker {

  public BCP47Checker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
  }
  

  @Override
  public void listPropertyNames(List<String> knownNames) {
    super.listPropertyNames(knownNames);
    addName(knownNames, "language");
    addName(knownNames, "region");
    addName(knownNames, "script");
    addName(knownNames, "variant");
    addName(knownNames, "extension");
    addName(knownNames, "ext-lang");
    addName(knownNames, "private-use");
  }


  @Override
  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {
    // TODO Auto-generated method stub
    return super.rulesForFilter(property, ops);
  }
  
  
}
