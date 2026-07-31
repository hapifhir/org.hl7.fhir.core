package org.hl7.fhir.r5.igs.testing.renderer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * Renderer for the TestPlan resource as defined by the FHIR Testing IG (hl7.fhir.uv.testing).
 * <p/>
 * This resource shares the name "TestPlan" with the base specification but has a different structure,
 * so this renderer is registered on the RendererFactory (see additional-resources-r5.md) to take
 * precedence over the built-in TestPlan renderer when the Testing IG is in use. Like all renderers, it
 * works off the model-agnostic ResourceWrapper (navigating the IG's element names), so it renders the
 * resource whether it was parsed into the generated object model or loaded through the element model.
 */
public class TestPlanRenderer extends ResourceRenderer {

  public TestPlanRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }

  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper tp) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResourceTechDetails(tp, x);
    genSummaryTable(status, x, (CanonicalResource) tp.getResourceNative());

    // a table of scopes (reference, and description if any)
    if (tp.has("scope")) {
      x.para().b().tx("Scopes");
      List<ResourceWrapper> scopes = tp.children("scope");
      boolean desc = anyHasDescription(scopes);
      XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Reference");
      if (desc) {
        tr.td().b().tx("Description");
      }
      for (ResourceWrapper scope : scopes) {
        tr = t.tr();
        renderCanonicalCell(status, tr.td(), scope.child("reference"));
        if (desc) {
          descriptionCell(tr.td(), scope);
        }
      }
    }

    // a table of dependencies (reference, and description if any)
    if (tp.has("dependency")) {
      x.para().b().tx("Dependencies");
      List<ResourceWrapper> deps = tp.children("dependency");
      boolean desc = anyHasDescription(deps);
      XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Reference");
      if (desc) {
        tr.td().b().tx("Description");
      }
      for (ResourceWrapper dep : deps) {
        tr = t.tr();
        renderCanonicalCell(status, tr.td(), dep.child("reference"));
        if (desc) {
          descriptionCell(tr.td(), dep);
        }
      }
    }

    // a table of modes (code, and description if any)
    if (tp.has("mode")) {
      x.para().b().tx("Modes");
      List<ResourceWrapper> modes = tp.children("mode");
      boolean desc = anyHasDescription(modes);
      XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Code");
      if (desc) {
        tr.td().b().tx("Description");
      }
      for (ResourceWrapper mode : modes) {
        tr = t.tr();
        tr.td().tx(mode.primitiveValue("code"));
        if (desc) {
          descriptionCell(tr.td(), mode);
        }
      }
    }

    // a table of global parameters
    if (tp.has("parameter")) {
      x.para().b().tx("Parameters");
      XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
      XhtmlNode tr = t.tr();
      tr.td().b().tx("Name");
      tr.td().b().tx("Value");
      tr.td().b().tx("Mode");
      for (ResourceWrapper param : tp.children("parameter")) {
        tr = t.tr();
        tr.td().tx(param.primitiveValue("name"));
        if (param.has("value[x]")) {
          renderDataType(status, tr.td(), param.child("value[x]"));
        } else {
          tr.td();
        }
        tr.td().tx(param.primitiveValue("mode"));
      }
    }

    // the suites, with <hr/> between the top level ones, nesting shown by numbering
    List<ResourceWrapper> suites = tp.children("suite");
    boolean first = true;
    int i = 0;
    for (ResourceWrapper suite : suites) {
      i++;
      if (!first) {
        x.hr();
      }
      first = false;
      renderSuite(status, x, suite, Integer.toString(i));
    }
  }

  private void renderSuite(RenderingStatus status, XhtmlNode x, ResourceWrapper suite, String number) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    // name as title
    x.para().b().tx(number + " " + suite.primitiveValue("name"));

    // modes and description as a single paragraph, if present
    String mode = suite.primitiveValue("mode");
    String description = suite.primitiveValue("description");
    if (mode != null || description != null) {
      XhtmlNode p = x.para();
      if (mode != null) {
        p.tx("Mode: " + mode);
        if (description != null) {
          p.tx(". ");
        }
      }
      if (description != null) {
        p.tx(description);
      }
    }

    // a table of inputs, if present
    if (suite.has("input")) {
      renderInputTable(status, x, "Inputs", suite.children("input"));
    }

    // a table of tests, if present
    if (suite.has("test")) {
      renderTestTable(status, x, suite.children("test"));
    }

    // nested suites, numbered under this one
    int j = 0;
    for (ResourceWrapper sub : suite.children("suite")) {
      j++;
      renderSuite(status, x, sub, number + "." + j);
    }
  }

  private void renderInputTable(RenderingStatus status, XhtmlNode x, String title, List<ResourceWrapper> inputs) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    x.para().b().tx(title);
    boolean hasName = anyHas(inputs, "name");
    boolean hasFile = anyHas(inputs, "file");
    boolean hasResource = anyHas(inputs, "resource");
    boolean hasMode = anyHas(inputs, "mode");
    XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = t.tr();
    if (hasName) {
      tr.td().b().tx("Name");
    }
    if (hasFile) {
      tr.td().b().tx("File");
    }
    if (hasResource) {
      tr.td().b().tx("Resource");
    }
    if (hasMode) {
      tr.td().b().tx("Mode");
    }
    for (ResourceWrapper input : inputs) {
      tr = t.tr();
      if (hasName) {
        tr.td().tx(input.primitiveValue("name"));
      }
      if (hasFile) {
        tr.td().tx(input.primitiveValue("file"));
      }
      if (hasResource) {
        XhtmlNode td = tr.td();
        if (input.has("resource")) {
          td.tx(input.child("resource").fhirType());
        }
      }
      if (hasMode) {
        tr.td().tx(input.primitiveValue("mode"));
      }
    }
  }

  private void renderTestTable(RenderingStatus status, XhtmlNode x, List<ResourceWrapper> tests) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    x.para().b().tx("Tests");
    XhtmlNode t = x.table("grid", false).markGenerated(!context.forValidResource());
    XhtmlNode tr = t.tr();
    tr.td().b().tx("Name");
    tr.td().b().tx("Mode");
    tr.td().b().tx("Description");
    tr.td().b().tx("Operation");
    tr.td().b().tx("Parameters");
    tr.td().b().tx("Input");
    tr.td().b().tx("Expected");
    for (ResourceWrapper test : tests) {
      tr = t.tr();
      tr.td().tx(test.primitiveValue("name"));
      tr.td().tx(test.primitiveValue("mode"));
      tr.td().tx(test.primitiveValue("description"));
      tr.td().tx(test.primitiveValue("operation"));
      renderParameterCell(status, tr.td(), test.children("parameter"));
      renderInputCell(status, tr.td(), test.children("input"));
      renderInputCell(status, tr.td(), test.children("expected"));
      // assertions ignored for now
    }
  }

  private void renderParameterCell(RenderingStatus status, XhtmlNode td, List<ResourceWrapper> params) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (params.isEmpty()) {
      return;
    }
    if (params.size() == 1) {
      renderParameter(status, td, params.get(0));
    } else {
      XhtmlNode ul = td.ul();
      for (ResourceWrapper param : params) {
        renderParameter(status, ul.li(), param);
      }
    }
  }

  private void renderParameter(RenderingStatus status, XhtmlNode x, ResourceWrapper param) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    x.tx(param.primitiveValue("name") + " = ");
    if (param.has("value[x]")) {
      renderDataType(status, x, param.child("value[x]"));
    }
  }

  private void renderInputCell(RenderingStatus status, XhtmlNode td, List<ResourceWrapper> inputs) {
    if (inputs.isEmpty()) {
      return;
    }
    if (inputs.size() == 1) {
      td.tx(inputSummary(inputs.get(0)));
    } else {
      XhtmlNode ul = td.ul();
      for (ResourceWrapper input : inputs) {
        ul.li().tx(inputSummary(input));
      }
    }
  }

  private String inputSummary(ResourceWrapper input) {
    if (input.has("name")) {
      return input.primitiveValue("name");
    }
    if (input.has("file")) {
      return input.primitiveValue("file");
    }
    if (input.has("resource")) {
      return input.child("resource").fhirType();
    }
    return "";
  }

  private void renderCanonicalCell(RenderingStatus status, XhtmlNode td, ResourceWrapper canonical) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (canonical != null) {
      renderDataType(status, td, canonical);
    }
  }

  private void descriptionCell(XhtmlNode td, ResourceWrapper w) {
    if (w.has("description")) {
      td.tx(w.primitiveValue("description"));
    }
  }

  private boolean anyHasDescription(List<ResourceWrapper> list) {
    return anyHas(list, "description");
  }

  private boolean anyHas(List<ResourceWrapper> list, String name) {
    // has() is true whether the child is a primitive (name/file/mode/description) or a
    // non-primitive (the contained resource in an input), which is exactly what we want to
    // decide whether a column is needed
    for (ResourceWrapper w : list) {
      if (w.has(name)) {
        return true;
      }
    }
    return false;
  }

}
