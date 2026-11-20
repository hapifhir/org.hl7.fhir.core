package org.hl7.fhir.services.renderers;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class WebTemplateRenderer extends ResourceRenderer {

  private static final String OPENEHR_CODESYSTEM_PREFIX = "https://specifications.openehr.org/fhir/codesystem-";
  
  public WebTemplateRenderer(RenderingContext context) { 
    super(context); 
  } 

  @Override
  public boolean renderingUsesValidation() {
    return true;
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper wt) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(wt, x);

    HierarchicalTableGenerator gen = new HierarchicalTableGenerator(context, context.getDestDir(), context.isInlineGraphics(), true, ""); 
    TableModel model = gen.new TableModel("wt="+wt.getId(), context.getRules() == GenerationRules.IG_PUBLISHER);     
    model.setAlternating(true); 
    if (context.getRules() == GenerationRules.VALID_RESOURCE || context.isInlineGraphics()) { 
      model.setDocoImg(HierarchicalTableGenerator.help16AsData());     
    } else { 
      model.setDocoImg(Utilities.pathURL(context.getLink(KnownLinkType.SPEC, true), "help16.png")); 
    }  
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Name"), (context.formatPhrase(RenderingI18nContext.QUEST_LINK)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Card."), (context.formatPhrase(RenderingI18nContext.QUEST_TEXTFOR)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Description"), (context.formatPhrase(RenderingI18nContext.QUEST_TIMES)), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Type"), (context.formatPhrase(RenderingI18nContext.QUEST_TIMES)), null, 0));
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Inputs"), (context.formatPhrase(RenderingI18nContext.QUEST_TYPE_ITEM)), null, 0));

    String lang = context.getLocale() != null ? context.getLocale().getLanguage() : null;
    String defLang = wt.primitiveValue("defaultLanguage");
    // first we add a root for the WebTemplate itself
    Row row = addItem(gen, model.getRows(), wt.child("tree"), null, lang, defLang);
