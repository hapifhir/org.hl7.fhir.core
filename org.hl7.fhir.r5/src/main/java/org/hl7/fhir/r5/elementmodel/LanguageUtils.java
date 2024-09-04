package org.hl7.fhir.r5.elementmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.cd;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader;
import org.hl7.fhir.utilities.i18n.AcceptLanguageHeader.LanguagePreference;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.LanguageProducerLanguageSession;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TextUnit;
import org.hl7.fhir.utilities.i18n.LanguageFileProducer.TranslationUnit;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

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
public class LanguageUtils {

  public static final List<String> TRANSLATION_SUPPLEMENT_RESOURCE_TYPES = Arrays.asList("CodeSystem", "StructureDefinition", "Questionnaire");

  private static final String ORPHAN_TRANSLATIONS_NAME = "translations.orphans";

  private static final String SUPPLEMENT_SOURCE_RESOURCE = "translations.supplemented";
  private static final String SUPPLEMENT_SOURCE_TRANSLATIONS = "translations.source-list";
  
  IWorkerContext context;
  private List<String> crlist;
  
  
  public LanguageUtils(IWorkerContext context) {
    super();
    this.context = context;
  }

  public void generateTranslations(Element resource, LanguageProducerLanguageSession session) {
    translate(null, resource, session);
  }
  
  
  private void translate(Element parent, Element element, LanguageProducerLanguageSession langSession) {
    if (element.isPrimitive() && isTranslatable(element)) {
      String base = element.primitiveValue();
      if (base != null) {
        String translation = getSpecialTranslation(parent, element, langSession.getTargetLang());
        if (translation == null) {
          translation = element.getTranslation(langSession.getTargetLang());
        }
        langSession.entry(new TextUnit(pathForElement(element), contextForElement(element), base, translation));
      }
    }
    for (Element c: element.getChildren()) {
      if (!c.getName().equals("designation")) {
        translate(element, c, langSession);
      }
    }
  }

  private String contextForElement(Element element) {
    throw new Error("Not done yet");
  }

