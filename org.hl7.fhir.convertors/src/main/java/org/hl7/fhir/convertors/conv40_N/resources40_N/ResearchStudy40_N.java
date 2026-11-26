package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.ResearchStudy;

/**
 * R4 ResearchStudy <-> R6 ResearchStudy
 *
 * status               R4 status is the study's progress (http://hl7.org/fhir/research-study-status). In R6 that's
 *                      an actual progressStatus with that state; R6 status is a (required) publication status, which
 *                      defaults to unknown, and anything but a plain unknown is a 5.0 extension in R4. Going back, R4
 *                      status is the state of the last actual progressStatus with a code in that system; that
 *                      progressStatus isn't kept unless it's more than the code, and the others are 5.0 extensions
 * primaryPurposeType   is the first R6 purposeType; the others are 6.0 extensions
 * category, location,  are R6 classifier, region, whyStopped
 * reasonStopped
 * enrollment           the first is R6 recruitment.eligibility, the others are 4.0 extensions. The rest of R6
 *                      recruitment is extensions
 * sponsor,             are R6 associatedParty, with the sponsor and primary-investigator roles. Any other
 * principalInvestigator associatedParty is a 5.0 extension
 * arm                  is R6 comparisonGroup; arm.type is a 4.0 extension
 * contact,             4.0 extensions
 * relatedArtifact
 */
public class ResearchStudy40_N {

  public static final String STATUS_SYSTEM = "http://hl7.org/fhir/research-study-status";
  public static final String ROLE_SYSTEM = "http://hl7.org/fhir/research-study-party-role";
  private static final String RS = "ResearchStudy";
  private static final String RECRUITMENT = "ResearchStudy.recruitment";
  private static final String[] SAME = {"identifier", "title", "protocol", "partOf", "phase", "condition", "keyword", "description", "period", "site", "note"};
  private static final String[] R4_ONLY = {"contact", "relatedArtifact"};
  private static final String[] V5 = {"url", "version", "name", "label", "date", "studyDesign", "descriptionSummary", "result"};
  private static final String[] V6 = {"citeAs", "relatesTo"};
  private static final String[] RECRUITMENT_V5 = {"targetNumber", "actualNumber", "actualGroup"};
  private static final String[] RECRUITMENT_V6 = {"description"};
  private static final String STATUS_URL = CrossVersionElements40_N.url(RS, "5.0", "status");
  private static final String PROGRESS_URL = CrossVersionElements40_N.url(RS, "5.0", "progressStatus");
  private static final String PURPOSE_URL = CrossVersionElements40_N.url(RS, "6.0", "purposeType");
  private static final String PARTY_URL = CrossVersionElements40_N.url(RS, "5.0", "associatedParty");
  private static final String ENROLLMENT_URL = CrossVersionElements40_N.url(RS, "4.0", "enrollment");

