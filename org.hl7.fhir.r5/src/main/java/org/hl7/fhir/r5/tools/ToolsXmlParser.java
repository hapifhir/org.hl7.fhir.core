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



import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.formats.*;
import org.xmlpull.v1.*;
import org.hl7.fhir.utilities.xml.IXMLWriter;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.FHIRException;
import java.io.IOException;
import java.util.Enumeration;

public class ToolsXmlParser extends org.hl7.fhir.r5.formats.XmlParser {

  public ToolsXmlParser(boolean allowUnknownContent) {
    super();
    setAllowUnknownContent(allowUnknownContent);
  }

  public ToolsXmlParser(IXMLWriter xml) {
    super();
    this.xml = xml;
  }

  protected boolean parseCDSHookContextContent(int eventType, XmlPullParser xpp, CDSHookContext res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected boolean parseCDSHooksElementContent(int eventType, XmlPullParser xpp, CDSHooksElement res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
      res.setExtension(parseCDSHooksExtensions(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)) { //3 
        return false;
    }
    return true;
  }

  protected CDSHookOrderSelectContext parseCDSHookOrderSelectContext(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHookOrderSelectContext res = new CDSHookOrderSelectContext();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHookOrderSelectContextContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHookOrderSelectContextContent(int eventType, XmlPullParser xpp, CDSHookOrderSelectContext res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("userId")) {
      res.setUserIdElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
      res.setPatientIdElement(parseId(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounterId")) {
      res.setEncounterIdElement(parseId(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("selections")) {
      res.getSelectionsList().add(parseUri(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("draftOrders")) {
      res.setDraftOrders(parseBundle(xpp));
    } else if (!parseCDSHookContextContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHookOrderSignContext parseCDSHookOrderSignContext(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHookOrderSignContext res = new CDSHookOrderSignContext();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHookOrderSignContextContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHookOrderSignContextContent(int eventType, XmlPullParser xpp, CDSHookOrderSignContext res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("userId")) {
      res.setUserIdElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
      res.setPatientIdElement(parseId(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounterId")) {
      res.setEncounterIdElement(parseId(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("draftOrders")) {
      res.setDraftOrders(parseBundle(xpp));
    } else if (!parseCDSHookContextContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHookPatientViewContext parseCDSHookPatientViewContext(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHookPatientViewContext res = new CDSHookPatientViewContext();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHookPatientViewContextContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHookPatientViewContextContent(int eventType, XmlPullParser xpp, CDSHookPatientViewContext res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("userId")) {
      res.setUserIdElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
      res.setPatientIdElement(parseId(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounterId")) {
      res.setEncounterIdElement(parseId(xpp));
    } else if (!parseCDSHookContextContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksExtensions parseCDSHooksExtensions(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksExtensions res = new CDSHooksExtensions();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksExtensionsContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksExtensionsContent(int eventType, XmlPullParser xpp, CDSHooksExtensions res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
    // todo: Named Element Extensions
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

    // todo: Named Element Extensions
  protected CDSHooksRequest parseCDSHooksRequest(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksRequest res = new CDSHooksRequest();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksRequestContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksRequestContent(int eventType, XmlPullParser xpp, CDSHooksRequest res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hook")) {
      res.setHookElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hookInstance")) {
      res.setHookInstanceElement(parseUuid(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("fhirServer")) {
      res.setFhirServerElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("fhirAuthorization")) {
      res.setFhirAuthorization(parseCDSHooksRequestFhirAuthorizationComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("context")) {
      res.setContext(parseCDSHookContext(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prefetch")) {
      res.getPrefetchList().add(parseCDSHooksRequestPrefetchComponent(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHookContext parseCDSHookContext(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    String xsiType = xpp.getAttributeValue("xsi", "type");
    if ("CDSHookPatientViewContext".equals(xsiType)) {
      return parseCDSHookPatientViewContext(xpp);
    }
    if ("CDSHookOrderSignContext".equals(xsiType)) {
      return parseCDSHookOrderSignContext(xpp);
    }
    if ("CDSHookOrderSelectContext".equals(xsiType)) {
      return parseCDSHookOrderSelectContext(xpp);
    }
    throw new FHIRFormatError("Unable to parse CDSHookContext: xsi:type '"+xsiType+"' not known");
  }

  protected CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent parseCDSHooksRequestFhirAuthorizationComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent res = new CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksRequestFhirAuthorizationComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksRequestFhirAuthorizationComponentContent(int eventType, XmlPullParser xpp, CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("accessToken")) {
      res.setAccessTokenElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("tokenType")) {
      res.setTokenTypeElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("expiresIn")) {
      res.setExpiresInElement(parseInteger(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("scope")) {
      res.setScopeElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
      res.setSubjectElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
      res.setPatientElement(parseId(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksRequest.CDSHooksRequestPrefetchComponent parseCDSHooksRequestPrefetchComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksRequest.CDSHooksRequestPrefetchComponent res = new CDSHooksRequest.CDSHooksRequestPrefetchComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksRequestPrefetchComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksRequestPrefetchComponentContent(int eventType, XmlPullParser xpp, CDSHooksRequest.CDSHooksRequestPrefetchComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("key")) {
      res.setKeyElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValue(parseResourceContained(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksResponse parseCDSHooksResponse(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksResponse res = new CDSHooksResponse();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksResponseContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksResponseContent(int eventType, XmlPullParser xpp, CDSHooksResponse res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("cards")) {
      res.getCardsList().add(parseCDSHooksResponseCardsComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("systemActions")) {
      res.getSystemActionsList().add(parseCDSHooksResponseCardsSuggestionsActionsComponent(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksResponse.CDSHooksResponseCardsComponent parseCDSHooksResponseCardsComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsComponent res = new CDSHooksResponse.CDSHooksResponseCardsComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksResponseCardsComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksResponseCardsComponentContent(int eventType, XmlPullParser xpp, CDSHooksResponse.CDSHooksResponseCardsComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uuid")) {
      res.setUuidElement(parseUuid(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("summary")) {
      res.setSummaryElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("detail")) {
      res.setDetailElement(parseMarkdown(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("indicator")) {
      res.setIndicatorElement(parseEnumeration(xpp, CDSHooksResponse.CDSIndicatorCodesVS.NULL, new CDSHooksResponse.CDSIndicatorCodesVSEnumFactory()));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
      res.setSource(parseCDSHooksResponseCardsSourceComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("suggestions")) {
      res.getSuggestionsList().add(parseCDSHooksResponseCardsSuggestionsComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("selectionBehavior")) {
      res.setSelectionBehaviorElement(parseEnumeration(xpp, CDSHooksResponse.CDSSelectionBehaviorCodesVS.NULL, new CDSHooksResponse.CDSSelectionBehaviorCodesVSEnumFactory()));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("overrideReasons")) {
      res.getOverrideReasonsList().add(parseCoding(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("links")) {
      res.getLinksList().add(parseCDSHooksResponseCardsLinksComponent(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksResponse.CDSHooksResponseCardsSourceComponent parseCDSHooksResponseCardsSourceComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsSourceComponent res = new CDSHooksResponse.CDSHooksResponseCardsSourceComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksResponseCardsSourceComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksResponseCardsSourceComponentContent(int eventType, XmlPullParser xpp, CDSHooksResponse.CDSHooksResponseCardsSourceComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("label")) {
      res.setLabelElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
      res.setUrlElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("icon")) {
      res.setIconElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("topic")) {
      res.setTopic(parseCoding(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent parseCDSHooksResponseCardsSuggestionsComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent res = new CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksResponseCardsSuggestionsComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksResponseCardsSuggestionsComponentContent(int eventType, XmlPullParser xpp, CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("label")) {
      res.setLabelElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uuid")) {
      res.setUuidElement(parseUuid(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("isRecommended")) {
      res.setIsRecommendedElement(parseBoolean(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("actions")) {
      res.getActionsList().add(parseCDSHooksResponseCardsSuggestionsActionsComponent(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent parseCDSHooksResponseCardsSuggestionsActionsComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent res = new CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksResponseCardsSuggestionsActionsComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksResponseCardsSuggestionsActionsComponentContent(int eventType, XmlPullParser xpp, CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setTypeElement(parseEnumeration(xpp, CDSHooksResponse.CDSActionTypeCodesVS.NULL, new CDSHooksResponse.CDSActionTypeCodesVSEnumFactory()));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescriptionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
      res.setResource(parseResourceContained(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resourceId")) {
      res.setResourceIdElement(parseUrl(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksResponse.CDSHooksResponseCardsLinksComponent parseCDSHooksResponseCardsLinksComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksResponse.CDSHooksResponseCardsLinksComponent res = new CDSHooksResponse.CDSHooksResponseCardsLinksComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksResponseCardsLinksComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksResponseCardsLinksComponentContent(int eventType, XmlPullParser xpp, CDSHooksResponse.CDSHooksResponseCardsLinksComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("label")) {
      res.setLabelElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
      res.setUrlElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
      res.setTypeElement(parseEnumeration(xpp, CDSHooksResponse.CDSLinkTypeCodesVS.NULL, new CDSHooksResponse.CDSLinkTypeCodesVSEnumFactory()));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("appContext")) {
      res.setAppContextElement(parseString(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksServices parseCDSHooksServices(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksServices res = new CDSHooksServices();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksServicesContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksServicesContent(int eventType, XmlPullParser xpp, CDSHooksServices res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("services")) {
      res.getServicesList().add(parseCDSHooksServicesServicesComponent(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksServices.CDSHooksServicesServicesComponent parseCDSHooksServicesServicesComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksServices.CDSHooksServicesServicesComponent res = new CDSHooksServices.CDSHooksServicesServicesComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksServicesServicesComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksServicesServicesComponentContent(int eventType, XmlPullParser xpp, CDSHooksServices.CDSHooksServicesServicesComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hook")) {
      res.setHookElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
      res.setTitleElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
      res.setIdElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescriptionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("usageRequirements")) {
      res.setUsageRequirementsElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prefetch")) {
      res.getPrefetchList().add(parseCDSHooksServicesServicesPrefetchComponent(xpp));
    } else if (!parseCDSHooksElementContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected CDSHooksServices.CDSHooksServicesServicesPrefetchComponent parseCDSHooksServicesServicesPrefetchComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    CDSHooksServices.CDSHooksServicesServicesPrefetchComponent res = new CDSHooksServices.CDSHooksServicesServicesPrefetchComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseCDSHooksServicesServicesPrefetchComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseCDSHooksServicesServicesPrefetchComponentContent(int eventType, XmlPullParser xpp, CDSHooksServices.CDSHooksServicesServicesPrefetchComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("key")) {
      res.setKeyElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
      res.setValueElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TestCases parseTestCases(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TestCases res = new TestCases();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTestCasesContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTestCasesContent(int eventType, XmlPullParser xpp, TestCases res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
      res.setUrlElement(parseUri(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
      res.setVersionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescriptionElement(parseMarkdown(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("runner")) {
      res.setRunnerElement(parseUrl(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
      res.getModeList().add(parseTestCasesModeComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("suite")) {
      res.getSuiteList().add(parseTestCasesSuiteComponent(xpp));
    } else if (!parseResourceContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TestCases.TestCasesModeComponent parseTestCasesModeComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TestCases.TestCasesModeComponent res = new TestCases.TestCasesModeComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTestCasesModeComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTestCasesModeComponentContent(int eventType, XmlPullParser xpp, TestCases.TestCasesModeComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
      res.setCodeElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescriptionElement(parseString(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TestCases.TestCasesSuiteComponent parseTestCasesSuiteComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TestCases.TestCasesSuiteComponent res = new TestCases.TestCasesSuiteComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTestCasesSuiteComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTestCasesSuiteComponentContent(int eventType, XmlPullParser xpp, TestCases.TestCasesSuiteComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescriptionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
      res.setModeElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
      res.getResourceList().add(parseTestCasesSuiteResourceComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("parameter")) {
      res.getParameterList().add(parseTestCasesSuiteParameterComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("test")) {
      res.getTestList().add(parseTestCasesSuiteTestComponent(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TestCases.TestCasesSuiteResourceComponent parseTestCasesSuiteResourceComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TestCases.TestCasesSuiteResourceComponent res = new TestCases.TestCasesSuiteResourceComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTestCasesSuiteResourceComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTestCasesSuiteResourceComponentContent(int eventType, XmlPullParser xpp, TestCases.TestCasesSuiteResourceComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("file")) {
      res.setFileElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
      res.setResource(parseResourceContained(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
      res.setModeElement(parseCode(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TestCases.TestCasesSuiteParameterComponent parseTestCasesSuiteParameterComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TestCases.TestCasesSuiteParameterComponent res = new TestCases.TestCasesSuiteParameterComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTestCasesSuiteParameterComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTestCasesSuiteParameterComponentContent(int eventType, XmlPullParser xpp, TestCases.TestCasesSuiteParameterComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
      res.setValue(parseType("value", xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
      res.setModeElement(parseCode(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }

  protected TestCases.TestCasesSuiteTestComponent parseTestCasesSuiteTestComponent(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    TestCases.TestCasesSuiteTestComponent res = new TestCases.TestCasesSuiteTestComponent();
    next(xpp);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
    if (!parseTestCasesSuiteTestComponentContent(eventType, xpp, res)) // 1
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    next(xpp);
    parseElementClose(res);
    return res;
  }

  protected boolean parseTestCasesSuiteTestComponentContent(int eventType, XmlPullParser xpp, TestCases.TestCasesSuiteTestComponent res) throws XmlPullParserException, IOException, FHIRFormatError {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
      res.setNameElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
      res.setDescriptionElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("operation")) {
      res.setOperationElement(parseCode(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
      res.setModeElement(parseString(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("parameter")) {
      res.getParameterList().add(parseTestCasesSuiteParameterComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("input")) {
      res.getInputList().add(parseTestCasesSuiteResourceComponent(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("output")) {
      res.getOutputList().add(parseTestCasesSuiteResourceComponent(xpp));
    } else if (!parseBaseContent(eventType, xpp, res)){ //2
      return false;
    }
    return true;
  }


  
  @Override
  protected Resource parseResource(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (xpp.getName().equals("TestCases")) {
      return parseTestCases(xpp);

    } else {
      throw new FHIRFormatError("Unknown resource type "+xpp.getName()+"");
    }
  }

  protected DataType parseType(String prefix, XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {
    if (prefix == null) {
      throw new IOException("prefix == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (xpp.getName().equals(prefix+"Date")) {
      return parseDate(xpp);
    } else if (xpp.getName().equals(prefix+"DateTime")) {
      return parseDateTime(xpp);
    } else if (xpp.getName().equals(prefix+"Code")) {
      return parseCode(xpp);
    } else if (xpp.getName().equals(prefix+"String")) {
      return parseString(xpp);
    } else if (xpp.getName().equals(prefix+"Integer")) {
      return parseInteger(xpp);
    } else if (xpp.getName().equals(prefix+"Integer64")) {
      return parseInteger64(xpp);
    } else if (xpp.getName().equals(prefix+"Oid")) {
      return parseOid(xpp);
    } else if (xpp.getName().equals(prefix+"Canonical")) {
      return parseCanonical(xpp);
    } else if (xpp.getName().equals(prefix+"Uri")) {
      return parseUri(xpp);
    } else if (xpp.getName().equals(prefix+"Uuid")) {
      return parseUuid(xpp);
    } else if (xpp.getName().equals(prefix+"Url")) {
      return parseUrl(xpp);
    } else if (xpp.getName().equals(prefix+"Instant")) {
      return parseInstant(xpp);
    } else if (xpp.getName().equals(prefix+"Boolean")) {
      return parseBoolean(xpp);
    } else if (xpp.getName().equals(prefix+"Base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (xpp.getName().equals(prefix+"UnsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (xpp.getName().equals(prefix+"Markdown")) {
      return parseMarkdown(xpp);
    } else if (xpp.getName().equals(prefix+"Time")) {
      return parseTime(xpp);
    } else if (xpp.getName().equals(prefix+"Id")) {
      return parseId(xpp);
    } else if (xpp.getName().equals(prefix+"PositiveInt")) {
      return parsePositiveInt(xpp);
    } else if (xpp.getName().equals(prefix+"Decimal")) {
      return parseDecimal(xpp);

    } else {
      throw new FHIRFormatError("Unknown type "+xpp.getName());
    }
  }

  protected DataType parseType(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    if (type == null) {
      throw new IOException("type == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (type.equals("date")) {
      return parseDate(xpp);
    } else if (type.equals("dateTime")) {
      return parseDateTime(xpp);
    } else if (type.equals("code")) {
      return parseCode(xpp);
    } else if (type.equals("string")) {
      return parseString(xpp);
    } else if (type.equals("integer")) {
      return parseInteger(xpp);
    } else if (type.equals("integer64")) {
      return parseInteger64(xpp);
    } else if (type.equals("oid")) {
      return parseOid(xpp);
    } else if (type.equals("canonical")) {
      return parseCanonical(xpp);
    } else if (type.equals("uri")) {
      return parseUri(xpp);
    } else if (type.equals("uuid")) {
      return parseUuid(xpp);
    } else if (type.equals("url")) {
      return parseUrl(xpp);
    } else if (type.equals("instant")) {
      return parseInstant(xpp);
    } else if (type.equals("boolean")) {
      return parseBoolean(xpp);
    } else if (type.equals("base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (type.equals("unsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (type.equals("markdown")) {
      return parseMarkdown(xpp);
    } else if (type.equals("time")) {
      return parseTime(xpp);
    } else if (type.equals("id")) {
      return parseId(xpp);
    } else if (type.equals("positiveInt")) {
      return parsePositiveInt(xpp);
    } else if (type.equals("decimal")) {
      return parseDecimal(xpp);

    } else {
      throw new FHIRFormatError("Unknown type "+type);
    }
  }

  public Base parseFragment(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    if (type == null) {
      throw new IOException("type == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (type.equals("CDSHookOrderSelectContext")) {
      return parseCDSHookOrderSelectContext(xpp);
    } else if (type.equals("CDSHookOrderSignContext")) {
      return parseCDSHookOrderSignContext(xpp);
    } else if (type.equals("CDSHookPatientViewContext")) {
      return parseCDSHookPatientViewContext(xpp);
    } else if (type.equals("CDSHooksExtensions")) {
      return parseCDSHooksExtensions(xpp);
    } else if (type.equals("CDSHooksRequest")) {
      return parseCDSHooksRequest(xpp);
    } else if (type.equals("CDSHooksResponse")) {
      return parseCDSHooksResponse(xpp);
    } else if (type.equals("CDSHooksServices")) {
      return parseCDSHooksServices(xpp);
    } else if (type.equals("TestCases")) {
      return parseTestCases(xpp);
      
    } else if (type.equals("date")) {
      return parseDate(xpp);
    } else if (type.equals("dateTime")) {
      return parseDateTime(xpp);
    } else if (type.equals("code")) {
      return parseCode(xpp);
    } else if (type.equals("string")) {
      return parseString(xpp);
    } else if (type.equals("integer")) {
      return parseInteger(xpp);
    } else if (type.equals("integer64")) {
      return parseInteger64(xpp);
    } else if (type.equals("oid")) {
      return parseOid(xpp);
    } else if (type.equals("canonical")) {
      return parseCanonical(xpp);
    } else if (type.equals("uri")) {
      return parseUri(xpp);
    } else if (type.equals("uuid")) {
      return parseUuid(xpp);
    } else if (type.equals("url")) {
      return parseUrl(xpp);
    } else if (type.equals("instant")) {
      return parseInstant(xpp);
    } else if (type.equals("boolean")) {
      return parseBoolean(xpp);
    } else if (type.equals("base64Binary")) {
      return parseBase64Binary(xpp);
    } else if (type.equals("unsignedInt")) {
      return parseUnsignedInt(xpp);
    } else if (type.equals("markdown")) {
      return parseMarkdown(xpp);
    } else if (type.equals("time")) {
      return parseTime(xpp);
    } else if (type.equals("id")) {
      return parseId(xpp);
    } else if (type.equals("positiveInt")) {
      return parsePositiveInt(xpp);
    } else if (type.equals("decimal")) {
      return parseDecimal(xpp);
    } else {
      throw new FHIRFormatError("Unknown type "+type);
    }
  }

  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) throws IOException {  
    if (prefix == null) {
      throw new IOException("prefix == null!");
    } else if (xpp == null) {
      throw new IOException("xpp == null!");
    } else if (xpp.getName().equals(prefix+"CDSHookOrderSelectContext")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CDSHookOrderSignContext")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CDSHookPatientViewContext")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CDSHooksExtensions")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CDSHooksRequest")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CDSHooksResponse")) {
      return true;
    } else if (xpp.getName().equals(prefix+"CDSHooksServices")) {
      return true;
    } else if (xpp.getName().equals(prefix+"TestCases")) {
      return true;

    } else if (xpp.getName().equals(prefix+"Date")) {
      return true;
    } else if (xpp.getName().equals(prefix+"DateTime")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Code")) {
      return true;
    } else if (xpp.getName().equals(prefix+"String")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Integer")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Integer64")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Oid")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Canonical")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Uri")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Uuid")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Url")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Instant")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Boolean")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Base64Binary")) {
      return true;
    } else if (xpp.getName().equals(prefix+"UnsignedInt")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Markdown")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Time")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Id")) {
      return true;
    } else if (xpp.getName().equals(prefix+"PositiveInt")) {
      return true;
    } else if (xpp.getName().equals(prefix+"Decimal")) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  protected DataType parseAnyType(XmlPullParser xpp, String type) throws XmlPullParserException, IOException, FHIRFormatError {
    return parseType(xpp, type);
  }


//----------------- Composer -------------------------------------------------------------------------------------------

  protected void composeCDSHookContextElements(CDSHookContext element) throws IOException {
    composeBaseElements(element);
  }

  protected void composeCDSHooksElementElements(CDSHooksElement element) throws IOException {
    composeBaseElements(element);
    if (element.hasExtension()) {
      composeCDSHooksExtensions("extension", element.getExtension());
    }
  }

  protected void composeCDSHookOrderSelectContext(String name, CDSHookOrderSelectContext element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHookOrderSelectContextElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHookOrderSelectContextElements(CDSHookOrderSelectContext element) throws IOException {
    composeCDSHookContextElements(element);
    if (element.hasUserIdElement()) {
      composeUrl("userId", element.getUserIdElement());
    }
    if (element.hasPatientIdElement()) {
      composeId("patientId", element.getPatientIdElement());
    }
    if (element.hasEncounterIdElement()) {
      composeId("encounterId", element.getEncounterIdElement());
    }
    if (element.hasSelections()) { 
      for (UriType e : element.getSelectionsList()) 
          composeUri("selections", e); // a
    }
    if (element.hasDraftOrders()) {
      composeBundle("draftOrders", element.getDraftOrders());
    }
  }

  protected void composeCDSHookOrderSignContext(String name, CDSHookOrderSignContext element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHookOrderSignContextElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHookOrderSignContextElements(CDSHookOrderSignContext element) throws IOException {
    composeCDSHookContextElements(element);
    if (element.hasUserIdElement()) {
      composeUrl("userId", element.getUserIdElement());
    }
    if (element.hasPatientIdElement()) {
      composeId("patientId", element.getPatientIdElement());
    }
    if (element.hasEncounterIdElement()) {
      composeId("encounterId", element.getEncounterIdElement());
    }
    if (element.hasDraftOrders()) {
      composeBundle("draftOrders", element.getDraftOrders());
    }
  }

  protected void composeCDSHookPatientViewContext(String name, CDSHookPatientViewContext element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHookPatientViewContextElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHookPatientViewContextElements(CDSHookPatientViewContext element) throws IOException {
    composeCDSHookContextElements(element);
    if (element.hasUserIdElement()) {
      composeUrl("userId", element.getUserIdElement());
    }
    if (element.hasPatientIdElement()) {
      composeId("patientId", element.getPatientIdElement());
    }
    if (element.hasEncounterIdElement()) {
      composeId("encounterId", element.getEncounterIdElement());
    }
  }

  protected void composeCDSHooksExtensions(String name, CDSHooksExtensions element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksExtensionsElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksExtensionsElements(CDSHooksExtensions element) throws IOException {
    composeBaseElements(element);
  }

  protected void composeCDSHooksRequest(String name, CDSHooksRequest element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksRequestElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksRequestElements(CDSHooksRequest element) throws IOException {
    composeCDSHooksElementElements(element);
    if (element.hasHookElement()) {
      composeCode("hook", element.getHookElement());
    }
    if (element.hasHookInstanceElement()) {
      composeUuid("hookInstance", element.getHookInstanceElement());
    }
    if (element.hasFhirServerElement()) {
      composeUrl("fhirServer", element.getFhirServerElement());
    }
    if (element.hasFhirAuthorization()) {
      composeCDSHooksRequestFhirAuthorizationComponent("fhirAuthorization", element.getFhirAuthorization());
    }
    if (element.hasContext()) {
      composeCDSHookContext("context", element.getContext());
    }
    if (element.hasPrefetch()) { 
      for (CDSHooksRequest.CDSHooksRequestPrefetchComponent e : element.getPrefetchList()) 
          composeCDSHooksRequestPrefetchComponent("prefetch", e); // a
    }
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
      xml.enter(FHIR_NS, name);
      composeCDSHooksRequestFhirAuthorizationComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksRequestFhirAuthorizationComponentElements(CDSHooksRequest.CDSHooksRequestFhirAuthorizationComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasAccessTokenElement()) {
      composeString("accessToken", element.getAccessTokenElement());
    }
    if (element.hasTokenTypeElement()) {
      composeCode("tokenType", element.getTokenTypeElement());
    }
    if (element.hasExpiresInElement()) {
      composeInteger("expiresIn", element.getExpiresInElement());
    }
    if (element.hasScopeElement()) {
      composeString("scope", element.getScopeElement());
    }
    if (element.hasSubjectElement()) {
      composeString("subject", element.getSubjectElement());
    }
    if (element.hasPatientElement()) {
      composeId("patient", element.getPatientElement());
    }
  }

  protected void composeCDSHooksRequestPrefetchComponent(String name, CDSHooksRequest.CDSHooksRequestPrefetchComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksRequestPrefetchComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksRequestPrefetchComponentElements(CDSHooksRequest.CDSHooksRequestPrefetchComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasKeyElement()) {
      composeCode("key", element.getKeyElement());
    }
    if (element.hasValue()) {
      xml.enter(FHIR_NS, "value");
      composeResource(element.getValue());
      xml.exit(FHIR_NS, "value");
    }
  }

  protected void composeCDSHooksResponse(String name, CDSHooksResponse element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksResponseElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksResponseElements(CDSHooksResponse element) throws IOException {
    composeCDSHooksElementElements(element);
    if (element.hasCards()) { 
      for (CDSHooksResponse.CDSHooksResponseCardsComponent e : element.getCardsList()) 
          composeCDSHooksResponseCardsComponent("cards", e); // a
    }
    if (element.hasSystemActions()) { 
      for (CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent e : element.getSystemActionsList()) 
          composeCDSHooksResponseCardsSuggestionsActionsComponent("systemActions", e); // a
    }
  }

  protected void composeCDSHooksResponseCardsComponent(String name, CDSHooksResponse.CDSHooksResponseCardsComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksResponseCardsComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksResponseCardsComponentElements(CDSHooksResponse.CDSHooksResponseCardsComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasUuidElement()) {
      composeUuid("uuid", element.getUuidElement());
    }
    if (element.hasSummaryElement()) {
      composeString("summary", element.getSummaryElement());
    }
    if (element.hasDetailElement()) {
      composeMarkdown("detail", element.getDetailElement());
    }
    if (element.hasIndicatorElement())
      composeEnumeration("indicator", element.getIndicatorElement(), new CDSHooksResponse.CDSIndicatorCodesVSEnumFactory());
    if (element.hasSource()) {
      composeCDSHooksResponseCardsSourceComponent("source", element.getSource());
    }
    if (element.hasSuggestions()) { 
      for (CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent e : element.getSuggestionsList()) 
          composeCDSHooksResponseCardsSuggestionsComponent("suggestions", e); // a
    }
    if (element.hasSelectionBehaviorElement())
      composeEnumeration("selectionBehavior", element.getSelectionBehaviorElement(), new CDSHooksResponse.CDSSelectionBehaviorCodesVSEnumFactory());
    if (element.hasOverrideReasons()) { 
      for (Coding e : element.getOverrideReasonsList()) 
          composeCoding("overrideReasons", e); // a
    }
    if (element.hasLinks()) { 
      for (CDSHooksResponse.CDSHooksResponseCardsLinksComponent e : element.getLinksList()) 
          composeCDSHooksResponseCardsLinksComponent("links", e); // a
    }
  }

  protected void composeCDSHooksResponseCardsSourceComponent(String name, CDSHooksResponse.CDSHooksResponseCardsSourceComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksResponseCardsSourceComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksResponseCardsSourceComponentElements(CDSHooksResponse.CDSHooksResponseCardsSourceComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasLabelElement()) {
      composeString("label", element.getLabelElement());
    }
    if (element.hasUrlElement()) {
      composeUrl("url", element.getUrlElement());
    }
    if (element.hasIconElement()) {
      composeUrl("icon", element.getIconElement());
    }
    if (element.hasTopic()) {
      composeCoding("topic", element.getTopic());
    }
  }

  protected void composeCDSHooksResponseCardsSuggestionsComponent(String name, CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksResponseCardsSuggestionsComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksResponseCardsSuggestionsComponentElements(CDSHooksResponse.CDSHooksResponseCardsSuggestionsComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasLabelElement()) {
      composeString("label", element.getLabelElement());
    }
    if (element.hasUuidElement()) {
      composeUuid("uuid", element.getUuidElement());
    }
    if (element.hasIsRecommendedElement()) {
      composeBoolean("isRecommended", element.getIsRecommendedElement());
    }
    if (element.hasActions()) { 
      for (CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent e : element.getActionsList()) 
          composeCDSHooksResponseCardsSuggestionsActionsComponent("actions", e); // a
    }
  }

  protected void composeCDSHooksResponseCardsSuggestionsActionsComponent(String name, CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksResponseCardsSuggestionsActionsComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksResponseCardsSuggestionsActionsComponentElements(CDSHooksResponse.CDSHooksResponseCardsSuggestionsActionsComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasTypeElement())
      composeEnumeration("type", element.getTypeElement(), new CDSHooksResponse.CDSActionTypeCodesVSEnumFactory());
    if (element.hasDescriptionElement()) {
      composeString("description", element.getDescriptionElement());
    }
    if (element.hasResource()) {
      xml.enter(FHIR_NS, "resource");
      composeResource(element.getResource());
      xml.exit(FHIR_NS, "resource");
    }
    if (element.hasResourceIdElement()) {
      composeUrl("resourceId", element.getResourceIdElement());
    }
  }

  protected void composeCDSHooksResponseCardsLinksComponent(String name, CDSHooksResponse.CDSHooksResponseCardsLinksComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksResponseCardsLinksComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksResponseCardsLinksComponentElements(CDSHooksResponse.CDSHooksResponseCardsLinksComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasLabelElement()) {
      composeString("label", element.getLabelElement());
    }
    if (element.hasUrlElement()) {
      composeUrl("url", element.getUrlElement());
    }
    if (element.hasTypeElement())
      composeEnumeration("type", element.getTypeElement(), new CDSHooksResponse.CDSLinkTypeCodesVSEnumFactory());
    if (element.hasAppContextElement()) {
      composeString("appContext", element.getAppContextElement());
    }
  }

  protected void composeCDSHooksServices(String name, CDSHooksServices element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksServicesElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksServicesElements(CDSHooksServices element) throws IOException {
    composeCDSHooksElementElements(element);
    if (element.hasServices()) { 
      for (CDSHooksServices.CDSHooksServicesServicesComponent e : element.getServicesList()) 
          composeCDSHooksServicesServicesComponent("services", e); // a
    }
  }

  protected void composeCDSHooksServicesServicesComponent(String name, CDSHooksServices.CDSHooksServicesServicesComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksServicesServicesComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksServicesServicesComponentElements(CDSHooksServices.CDSHooksServicesServicesComponent element) throws IOException {
    composehttp://hl7.org/fhir/tools/StructureDefinition/CDSHooksElementElements(element);
    if (element.hasHookElement()) {
      composeString("hook", element.getHookElement());
    }
    if (element.hasTitleElement()) {
      composeString("title", element.getTitleElement());
    }
    if (element.hasIdElement()) {
      composeCode("id", element.getIdElement());
    }
    if (element.hasDescriptionElement()) {
      composeString("description", element.getDescriptionElement());
    }
    if (element.hasUsageRequirementsElement()) {
      composeString("usageRequirements", element.getUsageRequirementsElement());
    }
    if (element.hasPrefetch()) { 
      for (CDSHooksServices.CDSHooksServicesServicesPrefetchComponent e : element.getPrefetchList()) 
          composeCDSHooksServicesServicesPrefetchComponent("prefetch", e); // a
    }
  }

  protected void composeCDSHooksServicesServicesPrefetchComponent(String name, CDSHooksServices.CDSHooksServicesServicesPrefetchComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeCDSHooksServicesServicesPrefetchComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeCDSHooksServicesServicesPrefetchComponentElements(CDSHooksServices.CDSHooksServicesServicesPrefetchComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasKeyElement()) {
      composeCode("key", element.getKeyElement());
    }
    if (element.hasValueElement()) {
      composeString("value", element.getValueElement());
    }
  }

  protected void composeTestCases(String name, TestCases element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTestCasesElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTestCasesElements(TestCases element) throws IOException {
    composeResourceElements(element);
    if (element.hasUrlElement()) {
      composeUri("url", element.getUrlElement());
    }
    if (element.hasVersionElement()) {
      composeString("version", element.getVersionElement());
    }
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasDescriptionElement()) {
      composeMarkdown("description", element.getDescriptionElement());
    }
    if (element.hasRunnerElement()) {
      composeUrl("runner", element.getRunnerElement());
    }
    if (element.hasMode()) { 
      for (TestCases.TestCasesModeComponent e : element.getModeList()) 
          composeTestCasesModeComponent("mode", e); // a
    }
    if (element.hasSuite()) { 
      for (TestCases.TestCasesSuiteComponent e : element.getSuiteList()) 
          composeTestCasesSuiteComponent("suite", e); // a
    }
  }

  protected void composeTestCasesModeComponent(String name, TestCases.TestCasesModeComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTestCasesModeComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTestCasesModeComponentElements(TestCases.TestCasesModeComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasCodeElement()) {
      composeString("code", element.getCodeElement());
    }
    if (element.hasDescriptionElement()) {
      composeString("description", element.getDescriptionElement());
    }
  }

  protected void composeTestCasesSuiteComponent(String name, TestCases.TestCasesSuiteComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTestCasesSuiteComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTestCasesSuiteComponentElements(TestCases.TestCasesSuiteComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasDescriptionElement()) {
      composeString("description", element.getDescriptionElement());
    }
    if (element.hasModeElement()) {
      composeCode("mode", element.getModeElement());
    }
    if (element.hasResource()) { 
      for (TestCases.TestCasesSuiteResourceComponent e : element.getResourceList()) 
          composeTestCasesSuiteResourceComponent("resource", e); // a
    }
    if (element.hasParameter()) { 
      for (TestCases.TestCasesSuiteParameterComponent e : element.getParameterList()) 
          composeTestCasesSuiteParameterComponent("parameter", e); // a
    }
    if (element.hasTest()) { 
      for (TestCases.TestCasesSuiteTestComponent e : element.getTestList()) 
          composeTestCasesSuiteTestComponent("test", e); // a
    }
  }

  protected void composeTestCasesSuiteResourceComponent(String name, TestCases.TestCasesSuiteResourceComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTestCasesSuiteResourceComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTestCasesSuiteResourceComponentElements(TestCases.TestCasesSuiteResourceComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasFileElement()) {
      composeString("file", element.getFileElement());
    }
    if (element.hasResource()) {
      xml.enter(FHIR_NS, "resource");
      composeResource(element.getResource());
      xml.exit(FHIR_NS, "resource");
    }
    if (element.hasModeElement()) {
      composeCode("mode", element.getModeElement());
    }
  }

  protected void composeTestCasesSuiteParameterComponent(String name, TestCases.TestCasesSuiteParameterComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTestCasesSuiteParameterComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTestCasesSuiteParameterComponentElements(TestCases.TestCasesSuiteParameterComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasValue()) {
      composeType("value", element.getValue());
    }    if (element.hasModeElement()) {
      composeCode("mode", element.getModeElement());
    }
  }

  protected void composeTestCasesSuiteTestComponent(String name, TestCases.TestCasesSuiteTestComponent element) throws IOException {
    if (element != null) {
      xml.enter(FHIR_NS, name);
      composeTestCasesSuiteTestComponentElements(element);
      composeElementClose(element);
      xml.exit(FHIR_NS, name);
    }
  }

  protected void composeTestCasesSuiteTestComponentElements(TestCases.TestCasesSuiteTestComponent element) throws IOException {
    composeBaseElements(element);
    if (element.hasNameElement()) {
      composeString("name", element.getNameElement());
    }
    if (element.hasDescriptionElement()) {
      composeString("description", element.getDescriptionElement());
    }
    if (element.hasOperationElement()) {
      composeCode("operation", element.getOperationElement());
    }
    if (element.hasModeElement()) {
      composeString("mode", element.getModeElement());
    }
    if (element.hasParameter()) { 
      for (TestCases.TestCasesSuiteParameterComponent e : element.getParameterList()) 
          composeTestCasesSuiteParameterComponent("parameter", e); // a
    }
    if (element.hasInput()) { 
      for (TestCases.TestCasesSuiteResourceComponent e : element.getInputList()) 
          composeTestCasesSuiteResourceComponent("input", e); // a
    }
    if (element.hasOutput()) { 
      for (TestCases.TestCasesSuiteResourceComponent e : element.getOutputList()) 
          composeTestCasesSuiteResourceComponent("output", e); // a
    }
  }



  @Override
  protected void composeResource(Resource resource) throws IOException {
    if (resource == null) {
      throw new IOException("resource == null");
    } else if (resource instanceof TestCases) {
      composeTestCases("TestCases", (TestCases)resource);
      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeResource(String name, Resource resource) throws IOException {
    if (name == null) {
      throw new IOException("name == null");
    } else if (resource == null) {
      throw new IOException("resource == null");
    } else if (resource instanceof TestCases) {
      composeTestCases(name, (TestCases)resource);
      
    } else {
      throw new Error("Unhandled resource type "+resource.getClass().getName());
    }
  }

  protected void composeType(String prefix, DataType type) throws IOException {
    if (prefix == null) {
      throw new IOException("prefix == null");
    } else if (type == null) {
      throw new IOException("type == null");

    } else if (type instanceof CodeType) {
       composeCode(prefix+"Code", (CodeType) type);
    } else if (type instanceof OidType) {
       composeOid(prefix+"Oid", (OidType) type);
    } else if (type instanceof CanonicalType) {
       composeCanonical(prefix+"Canonical", (CanonicalType) type);
    } else if (type instanceof UuidType) {
       composeUuid(prefix+"Uuid", (UuidType) type);
    } else if (type instanceof UrlType) {
       composeUrl(prefix+"Url", (UrlType) type);
    } else if (type instanceof UnsignedIntType) {
       composeUnsignedInt(prefix+"UnsignedInt", (UnsignedIntType) type);
    } else if (type instanceof MarkdownType) {
       composeMarkdown(prefix+"Markdown", (MarkdownType) type);
    } else if (type instanceof IdType) {
       composeId(prefix+"Id", (IdType) type);
    } else if (type instanceof PositiveIntType) {
       composePositiveInt(prefix+"PositiveInt", (PositiveIntType) type);
    } else if (type instanceof DateType) {
       composeDate(prefix+"Date", (DateType) type);
    } else if (type instanceof DateTimeType) {
       composeDateTime(prefix+"DateTime", (DateTimeType) type);
    } else if (type instanceof StringType) {
       composeString(prefix+"String", (StringType) type);
    } else if (type instanceof IntegerType) {
      composeInteger(prefix+"Integer", (IntegerType) type);
    } else if (type instanceof Integer64Type) {
      composeInteger64(prefix+"Integer64", (Integer64Type) type);
    } else if (type instanceof UriType) {
       composeUri(prefix+"Uri", (UriType) type);
    } else if (type instanceof InstantType) {
       composeInstant(prefix+"Instant", (InstantType) type);
    } else if (type instanceof BooleanType) {
       composeBoolean(prefix+"Boolean", (BooleanType) type);
    } else if (type instanceof Base64BinaryType) {
       composeBase64Binary(prefix+"Base64Binary", (Base64BinaryType) type);
    } else if (type instanceof TimeType) {
       composeTime(prefix+"Time", (TimeType) type);
    } else if (type instanceof DecimalType) {
       composeDecimal(prefix+"Decimal", (DecimalType) type);
    } else {
      throw new Error("Unhandled type "+type.fhirType());
    }
  }

}