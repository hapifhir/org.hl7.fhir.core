package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.exceptions.FHIRException;

/**
 * Device.deviceName.type and DeviceDefinition.deviceName.type: an R4 code, an R6 CodeableConcept, with fewer codes.
 * <ul>
 *   <li>user-friendly-name and patient-reported-name are the same in both; R4 manufacturer-name is R6 registered-name,
 *     and R4 model-name is R6 user-friendly-name (as for R4 to R5)</li>
 *   <li>R4 to R6: the R4 code is kept (codeUrl, a 4.0 extension on the concept) unless it's one of the three that R6
 *     has too</li>
 *   <li>R6 to R4: a concept with none of the R6 codes is R4 'other' (the code is required in R4), and the R6 concept
 *     is kept (conceptUrl, a 6.0 extension on the code) when the R4 code can't make it again</li>
 * </ul>
 */
public class DeviceNameType40_N {

  private static final String SYSTEM = "http://terminology.hl7.org/CodeSystem/device-nametype";
  private static final String SYSTEM_R4 = "http://hl7.org/fhir/device-nametype";

  public static org.hl7.fhir.model.core.CodeableConcept convertToR6(org.hl7.fhir.r4.model.Enumeration<?> src, String codeUrl, String conceptUrl) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.CodeableConcept kept = CodeableConcept40_N.keptCodeableConcept(src, conceptUrl);
    if (kept != null)
      return kept;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, conceptUrl);
    String code = src.getValueAsString();
    if (code != null) {
      switch (code) {
        case "user-friendly-name":
        case "model-name":
          tgt.addCoding(SYSTEM, "user-friendly-name", "User Friendly name");
          break;
        case "patient-reported-name":
          tgt.addCoding(SYSTEM, "patient-reported-name", "Patient Reported name");
          break;
        case "manufacturer-name":
          tgt.addCoding(SYSTEM, "registered-name", "Registered name");
          break;
        default:
          break;
      }
      if (!org.hl7.fhir.utilities.Utilities.existsInList(code, "user-friendly-name", "patient-reported-name", "manufacturer-name"))
        tgt.addExtension(codeUrl, new org.hl7.fhir.model.core.CodeType(code));
    }
    return tgt;
  }

  /**
   * @param tgt a new (empty) R4 enumeration, which this fills in
   */
  public static <T extends org.hl7.fhir.r4.model.Enumeration<?>> T convertToR4(org.hl7.fhir.model.core.CodeableConcept src, T tgt, String codeUrl, String conceptUrl) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, codeUrl);
    if (src.hasExtension(codeUrl))
      tgt.setValueAsString(src.getExtensionByUrl(codeUrl).getValue().primitiveValue());
    else if (src.hasCoding(SYSTEM, "user-friendly-name") || src.hasCoding(SYSTEM_R4, "user-friendly-name"))
      tgt.setValueAsString("user-friendly-name");
    else if (src.hasCoding(SYSTEM, "patient-reported-name") || src.hasCoding(SYSTEM_R4, "patient-reported-name"))
      tgt.setValueAsString("patient-reported-name");
    else if (src.hasCoding(SYSTEM, "registered-name") || src.hasCoding(SYSTEM_R4, "registered-name"))
      tgt.setValueAsString("manufacturer-name");
    else
      tgt.setValueAsString("other");
    // the R4 code doesn't carry all of the R6 concept: if it can't make the same concept again, keep the concept
    org.hl7.fhir.r4.model.Enumeration<?> plain = tgt.copy();
    plain.getExtension().clear();
    CodeableConcept40_N.keepCodeableConcept(src, tgt, convertToR6(plain, codeUrl, conceptUrl), conceptUrl);
    return tgt;
  }
}
