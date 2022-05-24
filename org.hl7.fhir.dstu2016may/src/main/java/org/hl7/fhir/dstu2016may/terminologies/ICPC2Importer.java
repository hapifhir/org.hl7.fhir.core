package org.hl7.fhir.dstu2016may.terminologies;

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
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu2016may.formats.XmlParser;
import org.hl7.fhir.dstu2016may.model.CodeSystem;
import org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu2016may.model.Coding;
import org.hl7.fhir.dstu2016may.model.DateTimeType;
import org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus;
import org.hl7.fhir.dstu2016may.model.Identifier;
import org.hl7.fhir.dstu2016may.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * This is defined as a prototype ClaML importer
 * 
 * @author Grahame
 *
 */

public class ICPC2Importer {

  public static void main(String[] args) {
    try {
      ICPC2Importer r = new ICPC2Importer();
      r.setSourceFileName(Utilities.path("[tmp]", "ICPC-2e-v5.0.xml"));
      r.setTargetFileNameCS(Utilities.path("[tmp]", "icpc2.xml"));
      r.setTargetFileNameVS(Utilities.path("[tmp]", "icpc2-vs.xml"));
      r.go();
      System.out.println("Completed OK");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String sourceFileName; // the ICPC2 ClaML file
  private String targetFileNameVS; // the value set to produce
  private String targetFileNameCS; // the value set to produce
  
  public ICPC2Importer() {
    super();
  }
  public ICPC2Importer(String sourceFileName, String targetFileNameCS, String targetFileNameVS) {
    super();
    this.sourceFileName = sourceFileName;
    this.targetFileNameCS = targetFileNameCS;
    this.targetFileNameVS = targetFileNameVS;
  }
  public String getSourceFileName() {
    return sourceFileName;
  }
  public void setSourceFileName(String sourceFileName) {
    this.sourceFileName = sourceFileName;
  }
  public String getTargetFileNameCS() {
    return targetFileNameCS;
  }
  public void setTargetFileNameCS(String targetFileName) {
    this.targetFileNameCS = targetFileName;
  }

  public String getTargetFileNameVS() {
    return targetFileNameVS;
  }
  public void setTargetFileNameVS(String targetFileName) {
    this.targetFileNameVS = targetFileName;
  }

  public void go() throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(false);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new FileInputStream(sourceFileName));

    ValueSet vs = new ValueSet();
    vs.setUrl("http://hl7.org/fhir/sid/icpc2/vs");
    Element title = XMLUtil.getNamedChild(doc.getDocumentElement(), "Title");
    vs.setVersion(title.getAttribute("version"));
    vs.setName(title.getAttribute("name"));
    vs.setImmutable(true);
    Element identifier = XMLUtil.getNamedChild(doc.getDocumentElement(), "Identifier");
    vs.setPublisher(identifier.getAttribute("authority"));
    vs.setIdentifier(new Identifier().setValue(identifier.getAttribute("uid")));
    List<Element> authors = new ArrayList<Element>(); 
    XMLUtil.getNamedChildren(XMLUtil.getNamedChild(doc.getDocumentElement(), "Authors"), "Author", authors);
    for (Element a : authors)
      if (!a.getAttribute("name").contains("+"))
        vs.addContact().setName(a.getTextContent());
    vs.setCopyright("The copyright of ICPC, both in hard copy and in electronic form, is owned by Wonca. See http://www.kith.no/templates/kith_WebPage____1110.aspx");
    vs.setStatus(ConformanceResourceStatus.ACTIVE);
    vs.setDateElement(new DateTimeType(title.getAttribute("date")));
    
    vs.getCompose().addInclude().setSystem("http://hl7.org/fhir/sid/icpc2");
    CodeSystem cs = new CodeSystem();
    cs.setUrl("http://hl7.org/fhir/sid/icpc2");
    cs.setVersion(title.getAttribute("version"));
    cs.setName(title.getAttribute("name"));
    identifier = XMLUtil.getNamedChild(doc.getDocumentElement(), "Identifier");
    cs.setPublisher(identifier.getAttribute("authority"));
    cs.setIdentifier(new Identifier().setValue(identifier.getAttribute("uid")));
    authors = new ArrayList<Element>(); 
    XMLUtil.getNamedChildren(XMLUtil.getNamedChild(doc.getDocumentElement(), "Authors"), "Author", authors);
    for (Element a : authors)
      if (!a.getAttribute("name").contains("+"))
        cs.addContact().setName(a.getTextContent());
    cs.setCopyright("The copyright of ICPC, both in hard copy and in electronic form, is owned by Wonca. See http://www.kith.no/templates/kith_WebPage____1110.aspx");
    cs.setStatus(ConformanceResourceStatus.ACTIVE);
    cs.setDateElement(new DateTimeType(title.getAttribute("date")));
    cs.setValueSet(vs.getUrl());
    
    Map<String, ConceptDefinitionComponent> concepts = new HashMap<String, ConceptDefinitionComponent>();
    List<Element> classes = new ArrayList<Element>(); 
    XMLUtil.getNamedChildren(doc.getDocumentElement(), "Class", classes);
    for (Element cls : classes) {
      processClass(cls, concepts, cs);
    }
    
    XmlParser xml = new XmlParser();
    xml.setOutputStyle(OutputStyle.PRETTY);
    xml.compose(new FileOutputStream(targetFileNameVS), vs);
    xml.compose(new FileOutputStream(targetFileNameCS), cs);
  }
  
