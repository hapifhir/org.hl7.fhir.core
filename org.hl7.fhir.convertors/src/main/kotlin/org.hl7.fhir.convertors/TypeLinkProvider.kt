package org.hl7.fhir.convertors

interface TypeLinkProvider {
    fun getLink(typeName: String?): String?
}
