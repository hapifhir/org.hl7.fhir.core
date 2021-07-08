package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertorResourceNameMapper;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations;

public class DataRequirement30_50 {
    public static org.hl7.fhir.r5.model.DataRequirement convertDataRequirement(org.hl7.fhir.dstu3.model.DataRequirement src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.DataRequirement tgt = new org.hl7.fhir.r5.model.DataRequirement();
      Element30_50.copyElement(src, tgt, VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME);
      if (src.hasType()) {
        if (src.hasExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME)) {
          tgt.setType(Enumerations.FHIRAllTypes.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME)));
        } else {
          String n = VersionConvertorResourceNameMapper.mapName3to5(src.getType());
          if (n != null) {
            tgt.setType(Enumerations.FHIRAllTypes.fromCode(n));
          }
          tgt.addExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME, new org.hl7.fhir.r5.model.CodeType(src.getType()));
        }
      }
      for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.dstu3.model.StringType t : src.getMustSupport()) tgt.addMustSupport(t.getValue());
      for (org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
        tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
      for (org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
        tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataRequirement convertDataRequirement(org.hl7.fhir.r5.model.DataRequirement src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.DataRequirement tgt = new org.hl7.fhir.dstu3.model.DataRequirement();
      Element30_50.copyElement(src, tgt, VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME);
      if (src.hasType() || src.hasExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME)) {
        if (src.hasExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME)) {
          tgt.setType(src.getExtensionString(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME));
        } else {
          String n = VersionConvertorResourceNameMapper.mapName5to3(src.getType().toCode());
          if (n != null) {
            tgt.setType(n);
          }
          tgt.addExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME, new org.hl7.fhir.dstu3.model.CodeType(src.getType().toCode()));
        }
      }
      for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.r5.model.StringType t : src.getMustSupport()) tgt.addMustSupport(t.getValue());
      for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
        tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
      for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
        tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
      return tgt;
    }

    public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent();
      Element30_50.copyElement(src, tgt);
      if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
      if (src.hasValueSet()) {
        DataType t = Type30_50.convertType(src.getValueSet());
        if (t instanceof org.hl7.fhir.r5.model.Reference)
          tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
        else tgt.setValueSet(t.primitiveValue());
        tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
      }
      for (org.hl7.fhir.dstu3.model.CodeType t : src.getValueCode()) tgt.addCode(Coding30_50.convertCoding(t));
      for (org.hl7.fhir.dstu3.model.Coding t : src.getValueCoding()) tgt.addCode(Coding30_50.convertCoding(t));
      for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getValueCodeableConcept()) tgt.addCode(Coding30_50.convertCoding(t));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementCodeFilterComponent();
      Element30_50.copyElement(src, tgt);
      if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
      if (src.hasValueSet()) {
        String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
        if (vsr != null) tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
        else tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
      }
      for (org.hl7.fhir.r5.model.Coding t : src.getCode()) {
        tgt.addValueCoding(Coding30_50.convertCoding(t));
      }
      return tgt;
    }

    public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent();
      Element30_50.copyElement(src, tgt);
      if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
      if (src.hasValue()) tgt.setValue(Type30_50.convertType(src.getValue()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.dstu3.model.DataRequirement.DataRequirementDateFilterComponent();
      Element30_50.copyElement(src, tgt);
      if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
      if (src.hasValue()) tgt.setValue(Type30_50.convertType(src.getValue()));
      return tgt;
    }
}
