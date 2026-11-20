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



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;

/**
 * see security.md - manages access to the local file system by the FHIR HAPI Core library
 * 
 * By using accessPolicy, allowedPaths and accessor, a host java application can control 
 * whether this library has direct access to the file system (and which paths it is allowed to access),
 * or whether the host application provides controlled access, or whether no access is allowed at all
 * (in which case other information providers need to be provided)
 *  
 * @author Grahame
 *
 */
public class ManagedFileAccess {
  
  public interface IFileAccessor {
    File file(String pathname) throws IOException;
    FileInputStream inStream(String pathname);
    FileOutputStream outStream(String pathname);
    CSFile csfile(String pathname);
    File[] listFiles(File file) throws IOException; // file would be returned from file() above
  }

  public enum FileAccessPolicy {
    DIRECT, // open access to the local file system, though access can be restricted only to files under the paths in AllowedPaths
    MANAGED, // no access except by the FileSystemProxyProvider
    PROHIBITED, // no access at all to File() services
  }

  private static FileAccessPolicy accessPolicy = FileAccessPolicy.DIRECT; // for legacy reasons
  private static List<String> allowedPaths = new ArrayList<>();
  private static IFileAccessor accessor;
  
  
  public static FileAccessPolicy getAccessPolicy() {
    return accessPolicy;
  }

  public static void setAccessPolicy(FileAccessPolicy accessPolicy) {
    ManagedFileAccess.accessPolicy = accessPolicy;
  }

  /**
   * Limits file access (in the DIRECT policy) to the files and folders under these folders. An empty list (the default)
   * means no limit. The IG publisher uses this to keep a build to the IG's own folder, the temp folder and ~/.fhir
   *
   * @param paths the folders, absolute or relative to the current folder
   */
  public static void setAllowedPaths(List<String> paths) {
    List<String> list = new ArrayList<>();
    if (paths != null) {
      for (String p : paths) {
        if (p != null) {
          java.nio.file.Path rp = realPath(p);
          list.add(rp != null ? rp.toString() : java.nio.file.Paths.get(p).toAbsolutePath().normalize().toString());
        }
      }
    }
    // a path inside another one adds nothing (e.g. ~/.fhir/packages when ~/.fhir is there), and nor does the same one twice
    List<String> res = new ArrayList<>();
    for (String p : list) {
      boolean covered = false;
      for (String q : list) {
        if (!p.equals(q) && java.nio.file.Paths.get(p).startsWith(java.nio.file.Paths.get(q))) {
          covered = true;
        }
      }
      if (!covered && !res.contains(p)) {
        res.add(p);
      }
    }
    allowedPaths = res;
  }

  public static List<String> getAllowedPaths() {
    return new ArrayList<>(allowedPaths);
  }

  /**
   * Whether the path is under one of the allowed folders, where it really is: . and .. are resolved, and so are
   * symbolic links, as far as the path exists (the rest of it is yet to be created). Compared by path segments, so
   * /ig-other isn't under /ig
   */
  private static boolean inAllowedPaths(String pathname) {
    if (allowedPaths.isEmpty()) {
      return true;
    }
    if (pathname == null) {
      return false;
    }
    java.nio.file.Path p = realPath(pathname);
    if (p == null) {
      return false;
    }
    for (String s : allowedPaths) {
      if (p.startsWith(java.nio.file.Paths.get(s))) {
        return true;
      }
    }
    return false;
  }

  private static java.nio.file.Path realPath(String pathname) {
    java.nio.file.Path p = java.nio.file.Paths.get(pathname).toAbsolutePath().normalize();
    java.nio.file.Path existing = p;
    while (existing != null && !java.nio.file.Files.exists(existing, java.nio.file.LinkOption.NOFOLLOW_LINKS)) {
      existing = existing.getParent();
    }
    if (existing == null) {
      return p;
    }
    try {
      return existing.toRealPath().resolve(existing.relativize(p)).normalize();
    } catch (IOException e) {
      // a link to nowhere: it isn't anywhere that's allowed
      return null;
    }
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
      return accessor.file(pathname);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  public static File file(String path, String filepath) throws IOException {
    switch (accessPolicy) {
    case DIRECT:
      if (!inAllowedPaths(path)) {
        throw new IOException("The path '"+path+"' cannot be accessed by policy");
      }
      return new File(path, filepath);
    case MANAGED:
      return accessor.file(Utilities.path(path, filepath));
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
        if (!inAllowedPaths(path)) {
          throw new IOException("The path '"+path+"' cannot be accessed by policy");
        }
        return new CSFile(path, filepath);
      case MANAGED:
        return accessor.csfile(Utilities.path(path, filepath));
      case PROHIBITED:
        throw new IOException("Access to files is not allowed by local security policy");
      default:
        throw new IOException("Internal Error");
    }
  }

  public static File csfile(File root, String filepath) throws IOException {
    return csfile(root.getAbsolutePath(), filepath);
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
      return accessor.inStream(pathname);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  /**
   * This doesn't do anything, but it's useful for it to exist, to make code inspection easier
   * @param file
   * @return
   * @throws FileNotFoundException
   */
  public static FileInputStream inStream(File file) throws FileNotFoundException {
    if (accessPolicy == FileAccessPolicy.DIRECT && !inAllowedPaths(file.getAbsolutePath())) {
      throw new FileNotFoundException("The pathname '"+file.getAbsolutePath()+"' cannot be accessed by policy");
    }
    return new FileInputStream(file);
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
      return accessor.outStream(pathname);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

  /**
   * This doesn't do anything, but it's useful for it to exist, to make code inspection easier
   * @param file
   * @return
   * @throws FileNotFoundException
   */
  public static FileOutputStream outStream(File file) throws FileNotFoundException {
    if (accessPolicy == FileAccessPolicy.DIRECT && !inAllowedPaths(file.getAbsolutePath())) {
      throw new FileNotFoundException("The pathname '"+file.getAbsolutePath()+"' cannot be accessed by policy");
    }
    return new FileOutputStream(file);
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
      return accessor.csfile(pathname);
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
      return accessor.file(path.toString());
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
      return accessor.listFiles(f);
    case PROHIBITED:
      throw new IOException("Access to files is not allowed by local security policy");
    default:
      throw new IOException("Internal Error");
    }
  }

}