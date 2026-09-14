package org.hl7.fhir.validation.service.renderers;

import java.io.File;
import java.io.IOException;

import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.model.utilities.formats.IParser;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.context.SimpleModelContext;

public class NativeRenderer extends ValidationOutputRenderer {

  private FhirFormat format;
  public NativeRenderer(FhirFormat format) {
    this.format = format;
  }

  public boolean handlesBundleDirectly() {
    return true;
  }

  @Override
  public void render(OperationOutcome op) throws IOException {
    IParser x;
    if (format == FhirFormat.JSON) {
      x = new JsonParser(new SimpleModelContext());
    } else {
      x = new XmlParser(new SimpleModelContext());
    }
    x.setOutputStyle(OutputStyle.PRETTY);
    x.compose(dst, op);
  }

  @Override
  public void render(Bundle bundle) throws IOException {
    IParser x;
    if (format == FhirFormat.JSON) {
      x = new JsonParser(new SimpleModelContext());
    } else {
      x = new XmlParser(new SimpleModelContext());
    }
    x.setOutputStyle(OutputStyle.PRETTY);
    x.compose(dst, bundle);
  }

  @Override
  public boolean isSingleFile() {
    return true;
  }

  @Override
  public String getStyleCode() {
    return format.toString().toLowerCase();
  }

  @Override
  public void setFolder(File dir) {
    throw new Error("Not supported");
    
  }
  
}
