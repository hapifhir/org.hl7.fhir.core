package org.hl7.fhir.r4.elementmodel;

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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.Factory;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.Type;


public class ObjectConverter  {

  private IWorkerContext context;

  public ObjectConverter(IWorkerContext context) {
    this.context = context;
  }

  public Element convert(Resource ig) throws IOException, FHIRException {
    if (ig == null)
      return null;
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    org.hl7.fhir.r4.formats.JsonParser jp = new org.hl7.fhir.r4.formats.JsonParser();
    jp.compose(bs, ig);
    ByteArrayInputStream bi = new ByteArrayInputStream(bs.toByteArray());
    return new JsonParser(context).parse(bi);
  }

  public Element convert(Property property, Type type) throws FHIRException {
    return convertElement(property, type);
  }
  
  private Element convertElement(Property property, Base base) throws FHIRException {
    if (base == null)
      return null;
    String tn = base.fhirType();
    StructureDefinition sd = context.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(tn, context.getOverrideVersionNs()));
    if (sd == null)
      throw new FHIRException("Unable to find definition for type "+tn);
    Element res = new Element(property.getName(), property);
    if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE) 
      res.setValue(((PrimitiveType) base).asStringValue());

    List<ElementDefinition> children = ProfileUtilities.getChildMap(sd, sd.getSnapshot().getElementFirstRep()); 
    for (ElementDefinition child : children) {
      String n = tail(child.getPath());
      if (sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE || !"value".equals(n)) {
        Base[] values = base.getProperty(n.hashCode(), n, false);
        if (values != null)
          for (Base value : values) {
            res.getChildren().add(convertElement(new Property(context, child, sd), value));
          }
      }
    }
    return res;
  }

  private String tail(String path) {
    if (path.contains("."))
      return path.substring(path.lastIndexOf('.')+1);
    else
      return path;
  }

  public Type convertToType(Element element) throws FHIRException {
    Type b = new Factory().create(element.fhirType());
    if (b instanceof PrimitiveType) {
      ((PrimitiveType) b).setValueAsString(element.primitiveValue());
    } else {
      for (Element child : element.getChildren()) {
        b.setProperty(child.getName(), convertToType(child));
      }
    }
    return b;
  }

  public Resource convert(Element element) throws FHIRException {
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    try {
      new JsonParser(context).compose(element, bo, OutputStyle.NORMAL, null);
//      TextFile.bytesToFile(bo.toByteArray(), "c:\\temp\\json.json");
      return new org.hl7.fhir.r4.formats.JsonParser().parse(bo.toByteArray());
    } catch (IOException e) {
      // won't happen
      throw new FHIRException(e);
    }
    
  }

  public static CodeableConcept readAsCodeableConcept(Element element) {
    CodeableConcept cc = new CodeableConcept();
    List<Element> list = new ArrayList<Element>();
    element.getNamedChildren("coding", list);
    for (Element item : list)
      cc.addCoding(readAsCoding(item));
    cc.setText(element.getNamedChildValue("text"));
    return cc;
  }

  public static Coding readAsCoding(Element item) {
    Coding c = new Coding();
    c.setSystem(item.getNamedChildValue("system"));
    c.setVersion(item.getNamedChildValue("version"));
    c.setCode(item.getNamedChildValue("code"));
    c.setDisplay(item.getNamedChildValue("display"));
    return c;
  }

  public static Identifier readAsIdentifier(Element item) {
    Identifier r = new Identifier();
    r.setSystem(item.getNamedChildValue("system"));
    r.setValue(item.getNamedChildValue("value"));
    return r;
  }

  public static Reference readAsReference(Element item) {
    Reference r = new Reference();
    r.setDisplay(item.getNamedChildValue("display"));
    r.setReference(item.getNamedChildValue("reference"));
    r.setType(item.getNamedChildValue("type"));
    List<Element> identifier = item.getChildrenByName("identifier");
    if (identifier.isEmpty() == false) {
      r.setIdentifier(readAsIdentifier(identifier.get(0)));
    }
    return r;
  }

}