package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;

/**
 * What a SNOMED CT concept says about where it's used - its semantic tag (from the fully
 * specified name), its sites and their laterality, and whether it's a planned procedure. Used by
 * SnomedResourceValidator: this class knows the rules, and that reports the problems.
 *
 * The properties come from the terminology server, in one $lookup per concept (cached)
 */
public class SnomedRules {

  public static final String SCT = "http://snomed.info/sct";

  private static final String FSN = "900000000000003001";
  private static final String FINDING_SITE = "363698007";
  private static final String PROCEDURE_SITE = "363704007";
  private static final String PROCEDURE_SITE_DIRECT = "405813007";
  private static final String PROCEDURE_SITE_INDIRECT = "405814001";
  private static final String LATERALITY = "272741003";
  private static final String PROCEDURE_CONTEXT = "408730004";
  private static final String FINDING_CONTEXT = "408729009";
  /**
   * the finding contexts that make a negation: Known absent, and its children Probably not present
   * and Definitely not present; and No known (1381510001, from the July 2026 International release,
   * where it replaced Known absent in the No known X allergy concepts)
   */
  private static final Set<String> KNOWN_ABSENT = Set.of("410516002", "410593006", "410594000", "1381510001");
  private static final String PLANNED = "397943006";
  private static final String PRODUCT = "373873005"; // Pharmaceutical / biologic product

  private static final Set<String> LOOKUP = Set.of("designation", "inactive", FINDING_CONTEXT, FINDING_SITE, PROCEDURE_SITE, PROCEDURE_SITE_DIRECT, PROCEDURE_SITE_INDIRECT, LATERALITY, PROCEDURE_CONTEXT);

  /** which side a body structure (or a laterality qualifier) is on */
  public enum Side {
    LEFT, RIGHT, BILATERAL, MIDLINE,
    /** can be on either side, but this one doesn't say (laterality = Side) */
    UNSTATED,
    /** doesn't have a side (no laterality) */
    NONE;

    public boolean isStated() {
      return this == LEFT || this == RIGHT || this == BILATERAL || this == MIDLINE;
    }
  }

  /** a laterality qualifier value (Left, Right...), or null if it isn't one */
  public static Side sideOfQualifier(String code) {
    if (code == null) {
      return null;
    }
    switch (code) {
    case "7771000": return Side.LEFT;
    case "24028007": return Side.RIGHT;
    case "51440002": return Side.BILATERAL;
    case "399488007": return Side.MIDLINE;
    case "182353008": return Side.UNSTATED;
    default: return null;
    }
  }

  /** a SNOMED CT concept, and what the terminology server says about it */
  public class Concept {
    private final String code;
    private final String version;
    private final String desc;
    private final Map<String, List<String>> props;

    private Concept(String code, String version, String display, Map<String, List<String>> props) {
      this.code = code;
      this.version = version;
      this.props = props;
      if (display == null) {
        // the fully specified name, without its semantic tag
        String fsn = first("designation:" + FSN);
        display = fsn != null && fsn.trim().endsWith(")") && fsn.contains(" (") ? fsn.substring(0, fsn.lastIndexOf(" (")).trim() : fsn;
      }
      this.desc = display == null ? code : code + " ('" + display + "')";
    }

    public String getCode() {
      return code;
    }

    /** the code and its display, for messages */
    public String getDesc() {
      return desc;
    }

    private String first(String name) {
      List<String> l = props.get(name);
      return l == null || l.isEmpty() ? null : l.get(0);
    }

    private List<String> all(String name) {
      List<String> l = props.get(name);
      return l == null ? new ArrayList<>() : l;
    }

    /** the semantic tag (disorder, procedure, body structure...), from the fully specified name */
    public String getSemanticTag() {
      String fsn = first("designation:" + FSN);
      if (fsn == null || !fsn.trim().endsWith(")") || !fsn.contains("(")) {
        return null;
      }
      String s = fsn.trim();
      return s.substring(s.lastIndexOf("(") + 1, s.length() - 1).trim();
    }

    /** the side, if this is a body structure: its laterality */
    public Side getSide() {
      List<String> l = all(LATERALITY);
      if (l.isEmpty()) {
        return Side.NONE;
      }
      Side s = l.size() == 1 ? sideOfQualifier(l.get(0)) : null;
      return s == null ? Side.UNSTATED : s;
    }

