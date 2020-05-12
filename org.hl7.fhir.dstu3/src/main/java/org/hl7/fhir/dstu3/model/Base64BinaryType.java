package org.hl7.fhir.dstu3.model;

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



import ca.uhn.fhir.model.api.IElement;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.parser.DataFormatException;
import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.api.IBaseHasExtensions;
import org.hl7.fhir.instance.model.api.IPrimitiveType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Primitive type "base64Binary" in FHIR: a sequence of bytes represented in base64
 */
@DatatypeDef(name = "base64Binary")
public class Base64BinaryType extends PrimitiveType<byte[]> implements IPrimitiveType<byte[]>, IBaseHasExtensions, IElement, Externalizable {

  private static final long serialVersionUID = 3L;
  private byte[] myValue;

  /**
   * Constructor
   */
  public Base64BinaryType() {
    super();
  }

  public Base64BinaryType(byte[] theBytes) {
    super();
    setValue(theBytes);
  }

  public Base64BinaryType(String theValue) {
    super();
    // Null values still result in non-null instance being created
    if (theValue != null) checkValidBase64(theValue);
    setValueAsString(theValue);
  }

  protected byte[] parse(String theValue) {
    if (theValue != null) {
      return Base64.decodeBase64(theValue.getBytes(ca.uhn.fhir.rest.api.Constants.CHARSET_UTF8));
    } else {
      return null;
    }
  }

  protected String encode(byte[] theValue) {
    if (theValue == null) {
      return null;
    }
    return new String(Base64.encodeBase64(theValue), ca.uhn.fhir.rest.api.Constants.CHARSET_UTF8);
  }

  @Override
  public Base64BinaryType copy() {
    return new Base64BinaryType(getValue());
  }

  @Override
  protected Type typedCopy() {
    return null;
  }

  public String fhirType() {
    return "base64Binary";
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(getValue());
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    setValue((byte[]) in.readObject());
  }

  @Override
  public String getValueAsString() {
    return encode(myValue);
  }

  @Override
  public void setValueAsString(String theValue) throws IllegalArgumentException {
    fromStringValue(theValue);
    setValue(parse(theValue));
  }

  @Override
  public byte[] getValue() {
    return myValue;
  }

  @Override
  public Base64BinaryType setValue(byte[] theValue) throws IllegalArgumentException {
    myValue = theValue;
    return this;
  }

  @Override
  public boolean hasValue() {
    return myValue != null && myValue.length > 0;
  }

  @Override
  public boolean isEmpty() {
    // Custom isEmpty() in order to avoid generating the text representation unneccessarily
    return ca.uhn.fhir.util.ElementUtil.isEmpty(id, extension) && !hasValue();
  }

  /**
   * Checks if the passed in String is a valid {@link Base64} encoded String. Will throw a {@link DataFormatException} if not
   * formatted correctly.
   *
   * @param toCheck {@link String} to check if valid {@link Base64}
   * @throws DataFormatException
   */
  public void checkValidBase64(String toCheck) throws DataFormatException {
    if (!Base64.isBase64(toCheck.getBytes())) {
      throw new DataFormatException("");
    }
  }
}