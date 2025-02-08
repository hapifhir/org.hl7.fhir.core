package org.hl7.fhir.r5.utils.validation;

import java.util.List;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

@MarkedToMoveToAdjunctPackage
public interface IMessagingServices {
  ValidationMessage signpost(List<ValidationMessage> errors, String ruleDate, IssueType type, int line, int col, String path, String theMessage, Object... theMessageArguments);

}
