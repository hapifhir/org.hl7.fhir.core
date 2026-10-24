package org.hl7.fhir.r5.fhirpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.TypeConvertor;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.context.IWorkerContext.VersionResolutionRules;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
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
 *   Composition's sections, nested ones too, whose code has a coding with that system and code.</li>
 *   <li><b>entry(system, code [, min, max])</b> - the input is sections. For each, its entries,
 *   resolved, whose code has a coding with that system and code.</li>
 *   <li><b>entryIn(valueSet [, min, max])</b> - as entry(), with a code in the value set.</li>
 *   <li><b>resources(system, code [, type])</b> - the input is documents, or anything in one. Every
 *   resource in the document whose code has a coding with that system and code, and is of the
 *   type, when one is given.</li>
 *   <li><b>resourcesIn(valueSet [, type])</b> - as resources(), with a code in the value set.</li>
 * </ul>
 *
 * min and max are both given, or neither: with neither, there's no constraint; max may be '*'.
 * When the number found for an input item is outside min..max, that item adds nothing to the
 * output (that is not an error). A resource's code is its code, vaccineCode or medication
 * (when that's a CodeableConcept, or a CodeableReference's concept - a medication given by
 * reference isn't followed). A value set is a canonical URL, with |version or not; a code is
 * in it when any coding of the code is. A value set that can't be found, or a membership the
 * terminology services can't decide, is an error.
 *
 * References in sections are resolved in the document the evaluation is on (the root resource,
 * or else the focus resource, when it's a Bundle): by fullUrl - absolute as is, relative
 * (Type/id) against the base of the Composition's fullUrl, or else by type and id - and '#id'
 * as a resource contained in the Composition. Anything else is passed to the host's
 * resolveReference().
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
  }

  // --- parameters --------------------------------------------------------------------------

  Bounds bounds(String fn, List<Base> min, List<Base> max) {
    if (min == null) {
      return Bounds.ANY;
    }
    String smin = single(min);
    String smax = single(max);
    Integer imin = nonNegative(smin);
    Integer imax = "*".equals(smax) ? Integer.valueOf(-1) : nonNegative(smax);
    if (imin == null || imax == null || (imax >= 0 && imax < imin)) {
      throw error(I18nConstants.FHIRPATH_DOC_BOUNDS, fn, smin, smax);
    }
    return new Bounds(imin, imax);
  }

  String valueSet(String fn, List<Base> param) {
    String url = single(param);
    if (!isCanonical(url)) {
      throw error(I18nConstants.FHIRPATH_DOC_VALUESET, fn, url);
    }
    return url;
  }

  String resourceType(String fn, List<Base> param) {
    if (param == null) {
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
   */
  private List<Base> sectionEntries(Object appInfo, Base root, Base focusResource, Base section) {
    if (section == null || section.isResource() || section.isPrimitive()) {
      return null;
    }
    Base bundle = document(root, focusResource);
    Base comp = null;
    String fromFullUrl = null;
    if (bundle != null) {
      for (Base e : children(bundle, "entry")) {
        Base r = single(e, "resource");
        if (r != null && "Composition".equals(r.fhirType()) && containsSection(r, section)) {
          comp = r;
          fromFullUrl = primitive(e, "fullUrl");
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
        res = inBundle(bundle, reference, fromFullUrl);
      }
      if (res == null && !reference.startsWith("#") && engine.getHostServices() != null) {
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

  private boolean containsSection(Base comp, Base section) {
    for (Base s : allSections(comp, new ArrayList<>())) {
      if (s == section) {
        return true;
      }
    }
    return false;
  }

  /** the base of an absolute RESTful fullUrl ([base]/Type/id[/_history/v]), or null */
  static String baseOf(String fullUrl) {
    if (fullUrl == null || !(fullUrl.startsWith("http://") || fullUrl.startsWith("https://"))) {
      return null;
    }
    String url = stripHistory(fullUrl);
    int slash = url.lastIndexOf('/');
    if (slash < 0) {
      return null;
    }
    int typeSlash = url.lastIndexOf('/', slash - 1);
    if (typeSlash < url.indexOf("://") + 3) {
      return null;
    }
    String type = url.substring(typeSlash + 1, slash);
    String id = url.substring(slash + 1);
    return isTypeName(type) && isId(id) ? url.substring(0, typeSlash + 1) : null;
  }

  private static String stripHistory(String url) {
    int h = url.lastIndexOf("/_history/");
    return h > 0 && url.indexOf('/', h + 10) < 0 ? url.substring(0, h) : url;
  }

  private static boolean isId(String id) {
    if (id.isEmpty() || id.length() > 64) {
      return false;
    }
    for (char ch : id.toCharArray()) {
      if (!(Character.isLetterOrDigit(ch) && ch < 128) && ch != '-' && ch != '.') {
        return false;
      }
    }
    return true;
  }

  private static boolean hasScheme(String ref) {
    int colon = ref.indexOf(':');
    if (colon < 1 || !Character.isLetter(ref.charAt(0))) {
      return false;
    }
    for (int i = 0; i < colon; i++) {
      char ch = ref.charAt(i);
      if (!(Character.isLetterOrDigit(ch) || ch == '+' || ch == '.' || ch == '-')) {
        return false;
      }
    }
    return true;
  }

  /** a reference resolved in a Bundle, or null */
  private Base inBundle(Base bundle, String reference, String fromFullUrl) {
    String ref = stripHistory(reference);
    List<Base> entries = children(bundle, "entry");
    if (hasScheme(ref)) {
      for (Base e : entries) {
        if (ref.equals(primitive(e, "fullUrl"))) {
          return single(e, "resource");
        }
      }
      return null;
    }
    int slash = ref.indexOf('/');
    if (slash < 0 || ref.indexOf('/', slash + 1) >= 0) {
      return null;
    }
    String type = ref.substring(0, slash);
    String id = ref.substring(slash + 1);
    if (!isTypeName(type) || !isId(id)) {
      return null;
    }
    String base = baseOf(fromFullUrl);
    if (base != null) {
      for (Base e : entries) {
        if ((base + ref).equals(primitive(e, "fullUrl")) && single(e, "resource") != null) {
          return single(e, "resource");
        }
      }
    }
    // no usable base: an entry with that type and id, whose fullUrl (if any) ends with it
    for (Base e : entries) {
      Base r = single(e, "resource");
      String fu = primitive(e, "fullUrl");
      if (r != null && type.equals(r.fhirType()) && id.equals(r.getIdBase()) && (fu == null || fu.endsWith("/" + ref) || baseOf(fu) == null)) {
        return r;
      }
    }
    return null;
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

  private boolean hasCoding(Base concept, String system, String code) {
    if (concept == null || system == null || code == null) {
      return false;
    }
    for (Base c : children(concept, "coding")) {
      if (system.equals(primitive(c, "system")) && code.equals(primitive(c, "code"))) {
        return true;
      }
    }
    return false;
  }

  private ValueSet findValueSet(Object appInfo, String fn, String url) {
    ValueSet vs = engine.getHostServices() != null ? engine.getHostServices().resolveValueSet(engine, appInfo, url) : worker.findTxResource(ValueSet.class, url, VersionResolutionRules.defaultRule());
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
      org.hl7.fhir.r5.model.CodeableConcept concept = TypeConvertor.castToCodeableConcept(cc);
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
    return ec != null && (ec.isInfrastructure() || ec == TerminologyServiceErrorClass.VALUESET_UNKNOWN ||
      ec == TerminologyServiceErrorClass.TOO_COSTLY || ec == TerminologyServiceErrorClass.INTERNAL_ERROR);
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
