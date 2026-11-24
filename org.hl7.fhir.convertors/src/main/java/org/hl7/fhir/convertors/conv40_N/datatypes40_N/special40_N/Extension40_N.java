package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension40_N {
  public static org.hl7.fhir.model.core.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Extension tgt = new org.hl7.fhir.model.core.Extension();
    if (src.hasUrl()) tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (!src.hasValue() && src.hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE)) {
      // the value is an R6 datatype that R4 doesn't have, represented as sub-extensions
      if (src.hasId()) tgt.setId(src.getId());
      String type = src.getExtensionString(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
      tgt.setValue(CrossVersionDatatype40_N.convertFromExtension(src, type, VersionConvertorConstants.EXT_ORIGINAL_DATATYPE));
      return tgt;
    }
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.model.core.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasUrl()) tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasValue()) {
      if (CrossVersionDatatype40_N.isR4Type(src.getValue())) {
        tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
      } else {
        // a datatype R4 doesn't have: sub-extensions, marked with the type so it can come back
        tgt.addExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.r4.model.CodeType(src.getValue().fhirType()));
        CrossVersionDatatype40_N.populateExtension(src.getValue(), tgt);
      }
    }
    return tgt;
  }
}
