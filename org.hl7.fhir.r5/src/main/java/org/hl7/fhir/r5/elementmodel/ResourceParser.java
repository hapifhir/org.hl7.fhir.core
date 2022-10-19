package org.hl7.fhir.r5.elementmodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.ParserBase.NamedElement;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;

public class ResourceParser extends ParserBase {

  public ResourceParser(IWorkerContext context) {
    super(context);
  }

  @Override
  public List<NamedElement> parse(InputStream stream) throws IOException, FHIRFormatError, DefinitionException, FHIRException {
    throw new NotImplementedException("parse(InputStream stream)"); // doesns't make sense
  }

  @Override
  public void compose(Element e, OutputStream destination, OutputStyle style, String base)
      throws FHIRException, IOException {
    throw new NotImplementedException("compose(Element e, OutputStream destination, OutputStyle style, String base)"); // doesns't make sense    
  }


}
