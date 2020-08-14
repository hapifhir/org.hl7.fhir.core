package org.hl7.fhir.dstu2016may.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2016may.metamodel.Element;
import org.hl7.fhir.dstu2016may.metamodel.Manager;
import org.hl7.fhir.dstu2016may.metamodel.Manager.FhirFormat;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.hl7.fhir.dstu2016may.utils.SimpleWorkerContext;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
public class RoundTripTest {
	 static String root = "C:\\work\\org.hl7.fhir.2016May\\build\\publish";

	 public static Stream<Arguments> getFiles() throws IOException {
		 List<Arguments> params = new ArrayList();
		 String examples = Utilities.path(root, "examples");
		 for (File f : new File(examples).listFiles()) {
			 if (f.getName().endsWith(".xml")) {
				 params.add(Arguments.of(f));
			 }
		 }
		 return params.stream();
	 }
	 
	 private File file;

	 public RoundTripTest(File file) {
		 this.file = file;
	 }
		 
	@ParameterizedTest
  @MethodSource("getFiles")
	@SuppressWarnings("deprecation")
	public void test(File file) throws Exception {
		System.out.println(file.getName());
		Resource r = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(new FileInputStream(file));
		String fn = makeTempFilename();
		new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(fn), r);
    String msg = TestingUtilities.checkXMLIsSame(file.getAbsolutePath(), fn);
    Assertions.assertTrue(msg == null, file.getName()+": "+msg);
    String j1 = makeTempFilename();
		new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(j1), r);

		if (TestingUtilities.context == null) {
      TestingUtilities.context = SimpleWorkerContext.fromPack(Utilities.path(root, "validation-min.xml.zip"));
    }
		
		Element re = Manager.parse(TestingUtilities.context, new FileInputStream(file), FhirFormat.XML);
    fn = makeTempFilename();
    Manager.compose(TestingUtilities.context, re, new FileOutputStream(fn), FhirFormat.XML, OutputStyle.PRETTY, null);
    msg = TestingUtilities.checkXMLIsSame(file.getAbsolutePath(), fn);
    Assertions.assertTrue(msg == null, file.getName()+": "+msg);
    String j2 = makeTempFilename();
    Manager.compose(TestingUtilities.context, re, new FileOutputStream(j2), FhirFormat.JSON, OutputStyle.PRETTY, null);

    msg = TestingUtilities.checkJsonIsSame(j1, j2);
    Assertions.assertTrue(msg == null, file.getName()+": "+msg);

	  // ok, we've produced equivalent JSON by both methods.
	  // now, we're going to reverse the process
		r = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new FileInputStream(j2)); // crossover too
    fn = makeTempFilename();
		new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(fn), r);
    msg = TestingUtilities.checkJsonIsSame(j2, fn);
    Assertions.assertTrue(msg == null, file.getName()+": "+msg);
    String x1 = makeTempFilename();
		new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(x1), r);

		re = Manager.parse(TestingUtilities.context, new FileInputStream(j1), FhirFormat.JSON);
    fn = makeTempFilename();
    Manager.compose(TestingUtilities.context, re, new FileOutputStream(fn), FhirFormat.JSON, OutputStyle.PRETTY, null);
    msg = TestingUtilities.checkJsonIsSame(j1, fn);
    Assertions.assertTrue( msg == null, file.getName()+": "+msg);
    String x2 = makeTempFilename();
    Manager.compose(TestingUtilities.context, re, new FileOutputStream(x2), FhirFormat.XML, OutputStyle.PRETTY, null);

    msg = TestingUtilities.checkXMLIsSame(x1, x2);
    Assertions.assertTrue(msg == null,file.getName()+": "+msg);
    msg = TestingUtilities.checkXMLIsSame(file.getAbsolutePath(), x1);
    Assertions.assertTrue(msg == null, file.getName()+": "+msg);

	}

	int i = 0;
	private String makeTempFilename() {
		i++;
  	return "c:\\temp\\fhirtests\\"+Integer.toString(i)+".tmp";
	}

}