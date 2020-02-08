package org.hl7.fhir.r5.test;

import java.io.IOException;

import org.hl7.fhir.utilities.Utilities;
import org.junit.Test;

import junit.framework.Assert;

public class UtilitiesTests {

  @Test
  public void testPath() throws IOException {
    Assert.assertEquals(Utilities.path("[tmp]", "test.txt"), "c:\\temp\\test.txt");
    Assert.assertEquals(Utilities.path("[user]", "test.txt"), System.getProperty("user.home")+"\\test.txt");
    Assert.assertEquals(Utilities.path("[JAVA_HOME]", "test.txt"), System.getenv("JAVA_HOME")+"\\test.txt");
  }
}
