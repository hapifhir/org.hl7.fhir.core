package org.hl7.fhir.r4.fhirpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ValueSet;
import org.hl7.fhir.r4.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;

/**
 * Functions for FHIR documents - an extension to FHIRPath, not part of the FHIRPath specification
 * or of the FHIR specification's additional FHIRPath functions. They were written for clinical
 * profiles of IPS documents (rules about what a document contains), and work on any document.
 *
 * <ul>
 *   <li><b>section(system, code [, min, max])</b> - the input is documents (Bundles) or
 *   Compositions; a document's Composition is its first Composition entry. For each, the
 *   Composition's sections, nested ones too, whose code has a coding that matches system and
 *   code. min and max default to 1 and 1.</li>
 *   <li><b>entry(system, code [, min, max])</b> - the input is sections. For each, its entries,
 *   resolved, whose code has a coding that matches system and code. min and max default to 0
 *   and '*'.</li>
 *   <li><b>entryIn(valueSet [, min, max])</b> - as entry(), with a code in the value set. Empty
 *   when valueSet is empty.</li>
 *   <li><b>resources(system, code [, type])</b> - the input is documents, or anything in one. Every
 *   resource in the document whose code has a coding that matches system and code, and is of the
 *   type, unless type is empty or isn't given.</li>
 *   <li><b>resourcesIn(valueSet [, type])</b> - as resources(), with a code in the value set. Empty
 *   when valueSet is empty.</li>
 *   <li><b>sameSubject([other])</b> - whether the focus resource has the same subject (or patient) as other, or
 *   without other, as the document's Composition: see {@link #sameSubject}. Empty when other is given but is
 *   empty: only when other isn't given at all is the Composition used.</li>
 *   <li><b>hasCoding(system, code [, version])</b> - the input is Codings or CodeableConcepts. Whether any coding
 *   in them matches: a parameter that is a string must match the coding's system, code or version precisely; a
 *   parameter that is empty, or the version when it isn't given, is ignored. True or false, or empty when the input
 *   is empty.</li>
 * </ul>
 *
 * A coding matches a system and code as in hasCoding(): a string must match precisely, and one that is
 * empty is ignored. min and max are both given, or neither; max may be '*'. Either may be empty, and an
 * empty one - or both, when they aren't given - takes the function's default. A parameter (other than
 * sameSubject's other) is a single value, or empty: one that is more than one makes the result empty
 * (when the expression is checked, a parameter that can be more than one is a warning, as for any function). When the number found
 * for an input item is outside min..max, that item adds nothing to the output (that is not an error). A resource's code is its code, vaccineCode or medication
 * (when that's a CodeableConcept, or a CodeableReference's concept - a medication given by
 * reference isn't followed). A value set is a canonical URL, with |version or not; a code is
 * in it when any coding of the code is. A value set that can't be found, or a membership the
 * terminology services can't decide, is an error.
 *
 * References in sections are resolved in the document the evaluation is on (the root resource,
 * or else the focus resource, when it's a Bundle), the way the validator resolves references in
 * a Bundle (BaseValidator.resolveInBundle): absolute by fullUrl, relative (Type/id) against the
 * base of the Composition's fullUrl when that is a RESTful URL (and before R4, by type and id),
 * and '#id' as a resource contained in the Composition. A reference that doesn't resolve in the
 * document is left out. Only without a document (a Composition on its own) is a reference passed
 * to the host's resolveReference().
 *
 * The test cases are in the FHIRPath test suite (fhir-test-cases), in a group with
 * mode="custom", which other engines need not run.
 */
class DocumentFunctions {

  private static final String[] CODE_ELEMENTS = { "code", "vaccineCode", "medication" };

  private final FHIRPathEngine engine;
  private final IWorkerContext worker;

  DocumentFunctions(FHIRPathEngine engine) {
    this.engine = engine;
    this.worker = engine.getWorker();
  }

