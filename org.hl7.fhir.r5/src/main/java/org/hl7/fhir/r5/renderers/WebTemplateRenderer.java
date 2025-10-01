package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.sql.Column;
import org.hl7.fhir.r5.utils.sql.ColumnKind;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Row;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.TableModel;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Title;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class WebTemplateRenderer extends ResourceRenderer {
  
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
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Name"), (context.formatPhrase(RenderingContext.QUEST_LINK)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Card."), (context.formatPhrase(RenderingContext.QUEST_TEXTFOR)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Definition"), (context.formatPhrase(RenderingContext.QUEST_TIMES)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Type"), (context.formatPhrase(RenderingContext.QUEST_TIMES)), null, 0)); 
    model.getTitles().add(gen.new Title(null, model.getDocoRef(), ("Inputs"), (context.formatPhrase(RenderingContext.QUEST_TYPE_ITEM)), null, 0)); 
 
    // first we add a root for the WebTemplate itself 
    Row row = addItem(gen, model.getRows(), wt.child("tree")); 
//    for (ResourceWrapper select : vd.children("select")) { 
//      renderSelect(status, gen, row.getSubRows(), vd, select); 
//    } 
    XhtmlNode xn = gen.generate(model, context.getLocalPrefix(), 1, null); 
    x.addChildNode(xn); 
 
    
  } 

  private Row addItem(HierarchicalTableGenerator gen, List<Row> rows, ResourceWrapper item) {
    Row r = gen.new Row(); 
    rows.add(r); 

    r.setIcon("icon_vd_view.png", context.formatPhrase(RenderingContext.QUEST_ROOT)); 
    r.getCells().add(gen.new Cell(null, null, item.primitiveValue("name"), null, null)); 
    
    r.getCells().add(gen.new Cell(null, null, item.primitiveValue("min")+".."+("-1".equals(item.primitiveValue("max")) ? "*" : item.primitiveValue("max")), null, null));
    
    String def = (item.primitiveValue("archetype_id") != null ? item.primitiveValue("archetype_id")+"/" : "")+(item.primitiveValue("nodeId") != null ?item.primitiveValue("nodeId") : "");
    Cell cell = gen.new Cell(null, null, Utilities.noString(def) ? "--" : def, item.primitiveValue("aqlPath"), null);
    r.getCells().add(cell);
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
      addInput(gen, cell, input);
    }
    
    
    for (ResourceWrapper child : item.children("children")) {
      addItem(gen, r.getSubRows(), child);
    }
    return r;     
  }

  private void addInput(HierarchicalTableGenerator gen, Cell cell, ResourceWrapper input) {
    if (input.has("suffix")) {
      cell.getPieces().add(gen.new Piece(null, input.primitiveValue("suffix"), null));
      cell.getPieces().add(gen.new Piece(null, " ", null));      
    }
    cell.getPieces().add(gen.new Piece(null, input.primitiveValue("type"), null).addStyle("font-weight: bold"));
    if (input.has("defaultValue")) {
      cell.getPieces().add(gen.new Piece(null, "(=", null));
      cell.getPieces().add(gen.new Piece(null, input.primitiveValue("defaultValue"), null));
      cell.getPieces().add(gen.new Piece(null, ")", null));
    }
    if (input.has("validation")) {
      addValidation(gen, cell, input.child("validation"));
    }
    if (input.has("list")) {
      addList(gen, cell, input.children("list"));
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

  private void addList(HierarchicalTableGenerator gen, Cell cell, List<ResourceWrapper> list) {
    for (ResourceWrapper item : list) {
      cell.getPieces().add(gen.new Piece("br"));
      cell.getPieces().add(gen.new Piece(null, "• ", null));
      cell.getPieces().add(gen.new Piece(null, item.primitiveValue("label"), item.primitiveValue("value")));      
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
    if (t == null) {
      return null;
    }
    StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, "http://openehr.org/fhir/StructureDefinition/"+t);
    if (sd == null) {
      sd = context.getContext().fetchTypeDefinition(t);
    }
    if (sd != null) {
      return sd.getWebPath();
    }
    return null;
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
        XhtmlNode div = x.div().style("display: inline-block").style("background-color: #d9e0e7").style("padding: 6px")
            .style("margin: 4px").style("border: 1px solid #8da1b4")
            .style("border-radius: 5px").style("line-height: 60%");

        boolean sfirst = true;
        p = plateStyle(div.para());
        if (tid != null) {
          p.tx(context.formatPhrase(RenderingContext.RES_REND_TEMPLATE_ID, tid));
          sfirst = false;
        }
        if (versionId != null) {
          p.tx(context.formatPhrase(RenderingContext.RES_REND_VER, versionId.primitiveValue()));
          sfirst = false;
        }
        if (lang != null) {
          if (!sfirst) {
            p.tx("; ");
          }
          p.tx(context.formatPhrase(RenderingContext.RES_REND_LANGUAGE, lang));
          sfirst = false;
        }
      }
    }
    return null;
  }

}
