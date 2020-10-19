package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class SchemaValidator {

  public static void validateSchema(String location, Manager.FhirFormat cntType, List<ValidationMessage> messages) throws IOException, SAXException {
    if (cntType == Manager.FhirFormat.JSON)
      validateJsonSchema(location, messages);
    if (cntType == Manager.FhirFormat.XML)
      validateXmlSchema(location, messages);
    if (cntType == Manager.FhirFormat.TURTLE)
      validateSHEX(location, messages);
  }

  private static void validateSHEX(String location, List<ValidationMessage> messages) {
    messages.add(new ValidationMessage(ValidationMessage.Source.InstanceValidator, ValidationMessage.IssueType.INFORMATIONAL, location, "SHEX Validation is not done yet", ValidationMessage.IssueSeverity.INFORMATION));
  }

  private static void validateXmlSchema(String location, List<ValidationMessage> messages) throws FileNotFoundException, IOException, SAXException {
    messages.add(new ValidationMessage(ValidationMessage.Source.InstanceValidator, ValidationMessage.IssueType.INFORMATIONAL, location, "XML Schema Validation is not done yet", ValidationMessage.IssueSeverity.INFORMATION));
  }

  private static void validateJsonSchema(String location, List<ValidationMessage> messages) {
    messages.add(new ValidationMessage(ValidationMessage.Source.InstanceValidator, ValidationMessage.IssueType.INFORMATIONAL, location, "JSON Schema Validation is not done yet", ValidationMessage.IssueSeverity.INFORMATION));
  }
}
