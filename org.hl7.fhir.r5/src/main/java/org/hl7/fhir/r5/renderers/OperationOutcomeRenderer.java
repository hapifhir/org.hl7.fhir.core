package org.hl7.fhir.r5.renderers; 
 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode; 
 
@MarkedToMoveToAdjunctPackage
public class OperationOutcomeRenderer extends ResourceRenderer { 


  public OperationOutcomeRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    List<ResourceWrapper> issues = r.children("issue");
    int hint = 0;
    int warn = 0;
    int err = 0;
    for (ResourceWrapper issue : issues) {
      switch (issue.primitiveValue("severity")) {
      case "information" : 
        hint++; 
        break;
      case "warning" : 
        warn++; 
        break;
      case "error" : 
      case "fatal" : 
        err++; 
        break;
      }
    }
    if (hint + warn + err == 0) {
      return context.formatPhrase(RenderingContext.OP_OUT_SUMM_ALL_OK);
    } else if (hint == 0) {
      return context.formatPhrase(RenderingContext.OP_OUT_SUMM_NOHINT, err, warn);
    } else {
      return context.formatPhrase(RenderingContext.OP_OUT_SUMM, err, warn, hint);
    }
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper op) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(op, x);
    boolean hasSource = false; 
    boolean success = true; 
    for (ResourceWrapper i : op.children("issue")) { 
      success = success && "information".equals(i.primitiveValue("severity")); 
      hasSource = hasSource || i.hasExtension(ExtensionDefinitions.EXT_ISSUE_SOURCE);
    } 
    if (success) { 
      x.para().tx(context.formatPhrase(RenderingContext.OP_OUT_OK));
    }
    if (op.has("issue")) { 
      XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource()); // on the basis that we'll most likely be rendered using the standard fhir css, but it doesn't really matter
      XhtmlNode tr = tbl.tr(); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.OP_OUT_SEV)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_LOCATION)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_DETAILS)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.OP_OUT_DIAG)); 
      if (hasSource) {
        tr.td().b().tx(context.formatPhrase(RenderingContext.OP_OUT_SRC));
      }
      for (ResourceWrapper i : op.children("issue")) { 
        tr = tbl.tr(); 
        tr.td().addText(getTranslatedCode(i.child("severity"))); 
        XhtmlNode td = tr.td(); 
        boolean d = false; 
        for (ResourceWrapper s : i.has("expression") ? i.children("expression") : i.children("location")) { 
          if (d) 
            td.tx(", "); 
          else 
            d = true; 
          td.addText(s.primitiveValue()); 
        } 
        tr.td().addText(getTranslatedCode(i.child("code")));
        if (i.has("details"))
          tr.td().addText(i.child("details").primitiveValue("text"));
        tr.td().addTextWithLineBreaks(i.primitiveValue("diagnostics")); 
        if (hasSource) { 
          ResourceWrapper ext = i.extension(ExtensionDefinitions.EXT_ISSUE_SOURCE); 
          tr.td().addText(ext == null || !ext.has("value") ? "" : displayDataType(ext.child("value"))); 
        } 
      } 
    } 
  } 


  public void describe(XhtmlNode x, OperationOutcome oo) { 
    x.tx(display(oo)); 
  } 
 
  public String display(OperationOutcome oo) { 
    return (context.formatPhrase(RenderingContext.GENERAL_TODO)); 
  } 
 
  public static String toString(OperationOutcome oo) { 
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(); 
    for (OperationOutcomeIssueComponent issue : oo.getIssue()) { 
      b.append(issue.getSeverity().toCode()+": "+issue.getDetails().getText()); 
    } 
    return b.toString(); 
  } 
} 
