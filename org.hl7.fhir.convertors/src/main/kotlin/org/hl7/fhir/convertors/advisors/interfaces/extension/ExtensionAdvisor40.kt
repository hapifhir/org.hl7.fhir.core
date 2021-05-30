package org.hl7.fhir.convertors.advisors.interfaces.extension

import org.hl7.fhir.exceptions.FHIRException
import org.hl7.fhir.instance.model.api.IBaseExtension
import org.hl7.fhir.r4.model.Extension
import org.hl7.fhir.r4.model.Type

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
interface ExtensionAdvisor40<T : IBaseExtension<T, *>> {

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreExtension(path: String, ext: Extension): Boolean {
        return ext.url?.let { ignoreExtension(path, ext.url) } ?: false || ext.value?.let { ignoreType(path, ext.value) } ?: false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreExtension(path: String, ext: T): Boolean {
        return ext.url?.let { ignoreExtension(path, ext.url) } ?: false || ext.value?.let { ignoreType(path, ext.value) } ?: false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreExtension(path: String, url: String): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreType(path: String, type: Any): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun ignoreType(path: String, type: Type): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun useAdvisorForExtension(path: String, ext: Extension): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun useAdvisorForExtension(path: String, ext: T): Boolean {
        return false
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun handleExtension(path: String, src: Extension, tgt: T) {
        // Override to add code to handle specific extensions
    }

    @JvmDefault
    @Throws(FHIRException::class)
    fun handleExtension(path: String, src: T, tgt: Extension) {
        // Override to add code to handle specific extensions
    }
}