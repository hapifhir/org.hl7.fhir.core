package org.hl7.fhir.r5.test.rendering;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ValidatedFragment;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.renderers.utils.ResourceElement.ElementKind;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourceElementTests {

  @Test
  public void testDirect() throws FHIRFormatError, IOException {
    IWorkerContext worker = TestingUtilities.getSharedWorkerContext();
    Resource res = new XmlParser().parse(TestingUtilities.loadTestResource("r5", "bundle-resource-element-test.xml"));
    ResourceElement re = ResourceElement.forResource(new ContextUtilities(worker), new ProfileUtilities(worker, null, null), res);
    checkTree(re); 
  }
  
  @Test
  public void testIndirect() throws FHIRFormatError, IOException {
    IWorkerContext worker = TestingUtilities.getSharedWorkerContext();
    List<ValidatedFragment> res = Manager.parse(worker, TestingUtilities.loadTestResourceStream("r5", "bundle-resource-element-test.xml"), FhirFormat.XML);
    ResourceElement re = ResourceElement.forResource(new ContextUtilities(worker), new ProfileUtilities(worker, null, null), res.get(0).getElement());
    checkTree(re);
  }

  private void checkTree(ResourceElement bnd) {
    Assertions.assertTrue(bnd.fhirType().equals("Bundle"));
    Assertions.assertNull(bnd.name());
    Assertions.assertNull(bnd.getId());
    Assertions.assertEquals("Bundle", bnd.path());
    Assertions.assertEquals("5.0.0", bnd.fhirVersion());
    Assertions.assertFalse(bnd.canHaveNarrative());
    Assertions.assertFalse(bnd.hasNarrative());
    Assertions.assertEquals(ElementKind.IndependentResource, bnd.kind());
    
    ResourceElement type = bnd.child("type");
    Assertions.assertTrue(type.fhirType().equals("code"));
    Assertions.assertEquals("type", type.name());
    Assertions.assertEquals("Bundle.type", type.path());
    Assertions.assertTrue(type.isPrimitive());
    Assertions.assertTrue(type.hasPrimitiveValue());
    Assertions.assertEquals("collection", type.primitiveValue());
    Assertions.assertFalse(type.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, type.kind());
    
    ResourceElement id = bnd.child("identifier");
    Assertions.assertEquals("Identifier", id.fhirType());
    Assertions.assertEquals("identifier", id.name());
    Assertions.assertEquals("Bundle.identifier", id.path());
    Assertions.assertFalse(id.isPrimitive());
    Assertions.assertFalse(id.hasPrimitiveValue());
    Assertions.assertTrue(id.hasChildren());
    Assertions.assertEquals(ElementKind.DataType, id.kind());

    ResourceElement system = id.child("system");
    Assertions.assertEquals("uri", system.fhirType());
    Assertions.assertEquals("system", system.name());
    Assertions.assertEquals("Bundle.identifier.system", system.path());
    Assertions.assertTrue(system.isPrimitive());
    Assertions.assertTrue(system.hasPrimitiveValue());
    Assertions.assertEquals("http://something1", system.primitiveValue());
    Assertions.assertFalse(system.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, system.kind());

    ResourceElement value = id.child("value");
    Assertions.assertEquals("string", value.fhirType());
    Assertions.assertEquals("value", value.name());
    Assertions.assertEquals("Bundle.identifier.value", value.path());
    Assertions.assertTrue(value.isPrimitive());
    Assertions.assertTrue(value.hasPrimitiveValue());
    Assertions.assertEquals("something2", value.primitiveValue());
    Assertions.assertFalse(value.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, value.kind());

    int i = 0;
    for (ResourceElement link : bnd.children("link")) {
      checkLink(i, link);
      i++;
    }

    ResourceElement entry = bnd.child("entry");
    Assertions.assertEquals("Bundle.entry", entry.fhirType());
    Assertions.assertEquals("entry", entry.name());
    Assertions.assertEquals("Bundle.entry[0]", entry.path());
    Assertions.assertFalse(entry.isPrimitive());
    Assertions.assertFalse(entry.hasPrimitiveValue());
    Assertions.assertTrue(entry.hasChildren());
    Assertions.assertEquals(ElementKind.BackboneElement, entry.kind());

    ResourceElement fu = entry.child("fullUrl");
    Assertions.assertEquals("uri", fu.fhirType());
    Assertions.assertEquals("fullUrl", fu.name());
    Assertions.assertEquals("Bundle.entry[0].fullUrl", fu.path());
    Assertions.assertTrue(fu.isPrimitive());
    Assertions.assertTrue(fu.hasPrimitiveValue());
    Assertions.assertEquals("http://something5", fu.primitiveValue());
    Assertions.assertFalse(fu.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, fu.kind());

    ResourceElement obs = entry.child("resource");
    checkObservation(obs);
  }

  private void checkObservation(ResourceElement obs) {
    Assertions.assertTrue(obs.fhirType().equals("Observation"));
    Assertions.assertEquals("resource", obs.name());
    Assertions.assertEquals("obs1", obs.getId());
    Assertions.assertEquals("Bundle.entry[0].resource", obs.path());
    Assertions.assertEquals(ElementKind.BundleEntry, obs.kind());
    Assertions.assertTrue(obs.canHaveNarrative());
    Assertions.assertTrue(obs.hasNarrative());
    Assertions.assertNotNull(obs.getNarrative());
    
    List<ResourceElement> children = obs.children();
    assertEquals(5, children.size());

    checkObsCode(children.get(3));

    assertEquals(children.get(4), obs.child("value"));
    assertEquals(children.get(4), obs.child("value[x]"));
    checkObsValue(children.get(4));
    
    assertEquals(children.get(2), obs.child("contained"));
    checkContained(children.get(2));
  }

  private void checkContained(ResourceElement cont) {
    Assertions.assertEquals("Provenance", cont.fhirType());
    Assertions.assertEquals("contained", cont.name());
    Assertions.assertEquals("Bundle.entry[0].resource.contained[0]", cont.path());
    Assertions.assertFalse(cont.isPrimitive());
    Assertions.assertFalse(cont.hasPrimitiveValue());
    Assertions.assertTrue(cont.hasChildren());
    Assertions.assertEquals(ElementKind.ContainedResource, cont.kind());
  }

  private void checkObsValue(ResourceElement obsValue) {
    Assertions.assertEquals("Quantity", obsValue.fhirType());
    Assertions.assertEquals("value[x]", obsValue.name());
    Assertions.assertEquals("Bundle.entry[0].resource.value[x]", obsValue.path());
    Assertions.assertFalse(obsValue.isPrimitive());
    Assertions.assertFalse(obsValue.hasPrimitiveValue());
    Assertions.assertTrue(obsValue.hasChildren());
    Assertions.assertEquals(ElementKind.DataType, obsValue.kind());
  }

  private void checkObsCode(ResourceElement obsCode) {
    Assertions.assertEquals("CodeableConcept", obsCode.fhirType());
    Assertions.assertEquals("code", obsCode.name());
    Assertions.assertEquals("Bundle.entry[0].resource.code", obsCode.path());
    Assertions.assertFalse(obsCode.isPrimitive());
    Assertions.assertFalse(obsCode.hasPrimitiveValue());
    Assertions.assertTrue(obsCode.hasChildren());
    Assertions.assertEquals(ElementKind.DataType, obsCode.kind());

    ResourceElement txt = obsCode.children().get(1);
    Assertions.assertEquals("string", txt.fhirType());
    Assertions.assertEquals("text", txt.name());
    Assertions.assertEquals("Bundle.entry[0].resource.code.text", txt.path());
    Assertions.assertTrue(txt.isPrimitive());
    Assertions.assertFalse(txt.hasPrimitiveValue());
    Assertions.assertTrue(txt.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, txt.kind());

    ResourceElement e1 = txt.extension("http://something11");
    Assertions.assertEquals("Extension", e1.fhirType());
    Assertions.assertEquals("extension", e1.name());
    Assertions.assertEquals("Bundle.entry[0].resource.code.text.extension[0]", e1.path());
    Assertions.assertFalse(e1.isPrimitive());
    Assertions.assertFalse(e1.hasPrimitiveValue());
    Assertions.assertTrue(e1.hasChildren());
    Assertions.assertEquals(ElementKind.DataType, e1.kind());
    Assertions.assertEquals("http://something11", e1.primitiveValue("url"));
    
    ResourceElement ev = txt.extensionValue("http://something11");
    Assertions.assertEquals(ev, e1.child("value"));
    Assertions.assertEquals(ev, e1.child("value[x]"));
    
    Assertions.assertEquals("string", ev.fhirType());
    Assertions.assertEquals("value[x]", ev.name());
    Assertions.assertEquals("Bundle.entry[0].resource.code.text.extension[0].value[x]", ev.path());
    Assertions.assertTrue(ev.isPrimitive());
    Assertions.assertTrue(ev.hasPrimitiveValue());
    Assertions.assertFalse(ev.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, ev.kind());
    Assertions.assertEquals("something12", ev.primitiveValue());
  }

  private void checkLink(int i, ResourceElement link) {
    Assertions.assertEquals("Bundle.link", link.fhirType());
    Assertions.assertEquals("link", link.name());
    Assertions.assertEquals("Bundle.link["+i+"]", link.path());
    Assertions.assertFalse(link.isPrimitive());
    Assertions.assertFalse(link.hasPrimitiveValue());
    Assertions.assertTrue(link.hasChildren());
    Assertions.assertEquals(ElementKind.BackboneElement, link.kind());

    ResourceElement rel = link.child("relation");
    Assertions.assertEquals("code", rel.fhirType());
    Assertions.assertEquals("relation", rel.name());
    Assertions.assertEquals("Bundle.link["+i+"].relation", rel.path());
    Assertions.assertTrue(rel.isPrimitive());
    Assertions.assertTrue(rel.hasPrimitiveValue());
    Assertions.assertEquals(i == 0 ? "self" : "next", rel.primitiveValue());
    Assertions.assertFalse(rel.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, rel.kind());

    ResourceElement url = link.child("url");
    Assertions.assertEquals("uri", url.fhirType());
    Assertions.assertEquals("url", url.name());
    Assertions.assertEquals("Bundle.link["+i+"].url", url.path());
    Assertions.assertTrue(url.isPrimitive());
    Assertions.assertTrue(url.hasPrimitiveValue());
    Assertions.assertEquals(i == 0 ? "http://something3" : "http://something4", url.primitiveValue());
    Assertions.assertFalse(url.hasChildren());
    Assertions.assertEquals(ElementKind.PrimitiveType, url.kind());
  }
  
}
