package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.Factory;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.utilities.Utilities;

/**
 * Represents an R6 datatype that R4 doesn't have (e.g. Availability, CodeableReference, VirtualServiceDetail)
 * as an R4 complex extension, and back again, generically, using the R6 model's property lists:
 * <ul>
 *   <li>each element of the datatype becomes a sub-extension whose url is the element name</li>
 *   <li>an element whose type R4 has goes in that sub-extension's value[x]</li>
 *   <li>an element whose type R4 doesn't have (incl. backbone elements) becomes a nested complex
 *       sub-extension, recursively. If it's a choice element, the url is the type-suffixed name
 *       (e.g. valueAvailability), since the type is otherwise unknown on the way back</li>
 *   <li>the datatype's own extensions are carried as sub-extensions with their own (absolute) urls</li>
 * </ul>
 * The caller provides the cross-version extension URL, and knows the R6 type on the way back
 */
public class CrossVersionDatatype40_N {

  /**
   * @return true if R4 has a type by this name, so the value can be converted directly
   */
  public static boolean isR4Type(Base value) {
    String t = value.fhirType();
    if (t == null || t.contains(".")) {
      return false; // backbone element
    }
    try {
      org.hl7.fhir.r4.model.Enumerations.FHIRDefinedType.fromCode(t);
      return true;
    } catch (FHIRException e) {
      return false;
    }
  }

  // the sub-extension that holds an element's modifier extensions
  private static final String MODIFIER = "modifierExtension";

  private static void addModifierExtension(Base tgt, org.hl7.fhir.model.core.Extension ext) throws FHIRException {
    if (tgt instanceof org.hl7.fhir.model.core.BackboneElement)
      ((org.hl7.fhir.model.core.BackboneElement) tgt).addModifierExtension(ext);
    else if (tgt instanceof org.hl7.fhir.model.core.BackboneType)
      ((org.hl7.fhir.model.core.BackboneType) tgt).addModifierExtension(ext);
    else if (tgt instanceof org.hl7.fhir.model.core.DomainResource)
      ((org.hl7.fhir.model.core.DomainResource) tgt).addModifierExtension(ext);
    else
      throw new FHIRException("A modifier extension on " + tgt.fhirType() + ", which can't have one");
  }

  private static void addModifierExtension(org.hl7.fhir.r4.model.Base tgt, org.hl7.fhir.r4.model.Extension ext) throws FHIRException {
    if (tgt instanceof org.hl7.fhir.r4.model.BackboneElement)
      ((org.hl7.fhir.r4.model.BackboneElement) tgt).addModifierExtension(ext);
    else if (tgt instanceof org.hl7.fhir.r4.model.BackboneType)
      ((org.hl7.fhir.r4.model.BackboneType) tgt).addModifierExtension(ext);
    else if (tgt instanceof org.hl7.fhir.r4.model.DomainResource)
      ((org.hl7.fhir.r4.model.DomainResource) tgt).addModifierExtension(ext);
    else
      throw new FHIRException("A modifier extension on " + tgt.fhirType() + ", which can't have one");
  }

  public static org.hl7.fhir.r4.model.Extension convertToExtension(String url, Base src) throws FHIRException {
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension(url);
    populateExtension(src, tgt);
    return tgt;
  }

