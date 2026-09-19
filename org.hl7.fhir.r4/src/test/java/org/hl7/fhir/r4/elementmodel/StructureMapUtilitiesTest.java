package org.hl7.fhir.r4.elementmodel;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification,
  are permitted provided that the following conditions are met:

   * Redistributions of source code must retain the above copyright notice, this
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice,
     this list of conditions and the following disclaimer in the documentation
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to
     endorse or promote products derived from this software without specific
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  POSSIBILITY OF SUCH DAMAGE.
 */

import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.StructureMapUtilities;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StructureMapUtilitiesTest {

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
    assertThat(patientDefinition).isNotNull();

    Element target = Manager.build(workerContext, patientDefinition);
    mapUtilities.transform(null, source, topMap, target);

    Patient result = (Patient) new ObjectConverter(workerContext).convert(target);
    assertThat(result.getContact()).hasSize(1);
    assertThat(result.getContactFirstRep().getName().getFamily()).isEqualTo("Jansen");
    assertThat(result.getContactFirstRep().getName().getGivenAsSingleString()).isEqualTo("Anja");
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
    source.addContact(new Patient.ContactComponent().setOrganization(new Reference("Organization/123").setDisplay("St. Antonius")));

    StructureDefinition patientDefinition = workerContext.fetchTypeDefinition("Patient");
    assertThat(patientDefinition).isNotNull();

    Element target = Manager.build(workerContext, patientDefinition);
    StructureMap supplementMap = buildAnonymousBackboneSupplementMap(topMap, "contact", "CopyContact");
    mapUtilities.transform(null, source.getContactFirstRep(), supplementMap, target);

    Patient result = (Patient) new ObjectConverter(workerContext).convert(target);
    assertThat(result.getContact()).hasSize(1);
    assertThat(result.getContactFirstRep().getExtension()).hasSize(1);
    assertThat(result.getContactFirstRep().getExtensionFirstRep().getUrl())
        .isEqualTo("http://example.org/StructureDefinition/patient-relatedPerson");
    assertThat(result.getContactFirstRep().getExtensionFirstRep().getValue()).isInstanceOf(Reference.class);
    Reference value = (Reference) result.getContactFirstRep().getExtensionFirstRep().getValue();
    assertThat(value.getReference()).isEqualTo("Organization/123");
    assertThat(value.getDisplay()).isEqualTo("St. Antonius");
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
        .addTarget(new StructureMap.StructureMapGroupRuleTargetComponent().setContext("tgt").setElement(theTargetElementName)
            .setVariable("t"))
        .addDependent(new StructureMap.StructureMapGroupRuleDependentComponent().setName(theSubgroupName).addVariable("s")
            .addVariable("t"));

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
        typeNames.addAll(List.of("Address", "BackboneElement", "CodeableConcept", "Coding", "ContactPoint", "Extension",
            "HumanName", "Meta", "Period", "Reference"));
        return typeNames;
      }
      return theMethod.invoke(theDelegate, theArgs);
    };
    return (IWorkerContext) Proxy.newProxyInstance(IWorkerContext.class.getClassLoader(), new Class<?>[] { IWorkerContext.class },
        handler);
  }

  private static class TestTransformerServices implements StructureMapUtilities.ITransformerServices {
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
