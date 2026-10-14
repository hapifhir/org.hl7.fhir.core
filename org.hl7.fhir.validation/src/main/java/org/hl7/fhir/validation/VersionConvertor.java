package org.hl7.fhir.validation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.hl7.fhir.convertors.factory.*;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.context.IWorkerContext;

import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.utilities.VersionUtilities;

public class VersionConvertor {

  public static byte[] convertVersionNativeR2(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu2.model.Resource r2;
    switch (cnt.getCntType()) {
      case JSON:
        r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt.getFocus().getBytes());
        break;
      case XML:
        r2 = new org.hl7.fhir.dstu2.formats.XmlParser().parse(cnt.getFocus().getBytes());
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, r2);
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_10_30.convertResource(r2);
      org.hl7.fhir.dstu2016may.model.Resource r2b = VersionConvertorFactory_14_30.convertResource(r3);
      return getBytesDstu2016(cnt, format, r2b);
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertorFactory_10_30.convertResource(r2));
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_10_40.convertResource(r2));
    } else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, VersionConvertorFactory_10_50.convertResource(r2));
    } else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, VersionConvertorFactory_10_N.convertResource(r2));
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR2b(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu2016may.model.Resource r2b;
    switch (cnt.getCntType()) {
      case JSON:
        r2b = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt.getFocus().getBytes());
        break;
      case XML:
        r2b = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(cnt.getFocus().getBytes());
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertorFactory_14_30.convertResource(r2b);
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertorFactory_10_30.convertResource(r3);
      return getBytesDstu2(cnt, format, r2);
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, r2b);
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertorFactory_14_30.convertResource(r2b));
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_14_40.convertResource(r2b));
    } else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, VersionConvertorFactory_14_50.convertResource(r2b));
    } else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, VersionConvertorFactory_14_N.convertResource(r2b));
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR3(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu3.model.Resource r3;
    switch (cnt.getCntType()) {
      case JSON:
        r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt.getFocus().getBytes());
        break;
      case XML:
        r3 = new org.hl7.fhir.dstu3.formats.XmlParser().parse(cnt.getFocus().getBytes());
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, VersionConvertorFactory_10_30.convertResource(r3));
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, VersionConvertorFactory_14_30.convertResource(r3));
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, r3);
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_30_40.convertResource(r3));
    } else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, VersionConvertorFactory_30_50.convertResource(r3));
    } else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, VersionConvertorFactory_30_N.convertResource(r3));
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR4(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.r4.model.Resource r4;
    switch (cnt.getCntType()) {
      case JSON:
        r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt.getFocus().getBytes());
        break;
      case XML:
        r4 = new org.hl7.fhir.r4.formats.XmlParser().parse(cnt.getFocus().getBytes());
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, VersionConvertorFactory_10_40.convertResource(r4));
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, VersionConvertorFactory_14_40.convertResource(r4));
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertorFactory_30_40.convertResource(r4));
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, r4);
    } else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, VersionConvertorFactory_40_50.convertResource(r4));
    } else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, VersionConvertorFactory_40_N.convertResource(r4));
    }
    else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR4b(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.r4b.model.Resource r4b;
    switch (cnt.getCntType()) {
      case JSON:
        r4b = new org.hl7.fhir.r4b.formats.JsonParser().parse(cnt.getFocus().getBytes());
        break;
      case XML:
        r4b = new org.hl7.fhir.r4b.formats.XmlParser().parse(cnt.getFocus().getBytes());
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR4BVer(targetVer)) {
      return getBytesR4B(cnt, format, r4b);
    } else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, VersionConvertorFactory_43_50.convertResource(r4b));
    } else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, VersionConvertorFactory_43_N.convertResource(r4b));
    }
    else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR5(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.r5.model.Resource r5;
    switch (cnt.getCntType()) {
      case JSON:
        r5 = new org.hl7.fhir.r5.formats.JsonParser().parse(cnt.getFocus().getBytes());
        break;
      case XML:
        r5 = new org.hl7.fhir.r5.formats.XmlParser().parse(cnt.getFocus().getBytes() );
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, VersionConvertorFactory_10_50.convertResource(r5));
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, VersionConvertorFactory_14_50.convertResource(r5));
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertorFactory_30_50.convertResource(r5));
    }
    else if (VersionUtilities.isR4BVer(targetVer)) {
      return getBytesR4B(cnt, format, VersionConvertorFactory_43_50.convertResource(r5));
    }
    else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_40_50.convertResource(r5));
    }
    else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, r5);
    }
    else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, VersionConvertorFactory_50_N.convertResource(r5));
    }
    else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public static byte[] convertVersionNativeR6(IWorkerContext context, String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.model.core.Resource rN;
    switch (cnt.getCntType()) {
      case JSON:
        rN = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext()).parse(cnt.getFocus().getBytes());
        break;
      case XML:
        rN = new org.hl7.fhir.model.core.formats.XmlParser(context.getModelContext()).parse(cnt.getFocus().getBytes() );
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.getCntType().toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      return getBytesDstu2(cnt, format, VersionConvertorFactory_10_N.convertResource(rN));
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      return getBytesDstu2016(cnt, format, VersionConvertorFactory_14_N.convertResource(rN));
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      return getBytesDstu3(cnt, format, VersionConvertorFactory_30_N.convertResource(rN));
    }
    else if (VersionUtilities.isR4BVer(targetVer)) {
      return getBytesR4B(cnt, format, VersionConvertorFactory_43_N.convertResource(rN));
    }
    else if (VersionUtilities.isR4Ver(targetVer)) {
      return getBytesR4(cnt, format, VersionConvertorFactory_40_N.convertResource(rN));
    }
    else if (VersionUtilities.isR5Ver(targetVer)) {
      return getBytesR5(cnt, format, VersionConvertorFactory_50_N.convertResource(rN));
    }
    else if (VersionUtilities.isR6Ver(targetVer)) {
      return getBytesR6(context, cnt, format, rN);
    }
    else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  private static byte[] getBytesDstu2(Content cnt, FhirFormat format, org.hl7.fhir.dstu2.model.Resource r2) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, r2);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.dstu2.formats.XmlParser().compose(bs, r2);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }

  private static byte[] getBytesDstu2016(Content cnt, FhirFormat format, Resource r2b) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.dstu2016may.formats.JsonParser().compose(bs, r2b);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.dstu2016may.formats.XmlParser().compose(bs, r2b);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }

  private static byte[] getBytesDstu3(Content cnt, FhirFormat format, org.hl7.fhir.dstu3.model.Resource r3) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.dstu3.formats.JsonParser().compose(bs, r3);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.dstu3.formats.XmlParser().compose(bs, r3);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }

  private static byte[] getBytesR4(Content cnt, FhirFormat format, org.hl7.fhir.r4.model.Resource r4) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.r4.formats.JsonParser().compose(bs, r4);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.r4.formats.XmlParser().compose(bs, r4);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }

  private static byte[] getBytesR4B(Content cnt, FhirFormat format, org.hl7.fhir.r4b.model.Resource r4b) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.r4b.formats.JsonParser().compose(bs, r4b);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.r4b.formats.XmlParser().compose(bs, r4b);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }

  private static byte[] getBytesR5(Content cnt, FhirFormat format, org.hl7.fhir.r5.model.Resource r5) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.r5.formats.JsonParser().compose(bs, r5);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.r5.formats.XmlParser().compose(bs, r5);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }

  private static byte[] getBytesR6(IWorkerContext context, Content cnt, FhirFormat format, org.hl7.fhir.model.core.Resource rN) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    switch (format) {
      case JSON:
        new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext()).compose(bs, rN);
        return bs.toByteArray();
      case XML:
        new org.hl7.fhir.model.core.formats.XmlParser(context.getModelContext()).compose(bs, rN);
        return bs.toByteArray();
      default:
        throw new FHIRException("Unsupported output format: " + cnt.getCntType().toString());
    }
  }
}
