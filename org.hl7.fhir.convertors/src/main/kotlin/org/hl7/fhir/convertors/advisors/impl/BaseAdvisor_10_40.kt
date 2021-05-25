package org.hl7.fhir.convertors.advisors.impl

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor
import org.hl7.fhir.convertors.advisors.interfaces.extension.ExtensionAdvisor40
import org.hl7.fhir.convertors.advisors.interfaces.bundle.BundleAdvisor40
import org.hl7.fhir.convertors.advisors.interfaces.codesystem.CodeSystemAdvisor40
import org.hl7.fhir.r4.model.CodeSystem
import org.hl7.fhir.r4.model.Expression
import org.hl7.fhir.r4.model.Type
import org.hl7.fhir.r4.model.ValueSet
import java.util.ArrayList

open class BaseAdvisor_10_40(val failFast: Boolean = true): BaseAdvisor, BundleAdvisor40, CodeSystemAdvisor40, ExtensionAdvisor40<org.hl7.fhir.dstu2.model.Extension> {

    val cslist = ArrayList<CodeSystem>()

    private val ignoredUrls = listOf(
        //todo put only in capabilty statement
        //todo methods to convert extension should always take path
        "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown",
    )

    private val ignoredExtensionTypes = listOf(
        Expression::class.java,
    )

    override fun failFastOnNullOrUnknownEntry(): Boolean {
        return failFast
    }

    //todo path - Observation.value
    // "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"
    //
    override fun ignoreExtension(url: String): Boolean {
        return ignoredUrls.contains(url)
    }


    override fun ignoreType(type: Type): Boolean {
        return ignoredExtensionTypes.contains(type::class.java)
    }

    override fun handleCodeSystem(tgtcs: CodeSystem, source: ValueSet) {
        tgtcs.id = source.id
        tgtcs.valueSet = source.url
        cslist.add(tgtcs)
    }

}