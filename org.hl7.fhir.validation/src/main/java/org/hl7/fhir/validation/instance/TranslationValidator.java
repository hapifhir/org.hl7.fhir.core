package org.hl7.fhir.validation.instance;

import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedComponent;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedMode;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.terminology.ExpansionOptions;
import org.hl7.fhir.services.terminology.ValueSetExpansionOutcome;
import org.hl7.fhir.services.validation.ValidatorSession;
import org.hl7.fhir.services.xver.XVerExtensionManager;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Uses the ConceptMaps known to the context to comment on the set of codings in a CodeableConcept.
 *
 * For each coding in the CodeableConcept, and each ConceptMap group whose source is that coding's
 * system, the other codings in the CodeableConcept that are in the group's target system are
 * checked against what the map says about the source code:
 *
 *  - the map relates the source code to one of them: fine, nothing to say
 *  - the map says the source code is not-related-to one of them: warning
 *  - the map says the source code has no map: warning
 *  - the map relates the source code only to other codes: hint
 *  - the map doesn't mention the source code at all: nothing to say
 *
 * Where the map doesn't list the source code, but the group has an unmapped, the unmapped is treated
 * as if it were an element for the code (use-source-code or fixed; other-map is not followed - if that
 * map is available, it gets checked in its own right). Where the map uses value sets rather than codes
 * (element.valueSet, target.valueSet, unmapped.valueSet) they are expanded, if that's possible, and
 * each code in the expansion is treated as if it were listed in the map.
 *
 * When more than one ConceptMap says the same thing (the same source, other coding and target codes),
 * there is a single message that lists all of them.
 *
 * The terminology server makes the same checks with the maps it has (and the same messages), and
 * its issues are already in the list by the time this runs. Anything it has already said about a
 * map is not said again - only the maps it didn't name are reported here.
 *
 * This never makes a resource invalid - warnings and hints only
 */
public class TranslationValidator extends BaseValidator {

  private static final String RULE_DATE = "2026-11-20";

  /**
   * Value sets used in maps are only expanded if they're no bigger than this - this is a check that
   * produces hints and warnings, and it's not worth expanding huge value sets for that
   */
  private static final int MAX_EXPANSION_SIZE = 1000;

  /**
   * Expansions of value sets used in maps, by canonical. A value set that can't be expanded (unknown,
   * too big, tx failure) is recorded as an empty list, so it isn't tried again
   */
  private final Map<String, List<ValueSetExpansionContainsComponent>> expansions = new ConcurrentHashMap<>();

  public TranslationValidator(IWorkerContext context, @NonNull ValidatorSettings settings, XVerExtensionManager xverManager, ValidatorSession session) {
    super(context, settings, xverManager, session);
  }

  public TranslationValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean checkCodeableConcept(List<ValidationMessage> errors, NodeStack stack, CodeableConcept concept) {
    if (concept == null || concept.getCodingList().size() < 2) {
      return true;
    }
    Map<String, Finding> findings = new LinkedHashMap<>();
    for (Coding source : concept.getCodingList()) {
      if (source != null && source.hasSystem() && source.hasCode()) {
        for (GroupWithMap group : getGroups(source.getSystem())) {
          if (matchesCoding(source, group.group.getSource())) {
            List<Coding> candidates = new ArrayList<>();
            for (Coding other : concept.getCodingList()) {
              if (other != source && other != null && other.hasSystem() && other.hasCode() && matchesCoding(other, group.group.getTarget())) {
                candidates.add(other);
              }
            }
            if (!candidates.isEmpty()) {
              checkCodingAgainstMap(findings, source, candidates, group);
            }
          }
        }
      }
    }
    List<ValidationMessage> serverSaid = serverTranslationMessages(errors, stack.getLiteralPath());
    for (Finding f : findings.values()) {
      if (!serverSaid.isEmpty()) {
        f.maps.removeIf(url -> serverAlreadySaid(serverSaid, f, url));
        if (f.maps.isEmpty()) {
          continue;
        }
      }
      String maps = CommaSeparatedStringBuilder.join(", ", f.maps);
      if (f.kind == FindingKind.OTHER) {
        hintPlural(errors, RULE_DATE, IssueType.BUSINESSRULE, stack, false, f.maps.size(), f.kind.message, f.source, f.other, maps, f.detail);
      } else {
        warningPlural(errors, RULE_DATE, IssueType.BUSINESSRULE, stack, false, f.maps.size(), f.kind.message, f.source, f.other, maps, f.detail);
      }
    }
    return true; // for now, this never calls anything invalid. warnings/hints only.
  }

