package org.hl7.fhir.validation.tests;

import java.text.NumberFormat;

import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.Test;


public class LoadIgTests {
  
  @Test
  public void testPackage() {
    String id = "hl7.fhir.r4.core";
    String version = "4.0.1";
    int DO_TIMES = 3;
    
    try {
      final String fhirSpecVersion = "4.0";
      final String definitions = VersionUtilities.packageForVersion(fhirSpecVersion) + "#" + VersionUtilities.getCurrentVersion(fhirSpecVersion);

      ValidationEngine hl7Validator = new ValidationEngine.ValidationEngineBuilder().fromSource(definitions);
      hl7Validator.setDoNative(false);
      hl7Validator.setAnyExtensionsAllowed(true);
      hl7Validator.prepare();
      IgLoader igLoader = new IgLoader(hl7Validator.getPcm(), hl7Validator.getContext(), hl7Validator.getVersion(), true);

      for (int i = 0; i < DO_TIMES; i++) {
        System.gc();
        System.out.print("loading: allocated memory " + getUsedMemoryAsMbs() + " MB, ");
        System.out.print("free memory " + getFreeMemoryAsMbs() + " MB, ");
        System.out.println("max memory " + getTotalMemoryAsMbs() + " MB");

        // The method under test:
        igLoader.loadIg(hl7Validator.getIgs(), hl7Validator.getBinaries(),id + (version != null ? "#" + version : ""), true);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    // loadResourceByVersion
  }
  
  @Test
  public void testLoad() {
    String id = "hl7.fhir.r4.core";
    String version = "4.0.1";
    int DO_TIMES = 10;
    
    try {
      final String fhirSpecVersion = "4.0";
      final String definitions = VersionUtilities.packageForVersion(fhirSpecVersion) + "#" + VersionUtilities.getCurrentVersion(fhirSpecVersion);

      ValidationEngine hl7Validator = new ValidationEngine.ValidationEngineBuilder().fromSource(definitions);
      hl7Validator.setDoNative(false);
      hl7Validator.setAnyExtensionsAllowed(true);
      hl7Validator.prepare();
      IgLoader igLoader = new IgLoader(hl7Validator.getPcm(), hl7Validator.getContext(), hl7Validator.getVersion(), true);

      byte[] b = TextFile.streamToBytes(TestingUtilities.loadTestResourceStream("r4b", "snapshot-generation", "t34-expected.xml")); // yes the choice of R5 is deliberate here - it's the same content as R4.
      for (int i = 0; i < DO_TIMES; i++) {
        System.gc();
        
        for (int j = 0; j < 100; j++) {
          igLoader.loadResourceByVersion("4.0.1", b, "resource.xml");
        }
        System.out.print("loading: allocated memory " + getUsedMemoryAsMbs() + " MB, ");
        System.out.print("free memory " + getFreeMemoryAsMbs() + " MB, ");
        System.out.println("max memory " + getTotalMemoryAsMbs() + " MB");

        // The method under test:
        igLoader.loadIg(hl7Validator.getIgs(), hl7Validator.getBinaries(), id + (version != null ? "#" + version : ""), true);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    // loadResourceByVersion
  }
  public static String getFreeMemoryAsMbs() {
    long MemoryFreeSize = Runtime.getRuntime().freeMemory();
    double MemoryFreeSizeInMb = (MemoryFreeSize / 1024.0 / 1024.0);
    return NumberFormat.getIntegerInstance().format(MemoryFreeSizeInMb);
  }

  public static String getUsedMemoryAsMbs() {
    long MemoryUsedSize = Runtime.getRuntime().totalMemory();
    double MemoryUsedSizeInMb = (MemoryUsedSize / 1024.0 / 1024.0);
    return NumberFormat.getIntegerInstance().format(MemoryUsedSizeInMb);
  }
  
  public static String getTotalMemoryAsMbs() {
    long MemoryTotalSize = Runtime.getRuntime().maxMemory();
    double MemoryTotalSizeInMb = (MemoryTotalSize / 1024.0 / 1024.0);
    return NumberFormat.getIntegerInstance().format(MemoryTotalSizeInMb);
  }
}
