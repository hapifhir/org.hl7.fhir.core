package org.hl7.fhir.services.elementmodel;

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


import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.context.ContextUtilities;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.utilities.formats.OutputStyle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


public class Manager {

  public static List<ValidatedFragment> parse(IWorkerContext context, InputStream source, FhirFormat inputFormat) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    return makeParser(context, inputFormat).parse(source);
  }

  public static Element parseSingle(IWorkerContext context, InputStream source, FhirFormat inputFormat) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    return makeParser(context, inputFormat).parseSingle(source, null);
  }
  

  public static void compose(IWorkerContext context, Element e, OutputStream destination, FhirFormat outputFormat, OutputStyle style, String base) throws FHIRException, IOException {
    makeParser(context, outputFormat).compose(e, destination, style, base);
  }

  public static ParserBase makeParser(IWorkerContext context, FhirFormat format) {
    if (format == null) {
      throw new Error("Programming logic error: no format known");
    }
    switch (format) {
    case JSON : return new JsonParser(context);
    case NDJSON : return new NDJsonParser(context);
    case XML : return new XmlParser(context);
    case TURTLE : return new TurtleParser(context);
    case VBAR : return new VerticalBarParser(context);
    case SHC : return new SHCParser(context);
    case SHL : return new SHLParser(context);
    case FML : return new FmlParser(context, null);
    case TEXT : throw new Error("Programming logic error: do not call makeParser for a text resource");
    }
    return null;
  }
  
  public static Element build(IWorkerContext context, StructureDefinition sd) {
    return build(context, sd, new ProfileUtilities(context, null, null));
  }
  
  public static Element build(IWorkerContext context, StructureDefinition sd, ProfileUtilities profileUtilities) {
    Property p = new Property(context, sd.getSnapshot().getElementFirstRep(), sd, profileUtilities, new ContextUtilities(context));
    Element e = new Element(p.getName(), p);
    e.setPath(sd.getType());
    return e;
  }

}