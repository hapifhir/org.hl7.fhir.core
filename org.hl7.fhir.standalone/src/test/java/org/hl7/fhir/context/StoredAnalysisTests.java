package org.hl7.fhir.context;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.NamingSystem;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.junit.jupiter.api.Test;

/**
 * An analysis worked out from the definitions is kept by the context until they change; one worked out while they were
 * changing isn't kept at all
 */
class StoredAnalysisTests {

  private static NamingSystem ns(SimpleWorkerContext ctxt, String id) {
    NamingSystem ns = new NamingSystem(ctxt.getModelContext());
    ns.setId(id);
    ns.setUrl("http://example.org/NamingSystem/" + id);
    return ns;
  }

  @Test
  void anAnalysisIsKeptUntilTheDefinitionsChange() throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    Object analysis = new Object();
    ctxt.storeAnalysis(StoredAnalysisTests.class, analysis, ctxt.getDefinitionsVersion());
    assertSame(analysis, ctxt.retrieveAnalysis(StoredAnalysisTests.class));
    ctxt.cacheResource(ns(ctxt, "a"));
    assertNull(ctxt.retrieveAnalysis(StoredAnalysisTests.class));
  }

  @Test
  void anAnalysisWorkedOutWhileTheDefinitionsChangedIsNotKept() throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    long version = ctxt.getDefinitionsVersion();
    Object analysis = new Object();
    // loaded while the analysis was being worked out
    ctxt.cacheResource(ns(ctxt, "b"));
    ctxt.storeAnalysis(StoredAnalysisTests.class, analysis, version);
    assertNull(ctxt.retrieveAnalysis(StoredAnalysisTests.class));
    // without the version, it's kept, as before
    ctxt.storeAnalysis(StoredAnalysisTests.class, analysis);
    assertSame(analysis, ctxt.retrieveAnalysis(StoredAnalysisTests.class));
  }
}
