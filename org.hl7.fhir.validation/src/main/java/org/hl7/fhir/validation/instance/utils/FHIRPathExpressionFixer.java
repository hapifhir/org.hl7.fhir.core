package org.hl7.fhir.validation.instance.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hl7.fhir.utilities.VersionUtilities;

/**
 * Hack work around for past publication of wrong FHIRPath expressions (and a couple of regexes).
 *
 * fixExpr is called for every invariant on every element the validator checks, so it is on the hot path.
 * The fixes are therefore held in a hash map keyed by the (exact) expression, and the few rules that
 * depend on the invariant key or the FHIR version are dispatched by a switch on the key. The version is
 * only examined when a version dependent rule is actually in play, and the result is cached per version string.
 *
 * Precedence: when more than one rule could apply, the rule that was listed first in the original
 * if-chain wins. The rules are therefore declared in that order, and the key-specific rules check
 * whichever expression rules preceded them.
 */
@SuppressWarnings("checkstyle:stringImplicitPatternUsage")
//False positive: .matches() occurs in FHIRPath expression string literals, not Java calls
public class FHIRPathExpressionFixer {

  // --- expression rules, in original precedence order. First registration of an expression wins ----

  /** expression rules that preceded the txt-2 / que-7 / dom-6 key rules */
  private static final Map<String, String> EARLY_FIXES = new HashMap<>();
  /** all expression rules that preceded the eld-19 / eld-20 key rules (includes EARLY_FIXES) */
  private static final Map<String, String> PRE_ELD_FIXES = new HashMap<>();
  /** all the unconditional expression rules */
  private static final Map<String, String> ALL_FIXES = new HashMap<>();

  // version dependent / key dependent rules

  private static final String OPD3_R5 = "targetProfile.exists() implies (type = 'Reference' or type = 'canonical' or type.memberOf('http://hl7.org/fhir/ValueSet/all-resource-types'))";
  private static final String OPD3_R4 = "targetProfile.exists() implies (type = 'Reference' or type = 'canonical' or type.memberOf('http://hl7.org/fhir/ValueSet/resource-types'))";
  private static final String TXT2 = "htmlChecks2()";
  private static final String QUE7 = "operator = 'exists' implies (answer is boolean)"; // wrong prior to R5
  private static final String DOM6 = "(%rootResource != $this) or text.`div`.exists()";
  // clarification in FHIRPath spec
  private static final String ELD19 = "path.matches('^[^\\\\s\\\\.,:;\\\\\\'\"\\\\/|?!@#$%&*()\\\\[\\\\]{}]{1,64}(\\\\.[^\\\\s\\\\.,:;\\\\\\'\"\\\\/|?!@#$%&*()\\\\[\\\\]{}]{1,64}(\\\\[x\\\\])?(\\\\:[^\\\\s\\\\.]+)?)*$')";
  private static final String ELD20 = "path.matches('^[A-Za-z][A-Za-z0-9]*(\\\\.[a-z][A-Za-z0-9]*(\\\\[x])?)*$')";
  // R4 (sits between the dom-6 and eld-19 rules)
  private static final String R4_OFFSET_EXPR = "offset.empty() or (when.exists() and ((when in ('C' | 'CM' | 'CD' | 'CV')).not()))";
  private static final String R4_OFFSET_FIX = "offset.empty() or (when.exists() and when.select($this in ('C' | 'CM' | 'CD' | 'CV')).allFalse())";
  // ras-2 (last rule)
  private static final String RAS2_EXPR = "probability is decimal implies probability.as(decimal) <= 100";
  private static final String RAS2_FIX = "probability.empty() or (probability is decimal implies probability.as(decimal) <= 100)";

  private static void early(String expr, String fix) {
    EARLY_FIXES.putIfAbsent(expr, fix);
    preEld(expr, fix);
  }

  private static void preEld(String expr, String fix) {
    PRE_ELD_FIXES.putIfAbsent(expr, fix);
    fix(expr, fix);
  }

  private static void fix(String expr, String fix) {
    ALL_FIXES.putIfAbsent(expr, fix);
  }

