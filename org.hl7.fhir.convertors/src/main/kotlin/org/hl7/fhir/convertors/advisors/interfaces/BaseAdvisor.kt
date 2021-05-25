package org.hl7.fhir.convertors.advisors.interfaces

interface BaseAdvisor {

    /**
     * During conversion, we may be provided with a null, or unknown Resource. This method returns true if the implementer
     * wants to fail fast in an unknown or null state.
     */
    @JvmDefault
    fun failFastOnNullOrUnknownEntry(): Boolean
}