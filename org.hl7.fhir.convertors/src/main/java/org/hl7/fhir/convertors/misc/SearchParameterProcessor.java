package org.hl7.fhir.convertors.misc;

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



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

public class SearchParameterProcessor {

  public class SPRelationship {
    private String r4;
    private String r3;
    private String r2b;
    private String r2;
    public SPRelationship(String r4, String r3, String r2b, String r2) {
      super();
      this.r4 = r4;
      this.r3 = r3;
      this.r2b = r2b;
      this.r2 = r2;
    }
    public String getR4() {
      return r4;
    }
    public String getR3() {
      return r3;
    }
    public String getR2b() {
      return r2b;
    }
    public String getR2() {
      return r2;
    }
    public String getByCode(String code) {
      if ("R4".equals(code))
        return r4;
      if ("R3".equals(code))
        return r3;
      if ("R2b".equals(code))
        return r2b;
      if ("R2".equals(code))
        return r2;
      return null;
    }
    
  }

  private static final String ROOT = "C:\\work\\org.hl7.fhir\\org.fhir.interversion\\package";

  private List<SPRelationship> list = new ArrayList<>();
  
  private List<String> list4 = new ArrayList<>();
  private List<String> list3 = new ArrayList<>();
  private List<String> list2 = new ArrayList<>();
  private List<String> list2b = new ArrayList<>();
  
  private void load() throws FileNotFoundException, IOException, FHIRException {
    load4();
    load3();
    load2b();
    load2();
    loadCsv();
    
    check4();
    check3();
    check2b();
    check2();
    
    generate("R3", "R4", "STU3", "R4");
    generate("R4", "R3", "R4", "STU3");
    generate("R2", "R4", "DSTU2", "R4");
    generate("R4", "R2", "R4", "DSTU2");
    generate("R2", "R3", "DSTU2", "STU3");
    generate("R3", "R2", "STU3", "DSTU2");
  }
  
