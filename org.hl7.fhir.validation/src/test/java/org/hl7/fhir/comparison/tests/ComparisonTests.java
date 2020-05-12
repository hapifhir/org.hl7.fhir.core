package org.hl7.fhir.comparison.tests;

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
import org.hl7.fhir.r5.comparison.CodeSystemComparer;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.ComparisonSession;
import org.hl7.fhir.r5.comparison.ValueSetComparer;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
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
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext.FunctionDetails;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.IResourceValidator.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.IResourceValidator.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.thymeleaf.util.IWritableCharSequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class ComparisonTests {

  public final static boolean PRINT_OUTPUT_TO_CONSOLE = true;

  public static Stream<Arguments> data() throws IOException {
    String contents = TestingUtilities.loadTestResource("comparison", "manifest.json");

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
  private static IWorkerContext context;
  private JsonObject content;

  private static final String DEF_TX = "http://tx.fhir.org";
  private static final String HEADER = "<html><link href=\"http://hl7.org/fhir/fhir.css\" rel=\"stylesheet\"/><body>";
  private static final String BREAK = "<hr/>";
  private static final String FOOTER = "</body></html>";

  @ParameterizedTest(name = "{index}: id {0}")
  @MethodSource("data")
  public void test(String name, JsonObject content) throws Exception {
    this.content = content;
    
    if (content.has("use-test") && !content.get("use-test").getAsBoolean())
      return;
    
    if (context == null) {
      System.out.println("---- Load R5 ----------------------------------------------------------------");
      context = TestingUtilities.context(); 
    }
  
    if (!new File(Utilities.path("[tmp]", "comparison")).exists()) {
      System.out.println("---- Set up Output ----------------------------------------------------------");
      Utilities.createDirectory(Utilities.path("[tmp]", "comparison"));
      PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
      NpmPackage npm = pcm.loadPackage("hl7.fhir.pubpack", "0.0.4");
      for (String f : npm.list("other")) {
        TextFile.streamToFile(npm.load("other", f), Utilities.path("[tmp]", "comparison", f));
      }
    }
    System.out.println("---- " + name + " ----------------------------------------------------------------");    
    CanonicalResource left = load("left");
    CanonicalResource right = load("right");
    
    ComparisonSession session = new ComparisonSession(context);
    
    if (left instanceof CodeSystem && right instanceof CodeSystem) {
      CodeSystemComparer cs = new CodeSystemComparer(session );
      CodeSystemComparison csc = cs.compare((CodeSystem) left, (CodeSystem) right);
      Assertions.assertTrue(csc.getUnion().getConcept().size() > csc.getIntersection().getConcept().size());
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", name+"-union.json")), csc.getUnion());
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", name+"-intersection.json")), csc.getIntersection());
      
      String xmle = new XhtmlComposer(true).compose(cs.renderErrors(csc));
      String xml1 = new XhtmlComposer(true).compose(cs.renderMetadata(csc, "", ""));
      String xml2 = new XhtmlComposer(true).compose(cs.renderConcepts(csc, "", ""));
      TextFile.stringToFile(HEADER+hd("Messages")+xmle+BREAK+hd("Metadata")+xml1+BREAK+hd("Concepts")+xml2+FOOTER, Utilities.path("[tmp]", "comparison", name+".html"));
      checkOutcomes(csc.getMessages(), content);
    } else if (left instanceof ValueSet && right instanceof ValueSet) {
      ValueSetComparer cs = new ValueSetComparer(session);
      ValueSetComparison csc = cs.compare((ValueSet) left, (ValueSet) right);
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", name+"-union.json")), csc.getUnion());
      new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "comparison", name+"-intersection.json")), csc.getIntersection());
      
      String xmle = new XhtmlComposer(true).compose(cs.renderErrors(csc));
      String xml1 = new XhtmlComposer(true).compose(cs.renderMetadata(csc, "", ""));
      String xml2 = new XhtmlComposer(true).compose(cs.renderCompose(csc, "", ""));
      String xml3 = new XhtmlComposer(true).compose(cs.renderExpansion(csc, "", ""));
      TextFile.stringToFile(HEADER+hd("Messages")+xmle+BREAK+hd("Metadata")+xml1+BREAK+hd("Definition")+xml2+BREAK+hd("Expansion")+xml3+FOOTER, Utilities.path("[tmp]", "comparison", name+".html"));
      checkOutcomes(csc.getMessages(), content);
    } else {
      throw new FHIRException("Can't compare "+left.fhirType()+" to "+right.fhirType());
    }
  }

  private String hd(String text) {
    return "<h2>"+text+"</h2>\r\n";   
  }

  private CanonicalResource load(String name) throws IOException {
    JsonObject details = content.getAsJsonObject(name);
    String src = TestingUtilities.loadTestResource("comparison", details.get("source").getAsString());
    return (CanonicalResource) loadResource(details.get("source").getAsString(), src, details.get("version").getAsString());
  }

  public Resource loadResource(String filename, String contents, String ver) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        if (Constants.VERSION.equals(ver) || "5.0".equals(ver))
          return new JsonParser().parse(inputStream);
        else if (VersionUtilities.isR3Ver(ver))
          return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream), false);
        else if (VersionUtilities.isR2BVer(ver))
          return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
        else if (VersionUtilities.isR2Ver(ver))
          return VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
        else if (VersionUtilities.isR4Ver(ver))
          return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + ver);
      } else {
        if (Constants.VERSION.equals(ver) || "5.0".equals(ver))
          return new XmlParser().parse(inputStream);
        else if (VersionUtilities.isR3Ver(ver))
          return VersionConvertor_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream), false);
        else if (VersionUtilities.isR2BVer(ver))
          return VersionConvertor_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
        else if (VersionUtilities.isR2Ver(ver))
          return VersionConvertor_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
        else if (VersionUtilities.isR4Ver(ver))
          return VersionConvertor_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + ver);
      }
    }
  } 

  private void checkOutcomes(List<ValidationMessage> errors, JsonObject focus) {
    JsonObject output = focus.getAsJsonObject("output");
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
    Assertions.assertEquals(output.get("errorCount").getAsInt(), ec, "Expected " + Integer.toString(output.get("errorCount").getAsInt()) + " errors, but found " + Integer.toString(ec) + ".");
    if (output.has("warningCount"))
      Assertions.assertEquals(output.get("warningCount").getAsInt(), wc, "Expected " + Integer.toString(output.get("warningCount").getAsInt()) + " warnings, but found " + Integer.toString(wc) + ".");
    if (output.has("infoCount"))
      Assertions.assertEquals(output.get("infoCount").getAsInt(), hc, "Expected " + Integer.toString(output.get("infoCount").getAsInt()) + " hints, but found " + Integer.toString(hc) + ".");
  }

}