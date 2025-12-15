package org.hl7.fhir.r5.extensions;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;

import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.*;

public class ExtensionUtilities {

  // specific extension helpers

  public static Extension makeIssueSource(ValidationMessage.Source source) {
    Extension ex = new Extension();
    // todo: write this up and get it published with the pack (and handle the redirect?)
    ex.setUrl(ExtensionDefinitions.EXT_ISSUE_SOURCE);
    StringType c = new StringType();
    c.setValue(source.toString());
    ex.setValue(c);
    return ex;
  }

  public static Extension makeIssueMessageId(String msgId) {
    Extension ex = new Extension();
    // todo: write this up and get it published with the pack (and handle the redirect?)
    ex.setUrl(ExtensionDefinitions.EXT_ISSUE_MSG_ID);
    CodeType c = new CodeType();
    c.setValue(msgId);
    ex.setValue(c);
    return ex;
  }

  public static boolean hasExtension(DomainResource de, String url) {
    return getExtension(de, url) != null;
  }

  public static boolean hasExtension(Element e, String url) {
    return getExtension(e, url) != null;
  }

  //  public static void addStringExtension(DomainResource dr, String url, String content) {
  //    if (!StringUtils.isBlank(content)) {
  //      Extension ex = getExtension(dr, url);
  //      if (ex != null)
  //        ex.setValue(new StringType(content));
  //      else
  //        dr.getExtension().add(Factory.newExtension(url, new StringType(content), true));
  //    }
  //  }

