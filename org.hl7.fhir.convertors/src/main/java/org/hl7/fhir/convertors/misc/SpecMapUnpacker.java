package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.DirectoryVisitor;
import org.hl7.fhir.utilities.filesystem.DirectoryVisitor.IDirectoryVisitorImplementation;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.NpmPackage;

@SuppressWarnings("checkstyle:systemout")
public class SpecMapUnpacker {

  public static void main(String[] args) throws IOException {
     new SpecMapUnpacker().unpack(args[0]);
  }

  public class SpecMapScanner implements IDirectoryVisitorImplementation {

    @Override
    public boolean enterDirectory(File directory) throws IOException {
      return true;
    }

    @Override
    public boolean visitFile(File file) throws IOException {
      System.out.println("Look at "+file.getAbsolutePath());
      try {
        NpmPackage npm = NpmPackage.fromPackage(ManagedFileAccess.inStream(file));
        if (npm.hasFile("other", "spec.internals")) {
          byte[] cnt = FileUtilities.streamToBytes(npm.load("other", "spec.internals"));
          FileUtilities.bytesToFile(cnt, Utilities.path(FileUtilities.getDirectoryForFile(file.getAbsolutePath()), "page-map.json"));
          System.out.println("  ...extracted");
          return true;
        } else {
          System.out.println("  ...not found");
          return false;
        }
        
      } catch (Exception e) {
        System.out.println("  ...error: "+e.getMessage());
        return false;
      }
    }
    
  }
  
  private void unpack(String path) throws IOException {
    System.out.println("Scanning "+path);
    int count = DirectoryVisitor.visitDirectory(new SpecMapScanner(), path, "tgz");
    System.out.println("Done. "+count+" files extracted");
  }

}