  /** min and max: min a non-negative integer, max an integer no less than min, or '*' */
  static class Bounds {
    private final int min;
    private final int max; // -1: no maximum

    Bounds(int min, int max) {
      this.min = min;
      this.max = max;
    }

    boolean within(int count) {
      return count >= min && (max < 0 || count <= max);
    }

    static final Bounds ANY = new Bounds(0, -1);
    static final Bounds ONE = new Bounds(1, 1);
  }

  /** a parameter that isn't given, or is empty */
  private static boolean isOmitted(List<Base> param) {
    return param == null || param.isEmpty();
  }

  /**
   * whether any of a function's parameter values has more than one item. The parameters (other than sameSubject's) are
   * each a single value, or empty: when one has more than one item, the function's result is empty
   */
  static boolean anyCollection(List<List<Base>> params) {
    for (List<Base> p : params) {
      if (p != null && p.size() > 1) {
        return true;
      }
    }
    return false;
  }

  // --- parameters --------------------------------------------------------------------------

  /**
   * min and max, each a parameter's value: null when it isn't given. One that is empty, or isn't given, takes the
   * default's value
   */
  Bounds bounds(String fn, List<Base> min, List<Base> max, Bounds defaults) {
    String smin = isOmitted(min) ? Integer.toString(defaults.min) : single(min);
    String smax = isOmitted(max) ? (defaults.max < 0 ? "*" : Integer.toString(defaults.max)) : single(max);
    Integer imin = nonNegative(smin);
    Integer imax = "*".equals(smax) ? Integer.valueOf(-1) : nonNegative(smax);
    if (imin == null || imax == null || (imax >= 0 && imax < imin)) {
      throw error(I18nConstants.FHIRPATH_DOC_BOUNDS, fn, smin, smax);
    }
    return new Bounds(imin, imax);
  }

  /** the value set url - null when the parameter is empty (and then entryIn() and resourcesIn() are empty) */
  String valueSet(String fn, List<Base> param) {
    if (isOmitted(param)) {
      return null;
    }
    String url = single(param);
    if (!isCanonical(url)) {
      throw error(I18nConstants.FHIRPATH_DOC_VALUESET, fn, url);
    }
    return url;
  }

  /** the type - null (no constraint) when the parameter isn't given, or is empty */
  String resourceType(String fn, List<Base> param) {
    if (isOmitted(param)) {
      return null;
    }
    String type = single(param);
    if (!isTypeName(type)) {
      throw error(I18nConstants.FHIRPATH_DOC_TYPE, fn, type);
    }
    return type;
  }

  String string(List<Base> param) {
    return single(param);
  }

  private String single(List<Base> param) {
    if (param == null || param.size() != 1 || param.get(0) == null) {
      return null;
    }
    return param.get(0).primitiveValue();
  }

  private static Integer nonNegative(String s) {
    if (s == null || s.isEmpty() || s.length() > 9) {
      return null;
    }
    for (char ch : s.toCharArray()) {
      if (ch < '0' || ch > '9') {
        return null;
      }
    }
    return Integer.valueOf(s);
  }

  /** a canonical URL: scheme:rest, with |version or not, no whitespace */
  static boolean isCanonical(String url) {
    if (url == null || url.length() > 320) {
      return false;
    }
    int colon = url.indexOf(':');
    if (colon < 1 || !Character.isLetter(url.charAt(0))) {
      return false;
    }
    for (int i = 0; i < colon; i++) {
      char ch = url.charAt(i);
      if (!(Character.isLetterOrDigit(ch) || ch == '+' || ch == '.' || ch == '-')) {
        return false;
      }
    }
    int bar = url.indexOf('|');
    if (bar >= 0 && (bar == url.length() - 1 || url.indexOf('|', bar + 1) >= 0)) {
      return false;
    }
    if (colon == (bar >= 0 ? bar : url.length()) - 1) {
      return false;
    }
    for (char ch : url.toCharArray()) {
      if (Character.isWhitespace(ch)) {
        return false;
      }
    }
    return true;
  }