  public static ResearchStudy convertResearchStudy(org.hl7.fhir.r4.model.ResearchStudy src) throws FHIRException {
    if (src == null)
      return null;
    ResearchStudy tgt = new ResearchStudy();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls(RS, "5.0", V5, CrossVersionElements40_N.urls(RS, "6.0", V6,
        CrossVersionElements40_N.urls(RECRUITMENT, "5.0", RECRUITMENT_V5, CrossVersionElements40_N.urls(RECRUITMENT, "6.0", RECRUITMENT_V6,
          STATUS_URL, PROGRESS_URL, PURPOSE_URL, PARTY_URL)))));
    CrossVersionElements40_N.r4ElementsToExtensions(src, RS, tgt.getExtension(), R4_ONLY);
    CrossVersionElements40_N.copySameElements(src, tgt, SAME);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", V6);
    // status
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "status", "progressStatus");
    if (!tgt.hasStatus())
      tgt.setStatus(PublicationStatus.UNKNOWN);
    if (src.hasStatus() && !hasProgress(tgt, src.getStatusElement().getValueAsString()))
      tgt.addProgressStatus(progressFor(src.getStatusElement().getValueAsString()));
    // purpose, classifier, region, why stopped, focus
    if (src.hasPrimaryPurposeType())
      tgt.addPurposeType(CodeableConcept40_N.convertCodeableConcept(src.getPrimaryPurposeType()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "purposeType");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addClassifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLocation())
      tgt.addRegion(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasReasonStopped())
      tgt.setWhyStopped(CodeableConcept40_N.convertCodeableConcept(src.getReasonStopped()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFocus())
      tgt.addFocus(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    // enrollment -> recruitment
    for (org.hl7.fhir.r4.model.Reference t : src.getEnrollment())
      if (!tgt.getRecruitment().hasEligibility())
        tgt.getRecruitment().setEligibility(Reference40_N.convertReference(t));
      else
        tgt.addExtension(ENROLLMENT_URL, Reference40_N.convertReference(t));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt.getRecruitment(), RECRUITMENT, "5.0", RECRUITMENT_V5);
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt.getRecruitment(), RECRUITMENT, "6.0", RECRUITMENT_V6);
    // sponsor, principalInvestigator -> associatedParty
    // (unless the extension has them as well - see below)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "associatedParty");
    java.util.List<ResearchStudy.ResearchStudyAssociatedPartyComponent> others = new java.util.ArrayList<>(tgt.getAssociatedPartyList());
    tgt.getAssociatedPartyList().clear();
    if (src.hasSponsor()) {
      ResearchStudy.ResearchStudyAssociatedPartyComponent p = partyFor("sponsor", Reference40_N.convertReference(src.getSponsor()));
      if (others.stream().noneMatch(o -> o.equalsDeep(p)))
        tgt.addAssociatedParty(p);
    }
    if (src.hasPrincipalInvestigator()) {
      ResearchStudy.ResearchStudyAssociatedPartyComponent p = partyFor("primary-investigator", Reference40_N.convertReference(src.getPrincipalInvestigator()));
      if (others.stream().noneMatch(o -> o.equalsDeep(p)))
        tgt.addAssociatedParty(p);
    }
    tgt.getAssociatedPartyList().addAll(others);
    for (org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent t : src.getArm())
      tgt.addComparisonGroup(convertArm(t));
    for (org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent t : src.getObjective())
      tgt.addObjective(convertObjective(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ResearchStudy convertResearchStudy(ResearchStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ResearchStudy tgt = new org.hl7.fhir.r4.model.ResearchStudy();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls(RS, "4.0", R4_ONLY, ENROLLMENT_URL));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, RS, R4_ONLY);
    CrossVersionElements40_N.copySameElements(src, tgt, SAME);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", V6);
    // status
    if (src.hasStatus() && (src.getStatus() != PublicationStatus.UNKNOWN || src.getStatusElement().hasExtension() || src.getStatusElement().hasId()))
      CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "status");
    ResearchStudy.ResearchStudyProgressStatusComponent status = null;
    for (ResearchStudy.ResearchStudyProgressStatusComponent t : src.getProgressStatusList())
      if (t.getActual() && t.getState().hasCoding(STATUS_SYSTEM))
        status = t;
    if (status != null) {
      try {
        tgt.getStatusElement().setValueAsString(codeInSystem(status.getState()));
      } catch (Exception e) {
        // R6 has codes R4 doesn't: then there's no R4 status, and the progressStatus is kept
        tgt.setStatusElement(null);
        status = null;
      }
    }
    for (ResearchStudy.ResearchStudyProgressStatusComponent t : src.getProgressStatusList())
      if (t != status || !t.equalsDeep(progressFor(codeInSystem(t.getState()))))
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(PROGRESS_URL, t));
    // purpose, classifier, region, why stopped, focus
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getPurposeTypeList())
      if (!tgt.hasPrimaryPurposeType())
        tgt.setPrimaryPurposeType(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(PURPOSE_URL, CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getClassifierList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRegionList())
      tgt.addLocation(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasWhyStopped())
      tgt.setReasonStopped(CodeableConcept40_N.convertCodeableConcept(src.getWhyStopped()));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getFocusList())
      tgt.addFocus(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
    // recruitment -> enrollment
    if (src.hasRecruitment()) {
      if (src.getRecruitment().hasEligibility())
        tgt.addEnrollment(Reference40_N.convertReference(src.getRecruitment().getEligibility()));
      CrossVersionElements40_N.elementsToExtensionsForPath(src.getRecruitment(), RECRUITMENT, tgt.getExtension(), "5.0", RECRUITMENT_V5);
      CrossVersionElements40_N.elementsToExtensionsForPath(src.getRecruitment(), RECRUITMENT, tgt.getExtension(), "6.0", RECRUITMENT_V6);
    }
    for (org.hl7.fhir.model.core.Extension e : src.getExtensionsByUrl(ENROLLMENT_URL))
      tgt.addEnrollment(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) e.getValue()));
    // associatedParty -> sponsor, principalInvestigator
    // going back, the sponsor and principal investigator come first: if that would change the order, all the parties
    // are in the extension (and R4 to R6 leaves out the sponsor and principal investigator it finds there)
    ResearchStudy.ResearchStudyAssociatedPartyComponent sponsor = null;
    ResearchStudy.ResearchStudyAssociatedPartyComponent pi = null;
    for (ResearchStudy.ResearchStudyAssociatedPartyComponent t : src.getAssociatedPartyList()) {
      if (sponsor == null && isParty(t, "sponsor"))
        sponsor = t;
      else if (pi == null && isParty(t, "primary-investigator"))
        pi = t;
    }
    java.util.List<ResearchStudy.ResearchStudyAssociatedPartyComponent> order = new java.util.ArrayList<>();
    if (sponsor != null)
      order.add(sponsor);
    if (pi != null)
      order.add(pi);
    for (ResearchStudy.ResearchStudyAssociatedPartyComponent t : src.getAssociatedPartyList())
      if (t != sponsor && t != pi)
        order.add(t);
    boolean all = false;
    for (int i = 0; i < order.size(); i++)
      all = all || order.get(i) != src.getAssociatedPartyList().get(i);
    if (sponsor != null)
      tgt.setSponsor(Reference40_N.convertReference(sponsor.getParty()));
    if (pi != null)
      tgt.setPrincipalInvestigator(Reference40_N.convertReference(pi.getParty()));
    for (ResearchStudy.ResearchStudyAssociatedPartyComponent t : src.getAssociatedPartyList())
      if (all || (t != sponsor && t != pi))
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(PARTY_URL, t));
    for (ResearchStudy.ResearchStudyComparisonGroupComponent t : src.getComparisonGroupList())
      tgt.addArm(convertArm(t));
    for (ResearchStudy.ResearchStudyObjectiveComponent t : src.getObjectiveList())
      tgt.addObjective(convertObjective(t));
    return tgt;
  }

  private static String codeInSystem(org.hl7.fhir.model.core.CodeableConcept cc) {
    for (org.hl7.fhir.model.core.Coding c : cc.getCodingList())
      if (STATUS_SYSTEM.equals(c.getSystem()))
        return c.getCode();
    return null;
  }

  private static ResearchStudy.ResearchStudyProgressStatusComponent progressFor(String code) {
    ResearchStudy.ResearchStudyProgressStatusComponent tgt = new ResearchStudy.ResearchStudyProgressStatusComponent();
    tgt.getState().addCoding().setSystem(STATUS_SYSTEM).setCode(code);
    tgt.setActual(true);
    return tgt;
  }

  private static boolean hasProgress(ResearchStudy tgt, String code) {
    for (ResearchStudy.ResearchStudyProgressStatusComponent t : tgt.getProgressStatusList())
      if (t.getActual() && t.getState().hasCoding(STATUS_SYSTEM, code))
        return true;
    return false;
  }

  private static ResearchStudy.ResearchStudyAssociatedPartyComponent partyFor(String role, org.hl7.fhir.model.core.Reference party) {
    ResearchStudy.ResearchStudyAssociatedPartyComponent tgt = new ResearchStudy.ResearchStudyAssociatedPartyComponent();
    tgt.getRole().addCoding().setSystem(ROLE_SYSTEM).setCode(role);
    tgt.setParty(party);
    return tgt;
  }

  // an associatedParty that R4 sponsor or principalInvestigator makes again exactly
  private static boolean isParty(ResearchStudy.ResearchStudyAssociatedPartyComponent src, String role) {
    return src.hasParty() && src.equalsDeep(partyFor(role, src.getParty()));
  }

  private static final String ARM = "ResearchStudy.arm";
  private static final String GROUP = "ResearchStudy.comparisonGroup";
  private static final String[] GROUP_V5 = {"observedGroup"};
  private static final String[] GROUP_V6 = {"targetNumber", "actualNumber", "eligibility"};

  public static ResearchStudy.ResearchStudyComparisonGroupComponent convertArm(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent src) throws FHIRException {
    ResearchStudy.ResearchStudyComparisonGroupComponent tgt = new ResearchStudy.ResearchStudyComparisonGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.urls(GROUP, "5.0", GROUP_V5, CrossVersionElements40_N.urls(GROUP, "6.0", GROUP_V6)));
    CrossVersionElements40_N.r4ElementsToExtensions(src, ARM, tgt.getExtension(), "type");
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertStringToMarkdown(src.getDescriptionElement()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, GROUP, "5.0", GROUP_V5);
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, GROUP, "6.0", GROUP_V6);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent convertArm(ResearchStudy.ResearchStudyComparisonGroupComponent src) throws FHIRException {
    org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent tgt = new org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url(ARM, "4.0", "type"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, ARM, "type");
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription()) {
      tgt.setDescription(src.getDescription());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getDescriptionElement(), tgt.getDescriptionElement());
    }
    CrossVersionElements40_N.elementsToExtensionsForPath(src, GROUP, tgt.getExtension(), "5.0", GROUP_V5);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, GROUP, tgt.getExtension(), "6.0", GROUP_V6);
    return tgt;
  }

  private static final String OBJECTIVE = "ResearchStudy.objective";

  public static ResearchStudy.ResearchStudyObjectiveComponent convertObjective(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent src) throws FHIRException {
    ResearchStudy.ResearchStudyObjectiveComponent tgt = new ResearchStudy.ResearchStudyObjectiveComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.url(OBJECTIVE, "5.0", "description"), CrossVersionElements40_N.url(OBJECTIVE, "6.0", "outcomeMeasure"));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, OBJECTIVE, "5.0", "description");
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, OBJECTIVE, "6.0", "outcomeMeasure");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent convertObjective(ResearchStudy.ResearchStudyObjectiveComponent src) throws FHIRException {
    org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent tgt = new org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    CrossVersionElements40_N.elementsToExtensionsForPath(src, OBJECTIVE, tgt.getExtension(), "5.0", "description");
    CrossVersionElements40_N.elementsToExtensionsForPath(src, OBJECTIVE, tgt.getExtension(), "6.0", "outcomeMeasure");
    return tgt;
  }
}
