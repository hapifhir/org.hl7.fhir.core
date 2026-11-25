package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.exceptions.FHIRException;

/**
 * R4 Evidence (a definition of the exposures and outcomes evidence is about) and R6 Evidence (the evidence itself -
 * variables, statistics, certainty) share little but the name and the metadata. The shared elements are copied, and
 * everything else is a cross-version extension both ways
 */
public class Evidence40_N {

  // the same element in R4 and R6
  private static final String[] SAME = {"url", "identifier", "version", "name", "title", "status", "date", "publisher", "contact", "description", "useContext", "note", "copyright", "approvalDate", "lastReviewDate", "author", "editor", "reviewer", "endorser"};
  // R4 elements that R6 doesn't have: 4.0 extensions in R6
  private static final String[] R4_ONLY = {"shortTitle", "subtitle", "jurisdiction", "effectivePeriod", "topic", "relatedArtifact", "exposureBackground", "exposureVariant", "outcome"};
  // R6 elements that R4 doesn't have: 5.0 and 6.0 extensions in R4
  private static final String[] V5 = {"versionAlgorithm", "experimental", "citeAs", "purpose", "copyrightLabel", "assertion", "variableDefinition", "synthesisType", "studyDesign", "statistic", "certainty"};
  private static final String[] V6 = {"recorder", "relatesTo", "classification"};

  public static org.hl7.fhir.model.core.Evidence convertEvidence(org.hl7.fhir.r4.model.Evidence src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Evidence tgt = new org.hl7.fhir.model.core.Evidence();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("Evidence", "5.0", V5, CrossVersionElements40_N.urls("Evidence", "6.0", V6)));
    CrossVersionElements40_N.copySameElements(src, tgt, SAME);
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Evidence", tgt.getExtension(), R4_ONLY);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Evidence convertEvidence(org.hl7.fhir.model.core.Evidence src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Evidence tgt = new org.hl7.fhir.r4.model.Evidence();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Evidence", "4.0", R4_ONLY));
    CrossVersionElements40_N.copySameElements(src, tgt, SAME);
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Evidence", R4_ONLY);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    return tgt;
  }
}
