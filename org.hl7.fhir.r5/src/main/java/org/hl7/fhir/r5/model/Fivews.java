package org.hl7.fhir.r5.model;

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

// Generated on Tue, May 7, 2019 08:21+1000 for FHIR v4.1.0

import java.util.*;

import org.hl7.fhir.utilities.Utilities;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;
import org.hl7.fhir.instance.model.api.*;
import org.hl7.fhir.exceptions.FHIRException;
/**
 * Who What When Where Why - Common pattern for all resources that deals with attribution.
 */
public interface Fivews extends PatternBase {

    public enum CanonicalStatus {
        /**
         * The resource was created in error, and should not be treated as valid (note: in many cases, for various data integrity related reasons, the information cannot be removed from the record)
         */
        ERROR, 
        /**
         * The resource describes an action or plan that is proposed, and not yet approved by the participants
         */
        PROPOSED, 
        /**
         * The resource describes a course of action that is planned and agreed/approved, but at the time of recording was still future
         */
        PLANNED, 
        /**
         * The information in the resource is still being prepared and edited
         */
        DRAFT, 
        /**
         * A fulfiller has been asked to perform this action, but it has not yet occurred
         */
        REQUESTED, 
        /**
         * The fulfiller has received the request, but not yet agreed to carry out the action
         */
        RECEIVED, 
        /**
         * The fulfiller chose not to perform the action
         */
        DECLINED, 
        /**
         * The fulfiller has decided to perform the action, and plans are in train to do this in the future
         */
        ACCEPTED, 
        /**
         * The pre-conditions for the action are all fulfilled, and it is imminent
         */
        ARRIVED, 
        /**
         * The resource describes information that is currently valid or a process that is presently occuring
         */
        ACTIVE, 
        /**
         * The process described/requested in this resource has been halted for some reason
         */
        SUSPENDED, 
        /**
         * The process described/requested in the resource could not be completed, and no further action is planned
         */
        FAILED, 
        /**
         * The information in this resource has been replaced by information in another resource
         */
        REPLACED, 
        /**
         * The process described/requested in the resource has been completed, and no further action is planned
         */
        COMPLETE, 
        /**
         * The resource describes information that is no longer valid or a process that is stopped occurring
         */
        INACTIVE, 
        /**
         * The process described/requested in the resource did not complete - usually due to some workflow error, and no further action is planned
         */
        ABANDONED, 
        /**
         * Authoring system does not know the status
         */
        UNKNOWN, 
        /**
         * The information in this resource is not yet approved
         */
        UNCONFIRMED, 
        /**
         * The information in this resource is approved
         */
        CONFIRMED, 
        /**
         * The issue identified by this resource is no longer of concern
         */
        RESOLVED, 
        /**
         * This information has been ruled out by testing and evaluation
         */
        REFUTED, 
        /**
         * Potentially true?
         */
        DIFFERENTIAL, 
        /**
         * This information is still being assembled
         */
        PARTIAL, 
        /**
         * not available at this time/location
         */
        BUSYUNAVAILABLE, 
        /**
         * Free for scheduling
         */
        FREE, 
        /**
         * Ready to act
         */
        ONTARGET, 
        /**
         * Ahead of the planned timelines
         */
        AHEADOFTARGET, 
        /**
         * 
         */
        BEHINDTARGET, 
        /**
         * Behind the planned timelines
         */
        NOTREADY, 
        /**
         * The device transducer is disconnected
         */
        TRANSDUCDISCON, 
        /**
         * The hardware is disconnected
         */
        HWDISCON, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CanonicalStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("error".equals(codeString))
          return ERROR;
        if ("proposed".equals(codeString))
          return PROPOSED;
        if ("planned".equals(codeString))
          return PLANNED;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("requested".equals(codeString))
          return REQUESTED;
        if ("received".equals(codeString))
          return RECEIVED;
        if ("declined".equals(codeString))
          return DECLINED;
        if ("accepted".equals(codeString))
          return ACCEPTED;
        if ("arrived".equals(codeString))
          return ARRIVED;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("suspended".equals(codeString))
          return SUSPENDED;
        if ("failed".equals(codeString))
          return FAILED;
        if ("replaced".equals(codeString))
          return REPLACED;
        if ("complete".equals(codeString))
          return COMPLETE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("abandoned".equals(codeString))
          return ABANDONED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if ("unconfirmed".equals(codeString))
          return UNCONFIRMED;
        if ("confirmed".equals(codeString))
          return CONFIRMED;
        if ("resolved".equals(codeString))
          return RESOLVED;
        if ("refuted".equals(codeString))
          return REFUTED;
        if ("differential".equals(codeString))
          return DIFFERENTIAL;
        if ("partial".equals(codeString))
          return PARTIAL;
        if ("busy-unavailable".equals(codeString))
          return BUSYUNAVAILABLE;
        if ("free".equals(codeString))
          return FREE;
        if ("on-target".equals(codeString))
          return ONTARGET;
        if ("ahead-of-target".equals(codeString))
          return AHEADOFTARGET;
        if ("behind-target".equals(codeString))
          return BEHINDTARGET;
        if ("not-ready".equals(codeString))
          return NOTREADY;
        if ("transduc-discon".equals(codeString))
          return TRANSDUCDISCON;
        if ("hw-discon".equals(codeString))
          return HWDISCON;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CanonicalStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ERROR: return "error";
            case PROPOSED: return "proposed";
            case PLANNED: return "planned";
            case DRAFT: return "draft";
            case REQUESTED: return "requested";
            case RECEIVED: return "received";
            case DECLINED: return "declined";
            case ACCEPTED: return "accepted";
            case ARRIVED: return "arrived";
            case ACTIVE: return "active";
            case SUSPENDED: return "suspended";
            case FAILED: return "failed";
            case REPLACED: return "replaced";
            case COMPLETE: return "complete";
            case INACTIVE: return "inactive";
            case ABANDONED: return "abandoned";
            case UNKNOWN: return "unknown";
            case UNCONFIRMED: return "unconfirmed";
            case CONFIRMED: return "confirmed";
            case RESOLVED: return "resolved";
            case REFUTED: return "refuted";
            case DIFFERENTIAL: return "differential";
            case PARTIAL: return "partial";
            case BUSYUNAVAILABLE: return "busy-unavailable";
            case FREE: return "free";
            case ONTARGET: return "on-target";
            case AHEADOFTARGET: return "ahead-of-target";
            case BEHINDTARGET: return "behind-target";
            case NOTREADY: return "not-ready";
            case TRANSDUCDISCON: return "transduc-discon";
            case HWDISCON: return "hw-discon";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ERROR: return "http://hl7.org/fhir/resource-status";
            case PROPOSED: return "http://hl7.org/fhir/resource-status";
            case PLANNED: return "http://hl7.org/fhir/resource-status";
            case DRAFT: return "http://hl7.org/fhir/resource-status";
            case REQUESTED: return "http://hl7.org/fhir/resource-status";
            case RECEIVED: return "http://hl7.org/fhir/resource-status";
            case DECLINED: return "http://hl7.org/fhir/resource-status";
            case ACCEPTED: return "http://hl7.org/fhir/resource-status";
            case ARRIVED: return "http://hl7.org/fhir/resource-status";
            case ACTIVE: return "http://hl7.org/fhir/resource-status";
            case SUSPENDED: return "http://hl7.org/fhir/resource-status";
            case FAILED: return "http://hl7.org/fhir/resource-status";
            case REPLACED: return "http://hl7.org/fhir/resource-status";
            case COMPLETE: return "http://hl7.org/fhir/resource-status";
            case INACTIVE: return "http://hl7.org/fhir/resource-status";
            case ABANDONED: return "http://hl7.org/fhir/resource-status";
            case UNKNOWN: return "http://hl7.org/fhir/resource-status";
            case UNCONFIRMED: return "http://hl7.org/fhir/resource-status";
            case CONFIRMED: return "http://hl7.org/fhir/resource-status";
            case RESOLVED: return "http://hl7.org/fhir/resource-status";
            case REFUTED: return "http://hl7.org/fhir/resource-status";
            case DIFFERENTIAL: return "http://hl7.org/fhir/resource-status";
            case PARTIAL: return "http://hl7.org/fhir/resource-status";
            case BUSYUNAVAILABLE: return "http://hl7.org/fhir/resource-status";
            case FREE: return "http://hl7.org/fhir/resource-status";
            case ONTARGET: return "http://hl7.org/fhir/resource-status";
            case AHEADOFTARGET: return "http://hl7.org/fhir/resource-status";
            case BEHINDTARGET: return "http://hl7.org/fhir/resource-status";
            case NOTREADY: return "http://hl7.org/fhir/resource-status";
            case TRANSDUCDISCON: return "http://hl7.org/fhir/resource-status";
            case HWDISCON: return "http://hl7.org/fhir/resource-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ERROR: return "The resource was created in error, and should not be treated as valid (note: in many cases, for various data integrity related reasons, the information cannot be removed from the record)";
            case PROPOSED: return "The resource describes an action or plan that is proposed, and not yet approved by the participants";
            case PLANNED: return "The resource describes a course of action that is planned and agreed/approved, but at the time of recording was still future";
            case DRAFT: return "The information in the resource is still being prepared and edited";
            case REQUESTED: return "A fulfiller has been asked to perform this action, but it has not yet occurred";
            case RECEIVED: return "The fulfiller has received the request, but not yet agreed to carry out the action";
            case DECLINED: return "The fulfiller chose not to perform the action";
            case ACCEPTED: return "The fulfiller has decided to perform the action, and plans are in train to do this in the future";
            case ARRIVED: return "The pre-conditions for the action are all fulfilled, and it is imminent";
            case ACTIVE: return "The resource describes information that is currently valid or a process that is presently occuring";
            case SUSPENDED: return "The process described/requested in this resource has been halted for some reason";
            case FAILED: return "The process described/requested in the resource could not be completed, and no further action is planned";
            case REPLACED: return "The information in this resource has been replaced by information in another resource";
            case COMPLETE: return "The process described/requested in the resource has been completed, and no further action is planned";
            case INACTIVE: return "The resource describes information that is no longer valid or a process that is stopped occurring";
            case ABANDONED: return "The process described/requested in the resource did not complete - usually due to some workflow error, and no further action is planned";
            case UNKNOWN: return "Authoring system does not know the status";
            case UNCONFIRMED: return "The information in this resource is not yet approved";
            case CONFIRMED: return "The information in this resource is approved";
            case RESOLVED: return "The issue identified by this resource is no longer of concern";
            case REFUTED: return "This information has been ruled out by testing and evaluation";
            case DIFFERENTIAL: return "Potentially true?";
            case PARTIAL: return "This information is still being assembled";
            case BUSYUNAVAILABLE: return "not available at this time/location";
            case FREE: return "Free for scheduling";
            case ONTARGET: return "Ready to act";
            case AHEADOFTARGET: return "Ahead of the planned timelines";
            case BEHINDTARGET: return "";
            case NOTREADY: return "Behind the planned timelines";
            case TRANSDUCDISCON: return "The device transducer is disconnected";
            case HWDISCON: return "The hardware is disconnected";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ERROR: return "error";
            case PROPOSED: return "proposed";
            case PLANNED: return "planned";
            case DRAFT: return "draft";
            case REQUESTED: return "requested";
            case RECEIVED: return "received";
            case DECLINED: return "declined";
            case ACCEPTED: return "accepted";
            case ARRIVED: return "arrived";
            case ACTIVE: return "active";
            case SUSPENDED: return "suspended";
            case FAILED: return "failed";
            case REPLACED: return "replaced";
            case COMPLETE: return "complete";
            case INACTIVE: return "inactive";
            case ABANDONED: return "abandoned";
            case UNKNOWN: return "unknown";
            case UNCONFIRMED: return "unconfirmed";
            case CONFIRMED: return "confirmed";
            case RESOLVED: return "resolved";
            case REFUTED: return "refuted";
            case DIFFERENTIAL: return "differential";
            case PARTIAL: return "partial";
            case BUSYUNAVAILABLE: return "busy-unavailable";
            case FREE: return "free";
            case ONTARGET: return "on-target";
            case AHEADOFTARGET: return "ahead-of-target";
            case BEHINDTARGET: return "behind-target";
            case NOTREADY: return "not-ready";
            case TRANSDUCDISCON: return "transduc-discon";
            case HWDISCON: return "hw-discon";
            default: return "?";
          }
        }
    }

  public class CanonicalStatusEnumFactory implements EnumFactory<CanonicalStatus> {
    public CanonicalStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("error".equals(codeString))
          return CanonicalStatus.ERROR;
        if ("proposed".equals(codeString))
          return CanonicalStatus.PROPOSED;
        if ("planned".equals(codeString))
          return CanonicalStatus.PLANNED;
        if ("draft".equals(codeString))
          return CanonicalStatus.DRAFT;
        if ("requested".equals(codeString))
          return CanonicalStatus.REQUESTED;
        if ("received".equals(codeString))
          return CanonicalStatus.RECEIVED;
        if ("declined".equals(codeString))
          return CanonicalStatus.DECLINED;
        if ("accepted".equals(codeString))
          return CanonicalStatus.ACCEPTED;
        if ("arrived".equals(codeString))
          return CanonicalStatus.ARRIVED;
        if ("active".equals(codeString))
          return CanonicalStatus.ACTIVE;
        if ("suspended".equals(codeString))
          return CanonicalStatus.SUSPENDED;
        if ("failed".equals(codeString))
          return CanonicalStatus.FAILED;
        if ("replaced".equals(codeString))
          return CanonicalStatus.REPLACED;
        if ("complete".equals(codeString))
          return CanonicalStatus.COMPLETE;
        if ("inactive".equals(codeString))
          return CanonicalStatus.INACTIVE;
        if ("abandoned".equals(codeString))
          return CanonicalStatus.ABANDONED;
        if ("unknown".equals(codeString))
          return CanonicalStatus.UNKNOWN;
        if ("unconfirmed".equals(codeString))
          return CanonicalStatus.UNCONFIRMED;
        if ("confirmed".equals(codeString))
          return CanonicalStatus.CONFIRMED;
        if ("resolved".equals(codeString))
          return CanonicalStatus.RESOLVED;
        if ("refuted".equals(codeString))
          return CanonicalStatus.REFUTED;
        if ("differential".equals(codeString))
          return CanonicalStatus.DIFFERENTIAL;
        if ("partial".equals(codeString))
          return CanonicalStatus.PARTIAL;
        if ("busy-unavailable".equals(codeString))
          return CanonicalStatus.BUSYUNAVAILABLE;
        if ("free".equals(codeString))
          return CanonicalStatus.FREE;
        if ("on-target".equals(codeString))
          return CanonicalStatus.ONTARGET;
        if ("ahead-of-target".equals(codeString))
          return CanonicalStatus.AHEADOFTARGET;
        if ("behind-target".equals(codeString))
          return CanonicalStatus.BEHINDTARGET;
        if ("not-ready".equals(codeString))
          return CanonicalStatus.NOTREADY;
        if ("transduc-discon".equals(codeString))
          return CanonicalStatus.TRANSDUCDISCON;
        if ("hw-discon".equals(codeString))
          return CanonicalStatus.HWDISCON;
        throw new IllegalArgumentException("Unknown CanonicalStatus code '"+codeString+"'");
        }
        public Enumeration<CanonicalStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CanonicalStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("error".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.ERROR);
        if ("proposed".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.PROPOSED);
        if ("planned".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.PLANNED);
        if ("draft".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.DRAFT);
        if ("requested".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.REQUESTED);
        if ("received".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.RECEIVED);
        if ("declined".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.DECLINED);
        if ("accepted".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.ACCEPTED);
        if ("arrived".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.ARRIVED);
        if ("active".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.ACTIVE);
        if ("suspended".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.SUSPENDED);
        if ("failed".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.FAILED);
        if ("replaced".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.REPLACED);
        if ("complete".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.COMPLETE);
        if ("inactive".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.INACTIVE);
        if ("abandoned".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.ABANDONED);
        if ("unknown".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.UNKNOWN);
        if ("unconfirmed".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.UNCONFIRMED);
        if ("confirmed".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.CONFIRMED);
        if ("resolved".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.RESOLVED);
        if ("refuted".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.REFUTED);
        if ("differential".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.DIFFERENTIAL);
        if ("partial".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.PARTIAL);
        if ("busy-unavailable".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.BUSYUNAVAILABLE);
        if ("free".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.FREE);
        if ("on-target".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.ONTARGET);
        if ("ahead-of-target".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.AHEADOFTARGET);
        if ("behind-target".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.BEHINDTARGET);
        if ("not-ready".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.NOTREADY);
        if ("transduc-discon".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.TRANSDUCDISCON);
        if ("hw-discon".equals(codeString))
          return new Enumeration<CanonicalStatus>(this, CanonicalStatus.HWDISCON);
        throw new FHIRException("Unknown CanonicalStatus code '"+codeString+"'");
        }
    public String toCode(CanonicalStatus code) {
      if (code == CanonicalStatus.ERROR)
        return "error";
      if (code == CanonicalStatus.PROPOSED)
        return "proposed";
      if (code == CanonicalStatus.PLANNED)
        return "planned";
      if (code == CanonicalStatus.DRAFT)
        return "draft";
      if (code == CanonicalStatus.REQUESTED)
        return "requested";
      if (code == CanonicalStatus.RECEIVED)
        return "received";
      if (code == CanonicalStatus.DECLINED)
        return "declined";
      if (code == CanonicalStatus.ACCEPTED)
        return "accepted";
      if (code == CanonicalStatus.ARRIVED)
        return "arrived";
      if (code == CanonicalStatus.ACTIVE)
        return "active";
      if (code == CanonicalStatus.SUSPENDED)
        return "suspended";
      if (code == CanonicalStatus.FAILED)
        return "failed";
      if (code == CanonicalStatus.REPLACED)
        return "replaced";
      if (code == CanonicalStatus.COMPLETE)
        return "complete";
      if (code == CanonicalStatus.INACTIVE)
        return "inactive";
      if (code == CanonicalStatus.ABANDONED)
        return "abandoned";
      if (code == CanonicalStatus.UNKNOWN)
        return "unknown";
      if (code == CanonicalStatus.UNCONFIRMED)
        return "unconfirmed";
      if (code == CanonicalStatus.CONFIRMED)
        return "confirmed";
      if (code == CanonicalStatus.RESOLVED)
        return "resolved";
      if (code == CanonicalStatus.REFUTED)
        return "refuted";
      if (code == CanonicalStatus.DIFFERENTIAL)
        return "differential";
      if (code == CanonicalStatus.PARTIAL)
        return "partial";
      if (code == CanonicalStatus.BUSYUNAVAILABLE)
        return "busy-unavailable";
      if (code == CanonicalStatus.FREE)
        return "free";
      if (code == CanonicalStatus.ONTARGET)
        return "on-target";
      if (code == CanonicalStatus.AHEADOFTARGET)
        return "ahead-of-target";
      if (code == CanonicalStatus.BEHINDTARGET)
        return "behind-target";
      if (code == CanonicalStatus.NOTREADY)
        return "not-ready";
      if (code == CanonicalStatus.TRANSDUCDISCON)
        return "transduc-discon";
      if (code == CanonicalStatus.HWDISCON)
        return "hw-discon";
      return "?";
      }
    public String toSystem(CanonicalStatus code) {
      return code.getSystem();
      }
    }

    /**
     * @return {@link #identifier} (Business Identifier.)
     */
    public List<Identifier> getIdentifier();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setIdentifier(List<Identifier> theIdentifier);

    public boolean hasIdentifier();

    public Identifier addIdentifier();

    public Fivews addIdentifier(Identifier t);

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() ;

    /**
     * @return {@link #version} (Identifier for this version.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement();

    public boolean hasVersionElement();

    public boolean hasVersion();

    /**
     * @param value {@link #version} (Identifier for this version.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Fivews setVersionElement(StringType value) ;

    /**
     * @return Identifier for this version.
     */
    public String getVersion();

    /**
     * @param value Identifier for this version.
     */
    public Fivews setVersion(String value);

    /**
     * @return {@link #status} (Status Field.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<CanonicalStatus> getStatusElement();

    public boolean hasStatusElement();

    public boolean hasStatus();

    /**
     * @param value {@link #status} (Status Field.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Fivews setStatusElement(Enumeration<CanonicalStatus> value) ;

    /**
     * @return Status Field.
     */
    public CanonicalStatus getStatus();

    /**
     * @param value Status Field.
     */
    public Fivews setStatus(CanonicalStatus value);

    /**
     * @return {@link #class_} (Classifier Field.)
     */
    public List<CodeableConcept> getClass_();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setClass_(List<CodeableConcept> theClass_);

    public boolean hasClass_();

    public CodeableConcept addClass_();

    public Fivews addClass_(CodeableConcept t);

    /**
     * @return The first repetition of repeating field {@link #class_}, creating it if it does not already exist
     */
    public CodeableConcept getClass_FirstRep() ;

    /**
     * @return {@link #grade} (A field that indicates the potential impact of the content of the resource.)
     */
    public CodeableConcept getGrade();

    public boolean hasGrade();

    /**
     * @param value {@link #grade} (A field that indicates the potential impact of the content of the resource.)
     */
    public Fivews setGrade(CodeableConcept value);

    /**
     * @return {@link #what} (what this resource is about.)
     */
    public Type getWhat();

    /**
     * @return {@link #what} (what this resource is about.)
     */
    public CodeableConcept getWhatCodeableConcept() throws FHIRException;

    public boolean hasWhatCodeableConcept();

    /**
     * @return {@link #what} (what this resource is about.)
     */
    public Reference getWhatReference() throws FHIRException;

    public boolean hasWhatReference();

    public boolean hasWhat();

    /**
     * @param value {@link #what} (what this resource is about.)
     */
    public Fivews setWhat(Type value);

    /**
     * @return {@link #subject} (Who this resource is about.)
     */
    public List<Reference> getSubject();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setSubject(List<Reference> theSubject);

    public boolean hasSubject();

    public Reference addSubject();

    public Fivews addSubject(Reference t);

    /**
     * @return The first repetition of repeating field {@link #subject}, creating it if it does not already exist
     */
    public Reference getSubjectFirstRep() ;

    /**
     * @return {@link #context} (a resource that gives context for the work described in this resource (usually Encounter or EpisodeOfCare).)
     */
    public Reference getContext();

    public boolean hasContext();

    /**
     * @param value {@link #context} (a resource that gives context for the work described in this resource (usually Encounter or EpisodeOfCare).)
     */
    public Fivews setContext(Reference value);

    /**
     * @return {@link #context} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (a resource that gives context for the work described in this resource (usually Encounter or EpisodeOfCare).)
     */
    public Resource getContextTarget();

    /**
     * @param value {@link #context} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (a resource that gives context for the work described in this resource (usually Encounter or EpisodeOfCare).)
     */
    public Fivews setContextTarget(Resource value);

    /**
     * @return {@link #init} (when the work described in this resource was started (or will be).). This is the underlying object with id, value and extensions. The accessor "getInit" gives direct access to the value
     */
    public DateTimeType getInitElement();

    public boolean hasInitElement();

    public boolean hasInit();

    /**
     * @param value {@link #init} (when the work described in this resource was started (or will be).). This is the underlying object with id, value and extensions. The accessor "getInit" gives direct access to the value
     */
    public Fivews setInitElement(DateTimeType value) ;

    /**
     * @return when the work described in this resource was started (or will be).
     */
    public Date getInit();

    /**
     * @param value when the work described in this resource was started (or will be).
     */
    public Fivews setInit(Date value);

    /**
     * @return {@link #planned} (when this resource is planned to occur.)
     */
    public List<Timing> getPlanned();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setPlanned(List<Timing> thePlanned);

    public boolean hasPlanned();

    public Timing addPlanned();

    public Fivews addPlanned(Timing t);

    /**
     * @return The first repetition of repeating field {@link #planned}, creating it if it does not already exist
     */
    public Timing getPlannedFirstRep() ;

    /**
     * @return {@link #done} (when the work described in this resource was completed (or will be).)
     */
    public Type getDone();

    /**
     * @return {@link #done} (when the work described in this resource was completed (or will be).)
     */
    public DateTimeType getDoneDateTimeType() throws FHIRException;

    public boolean hasDoneDateTimeType();

    /**
     * @return {@link #done} (when the work described in this resource was completed (or will be).)
     */
    public Period getDonePeriod() throws FHIRException;

    public boolean hasDonePeriod();

    public boolean hasDone();

    /**
     * @param value {@link #done} (when the work described in this resource was completed (or will be).)
     */
    public Fivews setDone(Type value);

    /**
     * @return {@link #recorded} (when this resource itself was created.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public InstantType getRecordedElement();

    public boolean hasRecordedElement();

    public boolean hasRecorded();

    /**
     * @param value {@link #recorded} (when this resource itself was created.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public Fivews setRecordedElement(InstantType value) ;

    /**
     * @return when this resource itself was created.
     */
    public Date getRecorded();

    /**
     * @param value when this resource itself was created.
     */
    public Fivews setRecorded(Date value);

    /**
     * @return {@link #author} (who authored the content of the resource.)
     */
    public List<Reference> getAuthor();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setAuthor(List<Reference> theAuthor);

    public boolean hasAuthor();

    public Reference addAuthor();

    public Fivews addAuthor(Reference t);

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist
     */
    public Reference getAuthorFirstRep() ;

    /**
     * @return {@link #source} (Who provided the information in this resource.)
     */
    public List<Reference> getSource();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setSource(List<Reference> theSource);

    public boolean hasSource();

    public Reference addSource();

    public Fivews addSource(Reference t);

    /**
     * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist
     */
    public Reference getSourceFirstRep() ;

    /**
     * @return {@link #actor} (who did the work described the resource (or will do).)
     */
    public List<Reference> getActor();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setActor(List<Reference> theActor);

    public boolean hasActor();

    public Reference addActor();

    public Fivews addActor(Reference t);

    /**
     * @return The first repetition of repeating field {@link #actor}, creating it if it does not already exist
     */
    public Reference getActorFirstRep() ;

    /**
     * @return {@link #cause} (who prompted the work described in the resource.)
     */
    public List<Reference> getCause();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setCause(List<Reference> theCause);

    public boolean hasCause();

    public Reference addCause();

    public Fivews addCause(Reference t);

    /**
     * @return The first repetition of repeating field {@link #cause}, creating it if it does not already exist
     */
    public Reference getCauseFirstRep() ;

    /**
     * @return {@link #witness} (who attests to the content of the resource (individual or org).)
     */
    public List<Reference> getWitness();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setWitness(List<Reference> theWitness);

    public boolean hasWitness();

    public Reference addWitness();

    public Fivews addWitness(Reference t);

    /**
     * @return The first repetition of repeating field {@link #witness}, creating it if it does not already exist
     */
    public Reference getWitnessFirstRep() ;

    /**
     * @return {@link #who} (An actor involved in the work described by this resource.)
     */
    public List<Reference> getWho();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setWho(List<Reference> theWho);

    public boolean hasWho();

    public Reference addWho();

    public Fivews addWho(Reference t);

    /**
     * @return The first repetition of repeating field {@link #who}, creating it if it does not already exist
     */
    public Reference getWhoFirstRep() ;

    /**
     * @return {@link #where} (The location of the work described.)
     */
    public List<Type> getWhere();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setWhere(List<Type> theWhere);

    public boolean hasWhere();

    public Type addWhere();

    public Fivews addWhere(Type t);

    /**
     * @return The first repetition of repeating field {@link #where}, creating it if it does not already exist
     */
    public Type getWhereFirstRep() ;

    /**
     * @return {@link #why} (Why this work was done.)
     */
    public List<Type> getWhy();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Fivews setWhy(List<Type> theWhy);

    public boolean hasWhy();

    public Type addWhy();

    public Fivews addWhy(Type t);

    /**
     * @return The first repetition of repeating field {@link #why}, creating it if it does not already exist
     */
    public Type getWhyFirstRep() ;

  public String fhirType();


}

