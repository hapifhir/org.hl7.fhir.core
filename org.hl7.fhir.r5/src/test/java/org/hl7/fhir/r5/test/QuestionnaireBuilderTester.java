package org.hl7.fhir.r5.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.QuestionnaireBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class QuestionnaireBuilderTester {

	private static final String TEST_PROFILE_DIR = "C:\\work\\org.hl7.fhir\\build\\publish";
//	private static final String TEST_DEST = Utilities.path("[tmp]", "questionnaires\\");

	public static void main(String[] args) throws IOException {
		QuestionnaireBuilder b = new QuestionnaireBuilder(null, "http://hl7.org/fhir/test");
		for (String f : ManagedFileAccess.file(TEST_PROFILE_DIR).list()) {
			if (f.endsWith(".profile.xml") && !f.contains("type-")) {
				System.out.println("process "+f);
				try {
					StructureDefinition p = (StructureDefinition) new XmlParser().parse(ManagedFileAccess.inStream(TEST_PROFILE_DIR+"\\"+f));
//					Questionnaire q = b.buildQuestionnaire(p);
//					new XmlComposer().compose(ManagedFileAccess.outStream(TEST_DEST+f), q, true);
					  throw new FHIRException("test");
        } catch (Exception e) {
	        e.printStackTrace();
        }
			}
		}
	}
}