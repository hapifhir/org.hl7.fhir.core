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
import java.math.*;
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
 * Details and position information for a place where services are provided and resources and participants may be stored, found, contained, or accommodated.
 */
@ResourceDef(name="Location", profile="http://hl7.org/fhir/StructureDefinition/Location")
public class Location extends DomainResource {

    public enum LocationMode {
        /**
         * The Location resource represents a specific instance of a location (e.g. Operating Theatre 1A).
         */
        INSTANCE, 
        /**
         * The Location represents a class of locations (e.g. Any Operating Theatre) although this class of locations could be constrained within a specific boundary (such as organization, or parent location, address etc.).
         */
        KIND, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static LocationMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return INSTANCE;
        if ("kind".equals(codeString))
          return KIND;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown LocationMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INSTANCE: return "instance";
            case KIND: return "kind";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INSTANCE: return "http://hl7.org/fhir/location-mode";
            case KIND: return "http://hl7.org/fhir/location-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INSTANCE: return "The Location resource represents a specific instance of a location (e.g. Operating Theatre 1A).";
            case KIND: return "The Location represents a class of locations (e.g. Any Operating Theatre) although this class of locations could be constrained within a specific boundary (such as organization, or parent location, address etc.).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INSTANCE: return "Instance";
            case KIND: return "Kind";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class LocationModeEnumFactory implements EnumFactory<LocationMode> {
    public LocationMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return LocationMode.INSTANCE;
        if ("kind".equals(codeString))
          return LocationMode.KIND;
        throw new IllegalArgumentException("Unknown LocationMode code '"+codeString+"'");
        }
        public Enumeration<LocationMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<LocationMode>(this, LocationMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<LocationMode>(this, LocationMode.NULL, code);
        if ("instance".equals(codeString))
          return new Enumeration<LocationMode>(this, LocationMode.INSTANCE, code);
        if ("kind".equals(codeString))
          return new Enumeration<LocationMode>(this, LocationMode.KIND, code);
        throw new FHIRException("Unknown LocationMode code '"+codeString+"'");
        }
    public String toCode(LocationMode code) {
      if (code == LocationMode.INSTANCE)
        return "instance";
      if (code == LocationMode.KIND)
        return "kind";
      return "?";
      }
    public String toSystem(LocationMode code) {
      return code.getSystem();
      }
    }

