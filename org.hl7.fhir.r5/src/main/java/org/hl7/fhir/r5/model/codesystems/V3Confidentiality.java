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

public enum V3Confidentiality {

        /**
         * A specializable code and its leaf codes used in Confidentiality value sets to value the Act.Confidentiality and Role.Confidentiality attribute in accordance with the definition for concept domain "Confidentiality".
         */
        _CONFIDENTIALITY, 
        /**
         * Privacy metadata indicating that a low level of protection is required to safeguard personal and healthcare information, which has been altered in such a way as to minimize the need for confidentiality protections with some residual risks associated with re-linking. The risk of harm to an individual's reputation and sense of privacy if disclosed without authorization is considered negligible, and mitigations are in place to address reidentification risk.

                        
                           Usage Note: 
                        
The level of protection afforded anonymized and pseudonymized, and non-personally identifiable information (e.g., a limited data set) is dictated by privacy policies and data use agreements intended to engender trust that health information can be used and disclosed with little or no risk of re-identification.
                           Example: Personal and healthcare information, which excludes 16 designated categories of direct identifiers in a HIPAA Limited Data Set. This information may be disclosed by HIPAA Covered Entities without patient authorization for a research, public health, and operations purposes if conditions are met, which includes obtaining a signed data use agreement from the recipient. See 45 CFR Section 164.514.

                        This metadata indicates that the receiver may have an obligation to comply with a data use agreement with the discloser. The discloser may have obligations to comply with policies dictating the methods for de-identification.

                        Confidentiality code total order hierarchy: Low (L) is less protective than V, R, N, and M, and subsumes U.
         */
        L, 
        /**
         * Privacy metadata indicating the level of protection required to safeguard personal and healthcare information, which if disclosed without authorization, would present a moderate risk of harm to an individual's reputation and sense of privacy.

                        
                           Usage Note: The level of protection afforded moderately confidential information is dictated by privacy policies intended to engender trust in a service provider. May include publicly available information in jurisdictions that restrict uses of that information without the consent of the data subject.

                        Privacy policies mandating moderate levels of protection, which preempt less protective privacy policies. "Moderate" confidentiality policies differ from and would be preempted by the prevailing privacy policies mandating the normative level of protection for information used in the delivery and management of healthcare.

                        Confidentiality code total order hierarchy: Moderate (M) is less protective than V, R, and N, and subsumes all other protection levels (i.e., L and U).

                        
                           Examples: Includes personal and health information that an individual authorizes to be collected, accessed, used or disclosed to a bank for a health credit card or savings account; to health oversight authorities; to a hospital patient directory; to worker compensation, disability, property and casualty or life insurers; and to personal health record systems, consumer-controlled devices, social media accounts and online Apps; or for marketing purposes
         */
        M, 
        /**
         * Privacy metadata indicating the level of protection required to safeguard personal and healthcare information, which if disclosed without authorization, would present a considerable risk of harm to an individual's reputation and sense of privacy.

                        
                           Usage Note: The level of protection afforded normatively confidential information is dictated by the prevailing normative privacy policies, which are intended to engender patient trust in their healthcare providers.

                        Privacy policies mandating normative levels of protection, which preempt less protective privacy policies when the information is used in the delivery and management of healthcare. May be pre-empted by jurisdictional law (e.g., for public health reporting or emergency treatment).

                        Confidentiality code total order hierarchy: Normal (N) is less protective than V and R, and subsumes all other protection levels (i.e., M, L, and U).

                        
                           Map:Partial Map to ISO 13606-4 Sensitivity Level (3) Clinical Care when purpose of use is treatment: Default for normal clinical care access (i.e., most clinical staff directly caring for the patient should be able to access nearly all of the EHR). Maps to normal confidentiality for treatment information but not to ancillary care, payment and operations. 

                        
                           Examples: 
                        
n the US, this includes what HIPAA identifies as protected health information (PHI) under 45 CFR Section 160.103.
         */
        N, 
        /**
         * Privacy metadata indicating the level of protection required to safeguard potentially stigmatizing information, which if disclosed without authorization, would present a high risk of harm to an individual's reputation and sense of privacy.

                        
                           Usage Note: The level of protection afforded restricted confidential information is dictated by specially protective organizational or jurisdictional privacy policies, including at an authorized individualâ€™s request, intended to engender patient trust in providers of sensitive services.

                        Privacy policies mandating additional levels of protection by restricting information access preempt less protective privacy policies when the information is used in the delivery and management of healthcare. May be pre-empted by jurisdictional law (e.g., for public health reporting or emergency treatment).

                        Confidentiality code total order hierarchy: Restricted (R) is less protective than V, and subsumes all other protection levels (i.e., N, M, L, and U).

                        
                           Examples: 
                        
Includes information that is additionally protected such as sensitive conditions mental health, HIV, substance abuse, domestic violence, child abuse, genetic disease, and reproductive health; or sensitive demographic information such as a patientâ€™s standing as an employee or a celebrity. May be used to indicate proprietary or classified information that is not related to an individual (e.g., secret ingredients in a therapeutic substance; or the name of a manufacturer).
         */
        R, 
        /**
         * Privacy metadata indicating that no level of protection is required to safeguard personal and healthcare information that has been disclosed by an authorized individual without restrictions on its use.

                        
                           Examples: Includes publicly available information e.g., business name, phone, email and physical address.

                        
                           Usage Note: The authorization to collect, access, use, and disclose this information may be stipulated in a contract of adhesion by a data user (e.g., via terms of service or data user privacy policies) in exchange for the data subject's use of a service.

                        This metadata indicates that the receiver has no obligation to consider privacy policies other than its own when making access control decisions.

                        This metadata indicates that the receiver has no obligation to consider privacy policies other than its own when making access control decisions.

                        Confidentiality code total order hierarchy: Unrestricted (U) is less protective than V, R, N, M, and L, and is the lowest protection levels.
         */
        U, 
        /**
         * Privacy metadata indicating the level of protection required under atypical cicumstances to safeguard potentially damaging or harmful information, which if disclosed without authorization, would (1) present an extremely high risk of harm to an individual's reputation, sense of privacy, and possibly safety; or (2) impact an individual's or organization's legal matters.

                        
                           Usage Note: The level of protection afforded very restricted confidential information is dictated by specially protective privacy or legal policies intended to ensure that under atypical circumstances additional protections limit access to only those with a high 'need to know' and the information is kept in highest confidence..

                        Privacy and legal policies mandating the highest level of protection by stringently restricting information access, preempt less protective privacy policies when the information is used in the delivery and management of healthcare including legal proceedings related to healthcare. May be pre-empted by jurisdictional law (e.g., for public health reporting or emergency treatment but only under limited circumstances).

                        Confidentiality code total order hierarchy: Very Restricted (V) is the highest protection level and subsumes all other protection levels s (i.e., R, N, M, L, and UI).

                        
                           Examples: 
                        
Includes information about a victim of abuse, patient requested information sensitivity, and taboo subjects relating to health status that must be discussed with the patient by an attending provider before sharing with the patient. May also include information held under a legal hold or attorney-client privilege.
         */
        V, 
        /**
         * Description: By accessing subject / role and relationship based  rights  (These concepts are mutually exclusive, one and only one is required for a valid confidentiality coding.)

                        
                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode
         */
        _CONFIDENTIALITYBYACCESSKIND, 
        /**
         * Description: Since the service class can represent knowledge structures that may be considered a trade or business secret, there is sometimes (though rarely) the need to flag those items as of business level confidentiality.  However, no patient related information may ever be of this confidentiality level.

                        
                           Deprecation Comment: Replced by ActCode.B
         */
        B, 
        /**
         * Description: Only clinicians may see this item, billing and administration persons can not access this item without special permission.

                        
                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode
         */
        D, 
        /**
         * Description: Access only to individual persons who are mentioned explicitly as actors of this service and whose actor type warrants that access (cf. to actor type code).

                        
                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode
         */
        I, 
        /**
         * Description: By information type, only for service catalog entries (multiples allowed). Not to be used with actual patient data!

                        
                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode
         */
        _CONFIDENTIALITYBYINFOTYPE, 
        /**
         * Description: Alcohol/drug-abuse related item

                        
                           Deprecation Comment:Replced by ActCode.ETH
         */
        ETH, 
        /**
         * Description: HIV and AIDS related item

                        
                           Deprecation Comment:Replced by ActCode.HIV
         */
        HIV, 
        /**
         * Description: Psychiatry related item

                        
                           Deprecation Comment:Replced by ActCode.PSY
         */
        PSY, 
        /**
         * Description: Sexual assault / domestic violence related item

                        
                           Deprecation Comment:Replced by ActCode.SDV
         */
        SDV, 
        /**
         * Description: Modifiers of role based access rights  (multiple allowed)

                        
                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode
         */
        _CONFIDENTIALITYMODIFIERS, 
        /**
         * Description: Celebrities are people of public interest (VIP) including employees, whose information require special protection.

                        
                           Deprecation Comment:Replced by ActCode.CEL
         */
        C, 
        /**
         * Description: 
                        
Information for which the patient seeks heightened confidentiality. Sensitive information is not to be shared with family members.  Information reported by the patient about family members is sensitive by default. Flag can be set or cleared on patient's request.
                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode
         */
        S, 
        /**
         * Description: Information not to be disclosed or discussed with patient except through physician assigned to patient in this case.  This is usually a temporary constraint only, example use is a new fatal diagnosis or finding, such as malignancy or HIV.

                        
                           Deprecation Note:Replced by ActCode.TBOO
         */
        T, 
        /**
         * added to help the parsers
         */
        NULL;
        public static V3Confidentiality fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("_Confidentiality".equals(codeString))
          return _CONFIDENTIALITY;
        if ("L".equals(codeString))
          return L;
        if ("M".equals(codeString))
          return M;
        if ("N".equals(codeString))
          return N;
        if ("R".equals(codeString))
          return R;
        if ("U".equals(codeString))
          return U;
        if ("V".equals(codeString))
          return V;
        if ("_ConfidentialityByAccessKind".equals(codeString))
          return _CONFIDENTIALITYBYACCESSKIND;
        if ("B".equals(codeString))
          return B;
        if ("D".equals(codeString))
          return D;
        if ("I".equals(codeString))
          return I;
        if ("_ConfidentialityByInfoType".equals(codeString))
          return _CONFIDENTIALITYBYINFOTYPE;
        if ("ETH".equals(codeString))
          return ETH;
        if ("HIV".equals(codeString))
          return HIV;
        if ("PSY".equals(codeString))
          return PSY;
        if ("SDV".equals(codeString))
          return SDV;
        if ("_ConfidentialityModifiers".equals(codeString))
          return _CONFIDENTIALITYMODIFIERS;
        if ("C".equals(codeString))
          return C;
        if ("S".equals(codeString))
          return S;
        if ("T".equals(codeString))
          return T;
        throw new FHIRException("Unknown V3Confidentiality code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _CONFIDENTIALITY: return "_Confidentiality";
            case L: return "L";
            case M: return "M";
            case N: return "N";
            case R: return "R";
            case U: return "U";
            case V: return "V";
            case _CONFIDENTIALITYBYACCESSKIND: return "_ConfidentialityByAccessKind";
            case B: return "B";
            case D: return "D";
            case I: return "I";
            case _CONFIDENTIALITYBYINFOTYPE: return "_ConfidentialityByInfoType";
            case ETH: return "ETH";
            case HIV: return "HIV";
            case PSY: return "PSY";
            case SDV: return "SDV";
            case _CONFIDENTIALITYMODIFIERS: return "_ConfidentialityModifiers";
            case C: return "C";
            case S: return "S";
            case T: return "T";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://terminology.hl7.org/CodeSystem/v3-Confidentiality";
        }
        public String getDefinition() {
          switch (this) {
            case _CONFIDENTIALITY: return "A specializable code and its leaf codes used in Confidentiality value sets to value the Act.Confidentiality and Role.Confidentiality attribute in accordance with the definition for concept domain \"Confidentiality\".";
            case L: return "Privacy metadata indicating that a low level of protection is required to safeguard personal and healthcare information, which has been altered in such a way as to minimize the need for confidentiality protections with some residual risks associated with re-linking. The risk of harm to an individual's reputation and sense of privacy if disclosed without authorization is considered negligible, and mitigations are in place to address reidentification risk.\r\n\n                        \n                           Usage Note: \n                        \r\nThe level of protection afforded anonymized and pseudonymized, and non-personally identifiable information (e.g., a limited data set) is dictated by privacy policies and data use agreements intended to engender trust that health information can be used and disclosed with little or no risk of re-identification.\n                           Example: Personal and healthcare information, which excludes 16 designated categories of direct identifiers in a HIPAA Limited Data Set. This information may be disclosed by HIPAA Covered Entities without patient authorization for a research, public health, and operations purposes if conditions are met, which includes obtaining a signed data use agreement from the recipient. See 45 CFR Section 164.514.\r\n\n                        This metadata indicates that the receiver may have an obligation to comply with a data use agreement with the discloser. The discloser may have obligations to comply with policies dictating the methods for de-identification.\r\n\n                        Confidentiality code total order hierarchy: Low (L) is less protective than V, R, N, and M, and subsumes U.";
            case M: return "Privacy metadata indicating the level of protection required to safeguard personal and healthcare information, which if disclosed without authorization, would present a moderate risk of harm to an individual's reputation and sense of privacy.\r\n\n                        \n                           Usage Note: The level of protection afforded moderately confidential information is dictated by privacy policies intended to engender trust in a service provider. May include publicly available information in jurisdictions that restrict uses of that information without the consent of the data subject.\r\n\n                        Privacy policies mandating moderate levels of protection, which preempt less protective privacy policies. \"Moderate\" confidentiality policies differ from and would be preempted by the prevailing privacy policies mandating the normative level of protection for information used in the delivery and management of healthcare.\r\n\n                        Confidentiality code total order hierarchy: Moderate (M) is less protective than V, R, and N, and subsumes all other protection levels (i.e., L and U).\r\n\n                        \n                           Examples: Includes personal and health information that an individual authorizes to be collected, accessed, used or disclosed to a bank for a health credit card or savings account; to health oversight authorities; to a hospital patient directory; to worker compensation, disability, property and casualty or life insurers; and to personal health record systems, consumer-controlled devices, social media accounts and online Apps; or for marketing purposes";
            case N: return "Privacy metadata indicating the level of protection required to safeguard personal and healthcare information, which if disclosed without authorization, would present a considerable risk of harm to an individual's reputation and sense of privacy.\r\n\n                        \n                           Usage Note: The level of protection afforded normatively confidential information is dictated by the prevailing normative privacy policies, which are intended to engender patient trust in their healthcare providers.\r\n\n                        Privacy policies mandating normative levels of protection, which preempt less protective privacy policies when the information is used in the delivery and management of healthcare. May be pre-empted by jurisdictional law (e.g., for public health reporting or emergency treatment).\r\n\n                        Confidentiality code total order hierarchy: Normal (N) is less protective than V and R, and subsumes all other protection levels (i.e., M, L, and U).\r\n\n                        \n                           Map:Partial Map to ISO 13606-4 Sensitivity Level (3) Clinical Care when purpose of use is treatment: Default for normal clinical care access (i.e., most clinical staff directly caring for the patient should be able to access nearly all of the EHR). Maps to normal confidentiality for treatment information but not to ancillary care, payment and operations. \r\n\n                        \n                           Examples: \n                        \r\nn the US, this includes what HIPAA identifies as protected health information (PHI) under 45 CFR Section 160.103.";
            case R: return "Privacy metadata indicating the level of protection required to safeguard potentially stigmatizing information, which if disclosed without authorization, would present a high risk of harm to an individual's reputation and sense of privacy.\r\n\n                        \n                           Usage Note: The level of protection afforded restricted confidential information is dictated by specially protective organizational or jurisdictional privacy policies, including at an authorized individualâ€™s request, intended to engender patient trust in providers of sensitive services.\r\n\n                        Privacy policies mandating additional levels of protection by restricting information access preempt less protective privacy policies when the information is used in the delivery and management of healthcare. May be pre-empted by jurisdictional law (e.g., for public health reporting or emergency treatment).\r\n\n                        Confidentiality code total order hierarchy: Restricted (R) is less protective than V, and subsumes all other protection levels (i.e., N, M, L, and U).\r\n\n                        \n                           Examples: \n                        \r\nIncludes information that is additionally protected such as sensitive conditions mental health, HIV, substance abuse, domestic violence, child abuse, genetic disease, and reproductive health; or sensitive demographic information such as a patientâ€™s standing as an employee or a celebrity. May be used to indicate proprietary or classified information that is not related to an individual (e.g., secret ingredients in a therapeutic substance; or the name of a manufacturer).";
            case U: return "Privacy metadata indicating that no level of protection is required to safeguard personal and healthcare information that has been disclosed by an authorized individual without restrictions on its use.\r\n\n                        \n                           Examples: Includes publicly available information e.g., business name, phone, email and physical address.\r\n\n                        \n                           Usage Note: The authorization to collect, access, use, and disclose this information may be stipulated in a contract of adhesion by a data user (e.g., via terms of service or data user privacy policies) in exchange for the data subject's use of a service.\r\n\n                        This metadata indicates that the receiver has no obligation to consider privacy policies other than its own when making access control decisions.\r\n\n                        This metadata indicates that the receiver has no obligation to consider privacy policies other than its own when making access control decisions.\r\n\n                        Confidentiality code total order hierarchy: Unrestricted (U) is less protective than V, R, N, M, and L, and is the lowest protection levels.";
            case V: return "Privacy metadata indicating the level of protection required under atypical cicumstances to safeguard potentially damaging or harmful information, which if disclosed without authorization, would (1) present an extremely high risk of harm to an individual's reputation, sense of privacy, and possibly safety; or (2) impact an individual's or organization's legal matters.\r\n\n                        \n                           Usage Note: The level of protection afforded very restricted confidential information is dictated by specially protective privacy or legal policies intended to ensure that under atypical circumstances additional protections limit access to only those with a high 'need to know' and the information is kept in highest confidence..\r\n\n                        Privacy and legal policies mandating the highest level of protection by stringently restricting information access, preempt less protective privacy policies when the information is used in the delivery and management of healthcare including legal proceedings related to healthcare. May be pre-empted by jurisdictional law (e.g., for public health reporting or emergency treatment but only under limited circumstances).\r\n\n                        Confidentiality code total order hierarchy: Very Restricted (V) is the highest protection level and subsumes all other protection levels s (i.e., R, N, M, L, and UI).\r\n\n                        \n                           Examples: \n                        \r\nIncludes information about a victim of abuse, patient requested information sensitivity, and taboo subjects relating to health status that must be discussed with the patient by an attending provider before sharing with the patient. May also include information held under a legal hold or attorney-client privilege.";
            case _CONFIDENTIALITYBYACCESSKIND: return "Description: By accessing subject / role and relationship based  rights  (These concepts are mutually exclusive, one and only one is required for a valid confidentiality coding.)\r\n\n                        \n                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode";
            case B: return "Description: Since the service class can represent knowledge structures that may be considered a trade or business secret, there is sometimes (though rarely) the need to flag those items as of business level confidentiality.  However, no patient related information may ever be of this confidentiality level.\r\n\n                        \n                           Deprecation Comment: Replced by ActCode.B";
            case D: return "Description: Only clinicians may see this item, billing and administration persons can not access this item without special permission.\r\n\n                        \n                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode";
            case I: return "Description: Access only to individual persons who are mentioned explicitly as actors of this service and whose actor type warrants that access (cf. to actor type code).\r\n\n                        \n                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode";
            case _CONFIDENTIALITYBYINFOTYPE: return "Description: By information type, only for service catalog entries (multiples allowed). Not to be used with actual patient data!\r\n\n                        \n                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode";
            case ETH: return "Description: Alcohol/drug-abuse related item\r\n\n                        \n                           Deprecation Comment:Replced by ActCode.ETH";
            case HIV: return "Description: HIV and AIDS related item\r\n\n                        \n                           Deprecation Comment:Replced by ActCode.HIV";
            case PSY: return "Description: Psychiatry related item\r\n\n                        \n                           Deprecation Comment:Replced by ActCode.PSY";
            case SDV: return "Description: Sexual assault / domestic violence related item\r\n\n                        \n                           Deprecation Comment:Replced by ActCode.SDV";
            case _CONFIDENTIALITYMODIFIERS: return "Description: Modifiers of role based access rights  (multiple allowed)\r\n\n                        \n                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode";
            case C: return "Description: Celebrities are people of public interest (VIP) including employees, whose information require special protection.\r\n\n                        \n                           Deprecation Comment:Replced by ActCode.CEL";
            case S: return "Description: \n                        \r\nInformation for which the patient seeks heightened confidentiality. Sensitive information is not to be shared with family members.  Information reported by the patient about family members is sensitive by default. Flag can be set or cleared on patient's request.\n                           Deprecation Comment:Deprecated due to updated confidentiality codes under ActCode";
            case T: return "Description: Information not to be disclosed or discussed with patient except through physician assigned to patient in this case.  This is usually a temporary constraint only, example use is a new fatal diagnosis or finding, such as malignancy or HIV.\r\n\n                        \n                           Deprecation Note:Replced by ActCode.TBOO";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _CONFIDENTIALITY: return "Confidentiality";
            case L: return "low";
            case M: return "moderate";
            case N: return "normal";
            case R: return "restricted";
            case U: return "unrestricted";
            case V: return "very restricted";
            case _CONFIDENTIALITYBYACCESSKIND: return "ConfidentialityByAccessKind";
            case B: return "business";
            case D: return "clinician";
            case I: return "individual";
            case _CONFIDENTIALITYBYINFOTYPE: return "ConfidentialityByInfoType";
            case ETH: return "substance abuse related";
            case HIV: return "HIV related";
            case PSY: return "psychiatry relate";
            case SDV: return "sexual and domestic violence related";
            case _CONFIDENTIALITYMODIFIERS: return "ConfidentialityModifiers";
            case C: return "celebrity";
            case S: return "sensitive";
            case T: return "taboo";
            default: return "?";
          }
    }


}