  /**
   * add the content of src to tgt as sub-extensions
   */
  public static void populateExtension(Base src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    if (src instanceof org.hl7.fhir.model.core.Element && ((org.hl7.fhir.model.core.Element) src).hasId() && !tgt.hasId()) {
      tgt.setId(((org.hl7.fhir.model.core.Element) src).getId());
    }
    for (Property p : src.getChildren()) {
      String name = p.getName();
      if ("id".equals(name)) {
        continue;
      }
      boolean choice = name.endsWith("[x]");
      if (choice) {
        name = name.substring(0, name.length() - 3);
      }
      for (Base v : p.getValues()) {
        if ("modifierExtension".equals(name)) {
          // kept apart (in a modifierExtension sub-extension), so it comes back as a modifier extension
          tgt.addExtension().setUrl(MODIFIER).addExtension(Extension40_N.convertExtension((org.hl7.fhir.model.core.Extension) v));
        } else if ("extension".equals(name)) {
          tgt.addExtension(Extension40_N.convertExtension((org.hl7.fhir.model.core.Extension) v));
        } else if (v instanceof org.hl7.fhir.model.core.Enumeration) {
          // R4 has code, but the R6 Enumeration isn't a CodeType
          org.hl7.fhir.r4.model.CodeType code = new org.hl7.fhir.r4.model.CodeType(v.primitiveValue());
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.model.core.Element) v, code);
          tgt.addExtension(name, code);
        } else if (isR4Type(v)) {
          tgt.addExtension(name, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.model.core.DataType) v));
        } else if (v.isPrimitive()) {
          // a primitive type R4 doesn't have (integer64): carried as a string
          org.hl7.fhir.r4.model.StringType str = new org.hl7.fhir.r4.model.StringType(v.primitiveValue());
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.model.core.Element) v, str);
          tgt.addExtension(choice ? name + Utilities.capitalize(v.fhirType()) : name, str);
        } else {
          org.hl7.fhir.r4.model.Extension sub = tgt.addExtension().setUrl(choice ? name + Utilities.capitalize(v.fhirType()) : name);
          populateExtension(v, sub);
        }
      }
    }
  }

  /**
   * @param type - the R6 type, which the caller knows from the element definition (or from the original-datatype extension)
   */
  public static org.hl7.fhir.model.core.DataType convertFromExtension(org.hl7.fhir.r4.model.Extension src, String type, String... urlsToIgnore) throws FHIRException {
    org.hl7.fhir.model.core.DataType tgt = new Factory().create(type);
    populateDatatype(src, tgt, urlsToIgnore);
    return tgt;
  }

  /**
   * fill tgt from the sub-extensions of src (the reverse of populateExtension)
   */
  /**
   * tgt.addChild(name), except that the R6 classes refuse addChild for some backbone elements
   * ("Cannot call addChild on an abstract type"), so this falls back to makeProperty, which adds to a list
   * or makes the singleton
   */
  public static Base addChild(Base tgt, String name) throws FHIRException {
    try {
      return tgt.addChild(name);
    } catch (FHIRException e) {
      return tgt.makeProperty(name);
    }
  }

  // the choice element of tgt that url is [choice][Type] for, if there is one
  private static Property choiceProperty(Base tgt, String url) {
    for (Property p : tgt.getChildren()) {
      String n = p.getName();
      if (n.endsWith("[x]") && url.startsWith(n.substring(0, n.length() - 3)) && url.length() > n.length() - 3
          && Character.isUpperCase(url.charAt(n.length() - 3)))
        return p;
    }
    return null;
  }

  // the value as the type, if the type is a primitive R4 doesn't have (so the value is a string)
  private static org.hl7.fhir.model.core.DataType choiceValue(String type, org.hl7.fhir.model.core.DataType v) {
    type = Character.toLowerCase(type.charAt(0)) + type.substring(1);
    if (v instanceof org.hl7.fhir.model.core.StringType && !type.equals("string")) {
      try {
        org.hl7.fhir.model.core.DataType t = (org.hl7.fhir.model.core.DataType) org.hl7.fhir.model.core.ResourceFactory.createType(type);
        if (t instanceof org.hl7.fhir.model.core.PrimitiveType) {
          ((org.hl7.fhir.model.core.PrimitiveType<?>) t).setValueAsString(v.primitiveValue());
          return t;
        }
      } catch (Exception e) {
        // not a type
      }
    }
    return v;
  }

  public static void populateDatatype(org.hl7.fhir.r4.model.Extension src, Base tgt, String... urlsToIgnore) throws FHIRException {
    List<String> ignore = Arrays.asList(urlsToIgnore);
    if (src.hasId() && tgt instanceof org.hl7.fhir.model.core.Element) {
      ((org.hl7.fhir.model.core.Element) tgt).setId(src.getId());
    }
    for (org.hl7.fhir.r4.model.Extension sub : src.getExtension()) {
      String url = sub.getUrl();
      if (url == null || ignore.contains(url)) {
        continue;
      }
      if (Utilities.isAbsoluteUrl(url)) {
        ((org.hl7.fhir.model.core.Element) tgt).addExtension(Extension40_N.convertExtension(sub));
      } else if (MODIFIER.equals(url)) {
        for (org.hl7.fhir.r4.model.Extension m : sub.getExtension())
          addModifierExtension(tgt, Extension40_N.convertExtension(m));
      } else if (sub.hasValue()) {
        org.hl7.fhir.model.core.DataType v = ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(sub.getValue());
        Property p = tgt.getChildByName(url);
        Property cp = p == null ? choiceProperty(tgt, url) : null;
        if (cp != null) {
          // [choice][Type], e.g. valueInteger64 - a primitive type R4 doesn't have is a string (see populateExtension)
          tgt.setProperty(cp.getName(), choiceValue(url.substring(cp.getName().length() - 3), v));
        } else
          tgt.setProperty(p == null ? url : p.getName(), v);
      } else {
        populateDatatype(sub, addChild(tgt, url));
      }
    }
  }

  // --- the other way: R4 elements that R6 doesn't have (e.g. PractitionerRole.availableTime) ---------------

  /**
   * R4 to R6, for an R4 element that R6 doesn't have: the element becomes a complex extension, with a sub-extension
   * per child element (using the R4 model's property list), recursively for backbone elements
   */
  public static org.hl7.fhir.model.core.Extension convertR4ElementToExtension(String url, org.hl7.fhir.r4.model.Base src) throws FHIRException {
    org.hl7.fhir.model.core.Extension tgt = new org.hl7.fhir.model.core.Extension().setUrl(url);
    populateR6Extension(src, tgt);
    return tgt;
  }

  private static void populateR6Extension(org.hl7.fhir.r4.model.Base src, org.hl7.fhir.model.core.Extension tgt) throws FHIRException {
    if (src instanceof org.hl7.fhir.r4.model.Element && ((org.hl7.fhir.r4.model.Element) src).hasId()) {
      tgt.setId(((org.hl7.fhir.r4.model.Element) src).getId());
    }
    for (org.hl7.fhir.r4.model.Property p : src.children()) {
      String name = p.getName();
      if ("id".equals(name)) {
        continue;
      }
      boolean choice = name.endsWith("[x]");
      if (choice) {
        name = name.substring(0, name.length() - 3);
      }
      for (org.hl7.fhir.r4.model.Base v : p.getValues()) {
        if ("modifierExtension".equals(name)) {
          // kept apart (see populateExtension)
          org.hl7.fhir.model.core.Extension m = new org.hl7.fhir.model.core.Extension().setUrl(MODIFIER);
          m.addExtension(Extension40_N.convertExtension((org.hl7.fhir.r4.model.Extension) v));
          tgt.addExtension(m);
        } else if ("extension".equals(name)) {
          tgt.addExtension(Extension40_N.convertExtension((org.hl7.fhir.r4.model.Extension) v));
        } else if (v instanceof org.hl7.fhir.r4.model.Enumeration) {
          org.hl7.fhir.model.core.CodeType code = new org.hl7.fhir.model.core.CodeType(v.primitiveValue());
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.r4.model.Element) v, code);
          tgt.addExtension(name, code);
        } else if (v instanceof org.hl7.fhir.r4.model.Type && !v.fhirType().contains(".")) {
          tgt.addExtension(name, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
        } else {
          org.hl7.fhir.model.core.Extension sub = new org.hl7.fhir.model.core.Extension().setUrl(choice ? name + Utilities.capitalize(v.fhirType()) : name);
          populateR6Extension(v, sub);
          tgt.addExtension(sub);
        }
      }
    }
  }

  /**
   * R6 to R4: fill the R4 element tgt from an extension made by convertR4ElementToExtension
   */
  public static void populateR4Element(org.hl7.fhir.model.core.Extension src, org.hl7.fhir.r4.model.Base tgt) throws FHIRException {
    if (src.hasId() && tgt instanceof org.hl7.fhir.r4.model.Element) {
      ((org.hl7.fhir.r4.model.Element) tgt).setId(src.getId());
    }
    for (org.hl7.fhir.model.core.Extension sub : src.getExtensionList()) {
      String url = sub.getUrl();
      if (url == null) {
        continue;
      }
      if (Utilities.isAbsoluteUrl(url)) {
        ((org.hl7.fhir.r4.model.Element) tgt).addExtension(Extension40_N.convertExtension(sub));
      } else if (MODIFIER.equals(url)) {
        for (org.hl7.fhir.model.core.Extension m : sub.getExtensionList())
          addModifierExtension(tgt, Extension40_N.convertExtension(m));
      } else if (sub.hasValue()) {
        tgt.setProperty(r4PropertyName(tgt, url), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(sub.getValue()));
      } else {
        populateR4Element(sub, tgt.addChild(url));
      }
    }
  }

  private static String r4PropertyName(org.hl7.fhir.r4.model.Base tgt, String name) {
    for (org.hl7.fhir.r4.model.Property p : tgt.children()) {
      if (p.getName().equals(name) || p.getName().equals(name + "[x]")) {
        return p.getName();
      }
    }
    return name;
  }
}