  static boolean isTypeName(String s) {
    if (s == null || s.length() < 2 || s.length() > 64 || !(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
      return false;
    }
    for (char ch : s.toCharArray()) {
      if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
        return false;
      }
    }
    return true;
  }

  private String fhirVersion() {
    return worker.getVersion();
  }

  private PathEngineException error(String msg, Object... args) {
    return new PathEngineException(worker.formatMessage(msg, args), msg);
  }

  // --- the functions -----------------------------------------------------------------------

  List<Base> section(List<Base> focus, String system, String code, Bounds bounds) {
    List<Base> result = new ArrayList<>();
    for (Base item : focus) {
      Base comp = composition(item);
      if (comp != null) {
        List<Base> found = new ArrayList<>();
        for (Base s : allSections(comp, new ArrayList<>())) {
          if (hasCoding(single(s, "code"), system, code)) {
            found.add(s);
          }
        }
        if (bounds.within(found.size())) {
          result.addAll(found);
        }
      }
    }
    return result;
  }

  List<Base> entry(Object appInfo, Base root, Base focusResource, List<Base> focus, String system, String code, Bounds bounds) {
    List<Base> result = new ArrayList<>();
    for (Base item : focus) {
      List<Base> entries = sectionEntries(appInfo, root, focusResource, item);
      if (entries != null) {
        List<Base> found = new ArrayList<>();
        for (Base r : entries) {
          if (hasCode(r, system, code)) {
            found.add(r);
          }
        }
        if (bounds.within(found.size())) {
          result.addAll(found);
        }
      }
    }
    return result;
  }

  List<Base> entryIn(Object appInfo, ValidationOptions options, Base root, Base focusResource, List<Base> focus, String fn, String url, Bounds bounds) {
    List<Base> result = new ArrayList<>();
    if (url == null) {
      return result;
    }
    ValueSet vs = null;
    for (Base item : focus) {
      List<Base> entries = sectionEntries(appInfo, root, focusResource, item);
      if (entries != null) {
        if (vs == null && !entries.isEmpty()) {
          vs = findValueSet(appInfo, fn, url);
        }
        List<Base> found = new ArrayList<>();
        for (Base r : entries) {
          if (inValueSet(options, fn, url, vs, r)) {
            found.add(r);
          }
        }
        if (bounds.within(found.size())) {
          result.addAll(found);
        }
      }
    }
    return result;
  }

  List<Base> resources(Base root, Base focusResource, List<Base> focus, String system, String code, String type) {
    List<Base> result = new ArrayList<>();
    for (Base r : documentResources(root, focusResource, focus, type)) {
      if (hasCode(r, system, code)) {
        result.add(r);
      }
    }
    return result;
  }

  List<Base> resourcesIn(Object appInfo, ValidationOptions options, Base root, Base focusResource, List<Base> focus, String fn, String url, String type) {
    List<Base> result = new ArrayList<>();
    if (url == null) {
      return result;
    }
    List<Base> candidates = documentResources(root, focusResource, focus, type);
    if (!candidates.isEmpty()) {
      ValueSet vs = findValueSet(appInfo, fn, url);
      for (Base r : candidates) {
        if (inValueSet(options, fn, url, vs, r)) {
          result.add(r);
        }
      }
    }
    return result;
  }

