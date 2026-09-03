package org.hl7.fhir.services.renderers;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.Enumerations.FHIRTypes;
import org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.model.core.OperationDefinition.OperationKind;
import org.hl7.fhir.model.core.OperationDefinition.OperationParameterScope;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.EOperationOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class OperationDefinitionRenderer extends TerminologyRenderer { 
 

  public OperationDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {
      renderResourceTechDetails(r, x);  
      genSummaryTable(status, x, (OperationDefinition) r.getBase());    
      render(status, x, (OperationDefinition) r.getBase());      
    } else {
      // the intention is to change this in the future
      x.para().tx("OperationDefinitionRenderer only renders native resources directly");
    }
  }
   
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  public void render(RenderingStatus status, XhtmlNode x, OperationDefinition opd) throws IOException, FHIRException, EOperationOutcome { 
    if (context.isShowSummaryTable()) { 
      x.h2().addText(opd.getName()); 
      x.para().addText(Utilities.capitalize(opd.getKind().toString())+": "+opd.getName());     
      x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_OFFIC)+" "); 
      x.pre().tx(opd.getUrl()); 
      addMarkdown(x, opd.getDescription());} 
 
    if (opd.getKind() == OperationKind.QUERY) {
      if (opd.getSystem()) {
        x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_URL, "?_query="+opd.getCode()+"&..."));
      }
      for (UriType c : opd.getResourceList()) {
        if (opd.getType()) 
          x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_URL, c.getValue()+"?_query="+opd.getCode()+"&..."));
        if (opd.getInstance()) 
          x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_URL, c.getValue()+"/[id]?_query="+opd.getCode()+"&..."));
      } 
    } else {
      if (opd.getSystem()) {
        x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_URL, "$"+opd.getCode()));
      }
      for (UriType c : opd.getResourceList()) {
        if (opd.getType()) 
          x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_URL, c.getValue()+"/$"+opd.getCode()));
        if (opd.getInstance()) 
          x.para().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_URL, c.getValue()+"/[id]/$"+opd.getCode()));
      } 
    }

    if (opd.hasInputProfile()) { 
      XhtmlNode p = x.para(); 
      p.tx(context.formatPhrase(RenderingI18nContext.OP_DEF_INPAR)); 
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, opd.getInputProfile(),
        ExtensionUtilities.getVersionResolutionRules(opd.getInputProfileElement()), null, opd);
      if (sd == null) { 
        p.pre().tx(opd.getInputProfile());         
      } else { 
        p.ah(context.prefixLocalHref(sd.getWebPath())).tx(sd.present());                  
      }       
    } 
    if (opd.hasOutputProfile()) { 
      XhtmlNode p = x.para(); 
      p.tx(context.formatPhrase(RenderingI18nContext.OP_DEF_OUTPAR)); 
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, opd.getOutputProfile(),
        ExtensionUtilities.getVersionResolutionRules(opd.getOutputProfileElement()), null, opd);
      if (sd == null) { 
        p.pre().tx(opd.getOutputProfile());         
      } else { 
        p.ah(context.prefixLocalHref(sd.getWebPath())).tx(sd.present());                  
      }       
    }

    x.h3().tx(context.formatPhrase(RenderingI18nContext.GENERAL_PARS));
    //x.para().tx(context.formatPhrase(RenderingI18nContext.GENERAL_PARS)); 
    XhtmlNode tbl = x.table( "grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = tbl.tr(); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_USE)); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_NAME)); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.OP_DEF_SCO)); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_CARDINALITY)); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_TYPE)); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_BINDING)); 
    tr.td().b().tx(context.formatPhrase(RenderingI18nContext.GENERAL_DOCUMENTATION)); 
    for (OperationDefinitionParameterComponent p : opd.getParameterList()) {
      genOpParam(tbl, "", p, opd); 
    } 
    addMarkdown(x, opd.getComment()); 
  } 
 
  public void describe(XhtmlNode x, OperationDefinition opd) { 
    x.tx(display(opd)); 
  } 
 
  public String display(OperationDefinition opd) { 
    return opd.present(); 
  } 
 
  @Override 
  public String display(Resource r) throws UnsupportedEncodingException, IOException { 
    return ((OperationDefinition) r).present(); 
  } 
 
  private void genOpParam(XhtmlNode tbl, String path, OperationDefinitionParameterComponent p, Resource opd) throws EOperationOutcome, FHIRException, IOException { 
    XhtmlNode tr; 
    tr = tbl.tr(); 
    tr.td().addText(p.getUse().toString()); 
    XhtmlNode td = tr.td(); 
    td.addText(path+p.getName()); 
    StandardsStatus ss = ExtensionUtilities.getStandardsStatus(p);
    genStandardsStatus(td, ss); 
    td = tr.td(); 
    if (p.hasScope()) { 
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(); 
      for (Enumeration<OperationParameterScope> s : p.getScopeList()) {
        b.append(s.getCode()); 
      } 
      td.tx(b.toString()); 
    } 
    tr.td().addText(Integer.toString(p.getMin())+".."+p.getMax()); 
    td = tr.td(); 
    String actualType = translateTypeToVersion(p.getTypeElement()); 
    StructureDefinition sd = actualType != null ? context.getWorker().fetchTypeDefinition(actualType) : null; 
    if (sd == null) {
      td.tx(p.hasType() ? actualType : "");  
    } else if (sd.getAbstract() && p.hasExtension(ExtensionDefinitions.EXT_ALLOWED_TYPE)) {
      boolean first = true;  
      for (Extension ex : p.getExtensionsByUrl(ExtensionDefinitions.EXT_ALLOWED_TYPE)) {  
        if (first) first = false; else td.tx(" | ");  
        String s = ex.getValue().primitiveValue();  
        StructureDefinition sdt = context.getWorker().fetchTypeDefinition(s);  
        if (sdt == null)  
          td.tx(p.hasType() ? actualType : "");  
        else  
          td.ah(context.prefixLocalHref(sdt.getWebPath())).tx(s);           
      }  
    } else if (sd.getAbstract() && (p.hasAllowedType())) {
      boolean first = true; 
      for (Enumeration<FHIRTypes> ex : p.getAllowedTypeList()) {
        if (first) first = false; else td.tx(" | "); 
        String s = ex.primitiveValue();
        StructureDefinition sdt = context.getWorker().fetchTypeDefinition(s); 
        if (sdt == null) 
          td.tx(p.hasType() ? actualType : ""); 
        else 
          td.ah(context.prefixLocalHref(sdt.getWebPath())).tx(s);          
      }
    } else 
      td.ah(context.prefixLocalHref(sd.getWebPath())).tx(actualType); 
    if (p.hasTargetProfile()) { 
      td.tx(" ("); 
      boolean first = true; 
      for (CanonicalType tp : p.getTargetProfileList()) {
        if (first) { first = false;} else {td.tx(", ");}; 
        StructureDefinition sdt = context.getWorker().fetchTypeDefinition(tp.asStringValue()); 
        if (sdt == null || !sdt.hasWebPath()) { 
          td.code().tx(tp.asStringValue()); 
        } else { 
          td.ah(context.prefixLocalHref(sdt.getWebPath()), tp.asStringValue()).tx(sdt.present()); 
        } 
      } 
      td.tx(")"); 
    } 
    if (p.hasSearchType()) { 
      td.br(); 
      td.tx("("); 
      td.ah(context.prefixLocalHref(context.getLink(KnownLinkType.SPEC, true) == null ? "search.html#"+p.getSearchType().toCode() : Utilities.pathURL(context.getLink(KnownLinkType.SPEC, true), "search.html#"+p.getSearchType().toCode()))).tx(p.getSearchType().toCode());        
      td.tx(")"); 
    } 
    td = tr.td(); 
    if (p.hasBinding() && p.getBinding().hasValueSet()) { 
      AddVsRef(p.getBinding().getValueSet(), p.getBinding().getValueSetElement(), td, opd);
      td.tx(" ("+p.getBinding().getStrength().getDisplay()+")"); 
    } 
    addMarkdown(tr.td(), p.getDocumentation()); 
    if (!p.hasType()) { 
      for (OperationDefinitionParameterComponent pp : p.getPartList()) {
        genOpParam(tbl, path+p.getName()+".", pp, opd); 
      } 
    } 
  } 
   
  public static final String EXT_OPDEF_ORIGINAL_TYPE = "http://hl7.org/fhir/4.0/StructureDefinition/extension-OperationDefinition.parameter.type"; 
 
  private String translateTypeToVersion(UriType src) {
    if (src.hasExtension(EXT_OPDEF_ORIGINAL_TYPE)) { 
      return src.getExtensionString(EXT_OPDEF_ORIGINAL_TYPE); 
    } else { 
      return src.asStringValue(); 
    } 
  } 
 
 
} 
