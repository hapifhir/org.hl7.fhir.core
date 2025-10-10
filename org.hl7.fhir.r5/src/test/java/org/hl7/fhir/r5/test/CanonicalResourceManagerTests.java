package org.hl7.fhir.r5.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.context.CanonicalResourceManager;
import org.hl7.fhir.r5.context.CanonicalResourceManager.CanonicalResourceProxy;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.ValueSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@Slf4j
public class CanonicalResourceManagerTests {

  public class DeferredLoadTestResource extends CanonicalResourceProxy {
    private final CanonicalResource resource;
    private final long delayInMillis;
    public DeferredLoadTestResource(CanonicalResource resource
    ) {
      this(resource, 0);
    }

    public DeferredLoadTestResource(CanonicalResource resource, long delayInMillis) {
      super(resource.fhirType(), resource.getId(), resource.getUrl(), resource.getVersion(), resource instanceof CodeSystem ? ((CodeSystem) resource).getSupplements() : null, null, null);
      this.resource = resource;
      this.delayInMillis = delayInMillis;
    }

    @Override
    public CanonicalResource loadResource() {
      if (delayInMillis > 0) {
        try {
          Thread.sleep(delayInMillis);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      return resource;
    }
  }

  @Test
  public void testSingleNoVersion() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/234");
    // no version
    
    mrm.clear();
    mrm.see(vs, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    mrm.see(vs, null);    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));

    mrm.drop("2344");
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    
    mrm.drop("2345");
    Assertions.assertEquals(0, mrm.size());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
  }

  @Test
  public void testSingleWithVersion() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/234");
    vs.setVersion("4.0.1");
    
