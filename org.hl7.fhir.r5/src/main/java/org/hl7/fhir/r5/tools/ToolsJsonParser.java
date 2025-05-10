package org.hl7.fhir.r5.tools;

// generated

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
import org.hl7.fhir.exceptions.FHIRFormatError;

import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.r5.formats.JsonParserBase;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ToolsJsonParser extends org.hl7.fhir.r5.formats.JsonParser {
 
  public ToolsJsonParser(JsonCreator json) {
    super();
    this.json = json;
  }

  public ToolsJsonParser(boolean allowUnknownContent, boolean allowComments) {
    super();
    setAllowUnknownContent(allowUnknownContent);
    setAllowComments(allowComments);
  }

  public Resource parseResource(JsonObject json) throws IOException, FHIRFormatError {
    if (!json.has("resourceType")) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
    }
    String t = json.get("resourceType").getAsString();
    if (Utilities.noString(t)) {
      throw new FHIRFormatError("Unable to find resource type - maybe not a FHIR resource?");
    } else if (t.equals("TestCases")) {
      return parseTestCases(json);

    } else {
      throw new FHIRFormatError("Unknown/Unrecognised resource type '"+t+"' (in property 'resourceType')");
    }
  }

  protected void parseCDSHookContextProperties(JsonObject json, CDSHookContext res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
  }

  protected void parseCDSHooksElementProperties(JsonObject json, CDSHooksElement res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("extension"))
      res.setExtension(parseCDSHooksExtensions(getJObject(json, "extension")));
  }

  protected CDSHookOrderSelectContext parseCDSHookOrderSelectContext(JsonObject json) throws IOException, FHIRFormatError {
    CDSHookOrderSelectContext res = new CDSHookOrderSelectContext();
    parseCDSHookOrderSelectContextProperties(json, res);
    return res;
  }

  protected void parseCDSHookOrderSelectContextProperties(JsonObject json, CDSHookOrderSelectContext res) throws IOException, FHIRFormatError {
    parseCDSHookContextProperties(json, res);
    if (json.has("userId"))
      res.setUserIdElement(parseUrl(json.get("userId").getAsString()));
    if (json.has("_userId"))
      parseElementProperties(getJObject(json, "_userId"), res.getUserIdElement());
    if (json.has("patientId"))
      res.setPatientIdElement(parseId(json.get("patientId").getAsString()));
    if (json.has("_patientId"))
      parseElementProperties(getJObject(json, "_patientId"), res.getPatientIdElement());
    if (json.has("encounterId"))
      res.setEncounterIdElement(parseId(json.get("encounterId").getAsString()));
    if (json.has("_encounterId"))
      parseElementProperties(getJObject(json, "_encounterId"), res.getEncounterIdElement());
    if (json.has("selections")) {
      JsonArray array = getJArray(json, "selections");
      for (int i = 0; i < array.size(); i++) {
        if (array.get(i).isJsonNull()) {
          res.getSelectionsList().add(new UriType());
        } else {;
          res.getSelectionsList().add(parseUri(array.get(i).getAsString()));
        }
      }
    };
    if (json.has("_selections")) {
      JsonArray array = getJArray(json, "_selections");
      for (int i = 0; i < array.size(); i++) {
        if (i == res.getSelectionsList().size())
          res.getSelectionsList().add(parseUri(null));
        if (array.get(i) instanceof JsonObject) 
          parseElementProperties(array.get(i).getAsJsonObject(), res.getSelectionsList().get(i));
      }
    };
    if (json.has("draftOrders"))
      res.setDraftOrders(parseBundle(getJObject(json, "draftOrders")));
  }

  protected CDSHookOrderSignContext parseCDSHookOrderSignContext(JsonObject json) throws IOException, FHIRFormatError {
    CDSHookOrderSignContext res = new CDSHookOrderSignContext();
    parseCDSHookOrderSignContextProperties(json, res);
    return res;
  }

  protected void parseCDSHookOrderSignContextProperties(JsonObject json, CDSHookOrderSignContext res) throws IOException, FHIRFormatError {
    parseCDSHookContextProperties(json, res);
    if (json.has("userId"))
      res.setUserIdElement(parseUrl(json.get("userId").getAsString()));
    if (json.has("_userId"))
      parseElementProperties(getJObject(json, "_userId"), res.getUserIdElement());
    if (json.has("patientId"))
      res.setPatientIdElement(parseId(json.get("patientId").getAsString()));
    if (json.has("_patientId"))
      parseElementProperties(getJObject(json, "_patientId"), res.getPatientIdElement());
    if (json.has("encounterId"))
      res.setEncounterIdElement(parseId(json.get("encounterId").getAsString()));
    if (json.has("_encounterId"))
      parseElementProperties(getJObject(json, "_encounterId"), res.getEncounterIdElement());
    if (json.has("draftOrders"))
      res.setDraftOrders(parseBundle(getJObject(json, "draftOrders")));
  }

  protected CDSHookPatientViewContext parseCDSHookPatientViewContext(JsonObject json) throws IOException, FHIRFormatError {
    CDSHookPatientViewContext res = new CDSHookPatientViewContext();
    parseCDSHookPatientViewContextProperties(json, res);
    return res;
  }

  protected void parseCDSHookPatientViewContextProperties(JsonObject json, CDSHookPatientViewContext res) throws IOException, FHIRFormatError {
    parseCDSHookContextProperties(json, res);
    if (json.has("userId"))
      res.setUserIdElement(parseUrl(json.get("userId").getAsString()));
    if (json.has("_userId"))
      parseElementProperties(getJObject(json, "_userId"), res.getUserIdElement());
    if (json.has("patientId"))
      res.setPatientIdElement(parseId(json.get("patientId").getAsString()));
    if (json.has("_patientId"))
      parseElementProperties(getJObject(json, "_patientId"), res.getPatientIdElement());
    if (json.has("encounterId"))
      res.setEncounterIdElement(parseId(json.get("encounterId").getAsString()));
    if (json.has("_encounterId"))
      parseElementProperties(getJObject(json, "_encounterId"), res.getEncounterIdElement());
  }

  protected CDSHooksExtensions parseCDSHooksExtensions(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksExtensions res = new CDSHooksExtensions();
    parseCDSHooksExtensionsProperties(json, res);
    return res;
  }

  protected void parseCDSHooksExtensionsProperties(JsonObject json, CDSHooksExtensions res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    // todo: Named Element Extensions
  }

  protected CDSHooksRequest parseCDSHooksRequest(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksRequest res = new CDSHooksRequest();
    parseCDSHooksRequestProperties(json, res);
    return res;
  }

  protected void parseCDSHooksRequestProperties(JsonObject json, CDSHooksRequest res) throws IOException, FHIRFormatError {
    parseCDSHooksElementProperties(json, res);
    if (json.has("hook"))
      res.setHookElement(parseCode(json.get("hook").getAsString()));
    if (json.has("_hook"))
      parseElementProperties(getJObject(json, "_hook"), res.getHookElement());
    if (json.has("hookInstance"))
      res.setHookInstanceElement(parseUuid(json.get("hookInstance").getAsString()));
    if (json.has("_hookInstance"))
      parseElementProperties(getJObject(json, "_hookInstance"), res.getHookInstanceElement());
    if (json.has("fhirServer"))
      res.setFhirServerElement(parseUrl(json.get("fhirServer").getAsString()));
    if (json.has("_fhirServer"))
      parseElementProperties(getJObject(json, "_fhirServer"), res.getFhirServerElement());
    if (json.has("fhirAuthorization"))
      res.setFhirAuthorization(parseCDSHooksRequestFhirAuthorizationComponent(getJObject(json, "fhirAuthorization")));
    if (json.has("context"))
      res.setContext(parseCDSHookContext(json, getJObject(json, "context")));
    if (json.has("prefetch")) {
      JsonArray array = getJArray(json, "prefetch");
      for (int i = 0; i < array.size(); i++) {
        res.getPrefetchList().add(parseCDSHooksRequestPrefetchComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CDSHookContext parseCDSHookContext(JsonObject resource, JsonObject json) throws IOException, FHIRFormatError {
    if (resource.get("hook").getAsString().equals("patient-view")) {
      return parseCDSHookPatientViewContext(json);
    }
    if (resource.get("hook").getAsString().equals("order-sign")) {
      return parseCDSHookOrderSignContext(json);
    }
    if (resource.get("hook").getAsString().equals("order-select")) {
      return parseCDSHookOrderSelectContext(json);
    }
    throw new FHIRFormatError("Unable to parse CDSHookContext: The content does not meet any of the type specifiers");
  }

  protected CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent parseCDSHooksRequestFhirAuthorizationComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent res = new CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent();
    parseCDSHooksRequestFhirAuthorizationComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksRequestFhirAuthorizationComponentProperties(JsonObject json, CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("accessToken"))
      res.setAccessTokenElement(parseString(json.get("accessToken").getAsString()));
    if (json.has("_accessToken"))
      parseElementProperties(getJObject(json, "_accessToken"), res.getAccessTokenElement());
    if (json.has("tokenType"))
      res.setTokenTypeElement(parseCode(json.get("tokenType").getAsString()));
    if (json.has("_tokenType"))
      parseElementProperties(getJObject(json, "_tokenType"), res.getTokenTypeElement());
    if (json.has("expiresIn"))
      res.setExpiresInElement(parseInteger(json.get("expiresIn").getAsLong()));
    if (json.has("_expiresIn"))
      parseElementProperties(getJObject(json, "_expiresIn"), res.getExpiresInElement());
    if (json.has("scope"))
      res.setScopeElement(parseString(json.get("scope").getAsString()));
    if (json.has("_scope"))
      parseElementProperties(getJObject(json, "_scope"), res.getScopeElement());
    if (json.has("subject"))
      res.setSubjectElement(parseString(json.get("subject").getAsString()));
    if (json.has("_subject"))
      parseElementProperties(getJObject(json, "_subject"), res.getSubjectElement());
    if (json.has("patient"))
      res.setPatientElement(parseId(json.get("patient").getAsString()));
    if (json.has("_patient"))
      parseElementProperties(getJObject(json, "_patient"), res.getPatientElement());
  }

  protected CDSHooksRequest.CDSHooksRequestPrefetchComponent parseCDSHooksRequestPrefetchComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksRequest.CDSHooksRequestPrefetchComponent res = new CDSHooksRequest.CDSHooksRequestPrefetchComponent();
    parseCDSHooksRequestPrefetchComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksRequestPrefetchComponentProperties(JsonObject json, CDSHooksRequest.CDSHooksRequestPrefetchComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("key"))
      res.setKeyElement(parseCode(json.get("key").getAsString()));
    if (json.has("_key"))
      parseElementProperties(getJObject(json, "_key"), res.getKeyElement());
    if (json.has("value"))
      res.setValue(parseResource(getJObject(json, "value")));
  }

  protected CDSHooksResponse parseCDSHooksResponse(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksResponse res = new CDSHooksResponse();
    parseCDSHooksResponseProperties(json, res);
    return res;
  }

  protected void parseCDSHooksResponseProperties(JsonObject json, CDSHooksResponse res) throws IOException, FHIRFormatError {
    parseCDSHooksElementProperties(json, res);
    if (json.has("cards")) {
      JsonArray array = getJArray(json, "cards");
      for (int i = 0; i < array.size(); i++) {
        res.getCardsList().add(parseCDSHooksResponseCardsComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("systemActions")) {
      JsonArray array = getJArray(json, "systemActions");
      for (int i = 0; i < array.size(); i++) {
        res.getSystemActionsList().add(parseCDSHooksResponseCardsSuggestionsActionsComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CDSHooksResponse.CDSHooksResponseCardsComponent parseCDSHooksResponseCardsComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsComponent res = new CDSHooksResponse.CDSHooksResponseCardsComponent();
    parseCDSHooksResponseCardsComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksResponseCardsComponentProperties(JsonObject json, CDSHooksResponse.CDSHooksResponseCardsComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("uuid"))
      res.setUuidElement(parseUuid(json.get("uuid").getAsString()));
    if (json.has("_uuid"))
      parseElementProperties(getJObject(json, "_uuid"), res.getUuidElement());
    if (json.has("summary"))
      res.setSummaryElement(parseString(json.get("summary").getAsString()));
    if (json.has("_summary"))
      parseElementProperties(getJObject(json, "_summary"), res.getSummaryElement());
    if (json.has("detail"))
      res.setDetailElement(parseMarkdown(json.get("detail").getAsString()));
    if (json.has("_detail"))
      parseElementProperties(getJObject(json, "_detail"), res.getDetailElement());
    if (json.has("indicator"))
      res.setIndicatorElement(parseEnumeration(json.get("indicator").getAsString(), CDSHooksResponse.CDSIndicatorCodesVS.NULL, new CDSHooksResponse.CDSIndicatorCodesVSEnumFactory()));
    if (json.has("_indicator"))
      parseElementProperties(getJObject(json, "_indicator"), res.getIndicatorElement());
    if (json.has("source"))
      res.setSource(parseCDSHooksResponseCardsSourceComponent(getJObject(json, "source")));
    if (json.has("suggestions")) {
      JsonArray array = getJArray(json, "suggestions");
      for (int i = 0; i < array.size(); i++) {
        res.getSuggestionsList().add(parseCDSHooksResponseCardsSuggestionsComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("selectionBehavior"))
      res.setSelectionBehaviorElement(parseEnumeration(json.get("selectionBehavior").getAsString(), CDSHooksResponse.CDSSelectionBehaviorCodesVS.NULL, new CDSHooksResponse.CDSSelectionBehaviorCodesVSEnumFactory()));
    if (json.has("_selectionBehavior"))
      parseElementProperties(getJObject(json, "_selectionBehavior"), res.getSelectionBehaviorElement());
    if (json.has("overrideReasons")) {
      JsonArray array = getJArray(json, "overrideReasons");
      for (int i = 0; i < array.size(); i++) {
        res.getOverrideReasonsList().add(parseCoding(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("links")) {
      JsonArray array = getJArray(json, "links");
      for (int i = 0; i < array.size(); i++) {
        res.getLinksList().add(parseCDSHooksResponseCardsLinksComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CDSHooksResponse.CDSHooksResponseCardsSourceComponent parseCDSHooksResponseCardsSourceComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsSourceComponent res = new CDSHooksResponse.CDSHooksResponseCardsSourceComponent();
    parseCDSHooksResponseCardsSourceComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksResponseCardsSourceComponentProperties(JsonObject json, CDSHooksResponse.CDSHooksResponseCardsSourceComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("label"))
      res.setLabelElement(parseString(json.get("label").getAsString()));
    if (json.has("_label"))
      parseElementProperties(getJObject(json, "_label"), res.getLabelElement());
    if (json.has("url"))
      res.setUrlElement(parseUrl(json.get("url").getAsString()));
    if (json.has("_url"))
      parseElementProperties(getJObject(json, "_url"), res.getUrlElement());
    if (json.has("icon"))
      res.setIconElement(parseUrl(json.get("icon").getAsString()));
    if (json.has("_icon"))
      parseElementProperties(getJObject(json, "_icon"), res.getIconElement());
    if (json.has("topic"))
      res.setTopic(parseCoding(getJObject(json, "topic")));
  }

  protected CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent parseCDSHooksResponseCardsSuggestionsComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent res = new CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent();
    parseCDSHooksResponseCardsSuggestionsComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksResponseCardsSuggestionsComponentProperties(JsonObject json, CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("label"))
      res.setLabelElement(parseString(json.get("label").getAsString()));
    if (json.has("_label"))
      parseElementProperties(getJObject(json, "_label"), res.getLabelElement());
    if (json.has("uuid"))
      res.setUuidElement(parseUuid(json.get("uuid").getAsString()));
    if (json.has("_uuid"))
      parseElementProperties(getJObject(json, "_uuid"), res.getUuidElement());
    if (json.has("isRecommended"))
      res.setIsRecommendedElement(parseBoolean(json.get("isRecommended").getAsBoolean()));
    if (json.has("_isRecommended"))
      parseElementProperties(getJObject(json, "_isRecommended"), res.getIsRecommendedElement());
    if (json.has("actions")) {
      JsonArray array = getJArray(json, "actions");
      for (int i = 0; i < array.size(); i++) {
        res.getActionsList().add(parseCDSHooksResponseCardsSuggestionsActionsComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent parseCDSHooksResponseCardsSuggestionsActionsComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent res = new CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent();
    parseCDSHooksResponseCardsSuggestionsActionsComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksResponseCardsSuggestionsActionsComponentProperties(JsonObject json, CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("type"))
      res.setTypeElement(parseEnumeration(json.get("type").getAsString(), CDSHooksResponse.CDSActionTypeCodesVS.NULL, new CDSHooksResponse.CDSActionTypeCodesVSEnumFactory()));
    if (json.has("_type"))
      parseElementProperties(getJObject(json, "_type"), res.getTypeElement());
    if (json.has("description"))
      res.setDescriptionElement(parseString(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(getJObject(json, "_description"), res.getDescriptionElement());
    if (json.has("resource"))
      res.setResource(parseResource(getJObject(json, "resource")));
    if (json.has("resourceId"))
      res.setResourceIdElement(parseUrl(json.get("resourceId").getAsString()));
    if (json.has("_resourceId"))
      parseElementProperties(getJObject(json, "_resourceId"), res.getResourceIdElement());
  }

  protected CDSHooksResponse.CDSHooksResponseCardsLinksComponent parseCDSHooksResponseCardsLinksComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsLinksComponent res = new CDSHooksResponse.CDSHooksResponseCardsLinksComponent();
    parseCDSHooksResponseCardsLinksComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksResponseCardsLinksComponentProperties(JsonObject json, CDSHooksResponse.CDSHooksResponseCardsLinksComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("label"))
      res.setLabelElement(parseString(json.get("label").getAsString()));
    if (json.has("_label"))
      parseElementProperties(getJObject(json, "_label"), res.getLabelElement());
    if (json.has("url"))
      res.setUrlElement(parseUrl(json.get("url").getAsString()));
    if (json.has("_url"))
      parseElementProperties(getJObject(json, "_url"), res.getUrlElement());
    if (json.has("type"))
      res.setTypeElement(parseEnumeration(json.get("type").getAsString(), CDSHooksResponse.CDSLinkTypeCodesVS.NULL, new CDSHooksResponse.CDSLinkTypeCodesVSEnumFactory()));
    if (json.has("_type"))
      parseElementProperties(getJObject(json, "_type"), res.getTypeElement());
    if (json.has("appContext"))
      res.setAppContextElement(parseString(json.get("appContext").getAsString()));
    if (json.has("_appContext"))
      parseElementProperties(getJObject(json, "_appContext"), res.getAppContextElement());
  }

  protected CDSHooksServices parseCDSHooksServices(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksServices res = new CDSHooksServices();
    parseCDSHooksServicesProperties(json, res);
    return res;
  }

  protected void parseCDSHooksServicesProperties(JsonObject json, CDSHooksServices res) throws IOException, FHIRFormatError {
    parseCDSHooksElementProperties(json, res);
    if (json.has("services")) {
      JsonArray array = getJArray(json, "services");
      for (int i = 0; i < array.size(); i++) {
        res.getServicesList().add(parseCDSHooksServicesServicesComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CDSHooksServices.CDSHooksServicesServicesComponent parseCDSHooksServicesServicesComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksServices.CDSHooksServicesServicesComponent res = new CDSHooksServices.CDSHooksServicesServicesComponent();
    parseCDSHooksServicesServicesComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksServicesServicesComponentProperties(JsonObject json, CDSHooksServices.CDSHooksServicesServicesComponent res) throws IOException, FHIRFormatError {
    parsehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(json, res);
    if (json.has("hook"))
      res.setHookElement(parseString(json.get("hook").getAsString()));
    if (json.has("_hook"))
      parseElementProperties(getJObject(json, "_hook"), res.getHookElement());
    if (json.has("title"))
      res.setTitleElement(parseString(json.get("title").getAsString()));
    if (json.has("_title"))
      parseElementProperties(getJObject(json, "_title"), res.getTitleElement());
    if (json.has("id"))
      res.setIdElement(parseCode(json.get("id").getAsString()));
    if (json.has("_id"))
      parseElementProperties(getJObject(json, "_id"), res.getIdElement());
    if (json.has("description"))
      res.setDescriptionElement(parseString(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(getJObject(json, "_description"), res.getDescriptionElement());
    if (json.has("usageRequirements"))
      res.setUsageRequirementsElement(parseString(json.get("usageRequirements").getAsString()));
    if (json.has("_usageRequirements"))
      parseElementProperties(getJObject(json, "_usageRequirements"), res.getUsageRequirementsElement());
    if (json.has("prefetch")) {
      JsonArray array = getJArray(json, "prefetch");
      for (int i = 0; i < array.size(); i++) {
        res.getPrefetchList().add(parseCDSHooksServicesServicesPrefetchComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected CDSHooksServices.CDSHooksServicesServicesPrefetchComponent parseCDSHooksServicesServicesPrefetchComponent(JsonObject json) throws IOException, FHIRFormatError {
    CDSHooksServices.CDSHooksServicesServicesPrefetchComponent res = new CDSHooksServices.CDSHooksServicesServicesPrefetchComponent();
    parseCDSHooksServicesServicesPrefetchComponentProperties(json, res);
    return res;
  }

  protected void parseCDSHooksServicesServicesPrefetchComponentProperties(JsonObject json, CDSHooksServices.CDSHooksServicesServicesPrefetchComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("key"))
      res.setKeyElement(parseCode(json.get("key").getAsString()));
    if (json.has("_key"))
      parseElementProperties(getJObject(json, "_key"), res.getKeyElement());
    if (json.has("value"))
      res.setValueElement(parseString(json.get("value").getAsString()));
    if (json.has("_value"))
      parseElementProperties(getJObject(json, "_value"), res.getValueElement());
  }

  protected TestCases parseTestCases(JsonObject json) throws IOException, FHIRFormatError {
    TestCases res = new TestCases();
    parseTestCasesProperties(json, res);
    return res;
  }

  protected void parseTestCasesProperties(JsonObject json, TestCases res) throws IOException, FHIRFormatError {
    parseResourceProperties(json, res);
    if (json.has("url"))
      res.setUrlElement(parseUri(json.get("url").getAsString()));
    if (json.has("_url"))
      parseElementProperties(getJObject(json, "_url"), res.getUrlElement());
    if (json.has("version"))
      res.setVersionElement(parseString(json.get("version").getAsString()));
    if (json.has("_version"))
      parseElementProperties(getJObject(json, "_version"), res.getVersionElement());
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    if (json.has("description"))
      res.setDescriptionElement(parseMarkdown(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(getJObject(json, "_description"), res.getDescriptionElement());
    if (json.has("runner"))
      res.setRunnerElement(parseUrl(json.get("runner").getAsString()));
    if (json.has("_runner"))
      parseElementProperties(getJObject(json, "_runner"), res.getRunnerElement());
    if (json.has("mode")) {
      JsonArray array = getJArray(json, "mode");
      for (int i = 0; i < array.size(); i++) {
        res.getModeList().add(parseTestCasesModeComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("suite")) {
      JsonArray array = getJArray(json, "suite");
      for (int i = 0; i < array.size(); i++) {
        res.getSuiteList().add(parseTestCasesSuiteComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected TestCases.TestCasesModeComponent parseTestCasesModeComponent(JsonObject json) throws IOException, FHIRFormatError {
    TestCases.TestCasesModeComponent res = new TestCases.TestCasesModeComponent();
    parseTestCasesModeComponentProperties(json, res);
    return res;
  }

  protected void parseTestCasesModeComponentProperties(JsonObject json, TestCases.TestCasesModeComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("code"))
      res.setCodeElement(parseString(json.get("code").getAsString()));
    if (json.has("_code"))
      parseElementProperties(getJObject(json, "_code"), res.getCodeElement());
    if (json.has("description"))
      res.setDescriptionElement(parseString(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(getJObject(json, "_description"), res.getDescriptionElement());
  }

  protected TestCases.TestCasesSuiteComponent parseTestCasesSuiteComponent(JsonObject json) throws IOException, FHIRFormatError {
    TestCases.TestCasesSuiteComponent res = new TestCases.TestCasesSuiteComponent();
    parseTestCasesSuiteComponentProperties(json, res);
    return res;
  }

  protected void parseTestCasesSuiteComponentProperties(JsonObject json, TestCases.TestCasesSuiteComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    if (json.has("description"))
      res.setDescriptionElement(parseString(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(getJObject(json, "_description"), res.getDescriptionElement());
    if (json.has("mode"))
      res.setModeElement(parseCode(json.get("mode").getAsString()));
    if (json.has("_mode"))
      parseElementProperties(getJObject(json, "_mode"), res.getModeElement());
    if (json.has("resource")) {
      JsonArray array = getJArray(json, "resource");
      for (int i = 0; i < array.size(); i++) {
        res.getResourceList().add(parseTestCasesSuiteResourceComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("parameter")) {
      JsonArray array = getJArray(json, "parameter");
      for (int i = 0; i < array.size(); i++) {
        res.getParameterList().add(parseTestCasesSuiteParameterComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("test")) {
      JsonArray array = getJArray(json, "test");
      for (int i = 0; i < array.size(); i++) {
        res.getTestList().add(parseTestCasesSuiteTestComponent(array.get(i).getAsJsonObject()));
      }
    };
  }

  protected TestCases.TestCasesSuiteResourceComponent parseTestCasesSuiteResourceComponent(JsonObject json) throws IOException, FHIRFormatError {
    TestCases.TestCasesSuiteResourceComponent res = new TestCases.TestCasesSuiteResourceComponent();
    parseTestCasesSuiteResourceComponentProperties(json, res);
    return res;
  }

  protected void parseTestCasesSuiteResourceComponentProperties(JsonObject json, TestCases.TestCasesSuiteResourceComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    if (json.has("file"))
      res.setFileElement(parseString(json.get("file").getAsString()));
    if (json.has("_file"))
      parseElementProperties(getJObject(json, "_file"), res.getFileElement());
    if (json.has("resource"))
      res.setResource(parseResource(getJObject(json, "resource")));
    if (json.has("mode"))
      res.setModeElement(parseCode(json.get("mode").getAsString()));
    if (json.has("_mode"))
      parseElementProperties(getJObject(json, "_mode"), res.getModeElement());
  }

  protected TestCases.TestCasesSuiteParameterComponent parseTestCasesSuiteParameterComponent(JsonObject json) throws IOException, FHIRFormatError {
    TestCases.TestCasesSuiteParameterComponent res = new TestCases.TestCasesSuiteParameterComponent();
    parseTestCasesSuiteParameterComponentProperties(json, res);
    return res;
  }

  protected void parseTestCasesSuiteParameterComponentProperties(JsonObject json, TestCases.TestCasesSuiteParameterComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    DataType value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("mode"))
      res.setModeElement(parseCode(json.get("mode").getAsString()));
    if (json.has("_mode"))
      parseElementProperties(getJObject(json, "_mode"), res.getModeElement());
  }

  protected TestCases.TestCasesSuiteTestComponent parseTestCasesSuiteTestComponent(JsonObject json) throws IOException, FHIRFormatError {
    TestCases.TestCasesSuiteTestComponent res = new TestCases.TestCasesSuiteTestComponent();
    parseTestCasesSuiteTestComponentProperties(json, res);
    return res;
  }

  protected void parseTestCasesSuiteTestComponentProperties(JsonObject json, TestCases.TestCasesSuiteTestComponent res) throws IOException, FHIRFormatError {
    parseBaseProperties(json, res);
    if (json.has("name"))
      res.setNameElement(parseString(json.get("name").getAsString()));
    if (json.has("_name"))
      parseElementProperties(getJObject(json, "_name"), res.getNameElement());
    if (json.has("description"))
      res.setDescriptionElement(parseString(json.get("description").getAsString()));
    if (json.has("_description"))
      parseElementProperties(getJObject(json, "_description"), res.getDescriptionElement());
    if (json.has("operation"))
      res.setOperationElement(parseCode(json.get("operation").getAsString()));
    if (json.has("_operation"))
      parseElementProperties(getJObject(json, "_operation"), res.getOperationElement());
    if (json.has("mode"))
      res.setModeElement(parseString(json.get("mode").getAsString()));
    if (json.has("_mode"))
      parseElementProperties(getJObject(json, "_mode"), res.getModeElement());
    if (json.has("parameter")) {
      JsonArray array = getJArray(json, "parameter");
      for (int i = 0; i < array.size(); i++) {
        res.getParameterList().add(parseTestCasesSuiteParameterComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("input")) {
      JsonArray array = getJArray(json, "input");
      for (int i = 0; i < array.size(); i++) {
        res.getInputList().add(parseTestCasesSuiteResourceComponent(array.get(i).getAsJsonObject()));
      }
    };
    if (json.has("output")) {
      JsonArray array = getJArray(json, "output");
      for (int i = 0; i < array.size(); i++) {
        res.getOutputList().add(parseTestCasesSuiteResourceComponent(array.get(i).getAsJsonObject()));
      }
    };
  }


  

// -- compose ---------------------------------------------------------------------------------------------------------------------


  protected void composeCDSHookContextProperties(CDSHookContext element) throws IOException {
      composeBaseProperties(element);
  }

  protected void composeCDSHooksElementProperties(CDSHooksElement element) throws IOException {
      composeBaseProperties(element);
      if (element.hasExtension()) {
        composeCDSHooksExtensions("extension", element.getExtension());
      }
  }

  protected void composeCDSHookOrderSelectContext(String name, CDSHookOrderSelectContext element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHookOrderSelectContextProperties(element);
      close();
    }
  }

  protected void composeCDSHookOrderSelectContextProperties(CDSHookOrderSelectContext element) throws IOException {
    composeCDSHookContextProperties(element);
      if (element.hasUserIdElement()) {
        composeUrlCore("userId", element.getUserIdElement(), false);
        composeUrlExtras("userId", element.getUserIdElement(), false);
      }
      if (element.hasPatientIdElement()) {
        composeIdCore("patientId", element.getPatientIdElement(), false);
        composeIdExtras("patientId", element.getPatientIdElement(), false);
      }
      if (element.hasEncounterIdElement()) {
        composeIdCore("encounterId", element.getEncounterIdElement(), false);
        composeIdExtras("encounterId", element.getEncounterIdElement(), false);
      }
      if (element.hasSelections()) {
        if (anyHasValue(element.getSelectionsList())) {
          openArray("selections");
          for (UriType e : element.getSelectionsList()) 
            composeUriCore(null, e, e != element.getSelectionsList().get(element.getSelectionsList().size()-1));
          closeArray();
        }
        if (anyHasExtras(element.getSelectionsList())) {
          openArray("_selections");
          for (UriType e : element.getSelectionsList()) 
            composeUriExtras(null, e, true);
          closeArray();
        }
      };
      if (element.hasDraftOrders()) {
        composeBundle("draftOrders", element.getDraftOrders());
      }
  }

  protected void composeCDSHookOrderSignContext(String name, CDSHookOrderSignContext element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHookOrderSignContextProperties(element);
      close();
    }
  }

  protected void composeCDSHookOrderSignContextProperties(CDSHookOrderSignContext element) throws IOException {
    composeCDSHookContextProperties(element);
      if (element.hasUserIdElement()) {
        composeUrlCore("userId", element.getUserIdElement(), false);
        composeUrlExtras("userId", element.getUserIdElement(), false);
      }
      if (element.hasPatientIdElement()) {
        composeIdCore("patientId", element.getPatientIdElement(), false);
        composeIdExtras("patientId", element.getPatientIdElement(), false);
      }
      if (element.hasEncounterIdElement()) {
        composeIdCore("encounterId", element.getEncounterIdElement(), false);
        composeIdExtras("encounterId", element.getEncounterIdElement(), false);
      }
      if (element.hasDraftOrders()) {
        composeBundle("draftOrders", element.getDraftOrders());
      }
  }

  protected void composeCDSHookPatientViewContext(String name, CDSHookPatientViewContext element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHookPatientViewContextProperties(element);
      close();
    }
  }

  protected void composeCDSHookPatientViewContextProperties(CDSHookPatientViewContext element) throws IOException {
    composeCDSHookContextProperties(element);
      if (element.hasUserIdElement()) {
        composeUrlCore("userId", element.getUserIdElement(), false);
        composeUrlExtras("userId", element.getUserIdElement(), false);
      }
      if (element.hasPatientIdElement()) {
        composeIdCore("patientId", element.getPatientIdElement(), false);
        composeIdExtras("patientId", element.getPatientIdElement(), false);
      }
      if (element.hasEncounterIdElement()) {
        composeIdCore("encounterId", element.getEncounterIdElement(), false);
        composeIdExtras("encounterId", element.getEncounterIdElement(), false);
      }
  }

  protected void composeCDSHooksExtensions(String name, CDSHooksExtensions element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksExtensionsProperties(element);
      close();
    }
  }

  protected void composeCDSHooksExtensionsProperties(CDSHooksExtensions element) throws IOException {
    composeBaseProperties(element);
     // todo: Named Element Extensions
  }

  protected void composeCDSHooksRequest(String name, CDSHooksRequest element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksRequestProperties(element);
      close();
    }
  }

  protected void composeCDSHooksRequestProperties(CDSHooksRequest element) throws IOException {
    composeCDSHooksElementProperties(element);
      if (element.hasHookElement()) {
        composeCodeCore("hook", element.getHookElement(), false);
        composeCodeExtras("hook", element.getHookElement(), false);
      }
      if (element.hasHookInstanceElement()) {
        composeUuidCore("hookInstance", element.getHookInstanceElement(), false);
        composeUuidExtras("hookInstance", element.getHookInstanceElement(), false);
      }
      if (element.hasFhirServerElement()) {
        composeUrlCore("fhirServer", element.getFhirServerElement(), false);
        composeUrlExtras("fhirServer", element.getFhirServerElement(), false);
      }
      if (element.hasFhirAuthorization()) {
        composeCDSHooksRequestFhirAuthorizationComponent("fhirAuthorization", element.getFhirAuthorization());
      }
      if (element.hasContext()) {
        composeCDSHookContext("context", element.getContext());
      }
      if (element.hasPrefetch()) {
        openArray("prefetch");
        for (CDSHooksRequest.CDSHooksRequestPrefetchComponent e : element.getPrefetchList()) 
          composeCDSHooksRequestPrefetchComponent(null, e);
        closeArray();
      };
  }

  protected void composeCDSHookContext(String name, CDSHookContext element) throws IOException {
    if (element instanceof CDSHookPatientViewContext) {
      composeCDSHookPatientViewContext(name, (CDSHookPatientViewContext) element);
    } else if (element instanceof CDSHookOrderSignContext) {
      composeCDSHookOrderSignContext(name, (CDSHookOrderSignContext) element);
    } else if (element instanceof CDSHookOrderSelectContext) {
      composeCDSHookOrderSelectContext(name, (CDSHookOrderSelectContext) element);
    } else {
      throw new FHIRFormatError("Unable to compose CDSHookContext: Unexpected type "+element.getClass().getName());
    }
  }

  protected void composeCDSHooksRequestFhirAuthorizationComponent(String name, CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksRequestFhirAuthorizationComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksRequestFhirAuthorizationComponentProperties(CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasAccessTokenElement()) {
        composeStringCore("accessToken", element.getAccessTokenElement(), false);
        composeStringExtras("accessToken", element.getAccessTokenElement(), false);
      }
      if (element.hasTokenTypeElement()) {
        composeCodeCore("tokenType", element.getTokenTypeElement(), false);
        composeCodeExtras("tokenType", element.getTokenTypeElement(), false);
      }
      if (element.hasExpiresInElement()) {
        composeIntegerCore("expiresIn", element.getExpiresInElement(), false);
        composeIntegerExtras("expiresIn", element.getExpiresInElement(), false);
      }
      if (element.hasScopeElement()) {
        composeStringCore("scope", element.getScopeElement(), false);
        composeStringExtras("scope", element.getScopeElement(), false);
      }
      if (element.hasSubjectElement()) {
        composeStringCore("subject", element.getSubjectElement(), false);
        composeStringExtras("subject", element.getSubjectElement(), false);
      }
      if (element.hasPatientElement()) {
        composeIdCore("patient", element.getPatientElement(), false);
        composeIdExtras("patient", element.getPatientElement(), false);
      }
  }

  protected void composeCDSHooksRequestPrefetchComponent(String name, CDSHooksRequest.CDSHooksRequestPrefetchComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksRequestPrefetchComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksRequestPrefetchComponentProperties(CDSHooksRequest.CDSHooksRequestPrefetchComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasKeyElement()) {
        composeCodeCore("key", element.getKeyElement(), false);
        composeCodeExtras("key", element.getKeyElement(), false);
      }
        if (element.hasValue()) {
          open("value");
          composeResource(element.getValue());
          close();
        }
  }

  protected void composeCDSHooksResponse(String name, CDSHooksResponse element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksResponseProperties(element);
      close();
    }
  }

  protected void composeCDSHooksResponseProperties(CDSHooksResponse element) throws IOException {
    composeCDSHooksElementProperties(element);
      if (element.hasCards()) {
        openArray("cards");
        for (CDSHooksResponse.CDSHooksResponseCardsComponent e : element.getCardsList()) 
          composeCDSHooksResponseCardsComponent(null, e);
        closeArray();
      };
      if (element.hasSystemActions()) {
        openArray("systemActions");
        for (CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent e : element.getSystemActionsList()) 
          composeCDSHooksResponseCardsSuggestionsActionsComponent(null, e);
        closeArray();
      };
  }

  protected void composeCDSHooksResponseCardsComponent(String name, CDSHooksResponse.CDSHooksResponseCardsComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksResponseCardsComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksResponseCardsComponentProperties(CDSHooksResponse.CDSHooksResponseCardsComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasUuidElement()) {
        composeUuidCore("uuid", element.getUuidElement(), false);
        composeUuidExtras("uuid", element.getUuidElement(), false);
      }
      if (element.hasSummaryElement()) {
        composeStringCore("summary", element.getSummaryElement(), false);
        composeStringExtras("summary", element.getSummaryElement(), false);
      }
      if (element.hasDetailElement()) {
        composeMarkdownCore("detail", element.getDetailElement(), false);
        composeMarkdownExtras("detail", element.getDetailElement(), false);
      }
      if (element.hasIndicatorElement()) {
        composeEnumerationCore("indicator", element.getIndicatorElement(), new CDSHooksResponse.CDSIndicatorCodesVSEnumFactory(), false);
        composeEnumerationExtras("indicator", element.getIndicatorElement(), new CDSHooksResponse.CDSIndicatorCodesVSEnumFactory(), false);
      }
      if (element.hasSource()) {
        composeCDSHooksResponseCardsSourceComponent("source", element.getSource());
      }
      if (element.hasSuggestions()) {
        openArray("suggestions");
        for (CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent e : element.getSuggestionsList()) 
          composeCDSHooksResponseCardsSuggestionsComponent(null, e);
        closeArray();
      };
      if (element.hasSelectionBehaviorElement()) {
        composeEnumerationCore("selectionBehavior", element.getSelectionBehaviorElement(), new CDSHooksResponse.CDSSelectionBehaviorCodesVSEnumFactory(), false);
        composeEnumerationExtras("selectionBehavior", element.getSelectionBehaviorElement(), new CDSHooksResponse.CDSSelectionBehaviorCodesVSEnumFactory(), false);
      }
      if (element.hasOverrideReasons()) {
        openArray("overrideReasons");
        for (Coding e : element.getOverrideReasonsList()) 
          composeCoding(null, e);
        closeArray();
      };
      if (element.hasLinks()) {
        openArray("links");
        for (CDSHooksResponse.CDSHooksResponseCardsLinksComponent e : element.getLinksList()) 
          composeCDSHooksResponseCardsLinksComponent(null, e);
        closeArray();
      };
  }

  protected void composeCDSHooksResponseCardsSourceComponent(String name, CDSHooksResponse.CDSHooksResponseCardsSourceComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksResponseCardsSourceComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksResponseCardsSourceComponentProperties(CDSHooksResponse.CDSHooksResponseCardsSourceComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasLabelElement()) {
        composeStringCore("label", element.getLabelElement(), false);
        composeStringExtras("label", element.getLabelElement(), false);
      }
      if (element.hasUrlElement()) {
        composeUrlCore("url", element.getUrlElement(), false);
        composeUrlExtras("url", element.getUrlElement(), false);
      }
      if (element.hasIconElement()) {
        composeUrlCore("icon", element.getIconElement(), false);
        composeUrlExtras("icon", element.getIconElement(), false);
      }
      if (element.hasTopic()) {
        composeCoding("topic", element.getTopic());
      }
  }

  protected void composeCDSHooksResponseCardsSuggestionsComponent(String name, CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksResponseCardsSuggestionsComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksResponseCardsSuggestionsComponentProperties(CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasLabelElement()) {
        composeStringCore("label", element.getLabelElement(), false);
        composeStringExtras("label", element.getLabelElement(), false);
      }
      if (element.hasUuidElement()) {
        composeUuidCore("uuid", element.getUuidElement(), false);
        composeUuidExtras("uuid", element.getUuidElement(), false);
      }
      if (element.hasIsRecommendedElement()) {
        composeBooleanCore("isRecommended", element.getIsRecommendedElement(), false);
        composeBooleanExtras("isRecommended", element.getIsRecommendedElement(), false);
      }
      if (element.hasActions()) {
        openArray("actions");
        for (CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent e : element.getActionsList()) 
          composeCDSHooksResponseCardsSuggestionsActionsComponent(null, e);
        closeArray();
      };
  }

  protected void composeCDSHooksResponseCardsSuggestionsActionsComponent(String name, CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksResponseCardsSuggestionsActionsComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksResponseCardsSuggestionsActionsComponentProperties(CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasTypeElement()) {
        composeEnumerationCore("type", element.getTypeElement(), new CDSHooksResponse.CDSActionTypeCodesVSEnumFactory(), false);
        composeEnumerationExtras("type", element.getTypeElement(), new CDSHooksResponse.CDSActionTypeCodesVSEnumFactory(), false);
      }
      if (element.hasDescriptionElement()) {
        composeStringCore("description", element.getDescriptionElement(), false);
        composeStringExtras("description", element.getDescriptionElement(), false);
      }
        if (element.hasResource()) {
          open("resource");
          composeResource(element.getResource());
          close();
        }
      if (element.hasResourceIdElement()) {
        composeUrlCore("resourceId", element.getResourceIdElement(), false);
        composeUrlExtras("resourceId", element.getResourceIdElement(), false);
      }
  }

  protected void composeCDSHooksResponseCardsLinksComponent(String name, CDSHooksResponse.CDSHooksResponseCardsLinksComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksResponseCardsLinksComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksResponseCardsLinksComponentProperties(CDSHooksResponse.CDSHooksResponseCardsLinksComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasLabelElement()) {
        composeStringCore("label", element.getLabelElement(), false);
        composeStringExtras("label", element.getLabelElement(), false);
      }
      if (element.hasUrlElement()) {
        composeUrlCore("url", element.getUrlElement(), false);
        composeUrlExtras("url", element.getUrlElement(), false);
      }
      if (element.hasTypeElement()) {
        composeEnumerationCore("type", element.getTypeElement(), new CDSHooksResponse.CDSLinkTypeCodesVSEnumFactory(), false);
        composeEnumerationExtras("type", element.getTypeElement(), new CDSHooksResponse.CDSLinkTypeCodesVSEnumFactory(), false);
      }
      if (element.hasAppContextElement()) {
        composeStringCore("appContext", element.getAppContextElement(), false);
        composeStringExtras("appContext", element.getAppContextElement(), false);
      }
  }

  protected void composeCDSHooksServices(String name, CDSHooksServices element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksServicesProperties(element);
      close();
    }
  }

  protected void composeCDSHooksServicesProperties(CDSHooksServices element) throws IOException {
    composeCDSHooksElementProperties(element);
      if (element.hasServices()) {
        openArray("services");
        for (CDSHooksServices.CDSHooksServicesServicesComponent e : element.getServicesList()) 
          composeCDSHooksServicesServicesComponent(null, e);
        closeArray();
      };
  }

  protected void composeCDSHooksServicesServicesComponent(String name, CDSHooksServices.CDSHooksServicesServicesComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksServicesServicesComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksServicesServicesComponentProperties(CDSHooksServices.CDSHooksServicesServicesComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementProperties(element);
      if (element.hasHookElement()) {
        composeStringCore("hook", element.getHookElement(), false);
        composeStringExtras("hook", element.getHookElement(), false);
      }
      if (element.hasTitleElement()) {
        composeStringCore("title", element.getTitleElement(), false);
        composeStringExtras("title", element.getTitleElement(), false);
      }
      if (element.hasIdElement()) {
        composeCodeCore("id", element.getIdElement(), false);
        composeCodeExtras("id", element.getIdElement(), false);
      }
      if (element.hasDescriptionElement()) {
        composeStringCore("description", element.getDescriptionElement(), false);
        composeStringExtras("description", element.getDescriptionElement(), false);
      }
      if (element.hasUsageRequirementsElement()) {
        composeStringCore("usageRequirements", element.getUsageRequirementsElement(), false);
        composeStringExtras("usageRequirements", element.getUsageRequirementsElement(), false);
      }
      if (element.hasPrefetch()) {
        openArray("prefetch");
        for (CDSHooksServices.CDSHooksServicesServicesPrefetchComponent e : element.getPrefetchList()) 
          composeCDSHooksServicesServicesPrefetchComponent(null, e);
        closeArray();
      };
  }

  protected void composeCDSHooksServicesServicesPrefetchComponent(String name, CDSHooksServices.CDSHooksServicesServicesPrefetchComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeCDSHooksServicesServicesPrefetchComponentProperties(element);
      close();
    }
  }

  protected void composeCDSHooksServicesServicesPrefetchComponentProperties(CDSHooksServices.CDSHooksServicesServicesPrefetchComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasKeyElement()) {
        composeCodeCore("key", element.getKeyElement(), false);
        composeCodeExtras("key", element.getKeyElement(), false);
      }
      if (element.hasValueElement()) {
        composeStringCore("value", element.getValueElement(), false);
        composeStringExtras("value", element.getValueElement(), false);
      }
  }

  protected void composeTestCases(String name, TestCases element) throws IOException {
    if (element != null) {
      prop("resourceType", "TestCases");
      composeTestCasesProperties(element);
    }
  }

  protected void composeTestCasesProperties(TestCases element) throws IOException {
    composeResourceProperties(element);
      if (element.hasUrlElement()) {
        composeUriCore("url", element.getUrlElement(), false);
        composeUriExtras("url", element.getUrlElement(), false);
      }
      if (element.hasVersionElement()) {
        composeStringCore("version", element.getVersionElement(), false);
        composeStringExtras("version", element.getVersionElement(), false);
      }
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasDescriptionElement()) {
        composeMarkdownCore("description", element.getDescriptionElement(), false);
        composeMarkdownExtras("description", element.getDescriptionElement(), false);
      }
      if (element.hasRunnerElement()) {
        composeUrlCore("runner", element.getRunnerElement(), false);
        composeUrlExtras("runner", element.getRunnerElement(), false);
      }
      if (element.hasMode()) {
        openArray("mode");
        for (TestCases.TestCasesModeComponent e : element.getModeList()) 
          composeTestCasesModeComponent(null, e);
        closeArray();
      };
      if (element.hasSuite()) {
        openArray("suite");
        for (TestCases.TestCasesSuiteComponent e : element.getSuiteList()) 
          composeTestCasesSuiteComponent(null, e);
        closeArray();
      };
  }

  protected void composeTestCasesModeComponent(String name, TestCases.TestCasesModeComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeTestCasesModeComponentProperties(element);
      close();
    }
  }

  protected void composeTestCasesModeComponentProperties(TestCases.TestCasesModeComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasCodeElement()) {
        composeStringCore("code", element.getCodeElement(), false);
        composeStringExtras("code", element.getCodeElement(), false);
      }
      if (element.hasDescriptionElement()) {
        composeStringCore("description", element.getDescriptionElement(), false);
        composeStringExtras("description", element.getDescriptionElement(), false);
      }
  }

  protected void composeTestCasesSuiteComponent(String name, TestCases.TestCasesSuiteComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeTestCasesSuiteComponentProperties(element);
      close();
    }
  }

  protected void composeTestCasesSuiteComponentProperties(TestCases.TestCasesSuiteComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasDescriptionElement()) {
        composeStringCore("description", element.getDescriptionElement(), false);
        composeStringExtras("description", element.getDescriptionElement(), false);
      }
      if (element.hasModeElement()) {
        composeCodeCore("mode", element.getModeElement(), false);
        composeCodeExtras("mode", element.getModeElement(), false);
      }
      if (element.hasResource()) {
        openArray("resource");
        for (TestCases.TestCasesSuiteResourceComponent e : element.getResourceList()) 
          composeTestCasesSuiteResourceComponent(null, e);
        closeArray();
      };
      if (element.hasParameter()) {
        openArray("parameter");
        for (TestCases.TestCasesSuiteParameterComponent e : element.getParameterList()) 
          composeTestCasesSuiteParameterComponent(null, e);
        closeArray();
      };
      if (element.hasTest()) {
        openArray("test");
        for (TestCases.TestCasesSuiteTestComponent e : element.getTestList()) 
          composeTestCasesSuiteTestComponent(null, e);
        closeArray();
      };
  }

  protected void composeTestCasesSuiteResourceComponent(String name, TestCases.TestCasesSuiteResourceComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeTestCasesSuiteResourceComponentProperties(element);
      close();
    }
  }

  protected void composeTestCasesSuiteResourceComponentProperties(TestCases.TestCasesSuiteResourceComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasFileElement()) {
        composeStringCore("file", element.getFileElement(), false);
        composeStringExtras("file", element.getFileElement(), false);
      }
        if (element.hasResource()) {
          open("resource");
          composeResource(element.getResource());
          close();
        }
      if (element.hasModeElement()) {
        composeCodeCore("mode", element.getModeElement(), false);
        composeCodeExtras("mode", element.getModeElement(), false);
      }
  }

  protected void composeTestCasesSuiteParameterComponent(String name, TestCases.TestCasesSuiteParameterComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeTestCasesSuiteParameterComponentProperties(element);
      close();
    }
  }

  protected void composeTestCasesSuiteParameterComponentProperties(TestCases.TestCasesSuiteParameterComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasValue()) {
        composeType("value", element.getValue());
      }
      if (element.hasModeElement()) {
        composeCodeCore("mode", element.getModeElement(), false);
        composeCodeExtras("mode", element.getModeElement(), false);
      }
  }

  protected void composeTestCasesSuiteTestComponent(String name, TestCases.TestCasesSuiteTestComponent element) throws IOException {
    if (element != null) {
      open(name);
      composeTestCasesSuiteTestComponentProperties(element);
      close();
    }
  }

  protected void composeTestCasesSuiteTestComponentProperties(TestCases.TestCasesSuiteTestComponent element) throws IOException {
    composeBaseProperties(element);
      if (element.hasNameElement()) {
        composeStringCore("name", element.getNameElement(), false);
        composeStringExtras("name", element.getNameElement(), false);
      }
      if (element.hasDescriptionElement()) {
        composeStringCore("description", element.getDescriptionElement(), false);
        composeStringExtras("description", element.getDescriptionElement(), false);
      }
      if (element.hasOperationElement()) {
        composeCodeCore("operation", element.getOperationElement(), false);
        composeCodeExtras("operation", element.getOperationElement(), false);
      }
      if (element.hasModeElement()) {
        composeStringCore("mode", element.getModeElement(), false);
        composeStringExtras("mode", element.getModeElement(), false);
      }
      if (element.hasParameter()) {
        openArray("parameter");
        for (TestCases.TestCasesSuiteParameterComponent e : element.getParameterList()) 
          composeTestCasesSuiteParameterComponent(null, e);
        closeArray();
      };
      if (element.hasInput()) {
        openArray("input");
        for (TestCases.TestCasesSuiteResourceComponent e : element.getInputList()) 
          composeTestCasesSuiteResourceComponent(null, e);
        closeArray();
      };
      if (element.hasOutput()) {
        openArray("output");
        for (TestCases.TestCasesSuiteResourceComponent e : element.getOutputList()) 
          composeTestCasesSuiteResourceComponent(null, e);
        closeArray();
      };
  }



  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    } else if (resource instanceof TestCases) {
      composeTestCases("TestCases", (TestCases)resource);
 
    } else
      throw new Error("Unhandled resource type "+resource.getClass().getName());
  }

}