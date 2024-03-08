package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

import net.sourceforge.plantuml.tim.stdlib.GetVariableValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
      public <T extends Resource> T fetchResourceRaw(Class<T> class_, String uri) {
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

      @Override
      public <T extends Resource> List<T> fetchResourcesByUrl(Class<T> class_, String url) {
        return new ArrayList<>();
      }

    };
    baseWorkerContext.expParameters = new Parameters();
    return baseWorkerContext;
  }

  @Test
  public void testAddServerValidationParametersDisplayWarning() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(baseWorkerContext.getTxClientManager().getMaster(), new ValueSet(), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getVersion())).setDisplayWarningMode(true));
    assertEquals("lenient-display-validation", pin.getParameter("mode").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersVsAsUrl() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();
    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(baseWorkerContext.getTxClientManager().getMaster(), new ValueSet().setUrl("http://dummy.org/vs"), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getVersion())).setVsAsUrl(true));
    assertEquals("uri", pin.getParameter("url").getValue().fhirType());
    assertEquals("http://dummy.org/vs", pin.getParameter("url").getValue().primitiveValue());
  }

  @Test
  public void testAddServerValidationParametersDisplayError() throws IOException {
    BaseWorkerContext baseWorkerContext = getBaseWorkerContext();

    Parameters pin = new Parameters();
    baseWorkerContext.addServerValidationParameters(baseWorkerContext.getTxClientManager().getMaster(), new ValueSet(), pin, new ValidationOptions(FhirPublication.fromCode(baseWorkerContext.getVersion())));
    assertNull(pin.getParameter("mode"));
  }
}
