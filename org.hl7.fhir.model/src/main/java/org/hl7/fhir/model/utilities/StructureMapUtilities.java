package org.hl7.fhir.model.utilities;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


// remember group resolution
// trace - account for which wasn't transformed in the source


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.IdType;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.UriType;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.fml.StructureMap;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rendering the FML (mapping language) syntax for a StructureMap, and the small helpers that go
 * with it. This lives in the model module rather than beside StructureMapTools in services because
 * it depends on nothing above the model: the generated StructureMap classes carry toString()
 * implementations that delegate here (see add-ons-config-r6), and the model module cannot see
 * services
 * <p>
 * The transform engine, the FML parser and the analysis all stay in
 * org.hl7.fhir.services.fml.StructureMapTools, which delegates the render entry points here so
 * that existing callers keep working
 */
public class StructureMapUtilities {

  private static final boolean MULTIPLE_TARGETS_ONELINE = true;
  public static final String AUTO_VAR_NAME = "vvv";
  public static final String DEF_GROUP_NAME = "DefaultMappingGroupAnonymousAlias";
  // Sentinel prefix used by the "Simple Form: Identity Transform" batch parser
  // when the source FML did not supply an explicit ruleName. Stored as the
  // rule-name prefix (e.g. element `a` becomes `unnameda`) so that the renderer
  // can distinguish batch-form rules from singly-written `src.x -> tgt.x;`
  // rules - without the sentinel both shapes are indistinguishable in memory
  // and the renderer cannot tell whether to re-collapse into batch form.
  public static final String BATCH_IDENTITY_UNNAMED_NAME = "unnamed";

  public static String render(StructureMap map) {
    StringBuilder b = new StringBuilder();
    b.append("/// url = '"+Utilities.escapeFhirPathString(map.getUrl())+"'\r\n");
    b.append("/// name = '"+Utilities.escapeFhirPathString(map.getName())+"'\r\n");
    if (map.hasTitle()) {
      b.append("/// title = '"+Utilities.escapeFhirPathString(map.getTitle())+"'\r\n");
    }
    b.append("/// status = '"+Utilities.escapeFhirPathString(map.getStatus().toCode())+"'\r\n");
    if (map.hasDescription() && !map.getDescription().equals(map.getTitle())) {
      String desc = map.getDescription();
      // Use triple-quoted markdown form when the description spans multiple lines so
      // the source remains human-readable. Falls back to the single-line escaped
      // form when: the description has no line breaks; it contains """ (which cannot
      // be represented inside a verbatim triple-quoted block); or it ends with a "
      // (which would be greedily merged into the closing """ by the parser).
      if ((desc.indexOf('\n') >= 0 || desc.indexOf('\r') >= 0) && !desc.contains("\"\"\"") && !desc.endsWith("\"")) {
        b.append("/// description = \"\"\"");
        b.append(desc);
        b.append("\"\"\"\r\n");
      } else {
        b.append("/// description = '"+Utilities.escapeFhirPathString(desc)+"'\r\n");
      }
    }
    if (map.hasExperimental()) {
      b.append("/// experimental = "+map.getExperimental()+"\r\n");
    }
    b.append("\r\n");
    renderConceptMaps(b, map);
    renderUses(b, map);
    renderImports(b, map);
    renderConsts(b, map);
    for (StructureMap.StructureMapGroupComponent g : map.getGroupList())
      renderGroup(b, g);
    return b.toString();
  }

  // === Simple Form: Identity Transform batch detection =================================
  // The "Simple Form: Identity Transform" syntax `src -> tgt: e1, e2, e3 [ruleName];`
  // (https://hl7.org/fhir/R5/mapping-language.html#simple) is parsed into N sibling
  // rules. To round-trip back to the compact form on render without relying on out-of-
  // band user data, the parser names each generated rule `makeId(ruleName + element)`
  // (with ruleName defaulting to ""). On render, runs of consecutive sibling rules that
  // (a) look structurally like a simple identity rule (context+element on source AND
  // target with everything matching, no transform/variable/condition/etc), (b) share
  // the same source/target context, and (c) have names of the form `<prefix>` +
  // `makeId(element)` for one common `prefix`, are emitted as a single batch line.
  // A run of length 1 falls back to the normal renderRule path.

