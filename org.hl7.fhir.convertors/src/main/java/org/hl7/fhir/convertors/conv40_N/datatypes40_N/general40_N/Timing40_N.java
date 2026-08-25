package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.BackboneElement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Time40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.Timing;

public class Timing40_N {
  public static org.hl7.fhir.r4.model.Timing convertTiming(org.hl7.fhir.model.core.Timing src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Timing tgt = new org.hl7.fhir.r4.model.Timing();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.DateTimeType t : src.getEventList()) tgt.getEvent().add(DateTime40_N.convertDateTime(t));
    if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode()) tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Timing convertTiming(org.hl7.fhir.r4.model.Timing src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Timing tgt = new org.hl7.fhir.model.core.Timing();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent()) tgt.getEventList().add(DateTime40_N.convertDateTime(t));
    if (src.hasRepeat()) tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode()) tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.model.core.Timing.TimingRepeatComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getBounds()));
    if (src.hasCount()) tgt.setCountElement(PositiveInt40_N.convertPositiveInt(src.getCountElement()));
    if (src.hasCountMax()) tgt.setCountMaxElement(PositiveInt40_N.convertPositiveInt(src.getCountMaxElement()));
    if (src.hasDuration()) tgt.setDurationElement(Decimal40_N.convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal40_N.convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequency()) tgt.setFrequencyElement(PositiveInt40_N.convertPositiveInt(src.getFrequencyElement()));
    if (src.hasFrequencyMax())
      tgt.setFrequencyMaxElement(PositiveInt40_N.convertPositiveInt(src.getFrequencyMaxElement()));
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal40_N.convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal40_N.convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    tgt.setDayOfWeekList(src.getDayOfWeek().stream().map(Timing40_N::convertDayOfWeek).collect(Collectors.toList()));
    if (src.hasWhen())
      tgt.setWhenList(src.getWhen().stream().map(Timing40_N::convertEventTiming).collect(Collectors.toList()));
    for (org.hl7.fhir.r4.model.TimeType t : src.getTimeOfDay()) tgt.getTimeOfDayList().add(Time40_N.convertTime(t));
    if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt40_N.convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.model.core.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4.model.Timing.TimingRepeatComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getBounds()));
    if (src.hasCount()) tgt.setCountElement(PositiveInt40_N.convertPositiveInt(src.getCountElement()));
    if (src.hasCountMax()) tgt.setCountMaxElement(PositiveInt40_N.convertPositiveInt(src.getCountMaxElement()));
    if (src.hasDuration()) tgt.setDurationElement(Decimal40_N.convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax()) tgt.setDurationMaxElement(Decimal40_N.convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit()) tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequency()) tgt.setFrequencyElement(PositiveInt40_N.convertPositiveInt(src.getFrequencyElement()));
    if (src.hasFrequencyMax())
      tgt.setFrequencyMaxElement(PositiveInt40_N.convertPositiveInt(src.getFrequencyMaxElement()));
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal40_N.convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax()) tgt.setPeriodMaxElement(Decimal40_N.convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit()) tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    tgt.setDayOfWeek(src.getDayOfWeekList().stream().map(Timing40_N::convertDayOfWeek).collect(Collectors.toList()));
    if (src.hasWhen())
      tgt.setWhen(src.getWhenList().stream().map(Timing40_N::convertEventTiming).collect(Collectors.toList()));
    for (org.hl7.fhir.model.core.TimeType t : src.getTimeOfDayList()) tgt.getTimeOfDay().add(Time40_N.convertTime(t));
    if (src.hasOffset()) tgt.setOffsetElement(UnsignedInt40_N.convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Timing.UnitsOfTime> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Timing.UnitsOfTimeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case S:
                    tgt.setValue(Timing.UnitsOfTime.S);
                    break;
                case MIN:
                    tgt.setValue(Timing.UnitsOfTime.MIN);
                    break;
                case H:
                    tgt.setValue(Timing.UnitsOfTime.H);
                    break;
                case D:
                    tgt.setValue(Timing.UnitsOfTime.D);
                    break;
                case WK:
                    tgt.setValue(Timing.UnitsOfTime.WK);
                    break;
                case MO:
                    tgt.setValue(Timing.UnitsOfTime.MO);
                    break;
                case A:
                    tgt.setValue(Timing.UnitsOfTime.A);
                    break;
                default:
                    tgt.setValue(Timing.UnitsOfTime.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.UnitsOfTimeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> convertDayOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case MON:
                    tgt.setValue(Enumerations.DaysOfWeek.MON);
                    break;
                case TUE:
                    tgt.setValue(Enumerations.DaysOfWeek.TUE);
                    break;
                case WED:
                    tgt.setValue(Enumerations.DaysOfWeek.WED);
                    break;
                case THU:
                    tgt.setValue(Enumerations.DaysOfWeek.THU);
                    break;
                case FRI:
                    tgt.setValue(Enumerations.DaysOfWeek.FRI);
                    break;
                case SAT:
                    tgt.setValue(Enumerations.DaysOfWeek.SAT);
                    break;
                case SUN:
                    tgt.setValue(Enumerations.DaysOfWeek.SUN);
                    break;
                default:
                    tgt.setValue(Enumerations.DaysOfWeek.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> convertDayOfWeek(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.DayOfWeekEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Timing.EventTiming> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Timing.EventTimingEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case MORN:
                    tgt.setValue(Timing.EventTiming.MORN);
                    break;
                case MORN_EARLY:
                    tgt.setValue(Timing.EventTiming.MORN_EARLY);
                    break;
                case MORN_LATE:
                    tgt.setValue(Timing.EventTiming.MORN_LATE);
                    break;
                case NOON:
                    tgt.setValue(Timing.EventTiming.NOON);
                    break;
                case AFT:
                    tgt.setValue(Timing.EventTiming.AFT);
                    break;
                case AFT_EARLY:
                    tgt.setValue(Timing.EventTiming.AFT_EARLY);
                    break;
                case AFT_LATE:
                    tgt.setValue(Timing.EventTiming.AFT_LATE);
                    break;
                case EVE:
                    tgt.setValue(Timing.EventTiming.EVE);
                    break;
                case EVE_EARLY:
                    tgt.setValue(Timing.EventTiming.EVE_EARLY);
                    break;
                case EVE_LATE:
                    tgt.setValue(Timing.EventTiming.EVE_LATE);
                    break;
                case NIGHT:
                    tgt.setValue(Timing.EventTiming.NIGHT);
                    break;
                case PHS:
                    tgt.setValue(Timing.EventTiming.PHS);
                    break;
                case HS:
                    tgt.setValue(Timing.EventTiming.HS);
                    break;
                case WAKE:
                    tgt.setValue(Timing.EventTiming.WAKE);
                    break;
                case C:
                    tgt.setValue(Timing.EventTiming.C);
                    break;
                case CM:
                    tgt.setValue(Timing.EventTiming.CM);
                    break;
                case CD:
                    tgt.setValue(Timing.EventTiming.CD);
                    break;
                case CV:
                    tgt.setValue(Timing.EventTiming.CV);
                    break;
                case AC:
                    tgt.setValue(Timing.EventTiming.AC);
                    break;
                case ACM:
                    tgt.setValue(Timing.EventTiming.ACM);
                    break;
                case ACD:
                    tgt.setValue(Timing.EventTiming.ACD);
                    break;
                case ACV:
                    tgt.setValue(Timing.EventTiming.ACV);
                    break;
                case PC:
                    tgt.setValue(Timing.EventTiming.PC);
                    break;
                case PCM:
                    tgt.setValue(Timing.EventTiming.PCM);
                    break;
                case PCD:
                    tgt.setValue(Timing.EventTiming.PCD);
                    break;
                case PCV:
                    tgt.setValue(Timing.EventTiming.PCV);
                    break;
                default:
                    tgt.setValue(Timing.EventTiming.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.EventTimingEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case MORN:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN);
                    break;
                case MORN_EARLY:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN_EARLY);
                    break;
                case MORN_LATE:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN_LATE);
                    break;
                case NOON:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NOON);
                    break;
                case AFT:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT);
                    break;
                case AFT_EARLY:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT_EARLY);
                    break;
                case AFT_LATE:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT_LATE);
                    break;
                case EVE:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE);
                    break;
                case EVE_EARLY:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE_EARLY);
                    break;
                case EVE_LATE:
                    tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE_LATE);
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
}
