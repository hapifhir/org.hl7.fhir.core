package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.ValueSet.*;

import java.io.IOException;
import java.util.*;

public class VCLParser {

  public static class VCLParseException extends Exception {
    public VCLParseException(String message) {
      super(message);
    }

    public VCLParseException(String message, int position) {
      super(message + " at position " + position);
    }
  }

  private enum TokenType {
    DASH, OPEN, CLOSE, SEMI, COMMA, DOT, STAR,
    EQ, IS_A, IS_NOT_A, DESC_OF, REGEX, IN, NOT_IN,
    GENERALIZES, CHILD_OF, DESC_LEAF, EXISTS,
    URI, SCODE, QUOTED_VALUE, EOF
  }

  private static class Token {
    TokenType type;
    String value;
    int position;

    Token(TokenType type, String value, int position) {
      this.type = type;
      this.value = value;
      this.position = position;
    }

    @Override
    public String toString() {
      return type + "(" + value + ")";
    }
  }

  private static class Lexer {
    private String input;
    private int pos = 0;

    public Lexer(String input) {
      this.input = input.trim();
    }

    public List<Token> tokenize() throws VCLParseException {
      List<Token> tokens = new ArrayList<>();

      while (pos < input.length()) {
        skipWhitespace();
        if (pos >= input.length()) break;

        int startPos = pos;
        char ch = input.charAt(pos);

        switch (ch) {
          case '-': tokens.add(new Token(TokenType.DASH, "-", startPos)); pos++; continue;
          case '(': tokens.add(new Token(TokenType.OPEN, "(", startPos)); pos++; continue;
          case ')': tokens.add(new Token(TokenType.CLOSE, ")", startPos)); pos++; continue;
          case ';': tokens.add(new Token(TokenType.SEMI, ";", startPos)); pos++; continue;
          case ',': tokens.add(new Token(TokenType.COMMA, ",", startPos)); pos++; continue;
          case '.': tokens.add(new Token(TokenType.DOT, ".", startPos)); pos++; continue;
          case '*': tokens.add(new Token(TokenType.STAR, "*", startPos)); pos++; continue;
          case '=': tokens.add(new Token(TokenType.EQ, "=", startPos)); pos++; continue;
          case '/': tokens.add(new Token(TokenType.REGEX, "/", startPos)); pos++; continue;
          case '^': tokens.add(new Token(TokenType.IN, "^", startPos)); pos++; continue;
          case '>':
            if (peek() == '>') {
              tokens.add(new Token(TokenType.GENERALIZES, ">>", startPos));
              pos += 2;
            } else {
              throw new VCLParseException("Unexpected character: " + ch, pos);
            }
            continue;
          case '<':
            if (peek() == '<') {
              tokens.add(new Token(TokenType.IS_A, "<<", startPos));
              pos += 2;
            } else if (peek() == '!') {
              tokens.add(new Token(TokenType.CHILD_OF, "<!", startPos));
              pos += 2;
            } else {
              tokens.add(new Token(TokenType.DESC_OF, "<", startPos));
              pos++;
            }
            continue;
          case '~':
            if (peek() == '<' && peek(1) == '<') {
              tokens.add(new Token(TokenType.IS_NOT_A, "~<<", startPos));
              pos += 3;
            } else if (peek() == '^') {
              tokens.add(new Token(TokenType.NOT_IN, "~^", startPos));
              pos += 2;
            } else {
              throw new VCLParseException("Unexpected character: " + ch, pos);
            }
            continue;
          case '!':
            if (peek() == '!' && peek(1) == '<') {
              tokens.add(new Token(TokenType.DESC_LEAF, "!!<", startPos));
              pos += 3;
            } else {
              throw new VCLParseException("Unexpected character: " + ch, pos);
            }
            continue;
          case '?': tokens.add(new Token(TokenType.EXISTS, "?", startPos)); pos++; continue;
          case '"':
            tokens.add(readQuotedValue(startPos));
            continue;
        }

        if (Character.isLetter(ch)) {
          String value = readWhile(c -> Character.isLetterOrDigit(c) || c == ':' || c == '?' ||
            c == '&' || c == '%' || c == '+' || c == '-' || c == '.' || c == '@' ||
            c == '#' || c == '$' || c == '!' || c == '{' || c == '}' || c == '_');

          if (value.contains(":")) {
            String restOfUri = readWhile(c -> Character.isLetterOrDigit(c) || c == '?' ||
              c == '&' || c == '%' || c == '+' || c == '-' || c == '.' || c == '@' ||
              c == '#' || c == '$' || c == '!' || c == '{' || c == '}' || c == '_' || c == '/');
            value += restOfUri;

            if (pos < input.length() && input.charAt(pos) == '|') {
              pos++;
              String version = readWhile(c -> c != '(' && c != ')' && !Character.isWhitespace(c));
              value += "|" + version;
            }
            tokens.add(new Token(TokenType.URI, value, startPos));
          } else {
            tokens.add(new Token(TokenType.SCODE, value, startPos));
          }
        } else if (Character.isDigit(ch)) {
          String value = readWhile(c -> Character.isLetterOrDigit(c) || c == '-' || c == '_');
          tokens.add(new Token(TokenType.SCODE, value, startPos));
        } else {
          throw new VCLParseException("Unexpected character: " + ch, pos);
        }
      }

      tokens.add(new Token(TokenType.EOF, "", pos));
      return tokens;
    }

