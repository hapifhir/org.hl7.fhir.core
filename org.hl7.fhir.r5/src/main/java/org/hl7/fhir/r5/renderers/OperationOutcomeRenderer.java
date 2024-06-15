package org.hl7.fhir.r5.renderers; 
 
import java.io.IOException; 
import java.io.UnsupportedEncodingException; 
 
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError; 
import org.hl7.fhir.r5.model.Extension; 
import org.hl7.fhir.r5.model.ExtensionHelper; 
import org.hl7.fhir.r5.model.OperationOutcome; 
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity; 
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent; 
import org.hl7.fhir.r5.model.Resource; 
import org.hl7.fhir.r5.model.StringType; 
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions; 
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder; 
import org.hl7.fhir.utilities.xhtml.XhtmlNode; 
 
public class OperationOutcomeRenderer extends ResourceRenderer { 


  public OperationOutcomeRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return "todo";
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement op) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    boolean hasSource = false; 
    boolean success = true; 
    for (ResourceElement i : op.children("issue")) { 
      success = success && "information".equals(i.primitiveValue("severity")); 
      hasSource = hasSource || i.hasExtension(ToolingExtensions.EXT_ISSUE_SOURCE); 
    } 
    if (success) { 
      x.para().tx(context.formatPhrase(RenderingContext.OP_OUT_OK));
    }
    if (op.has("issue")) { 
      XhtmlNode tbl = x.table("grid"); // on the basis that we'll most likely be rendered using the standard fhir css, but it doesn't really matter 
      XhtmlNode tr = tbl.tr(); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.OP_OUT_SEV)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_LOCATION)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_DETAILS)); 
      tr.td().b().tx(context.formatPhrase(RenderingContext.OP_OUT_DIAG)); 
      if (hasSource) {
        tr.td().b().tx(context.formatPhrase(RenderingContext.OP_OUT_SRC));
      }
      for (ResourceElement i : op.children("issue")) { 
        tr = tbl.tr(); 
        tr.td().addText(i.primitiveValue("severity")); 
        XhtmlNode td = tr.td(); 
        boolean d = false; 
        for (ResourceElement s : i.has("expression") ? i.children("expression") : i.children("location")) { 
          if (d) 
            td.tx(", "); 
          else 
            d = true; 
          td.addText(s.primitiveValue()); 
        } 
        tr.td().addText(i.child("code").primitiveValue("display")); 
        tr.td().addText(i.primitiveValue("details")); 
        smartAddText(tr.td(), i.primitiveValue("diagnostics")); 
        if (hasSource) { 
          ResourceElement ext = i.extension(ToolingExtensions.EXT_ISSUE_SOURCE); 
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
