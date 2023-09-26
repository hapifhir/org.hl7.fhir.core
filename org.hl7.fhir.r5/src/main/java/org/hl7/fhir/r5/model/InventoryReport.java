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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

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
 * A report of inventory or stock items.
 */
@ResourceDef(name="InventoryReport", profile="http://hl7.org/fhir/StructureDefinition/InventoryReport")
public class InventoryReport extends DomainResource {

    public enum InventoryCountType {
        /**
         * The inventory report is a current absolute snapshot, i.e. it represents the quantities at hand.
         */
        SNAPSHOT, 
        /**
         * The inventory report is about the difference between a previous count and a current count, i.e. it represents the items that have been added/subtracted from inventory.
         */
        DIFFERENCE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static InventoryCountType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("snapshot".equals(codeString))
          return SNAPSHOT;
        if ("difference".equals(codeString))
          return DIFFERENCE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown InventoryCountType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SNAPSHOT: return "snapshot";
            case DIFFERENCE: return "difference";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SNAPSHOT: return "http://hl7.org/fhir/inventoryreport-counttype";
            case DIFFERENCE: return "http://hl7.org/fhir/inventoryreport-counttype";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SNAPSHOT: return "The inventory report is a current absolute snapshot, i.e. it represents the quantities at hand.";
            case DIFFERENCE: return "The inventory report is about the difference between a previous count and a current count, i.e. it represents the items that have been added/subtracted from inventory.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SNAPSHOT: return "Snapshot";
            case DIFFERENCE: return "Difference";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class InventoryCountTypeEnumFactory implements EnumFactory<InventoryCountType> {
    public InventoryCountType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("snapshot".equals(codeString))
          return InventoryCountType.SNAPSHOT;
        if ("difference".equals(codeString))
          return InventoryCountType.DIFFERENCE;
        throw new IllegalArgumentException("Unknown InventoryCountType code '"+codeString+"'");
        }
        public Enumeration<InventoryCountType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InventoryCountType>(this, InventoryCountType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<InventoryCountType>(this, InventoryCountType.NULL, code);
        if ("snapshot".equals(codeString))
          return new Enumeration<InventoryCountType>(this, InventoryCountType.SNAPSHOT, code);
        if ("difference".equals(codeString))
          return new Enumeration<InventoryCountType>(this, InventoryCountType.DIFFERENCE, code);
        throw new FHIRException("Unknown InventoryCountType code '"+codeString+"'");
        }
    public String toCode(InventoryCountType code) {
      if (code == InventoryCountType.SNAPSHOT)
        return "snapshot";
      if (code == InventoryCountType.DIFFERENCE)
        return "difference";
      return "?";
      }
    public String toSystem(InventoryCountType code) {
      return code.getSystem();
      }
    }