    /**
     * a negation: a situation whose finding is known to be absent (finding context = Known
     * absent, e.g. No known allergy)
     */
    public boolean isKnownAbsent() {
      for (String v : all(FINDING_CONTEXT)) {
        if (KNOWN_ABSENT.contains(v)) {
          return true;
        }
      }
      return false;
    }

    /** a planned procedure (procedure context = Planned) */
    public boolean isPlanned() {
      return all(PROCEDURE_CONTEXT).contains(PLANNED);
    }

    /**
     * the concept's site - its finding site, or procedure site - if it has exactly one; null if it
     * has none, or more than one (attributes come back without their role groups, so which goes
     * with which can't be told)
     */
    public Concept getSite() {
      List<String> sites = new ArrayList<>();
      for (String a : new String[] { FINDING_SITE, PROCEDURE_SITE, PROCEDURE_SITE_DIRECT, PROCEDURE_SITE_INDIRECT }) {
        for (String v : all(a)) {
          if (!sites.contains(v)) {
            sites.add(v);
          }
        }
      }
      return sites.size() == 1 ? lookup(sites.get(0), version, null) : null;
    }

    /** whether this is a medicinal product; null if that can't be told */
    public Boolean isProduct() {
      return context.subsumes(options, new Coding(SCT, PRODUCT, null), new Coding(SCT, code, null).setVersion(version));
    }
  }

  /** where a code is used, for judging the kind of concept it is */
  public enum Kind {
    CONDITION, PROCEDURE, OBSERVATION, BODY_SITE, SPECIMEN, ALLERGY, MEDICATION
  }

  public enum Level {
    HINT, WARNING, ERROR
  }

  /** what's wrong with the kind of concept where it's used: how bad, and the message */
  public static class Judgement {
    private final Level level;
    private final String messageId;
    private final Object[] args;

    private Judgement(Level level, String messageId, Object... args) {
      this.level = level;
      this.messageId = messageId;
      this.args = args;
    }

    public Level getLevel() {
      return level;
    }

    public String getMessageId() {
      return messageId;
    }

    public Object[] getArgs() {
      return args;
    }
  }

  private static final Set<String> CONDITION_TAGS = Set.of("disorder", "finding", "situation", "event", "context-dependent category");
  private static final Set<String> PROCEDURE_TAGS = Set.of("procedure", "regime/therapy");
  private static final Set<String> FINDING_TAGS = Set.of("disorder", "finding");
  private static final Set<String> BODY_STRUCTURE_TAGS = Set.of("body structure", "cell structure");
  private static final Set<String> ALLERGY_TAGS = Set.of("substance", "product", "medicinal product", "medicinal product form", "clinical drug", "real clinical drug",
    "disorder", "finding", "situation", "organism");

  /**
   * Whether the kind of concept (its semantic tag) fits where it's used; null if it does, or if
   * that can't be told. Conditions coded by their procedure, and procedures coded by their
   * condition, are common practice (coding by proxy): those are hints
   */
  public Judgement judge(Kind kind, Concept concept) {
    String tag = concept == null ? null : concept.getSemanticTag();
    if (tag == null) {
      return null; // nothing known about it, or no fully specified name to tell what it is
    }
    String desc = concept.getDesc();
    switch (kind) {
    case CONDITION:
      if (CONDITION_TAGS.contains(tag)) {
        return null;
      }
      return PROCEDURE_TAGS.contains(tag) ? new Judgement(Level.HINT, I18nConstants.SCT_CONDITION_CODE_PROXY, desc, tag) : new Judgement(Level.WARNING, I18nConstants.SCT_CONDITION_CODE_WRONG, desc, tag);
    case PROCEDURE:
      if (PROCEDURE_TAGS.contains(tag) || "situation".equals(tag)) {
        return null;
      }
      return FINDING_TAGS.contains(tag) ? new Judgement(Level.HINT, I18nConstants.SCT_PROCEDURE_CODE_PROXY, desc, tag) : new Judgement(Level.WARNING, I18nConstants.SCT_PROCEDURE_CODE_WRONG, desc, tag);
    case OBSERVATION:
      return FINDING_TAGS.contains(tag) ? new Judgement(Level.WARNING, I18nConstants.SCT_OBSERVATION_CODE_FINDING, desc, tag) : null;
    case BODY_SITE:
      return BODY_STRUCTURE_TAGS.contains(tag) ? null : new Judgement(Level.WARNING, I18nConstants.SCT_BODYSITE_WRONG, desc, tag);
    case SPECIMEN:
      return "specimen".equals(tag) ? null : new Judgement(Level.WARNING, I18nConstants.SCT_SPECIMEN_TYPE_WRONG, desc, tag);
    case ALLERGY:
      return ALLERGY_TAGS.contains(tag) ? null : new Judgement(Level.WARNING, I18nConstants.SCT_ALLERGY_CODE_WRONG, desc, tag);
    case MEDICATION:
      // products are told by the hierarchy, not the tag: national editions have tags of their own
      Boolean product = concept.isProduct();
      if (product == null || product) {
        return null;
      }
      return "substance".equals(tag) ? new Judgement(Level.HINT, I18nConstants.SCT_MEDICATION_SUBSTANCE, desc) : new Judgement(Level.ERROR, I18nConstants.SCT_MEDICATION_WRONG, desc, tag);
    default:
      return null;
    }
  }

