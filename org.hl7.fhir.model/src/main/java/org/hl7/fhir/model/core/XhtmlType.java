package org.hl7.fhir.model.core;

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



import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.Base;
import java.util.EnumSet;

import java.util.*;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;


public class XhtmlType extends PrimitiveType<String> {

  private Narrative place;
  
  public XhtmlType(IModelContext modelContext, Narrative place) {
    super();

    this.modelContext = modelContext;
    this.place = place;
  }

  public XhtmlType(Narrative place) {
    this((IModelContext) null, place);
  }

  public XhtmlType() {
    // "<div xmlns=\""+FormatUtilities.XHTML_NS+"\"></div>"
  }

  /**
   * Constructor
   *
   * @param context the model context this object belongs to - all objects in a tree must share the same context
   */
  public XhtmlType(IModelContext modelContext) {
    this();
    this.modelContext = modelContext;
  }

  @Override
  public String fhirType() {
    return "xhtml";
  }

  @Override
  protected void listChildren(List<Property> result) {
  }

  @Override
  public String getIdBase() {
    return null;
  }

  @Override
  public void setIdBase(String value) {
  }

  @Override
  public PrimitiveType<String> copy(EnumSet<CopyObjectOptions> options) {
    return null;
  }

  public String getValue() {
    return primitiveValue();
  }

  public XhtmlNode getXhtml() {
    return place == null ? new XhtmlNode(NodeType.Element, "div") : place.getDiv();
  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if ("value".equals(name)) {
      if (value instanceof StringType) {
        // div is already generated with getValue, we cannot just overwrite it
        place.getDiv().setValueAsString(((StringType) value).asStringValue());
      } else {
        place.setDiv(TypeConvertor.castToXhtml(value));
      }
      return value;
    } else
      return super.setProperty(name, value);
  }

  @Override
  public Base[] getNamedValue(String name, boolean checkValid) throws FHIRException {
    if ("value".equals(name))
      return new Base[] {this};
    return super.getNamedValue(name, checkValid);
  }

  @Override
  public String primitiveValue() {
    return new XhtmlComposer(false).compose(getXhtml());
  }  
  
  @Override
  public boolean isPrimitive() {
    return true;
  }
  
  @Override
  public boolean hasPrimitiveValue() {
    return true;
  }

  @Override
  protected String encode(String theValue) {
    return theValue;
  }

  @Override
  protected String parse(String theValue) {
    return theValue;
  }

  public Narrative getPlace() {
    return place;
  }

  public void setPlace(Narrative place) {
    this.place = place;
  }

  @Override
  public Base setXhtml(XhtmlNode node) {
    return place.setDiv(node);
  }
  

}