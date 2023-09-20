package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation;
import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.r5.context.IWorkerContext.CodingValidationRequest;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.context.TerminologyCache.CacheToken;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ExtensionHelper;
import org.hl7.fhir.r5.model.Parameters;
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
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.ValueSetUtilities;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.LoincLinker;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ibm.icu.impl.locale.StringTokenIterator;

public class ValueSetRenderer extends TerminologyRenderer {

  public ValueSetRenderer(RenderingContext context) {
    super(context);
  }

  public ValueSetRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  private static final String ABSTRACT_CODE_HINT = "This code is not selectable ('Abstract')";

  private static final int MAX_DESIGNATIONS_IN_LINE = 5;

  private List<ConceptMapRenderInstructions> renderingMaps = new ArrayList<ConceptMapRenderInstructions>();

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (ValueSet) dr, false);
  }
  

  public boolean render(XhtmlNode x, ValueSet vs, boolean header) throws FHIRFormatError, DefinitionException, IOException {
    List<UsedConceptMap> maps = findReleventMaps(vs);
    
    boolean hasExtensions;
    if (vs.hasExpansion()) {
      // for now, we just accept an expansion if there is one
      hasExtensions = generateExpansion(x, vs, header, maps);
    } else {
      hasExtensions = generateComposition(x, vs, header, maps);
    }
    return hasExtensions;
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
          ValueSet vst = cm.hasTargetScope() ? getContext().getWorker().fetchResource(ValueSet.class, cm.hasTargetScopeCanonicalType() ? cm.getTargetScopeCanonicalType().getValue() : cm.getTargetScopeUriType().asStringValue(), cm) : null;
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
//    ValueSet vsr = context.getWorker().fetchResource(ValueSet.class, ((Reference) a.getTarget()).getReference());
//    if (vsr != null)
//      url = (String) vsr.getUserData("filename");
//    mymaps.put(a, url);
//  }
//    Map<ConceptMap, String> mymaps = new HashMap<ConceptMap, String>();
//  for (ConceptMap a : context.getWorker().findMapsForSource(cs.getValueSet())) {
//    String url = "";
//    ValueSet vsr = context.getWorker().fetchResource(ValueSet.class, ((Reference) a.getTarget()).getReference());
//    if (vsr != null)
//      url = (String) vsr.getUserData("filename");
//    mymaps.put(a, url);
//  }
    // also, look in the contained resources for a concept map
//    for (Resource r : cs.getContained()) {
//      if (r instanceof ConceptMap) {
//        ConceptMap cm = (ConceptMap) r;
//        if (((Reference) cm.getSource()).getReference().equals(cs.getValueSet())) {
//          String url = "";
//          ValueSet vsr = context.getWorker().fetchResource(ValueSet.class, ((Reference) cm.getTarget()).getReference());
//          if (vsr != null)
//              url = (String) vsr.getUserData("filename");
//        mymaps.put(cm, url);
//        }
//      }
//    }
  }  
  
  private boolean isSource(ValueSet vs, DataType source) {
    return vs.hasUrl() && source != null && vs.getUrl().equals(source.primitiveValue());
  }  
  
  private boolean generateExpansion(XhtmlNode x, ValueSet vs, boolean header, List<UsedConceptMap> maps) throws FHIRFormatError, DefinitionException, IOException {
    boolean hasExtensions = false;
    List<String> langs = new ArrayList<String>();
    Map<String, String> designations = new HashMap<>(); //  map of url = description, where url is the designation code. Designations that are for languages won't make it into this list
    Map<String, String> properties = new HashMap<>(); //  map of url = description, where url is the designation code. Designations that are for languages won't make it into this list

    if (header) {
      XhtmlNode h = x.addTag(getHeader());
      h.tx("Value Set Contents");
      if (IsNotFixedExpansion(vs))
        addMarkdown(x, vs.getDescription());
      if (vs.hasCopyright())
        generateCopyright(x, vs);
    }
    if (ToolingExtensions.hasExtension(vs.getExpansion(), ToolingExtensions.EXT_EXP_TOOCOSTLY)) {
      List<Extension> exl = vs.getExpansion().getExtensionsByUrl(ToolingExtensions.EXT_EXP_TOOCOSTLY);
      boolean other = false;
      for (Extension ex : exl) {
        if (ex.getValue() instanceof BooleanType) {
          x.para().style("border: maroon 1px solid; background-color: #FFCCCC; font-weight: bold; padding: 8px").addText(vs.getExpansion().getContains().isEmpty() ? getContext().getTooCostlyNoteEmpty() : getContext().getTooCostlyNoteNotEmpty());
        } else if (!other) {
          x.para().style("border: maroon 1px solid; background-color: #FFCCCC; font-weight: bold; padding: 8px").addText(vs.getExpansion().getContains().isEmpty() ? getContext().getTooCostlyNoteEmptyDependent() : getContext().getTooCostlyNoteNotEmptyDependent());
          other = true;
        }
      }
    } else {
      Integer count = countMembership(vs);
      if (count == null)
        x.para().tx("This value set does not contain a fixed number of concepts");
      else
        x.para().tx("This value set contains "+count.toString()+" concepts");
    }
    
    generateContentModeNotices(x, vs.getExpansion(), vs);
    generateVersionNotice(x, vs.getExpansion(), vs);

    boolean doLevel = false;
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      if (cc.hasContains()) {
        doLevel = true;
        break;
      }
    }
    boolean doInactive = checkDoInactive(vs.getExpansion().getContains());    
    boolean doDefinition = checkDoDefinition(vs.getExpansion().getContains());
    
    XhtmlNode t = x.table( "codes");
    XhtmlNode tr = t.tr();
    if (doLevel)
      tr.td().b().tx("Level");
    tr.td().attribute("style", "white-space:nowrap").b().tx("Code");
    tr.td().b().tx("System");
    XhtmlNode tdDisp = tr.td();
    tdDisp.b().tx("Display");
    boolean doDesignations = false;
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      scanForDesignations(c, langs, designations);
    }
    scanForProperties(vs.getExpansion(), langs, properties);
    if (doInactive) {
      tr.td().b().tx("Inactive");
    }
    if (doDefinition) {
      tr.td().b().tx("Definition");
      doDesignations = false;
      for (String n : Utilities.sorted(properties.keySet())) {
        tr.td().b().ah(properties.get(n)).addText(n);        
      }
    } else {
      for (String n : Utilities.sorted(properties.keySet())) {
        tr.td().b().ah(properties.get(n)).addText(n);        
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
          tr.td().b().addText(describeLang(lang));
        }
      }
    }

    
    addMapHeaders(tr, maps);
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      addExpansionRowToTable(t, vs, c, 1, doLevel, doDefinition, doInactive, maps, langs, designations, doDesignations, properties);
    }

    // now, build observed languages

    if (!doDesignations && langs.size() + designations.size() > 0) {
      Collections.sort(langs);
      if (designations.size() == 0) {
        x.para().b().tx("Additional Language Displays");
      } else if (langs.size() == 0) {
        x.para().b().tx("Additional Designations");
      } else {
        x.para().b().tx("Additional Designations and Language Displays");
      }
      t = x.table("codes");
      tr = t.tr();
      tr.td().b().tx("Code");
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

    return hasExtensions;
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

  private void generateContentModeNotices(XhtmlNode x, ValueSetExpansionComponent expansion, Resource vs) {
    generateContentModeNotice(x, expansion, "example", "Expansion based on example code system", vs); 
    generateContentModeNotice(x, expansion, "fragment", "Expansion based on code system fragment", vs); 
  }
  
  private void generateContentModeNotice(XhtmlNode x, ValueSetExpansionComponent expansion, String mode, String text, Resource vs) {
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
          }
        } else {
          for (String v : versions.get(s)) {
            if (first) {
              div = x.div().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
              div.para().tx(text+"s: ");
              ul = div.ul();
              first = false;
            }
            expRef(ul.li(), s, v, vs);
          }
        }
      }
    }
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
      count = count + conceptCount(vs.getExpansion().getContains());
    else {
      if (vs.hasCompose()) {
        if (vs.getCompose().hasExclude()) {
          try {
            ValueSetExpansionOutcome vse = getContext().getWorker().expandVS(vs, true, false);
            count = 0;
            count += conceptCount(vse.getValueset().getExpansion().getContains());
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

  private int conceptCount(List<ValueSetExpansionContainsComponent> list) {
    int count = 0;
    for (ValueSetExpansionContainsComponent c : list) {
      if (!c.getAbstract())
        count++;
      count = count + conceptCount(c.getContains());
    }
    return count;
  }

  private void addCSRef(XhtmlNode x, String url) {
    CodeSystem cs = getContext().getWorker().fetchCodeSystem(url);
    if (cs == null) {
      x.code(url);
    } else if (cs.hasWebPath()) {
      x.ah(cs.getWebPath()).tx(cs.present());
    } else {
      x.code(url);
      x.tx(" ("+cs.present()+")");
    }
  }

  @SuppressWarnings("rawtypes")
  private void generateVersionNotice(XhtmlNode x, ValueSetExpansionComponent expansion, Resource vs) {
    Multimap<String, String> versions = HashMultimap.create();
    for (ValueSetExpansionParameterComponent p : expansion.getParameter()) {
      if (p.getName().startsWith("used-") || p.getName().equals("version")) {
        String name = p.getName().equals("version") ? "system" : p.getName().substring(5);
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
            p.tx("Expansion based on ");
            expRef(p, s, v, vs);
          }
        } else {
          for (String v : versions.get(s)) {
            if (first) {
              div = x.div().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
              div.para().tx("Expansion based on: ");
              ul = div.ul();
              first = false;
            }
            expRef(ul.li(), s, v, vs);
          }
        }
      }
    }
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
          x.tx("SNOMED CT "+m+" edition "+formatSCTDate(parts[6]));
        } else {
          x.tx("SNOMED CT "+m+" edition");
        }
      } else {
        x.tx(describeSystem(u)+" version "+v);
      }
    } else if (u.equals("http://loinc.org")) {
      String vd = describeLoincVer(v);
      if (vd != null) {
        x.tx("Loinc v"+v+" ("+vd+")");
      } else {
        x.tx("Loinc v"+v);        
      }
    } else if (Utilities.noString(v)) {
      CanonicalResource cr = (CanonicalResource) getContext().getWorker().fetchResource(Resource.class, u, source);
      if (cr != null) {
        if (cr.hasWebPath()) {
          x.ah(cr.getWebPath()).tx(t+" "+cr.present()+" (no version) ("+cr.fhirType()+")");          
        } else {
          x.tx(t+" "+describeSystem(u)+" (no version) ("+cr.fhirType()+")");
        }
      } else {
        x.tx(t+" "+describeSystem(u)+" (no version)");
      }
    } else {
      CanonicalResource cr = (CanonicalResource) getContext().getWorker().fetchResource(Resource.class, u+"|"+v, source);
      if (cr != null) {
        if (cr.hasWebPath()) {
          x.ah(cr.getWebPath()).tx(t+" "+cr.present()+" v"+v+" ("+cr.fhirType()+")");          
        } else {
          x.tx(t+" "+describeSystem(u)+" v"+v+" ("+cr.fhirType()+")");
        }
      } else {
        x.tx(t+" "+describeSystem(u)+" version "+v);
      }
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
    if ("900000000000207008".equals(module))
      return "International";
    if ("731000124108".equals(module))
      return "United States";
    if ("32506021000036107".equals(module))
      return "Australian";
    if ("449081005".equals(module))
      return "Spanish";
    if ("554471000005108".equals(module))
      return "Danish";
    if ("11000146104".equals(module))
      return "Dutch";
    if ("45991000052106".equals(module))
      return "Swedish";
    if ("999000041000000102".equals(module))
      return "United Kingdon";
    return module;
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
        if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String l = ToolingExtensions.readStringExtension(ext, "lang");
          if (lang.equals(l)) {
            d = ToolingExtensions.readStringExtension(ext, "content");
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

  
  private boolean checkDoDefinition(List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      CodeSystem cs = getContext().getWorker().fetchCodeSystem(c.getSystem());
      if (cs != null) {
        ConceptDefinitionComponent cd = CodeSystemUtilities.getCode(cs, c.getCode());
        if (cd != null && cd.hasDefinition()) {
          return true;
        }
      }
      if (checkDoDefinition(c.getContains()))
        return true;
    }
    return false;
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

  private String getCsRef(String system) {
    CodeSystem cs = getContext().getWorker().fetchCodeSystem(system);
    return getCsRef(cs);
  }

  private  <T extends Resource> String getCsRef(T cs) {
    if (cs == null) {
      return "?cs-n?";
    }
    String ref = (String) cs.getUserData("filename");
    if (ref == null)
      ref = (String) cs.getWebPath();
    if (ref == null)
      return "?ngen-14?.html";
    if (!ref.contains(".html"))
      ref = ref + ".html";
    return ref.replace("\\", "/");
  }

  private void scanForDesignations(ValueSetExpansionContainsComponent c, List<String> langs, Map<String, String> designations) {
    for (Extension ext : c.getExtension()) {
      if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
        String lang = ToolingExtensions.readStringExtension(ext,  "lang");
        if (!Utilities.noString(lang) && !langs.contains(lang)) {
          langs.add(lang);
        }
      }
    }
    for (ConceptReferenceDesignationComponent d : c.getDesignation()) {
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
        if (disp != null && !designations.containsKey(url) && url != null) {
          designations.put(url, disp);
        }
      }
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      scanForDesignations(cc, langs, designations);
    }
  }

  private void scanForLangs(ValueSetExpansionContainsComponent c, List<String> langs) {
    for (Extension ext : c.getExtension()) {
      if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
        String lang = ToolingExtensions.readStringExtension(ext,  "lang");
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

  private void addExpansionRowToTable(XhtmlNode t, ValueSet vs, ValueSetExpansionContainsComponent c, int i, boolean doLevel, boolean doDefinition, boolean doInactive, List<UsedConceptMap> maps, List<String> langs, Map<String, String> designations, boolean doDesignations, Map<String, String> properties) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tr = t.tr();
    if (ValueSetUtilities.isDeprecated(vs, c)) {
      tr.setAttribute("style", "background-color: #ffeeee");
    }
      
    XhtmlNode td = tr.td();

    String tgt = makeAnchor(c.getSystem(), c.getCode());
    td.an(tgt);

    if (doLevel) {
      td.addText(Integer.toString(i));
      td = tr.td();
    }
    String s = Utilities.padLeft("", '\u00A0', i*2);
    td.attribute("style", "white-space:nowrap").addText(s);
    addCodeToTable(c.getAbstract(), c.getSystem(), c.getCode(), c.getDisplay(), td);
    td = tr.td();
    td.addText(c.getSystem());
    td = tr.td();
    if (c.hasDisplayElement())
      td.addText(c.getDisplay());

    if (doInactive) {
      td = tr.td();
      if (c.getInactive()) {
        td.tx("inactive");
      }
    }
    if (doDefinition) {
      td = tr.td();
      CodeSystem cs = getContext().getWorker().fetchCodeSystem(c.getSystem());
      if (cs != null) {
        String defn = CodeSystemUtilities.getCodeDefinition(cs, c.getCode());
        addMarkdown(td, defn, cs.getWebPath());
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
        addRefToCode(td, mapping.group.getTarget(), m.getLink(), mapping.comp.getCode()); 
        if (!Utilities.noString(mapping.comp.getComment()))
          td.i().tx("("+mapping.comp.getComment()+")");
      }
    }
    if (doDesignations) {
      addDesignationsToRow(c, designations, tr);
      addLangaugesToRow(c, langs, tr);
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      addExpansionRowToTable(t, vs, cc, i+1, doLevel, doDefinition, doInactive, maps, langs, designations, doDesignations, properties);
    }
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

  private void addCodeToTable(boolean isAbstract, String system, String code, String display, XhtmlNode td) {
    CodeSystem e = getContext().getWorker().fetchCodeSystem(system);
    if (e == null || (e.getContent() != org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.COMPLETE && e.getContent() != org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.FRAGMENT)) {
      if (isAbstract)
        td.i().setAttribute("title", ABSTRACT_CODE_HINT).addText(code);
      else if ("http://snomed.info/sct".equals(system)) {
        td.ah(sctLink(code)).addText(code);
      } else if ("http://loinc.org".equals(system)) {
          td.ah(LoincLinker.getLinkForCode(code)).addText(code);
      } else        
        td.addText(code);
    } else {
      String href = context.fixReference(getCsRef(e));
      if (href.contains("#"))
        href = href + "-"+Utilities.nmtokenize(code);
      else
        href = href + "#"+e.getId()+"-"+Utilities.nmtokenize(code);
      if (isAbstract)
        td.ah(href).setAttribute("title", ABSTRACT_CODE_HINT).i().addText(code);
      else
        td.ah(href).addText(code);
    }
  }


  public String sctLink(String code) {
//    if (snomedEdition != null)
//      http://browser.ihtsdotools.org/?perspective=full&conceptId1=428041000124106&edition=us-edition&release=v20180301&server=https://prod-browser-exten.ihtsdotools.org/api/snomed&langRefset=900000000000509007
    return "http://snomed.info/id/"+code;
  }

  private void addRefToCode(XhtmlNode td, String target, String vslink, String code) {
    addCodeToTable(false, target, code, null, td);
//    CodeSystem cs = getContext().getWorker().fetchCodeSystem(target);
//    String cslink = getCsRef(cs);
//    String link = cslink != null ? cslink+"#"+cs.getId()+"-"+code : vslink+"#"+code;
//    if (!Utilities.isAbsoluteUrl(link)) {
//      link = getContext().getSpecificationLink()+link;
//    }
//    XhtmlNode a = td.ah(link);
//    a.addText(code);
  }

  private boolean generateComposition(XhtmlNode x, ValueSet vs, boolean header, List<UsedConceptMap> maps) throws FHIRException, IOException {
    boolean hasExtensions = false;
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
        generateCopyright(x, vs);
    }
    int index = 0;
    if (vs.getCompose().getInclude().size() == 1 && vs.getCompose().getExclude().size() == 0 && !VersionComparisonAnnotation.hasDeleted(vs.getCompose(), "include", "exclude")) {
      hasExtensions = genInclude(x.ul(), vs.getCompose().getInclude().get(0), "Include", langs, doDesignations, maps, designations, index, vs) || hasExtensions;
    } else {
      XhtmlNode p = x.para();
      p.tx("This value set includes codes based on the following rules:");
      XhtmlNode ul = x.ul();
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        hasExtensions = genInclude(ul, inc, "Include", langs, doDesignations, maps, designations, index, vs) || hasExtensions;
        index++;
      }
      for (Base inc : VersionComparisonAnnotation.getDeleted(vs.getCompose(), "include")) {
        genInclude(ul, (ConceptSetComponent) inc, "Include", langs, doDesignations, maps, designations, index, vs);
        index++;
      }
      if (vs.getCompose().hasExclude() || VersionComparisonAnnotation.hasDeleted(vs.getCompose(), "exclude")) {
        p = x.para();
        p.tx("This value set excludes codes based on the following rules:");
        ul = x.ul();
        for (ConceptSetComponent exc : vs.getCompose().getExclude()) {
          hasExtensions = genInclude(ul, exc, "Exclude", langs, doDesignations, maps, designations, index, vs) || hasExtensions;
          index++;
        }
        for (Base inc : VersionComparisonAnnotation.getDeleted(vs.getCompose(), "exclude")) {
          genInclude(ul, (ConceptSetComponent) inc, "Exclude", langs, doDesignations, maps, designations, index, vs);
          index++;
        }
      }
    }
    
    // now, build observed languages

    if (!doDesignations && langs.size() + designations.size() > 0) {
      Collections.sort(langs);
      if (designations.size() == 0) {
        x.para().b().tx("Additional Language Displays");        
      } else if (langs.size() == 0) {
        x.para().b().tx("Additional Designations");       
      } else {
        x.para().b().tx("Additional Designations and Language Displays");
      }
      XhtmlNode t = x.table("codes");
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Code");
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

  
    return hasExtensions;
  }

  private void renderExpansionRules(XhtmlNode x, ConceptSetComponent inc, int index, Map<String, ConceptDefinitionComponent> definitions) throws FHIRException, IOException {
    String s = "This include specifies a heirarchy for when value sets are generated for use in a User Interface, but the rules are not properly defined";
    if (inc.hasExtension(ToolingExtensions.EXT_EXPAND_RULES)) {
      String rule = inc.getExtensionString(ToolingExtensions.EXT_EXPAND_RULES);
      if (rule != null) {
        switch (rule) {
        case "all-codes": s = "This include specifies a heirarchy for when value sets are generated for use in a User Interface. The expansion contains all the codes, and also this structure:"; 
        case "ungrouped": s = "This include specifies a heirarchy for when value sets are generated for use in a User Interface. The expansion contains this structure, and any codes not found in the structure:";
        case "groups-only": s = "This include specifies a heirarchy for when value sets are generated for use in a User Interface. The expansion contains this structure:";
        }
      }
    }
    x.br();
    x.tx(s);
    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context.getDestDir(), context.isInlineGraphics(), true);
    TableModel model = gen.new TableModel("exp.h="+index, context.getRules() == GenerationRules.IG_PUBLISHER);    
    model.setAlternating(true);
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("vs.exp.header", "Code"), translate("vs.exp.hint", "The code for the item"), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), translate("vs.exp.header", "Display"), translate("vs.exp.hint", "The display for the item"), null, 0));

    for (Extension ext : inc.getExtensionsByUrl(ToolingExtensions.EXT_EXPAND_GROUP)) {
      renderExpandGroup(gen, model, ext, inc, definitions);
    }
    x.br();
    x.tx("table"); 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null);
    x.getChildNodes().add(xn);
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
    for (Extension ext : inc.getExtensionsByUrl(ToolingExtensions.EXT_EXPAND_GROUP)) {
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
        if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String lang = ToolingExtensions.readStringExtension(ext,  "lang");
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
      return "Fully specified name";
    case "http://snomed.info/sct#900000000000013009":
      return "Synonym";
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

  private boolean genInclude(XhtmlNode ul, ConceptSetComponent inc, String type, List<String> langs, boolean doDesignations, List<UsedConceptMap> maps, Map<String, String> designations, int index, ValueSet vsRes) throws FHIRException, IOException {
    boolean hasExtensions = false;
    XhtmlNode li;
    li = ul.li();
    li = renderStatus(inc, li);

    Map<String, ConceptDefinitionComponent> definitions = new HashMap<>();
    
    if (inc.hasSystem()) {
      CodeSystem e = getContext().getWorker().fetchCodeSystem(inc.getSystem());
      if (inc.getConcept().size() == 0 && inc.getFilter().size() == 0) {
        li.addText(type+" all codes defined in ");
        addCsRef(inc, li, e);
      } else {
        if (inc.getConcept().size() > 0) {
          li.addText(type+" these codes as defined in ");
          addCsRef(inc, li, e);
          if (inc.hasVersion()) {
            li.addText(" version ");
            li.code(inc.getVersion());  
          }

          // for performance reasons, we do all the fetching in one batch
          definitions = getConceptsForCodes(e, inc, vsRes, index);

          
          XhtmlNode t = li.table("none");
          boolean hasComments = false;
          boolean hasDefinition = false;
          for (ConceptReferenceComponent c : inc.getConcept()) {
            hasComments = hasComments || ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_VS_COMMENT);
            ConceptDefinitionComponent cc = definitions == null ? null : definitions.get(c.getCode()); 
            hasDefinition = hasDefinition || ((cc != null && cc.hasDefinition()) || ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_DEFINITION));
          }
          if (hasComments || hasDefinition)
            hasExtensions = true;
          addMapHeaders(addTableHeaderRowStandard(t, false, true, hasDefinition, hasComments, false, false, null, langs, designations, doDesignations), maps);
          for (ConceptReferenceComponent c : inc.getConcept()) {
            renderConcept(inc, langs, doDesignations, maps, designations, definitions, t, hasComments, hasDefinition, c);
          }
          for (Base b : VersionComparisonAnnotation.getDeleted(inc, "concept" )) {
            renderConcept(inc, langs, doDesignations, maps, designations, definitions, t, hasComments, hasDefinition, (ConceptReferenceComponent) b);            
          }
        }
        if (inc.getFilter().size() > 0) {
          li.addText(type+" codes from ");
          addCsRef(inc, li, e);
          li.tx(" where ");
          for (int i = 0; i < inc.getFilter().size(); i++) {
            ConceptSetFilterComponent f = inc.getFilter().get(i);
            if (i > 0) {
              if (i == inc.getFilter().size()-1) {
                li.tx(" and ");
              } else {
                li.tx(", ");
              }
            }
            XhtmlNode wli = renderStatus(f, li);
            if (f.getOp() == FilterOperator.EXISTS) {
              if (f.getValue().equals("true")) {
                wli.tx(f.getProperty()+" exists");
              } else {
                wli.tx(f.getProperty()+" doesn't exist");
              }
            } else {
              wli.tx(f.getProperty()+" "+describe(f.getOp())+" ");
              if (e != null && codeExistsInValueSet(e, f.getValue())) {
                String href = getContext().fixReference(getCsRef(e));
                if (href.contains("#"))
                  href = href + "-"+Utilities.nmtokenize(f.getValue());
                else
                  href = href + "#"+e.getId()+"-"+Utilities.nmtokenize(f.getValue());
                wli.ah(href).addText(f.getValue());
              } else if ("concept".equals(f.getProperty()) && inc.hasSystem()) {
                wli.addText(f.getValue());
                ValidationResult vr = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions(), inc.getSystem(), inc.getVersion(), f.getValue(), null);
                if (vr.isOk()) {
                  wli.tx(" ("+vr.getDisplay()+")");
                }
              }
              else
                wli.addText(f.getValue());
              String disp = ToolingExtensions.getDisplayHint(f);
              if (disp != null)
                wli.tx(" ("+disp+")");
            }
          }
        }
      }
      if (inc.hasValueSet()) {
        li.tx(", where the codes are contained in ");
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
      if (inc.hasExtension(ToolingExtensions.EXT_EXPAND_RULES) || inc.hasExtension(ToolingExtensions.EXT_EXPAND_GROUP)) {
        hasExtensions = true;
        renderExpansionRules(li, inc, index, definitions);
      }
    } else {
      li.tx("Import all the codes that are contained in ");
      if (inc.getValueSet().size() < 4) {
        boolean first = true;
        for (UriType vs : inc.getValueSet()) {
          if (first)
            first = false;
          else
            li.tx(", ");
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
    return hasExtensions;
  }

  private void renderConcept(ConceptSetComponent inc, List<String> langs, boolean doDesignations,
      List<UsedConceptMap> maps, Map<String, String> designations, Map<String, ConceptDefinitionComponent> definitions,
      XhtmlNode t, boolean hasComments, boolean hasDefinition, ConceptReferenceComponent c) {
    XhtmlNode tr = t.tr();
    XhtmlNode td = renderStatusRow(c, t, tr);
    ConceptDefinitionComponent cc = definitions == null ? null : definitions.get(c.getCode()); 
    addCodeToTable(false, inc.getSystem(), c.getCode(), c.hasDisplay()? c.getDisplay() : cc != null ? cc.getDisplay() : "", td);

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
      if (ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_DEFINITION)) {
        smartAddText(td, ToolingExtensions.readStringExtension(c, ToolingExtensions.EXT_DEFINITION));
      } else if (cc != null && !Utilities.noString(cc.getDefinition())) {
        smartAddText(td, cc.getDefinition());
      }
    }
    if (hasComments) {
      td = tr.td();
      if (ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_VS_COMMENT)) {
        smartAddText(td, "Note: "+ToolingExtensions.readStringExtension(c, ToolingExtensions.EXT_VS_COMMENT));
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
        addRefToCode(td, mapping.group.getTarget(), m.getLink(), mapping.comp.getCode()); 
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
        if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String l = ToolingExtensions.readStringExtension(ext, "lang");
          if (lang.equals(l)) {
            d = ToolingExtensions.readStringExtension(ext, "content");
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
      e = getContext().getWorker().fetchCodeSystem(inc.getSystem());
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
        
        ValueSetExpansionOutcome vso = getContext().getWorker().expandVS(vs, true, false);
        ValueSet valueset = vso.getValueset();
        if (valueset == null)
          throw new TerminologyServiceException("Error Expanding ValueSet: "+vso.getError());
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
      getContext().getWorker().validateCodeBatch(getContext().getTerminologyServiceOptions(), serverList, null);
      for (CodingValidationRequest vr : serverList) {
        ConceptDefinitionComponent v = vr.getResult().asConceptDefinition();
        if (v != null) {
          results.put(vr.getCoding().getCode(), v);
        }
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
      return " null ";
    switch (op) {
    case EQUAL: return " = ";
    case ISA: return " is-a ";
    case ISNOTA: return " is-not-a ";
    case REGEX: return " matches (by regex) ";
    case NULL: return " ?ngen-13? ";
    case IN: return " in ";
    case NOTIN: return " not in ";
    case DESCENDENTOF: return " descends from ";
    case EXISTS: return " exists ";
    case GENERALIZES: return " generalizes ";
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


}