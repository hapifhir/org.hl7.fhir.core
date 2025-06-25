package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.*;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientR5.TerminologyClientR5Factory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpander;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.terminologies.validation.ValueSetValidator;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimpleWorkerContextTests {

  private static final String DUMMY_URL = "dummyUrl";
  @Spy
  SimpleWorkerContext context;

  @Mock
  TerminologyCache terminologyCache;

  @Mock
  ToolingClientLogger txLog;

  @Mock
  ITerminologyClient terminologyClient;

  public static final TerminologyCapabilities terminologyCapabilities = new TerminologyCapabilities();
  static {  terminologyCapabilities.getExpansion().setParameter(Arrays.asList());}

  public static final CapabilityStatement.CapabilityStatementSoftwareComponent software = new CapabilityStatement.CapabilityStatementSoftwareComponent();
  static { software.setVersion("dummyVersion"); }

  public static final CapabilityStatement capabilitiesStatement = new CapabilityStatement();
  static { capabilitiesStatement.setSoftware(software);}

  @BeforeEach
  public void beforeEach() {
    Mockito.doReturn(DUMMY_URL).when(terminologyClient).getAddress();
    context.initTxCache(terminologyCache);
    context.terminologyClientManager.setMasterClient(terminologyClient, false);
  }

  @Test
  public void testInitializationWithCache() {
   String address = "dummyUrl";

   Mockito.doReturn(true).when(terminologyCache).hasTerminologyCapabilities(address);

    Mockito.doReturn(terminologyCapabilities).when(terminologyCache).getTerminologyCapabilities(address);

    context.connectToTSServer(new TerminologyClientR5Factory(), terminologyClient, false);

    Mockito.verify(terminologyCache).getTerminologyCapabilities(address);
    Mockito.verify(terminologyClient).getCapabilitiesStatement();

    Mockito.verify(terminologyCache, times(0)).getCapabilityStatement(address);
    Mockito.verify(terminologyClient, times(0)).getTerminologyCapabilities();
  }

  @Test
  public void testInitializationWithClient() {
    String address = "dummyUrl";

    Mockito.doReturn(false).when(terminologyCache).hasTerminologyCapabilities(address);

    Mockito.doReturn(terminologyCapabilities).when(terminologyClient).getTerminologyCapabilities();
//    Mockito.doReturn(capabilitiesStatement).when(terminologyClient).getCapabilitiesStatementQuick();
    Mockito.doReturn(capabilitiesStatement).when(terminologyClient).getCapabilitiesStatement();

    TerminologyClientContext.setAllowNonConformantServers(true);
    
    context.connectToTSServer(new TerminologyClientR5Factory(), terminologyClient, false);

    Mockito.verify(terminologyCache, times(0)).getTerminologyCapabilities(address);
    Mockito.verify(terminologyCache, times(0)).getCapabilityStatement(address);

    Mockito.verify(terminologyClient).getTerminologyCapabilities();
    Mockito.verify(terminologyClient).getCapabilitiesStatement();

  }

  public static Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of("zip-slip/zip-slip.zip", "Entry with an illegal path: ../evil.txt"),
      Arguments.of("zip-slip/zip-slip-2.zip", "Entry with an illegal path: child/../../evil.txt"),
      Arguments.of("zip-slip/zip-slip-peer.zip", "Entry with an illegal path: ../childpeer/evil.txt"),
      Arguments.of("zip-slip/zip-slip-win.zip", "Entry with an illegal path: ../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  public void testLoadFromClasspathZipSlip(String classPath, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {new SimpleWorkerContext.SimpleWorkerContextBuilder().fromClassPath(classPath);});
    assertNotNull(thrown);
    assertEquals(expectedMessage, thrown.getMessage());
  }

  @Test
  public void testLoadFromClasspathBinaries() throws IOException {
   SimpleWorkerContext simpleWorkerContext = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromClassPath("zip-slip/zip-normal.zip");

    final String testPath = "zip-normal/depth1/test.txt";
    assertTrue(simpleWorkerContext.getBinaryKeysAsSet().contains(testPath));
    String testFileContent = new String(simpleWorkerContext.getBinaryForKey(testPath), StandardCharsets.UTF_8);
    assertEquals("dummy file content", testFileContent);
  }
}