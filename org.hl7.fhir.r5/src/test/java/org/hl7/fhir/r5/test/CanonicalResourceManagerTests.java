package org.hl7.fhir.r5.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r5.context.CanonicalResourceManager;
import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.ValueSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanonicalResourceManagerTests {

  public class DeferredLoadTestResource extends CanonicalResourceProxy {
    private CanonicalResource resource;

    public DeferredLoadTestResource(CanonicalResource resource) {
      super(resource.fhirType(), resource.getId(), resource.getUrl(), resource.getVersion(), resource instanceof CodeSystem ? ((CodeSystem) resource).getSupplements() : null, null, null);
      this.resource = resource;
    }

    @Override
    public CanonicalResource loadResource() {
      return resource;
    }    
  }

  @Test
  public void testSingleNoVersion() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    // no version
    
    mrm.clear();
    mrm.see(vs, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    mrm.see(vs, null);    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));

    mrm.drop("2344");
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    
    mrm.drop("2345");
    Assertions.assertEquals(mrm.size(), 0);
    Assertions.assertNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
  }

  @Test
  public void testSingleWithVersion() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    vs.setVersion("4.0.1");
    
    mrm.clear();
    mrm.see(vs, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersionNotSemVer() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    vs.setVersion("20140403");
    
    mrm.clear();
    mrm.see(vs, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "20140403"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "20140402"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "2014"));
  }

  @Test
  public void testSingleWithDuplicateIds1() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // doesn't exist;
    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2345").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
    
    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(mrm.size(), 0);
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));   
  }

  @Test
  public void testSingleWithDuplicateIds2() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(mrm.size(), 0);
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersions1() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2346").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // vs2;
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

  }

  @Test
  public void testSingleWithVersions2() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2346").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs1;
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2346").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testUTG1() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("234");
    vs1.setUrl("http://terminology.hl7.org/ValueSet/234");
    vs1.setVersion("2.0.0");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("234");
    vs2.setUrl("http://terminology.hl7.org/ValueSet/234");
    vs2.setVersion("2000.0.0");
    vs2.setName("2");
    

    mrm.see(vs1, null);
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertTrue(mrm.get("http://terminology.hl7.org/ValueSet/234").getName().equals("1"));

    mrm.see(vs2, null);   
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234"));
    Assertions.assertTrue(mrm.get("http://terminology.hl7.org/ValueSet/234").getName().equals("2"));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2000.0.0"));
  }
  
  @Test
  public void testUTG2() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("234");
    vs1.setUrl("http://terminology.hl7.org/ValueSet/234");
    vs1.setVersion("2.0.0");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("234");
    vs2.setUrl("http://terminology.hl7.org/ValueSet/234");
    vs2.setVersion("2000.0.0");
    vs2.setName("2");

    mrm.see(vs1, new PackageInformation("hl7.fhir.r4.core", "4.0.1", "4.0.1", new Date()));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertTrue(mrm.get("http://terminology.hl7.org/ValueSet/234").getName().equals("1"));

    mrm.see(vs2, new PackageInformation("hl7.terminology.r4", "4.0.1", "4.0.1", new Date()));   
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234"));
    Assertions.assertTrue(mrm.get("http://terminology.hl7.org/ValueSet/234").getName().equals("2"));
    Assertions.assertNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2.0.0")); // this will get dropped completely because of UTG rules
  }
  
  @Test
  public void testSingleNoVersionDeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    // no version
    DeferredLoadTestResource vsd = new DeferredLoadTestResource(vs);
    
    mrm.clear();
    mrm.register(vsd, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    mrm.register(vsd, null);    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));

    mrm.drop("2344");
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    
    mrm.drop("2345");
    Assertions.assertEquals(mrm.size(), 0);
    Assertions.assertNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
  }

  @Test
  public void testSingleWithVersionDeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    vs.setVersion("4.0.1");
    DeferredLoadTestResource vsd = new DeferredLoadTestResource(vs);
    
    mrm.clear();
    mrm.register(vsd, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersionNotSemVerDeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    vs.setVersion("20140403");
    DeferredLoadTestResource vsd = new DeferredLoadTestResource(vs);

    mrm.clear();
    mrm.register(vsd, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "20140403"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "20140402"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "2014"));
  }

  @Test
  public void testSingleWithDuplicateIds1DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // doesn't exist;
    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2345").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
    
    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(mrm.size(), 0);
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));   
  }

  @Test
  public void testSingleWithDuplicateIds2DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(mrm.size(), 0);
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersions1DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2346").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // vs2;
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

  }

  @Test
  public void testSingleWithVersions2DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(mrm.size(), 2);
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals(mrm.get("2345").getName(), "1");
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2346").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs1;
    Assertions.assertEquals(mrm.size(), 1);
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals(mrm.get("2346").getName(), "2");
    
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assertions.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assertions.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assertions.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testPackageSpecificResolution1() {
    // we add 2 canonicals to the cache with the same identification, but different package information
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("http://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);
    mrm.see(vs1, new PackageInformation("pid.one", "1.0.0", "4.0.1", new Date()));

    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("http://url/ValueSet/234");
    vs2.setVersion("4.0.1");
    vs2.setName("2");
    mrm.see(vs2, new PackageInformation("pid.two", "1.0.0", "4.0.1", new Date()));

    List<String> pvl1 = new ArrayList<>();
    pvl1.add("pid.one#1.0.0");
    
    List<String> pvl2 = new ArrayList<>();
    pvl1.add("pid.two#1.0.0");
    
    Assertions.assertEquals("2", mrm.get("http://url/ValueSet/234").getName());
    Assertions.assertEquals("1", mrm.getByPackage("http://url/ValueSet/234", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("http://url/ValueSet/234", pvl2).getName());

    Assertions.assertEquals("2", mrm.get("http://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertEquals("1", mrm.getByPackage("http://url/ValueSet/234", "4.0.1", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("http://url/ValueSet/234", "4.0.1", pvl2).getName());

    Assertions.assertEquals("2", mrm.get("http://url/ValueSet/234", "4.0").getName());
    Assertions.assertEquals("1", mrm.getByPackage("http://url/ValueSet/234", "4.0", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("http://url/ValueSet/234", "4.0", pvl2).getName());
    
    Assertions.assertEquals("2", mrm.get("http://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertEquals("1", mrm.getByPackage("http://url/ValueSet/234", "4.0.2", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("http://url/ValueSet/234", "4.0.2", pvl2).getName());
  }

  @Test
  public void testSupplements() {
    CanonicalResourceManager<CodeSystem> mrm = new CanonicalResourceManager<>(true, false);
    CodeSystem csb1 = new CodeSystem();
    csb1.setId("2345");
    csb1.setUrl("http://url/CodeSystem/234");
    csb1.setVersion("4.0.1");
    csb1.setName("1");
    mrm.see(csb1, new PackageInformation("pid.one", "1.0.0", "4.0.1", new Date()));

    CodeSystem csb2 = new CodeSystem();
    csb2.setId("2346");
    csb2.setUrl("http://url/CodeSystem/234");
    csb2.setVersion("4.0.1");
    csb2.setName("2");
    mrm.see(csb2, new PackageInformation("pid.two", "1.0.0", "4.0.1", new Date()));

    CodeSystem css1 = new CodeSystem();
    css1.setId("s2345");
    css1.setUrl("http://url/CodeSystem/s234");
    css1.setVersion("4.0.1");
    css1.setName("s1");
    css1.setSupplements("http://url/CodeSystem/234");
    mrm.see(css1, new PackageInformation("pid.one", "1.0.0", "4.0.1", new Date()));

    CodeSystem css2 = new CodeSystem();
    css2.setId("s2346");
    css2.setUrl("http://url/CodeSystem/s234");
    css2.setVersion("4.0.1");
    css2.setName("s2");
    css2.setSupplements("http://url/CodeSystem/234");
    mrm.see(css2, new PackageInformation("pid.two", "1.0.0", "4.0.1", new Date()));

    List<CodeSystem> sl = mrm.getSupplements("http://url/CodeSystem/234");
    Assertions.assertEquals(2, sl.size());
    sl = mrm.getSupplements("http://url/CodeSystem/234", "1.0.1");
    Assertions.assertEquals(2, sl.size());
    sl = mrm.getSupplements("http://url/CodeSystem/s234");
    Assertions.assertEquals(0, sl.size());

    List<String> pvl = new ArrayList<>();
    pvl.add("pid.two#1.0.0");
    sl = mrm.getSupplements("http://url/CodeSystem/234", "1.0.1", pvl);
    Assertions.assertEquals(1, sl.size());    
    
    mrm.drop("s2346");
    sl = mrm.getSupplements("http://url/CodeSystem/234");
    Assertions.assertEquals(1, sl.size());
    sl = mrm.getSupplements("http://url/CodeSystem/234", "1.0.1");
    Assertions.assertEquals(1, sl.size());
    sl = mrm.getSupplements("http://url/CodeSystem/s234");
    Assertions.assertEquals(0, sl.size());

    pvl = new ArrayList<>();
    pvl.add("pid.two#1.0.0");
    sl = mrm.getSupplements("http://url/CodeSystem/234", "1.0.1", pvl);
    Assertions.assertEquals(1, sl.size()); // cause we fall back to the other     

    pvl = new ArrayList<>();
    pvl.add("pid.one#1.0.0");
    sl = mrm.getSupplements("http://url/CodeSystem/234", "1.0.1", pvl);
    Assertions.assertEquals(1, sl.size());    

    mrm.drop("s2345");   

    mrm.drop("s2346");
    sl = mrm.getSupplements("http://url/CodeSystem/234");
    Assertions.assertEquals(0, sl.size());
    sl = mrm.getSupplements("http://url/CodeSystem/234", "1.0.1");
    Assertions.assertEquals(0, sl.size());
    sl = mrm.getSupplements("http://url/CodeSystem/s234");
    Assertions.assertEquals(0, sl.size());
  }


  @Test
  public void testVersionContentionTemplate() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://url", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = new PackageInformation("hl7.fhir.something", "1.2.3", dateFromStr("2023-04-05"));
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://url", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = new PackageInformation("hl7.fhir.something", "1.2.3", dateFromStr("2023-04-05"));
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://url", "2.0.1");
    Assertions.assertEquals("2", cs.getId());
  }

  private Date dateFromStr(String date) throws ParseException {
    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
    return dt.parse(date);
  }

  private CodeSystem makeCodeSystem(String id, String url, String ver) {
    CodeSystem cs = new CodeSystem();
    cs.setId(id);
    cs.setUrl(url);
    cs.setVersion(ver);
    return cs;
  }

  private PackageInformation makePackageInfo(String id, String version, String date) throws ParseException {
    return new PackageInformation(id, version, "4.0.1", dateFromStr(date));
  }

  // Claude generated test cases

  // =============================================
  // VERSION COMPARISON TESTS
  // =============================================

  @Test
  public void testSemverVersionComparison_HigherVersionWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("2", cs.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("2", csLatest.getId());
  }

  @Test
  public void testSemverVersionComparison_LowerVersionLoses() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("1", cs.getId()); // First one has higher version
  }

  @Test
  public void testDateVersionComparison() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2023-01-01");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2023-06-15");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Later date wins
  }

  @Test
  public void testIntegerVersionComparison() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "5");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "10");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // 10 > 5
  }

  @Test
  public void testVersionedVsUnversioned_VersionedWins1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", null); // No version
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("1", cs.getId()); // Versioned wins
  }

  @Test
  public void testVersionedVsUnversioned_VersionedWins2() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", null); // No version
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("1", cs.getId()); // Versioned wins
  }

  @Test
  public void testPackageVersionedVsUnversioned_VersionedLoses1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1"); // No version
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", null, "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Versioned wins
  }

  @Test
  public void testPackageVersionedVsUnversioned_VersionedLoses2() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1"); // No version
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", null, "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Versioned wins
  }

  @Test
  public void testPackageVersionedVsNP_VersionedLoses1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1"); // No version
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, null);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Versioned wins
  }

  @Test
  public void testPackageVersionedVsNP_VersionedLoses2() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1"); // No version
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, null);
    csm.see(cc2);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Versioned wins
  }

  @Test
  public void testBothUnversioned_MostRecentWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", null);
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", null);
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Most recent wins
  }

  // =============================================
  // PACKAGE COMPARISON TESTS
  // =============================================

  @Test
  public void testSameVersion_PackagedVsUnpackaged_PackagedWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, null); // No package
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("2", cs.getId()); // Packaged wins
  }

  @Test
  public void testSameVersion_BothUnpackaged_MostRecentWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, null);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, null);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("2", cs.getId()); // Most recent wins
  }

  @Test
  public void testSameVersion_DifferentPackageIds_MoreRecentDateWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.other", "1.0.0", "2023-06-15"); // Later date
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("2", cs.getId()); // More recent package date wins
  }

  @Test
  public void testSameVersion_SamePackageId_HigherPackageVersionWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "2.0.0", "2023-01-01"); // Higher package version
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("2", cs.getId()); // Higher package version wins
  }

  @Test
  public void testSameVersion_SamePackage_MostRecentWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01"); // Identical package
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("2", cs.getId()); // Most recent wins (template test case)
  }

  // =============================================
  // COMPLEX SCENARIOS
  // =============================================

  @Test
  public void testComplexScenario_MultipleVersionsAndPackages() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    // Add older version from newer package
    CodeSystem cs1 = makeCodeSystem("1", "http://test", "1.0.0");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "2.0.0", "2023-06-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    // Add newer version from older package
    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.0");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // Higher resource version wins regardless of package
  }

  @Test
  public void testNaturalOrderVersioning() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "v1.2");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "v1.10");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // v1.10 > v1.2 in natural order
  }

  @Test
  public void testMajorMinorVersionRetrieval() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.5");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // Test exact version retrieval
    CodeSystem cs1Exact = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("1", cs1Exact.getId());

    CodeSystem cs2Exact = csm.get("http://test", "2.1.5");
    Assertions.assertEquals("2", cs2Exact.getId());

    // Test major.minor retrieval (should get latest patch version)
    CodeSystem cs2MajorMinor = csm.get("http://test", "2.1");
    Assertions.assertEquals("2", cs2MajorMinor.getId());

    CodeSystem cs1MajorMinor = csm.get("http://test", "2.0");
    Assertions.assertEquals("1", cs1MajorMinor.getId());
  }

  // =============================================
  // SEMVER DEPTH MIXING TESTS
  // =============================================

  @Test
  public void testSemverDepth_2_1_Then_2_1_0() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0 > 2.1 (more specific wins)
    CodeSystem csExact2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("2", csExact2_1.getId());

    CodeSystem csExact2_1_0 = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("2", csExact2_1_0.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("2", csLatest.getId());
  }

  @Test
  public void testSemverDepth_2_1_0_Then_2_1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0 > 2.1 (more specific wins, regardless of order added)
    CodeSystem csExact2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("1", csExact2_1.getId()); // Should return 2.1.0 as it's more specific

    CodeSystem csExact2_1_0 = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("1", csExact2_1_0.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("1", csLatest.getId());
  }

  @Test
  public void testSemverDepth_2_1_0_Then_2_1_0_alpha() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0-alpha");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0 > 2.1.0-alpha (release > pre-release)
    CodeSystem csExact2_1_0 = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("1", csExact2_1_0.getId());

    CodeSystem csExact2_1_0_alpha = csm.get("http://test", "2.1.0-alpha");
    Assertions.assertEquals("2", csExact2_1_0_alpha.getId());

    CodeSystem csPartial2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("1", csPartial2_1.getId()); // Should return release version

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("1", csLatest.getId());
  }

  @Test
  public void testSemverDepth_2_1_0_alpha_Then_2_1_0() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0-alpha");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0 > 2.1.0-alpha (release > pre-release, regardless of order)
    CodeSystem csExact2_1_0 = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("2", csExact2_1_0.getId());

    CodeSystem csExact2_1_0_alpha = csm.get("http://test", "2.1.0-alpha");
    Assertions.assertEquals("1", csExact2_1_0_alpha.getId());

    CodeSystem csPartial2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("2", csPartial2_1.getId()); // Should return release version

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("2", csLatest.getId());
  }

  @Test
  public void testSemverDepth_2_1_Then_2_1_0_alpha() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0-alpha");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0-alpha > 2.1 (more specific wins)
    CodeSystem csExact2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("2", csExact2_1.getId());

    CodeSystem csExact2_1_0_alpha = csm.get("http://test", "2.1.0-alpha");
    Assertions.assertEquals("2", csExact2_1_0_alpha.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("2", csLatest.getId());
  }

  @Test
  public void testPrereleaseOrdering_alpha_vs_beta() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0-alpha");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0-beta");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0-beta > 2.1.0-alpha (beta > alpha)
    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("2", csLatest.getId());

    CodeSystem csPartial2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("2", csPartial2_1.getId()); // Should return latest pre-release
  }

  @Test
  public void testPrereleaseOrdering_beta_vs_alpha() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0-beta");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0-alpha");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0-beta > 2.1.0-alpha (beta > alpha, regardless of order)
    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("1", csLatest.getId()); // beta was added first

    CodeSystem csPartial2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("1", csPartial2_1.getId());
  }

  @Test
  public void testPrereleaseNumericOrdering() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0-alpha.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0-alpha.2");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    // 2.1.0-alpha.2 > 2.1.0-alpha.1
    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("2", csLatest.getId());

    CodeSystem csPartial2_11 = csm.get("http://test", "2.1.0-alpha.2");
    Assertions.assertEquals("2", csPartial2_11.getId());

    CodeSystem csPartial2_12 = csm.get("http://test", "2.1.0-alpha");
    Assertions.assertNull(csPartial2_12);

    CodeSystem csPartial2_1b = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("2", csPartial2_1b.getId());

    CodeSystem csPartial2_1d = csm.get("http://test", "2.1");
    Assertions.assertEquals("2", csPartial2_1d.getId());
  }

  @Test
  public void testComplexPrereleaseOrdering() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0-alpha.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.0-alpha.beta");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs3 = makeCodeSystem("3", "http://test", "2.1.0-beta");
    CanonicalResourceProxy cp3 = new DeferredLoadTestResource(cs3);
    PackageInformation pi3 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc3 = csm.new CachedCanonicalResource<CodeSystem>(cp3, pi3);
    csm.see(cc3);

    CodeSystem cs4 = makeCodeSystem("4", "http://test", "2.1.0-beta.2");
    CanonicalResourceProxy cp4 = new DeferredLoadTestResource(cs4);
    PackageInformation pi4 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc4 = csm.new CachedCanonicalResource<CodeSystem>(cp4, pi4);
    csm.see(cc4);

    // 2.1.0-beta.2 > 2.1.0-beta > 2.1.0-alpha.beta > 2.1.0-alpha.1
    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("4", csLatest.getId());

    CodeSystem csPartial2_1 = csm.get("http://test", "2.1");
    Assertions.assertEquals("4", csPartial2_1.getId());
  }

  @Test
  public void testPartialVersionMatching_Multiple_Patch_Versions() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.2");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs3 = makeCodeSystem("3", "http://test", "2.1.10");
    CanonicalResourceProxy cp3 = new DeferredLoadTestResource(cs3);
    PackageInformation pi3 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc3 = csm.new CachedCanonicalResource<CodeSystem>(cp3, pi3);
    csm.see(cc3);

    // Test exact version retrieval
    CodeSystem cs1Exact = csm.get("http://test", "2.1.1");
    Assertions.assertEquals("1", cs1Exact.getId());

    CodeSystem cs2Exact = csm.get("http://test", "2.1.2");
    Assertions.assertEquals("2", cs2Exact.getId());

    CodeSystem cs3Exact = csm.get("http://test", "2.1.10");
    Assertions.assertEquals("3", cs3Exact.getId());

    // Test partial version retrieval - should get latest (2.1.10)
    CodeSystem csPartial = csm.get("http://test", "2.1");
    Assertions.assertEquals("3", csPartial.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("3", csLatest.getId());
  }

  @Test
  public void testPartialVersionMatching_With_Prerelease() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.1.0");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.1.1-alpha");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs3 = makeCodeSystem("3", "http://test", "2.1.1");
    CanonicalResourceProxy cp3 = new DeferredLoadTestResource(cs3);
    PackageInformation pi3 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc3 = csm.new CachedCanonicalResource<CodeSystem>(cp3, pi3);
    csm.see(cc3);

    // Test exact version retrieval
    CodeSystem cs1Exact = csm.get("http://test", "2.1.0");
    Assertions.assertEquals("1", cs1Exact.getId());

    CodeSystem cs2Exact = csm.get("http://test", "2.1.1-alpha");
    Assertions.assertEquals("2", cs2Exact.getId());

    CodeSystem cs3Exact = csm.get("http://test", "2.1.1");
    Assertions.assertEquals("3", cs3Exact.getId());

    // Test partial version retrieval - should get latest release version (2.1.1)
    CodeSystem csPartial = csm.get("http://test", "2.1");
    Assertions.assertEquals("3", csPartial.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("3", csLatest.getId()); // 2.1.1 > 2.1.1-alpha
  }

  @Test
  public void testMixedDepthVersioning_Complex() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs3 = makeCodeSystem("3", "http://test", "2.0.0");
    CanonicalResourceProxy cp3 = new DeferredLoadTestResource(cs3);
    PackageInformation pi3 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc3 = csm.new CachedCanonicalResource<CodeSystem>(cp3, pi3);
    csm.see(cc3);

    CodeSystem cs4 = makeCodeSystem("4", "http://test", "2.0.0-rc.1");
    CanonicalResourceProxy cp4 = new DeferredLoadTestResource(cs4);
    PackageInformation pi4 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc4 = csm.new CachedCanonicalResource<CodeSystem>(cp4, pi4);
    csm.see(cc4);

    // 2.0.0 > 2.0.0-rc.1 > 2.0 > 2 (most specific release wins)
    CodeSystem csExact2 = csm.get("http://test", "2");
    Assertions.assertEquals("3", csExact2.getId()); // Should return most specific: 2.0.0

    CodeSystem csExact2_0 = csm.get("http://test", "2.0");
    Assertions.assertEquals("3", csExact2_0.getId()); // Should return most specific: 2.0.0

    CodeSystem csExact2_0_0 = csm.get("http://test", "2.0.0");
    Assertions.assertEquals("3", csExact2_0_0.getId());

    CodeSystem csLatest = csm.get("http://test", null);
    Assertions.assertEquals("3", csLatest.getId()); // 2.0.0 is the highest release
  }

  // =============================================
  // EDGE CASES
  // =============================================

  @Test
  public void testAlphanumericVersions() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "1.0-alpha");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "1.0-beta");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", null);
    Assertions.assertEquals("2", cs.getId()); // beta > alpha in natural order
  }

  @Test
  public void testSameDateDifferentTime() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<CodeSystem>(false, false);

    CodeSystem cs1 = makeCodeSystem("1", "http://test", "2.0.1");
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    // Both packages on same date - should fall back to most recent addition
    PackageInformation pi1 = makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);

    CodeSystem cs2 = makeCodeSystem("2", "http://test", "2.0.1");
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    PackageInformation pi2 = makePackageInfo("hl7.fhir.other", "1.0.0", "2023-01-01");
    CanonicalResourceManager.CachedCanonicalResource cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);

    CodeSystem cs = csm.get("http://test", "2.0.1");
    Assertions.assertEquals("2", cs.getId()); // Most recent addition wins when dates are equal
  }

}