  private static boolean isSimpleIdentityRule(StructureMap.StructureMapGroupRuleComponent r) {
    if (r.getSourceList().size() != 1 || r.getTargetList().size() != 1)
      return false;
    if (r.hasRule() || r.hasDependent())
      return false;
    StructureMap.StructureMapGroupRuleSourceComponent s = r.getSourceFirstRep();
    StructureMap.StructureMapGroupRuleTargetComponent t = r.getTargetFirstRep();
    if (!s.hasContext() || !s.hasElement())
      return false;
    if (!t.hasContext() || !t.hasElement())
      return false;
    if (s.hasType() || s.hasMin() || s.hasListMode() || s.hasDefaultValue()
        || s.hasCondition() || s.hasCheck() || s.hasLogMessage())
      return false;
    if (!t.getParameterList().isEmpty() || !t.getListModeList().isEmpty())
      return false;
    // Accept the executable simple-form shape: vvv variable on both sides plus a
    // CREATE transform on target with no params (matches both the non-batch
    // isSimpleSyntax branch and the batch-form rules produced just above). A
    // bare shape (no variable, no transform) is also accepted to stay tolerant
    // of programmatically-built rules.
    if (s.hasVariable() && !AUTO_VAR_NAME.equals(s.getVariable()))
      return false;
    if (t.hasVariable() && !AUTO_VAR_NAME.equals(t.getVariable()))
      return false;
    if (t.hasTransform() && t.getTransform() != StructureMap.StructureMapTransform.CREATE)
      return false;
    // element is 0..* in R6 where it was 0..1 in R5, so this is a list of StringType, and
    // List.equals compares the StringTypes with Object.equals - which the model does not
    // override, so it is object identity, and two rules never matched. Compare the values.
    // A batch member names exactly one element on each side (a rule that names several is
    // already the batch form, and getElementName() below throws for it)
    if (s.getElementList().size() != 1 || t.getElementList().size() != 1)
      return false;
    return elementNames(s.getElementList()).equals(elementNames(t.getElementList()));
  }

  /**
   * The values of a rule source's or target's element list. R6 made element 0..*, so the
   * generated accessor returns List&lt;StringType&gt;, which compares and prints by object
   * identity rather than by value
   */
  private static List<String> elementNames(List<StringType> elements) {
    List<String> res = new ArrayList<>();
    for (StringType e : elements) {
      res.add(e.getValue());
    }
    return res;
  }

  /**
   * If {@code r} is a simple identity rule whose name matches the
   * {@code <prefix> + makeId(element)} pattern (with a non-empty prefix),
   * returns the prefix part. A bare name with no prefix is not a batch (those
   * come from singly-written {@code src.x -> tgt.x;} rules that share the
   * shape but were never grouped) so {@code null} is returned in that case.
   * Returns {@code null} when {@code r} is not a simple identity rule.
   */
  private static String identityBatchPrefix(StructureMap.StructureMapGroupRuleComponent r) {
    if (!isSimpleIdentityRule(r) || !r.hasName())
      return null;
    String suffix = Utilities.makeId(r.getSourceFirstRep().getElementName());
    String name = r.getName();
    if (suffix.isEmpty() || !name.endsWith(suffix))
      return null;
    String prefix = name.substring(0, name.length() - suffix.length());
    if (prefix.isEmpty())
      return null;
    return prefix;
  }

