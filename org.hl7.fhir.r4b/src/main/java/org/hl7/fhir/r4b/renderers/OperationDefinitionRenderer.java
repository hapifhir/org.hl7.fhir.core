package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Extension;
import org.hl7.fhir.r4b.model.OperationDefinition;
import org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r4b.utils.EOperationOutcome;
import org.hl7.fhir.r4b.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class OperationDefinitionRenderer extends TerminologyRenderer {

  public OperationDefinitionRenderer(RenderingContext context) {
    super(context);
  }

  public OperationDefinitionRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public boolean render(XhtmlNode x, Resource dr) throws IOException, FHIRException, EOperationOutcome {
    return render(x, (OperationDefinition) dr);
  }

  public boolean render(XhtmlNode x, OperationDefinition opd) throws IOException, FHIRException, EOperationOutcome {
    x.h2().addText(opd.getName());
    x.para().addText(Utilities.capitalize(opd.getKind().toString()) + ": " + opd.getName());
    x.para().tx("The official URL for this operation definition is: ");
    x.pre().tx(opd.getUrl());
    addMarkdown(x, opd.getDescription());

    if (opd.getSystem())
      x.para().tx("URL: [base]/$" + opd.getCode());
    for (CodeType c : opd.getResource()) {
      if (opd.getType())
        x.para().tx("URL: [base]/" + c.getValue() + "/$" + opd.getCode());
      if (opd.getInstance())
        x.para().tx("URL: [base]/" + c.getValue() + "/[id]/$" + opd.getCode());
    }

    if (opd.hasInputProfile()) {
      XhtmlNode p = x.para();
      p.tx("Input parameters Profile: ");
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, opd.getInputProfile());
      if (sd == null) {
        p.pre().tx(opd.getInputProfile());
      } else {
        p.ah(sd.getUserString("path")).tx(sd.present());
      }
    }
    if (opd.hasOutputProfile()) {
      XhtmlNode p = x.para();
      p.tx("Output parameters Profile: ");
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, opd.getOutputProfile());
      if (sd == null) {
        p.pre().tx(opd.getOutputProfile());
      } else {
        p.ah(sd.getUserString("path")).tx(sd.present());
      }
    }
    x.para().tx("Parameters");
    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx("Use");
    tr.td().b().tx("Name");
    tr.td().b().tx("Cardinality");
    tr.td().b().tx("Type");
    tr.td().b().tx("Binding");
    tr.td().b().tx("Documentation");
    for (OperationDefinitionParameterComponent p : opd.getParameter()) {
      genOpParam(tbl, "", p);
    }
    addMarkdown(x, opd.getComment());
    return true;
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

  private void genOpParam(XhtmlNode tbl, String path, OperationDefinitionParameterComponent p)
      throws EOperationOutcome, FHIRException, IOException {
    XhtmlNode tr;
    tr = tbl.tr();
    tr.td().addText(p.getUse().toString());
    tr.td().addText(path + p.getName());
    tr.td().addText(Integer.toString(p.getMin()) + ".." + p.getMax());
    XhtmlNode td = tr.td();
    StructureDefinition sd = p.getType() != null ? context.getWorker().fetchTypeDefinition(p.getType().toCode()) : null;
    if (sd == null)
      td.tx(p.hasType() ? p.getType().toCode() : "");
    else if (sd.getAbstract() && p.hasExtension(ToolingExtensions.EXT_ALLOWED_TYPE)) {
      boolean first = true;
      for (Extension ex : p.getExtensionsByUrl(ToolingExtensions.EXT_ALLOWED_TYPE)) {
        if (first)
          first = false;
        else
          td.tx(" | ");
        String s = ex.getValue().primitiveValue();
        StructureDefinition sdt = context.getWorker().fetchTypeDefinition(s);
        if (sdt == null)
          td.tx(p.hasType() ? p.getType().toCode() : "");
        else
          td.ah(sdt.getUserString("path")).tx(s);
      }
    } else
      td.ah(sd.getUserString("path")).tx(p.hasType() ? p.getType().toCode() : "");
    if (p.hasSearchType()) {
      td.br();
      td.tx("(");
      td.ah(context.getSpecificationLink() == null ? "search.html#" + p.getSearchType().toCode()
          : Utilities.pathURL(context.getSpecificationLink(), "search.html#" + p.getSearchType().toCode()))
          .tx(p.getSearchType().toCode());
      td.tx(")");
    }
    td = tr.td();
    if (p.hasBinding() && p.getBinding().hasValueSet()) {
      AddVsRef(p.getBinding().getValueSet(), td);
      td.tx(" (" + p.getBinding().getStrength().getDisplay() + ")");
    }
    addMarkdown(tr.td(), p.getDocumentation());
    if (!p.hasType()) {
      for (OperationDefinitionParameterComponent pp : p.getPart()) {
        genOpParam(tbl, path + p.getName() + ".", pp);
      }
    }
  }

}
