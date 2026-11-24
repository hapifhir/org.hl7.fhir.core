package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.exceptions.FHIRException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * The files written to a package so far, for the package generators (NPMPackageGenerator).
 * <p/>
 * Adding exactly the same name twice is a duplicate: the generators report it and skip the second.
 * Adding a name that is a different string but the same file to some reader or file system (see
 * {@link NpmPackage#entryNameKey}: names that differ only in case, as ValueSet-abc.json and
 * ValueSet-ABC.json do for the ids abc and ABC) is an error, because every package reader refuses
 * a package that has both.
 */
public class PackageEntryNames {

  // entryNameKey -> the name as it was added. Linked, so the names come back in the order they were added
  private final Map<String, String> names = new LinkedHashMap<>();

  /**
   * Whether the name, or a name that is the same file to some systems, has been added: adding it would then skip it,
   * or fail
   */
  public boolean contains(String path) {
    return names.containsKey(NpmPackage.entryNameKey(path));
  }

  /** The names that have been added, as they were added (a name added again, and skipped, is there once) */
  public Set<String> getNames() {
    return Collections.unmodifiableSet(new LinkedHashSet<>(names.values()));
  }

  /**
   * @return true if the name is new, and the file should be written; false if exactly this name
   *   has been added already
   * @throws FHIRException if a different name for the same file has been added
   */
  public boolean add(String path) {
    String earlier = names.putIfAbsent(NpmPackage.entryNameKey(path), path);
    if (earlier == null) {
      return true;
    }
    if (earlier.equals(path)) {
      return false;
    }
    throw new FHIRException("The package can't contain both " + earlier + " and " + path
      + ": they are the same file to some systems (they differ only in case, or in ./ or //), and the package tools refuse a package that has both."
      + " If they are resources, their ids differ only in case");
  }
}
