package org.hl7.fhir.validation.service;

import lombok.Builder;

@Builder(toBuilder=true)
public record WatchParameters(ValidatorWatchMode watchMode, int watchScanDelay, int watchSettleTime) {
}
