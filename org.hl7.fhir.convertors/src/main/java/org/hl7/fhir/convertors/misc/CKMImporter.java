package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;

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


import org.hl7.fhir.convertors.misc.adl.ADLImporter;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CKMImporter {

  private String ckm;
  private String dest;
  private String config;
  private String info;

  public static void main(String[] args) throws Exception {
    CKMImporter self = new CKMImporter();
    self.ckm = getParam(args, "ckm");
    self.dest = getParam(args, "dest");
    self.config = getParam(args, "config");
    self.info = getParam(args, "info");
    if (self.ckm == null || self.dest == null || self.config == null) {
      System.out.println("ADL to FHIR StructureDefinition Converter");
      System.out.println("This tool takes 4 parameters:");
      System.out.println("-ckm: Baase URL of CKM");
      System.out.println("-dest: folder for output");
      System.out.println("-config: filename of OpenEHR/FHIR knowlege base (required)");
      System.out.println("-info: folder for additional knowlege of archetypes");
    } else {
      self.execute();
    }
  }

  private static String getParam(String[] args, String name) {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals("-" + name)) {
        return args[i + 1];
      }
    }
    return null;
  }


  private void execute() throws Exception {
    List<String> ids = new ArrayList<String>();
    Document xml = loadXml(ckm + "/services/ArchetypeFinderBean/getAllArchetypeIds");
    Element e = XMLUtil.getFirstChild(xml.getDocumentElement());
    while (e != null) {
      ids.add(e.getTextContent());
      e = XMLUtil.getNextSibling(e);
    }
//		for (String id : ids) {
//			downloadArchetype(id);
//		}
    for (String id : ids) {
      processArchetype(id);
    }
  }

  private void downloadArchetype(String id) throws Exception {
    System.out.println("Fetch " + id);
    Document sxml = loadXml(ckm + "/services/ArchetypeFinderBean/getArchetypeInXML?archetypeId=" + id);
    Element e = XMLUtil.getFirstChild(sxml.getDocumentElement());

    String src = Utilities.path("c:\\temp", id + ".xml");
    TextFile.stringToFile(e.getTextContent(), src);
  }

  private void processArchetype(String id) throws Exception {
    System.out.println("Process " + id);

    String cfg = info == null ? null : Utilities.path(info, id + ".config");
    String src = Utilities.path("c:\\temp", id + ".xml");
    String dst = Utilities.path(dest, id + ".xml");

    if (!new File(src).exists())
      downloadArchetype(id);
    if (cfg != null && new File(cfg).exists())
      ADLImporter.main(new String[]{"-source", src, "-dest", dst, "-config", config, "-info", cfg});
    else
      ADLImporter.main(new String[]{"-source", src, "-dest", dst, "-config", config});
  }

  private Document loadXml(String address) throws Exception {
    SimpleHTTPClient http = new SimpleHTTPClient();
    HTTPResult res = http.get(address, "application/xml");
    res.checkThrowException();
    InputStream xml = new ByteArrayInputStream(res.getContent());

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    return db.parse(xml);
  }
}