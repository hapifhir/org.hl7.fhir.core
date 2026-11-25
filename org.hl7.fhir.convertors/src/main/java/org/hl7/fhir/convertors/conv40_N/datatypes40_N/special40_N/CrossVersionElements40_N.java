package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.Property;

/**
 * Carries R6 elements that R4 doesn't have in extensions, and back again, generically (by element name, using
 * the R6 model's properties). The extension url is the cross-version extension for the element
 * (http://hl7.org/fhir/[version]/StructureDefinition/extension-[Type].[element]), except where R4 already has a
 * core extension with the same meaning and type, which is used instead (see {@link #R4_CORE_EXTENSIONS})
 * <p>
 * Values whose type R4 doesn't have are carried as complex extensions by {@link CrossVersionDatatype40_N}
 */
public class CrossVersionElements40_N {

  /**
   * The metadata elements that R5 added to the canonical resources that didn't have them in R4
   * (CodeSystem, ValueSet, ConceptMap, NamingSystem...)
   */
  public static final String[] R5_METADATA = {"approvalDate", "lastReviewDate", "effectivePeriod", "topic", "author",
    "editor", "reviewer", "endorser", "relatedArtifact", "copyrightLabel"};

  /**
   * R4 core extensions that are exactly the R6 element (same meaning, same type)
   */
  public static final Map<String, String> R4_CORE_EXTENSIONS = Map.of(
    "approvalDate", "http://hl7.org/fhir/StructureDefinition/resource-approvalDate",
    "lastReviewDate", "http://hl7.org/fhir/StructureDefinition/resource-lastReviewDate",
    "effectivePeriod", "http://hl7.org/fhir/StructureDefinition/resource-effectivePeriod");

  public static String url(String type, String version, String name) {
    // the R4 core extensions are for resource level elements (from R5)
    String core = "5.0".equals(version) && !type.contains(".") ? R4_CORE_EXTENSIONS.get(name) : null;
    return core != null ? core : "http://hl7.org/fhir/" + version + "/StructureDefinition/extension-" + type + "." + name;
  }

  /**
   * @return the extension urls for the named elements - for the ignore list when copying the R4 extensions
   */
  public static String[] urls(String type, String version, String[] names, String... others) {
    List<String> res = new ArrayList<>();
    for (String n : names) {
      res.add(url(type, version, n));
    }
    for (String o : others) {
      res.add(o);
    }
    return res.toArray(new String[0]);
  }

  /**
   * R6 to R4: add the values of the named elements of src to extensions (the list from the R4 target's getExtension())
   */
  public static void elementsToExtensions(Base src, List<org.hl7.fhir.r4.model.Extension> extensions, String version, String... names) throws FHIRException {
    elementsToExtensionsForPath(src, src.fhirType(), extensions, version, names);
  }

  /**
   * As for {@link #elementsToExtensions}, where the element's path isn't its fhirType() (e.g. ConceptMap
   * target.product, which reuses the dependsOn type)
   */
  public static void elementsToExtensionsForPath(Base src, String path, List<org.hl7.fhir.r4.model.Extension> extensions, String version, String... names) throws FHIRException {
    for (String name : names) {
      Property p = src.getChildByName(name);
      if (p == null) {
        throw new FHIRException("Unknown element " + src.fhirType() + "." + name);
      }
      String url = url(path, version, name);
      for (Base v : p.getValues())
        addR4Extension(extensions, url, v);
    }
  }

