package org.hl7.fhir.r5.model;


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

// Generated on Tue, May 4, 2021 07:17+1000 for FHIR v4.6.0

import ca.uhn.fhir.model.api.IElement;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import org.hl7.fhir.instance.model.api.IBaseDatatype;

/**
 * Base StructureDefinition for DataType Type: The base class for all re-useable types defined as part of the FHIR Specification.
 */
@DatatypeDef(name = "DataType")
public abstract class DataType extends Element implements IBaseDatatype, IElement {

  private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
  public DataType() {
    super();
  }

  public String fhirType() {
    return "DataType";

  }

  public abstract DataType copy();

  public void copyValues(DataType dst) {
    super.copyValues(dst);
  }


}