    mrm.clear();
    mrm.see(vs, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersionNotSemVer() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/234");
    vs.setVersion("20140403");
    
    mrm.clear();
    mrm.see(vs, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "20140403"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "20140402"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "2014"));
  }

  @Test
  public void testSingleWithDuplicateIds1() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("2", mrm.get("2345").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // doesn't exist;
    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
    
    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(0, mrm.size());
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));   
  }

  @Test
  public void testSingleWithDuplicateIds2() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("2", mrm.get("2345").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(0, mrm.size());
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersions1() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2346").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // vs2;
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

  }

  @Test
  public void testSingleWithVersions2() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    
    mrm.clear();
    mrm.see(vs1, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.see(vs2, null);

    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2346").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs1;
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2346").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testUTG1() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("234");
    vs1.setUrl("https://terminology.hl7.org/ValueSet/234");
    vs1.setVersion("2.0.0");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("234");
    vs2.setUrl("https://terminology.hl7.org/ValueSet/234");
    vs2.setVersion("2000.0.0");
    vs2.setName("2");
    

    mrm.see(vs1, null);
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertEquals("1", mrm.get("https://terminology.hl7.org/ValueSet/234").getName());

    mrm.see(vs2, null);   
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://terminology.hl7.org/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234", "2000.0.0"));
  }
  
  @Test
  public void testUTG2() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("234");
    vs1.setUrl("https://terminology.hl7.org/ValueSet/234");
    vs1.setVersion("2.0.0");
    vs1.setName("1");
    
    ValueSet vs2 = new ValueSet();
    vs2.setId("234");
    vs2.setUrl("https://terminology.hl7.org/ValueSet/234");
    vs2.setVersion("2000.0.0");
    vs2.setName("2");

    mrm.see(vs1, new PackageInformation("hl7.fhir.r4.core", "4.0.1", "4.0.1", new Date()));
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234", "2.0.0"));
    Assertions.assertEquals("1", mrm.get("https://terminology.hl7.org/ValueSet/234").getName());

    mrm.see(vs2, new PackageInformation("hl7.terminology.r4", "4.0.1", "4.0.1", new Date()));   
    Assertions.assertNotNull(mrm.get("https://terminology.hl7.org/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://terminology.hl7.org/ValueSet/234").getName());
    Assertions.assertNull(mrm.get("https://terminology.hl7.org/ValueSet/234", "2.0.0")); // this will get dropped completely because of UTG rules
  }
  
  @Test
  public void testSingleNoVersionDeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/234");
    // no version
    DeferredLoadTestResource vsd = new DeferredLoadTestResource(vs);
    
    mrm.clear();
    mrm.register(vsd, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    mrm.register(vsd, null);    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));

    mrm.drop("2344");
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    
    mrm.drop("2345");
    Assertions.assertEquals(0, mrm.size());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
  }

  @Test
  public void testSingleWithVersionDeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/234");
    vs.setVersion("4.0.1");
    DeferredLoadTestResource vsd = new DeferredLoadTestResource(vs);
    
    mrm.clear();
    mrm.register(vsd, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersionNotSemVerDeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/234");
    vs.setVersion("20140403");
    DeferredLoadTestResource vsd = new DeferredLoadTestResource(vs);

    mrm.clear();
    mrm.register(vsd, null);
    
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "20140403"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "20140402"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "2014"));
  }

  @Test
  public void testSingleWithDuplicateIds1DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("2", mrm.get("2345").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // doesn't exist;
    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
    
    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(0, mrm.size());
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));   
  }

  @Test
  public void testSingleWithDuplicateIds2DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2345");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("2", mrm.get("2345").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs2;
    Assertions.assertEquals(0, mrm.size());
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testSingleWithVersions1DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2346").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2346"); // vs2;
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertNull(mrm.get("2346"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

  }

  @Test
  public void testSingleWithVersions2DeferredLoad() {
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(true, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");
    DeferredLoadTestResource vs1d = new DeferredLoadTestResource(vs1);

    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.2");
    vs2.setName("2");
    DeferredLoadTestResource vs2d = new DeferredLoadTestResource(vs2);

    mrm.clear();
    mrm.register(vs1d, null);
    
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.register(vs2d, null);

    Assertions.assertEquals(2, mrm.size());
    Assertions.assertNotNull(mrm.get("2345"));
    Assertions.assertEquals("1", mrm.get("2345").getName());
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2346").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("1", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));

    mrm.drop("2345"); // vs1;
    Assertions.assertEquals(1, mrm.size());
    Assertions.assertNull(mrm.get("2345"));
    Assertions.assertNotNull(mrm.get("2346"));
    Assertions.assertEquals("2", mrm.get("2346").getName());
    
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.0").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.1"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0.2"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertNotNull(mrm.get("https://url/ValueSet/234", "4.0"));
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertNull(mrm.get("https://url/ValueSet/234", "4.1"));
  }

  @Test
  public void testPackageSpecificResolution1() {
    // we add 2 canonicals to the cache with the same identification, but different package information
    CanonicalResourceManager<ValueSet> mrm = new CanonicalResourceManager<>(false, false);
    ValueSet vs1 = new ValueSet();
    vs1.setId("2345");
    vs1.setUrl("https://url/ValueSet/234");
    vs1.setVersion("4.0.1");
    vs1.setName("1");

    mrm.see(vs1, new PackageInformation("pid.one", "1.0.0", "4.0.1", new Date()));

    ValueSet vs2 = new ValueSet();
    vs2.setId("2346");
    vs2.setUrl("https://url/ValueSet/234");
    vs2.setVersion("4.0.1");
    vs2.setName("2");
    mrm.see(vs2, new PackageInformation("pid.two", "1.0.0", "4.0.1", new Date()));

    List<String> pvl1 = new ArrayList<>();
    pvl1.add("pid.one#1.0.0");
    
    List<String> pvl2 = new ArrayList<>();
    pvl1.add("pid.two#1.0.0");
    
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234").getName());
    Assertions.assertEquals("1", mrm.getByPackage("https://url/ValueSet/234", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("https://url/ValueSet/234", pvl2).getName());

    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.1").getName());
    Assertions.assertEquals("1", mrm.getByPackage("https://url/ValueSet/234", "4.0.1", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("https://url/ValueSet/234", "4.0.1", pvl2).getName());

    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0").getName());
    Assertions.assertEquals("1", mrm.getByPackage("https://url/ValueSet/234", "4.0", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("https://url/ValueSet/234", "4.0", pvl2).getName());
    
    Assertions.assertEquals("2", mrm.get("https://url/ValueSet/234", "4.0.2").getName());
    Assertions.assertEquals("1", mrm.getByPackage("https://url/ValueSet/234", "4.0.2", pvl1).getName());
    Assertions.assertEquals("2", mrm.getByPackage("https://url/ValueSet/234", "4.0.2", pvl2).getName());
  }

  @Test
  public void testSupplements() {
    CanonicalResourceManager<CodeSystem> mrm = new CanonicalResourceManager<>(true, false);
    CodeSystem csb1 = new CodeSystem();
    csb1.setId("2345");
    csb1.setUrl("https://url/CodeSystem/234");
    csb1.setVersion("4.0.1");
    csb1.setName("1");
    mrm.see(csb1, new PackageInformation("pid.one", "1.0.0", "4.0.1", new Date()));

    CodeSystem csb2 = new CodeSystem();
    csb2.setId("2346");
    csb2.setUrl("https://url/CodeSystem/234");
    csb2.setVersion("4.0.1");
    csb2.setName("2");
    mrm.see(csb2, new PackageInformation("pid.two", "1.0.0", "4.0.1", new Date()));

    CodeSystem css1 = new CodeSystem();
    css1.setId("s2345");
    css1.setUrl("https://url/CodeSystem/s234");
    css1.setVersion("4.0.1");
    css1.setName("s1");
    css1.setSupplements("https://url/CodeSystem/234");
    mrm.see(css1, new PackageInformation("pid.one", "1.0.0", "4.0.1", new Date()));

    CodeSystem css2 = new CodeSystem();
    css2.setId("s2346");
    css2.setUrl("https://url/CodeSystem/s234");
    css2.setVersion("4.0.1");
    css2.setName("s2");
    css2.setSupplements("https://url/CodeSystem/234");
    mrm.see(css2, new PackageInformation("pid.two", "1.0.0", "4.0.1", new Date()));

    List<CodeSystem> sl = mrm.getSupplements("https://url/CodeSystem/234");
    Assertions.assertEquals(2, sl.size());
    sl = mrm.getSupplements("https://url/CodeSystem/234", "1.0.1");
    Assertions.assertEquals(2, sl.size());
    sl = mrm.getSupplements("https://url/CodeSystem/s234");
    Assertions.assertEquals(0, sl.size());

    List<String> pvl = new ArrayList<>();
    pvl.add("pid.two#1.0.0");
    sl = mrm.getSupplements("https://url/CodeSystem/234", "1.0.1", pvl);
    Assertions.assertEquals(1, sl.size());    
    
    mrm.drop("s2346");
    sl = mrm.getSupplements("https://url/CodeSystem/234");
    Assertions.assertEquals(1, sl.size());
    sl = mrm.getSupplements("https://url/CodeSystem/234", "1.0.1");
    Assertions.assertEquals(1, sl.size());
    sl = mrm.getSupplements("https://url/CodeSystem/s234");
    Assertions.assertEquals(0, sl.size());

    pvl = new ArrayList<>();
    pvl.add("pid.two#1.0.0");
    sl = mrm.getSupplements("https://url/CodeSystem/234", "1.0.1", pvl);
    Assertions.assertEquals(1, sl.size()); // because we fall back to the other

    pvl = new ArrayList<>();
    pvl.add("pid.one#1.0.0");
    sl = mrm.getSupplements("https://url/CodeSystem/234", "1.0.1", pvl);
    Assertions.assertEquals(1, sl.size());    

    mrm.drop("s2345");   

    mrm.drop("s2346");
    sl = mrm.getSupplements("https://url/CodeSystem/234");
    Assertions.assertEquals(0, sl.size());
    sl = mrm.getSupplements("https://url/CodeSystem/234", "1.0.1");
    Assertions.assertEquals(0, sl.size());
    sl = mrm.getSupplements("https://url/CodeSystem/s234");
    Assertions.assertEquals(0, sl.size());
  }

  private Date dateFromStr(String date) throws ParseException {
    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
    return dt.parse(date);
  }

  // Claude generated test cases

  // =============================================
  // VERSION COMPARISON TESTS
  // =============================================

  @Test
  public void testSemverVersionComparison_HigherVersionWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);

    registerResources(csm,
      makeCodeSystem("1", "2.0.1"), defaultPackage(),
      makeCodeSystem("2", "2.1.0"), defaultPackage());

    checkResponseResource(csm, "2.1.0", "2");
    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testSemverVersionComparison_LowerVersionLoses() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);

    registerResources(csm,
      makeCodeSystem("1", "2.1.0"), defaultPackage(),
      makeCodeSystem("2", "2.0.1"), defaultPackage());

    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testDateVersionComparison() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2023-01-01"), defaultPackage(),
        makeCodeSystem("2", "2023-06-15"), defaultPackage());

    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testIntegerVersionComparison() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "5"), defaultPackage(),
        makeCodeSystem("2", "10"), defaultPackage());
    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testVersionedVsUnversioned_VersionedWins1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", null), defaultPackage());

    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testVersionedVsUnversioned_VersionedWins2() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("2", null), defaultPackage(), 
        makeCodeSystem("1", "2.0.1"), defaultPackage());

    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testPackageVersionedVsUnversioned_VersionedLoses1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), makePackageInfo("hl7.fhir.core", null, "2023-01-01"));
    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testPackageVersionedVsUnversioned_VersionedLoses2() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("2", "2.0.1"), makePackageInfo("hl7.fhir.core", null, "2023-01-01"),
        makeCodeSystem("1", "2.0.1"), defaultPackage());

    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testPackageVersionedVsNP_VersionedLoses1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), null);

    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testPackageVersionedVsNP_VersionedLoses2() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("2", "2.0.1"), null,
        makeCodeSystem("1", "2.0.1"), defaultPackage());

    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testBothUnversioned_MostRecentWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", null), defaultPackage(),
        makeCodeSystem("2", null), defaultPackage());

    checkResponseResource(csm, null, "2");
  }

  // =============================================
  // PACKAGE COMPARISON TESTS
  // =============================================

  @Test
  public void testSameVersion_PackagedVsUnpackaged_PackagedWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), null);

    checkResponseResource(csm, "2.0.1", "2");
  }

  @Test
  public void testSameVersion_BothUnpackaged_MostRecentWins() {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), null,
        makeCodeSystem("2", "2.0.1"), null);

    checkResponseResource(csm, "2.0.1", "2");
  }

  @Test
  public void testSameVersion_DifferentPackageIds_MoreRecentDateWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), laterPackage());


    checkResponseResource(csm, "2.0.1", "2"); // More recent package date wins
  }

  @Test
  public void testSameVersion_SamePackageId_HigherPackageVersionWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), makePackageInfo("hl7.fhir.core", "2.0.0", "2023-01-01")); // Higher package version;

    checkResponseResource(csm, "2.0.1", "2"); // Higher package version wins
  }

  @Test
  public void testSameVersion_SamePackage_MostRecentWins() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), defaultPackage());

    checkResponseResource(csm, "2.0.1", "2");  // Most recent wins (template test case)
  }

  // =============================================
  // COMPLEX SCENARIOS
  // =============================================

  @Test
  public void testComplexScenario_MultipleVersionsAndPackages() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "1.0.0"),  makePackageInfo("hl7.fhir.core", "2.0.0", "2023-06-01"),
        makeCodeSystem("2", "2.0.0"), defaultPackage());

    checkResponseResource(csm, null, "2"); // Higher resource version wins regardless of package
  }

  @Test
  public void testNaturalOrderVersioning() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "v1.2"), defaultPackage(),
        makeCodeSystem("2", "v1.10"), defaultPackage());

    checkResponseResource(csm, null, "2"); // v1.10 > v1.2 in natural order
  }

  @Test
  public void testMajorMinorVersionRetrieval() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.1.5"), defaultPackage());

    checkResponseResource(csm, "2.0.1", "1"); // Test exact version retrieval
    checkResponseResource(csm, "2.1.5", "2");
    checkResponseResource(csm, "2.1", "2");  // Test major.minor retrieval (should get latest patch version)
    checkResponseResource(csm, "2.0", "1");
  }

  // =============================================
  // SEMVER DEPTH MIXING TESTS
  // =============================================

  @Test
  public void testSemverDepth_2_1_Then_2_1_0() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1"), defaultPackage(),
        makeCodeSystem("2", "2.1.0"), defaultPackage());

    checkResponseResource(csm, "2.1", "2"); // 2.1.0 > 2.1 (more specific wins)
    checkResponseResource(csm, "2.1.0", "2");
    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testSemverDepth_2_1_0_Then_2_1() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0"), defaultPackage(),
        makeCodeSystem("2", "2.1"), defaultPackage());


    checkResponseResource(csm, "2.1", "1"); // 2.1.0 > 2.1 (more specific wins, regardless of order added)
    checkResponseResource(csm, "2.1.0", "1");
    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testSemverDepth_2_1_0_Then_2_1_0_alpha() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0"), defaultPackage(),
        makeCodeSystem("2", "2.1.0-alpha"), defaultPackage());

    checkResponseResource(csm, "2.1.0", "1");  // 2.1.0 > 2.1.0-alpha (release > pre-release)
    checkResponseResource(csm, "2.1.0-alpha", "2");
    checkResponseResource(csm, "2.1", "1"); // Should return release version
    checkResponseResource(csm, null, "1");
  }

  @Test
  public void testSemverDepth_2_1_0_alpha_Then_2_1_0() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0-alpha"), defaultPackage(),
        makeCodeSystem("2", "2.1.0"), defaultPackage());


    checkResponseResource(csm, "2.1.0", "2"); // 2.1.0 > 2.1.0-alpha (release > pre-release, regardless of order)
    checkResponseResource(csm, "2.1.0-alpha", "1");
    checkResponseResource(csm, "2.1", "2"); // Should return release version
    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testSemverDepth_2_1_Then_2_1_0_alpha() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1"), defaultPackage(),
        makeCodeSystem("2", "2.1.0-alpha"), defaultPackage());

    checkResponseResource(csm, "2.1", "2"); // 2.1.0-alpha > 2.1 (more specific wins)
    checkResponseResource(csm, "2.1.0-alpha", "2");
    checkResponseResource(csm, null, "2");
  }

  @Test
  public void testPrereleaseOrdering_alpha_vs_beta() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0-alpha"), defaultPackage(),
        makeCodeSystem("2", "2.1.0-beta"), defaultPackage());


    checkResponseResource(csm, null, "2"); // 2.1.0-beta > 2.1.0-alpha (beta > alpha)
    checkResponseResource(csm, "2.1","2" ); // Should return latest pre-release
  }

  @Test
  public void testPrereleaseOrdering_beta_vs_alpha() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0-beta"), defaultPackage(),
        makeCodeSystem("2", "2.1.0-alpha"), defaultPackage());


    checkResponseResource(csm, null, "1"); // 2.1.0-beta > 2.1.0-alpha (beta > alpha, regardless of order)
    checkResponseResource(csm, "2.1", "1");
  }

  @Test
  public void testPrereleaseNumericOrdering() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0-alpha.1"), defaultPackage(),
        makeCodeSystem("2", "2.1.0-alpha.2"), defaultPackage());

    checkResponseResource(csm, null, "2"); // 2.1.0-alpha.2 > 2.1.0-alpha.1
    checkResponseResource(csm, "2.1.0-alpha.2", "2");
    checkResponseResource(csm, "2.1.0-alpha", null);
    checkResponseResource(csm, "2.1.0", "2");
    checkResponseResource(csm, "2.1", "2");
  }

  @Test
  public void testComplexPrereleaseOrdering() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0-alpha.1"), defaultPackage(),
        makeCodeSystem("2", "2.1.0-alpha.beta"), defaultPackage());
    registerResources(csm,
        makeCodeSystem("3", "2.1.0-beta"), defaultPackage(),
        makeCodeSystem("4", "2.1.0-beta.2"), defaultPackage());

    checkResponseResource(csm, null, "4"); // 2.1.0-beta.2 > 2.1.0-beta > 2.1.0-alpha.beta > 2.1.0-alpha.1
    checkResponseResource(csm, "2.1", "4");
  }

  @Test
  public void testPartialVersionMatching_Multiple_Patch_Versions() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.1"), defaultPackage(),
        makeCodeSystem("2", "2.1.2"), defaultPackage(),
        makeCodeSystem("3", "2.1.10"), defaultPackage());

    // Test exact version retrieval
    checkResponseResource(csm, "2.1.1", "1");
    checkResponseResource(csm, "2.1.2", "2");
    checkResponseResource(csm, "2.1.10", "3");
    // Test partial version retrieval - should get latest (2.1.10)
    checkResponseResource(csm, "2.1", "3");
    checkResponseResource(csm, null, "3");
  }

  @Test
  public void testPartialVersionMatching_With_Prerelease() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.1.0"), defaultPackage(),
        makeCodeSystem("2", "2.1.1-alpha"), defaultPackage(),
        makeCodeSystem("3", "2.1.1"), defaultPackage(),
        makeCodeSystem("4", "2.1.2"), defaultPackage());

    // Test exact version retrieval
    checkResponseResource(csm, "2.1.0", "1");
    checkResponseResource(csm, "2.1.1-alpha", "2");
    checkResponseResource(csm, "2.1.1", "3");
    // Test partial version retrieval - should get latest release version (2.1.1)
    checkResponseResource(csm, "2.1", "4");
    checkResponseResource(csm, null, "4");
  }

  @Test
  public void testMixedDepthVersioning_Complex() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
      makeCodeSystem("1", "2"), defaultPackage(),
      makeCodeSystem("2", "2.0"), defaultPackage(),
      makeCodeSystem("3", "2.0.0"), defaultPackage(),
      makeCodeSystem("4", "2.0.0-rc.1"), defaultPackage());

    // 2.0.0 > 2.0.0-rc.1 > 2.0 > 2 (most specific release wins)
    checkResponseResource(csm, "2", "1");
    checkResponseResource(csm, "2.0", "3"); // because semver kicks in
    checkResponseResource(csm, "2.0.0", "3");
    checkResponseResource(csm, null, "3");
  }

  // =============================================
  // EDGE CASES
  // =============================================

  @Test
  public void testAlphanumericVersions() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
      makeCodeSystem("1", "1.0-alpha"), defaultPackage(),
      makeCodeSystem("2", "1.0-beta"), defaultPackage());

    checkResponseResource(csm, null, "2"); // beta > alpha in natural order
  }

  @Test
  public void testSameDateDifferentTime() throws ParseException {
    CanonicalResourceManager<CodeSystem> csm = new CanonicalResourceManager<>(false, false);
    registerResources(csm,
        makeCodeSystem("1", "2.0.1"), defaultPackage(),
        makeCodeSystem("2", "2.0.1"), defaultPackage());

    checkResponseResource(csm, "2.0.1", "2");  // Most recent addition wins when dates are equal
  }

  /*
      Multithread Test
     */
  @Test
  // This timeout value was evaluated based on an observed time of 1400 ms for a single run, with a tolerance of 20%.
  @Timeout(value = 1680, unit = TimeUnit.MILLISECONDS)
  public void testCachedCanonicalResourceGetWithMultiThread() {
    //Create a single resource and then try to get it with multiple threads.
    CanonicalResourceManager<ValueSet> resourceManager = new CanonicalResourceManager<>(true, false);
    ValueSet vs = new ValueSet();
    vs.setId("2345");
    vs.setUrl("https://url/ValueSet/2345");

    // no version
    DeferredLoadTestResource testResource = spy(new DeferredLoadTestResource(vs, 1000));
    resourceManager.register(testResource, null);

    final int threadTotal = 20;
    List<Thread> threads = new ArrayList<>();

    for (int i = 0; i < threadTotal; i++) {
      Thread t = new Thread(() -> {
        ValueSet actualValueSet = resourceManager.get("https://url/ValueSet/2345");
        assertThat(actualValueSet).isNotNull();
      });
      t.start();
      threads.add(t);
    }
    threads.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    //Check that loadResource, which can be an expensive operation, is only called once
    verify(testResource, times(1)).loadResource();
  }


  // worker routines
  private void registerResources(CanonicalResourceManager<CodeSystem> csm, CodeSystem cs1, PackageInformation pi1,
                                 CodeSystem cs2, PackageInformation pi2) {
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);
  }

  private void registerResources(CanonicalResourceManager<CodeSystem> csm, CodeSystem cs1, PackageInformation pi1,
                                 CodeSystem cs2, PackageInformation pi2,
                                 CodeSystem cs3, PackageInformation pi3) {
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);
    CanonicalResourceProxy cp3 = new DeferredLoadTestResource(cs3);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc3 = csm.new CachedCanonicalResource<CodeSystem>(cp3, pi3);
    csm.see(cc3);
  }

  private void registerResources(CanonicalResourceManager<CodeSystem> csm, CodeSystem cs1, PackageInformation pi1,
                                 CodeSystem cs2, PackageInformation pi2,
                                 CodeSystem cs3, PackageInformation pi3,
                                 CodeSystem cs4, PackageInformation pi4) {
    CanonicalResourceProxy cp1 = new DeferredLoadTestResource(cs1);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc1 = csm.new CachedCanonicalResource<CodeSystem>(cp1, pi1);
    csm.see(cc1);
    CanonicalResourceProxy cp2 = new DeferredLoadTestResource(cs2);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc2 = csm.new CachedCanonicalResource<CodeSystem>(cp2, pi2);
    csm.see(cc2);
    CanonicalResourceProxy cp3 = new DeferredLoadTestResource(cs3);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc3 = csm.new CachedCanonicalResource<CodeSystem>(cp3, pi3);
    csm.see(cc3);
    CanonicalResourceProxy cp4 = new DeferredLoadTestResource(cs4);
    CanonicalResourceManager<CodeSystem>.CachedCanonicalResource<CodeSystem> cc4 = csm.new CachedCanonicalResource<CodeSystem>(cp4, pi4);
    csm.see(cc4);
  }

  private void checkResponseResource(CanonicalResourceManager<CodeSystem> csm, String version, String winner) {
    CodeSystem cs = csm.get("https://test", version);
    if (winner == null) {
      Assertions.assertNull(cs);
    } else {
      Assertions.assertEquals(winner, cs.getId()); // First one has higher version
    }
  }

  private PackageInformation defaultPackage() throws ParseException {
    return makePackageInfo("hl7.fhir.core", "1.0.0", "2023-01-01");
  }

  private PackageInformation laterPackage() throws ParseException {
    return makePackageInfo("hl7.fhir.other", "1.0.0", "2023-06-15");
  }

  private PackageInformation makePackageInfo(String id, String version, String date) throws ParseException {
    return new PackageInformation(id, version, "4.0.1", dateFromStr(date));
  }

  private CodeSystem makeCodeSystem(String id, String ver) {
    CodeSystem cs = new CodeSystem();
    cs.setId(id);
    cs.setUrl("https://test");
    cs.setVersion(ver);
    return cs;
  }

}
