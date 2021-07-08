package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class Timing30_40 {
    public static org.hl7.fhir.r4.model.Timing convertTiming(org.hl7.fhir.dstu3.model.Timing src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Timing tgt = new org.hl7.fhir.r4.model.Timing();
      Element30_40.copyElement(src, tgt);
      for (org.hl7.fhir.dstu3.model.DateTimeType t : src.getEvent())
        tgt.addEventElement().setValueAsString(t.getValueAsString());
      if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
      if (src.hasCode()) tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Timing convertTiming(org.hl7.fhir.r4.model.Timing src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Timing tgt = new org.hl7.fhir.dstu3.model.Timing();
      Element30_40.copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent())
        tgt.addEventElement().setValueAsString(t.getValueAsString());
      if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
      if (src.hasCode()) tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
      return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4.model.Timing.TimingRepeatComponent();
      Element30_40.copyElement(src, tgt);
      if (src.hasBounds()) tgt.setBounds(Type30_40.convertType(src.getBounds()));
      if (src.hasCount()) tgt.setCount(src.getCount());
      if (src.hasCountMax()) tgt.setCountMax(src.getCountMax());
      if (src.hasDuration()) tgt.setDurationElement(Decimal30_40.convertDecimal(src.getDurationElement()));
      if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal30_40.convertDecimal(src.getDurationMaxElement()));
      if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
      if (src.hasFrequency()) tgt.setFrequency(src.getFrequency());
      if (src.hasFrequencyMax()) tgt.setFrequencyMax(src.getFrequencyMax());
      if (src.hasPeriod()) tgt.setPeriodElement(Decimal30_40.convertDecimal(src.getPeriodElement()));
      if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal30_40.convertDecimal(src.getPeriodMaxElement()));
      if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
      tgt.setDayOfWeek(src.getDayOfWeek().stream().map(Timing30_40::convertDayOfWeek).collect(Collectors.toList()));
      for (org.hl7.fhir.dstu3.model.TimeType t : src.getTimeOfDay()) tgt.addTimeOfDay(t.getValue());
      if (src.hasWhen()) tgt.setWhen(src.getWhen().stream().map(Timing30_40::convertEventTiming).collect(Collectors.toList()));
      if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt30_40.convertUnsignedInt(src.getOffsetElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4.model.Timing.TimingRepeatComponent src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent();
      Element30_40.copyElement(src, tgt);
      if (src.hasBounds()) tgt.setBounds(Type30_40.convertType(src.getBounds()));
      if (src.hasCount()) tgt.setCount(src.getCount());
      if (src.hasCountMax()) tgt.setCountMax(src.getCountMax());
      if (src.hasDuration()) tgt.setDurationElement(Decimal30_40.convertDecimal(src.getDurationElement()));
      if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal30_40.convertDecimal(src.getDurationMaxElement()));
      if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
      if (src.hasFrequency()) tgt.setFrequency(src.getFrequency());
      if (src.hasFrequencyMax()) tgt.setFrequencyMax(src.getFrequencyMax());
      if (src.hasPeriod()) tgt.setPeriodElement(Decimal30_40.convertDecimal(src.getPeriodElement()));
      if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal30_40.convertDecimal(src.getPeriodMaxElement()));
      if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
      tgt.setDayOfWeek(src.getDayOfWeek().stream().map(Timing30_40::convertDayOfWeek).collect(Collectors.toList()));
      for (org.hl7.fhir.r4.model.TimeType t : src.getTimeOfDay()) tgt.addTimeOfDay(t.getValue());
      if (src.hasWhen()) tgt.setWhen(src.getWhen().stream().map(Timing30_40::convertEventTiming).collect(Collectors.toList()));
      if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt30_40.convertUnsignedInt(src.getOffsetElement()));
      return tgt;
    }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.EventTimingEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NULL);
    } else {
      switch (src.getValue()) {
        case MORN:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN);
          break;
        case AFT:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT);
          break;
        case EVE:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE);
          break;
        case NIGHT:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NIGHT);
          break;
        case PHS:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PHS);
          break;
        case HS:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.HS);
          break;
        case WAKE:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.WAKE);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.C);
          break;
        case CM:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CM);
          break;
        case CD:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CD);
          break;
        case CV:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CV);
          break;
        case AC:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AC);
          break;
        case ACM:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACM);
          break;
        case ACD:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACD);
          break;
        case ACV:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACV);
          break;
        case PC:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PC);
          break;
        case PCM:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCM);
          break;
        case PCD:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCD);
          break;
        case PCV:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCV);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.EventTimingEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.NULL);
    } else {
      switch (src.getValue()) {
        case MORN:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.MORN);
          break;
        case AFT:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.AFT);
          break;
        case EVE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.EVE);
          break;
        case NIGHT:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.NIGHT);
          break;
        case PHS:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PHS);
          break;
        case HS:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.HS);
          break;
        case WAKE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.WAKE);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.C);
          break;
        case CM:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CM);
          break;
        case CD:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CD);
          break;
        case CV:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CV);
          break;
        case AC:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.AC);
          break;
        case ACM:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACM);
          break;
        case ACD:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACD);
          break;
        case ACV:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACV);
          break;
        case PC:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PC);
          break;
        case PCM:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCM);
          break;
        case PCD:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCD);
          break;
        case PCV:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCV);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UsageContext convertUsageContext(org.hl7.fhir.dstu3.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.UsageContext tgt = new org.hl7.fhir.r4.model.UsageContext();
    Element30_40.copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding30_40.convertCoding(src.getCode()));
    if (src.hasValue()) tgt.setValue(Type30_40.convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UsageContext convertUsageContext(org.hl7.fhir.r4.model.UsageContext src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.UsageContext tgt = new org.hl7.fhir.dstu3.model.UsageContext();
    Element30_40.copyElement(src, tgt);
    if (src.hasCode()) tgt.setCode(Coding30_40.convertCoding(src.getCode()));
    if (src.hasValue()) tgt.setValue(Type30_40.convertType(src.getValue()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.DayOfWeek> convertDayOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.DayOfWeek> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.DayOfWeekEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.NULL);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.DayOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.UnitsOfTimeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL);
    } else {
      switch (src.getValue()) {
        case S:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.S);
          break;
        case MIN:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.MIN);
          break;
        case H:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.H);
          break;
        case D:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.D);
          break;
        case WK:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.WK);
          break;
        case MO:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.MO);
          break;
        case A:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.A);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.UnitsOfTimeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.NULL);
    } else {
      switch (src.getValue()) {
        case S:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.S);
          break;
        case MIN:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MIN);
          break;
        case H:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.H);
          break;
        case D:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.D);
          break;
        case WK:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.WK);
          break;
        case MO:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MO);
          break;
        case A:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.A);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> convertDayOfWeek(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.DayOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.DayOfWeekEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.NULL);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }
}