  /**
   * The translation messages the terminology server has already reported for this CodeableConcept
   */
  private List<ValidationMessage> serverTranslationMessages(List<ValidationMessage> errors, String location) {
    List<ValidationMessage> list = new ArrayList<>();
    for (ValidationMessage vm : errors) {
      if (vm.getSource() == ValidationMessage.Source.TerminologyEngine && vm.getMessageId() != null
        && vm.getMessageId().startsWith("TRANSLATION_WARNING_") && location.equals(vm.getLocation())) {
        list.add(vm);
      }
    }
    return list;
  }

  /**
   * Has the server already said this, for this map? Its message is the same message, so it names
   * the codings (system#code) and the maps (url|version) the same way. Only those are looked for -
   * not the words around them, which are in whatever language the server answered in - and each
   * coding is looked for on its own, since the server may list the other codings in another order
   */
  private boolean serverAlreadySaid(List<ValidationMessage> serverSaid, Finding f, String url) {
    for (ValidationMessage vm : serverSaid) {
      String text = vm.getMessage();
      if (vm.getMessageId().startsWith(f.kind.message) && text != null && names(text, f.source) && names(text, url) && namesAll(text, f.others)) {
        return true;
      }
    }
    return false;
  }

  private boolean namesAll(String text, List<String> tokens) {
    for (String token : tokens) {
      if (!names(text, token)) {
        return false;
      }
    }
    return true;
  }

  /**
   * text names token (a coding or a map url), and not some longer one that it is part of
   * (http://x/cm|1.0 in http://x/cm|1.0.1, or http://x/cs#12 in http://x/cs#123)
   */
  static boolean names(String text, String token) {
    int i = text.indexOf(token);
    while (i >= 0) {
      int end = i + token.length();
      if ((i == 0 || !continuesToken(text, i - 1)) && (end == text.length() || !continuesToken(text, end))) {
        return true;
      }
      i = text.indexOf(token, i + 1);
    }
    return false;
  }

  /**
   * Is the character at i part of a url or code? A '.' or ':' only is if more of one follows it -
   * otherwise it's punctuation in the message
   */
  private static boolean continuesToken(String text, int i) {
    char c = text.charAt(i);
    if (isAsciiLetterOrDigit(c) || "-_|#/%".indexOf(c) >= 0) {
      return true;
    }
    if (c == '.' || c == ':') {
      return i + 1 < text.length() && (isAsciiLetterOrDigit(text.charAt(i + 1)) || text.charAt(i + 1) == '/');
    }
    return false;
  }

  private static boolean isAsciiLetterOrDigit(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
  }

  private List<GroupWithMap> getGroups(String system) {
    List<GroupWithMap> groups = getIndex().get(system);
    return groups == null ? Collections.emptyList() : groups;
  }

  /**
   * ConceptMap groups, indexed by the (unversioned) system of the group source. Building it means looking at every
   * ConceptMap in the context, so it's kept by the context (storeAnalysis), which drops it when what's loaded changes:
   * it's shared by every validator using the context (one per request, in server mode), and maps loaded later are seen
   */
  @SuppressWarnings("unchecked")
  private Map<String, List<GroupWithMap>> getIndex() {
    Map<String, List<GroupWithMap>> index = (Map<String, List<GroupWithMap>>) context.retrieveAnalysis(TranslationValidator.class);
    if (index == null) {
      long version = context.getDefinitionsVersion();
      index = buildIndex();
      // if something was loaded while it was being built, it may already be out of date: it's used, but not kept
      context.storeAnalysis(TranslationValidator.class, index, version);
    }
    return index;
  }

  /** shared between threads once stored, so it can't be changed */
  private Map<String, List<GroupWithMap>> buildIndex() {
    Map<String, List<GroupWithMap>> index = new HashMap<>();
    for (ConceptMap cm : context.fetchResourcesByType(ConceptMap.class)) {
      for (ConceptMapGroupComponent group : cm.getGroupList()) {
        if (group.hasSource() && group.hasTarget()) {
          String system = unversioned(group.getSource());
          index.computeIfAbsent(system, k -> new ArrayList<>()).add(new GroupWithMap(cm, group));
        }
      }
    }
    index.replaceAll((k, v) -> Collections.unmodifiableList(v));
    return Collections.unmodifiableMap(index);
  }