  private static void addR4Extension(List<org.hl7.fhir.r4.model.Extension> extensions, String url, Base v) throws FHIRException {
    if (v instanceof org.hl7.fhir.model.core.Enumeration) {
      org.hl7.fhir.r4.model.CodeType code = new org.hl7.fhir.r4.model.CodeType(v.primitiveValue());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.model.core.Element) v, code);
      extensions.add(new org.hl7.fhir.r4.model.Extension(url, code));
    } else if (CrossVersionDatatype40_N.isR4Type(v)) {
      extensions.add(new org.hl7.fhir.r4.model.Extension(url, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.model.core.DataType) v)));
    } else if (v.isPrimitive()) {
      // a primitive type R4 doesn't have (integer64): a string, marked with the R6 type
      org.hl7.fhir.r4.model.StringType str = new org.hl7.fhir.r4.model.StringType(v.primitiveValue());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.model.core.Element) v, str);
      str.addExtension(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.r4.model.CodeType(v.fhirType()));
      extensions.add(new org.hl7.fhir.r4.model.Extension(url, str));
    } else {
      org.hl7.fhir.r4.model.Extension ext = CrossVersionDatatype40_N.convertToExtension(url, v);
      // a data type R4 doesn't have (e.g. CodeableReference): the element might be a choice, so the type is recorded
      if (!v.fhirType().contains("."))
        ext.addExtension(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.r4.model.CodeType(v.fhirType()));
      extensions.add(ext);
    }
  }

  /**
   * R6 to R4 for an element R6 allows more of than R4 does: the caller puts the first value in the R4 element, and this
   * puts the rest in cross-version extensions (5.0 if R5 has the element, else 6.0)
   */
  public static void extraValuesToR4(Base src, String name, List<org.hl7.fhir.r4.model.Extension> tgtExtensions) throws FHIRException {
    valuesToR4(src, name, 1, tgtExtensions);
  }

  /**
   * As for {@link #extraValuesToR4}, for the values from index from on
   */
  public static void valuesToR4(Base src, String name, int from, List<org.hl7.fhir.r4.model.Extension> tgtExtensions) throws FHIRException {
    Property p = src.getChildByName(name);
    if (p == null || p.getValues().size() <= from)
      return;
    String path = src.fhirType();
    String url = url(path, inR5(path, name) ? "5.0" : "6.0", name);
    for (Base v : p.getValues().subList(from, p.getValues().size()))
      addR4Extension(tgtExtensions, url, v);
  }

  /**
   * R4 to R6: the reverse of {@link #extraValuesToR4} (call after the R4 element's value has been added)
   */
  public static void extraValuesToR6(List<org.hl7.fhir.r4.model.Extension> srcExtensions, Base tgt, String name, List<org.hl7.fhir.model.core.Extension> tgtExtensions) throws FHIRException {
    String path = tgt.fhirType();
    String version = inR5(path, name) ? "5.0" : "6.0";
    String url = url(path, version, name);
    extensionsToElementsForPath(srcExtensions, tgt, path, version, name);
    tgtExtensions.removeIf(e -> url.equals(e.getUrl()));
  }

  /**
   * R4 to R6: set the named elements of tgt from the extensions (the R4 source's getExtension()). The caller
   * should also leave these extensions out when it copies the rest (see {@link #urls})
   */
  public static void extensionsToElements(List<org.hl7.fhir.r4.model.Extension> extensions, Base tgt, String version, String... names) throws FHIRException {
    extensionsToElementsForPath(extensions, tgt, tgt.fhirType(), version, names);
  }

  /**
   * As for {@link #extensionsToElements}, where the element's path isn't its fhirType()
   */
  public static void extensionsToElementsForPath(List<org.hl7.fhir.r4.model.Extension> extensions, Base tgt, String path, String version, String... names) throws FHIRException {
    for (String name : names) {
      Property p = tgt.getChildByName(name);
      if (p == null) {
        throw new FHIRException("Unknown element " + tgt.fhirType() + "." + name);
      }
      String url = url(path, version, name);
      for (org.hl7.fhir.r4.model.Extension ext : extensions) {
        if (url.equals(ext.getUrl())) {
          String type = ext.hasValue() ? ext.getValue().getExtensionString(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE)
            : ext.getExtensionString(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
          if (ext.hasValue() && type != null) {
            // a primitive type R4 doesn't have (see addR4Extension)
            org.hl7.fhir.model.core.DataType v = (org.hl7.fhir.model.core.DataType) org.hl7.fhir.model.core.ResourceFactory.createType(type);
            ((org.hl7.fhir.model.core.PrimitiveType<?>) v).setValueAsString(ext.getValue().primitiveValue());
            tgt.setProperty(p.getName(), v);
          } else if (ext.hasValue()) {
            tgt.setProperty(p.getName(), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(ext.getValue()));
          } else if (type != null) {
            // a data type R4 doesn't have (see addR4Extension)
            org.hl7.fhir.model.core.DataType v = (org.hl7.fhir.model.core.DataType) org.hl7.fhir.model.core.ResourceFactory.createType(type);
            CrossVersionDatatype40_N.populateDatatype(ext, v, org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
            tgt.setProperty(p.getName(), v);
          } else {
            CrossVersionDatatype40_N.populateDatatype(ext, CrossVersionDatatype40_N.addChild(tgt, name));
          }
        }
      }
    }
  }

  /**
   * R6 to R4: every element of src that R4 doesn't have (tgt has no element of that name) goes in a cross-version
   * extension on tgt: 5.0 if R5 has the element, otherwise 6.0. handled: the R6-only elements the caller deals with
   * itself (e.g. ones it maps to a renamed R4 element). An extension that's already there isn't added again
   */
  public static void newElementsToR4(Base src, org.hl7.fhir.r4.model.Base tgt, List<org.hl7.fhir.r4.model.Extension> tgtExtensions, String... handled) throws FHIRException {
    if (src instanceof org.hl7.fhir.model.core.Extension)
      return;
    String path = src.fhirType();
    for (Property p : src.getChildren()) {
      String name = p.getName().replace("[x]", "");
      if (!p.hasValues() || org.hl7.fhir.utilities.Utilities.existsInList(name, handled) || isBaseElement(name) || isHandled(path, name) || r4Child(tgt, name) != null)
        continue;
      if ("versionAlgorithm".equals(name)) {
        // all the canonical resources use the same extension for this
        if (tgtExtensions.stream().noneMatch(e -> org.hl7.fhir.convertors.VersionConvertorConstants.EXT_VERSION_ALGORITHM.equals(e.getUrl())))
          tgtExtensions.add(new org.hl7.fhir.r4.model.Extension(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_VERSION_ALGORITHM,
            ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.model.core.DataType) p.getValues().get(0))));
        continue;
      }
      String version = inR5(path, name) ? "5.0" : "6.0";
      String u = url(path, version, name);
      if (tgtExtensions.stream().noneMatch(e -> u.equals(e.getUrl())))
        elementsToExtensionsForPath(src, path, tgtExtensions, version, name);
    }
  }

  /**
   * R4 to R6: the reverse of {@link #newElementsToR4}. Call after the extensions have been copied: the extensions for
   * tgt's own elements (not its descendants) that tgt doesn't already have a value for become elements, and are removed
   * from tgtExtensions
   */
  public static void newElementsToR6(List<org.hl7.fhir.r4.model.Extension> srcExtensions, Base tgt, List<org.hl7.fhir.model.core.Extension> tgtExtensions) throws FHIRException {
    String path = tgt.fhirType();
    Property va = tgt.getChildByName("versionAlgorithm");
    if (va != null) {
      for (org.hl7.fhir.r4.model.Extension ext : srcExtensions)
        if (org.hl7.fhir.convertors.VersionConvertorConstants.EXT_VERSION_ALGORITHM.equals(ext.getUrl()) && ext.hasValue() && !va.hasValues())
          tgt.setProperty("versionAlgorithm[x]", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(ext.getValue()));
      tgtExtensions.removeIf(e -> org.hl7.fhir.convertors.VersionConvertorConstants.EXT_VERSION_ALGORITHM.equals(e.getUrl()));
    }
    for (String version : new String[] {"5.0", "6.0"}) {
      String prefix = "http://hl7.org/fhir/" + version + "/StructureDefinition/extension-" + path + ".";
      java.util.Set<String> names = new java.util.LinkedHashSet<>();
      for (org.hl7.fhir.r4.model.Extension ext : srcExtensions)
        if (ext.getUrl() != null && ext.getUrl().startsWith(prefix) && !ext.getUrl().substring(prefix.length()).contains("."))
          names.add(ext.getUrl().substring(prefix.length()));
      // and the R4 core extensions that url() uses instead
      if ("5.0".equals(version) && !path.contains("."))
        for (Map.Entry<String, String> e : R4_CORE_EXTENSIONS.entrySet())
          if (srcExtensions.stream().anyMatch(x -> e.getValue().equals(x.getUrl())))
            names.add(e.getKey());
      for (String name : names) {
        Property p = tgt.getChildByName(name);
        if (p == null || isHandled(path, name))
          continue;
        // if something else already set the element, the extension is just a copy of it
        if (!p.hasValues())
          extensionsToElementsForPath(srcExtensions, tgt, path, version, name);
        String u = url(path, version, name);
        tgtExtensions.removeIf(e -> u.equals(e.getUrl()));
      }
    }
  }

  /**
   * R6-only elements (by path) that the resource convertors map to something in R4 themselves (a renamed element, or
   * an extension with another url), so newElementsToR4/R6 leave them alone
   */
  private static final Map<String, java.util.Set<String>> HANDLED = new java.util.HashMap<>();
  static {
    handled("ActivityDefinition", "dosageInstruction");
    handled("ConceptMap", "sourceScope", "targetScope", "additionalAttribute");
    handled("ConceptMap.group.unmapped", "otherMap");
    handled("DeviceDefinition", "classification", "conformsTo", "deviceVersion", "contact");
    handled("DeviceDefinition.property", "value");
    handled("DeviceDefinition.conformsTo", "specification");
    handled("ExampleScenario.actor", "key", "title");
    handled("ExampleScenario.instance", "key", "title", "structureType");
    handled("ExampleScenario.instance.version", "key");
    handled("ExampleScenario.instance.containedInstance", "instanceReference", "versionReference");
    handled("ExampleScenario.process.step", "number");
    handled("ExampleScenario.process.step.operation", "title");
    handled("ImplementationGuide.definition.page", "source");
    handled("ImplementationGuide.definition.resource", "isExample", "profile");
    handled("ImplementationGuide.manifest.resource", "isExample", "profile");
    handled("Measure", "term");
    handled("PlanDefinition.action.relatedAction", "targetId");
    handled("Questionnaire.item", "answerConstraint");
    handled("TestScript", "testSystem");
  }

  private static void handled(String path, String... names) {
    HANDLED.put(path, new java.util.HashSet<>(java.util.Arrays.asList(names)));
  }

  private static boolean isHandled(String path, String name) {
    return HANDLED.containsKey(path) && HANDLED.get(path).contains(name);
  }

  // the elements every resource or element has, which the copy methods look after
  private static boolean isBaseElement(String name) {
    return org.hl7.fhir.utilities.Utilities.existsInList(name, "id", "meta", "implicitRules", "language", "text", "contained", "extension", "modifierExtension");
  }

  private static final Map<String, Boolean> R5_ELEMENTS = new java.util.concurrent.ConcurrentHashMap<>();

  // whether R5 has the element path.name (path is a resource or type name, then backbone element names)
  private static boolean inR5(String path, String name) {
    return R5_ELEMENTS.computeIfAbsent(path + "." + name, k -> {
      try {
        String[] parts = org.hl7.fhir.utilities.Utilities.simpleSplit(path, ".");
        org.hl7.fhir.r5.model.Base b = org.hl7.fhir.r5.model.ResourceFactory.createResourceOrType(parts[0]);
        for (int i = 1; i < parts.length; i++) {
          if (b.getChildByName(parts[i]) == null)
            return false;
          b = b.makeProperty(parts[i].hashCode(), parts[i]);
        }
        return b.getChildByName(name) != null;
      } catch (Exception e) {
        return false;
      }
    });
  }

  /**
   * The other direction: R4 elements that R6 doesn't have, carried in R6 as 4.0 cross-version extensions
   * (http://hl7.org/fhir/4.0/StructureDefinition/extension-[path].[element]). R4 to R6: add the extensions for
   * the named elements of src (an R4 element whose path is path)
   */
  public static void r4ElementsToExtensions(org.hl7.fhir.r4.model.Base src, String path, List<org.hl7.fhir.model.core.Extension> extensions, String... names) throws FHIRException {
    for (String name : names) {
      org.hl7.fhir.r4.model.Property p = r4Child(src, name);
      if (p == null) {
        throw new FHIRException("Unknown element " + src.fhirType() + "." + name);
      }
      String url = url(path, "4.0", name);
      for (org.hl7.fhir.r4.model.Base v : p.getValues()) {
        if (v instanceof org.hl7.fhir.r4.model.Enumeration) {
          org.hl7.fhir.model.core.CodeType code = new org.hl7.fhir.model.core.CodeType(v.primitiveValue());
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.r4.model.Element) v, code);
          extensions.add(new org.hl7.fhir.model.core.Extension(url, code));
        } else if (v instanceof org.hl7.fhir.r4.model.Type && hasR6Type(v.fhirType())) {
          extensions.add(new org.hl7.fhir.model.core.Extension(url, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v)));
        } else {
          org.hl7.fhir.model.core.Extension ext = CrossVersionDatatype40_N.convertR4ElementToExtension(url, v);
          // a data type R6 doesn't have (e.g. Contributor): the element might be a choice, so the type is recorded
          if (!v.fhirType().contains("."))
            ext.addExtension(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE, new org.hl7.fhir.model.core.CodeType(v.fhirType()));
          extensions.add(ext);
        }
      }
    }
  }

  /**
   * R6 to R4: set the named elements of tgt (an R4 element whose path is path) from the 4.0 extensions. The caller
   * should also leave these extensions out when it copies the rest (see {@link #urls})
   */
  public static void extensionsToR4Elements(List<org.hl7.fhir.model.core.Extension> extensions, org.hl7.fhir.r4.model.Base tgt, String path, String... names) throws FHIRException {
    for (String name : names) {
      String url = url(path, "4.0", name);
      for (org.hl7.fhir.model.core.Extension ext : extensions) {
        if (url.equals(ext.getUrl())) {
          org.hl7.fhir.r4.model.Property p = r4Child(tgt, name);
          String type = ext.getExtensionString(org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE);
          if (ext.hasValue()) {
            tgt.setProperty(p == null ? name : p.getName(), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(ext.getValue()));
          } else if (type != null) {
            // a data type R6 doesn't have (see r4ElementsToExtensions)
            org.hl7.fhir.r4.model.Base v = org.hl7.fhir.r4.model.ResourceFactory.createType(type);
            org.hl7.fhir.model.core.Extension copy = new org.hl7.fhir.model.core.Extension();
            copy.setId(ext.getId());
            for (org.hl7.fhir.model.core.Extension sub : ext.getExtensionList())
              if (!org.hl7.fhir.convertors.VersionConvertorConstants.EXT_ORIGINAL_DATATYPE.equals(sub.getUrl()))
                copy.addExtension(sub);
            CrossVersionDatatype40_N.populateR4Element(copy, v);
            tgt.setProperty(p == null ? name : p.getName(), v);
          } else {
            CrossVersionDatatype40_N.populateR4Element(ext, tgt.addChild(name));
          }
        }
      }
    }
  }

  /**
   * R4 to R6: copy the named elements, which have the same name and type in R4 and R6 (for resources where R4 and
   * R6 share little more than their names, and the shared elements are copied by name)
   */
  public static void copySameElements(org.hl7.fhir.r4.model.Base src, Base tgt, String... names) throws FHIRException {
    for (String name : names) {
      org.hl7.fhir.r4.model.Property p = r4Child(src, name);
      if (p == null) {
        throw new FHIRException("Unknown element " + src.fhirType() + "." + name);
      }
      for (org.hl7.fhir.r4.model.Base v : p.getValues()) {
        if (v instanceof org.hl7.fhir.r4.model.Enumeration) {
          org.hl7.fhir.model.core.CodeType code = new org.hl7.fhir.model.core.CodeType(v.primitiveValue());
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.r4.model.Element) v, code);
          tgt.setProperty(p.getName(), code);
        } else {
          tgt.setProperty(p.getName(), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
        }
      }
    }
  }

  /**
   * R6 to R4: the reverse of {@link #copySameElements(org.hl7.fhir.r4.model.Base, Base, String...)}
   */
  public static void copySameElements(Base src, org.hl7.fhir.r4.model.Base tgt, String... names) throws FHIRException {
    for (String name : names) {
      Property p = src.getChildByName(name);
      if (p == null) {
        throw new FHIRException("Unknown element " + src.fhirType() + "." + name);
      }
      for (Base v : p.getValues()) {
        if (v instanceof org.hl7.fhir.model.core.Enumeration) {
          org.hl7.fhir.r4.model.CodeType code = new org.hl7.fhir.r4.model.CodeType(v.primitiveValue());
          ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement((org.hl7.fhir.model.core.Element) v, code);
          tgt.setProperty(name, code);
        } else {
          tgt.setProperty(name, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.model.core.DataType) v));
        }
      }
    }
  }

  /**
   * R4 to R6 for a choice element whose types changed: the value, if R6 allows its type, and otherwise a 4.0
   * extension. A 5.0 extension (an R6 type R4 doesn't allow, from {@link #choiceToR4}) is the R6 value
   */
  public static void choiceToR6(org.hl7.fhir.r4.model.Base src, List<org.hl7.fhir.r4.model.Extension> srcExtensions, String path, String name,
      Base tgt, List<org.hl7.fhir.model.core.Extension> tgtExtensions) throws FHIRException {
    String url5 = url(path, "5.0", name);
    tgtExtensions.removeIf(e -> url5.equals(e.getUrl()));
    org.hl7.fhir.r4.model.Property p = r4Child(src, name);
    if (p != null && p.hasValues()) {
      org.hl7.fhir.r4.model.Base v = p.getValues().get(0);
      if (allows(tgt.getChildByName(name), v.fhirType()) && hasR6Type(v.fhirType()))
        tgt.setProperty(name + "[x]", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.r4.model.Type) v));
      else
        r4ElementsToExtensions(src, path, tgtExtensions, name);
    }
    extensionsToElementsForPath(srcExtensions, tgt, path, "5.0", name);
  }

  /**
   * R6 to R4: the reverse of {@link #choiceToR6}
   */
  public static void choiceToR4(Base src, List<org.hl7.fhir.model.core.Extension> srcExtensions, String path, String name,
      org.hl7.fhir.r4.model.Base tgt, List<org.hl7.fhir.r4.model.Extension> tgtExtensions) throws FHIRException {
    String url4 = url(path, "4.0", name);
    tgtExtensions.removeIf(e -> url4.equals(e.getUrl()));
    Property p = src.getChildByName(name);
    if (p != null && p.hasValues()) {
      Base v = p.getValues().get(0);
      org.hl7.fhir.r4.model.Property tp = r4Child(tgt, name);
      if (tp != null && allows(tp.getTypeCode(), v.fhirType()) && CrossVersionDatatype40_N.isR4Type(v))
        tgt.setProperty(name + "[x]", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType((org.hl7.fhir.model.core.DataType) v));
      else
        elementsToExtensionsForPath(src, path, tgtExtensions, "5.0", name);
    }
    extensionsToR4Elements(srcExtensions, tgt, path, name);
  }

  /**
   * R6 to R4 for a code: tgt is the R4 code the enumeration convertor made. If it has no R4 code (the R6 code isn't in
   * the R4 value set), the R6 code goes in a 6.0 extension on the R4 element. If the R6 element carries a 4.0
   * extension (an R4 code R6 doesn't have, from {@link #toR6Code}), that's the R4 code
   */
  public static <T extends Enum<?>> org.hl7.fhir.r4.model.Enumeration<T> toR4Code(org.hl7.fhir.model.core.Enumeration<?> src,
      org.hl7.fhir.r4.model.Enumeration<T> tgt, String path, String name) {
    if (tgt == null)
      return null;
    String url4 = url(path, "4.0", name);
    String url6 = url(path, "6.0", name);
    if (tgt.hasExtension(url4)) {
      tgt.setValueAsString(tgt.getExtensionByUrl(url4).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> url4.equals(e.getUrl()));
    } else if (src != null && src.getValue() != null && isNull(tgt.getValue()) && !tgt.hasExtension(url6)) {
      tgt.setValue(null);
      tgt.addExtension(url6, new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()));
    }
    return tgt;
  }

  /**
   * R4 to R6: the reverse of {@link #toR4Code}
   */
  public static <T extends Enum<?>> org.hl7.fhir.model.core.Enumeration<T> toR6Code(org.hl7.fhir.r4.model.Enumeration<?> src,
      org.hl7.fhir.model.core.Enumeration<T> tgt, String path, String name) {
    if (tgt == null)
      return null;
    String url4 = url(path, "4.0", name);
    String url6 = url(path, "6.0", name);
    if (tgt.hasExtension(url6)) {
      tgt.setValueAsString(tgt.getExtensionByUrl(url6).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> url6.equals(e.getUrl()));
    } else if (src != null && src.getValue() != null && !isNull(src.getValue()) && isNull(tgt.getValue()) && !tgt.hasExtension(url4)) {
      tgt.setValue(null);
      tgt.addExtension(url4, new org.hl7.fhir.model.core.CodeType(src.getValueAsString()));
    }
    return tgt;
  }

  /**
   * R6 to R4 for a code copied as is: if R4 doesn't know the code, it goes in a 6.0 extension instead; a 4.0
   * extension (from {@link #copyCodeToR6}) is the R4 code
   */
  public static void copyCodeToR4(org.hl7.fhir.model.core.PrimitiveType<?> src, org.hl7.fhir.r4.model.PrimitiveType<?> tgt, String path, String name) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    String url4 = url(path, "4.0", name);
    String url6 = url(path, "6.0", name);
    if (tgt.hasExtension(url4)) {
      tgt.setValueAsString(tgt.getExtensionByUrl(url4).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> url4.equals(e.getUrl()));
    } else if (src.getValue() != null) {
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (IllegalArgumentException | FHIRException e) {
        tgt.setValue(null);
        tgt.addExtension(url6, new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()));
      }
    }
  }

  /**
   * R4 to R6: the reverse of {@link #copyCodeToR4}
   */
  public static void copyCodeToR6(org.hl7.fhir.r4.model.PrimitiveType<?> src, org.hl7.fhir.model.core.PrimitiveType<?> tgt, String path, String name) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    String url4 = url(path, "4.0", name);
    String url6 = url(path, "6.0", name);
    if (tgt.hasExtension(url6)) {
      tgt.setValueAsString(tgt.getExtensionByUrl(url6).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> url6.equals(e.getUrl()));
    } else if (src.getValue() != null) {
      try {
        tgt.setValueAsString(src.getValueAsString());
      } catch (IllegalArgumentException | FHIRException e) {
        tgt.setValue(null);
        tgt.addExtension(url4, new org.hl7.fhir.model.core.CodeType(src.getValueAsString()));
      }
    }
  }

  // the enumeration convertors use the NULL constant for 'no matching code'
  private static boolean isNull(Enum<?> e) {
    return e == null || "NULL".equals(e.name());
  }

  /**
   * R4 to R6 for a code that R6 maps several R4 codes onto: if the R6 code doesn't make the same R4 code again
   * (regenerated), the R4 code is kept as a 4.0 extension on the R6 code
   */
  public static void keepR4Code(org.hl7.fhir.r4.model.PrimitiveType<?> src, org.hl7.fhir.model.core.Element tgt, org.hl7.fhir.r4.model.PrimitiveType<?> regenerated, String url) {
    if (src != null && src.hasValue() && tgt != null && (regenerated == null || !src.getValueAsString().equals(regenerated.getValueAsString())))
      tgt.addExtension(url, new org.hl7.fhir.model.core.CodeType(src.getValueAsString()));
  }

  /**
   * R6 to R4: the code kept by {@link #keepR4Code} (the extension was copied onto the R4 code with the rest)
   */
  public static void restoreR4Code(org.hl7.fhir.r4.model.PrimitiveType<?> tgt, String url) {
    if (tgt != null && tgt.hasExtension(url)) {
      tgt.setValueAsString(tgt.getExtensionByUrl(url).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> url.equals(e.getUrl()));
    }
  }

  private static boolean allows(Property p, String type) {
    return p != null && allows(p.getTypeCode(), type);
  }

  private static boolean allows(String typeCode, String type) {
    if (typeCode == null)
      return false;
    for (String t : org.hl7.fhir.utilities.Utilities.simpleSplit(typeCode, "|")) {
      t = t.trim();
      if (t.contains("("))
        t = t.substring(0, t.indexOf("("));
      if (t.equals(type) || t.equals("*") || (t.equals("Quantity") && isQuantity(type)) || (isQuantityProfile(t) && isQuantityProfile(type)))
        return true;
    }
    return false;
  }

  // Quantity and its profiles are the same type (the R4 parser makes a Quantity for a SimpleQuantity element)
  private static boolean isQuantityProfile(String type) {
    return org.hl7.fhir.utilities.Utilities.existsInList(type, "Quantity", "SimpleQuantity", "MoneyQuantity");
  }

  // the profiles and specializations of Quantity are allowed wherever Quantity is
  private static boolean isQuantity(String type) {
    return org.hl7.fhir.utilities.Utilities.existsInList(type, "SimpleQuantity", "MoneyQuantity", "Age", "Count", "Distance", "Duration");
  }

  // R4 datatypes that R6 doesn't have (they go into complex extensions)
  private static boolean hasR6Type(String type) {
    return !org.hl7.fhir.utilities.Utilities.existsInList(type, "ProdCharacteristic", "SubstanceAmount", "MarketingStatus", "Population", "Contributor");
  }

  // the R4 property for name, allowing for choice elements (name[x])
  private static org.hl7.fhir.r4.model.Property r4Child(org.hl7.fhir.r4.model.Base b, String name) {
    org.hl7.fhir.r4.model.Property p = b.getChildByName(name);
    return p != null ? p : b.getChildByName(name + "[x]");
  }
}
