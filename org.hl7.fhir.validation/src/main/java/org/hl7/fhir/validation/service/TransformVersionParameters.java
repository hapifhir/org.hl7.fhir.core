package org.hl7.fhir.validation.service;

import lombok.Builder;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.util.List;

@Builder
public record TransformVersionParameters(ValidationEngineParameters validationEngineParameters, String targetVer,
                                         boolean canDoNative, List<String> sources, String output) {
}