package org.hl7.fhir.r5.test;

import static org.junit.Assert.*;

import org.hl7.fhir.r5.context.MetadataResourceManager;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ValueSet;
import org.junit.Assert;
import org.junit.Test;

public class MetadataResourceManagerTester {

  private MetadataResourceManager<ValueSet> mrm = new MetadataResourceManager<>();
  
  @Test
  public void testSingleNoVersion() {
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    // no version
    
    mrm.clear();
    mrm.see(vs);
    
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    mrm.see(vs);    
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));

    mrm.drop("2344");
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    
    mrm.drop("2345");
    Assert.assertEquals(mrm.size(), 0);
    Assert.assertNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertNull(mrm.get("2345"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
  }

  @Test
  public void testSingleWithVersion() {
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    vs.setVersion("4.0.1");
    
    mrm.clear();
    mrm.see(vs);
    
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersionNotSemVer() {
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("http://url/ValueSet/234");
    vs.setVersion("20140403");
    
    mrm.clear();
    mrm.see(vs);
    
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "20140403"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "20140402"));
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "2014"));
  }

  @Test
  public void testSingleWithVersions1() {
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
    mrm.see(vs1);
    
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertEquals(mrm.get("2345").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.see(vs2);

    Assert.assertEquals(mrm.size(), 2);
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertEquals(mrm.get("2345").getName(), "1");
    Assert.assertNotNull(mrm.get("2346"));
    Assert.assertEquals(mrm.get("2346").getName(), "2");
    
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // vs2;
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertNull(mrm.get("2346"));
    Assert.assertEquals(mrm.get("2345").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

  }

  @Test
  public void testSingleWithVersions2() {
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
    mrm.see(vs1);
    
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertEquals(mrm.get("2345").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "1");
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.see(vs2);

    Assert.assertEquals(mrm.size(), 2);
    Assert.assertNotNull(mrm.get("2345"));
    Assert.assertEquals(mrm.get("2345").getName(), "1");
    Assert.assertNotNull(mrm.get("2346"));
    Assert.assertEquals(mrm.get("2346").getName(), "2");
    
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "1");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs1;
    Assert.assertEquals(mrm.size(), 1);
    Assert.assertNull(mrm.get("2345"));
    Assert.assertNotNull(mrm.get("2346"));
    Assert.assertEquals(mrm.get("2346").getName(), "2");
    
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.0").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.1"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.1").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0.2"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0.2").getName(), "2");
    Assert.assertNotNull(mrm.get("http://url/ValueSet/234", "4.0"));
    Assert.assertEquals(mrm.get("http://url/ValueSet/234", "4.0").getName(), "2");
    Assert.assertNull(mrm.get("http://url/ValueSet/234", "4.1"));
  }

}
