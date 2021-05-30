package org.hl7.fhir.convertors.advisors.impl

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor
import org.hl7.fhir.convertors.advisors.interfaces.bundle.BundleAdvisor30
import org.hl7.fhir.convertors.advisors.interfaces.codesystem.CodeSystemAdvisor30
import org.hl7.fhir.convertors.advisors.interfaces.extension.ExtensionAdvisor30
import org.hl7.fhir.dstu3.model.CodeSystem
import org.hl7.fhir.dstu3.model.ValueSet
import java.util.*

open class BaseAdvisor_14_30(val failFast: Boolean = true) : BaseAdvisor, BundleAdvisor30, CodeSystemAdvisor30,
    ExtensionAdvisor30<org.hl7.fhir.dstu2016may.model.Extension> {

    val cslist = ArrayList<CodeSystem>()

    private val ignoredUrls = listOf(
        "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown",
    )

    override fun failFastOnNullOrUnknownEntry(): Boolean {
        return failFast
    }

    override fun ignoreExtension(path: String, url: String): Boolean {
        return ignoredUrls.contains(url)
    }

    override fun handleCodeSystem(tgtcs: CodeSystem, source: ValueSet) {
        tgtcs.id = source.id
        tgtcs.valueSet = source.url
        cslist.add(tgtcs)
    }

}