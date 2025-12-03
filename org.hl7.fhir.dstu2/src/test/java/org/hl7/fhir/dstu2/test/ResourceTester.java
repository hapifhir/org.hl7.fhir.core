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
package org.hl7.fhir.dstu2.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.dstu2.formats.IParser;
import org.hl7.fhir.dstu2.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2.formats.JsonParser;
import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.Resource;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class ResourceTester {

  private File source;
  private boolean json;

  public File getSource() {
    return source;
  }

  public void setSource(File source) {
    this.source = source;
  }

  public void test() throws FHIRFormatError, IOException {

    IParser parser;
    if (isJson())
      parser = new JsonParser();
    else
      parser = new XmlParser(false);
    Resource resource = parser.parse(ManagedFileAccess.inStream(source));

    FileOutputStream out = ManagedFileAccess.outStream(source.getAbsoluteFile() + ".out.json");
    JsonParser jsonPrettyParser = new JsonParser();
    jsonPrettyParser.setOutputStyle(OutputStyle.PRETTY);
    jsonPrettyParser.compose(out, resource);
    out.close();

    JsonParser jsonParser = new JsonParser();
    resource = jsonParser.parse(ManagedFileAccess.inStream(source.getAbsoluteFile() + ".out.json"));

    out = ManagedFileAccess.outStream(source.getAbsoluteFile() + ".out.xml");
    XmlParser xmlParser = new XmlParser();
    xmlParser.setOutputStyle(OutputStyle.PRETTY);
    xmlParser.compose(out, resource, true);
    out.close();

  }

  public boolean isJson() {
    return json;
  }

  public void setJson(boolean json) {
    this.json = json;
  }

}