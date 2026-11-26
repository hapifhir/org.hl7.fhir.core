package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DosageDetails;

/**
 * R4 has a list of Dosage (MedicationRequest.dosageInstruction etc); R6 has a single DosageDetails, which has steps,
 * and each step has components (Dosages).
 *
 *  - R4 to R6: the dosages are grouped by sequence, in sequence order, and each sequence is a step; each dosage is a
 *    component of its step. A dosage with no sequence is a step on its own. The sequence itself is kept on each
 *    component as a cross-version extension (see Dosage40_N), unless it's what going back to R4 makes anyway
 *    If grouping by sequence changes the order of the dosages, each component gets the position of its R4 dosage
 *    (counting from 0) in a group index extension (VersionConvertorConstants.EXT_GROUP_INDEX)
 *  - R6 to R4: each component of each step is a dosage. If there's no sequence extension, and there's more than one
 *    dosage, the sequence is the step number (counting from 1). If the components have group indexes, the dosages
 *    are put back in that order
 *
 * R4 has nothing for the rest of DosageDetails: renderedInstruction and safety are 6.0 extensions on the resource
 * ([path].renderedInstruction etc, where path is the R6 path of the DosageDetails element), and the step's start,
 * end, count and safety are 6.0 extensions ([path].step.start etc) on the first dosage of the step
 */
public class DosageDetails40_N {

  private static final String DATA_ABSENT_REASON = "http://hl7.org/fhir/StructureDefinition/data-absent-reason";
  private static final String[] DETAILS = {"renderedInstruction", "safety"};
  private static final String[] STEP = {"start", "end", "count", "safety"};

  /**
   * R4 to R6
   *
   * @param src the R4 dosages
   * @param srcExtensions the extensions on the R4 resource (for renderedInstruction and safety)
   * @param tgtExtensions the extensions on the R6 resource (the extensions for renderedInstruction and safety are removed)
   * @param path the R6 path of the DosageDetails element, e.g. MedicationRequest.dosageInstruction
   * @param tgt the R6 DosageDetails
   */
  public static void convertDosages(List<org.hl7.fhir.r4.model.Dosage> src, List<org.hl7.fhir.r4.model.Extension> srcExtensions,
                                    List<org.hl7.fhir.model.core.Extension> tgtExtensions, String path, DosageDetails tgt) throws FHIRException {
    CrossVersionElements40_N.extensionsToElementsForPath(srcExtensions, tgt, path, "6.0", DETAILS);
    removeExtensions(tgtExtensions, path, DETAILS);

    // group by sequence, in sequence order (a dosage with no sequence is a group of its own)
    List<org.hl7.fhir.r4.model.Dosage> sorted = new ArrayList<>(src);
    sorted.sort((a, b) -> Integer.compare(a.hasSequence() ? a.getSequence() : Integer.MAX_VALUE, b.hasSequence() ? b.getSequence() : Integer.MAX_VALUE));
    Map<Object, List<org.hl7.fhir.r4.model.Dosage>> groups = new LinkedHashMap<>();
    for (org.hl7.fhir.r4.model.Dosage d : sorted)
      groups.computeIfAbsent(d.hasSequence() ? (Object) d.getSequence() : new Object(), k -> new ArrayList<>()).add(d);

    // if grouping changed the order, each component records where its dosage was
    List<org.hl7.fhir.r4.model.Dosage> grouped = new ArrayList<>();
    for (List<org.hl7.fhir.r4.model.Dosage> group : groups.values())
      grouped.addAll(group);
    boolean reordered = !grouped.equals(src);

    int i = 0;
    String sequenceUrl = CrossVersionElements40_N.url("Dosage", "4.0", "sequence");
    for (List<org.hl7.fhir.r4.model.Dosage> group : groups.values()) {
      i++;
      DosageDetails.DosageDetailsStepComponent step = tgt.addStep();
      for (org.hl7.fhir.r4.model.Dosage d : group) {
        org.hl7.fhir.model.core.Dosage c = Dosage40_N.convertDosage(d);
        if (reordered)
          c.addExtension(VersionConvertorConstants.EXT_GROUP_INDEX, new org.hl7.fhir.model.core.IntegerType(src.indexOf(d)));
        // the sequence extension is only needed if going back to R4 wouldn't make the same sequence
        if (src.size() > 1 && d.hasSequence() && d.getSequence() == i && !d.getSequenceElement().hasExtension() && !d.getSequenceElement().hasId())
          c.getExtension().removeIf(ext -> sequenceUrl.equals(ext.getUrl()));
        // one of several dosages with no sequence: going back to R4 would make one, so the extension says there isn't
        if (src.size() > 1 && !d.hasSequence()) {
          org.hl7.fhir.model.core.IntegerType none = new org.hl7.fhir.model.core.IntegerType();
          none.addExtension(DATA_ABSENT_REASON, new org.hl7.fhir.model.core.CodeType("not-applicable"));
          c.addExtension(sequenceUrl, none);
        }
        if (step.getComponentList().isEmpty()) {
          CrossVersionElements40_N.extensionsToElementsForPath(d.getExtension(), step, path + ".step", "6.0", STEP);
          removeExtensions(c.getExtension(), path + ".step", STEP);
        }
        step.addComponent(c);
      }
    }
  }

