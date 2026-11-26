package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Extension40_N {
  /*
   * A value of a type R4 doesn't have is carried in the R4 extension, marked with its type (the
   * original-datatype extension): a primitive (integer64) as a string, with the mark on the string; anything else
   * as sub-extensions, with the mark as a sub-extension. The value's own id is an "id" sub-extension (the
   * extension's id is the extension's)
   */
  private static final String VALUE_ID = "id";

  public static org.hl7.fhir.model.core.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Extension tgt = new org.hl7.fhir.model.core.Extension();
    if (src.hasUrl()) tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasValue() && src.getValue().hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE)) {
      // a primitive type R4 doesn't have
      try {
        org.hl7.fhir.model.core.DataType v = (org.hl7.fhir.model.core.DataType) org.hl7.fhir.model.core.ResourceFactory.createType(src.getValue().getExtensionString(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE));
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getValue(), v, VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
        ((org.hl7.fhir.model.core.PrimitiveType<?>) v).setValueAsString(src.getValue().primitiveValue());
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
        tgt.setValue(v);
        return tgt;
      } catch (FHIRException | ClassCastException e) {
        // not a type R6 extensions can have: as it is
      }
    }
    if (!src.hasValue() && src.hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE)) {
      // the value is an R6 datatype that R4 doesn't have, represented as sub-extensions
      String type = src.getExtensionString(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
      try {
        org.hl7.fhir.r4.model.Extension content = new org.hl7.fhir.r4.model.Extension();
        for (org.hl7.fhir.r4.model.Extension sub : src.getExtension())
          if (!VALUE_ID.equals(sub.getUrl()))
            content.addExtension(sub);
        org.hl7.fhir.model.core.DataType v = CrossVersionDatatype40_N.convertFromExtension(content, type, VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
        if (src.hasExtension(VALUE_ID))
          v.setId(src.getExtensionString(VALUE_ID));
        tgt.setValue(v);
        if (src.hasId()) tgt.setId(src.getId());
        return tgt;
      } catch (FHIRException e) {
        // a type an R6 extension can't have either (e.g. a cross-version extension for a choice element whose
        // type is DosageSafety): left as it is, for the element convertors to pick up
        tgt.setValue(null);
      }
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
      } else if (src.getValue().isPrimitive()) {
        // a primitive type R4 doesn't have (integer64): a string, marked with the type
        org.hl7.fhir.r4.model.StringType str = new org.hl7.fhir.r4.model.StringType(src.getValue().primitiveValue());
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getValue(), str);
        str.addExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.r4.model.CodeType(src.getValue().fhirType()));
        tgt.setValue(str);
      } else {
        // a datatype R4 doesn't have: sub-extensions, marked with the type so it can come back
        tgt.addExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.r4.model.CodeType(src.getValue().fhirType()));
        org.hl7.fhir.r4.model.Extension content = new org.hl7.fhir.r4.model.Extension();
        CrossVersionDatatype40_N.populateExtension(src.getValue(), content);
        tgt.getExtension().addAll(content.getExtension());
        if (src.getValue().hasId())
          tgt.addExtension(VALUE_ID, new org.hl7.fhir.r4.model.StringType(src.getValue().getId()));
      }
    }
    // a value of a type R6 doesn't have (from convertExtension(R4))
    String url4 = CrossVersionElements40_N.url("Extension", "4.0", "value");
    tgt.getExtension().removeIf(e -> url4.equals(e.getUrl()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Extension", "value");
    return tgt;
  }
}
