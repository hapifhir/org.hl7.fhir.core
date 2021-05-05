package org.hl7.fhir.convertors

data class SourceElementComponentWrapper<A>(
    var comp: A,
    var source: String,
    var target: String
)