package org.hl7.fhir.validation.cli.services;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;

public interface IPackageInstaller {
  boolean packageExists(String id, String ver) throws IOException, FHIRException;
  void loadPackage(String id, String ver) throws IOException, FHIRException;
}
