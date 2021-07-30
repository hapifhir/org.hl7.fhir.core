package org.hl7.fhir.validation;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.utilities.VersionUtilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class VersionConvertor {

  public static byte[] convertVersionNativeR2(String targetVer, Content cnt, Manager.FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu2.model.Resource r2;
    switch (cnt.cntType) {
      case JSON:
        r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r2 = new org.hl7.fhir.dstu2.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, r2);
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_10_30.convertResource(r2);
      org.hl7.fhir.dstu2016may.model.Resource r2b = VersionConvertor_14_30.convertResource(r3);
      return getBytesDstu2016(cnt, format, r2b);
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertor_10_30.convertResource(r2));
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertor_10_40.convertResource(r2));
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR2b(String targetVer, Content cnt, Manager.FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu2016may.model.Resource r2b;
    switch (cnt.cntType) {
      case JSON:
        r2b = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r2b = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_14_30.convertResource(r2b);
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertor_10_30.convertResource(r3);
      return getBytesDstu2(cnt, format, r2);
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, r2b);
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertor_14_30.convertResource(r2b));
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_14_40.convertResource(r2b));
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR3(String targetVer, Content cnt, Manager.FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu3.model.Resource r3;
    switch (cnt.cntType) {
      case JSON:
        r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r3 = new org.hl7.fhir.dstu3.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, VersionConvertor_10_30.convertResource(r3));
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, VersionConvertor_14_30.convertResource(r3));
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, r3);
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_30_40.convertResource(r3));
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR4(String targetVer, Content cnt, Manager.FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.r4.model.Resource r4;
    switch (cnt.cntType) {
      case JSON:
        r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r4 = new org.hl7.fhir.r4.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, VersionConvertor_10_40.convertResource(r4));
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, VersionConvertorFactory_14_40.convertResource(r4));
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertorFactory_30_40.convertResource(r4));
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, r4);
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  private static byte[] getBytesDstu2(Content cnt, Manager.FhirFormat format, org.hl7.fhir.dstu2.model.Resource r2) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, r2);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.dstu2.formats.XmlParser().compose(bs, r2);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
    }
  }

  private static byte[] getBytesDstu2016(Content cnt, Manager.FhirFormat format, Resource r2b) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.dstu2016may.formats.JsonParser().compose(bs, r2b);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.dstu2016may.formats.XmlParser().compose(bs, r2b);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
    }
  }

  private static byte[] getBytesDstu3(Content cnt, Manager.FhirFormat format, org.hl7.fhir.dstu3.model.Resource r3) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.dstu3.formats.JsonParser().compose(bs, r3);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.dstu3.formats.XmlParser().compose(bs, r3);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
    }
  }

  private static byte[] getBytesR4(Content cnt, Manager.FhirFormat format, org.hl7.fhir.r4.model.Resource r4) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.r4.formats.JsonParser().compose(bs, r4);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.r4.formats.XmlParser().compose(bs, r4);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
    }
  }
}
