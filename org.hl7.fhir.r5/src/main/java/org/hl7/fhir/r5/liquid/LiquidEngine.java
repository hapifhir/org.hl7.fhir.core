package org.hl7.fhir.r5.liquid;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRLexer;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.ExpressionNodeWithOffset;
import org.hl7.fhir.r5.fhirpath.IHostApplicationServices;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.KeyIssuer;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;


@MarkedToMoveToAdjunctPackage
public class LiquidEngine implements IHostApplicationServices {

  public static class LiquidforloopObject extends Base {

    private static final long serialVersionUID = 6951452522873320076L;
    private boolean first;
    private int index;
    private int index0;
    private int rindex;
    private int rindex0;
    private boolean last;
    private int length;
    private LiquidforloopObject parentLoop;
    
    
    public LiquidforloopObject(int size, int i, int offset, int limit, LiquidforloopObject parentLoop) {
      super();
      this.parentLoop = parentLoop;
      if (offset == -1) {
        offset = 0;
      }
      if (limit == -1) {
        limit = size;
      }
      
      first = i == offset;
      index = i+1-offset;
      index0 = i-offset;
      rindex = (limit-offset) - 1 - i;
      rindex0 = (limit-offset) - i;
      length = limit-offset;
      last = i == (limit-offset)-1;
    }
    

    @Override
    public String getIdBase() {
      return null;
    }

    @Override
    public void setIdBase(String value) {
      throw new Error("forloop is read only");
    }

    @Override
    public Base copy() {
      throw new Error("forloop is read only");
    }

    @Override
    public FhirPublication getFHIRPublicationVersion() {
      return FhirPublication.R5;
    }

    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (name) {
      case "parentLoop" : return wrap(parentLoop);
      case "first" : return wrap(new BooleanType(first));
      case "last" : return wrap(new BooleanType(last));
      case "index" : return wrap(new IntegerType(index));
      case "index0" : return wrap(new IntegerType(index0));
      case "rindex" : return wrap(new IntegerType(rindex));
      case "rindex0" : return wrap(new IntegerType(rindex0));
      case "length" : return wrap(new IntegerType(length));
      }

      return super.getProperty(hash, name, checkValid);
    }

    private Base[] wrap(Base b) {
      Base[] l = new Base[1];
      l[0] = b;
      return l;
    }


    @Override
    public String toString() {
      return "forloop";
    }


