package org.hl7.fhir.convertors.advisors.support

import org.hl7.fhir.convertors.VersionConvertor_10_40
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40
import org.hl7.fhir.dstu2.model.StringType
import org.hl7.fhir.exceptions.FHIRException
import org.hl7.fhir.r4.model.Expression
import org.hl7.fhir.r4.model.Extension

class ExpressionAdvisor40 : BaseAdvisor_10_40() {

    @Throws(FHIRException::class)
    override fun useAdvisorForExtension(ext: Extension): Boolean {
        return ext.hasValue() && ext.value is Expression
    }

    @Throws(FHIRException::class)
    override fun handleExtension(src: Extension, tgt: org.hl7.fhir.dstu2.model.Extension) {
        when {
            (src.value is Expression) -> {
                val type = StringType()
                type.valueAsString = (src.value as Expression).expression
                tgt.setValue(type)
                if (src.hasUrlElement()) tgt.urlElement = VersionConvertor_10_40.convertUri(src.urlElement)
            }
            else -> throw FHIRException("Unknown extension type passed in to custom convertor method.")
        }
    }
}