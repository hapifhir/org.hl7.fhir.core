package org.hl7.fhir.validation.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

import org.hl7.fhir.validation.BaseValidator;
import org.junit.jupiter.api.Test;

/**
 * When the entries of a Bundle are checked concurrently, each thread's validator is made like the validator of the
 * Bundle by InstanceValidator.configureLike. A setting it doesn't copy would be ignored for the entries, so every
 * field of the validator has to be accounted for here: copied, made by the constructor from what it is given, or part
 * of the state of a validation.
 */
class InstanceValidatorEntryWorkerTest {

  // copied by configureLike
  private static final Set<String> COPIED = Set.of(
    // BaseValidator
    "fetcher", "policyAdvisor", "noTerminologyChecks", "validationControl",
    // InstanceValidator
    "checkDisplay", "anyExtensionsAllowed", "errorForUnknownProfiles", "noInvariantChecks", "wantInvariantInMessage",
    "hintAboutNonMustSupport", "showMessagesFromReferences", "validationLanguage", "noCheckAggregation",
    "wantCheckSnapshotUnchanged", "noUnicodeBiDiControlChars", "htmlInMarkdownCheck", "allowComments",
    "allowDoubleQuotesInFHIRPath", "igs", "extensionDomains", "resourceIdRule", "allowXsiLocation",
    "suppressLoincSnomedMessages", "maxMessages", "timeout", "noBindingMsgSuppressed", "noExtensibleWarnings",
    "serverBase", "tracker", "securityChecks", "crumbTrails", "bundleValidationRules", "questionnaireMode",
    "logProgress", "testMode", "example", "signatureServices", "unknownCodeSystemsCauseErrors",
    "noExperimentalContent", "aiService", "cacheFolder", "matchetypeStatus");

  // made by the constructor, from the worker context, host services, extension manager, session and settings the
  // worker is given (the parent's), or settings kept inside them (the FHIRPath engine's are copied by configureLike)
  private static final Set<String> CONSTRUCTED = Set.of(
    // BaseValidator
    "context", "xverManager", "settings", "session", "cu", "urlRegex", "parent",
    // InstanceValidator
    "externalHostServices", "profileUtilities", "fpe", "validatorServices", "codingObserver", "oids",
    "myEnableWhenEvaluator", "start", "time", "lastlog");

  // the state of a validation: shared with the workers, or collected from them and merged
  private static final Set<String> STATE = Set.of(
    // BaseValidator
    "timeTracker", "validationContext", "trackedMessages", "messagesToRemove", "statusWarnings", "executionMemos",
    "sessionMemos", "statusWarningLog",
    // InstanceValidator
    "fetchCache", "resourceTracker", "executedConstraints", "instanceExecutionMemos", "instanceSessionMemos",
    "entryExecutor", "isEntryWorker", "entryParent", "executionId", "crLookups", "validatedContent", "textsToCheck",
    "textsToCheckKeys", "additionalResourcesTried", "additionalResourceNames");

  @Test
  void everyFieldIsCopiedConstructedOrState() {
    Set<String> unaccounted = new TreeSet<>();
    Set<String> known = new TreeSet<>();
    known.addAll(COPIED);
    known.addAll(CONSTRUCTED);
    known.addAll(STATE);
    Set<String> stale = new TreeSet<>(known);
    for (Class<?> c : new Class<?>[] { BaseValidator.class, InstanceValidator.class }) {
      for (Field f : c.getDeclaredFields()) {
        if (Modifier.isStatic(f.getModifiers()) || f.isSynthetic() || isConstant(f)) {
          continue;
        }
        stale.remove(f.getName());
        if (!known.contains(f.getName())) {
          unaccounted.add(c.getSimpleName() + "." + f.getName());
        }
      }
    }
    assertEquals(Set.of(), unaccounted, "fields that InstanceValidator.configureLike neither copies nor knows to be validation state");
    assertEquals(Set.of(), stale, "fields listed here that no longer exist");
  }

  private static boolean isConstant(Field f) {
    return Modifier.isFinal(f.getModifiers()) && f.getType() == String.class;
  }
}
