package org.hl7.fhir.r5.elementmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguagePreference;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TextUnit;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * in here:
 *   * generateTranslations
 *   * importFromTranslations
 *   * stripTranslations
 *   * switchLanguage
 *   
 *  in the validator
 *  
 * @author grahamegrieve
 *  generateTranslations = -langTransform export -src {src} -tgt {tgt} -dest {dest}
 *  importFromTranslations =  -langTransform import -src {src} -tgt {tgt} -dest {dest}
 */
@MarkedToMoveToAdjunctPackage
@Slf4j
public class LanguageUtils {
  
  public static final List<String> TRANSLATION_SUPPLEMENT_RESOURCE_TYPES = Arrays.asList("CodeSystem", "StructureDefinition", "Questionnaire");

  public static class TranslationUnitCollection {
    List<TranslationUnit> list= new ArrayList<>();
    Map<String, TranslationUnit> map = new HashMap<>();
    public void add(TranslationUnit tu) {
      String key = tu.getId()+"||"+tu.getSrcText();
      if (!map.containsKey(key)) {
        map.put(key, tu);
        list.add(tu);
      }
      
    }
  }
  IWorkerContext context;
  private List<String> crlist;
  @Getter @Setter private boolean keepTranslationsWhenTranslating;
  
  
  public LanguageUtils(IWorkerContext context) {
    super();
    this.context = context;
  }

  public void generateTranslations(Element resource, LanguageProducerLanguageSession session) {
    translate(null, resource, session, resource.fhirType());
  }
  
  
  private void translate(Element parent, Element element, LanguageProducerLanguageSession langSession, String path) {
    String npath = pathForElement(path, element);
    if (element.isPrimitive() && isTranslatable(element)) {
      String base = element.primitiveValue();
      if (base != null) {
        String translation = getSpecialTranslation(path, parent, element, langSession.getTargetLang());
        if (translation == null) {
          translation = element.getTranslation(langSession.getTargetLang());
        }
        langSession.entry(new TextUnit(npath, contextForElement(element), base, translation));
      }
    }
    for (Element c: element.getChildren()) {
      if (!c.getName().equals("designation")) {
        translate(element, c, langSession, npath);
      }
    }
  }

  private String contextForElement(Element element) {
    throw new Error("Not done yet");
  }

  private String getSpecialTranslation(String path, Element parent, Element element, String targetLang) {
    if (parent == null) {
      return null;
    }
    String npath = parent.getBasePath();
    if (Utilities.existsInList(npath, "CodeSystem.concept", "CodeSystem.concept.concept") && "CodeSystem.concept.display".equals(element.getBasePath())) {
      return getDesignationTranslation(parent, targetLang);
    }
    if (Utilities.existsInList(npath, "ValueSet.compose.include.concept") && "ValueSet.compose.include.concept.display".equals(element.getBasePath())) {
      return getDesignationTranslation(parent, targetLang);
    }
    if (Utilities.existsInList(npath, "ValueSet.expansion.contains", "ValueSet.expansion.contains.contains") && "ValueSet.expansion.contains.display".equals(element.getBasePath())) {
      return getDesignationTranslation(parent, targetLang);
    }
    return null;
  }

  private String getDesignationTranslation(Element parent, String targetLang) {
    for (Element e : parent.getChildren("designation")) {
      String lang = e.getNamedChildValue("language");
      if (langsMatch(targetLang, lang)) {
        return e.getNamedChildValue("value");
      }
    }
    return null;
  }

  private boolean isTranslatable(Element element) {    
    return element.getProperty().isTranslatable();
  }

  private String pathForElement(String path, Element element) {
    if (element.getSpecial() != null) {
      String bp = element.getBasePath();
      return pathForElement(bp, element.getProperty().getStructure().getType());
    } else {
      return (path == null ? element.getName() : path+"."+element.getName());
    }
  }
  
  private String pathForElement(String path, String type) {
    // special case support for metadata elements prior to R5:
    if (crlist == null) {
      crlist = new ContextUtilities(context).getCanonicalResourceNames();
    }
    if (crlist.contains(type)) {
      String fp = path.replace(type+".", "CanonicalResource.");
      if (Utilities.existsInList(fp,
         "CanonicalResource.url", "CanonicalResource.identifier", "CanonicalResource.version", "CanonicalResource.name", 
         "CanonicalResource.title", "CanonicalResource.status", "CanonicalResource.experimental", "CanonicalResource.date",
         "CanonicalResource.publisher", "CanonicalResource.contact", "CanonicalResource.description", "CanonicalResource.useContext", 
         "CanonicalResource.jurisdiction"))  {
        return fp;
      }
    }
    return path; 
  }
  
  
  public int importFromTranslations(Element resource, List<TranslationUnit> translations) {
    return importFromTranslations(resource.fhirType(), null, resource, translations, new HashSet<>());
  }
  
  public int importFromTranslations(Element resource, List<TranslationUnit> translations, List<ValidationMessage> messages) {
    Set<TranslationUnit> usedUnits = new HashSet<>();
    int r = 0;
    if (resource.fhirType().equals("StructureDefinition")) {
      r = importFromTranslationsForSD(null, resource, translations, usedUnits);
    } else {
     r = importFromTranslations(null, null, resource, translations, usedUnits);
    }
    for (TranslationUnit t : translations) {
      if (!usedUnits.contains(t)) {
        if (messages != null) {
          messages.add(new ValidationMessage(Source.Publisher, IssueType.INFORMATIONAL, t.getId(), "Unused '"+t.getLanguage()+"' translation '"+t.getSrcText()+"' -> '"+t.getTgtText()+"'", IssueSeverity.INFORMATION));
        }
      }
    }
    return r;
  }
  