  static {
    // --- before txt-2 / que-7 / dom-6 ---
    early("probability is decimal implies (probability as decimal) <= 100",
        "(probability.exists() and (probability is decimal)) implies ((probability as decimal) <= 100)");
    early("enableWhen.count() > 2 implies enableBehavior.exists()",
        "enableWhen.count() >= 2 implies enableBehavior.exists()");

    // --- before eld-19 / eld-20 ---
    preEld("generated='generated' implies source.empty()",
        "generation='generated' implies source.empty()");
    preEld("binding.empty() or type.code.empty() or type.code.contains(\":\") or type.select((code = 'code') or (code = 'Coding') or (code='CodeableConcept') or (code = 'Quantity') or (code = 'string') or (code = 'uri') or (code = 'Duration')).exists()",
        "binding.empty() or type.code.empty() or type.code.contains(':') or type.select((code = 'code') or (code = 'Coding') or (code='CodeableConcept') or (code = 'Quantity') or (code = 'string') or (code = 'uri') or (code = 'Duration')).exists()");
    // fixes to string functions in FHIRPath
    // ref-1
    String ref1R5 = "reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids')) or (reference='#' and %rootResource!=%resource)"; // R5
    preEld(ref1R5, "reference.exists() implies ("+ref1R5+")");
    String ref1R4 = "reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))"; // R4/R4B
    preEld(ref1R4, "reference.exists() implies (reference = '#' or ("+ref1R4+"))");
    preEld("reference.startsWith('#').not() or (reference.substring(1).trace('url') in %resource.contained.id.trace('ids'))", // STU3
        "reference.exists() implies (reference = '#' or (reference.startsWith('#').not() or (reference.substring(1).trace('url') in %rootResource.contained.id.trace('ids'))))");
    // bld-8
    preEld("fullUrl.contains('/_history/').not()", // R4
        "fullUrl.exists() implies fullUrl.contains('/_history/').not()");
    preEld("name.matches('[A-Z]([A-Za-z0-9_]){0,254}')",
        "name.exists() implies name.matches('^[A-Z]([A-Za-z0-9_]){0,254}$')");
    // con-3 in R4
    preEld("clinicalStatus.exists() or verificationStatus.coding.where(system='http://terminology.hl7.org/CodeSystem/condition-ver-status' and code = 'entered-in-error').exists() or category.select($this='problem-list-item').empty()",
        "(verificationStatus.coding.where(system='http://terminology.hl7.org/CodeSystem/condition-ver-status' and code = 'entered-in-error').exists() and category.coding.exists(system='http://terminology.hl7.org/CodeSystem/condition-category' and code ='problem-list-item').empty()) implies (clinicalStatus.exists())");
    // (the R4-only offset rule sits here - see R4_OFFSET_EXPR)
    // R5 ballot
    preEld("url.matches('([^|#])*')",
        "$this.matches('([^|#])*')");
    preEld("((kind in 'resource' | 'complex-type') and (specialization = 'derivation')) implies differential.element.where((min != 0 and min != 1) or (max != '1' and max != '*')).empty()",
        "((kind in 'resource' | 'complex-type') and (derivation = 'specialization')) implies differential.element.where((min.exists() and min != 0 and min != 1) or (max.exists() and max != '1' and max != '*')).empty()");

    // --- after eld-19 / eld-20 ---
    // handled in 4.0.1
    fix("(component.empty() and hasMember.empty()) implies (dataAbsentReason or value)",
        "(component.empty() and hasMember.empty()) implies (dataAbsentReason.exists() or value.exists())");
    fix("isModifier implies isModifierReason.exists()",
        "(isModifier.exists() and isModifier) implies isModifierReason.exists()");
    fix("(%resource.kind = 'logical' or element.first().path.startsWith(%resource.type)) and (element.tail().not() or  element.tail().all(path.startsWith(%resource.differential.element.first().path.replaceMatches('\\\\..*','')&'.')))",
        "(%resource.kind = 'logical' or element.first().path.startsWith(%resource.type)) and (element.tail().empty() or  element.tail().all(path.startsWith(%resource.differential.element.first().path.replaceMatches('\\\\..*','')&'.')))");
    fix("differential.element.all(id) and differential.element.id.trace('ids').isDistinct()",
        "differential.element.all(id.exists()) and differential.element.id.trace('ids').isDistinct()");
    fix("snapshot.element.all(id) and snapshot.element.id.trace('ids').isDistinct()",
        "snapshot.element.all(id.exists()) and snapshot.element.id.trace('ids').isDistinct()");
    // R3
    fix("(code or value.empty()) and (system.empty() or system = 'urn:iso:std:iso:4217')",
        "(code.exists() or value.empty()) and (system.empty() or system = 'urn:iso:std:iso:4217')");
    fix("value.empty() or code!=component.code",
        "value.empty() or (code in component.code).not()");
    fix("(code or value.empty()) and (system.empty() or system = %ucum) and (value.empty() or value > 0)",
        "(code.exists() or value.empty()) and (system.empty() or system = %ucum) and (value.empty() or value > 0)");
    fix("element.all(definition and min and max)",
        "element.all(definition.exists() and min.exists() and max.exists())");
    fix("telecom or endpoint",
        "telecom.exists() or endpoint.exists()");
    fix("searchType implies type = 'string'",
        "searchType.exists() implies type = 'string'");
    fix("abatement.empty() or (abatement as boolean).not()  or clinicalStatus='resolved' or clinicalStatus='remission' or clinicalStatus='inactive'",
        "abatement.empty() or (abatement is boolean).not() or (abatement as boolean).not() or (clinicalStatus = 'resolved') or (clinicalStatus = 'remission') or (clinicalStatus = 'inactive')");
    fix("(component.empty() and related.empty()) implies (dataAbsentReason or value)",
        "(component.empty() and related.empty()) implies (dataAbsentReason.exists() or value.exists())");
    // (the R3 versions of ref-1 used to be listed here, but they were always pre-empted by the ref-1 rules above)
    // (ras-2 is last - see RAS2_EXPR)
  }

