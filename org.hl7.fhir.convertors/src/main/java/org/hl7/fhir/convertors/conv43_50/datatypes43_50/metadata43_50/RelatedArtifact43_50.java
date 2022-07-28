package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedArtifact43_50 {
  public static org.hl7.fhir.r5.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r4b.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasLabel()) tgt.setLabelElement(String43_50.convertString(src.getLabelElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitationElement(MarkDown43_50.convertMarkdown(src.getCitationElement()));
    if (src.hasUrl()) tgt.getDocument().setUrlElement(Url43_50.convertUrl(src.getUrlElement()));
    if (src.hasDocument()) tgt.setDocument(Attachment43_50.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Canonical43_50.convertCanonical(src.getResourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.RelatedArtifact tgt = new org.hl7.fhir.r4b.model.RelatedArtifact();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasLabel()) tgt.setLabelElement(String43_50.convertString(src.getLabelElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitationElement(MarkDown43_50.convertMarkdown(src.getCitationElement()));
    if (src.getDocument().hasUrl()) tgt.setUrlElement(Url43_50.convertUrl(src.getDocument().getUrlElement()));
    if (src.hasDocument()) tgt.setDocument(Attachment43_50.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Canonical43_50.convertCanonical(src.getResourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.NULL);
    } else {
      switch (src.getValue()) {
        case DOCUMENTATION:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
          break;
        case JUSTIFICATION:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
          break;
        case CITATION:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.CITATION);
          break;
        case PREDECESSOR:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
          break;
        case SUCCESSOR:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
          break;
        case DERIVEDFROM:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
          break;
        case DEPENDSON:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
          break;
        case COMPOSEDOF:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType.NULL);
          break;
      }
    }
    return tgt;
  }
}
