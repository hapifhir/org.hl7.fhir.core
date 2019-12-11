package org.hl7.fhir.r5.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.MetadataResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.TestScript;
import org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes;
import org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent;
import org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent;
import org.hl7.fhir.r5.model.TestScript.TestActionComponent;
import org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent;
import org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.CodingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.uhn.fhir.rest.api.Constants;
import junit.framework.Assert;

@RunWith(Parameterized.class)
public class NarrativeGenerationTests {

  public static class TestDetails {
    private String id;

    public TestDetails(Element test) {
      super();
      id = test.getAttribute("id");
    }
    public String getId() {
      return id;
    }
  }

  private static FHIRPathEngine fp;

  @Parameters(name = "{index}: file {0}")
  public static Iterable<Object[]> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {

    Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "narrative", "manifest.xml"));
    Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
    List<Object[]> objects = new ArrayList<Object[]>();
    while (test != null && test.getNodeName().equals("test")) {
      TestDetails t = new TestDetails(test);
      objects.add(new Object[] {t.getId(), t});
      test = XMLUtil.getNextSibling(test);
    }
    return objects;

  }


  private final TestDetails test;
  private IWorkerContext context;
  private List<ValidationMessage> messages;

  public NarrativeGenerationTests(String id, TestDetails test) {
    this.test = test;
    this.context = TestingUtilities.context();
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    NarrativeGenerator gen = new NarrativeGenerator("", "http://hl7.org/fhir", context);
    IOUtils.copy(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId()+"-expected.xml"), new FileOutputStream(TestingUtilities.tempFile("narrative", test.getId()+"-expected.xml")));
    DomainResource source = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId()+"-input.xml"));
    DomainResource target = (DomainResource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", "narrative", test.getId()+"-expected.xml"));
    gen.generate(source);
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(TestingUtilities.tempFile("narrative", test.getId()+"-actual.xml")), source);
    Assert.assertTrue("Output does not match expected", source.equalsDeep(target));
  }

}
