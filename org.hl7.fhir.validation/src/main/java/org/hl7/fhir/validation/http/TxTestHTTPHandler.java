package org.hl7.fhir.validation.http;

import com.google.common.base.Charsets;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.special.TxTestData;
import org.hl7.fhir.validation.special.TxTester;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Handler for validating resources
 */
class TxTestHTTPHandler extends BaseHTTPHandler implements HttpHandler {

  public class ServerTxTesterLoader implements TxTester.ITxTesterLoader {
    private TxTestData txtests;
    private String version;

    public ServerTxTesterLoader(TxTestData txtests, String version) {
      this.txtests = txtests;
      this.version = version;
    }

    @Override
    public String describe() {
      return "Test cases";
    }

    @Override
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException {
      return txtests.loadBytes(filename);
    }

    @Override
    public boolean hasContent(String filename) throws IOException {
      return txtests.hasFile(filename);
    }

    @Override
    public String code() {
      return "external";
    }

    @Override
    public String version() throws JsonException, IOException {
      return txtests.loadVersion();
    }

    @Override
    public String testFileName() {
      return txtests.testFileName();
    }


    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
      String contents = txtests.load(filename);
      try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
        if (filename.contains(".json")) {
          if (Constants.VERSION.equals(version) || "5.0".equals(version))
            return new JsonParser().parse(inputStream);
          else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
            return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream));
          else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
            return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
          else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
            return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
          else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
            return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
          else
            throw new FHIRException("unknown version " + version);
        } else {
          if (Constants.VERSION.equals(version) || "5.0".equals(version))
            return new XmlParser().parse(inputStream);
          else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
            return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream));
          else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
            return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
          else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
            return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
          else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
            return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
          else
            throw new FHIRException("unknown version " + version);
        }
      }
    }
  }

  public class ServerTxTester extends TxTester {
    private final ServerTxTesterLoader loader;
    private org.hl7.fhir.utilities.json.model.JsonObject testCases;

    public ServerTxTester(ServerTxTesterLoader loader, String server, boolean tight, JsonObject testCases, JsonObject externals) {
      super(loader, server, tight, externals);
      this.testCases = testCases;
      this.loader = loader;
    }

    public JsonObject getSuite(String suiteName) throws Exception {
      for (var t : testCases.getJsonObjects("suites")) {
        if (suiteName.equals(t.asString("name"))) {
          return t;
        }
      }
      throw new Exception("Test Suite "+suiteName+" not found");
    }

    public JsonObject getTest(JsonObject suite, String testName) throws Exception {
      for (var t : suite.getJsonObjects("tests")) {
        if (testName.equals(t.asString("name"))) {
          return t;
        }
      }
      throw new Exception("Test Suite "+testName+" not found in suite "+suite.asString("name"));
    }
  }

  private final FhirValidatorHttpService fhirValidatorHttpService;

  public TxTestHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"GET".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    String suiteName = null;
    String testName = null;
    String server = null;
    String externalFile = null;
    String version = null;
    Set<String> modes = new HashSet<>();

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getQuery());
      suiteName = params.get("suite");
      testName = params.get("test");
      server = params.get("server");
      version = params.get("version");
      externalFile = params.get("externals");
      if (params.containsKey("modes")) {
        modes.addAll(parseListParameter(params.get("modes")));
      } else {
        modes.add("tx.fhir.org");
        modes.add("omop");
        modes.add("general");
        modes.add("snomed");
      }

      if (suiteName == null) {
        throw new FHIRException("Missing required parameter 'suite'");
      }
      if (testName == null) {
        throw new FHIRException("Missing required parameter 'test'");
      }
      if (server == null) {
        throw new FHIRException("Missing required parameter 'server'");
      }
      if (version == null) {
        version = "5.0";
      }
      if (externalFile == null) {
        externalFile = "messages-tx.fhir.org.json";
      }
      if (!externalFile.endsWith(".json")) {
        externalFile = externalFile + ".json";
      }

      ServerTxTester tester = fhirValidatorHttpService.getTxTesters().get(server);
      if (tester == null) {
        TxTestData txtests = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#dev");
        org.hl7.fhir.utilities.json.model.JsonObject testCases = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(txtests.load("test-cases.json"));
        org.hl7.fhir.utilities.json.model.JsonObject externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(txtests.load(externalFile));
        tester = new ServerTxTester(new ServerTxTesterLoader(txtests, version), server, true, testCases, externals);
        fhirValidatorHttpService.getTxTesters().put(server, tester);
      }

      org.hl7.fhir.utilities.json.model.JsonObject suite = tester.getSuite(suiteName);
      org.hl7.fhir.utilities.json.model.JsonObject test = tester.getTest(suite, testName);
      OperationOutcome outcome;
      if (suite.asBoolean("disabled") || test.asBoolean("disabled")) {
        outcome = OperationOutcomeUtilities.createSuccess("Test is disabled");
      } else {
        // run the test
        String err = tester.executeTest(tester.loader, suite, test, modes);
        if (err != null) {
          outcome = OperationOutcomeUtilities.outcomeFromTextError(err);
        } else {
          outcome = OperationOutcomeUtilities.createSuccess("Test passed");
        }
      }
      sendOperationOutcome(exchange, 200, outcome, getAcceptHeader(exchange));
    } catch (Exception e) {
      OperationOutcome outcome = createErrorOperationOutcome("Testing failed: " + e.getMessage());
      sendOperationOutcome(exchange, 500, outcome, getAcceptHeader(exchange));
    }
  }
}
