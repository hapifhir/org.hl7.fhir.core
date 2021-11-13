package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.exceptions.FHIRException;

import java.io.IOException;

public interface IPackageInstaller {
  boolean packageExists(String id, String ver) throws IOException, FHIRException;
  void loadPackage(String id, String ver) throws IOException, FHIRException;
}