  /**
   * sameSubject([other]): whether the focus resource is about the same subject as other - or, without other, as the
   * Composition of the document the evaluation is on (other given as empty is not the same as no other: the result
   * is empty). The subject of a resource is its subject or its patient (no resource has both). Empty if the focus or other isn't a single resource, if either has no subject (or more than
   * one), or, without other, if the evaluation isn't on a document (a Bundle of type document with a Composition).
   * Otherwise true when the references are identical strings - when both have one; else when both have an identifier,
   * when the identifiers' system and value are identical; otherwise false. Exact matching, without resolving: outside
   * the document, the context might treat two different references differently
   */
  Boolean sameSubject(Base root, Base focusResource, List<Base> focus, List<Base> other) {
    if (focus.size() != 1 || focus.get(0) == null) {
      return null;
    }
    Base o;
    if (other != null) {
      if (other.size() != 1) {
        return null;
      }
      o = other.get(0);
    } else {
      Base doc = document(root, focusResource);
      o = doc != null && "document".equals(primitive(doc, "type")) ? composition(doc) : null;
    }
    Base a = subjectOf(focus.get(0));
    Base b = o == null ? null : subjectOf(o);
    if (a == null || b == null) {
      return null;
    }
    String refA = primitive(a, "reference");
    String refB = primitive(b, "reference");
    if (!isEmpty(refA) && !isEmpty(refB)) {
      return refA.equals(refB);
    }
    Base idA = single(a, "identifier");
    Base idB = single(b, "identifier");
    if (idA != null && idB != null) {
      String valueA = primitive(idA, "value");
      return !isEmpty(valueA) && valueA.equals(primitive(idB, "value")) && sameString(primitive(idA, "system"), primitive(idB, "system"));
    }
    return false;
  }

