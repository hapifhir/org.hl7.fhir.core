package org.hl7.fhir.dstu2016may.model.codesystems;




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

// Generated on Sun, May 8, 2016 03:05+1000 for FHIR v1.4.0


import org.hl7.fhir.exceptions.FHIRException;

public enum OrderStatus {

        /**
         * The order is known, but no processing has occurred at this time
         */
        PENDING, 
        /**
         * The order is undergoing initial processing to determine whether it will be accepted (usually this involves human review)
         */
        REVIEW, 
        /**
         * The order was rejected because of a workflow/business logic reason
         */
        REJECTED, 
        /**
         * The order was unable to be processed because of a technical error (i.e. unexpected error)
         */
        ERROR, 
        /**
         * The order has been accepted, and work is in progress.
         */
        ACCEPTED, 
        /**
         * Processing the order was halted at the initiators request.
         */
        CANCELLED, 
        /**
         * The order has been cancelled and replaced by another.
         */
        REPLACED, 
        /**
         * Processing the order was stopped because of some workflow/business logic reason.
         */
        ABORTED, 
        /**
         * The order has been completed.
         */
        COMPLETED, 
        /**
         * added to help the parsers
         */
        NULL;
        public static OrderStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("pending".equals(codeString))
          return PENDING;
        if ("review".equals(codeString))
          return REVIEW;
        if ("rejected".equals(codeString))
          return REJECTED;
        if ("error".equals(codeString))
          return ERROR;
        if ("accepted".equals(codeString))
          return ACCEPTED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("replaced".equals(codeString))
          return REPLACED;
        if ("aborted".equals(codeString))
          return ABORTED;
        if ("completed".equals(codeString))
          return COMPLETED;
        throw new FHIRException("Unknown OrderStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PENDING: return "pending";
            case REVIEW: return "review";
            case REJECTED: return "rejected";
            case ERROR: return "error";
            case ACCEPTED: return "accepted";
            case CANCELLED: return "cancelled";
            case REPLACED: return "replaced";
            case ABORTED: return "aborted";
            case COMPLETED: return "completed";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/order-status";
        }
        public String getDefinition() {
          switch (this) {
            case PENDING: return "The order is known, but no processing has occurred at this time";
            case REVIEW: return "The order is undergoing initial processing to determine whether it will be accepted (usually this involves human review)";
            case REJECTED: return "The order was rejected because of a workflow/business logic reason";
            case ERROR: return "The order was unable to be processed because of a technical error (i.e. unexpected error)";
            case ACCEPTED: return "The order has been accepted, and work is in progress.";
            case CANCELLED: return "Processing the order was halted at the initiators request.";
            case REPLACED: return "The order has been cancelled and replaced by another.";
            case ABORTED: return "Processing the order was stopped because of some workflow/business logic reason.";
            case COMPLETED: return "The order has been completed.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PENDING: return "Pending";
            case REVIEW: return "Review";
            case REJECTED: return "Rejected";
            case ERROR: return "Error";
            case ACCEPTED: return "Accepted";
            case CANCELLED: return "Cancelled";
            case REPLACED: return "Replaced";
            case ABORTED: return "Aborted";
            case COMPLETED: return "Completed";
            case NULL: return null;
            default: return "?";
          }
    }


}