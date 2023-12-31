package org.hl7.fhir.r4b.fhirpath;

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

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.Quantity;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.utilities.SourceLocation;
import org.hl7.fhir.utilities.Utilities;

public class ExpressionNode {

  public enum Kind {
    Name, Function, Constant, Group, Unary
  }

  public enum Function {
    Custom,

    Empty, Not, Exists, SubsetOf, SupersetOf, IsDistinct, Distinct, Count, Where, Select, All, Repeat, Aggregate,
    Item /* implicit from name[] */, As, Is, Single, First, Last, Tail, Skip, Take, Union, Combine, Intersect, Exclude,
    Iif, Upper, Lower, ToChars, IndexOf, Substring, StartsWith, EndsWith, Matches, MatchesFull, ReplaceMatches,
    Contains, Replace, Length, Children, Descendants, MemberOf, Trace, Check, Today, Now, Resolve, Extension, AllFalse,
    AnyFalse, AllTrue, AnyTrue, HasValue, OfType, Type, ConvertsToBoolean, ConvertsToInteger, ConvertsToString,
    ConvertsToDecimal, ConvertsToQuantity, ConvertsToDateTime, ConvertsToDate, ConvertsToTime, ToBoolean, ToInteger,
    ToString, ToDecimal, ToQuantity, ToDateTime, ToTime, ConformsTo, Round, Sqrt, Abs, Ceiling, Exp, Floor, Ln, Log,
    Power, Truncate,

    // R3 functions
    Encode, Decode, Escape, Unescape, Trim, Split, Join, LowBoundary, HighBoundary, Precision,

    // Local extensions to FHIRPath
    HtmlChecks1, HtmlChecks2, AliasAs, Alias, Comparable;