  private void generate(String src, String dst, String srcURL, String tgtURL) throws FileNotFoundException, IOException {
    ConceptMap map = new ConceptMap();
    map.setId("search-parameters-"+src+"-to-"+dst);
    map.setUrl("http://hl7.org/fhir/interversion/ConceptMap/"+map.getId());
    map.setName("SearchParameterMap"+src+dst);
    map.setTitle("Search Parameter Map - "+src+" to "+dst);
    map.setStatus(PublicationStatus.DRAFT);
    map.setDate(new Date());
    map.setExperimental(false);
    map.setPublisher("HL7");
    ConceptMapGroupComponent group = map.addGroup();
    group.setSource("http://hl7.org/fhir/"+srcURL);
    group.setTarget("http://hl7.org/fhir/"+tgtURL);
    for (SPRelationship sp : list) {
      String s = sp.getByCode(src);
      String d = sp.getByCode(dst);
      if (!Utilities.noString(s) && !Utilities.noString(d)) {
        SourceElementComponent e = makeElement(s, group);
        e.addTarget().setCode(d).setRelationship(ConceptMapRelationship.RELATEDTO);
      }
    }
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(ROOT, "ConceptMap-"+map.getId()+".json")), map);
  }

  private SourceElementComponent makeElement(String code, ConceptMapGroupComponent group) {
    for (SourceElementComponent e : group.getElement()) {
      if (e.getCode().equals(code))
        return e;
    }
    return group.addElement().setCode(code);
  }

  private void check4() {
    for (String s : list4) {
      boolean ok = false;
      for (SPRelationship t : list) {
        if (s.equals(t.r4))
          ok = true;
      }
      if (!ok)
        System.out.println("R4 missing : "+s);
    }
    for (SPRelationship sp : list) {
      if (!Utilities.noString(sp.r4)) {
        boolean ok = list4.contains(sp.r4);
        if (!ok)
          System.out.println("R4 extra : "+sp.r4);
      }
    }
  }

  private void check3() {
    for (String s : list3) {
      boolean ok = false;
      for (SPRelationship t : list) {
        if (s.equals(t.r3))
          ok = true;
      }
      if (!ok)
        System.out.println("R3 : "+s);
    }
    for (SPRelationship sp : list) {
      if (!Utilities.noString(sp.r3)) {
        boolean ok = list3.contains(sp.r3);
        if (!ok)
          System.out.println("R3 extra : "+sp.r3);
      }
    }
  }

  private void check2b() {
    for (String s : list2b) {
      boolean ok = false;
      for (SPRelationship t : list) {
        if (s.equals(t.r2b))
          ok = true;
      }
      if (!ok)
        System.out.println("R2b : "+s);
    }
    for (SPRelationship sp : list) {
      if (!Utilities.noString(sp.r2b)) {
        boolean ok = list2b.contains(sp.r2b);
        if (!ok)
          System.out.println("R2b extra : "+sp.r2b);
      }
    }
  }

  private void check2() {
    for (String s : list2) {
      boolean ok = false;
      for (SPRelationship t : list) {
        if (s.equals(t.r2))
          ok = true;
      }
      if (!ok)
        System.out.println("R2 : "+s);
    }
    for (SPRelationship sp : list) {
      if (!Utilities.noString(sp.r2)) {
        boolean ok = list2.contains(sp.r2);
        if (!ok)
          System.out.println("R2 extra : "+sp.r2);
      }
    }
  }

  private void load4() throws FHIRFormatError, FileNotFoundException, IOException {
    org.hl7.fhir.r4.model.Bundle bundle = (org.hl7.fhir.r4.model.Bundle) new org.hl7.fhir.r4.formats.JsonParser().parse(new FileInputStream("c:\\temp\\sp4.json"));
    for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent be : bundle.getEntry()) {
      org.hl7.fhir.r4.model.SearchParameter sp = (org.hl7.fhir.r4.model.SearchParameter) be.getResource();
      for (org.hl7.fhir.r4.model.CodeType br : sp.getBase()) {
        if (!Utilities.existsInList(br.asStringValue(), "DomainResource", "Resource"))
        list4.add(br.asStringValue()+"."+sp.getCode());//+", "+sp.getType().toCode()); 
      }
    }
    Collections.sort(list4);
    System.out.println("R4 loaded - "+list4.size()+" parameters");
  }

  private void load3() throws FHIRFormatError, FileNotFoundException, IOException {
    org.hl7.fhir.dstu3.model.Bundle bundle = (org.hl7.fhir.dstu3.model.Bundle) new org.hl7.fhir.dstu3.formats.JsonParser().parse(new FileInputStream("c:\\temp\\sp3.json"));
    for (org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent be : bundle.getEntry()) {
      org.hl7.fhir.dstu3.model.SearchParameter sp = (org.hl7.fhir.dstu3.model.SearchParameter) be.getResource();
      for (org.hl7.fhir.dstu3.model.CodeType br : sp.getBase()) {
        if (!Utilities.existsInList(br.asStringValue(), "DomainResource", "Resource"))
        list3.add(br.asStringValue()+"."+sp.getCode());//+", "+sp.getType().toCode()); 
      }
    }
    Collections.sort(list3);
    System.out.println("R3 loaded - "+list3.size()+" parameters");
  }

  private void load2() throws FHIRFormatError, FileNotFoundException, IOException {
    org.hl7.fhir.dstu2.model.Bundle bundle = (org.hl7.fhir.dstu2.model.Bundle) new org.hl7.fhir.dstu2.formats.JsonParser().parse(new FileInputStream("c:\\temp\\sp2.json"));
    for (org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent be : bundle.getEntry()) {
      org.hl7.fhir.dstu2.model.SearchParameter sp = (org.hl7.fhir.dstu2.model.SearchParameter) be.getResource();
      String br = sp.getBase();
      if (!Utilities.existsInList(br, "DomainResource", "Resource"))
      list2.add(br+"."+sp.getCode());//+", "+sp.getType().toCode()); 
    }
    Collections.sort(list2);
    System.out.println("R2 loaded - "+list2.size()+" parameters");
  }

  private void load2b() throws FHIRFormatError, FileNotFoundException, IOException {
    org.hl7.fhir.dstu2016may.model.Bundle bundle = (org.hl7.fhir.dstu2016may.model.Bundle) new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new FileInputStream("c:\\temp\\sp2b.json"));
    for (org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent be : bundle.getEntry()) {
      org.hl7.fhir.dstu2016may.model.SearchParameter sp = (org.hl7.fhir.dstu2016may.model.SearchParameter) be.getResource();
      String br = sp.getBase();
      if (!Utilities.existsInList(br, "DomainResource", "Resource"))
      list2b.add(br+"."+sp.getCode());//+", "+sp.getType().toCode()); 
    }
    Collections.sort(list2b);
    System.out.println("R2b loaded - "+list2b.size()+" parameters");
  }

  private void loadCsv() throws IOException, FHIRException {
    CSVReader csv = new CSVReader(new FileInputStream("C:\\work\\org.hl7.fhir\\org.fhir.interversion\\work\\search-params.csv"));
    csv.readHeaders();
    while (csv.line()) {
      String r4 = csv.cell("R4");
      String r3 = csv.cell("R3");
      String r2b = csv.cell("R2b");
      String r2 = csv.cell("R2");
      if (!Utilities.noString(r4) || !Utilities.noString(r3) || !Utilities.noString(r2b) || !Utilities.noString(r2)) {
        boolean ok = (!Utilities.noString(r4) && r4.contains(".")) ||
            (!Utilities.noString(r3) && r3.contains(".")) ||
            (!Utilities.noString(r2b) && r2b.contains(".")) ||
            (!Utilities.noString(r2) && r2.contains("."));
        if (ok) {
          list.add(new SPRelationship(r4, r3, r2b, r2));
        }
      }
    }
    System.out.println("Map loaded - "+list.size()+" entries");    
  }

//  private void generate(String name) throws IOException {
//    StringBuilder b = new StringBuilder();
//    
//    String rn = "";
//    Collections.sort(list);
//    for (String s : list) {
//      String rnn = s.substring(0, s.indexOf("."));
//      if (!rnn.equals(rn)) {
//        rn = rnn;
//        b.append(rn+"\r\n");
//      }
//      b.append(s+"\r\n");
//    }
//    TextFile.stringToFile(b.toString(), name);
//  }
//
  public static void main(String[] args) throws FileNotFoundException, IOException, FHIRException {
    new SearchParameterProcessor().load();
  }


}