  /**
   * Returns the inclusive end index of an identity-transform batch starting at
   * {@code start}, or {@code start} itself if there's no batch (no batch is
   * emitted unless at least 2 consecutive rules match).
   */
  private static int detectIdentityBatchEnd(List<StructureMap.StructureMapGroupRuleComponent> rules, int start) {
    // Trailing `// comment` on the batch terminator is preserved on the first
    // rule by the parser, so a trailing comment on rules[start] doesn't prevent
    // batching. Trailing comments on subsequent rules WOULD be lost, so the loop
    // below stops if it sees one.
    StructureMap.StructureMapGroupRuleComponent first = rules.get(start);
    String prefix = identityBatchPrefix(first);
    if (prefix == null)
      return start;
    String srcCtx = first.getSourceFirstRep().getContext();
    String tgtCtx = first.getTargetFirstRep().getContext();
    int end = start;
    for (int j = start + 1; j < rules.size(); j++) {
      StructureMap.StructureMapGroupRuleComponent r = rules.get(j);
      // Don't swallow subsequent rules that have their own documentation or
      // trailing format comments — those would be silently lost in a batch.
      if (r.hasDocumentation() || r.hasFormatCommentPost())
        break;
      String p = identityBatchPrefix(r);
      if (p == null || !prefix.equals(p))
        break;
      if (!srcCtx.equals(r.getSourceFirstRep().getContext())
          || !tgtCtx.equals(r.getTargetFirstRep().getContext()))
        break;
      end = j;
    }
    return end;
  }

  private static void renderIdentityBatch(StringBuilder b, List<StructureMap.StructureMapGroupRuleComponent> rules,
      int start, int end, int indent) {
    StructureMap.StructureMapGroupRuleComponent first = rules.get(start);
    if (first.hasDocumentation()) {
      renderMultilineDoco(b, first.getDocumentation(), indent);
    }
    for (int i = 0; i < indent; i++)
      b.append(' ');
    b.append(first.getSourceFirstRep().getContext());
    b.append(" -> ");
    b.append(first.getTargetFirstRep().getContext());
    b.append(": ");
    for (int j = start; j <= end; j++) {
      if (j > start)
        b.append(", ");
      b.append(String.join(", ", elementNames(rules.get(j).getSourceFirstRep().getElementList())));
    }
    String prefix = identityBatchPrefix(first);
    if (prefix != null && !BATCH_IDENTITY_UNNAMED_NAME.equals(prefix)) {
      b.append(" \"");
      b.append(prefix);
      b.append("\"");
    }
    b.append(";");
    if (first.hasFormatCommentPost()) {
      b.append(" // ");
      b.append(first.getFormatCommentsPost().get(0));
    }
    b.append("\r\n");
  }

  private static void renderRules(StringBuilder b, List<StructureMap.StructureMapGroupRuleComponent> rules, int indent) {
    int i = 0;
    while (i < rules.size()) {
      int end = detectIdentityBatchEnd(rules, i);
      if (end > i) {
        renderIdentityBatch(b, rules, i, end, indent);
        i = end + 1;
      } else {
        renderRule(b, rules.get(i), indent);
        i++;
      }
    }
  }

  private static void renderConceptMaps(StringBuilder b, StructureMap map) {
    for (Resource r : map.getContainedList()) {
      if (r instanceof ConceptMap) {
        produceConceptMap(b, (ConceptMap) r);
      }
    }
  }

