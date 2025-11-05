package org.hl7.fhir.validation.service;

import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.util.List;

public record GenerateNarrativeParameters(ValidationEngineParameters validationEngineParameters, List<String> sources,
                                          String output) {
}