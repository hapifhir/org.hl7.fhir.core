package org.hl7.fhir.validation.cli.services;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.model.FileInfo;
import org.hl7.fhir.validation.cli.model.ValidationRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

  @Test
  void validateSources() throws Exception {
    SessionCache sessionCache = Mockito.spy(new SessionCache());
    ValidationService myService = new ValidationService(sessionCache);

    String resource = IOUtils.toString(getFileFromResourceAsStream("detected_issues.json"), StandardCharsets.UTF_8);
    List<FileInfo> filesToValidate = new ArrayList<>();
    filesToValidate.add(new FileInfo().setFileName("test_resource.json").setFileContent(resource).setFileType(Manager.FhirFormat.JSON.getExtension()));

    ValidationRequest request = new ValidationRequest().setCliContext(new CliContext()).setFilesToValidate(filesToValidate);
    // Validation run 1...nothing cached yet
    myService.validateSources(request);
    Mockito.verify(sessionCache, Mockito.times(1)).cacheSession(ArgumentMatchers.any(ValidationEngine.class));

    Set<String> sessionIds = sessionCache.getSessionIds();
    if (sessionIds.stream().findFirst().isPresent()) {
      // Verify that after 1 run there is only one entry within the cache
      Assertions.assertEquals(1, sessionIds.size());
      myService.validateSources(request);
      // Verify that the cache has been called on once with the id created in the first run
      Mockito.verify(sessionCache, Mockito.times(1)).fetchSessionValidatorEngine(sessionIds.stream().findFirst().get());
    } else {
      // If no sessions exist within the cache after a run, we auto-fail.
      fail();
    }
  }

  private InputStream getFileFromResourceAsStream(String fileName) {
    // The class loader that loaded the class
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);

    // the stream holding the file content
    if (inputStream == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    } else {
      return inputStream;
    }
  }
}