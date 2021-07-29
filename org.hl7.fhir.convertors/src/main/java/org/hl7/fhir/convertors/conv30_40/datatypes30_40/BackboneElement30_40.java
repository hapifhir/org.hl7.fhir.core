package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class BackboneElement30_40 {
    static public void copyBackboneElement(org.hl7.fhir.dstu3.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      for (org.hl7.fhir.dstu3.model.Extension e : src.getModifierExtension()) {
        tgt.addModifierExtension(Extension30_40.convertExtension(e));
      }
    }

    static public void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.dstu3.model.BackboneElement tgt) throws FHIRException {
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
        tgt.addModifierExtension(Extension30_40.convertExtension(e));
      }
    }
}
