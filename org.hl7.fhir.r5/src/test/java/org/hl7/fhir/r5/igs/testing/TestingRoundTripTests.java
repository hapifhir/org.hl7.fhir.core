package org.hl7.fhir.r5.igs.testing;



/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Round trip tests for the Testing model: each example in the source package(s) is
 * parsed from json, composed to xml, parsed back from the xml, composed back to json,
 * and then the two json representations are compared
 */
public class TestingRoundTripTests {

  private static final String[] PACKAGES = {"hl7.fhir.uv.testing#current"};
  private static final String[] RESOURCE_TYPES = {"TestReport", "TestPlan", "TestScript"};

  public static Stream<Arguments> data() throws IOException {
    List<Arguments> objects = new ArrayList<>();
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    for (String pid : PACKAGES) {
      NpmPackage npm = pcm.loadPackage(pid);
      for (String fn : npm.list("example")) {
        if (fn.endsWith(".json") && fn.contains("-")) {
          String rt = fn.substring(0, fn.indexOf("-"));
          if (Utilities.existsInList(rt, RESOURCE_TYPES)) {
            objects.add(Arguments.of(pid+"/"+fn, pid, fn));
          }
        }
      }
    }
    return objects.stream();
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("data")
  public void testRoundTrip(String name, String pid, String filename) throws IOException {
    NpmPackage npm = new FilesystemPackageCacheManager.Builder().build().loadPackage(pid);
    byte[] source = FileUtilities.streamToBytes(npm.load("example", filename));

    Resource r1 = new TestingJsonParser(true, true).parse(source);
    String json1 = new TestingJsonParser(true, true).composeString(r1);

    String xml = new TestingXmlParser(true).composeString(r1);
    Resource r2 = new TestingXmlParser(true).parse(xml.getBytes(StandardCharsets.UTF_8));

    String json2 = new TestingJsonParser(true, true).composeString(r2);
    assertTrue(r1.equalsDeep(r2), "resources differ after round trip json -> xml -> json:\r\n"+json1+"\r\n----\r\n"+json2);
    assertEquals(json1, json2, "json differs after round trip json -> xml -> json");
  }

}