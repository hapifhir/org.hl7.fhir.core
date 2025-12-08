package org.hl7.fhir.validation.instance.advisor;

import java.util.*;

import lombok.Getter;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor.ReferenceDestinationType;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;

public class BasePolicyAdvisorForFullValidation implements IValidationPolicyAdvisor {
  
  private ReferenceValidationPolicy refpol = ReferenceValidationPolicy.CHECK_VALID;
  @Getter private Set<String> checkReferencesTo = new HashSet<>();

  public IValidationPolicyAdvisor getPolicyAdvisor() {
    return null;
  }

  public IValidationPolicyAdvisor setPolicyAdvisor(IValidationPolicyAdvisor policyAdvisor) {
    throw new Error("This policy advisor is the end of the chain");
  }
  
  public BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy refpol, Set<String> referencesTo) {
    super();
    this.refpol = refpol;
    if (referencesTo != null) {
      this.checkReferencesTo.addAll(referencesTo);
    }
  }

  public ReferenceValidationPolicy getRefpol() {
    return refpol;
  }

  public void setRefpol(ReferenceValidationPolicy refpol) {
    this.refpol = refpol;
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url,
      ReferenceDestinationType destinationType) {
    boolean inList = false;
    String urls = url.replace("https://", "http://");
    for (String u : checkReferencesTo) {
      if (urls.startsWith(u)) {
        inList = true;
        break;
      }
    }
    return inList ? ReferenceValidationPolicy.CHECK_VALID : refpol;
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String containerType, String containerId,
      SpecialElement containingResourceType, String path, String url) {

    return ContainedReferenceValidationPolicy.CHECK_VALID;
  }
  
  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
      StructureDefinition type, String path) {
    return EnumSet.allOf(ResourceValidationAction.class);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
      StructureDefinition structure, ElementDefinition element, String path) {
    return EnumSet.allOf(ElementValidationAction.class);
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator,
      Object appContext,
      String stackPath,
      ElementDefinition definition,
      StructureDefinition structure,
      BindingKind kind,
      AdditionalBindingPurpose purpose,
      ValueSet valueSet,
      List<String> systems) {
    return EnumSet.allOf(CodedContentValidationAction.class);
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator, Object appContext,
      String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid,
      IMessagingServices msgServices, List<ValidationMessage> messages) {
    List<StructureDefinition> profiles = new ArrayList<StructureDefinition>();
    if ("Observation".equals(resource.fhirType()) && VersionUtilities.isR4Plus(validator.getContext().getVersion())) {
      getImpliedProfilesForObservation(profiles, msgServices, messages, validator.getContext(), stackPath, resource);
    }
    return profiles;
  }
    

  private void getImpliedProfilesForObservation(List<StructureDefinition> profiles, IMessagingServices msgServices, List<ValidationMessage> messages, IWorkerContext context, String stackPath, Element resource) {
    Element code = resource.getNamedChild("code", false);
    List<String> codes = new ArrayList<>();
    if (hasLoincCode(code, codes, "85353-1")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/vitalspanel", "Vital Signs Panel", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "9279-1", "76170-0", "76172-6", "76171-8", "19840-8", "33438-3", "76270-8", "11291-2")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/resprate", "Respiratory Rate", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "60978-4", "73795-7", "73799-9", "76476-1", "76477-9", "8867-4", "8889-8", "8890-6", "8891-4", "8892-2", "8893-0", "40443-4", "55425-3", "68999-2", "11328-2", "69000-8", "69000-8", "60978-4", "60978-4", "8890-6", "8886-4", "68999-2", "68999-2")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/heartrate", "Heart rate", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "2708-6", "19224-5", "20564-1", "2709-4", "2710-2", "2713-6", "51733-4", "59408-5", "59417-6", "89276-0", "97549-0")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/oxygensat", "Oxygen saturation", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "8310-5", "60834-9", "60835-6", "60836-4", "60838-0", "60955-2", "61009-7", "75539-7", "75987-8", "76010-8", "76011-6", "76278-1", "8309-7", "8310-5", "8328-7", "8329-5", "8330-3", "8331-1", "8332-9", "8333-7", "8334-5", "91371-5", "98657-0", "98663-8")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bodytemp", "Body temperature", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "8302-2", "3137-7", "3138-5", "8302-2", "8306-3", "8308-9")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bodyheight", "Body height", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "9843-4", "8287-5", "9843-4")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/headcircum", "Head circumference", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "29463-7", "29463-7", "3141-9", "3142-7", "75292-3", "79348-9", "8350-1", "8351-9")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bodyweight", "Body weight", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "39156-5", "39156-5", "89270-3")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bmi", "Body mass index", "LOINC", codes);
    } else if (hasLoincCode(code, codes, "85354-9", "35094-2", "8459-0", "85354-9", "76534-7", "55284-4", "8480-6")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bp", "Blood pressure systolic and diastolic", "LOINC", codes);
    
    } else if (hasSctCode(code, codes, "46680005")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/vitalspanel", "Vital Signs Panel", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "86290005", "271625008", "271306003")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/resprate", "Respiratory Rate", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "271306003", "249043002", "444981005", "399017001", "251670001", "429525003", "429614003")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/heartrate", "Heart rate", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "442476006", "431314004")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/oxygensat", "Oxygen saturation", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "386725007", "276885007", "300076005", "1222808002", "364246006", "307047009", "708499008", "431598003", "698831002", "698832009", "415882003", "415974002", "415929009", "415945006")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bodytemp", "Body temperature", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "1153637007", "1162419008", "50373000", "1162418000", "1230278008", "1162392001", "1162417005")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bodyheight", "Body height", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "363812007", "169876006", "1269262007", "363811000")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/headcircum", "Head circumference", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "735395000", "425024002", "424927000", "784399000", "1162416001", "1162415002")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bodyweight", "Body weight", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "60621009")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bmi", "Body mass index", "SNOMED CT", codes);
    } else if (hasSctCode(code, codes, "251076008", "163033001", "163035008", "386534000", "386536003", "271649006", "271650006", "407556006", "407554009", "716579001", "399304008")) {
      addProfile(profiles, msgServices, messages, context, stackPath, resource, "http://hl7.org/fhir/StructureDefinition/bp", "Blood pressure systolic and diastolic", "SNOMED CT", codes);
    }  
    
  }

  private void addProfile(List<StructureDefinition> profiles, IMessagingServices msgServices, List<ValidationMessage> messages, IWorkerContext context, String stackPath, Element resource, String url, String name, String systemName, List<String> codes) {
    resource.addMessage(msgServices.signpost(messages, null, IssueType.INFORMATIONAL, resource.line(), resource.col(), stackPath, I18nConstants.VALIDATION_VAL_PROFILE_SIGNPOST_OBS, url, name, systemName, codes.get(0)));
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, url);
    if (sd != null) {
      profiles.add(sd);
    } else {
      // complain?
    }
  }

  protected boolean hasLoincCode(Element code, List<String> codes, String... values) {
    if (code != null) {
      List<Element> codings = code.getChildren("coding");
      for (Element coding : codings) {
        if ("http://loinc.org".equals(coding.getNamedChildValue("system", false)) && Utilities.existsInList(coding.getNamedChildValue("code", false), values)) {
          codes.add(coding.getNamedChildValue("code", false));
          return true;
        }
      }
    }
    return false;
  }

  protected boolean hasSctCode(Element code, List<String> codes, String... values) {
    if (code != null) {
      List<Element> codings = code.getChildren("coding");
      for (Element coding : codings) {
        if ("http://snomed.info/sct".equals(coding.getNamedChildValue("system", false)) && Utilities.existsInList(coding.getNamedChildValue("code", false), values)) {
          codes.add(coding.getNamedChildValue("code", false));
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public boolean isSuppressMessageId(String path, String messageId) {
    return false;
  }

  @Override
  public ReferenceValidationPolicy getReferencePolicy() {
    return refpol;
  }

  @Override
  public SpecialValidationAction policyForSpecialValidation(IResourceValidator validator, Object appContext, SpecialValidationRule rule, String stackPath, Element resource, Element element) {
    return SpecialValidationAction.CHECK_RULE;
  }

  
}
