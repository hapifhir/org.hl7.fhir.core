package org.hl7.fhir.convertors.conv40_50.datatypes40_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumerations.FHIRTypes;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.utilities.Utilities;

public class Utilities40_50 {

  public static void convertType(org.hl7.fhir.r4.model.CodeType src, org.hl7.fhir.r5.model.Enumeration<FHIRTypes> tgt) {
    if (Utilities.existsInList(src.primitiveValue(), "Media")) {
      setType(tgt, src.primitiveValue(), "DocumentReference");
    
    } else if (Utilities.existsInList(src.primitiveValue(), "DeviceUseStatement")) {
      setType(tgt, src.primitiveValue(), "DeviceUsage");
    
    } else if (Utilities.existsInList(src.primitiveValue(), "DocumentManifest")) {
      setType(tgt, src.primitiveValue(), "List");
    
    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProduct")) {
      setType(tgt, src.primitiveValue(), "MedicinalProductDefinition");
    
    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProductAuthorization")) {
      setType(tgt, src.primitiveValue(), "RegulatedAuthorization");
    
    } else if (Utilities.existsInList(src.primitiveValue(), "RequestGroup")) {
      setType(tgt, src.primitiveValue(), "RequestOrchestration");

    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProductIngredient")) {
      setType(tgt, src.primitiveValue(), "Ingredient");

    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProductManufactured")) {
      setType(tgt, src.primitiveValue(), "ManufacturedItemDefinition");

    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProductPackaged")) {
      setType(tgt, src.primitiveValue(), "PackagedProductDefinition");

    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProductPharmaceutical")) {
      setType(tgt, src.primitiveValue(), "AdministrableProductDefinition");

    } else if (Utilities.existsInList(src.primitiveValue(), "SubstanceSpecification")) {
      setType(tgt, src.primitiveValue(), "SubstanceDefinition");

    } else if (Utilities.existsInList(src.primitiveValue(), "MedicinalProductContraindication", "MedicinalProductIndication", "MedicinalProductInteraction", "MedicinalProductUndesirableEffect", "ClinicalUseDefinition")) {
      setType(tgt, src.primitiveValue(), "SubstanceDefinition");

    } else if (Utilities.existsInList(src.primitiveValue(), "EffectEvidenceSynthesis", "CatalogEntry", "ResearchDefinition", "ResearchElementDefinition", "RiskEvidenceSynthesis",
        "Contributor", "ProdCharacteristic", "SubstanceAmount")) {
      setType(tgt, src.primitiveValue(), "Basic");
    
    } else {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.fromCode(src.primitiveValue()));
    }
  }

  private static void setType(org.hl7.fhir.r5.model.Enumeration<FHIRTypes> tgt, String original, String value) {
    tgt.setValueAsString(value);
    tgt.addExtension(new Extension().setUrl(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE).setValue(new CodeType(original))); 
  }

  public static void convertType(org.hl7.fhir.r5.model.Enumeration<FHIRTypes> src, org.hl7.fhir.r4.model.CodeType tgt) {
    if (src.hasExtension(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE));
    } else {
      tgt.setValue(src.asStringValue());
    }
    
  }

}
