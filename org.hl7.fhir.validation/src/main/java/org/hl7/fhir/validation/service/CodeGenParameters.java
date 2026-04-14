package org.hl7.fhir.validation.service;

import java.util.List;

public record CodeGenParameters(String version, List<String> profiles, List<String> options, String packageName,
                                String output) {
}