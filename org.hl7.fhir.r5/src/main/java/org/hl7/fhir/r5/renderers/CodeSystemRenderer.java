package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.renderers.CodeSystemRenderer.Translateable;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.MultiLanguagePolicy;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.CodeSystemNavigator;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.LoincLinker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class CodeSystemRenderer extends TerminologyRenderer {

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

  public CodeSystemRenderer(RenderingContext context) {
    super(context);
  }

  public CodeSystemRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (CodeSystem) dr);
  }
  
  public boolean render(XhtmlNode x, CodeSystem cs) throws FHIRFormatError, DefinitionException, IOException {
    boolean hasExtensions = false;

    if (context.isHeader()) {
      XhtmlNode h = x.h2();
      h.addText(cs.hasTitle() ? cs.getTitle() : cs.getName());
      addMarkdown(x, cs.getDescription());
      if (cs.hasCopyright())
        generateCopyright(x, cs );
    }

    boolean props = generateProperties(x, cs);
    generateFilters(x, cs);
    List<UsedConceptMap> maps = new ArrayList<UsedConceptMap>();
    hasExtensions = generateCodeSystemContent(x, cs, hasExtensions, maps, props);

    return hasExtensions;
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
      XhtmlNode tbl = x.table("grid");
      XhtmlNode tr = tbl.tr();
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_CODE));
      tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_FILTER_DESC));
      tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_FILTER_OP));
      tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_FILTER_VALUE));
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
      for (PropertyComponent p : cs.getProperty()) {
        String display = getPropertyDisplay(p);
        hasRendered = hasRendered || display != null;
        hasURI = hasURI || p.hasUri();
        hasDescription = hasDescription || p.hasDescription();
      }
      
      x.para().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROPS));
      x.para().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROPS_DESC));
      XhtmlNode tbl = x.table("grid");
      XhtmlNode tr = tbl.tr();
      if (hasRendered) {
        tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROP_NAME));        
      }
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_CODE));
      if (hasURI) {
        tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROP_URI));
      }
      tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROP_TYPE));
      if (hasDescription) {
        tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_PROP_DESC));
      }
      for (PropertyComponent p : cs.getProperty()) {
        tr = tbl.tr();
        if (hasRendered) {
          String display = getPropertyDisplay(p);
          tr.td().tx(display);          
        }
        renderStatus(p, tr.td()).tx(p.getCode());
        if (hasURI) {
          renderStatus(p.getUriElement(), tr.td()).tx(p.getUri());
        }
        renderStatus(p.getTypeElement(), tr.td()).tx(p.hasType() ? p.getType().toCode() : "");
        if (hasDescription) {
          renderStatus(p.getDescriptionElement(), tr.td()).tx(p.getDescription());
        }
      }
      return true;
    } else {
      return false;
    }
  }

  private String sentenceForContent(CodeSystemContentMode mode, CodeSystem cs) {
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
  
  private boolean generateCodeSystemContent(XhtmlNode x, CodeSystem cs, boolean hasExtensions, List<UsedConceptMap> maps, boolean props) throws FHIRFormatError, DefinitionException, IOException {
    if (props) {
      x.para().b().tx(formatPhrase(RenderingContext.CODESYSTEM_CONCEPTS));
    }
    XhtmlNode p = x.para();
    renderStatus(cs.getUrlElement(), p.param("cs")).code().tx(cs.getUrl());
    makeCasedParam(p.param("cased"), cs, cs.getCaseSensitiveElement());
    makeHierarchyParam(p.param("h"), cs, cs.getHierarchyMeaningElement());

    p.paramValue("code-count", CodeSystemUtilities.countCodes(cs));
    p.sentenceForParams(sentenceForContent(cs.getContent(), cs));
    if (cs.getContent() == CodeSystemContentMode.NOTPRESENT) {
      return false;
    }
    
    XhtmlNode t = x.table( "codes");
    boolean definitions = false;
    boolean commentS = false;
    boolean deprecated = false;
    boolean display = false;
    boolean hierarchy = false;
    boolean version = false;
    boolean ignoreStatus = false;
    boolean isSupplement = cs.getContent() == CodeSystemContentMode.SUPPLEMENT;
    List<PropertyComponent> properties = new ArrayList<>();
    for (PropertyComponent cp : cs.getProperty()) {
      if (showPropertyInTable(cp)) {
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
      commentS = commentS || conceptsHaveComments(c);
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
      hasExtensions = addDefineRowToTable(t, c, 0, hierarchy, display, definitions, commentS, version, deprecated, maps, cs.getUrl(), cs, properties, csNav, langs.size() < 2 ? langs : null, isSupplement) || hasExtensions;
    }
    if (langs.size() >= 2) {
      Collections.sort(langs);
      x.para().b().tx(context.formatPhrase(RenderingContext.GENERAL_ADD_LANG));
      t = x.table("codes");
      XhtmlNode tr = t.tr();
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
      for (String lang : langs)
        tr.td().b().addText(describeLang(lang));
      for (ConceptDefinitionComponent c : cs.getConcept()) {
        addLanguageRow(c, t, langs);
      }
    }
    return hasExtensions;
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

  private boolean showPropertyInTable(PropertyComponent cp) {
    if (cp.hasCode()) {
      if (cp.hasExtension(ToolingExtensions.EXT_RENDERED_VALUE)) {
        return true;
      }
      if (cp.getCodeElement().hasExtension(ToolingExtensions.EXT_RENDERED_VALUE)) {
        return true;
      }
      String uri = cp.getUri();
      if (Utilities.noString(uri)){
        return true; // do we always want to render properties in this case? Not sure...
      }
      String code = null;
      if (uri.contains("#")) {
        code = uri.substring(uri.indexOf("#")+1);
        uri = uri.substring(0, uri.indexOf("#"));
      }
      if (Utilities.existsInList(uri, "http://hl7.org/fhir/concept-properties") || context.getCodeSystemPropList().contains(uri)) {
        return true;
      };
      CodeSystem cs = getContext().getWorker().fetchCodeSystem(uri);
      if (cs == null) {
        return false;
      }
      return code == null ? false : CodeSystemUtilities.hasCode(cs, code);
    }
    return false;
  }


  private int countConcepts(List<ConceptDefinitionComponent> list) {
    int count = list.size();
    for (ConceptDefinitionComponent c : list)
      if (c.hasConcept())
        count = count + countConcepts(c.getConcept());
    return count;
  }
  
  private boolean conceptsHaveComments(ConceptDefinitionComponent c) {
    if (ToolingExtensions.hasCSComment(c))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept())
      if (conceptsHaveComments(g))
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
    if (c.hasUserData("cs.version.notes"))
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



  private boolean addDefineRowToTable(XhtmlNode t, ConceptDefinitionComponent c, int level, boolean hasHierarchy, boolean hasDisplay, boolean hasDefinitions, boolean comment, boolean version, boolean deprecated, List<UsedConceptMap> maps, String system, CodeSystem cs, List<PropertyComponent> properties, CodeSystemNavigator csNav, List<String> langs, boolean isSupplement) throws FHIRFormatError, DefinitionException, IOException {
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
    String link = isSupplement ? getLinkForCode(cs.getSupplements(), null, c.getCode()) : null;
    if (link != null) {
      td.ah(link).style( "white-space:nowrap").addText(c.getCode());
    } else {
      td.style("white-space:nowrap").addText(c.getCode());
    }      
    XhtmlNode a;
    if (c.hasCodeElement()) {
      td.an(cs.getId()+"-" + Utilities.nmtokenize(c.getCode()));
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

        if (getContext().getMultiLanguagePolicy() == MultiLanguagePolicy.NONE || !(sl || ToolingExtensions.hasLanguageTranslations(defn))) {
          if (hasMarkdownInDefinitions(cs)) {
            addMarkdown(renderStatusDiv(defn, td), defn.asStringValue());
          } else {
            renderStatus(defn, td).addText(defn.asStringValue());
          }
        } else {
          List<Translateable> list = new ArrayList<>();
          list.add(new Translateable(cs.getLanguage(), defn));
          for (Extension ext : defn.getExtensionsByUrl(ToolingExtensions.EXT_TRANSLATION)) {
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
        smartAddText(td, formatPhrase(RenderingContext.CODESYSTEM_DEPRECATED));
        hasExtensions = true;
        if (ToolingExtensions.hasExtension(c, ToolingExtensions.EXT_REPLACED_BY)) {
          Coding cc = (Coding) ToolingExtensions.getExtension(c, ToolingExtensions.EXT_REPLACED_BY).getValue();
          td.tx(" "+ context.formatPhrase(RenderingContext.CODE_SYS_REPLACED_BY) + " ");
          String url = getCodingReference(cc, system);
          if (url != null) {
            td.ah(url).addText(cc.getCode());
            td.tx(": "+cc.getDisplay()+")");
          } else
            td.addText(cc.getCode()+" '"+cc.getDisplay()+"' in "+cc.getSystem()+")");
        } else {
          Extension ext = c.getExtensionByUrl(ToolingExtensions.EXT_STANDARDS_STATUS);
          if (ext != null) {
            ext = ext.getValue().getExtensionByUrl(ToolingExtensions.EXT_STANDARDS_STATUS_REASON);
            if (ext != null) {
              addMarkdown(td, ext.getValue().primitiveValue());
            }
          }
        }
      }
    }
    if (comment) {
      td = tr.td();
      Extension ext = c.getExtensionByUrl(ToolingExtensions.EXT_CS_COMMENT);
      if (ext != null &&  ext.hasValue() && ext.getValue().primitiveValue() != null) {
        hasExtensions = true;
        StringType defn = context.getTranslatedElement((PrimitiveType<?>) ext.getValue());
        if (getContext().getMultiLanguagePolicy() == MultiLanguagePolicy.NONE ||!(ToolingExtensions.hasLanguageTranslations(ext.getValue()))) {
          td.addText(defn.asStringValue());
        } else {
          List<Translateable> list = new ArrayList<>();
          list.add(new Translateable(cs.getLanguage(), defn));
          for (Extension ex : defn.getExtensionsByUrl(ToolingExtensions.EXT_TRANSLATION)) {
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
      if (c.hasUserData("cs.version.notes"))
        td.addText(c.getUserString("cs.version.notes"));
    }
    if (properties != null) {
      for (PropertyComponent pc : properties) {
        td = tr.td();
        boolean first = true;
        List<ConceptPropertyComponent> pcvl = CodeSystemUtilities.getPropertyValues(c, pc.getCode());
        for (ConceptPropertyComponent pcv : pcvl) {
          if (pcv.hasValue()) {
            if (first) first = false; else td.addText(", ");
            if (pcv.hasValueCoding()) { 
              td.addText(pcv.getValueCoding().getCode());
            } else if (pcv.hasValueStringType() && Utilities.isAbsoluteUrl(pcv.getValue().primitiveValue())) {
              CanonicalResource cr = (CanonicalResource) context.getContext().fetchResource(Resource.class, pcv.getValue().primitiveValue());
              if (cr != null) {
                td.ah(cr.getWebPath(), cr.getVersionedUrl()).tx(cr.present());
              } else if (Utilities.isAbsoluteUrlLinkable(pcv.getValue().primitiveValue())) {
                td.ah(pcv.getValue().primitiveValue()).tx(pcv.getValue().primitiveValue());
              } else {
                td.code(pcv.getValue().primitiveValue());                
              }
            } else if ("parent".equals(pcv.getCode())) {              
              td.ah("#"+cs.getId()+"-"+Utilities.nmtokenize(pcv.getValue().primitiveValue())).addText(pcv.getValue().primitiveValue());
            } else {
              td.addText(pcv.getValue().primitiveValue());
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
        a = td.ah(getContext().getLink(KnownLinkType.SPEC)+m.getLink()+"#"+makeAnchor(mapping.group.getTarget(), mapping.comp.getCode()));
        a.addText(mapping.comp.getCode());
        if (!Utilities.noString(mapping.comp.getComment()))
          td.i().tx("("+mapping.comp.getComment()+")");
      }
    }
    List<ConceptDefinitionComponent> ocl = csNav.getOtherChildren(c);
    for (ConceptDefinitionComponent cc : csNav.getConcepts(c)) {
      hasExtensions = addDefineRowToTable(t, cc, level+1, hasHierarchy, hasDisplay, hasDefinitions, comment, version, deprecated, maps, system, cs, properties, csNav, langs, isSupplement) || hasExtensions;
    }
    for (ConceptDefinitionComponent cc : ocl) {
      tr = t.tr();
      td = tr.td();
      td.addText(Integer.toString(level+2));
      td = tr.td();
      String s = Utilities.padLeft("", '\u00A0', (level+1)*2);
      td.addText(s);
      td.style("white-space:nowrap");
      a = td.ah("#"+cs.getId()+"-" + Utilities.nmtokenize(cc.getCode()));
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
    return hasExtensions;
  }

  private String getDisplay(String lang, ConceptDefinitionComponent c) {
    for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
      if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display") && cd.hasLanguage() && cd.getLanguage().equals(lang)) {
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
      if (cs.hasExtension("http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown")) {
        doMarkdown  = ToolingExtensions.readBoolExtension(cs, "http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown");
      } else {
        doMarkdown = CodeSystemUtilities.hasMarkdownInDefinitions(cs, context.getMarkdown());
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
      for (Extension ext : disp.getExtensionsByUrl(ToolingExtensions.EXT_TRANSLATION)) {
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
 
}