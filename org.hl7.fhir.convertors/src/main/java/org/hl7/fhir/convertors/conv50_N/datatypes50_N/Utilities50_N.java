package org.hl7.fhir.convertors.conv50_N.datatypes50_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.Enumerations.FHIRTypes;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.utilities.Utilities;

public class Utilities50_N {

  public static void convertType(org.hl7.fhir.r5.model.PrimitiveType<?> src, org.hl7.fhir.model.core.Enumeration<FHIRTypes> tgt) {
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
    
    } else {
      tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.fromCode(code));
    }
  }

  private static void setType(org.hl7.fhir.model.core.Enumeration<FHIRTypes> tgt, String original, String value) {
    tgt.setValueAsString(value);
    tgt.addExtension(new Extension().setUrl(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE).setValue(new CodeType(original))); 
  }

  public static void convertType(org.hl7.fhir.model.core.Enumeration<FHIRTypes> src, org.hl7.fhir.r5.model.CodeType tgt) {
    if (src.hasExtension(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE));
    } else {
      tgt.setValue(src.asStringValue());
    }
    
  }

}
