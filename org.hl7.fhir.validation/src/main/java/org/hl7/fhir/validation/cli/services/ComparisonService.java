package org.hl7.fhir.validation.cli.services;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.comparison.ComparisonRenderer;
import org.hl7.fhir.r5.comparison.ComparisonSession;
import org.hl7.fhir.r5.comparison.ProfileComparer;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.utils.Params;

public class ComparisonService {

  public static void doLeftRightComparison(String[] args, String dest, ValidationEngine validator) throws IOException, FHIRException, EOperationOutcome {
    // ok now set up the comparison
    String left = Params.getParam(args, Params.LEFT);
    String right = Params.getParam(args, Params.RIGHT);

    Resource resLeft = validator.getContext().fetchResource(Resource.class, left);
    Resource resRight = validator.getContext().fetchResource(Resource.class, right);
    if (resLeft == null) {
      System.out.println("Unable to locate left resource " + left);
    }
    if (resRight == null) {
      System.out.println("Unable to locate right resource " + right);
    }

    if (resLeft != null && resRight != null) {
      if (resLeft instanceof StructureDefinition && resRight instanceof StructureDefinition) {
        ComparisonService.compareStructureDefinitions(dest, validator, left, right, (StructureDefinition) resLeft, (StructureDefinition) resRight);
      } else if (resLeft instanceof CapabilityStatement && resRight instanceof CapabilityStatement) {
        ComparisonService.compareCapabilityStatements(args, dest, validator, left, right, (CanonicalResource) resLeft, (CanonicalResource) resRight);
      } else
        System.out.println("Unable to compare left resource " + left + " (" + resLeft.fhirType() + ") with right resource " + right + " (" + resRight.fhirType() + ")");
    }
  }

  public static void compareCapabilityStatements(String[] args, String dest, ValidationEngine validator, String left, String right, CanonicalResource resLeft, CanonicalResource resRight) throws IOException {
    throw new Error("CapabilityStatement comparison is not implemented at this time (WIP)");
//    System.out.println("Comparing CapabilityStatements " + left + " to " + right);
//    ComparisonSession session = new ComparisonSession(validator.getContext(), validator.getContext(), "Comparing Capability Statements", null);
//    session.compare(resLeft, resRight);
//    ComparisonRenderer cr = new ComparisonRenderer(validator.getContext(), validator.getContext(), dest, session);
//    cr.getTemplates().put("CodeSystem", new String(validator.getContext().getBinaries().get("template-comparison-CodeSystem.html")));
//    cr.getTemplates().put("ValueSet", new String(validator.getContext().getBinaries().get("template-comparison-ValueSet.html")));
//    cr.getTemplates().put("Profile", new String(validator.getContext().getBinaries().get("template-comparison-Profile.html")));
//    cr.getTemplates().put("Index", new String(validator.getContext().getBinaries().get("template-comparison-index.html")));
//    File htmlFile = cr.render(left, right);
//    Desktop.getDesktop().browse(htmlFile.toURI());
//    System.out.println("Done");
  }

  public static void compareStructureDefinitions(String dest, ValidationEngine validator, String left, String right, StructureDefinition resLeft, StructureDefinition resRight) throws IOException, FHIRException, EOperationOutcome {
    System.out.println("Comparing StructureDefinitions " + left + " to " + right);
    ComparisonSession session = new ComparisonSession(validator.getContext(), validator.getContext(), "Comparing Profiles", null, null);
    session.compare(resLeft, resRight);
    
    System.out.println("Generating output to " + dest + "...");
    Utilities.createDirectory(dest);
    ComparisonRenderer cr = new ComparisonRenderer(validator.getContext(), validator.getContext(), dest, session);
    cr.getTemplates().put("CodeSystem", new String(validator.getContext().getBinaries().get("template-comparison-CodeSystem.html")));
    cr.getTemplates().put("ValueSet", new String(validator.getContext().getBinaries().get("template-comparison-ValueSet.html")));
    cr.getTemplates().put("Profile", new String(validator.getContext().getBinaries().get("template-comparison-Profile.html")));
    cr.getTemplates().put("Index", new String(validator.getContext().getBinaries().get("template-comparison-index.html")));
    File htmlFile = cr.render(left, right);
    Desktop.getDesktop().browse(htmlFile.toURI());
    System.out.println("Done");
  }

  private static String chooseName(String[] args, String name, CanonicalResource mr) {
    String s = Params.getParam(args, "-" + name);
    if (Utilities.noString(s))
      s = mr.present();
    return s;
  }
}