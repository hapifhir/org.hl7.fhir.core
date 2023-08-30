package org.hl7.fhir.validation.tests;

import org.hl7.fhir.utilities.npm.CommonPackages;
import org.junit.jupiter.api.Test;

public class ProfileComparisonTests {

  @Test
  public void testCurrentComparison() throws Exception {
//    if (!TestUtilities.silent) 
//      System.out.println("Compare US Patient Core with AU Patient Base");
//    ValidationEngine ve = new ValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, null, FhirPublication.STU3, "3.0.2");
//    ve.loadIg("hl7.fhir.us.core#1.0.1", false);
//    ve.loadIg("hl7.fhir.au.base#current", false);
//    ve.getContext().loadFromPackage(new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION).loadPackage(CommonPackages.ID_PUBPACK, CommonPackages.VER_PUBPACK), new R5ToR5Loader(new String[] {"Binary"}), "Binary");
//
//
//    String left = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient";
//    String right = "http://hl7.org.au/fhir/StructureDefinition/au-patient";
//    String dest = TestingUtilities.tempFolder("comparison-output");
//
//    // ok now set up the comparison
//    StructureDefinition sdL = ve.getContext().fetchResource(StructureDefinition.class, left);
//    ProfileComparer pc = new ProfileComparer(ve.getContext(), new KeyGenerator("http://fhir.org/temp/"+UUID.randomUUID().toString().toLowerCase()), dest);
//    if (sdL == null) {
//      System.out.println("Unable to locate left profile " +left);
//    } else {
//      StructureDefinition sdR = ve.getContext().fetchResource(StructureDefinition.class, right);
//      if (sdR == null) {
//        System.out.println("Unable to locate right profile " +right);
//      } else {
//        System.out.println("Comparing "+left+" to "+right);
//        pc.compareProfiles(sdL, sdR);
//        System.out.println("Generating output...");
//        File htmlFile = null;
//        try {
//          htmlFile = new File(pc.generate());
//        } catch (Exception e) {
//          e.printStackTrace();
//          throw e;
//        }
//        System.out.println("Done");
//      }
//    }
  }

//    int e = errors(op);
//    int w = warnings(op);
//    int h = hints(op);
//    if (!TestUtilities.silent) {
//      System.out.println("  .. done: "+Integer.toString(e)+" errors, "+Integer.toString(w)+" warnings, "+Integer.toString(h)+" information messages");
//      for (OperationOutcomeIssueComponent iss : op.getIssue()) {
//        System.out.println("    "+iss.getDetails().getText());
//      }
//    }
//    Assert.assertTrue(e == 0);
//    Assert.assertTrue(w == 0);
//    Assert.assertTrue(h == 0);
//  }
}