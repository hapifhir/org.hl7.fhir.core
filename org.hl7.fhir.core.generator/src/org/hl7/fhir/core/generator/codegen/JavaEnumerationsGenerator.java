package org.hl7.fhir.core.generator.codegen;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;

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

/*
changes for James
- lazy construction of lists
- getX will construct if null
- add hasX
  
*/
public class JavaEnumerationsGenerator extends JavaBaseGenerator {
  
  public JavaEnumerationsGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate);
  }
  
	public void generate() throws Exception {		
		write("package org.hl7.fhir.r5.model;\r\n");
    startMark(version, genDate);
    write("\r\n");
    write("import org.hl7.fhir.instance.model.api.*;\r\n");
    write("import org.hl7.fhir.exceptions.FHIRException;\r\n");
    write("\r\n");

    write("public class Enumerations {\r\n");
    write("\r\n");
    write("// In here: \r\n");
		
    Map<String, ValueSet> enums = scanForEnums();
    List<String> names = new ArrayList<String>();
    names.addAll(enums.keySet());
    Collections.sort(names);
    for (String n : names) {
      ValueSet vs = enums.get(n);
      write("//   "+n+": "+vs.getDescription());
      if (vs.hasUserData("usages")) {
        write(vs.getUserData("usages").toString());
      } else {
        write("?null?");        
      }
      write("\r\n");
    }
    write("\r\n");
    write("\r\n");
    for (String n : names) {
      ValueSet vs = enums.get(n);
      generateEnum(n, (ValueSet) vs.getUserData("expansion"));
		}
		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();
	}

	private Map<String, ValueSet> scanForEnums() {
	  Map<String, ValueSet> res = new HashMap<>();
    for (ValueSet vs : definitions.getValuesets().getSortedList()) {
      if (vs.hasUserData("shared") && vs.hasUserData("expansion")) {
        res.put(getCodeListType(vs.getName()), vs);
      }
    }
    return res;
  }


	 
  private void generateEnum(String name, ValueSet vs) throws Exception {
    String url = vs.getUrl();
    CommaSeparatedStringBuilder el = new CommaSeparatedStringBuilder();

		write("    public enum "+name+" {\r\n");
		int l = vs.getExpansion().getContains().size();
		int i = 0;
		for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
				i++;
				String cc = Utilities.camelCase(c.getCode());
	      cc = makeConst(cc);
	      el.append(cc);

	      write("        /**\r\n");
	      write("         * "+definitions.getCodeDefinition(c.getSystem(), c.getCode())+"\r\n");
	      write("         */\r\n");      
				write("        "+cc.toUpperCase()+", \r\n");
			}
    write("        /**\r\n");
    write("         * added to help the parsers\r\n");
    write("         */\r\n");      
    write("        NULL;\r\n");
    el.append("NULL");


		write("        public static "+name+" fromCode(String codeString) throws FHIRException {\r\n");
		write("            if (codeString == null || \"\".equals(codeString))\r\n");
		write("                return null;\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
				String cc = Utilities.camelCase(c.getCode());
				cc = makeConst(cc);
				write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
				write("          return "+cc+";\r\n");
			}
		write("        throw new FHIRException(\"Unknown "+name+" code '\"+codeString+\"'\");\r\n");
		write("        }\r\n");	

		write("        public String toCode() {\r\n");
		write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
				String cc = Utilities.camelCase(c.getCode());
	      cc = makeConst(cc);
				write("            case "+cc+": return \""+c.getCode()+"\";\r\n");
			}
		write("            default: return \"?\";\r\n");
		write("          }\r\n"); 
		write("        }\r\n"); 

    write("        public String getSystem() {\r\n");
    write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("            case "+cc+": return \""+c.getSystem()+"\";\r\n");
    }
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getDefinition() {\r\n");
    write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
	      String cc = Utilities.camelCase(c.getCode());
	      cc = makeConst(cc);
	      write("            case "+cc+": return \""+Utilities.escapeJava(definitions.getCodeDefinition(c.getSystem(), c.getCode()))+"\";\r\n");
			}
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getDisplay() {\r\n");
    write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
	      String cc = Utilities.camelCase(c.getCode());
	      cc = makeConst(cc);
	      write("            case "+cc+": return \""+Utilities.escapeJava(Utilities.noString(c.getDisplay()) ? c.getCode() : c.getDisplay())+"\";\r\n");
			}
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    if (config.getAdornments().containsKey(name)) {
      write("// manual code from configuration.txt:\r\n");
      write(config.getAdornments().get(name)+"\r\n");
      write("// end addition\r\n");
    }

		write("    }\r\n");
		write("\r\n");

		
		write("  public static class "+name+"EnumFactory implements EnumFactory<"+name+"> {\r\n");
		write("    public "+name+" fromCode(String codeString) throws IllegalArgumentException {\r\n");
		
		write("      if (codeString == null || \"\".equals(codeString))\r\n");
    write("            if (codeString == null || \"\".equals(codeString))\r\n");
    write("                return null;\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
	      String cc = Utilities.camelCase(c.getCode());
	      cc = makeConst(cc);
	      write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
	      write("          return "+name+"."+cc+";\r\n");
			}
    write("        throw new IllegalArgumentException(\"Unknown "+name+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 
    write("        public Enumeration<"+name+"> fromType(Base code) throws FHIRException {\r\n");
    write("          if (code == null)\r\n");
    write("            return null;\r\n");
    write("          if (code.isEmpty())\r\n");
    write("            return new Enumeration<"+name+">(this);\r\n");
    write("          String codeString = ((PrimitiveType) code).asStringValue();\r\n");
    write("          if (codeString == null || \"\".equals(codeString))\r\n");
    write("            return null;\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
      write("          return new Enumeration<"+name+">(this, "+name+"."+cc+");\r\n");
    }   
    write("        throw new FHIRException(\"Unknown "+name+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 
    write("    public String toCode("+name+" code) {\r\n");
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
	      String cc = Utilities.camelCase(c.getCode());
	      cc = makeConst(cc);
	      write("      if (code == "+name+"."+cc+")\r\n        return \""+c.getCode()+"\";\r\n");
    }
    write("      return \"?\";\r\n"); 
    write("      }\r\n");
    
    write("    public String toSystem("+name+" code) {\r\n");
    write("      return code.getSystem();\r\n");
    write("      }\r\n"); 

    write("    }\r\n"); 
    write("\r\n");
	}

}