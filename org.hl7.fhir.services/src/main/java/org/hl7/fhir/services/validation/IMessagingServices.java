package org.hl7.fhir.services.validation;

import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

import java.util.List;


public interface IMessagingServices {
  ValidationMessage signpost(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, String theMessage, Object... theMessageArguments);

}
