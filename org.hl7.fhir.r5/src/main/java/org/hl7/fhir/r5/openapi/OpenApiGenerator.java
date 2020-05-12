package org.hl7.fhir.r5.openapi;

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


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy;
import org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.Enumerations.SearchParamType;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.openapi.ParameterWriter.ParameterLocation;
import org.hl7.fhir.r5.openapi.ParameterWriter.ParameterStyle;
import org.hl7.fhir.r5.openapi.SchemaWriter.SchemaType;
import org.hl7.fhir.utilities.Utilities;


public class OpenApiGenerator {

  private IWorkerContext context;
  private CapabilityStatement source;
  private Writer dest;

  public OpenApiGenerator(IWorkerContext context, CapabilityStatement cs, Writer oa) {
    this.context = context;
    this.source = cs;
    this.dest = oa;
  }

  public void generate(String license, String url) {
    dest.info().title(source.present()).description(source.getDescription()).license(license, url).version(source.getVersion());
    for (ContactDetail cd : source.getContact()) {
      dest.info().contact(cd.getName(), email(cd.getTelecom()), url(cd.getTelecom()));
    }
    if (source.hasPublisher())
      dest.info().contact(source.getPublisher(), null, null);

    if (source.hasImplementation()) {
      dest.server(source.getImplementation().getUrl()).description(source.getImplementation().getDescription());
    }
    dest.externalDocs().url(source.getUrl()).description("FHIR CapabilityStatement");

    for (CapabilityStatementRestComponent csr : source.getRest()) {
      if (csr.getMode() == RestfulCapabilityMode.SERVER) {
        generatePaths(csr);
      }
    }
    writeBaseParameters(dest.components());
  }

  private void writeBaseParameters(ComponentsWriter components) {
    components.parameter("rid").name("rid").in(ParameterLocation.path).description("id of the resource (=Resource.id)").required(true).allowEmptyValue(false).style(ParameterStyle.simple)
    .schema().type(SchemaType.string);
    
    components.parameter("hid").name("hid").in(ParameterLocation.path).description("id of the history entry (=Resource.meta.versionId)").required(true).allowEmptyValue(false).style(ParameterStyle.simple)
    .schema().type(SchemaType.string);

    components.parameter("summary").name("_summary").in(ParameterLocation.query).description("Requests the server to return a designated subset of the resource").allowEmptyValue().style(ParameterStyle.form)
    .schema().type(SchemaType.string).enums("true", "text", "data", "count", "false");

    components.parameter("format").name("_format").in(ParameterLocation.query).description("Specify alternative response formats by their MIME-types (when a client is unable acccess accept: header)").allowEmptyValue().style(ParameterStyle.form)
    .schema().type(SchemaType.string).format("mime-type");

    components.parameter("pretty").name("_pretty").in(ParameterLocation.query).description("Ask for a pretty printed response for human convenience").allowEmptyValue().style(ParameterStyle.form)
    .schema().type(SchemaType.bool);

    SchemaWriter p = components.parameter("elements").name("_elements").in(ParameterLocation.query).description("Requests the server to return a collection of elements from the resource").allowEmptyValue().style(ParameterStyle.form).explode(false)
    .schema();
    p.type(SchemaType.array).format("string");
    p.items().format("string");

    components.parameter("count").name("_count").in(ParameterLocation.query).description("The maximum number of search results on a page. The server is not bound to return the number requested, but cannot return more")
    .schema().type(SchemaType.number);
  }

  private void generatePaths(CapabilityStatementRestComponent csr) {
    generateMetadata();
    for (CapabilityStatementRestResourceComponent r : csr.getResource())
      generateResource(r);
    if (hasOp(csr, SystemRestfulInteraction.HISTORYSYSTEM))
      generateHistorySystem(csr);
    if (hasOp(csr, SystemRestfulInteraction.SEARCHSYSTEM))
      generateSearchSystem(csr);
    if (hasOp(csr, SystemRestfulInteraction.BATCH) || hasOp(csr, SystemRestfulInteraction.TRANSACTION) )
      generateBatchTransaction(csr);
  }

  private void generateResource(CapabilityStatementRestResourceComponent r) {
    if (hasOp(r, TypeRestfulInteraction.SEARCHTYPE)) 
      generateSearch(r);
    if (hasOp(r, TypeRestfulInteraction.READ))
      generateRead(r);
    if (hasOp(r, TypeRestfulInteraction.CREATE)) 
      generateCreate(r);
    if (hasOp(r, TypeRestfulInteraction.UPDATE)) 
      generateUpdate(r);
    if (hasOp(r, TypeRestfulInteraction.PATCH)) 
      generatePatch(r);
    if (hasOp(r, TypeRestfulInteraction.DELETE)) 
      generateDelete(r);
    if (hasOp(r, TypeRestfulInteraction.HISTORYINSTANCE)) 
      generateHistoryInstance(r);
    if (hasOp(r, TypeRestfulInteraction.VREAD)) 
      generateVRead(r);
    if (hasOp(r, TypeRestfulInteraction.HISTORYTYPE)) 
      generateHistoryType(r);
  }