  private static void produceConceptMap(StringBuilder b, ConceptMap cm) {
    b.append("conceptmap \"");
    b.append(cm.getId());
    b.append("\" {\r\n");
    Map<String, String> prefixesSrc = new HashMap<String, String>();
    Map<String, String> prefixesTgt = new HashMap<String, String>();
    char prefix = 's';
    for (ConceptMap.ConceptMapGroupComponent cg : cm.getGroupList()) {
      if (!prefixesSrc.containsKey(cg.getSource())) {
        prefixesSrc.put(cg.getSource(), String.valueOf(prefix));
        b.append("  prefix ");
        b.append(prefix);
        b.append(" = \"");
        b.append(cg.getSource());
        b.append("\"\r\n");
        prefix++;
      }
      if (!prefixesTgt.containsKey(cg.getTarget())) {
        prefixesTgt.put(cg.getTarget(), String.valueOf(prefix));
        b.append("  prefix ");
        b.append(prefix);
        b.append(" = \"");
        b.append(cg.getTarget());
        b.append("\"\r\n");
        prefix++;
      }
    }
    b.append("\r\n");
    for (ConceptMap.ConceptMapGroupComponent cg : cm.getGroupList()) {
      if (cg.hasUnmapped()) {
        b.append("  unmapped for ");
        b.append(prefixesSrc.get(cg.getSource()));
        b.append(" = ");
        b.append(cg.getUnmapped().getMode().toCode());
        b.append("\r\n");
      }
    }

    for (ConceptMap.ConceptMapGroupComponent cg : cm.getGroupList()) {
      for (ConceptMap.SourceElementComponent ce : cg.getElementList()) {
        b.append("  ");
        b.append(prefixesSrc.get(cg.getSource()));
        b.append(":");
        if (Utilities.isToken(ce.getCode())) {
          b.append(ce.getCode());
        } else {
          b.append("\"");
          b.append(ce.getCode());
          b.append("\"");
        }
        b.append(" ");
        b.append(getChar(ce.getTargetFirstRep().getRelationship()));
        b.append(" ");
        b.append(prefixesTgt.get(cg.getTarget()));
        b.append(":");
        if (Utilities.isToken(ce.getTargetFirstRep().getCode())) {
          b.append(ce.getTargetFirstRep().getCode());
        } else {
          b.append("\"");
          b.append(ce.getTargetFirstRep().getCode());
          b.append("\"");
        }
        b.append("\r\n");
      }
    }
    b.append("}\r\n\r\n");
  }

  private static Object getChar(Enumerations.ConceptMapRelationship relationship) {
    switch (relationship) {
      case RELATEDTO:
        return "-";
      case EQUIVALENT:
        return "==";
      case NOTRELATEDTO:
        return "!=";
      case SOURCEISNARROWERTHANTARGET:
        return "<=";
      case SOURCEISBROADERTHANTARGET:
        return ">=";
      default:
        return "??";
    }
  }

  private static void renderUses(StringBuilder b, StructureMap map) {
    for (StructureMap.StructureMapStructureComponent s : map.getStructureList()) {
      if (s.hasDocumentation()) {
        renderMultilineDoco(b, s.getDocumentation(), 0);
      }
      b.append("uses \"");
      b.append(s.getUrl());
      b.append("\" ");
      if (s.hasAlias()) {
        b.append("alias ");
        b.append(s.getAlias());
        b.append(" ");
      }
      b.append("as ");
      b.append(s.getMode().toCode());
      // Same-line trailing `//` comment captured in formatCommentsPost is
      // emitted after the mode keyword, mirroring how renderRule handles
      // trailing-on-`;` comments.
      if (s.hasFormatCommentPost()) {
        b.append(" // ");
        b.append(s.getFormatCommentsPost().get(0));
      }
      b.append("\r\n");
    }
    if (map.hasStructure())
      b.append("\r\n");
  }

  private static void renderImports(StringBuilder b, StructureMap map) {
    for (UriType s : map.getImportList()) {
      b.append("imports \"");
      b.append(s.getValue());
      b.append("\"\r\n");
    }
    if (map.hasImport())
      b.append("\r\n");
  }

  private static void renderConsts(StringBuilder b, StructureMap map) {
    for (StructureMap.StructureMapConstComponent c : map.getConstList()) {
      b.append("let ");
      b.append(c.getName());
      b.append(" = ");
      b.append(c.getValue());
      b.append(";\r\n");
    }
    if (map.hasConst())
      b.append("\r\n");
  }

  public static String groupToString(StructureMap.StructureMapGroupComponent g) {
    StringBuilder b = new StringBuilder();
    renderGroup(b, g);
    return b.toString();
  }

