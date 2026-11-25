package org.hl7.fhir.utilities.filesystem;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * see security.md - manages access to the local file system by the FHIR HAPI Core library
 * 
 * By using accessPolicy and allowedPaths, a host java application can control
 * whether this library has direct access to the file system (and which paths it is allowed to access),
 * or whether no access is allowed at all (in which case other information providers need to be provided)
 *  
 * @author Grahame
 *
 */
public class ManagedFileAccess {

  public static final String FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED = "FileAccessPolicy.MANAGED is not supported";

  /**
   * @deprecated not used: the MANAGED policy it was meant for is not supported (see FileAccessPolicy.MANAGED)
   */
  @Deprecated
  public interface IFileAccessor {
    File file(String pathname) throws IOException;
    FileInputStream inStream(String pathname);
    FileOutputStream outStream(String pathname);
    CSFile csfile(String pathname);
    File[] listFiles(File file) throws IOException; // file would be returned from file() above
  }

  public enum FileAccessPolicy {
    DIRECT, // open access to the local file system, though access can be restricted only to files under the paths in AllowedPaths
    /**
     * Not supported. {@link ManagedFileAccess#setAccessPolicy(FileAccessPolicy)} refuses it with an
     * {@link UnsupportedOperationException}, and so does every file operation if the policy is somehow MANAGED.
     *
     * @deprecated This never worked: there was no way to set an {@link IFileAccessor}, and some operations (temporary
     * files, links, walking folders) can't be done through one at all. Nothing in core, the IG publisher or kindling
     * uses it. Use DIRECT, limited to some folders with {@link ManagedFileAccess#setAllowedPaths(List)}, or PROHIBITED.
     */
    @Deprecated
    MANAGED,
    PROHIBITED, // no access at all to File() services
  }

  private static FileAccessPolicy accessPolicy = defaultFileAccessPolicy(); // for legacy reasons

  @Nonnull
  protected static FileAccessPolicy defaultFileAccessPolicy() {
    return FileAccessPolicy.DIRECT;
  }

  // set by one thread (e.g. as the IG publisher starts), read by others: replaced whole, never changed in place
  private static volatile List<String> allowedPaths = defaultAllowedPaths();

  @Nonnull
  protected static List<String> defaultAllowedPaths() {
    return java.util.Collections.emptyList();
  }


  public static FileAccessPolicy getAccessPolicy() {
    return accessPolicy;
  }

  public static void setAccessPolicy(FileAccessPolicy accessPolicy) {
    if (accessPolicy == FileAccessPolicy.MANAGED) {
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    }
    ManagedFileAccess.accessPolicy = accessPolicy;
  }

  /**
   * Limits file access (in the DIRECT policy) to the files and folders under these folders. An empty list (the default)
   * means no limit. The IG publisher uses this to keep a build to the IG's own folder, the temp folder and ~/.fhir
   *
   * @param paths the folders, absolute or relative to the current folder
   */
  public static void setAllowedPaths(List<String> paths) {
    final List<String> realPaths = new ArrayList<>();
    if (paths != null) {
      for (String path : paths) {
        if (path != null) {
          java.nio.file.Path realPath = realPath(path);
          realPaths.add(realPath != null ? realPath.toString() : java.nio.file.Paths.get(path).toAbsolutePath().normalize().toString());
        }
      }
    }
    final List<String> uniquePaths = getUniquePaths(realPaths);
    allowedPaths = java.util.Collections.unmodifiableList(uniquePaths);
  }

  protected static @Nonnull List<String> getUniquePaths(List<String> realPaths) {
    // a path inside another one adds nothing (e.g. ~/.fhir/packages when ~/.fhir is there), and nor does the same one twice
    final List<String> uniquePaths = new ArrayList<>();
    for (String pathToAdd : realPaths) {
      boolean covered = false;
      for (String existingPath : realPaths) {
        if (!pathToAdd.equals(existingPath) && java.nio.file.Paths.get(pathToAdd).startsWith(java.nio.file.Paths.get(existingPath))) {
          covered = true;
        }
      }
      if (!covered && !uniquePaths.contains(pathToAdd)) {
        uniquePaths.add(pathToAdd);
      }
    }
    return uniquePaths;
  }

