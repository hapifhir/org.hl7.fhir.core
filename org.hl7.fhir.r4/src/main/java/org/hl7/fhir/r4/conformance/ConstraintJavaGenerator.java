package org.hl7.fhir.r4.conformance;

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



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.utilities.Utilities;

public class ConstraintJavaGenerator {

  private IWorkerContext context; // for doing expansions
  private String version; // for getting includes correct
  private String folder; //dest dir where the profile will be generated into
  private String packageName;
  
  public ConstraintJavaGenerator(IWorkerContext context, String version, String folder, String packageName) {
    super();
    this.context = context;
    this.version = version;
    this.folder = folder;
    this.packageName = packageName;
  }

  public String generate(StructureDefinition sd) throws FHIRException, IOException {
    String name = sd.hasName() ? Utilities.titleize(sd.getName().replace(".", "").replace("-", "").replace("\"", "")).replace(" ", "") : "";
    if (!Utilities.nmtokenize(name).equals(name)) {
      System.out.println("Cannot generate Java code for profile "+sd.getUrl()+" because the name \""+name+"\" is not a valid Java class name");
      return null;
    }
    File destFile = new File(Utilities.path(folder, name+".java"));
    OutputStreamWriter dest = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
    
    dest.write("package "+packageName+";\r\n");
    dest.write("\r\n");
    dest.write("import org.hl7.fhir.r4.model.ProfilingWrapper;\r\n");
    dest.write("\r\n");
    dest.write("public class "+name+" {\r\n");
    dest.write("\r\n");
    
    dest.write("}\r\n");
    dest.flush();
    dest.close();
    return destFile.getAbsolutePath();
  }
  
}