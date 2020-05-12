package org.hl7.fhir.dstu2.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.dstu2.formats.XmlParser;
import org.hl7.fhir.dstu2.model.DomainResource;
import org.hl7.fhir.dstu2.utils.EOperationOutcome;
import org.hl7.fhir.dstu2.utils.NarrativeGenerator;
import org.hl7.fhir.dstu2.utils.SimpleWorkerContext;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled // TODO Need to find and fix files referenced here
public class NarrativeGeneratorTests {

	private NarrativeGenerator gen;
	
	@BeforeEach
	public void setUp() throws IOException, FHIRException {
		if (gen == null)
  		gen = new NarrativeGenerator("", null, SimpleWorkerContext.fromPack("C:\\work\\org.hl7.fhir\\build\\publish\\validation.zip"));
	}

	@AfterEach
	public void tearDown() {
	}

	@Test
	public void test() throws IOException, EOperationOutcome, FHIRException {
		process("C:\\work\\org.hl7.fhir\\build\\source\\questionnaireresponse\\questionnaireresponse-example-f201-lifelines.xml");
	}

	private void process(String path) throws IOException, EOperationOutcome, FHIRException {
	  XmlParser p = new XmlParser();
	  DomainResource r = (DomainResource) p.parse(new FileInputStream(path));
	  gen.generate(r);
	  FileOutputStream s = new FileOutputStream("c:\\temp\\gen.xml");
    new XmlParser().compose(s, r, true);
    s.close();
  }

}