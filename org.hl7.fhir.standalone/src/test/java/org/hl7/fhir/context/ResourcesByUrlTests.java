package org.hl7.fhir.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.ActivityDefinition;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.PackageInformation;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.services.context.CanonicalResourceProxy;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Looking up a resource by url when the url isn't one of a known canonical type (here, ActivityDefinition) uses the
 * context's index of resources by url, which has to stay in step with its index by type and id
 */
class ResourcesByUrlTests {

  private static final String URL_A = "http://example.org/ActivityDefinition/a";
  private static final String URL_B = "http://example.org/ActivityDefinition/b";

  private SimpleWorkerContext context;

  @BeforeEach
  void setUp() throws IOException {
    context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
  }

  private static ActivityDefinition ad(String id, String url, String version) {
    ActivityDefinition ad = new ActivityDefinition();
    ad.setId(id);
    ad.setUrl(url);
    ad.setVersion(version);
    return ad;
  }

  private static CanonicalResourceProxy csProxy(String id, String url, String version) {
    return new CanonicalResourceProxy("CodeSystem", id, url, version, null, null, null) {
      @Override
      public CanonicalResource loadResource() throws FHIRException {
        CodeSystem cs = new CodeSystem();
        cs.setId(id);
        cs.setUrl(url);
        cs.setVersion(version);
        return cs;
      }
    };
  }

  private Resource fetch(SimpleWorkerContext ctxt, String url) {
    return ctxt.fetchResource(Resource.class, url, VersionResolutionRules.defaultRule());
  }

  private Resource fetchByVersion(SimpleWorkerContext ctxt, String url) {
    return ctxt.fetchResourceWithExceptionByVersion((String) null, url, VersionResolutionRules.defaultRule(), null, null);
  }

  private boolean exists(SimpleWorkerContext ctxt, String url) {
    return ctxt.checkResourceExists(null, url, VersionResolutionRules.defaultRule());
  }

  private List<Resource> versions(SimpleWorkerContext ctxt, String url) {
    return ctxt.fetchResourceVersions(Resource.class, url);
  }

  @Test
  void lookupsByUrl() {
    ActivityDefinition a = ad("a", URL_A, "1.0.0");
    context.cacheResource(a);

    assertSame(a, fetch(context, URL_A));
    assertSame(a, fetch(context, URL_A + "|1.0.0"));
    assertNull(fetch(context, URL_A + "|2.0.0"));
    assertSame(a, fetchByVersion(context, URL_A));
    assertTrue(exists(context, URL_A));
    assertEquals(List.of(a), versions(context, URL_A));

    assertNull(fetch(context, URL_B));
    assertNull(fetchByVersion(context, URL_B));
    assertFalse(exists(context, URL_B));
    assertTrue(versions(context, URL_B).isEmpty());
  }

  @Test
  void lookupByUrlAndVersionChecksEachEntryWithTheUrl() {
    ActivityDefinition a1 = ad("a1", URL_A, "1.0.0");
    ActivityDefinition a2 = ad("a2", URL_A, "2.0.0");
    context.cacheResource(a1);
    context.cacheResource(a2);

    assertSame(a2, fetch(context, URL_A));
    assertSame(a1, fetch(context, URL_A + "|1.0.0"));
    assertSame(a2, fetch(context, URL_A + "|2.0.0"));
    assertNull(fetch(context, URL_A + "|3.0.0"));
    assertEquals(List.of(a2, a1), versions(context, URL_A));
  }

  @Test
  void droppedResourceIsNotFoundByUrl() {
    ActivityDefinition a = ad("a", URL_A, "1.0.0");
    ActivityDefinition b = ad("b", URL_B, "1.0.0");
    context.cacheResource(a);
    context.cacheResource(b);

    context.dropResource("ActivityDefinition", "a");

    assertNull(fetch(context, URL_A));
    assertNull(fetchByVersion(context, URL_A));
    assertFalse(exists(context, URL_A));
    assertTrue(versions(context, URL_A).isEmpty());
    assertSame(b, fetch(context, URL_B));
  }

  @Test
  void droppingAResourceDropsEveryVersionOfIt() {
    ActivityDefinition x1 = ad("x", URL_A, "1.0.0");
    ActivityDefinition x2 = ad("x", URL_A, "2.0.0");
    ActivityDefinition y = ad("y", URL_A, "3.0.0");
    context.cacheResource(x1);
    context.cacheResource(x2);
    context.cacheResource(y);

    context.dropResource("ActivityDefinition", "x");

    assertSame(y, fetch(context, URL_A));
    assertNull(fetch(context, URL_A + "|1.0.0"));
    assertNull(fetch(context, URL_A + "|2.0.0"));
    assertEquals(List.of(y), versions(context, URL_A));
  }

  @Test
  void droppingAResourceDropsItsEarlierEntriesWithOtherUrls() {
    ActivityDefinition a = ad("x", URL_A, "1.0.0");
    ActivityDefinition noUrl = ad("x", null, "2.0.0");
    ActivityDefinition b = ad("x", URL_B, "3.0.0");
    context.cacheResource(a);
    context.cacheResource(noUrl);
    context.cacheResource(b);
    assertSame(a, fetch(context, URL_A));

    context.dropResource("ActivityDefinition", "x");

    assertNull(fetch(context, URL_A));
    assertFalse(exists(context, URL_A));
    assertTrue(versions(context, URL_A).isEmpty());
    assertNull(fetch(context, URL_B));
  }

