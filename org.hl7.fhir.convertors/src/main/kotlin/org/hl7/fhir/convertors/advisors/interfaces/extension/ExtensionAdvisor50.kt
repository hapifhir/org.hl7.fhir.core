package org.hl7.fhir.convertors.advisors.interfaces.extension

import org.hl7.fhir.exceptions.FHIRException
import org.hl7.fhir.instance.model.api.IBaseExtension
import org.hl7.fhir.r5.model.DataType
import org.hl7.fhir.r5.model.Extension

/**
 * When converting an Extension from R4, value types support in the source version are not always supported
 * in the target version. For example, if when converting a source R4 Extension to DSTU2, the [Expression] type in the
 * source is not supported in the target version.
 *
 * The default behavior for such conversions of this type is to treat the operation as a 'lossy' conversion,
 * ignoring all non-supported fields. However, if identified ahead of time, developers can utilize a convertor
 * advisor to process these unsupported [Extension] as they see fit.
 *
 */
interface ExtensionAdvisor50<T: IBaseExtension<T, *>> {

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreExtension(ext: Extension): Boolean {
        return ext.url?.let { ignoreExtension(ext.url) } ?: false || ext.value?.let { ignoreType(ext.value) } ?: false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreExtension(ext: T): Boolean {
        return ext.url?.let { ignoreExtension(ext.url) } ?: false || ext.value?.let { ignoreType(ext.value) } ?: false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreExtension(url: String): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreType(type: DataType): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreType(type: Any): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun useAdvisorForExtension(ext: Extension): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun useAdvisorForExtension(ext: T): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun handleExtension(src: Extension, tgt: T) {
        // Override to add code to handle specific extensions
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun handleExtension(src: T, tgt: Extension) {
        // Override to add code to handle specific extensions
    }
}