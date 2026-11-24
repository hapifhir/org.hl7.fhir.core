package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class CodeableConcept40_N {
  public static org.hl7.fhir.model.core.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(Coding40_N.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Coding t : src.getCodingList()) tgt.addCoding(Coding40_N.convertCoding(t));
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    return tgt;
  }

  /**
   * The reverse of {@link #convertCodeableReferenceToCodeableConcept}: picks up a reference carried on the
   * concept in the CodeableReference.reference cross-version extension
   */
  public static CodeableReference convertCodeableConceptToCodeableReference(org.hl7.fhir.r4.model.CodeableConcept src) {
    return src == null ? null : convertChoiceToCodeableReference(src);
  }

  /**
   * For R6 CodeableReferences whose R4 element is only a CodeableConcept: the reference goes on the concept in the
   * cross-version extension for CodeableReference.reference (so a reference-only CodeableReference becomes a
   * CodeableConcept with just that extension). The CodeableReference's own id and extensions are not kept
   */
  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableReferenceToCodeableConcept(CodeableReference src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = src.hasConcept() ? convertCodeableConcept(src.getConcept()) : new org.hl7.fhir.r4.model.CodeableConcept();
    if (src.hasReference()) {
      tgt.addExtension(VersionConvertorConstants.EXT_CODEABLE_REFERENCE_REFERENCE, Reference40_N.convertReference(src.getReference()));
    }
    return tgt;
  }

  /**
   * For R4 choice elements [x] of CodeableConcept|Reference that became a CodeableReference in R6
   * (e.g. Claim.diagnosis[x], MedicationRequest.medication[x]). R4 can only carry one of them: if the R6
   * CodeableReference has both, the concept wins, and the reference goes on the concept in the cross-version
   * extension for CodeableReference.reference, where {@link #convertChoiceToCodeableReference} picks it up again.
   * The CodeableReference's own id and extensions are not kept
   */
  public static org.hl7.fhir.r4.model.Type convertCodeableReferenceToChoice(CodeableReference src) {
    if (src == null) return null;
    if (src.hasConcept()) {
      org.hl7.fhir.r4.model.CodeableConcept tgt = convertCodeableConcept(src.getConcept());
      if (src.hasReference()) {
        tgt.addExtension(VersionConvertorConstants.EXT_CODEABLE_REFERENCE_REFERENCE, Reference40_N.convertReference(src.getReference()));
      }
      return tgt;
    } else if (src.hasReference()) {
      return Reference40_N.convertReference(src.getReference());
    } else {
      return null;
    }
  }

  /**
   * The reverse of {@link #convertCodeableReferenceToChoice}: a CodeableConcept or Reference from an R4 choice
   * element, including a reference carried on the concept in the CodeableReference.reference extension
   */
  public static CodeableReference convertChoiceToCodeableReference(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null) return null;
    CodeableReference tgt = new CodeableReference();
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept) {
      org.hl7.fhir.r4.model.CodeableConcept cc = (org.hl7.fhir.r4.model.CodeableConcept) src;
      tgt.setConcept(convertCodeableConcept(cc));
      org.hl7.fhir.r4.model.Extension ext = cc.getExtensionByUrl(VersionConvertorConstants.EXT_CODEABLE_REFERENCE_REFERENCE);
      if (ext != null && ext.getValue() instanceof org.hl7.fhir.r4.model.Reference) {
        tgt.getConcept().removeExtension(VersionConvertorConstants.EXT_CODEABLE_REFERENCE_REFERENCE);
        tgt.setReference(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) ext.getValue()));
        if (tgt.getConcept().isEmpty()) {
          tgt.setConcept(null);
        }
      }
    } else if (src instanceof org.hl7.fhir.r4.model.Reference) {
      tgt.setReference(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) src));
    } else {
      throw new FHIRException("Unable to convert a " + src.fhirType() + " to a CodeableReference");
    }
    return tgt;
  }

  /**
   * For R4 Codings that became CodeableConcepts in R6: the first coding. If the concept has more than that (other
   * codings, text), the whole concept goes on the coding in the extension url, where
   * {@link #convertCodingToCodeableConcept(org.hl7.fhir.r4.model.Coding, String)} picks it up again
   */
  public static org.hl7.fhir.r4.model.Coding convertCodeableConceptToCoding(org.hl7.fhir.model.core.CodeableConcept src, String url) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Coding tgt = src.hasCoding() ? Coding40_N.convertCoding(src.getCodingFirstRep()) : new org.hl7.fhir.r4.model.Coding();
    if (src.getCodingList().size() != 1 || src.hasText() || src.hasId() || src.hasExtension())
      tgt.addExtension(url, convertCodeableConcept(src));
    return tgt;
  }

  /**
   * The reverse of {@link #convertCodeableConceptToCoding}
   */
  public static org.hl7.fhir.model.core.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.r4.model.Coding src, String url) throws FHIRException {
    if (src == null) return null;
    if (src.hasExtension(url) && src.getExtensionByUrl(url).getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(url).getValue());
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    tgt.addCoding(Coding40_N.convertCoding(src));
    return tgt;
  }

  /**
   * For R4 strings that became CodeableConcepts in R6: the text. If the concept has more than that (codings), the
   * string is the text (or the first code, if there's no text), and the whole concept goes on the string in the
   * extension url, where {@link #convertStringToCodeableConcept} picks it up again
   */
  public static org.hl7.fhir.r4.model.StringType convertCodeableConceptToString(org.hl7.fhir.model.core.CodeableConcept src, String url) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType(src.hasText() ? src.getText() : src.hasCoding() ? src.getCodingFirstRep().getCode() : null);
    if (src.hasCoding() || src.hasId() || src.hasExtension() || src.getTextElement().hasExtension())
      tgt.addExtension(url, convertCodeableConcept(src));
    return tgt;
  }

  /**
   * The reverse of {@link #convertCodeableConceptToString}
   */
  public static org.hl7.fhir.model.core.CodeableConcept convertStringToCodeableConcept(org.hl7.fhir.r4.model.StringType src, String url) throws FHIRException {
    if (src == null) return null;
    if (src.hasExtension(url) && src.getExtensionByUrl(url).getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(url).getValue());
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    tgt.setTextElement(String40_N.convertString(src));
    return tgt;
  }

  /**
   * R4 reasonCode + reasonReference to R6 reason (a list of CodeableReference): codes first, then references
   */
  public static void convertReasonsToR6(java.util.List<org.hl7.fhir.r4.model.CodeableConcept> codes, java.util.List<org.hl7.fhir.r4.model.Reference> references, java.util.List<CodeableReference> tgt) throws FHIRException {
    // if the R4 elements have group indexes (see convertReasonsToR4), that's the R6 order
    java.util.List<CodeableReference> list = new java.util.ArrayList<>();
    java.util.Map<CodeableReference, Integer> index = new java.util.IdentityHashMap<>();
    for (org.hl7.fhir.r4.model.CodeableConcept t : codes) {
      CodeableReference cr = convertCodeableConceptToCodeableReference(t);
      takeIndex(t, cr.getConcept(), cr, index);
      list.add(cr);
    }
    for (org.hl7.fhir.r4.model.Reference t : references) {
      CodeableReference cr = Reference40_N.convertReferenceToCodeableReference(t);
      takeIndex(t, cr.getReference(), cr, index);
      list.add(cr);
    }
    if (!index.isEmpty())
      list.sort((a, b) -> Integer.compare(index.getOrDefault(a, Integer.MAX_VALUE), index.getOrDefault(b, Integer.MAX_VALUE)));
    tgt.addAll(list);
  }

  private static void takeIndex(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.model.core.Element tgt, CodeableReference cr, java.util.Map<CodeableReference, Integer> index) {
    org.hl7.fhir.r4.model.Extension ext = src.getExtensionByUrl(VersionConvertorConstants.EXT_GROUP_INDEX);
    if (ext != null && ext.getValue() instanceof org.hl7.fhir.r4.model.IntegerType && ((org.hl7.fhir.r4.model.IntegerType) ext.getValue()).hasValue())
      index.put(cr, ((org.hl7.fhir.r4.model.IntegerType) ext.getValue()).getValue());
    if (tgt != null)
      tgt.getExtension().removeIf(e -> VersionConvertorConstants.EXT_GROUP_INDEX.equals(e.getUrl()));
  }

  /**
   * The reverse: a reason with a concept is a reasonCode (with any reference on it in the CodeableReference
   * extension), one with only a reference is a reasonReference
   */
  public static void convertReasonsToR4(java.util.List<CodeableReference> src, java.util.List<org.hl7.fhir.r4.model.CodeableConcept> codes, java.util.List<org.hl7.fhir.r4.model.Reference> references) throws FHIRException {
    // R4 has the codes before the references: if that changes the order, each gets its position in the R6 list in
    // a group index extension, and convertReasonsToR6 puts them back in that order
    boolean reordered = false;
    boolean sawReference = false;
    for (CodeableReference t : src) {
      if (t.hasConcept() && sawReference)
        reordered = true;
      if (!t.hasConcept() && t.hasReference())
        sawReference = true;
    }
    for (int i = 0; i < src.size(); i++) {
      CodeableReference t = src.get(i);
      org.hl7.fhir.r4.model.Element e = null;
      if (t.hasConcept()) {
        e = convertCodeableReferenceToCodeableConcept(t);
        codes.add((org.hl7.fhir.r4.model.CodeableConcept) e);
      } else if (t.hasReference()) {
        e = Reference40_N.convertReference(t.getReference());
        references.add((org.hl7.fhir.r4.model.Reference) e);
      }
      if (e != null && reordered)
        e.addExtension(VersionConvertorConstants.EXT_GROUP_INDEX, new org.hl7.fhir.r4.model.IntegerType(i));
    }
  }

  /**
   * For R6 CodeableConcepts that are codes in R4: if the R4 code (tgt) doesn't regenerate the R6 concept exactly
   * (regenerated is what it converts back to), the whole concept goes on the R4 element in the extension url, where
   * {@link #keptCodeableConcept} picks it up again
   */
  public static void keepCodeableConcept(org.hl7.fhir.model.core.CodeableConcept src, org.hl7.fhir.r4.model.Element tgt, org.hl7.fhir.model.core.CodeableConcept regenerated, String url) throws FHIRException {
    if (tgt != null && src != null && (regenerated == null || !src.equalsDeep(regenerated)))
      tgt.addExtension(url, convertCodeableConcept(src));
  }

  /**
   * The concept kept on an R4 element by {@link #keepCodeableConcept}, or null if there isn't one
   */
  public static org.hl7.fhir.model.core.CodeableConcept keptCodeableConcept(org.hl7.fhir.r4.model.Element src, String url) throws FHIRException {
    if (src != null && src.hasExtension(url) && src.getExtensionByUrl(url).getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(url).getValue());
    return null;
  }
}
