package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.Base.ValidationMode;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.PercentageTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

public class ObservationValidator extends BaseValidator {


  public ObservationValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateObservation(ValidationContext valContext, List<ValidationMessage> errors, Element element, NodeStack stack, PercentageTracker pct, ValidationMode mode) {
    boolean ok = true;
    // all observations should have a subject, a performer, and a time

    ok = bpCheck(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), element.getNamedChild("subject", false) != null, I18nConstants.ALL_OBSERVATIONS_SHOULD_HAVE_A_SUBJECT) && ok;
    List<Element> performers = new ArrayList<>();
    element.getNamedChildren("performer", performers);
    ok = bpCheck(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), performers.size() > 0, I18nConstants.ALL_OBSERVATIONS_SHOULD_HAVE_A_PERFORMER) && ok;
    ok = bpCheck(errors, IssueType.INVALID, element.line(), element.col(), stack.getLiteralPath(), 
          element.getNamedChild("effectiveDateTime", false) != null || element.getNamedChild("effectivePeriod", false) != null || 
          element.getNamedChild("effectiveTiming", false) != null || element.getNamedChild("effectiveInstant", false) != null, 
          I18nConstants.ALL_OBSERVATIONS_SHOULD_HAVE_AN_EFFECTIVEDATETIME_OR_AN_EFFECTIVEPERIOD, element.getProperty().typeSummary()) && ok;   
    
    // hook in the vital signs 
    if (VersionUtilities.isR4Plus(context.getVersion())) {
      Element code = element.getNamedChild("code", false);
      List<String> codes = new ArrayList<>();
      if (hasLoincCode(code, codes, "85353-1")) {
        ok = checkObservationAgainstProfile(valContext, errors, element, stack, "http://hl7.org/fhir/StructureDefinition/vitalspanel", "Vital Signs Panel", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "9279-1", "76170-0", "76172-6", "76171-8", "19840-8", "33438-3", "76270-8", "11291-2")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/resprate", "Respiratory Rate", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "60978-4", "73795-7", "73799-9", "76476-1", "76477-9", "8867-4", "8889-8", "8890-6", "8891-4", "8892-2", "8893-0", "40443-4", "55425-3", "68999-2", "11328-2", "69000-8", "69000-8", "60978-4", "60978-4", "8890-6", "8886-4", "68999-2", "68999-2")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/heartrate", "Heart rate", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "2708-6", "19224-5", "20564-1", "2709-4", "2710-2", "2711-0", "2713-6", "51733-4", "59408-5", "59417-6", "89276-0", "97549-0")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/oxygensat", "Oxygen saturation", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "8310-5", "60834-9", "60835-6", "60836-4", "60838-0", "60955-2", "61009-7", "75539-7", "75987-8", "76010-8", "76011-6", "76278-1", "8309-7", "8310-5", "8328-7", "8329-5", "8330-3", "8331-1", "8332-9", "8333-7", "8334-5", "91371-5", "98657-0", "98663-8")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bodytemp", "Body temperature", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "8302-2", "3137-7", "3138-5", "8302-2", "8306-3", "8308-9")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bodyheight", "Body height", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "9843-4", "8287-5", "9843-4")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/headcircum", "Head circumference", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "29463-7", "29463-7", "3141-9", "3142-7", "75292-3", "79348-9", "8350-1", "8351-9")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bodyweight", "Body weight", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "39156-5", "39156-5", "59574-4", "89270-3")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bmi", "Body mass index", "LOINC", codes, pct, mode) && ok;
      } else if (hasLoincCode(code, codes, "85354-9", "35094-2", "8459-0", "85354-9", "76534-7", "55284-4", "8480-6")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bp", "Blood pressure systolic and diastolic", "LOINC", codes, pct, mode) && ok;
      
      } else if (hasSctCode(code, codes, "46680005")) {
        ok = checkObservationAgainstProfile(valContext, errors, element, stack, "http://hl7.org/fhir/StructureDefinition/vitalspanel", "Vital Signs Panel", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "86290005", "271625008", "271306003")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "Blood pressure systolic and diastolic", "Respiratory Rate", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "271306003", "249043002", "444981005", "399017001", "251670001", "429525003", "429614003")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/heartrate", "Heart rate", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "103228002", "103228002", "442349007", "442476006", "442440005", "431314004", "442734002", "713194001")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/oxygensat", "Oxygen saturation", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "386725007", "276885007", "300076005", "1222808002", "364246006", "307047009", "708499008", "708499008", "431598003", "698831002", "698832009", "415882003", "415974002", "415929009", "415945006")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bodytemp", "Body temperature", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "1153637007", "1162419008", "50373000", "1162418000", "1230278008", "1162392001", "1162417005")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bodyheight", "Body height", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "363812007", "169876006", "1269262007", "363811000")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/headcircum", "Head circumference", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "363811000", "60621009", "735395000", "425024002", "424927000", "784399000", "1162416001", "1162415002")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bodyweight", "Body weight", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "60621009")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bmi", "Body mass index", "SNOMED CT", codes, pct, mode) && ok;
      } else if (hasSctCode(code, codes, "75367002", "251076008", "163033001", "163035008", "386534000", "386536003", "271649006", "271649006", "271650006", "407556006", "407554009", "716579001", "399304008")) {
        ok = checkObservationAgainstProfile(valContext,errors, element, stack, "http://hl7.org/fhir/StructureDefinition/bp", "Blood pressure systolic and diastolic", "SNOMED CT", codes, pct, mode) && ok;
      }  
    }
    return ok;
  }

  private boolean checkObservationAgainstProfile(ValidationContext valContext, List<ValidationMessage> errors, Element element, NodeStack stack, String url, String name, String sys, List<String> loinc, PercentageTracker pct, ValidationMode mode) {
    element.addMessage(signpost(errors, NO_RULE_DATE, IssueType.INFORMATIONAL, element.line(), element.col(), stack.getLiteralPath(), I18nConstants.VALIDATION_VAL_PROFILE_SIGNPOST_OBS, url, name, sys, loinc.get(0)));
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, url);
    if (sd == null) {
      return false;
    } else {
      return ((InstanceValidator) parent).startInner(valContext, errors, element, element, sd, stack, false, pct, mode);
    }
  }

  private boolean hasLoincCode(Element code, List<String> codes, String... values) {
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

  private boolean hasSctCode(Element code, List<String> codes, String... values) {
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

  

}
