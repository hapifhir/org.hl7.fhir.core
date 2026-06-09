package org.hl7.fhir.r5.elementmodel;

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



import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.turtle.Turtle.Complex;
import org.hl7.fhir.utilities.turtle.Turtle.Subject;


@MarkedToMoveToAdjunctPackage
public class TurtleParserR6 extends TurtleParserBase {

  public TurtleParserR6(IWorkerContext context) {
    super(context);
  }

  protected String getReferenceURI(String ref) {
    if (ref != null && (ref.startsWith("http://") || ref.startsWith("https://") || ref.startsWith("urn:") || ref.startsWith("#")))
      return "<" + ref + ">";
    else if (base != null && ref != null && ref.contains("/"))
      return "<" + Utilities.appendForwardSlash(base) + ref + ">";
    else if (ref != null) {
        return "fhir:" + ref;
    } else return null;
  }

  @Override
  protected String getReferencePredicate() {
    return FHIR_BASE_PREFIX + "l";
  }

  @Override
  protected void composeResourceMetadata(Subject subject, Element resource) throws FHIRException {
    if (ExtensionUtilities.readBoolExtension(resource.getProperty().getStructure(), ExtensionDefinitions.EXT_ADDITIONAL_RESOURCE)) {
      subject.linkedPredicate("fhir:resourceDefinition", resource.getProperty().getStructure().getVersionedUrl(), null, null);
    }
  }

  @Override
  protected void decoratePrimitiveValue(Complex t, Element element) {
    if (Utilities.existsInList(element.getType(), "canonical", "oid", "uri", "url", "uuid")) {
      linkURI(t, element.primitiveValue(), element.getType());
    }
  }

  @Override
  protected String className(String element) {
    return getClassName(element);
  }

  public static String getClassName(String element) {
    if (element == null || element.isEmpty()) {
      return element;
    }
    // Uppercase first letter
    return element.substring(0, 1).toUpperCase() + element.substring(1);
  }

  private void linkURI(Complex t, String value, String type) {
    if (value == null) {
      return;
    }
    String versioned = value;
    if (versioned.contains("|")) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //single literal character split
      String[] parts = versioned.split("\\|", 2);
      String url = parts[0];
      String version = parts[1];
      String separator = url.contains("?") ? "&" : "?";
      versioned = url + separator + "version=" + version;
    }
    String refURI = getReferenceURI(versioned);
    if (refURI != null) {
      t.linkedPredicate(getReferencePredicate(), refURI, linkResolver == null ? null : linkResolver.resolveType(type), null);
    }
  }
}