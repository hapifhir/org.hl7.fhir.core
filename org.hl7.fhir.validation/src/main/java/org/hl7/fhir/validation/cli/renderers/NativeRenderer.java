package org.hl7.fhir.validation.cli.renderers;

import java.io.File;
import java.io.IOException;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;

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
      x = new JsonParser();
    } else {
      x = new XmlParser();
    }
    x.setOutputStyle(IParser.OutputStyle.PRETTY);
    x.compose(dst, op);
  }

  @Override
  public void render(Bundle bundle) throws IOException {
    IParser x;
    if (format == FhirFormat.JSON) {
      x = new JsonParser();
    } else {
      x = new XmlParser();
    }
    x.setOutputStyle(IParser.OutputStyle.PRETTY);
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
