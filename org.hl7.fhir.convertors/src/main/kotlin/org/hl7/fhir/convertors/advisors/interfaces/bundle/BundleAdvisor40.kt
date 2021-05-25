package org.hl7.fhir.convertors.advisors.interfaces.bundle

import org.hl7.fhir.exceptions.FHIRException
import org.hl7.fhir.r4.model.*
import org.hl7.fhir.r5.model.FhirPublication

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

*/ /**
 * This interface is passed into the version conversion routines when on of the
 * converters is producing or converting R4 resources.
 *
 * The interface allows users of the code to
 * 1. manage the life cycle of new resources created (or needed) during the conversion process
 * 2. manage how unknown content etc is handled
 *
 * @author grahame
 */
interface BundleAdvisor40 {

    /**
     * When processing a bundle during conversion, we can choose whether to ignore an entry in the bundle. We return
     * true when it's a resource that isn't handled, and you don't want to convert.
     *
     * Different conversions require differing behaviors, so users can determine how they want to handle conversion
     * for different target [FhirPublication] versions by switching on the the passed in version.
     *
     * If implementing this advisor, by default, always return false unless you have a specific reason not to convert
     * a [Bundle.BundleEntryComponent].
     *
     * @param src [Bundle.BundleEntryComponent] to ignore
     * @param targetVersion [FhirPublication] of the target version
     * @return [Boolean] True, if we are going to ignore this [Bundle.BundleEntryComponent] in this conversion operation.
     */
    @JvmDefault
    fun ignoreEntry(src: Bundle.BundleEntryComponent, targetVersion: FhirPublication): Boolean {
        return false
    }
}