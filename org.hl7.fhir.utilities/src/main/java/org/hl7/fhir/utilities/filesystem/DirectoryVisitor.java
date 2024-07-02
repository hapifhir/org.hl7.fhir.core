package org.hl7.fhir.utilities.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.utilities.Utilities;

public class DirectoryVisitor {
  
  public interface IDirectoryVisitorImplementation {
    boolean enterDirectory(File directory) throws IOException;
    boolean visitFile(File file) throws IOException; // return true if count
  }
  
  private IDirectoryVisitorImplementation worker;
  private Set<String> extensions;
  
  public DirectoryVisitor(IDirectoryVisitorImplementation worker, Set<String> extensions) {
    super();
    this.worker = worker;
    this.extensions = extensions;
    if (this.extensions == null) {
      extensions = new HashSet<>();
    }
  }
  
  public DirectoryVisitor(IDirectoryVisitorImplementation worker, String... extensionList) {
    super();
    this.worker = worker;
    extensions = new HashSet<>();
    for (String s : extensionList) {
      extensions.add(s);
    }
  }
  
  public DirectoryVisitor(IDirectoryVisitorImplementation worker) {
    super();
    this.worker = worker;
    extensions = new HashSet<>();
  }
  
  public static int visitDirectory(IDirectoryVisitorImplementation worker, String path) throws IOException {
    return new DirectoryVisitor(worker).visit(path);
  }

  public static int visitDirectory(IDirectoryVisitorImplementation worker, String path, Set<String> extensions) throws IOException {
    return new DirectoryVisitor(worker, extensions).visit(path);
  }

  public static int visitDirectory(IDirectoryVisitorImplementation worker, String path, String... extensionList) throws IOException {
    return new DirectoryVisitor(worker, extensionList).visit(path);
  }

  public int visit(String path) throws IOException {
    return visit(ManagedFileAccess.file(path));
  }

  private int visit(File file) throws IOException {
    int count = 0;
    if (file.isDirectory()) {
      if (worker.enterDirectory(file)) {
        for (File f : ManagedFileAccess.listFiles(file)) {
          count += visit(f);
        }
      }
    } else {
      String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
      if (extensions.isEmpty() || extensions.contains(ext)) {
        if (worker.visitFile(file)) {
          count++;
        }
      }
    }
    return count;
  }
}
