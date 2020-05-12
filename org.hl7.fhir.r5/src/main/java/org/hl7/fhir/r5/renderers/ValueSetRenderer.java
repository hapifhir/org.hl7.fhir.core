package org.hl7.fhir.r5.renderers;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ExtensionHelper;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ValueSetRenderer extends TerminologyRenderer {

  public ValueSetRenderer(RenderingContext context) {
    super(context);
  }

  public ValueSetRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  private static final String ABSTRACT_CODE_HINT = "This code is not selectable ('Abstract')";

  private List<ConceptMapRenderInstructions> renderingMaps = new ArrayList<ConceptMapRenderInstructions>();

  public boolean render(XhtmlNode x, DomainResource dr) throws FHIRFormatError, DefinitionException, IOException {
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
    for (CanonicalResource md : getContext().getWorker().allConformanceResources()) {
      if (md instanceof ConceptMap) {
        ConceptMap cm = (ConceptMap) md;
        if (isSource(vs, cm.getSource())) {
          ConceptMapRenderInstructions re = findByTarget(cm.getTarget());
          if (re != null) {
            ValueSet vst = cm.hasTarget() ? getContext().getWorker().fetchResource(ValueSet.class, cm.hasTargetCanonicalType() ? cm.getTargetCanonicalType().getValue() : cm.getTargetUriType().asStringValue()) : null;
            res.add(new UsedConceptMap(re, vst == null ? cm.getUserString("path") : vst.getUserString("path"), cm));
          }
        }
      }
    }
    return res;
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
    if (ToolingExtensions.hasExtension(vs.getExpansion(), ToolingExtensions.EXT_EXP_FRAGMENT)) {
      XhtmlNode div = x.div().style("border: maroon 1px solid; background-color: #FFCCCC; padding: 8px");
      List<Extension> exl = vs.getExpansion().getExtensionsByUrl(ToolingExtensions.EXT_EXP_FRAGMENT);
      if (exl.size() > 1) {
        div.para().addText("Warning: this expansion is generated from fragments of the following code systems, and may be missing codes, or include codes that are not valid:");
        XhtmlNode ul = div.ul();
        for (Extension ex : exl) {
          addCSRef(ul.li(), ex.getValue().primitiveValue());
        }
      } else {
        XhtmlNode p = div.para();
        p.addText("Warning: this expansion is generated from a fragment of the code system ");
        addCSRef(p, exl.get(0).getValue().primitiveValue());
        p.addText(" and may be missing codes, or include codes that are not valid");
      }
    }

    generateVersionNotice(x, vs.getExpansion());

    CodeSystem allCS = null;
    boolean doLevel = false;
    for (ValueSetExpansionContainsComponent cc : vs.getExpansion().getContains()) {
      if (cc.hasContains()) {
        doLevel = true;
        break;
      }
    }
    
    boolean doSystem = true; // checkDoSystem(vs, src);
    boolean doDefinition = checkDoDefinition(vs.getExpansion().getContains());
    if (doSystem && allFromOneSystem(vs)) {
      doSystem = false;
      XhtmlNode p = x.para();
      p.tx("All codes from system ");
      allCS = getContext().getWorker().fetchCodeSystem(vs.getExpansion().getContains().get(0).getSystem());
      String ref = null;
      if (allCS != null)
        ref = getCsRef(allCS);
      if (ref == null)
        p.code(vs.getExpansion().getContains().get(0).getSystem());
      else
        p.ah(getContext().getPrefix()+ref).code(vs.getExpansion().getContains().get(0).getSystem());
    }
    XhtmlNode t = x.table( "codes");
    XhtmlNode tr = t.tr();
    if (doLevel)
      tr.td().b().tx("Lvl");
    tr.td().attribute("style", "white-space:nowrap").b().tx("Code");
    if (doSystem)
      tr.td().b().tx("System");
    tr.td().b().tx("Display");
    if (doDefinition)
      tr.td().b().tx("Definition");

    addMapHeaders(tr, maps);
    for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
      addExpansionRowToTable(t, c, 0, doLevel, doSystem, doDefinition, maps, allCS, langs);
    }

    // now, build observed languages

    if (langs.size() > 0) {
      Collections.sort(langs);
      x.para().b().tx("Additional Language Displays");
      t = x.table( "codes");
      tr = t.tr();
      tr.td().b().tx("Code");
      for (String lang : langs)
        tr.td().b().addText(describeLang(lang));
      for (ValueSetExpansionContainsComponent c : vs.getExpansion().getContains()) {
        addLanguageRow(c, t, langs);
      }
    }

    return hasExtensions;
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
    if (src != null)
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
    } else if (cs.hasUserData("path")) {
      x.ah(cs.getUserString("path")).tx(cs.present());
    } else {
      x.code(url);
      x.tx(" ("+cs.present()+")");
    }
  }

  @SuppressWarnings("rawtypes")
  private void generateVersionNotice(XhtmlNode x, ValueSetExpansionComponent expansion) {
    Multimap<String, String> versions = HashMultimap.create();
    for (ValueSetExpansionParameterComponent p : expansion.getParameter()) {
      if (p.getName().equals("version")) {
        String[] parts = ((PrimitiveType) p.getValue()).asStringValue().split("\\|");
        if (parts.length == 2)
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
            XhtmlNode p = x.para().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
            p.tx("Expansion based on ");
            expRef(p, s, v);
          }
        } else {
          for (String v : versions.get(s)) {
            if (first) {
              div = x.div().style("border: black 1px dotted; background-color: #EEEEEE; padding: 8px; margin-bottom: 8px");
              div.para().tx("Expansion based on: ");
              ul = div.ul();
              first = false;
            }
            expRef(ul.li(), s, v);
          }
        }
      }
    }
  }

  private void expRef(XhtmlNode x, String u, String v) {
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
    } else {
      CanonicalResource cr = (CanonicalResource) getContext().getWorker().fetchResource(Resource.class, u+"|"+v);
      if (cr != null) {
        if (cr.hasUserData("path")) {
          x.ah(cr.getUserString("path")).tx(cr.present()+" v"+v+" ("+cr.fhirType()+")");          
        } else {
          x.tx(describeSystem(u)+" v"+v+" ("+cr.fhirType()+")");
        }
      } else {
        x.tx(describeSystem(u)+" version "+v);
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

  private void addLanguageRow(ValueSetExpansionContainsComponent c, XhtmlNode t, List<String> langs) {
    XhtmlNode tr = t.tr();
    tr.td().addText(c.getCode());
    for (String lang : langs) {
      String d = null;
      for (Extension ext : c.getExtension()) {
        if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
          String l = ToolingExtensions.readStringExtension(ext, "lang");
          if (lang.equals(l))
            d = ToolingExtensions.readStringExtension(ext, "content");
        }
      }
      tr.td().addText(d == null ? "" : d);
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      addLanguageRow(cc, t, langs);
    }
  }

  
  private boolean checkDoDefinition(List<ValueSetExpansionContainsComponent> contains) {
    for (ValueSetExpansionContainsComponent c : contains) {
      CodeSystem cs = getContext().getWorker().fetchCodeSystem(c.getSystem());
      if (cs != null)
        return true;
      if (checkDoDefinition(c.getContains()))
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
    String ref = (String) cs.getUserData("filename");
    if (ref == null)
      ref = (String) cs.getUserData("path");
    if (ref == null)
      return "?ngen-14?.html";
    if (!ref.contains(".html"))
      ref = ref + ".html";
    return ref.replace("\\", "/");
  }

  private void addExpansionRowToTable(XhtmlNode t, ValueSetExpansionContainsComponent c, int i, boolean doLevel, boolean doSystem, boolean doDefinition, List<UsedConceptMap> maps, CodeSystem allCS, List<String> langs) {
    XhtmlNode tr = t.tr();
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
    if (doSystem) {
      td = tr.td();
      td.addText(c.getSystem());
    }
    td = tr.td();
    if (c.hasDisplayElement())
      td.addText(c.getDisplay());

    if (doDefinition) {
      CodeSystem cs = allCS;
      if (cs == null)
        cs = getContext().getWorker().fetchCodeSystem(c.getSystem());
      td = tr.td();
      if (cs != null)
        td.addText(CodeSystemUtilities.getCodeDefinition(cs, c.getCode()));
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
    for (Extension ext : c.getExtension()) {
      if (ToolingExtensions.EXT_TRANSLATION.equals(ext.getUrl())) {
        String lang = ToolingExtensions.readStringExtension(ext,  "lang");
        if (!Utilities.noString(lang) && !langs.contains(lang))
          langs.add(lang);
      }
    }
    for (ValueSetExpansionContainsComponent cc : c.getContains()) {
      addExpansionRowToTable(t, cc, i+1, doLevel, doSystem, doDefinition, maps, allCS, langs);
    }
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
    if (e == null || e.getContent() != org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.COMPLETE) {
      if (isAbstract)
        td.i().setAttribute("title", ABSTRACT_CODE_HINT).addText(code);
      else if ("http://snomed.info/sct".equals(system)) {
        td.ah(sctLink(code)).addText(code);
      } else if ("http://loinc.org".equals(system)) {
          td.ah("http://details.loinc.org/LOINC/"+code+".html").addText(code);
      } else        
        td.addText(code);
    } else {
      String href = getContext().getPrefix()+getCsRef(e);
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
    return "http://browser.ihtsdotools.org/?perspective=full&conceptId1="+code;
  }

  private void addRefToCode(XhtmlNode td, String target, String vslink, String code) {
    CodeSystem cs = getContext().getWorker().fetchCodeSystem(target);
    String cslink = getCsRef(cs);
    XhtmlNode a = null;
    if (cslink != null) 
      a = td.ah(getContext().getPrefix()+cslink+"#"+cs.getId()+"-"+code);
    else
      a = td.ah(getContext().getPrefix()+vslink+"#"+code);
    a.addText(code);
  }

  private boolean generateComposition(XhtmlNode x, ValueSet vs, boolean header, List<UsedConceptMap> maps) throws FHIRException, IOException {
    boolean hasExtensions = false;
    List<String> langs = new ArrayList<String>();

    if (header) {
      XhtmlNode h = x.h2();
      h.addText(vs.present());
      addMarkdown(x, vs.getDescription());
      if (vs.hasCopyrightElement())
        generateCopyright(x, vs);
    }
    if (vs.getCompose().getInclude().size() == 1 && vs.getCompose().getExclude().size() == 0) {
      hasExtensions = genInclude(x.ul(), vs.getCompose().getInclude().get(0), "Include", langs, maps) || hasExtensions;
    } else {
      XhtmlNode p = x.para();
      p.tx("This value set includes codes based on the following rules:");
      XhtmlNode ul = x.ul();
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        hasExtensions = genInclude(ul, inc, "Include", langs, maps) || hasExtensions;
      }
      for (ConceptSetComponent exc : vs.getCompose().getExclude()) {
        hasExtensions = genInclude(ul, exc, "Exclude", langs, maps) || hasExtensions;
      }
    }
    
    // now, build observed languages

    if (langs.size() > 0) {
      Collections.sort(langs);
      x.para().b().tx("Additional Language Displays");
      XhtmlNode t = x.table( "codes");
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Code");
      for (String lang : langs)
        tr.td().b().addText(describeLang(lang));
      for (ConceptSetComponent c : vs.getCompose().getInclude()) {
        for (ConceptReferenceComponent cc : c.getConcept()) {
          addLanguageRow(cc, t, langs);
        }
      }
    }

    return hasExtensions;
  }

  private boolean genInclude(XhtmlNode ul, ConceptSetComponent inc, String type, List<String> langs, List<UsedConceptMap> maps) throws FHIRException, IOException {
    boolean hasExtensions = false;
    XhtmlNode li;
    li = ul.li();
    CodeSystem e = getContext().getWorker().fetchCodeSystem(inc.getSystem());

    if (inc.hasSystem()) {
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

          XhtmlNode t = li.table("none");
          boolean hasComments = false;
          boolean hasDefinition = false;
          for (ConceptReferenceComponent c : inc.getConcept()) {
            hasComments = hasComments || ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_VS_COMMENT);
            hasDefinition = hasDefinition || ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_DEFINITION);
          }
          if (hasComments || hasDefinition)
            hasExtensions = true;
          addMapHeaders(addTableHeaderRowStandard(t, false, true, hasDefinition, hasComments, false, false, null), maps);
          for (ConceptReferenceComponent c : inc.getConcept()) {
            XhtmlNode tr = t.tr();
            XhtmlNode td = tr.td();
            ConceptDefinitionComponent cc = getConceptForCode(e, c.getCode(), inc);
            addCodeToTable(false, inc.getSystem(), c.getCode(), c.hasDisplay()? c.getDisplay() : cc != null ? cc.getDisplay() : "", td);

            td = tr.td();
            if (!Utilities.noString(c.getDisplay()))
              td.addText(c.getDisplay());
            else if (cc != null && !Utilities.noString(cc.getDisplay()))
              td.addText(cc.getDisplay());

            td = tr.td();
            if (ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_DEFINITION))
              smartAddText(td, ToolingExtensions.readStringExtension(c, ToolingExtensions.EXT_DEFINITION));
            else if (cc != null && !Utilities.noString(cc.getDefinition()))
              smartAddText(td, cc.getDefinition());

            if (ExtensionHelper.hasExtension(c, ToolingExtensions.EXT_VS_COMMENT)) {
              smartAddText(tr.td(), "Note: "+ToolingExtensions.readStringExtension(c, ToolingExtensions.EXT_VS_COMMENT));
            }
            for (ConceptReferenceDesignationComponent cd : c.getDesignation()) {
              if (cd.hasLanguage() && !langs.contains(cd.getLanguage()))
                langs.add(cd.getLanguage());
            }
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
            if (f.getOp() == FilterOperator.EXISTS) {
              if (f.getValue().equals("true")) {
                li.tx(f.getProperty()+" exists");
              } else {
                li.tx(f.getProperty()+" doesn't exist");
              }
            } else {
              li.tx(f.getProperty()+" "+describe(f.getOp())+" ");
              if (e != null && codeExistsInValueSet(e, f.getValue())) {
                String href = getContext().getPrefix()+getCsRef(e);
                if (href.contains("#"))
                  href = href + "-"+Utilities.nmtokenize(f.getValue());
                else
                  href = href + "#"+e.getId()+"-"+Utilities.nmtokenize(f.getValue());
                li.ah(href).addText(f.getValue());
              } else if ("concept".equals(f.getProperty()) && inc.hasSystem()) {
                li.addText(f.getValue());
                ValidationResult vr = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions(), inc.getSystem(), f.getValue(), null);
                if (vr.isOk()) {
                  li.tx(" ("+vr.getDisplay()+")");
                }
              }
              else
                li.addText(f.getValue());
              String disp = ToolingExtensions.getDisplayHint(f);
              if (disp != null)
                li.tx(" ("+disp+")");
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
          AddVsRef(vs.asStringValue(), li);
        }
      }
    } else {
      li.tx("Import all the codes that are contained in ");
      boolean first = true;
      for (UriType vs : inc.getValueSet()) {
        if (first)
          first = false;
        else
          li.tx(", ");
        AddVsRef(vs.asStringValue(), li);
      }
    }
    return hasExtensions;
  }


  private ConceptDefinitionComponent getConceptForCode(CodeSystem e, String code, ConceptSetComponent inc) {
    if (code == null) {
      return null;
    }
    // first, look in the code systems
    if (e == null)
    e = getContext().getWorker().fetchCodeSystem(inc.getSystem());
    if (e != null) {
      ConceptDefinitionComponent v = getConceptForCode(e.getConcept(), code);
      if (v != null)
        return v;
    }

    if (noSlowLookup)
      return null;
    
    if (!getContext().getWorker().hasCache()) {
      ValueSetExpansionComponent vse;
      try {
        ValueSetExpansionOutcome vso = getContext().getWorker().expandVS(inc, false);   
        ValueSet valueset = vso.getValueset();
        if (valueset == null)
          throw new TerminologyServiceException("Error Expanding ValueSet: "+vso.getError());
        vse = valueset.getExpansion();        

      } catch (TerminologyServiceException e1) {
        return null;
      }
      if (vse != null) {
        ConceptDefinitionComponent v = getConceptForCodeFromExpansion(vse.getContains(), code);
      if (v != null)
        return v;
    }
    }

    return getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions(), inc.getSystem(), code, null).asConceptDefinition();
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
  

  private void addLanguageRow(ConceptReferenceComponent c, XhtmlNode t, List<String> langs) {
    XhtmlNode tr = t.tr();
    tr.td().addText(c.getCode());
    for (String lang : langs) {
      String d = null;
      for (ConceptReferenceDesignationComponent cd : c.getDesignation()) {
        String l = cd.getLanguage();
        if (lang.equals(l))
          d = cd.getValue();
      }
      tr.td().addText(d == null ? "" : d);
    }
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