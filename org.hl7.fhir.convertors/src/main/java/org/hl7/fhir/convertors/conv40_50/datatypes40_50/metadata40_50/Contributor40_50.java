package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Contributor40_50 {
  public static org.hl7.fhir.r5.model.Contributor convertContributor(org.hl7.fhir.r4.model.Contributor src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Contributor tgt = new org.hl7.fhir.r5.model.Contributor();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertContributorType(src.getTypeElement()));
    if (src.hasName()) tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Contributor convertContributor(org.hl7.fhir.r5.model.Contributor src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Contributor tgt = new org.hl7.fhir.r4.model.Contributor();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertContributorType(src.getTypeElement()));
    if (src.hasName()) tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contributor.ContributorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contributor.ContributorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Contributor.ContributorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.NULL);
    } else {
      switch (src.getValue()) {
        case AUTHOR:
          tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.AUTHOR);
          break;
        case EDITOR:
          tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.EDITOR);
          break;
        case REVIEWER:
          tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.REVIEWER);
          break;
        case ENDORSER:
          tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.ENDORSER);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.NULL);
          break;
      }
    }
    return tgt;
  }
}
