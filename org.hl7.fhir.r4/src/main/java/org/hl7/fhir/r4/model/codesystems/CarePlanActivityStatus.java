package org.hl7.fhir.r4.model.codesystems;

/*-
 * #%L
 * org.hl7.fhir.r4
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

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0


import org.hl7.fhir.exceptions.FHIRException;

public enum CarePlanActivityStatus {

        /**
         * Care plan activity is planned but no action has yet been taken.
         */
        NOTSTARTED, 
        /**
         * Appointment or other booking has occurred but activity has not yet begun.
         */
        SCHEDULED, 
        /**
         * Care plan activity has been started but is not yet complete.
         */
        INPROGRESS, 
        /**
         * Care plan activity was started but has temporarily ceased with an expectation of resumption at a future time.
         */
        ONHOLD, 
        /**
         * Care plan activity has been completed (more or less) as planned.
         */
        COMPLETED, 
        /**
         * The planned care plan activity has been withdrawn.
         */
        CANCELLED, 
        /**
         * The planned care plan activity has been ended prior to completion after the activity was started.
         */
        STOPPED, 
        /**
         * The current state of the care plan activity is not known.  Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which one.
         */
        UNKNOWN, 
        /**
         * Care plan activity was entered in error and voided.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CarePlanActivityStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-started".equals(codeString))
          return NOTSTARTED;
        if ("scheduled".equals(codeString))
          return SCHEDULED;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        throw new FHIRException("Unknown CarePlanActivityStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NOTSTARTED: return "not-started";
            case SCHEDULED: return "scheduled";
            case INPROGRESS: return "in-progress";
            case ONHOLD: return "on-hold";
            case COMPLETED: return "completed";
            case CANCELLED: return "cancelled";
            case STOPPED: return "stopped";
            case UNKNOWN: return "unknown";
            case ENTEREDINERROR: return "entered-in-error";
            default: return "?";
          }
        }
        public String getSystem() {
          return "http://hl7.org/fhir/care-plan-activity-status";
        }
        public String getDefinition() {
          switch (this) {
            case NOTSTARTED: return "Care plan activity is planned but no action has yet been taken.";
            case SCHEDULED: return "Appointment or other booking has occurred but activity has not yet begun.";
            case INPROGRESS: return "Care plan activity has been started but is not yet complete.";
            case ONHOLD: return "Care plan activity was started but has temporarily ceased with an expectation of resumption at a future time.";
            case COMPLETED: return "Care plan activity has been completed (more or less) as planned.";
            case CANCELLED: return "The planned care plan activity has been withdrawn.";
            case STOPPED: return "The planned care plan activity has been ended prior to completion after the activity was started.";
            case UNKNOWN: return "The current state of the care plan activity is not known.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which one.";
            case ENTEREDINERROR: return "Care plan activity was entered in error and voided.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NOTSTARTED: return "Not Started";
            case SCHEDULED: return "Scheduled";
            case INPROGRESS: return "In Progress";
            case ONHOLD: return "On Hold";
            case COMPLETED: return "Completed";
            case CANCELLED: return "Cancelled";
            case STOPPED: return "Stopped";
            case UNKNOWN: return "Unknown";
            case ENTEREDINERROR: return "Entered in Error";
            default: return "?";
          }
    }


}

