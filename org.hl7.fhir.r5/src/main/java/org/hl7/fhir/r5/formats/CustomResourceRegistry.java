package org.hl7.fhir.r5.formats;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:

   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to
     endorse or promote products derived from this software without specific
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
 */

import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.r5.formats.ParserBase.CustomResourceHandler;
import org.hl7.fhir.r5.formats.ParserBase.IParserFactory;

/**
 * A registry of the parsers/composers for custom (additional) resources - resources that are not
 * defined in the base specification, but are defined in an incubator IG that code has been
 * generated for.
 * <p/>
 * Registration is no longer an unavoidably global side effect: a parser uses {@link #GLOBAL} unless
 * it is given a specific registry (via a constructor, or {@link ParserBase#setCustomResourceRegistry}
 * / {@link ParserBase#withCustomResourceRegistry}). This lets a caller (e.g. an IG build) scope a
 * set of custom resources to just the parsers it hands the registry to, rather than the whole
 * process. Code that does not care continues to use {@link #GLOBAL}, which is where the static
 * GLOBAL registry is where the generated register(boolean) convenience methods register.
 */
public class CustomResourceRegistry {

  /**
   * The process-wide default registry. Parsers that are not given a specific registry use this one,
   * and the generated <name>Parser.register(boolean) convenience methods register into it
   */
  public static final CustomResourceRegistry GLOBAL = new CustomResourceRegistry();

  private final Map<String, CustomResourceHandler> handlers = new HashMap<>();

  public void registerCustomResource(String name, IParserFactory factory, boolean overridesBase) {
    handlers.put(name, new CustomResourceHandler(factory, overridesBase));
  }

  public boolean has(String name) {
    return handlers.containsKey(name);
  }

  public CustomResourceHandler get(String name) {
    return handlers.get(name);
  }

  public Map<String, CustomResourceHandler> getHandlers() {
    return handlers;
  }
}
