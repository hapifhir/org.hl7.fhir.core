package org.hl7.fhir.utilities.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcceptLanguageTests {

  @Test
  public void testEasy() {
    AcceptLanguageHeader hdr = new AcceptLanguageHeader("en", true);
    Assertions.assertEquals(1, hdr.getLangs().size());
    Assertions.assertEquals(1, hdr.getLangs().get(0).getValue());
    Assertions.assertEquals(0, hdr.getLangs().get(0).getOrder());
    Assertions.assertEquals("en", hdr.getLangs().get(0).getLang());
  }
  

  @Test
  public void testComplex() {
    AcceptLanguageHeader hdr = new AcceptLanguageHeader("en; q=0.9, de;q=0.7, *", true);
    Assertions.assertEquals(3, hdr.getLangs().size());
    
    Assertions.assertEquals(1, hdr.getLangs().get(0).getValue());
    Assertions.assertEquals(2, hdr.getLangs().get(0).getOrder());
    Assertions.assertEquals("*", hdr.getLangs().get(0).getLang());
    
    Assertions.assertEquals(0.9, hdr.getLangs().get(1).getValue(), 0.001);
    Assertions.assertEquals(0, hdr.getLangs().get(1).getOrder());
    Assertions.assertEquals("en", hdr.getLangs().get(1).getLang());
    
    Assertions.assertEquals(0.7, hdr.getLangs().get(2).getValue(), 0.001);
    Assertions.assertEquals(1, hdr.getLangs().get(2).getOrder());
    Assertions.assertEquals("de", hdr.getLangs().get(2).getLang());
  }
  

  @Test
  public void testBadSyntax() {
    AcceptLanguageHeader hdr = new AcceptLanguageHeader("en; 0.9, ; q=0.7, *:0.1", true);
    Assertions.assertEquals(3, hdr.getLangs().size());
    
  }
  
  
}
