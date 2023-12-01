package org.hl7.fhir.r5.profiles;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Observation;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;

public class GeneratedPEModelTest {

  private IWorkerContext ctxt;

  public void load() throws Exception {
    if (ctxt == null) {
      ctxt = TestingUtilities.getSharedWorkerContext();
      FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager.FilesystemPackageCacheManagerBuilder().build();
      NpmPackage npm = pc.loadPackage("hl7.fhir.us.core", "5.0.0");
      ctxt.loadFromPackage(npm, new TestPackageLoader(Utilities.strings("StructureDefinition" )));
      
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-extension-simple.json")));
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-extension-complex.json")));
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-profile2.json")));
      ctxt.cacheResource(new JsonParser().parse(TestingUtilities.loadTestResource("r5", "profiles", "pe-profile1.json")));
    }
  }

  @Test
  public void testPEGenLoad() throws Exception {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC+1100"));
    load();
    Observation obs = (Observation) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "profiles", "pe-instance.xml"));
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
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "pe-instance-gen.xml")), tgt);
    
    String msg = CompareUtilities.checkXMLIsSame(TestingUtilities.loadTestResourceStream("r5", "profiles", "pe-instance.xml"), new FileInputStream(Utilities.path("[tmp]", "pe-instance-gen.xml")));
    Assertions.assertNull(msg, msg);
  }

}
