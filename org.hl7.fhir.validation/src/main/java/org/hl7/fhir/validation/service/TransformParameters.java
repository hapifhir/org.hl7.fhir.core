package org.hl7.fhir.validation.service;

import org.hl7.fhir.validation.service.model.MapParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.util.List;

public record TransformParameters(ValidationEngineParameters validationEngineParameters, MapParameters mapParameters,
                                  List<String> sources, OutputParameters outputParameters) {
}