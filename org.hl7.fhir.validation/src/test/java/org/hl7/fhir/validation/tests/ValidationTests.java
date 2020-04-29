package org.hl7.fhir.validation.tests;

import com.google.common.base.Charsets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.IResourceValidator.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.IResourceValidator.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class ValidationTests implements IEvaluationContext, IValidatorResourceFetcher {

  public final static boolean PRINT_OUTPUT_TO_CONSOLE = false;

  public static Stream<Arguments> data() throws IOException {
    String contents = TestingUtilities.loadTestResource("validator", "manifest.json");

    Map<String, JsonObject> examples = new HashMap<String, JsonObject>();
    manifest = (JsonObject) new com.google.gson.JsonParser().parse(contents);
    for (Entry<String, JsonElement> e : manifest.getAsJsonObject("test-cases").entrySet()) {
      examples.put(e.getKey(), e.getValue().getAsJsonObject());
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Arguments> objects = new ArrayList<>();
    for (String id : names) {
      objects.add(Arguments.of(id, examples.get(id)));
    }
    return objects.stream();
  }

  private static JsonObject manifest;
  private JsonObject content;
  private String version;

  private static final String DEF_TX = "http://tx.fhir.org";
  private static Map<String, ValidationEngine> ve = new HashMap<>();
  private static ValidationEngine vCurr;

  @ParameterizedTest(name = "{index}: id {0}")
  @MethodSource("data")
  public void test(String name, JsonObject content) throws Exception {
    this.content = content;
    System.out.println("---- " + name + " ----------------------------------------------------------------");
    System.out.println("** Core: ");
    String txLog = null;
    if (content.has("txLog")) {
      txLog = content.get("txLog").getAsString();
    }
    version = "5.0";
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (content.has("version")) {
      version = content.get("version").getAsString();
    }

    version = VersionUtilities.getMajMin(version);
    if (!ve.containsKey(version)) {
      if (version.startsWith("5.0"))
        ve.put(version, new ValidationEngine("hl7.fhir.r5.core#current", DEF_TX, txLog, FhirPublication.R5, true, "4.2.0"));
      else if (version.startsWith("3.0"))
        ve.put(version, new ValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, txLog, FhirPublication.STU3, true, "3.0.2"));
      else if (version.startsWith("4.0"))
        ve.put(version, new ValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, txLog, FhirPublication.R4, true, "4.0.1"));
      else if (version.startsWith("1.0"))
        ve.put(version, new ValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, txLog, FhirPublication.DSTU2, true, "1.0.2"));
      else if (version.startsWith("1.4"))
        ve.put(version, new ValidationEngine("hl7.fhir.r2b.core#1.4.0", DEF_TX, txLog, FhirPublication.DSTU2016May, true, "1.4.0"));
      else
        throw new Exception("unknown version " + version);
    }
    vCurr = ve.get(version);
    vCurr.setFetcher(this);
    if (TestingUtilities.fcontexts == null) {
      TestingUtilities.fcontexts = new HashMap<>();
    }
    TestingUtilities.fcontexts.put(version, vCurr.getContext());

    if (content.has("use-test") && !content.get("use-test").getAsBoolean())
      return;

    String testCaseContent = TestingUtilities.loadTestResource("validator", name);

    InstanceValidator val = vCurr.getValidator();
    val.setDebug(false);
    if (content.has("allowed-extension-domain"))
      val.getExtensionDomains().add(content.get("allowed-extension-domain").getAsString());
    if (content.has("allowed-extension-domains"))
      for (JsonElement a : content.getAsJsonArray("allowed-extension-domains"))
        val.getExtensionDomains().add(a.getAsString());
    if (content.has("language"))
      val.setValidationLanguage(content.get("language").getAsString());
    else
      val.setValidationLanguage(null);
    val.setFetcher(this);
    if (content.has("packages")) {
      for (JsonElement e : content.getAsJsonArray("packages")) {
        vCurr.loadIg(e.getAsString(), true);
      }
    }
    if (content.has("supporting")) {
      for (JsonElement e : content.getAsJsonArray("supporting")) {
        String filename = e.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
        val.getContext().cacheResource(mr);
      }
    }
    if (content.has("profiles")) {
      for (JsonElement je : content.getAsJsonArray("profiles")) {
        String filename = je.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        StructureDefinition sd = loadProfile(filename, contents, messages);
        val.getContext().cacheResource(sd);
      }
    }
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    if (content.getAsJsonObject("java").has("debug")) {
      val.setDebug(content.getAsJsonObject("java").get("debug").getAsBoolean());
    } else {
      val.setDebug(false);
    }
    if (content.has("examples")) {
      val.setAllowExamples(content.get("examples").getAsBoolean());
    } else {
      val.setAllowExamples(true);
    }
    val.setAssumeValidRestReferences(content.has("assumeValidRestReferences") ? content.get("assumeValidRestReferences").getAsBoolean() : false);
    if (name.endsWith(".json"))
      val.validate(null, errors, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.JSON);
    else
      val.validate(null, errors, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.XML);
    System.out.println(val.reportTimes());
    checkOutcomes(errors, content);
    if (content.has("profile")) {
      System.out.print("** Profile: ");
      JsonObject profile = content.getAsJsonObject("profile");
      if (profile.getAsJsonObject("java").has("debug")) {
        val.setDebug(profile.getAsJsonObject("java").get("debug").getAsBoolean());
      }
      if (profile.has("supporting")) {
        for (JsonElement e : profile.getAsJsonArray("supporting")) {
          String filename = e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
          val.getContext().cacheResource(mr);
        }
      }
      String filename = profile.get("source").getAsString();
      String contents = TestingUtilities.loadTestResource("validator", filename);
      System.out.println("Name: " + name + " - profile : " + profile.get("source").getAsString());
      version = content.has("version") ? content.get("version").getAsString() : Constants.VERSION;
      StructureDefinition sd = loadProfile(filename, contents, messages);
      val.getContext().cacheResource(sd);
      val.setAssumeValidRestReferences(profile.has("assumeValidRestReferences") ? profile.get("assumeValidRestReferences").getAsBoolean() : false);
      List<ValidationMessage> errorsProfile = new ArrayList<ValidationMessage>();
      if (name.endsWith(".json"))
        val.validate(null, errorsProfile, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.JSON, asSdList(sd));
      else
        val.validate(null, errorsProfile, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.XML, asSdList(sd));
      System.out.println(val.reportTimes());
      checkOutcomes(errorsProfile, profile);
    }
    if (content.has("logical")) {
      JsonObject logical = content.getAsJsonObject("logical");
      if (logical.has("supporting")) {
        for (JsonElement e : logical.getAsJsonArray("supporting")) {
          String filename = e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
          if (mr instanceof StructureDefinition) {
            val.getContext().generateSnapshot((StructureDefinition) mr, true);
          }
          val.getContext().cacheResource(mr);
        }
      }
      List<ValidationMessage> errorsLogical = new ArrayList<ValidationMessage>();
      Element le = val.validate(null, errorsLogical, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), (name.endsWith(".json")) ? FhirFormat.JSON : FhirFormat.XML);
      if (logical.has("expressions")) {
        FHIRPathEngine fp = new FHIRPathEngine(val.getContext());
        for (JsonElement e : logical.getAsJsonArray("expressions")) {
          String exp = e.getAsString();
          Assertions.assertTrue(fp.evaluateToBoolean(null, le, le, le, fp.parse(exp)));
        }
      }
      checkOutcomes(errorsLogical, logical);
    }
  }

  private List<StructureDefinition> asSdList(StructureDefinition sd) {
    List<StructureDefinition> res = new ArrayList<StructureDefinition>();
    res.add(sd);
    return res;
  }

  public StructureDefinition loadProfile(String filename, String contents, List<ValidationMessage> messages) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    StructureDefinition sd = (StructureDefinition) loadResource(filename, contents);
    ProfileUtilities pu = new ProfileUtilities(TestingUtilities.context(version), messages, null);
    if (!sd.hasSnapshot()) {
      StructureDefinition base = TestingUtilities.context(version).fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      pu.generateSnapshot(base, sd, sd.getUrl(), null, sd.getTitle());
// (debugging)      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", sd.getId()+".xml")), sd);
    }
    for (Resource r : sd.getContained()) {
      if (r instanceof StructureDefinition) {
        StructureDefinition childSd = (StructureDefinition) r;
        if (!childSd.hasSnapshot()) {
          StructureDefinition base = TestingUtilities.context(version).fetchResource(StructureDefinition.class, childSd.getBaseDefinition());
          pu.generateSnapshot(base, childSd, childSd.getUrl(), null, childSd.getTitle());
        }
      }
    }
    return sd;
  }

  public Resource loadResource(String filename, String contents) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        if (Constants.VERSION.equals(version) || "5.0".equals(version))
          return new JsonParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream), false);
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      } else {
        if (Constants.VERSION.equals(version) || "5.0".equals(version))
          return new XmlParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream), false);
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      }
    }
  }

  private void checkOutcomes(List<ValidationMessage> errors, JsonObject focus) {
    JsonObject java = focus.getAsJsonObject("java");
    int ec = 0;
    int wc = 0;
    int hc = 0;
    List<String> errLocs = new ArrayList<>();
    for (ValidationMessage vm : errors) {
      if (vm.getLevel() == IssueSeverity.FATAL || vm.getLevel() == IssueSeverity.ERROR) {
        ec++;
        if (PRINT_OUTPUT_TO_CONSOLE) {
          System.out.println(vm.getDisplay());
        }
        errLocs.add(vm.getLocation());
      }
      if (vm.getLevel() == IssueSeverity.WARNING) {
        wc++;
        if (PRINT_OUTPUT_TO_CONSOLE) {
          System.out.println(vm.getDisplay());
        }
      }
      if (vm.getLevel() == IssueSeverity.INFORMATION) {
        hc++;
        if (PRINT_OUTPUT_TO_CONSOLE) {
          System.out.println(vm.getDisplay());
        }
      }
    }
    if (!TestingUtilities.context(version).isNoTerminologyServer() || !focus.has("tx-dependent")) {
      Assertions.assertEquals(java.get("errorCount").getAsInt(), ec, "Expected " + Integer.toString(java.get("errorCount").getAsInt()) + " errors, but found " + Integer.toString(ec) + ".");
      if (java.has("warningCount"))
        Assertions.assertEquals(java.get("warningCount").getAsInt(), wc, "Expected " + Integer.toString(java.get("warningCount").getAsInt()) + " warnings, but found " + Integer.toString(wc) + ".");
      if (java.has("infoCount"))
        Assertions.assertEquals(java.get("infoCount").getAsInt(), hc, "Expected " + Integer.toString(java.get("infoCount").getAsInt()) + " hints, but found " + Integer.toString(hc) + ".");
    }
    if (java.has("error-locations")) {
      JsonArray el = java.getAsJsonArray("error-locations");
      Assertions.assertEquals(errLocs.size(), el.size(), "locations count is not correct");
      for (int i = 0; i < errLocs.size(); i++) {
        Assertions.assertEquals(errLocs.get(i), el.get(i).getAsString(), "Location should be " + el.get(i).getAsString() + ", but was " + errLocs.get(i));
      }
    }
    if (focus.has("output")) {
      focus.remove("output");
    }
    JsonArray vr = new JsonArray();
    java.add("output", vr);
    for (ValidationMessage vm : errors) {
      vr.add(vm.getDisplay());
    }
  }

  private org.hl7.fhir.r4.model.Parameters makeExpProfile() {
    org.hl7.fhir.r4.model.Parameters ep = new org.hl7.fhir.r4.model.Parameters();
    ep.addParameter("profile-url", "http://hl7.org/fhir/ExpansionProfile/dc8fd4bc-091a-424a-8a3b-6198ef146891"); // change this to blow the cache
    // all defaults....
    return ep;
  }

  @Override
  public Base resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
    return null;
  }

  @Override
  public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
    return null;
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(String functionName) {
    return null;
  }

  @Override
  public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
    return null;
  }

  @Override
  public List<Base> executeFunction(Object appContext, String functionName, List<List<Base>> parameters) {
    return null;
  }

  @Override
  public Base resolveReference(Object appContext, String url, Base refContext) {
    if (url.equals("Patient/test"))
      return new Patient();
    return null;
  }

  @Override
  public Element fetch(Object appContext, String url) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    Element res = null;
    if (url.equals("Patient/test")) {
      res = new ObjectConverter(TestingUtilities.context(version)).convert(new Patient());
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase() + ".json")) {
      res = Manager.makeParser(TestingUtilities.context(version), FhirFormat.JSON).parse(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase() + ".json"));
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase() + ".xml")) {
      res = Manager.makeParser(TestingUtilities.context(version), FhirFormat.XML).parse(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase() + ".xml"));
    }
    if (res == null && url.contains("/")) {
      String tail = url.substring(url.indexOf("/") + 1);
      if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase() + ".json")) {
        res = Manager.makeParser(TestingUtilities.context(version), FhirFormat.JSON).parse(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase() + ".json"));
      } else if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase() + ".xml")) {
        res = Manager.makeParser(TestingUtilities.context(version), FhirFormat.XML).parse(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase() + ".xml"));
      }
    }
    return res;
  }

  @Override
  public ReferenceValidationPolicy validationPolicy(Object appContext, String path, String url) {
    if (content.has("validate"))
      return ReferenceValidationPolicy.valueOf(content.get("validate").getAsString());
    else
      return ReferenceValidationPolicy.IGNORE;
  }

  @Override
  public boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException {
    return !url.contains("example.org");
  }

  @Override
  public void setLocale(Locale locale) {
    //do nothing
  }

  @Override
  public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
    IResourceValidator val = TestingUtilities.context(version).newValidator();
    List<ValidationMessage> valerrors = new ArrayList<ValidationMessage>();
    if (item instanceof Resource) {
      val.validate(appContext, valerrors, (Resource) item, url);
      boolean ok = true;
      for (ValidationMessage v : valerrors)
        ok = ok && v.getLevel().isError();
      return ok;
    }
    throw new NotImplementedException("Not done yet (IGPublisherHostServices.conformsToProfile), when item is element");
  }

  @Override
  public ValueSet resolveValueSet(Object appContext, String url) {
    return vCurr.getContext().fetchResource(ValueSet.class, url);
  }

  @AfterAll
  public static void saveWhenDone() throws IOException {
    String content = new GsonBuilder().setPrettyPrinting().create().toJson(manifest);
    TextFile.stringToFile(content, Utilities.path("[tmp]", "validator-produced-manifest.json"));

  }
}
