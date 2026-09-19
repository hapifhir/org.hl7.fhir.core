package org.hl7.fhir.r5.terminologies.subsumption;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.context.BaseWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValueSetProcessBase;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

/**
 * Determines whether one concept subsumes another, using the CodeSystem resources that are
 * available in the context. This is the engine behind the CodeSystem $subsumes operation, and
 * it is what the internal ('mini') terminology server uses when there is no terminology server
 * to delegate to.
 * <p>
 * Subsumption is determined from the code system's hierarchy, which may be expressed either by
 * nesting concepts inside each other, or by concept properties with the uri
 * http://hl7.org/fhir/concept-properties#parent or #child (the property code itself varies -
 * THO uses 'subsumedBy' for the parent property, for instance, so the property must be located
 * by its uri, not its code). Both forms may be used in the one code system, and a concept may
 * have more than one parent.
 * <p>
 * The hierarchy only describes subsumption if hierarchyMeaning is is-a (or is not stated - in
 * which case is-a is assumed, since that is by far the most common intent, and a code system
 * that means something else is expected to say so). If hierarchyMeaning says something else, no
 * answer is possible, and an exception is thrown.
 * <p>
 * This class only handles code systems that are present in the context with content = complete.
 * Anything else - a code system that isn't known at all, a fragment, an example, a not-present
 * code system, or one of the special code systems that are handled by a CodeSystemProvider
 * (SNOMED CT, LOINC, UCUM, mime types, language codes...) - produces a SubsumptionException,
 * because a wrong answer is worse than no answer. Those code systems are the province of a real
 * terminology server (or, in the future, of subsumption support on CodeSystemProvider).
 */
public class TerminologySubsumptionTester extends ValueSetProcessBase {

  public static final String PARENT_PROPERTY_URI = "http://hl7.org/fhir/concept-properties#parent";
  public static final String CHILD_PROPERTY_URI = "http://hl7.org/fhir/concept-properties#child";

  public TerminologySubsumptionTester(BaseWorkerContext context) {
    this(context, new TerminologyOperationContext(context, ValidationOptions.defaults(), "subsumption"));
  }

  public TerminologySubsumptionTester(BaseWorkerContext context, TerminologyOperationContext opContext) {
    super(context, opContext);
  }

  /**
   * Test whether codingA subsumes codingB (or is subsumed by it, or is the same concept).
   *
   * @param codingA the first coding (the outcome is stated from A's point of view)
   * @param codingB the second coding
   * @return the subsumption outcome - never null
   * @throws SubsumptionException if the question cannot be answered
   */
  public SubsumptionOutcome subsumes(Coding codingA, Coding codingB) throws SubsumptionException {
    return subsumes(codingA, codingB, "codingA", "codingB");
  }

  /**
   * As {@link #subsumes(Coding, Coding)}, but with control over the names used to refer to the two
   * codings when reporting problems with them (the $subsumes operation names them codingA/codingB
   * or codeA/codeB depending on which form of the parameters was used).
   */
  public SubsumptionOutcome subsumes(Coding codingA, Coding codingB, @Nonnull String pathA, @Nonnull String pathB) throws SubsumptionException {
    opContext.deadCheck("subsumes");

    checkCoding(codingA, pathA);
    checkCoding(codingB, pathB);

    if (!codingA.getSystem().equals(codingB.getSystem())) {
      throw fail(IssueType.INVALID, OpIssueCode.InvalidData, pathB, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.SUBSUMPTION_SYSTEM_MISMATCH, codingA.getSystem(), codingB.getSystem());
    }
    if (codingA.hasVersion() && codingB.hasVersion() && !codingA.getVersion().equals(codingB.getVersion())) {
      throw fail(IssueType.INVALID, OpIssueCode.InvalidData, pathB, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.SUBSUMPTION_VERSION_MISMATCH, codingA.getSystem(), codingA.getVersion(), codingB.getVersion());
    }
    String system = codingA.getSystem();
    String version = codingA.hasVersion() ? codingA.getVersion() : codingB.getVersion();

    CodeSystem cs = context.fetchCodeSystem(system, ExtensionUtilities.getVersionResolutionRules(codingA.getSystemElement()), version, null);
    if (cs == null) {
      if (version == null) {
        throw fail(IssueType.NOTFOUND, OpIssueCode.NotFound, null, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED,
            I18nConstants.SUBSUMPTION_CS_NOT_FOUND, system);
      } else {
        throw fail(IssueType.NOTFOUND, OpIssueCode.NotFound, null, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED_VERSION,
            I18nConstants.SUBSUMPTION_CS_NOT_FOUND_VERSION, system, version);
      }
    }
    if (cs.getContent() != CodeSystemContentMode.COMPLETE) {
      throw fail(IssueType.NOTSUPPORTED, null, null, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED,
          I18nConstants.SUBSUMPTION_CS_NOT_COMPLETE, cs.getVersionedUrl(), cs.hasContent() ? cs.getContent().toCode() : "(none)");
    }
    if (cs.hasHierarchyMeaning() && cs.getHierarchyMeaning() != CodeSystemHierarchyMeaning.ISA) {
      throw fail(IssueType.NOTSUPPORTED, null, null, TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED,
          I18nConstants.SUBSUMPTION_CS_HIERARCHY_MEANING, cs.getVersionedUrl(), cs.getHierarchyMeaning().toCode());
    }

    ConceptDefinitionComponent cdA = findConcept(cs, codingA.getCode());
    if (cdA == null) {
      throw failUnknownCode(cs, codingA.getCode(), pathA);
    }
    ConceptDefinitionComponent cdB = findConcept(cs, codingB.getCode());
    if (cdB == null) {
      throw failUnknownCode(cs, codingB.getCode(), pathB);
    }
    if (cdA.getCode().equals(cdB.getCode())) {
      return SubsumptionOutcome.EQUIVALENT;
    }

    Map<String, Set<String>> parents = getParentMap(cs);
    if (hasAncestor(parents, cdB.getCode(), cdA.getCode())) {
      return SubsumptionOutcome.SUBSUMES;
    }
    if (hasAncestor(parents, cdA.getCode(), cdB.getCode())) {
      return SubsumptionOutcome.SUBSUMEDBY;
    }
    return SubsumptionOutcome.NOTSUBSUMED;
  }

