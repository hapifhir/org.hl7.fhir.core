package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ExtensionHelper;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.DesignationMode;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.SnomedUtilities;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.LoincLinker;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

@MarkedToMoveToAdjunctPackage
public class ValueSetRenderer extends TerminologyRenderer {

  private Map<String, CodeSystem> supplementedCodeSystems = new HashMap<>();

  public ValueSetRenderer(RenderingContext context) { 
    super(context); 
  }
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (!r.isDirect()) {
      // the intention is to change this in the future
      x.para().tx("ValueSetRenderer only renders native resources directly");
    } else {
      renderResourceTechDetails(r, x);
      ValueSet vs = (ValueSet) r.getBase();

      genSummaryTable(status, x, vs);
      List<UsedConceptMap> maps = findReleventMaps(vs);

      if (context.isShowSummaryTable()) {
        XhtmlNode h = x.h2();
        h.addText(vs.hasTitle() ? vs.getTitle() : vs.getName());
        addMarkdown(x, vs.getDescription());
        if (vs.hasCopyright())
          generateCopyright(x, r);
      }
      if (vs.hasExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED)) {
        List<Extension> exts = vs.getExtensionsByUrl(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED);
        var p = x.para();
        p.tx(context.formatPhrasePlural(exts.size(), RenderingI18nContext.VALUE_SET_NEEDS_SUPPL));
        p.tx(" ");
        for (int i = 0; i < exts.size(); i++) { 
          if (i > 0) {
            if (i == exts.size() - 1) {
              p.tx(" and ");
            } else {
              p.tx(", ");
            }
          }
          String u = exts.get(i).getValue().primitiveValue();
          CodeSystem cs = context.getContext().fetchResource(CodeSystem.class, u);
          if (cs == null) {
            p.code().tx(u);
          } else if (!cs.hasWebPath()) {
            p.ah(u).tx(cs.present());
          } else {
            p.ah(cs.getWebPath()).tx(cs.present());          
          }
        }
        p.tx(".");
      }
      if (vs.hasExtension(ExtensionDefinitions.EXT_VALUESET_PARAMETER)) {
        x.para().b().tx("This ValueSet has parameters");
        XhtmlNode tbl = x.table("grid").markGenerated(!context.forValidResource());
        XhtmlNode tr = tbl.tr();
        tr.th().tx("Name");
        tr.th().tx("Documentation");
        for (Extension ext : vs.getExtensionsByUrl(ExtensionDefinitions.EXT_VALUESET_PARAMETER)) {
          tr = tbl.tr();
          tr.td().tx(ext.getExtensionString("name"));
          tr.td().markdown(ext.getExtensionString("documentation"), "parameter.documentation");    
        }
      }
      if (vs.hasExpansion()) {
        // for now, we just accept an expansion if there is one
        generateExpansion(status, r, x, vs, false, maps);
      } else {
        generateComposition(status, r, x, vs, false, maps);
      }
    }
  }

  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  private static final int MAX_DESIGNATIONS_IN_LINE = 5;

  private static final int MAX_BATCH_VALIDATION_SIZE = 1000;

  private List<ConceptMapRenderInstructions> renderingMaps = new ArrayList<ConceptMapRenderInstructions>();

  private Map<String, String> oidMap;

  public void render(RenderingStatus status, XhtmlNode x, ValueSet vs, boolean header) throws FHIRFormatError, DefinitionException, IOException {
    
  }

  public void describe(XhtmlNode x, ValueSet vs) {
    x.tx(display(vs));
  }

  public String display(ValueSet vs) {
    return vs.present();
  }

  
  private List<UsedConceptMap> findReleventMaps(ValueSet vs) throws FHIRException {
    List<UsedConceptMap> res = new ArrayList<UsedConceptMap>();
    for (ConceptMap cm : getContext().getWorker().fetchResourcesByType(ConceptMap.class)) {
      if (isSource(vs, cm.getSourceScope())) {
        ConceptMapRenderInstructions re = findByTarget(cm.getTargetScope());
        if (re == null) {
          re = new ConceptMapRenderInstructions(cm.present(), cm.getUrl(), false);
        }
        if (re != null) {
          ValueSet vst = cm.hasTargetScope() ? getContext().getWorker().findTxResource(ValueSet.class, cm.hasTargetScopeCanonicalType() ? cm.getTargetScopeCanonicalType().getValue() : cm.getTargetScopeUriType().asStringValue(), null, cm) : null;
          res.add(new UsedConceptMap(re, vst == null ? cm.getWebPath() : vst.getWebPath(), cm));
        }
      }
    }
    return res;

//    @Override
//    public List<ConceptMap> findMapsForSource(String url) throws FHIRException {
//      synchronized (lock) {
//        List<ConceptMap> res = new ArrayList<ConceptMap>();
//        for (ConceptMap map : maps.getList()) {
//          if (((Reference) map.getSourceScope()).getReference().equals(url)) { 
//            res.add(map);
//          } 
//        } 
//        return res;
//      }
//    }

//    Map<ConceptMap, String> mymaps = new HashMap<ConceptMap, String>();
//  for (ConceptMap a : context.getWorker().findMapsForSource(vs.getUrl())) {
//    String url = "";
//    ValueSet vsr = context.getWorker().findTxResource(ValueSet.class, ((Reference) a.getTarget()).getReference());
//    if (vsr != null)
//      url = (String) vsr.getUserData(UserDataNames.filename);
//    mymaps.put(a, url);
//  }
//    Map<ConceptMap, String> mymaps = new HashMap<ConceptMap, String>();
//  for (ConceptMap a : context.getWorker().findMapsForSource(cs.getValueSet())) {
//    String url = "";
//    ValueSet vsr = context.getWorker().fetchResource(ValueSet.class, ((Reference) a.getTarget()).getReference());
//    if (vsr != null)
//      url = (String) vsr.getUserData(UserDataNames.filename);
//    mymaps.put(a, url);
//  }
    // also, look in the contained resources for a concept map
//    for (Resource r : cs.getContained()) {
//      if (r instanceof ConceptMap) {
//        ConceptMap cm = (ConceptMap) r;
//        if (((Reference) cm.getSource()).getReference().equals(cs.getValueSet())) {
//          String url = "";
//          ValueSet vsr = context.getWorker().findTxResource(ValueSet.class, ((Reference) cm.getTarget()).getReference());
//          if (vsr != null)
//              url = (String) vsr.getUserData(UserDataNames.filename);
//        mymaps.put(cm, url);
//        }
//      }
//    }
  }  
  
  private boolean isSource(ValueSet vs, DataType source) {
    return vs.hasUrl() && source != null && vs.getUrl().equals(source.primitiveValue());
  }  
  
  private void generateExpansion(RenderingStatus status, ResourceWrapper res, XhtmlNode x, ValueSet vs, boolean header, List<UsedConceptMap> maps) throws FHIRFormatError, DefinitionException, IOException {
    List<String> langs = new ArrayList<String>();
    Map<String, String> designations = new HashMap<>(); //  map of url = description, where url is the designation code. Designations that are for languages won't make it into this list
    Map<String, String> properties = new HashMap<>(); //  map of url = description, where url is the designation code. Designations that are for languages won't make it into this list

    if (header) {
      XhtmlNode h = x.addTag(getHeader());
      h.tx(context.formatPhrase(RenderingContext.VALUE_SET_CONT));
      if (IsNotFixedExpansion(vs))
        addMarkdown(x, vs.getDescription());
      if (vs.hasCopyright())
        generateCopyright(x, res);
    }
    boolean hasFragment = generateContentModeNotices(x, vs.getExpansion(), vs);
    generateVersionNotice(x, vs.getExpansion(), vs);
    
    if (ExtensionUtilities.hasExtension(vs.getExpansion(), ExtensionDefinitions.EXT_EXP_TOOCOSTLY)) {
      String msg = null;
      if (vs.getExpansion().getContains().isEmpty()) {
        msg = context.formatPhrase(RenderingContext.VALUE_SET_TOO_COSTLY);
      } else {
        msg = context.formatPhrase(RenderingContext.VALUE_SET_CODE_SELEC, countMembership(vs));
      }
      x.para().style("border: maroon 1px solid; background-color: #FFCCCC; font-weight: bold; padding: 8px").addText(msg);
    } else {
      int count = ValueSetUtilities.countExpansion(vs);
      if (vs.getExpansion().hasTotal()) {
        if (count != vs.getExpansion().getTotal()) {
          x.para().style("border: maroon 1px solid; background-color: #FFCCCC; font-weight: bold; padding: 8px")
            .addText(context.formatPhrase(hasFragment ? RenderingContext.VALUE_SET_HAS_AT_LEAST : RenderingContext.VALUE_SET_HAS, vs.getExpansion().getTotal(), count));
        } else {
          x.para().tx(context.formatPhrase(hasFragment ? RenderingContext.VALUE_SET_CONTAINS_AT_LEAST : RenderingContext.VALUE_SET_CONTAINS, vs.getExpansion().getTotal()));          
        }
      } else if (count == 1000) {
        // it's possible that there's exactly 1000 codes, in which case wht we're about to do is wrong
        // work in progress to tighten up the terminology system to always return a total...
        String msg = context.formatPhrase(RenderingContext.VALUE_SET_SEL);    
        x.para().style("border: maroon 1px solid; background-color: #FFCCCC; font-weight: bold; padding: 8px").addText(msg);        
      } else {
        x.para().tx(context.formatPhrase(RenderingContext.VALUE_SET_NUMBER_CONCEPTS, count));
      }
    }
    

    boolean doLevel = false;
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      if (cc.hasContains()) {
        doLevel = true;
        break;
      }
    }
    boolean doInactive = checkDoInactive(vs.getExpansion().getContains());    
    boolean doDefinition = checkDoDefinition(vs, vs.getExpansion().getContains());
    boolean doVersion = checkDoVersion(vs.getExpansion().getContains());
    
    XhtmlNode t = x.table("codes", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = t.tr();
    if (doLevel)
      tr.td().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_LEVEL));
    tr.td().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_SYSTEM));
    if (doVersion) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_VER));
    }
    tr.td().attribute("style", "white-space:nowrap").b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
    XhtmlNode tdDisp = tr.td();
    String displang = vs.getLanguage();
    if (displang == null) {
      displang = findParamValue(vs.getExpansion().getParameter(), "displayLanguage");
    }
    if (displang == null) {
      tdDisp.b().tx(context.formatPhrase(RenderingContext.TX_DISPLAY));
    } else {
      tdDisp.b().tx(context.formatPhrase(RenderingContext.TX_DISPLAY_LANG, displang));
    }
    boolean doDesignations = false;
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      scanForDesignations(vs, c, langs, designations);
    }
    scanForProperties(vs.getExpansion(), langs, properties);
    if (doInactive) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_INACTIVE));
    }
    if (doDefinition) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_DEFINITION));
      doDesignations = false;
      for (String n : Utilities.sorted(properties.keySet())) {
        tr.td().b().ah(context.prefixLocalHref(properties.get(n))).addText(n);        
      }
    } else {
      for (String n : Utilities.sorted(properties.keySet())) {
        tr.td().b().ah(context.prefixLocalHref(properties.get(n))).addText(n);        
      }
      // if we're not doing definitions and we don't have too many languages, we'll do them in line
      doDesignations = langs.size() + properties.size() + designations.size() < MAX_DESIGNATIONS_IN_LINE;

      if (doDesignations) {
        if (vs.hasLanguage()) {
          tdDisp.tx(" - "+describeLang(vs.getLanguage()));
        }
        for (String url : designations.keySet()) {
          tr.td().b().addText(designations.get(url));
        }
        for (String lang : langs) {
          tr.td().b().addText(describeVSLang(lang, displang));
        }
      }
    }
    addMapHeaders(tr, maps);
    if (context.forPublisher()) {
      tr.td().b().tx(context.formatPhrase(RenderingI18nContext.CANON_REND_JSON));
      tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_XML));
    }

    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      addExpansionRowToTable(t, vs, c, 1, doLevel, doDefinition, doInactive, doVersion, maps, langs, designations, doDesignations, properties, res);
    }

    // now, build observed languages

    if (!doDesignations && langs.size() + designations.size() > 0) {
      Collections.sort(langs);
      if (designations.size() == 0) {
        x.para().b().tx(context.formatPhrase(RenderingContext.GENERAL_ADD_LANG));
      } else if (langs.size() == 0) {
        x.para().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_DESIG));
      } else {
        x.para().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_ADD_DESIG));
      }
      t = x.table("codes", false).markGenerated(!context.forValidResource());
      tr = t.tr();
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
      for (String url : designations.keySet()) {
        tr.td().b().addText(designations.get(url));
      }
      for (String lang : langs) {
        tr.td().b().addText(describeLang(lang));
      }
      for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
        addDesignationRow(c, t, langs, designations);
      }
    }

  }

  protected String describeVSLang(String lang, String displang) { 
    
    // special cases: 
    if ("fr-CA".equals(lang)) { 
      return "French (Canadian)"; // this one was omitted from the value set 
    } 
    ValueSet v = getContext().getWorker().findTxResource(ValueSet.class, "http://hl7.org/fhir/ValueSet/languages"); 
    if (v != null) { 
      ConceptReferenceComponent l = null; 
      for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) { 
        if (cc.getCode().equals(lang)) 
          l = cc; 
      } 
      if (l == null) { 
        if (lang.contains("-")) { 
          lang = lang.substring(0, lang.indexOf("-")); 
        } 
        for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) { 
          if (cc.getCode().equals(lang)) { 
            l = cc; 
            break; 
          } 
        } 
        if (l == null) { 
          for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) { 
            if (cc.getCode().startsWith(lang+"-")) { 
              l = cc; 
              break; 
            } 
          } 
        } 
      } 
      if (l != null) { 
        if (lang.contains("-")) 
          lang = lang.substring(0, lang.indexOf("-")); 
        String en = l.getDisplay(); 
        String nativelang = null; 
        for (ConceptReferenceDesignationComponent cd : l.getDesignation()) { 
          if (cd.getLanguage().equals(lang)) 
            nativelang = cd.getValue(); 
        } 
        return context.formatPhrase(langsMatch(lang, displang) ? RenderingContext.VALUE_SET_OTHER_DISPLAY : RenderingContext.TX_DISPLAY_LANG,  nativelang == null ? en : nativelang);
      } 
    } 
    return lang; 
  } 


  private boolean langsMatch(String lang, String displang) {
    if (lang == null) {
      return displang == null;
    } else if (lang.equals(displang)) {
      return true;
    } else if (displang == null) {
      return false;
    } else {
      String l1 = lang.contains("-") ? lang.substring(0, lang.indexOf("-")) : lang;
      String l2 = displang.contains("-") ? displang.substring(0, displang.indexOf("-")) : displang;
      return l1.equals(l2);
    }
  }

  private void scanForProperties(ValueSetExpansionComponent exp, List<String> langs, Map<String, String> properties) {
    properties.clear();
    for (ValueSetExpansionPropertyComponent pp : exp.getProperty()) {
      if (pp.hasCode() && pp.hasUri() && anyActualproperties(exp.getContains(), pp.getCode())) {
        properties.put(pp.getCode(), pp.getUri());
      }
    }
  }

  private boolean anyActualproperties(List<ValueSetExpansionContainsComponent> contains, String pp) {
    for (ValueSetExpansionContainsComponent c : contains) {
      for (ConceptPropertyComponent cp : c.getProperty()) {
        if (pp.equals(cp.getCode())) {
          return true;
        }
      }
      if (anyActualproperties(c.getContains(), pp)) {
        return true;
      }
    }
    return false;
  }

  private boolean generateContentModeNotices(XhtmlNode x, ValueSetExpansionComponent expansion, Resource vs) {
    generateContentModeNotice(x, expansion, "example", context.formatPhrase(RenderingContext.VALUE_SET_EXP), vs); 
    return generateContentModeNotice(x, expansion, "fragment", context.formatPhrase(RenderingContext.VALUE_SET_EXP_FRAG), vs); 
  }
  
  private boolean generateContentModeNotice(XhtmlNode x, ValueSetExpansionComponent expansion, String mode, String text, Resource vs) {
    boolean res = false;
    Multimap<String, String> versions = HashMultimap.create();
    for (ValueSetExpansionParameterComponent p : expansion.getParameter()) {
      if (p.getName().equals(mode)) {
        String[] parts = ((PrimitiveType) p.getValue()).asStringValue().split("\\|");
        if (parts.length == 2 && !Utilities.noString(parts[0]))
          versions.put(parts[0], parts[1]);
      }
    }
    if (versions.size() > 0) {
      XhtmlNode div = null;
      XhtmlNode ul = null;
      boolean first = true;
      for (String s : versions.keySet()) {
        if (versions.size() == 1 && versions.get(s).size() == 1) {
          for (String v : versions.get(s)) { // though there'll only be one
            XhtmlNode p = x.para().style("border: black 1px dotted; background-color: #ffcccc; padding: 8px; margin-bottom: 8px");
            p.tx(text+" ");
            expRef(p, s, v, vs);
            res = true;
          }
        } else {
          for (String v : versions.get(s)) {
            if (first) {
              div = x.div().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
              div.para().tx(text+"s: ");
              ul = div.ul();
              first = false;
              res = true;
            }
            expRef(ul.li(), s, v, vs);
          }
        }
      }
    }
    return res;
  }

  private boolean checkDoSystem(ValueSet vs, ValueSet src) {
    if (src != null)
      vs = src;
    return vs.hasCompose();
  }

  private boolean IsNotFixedExpansion(ValueSet vs) {
    if (vs.hasCompose())
      return false;


    // it's not fixed if it has any includes that are not version fixed
    for (ConceptSetComponent cc : vs.getCompose().getInclude()) {
      if (cc.hasValueSet())
        return true;
      if (!cc.hasVersion())
        return true;
    }
    return false;
  }


 
  
  private ConceptMapRenderInstructions findByTarget(DataType source) {
    if (source == null) {
      return null;
    }
    String src = source.primitiveValue();
    if (src == null) {
      return null;
    }
    for (ConceptMapRenderInstructions t : renderingMaps) {
      if (src.equals(t.getUrl()))
        return t;
    }
    return null;    
  }

  private Integer countMembership(ValueSet vs) {
    int count = 0;
    if (vs.hasExpansion())
      count = count + ValueSetUtilities.countExpansion(vs);
    else {
      if (vs.hasCompose()) {
        if (vs.getCompose().hasExclude()) {
          try {
            ValueSetExpansionOutcome vse = getContext().getWorker().expandVS(ExpansionOptions.cacheNoHeirarchy().withLanguage(context.getLocale().getLanguage()), vs);
            count = 0;
            count += ValueSetUtilities.countExpansion(vse.getValueset());
            return count;
          } catch (Exception e) {
            return null;
          }
        }
        for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
          if (inc.hasFilter())
            return null;
          if (!inc.hasConcept())
            return null;
          count = count + inc.getConcept().size();
        }
      }
    }
    return count;
  }

  @SuppressWarnings("rawtypes")
  private void generateVersionNotice(XhtmlNode x, ValueSetExpansionComponent expansion, Resource vs) {

    Multimap<String, String> versions = HashMultimap.create();
    Set<String> vlist = new HashSet<>();
    for (ValueSetExpansionParameterComponent p : expansion.getParameter()) {
      if ((p.getName().startsWith("used-") || p.getName().equals("version")) && !vlist.contains(p.getValue().primitiveValue())) {
        String name = p.getName().equals("version") ? "system" : p.getName().substring(5);
        vlist.add(p.getValue().primitiveValue());
        String[] parts = ((PrimitiveType) p.getValue()).asStringValue().split("\\|");
        if (parts.length == 2 && !Utilities.noString(parts[0]))
          versions.put(name+"|"+parts[0], parts[1]);
      }
    }
    if (versions.size() > 0) {
      XhtmlNode div = null;
      XhtmlNode ul = null;
      boolean first = true;
      for (String s : Utilities.sorted(versions.keySet())) {
        if (versions.size() == 1 && versions.get(s).size() == 1) {
          for (String v : versions.get(s)) { // though there'll only be one
            XhtmlNode p = x.para().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
            if (!vs.hasUserData(UserDataNames.VS_EXPANSION_SOURCE)) {
              p.tx(context.formatPhrase(RenderingContext.VALUE_SET_EXPANSION)+" ");
            } else if ("internal".equals(vs.getUserString(UserDataNames.VS_EXPANSION_SOURCE))) {
              p.tx(context.formatPhrase(RenderingContext.VALUE_SET_EXPANSION_INTERNAL)+" ");              
            } else {
              p.tx(context.formatPhrase(RenderingContext.VALUE_SET_EXPANSION_SRVR, vs.getUserString(UserDataNames.VS_EXPANSION_SOURCE))+" ");
            }
            expRef(p, s, v, vs);
          }
        } else {
          for (String v : versions.get(s)) {
            if (first) {
              div = x.div().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
              if (!vs.hasUserData(UserDataNames.VS_EXPANSION_SOURCE)) {
                div.para().tx(context.formatPhrase(RenderingContext.VALUE_SET_EXPANSIONS));                
              } else if ("internal".equals(vs.getUserString(UserDataNames.VS_EXPANSION_SOURCE))) {
                div.para().tx(context.formatPhrase(RenderingContext.VALUE_SET_EXPANSIONS_INTERNAL));                
              } else {
                div.para().tx(context.formatPhrase(RenderingContext.VALUE_SET_EXPANSIONS_SRVR, vs.getUserString(UserDataNames.VS_EXPANSION_SOURCE)));
              }
              ul = div.ul();
              first = false;
            }
            expRef(ul.li(), s, v, vs);
          }
        }
      }
    }
  }

  private String findParamValue(List<ValueSetExpansionParameterComponent> list, String name) {
    for (ValueSetExpansionParameterComponent p : list) {
      if (name.equals(p.getName())) {
        return p.getValue().primitiveValue();
      }
    }
    return null;
  }
  
  private void expRef(XhtmlNode x, String u, String v, Resource source) {
    String t = u.contains("|") ? u.substring(0, u.indexOf("|")) : u;
    u = u.substring(u.indexOf("|")+1);
    // TODO Auto-generated method stub
    if (u.equals("http://snomed.info/sct")) {
      String[] parts = v.split("\\/");
      if (parts.length >= 5) {
        String m = describeModule(parts[4]);
        if (parts.length == 7) {
          x.tx(context.formatPhrase(RenderingContext.VALUE_SET_SNOMED_ADD, m, formatSCTDate(parts[6])));
        } else {
          x.tx(context.formatPhrase(RenderingContext.VALUE_SET_SNOMED, m));
        }
      } else {
        x.tx(displaySystem(u)+" "+ context.formatPhrase(RenderingContext.GENERAL_VER_LOW) + " " +v);
      }
    } else if (u.equals("http://loinc.org")) {
      String vd = describeLoincVer(v);
      if (vd != null) {
        x.tx(context.formatPhrase(RenderingContext.VALUE_SET_LOINCV)+v+" ("+vd+")");
      } else {
        x.tx(context.formatPhrase(RenderingContext.VALUE_SET_LOINCV)+v);        
      }
    } else if (Utilities.noString(v)) {
      CanonicalResource cr = (CanonicalResource) getContext().getWorker().fetchResource(Resource.class, u, null, source);
      if (cr != null) {
        if (cr.hasWebPath()) {
          x.ah(context.prefixLocalHref(cr.getWebPath())).tx(t+" "+cr.present()+" "+ context.formatPhrase(RenderingContext.VALUE_SET_NO_VERSION)+cr.fhirType()+")");          
        } else {
          x.tx(t+" "+displaySystem(u)+" "+context.formatPhrase(RenderingContext.VALUE_SET_NO_VERSION)+cr.fhirType()+")");
        }
      } else {
        x.tx(t+" "+displaySystem(u)+" "+ context.formatPhrase(RenderingContext.VALUE_SET_NO_VER));
      }
    } else {
      CanonicalResource cr = (CanonicalResource) getContext().getWorker().fetchResource(Resource.class, u, v, source);
      if (cr != null) {
        if (cr.hasWebPath()) {
          x.ah(context.prefixLocalHref(cr.getWebPath())).tx(t+" "+cr.present()+" v"+v+" ("+cr.fhirType()+")");          
        } else {
          x.tx(t+" "+displaySystem(u)+" v"+v+" ("+cr.fhirType()+")");
        }
      } else {
        x.tx(t+" "+displaySystem(u)+" "+ context.formatPhrase(RenderingContext.GENERAL_VER_LOW)+" "+v);
      }
    }
    if (context.forPublisher()) {
      XhtmlNode ispan = x.spanClss("copy-text-inline");
      String copyUrl = v == null ? u : u + "|" + v;
      ispan.button("btn-copy", context.formatPhrase(RenderingContext.STRUC_DEF_COPY_URL)).attribute("data-clipboard-text", copyUrl).tx(" ");
    }
  }

  private String describeLoincVer(String v) {
    if ("2.67".equals(v))  return "Dec 2019";
    if ("2.66".equals(v))  return "Jun 2019";
    if ("2.65".equals(v))  return "Dec 2018";
    if ("2.64".equals(v))  return "Jun 2018";
    if ("2.63".equals(v))  return "Dec 2017";
    if ("2.61".equals(v))  return "Jun 2017";
    if ("2.59".equals(v))  return "Feb 2017";
    if ("2.58".equals(v))  return "Dec 2016";
    if ("2.56".equals(v))  return "Jun 2016";
    if ("2.54".equals(v))  return "Dec 2015";
    if ("2.52".equals(v))  return "Jun 2015";
    if ("2.50".equals(v))  return "Dec 2014";
    if ("2.48".equals(v))  return "Jun 2014";
    if ("2.46".equals(v))  return "Dec 2013";
    if ("2.44".equals(v))  return "Jun 2013";
    if ("2.42".equals(v))  return "Dec 2012";
    if ("2.40".equals(v))  return "Jun 2012";
    if ("2.38".equals(v))  return "Dec 2011";
    if ("2.36".equals(v))  return "Jun 2011";
    if ("2.34".equals(v))  return "Dec 2010";
    if ("2.32".equals(v))  return "Jun 2010";
    if ("2.30".equals(v))  return "Feb 2010";
    if ("2.29".equals(v))  return "Dec 2009";
    if ("2.27".equals(v))  return "Jul 2009";
    if ("2.26".equals(v))  return "Jan 2009";
    if ("2.24".equals(v))  return "Jul 2008";
    if ("2.22".equals(v))  return "Dec 2007";
    if ("2.21".equals(v))  return "Jun 2007";
    if ("2.19".equals(v))  return "Dec 2006";
    if ("2.17".equals(v))  return "Jun 2006";
    if ("2.16".equals(v))  return "Dec 2005";
    if ("2.15".equals(v))  return "Jun 2005";
    if ("2.14".equals(v))  return "Dec 2004";
    if ("2.13".equals(v))  return "Aug 2004";
    if ("2.12".equals(v))  return "Feb 2004";
    if ("2.10".equals(v))  return "Oct 2003";
    if ("2.09".equals(v))  return "May 2003";
    if ("2.08 ".equals(v)) return "Sep 2002";
    if ("2.07".equals(v))  return "Aug 2002";
    if ("2.05".equals(v))  return "Feb 2002";
    if ("2.04".equals(v))  return "Jan 2002";
    if ("2.03".equals(v))  return "Jul 2001";
    if ("2.02".equals(v))  return "May 2001";
    if ("2.01".equals(v))  return "Jan 2001";
    if ("2.00".equals(v))  return "Jan 2001";
    if ("1.0n".equals(v))  return "Feb 2000";
    if ("1.0ma".equals(v)) return "Aug 1999";
    if ("1.0m".equals(v))  return "Jul 1999";
    if ("1.0l".equals(v))  return "Jan 1998";
    if ("1.0ja".equals(v)) return "Oct 1997";
    return null;
  }

  private String formatSCTDate(String ds) {
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    Date date;
    try {
      date = format.parse(ds);
    } catch (ParseException e) {
      return ds;
    }
    return new SimpleDateFormat("dd-MMM yyyy").format(date);
  }

  private String describeModule(String module) {
    switch (module) {
    case "900000000000207008" : return context.formatPhrase(RenderingContext.VALUE_SET_INT);
    case "449081005" : return context.formatPhrase(RenderingContext.VALUE_SET_SPAN);  
    case "11000221109" : return context.formatPhrase(RenderingContext.VALUE_SET_AR);
    case "32506021000036107" : return context.formatPhrase(RenderingContext.VALUE_SET_AUS);
    case "11000234105" : return context.formatPhrase(RenderingContext.VALUE_SET_AT);
    case "11000172109" : return context.formatPhrase(RenderingContext.VALUE_SET_BE);
    case "20621000087109" : return context.formatPhrase(RenderingContext.VALUE_SET_CA_EN);
    case "20611000087101" : return context.formatPhrase(RenderingContext.VALUE_SET_CA); // was FR but was repurposed
    case "554471000005108" : return context.formatPhrase(RenderingContext.VALUE_SET_DANISH);
    case "11000181102 " : return context.formatPhrase(RenderingContext.VALUE_SET_EE);
    case "11000229106" : return context.formatPhrase(RenderingContext.VALUE_SET_FI);
    case "11000274103" : return context.formatPhrase(RenderingContext.VALUE_SET_DE);
    case "1121000189102" : return context.formatPhrase(RenderingContext.VALUE_SET_IN);
    case "11000220105" : return context.formatPhrase(RenderingContext.VALUE_SET_IE);
    case "11000146104" : return context.formatPhrase(RenderingContext.VALUE_SET_DUTCH);
    case "21000210109" : return context.formatPhrase(RenderingContext.VALUE_SET_NZ);
    case "51000202101 " : return context.formatPhrase(RenderingContext.VALUE_SET_NO);
    case "11000267109" : return context.formatPhrase(RenderingContext.VALUE_SET_KR);
    case "900000001000122104" : return context.formatPhrase(RenderingContext.VALUE_ES_ES);
    case "45991000052106" : return context.formatPhrase(RenderingContext.VALUE_SET_SWEDISH); 
    case "2011000195101" : return context.formatPhrase(RenderingContext.VALUE_SET_CH);
    case "83821000000107" : return context.formatPhrase(RenderingContext.VALUE_SET_UK);
    case "999000021000000109" : return context.formatPhrase(RenderingContext.VALUE_SET_UK_CLIN);
    case "5631000179106" : return context.formatPhrase(RenderingContext.VALUE_SET_UY);  
    case "731000124108" : return context.formatPhrase(RenderingContext.VALUE_SET_US);
    case "5991000124107" : return context.formatPhrase(RenderingContext.VALUE_SET_US_ICD10CM);
    default:
      return module;
    }
  }

  private boolean hasVersionParameter(ValueSetExpansionComponent expansion) {
    for (ValueSetExpansionParameterComponent p : expansion.getParameter()) {
      if (p.getName().equals("version"))
        return true;
    }
    return false;
  }

  private void addDesignationRow(ValueSetExpansionContainsComponent c, XhtmlNode t, List<String> langs, Map<String, String> designations) {
    XhtmlNode tr = t.tr();
    tr.td().addText(c.getCode());
    addDesignationsToRow(c, designations, tr);
    addLangaugesToRow(c, langs, tr);
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      addDesignationRow(cc, t, langs, designations);
    }
  }

  public void addDesignationsToRow(ValueSetExpansionContainsComponent c, Map<String, String> designations, XhtmlNode tr) {
    for (String url : designations.keySet()) {
      String d = null;
      if (d == null) {
        for (ConceptReferenceDesignationComponent dd : c.getDesignation()) {
          if (url.equals(getUrlForDesignation(dd))) {
            d = dd.getValue();
          }
        }
      }
      tr.td().addText(d == null ? "" : d);
    }
  }

  public void addLangaugesToRow(ValueSetExpansionContainsComponent c, List<String> langs, XhtmlNode tr) {
    for (String lang : langs) {
      String d = null;
      for (Extension ext : c.getExtension()) {
        if (ExtensionDefinitions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String l = ExtensionUtilities.readStringExtension(ext, "lang");
          if (lang.equals(l)) {
            d = ExtensionUtilities.readStringExtension(ext, "content");
          }
        }
      }
      if (d == null) {
        for (ConceptReferenceDesignationComponent dd : c.getDesignation()) {
          String l = dd.getLanguage();
          if (lang.equals(l)) {
            d = dd.getValue();
          }
        }
      }
      tr.td().addText(d == null ? "" : d);
    }
  }

  
  private boolean checkDoDefinition(ValueSet source, List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      CodeSystem cs = getFetchedCodeSystem(c.getSystem(), c.getVersion(), source);
      if (cs != null) {
        ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(cs, c.getCode());
        if (cd != null && cd.hasDefinition()) {
          return true;
        }
      }
      if (checkDoDefinition(source, c.getContains()))
        return true;
    }
    return false;
  }

  private CodeSystem getFetchedCodeSystem(String system, String version, ValueSet source) {
    String key = system+"|"+version+"?"+source.getVersionedUrl();
    if (supplementedCodeSystems.containsKey(key)) {
      return supplementedCodeSystems.get(key);
    }
    CodeSystem cs = getContext().getWorker().fetchSupplementedCodeSystem(system, version, source);
    supplementedCodeSystems.put(key, cs);
    return cs;
  }

  private boolean checkDoInactive(List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      if (c.hasInactive()) {
        return true;
      }
      if (checkDoInactive(c.getContains()))
        return true;
    }
    return false;
  }

  private boolean checkDoVersion(List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      if (c.hasVersion()) {
        return true;
      }
      if (checkDoVersion(c.getContains()))
        return true;
    }
    return false;
  }


  private boolean allFromOneSystem(ValueSet vs) {
    if (vs.getExpansion().getContains().isEmpty())
      return false;
    String system = vs.getExpansion().getContains().get(0).getSystem();
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      if (!checkSystemMatches(system, cc))
        return false;
    }
    return true;
  }

  private String getCsRef(ValueSet source, String system, String version) {
    CodeSystem cs = getFetchedCodeSystem(system, version, source);
    return getCsRef(cs);
  }

  private  <T extends Resource> String getCsRef(T cs) {
    if (cs == null) {
      return "?cs-n?";
    }
    String ref = cs.getWebPath();
    if (ref == null) {
      ref = cs.getUserString(UserDataNames.render_filename);
    }
    return ref == null ? null : ref.replace("\\", "/");
  }

  private void scanForDesignations(ValueSet vs, ValueSetExpansionContainsComponent c, List<String> langs, Map<String, String> designations) {
    for (Extension ext : c.getExtension()) {
      if (ExtensionDefinitions.EXT_TRANSLATION.equals(ext.getUrl())) {
        String lang = ExtensionUtilities.readStringExtension(ext,  "lang");
        if (!Utilities.noString(lang) && !langs.contains(lang) && !isBaseLang(vs, lang)) {
          langs.add(lang);
        }
      }
    }
    if (context.getDesignationMode() != DesignationMode.NONE) {
      for (ConceptReferenceDesignationComponent d : c.getDesignation()) {
        String lang = d.getLanguage();
        if (!Utilities.noString(lang)) {
          if (!langs.contains(lang)) {
            langs.add(lang);
          }
        } else if (context.getDesignationMode() == DesignationMode.ALL) {
          // can we present this as a designation that we know?
          String disp = getDisplayForDesignation(d);
          String url = getUrlForDesignation(d);
          if (disp == null) {
            disp = getDisplayForUrl(url);
          }
          if (disp != null && !designations.containsKey(url) && url != null) {
            designations.put(url, disp);
          }
        }
      }
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      scanForDesignations(vs, cc, langs, designations);
    }
  }

  private boolean isBaseLang(ValueSet vs, String lang) {
    return (isDefLang(lang) && isDefLang(vs.getLanguage())) || langsMatch(lang, vs.getLanguage());
  }

  private boolean isDefLang(String lang) {
    return lang == null || "en".equals(lang) || "en-US".equals(lang);
  }

  private void scanForLangs(ValueSetExpansionContainsComponent c, List<String> langs) {
    for (Extension ext : c.getExtension()) {
      if (ExtensionDefinitions.EXT_TRANSLATION.equals(ext.getUrl())) {
        String lang = ExtensionUtilities.readStringExtension(ext,  "lang");
        if (!Utilities.noString(lang) && !langs.contains(lang)) {
          langs.add(lang);
        }
      }
    }
    for (ConceptReferenceDesignationComponent d : c.getDesignation()) {
      String lang = d.getLanguage();
      if (!Utilities.noString(lang) && !langs.contains(lang)) {
        langs.add(lang);
      }
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      scanForLangs(cc, langs);
    }    
  }

  private void addExpansionRowToTable(XhtmlNode t, ValueSet vs, ValueSetExpansionContainsComponent c, int i, boolean doLevel, boolean doDefinition, boolean doInactive, boolean doVersion, List<UsedConceptMap> maps, List<String> langs, Map<String, String> designations, boolean doDesignations, Map<String, String> properties, ResourceWrapper res) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = t.tr();
    if (ValueSetUtilities.isDeprecated(vs, c)) {
      tr.setAttribute("style", "background-color: #ffeeee");
    }
      
    XhtmlNode td = tr.td();

    String tgt = makeAnchor(c.getSystem(), c.getCode());
    String pfx = res.getScopedId();
    td.an((context.prefixAnchor(pfx == null ? "" : pfx+"-")+tgt));

    if (doLevel) {
      td.addText(Integer.toString(i));
      td = tr.td();
    }
    if (context.isOids()) {
      td.addText(getOid(c.getSystem(), c.getVersion(), vs));
    } else {
      td.code().tx(c.getSystem());
    }
    if (doVersion) {
      td = tr.td();
      td.addText(c.getVersion());
    }
    td = tr.td();
    String s = Utilities.padLeft("", '\u00A0', i*2);
    td.attribute("style", "white-space:nowrap").addText(s);
    addCodeToTable(vs, c.getAbstract(), c.getSystem(), c.getVersion(), c.getCode(), c.getDisplay(), td);
    td = tr.td();
    if (c.hasDisplayElement())
      td.addText(c.getDisplay());

    if (doInactive) {
      td = tr.td();
      if (c.getInactive()) {
        td.tx(context.formatPhrase(RenderingContext.VALUE_SET_INACT));
      }
    }
    if (doDefinition) {
      td = tr.td();
      CodeSystem cs = getFetchedCodeSystem(c.getSystem(), c.getVersion(), vs);
      if (cs != null) {
        String defn = CodeSystemUtilities.getCodeDefinition(cs, c.getCode());
        if (hasMarkdownInDefinitions(cs)) {
          addMarkdown(td, defn, cs.getWebPath());
        } else {
          td.tx(defn);
        }
      }
    }
    for (String n  : Utilities.sorted(properties.keySet())) {
      td = tr.td();
      String ps = getPropertyValue(c, n); 
      if (!Utilities.noString(ps)) {  
        td.addText(ps);        
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
        XhtmlNode span = td.span(null, mapping.comp.getRelationship().toString());
        span.addText(getCharForRelationship(mapping.comp));
        addRefToCode(td, mapping.group.getTarget(), m.getLink(), mapping.comp.getCode(), null, vs);
        if (!Utilities.noString(mapping.comp.getComment()))
          td.i().tx("("+mapping.comp.getComment()+")");
      }
    }
    if (doDesignations) {
      addDesignationsToRow(c, designations, tr);
      addLangaugesToRow(c, langs, tr);
    }

    if (context.forPublisher()) {
      XhtmlNode ispan = tr.td().spanClss("copy-text-inline");
      String json = makeJson(c, getVersionForSystem(vs.getExpansion().getParameter(), c.getSystem()));
      ispan.button("btn-copy", context.formatPhrase(RenderingContext.STRUC_DEF_COPY_CODING)).attribute("data-clipboard-text", json).tx(" ");
      ispan = tr.td().spanClss("copy-text-inline");
      String xml = makeXml(c, getVersionForSystem(vs.getExpansion().getParameter(), c.getSystem()));
      ispan.button("btn-copy", context.formatPhrase(RenderingContext.STRUC_DEF_COPY_CODING)).attribute("data-clipboard-text", xml).tx(" ");
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      addExpansionRowToTable(t, vs, cc, i+1, doLevel, doDefinition, doInactive, doVersion, maps, langs, designations, doDesignations, properties, res);
    }
  }

  private String getVersionForSystem(List<ValueSetExpansionParameterComponent> parameter, String system) {
    for (ValueSetExpansionParameterComponent p : parameter) {
      if (p.hasValue() && p.getValue().isPrimitive()) {
        if (p.getValue().primitiveValue().startsWith(system+"|")) {
          return p.getValue().primitiveValue().substring(system.length()+1);
        }
      }
    }
    return null;
  }

  private String makeJson(ValueSetExpansionContainsComponent c, String version) {
    StringBuilder b = new StringBuilder();
    b.append("{");
    b.append("\"system\": \""+ Utilities.escapeJson(c.getSystem())+"\"");
    if (c.hasVersion()) {
      b.append(", \"version\": \""+ Utilities.escapeJson(c.getVersion())+"\"");
    } else if (version != null) {
      b.append(", \"version\": \""+ Utilities.escapeJson(version)+"\"");
    }
    if (c.hasCode()) {
      b.append(", \"code\": \""+ Utilities.escapeJson(c.getCode())+"\"");
    }
    if (c.hasDisplay()) {
      b.append(", \"display\": \""+ Utilities.escapeJson(c.getDisplay())+"\"");
    }
    b.append("}");
    return b.toString();
  }

  private String makeXml(ValueSetExpansionContainsComponent c, String version) {
    StringBuilder b = new StringBuilder();
    b.append("<coding>");
    b.append("<system value=\""+ Utilities.escapeXml(c.getSystem())+"\">");
    if (c.hasVersion()) {
      b.append("<version value=\""+ Utilities.escapeXml(c.getVersion())+"\">");
    } else if (version != null) {
      b.append("<version value=\""+ Utilities.escapeXml(version)+"\">");
    }
    if (c.hasCode()) {
      b.append("<code value=\""+ Utilities.escapeXml(c.getCode())+"\">");
    }
    if (c.hasDisplay()) {
      b.append("<display value=\""+ Utilities.escapeXml(c.getDisplay())+"\">");
    }
    b.append("</coding>");
    return b.toString();
  }


  private boolean hasMarkdownInDefinitions(CodeSystem cs) {
    if (!cs.hasUserData(UserDataNames.CS_MARKDOWN_FLAG)) {
      if (cs.hasExtension("http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown")) {
        cs.setUserData(UserDataNames.CS_MARKDOWN_FLAG, ExtensionUtilities.readBoolExtension(cs, "http://hl7.org/fhir/StructureDefinition/codesystem-use-markdown"));
      } else {
        cs.setUserData(UserDataNames.CS_MARKDOWN_FLAG, CodeSystemUtilities.hasMarkdownInDefinitions(cs, context.getMarkdown()));
      }
    }
    return (Boolean) cs.getUserData(UserDataNames.CS_MARKDOWN_FLAG);
  }
  
  private String getOid(String system, String version, ValueSet vs) {
    if (oidMap == null) {
      oidMap = new HashMap<>();
    }
    String oid = oidMap.get(system);
    if (oid == null) {
      CodeSystem cs = getFetchedCodeSystem(system, version, vs);
      if (cs != null) {
        oid = CodeSystemUtilities.getOID(cs);
      }
      if (oid == null) {
        oid = system;
      }
      oidMap.put(system, oid);
    }
    return oid;
  }

  private String getPropertyValue(ValueSetExpansionContainsComponent c, String n) {
    for (ConceptPropertyComponent  cp : c.getProperty()) {
      if (n.equals(cp.getCode())) {
        return cp.getValue().primitiveValue();
      }
    }
    return null;
  }

  private boolean checkSystemMatches(String system, ValueSetExpansionContainsComponent cc) {
    if (!system.equals(cc.getSystem()))
      return false;
    for (ValueSetExpansionContainsComponent cc1 : cc.getContains()) {
      if (!checkSystemMatches(system, cc1))
        return false;
    }
     return true;
  }

  private void addCodeToTable(ValueSet vs, boolean isAbstract, String system, String version, String code, String display, XhtmlNode td) {
    CodeSystem e = getFetchedCodeSystem(system, version, vs);
    if (e == null || (e.getContent() != org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.COMPLETE && e.getContent() != org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.FRAGMENT)) {
      if (isAbstract)
        td.i().setAttribute("title", context.formatPhrase(RenderingContext.VS_ABSTRACT_CODE_HINT)).addText(code);
      else if ("http://snomed.info/sct".equals(system)) {
        td.ah(context.prefixLocalHref(SnomedUtilities.getSctLink(version, code, context.getContext().getExpansionParameters()))).addText(code);
      } else if ("http://loinc.org".equals(system)) {
          td.ah(context.prefixLocalHref(LoincLinker.getLinkForCode(code))).addText(code);
      } else        
        td.addText(code);
    } else {
      String href = context.fixReference(getCsRef(e));
      if (href == null) {
        td.code().tx(code);        
      } else {
        if (href.contains("#"))
          href = href + "-"+Utilities.nmtokenize(code);
        else
          href = href + "#"+e.getId()+"-"+Utilities.nmtokenize(code);
        if (isAbstract)
          td.ah(context.prefixLocalHref(href)).setAttribute("title", context.formatPhrase(RenderingContext.VS_ABSTRACT_CODE_HINT)).i().addText(code);
        else
          td.ah(context.prefixLocalHref(href)).addText(code);
      }
    }
  }

  private void addRefToCode(XhtmlNode td, String target, String vslink, String code, String version, ValueSet vs) {
    addCodeToTable(vs, false, target, version, code, null, td);
//    CodeSystem cs = getContext().getWorker().fetchCodeSystem(target);
//    String cslink = getCsRef(cs);
//    String link = cslink != null ? cslink+"#"+cs.getId()+"-"+code : vslink+"#"+code;
//    if (!Utilities.isAbsoluteUrl(link)) {
//      link = getContext().getSpecificationLink()+link;
//    }
//    XhtmlNode a = td.ah(context.prefixLocalHref(link));
//    a.addText(code);
  }

  private void generateComposition(RenderingStatus status, ResourceWrapper res, XhtmlNode x, ValueSet vs, boolean header, List<UsedConceptMap> maps) throws FHIRException, IOException {
    List<String> langs = new ArrayList<String>();
    Map<String, String> designations = new HashMap<>(); //  map of url = description, where url is the designation code. Designations that are for languages won't make it into this list 
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      scanDesignations(inc, langs, designations);
    }
    for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
      scanDesignations(inc, langs, designations);
    }
    boolean doDesignations = langs.size() + designations.size() < MAX_DESIGNATIONS_IN_LINE;
    
    if (header) {
      XhtmlNode h = x.h2();
      h.addText(vs.present());
      addMarkdown(x, vs.getDescription());
      if (vs.hasCopyrightElement())
        generateCopyright(x, res);
    }
    int index = 0;
    if (vs.getCompose().getInclude().size() == 1 && vs.getCompose().getExclude().size() == 0 && !VersionComparisonAnnotation.hasDeleted(vs.getCompose(), "include", "exclude")) {
      genInclude(status, x.ul(), vs.getCompose().getInclude().get(0), "Include", langs, doDesignations, maps, designations, index, vs);
    } else {
      XhtmlNode p = x.para();
      p.tx(context.formatPhrase(RenderingContext.VALUE_SET_RULES_INC));
      XhtmlNode ul = x.ul();
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        genInclude(status, ul, inc, context.formatPhrase(RenderingContext.VALUE_SET_INC), langs, doDesignations, maps, designations, index, vs);
        index++;
      }
      for (Base inc : VersionComparisonAnnotation.getDeleted(vs.getCompose(), "include")) {
        genInclude(status, ul, (ConceptSetComponent) inc, context.formatPhrase(RenderingContext.VALUE_SET_INC), langs, doDesignations, maps, designations, index, vs);
        index++;
      }
      if (vs.getCompose().hasExclude() || VersionComparisonAnnotation.hasDeleted(vs.getCompose(), "exclude")) {
        p = x.para();
        p.tx(context.formatPhrase(RenderingContext.VALUE_SET_RULES_EXC));
        ul = x.ul();
        for (ConceptSetComponent exc : vs.getCompose().getExclude()) {
          genInclude(status, ul, exc, context.formatPhrase(RenderingContext.VALUE_SET_EXCL), langs, doDesignations, maps, designations, index, vs);
          index++;
        }
        for (Base inc : VersionComparisonAnnotation.getDeleted(vs.getCompose(), "exclude")) {
          genInclude(status, ul, (ConceptSetComponent) inc, context.formatPhrase(RenderingContext.VALUE_SET_EXCL), langs, doDesignations, maps, designations, index, vs);
          index++;
        }
      }
    }
    
    // now, build observed languages

    if (!doDesignations && langs.size() + designations.size() > 0) {
      Collections.sort(langs);
      if (designations.size() == 0) {
        x.para().b().tx(context.formatPhrase(RenderingContext.GENERAL_ADD_LANG));        
      } else if (langs.size() == 0) {
        x.para().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_DESIG));       
      } else {
        x.para().b().tx(context.formatPhrase(RenderingContext.VALUE_SET_ADD_DESIG));
      }
      XhtmlNode t = x.table("codes", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = t.tr();
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
      for (String url : designations.keySet()) {
        tr.td().b().addText(designations.get(url));
      }
      for (String lang : langs) {
        tr.td().b().addText(describeLang(lang));
      }
      for (ConceptSetComponent c : vs.getCompose().getInclude()) {
        for (ConceptReferenceComponent cc : c.getConcept()) {
          addDesignationRow(cc, t, langs, designations);
        }
      }
    }
  }

  private void renderExpansionRules(XhtmlNode x, ConceptSetComponent inc, int index, Map<String, ConceptDefinitionComponent> definitions) throws FHIRException, IOException {
    String s = context.formatPhrase(RenderingContext.VALUE_SET_NOT_DEF);
    if (inc.hasExtension(ExtensionDefinitions.EXT_EXPAND_RULES)) {
      String rule = inc.getExtensionString(ExtensionDefinitions.EXT_EXPAND_RULES);
      if (rule != null) {
        switch (rule) {
        case "all-codes": s = context.formatPhrase(RenderingContext.VALUE_SET_ALL_CODE); 
        case "ungrouped": s = context.formatPhrase(RenderingContext.VALUE_SET_NOT_FOUND);
        case "groups-only": s = context.formatPhrase(RenderingContext.VALUE_SET_CONT_STRUC);
        }
      }
    }
    x.br();
    x.tx(s);
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, context.getDestDir(), context.isInlineGraphics(), true, "exp");
    TableModel model = gen.new TableModel("exp.h="+index, context.getRules() == GenerationRules.IG_PUBLISHER);    
    model.setAlternating(true);
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.GENERAL_CODE), context.formatPhrase(RenderingContext.VALUE_SET_CODE_ITEM), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), context.formatPhrase(RenderingContext.TX_DISPLAY), context.formatPhrase(RenderingContext.VALUE_SET_DISPLAY_ITEM), null, 0));

    for (Extension ext : inc.getExtensionsByUrl(ExtensionDefinitions.EXT_EXPAND_GROUP)) {
      renderExpandGroup(gen, model, ext, inc, definitions);
    }
    x.br();
    x.tx("table"); 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null);
    x.addChildNode(xn);
  }

  private void renderExpandGroup(HierarchicalTableGenerator gen, TableModel model, Extension ext, ConceptSetComponent inc, Map<String, ConceptDefinitionComponent> definitions) {
    Row row = gen.new Row(); 
    model.getRows().add(row);
    row.setIcon("icon_entry_blue.png", "entry");
    String code = ext.getExtensionString("code");
    if (code != null) {
      row.getCells().add(gen.new Cell(null, null, code, null, null));
      row.getCells().add(gen.new Cell(null, null, getDisplayForCode(inc, code, definitions), null, null));
    } else if (ext.hasId()) {      
      row.getCells().add(gen.new Cell(null, null, "(#"+ext.getId()+")", null, null));      
      row.getCells().add(gen.new Cell(null, null, ext.getExtensionString("display"), null, null));
    } else {
      row.getCells().add(gen.new Cell(null, null, null, null, null));      
      row.getCells().add(gen.new Cell(null, null, ext.getExtensionString("display"), null, null));
    }
    for (Extension member : ext.getExtensionsByUrl("member")) {
      Row subRow = gen.new Row(); 
      row.getSubRows().add(subRow);
      subRow.setIcon("icon_entry_blue.png", "entry");
      String mc = member.getValue().primitiveValue();
      // mc might be a reference to another expansion group - we check that first, or to a code in the compose
      if (mc.startsWith("#")) {
        // it's a reference by id
        subRow.getCells().add(gen.new Cell(null, null, "("+mc+")", null, null));      
        subRow.getCells().add(gen.new Cell(null, null, "group reference by id", null, null));
      } else {
        Extension tgt = findTargetByCode(inc, mc);
        if (tgt != null) {
          subRow.getCells().add(gen.new Cell(null, null, mc, null, null));      
          subRow.getCells().add(gen.new Cell(null, null, "group reference by code", null, null));                    
        } else {
          subRow.getCells().add(gen.new Cell(null, null, mc, null, null));      
          subRow.getCells().add(gen.new Cell(null, null, getDisplayForCode(inc, mc, definitions), null, null));          
        }
      }
    }
  }

  private Extension findTargetByCode(ConceptSetComponent inc, String mc) {
    for (Extension ext : inc.getExtensionsByUrl(ExtensionDefinitions.EXT_EXPAND_GROUP)) {
      String code = ext.getExtensionString("code");
      if (mc.equals(code)) {
        return ext;
      }
    }
    return null;
  }

  private String getDisplayForCode(ConceptSetComponent inc, String code, Map<String, ConceptDefinitionComponent> definitions) {
    for (ConceptReferenceComponent cc : inc.getConcept()) {
      if (code.equals(cc.getCode())) {
        if (cc.hasDisplay()) {
          return cc.getDisplay();
        }
      }
    }
    if (definitions.containsKey(code)) {
      return definitions.get(code).getDisplay();
    }
    return null;
  }

  private void scanDesignations(ConceptSetComponent inc, List<String> langs, Map<String, String> designations) {
    for (ConceptReferenceComponent cc : inc.getConcept()) {
      for (Extension ext : cc.getExtension()) {
        if (ExtensionDefinitions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String lang = ExtensionUtilities.readStringExtension(ext,  "lang");
          if (!Utilities.noString(lang) && !langs.contains(lang)) {
            langs.add(lang);
          }
        }
      }
      for (ConceptReferenceDesignationComponent d : cc.getDesignation()) {
        String lang = d.getLanguage();
        if (!Utilities.noString(lang) && !langs.contains(lang)) {
          langs.add(lang);
        } else {
          // can we present this as a designation that we know?
          String disp = getDisplayForDesignation(d);
          String url = getUrlForDesignation(d);
          if (disp == null) {
            disp = getDisplayForUrl(url);
          }
          if (disp != null && !designations.containsKey(url)) {
            designations.put(url, disp);            
          }
        }
      }
    }
  }

  private String getDisplayForUrl(String url) {
    if (url == null) {
      return null;
    }
    switch (url) {
    case "http://snomed.info/sct#900000000000003001":
      return context.formatPhrase(RenderingContext.VALUE_SET_SPEC_NAME);
    case "http://snomed.info/sct#900000000000013009":
      return context.formatPhrase(RenderingContext.VALUE_SET_SYNONYM);
    case "http://terminology.hl7.org/CodeSystem/designation-usage#display":
      return context.formatPhrase(RenderingContext.VALUE_SET_OTHER_DISPLAY);
    case "http://terminology.hl7.org/CodeSystem/hl7TermMaintInfra#preferredForLanguage":
      return context.formatPhrase(RenderingContext.VALUE_SET_OTHER_DISPLAY);
    default:
      // As specified in http://www.hl7.org/fhir/valueset-definitions.html#ValueSet.compose.include.concept.designation.use and in http://www.hl7.org/fhir/codesystem-definitions.html#CodeSystem.concept.designation.use the terminology binding is extensible.
      return url;
    }
  }

  private String getUrlForDesignation(ConceptReferenceDesignationComponent d) {
    if (d.hasUse() && d.getUse().hasSystem() && d.getUse().hasCode()) {
      return d.getUse().getSystem()+"#"+d.getUse().getCode();
    } else {
      return null;
    }
  }

  private String getDisplayForDesignation(ConceptReferenceDesignationComponent d) {
    if (d.hasUse() && d.getUse().hasDisplay()) {
      return d.getUse().getDisplay();
    } else {
      return null;
    }
  }

  private void genInclude(RenderingStatus status, XhtmlNode ul, ConceptSetComponent inc, String type, List<String> langs, boolean doDesignations, List<UsedConceptMap> maps, Map<String, String> designations, int index, ValueSet vsRes) throws FHIRException, IOException {
    XhtmlNode li;
    li = ul.li();
    li = renderStatus(inc, li);

    Map<String, ConceptDefinitionComponent> definitions = new HashMap<>();
    
    if (inc.hasSystem()) {
      CodeSystem e = getContext().getWorker().findTxResource(CodeSystem.class, inc.getSystem(), inc.getVersion(), vsRes);
      if (inc.getConcept().size() == 0 && inc.getFilter().size() == 0) {
        li.addText(type+" "+ context.formatPhrase(RenderingContext.VALUE_SET_ALL_CODES_DEF) + " ");
        addCsRef(inc, li, e);
      } else {
        if (inc.getConcept().size() > 0) {
          li.addText(type+" "+ context.formatPhrase(RenderingContext.VALUE_SET_THESE_CODES_DEF) + " ");
          addCsRef(inc, li, e);


          // for performance reasons, we do all the fetching in one batch
          definitions = getConceptsForCodes(e, inc, vsRes, index);

          
          XhtmlNode t = li.table("none", false).markGenerated(!context.forValidResource());
          boolean hasComments = false;
          boolean hasDefinition = false;
          for (ConceptReferenceComponent c : inc.getConcept()) {
            hasComments = hasComments || ExtensionHelper.hasExtension(c, ExtensionDefinitions.EXT_VS_COMMENT);
            ConceptDefinitionComponent cc = definitions == null ? null : definitions.get(c.getCode()); 
            hasDefinition = hasDefinition || ((cc != null && cc.hasDefinition()) || ExtensionHelper.hasExtension(c, ExtensionDefinitions.EXT_DEFINITION));
          }
          if (hasComments || hasDefinition) {
            status.setExtensions(true);
          }
          addMapHeaders(addTableHeaderRowStandard(t, false, true, hasDefinition, hasComments, false, false, null, langs, designations, doDesignations), maps);
          for (ConceptReferenceComponent c : inc.getConcept()) {
            renderConcept(inc, langs, doDesignations, maps, designations, definitions, t, hasComments, hasDefinition, c, inc.getVersion(), vsRes);
          }
          for (Base b : VersionComparisonAnnotation.getDeleted(inc, "concept" )) {
            renderConcept(inc, langs, doDesignations, maps, designations, definitions, t, hasComments, hasDefinition, (ConceptReferenceComponent) b, inc.getVersion(), vsRes);
          }
        }
        if (inc.getFilter().size() > 0) {
          li.addText(type+" "+ context.formatPhrase(RenderingContext.VALUE_SET_CODES_FROM));
          addCsRef(inc, li, e);
          li.tx(" "+ context.formatPhrase(RenderingContext.VALUE_SET_WHERE)+" ");
          for (int i = 0; i < inc.getFilter().size(); i++) {
            ConceptSetFilterComponent f = inc.getFilter().get(i);
            if (i > 0) {
              if (i == inc.getFilter().size()-1) {
                li.tx(" "+ context.formatPhrase(RenderingContext.VALUE_SET_AND)+" ");
              } else {
                li.tx(context.formatPhrase(RenderingContext.VALUE_SET_COMMA)+" ");
              }
            }
            XhtmlNode wli = renderStatus(f, li);
            if (f.getOp() == FilterOperator.EXISTS) {
              if (f.getValue().equals("true")) {
                wli.tx(f.getProperty()+" "+ context.formatPhrase(RenderingContext.VALUE_SET_EXISTS));
              } else {
                wli.tx(f.getProperty()+" "+ context.formatPhrase(RenderingContext.VALUE_SET_DOESNT_EXIST));
              }
            } else {
              wli.tx(f.getProperty()+" "+describe(f.getOp())+" ");
              if (f.getValueElement().hasExtension(ExtensionDefinitions.EXT_CQF_EXP)) {
                Extension expE = f.getValueElement().getExtensionByUrl(ExtensionDefinitions.EXT_CQF_EXP);
                Expression exp = expE.getValueExpression();
                wli.addText("(as calculated by ");
                wli.code().tx(exp.getExpression());
                wli.addText(")");
              } else {
                if (e != null && codeExistsInValueSet(e, f.getValue())) {
                  String href = getContext().fixReference(getCsRef(e));
                  if (href == null) {
                    wli.code().tx(f.getValue());                  
                  } else {
                    if (href.contains("#"))
                      href = href + "-"+Utilities.nmtokenize(f.getValue());
                    else
                      href = href + "#"+e.getId()+"-"+Utilities.nmtokenize(f.getValue());
                    wli.ah(context.prefixLocalHref(href)).addText(f.getValue());
                  }
                } else if (inc.hasSystem()) {
                  wli.addText(f.getValue());
                  ValidationResult vr = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions(), inc.getSystem(), inc.getVersion(), f.getValue(), null);
                  if (vr.isOk() && vr.getDisplay() != null) {
                    wli.tx(" ("+vr.getDisplay()+")");
                  }
                } else {
                  wli.addText(f.getValue());
                }
              }
              String disp = ExtensionUtilities.getDisplayHint(f);
              if (disp != null)
                wli.tx(" ("+disp+")");
            }
          }
        }
      }
      if (inc.hasValueSet()) {
        li.tx(context.formatPhrase(RenderingContext.VALUE_SET_WHERE_CODES)+" ");
        boolean first = true;
        for (UriType vs : inc.getValueSet()) {
          if (first)
            first = false;
          else
            li.tx(", ");
          XhtmlNode wli = renderStatus(vs, li);
          AddVsRef(vs.asStringValue(), wli, vsRes);
        }
      }
      if (inc.hasExtension(ExtensionDefinitions.EXT_EXPAND_RULES) || inc.hasExtension(ExtensionDefinitions.EXT_EXPAND_GROUP)) {
        status.setExtensions(true);
        renderExpansionRules(li, inc, index, definitions);
      }
    } else {
      li.tx(context.formatMessagePlural(inc.getValueSet().size(), RenderingContext.VALUE_SET_IMPORT)+" ");
      if (inc.getValueSet().size() <= 2) {
        int i = 0;  
        for (UriType vs : inc.getValueSet()) {
          if (i > 0) {
            if ( i  < inc.getValueSet().size() - 1) {
              li.tx(", ");
            } else {
              li.tx(" and ");              
            }
          }
          i++;
          XhtmlNode wli = renderStatus(vs, li);
          AddVsRef(vs.asStringValue(), wli, vsRes);
        }
      } else {
        XhtmlNode xul = li.ul();
        for (UriType vs : inc.getValueSet()) {
          XhtmlNode wli = renderStatus(vs,  xul.li());
          AddVsRef(vs.asStringValue(), wli, vsRes);
        }
        
      }
    }
  }

  private void renderConcept(ConceptSetComponent inc, List<String> langs, boolean doDesignations,
      List<UsedConceptMap> maps, Map<String, String> designations, Map<String, ConceptDefinitionComponent> definitions,
      XhtmlNode t, boolean hasComments, boolean hasDefinition, ConceptReferenceComponent c, String version, ValueSet vs) {
    XhtmlNode tr = t.tr();
    XhtmlNode td = renderStatusRow(c, t, tr);
    ConceptDefinitionComponent cc = definitions == null ? null : definitions.get(c.getCode()); 
    addCodeToTable(vs, false, inc.getSystem(), version, c.getCode(), c.hasDisplay()? c.getDisplay() : cc != null ? cc.getDisplay() : "", td);

    td = tr.td();
    if (!Utilities.noString(c.getDisplay()))
      renderStatus(c.getDisplayElement(), td).addText(c.getDisplay());
    else if (VersionComparisonAnnotation.hasDeleted(c, "display")) {
      StringType d = (StringType) VersionComparisonAnnotation.getDeletedItem(c, "display"); 
      renderStatus(d, td).addText(d.primitiveValue());
    } else if (cc != null && !Utilities.noString(cc.getDisplay()))
      td.style("color: #cccccc").addText(cc.getDisplay());

    if (hasDefinition) {
      td = tr.td();
      if (ExtensionHelper.hasExtension(c, ExtensionDefinitions.EXT_DEFINITION)) {
        td.addTextWithLineBreaks(ExtensionUtilities.readStringExtension(c, ExtensionDefinitions.EXT_DEFINITION));
      } else if (cc != null && !Utilities.noString(cc.getDefinition())) {
        td.addTextWithLineBreaks(cc.getDefinition());
      }
    }
    if (hasComments) {
      td = tr.td();
      if (ExtensionHelper.hasExtension(c, ExtensionDefinitions.EXT_VS_COMMENT)) {
        td.addTextWithLineBreaks(context.formatPhrase(RenderingContext.VALUE_SET_NOTE, ExtensionUtilities.readStringExtension(c, ExtensionDefinitions.EXT_VS_COMMENT)+" "));
      }
    }
    if (doDesignations) {
      addDesignationsToRow(c, designations, tr);
      addLangaugesToRow(c, langs, tr);
    }
    for (UsedConceptMap m : maps) {
      td = tr.td();
      List<TargetElementComponentWrapper> mappings = findMappingsForCode(c.getCode(), m.getMap());
      boolean first = true;
      for (TargetElementComponentWrapper mapping : mappings) {
        if (!first)
            td.br();
        first = false;
        XhtmlNode span = td.span(null, mapping.comp.getRelationship().toString());
        span.addText(getCharForRelationship(mapping.comp));
        addRefToCode(td, mapping.group.getTarget(), m.getLink(), mapping.comp.getCode(), version, vs);
        if (!Utilities.noString(mapping.comp.getComment()))
          td.i().tx("("+mapping.comp.getComment()+")");
      }
    }
  }

  public void addDesignationsToRow(ConceptReferenceComponent c, Map<String, String> designations, XhtmlNode tr) {
    for (String url : designations.keySet()) {
      String d = null;
      if (d == null) {
        for (ConceptReferenceDesignationComponent dd : c.getDesignation()) {
          if (url.equals(getUrlForDesignation(dd))) {
            d = dd.getValue();
          }
        }
      }
      tr.td().addText(d == null ? "" : d);
    }
  }

  public void addLangaugesToRow(ConceptReferenceComponent c, List<String> langs, XhtmlNode tr) {
    for (String lang : langs) {
      String d = null;
      for (Extension ext : c.getExtension()) {
        if (ExtensionDefinitions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String l = ExtensionUtilities.readStringExtension(ext, "lang");
          if (lang.equals(l)) {
            d = ExtensionUtilities.readStringExtension(ext, "content");
          }
        }
      }
      if (d == null) {
        for (ConceptReferenceDesignationComponent dd : c.getDesignation()) {
          String l = dd.getLanguage();
          if (lang.equals(l)) {
            d = dd.getValue();
          }
        }
      }
      tr.td().addText(d == null ? "" : d);
    }
  }


  private Map<String, ConceptDefinitionComponent> getConceptsForCodes(CodeSystem e, ConceptSetComponent inc, ValueSet source, int index) {
    if (e == null) {
      e = getFetchedCodeSystem(inc.getSystem(), inc.getVersion(), source);
    }
    
    ValueSetExpansionComponent vse = null;
    if (!context.isNoSlowLookup()) { // && !getContext().getWorker().hasCache()) { removed GG 20220107 like what is this trying to do?
      try {
        
        ValueSet vs = new ValueSet();
        vs.setUrl(source.getUrl()+"-inc-"+index);
        vs.setStatus(PublicationStatus.ACTIVE);
        vs.setCompose(new ValueSetComposeComponent());
        vs.getCompose().setInactive(false);
        vs.getCompose().getInclude().add(inc);
        
        ValueSetExpansionOutcome vso = getContext().getWorker().expandVS(ExpansionOptions.cacheNoHeirarchy().withLanguage(context.getLocale().getLanguage()), vs);
        ValueSet valueset = vso.getValueset();
        if (valueset == null)
          throw new TerminologyServiceException(context.formatPhrase(RenderingContext.VALUE_SET_ERROR, vso.getError()+" "));
        vse = valueset.getExpansion();        

      } catch (Exception e1) {
        return null;
      }
    }
    
    Map<String, ConceptDefinitionComponent> results = new HashMap<>();
    List<CodingValidationRequest> serverList = new ArrayList<>();
    
    // 1st pass, anything we can resolve internally
    for (ConceptReferenceComponent cc : inc.getConcept()) {
      String code = cc.getCode();
      ConceptDefinitionComponent v = null;
      if (e != null && code != null) {
        v = getConceptForCode(e.getConcept(), code);
      }
      if (v == null && vse != null) {
        v = getConceptForCodeFromExpansion(vse.getContains(), code);
      }
      if (v != null) {
        results.put(code, v);
      } else {
        serverList.add(new CodingValidationRequest(new Coding(inc.getSystem(), code, null)));
      }
    }
    if (!context.isNoSlowLookup() && !serverList.isEmpty()) {
      try {
        // todo: split this into 10k batches 
        int i = 0;
        while (serverList.size() > i) { 
          int len = Integer.min(serverList.size(), MAX_BATCH_VALIDATION_SIZE);
          List<CodingValidationRequest> list = serverList.subList(i, i+len);
          i += len;
          getContext().getWorker().validateCodeBatch(getContext().getTerminologyServiceOptions(), list, null, true);
          for (CodingValidationRequest vr : list) {
            ConceptDefinitionComponent v = vr.getResult().asConceptDefinition();
            if (v != null) {
              results.put(vr.getCoding().getCode(), v);
            }
          }
        }
      } catch (Exception e1) {
        return null;
      }
    }
    return results;
  }
  
  private ConceptDefinitionComponent getConceptForCode(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
    if (code.equals(c.getCode()))
      return c;
      ConceptDefinitionComponent v = getConceptForCode(c.getConcept(), code);
      if (v != null)
        return v;
    }
    return null;
  }

  private ConceptDefinitionComponent getConceptForCodeFromExpansion(List<ValueSetExpansionContainsComponent> list, String code) {
    for (ValueSetExpansionContainsComponent c : list) {
      if (code.equals(c.getCode())) {
        ConceptDefinitionComponent res = new ConceptDefinitionComponent();
        res.setCode(c.getCode());
        res.setDisplay(c.getDisplay());
        return res;
      }
      ConceptDefinitionComponent v = getConceptForCodeFromExpansion(c.getContains(), code);
      if (v != null)
        return v;
    }
    return null;
  }

 
  private boolean codeExistsInValueSet(CodeSystem cs, String code) {
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      if (inConcept(code, c))
        return true;
    }
    return false;
  }
  


  private void addDesignationRow(ConceptReferenceComponent c, XhtmlNode t, List<String> langs, Map<String, String> designations) {
    XhtmlNode tr = t.tr();
    tr.td().addText(c.getCode());
    addDesignationsToRow(c, designations, tr);
    addLangaugesToRow(c, langs, tr);
  }


  private String describe(FilterOperator op) {
    if (op == null)
      return " "+ context.formatPhrase(RenderingContext.VALUE_SET_NULL);
    switch (op) {
    case EQUAL: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_EQUAL);
    case ISA: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_ISA);
    case ISNOTA: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_ISNOTA);
    case REGEX: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_REGEX);
    case NULL: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_NULLS);
    case IN: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_IN);
    case NOTIN: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_NOTIN);
    case DESCENDENTOF: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_DESCENDENTOF);
    case EXISTS: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_EXISTS);
    case GENERALIZES: return " "+ context.formatPhrase(RenderingContext.VALUE_SET_GENERALIZES);
    }
    return null;
  }

  private boolean inConcept(String code, ConceptDefinitionComponent c) {
    if (c.hasCodeElement() && c.getCode().equals(code))
      return true;
    for (ConceptDefinitionComponent g : c.getConcept()) {
      if (inConcept(code, g))
        return true;
    }
    return false;
  }


  @Override
  protected void genSummaryTableContent(RenderingStatus status, XhtmlNode tbl, CanonicalResource cr) throws IOException {
    super.genSummaryTableContent(status, tbl, cr);
    
    ValueSet vs = (ValueSet) cr;
    XhtmlNode tr;

    if (CodeSystemUtilities.hasOID(vs)) {
      tr = tbl.tr();
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_OID)+":");
      tr.td().tx(context.formatPhrase(RenderingContext.CODE_SYS_FOR_OID, CodeSystemUtilities.getOID(vs)));
    }
  }

}