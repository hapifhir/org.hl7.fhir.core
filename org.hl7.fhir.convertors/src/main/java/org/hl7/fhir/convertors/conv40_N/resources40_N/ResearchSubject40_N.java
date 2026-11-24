package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.ResearchSubject;

/**
 * R4 ResearchSubject <-> R6 ResearchSubject
 *
 * status        R4 status is the subject's progress (http://hl7.org/fhir/research-subject-status). In R6 that's a
 *               subjectState with that code; R6 status is a (required) publication status, which defaults to
 *               unknown, and anything but a plain unknown is a 5.0 extension in R4. Going back, R4 status is the
 *               code of the last subjectState with a code in that system; that subjectState isn't kept unless it's
 *               more than the code, and the other subjectStates are 6.0 extensions
 * individual    is R6 subject
 * assignedArm,  are the names of R4 ResearchStudy arms: 4.0 extensions
 * actualArm
 * consent       R6 has many: the first, and the rest as 6.0 extensions
 */
public class ResearchSubject40_N {

  public static final String STATUS_SYSTEM = "http://hl7.org/fhir/research-subject-status";
  private static final String[] R4_ONLY = {"assignedArm", "actualArm"};
  private static final String[] V6 = {"subjectMilestone", "comparisonGroup"};

  public static ResearchSubject convertResearchSubject(org.hl7.fhir.r4.model.ResearchSubject src) throws FHIRException {
    if (src == null)
      return null;
    ResearchSubject tgt = new ResearchSubject();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls("ResearchSubject", "6.0", V6, CrossVersionElements40_N.url("ResearchSubject", "5.0", "status"),
        CrossVersionElements40_N.url("ResearchSubject", "6.0", "subjectState"), CrossVersionElements40_N.url("ResearchSubject", "6.0", "consent")));
    CrossVersionElements40_N.r4ElementsToExtensions(src, "ResearchSubject", tgt.getExtension(), R4_ONLY);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    // R6 status is required, and R4 doesn't have one: unknown, unless the extension says otherwise
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "status");
    if (!tgt.hasStatus())
      tgt.setStatus(PublicationStatus.UNKNOWN);
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasStudy())
      tgt.setStudy(Reference40_N.convertReference(src.getStudy()));
    if (src.hasIndividual())
      tgt.setSubject(Reference40_N.convertReference(src.getIndividual()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "subjectState");
    if (src.hasStatus() && !hasState(tgt, src.getStatusElement().getValueAsString())) {
      ResearchSubject.ResearchSubjectSubjectStateComponent state = tgt.addSubjectState();
      state.getCode().addCoding().setSystem(STATUS_SYSTEM).setCode(src.getStatusElement().getValueAsString());
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    if (src.hasConsent())
      tgt.addConsent(Reference40_N.convertReference(src.getConsent()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "consent");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ResearchSubject convertResearchSubject(ResearchSubject src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ResearchSubject tgt = new org.hl7.fhir.r4.model.ResearchSubject();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("ResearchSubject", "4.0", R4_ONLY));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "ResearchSubject", R4_ONLY);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus() && (src.getStatus() != PublicationStatus.UNKNOWN || src.getStatusElement().hasExtension() || src.getStatusElement().hasId()))
      CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "status");
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasStudy())
      tgt.setStudy(Reference40_N.convertReference(src.getStudy()));
    if (src.hasSubject())
      tgt.setIndividual(Reference40_N.convertReference(src.getSubject()));
    ResearchSubject.ResearchSubjectSubjectStateComponent status = null;
    for (ResearchSubject.ResearchSubjectSubjectStateComponent t : src.getSubjectStateList())
      if (t.getCode().hasCoding(STATUS_SYSTEM))
        status = t;
    if (status != null) {
      try {
        tgt.getStatusElement().setValueAsString(codeInSystem(status));
      } catch (Exception e) {
        // R6 has codes R4 doesn't: then there's no R4 status, and the subjectState is kept
        tgt.setStatusElement(null);
        status = null;
      }
    }
    String url = CrossVersionElements40_N.url("ResearchSubject", "6.0", "subjectState");
    for (ResearchSubject.ResearchSubjectSubjectStateComponent t : src.getSubjectStateList())
      if (t != status || !isJustTheCode(t))
        tgt.addExtension(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N.convertToExtension(url, t));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    for (org.hl7.fhir.model.core.Reference t : src.getConsentList())
      if (!tgt.hasConsent())
        tgt.setConsent(Reference40_N.convertReference(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("ResearchSubject", "6.0", "consent"), Reference40_N.convertReference(t));
    return tgt;
  }

  private static String codeInSystem(ResearchSubject.ResearchSubjectSubjectStateComponent state) {
    for (org.hl7.fhir.model.core.Coding c : state.getCode().getCodingList())
      if (STATUS_SYSTEM.equals(c.getSystem()))
        return c.getCode();
    return null;
  }

  // a subjectState that the R4 status code makes again exactly
  private static boolean isJustTheCode(ResearchSubject.ResearchSubjectSubjectStateComponent state) {
    ResearchSubject.ResearchSubjectSubjectStateComponent regenerated = new ResearchSubject.ResearchSubjectSubjectStateComponent();
    regenerated.getCode().addCoding().setSystem(STATUS_SYSTEM).setCode(codeInSystem(state));
    return state.equalsDeep(regenerated);
  }

  private static boolean hasState(ResearchSubject tgt, String code) {
    for (ResearchSubject.ResearchSubjectSubjectStateComponent t : tgt.getSubjectStateList())
      if (t.getCode().hasCoding(STATUS_SYSTEM, code))
        return true;
    return false;
  }
}