    private Token readQuotedValue(int startPos) throws VCLParseException {
      StringBuilder sb = new StringBuilder();
      pos++;

      while (pos < input.length()) {
        char ch = input.charAt(pos);
        if (ch == '"') {
          pos++;
          return new Token(TokenType.QUOTED_VALUE, sb.toString(), startPos);
        } else if (ch == '\\' && pos + 1 < input.length()) {
          pos++;
          char escaped = input.charAt(pos);
          if (escaped == '"' || escaped == '\\') {
            sb.append(escaped);
          } else {
            sb.append('\\').append(escaped);
          }
          pos++;
        } else {
          sb.append(ch);
          pos++;
        }
      }

      throw new VCLParseException("Unterminated quoted string", startPos);
    }

    private String readWhile(java.util.function.Predicate<Character> predicate) {
      StringBuilder sb = new StringBuilder();
      while (pos < input.length() && predicate.test(input.charAt(pos))) {
        sb.append(input.charAt(pos));
        pos++;
      }
      return sb.toString();
    }

    private char peek() {
      return peek(0);
    }

    private char peek(int offset) {
      int peekPos = pos + 1 + offset;
      return peekPos < input.length() ? input.charAt(peekPos) : '\0';
    }

    private void skipWhitespace() {
      while (pos < input.length() && Character.isWhitespace(input.charAt(pos))) {
        pos++;
      }
    }
  }

  private static class Parser {
    private List<Token> tokens;
    private int pos = 0;
    private ValueSet valueSet;
    private ValueSetComposeComponent compose;

    public Parser(List<Token> tokens) {
      this.tokens = tokens;
      this.valueSet = new ValueSet();
      this.valueSet.setStatus(Enumerations.PublicationStatus.DRAFT);
      this.compose = new ValueSetComposeComponent();
      this.valueSet.setCompose(compose);
    }

    public ValueSet parse() throws VCLParseException {
      parseExpr();
      expect(TokenType.EOF);
      return valueSet;
    }

    private void parseExpr() throws VCLParseException {
      parseSubExpr(false);

      if (current().type == TokenType.COMMA) {
        parseConjunction();
      } else if (current().type == TokenType.SEMI) {
        parseDisjunction();
      } else if (current().type == TokenType.DASH) {
        parseExclusion();
      }
    }

