package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentManifest10_40 {
  public static org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasRef()) tgt.setRef(Reference10_40.convertReference(src.getRef()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasRef()) tgt.setRef(Reference10_40.convertReference(src.getRef()));
    return tgt;
  }
}
