package org.hl7.fhir.validation.service;

import lombok.Builder;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.util.List;

@Builder
public record TransformParameters(String map,
                                  String mapLog,
                                  String txServer,
                                  List<String> sources,
                                  String output) {
}