    private void parseSubExpr(boolean isExclusion) throws VCLParseException {
      String systemUri = null;

      if (current().type == TokenType.OPEN && peek().type == TokenType.URI) {
        consume(TokenType.OPEN);
        systemUri = current().value;
        consume(TokenType.URI);
        consume(TokenType.CLOSE);
      }

      if (current().type == TokenType.OPEN) {
        consume(TokenType.OPEN);

        if (current().type == TokenType.OPEN && peek().type == TokenType.URI) {
          consume(TokenType.OPEN);
          systemUri = current().value;
          consume(TokenType.URI);
          consume(TokenType.CLOSE);
        }

        if (isSimpleCodeList()) {
          parseSimpleCodeList(systemUri, isExclusion);
        } else {
          parseExprWithinParentheses(isExclusion);
        }

        consume(TokenType.CLOSE);
      } else {
        parseSimpleExpr(systemUri, isExclusion);
      }
    }

    private boolean isSimpleCodeList() {
      int lookahead = pos;
      while (lookahead < tokens.size()) {
        Token token = tokens.get(lookahead);

        if (token.type == TokenType.CLOSE) {
          return true;
        }

        if (token.type == TokenType.OPEN && lookahead + 2 < tokens.size()) {
          Token nextToken = tokens.get(lookahead + 1);
          Token tokenAfterNext = tokens.get(lookahead + 2);
          if (nextToken.type == TokenType.URI && tokenAfterNext.type == TokenType.CLOSE) {
            lookahead += 3;
            continue;
          }
        }

        if (token.type == TokenType.OPEN ||
          token.type == TokenType.DASH ||
          isFilterOperator(token.type)) {
          return false;
        }
        lookahead++;
      }
      return true;
    }

    private void parseExprWithinParentheses(boolean isExclusion) throws VCLParseException {
      parseSubExpr(isExclusion);

      while (current().type == TokenType.COMMA || current().type == TokenType.SEMI || current().type == TokenType.DASH) {
        if (current().type == TokenType.COMMA) {
          parseConjunctionWithFlag(isExclusion);
        } else if (current().type == TokenType.SEMI) {
          parseDisjunctionWithFlag(isExclusion);
        } else if (current().type == TokenType.DASH) {
          parseExclusion();
        }
      }
    }

    private void parseSimpleCodeList(String systemUri, boolean isExclusion) throws VCLParseException {
      ConceptSetComponent conceptSet = createConceptSet(systemUri, isExclusion);

      if (current().type == TokenType.STAR) {
        consume(TokenType.STAR);
        conceptSet.addFilter()
          .setProperty("concept")
          .setOp(Enumerations.FilterOperator.EXISTS)
          .setValue("true");
        return;
      } else if (current().type == TokenType.IN) {
        parseIncludeVs(conceptSet);
        return;
      } else {
        String code = parseCode();
        conceptSet.addConcept().setCode(code);
      }

      while (current().type == TokenType.SEMI || current().type == TokenType.COMMA) {
        consume(current().type);

        if (current().type == TokenType.STAR) {
          consume(TokenType.STAR);
          conceptSet.addFilter()
            .setProperty("concept")
            .setOp(Enumerations.FilterOperator.EXISTS)
            .setValue("true");
        } else if (current().type == TokenType.IN) {
          parseIncludeVs(conceptSet);
        } else {
          String code = parseCode();
          conceptSet.addConcept().setCode(code);
        }
      }
    }

    private void parseSimpleExpr(String systemUri, boolean isExclusion) throws VCLParseException {
      ConceptSetComponent conceptSet = createConceptSet(systemUri, isExclusion);

      if (current().type == TokenType.STAR) {
        consume(TokenType.STAR);
        conceptSet.addFilter()
          .setProperty("concept")
          .setOp(Enumerations.FilterOperator.EXISTS)
          .setValue("true");
      } else if (current().type == TokenType.SCODE || current().type == TokenType.QUOTED_VALUE) {
        String code = parseCode();

        if (isFilterOperator(current().type)) {
          parseFilter(conceptSet, code);
        } else {
          conceptSet.addConcept().setCode(code);
        }
      } else if (current().type == TokenType.IN) {
        parseIncludeVs(conceptSet);
      } else {
        throw new VCLParseException("Expected code, filter, or include", current().position);
      }
    }

