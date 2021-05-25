package org.hl7.fhir.convertors.advisors.impl

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor
import org.hl7.fhir.convertors.advisors.interfaces.extension.ExtensionAdvisor40
import org.hl7.fhir.convertors.advisors.interfaces.bundle.BundleAdvisor40
import org.hl7.fhir.convertors.advisors.interfaces.codesystem.CodeSystemAdvisor40
import org.hl7.fhir.r4.model.CodeSystem
import org.hl7.fhir.r4.model.Expression
import org.hl7.fhir.r4.model.Extension
import org.hl7.fhir.r4.model.ValueSet
import java.util.ArrayList

open class BaseAdvisor_30_40(val failFast: Boolean = true): BaseAdvisor, BundleAdvisor40, CodeSystemAdvisor40, ExtensionAdvisor40<org.hl7.fhir.dstu3.model.Extension> {

    val cslist = ArrayList<CodeSystem>()

    private val ignoredUrls = listOf(
        "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown",
    )

    override fun failFastOnNullOrUnknownEntry(): Boolean {
        return failFast
    }

    private val ignoredExtensionTypes = listOf(
        Expression::class.java,
    )

    override fun ignoreExtension(ext: Extension): Boolean {
        return (ignoredUrls.contains(ext.url) || (ignoredExtensionTypes.contains(ext.value::class.java)))
    }

    override fun handleCodeSystem(tgtcs: CodeSystem, srcvs: ValueSet) {
        tgtcs.id = srcvs.id
        tgtcs.valueSet = srcvs.url
        cslist.add(tgtcs)
    }
}