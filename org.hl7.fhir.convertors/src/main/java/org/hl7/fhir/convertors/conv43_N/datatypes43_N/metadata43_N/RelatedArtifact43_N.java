package org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Attachment43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Url43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.RelatedArtifact;

public class RelatedArtifact43_N {
  public static org.hl7.fhir.model.core.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r4b.model.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.RelatedArtifact tgt = new org.hl7.fhir.model.core.RelatedArtifact();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasLabel()) tgt.setLabelElement(String43_N.convertString(src.getLabelElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitationElement(MarkDown43_N.convertMarkdown(src.getCitationElement()));
    if (src.hasUrl()) tgt.getDocument().setUrlElement(Url43_N.convertUrl(src.getUrlElement()));
    if (src.hasDocument()) tgt.setDocument(Attachment43_N.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Canonical43_N.convertCanonical(src.getResourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.model.core.RelatedArtifact src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.RelatedArtifact tgt = new org.hl7.fhir.r4b.model.RelatedArtifact();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
    if (src.hasLabel()) tgt.setLabelElement(String43_N.convertString(src.getLabelElement()));
    if (src.hasDisplay()) tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    if (src.hasCitation()) tgt.setCitationElement(MarkDown43_N.convertMarkdown(src.getCitationElement()));
    if (src.getDocument().hasUrl()) tgt.setUrlElement(Url43_N.convertUrl(src.getDocument().getUrlElement()));
    if (src.hasDocument()) tgt.setDocument(Attachment43_N.convertAttachment(src.getDocument()));
    if (src.hasResource()) tgt.setResourceElement(Canonical43_N.convertCanonical(src.getResourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case DOCUMENTATION:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
                    break;
                case JUSTIFICATION:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
                    break;
                case CITATION:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.CITATION);
                    break;
                case PREDECESSOR:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.PREDECESSOR);
                    break;
                case SUCCESSOR:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.SUCCESSOR);
                    break;
                case DERIVEDFROM:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
                    break;
                case DEPENDSON:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.DEPENDSON);
                    break;
                case COMPOSEDOF:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
                    break;
                default:
                    tgt.setValue(RelatedArtifact.RelatedArtifactType.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
