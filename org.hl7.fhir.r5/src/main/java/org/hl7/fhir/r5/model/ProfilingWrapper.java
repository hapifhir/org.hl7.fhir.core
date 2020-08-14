package org.hl7.fhir.r5.model;

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


import java.util.Map;

import org.hl7.fhir.r5.utils.FHIRPathEngine;

/**
 * This class is the base class for Profile classes - whether generated or manual
 * 
 * @author Grahame Grieve
 *
 */
public class ProfilingWrapper {

  // some discriminators require on features of external resources
  // to do slice matching. This provides external services to match 
  public interface IResourceResolver {
    Resource resolve(Base context, Base resource, Base reference);
  }

  // context
  private Base context; // bundle, if one is present and related; sole use is to pass to IResourceResolver.resolve as context
  private Base resource; // resource that contains the wrapped object
  protected Base wrapped; // the actual wrapped object 
  
  // FHIRPath engine
  private Map<String, ExpressionNode> cache; 
  private FHIRPathEngine engine;

  public ProfilingWrapper(Base context, Base resource, Base wrapped) {
    super();
    this.context = context;
    this.resource = resource;
    this.wrapped = wrapped;
  }
  
  public ProfilingWrapper(Base context, Base resource) {
    super();
    this.context = context;
    this.resource = resource;
    this.wrapped = resource;
  }
  
  /**
   * This is a convenient called for 
   * @param object
   * @return
   */
  private ProfilingWrapper wrap(Base object) {
    ProfilingWrapper res = new ProfilingWrapper(context, resource, object);
    res.cache = cache;
    res.engine = engine;
    return res;
  }
  
  
}