    @Override
    public String fhirType() {
      return "forloop";
    }
    
  }

  public interface ILiquidRenderingSupport {
    String renderForLiquid(Object appContext, Base i) throws FHIRException;
  }

  public interface ILiquidEngineIncludeResolver {
    public String fetchInclude(LiquidEngine engine, String name);
  }

  private IHostApplicationServices externalHostServices;
  private FHIRPathEngine engine;
  private ILiquidEngineIncludeResolver includeResolver;
  private ILiquidRenderingSupport renderingSupport;
  private MarkDownProcessor processor = new MarkDownProcessor(Dialect.COMMON_MARK);
  private Map<String, List<Base>> vars = new HashMap<>();
  private KeyIssuer keyIssuer;
  
  private class LiquidEngineContext {
    private Object externalContext;
    private Map<String, Base> loopVars = new HashMap<>();
    private Map<String, List<Base>> globalVars = new HashMap<>();

    public LiquidEngineContext(Object externalContext, Map<String, List<Base>> vars) {
      super();
      this.externalContext = externalContext;
      globalVars = new HashMap<>();
      globalVars.putAll(vars);
    }

    public LiquidEngineContext(Object externalContext, LiquidEngineContext existing) {
      super();
      this.externalContext = externalContext;
      loopVars.putAll(existing.loopVars);
      globalVars = existing.globalVars;
    }

    public LiquidEngineContext(LiquidEngineContext existing) {
      super();
      externalContext = existing.externalContext;
      loopVars.putAll(existing.loopVars);
      globalVars = existing.globalVars;
    }
  }

  public LiquidEngine(IWorkerContext context, IHostApplicationServices hostServices) {
    super();
    this.externalHostServices = hostServices;
    engine = new FHIRPathEngine(context);
    engine.setHostServices(this);
    engine.setLiquidMode(true);
    engine.setCheckWithHostServicesBeforeHand(true);
  }

  public ILiquidEngineIncludeResolver getIncludeResolver() {
    return includeResolver;
  }

  public void setIncludeResolver(ILiquidEngineIncludeResolver includeResolver) {
    this.includeResolver = includeResolver;
  }

  public ILiquidRenderingSupport getRenderingSupport() {
    return renderingSupport;
  }

  public void setRenderingSupport(ILiquidRenderingSupport renderingSupport) {
    this.renderingSupport = renderingSupport;
  }

  public Map<String, List<Base>> getVars() {
    return vars;
  }

  public LiquidDocument parse(String source, String sourceName) throws FHIRException {
    return new LiquidParser(source).parse(sourceName);
  }

  public String evaluate(LiquidDocument document, Base resource, Object appContext) throws FHIRException {
    StringBuilder b = new StringBuilder();
    LiquidEngineContext ctxt = new LiquidEngineContext(appContext, vars );
    for (LiquidNode n : document.body) {
      b.append(singleString(n.evaluate(resource, ctxt)));
    }
    return b.toString();
  }
  
  private String singleString(List<String> t) throws FHIRException {
    if (t == null) {
      throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNKNOWN_SYNTAX));
    }
    if (t.size() == 0) {
      return "";
    } else if (t.size() == 1) {
      return t.get(0);
    } else {
      boolean first = false;
      StringBuilder b = new StringBuilder();
      for (String s : t) {
        if (first) {
          b.append(", ");
        }
        first = true;
        b.append(s);
      }
      return b.toString();
    }
  }
  

  private abstract class LiquidNode {
    protected void closeUp() {
    }

    public abstract List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException;
  }

  private class LiquidConstant extends LiquidNode {
    private String constant;
    private StringBuilder b = new StringBuilder();

    @Override
    protected void closeUp() {
      constant = b.toString();
      b = null;
    }

    public void addChar(char ch) {
      b.append(ch);
    }

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) {
      return List.of(constant);
    }

  }

  /*
   * Returns list:
   *  - compact, map, reverse, slice, sort, sort_natural, uniq, where
   */
  
  private enum LiquidFilter {
    // String filters
    APPEND,
    BASE64_DECODE,
    BASE64_ENCODE,
    CAPITALIZE,
    DOWNCASE,
    ESCAPE,
    ESCAPE_ONCE,
    LSTRIP,
    NEWLINE_TO_BR,
    PREPEND,
    REMOVE,
    REMOVE_FIRST,
    REMOVE_LAST,
    REPLACE,
    REPLACE_FIRST,
    REPLACE_LAST,
    RSTRIP,
    SLICE,
    SPLIT,
    STRIP,
    STRIP_HTML,
    STRIP_NEWLINES,
    TRUNCATE,
    TRUNCATEWORDS,
    UPCASE,
    URL_DECODE,
    URL_ENCODE,
    // Math filters
    ABS,
    AT_LEAST,
    AT_MOST,
    CEIL,
    DIVIDED_BY,
    FLOOR,
    MINUS,
    MODULO,
    PLUS,
    ROUND,
    TIMES,
    // Array filters
    COMPACT,
    CONCAT,
    FIRST,
    JOIN,
    LAST,
    MAP,
    REVERSE,
    SIZE,
    SORT,
    SORT_NATURAL,
    SUM,
    UNIQ,
    WHERE,
    // Date filter
    DATE,
    // Other filters
    DEFAULT,
    JSON,
    // Non-standard but supported
    MARKDOWNIFY,
    ;
    
    public static LiquidFilter fromCode(String code) {
      switch (code) {
      // String filters
      case "append": return APPEND;
      case "base64_decode": return BASE64_DECODE;
      case "base64_encode": return BASE64_ENCODE;
      case "capitalize": return CAPITALIZE;
      case "downcase": return DOWNCASE;
      case "escape": return ESCAPE;
      case "escape_once": return ESCAPE_ONCE;
      case "lstrip": return LSTRIP;
      case "newline_to_br": return NEWLINE_TO_BR;
      case "prepend": return PREPEND;
      case "remove": return REMOVE;
      case "remove_first": return REMOVE_FIRST;
      case "remove_last": return REMOVE_LAST;
      case "replace": return REPLACE;
      case "replace_first": return REPLACE_FIRST;
      case "replace_last": return REPLACE_LAST;
      case "rstrip": return RSTRIP;
      case "slice": return SLICE;
      case "split": return SPLIT;
      case "strip": return STRIP;
      case "strip_html": return STRIP_HTML;
      case "strip_newlines": return STRIP_NEWLINES;
      case "truncate": return TRUNCATE;
      case "truncatewords": return TRUNCATEWORDS;
      case "upcase": return UPCASE;
      case "url_decode": return URL_DECODE;
      case "url_encode": return URL_ENCODE;
      // Math filters
      case "abs": return ABS;
      case "at_least": return AT_LEAST;
      case "at_most": return AT_MOST;
      case "ceil": return CEIL;
      case "divided_by": return DIVIDED_BY;
      case "floor": return FLOOR;
      case "minus": return MINUS;
      case "modulo": return MODULO;
      case "plus": return PLUS;
      case "round": return ROUND;
      case "times": return TIMES;
      // Array filters
      case "compact": return COMPACT;
      case "concat": return CONCAT;
      case "first": return FIRST;
      case "join": return JOIN;
      case "last": return LAST;
      case "map": return MAP;
      case "reverse": return REVERSE;
      case "size": return SIZE;
      case "sort": return SORT;
      case "sort_natural": return SORT_NATURAL;
      case "sum": return SUM;
      case "uniq": return UNIQ;
      case "where": return WHERE;
      // Date filter
      case "date": return DATE;
      // Other filters
      case "default": return DEFAULT;
      case "json": return JSON;
      // Non-standard but supported
      case "markdownify": return MARKDOWNIFY;
      default: return null;
      }
    }
  }

  private class LiquidExpressionNode {
    private LiquidFilter filter; // null at root
    private ExpressionNode expression; // null for some filters
    private ExpressionNode expression2; // null for some filters
    public LiquidExpressionNode(LiquidFilter filter, ExpressionNode expression) {
      super();
      this.filter = filter;
      this.expression = expression;
    }
    public LiquidExpressionNode(LiquidFilter filter, ExpressionNode expression, ExpressionNode expression2) {
      super();
      this.filter = filter;
      this.expression = expression;
      this.expression2 = expression2;
    }
    
  }
  
  private class LiquidStatement extends LiquidNode {
    private String statement;
    private List<LiquidExpressionNode> compiled = new ArrayList<>();

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      if (compiled.size() == 0) {
        FHIRLexer lexer = new FHIRLexer(statement, "liquid statement", false, true);
        lexer.setLiquidMode(true);
        try {
          compiled.add(new LiquidExpressionNode(null, engine.parse(lexer)));
        } catch (Exception e) {
          throw lexer.error(engine.getWorker().formatMessage(I18nConstants.LIQUID_STATEMENT_ERROR, statement, e.getMessage()));
        }
        while (!lexer.done()) {
          if (lexer.getCurrent().equals("||")) {
            lexer.next();
            String f = lexer.getCurrent();
            LiquidFilter filter = LiquidFilter.fromCode(f);
            if (filter == null) {
              throw lexer.error(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNKNOWN_FILTER, f));
            }
            lexer.next();
            if (!lexer.done() && lexer.getCurrent().equals(":")) {
              lexer.next();
              ExpressionNodeWithOffset po = engine.parsePartialExpression(lexer);
              ExpressionNode ex1 = po.getNode();
              if (!lexer.done() && lexer.getCurrent().equals(",")) {
                lexer.next();
                ExpressionNodeWithOffset po2 = engine.parsePartialExpression(lexer);
                ExpressionNode ex2 = po2.getNode();
                compiled.add(new LiquidExpressionNode(filter, ex1, ex2));
              } else {
                compiled.add(new LiquidExpressionNode(filter, ex1));
              }
            } else {
              compiled.add(new LiquidExpressionNode(filter, null));
            }
          } else {
            throw lexer.error(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNKNOWN_SYNTAX));
          }
        }
      }
      
      List<String> t = null;
      for (LiquidExpressionNode i : compiled) {
        if (i.filter == null) { // first
          t = liquify(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
        } else switch (i.filter) {

        // ── String filters ──────────────────────────────────────────────

        case APPEND:
          t = List.of(singleString(t) + liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          break;
        case BASE64_DECODE:
          t = List.of(new String(java.util.Base64.getDecoder().decode(singleString(t)), java.nio.charset.StandardCharsets.UTF_8));
          break;
        case PREPEND:
          t = List.of(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)) + singleString(t));
          break; 
        case MARKDOWNIFY:
          t = List.of(processMarkdown(singleString(t)));
          break;
        case UPCASE:
          t = List.of(singleString(t).toUpperCase());
          break;
        case BASE64_ENCODE:
          t = List.of(java.util.Base64.getEncoder().encodeToString(singleString(t).getBytes(java.nio.charset.StandardCharsets.UTF_8)));
          break;
        case CAPITALIZE: {
          String s = singleString(t);
          t = !s.isEmpty() ? List.of(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()) : List.of(s);
          break;
        }
        case DOWNCASE:
          t = List.of(singleString(t).toLowerCase());
          break;
        case ESCAPE:
          t = List.of(singleString(t)
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;"));
          break;
        case ESCAPE_ONCE: {
          // Unescape first, then escape — so already-escaped entities aren't double-escaped
          String s = singleString(t)
            .replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">")
            .replace("&quot;", "\"").replace("&#39;", "'");
          t = List.of(s
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;"));
          break;
        }
        case LSTRIP:
          t = List.of(singleString(t).stripLeading());
          break;
        case NEWLINE_TO_BR:
          t = List.of(singleString(t).replace("\r\n", "<br />\r\n").replace("\n", "<br />\n"));
          break;
        case REMOVE:
          t = List.of(singleString(t).replace(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)), ""));
          break;
        case REMOVE_FIRST: {
          @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
          //Regex sourced from Liquid expression parameter; user-supplied at runtime, Pattern.quote() applied
          String removeFirstResult = singleString(t).replaceFirst(Pattern.quote(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression))), "");
          t = List.of(removeFirstResult);
          break;
        }
        case REMOVE_LAST: {
          String target = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          String s = singleString(t);
          int p = s.lastIndexOf(target);
          if (p != -1) {
            t = List.of(s.substring(0, p) + s.substring(p + target.length()));
          }
          break;
        }
        case REPLACE:
          t = List.of(singleString(t).replace(
            liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)),
            liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression2))));
          break;
        case REPLACE_FIRST: {
          String target = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          String replacement = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression2));
          String s = singleString(t);
          int p = s.indexOf(target);
          if (p != -1) {
            t = List.of(s.substring(0, p) + replacement + s.substring(p + target.length()));
          }
          break;
        }
        case REPLACE_LAST: {
          String target = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          String replacement = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression2));
          String s = singleString(t);
          int p = s.lastIndexOf(target);
          if (p != -1) {
            t = List.of(s.substring(0, p) + replacement + s.substring(p + target.length()));
          }
          break;
        }
        case RSTRIP:
          t = List.of(singleString(t).stripTrailing());
          break;
        case SLICE: {
          String s = singleString(t);
          int offset = Integer.parseInt(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          int length = i.expression2 != null
            ? Integer.parseInt(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression2)))
            : 1;
          if (offset < 0) {
            offset = s.length() + offset;
          }
          if (offset < 0) {
            offset = 0;
          }
          int end = Math.min(offset + length, s.length());
          t = offset < s.length() ? List.of(s.substring(offset, end)) : List.of("");
          break;
        }
        case SPLIT: {
          @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
          //Regex sourced from Liquid expression parameter; user-supplied at runtime, Pattern.quote() applied
          List<String> splitResult = new ArrayList<>(Arrays.asList(singleString(t).split(
            Pattern.quote(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression))))));
          t = splitResult;
          break;
        }
        case STRIP:
          t = List.of(singleString(t).strip());
          break;
        case STRIP_HTML: {
          @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
          //simple character class match; safe
          String stripped = singleString(t).replaceAll("<[^>]*>", "");
          t = List.of(stripped);
          break;
        }
        case STRIP_NEWLINES:
          t = List.of(singleString(t).replace("\r\n", "").replace("\n", "").replace("\r", ""));
          break;
        case TRUNCATE: {
          int len = Integer.parseInt(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          String ellipsis = i.expression2 != null
            ? liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression2))
            : "...";
          String s = singleString(t);
          if (s.length() > len) {
            int end = Math.max(len - ellipsis.length(), 0);
            t = List.of(s.substring(0, end) + ellipsis);
          }
          break;
        }
        case TRUNCATEWORDS: {
          int words = Integer.parseInt(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          String ellipsis = i.expression2 != null
            ? liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression2))
            : "...";
          @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
          //simple character class split; safe
          String[] parts = singleString(t).split("\\s+");
          if (parts.length > words) {
            StringBuilder sb = new StringBuilder();
            for (int w = 0; w < words; w++) {
              if (w > 0) sb.append(" ");
              sb.append(parts[w]);
            }
            sb.append(ellipsis);
            t = List.of(sb.toString());
          }
          break;
        }
        case URL_DECODE:
          t = List.of(java.net.URLDecoder.decode(singleString(t), java.nio.charset.StandardCharsets.UTF_8));
          break;
        case URL_ENCODE:
          t = List.of(java.net.URLEncoder.encode(singleString(t), java.nio.charset.StandardCharsets.UTF_8));
          break;

        // ── Math filters ────────────────────────────────────────────────

        case ABS: {
          double v = toDouble(singleString(t));
          t = List.of(formatNumber(Math.abs(v), singleString(t)));
          break;
        }
        case AT_LEAST: {
          double v = toDouble(singleString(t));
          double min = toDouble(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          t = List.of(formatNumber(Math.max(v, min), singleString(t)));
          break;
        }
        case AT_MOST: {
          double v = toDouble(singleString(t));
          double max = toDouble(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          t = List.of(formatNumber(Math.min(v, max), singleString(t)));
          break;
        }
        case CEIL: {
          double v = toDouble(singleString(t));
          t = List.of(String.valueOf((long) Math.ceil(v)));
          break;
        }
        case DIVIDED_BY: {
          String raw = singleString(t);
          String argRaw = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          if (isLong(raw) && isLong(argRaw)) {
            long a = Long.parseLong(raw.trim());
            long denominator = Long.parseLong(argRaw.trim());
            if (denominator == 0) {
              throw new FHIRException(new ArithmeticException("/ by zero"));
            }
            t = List.of(String.valueOf(a / denominator));
          } else {
            double denominator = toDouble(argRaw);
            if (denominator == 0) {
              throw new FHIRException(new ArithmeticException("/ by zero"));
            }
            t = List.of(formatNumber(toDouble(raw) / denominator, raw));
          }
          break;
        }
        case FLOOR: {
          double v = toDouble(singleString(t));
          t = List.of(String.valueOf((long) Math.floor(v)));
          break;
        }
        case MINUS: {
          String raw = singleString(t);
          String argRaw = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          if (isLong(raw) && isLong(argRaw)) {
            t = List.of(String.valueOf(Long.parseLong(raw.trim()) - Long.parseLong(argRaw.trim())));
          } else {
            t = List.of(formatNumber(toDouble(raw) - toDouble(argRaw), raw));
          }
          break;
        }
        case MODULO: {
          String raw = singleString(t);
          String argRaw = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          if (isLong(raw) && isLong(argRaw)) {
            long denominator = Long.parseLong(argRaw.trim());
            if (denominator == 0) {
              throw new FHIRException(new ArithmeticException("/ by zero"));
            }
            t = List.of(String.valueOf(Long.parseLong(raw.trim()) % denominator));
          } else {
            double denominator = toDouble(argRaw);
            if (denominator == 0) {
              throw new FHIRException(new ArithmeticException("/ by zero"));
            }
            t = List.of(formatNumber(toDouble(raw) % denominator, raw));
          }
          break;
        }
        case PLUS: {
          String raw = singleString(t);
          String argRaw = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          if (isLong(raw) && isLong(argRaw)) {
            t = List.of(String.valueOf(Long.parseLong(raw.trim()) + Long.parseLong(argRaw.trim())));
          } else {
            t = List.of(formatNumber(toDouble(raw) + toDouble(argRaw), raw));
          }
          break;
        }
        case ROUND: {
          double v = toDouble(singleString(t));
          if (i.expression != null) {
            int places = Integer.parseInt(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
            double factor = Math.pow(10, places);
            t = List.of(String.valueOf(Math.round(v * factor) / factor));
          } else {
            t = List.of(String.valueOf(Math.round(v)));
          }
          break;
        }
        case TIMES: {
          String raw = singleString(t);
          String argRaw = liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          if (isLong(raw) && isLong(argRaw)) {
            t = List.of(String.valueOf(Long.parseLong(raw.trim()) * Long.parseLong(argRaw.trim())));
          } else {
            t = List.of(formatNumber(toDouble(raw) * toDouble(argRaw), raw));
          }
          break;
        }

        // ── Array filters ───────────────────────────────────────────────

        case COMPACT:
          t = new ArrayList<>(t);
          t.removeIf(item -> item == null || item.isEmpty());
          break;
        case CONCAT: {
          List<String> other = liquify(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
          List<String> merged = new ArrayList<>(t);
          merged.addAll(other);
          t = merged;
          break;
        }
        case FIRST:
          t = t.isEmpty() ? List.of("") : List.of(t.get(0));
          break;
        case JOIN:
          t = List.of(String.join(
            liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)), t));
          break;
        case LAST:
          t = t.isEmpty() ? List.of("") : List.of(t.get(t.size() - 1));
          break;
        case MAP:
          // map is complex (requires property access on objects); not feasible with string-only pipeline
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_FILTER_NOT_SUPPORTED, "map"));
        case REVERSE: {
          List<String> rev = new ArrayList<>(t);
          Collections.reverse(rev);
          t = rev;
          break;
        }
        case SIZE:
          t = List.of(String.valueOf(t.size() == 1 ? singleString(t).length() : t.size()));
          break;
        case SORT: {
          List<String> sorted = new ArrayList<>(t);
          Collections.sort(sorted);
          t = sorted;
          break;
        }
        case SORT_NATURAL: {
          List<String> sorted = new ArrayList<>(t);
          sorted.sort(String.CASE_INSENSITIVE_ORDER);
          t = sorted;
          break;
        }
        case SUM: {
          double sum = 0;
          for (String item : t) {
            try {
              sum += Double.parseDouble(item.trim());
            } catch (NumberFormatException e) {
              // non-numeric items treated as 0
            }
          }
          t = List.of(formatNumber(sum, "0"));
          break;
        }
        case UNIQ: {
          List<String> unique = new ArrayList<>();
          for (String item : t) {
            if (!unique.contains(item)) {
              unique.add(item);
            }
          }
          t = unique;
          break;
        }
        case WHERE:
          // where requires property access on objects; not feasible with string-only pipeline
          //
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_FILTER_NOT_SUPPORTED, "where"));

        // ── Date filter ─────────────────────────────────────────────────

        case DATE: {
          String fmt = rubyToJavaDateFormat(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          ZonedDateTime dt = parseArbitraryDateTime(singleString(t));
          try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fmt);
            t = List.of(dt.format(formatter));
          } catch (Exception e) {
            throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_BAD_DATE_FORMAT, fmt));
          }
          break;
        }

        // ── Other filters ───────────────────────────────────────────────

        case DEFAULT: {
          String s = singleString(t);
          if (s == null || s.isEmpty()) {
            t = List.of(liquifySingle(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)));
          }
          break;
        }
        case JSON:
          // Simple JSON serialization: quote and escape the string value
          t = List.of(jsonEscape(singleString(t)));
          break;
      }
      }
      return t;
    }

    private double toDouble(String s) {
      try {
        return Double.parseDouble(s.trim());
      } catch (NumberFormatException e) {
        return 0;
      }
    }

    private boolean isLong(String s) {
      if (s == null) {
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNKNOWN_SYNTAX));
      }

     try {
        Long.parseLong(s.trim());
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    }

    private String formatNumber(double v, String hint) {
      if (v == Math.floor(v) && !Double.isInfinite(v)) {
        return String.valueOf((long) v);
      }
      return String.valueOf(v);
    }

    private String jsonEscape(String s) {
      StringBuilder sb = new StringBuilder("\"");
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        switch (c) {
        case '"': sb.append("\\\""); break;
        case '\\': sb.append("\\\\"); break;
        case '\n': sb.append("\\n"); break;
        case '\r': sb.append("\\r"); break;
        case '\t': sb.append("\\t"); break;
        default:
          if (c < 0x20) {
            sb.append(String.format("\\u%04x", (int) c));
          } else {
            sb.append(c);
          }
        }
      }
      sb.append("\"");
      return sb.toString();
    }

    private String rubyToJavaDateFormat(String rubyFormat) {
      if (rubyFormat == null) {
        return null;
      }
      StringBuilder sb = new StringBuilder();
      int i = 0;
      while (i < rubyFormat.length()) {
        char c = rubyFormat.charAt(i);
        if (c == '%' && i + 1 < rubyFormat.length()) {
          i++;
          char directive = rubyFormat.charAt(i);
          switch (directive) {
          // Date directives
          case 'Y': sb.append("yyyy"); break;   // 4-digit year
          case 'C': sb.append("yy"); break;      // century (year / 100) — approximate with 2-digit year
          case 'y': sb.append("yy"); break;       // 2-digit year
          case 'm': sb.append("MM"); break;       // zero-padded month (01..12)
          case 'B': sb.append("MMMM"); break;     // full month name
          case 'b': sb.append("MMM"); break;       // abbreviated month name
          case 'h': sb.append("MMM"); break;       // same as %b
          case 'd': sb.append("dd"); break;        // zero-padded day of month (01..31)
          case 'e': sb.append("d"); break;         // day of month, space-padded ( 1..31) — Java 'd' is unpadded
          case 'j': sb.append("DDD"); break;       // day of year (001..366)
          // Time directives
          case 'H': sb.append("HH"); break;       // 24-hour zero-padded (00..23)
          case 'k': sb.append("H"); break;         // 24-hour space-padded ( 0..23) — Java 'H' is unpadded
          case 'I': sb.append("hh"); break;        // 12-hour zero-padded (01..12)
          case 'l': sb.append("h"); break;         // 12-hour space-padded ( 1..12) — Java 'h' is unpadded
          case 'P': sb.append("a"); break;         // am/pm lowercase
          case 'p': sb.append("a"); break;         // AM/PM (Java 'a' outputs AM/PM by default)
          case 'M': sb.append("mm"); break;        // minute (00..59)
          case 'S': sb.append("ss"); break;        // second (00..59)
          case 'L': sb.append("SSS"); break;       // millisecond (000..999)
          case 'N': sb.append("nnnnnnnnn"); break; // nanosecond (000000000..999999999)
          // Time zone directives
          case 'z': sb.append("Z"); break;         // +hhmm offset
          case 'Z': sb.append("z"); break;         // time zone abbreviation
          case ':':
            // Handle %:z, %::z, %:::z
            if (i + 1 < rubyFormat.length() && rubyFormat.charAt(i + 1) == 'z') {
              sb.append("XXX"); // +hh:mm
              i++;
            } else if (i + 2 < rubyFormat.length() && rubyFormat.charAt(i + 1) == ':' && rubyFormat.charAt(i + 2) == 'z') {
              sb.append("XXX':00'"); // +hh:mm:ss — approximate
              i += 2;
            } else {
              sb.append(':');
            }
            break;
          // Week / day-of-week directives
          case 'A': sb.append("EEEE"); break;     // full weekday name
          case 'a': sb.append("EEE"); break;       // abbreviated weekday name
          case 'u': sb.append("e"); break;         // day of week (Monday=1..Sunday=7)
          case 'w': sb.append("e"); break;         // day of week (Sunday=0..Saturday=6) — approximate
          case 'U': sb.append("ww"); break;        // week number (Sunday as first day) — approximate with ISO week
          case 'W': sb.append("ww"); break;        // week number (Monday as first day)
          // Epoch
          case 's': sb.append("'epoch'"); break;   // seconds since epoch — not directly supported
          // Literal percent
          case '%': sb.append('%'); break;
          // Shorthand combinations
          case 'c': sb.append("EEE MMM d HH:mm:ss yyyy"); break;  // date and time
          case 'D': sb.append("MM/dd/yy"); break;                  // %m/%d/%y
          case 'F': sb.append("yyyy-MM-dd"); break;                // %Y-%m-%d (ISO 8601 date)
          case 'v': sb.append("d-MMM-yyyy"); break;                // %e-%b-%Y
          case 'x': sb.append("MM/dd/yy"); break;                  // same as %D
          case 'X': sb.append("HH:mm:ss"); break;                  // same as %T
          case 'r': sb.append("hh:mm:ss a"); break;                // %I:%M:%S %p (12-hour time)
          case 'R': sb.append("HH:mm"); break;                     // %H:%M
          case 'T': sb.append("HH:mm:ss"); break;                  // %H:%M:%S
          // Flags: -, _, 0, ^ — strip and ignore
          case '-':
          case '_':
          case '0':
          case '^':
          case '#':
            // These are Ruby format flags that modify the next directive.
            // Skip the flag and let the next iteration handle the directive.
            // We don't re-increment i, so the next char will be processed in the next loop iteration as if after '%'.
            // To handle this, we need to peek at the next character and treat it as the directive.
            if (i + 1 < rubyFormat.length()) {
              i++;
              char next = rubyFormat.charAt(i);
              // Recurse through the switch for the actual directive by re-processing
              // For simplicity, we just call the same logic:
              sb.append(rubyDirectiveToJava(next));
            }
            break;
          default:
            // Unknown directive — pass through as literal
            sb.append("'%").append(directive).append("'");
            break;
          }
        } else if (c == '\'') {
          sb.append("''"); // escape single quote for DateTimeFormatter
        } else if (Character.isLetter(c)) {
          sb.append('\'').append(c).append('\''); // quote literal letters so they aren't interpreted as patterns
        } else {
          sb.append(c);
        }
        i++;
      }
      return sb.toString();
    }

    private String rubyDirectiveToJava(char directive) {
      switch (directive) {
      case 'Y': return "yyyy";
      case 'y': return "yy";
      case 'm': return "MM";
      case 'B': return "MMMM";
      case 'b': return "MMM";
      case 'h': return "MMM";
      case 'd': return "dd";
      case 'e': return "d";
      case 'j': return "DDD";
      case 'H': return "HH";
      case 'k': return "H";
      case 'I': return "hh";
      case 'l': return "h";
      case 'P': return "a";
      case 'p': return "a";
      case 'M': return "mm";
      case 'S': return "ss";
      case 'L': return "SSS";
      case 'N': return "nnnnnnnnn";
      case 'z': return "Z";
      case 'Z': return "z";
      case 'A': return "EEEE";
      case 'a': return "EEE";
      case 'u': return "e";
      case 'w': return "e";
      case 'F': return "yyyy-MM-dd";
      case 'T': return "HH:mm:ss";
      case 'R': return "HH:mm";
      case 'r': return "hh:mm:ss a";
      case '%': return "%";
      default: return "'%" + directive + "'";
      }
    }

    private ZonedDateTime parseArbitraryDateTime(String dateTimeString) throws FHIRException {
      String s = dateTimeString == null ? "" : dateTimeString.trim();

      if (s.isEmpty()) {
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNABLE_TO_PARSE_DATETIME, dateTimeString));
      }

      ZoneId localZone = ZoneId.systemDefault();

      // Epoch handling: seconds (10 digits) or milliseconds (13 digits)
      try {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //anchored, fixed-width, safe
        boolean isEpochMillis = s.matches("^-?\\d{13}$");
        if (isEpochMillis) {
          long ms = Long.parseLong(s);
          return ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(ms), localZone);
        }
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //anchored, fixed-width, safe
        boolean isEpochSeconds = s.matches("^-?\\d{10}$");
        if (isEpochSeconds) {
          long sec = Long.parseLong(s);
          return ZonedDateTime.ofInstant(java.time.Instant.ofEpochSecond(sec), localZone);
        }
      } catch (Exception e) {
        // fall through
      }

      // ISO strings with explicit offset/zone
      try {
        return java.time.ZonedDateTime.parse(s);
      } catch (Exception e) {
        // fall through
      }
      try {
        return java.time.OffsetDateTime.parse(s).toZonedDateTime();
      } catch (Exception e) {
        // fall through
      }
      try {
        return java.time.Instant.parse(s).atZone(localZone);
      } catch (Exception e) {
        // fall through
      }

      // ISO local date-time (no zone): assume local timezone
      try {
        return LocalDateTime.parse(s).atZone(localZone);
      } catch (Exception e) {
        // fall through
      }

      // XSD dateTime with optional fractional seconds and optional offset
      try {
        DateTimeFormatter xsdFormatter = new java.time.format.DateTimeFormatterBuilder()
          .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
          .optionalStart().appendFraction(java.time.temporal.ChronoField.NANO_OF_SECOND, 0, 9, true).optionalEnd()
          .optionalStart().appendOffsetId().optionalEnd()
          .toFormatter();
        java.time.temporal.TemporalAccessor parsed = xsdFormatter.parseBest(s, java.time.OffsetDateTime::from, LocalDateTime::from);
        if (parsed instanceof java.time.OffsetDateTime) {
          return ((java.time.OffsetDateTime) parsed).toZonedDateTime();
        }
        return ((LocalDateTime) parsed).atZone(localZone);
      } catch (Exception e) {
        // fall through
      }

      // XSD partial date types: gYear (yyyy), gYearMonth (yyyy-MM), date (yyyy-MM-dd)
      try {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //fixed-width, safe
        boolean isGYear = s.matches("-?\\d{4}");
        if (isGYear) {
          return LocalDateTime.of(Integer.parseInt(s), 1, 1, 0, 0).atZone(localZone);
        }
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //fixed-width, safe
        boolean isGYearMonth = s.matches("-?\\d{4}-\\d{2}");
        if (isGYearMonth) {
          return java.time.YearMonth.parse(s).atDay(1).atStartOfDay(localZone);
        }
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //fixed-width, safe
        boolean isDate = s.matches("-?\\d{4}-\\d{2}-\\d{2}");
        if (isDate) {
          return java.time.LocalDate.parse(s).atStartOfDay(localZone);
        }
      } catch (Exception e) {
        // fall through
      }

      // Try common patterns (lenient single/double digit month and day variants)
      DateTimeFormatter[] formatters = {
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
        DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss"),
        DateTimeFormatter.ofPattern("M-d-yyyy HH:mm:ss"),
        DateTimeFormatter.ofPattern("M/d/yyyy"),
        DateTimeFormatter.ofPattern("M-d-yyyy"),
        DateTimeFormatter.ofPattern("M/d/yy"),
        DateTimeFormatter.ofPattern("M-d-yy"),
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("d-M-yyyy"),
        DateTimeFormatter.ofPattern("d/M/yy"),
        DateTimeFormatter.ofPattern("d-M-yy"),
        DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy", java.util.Locale.ENGLISH),
        DateTimeFormatter.ofPattern("MMMM d, yyyy", java.util.Locale.ENGLISH),
        DateTimeFormatter.ofPattern("MMM d, yyyy", java.util.Locale.ENGLISH),
      };
      for (DateTimeFormatter fmt : formatters) {
        try {
          return java.time.OffsetDateTime.parse(s, fmt).toZonedDateTime();
        } catch (Exception e) {
          // try next
        }
        try {
          return LocalDateTime.parse(s, fmt).atZone(localZone);
        } catch (Exception e) {
          // try next
        }
        try {
          return java.time.LocalDate.parse(s, fmt).atStartOfDay(localZone);
        } catch (Exception e) {
          // try next
        }
      }

      throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNABLE_TO_PARSE_DATETIME, dateTimeString));
    }

    private String processMarkdown(String t) {
      return processor.process(t, "liquid");
    }

    private String liquifySingle(LiquidEngineContext ctxt, List<Base> items) throws FHIRException {
      return singleString(liquify(ctxt, items));
    }
    
    
    private List<String> liquify(LiquidEngineContext ctxt, List<Base> items) {
      List<String> l = new ArrayList<>();
      for (Base i : items) {
        if (i != null) {
          if (i instanceof StringType)
            l.add(i.primitiveValue());
          else {
            String s = renderingSupport != null ? renderingSupport.renderForLiquid(ctxt.externalContext, i) : null;
            l.add(s != null ? s : engine.convertToString(i));
          }
        }
      }
      return l;
    }
  }

  private class LiquidElsIf extends LiquidNode {
    private String condition;
    private ExpressionNode compiled;
    private List<LiquidNode> body = new ArrayList<>();

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      StringBuilder b = new StringBuilder();
      for (LiquidNode n : body) {
        b.append(singleString(n.evaluate(resource, ctxt)));
      }
      return List.of(b.toString());
    }
  }

  private class LiquidIf extends LiquidNode {
    private String condition;
    private ExpressionNode compiled;
    private List<LiquidNode> thenBody = new ArrayList<>();
    private List<LiquidElsIf> elseIf = new ArrayList<>();
    private List<LiquidNode> elseBody = new ArrayList<>();

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      if (compiled == null)
        compiled = engine.parse(condition);
      boolean ok = engine.evaluateToBoolean(ctxt, resource, resource, resource, compiled);
      List<LiquidNode> list = null;
      if (ok) {
        list = thenBody;

      } else {
        list = elseBody;
        for (LiquidElsIf i : elseIf) {
          if (i.compiled == null)
            i.compiled = engine.parse(i.condition);
          ok = engine.evaluateToBoolean(ctxt, resource, resource, resource, i.compiled);
          if (ok) {
            list = i.body;
            break;
          }
        }
      }
      StringBuilder b = new StringBuilder();
      for (LiquidNode n : list) {
        b.append(singleString(n.evaluate(resource, ctxt)));
      }
      return List.of(b.toString());
    }
  }

  private class LiquidContinueExecuted extends FHIRException {
    private static final long serialVersionUID = 4748737094188943721L;
  }

  private class LiquidContinue extends LiquidNode {
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      throw new LiquidContinueExecuted();
    }
  }

  private class LiquidBreakExecuted extends FHIRException {
    private static final long serialVersionUID = 6328496371172871082L;
  }

  private class LiquidBreak extends LiquidNode {
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      throw new LiquidBreakExecuted();
    }
  }

  private class LiquidCycle extends LiquidNode {
    private List<String> list = new ArrayList<>();
    private int cursor = 0;

    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      String s = list.get(cursor);
      cursor++;
      if (cursor == list.size()) {
        cursor = 0;
      }
      return List.of(s);
    }
  }

  private class LiquidAssign extends LiquidNode {
    private String varName;
    private LiquidStatement value;
    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      List<String> result = value.evaluate(resource, ctxt);
      List<Base> list = new ArrayList<>();
      for (String s : result) {
        list.add(new StringType(s));
      }

      if (list.isEmpty()) {
        ctxt.globalVars.remove(varName);
      } else {
        ctxt.globalVars.put(varName, list);
      }      
      return new ArrayList<String>();
    }
  }
  
  private class LiquidFor extends LiquidNode {
    private String varName;
    private String condition;
    private ExpressionNode compiled;
    private boolean reversed = false;
    private int limit = -1;
    private int offset = -1;
    private List<LiquidNode> body = new ArrayList<>();
    private List<LiquidNode> elseBody = new ArrayList<>();

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      if (compiled == null) {
        ExpressionNodeWithOffset po = engine.parsePartial(condition, 0);
        compiled = po.getNode();
        if (po.getOffset() < condition.length()) {
          parseModifiers(condition.substring(po.getOffset()));
        }
      }
      
      List<Base> list = engine.evaluate(ctxt, resource, resource, resource, compiled);
      
      LiquidEngineContext lctxt = new LiquidEngineContext(ctxt);
      StringBuilder b = new StringBuilder();
      if (list.isEmpty()) {
        for (LiquidNode n : elseBody) {
          b.append(singleString(n.evaluate(resource, lctxt)));
        }
      } else {
        if (reversed) {
          Collections.reverse(list);
        }
        int i = 0;
        LiquidforloopObject parentLoop = (LiquidforloopObject) (lctxt.globalVars.containsKey("forloop") ? lctxt.globalVars.get("forloop").get(0) : null);
        for (Base o : list) {
          if (offset >= 0 && i < offset) {
            i++;
            continue;
          }
          if (limit >= 0 && i == limit) {
            break;
          }          
          LiquidforloopObject forloop = new LiquidforloopObject(list.size(), i, offset, limit, parentLoop);
          lctxt.globalVars.put("forloop", List.of(forloop));
          lctxt.globalVars.remove(varName);
          lctxt.loopVars.put(varName, o);
          boolean wantBreak = false;
          for (LiquidNode n : body) {
            try {
              b.append(singleString(n.evaluate(resource, lctxt)));
            } catch (LiquidContinueExecuted e) {
              break;
            } catch (LiquidBreakExecuted e) {
              wantBreak = true;
              break;
            }
          }
          if (wantBreak) {
            break;
          }
          i++;
        }
        if (parentLoop != null) {
          lctxt.globalVars.put("forloop", List.of(parentLoop));
        } else {
          lctxt.globalVars.remove("forloop");
        }
      }
      return List.of(b.toString());
    }

    private void parseModifiers(String cnt) {
      String src = cnt;
      while (!Utilities.noString(cnt)) {
        if (cnt.startsWith("reversed")) {
          reversed = true;
          cnt = cnt.substring(8);
        } else if (cnt.startsWith("limit")) {
          cnt = cnt.substring(5).trim();
          if (!cnt.startsWith(":")) {
            throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_COLON, src));
          }
          cnt = cnt.substring(1).trim();
          int i = 0;
          while (i < cnt.length() && Character.isDigit(cnt.charAt(i))) {
            i++;
          }
          if (i == 0) {
            throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_NUMBER, src));
          }
          limit = Integer.parseInt(cnt.substring(0, i));
          cnt = cnt.substring(i);
        } else if (cnt.startsWith("offset")) {
          cnt = cnt.substring(6).trim();
          if (!cnt.startsWith(":")) {
            throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_COLON, src));
          }
          cnt = cnt.substring(1).trim();
          int i = 0;
          while (i < cnt.length() && Character.isDigit(cnt.charAt(i))) {
            i++;
          }
          if (i == 0) {
            throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_NUMBER, src));
          }
          offset = Integer.parseInt(cnt.substring(0, i));
          cnt = cnt.substring(i);
        } else {
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_UNEXPECTED, cnt));
        }
      }      
    }   
  }

  private class LiquidCapture extends LiquidNode {
    private String varName;
    private List<LiquidNode> body = new ArrayList<>();

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      StringBuilder bc = new StringBuilder();
      for (LiquidNode n : body) {
        bc.append(singleString(n.evaluate(resource, ctxt)));
      }
      ctxt.globalVars.put(varName, List.of(new StringType(bc.toString())));
      return new ArrayList<String>();
    }
  }

  private class LiquidInclude extends LiquidNode {
    private String page;
    private Map<String, ExpressionNode> params = new HashMap<>();

    @Override
    public List<String> evaluate(Base resource, LiquidEngineContext ctxt) throws FHIRException {
      if (includeResolver == null) {
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_INCLUDE_NOT_SUPPORTED));
      }
      String src = includeResolver.fetchInclude(LiquidEngine.this, page);
      if (src == null) {
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_INCLUDE_NOT_RESOLVED, page));
      }
      LiquidParser parser = new LiquidParser(src);
      LiquidDocument doc = parser.parse(page);
      LiquidEngineContext nctxt = new LiquidEngineContext(ctxt.externalContext, ctxt);
      Tuple incl = new Tuple();
      nctxt.loopVars.put("include", incl);
      for (String s : params.keySet()) {
        incl.addProperty(s, engine.evaluate(ctxt, resource, resource, resource, params.get(s)));
      }
      StringBuilder b = new StringBuilder();
      for (LiquidNode n : doc.body) {
        b.append(singleString(n.evaluate(resource, nctxt)));
      }
      return List.of(b.toString());
    }
  }

  public static class LiquidDocument {
    private List<LiquidNode> body = new ArrayList<>();

  }

  private class LiquidParser {

    private String source;
    private int cursor;
    private String name;

    public LiquidParser(String source) {
      this.source = source;
      if (source == null) {
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_NO_SOURCE_TO_PARSE));
      }
      cursor = 0;
    }

    private char next1() {
      if (cursor >= source.length())
        return 0;
      else
        return source.charAt(cursor);
    }

    private char next2() {
      if (cursor >= source.length() - 1)
        return 0;
      else
        return source.charAt(cursor + 1);
    }

    private char grab() {
      cursor++;
      return source.charAt(cursor - 1);
    }

    public LiquidDocument parse(String name) throws FHIRException {
      this.name = name;
      LiquidDocument doc = new LiquidDocument();
      parseList(doc.body, false, new String[0]);
      return doc;
    }

    public LiquidCycle parseCycle(String cnt) {
      LiquidCycle res = new LiquidCycle();
      cnt = "," + cnt.substring(5).trim();
      while (!Utilities.noString(cnt)) {
        if (!cnt.startsWith(",")) {
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_EXPECTING, name, cnt.charAt(0), ','));
        }
        cnt = cnt.substring(1).trim();
        if (!cnt.startsWith("\"")) {
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_EXPECTING, name, cnt.charAt(0), '"'));
        }
        cnt = cnt.substring(1);
        int i = 0;
        while (i < cnt.length() && cnt.charAt(i) != '"') {
          i++;
        }
        if (i == cnt.length()) {
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_UNTERMINATED, name));
        }
        res.list.add(cnt.substring(0, i));
        cnt = cnt.substring(i + 1).trim();
      }
      return res;
    }

    private String parseList(List<LiquidNode> list, boolean inLoop, String[] terminators) throws FHIRException {
      String close = null;
      while (cursor < source.length()) {
        if (next1() == '{' && (next2() == '%' || next2() == '{')) {
          if (next2() == '%') {
            String cnt = parseTag('%');
            if (isTerminator(cnt, terminators)) {
              close = cnt;
              break;
            } else if (cnt.startsWith("if "))
              list.add(parseIf(cnt, inLoop));
            else if (cnt.startsWith("loop ")) // loop is deprecated, but still
                                              // supported
              list.add(parseLoop(cnt.substring(4).trim()));
            else if (cnt.startsWith("for "))
              list.add(parseFor(cnt.substring(3).trim()));
            else if (inLoop && cnt.equals("continue"))
              list.add(new LiquidContinue());
            else if (inLoop && cnt.equals("break"))
              list.add(new LiquidBreak());
            else if (inLoop && cnt.startsWith("cycle "))
              list.add(parseCycle(cnt));
            else if (cnt.startsWith("include "))
              list.add(parseInclude(cnt.substring(7).trim()));
            else if (cnt.startsWith("assign "))
              list.add(parseAssign(cnt.substring(6).trim()));
            else if (cnt.startsWith("capture "))
              list.add(parseCapture(cnt.substring(7).trim()));
            else
              throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNKNOWN_FLOW_STMT,name, cnt));
          } else { // next2() == '{'
            list.add(parseStatement());
          }
        } else {
          if (list.size() == 0 || !(list.get(list.size() - 1) instanceof LiquidConstant))
            list.add(new LiquidConstant());
          ((LiquidConstant) list.get(list.size() - 1)).addChar(grab());
        }
      }
      for (LiquidNode n : list)
        n.closeUp();
      if (terminators.length > 0)
        if (!isTerminator(close, terminators))
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_UNKNOWN_NOEND, name, terminators));
      return close;
    }

    private boolean isTerminator(String cnt, String[] terminators) {
      if (Utilities.noString(cnt)) {
        return false;
      }
      for (String t : terminators) {
        if (t.endsWith(" ")) {
          if (cnt.startsWith(t)) {
            return true;
          }
        } else {
          if (cnt.equals(t)) {
            return true;
          }
        }
      }
      return false;
    }

    private LiquidNode parseIf(String cnt, boolean inLoop) throws FHIRException {
      LiquidIf res = new LiquidIf();
      res.condition = cnt.substring(3).trim();
      String term = parseList(res.thenBody, inLoop, new String[] { "else", "elsif ", "endif" });
      while (term.startsWith("elsif ")) {
        LiquidElsIf elsIf = new LiquidElsIf();
        res.elseIf.add(elsIf);
        elsIf.condition = term.substring(5).trim();
        term = parseList(elsIf.body, inLoop, new String[] { "elsif ", "else", "endif" });
      }
      if ("else".equals(term)) {
        term = parseList(res.elseBody, inLoop, new String[] { "endif" });
      }

      return res;
    }

    private LiquidNode parseInclude(String cnt) throws FHIRException {
      int i = 1;
      while (i < cnt.length() && !Character.isWhitespace(cnt.charAt(i)))
        i++;
      if (i == 0)
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_INCLUDE, name, cnt));
      LiquidInclude res = new LiquidInclude();
      res.page = cnt.substring(0, i);
      while (i < cnt.length() && Character.isWhitespace(cnt.charAt(i)))
        i++;
      while (i < cnt.length()) {
        int j = i;
        while (i < cnt.length() && cnt.charAt(i) != '=')
          i++;
        if (i >= cnt.length() || j == i)
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_INCLUDE, name,  cnt));
        String n = cnt.substring(j, i);
        if (res.params.containsKey(n))
          throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_INCLUDE, name,  cnt));
        i++;
        ExpressionNodeWithOffset t = engine.parsePartial(cnt, i);
        i = t.getOffset();
        res.params.put(n, t.getNode());
        while (i < cnt.length() && Character.isWhitespace(cnt.charAt(i)))
          i++;
      }
      return res;
    }

    private LiquidFor handleLoop(String cnt) throws FHIRException {
      int i = 0;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      LiquidFor res = new LiquidFor();
      res.varName = cnt.substring(0, i);
      if ("include".equals(res.varName)) {
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_VARIABLE_ILLEGAL, res.varName));
      }
      while (Character.isWhitespace(cnt.charAt(i)))
        i++;
      int j = i;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      if (!"in".equals(cnt.substring(j, i)))
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_LOOP, name, cnt));
      res.condition = cnt.substring(i).trim();
      return res;    
    }

    
    private LiquidNode parseLoop(String cnt) throws FHIRException {
      LiquidFor res = handleLoop(cnt);
      parseList(res.body, false, new String[] { "endloop" });
      return res;
    }

    private LiquidNode parseFor(String cnt) throws FHIRException {
      LiquidFor res = handleLoop(cnt);
      String term = parseList(res.body, true, new String[] { "endfor", "else" });
      if ("else".equals(term)) {
        parseList(res.elseBody, false, new String[] { "endfor" });
      }
      return res;
    }

    private LiquidNode parseCapture(String cnt) throws FHIRException {
      int i = 0;
      while (i < cnt.length() && !Character.isWhitespace(cnt.charAt(i)))
        i++;
      LiquidCapture res = new LiquidCapture();
      res.varName = cnt.substring(0, i);
      parseList(res.body, true, new String[] { "endcapture" });
      return res;
    }

    private LiquidNode parseAssign(String cnt) throws FHIRException {
      int i = 0;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      LiquidAssign res = new LiquidAssign();
      res.varName = cnt.substring(0, i);
      while (Character.isWhitespace(cnt.charAt(i)))
        i++;
      int j = i;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;

      res.value = new LiquidStatement();
      res.value.statement = cnt.substring(i).trim();
      
      return res;
    }

    private String parseTag(char ch) throws FHIRException {
      grab();
      grab();
      StringBuilder b = new StringBuilder();
      while (cursor < source.length() && !(next1() == '%' && next2() == '}')) {
        b.append(grab());
      }
      if (!(next1() == '%' && next2() == '}'))
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_NOTERM, name,  "{% " + b.toString()));
      grab();
      grab();
      return b.toString().trim();
    }

    private LiquidStatement parseStatement() throws FHIRException {
      grab();
      grab();
      StringBuilder b = new StringBuilder();
      while (cursor < source.length() && !(next1() == '}' && next2() == '}')) {
        b.append(grab());
      }
      if (!(next1() == '}' && next2() == '}'))
        throw new FHIRException(engine.getWorker().formatMessage(I18nConstants.LIQUID_SYNTAX_NOTERM, name,  "{{ " + b.toString()));
      grab();
      grab();
      LiquidStatement res = new LiquidStatement();
      res.statement = b.toString().trim();
      return res;
    }

  }

  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    if (ctxt.loopVars.containsKey(name))
      return new ArrayList<Base>(Arrays.asList(ctxt.loopVars.get(name)));
    if (ctxt.globalVars.containsKey(name))
      return new ArrayList<Base>(ctxt.globalVars.get(name));
    if (externalHostServices == null)
      return new ArrayList<Base>();
    return externalHostServices.resolveConstant(engine, ctxt.externalContext, name, mode);
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return externalHostServices.resolveConstantType(engine, ctxt.externalContext, name, mode);
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    if (externalHostServices == null)
      return false;
    return externalHostServices.log(argument, focus);
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    // we define one function here: ensureId()
    if (keyIssuer != null && "ensureId".equals(functionName)) {
      return new FunctionDetails("Id for element, and make a unique one if it doens't exist", 0, 0);
    }
    if (externalHostServices == null)
      return null;
    return externalHostServices.resolveFunction(engine, functionName);
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    if (keyIssuer != null && "ensureId".equals(functionName)) {
      return new TypeDetails(CollectionStatus.SINGLETON, "string");
    }
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return externalHostServices.checkFunction(engine, ctxt.externalContext, functionName, focus, parameters);
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    if (keyIssuer != null && "ensureId".equals(functionName)) {
      Base b = focus.get(0);
      if (b.getIdBase() == null) {
        b.setIdBase(keyIssuer.issueKey());
      }
      List<Base> res = new ArrayList<Base>();
      res.add(new IdType(b.getIdBase()));
      return res;
    }
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return externalHostServices.executeFunction(engine, ctxt.externalContext, focus, functionName, parameters);
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Identifier identifier, Base refContext) throws FHIRException {
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return resolveReference(engine, ctxt.externalContext, url, identifier, refContext);
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    if (externalHostServices == null)
      return false;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return conformsToProfile(engine, ctxt.externalContext, item, url);
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    if (externalHostServices != null)
      return externalHostServices.resolveValueSet(engine, ctxt.externalContext, url);
    else
      return engine.getWorker().fetchResource(ValueSet.class, url, IWorkerContext.VersionResolutionRules.defaultRule());
  }

  /**
   * Lightweight method to replace fixed constants in resources
   * 
   * @param node
   * @param vars
   * @return
   */
  public boolean replaceInHtml(XhtmlNode node, Map<String, String> vars) {
    boolean replaced = false;
    if (node.getNodeType() == NodeType.Text || node.getNodeType() == NodeType.Comment) {
      String cnt = node.getContent();
      for (String n : vars.keySet()) {
        cnt = cnt.replace(n, vars.get(n));
      }
      if (!cnt.equals(node.getContent())) {
        node.setContent(cnt);
        replaced = true;
      }
    } else if (node.getNodeType() == NodeType.Element || node.getNodeType() == NodeType.Document) {
      for (XhtmlNode c : node.getChildNodes()) {
        if (replaceInHtml(c, vars)) {
          replaced = true;
        }
      }
      for (String an : node.getAttributes().keySet()) {
        String cnt = node.getAttributes().get(an);
        for (String n : vars.keySet()) {
          cnt = cnt.replace(n, vars.get(n));
        }
        if (!cnt.equals(node.getAttributes().get(an))) {
          node.getAttributes().put(an, cnt);
          replaced = true;
        }
      }
    }
    return replaced;
  }

  @Override
  public boolean paramIsType(String name, int index) {
    return false;
  }

  public FHIRPathEngine getEngine() {
    return engine;
  }


  public Base findContainingResource(Object appContext, Base item) {
    return null;
  }
}
