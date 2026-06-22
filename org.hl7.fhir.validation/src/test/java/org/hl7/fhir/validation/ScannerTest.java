package org.hl7.fhir.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.service.model.ScanOutputItem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScannerTest implements ResourceLoaderTests {

  public static final String ZIP_NORMAL_ZIP = "zip-normal.zip";
  public static final String ZIP_SLIP_ZIP = "zip-slip.zip";
  public static final String ZIP_SLIP_2_ZIP = "zip-slip-2.zip";
  public static final String ZIP_SLIP_PEER_ZIP = "zip-slip-peer.zip";
  public static final String ZIP_SLIP_WIN_ZIP = "zip-slip-win.zip";

  Path tempDir;
  Path zipNormalPath;
  Path zipSlipPath;

  Path zipSlip2Path;
  Path zipSlipPeerPath;

  Path zipSlipWinPath;

  @BeforeAll
  void beforeAll() throws IOException {
    tempDir = Files.createTempDirectory("scanner-zip");
    ManagedFileAccess.fromPath(tempDir.resolve("child")).mkdir();
    zipNormalPath = tempDir.resolve(ZIP_NORMAL_ZIP);
    zipSlipPath = tempDir.resolve(ZIP_SLIP_ZIP);
    zipSlip2Path = tempDir.resolve(ZIP_SLIP_2_ZIP);
    zipSlipPeerPath = tempDir.resolve(ZIP_SLIP_PEER_ZIP);
    zipSlipWinPath = tempDir.resolve(ZIP_SLIP_WIN_ZIP);

    copyResourceToFile(zipNormalPath, "zip-slip", ZIP_NORMAL_ZIP);
    copyResourceToFile(zipSlipPath, "zip-slip", ZIP_SLIP_ZIP);
    copyResourceToFile(zipSlip2Path, "zip-slip", ZIP_SLIP_2_ZIP);
    copyResourceToFile(zipSlipPeerPath, "zip-slip", ZIP_SLIP_PEER_ZIP);
    copyResourceToFile(zipSlipWinPath, "zip-slip", ZIP_SLIP_WIN_ZIP);
  }
  
  @Test
  void testNormalZip() throws IOException {
    Scanner scanner = new Scanner(null,null,null,null);
    scanner.unzip(ManagedFileAccess.fromPath(zipNormalPath).getAbsolutePath(), ManagedFileAccess.fromPath(tempDir).getAbsolutePath());

    Path expectedFilePath = tempDir.resolve("zip-normal").resolve("depth1").resolve("test.txt");
    String actualContent = Files.readString(expectedFilePath);
    assertEquals("dummy file content", actualContent);
  }

  public  Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of(zipSlipPath, "Entry with an illegal path: ../evil.txt"),
      Arguments.of(zipSlip2Path, "Entry with an illegal path: child/../../evil.txt"),
      Arguments.of(zipSlipPeerPath, "Entry with an illegal path: ../childpeer/evil.txt"),
      Arguments.of(zipSlipWinPath, "Entry with an illegal path: ../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  void testUnzipZipSlip(Path path, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(null,null,null,null);
      scanner.unzip(ManagedFileAccess.fromPath(path).getAbsolutePath(), ManagedFileAccess.fromPath(tempDir).getAbsolutePath());
    });
    assertNotNull(thrown);
    assertEquals(expectedMessage, thrown.getMessage());
  }

  @Test
  void testGenScanOutputWithJsContentIg() throws Exception {
    // Obtain an R4 shared context (the IG targets FHIR 4.0.1)
    TestingUtilities.injectCorePackageLoader();
    SimpleWorkerContext context = TestingUtilities.getSharedWorkerContext("4.0.1");

    // Stage the IG and patient resource into a temp working directory
    Path workDir = Files.createTempDirectory("scanner-genoutput");
    Path igPath = workDir.resolve("ig-with-js-content.tgz");
    Path patientPath = workDir.resolve("patient.json");
    copyResourceToFile(igPath, "scanner", "ig-with-js-content.tgz");
    copyResourceToFile(patientPath, "scanner", "patient.json");

    // Build the Scanner collaborators wired to the shared context,
    // mirroring what ValidationEngine produces for ScanCommand
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    IgLoader igLoader = new IgLoader(pcm, context, context.getVersion(), false);
    igLoader.loadIg(new ArrayList<>(), new HashMap<>(),
        ManagedFileAccess.fromPath(igPath).getAbsolutePath(), false);
    InstanceValidator validator =
        new InstanceValidator(context, null, null, new ValidatorSession(), new ValidatorSettings());
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    fpe.setAllowDoubleQuotes(false);

    Scanner scanner = new Scanner(context, validator, igLoader, fpe);

    // Collect the IG URLs exactly as Scanner.validateScan(outputDirectory, sources) does,
    // so we can call genScanOutput with includeStyleResources=false (no network access)
    List<String> sources = List.of(ManagedFileAccess.fromPath(patientPath).getAbsolutePath());
    Set<String> urls = new HashSet<>();
    for (ImplementationGuide ig : context.allImplementationGuides()) {
      if (ig.getUrl().contains("/ImplementationGuide")
          && !ig.getUrl().equals("http://hl7.org/fhir/ImplementationGuide/fhir")) {
        urls.add(ig.getUrl());
      }
    }
    List<ScanOutputItem> scanResults = getFakeResults(sources, urls, context);

    Path outDir = Files.createTempDirectory("scanner-output");
    scanner.genScanOutput(scanResults, ManagedFileAccess.fromPath(outDir).getAbsolutePath(), false);

    assertTrue(Files.exists(outDir.resolve("scan.html")));
    assertTrue(Files.exists(outDir.resolve("c1.html")));

    for (String filename : List.of("scan.html", "c0.html", "c1.html")) {
      String content = Files.readString(outDir.resolve(filename));
      assertFalse(content.contains("<script>"), filename + " contains unescaped <script>");
      assertFalse(content.contains("</script>"), filename + " contains unescaped </script>");
    }
  }

  private List<ScanOutputItem> getFakeResults(List<String> sources, Set<String> urls, SimpleWorkerContext context) {
    String ref = sources.get(0);

    ImplementationGuide ig = context.allImplementationGuides().stream()
        .filter(i -> "<script>alert(\"package.json.name\")</script>".equals(i.getId()))
        .findFirst().orElse(null);

    StructureDefinition profile = context.fetchResource(StructureDefinition.class,
        "http://example.org/fhir/StructureDefinition/minimal-patient-profile");

    OperationOutcome allOkOutcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent okIssue = allOkOutcome.addIssue();
    okIssue.setSeverity(OperationOutcome.IssueSeverity.INFORMATION);
    okIssue.setCode(OperationOutcome.IssueType.INFORMATIONAL);
    okIssue.getDetails().setText("All OK");

    OperationOutcome errorOutcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent errorIssue = errorOutcome.addIssue();
    errorIssue.setSeverity(OperationOutcome.IssueSeverity.ERROR);
    errorIssue.setCode(OperationOutcome.IssueType.INVALID);
    errorIssue.getDetails().setText("dummy error");

    return List.of(
        new ScanOutputItem(ref, null, null, allOkOutcome),
        new ScanOutputItem(ref, ig, profile, errorOutcome)
    );
  }

}
