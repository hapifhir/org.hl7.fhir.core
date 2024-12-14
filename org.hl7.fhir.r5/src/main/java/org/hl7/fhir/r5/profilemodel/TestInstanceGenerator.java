package org.hl7.fhir.r5.profilemodel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.utilities.Utilities;

public class TestInstanceGenerator {

  private IWorkerContext context;
  private Map<String, String> data;
  
  public TestInstanceGenerator(IWorkerContext context) {
    super();
    this.context = context;
  }

  public byte[] generate(StructureDefinition profile, FhirFormat format) throws FHIRException, IOException {
    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.NONE, true);
    PEDefinition definition = builder.buildPEDefinition(profile);
    Element element = Manager.build(context, profile);
    
    populateByProfile(element, definition, 0);
    
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    Manager.compose(context, element, ba, format, OutputStyle.PRETTY, null);
    return ba.toByteArray();
  }
  
  protected void populateByProfile(Element element, PEDefinition definition, int level) {
    if (definition.types().size() == 1) {
      for (PEDefinition pe : definition.directChildren(true)) {
        if (!isIgnoredElement(pe.definition().getBase().getPath())) {
          populateElement(element, pe, level);
        }
      }
    }
  }

  private boolean isIgnoredElement(String path) {
    return Utilities.existsInList(path, "Identifier.assigner", "Resource.meta", "DomainResource.text");
  }

  public void populateElement(Element element, PEDefinition pe, int level) {
    System.out.println(pe.path());
    if (pe.hasFixedValue()) {
      Element focus = element.addElement(pe.schemaName());
      Base fv = pe.definition().hasPattern() ? pe.definition().getPattern() : pe.definition().getFixed();
      if (fv.isPrimitive()) {
        focus.setValue(fv.primitiveValue());
      } else {
        populateElementFromDataType(element, fv, null);
      }
    } else if (!pe.isSlicer() && pe.max() == 1) {
      for (int i = 0; i < pe.max(); i++) {
        makeChildElement(element, pe, level);
      }
    }
  }

  public void makeChildElement(Element element, PEDefinition pe, int level) {
    Element b = null;
    if (pe.schemaName().endsWith("[x]")) {
      if (pe.types().size() == 1) {
        b = element.makeElement(pe.schemaName().replace("[x]", Utilities.capitalize(pe.types().get(0).getType())));
      }
    } else {
      b = element.makeElement(pe.schemaName());
    }
    if (b != null) {
      if (pe.definition.hasBinding()) {
        
      } else if (b.isPrimitive()) {
        switch (b.fhirType()) {
        case "id": b.setValue(UUID.randomUUID().toString().toLowerCase());
        }
      } else {
        populateByProfile(b, pe, level+1);
      }
    }
  }

  private void populateElementFromDataType(Element element, Base fv, Object object) {
    // TODO Auto-generated method stub
    
  }

  
}
