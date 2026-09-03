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
import org.hl7.fhir.model.Base.CopyObjectOptions;
import org.hl7.fhir.model.Base;
import java.util.EnumSet;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * Primitive type "integer" in FHIR: A signed 32-bit integer
 */
@DatatypeDef(name = "positiveInt", profileOf=IntegerType.class)
public class PositiveIntType extends IntegerType {

	/**
	 * 
	 */
  private static final long serialVersionUID = 1686497884249402429L;

	/**
	 * Constructor
	 */
	public PositiveIntType() {
		// nothing
	}

	/**
	 * Constructor
	 *
	 * @param context the model context this object belongs to - all objects in a tree must share the same context
	 */
	public PositiveIntType(IModelContext modelContext) {
	  this();
	  this.modelContext = modelContext;
	}

  /**
   * Constructor
   */
  public PositiveIntType(IModelContext modelContext, int theInteger) {
    this.modelContext = modelContext;
    setValue(theInteger);
  }

  /**
   * Constructor
   *
   * @param theIntegerAsString
   *            A string representation of an integer
   * @throws IllegalArgumentException
   *             If the string is not a valid integer representation
   */
  public PositiveIntType(IModelContext modelContext, String theIntegerAsString) {
    this.modelContext = modelContext;
    setValueAsString(theIntegerAsString);
  }

  /**
   * Constructor
   */
  public PositiveIntType(int theInteger) {
    setValue(theInteger);
  }

  /**
   * Constructor
   *
   * @param theIntegerAsString
   *            A string representation of an integer
   * @throws IllegalArgumentException
   *             If the string is not a valid integer representation
   */
  public PositiveIntType(String theIntegerAsString) {
    setValueAsString(theIntegerAsString);
  }

	/**
	 * Constructor
	 * 
	 * @param theValue The value
	 * @throws IllegalArgumentException If the value is too large to fit in a signed integer
	 */
	public PositiveIntType(IModelContext modelContext, Long theValue) {
    this.modelContext = modelContext;
	    if (theValue < 1 || theValue > java.lang.Integer.MAX_VALUE) {
	        throw new IllegalArgumentException
	            (theValue + " cannot be cast to int without changing its value.");
	    }
	    if(theValue!=null) {
	    	setValue((int)theValue.longValue());
	    }
	}

	public PositiveIntType(Long theValue) {
	  this((IModelContext) null, theValue);
	}

	@Override
	public PositiveIntType copy(EnumSet<CopyObjectOptions> options) {
    PositiveIntType ret = getValue() == null ? new PositiveIntType() : new PositiveIntType(modelContext, getValue());
    copyValues(ret, options);
    return ret;
	}

	public String fhirType() {
		return "positiveInt";		
	}
}