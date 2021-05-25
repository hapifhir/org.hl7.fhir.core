package org.hl7.fhir.convertors

import org.hl7.fhir.r5.model.StructureDefinition
import org.hl7.fhir.r5.model.ValueSet
import java.util.HashMap

data class SpecPackage (
    var valuesets: Map<String, ValueSet> = HashMap(),
    var expansions: Map<String, ValueSet> = HashMap(),
    var types: Map<String, StructureDefinition> = HashMap(),
    var resources: Map<String, StructureDefinition> = HashMap(),
    var extensions: Map<String, StructureDefinition> = HashMap(),
    var profiles: Map<String, StructureDefinition> = HashMap()
)
