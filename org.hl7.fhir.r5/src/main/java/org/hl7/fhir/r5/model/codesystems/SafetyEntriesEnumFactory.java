package org.hl7.fhir.r5.model.codesystems;

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

// Generated on Sun, Jun 30, 2019 16:52-0400 for FHIR v4.1.0


import org.hl7.fhir.r5.model.EnumFactory;

public class SafetyEntriesEnumFactory implements EnumFactory<SafetyEntries> {

  public SafetyEntries fromCode(String codeString) throws IllegalArgumentException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("life-cycle".equals(codeString))
      return SafetyEntries.LIFECYCLE;
    if ("modifiers".equals(codeString))
      return SafetyEntries.MODIFIERS;
    if ("modifier-extensions".equals(codeString))
      return SafetyEntries.MODIFIEREXTENSIONS;
    if ("must-support".equals(codeString))
      return SafetyEntries.MUSTSUPPORT;
    if ("identity".equals(codeString))
      return SafetyEntries.IDENTITY;
    if ("current".equals(codeString))
      return SafetyEntries.CURRENT;
    if ("error-checks".equals(codeString))
      return SafetyEntries.ERRORCHECKS;
    if ("link-merge".equals(codeString))
      return SafetyEntries.LINKMERGE;
    if ("cs-declare".equals(codeString))
      return SafetyEntries.CSDECLARE;
    if ("valid-checked".equals(codeString))
      return SafetyEntries.VALIDCHECKED;
    if ("obs-focus".equals(codeString))
      return SafetyEntries.OBSFOCUS;
    if ("time-zone".equals(codeString))
      return SafetyEntries.TIMEZONE;
    if ("date-rendering".equals(codeString))
      return SafetyEntries.DATERENDERING;
    if ("cross-resource".equals(codeString))
      return SafetyEntries.CROSSRESOURCE;
    if ("display-warnings".equals(codeString))
      return SafetyEntries.DISPLAYWARNINGS;
    if ("search-parameters".equals(codeString))
      return SafetyEntries.SEARCHPARAMETERS;
    if ("missing-values".equals(codeString))
      return SafetyEntries.MISSINGVALUES;
    if ("default-filters".equals(codeString))
      return SafetyEntries.DEFAULTFILTERS;
    if ("deletion-check".equals(codeString))
      return SafetyEntries.DELETIONCHECK;
    if ("deletion-replication".equals(codeString))
      return SafetyEntries.DELETIONREPLICATION;
    if ("deletion-support".equals(codeString))
      return SafetyEntries.DELETIONSUPPORT;
    if ("check-consent".equals(codeString))
      return SafetyEntries.CHECKCONSENT;
    if ("distribute-aod".equals(codeString))
      return SafetyEntries.DISTRIBUTEAOD;
    if ("check-clocks".equals(codeString))
      return SafetyEntries.CHECKCLOCKS;
    if ("check-dns-responses".equals(codeString))
      return SafetyEntries.CHECKDNSRESPONSES;
    if ("use-encryption".equals(codeString))
      return SafetyEntries.USEENCRYPTION;
    if ("use-tls".equals(codeString))
      return SafetyEntries.USETLS;
    if ("use-smime".equals(codeString))
      return SafetyEntries.USESMIME;
    if ("use-tls-per-bcp195".equals(codeString))
      return SafetyEntries.USETLSPERBCP195;
    if ("use-ouath".equals(codeString))
      return SafetyEntries.USEOUATH;
    if ("use-openidconnect".equals(codeString))
      return SafetyEntries.USEOPENIDCONNECT;
    if ("use-rbac".equals(codeString))
      return SafetyEntries.USERBAC;
    if ("use-labels".equals(codeString))
      return SafetyEntries.USELABELS;
    if ("render-narratives".equals(codeString))
      return SafetyEntries.RENDERNARRATIVES;
    if ("check=validation".equals(codeString))
      return SafetyEntries.CHECKVALIDATION;
    if ("use-provenance".equals(codeString))
      return SafetyEntries.USEPROVENANCE;
    if ("enable-cors".equals(codeString))
      return SafetyEntries.ENABLECORS;
    if ("use-json".equals(codeString))
      return SafetyEntries.USEJSON;
    if ("json-for-errors".equals(codeString))
      return SafetyEntries.JSONFORERRORS;
    if ("use-format-header".equals(codeString))
      return SafetyEntries.USEFORMATHEADER;
    if ("use-operation-outcome".equals(codeString))
      return SafetyEntries.USEOPERATIONOUTCOME;
    throw new IllegalArgumentException("Unknown SafetyEntries code '"+codeString+"'");
  }

  public String toCode(SafetyEntries code) {
    if (code == SafetyEntries.LIFECYCLE)
      return "life-cycle";
    if (code == SafetyEntries.MODIFIERS)
      return "modifiers";
    if (code == SafetyEntries.MODIFIEREXTENSIONS)
      return "modifier-extensions";
    if (code == SafetyEntries.MUSTSUPPORT)
      return "must-support";
    if (code == SafetyEntries.IDENTITY)
      return "identity";
    if (code == SafetyEntries.CURRENT)
      return "current";
    if (code == SafetyEntries.ERRORCHECKS)
      return "error-checks";
    if (code == SafetyEntries.LINKMERGE)
      return "link-merge";
    if (code == SafetyEntries.CSDECLARE)
      return "cs-declare";
    if (code == SafetyEntries.VALIDCHECKED)
      return "valid-checked";
    if (code == SafetyEntries.OBSFOCUS)
      return "obs-focus";
    if (code == SafetyEntries.TIMEZONE)
      return "time-zone";
    if (code == SafetyEntries.DATERENDERING)
      return "date-rendering";
    if (code == SafetyEntries.CROSSRESOURCE)
      return "cross-resource";
    if (code == SafetyEntries.DISPLAYWARNINGS)
      return "display-warnings";
    if (code == SafetyEntries.SEARCHPARAMETERS)
      return "search-parameters";
    if (code == SafetyEntries.MISSINGVALUES)
      return "missing-values";
    if (code == SafetyEntries.DEFAULTFILTERS)
      return "default-filters";
    if (code == SafetyEntries.DELETIONCHECK)
      return "deletion-check";
    if (code == SafetyEntries.DELETIONREPLICATION)
      return "deletion-replication";
    if (code == SafetyEntries.DELETIONSUPPORT)
      return "deletion-support";
    if (code == SafetyEntries.CHECKCONSENT)
      return "check-consent";
    if (code == SafetyEntries.DISTRIBUTEAOD)
      return "distribute-aod";
    if (code == SafetyEntries.CHECKCLOCKS)
      return "check-clocks";
    if (code == SafetyEntries.CHECKDNSRESPONSES)
      return "check-dns-responses";
    if (code == SafetyEntries.USEENCRYPTION)
      return "use-encryption";
    if (code == SafetyEntries.USETLS)
      return "use-tls";
    if (code == SafetyEntries.USESMIME)
      return "use-smime";
    if (code == SafetyEntries.USETLSPERBCP195)
      return "use-tls-per-bcp195";
    if (code == SafetyEntries.USEOUATH)
      return "use-ouath";
    if (code == SafetyEntries.USEOPENIDCONNECT)
      return "use-openidconnect";
    if (code == SafetyEntries.USERBAC)
      return "use-rbac";
    if (code == SafetyEntries.USELABELS)
      return "use-labels";
    if (code == SafetyEntries.RENDERNARRATIVES)
      return "render-narratives";
    if (code == SafetyEntries.CHECKVALIDATION)
      return "check=validation";
    if (code == SafetyEntries.USEPROVENANCE)
      return "use-provenance";
    if (code == SafetyEntries.ENABLECORS)
      return "enable-cors";
    if (code == SafetyEntries.USEJSON)
      return "use-json";
    if (code == SafetyEntries.JSONFORERRORS)
      return "json-for-errors";
    if (code == SafetyEntries.USEFORMATHEADER)
      return "use-format-header";
    if (code == SafetyEntries.USEOPERATIONOUTCOME)
      return "use-operation-outcome";
    return "?";
  }

    public String toSystem(SafetyEntries code) {
      return code.getSystem();
      }

}