    public static Function fromCode(String name) {
      if (name.equals("empty"))
        return Function.Empty;
      if (name.equals("not"))
        return Function.Not;
      if (name.equals("exists"))
        return Function.Exists;
      if (name.equals("subsetOf"))
        return Function.SubsetOf;
      if (name.equals("supersetOf"))
        return Function.SupersetOf;
      if (name.equals("isDistinct"))
        return Function.IsDistinct;
      if (name.equals("distinct"))
        return Function.Distinct;
      if (name.equals("count"))
        return Function.Count;
      if (name.equals("where"))
        return Function.Where;
      if (name.equals("select"))
        return Function.Select;
      if (name.equals("all"))
        return Function.All;
      if (name.equals("repeat"))
        return Function.Repeat;
      if (name.equals("aggregate"))
        return Function.Aggregate;
      if (name.equals("item"))
        return Function.Item;
      if (name.equals("as"))
        return Function.As;
      if (name.equals("is"))
        return Function.Is;
      if (name.equals("single"))
        return Function.Single;
      if (name.equals("first"))
        return Function.First;
      if (name.equals("last"))
        return Function.Last;
      if (name.equals("tail"))
        return Function.Tail;
      if (name.equals("skip"))
        return Function.Skip;
      if (name.equals("take"))
        return Function.Take;
      if (name.equals("union"))
        return Function.Union;
      if (name.equals("combine"))
        return Function.Combine;
      if (name.equals("intersect"))
        return Function.Intersect;
      if (name.equals("exclude"))
        return Function.Exclude;
      if (name.equals("iif"))
        return Function.Iif;
      if (name.equals("lower"))
        return Function.Lower;
      if (name.equals("upper"))
        return Function.Upper;
      if (name.equals("toChars"))
        return Function.ToChars;
      if (name.equals("indexOf"))
        return Function.IndexOf;
      if (name.equals("substring"))
        return Function.Substring;
      if (name.equals("startsWith"))
        return Function.StartsWith;
      if (name.equals("endsWith"))
        return Function.EndsWith;
      if (name.equals("matches"))
        return Function.Matches;
      if (name.equals("matchesFull"))
        return Function.MatchesFull;
      if (name.equals("replaceMatches"))
        return Function.ReplaceMatches;
      if (name.equals("contains"))
        return Function.Contains;
      if (name.equals("replace"))
        return Function.Replace;
      if (name.equals("length"))
        return Function.Length;
      if (name.equals("children"))
        return Function.Children;
      if (name.equals("descendants"))
        return Function.Descendants;
      if (name.equals("memberOf"))
        return Function.MemberOf;
      if (name.equals("trace"))
        return Function.Trace;
      if (name.equals("check"))
        return Function.Check;
      if (name.equals("today"))
        return Function.Today;
      if (name.equals("now"))
        return Function.Now;
      if (name.equals("resolve"))
        return Function.Resolve;
      if (name.equals("extension"))
        return Function.Extension;
      if (name.equals("allFalse"))
        return Function.AllFalse;
      if (name.equals("anyFalse"))
        return Function.AnyFalse;
      if (name.equals("allTrue"))
        return Function.AllTrue;
      if (name.equals("anyTrue"))
        return Function.AnyTrue;
      if (name.equals("hasValue"))
        return Function.HasValue;
      if (name.equals("alias"))
        return Function.Alias;
      if (name.equals("aliasAs"))
        return Function.AliasAs;
      if (name.equals("htmlChecks"))
        return Function.HtmlChecks1;
      if (name.equals("htmlchecks"))
        return Function.HtmlChecks1; // support change of care from R3
      if (name.equals("htmlChecks2"))
        return Function.HtmlChecks2;
      if (name.equals("comparable"))
        return Function.Comparable;
      if (name.equals("encode"))
        return Function.Encode;
      if (name.equals("decode"))
        return Function.Decode;
      if (name.equals("escape"))
        return Function.Escape;
      if (name.equals("unescape"))
        return Function.Unescape;
      if (name.equals("trim"))
        return Function.Trim;
      if (name.equals("split"))
        return Function.Split;
      if (name.equals("join"))
        return Function.Join;
      if (name.equals("ofType"))
        return Function.OfType;
      if (name.equals("type"))
        return Function.Type;
      if (name.equals("toInteger"))
        return Function.ToInteger;
      if (name.equals("toDecimal"))
        return Function.ToDecimal;
      if (name.equals("toString"))
        return Function.ToString;
      if (name.equals("toQuantity"))
        return Function.ToQuantity;
      if (name.equals("toBoolean"))
        return Function.ToBoolean;
      if (name.equals("toDateTime"))
        return Function.ToDateTime;
      if (name.equals("toTime"))
        return Function.ToTime;
      if (name.equals("convertsToInteger"))
        return Function.ConvertsToInteger;
      if (name.equals("convertsToDecimal"))
        return Function.ConvertsToDecimal;
      if (name.equals("convertsToString"))
        return Function.ConvertsToString;
      if (name.equals("convertsToQuantity"))
        return Function.ConvertsToQuantity;
      if (name.equals("convertsToBoolean"))
        return Function.ConvertsToBoolean;
      if (name.equals("convertsToDateTime"))
        return Function.ConvertsToDateTime;
      if (name.equals("convertsToDate"))
        return Function.ConvertsToDate;
      if (name.equals("convertsToTime"))
        return Function.ConvertsToTime;
      if (name.equals("conformsTo"))
        return Function.ConformsTo;
      if (name.equals("round"))
        return Function.Round;
      if (name.equals("sqrt"))
        return Function.Sqrt;
      if (name.equals("abs"))
        return Function.Abs;
      if (name.equals("ceiling"))
        return Function.Ceiling;
      if (name.equals("exp"))
        return Function.Exp;
      if (name.equals("floor"))
        return Function.Floor;
      if (name.equals("ln"))
        return Function.Ln;
      if (name.equals("log"))
        return Function.Log;
      if (name.equals("power"))
        return Function.Power;
      if (name.equals("truncate"))
        return Function.Truncate;
      if (name.equals("lowBoundary"))
        return Function.LowBoundary;
      if (name.equals("highBoundary"))
        return Function.HighBoundary;
      if (name.equals("precision"))
        return Function.Precision;

      return null;
    }

