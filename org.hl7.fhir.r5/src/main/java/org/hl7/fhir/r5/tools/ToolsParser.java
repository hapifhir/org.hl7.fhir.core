package org.hl7.fhir.r5.tools;

// generated

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
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0



import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.r5.formats.JsonParserBase;
import org.hl7.fhir.r5.formats.ParserBase.IParserFactory;
import org.hl7.fhir.r5.formats.XmlParserBase;
import org.hl7.fhir.utilities.xml.IXMLWriter;

public class ToolsParser {

  /**
   * Register the parsers for the resources in this package with the core parsers. 
   * 
   * If overridesBase is true, these resources take precedence over any resources with the 
   * same names defined in the base specification; if it is false, they are only used for 
   * resource names that the base specification doesn't define (which is the appropriate 
   * choice for this package - nothing in it overrides the base specification). The parameter 
   * is always present for consistency across the generated packages
   */
  public static void register(boolean overridesBase) {    
    register(org.hl7.fhir.r5.formats.CustomResourceRegistry.GLOBAL, overridesBase);

  }

  /**
   * Register the parsers for the resources in this package into the given custom resource 
   * registry, rather than the global one - so the registration only affects parsers that are 
   * given this registry, not the whole process. See register(boolean) for the meaning of 
   * overridesBase
   */
  public static void register(org.hl7.fhir.r5.formats.CustomResourceRegistry registry, boolean overridesBase) {
    registry.registerCustomResource("TestCases", new ToolsJsonParserFactory(), overridesBase);
  }

  public static class ToolsJsonParserFactory implements IParserFactory {
    @Override
    public JsonParserBase composerJson(JsonCreator json) {
      return new ToolsJsonParser(json);
    }
    @Override
    public JsonParserBase parserJson(boolean allowUnknownContent, boolean allowComments) {
      return new ToolsJsonParser(allowUnknownContent, allowComments);
    }
    @Override
    public XmlParserBase composerXml(IXMLWriter xml) {
      return new ToolsXmlParser(xml);
    }
    @Override
    public XmlParserBase parserXml(boolean allowUnknownContent) {
      return new ToolsXmlParser(allowUnknownContent);
    }
  }
  
}
