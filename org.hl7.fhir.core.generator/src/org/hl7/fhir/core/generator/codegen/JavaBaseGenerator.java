package org.hl7.fhir.core.generator.codegen;
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
import java.util.Date;
import java.util.List;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.Utilities;


public class JavaBaseGenerator extends OutputStreamWriter {

  protected Definitions definitions;
  protected Configuration config;
  protected String version;
  protected Date genDate;

  public JavaBaseGenerator(OutputStream arg0, Definitions definitions, Configuration config, String version, Date genDate) throws UnsupportedEncodingException {
    super(arg0, "UTF-8");
    this.definitions = definitions;
    this.config = config;
    this.version = version;
    this.genDate = genDate;
  }

  public void startMark(String version, Date genDate) throws IOException {
    write(startLicenseValue());
    write(startVMarkValue());
  }

  public String startLicenseValue() {
    return "\r\n\r\n"+config.getLicense()+"\r\n\r\n";
  }

  public String startVMarkValue() {
    return "// Generated on "+config.DATE_FORMAT().format(genDate)+" for FHIR v"+version+"\r\n\r\n";
//    return "// Generated on Thu, Dec 13, 2018 14:07+1100 for FHIR v4.0.0\r\n\r\n";
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
    return definitions.getStructures().has(typeNs(name)) && definitions.getStructures().get(typeNs(name)).getKind() == StructureDefinitionKind.PRIMITIVETYPE;
  }

	private String typeNs(String name) {
    return "http://hl7.org/fhir/StructureDefinition/"+name;
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
	  if (type.hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type")) {
	    return type.getExtensionString("http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type");
	  } else {
		  return getTypeName(type.getCode());
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
    if (Utilities.isOid(cc))
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
  
  
  protected ElementDefinition matchingInheritedElement(List<ElementDefinition> children, ElementDefinition m) {
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

  

}
