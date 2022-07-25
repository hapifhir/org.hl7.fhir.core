package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentManifest30_40 {
  public static org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasRef()) tgt.setRef(Reference30_40.convertReference(src.getRef()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasRef()) tgt.setRef(Reference30_40.convertReference(src.getRef()));
    return tgt;
  }
}