  public static void addMarkdownExtension(DomainResource dr, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(dr, url);
      if (ex != null)
        ex.setValue(new StringType(content));
      else
        dr.getExtension().add(Factory.newExtension(url, new MarkdownType(content), true));
    }
  }

  public static void addStringExtension(Element e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new StringType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new StringType(content), true));
    }
  }

  public static void addCodeExtension(Element e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new CodeType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new CodeType(content), true));
    }
  }

  public static void addStringExtension(DomainResource e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new StringType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new StringType(content), true));
    }
  }


  public static void addBooleanExtension(Element e, String url, boolean content) {
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new BooleanType(content));
    else
      e.getExtension().add(Factory.newExtension(url, new BooleanType(content), true));
  }

  public static void addBooleanExtension(DomainResource e, String url, boolean content) {
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new BooleanType(content));
    else
      e.getExtension().add(Factory.newExtension(url, new BooleanType(content), true));
  }

  public static void addIntegerExtension(DomainResource dr, String url, int value) {
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new IntegerType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new IntegerType(value), true));
  }

  public static void addCodeExtension(DomainResource dr, String url, String value) {
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new CodeType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new CodeType(value), true));
  }

  public static void addVSComment(ValueSet.ConceptSetComponent nc, String comment) {
    if (!StringUtils.isBlank(comment))
      nc.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_VS_COMMENT, Factory.newString_(comment), true));
  }
  public static void addVSComment(ValueSet.ConceptReferenceComponent nc, String comment) {
    if (!StringUtils.isBlank(comment))
      nc.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_VS_COMMENT, Factory.newString_(comment), true));
  }

  //  public static void markDeprecated(Element nc) {
  //    setDeprecated(nc);
  //  }
  //

  public static void addDefinition(Element nc, String definition) {
    if (!StringUtils.isBlank(definition))
      nc.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_DEFINITION, Factory.newString_(definition), true));
  }

  public static void addDisplayHint(Element def, String hint) {
    if (!StringUtils.isBlank(hint))
      def.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_DISPLAY_HINT, Factory.newString_(hint), true));
  }

  public static String getDisplayHint(Element def) {
    return readStringExtension(def, ExtensionDefinitions.EXT_DISPLAY_HINT);
  }

  public static String readStringExtension(Element c, String... uris) {
    for (String uri : uris) {
      if (hasExtension(c, uri)) {
        return readStringExtension(c, uri);
      }
    }
    return null;
  }

  public static String readStringFromExtension(Extension ext) {
    if (ext.hasValue() && ext.getValue().isPrimitive()) {
      return ext.getValue().primitiveValue();
    }
    return null;
  }

  public static String readStringExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (ex.getValue() instanceof UriType)
      return ((UriType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CanonicalType)
      return ((CanonicalType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CodeType)
      return ((CodeType) ex.getValue()).getValue();
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof Integer64Type)
      return ((Integer64Type) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof DecimalType)
      return ((DecimalType) ex.getValue()).asStringValue();
    if ((ex.getValue() instanceof MarkdownType))
      return ((MarkdownType) ex.getValue()).getValue();
    if ((ex.getValue() instanceof PrimitiveType))
      return ((PrimitiveType) ex.getValue()).primitiveValue();
    if (!(ex.getValue() instanceof StringType))
      return null;
    return ((StringType) ex.getValue()).getValue();
  }

  public static List<String> readStringExtensions(Element c, String uri) {
    List<String> res = new ArrayList<>();
    List<Extension> list = ExtensionHelper.getExtensionList(c, uri);
    for (Extension ex : list) {
      if (ex != null) {
        if (ex.getValue() instanceof UriType)
          res.add(((UriType) ex.getValue()).getValue());
        if (ex.getValue() instanceof CanonicalType)
          res.add(((CanonicalType) ex.getValue()).getValue());
        if (ex.getValue() instanceof CodeType)
          res.add(((CodeType) ex.getValue()).getValue());
        if (ex.getValue() instanceof IntegerType)
          res.add(((IntegerType) ex.getValue()).asStringValue());
        if (ex.getValue() instanceof Integer64Type)
          res.add(((Integer64Type) ex.getValue()).asStringValue());
        if (ex.getValue() instanceof DecimalType)
          res.add(((DecimalType) ex.getValue()).asStringValue());
        if ((ex.getValue() instanceof MarkdownType))
          res.add(((MarkdownType) ex.getValue()).getValue());
        if ((ex.getValue() instanceof PrimitiveType))
          res.add(((PrimitiveType) ex.getValue()).primitiveValue());
        if ((ex.getValue() instanceof StringType))
          res.add(((StringType) ex.getValue()).getValue());
      }
    }
    return res;
  }

  public static String readStringExtension(DomainResource c, String... uris) {
    for (String uri : uris) {
      if (hasExtension(c, uri)) {
        return readStringExtension(c, uri);
      }
    }
    return null;
  }

  public static String readStringExtension(DomainResource c, String uri) {
    Extension ex = getExtension(c, uri);
    if (ex == null)
      return null;
    if ((ex.getValue() instanceof StringType))
      return ((StringType) ex.getValue()).getValue();
    if ((ex.getValue() instanceof UriType))
      return ((UriType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CodeType)
      return ((CodeType) ex.getValue()).getValue();
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof Integer64Type)
      return ((Integer64Type) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof DecimalType)
      return ((DecimalType) ex.getValue()).asStringValue();
    if ((ex.getValue() instanceof MarkdownType))
      return ((MarkdownType) ex.getValue()).getValue();
    return null;
  }

  public static String readStringSubExtension(DomainResource c, String uri, String name) {
    Extension ex = getExtension(c, uri);
    if (ex == null)
      return null;
    ex = getExtension(ex, name);
    if (ex == null)
      return null;
    if ((ex.getValue() instanceof StringType))
      return ((StringType) ex.getValue()).getValue();
    if ((ex.getValue() instanceof UriType))
      return ((UriType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CodeType)
      return ((CodeType) ex.getValue()).getValue();
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof Integer64Type)
      return ((Integer64Type) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof DecimalType)
      return ((DecimalType) ex.getValue()).asStringValue();
    if ((ex.getValue() instanceof MarkdownType))
      return ((MarkdownType) ex.getValue()).getValue();
    return null;
  }

  @SuppressWarnings("unchecked")
  public static PrimitiveType<DataType> readPrimitiveExtension(DomainResource c, String uri) {
    Extension ex = getExtension(c, uri);
    if (ex == null)
      return null;
    return (PrimitiveType<DataType>) ex.getValue();
  }

  public static boolean findStringExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof StringType))
      return false;
    return !StringUtils.isBlank(((StringType) ex.getValue()).getValue());
  }

  public static Boolean readBooleanExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (!(ex.getValue() instanceof BooleanType))
      return null;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean findBooleanExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return true;
  }

  public static Boolean readBooleanExtension(DomainResource c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (!(ex.getValue() instanceof BooleanType))
      return null;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean readBoolExtension(DomainResource c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean readBoolExtension(DomainResource c, String... uris) {
    Extension ex = null;
    for (String uri : uris) {
      ex = ExtensionHelper.getExtension(c, uri);
      if (ex != null) {
        break;
      }
    }
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean readBoolExtension(Element e, String uri) {
    Extension ex = ExtensionHelper.getExtension(e, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    if (!(ex.getValue().hasPrimitiveValue()))
      return false;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean findBooleanExtension(DomainResource c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return true;
  }

  //  public static boolean hasDeprecated(Element c) {
  //    return findBooleanExtension(c, EXT_DEPRECATED);
  //  }

  public static void addFlyOver(Questionnaire.QuestionnaireItemComponent item, String text, String linkId){
    if (!StringUtils.isBlank(text)) {
      Questionnaire.QuestionnaireItemComponent display = item.addItem();
      display.setType(Questionnaire.QuestionnaireItemType.DISPLAY);
      display.setText(text);
      display.setLinkId(linkId);
      display.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_CONTROL, Factory.newCodeableConcept("flyover", "http://hl7.org/fhir/questionnaire-item-control", "Fly-over"), true));
    }
  }

  public static void addMin(Questionnaire.QuestionnaireItemComponent item, int min) {
    item.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_MINOCCURS, Factory.newInteger(min), true));
  }

  public static void addMax(Questionnaire.QuestionnaireItemComponent item, int max) {
    item.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_MAXOCCURS, Factory.newInteger(max), true));
  }

  public static void addFhirType(Questionnaire.QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_FHIRTYPE, Factory.newString_(value), true));
  }

  public static void addControl(Questionnaire.QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_CONTROL, Factory.newCodeableConcept(value, "http://hl7.org/fhir/questionnaire-item-control", value), true));
  }

  public static void addAllowedResource(Questionnaire.QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_ALLOWEDRESOURCE, Factory.newCode(value), true));
  }

  public static void addReferenceFilter(Questionnaire.QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_REFERENCEFILTER, Factory.newString_(value), true));
  }

  //  public static void addIdentifier(Element element, Identifier value) {
  //    element.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_IDENTIFIER, value, true));
  //  }

  /**
   * @param name the identity of the extension of interest
   * @return The extension, if on this element, else null
   */
  public static Extension getExtension(DomainResource resource, String name) {
    if (resource == null || name == null)
      return null;
    if (!resource.hasExtension())
      return null;
    for (Extension e : resource.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  public static Extension getExtension(Element el, String name) {
    if (name == null)
      return null;
    if (!el.hasExtension())
      return null;
    for (Extension e : el.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  public static void setStringExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new StringType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new StringType(value)));
  }

  public static void setStringExtension(Element resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new StringType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new StringType(value)));
  }

  public static void setUriExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new UriType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new UriType(value)));
  }

  public static void setUriExtension(Element resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new UriType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new UriType(value)));
  }

  public static void setCanonicalExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new UriType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new CanonicalType(value)));
  }

  public static void setCanonicalExtension(Element resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new UriType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new CanonicalType(value)));
  }

  public static void setUrlExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new UrlType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new UrlType(value)));
  }

  public static void setUrlExtension(Element resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new UrlType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new UrlType(value)));
  }

  public static void setCodeExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;

    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new CodeType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new CodeType(value)));
  }

  public static void setCodeExtensionMod(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;

    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new CodeType(value));
    else
      resource.getModifierExtension().add(new Extension(uri).setValue(new CodeType(value)));
  }

  public static void setCodeExtensionMod(BackboneElement resource, String uri, String value) {
    if (Utilities.noString(value))
      return;

    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new CodeType(value));
    else
      resource.getModifierExtension().add(new Extension(uri).setValue(new CodeType(value)));
  }

  public static void setCodeExtension(Element element, String uri, String value) {
    if (Utilities.noString(value))
      return;

    Extension ext = getExtension(element, uri);
    if (ext != null)
      ext.setValue(new CodeType(value));
    else
      element.getExtension().add(new Extension(uri).setValue(new CodeType(value)));
  }

  public static void setMarkdownExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;

    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new MarkdownType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new MarkdownType(value)));
  }

  public static void setIntegerExtension(DomainResource resource, String uri, int value) {
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new IntegerType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new IntegerType(value)));
  }

  //  public static String getOID(CodeSystem define) {
  //    return readStringExtension(define, EXT_OID);
  //  }
  //
  //  public static String getOID(ValueSet vs) {
  //    return readStringExtension(vs, EXT_OID);
  //  }
  //
  //  public static void setOID(CodeSystem define, String oid) throws FHIRFormatError, URISyntaxException {
  //    if (!oid.startsWith("urn:oid:"))
  //      throw new FHIRFormatError("Error in OID format");
  //    if (oid.startsWith("urn:oid:urn:oid:"))
  //      throw new FHIRFormatError("Error in OID format");
  //    if (!hasExtension(define, EXT_OID))
  //    define.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_OID, Factory.newUri(oid), false));
  //    else if (!oid.equals(readStringExtension(define, EXT_OID)))
  //      throw new Error("Attempt to assign multiple OIDs to a code system");
  //  }
  //  public static void setOID(ValueSet vs, String oid) throws FHIRFormatError, URISyntaxException {
  //    if (!oid.startsWith("urn:oid:"))
  //      throw new FHIRFormatError("Error in OID format");
  //    if (oid.startsWith("urn:oid:urn:oid:"))
  //      throw new FHIRFormatError("Error in OID format");
  //    if (!hasExtension(vs, EXT_OID))
  //    vs.getExtension().add(Factory.newExtension(ExtensionDefinitions.EXT_OID, Factory.newUri(oid), false));
  //    else if (!oid.equals(readStringExtension(vs, EXT_OID)))
  //      throw new Error("Attempt to assign multiple OIDs to value set "+vs.getName()+" ("+vs.getUrl()+"). Has "+readStringExtension(vs, EXT_OID)+", trying to add "+oid);
  //  }

  public static boolean hasLanguageTranslations(Element element) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasLanguageTranslation(Element element, String lang) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
        Extension e1 = ExtensionHelper.getExtension(e, "lang");

        if (e1 != null && e1.getValue() instanceof CodeType && ((CodeType) e.getValue()).getValue().equals(lang))
          return true;
      }
    }
    return false;
  }

  public static String getLanguageTranslation(Element element, String lang) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
        Extension e1 = ExtensionHelper.getExtension(e, "lang");

        if (e1 != null && e1.getValue() != null && e1.getValue() instanceof CodeType && ((CodeType) e1.getValue()).getValue().equals(lang)) {
          e1 = ExtensionHelper.getExtension(e, "content");
          if (e1 != null && e1.hasValue()) {
            return e1.getValue().primitiveValue();
          }
        }
      }
    }
    return null;
  }

  public static Extension getLanguageExtension(Element element, String lang) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
        Extension e1 = ExtensionHelper.getExtension(e, "lang");

        if (e1 != null && e1.getValue() != null && e1.getValue() instanceof CodeType && ((CodeType) e1.getValue()).getValue().equals(lang)) {
          e1 = ExtensionHelper.getExtension(e, "content");
          if (e1 != null && e1.hasValue()) {
            return e1;
          }
        }
      }
    }
    return null;
  }

  public static StringType getLanguageTranslationElement(Element element, String lang) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
        Extension e1 = ExtensionHelper.getExtension(e, "lang");

        if (e1 != null && e1.getValue() != null && e1.getValue() instanceof CodeType && ((CodeType) e1.getValue()).getValue().equals(lang)) {
          e1 = ExtensionHelper.getExtension(e, "content");
          return ((StringType) e1.getValue());
        }
      }
    }
    return null;
  }

  public static void addLanguageTranslation(Element element, String lang, String value) {
    if (Utilities.noString(lang) || Utilities.noString(value))
      return;

    Extension extension = new Extension().setUrl(ExtensionDefinitions.EXT_TRANSLATION);
    extension.addExtension().setUrl("lang").setValue(new CodeType(lang));
    extension.addExtension().setUrl("content").setValue(new StringType(value));
    element.getExtension().add(extension);
  }

  public static void setLanguageTranslation(Element element, String lang, String value) {
    if (Utilities.noString(lang) || Utilities.noString(value))
      return;

    for (Extension extension : element.getExtension()) {
      if (ExtensionDefinitions.EXT_TRANSLATION.equals(extension.getUrl())) {
        String l = extension.getExtensionString("lang");
        if (lang.equals(l)) {
          setStringExtension(extension, "content", value);
          return;
        }
      }
    }

    Extension extension = new Extension().setUrl(ExtensionDefinitions.EXT_TRANSLATION);
    extension.addExtension().setUrl("lang").setValue(new CodeType(lang));
    extension.addExtension().setUrl("content").setValue(new StringType(value));
    element.getExtension().add(extension);
  }

  public static boolean hasAllowedUnits(ElementDefinition eld) {
    for (Extension e : eld.getExtension())
      if (e.getUrl().equals(ExtensionDefinitions.EXT_ALLOWABLE_UNITS))
        return true;
    return false;
  }

  public static DataType getAllowedUnits(ElementDefinition eld) {
    for (Extension e : eld.getExtension())
      if (e.getUrl().equals(ExtensionDefinitions.EXT_ALLOWABLE_UNITS))
        return e.getValue();
    return null;
  }

  public static void setAllowableUnits(ElementDefinition eld, CodeableConcept cc) {
    for (Extension e : eld.getExtension())
      if (e.getUrl().equals(ExtensionDefinitions.EXT_ALLOWABLE_UNITS)) {
        e.setValue(cc);
        return;
      }
    eld.getExtension().add(new Extension().setUrl(ExtensionDefinitions.EXT_ALLOWABLE_UNITS).setValue(cc));
  }

  public static List<Extension> getExtensions(Element element, String url) {
    List<Extension> results = new ArrayList<Extension>();
    for (Extension ex : element.getExtension())
      if (ex.getUrl().equals(url))
        results.add(ex);
    return results;
  }

  public static List<Extension> getExtensions(DomainResource resource, String url) {
    List<Extension> results = new ArrayList<Extension>();
    for (Extension ex : resource.getExtension())
      if (ex.getUrl().equals(url))
        results.add(ex);
    return results;
  }

  //  public static void addDEReference(DataElement de, String value) {
  //    for (Extension e : de.getExtension())
  //      if (e.getUrl().equals(ExtensionDefinitions.EXT_CIMI_REFERENCE)) {
  //        e.setValue(new UriType(value));
  //        return;
  //      }
  //    de.getExtension().add(new Extension().setUrl(ExtensionDefinitions.EXT_CIMI_REFERENCE).setValue(new UriType(value)));
  //  }

  //  public static void setDeprecated(Element nc) {
  //    for (Extension e : nc.getExtension())
  //      if (e.getUrl().equals(ExtensionDefinitions.EXT_DEPRECATED)) {
  //        e.setValue(new BooleanType(true));
  //        return;
  //      }
  //    nc.getExtension().add(new Extension().setUrl(ExtensionDefinitions.EXT_DEPRECATED).setValue(new BooleanType(true)));
  //  }

  public static void setExtension(Element focus, String url, Coding c) {
    for (Extension e : focus.getExtension())
      if (e.getUrl().equals(url)) {
        e.setValue(c);
        return;
      }
    focus.getExtension().add(new Extension().setUrl(url).setValue(c));
  }

  public static void removeExtension(DomainResource focus, String url) {
    Iterator<Extension> i = focus.getExtension().iterator();
    while (i.hasNext()) {
      Extension e = i.next(); // must be called before you can call i.remove()
      if (url.equals(e.getUrl())) {
        i.remove();
      }
    }
  }

  public static void removeExtension(Element focus, String url) {
    Iterator<Extension> i = focus.getExtension().iterator();
    while (i.hasNext()) {
      Extension e = i.next(); // must be called before you can call i.remove()
      if (e.getUrl().equals(url)) {
        i.remove();
      }
    }
  }

  public static int readIntegerExtension(DomainResource dr, String uri, int defaultValue) {
    Extension ex = ExtensionHelper.getExtension(dr, uri);
    if (ex == null)
      return defaultValue;
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).getValue();
    throw new Error("Unable to read extension "+uri+" as an integer");
  }

  public static int readIntegerExtension(Element e, String uri, int defaultValue) {
    Extension ex = ExtensionHelper.getExtension(e, uri);
    if (ex == null)
      return defaultValue;
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).getValue();
    if (ex.getValue() instanceof DecimalType)
      return ((DecimalType) ex.getValue()).getValue().intValue();
    throw new Error("Unable to read extension "+uri+" as an integer");
  }

  public static Map<String, String> getLanguageTranslations(Element e) {
    Map<String, String> res = new HashMap<String, String>();
    for (Extension ext : e.getExtension()) {
      if (ext.getUrl().equals(ExtensionDefinitions.EXT_TRANSLATION)) {
        String lang = readStringExtension(ext, "lang");
        String value = readStringExtension(ext, "content");
        res.put(lang,  value);
      }
    }
    return res;
  }

  public static StandardsStatus getStandardsStatus(DomainResource dr) throws FHIRException {
    return StandardsStatus.fromCode(ExtensionUtilities.readStringExtension(dr, ExtensionDefinitions.EXT_STANDARDS_STATUS));
  }

  public static StandardsStatus getStandardsStatus(Element e) throws FHIRException {
    return StandardsStatus.fromCode(ExtensionUtilities.readStringExtension(e, ExtensionDefinitions.EXT_STANDARDS_STATUS));
  }

  public static void setStandardsStatus(DomainResource dr, StandardsStatus status, String normativeVersion) {
    if (status == null)
      ExtensionUtilities.removeExtension(dr, ExtensionDefinitions.EXT_STANDARDS_STATUS);
    else
      ExtensionUtilities.setCodeExtension(dr, ExtensionDefinitions.EXT_STANDARDS_STATUS, status.toCode());
    if (normativeVersion == null)
      ExtensionUtilities.removeExtension(dr, ExtensionDefinitions.EXT_NORMATIVE_VERSION);
    else
      ExtensionUtilities.setCodeExtension(dr, ExtensionDefinitions.EXT_NORMATIVE_VERSION, normativeVersion);
  }

  public static void setStandardsStatus(Element dr, StandardsStatus status, String normativeVersion) {
    if (status == null)
      ExtensionUtilities.removeExtension(dr, ExtensionDefinitions.EXT_STANDARDS_STATUS);
    else
      ExtensionUtilities.setCodeExtension(dr, ExtensionDefinitions.EXT_STANDARDS_STATUS, status.toCode());
    if (normativeVersion == null)
      ExtensionUtilities.removeExtension(dr, ExtensionDefinitions.EXT_NORMATIVE_VERSION);
    else
      ExtensionUtilities.setCodeExtension(dr, ExtensionDefinitions.EXT_NORMATIVE_VERSION, normativeVersion);
  }

  public static ValidationMessage readValidationMessage(OperationOutcome.OperationOutcomeIssueComponent issue, ValidationMessage.Source source) {
    ValidationMessage vm = new ValidationMessage();
    vm.setSource(source);
    vm.setLevel(mapSeverity(issue.getSeverity()));
    vm.setType(mapType(issue.getCode()));
    if (issue.hasExtension(ExtensionDefinitions.EXT_ISSUE_LINE))
      vm.setLine(ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_LINE, 0));
    if (issue.hasExtension(ExtensionDefinitions.EXT_ISSUE_COL))
      vm.setCol(ExtensionUtilities.readIntegerExtension(issue, ExtensionDefinitions.EXT_ISSUE_COL, 0));
    if (issue.hasExpression())
      vm.setLocation(issue.getExpression().get(0).asStringValue());
    vm.setMessage(issue.getDetails().getText());
    if (issue.hasExtension("http://hl7.org/fhir/StructureDefinition/rendering-xhtml"))
      vm.setHtml(ExtensionUtilities.readStringExtension(issue, "http://hl7.org/fhir/StructureDefinition/rendering-xhtml"));
    return vm;
  }

  private static ValidationMessage.IssueType mapType(org.hl7.fhir.r5.model.OperationOutcome.IssueType code) {
    if (code == null) {
      return null;
    }
    switch (code) {
      case BUSINESSRULE: return ValidationMessage.IssueType.BUSINESSRULE;
      case CODEINVALID: return ValidationMessage.IssueType.CODEINVALID;
      case CONFLICT: return ValidationMessage.IssueType.CONFLICT;
      case DELETED: return ValidationMessage.IssueType.DELETED;
      case DUPLICATE: return ValidationMessage.IssueType.DUPLICATE;
      case EXCEPTION: return ValidationMessage.IssueType.EXCEPTION;
      case EXPIRED: return ValidationMessage.IssueType.EXPIRED;
      case EXTENSION: return ValidationMessage.IssueType.EXTENSION;
      case FORBIDDEN: return ValidationMessage.IssueType.FORBIDDEN;
      case INCOMPLETE: return ValidationMessage.IssueType.INCOMPLETE;
      case INFORMATIONAL: return ValidationMessage.IssueType.INFORMATIONAL;
      case INVALID: return ValidationMessage.IssueType.INVALID;
      case INVARIANT: return ValidationMessage.IssueType.INVARIANT;
      case LOCKERROR: return ValidationMessage.IssueType.LOCKERROR;
      case LOGIN: return ValidationMessage.IssueType.LOGIN;
      case MULTIPLEMATCHES: return ValidationMessage.IssueType.MULTIPLEMATCHES;
      case NOSTORE: return ValidationMessage.IssueType.NOSTORE;
      case NOTFOUND: return ValidationMessage.IssueType.NOTFOUND;
      case NOTSUPPORTED: return ValidationMessage.IssueType.NOTSUPPORTED;
      case NULL: return ValidationMessage.IssueType.NULL;
      case PROCESSING: return ValidationMessage.IssueType.PROCESSING;
      case REQUIRED: return ValidationMessage.IssueType.REQUIRED;
      case SECURITY: return ValidationMessage.IssueType.SECURITY;
      case STRUCTURE: return ValidationMessage.IssueType.STRUCTURE;
      case SUPPRESSED: return ValidationMessage.IssueType.SUPPRESSED;
      case THROTTLED: return ValidationMessage.IssueType.THROTTLED;
      case TIMEOUT: return ValidationMessage.IssueType.TIMEOUT;
      case TOOCOSTLY: return ValidationMessage.IssueType.TOOCOSTLY;
      case TOOLONG: return ValidationMessage.IssueType.TOOLONG;
      case TRANSIENT: return ValidationMessage.IssueType.TRANSIENT;
      case UNKNOWN: return ValidationMessage.IssueType.UNKNOWN;
      case VALUE: return ValidationMessage.IssueType.VALUE;
      default: return null;
    }
  }

  private static ValidationMessage.IssueSeverity mapSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity severity) {
    if (severity == null) {
      return null;
    }
    switch (severity) {
      case ERROR: return ValidationMessage.IssueSeverity.ERROR;
      case FATAL: return ValidationMessage.IssueSeverity.FATAL;
      case INFORMATION: return ValidationMessage.IssueSeverity.INFORMATION;
      case WARNING: return ValidationMessage.IssueSeverity.WARNING;
      default: return null;
    }
  }

  public static String getPresentation(PrimitiveType<?> type) {
    if (type.hasExtension(ExtensionDefinitions.EXT_RENDERED_VALUE))
      return readStringExtension(type, ExtensionDefinitions.EXT_RENDERED_VALUE);
    return type.primitiveValue();
  }

  public static String getPresentation(Element holder, PrimitiveType<?> type) {
    if (holder.hasExtension(ExtensionDefinitions.EXT_RENDERED_VALUE))
      return readStringExtension(holder, ExtensionDefinitions.EXT_RENDERED_VALUE);
    if (type.hasExtension(ExtensionDefinitions.EXT_RENDERED_VALUE))
      return readStringExtension(type, ExtensionDefinitions.EXT_RENDERED_VALUE);
    return type.primitiveValue();
  }

  //  public static boolean hasOID(ValueSet vs) {
  //    return hasExtension(vs, EXT_OID);
  //  }
  //
  //  public static boolean hasOID(CodeSystem cs) {
  //    return hasExtension(cs, EXT_OID);
  //  }
  //
  public static void addUrlExtension(Element e, String url, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new UrlType(value));
    else
      e.getExtension().add(Factory.newExtension(url, new UrlType(value), true));
  }

  public static void addUrlExtension(DomainResource dr, String url, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new UrlType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new UrlType(value), true));
  }

  public static void addUriExtension(Element e, String url, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new UriType(value));
    else
      e.getExtension().add(Factory.newExtension(url, new UriType(value), true));
  }

  public static void addUriExtension(DomainResource dr, String url, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new UriType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new UriType(value), true));
  }

  public static void addCanonicalExtension(Element e, String url, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new CanonicalType(value));
    else
      e.getExtension().add(Factory.newExtension(url, new CanonicalType(value), true));

  }

  public static void addCanonicalExtension(DomainResource dr, String url, String value) {
    if (StringUtils.isBlank(value)) {
      return;
    }
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new CanonicalType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new CanonicalType(value), true));
  }


  public static boolean usesExtension(String url, Base base) {
    if ("Extension".equals(base.fhirType())) {
      Property p = base.getNamedProperty("url");
      for (Base b : p.getValues()) {
        if (url.equals(b.primitiveValue())) {
          return true;
        }
      }
    }

    for (Property p : base.children() ) {
      for (Base v : p.getValues()) {
        if (usesExtension(url, v)) {
          return true;
        }
      }
    }
    return false;
  }

  private static Set<String> cachedConsts;

  public static Set<String> allConsts() {
    if (cachedConsts == null) {
      Set<String> list = new HashSet<>();
      for (Field field : ExtensionUtilities.class.getDeclaredFields()) {
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
          try {
            list.add(field.get(field.getType()).toString());
          } catch (Exception e) {
          }
        }
      }
      cachedConsts = list;
    }
    return cachedConsts;
  }

  public static boolean hasAnyOfExtensions(Element d, String... urls) {
    for (String url : urls) {
      if (d.hasExtension(url)) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasAnyOfExtensions(DomainResource dr, String... urls) {
    for (String url : urls) {
      if (dr.hasExtension(url)) {
        return true;
      }
    }
    return false;
  }

  public static int countExtensions(ElementDefinition d, String... urls) {
    int res = 0;
    for (String url : urls) {
      if (d.hasExtension(url)) {
        res++;
      }
    }
    return res;
  }

  public static boolean hasExtensionValue(StructureDefinition src, String url, String value) {
    for (Extension ext : src.getExtension()) {
      if (url.equals(ext.getUrl()) && ext.hasValue() && value.equals(ext.getValue().primitiveValue())) {
        return true;
      }
    }
    return false;
  }


  private static Extension setExtensionE(Element context, String url, DataType value) {
    for (Extension ext : context.getExtension()) {
      if (ext.getUrl().equals(url)) {
        return ext.setValue(value);
      }
    }
    return context.addExtension().setUrl(url).setValue(value);
  }

  private static Extension setExtensionBE(BackboneElement context, boolean mod, String url, DataType value) {
    if (mod) {
      for (Extension ext : context.getModifierExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);
        }
      }
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }

  private static Extension setExtensionBT(BackboneType context, boolean mod, String url, DataType value) {
    if (mod) {
      for (Extension ext : context.getModifierExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);
        }
      }
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }

  private static Extension setExtensionR(DomainResource context, boolean mod, String url, DataType value) {
    if (mod) {
      for (Extension ext : context.getModifierExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);
        }
      }
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      for (Extension ext : context.getExtension()) {
        if (ext.getUrl().equals(url)) {
          return ext.setValue(value);
        }
      }
      return context.addExtension().setUrl(url).setValue(value);
    }
  }

  public static Extension setExtension(Base context, String url, DataType value) {
    boolean mod = ExtensionUtilities.isModifier(url);
    if (context instanceof BackboneElement) {
      return setExtensionBE((BackboneElement) context, mod, url, value);
    } else if (mod && context instanceof BackboneType) {
      return setExtensionBT((BackboneType) context, mod, url, value);
    } else if (context instanceof Element) {
      if (mod) {
        throw new FHIRException("Can't use a modifier extension on "+context.getClass().getName());
      } else {
        return setExtensionE((Element) context, url, value);
      }
    } else if (context instanceof DomainResource) {
      return setExtensionR((DomainResource) context, mod, url, value);
    } else {
      throw new FHIRException("Can't use an extension on "+context.getClass().getName());
    }
  }


  private static Extension addExtensionE(Element context, String url, DataType value) {
    return context.addExtension().setValue(value);
  }

  private static Extension addExtensionBE(BackboneElement context, boolean mod, String url, DataType value) {
    if (mod) {
      return context.addModifierExtension().setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }

  private static Extension addExtensionBT(BackboneType context, boolean mod, String url, DataType value) {
    if (mod) {
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return setExtensionE(context, url, value);
    }
  }

  private static Extension addExtensionR(DomainResource context, boolean mod, String url, DataType value) {
    if (mod) {
      return context.addModifierExtension().setUrl(url).setValue(value);
    } else {
      return context.addExtension().setUrl(url).setValue(value);
    }
  }

  public static Extension addExtension(Base context, String url, DataType value) {
    boolean mod = ExtensionUtilities.isModifier(url);
    if (context instanceof BackboneElement) {
      return addExtensionBE((BackboneElement) context, mod, url, value);
    } else if (mod && context instanceof BackboneType) {
      return addExtensionBT((BackboneType) context, mod, url, value);
    } else if (context instanceof Element) {
      if (mod) {
        throw new FHIRException("Can't use a modifier extension on "+context.getClass().getName());
      } else {
        return addExtensionE((Element) context, url, value);
      }
    } else if (context instanceof DomainResource) {
      return addExtensionR((DomainResource) context, mod, url, value);
    } else {
      throw new FHIRException("Can't use an extension on "+context.getClass().getName());
    }
  }

  private static List<Extension> getAllExtensions(Base context, String url) {
    List<Extension> list = new ArrayList<>();
    boolean mod = ExtensionUtilities.isModifier(url);
    if (mod) {
      if (context instanceof BackboneElement) {
        list.addAll(((BackboneElement) context).getModifierExtension());
      }
      if (context instanceof BackboneType) {
        list.addAll(((BackboneElement) context).getModifierExtension());
      }
      if (context instanceof DomainResource) {
        list.addAll(((DomainResource) context).getModifierExtension());
      }
    } else {
      if (context instanceof Element) {
        list.addAll(((Element) context).getExtension());
      }
      if (context instanceof DomainResource) {
        list.addAll(((DomainResource) context).getExtension());
      }
    }
    return list;
  }

  public static <T extends DataType> T getExtension(Class<T> class_, Base context, String url) {
    boolean found = false;
    T result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValue() && class_.isInstance(ext.getValue())) {
          found = true;
          result = (T) ext.getValue();
        }
      }
    }
    return result;
  }

  public static <T extends DataType> List<T> getExtensionList(Class<T> class_, Base context, String url) {
    List<T> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValue() && class_.isInstance(ext.getValue())) {
          result.add((T) ext.getValue());
        }
      }
    }
    return result;
  }

  public static String getExtensionString(Base context, String url) {
    boolean found = false;
    String result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValue() && ext.getValue().isPrimitive()) {
          found = true;
          result = ext.getValue().primitiveValue();
        }
      }
    }
    return result;
  }

  public static Boolean getExtensionBoolean(Base context, String url) {
    boolean found = false;
    Boolean result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValueBooleanType()) {
          found = true;
          result = ext.getValueBooleanType().getValue();
        }
      }
    }
    return result;
  }

  public static Integer getExtensionInt(Base context, String url) {
    boolean found = false;
    Integer result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValueIntegerType()) {
          found = true;
          result = ext.getValueIntegerType().getValue();
        }
      }
    }
    return result;
  }

  public static BigDecimal getExtensionFloat(Base context, String url) {
    boolean found = false;
    BigDecimal result = null;
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (found) {
          throw new FHIRException("Multiple Extensions for "+url);
        } else if (ext.hasValueIntegerType()) {
          found = true;
          result = ext.getValueDecimalType().getValue();
        }
      }
    }
    return result;
  }

  public static List<String> getExtensionStringList(Base context, String url) {
    List<String> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValue() && ext.getValue().isPrimitive()) {
          result.add(ext.getValue().primitiveValue());
        }
      }
    }
    return result;
  }

  public static List<Boolean> getExtensionBooleanList(Base context, String url) {
    List<Boolean> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValue() && ext.getValue().isPrimitive()) {
          result.add(Boolean.valueOf(ext.getValue().primitiveValue()));
        }
      }
    }
    return result;
  }

  public static List<Integer> getExtensionIntList(Base context, String url) {
    List<Integer> result = new ArrayList<>();
    for (Extension ext : getAllExtensions(context, url)) {
      if (ext.hasUrl() && ext.getUrl().equals(url)) {
        if (ext.hasValueIntegerType()) {
          result.add(ext.getValueIntegerType().getValue());
        }
      }
    }
    return result;
  }

  public static boolean stripExtensions(Element element, String... exceptions) {
    return stripExtensions(element, Utilities.strings(exceptions));
  }

  public static boolean stripExtensions(Element element, List<String> exceptions) {
    boolean res = element.getExtension().removeIf(ex -> !exceptions.contains(ex.getUrl()));
    if (element instanceof BackboneElement) {
      res = ((BackboneElement) element).getModifierExtension().removeIf(ex -> !exceptions.contains(ex.getUrl())) || res;
    }
    if (element instanceof BackboneElement) {
      res = ((BackboneElement) element).getModifierExtension().removeIf(ex -> !exceptions.contains(ex.getUrl())) || res;
    }
    for (Property p : element.children()) {
      for (Base v : p.getValues()) {
        if (v instanceof Element) {
          res = stripExtensions((Element) v, exceptions) || res;
        } else if (v instanceof Element) {
          res = stripExtensions((Resource) v, exceptions) || res;
        }
      }
    }
    return res;
  }

  public static boolean stripExtensions(Resource resource, String... exceptions) {
    return stripExtensions(resource, Utilities.strings(exceptions));
  }

  public static boolean stripExtensions(Resource resource, List<String> exceptions) {
    boolean res = false;
    if (resource instanceof DomainResource) {
      res = ((DomainResource) resource).getExtension().removeIf(ex -> !exceptions.contains(ex.getUrl())) ||
        ((DomainResource) resource).getModifierExtension().removeIf(ex -> !exceptions.contains(ex.getUrl()));
    }
    for (Property p : resource.children()) {
      for (Base v : p.getValues()) {
        if (v instanceof Element) {
          res = stripExtensions((Element) v, exceptions) || res;
        } else if (v instanceof Element) {
          res = stripExtensions((Resource) v, exceptions) || res;
        }
      }
    }
    return res;
  }

  public static void copyExtensions(List<Extension> source, List<Extension> dest, String... urls) {
    if (source != null && dest != null) {
      for (Extension ex : source) {
        if (Utilities.existsInList(ex.getUrl(), urls)) {
          dest.add(ex.copy());
        }
      }
    }
  }



  public static DataType getExtensionValue(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return ex.getValue();
      }
    }
    return null;
  }


  public static String getExtensionString(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return ex.getValue().primitiveValue();
      }
    }
    return null;
  }



  public static Integer getExtensionInteger(List<Extension> extensions, String url) {
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url) && ex.hasValueIntegerType()) {
        return ex.getValueIntegerType().getValue();
      }
    }
    return null;
  }

  public static boolean hasExtension(List<Extension> extensions, String url) {
    if (extensions == null) {
      return false;
    }
    for (Extension ex : extensions) {
      if (ex.getUrl().equals(url)) {
        return true;
      }
    }
    return false;
  }


  public static boolean isModifier(String url) {
    return Utilities.existsInList(url, "http://hl7.org/fhir/StructureDefinition/artifact-status", "http://hl7.org/fhir/StructureDefinition/capabilitystatement-prohibited", "http://hl7.org/fhir/StructureDefinition/request-doNotPerform");
  }

}
