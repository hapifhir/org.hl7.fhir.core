package org.hl7.fhir.convertors;

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

/**
 * This interface is passed into the version conversion routines when on of the
 * converters is producing or converting R3 resources. 
 * 
 * The interface allows users of the code to 
 *   1. manage the life cycle of new resources created (or needed) during the conversion process
 *   2. manage how unknown content etc is handled
 *    
 * @author grahame
 *
 */
public interface VersionConvertorAdvisor30 {
  
  /**
   * when processing a bundle, and converting from R3 to R2 whether to ignore an entry in the bundle. 
   * typically, return true when it's a resource that isn't handled, and you don't care. 
   * 
   * by default, always return false unless you know why not do this
   * 
   * todo: why only R2? generalise this to all targets
   * 
   * @param src
   * @return
   */
  boolean ignoreEntry(org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent src);

  /**
   * In R2, code systems are internal to value sets, but in subsequent versions, they
   * exist as separate resources. The convertor will create the code system, and then
   * call this routine for the host to decide what to do with it
   * 
   * It can make it a contained resource, or it can put it somewhere else
   * 
   * @param tgtcs
   * @param source
   * @throws FHIRException
   */
  void handleCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem tgtcs, org.hl7.fhir.dstu3.model.ValueSet source) throws FHIRException;

  /** 
   * when converting from R3 to R2, and converting a value set, the convertor will need 
   * to find the code system a value set is referring to, so it can include it inline. 
   * 
   * This routine should find the actual resource
   *  
   * @param src
   * @return
   * @throws FHIRException
   */
  org.hl7.fhir.dstu3.model.CodeSystem getCodeSystem(org.hl7.fhir.dstu3.model.ValueSet src) throws FHIRException;
}