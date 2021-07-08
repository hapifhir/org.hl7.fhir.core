package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Attachment30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedArtifact30_40 {
    public static org.hl7.fhir.r4.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.dstu3.model.RelatedArtifact src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.RelatedArtifact tgt = new org.hl7.fhir.r4.model.RelatedArtifact();
      Element30_40.copyElement(src, tgt);
      if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
      if (src.hasDisplay()) tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
      if (src.hasCitation()) tgt.setCitation(src.getCitation());
      if (src.hasUrl()) tgt.setUrl(src.getUrl());
      if (src.hasDocument()) tgt.setDocument(Attachment30_40.convertAttachment(src.getDocument()));
      if (src.hasResource()) tgt.setResourceElement(Reference30_40.convertReferenceToCanonical(src.getResource()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r4.model.RelatedArtifact src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.RelatedArtifact tgt = new org.hl7.fhir.dstu3.model.RelatedArtifact();
      Element30_40.copyElement(src, tgt);
      if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
      if (src.hasDisplay()) tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
      if (src.hasCitation()) tgt.setCitation(src.getCitation());
      if (src.hasUrl()) tgt.setUrl(src.getUrl());
      if (src.hasDocument()) tgt.setDocument(Attachment30_40.convertAttachment(src.getDocument()));
      if (src.hasResource()) tgt.setResource(Reference30_40.convertCanonicalToReference(src.getResourceElement()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
      Element30_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.NULL);
      } else {
        switch (src.getValue()) {
          case DOCUMENTATION:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
            break;
          case JUSTIFICATION:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
            break;
          case CITATION:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.CITATION);
            break;
          case PREDECESSOR:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
            break;
          case SUCCESSOR:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
            break;
          case DERIVEDFROM:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
            break;
          case DEPENDSON:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
            break;
          case COMPOSEDOF:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
      Element30_40.copyElement(src, tgt);
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
