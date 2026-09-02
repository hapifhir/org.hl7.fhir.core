package org.hl7.fhir.convertors.conv43_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumerations.FHIRTypes;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.utilities.Utilities;

public class Utilities43_50 {

  public static void convertType(org.hl7.fhir.r4b.model.Enumeration<FHIRAllTypes> src, org.hl7.fhir.r5.model.Enumeration<FHIRTypes> tgt) {
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

  public static void convertType(org.hl7.fhir.r5.model.Enumeration<FHIRTypes> src, org.hl7.fhir.r4b.model.Enumeration<FHIRAllTypes> tgt) {
    if (src.hasExtension(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OPDEF_ORIGINAL_TYPE));
    } else {
      tgt.setValueAsString(src.asStringValue());
    }
    
  }


  /**
   * doseNumber[x] and seriesDoses[x] are positiveInt|string choices in R4B, but plain strings in R5.
   * The conversion is done element by element, not value by value, so that the id and any extensions
   * survive - including on an element that has no value at all (e.g. one that carries only a data absent
   * reason). Where the source is a positiveInt, that is recorded in an extension so that the original type
   * can be restored converting the other way
   */
  public static org.hl7.fhir.r5.model.StringType convertPositiveIntOrStringToString(org.hl7.fhir.r4b.model.DataType src) throws FHIRException {
    if (src == null) {
      return null;
    }
    org.hl7.fhir.r5.model.StringType tgt = src.primitiveValue() != null ? new org.hl7.fhir.r5.model.StringType(src.primitiveValue()) : new org.hl7.fhir.r5.model.StringType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src instanceof org.hl7.fhir.r4b.model.PositiveIntType) {
      tgt.addExtension(new Extension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new CodeType("positiveInt")));
    }
    return tgt;
  }

  /**
   * The other half of convertPositiveIntOrStringToString: rebuild the R4B choice from the R5 string,
   * using the recorded original type where there is one, and defaulting to string where there isn't
   */
  public static org.hl7.fhir.r4b.model.DataType convertStringToPositiveIntOrString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    if (src == null) {
      return null;
    }
    org.hl7.fhir.r4b.model.PrimitiveType<?> tgt = "positiveInt".equals(src.getExtensionString(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE)) ?
        new org.hl7.fhir.r4b.model.PositiveIntType() : new org.hl7.fhir.r4b.model.StringType();
    if (src.hasValue()) {
      tgt.setValueAsString(src.getValue());
    }
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
    return tgt;
  }

}