    public enum LocationStatus {
        /**
         * The location is operational.
         */
        ACTIVE, 
        /**
         * The location is temporarily closed.
         */
        SUSPENDED, 
        /**
         * The location is no longer used.
         */
        INACTIVE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static LocationStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("suspended".equals(codeString))
          return SUSPENDED;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown LocationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case SUSPENDED: return "suspended";
            case INACTIVE: return "inactive";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/location-status";
            case SUSPENDED: return "http://hl7.org/fhir/location-status";
            case INACTIVE: return "http://hl7.org/fhir/location-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The location is operational.";
            case SUSPENDED: return "The location is temporarily closed.";
            case INACTIVE: return "The location is no longer used.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case SUSPENDED: return "Suspended";
            case INACTIVE: return "Inactive";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class LocationStatusEnumFactory implements EnumFactory<LocationStatus> {
    public LocationStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return LocationStatus.ACTIVE;
        if ("suspended".equals(codeString))
          return LocationStatus.SUSPENDED;
        if ("inactive".equals(codeString))
          return LocationStatus.INACTIVE;
        throw new IllegalArgumentException("Unknown LocationStatus code '"+codeString+"'");
        }
        public Enumeration<LocationStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<LocationStatus>(this, LocationStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<LocationStatus>(this, LocationStatus.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<LocationStatus>(this, LocationStatus.ACTIVE, code);
        if ("suspended".equals(codeString))
          return new Enumeration<LocationStatus>(this, LocationStatus.SUSPENDED, code);
        if ("inactive".equals(codeString))
          return new Enumeration<LocationStatus>(this, LocationStatus.INACTIVE, code);
        throw new FHIRException("Unknown LocationStatus code '"+codeString+"'");
        }
    public String toCode(LocationStatus code) {
      if (code == LocationStatus.ACTIVE)
        return "active";
      if (code == LocationStatus.SUSPENDED)
        return "suspended";
      if (code == LocationStatus.INACTIVE)
        return "inactive";
      return "?";
      }
    public String toSystem(LocationStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class LocationPositionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).
         */
        @Child(name = "longitude", type = {DecimalType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Longitude with WGS84 datum", formalDefinition="Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page)." )
        protected DecimalType longitude;

        /**
         * Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).
         */
        @Child(name = "latitude", type = {DecimalType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Latitude with WGS84 datum", formalDefinition="Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page)." )
        protected DecimalType latitude;

        /**
         * Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).
         */
        @Child(name = "altitude", type = {DecimalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Altitude with WGS84 datum", formalDefinition="Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page)." )
        protected DecimalType altitude;

        private static final long serialVersionUID = -74276134L;

    /**
     * Constructor
     */
      public LocationPositionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public LocationPositionComponent(BigDecimal longitude, BigDecimal latitude) {
        super();
        this.setLongitude(longitude);
        this.setLatitude(latitude);
      }

        /**
         * @return {@link #longitude} (Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).). This is the underlying object with id, value and extensions. The accessor "getLongitude" gives direct access to the value
         */
        public DecimalType getLongitudeElement() { 
          if (this.longitude == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create LocationPositionComponent.longitude");
            else if (Configuration.doAutoCreate())
              this.longitude = new DecimalType(); // bb
          return this.longitude;
        }

        public boolean hasLongitudeElement() { 
          return this.longitude != null && !this.longitude.isEmpty();
        }

        public boolean hasLongitude() { 
          return this.longitude != null && !this.longitude.isEmpty();
        }

        /**
         * @param value {@link #longitude} (Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).). This is the underlying object with id, value and extensions. The accessor "getLongitude" gives direct access to the value
         */
        public LocationPositionComponent setLongitudeElement(DecimalType value) { 
          this.longitude = value;
          return this;
        }

        /**
         * @return Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).
         */
        public BigDecimal getLongitude() { 
          return this.longitude == null ? null : this.longitude.getValue();
        }

        /**
         * @param value Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setLongitude(BigDecimal value) { 
            if (this.longitude == null)
              this.longitude = new DecimalType();
            this.longitude.setValue(value);
          return this;
        }

        /**
         * @param value Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setLongitude(long value) { 
              this.longitude = new DecimalType();
            this.longitude.setValue(value);
          return this;
        }

        /**
         * @param value Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setLongitude(double value) { 
              this.longitude = new DecimalType();
            this.longitude.setValue(value);
          return this;
        }

        /**
         * @return {@link #latitude} (Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).). This is the underlying object with id, value and extensions. The accessor "getLatitude" gives direct access to the value
         */
        public DecimalType getLatitudeElement() { 
          if (this.latitude == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create LocationPositionComponent.latitude");
            else if (Configuration.doAutoCreate())
              this.latitude = new DecimalType(); // bb
          return this.latitude;
        }

        public boolean hasLatitudeElement() { 
          return this.latitude != null && !this.latitude.isEmpty();
        }

        public boolean hasLatitude() { 
          return this.latitude != null && !this.latitude.isEmpty();
        }

        /**
         * @param value {@link #latitude} (Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).). This is the underlying object with id, value and extensions. The accessor "getLatitude" gives direct access to the value
         */
        public LocationPositionComponent setLatitudeElement(DecimalType value) { 
          this.latitude = value;
          return this;
        }

        /**
         * @return Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).
         */
        public BigDecimal getLatitude() { 
          return this.latitude == null ? null : this.latitude.getValue();
        }

        /**
         * @param value Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setLatitude(BigDecimal value) { 
            if (this.latitude == null)
              this.latitude = new DecimalType();
            this.latitude.setValue(value);
          return this;
        }

        /**
         * @param value Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setLatitude(long value) { 
              this.latitude = new DecimalType();
            this.latitude.setValue(value);
          return this;
        }

        /**
         * @param value Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setLatitude(double value) { 
              this.latitude = new DecimalType();
            this.latitude.setValue(value);
          return this;
        }

        /**
         * @return {@link #altitude} (Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).). This is the underlying object with id, value and extensions. The accessor "getAltitude" gives direct access to the value
         */
        public DecimalType getAltitudeElement() { 
          if (this.altitude == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create LocationPositionComponent.altitude");
            else if (Configuration.doAutoCreate())
              this.altitude = new DecimalType(); // bb
          return this.altitude;
        }

        public boolean hasAltitudeElement() { 
          return this.altitude != null && !this.altitude.isEmpty();
        }

        public boolean hasAltitude() { 
          return this.altitude != null && !this.altitude.isEmpty();
        }

        /**
         * @param value {@link #altitude} (Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).). This is the underlying object with id, value and extensions. The accessor "getAltitude" gives direct access to the value
         */
        public LocationPositionComponent setAltitudeElement(DecimalType value) { 
          this.altitude = value;
          return this;
        }

        /**
         * @return Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).
         */
        public BigDecimal getAltitude() { 
          return this.altitude == null ? null : this.altitude.getValue();
        }

        /**
         * @param value Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setAltitude(BigDecimal value) { 
          if (value == null)
            this.altitude = null;
          else {
            if (this.altitude == null)
              this.altitude = new DecimalType();
            this.altitude.setValue(value);
          }
          return this;
        }

        /**
         * @param value Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setAltitude(long value) { 
              this.altitude = new DecimalType();
            this.altitude.setValue(value);
          return this;
        }

        /**
         * @param value Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).
         */
        public LocationPositionComponent setAltitude(double value) { 
              this.altitude = new DecimalType();
            this.altitude.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("longitude", "decimal", "Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).", 0, 1, longitude));
          children.add(new Property("latitude", "decimal", "Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).", 0, 1, latitude));
          children.add(new Property("altitude", "decimal", "Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).", 0, 1, altitude));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 137365935: /*longitude*/  return new Property("longitude", "decimal", "Longitude. The value domain and the interpretation are the same as for the text of the longitude element in KML (see notes on Location main page).", 0, 1, longitude);
          case -1439978388: /*latitude*/  return new Property("latitude", "decimal", "Latitude. The value domain and the interpretation are the same as for the text of the latitude element in KML (see notes on Location main page).", 0, 1, latitude);
          case 2036550306: /*altitude*/  return new Property("altitude", "decimal", "Altitude. The value domain and the interpretation are the same as for the text of the altitude element in KML (see notes on Location main page).", 0, 1, altitude);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 137365935: /*longitude*/ return this.longitude == null ? new Base[0] : new Base[] {this.longitude}; // DecimalType
        case -1439978388: /*latitude*/ return this.latitude == null ? new Base[0] : new Base[] {this.latitude}; // DecimalType
        case 2036550306: /*altitude*/ return this.altitude == null ? new Base[0] : new Base[] {this.altitude}; // DecimalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 137365935: // longitude
          this.longitude = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1439978388: // latitude
          this.latitude = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 2036550306: // altitude
          this.altitude = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("longitude")) {
          this.longitude = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("latitude")) {
          this.latitude = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("altitude")) {
          this.altitude = TypeConvertor.castToDecimal(value); // DecimalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 137365935:  return getLongitudeElement();
        case -1439978388:  return getLatitudeElement();
        case 2036550306:  return getAltitudeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 137365935: /*longitude*/ return new String[] {"decimal"};
        case -1439978388: /*latitude*/ return new String[] {"decimal"};
        case 2036550306: /*altitude*/ return new String[] {"decimal"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("longitude")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.position.longitude");
        }
        else if (name.equals("latitude")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.position.latitude");
        }
        else if (name.equals("altitude")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.position.altitude");
        }
        else
          return super.addChild(name);
      }

      public LocationPositionComponent copy() {
        LocationPositionComponent dst = new LocationPositionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(LocationPositionComponent dst) {
        super.copyValues(dst);
        dst.longitude = longitude == null ? null : longitude.copy();
        dst.latitude = latitude == null ? null : latitude.copy();
        dst.altitude = altitude == null ? null : altitude.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof LocationPositionComponent))
          return false;
        LocationPositionComponent o = (LocationPositionComponent) other_;
        return compareDeep(longitude, o.longitude, true) && compareDeep(latitude, o.latitude, true) && compareDeep(altitude, o.altitude, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof LocationPositionComponent))
          return false;
        LocationPositionComponent o = (LocationPositionComponent) other_;
        return compareValues(longitude, o.longitude, true) && compareValues(latitude, o.latitude, true) && compareValues(altitude, o.altitude, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(longitude, latitude, altitude
          );
      }

  public String fhirType() {
    return "Location.position";

  }

  }

    /**
     * Unique code or number identifying the location to its users.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique code or number identifying the location to its users", formalDefinition="Unique code or number identifying the location to its users." )
    protected List<Identifier> identifier;

    /**
     * The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | suspended | inactive", formalDefinition="The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/location-status")
    protected Enumeration<LocationStatus> status;

    /**
     * The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and other activities like maintenance.
     */
    @Child(name = "operationalStatus", type = {Coding.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The operational status of the location (typically only for a bed/room)", formalDefinition="The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and other activities like maintenance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0116")
    protected Coding operationalStatus;

    /**
     * Name of the location as used by humans. Does not need to be unique.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the location as used by humans", formalDefinition="Name of the location as used by humans. Does not need to be unique." )
    protected StringType name;

    /**
     * A list of alternate names that the location is known as, or was known as, in the past.
     */
    @Child(name = "alias", type = {StringType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A list of alternate names that the location is known as, or was known as, in the past", formalDefinition="A list of alternate names that the location is known as, or was known as, in the past." )
    protected List<StringType> alias;

    /**
     * Description of the Location, which helps in finding or referencing the place.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Additional details about the location that could be displayed as further information to identify the location beyond its name", formalDefinition="Description of the Location, which helps in finding or referencing the place." )
    protected MarkdownType description;

    /**
     * Indicates whether a resource instance represents a specific location or a class of locations.
     */
    @Child(name = "mode", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="instance | kind", formalDefinition="Indicates whether a resource instance represents a specific location or a class of locations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/location-mode")
    protected Enumeration<LocationMode> mode;

    /**
     * Indicates the type of function performed at the location.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of function performed", formalDefinition="Indicates the type of function performed at the location." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ServiceDeliveryLocationRoleType")
    protected List<CodeableConcept> type;

    /**
     * The contact details of communication devices available at the location. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.
     */
    @Child(name = "contact", type = {ExtendedContactDetail.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Official contact details for the location", formalDefinition="The contact details of communication devices available at the location. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites." )
    protected List<ExtendedContactDetail> contact;

    /**
     * Physical location.
     */
    @Child(name = "address", type = {Address.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Physical location", formalDefinition="Physical location." )
    protected Address address;

    /**
     * Physical form of the location, e.g. building, room, vehicle, road, virtual.
     */
    @Child(name = "form", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Physical form of the location", formalDefinition="Physical form of the location, e.g. building, room, vehicle, road, virtual." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/location-form")
    protected CodeableConcept form;

    /**
     * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system used in KML).
     */
    @Child(name = "position", type = {}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The absolute geographic location", formalDefinition="The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system used in KML)." )
    protected LocationPositionComponent position;

    /**
     * The organization responsible for the provisioning and upkeep of the location.
     */
    @Child(name = "managingOrganization", type = {Organization.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization responsible for provisioning and upkeep", formalDefinition="The organization responsible for the provisioning and upkeep of the location." )
    protected Reference managingOrganization;

    /**
     * Another Location of which this Location is physically a part of.
     */
    @Child(name = "partOf", type = {Location.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Another Location this one is physically a part of", formalDefinition="Another Location of which this Location is physically a part of." )
    protected Reference partOf;

    /**
     * Collection of characteristics (attributes).
     */
    @Child(name = "characteristic", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Collection of characteristics (attributes)", formalDefinition="Collection of characteristics (attributes)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/location-characteristic")
    protected List<CodeableConcept> characteristic;

    /**
     * What days/times during a week is this location usually open, and any exceptions where the location is not available.
     */
    @Child(name = "hoursOfOperation", type = {Availability.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What days/times during a week is this location usually open (including exceptions)", formalDefinition="What days/times during a week is this location usually open, and any exceptions where the location is not available." )
    protected List<Availability> hoursOfOperation;

    /**
     * Connection details of a virtual service (e.g. shared conference call facility with dedicated number/details).
     */
    @Child(name = "virtualService", type = {VirtualServiceDetail.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Connection details of a virtual service (e.g. conference call)", formalDefinition="Connection details of a virtual service (e.g. shared conference call facility with dedicated number/details)." )
    protected List<VirtualServiceDetail> virtualService;

    /**
     * Technical endpoints providing access to services operated for the location.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Technical endpoints providing access to services operated for the location", formalDefinition="Technical endpoints providing access to services operated for the location." )
    protected List<Reference> endpoint;

    private static final long serialVersionUID = 1238993068L;

  /**
   * Constructor
   */
    public Location() {
      super();
    }

    /**
     * @return {@link #identifier} (Unique code or number identifying the location to its users.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setIdentifier(List<Identifier> theIdentifier) { 
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

    public Location addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<LocationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<LocationStatus>(new LocationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Location setStatusElement(Enumeration<LocationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.
     */
    public LocationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.
     */
    public Location setStatus(LocationStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<LocationStatus>(new LocationStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #operationalStatus} (The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and other activities like maintenance.)
     */
    public Coding getOperationalStatus() { 
      if (this.operationalStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.operationalStatus");
        else if (Configuration.doAutoCreate())
          this.operationalStatus = new Coding(); // cc
      return this.operationalStatus;
    }

    public boolean hasOperationalStatus() { 
      return this.operationalStatus != null && !this.operationalStatus.isEmpty();
    }

    /**
     * @param value {@link #operationalStatus} (The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and other activities like maintenance.)
     */
    public Location setOperationalStatus(Coding value) { 
      this.operationalStatus = value;
      return this;
    }

    /**
     * @return {@link #name} (Name of the location as used by humans. Does not need to be unique.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.name");
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
     * @param value {@link #name} (Name of the location as used by humans. Does not need to be unique.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Location setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return Name of the location as used by humans. Does not need to be unique.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value Name of the location as used by humans. Does not need to be unique.
     */
    public Location setName(String value) { 
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
     * @return {@link #alias} (A list of alternate names that the location is known as, or was known as, in the past.)
     */
    public List<StringType> getAlias() { 
      if (this.alias == null)
        this.alias = new ArrayList<StringType>();
      return this.alias;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setAlias(List<StringType> theAlias) { 
      this.alias = theAlias;
      return this;
    }

    public boolean hasAlias() { 
      if (this.alias == null)
        return false;
      for (StringType item : this.alias)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #alias} (A list of alternate names that the location is known as, or was known as, in the past.)
     */
    public StringType addAliasElement() {//2 
      StringType t = new StringType();
      if (this.alias == null)
        this.alias = new ArrayList<StringType>();
      this.alias.add(t);
      return t;
    }

    /**
     * @param value {@link #alias} (A list of alternate names that the location is known as, or was known as, in the past.)
     */
    public Location addAlias(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.alias == null)
        this.alias = new ArrayList<StringType>();
      this.alias.add(t);
      return this;
    }

    /**
     * @param value {@link #alias} (A list of alternate names that the location is known as, or was known as, in the past.)
     */
    public boolean hasAlias(String value) { 
      if (this.alias == null)
        return false;
      for (StringType v : this.alias)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #description} (Description of the Location, which helps in finding or referencing the place.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.description");
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
     * @param value {@link #description} (Description of the Location, which helps in finding or referencing the place.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Location setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Description of the Location, which helps in finding or referencing the place.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Description of the Location, which helps in finding or referencing the place.
     */
    public Location setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #mode} (Indicates whether a resource instance represents a specific location or a class of locations.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
     */
    public Enumeration<LocationMode> getModeElement() { 
      if (this.mode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.mode");
        else if (Configuration.doAutoCreate())
          this.mode = new Enumeration<LocationMode>(new LocationModeEnumFactory()); // bb
      return this.mode;
    }

    public boolean hasModeElement() { 
      return this.mode != null && !this.mode.isEmpty();
    }

    public boolean hasMode() { 
      return this.mode != null && !this.mode.isEmpty();
    }

    /**
     * @param value {@link #mode} (Indicates whether a resource instance represents a specific location or a class of locations.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
     */
    public Location setModeElement(Enumeration<LocationMode> value) { 
      this.mode = value;
      return this;
    }

    /**
     * @return Indicates whether a resource instance represents a specific location or a class of locations.
     */
    public LocationMode getMode() { 
      return this.mode == null ? null : this.mode.getValue();
    }

    /**
     * @param value Indicates whether a resource instance represents a specific location or a class of locations.
     */
    public Location setMode(LocationMode value) { 
      if (value == null)
        this.mode = null;
      else {
        if (this.mode == null)
          this.mode = new Enumeration<LocationMode>(new LocationModeEnumFactory());
        this.mode.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (Indicates the type of function performed at the location.)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setType(List<CodeableConcept> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (CodeableConcept item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return t;
    }

    public Location addType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #contact} (The contact details of communication devices available at the location. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.)
     */
    public List<ExtendedContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setContact(List<ExtendedContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ExtendedContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ExtendedContactDetail addContact() { //3
      ExtendedContactDetail t = new ExtendedContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      this.contact.add(t);
      return t;
    }

    public Location addContact(ExtendedContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ExtendedContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #address} (Physical location.)
     */
    public Address getAddress() { 
      if (this.address == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.address");
        else if (Configuration.doAutoCreate())
          this.address = new Address(); // cc
      return this.address;
    }

    public boolean hasAddress() { 
      return this.address != null && !this.address.isEmpty();
    }

    /**
     * @param value {@link #address} (Physical location.)
     */
    public Location setAddress(Address value) { 
      this.address = value;
      return this;
    }

    /**
     * @return {@link #form} (Physical form of the location, e.g. building, room, vehicle, road, virtual.)
     */
    public CodeableConcept getForm() { 
      if (this.form == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.form");
        else if (Configuration.doAutoCreate())
          this.form = new CodeableConcept(); // cc
      return this.form;
    }

    public boolean hasForm() { 
      return this.form != null && !this.form.isEmpty();
    }

    /**
     * @param value {@link #form} (Physical form of the location, e.g. building, room, vehicle, road, virtual.)
     */
    public Location setForm(CodeableConcept value) { 
      this.form = value;
      return this;
    }

    /**
     * @return {@link #position} (The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system used in KML).)
     */
    public LocationPositionComponent getPosition() { 
      if (this.position == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.position");
        else if (Configuration.doAutoCreate())
          this.position = new LocationPositionComponent(); // cc
      return this.position;
    }

    public boolean hasPosition() { 
      return this.position != null && !this.position.isEmpty();
    }

    /**
     * @param value {@link #position} (The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system used in KML).)
     */
    public Location setPosition(LocationPositionComponent value) { 
      this.position = value;
      return this;
    }

    /**
     * @return {@link #managingOrganization} (The organization responsible for the provisioning and upkeep of the location.)
     */
    public Reference getManagingOrganization() { 
      if (this.managingOrganization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.managingOrganization");
        else if (Configuration.doAutoCreate())
          this.managingOrganization = new Reference(); // cc
      return this.managingOrganization;
    }

    public boolean hasManagingOrganization() { 
      return this.managingOrganization != null && !this.managingOrganization.isEmpty();
    }

    /**
     * @param value {@link #managingOrganization} (The organization responsible for the provisioning and upkeep of the location.)
     */
    public Location setManagingOrganization(Reference value) { 
      this.managingOrganization = value;
      return this;
    }

    /**
     * @return {@link #partOf} (Another Location of which this Location is physically a part of.)
     */
    public Reference getPartOf() { 
      if (this.partOf == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Location.partOf");
        else if (Configuration.doAutoCreate())
          this.partOf = new Reference(); // cc
      return this.partOf;
    }

    public boolean hasPartOf() { 
      return this.partOf != null && !this.partOf.isEmpty();
    }

    /**
     * @param value {@link #partOf} (Another Location of which this Location is physically a part of.)
     */
    public Location setPartOf(Reference value) { 
      this.partOf = value;
      return this;
    }

    /**
     * @return {@link #characteristic} (Collection of characteristics (attributes).)
     */
    public List<CodeableConcept> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setCharacteristic(List<CodeableConcept> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (CodeableConcept item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCharacteristic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      this.characteristic.add(t);
      return t;
    }

    public Location addCharacteristic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #hoursOfOperation} (What days/times during a week is this location usually open, and any exceptions where the location is not available.)
     */
    public List<Availability> getHoursOfOperation() { 
      if (this.hoursOfOperation == null)
        this.hoursOfOperation = new ArrayList<Availability>();
      return this.hoursOfOperation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setHoursOfOperation(List<Availability> theHoursOfOperation) { 
      this.hoursOfOperation = theHoursOfOperation;
      return this;
    }

    public boolean hasHoursOfOperation() { 
      if (this.hoursOfOperation == null)
        return false;
      for (Availability item : this.hoursOfOperation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Availability addHoursOfOperation() { //3
      Availability t = new Availability();
      if (this.hoursOfOperation == null)
        this.hoursOfOperation = new ArrayList<Availability>();
      this.hoursOfOperation.add(t);
      return t;
    }

    public Location addHoursOfOperation(Availability t) { //3
      if (t == null)
        return this;
      if (this.hoursOfOperation == null)
        this.hoursOfOperation = new ArrayList<Availability>();
      this.hoursOfOperation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #hoursOfOperation}, creating it if it does not already exist {3}
     */
    public Availability getHoursOfOperationFirstRep() { 
      if (getHoursOfOperation().isEmpty()) {
        addHoursOfOperation();
      }
      return getHoursOfOperation().get(0);
    }

    /**
     * @return {@link #virtualService} (Connection details of a virtual service (e.g. shared conference call facility with dedicated number/details).)
     */
    public List<VirtualServiceDetail> getVirtualService() { 
      if (this.virtualService == null)
        this.virtualService = new ArrayList<VirtualServiceDetail>();
      return this.virtualService;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setVirtualService(List<VirtualServiceDetail> theVirtualService) { 
      this.virtualService = theVirtualService;
      return this;
    }

    public boolean hasVirtualService() { 
      if (this.virtualService == null)
        return false;
      for (VirtualServiceDetail item : this.virtualService)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public VirtualServiceDetail addVirtualService() { //3
      VirtualServiceDetail t = new VirtualServiceDetail();
      if (this.virtualService == null)
        this.virtualService = new ArrayList<VirtualServiceDetail>();
      this.virtualService.add(t);
      return t;
    }

    public Location addVirtualService(VirtualServiceDetail t) { //3
      if (t == null)
        return this;
      if (this.virtualService == null)
        this.virtualService = new ArrayList<VirtualServiceDetail>();
      this.virtualService.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #virtualService}, creating it if it does not already exist {3}
     */
    public VirtualServiceDetail getVirtualServiceFirstRep() { 
      if (getVirtualService().isEmpty()) {
        addVirtualService();
      }
      return getVirtualService().get(0);
    }

    /**
     * @return {@link #endpoint} (Technical endpoints providing access to services operated for the location.)
     */
    public List<Reference> getEndpoint() { 
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      return this.endpoint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Location setEndpoint(List<Reference> theEndpoint) { 
      this.endpoint = theEndpoint;
      return this;
    }

    public boolean hasEndpoint() { 
      if (this.endpoint == null)
        return false;
      for (Reference item : this.endpoint)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEndpoint() { //3
      Reference t = new Reference();
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return t;
    }

    public Location addEndpoint(Reference t) { //3
      if (t == null)
        return this;
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist {3}
     */
    public Reference getEndpointFirstRep() { 
      if (getEndpoint().isEmpty()) {
        addEndpoint();
      }
      return getEndpoint().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique code or number identifying the location to its users.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.", 0, 1, status));
        children.add(new Property("operationalStatus", "Coding", "The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and other activities like maintenance.", 0, 1, operationalStatus));
        children.add(new Property("name", "string", "Name of the location as used by humans. Does not need to be unique.", 0, 1, name));
        children.add(new Property("alias", "string", "A list of alternate names that the location is known as, or was known as, in the past.", 0, java.lang.Integer.MAX_VALUE, alias));
        children.add(new Property("description", "markdown", "Description of the Location, which helps in finding or referencing the place.", 0, 1, description));
        children.add(new Property("mode", "code", "Indicates whether a resource instance represents a specific location or a class of locations.", 0, 1, mode));
        children.add(new Property("type", "CodeableConcept", "Indicates the type of function performed at the location.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("contact", "ExtendedContactDetail", "The contact details of communication devices available at the location. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("address", "Address", "Physical location.", 0, 1, address));
        children.add(new Property("form", "CodeableConcept", "Physical form of the location, e.g. building, room, vehicle, road, virtual.", 0, 1, form));
        children.add(new Property("position", "", "The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system used in KML).", 0, 1, position));
        children.add(new Property("managingOrganization", "Reference(Organization)", "The organization responsible for the provisioning and upkeep of the location.", 0, 1, managingOrganization));
        children.add(new Property("partOf", "Reference(Location)", "Another Location of which this Location is physically a part of.", 0, 1, partOf));
        children.add(new Property("characteristic", "CodeableConcept", "Collection of characteristics (attributes).", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("hoursOfOperation", "Availability", "What days/times during a week is this location usually open, and any exceptions where the location is not available.", 0, java.lang.Integer.MAX_VALUE, hoursOfOperation));
        children.add(new Property("virtualService", "VirtualServiceDetail", "Connection details of a virtual service (e.g. shared conference call facility with dedicated number/details).", 0, java.lang.Integer.MAX_VALUE, virtualService));
        children.add(new Property("endpoint", "Reference(Endpoint)", "Technical endpoints providing access to services operated for the location.", 0, java.lang.Integer.MAX_VALUE, endpoint));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique code or number identifying the location to its users.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status property covers the general availability of the resource, not the current value which may be covered by the operationStatus, or by a schedule/slots if they are configured for the location.", 0, 1, status);
        case -2103166364: /*operationalStatus*/  return new Property("operationalStatus", "Coding", "The operational status covers operation values most relevant to beds (but can also apply to rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers concepts such as contamination, housekeeping, and other activities like maintenance.", 0, 1, operationalStatus);
        case 3373707: /*name*/  return new Property("name", "string", "Name of the location as used by humans. Does not need to be unique.", 0, 1, name);
        case 92902992: /*alias*/  return new Property("alias", "string", "A list of alternate names that the location is known as, or was known as, in the past.", 0, java.lang.Integer.MAX_VALUE, alias);
        case -1724546052: /*description*/  return new Property("description", "markdown", "Description of the Location, which helps in finding or referencing the place.", 0, 1, description);
        case 3357091: /*mode*/  return new Property("mode", "code", "Indicates whether a resource instance represents a specific location or a class of locations.", 0, 1, mode);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates the type of function performed at the location.", 0, java.lang.Integer.MAX_VALUE, type);
        case 951526432: /*contact*/  return new Property("contact", "ExtendedContactDetail", "The contact details of communication devices available at the location. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1147692044: /*address*/  return new Property("address", "Address", "Physical location.", 0, 1, address);
        case 3148996: /*form*/  return new Property("form", "CodeableConcept", "Physical form of the location, e.g. building, room, vehicle, road, virtual.", 0, 1, form);
        case 747804969: /*position*/  return new Property("position", "", "The absolute geographic location of the Location, expressed using the WGS84 datum (This is the same co-ordinate system used in KML).", 0, 1, position);
        case -2058947787: /*managingOrganization*/  return new Property("managingOrganization", "Reference(Organization)", "The organization responsible for the provisioning and upkeep of the location.", 0, 1, managingOrganization);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Location)", "Another Location of which this Location is physically a part of.", 0, 1, partOf);
        case 366313883: /*characteristic*/  return new Property("characteristic", "CodeableConcept", "Collection of characteristics (attributes).", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case -1588872511: /*hoursOfOperation*/  return new Property("hoursOfOperation", "Availability", "What days/times during a week is this location usually open, and any exceptions where the location is not available.", 0, java.lang.Integer.MAX_VALUE, hoursOfOperation);
        case 1420774698: /*virtualService*/  return new Property("virtualService", "VirtualServiceDetail", "Connection details of a virtual service (e.g. shared conference call facility with dedicated number/details).", 0, java.lang.Integer.MAX_VALUE, virtualService);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "Technical endpoints providing access to services operated for the location.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<LocationStatus>
        case -2103166364: /*operationalStatus*/ return this.operationalStatus == null ? new Base[0] : new Base[] {this.operationalStatus}; // Coding
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 92902992: /*alias*/ return this.alias == null ? new Base[0] : this.alias.toArray(new Base[this.alias.size()]); // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<LocationMode>
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ExtendedContactDetail
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : new Base[] {this.address}; // Address
        case 3148996: /*form*/ return this.form == null ? new Base[0] : new Base[] {this.form}; // CodeableConcept
        case 747804969: /*position*/ return this.position == null ? new Base[0] : new Base[] {this.position}; // LocationPositionComponent
        case -2058947787: /*managingOrganization*/ return this.managingOrganization == null ? new Base[0] : new Base[] {this.managingOrganization}; // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : new Base[] {this.partOf}; // Reference
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // CodeableConcept
        case -1588872511: /*hoursOfOperation*/ return this.hoursOfOperation == null ? new Base[0] : this.hoursOfOperation.toArray(new Base[this.hoursOfOperation.size()]); // Availability
        case 1420774698: /*virtualService*/ return this.virtualService == null ? new Base[0] : this.virtualService.toArray(new Base[this.virtualService.size()]); // VirtualServiceDetail
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
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
          value = new LocationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<LocationStatus>
          return value;
        case -2103166364: // operationalStatus
          this.operationalStatus = TypeConvertor.castToCoding(value); // Coding
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 92902992: // alias
          this.getAlias().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3357091: // mode
          value = new LocationModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<LocationMode>
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToExtendedContactDetail(value)); // ExtendedContactDetail
          return value;
        case -1147692044: // address
          this.address = TypeConvertor.castToAddress(value); // Address
          return value;
        case 3148996: // form
          this.form = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 747804969: // position
          this.position = (LocationPositionComponent) value; // LocationPositionComponent
          return value;
        case -2058947787: // managingOrganization
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
          return value;
        case -995410646: // partOf
          this.partOf = TypeConvertor.castToReference(value); // Reference
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1588872511: // hoursOfOperation
          this.getHoursOfOperation().add(TypeConvertor.castToAvailability(value)); // Availability
          return value;
        case 1420774698: // virtualService
          this.getVirtualService().add(TypeConvertor.castToVirtualServiceDetail(value)); // VirtualServiceDetail
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new LocationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<LocationStatus>
        } else if (name.equals("operationalStatus")) {
          this.operationalStatus = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("alias")) {
          this.getAlias().add(TypeConvertor.castToString(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("mode")) {
          value = new LocationModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<LocationMode>
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToExtendedContactDetail(value));
        } else if (name.equals("address")) {
          this.address = TypeConvertor.castToAddress(value); // Address
        } else if (name.equals("form")) {
          this.form = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("position")) {
          this.position = (LocationPositionComponent) value; // LocationPositionComponent
        } else if (name.equals("managingOrganization")) {
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("partOf")) {
          this.partOf = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("hoursOfOperation")) {
          this.getHoursOfOperation().add(TypeConvertor.castToAvailability(value));
        } else if (name.equals("virtualService")) {
          this.getVirtualService().add(TypeConvertor.castToVirtualServiceDetail(value));
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -2103166364:  return getOperationalStatus();
        case 3373707:  return getNameElement();
        case 92902992:  return addAliasElement();
        case -1724546052:  return getDescriptionElement();
        case 3357091:  return getModeElement();
        case 3575610:  return addType(); 
        case 951526432:  return addContact(); 
        case -1147692044:  return getAddress();
        case 3148996:  return getForm();
        case 747804969:  return getPosition();
        case -2058947787:  return getManagingOrganization();
        case -995410646:  return getPartOf();
        case 366313883:  return addCharacteristic(); 
        case -1588872511:  return addHoursOfOperation(); 
        case 1420774698:  return addVirtualService(); 
        case 1741102485:  return addEndpoint(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -2103166364: /*operationalStatus*/ return new String[] {"Coding"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 92902992: /*alias*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3357091: /*mode*/ return new String[] {"code"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 951526432: /*contact*/ return new String[] {"ExtendedContactDetail"};
        case -1147692044: /*address*/ return new String[] {"Address"};
        case 3148996: /*form*/ return new String[] {"CodeableConcept"};
        case 747804969: /*position*/ return new String[] {};
        case -2058947787: /*managingOrganization*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case 366313883: /*characteristic*/ return new String[] {"CodeableConcept"};
        case -1588872511: /*hoursOfOperation*/ return new String[] {"Availability"};
        case 1420774698: /*virtualService*/ return new String[] {"VirtualServiceDetail"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.status");
        }
        else if (name.equals("operationalStatus")) {
          this.operationalStatus = new Coding();
          return this.operationalStatus;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.name");
        }
        else if (name.equals("alias")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.alias");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.description");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a primitive type Location.mode");
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("address")) {
          this.address = new Address();
          return this.address;
        }
        else if (name.equals("form")) {
          this.form = new CodeableConcept();
          return this.form;
        }
        else if (name.equals("position")) {
          this.position = new LocationPositionComponent();
          return this.position;
        }
        else if (name.equals("managingOrganization")) {
          this.managingOrganization = new Reference();
          return this.managingOrganization;
        }
        else if (name.equals("partOf")) {
          this.partOf = new Reference();
          return this.partOf;
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("hoursOfOperation")) {
          return addHoursOfOperation();
        }
        else if (name.equals("virtualService")) {
          return addVirtualService();
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Location";

  }

      public Location copy() {
        Location dst = new Location();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Location dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.operationalStatus = operationalStatus == null ? null : operationalStatus.copy();
        dst.name = name == null ? null : name.copy();
        if (alias != null) {
          dst.alias = new ArrayList<StringType>();
          for (StringType i : alias)
            dst.alias.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.mode = mode == null ? null : mode.copy();
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (contact != null) {
          dst.contact = new ArrayList<ExtendedContactDetail>();
          for (ExtendedContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.address = address == null ? null : address.copy();
        dst.form = form == null ? null : form.copy();
        dst.position = position == null ? null : position.copy();
        dst.managingOrganization = managingOrganization == null ? null : managingOrganization.copy();
        dst.partOf = partOf == null ? null : partOf.copy();
        if (characteristic != null) {
          dst.characteristic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : characteristic)
            dst.characteristic.add(i.copy());
        };
        if (hoursOfOperation != null) {
          dst.hoursOfOperation = new ArrayList<Availability>();
          for (Availability i : hoursOfOperation)
            dst.hoursOfOperation.add(i.copy());
        };
        if (virtualService != null) {
          dst.virtualService = new ArrayList<VirtualServiceDetail>();
          for (VirtualServiceDetail i : virtualService)
            dst.virtualService.add(i.copy());
        };
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
      }

      protected Location typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Location))
          return false;
        Location o = (Location) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(operationalStatus, o.operationalStatus, true)
           && compareDeep(name, o.name, true) && compareDeep(alias, o.alias, true) && compareDeep(description, o.description, true)
           && compareDeep(mode, o.mode, true) && compareDeep(type, o.type, true) && compareDeep(contact, o.contact, true)
           && compareDeep(address, o.address, true) && compareDeep(form, o.form, true) && compareDeep(position, o.position, true)
           && compareDeep(managingOrganization, o.managingOrganization, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(characteristic, o.characteristic, true) && compareDeep(hoursOfOperation, o.hoursOfOperation, true)
           && compareDeep(virtualService, o.virtualService, true) && compareDeep(endpoint, o.endpoint, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Location))
          return false;
        Location o = (Location) other_;
        return compareValues(status, o.status, true) && compareValues(name, o.name, true) && compareValues(alias, o.alias, true)
           && compareValues(description, o.description, true) && compareValues(mode, o.mode, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, operationalStatus
          , name, alias, description, mode, type, contact, address, form, position, managingOrganization
          , partOf, characteristic, hoursOfOperation, virtualService, endpoint);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Location;
   }

 /**
   * Search parameter: <b>address-city</b>
   * <p>
   * Description: <b>A city specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.city</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-city", path="Location.address.city", description="A city specified in an address", type="string" )
  public static final String SP_ADDRESS_CITY = "address-city";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-city</b>
   * <p>
   * Description: <b>A city specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.city</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_CITY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_CITY);

 /**
   * Search parameter: <b>address-country</b>
   * <p>
   * Description: <b>A country specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.country</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-country", path="Location.address.country", description="A country specified in an address", type="string" )
  public static final String SP_ADDRESS_COUNTRY = "address-country";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-country</b>
   * <p>
   * Description: <b>A country specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.country</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_COUNTRY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_COUNTRY);

 /**
   * Search parameter: <b>address-postalcode</b>
   * <p>
   * Description: <b>A postal code specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.postalCode</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-postalcode", path="Location.address.postalCode", description="A postal code specified in an address", type="string" )
  public static final String SP_ADDRESS_POSTALCODE = "address-postalcode";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-postalcode</b>
   * <p>
   * Description: <b>A postal code specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.postalCode</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_POSTALCODE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_POSTALCODE);

 /**
   * Search parameter: <b>address-state</b>
   * <p>
   * Description: <b>A state specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.state</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-state", path="Location.address.state", description="A state specified in an address", type="string" )
  public static final String SP_ADDRESS_STATE = "address-state";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-state</b>
   * <p>
   * Description: <b>A state specified in an address</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address.state</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS_STATE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS_STATE);

 /**
   * Search parameter: <b>address-use</b>
   * <p>
   * Description: <b>A use code specified in an address</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.address.use</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address-use", path="Location.address.use", description="A use code specified in an address", type="token" )
  public static final String SP_ADDRESS_USE = "address-use";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address-use</b>
   * <p>
   * Description: <b>A use code specified in an address</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.address.use</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ADDRESS_USE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ADDRESS_USE);

 /**
   * Search parameter: <b>address</b>
   * <p>
   * Description: <b>A (part of the) address of the location</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address</b><br>
   * </p>
   */
  @SearchParamDefinition(name="address", path="Location.address", description="A (part of the) address of the location", type="string" )
  public static final String SP_ADDRESS = "address";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>address</b>
   * <p>
   * Description: <b>A (part of the) address of the location</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.address</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ADDRESS = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ADDRESS);

 /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>One of the Location's characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.characteristic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic", path="Location.characteristic", description="One of the Location's characteristics", type="token" )
  public static final String SP_CHARACTERISTIC = "characteristic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>One of the Location's characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.characteristic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CHARACTERISTIC);

 /**
   * Search parameter: <b>contains</b>
   * <p>
   * Description: <b>Select locations that contain the specified co-ordinates</b><br>
   * Type: <b>special</b><br>
   * Path: <b>Location.extension('http://hl7.org/fhir/StructureDefinition/location-boundary-geojson').value</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contains", path="Location.extension('http://hl7.org/fhir/StructureDefinition/location-boundary-geojson').value", description="Select locations that contain the specified co-ordinates", type="special" )
  public static final String SP_CONTAINS = "contains";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contains</b>
   * <p>
   * Description: <b>Select locations that contain the specified co-ordinates</b><br>
   * Type: <b>special</b><br>
   * Path: <b>Location.extension('http://hl7.org/fhir/StructureDefinition/location-boundary-geojson').value</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.SpecialClientParam CONTAINS = new ca.uhn.fhir.rest.gclient.SpecialClientParam(SP_CONTAINS);

 /**
   * Search parameter: <b>endpoint</b>
   * <p>
   * Description: <b>Technical endpoints providing access to services operated for the location</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Location.endpoint</b><br>
   * </p>
   */
  @SearchParamDefinition(name="endpoint", path="Location.endpoint", description="Technical endpoints providing access to services operated for the location", type="reference", target={Endpoint.class } )
  public static final String SP_ENDPOINT = "endpoint";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>endpoint</b>
   * <p>
   * Description: <b>Technical endpoints providing access to services operated for the location</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Location.endpoint</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENDPOINT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENDPOINT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Location:endpoint</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENDPOINT = new ca.uhn.fhir.model.api.Include("Location:endpoint").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>An identifier for the location</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Location.identifier", description="An identifier for the location", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>An identifier for the location</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A portion of the location's name or alias</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.name | Location.alias</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="Location.name | Location.alias", description="A portion of the location's name or alias", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A portion of the location's name or alias</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Location.name | Location.alias</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>near</b>
   * <p>
   * Description: <b>Search for locations where the location.position is near to, or within a specified distance of, the provided coordinates expressed as [latitude]|[longitude]|[distance]|[units] (using the WGS84 datum, see notes).

Servers which support the near parameter SHALL support the unit string 'km' for kilometers and SHOULD support '[mi_us]' for miles, support for other units is optional. If the units are omitted, then kms should be assumed. If the distance is omitted, then the server can use its own discretion as to what distances should be considered near (and units are irrelevant).If the server is unable to understand the units (and does support the near search parameter), it MIGHT return an OperationOutcome and fail the search with a http status 400 BadRequest. If the server does not support the near parameter, the parameter MIGHT report the unused parameter in a bundled OperationOutcome and still perform the search ignoring the near parameter.

Note: The algorithm to determine the distance is not defined by the specification, and systems might have different engines that calculate things differently. They could consider geographic point to point, or path via road, or including current traffic conditions, or just simple neighboring postcodes/localities if that's all it had access to.</b><br>
   * Type: <b>special</b><br>
   * Path: <b>Location.position</b><br>
   * </p>
   */
  @SearchParamDefinition(name="near", path="Location.position", description="Search for locations where the location.position is near to, or within a specified distance of, the provided coordinates expressed as [latitude]|[longitude]|[distance]|[units] (using the WGS84 datum, see notes).\n\nServers which support the near parameter SHALL support the unit string 'km' for kilometers and SHOULD support '[mi_us]' for miles, support for other units is optional. If the units are omitted, then kms should be assumed. If the distance is omitted, then the server can use its own discretion as to what distances should be considered near (and units are irrelevant).\r\rIf the server is unable to understand the units (and does support the near search parameter), it MIGHT return an OperationOutcome and fail the search with a http status 400 BadRequest. If the server does not support the near parameter, the parameter MIGHT report the unused parameter in a bundled OperationOutcome and still perform the search ignoring the near parameter.\n\nNote: The algorithm to determine the distance is not defined by the specification, and systems might have different engines that calculate things differently. They could consider geographic point to point, or path via road, or including current traffic conditions, or just simple neighboring postcodes/localities if that's all it had access to.", type="special" )
  public static final String SP_NEAR = "near";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>near</b>
   * <p>
   * Description: <b>Search for locations where the location.position is near to, or within a specified distance of, the provided coordinates expressed as [latitude]|[longitude]|[distance]|[units] (using the WGS84 datum, see notes).

Servers which support the near parameter SHALL support the unit string 'km' for kilometers and SHOULD support '[mi_us]' for miles, support for other units is optional. If the units are omitted, then kms should be assumed. If the distance is omitted, then the server can use its own discretion as to what distances should be considered near (and units are irrelevant).If the server is unable to understand the units (and does support the near search parameter), it MIGHT return an OperationOutcome and fail the search with a http status 400 BadRequest. If the server does not support the near parameter, the parameter MIGHT report the unused parameter in a bundled OperationOutcome and still perform the search ignoring the near parameter.

Note: The algorithm to determine the distance is not defined by the specification, and systems might have different engines that calculate things differently. They could consider geographic point to point, or path via road, or including current traffic conditions, or just simple neighboring postcodes/localities if that's all it had access to.</b><br>
   * Type: <b>special</b><br>
   * Path: <b>Location.position</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.SpecialClientParam NEAR = new ca.uhn.fhir.rest.gclient.SpecialClientParam(SP_NEAR);

 /**
   * Search parameter: <b>operational-status</b>
   * <p>
   * Description: <b>Searches for locations (typically bed/room) that have an operational status (e.g. contaminated, housekeeping)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.operationalStatus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="operational-status", path="Location.operationalStatus", description="Searches for locations (typically bed/room) that have an operational status (e.g. contaminated, housekeeping)", type="token" )
  public static final String SP_OPERATIONAL_STATUS = "operational-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>operational-status</b>
   * <p>
   * Description: <b>Searches for locations (typically bed/room) that have an operational status (e.g. contaminated, housekeeping)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.operationalStatus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam OPERATIONAL_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_OPERATIONAL_STATUS);

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>Searches for locations that are managed by the provided organization</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Location.managingOrganization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="Location.managingOrganization", description="Searches for locations that are managed by the provided organization", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>Searches for locations that are managed by the provided organization</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Location.managingOrganization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Location:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("Location:organization").toLocked();

 /**
   * Search parameter: <b>partof</b>
   * <p>
   * Description: <b>A location of which this location is a part</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Location.partOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="partof", path="Location.partOf", description="A location of which this location is a part", type="reference", target={Location.class } )
  public static final String SP_PARTOF = "partof";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>partof</b>
   * <p>
   * Description: <b>A location of which this location is a part</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Location.partOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARTOF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARTOF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Location:partof</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARTOF = new ca.uhn.fhir.model.api.Include("Location:partof").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Searches for locations with a specific kind of status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Location.status", description="Searches for locations with a specific kind of status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Searches for locations with a specific kind of status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>A code for the type of location</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Location.type", description="A code for the type of location", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>A code for the type of location</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Location.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

