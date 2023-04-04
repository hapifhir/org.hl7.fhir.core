package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.CodeSystemNavigator;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.LoincLinker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class CodeSystemRenderer extends TerminologyRenderer {

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
      x.para().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Filters", getContext().getLang()));
      XhtmlNode tbl = x.table("grid");
      XhtmlNode tr = tbl.tr();
      tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Code", getContext().getLang()));
      tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Description", getContext().getLang()));
      tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "operator", getContext().getLang()));
      tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Value", getContext().getLang()));
      for (CodeSystemFilterComponent f : cs.getFilter()) {
        tr = tbl.tr();
        tr.td().tx(f.getCode());
        tr.td().tx(f.getDescription());
        XhtmlNode td = tr.td();
        for (Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> t : f.getOperator())
          td.tx(t.asStringValue()+" ");
        tr.td().tx(f.getValue());
      }
    }
  }

  private boolean generateProperties(XhtmlNode x, CodeSystem cs) {
    if (cs.hasProperty()) {
      boolean hasRendered = false;
      boolean hasURI = false;
      boolean hasDescription = false;
      for (PropertyComponent p : cs.getProperty()) {
        hasRendered = hasRendered || !p.getCode().equals(ToolingExtensions.getPresentation(p, p.getCodeElement()));
        hasURI = hasURI || p.hasUri();
        hasDescription = hasDescription || p.hasDescription();
      }
      
      x.para().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Properties", getContext().getLang()));
      x.para().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "This code system  defines the following properties for its concepts", getContext().getLang()));
      XhtmlNode tbl = x.table("grid");
      XhtmlNode tr = tbl.tr();
      if (hasRendered) {
        tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Name", getContext().getLang()));        
      }
      tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Code", getContext().getLang()));
      if (hasURI) {
        tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "URI", getContext().getLang()));
      }
      tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Type", getContext().getLang()));
      if (hasDescription) {
        tr.td().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Description", getContext().getLang()));
      }
      for (PropertyComponent p : cs.getProperty()) {
        tr = tbl.tr();
        if (hasRendered) {
          tr.td().tx(ToolingExtensions.getPresentation(p, p.getCodeElement()));          
        }
        tr.td().tx(p.getCode());
        if (hasURI) {
          tr.td().tx(p.getUri());
        }
        tr.td().tx(p.hasType() ? p.getType().toCode() : "");
        if (hasDescription) {
          tr.td().tx(p.getDescription());
        }
      }
      return true;
    } else {
      return false;
    }
  }

  private String sentenceForContent(CodeSystemContentMode mode) {
    switch (mode) {
    case COMPLETE: return "This code system <param name='cs'/> defines the following code<if test='code-count != 1'>s</if>:";
    case EXAMPLE: return "This code system <param name='cs'/> provides some example code<if test='code-count != 1'>s</if>:";
    case FRAGMENT: return "This code system <param name='cs'/> provides a fragment that includes following code<if test='code-count != 1'>s</if>:";
    case NOTPRESENT: return "This code system <param name='cs'/> defines codes, but no codes are represented here";
    case SUPPLEMENT: return "This code system <param name='cs'/> defines properties on the following code<if test='code-count != 1'>s</if>:";
    }
    throw new FHIRException("Unknown CodeSystemContentMode mode");
  }
  
  private boolean generateCodeSystemContent(XhtmlNode x, CodeSystem cs, boolean hasExtensions, List<UsedConceptMap> maps, boolean props) throws FHIRFormatError, DefinitionException, IOException {
    if (props) {
      x.para().b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Concepts", getContext().getLang()));
    }
    XhtmlNode p = x.para();
    p.param("cs").code().tx(cs.getUrl());
    p.paramValue("code-count", CodeSystemUtilities.countCodes(cs));
    p.sentenceForParams(sentenceForContent(cs.getContent()));
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
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      commentS = commentS || conceptsHaveComments(c);
      deprecated = deprecated || conceptsHaveDeprecated(cs, c, ignoreStatus);
      display = display || conceptsHaveDisplay(c);
      version = version || conceptsHaveVersion(c);
      hierarchy = hierarchy || c.hasConcept();
      definitions = definitions || conceptsHaveDefinition(c);
    }
    CodeSystemNavigator csNav = new CodeSystemNavigator(cs);
    hierarchy = hierarchy || csNav.isRestructure();
    
    List<String> langs = new ArrayList<>();
    addCopyColumn(addMapHeaders(addTableHeaderRowStandard(t, hierarchy, display, definitions, commentS, version, deprecated, properties, null, null, false), maps));
    for (ConceptDefinitionComponent c : csNav.getConcepts(null)) {
      hasExtensions = addDefineRowToTable(t, c, 0, hierarchy, display, definitions, commentS, version, deprecated, maps, cs.getUrl(), cs, properties, csNav, langs, isSupplement) || hasExtensions;
    }
    if (langs.size() > 0) {
      Collections.sort(langs);
      x.para().b().tx("Additional Language Displays");
      t = x.table("codes");
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Code");
      for (String lang : langs)
        tr.td().b().addText(describeLang(lang));
      for (ConceptDefinitionComponent c : cs.getConcept()) {
        addLanguageRow(c, t, langs);
      }
    }
    return hasExtensions;
  }

  private void addCopyColumn(XhtmlNode tr) {
    if (context.isCopyButton()) {
      tr.td().b().tx("Copy");
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
    
    XhtmlNode td = tr.td();
    if (hasHierarchy) {
      td.addText(Integer.toString(level+1));
      td = tr.td();
      String s = Utilities.padLeft("", '\u00A0', level*2);
      td.addText(s);
    }
    String link = isSupplement ? getLinkForCode(cs.getSupplements(), null, c.getCode()) : null;
    if (link != null) {
      td.ah(link).attribute("style", "white-space:nowrap").addText(c.getCode());
    } else {
      td.attribute("style", "white-space:nowrap").addText(c.getCode());
    }      
    XhtmlNode a;
    if (c.hasCodeElement()) {
      td.an(cs.getId()+"-" + Utilities.nmtokenize(c.getCode()));
    }

    for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
      if (cd.hasLanguage() && !langs.contains(cd.getLanguage()) && (!cs.hasLanguage() || !cs.getLanguage().equals(cd.getLanguage()))) {
        langs.add(cd.getLanguage());
      }
        
    }

    if (hasDisplay) {
      td = tr.td();
      renderDisplayName(c, cs, td);
    } 
    if (hasDefinitions) {
      td = tr.td();
      if (c != null && 
          c.hasDefinitionElement()) {
        if (getContext().getLang() == null) {
          if (hasMarkdownInDefinitions(cs))
            addMarkdown(td, c.getDefinition());
          else
            td.addText(c.getDefinition());
        } else if (getContext().getLang().equals("*")) {
          boolean sl = false;
          for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) 
            if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "definition") && cd.hasLanguage() && !c.getDefinition().equalsIgnoreCase(cd.getValue())) 
              sl = true;
          td.addText((sl ? cs.getLanguage("en")+": " : ""));
          if (hasMarkdownInDefinitions(cs))
            addMarkdown(td, c.getDefinition());
          else
            td.addText(c.getDefinition());
          for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
            if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "definition") && cd.hasLanguage() && !c.getDefinition().equalsIgnoreCase(cd.getValue())) {
              td.br();
              td.addText(cd.getLanguage()+": "+cd.getValue());
            }
          }
        } else if (getContext().getLang().equals(cs.getLanguage()) || (getContext().getLang().equals("en") && !cs.hasLanguage())) {
          td.addText(c.getDefinition());
        } else {
          for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
            if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "definition") && cd.hasLanguage() && cd.getLanguage().equals(getContext().getLang())) {
              td.addText(cd.getValue());
            }
          }
        }
      }
    }
    if (deprecated) {
      td = tr.td();
      Boolean b = CodeSystemUtilities.isDeprecated(cs, c, false);
      if (b !=  null && b) {
        smartAddText(td, getContext().getWorker().translator().translate("xhtml-gen-cs", "Deprecated", getContext().getLang()));
        hasExtensions = true;
        if (ToolingExtensions.hasExtension(c, ToolingExtensions.EXT_REPLACED_BY)) {
          Coding cc = (Coding) ToolingExtensions.getExtension(c, ToolingExtensions.EXT_REPLACED_BY).getValue();
          td.tx(" (replaced by ");
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
      if (ext != null) {
        hasExtensions = true;
        String bc = ext.hasValue() ? ext.getValue().primitiveValue() : null;
        Map<String, String> translations = ToolingExtensions.getLanguageTranslations(ext.getValue());

        if (getContext().getLang() == null) {
          if (bc != null)
            td.addText(bc);
        } else if (getContext().getLang().equals("*")) {
          boolean sl = false;
          for (String l : translations.keySet()) 
            if (bc == null || !bc.equalsIgnoreCase(translations.get(l))) 
              sl = true;
          if (bc != null) {
            td.addText((sl ? cs.getLanguage("en")+": " : "")+bc);
          }
          for (String l : translations.keySet()) {
            if (bc == null || !bc.equalsIgnoreCase(translations.get(l))) {
              if (!td.getChildNodes().isEmpty()) 
                td.br();
              td.addText(l+": "+translations.get(l));
            }
          }
        } else if (getContext().getLang().equals(cs.getLanguage()) || (getContext().getLang().equals("en") && !cs.hasLanguage())) {
          if (bc != null)
            td.addText(bc);
        } else {
          if (bc != null)
            translations.put(cs.getLanguage("en"), bc);
          for (String l : translations.keySet()) { 
            if (l.equals(getContext().getLang())) {
              td.addText(translations.get(l));
            }
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
            } else if (pcv.hasValueStringType() && Utilities.isAbsoluteUrlLinkable(pcv.getValue().primitiveValue())) {
              td.ah(pcv.getValue().primitiveValue()).tx(pcv.getValue().primitiveValue());
            } else {
              td.addText(pcv.getValue().primitiveValue());
            }
          }
        }
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
      td.attribute("style", "white-space:nowrap");
      a = td.ah("#"+cs.getId()+"-" + Utilities.nmtokenize(cc.getCode()));
      a.addText(cc.getCode());
      if (hasDisplay) {
        td = tr.td();
        renderDisplayName(cc, cs, td);
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

  private boolean hasMarkdownInDefinitions(CodeSystem cs) {
    return ToolingExtensions.readBoolExtension(cs, "http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown");
  }


  public void renderDisplayName(ConceptDefinitionComponent c, CodeSystem cs, XhtmlNode td) {
    if (c.hasDisplayElement()) {
      if (getContext().getLang() == null) {
        td.addText(c.getDisplay());
      } else if (getContext().getLang().equals("*")) {
        boolean sl = false;
        for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) 
          if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display") && cd.hasLanguage() && !c.getDisplay().equalsIgnoreCase(cd.getValue())) 
            sl = true;
        td.addText((sl ? cs.getLanguage("en")+": " : "")+c.getDisplay());
        for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
          if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display") && cd.hasLanguage() && !c.getDisplay().equalsIgnoreCase(cd.getValue())) {
            td.br();
            td.addText(cd.getLanguage()+": "+cd.getValue());
          }
        }
     } else if (getContext().getLang().equals(cs.getLanguage()) || (getContext().getLang().equals("en") && !cs.hasLanguage())) {
       td.addText(c.getDisplay());
     } else {
       for (ConceptDefinitionDesignationComponent cd : c.getDesignation()) {
         if (cd.getUse().is("http://terminology.hl7.org/CodeSystem/designation-usage", "display") && cd.hasLanguage() && cd.getLanguage().equals(getContext().getLang())) {
           td.addText(cd.getValue());
         }
       }
     }
    }
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