  private static void renderGroup(StringBuilder b, StructureMap.StructureMapGroupComponent g) {
    if (g.hasDocumentation()) {
      renderMultilineDoco(b, g.getDocumentation(), 0);
    }
    b.append("group ");
    b.append(g.getName());
    b.append("(");
    boolean first = true;
    for (StructureMap.StructureMapGroupInputComponent gi : g.getInputList()) {
      if (first)
        first = false;
      else
        b.append(", ");
      b.append(gi.getMode().toCode());
      b.append(" ");
      b.append(gi.getName());
      if (gi.hasType()) {
        b.append(" : ");
        b.append(gi.getType());
      }
    }
    b.append(")");
    if (g.hasExtends()) {
      b.append(" extends ");
      b.append(g.getExtends());
    }

    if (g.hasTypeMode()) {
      switch (g.getTypeMode()) {
        case TYPES:
          b.append(" <<types>>");
          break;
        case TYPEANDTYPES:
          b.append(" <<type+>>");
          break;
        default: // NONE, NULL
      }
    }
    b.append(" {\r\n");
    renderRules(b, g.getRuleList(), 2);
    b.append("}\r\n\r\n");
  }

  public static String ruleToString(StructureMap.StructureMapGroupRuleComponent r) {
    StringBuilder b = new StringBuilder();
    renderRule(b, r, 0);
    return b.toString();
  }

  private static void renderRule(StringBuilder b, StructureMap.StructureMapGroupRuleComponent r, int indent) {
    if (r.hasDocumentation()) {
      renderMultilineDoco(b, r.getDocumentation(), indent);
    }
    for (int i = 0; i < indent; i++)
      b.append(' ');
    boolean canBeAbbreviated = checkisSimple(r);
    {
      boolean first = true;
      for (StructureMap.StructureMapGroupRuleSourceComponent rs : r.getSourceList()) {
        if (first)
          first = false;
        else
          b.append(", ");
        renderSource(b, rs, canBeAbbreviated);
      }
    }
    if (r.getTargetList().size() > 1) {
      b.append(" ->");
      boolean first = true;
      for (StructureMap.StructureMapGroupRuleTargetComponent rt : r.getTargetList()) {
        if (first)
          first = false;
        else
          b.append(",");
        if (MULTIPLE_TARGETS_ONELINE)
          b.append(' ');
        else {
          b.append("\r\n");
          for (int i = 0; i < indent + 4; i++)
            b.append(' ');
        }
        renderTarget(b, rt, false);
      }
    } else if (r.hasTarget()) {
      b.append(" -> ");
      renderTarget(b, r.getTargetList().get(0), canBeAbbreviated);
    }
    if (r.hasRule()) {
      b.append(" then {\r\n");
      renderRules(b, r.getRuleList(), indent + 2);
      for (int i = 0; i < indent; i++)
        b.append(' ');
      b.append("}");
    } else if (!canBeAbbreviated) {
      if (r.hasDependent()) {
        b.append(" then ");
        boolean first = true;
        for (StructureMap.StructureMapGroupRuleDependentComponent rd : r.getDependentList()) {
          if (first)
            first = false;
          else
            b.append(", ");
          b.append(rd.getName());
          b.append("(");
          boolean ifirst = true;
          for (StructureMap.StructureMapGroupRuleTargetParameterComponent rdp : rd.getParameterList()) {
            if (ifirst)
              ifirst = false;
            else
              b.append(", ");
            renderTransformParam(b, rdp);
          }
          b.append(")");
        }
      }
    }
    if (r.hasName()) {
      // only put the name in if it wasn't auto-generated
      String autoGeneratedName = r.getSourceFirstRep().getElementName();
      if (r.getSourceFirstRep().hasType())
        autoGeneratedName += Utilities.capitalize(r.getSourceFirstRep().getType());
      
      String ruleName = r.getName();
      if (!ruleName.equals(autoGeneratedName))
      {
        b.append(" \"");
        b.append(ruleName);
        b.append("\"");
      }
    }
    b.append(";");
    if (r.hasFormatCommentPost()) {
      b.append(" // ");
      b.append(r.getFormatCommentsPost().get(0));
    }
    b.append("\r\n");
  }

  private static boolean matchesName(String n, List<StructureMap.StructureMapGroupRuleSourceComponent> source) {
    if (source.size() != 1)
      return false;
    if (!source.get(0).hasElement())
      return false;
    String s = source.get(0).getElementName();
    if (n.equals(s) || n.equals("\"" + s + "\""))
      return true;
    if (source.get(0).hasType()) {
      s = source.get(0).getElementName() + "-" + source.get(0).getType();
      return n.equals(s) || n.equals("\"" + s + "\"");
    }
    return false;
  }