  /**
   * hasCoding(system, code [, version]): whether any Coding in the focus - Codings, and the codings of CodeableConcepts;
   * anything else is passed over - matches. A parameter that is a string must match the Coding's system, code or
   * version precisely (so a Coding with no version doesn't match a version that is given); a parameter that is
   * empty, or the version when it isn't given, is ignored (null here). Empty when the focus is empty; otherwise true
   * or false
   */
  Boolean hasCoding(List<Base> focus, String system, String code, String version) {
    if (focus.isEmpty()) {
      return null;
    }
    for (Base item : focus) {
      if (item == null) {
        continue;
      }
      if ("Coding".equals(item.fhirType())) {
        if (codingMatches(item, system, code, version)) {
          return true;
        }
      } else if ("CodeableConcept".equals(item.fhirType())) {
        for (Base c : children(item, "coding")) {
          if (codingMatches(c, system, code, version)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean codingMatches(Base coding, String system, String code, String version) {
    return (system == null || system.equals(primitive(coding, "system")))
      && (code == null || code.equals(primitive(coding, "code")))
      && (version == null || version.equals(primitive(coding, "version")));
  }

  /** a resource's subject or patient - null if it has neither, or more than one (R5+ Composition.subject repeats) */
  private Base subjectOf(Base resource) {
    if (resource.isPrimitive()) {
      return null;
    }
    List<Base> list = children(resource, "subject");
    if (list.isEmpty()) {
      list = children(resource, "patient");
    }
    return list.size() == 1 ? list.get(0) : null;
  }

  private static boolean isEmpty(String s) {
    return s == null || s.isEmpty();
  }

  private static boolean sameString(String a, String b) {
    return a == null ? b == null : a.equals(b);
  }

  // --- documents ---------------------------------------------------------------------------

  /** the Composition for an input item: the item itself, or a document's first Composition entry */
  private Base composition(Base item) {
    if (item == null) {
      return null;
    }
    if ("Composition".equals(item.fhirType())) {
      return item;
    }
    if ("Bundle".equals(item.fhirType())) {
      for (Base e : children(item, "entry")) {
        Base r = single(e, "resource");
        if (r != null && "Composition".equals(r.fhirType())) {
          return r;
        }
      }
    }
    return null;
  }

  /** all the sections, nested ones after their parent */
  private List<Base> allSections(Base parent, List<Base> list) {
    for (Base s : children(parent, "section")) {
      list.add(s);
      allSections(s, list);
    }
    return list;
  }

  /** the document the evaluation is on */
  private Base document(Base root, Base focusResource) {
    if (root != null && "Bundle".equals(root.fhirType())) {
      return root;
    }
    if (focusResource != null && "Bundle".equals(focusResource.fhirType())) {
      return focusResource;
    }
    return null;
  }

  /** the resources of the documents the inputs are, or are in; each document once */
  private List<Base> documentResources(Base root, Base focusResource, List<Base> focus, String type) {
    List<Base> result = new ArrayList<>();
    Set<Base> seen = Collections.newSetFromMap(new IdentityHashMap<>());
    for (Base item : focus) {
      Base bundle = item != null && "Bundle".equals(item.fhirType()) ? item : document(root, focusResource);
      if (bundle != null && seen.add(bundle)) {
        for (Base e : children(bundle, "entry")) {
          Base r = single(e, "resource");
          if (r != null && (type == null || type.equals(r.fhirType()))) {
            result.add(r);
          }
        }
      }
    }
    return result;
  }

  /**
   * A section's entries, resolved; null if the item can't be a section (a resource or a primitive). References that can't be
   * resolved are left out.
   *
   * In a document, references are resolved in the document only - as the validator does for a document - and are never passed
   * to the host. Without a document (a Composition on its own) the host's resolveReference() is used.
   */
  private List<Base> sectionEntries(Object appInfo, Base root, Base focusResource, Base section) {
    if (section == null || section.isResource() || section.isPrimitive()) {
      return null;
    }
    Base bundle = document(root, focusResource);
    Base comp = null;
    String compFullUrl = null;
    if (bundle != null) {
      for (Base e : children(bundle, "entry")) {
        Base r = single(e, "resource");
        if (r != null && "Composition".equals(r.fhirType()) && containsSection(r, section)) {
          comp = r;
          compFullUrl = primitive(e, "fullUrl");
          break;
        }
      }
    }
    if (comp == null) {
      Base r = root != null && "Composition".equals(root.fhirType()) ? root : focusResource;
      if (r != null && "Composition".equals(r.fhirType()) && containsSection(r, section)) {
        comp = r;
      }
    }
    List<Base> result = new ArrayList<>();
    for (Base ref : children(section, "entry")) {
      String reference = primitive(ref, "reference");
      if (reference == null || reference.isEmpty()) {
        continue;
      }
      Base res = null;
      if (reference.startsWith("#")) {
        if (comp != null) {
          String id = reference.substring(1);
          for (Base c : children(comp, "contained")) {
            if (id.equals(c.getIdBase())) {
              res = c;
              break;
            }
          }
        }
      } else if (bundle != null) {
        res = inBundle(bundle, reference, comp, compFullUrl);
      } else if (engine.getHostServices() != null) {
        try {
          res = engine.getHostServices().resolveReference(engine, appInfo, reference, null, ref);
        } catch (Exception e) {
          res = null;
        }
      }
      if (res != null) {
        result.add(res);
      }
    }
    return result;
  }

  // An instance is made for one function call (see FHIRPathEngine.funcSection etc), and builds these
  // as it needs them, so that a call on many sections doesn't walk the document again for each one

  // a Composition's sections, nested ones too, by identity
  private final Map<Base, Set<Base>> sectionsOf = new IdentityHashMap<>();
  // a document's entries, indexed for resolving references
  private final Map<Base, BundleIndex> bundleIndexes = new IdentityHashMap<>();

  private boolean containsSection(Base comp, Base section) {
    Set<Base> sections = sectionsOf.get(comp);
    if (sections == null) {
      sections = Collections.newSetFromMap(new IdentityHashMap<>());
      sections.addAll(allSections(comp, new ArrayList<>()));
      sectionsOf.put(comp, sections);
    }
    return sections.contains(section);
  }

  /**
   * A document's entries, indexed as BaseValidator.resolveInBundle indexes a Bundle: by fullUrl (and by
   * fullUrl/_history/[versionId], when the resource has a meta.versionId), and by Type/id
   */
  private class BundleIndex {
    private final Map<String, List<Base>> byFullUrl = new HashMap<>();
    private final Map<String, List<Base>> byTypeAndId = new HashMap<>();

    private BundleIndex(Base bundle) {
      for (Base e : children(bundle, "entry")) {
        String fu = primitive(e, "fullUrl");
        add(byFullUrl, fu, e);
        Base r = single(e, "resource");
        if (r != null) {
          String id = r.getIdBase();
          if (id != null) {
            add(byTypeAndId, r.fhirType() + "/" + id, e);
          }
          Base meta = single(r, "meta");
          String versionId = meta == null ? null : primitive(meta, "versionId");
          if (fu != null && versionId != null) {
            add(byFullUrl, fu + "/_history/" + versionId, e);
          }
        }
      }
    }

    private void add(Map<String, List<Base>> map, String key, Base entry) {
      if (key != null) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
      }
    }
  }

  /**
   * A reference resolved in a document, as BaseValidator.resolveInBundle resolves it (less its error reporting), or null:
   * <ul>
   *   <li>a fragment (#...) on the end is set aside: the resource is what is resolved</li>
   *   <li>an absolute reference is resolved by fullUrl, and by nothing else</li>
   *   <li>a relative reference (Type/id) is resolved against the base of the referring Composition's fullUrl, when that is
   *   a RESTful URL (as BaseValidator's urlRegex), and before R4, by type and id</li>
   *   <li>more than one match is no match</li>
   * </ul>
   */
  private Base inBundle(Base bundle, String reference, Base comp, String compFullUrl) {
    BundleIndex index = bundleIndexes.get(bundle);
    if (index == null) {
      index = new BundleIndex(bundle);
      bundleIndexes.put(bundle, index);
    }
    String ref = reference.contains("#") ? reference.substring(0, reference.indexOf('#')) : reference;
    if (Utilities.isAbsoluteUrl(ref)) {
      return resourceOf(index.byFullUrl.get(ref));
    }
    String base = comp == null ? null : restfulBase(compFullUrl, comp.fhirType(), comp.getIdBase());
    if (base != null) {
      List<Base> el = index.byFullUrl.get(base + ref);
      if (el != null && !el.isEmpty()) {
        return resourceOf(el);
      }
    }
    // BaseValidator: from R4 on, a relative reference doesn't resolve by type and id alone - it needs a RESTful base
    int slash = ref.indexOf('/');
    if (slash > 0 && !VersionUtilities.isR4Plus(fhirVersion())) {
      String type = ref.substring(0, slash);
      String rest = ref.substring(slash + 1);
      String id = rest.contains("/") ? rest.substring(0, rest.indexOf('/')) : rest;
      if (!id.isEmpty() && worker.getResourceNamesAsSet().contains(type)) {
        return resourceOf(index.byTypeAndId.get(type + "/" + id));
      }
    }
    return null;
  }

  /** the resource of the one entry found; null if there is none, or more than one */
  private Base resourceOf(List<Base> entries) {
    return entries == null || entries.size() != 1 ? null : single(entries.get(0), "resource");
  }

  /**
   * The base a relative reference is resolved against: the referring resource's fullUrl less its own Type/id, when the
   * fullUrl is a RESTful one - [http(s)://...]Type/id, as BaseValidator's urlRegex (URI_REGEX_XVER) has it. Null if it isn't
   */
  static String restfulBase(String fullUrl, String type, String id) {
    if (fullUrl == null || type == null || id == null || !isRestfulId(id)) {
      return null;
    }
    String own = type + "/" + id;
    if (!fullUrl.endsWith(own)) {
      return null;
    }
    String base = fullUrl.substring(0, fullUrl.length() - own.length());
    if (base.isEmpty()) {
      return base;
    }
    String rest;
    if (base.startsWith("http://")) {
      rest = base.substring(7);
    } else if (base.startsWith("https://")) {
      rest = base.substring(8);
    } else {
      return null;
    }
    if (!rest.isEmpty() && !rest.endsWith("/")) {
      return null;
    }
    for (char ch : rest.toCharArray()) {
      if (!(isAsciiLetterOrDigit(ch) || "\\.:%$-_/".indexOf(ch) >= 0)) {
        return null;
      }
    }
    return base;
  }

  private static boolean isRestfulId(String id) {
    if (id.isEmpty() || id.length() > 64) {
      return false;
    }
    for (char ch : id.toCharArray()) {
      if (!(isAsciiLetterOrDigit(ch) || ch == '-' || ch == '.')) {
        return false;
      }
    }
    return true;
  }

  private static boolean isAsciiLetterOrDigit(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
  }

  // --- codes -------------------------------------------------------------------------------

  /** the code of a resource: its code, vaccineCode or medication (a CodeableConcept) */
  private List<Base> codes(Base resource) {
    List<Base> result = new ArrayList<>();
    for (String name : CODE_ELEMENTS) {
      for (Base v : children(resource, name)) {
        if ("CodeableConcept".equals(v.fhirType())) {
          result.add(v);
        } else if ("CodeableReference".equals(v.fhirType())) {
          Base c = single(v, "concept");
          if (c != null) {
            result.add(c);
          }
        }
      }
    }
    return result;
  }

  private boolean hasCode(Base resource, String system, String code) {
    for (Base cc : codes(resource)) {
      if (hasCoding(cc, system, code)) {
        return true;
      }
    }
    return false;
  }

  /** whether the concept has a coding that matches system and code - each null (empty) to match anything */
  private boolean hasCoding(Base concept, String system, String code) {
    if (concept == null) {
      return false;
    }
    for (Base c : children(concept, "coding")) {
      if (codingMatches(c, system, code, null)) {
        return true;
      }
    }
    return false;
  }

  private ValueSet findValueSet(Object appInfo, String fn, String url) {
    ValueSet vs = engine.getHostServices() != null ? engine.getHostServices().resolveValueSet(engine, appInfo, url) : worker.fetchResource(ValueSet.class, url);
    if (vs == null) {
      throw error(I18nConstants.FHIRPATH_DOC_VALUESET_UNKNOWN, fn, url);
    }
    return vs;
  }

  /** whether any coding of the resource's code is in the value set */
  private boolean inValueSet(ValidationOptions options, String fn, String url, ValueSet vs, Base resource) {
    for (Base cc : codes(resource)) {
      if (children(cc, "coding").isEmpty()) {
        continue;
      }
      org.hl7.fhir.r4.model.CodeableConcept concept = cc.castToCodeableConcept(cc);
      ValidationResult vr = worker.validateCode(options, concept, vs);
      if (vr.isOk()) {
        return true;
      }
      if (cantTell(vr)) {
        throw error(I18nConstants.FHIRPATH_DOC_VALUESET_NO_ANSWER, fn, url, vr.getMessage());
      }
    }
    return false;
  }

  /** whether a validation that failed couldn't decide (rather than saying no) */
  private boolean cantTell(ValidationResult vr) {
    TerminologyServiceErrorClass ec = vr.getErrorClass();
    return ec != null && ec.isInfrastructure();
  }

  // --- access ------------------------------------------------------------------------------

  private List<Base> children(Base item, String name) {
    List<Base> result = new ArrayList<>();
    try {
      Base[] values = item.listChildrenByName(name, false);
      if (values != null) {
        for (Base v : values) {
          if (v != null) {
            result.add(v);
          }
        }
      }
    } catch (FHIRException e) {
      // not a property of the item
    }
    return result;
  }

  private Base single(Base item, String name) {
    List<Base> list = children(item, name);
    return list.isEmpty() ? null : list.get(0);
  }

  private String primitive(Base item, String name) {
    Base v = single(item, name);
    return v == null ? null : v.primitiveValue();
  }
}
