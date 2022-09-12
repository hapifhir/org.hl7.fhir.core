package org.hl7.fhir.r5.model;


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

// Generated on Mon, Sep 5, 2022 20:11+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
 */
@ResourceDef(name="TerminologyCapabilities", profile="http://hl7.org/fhir/StructureDefinition/TerminologyCapabilities")
public class TerminologyCapabilities extends CanonicalResource {

    public enum CodeSearchSupport {
        /**
         * The search for code on ValueSet returns ValueSet resources where the code is included in the extensional definition of the ValueSet.
         */
        INCOMPOSE, 
        /**
         * The search for code on ValueSet returns ValueSet resources where the code is contained in the  ValueSet expansion.
         */
        INEXPANSION, 
        /**
         * The search for code on ValueSet returns ValueSet resources where the code is included in the extensional definition or contained in the ValueSet expansion.
         */
        INCOMPOSEOREXPANSION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CodeSearchSupport fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-compose".equals(codeString))
          return INCOMPOSE;
        if ("in-expansion".equals(codeString))
          return INEXPANSION;
        if ("in-compose-or-expansion".equals(codeString))
          return INCOMPOSEOREXPANSION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CodeSearchSupport code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INCOMPOSE: return "in-compose";
            case INEXPANSION: return "in-expansion";
            case INCOMPOSEOREXPANSION: return "in-compose-or-expansion";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INCOMPOSE: return "http://hl7.org/fhir/code-search-support";
            case INEXPANSION: return "http://hl7.org/fhir/code-search-support";
            case INCOMPOSEOREXPANSION: return "http://hl7.org/fhir/code-search-support";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INCOMPOSE: return "The search for code on ValueSet returns ValueSet resources where the code is included in the extensional definition of the ValueSet.";
            case INEXPANSION: return "The search for code on ValueSet returns ValueSet resources where the code is contained in the  ValueSet expansion.";
            case INCOMPOSEOREXPANSION: return "The search for code on ValueSet returns ValueSet resources where the code is included in the extensional definition or contained in the ValueSet expansion.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INCOMPOSE: return "In Compose";
            case INEXPANSION: return "In Expansion";
            case INCOMPOSEOREXPANSION: return "In Compose Or Expansion";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CodeSearchSupportEnumFactory implements EnumFactory<CodeSearchSupport> {
    public CodeSearchSupport fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-compose".equals(codeString))
          return CodeSearchSupport.INCOMPOSE;
        if ("in-expansion".equals(codeString))
          return CodeSearchSupport.INEXPANSION;
        if ("in-compose-or-expansion".equals(codeString))
          return CodeSearchSupport.INCOMPOSEOREXPANSION;
        throw new IllegalArgumentException("Unknown CodeSearchSupport code '"+codeString+"'");
        }
        public Enumeration<CodeSearchSupport> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CodeSearchSupport>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("in-compose".equals(codeString))
          return new Enumeration<CodeSearchSupport>(this, CodeSearchSupport.INCOMPOSE);
        if ("in-expansion".equals(codeString))
          return new Enumeration<CodeSearchSupport>(this, CodeSearchSupport.INEXPANSION);
        if ("in-compose-or-expansion".equals(codeString))
          return new Enumeration<CodeSearchSupport>(this, CodeSearchSupport.INCOMPOSEOREXPANSION);
        throw new FHIRException("Unknown CodeSearchSupport code '"+codeString+"'");
        }
    public String toCode(CodeSearchSupport code) {
      if (code == CodeSearchSupport.INCOMPOSE)
        return "in-compose";
      if (code == CodeSearchSupport.INEXPANSION)
        return "in-expansion";
      if (code == CodeSearchSupport.INCOMPOSEOREXPANSION)
        return "in-compose-or-expansion";
      return "?";
      }
    public String toSystem(CodeSearchSupport code) {
      return code.getSystem();
      }
    }

    public enum CommonLanguages {
        /**
         * 
         */
        AR, 
        /**
         * 
         */
        BN, 
        /**
         * 
         */
        CS, 
        /**
         * 
         */
        DA, 
        /**
         * 
         */
        DE, 
        /**
         * 
         */
        DEAT, 
        /**
         * 
         */
        DECH, 
        /**
         * 
         */
        DEDE, 
        /**
         * 
         */
        EL, 
        /**
         * 
         */
        EN, 
        /**
         * 
         */
        ENAU, 
        /**
         * 
         */
        ENCA, 
        /**
         * 
         */
        ENGB, 
        /**
         * 
         */
        ENIN, 
        /**
         * 
         */
        ENNZ, 
        /**
         * 
         */
        ENSG, 
        /**
         * 
         */
        ENUS, 
        /**
         * 
         */
        ES, 
        /**
         * 
         */
        ESAR, 
        /**
         * 
         */
        ESES, 
        /**
         * 
         */
        ESUY, 
        /**
         * 
         */
        FI, 
        /**
         * 
         */
        FR, 
        /**
         * 
         */
        FRBE, 
        /**
         * 
         */
        FRCH, 
        /**
         * 
         */
        FRFR, 
        /**
         * 
         */
        FRCA, 
        /**
         * 
         */
        FY, 
        /**
         * 
         */
        FYNL, 
        /**
         * 
         */
        HI, 
        /**
         * 
         */
        HR, 
        /**
         * 
         */
        IT, 
        /**
         * 
         */
        ITCH, 
        /**
         * 
         */
        ITIT, 
        /**
         * 
         */
        JA, 
        /**
         * 
         */
        KO, 
        /**
         * 
         */
        NL, 
        /**
         * 
         */
        NLBE, 
        /**
         * 
         */
        NLNL, 
        /**
         * 
         */
        NO, 
        /**
         * 
         */
        NONO, 
        /**
         * 
         */
        PA, 
        /**
         * 
         */
        PL, 
        /**
         * 
         */
        PT, 
        /**
         * 
         */
        PTBR, 
        /**
         * 
         */
        RU, 
        /**
         * 
         */
        RURU, 
        /**
         * 
         */
        SR, 
        /**
         * 
         */
        SRRS, 
        /**
         * 
         */
        SV, 
        /**
         * 
         */
        SVSE, 
        /**
         * 
         */
        TE, 
        /**
         * 
         */
        ZH, 
        /**
         * 
         */
        ZHCN, 
        /**
         * 
         */
        ZHHK, 
        /**
         * 
         */
        ZHSG, 
        /**
         * 
         */
        ZHTW, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CommonLanguages fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ar".equals(codeString))
          return AR;
        if ("bn".equals(codeString))
          return BN;
        if ("cs".equals(codeString))
          return CS;
        if ("da".equals(codeString))
          return DA;
        if ("de".equals(codeString))
          return DE;
        if ("de-AT".equals(codeString))
          return DEAT;
        if ("de-CH".equals(codeString))
          return DECH;
        if ("de-DE".equals(codeString))
          return DEDE;
        if ("el".equals(codeString))
          return EL;
        if ("en".equals(codeString))
          return EN;
        if ("en-AU".equals(codeString))
          return ENAU;
        if ("en-CA".equals(codeString))
          return ENCA;
        if ("en-GB".equals(codeString))
          return ENGB;
        if ("en-IN".equals(codeString))
          return ENIN;
        if ("en-NZ".equals(codeString))
          return ENNZ;
        if ("en-SG".equals(codeString))
          return ENSG;
        if ("en-US".equals(codeString))
          return ENUS;
        if ("es".equals(codeString))
          return ES;
        if ("es-AR".equals(codeString))
          return ESAR;
        if ("es-ES".equals(codeString))
          return ESES;
        if ("es-UY".equals(codeString))
          return ESUY;
        if ("fi".equals(codeString))
          return FI;
        if ("fr".equals(codeString))
          return FR;
        if ("fr-BE".equals(codeString))
          return FRBE;
        if ("fr-CH".equals(codeString))
          return FRCH;
        if ("fr-FR".equals(codeString))
          return FRFR;
        if ("fr-CA".equals(codeString))
          return FRCA;
        if ("fy".equals(codeString))
          return FY;
        if ("fy-NL".equals(codeString))
          return FYNL;
        if ("hi".equals(codeString))
          return HI;
        if ("hr".equals(codeString))
          return HR;
        if ("it".equals(codeString))
          return IT;
        if ("it-CH".equals(codeString))
          return ITCH;
        if ("it-IT".equals(codeString))
          return ITIT;
        if ("ja".equals(codeString))
          return JA;
        if ("ko".equals(codeString))
          return KO;
        if ("nl".equals(codeString))
          return NL;
        if ("nl-BE".equals(codeString))
          return NLBE;
        if ("nl-NL".equals(codeString))
          return NLNL;
        if ("no".equals(codeString))
          return NO;
        if ("no-NO".equals(codeString))
          return NONO;
        if ("pa".equals(codeString))
          return PA;
        if ("pl".equals(codeString))
          return PL;
        if ("pt".equals(codeString))
          return PT;
        if ("pt-BR".equals(codeString))
          return PTBR;
        if ("ru".equals(codeString))
          return RU;
        if ("ru-RU".equals(codeString))
          return RURU;
        if ("sr".equals(codeString))
          return SR;
        if ("sr-RS".equals(codeString))
          return SRRS;
        if ("sv".equals(codeString))
          return SV;
        if ("sv-SE".equals(codeString))
          return SVSE;
        if ("te".equals(codeString))
          return TE;
        if ("zh".equals(codeString))
          return ZH;
        if ("zh-CN".equals(codeString))
          return ZHCN;
        if ("zh-HK".equals(codeString))
          return ZHHK;
        if ("zh-SG".equals(codeString))
          return ZHSG;
        if ("zh-TW".equals(codeString))
          return ZHTW;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CommonLanguages code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AR: return "ar";
            case BN: return "bn";
            case CS: return "cs";
            case DA: return "da";
            case DE: return "de";
            case DEAT: return "de-AT";
            case DECH: return "de-CH";
            case DEDE: return "de-DE";
            case EL: return "el";
            case EN: return "en";
            case ENAU: return "en-AU";
            case ENCA: return "en-CA";
            case ENGB: return "en-GB";
            case ENIN: return "en-IN";
            case ENNZ: return "en-NZ";
            case ENSG: return "en-SG";
            case ENUS: return "en-US";
            case ES: return "es";
            case ESAR: return "es-AR";
            case ESES: return "es-ES";
            case ESUY: return "es-UY";
            case FI: return "fi";
            case FR: return "fr";
            case FRBE: return "fr-BE";
            case FRCH: return "fr-CH";
            case FRFR: return "fr-FR";
            case FRCA: return "fr-CA";
            case FY: return "fy";
            case FYNL: return "fy-NL";
            case HI: return "hi";
            case HR: return "hr";
            case IT: return "it";
            case ITCH: return "it-CH";
            case ITIT: return "it-IT";
            case JA: return "ja";
            case KO: return "ko";
            case NL: return "nl";
            case NLBE: return "nl-BE";
            case NLNL: return "nl-NL";
            case NO: return "no";
            case NONO: return "no-NO";
            case PA: return "pa";
            case PL: return "pl";
            case PT: return "pt";
            case PTBR: return "pt-BR";
            case RU: return "ru";
            case RURU: return "ru-RU";
            case SR: return "sr";
            case SRRS: return "sr-RS";
            case SV: return "sv";
            case SVSE: return "sv-SE";
            case TE: return "te";
            case ZH: return "zh";
            case ZHCN: return "zh-CN";
            case ZHHK: return "zh-HK";
            case ZHSG: return "zh-SG";
            case ZHTW: return "zh-TW";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AR: return "urn:ietf:bcp:47";
            case BN: return "urn:ietf:bcp:47";
            case CS: return "urn:ietf:bcp:47";
            case DA: return "urn:ietf:bcp:47";
            case DE: return "urn:ietf:bcp:47";
            case DEAT: return "urn:ietf:bcp:47";
            case DECH: return "urn:ietf:bcp:47";
            case DEDE: return "urn:ietf:bcp:47";
            case EL: return "urn:ietf:bcp:47";
            case EN: return "urn:ietf:bcp:47";
            case ENAU: return "urn:ietf:bcp:47";
            case ENCA: return "urn:ietf:bcp:47";
            case ENGB: return "urn:ietf:bcp:47";
            case ENIN: return "urn:ietf:bcp:47";
            case ENNZ: return "urn:ietf:bcp:47";
            case ENSG: return "urn:ietf:bcp:47";
            case ENUS: return "urn:ietf:bcp:47";
            case ES: return "urn:ietf:bcp:47";
            case ESAR: return "urn:ietf:bcp:47";
            case ESES: return "urn:ietf:bcp:47";
            case ESUY: return "urn:ietf:bcp:47";
            case FI: return "urn:ietf:bcp:47";
            case FR: return "urn:ietf:bcp:47";
            case FRBE: return "urn:ietf:bcp:47";
            case FRCH: return "urn:ietf:bcp:47";
            case FRFR: return "urn:ietf:bcp:47";
            case FRCA: return "urn:ietf:bcp:47";
            case FY: return "urn:ietf:bcp:47";
            case FYNL: return "urn:ietf:bcp:47";
            case HI: return "urn:ietf:bcp:47";
            case HR: return "urn:ietf:bcp:47";
            case IT: return "urn:ietf:bcp:47";
            case ITCH: return "urn:ietf:bcp:47";
            case ITIT: return "urn:ietf:bcp:47";
            case JA: return "urn:ietf:bcp:47";
            case KO: return "urn:ietf:bcp:47";
            case NL: return "urn:ietf:bcp:47";
            case NLBE: return "urn:ietf:bcp:47";
            case NLNL: return "urn:ietf:bcp:47";
            case NO: return "urn:ietf:bcp:47";
            case NONO: return "urn:ietf:bcp:47";
            case PA: return "urn:ietf:bcp:47";
            case PL: return "urn:ietf:bcp:47";
            case PT: return "urn:ietf:bcp:47";
            case PTBR: return "urn:ietf:bcp:47";
            case RU: return "urn:ietf:bcp:47";
            case RURU: return "urn:ietf:bcp:47";
            case SR: return "urn:ietf:bcp:47";
            case SRRS: return "urn:ietf:bcp:47";
            case SV: return "urn:ietf:bcp:47";
            case SVSE: return "urn:ietf:bcp:47";
            case TE: return "urn:ietf:bcp:47";
            case ZH: return "urn:ietf:bcp:47";
            case ZHCN: return "urn:ietf:bcp:47";
            case ZHHK: return "urn:ietf:bcp:47";
            case ZHSG: return "urn:ietf:bcp:47";
            case ZHTW: return "urn:ietf:bcp:47";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AR: return "";
            case BN: return "";
            case CS: return "";
            case DA: return "";
            case DE: return "";
            case DEAT: return "";
            case DECH: return "";
            case DEDE: return "";
            case EL: return "";
            case EN: return "";
            case ENAU: return "";
            case ENCA: return "";
            case ENGB: return "";
            case ENIN: return "";
            case ENNZ: return "";
            case ENSG: return "";
            case ENUS: return "";
            case ES: return "";
            case ESAR: return "";
            case ESES: return "";
            case ESUY: return "";
            case FI: return "";
            case FR: return "";
            case FRBE: return "";
            case FRCH: return "";
            case FRFR: return "";
            case FRCA: return "";
            case FY: return "";
            case FYNL: return "";
            case HI: return "";
            case HR: return "";
            case IT: return "";
            case ITCH: return "";
            case ITIT: return "";
            case JA: return "";
            case KO: return "";
            case NL: return "";
            case NLBE: return "";
            case NLNL: return "";
            case NO: return "";
            case NONO: return "";
            case PA: return "";
            case PL: return "";
            case PT: return "";
            case PTBR: return "";
            case RU: return "";
            case RURU: return "";
            case SR: return "";
            case SRRS: return "";
            case SV: return "";
            case SVSE: return "";
            case TE: return "";
            case ZH: return "";
            case ZHCN: return "";
            case ZHHK: return "";
            case ZHSG: return "";
            case ZHTW: return "";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AR: return "Arabisk";
            case BN: return "Bengali";
            case CS: return "Czech";
            case DA: return "Danish";
            case DE: return "German";
            case DEAT: return "German (Austria)";
            case DECH: return "German (Switzerland)";
            case DEDE: return "German (Germany)";
            case EL: return "Greek";
            case EN: return "English";
            case ENAU: return "English (Australia)";
            case ENCA: return "English (Canada)";
            case ENGB: return "English (Great Britain)";
            case ENIN: return "English (India)";
            case ENNZ: return "English (New Zealand)";
            case ENSG: return "English (Singapore)";
            case ENUS: return "English (United States)";
            case ES: return "Spanish";
            case ESAR: return "Spanish (Argentina)";
            case ESES: return "Spanish (Spain)";
            case ESUY: return "Spanish (Uruguay)";
            case FI: return "Finnish";
            case FR: return "French";
            case FRBE: return "French (Belgium)";
            case FRCH: return "French (Switzerland)";
            case FRFR: return "French (France)";
            case FRCA: return "French (Canada)";
            case FY: return "Frysian";
            case FYNL: return "Frysian (Netherlands)";
            case HI: return "Hindi";
            case HR: return "Croatian";
            case IT: return "Italian";
            case ITCH: return "Italian (Switzerland)";
            case ITIT: return "Italian (Italy)";
            case JA: return "Japanese";
            case KO: return "Korean";
            case NL: return "Dutch";
            case NLBE: return "Dutch (Belgium)";
            case NLNL: return "Dutch (Netherlands)";
            case NO: return "Norwegian";
            case NONO: return "Norwegian (Norway)";
            case PA: return "Punjabi";
            case PL: return "Polskie";
            case PT: return "Portuguese";
            case PTBR: return "Portuguese (Brazil)";
            case RU: return "Russian";
            case RURU: return "Russian (Russia)";
            case SR: return "Serbian";
            case SRRS: return "Serbian (Serbia)";
            case SV: return "Swedish";
            case SVSE: return "Swedish (Sweden)";
            case TE: return "Telegu";
            case ZH: return "Chinese";
            case ZHCN: return "Chinese (China)";
            case ZHHK: return "Chinese (Hong Kong)";
            case ZHSG: return "Chinese (Singapore)";
            case ZHTW: return "Chinese (Taiwan)";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CommonLanguagesEnumFactory implements EnumFactory<CommonLanguages> {
    public CommonLanguages fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ar".equals(codeString))
          return CommonLanguages.AR;
        if ("bn".equals(codeString))
          return CommonLanguages.BN;
        if ("cs".equals(codeString))
          return CommonLanguages.CS;
        if ("da".equals(codeString))
          return CommonLanguages.DA;
        if ("de".equals(codeString))
          return CommonLanguages.DE;
        if ("de-AT".equals(codeString))
          return CommonLanguages.DEAT;
        if ("de-CH".equals(codeString))
          return CommonLanguages.DECH;
        if ("de-DE".equals(codeString))
          return CommonLanguages.DEDE;
        if ("el".equals(codeString))
          return CommonLanguages.EL;
        if ("en".equals(codeString))
          return CommonLanguages.EN;
        if ("en-AU".equals(codeString))
          return CommonLanguages.ENAU;
        if ("en-CA".equals(codeString))
          return CommonLanguages.ENCA;
        if ("en-GB".equals(codeString))
          return CommonLanguages.ENGB;
        if ("en-IN".equals(codeString))
          return CommonLanguages.ENIN;
        if ("en-NZ".equals(codeString))
          return CommonLanguages.ENNZ;
        if ("en-SG".equals(codeString))
          return CommonLanguages.ENSG;
        if ("en-US".equals(codeString))
          return CommonLanguages.ENUS;
        if ("es".equals(codeString))
          return CommonLanguages.ES;
        if ("es-AR".equals(codeString))
          return CommonLanguages.ESAR;
        if ("es-ES".equals(codeString))
          return CommonLanguages.ESES;
        if ("es-UY".equals(codeString))
          return CommonLanguages.ESUY;
        if ("fi".equals(codeString))
          return CommonLanguages.FI;
        if ("fr".equals(codeString))
          return CommonLanguages.FR;
        if ("fr-BE".equals(codeString))
          return CommonLanguages.FRBE;
        if ("fr-CH".equals(codeString))
          return CommonLanguages.FRCH;
        if ("fr-FR".equals(codeString))
          return CommonLanguages.FRFR;
        if ("fr-CA".equals(codeString))
          return CommonLanguages.FRCA;
        if ("fy".equals(codeString))
          return CommonLanguages.FY;
        if ("fy-NL".equals(codeString))
          return CommonLanguages.FYNL;
        if ("hi".equals(codeString))
          return CommonLanguages.HI;
        if ("hr".equals(codeString))
          return CommonLanguages.HR;
        if ("it".equals(codeString))
          return CommonLanguages.IT;
        if ("it-CH".equals(codeString))
          return CommonLanguages.ITCH;
        if ("it-IT".equals(codeString))
          return CommonLanguages.ITIT;
        if ("ja".equals(codeString))
          return CommonLanguages.JA;
        if ("ko".equals(codeString))
          return CommonLanguages.KO;
        if ("nl".equals(codeString))
          return CommonLanguages.NL;
        if ("nl-BE".equals(codeString))
          return CommonLanguages.NLBE;
        if ("nl-NL".equals(codeString))
          return CommonLanguages.NLNL;
        if ("no".equals(codeString))
          return CommonLanguages.NO;
        if ("no-NO".equals(codeString))
          return CommonLanguages.NONO;
        if ("pa".equals(codeString))
          return CommonLanguages.PA;
        if ("pl".equals(codeString))
          return CommonLanguages.PL;
        if ("pt".equals(codeString))
          return CommonLanguages.PT;
        if ("pt-BR".equals(codeString))
          return CommonLanguages.PTBR;
        if ("ru".equals(codeString))
          return CommonLanguages.RU;
        if ("ru-RU".equals(codeString))
          return CommonLanguages.RURU;
        if ("sr".equals(codeString))
          return CommonLanguages.SR;
        if ("sr-RS".equals(codeString))
          return CommonLanguages.SRRS;
        if ("sv".equals(codeString))
          return CommonLanguages.SV;
        if ("sv-SE".equals(codeString))
          return CommonLanguages.SVSE;
        if ("te".equals(codeString))
          return CommonLanguages.TE;
        if ("zh".equals(codeString))
          return CommonLanguages.ZH;
        if ("zh-CN".equals(codeString))
          return CommonLanguages.ZHCN;
        if ("zh-HK".equals(codeString))
          return CommonLanguages.ZHHK;
        if ("zh-SG".equals(codeString))
          return CommonLanguages.ZHSG;
        if ("zh-TW".equals(codeString))
          return CommonLanguages.ZHTW;
        throw new IllegalArgumentException("Unknown CommonLanguages code '"+codeString+"'");
        }
        public Enumeration<CommonLanguages> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CommonLanguages>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("ar".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.AR);
        if ("bn".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.BN);
        if ("cs".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.CS);
        if ("da".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.DA);
        if ("de".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.DE);
        if ("de-AT".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.DEAT);
        if ("de-CH".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.DECH);
        if ("de-DE".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.DEDE);
        if ("el".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.EL);
        if ("en".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.EN);
        if ("en-AU".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENAU);
        if ("en-CA".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENCA);
        if ("en-GB".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENGB);
        if ("en-IN".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENIN);
        if ("en-NZ".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENNZ);
        if ("en-SG".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENSG);
        if ("en-US".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ENUS);
        if ("es".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ES);
        if ("es-AR".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ESAR);
        if ("es-ES".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ESES);
        if ("es-UY".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ESUY);
        if ("fi".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FI);
        if ("fr".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FR);
        if ("fr-BE".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FRBE);
        if ("fr-CH".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FRCH);
        if ("fr-FR".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FRFR);
        if ("fr-CA".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FRCA);
        if ("fy".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FY);
        if ("fy-NL".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.FYNL);
        if ("hi".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.HI);
        if ("hr".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.HR);
        if ("it".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.IT);
        if ("it-CH".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ITCH);
        if ("it-IT".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ITIT);
        if ("ja".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.JA);
        if ("ko".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.KO);
        if ("nl".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.NL);
        if ("nl-BE".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.NLBE);
        if ("nl-NL".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.NLNL);
        if ("no".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.NO);
        if ("no-NO".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.NONO);
        if ("pa".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.PA);
        if ("pl".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.PL);
        if ("pt".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.PT);
        if ("pt-BR".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.PTBR);
        if ("ru".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.RU);
        if ("ru-RU".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.RURU);
        if ("sr".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.SR);
        if ("sr-RS".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.SRRS);
        if ("sv".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.SV);
        if ("sv-SE".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.SVSE);
        if ("te".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.TE);
        if ("zh".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ZH);
        if ("zh-CN".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ZHCN);
        if ("zh-HK".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ZHHK);
        if ("zh-SG".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ZHSG);
        if ("zh-TW".equals(codeString))
          return new Enumeration<CommonLanguages>(this, CommonLanguages.ZHTW);
        throw new FHIRException("Unknown CommonLanguages code '"+codeString+"'");
        }
    public String toCode(CommonLanguages code) {
      if (code == CommonLanguages.AR)
        return "ar";
      if (code == CommonLanguages.BN)
        return "bn";
      if (code == CommonLanguages.CS)
        return "cs";
      if (code == CommonLanguages.DA)
        return "da";
      if (code == CommonLanguages.DE)
        return "de";
      if (code == CommonLanguages.DEAT)
        return "de-AT";
      if (code == CommonLanguages.DECH)
        return "de-CH";
      if (code == CommonLanguages.DEDE)
        return "de-DE";
      if (code == CommonLanguages.EL)
        return "el";
      if (code == CommonLanguages.EN)
        return "en";
      if (code == CommonLanguages.ENAU)
        return "en-AU";
      if (code == CommonLanguages.ENCA)
        return "en-CA";
      if (code == CommonLanguages.ENGB)
        return "en-GB";
      if (code == CommonLanguages.ENIN)
        return "en-IN";
      if (code == CommonLanguages.ENNZ)
        return "en-NZ";
      if (code == CommonLanguages.ENSG)
        return "en-SG";
      if (code == CommonLanguages.ENUS)
        return "en-US";
      if (code == CommonLanguages.ES)
        return "es";
      if (code == CommonLanguages.ESAR)
        return "es-AR";
      if (code == CommonLanguages.ESES)
        return "es-ES";
      if (code == CommonLanguages.ESUY)
        return "es-UY";
      if (code == CommonLanguages.FI)
        return "fi";
      if (code == CommonLanguages.FR)
        return "fr";
      if (code == CommonLanguages.FRBE)
        return "fr-BE";
      if (code == CommonLanguages.FRCH)
        return "fr-CH";
      if (code == CommonLanguages.FRFR)
        return "fr-FR";
      if (code == CommonLanguages.FRCA)
        return "fr-CA";
      if (code == CommonLanguages.FY)
        return "fy";
      if (code == CommonLanguages.FYNL)
        return "fy-NL";
      if (code == CommonLanguages.HI)
        return "hi";
      if (code == CommonLanguages.HR)
        return "hr";
      if (code == CommonLanguages.IT)
        return "it";
      if (code == CommonLanguages.ITCH)
        return "it-CH";
      if (code == CommonLanguages.ITIT)
        return "it-IT";
      if (code == CommonLanguages.JA)
        return "ja";
      if (code == CommonLanguages.KO)
        return "ko";
      if (code == CommonLanguages.NL)
        return "nl";
      if (code == CommonLanguages.NLBE)
        return "nl-BE";
      if (code == CommonLanguages.NLNL)
        return "nl-NL";
      if (code == CommonLanguages.NO)
        return "no";
      if (code == CommonLanguages.NONO)
        return "no-NO";
      if (code == CommonLanguages.PA)
        return "pa";
      if (code == CommonLanguages.PL)
        return "pl";
      if (code == CommonLanguages.PT)
        return "pt";
      if (code == CommonLanguages.PTBR)
        return "pt-BR";
      if (code == CommonLanguages.RU)
        return "ru";
      if (code == CommonLanguages.RURU)
        return "ru-RU";
      if (code == CommonLanguages.SR)
        return "sr";
      if (code == CommonLanguages.SRRS)
        return "sr-RS";
      if (code == CommonLanguages.SV)
        return "sv";
      if (code == CommonLanguages.SVSE)
        return "sv-SE";
      if (code == CommonLanguages.TE)
        return "te";
      if (code == CommonLanguages.ZH)
        return "zh";
      if (code == CommonLanguages.ZHCN)
        return "zh-CN";
      if (code == CommonLanguages.ZHHK)
        return "zh-HK";
      if (code == CommonLanguages.ZHSG)
        return "zh-SG";
      if (code == CommonLanguages.ZHTW)
        return "zh-TW";
      return "?";
      }
    public String toSystem(CommonLanguages code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class TerminologyCapabilitiesSoftwareComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name the software is known by.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A name the software is known by", formalDefinition="Name the software is known by." )
        protected StringType name;

        /**
         * The version identifier for the software covered by this statement.
         */
        @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Version covered by this statement", formalDefinition="The version identifier for the software covered by this statement." )
        protected StringType version;

        private static final long serialVersionUID = -790299911L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesSoftwareComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesSoftwareComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (Name the software is known by.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesSoftwareComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new StringType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name the software is known by.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TerminologyCapabilitiesSoftwareComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name the software is known by.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name the software is known by.
         */
        public TerminologyCapabilitiesSoftwareComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #version} (The version identifier for the software covered by this statement.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public StringType getVersionElement() { 
          if (this.version == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesSoftwareComponent.version");
            else if (Configuration.doAutoCreate())
              this.version = new StringType(); // bb
          return this.version;
        }

        public boolean hasVersionElement() { 
          return this.version != null && !this.version.isEmpty();
        }

        public boolean hasVersion() { 
          return this.version != null && !this.version.isEmpty();
        }

        /**
         * @param value {@link #version} (The version identifier for the software covered by this statement.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public TerminologyCapabilitiesSoftwareComponent setVersionElement(StringType value) { 
          this.version = value;
          return this;
        }

        /**
         * @return The version identifier for the software covered by this statement.
         */
        public String getVersion() { 
          return this.version == null ? null : this.version.getValue();
        }

        /**
         * @param value The version identifier for the software covered by this statement.
         */
        public TerminologyCapabilitiesSoftwareComponent setVersion(String value) { 
          if (Utilities.noString(value))
            this.version = null;
          else {
            if (this.version == null)
              this.version = new StringType();
            this.version.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Name the software is known by.", 0, 1, name));
          children.add(new Property("version", "string", "The version identifier for the software covered by this statement.", 0, 1, version));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Name the software is known by.", 0, 1, name);
          case 351608024: /*version*/  return new Property("version", "string", "The version identifier for the software covered by this statement.", 0, 1, version);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 351608024:  return getVersionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 351608024: /*version*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.software.name");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.software.version");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesSoftwareComponent copy() {
        TerminologyCapabilitiesSoftwareComponent dst = new TerminologyCapabilitiesSoftwareComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesSoftwareComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.version = version == null ? null : version.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesSoftwareComponent))
          return false;
        TerminologyCapabilitiesSoftwareComponent o = (TerminologyCapabilitiesSoftwareComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(version, o.version, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesSoftwareComponent))
          return false;
        TerminologyCapabilitiesSoftwareComponent o = (TerminologyCapabilitiesSoftwareComponent) other_;
        return compareValues(name, o.name, true) && compareValues(version, o.version, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, version);
      }

  public String fhirType() {
    return "TerminologyCapabilities.software";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesImplementationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Information about the specific installation that this terminology capability statement relates to.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Describes this specific instance", formalDefinition="Information about the specific installation that this terminology capability statement relates to." )
        protected StringType description;

        /**
         * An absolute base URL for the implementation.
         */
        @Child(name = "url", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Base URL for the implementation", formalDefinition="An absolute base URL for the implementation." )
        protected UrlType url;

        private static final long serialVersionUID = 98009649L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesImplementationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesImplementationComponent(String description) {
        super();
        this.setDescription(description);
      }

        /**
         * @return {@link #description} (Information about the specific installation that this terminology capability statement relates to.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesImplementationComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (Information about the specific installation that this terminology capability statement relates to.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TerminologyCapabilitiesImplementationComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Information about the specific installation that this terminology capability statement relates to.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Information about the specific installation that this terminology capability statement relates to.
         */
        public TerminologyCapabilitiesImplementationComponent setDescription(String value) { 
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          return this;
        }

        /**
         * @return {@link #url} (An absolute base URL for the implementation.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesImplementationComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UrlType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (An absolute base URL for the implementation.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public TerminologyCapabilitiesImplementationComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return An absolute base URL for the implementation.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value An absolute base URL for the implementation.
         */
        public TerminologyCapabilitiesImplementationComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Information about the specific installation that this terminology capability statement relates to.", 0, 1, description));
          children.add(new Property("url", "url", "An absolute base URL for the implementation.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Information about the specific installation that this terminology capability statement relates to.", 0, 1, description);
          case 116079: /*url*/  return new Property("url", "url", "An absolute base URL for the implementation.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 116079: /*url*/ return new String[] {"url"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.implementation.description");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.implementation.url");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesImplementationComponent copy() {
        TerminologyCapabilitiesImplementationComponent dst = new TerminologyCapabilitiesImplementationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesImplementationComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesImplementationComponent))
          return false;
        TerminologyCapabilitiesImplementationComponent o = (TerminologyCapabilitiesImplementationComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(url, o.url, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesImplementationComponent))
          return false;
        TerminologyCapabilitiesImplementationComponent o = (TerminologyCapabilitiesImplementationComponent) other_;
        return compareValues(description, o.description, true) && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, url);
      }

  public String fhirType() {
    return "TerminologyCapabilities.implementation";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesCodeSystemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Canonical identifier for the code system, represented as a URI.
         */
        @Child(name = "uri", type = {CanonicalType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Canonical identifier for the code system, represented as a URI", formalDefinition="Canonical identifier for the code system, represented as a URI." )
        protected CanonicalType uri;

        /**
         * For the code system, a list of versions that are supported by the server.
         */
        @Child(name = "version", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Version of Code System supported", formalDefinition="For the code system, a list of versions that are supported by the server." )
        protected List<TerminologyCapabilitiesCodeSystemVersionComponent> version;

        /**
         * The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.
         */
        @Child(name = "content", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="not-present | example | fragment | complete | supplement", formalDefinition="The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/codesystem-content-mode")
        protected CodeType content;

        /**
         * True if subsumption is supported for this version of the code system.
         */
        @Child(name = "subsumption", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether subsumption is supported", formalDefinition="True if subsumption is supported for this version of the code system." )
        protected BooleanType subsumption;

        private static final long serialVersionUID = 177402405L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesCodeSystemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesCodeSystemComponent(String content) {
        super();
        this.setContent(content);
      }

        /**
         * @return {@link #uri} (Canonical identifier for the code system, represented as a URI.). This is the underlying object with id, value and extensions. The accessor "getUri" gives direct access to the value
         */
        public CanonicalType getUriElement() { 
          if (this.uri == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemComponent.uri");
            else if (Configuration.doAutoCreate())
              this.uri = new CanonicalType(); // bb
          return this.uri;
        }

        public boolean hasUriElement() { 
          return this.uri != null && !this.uri.isEmpty();
        }

        public boolean hasUri() { 
          return this.uri != null && !this.uri.isEmpty();
        }

        /**
         * @param value {@link #uri} (Canonical identifier for the code system, represented as a URI.). This is the underlying object with id, value and extensions. The accessor "getUri" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemComponent setUriElement(CanonicalType value) { 
          this.uri = value;
          return this;
        }

        /**
         * @return Canonical identifier for the code system, represented as a URI.
         */
        public String getUri() { 
          return this.uri == null ? null : this.uri.getValue();
        }

        /**
         * @param value Canonical identifier for the code system, represented as a URI.
         */
        public TerminologyCapabilitiesCodeSystemComponent setUri(String value) { 
          if (Utilities.noString(value))
            this.uri = null;
          else {
            if (this.uri == null)
              this.uri = new CanonicalType();
            this.uri.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #version} (For the code system, a list of versions that are supported by the server.)
         */
        public List<TerminologyCapabilitiesCodeSystemVersionComponent> getVersion() { 
          if (this.version == null)
            this.version = new ArrayList<TerminologyCapabilitiesCodeSystemVersionComponent>();
          return this.version;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TerminologyCapabilitiesCodeSystemComponent setVersion(List<TerminologyCapabilitiesCodeSystemVersionComponent> theVersion) { 
          this.version = theVersion;
          return this;
        }

        public boolean hasVersion() { 
          if (this.version == null)
            return false;
          for (TerminologyCapabilitiesCodeSystemVersionComponent item : this.version)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TerminologyCapabilitiesCodeSystemVersionComponent addVersion() { //3
          TerminologyCapabilitiesCodeSystemVersionComponent t = new TerminologyCapabilitiesCodeSystemVersionComponent();
          if (this.version == null)
            this.version = new ArrayList<TerminologyCapabilitiesCodeSystemVersionComponent>();
          this.version.add(t);
          return t;
        }

        public TerminologyCapabilitiesCodeSystemComponent addVersion(TerminologyCapabilitiesCodeSystemVersionComponent t) { //3
          if (t == null)
            return this;
          if (this.version == null)
            this.version = new ArrayList<TerminologyCapabilitiesCodeSystemVersionComponent>();
          this.version.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #version}, creating it if it does not already exist {3}
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent getVersionFirstRep() { 
          if (getVersion().isEmpty()) {
            addVersion();
          }
          return getVersion().get(0);
        }

        /**
         * @return {@link #content} (The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.). This is the underlying object with id, value and extensions. The accessor "getContent" gives direct access to the value
         */
        public CodeType getContentElement() { 
          if (this.content == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemComponent.content");
            else if (Configuration.doAutoCreate())
              this.content = new CodeType(); // bb
          return this.content;
        }

        public boolean hasContentElement() { 
          return this.content != null && !this.content.isEmpty();
        }

        public boolean hasContent() { 
          return this.content != null && !this.content.isEmpty();
        }

        /**
         * @param value {@link #content} (The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.). This is the underlying object with id, value and extensions. The accessor "getContent" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemComponent setContentElement(CodeType value) { 
          this.content = value;
          return this;
        }

        /**
         * @return The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.
         */
        public String getContent() { 
          return this.content == null ? null : this.content.getValue();
        }

        /**
         * @param value The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.
         */
        public TerminologyCapabilitiesCodeSystemComponent setContent(String value) { 
            if (this.content == null)
              this.content = new CodeType();
            this.content.setValue(value);
          return this;
        }

        /**
         * @return {@link #subsumption} (True if subsumption is supported for this version of the code system.). This is the underlying object with id, value and extensions. The accessor "getSubsumption" gives direct access to the value
         */
        public BooleanType getSubsumptionElement() { 
          if (this.subsumption == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemComponent.subsumption");
            else if (Configuration.doAutoCreate())
              this.subsumption = new BooleanType(); // bb
          return this.subsumption;
        }

        public boolean hasSubsumptionElement() { 
          return this.subsumption != null && !this.subsumption.isEmpty();
        }

        public boolean hasSubsumption() { 
          return this.subsumption != null && !this.subsumption.isEmpty();
        }

        /**
         * @param value {@link #subsumption} (True if subsumption is supported for this version of the code system.). This is the underlying object with id, value and extensions. The accessor "getSubsumption" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemComponent setSubsumptionElement(BooleanType value) { 
          this.subsumption = value;
          return this;
        }

        /**
         * @return True if subsumption is supported for this version of the code system.
         */
        public boolean getSubsumption() { 
          return this.subsumption == null || this.subsumption.isEmpty() ? false : this.subsumption.getValue();
        }

        /**
         * @param value True if subsumption is supported for this version of the code system.
         */
        public TerminologyCapabilitiesCodeSystemComponent setSubsumption(boolean value) { 
            if (this.subsumption == null)
              this.subsumption = new BooleanType();
            this.subsumption.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("uri", "canonical(CodeSystem)", "Canonical identifier for the code system, represented as a URI.", 0, 1, uri));
          children.add(new Property("version", "", "For the code system, a list of versions that are supported by the server.", 0, java.lang.Integer.MAX_VALUE, version));
          children.add(new Property("content", "code", "The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.", 0, 1, content));
          children.add(new Property("subsumption", "boolean", "True if subsumption is supported for this version of the code system.", 0, 1, subsumption));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 116076: /*uri*/  return new Property("uri", "canonical(CodeSystem)", "Canonical identifier for the code system, represented as a URI.", 0, 1, uri);
          case 351608024: /*version*/  return new Property("version", "", "For the code system, a list of versions that are supported by the server.", 0, java.lang.Integer.MAX_VALUE, version);
          case 951530617: /*content*/  return new Property("content", "code", "The extent of the content of the code system (the concepts and codes it defines) are represented in this resource instance.", 0, 1, content);
          case -499084711: /*subsumption*/  return new Property("subsumption", "boolean", "True if subsumption is supported for this version of the code system.", 0, 1, subsumption);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116076: /*uri*/ return this.uri == null ? new Base[0] : new Base[] {this.uri}; // CanonicalType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // TerminologyCapabilitiesCodeSystemVersionComponent
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // CodeType
        case -499084711: /*subsumption*/ return this.subsumption == null ? new Base[0] : new Base[] {this.subsumption}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116076: // uri
          this.uri = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 351608024: // version
          this.getVersion().add((TerminologyCapabilitiesCodeSystemVersionComponent) value); // TerminologyCapabilitiesCodeSystemVersionComponent
          return value;
        case 951530617: // content
          this.content = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -499084711: // subsumption
          this.subsumption = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uri")) {
          this.uri = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("version")) {
          this.getVersion().add((TerminologyCapabilitiesCodeSystemVersionComponent) value);
        } else if (name.equals("content")) {
          this.content = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("subsumption")) {
          this.subsumption = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116076:  return getUriElement();
        case 351608024:  return addVersion(); 
        case 951530617:  return getContentElement();
        case -499084711:  return getSubsumptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116076: /*uri*/ return new String[] {"canonical"};
        case 351608024: /*version*/ return new String[] {};
        case 951530617: /*content*/ return new String[] {"code"};
        case -499084711: /*subsumption*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uri")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.uri");
        }
        else if (name.equals("version")) {
          return addVersion();
        }
        else if (name.equals("content")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.content");
        }
        else if (name.equals("subsumption")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.subsumption");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesCodeSystemComponent copy() {
        TerminologyCapabilitiesCodeSystemComponent dst = new TerminologyCapabilitiesCodeSystemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesCodeSystemComponent dst) {
        super.copyValues(dst);
        dst.uri = uri == null ? null : uri.copy();
        if (version != null) {
          dst.version = new ArrayList<TerminologyCapabilitiesCodeSystemVersionComponent>();
          for (TerminologyCapabilitiesCodeSystemVersionComponent i : version)
            dst.version.add(i.copy());
        };
        dst.content = content == null ? null : content.copy();
        dst.subsumption = subsumption == null ? null : subsumption.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesCodeSystemComponent))
          return false;
        TerminologyCapabilitiesCodeSystemComponent o = (TerminologyCapabilitiesCodeSystemComponent) other_;
        return compareDeep(uri, o.uri, true) && compareDeep(version, o.version, true) && compareDeep(content, o.content, true)
           && compareDeep(subsumption, o.subsumption, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesCodeSystemComponent))
          return false;
        TerminologyCapabilitiesCodeSystemComponent o = (TerminologyCapabilitiesCodeSystemComponent) other_;
        return compareValues(uri, o.uri, true) && compareValues(content, o.content, true) && compareValues(subsumption, o.subsumption, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uri, version, content, subsumption
          );
      }

  public String fhirType() {
    return "TerminologyCapabilities.codeSystem";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesCodeSystemVersionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * For version-less code systems, there should be a single version with no identifier.
         */
        @Child(name = "code", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Version identifier for this version", formalDefinition="For version-less code systems, there should be a single version with no identifier." )
        protected StringType code;

        /**
         * If this is the default version for this code system.
         */
        @Child(name = "isDefault", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="If this is the default version for this code system", formalDefinition="If this is the default version for this code system." )
        protected BooleanType isDefault;

        /**
         * If the compositional grammar defined by the code system is supported.
         */
        @Child(name = "compositional", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If compositional grammar is supported", formalDefinition="If the compositional grammar defined by the code system is supported." )
        protected BooleanType compositional;

        /**
         * Language Displays supported.
         */
        @Child(name = "language", type = {CodeType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Language Displays supported", formalDefinition="Language Displays supported." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected List<Enumeration<CommonLanguages>> language;

        /**
         * Filter Properties supported.
         */
        @Child(name = "filter", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Filter Properties supported", formalDefinition="Filter Properties supported." )
        protected List<TerminologyCapabilitiesCodeSystemVersionFilterComponent> filter;

        /**
         * Properties supported for $lookup.
         */
        @Child(name = "property", type = {CodeType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Properties supported for $lookup", formalDefinition="Properties supported for $lookup." )
        protected List<CodeType> property;

        private static final long serialVersionUID = 658198795L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesCodeSystemVersionComponent() {
        super();
      }

        /**
         * @return {@link #code} (For version-less code systems, there should be a single version with no identifier.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public StringType getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemVersionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new StringType(); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (For version-less code systems, there should be a single version with no identifier.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setCodeElement(StringType value) { 
          this.code = value;
          return this;
        }

        /**
         * @return For version-less code systems, there should be a single version with no identifier.
         */
        public String getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value For version-less code systems, there should be a single version with no identifier.
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setCode(String value) { 
          if (Utilities.noString(value))
            this.code = null;
          else {
            if (this.code == null)
              this.code = new StringType();
            this.code.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #isDefault} (If this is the default version for this code system.). This is the underlying object with id, value and extensions. The accessor "getIsDefault" gives direct access to the value
         */
        public BooleanType getIsDefaultElement() { 
          if (this.isDefault == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemVersionComponent.isDefault");
            else if (Configuration.doAutoCreate())
              this.isDefault = new BooleanType(); // bb
          return this.isDefault;
        }

        public boolean hasIsDefaultElement() { 
          return this.isDefault != null && !this.isDefault.isEmpty();
        }

        public boolean hasIsDefault() { 
          return this.isDefault != null && !this.isDefault.isEmpty();
        }

        /**
         * @param value {@link #isDefault} (If this is the default version for this code system.). This is the underlying object with id, value and extensions. The accessor "getIsDefault" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setIsDefaultElement(BooleanType value) { 
          this.isDefault = value;
          return this;
        }

        /**
         * @return If this is the default version for this code system.
         */
        public boolean getIsDefault() { 
          return this.isDefault == null || this.isDefault.isEmpty() ? false : this.isDefault.getValue();
        }

        /**
         * @param value If this is the default version for this code system.
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setIsDefault(boolean value) { 
            if (this.isDefault == null)
              this.isDefault = new BooleanType();
            this.isDefault.setValue(value);
          return this;
        }

        /**
         * @return {@link #compositional} (If the compositional grammar defined by the code system is supported.). This is the underlying object with id, value and extensions. The accessor "getCompositional" gives direct access to the value
         */
        public BooleanType getCompositionalElement() { 
          if (this.compositional == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemVersionComponent.compositional");
            else if (Configuration.doAutoCreate())
              this.compositional = new BooleanType(); // bb
          return this.compositional;
        }

        public boolean hasCompositionalElement() { 
          return this.compositional != null && !this.compositional.isEmpty();
        }

        public boolean hasCompositional() { 
          return this.compositional != null && !this.compositional.isEmpty();
        }

        /**
         * @param value {@link #compositional} (If the compositional grammar defined by the code system is supported.). This is the underlying object with id, value and extensions. The accessor "getCompositional" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setCompositionalElement(BooleanType value) { 
          this.compositional = value;
          return this;
        }

        /**
         * @return If the compositional grammar defined by the code system is supported.
         */
        public boolean getCompositional() { 
          return this.compositional == null || this.compositional.isEmpty() ? false : this.compositional.getValue();
        }

        /**
         * @param value If the compositional grammar defined by the code system is supported.
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setCompositional(boolean value) { 
            if (this.compositional == null)
              this.compositional = new BooleanType();
            this.compositional.setValue(value);
          return this;
        }

        /**
         * @return {@link #language} (Language Displays supported.)
         */
        public List<Enumeration<CommonLanguages>> getLanguage() { 
          if (this.language == null)
            this.language = new ArrayList<Enumeration<CommonLanguages>>();
          return this.language;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setLanguage(List<Enumeration<CommonLanguages>> theLanguage) { 
          this.language = theLanguage;
          return this;
        }

        public boolean hasLanguage() { 
          if (this.language == null)
            return false;
          for (Enumeration<CommonLanguages> item : this.language)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #language} (Language Displays supported.)
         */
        public Enumeration<CommonLanguages> addLanguageElement() {//2 
          Enumeration<CommonLanguages> t = new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory());
          if (this.language == null)
            this.language = new ArrayList<Enumeration<CommonLanguages>>();
          this.language.add(t);
          return t;
        }

        /**
         * @param value {@link #language} (Language Displays supported.)
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent addLanguage(CommonLanguages value) { //1
          Enumeration<CommonLanguages> t = new Enumeration<CommonLanguages>(new CommonLanguagesEnumFactory());
          t.setValue(value);
          if (this.language == null)
            this.language = new ArrayList<Enumeration<CommonLanguages>>();
          this.language.add(t);
          return this;
        }

        /**
         * @param value {@link #language} (Language Displays supported.)
         */
        public boolean hasLanguage(CommonLanguages value) { 
          if (this.language == null)
            return false;
          for (Enumeration<CommonLanguages> v : this.language)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #filter} (Filter Properties supported.)
         */
        public List<TerminologyCapabilitiesCodeSystemVersionFilterComponent> getFilter() { 
          if (this.filter == null)
            this.filter = new ArrayList<TerminologyCapabilitiesCodeSystemVersionFilterComponent>();
          return this.filter;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setFilter(List<TerminologyCapabilitiesCodeSystemVersionFilterComponent> theFilter) { 
          this.filter = theFilter;
          return this;
        }

        public boolean hasFilter() { 
          if (this.filter == null)
            return false;
          for (TerminologyCapabilitiesCodeSystemVersionFilterComponent item : this.filter)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TerminologyCapabilitiesCodeSystemVersionFilterComponent addFilter() { //3
          TerminologyCapabilitiesCodeSystemVersionFilterComponent t = new TerminologyCapabilitiesCodeSystemVersionFilterComponent();
          if (this.filter == null)
            this.filter = new ArrayList<TerminologyCapabilitiesCodeSystemVersionFilterComponent>();
          this.filter.add(t);
          return t;
        }

        public TerminologyCapabilitiesCodeSystemVersionComponent addFilter(TerminologyCapabilitiesCodeSystemVersionFilterComponent t) { //3
          if (t == null)
            return this;
          if (this.filter == null)
            this.filter = new ArrayList<TerminologyCapabilitiesCodeSystemVersionFilterComponent>();
          this.filter.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #filter}, creating it if it does not already exist {3}
         */
        public TerminologyCapabilitiesCodeSystemVersionFilterComponent getFilterFirstRep() { 
          if (getFilter().isEmpty()) {
            addFilter();
          }
          return getFilter().get(0);
        }

        /**
         * @return {@link #property} (Properties supported for $lookup.)
         */
        public List<CodeType> getProperty() { 
          if (this.property == null)
            this.property = new ArrayList<CodeType>();
          return this.property;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent setProperty(List<CodeType> theProperty) { 
          this.property = theProperty;
          return this;
        }

        public boolean hasProperty() { 
          if (this.property == null)
            return false;
          for (CodeType item : this.property)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #property} (Properties supported for $lookup.)
         */
        public CodeType addPropertyElement() {//2 
          CodeType t = new CodeType();
          if (this.property == null)
            this.property = new ArrayList<CodeType>();
          this.property.add(t);
          return t;
        }

        /**
         * @param value {@link #property} (Properties supported for $lookup.)
         */
        public TerminologyCapabilitiesCodeSystemVersionComponent addProperty(String value) { //1
          CodeType t = new CodeType();
          t.setValue(value);
          if (this.property == null)
            this.property = new ArrayList<CodeType>();
          this.property.add(t);
          return this;
        }

        /**
         * @param value {@link #property} (Properties supported for $lookup.)
         */
        public boolean hasProperty(String value) { 
          if (this.property == null)
            return false;
          for (CodeType v : this.property)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "string", "For version-less code systems, there should be a single version with no identifier.", 0, 1, code));
          children.add(new Property("isDefault", "boolean", "If this is the default version for this code system.", 0, 1, isDefault));
          children.add(new Property("compositional", "boolean", "If the compositional grammar defined by the code system is supported.", 0, 1, compositional));
          children.add(new Property("language", "code", "Language Displays supported.", 0, java.lang.Integer.MAX_VALUE, language));
          children.add(new Property("filter", "", "Filter Properties supported.", 0, java.lang.Integer.MAX_VALUE, filter));
          children.add(new Property("property", "code", "Properties supported for $lookup.", 0, java.lang.Integer.MAX_VALUE, property));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "string", "For version-less code systems, there should be a single version with no identifier.", 0, 1, code);
          case 965025207: /*isDefault*/  return new Property("isDefault", "boolean", "If this is the default version for this code system.", 0, 1, isDefault);
          case 1248023381: /*compositional*/  return new Property("compositional", "boolean", "If the compositional grammar defined by the code system is supported.", 0, 1, compositional);
          case -1613589672: /*language*/  return new Property("language", "code", "Language Displays supported.", 0, java.lang.Integer.MAX_VALUE, language);
          case -1274492040: /*filter*/  return new Property("filter", "", "Filter Properties supported.", 0, java.lang.Integer.MAX_VALUE, filter);
          case -993141291: /*property*/  return new Property("property", "code", "Properties supported for $lookup.", 0, java.lang.Integer.MAX_VALUE, property);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // StringType
        case 965025207: /*isDefault*/ return this.isDefault == null ? new Base[0] : new Base[] {this.isDefault}; // BooleanType
        case 1248023381: /*compositional*/ return this.compositional == null ? new Base[0] : new Base[] {this.compositional}; // BooleanType
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : this.language.toArray(new Base[this.language.size()]); // Enumeration<CommonLanguages>
        case -1274492040: /*filter*/ return this.filter == null ? new Base[0] : this.filter.toArray(new Base[this.filter.size()]); // TerminologyCapabilitiesCodeSystemVersionFilterComponent
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // CodeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToString(value); // StringType
          return value;
        case 965025207: // isDefault
          this.isDefault = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1248023381: // compositional
          this.compositional = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1613589672: // language
          value = new CommonLanguagesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getLanguage().add((Enumeration) value); // Enumeration<CommonLanguages>
          return value;
        case -1274492040: // filter
          this.getFilter().add((TerminologyCapabilitiesCodeSystemVersionFilterComponent) value); // TerminologyCapabilitiesCodeSystemVersionFilterComponent
          return value;
        case -993141291: // property
          this.getProperty().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("isDefault")) {
          this.isDefault = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("compositional")) {
          this.compositional = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("language")) {
          value = new CommonLanguagesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getLanguage().add((Enumeration) value);
        } else if (name.equals("filter")) {
          this.getFilter().add((TerminologyCapabilitiesCodeSystemVersionFilterComponent) value);
        } else if (name.equals("property")) {
          this.getProperty().add(TypeConvertor.castToCode(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 965025207:  return getIsDefaultElement();
        case 1248023381:  return getCompositionalElement();
        case -1613589672:  return addLanguageElement();
        case -1274492040:  return addFilter(); 
        case -993141291:  return addPropertyElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"string"};
        case 965025207: /*isDefault*/ return new String[] {"boolean"};
        case 1248023381: /*compositional*/ return new String[] {"boolean"};
        case -1613589672: /*language*/ return new String[] {"code"};
        case -1274492040: /*filter*/ return new String[] {};
        case -993141291: /*property*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.code");
        }
        else if (name.equals("isDefault")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.isDefault");
        }
        else if (name.equals("compositional")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.compositional");
        }
        else if (name.equals("language")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.language");
        }
        else if (name.equals("filter")) {
          return addFilter();
        }
        else if (name.equals("property")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.property");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesCodeSystemVersionComponent copy() {
        TerminologyCapabilitiesCodeSystemVersionComponent dst = new TerminologyCapabilitiesCodeSystemVersionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesCodeSystemVersionComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.isDefault = isDefault == null ? null : isDefault.copy();
        dst.compositional = compositional == null ? null : compositional.copy();
        if (language != null) {
          dst.language = new ArrayList<Enumeration<CommonLanguages>>();
          for (Enumeration<CommonLanguages> i : language)
            dst.language.add(i.copy());
        };
        if (filter != null) {
          dst.filter = new ArrayList<TerminologyCapabilitiesCodeSystemVersionFilterComponent>();
          for (TerminologyCapabilitiesCodeSystemVersionFilterComponent i : filter)
            dst.filter.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<CodeType>();
          for (CodeType i : property)
            dst.property.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesCodeSystemVersionComponent))
          return false;
        TerminologyCapabilitiesCodeSystemVersionComponent o = (TerminologyCapabilitiesCodeSystemVersionComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(isDefault, o.isDefault, true) && compareDeep(compositional, o.compositional, true)
           && compareDeep(language, o.language, true) && compareDeep(filter, o.filter, true) && compareDeep(property, o.property, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesCodeSystemVersionComponent))
          return false;
        TerminologyCapabilitiesCodeSystemVersionComponent o = (TerminologyCapabilitiesCodeSystemVersionComponent) other_;
        return compareValues(code, o.code, true) && compareValues(isDefault, o.isDefault, true) && compareValues(compositional, o.compositional, true)
           && compareValues(language, o.language, true) && compareValues(property, o.property, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, isDefault, compositional
          , language, filter, property);
      }

  public String fhirType() {
    return "TerminologyCapabilities.codeSystem.version";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesCodeSystemVersionFilterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code of the property supported.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code of the property supported", formalDefinition="Code of the property supported." )
        protected CodeType code;

        /**
         * Operations supported for the property.
         */
        @Child(name = "op", type = {CodeType.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Operations supported for the property", formalDefinition="Operations supported for the property." )
        protected List<CodeType> op;

        private static final long serialVersionUID = -489160282L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesCodeSystemVersionFilterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesCodeSystemVersionFilterComponent(String code, String op) {
        super();
        this.setCode(code);
        this.addOp(op);
      }

        /**
         * @return {@link #code} (Code of the property supported.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public CodeType getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesCodeSystemVersionFilterComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeType(); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Code of the property supported.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public TerminologyCapabilitiesCodeSystemVersionFilterComponent setCodeElement(CodeType value) { 
          this.code = value;
          return this;
        }

        /**
         * @return Code of the property supported.
         */
        public String getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value Code of the property supported.
         */
        public TerminologyCapabilitiesCodeSystemVersionFilterComponent setCode(String value) { 
            if (this.code == null)
              this.code = new CodeType();
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #op} (Operations supported for the property.)
         */
        public List<CodeType> getOp() { 
          if (this.op == null)
            this.op = new ArrayList<CodeType>();
          return this.op;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TerminologyCapabilitiesCodeSystemVersionFilterComponent setOp(List<CodeType> theOp) { 
          this.op = theOp;
          return this;
        }

        public boolean hasOp() { 
          if (this.op == null)
            return false;
          for (CodeType item : this.op)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #op} (Operations supported for the property.)
         */
        public CodeType addOpElement() {//2 
          CodeType t = new CodeType();
          if (this.op == null)
            this.op = new ArrayList<CodeType>();
          this.op.add(t);
          return t;
        }

        /**
         * @param value {@link #op} (Operations supported for the property.)
         */
        public TerminologyCapabilitiesCodeSystemVersionFilterComponent addOp(String value) { //1
          CodeType t = new CodeType();
          t.setValue(value);
          if (this.op == null)
            this.op = new ArrayList<CodeType>();
          this.op.add(t);
          return this;
        }

        /**
         * @param value {@link #op} (Operations supported for the property.)
         */
        public boolean hasOp(String value) { 
          if (this.op == null)
            return false;
          for (CodeType v : this.op)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "Code of the property supported.", 0, 1, code));
          children.add(new Property("op", "code", "Operations supported for the property.", 0, java.lang.Integer.MAX_VALUE, op));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "Code of the property supported.", 0, 1, code);
          case 3553: /*op*/  return new Property("op", "code", "Operations supported for the property.", 0, java.lang.Integer.MAX_VALUE, op);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeType
        case 3553: /*op*/ return this.op == null ? new Base[0] : this.op.toArray(new Base[this.op.size()]); // CodeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 3553: // op
          this.getOp().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("op")) {
          this.getOp().add(TypeConvertor.castToCode(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 3553:  return addOpElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 3553: /*op*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.filter.code");
        }
        else if (name.equals("op")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSystem.version.filter.op");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesCodeSystemVersionFilterComponent copy() {
        TerminologyCapabilitiesCodeSystemVersionFilterComponent dst = new TerminologyCapabilitiesCodeSystemVersionFilterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesCodeSystemVersionFilterComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (op != null) {
          dst.op = new ArrayList<CodeType>();
          for (CodeType i : op)
            dst.op.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesCodeSystemVersionFilterComponent))
          return false;
        TerminologyCapabilitiesCodeSystemVersionFilterComponent o = (TerminologyCapabilitiesCodeSystemVersionFilterComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(op, o.op, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesCodeSystemVersionFilterComponent))
          return false;
        TerminologyCapabilitiesCodeSystemVersionFilterComponent o = (TerminologyCapabilitiesCodeSystemVersionFilterComponent) other_;
        return compareValues(code, o.code, true) && compareValues(op, o.op, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, op);
      }

  public String fhirType() {
    return "TerminologyCapabilities.codeSystem.version.filter";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesExpansionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether the server can return nested value sets.
         */
        @Child(name = "hierarchical", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the server can return nested value sets", formalDefinition="Whether the server can return nested value sets." )
        protected BooleanType hierarchical;

        /**
         * Whether the server supports paging on expansion.
         */
        @Child(name = "paging", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the server supports paging on expansion", formalDefinition="Whether the server supports paging on expansion." )
        protected BooleanType paging;

        /**
         * True if requests for incomplete expansions are allowed.
         */
        @Child(name = "incomplete", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Allow request for incomplete expansions?", formalDefinition="True if requests for incomplete expansions are allowed." )
        protected BooleanType incomplete;

        /**
         * Supported expansion parameter.
         */
        @Child(name = "parameter", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Supported expansion parameter", formalDefinition="Supported expansion parameter." )
        protected List<TerminologyCapabilitiesExpansionParameterComponent> parameter;

        /**
         * Documentation about text searching works.
         */
        @Child(name = "textFilter", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Documentation about text searching works", formalDefinition="Documentation about text searching works." )
        protected MarkdownType textFilter;

        private static final long serialVersionUID = -1011350616L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesExpansionComponent() {
        super();
      }

        /**
         * @return {@link #hierarchical} (Whether the server can return nested value sets.). This is the underlying object with id, value and extensions. The accessor "getHierarchical" gives direct access to the value
         */
        public BooleanType getHierarchicalElement() { 
          if (this.hierarchical == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesExpansionComponent.hierarchical");
            else if (Configuration.doAutoCreate())
              this.hierarchical = new BooleanType(); // bb
          return this.hierarchical;
        }

        public boolean hasHierarchicalElement() { 
          return this.hierarchical != null && !this.hierarchical.isEmpty();
        }

        public boolean hasHierarchical() { 
          return this.hierarchical != null && !this.hierarchical.isEmpty();
        }

        /**
         * @param value {@link #hierarchical} (Whether the server can return nested value sets.). This is the underlying object with id, value and extensions. The accessor "getHierarchical" gives direct access to the value
         */
        public TerminologyCapabilitiesExpansionComponent setHierarchicalElement(BooleanType value) { 
          this.hierarchical = value;
          return this;
        }

        /**
         * @return Whether the server can return nested value sets.
         */
        public boolean getHierarchical() { 
          return this.hierarchical == null || this.hierarchical.isEmpty() ? false : this.hierarchical.getValue();
        }

        /**
         * @param value Whether the server can return nested value sets.
         */
        public TerminologyCapabilitiesExpansionComponent setHierarchical(boolean value) { 
            if (this.hierarchical == null)
              this.hierarchical = new BooleanType();
            this.hierarchical.setValue(value);
          return this;
        }

        /**
         * @return {@link #paging} (Whether the server supports paging on expansion.). This is the underlying object with id, value and extensions. The accessor "getPaging" gives direct access to the value
         */
        public BooleanType getPagingElement() { 
          if (this.paging == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesExpansionComponent.paging");
            else if (Configuration.doAutoCreate())
              this.paging = new BooleanType(); // bb
          return this.paging;
        }

        public boolean hasPagingElement() { 
          return this.paging != null && !this.paging.isEmpty();
        }

        public boolean hasPaging() { 
          return this.paging != null && !this.paging.isEmpty();
        }

        /**
         * @param value {@link #paging} (Whether the server supports paging on expansion.). This is the underlying object with id, value and extensions. The accessor "getPaging" gives direct access to the value
         */
        public TerminologyCapabilitiesExpansionComponent setPagingElement(BooleanType value) { 
          this.paging = value;
          return this;
        }

        /**
         * @return Whether the server supports paging on expansion.
         */
        public boolean getPaging() { 
          return this.paging == null || this.paging.isEmpty() ? false : this.paging.getValue();
        }

        /**
         * @param value Whether the server supports paging on expansion.
         */
        public TerminologyCapabilitiesExpansionComponent setPaging(boolean value) { 
            if (this.paging == null)
              this.paging = new BooleanType();
            this.paging.setValue(value);
          return this;
        }

        /**
         * @return {@link #incomplete} (True if requests for incomplete expansions are allowed.). This is the underlying object with id, value and extensions. The accessor "getIncomplete" gives direct access to the value
         */
        public BooleanType getIncompleteElement() { 
          if (this.incomplete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesExpansionComponent.incomplete");
            else if (Configuration.doAutoCreate())
              this.incomplete = new BooleanType(); // bb
          return this.incomplete;
        }

        public boolean hasIncompleteElement() { 
          return this.incomplete != null && !this.incomplete.isEmpty();
        }

        public boolean hasIncomplete() { 
          return this.incomplete != null && !this.incomplete.isEmpty();
        }

        /**
         * @param value {@link #incomplete} (True if requests for incomplete expansions are allowed.). This is the underlying object with id, value and extensions. The accessor "getIncomplete" gives direct access to the value
         */
        public TerminologyCapabilitiesExpansionComponent setIncompleteElement(BooleanType value) { 
          this.incomplete = value;
          return this;
        }

        /**
         * @return True if requests for incomplete expansions are allowed.
         */
        public boolean getIncomplete() { 
          return this.incomplete == null || this.incomplete.isEmpty() ? false : this.incomplete.getValue();
        }

        /**
         * @param value True if requests for incomplete expansions are allowed.
         */
        public TerminologyCapabilitiesExpansionComponent setIncomplete(boolean value) { 
            if (this.incomplete == null)
              this.incomplete = new BooleanType();
            this.incomplete.setValue(value);
          return this;
        }

        /**
         * @return {@link #parameter} (Supported expansion parameter.)
         */
        public List<TerminologyCapabilitiesExpansionParameterComponent> getParameter() { 
          if (this.parameter == null)
            this.parameter = new ArrayList<TerminologyCapabilitiesExpansionParameterComponent>();
          return this.parameter;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TerminologyCapabilitiesExpansionComponent setParameter(List<TerminologyCapabilitiesExpansionParameterComponent> theParameter) { 
          this.parameter = theParameter;
          return this;
        }

        public boolean hasParameter() { 
          if (this.parameter == null)
            return false;
          for (TerminologyCapabilitiesExpansionParameterComponent item : this.parameter)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TerminologyCapabilitiesExpansionParameterComponent addParameter() { //3
          TerminologyCapabilitiesExpansionParameterComponent t = new TerminologyCapabilitiesExpansionParameterComponent();
          if (this.parameter == null)
            this.parameter = new ArrayList<TerminologyCapabilitiesExpansionParameterComponent>();
          this.parameter.add(t);
          return t;
        }

        public TerminologyCapabilitiesExpansionComponent addParameter(TerminologyCapabilitiesExpansionParameterComponent t) { //3
          if (t == null)
            return this;
          if (this.parameter == null)
            this.parameter = new ArrayList<TerminologyCapabilitiesExpansionParameterComponent>();
          this.parameter.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
         */
        public TerminologyCapabilitiesExpansionParameterComponent getParameterFirstRep() { 
          if (getParameter().isEmpty()) {
            addParameter();
          }
          return getParameter().get(0);
        }

        /**
         * @return {@link #textFilter} (Documentation about text searching works.). This is the underlying object with id, value and extensions. The accessor "getTextFilter" gives direct access to the value
         */
        public MarkdownType getTextFilterElement() { 
          if (this.textFilter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesExpansionComponent.textFilter");
            else if (Configuration.doAutoCreate())
              this.textFilter = new MarkdownType(); // bb
          return this.textFilter;
        }

        public boolean hasTextFilterElement() { 
          return this.textFilter != null && !this.textFilter.isEmpty();
        }

        public boolean hasTextFilter() { 
          return this.textFilter != null && !this.textFilter.isEmpty();
        }

        /**
         * @param value {@link #textFilter} (Documentation about text searching works.). This is the underlying object with id, value and extensions. The accessor "getTextFilter" gives direct access to the value
         */
        public TerminologyCapabilitiesExpansionComponent setTextFilterElement(MarkdownType value) { 
          this.textFilter = value;
          return this;
        }

        /**
         * @return Documentation about text searching works.
         */
        public String getTextFilter() { 
          return this.textFilter == null ? null : this.textFilter.getValue();
        }

        /**
         * @param value Documentation about text searching works.
         */
        public TerminologyCapabilitiesExpansionComponent setTextFilter(String value) { 
          if (value == null)
            this.textFilter = null;
          else {
            if (this.textFilter == null)
              this.textFilter = new MarkdownType();
            this.textFilter.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("hierarchical", "boolean", "Whether the server can return nested value sets.", 0, 1, hierarchical));
          children.add(new Property("paging", "boolean", "Whether the server supports paging on expansion.", 0, 1, paging));
          children.add(new Property("incomplete", "boolean", "True if requests for incomplete expansions are allowed.", 0, 1, incomplete));
          children.add(new Property("parameter", "", "Supported expansion parameter.", 0, java.lang.Integer.MAX_VALUE, parameter));
          children.add(new Property("textFilter", "markdown", "Documentation about text searching works.", 0, 1, textFilter));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 857636745: /*hierarchical*/  return new Property("hierarchical", "boolean", "Whether the server can return nested value sets.", 0, 1, hierarchical);
          case -995747956: /*paging*/  return new Property("paging", "boolean", "Whether the server supports paging on expansion.", 0, 1, paging);
          case -1010022050: /*incomplete*/  return new Property("incomplete", "boolean", "True if requests for incomplete expansions are allowed.", 0, 1, incomplete);
          case 1954460585: /*parameter*/  return new Property("parameter", "", "Supported expansion parameter.", 0, java.lang.Integer.MAX_VALUE, parameter);
          case 1469359877: /*textFilter*/  return new Property("textFilter", "markdown", "Documentation about text searching works.", 0, 1, textFilter);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 857636745: /*hierarchical*/ return this.hierarchical == null ? new Base[0] : new Base[] {this.hierarchical}; // BooleanType
        case -995747956: /*paging*/ return this.paging == null ? new Base[0] : new Base[] {this.paging}; // BooleanType
        case -1010022050: /*incomplete*/ return this.incomplete == null ? new Base[0] : new Base[] {this.incomplete}; // BooleanType
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // TerminologyCapabilitiesExpansionParameterComponent
        case 1469359877: /*textFilter*/ return this.textFilter == null ? new Base[0] : new Base[] {this.textFilter}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 857636745: // hierarchical
          this.hierarchical = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -995747956: // paging
          this.paging = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1010022050: // incomplete
          this.incomplete = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1954460585: // parameter
          this.getParameter().add((TerminologyCapabilitiesExpansionParameterComponent) value); // TerminologyCapabilitiesExpansionParameterComponent
          return value;
        case 1469359877: // textFilter
          this.textFilter = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("hierarchical")) {
          this.hierarchical = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("paging")) {
          this.paging = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("incomplete")) {
          this.incomplete = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("parameter")) {
          this.getParameter().add((TerminologyCapabilitiesExpansionParameterComponent) value);
        } else if (name.equals("textFilter")) {
          this.textFilter = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 857636745:  return getHierarchicalElement();
        case -995747956:  return getPagingElement();
        case -1010022050:  return getIncompleteElement();
        case 1954460585:  return addParameter(); 
        case 1469359877:  return getTextFilterElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 857636745: /*hierarchical*/ return new String[] {"boolean"};
        case -995747956: /*paging*/ return new String[] {"boolean"};
        case -1010022050: /*incomplete*/ return new String[] {"boolean"};
        case 1954460585: /*parameter*/ return new String[] {};
        case 1469359877: /*textFilter*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("hierarchical")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.expansion.hierarchical");
        }
        else if (name.equals("paging")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.expansion.paging");
        }
        else if (name.equals("incomplete")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.expansion.incomplete");
        }
        else if (name.equals("parameter")) {
          return addParameter();
        }
        else if (name.equals("textFilter")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.expansion.textFilter");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesExpansionComponent copy() {
        TerminologyCapabilitiesExpansionComponent dst = new TerminologyCapabilitiesExpansionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesExpansionComponent dst) {
        super.copyValues(dst);
        dst.hierarchical = hierarchical == null ? null : hierarchical.copy();
        dst.paging = paging == null ? null : paging.copy();
        dst.incomplete = incomplete == null ? null : incomplete.copy();
        if (parameter != null) {
          dst.parameter = new ArrayList<TerminologyCapabilitiesExpansionParameterComponent>();
          for (TerminologyCapabilitiesExpansionParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
        dst.textFilter = textFilter == null ? null : textFilter.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesExpansionComponent))
          return false;
        TerminologyCapabilitiesExpansionComponent o = (TerminologyCapabilitiesExpansionComponent) other_;
        return compareDeep(hierarchical, o.hierarchical, true) && compareDeep(paging, o.paging, true) && compareDeep(incomplete, o.incomplete, true)
           && compareDeep(parameter, o.parameter, true) && compareDeep(textFilter, o.textFilter, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesExpansionComponent))
          return false;
        TerminologyCapabilitiesExpansionComponent o = (TerminologyCapabilitiesExpansionComponent) other_;
        return compareValues(hierarchical, o.hierarchical, true) && compareValues(paging, o.paging, true) && compareValues(incomplete, o.incomplete, true)
           && compareValues(textFilter, o.textFilter, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(hierarchical, paging, incomplete
          , parameter, textFilter);
      }

  public String fhirType() {
    return "TerminologyCapabilities.expansion";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesExpansionParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name of the supported expansion parameter.
         */
        @Child(name = "name", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the supported expansion parameter", formalDefinition="Name of the supported expansion parameter." )
        protected CodeType name;

        /**
         * Description of support for parameter.
         */
        @Child(name = "documentation", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of support for parameter", formalDefinition="Description of support for parameter." )
        protected StringType documentation;

        private static final long serialVersionUID = -1703372741L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesExpansionParameterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesExpansionParameterComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (Name of the supported expansion parameter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CodeType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesExpansionParameterComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new CodeType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name of the supported expansion parameter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TerminologyCapabilitiesExpansionParameterComponent setNameElement(CodeType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of the supported expansion parameter.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of the supported expansion parameter.
         */
        public TerminologyCapabilitiesExpansionParameterComponent setName(String value) { 
            if (this.name == null)
              this.name = new CodeType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Description of support for parameter.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StringType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesExpansionParameterComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new StringType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Description of support for parameter.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public TerminologyCapabilitiesExpansionParameterComponent setDocumentationElement(StringType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Description of support for parameter.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Description of support for parameter.
         */
        public TerminologyCapabilitiesExpansionParameterComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new StringType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "code", "Name of the supported expansion parameter.", 0, 1, name));
          children.add(new Property("documentation", "string", "Description of support for parameter.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "code", "Name of the supported expansion parameter.", 0, 1, name);
          case 1587405498: /*documentation*/  return new Property("documentation", "string", "Description of support for parameter.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // CodeType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.expansion.parameter.name");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.expansion.parameter.documentation");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesExpansionParameterComponent copy() {
        TerminologyCapabilitiesExpansionParameterComponent dst = new TerminologyCapabilitiesExpansionParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesExpansionParameterComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesExpansionParameterComponent))
          return false;
        TerminologyCapabilitiesExpansionParameterComponent o = (TerminologyCapabilitiesExpansionParameterComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesExpansionParameterComponent))
          return false;
        TerminologyCapabilitiesExpansionParameterComponent o = (TerminologyCapabilitiesExpansionParameterComponent) other_;
        return compareValues(name, o.name, true) && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, documentation);
      }

  public String fhirType() {
    return "TerminologyCapabilities.expansion.parameter";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesValidateCodeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether translations are validated.
         */
        @Child(name = "translations", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether translations are validated", formalDefinition="Whether translations are validated." )
        protected BooleanType translations;

        private static final long serialVersionUID = -1212814906L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesValidateCodeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesValidateCodeComponent(boolean translations) {
        super();
        this.setTranslations(translations);
      }

        /**
         * @return {@link #translations} (Whether translations are validated.). This is the underlying object with id, value and extensions. The accessor "getTranslations" gives direct access to the value
         */
        public BooleanType getTranslationsElement() { 
          if (this.translations == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesValidateCodeComponent.translations");
            else if (Configuration.doAutoCreate())
              this.translations = new BooleanType(); // bb
          return this.translations;
        }

        public boolean hasTranslationsElement() { 
          return this.translations != null && !this.translations.isEmpty();
        }

        public boolean hasTranslations() { 
          return this.translations != null && !this.translations.isEmpty();
        }

        /**
         * @param value {@link #translations} (Whether translations are validated.). This is the underlying object with id, value and extensions. The accessor "getTranslations" gives direct access to the value
         */
        public TerminologyCapabilitiesValidateCodeComponent setTranslationsElement(BooleanType value) { 
          this.translations = value;
          return this;
        }

        /**
         * @return Whether translations are validated.
         */
        public boolean getTranslations() { 
          return this.translations == null || this.translations.isEmpty() ? false : this.translations.getValue();
        }

        /**
         * @param value Whether translations are validated.
         */
        public TerminologyCapabilitiesValidateCodeComponent setTranslations(boolean value) { 
            if (this.translations == null)
              this.translations = new BooleanType();
            this.translations.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("translations", "boolean", "Whether translations are validated.", 0, 1, translations));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1225497630: /*translations*/  return new Property("translations", "boolean", "Whether translations are validated.", 0, 1, translations);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1225497630: /*translations*/ return this.translations == null ? new Base[0] : new Base[] {this.translations}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1225497630: // translations
          this.translations = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("translations")) {
          this.translations = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1225497630:  return getTranslationsElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1225497630: /*translations*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("translations")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.validateCode.translations");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesValidateCodeComponent copy() {
        TerminologyCapabilitiesValidateCodeComponent dst = new TerminologyCapabilitiesValidateCodeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesValidateCodeComponent dst) {
        super.copyValues(dst);
        dst.translations = translations == null ? null : translations.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesValidateCodeComponent))
          return false;
        TerminologyCapabilitiesValidateCodeComponent o = (TerminologyCapabilitiesValidateCodeComponent) other_;
        return compareDeep(translations, o.translations, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesValidateCodeComponent))
          return false;
        TerminologyCapabilitiesValidateCodeComponent o = (TerminologyCapabilitiesValidateCodeComponent) other_;
        return compareValues(translations, o.translations, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(translations);
      }

  public String fhirType() {
    return "TerminologyCapabilities.validateCode";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesTranslationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether the client must identify the map.
         */
        @Child(name = "needsMap", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the client must identify the map", formalDefinition="Whether the client must identify the map." )
        protected BooleanType needsMap;

        private static final long serialVersionUID = -1727843575L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesTranslationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TerminologyCapabilitiesTranslationComponent(boolean needsMap) {
        super();
        this.setNeedsMap(needsMap);
      }

        /**
         * @return {@link #needsMap} (Whether the client must identify the map.). This is the underlying object with id, value and extensions. The accessor "getNeedsMap" gives direct access to the value
         */
        public BooleanType getNeedsMapElement() { 
          if (this.needsMap == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesTranslationComponent.needsMap");
            else if (Configuration.doAutoCreate())
              this.needsMap = new BooleanType(); // bb
          return this.needsMap;
        }

        public boolean hasNeedsMapElement() { 
          return this.needsMap != null && !this.needsMap.isEmpty();
        }

        public boolean hasNeedsMap() { 
          return this.needsMap != null && !this.needsMap.isEmpty();
        }

        /**
         * @param value {@link #needsMap} (Whether the client must identify the map.). This is the underlying object with id, value and extensions. The accessor "getNeedsMap" gives direct access to the value
         */
        public TerminologyCapabilitiesTranslationComponent setNeedsMapElement(BooleanType value) { 
          this.needsMap = value;
          return this;
        }

        /**
         * @return Whether the client must identify the map.
         */
        public boolean getNeedsMap() { 
          return this.needsMap == null || this.needsMap.isEmpty() ? false : this.needsMap.getValue();
        }

        /**
         * @param value Whether the client must identify the map.
         */
        public TerminologyCapabilitiesTranslationComponent setNeedsMap(boolean value) { 
            if (this.needsMap == null)
              this.needsMap = new BooleanType();
            this.needsMap.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("needsMap", "boolean", "Whether the client must identify the map.", 0, 1, needsMap));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 866566527: /*needsMap*/  return new Property("needsMap", "boolean", "Whether the client must identify the map.", 0, 1, needsMap);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 866566527: /*needsMap*/ return this.needsMap == null ? new Base[0] : new Base[] {this.needsMap}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 866566527: // needsMap
          this.needsMap = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("needsMap")) {
          this.needsMap = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 866566527:  return getNeedsMapElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 866566527: /*needsMap*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("needsMap")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.translation.needsMap");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesTranslationComponent copy() {
        TerminologyCapabilitiesTranslationComponent dst = new TerminologyCapabilitiesTranslationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesTranslationComponent dst) {
        super.copyValues(dst);
        dst.needsMap = needsMap == null ? null : needsMap.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesTranslationComponent))
          return false;
        TerminologyCapabilitiesTranslationComponent o = (TerminologyCapabilitiesTranslationComponent) other_;
        return compareDeep(needsMap, o.needsMap, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesTranslationComponent))
          return false;
        TerminologyCapabilitiesTranslationComponent o = (TerminologyCapabilitiesTranslationComponent) other_;
        return compareValues(needsMap, o.needsMap, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(needsMap);
      }

  public String fhirType() {
    return "TerminologyCapabilities.translation";

  }

  }

    @Block()
    public static class TerminologyCapabilitiesClosureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * If cross-system closure is supported.
         */
        @Child(name = "translation", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If cross-system closure is supported", formalDefinition="If cross-system closure is supported." )
        protected BooleanType translation;

        private static final long serialVersionUID = 1900484343L;

    /**
     * Constructor
     */
      public TerminologyCapabilitiesClosureComponent() {
        super();
      }

        /**
         * @return {@link #translation} (If cross-system closure is supported.). This is the underlying object with id, value and extensions. The accessor "getTranslation" gives direct access to the value
         */
        public BooleanType getTranslationElement() { 
          if (this.translation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TerminologyCapabilitiesClosureComponent.translation");
            else if (Configuration.doAutoCreate())
              this.translation = new BooleanType(); // bb
          return this.translation;
        }

        public boolean hasTranslationElement() { 
          return this.translation != null && !this.translation.isEmpty();
        }

        public boolean hasTranslation() { 
          return this.translation != null && !this.translation.isEmpty();
        }

        /**
         * @param value {@link #translation} (If cross-system closure is supported.). This is the underlying object with id, value and extensions. The accessor "getTranslation" gives direct access to the value
         */
        public TerminologyCapabilitiesClosureComponent setTranslationElement(BooleanType value) { 
          this.translation = value;
          return this;
        }

        /**
         * @return If cross-system closure is supported.
         */
        public boolean getTranslation() { 
          return this.translation == null || this.translation.isEmpty() ? false : this.translation.getValue();
        }

        /**
         * @param value If cross-system closure is supported.
         */
        public TerminologyCapabilitiesClosureComponent setTranslation(boolean value) { 
            if (this.translation == null)
              this.translation = new BooleanType();
            this.translation.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("translation", "boolean", "If cross-system closure is supported.", 0, 1, translation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1840647503: /*translation*/  return new Property("translation", "boolean", "If cross-system closure is supported.", 0, 1, translation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1840647503: /*translation*/ return this.translation == null ? new Base[0] : new Base[] {this.translation}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1840647503: // translation
          this.translation = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("translation")) {
          this.translation = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1840647503:  return getTranslationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1840647503: /*translation*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("translation")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.closure.translation");
        }
        else
          return super.addChild(name);
      }

      public TerminologyCapabilitiesClosureComponent copy() {
        TerminologyCapabilitiesClosureComponent dst = new TerminologyCapabilitiesClosureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilitiesClosureComponent dst) {
        super.copyValues(dst);
        dst.translation = translation == null ? null : translation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesClosureComponent))
          return false;
        TerminologyCapabilitiesClosureComponent o = (TerminologyCapabilitiesClosureComponent) other_;
        return compareDeep(translation, o.translation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilitiesClosureComponent))
          return false;
        TerminologyCapabilitiesClosureComponent o = (TerminologyCapabilitiesClosureComponent) other_;
        return compareValues(translation, o.translation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(translation);
      }

  public String fhirType() {
    return "TerminologyCapabilities.closure";

  }

  }

    /**
     * An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this terminology capabilities, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this terminology capabilities when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the terminology capabilities", formalDefinition="A formal identifier that is used to identify this terminology capabilities when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the terminology capabilities", formalDefinition="The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this terminology capabilities (computer friendly)", formalDefinition="A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the terminology capabilities.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this terminology capabilities (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the terminology capabilities." )
    protected StringType title;

    /**
     * The status of this terminology capabilities. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this terminology capabilities. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.
     */
    @Child(name = "publisher", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the terminology capabilities", formalDefinition="A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate terminology capabilities instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate terminology capabilities instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the terminology capabilities is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for terminology capabilities (if applicable)", formalDefinition="A legal or geographic region in which the terminology capabilities is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this terminology capabilities is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this terminology capabilities is defined", formalDefinition="Explanation of why this terminology capabilities is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities." )
    protected MarkdownType copyright;

    /**
     * The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    @Child(name = "kind", type = {CodeType.class}, order=15, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="instance | capability | requirements", formalDefinition="The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/capability-statement-kind")
    protected Enumeration<CapabilityStatementKind> kind;

    /**
     * Software that is covered by this terminology capability statement.  It is used when the statement describes the capabilities of a particular software version, independent of an installation.
     */
    @Child(name = "software", type = {}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Software that is covered by this terminology capability statement", formalDefinition="Software that is covered by this terminology capability statement.  It is used when the statement describes the capabilities of a particular software version, independent of an installation." )
    protected TerminologyCapabilitiesSoftwareComponent software;

    /**
     * Identifies a specific implementation instance that is described by the terminology capability statement - i.e. a particular installation, rather than the capabilities of a software program.
     */
    @Child(name = "implementation", type = {}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this describes a specific instance", formalDefinition="Identifies a specific implementation instance that is described by the terminology capability statement - i.e. a particular installation, rather than the capabilities of a software program." )
    protected TerminologyCapabilitiesImplementationComponent implementation;

    /**
     * Whether the server supports lockedDate.
     */
    @Child(name = "lockedDate", type = {BooleanType.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether lockedDate is supported", formalDefinition="Whether the server supports lockedDate." )
    protected BooleanType lockedDate;

    /**
     * Identifies a code system that is supported by the server. If there is a no code system URL, then this declares the general assumptions a client can make about support for any CodeSystem resource.
     */
    @Child(name = "codeSystem", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A code system supported by the server", formalDefinition="Identifies a code system that is supported by the server. If there is a no code system URL, then this declares the general assumptions a client can make about support for any CodeSystem resource." )
    protected List<TerminologyCapabilitiesCodeSystemComponent> codeSystem;

    /**
     * Information about the [ValueSet/$expand](valueset-operation-expand.html) operation.
     */
    @Child(name = "expansion", type = {}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Information about the [ValueSet/$expand](valueset-operation-expand.html) operation", formalDefinition="Information about the [ValueSet/$expand](valueset-operation-expand.html) operation." )
    protected TerminologyCapabilitiesExpansionComponent expansion;

    /**
     * The degree to which the server supports the code search parameter on ValueSet, if it is supported.
     */
    @Child(name = "codeSearch", type = {CodeType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="in-compose | in-expansion | in-compose-or-expansion", formalDefinition="The degree to which the server supports the code search parameter on ValueSet, if it is supported." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/code-search-support")
    protected Enumeration<CodeSearchSupport> codeSearch;

    /**
     * Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation.
     */
    @Child(name = "validateCode", type = {}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation", formalDefinition="Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation." )
    protected TerminologyCapabilitiesValidateCodeComponent validateCode;

    /**
     * Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation.
     */
    @Child(name = "translation", type = {}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation", formalDefinition="Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation." )
    protected TerminologyCapabilitiesTranslationComponent translation;

    /**
     * Whether the $closure operation is supported.
     */
    @Child(name = "closure", type = {}, order=24, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Information about the [ConceptMap/$closure](conceptmap-operation-closure.html) operation", formalDefinition="Whether the $closure operation is supported." )
    protected TerminologyCapabilitiesClosureComponent closure;

    private static final long serialVersionUID = 1685724657L;

  /**
   * Constructor
   */
    public TerminologyCapabilities() {
      super();
    }

  /**
   * Constructor
   */
    public TerminologyCapabilities(PublicationStatus status, Date date, CapabilityStatementKind kind) {
      super();
      this.setStatus(status);
      this.setDate(date);
      this.setKind(kind);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public TerminologyCapabilities setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.
     */
    public TerminologyCapabilities setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this terminology capabilities when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TerminologyCapabilities setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public TerminologyCapabilities addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.version");
        else if (Configuration.doAutoCreate())
          this.version = new StringType(); // bb
      return this.version;
    }

    public boolean hasVersionElement() { 
      return this.version != null && !this.version.isEmpty();
    }

    public boolean hasVersion() { 
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public TerminologyCapabilities setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public TerminologyCapabilities setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public TerminologyCapabilities setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public TerminologyCapabilities setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the terminology capabilities.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the terminology capabilities.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public TerminologyCapabilities setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the terminology capabilities.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the terminology capabilities.
     */
    public TerminologyCapabilities setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this terminology capabilities. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this terminology capabilities. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public TerminologyCapabilities setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this terminology capabilities. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this terminology capabilities. Enables tracking the life-cycle of the content.
     */
    public TerminologyCapabilities setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.experimental");
        else if (Configuration.doAutoCreate())
          this.experimental = new BooleanType(); // bb
      return this.experimental;
    }

    public boolean hasExperimentalElement() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    public boolean hasExperimental() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public TerminologyCapabilities setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public TerminologyCapabilities setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public TerminologyCapabilities setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.
     */
    public TerminologyCapabilities setDate(Date value) { 
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new StringType(); // bb
      return this.publisher;
    }

    public boolean hasPublisherElement() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public TerminologyCapabilities setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.
     */
    public TerminologyCapabilities setPublisher(String value) { 
      if (Utilities.noString(value))
        this.publisher = null;
      else {
        if (this.publisher == null)
          this.publisher = new StringType();
        this.publisher.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TerminologyCapabilities setContact(List<ContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public TerminologyCapabilities addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public TerminologyCapabilities setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    public TerminologyCapabilities setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate terminology capabilities instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TerminologyCapabilities setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public TerminologyCapabilities addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the terminology capabilities is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TerminologyCapabilities setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      this.jurisdiction = theJurisdiction;
      return this;
    }

    public boolean hasJurisdiction() { 
      if (this.jurisdiction == null)
        return false;
      for (CodeableConcept item : this.jurisdiction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public TerminologyCapabilities addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this terminology capabilities is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new MarkdownType(); // bb
      return this.purpose;
    }

    public boolean hasPurposeElement() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Explanation of why this terminology capabilities is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public TerminologyCapabilities setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this terminology capabilities is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this terminology capabilities is needed and why it has been designed as it has.
     */
    public TerminologyCapabilities setPurpose(String value) { 
      if (value == null)
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public TerminologyCapabilities setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.
     */
    public TerminologyCapabilities setCopyright(String value) { 
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #kind} (The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public Enumeration<CapabilityStatementKind> getKindElement() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new Enumeration<CapabilityStatementKind>(new CapabilityStatementKindEnumFactory()); // bb
      return this.kind;
    }

    public boolean hasKindElement() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public TerminologyCapabilities setKindElement(Enumeration<CapabilityStatementKind> value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    public CapabilityStatementKind getKind() { 
      return this.kind == null ? null : this.kind.getValue();
    }

    /**
     * @param value The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    public TerminologyCapabilities setKind(CapabilityStatementKind value) { 
        if (this.kind == null)
          this.kind = new Enumeration<CapabilityStatementKind>(new CapabilityStatementKindEnumFactory());
        this.kind.setValue(value);
      return this;
    }

    /**
     * @return {@link #software} (Software that is covered by this terminology capability statement.  It is used when the statement describes the capabilities of a particular software version, independent of an installation.)
     */
    public TerminologyCapabilitiesSoftwareComponent getSoftware() { 
      if (this.software == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.software");
        else if (Configuration.doAutoCreate())
          this.software = new TerminologyCapabilitiesSoftwareComponent(); // cc
      return this.software;
    }

    public boolean hasSoftware() { 
      return this.software != null && !this.software.isEmpty();
    }

    /**
     * @param value {@link #software} (Software that is covered by this terminology capability statement.  It is used when the statement describes the capabilities of a particular software version, independent of an installation.)
     */
    public TerminologyCapabilities setSoftware(TerminologyCapabilitiesSoftwareComponent value) { 
      this.software = value;
      return this;
    }

    /**
     * @return {@link #implementation} (Identifies a specific implementation instance that is described by the terminology capability statement - i.e. a particular installation, rather than the capabilities of a software program.)
     */
    public TerminologyCapabilitiesImplementationComponent getImplementation() { 
      if (this.implementation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.implementation");
        else if (Configuration.doAutoCreate())
          this.implementation = new TerminologyCapabilitiesImplementationComponent(); // cc
      return this.implementation;
    }

    public boolean hasImplementation() { 
      return this.implementation != null && !this.implementation.isEmpty();
    }

    /**
     * @param value {@link #implementation} (Identifies a specific implementation instance that is described by the terminology capability statement - i.e. a particular installation, rather than the capabilities of a software program.)
     */
    public TerminologyCapabilities setImplementation(TerminologyCapabilitiesImplementationComponent value) { 
      this.implementation = value;
      return this;
    }

    /**
     * @return {@link #lockedDate} (Whether the server supports lockedDate.). This is the underlying object with id, value and extensions. The accessor "getLockedDate" gives direct access to the value
     */
    public BooleanType getLockedDateElement() { 
      if (this.lockedDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.lockedDate");
        else if (Configuration.doAutoCreate())
          this.lockedDate = new BooleanType(); // bb
      return this.lockedDate;
    }

    public boolean hasLockedDateElement() { 
      return this.lockedDate != null && !this.lockedDate.isEmpty();
    }

    public boolean hasLockedDate() { 
      return this.lockedDate != null && !this.lockedDate.isEmpty();
    }

    /**
     * @param value {@link #lockedDate} (Whether the server supports lockedDate.). This is the underlying object with id, value and extensions. The accessor "getLockedDate" gives direct access to the value
     */
    public TerminologyCapabilities setLockedDateElement(BooleanType value) { 
      this.lockedDate = value;
      return this;
    }

    /**
     * @return Whether the server supports lockedDate.
     */
    public boolean getLockedDate() { 
      return this.lockedDate == null || this.lockedDate.isEmpty() ? false : this.lockedDate.getValue();
    }

    /**
     * @param value Whether the server supports lockedDate.
     */
    public TerminologyCapabilities setLockedDate(boolean value) { 
        if (this.lockedDate == null)
          this.lockedDate = new BooleanType();
        this.lockedDate.setValue(value);
      return this;
    }

    /**
     * @return {@link #codeSystem} (Identifies a code system that is supported by the server. If there is a no code system URL, then this declares the general assumptions a client can make about support for any CodeSystem resource.)
     */
    public List<TerminologyCapabilitiesCodeSystemComponent> getCodeSystem() { 
      if (this.codeSystem == null)
        this.codeSystem = new ArrayList<TerminologyCapabilitiesCodeSystemComponent>();
      return this.codeSystem;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TerminologyCapabilities setCodeSystem(List<TerminologyCapabilitiesCodeSystemComponent> theCodeSystem) { 
      this.codeSystem = theCodeSystem;
      return this;
    }

    public boolean hasCodeSystem() { 
      if (this.codeSystem == null)
        return false;
      for (TerminologyCapabilitiesCodeSystemComponent item : this.codeSystem)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TerminologyCapabilitiesCodeSystemComponent addCodeSystem() { //3
      TerminologyCapabilitiesCodeSystemComponent t = new TerminologyCapabilitiesCodeSystemComponent();
      if (this.codeSystem == null)
        this.codeSystem = new ArrayList<TerminologyCapabilitiesCodeSystemComponent>();
      this.codeSystem.add(t);
      return t;
    }

    public TerminologyCapabilities addCodeSystem(TerminologyCapabilitiesCodeSystemComponent t) { //3
      if (t == null)
        return this;
      if (this.codeSystem == null)
        this.codeSystem = new ArrayList<TerminologyCapabilitiesCodeSystemComponent>();
      this.codeSystem.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #codeSystem}, creating it if it does not already exist {3}
     */
    public TerminologyCapabilitiesCodeSystemComponent getCodeSystemFirstRep() { 
      if (getCodeSystem().isEmpty()) {
        addCodeSystem();
      }
      return getCodeSystem().get(0);
    }

    /**
     * @return {@link #expansion} (Information about the [ValueSet/$expand](valueset-operation-expand.html) operation.)
     */
    public TerminologyCapabilitiesExpansionComponent getExpansion() { 
      if (this.expansion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.expansion");
        else if (Configuration.doAutoCreate())
          this.expansion = new TerminologyCapabilitiesExpansionComponent(); // cc
      return this.expansion;
    }

    public boolean hasExpansion() { 
      return this.expansion != null && !this.expansion.isEmpty();
    }

    /**
     * @param value {@link #expansion} (Information about the [ValueSet/$expand](valueset-operation-expand.html) operation.)
     */
    public TerminologyCapabilities setExpansion(TerminologyCapabilitiesExpansionComponent value) { 
      this.expansion = value;
      return this;
    }

    /**
     * @return {@link #codeSearch} (The degree to which the server supports the code search parameter on ValueSet, if it is supported.). This is the underlying object with id, value and extensions. The accessor "getCodeSearch" gives direct access to the value
     */
    public Enumeration<CodeSearchSupport> getCodeSearchElement() { 
      if (this.codeSearch == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.codeSearch");
        else if (Configuration.doAutoCreate())
          this.codeSearch = new Enumeration<CodeSearchSupport>(new CodeSearchSupportEnumFactory()); // bb
      return this.codeSearch;
    }

    public boolean hasCodeSearchElement() { 
      return this.codeSearch != null && !this.codeSearch.isEmpty();
    }

    public boolean hasCodeSearch() { 
      return this.codeSearch != null && !this.codeSearch.isEmpty();
    }

    /**
     * @param value {@link #codeSearch} (The degree to which the server supports the code search parameter on ValueSet, if it is supported.). This is the underlying object with id, value and extensions. The accessor "getCodeSearch" gives direct access to the value
     */
    public TerminologyCapabilities setCodeSearchElement(Enumeration<CodeSearchSupport> value) { 
      this.codeSearch = value;
      return this;
    }

    /**
     * @return The degree to which the server supports the code search parameter on ValueSet, if it is supported.
     */
    public CodeSearchSupport getCodeSearch() { 
      return this.codeSearch == null ? null : this.codeSearch.getValue();
    }

    /**
     * @param value The degree to which the server supports the code search parameter on ValueSet, if it is supported.
     */
    public TerminologyCapabilities setCodeSearch(CodeSearchSupport value) { 
      if (value == null)
        this.codeSearch = null;
      else {
        if (this.codeSearch == null)
          this.codeSearch = new Enumeration<CodeSearchSupport>(new CodeSearchSupportEnumFactory());
        this.codeSearch.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #validateCode} (Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation.)
     */
    public TerminologyCapabilitiesValidateCodeComponent getValidateCode() { 
      if (this.validateCode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.validateCode");
        else if (Configuration.doAutoCreate())
          this.validateCode = new TerminologyCapabilitiesValidateCodeComponent(); // cc
      return this.validateCode;
    }

    public boolean hasValidateCode() { 
      return this.validateCode != null && !this.validateCode.isEmpty();
    }

    /**
     * @param value {@link #validateCode} (Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation.)
     */
    public TerminologyCapabilities setValidateCode(TerminologyCapabilitiesValidateCodeComponent value) { 
      this.validateCode = value;
      return this;
    }

    /**
     * @return {@link #translation} (Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation.)
     */
    public TerminologyCapabilitiesTranslationComponent getTranslation() { 
      if (this.translation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.translation");
        else if (Configuration.doAutoCreate())
          this.translation = new TerminologyCapabilitiesTranslationComponent(); // cc
      return this.translation;
    }

    public boolean hasTranslation() { 
      return this.translation != null && !this.translation.isEmpty();
    }

    /**
     * @param value {@link #translation} (Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation.)
     */
    public TerminologyCapabilities setTranslation(TerminologyCapabilitiesTranslationComponent value) { 
      this.translation = value;
      return this;
    }

    /**
     * @return {@link #closure} (Whether the $closure operation is supported.)
     */
    public TerminologyCapabilitiesClosureComponent getClosure() { 
      if (this.closure == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TerminologyCapabilities.closure");
        else if (Configuration.doAutoCreate())
          this.closure = new TerminologyCapabilitiesClosureComponent(); // cc
      return this.closure;
    }

    public boolean hasClosure() { 
      return this.closure != null && !this.closure.isEmpty();
    }

    /**
     * @param value {@link #closure} (Whether the $closure operation is supported.)
     */
    public TerminologyCapabilities setClosure(TerminologyCapabilitiesClosureComponent value) { 
      this.closure = value;
      return this;
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getVersionAlgorithmMax() { 
      return 0;
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmStringType() { 
      return false;////K 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmCoding() { 
      return false;////K 
    }
    public boolean hasVersionAlgorithm() { 
      return false;
    }
    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public TerminologyCapabilities setVersionAlgorithm(DataType value) { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"versionAlgorithm[x]\""); 
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightLabelMax() { 
      return 0;
    }
    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"copyrightLabel\"");
    }

    public boolean hasCopyrightLabelElement() { 
      return false;
    }
    public boolean hasCopyrightLabel() {
      return false;
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public TerminologyCapabilities setCopyrightLabelElement(StringType value) { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"copyrightLabel\""); 
    }
    public String getCopyrightLabel() { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"copyrightLabel\""); 
    }
    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public TerminologyCapabilities setCopyrightLabel(String value) { 
      throw new Error("The resource type \"TerminologyCapabilities\" does not implement the property \"copyrightLabel\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this terminology capabilities when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the terminology capabilities.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this terminology capabilities. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate terminology capabilities instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the terminology capabilities is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this terminology capabilities is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.", 0, 1, copyright));
        children.add(new Property("kind", "code", "The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).", 0, 1, kind));
        children.add(new Property("software", "", "Software that is covered by this terminology capability statement.  It is used when the statement describes the capabilities of a particular software version, independent of an installation.", 0, 1, software));
        children.add(new Property("implementation", "", "Identifies a specific implementation instance that is described by the terminology capability statement - i.e. a particular installation, rather than the capabilities of a software program.", 0, 1, implementation));
        children.add(new Property("lockedDate", "boolean", "Whether the server supports lockedDate.", 0, 1, lockedDate));
        children.add(new Property("codeSystem", "", "Identifies a code system that is supported by the server. If there is a no code system URL, then this declares the general assumptions a client can make about support for any CodeSystem resource.", 0, java.lang.Integer.MAX_VALUE, codeSystem));
        children.add(new Property("expansion", "", "Information about the [ValueSet/$expand](valueset-operation-expand.html) operation.", 0, 1, expansion));
        children.add(new Property("codeSearch", "code", "The degree to which the server supports the code search parameter on ValueSet, if it is supported.", 0, 1, codeSearch));
        children.add(new Property("validateCode", "", "Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation.", 0, 1, validateCode));
        children.add(new Property("translation", "", "Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation.", 0, 1, translation));
        children.add(new Property("closure", "", "Whether the $closure operation is supported.", 0, 1, closure));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this terminology capabilities when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this terminology capabilities is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the terminology capabilities is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this terminology capabilities when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the terminology capabilities when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the terminology capabilities author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the terminology capabilities. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the terminology capabilities.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this terminology capabilities. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this terminology capabilities is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the terminology capabilities was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the terminology capabilities changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the terminology capabilities.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the terminology capabilities from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate terminology capabilities instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the terminology capabilities is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this terminology capabilities is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the terminology capabilities and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the terminology capabilities.", 0, 1, copyright);
        case 3292052: /*kind*/  return new Property("kind", "code", "The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).", 0, 1, kind);
        case 1319330215: /*software*/  return new Property("software", "", "Software that is covered by this terminology capability statement.  It is used when the statement describes the capabilities of a particular software version, independent of an installation.", 0, 1, software);
        case 1683336114: /*implementation*/  return new Property("implementation", "", "Identifies a specific implementation instance that is described by the terminology capability statement - i.e. a particular installation, rather than the capabilities of a software program.", 0, 1, implementation);
        case 1391591896: /*lockedDate*/  return new Property("lockedDate", "boolean", "Whether the server supports lockedDate.", 0, 1, lockedDate);
        case -916511108: /*codeSystem*/  return new Property("codeSystem", "", "Identifies a code system that is supported by the server. If there is a no code system URL, then this declares the general assumptions a client can make about support for any CodeSystem resource.", 0, java.lang.Integer.MAX_VALUE, codeSystem);
        case 17878207: /*expansion*/  return new Property("expansion", "", "Information about the [ValueSet/$expand](valueset-operation-expand.html) operation.", 0, 1, expansion);
        case -935519755: /*codeSearch*/  return new Property("codeSearch", "code", "The degree to which the server supports the code search parameter on ValueSet, if it is supported.", 0, 1, codeSearch);
        case 1080737827: /*validateCode*/  return new Property("validateCode", "", "Information about the [ValueSet/$validate-code](valueset-operation-validate-code.html) operation.", 0, 1, validateCode);
        case -1840647503: /*translation*/  return new Property("translation", "", "Information about the [ConceptMap/$translate](conceptmap-operation-translate.html) operation.", 0, 1, translation);
        case 866552379: /*closure*/  return new Property("closure", "", "Whether the $closure operation is supported.", 0, 1, closure);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<CapabilityStatementKind>
        case 1319330215: /*software*/ return this.software == null ? new Base[0] : new Base[] {this.software}; // TerminologyCapabilitiesSoftwareComponent
        case 1683336114: /*implementation*/ return this.implementation == null ? new Base[0] : new Base[] {this.implementation}; // TerminologyCapabilitiesImplementationComponent
        case 1391591896: /*lockedDate*/ return this.lockedDate == null ? new Base[0] : new Base[] {this.lockedDate}; // BooleanType
        case -916511108: /*codeSystem*/ return this.codeSystem == null ? new Base[0] : this.codeSystem.toArray(new Base[this.codeSystem.size()]); // TerminologyCapabilitiesCodeSystemComponent
        case 17878207: /*expansion*/ return this.expansion == null ? new Base[0] : new Base[] {this.expansion}; // TerminologyCapabilitiesExpansionComponent
        case -935519755: /*codeSearch*/ return this.codeSearch == null ? new Base[0] : new Base[] {this.codeSearch}; // Enumeration<CodeSearchSupport>
        case 1080737827: /*validateCode*/ return this.validateCode == null ? new Base[0] : new Base[] {this.validateCode}; // TerminologyCapabilitiesValidateCodeComponent
        case -1840647503: /*translation*/ return this.translation == null ? new Base[0] : new Base[] {this.translation}; // TerminologyCapabilitiesTranslationComponent
        case 866552379: /*closure*/ return this.closure == null ? new Base[0] : new Base[] {this.closure}; // TerminologyCapabilitiesClosureComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3292052: // kind
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
          return value;
        case 1319330215: // software
          this.software = (TerminologyCapabilitiesSoftwareComponent) value; // TerminologyCapabilitiesSoftwareComponent
          return value;
        case 1683336114: // implementation
          this.implementation = (TerminologyCapabilitiesImplementationComponent) value; // TerminologyCapabilitiesImplementationComponent
          return value;
        case 1391591896: // lockedDate
          this.lockedDate = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -916511108: // codeSystem
          this.getCodeSystem().add((TerminologyCapabilitiesCodeSystemComponent) value); // TerminologyCapabilitiesCodeSystemComponent
          return value;
        case 17878207: // expansion
          this.expansion = (TerminologyCapabilitiesExpansionComponent) value; // TerminologyCapabilitiesExpansionComponent
          return value;
        case -935519755: // codeSearch
          value = new CodeSearchSupportEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.codeSearch = (Enumeration) value; // Enumeration<CodeSearchSupport>
          return value;
        case 1080737827: // validateCode
          this.validateCode = (TerminologyCapabilitiesValidateCodeComponent) value; // TerminologyCapabilitiesValidateCodeComponent
          return value;
        case -1840647503: // translation
          this.translation = (TerminologyCapabilitiesTranslationComponent) value; // TerminologyCapabilitiesTranslationComponent
          return value;
        case 866552379: // closure
          this.closure = (TerminologyCapabilitiesClosureComponent) value; // TerminologyCapabilitiesClosureComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("kind")) {
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
        } else if (name.equals("software")) {
          this.software = (TerminologyCapabilitiesSoftwareComponent) value; // TerminologyCapabilitiesSoftwareComponent
        } else if (name.equals("implementation")) {
          this.implementation = (TerminologyCapabilitiesImplementationComponent) value; // TerminologyCapabilitiesImplementationComponent
        } else if (name.equals("lockedDate")) {
          this.lockedDate = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("codeSystem")) {
          this.getCodeSystem().add((TerminologyCapabilitiesCodeSystemComponent) value);
        } else if (name.equals("expansion")) {
          this.expansion = (TerminologyCapabilitiesExpansionComponent) value; // TerminologyCapabilitiesExpansionComponent
        } else if (name.equals("codeSearch")) {
          value = new CodeSearchSupportEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.codeSearch = (Enumeration) value; // Enumeration<CodeSearchSupport>
        } else if (name.equals("validateCode")) {
          this.validateCode = (TerminologyCapabilitiesValidateCodeComponent) value; // TerminologyCapabilitiesValidateCodeComponent
        } else if (name.equals("translation")) {
          this.translation = (TerminologyCapabilitiesTranslationComponent) value; // TerminologyCapabilitiesTranslationComponent
        } else if (name.equals("closure")) {
          this.closure = (TerminologyCapabilitiesClosureComponent) value; // TerminologyCapabilitiesClosureComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 3292052:  return getKindElement();
        case 1319330215:  return getSoftware();
        case 1683336114:  return getImplementation();
        case 1391591896:  return getLockedDateElement();
        case -916511108:  return addCodeSystem(); 
        case 17878207:  return getExpansion();
        case -935519755:  return getCodeSearchElement();
        case 1080737827:  return getValidateCode();
        case -1840647503:  return getTranslation();
        case 866552379:  return getClosure();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case 1319330215: /*software*/ return new String[] {};
        case 1683336114: /*implementation*/ return new String[] {};
        case 1391591896: /*lockedDate*/ return new String[] {"boolean"};
        case -916511108: /*codeSystem*/ return new String[] {};
        case 17878207: /*expansion*/ return new String[] {};
        case -935519755: /*codeSearch*/ return new String[] {"code"};
        case 1080737827: /*validateCode*/ return new String[] {};
        case -1840647503: /*translation*/ return new String[] {};
        case 866552379: /*closure*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.copyright");
        }
        else if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.kind");
        }
        else if (name.equals("software")) {
          this.software = new TerminologyCapabilitiesSoftwareComponent();
          return this.software;
        }
        else if (name.equals("implementation")) {
          this.implementation = new TerminologyCapabilitiesImplementationComponent();
          return this.implementation;
        }
        else if (name.equals("lockedDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.lockedDate");
        }
        else if (name.equals("codeSystem")) {
          return addCodeSystem();
        }
        else if (name.equals("expansion")) {
          this.expansion = new TerminologyCapabilitiesExpansionComponent();
          return this.expansion;
        }
        else if (name.equals("codeSearch")) {
          throw new FHIRException("Cannot call addChild on a primitive type TerminologyCapabilities.codeSearch");
        }
        else if (name.equals("validateCode")) {
          this.validateCode = new TerminologyCapabilitiesValidateCodeComponent();
          return this.validateCode;
        }
        else if (name.equals("translation")) {
          this.translation = new TerminologyCapabilitiesTranslationComponent();
          return this.translation;
        }
        else if (name.equals("closure")) {
          this.closure = new TerminologyCapabilitiesClosureComponent();
          return this.closure;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "TerminologyCapabilities";

  }

      public TerminologyCapabilities copy() {
        TerminologyCapabilities dst = new TerminologyCapabilities();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TerminologyCapabilities dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.kind = kind == null ? null : kind.copy();
        dst.software = software == null ? null : software.copy();
        dst.implementation = implementation == null ? null : implementation.copy();
        dst.lockedDate = lockedDate == null ? null : lockedDate.copy();
        if (codeSystem != null) {
          dst.codeSystem = new ArrayList<TerminologyCapabilitiesCodeSystemComponent>();
          for (TerminologyCapabilitiesCodeSystemComponent i : codeSystem)
            dst.codeSystem.add(i.copy());
        };
        dst.expansion = expansion == null ? null : expansion.copy();
        dst.codeSearch = codeSearch == null ? null : codeSearch.copy();
        dst.validateCode = validateCode == null ? null : validateCode.copy();
        dst.translation = translation == null ? null : translation.copy();
        dst.closure = closure == null ? null : closure.copy();
      }

      protected TerminologyCapabilities typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilities))
          return false;
        TerminologyCapabilities o = (TerminologyCapabilities) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(status, o.status, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(kind, o.kind, true) && compareDeep(software, o.software, true) && compareDeep(implementation, o.implementation, true)
           && compareDeep(lockedDate, o.lockedDate, true) && compareDeep(codeSystem, o.codeSystem, true) && compareDeep(expansion, o.expansion, true)
           && compareDeep(codeSearch, o.codeSearch, true) && compareDeep(validateCode, o.validateCode, true)
           && compareDeep(translation, o.translation, true) && compareDeep(closure, o.closure, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TerminologyCapabilities))
          return false;
        TerminologyCapabilities o = (TerminologyCapabilities) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(kind, o.kind, true)
           && compareValues(lockedDate, o.lockedDate, true) && compareValues(codeSearch, o.codeSearch, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, status, experimental, date, publisher, contact, description, useContext
          , jurisdiction, purpose, copyright, kind, software, implementation, lockedDate
          , codeSystem, expansion, codeSearch, validateCode, translation, closure);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.TerminologyCapabilities;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="CapabilityStatement.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement\r\n* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map\r\n* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide\r\n* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition\r\n* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities\r\n* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="CapabilityStatement.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement\r\n* [CodeSystem](codesystem.html): A use context type and value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map\r\n* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide\r\n* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition\r\n* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities\r\n* [ValueSet](valueset.html): A use context type and value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="CapabilityStatement.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | ValueSet.useContext.code", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement\r\n* [CodeSystem](codesystem.html): A type of use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map\r\n* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide\r\n* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition\r\n* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A type of use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities\r\n* [ValueSet](valueset.html): A type of use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(CapabilityStatement.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(CapabilityStatement.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(CapabilityStatement.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CapabilityStatement.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | GraphDefinition.date | ImplementationGuide.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | TerminologyCapabilities.date | ValueSet.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="CapabilityStatement.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | GraphDefinition.date | ImplementationGuide.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | TerminologyCapabilities.date | ValueSet.date", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): The capability statement publication date\r\n* [CodeSystem](codesystem.html): The code system publication date\r\n* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date\r\n* [ConceptMap](conceptmap.html): The concept map publication date\r\n* [GraphDefinition](graphdefinition.html): The graph definition publication date\r\n* [ImplementationGuide](implementationguide.html): The implementation guide publication date\r\n* [MessageDefinition](messagedefinition.html): The message definition publication date\r\n* [NamingSystem](namingsystem.html): The naming system publication date\r\n* [OperationDefinition](operationdefinition.html): The operation definition publication date\r\n* [SearchParameter](searchparameter.html): The search parameter publication date\r\n* [StructureDefinition](structuredefinition.html): The structure definition publication date\r\n* [StructureMap](structuremap.html): The structure map publication date\r\n* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date\r\n* [ValueSet](valueset.html): The value set publication date\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CapabilityStatement.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | GraphDefinition.date | ImplementationGuide.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | TerminologyCapabilities.date | ValueSet.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | GraphDefinition.description | ImplementationGuide.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | ValueSet.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="CapabilityStatement.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | GraphDefinition.description | ImplementationGuide.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | ValueSet.description", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): The description of the capability statement\r\n* [CodeSystem](codesystem.html): The description of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition\r\n* [ConceptMap](conceptmap.html): The description of the concept map\r\n* [GraphDefinition](graphdefinition.html): The description of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The description of the implementation guide\r\n* [MessageDefinition](messagedefinition.html): The description of the message definition\r\n* [NamingSystem](namingsystem.html): The description of the naming system\r\n* [OperationDefinition](operationdefinition.html): The description of the operation definition\r\n* [SearchParameter](searchparameter.html): The description of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The description of the structure definition\r\n* [StructureMap](structuremap.html): The description of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities\r\n* [ValueSet](valueset.html): The description of the value set\r\n", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | GraphDefinition.description | ImplementationGuide.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | ValueSet.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CodeSystem.identifier | ConceptMap.identifier | MessageDefinition.identifier | NamingSystem.identifier | StructureDefinition.identifier | StructureMap.identifier | TerminologyCapabilities.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="CodeSystem.identifier | ConceptMap.identifier | MessageDefinition.identifier | NamingSystem.identifier | StructureDefinition.identifier | StructureMap.identifier | TerminologyCapabilities.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CodeSystem.identifier | ConceptMap.identifier | MessageDefinition.identifier | NamingSystem.identifier | StructureDefinition.identifier | StructureMap.identifier | TerminologyCapabilities.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="CapabilityStatement.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | ValueSet.jurisdiction", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement\r\n* [CodeSystem](codesystem.html): Intended jurisdiction for the code system\r\n* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map\r\n* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition\r\n* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide\r\n* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition\r\n* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system\r\n* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition\r\n* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter\r\n* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition\r\n* [StructureMap](structuremap.html): Intended jurisdiction for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities\r\n* [ValueSet](valueset.html): Intended jurisdiction for the value set\r\n", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | GraphDefinition.name | ImplementationGuide.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | ValueSet.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="CapabilityStatement.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | GraphDefinition.name | ImplementationGuide.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | ValueSet.name", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement\r\n* [CodeSystem](codesystem.html): Computationally friendly name of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition\r\n* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map\r\n* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide\r\n* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition\r\n* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system\r\n* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition\r\n* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition\r\n* [StructureMap](structuremap.html): Computationally friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities\r\n* [ValueSet](valueset.html): Computationally friendly name of the value set\r\n", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | GraphDefinition.name | ImplementationGuide.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | ValueSet.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="CapabilityStatement.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | ValueSet.publisher", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement\r\n* [CodeSystem](codesystem.html): Name of the publisher of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition\r\n* [ConceptMap](conceptmap.html): Name of the publisher of the concept map\r\n* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide\r\n* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition\r\n* [NamingSystem](namingsystem.html): Name of the publisher of the naming system\r\n* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition\r\n* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition\r\n* [StructureMap](structuremap.html): Name of the publisher of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities\r\n* [ValueSet](valueset.html): Name of the publisher of the value set\r\n", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | GraphDefinition.status | ImplementationGuide.status | MessageDefinition.status | NamingSystem.status | OperationDefinition.status | SearchParameter.status | StructureDefinition.status | StructureMap.status | TerminologyCapabilities.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="CapabilityStatement.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | GraphDefinition.status | ImplementationGuide.status | MessageDefinition.status | NamingSystem.status | OperationDefinition.status | SearchParameter.status | StructureDefinition.status | StructureMap.status | TerminologyCapabilities.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | GraphDefinition.status | ImplementationGuide.status | MessageDefinition.status | NamingSystem.status | OperationDefinition.status | SearchParameter.status | StructureDefinition.status | StructureMap.status | TerminologyCapabilities.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.title | CodeSystem.title | ConceptMap.title | ImplementationGuide.title | MessageDefinition.title | OperationDefinition.title | StructureDefinition.title | StructureMap.title | TerminologyCapabilities.title | ValueSet.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="CapabilityStatement.title | CodeSystem.title | ConceptMap.title | ImplementationGuide.title | MessageDefinition.title | OperationDefinition.title | StructureDefinition.title | StructureMap.title | TerminologyCapabilities.title | ValueSet.title", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement\r\n* [CodeSystem](codesystem.html): The human-friendly name of the code system\r\n* [ConceptMap](conceptmap.html): The human-friendly name of the concept map\r\n* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide\r\n* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition\r\n* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition\r\n* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition\r\n* [StructureMap](structuremap.html): The human-friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities\r\n* [ValueSet](valueset.html): The human-friendly name of the value set\r\n", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement.title | CodeSystem.title | ConceptMap.title | ImplementationGuide.title | MessageDefinition.title | OperationDefinition.title | StructureDefinition.title | StructureMap.title | TerminologyCapabilities.title | ValueSet.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>CapabilityStatement.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | GraphDefinition.url | ImplementationGuide.url | MessageDefinition.url | NamingSystem.url | OperationDefinition.url | SearchParameter.url | StructureDefinition.url | StructureMap.url | TerminologyCapabilities.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="CapabilityStatement.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | GraphDefinition.url | ImplementationGuide.url | MessageDefinition.url | NamingSystem.url | OperationDefinition.url | SearchParameter.url | StructureDefinition.url | StructureMap.url | TerminologyCapabilities.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>CapabilityStatement.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | GraphDefinition.url | ImplementationGuide.url | MessageDefinition.url | NamingSystem.url | OperationDefinition.url | SearchParameter.url | StructureDefinition.url | StructureMap.url | TerminologyCapabilities.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | GraphDefinition.version | ImplementationGuide.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | TerminologyCapabilities.version | ValueSet.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="CapabilityStatement.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | GraphDefinition.version | ImplementationGuide.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | TerminologyCapabilities.version | ValueSet.version", description="Multiple Resources: \r\n\r\n* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement\r\n* [CodeSystem](codesystem.html): The business version of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition\r\n* [ConceptMap](conceptmap.html): The business version of the concept map\r\n* [GraphDefinition](graphdefinition.html): The business version of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The business version of the implementation guide\r\n* [MessageDefinition](messagedefinition.html): The business version of the message definition\r\n* [NamingSystem](namingsystem.html): The business version of the naming system\r\n* [OperationDefinition](operationdefinition.html): The business version of the operation definition\r\n* [SearchParameter](searchparameter.html): The business version of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The business version of the structure definition\r\n* [StructureMap](structuremap.html): The business version of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities\r\n* [ValueSet](valueset.html): The business version of the value set\r\n", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | GraphDefinition.version | ImplementationGuide.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | TerminologyCapabilities.version | ValueSet.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}

