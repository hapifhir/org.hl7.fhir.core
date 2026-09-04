package org.hl7.fhir.test.profiles;


import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.services.profilemodel.PEBuilder;
import org.hl7.fhir.standalone.testing.TestPackageLoader;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Test;

public class PEModelTest1343 {

  private IWorkerContext ctxt;

  public void Load() throws Exception {
    if (ctxt == null) {
      ctxt = TestingUtilities.getSharedWorkerContext("4.0.1");
      FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager.Builder().build();
      NpmPackage npm = pc.loadPackage("hl7.fhir.fr.core", "1.1.0");
      ctxt.getManager().loadFromPackage(npm, new TestPackageLoader(Utilities.stringSet(SimpleWorkerContext.defaultTypesToLoad().stream().toArray(String[]::new)), TestingUtilities.getSharedWorkerContext("4.0.1")));
    }
  }

  @Test
  public void testPatientCreate() throws Exception {
    CreatePatientFromProfile("http://interopsante.org/fhir/StructureDefinition/FrPatient");
  }

  public void CreatePatientFromProfile(String profileURL) throws Exception {
    this.Load();

    var peBuilder = new PEBuilder(ctxt, PEBuilder.PEElementPropertiesPolicy.NONE, false);
    Patient res = (Patient) peBuilder.createResource(profileURL, true);

    String json = new JsonParser(TestingUtilities.getSharedWorkerContext("4.0.1")).setOutputStyle(OutputStyle.PRETTY).composeString(res);
    System.out.println(json);
  }

}
