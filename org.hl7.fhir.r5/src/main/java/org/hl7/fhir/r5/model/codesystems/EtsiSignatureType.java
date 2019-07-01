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


import org.hl7.fhir.exceptions.FHIRException;

public enum EtsiSignatureType {

        /**
         * indicates that the signer recognizes to have created, approved and sent the signed data object.
         */
        PROOFOFORIGIN, 
        /**
         * indicates that signer recognizes to have received the content of the signed data object.
         */
        PROOFOFRECEIPT, 
        /**
         * indicates that the TSP providing that indication has delivered a signed data object in a local store accessible to the recipient of the signed data object.
         */
        PROOFOFDELIVERY, 
        /**
         * indicates that the entity providing that indication has sent the signed data object (but not necessarily created it).
         */
        PROOFOFSENDER, 
        /**
         * indicates that the signer has approved the content of the signed data object.
         */
        PROOFOFAPPROVAL, 
        /**
         * indicates that the signer has created the signed data object (but not necessarily approved, nor sent it).
         */
        PROOFOFCREATION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static EtsiSignatureType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ProofOfOrigin".equals(codeString))
          return PROOFOFORIGIN;
        if ("ProofOfReceipt".equals(codeString))
          return PROOFOFRECEIPT;
        if ("ProofOfDelivery".equals(codeString))
          return PROOFOFDELIVERY;
        if ("ProofOfSender".equals(codeString))
          return PROOFOFSENDER;
        if ("ProofOfapproval".equals(codeString))
          return PROOFOFAPPROVAL;
        if ("ProofOfCreation".equals(codeString))
          return PROOFOFCREATION;
        throw new FHIRException("Unknown EtsiSignatureType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PROOFOFORIGIN: return "ProofOfOrigin";
            case PROOFOFRECEIPT: return "ProofOfReceipt";
            case PROOFOFDELIVERY: return "ProofOfDelivery";
            case PROOFOFSENDER: return "ProofOfSender";
            case PROOFOFAPPROVAL: return "ProofOfapproval";
            case PROOFOFCREATION: return "ProofOfCreation";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://uri.etsi.org/01903/v1.2.2";
        }
        public String getDefinition() {
          switch (this) {
            case PROOFOFORIGIN: return "indicates that the signer recognizes to have created, approved and sent the signed data object.";
            case PROOFOFRECEIPT: return "indicates that signer recognizes to have received the content of the signed data object.";
            case PROOFOFDELIVERY: return "indicates that the TSP providing that indication has delivered a signed data object in a local store accessible to the recipient of the signed data object.";
            case PROOFOFSENDER: return "indicates that the entity providing that indication has sent the signed data object (but not necessarily created it).";
            case PROOFOFAPPROVAL: return "indicates that the signer has approved the content of the signed data object.";
            case PROOFOFCREATION: return "indicates that the signer has created the signed data object (but not necessarily approved, nor sent it).";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PROOFOFORIGIN: return "Proof of origin";
            case PROOFOFRECEIPT: return "Proof of receipt";
            case PROOFOFDELIVERY: return "Proof of delivery";
            case PROOFOFSENDER: return "Proof of sender";
            case PROOFOFAPPROVAL: return "Proof of approval";
            case PROOFOFCREATION: return "Proof of creation";
            default: return "?";
          }
    }


}

