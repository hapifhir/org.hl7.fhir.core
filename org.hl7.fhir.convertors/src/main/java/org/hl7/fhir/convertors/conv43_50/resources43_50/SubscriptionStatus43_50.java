package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;


import java.util.stream.Collectors;


public class SubscriptionStatus43_50 {
  public static org.hl7.fhir.r4b.model.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r5.model.SubscriptionStatus src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionStatus tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyResource(src, tgt);
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);

    return tgt;
  }


  public static org.hl7.fhir.r5.model.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r4b.model.SubscriptionStatus src) {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubscriptionStatus tgt = new org.hl7.fhir.r5.model.SubscriptionStatus();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyResource(src, tgt);
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);

    return tgt;
  }
}
