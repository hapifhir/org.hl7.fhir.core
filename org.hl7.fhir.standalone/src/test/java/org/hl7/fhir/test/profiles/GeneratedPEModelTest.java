package org.hl7.fhir.test.profiles;


import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.core.Observation;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestPackageLoader;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TimeZone;

public class GeneratedPEModelTest {

  private IWorkerContext ctxt;

  public void load() throws Exception {
    if (ctxt == null) {
      ctxt = TestingUtilities.getSharedWorkerContext();
      FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager.Builder().build();
      NpmPackage npm = pc.loadPackage("hl7.fhir.us.core", "5.0.0");
      ctxt.getManager().loadFromPackage(npm, new TestPackageLoader(Utilities.stringSet("StructureDefinition"), ctxt));
      
      ctxt.getManager().cacheResource(new JsonParser(ctxt).parse(TestingUtilities.loadTestResource("r6", "profiles", "pe-extension-simple.json")));
      ctxt.getManager().cacheResource(new JsonParser(ctxt).parse(TestingUtilities.loadTestResource("r6", "profiles", "pe-extension-complex.json")));
      ctxt.getManager().cacheResource(new JsonParser(ctxt).parse(TestingUtilities.loadTestResource("r6", "profiles", "pe-profile2.json")));
      ctxt.getManager().cacheResource(new JsonParser(ctxt).parse(TestingUtilities.loadTestResource("r6", "profiles", "pe-profile1.json")));
    }
  }

  @Test
  public void testPEGenLoad() throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC+1100"));
    load();
    Observation obs = (Observation) new XmlParser(ctxt).parse(TestingUtilities.loadTestResourceStream("r6", "profiles", "pe-instance.xml"));
    TestProfile tp = TestProfile.fromSource(ctxt, obs);
    Assertions.assertEquals("pe-instance", tp.getId());
    Assertions.assertNotNull(tp);
    Assertions.assertEquals("pe-instance", tp.getId());
    Assertions.assertEquals("something", tp.getIdentifier().getValue());
    Assertions.assertEquals("final", tp.getStatus());
    Assertions.assertEquals("Sexual Orientation", tp.getCode().getText());
    Assertions.assertEquals("Patient/us-example", tp.getSubject().getReference());
    Assertions.assertNull(tp.getEncounter().getReference());
    Assertions.assertNotNull(tp.getEffective());
    Assertions.assertEquals(0, tp.getPerformers().size());
    TestDatatypeProfile dt = tp.getValueCodeableConcept();
    Assertions.assertNotNull(dt);
    Assertions.assertEquals("42035005", dt.getSnomedct().getCode());
    Assertions.assertEquals("LA22876-9", dt.getLoinc().getCode());
    Assertions.assertFalse(dt.hasCoding());
    
    Assertions.assertEquals("code", tp.getSimple());
    Assertions.assertEquals("14647-2", tp.getComplex().getSlice1().getCode());
    Assertions.assertEquals("something", tp.getComplex().getSlice2s().get(0).getValue());
    Assertions.assertEquals(0, tp.getComplex().getExtensions().size());
    
    Observation tgt = tp.build(ctxt);
    new XmlParser(ctxt).setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path("[tmp]", "pe-instance-gen.xml")), tgt);
    
    String msg = new CompareUtilities().checkXMLIsSame("PEGEN", TestingUtilities.loadTestResourceStream("r6", "profiles", "pe-instance.xml"), ManagedFileAccess.inStream(Utilities.path("[tmp]", "pe-instance-gen.xml")));
    Assertions.assertNull(msg, msg);
  }

}
