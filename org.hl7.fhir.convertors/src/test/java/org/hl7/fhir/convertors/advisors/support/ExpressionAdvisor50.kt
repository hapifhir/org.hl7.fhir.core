package org.hl7.fhir.convertors.advisors.support

import org.hl7.fhir.convertors.VersionConvertor_10_50
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50
import org.hl7.fhir.dstu2.model.StringType
import org.hl7.fhir.exceptions.FHIRException
import org.hl7.fhir.r5.model.Expression
import org.hl7.fhir.r5.model.Extension

open class ExpressionAdvisor50 : BaseAdvisor_10_50() {

    override fun useAdvisorForExtension(path: String, ext: org.hl7.fhir.dstu2.model.Extension): Boolean {
        return super.useAdvisorForExtension(path, ext)
    }

    override fun useAdvisorForExtension(path: String, ext: Extension): Boolean {
        return ext.hasValue() && ext.value is Expression
    }

    override fun handleExtension(path: String, src: Extension, tgt: org.hl7.fhir.dstu2.model.Extension) {
        when {
            (src.value is Expression) -> {
                val type = StringType()
                type.valueAsString = (src.value as Expression).expression
                tgt.setValue(type)
                if (src.hasUrlElement()) tgt.urlElement = VersionConvertor_10_50.convertUri(src.urlElement)
            }
            else -> throw FHIRException("Unknown extension type passed in to custom convertor method.")
        }
    }
}