  // --- version flags, cached per version string ----

  private static final int R4 = 1;
  private static final int R5 = 2;
  private static final Map<String, Integer> VERSION_FLAGS = new ConcurrentHashMap<>();

  private static int versionFlags(String version) {
    if (version == null) {
      return 0;
    }
    Integer res = VERSION_FLAGS.get(version);
    if (res == null) {
      // if the version is invalid, this throws, and nothing is cached
      int f = 0;
      if (VersionUtilities.isR5Ver(version)) {
        f |= R5;
      }
      if (VersionUtilities.isR4Ver(version) || VersionUtilities.isR4BVer(version)) {
        f |= R4;
      }
      res = f;
      VERSION_FLAGS.put(version, res);
    }
    return res;
  }

  private static boolean isR5(String version) {
    return (versionFlags(version) & R5) != 0;
  }

  private static boolean isR4(String version) {
    return (versionFlags(version) & R4) != 0;
  }

  // --- fixExpr ----

  public static String fixExpr(String expr, String key, String version) {
    // this is a hack work around for past publication of wrong FHIRPath expressions
    if (key != null) {
      switch (key) {
        case "opd-3":
          // see https://chat.fhir.org/#narrow/stream/196008-ig-publishing-requirements/topic/Operation.20Definition.20Parameters.20table
          if (isR5(version)) {
            return OPD3_R5;
          }
          if (isR4(version)) {
            return OPD3_R4;
          }
          break;
        case "txt-2":
          return earlyFixOr(expr, TXT2);
        case "que-7":
          return earlyFixOr(expr, QUE7);
        case "dom-6":
          return earlyFixOr(expr, DOM6);
        case "eld-19":
          return preEldFixOr(expr, version, ELD19);
        case "eld-20":
          return preEldFixOr(expr, version, ELD20);
        case "ras-2":
          if (RAS2_EXPR.equals(expr)) {
            return RAS2_FIX; // nothing else matches this expression, so no precedence questions
          }
          break;
        default:
          break;
      }
    }
    if (expr == null) {
      return null;
    }
    String res = ALL_FIXES.get(expr);
    if (res != null) {
      return res;
    }
    if (R4_OFFSET_EXPR.equals(expr) && isR4(version)) {
      return R4_OFFSET_FIX;
    }
    return expr;
  }

  private static String earlyFixOr(String expr, String keyFix) {
    String res = expr == null ? null : EARLY_FIXES.get(expr);
    return res != null ? res : keyFix;
  }

  private static String preEldFixOr(String expr, String version, String keyFix) {
    if (expr != null) {
      String res = PRE_ELD_FIXES.get(expr);
      if (res != null) {
        return res;
      }
      if (R4_OFFSET_EXPR.equals(expr) && isR4(version)) {
        return R4_OFFSET_FIX;
      }
    }
    if (isR5(version)) {
      // the eld-19/20 fixes don't apply to R5; fall back to the rules that come after them
      return expr == null ? null : ALL_FIXES.getOrDefault(expr, expr);
    }
    return keyFix;
  }

  public static String fixRegex(String regex) {
    if (regex == null) {
      return null;
    }
    if (regex.equals("-?(0|[1-9][0-9]{0,17})(\\.[0-9]{1,17})?([eE][+-]?[0-9]{1,9}})?")) {
      return "-?(0|[1-9][0-9]{0,17})(\\.[0-9]{1,17})?([eE](0|[+\\-]?[1-9][0-9]{0,9}))?";
    }
    if (regex.equals("[ \\r\\n\\t\\S]+")) {
      return "^[\\s\\S]+$";
    }
    return regex;
  }

}