//    for (ResourceWrapper select : vd.children("select")) { 
//      renderSelect(status, gen, row.getSubRows(), vd, select); 
//    } 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), true, null);
    x.addChildNode(xn); 
 
    
  } 

  private Row addItem(HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper item, String parentRmType, String lang, String defLang) {
    Row r = gen.new Row();
    rows.add(r);

    r.setIcon("icon_vd_view.png", context.formatPhrase(RenderingI18nContext.QUEST_ROOT));
    // Name [archetype_id/nodeId], with the AQL path as the hover hint
    String def = (item.primitiveValue("archetype_id") != null ? item.primitiveValue("archetype_id")+"/" : "")+(item.primitiveValue("nodeId") != null ?item.primitiveValue("nodeId") : "");
    String name = item.primitiveValue("name");
    if (Utilities.noString(name)) {
      name = item.primitiveValue("id");
    }
    // A node without a nodeId is an RM attribute (category, setting, language...): link it to
    // the RM class that declares it, provided the RM logical model really has that attribute
    ElementDefinition rmElement = Utilities.noString(def) ? findRmElement(parentRmType, item.primitiveValue("id")) : null;
    Cell cell;
    if (rmElement != null) {
      cell = gen.new Cell(null, linkForType(parentRmType), name,
          "openEHR RM attribute "+parentRmType+"."+item.primitiveValue("id")+" ("+item.primitiveValue("aqlPath")+")", null);
    } else {
      cell = gen.new Cell(null, null, name, item.primitiveValue("aqlPath"), null);
    }
    if (!Utilities.noString(def)) {
      cell.addPiece(gen.new Piece(null, " ["+def+"]", item.primitiveValue("aqlPath")));
    }
    r.getCells().add(cell);

    r.getCells().add(gen.new Cell(null, null, item.primitiveValue("min")+".."+("-1".equals(item.primitiveValue("max")) ? "*" : item.primitiveValue("max")), null, null));

    // Description: the node description in the rendering language, then any RM binding and term bindings
    String desc = getLocalizedDescription(item, lang, defLang);
    cell = gen.new Cell(null, null, desc, null, null);
    r.getCells().add(cell);
    if (rmElement != null && rmElement.hasBinding()) {
      addRmBinding(gen, cell, rmElement);
    }
    addTermBindings(gen, cell, item);
    
    
    r.getCells().add(gen.new Cell(null, linkForType(item.primitiveValue("rmType")), item.primitiveValue("rmType"), null, null));
    
    cell = gen.new Cell(null, null, null, null, null);
    r.getCells().add(cell);
    boolean first = true;
    for (ResourceWrapper input : item.children("inputs")) {
      if (first) {
        first = false;
      } else {
        cell.getPieces().add(gen.new Piece("br"));
      }
      addInput(gen, cell, input, rmElement != null);
    }
    
    
    for (ResourceWrapper child : item.children("children")) {
      addItem(gen, r.getSubRows(), child, item.primitiveValue("rmType"), lang, defLang);
    }
    return r;
  }

  /**
   * localizedDescriptions is a map keyed by language (json-property-key = language).
   * Prefer the rendering language, then the template's default language, then the first entry.
   */
  private String getLocalizedDescription(ResourceWrapper item, String lang, String defLang) {
    String first = null;
    String byDefault = null;
    for (ResourceWrapper ts : item.children("localizedDescriptions")) {
      String l = ts.primitiveValue("language");
      String v = ts.primitiveValue("value");
      if (Utilities.noString(v)) {
        continue;
      }
      if (lang != null && lang.equals(l)) {
        return v;
      }
      if (defLang != null && defLang.equals(l)) {
        byDefault = v;
      }
      if (first == null) {
        first = v;
      }
    }
    return byDefault != null ? byDefault : first;
  }

  private void addInput(HierarchicalTableGenerator gen, Cell cell, ResourceWrapper input, boolean rmAttribute) {
    if (input.has("suffix")) {
      cell.getPieces().add(gen.new Piece(null, input.primitiveValue("suffix"), null));
      cell.getPieces().add(gen.new Piece(null, " ", null));      
    }
    cell.getPieces().add(gen.new Piece(null, input.primitiveValue("type"), null).styleAsBold());
    if (input.has("defaultValue")) {
      cell.getPieces().add(gen.new Piece(null, "(=", null));
      cell.getPieces().add(gen.new Piece(null, input.primitiveValue("defaultValue"), null));
      cell.getPieces().add(gen.new Piece(null, ")", null));
    }
    if (input.has("validation")) {
      addValidation(gen, cell, input.child("validation"));
    }
    if (input.has("list")) {
      addList(gen, cell, input.children("list"), input.primitiveValue("terminology"), rmAttribute);
    }
  }

  private void addValidation(HierarchicalTableGenerator gen, Cell cell, ResourceWrapper validation) {
    cell.getPieces().add(gen.new Piece(null, ": ", null));
    
    if (validation.has("range") && !validation.has("precision")) {
      addRange(gen, cell, validation.child("range"));
    } else {
      boolean first = true;
      if (validation.has("range")) {
        cell.getPieces().add(gen.new Piece(null, "range: ", null));
        addRange(gen, cell, validation.child("range"));
        first = false;
      }        
      if (validation.has("precision")) {
        if (!first) {          
          cell.getPieces().add(gen.new Piece(null, "; ", null));
        }
        cell.getPieces().add(gen.new Piece(null, "precision: ", null));
        addRange(gen, cell, validation.child("precision"));
      }        
    }
  }

  private void addRange(HierarchicalTableGenerator gen, Cell cell, ResourceWrapper range) {
    String min = range.primitiveValue("min");
    String minOp = range.primitiveValue("minOp");
    String max = range.primitiveValue("max");
    String maxOp = range.primitiveValue("maxOp");
    String summ;
    if ("0".equals(min) && "0".equals(max)) {
      summ = "0";
    } else {
      summ = minOp+min;
      if (!Utilities.noString(max)) {
        summ = summ+","+maxOp+max;
      }
    } 
    cell.getPieces().add(gen.new Piece(null, summ, null));
    
  }

  private void addList(HierarchicalTableGenerator gen, Cell cell, List<ResourceWrapper> list, String terminology, boolean rmAttribute) {
    // Codes from the openEHR terminology are unique across all its groups, so each one
    // identifies the openEHR CodeSystem it comes from: link the codes to their concepts.
    // Some exports omit terminology on RM attributes (e.g. ISM_TRANSITION.current_state):
    // there, treat the list as openEHR codes only if every code is found in the openEHR terminology
    boolean openehr = "openehr".equals(terminology);
    if (!openehr && terminology == null && rmAttribute && !list.isEmpty()) {
      openehr = true;
      for (ResourceWrapper item : list) {
        openehr = openehr && findOpenehrCodeSystem(item.primitiveValue("value")) != null;
      }
    }
    if (openehr && !list.isEmpty()) {
      CodeSystem cs = findOpenehrCodeSystem(list.get(0).primitiveValue("value"));
      if (cs != null) {
        cell.getPieces().add(gen.new Piece(null, " from ", null));
        cell.getPieces().add(gen.new Piece(cs.getWebPath(), cs.hasTitle() ? cs.getTitle() : cs.getName(), cs.getUrl()));
      }
    }
    for (ResourceWrapper item : list) {
      cell.getPieces().add(gen.new Piece("br"));
      cell.getPieces().add(gen.new Piece(null, "• ", null));
      String code = item.primitiveValue("value");
      CodeSystem cs = openehr ? findOpenehrCodeSystem(code) : null;
      if (cs != null) {
        String link = getLinkForCode(cs.getUrl(), null, code, item.getResourceNative());
        cell.getPieces().add(gen.new Piece(link, item.primitiveValue("label"), "openEHR "+(cs.hasTitle() ? cs.getTitle() : cs.getName())+" "+code));
      } else {
        cell.getPieces().add(gen.new Piece(null, item.primitiveValue("label"), code));
      }
    }
  }

  private Map<String, CodeSystem> openehrCodes;

  /** Finds the openEHR terminology CodeSystem (from openehr.base) that defines this code. */
  private CodeSystem findOpenehrCodeSystem(String code) {
    if (code == null) {
      return null;
    }
    if (openehrCodes == null) {
      openehrCodes = new HashMap<>();
      for (CodeSystem cs : context.getContext().fetchResourcesByType(CodeSystem.class)) {
        if (cs.getUrl() != null && cs.getUrl().startsWith(OPENEHR_CODESYSTEM_PREFIX)) {
          indexCodes(cs, cs.getConceptList());
        }
      }
    }
    return openehrCodes.get(code);
  }

  private void indexCodes(CodeSystem cs, List<CodeSystem.ConceptDefinitionComponent> concepts) {
    for (CodeSystem.ConceptDefinitionComponent c : concepts) {
      openehrCodes.putIfAbsent(c.getCode(), cs);
      indexCodes(cs, c.getConceptList());
    }
  }

  /** Finds the element for an RM attribute in the openehr.base logical model of its class. */
  private ElementDefinition findRmElement(String rmType, String attribute) {
    if (rmType == null || attribute == null) {
      return null;
    }
    StructureDefinition sd = fetchRmType(rmType);
    if (sd == null || !sd.hasSnapshot()) {
      return null;
    }
    for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
      String path = ed.getPath();
      if (path.indexOf('.') > 0 && path.indexOf('.') == path.lastIndexOf('.') && path.endsWith("."+attribute)) {
        return ed;
      }
    }
    return null;
  }

  private void addRmBinding(HierarchicalTableGenerator gen, Cell cell, ElementDefinition ed) {
    String url = ed.getBinding().getValueSet();
    ValueSet vs = context.getContext().fetchResource(ValueSet.class, url);
    if (cell.getPieces().size() > 0) {
      cell.getPieces().add(gen.new Piece("br"));
    }
    cell.getPieces().add(gen.new Piece(null, "Binding: ", null).styleAsBold());
    cell.getPieces().add(gen.new Piece(vs != null ? vs.getWebPath() : null, vs != null ? (vs.hasTitle() ? vs.getTitle() : vs.getName()) : url, url));
    if (ed.getBinding().hasStrength()) {
      cell.getPieces().add(gen.new Piece(null, " ("+ed.getBinding().getStrength().toCode()+")", null));
    }
  }

  private void addTermBindings(HierarchicalTableGenerator gen, Cell cell, ResourceWrapper item) {
    for (ResourceWrapper tb : item.children("termBindings")) {
      String code = tb.primitiveValue("code");
      ResourceWrapper v = tb.child("value");
      String value = v.primitiveValue("value");
      if (value.contains("::")) {
        value = value.substring(value.indexOf("::")+2).replace("]", "");
      }
      String tid = v.primitiveValue("terminologyId");
      String pfx = "";
      String link = null;
      String hint = null;
      switch (code) {
      case "SNOMED-CT" : 
        pfx = "SCT:";
        link = getLinkForCode("http://snomed.info/sct", null, value, item.getResourceNative());
        ValidationResult vr = context.getContext().validateCode(context.getTerminologyServiceOptions(), "http://snomed.info/sct", null, value, null);
        if (vr.isOk()) {
          hint = "SNOMED CT "+value+": "+vr.getDisplay();
        }
        break;
      case "LOINC" :
        pfx = "LN:";
        link = getLinkForCode("http://loinc.org", null, value, item.getResourceNative());
        vr = context.getContext().validateCode(context.getTerminologyServiceOptions(), "http://loinc.org", null, value, null);
        if (vr.isOk()) {
          hint = "LOINC "+value+": "+vr.getDisplay();
        }
        break;
      case "LNC205" :
        // what is this?
        break;
      default: 
        log.warn("?");
      }
      cell.addPiece(gen.new Piece(null, " ", null));
      cell.addPiece(gen.new Piece(link, pfx+value, hint));      
    }
  }

  private String linkForType(String t) {
    StructureDefinition sd = fetchRmType(t);
    return sd != null ? sd.getWebPath() : null;
  }

  private StructureDefinition fetchRmType(String t) {
    if (t == null) {
      return null;
    }
    StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, "http://openehr.org/fhir/StructureDefinition/"+t, VersionResolutionRules.defaultRule());
    if (sd == null && t.contains("_")) {
      sd = context.getContext().fetchResource(StructureDefinition.class, "http://openehr.org/fhir/StructureDefinition/"+t.replace("_", "-"), VersionResolutionRules.defaultRule());
    }
    if (sd == null) {
      sd = context.getContext().fetchTypeDefinition(t);
    }
    return sd;
  }

  protected XhtmlNode renderResourceTechDetails(ResourceWrapper r, XhtmlNode x) throws UnsupportedEncodingException, FHIRException, IOException {
    return renderResourceTechDetails(r, x, (context.isContained() && r.getId() != null ? "#"+r.getId() : r.getId()));
  }
  
  protected XhtmlNode renderResourceTechDetails(ResourceWrapper r, XhtmlNode x, String desc) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode p = x.para().attribute("class", "res-header-id");
    if (desc == null) { 
      p.b().tx(context.formatPhrase(context.isTechnicalMode() && !isInner() ? RenderingContext.PROF_DRIV_GEN_NARR_TECH : RenderingContext.PROF_DRIV_GEN_NARR, "WebTemplate", ""));      
    } else {
      p.b().tx(context.formatPhrase(context.isTechnicalMode() && !isInner() ? RenderingContext.PROF_DRIV_GEN_NARR_TECH : RenderingContext.PROF_DRIV_GEN_NARR, "WebTemplate", desc));
    }

    // first thing we do is lay down the resource anchors. 
    String tid = r.primitiveValue("templateId");
    if (!Utilities.noString(tid)) {
      String sid = "hc"+tid;
      if (!context.hasAnchor(sid)) {
        context.addAnchor(sid);
        x.an(context.prefixAnchor(sid));
      }
    }

    if (context.isTechnicalMode()) {
      RenderingStatus status = new RenderingStatus();

      String lang = r.primitiveValue("defaultLanguage"); 
      ResourceWrapper versionId = r.child("semver");

      if (lang != null || versionId != null) {
        XhtmlNode div = x.div().style("display: inline-block").style("background-color: #fbffeb").style("padding: 6px")
            .style("margin: 4px").style("border: 1px solid #8da1b4")
            .style("border-radius: 5px").style("line-height: 60%");

        boolean sfirst = true;
        p = plateStyle(div.para());
        if (tid != null) {
          p.tx(context.formatPhrase(RenderingI18nContext.RES_REND_TEMPLATE_ID, tid));
          sfirst = false;
        }
        if (versionId != null) {
          p.tx(context.formatPhrase(RenderingI18nContext.RES_REND_VER, versionId.primitiveValue()));
          sfirst = false;
        }
        if (lang != null) {
          if (!sfirst) {
            p.tx("; ");
          }
          p.tx(context.formatPhrase(RenderingI18nContext.RES_REND_LANGUAGE, lang));
          sfirst = false;
        }
      }
    }
    return null;
  }

}
