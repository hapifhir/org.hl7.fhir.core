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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.OIDUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;


public class JavaBaseGenerator extends OutputStreamWriter {

  protected Definitions definitions;
  protected Configuration config;
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
    write(startVMarkValue());
  }

  public String startLicenseValue() {
    return "\r\n\r\n"+config.getLicense()+"\r\n\r\n";
  }

  public String startVMarkValue() {
//    return "// Generated on "+genDate+" for FHIR v"+version+"\r\n\r\n";
    return "// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0\r\n\r\n";
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


  protected String getElementName(String name, boolean alone) {
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