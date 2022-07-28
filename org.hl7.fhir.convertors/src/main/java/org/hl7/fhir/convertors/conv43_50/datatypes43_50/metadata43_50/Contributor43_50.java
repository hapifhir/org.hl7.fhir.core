package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Contributor43_50 {
  public static org.hl7.fhir.r5.model.Contributor convertContributor(org.hl7.fhir.r4b.model.Contributor src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Contributor tgt = new org.hl7.fhir.r5.model.Contributor();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertContributorType(src.getTypeElement()));
    if (src.hasName()) tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contributor convertContributor(org.hl7.fhir.r5.model.Contributor src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Contributor tgt = new org.hl7.fhir.r4b.model.Contributor();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertContributorType(src.getTypeElement()));
    if (src.hasName()) tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contributor.ContributorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contributor.ContributorTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.NULL);
    } else {
      switch (src.getValue()) {
        case AUTHOR:
          tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.AUTHOR);
          break;
        case EDITOR:
          tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.EDITOR);
          break;
        case REVIEWER:
          tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.REVIEWER);
          break;
        case ENDORSER:
          tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.ENDORSER);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Contributor.ContributorTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Contributor.ContributorType.NULL);
    } else {
      switch (src.getValue()) {
        case AUTHOR:
          tgt.setValue(org.hl7.fhir.r4b.model.Contributor.ContributorType.AUTHOR);
          break;
        case EDITOR:
          tgt.setValue(org.hl7.fhir.r4b.model.Contributor.ContributorType.EDITOR);
          break;
        case REVIEWER:
          tgt.setValue(org.hl7.fhir.r4b.model.Contributor.ContributorType.REVIEWER);
          break;
        case ENDORSER:
          tgt.setValue(org.hl7.fhir.r4b.model.Contributor.ContributorType.ENDORSER);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Contributor.ContributorType.NULL);
          break;
      }
    }
    return tgt;
  }
}
