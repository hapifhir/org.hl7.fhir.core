package org.hl7.fhir.convertors.advisors.impl

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor
import org.hl7.fhir.convertors.advisors.interfaces.bundle.BundleAdvisor40
import org.hl7.fhir.convertors.advisors.interfaces.codesystem.CodeSystemAdvisor40
import org.hl7.fhir.convertors.advisors.interfaces.extension.ExtensionAdvisor40
import org.hl7.fhir.r4.model.CodeSystem
import org.hl7.fhir.r4.model.Expression
import org.hl7.fhir.r4.model.Type
import org.hl7.fhir.r4.model.ValueSet
import java.util.*

open class BaseAdvisor_14_40(val failFast: Boolean = true) : BaseAdvisor, BundleAdvisor40, CodeSystemAdvisor40,
    ExtensionAdvisor40<org.hl7.fhir.dstu2016may.model.Extension> {

    val cslist = ArrayList<CodeSystem>()

    private val ignoredUrls = listOf(
        "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown",
    )

    private val ignoredExtensionTypes = listOf(
        Expression::class.java,
    )

    override fun failFastOnNullOrUnknownEntry(): Boolean {
        return failFast
    }

    override fun ignoreExtension(path: String, url: String): Boolean {
        return ignoredUrls.contains(url)
    }

    override fun ignoreType(path: String, type: Type): Boolean {
        return ignoredExtensionTypes.contains(type::class.java)
    }

    override fun handleCodeSystem(tgtcs: org.hl7.fhir.r4.model.CodeSystem, source: ValueSet) {
        tgtcs.id = source.id
        tgtcs.valueSet = source.url
        cslist.add(tgtcs)
    }

}