    public String toCode() {
      switch (this) {
      case Empty:
        return "empty";
      case Not:
        return "not";
      case Exists:
        return "exists";
      case SubsetOf:
        return "subsetOf";
      case SupersetOf:
        return "supersetOf";
      case IsDistinct:
        return "isDistinct";
      case Distinct:
        return "distinct";
      case Count:
        return "count";
      case Where:
        return "where";
      case Select:
        return "select";
      case All:
        return "all";
      case Repeat:
        return "repeat";
      case Aggregate:
        return "aggregate";
      case Item:
        return "item";
      case As:
        return "as";
      case Is:
        return "is";
      case Single:
        return "single";
      case First:
        return "first";
      case Last:
        return "last";
      case Tail:
        return "tail";
      case Skip:
        return "skip";
      case Take:
        return "take";
      case Union:
        return "union";
      case Combine:
        return "combine";
      case Intersect:
        return "intersect";
      case Exclude:
        return "exclude";
      case Iif:
        return "iif";
      case ToChars:
        return "toChars";
      case Lower:
        return "lower";
      case Upper:
        return "upper";
      case IndexOf:
        return "indexOf";
      case Substring:
        return "substring";
      case StartsWith:
        return "startsWith";
      case EndsWith:
        return "endsWith";
      case Matches:
        return "matches";
      case MatchesFull:
        return "matchesFull";
      case ReplaceMatches:
        return "replaceMatches";
      case Contains:
        return "contains";
      case Replace:
        return "replace";
      case Length:
        return "length";
      case Children:
        return "children";
      case Descendants:
        return "descendants";
      case MemberOf:
        return "memberOf";
      case Trace:
        return "trace";
      case Check:
        return "check";
      case Today:
        return "today";
      case Now:
        return "now";
      case Resolve:
        return "resolve";
      case Extension:
        return "extension";
      case AllFalse:
        return "allFalse";
      case AnyFalse:
        return "anyFalse";
      case AllTrue:
        return "allTrue";
      case AnyTrue:
        return "anyTrue";
      case HasValue:
        return "hasValue";
      case Alias:
        return "alias";
      case AliasAs:
        return "aliasAs";
      case Encode:
        return "encode";
      case Decode:
        return "decode";
      case Escape:
        return "escape";
      case Unescape:
        return "unescape";
      case Trim:
        return "trim";
      case Split:
        return "split";
      case Join:
        return "join";
      case HtmlChecks1:
        return "htmlChecks";
      case HtmlChecks2:
        return "htmlChecks2";
      case Comparable:
        return "comparable";
      case OfType:
        return "ofType";
      case Type:
        return "type";
      case ToInteger:
        return "toInteger";
      case ToDecimal:
        return "toDecimal";
      case ToString:
        return "toString";
      case ToBoolean:
        return "toBoolean";
      case ToQuantity:
        return "toQuantity";
      case ToDateTime:
        return "toDateTime";
      case ToTime:
        return "toTime";
      case ConvertsToInteger:
        return "convertsToInteger";
      case ConvertsToDecimal:
        return "convertsToDecimal";
      case ConvertsToString:
        return "convertsToString";
      case ConvertsToBoolean:
        return "convertsToBoolean";
      case ConvertsToQuantity:
        return "convertsToQuantity";
      case ConvertsToDateTime:
        return "convertsToDateTime";
      case ConvertsToDate:
        return "convertsToDate";
      case ConvertsToTime:
        return "isTime";
      case ConformsTo:
        return "conformsTo";
      case Round:
        return "round";
      case Sqrt:
        return "sqrt";
      case Abs:
        return "abs";
      case Ceiling:
        return "ceiling";
      case Exp:
        return "exp";
      case Floor:
        return "floor";
      case Ln:
        return "ln";
      case Log:
        return "log";
      case Power:
        return "power";
      case Truncate:
        return "truncate";
      case LowBoundary:
        return "lowBoundary";
      case HighBoundary:
        return "highBoundary";
      case Precision:
        return "precision";
      default:
        return "?custom?";
      }
    }
  }

  public enum Operation {
    Equals, Equivalent, NotEquals, NotEquivalent, LessThan, Greater, LessOrEqual, GreaterOrEqual, Is, As, Union, Or,
    And, Xor, Implies, Times, DivideBy, Plus, Minus, Concatenate, Div, Mod, In, Contains, MemberOf;

    public static Operation fromCode(String name) {
      if (Utilities.noString(name))
        return null;
      if (name.equals("="))
        return Operation.Equals;
      if (name.equals("~"))
        return Operation.Equivalent;
      if (name.equals("!="))
        return Operation.NotEquals;
      if (name.equals("!~"))
        return Operation.NotEquivalent;
      if (name.equals(">"))
        return Operation.Greater;
      if (name.equals("<"))
        return Operation.LessThan;
      if (name.equals(">="))
        return Operation.GreaterOrEqual;
      if (name.equals("<="))
        return Operation.LessOrEqual;
      if (name.equals("|"))
        return Operation.Union;
      if (name.equals("or"))
        return Operation.Or;
      if (name.equals("and"))
        return Operation.And;
      if (name.equals("xor"))
        return Operation.Xor;
      if (name.equals("is"))
        return Operation.Is;
      if (name.equals("as"))
        return Operation.As;
      if (name.equals("*"))
        return Operation.Times;
      if (name.equals("/"))
        return Operation.DivideBy;
      if (name.equals("+"))
        return Operation.Plus;
      if (name.equals("-"))
        return Operation.Minus;
      if (name.equals("&"))
        return Operation.Concatenate;
      if (name.equals("implies"))
        return Operation.Implies;
      if (name.equals("div"))
        return Operation.Div;
      if (name.equals("mod"))
        return Operation.Mod;
      if (name.equals("in"))
        return Operation.In;
      if (name.equals("contains"))
        return Operation.Contains;
      if (name.equals("memberOf"))
        return Operation.MemberOf;
      return null;

    }

