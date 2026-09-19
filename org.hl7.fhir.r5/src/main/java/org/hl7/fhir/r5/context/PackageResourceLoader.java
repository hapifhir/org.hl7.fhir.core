package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.utils.R5Hacker;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.NpmPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PackageResourceLoader extends CanonicalResourceProxy {

  private final String filename;
  private final IContextResourceLoader loader;
  private final PackageInformation packageInformation;

  public PackageResourceLoader(NpmPackage.PackageResourceInformation pri, IContextResourceLoader loader, PackageInformation pi) {
    super(pri.getResourceType(), pri.getId(), loader == null ? pri.getUrl() : loader.patchUrl(pri.getUrl(), pri.getResourceType()), pri.getVersion(), pri.getSupplements(), pri.getDerivation(), pri.getContent());
    this.filename = pri.getFilename();
    this.loader = loader;
    this.packageInformation = pi;
  }

  @Override
  public CanonicalResource loadResource() {
    try {
      FileInputStream f = ManagedFileAccess.inStream(filename);
      try {
        if (loader != null) {
          return setPi(R5Hacker.fixR5BrokenResource((CanonicalResource) loader.loadResource(f, true)));
        } else {
          return setPi(R5Hacker.fixR5BrokenResource((CanonicalResource) new JsonParser().parse(f)));
        }
      } finally {
        f.close();
      }
    } catch (Exception e) {
      throw new FHIRException("Error loading " + filename + ": " + e.getMessage(), e);
    }
  }

  private CanonicalResource setPi(CanonicalResource cr) {
    cr.setSourcePackage(packageInformation);
    return cr;
  }

  /**
   * This is not intended for use outside the package loaders
   *
   * @return
   * @throws IOException
   */
  public InputStream getStream() throws IOException {
    return ManagedFileAccess.inStream(filename);
  }

}
