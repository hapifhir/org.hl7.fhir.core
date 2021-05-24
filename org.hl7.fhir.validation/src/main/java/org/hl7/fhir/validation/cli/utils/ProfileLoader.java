package org.hl7.fhir.validation.cli.utils;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ProfileLoader {
  public static byte[] loadProfileSource(String src) throws FHIRException, IOException {
    if (Utilities.noString(src)) {
      throw new FHIRException("Profile Source '" + src + "' could not be processed");
    } else if (Common.isNetworkPath(src)) {
      return loadProfileFromUrl(src);
    } else if (new File(src).exists()) {
      return loadProfileFromFile(src);
    } else {
      throw new FHIRException("Definitions Source '" + src + "' could not be processed");
    }
  }

  private static byte[] loadProfileFromUrl(String src) throws FHIRException {
    try {
      URL url = new URL(src + "?nocache=" + System.currentTimeMillis());
      URLConnection c = url.openConnection();
     
      return IOUtils.toByteArray(c.getInputStream());
    } catch (Exception e) {
      throw new FHIRException("Unable to find definitions at URL '" + src + "': " + e.getMessage(), e);
    }
  }

  private static byte[] loadProfileFromFile(String src) throws IOException {
    File f = new File(src);
    if (f.isDirectory())
      throw new IOException("You must provide a file name, not a directory name");
    return TextFile.fileToBytes(src);
  }

}
