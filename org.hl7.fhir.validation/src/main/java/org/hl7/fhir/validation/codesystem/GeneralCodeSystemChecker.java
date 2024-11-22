package org.hl7.fhir.validation.codesystem;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class GeneralCodeSystemChecker extends CodeSystemChecker {

  public GeneralCodeSystemChecker(IWorkerContext context, XVerExtensionManager xverManager, boolean debug, List<ValidationMessage> errors, ValidatorSession session) {
    super(context, xverManager, debug, errors, session);
    // TODO Auto-generated constructor stub
  }

}
