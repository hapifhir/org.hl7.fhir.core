package org.hl7.fhir.dstu2016may.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.hl7.fhir.dstu2016may.formats.XmlParser;
import org.hl7.fhir.dstu2016may.model.StructureDefinition;
import org.hl7.fhir.dstu2016may.utils.QuestionnaireBuilder;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

public class QuestionnaireBuilderTester {

  private static final String TEST_PROFILE_DIR = "C:\\work\\org.hl7.fhir\\build\\publish";
//	private static final String TEST_DEST = Utilities.path("[tmp]", "questionnaires\\");

  public static void main(String[] args) throws IOException {
    QuestionnaireBuilder b = new QuestionnaireBuilder(null);
    for (String f : ManagedFileAccess.file(TEST_PROFILE_DIR).list()) {
      if (f.endsWith(".profile.xml") && !f.contains("type-")) {
        System.out.println("process " + f);
        try {
          StructureDefinition p = (StructureDefinition) new XmlParser()
              .parse(ManagedFileAccess.inStream(TEST_PROFILE_DIR + "\\" + f));
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