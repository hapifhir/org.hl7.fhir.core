package org.hl7.fhir.standalone.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.context.CanonicalResourceProxy;
import org.hl7.fhir.standalone.context.BaseWorkerContext.ResourceProxy;
import org.hl7.fhir.standalone.context.BaseWorkerContext.ResourceProxyMap;
import org.junit.jupiter.api.Test;

class ResourceProxyMapTest {

  private static ResourceProxy proxy(String id, String url) {
    return new ResourceProxy(new CanonicalResourceProxy("ValueSet", id, url, "1.0.0", null, null, null) {
      @Override
      public CanonicalResource loadResource() throws FHIRException {
        return new ValueSet().setUrl(url);
      }
    });
  }

  @Test
  void proxyEntriesAreFoundByUrl() {
    ResourceProxyMap map = new ResourceProxyMap();
    map.put("a", proxy("a", "http://example.org/a"));
    map.put("b", proxy("b", "http://example.org/b"));

    assertEquals(2, map.candidatesForUrl("http://example.org/a").size());
    assertTrue(map.candidatesForUrl("http://example.org/c").isEmpty());
  }

  @Test
  void replacedAndRemovedEntriesAreForgotten() {
    ResourceProxyMap map = new ResourceProxyMap();
    map.put("a", proxy("a", "http://example.org/a"));
    map.put("a", proxy("a", "http://example.org/a2"));
    assertTrue(map.candidatesForUrl("http://example.org/a").isEmpty());
    assertEquals(1, map.candidatesForUrl("http://example.org/a2").size());

    map.remove("a");
    assertTrue(map.candidatesForUrl("http://example.org/a2").isEmpty());
  }

  @Test
  void twoProxiesWithTheSameUrl() {
    ResourceProxyMap map = new ResourceProxyMap();
    map.put("a", proxy("a", "http://example.org/a"));
    map.put("b", proxy("b", "http://example.org/a"));
    map.remove("a");
    assertEquals(1, map.candidatesForUrl("http://example.org/a").size());
  }

  @Test
  void resourceEntriesAreFoundByTheirCurrentUrl() {
    ResourceProxyMap map = new ResourceProxyMap();
    ValueSet vs = new ValueSet().setUrl("http://example.org/vs");
    vs.setId("vs");
    map.put("vs", new ResourceProxy(vs));
    map.put("p", new ResourceProxy(new Patient()));
    assertEquals(2, map.candidatesForUrl("http://example.org/vs").size());

    // the url of a resource can change after it's added
    vs.setUrl("http://example.org/vs2");
    assertTrue(map.candidatesForUrl("http://example.org/vs").isEmpty());
    assertEquals(2, map.candidatesForUrl("http://example.org/vs2").size());

    map.remove("vs");
    assertTrue(map.candidatesForUrl("http://example.org/vs2").isEmpty());
  }

  @Test
  void anEntryUnderTwoIds() {
    ResourceProxyMap map = new ResourceProxyMap();
    ValueSet vs = new ValueSet().setUrl("http://example.org/vs");
    ResourceProxy r = new ResourceProxy(vs);
    map.put("a", r);
    map.put("b", r);
    map.remove("a");
    assertEquals(1, map.candidatesForUrl("http://example.org/vs").size());

    ResourceProxy p = proxy("p", "http://example.org/p");
    map.put("p1", p);
    map.put("p2", p);
    map.remove("p1");
    assertEquals(2, map.candidatesForUrl("http://example.org/p").size());
    map.remove("p2");
    assertTrue(map.candidatesForUrl("http://example.org/p").isEmpty());
  }

  @Test
  void aProxyIsUncountedUnderTheUrlItWasCountedUnder() {
    ResourceProxyMap map = new ResourceProxyMap();
    ResourceProxy p = proxy("p", "http://example.org/p");
    map.put("p", p);
    map.put("q", proxy("q", "http://example.org/q"));
    // proxy urls are only meant to be changed before registration, but if one is changed afterwards, removing it
    // still has to forget the url it was found by
    p.getProxy().hack("http://example.org/p2", "2.0");
    map.remove("p");
    assertTrue(map.candidatesForUrl("http://example.org/p").isEmpty());
    assertEquals(1, map.candidatesForUrl("http://example.org/q").size());
  }
}