  private void generateMetadata() {
    OperationWriter op = makePathMetadata().operation("get");
    op.summary("Return the server's capability statement");
    op.operationId("metadata");
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the capbility statement");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/CapabilityStatement");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/CapabilityStatement.xsd");

    // parameters - but do they apply?
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/elements");
  }

  private void generateRead(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResId(r).operation("get");
    op.summary("Read the current state of the resource");
    op.operationId("read"+r.getType());
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned");
    if (r.getVersioning() != ResourceVersionPolicy.NOVERSION)
      resp.header("ETag").description("Version from Resource.meta.version as a weak ETag").schema().type(SchemaType.string);
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");

    // parameters:
    op.paramRef("#/components/parameters/rid");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
  }

  private void generateSearch(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResType(r).operation("get");
    op.summary("Search all resources of type "+r.getType()+" based on a set of criteria");
    op.operationId("search"+r.getType());
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");
    // todo: how do we know that these apply? 
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/elements");
    Set<String> set = new HashSet<>();
    for (CapabilityStatementRestResourceSearchParamComponent spc : r.getSearchParam()) {
      if (!set.contains(spc.getName())) {
        set.add(spc.getName());
        ParameterWriter p = op.parameter(spc.getName());
        p.in(ParameterLocation.query).description(spc.getDocumentation());
        p.schema().type(getSchemaType(spc.getType()));
        if (spc.hasDefinition()) {
          SearchParameter sp = context.fetchResource(SearchParameter.class, spc.getDefinition());
          if (sp != null) {
            p.description(sp.getDescription());
          }
        }
      }
    }
  }

  private void generateSearchSystem(CapabilityStatementRestComponent csr) {
    OperationWriter op = makePathSystem().operation("get");
    op.summary("Search all resources of all types based on a set of criteria");
    op.operationId("searchAll");
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");
    // todo: how do we know that these apply? 
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/elements");
    Set<String> set = new HashSet<>();
    set.add("_summary");
    set.add("_format");
    set.add("_pretty");
    set.add("_elements");
    for (CapabilityStatementRestResourceSearchParamComponent spc : csr.getSearchParam()) {
      if (!set.contains(spc.getName())) {
        set.add(spc.getName());
        ParameterWriter p = op.parameter(spc.getName());
        p.in(ParameterLocation.query).description(spc.getDocumentation());
        p.schema().type(getSchemaType(spc.getType()));
        if (spc.hasDefinition()) {
          SearchParameter sp = context.fetchResource(SearchParameter.class, spc.getDefinition());
          if (sp != null) {
            p.description(sp.getDescription());
          }
        }
      }
    }
  }

  private SchemaType getSchemaType(SearchParamType type) {
    switch (type) {
    // case COMPOSITE:
    case DATE: return SchemaType.dateTime;
    case NUMBER: return SchemaType.number; 
    case QUANTITY: return SchemaType.string;
    case REFERENCE: return SchemaType.string;
    case STRING: return SchemaType.string;
    case TOKEN: return SchemaType.string;
    case URI: return SchemaType.string;
    }
    return null;
  }

  private void generateHistoryType(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResHistListType(r).operation("get");
    op.summary("Read the past states of the resource");
    op.operationId("histtype"+r.getType());
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resources being returned");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
    op.paramRef("#/components/parameters/count");

    op.parameter("_since").in(ParameterLocation.query).description("Only include resource versions that were created at or after the given instant in time").schema().type(SchemaType.dateTime);
    op.parameter("_at").in(ParameterLocation.query).description("Only include resource versions that were current at some point during the time period specified in the date time value (see Search notes on date searching)").schema().type(SchemaType.dateTime);
    op.parameter("_list").in(ParameterLocation.query).description("Only include resource versions that are referenced in the specified list (current list references are allowed)").schema().type(SchemaType.string);
  }

  private void generateHistoryInstance(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResHistListId(r).operation("get");
    op.summary("Read the past states of the resource");
    op.operationId("histinst"+r.getType());
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resources being returned");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");
    op.paramRef("#/components/parameters/rid");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
    op.paramRef("#/components/parameters/count");

    op.parameter("_since").in(ParameterLocation.query).description("Only include resource versions that were created at or after the given instant in time").schema().type(SchemaType.dateTime);
    op.parameter("_at").in(ParameterLocation.query).description("Only include resource versions that were current at some point during the time period specified in the date time value (see Search notes on date searching)").schema().type(SchemaType.dateTime);
    op.parameter("_list").in(ParameterLocation.query).description("Only include resource versions that are referenced in the specified list (current list references are allowed)").schema().type(SchemaType.string);
  }

  private void generateHistorySystem(CapabilityStatementRestComponent csr) {
    OperationWriter op = makePathHistListSystem().operation("get");
    op.summary("Read the past states of all resources");
    op.operationId("histAll");
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resources being returned");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
    op.paramRef("#/components/parameters/count");

    op.parameter("_since").in(ParameterLocation.query).description("Only include resource versions that were created at or after the given instant in time").schema().type(SchemaType.dateTime);
    op.parameter("_at").in(ParameterLocation.query).description("Only include resource versions that were current at some point during the time period specified in the date time value (see Search notes on date searching)").schema().type(SchemaType.dateTime);
    op.parameter("_list").in(ParameterLocation.query).description("Only include resource versions that are referenced in the specified list (current list references are allowed)").schema().type(SchemaType.string);
  }

  private void generateVRead(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResHistId(r).operation("get");
    op.summary("Read a past state of the resource");
    op.operationId("vread"+r.getType());
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned");
    if (r.getVersioning() != ResourceVersionPolicy.NOVERSION)
      resp.header("ETag").description("Version from Resource.meta.version as a weak ETag for that version").schema().type(SchemaType.string);
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");
    op.paramRef("#/components/parameters/rid");
    op.paramRef("#/components/parameters/hid");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
  }

  // todo: how does prefer header affect return type?
  private void generateUpdate(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResId(r).operation("put");
    if (r.getUpdateCreate())
      op.summary("Update the current state of the resource (can create a new resource if it does not exist)");
    else
      op.summary("Update the current state of the resource");
    op.operationId("update"+r.getType());
    RequestBodyWriter req = op.request();
    req.description("The new state of the resource").required(true);
    if (isJson())
      req.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      req.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");

    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned after being updated");
    if (r.getVersioning() != ResourceVersionPolicy.NOVERSION)
      resp.header("ETag").description("Version from Resource.meta.version as a weak ETag").schema().type(SchemaType.string);
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");
    op.paramRef("#/components/parameters/rid");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
  }

  private void generatePatch(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResId(r).operation("patch");
    op.summary("Change the current state of the resource by providing a patch - a series of change commands");
    op.operationId("patch"+r.getType());
    RequestBodyWriter req = op.request();
    req.description("The new state of the resource").required(true);
    if (isJson()) {
      req.content("application/json-patch+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
      req.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Parameters");
    }
    if (isXml()) {
      req.content("application/xml-patch+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");
      req.content("application/fhir+xml").schemaRef(specRef()+"/Parameters.xsd");
    }

    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned after being patched");
    if (r.getVersioning() != ResourceVersionPolicy.NOVERSION)
      resp.header("ETag").description("Version from Resource.meta.version as a weak ETag").schema().type(SchemaType.string);
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");
    op.paramRef("#/components/parameters/rid");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
  }

  private void generateDelete(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathResId(r).operation("delete");
    op.summary("Delete the resource so that it no exists (no read, search etc)");
    op.operationId("delete"+r.getType());
    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("204");
    resp.description("If the resource is deleted - no content is returned");
    if (r.getVersioning() != ResourceVersionPolicy.NOVERSION)
      resp.header("ETag").description("Version from Resource.meta.version as a weak ETag").schema().type(SchemaType.string);
    op.paramRef("#/components/parameters/rid");
  }

  private void generateCreate(CapabilityStatementRestResourceComponent r) {
    OperationWriter op = makePathRes(r).operation("post");
    op.summary("Create a new resource");
    op.operationId("create"+r.getType());
    RequestBodyWriter req = op.request();
    req.description("The new state of the resource").required(true);
    if (isJson())
      req.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      req.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");

    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("the resource being returned after being updated");
    if (r.getVersioning() != ResourceVersionPolicy.NOVERSION)
      resp.header("ETag").description("Version from Resource.meta.version as a weak ETag").schema().type(SchemaType.string);
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/"+r.getType());
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/"+r.getType()+".xsd");
    op.paramRef("#/components/parameters/summary");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
    op.paramRef("#/components/parameters/elements");
  }

  private void generateBatchTransaction(CapabilityStatementRestComponent csr) {
    OperationWriter op = makePathSystem().operation("put");
    op.summary("Batch or Transaction");
    op.operationId("transaction");
    RequestBodyWriter req = op.request();
    req.description("The batch or transaction").required(true);
    if (isJson())
      req.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      req.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");

    opOutcome(op.responses().defaultResponse());
    ResponseObjectWriter resp = op.responses().httpResponse("200");
    resp.description("Batch or Transaction response");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/Bundle");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/Bundle.xsd");
    op.paramRef("#/components/parameters/format");
    op.paramRef("#/components/parameters/pretty");
  }

  private void opOutcome(ResponseObjectWriter resp) {
    resp.description("Error, with details");
    if (isJson())
      resp.content("application/fhir+json").schemaRef(specRef()+"/fhir.schema.json#/definitions/OperationOutcome");
    if (isXml())
      resp.content("application/fhir+xml").schemaRef(specRef()+"/OperationOutcome.xsd");    
  }

  private String specRef() {
    String ver = context.getVersion();
    if (Utilities.noString(ver))
      return "https://hl7.org/fhir/STU3";
    if (ver.startsWith("4.0"))
      return "https://hl7.org/fhir/R4";
    if (ver.startsWith("3.0"))
      return "https://hl7.org/fhir/STU3";
    if (ver.startsWith("1.0"))
      return "https://hl7.org/fhir/DSTU2";
    if (ver.startsWith("1.4"))
      return "https://hl7.org/fhir/2016May";
    return "https://build.fhir.org";    
  }

  private boolean isJson() {
    for (CodeType f : source.getFormat()) {
      if (f.getCode().contains("json"))
        return true;
    }
    return false;
  }

  private boolean isXml() {
    for (CodeType f : source.getFormat()) {
      if (f.getCode().contains("xml"))
        return true;
    }
    return false;
  }

  public PathItemWriter makePathSystem() {
    PathItemWriter p = dest.path("/");
    p.summary("System level operations");
    p.description("System level operations");
    return p;
  }

  public PathItemWriter makePathMetadata() {
    PathItemWriter p = dest.path("/metadata");
    p.summary("Access to the Server's Capability Statement");
    p.description("All FHIR Servers return a CapabilityStatement that describes what services they perform");
    return p;
  }

  public PathItemWriter makePathRes(CapabilityStatementRestResourceComponent r) {
    PathItemWriter p = dest.path("/"+r.getType());
    p.summary("Manager for resources of type "+r.getType());
    p.description("The Manager for resources of type "+r.getType()+": provides services to manage the collection of all the "+r.getType()+" instances");
    return p;
  }

  public PathItemWriter makePathResId(CapabilityStatementRestResourceComponent r) {
    PathItemWriter p = dest.path("/"+r.getType()+"/{rid}");
    p.summary("Read/Write/etc resource instance of type "+r.getType());
    p.description("Access to services to manage the state of a single resource of type "+r.getType());
    return p;
  }

  public PathItemWriter makePathResType(CapabilityStatementRestResourceComponent r) {
    PathItemWriter p = dest.path("/"+r.getType());
    p.summary("manage the collection of resources of type "+r.getType());
    p.description("Access to services to manage the collection of all resources of type "+r.getType());
    return p;
  }

  public PathItemWriter makePathResHistListType(CapabilityStatementRestResourceComponent r) {
    PathItemWriter p = dest.path("/"+r.getType()+"/_history");
    p.summary("Read past versions of resources of type "+r.getType());
    p.description("Access to previous versions of resourcez of type "+r.getType());
    return p;
  }

  public PathItemWriter makePathResHistListId(CapabilityStatementRestResourceComponent r) {
    PathItemWriter p = dest.path("/"+r.getType()+"/{rid}/_history");
    p.summary("Read past versions of resource instance of type "+r.getType());
    p.description("Access to previous versions of a single resource of type "+r.getType());
    return p;
  }

  public PathItemWriter makePathResHistId(CapabilityStatementRestResourceComponent r) {
    PathItemWriter p = dest.path("/"+r.getType()+"/{rid}/_history/{hid}");
    p.summary("Read a past version of resource instance of type "+r.getType());
    p.description("Access a to specified previous version of a single resource of type "+r.getType());
    return p;
  }

  public PathItemWriter makePathHistListSystem() {
    PathItemWriter p = dest.path("/_history");
    p.summary("Read a past version of resource instance of all types");
    p.description("Access a previous versions of all types");
    return p;
  }

  private boolean hasOp(CapabilityStatementRestComponent r, SystemRestfulInteraction opCode) {
    for (SystemInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == opCode) 
        return true;
    }
    return false;
  }

  private boolean hasOp(CapabilityStatementRestResourceComponent r, TypeRestfulInteraction opCode) {
    for (ResourceInteractionComponent op : r.getInteraction()) {
      if (op.getCode() == opCode) 
        return true;
    }
    return false;
  }

  private String url(List<ContactPoint> telecom) {
    for (ContactPoint cp : telecom) {
      if (cp.getSystem() == ContactPointSystem.URL)
        return cp.getValue();
    }
    return null;
  }


  private String email(List<ContactPoint> telecom) {
    for (ContactPoint cp : telecom) {
      if (cp.getSystem() == ContactPointSystem.EMAIL)
        return cp.getValue();
    }
    return null;
  }



}