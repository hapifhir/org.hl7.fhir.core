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



/*
Copyright (c) 2011+, HL7, Inc
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

public class XsltURIResolver implements URIResolver {

  private final String path;
  private final URIResolver alt;
  
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
        return org.hl7.fhir.utilities.xml.XMLUtil.newXXEProtectedTransformerFactory().getURIResolver().resolve(href, base);
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
   */
  private String resolveWithinRoot(String href) throws TransformerException {
    try {
      Path root = Paths.get(Utilities.path(path)).toAbsolutePath().normalize();
      String resolved = Paths.get(href).isAbsolute() ? href : Utilities.path(path, href);
      Path target = Paths.get(resolved).toAbsolutePath().normalize();
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