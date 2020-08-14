package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The validator keeps one of these classes for each resource it validates (e.g. when chasing references)
 * <p>
 * It keeps track of the state of resource validation - a given resrouce may be validated agaisnt multiple
 * profiles during a single validation, and it may be valid against some, and invalid against others.
 * <p>
 * We don't want to keep doing the same validation, so we remember the outcomes for each combination
 * of resource + profile
 * <p>
 * Additionally, profile validation may be circular - e.g. a Patient profile that applies the same profile
 * to linked patients, and 2 patient resources that link to each other. So this class also tracks validation
 * in process.
 * <p>
 * If the validator comes back to the same point, and validates the same instance against the same profile
 * while it's already validating, it assumes it's valid - it cannot have new errors that wouldn't already
 * be found in the first iteration - in other words, there's no errors
 *
 * @author graha
 */
public class ResourceValidationTracker {
    private Map<String, List<ValidationMessage>> validations = new HashMap<>();

    public void startValidating(StructureDefinition sd) {
        validations.put(sd.getUrl(), new ArrayList<ValidationMessage>());
    }

    public List<ValidationMessage> getOutcomes(StructureDefinition sd) {
        return validations.get(sd.getUrl());
    }

    public void storeOutcomes(StructureDefinition sd, List<ValidationMessage> errors) {
        validations.put(sd.getUrl(), errors);
    }
}