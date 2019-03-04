package org.hl7.fhir.r5.elementmodel;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.Type;


public class ObjectConverter  {

  private IWorkerContext context;

  public ObjectConverter(IWorkerContext context) {
    this.context = context;
  }

  public Element convert(Resource ig) throws IOException, FHIRException {
    if (ig == null)
      return null;
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    org.hl7.fhir.r5.formats.JsonParser jp = new org.hl7.fhir.r5.formats.JsonParser();
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
      return new org.hl7.fhir.r5.formats.JsonParser().parse(bo.toByteArray());
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
