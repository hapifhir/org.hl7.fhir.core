package org.hl7.fhir.validation.service;

import lombok.Builder;

@Builder
public record  ValidationOutputRenderSummary(int totalErrors) {}
