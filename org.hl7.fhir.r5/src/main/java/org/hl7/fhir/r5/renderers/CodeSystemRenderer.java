package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.MultiLanguagePolicy;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.CodeSystemNavigator;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.LoincLinker;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class CodeSystemRenderer extends TerminologyRenderer {


  public CodeSystemRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {   
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (CodeSystem) r.getBase());
      render(status, x, (CodeSystem) r.getBase(), r);      
    } else {
      // the intention is to change this in the future
      x.para().tx("CodeSystemRenderer only renders native resources directly");
    }
  }

  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  
  public class Translateable {

    private String lang;
    private StringType value;

    public Translateable(String lang, StringType value) {
      this.lang = lang;
      this.value = value;
    }

    public String getLang() {
      return lang;
    }

    public StringType getValue() {
      return value;
    }

  }

  private Boolean doMarkdown = null;  
  
  public void render(RenderingStatus status, XhtmlNode x, CodeSystem cs, ResourceWrapper res) throws FHIRFormatError, DefinitionException, IOException {
    
    if (context.isShowSummaryTable()) {
      XhtmlNode h = x.h2();
      h.addText(cs.hasTitle() ? cs.getTitle() : cs.getName());
      addMarkdown(x, cs.getDescription());
      if (cs.hasCopyright())
        generateCopyright(x, res);
    }

    boolean props = generateProperties(x, cs);
    generateFilters(x, cs);
    List<UsedConceptMap> maps = new ArrayList<UsedConceptMap>();
    generateCodeSystemContent(status, x, cs, maps, props);
  }

  public void describe(XhtmlNode x, CodeSystem cs) {
    x.tx(display(cs));
  }

  public String display(CodeSystem cs) {
    return cs.present();
  }
  
  private void generateFilters(XhtmlNode x, CodeSystem cs) {
    if (cs.hasFilter()) {
      x.para().b().tx(formatPhrase(RenderingContext.CODESYSTEM_FILTERS));
      XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = tbl.tr();
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_CODE));
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_DESC));
      tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_FILTER_OP));
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_VALUE));
      for (CodeSystemFilterComponent f : cs.getFilter()) {
        tr = tbl.tr();
        renderStatus(f, tr.td()).tx(f.getCode());
        renderStatus(f.getDescriptionElement(), tr.td()).tx(f.getDescription());
        XhtmlNode td = tr.td();
        for (Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> t : f.getOperator())
          renderStatus(t, td).tx(t.asStringValue()+" ");
        renderStatus(f.getValueElement(), tr.td()).tx(f.getValue());
      }
    }
  }

  private boolean generateProperties(XhtmlNode x, CodeSystem cs) {
    if (cs.hasProperty()) {
      boolean hasRendered = false;
      boolean hasURI = false;
      boolean hasDescription = false;
      boolean hasValueSet = false;
      for (PropertyComponent p : cs.getProperty()) {
        hasRendered = hasRendered || getDisplayForProperty(p) != null;
        hasURI = hasURI || p.hasUri();
        hasDescription = hasDescription || p.hasDescription();
        hasValueSet = hasValueSet || p.hasExtension(ExtensionDefinitions.EXT_PROPERTY_VALUESET);
      }
      
      x.para().b().tx(formatPhrase(RenderingContext.GENERAL_PROPS));
      x.para().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROPS_DESC));
      XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = tbl.tr();
      if (hasRendered) {
        tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_NAME));        
      }
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_CODE));
      if (hasURI) {
        tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_URI));
      }
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_TYPE));
      if (hasDescription) {
        tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_DESC));
      }
      if (hasValueSet) {
        tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_VALUESET));
      }
      for (PropertyComponent p : cs.getProperty()) {
        tr = tbl.tr();
        if (hasRendered) {
          tr.td().tx(getDisplayForProperty(p));          
        }
        renderStatus(p, tr.td()).tx(p.getCode());
        if (hasURI) {
          renderStatus(p.getUriElement(), tr.td()).tx(p.getUri());
        }
        renderStatus(p.getTypeElement(), tr.td()).tx(p.hasType() ? p.getType().toCode() : "");
        if (hasDescription) {
          renderStatus(p.getDescriptionElement(), tr.td()).tx(p.getDescription());
        }
        if (hasValueSet) {
          XhtmlNode td = tr.td();
          String url = p.getExtensionString(ExtensionDefinitions.EXT_PROPERTY_VALUESET);
          if (url != null) {
            ValueSet vs = context.getContext().fetchResource(ValueSet.class, url);
            if (vs == null) {
              td.code().tx(url);
            } else {
              td.ah(vs.getWebPath()).tx(vs.present());
            }
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }

  private String sentenceForContent(CodeSystemContentMode mode, CodeSystem cs) {
    if (mode == null) {
      return formatPhrase(RenderingContext.CODESYSTEM_CONTENT_NOTPRESENT);
    }
    switch (mode) {
    case COMPLETE: return formatPhrase(RenderingContext.CODESYSTEM_CONTENT_COMPLETE);
    case EXAMPLE: return formatPhrase(RenderingContext.CODESYSTEM_CONTENT_EXAMPLE);
    case FRAGMENT: return formatPhrase(RenderingContext.CODESYSTEM_CONTENT_FRAGMENT);
    case NOTPRESENT: return formatPhrase(RenderingContext.CODESYSTEM_CONTENT_NOTPRESENT);
    case SUPPLEMENT:
      boolean properties = CodeSystemUtilities.hasProperties(cs);
      boolean designations = CodeSystemUtilities.hasDesignations(cs); 
      String features;
      if (properties && designations) {
        features = (context.formatPhrase(RenderingContext.CODE_SYS_DISP_PROP));
      } else if (properties) {
        features = (context.formatPhrase(RenderingContext.CODE_SYS_PROP));
      } else if (designations) {
        features = (context.formatPhrase(RenderingContext.CODE_SYS_DISP));
      } else {
        features = (context.formatPhrase(RenderingContext.CODE_SYS_FEAT)); // ?
      }
      return formatPhrase(RenderingContext.CODESYSTEM_CONTENT_SUPPLEMENT, features);
    default:
      throw new FHIRException(context.formatPhrase(RenderingContext.CODE_SYS_UNKN_MODE));
    }
  }
  
  private void generateCodeSystemContent(RenderingStatus status, XhtmlNode x, CodeSystem cs, List<UsedConceptMap> maps, boolean props) throws FHIRFormatError, DefinitionException, IOException {
    if (props) {
      x.para().b().tx(formatPhrase(RenderingContext.CODESYSTEM_CONCEPTS));
    }
    XhtmlNode p = x.para();
    
    p.startScript("csc");
    renderStatus(cs.getUrlElement(), p.param("cs")).code().tx(cs.getUrl());
    makeCasedParam(p.param("cased"), cs, cs.getCaseSensitiveElement());
    makeHierarchyParam(p.param("h"), cs, cs.getHierarchyMeaningElement());
    p.paramValue("code-count", CodeSystemUtilities.countCodes(cs));
    p.execScript(sentenceForContent(cs.getContent(), cs));
    p.closeScript();
    
    if (cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
      return;
    }
    
    XhtmlNode t = x.table( "codes", false).markGenerated(!context.forValidResource());
    boolean definitions = false;
    boolean commentS = false;
    boolean deprecated = false;
    boolean display = false;
    boolean hierarchy = false;
    boolean version = false;
    boolean ignoreStatus = false;
    boolean isSupplement = cs.getContent() == CodeSystemContentMode.SUPPLEMENT;
    List<PropertyComponent> properties = new ArrayList<>();
    boolean isManual = false;
    for (PropertyComponent cp : cs.getProperty()) {
      if (cp.hasExtension(ExtensionDefinitions.EXT_DISPLAY_HINT)) {
        isManual = true;
      }
    }
    for (PropertyComponent cp : cs.getProperty()) {
      if (showPropertyInTable(cp, isManual)) {
        boolean exists = false;
        for (ConceptDefinitionComponent c : cs.getConcept()) {
          exists = exists || conceptsHaveProperty(c, cp);
        }
        if (exists) {
          properties.add(cp);
          if ("status".equals(cp.getCode())) {
            ignoreStatus = true;
          }
        }
      }
    }
    List<String> langs = new ArrayList<>();
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      commentS = commentS || conceptsHaveComments(cs, c);
      deprecated = deprecated || conceptsHaveDeprecated(cs, c, ignoreStatus);
      display = display || conceptsHaveDisplay(c);
      version = version || conceptsHaveVersion(c);
      hierarchy = hierarchy || c.hasConcept();
      definitions = definitions || conceptsHaveDefinition(c);
      listConceptLanguages(cs, c, langs);
    }
    CodeSystemNavigator csNav = new CodeSystemNavigator(cs);
    hierarchy = hierarchy || csNav.isRestructure();
    
    if (langs.size() < 2) {
      addCopyColumn(addMapHeaders(addTableHeaderRowStandard(t, hierarchy, display, definitions, commentS, version, deprecated, properties, langs, null, true), maps));
    } else {
      addCopyColumn(addMapHeaders(addTableHeaderRowStandard(t, hierarchy, display, definitions, commentS, version, deprecated, properties, null, null, false), maps));      
    }
    for (ConceptDefinitionComponent c : csNav.getConcepts(null)) {
      addDefineRowToTable(status, t, c, 0, hierarchy, display, definitions, commentS, version, deprecated, maps, cs.getUrl(), cs, properties, csNav, langs.size() < 2 ? langs : null, isSupplement);
    }
    if (langs.size() >= 2) {
      Collections.sort(langs);
      x.para().b().tx(context.formatPhrase(RenderingContext.GENERAL_ADD_LANG));
      t = x.table("codes", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = t.tr();
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
      for (String lang : langs)
        tr.td().b().addText(describeLang(lang));
      for (ConceptDefinitionComponent c : cs.getConcept()) {
        addLanguageRow(c, t, langs);
      }
    }
  }

  private void makeHierarchyParam(XhtmlNode x, CodeSystem cs, Enumeration<CodeSystemHierarchyMeaning> hm) {
    if (hm.hasValue()) {
      String s = hm.getValue().getDisplay();
      renderStatus(hm, x).tx(" "+context.formatPhrase(RenderingContext.CODE_SYS_IN_A_HIERARCHY, s));
    } else if (VersionComparisonAnnotation.hasDeleted(cs, "hierarchyMeaning")) {
      makeHierarchyParam(x, null, (Enumeration<CodeSystemHierarchyMeaning>) VersionComparisonAnnotation.getDeleted(cs, "hierarchyMeaning").get(0));
    } else if (CodeSystemUtilities.hasHierarchy(cs)) {
      x.tx(" "+ (context.formatPhrase(RenderingContext.CODE_SYS_UNDEF_HIER)));
    } else {
      x.tx("");
    }
  }

  private void makeCasedParam(XhtmlNode x, CodeSystem cs, BooleanType caseSensitiveElement) {
    if (caseSensitiveElement.hasValue()) {
      String s = caseSensitiveElement.getValue() == true? "case-sensitive" : "case-insensitive";
      renderStatus(caseSensitiveElement, x).tx(s);
    } else if (VersionComparisonAnnotation.hasDeleted(cs, "caseSensitive")) {
      makeCasedParam(x, null, (BooleanType) VersionComparisonAnnotation.getDeleted(cs, "caseSensitive").get(0));
    } else {
      x.tx("");
    }
  }

  private void listConceptLanguages(CodeSystem cs, ConceptDefinitionComponent c, List<String> langs) {
    for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
      if (cd.hasLanguage() && !langs.contains(cd.getLanguage()) && (!cs.hasLanguage() || !cs.getLanguage().equals(cd.getLanguage()))) {
        langs.add(cd.getLanguage());
      }
    }

    for (ConceptDefinitionComponent g : c.getConcept()) {
      listConceptLanguages(cs, g, langs);
    }
  }

  private void addCopyColumn(XhtmlNode tr) {
    if (context.isCopyButton()) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.CODE_SYS_COPY));
    }
    
  }

  private boolean conceptsHaveDefinition(ConceptDefinitionComponent c) {
    if (c.hasDefinition()) {
      return true;
    }
    for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) { 
      if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "definition") && cd.hasLanguage() && !c.getDefinition().equalsIgnoreCase(cd.getValue())) {
        return true;
      }
    }
    for (ConceptDefinitionComponent g : c.getConcept()) {
      if (conceptsHaveDefinition(g)) {
        return true;
      }
    }
    return false;
  }

  private boolean conceptsHaveProperty(ConceptDefinitionComponent c, PropertyComponent cp) {
    if (CodeSystemUtilities.hasProperty(c, cp.getCode()))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept())
      if (conceptsHaveProperty(g,  cp))
        return true;
    return false;

  }

  private boolean showPropertyInTable(PropertyComponent cp, boolean isManual) {
    if (!isManual) {
      return cp.hasCode();
    } else if (cp.hasExtension(ExtensionDefinitions.EXT_DISPLAY_HINT)) {
      return Utilities.existsInList(cp.getExtensionString(ExtensionDefinitions.EXT_DISPLAY_HINT), "display", "no-link");
    } else {
      return false;
    }
  }

  private int countConcepts(List<ConceptDefinitionComponent> list) {
    int count = list.size();
    for (ConceptDefinitionComponent c : list)
      if (c.hasConcept())
        count = count + countConcepts(c.getConcept());
    return count;
  }
  
  private boolean conceptsHaveComments(CodeSystem cs, ConceptDefinitionComponent c) {
    if (CodeSystemUtilities.hasCSComments(cs, c))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept())
      if (conceptsHaveComments(cs, g))
        return true;
    return false;
  }

  private boolean conceptsHaveDisplay(ConceptDefinitionComponent c) {
    if (c.hasDisplay() && !c.getDisplay().equals(c.getCode()))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept())
      if (conceptsHaveDisplay(g))
        return true;
    return false;
  }

  private boolean conceptsHaveVersion(ConceptDefinitionComponent c) {
    if (c.hasUserData(UserDataNames.tx_cs_version_notes))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept())
      if (conceptsHaveVersion(g))
        return true;
    return false;
  }

  private boolean conceptsHaveDeprecated(CodeSystem cs, ConceptDefinitionComponent c, boolean ignoreStatus) {
    if (CodeSystemUtilities.isDeprecated(cs, c, ignoreStatus))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept())
      if (conceptsHaveDeprecated(cs, g, ignoreStatus))
        return true;
    return false;
  }



  private void addDefineRowToTable(RenderingStatus status, XhtmlNode t, ConceptDefinitionComponent c, int level, boolean hasHierarchy, boolean hasDisplay, boolean hasDefinitions, boolean comment, boolean version, boolean deprecated, List<UsedConceptMap> maps, String system, CodeSystem cs, List<PropertyComponent> properties, CodeSystemNavigator csNav, List<String> langs, boolean isSupplement) throws FHIRFormatError, DefinitionException, IOException {
    boolean hasExtensions = false;
    XhtmlNode tr = t.tr();
    boolean notCurrent = CodeSystemUtilities.isNotCurrent(cs, c);
    if (notCurrent) {
      tr.setAttribute("style", "background-color: #ffeeee");
    }
    
    XhtmlNode td = renderStatusRow(c, t, tr);
    if (hasHierarchy) {
      td.addText(Integer.toString(level+1));
      td = tr.td();
      String s = Utilities.padLeft("", '\u00A0', level*2);
      td.addText(s);
    }
    String link = isSupplement ? getLinkForCode(cs.getSupplements(), null, c.getCode(), cs) : null;
    if (link != null) {
      td.ah(context.prefixLocalHref(link)).style( "white-space:nowrap").addText(c.getCode());
    } else {
      td.style("white-space:nowrap").addText(c.getCode());
    }      
    XhtmlNode a;
    if (c.hasCodeElement()) {
      td.an(context.prefixAnchor(cs.getId()+"-" + Utilities.nmtokenize(c.getCode())));
    }

    if (hasDisplay) {
      td = tr.td();
      hasExtensions = renderDisplayName(c, cs, td, langs) || hasExtensions;
    } 
    if (hasDefinitions) {
      td = tr.td();
      if (c != null &&c.hasDefinitionElement()) {
        // translations of the definition might come from either the translation extension, or from the designations
        StringType defn = context.getTranslatedElement(c.getDefinitionElement());
        boolean sl = false;
        for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) { 
          if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "definition") && cd.hasLanguage() && !c.getDefinition().equalsIgnoreCase(cd.getValue())) { 
            sl = true;
          }
        }

        if (getContext().getMultiLanguagePolicy() == MultiLanguagePolicy.NONE || !(sl || ExtensionUtilities.hasLanguageTranslations(defn))) {
          if (hasMarkdownInDefinitions(cs)) {
            addMarkdown(renderStatusDiv(defn, td), defn.asStringValue());
          } else {
            renderStatus(defn, td).addText(defn.asStringValue());
          }
        } else {
          List<Translateable> list = new ArrayList<>();
          list.add(new Translateable(cs.getLanguage(), defn));
          for (Extension ext : defn.getExtensionsByUrl(ExtensionDefinitions.EXT_TRANSLATION)) {
            hasExtensions = true;
            list.add(new Translateable(ext.getExtensionString("lang"), ext.getExtensionByUrl("content").getValueStringType()));
          }
          for (ConceptDefinitionDesignationComponent cd : c.getDesignation())  {
            if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "definition") && cd.hasLanguage() && !c.getDefinition().equalsIgnoreCase(cd.getValue())) {
              list.add(new Translateable(cd.getLanguage(), cd.getValueElement()));
            }
          }
          boolean first = true;
          for (Translateable ti : list) {
            if (first) {
              first = false;
            } else {
              td.br();
            }

            if (ti.lang != null) {
              td.addText(ti.lang + ": ");
            }
            if (hasMarkdownInDefinitions(cs)) {
              addMarkdown(renderStatusDiv(ti.getValue(), td), ti.getValue().asStringValue());
            } else {
              renderStatus(ti.getValue(), td).addText(ti.getValue().asStringValue());
            }
          }
        }
      }
    }
    if (deprecated) {
      td = tr.td();
      Boolean b = CodeSystemUtilities.isDeprecated(cs, c, false);
      if (b !=  null && b) {
        td.addTextWithLineBreaks(formatPhrase(RenderingContext.CODESYSTEM_DEPRECATED));
        hasExtensions = true;
        if (ExtensionUtilities.hasExtension(c, ExtensionDefinitions.EXT_REPLACED_BY)) {
          Coding cc = (Coding) ExtensionUtilities.getExtension(c, ExtensionDefinitions.EXT_REPLACED_BY).getValue();
          td.tx(" "+ context.formatPhrase(RenderingContext.CODE_SYS_REPLACED_BY) + " ");
          String url = getCodingReference(cc, system);
          if (url != null) {
            td.ah(context.prefixLocalHref(url)).addText(cc.getCode());
            td.tx(": "+cc.getDisplay()+")");
          } else
            td.addText(cc.getCode()+" '"+cc.getDisplay()+"' in "+cc.getSystem()+")");
        } else {
          Extension ext = c.getExtensionByUrl(ExtensionDefinitions.EXT_STANDARDS_STATUS);
          if (ext != null) {
            ext = ext.getValue().getExtensionByUrl(ExtensionDefinitions.EXT_STANDARDS_STATUS_REASON);
            if (ext != null) {
              addMarkdown(td, ext.getValue().primitiveValue());
            }
          }
        }
      }
    }
    if (comment) {
      td = tr.td();
      Extension ext = c.getExtensionByUrl(ExtensionDefinitions.EXT_CS_COMMENT);
      if (ext != null &&  ext.hasValue() && ext.getValue().primitiveValue() != null) {
        hasExtensions = true;
        StringType defn = context.getTranslatedElement((PrimitiveType<?>) ext.getValue());
        if (getContext().getMultiLanguagePolicy() == MultiLanguagePolicy.NONE ||!(ExtensionUtilities.hasLanguageTranslations(ext.getValue()))) {
          td.addText(defn.asStringValue());
        } else {
          List<Translateable> list = new ArrayList<>();
          list.add(new Translateable(cs.getLanguage(), defn));
          for (Extension ex : defn.getExtensionsByUrl(ExtensionDefinitions.EXT_TRANSLATION)) {
            hasExtensions = true;
            list.add(new Translateable(ex.getExtensionString("lang"), ex.getExtensionByUrl("content").getValueStringType()));
          }
          boolean first = true;
          for (Translateable ti : list) {
            if (first) {
              first = false;
            } else {
              td.br();
            }

            if (ti.lang != null) {
              td.addText(ti.lang + ": ");
            }
            renderStatus(ti.getValue(), td).addText(ti.getValue().asStringValue());
          }
        }
      }      
    }
    if (version) {
      td = tr.td();
      if (c.hasUserData(UserDataNames.tx_cs_version_notes)) { // todo: this is never set
        td.addText(c.getUserString(UserDataNames.tx_cs_version_notes));
      }
    }

    if (properties != null) {
      for (PropertyComponent pc : properties) {
        td = tr.td();
        boolean first = true;
        boolean nolink = !Utilities.existsInList(pc.getExtensionString(ExtensionDefinitions.EXT_DISPLAY_HINT), "no-link");
        List<ConceptPropertyComponent> pcvl = CodeSystemUtilities.getPropertyValues(c, pc.getCode());
        for (ConceptPropertyComponent pcv : pcvl) {
          if (pcv.hasValue()) {
            if (first) first = false; else td.addText(", ");
            if (pcv.hasValueCoding()) { 
              td.addText(pcv.getValueCoding().getCode());
            } else {
              String pv = pcv.getValue().primitiveValue();
              if (pcv.hasValueStringType() && Utilities.isAbsoluteUrl(pv)) {
                if (nolink) {
                  td.code(pv);
                } else {
                  CanonicalResource cr = (CanonicalResource) context.getContext().fetchResource(Resource.class, pv);
                  if (cr != null) {
                    if (cr.hasWebPath()) {
                      td.ah(context.prefixLocalHref(cr.getWebPath()), cr.getVersionedUrl()).tx(cr.present());
                    } else {
                      td.ah(cr.getVersionedUrl(), cr.getVersionedUrl()).tx(cr.present());
                    }
                  } else if (Utilities.isAbsoluteUrlLinkable(pv) && !isInKnownUrlSpace(pv)) {
                    td.ah(context.prefixLocalHref(pv)).tx(pv);
                  } else {
                    td.code(pv);
                  }
                }
              } else if ("parent".equals(pcv.getCode()) && !nolink) {
                td.ah(context.prefixLocalHref("#"+cs.getId()+"-"+Utilities.nmtokenize(pv))).addText(pv);
              } else {
                td.addText(pv);
              }
            }
          }
        }
      }
    }
    
    if (langs != null) {
      for (String lang : langs) {
        td = tr.td().tx(getDisplay(lang, c));
      }
    }
    for (UsedConceptMap m : maps) {
      td = tr.td();
      List<TargetElementComponentWrapper> mappings = findMappingsForCode(c.getCode(), m.getMap());
      boolean first = true;
      for (TargetElementComponentWrapper mapping : mappings) {
        if (!first)
            td.br();
        first = false;
        XhtmlNode span = td.span(null, mapping.comp.hasRelationship() ?  mapping.comp.getRelationship().toCode() : "");
        span.addText(getCharForRelationship(mapping.comp));
        a = td.ah(context.prefixLocalHref(getContext().getLink(KnownLinkType.SPEC, true)+m.getLink()+"#"+makeAnchor(mapping.group.getTarget(), mapping.comp.getCode())));
        a.addText(mapping.comp.getCode());
        if (!Utilities.noString(mapping.comp.getComment()))
          td.i().tx("("+mapping.comp.getComment()+")");
      }
    }
    List<ConceptDefinitionComponent> ocl = csNav.getOtherChildren(c);
    for (ConceptDefinitionComponent cc : csNav.getConcepts(c)) {
       addDefineRowToTable(status, t, cc, level+1, hasHierarchy, hasDisplay, hasDefinitions, comment, version, deprecated, maps, system, cs, properties, csNav, langs, isSupplement);
    }
    for (ConceptDefinitionComponent cc : ocl) {
      tr = t.tr();
      td = tr.td();
      td.addText(Integer.toString(level+2));
      td = tr.td();
      String s = Utilities.padLeft("", '\u00A0', (level+1)*2);
      td.addText(s);
      td.style("white-space:nowrap");
      a = td.ah(context.prefixLocalHref("#"+cs.getId()+"-" + Utilities.nmtokenize(cc.getCode())));
      a.addText(cc.getCode());
      if (hasDisplay) {
        td = tr.td();
        hasExtensions = renderDisplayName(cc, cs, td, langs) || hasExtensions;
      }
      int w = 1 + (deprecated ? 1 : 0) + (comment ? 1 : 0) + (version ? 1 : 0) + maps.size();
      if (properties != null) {
        w = w + properties.size();
      }
      td = tr.td().colspan(Integer.toString(w));
    }
    if (context.isCopyButton()) {
      td = tr.td();
      clipboard(td, "icon_clipboard_x.png", "XML", "<system value=\""+Utilities.escapeXml(cs.getUrl())+"\">\n"+(cs.getVersionNeeded() ? "<version value=\""+Utilities.escapeXml(cs.getVersion())+"\">\n" : "")+"<code value=\""+Utilities.escapeXml(c.getCode())+"\">\n<display value=\""+Utilities.escapeXml(c.getDisplay())+"\">\n");
      td.nbsp();
      clipboard(td, "icon_clipboard_j.png", "JSON", "\"system\" : \""+Utilities.escapeXml(cs.getUrl())+"\",\n"+(cs.getVersionNeeded() ? "\"version\" : \""+Utilities.escapeXml(cs.getVersion())+"\",\n" : "")+"\"code\" : \""+Utilities.escapeXml(c.getCode())+"\",\n\"display\" : \""+Utilities.escapeXml(c.getDisplay())+"\"\n");
    }
  }


  private String getDisplay(String lang, ConceptDefinitionComponent c) {
    for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
      if ((cd.getUse().is("http://terminology.hl7.org/CodeSystem/hl7TermMaintInfra", "preferredForLanguage") || cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display"))
          && cd.hasLanguage() && cd.getLanguage().equals(lang)) {
        return cd.getValue();
      }
    }
    for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
      if (cd.hasLanguage() && cd.getLanguage().equals(lang)) {
        return cd.getValue();
      }
    }
    return null;
  }

  private boolean hasMarkdownInDefinitions(CodeSystem cs) {
    if (doMarkdown == null) {
      if (cs.hasUserData(UserDataNames.CS_MARKDOWN_FLAG)) {
        doMarkdown = (Boolean) cs.getUserData(UserDataNames.CS_MARKDOWN_FLAG);
      } else {
      if (cs.hasExtension("http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown")) {
        doMarkdown  = ExtensionUtilities.readBoolExtension(cs, "http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown");
      } else {
        doMarkdown = CodeSystemUtilities.hasMarkdownInDefinitions(cs, context.getMarkdown());
      }
        cs.setUserData(UserDataNames.CS_MARKDOWN_FLAG, doMarkdown);
      }
    }
    return doMarkdown;
  }


  public boolean renderDisplayName(ConceptDefinitionComponent c, CodeSystem cs, XhtmlNode td, List<String> langs) {
    boolean hasExtensions = false;
    if (c.hasDisplayElement()) {
      StringType disp = c.getDisplayElement();
      List<Translateable> list = new ArrayList<>();
      list.add(new Translateable(cs.getLanguage(), disp));
      for (Extension ext : disp.getExtensionsByUrl(ExtensionDefinitions.EXT_TRANSLATION)) {
        if (!langs.contains(ext.getExtensionString("lang"))) {
          hasExtensions = true;
          list.add(new Translateable(ext.getExtensionString("lang"), ext.getExtensionByUrl("content").getValueStringType()));
        }
      }
      for (ConceptDefinitionDesignationComponent cd : c.getDesignation())  {
        if (cd.hasLanguage() && (langs == null || !langs.contains(cd.getLanguage())) && (c.getDefinition() == null || !c.getDefinition().equalsIgnoreCase(cd.getValue()))) {
          list.add(new Translateable(cd.getLanguage(), cd.getValueElement()));
        }
      }

      if (getContext().getMultiLanguagePolicy() == MultiLanguagePolicy.NONE || list.size() <= 1) {
        renderStatus(disp, td).addText(disp.asStringValue());
      } else {
        boolean first = true;
        for (Translateable ti : list) {
          if (first) {
            first = false;
          } else {
            td.br();
          }

          if (ti.lang != null) {
            td.addText(ti.lang + ": ");
          }
          renderStatus(ti.getValue(), td).addText(ti.getValue().asStringValue());
        }      

      }
    }
    return hasExtensions;
  }

  private String getCodingReference(Coding cc, String system) {
    if (cc.getSystem().equals(system))
      return "#"+cc.getCode();
    if (cc.getSystem().equals("http://snomed.info/sct"))
      return "http://snomed.info/sct/"+cc.getCode();
    if (cc.getSystem().equals("http://loinc.org"))
      return LoincLinker.getLinkForCode(cc.getCode());
    return null;
  }


  private void addLanguageRow(ConceptDefinitionComponent c, XhtmlNode t, List<String> langs) {
    XhtmlNode tr = t.tr();
    tr.td().addText(c.getCode());
    for (String lang : langs) {
      ConceptDefinitionDesignationComponent d = null;
      for (ConceptDefinitionDesignationComponent designation : c.getDesignation()) {
        if (designation.hasLanguage()) {
          if (lang.equals(designation.getLanguage()))
            d = designation;
        }
      }
      tr.td().addText(d == null ? "" : d.getValue());
    }
  }
 

  @Override
  protected void genSummaryTableContent(RenderingStatus status, XhtmlNode tbl, CanonicalResource cr) throws IOException {
    super.genSummaryTableContent(status, tbl, cr);

    CodeSystem cs = (CodeSystem) cr;
    XhtmlNode tr;
    if (cs.hasContent()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_CONTENT)+":");
      XhtmlNode td = tr.td();
      td.tx((cs.getContent().getDisplay())+": "+describeContent(cs.getContent(), cs));
      if (cs.getContent() == CodeSystemContentMode.SUPPLEMENT) {
        td.tx(" ");
        CodeSystem tgt = context.getContext().fetchCodeSystem(cs.getSupplements());
        if (tgt != null) {
          td.ah(tgt.getWebPath()).tx(tgt.present());
        } else {
          td.code().tx(cs.getSupplements());
        }            
      }
    }
    
    if (CodeSystemUtilities.hasOID(cs)) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_OID)+":");
      tr.td().tx(context.formatPhrase(RenderingContext.CODE_SYS_FOR_OID, CodeSystemUtilities.getOID(cs)));
    }

    if (cs.hasValueSet()) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_VALUESET)+":");
      ValueSet vs = context.getContext().findTxResource(ValueSet.class, cs.getValueSet());
      if (vs == null) {
        tr.td().tx(context.formatPhrase(RenderingContext.CODE_SYS_THE_VALUE_SET, cs.getValueSet())+")");
      } else {
        tr.td().ah(vs.getWebPath()).tx(context.formatPhrase(RenderingContext.CODE_SYS_THE_VALUE_SET, cs.getValueSet())+")");
      }
    }
  }

  private String describeContent(CodeSystemContentMode content, CodeSystem cs) {
    switch (content) {
    case COMPLETE: return (context.formatPhrase(RenderingContext.CODE_SYS_COMPLETE));
    case NOTPRESENT: return (context.formatPhrase(RenderingContext.CODE_SYS_NOTPRESENT));
    case EXAMPLE: return (context.formatPhrase(RenderingContext.CODE_SYS_EXAMPLE));
    case FRAGMENT: return (context.formatPhrase(RenderingContext.CODE_SYS_FRAGMENT));
    case SUPPLEMENT: return (context.formatPhrase(RenderingContext.CODE_SYS_SUPPLEMENT));
    default:
      return "?? illegal content status value "+(content == null ? "(null)" : content.toCode());
    }
  }


}