    private void parseFilter(ConceptSetComponent conceptSet, String property) throws VCLParseException {
      ConceptSetFilterComponent filter = conceptSet.addFilter();
      filter.setProperty(property);

      TokenType op = current().type;
      consume(op);

      switch (op) {
        case EQ:
          filter.setOp(Enumerations.FilterOperator.EQUAL);
          filter.setValue(parseCode());
          break;
        case IS_A:
          filter.setOp(Enumerations.FilterOperator.ISA);
          filter.setValue(parseCode());
          break;
        case IS_NOT_A:
          filter.setOp(Enumerations.FilterOperator.ISNOTA);
          filter.setValue(parseCode());
          break;
        case DESC_OF:
          filter.setOp(Enumerations.FilterOperator.DESCENDENTOF);
          filter.setValue(parseCode());
          break;
        case REGEX:
          filter.setOp(Enumerations.FilterOperator.REGEX);
          filter.setValue(parseQuotedString());
          break;
        case IN:
          filter.setOp(Enumerations.FilterOperator.IN);
          filter.setValue(parseFilterValue());
          break;
        case NOT_IN:
          filter.setOp(Enumerations.FilterOperator.NOTIN);
          filter.setValue(parseFilterValue());
          break;
        case GENERALIZES:
          filter.setOp(Enumerations.FilterOperator.GENERALIZES);
          filter.setValue(parseCode());
          break;
        case CHILD_OF:
          filter.setOp(Enumerations.FilterOperator.CHILDOF);
          filter.setValue(parseCode());
          break;
        case DESC_LEAF:
          filter.setOp(Enumerations.FilterOperator.DESCENDENTLEAF);
          filter.setValue(parseCode());
          break;
        case EXISTS:
          filter.setOp(Enumerations.FilterOperator.EXISTS);
          filter.setValue(parseCode());
          break;
        default:
          throw new VCLParseException("Unexpected filter operator: " + op, current().position);
      }
    }

    private void parseIncludeVs(ConceptSetComponent conceptSet) throws VCLParseException {
      consume(TokenType.IN);

      if (current().type == TokenType.URI) {
        conceptSet.addValueSet(current().value);
        consume(TokenType.URI);
      } else if (current().type == TokenType.OPEN) {
        consume(TokenType.OPEN);
        conceptSet.addValueSet(current().value);
        consume(TokenType.URI);
        consume(TokenType.CLOSE);
      } else {
        throw new VCLParseException("Expected URI after ^", current().position);
      }
    }

    private void parseConjunction() throws VCLParseException {
      ConceptSetComponent currentConceptSet = getCurrentConceptSet(false);

      while (current().type == TokenType.COMMA) {
        consume(TokenType.COMMA);

        if (current().type == TokenType.SCODE || current().type == TokenType.QUOTED_VALUE) {
          String code = parseCode();
          if (isFilterOperator(current().type)) {
            parseFilter(currentConceptSet, code);
          } else {
            currentConceptSet.addConcept().setCode(code);
          }
        } else {
          parseSubExpr(false);
        }
      }
    }

    private void parseConjunctionWithFlag(boolean isExclusion) throws VCLParseException {
      ConceptSetComponent currentConceptSet = getCurrentConceptSet(isExclusion);

      while (current().type == TokenType.COMMA) {
        consume(TokenType.COMMA);

        if (current().type == TokenType.SCODE || current().type == TokenType.QUOTED_VALUE) {
          String code = parseCode();
          if (isFilterOperator(current().type)) {
            parseFilter(currentConceptSet, code);
          } else {
            currentConceptSet.addConcept().setCode(code);
          }
        } else {
          parseSubExpr(isExclusion);
        }
      }
    }

    private void parseDisjunction() throws VCLParseException {
      while (current().type == TokenType.SEMI) {
        consume(TokenType.SEMI);
        parseSubExpr(false);
      }
    }

    private void parseDisjunctionWithFlag(boolean isExclusion) throws VCLParseException {
      while (current().type == TokenType.SEMI) {
        consume(TokenType.SEMI);
        parseSubExpr(isExclusion);
      }
    }

