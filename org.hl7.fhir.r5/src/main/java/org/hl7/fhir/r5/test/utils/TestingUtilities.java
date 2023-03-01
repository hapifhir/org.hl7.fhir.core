package org.hl7.fhir.r5.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.utils.R5Hacker;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.ToolGlobalSettings;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.hl7.fhir.utilities.tests.TestConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class TestingUtilities extends BaseTestingUtilities {

  static public Map<String, IWorkerContext> fcontexts;

  final static public String DEFAULT_CONTEXT_VERSION = "5.0.0";

  /** Get an existing instantiation of a WorkerContext if available
   *
   * This uses the DEFAULT_CONTEXT_VERSION
   * */
  public static IWorkerContext getSharedWorkerContext() {
    return getSharedWorkerContext(DEFAULT_CONTEXT_VERSION);
  }

  /**
   * Get an existing instantiation of a WorkerContext if available
   *
   * @param version FHIR Version to get context for
   * @return
   */
  public static IWorkerContext getSharedWorkerContext(String version) {
    if (!Utilities.existsInList(version, "1.0.2", "3.0.1", "4.0.1", "4.3.0", "5.0.0")) {
      throw new Error("illegal version: "+version);
      
    }
    
    String v = VersionUtilities.getMajMin(version);
    if (fcontexts == null) {
      fcontexts = new HashMap<>();
    }
    if (!fcontexts.containsKey(v)) {
        IWorkerContext fcontext = getWorkerContext(version);
        fcontexts.put(v, fcontext);
    }
    return fcontexts.get(v);
  }

  public static IWorkerContext getWorkerContext(String version) {

    FilesystemPackageCacheManager pcm;
    try {
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
      IWorkerContext fcontext = getWorkerContext(pcm.loadPackage(VersionUtilities.packageForVersion(version), version));
      fcontext.setUcumService(new UcumEssenceService(TestingUtilities.loadTestResourceStream("ucum", "ucum-essence.xml")));
      fcontext.setExpansionProfile(new Parameters());
      if (!fcontext.hasPackage("hl7.terminology.r5", null)) {
        NpmPackage utg = pcm.loadPackage("hl7.terminology.r5");
        System.out.println("Loading THO: "+utg.name()+"#"+utg.version());
        fcontext.loadFromPackage(utg, new TestPackageLoader(new String[]{"CodeSystem", "ValueSet"}));
      } 
      if (!fcontext.hasPackage("hl7.fhir.uv.extensions", null)) {
        NpmPackage ext = pcm.loadPackage("hl7.fhir.uv.extensions");
        System.out.println("Loading Extensions: "+ext.name()+"#"+ext.version());
        fcontext.loadFromPackage(ext, new TestPackageLoader(new String[]{"CodeSystem", "ValueSet", "StructureDefinition"}));
      } 
      R5Hacker.fixR5BrokenResources(fcontext);
      return fcontext;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Error(e);
    }
  }

  public static String getTerminologyCacheDirectory() {
    return TestConfig.getInstance().getTxCacheDirectory("org.hl7.fhir.r5");
  }

  public static SimpleWorkerContext getWorkerContext(NpmPackage npmPackage) throws Exception {
    SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withUserAgent(TestConstants.USER_AGENT)
        .withTerminologyCachePath(getTerminologyCacheDirectory()).fromPackage(npmPackage);
    TerminologyCache.setCacheErrors(true);
    return swc;
  }

  public static SimpleWorkerContext getWorkerContext(NpmPackage npmPackage, IWorkerContext.IContextResourceLoader loader) throws Exception {
    SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withUserAgent(TestConstants.USER_AGENT)
        .withTerminologyCachePath(getTerminologyCacheDirectory()).fromPackage(npmPackage, loader);
    TerminologyCache.setCacheErrors(true);
    return swc;
  }

  static public String fixedpath;
  static public String contentpath;

  public static String home() {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir\\build";
    // FIXME: change this back
    s = "/Users/jamesagnew/git/fhir";
    if (new File(s).exists())
      return s;
    throw new Error("FHIR Home directory not configured");
  }


  public static String content() throws IOException {
    if (contentpath != null)
      return contentpath;
    String s = "R:\\fhir\\publish";
    if (new File(s).exists())
      return s;
    return Utilities.path(home(), "publish");
  }

  // diretory that contains all the US implementation guides
  public static String us() {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir.us";
    if (new File(s).exists())
      return s;
    throw new Error("FHIR US directory not configured");
  }


}