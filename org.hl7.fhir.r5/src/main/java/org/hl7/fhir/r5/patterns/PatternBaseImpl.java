package org.hl7.fhir.r5.patterns;

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



import java.util.List;

import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;

public class PatternBaseImpl implements PatternBase {

  private Base wrapped;
  
  public PatternBaseImpl(Base wrapped) {
    super();
    this.wrapped = wrapped;
  }

  @Override
  public String getId() {
    if (wrapped instanceof Element)
      return ((Element) wrapped).getId();
    if (wrapped instanceof Resource)
      return ((Resource) wrapped).getId();
    return null;
  }

  @Override
  public PatternBase setId(String value) {
    if (wrapped instanceof Element)
      ((Element) wrapped).setId(value);
    else if (wrapped instanceof Resource)
      ((Resource) wrapped).setId(value);
    else
      throw new Error("this should not happen? wrapped = "+wrapped.getClass().getName());
    return this;
  }

  @Override
  public List<Extension> getExtension() {
    if (wrapped instanceof Element)
      return ((Element) wrapped).getExtension();
    if (wrapped instanceof DomainResource)
      return ((DomainResource) wrapped).getExtension();
    return null;
  }


  protected Annotation convertStringToAnnotation(String value) {
    if (value == null)
      return null;
    else
      return new Annotation().setText(value);
  }
  
  protected String convertAnnotationToString(Annotation value) {
    if (value == null)
      return null;
    else
      return value.getText();
  }


}