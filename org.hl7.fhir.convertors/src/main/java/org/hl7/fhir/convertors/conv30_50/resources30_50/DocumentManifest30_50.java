package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentManifest30_50 {
  public static org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasRef()) tgt.setRef(Reference30_50.convertReference(src.getRef()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.r5.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasRef()) tgt.setRef(Reference30_50.convertReference(src.getRef()));
    return tgt;
  }
}
