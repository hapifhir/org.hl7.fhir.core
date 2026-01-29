package org.hl7.fhir.validation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.ValidationEngine.ValidationEngineBuilder;
import org.hl7.fhir.validation.instance.ValidationTimeout;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;

/**
 * @author richard.ettema
 *
 */
public class TestValidationEngineR4 {

  public ValidationEngine engine = null;

  public static Logger log = Logger.getLogger("TestValidationEngineR4");

  private JsonParser jsonParser = new JsonParser();
  private org.hl7.fhir.r4.formats.JsonParser jsonParserR4 = new org.hl7.fhir.r4.formats.JsonParser();

  private org.hl7.fhir.r4.formats.RdfParser rdfParserR4 = new org.hl7.fhir.r4.formats.RdfParser();

  private XmlParser xmlParser = new XmlParser();
  private org.hl7.fhir.r4.formats.XmlParser xmlParserR4 = new org.hl7.fhir.r4.formats.XmlParser();

  public TestValidationEngineR4() {

    try {
      log.info("Initialize FHIRValidatorClient Instance");

      long start = System.currentTimeMillis();

      InstanceValidatorParameters defaultInstanceValidatorParameters = new InstanceValidatorParameters();
      // Set validation check for valid restful resource references
      defaultInstanceValidatorParameters.setAssumeValidRestReferences(true);
      // Allow example paths
      defaultInstanceValidatorParameters.setAllowExampleUrls(true);
      // Suppress best practice warnings
      defaultInstanceValidatorParameters.setBestPracticeLevel(BestPracticeWarningLevel.Hint);
      // Set validation time out
      ValidationTimeout timeout = new ValidationTimeout(2000L, "TestValidationEngineR4");
      defaultInstanceValidatorParameters.setTimeout(timeout);

      ValidationEngineBuilder builder = new ValidationEngine.ValidationEngineBuilder().withDefaultInstanceValidatorParameters(defaultInstanceValidatorParameters);
      engine = builder.fromSource("hl7.fhir.r4.core");

      IValidationPolicyAdvisor policyAdvisor = new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.IGNORE, null);
      engine.setPolicyAdvisor(policyAdvisor);

      // Load additional packages
      String fhirPackages = "hl7.fhir.us.davinci-drug-formulary#2.1.0";
      if (fhirPackages != null && !fhirPackages.isEmpty()) {
        loadPackages(fhirPackages);
      }

      engine.connectToTSServer("http://tx.fhir.org/r4", null, FhirPublication.R4, false);

      log.info("FHIR R4 v4.0.1 Validation Engine initialization completed in " + this.getElapsedTime(start));
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to initialize FHIR Validation Engine!", e);
    }

  }

  /**
   * Process FHIR validation request using available pooled FHIRValidator object.
   *
   * @param resourceName
   * @param resourceContents
   * @param profileUri
   * @return <code>OperationOutcome</code> with results of the validation
   * @throws Exception
   */
  public org.hl7.fhir.r4.model.OperationOutcome validateResource(String resourceName, byte[] resourceContents, String profileUri) throws Exception {

    log.fine("FHIRValidatorClient.validateResource() - START");

    OperationOutcome rOutcome = null;

    long start = System.currentTimeMillis();

    try {
      List<String> profiles = null;
      if (profileUri != null) {
        profiles = new ArrayList<String>();
        profiles.add(profileUri);
      }

      FhirFormat cntType = getFhirFormat(resourceContents);

      List<ValidationMessage> messages = new ArrayList<ValidationMessage>();

      rOutcome = engine.validate(resourceContents, cntType, profiles, messages);

      try {
        // Now parse the Resource contents; this is the last validation to insure the contents is a valid FHIR resource instance
        if (cntType.equals(FhirFormat.JSON)) {
          jsonParserR4.parse((byte[])resourceContents);
        }
        else if (cntType.equals(FhirFormat.XML)) {
          xmlParserR4.parse((byte[])resourceContents);
        }
        else if (cntType.equals(FhirFormat.TURTLE)) {
          rdfParserR4.parse((byte[])resourceContents);
        }
      }
      catch (Exception ie) {
        ie.printStackTrace();

        // FHIR resource parsing failed, content is not a valid FHIR resource; throw appropriate exception to catch below
        throw ie;
      }

    } catch (Exception e) {
      String outcome = getOperationOutcome(OperationOutcome.IssueSeverity.FATAL, OperationOutcome.IssueType.PROCESSING,
          "Exception validating resource " + resourceName + ". " + e.getMessage(), null, "application/xml+fhir");

      rOutcome = (OperationOutcome) xmlParser.parse(outcome);
    } catch (Throwable e) {
      String outcome = getOperationOutcome(OperationOutcome.IssueSeverity.FATAL, OperationOutcome.IssueType.PROCESSING,
          "Exception validating resource " + (String)resourceName + ". " + e.getMessage(), null, "application/xml+fhir");

      rOutcome = (OperationOutcome) xmlParser.parse(outcome);
    }

    log.fine("FHIRValidatorClient.validateResource() - END");

    log.info("FHIR Validator - validation of resource completed in " + this.getElapsedTime(start));

    org.hl7.fhir.r4.model.OperationOutcome r4Outcome = convertR5OOR4(rOutcome);

    return r4Outcome;
  }

  /**
   * Evaluate the fhirpath expression against the given resource contents and return the evaluated values.
   *
   * @param resourceContents
   * @param pathExpression
   * @return <code>List<Base></code>
   * @throws Exception
   */
  public List<org.hl7.fhir.r4.model.Base> evaluate(byte[] resourceContents, String pathExpression) throws Exception {

    log.fine("FHIRValidatorClient.evaluate([Resource]) - START");

    long start = System.currentTimeMillis();

    List<org.hl7.fhir.r4.model.Base> result = null;
    List<org.hl7.fhir.r5.model.Base> resultR5 = null;

    try {
      org.hl7.fhir.r4.model.Resource resource = null;

      FhirFormat cntType = getFhirFormat(resourceContents);

      if (cntType.equals(FhirFormat.JSON)) {

        resource = jsonParserR4.parse(resourceContents);
      }
      else if (cntType.equals(FhirFormat.TURTLE)) {

        resource = rdfParserR4.parse(resourceContents);
      }
      else if (cntType.equals(FhirFormat.XML)) {

        resource = xmlParserR4.parse(resourceContents);
      }

      org.hl7.fhir.r5.model.Resource resourceR5 = VersionConvertorFactory_40_50.convertResource(resource);
      resultR5 = engine.getValidator(null).getFHIRPathEngine().evaluate((org.hl7.fhir.r5.model.Base)resourceR5, pathExpression);
      result = this.convertR5ListBaseToR4(resultR5);
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new Exception("Exception evaluating fhirpath expression [" + pathExpression + "]. " + e.getMessage());
    }

    log.fine("FHIRValidatorClient.evaluate() - END");

    log.info("FHIR Validator - evaluation of fhirpath expression completed in " + this.getElapsedTime(start));

    return result;
  }

  /**
   * Evaluate the fhirpath expression against the given resource contents into a boolean representation of
   * the evaluated values.
   *
   * @param resourceContents
   * @param pathExpression
   * @return boolean
   * @throws Exception
   */
  public boolean evaluateToBoolean(byte[] resourceContents, String pathExpression) throws Exception {

    log.fine("FHIRValidatorClient.evaluateToBoolean([Resource]) - START");

    long start = System.currentTimeMillis();

    boolean result = false;
    List<org.hl7.fhir.r5.model.Base> resultR5 = null;

    try {
      org.hl7.fhir.r4.model.Resource resource = null;

      FhirFormat cntType = getFhirFormat(resourceContents);

      if (cntType.equals(FhirFormat.JSON)) {

        resource = jsonParserR4.parse(resourceContents);
      }
      else if (cntType.equals(FhirFormat.TURTLE)) {

        resource = rdfParserR4.parse(resourceContents);
      }
      else if (cntType.equals(FhirFormat.XML)) {

        resource = xmlParserR4.parse(resourceContents);
      }

      org.hl7.fhir.r5.model.Resource resourceR5 = VersionConvertorFactory_40_50.convertResource(resource);
      FHIRPathEngine fpe = engine.getValidator(null).getFHIRPathEngine();
      resultR5 = fpe.evaluate((org.hl7.fhir.r5.model.Base)resourceR5, pathExpression);

      result = fpe.convertToBoolean(resultR5);
    }
    catch (Exception e) {
      throw new Exception("Evaluate To Boolean exception evaluating fhirpath expression [" + pathExpression + "]. " + e.getMessage());
    }

    log.fine("FHIRValidatorClient.evaluateToBoolean() - END");

    log.info("FHIR Validator - evaluation of fhirpath expression completed in " + this.getElapsedTime(start));

    return result;
  }

  /**
   * Evaluate the fhirpath expression against the given resource contents into a String representation of
   * the evaluated values.
   *
   * @param resourceContents
   * @param pathExpression
   * @return String
   * @throws Exception
   */
  public String evaluateToString(byte[] resourceContents, String pathExpression) throws Exception {

    log.fine("FHIRValidatorClient.evaluateToString([Resource]) - START");

    long start = System.currentTimeMillis();

    String result = null;
    List<org.hl7.fhir.r5.model.Base> resultR5 = null;

    try {
      org.hl7.fhir.r4.model.Resource resource = null;

      FhirFormat cntType = getFhirFormat(resourceContents);

      if (cntType.equals(FhirFormat.JSON)) {

        resource = jsonParserR4.parse(resourceContents);
      }
      else if (cntType.equals(FhirFormat.TURTLE)) {

        resource = rdfParserR4.parse(resourceContents);
      }
      else if (cntType.equals(FhirFormat.XML)) {

        resource = xmlParserR4.parse(resourceContents);
      }

      org.hl7.fhir.r5.model.Resource resourceR5 = VersionConvertorFactory_40_50.convertResource(resource);
      FHIRPathEngine fpe = engine.getValidator(null).getFHIRPathEngine();
      resultR5 = fpe.evaluate((org.hl7.fhir.r5.model.Base)resourceR5, pathExpression);

      result = fpe.convertToString(resultR5);
    }
    catch (Exception e) {
      throw new Exception("Evaluate To String exception evaluating fhirpath expression [" + pathExpression + "]. " + e.getMessage());
    }

    log.fine("FHIRValidatorClient.evaluateToString() - END");

    log.info("FHIR Validator - evaluation of fhirpath expression completed in " + this.getElapsedTime(start));

    return result;
  }

  /*
   * Private methods
   */

  /**
   * Load FHIR packages from environment variable FHIR_PACKAGES
   * Expect a string with comma delimited list of package#version, ...
   * NOTE - NO ERROR CHECKING IS DONE TO VERIFY THE PACKAGE NAME AND VERSION
   *
   * @param fhirPackages
   */
  private void loadPackages(String fhirPackages) throws Exception {

    // Split list of packages by comma
    String[] packageList = fhirPackages.split(",");

    for (String pkg : packageList) {
      // Split pkg into package name and version by '#'
      String[] pkgSplit = pkg.split("#");
      String pkgName = pkgSplit[0];
      String pkgVersion = pkgSplit[1];
      if (pkgVersion == null || pkgVersion.isEmpty()) {
        pkgVersion = null;
      }

      try {
        log.info("Load package " + pkgName + "#" + (pkgVersion != null ? pkgVersion : "null"));
        engine.loadPackage(pkgName, pkgVersion);
      } catch (Exception e) {
        log.severe("Load package " + pkgName + "#" + (pkgVersion != null ? pkgVersion : "null") + " failed! " + e.getMessage());
      }
    }
  }

  /**
   * Build an OperationOutcome resource with a single issue.
   *
   * @param severity
   * @param type
   * @param details
   * @param location
   * @param producesType
   * @return
   */
  private String getOperationOutcome(OperationOutcome.IssueSeverity severity, OperationOutcome.IssueType type, String details, String location, String producesType) {
    String sOp = "";

    try {
      OperationOutcome op = new OperationOutcome();

      OperationOutcome.OperationOutcomeIssueComponent issue = getOperationOutcomeIssueComponent(severity, type, details, location);

      if (issue != null) {
        op.getIssue().add(issue);
      }

      // Use Java Core Library RenderingContext
      RenderingContext rc = new RenderingContext(engine.getContext(), null, null, "http://hl7.org/fhir", "", null, RenderingContext.ResourceRendererMode.END_USER, RenderingContext.GenerationRules.VALID_RESOURCE);
      RendererFactory.factory(op, rc).renderResource(ResourceWrapper.forResource(rc.getContextUtilities(), op));

      // Convert the OperationOutcome to XML or JSON string
      ByteArrayOutputStream oOp = new ByteArrayOutputStream();

      if (producesType == null || producesType.indexOf("xml") >= 0) {
        xmlParser.setOutputStyle(OutputStyle.PRETTY);
        xmlParser.compose(oOp, op, true);
        sOp = oOp.toString();
      }
      else {
        jsonParser.setOutputStyle(OutputStyle.PRETTY);
        jsonParser.compose(oOp, op);
        sOp = oOp.toString();
      }

    }
    catch (Exception e) {
      // Handle generic exceptions
      e.printStackTrace();
      // Exception not thrown to allow operation to complete
    }

    return sOp;
  }

  /**
   * Build a single OperationOutcomeIssueComponent object
   *
   * @param severity
   * @param type
   * @param details
   * @param location
   * @return
   */
  private OperationOutcome.OperationOutcomeIssueComponent getOperationOutcomeIssueComponent(OperationOutcome.IssueSeverity severity, OperationOutcome.IssueType type, String details, String location) {
    OperationOutcome.OperationOutcomeIssueComponent issue = null;

    try {
      issue = new OperationOutcome.OperationOutcomeIssueComponent();

      issue.setSeverity(severity);
      if (type != null) {
        issue.setCode(type);
      }
      if (details != null) {
        CodeableConcept outcomeDetails = new CodeableConcept();
        outcomeDetails.setText(details);
        issue.setDetails(outcomeDetails);
      }
      if (location != null) {
        issue.getLocation().add(new StringType(location));
      }

    }
    catch (Exception e) {
      // Handle generic exceptions
      e.printStackTrace();
      // Exception not thrown to allow operation to complete
    }

    return issue;
  }

  private List<org.hl7.fhir.r4.model.Base> convertR5ListBaseToR4(List<org.hl7.fhir.r5.model.Base> listBaseR5) throws Exception {
    List<org.hl7.fhir.r4.model.Base> listBaseR4 = new ArrayList<org.hl7.fhir.r4.model.Base>();

    try {
      for (org.hl7.fhir.r5.model.Base baseR5 : listBaseR5) {
        if (baseR5 instanceof org.hl7.fhir.r5.model.DataType) {
          org.hl7.fhir.r4.model.Type typeR4 = VersionConvertorFactory_40_50.convertType((org.hl7.fhir.r5.model.DataType)baseR5);
          listBaseR4.add(typeR4);
        }
        else if (baseR5 instanceof org.hl7.fhir.r5.model.Resource) {
          org.hl7.fhir.r4.model.Resource resourceR4 = VersionConvertorFactory_40_50.convertResource((org.hl7.fhir.r5.model.Resource)baseR5);
          listBaseR4.add(resourceR4);
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

    return listBaseR4;
  }

  private org.hl7.fhir.r4.model.OperationOutcome convertR5OOR4(OperationOutcome rOutcome) throws Exception {
    org.hl7.fhir.r4.model.OperationOutcome r4Outcome = null;

    try {
      r4Outcome = (org.hl7.fhir.r4.model.OperationOutcome)VersionConvertorFactory_40_50.convertResource(rOutcome);
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

    return r4Outcome;
  }

  private FhirFormat getFhirFormat(byte[] source) {
    FhirFormat cntType = FhirFormat.TEXT;

    if (source != null) {
      if (isXml(source)) {
        cntType = FhirFormat.XML;
      }
      else if (isJson(source)) {
        cntType = FhirFormat.JSON;
      }
      else if (isTurtle(source)) {
        cntType = FhirFormat.TURTLE;
      }
    }

    return cntType;
  }

  private boolean isXml(byte[] source) {
    int x = position(source, '<');
    int j = position(source, '{');
    int t = position(source, '@');
    if (x == Integer.MAX_VALUE && j == Integer.MAX_VALUE || (t < j && t < x))
      return false;
    return (x < j);
  }

  private boolean isJson(byte[] source) {
    int x = position(source, '<');
    int j = position(source, '{');
    int t = position(source, '@');
    if (x == Integer.MAX_VALUE && j == Integer.MAX_VALUE || (t < j && t < x))
      return false;
    return (j < x);
  }

  private boolean isTurtle(byte[] source) {
    int x = position(source, '<');
    int j = position(source, '{');
    int t = position(source, '@');
    if (x == Integer.MAX_VALUE && j == Integer.MAX_VALUE || (t > j) || (t > x))
      return false;
    return true;
  }

  private int position(byte[] bytes, char target) {
    byte t = (byte) target;
    for (int i = 0; i < bytes.length; i++)
      if (bytes[i] == t)
        return i;
    return Integer.MAX_VALUE;
  }

  /*
   * Execute as a Java application (jar).
   * Arguments:
   * arg0 - flag; -d (directory), -f (single file), -l (space separated list of files)
   * arg1 - directory, single file, or space separated list of files
   * arg2 - profile; only for -f flag, canonical url with optional version
   * 
   * Example arguments for validation of a single FHIR resource in a file contained in the same folder as the jar:
   * -f bundle.json http://hl7.org/fhir/StructureDefinition/Bundle
   */
  public static void main(String[] args) {

    TestValidationEngineR4 testEngine = new TestValidationEngineR4();

    try {
      long start = System.currentTimeMillis();

      byte[] resourceBytes = null;
      String profile = null;

      if (args != null && args.length >= 2) {
        log.info("Argument Flag: " + args[0]);
        log.info("Dir/File to validate: " + args[1]);

        if (args[0].equals("-d")) {
          log.info("Directory Processing...");

          File dir = new File(args[1]);

          if (dir.listFiles() != null) {

            for (File file : dir.listFiles()) {
              log.info("");
              log.info("--------------------");
              log.info("Processing file: " + file.getName());

              resourceBytes = FileUtils.readFileToByteArray(file);

              testEngine.doValidate(testEngine, resourceBytes, profile);

              log.info("--------------------");
            }
          }
        }
        else if (args[0].equals("-f")) {
          File resourceFile = new File(args[1]);

          resourceBytes = FileUtils.readFileToByteArray(resourceFile);

          if (args.length > 2) {
            log.info("Profile for validation: " + args[2]);
            profile = args[2];
          }

          long rStart = System.currentTimeMillis();

          testEngine.doValidate(testEngine, resourceBytes, profile);

          log.info("Validate processing time: " + testEngine.getElapsedTime(rStart));
        }
        else if (args[0].equals("-l")) {
          int argLast = args.length - 1;

          for (int argIndex = 1; argIndex <= argLast; argIndex++) {

            log.info("");
            log.info("--------------------");
            log.info("Filename to validate: " + args[argIndex]);

            File resourceFile = new File(args[argIndex]);

            resourceBytes = FileUtils.readFileToByteArray(resourceFile);

            testEngine.doValidate(testEngine, resourceBytes, profile);

            log.info("--------------------");
          }
        }
        else {
          log.severe("Invalid argument flag '" + args[0] + "'! Please use '-d' for directory or '-f' for resource filename or '-l' for space separated list of filenames.");
        }
      }
      else {
        System.out.println("Invalid usage! 2+ arguments expected when arg0 is '-d', '-f' or '-l'; arg1 is directory, single filename or list of space separated filenames.");
      }

      log.info("Total processing time: " + testEngine.getElapsedTime(start));
    } catch (Throwable e) {
      e.printStackTrace();
    }

  }

  public void doValidate(TestValidationEngineR4 testEngine, byte[] resourceBytes, String profile) throws Exception {

    if (resourceBytes != null) {
      FhirFormat cntType = testEngine.getFhirFormat(resourceBytes);

      List<String> profiles = new ArrayList<String>();
      if (profile != null) {
        profiles.add(profile);
      }

      List<ValidationMessage> messages = new ArrayList<ValidationMessage>();

      OperationOutcome rOutcome = testEngine.engine.validate(resourceBytes, cntType, profiles, messages);

			// Convert the OperationOutcome to XML string
      ByteArrayOutputStream oOp = new ByteArrayOutputStream();
      XmlParser xmlParser = new XmlParser();
      xmlParser.setOutputStyle(OutputStyle.PRETTY);
      xmlParser.compose(oOp, rOutcome, true);
      String sOp = oOp.toString();

      log.info(sOp);
    }
    else {
      log.severe("Resource contents to validate are empty or null!");
    }

  }

  /**
   * Returns the elapsed time as a formatted string
   *
   * @param startMillis
   * @return
   */
  private String getElapsedTime(long startMillis) {
    long different = System.currentTimeMillis() - startMillis;

    long secondsInMilli = 1000;
    long minutesInMilli = secondsInMilli * 60;
    long hoursInMilli = minutesInMilli * 60;
    long daysInMilli = hoursInMilli * 24;

    long elapsedDays = different / daysInMilli;
    different = different % daysInMilli;

    long elapsedHours = different / hoursInMilli;
    different = different % hoursInMilli;

    long elapsedMinutes = different / minutesInMilli;
    different = different % minutesInMilli;

    long elapsedSeconds = different / secondsInMilli;

    long elapsedMillis = different % secondsInMilli;

    return (elapsedDays > 0 ? elapsedDays + " day" : "") + (elapsedDays > 1 ? "s" : "") +
      (elapsedHours > 0 ? elapsedHours + " hr" : "") + (elapsedHours > 1 ? "s" : "") +
      (elapsedMinutes > 0 ? " " + elapsedMinutes + " min" : "") + (elapsedMinutes > 1 ? "s" : "") +
      (elapsedSeconds > 0 ? " " + elapsedSeconds + " sec" : "") + (elapsedSeconds > 1 ? "s" : "") +
      (elapsedMillis > 0 ? " " + elapsedMillis + " millis " : "");
  }

}
