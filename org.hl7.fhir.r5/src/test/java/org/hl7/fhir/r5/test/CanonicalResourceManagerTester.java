package org.hl7.fhir.r5.test;

import org.hl7.fhir.r5.context.CanonicalResourceManager;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r5.model.ValueSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanonicalResourceManagerTester {

  @Test
  public void testSingleNoVersion() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false);
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
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false);
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
    

    mrm.see(vs1, new PackageVersion("hl7.fhir.r4.core", "4.0.1"));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertTrue(mrm.get("http://terminology.hl7.org/ValueSet/234").getName().equals("1"));

    mrm.see(vs2, new PackageVersion("hl7.terminology.r4", "4.0.1"));   
    Assertions.assertNotNull(mrm.get("http://terminology.hl7.org/ValueSet/234"));
    Assertions.assertTrue(mrm.get("http://terminology.hl7.org/ValueSet/234").getName().equals("2"));
    Assertions.assertNull(mrm.get("http://terminology.hl7.org/ValueSet/234", "2.0.0")); // this will get dropped completely because of UTG rules
  }
}