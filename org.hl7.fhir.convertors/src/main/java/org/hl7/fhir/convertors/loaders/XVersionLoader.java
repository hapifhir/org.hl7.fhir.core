package org.hl7.fhir.convertors.loaders;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

public class XVersionLoader {

  public static Resource loadXml(String version, InputStream stream) throws FHIRFormatError, IOException {
    if (Utilities.noString(version)) {
      return new org.hl7.fhir.r5.formats.XmlParser().parse(stream);
    }
    switch (VersionUtilities.getMajMin(version)) {
    case "1.0": return VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(stream));
    case "1.4": return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(stream));
    case "3.0": return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(stream));
    case "4.0": return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(stream));
    case "5.0": return new org.hl7.fhir.r5.formats.XmlParser().parse(stream);
    }
    throw new FHIRException("Unknown version "+version+" loading resource");
  }

  public static Resource loadJson(String version, InputStream stream) throws FHIRFormatError, FHIRException, IOException {
    if (Utilities.noString(version)) {
      return new org.hl7.fhir.r5.formats.JsonParser().parse(stream);
    }
    switch (VersionUtilities.getMajMin(version)) {
    case "1.0": return VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(stream));
    case "1.4": return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(stream));
    case "3.0": return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(stream));
    case "4.0": return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(stream));
    case "5.0": return new org.hl7.fhir.r5.formats.JsonParser().parse(stream);
    }
    throw new FHIRException("Unknown version "+version+" loading resource");
  }

}
