package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceFactory;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.terminologies.ConceptMapEngine;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@RunWith(Parameterized.class)

public class FHIRMappingLanguageTests implements ITransformerServices {

	private List<Resource> outputs = new ArrayList<Resource>();

	static private SimpleWorkerContext context;
	static private JsonParser jsonParser;

	@Parameters(name = "{index}: {0}")
	public static Iterable<Object[]> data()
			throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
		Document tests = XMLUtil.parseToDom(TestingUtilities.loadTestResource("r5", "fml", "manifest.xml"));
		Element test = XMLUtil.getFirstChild(tests.getDocumentElement());
		List<Object[]> objects = new ArrayList<Object[]>();
		while (test != null && test.getNodeName().equals("test")) {
			objects.add(new Object[] { test.getAttribute("name"), test.getAttribute("source"), test.getAttribute("map"),
					test.getAttribute("output") });
			test = XMLUtil.getNextSibling(test);
		}
		return objects;
	}

	private final String name;
	private String source;
	private String output;
	private String map;

	public FHIRMappingLanguageTests(String name, String source, String map, String output) {
		this.name = name;
		this.source = source;
		this.output = output;
		this.map = map;
	}

	@BeforeClass
	static public void setUp() throws Exception {
		if (context == null) {
			PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
      context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.core", "4.0.1"));
			jsonParser = new JsonParser();
			jsonParser.setOutputStyle(OutputStyle.PRETTY);
		}
	}

	@Test
	public void test() throws Exception {

		InputStream fileSource = TestingUtilities.loadTestResourceStream("r5", "fml", source);
		InputStream fileMap = TestingUtilities.loadTestResourceStream("r5", "fml", map);
		String outputJson = TestingUtilities.loadTestResource("r5","fml", output);
		String fileOutputRes = TestingUtilities.tempFile("fml", output)+".out";

		outputs.clear();

		boolean ok = false;
		String msg = null;
		Resource resource = null;
		try {
			StructureMapUtilities scu = new StructureMapUtilities(context, this);
			org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context,
					new ByteArrayInputStream(TextFile.streamToBytes(fileSource)), FhirFormat.JSON);
			StructureMap structureMap = scu.parse(TextFile.streamToString(fileMap), name);
			String typeName = scu.getTargetType(structureMap).getType();
			resource = ResourceFactory.createResource(typeName);
			scu.transform(null, src, structureMap, resource);
			ok = true;
		} catch (Exception e) {
			ok = false;
			msg = e.getMessage();
		}
		if (ok) {
			ByteArrayOutputStream boas = new ByteArrayOutputStream();
			jsonParser.compose(boas, resource);
			String result = boas.toString();
			log(result);
			TextFile.bytesToFile(boas.toByteArray(), fileOutputRes);
			msg = TestingUtilities.checkJsonSrcIsSame(result, outputJson);
			assertTrue(msg, Utilities.noString(msg));
		} else
			assertTrue("Error, but proper output was expected (" + msg + ")", output.equals("$error"));
	}

	@Override
	public void log(String message) {
		System.out.println(message);
	}

	@Override
	public Base createType(Object appInfo, String name) throws FHIRException {
		StructureDefinition sd = context.fetchResource(StructureDefinition.class, name);
		if (sd != null && sd.getKind() == StructureDefinitionKind.LOGICAL) {
			return Manager.build(context, sd);
		} else {
			if (name.startsWith("http://hl7.org/fhir/StructureDefinition/"))
				name = name.substring("http://hl7.org/fhir/StructureDefinition/".length());
			return ResourceFactory.createResourceOrType(name);
		}
	}

	@Override
	public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
		if (atRootofTransform)
			outputs.add((Resource) res);
		return res;
	}

	@Override
	public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
		ConceptMapEngine cme = new ConceptMapEngine(context);
		return cme.translate(source, conceptMapUrl);
	}

	@Override
	public Base resolveReference(Object appContext, String url) throws FHIRException {
		throw new FHIRException("resolveReference is not supported yet");
	}

	@Override
	public List<Base> performSearch(Object appContext, String url) throws FHIRException {
		throw new FHIRException("performSearch is not supported yet");
	}

}