  private String getSpecialTranslation(Element parent, Element element, String targetLang) {
    if (parent == null) {
      return null;
    }
    if (Utilities.existsInList(pathForElement(parent), "CodeSystem.concept", "CodeSystem.concept.concept") && "CodeSystem.concept.display".equals(pathForElement(element))) {
      return getDesignationTranslation(parent, targetLang);
    }
    if (Utilities.existsInList(pathForElement(parent), "ValueSet.compose.include.concept") && "ValueSet.compose.include.concept.display".equals(pathForElement(element))) {
      return getDesignationTranslation(parent, targetLang);
    }
    if (Utilities.existsInList(pathForElement(parent), "ValueSet.expansion.contains", "ValueSet.expansion.contains.contains") && "ValueSet.expansion.contains.display".equals(pathForElement(element))) {
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

  private String pathForElement(Element element) {
    String bp = element.getBasePath();
    return pathForElement(bp, element.getProperty().getStructure().getType());
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
    return importFromTranslations(null, resource, translations, new HashSet<>());
  }
  
  public int importFromTranslations(Element resource, List<TranslationUnit> translations, List<ValidationMessage> messages) {
    Set<TranslationUnit> usedUnits = new HashSet<>();
    int r = 0;
    if (resource.fhirType().equals("StructureDefinition")) {
      r = importFromTranslationsForSD(null, resource, translations, usedUnits);
    } else {
     r = importFromTranslations(null, resource, translations, usedUnits);
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
    r = r + checkForTranslations(translations, usedUnits, resource, "name", "name");
    r = r + checkForTranslations(translations, usedUnits, resource, "title", "title");
    r = r + checkForTranslations(translations, usedUnits, resource, "publisher", "publisher");
    for (Element cd : resource.getChildrenByName("contact")) {
      r = r + checkForTranslations(translations, usedUnits, cd, "contact.name", "name");
    }
    r = r + checkForTranslations(translations, usedUnits, resource, "purpose", "purpose");
    r = r + checkForTranslations(translations, usedUnits, resource, "copyright", "copyright");
    Element diff = resource.getNamedChild("differential");
    if (diff != null) {
      for (Element ed : diff.getChildrenByName("element")) {
        String id = ed.getNamedChildValue("id");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/label", "label");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/short", "short");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/definition", "definition");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/comment", "comment");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/requirements", "requirements");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/meaningWhenMissing", "meaningWhenMissing");
        r = r + checkForTranslations(translations, usedUnits, ed, id+"/orderMeaning", "orderMeaning");
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
            ToolingExtensions.setLanguageTranslation(e, translation.getLanguage(), translation.getTgtText());
            usedUnits.add(translation);
          }
        }
      }
    }
    for (Property c : element.children()) {
      for (Base v : c.getValues()) {
        if (!c.getName().equals("designation")) {
          t = t + importResourceFromTranslations(element, v, translations, usedUnits, path+"."+c.getName());
        }
      }
    }
    return t;
  }

  private boolean handleAsSpecial(Base parent, Base element, TranslationUnit translation) {
    return false;
  }

  private boolean isTranslatable(Base element, String path) {
    return Utilities.existsInList(element.fhirType(), "string", "markdown");
  }

  private int importFromTranslations(Element parent, Element element, List<TranslationUnit> translations, Set<TranslationUnit> usedUnits) {
    int t = 0;
    if (element.isPrimitive() && isTranslatable(element)) {
      String base = element.primitiveValue();
      if (base != null) {
        String path = pathForElement(element);
        Set<TranslationUnit> tlist = findTranslations(path, base, translations);
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
        t = t + importFromTranslations(element, c, translations, usedUnits);
      }
    }
    return t;
  }

  private boolean handleAsSpecial(Element parent, Element element, TranslationUnit translation) {
    if (parent == null) {
      return false;
    }
    if (Utilities.existsInList(pathForElement(parent), "CodeSystem.concept", "CodeSystem.concept.concept") && "CodeSystem.concept.display".equals(pathForElement(element))) {
      return setDesignationTranslation(parent, translation.getLanguage(), translation.getTgtText());
    }
    if (Utilities.existsInList(pathForElement(parent), "ValueSet.compose.include.concept") && "ValueSet.compose.include.concept.display".equals(pathForElement(element))) {
      return setDesignationTranslation(parent, translation.getLanguage(), translation.getTgtText());
    }
    if (Utilities.existsInList(pathForElement(parent), "ValueSet.expansion.contains", "ValueSet.expansion.contains.contains") && "ValueSet.expansion.contains.display".equals(pathForElement(element))) {
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
    return dstLang == null || srcLang == null ? false : dstLang.startsWith(srcLang) || "*".equals(srcLang);
  }

  public void fillSupplement(CodeSystem csSrc, CodeSystem csDst, List<TranslationUnit> list) {
    csDst.setUserData(SUPPLEMENT_SOURCE_RESOURCE, csSrc);
    csDst.setUserData(SUPPLEMENT_SOURCE_TRANSLATIONS, list);
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
    List<TranslationUnit> list = (List<TranslationUnit>) cs.getUserData(ORPHAN_TRANSLATIONS_NAME);
    if (list == null) {
      list = new ArrayList<>();
      cs.setUserData(ORPHAN_TRANSLATIONS_NAME, list);
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
    return (resource instanceof CodeSystem && resource.hasUserData(SUPPLEMENT_SOURCE_RESOURCE)) || (resource instanceof StructureDefinition);
  }

  public boolean handlesAsElement(Element element) {
    return true; // for now...
  }

  public List<TranslationUnit> generateTranslations(Resource res, String lang) {
    List<TranslationUnit> list = new ArrayList<>();
    if (res instanceof StructureDefinition) {
      StructureDefinition sd = (StructureDefinition) res;
      generateTranslations(list, sd, lang);
      if (res.hasUserData(ORPHAN_TRANSLATIONS_NAME)) {
        List<TranslationUnit> orphans = (List<TranslationUnit>) res.getUserData(ORPHAN_TRANSLATIONS_NAME);
        for (TranslationUnit t : orphans) {
          list.add(new TranslationUnit(lang, "!!"+t.getId(), t.getContext1(), t.getSrcText(), t.getTgtText()));
        }
      }
    } else {
      CodeSystem cs = (CodeSystem) res.getUserData(SUPPLEMENT_SOURCE_RESOURCE);
      List<TranslationUnit> inputs = res.hasUserData(SUPPLEMENT_SOURCE_TRANSLATIONS) ? (List<TranslationUnit>) res.getUserData(SUPPLEMENT_SOURCE_TRANSLATIONS) : new ArrayList<>();
      for (ConceptDefinitionComponent cd : cs.getConcept()) {
        generateTranslations(list, cd, lang, inputs);
      }
      if (cs.hasUserData(ORPHAN_TRANSLATIONS_NAME)) {
        List<TranslationUnit> orphans = (List<TranslationUnit>) cs.getUserData(ORPHAN_TRANSLATIONS_NAME);
        for (TranslationUnit t : orphans) {
          list.add(new TranslationUnit(lang, "!!"+t.getId(), t.getContext1(), t.getSrcText(), t.getTgtText()));
        }
      }
    }
    return list;
  }

  private void generateTranslations(List<TranslationUnit> list, StructureDefinition sd, String lang) {
    addToList(list, lang, sd, "name", "name", sd.getNameElement());
    addToList(list, lang, sd, "title", "title", sd.getTitleElement());
    addToList(list, lang, sd, "publisher", "publisher", sd.getPublisherElement());
    for (ContactDetail cd : sd.getContact()) {
      addToList(list, lang, cd, "contact.name", "name", cd.getNameElement());
    }
    addToList(list, lang, sd, "purpose", "purpose", sd.getPurposeElement());
    addToList(list, lang, sd, "copyright", "copyright", sd.getCopyrightElement());
    for (ElementDefinition ed : sd.getDifferential().getElement()) {
      addToList(list, lang, ed, ed.getId()+"/label", "label", ed.getLabelElement());
      addToList(list, lang, ed, ed.getId()+"/short", "short", ed.getShortElement());
      addToList(list, lang, ed, ed.getId()+"/definition", "definition", ed.getDefinitionElement());
      addToList(list, lang, ed, ed.getId()+"/comment", "comment", ed.getCommentElement());
      addToList(list, lang, ed, ed.getId()+"/requirements", "requirements", ed.getRequirementsElement());
      addToList(list, lang, ed, ed.getId()+"/meaningWhenMissing", "meaningWhenMissing", ed.getMeaningWhenMissingElement());
      addToList(list, lang, ed, ed.getId()+"/orderMeaning", "orderMeaning", ed.getOrderMeaningElement());
      for (ElementDefinitionConstraintComponent con : ed.getConstraint()) {
        addToList(list, lang, con, ed.getId()+"/constraint", "human", con.getHumanElement());
      }
      if (ed.hasBinding()) {
        addToList(list, lang, ed.getBinding(), ed.getId()+"/b/desc", "description", ed.getBinding().getDescriptionElement());
        for (ElementDefinitionBindingAdditionalComponent ab : ed.getBinding().getAdditional()) {
          addToList(list, lang, ab, ed.getId()+"/ab/doco", "documentation", ab.getDocumentationElement());
          addToList(list, lang, ab, ed.getId()+"/ab/short", "shortDoco", ab.getShortDocoElement());
        }
      }
    }
  }

  private void addToList(List<TranslationUnit> list, String lang, Base ctxt, String name, String propName, DataType value) {
    if (value != null && value.hasPrimitiveValue()) {
      list.add(new TranslationUnit(lang, name, ctxt.getNamedProperty(propName).getDefinition(), value.primitiveValue(), value.getTranslation(lang)));
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
    // not sure what to do with context?
    if (existing == null) {
      list.add(new TranslationUnit(lang, id, null, srcText, null));
    } else if (srcText.equals(existing.getSrcText())) {
      list.add(new TranslationUnit(lang, id, null, srcText, existing.getTgtText()));
    } else {
      list.add(new TranslationUnit(lang, id, null, srcText, "!!"+existing.getTgtText()).setOriginal(existing.getSrcText()));
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
    List<TranslationUnit> list = new ArrayList<>();
    generateTranslations(e, lang, list);
    return list;
  }

  private void generateTranslations(Element e, String lang, List<TranslationUnit> list) {
    if (e.getProperty().isTranslatable()) {
      String id = pathForElement(e); // .getProperty().getDefinition().getPath();
      String context = e.getProperty().getDefinition().getDefinition();
      String src = e.primitiveValue();
      String tgt = getTranslation(e, lang);
      list.add(new TranslationUnit(lang, id, context, src, tgt));
    }
    if (e.hasChildren()) {
      for (Element c : e.getChildren()) {
        generateTranslations(c, lang, list);
      }
    }
    
  }

  private String getTranslation(Element e, String lang) {
    if (!e.hasChildren()) {
      return null;
    }
    for (Element ext : e.getChildren()) {
      if ("Extension".equals(ext.fhirType()) && "http://hl7.org/fhir/StructureDefinition/translation".equals(ext.getNamedChildValue("url"))) {
        String l = null;
        String v = null;
        for (Element subExt : ext.getChildren()) {
          if ("Extension".equals(subExt.fhirType()) && "lang".equals(subExt.getNamedChildValue("url"))) {
            l = subExt.getNamedChildValue("value");
          }
          if ("Extension".equals(subExt.fhirType()) && "content".equals(subExt.getNamedChildValue("url"))) {
            v = subExt.getNamedChildValue("value");
          }
        }
        if (lang.equals(l)) {
          return v;
        }
      }
    }
    return null;
  }
 
  public boolean switchLanguage(Element e, String lang) {
    if (e.getProperty().isTranslatable()) {
      String cnt = getTranslation(e, lang);
      e.removeExtension(ToolingExtensions.EXT_TRANSLATION);
      if (cnt != null) {
        e.setValue(cnt);
      }
    }
    if (e.hasChildren()) {
      for (Element c : e.getChildren()) {
        if (!switchLanguage(c, lang)) {
          return false;
        }
      }
    }
    return true;
  }
}
