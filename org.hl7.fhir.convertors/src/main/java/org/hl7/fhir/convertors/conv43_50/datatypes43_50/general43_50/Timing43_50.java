package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneType43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Time43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.UnsignedInt43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Timing43_50 {
  public static org.hl7.fhir.r4b.model.Timing convertTiming(org.hl7.fhir.r5.model.Timing src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Timing tgt = new org.hl7.fhir.r4b.model.Timing();
    BackboneType43_50.copyBackboneType(src, tgt);
    for (org.hl7.fhir.r5.model.DateTimeType t : src.getEvent()) tgt.getEvent().add(DateTime43_50.convertDateTime(t));
    if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode()) tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Timing convertTiming(org.hl7.fhir.r4b.model.Timing src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Timing tgt = new org.hl7.fhir.r5.model.Timing();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.DateTimeType t : src.getEvent()) tgt.getEvent().add(DateTime43_50.convertDateTime(t));
    if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode()) tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4b.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r5.model.Timing.TimingRepeatComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getBounds()));
    if (src.hasCount()) tgt.setCountElement(PositiveInt43_50.convertPositiveInt(src.getCountElement()));
    if (src.hasCountMax()) tgt.setCountMaxElement(PositiveInt43_50.convertPositiveInt(src.getCountMaxElement()));
    if (src.hasDuration()) tgt.setDurationElement(Decimal43_50.convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal43_50.convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequency()) tgt.setFrequencyElement(PositiveInt43_50.convertPositiveInt(src.getFrequencyElement()));
    if (src.hasFrequencyMax())
      tgt.setFrequencyMaxElement(PositiveInt43_50.convertPositiveInt(src.getFrequencyMaxElement()));
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal43_50.convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal43_50.convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    tgt.setDayOfWeek(src.getDayOfWeek().stream().map(Timing43_50::convertDayOfWeek).collect(Collectors.toList()));
    if (src.hasWhen())
      tgt.setWhen(src.getWhen().stream().map(Timing43_50::convertEventTiming).collect(Collectors.toList()));
    for (org.hl7.fhir.r4b.model.TimeType t : src.getTimeOfDay()) tgt.getTimeOfDay().add(Time43_50.convertTime(t));
    if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt43_50.convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4b.model.Timing.TimingRepeatComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getBounds()));
    if (src.hasCount()) tgt.setCountElement(PositiveInt43_50.convertPositiveInt(src.getCountElement()));
    if (src.hasCountMax()) tgt.setCountMaxElement(PositiveInt43_50.convertPositiveInt(src.getCountMaxElement()));
    if (src.hasDuration()) tgt.setDurationElement(Decimal43_50.convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal43_50.convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequency()) tgt.setFrequencyElement(PositiveInt43_50.convertPositiveInt(src.getFrequencyElement()));
    if (src.hasFrequencyMax())
      tgt.setFrequencyMaxElement(PositiveInt43_50.convertPositiveInt(src.getFrequencyMaxElement()));
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal43_50.convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal43_50.convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    tgt.setDayOfWeek(src.getDayOfWeek().stream().map(Timing43_50::convertDayOfWeek).collect(Collectors.toList()));
    if (src.hasWhen())
      tgt.setWhen(src.getWhen().stream().map(Timing43_50::convertEventTiming).collect(Collectors.toList()));
    for (org.hl7.fhir.r5.model.TimeType t : src.getTimeOfDay()) tgt.getTimeOfDay().add(Time43_50.convertTime(t));
    if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt43_50.convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.UnitsOfTimeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.NULL);
    } else {
      switch (src.getValue()) {
        case S:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.S);
          break;
        case MIN:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.MIN);
          break;
        case H:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.H);
          break;
        case D:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.D);
          break;
        case WK:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.WK);
          break;
        case MO:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.MO);
          break;
        case A:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.A);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Timing.UnitsOfTimeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.NULL);
    } else {
      switch (src.getValue()) {
        case S:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.S);
          break;
        case MIN:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.MIN);
          break;
        case H:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.H);
          break;
        case D:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.D);
          break;
        case WK:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.WK);
          break;
        case MO:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.MO);
          break;
        case A:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.A);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.UnitsOfTime.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDayOfWeek(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> convertDayOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.NULL);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DaysOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.EventTimingEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NULL);
    } else {
      switch (src.getValue()) {
        case MORN:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN);
          break;
        case MORN_EARLY:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN_EARLY);
          break;
        case MORN_LATE:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN_LATE);
          break;
        case NOON:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NOON);
          break;
        case AFT:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT);
          break;
        case AFT_EARLY:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT_EARLY);
          break;
        case AFT_LATE:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT_LATE);
          break;
        case EVE:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE);
          break;
        case EVE_EARLY:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE_EARLY);
          break;
        case EVE_LATE:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE_LATE);
          break;
        case NIGHT:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NIGHT);
          break;
        case PHS:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PHS);
          break;
        case HS:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.HS);
          break;
        case WAKE:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.WAKE);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.C);
          break;
        case CM:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CM);
          break;
        case CD:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CD);
          break;
        case CV:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CV);
          break;
        case AC:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AC);
          break;
        case ACM:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACM);
          break;
        case ACD:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACD);
          break;
        case ACV:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACV);
          break;
        case PC:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PC);
          break;
        case PCM:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCM);
          break;
        case PCD:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCD);
          break;
        case PCV:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCV);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Timing.EventTiming> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Timing.EventTimingEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.NULL);
    } else {
      switch (src.getValue()) {
        case MORN:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.MORN);
          break;
        case MORN_EARLY:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.MORN_EARLY);
          break;
        case MORN_LATE:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.MORN_LATE);
          break;
        case NOON:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.NOON);
          break;
        case AFT:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.AFT);
          break;
        case AFT_EARLY:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.AFT_EARLY);
          break;
        case AFT_LATE:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.AFT_LATE);
          break;
        case EVE:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.EVE);
          break;
        case EVE_EARLY:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.EVE_EARLY);
          break;
        case EVE_LATE:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.EVE_LATE);
          break;
        case NIGHT:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.NIGHT);
          break;
        case PHS:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.PHS);
          break;
        case HS:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.HS);
          break;
        case WAKE:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.WAKE);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.C);
          break;
        case CM:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.CM);
          break;
        case CD:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.CD);
          break;
        case CV:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.CV);
          break;
        case AC:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.AC);
          break;
        case ACM:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.ACM);
          break;
        case ACD:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.ACD);
          break;
        case ACV:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.ACV);
          break;
        case PC:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.PC);
          break;
        case PCM:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.PCM);
          break;
        case PCD:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.PCD);
          break;
        case PCV:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.PCV);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Timing.EventTiming.NULL);
          break;
      }
    }
    return tgt;
  }
}
