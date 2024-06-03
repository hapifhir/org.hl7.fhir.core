package org.hl7.fhir.validation.localDir;

import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.hl7.fhir.validation.*;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.services.ValidationService;
import org.hl7.fhir.validation.cli.services.ValidatorWatchMode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TestValidationOfLocalDirectory {

  // TODO remove Medication and test for load failure


  @Test
  public void testIpsComposition() throws Exception {
    Path tempDir = Files.createTempDirectory("ips-dir-load");
    String[] files = {"Composition-composition-minimal.json", "Condition-eumfh-39-07-1.json"
      , "MedicationStatement-eumfh-39-07-1.json", "Organization-simple-org.json", "Patient-eumfh-39-07.json"
      , "Practitioner-eumfh-39-07.json", "AllergyIntolerance-eumfh-39-07-1.json", "Medication-eumfh-39-07-1.json"
    };
    String IPSDIR = "ips-dir/";
    for( String file : files ){
      ResourceLoaderTests.copyResourceToFile(
        this.getClass(),
        tempDir.resolve(file), IPSDIR+file );
    }
    CliContext cliContext = new CliContext();
    // loadRefTest/ -version 4.0 -watch-mode all -output-style compact -output validator.log
    cliContext.setIgs( List.of(tempDir.toString()));
    cliContext.setTargetVer("4.0");
    cliContext.setTxServer("http://tx.fhir.org");
    cliContext.setSv("4.0");
    cliContext.setOutputStyle("compact");
    cliContext.setSources( List.of(tempDir.toString()));
    ValidationService validationService = new ValidationService();
    TimeTracker tt = new TimeTracker();
    ValidationEngine validationEngine = validationService.initializeValidator(cliContext, "hl7.fhir.r4.core#4.0.1", tt);
    TimeTracker.Session tts = tt.start("Loading");

    if (cliContext.getProfiles().size() > 0) {
      System.out.println("  Profiles: " + cliContext.getProfiles());
    }
    IgLoader igLoader = new IgLoader(validationEngine.getPcm(), validationEngine.getContext(), validationEngine.getVersion());

    List<ValidationRecord> records = new ArrayList<>();
    List<ValidatorUtils.SourceFile> refs = new ArrayList<>();

    Resource r = validationEngine.validate(cliContext.getSources(), cliContext.getProfiles(), refs, records, igLoader, false, 0, true );

    assertNotNull( r );
    assertTrue( r instanceof Bundle);
    Bundle resBundle = (Bundle)r;

    // results for all 6 resources
    assertEquals( 8, resBundle.getEntry().size() );
    List<OperationOutcome> opOutcList = resBundle.getEntry().stream()
      .map( Bundle.BundleEntryComponent::getResource )
      .filter( res -> res instanceof OperationOutcome )
      .map( res -> (OperationOutcome)res )
      .collect(Collectors.toList());

    // retrieve composition result
    Optional<OperationOutcome> optCompOpOutc = opOutcList.stream()
      .filter(opOut -> opOut.hasExtension("http://hl7.org/fhir/StructureDefinition/operationoutcome-file"))
      .filter(opOut -> opOut.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/operationoutcome-file")
        .getValueStringType().toString().endsWith("Composition-composition-minimal.json"))
      .findFirst();
    assertTrue( optCompOpOutc.isPresent() );
    OperationOutcome compOpOutc = optCompOpOutc.get();

    // no errors should be present
    assertTrue( compOpOutc.getIssue().stream()
      .noneMatch( issue -> issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR )
    );
  }

}