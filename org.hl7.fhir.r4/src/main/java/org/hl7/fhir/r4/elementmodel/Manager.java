package org.hl7.fhir.r4.elementmodel;

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



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.model.StructureDefinition;

public class Manager {

  public enum FhirFormat { XML, JSON, TURTLE, TEXT, VBAR;

    public String getExtension() {
      switch (this) {
      case JSON:
        return "json";
      case TURTLE:
        return "ttl";
      case XML:
        return "xml";
      case TEXT:
        return "txt";
      case VBAR:
        return "hl7";
      }
      return null;
    }
  }
  
  public static Element parse(IWorkerContext context, InputStream source, FhirFormat inputFormat) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    return makeParser(context, inputFormat).parse(source);
  }

  public static void compose(IWorkerContext context, Element e, OutputStream destination, FhirFormat outputFormat, OutputStyle style, String base) throws FHIRException, IOException {
    makeParser(context, outputFormat).compose(e, destination, style, base);
  }

  public static ParserBase makeParser(IWorkerContext context, FhirFormat format) {
    switch (format) {
    case JSON : return new JsonParser(context);
    case XML : return new XmlParser(context);
    case TURTLE : return new TurtleParser(context);
    case VBAR : return new VerticalBarParser(context);
    case TEXT : throw new Error("Programming logic error: do not call makeParser for a text resource");
    }
    return null;
  }
  
  public static Element build(IWorkerContext context, StructureDefinition sd) {
    Property p = new Property(context, sd.getSnapshot().getElementFirstRep(), sd);
    Element e = new Element(null, p);
    return e;
  }

}