  private String unversioned(String canonical) {
    return canonical.contains("|") ? canonical.substring(0, canonical.indexOf("|")) : canonical;
  }

  private boolean matchesCoding(Coding c, String canonical) {
    if (canonical == null || !c.hasSystem()) {
      return false;
    }
    if (canonical.equals(c.getSystem())) {
      return true;
    }
    if (canonical.contains("|")) {
      String system = canonical.substring(0, canonical.indexOf("|"));
      String version = canonical.substring(canonical.indexOf("|") + 1);
      return c.getSystem().equals(system) && c.hasVersion() && versionMatchesHere(version, c.getVersion());
    }
    return false;
  }

  private boolean versionMatchesHere(String criteria, String candidate) {
    if (VersionUtilities.isSemVerWithWildcards(criteria)) {
      return VersionUtilities.versionMatches(criteria, candidate);
    }
    // if is date...)
    return candidate.startsWith(criteria);
  }

  private void checkCodingAgainstMap(Map<String, Finding> findings, Coding source, List<Coding> candidates, GroupWithMap map) {
    boolean noMap = false;
    List<MapTarget> targets = new ArrayList<>();
    List<SourceElementComponent> elements = getElements(map, source.getCode());
    if (!elements.isEmpty()) {
      for (SourceElementComponent element : elements) {
        if (element.getNoMap()) {
          noMap = true;
        }
        for (TargetElementComponent target : element.getTargetList()) {
          addTargets(targets, map, target.getCode(), target.getValueSet(), target.getRelationship());
        }
      }
    } else if (map.group.hasUnmapped()) {
      ConceptMapGroupUnmappedComponent unmapped = map.group.getUnmapped();
      if (unmapped.getMode() == ConceptMapGroupUnmappedMode.USESOURCECODE) {
        targets.add(new MapTarget(source.getCode(), unmapped.getRelationship()));
      } else if (unmapped.getMode() == ConceptMapGroupUnmappedMode.FIXED) {
        addTargets(targets, map, unmapped.getCode(), unmapped.getValueSet(), unmapped.getRelationship());
      }
      // other-map: not followed. If the other map is available, it gets checked in its own right
    }
    if (!noMap && targets.isEmpty()) {
      return; // the map doesn't say anything about this code, so neither do we
    }

    Set<Coding> confirmed = new HashSet<>();
    Set<Coding> denied = new HashSet<>();
    Set<String> mappedTo = new HashSet<>();
    for (MapTarget target : targets) {
      boolean notRelated = target.relationship == ConceptMapRelationship.NOTRELATEDTO;
      if (!notRelated) {
        mappedTo.add(target.code);
      }
      for (Coding candidate : candidates) {
        if (target.code.equals(candidate.getCode())) {
          if (notRelated) {
            denied.add(candidate);
          } else {
            confirmed.add(candidate);
          }
        }
      }
    }

    String url = map.resource.getVUrl();
    for (Coding candidate : candidates) {
      if (denied.contains(candidate) && !confirmed.contains(candidate)) {
        addFinding(findings, FindingKind.DENIED, describe(source), List.of(describe(candidate)), "", url);
      }
    }
    if (confirmed.isEmpty()) {
      if (noMap) {
        List<String> others = new ArrayList<>();
        for (Coding candidate : candidates) {
          others.add(describe(candidate));
        }
        addFinding(findings, FindingKind.NOMAP, describe(source), others, map.group.getTarget(), url);
      } else if (!mappedTo.isEmpty()) {
        String mappedCodes = CommaSeparatedStringBuilder.join(", ", Utilities.sorted(mappedTo));
        for (Coding candidate : candidates) {
          if (!denied.contains(candidate)) {
            addFinding(findings, FindingKind.OTHER, describe(source), List.of(describe(candidate)), mappedCodes, url);
          }
        }
      }
    }
  }

  private void addFinding(Map<String, Finding> findings, FindingKind kind, String source, List<String> others, String detail, String url) {
    String other = CommaSeparatedStringBuilder.join(", ", others);
    String key = kind + "|" + source + "|" + other + "|" + detail;
    findings.computeIfAbsent(key, k -> new Finding(kind, source, others, other, detail)).maps.add(url);
  }

