package org.hl7.fhir.model.core.formats;





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


import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.utilities.formats.FormatUtilities;
import org.hl7.fhir.model.utilities.formats.IParser;
import org.hl7.fhir.model.utilities.formats.JsonCreator;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.IXMLWriter;

import javax.annotation.Nonnull;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public abstract class ParserBase extends FormatUtilities implements IParser {

  protected IModelContext modelContext;

  public ParserBase(@Nonnull IModelContext modelContext) {
    if (modelContext == null) {
      throw new IllegalArgumentException("modelContext must not be null for a new instance of the "+getClass().getName());
    }
    this.modelContext = modelContext;
  }

  public interface IParserFactory {
    public JsonParserBase composerJson(IModelContext modelContext, JsonCreator json);
    public JsonParserBase parserJson(IModelContext modelContext, boolean allowUnknownContent, boolean allowComments);
    public XmlParserBase composerXml(IModelContext modelContext, IXMLWriter xml);
    public XmlParserBase parserXml(IModelContext modelContext, boolean allowUnknownContent);
  }

  public static class CustomResourceHandler {
    private final IParserFactory factory;
    private final boolean overridesBase;

    public CustomResourceHandler(IParserFactory factory, boolean overridesBase) {
      super();
      this.factory = factory;
      this.overridesBase = overridesBase;
    }

    public IParserFactory getFactory() {
      return factory;
    }

    /**
     * if true, this handler takes precedence over any resource with the same name defined 
     * in the base specification. If false, the handler is only used for resource names that 
     * the base specification doesn't define
     */
    public boolean isOverridesBase() {
      return overridesBase;
    }
  }

  // -- implementation of variant type methods from the interface --------------------------------
  
  public Resource parse(String input) throws FHIRFormatError, IOException {
  	return parse(input.getBytes(StandardCharsets.UTF_8));
  }
  
  public Resource parse(byte[] bytes) throws FHIRFormatError, IOException {
  	ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
  	return parse(bi);
  }

  public DataType parseType(String input, String typeName) throws FHIRFormatError, IOException {
    return parseType(input.getBytes(StandardCharsets.UTF_8), typeName);
  }
  
  public DataType parseAnyType(String input, String typeName) throws FHIRFormatError, IOException {
    return parseAnyType(input.getBytes(StandardCharsets.UTF_8), typeName);
  }
  
  public DataType parseType(byte[] bytes, String typeName) throws FHIRFormatError, IOException {
    ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
    return parseType(bi, typeName);
  }

  public DataType parseAnyType(byte[] bytes, String typeName) throws FHIRFormatError, IOException {
    ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
    return parseAnyType(bi, typeName);
  }

  public String composeString(Resource resource) throws IOException {
    return new String(composeBytes(resource), StandardCharsets.UTF_8);
  }

  public byte[] composeBytes(Resource resource) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    compose(bytes, resource);
    bytes.close();
    return bytes.toByteArray();
  }

  public String composeString(DataType type, String typeName) throws IOException {
    return new String(composeBytes(type, typeName), StandardCharsets.UTF_8);
  }

  public byte[] composeBytes(DataType type, String typeName) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    compose(bytes, type, typeName);
    bytes.close();
    return bytes.toByteArray();
  }


  // -- Parser Configuration --------------------------------

  protected String xhtmlMessage;
  
	@Override
  public IParser setSuppressXhtml(String message) {
    xhtmlMessage = message;
    return this;
  }
  
  protected boolean handleComments = false;
  
  public boolean getHandleComments() {
    return handleComments;
  }

  public IParser setHandleComments(boolean value) {
    this.handleComments = value;
    return this;
  }
  
  /**
   * Whether to throw an exception if unknown content is found (or just skip it)
   */
  protected boolean allowUnknownContent;
  
  /**
   * whether to allow comments in the json (special case for IG publisher source)
   */
  protected boolean allowComments;
  
  /**
   * @return Whether to throw an exception if unknown content is found (or just skip it) 
   */
  public boolean isAllowUnknownContent() {
    return true; // allowUnknownContent;
  }
  /**
   * @param allowUnknownContent Whether to throw an exception if unknown content is found (or just skip it)
   */
  public IParser setAllowUnknownContent(boolean allowUnknownContent) {
    this.allowUnknownContent = allowUnknownContent;
    return this;
  }
    
  public boolean isAllowComments() {
    return allowComments;
  }

  public void setAllowComments(boolean allowComments) {
    this.allowComments = allowComments;
  }

  protected OutputStyle style = OutputStyle.NORMAL;
  
  public OutputStyle getOutputStyle() {
    return style;
  }

  public IParser setOutputStyle(OutputStyle style) {
    this.style = style;
    return this;
  }
  
  // -- Parser Utilities --------------------------------
 	

  protected Map<String, Object> idMap = new HashMap<String, Object>();


  protected int parseIntegerPrimitive(String value) {
    if (value.startsWith("+") && Utilities.isInteger(value.substring(1)))
      value = value.substring(1);
	return Integer.parseInt(value);
  }
  protected int parseIntegerPrimitive(Long value) {
    if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
        throw new IllegalArgumentException
            (value + " cannot be cast to int without changing its value.");
    }
    return value.intValue();
  }


  protected String parseCodePrimitive(String value) {
    return value;
  }

  protected String parseTimePrimitive(String value) throws ParseException {
    return value;
  }

  protected BigDecimal parseDecimalPrimitive(BigDecimal value) {
    return value;
  }

  protected BigDecimal parseDecimalPrimitive(String value) {
    return new BigDecimal(value);
  }

  protected String parseUriPrimitive(String value) {
  	 return value;
  }

  protected byte[] parseBase64BinaryPrimitive(String value) {
    return Base64.decodeBase64(value.getBytes());
  }
  
  protected String parseOidPrimitive(String value) {
    return value;
  }

  protected Boolean parseBooleanPrimitive(String value) {
    return Boolean.valueOf(value);
  }
  
  protected Boolean parseBooleanPrimitive(Boolean value) {
    return Boolean.valueOf(value);
  }
  
  protected String parseIdPrimitive(String value) {
    return value;
  }

  protected String parseStringPrimitive(String value) {
    return value;
  }

  protected String parseUuidPrimitive(String value) {
    return value;
  }

  @Override
  public Resource parseAndClose(InputStream input) throws IOException, FHIRFormatError {
    try {
      return parse(input);
    } finally {
      input.close();
    }
  }

}