  /** a side's name, for messages */
  public static String sideName(Side side) {
    switch (side) {
    case LEFT: return "Left";
    case RIGHT: return "Right";
    case BILATERAL: return "Right and left";
    case MIDLINE: return "Midline";
    default: return side.toString();
    }
  }

  private final IWorkerContext context;
  private final ValidationOptions options;

  public SnomedRules(IWorkerContext context, ValidationOptions options) {
    this.context = context;
    this.options = options;
  }

  /**
   * what the terminology server says about the concept; null if it doesn't know it (or there's no
   * server), or the concept is inactive - an inactive concept is reported as inactive, and has no
   * place in the hierarchy (or attributes) to judge it by
   */
  public Concept lookup(String code, String version, String display) {
    Map<String, List<String>> props = context.lookupProperties(options, SCT, version, code, LOOKUP);
    if (props == null || props.getOrDefault("inactive", new ArrayList<>()).contains("true")) {
      return null;
    }
    return new Concept(code, version, display, props);
  }

  /**
   * what the terminology server says about the concept, active or not (a negation code can be
   * inactive - No known latex allergy is - and still say what it says); null if it doesn't know it
   */
  public Concept lookupAny(String code, String version, String display) {
    Map<String, List<String>> props = context.lookupProperties(options, SCT, version, code, LOOKUP);
    return props == null ? null : new Concept(code, version, display, props);
  }

  /**
   * a post-coordinated expression that only refines a concept's laterality (e.g. 69695003:272741003=7771000,
   * a left stomach): the focus concept and the laterality, or null if it isn't one. Terms (|...|) and
   * whitespace are allowed around each code.
   */
  public static String[] lateralityRefinement(String expression) {
    if (expression == null || !expression.contains(":")) {
      return null;
    }
    ExpressionReader r = new ExpressionReader(expression);
    String focus = r.code();
    if (focus == null || !r.optionalTerm() || !r.symbol(':') || !LATERALITY.equals(r.code()) || !r.optionalTerm() || !r.symbol('=')) {
      return null;
    }
    String laterality = r.code();
    return laterality != null && r.optionalTerm() && r.atEnd() ? new String[] { focus, laterality } : null;
  }

  /** a minimal reader for the simple expressions lateralityRefinement accepts; each step skips leading whitespace */
  private static class ExpressionReader {
    private final String src;
    private int cursor;

    private ExpressionReader(String src) {
      this.src = src;
    }

    /** a run of digits, or null if there isn't one */
    private String code() {
      skipWhitespace();
      int start = cursor;
      while (cursor < src.length() && src.charAt(cursor) >= '0' && src.charAt(cursor) <= '9') {
        cursor++;
      }
      return cursor > start ? src.substring(start, cursor) : null;
    }

    /** skips a |term| if there is one; false if a term is opened but not closed */
    private boolean optionalTerm() {
      skipWhitespace();
      if (cursor < src.length() && src.charAt(cursor) == '|') {
        int end = src.indexOf('|', cursor + 1);
        if (end < 0) {
          return false;
        }
        cursor = end + 1;
      }
      return true;
    }

    private boolean symbol(char ch) {
      skipWhitespace();
      if (cursor < src.length() && src.charAt(cursor) == ch) {
        cursor++;
        return true;
      }
      return false;
    }

    private boolean atEnd() {
      skipWhitespace();
      return cursor == src.length();
    }

    private void skipWhitespace() {
      while (cursor < src.length() && " \t\n\u000B\f\r".indexOf(src.charAt(cursor)) >= 0) {
        cursor++;
      }
    }
  }
}
