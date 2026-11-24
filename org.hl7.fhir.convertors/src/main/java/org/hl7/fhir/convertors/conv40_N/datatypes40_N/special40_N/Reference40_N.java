package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class Reference40_N {
  public static org.hl7.fhir.model.core.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Reference tgt = new org.hl7.fhir.model.core.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String40_N.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri40_N.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.model.core.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String40_N.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri40_N.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static CodeableReference convertReferenceToCodeableReference(org.hl7.fhir.r4.model.Reference src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setReference(convertReference(src));
    // the concept, if convertCodeableReferenceToReference put one there
    String url = org.hl7.fhir.convertors.VersionConvertorConstants.EXT_CODEABLE_REFERENCE_CONCEPT;
    if (src.hasExtension(url) && src.getExtensionByUrl(url).getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept) {
      tgt.setConcept(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(url).getValue()));
      tgt.getReference().getExtension().removeIf(e -> url.equals(e.getUrl()));
      if (tgt.getReference().isEmpty())
        tgt.setReference(null);
    }
    return tgt;
  }

  /**
   * For R6 CodeableReferences whose R4 element is only a Reference: the concept goes on the Reference in the
   * cross-version extension for CodeableReference.concept (so a concept-only CodeableReference becomes a Reference
   * with just that extension)
   */
  public static org.hl7.fhir.r4.model.Reference convertCodeableReferenceToReference(CodeableReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Reference tgt = src.hasReference() ? convertReference(src.getReference()) : new org.hl7.fhir.r4.model.Reference();
    if (src.hasConcept())
      tgt.addExtension(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_CODEABLE_REFERENCE_CONCEPT, org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getConcept()));
    return tgt;
  }
  

  public static org.hl7.fhir.model.core.CanonicalType convertReferenceToCanonical(org.hl7.fhir.r4.model.Reference src) {
    if (src == null) return null;
    org.hl7.fhir.model.core.CanonicalType tgt = new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference()) tgt.setValue(src.getReference());
    // a canonical has no display: it's the display extension
    if (src.hasDisplay()) tgt.addExtension(EXT_DISPLAY, new org.hl7.fhir.model.core.StringType(src.getDisplay()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertReferenceToCanonical(org.hl7.fhir.model.core.CanonicalType src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.getValue());
    restoreDisplay(tgt);
    return tgt;
  }
  

  public static org.hl7.fhir.r4.model.Reference convertCanonicalToReference(org.hl7.fhir.model.core.CanonicalType src) {
    org.hl7.fhir.r4.model.Reference dst = new org.hl7.fhir.r4.model.Reference(src.getValue());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, dst);
    restoreDisplay(dst);
    return dst;
  }

  public static final String EXT_DISPLAY = "http://hl7.org/fhir/StructureDefinition/display";

  // the display extension on the canonical is the Reference's display
  private static void restoreDisplay(org.hl7.fhir.r4.model.Reference tgt) {
    if (tgt.hasExtension(EXT_DISPLAY)) {
      tgt.setDisplay(tgt.getExtensionByUrl(EXT_DISPLAY).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> EXT_DISPLAY.equals(e.getUrl()));
    }

  }

  public static org.hl7.fhir.model.core.Reference convertReferenceFromString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Reference tgt = new org.hl7.fhir.model.core.Reference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValue()) tgt.setReference(src.primitiveValue());
    return tgt;
  }



}
