package org.hl7.fhir.utilities.tests;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public interface ResourceLoaderTests {

  static final String PATH_DELIMITER = "/";

  public static InputStream getResourceAsInputStream(Class<?> clazz, String... resourcePath) {
    return clazz.getClassLoader().getResourceAsStream(String.join(PATH_DELIMITER, resourcePath));
  }
  public default InputStream getResourceAsInputStream(String ... resourcePath) {
    return getResourceAsInputStream(this.getClass(), resourcePath);
  }

  public default void copyResourceToFile(Path target, String ... resourcePath) throws IOException {
    copyResourceToFile(this.getClass(), target, resourcePath);
  }

  public static void copyResourceToFile(Class<?> clazz, Path target, String ... resourcePath) throws IOException {
    InputStream initialStream = getResourceAsInputStream(clazz, resourcePath);
    BaseTestingUtilities.createParentDirIfNotExists(target);
    java.nio.file.Files.copy(
      initialStream,
      target,
      StandardCopyOption.REPLACE_EXISTING);

    initialStream.close();
  }

}
