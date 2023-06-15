package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BaseWorkerContextTests {

  private BaseWorkerContext getBaseWorkerContext() throws IOException {
    BaseWorkerContext baseWorkerContext = new BaseWorkerContext() {
      @Override
      public String getVersion() {
        return null;
      }

      @Override
      public IResourceValidator newValidator() throws FHIRException {
        return null;
      }

      @Override
      public void cachePackage(PackageInformation packageInfo) {

      }

      @Override
      public List<String> getResourceNames() {
        return null;
      }

      @Override
      public int loadFromPackage(NpmPackage pi, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public int loadFromPackage(NpmPackage pi, IContextResourceLoader loader, List<String> types) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException {
        return 0;
      }

      @Override
      public boolean hasPackage(String id, String ver) {
        return false;
      }

      @Override
      public boolean hasPackage(PackageInformation pack) {
        return false;
      }

      @Override
      public PackageInformation getPackage(String id, String ver) {
        return null;
      }

      @Override
      public String getSpecUrl() {
        return null;
      }
    };
    baseWorkerContext.expParameters = new Parameters();
    return baseWorkerContext;
  }

  @Test
  public void testAddServerValidationParametersDisplayWarning() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(new ValueSet(), pin, new ValidationOptions().setDisplayWarningMode(true));
    assertEquals("lenient-display-validation", pin.getParameter("mode").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersDisplayError() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(new ValueSet(), pin, new ValidationOptions());
    assertNull(pin.getParameter("mode"));
  }
}