    public String toCode() {
      switch (this) {
      case Equals:
        return "=";
      case Equivalent:
        return "~";
      case NotEquals:
        return "!=";
      case NotEquivalent:
        return "!~";
      case Greater:
        return ">";
      case LessThan:
        return "<";
      case GreaterOrEqual:
        return ">=";
      case LessOrEqual:
        return "<=";
      case Union:
        return "|";
      case Or:
        return "or";
      case And:
        return "and";
      case Xor:
        return "xor";
      case Times:
        return "*";
      case DivideBy:
        return "/";
      case Plus:
        return "+";
      case Minus:
        return "-";
      case Concatenate:
        return "&";
      case Implies:
        return "implies";
      case Is:
        return "is";
      case As:
        return "as";
      case Div:
        return "div";
      case Mod:
        return "mod";
      case In:
        return "in";
      case Contains:
        return "contains";
      case MemberOf:
        return "memberOf";
      default:
        return "?custom?";
      }
    }
  }

  public enum CollectionStatus {
    SINGLETON, ORDERED, UNORDERED;
  }

  // the expression will have one of either name or constant
  private String uniqueId;
  private Kind kind;
  private String name;
  private Base constant;
  private Function function;
  private List<ExpressionNode> parameters; // will be created if there is a function
  private ExpressionNode inner;
  private ExpressionNode group;
  private Operation operation;
  private boolean proximal; // a proximal operation is the first in the sequence of operations. This is
                            // significant when evaluating the outcomes
  private ExpressionNode opNext;
  private SourceLocation start;
  private SourceLocation end;
  private SourceLocation opStart;
  private SourceLocation opEnd;
  private TypeDetails types;
  private TypeDetails opTypes;

  public ExpressionNode(int uniqueId) {
    super();
    this.uniqueId = Integer.toString(uniqueId);
  }

