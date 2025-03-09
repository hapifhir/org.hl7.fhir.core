package org.hl7.fhir.r5.tools;


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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.tools.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * This structure is defined to allow the FHIR Validator to validate a CDSHooks Order-Sign context. TODO: This content will be moved to the CDS Hooks specification in the future
 */
@DatatypeDef(name="CDSHookOrderSignContext")
public class CDSHookOrderSignContext extends CDSHookContext implements ICompositeType {

    /**
     * For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.
     */
    @Child(name = "userId", type = {UrlType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The id of the current user. Must be in the format [ResourceType]/[id].", formalDefinition="For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123." )
    protected UrlType userId;

    /**
     * The FHIR Patient.id of the current patient in context
     */
    @Child(name = "patientId", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The FHIR Patient.id of the current patient in context", formalDefinition="The FHIR Patient.id of the current patient in context" )
    protected IdType patientId;

    /**
     * The FHIR Encounter.id of the current encounter in context
     */
    @Child(name = "encounterId", type = {IdType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The FHIR Encounter.id of the current encounter in context", formalDefinition="The FHIR Encounter.id of the current encounter in context" )
    protected IdType encounterId;

    /**
     * FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status
     */
    @Child(name = "draftOrders", type = {Bundle.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status", formalDefinition="FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status" )
    protected Bundle draftOrders;

    private static final long serialVersionUID = -590647101L;

  /**
   * Constructor
   */
    public CDSHookOrderSignContext() {
      super();
    }

  /**
   * Constructor
   */
    public CDSHookOrderSignContext(String userId, String patientId, Bundle draftOrders) {
      super();
      this.setUserId(userId);
      this.setPatientId(patientId);
      this.setDraftOrders(draftOrders);
    }

    /**
     * @return {@link #userId} (For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.). This is the underlying object with id, value and extensions. The accessor "getUserId" gives direct access to the value
     */
    public UrlType getUserIdElement() { 
      if (this.userId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHookOrderSignContext.userId");
        else if (Configuration.doAutoCreate())
          this.userId = new UrlType(); // bb
      return this.userId;
    }

    public boolean hasUserIdElement() { 
      return this.userId != null && !this.userId.isEmpty();
    }

    public boolean hasUserId() { 
      return this.userId != null && !this.userId.isEmpty();
    }

    /**
     * @param value {@link #userId} (For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.). This is the underlying object with id, value and extensions. The accessor "getUserId" gives direct access to the value
     */
    public CDSHookOrderSignContext setUserIdElement(UrlType value) { 
      this.userId = value;
      return this;
    }

    /**
     * @return For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.
     */
    public String getUserId() { 
      return this.userId == null ? null : this.userId.getValue();
    }

    /**
     * @param value For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.
     */
    public CDSHookOrderSignContext setUserId(String value) { 
        if (this.userId == null)
          this.userId = new UrlType();
        this.userId.setValue(value);
      return this;
    }

    /**
     * @return {@link #patientId} (The FHIR Patient.id of the current patient in context). This is the underlying object with id, value and extensions. The accessor "getPatientId" gives direct access to the value
     */
    public IdType getPatientIdElement() { 
      if (this.patientId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHookOrderSignContext.patientId");
        else if (Configuration.doAutoCreate())
          this.patientId = new IdType(); // bb
      return this.patientId;
    }

    public boolean hasPatientIdElement() { 
      return this.patientId != null && !this.patientId.isEmpty();
    }

    public boolean hasPatientId() { 
      return this.patientId != null && !this.patientId.isEmpty();
    }

    /**
     * @param value {@link #patientId} (The FHIR Patient.id of the current patient in context). This is the underlying object with id, value and extensions. The accessor "getPatientId" gives direct access to the value
     */
    public CDSHookOrderSignContext setPatientIdElement(IdType value) { 
      this.patientId = value;
      return this;
    }

    /**
     * @return The FHIR Patient.id of the current patient in context
     */
    public String getPatientId() { 
      return this.patientId == null ? null : this.patientId.getValue();
    }

    /**
     * @param value The FHIR Patient.id of the current patient in context
     */
    public CDSHookOrderSignContext setPatientId(String value) { 
        if (this.patientId == null)
          this.patientId = new IdType();
        this.patientId.setValue(value);
      return this;
    }

    /**
     * @return {@link #encounterId} (The FHIR Encounter.id of the current encounter in context). This is the underlying object with id, value and extensions. The accessor "getEncounterId" gives direct access to the value
     */
    public IdType getEncounterIdElement() { 
      if (this.encounterId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHookOrderSignContext.encounterId");
        else if (Configuration.doAutoCreate())
          this.encounterId = new IdType(); // bb
      return this.encounterId;
    }

    public boolean hasEncounterIdElement() { 
      return this.encounterId != null && !this.encounterId.isEmpty();
    }

    public boolean hasEncounterId() { 
      return this.encounterId != null && !this.encounterId.isEmpty();
    }

    /**
     * @param value {@link #encounterId} (The FHIR Encounter.id of the current encounter in context). This is the underlying object with id, value and extensions. The accessor "getEncounterId" gives direct access to the value
     */
    public CDSHookOrderSignContext setEncounterIdElement(IdType value) { 
      this.encounterId = value;
      return this;
    }

    /**
     * @return The FHIR Encounter.id of the current encounter in context
     */
    public String getEncounterId() { 
      return this.encounterId == null ? null : this.encounterId.getValue();
    }

    /**
     * @param value The FHIR Encounter.id of the current encounter in context
     */
    public CDSHookOrderSignContext setEncounterId(String value) { 
      if (Utilities.noString(value))
        this.encounterId = null;
      else {
        if (this.encounterId == null)
          this.encounterId = new IdType();
        this.encounterId.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #draftOrders} (FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status)
     */
    public Bundle getDraftOrders() { 
      if (this.draftOrders == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHookOrderSignContext.draftOrders");
        else if (Configuration.doAutoCreate())
          this.draftOrders = new Bundle(); // cc
      return this.draftOrders;
    }

    public boolean hasDraftOrders() { 
      return this.draftOrders != null && !this.draftOrders.isEmpty();
    }

    /**
     * @param value {@link #draftOrders} (FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status)
     */
    public CDSHookOrderSignContext setDraftOrders(Bundle value) { 
      this.draftOrders = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("userId", "url", "For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.", 0, 1, userId));
        children.add(new Property("patientId", "id", "The FHIR Patient.id of the current patient in context", 0, 1, patientId));
        children.add(new Property("encounterId", "id", "The FHIR Encounter.id of the current encounter in context", 0, 1, encounterId));
        children.add(new Property("draftOrders", "Bundle", "FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status", 0, 1, draftOrders));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -836030906: /*userId*/  return new Property("userId", "url", "For this hook, the user is expected to be of type Practitioner, PractitionerRole, Patient, or RelatedPerson. Patient or RelatedPerson are appropriate when a patient or their proxy are viewing the record. For example, Practitioner/abc or Patient/123.", 0, 1, userId);
        case -343587072: /*patientId*/  return new Property("patientId", "id", "The FHIR Patient.id of the current patient in context", 0, 1, patientId);
        case 107147694: /*encounterId*/  return new Property("encounterId", "id", "The FHIR Encounter.id of the current encounter in context", 0, 1, encounterId);
        case 155667430: /*draftOrders*/  return new Property("draftOrders", "Bundle", "FHIR Bundle of MedicationRequest, NutritionOrder, ServiceRequest, VisionPrescription with draft status", 0, 1, draftOrders);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -836030906: /*userId*/ return this.userId == null ? new Base[0] : new Base[] {this.userId}; // UrlType
        case -343587072: /*patientId*/ return this.patientId == null ? new Base[0] : new Base[] {this.patientId}; // IdType
        case 107147694: /*encounterId*/ return this.encounterId == null ? new Base[0] : new Base[] {this.encounterId}; // IdType
        case 155667430: /*draftOrders*/ return this.draftOrders == null ? new Base[0] : new Base[] {this.draftOrders}; // Bundle
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -836030906: // userId
          this.userId = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case -343587072: // patientId
          this.patientId = TypeConvertor.castToId(value); // IdType
          return value;
        case 107147694: // encounterId
          this.encounterId = TypeConvertor.castToId(value); // IdType
          return value;
        case 155667430: // draftOrders
          this.draftOrders = (Bundle) value; // Bundle
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("userId")) {
          this.userId = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("patientId")) {
          this.patientId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("encounterId")) {
          this.encounterId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("draftOrders")) {
          this.draftOrders = (Bundle) value; // Bundle
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -836030906:  return getUserIdElement();
        case -343587072:  return getPatientIdElement();
        case 107147694:  return getEncounterIdElement();
        case 155667430:  return getDraftOrders();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -836030906: /*userId*/ return new String[] {"url"};
        case -343587072: /*patientId*/ return new String[] {"id"};
        case 107147694: /*encounterId*/ return new String[] {"id"};
        case 155667430: /*draftOrders*/ return new String[] {"Bundle"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("userId")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHookOrderSignContext.userId");
        }
        else if (name.equals("patientId")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHookOrderSignContext.patientId");
        }
        else if (name.equals("encounterId")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHookOrderSignContext.encounterId");
        }
        else if (name.equals("draftOrders")) {
          this.draftOrders = new Bundle();
          return this.draftOrders;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CDSHookOrderSignContext";

  }

      public CDSHookOrderSignContext copy() {
        CDSHookOrderSignContext dst = new CDSHookOrderSignContext();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHookOrderSignContext dst) {
        super.copyValues(dst);
        dst.userId = userId == null ? null : userId.copy();
        dst.patientId = patientId == null ? null : patientId.copy();
        dst.encounterId = encounterId == null ? null : encounterId.copy();
        dst.draftOrders = draftOrders == null ? null : draftOrders.copy();
      }

      protected CDSHookOrderSignContext typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHookOrderSignContext))
          return false;
        CDSHookOrderSignContext o = (CDSHookOrderSignContext) other_;
        return compareDeep(userId, o.userId, true) && compareDeep(patientId, o.patientId, true) && compareDeep(encounterId, o.encounterId, true)
           && compareDeep(draftOrders, o.draftOrders, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHookOrderSignContext))
          return false;
        CDSHookOrderSignContext o = (CDSHookOrderSignContext) other_;
        return compareValues(userId, o.userId, true) && compareValues(patientId, o.patientId, true) && compareValues(encounterId, o.encounterId, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(userId, patientId, encounterId
          , draftOrders);
      }


}

