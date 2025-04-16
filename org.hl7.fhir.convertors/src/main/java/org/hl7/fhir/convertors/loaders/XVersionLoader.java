package org.hl7.fhir.convertors.loaders;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class XVersionLoader {

  public static Resource loadXml(String version, InputStream stream) throws FHIRFormatError, IOException {
    if (Utilities.noString(version)) {
      return new org.hl7.fhir.r5.formats.XmlParser().parse(stream);
    }
    switch (VersionUtilities.getMajMin(version)) {
      case "1.0":
        return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(stream));
      case "1.4":
        return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(stream));
      case "3.0":
        return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(stream));
      case "4.0":
        return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(stream));
      case "5.0":
        return new org.hl7.fhir.r5.formats.XmlParser().parse(stream);
    }
    throw new FHIRException("Unknown version " + version + " loading resource");
  }

  public static Resource loadJson(String version, InputStream stream) throws FHIRException, IOException {
    if (Utilities.noString(version)) {
      return new org.hl7.fhir.r5.formats.JsonParser().parse(stream);
    }
    switch (VersionUtilities.getMajMin(version)) {
      case "1.0":
        return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(stream));
      case "1.4":
        return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(stream));
      case "3.0":
        return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(stream));
      case "4.0":
        return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(stream));
      case "5.0":
        return new org.hl7.fhir.r5.formats.JsonParser().parse(stream);
    }
    throw new FHIRException("Unknown version " + version + " loading resource");
  }

  public static void saveXml(String version, Resource resource, OutputStream stream) throws FHIRFormatError, IOException {
    if (Utilities.noString(version)) {
      new org.hl7.fhir.r5.formats.XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(stream, resource);
    }
    switch (VersionUtilities.getMajMin(version)) {
      case "1.0":
        new org.hl7.fhir.dstu2.formats.XmlParser().compose(stream, VersionConvertorFactory_10_50.convertResource(resource), true);
        return;
      case "1.4":
        new org.hl7.fhir.dstu2016may.formats.XmlParser(true, true).compose(stream, VersionConvertorFactory_14_50.convertResource(resource), true);
        return;
      case "3.0":
        new org.hl7.fhir.dstu3.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(stream, VersionConvertorFactory_30_50.convertResource(resource));
        return;
      case "4.0":
        new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(stream, VersionConvertorFactory_40_50.convertResource(resource));
        return;
      case "5.0":
        new org.hl7.fhir.r5.formats.XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(stream, resource);
        return;
    }
    throw new FHIRException("Unknown version " + version + " loading resource");
  }

  public static void saveJson(String version, Resource resource, OutputStream stream) throws FHIRException, IOException {
    if (Utilities.noString(version)) {
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(stream, resource);
    }
    switch (VersionUtilities.getMajMin(version)) {
      case "1.0":
         new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(stream, VersionConvertorFactory_10_50.convertResource(resource));
         return;
      case "1.4":
         new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(stream, VersionConvertorFactory_14_50.convertResource(resource));
         return;
      case "3.0":
         new org.hl7.fhir.dstu3.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(stream, VersionConvertorFactory_30_50.convertResource(resource));
         return;
      case "4.0":
         new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(stream, VersionConvertorFactory_40_50.convertResource(resource));
         return;
      case "5.0":
         new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(stream, resource);
         return;
    }
    throw new FHIRException("Unknown version " + version + " loading resource");
  }

}
