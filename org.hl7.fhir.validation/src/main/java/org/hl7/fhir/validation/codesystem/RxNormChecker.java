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

public class RxNormChecker extends CodeSystemChecker {

  public RxNormChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
  }
  

  @Override
  public void listPropertyNames(List<String> knownNames) {
    super.listPropertyNames(knownNames);
    addName(knownNames, "STY");
    addName(knownNames, "SAB");
    addName(knownNames, "TTY");
    addName(knownNames, "SY");
    addName(knownNames, "SIB");
    addName(knownNames, "RN");
    addName(knownNames, "PAR");
    addName(knownNames, "CHD");
    addName(knownNames, "RB");
    addName(knownNames, "RO");
    addName(knownNames, "IN");
    addName(knownNames, "PIN");
    addName(knownNames, "MIN");
    addName(knownNames, "BN");
    addName(knownNames, "SCD");
    addName(knownNames, "SBD");
    addName(knownNames, "GPCK");
    addName(knownNames, "BPCK");
    addName(knownNames, "SCDC");
    addName(knownNames, "SCDF");
    addName(knownNames, "SCDFP");
    addName(knownNames, "SCDG");
    addName(knownNames, "SCDGP");
    addName(knownNames, "SBDC");
    addName(knownNames, "SBDF");
    addName(knownNames, "SBDFP");
    addName(knownNames, "SBDG");
    addName(knownNames, "DF");
    addName(knownNames, "DFG");

  }
  
  @Override
  public PropertyValidationRules rulesForFilter(String property, EnumSet<PropertyOperation> ops) {
    return new PropertyValidationRules(PropertyFilterType.Code, CodeValidationRule.None, ops);
  }
  
}