  /**
   * R6 to R4
   *
   * @param src the R6 DosageDetails
   * @param path the R6 path of the DosageDetails element, e.g. MedicationRequest.dosageInstruction
   * @param tgt the R4 dosages
   * @param tgtExtensions the extensions on the R4 resource (for renderedInstruction and safety)
   */
  public static void convertDosageDetails(DosageDetails src, String path, List<org.hl7.fhir.r4.model.Dosage> tgt,
                                          List<org.hl7.fhir.r4.model.Extension> tgtExtensions) throws FHIRException {
    if (src == null || src.isEmpty())
      return;
    CrossVersionElements40_N.elementsToExtensionsForPath(src, path, tgtExtensions, "6.0", DETAILS);
    int i = 0;
    int count = 0;
    for (DosageDetails.DosageDetailsStepComponent step : src.getStepList())
      count += step.getComponentList().size();
    boolean several = count > 1;
    List<org.hl7.fhir.r4.model.Dosage> dosages = new ArrayList<>();
    Map<org.hl7.fhir.r4.model.Dosage, Integer> index = new java.util.IdentityHashMap<>();
    for (DosageDetails.DosageDetailsStepComponent step : src.getStepList()) {
      i++;
      boolean first = true;
      for (org.hl7.fhir.model.core.Dosage c : step.getComponentList()) {
        org.hl7.fhir.r4.model.Dosage d = Dosage40_N.convertDosage(c);
        if (d.hasSequenceElement() && !d.getSequenceElement().hasValue() && d.getSequenceElement().hasExtension(DATA_ABSENT_REASON))
          // the R4 dosage had no sequence (see above)
          d.setSequenceElement(null);
        else if (!d.hasSequence() && several)
          d.setSequence(i);
        if (first)
          CrossVersionElements40_N.elementsToExtensionsForPath(step, path + ".step", d.getExtension(), "6.0", STEP);
        first = false;
        org.hl7.fhir.r4.model.Extension gx = d.getExtensionByUrl(VersionConvertorConstants.EXT_GROUP_INDEX);
        if (gx != null && gx.getValue() instanceof org.hl7.fhir.r4.model.IntegerType && ((org.hl7.fhir.r4.model.IntegerType) gx.getValue()).hasValue())
          index.put(d, ((org.hl7.fhir.r4.model.IntegerType) gx.getValue()).getValue());
        d.getExtension().removeIf(ext -> VersionConvertorConstants.EXT_GROUP_INDEX.equals(ext.getUrl()));
        dosages.add(d);
      }
    }
    // back into the R4 order, if it was recorded (dosages without an index go after the ones with one, in step order)
    if (!index.isEmpty())
      dosages.sort((a, b) -> Integer.compare(index.getOrDefault(a, Integer.MAX_VALUE), index.getOrDefault(b, Integer.MAX_VALUE)));
    tgt.addAll(dosages);
  }

  /**
   * the urls for the extensions this uses on the resource, so the resource's copy can leave them out
   */
  public static String[] urls(String path) {
    return CrossVersionElements40_N.urls(path, "6.0", DETAILS);
  }

  private static void removeExtensions(List<org.hl7.fhir.model.core.Extension> extensions, String path, String[] names) {
    for (String name : names) {
      String url = CrossVersionElements40_N.url(path, "6.0", name);
      extensions.removeIf(ext -> url.equals(ext.getUrl()));
    }
  }
}
