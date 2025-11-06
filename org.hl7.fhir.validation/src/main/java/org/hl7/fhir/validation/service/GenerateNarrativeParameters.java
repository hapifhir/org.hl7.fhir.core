package org.hl7.fhir.validation.service;

import java.util.List;

public record GenerateNarrativeParameters(String version, List<String> sources,
                                          String output) {
}