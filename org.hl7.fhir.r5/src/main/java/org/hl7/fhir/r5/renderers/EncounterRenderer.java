package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class EncounterRenderer extends ResourceRenderer {


  public EncounterRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return "todo";
  }

  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    throw new Error("todo");
  }
  

}