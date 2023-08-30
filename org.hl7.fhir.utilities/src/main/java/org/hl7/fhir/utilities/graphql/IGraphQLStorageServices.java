package org.hl7.fhir.utilities.graphql;

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


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseReference;
import org.hl7.fhir.instance.model.api.IBaseResource;

import java.util.List;

public interface IGraphQLStorageServices {

  /**
   * given a reference inside a context, return what it references (including resolving internal references (e.g. start with #)
   */
  ReferenceResolution lookup(Object appInfo, IBaseResource context, IBaseReference reference) throws FHIRException;

  /**
   * just get the identified resource
   */
  IBaseResource lookup(Object appInfo, String type, String id) throws FHIRException;

  /**
   * list the matching resources. searchParams are the standard search params.
   * this instanceof different to search because the server returns all matching resources, or an error. There instanceof no paging on this search
   */
  void listResources(Object appInfo, String type, List<Argument> searchParams, List<IBaseResource> matches) throws FHIRException;

  /**
   * just perform a standard search, and return the bundle as you return to the client
   */
  IBaseBundle search(Object appInfo, String type, List<Argument> searchParams) throws FHIRException;

  class ReferenceResolution {
    private IBaseResource targetContext;
    private IBaseResource target;

    public ReferenceResolution(IBaseResource targetContext, IBaseResource target) {
      super();
      this.targetContext = targetContext;
      this.target = target;
    }

    public IBaseResource getTargetContext() {
      return targetContext;
    }

    public IBaseResource getTarget() {
      return target;
    }


  }
}