    private void parseExclusion() throws VCLParseException {
      consume(TokenType.DASH);
      parseSubExpr(true);
    }

    private String parseCode() throws VCLParseException {
      if (current().type == TokenType.SCODE) {
        String code = current().value;
        consume(TokenType.SCODE);
        return code;
      } else if (current().type == TokenType.QUOTED_VALUE) {
        String code = current().value;
        consume(TokenType.QUOTED_VALUE);
        return code;
      } else {
        throw new VCLParseException("Expected code", current().position);
      }
    }

    private String parseQuotedString() throws VCLParseException {
      if (current().type == TokenType.QUOTED_VALUE) {
        String value = current().value;
        consume(TokenType.QUOTED_VALUE);
        return value;
      } else {
        throw new VCLParseException("Expected quoted string", current().position);
      }
    }

    private String parseFilterValue() throws VCLParseException {
      if (current().type == TokenType.OPEN) {
        consume(TokenType.OPEN);
        StringBuilder sb = new StringBuilder();
        sb.append(parseCode());

        while (current().type == TokenType.COMMA) {
          consume(TokenType.COMMA);
          sb.append(",").append(parseCode());
        }

        consume(TokenType.CLOSE);
        return sb.toString();
      } else if (current().type == TokenType.URI) {
        String uri = current().value;
        consume(TokenType.URI);
        return uri;
      } else {
        return parseCode();
      }
    }

    private ConceptSetComponent createConceptSet(String systemUri, boolean isExclusion) {
      ConceptSetComponent conceptSet = new ConceptSetComponent();

      if (systemUri != null) {
        conceptSet.setSystem(systemUri);
      }

      if (isExclusion) {
        compose.addExclude(conceptSet);
      } else {
        compose.addInclude(conceptSet);
      }

      return conceptSet;
    }

    private ConceptSetComponent getCurrentConceptSet(boolean isExclusion) {
      if (isExclusion) {
        List<ConceptSetComponent> excludes = compose.getExclude();
        return excludes.isEmpty() ? createConceptSet(null, true) : excludes.get(excludes.size() - 1);
      } else {
        List<ConceptSetComponent> includes = compose.getInclude();
        return includes.isEmpty() ? createConceptSet(null, false) : includes.get(includes.size() - 1);
      }
    }

    private boolean isFilterOperator(TokenType type) {
      return type == TokenType.EQ || type == TokenType.IS_A || type == TokenType.IS_NOT_A ||
        type == TokenType.DESC_OF || type == TokenType.REGEX || type == TokenType.IN ||
        type == TokenType.NOT_IN || type == TokenType.GENERALIZES || type == TokenType.CHILD_OF ||
        type == TokenType.DESC_LEAF || type == TokenType.EXISTS;
    }

    private Token current() {
      return pos < tokens.size() ? tokens.get(pos) : new Token(TokenType.EOF, "", -1);
    }

    private Token peek() {
      return pos + 1 < tokens.size() ? tokens.get(pos + 1) : new Token(TokenType.EOF, "", -1);
    }

    private void consume(TokenType expected) throws VCLParseException {
      if (current().type != expected) {
        throw new VCLParseException("Expected " + expected + " but got " + current().type, current().position);
      }
      pos++;
    }

    private void expect(TokenType expected) throws VCLParseException {
      if (current().type != expected) {
        throw new VCLParseException("Expected " + expected + " but got " + current().type, current().position);
      }
    }
  }

  public static ValueSet parse(String vclExpression) throws VCLParseException {
    if (vclExpression == null || vclExpression.trim().isEmpty()) {
      throw new VCLParseException("VCL expression cannot be empty");
    }

    Lexer lexer = new Lexer(vclExpression);
    List<Token> tokens = lexer.tokenize();

    Parser parser = new Parser(tokens);
    return parser.parse();
  }

  public static ValueSet parseAndId(String vclExpression) throws VCLParseException, IOException {
    ValueSet vs = parse(vclExpression);
    String json = new JsonParser().composeString(vs);
    vs.setUrl("cid:" + json.hashCode());
    return vs;
  }

}