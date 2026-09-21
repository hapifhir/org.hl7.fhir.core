package org.hl7.fhir.convertors.conv43_N.datatypes43_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.Enumerations.FHIRTypes;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.utilities.Utilities;

public class Utilities43_N {

  public static void convertType(org.hl7.fhir.r4b.model.PrimitiveType<?> src, org.hl7.fhir.model.core.Enumeration<FHIRTypes> tgt) {
    String code = src.primitiveValue();
    if (Utilities.existsInList(code, "Media")) {
      setType(tgt, code, "DocumentReference");
    
    } else if (Utilities.existsInList(code, "DeviceUseStatement")) {
      setType(tgt, code, "DeviceUsage");
    
    } else if (Utilities.existsInList(code, "DocumentManifest")) {
      setType(tgt, code, "List");
    
    } else if (Utilities.existsInList(code, "MedicinalProduct")) {
      setType(tgt, code, "MedicinalProductDefinition");
    
    } else if (Utilities.existsInList(code, "MedicinalProductAuthorization")) {
      setType(tgt, code, "RegulatedAuthorization");
    
    } else if (Utilities.existsInList(code, "RequestGroup")) {
      setType(tgt, code, "RequestOrchestration");

    } else if (Utilities.existsInList(code, "MedicinalProductIngredient")) {
      setType(tgt, code, "Ingredient");

    } else if (Utilities.existsInList(code, "MedicinalProductManufactured")) {
      setType(tgt, code, "ManufacturedItemDefinition");

    } else if (Utilities.existsInList(code, "MedicinalProductPackaged")) {
      setType(tgt, code, "PackagedProductDefinition");

    } else if (Utilities.existsInList(code, "MedicinalProductPharmaceutical")) {
      setType(tgt, code, "AdministrableProductDefinition");

    } else if (Utilities.existsInList(code, "SubstanceSpecification")) {
      setType(tgt, code, "SubstanceDefinition");

    } else if (Utilities.existsInList(code, "MedicinalProductContraindication", "MedicinalProductIndication", "MedicinalProductInteraction", "MedicinalProductUndesirableEffect", "ClinicalUseDefinition")) {
      setType(tgt, code, "SubstanceDefinition");

    } else if (Utilities.existsInList(code, "EffectEvidenceSynthesis", "CatalogEntry", "ResearchDefinition", "ResearchElementDefinition", "RiskEvidenceSynthesis",
        "Contributor", "ProdCharacteristic", "SubstanceAmount")) {
      setType(tgt, code, "Basic");

    } else if (Utilities.existsInList(code, "Any")) {
      // R5 renamed Any to Resource. setType keeps the original code in the extension, so
      // converting back restores Any rather than leaving Resource behind
      setType(tgt, code, "Resource");
    
    } else {
      tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.fromCode(code));
    }
  }

  private static void setType(org.hl7.fhir.model.core.Enumeration<FHIRTypes> tgt, String original, String value) {
    tgt.setValueAsString(value);
    tgt.addExtension(new Extension().setUrl(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE).setValue(new CodeType(original))); 
  }

  public static void convertType(org.hl7.fhir.model.core.Enumeration<FHIRTypes> src, org.hl7.fhir.r4b.model.CodeType tgt) {
    if (src.hasExtension(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE));
    } else {
      tgt.setValue(src.asStringValue());
    }
    
  }

  /**
   * R4B OperationDefinition.parameter.type is a code from all-types, which includes Any. In R6 the element is
   * a uri from fhir-types, which has no Any - the same intent is spelled Resource there (hence targetProfile:
   * "If type is 'Resource', then this constrains the allowed resource types"). Any and Resource are both
   * valid R4B codes, so the original is kept in an extension: that is the only way the reverse conversion can
   * tell a converted Any from a Resource that was always a Resource
   */
  public static org.hl7.fhir.model.core.UriType convertParameterType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes> src) {
    org.hl7.fhir.model.core.UriType tgt = src.hasValue() ? new org.hl7.fhir.model.core.UriType(src.getValueAsString()) : new org.hl7.fhir.model.core.UriType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if ("Any".equals(src.getValueAsString())) {
      tgt.setValue("Resource");
      tgt.addExtension(new Extension().setUrl(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE).setValue(new CodeType("Any")));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes> convertParameterType(org.hl7.fhir.model.core.UriType src) {
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypesEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE);
    if (src.hasExtension(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE)) {
      tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE)));
    } else if (src.hasValue()) {
      tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes.fromCode(src.getValue()));
    }
    return tgt;
  }

}