  @Test
  void otherVersionWithTheSameIdIsStillFoundByUrl() {
    ActivityDefinition a1 = ad("x", URL_A, "1.0.0");
    ActivityDefinition a2 = ad("x", URL_A, "2.0.0");
    context.cacheResource(a1);
    context.cacheResource(a2);

    assertSame(a2, context.fetchResourceById("ActivityDefinition", "x"));
    assertSame(a2, fetch(context, URL_A));
    assertSame(a1, fetch(context, URL_A + "|1.0.0"));
    assertEquals(List.of(a2, a1), versions(context, URL_A));
  }

  @Test
  void laterEntryWithTheSameIdIsFoundFirst() {
    ActivityDefinition a = ad("x", URL_A, "1.0.0");
    ActivityDefinition again = ad("x", URL_A, "1.0.0");
    context.cacheResource(a);
    context.cacheResource(again);

    assertSame(again, fetch(context, URL_A));
    assertSame(again, fetch(context, URL_A + "|1.0.0"));
    assertSame(again, fetchByVersion(context, URL_A));
  }

  @Test
  void entryReplacedUnderItsIdIsStillFoundByItsUrl() {
    ActivityDefinition a = ad("x", URL_A, "1.0.0");
    ActivityDefinition b = ad("x", URL_B, "1.0.0");
    context.cacheResource(a);
    context.cacheResource(b);

    assertSame(b, context.fetchResourceById("ActivityDefinition", "x"));
    assertSame(a, fetch(context, URL_A));
    assertSame(b, fetch(context, URL_B));
  }

  @Test
  void versionsOfAProxyFromTwoPackagesAreBothFoundByUrl() {
    String url = "http://example.org/CodeSystem/a";
    context.registerResourceFromPackage(csProxy("x", url, "1.0.0"), new PackageInformation("example.package", "1.0.0", "4.0.1", null));
    context.registerResourceFromPackage(csProxy("x", url, "2.0.0"), new PackageInformation("example.package", "2.0.0", "4.0.1", null));

    assertEquals(2, context.fetchResourceVersions(CodeSystem.class, url).size());
    assertEquals(2, versions(context, url).size());
  }

  @Test
  void examplesPackageDoesNotReplaceOrAddAnExistingId() {
    ActivityDefinition a = ad("x", URL_A, "1.0.0");
    ActivityDefinition example = ad("x", URL_B, "1.0.0");
    ActivityDefinition other = ad("y", "http://example.org/ActivityDefinition/y", "1.0.0");
    PackageInformation examples = new PackageInformation("hl7.fhir.r4.examples", "4.0.1", "4.0.1", null);
    context.cacheResource(a);
    context.cacheResourceFromPackage(example, examples);
    context.cacheResourceFromPackage(other, examples);

    assertSame(a, fetch(context, URL_A));
    assertNull(fetch(context, URL_B));
    assertFalse(exists(context, URL_B));
    assertTrue(versions(context, URL_B).isEmpty());
    assertSame(other, fetch(context, "http://example.org/ActivityDefinition/y"));
  }

  @Test
  void examplesPackageProxyDoesNotReplaceOrAddAnExistingId() {
    PackageInformation pi = new PackageInformation("example.package", "1.0.0", "4.0.1", null);
    PackageInformation examples = new PackageInformation("hl7.fhir.r4.examples", "4.0.1", "4.0.1", null);
    context.registerResourceFromPackage(csProxy("x", "http://example.org/CodeSystem/a", "1.0.0"), pi);
    context.registerResourceFromPackage(csProxy("x", "http://example.org/CodeSystem/b", "1.0.0"), examples);

    assertEquals(1, versions(context, "http://example.org/CodeSystem/a").size());
    assertTrue(versions(context, "http://example.org/CodeSystem/b").isEmpty());
  }

  @Test
  void copiedContextFindsResourcesByUrl() throws IOException {
    ActivityDefinition a = ad("a", URL_A, "1.0.0");
    context.cacheResource(a);

    SimpleWorkerContext copy = new SimpleWorkerContext(context);

    assertSame(a, fetch(copy, URL_A));
    assertSame(a, fetchByVersion(copy, URL_A));
    assertTrue(exists(copy, URL_A));
    assertEquals(List.of(a), versions(copy, URL_A));
  }

  @Test
  void copiedContextsChangeIndependently() throws IOException {
    ActivityDefinition a = ad("a", URL_A, "1.0.0");
    context.cacheResource(a);
    SimpleWorkerContext copy = new SimpleWorkerContext(context);

    ActivityDefinition b = ad("b", URL_B, "1.0.0");
    copy.cacheResource(b);
    copy.dropResource("ActivityDefinition", "a");

    assertNull(fetch(copy, URL_A));
    assertSame(b, fetch(copy, URL_B));
    assertSame(b, copy.fetchResourceById("ActivityDefinition", "b"));

    assertSame(a, fetch(context, URL_A));
    assertSame(a, context.fetchResourceById("ActivityDefinition", "a"));
    assertNull(fetch(context, URL_B));
    assertNull(context.fetchResourceById("ActivityDefinition", "b"));
  }

  @Test
  void resourceWithoutIdIsFoundByUrl() {
    ActivityDefinition a = ad(null, URL_A, "1.0.0");
    context.cacheResource(a);

    assertSame(a, fetch(context, URL_A));
    assertEquals(List.of(a), versions(context, URL_A));
  }
}
