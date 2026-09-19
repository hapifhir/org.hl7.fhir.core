package org.hl7.fhir.validation.service.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.xml.sax.SAXException;

public class SchemaValidator {

  public static void validateSchema(String location, FhirFormat cntType, List<ValidationMessage> messages) throws IOException, SAXException {
    if (cntType == FhirFormat.JSON)
      validateJsonSchema(location, messages);
    if (cntType == FhirFormat.XML)
      validateXmlSchema(location, messages);
    if (cntType == FhirFormat.TURTLE)
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