    public enum InventoryReportStatus {
        /**
         * The existence of the report is registered, but it is still without content or only some preliminary content.
         */
        DRAFT, 
        /**
         * The inventory report has been requested but there is no data available.
         */
        REQUESTED, 
        /**
         * This report is submitted as current.
         */
        ACTIVE, 
        /**
         * The report has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static InventoryReportStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("requested".equals(codeString))
          return REQUESTED;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown InventoryReportStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case REQUESTED: return "requested";
            case ACTIVE: return "active";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/inventoryreport-status";
            case REQUESTED: return "http://hl7.org/fhir/inventoryreport-status";
            case ACTIVE: return "http://hl7.org/fhir/inventoryreport-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/inventoryreport-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "The existence of the report is registered, but it is still without content or only some preliminary content.";
            case REQUESTED: return "The inventory report has been requested but there is no data available.";
            case ACTIVE: return "This report is submitted as current.";
            case ENTEREDINERROR: return "The report has been withdrawn following a previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case REQUESTED: return "Requested";
            case ACTIVE: return "Active";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class InventoryReportStatusEnumFactory implements EnumFactory<InventoryReportStatus> {
    public InventoryReportStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return InventoryReportStatus.DRAFT;
        if ("requested".equals(codeString))
          return InventoryReportStatus.REQUESTED;
        if ("active".equals(codeString))
          return InventoryReportStatus.ACTIVE;
        if ("entered-in-error".equals(codeString))
          return InventoryReportStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown InventoryReportStatus code '"+codeString+"'");
        }
        public Enumeration<InventoryReportStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InventoryReportStatus>(this, InventoryReportStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<InventoryReportStatus>(this, InventoryReportStatus.NULL, code);
        if ("draft".equals(codeString))
          return new Enumeration<InventoryReportStatus>(this, InventoryReportStatus.DRAFT, code);
        if ("requested".equals(codeString))
          return new Enumeration<InventoryReportStatus>(this, InventoryReportStatus.REQUESTED, code);
        if ("active".equals(codeString))
          return new Enumeration<InventoryReportStatus>(this, InventoryReportStatus.ACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<InventoryReportStatus>(this, InventoryReportStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown InventoryReportStatus code '"+codeString+"'");
        }
    public String toCode(InventoryReportStatus code) {
      if (code == InventoryReportStatus.DRAFT)
        return "draft";
      if (code == InventoryReportStatus.REQUESTED)
        return "requested";
      if (code == InventoryReportStatus.ACTIVE)
        return "active";
      if (code == InventoryReportStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(InventoryReportStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class InventoryReportInventoryListingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Location of the inventory items.
         */
        @Child(name = "location", type = {Location.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Location of the inventory items", formalDefinition="Location of the inventory items." )
        protected Reference location;

        /**
         * The status of the items.
         */
        @Child(name = "itemStatus", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the items that are being reported", formalDefinition="The status of the items." )
        protected CodeableConcept itemStatus;

        /**
         * The date and time when the items were counted.
         */
        @Child(name = "countingDateTime", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date and time when the items were counted", formalDefinition="The date and time when the items were counted." )
        protected DateTimeType countingDateTime;

        /**
         * The item or items in this listing.
         */
        @Child(name = "item", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The item or items in this listing", formalDefinition="The item or items in this listing." )
        protected List<InventoryReportInventoryListingItemComponent> item;

        private static final long serialVersionUID = 1766136476L;

    /**
     * Constructor
     */
      public InventoryReportInventoryListingComponent() {
        super();
      }

        /**
         * @return {@link #location} (Location of the inventory items.)
         */
        public Reference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryReportInventoryListingComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new Reference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (Location of the inventory items.)
         */
        public InventoryReportInventoryListingComponent setLocation(Reference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #itemStatus} (The status of the items.)
         */
        public CodeableConcept getItemStatus() { 
          if (this.itemStatus == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryReportInventoryListingComponent.itemStatus");
            else if (Configuration.doAutoCreate())
              this.itemStatus = new CodeableConcept(); // cc
          return this.itemStatus;
        }

        public boolean hasItemStatus() { 
          return this.itemStatus != null && !this.itemStatus.isEmpty();
        }

        /**
         * @param value {@link #itemStatus} (The status of the items.)
         */
        public InventoryReportInventoryListingComponent setItemStatus(CodeableConcept value) { 
          this.itemStatus = value;
          return this;
        }

        /**
         * @return {@link #countingDateTime} (The date and time when the items were counted.). This is the underlying object with id, value and extensions. The accessor "getCountingDateTime" gives direct access to the value
         */
        public DateTimeType getCountingDateTimeElement() { 
          if (this.countingDateTime == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryReportInventoryListingComponent.countingDateTime");
            else if (Configuration.doAutoCreate())
              this.countingDateTime = new DateTimeType(); // bb
          return this.countingDateTime;
        }

        public boolean hasCountingDateTimeElement() { 
          return this.countingDateTime != null && !this.countingDateTime.isEmpty();
        }

        public boolean hasCountingDateTime() { 
          return this.countingDateTime != null && !this.countingDateTime.isEmpty();
        }

        /**
         * @param value {@link #countingDateTime} (The date and time when the items were counted.). This is the underlying object with id, value and extensions. The accessor "getCountingDateTime" gives direct access to the value
         */
        public InventoryReportInventoryListingComponent setCountingDateTimeElement(DateTimeType value) { 
          this.countingDateTime = value;
          return this;
        }

        /**
         * @return The date and time when the items were counted.
         */
        public Date getCountingDateTime() { 
          return this.countingDateTime == null ? null : this.countingDateTime.getValue();
        }

        /**
         * @param value The date and time when the items were counted.
         */
        public InventoryReportInventoryListingComponent setCountingDateTime(Date value) { 
          if (value == null)
            this.countingDateTime = null;
          else {
            if (this.countingDateTime == null)
              this.countingDateTime = new DateTimeType();
            this.countingDateTime.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #item} (The item or items in this listing.)
         */
        public List<InventoryReportInventoryListingItemComponent> getItem() { 
          if (this.item == null)
            this.item = new ArrayList<InventoryReportInventoryListingItemComponent>();
          return this.item;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public InventoryReportInventoryListingComponent setItem(List<InventoryReportInventoryListingItemComponent> theItem) { 
          this.item = theItem;
          return this;
        }

        public boolean hasItem() { 
          if (this.item == null)
            return false;
          for (InventoryReportInventoryListingItemComponent item : this.item)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public InventoryReportInventoryListingItemComponent addItem() { //3
          InventoryReportInventoryListingItemComponent t = new InventoryReportInventoryListingItemComponent();
          if (this.item == null)
            this.item = new ArrayList<InventoryReportInventoryListingItemComponent>();
          this.item.add(t);
          return t;
        }

        public InventoryReportInventoryListingComponent addItem(InventoryReportInventoryListingItemComponent t) { //3
          if (t == null)
            return this;
          if (this.item == null)
            this.item = new ArrayList<InventoryReportInventoryListingItemComponent>();
          this.item.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist {3}
         */
        public InventoryReportInventoryListingItemComponent getItemFirstRep() { 
          if (getItem().isEmpty()) {
            addItem();
          }
          return getItem().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("location", "Reference(Location)", "Location of the inventory items.", 0, 1, location));
          children.add(new Property("itemStatus", "CodeableConcept", "The status of the items.", 0, 1, itemStatus));
          children.add(new Property("countingDateTime", "dateTime", "The date and time when the items were counted.", 0, 1, countingDateTime));
          children.add(new Property("item", "", "The item or items in this listing.", 0, java.lang.Integer.MAX_VALUE, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "Location of the inventory items.", 0, 1, location);
          case 1999789285: /*itemStatus*/  return new Property("itemStatus", "CodeableConcept", "The status of the items.", 0, 1, itemStatus);
          case -2075203282: /*countingDateTime*/  return new Property("countingDateTime", "dateTime", "The date and time when the items were counted.", 0, 1, countingDateTime);
          case 3242771: /*item*/  return new Property("item", "", "The item or items in this listing.", 0, java.lang.Integer.MAX_VALUE, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 1999789285: /*itemStatus*/ return this.itemStatus == null ? new Base[0] : new Base[] {this.itemStatus}; // CodeableConcept
        case -2075203282: /*countingDateTime*/ return this.countingDateTime == null ? new Base[0] : new Base[] {this.countingDateTime}; // DateTimeType
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // InventoryReportInventoryListingItemComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1999789285: // itemStatus
          this.itemStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2075203282: // countingDateTime
          this.countingDateTime = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 3242771: // item
          this.getItem().add((InventoryReportInventoryListingItemComponent) value); // InventoryReportInventoryListingItemComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("itemStatus")) {
          this.itemStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("countingDateTime")) {
          this.countingDateTime = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("item")) {
          this.getItem().add((InventoryReportInventoryListingItemComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("itemStatus")) {
          this.itemStatus = null;
        } else if (name.equals("countingDateTime")) {
          this.countingDateTime = null;
        } else if (name.equals("item")) {
          this.getItem().add((InventoryReportInventoryListingItemComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1901043637:  return getLocation();
        case 1999789285:  return getItemStatus();
        case -2075203282:  return getCountingDateTimeElement();
        case 3242771:  return addItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 1999789285: /*itemStatus*/ return new String[] {"CodeableConcept"};
        case -2075203282: /*countingDateTime*/ return new String[] {"dateTime"};
        case 3242771: /*item*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("itemStatus")) {
          this.itemStatus = new CodeableConcept();
          return this.itemStatus;
        }
        else if (name.equals("countingDateTime")) {
          throw new FHIRException("Cannot call addChild on a singleton property InventoryReport.inventoryListing.countingDateTime");
        }
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

      public InventoryReportInventoryListingComponent copy() {
        InventoryReportInventoryListingComponent dst = new InventoryReportInventoryListingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryReportInventoryListingComponent dst) {
        super.copyValues(dst);
        dst.location = location == null ? null : location.copy();
        dst.itemStatus = itemStatus == null ? null : itemStatus.copy();
        dst.countingDateTime = countingDateTime == null ? null : countingDateTime.copy();
        if (item != null) {
          dst.item = new ArrayList<InventoryReportInventoryListingItemComponent>();
          for (InventoryReportInventoryListingItemComponent i : item)
            dst.item.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryReportInventoryListingComponent))
          return false;
        InventoryReportInventoryListingComponent o = (InventoryReportInventoryListingComponent) other_;
        return compareDeep(location, o.location, true) && compareDeep(itemStatus, o.itemStatus, true) && compareDeep(countingDateTime, o.countingDateTime, true)
           && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryReportInventoryListingComponent))
          return false;
        InventoryReportInventoryListingComponent o = (InventoryReportInventoryListingComponent) other_;
        return compareValues(countingDateTime, o.countingDateTime, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(location, itemStatus, countingDateTime
          , item);
      }

  public String fhirType() {
    return "InventoryReport.inventoryListing";

  }

  }

    @Block()
    public static class InventoryReportInventoryListingItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The inventory category or classification of the items being reported. This is meant not for defining the product, but for inventory categories e.g. 'pending recount' or 'damaged'.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The inventory category or classification of the items being reported", formalDefinition="The inventory category or classification of the items being reported. This is meant not for defining the product, but for inventory categories e.g. 'pending recount' or 'damaged'." )
        protected CodeableConcept category;

        /**
         * The quantity of the item or items being reported.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of the item or items being reported", formalDefinition="The quantity of the item or items being reported." )
        protected Quantity quantity;

        /**
         * The code or reference to the item type.
         */
        @Child(name = "item", type = {CodeableReference.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The code or reference to the item type", formalDefinition="The code or reference to the item type." )
        protected CodeableReference item;

        private static final long serialVersionUID = 566223460L;

    /**
     * Constructor
     */
      public InventoryReportInventoryListingItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InventoryReportInventoryListingItemComponent(Quantity quantity, CodeableReference item) {
        super();
        this.setQuantity(quantity);
        this.setItem(item);
      }

        /**
         * @return {@link #category} (The inventory category or classification of the items being reported. This is meant not for defining the product, but for inventory categories e.g. 'pending recount' or 'damaged'.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryReportInventoryListingItemComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (The inventory category or classification of the items being reported. This is meant not for defining the product, but for inventory categories e.g. 'pending recount' or 'damaged'.)
         */
        public InventoryReportInventoryListingItemComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The quantity of the item or items being reported.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryReportInventoryListingItemComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The quantity of the item or items being reported.)
         */
        public InventoryReportInventoryListingItemComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #item} (The code or reference to the item type.)
         */
        public CodeableReference getItem() { 
          if (this.item == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InventoryReportInventoryListingItemComponent.item");
            else if (Configuration.doAutoCreate())
              this.item = new CodeableReference(); // cc
          return this.item;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The code or reference to the item type.)
         */
        public InventoryReportInventoryListingItemComponent setItem(CodeableReference value) { 
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "The inventory category or classification of the items being reported. This is meant not for defining the product, but for inventory categories e.g. 'pending recount' or 'damaged'.", 0, 1, category));
          children.add(new Property("quantity", "Quantity", "The quantity of the item or items being reported.", 0, 1, quantity));
          children.add(new Property("item", "CodeableReference(Medication|Device|Medication|NutritionProduct|InventoryItem|BiologicallyDerivedProduct|InventoryItem)", "The code or reference to the item type.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "The inventory category or classification of the items being reported. This is meant not for defining the product, but for inventory categories e.g. 'pending recount' or 'damaged'.", 0, 1, category);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The quantity of the item or items being reported.", 0, 1, quantity);
          case 3242771: /*item*/  return new Property("item", "CodeableReference(Medication|Device|Medication|NutritionProduct|InventoryItem|BiologicallyDerivedProduct|InventoryItem)", "The code or reference to the item type.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // CodeableReference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 3242771: // item
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("item")) {
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = null;
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("item")) {
          this.item = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case -1285004149:  return getQuantity();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("item")) {
          this.item = new CodeableReference();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public InventoryReportInventoryListingItemComponent copy() {
        InventoryReportInventoryListingItemComponent dst = new InventoryReportInventoryListingItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryReportInventoryListingItemComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryReportInventoryListingItemComponent))
          return false;
        InventoryReportInventoryListingItemComponent o = (InventoryReportInventoryListingItemComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(quantity, o.quantity, true) && compareDeep(item, o.item, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryReportInventoryListingItemComponent))
          return false;
        InventoryReportInventoryListingItemComponent o = (InventoryReportInventoryListingItemComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, quantity, item
          );
      }

  public String fhirType() {
    return "InventoryReport.inventoryListing.item";

  }

  }

    /**
     * Business identifier for the InventoryReport.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for the report", formalDefinition="Business identifier for the InventoryReport." )
    protected List<Identifier> identifier;

    /**
     * The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | requested | active | entered-in-error", formalDefinition="The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/inventoryreport-status")
    protected Enumeration<InventoryReportStatus> status;

    /**
     * Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).
     */
    @Child(name = "countType", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="snapshot | difference", formalDefinition="Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/inventoryreport-counttype")
    protected Enumeration<InventoryCountType> countType;

    /**
     * What type of operation is being performed - addition or subtraction.
     */
    @Child(name = "operationType", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="addition | subtraction", formalDefinition="What type of operation is being performed - addition or subtraction." )
    protected CodeableConcept operationType;

    /**
     * The reason for this count - regular count, ad-hoc count, new arrivals, etc.
     */
    @Child(name = "operationTypeReason", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The reason for this count - regular count, ad-hoc count, new arrivals, etc", formalDefinition="The reason for this count - regular count, ad-hoc count, new arrivals, etc." )
    protected CodeableConcept operationTypeReason;

    /**
     * When the report has been submitted.
     */
    @Child(name = "reportedDateTime", type = {DateTimeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the report has been submitted", formalDefinition="When the report has been submitted." )
    protected DateTimeType reportedDateTime;

    /**
     * Who submits the report.
     */
    @Child(name = "reporter", type = {Practitioner.class, Patient.class, RelatedPerson.class, Device.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who submits the report", formalDefinition="Who submits the report." )
    protected Reference reporter;

    /**
     * The period the report refers to.
     */
    @Child(name = "reportingPeriod", type = {Period.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The period the report refers to", formalDefinition="The period the report refers to." )
    protected Period reportingPeriod;

    /**
     * An inventory listing section (grouped by any of the attributes).
     */
    @Child(name = "inventoryListing", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An inventory listing section (grouped by any of the attributes)", formalDefinition="An inventory listing section (grouped by any of the attributes)." )
    protected List<InventoryReportInventoryListingComponent> inventoryListing;

    /**
     * A note associated with the InventoryReport.
     */
    @Child(name = "note", type = {Annotation.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A note associated with the InventoryReport", formalDefinition="A note associated with the InventoryReport." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 539262671L;

  /**
   * Constructor
   */
    public InventoryReport() {
      super();
    }

  /**
   * Constructor
   */
    public InventoryReport(InventoryReportStatus status, InventoryCountType countType, Date reportedDateTime) {
      super();
      this.setStatus(status);
      this.setCountType(countType);
      this.setReportedDateTime(reportedDateTime);
    }

    /**
     * @return {@link #identifier} (Business identifier for the InventoryReport.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryReport setIdentifier(List<Identifier> theIdentifier) { 
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

    public InventoryReport addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<InventoryReportStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<InventoryReportStatus>(new InventoryReportStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public InventoryReport setStatusElement(Enumeration<InventoryReportStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.
     */
    public InventoryReportStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.
     */
    public InventoryReport setStatus(InventoryReportStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<InventoryReportStatus>(new InventoryReportStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #countType} (Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).). This is the underlying object with id, value and extensions. The accessor "getCountType" gives direct access to the value
     */
    public Enumeration<InventoryCountType> getCountTypeElement() { 
      if (this.countType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.countType");
        else if (Configuration.doAutoCreate())
          this.countType = new Enumeration<InventoryCountType>(new InventoryCountTypeEnumFactory()); // bb
      return this.countType;
    }

    public boolean hasCountTypeElement() { 
      return this.countType != null && !this.countType.isEmpty();
    }

    public boolean hasCountType() { 
      return this.countType != null && !this.countType.isEmpty();
    }

    /**
     * @param value {@link #countType} (Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).). This is the underlying object with id, value and extensions. The accessor "getCountType" gives direct access to the value
     */
    public InventoryReport setCountTypeElement(Enumeration<InventoryCountType> value) { 
      this.countType = value;
      return this;
    }

    /**
     * @return Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).
     */
    public InventoryCountType getCountType() { 
      return this.countType == null ? null : this.countType.getValue();
    }

    /**
     * @param value Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).
     */
    public InventoryReport setCountType(InventoryCountType value) { 
        if (this.countType == null)
          this.countType = new Enumeration<InventoryCountType>(new InventoryCountTypeEnumFactory());
        this.countType.setValue(value);
      return this;
    }

    /**
     * @return {@link #operationType} (What type of operation is being performed - addition or subtraction.)
     */
    public CodeableConcept getOperationType() { 
      if (this.operationType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.operationType");
        else if (Configuration.doAutoCreate())
          this.operationType = new CodeableConcept(); // cc
      return this.operationType;
    }

    public boolean hasOperationType() { 
      return this.operationType != null && !this.operationType.isEmpty();
    }

    /**
     * @param value {@link #operationType} (What type of operation is being performed - addition or subtraction.)
     */
    public InventoryReport setOperationType(CodeableConcept value) { 
      this.operationType = value;
      return this;
    }

    /**
     * @return {@link #operationTypeReason} (The reason for this count - regular count, ad-hoc count, new arrivals, etc.)
     */
    public CodeableConcept getOperationTypeReason() { 
      if (this.operationTypeReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.operationTypeReason");
        else if (Configuration.doAutoCreate())
          this.operationTypeReason = new CodeableConcept(); // cc
      return this.operationTypeReason;
    }

    public boolean hasOperationTypeReason() { 
      return this.operationTypeReason != null && !this.operationTypeReason.isEmpty();
    }

    /**
     * @param value {@link #operationTypeReason} (The reason for this count - regular count, ad-hoc count, new arrivals, etc.)
     */
    public InventoryReport setOperationTypeReason(CodeableConcept value) { 
      this.operationTypeReason = value;
      return this;
    }

    /**
     * @return {@link #reportedDateTime} (When the report has been submitted.). This is the underlying object with id, value and extensions. The accessor "getReportedDateTime" gives direct access to the value
     */
    public DateTimeType getReportedDateTimeElement() { 
      if (this.reportedDateTime == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.reportedDateTime");
        else if (Configuration.doAutoCreate())
          this.reportedDateTime = new DateTimeType(); // bb
      return this.reportedDateTime;
    }

    public boolean hasReportedDateTimeElement() { 
      return this.reportedDateTime != null && !this.reportedDateTime.isEmpty();
    }

    public boolean hasReportedDateTime() { 
      return this.reportedDateTime != null && !this.reportedDateTime.isEmpty();
    }

    /**
     * @param value {@link #reportedDateTime} (When the report has been submitted.). This is the underlying object with id, value and extensions. The accessor "getReportedDateTime" gives direct access to the value
     */
    public InventoryReport setReportedDateTimeElement(DateTimeType value) { 
      this.reportedDateTime = value;
      return this;
    }

    /**
     * @return When the report has been submitted.
     */
    public Date getReportedDateTime() { 
      return this.reportedDateTime == null ? null : this.reportedDateTime.getValue();
    }

    /**
     * @param value When the report has been submitted.
     */
    public InventoryReport setReportedDateTime(Date value) { 
        if (this.reportedDateTime == null)
          this.reportedDateTime = new DateTimeType();
        this.reportedDateTime.setValue(value);
      return this;
    }

    /**
     * @return {@link #reporter} (Who submits the report.)
     */
    public Reference getReporter() { 
      if (this.reporter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.reporter");
        else if (Configuration.doAutoCreate())
          this.reporter = new Reference(); // cc
      return this.reporter;
    }

    public boolean hasReporter() { 
      return this.reporter != null && !this.reporter.isEmpty();
    }

    /**
     * @param value {@link #reporter} (Who submits the report.)
     */
    public InventoryReport setReporter(Reference value) { 
      this.reporter = value;
      return this;
    }

    /**
     * @return {@link #reportingPeriod} (The period the report refers to.)
     */
    public Period getReportingPeriod() { 
      if (this.reportingPeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create InventoryReport.reportingPeriod");
        else if (Configuration.doAutoCreate())
          this.reportingPeriod = new Period(); // cc
      return this.reportingPeriod;
    }

    public boolean hasReportingPeriod() { 
      return this.reportingPeriod != null && !this.reportingPeriod.isEmpty();
    }

    /**
     * @param value {@link #reportingPeriod} (The period the report refers to.)
     */
    public InventoryReport setReportingPeriod(Period value) { 
      this.reportingPeriod = value;
      return this;
    }

    /**
     * @return {@link #inventoryListing} (An inventory listing section (grouped by any of the attributes).)
     */
    public List<InventoryReportInventoryListingComponent> getInventoryListing() { 
      if (this.inventoryListing == null)
        this.inventoryListing = new ArrayList<InventoryReportInventoryListingComponent>();
      return this.inventoryListing;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryReport setInventoryListing(List<InventoryReportInventoryListingComponent> theInventoryListing) { 
      this.inventoryListing = theInventoryListing;
      return this;
    }

    public boolean hasInventoryListing() { 
      if (this.inventoryListing == null)
        return false;
      for (InventoryReportInventoryListingComponent item : this.inventoryListing)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InventoryReportInventoryListingComponent addInventoryListing() { //3
      InventoryReportInventoryListingComponent t = new InventoryReportInventoryListingComponent();
      if (this.inventoryListing == null)
        this.inventoryListing = new ArrayList<InventoryReportInventoryListingComponent>();
      this.inventoryListing.add(t);
      return t;
    }

    public InventoryReport addInventoryListing(InventoryReportInventoryListingComponent t) { //3
      if (t == null)
        return this;
      if (this.inventoryListing == null)
        this.inventoryListing = new ArrayList<InventoryReportInventoryListingComponent>();
      this.inventoryListing.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #inventoryListing}, creating it if it does not already exist {3}
     */
    public InventoryReportInventoryListingComponent getInventoryListingFirstRep() { 
      if (getInventoryListing().isEmpty()) {
        addInventoryListing();
      }
      return getInventoryListing().get(0);
    }

    /**
     * @return {@link #note} (A note associated with the InventoryReport.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public InventoryReport setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public InventoryReport addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for the InventoryReport.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.", 0, 1, status));
        children.add(new Property("countType", "code", "Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).", 0, 1, countType));
        children.add(new Property("operationType", "CodeableConcept", "What type of operation is being performed - addition or subtraction.", 0, 1, operationType));
        children.add(new Property("operationTypeReason", "CodeableConcept", "The reason for this count - regular count, ad-hoc count, new arrivals, etc.", 0, 1, operationTypeReason));
        children.add(new Property("reportedDateTime", "dateTime", "When the report has been submitted.", 0, 1, reportedDateTime));
        children.add(new Property("reporter", "Reference(Practitioner|Patient|RelatedPerson|Device)", "Who submits the report.", 0, 1, reporter));
        children.add(new Property("reportingPeriod", "Period", "The period the report refers to.", 0, 1, reportingPeriod));
        children.add(new Property("inventoryListing", "", "An inventory listing section (grouped by any of the attributes).", 0, java.lang.Integer.MAX_VALUE, inventoryListing));
        children.add(new Property("note", "Annotation", "A note associated with the InventoryReport.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for the InventoryReport.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the inventory check or notification - whether this is draft (e.g. the report is still pending some updates) or active.", 0, 1, status);
        case 1351759081: /*countType*/  return new Property("countType", "code", "Whether the report is about the current inventory count (snapshot) or a differential change in inventory (change).", 0, 1, countType);
        case 91999553: /*operationType*/  return new Property("operationType", "CodeableConcept", "What type of operation is being performed - addition or subtraction.", 0, 1, operationType);
        case 449681125: /*operationTypeReason*/  return new Property("operationTypeReason", "CodeableConcept", "The reason for this count - regular count, ad-hoc count, new arrivals, etc.", 0, 1, operationTypeReason);
        case -1048250994: /*reportedDateTime*/  return new Property("reportedDateTime", "dateTime", "When the report has been submitted.", 0, 1, reportedDateTime);
        case -427039519: /*reporter*/  return new Property("reporter", "Reference(Practitioner|Patient|RelatedPerson|Device)", "Who submits the report.", 0, 1, reporter);
        case 409685391: /*reportingPeriod*/  return new Property("reportingPeriod", "Period", "The period the report refers to.", 0, 1, reportingPeriod);
        case -1764804216: /*inventoryListing*/  return new Property("inventoryListing", "", "An inventory listing section (grouped by any of the attributes).", 0, java.lang.Integer.MAX_VALUE, inventoryListing);
        case 3387378: /*note*/  return new Property("note", "Annotation", "A note associated with the InventoryReport.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<InventoryReportStatus>
        case 1351759081: /*countType*/ return this.countType == null ? new Base[0] : new Base[] {this.countType}; // Enumeration<InventoryCountType>
        case 91999553: /*operationType*/ return this.operationType == null ? new Base[0] : new Base[] {this.operationType}; // CodeableConcept
        case 449681125: /*operationTypeReason*/ return this.operationTypeReason == null ? new Base[0] : new Base[] {this.operationTypeReason}; // CodeableConcept
        case -1048250994: /*reportedDateTime*/ return this.reportedDateTime == null ? new Base[0] : new Base[] {this.reportedDateTime}; // DateTimeType
        case -427039519: /*reporter*/ return this.reporter == null ? new Base[0] : new Base[] {this.reporter}; // Reference
        case 409685391: /*reportingPeriod*/ return this.reportingPeriod == null ? new Base[0] : new Base[] {this.reportingPeriod}; // Period
        case -1764804216: /*inventoryListing*/ return this.inventoryListing == null ? new Base[0] : this.inventoryListing.toArray(new Base[this.inventoryListing.size()]); // InventoryReportInventoryListingComponent
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new InventoryReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InventoryReportStatus>
          return value;
        case 1351759081: // countType
          value = new InventoryCountTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.countType = (Enumeration) value; // Enumeration<InventoryCountType>
          return value;
        case 91999553: // operationType
          this.operationType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 449681125: // operationTypeReason
          this.operationTypeReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1048250994: // reportedDateTime
          this.reportedDateTime = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -427039519: // reporter
          this.reporter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 409685391: // reportingPeriod
          this.reportingPeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -1764804216: // inventoryListing
          this.getInventoryListing().add((InventoryReportInventoryListingComponent) value); // InventoryReportInventoryListingComponent
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new InventoryReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InventoryReportStatus>
        } else if (name.equals("countType")) {
          value = new InventoryCountTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.countType = (Enumeration) value; // Enumeration<InventoryCountType>
        } else if (name.equals("operationType")) {
          this.operationType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("operationTypeReason")) {
          this.operationTypeReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reportedDateTime")) {
          this.reportedDateTime = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("reporter")) {
          this.reporter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reportingPeriod")) {
          this.reportingPeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("inventoryListing")) {
          this.getInventoryListing().add((InventoryReportInventoryListingComponent) value);
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new InventoryReportStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<InventoryReportStatus>
        } else if (name.equals("countType")) {
          value = new InventoryCountTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.countType = (Enumeration) value; // Enumeration<InventoryCountType>
        } else if (name.equals("operationType")) {
          this.operationType = null;
        } else if (name.equals("operationTypeReason")) {
          this.operationTypeReason = null;
        } else if (name.equals("reportedDateTime")) {
          this.reportedDateTime = null;
        } else if (name.equals("reporter")) {
          this.reporter = null;
        } else if (name.equals("reportingPeriod")) {
          this.reportingPeriod = null;
        } else if (name.equals("inventoryListing")) {
          this.getInventoryListing().add((InventoryReportInventoryListingComponent) value);
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 1351759081:  return getCountTypeElement();
        case 91999553:  return getOperationType();
        case 449681125:  return getOperationTypeReason();
        case -1048250994:  return getReportedDateTimeElement();
        case -427039519:  return getReporter();
        case 409685391:  return getReportingPeriod();
        case -1764804216:  return addInventoryListing(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1351759081: /*countType*/ return new String[] {"code"};
        case 91999553: /*operationType*/ return new String[] {"CodeableConcept"};
        case 449681125: /*operationTypeReason*/ return new String[] {"CodeableConcept"};
        case -1048250994: /*reportedDateTime*/ return new String[] {"dateTime"};
        case -427039519: /*reporter*/ return new String[] {"Reference"};
        case 409685391: /*reportingPeriod*/ return new String[] {"Period"};
        case -1764804216: /*inventoryListing*/ return new String[] {};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property InventoryReport.status");
        }
        else if (name.equals("countType")) {
          throw new FHIRException("Cannot call addChild on a singleton property InventoryReport.countType");
        }
        else if (name.equals("operationType")) {
          this.operationType = new CodeableConcept();
          return this.operationType;
        }
        else if (name.equals("operationTypeReason")) {
          this.operationTypeReason = new CodeableConcept();
          return this.operationTypeReason;
        }
        else if (name.equals("reportedDateTime")) {
          throw new FHIRException("Cannot call addChild on a singleton property InventoryReport.reportedDateTime");
        }
        else if (name.equals("reporter")) {
          this.reporter = new Reference();
          return this.reporter;
        }
        else if (name.equals("reportingPeriod")) {
          this.reportingPeriod = new Period();
          return this.reportingPeriod;
        }
        else if (name.equals("inventoryListing")) {
          return addInventoryListing();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "InventoryReport";

  }

      public InventoryReport copy() {
        InventoryReport dst = new InventoryReport();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InventoryReport dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.countType = countType == null ? null : countType.copy();
        dst.operationType = operationType == null ? null : operationType.copy();
        dst.operationTypeReason = operationTypeReason == null ? null : operationTypeReason.copy();
        dst.reportedDateTime = reportedDateTime == null ? null : reportedDateTime.copy();
        dst.reporter = reporter == null ? null : reporter.copy();
        dst.reportingPeriod = reportingPeriod == null ? null : reportingPeriod.copy();
        if (inventoryListing != null) {
          dst.inventoryListing = new ArrayList<InventoryReportInventoryListingComponent>();
          for (InventoryReportInventoryListingComponent i : inventoryListing)
            dst.inventoryListing.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected InventoryReport typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InventoryReport))
          return false;
        InventoryReport o = (InventoryReport) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(countType, o.countType, true)
           && compareDeep(operationType, o.operationType, true) && compareDeep(operationTypeReason, o.operationTypeReason, true)
           && compareDeep(reportedDateTime, o.reportedDateTime, true) && compareDeep(reporter, o.reporter, true)
           && compareDeep(reportingPeriod, o.reportingPeriod, true) && compareDeep(inventoryListing, o.inventoryListing, true)
           && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InventoryReport))
          return false;
        InventoryReport o = (InventoryReport) other_;
        return compareValues(status, o.status, true) && compareValues(countType, o.countType, true) && compareValues(reportedDateTime, o.reportedDateTime, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, countType
          , operationType, operationTypeReason, reportedDateTime, reporter, reportingPeriod
          , inventoryListing, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.InventoryReport;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Search by identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryReport.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="InventoryReport.identifier", description="Search by identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Search by identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryReport.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>item-reference</b>
   * <p>
   * Description: <b>Search by items in inventory report</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>InventoryReport.inventoryListing.item.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="item-reference", path="InventoryReport.inventoryListing.item.item.reference", description="Search by items in inventory report", type="reference", target={BiologicallyDerivedProduct.class, Device.class, InventoryItem.class, Medication.class, NutritionProduct.class } )
  public static final String SP_ITEM_REFERENCE = "item-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>item-reference</b>
   * <p>
   * Description: <b>Search by items in inventory report</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>InventoryReport.inventoryListing.item.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ITEM_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ITEM_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>InventoryReport:item-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ITEM_REFERENCE = new ca.uhn.fhir.model.api.Include("InventoryReport:item-reference").toLocked();

 /**
   * Search parameter: <b>item</b>
   * <p>
   * Description: <b>Search by items in inventory report</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryReport.inventoryListing.item.item.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="item", path="InventoryReport.inventoryListing.item.item.concept", description="Search by items in inventory report", type="token" )
  public static final String SP_ITEM = "item";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>item</b>
   * <p>
   * Description: <b>Search by items in inventory report</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryReport.inventoryListing.item.item.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ITEM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ITEM);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Search by status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryReport.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="InventoryReport.status", description="Search by status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Search by status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>InventoryReport.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

