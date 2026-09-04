package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Base64Binary43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;

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

public class Binary43_N {

  public static org.hl7.fhir.model.core.Binary convertBinary(org.hl7.fhir.r4b.model.Binary src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Binary tgt = new org.hl7.fhir.model.core.Binary();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyResource(src, tgt);
    if (src.hasContentType())
      tgt.setContentTypeElement(Code43_N.convertCode(src.getContentTypeElement()));
    if (src.hasSecurityContext())
      tgt.setSecurityContext(Reference43_N.convertReference(src.getSecurityContext()));
    if (src.hasData())
      tgt.setDataElement(Base64Binary43_N.convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Binary convertBinary(org.hl7.fhir.model.core.Binary src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Binary tgt = new org.hl7.fhir.r4b.model.Binary();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyResource(src, tgt);
    if (src.hasContentType())
      tgt.setContentTypeElement(Code43_N.convertCode(src.getContentTypeElement()));
    if (src.hasSecurityContext())
      tgt.setSecurityContext(Reference43_N.convertReference(src.getSecurityContext()));
    if (src.hasData())
      tgt.setDataElement(Base64Binary43_N.convertBase64Binary(src.getDataElement()));
    return tgt;
  }
}