package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.r5.conformance.CapabilityStatementUtilities;
import org.hl7.fhir.r5.conformance.ProfileComparer;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.KeyGenerator;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.utils.Params;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ComparisonService {

  public static void doLeftRightComparison(String[] args, String dest, ValidationEngine validator) throws IOException {
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
    String nameLeft = chooseName(args, "leftName", resLeft);
    String nameRight = chooseName(args, "rightName", resRight);
    System.out.println("Comparing CapabilityStatements " + left + " to " + right);
    CapabilityStatementUtilities pc = new CapabilityStatementUtilities(validator.getContext(), dest, new KeyGenerator("http://fhir.org/temp/" + UUID.randomUUID().toString().toLowerCase()));
    CapabilityStatement capL = (CapabilityStatement) resLeft;
    CapabilityStatement capR = (CapabilityStatement) resRight;
    CapabilityStatementUtilities.CapabilityStatementComparisonOutput output = pc.isCompatible(nameLeft, nameRight, capL, capR);

    String destTxt = Utilities.path(dest, "output.txt");
    System.out.println("Generating output to " + destTxt + "...");
    StringBuilder b = new StringBuilder();
    for (ValidationMessage msg : output.getMessages()) {
      b.append(msg.summary());
      b.append("\r\n");
    }
    TextFile.stringToFile(b.toString(), destTxt);
    new XmlParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "CapabilityStatement-union.xml")), output.getSuperset());
    new XmlParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "CapabilityStatement-intersection.xml")), output.getSubset());
    new XmlParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "OperationOutcome-issues.xml")), output.getOutcome());
    new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "CapabilityStatement-union.json")), output.getSuperset());
    new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "CapabilityStatement-intersection.json")), output.getSubset());
    new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "OperationOutcome-issues.json")), output.getOutcome());

    String destHtml = Utilities.path(dest, "public/index.html");
    File htmlFile = new File(destHtml);
    Desktop.getDesktop().browse(htmlFile.toURI());
    System.out.println("Done");
  }

  public static void compareStructureDefinitions(String dest, ValidationEngine validator, String left, String right, StructureDefinition resLeft, StructureDefinition resRight) throws IOException {
    System.out.println("Comparing StructureDefinitions " + left + " to " + right);
    ProfileComparer pc = new ProfileComparer(validator.getContext(), dest);
    StructureDefinition sdL = resLeft;
    StructureDefinition sdR = resRight;
    pc.compareProfiles(sdL, sdR);
    System.out.println("Generating output to " + dest + "...");
    File htmlFile = new File(pc.generate());
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