  public String toString() {
    StringBuilder b = new StringBuilder();
    switch (kind) {
    case Name:
      b.append(name);
      break;
    case Function:
      if (function == Function.Item)
        b.append("[");
      else {
        b.append(name);
        b.append("(");
      }
      boolean first = true;
      for (ExpressionNode n : parameters) {
        if (first)
          first = false;
        else
          b.append(", ");
        b.append(n.toString());
      }
      if (function == Function.Item) {
        b.append("]");
      } else {
        b.append(")");
      }
      break;
    case Constant:
      if (constant == null) {
        b.append("{}");
      } else if (constant instanceof StringType) {
        b.append("'" + Utilities.escapeJson(constant.primitiveValue()) + "'");
      } else if (constant instanceof Quantity) {
        Quantity q = (Quantity) constant;
        b.append(Utilities.escapeJson(q.getValue().toPlainString()));
        b.append(" '");
        b.append(Utilities.escapeJson(q.getUnit()));
        b.append("'");
      } else if (constant.primitiveValue() != null) {
        b.append(Utilities.escapeJson(constant.primitiveValue()));
      } else {
        b.append(Utilities.escapeJson(constant.toString()));
      }
      break;
    case Group:
      b.append("(");
      b.append(group.toString());
      b.append(")");
    }
    if (inner != null) {
      if (!((ExpressionNode.Kind.Function == inner.getKind())
          && (ExpressionNode.Function.Item == inner.getFunction()))) {
        b.append(".");
      }
      b.append(inner.toString());
    }
    if (operation != null) {
      b.append(" ");
      b.append(operation.toCode());
      b.append(" ");
      b.append(opNext.toString());
    }

    return b.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Base getConstant() {
    return constant;
  }

  public void setConstant(Base constant) {
    this.constant = constant;
  }

  public Function getFunction() {
    return function;
  }

  public void setFunction(Function function) {
    this.function = function;
    if (parameters == null)
      parameters = new ArrayList<ExpressionNode>();
  }

  public boolean isProximal() {
    return proximal;
  }

  public void setProximal(boolean proximal) {
    this.proximal = proximal;
  }

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public ExpressionNode getInner() {
    return inner;
  }

  public void setInner(ExpressionNode value) {
    this.inner = value;
  }

  public ExpressionNode getOpNext() {
    return opNext;
  }

  public void setOpNext(ExpressionNode value) {
    this.opNext = value;
  }

  public List<ExpressionNode> getParameters() {
    return parameters;
  }

  public boolean checkName() {
    if (!name.startsWith("$"))
      return true;
    else
      return Utilities.existsInList(name, "$this", "$total", "$index");
  }

  public Kind getKind() {
    return kind;
  }

  public void setKind(Kind kind) {
    this.kind = kind;
  }

  public ExpressionNode getGroup() {
    return group;
  }

  public void setGroup(ExpressionNode group) {
    this.group = group;
  }

  public SourceLocation getStart() {
    return start;
  }

  public void setStart(SourceLocation start) {
    this.start = start;
  }

  public SourceLocation getEnd() {
    return end;
  }

  public void setEnd(SourceLocation end) {
    this.end = end;
  }

  public SourceLocation getOpStart() {
    return opStart;
  }

  public void setOpStart(SourceLocation opStart) {
    this.opStart = opStart;
  }

  public SourceLocation getOpEnd() {
    return opEnd;
  }

  public void setOpEnd(SourceLocation opEnd) {
    this.opEnd = opEnd;
  }

  public String getUniqueId() {
    return uniqueId;
  }

  public int parameterCount() {
    if (parameters == null)
      return 0;
    else
      return parameters.size();
  }

  public String Canonical() {
    StringBuilder b = new StringBuilder();
    write(b);
    return b.toString();
  }

  public String summary() {
    switch (kind) {
    case Name:
      return uniqueId + ": " + name;
    case Function:
      return uniqueId + ": " + function.toString() + "()";
    case Constant:
      return uniqueId + ": " + constant;
    case Group:
      return uniqueId + ": (Group)";
    }
    return "?exp-kind?";
  }

  private void write(StringBuilder b) {

    switch (kind) {
    case Name:
      b.append(name);
      break;
    case Constant:
      b.append(constant);
      break;
    case Function:
      b.append(function.toCode());
      b.append('(');
      boolean f = true;
      for (ExpressionNode n : parameters) {
        if (f)
          f = false;
        else
          b.append(", ");
        n.write(b);
      }
      b.append(')');

      break;
    case Group:
      b.append('(');
      group.write(b);
      b.append(')');
    }

    if (inner != null) {
      b.append('.');
      inner.write(b);
    }
    if (operation != null) {
      b.append(' ');
      b.append(operation.toCode());
      b.append(' ');
      opNext.write(b);
    }
  }

  public String check() {

    if (kind == null) {
      return "Error in expression - node has no kind";
    }
    switch (kind) {
    case Name:
      if (Utilities.noString(name))
        return "No Name provided @ " + location();
      break;

    case Function:
      if (function == null)
        return "No Function id provided @ " + location();
      for (ExpressionNode n : parameters) {
        String msg = n.check();
        if (msg != null)
          return msg;
      }

      break;

    case Unary:
      break;
    case Constant:
      if (constant == null)
        return "No Constant provided @ " + location();
      break;

    case Group:
      if (group == null)
        return "No Group provided @ " + location();
      else {
        String msg = group.check();
        if (msg != null)
          return msg;
      }
    }
    if (inner != null) {
      String msg = inner.check();
      if (msg != null)
        return msg;
    }
    if (operation == null) {

      if (opNext != null)
        return "Next provided when it shouldn't be @ " + location();
    } else {
      if (opNext == null)
        return "No Next provided @ " + location();
      else
        opNext.check();
    }
    return null;

  }

  private String location() {
    return Integer.toString(start.getLine()) + ", " + Integer.toString(start.getColumn());
  }

  public TypeDetails getTypes() {
    return types;
  }

  public void setTypes(TypeDetails types) {
    this.types = types;
  }

  public TypeDetails getOpTypes() {
    return opTypes;
  }

  public void setOpTypes(TypeDetails opTypes) {
    this.opTypes = opTypes;
  }

}