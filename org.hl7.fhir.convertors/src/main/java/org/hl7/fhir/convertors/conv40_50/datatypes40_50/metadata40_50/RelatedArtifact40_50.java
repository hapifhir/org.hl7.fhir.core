package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Url40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedArtifact40_50 {
  public static org.hl7.fhir.r5.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r4.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasLabel()) tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitationElement(MarkDown40_50.convertMarkdown(src.getCitationElement()));
    if (src.hasUrl()) tgt.getDocument().setUrlElement(Url40_50.convertUrl(src.getUrlElement()));
    if (src.hasDocument()) tgt.setDocument(Attachment40_50.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Canonical40_50.convertCanonical(src.getResourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.RelatedArtifact tgt = new org.hl7.fhir.r4.model.RelatedArtifact();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasLabel()) tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitationElement(MarkDown40_50.convertMarkdown(src.getCitationElement()));
    if (src.getDocument().hasUrl()) tgt.setUrlElement(Url40_50.convertUrl(src.getDocument().getUrlElement()));
    if (src.hasDocument()) tgt.setDocument(Attachment40_50.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Canonical40_50.convertCanonical(src.getResourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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
}
