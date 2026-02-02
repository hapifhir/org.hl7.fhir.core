package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.analytics.PackageVisitor;
import org.hl7.fhir.validation.packages.PackageCacheDownloader;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Internal maintenance command for pre-loading the package cache.
 *
 * This hidden command downloads and caches all available FHIR packages from the package registry.
 * It is useful for pre-loading a system with all FHIR packages for offline use.
 */
@Slf4j
@CommandLine.Command(
  name = "preloadCache",
  description = """
    (Internal Maintenance Tool) Pre-load Package Cache

    Downloads and caches all available FHIR packages from the package registry.
    This is useful for pre-loading a system with all FHIR packages for offline use.

    This command is hidden - it is an internal maintenance tool.
    """,
  hidden = true
)
public class PreloadCacheCommand extends ValidationServiceCommand implements Callable<Integer> {

  @Override
  public Integer call() {
    try {
      log.info("Starting package cache pre-load operation");

      PackageVisitor pv = new PackageCacheDownloader();
      pv.visitPackages();

      log.info("Package cache pre-load completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error pre-loading package cache", e);
      return 1;
    }
  }
}
