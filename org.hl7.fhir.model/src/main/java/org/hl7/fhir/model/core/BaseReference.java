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

import org.hl7.fhir.instance.model.api.IAnyResource;
import org.hl7.fhir.instance.model.api.IBaseReference;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.instance.model.api.ICompositeType;
import org.hl7.fhir.instance.model.api.IIdType;

public abstract class BaseReference extends DataType implements IBaseReference, ICompositeType {

    /**
     * This is not a part of the "wire format" resource, but can be changed/accessed by parsers
     */
    private transient IBaseResource resource;

  public BaseReference(IModelContext modelContext, String theReference) {
    this.modelContext = modelContext;
    setReference(theReference);
  }

  public BaseReference(String theReference) {
    setReference(theReference);
  }

    public BaseReference(IModelContext modelContext, IIdType theReference) {
    this.modelContext = modelContext;
    	if (theReference != null) {
    		setReference(theReference.getValue());
    	} else {
    		setReference(null);
    	}
    }

    public BaseReference(IIdType theReference) {
      this((IModelContext) null, theReference);
    }

	public BaseReference(IModelContext modelContext, IAnyResource theResource) {
    this.modelContext = modelContext;
		resource = theResource;
	}

	public BaseReference(IAnyResource theResource) {
	  this((IModelContext) null, theResource);
	}

	public BaseReference() {
	}

	/**
	 * Constructor
	 *
	 * @param context the model context this object belongs to - all objects in a tree must share the same context
	 */
	public BaseReference(IModelContext modelContext) {
	  this();
	  this.modelContext = modelContext;
	}

	/**
     * Retrieves the actual resource referenced by this reference. Note that the resource itself is not
     * a part of the FHIR "wire format" and is never transmitted or receieved inline, but this property
     * may be changed/accessed by parsers.
     */
    public IBaseResource getResource() {
        return resource;
    }

    @Override
	public IIdType getReferenceElement() {
		return new IdType(getReference());
	}

    abstract String getReference();

    /**
     * Sets the actual resource referenced by this reference. Note that the resource itself is not
     * a part of the FHIR "wire format" and is never transmitted or receieved inline, but this property
     * may be changed/accessed by parsers.
     */
    public IBaseReference setResource(IBaseResource theResource) {
        resource = theResource;
        return this;
    }

    @Override
	public boolean isEmpty() {
		return resource == null && super.isEmpty();
	}

  @Override
  public void copyValues(Element dst, EnumSet<CopyObjectOptions> options) {
    super.copyValues(dst, options);
    if (resource != null && dst instanceof BaseReference) {
      ((BaseReference) dst).setResource(resource);
    }
  }

}