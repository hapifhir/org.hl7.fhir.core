package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Availability.AvailabilityAvailableTimeComponent;
import org.hl7.fhir.model.core.Availability.AvailabilityNotAvailableTimeComponent;
import org.hl7.fhir.model.core.Enumerations;

/**
 * R4 had availability in each resource (PractitionerRole and HealthcareService availableTime / notAvailable,
 * Location hoursOfOperation); R6 has the Availability datatype. The R4 backbone elements have the same content
 * as Availability's availableTime and notAvailableTime, but different classes (and, for Location, different names
 * for the times), so these work by element name. What doesn't map (R4 availabilityExceptions, R6 Availability.period)
 * is handled by the resources, as cross-version extensions
 */
public class Availability40_N {

  /**
   * R4 [Resource].availableTime / Location.hoursOfOperation to R6 Availability.availableTime
   */
  public static AvailabilityAvailableTimeComponent convertAvailableTime(org.hl7.fhir.r4.model.Element src, String startName, String endName) throws FHIRException {
    AvailabilityAvailableTimeComponent tgt = new AvailabilityAvailableTimeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Base v : src.getChildByName("daysOfWeek").getValues()) {
      org.hl7.fhir.r4.model.Enumeration<?> e = (org.hl7.fhir.r4.model.Enumeration<?>) v;
      org.hl7.fhir.model.core.Enumeration<Enumerations.DaysOfWeek> d = new org.hl7.fhir.model.core.Enumeration<>(new Enumerations.DaysOfWeekEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(e, d);
      if (e.hasCode())
        d.setValue(Enumerations.DaysOfWeek.fromCode(e.getCode()));
      tgt.getDaysOfWeekList().add(d);
    }
    for (org.hl7.fhir.r4.model.Base v : src.getChildByName("allDay").getValues())
      tgt.setAllDayElement((org.hl7.fhir.model.core.BooleanType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
    for (org.hl7.fhir.r4.model.Base v : src.getChildByName(startName).getValues())
      tgt.setAvailableStartTimeElement((org.hl7.fhir.model.core.TimeType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
    for (org.hl7.fhir.r4.model.Base v : src.getChildByName(endName).getValues())
      tgt.setAvailableEndTimeElement((org.hl7.fhir.model.core.TimeType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
    return tgt;
  }

  /**
   * R6 Availability.availableTime to R4 [Resource].availableTime / Location.hoursOfOperation (tgt, already added)
   */
  public static void convertAvailableTime(AvailabilityAvailableTimeComponent src, org.hl7.fhir.r4.model.Element tgt, String startName, String endName) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.Enumeration<Enumerations.DaysOfWeek> d : src.getDaysOfWeekList()) {
      org.hl7.fhir.r4.model.CodeType c = new org.hl7.fhir.r4.model.CodeType(d.getCode());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(d, c);
      tgt.setProperty("daysOfWeek", c);
    }
    if (src.hasAllDay())
      tgt.setProperty("allDay", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAllDayElement()));
    if (src.hasAvailableStartTime())
      tgt.setProperty(startName, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAvailableStartTimeElement()));
    if (src.hasAvailableEndTime())
      tgt.setProperty(endName, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAvailableEndTimeElement()));
  }

  /**
   * R4 [Resource].notAvailable to R6 Availability.notAvailableTime
   */
  public static AvailabilityNotAvailableTimeComponent convertNotAvailable(org.hl7.fhir.r4.model.Element src) throws FHIRException {
    AvailabilityNotAvailableTimeComponent tgt = new AvailabilityNotAvailableTimeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Base v : src.getChildByName("description").getValues())
      tgt.setDescriptionElement((org.hl7.fhir.model.core.StringType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
    for (org.hl7.fhir.r4.model.Base v : src.getChildByName("during").getValues())
      tgt.setDuring(Period40_N.convertPeriod((org.hl7.fhir.r4.model.Period) v));
    return tgt;
  }

  /**
   * R6 Availability.notAvailableTime to R4 [Resource].notAvailable (tgt, already added)
   */
  public static void convertNotAvailable(AvailabilityNotAvailableTimeComponent src, org.hl7.fhir.r4.model.Element tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setProperty("description", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDescriptionElement()));
    if (src.hasDuring())
      tgt.setProperty("during", Period40_N.convertPeriod(src.getDuring()));
  }
}