  public int importFromTranslations(Resource resource, List<TranslationUnit> translations, List<ValidationMessage> messages) {
    Set<TranslationUnit> usedUnits = new HashSet<>();
    int r = 0;
    if (resource.fhirType().equals("StructureDefinition")) {
      // todo... r = importFromTranslationsForSD(null, resource, translations, usedUnits);
    } else {
     r = importResourceFromTranslations(null, resource, translations, usedUnits, resource.fhirType());
    }
    for (TranslationUnit t : translations) {
      if (!usedUnits.contains(t)) {
        if (messages != null) {
          messages.add(new ValidationMessage(Source.Publisher, IssueType.INFORMATIONAL, t.getId(), "Unused '"+t.getLanguage()+"' translation '"+t.getSrcText()+"' -> '"+t.getTgtText()+"'", IssueSeverity.INFORMATION));
        }
      }
    }
    return r;
  }
  

  /*
   * */
  private int importFromTranslationsForSD(Object object, Element resource, List<TranslationUnit> translations, Set<TranslationUnit> usedUnits) {
    int r = 0;
    r = r + checkForTranslations(translations, usedUnits, resource, "StructureDefinition.name", "name");
    r = r + checkForTranslations(translations, usedUnits, resource, "StructureDefinition.title", "title");
    r = r + checkForTranslations(translations, usedUnits, resource, "StructureDefinition.publisher", "publisher");
    for (Element cd : resource.getChildrenByName("contact")) {
      r = r + checkForTranslations(translations, usedUnits, cd, "StructureDefinition.contact.name", "name");
    }
    r = r + checkForTranslations(translations, usedUnits, resource, "StructureDefinition.purpose", "purpose");
    r = r + checkForTranslations(translations, usedUnits, resource, "StructureDefinition.copyright", "copyright");
    for (Element map : resource.getChildrenByName("mapping")) {
      String identity = map.getNamedChildValue("identity");
      r = r + checkForTranslations(translations, usedUnits, map, "StructureDefinition.mapping."+identity+"/name", "name");
      r = r + checkForTranslations(translations, usedUnits, map, "StructureDefinition.mapping."+identity+"/comment", "comment");
    }
    Element diff = resource.getNamedChild("differential");
    if (diff != null) {
      for (Element ed : diff.getChildrenByName("element")) {
        String id = ed.getNamedChildValue("id");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/label", "label");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/short", "short");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/definition", "definition");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/comment", "comment");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/requirements", "requirements");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/meaningWhenMissing", "meaningWhenMissing");
        r = r + checkForTranslations(translations, usedUnits, ed, "StructureDefinition.element."+id+"/orderMeaning", "orderMeaning");
        for (Element map : ed.getChildrenByName("mapping")) {
          String identity = map.getNamedChildValue("identity");
          r = r + checkForTranslations(translations, usedUnits, map, "StructureDefinition.element."+id+"/mapping/"+identity+"/map", "map");
          r = r + checkForTranslations(translations, usedUnits, map, "StructureDefinition.element."+id+"/mapping/"+identity+"/comment", "comment");
        }
        //      for (ElementDefinitionConstraintComponent con : ed.getConstraint()) {
        //        addToList(list, lang, con, ed.getId()+"/constraint", "human", con.getHumanElement());
        //      }
        //      if (ed.hasBinding()) {
        //        addToList(list, lang, ed.getBinding(), ed.getId()+"/b/desc", "description", ed.getBinding().getDescriptionElement());
        //        for (ElementDefinitionBindingAdditionalComponent ab : ed.getBinding().getAdditional()) {
        //          addToList(list, lang, ab, ed.getId()+"/ab/doco", "documentation", ab.getDocumentationElement());
        //          addToList(list, lang, ab, ed.getId()+"/ab/short", "shortDoco", ab.getShortDocoElement());
        //        }
        //      }
      }
    }
    return r;
  }

  private int checkForTranslations(List<TranslationUnit> translations, Set<TranslationUnit> usedUnits, Element context, String tname, String pname) {
    int r = 0;
    Element child = context.getNamedChild(pname);
    if (child != null) {
      String v = child.primitiveValue();
      if (v != null) {
        for (TranslationUnit tu : translations) {
          if (tname.equals(tu.getId()) && v.equals(tu.getSrcText())) {
            usedUnits.add(tu);
            child.setTranslation(tu.getLanguage(), tu.getTgtText());
            r++;
          }
        }
      }
    }
    return r;
  }

  private int importResourceFromTranslations(Base parent, Base element, List<TranslationUnit> translations, Set<TranslationUnit> usedUnits, String path) {
    int t = 0;
    if (element.isPrimitive() && isTranslatable(element, path) && element instanceof org.hl7.fhir.r5.model.Element) {
      org.hl7.fhir.r5.model.Element e = (org.hl7.fhir.r5.model.Element) element;
      String base = element.primitiveValue();
      if (base != null) {
        String epath = pathForElement(path, element.fhirType());
        Set<TranslationUnit> tlist = findTranslations(epath, base, translations);
        for (TranslationUnit translation : tlist) {
          t++;
          if (!handleAsSpecial(parent, element, translation)) {
            usedUnits.add(translation);
            if (translation.getTgtText() != null) {
              ExtensionUtilities.setLanguageTranslation(e, translation.getLanguage(), translation.getTgtText());
            } else {
              log.warn("?");
            }
          }
        }
      }
    }
    for (Property c : element.children()) {
      for (Base v : c.getValues()) {
        if (!c.getName().equals("designation") && !isTranslation(v)) {
          t = t + importResourceFromTranslations(element, v, translations, usedUnits, genPath(c, v, path, c.getName()));
        }
      }
    }
    return t;
  }

  private String genPath(Property c, Base v, String path, String name) {
    // special cases: recursion
    if ("ImplementationGuide.definition.page".equals(path) && "page".equals(name)) {
      return path;
    }
    if ("ValueSet.expansion.contains".equals(path) && "contains".equals(name)) {
      return path;
    }
    if ("ValueSet.expansion.contains".equals(path) && "contains".equals(name)) {
      return path;
    }
    if (v.isResource() && !"contained".equals(name)) {
      return v.fhirType();
    } else {
      return path+"."+name;
    }
  }

  private boolean isTranslation(Base element) {
    return "Extension".equals(element.fhirType()) && element.getChildByName("url").hasValues()  && ExtensionDefinitions.EXT_TRANSLATION.equals(element.getChildByName("url").getValues().get(0).primitiveValue());
  }

  private boolean handleAsSpecial(Base parent, Base element, TranslationUnit translation) {
    return false;
  }

  private boolean isTranslatable(Base element, String path) {
    return (Utilities.existsInList(element.fhirType(), "string", "markdown") 
        || isTranslatable(path)) && !isExemptFromTranslations(path);
  }

  private int importFromTranslations(String path, Element parent, Element element, List<TranslationUnit> translations, Set<TranslationUnit> usedUnits) {
    String npath = pathForElement(path, element);
    int t = 0;
    if (element.isPrimitive() && isTranslatable(element) && !isExemptFromTranslations(npath)) {
      String base = element.primitiveValue();
      if (base != null) {
        Set<TranslationUnit> tlist = findTranslations(npath, base, translations);
        for (TranslationUnit translation : tlist) {
          t++;
          if (!handleAsSpecial(parent, element, translation)) {
            element.setTranslation(translation.getLanguage(), translation.getTgtText());
            usedUnits.add(translation);
          }
        }
      }
    }
    // Create a copy of the children collection before iterating
    List<Element> childrenCopy = List.copyOf(element.getChildren());
    for (Element c : childrenCopy) {
      if (!c.getName().equals("designation")) {
        t = t + importFromTranslations(npath, element, c, translations, usedUnits);
      }
    }
    return t;
  }

  private boolean handleAsSpecial(Element parent, Element element, TranslationUnit translation) {
    if (parent == null) {
      return false;
    }
    if (Utilities.existsInList(parent.getBasePath(), "CodeSystem.concept", "CodeSystem.concept.concept") && "CodeSystem.concept.display".equals(element.getBasePath())) {
      return setDesignationTranslation(parent, translation.getLanguage(), translation.getTgtText());
    }
    if (Utilities.existsInList(parent.getBasePath(), "ValueSet.compose.include.concept") && "ValueSet.compose.include.concept.display".equals(element.getBasePath())) {
      return setDesignationTranslation(parent, translation.getLanguage(), translation.getTgtText());
    }
    if (Utilities.existsInList(parent.getBasePath(), "ValueSet.expansion.contains", "ValueSet.expansion.contains.contains") && "ValueSet.expansion.contains.display".equals(element.getBasePath())) {
      return setDesignationTranslation(parent, translation.getLanguage(), translation.getTgtText());
    }
    return false;
  }

  private boolean setDesignationTranslation(Element parent, String targetLang, String translation) {
    for (Element e : parent.getChildren("designation")) {
      String lang = e.getNamedChildValue("language");
      if (langsMatch(targetLang, lang)) {
        Element value = e.getNamedChild("value");
        if (value != null) {
          value.setValue(translation);
        } else {
          e.addElement("value").setValue(translation);
        }
        return true;
      }
    }
    Element d = parent.addElement("designation");
    d.addElement("language").setValue(targetLang);
    d.addElement("value").setValue(translation);
    return true;
  }

  private Set<TranslationUnit> findTranslations(String path, String src, List<TranslationUnit> translations) {
    Set<TranslationUnit> res = new HashSet<>();
    for (TranslationUnit translation : translations) {
      if (path.equals(translation.getId()) && src.equals(translation.getSrcText())) {
        res.add(translation);
      }
    }
    return res;
  }

  public static boolean langsMatchExact(AcceptLanguageHeader langs, String srcLang) {
    if (langs == null) {
      return false;
    }
    for (LanguagePreference lang : langs.getLangs()) {
      if (lang.getValue() > 0) {
        if ("*".equals(lang.getLang())) {
          return true;
        } else {
          return langsMatch(lang.getLang(), srcLang);
        }
      }
    }
    return false;
  }

  public static boolean langsMatch(AcceptLanguageHeader langs, String srcLang) {
    if (langs == null) {
      return false;
    }
    for (LanguagePreference lang : langs.getLangs()) {
      if (lang.getValue() > 0) {
        if ("*".equals(lang.getLang())) {
          return true;
        } else {
          boolean ok = langsMatch(lang.getLang(), srcLang);
          if (ok) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean langsMatchExact(String dstLang, String srcLang) {
    return dstLang == null ? false : dstLang.equals(srcLang);
  }

  public static boolean langsMatch(String dstLang, String srcLang) {
    if (dstLang == null && srcLang == null) {
      return true;
    } if (dstLang == null) {
      return srcLang.equals("en") || srcLang.startsWith("en-");
    } else if (srcLang == null) {
      return dstLang.equals("en") || dstLang.startsWith("en-");
    } else {
      return dstLang.startsWith(srcLang) || "*".equals(srcLang);
    }
  }

  public void fillSupplement(CodeSystem csSrc, CodeSystem csDst, List<TranslationUnit> list) {
    csDst.setUserData(UserDataNames.LANGUTILS_SOURCE_SUPPLEMENT, csSrc);
    csDst.setUserData(UserDataNames.LANGUTILS_SOURCE_TRANSLATIONS, list);
    for (TranslationUnit tu : list) {
      String code = tu.getId();
      String subCode = null;
      if (code.contains("@")) {
        subCode = code.substring(code.indexOf("@")+1);
        code = code.substring(0, code.indexOf("@"));
      }
      ConceptDefinitionComponent cdSrc = CodeSystemUtilities.getCode(csSrc, tu.getId());
      if (cdSrc == null) {
        addOrphanTranslation(csSrc, tu);
      } else {
        ConceptDefinitionComponent cdDst = CodeSystemUtilities.getCode(csDst, cdSrc.getCode());
        if (cdDst == null) {
          cdDst = csDst.addConcept().setCode(cdSrc.getCode());
        }
        String tt = tu.getTgtText();
        if (tt.startsWith("!!")) {
          tt = tt.substring(3);
        }
        if (subCode == null) {
          cdDst.setDisplay(tt);
        } else if ("definition".equals(subCode)) {
          cdDst.setDefinition(tt);
        } else {
          boolean found = false;
          for (ConceptDefinitionDesignationComponent d : cdSrc.getDesignation()) {
            if (d.hasUse() && subCode.equals(d.getUse().getCode())) {
              found = true;
              cdDst.addDesignation().setUse(d.getUse()).setLanguage(tu.getLanguage()).setValue(tt); //.setUserData(SUPPLEMENT_SOURCE, tu);       
              break;
            }
          }
          if (!found) {
            for (Extension e : cdSrc.getExtension()) {
              if (subCode.equals(tail(e.getUrl()))) {
                found = true;
                cdDst.addExtension().setUrl(e.getUrl()).setValue(
                    e.getValue().fhirType().equals("markdown") ? new MarkdownType(tt) : new StringType(tt)); //.setUserData(SUPPLEMENT_SOURCE, tu);          
                break;
              }
            }
          }
          if (!found) {
            addOrphanTranslation(csSrc, tu);            
          }
        }
      }      
    }    
  }

  private String tail(String url) {
    return url.contains("/") ? url.substring(url.lastIndexOf("/")+1) : url;
  }

  private void addOrphanTranslation(CodeSystem cs, TranslationUnit tu) {
    List<TranslationUnit> list = (List<TranslationUnit>) cs.getUserData(UserDataNames.LANGUTILS_ORPHAN);
    if (list == null) {
      list = new ArrayList<>();
      cs.setUserData(UserDataNames.LANGUTILS_ORPHAN, list);
    }
    list.add(tu);
  }

  public String nameForLang(String lang) {
    // todo: replace with structures from loading languages properly
    switch (lang) {
    case "en" : return "English";
    case "de" : return "German";
    case "es" : return "Spanish";
    case "nl" : return "Dutch";
    }
    return Utilities.capitalize(lang);
  }

  public String titleForLang(String lang) {
    // todo: replace with structures from loading languages properly
    switch (lang) {
    case "en" : return "English";
    case "de" : return "German";
    case "es" : return "Spanish";
    case "nl" : return "Dutch";
    }
    return Utilities.capitalize(lang);
  }

  public boolean handlesAsResource(Resource resource) {
    return (resource instanceof CodeSystem && resource.hasUserData(UserDataNames.LANGUTILS_SOURCE_SUPPLEMENT)) || (resource instanceof StructureDefinition);
  }

  public boolean handlesAsElement(Element element) {
    return true; // for now...
  }

  public List<TranslationUnit> generateTranslations(Resource res, String lang) {
    List<TranslationUnit> list = new ArrayList<>();
    if (res instanceof StructureDefinition) {
      StructureDefinition sd = (StructureDefinition) res;
      generateTranslations(list, sd, lang);
      if (res.hasUserData(UserDataNames.LANGUTILS_ORPHAN)) {
        List<TranslationUnit> orphans = (List<TranslationUnit>) res.getUserData(UserDataNames.LANGUTILS_ORPHAN);
        for (TranslationUnit t : orphans) {
          if (!hasInList(list, t.getId(), t.getSrcText())) {
            list.add(new TranslationUnit(lang, "!!"+t.getId(), t.getContext(), t.getSrcText(), t.getTgtText()));
          }
        }
      }
    } else {
      CodeSystem cs = (CodeSystem) res.getUserData(UserDataNames.LANGUTILS_SOURCE_SUPPLEMENT);
      List<TranslationUnit> inputs = res.hasUserData(UserDataNames.LANGUTILS_SOURCE_TRANSLATIONS) ? (List<TranslationUnit>) res.getUserData(UserDataNames.LANGUTILS_SOURCE_TRANSLATIONS) : new ArrayList<>();
      for (ConceptDefinitionComponent cd : cs.getConcept()) {
        generateTranslations(list, cd, lang, inputs);
      }
      if (cs.hasUserData(UserDataNames.LANGUTILS_ORPHAN)) {
        List<TranslationUnit> orphans = (List<TranslationUnit>) cs.getUserData(UserDataNames.LANGUTILS_ORPHAN);
        for (TranslationUnit t : orphans) {
          if (!hasInList(list, t.getId(), t.getSrcText())) {
            list.add(new TranslationUnit(lang, "!!"+t.getId(), t.getContext(), t.getSrcText(), t.getTgtText()));
          }
        }
      }
    }
    return list;
  }

  private void generateTranslations(List<TranslationUnit> list, StructureDefinition sd, String lang) {
    addToList(list, lang, sd, "StructureDefinition.name", "name", sd.getNameElement());
    addToList(list, lang, sd, "StructureDefinition.title", "title", sd.getTitleElement());
    addToList(list, lang, sd, "StructureDefinition.publisher", "publisher", sd.getPublisherElement());
    for (ContactDetail cd : sd.getContact()) {
      addToList(list, lang, cd, "StructureDefinition.contact.name", "name", cd.getNameElement());
    }
    addToList(list, lang, sd, "StructureDefinition.purpose", "purpose", sd.getPurposeElement());
    addToList(list, lang, sd, "StructureDefinition.copyright", "copyright", sd.getCopyrightElement());
    for (StructureDefinitionMappingComponent map : sd.getMapping()) {
      addToList(list, lang, map, "StructureDefinition.mapping."+map.getIdentity()+"/name", "name", map.getNameElement());
      addToList(list, lang, map, "StructureDefinition.mapping."+map.getIdentity()+"/comment", "comment", map.getCommentElement());
    }
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/label", "label", ed.getLabelElement());
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/short", "short", ed.getShortElement());
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/definition", "definition", ed.getDefinitionElement());
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/comment", "comment", ed.getCommentElement());
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/requirements", "requirements", ed.getRequirementsElement());
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/meaningWhenMissing", "meaningWhenMissing", ed.getMeaningWhenMissingElement());
      addToList(list, lang, ed, "StructureDefinition.element."+ed.getId()+"/orderMeaning", "orderMeaning", ed.getOrderMeaningElement());
      for (ElementDefinitionConstraintComponent con : ed.getConstraint()) {
        addToList(list, lang, con, "StructureDefinition.element."+ed.getId()+"/constraint", "human", con.getHumanElement());
      }
      for (ElementDefinitionMappingComponent map : ed.getMapping()) {
        addToList(list, lang, map, "StructureDefinition.element."+ed.getId()+"/mapping/"+map.getIdentity()+"/map", "map", map.getMapElement());
        addToList(list, lang, map, "StructureDefinition.element."+ed.getId()+"/mapping/"+map.getIdentity()+"/comment", "comment", map.getCommentElement());
      }
      if (ed.hasBinding()) {
        addToList(list, lang, ed.getBinding(), "StructureDefinition.element."+ed.getId()+"/b/desc", "description", ed.getBinding().getDescriptionElement());
        for (ElementDefinitionBindingAdditionalComponent ab : ed.getBinding().getAdditional()) {
          addToList(list, lang, ab, "StructureDefinition.element."+ed.getId()+"/ab/doco", "documentation", ab.getDocumentationElement());
          addToList(list, lang, ab, "StructureDefinition.element."+ed.getId()+"/ab/short", "shortDoco", ab.getShortDocoElement());
        }
      }
    }
  }

  private void addToList(List<TranslationUnit> list, String lang, Base ctxt, String name, String propName, DataType value) {
    if (value != null && value.hasPrimitiveValue()) {
      if (!hasInList(list, name, value.primitiveValue())) {
        list.add(new TranslationUnit(lang, name, ctxt.getNamedProperty(propName).getDefinition(), value.primitiveValue(), value.getTranslation(lang)));
      }
    }
    
  }

  private void generateTranslations(List<TranslationUnit> list, ConceptDefinitionComponent cd, String lang, List<TranslationUnit> inputs) {
    // we generate translation units for the display, the definition, and any designations and extensions that we find
    // the id of the designation is the use.code (there will be a use) and for the extension, the tail of the extension URL 
    // todo: do we need to worry about name clashes? why would we, and more importantly, how would we solve that?

    addTranslationUnit(list, cd.getCode(), cd.getDisplay(), lang, inputs);
    if (cd.hasDefinition()) {
      addTranslationUnit(list, cd.getCode()+"@definition", cd.getDefinition(), lang, inputs);        
    }
    for (ConceptDefinitionDesignationComponent d : cd.getDesignation()) {
      addTranslationUnit(list, cd.getCode()+"@"+d.getUse().getCode(), d.getValue(), lang, inputs);              
    }
    for (Extension e : cd.getExtension()) {
      addTranslationUnit(list, cd.getCode()+"@"+tail(e.getUrl()), e.getValue().primitiveValue(), lang, inputs);                    
    }
  }

  private void addTranslationUnit(List<TranslationUnit> list, String id, String srcText, String lang, List<TranslationUnit> inputs) {
    TranslationUnit existing = null;
    for (TranslationUnit t : inputs) {
      if (id.equals(t.getId())) {
        existing = t;
        break;
      }
    }
    if (!hasInList(list, id, srcText)) {
      // not sure what to do with context?
      if (existing == null) {
        list.add(new TranslationUnit(lang, id, null, srcText, null));
      } else if (srcText.equals(existing.getSrcText())) {
        list.add(new TranslationUnit(lang, id, null, srcText, existing.getTgtText()));
      } else {
        list.add(new TranslationUnit(lang, id, null, srcText, "!!"+existing.getTgtText()).setOriginal(existing.getSrcText()));
      }
    }
  }
  
  private String getDefinition(ConceptDefinitionComponent cd) {
    ConceptPropertyComponent v = CodeSystemUtilities.getProperty(cd, "translation-context");
    if (v != null && v.hasValue()) {
      return v.getValue().primitiveValue();
    } else {
      return cd.getDefinition();
    }
  }

  public List<TranslationUnit> generateTranslations(Element e, String lang) {
    TranslationUnitCollection list = new TranslationUnitCollection();
    generateTranslations(e, lang, list, e.fhirType());
    return list.list;
  }

  private void generateTranslations(Element e, String lang, TranslationUnitCollection list, String path) {
    String npath = pathForElement(path, e);
    if ((e.getProperty().isTranslatable() || isTranslatable(e.getProperty().getDefinition().getBase().getPath())) 
        && !isExemptFromTranslations(e.getProperty().getDefinition().getBase().getPath())) {
      String id = e.getProperty().getDefinition().getBase().getPath(); // .getProperty().getDefinition().getPath();
      String context = e.getProperty().getDefinition().getDefinition();
      String src = e.primitiveValue();
      String tgt = getTranslation(e, lang);
      if (!hasInList(list.list, id, src)) {
        list.add(new TranslationUnit(lang, id, context, src, tgt));
      }
    }
    if (e.hasChildren()) {
      for (Element c : e.getChildren()) {
        generateTranslations(c, lang, list, npath);
      }
    }
  }

  private boolean hasInList(List<TranslationUnit> list, String id, String src) {
    for (TranslationUnit t : list) {
      if (t.getId() != null && t.getId().equals(id) && t.getSrcText()!= null && t.getSrcText().equals(src)) {
        return true;
      }
    }
    return false;
  }

  /**
   * override specifications
   * 
   * @param path
   * @return
   */
  private boolean isTranslatable(String path) {
    return Utilities.existsInList(path, "TestCases.publisher",
        "TestCases.contact.telecom.value",
        "TestCases.definition",
        "TestCases.parameter.name",
        "TestCases.parameter.description",
        "TestCases.scope.description ",
        "TestCases.dependency.description",
        "TestCases.mode.description",
        "TestCases.suite",
        "TestCases.suite.name",
        "TestCases.suite.description",
        "TestCases.suite.test",
        "TestCases.suite.test.name",
        "TestCases.suite.test.description",
        "TestCases.suite.test.assert.human",
        "ActorDefinition.title",
        "ActorDefinition.description",
        "ActorDefinition.purpose",
        "ActorDefinition.copyright",
        "ActorDefinition.copyrightLabel",
        "ActorDefinition.documentation",
        "Requirements.title",
        "Requirements.publisher",
        "Requirements.description",
        "Requirements.purpose",
        "Requirements.copyright",
        "Requirements.copyrightLabel",
        "Requirements.statement.label",
        "Requirements.statement.requirement");    
  }

  private boolean isExemptFromTranslations(String path) {
    if (path.endsWith(".reference")) {
      return true;
    }
    return Utilities.existsInList(path, 
        "ImplementationGuide.definition.parameter.value", "ImplementationGuide.dependsOn.version", "ImplementationGuide.dependsOn.id",
        "CanonicalResource.name", 
        "CapabilityStatement.rest.resource.searchRevInclude", "CapabilityStatement.rest.resource.searchInclude", "CapabilityStatement.rest.resource.searchParam.name",
        "SearchParameter.expression", "SearchParameter.xpath",
        "ExampleScenario.actor.actorId", "ExampleScenario.instance.resourceId", "ExampleScenario.instance.containedInstance.resourceId", "ExampleScenario.instance.version.versionId", 
          "ExampleScenario.process.step.operation.number", "ExampleScenario.process.step.operation.initiator", "ExampleScenario.process.step.operation.receiver",
        "ExampleScenario.process.step.operation.number", "ExampleScenario.process.step.operation.initiator", "ExampleScenario.process.step.operation.receiver",
        "OperationDefinition.parameter.max", "OperationDefinition.overload.parameterName",
        "StructureMap.group.rule.source.type", "StructureMap.group.rule.source.element", "StructureMap.group.rule.target.element");
  }

  private String getTranslation(Element e, String lang) {
    if (!e.hasChildren()) {
      return null;
    }
    for (Element ext : e.getChildren()) {
      if ("Extension".equals(ext.fhirType()) && "http://hl7.org/fhir/StructureDefinition/translation".equals(ext.getNamedChildValue("url"))) {
        String childLang = null;
        String childContent = null;
        for (Element subExt : ext.getChildren()) {
          if ("Extension".equals(subExt.fhirType()) && "lang".equals(subExt.getNamedChildValue("url"))) {
            childLang = subExt.getNamedChildValue("value");
          }
          if ("Extension".equals(subExt.fhirType()) && "content".equals(subExt.getNamedChildValue("url"))) {
            childContent = subExt.getNamedChildValue("value");
          }
        }
        if (lang.equals(childLang)) {
          return childContent;
        }
      }
    }
    return null;
  }

  private Element getTranslationExtension(Element e, String lang) {
    if (!e.hasChildren()) {
      return null;
    }
    for (Element ext : e.getChildren()) {
      if ("Extension".equals(ext.fhirType()) && "http://hl7.org/fhir/StructureDefinition/translation".equals(ext.getNamedChildValue("url"))) {
        String l = null;
        Element v = null;
        for (Element subExt : ext.getChildren()) {
          if ("Extension".equals(subExt.fhirType()) && "lang".equals(subExt.getNamedChildValue("url"))) {
            l = subExt.getNamedChildValue("value");
          }
          if ("Extension".equals(subExt.fhirType()) && "content".equals(subExt.getNamedChildValue("url"))) {
            v = subExt;
          }
        }
        if (lang.equals(l) && v != null) {
          return ext;
        }
      }
    }
    return null;
  }

  public boolean switchLanguage(Base r, String lang, boolean markLanguage, boolean contained, String resourceLang, String defaultLang, List<ValidationMessage> errors) {
    boolean changed = false;
    if (r.isPrimitive()) {
      PrimitiveType<?> dt = (PrimitiveType<?>) r;
      if (keepTranslationsWhenTranslating) {
        if (langsMatch(lang, resourceLang)) {
          // we don't do anything
        } else {
          Extension ext = ExtensionUtilities.getLanguageExtension(dt, lang);
          if (ext != null && ext.hasExtension("lang") && ext.hasExtension("content")) {
            ext.getExtensionByUrl("lang").setValue(new CodeType(resourceLang));
            String v = ext.getExtensionByUrl("content").primitiveValue();
            ext.getExtensionByUrl("content").setValue(new StringType(r.primitiveValue()));
            ((PrimitiveType<?>) r).setValueAsString(v);
          }
        }
      } else {
        String cnt = ExtensionUtilities.getLanguageTranslation(dt, lang);
        dt.removeExtension(ExtensionDefinitions.EXT_TRANSLATION);
        if (cnt != null) {
          dt.setValueAsString(cnt);
          changed = true;
        }
      }
    }

    if (r.fhirType().equals("Narrative")) {
      Base div = r.getChildValueByName("div");
      Base status = r.getChildValueByName("status");

      XhtmlNode xhtml = div.getXhtml();
      xhtml = adjustToLang(xhtml, lang, status == null ? null : status.primitiveValue(), resourceLang, defaultLang, errors);
      if (xhtml == null) {
        r.removeChild("div", div);
      } else {
        div.setXhtml(xhtml);
      }
    }
    for (Property p : r.children()) {
      for (Base c : p.getValues()) {
        changed = switchLanguage(c, lang, markLanguage, p.getName().equals("contained"), resourceLang, defaultLang, errors) || changed;
      }
    }
    if (markLanguage && r.isResource() && !contained) {
      Resource res = (Resource) r;
      res.setLanguage(lang);
      changed = true;
    }
    return changed;
  }
  
  public XhtmlNode divForLang(DomainResource r, String lang, String defaultLang, List<ValidationMessage> errors) {
    if (!r.hasText() || !r.getText().hasDiv())
      return null;
    else
      return divForLang(r.getText().getDiv(), lang, r.getLanguage(), defaultLang, errors);
  }
  
  public XhtmlNode divForLang(XhtmlNode xhtml, String lang, String resourceLang, String defaultLang, List<ValidationMessage> errors) {
    if (xhtml==null)
      return null;
   
    boolean foundLangDivs = false;
    for (XhtmlNode div : xhtml.getChildNodes()) {
      if ("div".equals(div.getName())) {
        String l = div.hasAttribute("lang") ? div.getAttribute("lang") : div.getAttribute("xml:lang");
        if (l!=null)
          foundLangDivs = true;
        if (lang.equals(l)) {
          return div;
        }       
      }
    }

    // If the base div declares a language that matches, then the whole div is the content 
    String l = xhtml.hasAttribute("lang") ? xhtml.getAttribute("lang") : xhtml.getAttribute("xml:lang");
    if (lang.equals(l)) {
      return xhtml;
    }
    
    // If there's no language declared at all, then the narrative is presumed to be the language the resource declares
    // (if there is one), or the default language for the IG if the resource doesn't have a language.
    if (!foundLangDivs && (resourceLang!=null ? lang.equals(resourceLang) : lang.equals(defaultLang))) {
      return xhtml;
    }
    
    // If we didn't find a div for the requested language, then we'll either use narrative div for the default language
    // (if it wasn't generated) or will leave the narrative as null, which will force it to be generated for this language
    if (!lang.equals(defaultLang)) {
      XhtmlNode defaultDiv = divForLang(xhtml, defaultLang, resourceLang, defaultLang, null);
      if (defaultDiv != null) {
        if (scanForGeneratedNarrative(defaultDiv, defaultLang)) {
          return null;
        }
      }
      
      if (errors != null)
        errors.add(new ValidationMessage(Source.Publisher, IssueType.BUSINESSRULE, "IG", context.formatMessage(I18nConstants.NARRATIVE_NOT_TRANSLATED, defaultLang, lang), IssueSeverity.WARNING));
      return defaultDiv;
    }
    
    return null;
  }
  
  public static boolean scanForGeneratedNarrative(XhtmlNode x, String lang) {
    RenderingI18nContext rc = new RenderingI18nContext();
    rc.setLocale(Locale.forLanguageTag(lang));
    return scanForGeneratedNarrative(x, lang, rc);
  }
    
  private static boolean scanForGeneratedNarrative(XhtmlNode x, String lang, RenderingI18nContext rc) {

    if (x.getContent() != null && x.getContent().contains( rc.formatPhrase(RenderingContext.PROF_DRIV_GEN_NARR_TECH, "", "").trim())) {
      return true;
    }
    for (XhtmlNode c : x.getChildNodes()) {
      if (scanForGeneratedNarrative(c, lang)) {
        return true;
      }
    }
    return false;
  }

  private XhtmlNode adjustToLang(XhtmlNode xhtml, String lang, String status, String resourceLang, String defaultLang, List<ValidationMessage> errors) {
    if (xhtml == null) {
      return null;
    }
    xhtml = divForLang(xhtml, lang, resourceLang, defaultLang, errors);
    
    if (xhtml!=null)
      return xhtml;
    
    // if the root language is null and the status is not additional
    // it can be regenerated
    if (Utilities.existsInList(status, "generated", "extensions")) {
      return null;
    }    
    // well, really, not much we can do...
    return xhtml;
  }

  public boolean switchLanguage(Element e, String lang, boolean markLanguage, String resourceLang, String defaultLang, List<ValidationMessage> errors) throws IOException {
    boolean changed = false;
    if (e.getProperty().isTranslatable()) {
      if (keepTranslationsWhenTranslating) {
        Element ext = getTranslationExtension(e, lang);
        if (ext != null && ext.hasExtension("lang") && ext.hasExtension("content")) {
          Element extLang = ext.getExtension("lang");
          Element extCont = ext.getExtension("content");
          extLang.getNamedChild("value").setValue(resourceLang);
          String v = extCont.getNamedChildValue("value");
          extCont.getNamedChild("value").setValue(e.getValue());
          e.setValue(v);
        }
      } else {
        String cnt = getTranslation(e, lang);
        e.removeExtension(ExtensionDefinitions.EXT_TRANSLATION);
        if (cnt != null) {
          e.setValue(cnt);
          changed = true;
        }
      }
    }
    if (e.fhirType().equals("Narrative") && e.hasChild("div")) {
      XhtmlNode xhtml = e.getNamedChild("div").getXhtml();
      xhtml = adjustToLang(xhtml, lang, e.getNamedChildValue("status"), resourceLang, defaultLang, errors);
      if (xhtml == null) {
        e.removeChild("div");
      } else {
        e.getNamedChild("div").setXhtml(xhtml);
      }
    }
    if (e.hasChildren()) {
      for (Element c : e.getChildren()) {
        changed = switchLanguage(c, lang, markLanguage, resourceLang, defaultLang, errors) || changed;
      }
    }
    if (markLanguage && e.isResource() && e.getSpecial() != SpecialElement.CONTAINED) {
      e.setChildValue("language", lang);
      changed = true;
    }
    return changed;
  }

  public boolean hasTranslation(org.hl7.fhir.r5.model.Element e, String lang) {
    return getTranslation(e, lang) != null;
  }

  public String getTranslation(org.hl7.fhir.r5.model.Element e, String lang) {
    for (Extension ext : e.getExtensionsByUrl(ExtensionDefinitions.EXT_TRANSLATION)) {
      String l = ext.getExtensionString("lang");
      String v =  ext.getExtensionString("content");
      if (langsMatch(l, lang) && v != null) {
        return v;
      }
    }
    return null;
  }

  public String getTranslationOrBase(PrimitiveType<?> e, String lang) {
    for (Extension ext : e.getExtensionsByUrl(ExtensionDefinitions.EXT_TRANSLATION)) {
      String l = ext.getExtensionString("lang");
      String v =  ext.getExtensionString("content");
      if (langsMatch(l, lang) && v != null) {
        return v;
      }
    }
    return e.primitiveValue();
  }

  public Element copyToLanguage(Element element, String lang, boolean markLanguage, String resourceLang, String defaultLang, List<ValidationMessage> errors) throws IOException {
    Element result = (Element) element.copy();
    switchLanguage(result, lang, markLanguage, resourceLang, defaultLang, errors);
    return result;
  }

  public Resource copyToLanguage(Resource res, String lang, boolean markLanguage, String defaultLang, List<ValidationMessage> errors) {
    if (res == null) {
      return null;
    }
    Resource r = res.copy();
    switchLanguage(r, lang, markLanguage, false, res.getLanguage(), defaultLang, errors);    
    return r;
  }
}
