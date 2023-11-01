package org.hl7.fhir.utilities.validation;

import java.io.IOException;

import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;

public interface IDigitalSignatureServices {

  JsonObject fetchJWKS(String address) throws JsonException, IOException;
}
