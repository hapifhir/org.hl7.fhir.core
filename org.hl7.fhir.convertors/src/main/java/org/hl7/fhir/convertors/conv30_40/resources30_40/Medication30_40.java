package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Attachment30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Ratio30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.List;


/**
 * Conversion is based on mapping defined at https://hl7.org/fhir/R4/medication-version-maps.html
 * Only deviation is the status mapping, which seems incorrect in the definition.
 * Because they define an extension based mapping, but both dstu3 and r4 have a corresponding status field,
 * so it seems incorrect to not just map the status fields
 */

public class Medication30_40 {
  private static final String[] IGNORED_EXTENSION_URLS = new String[]{
    VersionConvertorConstants.EXT_MED_ISBRAND, VersionConvertorConstants.EXT_MED_OTC,
    VersionConvertorConstants.EXT_MED_PACK_CONTAINER, VersionConvertorConstants.EXT_MED_PACK_CONTENT,
    VersionConvertorConstants.EXT_MED_IMAGE
  };

  public static org.hl7.fhir.r4.model.Medication convertMedication(org.hl7.fhir.dstu3.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication tgt = new org.hl7.fhir.r4.model.Medication();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
    if (src.hasIsBrand())
      tgt.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_ISBRAND, new org.hl7.fhir.r4.model.BooleanType(src.getIsBrand())));
    if (src.hasIsOverTheCounter())
      tgt.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_OTC, new org.hl7.fhir.r4.model.BooleanType(src.getIsOverTheCounter())));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference30_40.convertReference(src.getManufacturer()));
    if (src.hasForm())
      tgt.setForm(CodeableConcept30_40.convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));

    if (src.hasPackage()) {
      if (src.getPackage().hasContainer())
        tgt.addExtension(
          VersionConvertorConstants.EXT_MED_PACK_CONTAINER,
          CodeableConcept30_40.convertCodeableConcept(src.getPackage().getContainer())
        );
      for (org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent c : src.getPackage().getContent())
        tgt.addExtension(
          VersionConvertorConstants.EXT_MED_PACK_CONTENT,
          Medication30_40.convertMedicationPackageContentComponent(c)
        );
      tgt.setBatch(convertMedicationPackageBatchComponent(src.getPackage().getBatchFirstRep()));
    }

    for (org.hl7.fhir.dstu3.model.Attachment attachment : src.getImage()) {
      tgt.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_IMAGE, Attachment30_40.convertAttachment(attachment)));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication convertMedication(org.hl7.fhir.r4.model.Medication src) throws FHIRException {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.Medication tgt = new org.hl7.fhir.dstu3.model.Medication();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_MED_ISBRAND)) {
      org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_ISBRAND);
      if (ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r4.model.BooleanType) {
        tgt.setIsBrandElement(Boolean30_40.convertBoolean((org.hl7.fhir.r4.model.BooleanType) ext.getValue()));
      }
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_MED_OTC)) {
      org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_OTC);
      if (ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r4.model.BooleanType) {
        tgt.setIsOverTheCounterElement(Boolean30_40.convertBoolean((org.hl7.fhir.r4.model.BooleanType) ext.getValue()));
      }
    }
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference30_40.convertReference(src.getManufacturer()));
    if (src.hasForm())
      tgt.setForm(CodeableConcept30_40.convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));

    if (src.hasBatch() || src.hasExtension(VersionConvertorConstants.EXT_MED_PACK_CONTAINER) || src.hasExtension(VersionConvertorConstants.EXT_MED_PACK_CONTENT)) {
      tgt.setPackage(convertMedicationPackageComponent(src));
    }

    if (src.hasExtension(VersionConvertorConstants.EXT_MED_IMAGE)) {
      List<org.hl7.fhir.r4.model.Extension> extensions = src.getExtensionsByUrl(VersionConvertorConstants.EXT_MED_IMAGE);
      for (org.hl7.fhir.r4.model.Extension ext : extensions) {
        if (ext.getValue() instanceof org.hl7.fhir.r4.model.Attachment) {
          tgt.addImage(Attachment30_40.convertAttachment((org.hl7.fhir.r4.model.Attachment) ext.getValue()));
        }
      }
    }

    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent convertMedicationPackageComponent(org.hl7.fhir.r4.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent();

    if (src.hasExtension(VersionConvertorConstants.EXT_MED_PACK_CONTAINER)) {
      org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_PACK_CONTAINER);
      if (ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept) {
        tgt.setContainer(CodeableConcept30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
      }
    }

    if (src.hasExtension(VersionConvertorConstants.EXT_MED_PACK_CONTENT)) {
      org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_PACK_CONTENT);
      if (ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r4.model.Extension) {
        tgt.addContent(convertMedicationPackageContentComponent((org.hl7.fhir.r4.model.Extension) ext.getValue()));
      }
    }

    if (src.hasBatch())
      tgt.addBatch(convertMedicationPackageBatchComponent(src.getBatch()));

    return tgt;
  }

  public static org.hl7.fhir.r4.model.Extension convertMedicationPackageContentComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);

    if (src.hasItem())
      tgt.addExtension(
        VersionConvertorConstants.EXT_MED_PACK_CONTENT,
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getItem())
      );
    if (src.hasAmount())
      tgt.addExtension(
        VersionConvertorConstants.EXT_MED_PACK_AMOUNT,
        SimpleQuantity30_40.convertSimpleQuantity(src.getAmount())
      );
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent convertMedicationPackageContentComponent(org.hl7.fhir.r4.model.Extension src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt, VersionConvertorConstants.EXT_MED_PACK_CONTENT, VersionConvertorConstants.EXT_MED_PACK_AMOUNT);

    if (src.hasExtension(VersionConvertorConstants.EXT_MED_PACK_CONTENT)) {
      org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_PACK_CONTENT);
      if (ext.hasValue() && (ext.getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept || ext.getValue() instanceof org.hl7.fhir.r4.model.Reference)) {
        tgt.setItem(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(ext.getValue()));
      }
    }

    if (src.hasExtension(VersionConvertorConstants.EXT_MED_PACK_AMOUNT)) {
      org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_MED_PACK_AMOUNT);
      if (ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r4.model.Quantity) {
        tgt.setAmount(SimpleQuantity30_40.convertSimpleQuantity((org.hl7.fhir.r4.model.Quantity) ext.getValue()));
      }
    }

    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getItem()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(Boolean30_40.convertBoolean(src.getIsActiveElement()));
    if (src.hasStrength())
      tgt.setAmount(Ratio30_40.convertRatio(src.getStrength()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getItem()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(Boolean30_40.convertBoolean(src.getIsActiveElement()));
    if (src.hasAmount())
      tgt.setStrength(Ratio30_40.convertRatio(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent convertMedicationPackageBatchComponent(org.hl7.fhir.r4.model.Medication.MedicationBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime30_40.convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication.MedicationBatchComponent convertMedicationPackageBatchComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationBatchComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime30_40.convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> convertMedicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Medication.MedicationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.ACTIVE);
          break;
        case INACTIVE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.INACTIVE);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> convertMedicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Medication.MedicationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.ACTIVE);
          break;
        case INACTIVE:
          tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.INACTIVE);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }
}