package org.hl7.fhir.r5.utils;

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


// todo:
// - generate sort order parameters
// - generate inherited search parameters

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.SearchParamType;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public class GraphQLSchemaGenerator {

  private static final Set<String> JSON_NUMBER_TYPES = new HashSet<String>() {{
    add("decimal");
    add("positiveInt");
    add("unsignedInt");
  }};
  private final ProfileUtilities profileUtilities;
  private final String version;
  IWorkerContext context;

  public GraphQLSchemaGenerator(IWorkerContext context, String version) {
    super();
    this.context = context;
    this.version = version;
    profileUtilities = new ProfileUtilities(context, null, null);
  }

  public void generateTypes(OutputStream stream) throws IOException, FHIRException {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
    generateTypes(writer);
    writer.flush();
    writer.close();
  }

  public void generateTypes(Writer writer) throws IOException {
    EnumSet<FHIROperationType> operations = EnumSet.allOf(FHIROperationType.class);
    generateTypes(writer, operations);
  }

  public void generateTypes(Writer writer, EnumSet<FHIROperationType> operations) throws IOException {
    Map<String, StructureDefinition> pl = new HashMap<>();
    Map<String, StructureDefinition> tl = new HashMap<>();
    Map<String, String> existingTypeNames = new HashMap<>();
    for (StructureDefinition sd : context.allStructures()) {
      if (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        pl.put(sd.getName(), sd);
      }
      if (sd.getKind() == StructureDefinitionKind.COMPLEXTYPE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        tl.put(sd.getName(), sd);
      }
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() != TypeDerivationRule.CONSTRAINT && sd.getAbstract()) {
        tl.put(sd.getName(), sd);
      }
    }
    writer.write("# FHIR GraphQL Schema. Version " + version + "\r\n\r\n");
    writer.write("# FHIR Defined Primitive types\r\n");
    for (String n : sorted(pl.keySet()))
      generatePrimitive(writer, pl.get(n));
    writer.write("\r\n");
    writer.write("# FHIR Defined Search Parameter Types\r\n");
    for (SearchParamType dir : SearchParamType.values()) {
      if (pl.containsKey(dir.toCode())) {
        // Don't double create String and URI
        continue;
      }
      if (dir != SearchParamType.NULL)
        generateSearchParamType(writer, dir.toCode());
    }
    writer.write("\r\n");
    generateElementBase(writer, operations);
    for (String n : sorted(tl.keySet())) {
      generateType(existingTypeNames, writer, tl.get(n), operations);
    }
  }

  public void generateResource(OutputStream stream, StructureDefinition sd, List<SearchParameter> parameters, EnumSet<FHIROperationType> operations) throws IOException, FHIRException {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
    generateResource(writer, sd, parameters, operations);
    writer.flush();
    writer.close();
  }

  public void generateResource(Writer writer, StructureDefinition sd, List<SearchParameter> parameters, EnumSet<FHIROperationType> operations) throws IOException {
    Map<String, String> existingTypeNames = new HashMap<>();

    writer.write("# FHIR GraphQL Schema. Version " + version + "\r\n\r\n");
    writer.write("# import * from 'types.graphql'\r\n\r\n");

    generateType(existingTypeNames, writer, sd, operations);
    if (operations.contains(FHIROperationType.READ))
      generateIdAccess(writer, sd.getName());
    if (operations.contains(FHIROperationType.SEARCH)) {
      generateListAccess(writer, parameters, sd.getName());
      generateConnectionAccess(writer, parameters, sd.getName());
    }
    if (operations.contains(FHIROperationType.CREATE))
      generateCreate(writer, sd.getName());
    if (operations.contains(FHIROperationType.UPDATE))
      generateUpdate(writer, sd.getName());
    if (operations.contains(FHIROperationType.DELETE))
      generateDelete(writer, sd.getName());
  }

  private void generateCreate(Writer writer, String name) throws IOException {
    writer.write("type " + name + "CreateType {\r\n");
    writer.write("  " + name + "Create(");
    param(writer, "resource", name + "Input", false, false);
    writer.write("): " + name + "Creation\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
    writer.write("type " + name + "Creation {\r\n");
    writer.write("  location: String\r\n");
    writer.write("  resource: " + name + "\r\n");
    writer.write("  information: OperationOutcome\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
  }

  private void generateUpdate(Writer writer, String name) throws IOException {
    writer.write("type " + name + "UpdateType {\r\n");
    writer.write("  " + name + "Update(");
    param(writer, "id", "ID", false, false);
    writer.write(", ");
    param(writer, "resource", name + "Input", false, false);
    writer.write("): " + name + "Update\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
    writer.write("type " + name + "Update {\r\n");
    writer.write("  resource: " + name + "\r\n");
    writer.write("  information: OperationOutcome\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
  }

  private void generateDelete(Writer writer, String name) throws IOException {
    writer.write("type " + name + "DeleteType {\r\n");
    writer.write("  " + name + "Delete(");
    param(writer, "id", "ID", false, false);
    writer.write("): " + name + "Delete\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
    writer.write("type " + name + "Delete {\r\n");
    writer.write("  information: OperationOutcome\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
  }

  private void generateListAccess(Writer writer, List<SearchParameter> parameters, String name) throws IOException {
    writer.write("type " + name + "ListType {\r\n");
    writer.write("  ");
    generateListAccessQuery(writer, parameters, name);
    writer.write("}\r\n");
    writer.write("\r\n");
  }

  public void generateListAccessQuery(Writer writer, List<SearchParameter> parameters, String name) throws IOException {
    writer.write(name + "List(");
    param(writer, "_filter", "String", false, false);
    for (SearchParameter sp : parameters)
      param(writer, sp.getName().replace("-", "_"), getGqlname(requireNonNull(sp.getType().toCode())), true, true);
    param(writer, "_sort", "String", false, true);
    param(writer, "_count", "Int", false, true);
    param(writer, "_cursor", "String", false, true);
    writer.write("): [" + name + "]\r\n");
  }

  private void param(Writer writer, String name, String type, boolean list, boolean line) throws IOException {
    if (line)
      writer.write("\r\n    ");
    writer.write(name);
    writer.write(": ");
    if (list)
      writer.write("[");
    writer.write(type);
    if (list)
      writer.write("]");
  }

  private void generateConnectionAccess(Writer writer, List<SearchParameter> parameters, String name) throws IOException {
    writer.write("type " + name + "ConnectionType {\r\n");
    writer.write("  ");
    generateConnectionAccessQuery(writer, parameters, name);
    writer.write("}\r\n");
    writer.write("\r\n");
    writer.write("type " + name + "Connection {\r\n");
    writer.write("  count: Int\r\n");
    writer.write("  offset: Int\r\n");
    writer.write("  pagesize: Int\r\n");
    writer.write("  first: ID\r\n");
    writer.write("  previous: ID\r\n");
    writer.write("  next: ID\r\n");
    writer.write("  last: ID\r\n");
    writer.write("  edges: [" + name + "Edge]\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
    writer.write("type " + name + "Edge {\r\n");
    writer.write("  mode: String\r\n");
    writer.write("  score: Float\r\n");
    writer.write("  resource: " + name + "\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
  }

  public void generateConnectionAccessQuery(Writer writer, List<SearchParameter> parameters, String name) throws IOException {
    writer.write(name + "Conection(");
    param(writer, "_filter", "String", false, false);
    for (SearchParameter sp : parameters)
      param(writer, sp.getName().replace("-", "_"), getGqlname(requireNonNull(sp.getType().toCode())), true, true);
    param(writer, "_sort", "String", false, true);
    param(writer, "_count", "Int", false, true);
    param(writer, "_cursor", "String", false, true);
    writer.write("): " + name + "Connection\r\n");
  }

  private void generateIdAccess(Writer writer, String name) throws IOException {
    writer.write("type " + name + "ReadType {\r\n");
    writer.write("  " + name + "(id: ID!): " + name + "\r\n");
    writer.write("}\r\n");
    writer.write("\r\n");
  }

  private void generateElementBase(Writer writer, EnumSet<FHIROperationType> operations) throws IOException {
    if (operations.contains(FHIROperationType.READ) || operations.contains(FHIROperationType.SEARCH)) {
      writer.write("type ElementBase {\r\n");
      writer.write("  id: ID\r\n");
      writer.write("  extension: [Extension]\r\n");
      writer.write("}\r\n");
      writer.write("\r\n");
    }

    if (operations.contains(FHIROperationType.CREATE) || operations.contains(FHIROperationType.UPDATE)) {
      writer.write("input ElementBaseInput {\r\n");
      writer.write("  id : ID\r\n");
      writer.write("  extension: [ExtensionInput]\r\n");
      writer.write("}\r\n");
      writer.write("\r\n");
    }
  }

  private void generateType(Map<String, String> existingTypeNames, Writer writer, StructureDefinition sd, EnumSet<FHIROperationType> operations) throws IOException {
    if (operations.contains(FHIROperationType.READ) || operations.contains(FHIROperationType.SEARCH)) {
      List<StringBuilder> list = new ArrayList<>();
      StringBuilder b = new StringBuilder();
      list.add(b);
      b.append("type ");
      b.append(sd.getName());
      StructureDefinition sdp = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      if (sdp != null) {
        b.append(" implements ");
        b.append(sdp.getType());
      }
      b.append(" {\r\n");
      ElementDefinition ed = sd.getSnapshot().getElementFirstRep();
      generateProperties(existingTypeNames, list, b, sd.getName(), sd, ed, "type", "");
      b.append("}");
      b.append("\r\n");
      b.append("\r\n");
      for (StringBuilder bs : list) {
        writer.write(bs.toString());
      }
      list.clear();
    }

    if (operations.contains(FHIROperationType.CREATE) || operations.contains(FHIROperationType.UPDATE)) {
      List<StringBuilder> list = new ArrayList<>();
      StringBuilder b = new StringBuilder();
      list.add(b);
      b.append("input ");
      b.append(sd.getName());
      b.append("Input {\r\n");
      ElementDefinition ed = sd.getSnapshot().getElementFirstRep();
      generateProperties(existingTypeNames, list, b, sd.getName(), sd, ed, "input", "Input");
      b.append("}");
      b.append("\r\n");
      b.append("\r\n");
      for (StringBuilder bs : list) {
        writer.write(bs.toString());
      }
    }

  }

  private void generateProperties(Map<String, String> existingTypeNames, List<StringBuilder> list, StringBuilder b, String typeName, StructureDefinition sd, ElementDefinition ed, String mode, String suffix) throws IOException {
    List<ElementDefinition> children = profileUtilities.getChildList(sd, ed);
    for (ElementDefinition child : children) {
      if (child.hasContentReference()) {
        ElementDefinition ref = resolveContentReference(sd, child.getContentReference());
        generateProperty(existingTypeNames, list, b, typeName, sd, child, ref.getType().get(0), false, ref, mode, suffix);
      } else if (child.getType().size() == 1) {
        generateProperty(existingTypeNames, list, b, typeName, sd, child, child.getType().get(0), false, null, mode, suffix);
      } else {
        boolean ref = false;
        for (TypeRefComponent t : child.getType()) {
          if (!t.hasTarget())
            generateProperty(existingTypeNames, list, b, typeName, sd, child, t, true, null, mode, suffix);
          else if (!ref) {
            ref = true;
            generateProperty(existingTypeNames, list, b, typeName, sd, child, t, true, null, mode, suffix);
          }
        }
      }
    }
  }

  private ElementDefinition resolveContentReference(StructureDefinition sd, String contentReference) {
    String id = contentReference.substring(1);
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (id.equals(ed.getId()))
        return ed;
    }
    throw new Error("Unable to find " + id);
  }

  private void generateProperty(Map<String, String> existingTypeNames, List<StringBuilder> list, StringBuilder b, String typeName, StructureDefinition sd, ElementDefinition child, TypeRefComponent typeDetails, boolean suffix, ElementDefinition cr, String mode, String suffixS) throws IOException {
    if (isPrimitive(typeDetails)) {
      String n = getGqlname(typeDetails.getWorkingCode());
      b.append("  ");
      b.append(tail(child.getPath(), suffix));
      if (suffix)
        b.append(Utilities.capitalize(typeDetails.getWorkingCode()));
      b.append(": ");
      if (!child.getMax().equals("1")) {
        b.append("[");
        b.append(n);
        b.append("]");
      } else {
        b.append(n);
      }
      if (!child.getPath().endsWith(".id")) {
        b.append("  _");
        b.append(tail(child.getPath(), suffix));
        if (suffix)
          b.append(Utilities.capitalize(typeDetails.getWorkingCode()));
        if (!child.getMax().equals("1")) {
          b.append(": [ElementBase");
          b.append(suffixS);
          b.append("]\r\n");
        } else {
          b.append(": ElementBase");
          b.append(suffixS);
          b.append("\r\n");
        }
      } else
        b.append("\r\n");
    } else {
      b.append("  ");
      b.append(tail(child.getPath(), suffix));
      if (suffix)
        b.append(Utilities.capitalize(typeDetails.getWorkingCode()));
      b.append(": ");
      if (!child.getMax().equals("1"))
        b.append("[");
      String type = typeDetails.getWorkingCode();
      if (cr != null)
        b.append(generateInnerType(existingTypeNames, list, sd, typeName, cr, mode, suffixS));
      else if (Utilities.existsInList(type, "Element", "BackboneElement"))
        b.append(generateInnerType(existingTypeNames, list, sd, typeName, child, mode, suffixS));
      else
        b.append(type).append(suffixS);
      if (!child.getMax().equals("1"))
        b.append("]");
      if (child.getMin() != 0 && !suffix)
        b.append("!");
      b.append("\r\n");
    }
  }

  private String generateInnerType(Map<String, String> existingTypeNames, List<StringBuilder> list, StructureDefinition sd, String name, ElementDefinition child, String mode, String suffix) throws IOException {
    String key = child.getName() + "." + mode;
    if (existingTypeNames.containsKey(key)) {
      return existingTypeNames.get(key);
    }

    String typeName = name + Utilities.capitalize(tail(child.getPath(), false)) + suffix;
    existingTypeNames.put(key, typeName + suffix);

    StringBuilder b = new StringBuilder();
    list.add(b);
    b.append(mode);
    b.append(" ");
    b.append(typeName);
    b.append(suffix);
    b.append(" {\r\n");
    generateProperties(existingTypeNames, list, b, typeName, sd, child, mode, suffix);
    b.append("}");
    b.append("\r\n");
    b.append("\r\n");
    return typeName + suffix;
  }

  private String tail(String path, boolean suffix) {
    if (suffix)
      path = path.substring(0, path.length() - 3);
    int i = path.lastIndexOf(".");
    return i < 0 ? path : path.substring(i + 1);
  }

  private boolean isPrimitive(TypeRefComponent type) {
    String typeName = type.getWorkingCode();
    StructureDefinition sd = context.fetchTypeDefinition(typeName);
    if (sd == null)
      return false;
    return sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
  }

  private List<String> sorted(Set<String> keys) {
    List<String> sl = new ArrayList<>(keys);
    Collections.sort(sl);
    return sl;
  }

  private void generatePrimitive(Writer writer, StructureDefinition sd) throws IOException, FHIRException {
    String gqlName = getGqlname(sd.getName());
    if (gqlName.equals(sd.getName())) {
      writer.write("scalar ");
      writer.write(sd.getName());
      writer.write(" # JSON Format: ");
      writer.write(getJsonFormat(sd));
    } else {
      writer.write("# Type ");
      writer.write(sd.getName());
      writer.write(": use GraphQL Scalar type ");
      writer.write(gqlName);
    }
    writer.write("\r\n");
  }

  private void generateSearchParamType(Writer writer, String name) throws IOException, FHIRException {
    String gqlName = getGqlname(name);
    if (gqlName.equals("date")) {
      writer.write("# Search Param ");
      writer.write(name);
      writer.write(": already defined as Primitive with JSON Format: string ");
    } else if (gqlName.equals(name)) {
      writer.write("scalar ");
      writer.write(name);
      writer.write(" # JSON Format: string");
    } else {
      writer.write("# Search Param ");
      writer.write(name);
      writer.write(": use GraphQL Scalar type ");
      writer.write(gqlName);
    }
    writer.write("\r\n");
  }

  private String getJsonFormat(StructureDefinition sd) throws FHIRException {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (!ed.getType().isEmpty() && ed.getType().get(0).getCodeElement().hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-json-type"))
        return ed.getType().get(0).getCodeElement().getExtensionString(" http://hl7.org/fhir/StructureDefinition/structuredefinition-json-type");
    }
    // all primitives but JSON_NUMBER_TYPES are represented as JSON strings
    if (JSON_NUMBER_TYPES.contains(sd.getName())) {
      return "number";
    } else {
      return "string";
    }
  }

  private String getGqlname(String name) {
    if (name.equals("string"))
      return "String";
    if (name.equals("integer"))
      return "Int";
    if (name.equals("boolean"))
      return "Boolean";
    if (name.equals("id"))
      return "ID";
    return name;
  }

  public enum FHIROperationType {READ, SEARCH, CREATE, UPDATE, DELETE}
}