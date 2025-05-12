package org.hl7.fhir.validation.codegen;
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
import java.io.UnsupportedEncodingException;

public class JavaParserGenerator extends JavaBaseGenerator {

  private StringBuilder register = new StringBuilder();
  private String jname;

  public JavaParserGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String packageName, String jname) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, packageName);
    this.jname = jname;
  }

  public void seeClass(Analysis analysis) throws Exception {
    generateParser(analysis);
  }
  
  public void generate() throws Exception {
    
    String template = config.getAdornments().get("Parser");
    template = template.replace("{{pid}}", packageName);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{jname}}", jname);
    template = template.replace("{{register}}", register.toString());

    write(template);
    flush();
    close();
  }
  

  private void generateParser(Analysis analysis) throws Exception {
    if (analysis.getAncestor().getName().equals("Resource")) {
      register.append("    org.hl7.fhir.r5.formats.JsonParser.getCustomResourceHandlers().put(\""+analysis.getName()+"\", new "+jname+"JsonParserFactory());\r\n");
    }
  }

}