  private static String ntail(String name) {
    if (name == null)
      return null;
    if (name.startsWith("\"")) {
      name = name.substring(1);
      name = name.substring(0, name.length() - 1);
    }
    return "\"" + (name.contains(".") ? name.substring(name.lastIndexOf(".") + 1) : name) + "\"";
  }

  private static boolean checkisSimple(StructureMap.StructureMapGroupRuleComponent r) {
    return
      (r.getSourceList().size() == 1 && r.getSourceFirstRep().hasElement() && r.getSourceFirstRep().hasVariable()) &&
        (r.getTargetList().size() == 1 && r.getTargetFirstRep().hasVariable() && (r.getTargetFirstRep().getTransform() == null || r.getTargetFirstRep().getTransform() == StructureMap.StructureMapTransform.CREATE) && r.getTargetFirstRep().getParameterList().size() == 0) &&
        (r.getDependentList().size() == 0 || (r.getDependentList().size() == 1 && DEF_GROUP_NAME.equals(r.getDependentFirstRep().getName()))) && (r.getRuleList().size() == 0);
  }

  public static String sourceToString(StructureMap.StructureMapGroupRuleSourceComponent r) {
    StringBuilder b = new StringBuilder();
    renderSource(b, r, false);
    return b.toString();
  }

  private static void renderSource(StringBuilder b, StructureMap.StructureMapGroupRuleSourceComponent rs, boolean abbreviate) {
    b.append(rs.getContext());
    if (rs.getContext().equals("@search")) {
      b.append('(');
      b.append(rs.getElementName());
      b.append(')');
    } else if (rs.hasElement()) {
      b.append('.');
      b.append(renderElementName(rs.getElementName()));
    }
    if (rs.hasType()) {
      b.append(" : ");
      b.append(rs.getType());
    }
    if (rs.hasMin()) {
      b.append(" ");
      b.append(rs.getMin());
      b.append("..");
      b.append(rs.getMax());
    }

    if (rs.hasListMode()) {
      b.append(" ");
      b.append(rs.getListMode().toCode());
    }
    if (rs.hasDefaultValue()) {
      b.append(" default (");
      b.append(rs.getDefaultValue());
      b.append(")");
    }
    if (!abbreviate && rs.hasVariable()) {
      b.append(" as ");
      b.append(rs.getVariable());
    }
    if (rs.hasCondition()) {
      b.append(" where (");
      b.append(rs.getCondition());
      b.append(")");
    }
    if (rs.hasCheck()) {
      b.append(" check (");
      b.append(rs.getCheck());
      b.append(")");
    }
    if (rs.hasLogMessage()) {
      b.append(" log (");
      b.append(rs.getLogMessage());
      b.append(")");
    }
  }

  public static String targetToString(StructureMap.StructureMapGroupRuleTargetComponent rt) {
    StringBuilder b = new StringBuilder();
    renderTarget(b, rt, false);
    return b.toString();
  }

  /** if the element name is NOT a valid token then it needs backticks */
  public static String renderElementName(String name) {
    // if the name isn't a simple identifier, then escaping is required (\w is `A-Za-z0-9_`)
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    // one anchored character class [A-Za-z_] followed by \w*, anchored at both ends with ^ and $
    boolean matches = name.matches("^[A-Za-z_]\\w*$");
    if (matches)
      return name;
    // Inside backticks the lexer treats \ as an escape and ` as the terminator,
    // so both must be escaped to round-trip through FHIRLexer.processConstant.
    return "`" + name.replace("\\", "\\\\").replace("`", "\\`") + "`";
  }

