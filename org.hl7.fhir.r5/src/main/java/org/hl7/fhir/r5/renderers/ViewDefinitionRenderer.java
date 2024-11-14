package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ViewDefinitionRenderer extends ResourceRenderer {
  
  public ViewDefinitionRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper vd) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(vd, x);
    genSummaryTable(status, x, vd);
    
    XhtmlNode tbl = x.table("grid");
    
    // row 1: identity
    XhtmlNode tr = tbl.tr();
    tr.para().tx("This view definition produces a table \""+vd.primitiveValue("name")+"\"");
    
    // row 2: content
    tr = tbl.tr();
    CommaSeparatedStringBuilder cb = new CommaSeparatedStringBuilder(", ", " and ");
    for (ResourceWrapper v : vd.children("fhirVersion")) {
      String ver = v.primitiveValue();
      cb.append("<a href=\""+VersionUtilities.getSpecUrl(ver)+"\">"+VersionUtilities.getNameForVersion(ver)+"</a>");
    }
    String vh = cb.count() == 0 ? "" : cb.count() == 1 ? "version " +cb.toString() : "versions "+cb.toString();
    
    if (vd.has("resourceProfile")) {
      XhtmlNode p = tr.para();
      p.tx("This view acts on "+vh+" "+cb.toString()+" "+vd.primitiveValue("resource")+" using profile ?");
      // todo
    } else {
      tr.para().tx("This view acts on "+vh+" "+cb.toString()+" "+vd.primitiveValue("resource"));
    }
  
    // row 3: columns
    tr = tbl.tr();
    tr.para().tx("This view creates the following columns:");
    // row 4: select tree
    tr = tbl.tr();
    tr.para().tx("This view selects the following cells");
  }
      
}
