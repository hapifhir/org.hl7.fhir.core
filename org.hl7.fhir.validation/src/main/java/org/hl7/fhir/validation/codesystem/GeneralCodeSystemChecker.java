package org.hl7.fhir.validation.codesystem;

import java.util.List;

import javax.annotation.Nonnull;

import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.validation.ValidatorSession;
import org.hl7.fhir.services.xver.XVerExtensionManager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidatorSettings;

public class GeneralCodeSystemChecker extends CodeSystemChecker {

  public GeneralCodeSystemChecker(IWorkerContext context, @Nonnull ValidatorSettings settings, XVerExtensionManager xverManager, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, settings, xverManager, errors, session);
    // TODO Auto-generated constructor stub
  }

}