  private void processClass(Element cls, Map<String, ConceptDefinitionComponent> concepts, CodeSystem define) {
    ConceptDefinitionComponent concept = new ConceptDefinitionComponent();
    concept.setCode(cls.getAttribute("code"));
    concept.setDefinition(getRubric(cls, "preferred"));
    String s = getRubric(cls, "shortTitle");
    if (s != null && !s.equals(concept.getDefinition()))
      concept.addDesignation().setUse(new Coding().setSystem("http://hl7.org/fhir/sid/icpc2/rubrics").setCode("shortTitle")).setValue(s);
    s = getRubric(cls, "inclusion");
    if (s != null)
      concept.addDesignation().setUse(new Coding().setSystem("http://hl7.org/fhir/sid/icpc2/rubrics").setCode("inclusion")).setValue(s);
    s = getRubric(cls, "exclusion");
    if (s != null)
      concept.addDesignation().setUse(new Coding().setSystem("http://hl7.org/fhir/sid/icpc2/rubrics").setCode("exclusion")).setValue(s);
    s = getRubric(cls, "criteria");
    if (s != null)
      concept.addDesignation().setUse(new Coding().setSystem("http://hl7.org/fhir/sid/icpc2/rubrics").setCode("criteria")).setValue(s);
    s = getRubric(cls, "consider");
    if (s != null)
      concept.addDesignation().setUse(new Coding().setSystem("http://hl7.org/fhir/sid/icpc2/rubrics").setCode("consider")).setValue(s);
    s = getRubric(cls, "note");
    if (s != null)
      concept.addDesignation().setUse(new Coding().setSystem("http://hl7.org/fhir/sid/icpc2/rubrics").setCode("note")).setValue(s);
    
    concepts.put(concept.getCode(), concept);
    List<Element> children = new ArrayList<Element>(); 
    XMLUtil.getNamedChildren(cls, "SubClass", children);
    if (children.size() > 0)
      CodeSystemUtilities.setAbstract(define, concept);
    
    Element parent = XMLUtil.getNamedChild(cls, "SuperClass");
    if (parent == null) {
      define.addConcept(concept);
    } else {
      ConceptDefinitionComponent p = concepts.get(parent.getAttribute("code"));
      p.getConcept().add(concept);
    }
  }
  
  private String getRubric(Element cls, String kind) {
    List<Element> rubrics = new ArrayList<Element>(); 
    XMLUtil.getNamedChildren(cls, "Rubric", rubrics);
    for (Element r : rubrics) {
      if (r.getAttribute("kind").equals(kind))
        return XMLUtil.getNamedChild(r,  "Label").getTextContent();
    }
    return null;
  }
  
}