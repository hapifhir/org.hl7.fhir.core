package org.hl7.fhir.r5.test;

import java.io.IOException;
import org.apache.commons.lang3.SystemUtils;

import org.hl7.fhir.utilities.Utilities;
import org.junit.Test;

import junit.framework.Assert;

public class UtilitiesTests {

  @Test
  public void testPath() throws IOException {
    Assert.assertEquals(Utilities.path("[tmp]", "test.txt"),  SystemUtils.IS_OS_WINDOWS ? "c:\\temp\\test.txt" : "/tmp/test.txt");
    Assert.assertEquals(Utilities.path("[user]", "test.txt"), System.getProperty("user.home")+"\\test.txt");
    Assert.assertEquals(Utilities.path("[JAVA_HOME]", "test.txt"), System.getenv("JAVA_HOME")+"\\test.txt");
  }
}
