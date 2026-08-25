package org.hl7.fhir.validation.codegen;
import java.io.IOException;
/*
Copyright (c) 2011+, HL7, Inc
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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.OIDUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;


public class JavaBaseGenerator extends OutputStreamWriter {

  protected Definitions definitions;
  protected Configuration config;

  /** true when generating against the versionless R6+ model (org.hl7.fhir.model) rather than org.hl7.fhir.r5 */
  protected boolean isR6() {
    return config.isR6();
  }
  protected String version;
  protected String genDate;
  protected String packageName;

  public JavaBaseGenerator(OutputStream arg0, Definitions definitions, Configuration config, String version, String genDate, String packageName) throws UnsupportedEncodingException {
    super(arg0, "UTF-8");
    this.definitions = definitions;
    this.config = config;
    this.version = version;
    this.genDate = genDate;
    this.packageName = packageName;
  }

  public void startMark(String version, String genDate) throws IOException {
    write(startLicenseValue());
  }

  /**
   * The license block, with a single blank line either side of it. The caller has already written
   * the package declaration and its line terminator, so the leading break opens the blank line and
   * the two trailing ones close the license off and open the next
   */
  public String startLicenseValue() {
    return "\r\n"+config.getLicense()+"\r\n\r\n";
  }

  /**
   * The standard marker for generated code, as an annotation on the generated type. The header
   * comment only helps a reader who is looking at the top of the file; this is what tooling sees,
   * and what is visible to anyone who lands on the class declaration itself. Written fully
   * qualified so that no template needs an import for it, and so that it cannot be shadowed by a
   * generated type that happens to be called Generated. No date - the header carries that, and a
   * second copy would just double the churn on regeneration
   */
  public String generatedAnnotationValue() {
    List<String> pl = definitions == null ? null : definitions.getPackages();
    StringBuilder b = new StringBuilder();
    b.append("@javax.annotation.processing.Generated(value = \"org.hl7.fhir.validation.codegen.LogicalModelCodeGenerator\"");
    if (pl != null && !pl.isEmpty()) {
      b.append(", comments = \"generated from "+escapeJavaString(String.join(", ", pl))+"\"");
    }
    b.append(")");
    return b.toString();
  }

  /**
   * The header comment that identifies a file as generated. It goes at the very top of the file,
   * above the package declaration, so that it is the first thing a reader (or a diff) sees.
   * The package ids and the version come from loaded definitions, so they are sanitized before
   * being embedded in the comment
   */
  public String startVMarkValue() {
    List<String> pl = definitions == null ? null : definitions.getPackages();
    StringBuilder b = new StringBuilder();
    b.append("// This file is generated code - do not edit it.\r\n");
    b.append("//\r\n");
    b.append("// Generated by the HL7 FHIR code generator (org.hl7.fhir.core: ig-codegen)\r\n");
    if (pl != null && pl.size() == 1) {
      b.append("// from "+sanitizeComment(pl.get(0))+" (version "+sanitizeComment(version)+")\r\n");
    } else if (pl != null && pl.size() > 1) {
      b.append("// from (version "+sanitizeComment(version)+"):\r\n");
      for (String p : pl) {
        b.append("//   "+sanitizeComment(p)+"\r\n");
      }
    }
    b.append("// on "+sanitizeComment(genDate)+".\r\n");
    b.append("//\r\n");
    b.append("// Any changes made here will be lost the next time the generator is run. To change\r\n");
    b.append("// this file, change the definitions it is generated from, or change the generator.\r\n");
    return b.toString();
  }


  /**
   * Text values in generated code (comments, string literals, identifiers) are frequently drawn 
   * from FHIR packages that the tooling did not author, and so must be treated as untrusted input. 
   * The methods below neutralise three classes of problem before such text is embedded in java 
   * source:
   *   1. comment breakout - a value containing a comment delimiter escaping into class-level code
   *   2. java unicode escapes - javac processes \\uXXXX sequences (even inside comments and string 
   *      literals) before tokenising, so an unescaped backslash-u in untrusted text can smuggle in 
   *      arbitrary characters (including the ones in 1 and 3)
   *   3. Trojan Source (CVE-2021-42574) - bidirectional and other invisible/format control 
   *      characters that make the source a human reviewer sees differ from what the compiler builds
   */
  protected static boolean isDangerousInvisibleChar(char c) {
    // bidirectional formatting (embeddings, overrides, isolates, marks) 
    if (c >= 0x202A && c <= 0x202E) return true; // LRE RLE PDF LRO RLO
    if (c >= 0x2066 && c <= 0x2069) return true; // LRI RLI FSI PDI
    if (c == 0x200E || c == 0x200F || c == 0x061C) return true; // LRM RLM ALM
    // zero width and other joiners / invisible spacing
    if (c == 0x200B || c == 0x200C || c == 0x200D) return true; // ZWSP ZWNJ ZWJ
    if (c == 0x2060 || c == 0xFEFF) return true; // WORD JOINER, ZWNBSP / BOM
    // anything else in the Unicode Format category, or a control character other than the plain 
    // whitespace we handle explicitly
    int type = Character.getType(c);
    if (type == Character.FORMAT) return true;
    if (type == Character.CONTROL && c != '\t' && c != '\r' && c != '\n') return true;
    return false;
  }

  /**
   * Escape a value for use inside a java string literal. Delegates to Utilities.escapeJava (which 
   * escapes the backslash, quote, CR and LF - and so also defuses java unicode escapes, since the 
   * backslash of any \\uXXXX is doubled), then converts any remaining bidirectional / invisible 
   * control characters to explicit \\uXXXX escapes so the source file is plain ascii and cannot be 
   * used to disguise the compiled content from a reviewer. The escapes round-trip to exactly the 
   * same string at runtime
   */
  protected static String escapeJavaString(String s) {
    String e = Utilities.escapeJava(s);
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < e.length(); i++) {
      char c = e.charAt(i);
      if (isDangerousInvisibleChar(c)) {
        b.append(String.format("\\u%04x", (int) c));
      } else {
        b.append(c);
      }
    }
    return b.toString();
  }

  /**
   * Neutralise a value for use inside a java comment (line or block). Line breaks and tabs are 
   * collapsed to spaces (so the value cannot terminate a // comment or reshape a block comment), 
   * bidirectional / invisible control characters are stripped (they cannot be \\uXXXX-escaped here, 
   * because javac would translate the escape back to the character inside the comment), java 
   * unicode escapes are broken by separating any backslash-u, and the comment delimiters are 
   * defused last
   */
  protected static String sanitizeComment(String text) {
    if (text == null) {
      return "";
    }
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '\r' || c == '\n' || c == '\t') {
        b.append(' ');
      } else if (isDangerousInvisibleChar(c)) {
        // strip - see method doc
      } else {
        b.append(c);
      }
    }
    return b.toString()
      .replace("\\u", "\\ u").replace("\\U", "\\ U") // break any java unicode escape (\\uXXXX)
      .replace("*/", "* /").replace("/*", "/ *");            // defuse comment delimiters
  }

  /**
   * The maximum length allowed for a generated java identifier. The JLS imposes no limit of its 
   * own, but a name longer than this is either a mistake in a definition or an attempt to break 
   * something downstream - class names become file names, and file systems do have limits
   */
  protected static final int MAX_JAVA_IDENTIFIER_LENGTH = 255;

  /**
   * How much of a refused token to quote back in an error message
   */
  private static final int MAX_RENDERED_TOKEN_LENGTH = 100;

  /**
   * Tokens that are spelled like an identifier but cannot be used as one. This is deliberately 
   * wider than {@link #isJavaReservedWord(String)} - that method is about the names the generator 
   * picks for itself, and mangles rather than refuses. This set adds:
   *   - the boolean and null literals, which are not keywords but are not available as identifiers
   *   - the lone underscore, a keyword since java 9
   *   - the contextual keywords that are restricted in type or method declaration positions. Each 
   *     of these is a legal identifier in *some* position, but a token checked here may be about to 
   *     be used in any position, so they are all refused
   * It does not include "Exception" (which {@link #isJavaReservedWord(String)} carries for its own 
   * reasons), because a field or method named Exception compiles perfectly well
   */
  private static final Set<String> UNUSABLE_JAVA_IDENTIFIERS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
      // JLS 3.9 keywords
      "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", 
      "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", 
      "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", 
      "native", "new", "package", "private", "protected", "public", "return", "short", "static", 
      "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", 
      "void", "volatile", "while",
      // JLS 3.10 literals
      "true", "false", "null",
      // JLS 3.9 - a lone underscore
      "_",
      // JLS 3.9 contextual keywords restricted in type or method declarations
      "var", "yield", "record", "sealed", "permits")));

  /**
   * True if token can be used, exactly as it stands, as an identifier anywhere in generated java 
   * source - the name of a class, method, field, parameter, enum constant or local.
   * <p>
   * This is much narrower than the JLS allows, on purpose. Java accepts any character for which 
   * {@link Character#isJavaIdentifierPart(char)} is true, and that set includes the zero width and 
   * bidirectional formatting characters that {@link #sanitizeComment(String)} strips: javac will 
   * compile two classes whose names a human reviewer cannot tell apart. It also includes ignorable 
   * control characters, which vanish entirely when the source is displayed. Since every name the 
   * generator emits derives from a FHIR definition, and those are ascii by convention, nothing is 
   * lost by requiring the token to match
   * <pre>[A-Za-z_][A-Za-z0-9_]{0,254}</pre>
   * and refusing everything else.
   * <p>
   * '$' is excluded even though it is legal java: it is the separator the compiler uses in the 
   * binary names of nested and synthetic classes, so a token containing one can collide with a 
   * class the generator never meant to name.
   * <p>
   * Restricting to ascii also settles the surrogate question - no character above U+007F is 
   * accepted, so a lone surrogate or a supplementary code point is refused by the same test as 
   * everything else, and the value can safely be walked one char at a time.
   * <p>
   * The character tests are spelled out below rather than delegated to Character or Utilities, so 
   * that the accepted set is fixed by this method and cannot be widened by a change made elsewhere 
   * for an unrelated reason
   * 
   * @param token the candidate identifier; null and empty are not safe
   * @return true if the token is a safe java identifier
   */
  protected static boolean isSafeJavaIdentifier(String token) {
    return findJavaIdentifierProblem(token) == null;
  }

  /**
   * As {@link #isSafeJavaIdentifier(String)}, but throws instead of returning false, naming both 
   * the token and the reason it was refused
   * 
   * @param token the candidate identifier
   * @param context where the value came from, e.g. "element Patient.name" - so that a failure 
   *   points at the definition that needs fixing, not at the generator
   * @throws FHIRException if the token is not a safe java identifier
   */
  protected static void checkJavaIdentifier(String token, String context) throws FHIRException {
    String problem = findJavaIdentifierProblem(token);
    if (problem != null) {
      throw new FHIRException("The value "+renderToken(token)+" ("+context+") cannot be used as a java identifier: "+problem);
    }
  }

  /**
   * The reason token is not a safe java identifier, or null if it is one
   */
  private static String findJavaIdentifierProblem(String token) {
    if (token == null) {
      return "it is null";
    }
    if (token.length() == 0) {
      return "it is empty";
    }
    if (token.length() > MAX_JAVA_IDENTIFIER_LENGTH) {
      return "it is "+token.length()+" characters long, and the limit is "+MAX_JAVA_IDENTIFIER_LENGTH;
    }
    char first = token.charAt(0);
    if (!isAsciiLetter(first) && first != '_') {
      return "the first character ("+renderChar(first)+") is not an ascii letter or an underscore";
    }
    for (int i = 1; i < token.length(); i++) {
      char c = token.charAt(i);
      if (!isAsciiLetter(c) && !isAsciiDigit(c) && c != '_') {
        return "the character at position "+i+" ("+renderChar(c)+") is not an ascii letter, digit or underscore";
      }
    }
    if (UNUSABLE_JAVA_IDENTIFIERS.contains(token)) {
      return "it is a java keyword, literal, or an identifier that is restricted in some declarations";
    }
    return null;
  }

  private static boolean isAsciiLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private static boolean isAsciiDigit(char c) {
    return c >= '0' && c <= '9';
  }

  /**
   * Quote a refused token for an error message. The token is untrusted and the message may be 
   * logged, echoed into an OperationOutcome, or read in a terminal, so anything outside printable 
   * ascii is shown as an escape rather than passed through, and the value is truncated
   */
  private static String renderToken(String token) {
    if (token == null) {
      return "(null)";
    }
    StringBuilder b = new StringBuilder();
    b.append('"');
    int len = Math.min(token.length(), MAX_RENDERED_TOKEN_LENGTH);
    for (int i = 0; i < len; i++) {
      char c = token.charAt(i);
      if (isPrintableAscii(c) && c != '"' && c != '\\') {
        b.append(c);
      } else {
        b.append(String.format("\\u%04x", (int) c));
      }
    }
    if (token.length() > MAX_RENDERED_TOKEN_LENGTH) {
      b.append("...");
    }
    b.append('"');
    return b.toString();
  }

  /**
   * Name a single refused character for an error message - see {@link #renderToken(String)} for why 
   * it is not simply printed
   */
  private static String renderChar(char c) {
    return isPrintableAscii(c) ? "'"+c+"'" : String.format("U+%04X", (int) c);
  }

  private static boolean isPrintableAscii(char c) {
    return c >= ' ' && c <= '~';
  }

  public static boolean isJavaReservedWord(String word) {
    if (word.equals("abstract")) return true;   
    if (word.equals("assert")) return true;
    if (word.equals("boolean")) return true;
    if (word.equals("break")) return true;  
    if (word.equals("byte")) return true;   
    if (word.equals("case")) return true;
    if (word.equals("catch")) return true;  
    if (word.equals("char")) return true;   
    if (word.equals("class")) return true;  
    if (word.equals("const")) return true;  
    if (word.equals("continue")) return true;   
    if (word.equals("default")) return true;
    if (word.equals("double")) return true;   
    if (word.equals("do")) return true;   
    if (word.equals("else")) return true;   
    if (word.equals("enum")) return true;   
    if (word.equals("extends")) return true;  
    if (word.equals("false")) return true;
    if (word.equals("final")) return true;  
    if (word.equals("finally")) return true;  
    if (word.equals("float")) return true;  
    if (word.equals("for")) return true;  
    if (word.equals("goto")) return true;   
    if (word.equals("if")) return true;
    if (word.equals("implements")) return true;   
    if (word.equals("import")) return true;   
    if (word.equals("instanceof")) return true;   
    if (word.equals("int")) return true;  
    if (word.equals("interface")) return true;  
    if (word.equals("long")) return true;
    if (word.equals("native")) return true;   
    if (word.equals("new")) return true;  
    if (word.equals("null")) return true;   
    if (word.equals("package")) return true;  
    if (word.equals("private")) return true;  
    if (word.equals("protected")) return true;
    if (word.equals("public")) return true;   
    if (word.equals("return")) return true;   
    if (word.equals("short")) return true;  
    if (word.equals("static")) return true;   
    if (word.equals("strictfp")) return true;   
    if (word.equals("super")) return true;
    if (word.equals("switch")) return true;   
    if (word.equals("synchronized")) return true;   
    if (word.equals("this")) return true;   
    if (word.equals("throw")) return true;  
    if (word.equals("throws")) return true;   
    if (word.equals("transient")) return true;
    if (word.equals("true")) return true;   
    if (word.equals("try")) return true;  
    if (word.equals("void")) return true;   
    if (word.equals("volatile")) return true;
    if (word.equals("while")) return true;
    if (word.equals("Exception")) return true;
    return false;
  }
 
  protected boolean isJavaPrimitive(ElementDefinition e) {
    return e.getType().size() == 1 && (isPrimitive(e.getType().get(0).getWorkingCode()));
  }

  protected boolean isPrimitive(String name) {
    return definitions.isPrimitive(name);
  }


  protected static String getElementName(String name, boolean alone) {
	  if (name.equals("[type]"))
	    return "value";
	  else if ((alone && isJavaReservedWord(name)) || (!alone && name.equals("class")))
	    return name+"_";
	  else if (name.equals("[x]"))
      return "value";
	  else
	    return name.replace("[x]", "");
	}

	protected String getTypeName(ElementDefinition e) throws Exception {
		if (e.getType().size() > 1) {
			return "DataType";
		} else if (e.getType().size() == 0) {
			throw new Exception("not supported");
		} else {
			return getTypename(e.getType().get(0));
		}
	}

	protected String getTypename(TypeRefComponent type) throws Exception {
	  if (type.hasExtension(ExtensionDefinitions.EXT_FHIR_TYPE)) {
	    return type.getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE);
	  } else {
		  String code = type.getCode();
		  if (Utilities.isAbsoluteUrl(code)) {
		    code = Utilities.urlTail(code);
		  }
      return getTypeName(code);
	  }
	}

	protected String getTypeName(String tn) {
		if (tn.equals("string")) {
			return "StringType";
		} else if (tn.equals("Any")) {
			return "Reference";
    } else if (tn.equals("SimpleQuantity")) {
      return "Quantity";
    } else if (isPrimitive(tn)) {
      return getTitle(tn)+"Type";
		} else {
		  if (tn.contains("-")) {
		    tn = tn.replace("-", "_");
		  }
			return getTitle(tn);
		}
	}

	protected String getTitle(String name) {
		return Utilities.noString(name) ? "Value" : name.substring(0, 1).toUpperCase()+ name.substring(1);
	}


  protected List<ConceptDefinitionComponent> listAllCodes(CodeSystem cs) {
    List<ConceptDefinitionComponent> result = new ArrayList<ConceptDefinitionComponent>();
    addAllCodes(result, cs.getConcept());
    return result;
  }

  private void addAllCodes(List<ConceptDefinitionComponent> result, List<ConceptDefinitionComponent> concept) {
    for (ConceptDefinitionComponent c : concept) {
      result.add(c);
      addAllCodes(result, c.getConcept());
    }
  }

  protected String makeConst(String cc) {
    if (cc.equals("*"))
      cc = "ASTERISK";
    if (OIDUtilities.isValidOID(cc) && Utilities.charCount(cc, '.') > 2)
      cc = "OID_"+cc;
    if (cc.equals("%"))
      cc = "pct";
    else if (cc.equals("<"))
      cc = "less_Than";
    else if (cc.equals("<="))
      cc = "less_Or_Equal";
    else if (cc.equals(">"))
      cc = "greater_Than";
    else if (cc.equals(">="))
      cc = "greater_Or_Equal";
    else if (cc.equals("="))
      cc = "equal";
    else if (cc.equals("!="))
      cc = "not_equal";
    else if (allPlusMinus(cc))
      cc = cc.replace("-", "Minus").replace("+", "Plus");
    else
      cc = cc.replace("-", "").replace("+", "");
    cc = cc.replace("(", "_").replace(")", "_");
    cc = cc.replace("{", "_").replace("}", "_");
    cc = cc.replace("<", "_").replace(">", "_");
    cc = cc.replace(".", "_").replace("/", "_");
    cc = cc.replace(":", "_");
    cc = cc.replace("%", "pct");
    if (Utilities.isInteger(cc.substring(0, 1)))
      cc = "_"+cc;
    cc = cc.toUpperCase();
    if (isJavaReservedWord(cc))
      cc = cc + "_";
    return cc;
  }

  private boolean allPlusMinus(String cc) {
    for (char c : cc.toCharArray())
      if (!(c == '-' || c == '+'))
        return false;
    return true;
  }

  protected boolean isEnum(ElementDefinitionBindingComponent cd) {
    boolean ok = cd != null && cd.getStrength() == BindingStrength.REQUIRED;
    if (ok) {
      if (cd.getValueSet() != null) {
        ValueSet vs = definitions.getValuesets().get(cd.getValueSet()); 
        if (vs != null && vs.hasCompose() && vs.getCompose().getInclude().size() == 1) {
          ConceptSetComponent inc = vs.getCompose().getIncludeFirstRep();
          if (inc.hasSystem() && !inc.hasFilter() && !inc.hasConcept() && !(inc.getSystem().startsWith("http://hl7.org/fhir") || inc.getSystem().startsWith("http://terminology.hl7.org")))
            ok = false;
        }
      }
    }
    return ok;
  }

  protected String getCodeListType(String binding) {
    StringBuilder b = new StringBuilder();
    boolean up = true;
    for (char ch: binding.toCharArray()) {
      if (ch == '-' || ch == ' ' || ch == '.')
        up = true;
      else if (up) {
        b.append(Character.toUpperCase(ch));
        up = false;
      }
      else        
        b.append(ch);
    }
    return "ResourceType".equals(b.toString()) ? "ResourceTypeEnum" : b.toString();
  }
  
  
  protected ElementDefinition matchingInheritedElement(List<ElementDefinition> children, ElementDefinition m, String name) {
    if (VersionUtilities.isR4BVer(version)) {
      if (m.getPath().endsWith(".identifier") && Utilities.charCount(m.getPath(), '.') == 1 && !Utilities.noString(config.getIni().getStringProperty("R4B.CanonicalResources", name))) {
        ElementDefinition inh = new ElementDefinition();
        inh.setMax("*");
        return inh;
      }
    }
    if (children == null) {
      return null;
    }
    String mtail = m.getPath().substring(m.getPath().indexOf("."));
    for (ElementDefinition t : children) {
      String ttail = t.getPath().substring(t.getPath().indexOf("."));
      if (ttail.equals(mtail)) {
        return t;
      }
      
    }
    return null;
  }

  protected boolean isNamedElementExtensions(ElementDefinition ed) {
    return "named-elements".equals(ed.getExtensionString(ExtensionDefinitions.EXT_EXTENSION_STYLE_NEW, ExtensionDefinitions.EXT_EXTENSION_STYLE_DEPRECATED));
  }

  /**
   * true if the element's (single) type resolves to an abstract class in the set being 
   * generated. Such a type gets its own xsi:type dispatcher from genInnerAbstract, with 
   * the same name and signature a type-specifier dispatcher for an element of the type 
   * would get - so the type-specifier emission is skipped for these elements (the 
   * abstract dispatcher covers all the concrete descendents)
   */
  protected boolean isAbstractGeneratedType(ElementDefinition ed) {
    if (ed.getType().size() != 1) {
      return false;
    }
    String code = ed.getTypeFirstRep().getWorkingCode();
    StructureDefinition sd = definitions.getStructures().get(code);
    if (sd == null) {
      sd = definitions.getStructures().get("http://hl7.org/fhir/StructureDefinition/"+code);
    }
    return sd != null && sd.getAbstract() && !sd.hasUserData(Definitions.CORE_MARKER);
  }

  /**
   * true if any element in the generated set carries a type-specifier extension and is 
   * declared with the given analysis's (abstract) type. For such types the JSON composer's 
   * type-specifier machinery generates the compose dispatcher (instanceof-based, matching 
   * the condition-based parse dispatch, with no _type property on the wire), so the generic 
   * abstract _type-protocol dispatcher must not also be generated - same name and signature
   */
  protected boolean isTypeSpecifierTarget(Analysis analysis) {
    String url = analysis.getStructure().getUrl();
    for (StructureDefinition sd : definitions.getStructures().getList()) {
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        if (ed.hasExtension(ExtensionDefinitions.EXT_TYPE_SPEC) && ed.getType().size() == 1 
            && url.equals(ed.getTypeFirstRep().getWorkingCode())) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Get the expansion to enumerate a (required-binding) value set from, for generating an 
   * enum. In order: an expansion already attached by the loader (UserDataNames.EXPANSION); 
   * an expansion built directly from the code system definitions in the loaded packages, 
   * where the compose is simple enough (all-codes or enumerated includes of complete code 
   * systems, no filters/imports/excludes) - this covers IG-defined enums without a 
   * terminology server round trip; failing those, a terminology service expansion. 
   * Returns null if none of these produce an expansion
   */
  protected ValueSet expandValueSet(ValueSet vs) {
    ValueSet vse = (ValueSet) vs.getUserData(UserDataNames.EXPANSION);
    if (vse == null) {
      vse = expandFromCodeSystems(vs);
    }
    if (vse == null) {
      ValueSetExpansionOutcome vsex = definitions.getContext().expandVS(vs, true, false);
      if (vsex.isOk()) {
        vse = vsex.getValueset();
      }
    }
    return vse;
  }

  private ValueSet expandFromCodeSystems(ValueSet vs) {
    if (!vs.hasCompose() || vs.getCompose().hasExclude()) {
      return null;
    }
    ValueSet res = new ValueSet();
    res.setUrl(vs.getUrl());
    res.setVersion(vs.getVersion());
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      if (inc.hasFilter() || inc.hasValueSet() || !inc.hasSystem()) {
        return null;
      }
      CodeSystem cs = definitions.getCodeSystems().get(inc.getSystem());
      if (cs == null) {
        cs = definitions.getContext().fetchResource(CodeSystem.class, inc.getSystem());
      }
      if (cs == null || cs.getContent() != Enumerations.CodeSystemContentMode.COMPLETE) {
        return null;
      }
      if (inc.hasConcept()) {
        for (ConceptReferenceComponent c : inc.getConcept()) {
          ConceptDefinitionComponent d = cs.getDefinitionByCode(c.getCode());
          res.getExpansion().addContains().setSystem(inc.getSystem()).setCode(c.getCode())
              .setDisplay(c.hasDisplay() ? c.getDisplay() : (d == null ? null : d.getDisplay()));
        }
      } else {
        addAllCodes(res, cs, inc.getSystem(), cs.getConcept());
      }
    }
    return res.getExpansion().hasContains() ? res : null;
  }

  private void addAllCodes(ValueSet res, CodeSystem cs, String system, List<ConceptDefinitionComponent> concepts) {
    for (ConceptDefinitionComponent c : concepts) {
      if (!CodeSystemUtilities.isNotSelectable(cs, c)) {
        res.getExpansion().addContains().setSystem(system).setCode(c.getCode()).setDisplay(c.getDisplay());
      }
      addAllCodes(res, cs, system, c.getConcept());
    }
  }

  protected Map<String, String> getConcreteDescendents(Analysis analysis, TypeInfo ti) {
    Map<String, String> types = new HashMap<String, String>();
    List<StructureDefinition> list = new ArrayList<>();
    for (StructureDefinition sd : definitions.getStructures().getList()) {
      // todo: do we need to check for transitive children?
      if (analysis.getStructure().getUrl().equals(sd.getBaseDefinition()) && !sd.getAbstract()) {
        list.add(sd);
      }
    }
    for (StructureDefinition sd : list) {
      if (sd.getName().contains("_")) {
        // temporary openEHR hack?
        types.put(sd.getName().replace("_", "-"), sd.getName());
      } else {
        types.put(sd.getName(), sd.getName());
      }
    }
    return types;
  }
  
  protected boolean isCoreType(StructureDefinition sd) {
    return sd != null && sd.hasUrl() && sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition");
  }
}