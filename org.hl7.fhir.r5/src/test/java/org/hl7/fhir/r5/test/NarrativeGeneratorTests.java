package org.hl7.fhir.r5.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.hl7.fhir.utilities.Utilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

public class NarrativeGeneratorTests {

	private NarrativeGenerator gen;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException, FHIRException, UcumException {
		if (gen == null)
  		gen = new NarrativeGenerator("", null, TestingUtilities.context());
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test() throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
		process(TestingUtilities.loadTestResourceStream("r5", "questionnaireresponse-example-f201-lifelines.xml"));
	}

	private void process(InputStream stream) throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {
	  XmlParser p = new XmlParser();
	  DomainResource r = (DomainResource) p.parse(stream);
	  gen.generate(r, null);
	  FileOutputStream s = new FileOutputStream(TestingUtilities.tempFile("gen", "gen.xml"));
    new XmlParser().compose(s, r, true);
    s.close();
	  
  }

}
