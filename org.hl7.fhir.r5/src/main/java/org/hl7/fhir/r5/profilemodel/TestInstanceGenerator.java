package org.hl7.fhir.r5.profilemodel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.Base64;
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
        if (pe.max() > 0 && (!isIgnoredElement(pe.definition().getBase().getPath()) || pe.hasFixedValue())) {
          populateElement(element, pe, level);
        }
      }
    }
  }

  private boolean isIgnoredElement(String path) {
    return Utilities.existsInList(path, "Identifier.assigner", "Resource.meta", "DomainResource.text", "Resource.implicitRules");
  }

  public void populateElement(Element element, PEDefinition pe, int level) {
    System.out.println(pe.path());
    if (!pe.isSlicer() && isNonAbstractType(pe)) {
      if (pe.hasFixedValue()) {
        Element focus = element.addElement(pe.schemaName());
        Base fv = pe.definition().hasPattern() ? pe.definition().getPattern() : pe.definition().getFixed();
        if (fv.isPrimitive()) {
          focus.setValue(fv.primitiveValue());
        } else {
          populateElementFromDataType(element, fv, null);
        }
      } else {
        makeChildElement(element, pe, level);
      }
    }
  }

  private boolean isNonAbstractType(PEDefinition pe) {
    for (PEType t : pe.types()) {
      if (!pe.getBuilder().getContextUtilities().isAbstractType(t.getType())) {
        return true;
      }
    }
    return false;
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
        ValueSet vs = pe.valueSet();
        if (vs != null) {
          ValueSetExpansionOutcome vse = context.expandVS(vs, true, false);
          if (vse.isOk()) {
            ValueSetExpansionContainsComponent cc = pickRandomConcept(vse.getValueset().getExpansion().getContains());
            if (b.isPrimitive()) {  
              b.setValue(vse.getValueset().getExpansion().getContainsFirstRep().getCode());
            } else if ("Coding".equals(b.fhirType())) {
              populateElementFromDataType(b, new Coding(cc), null);
            } else if ("CodeableConcept".equals(b.fhirType())) {
              populateElementFromDataType(b, new CodeableConcept(new Coding(cc)), null);
            }
          } else {
            System.out.println("  ValueSet Error: "+vse.getError());
          }
        } else {
          System.out.println("  Unknown ValueSet: "+pe.definition.getBinding().getValueSet());
        }
      } else if (b.isPrimitive()) {
        switch (b.fhirType()) {
        case "id": 
          b.setValue(UUID.randomUUID().toString().toLowerCase());
          break;
        case "string": 
          b.setValue("Some String value");
          break;
        case "base64Binary" : 
          b.setValue(java.util.Base64.getMimeEncoder().encodeToString("Some Binary Value".getBytes(StandardCharsets.UTF_8)));
          break;
        case "boolean" : 
          b.setValue(ThreadLocalRandom.current().nextInt(0, 2) == 1 ? "true" : "false");
          break;
        case "date" : 
          b.setValue(new DateType(new Date()).asStringValue());
          break;
        case "dateTime": 
          b.setValue(new DateTimeType(new Date()).asStringValue());
          break;
        case "positiveInt" :
          b.setValue(Integer.toString(ThreadLocalRandom.current().nextInt(1, 1000)));
          break;
        case "usignedInt" : 
          b.setValue(Integer.toString(ThreadLocalRandom.current().nextInt(0, 1000)));
          break;
        case "url" : 
          b.setValue("http://some.url/path");
          break;
                    
        default:
          System.out.println("Unhandled type: "+b.fhirType());
        }
      } else {
        populateByProfile(b, pe, level+1);
      }
    }
  }

  private ValueSetExpansionContainsComponent pickRandomConcept(List<ValueSetExpansionContainsComponent> list) {
    ValueSetExpansionContainsComponent res = null;
    while (res == null) {
      int r = ThreadLocalRandom.current().nextInt(0, list.size());
      if (list.get(r).getAbstract()) {
        if (list.get(r).hasContains()) {
          res = pickRandomConcept(list.get(0).getContains());
        }
      } else {
        res = list.get(r);
      }
    }
    return res;
  }

  private void populateElementFromDataType(Element element, Base source, PEDefinition defn) {
    for (Property prop : source.children()) {
      for (Base b : prop.getValues()) {
        Element child = element.makeElement(prop.getName());
        if (b.isPrimitive()) {
          child.setValue(b.primitiveValue());
        } else {
          populateElementFromDataType(child, b, null);
        }
      }
    }
    
    
  }

  
}
