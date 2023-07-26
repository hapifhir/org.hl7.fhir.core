package org.hl7.fhir.r4b.test;

import java.io.File;
import java.io.FileInputStream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.utils.QuestionnaireBuilder;

public class QuestionnaireBuilderTester {

  private static final String TEST_PROFILE_DIR = "C:\\work\\org.hl7.fhir\\build\\publish";
//	private static final String TEST_DEST = Utilities.path("[tmp]", "questionnaires\\");

  public static void main(String[] args) {
    QuestionnaireBuilder b = new QuestionnaireBuilder(null);
    for (String f : new File(TEST_PROFILE_DIR).list()) {
      if (f.endsWith(".profile.xml") && !f.contains("type-")) {
        System.out.println("process " + f);
        try {
          StructureDefinition p = (StructureDefinition) new XmlParser()
              .parse(new FileInputStream(TEST_PROFILE_DIR + "\\" + f));
//					Questionnaire q = b.buildQuestionnaire(p);
//					new XmlComposer().compose(new FileOutputStream(TEST_DEST+f), q, true);
          throw new FHIRException("test");
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}