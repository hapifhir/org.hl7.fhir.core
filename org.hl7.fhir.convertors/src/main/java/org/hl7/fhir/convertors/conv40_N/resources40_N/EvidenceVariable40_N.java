package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.exceptions.FHIRException;

/**
 * R4 EvidenceVariable (characteristics, mostly for cohort definition) and R6 EvidenceVariable (a variable
 * definition) share little but the name and the metadata. The shared elements are copied, and everything else is a
 * cross-version extension both ways
 */
public class EvidenceVariable40_N {

  // the same element in R4 and R6
  private static final String[] SAME = {"url", "identifier", "version", "name", "title", "status", "date", "publisher", "contact", "description", "useContext", "note", "copyright", "approvalDate", "lastReviewDate", "author", "editor", "reviewer", "endorser", "shortTitle", "effectivePeriod"};
  // R4 elements that R6 doesn't have: 4.0 extensions in R6
  private static final String[] R4_ONLY = {"subtitle", "jurisdiction", "topic", "relatedArtifact", "type", "characteristic"};
  // R6 elements that R4 doesn't have: 5.0 and 6.0 extensions in R4
  private static final String[] V5 = {"versionAlgorithm", "experimental", "purpose", "copyrightLabel", "actual", "handling", "category"};
  private static final String[] V6 = {"citeAs", "recorder", "relatesTo", "definition", "definitionModifier", "conditional", "classifier", "dataStorage", "timing", "period", "constraint", "missingDataMeaning", "unacceptableDataHandling"};

  public static org.hl7.fhir.model.core.EvidenceVariable convertEvidenceVariable(org.hl7.fhir.r4.model.EvidenceVariable src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EvidenceVariable tgt = new org.hl7.fhir.model.core.EvidenceVariable();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("EvidenceVariable", "5.0", V5, CrossVersionElements40_N.urls("EvidenceVariable", "6.0", V6)));
    CrossVersionElements40_N.copySameElements(src, tgt, SAME);
    CrossVersionElements40_N.r4ElementsToExtensions(src, "EvidenceVariable", tgt.getExtension(), R4_ONLY);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EvidenceVariable convertEvidenceVariable(org.hl7.fhir.model.core.EvidenceVariable src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EvidenceVariable tgt = new org.hl7.fhir.r4.model.EvidenceVariable();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("EvidenceVariable", "4.0", R4_ONLY));
    CrossVersionElements40_N.copySameElements(src, tgt, SAME);
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "EvidenceVariable", R4_ONLY);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    return tgt;
  }
}
