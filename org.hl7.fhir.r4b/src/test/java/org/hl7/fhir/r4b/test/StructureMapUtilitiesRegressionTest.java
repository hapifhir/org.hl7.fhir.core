package org.hl7.fhir.r4b.test;

import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.context.SimpleWorkerContext;
import org.hl7.fhir.r4b.elementmodel.Element;
import org.hl7.fhir.r4b.elementmodel.Manager;
import org.hl7.fhir.r4b.elementmodel.ObjectConverter;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.Factory;
import org.hl7.fhir.r4b.model.HumanName;
import org.hl7.fhir.r4b.model.Patient;
import org.hl7.fhir.r4b.model.Reference;
import org.hl7.fhir.r4b.model.ResourceFactory;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.model.StructureMap;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.r4b.utils.structuremap.ITransformerServices;
import org.hl7.fhir.r4b.utils.structuremap.StructureMapUtilities;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StructureMapUtilitiesRegressionTest {

  @Test
  void transitiveImportsShouldResolveNamedGroups() throws Exception {
    SimpleWorkerContext delegate = (SimpleWorkerContext) TestingUtilities.context();
    Map<String, StructureMap> mapsByUrl = new LinkedHashMap<String, StructureMap>();
    IWorkerContext workerContext = mapAwareWorkerContext(delegate, mapsByUrl);
    StructureMapUtilities mapUtilities = new StructureMapUtilities(workerContext, new TestTransformerServices(workerContext));

    parseAndRegister(mapUtilities, mapsByUrl,
        "map \"http://example.org/StructureMap/shared/FhirDatatypeCopies\" = \"FhirDatatypeCopies\"\n"
            + "\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Resource\" as source\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Resource\" as target\n"
            + "\n"
            + "group CopyHumanName(source src : HumanName, target tgt : HumanName) {\n"
            + "  src.family as s -> tgt.family = s \"copy-family\";\n"
            + "  src.given as s -> tgt.given = s \"copy-given\";\n"
            + "}\n",
        "FhirDatatypeCopies.map");

    parseAndRegister(mapUtilities, mapsByUrl,
        "map \"http://example.org/StructureMap/mid/Mid\" = \"Mid\"\n"
            + "\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" as source\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" as target\n"
            + "\n"
            + "imports \"http://example.org/StructureMap/shared/FhirDatatypeCopies\"\n"
            + "\n"
            + "group Mid(source src : Patient, target tgt : Patient) {\n"
            + "  src -> tgt \"noop\";\n"
            + "}\n",
        "Mid.map");

    StructureMap topMap = parseAndRegister(mapUtilities, mapsByUrl,
        "map \"http://example.org/StructureMap/top/Top\" = \"Top\"\n"
            + "\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" as source\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" as target\n"
            + "\n"
            + "imports \"http://example.org/StructureMap/mid/Mid\"\n"
            + "\n"
            + "group Top(source src : Patient, target tgt : Patient) {\n"
            + "  src.contact as s -> tgt.contact = create('BackboneElement') as t then CopyContact(s, t) \"copy-contact\";\n"
            + "}\n"
            + "\n"
            + "group CopyContact(source src, target tgt : BackboneElement) {\n"
            + "  src.name as s -> tgt.name as t then CopyHumanName(s, t) \"copy-name\";\n"
            + "}\n",
        "Top.map");

    Patient source = new Patient();
    source.addContact(new Patient.ContactComponent().setName(new HumanName().setFamily("Jansen").addGiven("Anja")));

    StructureDefinition patientDefinition = workerContext.fetchTypeDefinition("Patient");
    assertNotNull(patientDefinition);

    Element target = Manager.build(workerContext, patientDefinition);
    mapUtilities.transform(null, source, topMap, target);

    Patient result = (Patient) new ObjectConverter(workerContext).convert(target);
    assertEquals(1, result.getContact().size());
    assertEquals("Jansen", result.getContactFirstRep().getName().getFamily());
    assertEquals("Anja", result.getContactFirstRep().getName().getGivenAsSingleString());
  }

  @Test
  void anonymousBackboneSupplementShouldPopulateExtensionValueReference() throws Exception {
    SimpleWorkerContext delegate = (SimpleWorkerContext) TestingUtilities.context();
    Map<String, StructureMap> mapsByUrl = new LinkedHashMap<String, StructureMap>();
    IWorkerContext workerContext = mapAwareWorkerContext(delegate, mapsByUrl);
    StructureMapUtilities mapUtilities = new StructureMapUtilities(workerContext, new TestTransformerServices(workerContext));

    StructureMap topMap = parseAndRegister(mapUtilities, mapsByUrl,
        "map \"http://example.org/StructureMap/top/TopAnonymous\" = \"TopAnonymous\"\n"
            + "\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" as source\n"
            + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" as target\n"
            + "\n"
            + "group TopAnonymous(source src : Patient, target tgt : Patient) {\n"
            + "  src.contact as s -> tgt.contact as t then CopyContact(s, t) \"copy-contact\";\n"
            + "}\n"
            + "\n"
            + "group CopyContact(source src, target tgt : BackboneElement) {\n"
            + "  src.organization as s -> tgt.extension = create('Extension') as t then SetRelatedPersonExtension(s, t) \"copy-related-person\";\n"
            + "}\n"
            + "\n"
            + "group SetRelatedPersonExtension(source src : Reference, target tgt : Extension) {\n"
            + "  src -> tgt.url = 'http://example.org/StructureDefinition/patient-relatedPerson' \"set-url\";\n"
            + "  src -> tgt.value = create('Reference') as t then CopyReference(src, t) \"set-value\";\n"
            + "}\n"
            + "\n"
            + "group CopyReference(source src : Reference, target tgt : Reference) {\n"
            + "  src.reference as s -> tgt.reference = s \"copy-reference\";\n"
            + "  src.display as s -> tgt.display = s \"copy-display\";\n"
            + "}\n",
        "TopAnonymous.map");

    Patient source = new Patient();
    source.addContact(
        new Patient.ContactComponent().setOrganization(new Reference("Organization/123").setDisplay("St. Antonius")));

    StructureDefinition patientDefinition = workerContext.fetchTypeDefinition("Patient");
    assertNotNull(patientDefinition);

    Element target = Manager.build(workerContext, patientDefinition);
    StructureMap supplementMap = buildAnonymousBackboneSupplementMap(topMap, "contact", "CopyContact");
    mapUtilities.transform(null, source.getContactFirstRep(), supplementMap, target);

    Patient result = (Patient) new ObjectConverter(workerContext).convert(target);
    assertEquals(1, result.getContact().size());
    assertEquals(1, result.getContactFirstRep().getExtension().size());
    assertEquals("http://example.org/StructureDefinition/patient-relatedPerson",
        result.getContactFirstRep().getExtensionFirstRep().getUrl());
    Reference value = assertInstanceOf(Reference.class, result.getContactFirstRep().getExtensionFirstRep().getValue());
    assertEquals("Organization/123", value.getReference());
    assertEquals("St. Antonius", value.getDisplay());
  }

  private static StructureMap buildAnonymousBackboneSupplementMap(StructureMap theMap, String theTargetElementName,
      String theSubgroupName) {
    StructureMap copied = theMap.copy();
    StructureMap.StructureMapGroupComponent subgroup = copied.getGroup().stream()
        .filter(group -> theSubgroupName.equals(group.getName()))
        .findFirst()
        .orElseThrow(IllegalStateException::new);
    subgroup.getInput().stream()
        .filter(input -> input.getMode() == StructureMap.StructureMapInputMode.TARGET)
        .findFirst()
        .ifPresent(input -> input.setType(null));

    StructureMap.StructureMapGroupComponent rootGroup = new StructureMap.StructureMapGroupComponent();
    rootGroup.setName("SupplementContact");
    rootGroup.addInput().setMode(StructureMap.StructureMapInputMode.SOURCE).setName("src");
    rootGroup.addInput().setMode(StructureMap.StructureMapInputMode.TARGET).setName("tgt").setType("Patient");
    rootGroup.addRule()
        .setName("supplement-contact")
        .addSource(new StructureMap.StructureMapGroupRuleSourceComponent().setContext("src").setVariable("s"))
        .addTarget(new StructureMap.StructureMapGroupRuleTargetComponent().setContext("tgt")
            .setElement(theTargetElementName).setVariable("t"))
        .addDependent(new StructureMap.StructureMapGroupRuleDependentComponent().setName(theSubgroupName)
            .addVariable("s").addVariable("t"));

    copied.getGroup().add(0, rootGroup);
    copied.setName(rootGroup.getName());
    copied.setId(rootGroup.getName());
    copied.setUrl(theMap.getUrl() + "#" + rootGroup.getName());
    return copied;
  }

  private static StructureMap parseAndRegister(StructureMapUtilities theMapUtilities, Map<String, StructureMap> theMapsByUrl,
      String theMapText, String theName) throws Exception {
    StructureMap map = (StructureMap) theMapUtilities.parse(theMapText, theName);
    theMapsByUrl.put(map.getUrl(), map);
    return map;
  }

  private static IWorkerContext mapAwareWorkerContext(IWorkerContext theDelegate, Map<String, StructureMap> theMapsByUrl) {
    InvocationHandler handler = (theProxy, theMethod, theArgs) -> {
      String name = theMethod.getName();
      if ("getTransform".equals(name)) {
        String url = (String) theArgs[0];
        StructureMap fromRegistry = theMapsByUrl.get(url);
        return fromRegistry != null ? fromRegistry : theMethod.invoke(theDelegate, theArgs);
      }
      if ("listTransforms".equals(name)) {
        Map<String, StructureMap> combined = new LinkedHashMap<String, StructureMap>();
        for (StructureMap next : theDelegate.listTransforms()) {
          combined.put(next.getUrl(), next);
        }
        combined.putAll(theMapsByUrl);
        return List.copyOf(combined.values());
      }
      if ("getTypeNames".equals(name)) {
        List<String> typeNames = new ArrayList<String>(theDelegate.getTypeNames());
        typeNames.addAll(List.of("Address", "BackboneElement", "CodeableConcept", "Coding", "ContactPoint",
            "Extension", "HumanName", "Meta", "Period", "Reference"));
        return typeNames;
      }
      return theMethod.invoke(theDelegate, theArgs);
    };
    return (IWorkerContext) Proxy.newProxyInstance(IWorkerContext.class.getClassLoader(),
        new Class<?>[] { IWorkerContext.class }, handler);
  }

  private static class TestTransformerServices implements ITransformerServices {
    private final IWorkerContext myWorkerContext;

    private TestTransformerServices(IWorkerContext theWorkerContext) {
      myWorkerContext = theWorkerContext;
    }

    @Override
    public void log(String message) {
      // nothing
    }

    @Override
    public Base createType(Object appInfo, String name) {
      if (name == null || name.isBlank()) {
        return new StringType();
      }
      try {
        return ResourceFactory.createType(name);
      } catch (Exception e) {
        try {
          return new Factory().create(name);
        } catch (Exception ignored) {
          StructureDefinition definition = myWorkerContext.fetchTypeDefinition(name);
          if (definition == null) {
            definition = myWorkerContext.fetchResource(StructureDefinition.class, name);
          }
          if (definition == null) {
            throw new IllegalArgumentException("Unknown data type " + name, e);
          }
          return Manager.build(myWorkerContext, definition);
        }
      }
    }

    @Override
    public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
      return res;
    }

    @Override
    public Coding translate(Object appInfo, Coding source, String conceptMapUrl) {
      return source;
    }

    @Override
    public Base resolveReference(Object appContext, String url) {
      return null;
    }

    @Override
    public List<Base> performSearch(Object appContext, String url) {
      return List.of();
    }
  }
}
