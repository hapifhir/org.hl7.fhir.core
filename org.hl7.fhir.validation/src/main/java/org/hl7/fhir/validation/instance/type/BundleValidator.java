package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.EntrySummary;
import org.hl7.fhir.validation.instance.utils.IndexedElement;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class BundleValidator extends BaseValidator{
  public final static String URI_REGEX3 = "((http|https)://([A-Za-z0-9\\\\\\.\\:\\%\\$]*\\/)*)?(Account|ActivityDefinition|AllergyIntolerance|AdverseEvent|Appointment|AppointmentResponse|AuditEvent|Basic|Binary|BodySite|Bundle|CapabilityStatement|CarePlan|CareTeam|ChargeItem|Claim|ClaimResponse|ClinicalImpression|CodeSystem|Communication|CommunicationRequest|CompartmentDefinition|Composition|ConceptMap|Condition (aka Problem)|Consent|Contract|Coverage|DataElement|DetectedIssue|Device|DeviceComponent|DeviceMetric|DeviceRequest|DeviceUseStatement|DiagnosticReport|DocumentManifest|DocumentReference|EligibilityRequest|EligibilityResponse|Encounter|Endpoint|EnrollmentRequest|EnrollmentResponse|EpisodeOfCare|ExpansionProfile|ExplanationOfBenefit|FamilyMemberHistory|Flag|Goal|GraphDefinition|Group|GuidanceResponse|HealthcareService|ImagingManifest|ImagingStudy|Immunization|ImmunizationRecommendation|ImplementationGuide|Library|Linkage|List|Location|Measure|MeasureReport|Media|Medication|MedicationAdministration|MedicationDispense|MedicationRequest|MedicationStatement|MessageDefinition|MessageHeader|NamingSystem|NutritionOrder|Observation|OperationDefinition|OperationOutcome|Organization|Parameters|Patient|PaymentNotice|PaymentReconciliation|Person|PlanDefinition|Practitioner|PractitionerRole|Procedure|ProcedureRequest|ProcessRequest|ProcessResponse|Provenance|Questionnaire|QuestionnaireResponse|ReferralRequest|RelatedPerson|RequestGroup|ResearchStudy|ResearchSubject|RiskAssessment|Schedule|SearchParameter|Sequence|ServiceDefinition|Slot|Specimen|StructureDefinition|StructureMap|Subscription|Substance|SupplyDelivery|SupplyRequest|Task|TestScript|TestReport|ValueSet|VisionPrescription)\\/[A-Za-z0-9\\-\\.]{1,64}(\\/_history\\/[A-Za-z0-9\\-\\.]{1,64})?";
  private String serverBase;

  public BundleValidator(IWorkerContext context, String serverBase) {
    super(context);
    this.serverBase = serverBase;
  }

  public void validateBundle(List<ValidationMessage> errors, Element bundle, NodeStack stack, boolean checkSpecials) {
    List<Element> entries = new ArrayList<Element>();
    bundle.getNamedChildren(ENTRY, entries);
    String type = bundle.getNamedChildValue(TYPE);
    type = StringUtils.defaultString(type);

    if (entries.size() == 0) {
      rule(errors, IssueType.INVALID, stack.getLiteralPath(), !(type.equals(DOCUMENT) || type.equals(MESSAGE)), I18nConstants.BUNDLE_BUNDLE_ENTRY_NOFIRST);
    } else {
      // Get the first entry, the MessageHeader
      Element firstEntry = entries.get(0);
      // Get the stack of the first entry
      NodeStack firstStack = stack.push(firstEntry, 1, null, null);

      String fullUrl = firstEntry.getNamedChildValue(FULL_URL);

      if (type.equals(DOCUMENT)) {
        Element resource = firstEntry.getNamedChild(RESOURCE);
        if (rule(errors, IssueType.INVALID, firstEntry.line(), firstEntry.col(), stack.addToLiteralPath(ENTRY, PATH_ARG), resource != null, I18nConstants.BUNDLE_BUNDLE_ENTRY_NOFIRSTRESOURCE)) {
          String id = resource.getNamedChildValue(ID);
          validateDocument(errors, entries, resource, firstStack.push(resource, -1, null, null), fullUrl, id);
        }
        if (!VersionUtilities.isThisOrLater(FHIRVersion._4_0_1.getDisplay(), bundle.getProperty().getStructure().getFhirVersion().getDisplay())) {
          handleSpecialCaseForLastUpdated(bundle, errors, stack);
        }
        checkAllInterlinked(errors, entries, stack, bundle, true);
      }
      if (type.equals(MESSAGE)) {
        Element resource = firstEntry.getNamedChild(RESOURCE);
        String id = resource.getNamedChildValue(ID);
        if (rule(errors, IssueType.INVALID, firstEntry.line(), firstEntry.col(), stack.addToLiteralPath(ENTRY, PATH_ARG), resource != null, I18nConstants.BUNDLE_BUNDLE_ENTRY_NOFIRSTRESOURCE)) {
          validateMessage(errors, entries, resource, firstStack.push(resource, -1, null, null), fullUrl, id);
        }
        checkAllInterlinked(errors, entries, stack, bundle, VersionUtilities.isR5Ver(context.getVersion()));
      }
      // We do not yet have rules requiring that the id and fullUrl match when dealing with messaging Bundles
      //      validateResourceIds(errors, entries, stack);
    }
    for (Element entry : entries) {
      String fullUrl = entry.getNamedChildValue(FULL_URL);
      String url = getCanonicalURLForEntry(entry);
      String id = getIdForEntry(entry);
      if (url != null) {
        if (!(!url.equals(fullUrl) || (url.matches(uriRegexForVersion()) && url.endsWith("/" + id))) && !isV3orV2Url(url))
          rule(errors, IssueType.INVALID, entry.line(), entry.col(), stack.addToLiteralPath(ENTRY, PATH_ARG), false, I18nConstants.BUNDLE_BUNDLE_ENTRY_MISMATCHIDURL, url, fullUrl, id);
        rule(errors, IssueType.INVALID, entry.line(), entry.col(), stack.addToLiteralPath(ENTRY, PATH_ARG), !url.equals(fullUrl) || serverBase == null || (url.equals(Utilities.pathURL(serverBase, entry.getNamedChild(RESOURCE).fhirType(), id))), I18nConstants.BUNDLE_BUNDLE_ENTRY_CANONICAL, url, fullUrl);
      }
      // todo: check specials
    }
  }

  private void validateDocument(List<ValidationMessage> errors, List<Element> entries, Element composition, NodeStack stack, String fullUrl, String id) {
    // first entry must be a composition
    if (rule(errors, IssueType.INVALID, composition.line(), composition.col(), stack.getLiteralPath(), composition.getType().equals("Composition"), I18nConstants.BUNDLE_BUNDLE_ENTRY_DOCUMENT)) {

      // the composition subject etc references must resolve in the bundle
      validateDocumentReference(errors, entries, composition, stack, fullUrl, id, false, "subject", "Composition");
      validateDocumentReference(errors, entries, composition, stack, fullUrl, id, true, "author", "Composition");
      validateDocumentReference(errors, entries, composition, stack, fullUrl, id, false, "encounter", "Composition");
      validateDocumentReference(errors, entries, composition, stack, fullUrl, id, false, "custodian", "Composition");
      validateDocumentSubReference(errors, entries, composition, stack, fullUrl, id, "Composition", "attester", false, "party");
      validateDocumentSubReference(errors, entries, composition, stack, fullUrl, id, "Composition", "event", true, "detail");

      validateSections(errors, entries, composition, stack, fullUrl, id);
    }
  }

  private void validateSections(List<ValidationMessage> errors, List<Element> entries, Element focus, NodeStack stack, String fullUrl, String id) {
    List<Element> sections = new ArrayList<Element>();
    focus.getNamedChildren("section", sections);
    int i = 1;
    for (Element section : sections) {
      NodeStack localStack = stack.push(section, i, null, null);

      // technically R4+, but there won't be matches from before that
      validateDocumentReference(errors, entries, section, stack, fullUrl, id, false, "author", "Section");
      validateDocumentReference(errors, entries, section, stack, fullUrl, id, false, "focus", "Section");

      List<Element> sectionEntries = new ArrayList<Element>();
      section.getNamedChildren(ENTRY, sectionEntries);
      int j = 1;
      for (Element sectionEntry : sectionEntries) {
        NodeStack localStack2 = localStack.push(sectionEntry, j, null, null);
        validateBundleReference(errors, entries, sectionEntry, "Section Entry", localStack2, fullUrl, "Composition", id);
        j++;
      }
      validateSections(errors, entries, section, localStack, fullUrl, id);
      i++;
    }
  }


  public void validateDocumentSubReference(List<ValidationMessage> errors, List<Element> entries, Element composition, NodeStack stack, String fullUrl, String id, String title, String parent, boolean repeats, String propName) {
    List<Element> list = new ArrayList<>();
    composition.getNamedChildren(parent, list);
    int i = 1;
    for (Element elem : list) {
      validateDocumentReference(errors, entries, elem, stack.push(elem, i, null, null), fullUrl, id, repeats, propName, title + "." + parent);
      i++;
    }
  }

  public void validateDocumentReference(List<ValidationMessage> errors, List<Element> entries, Element composition, NodeStack stack, String fullUrl, String id, boolean repeats, String propName, String title) {
    if (repeats) {
      List<Element> list = new ArrayList<>();
      composition.getNamedChildren(propName, list);
      int i = 1;
      for (Element elem : list) {
        
        validateBundleReference(errors, entries, elem, title + "." + propName, stack.push(elem, i, null, null), fullUrl, "Composition", id);
        i++;
      }

    } else {
      Element elem = composition.getNamedChild(propName);
      if (elem != null) {
        validateBundleReference(errors, entries, elem, title + "." + propName, stack.push(elem, -1, null, null), fullUrl, "Composition", id);
      }
    }
  }

  private void validateMessage(List<ValidationMessage> errors, List<Element> entries, Element messageHeader, NodeStack stack, String fullUrl, String id) {
    // first entry must be a messageheader
    if (rule(errors, IssueType.INVALID, messageHeader.line(), messageHeader.col(), stack.getLiteralPath(), messageHeader.getType().equals("MessageHeader"), I18nConstants.VALIDATION_BUNDLE_MESSAGE)) {
      List<Element> elements = messageHeader.getChildren("focus");
      for (Element elem : elements)
        validateBundleReference(errors, entries, elem, "MessageHeader Data", stack.push(elem, -1, null, null), fullUrl, "MessageHeader", id);
    }
  }

  private void validateBundleReference(List<ValidationMessage> errors, List<Element> entries, Element ref, String name, NodeStack stack, String fullUrl, String type, String id) {
    String reference = null;
    try {
      reference = ref.getNamedChildValue("reference");
    } catch (Error e) {

    }

    if (ref != null && !Utilities.noString(reference) && !reference.startsWith("#")) {
      Element target = resolveInBundle(entries, reference, fullUrl, type, id);
      rule(errors, IssueType.INVALID, ref.line(), ref.col(), stack.addToLiteralPath("reference"), target != null, I18nConstants.BUNDLE_BUNDLE_ENTRY_NOTFOUND, reference, name);
    }
  }


  /**
   * As per outline for <a href=http://hl7.org/fhir/stu3/documents.html#content>Document Content</a>:
   * <li>"The document date (mandatory). This is found in Bundle.meta.lastUpdated and identifies when the document bundle
   * was assembled from the underlying resources"</li>
   * <p></p>
   * This check was not being done for release versions < r4.
   * <p></p>
   * Related JIRA ticket is <a href=https://jira.hl7.org/browse/FHIR-26544>FHIR-26544</a>
   *
   * @param bundle {@link org.hl7.fhir.r5.elementmodel}
   * @param errors {@link List<ValidationMessage>}
   * @param stack {@link NodeStack}
   */
  private void handleSpecialCaseForLastUpdated(Element bundle, List<ValidationMessage> errors, NodeStack stack) {
    boolean ok = bundle.hasChild(META)
      && bundle.getNamedChild(META).hasChild(LAST_UPDATED)
      && bundle.getNamedChild(META).getNamedChild(LAST_UPDATED).hasValue();
    rule(errors, IssueType.REQUIRED, stack.getLiteralPath(), ok, I18nConstants.DOCUMENT_DATE_REQUIRED, I18nConstants.DOCUMENT_DATE_REQUIRED_HTML);
  }

  private void checkAllInterlinked(List<ValidationMessage> errors, List<Element> entries, NodeStack stack, Element bundle, boolean isError) {
    List<EntrySummary> entryList = new ArrayList<>();
    for (Element entry : entries) {
      Element r = entry.getNamedChild(RESOURCE);
      if (r != null) {
        entryList.add(new EntrySummary(entry, r));
      }
    }
    for (EntrySummary e : entryList) {
      Set<String> references = findReferences(e.getEntry());
      for (String ref : references) {
        Element tgt = resolveInBundle(entries, ref, e.getEntry().getChildValue(FULL_URL), e.getResource().fhirType(), e.getResource().getIdBase());
        if (tgt != null) {
          EntrySummary t = entryForTarget(entryList, tgt);
          if (t != null) {
            e.getTargets().add(t);
          }
        }
      }
    }

    Set<EntrySummary> visited = new HashSet<>();
    visitLinked(visited, entryList.get(0));
    boolean foundRevLinks;
    do {
      foundRevLinks = false;
      for (EntrySummary e : entryList) {
        if (!visited.contains(e)) {
          boolean add = false;
          for (EntrySummary t : e.getTargets()) {
            if (visited.contains(t)) {
              add = true;
            }
          }
          if (add) {
            foundRevLinks = true;
            visitLinked(visited, e);
          }
        }
      }
    } while (foundRevLinks);

    int i = 0;
    for (EntrySummary e : entryList) {
      Element entry = e.getEntry();
      if (isError) {
        rule(errors, IssueType.INFORMATIONAL, entry.line(), entry.col(), stack.addToLiteralPath(ENTRY + '[' + (i + 1) + ']'), visited.contains(e), I18nConstants.BUNDLE_BUNDLE_ENTRY_ORPHAN, (entry.getChildValue(FULL_URL) != null ? "'" + entry.getChildValue(FULL_URL) + "'" : ""));
      } else {
        warning(errors, IssueType.INFORMATIONAL, entry.line(), entry.col(), stack.addToLiteralPath(ENTRY + '[' + (i + 1) + ']'), visited.contains(e), I18nConstants.BUNDLE_BUNDLE_ENTRY_ORPHAN, (entry.getChildValue(FULL_URL) != null ? "'" + entry.getChildValue(FULL_URL) + "'" : ""));
      }
      i++;
    }
  }



  private String uriRegexForVersion() {
    if (VersionUtilities.isR3Ver(context.getVersion()))
      return URI_REGEX3;
    else
      return Constants.URI_REGEX;
  }

  private String getCanonicalURLForEntry(Element entry) {
    Element e = entry.getNamedChild(RESOURCE);
    if (e == null)
      return null;
    return e.getNamedChildValue("url");
  }

  private String getIdForEntry(Element entry) {
    Element e = entry.getNamedChild(RESOURCE);
    if (e == null)
      return null;
    return e.getNamedChildValue(ID);
  }

  /**
   * Check each resource entry to ensure that the entry's fullURL includes the resource's id
   * value. Adds an ERROR ValidationMessge to errors List for a given entry if it references
   * a resource and fullURL does not include the resource's id.
   *
   * @param errors  List of ValidationMessage objects that new errors will be added to.
   * @param entries List of entry Element objects to be checked.
   * @param stack   Current NodeStack used to create path names in error detail messages.
   */
  private void validateResourceIds(List<ValidationMessage> errors, List<Element> entries, NodeStack stack) {
    // TODO: Need to handle _version
    int i = 1;
    for (Element entry : entries) {
      String fullUrl = entry.getNamedChildValue(FULL_URL);
      Element resource = entry.getNamedChild(RESOURCE);
      String id = resource != null ? resource.getNamedChildValue(ID) : null;
      if (id != null && fullUrl != null) {
        String urlId = null;
        if (fullUrl.startsWith("https://") || fullUrl.startsWith("http://")) {
          urlId = fullUrl.substring(fullUrl.lastIndexOf('/') + 1);
        } else if (fullUrl.startsWith("urn:uuid") || fullUrl.startsWith("urn:oid")) {
          urlId = fullUrl.substring(fullUrl.lastIndexOf(':') + 1);
        }
        rule(errors, IssueType.INVALID, entry.line(), entry.col(), stack.addToLiteralPath("entry[" + i + "]"), urlId.equals(id), I18nConstants.BUNDLE_BUNDLE_ENTRY_IDURLMISMATCH, id, fullUrl);
      }
      i++;
    }
  }

  private EntrySummary entryForTarget(List<EntrySummary> entryList, Element tgt) {
    for (EntrySummary e : entryList) {
      if (e.getEntry() == tgt) {
        return e;
      }
    }
    return null;
  }

  private void visitLinked(Set<EntrySummary> visited, EntrySummary t) {
    if (!visited.contains(t)) {
      visited.add(t);
      for (EntrySummary e : t.getTargets()) {
        visitLinked(visited, e);
      }
    }
  }

  private void followResourceLinks(Element entry, Map<String, Element> visitedResources, Map<Element, Element> candidateEntries, List<Element> candidateResources, List<ValidationMessage> errors, NodeStack stack) {
    followResourceLinks(entry, visitedResources, candidateEntries, candidateResources, errors, stack, 0);
  }

  private void followResourceLinks(Element entry, Map<String, Element> visitedResources, Map<Element, Element> candidateEntries, List<Element> candidateResources, List<ValidationMessage> errors, NodeStack stack, int depth) {
    Element resource = entry.getNamedChild(RESOURCE);
    if (visitedResources.containsValue(resource))
      return;

    visitedResources.put(entry.getNamedChildValue(FULL_URL), resource);

    String type = null;
    Set<String> references = findReferences(resource);
    for (String reference : references) {
      // We don't want errors when just retrieving the element as they will be caught (with better path info) in subsequent processing
      IndexedElement r = getFromBundle(stack.getElement(), reference, entry.getChildValue(FULL_URL), new ArrayList<ValidationMessage>(), stack.addToLiteralPath("entry[" + candidateResources.indexOf(resource) + "]"), type, "transaction".equals(stack.getElement().getChildValue(TYPE)));
      if (r != null && !visitedResources.containsValue(r.getMatch())) {
        followResourceLinks(candidateEntries.get(r.getMatch()), visitedResources, candidateEntries, candidateResources, errors, stack, depth + 1);
      }
    }
  }


  private Set<String> findReferences(Element start) {
    Set<String> references = new HashSet<String>();
    findReferences(start, references);
    return references;
  }

  private void findReferences(Element start, Set<String> references) {
    for (Element child : start.getChildren()) {
      if (child.getType().equals("Reference")) {
        String ref = child.getChildValue("reference");
        if (ref != null && !ref.startsWith("#"))
          references.add(ref);
      }
      if (child.getType().equals("url") || child.getType().equals("uri") || child.getType().equals("canonical")) {
        String ref = child.primitiveValue();
        if (ref != null && !ref.startsWith("#"))
          references.add(ref);
      }
      findReferences(child, references);
    }
  }



  // hack for pre-UTG v2/v3
  private boolean isV3orV2Url(String url) {
    return url.startsWith("http://hl7.org/fhir/v3/") || url.startsWith("http://hl7.org/fhir/v2/");
  }


}
