package org.hl7.fhir.validation.service;

import java.util.List;

public record TransformLangParameters(String langTransform, List<String> inputs, String srcLang, String tgtLang,
                                      List<String> sources, String output) {
}