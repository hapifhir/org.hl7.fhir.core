package org.hl7.fhir.dstu3.model;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.hl7.fhir.dstu3.formats.JsonParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MedicationAdministrationCopyTest {

  @DisplayName("Test MedicationAdministration copy")
  @Test
  public void test() throws IOException {
      MedicationAdministration beforeCopy = createMedAdminWithDosageDurationExtension();
      MedicationAdministration afterCopy = beforeCopy.copy();

      System.out.println("---- BEFORE COPY (BEGIN)");
      System.out.println(new JsonParser().composeString(beforeCopy));
      System.out.println("---- BEFORE COPY (END)");
      System.out.println();
      System.out.println("---- AFTER COPY (BEGIN)");
      System.out.println(new JsonParser().composeString(afterCopy));
      System.out.println("---- AFTER COPY (END)");
      assertTrue(beforeCopy.equalsDeep(afterCopy));
  }

  private static MedicationAdministration createMedAdminWithDosageDurationExtension() {
      MedicationAdministration resource = new MedicationAdministration();
      resource.setId("12345");
      var dosage = new MedicationAdministration.MedicationAdministrationDosageComponent();
      dosage.setDose((SimpleQuantity) new SimpleQuantity().setValue(40))
              .addExtension(new Extension()
                      .setUrl("http://duration")
                      .setValue(new Duration().setValue(5340000)));
      resource.setDosage(dosage);
      return resource;
  }
}
