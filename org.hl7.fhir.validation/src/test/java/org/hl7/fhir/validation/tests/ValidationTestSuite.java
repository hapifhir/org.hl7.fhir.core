package org.hl7.fhir.validation.tests;

import com.google.common.base.Charsets;
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
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.IResourceValidator.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.IResourceValidator.ReferenceValidationPolicy;
import org.hl7.fhir.r5.validation.InstanceValidator;
import org.hl7.fhir.r5.validation.ValidationEngine;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
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
    JsonObject json =  (JsonObject) new com.google.gson.JsonParser().parse(contents);
    json = json.getAsJsonObject("validator-tests");
    for (Entry<String, JsonElement> e : json.getAsJsonObject("Json").entrySet()) {
      examples.put("Json."+e.getKey(), e.getValue().getAsJsonObject());
    }
    for (Entry<String, JsonElement> e : json.getAsJsonObject("Xml").entrySet()) {
      examples.put("Xml."+e.getKey(), e.getValue().getAsJsonObject());
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

  private String name;
  private JsonObject content;
  private static String veVersion;
  
  public ValidationTestSuite(String name, JsonObject content) {
    this.name = name;
    this.content = content;
  }

  private static final String DEF_TX = "http://tx.fhir.org";
//  private static final String DEF_TX = "http://local.fhir.org:960";
  private static ValidationEngine ve;
  
  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    System.out.println("Name: " + name+" - base");
    String v = "5.0";
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (content.has("version")) 
      v = content.get("version").getAsString();
      
    if (ve == null || !v.equals(veVersion)) {
      if (v.startsWith("5.0"))
        ve = new ValidationEngine("hl7.fhir.r5.core#current", DEF_TX, null, FhirPublication.R5, true);
      else if (v.startsWith("3.0"))
        ve = new ValidationEngine("hl7.fhir.r3.core#3.0.2", DEF_TX, null, FhirPublication.STU3, true);
      else if (v.startsWith("4.0"))
        ve = new ValidationEngine("hl7.fhir.r4.core#4.0.1", DEF_TX, null, FhirPublication.R4, true);
      else if (v.startsWith("1.0"))
        ve = new ValidationEngine("hl7.fhir.r2.core#1.0.2", DEF_TX, null, FhirPublication.DSTU2, true);
      else
        throw new Exception("unknown version "+v);
      TestingUtilities.fcontext = ve.getContext();
      veVersion = v;
    }

    if (content.has("use-test") && !content.get("use-test").getAsBoolean())
      return;

    String testCaseContent = TestingUtilities.loadTestResource("validator", name.substring(name.indexOf(".")+1));

    InstanceValidator val = ve.getValidator();
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
      ve.getContext().cacheResource(loadResource(filename, contents, v));
    }
    if (content.has("codesystems")) {
      for (JsonElement je : content.getAsJsonArray("codesystems")) {
        String filename = je.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        CodeSystem sd = (CodeSystem) loadResource(filename, contents, v);
        val.getContext().cacheResource(sd);
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
    if (name.startsWith("Json."))
      val.validate(null, errors, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.JSON);
    else
      val.validate(null, errors, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.XML);
    checkOutcomes(errors, content);
    if (content.has("profile")) {
      List<ValidationMessage> errorsProfile = new ArrayList<ValidationMessage>();
      JsonObject profile = content.getAsJsonObject("profile");
      String filename =  profile.get("source").getAsString();
      String contents = TestingUtilities.loadTestResource("validator", filename);
      System.out.println("Name: " + name+" - profile : "+profile.get("source").getAsString());
      v = content.has("version") ? content.get("version").getAsString() : Constants.VERSION;
      StructureDefinition sd = loadProfile(filename, contents, v, messages);
      if (name.startsWith("Json."))
        val.validate(null, errorsProfile, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.JSON, sd);
      else
         val.validate(null, errorsProfile, IOUtils.toInputStream(testCaseContent, Charsets.UTF_8), FhirFormat.XML, sd);
      checkOutcomes(errorsProfile, profile);
    } 
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
    int ec = 0;
    int wc = 0;
    for (ValidationMessage vm : errors) {
      if (vm.getLevel() == IssueSeverity.FATAL || vm.getLevel() == IssueSeverity.ERROR) {
        ec++;
        System.out.println(vm.getDisplay());
      }
      if (vm.getLevel() == IssueSeverity.WARNING) { 
        wc++;
        System.out.println("warning: "+vm.getDisplay());
      }
    }
    if (TestingUtilities.context().isNoTerminologyServer() || !focus.has("tx-dependent")) {
      Assert.assertEquals("Expected "+Integer.toString(focus.get("errorCount").getAsInt())+" errors, but found "+Integer.toString(ec)+".", focus.get("errorCount").getAsInt(), ec);
      if (focus.has("warningCount"))
        Assert.assertEquals("Expected "+Integer.toString(focus.get("warningCount").getAsInt())+" warnings, but found "+Integer.toString(wc)+".", focus.get("warningCount").getAsInt(), wc);
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
    if (url.equals("Patient/test"))
      return new ObjectConverter(TestingUtilities.context()).convert(new Patient());
    if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase()+".json")) {
      return Manager.makeParser(TestingUtilities.context(), FhirFormat.JSON).parse(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase()+".json"));
    }
    if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase()+".xml")) {
      return Manager.makeParser(TestingUtilities.context(), FhirFormat.JSON).parse(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase()+".xml"));
    }
    return null;
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
    return ve.getContext().fetchResource(ValueSet.class, url);
  }

}
