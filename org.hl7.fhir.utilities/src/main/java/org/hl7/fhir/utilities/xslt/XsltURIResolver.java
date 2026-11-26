package org.hl7.fhir.utilities.xslt;

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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;

/**
 * Resolves stylesheet includes, document() calls and entity references for the file-based
 * {@link XsltUtilities} transforms.
 * <p>
 * Local hrefs are served only from inside a root directory. Remote (http/https) hrefs are served
 * only by a resolver the caller supplies. Anything else is refused.
 * <p>
 * The <code>base</code> argument to {@link #resolve(String, String)} is ignored. Relative hrefs
 * are always resolved against the root directory, not against the document that referenced them.
 */
public class XsltURIResolver implements URIResolver {

  /**
   * The root directory that local hrefs are resolved against and must stay inside. It may
   * contain variables such as <code>[tmp]</code> and <code>[user]</code>, which are expanded by
   * {@link Utilities#path(String...)}.
   */
  private final String path;

  /**
   * An optional resolver for http and https hrefs. If it is null, or it returns null, remote
   * hrefs are refused. It is never used for local hrefs.
   */
  private final URIResolver alt;

  /**
   * @param path the root directory for local hrefs
   * @param alt an optional resolver for remote (http/https) hrefs, or null to refuse them
   */
  public XsltURIResolver(String path, URIResolver alt) {
    super();
    this.path = path;
    this.alt = alt;
  }


  @Override
  public Source resolve(String href, String base) throws TransformerException {
    try {
      if (href.startsWith("http://") || href.startsWith("https://")) {
        if (alt != null) {
          Source s = alt.resolve(href, base);
          if (s != null)
            return s;
        }
        // No default remote fetch: fetching here would make outbound requests on behalf of the
        // documents being transformed. Callers that need remote resources supply an alt resolver.
        throw new TransformerException("Unable to resolve '" + href + "': remote resources require a caller-supplied resolver");
      } else
        return new StreamSource(ManagedFileAccess.inStream(resolveWithinRoot(href)));
    } catch (IOException e) {
      throw new TransformerException(e);
    }
  }

  /**
   * Resolves a local href against the configured root directory, refusing any result that falls
   * outside it (absolute paths elsewhere, '..' traversal). This prevents stylesheet includes,
   * document() calls, or entity references from reading arbitrary files.
   * <p>
   * The root is built with {@link Utilities#path(String...)} so that variables such as
   * <code>[tmp]</code> and <code>[user]</code> are expanded, as before. Relative hrefs are also
   * resolved with {@link Utilities#path(String...)}. Absolute hrefs are accepted only if they
   * already point inside the root (PathBuilder would otherwise re-root them under it).
   * <p>
   * The check happens in two stages:
   * <ol>
   *   <li>A lexical check (absolute, normalized, no filesystem access) refuses targets outside the
   *   root before anything is opened. Without it, toRealPath() would touch the target first: for
   *   a Windows UNC path such as <code>\\host\share\x.xml</code>, that makes an SMB connection
   *   (which can leak an NTLM hash) before the path is refused.</li>
   *   <li>Both the root and the target are then compared as real paths, with symlinks resolved, so
   *   a symlink inside the root cannot point the read outside it.</li>
   * </ol>
   * The real path is returned so that the file opened is the one that was checked. A target that
   * does not exist fails in the second stage with NoSuchFileException.
   */
  private String resolveWithinRoot(String href) throws TransformerException {
    try {
      Path lexicalRoot = Paths.get(Utilities.path(path)).toAbsolutePath().normalize();
      String resolved = Paths.get(href).isAbsolute() ? href : Utilities.path(path, href);
      Path lexicalTarget = Paths.get(resolved).toAbsolutePath().normalize();
      if (!lexicalTarget.startsWith(lexicalRoot)) {
        throw new TransformerException("Access to '" + href + "' outside " + lexicalRoot + " is not permitted");
      }
      Path root = lexicalRoot.toRealPath();
      Path target = lexicalTarget.toRealPath();
      if (!target.startsWith(root)) {
        throw new TransformerException("Access to '" + href + "' outside " + root + " is not permitted");
      }
      return target.toString();
    } catch (IOException | RuntimeException e) {
      // PathBuilder reports null roots and traversal outside the root as RuntimeException;
      // Paths.get rejects malformed hrefs with InvalidPathException (also a RuntimeException)
      throw new TransformerException(e);
    }
  }

}