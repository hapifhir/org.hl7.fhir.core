package org.hl7.fhir.core.generator.codegen;
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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.core.generator.analysis.TypeInfo;
import org.hl7.fhir.core.generator.codegen.JavaBaseGenerator;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.ImplementationGuide.SPDXLicense;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;



public class JavaFactoryGenerator extends JavaBaseGenerator {

  
  public JavaFactoryGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate);
  }

	public void generate() throws Exception {
	  String template = config.getAdornments().get("ResourceFactory");
	  template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());
    template = template.replace("{{resource-factory}}", genResourceFactory());
    template = template.replace("{{type-factory}}", genTypeFactory());
    template = template.replace("{{case-factory}}", genCaseFactory());
    write(template);
		flush();
		close();
	}
	

  private String genResourceFactory() {
    StringBuilder b = new StringBuilder();
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        String tn = ((TypeInfo) sd.getUserData("java.type.info")).getName();
        b.append("        if (\""+sd.getName()+"\".equals(name))\r\n");
        b.append("            return new "+tn+"();\r\n");
      }
    }
    
    return b.toString();
  }

  private String genTypeFactory() {
    StringBuilder b = new StringBuilder();
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.COMPLEXTYPE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        String tn = ((TypeInfo) sd.getUserData("java.type.info")).getName();
        b.append("        if (\""+sd.getName()+"\".equals(name))\r\n");
        b.append("            return new "+tn+"();\r\n");
      }
    }
    
    return b.toString();
  }

  private String genCaseFactory() {
    StringBuilder b = new StringBuilder();
    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        String tn = ((TypeInfo) sd.getUserData("java.type.info")).getName();
        b.append("        case "+Integer.toString(sd.getName().hashCode())+": return new "+tn+"();\r\n");
      }
    }

    for (StructureDefinition sd : definitions.getStructures().getSortedList()) {
      if (sd.getKind() == StructureDefinitionKind.COMPLEXTYPE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && !sd.getAbstract()) {
        String tn = ((TypeInfo) sd.getUserData("java.type.info")).getName();
        b.append("        case "+Integer.toString(sd.getName().hashCode())+": return new "+tn+"();\r\n");
      }
    }
    
    return b.toString();
  }

}