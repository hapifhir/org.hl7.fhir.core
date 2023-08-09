package org.hl7.fhir.r5.profiles;


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.test.utils.TestPackageLoader;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.Test;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;

public class PEModelTest1343 {

  private IWorkerContext ctxt;

  public void Load() throws Exception {
    if (ctxt == null) {
      ctxt = TestingUtilities.getSharedWorkerContext("4.0.1");
      FilesystemPackageCacheManager pc = new FilesystemPackageCacheManager(true);
      NpmPackage npm = pc.loadPackage("hl7.fhir.fr.core", "1.1.0");
      ctxt.loadFromPackage(npm, new TestPackageLoader(Utilities.strings(SimpleWorkerContext.defaultTypesToLoad().stream().toArray(String[]::new))));
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

    String json = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(res);
    System.out.println(json);
  }

}
