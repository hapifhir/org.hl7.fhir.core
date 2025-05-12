package org.hl7.fhir.convertors.misc.iso21090;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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


import org.hl7.fhir.dstu3.context.IWorkerContext;
import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.XmlParser;
import org.hl7.fhir.dstu3.model.ElementDefinition;
import org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation;
import org.hl7.fhir.dstu3.model.Enumerations.BindingStrength;
import org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus;
import org.hl7.fhir.dstu3.model.StructureDefinition;
import org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.dstu3.model.ValueSet;
import org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.dstu3.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ISO21090Importer {

  private final Map<String, EnumValueSet> bindings = new HashMap<>();
  private final Map<String, DataType> types = new HashMap<>();
  private IWorkerContext ctxt;
  private Element schema;

  public static void main(String[] args) throws Exception {
    new ISO21090Importer().process();
  }

  private void process() throws Exception {
    ctxt = SimpleWorkerContext.fromPack("C:\\work\\org.hl7.fhir\\build\\publish\\igpack.zip");
    load();
    processEnums();
    processDataTypes();
    generate();

    System.out.print("done");
  }

  private void generate() throws Exception {
    for (EnumValueSet evs : bindings.values()) {
      generateValueSet(evs);
    }
    for (DataType dt : types.values()) {
      generateType(dt);
    }
  }

  private void generateType(DataType dt) throws Exception {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(dt.getName());
    sd.setUrl("http://hl7.org/fhir/iso21090/StructureDefinition/" + sd.getId());
    sd.setName(dt.getName() + " data type");
    sd.setStatus(PublicationStatus.ACTIVE);
    sd.setExperimental(false);
    sd.setPublisher("HL7 / ISO");
    sd.setDate(new Date());
    sd.setDescription(dt.getDoco());
    sd.setKind(StructureDefinitionKind.LOGICAL);
    sd.setAbstract(Utilities.existsInList(dt.getName(), "HXIT", "QTY"));
    sd.setType("Element");
    if (dt.getParent() == null)
      sd.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Element");
    else
      sd.setBaseDefinition("http://hl7.org/fhir/iso21090/StructureDefinition/" + dt.getParent());
    sd.setDerivation(TypeDerivationRule.SPECIALIZATION);
    ElementDefinition ed = sd.getDifferential().addElement();
    ed.setPath(dt.getName());
    produceProperties(sd.getDifferential().getElement(), dt.getName(), dt.getProperties(), true, false);
    produceProperties(sd.getDifferential().getElement(), dt.getName(), dt.getProperties(), false, false);
    ed = sd.getSnapshot().addElement();
    ed.setPath(dt.getName());
    if (dt.getParent() != null)
      addParentProperties(sd.getSnapshot().getElement(), dt.getName(), dt.getParent(), true, true);
    produceProperties(sd.getSnapshot().getElement(), dt.getName(), dt.getProperties(), true, true);
    if (dt.getParent() != null)
      addParentProperties(sd.getSnapshot().getElement(), dt.getName(), dt.getParent(), false, true);
    produceProperties(sd.getSnapshot().getElement(), dt.getName(), dt.getProperties(), false, true);
    ed.getBase().setPath(ed.getPath()).setMin(ed.getMin()).setMax(ed.getMax());
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path("[tmp]", "iso21090\\StructureDefinition-" + dt.getName() + ".xml")), sd);
  }

  private void addParentProperties(List<ElementDefinition> elements, String name, String parent, boolean attrMode, boolean snapshot) throws FHIRFormatError {
    DataType dt = types.get(parent);
    if (dt == null)
      throw new Error("No find " + parent);
    if (dt.getParent() != null)
      addParentProperties(elements, name, dt.getParent(), attrMode, snapshot);
    produceProperties(elements, name, dt.getProperties(), attrMode, snapshot);
  }

  private void produceProperties(List<ElementDefinition> elements, String name, List<Property> properties, boolean attrMode, boolean snapshot) throws FHIRFormatError {
    for (Property p : properties) {
      if (p.isIsattr() == attrMode) {
        ElementDefinition ed = new ElementDefinition();
        elements.add(ed);
        ed.setPath(name + "." + p.getName());
        if (p.getType().startsWith("xsd:"))
          ToolingExtensions.addStringExtension(ed.addType(), ToolingExtensions.EXT_XML_TYPE, p.getType());
        else
          ed.addType().setCode(p.getType());
        ed.setMin(p.getMin());
        ed.setMax(p.getMax() == Integer.MAX_VALUE ? "*" : Integer.toString(p.getMax()));
        ed.setDefinition(p.getDoco());
        if (p.isIsattr())
          ed.addRepresentation(PropertyRepresentation.XMLATTR);
        if (p.getBinding() != null)
          ed.getBinding().setStrength(BindingStrength.REQUIRED).setValueSet(new UriType("http://hl7.org/fhir/iso21090/ValueSet/" + p.getBinding()));
        if (snapshot)
          ed.getBase().setPath(ed.getPath()).setMin(ed.getMin()).setMax(ed.getMax());
      }
    }
  }

  private void generateValueSet(EnumValueSet evs) throws Exception {
    ValueSet bvs = ctxt.fetchResource(ValueSet.class, evs.getTemplate());
    if (bvs == null)
      throw new Exception("Did not find template value set " + evs.getTemplate());
    ValueSet vs = bvs.copy();
    vs.getCompose().getInclude().clear();
    vs.getIdentifier().clear();
    vs.setName("ISO 20190 " + evs.getName() + " Enumeration");
    vs.setId(evs.getName());
    vs.setUrl("http://hl7.org/fhir/iso21090/ValueSet/" + vs.getId());
    vs.setDate(new Date());
    vs.setExperimental(false);
    ConceptSetComponent inc = vs.getCompose().addInclude().setSystem(evs.getSystem());
    for (String code : evs.getCodes()) {
      inc.addConcept().setCode(code);
    }
    new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path("[tmp]", "iso21090\\ValueSet-" + evs.getName() + ".xml")), vs);
  }

  private void processDataTypes() {
    Element type = XMLUtil.getFirstChild(schema);
    while (type != null) {
      if (type.getTagName().equals("xsd:complexType")) {
        String n = type.getAttribute("name");
        if (!(n.contains(".") || n.contains("_") || n.equals("XReference")))
          processDataType(n, type);
      }
      type = XMLUtil.getNextSibling(type);
    }
  }

  private void processDataType(String n, Element type) {
    DataType dt = new DataType();
    types.put(n, dt);
    dt.setName(n);
    dt.setDoco(getDoco(type));
    Element cnt;
    Element ext = XMLUtil.getNamedChild(XMLUtil.getNamedChild(type, "xsd:complexContent"), "xsd:extension");
    if (ext != null) {
      dt.setParent(ext.getAttribute("base"));
      cnt = XMLUtil.getFirstChild(ext);
    } else {
      cnt = XMLUtil.getFirstChild(type);
    }
    if (cnt.getTagName().equals("xsd:annotation"))
      cnt = XMLUtil.getNextSibling(cnt);
    System.out.println(n + " (" + dt.getParent() + ")");
    while (cnt != null) {
      if (cnt.getTagName().equals("xsd:attribute")) {
        processAttribute(dt, cnt);
      } else if (cnt.getTagName().equals("xsd:sequence")) {
        Element e = XMLUtil.getFirstChild(cnt);
        while (e != null) {
          if (e.getTagName().equals("xsd:element")) {
            processElement(dt, e);
          } else
            System.out.println("2. ignore " + e.getTagName());

          e = XMLUtil.getNextSibling(e);
        }
      } else
        System.out.println("ignore " + cnt.getTagName());
      cnt = XMLUtil.getNextSibling(cnt);
    }
  }

  private void processElement(DataType dt, Element elem) {
    Property prop = new Property();
    prop.setName(elem.getAttribute("name"));
    prop.setMin(Integer.parseInt(elem.getAttribute("minOccurs")));
    prop.setMax("unbounded".equals(elem.getAttribute("maxOccurs")) ? Integer.MAX_VALUE : Integer.parseInt(elem.getAttribute("maxOccurs")));
    prop.setType(elem.getAttribute("type"));
    prop.setDoco(getDoco(elem));
    dt.getProperties().add(prop);
    System.out.println("  " + prop.getName() + " : " + prop.getType() + " [" + prop.getMin() + ".." + prop.getMax() + "]");
  }

  private void processAttribute(DataType dt, Element attr) {
    Property prop = new Property();
    prop.setName(attr.getAttribute("name"));
    prop.setType(attr.getAttribute("type"));
    if (!prop.getType().startsWith("xsd:")) {
      if (Utilities.noString(prop.getType()))
        prop.setType("xsd:string");
      else if (bindings.containsKey(prop.getType())) {
        prop.setBinding(prop.getType());
        prop.setType("xsd:string");
      } else if (prop.getType().startsWith("set_") && bindings.containsKey(prop.getType().substring(4))) {
        prop.setBinding(prop.getType().substring(4));
        prop.setType("xsd:string");
        prop.setMax(Integer.MAX_VALUE);
      } else if ("Uid".equals(prop.getType()))
        prop.setType("xsd:string");
      else if ("Code".equals(prop.getType()))
        prop.setType("xsd:token");
      else if ("Decimal".equals(prop.getType()))
        prop.setType("xsd:decimal");
      else
        throw new Error("Unknown type " + prop.getType() + " on " + dt.getName() + "." + prop.getName());
    }
    prop.setMin("optional".equals(attr.getAttribute("use")) ? 0 : 1);
    prop.setMax(1);
    prop.setDoco(getDoco(attr));
    prop.setIsattr(true);
    dt.getProperties().add(prop);
    System.out.println("  " + prop.getName() + " : " + prop.getType() + " [" + prop.getMin() + ".." + prop.getMax() + "]");
  }

  private void processEnums() {
    Element type = XMLUtil.getFirstChild(schema);
    while (type != null) {
      if (type.getTagName().equals("xsd:simpleType")) {
        Element res = XMLUtil.getFirstChild(type);
        Element en = XMLUtil.getFirstChild(res);
        if (en != null && en.getTagName().equals("xsd:enumeration") && !type.getAttribute("name").contains("."))
          processEnum(type.getAttribute("name"), en);
      }
      type = XMLUtil.getNextSibling(type);
    }
  }

  private void processEnum(String n, Element en) {
    EnumValueSet vs = new EnumValueSet();
    bindings.put(n, vs);
    vs.setName(n);
    String v3n;
    if (n.contains("EntityName"))
      v3n = n + "R2";
    else if (n.equals("Compression"))
      v3n = "CompressionAlgorithm";
    else if (n.equals("UpdateMode"))
      v3n = "HL7UpdateMode";
    else if (n.equals("UncertaintyType"))
      v3n = "ProbabilityDistributionType";
    else if (n.equals("TelecommunicationAddressUse") || n.equals("PostalAddressUse"))
      v3n = "AddressUse";
    else if (n.equals("TelecommunicationCapability"))
      v3n = "TelecommunicationCapabilities";
    else
      v3n = n;
    vs.setSystem("http://hl7.org/fhir/v3-" + v3n);
    vs.setTemplate("http://hl7.org/fhir/ValueSet/v3-" + v3n);
    System.out.println("Enum: " + n + " == " + vs.getSystem());
    while (en != null) {
      vs.getCodes().add(en.getAttribute("value"));
      vs.getMembers().put(en.getAttribute("value"), getDoco(en));
      en = XMLUtil.getNextSibling(en);
    }
  }

  private String getDoco(Element en) {
    Element doco = XMLUtil.getNamedChild(XMLUtil.getNamedChild(en, "xsd:annotation"), "xsd:documentation");
    return doco == null ? null : doco.getTextContent();
  }

  private void load() throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
    factory.setNamespaceAware(false);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(ManagedFileAccess.inStream("C:\\work\\projects\\org.hl7.v3.dt\\iso\\iso-21090-datatypes.xsd"));
    schema = doc.getDocumentElement();
  }

}