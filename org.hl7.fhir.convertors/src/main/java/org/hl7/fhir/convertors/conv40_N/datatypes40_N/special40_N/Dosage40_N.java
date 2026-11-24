package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.BackboneElement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Ratio40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Timing40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class Dosage40_N {
  public static org.hl7.fhir.model.core.Dosage convertDosage(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Dosage tgt = new org.hl7.fhir.model.core.Dosage();
    BackboneElement40_N.copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Dosage", "5.0", new String[] {"asNeededFor", "asNeeded"},
      CrossVersionElements40_N.urls("Dosage", "6.0", new String[] {"condition", "safety"})));
    // R6 dropped sequence
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Dosage", tgt.getExtension(), "sequence");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "condition");
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String40_N.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing40_N.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean40_N.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasAsNeededCodeableConcept()) {
      tgt.addAsNeededFor(CodeableConcept40_N.convertCodeableConcept(src.getAsNeededCodeableConcept()));      
    }
    // the other reasons (R4 has only one)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "asNeededFor");
    // R6 had both asNeeded and reasons (see below)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "asNeeded");
    if (src.hasSite()) tgt.setSite(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    // R6 safety.doseLimit has the R4 maximum doses as scopes (or the whole R6 safety is in the extension)
    if (src.hasMaxDosePerPeriod()) {
      org.hl7.fhir.model.core.DosageSafety.DosageSafetyDoseLimitComponent l = tgt.getSafety().addDoseLimit();
      l.setScope(org.hl7.fhir.model.core.DosageSafety.DoseLimitScopeVS.PERIOD);
      if (src.getMaxDosePerPeriod().hasNumerator())
        l.setValue(Quantity40_N.convertQuantity(src.getMaxDosePerPeriod().getNumerator()));
      if (src.getMaxDosePerPeriod().hasDenominator()) {
        org.hl7.fhir.model.core.Duration d = new org.hl7.fhir.model.core.Duration();
        Quantity40_N.copyQuantity(src.getMaxDosePerPeriod().getDenominator(), d);
        l.setPeriod(d);
      }
    }
    if (src.hasMaxDosePerAdministration())
      tgt.getSafety().addDoseLimit().setScope(org.hl7.fhir.model.core.DosageSafety.DoseLimitScopeVS.ADMINISTRATION).setValue(SimpleQuantity40_N.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.getSafety().addDoseLimit().setScope(org.hl7.fhir.model.core.DosageSafety.DoseLimitScopeVS.LIFETIME).setValue(SimpleQuantity40_N.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "safety");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage convertDosage(org.hl7.fhir.model.core.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
    BackboneElement40_N.copyBackboneElement(src, tgt, CrossVersionElements40_N.url("Dosage", "4.0", "sequence"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Dosage", "sequence");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "condition");
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAdditionalInstructionList())
      tgt.addAdditionalInstruction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String40_N.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing40_N.convertTiming(src.getTiming()));
    // R4 asNeeded[x] is a boolean or a single reason (which means as needed is true): the first reason, and the rest in
    // the extension
    if (src.hasAsNeededFor()) {
      tgt.setAsNeeded(CodeableConcept40_N.convertCodeableConcept(src.getAsNeededForFirstRep()));
      for (org.hl7.fhir.model.core.CodeableConcept t : src.getAsNeededForList().subList(1, src.getAsNeededForList().size()))
        tgt.addExtension(CrossVersionElements40_N.url("Dosage", "5.0", "asNeededFor"), CodeableConcept40_N.convertCodeableConcept(t));
      // R4 has nowhere for asNeeded as well as a reason
      if (src.hasAsNeeded())
        tgt.addExtension(CrossVersionElements40_N.url("Dosage", "5.0", "asNeeded"), Boolean40_N.convertBoolean(src.getAsNeededElement()));
    } else if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean40_N.convertBoolean(src.getAsNeededElement()));
    if (src.hasSite()) tgt.setSite(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRateList())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasSafety()) {
      if (isR4MaxDoses(src.getSafety())) {
        for (org.hl7.fhir.model.core.DosageSafety.DosageSafetyDoseLimitComponent l : src.getSafety().getDoseLimitList()) {
          switch (l.getScope()) {
          case PERIOD:
            org.hl7.fhir.r4.model.Ratio r = new org.hl7.fhir.r4.model.Ratio();
            if (l.hasValue())
              r.setNumerator(Quantity40_N.convertQuantity(l.getValueQuantity()));
            if (l.hasPeriod()) {
              org.hl7.fhir.r4.model.Quantity q = new org.hl7.fhir.r4.model.Quantity();
              Quantity40_N.copyQuantity(l.getPeriod(), q);
              r.setDenominator(q);
            }
            tgt.setMaxDosePerPeriod(r);
            break;
          case ADMINISTRATION:
            tgt.setMaxDosePerAdministration(SimpleQuantity40_N.convertSimpleQuantity(l.getValueQuantity()));
            break;
          case LIFETIME:
            tgt.setMaxDosePerLifetime(SimpleQuantity40_N.convertSimpleQuantity(l.getValueQuantity()));
            break;
          default:
            break;
          }
        }
      } else {
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "safety");
      }
    }
    return tgt;
  }

  /**
   * true if R6 safety is no more than the R4 maximum doses: at most one dose limit each for period, administration and
   * lifetime, each a quantity (and for period, a period), and nothing else
   */
  private static boolean isR4MaxDoses(org.hl7.fhir.model.core.DosageSafety safety) {
    if (safety.hasIfExceeded() || safety.hasId() || safety.hasExtension())
      return false;
    java.util.Set<org.hl7.fhir.model.core.DosageSafety.DoseLimitScopeVS> seen = new java.util.HashSet<>();
    for (org.hl7.fhir.model.core.DosageSafety.DosageSafetyDoseLimitComponent l : safety.getDoseLimitList()) {
      if (!l.hasScope() || !seen.add(l.getScope()) || l.hasText() || l.hasId() || l.hasExtension())
        return false;
      if (l.hasValue() && !l.hasValueQuantity())
        return false;
      switch (l.getScope()) {
      case PERIOD:
        break;
      case ADMINISTRATION:
      case LIFETIME:
        if (l.hasPeriod() || !l.hasValue())
          return false;
        break;
      default:
        return false;
      }
    }
    return true;
  }

  public static org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "dose", tgt, tgt.getExtension());
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "rate", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "dose", tgt, tgt.getExtension());
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "rate", tgt, tgt.getExtension());
    return tgt;
  }
}
