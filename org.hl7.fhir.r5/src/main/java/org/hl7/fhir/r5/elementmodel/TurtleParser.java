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



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.VersionUtilities;


@MarkedToMoveToAdjunctPackage
public class TurtleParser extends TurtleParserBase {

  // `volatile` so the one-shot lazy publish of the R6 delegate is visible across threads.
  // Per-call setting sync below is intentionally NOT synchronized: the inherited ParserBase
  // setters/fields aren't thread-safe to begin with, and parse()/compose() mutate other
  // instance state that isn't guarded either, so adding a lock here would imply a guarantee
  // we can't actually deliver. Concurrent mutation of a single parser instance is unsupported.
  private volatile TurtleParserR6 r6Parser;

  /** R5 Turtle Parser with optional redirect to TurtleParserR6 */
  public TurtleParser(IWorkerContext context) {
    super(context);
  }

  TurtleParserR6 r6Parser() {
    TurtleParserR6 parser = r6Parser;
    if (parser == null) {
      // `synchronized` ensures only one thread creates the delegate and publishes it safely,
      // so a racing first-time R6 caller can't silently lose a delegate (and its initial setup).
      synchronized (this) {
        parser = r6Parser;
        if (parser == null) {
          parser = new TurtleParserR6(context);
          r6Parser = parser;
        }
      }
    }
    syncR6ParserState();
    return parser;
  }

  /**
   * Copy outer parser settings into the R6 delegate so it sees the same configuration.
   * Not synchronized by design — see the note on {@link #r6Parser}.
   */
  private void syncR6ParserState() {
    r6Parser.setupValidation(policy);
    r6Parser.setLinkResolver(linkResolver);
    r6Parser.setShowDecorations(showDecorations);
    r6Parser.setIdPolicy(idPolicy);
    r6Parser.setLogical(logical);
    r6Parser.setSignatureServices(signatureServices);
    r6Parser.canonicalFilter = canonicalFilter;
    r6Parser.setStyle(getStyle());
  }

  @Override
  public List<ValidatedFragment> parse(InputStream inStream) throws IOException, FHIRException {
    // Redirect cross-version parsing
    String fhirVersion = context.getVersion();
    if ( VersionUtilities.isR6Ver(fhirVersion) ) {
      return r6Parser().parse(inStream); 
    }

    if (VersionUtilities.isR5Ver(fhirVersion)) {
      return super.parse(inStream);
    }

    throw new FHIRException("Turtle parsing for versions under R5 is not supported in this module. Use the appropriate module. (R4, DSTU3, etc)");
  }

  @Override
  public void compose(Element e, OutputStream stream, OutputStyle style, String base) throws IOException, FHIRException {
    // Redirect cross-version serialization
    String fhirVersion = context.getVersion();
    if ( VersionUtilities.isR6Ver(fhirVersion) ) {
      r6Parser().compose(e, stream, style, base);
    } else {
      super.compose(e, stream, style, base);
    }
  }

  @Override
  protected String className(String element) {
    return getClassName(element);
  }

  public static String getClassName(String name) {
    return name; // R5 ShEx type names are not transformed
  }
}