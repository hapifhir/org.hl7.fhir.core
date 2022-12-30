package org.hl7.fhir.r4b.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.ExpressionNode;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.Tuple;
import org.hl7.fhir.r4b.model.TypeDetails;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.r4b.utils.FHIRPathEngine.ExpressionNodeWithOffset;
import org.hl7.fhir.r4b.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class LiquidEngine implements IEvaluationContext {

  public interface ILiquidRenderingSupport {
    String renderForLiquid(Object appContext, Base i) throws FHIRException;
  }

  public interface ILiquidEngineIncludeResolver {
    public String fetchInclude(LiquidEngine engine, String name);
  }

  private IEvaluationContext externalHostServices;
  private FHIRPathEngine engine;
  private ILiquidEngineIncludeResolver includeResolver;
  private ILiquidRenderingSupport renderingSupport;

  private class LiquidEngineContext {
    private Object externalContext;
    private Map<String, Base> vars = new HashMap<>();

    public LiquidEngineContext(Object externalContext) {
      super();
      this.externalContext = externalContext;
    }

    public LiquidEngineContext(LiquidEngineContext existing) {
      super();
      externalContext = existing.externalContext;
      vars.putAll(existing.vars);
    }
  }

  public LiquidEngine(IWorkerContext context, IEvaluationContext hostServices) {
    super();
    this.externalHostServices = hostServices;
    engine = new FHIRPathEngine(context);
    engine.setHostServices(this);
    engine.setLiquidMode(true);
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

  public LiquidDocument parse(String source, String sourceName) throws FHIRException {
    return new LiquidParser(source).parse(sourceName);
  }

  public String evaluate(LiquidDocument document, Base resource, Object appContext) throws FHIRException {
    StringBuilder b = new StringBuilder();
    LiquidEngineContext ctxt = new LiquidEngineContext(appContext);
    for (LiquidNode n : document.body) {
      n.evaluate(b, resource, ctxt);
    }
    return b.toString();
  }

  private abstract class LiquidNode {
    protected void closeUp() {
    }

    public abstract void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException;
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
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) {
      b.append(constant);
    }

  }
  
  private enum LiquidFilter {
    PREPEND;
    
    public static LiquidFilter fromCode(String code) {
      if ("prepend".equals(code)) {
        return PREPEND;
      }
      return null;
    }
  }

  private class LiquidExpressionNode {
    private LiquidFilter filter; // null at root
    private ExpressionNode expression; // null for some filters
    public LiquidExpressionNode(LiquidFilter filter, ExpressionNode expression) {
      super();
      this.filter = filter;
      this.expression = expression;
    }
    
  }
  
  private class LiquidStatement extends LiquidNode {
    private String statement;
    private List<LiquidExpressionNode> compiled = new ArrayList<>();

    @Override
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      if (compiled.size() == 0) {
        FHIRLexer lexer = new FHIRLexer(statement, "liquid statement");
        lexer.setLiquidMode(true);
        compiled.add(new LiquidExpressionNode(null, engine.parse(lexer)));
        while (!lexer.done()) {
          if (lexer.getCurrent().equals("||")) {
            lexer.next();
            String f = lexer.getCurrent();
            LiquidFilter filter = LiquidFilter.fromCode(f);
            if (filter == null) {
              lexer.error("Unknown Liquid filter '"+f+"'");
            }
            lexer.next();
            if (!lexer.done() && lexer.getCurrent().equals(":")) {
              lexer.next();
              compiled.add(new LiquidExpressionNode(filter, engine.parse(lexer)));
            } else {
              compiled.add(new LiquidExpressionNode(filter, null));
            }
          } else {
            lexer.error("Unexpected syntax parsing liquid statement");
          }
        }
      }
      
      String t = null;
      for (LiquidExpressionNode i : compiled) {
        if (i.filter == null) { // first
          t = stmtToString(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression));
        } else switch (i.filter) {
        case PREPEND:
          t = stmtToString(ctxt, engine.evaluate(ctxt, resource, resource, resource, i.expression)) + t;
          break;
        }
      }
      b.append(t);
    }

    private String stmtToString(LiquidEngineContext ctxt, List<Base> items) {
      StringBuilder b = new StringBuilder();
      boolean first = true;
      for (Base i : items) {
        if (first) first = false; else b.append(", ");
        String s = renderingSupport != null ? renderingSupport.renderForLiquid(ctxt.externalContext, i) : null;
        b.append(s != null ? s : engine.convertToString(i));
      }
      return b.toString();
    }
  }

  private class LiquidElsIf extends LiquidNode {
    private String condition;
    private ExpressionNode compiled;
    private List<LiquidNode> body = new ArrayList<>();

    @Override
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      for (LiquidNode n : body) {
        n.evaluate(b, resource, ctxt);
      }
    }
  }

  private class LiquidIf extends LiquidNode {
    private String condition;
    private ExpressionNode compiled;
    private List<LiquidNode> thenBody = new ArrayList<>();
    private List<LiquidElsIf> elseIf = new ArrayList<>();
    private List<LiquidNode> elseBody = new ArrayList<>();

    @Override
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
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
      for (LiquidNode n : list) {
        n.evaluate(b, resource, ctxt);
      }
    }
  }

  private class LiquidContinueExecuted extends FHIRException {
    private static final long serialVersionUID = 4748737094188943721L;
  }

  private class LiquidContinue extends LiquidNode {
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      throw new LiquidContinueExecuted();
    }
  }

  private class LiquidBreakExecuted extends FHIRException {
    private static final long serialVersionUID = 6328496371172871082L;
  }

  private class LiquidBreak extends LiquidNode {
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      throw new LiquidBreakExecuted();
    }
  }

  private class LiquidCycle extends LiquidNode {
    private List<String> list = new ArrayList<>();
    private int cursor = 0;

    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      b.append(list.get(cursor));
      cursor++;
      if (cursor == list.size()) {
        cursor = 0;
      }
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
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      if (compiled == null) {
        ExpressionNodeWithOffset po = engine.parsePartial(condition, 0);
        compiled = po.getNode();
        if (po.getOffset() < condition.length()) {
          parseModifiers(condition.substring(po.getOffset()));
        }
      }
      List<Base> list = engine.evaluate(ctxt, resource, resource, resource, compiled);
      LiquidEngineContext lctxt = new LiquidEngineContext(ctxt);
      if (list.isEmpty()) {
        for (LiquidNode n : elseBody) {
          n.evaluate(b, resource, lctxt);
        }
      } else {
        if (reversed) {
          Collections.reverse(list);
        }
        int i = 0;
        for (Base o : list) {
          if (offset >= 0 && i < offset) {
            i++;
            continue;
          }
          if (limit >= 0 && i == limit) {
            break;
          }          
          lctxt.vars.put(varName, o);
          boolean wantBreak = false;
          for (LiquidNode n : body) {
            try {
              n.evaluate(b, resource, lctxt);
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
      }
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
            throw new FHIRException("Exception evaluating "+src+": limit is not followed by ':'");
          }
          cnt = cnt.substring(1).trim();
          int i = 0;
          while (i < cnt.length() && Character.isDigit(cnt.charAt(i))) {
            i++;
          }
          if (i == 0) {
            throw new FHIRException("Exception evaluating "+src+": limit is not followed by a number");
          }
          limit = Integer.parseInt(cnt.substring(0, i));
          cnt = cnt.substring(i);
        } else if (cnt.startsWith("offset")) {
          cnt = cnt.substring(6).trim();
          if (!cnt.startsWith(":")) {
            throw new FHIRException("Exception evaluating "+src+": limit is not followed by ':'");
          }
          cnt = cnt.substring(1).trim();
          int i = 0;
          while (i < cnt.length() && Character.isDigit(cnt.charAt(i))) {
            i++;
          }
          if (i == 0) {
            throw new FHIRException("Exception evaluating "+src+": limit is not followed by a number");
          }
          offset = Integer.parseInt(cnt.substring(0, i));
          cnt = cnt.substring(i);
        } else {
          throw new FHIRException("Exception evaluating "+src+": unexpected content at "+cnt);
        }
      }      
    }
  }

  private class LiquidInclude extends LiquidNode {
    private String page;
    private Map<String, ExpressionNode> params = new HashMap<>();

    @Override
    public void evaluate(StringBuilder b, Base resource, LiquidEngineContext ctxt) throws FHIRException {
      String src = includeResolver.fetchInclude(LiquidEngine.this, page);
      LiquidParser parser = new LiquidParser(src);
      LiquidDocument doc = parser.parse(page);
      LiquidEngineContext nctxt = new LiquidEngineContext(ctxt.externalContext);
      Tuple incl = new Tuple();
      nctxt.vars.put("include", incl);
      for (String s : params.keySet()) {
        incl.addProperty(s, engine.evaluate(ctxt, resource, resource, resource, params.get(s)));
      }
      for (LiquidNode n : doc.body) {
        n.evaluate(b, resource, nctxt);
      }
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
          throw new FHIRException("Script " + name + ": Script " + name + ": Found " + cnt.charAt(0) + " expecting ',' parsing cycle");
        }
        cnt = cnt.substring(1).trim();
        if (!cnt.startsWith("\"")) {
          throw new FHIRException("Script " + name + ": Script " + name + ": Found " + cnt.charAt(0) + " expecting '\"' parsing cycle");
        }
        cnt = cnt.substring(1);
        int i = 0;
        while (i < cnt.length() && cnt.charAt(i) != '"') {
          i++;
        }
        if (i == cnt.length()) {
          throw new FHIRException("Script " + name + ": Script " + name + ": Found unterminated string parsing cycle");
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
            else
              throw new FHIRException("Script " + name + ": Script " + name + ": Unknown flow control statement " + cnt);
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
          throw new FHIRException("Script " + name + ": Script " + name + ": Found end of script looking for " + terminators);
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
      if (i == cnt.length() || i == 0)
        throw new FHIRException("Script " + name + ": Error reading include: " + cnt);
      LiquidInclude res = new LiquidInclude();
      res.page = cnt.substring(0, i);
      while (i < cnt.length() && Character.isWhitespace(cnt.charAt(i)))
        i++;
      while (i < cnt.length()) {
        int j = i;
        while (i < cnt.length() && cnt.charAt(i) != '=')
          i++;
        if (i >= cnt.length() || j == i)
          throw new FHIRException("Script " + name + ": Error reading include: " + cnt);
        String n = cnt.substring(j, i);
        if (res.params.containsKey(n))
          throw new FHIRException("Script " + name + ": Error reading include: " + cnt);
        i++;
        ExpressionNodeWithOffset t = engine.parsePartial(cnt, i);
        i = t.getOffset();
        res.params.put(n, t.getNode());
        while (i < cnt.length() && Character.isWhitespace(cnt.charAt(i)))
          i++;
      }
      return res;
    }

    private LiquidNode parseLoop(String cnt) throws FHIRException {
      int i = 0;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      LiquidFor res = new LiquidFor();
      res.varName = cnt.substring(0, i);
      while (Character.isWhitespace(cnt.charAt(i)))
        i++;
      int j = i;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      if (!"in".equals(cnt.substring(j, i)))
        throw new FHIRException("Script " + name + ": Script " + name + ": Error reading loop: " + cnt);
      res.condition = cnt.substring(i).trim();
      parseList(res.body, false, new String[] { "endloop" });
      return res;
    }

    private LiquidNode parseFor(String cnt) throws FHIRException {
      int i = 0;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      LiquidFor res = new LiquidFor();
      res.varName = cnt.substring(0, i);
      while (Character.isWhitespace(cnt.charAt(i)))
        i++;
      int j = i;
      while (!Character.isWhitespace(cnt.charAt(i)))
        i++;
      if (!"in".equals(cnt.substring(j, i)))
        throw new FHIRException("Script " + name + ": Script " + name + ": Error reading loop: " + cnt);
      res.condition = cnt.substring(i).trim();
      String term = parseList(res.body, true, new String[] { "endfor", "else" });
      if ("else".equals(term)) {
        parseList(res.elseBody, false, new String[] { "endfor" });
      }
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
        throw new FHIRException("Script " + name + ": Unterminated Liquid statement {% " + b.toString());
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
        throw new FHIRException("Script " + name + ": Unterminated Liquid statement {{ " + b.toString());
      grab();
      grab();
      LiquidStatement res = new LiquidStatement();
      res.statement = b.toString().trim();
      return res;
    }

  }

  @Override
  public List<Base> resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    if (ctxt.vars.containsKey(name))
      return new ArrayList<Base>(Arrays.asList(ctxt.vars.get(name)));
    if (externalHostServices == null)
      return new ArrayList<Base>();
    return externalHostServices.resolveConstant(ctxt.externalContext, name, beforeContext);
  }

  @Override
  public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return externalHostServices.resolveConstantType(ctxt.externalContext, name);
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    if (externalHostServices == null)
      return false;
    return externalHostServices.log(argument, focus);
  }

  @Override
  public FunctionDetails resolveFunction(String functionName) {
    if (externalHostServices == null)
      return null;
    return externalHostServices.resolveFunction(functionName);
  }

  @Override
  public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return externalHostServices.checkFunction(ctxt.externalContext, functionName, parameters);
  }

  @Override
  public List<Base> executeFunction(Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return externalHostServices.executeFunction(ctxt.externalContext, focus, functionName, parameters);
  }

  @Override
  public Base resolveReference(Object appContext, String url, Base refContext) throws FHIRException {
    if (externalHostServices == null)
      return null;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return resolveReference(ctxt.externalContext, url, refContext);
  }

  @Override
  public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
    if (externalHostServices == null)
      return false;
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    return conformsToProfile(ctxt.externalContext, item, url);
  }

  @Override
  public ValueSet resolveValueSet(Object appContext, String url) {
    LiquidEngineContext ctxt = (LiquidEngineContext) appContext;
    if (externalHostServices != null)
      return externalHostServices.resolveValueSet(ctxt.externalContext, url);
    else
      return engine.getWorker().fetchResource(ValueSet.class, url);
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

}