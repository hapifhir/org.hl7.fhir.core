package org.hl7.fhir.validation.packages;

import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.PackageServer;

import java.io.IOException;
import java.util.List;

/**
 * A PackageVisitor that is intended to visit each available package from
 * https://packages2.fhir.org/packages aka PackageServer.secondaryServer()
 * <p/>
 * A useful side effect of this is that it fills the package cache on the disk
 * with all available packages. Aside from this, it does nothing but write to
 * console out.
 * <p/>
 * It targets the secondary server to avoid loading the primary server.
 *
 */
public class PackageCacheDownloader extends PackageVisitor implements PackageVisitor.IPackageVisitorProcessor{

  public PackageCacheDownloader() throws IOException {
    super();
    setClientPackageServer(PackageServer.secondaryServer());
    setCachePackageServers(List.of(PackageServer.secondaryServer()));

    String taskCache = Utilities.path("[tmp]", "package-cache-task");

    setProcessor(this);
    setCache(taskCache);
    setOldVersions(true);
    setCorePackages(true);
  }

  @Override
  public Object startPackage(PackageVisitor.PackageContext context) throws FHIRException {
    System.out.println("Currently loading " + context.getPid());
    return null;
  }

  @Override
  public void processResource(PackageVisitor.PackageContext context, Object clientContext, String type, String id, byte[] content) throws FHIRException {

  }

  @Override
  public void finishPackage(PackageVisitor.PackageContext context) throws FHIRException {

  }

  @Override
  public void alreadyVisited(String pid) throws FHIRException {

  }
}
