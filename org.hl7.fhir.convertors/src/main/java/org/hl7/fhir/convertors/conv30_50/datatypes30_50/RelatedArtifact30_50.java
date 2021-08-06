package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Attachment30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedArtifact30_50 {
  public static org.hl7.fhir.r5.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.dstu3.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitation(src.getCitation());
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasDocument()) tgt.setDocument(Attachment30_50.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Reference30_50.convertReferenceToCanonical(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.RelatedArtifact tgt = new org.hl7.fhir.dstu3.model.RelatedArtifact();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitation(src.getCitation());
    if (src.hasUrl()) tgt.setUrl(src.getUrl());
    if (src.hasDocument()) tgt.setDocument(Attachment30_50.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResource(Reference30_50.convertCanonicalToReference(src.getResourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.NULL);
    } else {
      switch (src.getValue()) {
        case DOCUMENTATION:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
          break;
        case JUSTIFICATION:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
          break;
        case CITATION:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.CITATION);
          break;
        case PREDECESSOR:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
          break;
        case SUCCESSOR:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
          break;
        case DERIVEDFROM:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
          break;
        case DEPENDSON:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
          break;
        case COMPOSEDOF:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.NULL);
    } else {
      switch (src.getValue()) {
        case DOCUMENTATION:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
          break;
        case JUSTIFICATION:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
          break;
        case CITATION:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.CITATION);
          break;
        case PREDECESSOR:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
          break;
        case SUCCESSOR:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
          break;
        case DERIVEDFROM:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
          break;
        case DEPENDSON:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
          break;
        case COMPOSEDOF:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType.NULL);
          break;
      }
    }
    return tgt;
  }
}