  private void checkCoding(Coding coding, String path) throws SubsumptionException {
    if (coding == null) {
      throw fail(IssueType.REQUIRED, OpIssueCode.InvalidData, path, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.SUBSUMPTION_NO_CODING, path);
    }
    if (!coding.hasSystem()) {
      throw fail(IssueType.REQUIRED, OpIssueCode.InvalidData, path, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.SUBSUMPTION_NO_SYSTEM, path);
    }
    if (!coding.hasCode()) {
      throw fail(IssueType.REQUIRED, OpIssueCode.InvalidData, path, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.SUBSUMPTION_NO_CODE, path);
    }
  }

  /**
   * Find a concept, honouring caseSensitive (which defaults to true if it isn't stated - the
   * code system has to say that its codes are case insensitive before we'll treat them so).
   */
  private ConceptDefinitionComponent findConcept(CodeSystem cs, String code) {
    ConceptDefinitionComponent cd = CodeSystemUtilities.findCode(cs.getConcept(), code);
    if (cd == null && cs.hasCaseSensitive() && !cs.getCaseSensitive()) {
      cd = findConceptCaseInsensitive(cs.getConcept(), code);
    }
    return cd;
  }

  private ConceptDefinitionComponent findConceptCaseInsensitive(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasCode() && cd.getCode().equalsIgnoreCase(code)) {
        return cd;
      }
      ConceptDefinitionComponent t = findConceptCaseInsensitive(cd.getConcept(), code);
      if (t != null) {
        return t;
      }
    }
    return null;
  }

  /**
   * Build the code -> parent codes map for the code system, from both the nested concepts and
   * the #parent / #child properties. Note that this is built per call; if subsumption testing
   * ever gets hot, this is the thing to cache against the CodeSystem.
   */
  private Map<String, Set<String>> getParentMap(CodeSystem cs) {
    Map<String, Set<String>> parents = new HashMap<>();
    PropertyComponent pp = CodeSystemUtilities.getPropertyDefinition(cs, "parent");
    PropertyComponent cp = CodeSystemUtilities.getPropertyDefinition(cs, "child");
    processConcepts(parents, cs.getConcept(), null, pp == null ? null : pp.getCode(), cp == null ? null : cp.getCode());
    return parents;
  }

  private void processConcepts(Map<String, Set<String>> parents, List<ConceptDefinitionComponent> list, String parentCode, String parentProperty, String childProperty) {
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasCode()) {
        if (parentCode != null) {
          addParent(parents, cd.getCode(), parentCode);
        }
        for (ConceptPropertyComponent p : cd.getProperty()) {
          if (!p.hasValue() || !p.getValue().isPrimitive()) {
            continue;
          }
          String value = p.getValue().primitiveValue();
          if (Utilities.noString(value)) {
            continue;
          }
          if (p.getCode().equals(parentProperty)) {
            addParent(parents, cd.getCode(), value);
          } else if (p.getCode().equals(childProperty)) {
            addParent(parents, value, cd.getCode());
          }
        }
      }
      processConcepts(parents, cd.getConcept(), cd.getCode(), parentProperty, childProperty);
    }
  }

  private void addParent(Map<String, Set<String>> parents, String code, String parent) {
    if (!code.equals(parent)) { // a concept is not its own parent, whatever it says
      parents.computeIfAbsent(code, c -> new HashSet<>()).add(parent);
    }
  }

  /**
   * Walk up from code looking for ancestor. The walk is cycle safe: code systems are not
   * supposed to contain loops, but nothing stops them, and a stack overflow is a poor way to
   * find out.
   */
  private boolean hasAncestor(Map<String, Set<String>> parents, String code, String ancestor) {
    Set<String> visited = new HashSet<>();
    Deque<String> queue = new ArrayDeque<>();
    queue.add(code);
    while (!queue.isEmpty()) {
      String c = queue.poll();
      if (visited.add(c)) {
        for (String p : parents.getOrDefault(c, Collections.emptySet())) {
          if (p.equals(ancestor)) {
            return true;
          }
          queue.add(p);
        }
      }
    }
    return false;
  }

  private SubsumptionException failUnknownCode(CodeSystem cs, String code, String path) {
    if (cs.hasVersion()) {
      return fail(IssueType.CODEINVALID, OpIssueCode.InvalidCode, path, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.UNKNOWN_CODE_IN_VERSION, code, cs.getUrl(), cs.getVersion());
    } else {
      return fail(IssueType.CODEINVALID, OpIssueCode.InvalidCode, path, TerminologyServiceErrorClass.PROCESSING,
          I18nConstants.UNKNOWN_CODE_IN, code, cs.getUrl());
    }
  }

  private SubsumptionException fail(IssueType type, OpIssueCode code, String path, TerminologyServiceErrorClass errorClass, String msgId, Object... params) {
    String msg = context.formatMessage(msgId, params);
    List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
    issues.addAll(makeIssue(IssueSeverity.ERROR, type, path, msg, code, null, msgId));
    return new SubsumptionException(msg, issues, errorClass);
  }
}