  public static List<String> getAllowedPaths() {
    return new ArrayList<>(allowedPaths);
  }

  /**
   * Whether the path is under one of the allowed folders (see {@link #inAllowedPaths}), for code that is choosing
   * between candidate locations and should pass over one it can't use, rather than fail on it
   */
  public static boolean isAllowedPath(String pathname) {
    return inAllowedPaths(pathname);
  }

  /**
   * Whether the path is under one of the allowed folders, where it really is: . and .. are resolved, and so are
   * symbolic links, as far as the path exists (the rest of it is yet to be created). Compared by path segments, so
   * /ig-other isn't under /ig
   */
  private static boolean inAllowedPaths(String pathname) {
    List<String> allowedPathsRef = allowedPaths; // keep a reference to the original list throughout this method, even if the original is replaced by another thread.
    if (allowedPathsRef.isEmpty()) {
      return true;
    }
    if (pathname == null) {
      return false;
    }
    java.nio.file.Path realPath = realPath(pathname);
    if (realPath == null) {
      return false;
    }
    for (String allowedPath : allowedPathsRef) {
      if (realPath.startsWith(java.nio.file.Paths.get(allowedPath))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Where a path really is, as the file system would resolve it: symbolic links are followed as far as the path
   * exists, and . and .. are resolved where they are, after the links before them (so /ig/link/../x is the folder above
   * where link leads, not /ig/x - normalising the text first gets that wrong). Whatever doesn't exist yet is taken as
   * plain folders that will be created. Null if the path isn't a path on this platform, or leads to a link to nowhere
   */
  public static java.nio.file.Path realPath(String pathname) {
    java.nio.file.Path absolutePath;
    try {
      absolutePath = java.nio.file.Paths.get(pathname).toAbsolutePath();
    } catch (java.nio.file.InvalidPathException e) {
      // not a path this platform has (e.g. a URL on Windows, where : * ? < > | can't be in a name): it isn't anywhere
      // that's allowed, and the caller gets the policy's IOException, not this unchecked one
      return null;
    }
    Path longestExistingPath = longestExistingPath(absolutePath);
    if (longestExistingPath == null) {
      return absolutePath.normalize();
    }
    java.nio.file.Path realPath;
    try {
      realPath = longestExistingPath.toRealPath();
    } catch (IOException e) {
      // a link to nowhere: it isn't anywhere that's allowed
      return null;
    }
    if (longestExistingPath.getNameCount() == absolutePath.getNameCount()) {
      return realPath;
    }
    java.nio.file.Path nonExistingSubPath = absolutePath.subpath(longestExistingPath.getNameCount(), absolutePath.getNameCount());
    final boolean hasDotDot = hasDotDot(nonExistingSubPath);
    if (!hasDotDot) {
      // none of the rest exists, so there are no links in it
      return realPath.resolve(nonExistingSubPath).normalize();
    }
    return resolveDotEntriesAgainstRealPath(realPath, nonExistingSubPath);
  }

  protected static @Nullable Path resolveDotEntriesAgainstRealPath(Path realPath, Path nonExistingSubPath) {
    // with a .., the rest can lead back into what exists (new/../link/../x), so it's resolved a step at a time
    Path currentPath = realPath;
    for (Path nonExistingSegment : nonExistingSubPath) {
      String segmentString = nonExistingSegment.toString();
      if (".".equals(segmentString)) {
        continue;
      }
      if ("..".equals(segmentString)) {
        // currentPath is a real path (no links in it), so its parent is where .. really goes
        currentPath = currentPath.getParent() == null ? currentPath : currentPath.getParent();
      } else {
        currentPath = currentPath.resolve(segmentString);
      }
      if (java.nio.file.Files.exists(currentPath, java.nio.file.LinkOption.NOFOLLOW_LINKS)) {
        try {
          currentPath = currentPath.toRealPath();
        } catch (IOException e) {
          return null;
        }
      }
    }
    return currentPath;
  }

  protected static boolean hasDotDot(Path nonExistingSubPath) {
    boolean hasDotDot = false;
    for (Path nonExistingSegment : nonExistingSubPath) {
      hasDotDot = hasDotDot || "..".equals(nonExistingSegment.toString());
    }
    return hasDotDot;
  }

  protected static @Nullable Path longestExistingPath(Path absolutePath) {
    // the longest part of the path that exists. Not normalised: the file system resolves the .. in /ig/link/.. after
    // following link, and so do exists() and toRealPath()
    Path existing = absolutePath;
    while (existing != null && !java.nio.file.Files.exists(existing, java.nio.file.LinkOption.NOFOLLOW_LINKS)) {
      existing = existing.getParent();
    }
    return existing;
  }

  /**
   * Whether path is inside root (or is root), where they really are (see {@link #realPath}). Compared by path segments,
   * so /ig-other isn't inside /ig. False if either isn't a path, or leads to a link to nowhere
   */
  public static boolean isInside(String root, String path) {
    java.nio.file.Path r = root == null ? null : realPath(root);
    java.nio.file.Path p = path == null ? null : realPath(path);
    return r != null && p != null && p.startsWith(r);
  }

  /** 
   * Open a file, conforming to local security policy 
   **/
  public static File file(String pathname) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(pathname)) {
        throw new IOException("The pathname '"+pathname+"' cannot be accessed by policy");
      }
      return new File(pathname);
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  /**
   * A file in a folder. The name can have folders in it, but must stay in the folder: names come from zip entries,
   * references and the like, so ../../etc/passwd is refused (as Utilities.path does). And the file itself (not just the
   * folder) has to be somewhere the policy allows: a link in the folder can lead elsewhere
   */
  public static File file(String path, String filepath) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      File f = new File(path, filepath);
      checkChild(path, filepath, f);
      if (!inAllowedPaths(f.getAbsolutePath())) {
        throw new IOException("The path '"+f.getAbsolutePath()+"' cannot be accessed by policy");
      }
      return f;
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public static File file(File root, String filepath) throws IOException {
    return file(root.getAbsolutePath(), filepath);
  }

  public static File csfile(String path, String filepath) throws IOException {
    switch (accessPolicy) {
      case DIRECT:
        // checked before the CSFile is made, because that looks at the file
        File f = new File(path, filepath);
        checkChild(path, filepath, f);
        if (!inAllowedPaths(f.getAbsolutePath())) {
          throw new IOException("The path '"+f.getAbsolutePath()+"' cannot be accessed by policy");
        }
        return new CSFile(path, filepath);
      case MANAGED:
        throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
      case PROHIBITED:
        throw new IOException("Access to files is not allowed by local security policy");
      default:
        throw new IOException("Internal Error");
    }
  }

  public static File csfile(File root, String filepath) throws IOException {
    return csfile(root.getAbsolutePath(), filepath);
  }

  /** the file must be in the folder, as written (a link is checked by the policy, which looks at where the file really is) */
  private static void checkChild(String path, String filepath, File f) throws IOException {
    java.nio.file.Path parent;
    java.nio.file.Path child;
    try {
      parent = java.nio.file.Paths.get(path).toAbsolutePath().normalize();
      child = f.toPath().toAbsolutePath().normalize();
    } catch (java.nio.file.InvalidPathException e) {
      // not a name this platform can have (e.g. a URL on Windows)
      throw new IOException("The name '"+filepath+"' isn't a file in the folder '"+path+"'", e);
    }
    if (filepath == null || filepath.isEmpty() || !child.startsWith(parent) || child.equals(parent)) {
      throw new IOException("The name '"+filepath+"' isn't a file in the folder '"+path+"'");
    }
  }

  /**
   * Open a FileInputStream, conforming to local security policy 
   **/
  public static FileInputStream inStream(String pathname) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(pathname)) {
        throw new IOException("The pathname '"+pathname+"' cannot be accessed by policy");
      }
      return new FileInputStream(pathname);
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  /**
   * Open a FileInputStream, conforming to local security policy, as inStream(String) does. Throws FileNotFoundException (not
   * IOException) when the policy refuses, as new FileInputStream(file) would when it can't open the file
   */
  public static FileInputStream inStream(File file) throws FileNotFoundException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(file.getAbsolutePath())) {
        throw new FileNotFoundException("The pathname '"+file.getAbsolutePath()+"' cannot be accessed by policy");
      }
      return new FileInputStream(file);
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new FileNotFoundException("Access to files is not allowed by local security policy");
    default:
      throw new FileNotFoundException("Internal Error");
    }
  }

  /** 
   * Open a FileInputStream, conforming to local security policy 
   **/

  public static FileOutputStream outStream(String pathname) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(pathname)) {
        throw new IOException("The pathname '"+pathname+"' cannot be accessed by policy");
      }
      return new FileOutputStream(pathname);
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  /**
   * Open a FileOutputStream, conforming to local security policy, as outStream(String) does. Throws FileNotFoundException (not
   * IOException) when the policy refuses, as new FileOutputStream(file) would when it can't open the file
   */
  public static FileOutputStream outStream(File file) throws FileNotFoundException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(file.getAbsolutePath())) {
        throw new FileNotFoundException("The pathname '"+file.getAbsolutePath()+"' cannot be accessed by policy");
      }
      return new FileOutputStream(file);
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new FileNotFoundException("Access to files is not allowed by local security policy");
    default:
      throw new FileNotFoundException("Internal Error");
    }
  }
  
  /** 
   * same as file() but checks case is correct when opening directly (for consistency across platforms) 
   **/
  public static CSFile csfile(String pathname) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(pathname)) {
        throw new IOException("The pathname '"+pathname+"' cannot be accessed by policy");
      }
      return new CSFile(pathname);
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public static File fromPath(Path path) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(path.toString())) {
        throw new IOException("The pathname '"+path.toString()+"' cannot be accessed by policy");
      }
      return path.toFile();
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public static File[] listFiles(File f) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(f.getAbsolutePath())) {
        throw new IOException("The pathname '"+f.getAbsolutePath()+"' cannot be accessed by policy");
      }
      return f.listFiles();
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  /**
   * Creates a new empty file in the system temp folder (java.io.tmpdir), as File.createTempFile does, conforming to
   * local security policy: the temp folder has to be one that may be accessed
   */
  public static File createTempFile(String prefix, String suffix) throws IOException {
    return createTempFile(null, prefix, suffix);
  }

  /**
   * As createTempFile(prefix, suffix), in the folder dir (null for the system temp folder), which has to be one that
   * may be accessed
   */
  public static File createTempFile(File dir, String prefix, String suffix) throws IOException {
    return File.createTempFile(prefix, suffix, tempFolder(dir));
  }

  /**
   * Creates a new empty folder in the system temp folder (java.io.tmpdir), as Files.createTempDirectory does,
   * conforming to local security policy: the temp folder has to be one that may be accessed
   */
  public static File createTempDirectory(String prefix) throws IOException {
    return java.nio.file.Files.createTempDirectory(tempFolder(null).toPath(), prefix).toFile();
  }

  /** the folder to make a temporary file or folder in (null for the system temp folder), once policy allows it */
  private static File tempFolder(File dir) throws IOException {
    File folder = dir != null ? dir : new File(System.getProperty("java.io.tmpdir"));
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(folder.getAbsolutePath())) {
        throw new IOException("The pathname '"+folder.getAbsolutePath()+"' cannot be accessed by policy");
      }
      return folder;
    case MANAGED:
      throw new UnsupportedOperationException(FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

}