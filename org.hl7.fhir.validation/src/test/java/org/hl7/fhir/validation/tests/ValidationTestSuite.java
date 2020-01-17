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
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.IResourceValidator.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.IResourceValidator.ReferenceValidationPolicy;
import org.hl7.fhir.r5.validation.InstanceValidator;
import org.hl7.fhir.r5.validation.ValidationEngine;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

@RunWith(Parameterized.class)
public class ValidationTestSuite implements IEvaluationContext, IValidatorResourceFetcher {

  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {

    String contents = TestingUtilities.loadTestResource("validator", "manifest.json");

    Map<String, JsonObject> examples = new HashMap<String, JsonObject>();
    manifest = (JsonObject) new com.google.gson.JsonParser().parse(contents);
    for (Entry<String, JsonElement> e : manifest.getAsJsonObject("test-cases").entrySet()) {
      examples.put(e.getKey(), e.getValue().getAsJsonObject());
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Object[]> objects = new ArrayList<Object[]>(examples.size());
    for (String id : names) {
      objects.add(new Object[] { id, examples.get(id)});
    }
    return objects;
  }

  private static JsonObject manifest;
  
  private String name;
  private JsonObject content;
  
  public ValidationTestSuite(String name, JsonObject content) {
    this.name = name;
    this.content = content;
  }

  private static final String DEF_TX = "http://tx.fhir.org";
//  private static final String DEF_TX = "http://local.fhir.org:960";
  private static Map<String, ValidationEngine> ve = new HashMap<>();
  private static ValidationEngine vCurr;
  
  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    System.out.println("---- "+name+" ----------------------------------------------------------------");
    System.out.println("** Core: ");
    String txLog = null;
    if (content.has("txLog")) {
      txLog = content.get("txLog").getAsString();      
    }
    String v = "5.0";
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (content.has("version")) {
      v = content.get("version").getAsString();
    }
      
    v = VersionUtilities.getMajMin(v);
    if (!ve.containsKey(v)) {
      if (v.startsWith("5.0"))
        ve.put(v, new ValidationEngine("hl7.fhir.r5.core#current", DEF_TX, txLog, FhirPublication.R5, true));
      else if (v.startsWith("3.0"))
        ve.put(v, new ValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, txLog, FhirPublication.STU3, true));
      else if (v.startsWith("4.0"))
        ve.put(v, new ValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, txLog, FhirPublication.R4, true));
      else if (v.startsWith("1.0"))
        ve.put(v, new ValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, txLog, FhirPublication.DSTU2, true));
      else if (v.startsWith("1.4"))
        ve.put(v, new ValidationEngine("hl7.fhir.r2b.core#1.4.0", DEF_TX, txLog, FhirPublication.DSTU2016May, true));
      else
        throw new Exception("unknown version "+v);
    }
    vCurr = ve.get(v);
    vCurr.setFetcher(this);
    TestingUtilities.fcontext = vCurr.getContext();

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
    if (content.has("questionnaire")) {
      String filename = content.get("questionnaire").getAsString();
      String contents = TestingUtilities.loadTestResource("validator", filename);
      vCurr.getContext().cacheResource(loadResource(filename, contents, v));
    }
    if (content.has("codesystems")) {
      for (JsonElement je : content.getAsJsonArray("codesystems")) {
        String filename = je.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        CodeSystem sd = (CodeSystem) loadResource(filename, contents, v);
        val.getContext().cacheResource(sd);
      }
    }
    if (content.has("valuesets")) {
      for (JsonElement je : content.getAsJsonArray("valuesets")) {
        String filename = je.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        ValueSet vs = (ValueSet) loadResource(filename, contents, v);
        val.getContext().cacheResource(vs);
      }
    }
    if (content.has("profiles")) {
      for (JsonElement je : content.getAsJsonArray("profiles")) {
        String filename = je.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        StructureDefinition sd = loadProfile(filename, contents, v, messages);
        val.getContext().cacheResource(sd);
      }
    }
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    if (content.getAsJsonObject("java").has("debug")) {
      val.setDebug(content.getAsJsonObject("java").get("debug").getAsBoolean());
    } else {
      val.setDebug(false);
    }
    if (name.endsWith(".json"))
      val.validate(null, errors, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.JSON);
    else
      val.validate(null, errors, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.XML);
    System.out.println(val.reportTimes());
    checkOutcomes(errors, content);
    if (content.has("profile")) {
      System.out.print("** Profile: ");
      JsonObject profile = content.getAsJsonObject("profile");
      if (profile.has("supporting")) {
        for (JsonElement e : profile.getAsJsonArray("supporting")) {
          String filename =  e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents, v);
          val.getContext().cacheResource(mr);
        }
      }
      String filename =  profile.get("source").getAsString();
      String contents = TestingUtilities.loadTestResource("validator", filename);
      System.out.println("Name: " + name+" - profile : "+profile.get("source").getAsString());
      v = content.has("version") ? content.get("version").getAsString() : Constants.VERSION;
      StructureDefinition sd = loadProfile(filename, contents, v, messages);
      val.getContext().cacheResource(sd);      
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
          String filename =  e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents, v);
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
          Assert.assertTrue(fp.evaluateToBoolean(null, le, le, le, fp.parse(exp)));
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

  public StructureDefinition loadProfile(String filename, String contents, String v, List<ValidationMessage> messages)  throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    StructureDefinition sd = (StructureDefinition) loadResource(filename, contents, v);
    ProfileUtilities pu = new ProfileUtilities(TestingUtilities.context(), messages, null);
    if (!sd.hasSnapshot()) {
      StructureDefinition base = TestingUtilities.context().fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      pu.generateSnapshot(base, sd, sd.getUrl(), null, sd.getTitle());
// (debugging)      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", sd.getId()+".xml")), sd);
    }
    for (Resource r: sd.getContained()) {
      if (r instanceof StructureDefinition) {
        StructureDefinition childSd = (StructureDefinition)r;
        if (!childSd.hasSnapshot()) {
          StructureDefinition base = TestingUtilities.context().fetchResource(StructureDefinition.class, childSd.getBaseDefinition());
          pu.generateSnapshot(base, childSd, childSd.getUrl(), null, childSd.getTitle());          
        }
      }
    }
    return sd;
  }
  
  public Resource loadResource(String filename, String contents, String v)  throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        if (Constants.VERSION.equals(v) || "5.0".equals(v))
          return new JsonParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(v) || "3.0".equals(v))
          return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream), false);
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(v) || "1.4".equals(v))
          return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(v) || "1.0".equals(v))
          return new VersionConvertor_10_50(null).convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(v) || "4.0".equals(v))
          return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
        else
          throw new FHIRException("unknown version "+v);
      } else {
        if (Constants.VERSION.equals(v) || "5.0".equals(v))
          return new XmlParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(v) || "3.0".equals(v))
          return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream), false);
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(v) || "1.4".equals(v))
          return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(v) || "1.0".equals(v))
          return new VersionConvertor_10_50(null).convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(v) || "4.0".equals(v))
          return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + v);
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
        System.out.println(vm.getDisplay());
        errLocs.add(vm.getLocation());
      }
      if (vm.getLevel() == IssueSeverity.WARNING) { 
        wc++;
        System.out.println("warning: "+vm.getDisplay());
      }
      if (vm.getLevel() == IssueSeverity.INFORMATION) { 
        hc++;
        if (java.has("infoCount") || java.has("debug")) {
          System.out.println("hint: "+vm.getDisplay());          
        }
      }
    }
    if (TestingUtilities.context().isNoTerminologyServer() || !focus.has("tx-dependent")) {
      Assert.assertEquals("Expected "+Integer.toString(java.get("errorCount").getAsInt())+" errors, but found "+Integer.toString(ec)+".", java.get("errorCount").getAsInt(), ec);
      if (java.has("warningCount"))
        Assert.assertEquals("Expected "+Integer.toString(java.get("warningCount").getAsInt())+" warnings, but found "+Integer.toString(wc)+".", java.get("warningCount").getAsInt(), wc);
      if (java.has("infoCount"))
        Assert.assertEquals("Expected "+Integer.toString(java.get("infoCount").getAsInt())+" hints, but found "+Integer.toString(hc)+".", java.get("infoCount").getAsInt(), hc);
    }
    if (java.has("error-locations")) {
      JsonArray el = java.getAsJsonArray("error-locations");
      Assert.assertEquals("locations count is not correct", errLocs.size(), el.size());
      for (int i = 0; i < errLocs.size(); i++) {
        Assert.assertEquals("Location should be "+el.get(i).getAsString()+", but was "+errLocs.get(i), errLocs.get(i), el.get(i).getAsString());
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
    org.hl7.fhir.r4.model.Parameters ep  = new org.hl7.fhir.r4.model.Parameters();
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
  public Base resolveReference(Object appContext, String url) {
    if (url.equals("Patient/test"))
      return new Patient();
    return null;
  }

  @Override
  public Element fetch(Object appContext, String url) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    Element res = null;
    if (url.equals("Patient/test")) {
      res = new ObjectConverter(TestingUtilities.context()).convert(new Patient());
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase()+".json")) {
      res = Manager.makeParser(TestingUtilities.context(), FhirFormat.JSON).parse(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase()+".json"));
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase()+".xml")) {
      res = Manager.makeParser(TestingUtilities.context(), FhirFormat.XML).parse(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase()+".xml"));
    }
    if (res == null && url.contains("/")) {
      String tail = url.substring(url.indexOf("/")+1);
      if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase()+".json")) {
        res = Manager.makeParser(TestingUtilities.context(), FhirFormat.JSON).parse(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase()+".json"));
      } else if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase()+".xml")) {
        res =  Manager.makeParser(TestingUtilities.context(), FhirFormat.XML).parse(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase()+".xml"));
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
    return true;
  }

  @Override
  public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
    IResourceValidator val = TestingUtilities.context().newValidator();
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

  @AfterClass
  public static void saveWhenDone() throws IOException {
    String content = new GsonBuilder().setPrettyPrinting().create().toJson(manifest);
    TextFile.stringToFile(content, Utilities.path("[tmp]", "validator-produced-manifest.json"));
    
  }
}
