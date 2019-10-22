package org.hl7.fhir.r5.model.codesystems;

/*
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

// Generated on Thu, Oct 17, 2019 09:42+1100 for FHIR v4.1.0


import org.hl7.fhir.exceptions.FHIRException;

public enum SafetyEntries {

        /**
         * For each resource that my system handles, my system handles the full [Life cycle](lifecycle.html) (status codes, currency issues, and erroneous entry status)
         */
        LIFECYCLE, 
        /**
         * For each resource that my system handles, I've reviewed the [Modifier elements](conformance-rules.html#isModifier)
         */
        MODIFIERS, 
        /**
         * My system checks for [modifierExtension](extensibility.html#modifierExtension) elements
         */
        MODIFIEREXTENSIONS, 
        /**
         * My system supports [elements labeled as 'MustSupport'](conformance-rules.html#mustSupport) in the [profiles](profiling.html) that apply to my system
         */
        MUSTSUPPORT, 
        /**
         * My system has documented how [distributed resource identification](managing.html#distributed) works in its relevant contexts of use, and where (and why) [contained](references.html#contained) resources are used
         */
        IDENTITY, 
        /**
         * My system manages lists of [current resources](lifecycle.html#current) correctly
         */
        CURRENT, 
        /**
         * When other systems [return http errors from the RESTful API](http.html#summary) and [Operations](operations.html) (perhaps using [Operation Outcome](operationoutcome.html)), my system checks for them and handles them appropriately 
         */
        ERRORCHECKS, 
        /**
         * My system ensures checks for patient links (and/or merges) and handles data that is linked to patients accordingly
         */
        LINKMERGE, 
        /**
         * My system publishes a [Capability Statement](capabilitystatement.html) with [StructureDefinitions](structuredefinition.html), [ValueSets](valueset.html), and [OperationDefinitions](operationdefinition.html), etc., so other implementers know how the system functions
         */
        CSDECLARE, 
        /**
         * All resources in use are [valid](validation.html) against the base specification and the [profiles](profiling.html) that apply to my system (see note about the [correct run-time use of validation](validation.html#correct-use))
         */
        VALIDCHECKED, 
        /**
         * I've reviewed the [Observation](observation.html) resource, and understand how ```focus``` is a mechanism for observations to be about someone or something other than the patient or subject of record.
         */
        OBSFOCUS, 
        /**
         * My system checks for time zones and adjusts times appropriately. (note: time zones are extremely difficult to get correct - see [W3C Timezone Advice](https://www.w3.org/TR/timezone/), and note that some fields should be timezone corrected, and others should not be)
         */
        TIMEZONE, 
        /**
         * My system renders dates safely for changes in culture and language (the date formats D-M-Y and M-D-Y are not differentiated for many dates, and this is a well-known source of confusion. Systems should use the month name, or otherwise be specific for each date when rendering, unless there is solid confidence that such confusion cannot arise, even in the future when information/narrative from resources will be shared much more widely)
         */
        DATERENDERING, 
        /**
         * My system takes care to ensure that clients can (for servers) or will (for clients) find the information they need when content that might reasonably be exposed using more than one FHIR resource. Possible patterns: Support a single search across the applicable resources, or expose data through each applicable resource. See discussion on [Wiki Page](https://confluence.hl7.org/display/FHIR/Managing+Overlap+Between+Resources) for further information
         */
        CROSSRESOURCE, 
        /**
         * My system will display warnings returned by the server to the user
         */
        DISPLAYWARNINGS, 
        /**
         * My system checks whether the server processed all the requested search parameter, and is safe if servers ignore parameters (typically, either filters locally or warns the user)
         */
        SEARCHPARAMETERS, 
        /**
         * My system caters for [parameters that have missing values](search.html#missing) when doing search operations, and responds correctly to the client with regard to [erroneous search parameters](search.html#errors)
         */
        MISSINGVALUES, 
        /**
         * My system includes appropriate default filters when searching based on patient context - e.g. filtering out entered-in-error records, filtering to only include active, living patients if appropriate, and clearly documents these (preferably including them in the self link for a search
         */
        DEFAULTFILTERS, 
        /**
         * For each resource, I have checked whether resources can be deleted, and/or how records are marked as incorrect/no longer relevant
         */
        DELETIONCHECK, 
        /**
         * Deletion of records (or equivalent updates in status) flow through the system so any replicated copies are deleted/updated
         */
        DELETIONREPLICATION, 
        /**
         * (If a server) my documentation about deleted resources is clear, and my test sandbox (if exists) has deleted/error record cases in the test data
         */
        DELETIONSUPPORT, 
        /**
         * My system checks that the right [Patient consent](consent.html) has been granted (where applicable)
         */
        CHECKCONSENT, 
        /**
         * My system sends an [Accounting of Disclosure](secpriv-module.html#AoD) to the consenter as requested when permitted actions on resources are performed using an [AuditEvent](auditevent.html) Resource
         */
        DISTRIBUTEAOD, 
        /**
         * My system ensures that system clocks are synchronized using a protocol like NTP or SNTP, or my server is robust against clients that have the wrong clock set
         */
        CHECKCLOCKS, 
        /**
         * My system uses security methods for an API to authenticate where Domain Name System (DNS) responses are coming from and ensure that they are valid
         */
        CHECKDNSRESPONSES, 
        /**
         * Production exchange of patient or other sensitive data will always use some form of [encryption on the wire](security.html#http)
         */
        USEENCRYPTION, 
        /**
         * Where resources are exchanged using [HTTP](security.html#http), [TLS](https://en.wikipedia.org/wiki/Transport_Layer_Security) should be utilized to protect the communications channel
         */
        USETLS, 
        /**
         * Where resources are exchanged using email, [S/MIME](https://en.wikipedia.org/wiki/S/MIME) should be used to protect the end-to-end communication
         */
        USESMIME, 
        /**
         * Production exchange should utilize recommendations for [Best-Current-Practice on TLS in BCP 195](https://tools.ietf.org/html/bcp195)
         */
        USETLSPERBCP195, 
        /**
         * My system utilizes a risk and use case [appropriate OAuth profile](security.html#oauth) (preferably [Smart App Launch](http://hl7.org/fhir/smart-app-launch)), with a [clear policy on authentication strength](security.html#authentication)
         */
        USEOUATH, 
        /**
         * My system uses [OpenID Connect](https://openid.net/connect/) (or other suitable authentication protocol) to verify identity of end user, where it is necessary that end-users be identified to the client application, and has a clear policy on [identity proofing](secpriv-module.html#user)
         */
        USEOPENIDCONNECT, 
        /**
         * My system applies appropriate access control to every request, using a combination of requester’s clearance (ABAC) and/or roles (RBAC)
         */
        USERBAC, 
        /**
         * My system considers [security labels](security-labels.html) on the affected resources when making access control decisions 
         */
        USELABELS, 
        /**
         * My system can [render narratives properly](narrative.html#css) and [securely](security.html#narrative)(where they are used)
         */
        RENDERNARRATIVES, 
        /**
         * My system [validates all input received](validation.html) (whether in resource format or other) from other actors so that it data is well-formed and does not contain content that would cause unwanted system behavior
         */
        CHECK_VALIDATION, 
        /**
         * My system makes the right [Provenance](provenance.html) statements and [AuditEvent](auditevent.html) logs, and uses the right [security labels](security-labels.html#core) where appropriate
         */
        USEPROVENANCE, 
        /**
         * Server: CORS ([cross-origin resource sharing](http://enable-cors.org/)) is appropriately enabled (many clients are Javascript apps running in a browser)
         */
        ENABLECORS, 
        /**
         * JSON is supported (many clients are Javascript apps running in a browser; XML is inconvenient at best)
         */
        USEJSON, 
        /**
         * JSON is returned correctly when errors happen (clients often don't handle HTML errors well)
         */
        JSONFORERRORS, 
        /**
         * The _format header is supported correctly
         */
        USEFORMATHEADER, 
        /**
         * Errors are trapped and an OperationOutcome returned
         */
        USEOPERATIONOUTCOME, 
        /**
         * added to help the parsers
         */
        NULL;
        public static SafetyEntries fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("life-cycle".equals(codeString))
          return LIFECYCLE;
        if ("modifiers".equals(codeString))
          return MODIFIERS;
        if ("modifier-extensions".equals(codeString))
          return MODIFIEREXTENSIONS;
        if ("must-support".equals(codeString))
          return MUSTSUPPORT;
        if ("identity".equals(codeString))
          return IDENTITY;
        if ("current".equals(codeString))
          return CURRENT;
        if ("error-checks".equals(codeString))
          return ERRORCHECKS;
        if ("link-merge".equals(codeString))
          return LINKMERGE;
        if ("cs-declare".equals(codeString))
          return CSDECLARE;
        if ("valid-checked".equals(codeString))
          return VALIDCHECKED;
        if ("obs-focus".equals(codeString))
          return OBSFOCUS;
        if ("time-zone".equals(codeString))
          return TIMEZONE;
        if ("date-rendering".equals(codeString))
          return DATERENDERING;
        if ("cross-resource".equals(codeString))
          return CROSSRESOURCE;
        if ("display-warnings".equals(codeString))
          return DISPLAYWARNINGS;
        if ("search-parameters".equals(codeString))
          return SEARCHPARAMETERS;
        if ("missing-values".equals(codeString))
          return MISSINGVALUES;
        if ("default-filters".equals(codeString))
          return DEFAULTFILTERS;
        if ("deletion-check".equals(codeString))
          return DELETIONCHECK;
        if ("deletion-replication".equals(codeString))
          return DELETIONREPLICATION;
        if ("deletion-support".equals(codeString))
          return DELETIONSUPPORT;
        if ("check-consent".equals(codeString))
          return CHECKCONSENT;
        if ("distribute-aod".equals(codeString))
          return DISTRIBUTEAOD;
        if ("check-clocks".equals(codeString))
          return CHECKCLOCKS;
        if ("check-dns-responses".equals(codeString))
          return CHECKDNSRESPONSES;
        if ("use-encryption".equals(codeString))
          return USEENCRYPTION;
        if ("use-tls".equals(codeString))
          return USETLS;
        if ("use-smime".equals(codeString))
          return USESMIME;
        if ("use-tls-per-bcp195".equals(codeString))
          return USETLSPERBCP195;
        if ("use-ouath".equals(codeString))
          return USEOUATH;
        if ("use-openidconnect".equals(codeString))
          return USEOPENIDCONNECT;
        if ("use-rbac".equals(codeString))
          return USERBAC;
        if ("use-labels".equals(codeString))
          return USELABELS;
        if ("render-narratives".equals(codeString))
          return RENDERNARRATIVES;
        if ("check=validation".equals(codeString))
          return CHECK_VALIDATION;
        if ("use-provenance".equals(codeString))
          return USEPROVENANCE;
        if ("enable-cors".equals(codeString))
          return ENABLECORS;
        if ("use-json".equals(codeString))
          return USEJSON;
        if ("json-for-errors".equals(codeString))
          return JSONFORERRORS;
        if ("use-format-header".equals(codeString))
          return USEFORMATHEADER;
        if ("use-operation-outcome".equals(codeString))
          return USEOPERATIONOUTCOME;
        throw new FHIRException("Unknown SafetyEntries code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case LIFECYCLE: return "life-cycle";
            case MODIFIERS: return "modifiers";
            case MODIFIEREXTENSIONS: return "modifier-extensions";
            case MUSTSUPPORT: return "must-support";
            case IDENTITY: return "identity";
            case CURRENT: return "current";
            case ERRORCHECKS: return "error-checks";
            case LINKMERGE: return "link-merge";
            case CSDECLARE: return "cs-declare";
            case VALIDCHECKED: return "valid-checked";
            case OBSFOCUS: return "obs-focus";
            case TIMEZONE: return "time-zone";
            case DATERENDERING: return "date-rendering";
            case CROSSRESOURCE: return "cross-resource";
            case DISPLAYWARNINGS: return "display-warnings";
            case SEARCHPARAMETERS: return "search-parameters";
            case MISSINGVALUES: return "missing-values";
            case DEFAULTFILTERS: return "default-filters";
            case DELETIONCHECK: return "deletion-check";
            case DELETIONREPLICATION: return "deletion-replication";
            case DELETIONSUPPORT: return "deletion-support";
            case CHECKCONSENT: return "check-consent";
            case DISTRIBUTEAOD: return "distribute-aod";
            case CHECKCLOCKS: return "check-clocks";
            case CHECKDNSRESPONSES: return "check-dns-responses";
            case USEENCRYPTION: return "use-encryption";
            case USETLS: return "use-tls";
            case USESMIME: return "use-smime";
            case USETLSPERBCP195: return "use-tls-per-bcp195";
            case USEOUATH: return "use-ouath";
            case USEOPENIDCONNECT: return "use-openidconnect";
            case USERBAC: return "use-rbac";
            case USELABELS: return "use-labels";
            case RENDERNARRATIVES: return "render-narratives";
            case CHECK_VALIDATION: return "check=validation";
            case USEPROVENANCE: return "use-provenance";
            case ENABLECORS: return "enable-cors";
            case USEJSON: return "use-json";
            case JSONFORERRORS: return "json-for-errors";
            case USEFORMATHEADER: return "use-format-header";
            case USEOPERATIONOUTCOME: return "use-operation-outcome";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/safety-entries";
        }
        public String getDefinition() {
          switch (this) {
            case LIFECYCLE: return "For each resource that my system handles, my system handles the full [Life cycle](lifecycle.html) (status codes, currency issues, and erroneous entry status)";
            case MODIFIERS: return "For each resource that my system handles, I've reviewed the [Modifier elements](conformance-rules.html#isModifier)";
            case MODIFIEREXTENSIONS: return "My system checks for [modifierExtension](extensibility.html#modifierExtension) elements";
            case MUSTSUPPORT: return "My system supports [elements labeled as 'MustSupport'](conformance-rules.html#mustSupport) in the [profiles](profiling.html) that apply to my system";
            case IDENTITY: return "My system has documented how [distributed resource identification](managing.html#distributed) works in its relevant contexts of use, and where (and why) [contained](references.html#contained) resources are used";
            case CURRENT: return "My system manages lists of [current resources](lifecycle.html#current) correctly";
            case ERRORCHECKS: return "When other systems [return http errors from the RESTful API](http.html#summary) and [Operations](operations.html) (perhaps using [Operation Outcome](operationoutcome.html)), my system checks for them and handles them appropriately ";
            case LINKMERGE: return "My system ensures checks for patient links (and/or merges) and handles data that is linked to patients accordingly";
            case CSDECLARE: return "My system publishes a [Capability Statement](capabilitystatement.html) with [StructureDefinitions](structuredefinition.html), [ValueSets](valueset.html), and [OperationDefinitions](operationdefinition.html), etc., so other implementers know how the system functions";
            case VALIDCHECKED: return "All resources in use are [valid](validation.html) against the base specification and the [profiles](profiling.html) that apply to my system (see note about the [correct run-time use of validation](validation.html#correct-use))";
            case OBSFOCUS: return "I've reviewed the [Observation](observation.html) resource, and understand how ```focus``` is a mechanism for observations to be about someone or something other than the patient or subject of record.";
            case TIMEZONE: return "My system checks for time zones and adjusts times appropriately. (note: time zones are extremely difficult to get correct - see [W3C Timezone Advice](https://www.w3.org/TR/timezone/), and note that some fields should be timezone corrected, and others should not be)";
            case DATERENDERING: return "My system renders dates safely for changes in culture and language (the date formats D-M-Y and M-D-Y are not differentiated for many dates, and this is a well-known source of confusion. Systems should use the month name, or otherwise be specific for each date when rendering, unless there is solid confidence that such confusion cannot arise, even in the future when information/narrative from resources will be shared much more widely)";
            case CROSSRESOURCE: return "My system takes care to ensure that clients can (for servers) or will (for clients) find the information they need when content that might reasonably be exposed using more than one FHIR resource. Possible patterns: Support a single search across the applicable resources, or expose data through each applicable resource. See discussion on [Wiki Page](https://confluence.hl7.org/display/FHIR/Managing+Overlap+Between+Resources) for further information";
            case DISPLAYWARNINGS: return "My system will display warnings returned by the server to the user";
            case SEARCHPARAMETERS: return "My system checks whether the server processed all the requested search parameter, and is safe if servers ignore parameters (typically, either filters locally or warns the user)";
            case MISSINGVALUES: return "My system caters for [parameters that have missing values](search.html#missing) when doing search operations, and responds correctly to the client with regard to [erroneous search parameters](search.html#errors)";
            case DEFAULTFILTERS: return "My system includes appropriate default filters when searching based on patient context - e.g. filtering out entered-in-error records, filtering to only include active, living patients if appropriate, and clearly documents these (preferably including them in the self link for a search";
            case DELETIONCHECK: return "For each resource, I have checked whether resources can be deleted, and/or how records are marked as incorrect/no longer relevant";
            case DELETIONREPLICATION: return "Deletion of records (or equivalent updates in status) flow through the system so any replicated copies are deleted/updated";
            case DELETIONSUPPORT: return "(If a server) my documentation about deleted resources is clear, and my test sandbox (if exists) has deleted/error record cases in the test data";
            case CHECKCONSENT: return "My system checks that the right [Patient consent](consent.html) has been granted (where applicable)";
            case DISTRIBUTEAOD: return "My system sends an [Accounting of Disclosure](secpriv-module.html#AoD) to the consenter as requested when permitted actions on resources are performed using an [AuditEvent](auditevent.html) Resource";
            case CHECKCLOCKS: return "My system ensures that system clocks are synchronized using a protocol like NTP or SNTP, or my server is robust against clients that have the wrong clock set";
            case CHECKDNSRESPONSES: return "My system uses security methods for an API to authenticate where Domain Name System (DNS) responses are coming from and ensure that they are valid";
            case USEENCRYPTION: return "Production exchange of patient or other sensitive data will always use some form of [encryption on the wire](security.html#http)";
            case USETLS: return "Where resources are exchanged using [HTTP](security.html#http), [TLS](https://en.wikipedia.org/wiki/Transport_Layer_Security) should be utilized to protect the communications channel";
            case USESMIME: return "Where resources are exchanged using email, [S/MIME](https://en.wikipedia.org/wiki/S/MIME) should be used to protect the end-to-end communication";
            case USETLSPERBCP195: return "Production exchange should utilize recommendations for [Best-Current-Practice on TLS in BCP 195](https://tools.ietf.org/html/bcp195)";
            case USEOUATH: return "My system utilizes a risk and use case [appropriate OAuth profile](security.html#oauth) (preferably [Smart App Launch](http://hl7.org/fhir/smart-app-launch)), with a [clear policy on authentication strength](security.html#authentication)";
            case USEOPENIDCONNECT: return "My system uses [OpenID Connect](https://openid.net/connect/) (or other suitable authentication protocol) to verify identity of end user, where it is necessary that end-users be identified to the client application, and has a clear policy on [identity proofing](secpriv-module.html#user)";
            case USERBAC: return "My system applies appropriate access control to every request, using a combination of requester’s clearance (ABAC) and/or roles (RBAC)";
            case USELABELS: return "My system considers [security labels](security-labels.html) on the affected resources when making access control decisions ";
            case RENDERNARRATIVES: return "My system can [render narratives properly](narrative.html#css) and [securely](security.html#narrative)(where they are used)";
            case CHECK_VALIDATION: return "My system [validates all input received](validation.html) (whether in resource format or other) from other actors so that it data is well-formed and does not contain content that would cause unwanted system behavior";
            case USEPROVENANCE: return "My system makes the right [Provenance](provenance.html) statements and [AuditEvent](auditevent.html) logs, and uses the right [security labels](security-labels.html#core) where appropriate";
            case ENABLECORS: return "Server: CORS ([cross-origin resource sharing](http://enable-cors.org/)) is appropriately enabled (many clients are Javascript apps running in a browser)";
            case USEJSON: return "JSON is supported (many clients are Javascript apps running in a browser; XML is inconvenient at best)";
            case JSONFORERRORS: return "JSON is returned correctly when errors happen (clients often don't handle HTML errors well)";
            case USEFORMATHEADER: return "The _format header is supported correctly";
            case USEOPERATIONOUTCOME: return "Errors are trapped and an OperationOutcome returned";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case LIFECYCLE: return "life-cycle";
            case MODIFIERS: return "modifiers";
            case MODIFIEREXTENSIONS: return "modifier-extensions";
            case MUSTSUPPORT: return "must-support";
            case IDENTITY: return "identity";
            case CURRENT: return "current";
            case ERRORCHECKS: return "error-checks";
            case LINKMERGE: return "link-merge";
            case CSDECLARE: return "cs-declare";
            case VALIDCHECKED: return "valid-checked";
            case OBSFOCUS: return "obs-focus";
            case TIMEZONE: return "time-zone";
            case DATERENDERING: return "date-rendering";
            case CROSSRESOURCE: return "cross-resource";
            case DISPLAYWARNINGS: return "display-warnings";
            case SEARCHPARAMETERS: return "search-parameters";
            case MISSINGVALUES: return "missing-values";
            case DEFAULTFILTERS: return "default-filters";
            case DELETIONCHECK: return "deletion-check";
            case DELETIONREPLICATION: return "deletion-replication";
            case DELETIONSUPPORT: return "deletion-support";
            case CHECKCONSENT: return "check-consent";
            case DISTRIBUTEAOD: return "distribute-aod";
            case CHECKCLOCKS: return "check-clocks";
            case CHECKDNSRESPONSES: return "check-dns-responses";
            case USEENCRYPTION: return "use-encryption";
            case USETLS: return "use-tls";
            case USESMIME: return "use-smime";
            case USETLSPERBCP195: return "use-tls-per-bcp195";
            case USEOUATH: return "use-ouath";
            case USEOPENIDCONNECT: return "use-openidconnect";
            case USERBAC: return "use-rbac";
            case USELABELS: return "use-labels";
            case RENDERNARRATIVES: return "render-narratives";
            case CHECK_VALIDATION: return "check=validation";
            case USEPROVENANCE: return "use-provenance";
            case ENABLECORS: return "enable-cors";
            case USEJSON: return "use-json";
            case JSONFORERRORS: return "json-for-errors";
            case USEFORMATHEADER: return "use-format-header";
            case USEOPERATIONOUTCOME: return "use-operation-outcome";
            default: return "?";
          }
    }


}

