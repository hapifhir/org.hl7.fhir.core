package org.hl7.fhir.validation.service;

import lombok.Builder;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.model.WatchParameters;

import javax.annotation.Nonnull;
import java.util.List;

/**
 *
 *
 * @param instanceValidatorParameters the parameters used by {@link org.hl7.fhir.validation.ValidationEngine}  to
 *                                    instantiate a {@link org.hl7.fhir.validation.instance.InstanceValidator} for
 *                                    validation. If this is null, the ValidatorEngine will use its default
 *                                    InstanceValidatorParameters object.
 * @param sources A list of sources to validate.
 * @param output An output
 * @param watchParameters If this is not null and org.hl7.fhir.validation.service.ValidatorWatchMode is not NULL, this
 *                        method will start a loop in which it will validate any sources that change.
 */
@Builder
public record ValidateSourceParameters(InstanceValidatorParameters instanceValidatorParameters, @Nonnull List<String> sources,
                                       String output, WatchParameters watchParameters) {
}