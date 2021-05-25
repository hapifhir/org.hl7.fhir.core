package org.hl7.fhir.convertors.advisors.interfaces.codesystem

import org.hl7.fhir.exceptions.FHIRException
import org.hl7.fhir.r5.model.Expression
import org.hl7.fhir.r5.model.Extension
import org.hl7.fhir.r5.model.Bundle
import org.hl7.fhir.r5.model.CodeSystem
import org.hl7.fhir.r5.model.FhirPublication
import org.hl7.fhir.r5.model.ValueSet

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
interface CodeSystemAdvisor50 {

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
    @JvmDefault
    @Throws(FHIRException::class)
    fun handleCodeSystem(tgtcs: CodeSystem, source: ValueSet) {}

    /**
     * when converting from R5 to R2, and converting a value set, the convertor will need
     * to find the code system a value set is referring to, so it can include it inline.
     *
     * This routine should find the actual resource
     *
     * @param src
     * @return
     * @throws FHIRException
     */
    @JvmDefault
    @Throws(FHIRException::class)
    fun getCodeSystem(src: ValueSet): CodeSystem? {
        return null
    }
}