  private static void renderTarget(StringBuilder b, StructureMap.StructureMapGroupRuleTargetComponent rt, boolean abbreviate) {
    if (rt.hasContext()) {
      b.append(rt.getContext());
      if (rt.hasElement()) {
        b.append('.');
        b.append(renderElementName(rt.getElementName()));
      }
    }
    if (!abbreviate && rt.hasTransform()) {
      if (rt.hasContext())
        b.append(" = ");
      if (rt.getTransform() == StructureMap.StructureMapTransform.COPY && rt.getParameterList().size() == 1) {
        renderTransformParam(b, rt.getParameterList().get(0));
      } else if (rt.getTransform() == StructureMap.StructureMapTransform.EVALUATE && rt.getParameterList().size() == 1) {
        b.append("(");
        b.append(((StringType) rt.getParameterList().get(0).getValue()).asStringValue());
        b.append(")");
      } else if (rt.getTransform() == StructureMap.StructureMapTransform.EVALUATE && rt.getParameterList().size() == 2) {
        b.append(rt.getTransform().toCode());
        b.append("(");
        b.append(((IdType) rt.getParameterList().get(0).getValue()).asStringValue());
        b.append(", ");
        b.append(((StringType) rt.getParameterList().get(1).getValue()).asStringValue());
        b.append(")");
      } else {
        b.append(rt.getTransform().toCode());
        b.append("(");
        boolean first = true;
        for (StructureMap.StructureMapGroupRuleTargetParameterComponent rtp : rt.getParameterList()) {
          if (first)
            first = false;
          else
            b.append(", ");
          renderTransformParam(b, rtp);
        }
        b.append(")");
      }
    }
    if (!abbreviate && rt.hasVariable()) {
      b.append(" as ");
      b.append(rt.getVariable());
    }
    for (Enumeration<StructureMap.StructureMapTargetListMode> lm : rt.getListModeList()) {
      b.append(" ");
      b.append(lm.getValue().toCode());
      if (lm.getValue() == StructureMap.StructureMapTargetListMode.SHARE) {
        b.append(" ");
        b.append(rt.getListRuleId());
      }
    }
  }

  public static String paramToString(StructureMap.StructureMapGroupRuleTargetParameterComponent rtp) {
    StringBuilder b = new StringBuilder();
    renderTransformParam(b, rtp);
    return b.toString();
  }

  private static void renderTransformParam(StringBuilder b, StructureMap.StructureMapGroupRuleTargetParameterComponent rtp) {
    try {
      if (rtp.hasValueBooleanType())
        b.append(rtp.getValueBooleanType().asStringValue());
      else if (rtp.hasValueDecimalType())
        b.append(rtp.getValueDecimalType().asStringValue());
      else if (rtp.hasValueIdType())
        b.append(rtp.getValueIdType().asStringValue());
      else if (rtp.hasValueIntegerType())
        b.append(rtp.getValueIntegerType().asStringValue());
      else
        b.append("'" + Utilities.escapeFhirPathString(rtp.getValueStringType().asStringValue()) + "'");
    } catch (FHIRException e) {
      e.printStackTrace();
      b.append("error!");
    }
  }

  private static void renderDoco(StringBuilder b, String doco) {
    if (Utilities.noString(doco))
      return;
    if (b != null && b.length() > 1 && b.charAt(b.length() - 1) != '\n' && b.charAt(b.length() - 1) != ' ') {
      b.append(" ");
    }
    b.append("// ");
    b.append(doco.replace("\r\n", " ").replace("\r", " ").replace("\n", " "));
  }

  private static void renderMultilineDoco(StringBuilder b, String doco, int indent) {
    if (Utilities.noString(doco))
      return;
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //simple character class split; safe
    String[] lines = doco.split("\\r?\\n");
    for (String line : lines) {
      for (int i = 0; i < indent; i++)
        b.append(' ');
      renderDoco(b, line);
      b.append("\r\n");
    }
  }
  private static void renderMultilineDoco(StringBuilder b, List<String> doco, int indent) {
    if (doco == null || doco.isEmpty())
      return;
    for (String line : doco) {
      for (int i = 0; i < indent; i++)
        b.append(' ');
      renderDoco(b, line);
      b.append("\r\n");
    }
  }

}
