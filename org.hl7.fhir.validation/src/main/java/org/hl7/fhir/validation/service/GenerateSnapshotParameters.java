package org.hl7.fhir.validation.service;

import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.util.List;

public record GenerateSnapshotParameters(String version, List<String> sources,
                                         String output, String outputSuffix) {
}