  /**
   * A target is either a code, or a value set whose (target system) codes are all targets
   */
  private void addTargets(List<MapTarget> targets, GroupWithMap map, String code, String valueSet, ConceptMapRelationship relationship) {
    if (code != null) {
      targets.add(new MapTarget(code, relationship));
    } else if (valueSet != null) {
      for (ValueSetExpansionContainsComponent c : expand(valueSet)) {
        if (c.hasCode() && (!c.hasSystem() || matchesSystem(c.getSystem(), map.group.getTarget()))) {
          targets.add(new MapTarget(c.getCode(), relationship));
        }
      }
    }
  }

  private List<SourceElementComponent> getElements(GroupWithMap map, String code) {
    Map<String, List<SourceElementComponent>> index = map.elementsByCode;
    if (index == null) {
      index = new HashMap<>();
      for (SourceElementComponent e : map.group.getElementList()) {
        if (e.hasCode()) {
          index.computeIfAbsent(e.getCode(), k -> new ArrayList<>()).add(e);
        } else if (e.hasValueSet()) {
          // all the (source system) codes in the value set are mapped the same way
          for (ValueSetExpansionContainsComponent c : expand(e.getValueSet())) {
            if (c.hasCode() && (!c.hasSystem() || matchesSystem(c.getSystem(), map.group.getSource()))) {
              index.computeIfAbsent(c.getCode(), k -> new ArrayList<>()).add(e);
            }
          }
        }
      }
      map.elementsByCode = index;
    }
    List<SourceElementComponent> elements = index.get(code);
    return elements == null ? Collections.emptyList() : elements;
  }

  private boolean matchesSystem(String system, String canonical) {
    return system.equals(unversioned(canonical));
  }

  private List<ValueSetExpansionContainsComponent> expand(String valueSet) {
    return expansions.computeIfAbsent(valueSet, url -> {
      List<ValueSetExpansionContainsComponent> list = new ArrayList<>();
      try {
        ExpansionOptions options = new ExpansionOptions(true, false, MAX_EXPANSION_SIZE, false, null);
        ValueSet vs = context.findTxResource(ValueSet.class, url);
        // if we don't have it, the terminology server might
        ValueSetExpansionOutcome exp = vs != null ? context.expandVS(options, vs) : context.expandVS(options, url);
        if (exp != null && exp.isOk() && exp.getValueset() != null) {
          flatten(list, exp.getValueset().getExpansion().getContainsList());
        }
      } catch (Exception e) {
        // if we can't expand it, we just don't have anything to say about it
      }
      return list;
    });
  }

  private void flatten(List<ValueSetExpansionContainsComponent> list, List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      list.add(c);
      flatten(list, c.getContainsList());
    }
  }

  private String describe(Coding c) {
    return c.getVersionedSystem() + "#" + c.getCode();
  }

  private enum FindingKind {
    DENIED(I18nConstants.TRANSLATION_WARNING_DENIED),
    NOMAP(I18nConstants.TRANSLATION_WARNING_NOMAP),
    OTHER(I18nConstants.TRANSLATION_WARNING_OTHER);

    final String message;

    FindingKind(String message) {
      this.message = message;
    }
  }

  /**
   * One thing to say about a pair of codings, and all the ConceptMaps that say it
   */
  private static class Finding {
    final FindingKind kind;
    final String source;
    final List<String> others; // the other codings, each as describe() gives it
    final String other; // others, as the message lists them
    final String detail;
    final Set<String> maps = new TreeSet<>(); // sorted, so the output is stable whatever order the context lists the maps in

    Finding(FindingKind kind, String source, List<String> others, String other, String detail) {
      this.kind = kind;
      this.source = source;
      this.others = others;
      this.other = other;
      this.detail = detail;
    }
  }

  private static class MapTarget {
    final String code;
    final ConceptMapRelationship relationship;

    MapTarget(String code, ConceptMapRelationship relationship) {
      this.code = code;
      this.relationship = relationship;
    }
  }

  private static class GroupWithMap {
    final ConceptMap resource;
    final ConceptMapGroupComponent group;

    volatile Map<String, List<SourceElementComponent>> elementsByCode; // built on first use - see TranslationValidator.getElements

    GroupWithMap(ConceptMap resource, ConceptMapGroupComponent group) {
      this.resource = resource;
      this.group = group;
    }

  }

}
