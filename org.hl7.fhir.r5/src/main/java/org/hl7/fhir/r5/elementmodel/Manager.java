package org.hl7.fhir.r5.elementmodel;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.StructureDefinition;

public class Manager {

  //TODO use EnumMap
  public enum FhirFormat {
    XML("xml"),
    JSON("json"),
    TURTLE("ttl"),
    TEXT("txt"),
    VBAR("hl7");

    final String extension;

    FhirFormat(String extension) {
      this.extension = extension;
    }

    public String getExtension() {
      return this.extension;
    }

    private static final Map<String, FhirFormat> lookup = new HashMap<>();

    static {
      for(FhirFormat ff : FhirFormat.values()) {
        lookup.put(ff.getExtension(), ff);
      }
    }

    public static FhirFormat get(String extension) {
      return lookup.get(extension);
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
