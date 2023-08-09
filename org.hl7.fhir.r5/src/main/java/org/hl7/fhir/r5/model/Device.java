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
 * This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc.), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.
 */
@ResourceDef(name="Device", profile="http://hl7.org/fhir/StructureDefinition/Device")
public class Device extends DomainResource {

    public enum FHIRDeviceStatus {
        /**
         * The device record is current and is appropriate for reference in new instances.
         */
        ACTIVE, 
        /**
         * The device record is not current and is not appropriate for reference in new instances.
         */
        INACTIVE, 
        /**
         * The device record is not current and is not appropriate for reference in new instances.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static FHIRDeviceStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown FHIRDeviceStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case INACTIVE: return "inactive";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/device-status";
            case INACTIVE: return "http://hl7.org/fhir/device-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/device-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The device record is current and is appropriate for reference in new instances.";
            case INACTIVE: return "The device record is not current and is not appropriate for reference in new instances.";
            case ENTEREDINERROR: return "The device record is not current and is not appropriate for reference in new instances.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class FHIRDeviceStatusEnumFactory implements EnumFactory<FHIRDeviceStatus> {
    public FHIRDeviceStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return FHIRDeviceStatus.ACTIVE;
        if ("inactive".equals(codeString))
          return FHIRDeviceStatus.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return FHIRDeviceStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown FHIRDeviceStatus code '"+codeString+"'");
        }
        public Enumeration<FHIRDeviceStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRDeviceStatus>(this, FHIRDeviceStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<FHIRDeviceStatus>(this, FHIRDeviceStatus.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<FHIRDeviceStatus>(this, FHIRDeviceStatus.ACTIVE, code);
        if ("inactive".equals(codeString))
          return new Enumeration<FHIRDeviceStatus>(this, FHIRDeviceStatus.INACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<FHIRDeviceStatus>(this, FHIRDeviceStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown FHIRDeviceStatus code '"+codeString+"'");
        }
    public String toCode(FHIRDeviceStatus code) {
      if (code == FHIRDeviceStatus.ACTIVE)
        return "active";
      if (code == FHIRDeviceStatus.INACTIVE)
        return "inactive";
      if (code == FHIRDeviceStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(FHIRDeviceStatus code) {
      return code.getSystem();
      }
    }

    public enum UDIEntryType {
        /**
         * a barcodescanner captured the data from the device label.
         */
        BARCODE, 
        /**
         * An RFID chip reader captured the data from the device label.
         */
        RFID, 
        /**
         * The data was read from the label by a person and manually entered. (e.g.  via a keyboard).
         */
        MANUAL, 
        /**
         * The data originated from a patient's implant card and was read by an operator.
         */
        CARD, 
        /**
         * The data originated from a patient source and was not directly scanned or read from a label or card.
         */
        SELFREPORTED, 
        /**
         * The UDI information was received electronically from the device through a communication protocol, such as the IEEE 11073 20601 version 4 exchange protocol over Bluetooth or USB.
         */
        ELECTRONICTRANSMISSION, 
        /**
         * The method of data capture has not been determined.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static UDIEntryType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("barcode".equals(codeString))
          return BARCODE;
        if ("rfid".equals(codeString))
          return RFID;
        if ("manual".equals(codeString))
          return MANUAL;
        if ("card".equals(codeString))
          return CARD;
        if ("self-reported".equals(codeString))
          return SELFREPORTED;
        if ("electronic-transmission".equals(codeString))
          return ELECTRONICTRANSMISSION;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown UDIEntryType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BARCODE: return "barcode";
            case RFID: return "rfid";
            case MANUAL: return "manual";
            case CARD: return "card";
            case SELFREPORTED: return "self-reported";
            case ELECTRONICTRANSMISSION: return "electronic-transmission";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case BARCODE: return "http://hl7.org/fhir/udi-entry-type";
            case RFID: return "http://hl7.org/fhir/udi-entry-type";
            case MANUAL: return "http://hl7.org/fhir/udi-entry-type";
            case CARD: return "http://hl7.org/fhir/udi-entry-type";
            case SELFREPORTED: return "http://hl7.org/fhir/udi-entry-type";
            case ELECTRONICTRANSMISSION: return "http://hl7.org/fhir/udi-entry-type";
            case UNKNOWN: return "http://hl7.org/fhir/udi-entry-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case BARCODE: return "a barcodescanner captured the data from the device label.";
            case RFID: return "An RFID chip reader captured the data from the device label.";
            case MANUAL: return "The data was read from the label by a person and manually entered. (e.g.  via a keyboard).";
            case CARD: return "The data originated from a patient's implant card and was read by an operator.";
            case SELFREPORTED: return "The data originated from a patient source and was not directly scanned or read from a label or card.";
            case ELECTRONICTRANSMISSION: return "The UDI information was received electronically from the device through a communication protocol, such as the IEEE 11073 20601 version 4 exchange protocol over Bluetooth or USB.";
            case UNKNOWN: return "The method of data capture has not been determined.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BARCODE: return "Barcode";
            case RFID: return "RFID";
            case MANUAL: return "Manual";
            case CARD: return "Card";
            case SELFREPORTED: return "Self Reported";
            case ELECTRONICTRANSMISSION: return "Electronic Transmission";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class UDIEntryTypeEnumFactory implements EnumFactory<UDIEntryType> {
    public UDIEntryType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("barcode".equals(codeString))
          return UDIEntryType.BARCODE;
        if ("rfid".equals(codeString))
          return UDIEntryType.RFID;
        if ("manual".equals(codeString))
          return UDIEntryType.MANUAL;
        if ("card".equals(codeString))
          return UDIEntryType.CARD;
        if ("self-reported".equals(codeString))
          return UDIEntryType.SELFREPORTED;
        if ("electronic-transmission".equals(codeString))
          return UDIEntryType.ELECTRONICTRANSMISSION;
        if ("unknown".equals(codeString))
          return UDIEntryType.UNKNOWN;
        throw new IllegalArgumentException("Unknown UDIEntryType code '"+codeString+"'");
        }
        public Enumeration<UDIEntryType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<UDIEntryType>(this, UDIEntryType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<UDIEntryType>(this, UDIEntryType.NULL, code);
        if ("barcode".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.BARCODE, code);
        if ("rfid".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.RFID, code);
        if ("manual".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.MANUAL, code);
        if ("card".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.CARD, code);
        if ("self-reported".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.SELFREPORTED, code);
        if ("electronic-transmission".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.ELECTRONICTRANSMISSION, code);
        if ("unknown".equals(codeString))
          return new Enumeration<UDIEntryType>(this, UDIEntryType.UNKNOWN, code);
        throw new FHIRException("Unknown UDIEntryType code '"+codeString+"'");
        }
    public String toCode(UDIEntryType code) {
      if (code == UDIEntryType.BARCODE)
        return "barcode";
      if (code == UDIEntryType.RFID)
        return "rfid";
      if (code == UDIEntryType.MANUAL)
        return "manual";
      if (code == UDIEntryType.CARD)
        return "card";
      if (code == UDIEntryType.SELFREPORTED)
        return "self-reported";
      if (code == UDIEntryType.ELECTRONICTRANSMISSION)
        return "electronic-transmission";
      if (code == UDIEntryType.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(UDIEntryType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DeviceUdiCarrierComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.
         */
        @Child(name = "deviceIdentifier", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Mandatory fixed portion of UDI", formalDefinition="The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device." )
        protected StringType deviceIdentifier;

        /**
         * Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: 
1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, 
2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, 
3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, 
4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.
         */
        @Child(name = "issuer", type = {UriType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="UDI Issuing Organization", formalDefinition="Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: \n1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, \n2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, \n3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, \n4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di." )
        protected UriType issuer;

        /**
         * The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.
         */
        @Child(name = "jurisdiction", type = {UriType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Regional UDI authority", formalDefinition="The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi." )
        protected UriType jurisdiction;

        /**
         * The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.
         */
        @Child(name = "carrierAIDC", type = {Base64BinaryType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="UDI Machine Readable Barcode String", formalDefinition="The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded." )
        protected Base64BinaryType carrierAIDC;

        /**
         * The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.
         */
        @Child(name = "carrierHRF", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="UDI Human Readable Barcode String", formalDefinition="The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device." )
        protected StringType carrierHRF;

        /**
         * A coded entry to indicate how the data was entered.
         */
        @Child(name = "entryType", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="barcode | rfid | manual | card | self-reported | electronic-transmission | unknown", formalDefinition="A coded entry to indicate how the data was entered." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/udi-entry-type")
        protected Enumeration<UDIEntryType> entryType;

        private static final long serialVersionUID = -191630425L;

    /**
     * Constructor
     */
      public DeviceUdiCarrierComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceUdiCarrierComponent(String deviceIdentifier, String issuer) {
        super();
        this.setDeviceIdentifier(deviceIdentifier);
        this.setIssuer(issuer);
      }

        /**
         * @return {@link #deviceIdentifier} (The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.). This is the underlying object with id, value and extensions. The accessor "getDeviceIdentifier" gives direct access to the value
         */
        public StringType getDeviceIdentifierElement() { 
          if (this.deviceIdentifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUdiCarrierComponent.deviceIdentifier");
            else if (Configuration.doAutoCreate())
              this.deviceIdentifier = new StringType(); // bb
          return this.deviceIdentifier;
        }

        public boolean hasDeviceIdentifierElement() { 
          return this.deviceIdentifier != null && !this.deviceIdentifier.isEmpty();
        }

        public boolean hasDeviceIdentifier() { 
          return this.deviceIdentifier != null && !this.deviceIdentifier.isEmpty();
        }

        /**
         * @param value {@link #deviceIdentifier} (The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.). This is the underlying object with id, value and extensions. The accessor "getDeviceIdentifier" gives direct access to the value
         */
        public DeviceUdiCarrierComponent setDeviceIdentifierElement(StringType value) { 
          this.deviceIdentifier = value;
          return this;
        }

        /**
         * @return The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.
         */
        public String getDeviceIdentifier() { 
          return this.deviceIdentifier == null ? null : this.deviceIdentifier.getValue();
        }

        /**
         * @param value The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.
         */
        public DeviceUdiCarrierComponent setDeviceIdentifier(String value) { 
            if (this.deviceIdentifier == null)
              this.deviceIdentifier = new StringType();
            this.deviceIdentifier.setValue(value);
          return this;
        }

        /**
         * @return {@link #issuer} (Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: 
1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, 
2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, 
3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, 
4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
         */
        public UriType getIssuerElement() { 
          if (this.issuer == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUdiCarrierComponent.issuer");
            else if (Configuration.doAutoCreate())
              this.issuer = new UriType(); // bb
          return this.issuer;
        }

        public boolean hasIssuerElement() { 
          return this.issuer != null && !this.issuer.isEmpty();
        }

        public boolean hasIssuer() { 
          return this.issuer != null && !this.issuer.isEmpty();
        }

        /**
         * @param value {@link #issuer} (Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: 
1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, 
2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, 
3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, 
4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
         */
        public DeviceUdiCarrierComponent setIssuerElement(UriType value) { 
          this.issuer = value;
          return this;
        }

        /**
         * @return Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: 
1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, 
2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, 
3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, 
4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.
         */
        public String getIssuer() { 
          return this.issuer == null ? null : this.issuer.getValue();
        }

        /**
         * @param value Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: 
1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, 
2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, 
3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, 
4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.
         */
        public DeviceUdiCarrierComponent setIssuer(String value) { 
            if (this.issuer == null)
              this.issuer = new UriType();
            this.issuer.setValue(value);
          return this;
        }

        /**
         * @return {@link #jurisdiction} (The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.). This is the underlying object with id, value and extensions. The accessor "getJurisdiction" gives direct access to the value
         */
        public UriType getJurisdictionElement() { 
          if (this.jurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUdiCarrierComponent.jurisdiction");
            else if (Configuration.doAutoCreate())
              this.jurisdiction = new UriType(); // bb
          return this.jurisdiction;
        }

        public boolean hasJurisdictionElement() { 
          return this.jurisdiction != null && !this.jurisdiction.isEmpty();
        }

        public boolean hasJurisdiction() { 
          return this.jurisdiction != null && !this.jurisdiction.isEmpty();
        }

        /**
         * @param value {@link #jurisdiction} (The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.). This is the underlying object with id, value and extensions. The accessor "getJurisdiction" gives direct access to the value
         */
        public DeviceUdiCarrierComponent setJurisdictionElement(UriType value) { 
          this.jurisdiction = value;
          return this;
        }

        /**
         * @return The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.
         */
        public String getJurisdiction() { 
          return this.jurisdiction == null ? null : this.jurisdiction.getValue();
        }

        /**
         * @param value The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.
         */
        public DeviceUdiCarrierComponent setJurisdiction(String value) { 
          if (Utilities.noString(value))
            this.jurisdiction = null;
          else {
            if (this.jurisdiction == null)
              this.jurisdiction = new UriType();
            this.jurisdiction.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #carrierAIDC} (The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.). This is the underlying object with id, value and extensions. The accessor "getCarrierAIDC" gives direct access to the value
         */
        public Base64BinaryType getCarrierAIDCElement() { 
          if (this.carrierAIDC == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUdiCarrierComponent.carrierAIDC");
            else if (Configuration.doAutoCreate())
              this.carrierAIDC = new Base64BinaryType(); // bb
          return this.carrierAIDC;
        }

        public boolean hasCarrierAIDCElement() { 
          return this.carrierAIDC != null && !this.carrierAIDC.isEmpty();
        }

        public boolean hasCarrierAIDC() { 
          return this.carrierAIDC != null && !this.carrierAIDC.isEmpty();
        }

        /**
         * @param value {@link #carrierAIDC} (The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.). This is the underlying object with id, value and extensions. The accessor "getCarrierAIDC" gives direct access to the value
         */
        public DeviceUdiCarrierComponent setCarrierAIDCElement(Base64BinaryType value) { 
          this.carrierAIDC = value;
          return this;
        }

        /**
         * @return The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.
         */
        public byte[] getCarrierAIDC() { 
          return this.carrierAIDC == null ? null : this.carrierAIDC.getValue();
        }

        /**
         * @param value The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.
         */
        public DeviceUdiCarrierComponent setCarrierAIDC(byte[] value) { 
          if (value == null)
            this.carrierAIDC = null;
          else {
            if (this.carrierAIDC == null)
              this.carrierAIDC = new Base64BinaryType();
            this.carrierAIDC.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #carrierHRF} (The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.). This is the underlying object with id, value and extensions. The accessor "getCarrierHRF" gives direct access to the value
         */
        public StringType getCarrierHRFElement() { 
          if (this.carrierHRF == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUdiCarrierComponent.carrierHRF");
            else if (Configuration.doAutoCreate())
              this.carrierHRF = new StringType(); // bb
          return this.carrierHRF;
        }

        public boolean hasCarrierHRFElement() { 
          return this.carrierHRF != null && !this.carrierHRF.isEmpty();
        }

        public boolean hasCarrierHRF() { 
          return this.carrierHRF != null && !this.carrierHRF.isEmpty();
        }

        /**
         * @param value {@link #carrierHRF} (The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.). This is the underlying object with id, value and extensions. The accessor "getCarrierHRF" gives direct access to the value
         */
        public DeviceUdiCarrierComponent setCarrierHRFElement(StringType value) { 
          this.carrierHRF = value;
          return this;
        }

        /**
         * @return The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.
         */
        public String getCarrierHRF() { 
          return this.carrierHRF == null ? null : this.carrierHRF.getValue();
        }

        /**
         * @param value The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.
         */
        public DeviceUdiCarrierComponent setCarrierHRF(String value) { 
          if (Utilities.noString(value))
            this.carrierHRF = null;
          else {
            if (this.carrierHRF == null)
              this.carrierHRF = new StringType();
            this.carrierHRF.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #entryType} (A coded entry to indicate how the data was entered.). This is the underlying object with id, value and extensions. The accessor "getEntryType" gives direct access to the value
         */
        public Enumeration<UDIEntryType> getEntryTypeElement() { 
          if (this.entryType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUdiCarrierComponent.entryType");
            else if (Configuration.doAutoCreate())
              this.entryType = new Enumeration<UDIEntryType>(new UDIEntryTypeEnumFactory()); // bb
          return this.entryType;
        }

        public boolean hasEntryTypeElement() { 
          return this.entryType != null && !this.entryType.isEmpty();
        }

        public boolean hasEntryType() { 
          return this.entryType != null && !this.entryType.isEmpty();
        }

        /**
         * @param value {@link #entryType} (A coded entry to indicate how the data was entered.). This is the underlying object with id, value and extensions. The accessor "getEntryType" gives direct access to the value
         */
        public DeviceUdiCarrierComponent setEntryTypeElement(Enumeration<UDIEntryType> value) { 
          this.entryType = value;
          return this;
        }

        /**
         * @return A coded entry to indicate how the data was entered.
         */
        public UDIEntryType getEntryType() { 
          return this.entryType == null ? null : this.entryType.getValue();
        }

        /**
         * @param value A coded entry to indicate how the data was entered.
         */
        public DeviceUdiCarrierComponent setEntryType(UDIEntryType value) { 
          if (value == null)
            this.entryType = null;
          else {
            if (this.entryType == null)
              this.entryType = new Enumeration<UDIEntryType>(new UDIEntryTypeEnumFactory());
            this.entryType.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("deviceIdentifier", "string", "The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.", 0, 1, deviceIdentifier));
          children.add(new Property("issuer", "uri", "Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: \n1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, \n2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, \n3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, \n4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.", 0, 1, issuer));
          children.add(new Property("jurisdiction", "uri", "The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.", 0, 1, jurisdiction));
          children.add(new Property("carrierAIDC", "base64Binary", "The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.", 0, 1, carrierAIDC));
          children.add(new Property("carrierHRF", "string", "The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.", 0, 1, carrierHRF));
          children.add(new Property("entryType", "code", "A coded entry to indicate how the data was entered.", 0, 1, entryType));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1322005407: /*deviceIdentifier*/  return new Property("deviceIdentifier", "string", "The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler and the specific version or model of a device.", 0, 1, deviceIdentifier);
          case -1179159879: /*issuer*/  return new Property("issuer", "uri", "Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers include: \n1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di, \n2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI, \n3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di, \n4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di # Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only): http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.", 0, 1, issuer);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "uri", "The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs are globally unique within a single namespace with the appropriate repository uri as the system. For example, UDIs of devices managed in the U.S. by the FDA, the value is http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.", 0, 1, jurisdiction);
          case -768521825: /*carrierAIDC*/  return new Property("carrierAIDC", "base64Binary", "The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology representation of the barcode string as printed on the packaging of the device - e.g., a barcode or RFID.   Because of limitations on character sets in XML and the need to round-trip JSON data through XML, AIDC Formats *SHALL* be base64 encoded.", 0, 1, carrierAIDC);
          case 806499972: /*carrierHRF*/  return new Property("carrierHRF", "string", "The full UDI carrier as the human readable form (HRF) representation of the barcode string as printed on the packaging of the device.", 0, 1, carrierHRF);
          case -479362356: /*entryType*/  return new Property("entryType", "code", "A coded entry to indicate how the data was entered.", 0, 1, entryType);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1322005407: /*deviceIdentifier*/ return this.deviceIdentifier == null ? new Base[0] : new Base[] {this.deviceIdentifier}; // StringType
        case -1179159879: /*issuer*/ return this.issuer == null ? new Base[0] : new Base[] {this.issuer}; // UriType
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : new Base[] {this.jurisdiction}; // UriType
        case -768521825: /*carrierAIDC*/ return this.carrierAIDC == null ? new Base[0] : new Base[] {this.carrierAIDC}; // Base64BinaryType
        case 806499972: /*carrierHRF*/ return this.carrierHRF == null ? new Base[0] : new Base[] {this.carrierHRF}; // StringType
        case -479362356: /*entryType*/ return this.entryType == null ? new Base[0] : new Base[] {this.entryType}; // Enumeration<UDIEntryType>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1322005407: // deviceIdentifier
          this.deviceIdentifier = TypeConvertor.castToString(value); // StringType
          return value;
        case -1179159879: // issuer
          this.issuer = TypeConvertor.castToUri(value); // UriType
          return value;
        case -507075711: // jurisdiction
          this.jurisdiction = TypeConvertor.castToUri(value); // UriType
          return value;
        case -768521825: // carrierAIDC
          this.carrierAIDC = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
          return value;
        case 806499972: // carrierHRF
          this.carrierHRF = TypeConvertor.castToString(value); // StringType
          return value;
        case -479362356: // entryType
          value = new UDIEntryTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.entryType = (Enumeration) value; // Enumeration<UDIEntryType>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("deviceIdentifier")) {
          this.deviceIdentifier = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("issuer")) {
          this.issuer = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("jurisdiction")) {
          this.jurisdiction = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("carrierAIDC")) {
          this.carrierAIDC = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
        } else if (name.equals("carrierHRF")) {
          this.carrierHRF = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("entryType")) {
          value = new UDIEntryTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.entryType = (Enumeration) value; // Enumeration<UDIEntryType>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1322005407:  return getDeviceIdentifierElement();
        case -1179159879:  return getIssuerElement();
        case -507075711:  return getJurisdictionElement();
        case -768521825:  return getCarrierAIDCElement();
        case 806499972:  return getCarrierHRFElement();
        case -479362356:  return getEntryTypeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1322005407: /*deviceIdentifier*/ return new String[] {"string"};
        case -1179159879: /*issuer*/ return new String[] {"uri"};
        case -507075711: /*jurisdiction*/ return new String[] {"uri"};
        case -768521825: /*carrierAIDC*/ return new String[] {"base64Binary"};
        case 806499972: /*carrierHRF*/ return new String[] {"string"};
        case -479362356: /*entryType*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("deviceIdentifier")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.udiCarrier.deviceIdentifier");
        }
        else if (name.equals("issuer")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.udiCarrier.issuer");
        }
        else if (name.equals("jurisdiction")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.udiCarrier.jurisdiction");
        }
        else if (name.equals("carrierAIDC")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.udiCarrier.carrierAIDC");
        }
        else if (name.equals("carrierHRF")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.udiCarrier.carrierHRF");
        }
        else if (name.equals("entryType")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.udiCarrier.entryType");
        }
        else
          return super.addChild(name);
      }

      public DeviceUdiCarrierComponent copy() {
        DeviceUdiCarrierComponent dst = new DeviceUdiCarrierComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceUdiCarrierComponent dst) {
        super.copyValues(dst);
        dst.deviceIdentifier = deviceIdentifier == null ? null : deviceIdentifier.copy();
        dst.issuer = issuer == null ? null : issuer.copy();
        dst.jurisdiction = jurisdiction == null ? null : jurisdiction.copy();
        dst.carrierAIDC = carrierAIDC == null ? null : carrierAIDC.copy();
        dst.carrierHRF = carrierHRF == null ? null : carrierHRF.copy();
        dst.entryType = entryType == null ? null : entryType.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceUdiCarrierComponent))
          return false;
        DeviceUdiCarrierComponent o = (DeviceUdiCarrierComponent) other_;
        return compareDeep(deviceIdentifier, o.deviceIdentifier, true) && compareDeep(issuer, o.issuer, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(carrierAIDC, o.carrierAIDC, true)
           && compareDeep(carrierHRF, o.carrierHRF, true) && compareDeep(entryType, o.entryType, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceUdiCarrierComponent))
          return false;
        DeviceUdiCarrierComponent o = (DeviceUdiCarrierComponent) other_;
        return compareValues(deviceIdentifier, o.deviceIdentifier, true) && compareValues(issuer, o.issuer, true)
           && compareValues(jurisdiction, o.jurisdiction, true) && compareValues(carrierAIDC, o.carrierAIDC, true)
           && compareValues(carrierHRF, o.carrierHRF, true) && compareValues(entryType, o.entryType, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(deviceIdentifier, issuer, jurisdiction
          , carrierAIDC, carrierHRF, entryType);
      }

  public String fhirType() {
    return "Device.udiCarrier";

  }

  }

    @Block()
    public static class DeviceNameComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual name that identifies the device.
         */
        @Child(name = "value", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The term that names the device", formalDefinition="The actual name that identifies the device." )
        protected StringType value;

        /**
         * Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.
         */
        @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="registered-name | user-friendly-name | patient-reported-name", formalDefinition="Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-nametype")
        protected Enumeration<DeviceNameType> type;

        /**
         * Indicates the default or preferred name to be displayed.
         */
        @Child(name = "display", type = {BooleanType.class}, order=3, min=0, max=1, modifier=true, summary=true)
        @Description(shortDefinition="The preferred device name", formalDefinition="Indicates the default or preferred name to be displayed." )
        protected BooleanType display;

        private static final long serialVersionUID = 1911928470L;

    /**
     * Constructor
     */
      public DeviceNameComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceNameComponent(String value, DeviceNameType type) {
        super();
        this.setValue(value);
        this.setType(type);
      }

        /**
         * @return {@link #value} (The actual name that identifies the device.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceNameComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The actual name that identifies the device.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public DeviceNameComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The actual name that identifies the device.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The actual name that identifies the device.
         */
        public DeviceNameComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<DeviceNameType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceNameComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<DeviceNameType>(new DeviceNameTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public DeviceNameComponent setTypeElement(Enumeration<DeviceNameType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.
         */
        public DeviceNameType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.
         */
        public DeviceNameComponent setType(DeviceNameType value) { 
            if (this.type == null)
              this.type = new Enumeration<DeviceNameType>(new DeviceNameTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #display} (Indicates the default or preferred name to be displayed.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public BooleanType getDisplayElement() { 
          if (this.display == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceNameComponent.display");
            else if (Configuration.doAutoCreate())
              this.display = new BooleanType(); // bb
          return this.display;
        }

        public boolean hasDisplayElement() { 
          return this.display != null && !this.display.isEmpty();
        }

        public boolean hasDisplay() { 
          return this.display != null && !this.display.isEmpty();
        }

        /**
         * @param value {@link #display} (Indicates the default or preferred name to be displayed.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public DeviceNameComponent setDisplayElement(BooleanType value) { 
          this.display = value;
          return this;
        }

        /**
         * @return Indicates the default or preferred name to be displayed.
         */
        public boolean getDisplay() { 
          return this.display == null || this.display.isEmpty() ? false : this.display.getValue();
        }

        /**
         * @param value Indicates the default or preferred name to be displayed.
         */
        public DeviceNameComponent setDisplay(boolean value) { 
            if (this.display == null)
              this.display = new BooleanType();
            this.display.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value", "string", "The actual name that identifies the device.", 0, 1, value));
          children.add(new Property("type", "code", "Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.", 0, 1, type));
          children.add(new Property("display", "boolean", "Indicates the default or preferred name to be displayed.", 0, 1, display));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 111972721: /*value*/  return new Property("value", "string", "The actual name that identifies the device.", 0, 1, value);
          case 3575610: /*type*/  return new Property("type", "code", "Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName.", 0, 1, type);
          case 1671764162: /*display*/  return new Property("display", "boolean", "Indicates the default or preferred name to be displayed.", 0, 1, display);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<DeviceNameType>
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new DeviceNameTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DeviceNameType>
          return value;
        case 1671764162: // display
          this.display = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new DeviceNameTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DeviceNameType>
        } else if (name.equals("display")) {
          this.display = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        case 3575610:  return getTypeElement();
        case 1671764162:  return getDisplayElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 1671764162: /*display*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.name.value");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.name.type");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.name.display");
        }
        else
          return super.addChild(name);
      }

      public DeviceNameComponent copy() {
        DeviceNameComponent dst = new DeviceNameComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceNameComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.type = type == null ? null : type.copy();
        dst.display = display == null ? null : display.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceNameComponent))
          return false;
        DeviceNameComponent o = (DeviceNameComponent) other_;
        return compareDeep(value, o.value, true) && compareDeep(type, o.type, true) && compareDeep(display, o.display, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceNameComponent))
          return false;
        DeviceNameComponent o = (DeviceNameComponent) other_;
        return compareValues(value, o.value, true) && compareValues(type, o.type, true) && compareValues(display, o.display, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, type, display);
      }

  public String fhirType() {
    return "Device.name";

  }

  }

    @Block()
    public static class DeviceVersionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of the device version, e.g. manufacturer, approved, internal.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of the device version, e.g. manufacturer, approved, internal", formalDefinition="The type of the device version, e.g. manufacturer, approved, internal." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-versiontype")
        protected CodeableConcept type;

        /**
         * The hardware or software module of the device to which the version applies.
         */
        @Child(name = "component", type = {Identifier.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The hardware or software module of the device to which the version applies", formalDefinition="The hardware or software module of the device to which the version applies." )
        protected Identifier component;

        /**
         * The date the version was installed on the device.
         */
        @Child(name = "installDate", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the version was installed on the device", formalDefinition="The date the version was installed on the device." )
        protected DateTimeType installDate;

        /**
         * The version text.
         */
        @Child(name = "value", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The version text", formalDefinition="The version text." )
        protected StringType value;

        private static final long serialVersionUID = 1358422741L;

    /**
     * Constructor
     */
      public DeviceVersionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceVersionComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #type} (The type of the device version, e.g. manufacturer, approved, internal.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceVersionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of the device version, e.g. manufacturer, approved, internal.)
         */
        public DeviceVersionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #component} (The hardware or software module of the device to which the version applies.)
         */
        public Identifier getComponent() { 
          if (this.component == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceVersionComponent.component");
            else if (Configuration.doAutoCreate())
              this.component = new Identifier(); // cc
          return this.component;
        }

        public boolean hasComponent() { 
          return this.component != null && !this.component.isEmpty();
        }

        /**
         * @param value {@link #component} (The hardware or software module of the device to which the version applies.)
         */
        public DeviceVersionComponent setComponent(Identifier value) { 
          this.component = value;
          return this;
        }

        /**
         * @return {@link #installDate} (The date the version was installed on the device.). This is the underlying object with id, value and extensions. The accessor "getInstallDate" gives direct access to the value
         */
        public DateTimeType getInstallDateElement() { 
          if (this.installDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceVersionComponent.installDate");
            else if (Configuration.doAutoCreate())
              this.installDate = new DateTimeType(); // bb
          return this.installDate;
        }

        public boolean hasInstallDateElement() { 
          return this.installDate != null && !this.installDate.isEmpty();
        }

        public boolean hasInstallDate() { 
          return this.installDate != null && !this.installDate.isEmpty();
        }

        /**
         * @param value {@link #installDate} (The date the version was installed on the device.). This is the underlying object with id, value and extensions. The accessor "getInstallDate" gives direct access to the value
         */
        public DeviceVersionComponent setInstallDateElement(DateTimeType value) { 
          this.installDate = value;
          return this;
        }

        /**
         * @return The date the version was installed on the device.
         */
        public Date getInstallDate() { 
          return this.installDate == null ? null : this.installDate.getValue();
        }

        /**
         * @param value The date the version was installed on the device.
         */
        public DeviceVersionComponent setInstallDate(Date value) { 
          if (value == null)
            this.installDate = null;
          else {
            if (this.installDate == null)
              this.installDate = new DateTimeType();
            this.installDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #value} (The version text.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceVersionComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The version text.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public DeviceVersionComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The version text.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The version text.
         */
        public DeviceVersionComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type of the device version, e.g. manufacturer, approved, internal.", 0, 1, type));
          children.add(new Property("component", "Identifier", "The hardware or software module of the device to which the version applies.", 0, 1, component));
          children.add(new Property("installDate", "dateTime", "The date the version was installed on the device.", 0, 1, installDate));
          children.add(new Property("value", "string", "The version text.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of the device version, e.g. manufacturer, approved, internal.", 0, 1, type);
          case -1399907075: /*component*/  return new Property("component", "Identifier", "The hardware or software module of the device to which the version applies.", 0, 1, component);
          case 2143044585: /*installDate*/  return new Property("installDate", "dateTime", "The date the version was installed on the device.", 0, 1, installDate);
          case 111972721: /*value*/  return new Property("value", "string", "The version text.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : new Base[] {this.component}; // Identifier
        case 2143044585: /*installDate*/ return this.installDate == null ? new Base[0] : new Base[] {this.installDate}; // DateTimeType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1399907075: // component
          this.component = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 2143044585: // installDate
          this.installDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("component")) {
          this.component = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("installDate")) {
          this.installDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1399907075:  return getComponent();
        case 2143044585:  return getInstallDateElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1399907075: /*component*/ return new String[] {"Identifier"};
        case 2143044585: /*installDate*/ return new String[] {"dateTime"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("component")) {
          this.component = new Identifier();
          return this.component;
        }
        else if (name.equals("installDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.version.installDate");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.version.value");
        }
        else
          return super.addChild(name);
      }

      public DeviceVersionComponent copy() {
        DeviceVersionComponent dst = new DeviceVersionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceVersionComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.component = component == null ? null : component.copy();
        dst.installDate = installDate == null ? null : installDate.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceVersionComponent))
          return false;
        DeviceVersionComponent o = (DeviceVersionComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(component, o.component, true) && compareDeep(installDate, o.installDate, true)
           && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceVersionComponent))
          return false;
        DeviceVersionComponent o = (DeviceVersionComponent) other_;
        return compareValues(installDate, o.installDate, true) && compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, component, installDate
          , value);
      }

  public String fhirType() {
    return "Device.version";

  }

  }

    @Block()
    public static class DeviceConformsToComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes the type of the standard, specification, or formal guidance.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Describes the common type of the standard, specification, or formal guidance.  communication | performance | measurement", formalDefinition="Describes the type of the standard, specification, or formal guidance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-specification-category")
        protected CodeableConcept category;

        /**
         * Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.
         */
        @Child(name = "specification", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Identifies the standard, specification, or formal guidance that the device adheres to", formalDefinition="Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-specification-type")
        protected CodeableConcept specification;

        /**
         * Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.
         */
        @Child(name = "version", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specific form or variant of the standard", formalDefinition="Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label." )
        protected StringType version;

        private static final long serialVersionUID = 1592712180L;

    /**
     * Constructor
     */
      public DeviceConformsToComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceConformsToComponent(CodeableConcept specification) {
        super();
        this.setSpecification(specification);
      }

        /**
         * @return {@link #category} (Describes the type of the standard, specification, or formal guidance.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceConformsToComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (Describes the type of the standard, specification, or formal guidance.)
         */
        public DeviceConformsToComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #specification} (Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.)
         */
        public CodeableConcept getSpecification() { 
          if (this.specification == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceConformsToComponent.specification");
            else if (Configuration.doAutoCreate())
              this.specification = new CodeableConcept(); // cc
          return this.specification;
        }

        public boolean hasSpecification() { 
          return this.specification != null && !this.specification.isEmpty();
        }

        /**
         * @param value {@link #specification} (Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.)
         */
        public DeviceConformsToComponent setSpecification(CodeableConcept value) { 
          this.specification = value;
          return this;
        }

        /**
         * @return {@link #version} (Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public StringType getVersionElement() { 
          if (this.version == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceConformsToComponent.version");
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
         * @param value {@link #version} (Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public DeviceConformsToComponent setVersionElement(StringType value) { 
          this.version = value;
          return this;
        }

        /**
         * @return Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.
         */
        public String getVersion() { 
          return this.version == null ? null : this.version.getValue();
        }

        /**
         * @param value Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.
         */
        public DeviceConformsToComponent setVersion(String value) { 
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
          children.add(new Property("category", "CodeableConcept", "Describes the type of the standard, specification, or formal guidance.", 0, 1, category));
          children.add(new Property("specification", "CodeableConcept", "Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.", 0, 1, specification));
          children.add(new Property("version", "string", "Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.", 0, 1, version));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Describes the type of the standard, specification, or formal guidance.", 0, 1, category);
          case 1307197699: /*specification*/  return new Property("specification", "CodeableConcept", "Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.", 0, 1, specification);
          case 351608024: /*version*/  return new Property("version", "string", "Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.", 0, 1, version);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case 1307197699: /*specification*/ return this.specification == null ? new Base[0] : new Base[] {this.specification}; // CodeableConcept
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1307197699: // specification
          this.specification = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("specification")) {
          this.specification = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case 1307197699:  return getSpecification();
        case 351608024:  return getVersionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 1307197699: /*specification*/ return new String[] {"CodeableConcept"};
        case 351608024: /*version*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("specification")) {
          this.specification = new CodeableConcept();
          return this.specification;
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.conformsTo.version");
        }
        else
          return super.addChild(name);
      }

      public DeviceConformsToComponent copy() {
        DeviceConformsToComponent dst = new DeviceConformsToComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceConformsToComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.specification = specification == null ? null : specification.copy();
        dst.version = version == null ? null : version.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceConformsToComponent))
          return false;
        DeviceConformsToComponent o = (DeviceConformsToComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(specification, o.specification, true)
           && compareDeep(version, o.version, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceConformsToComponent))
          return false;
        DeviceConformsToComponent o = (DeviceConformsToComponent) other_;
        return compareValues(version, o.version, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, specification, version
          );
      }

  public String fhirType() {
    return "Device.conformsTo";

  }

  }

    @Block()
    public static class DevicePropertyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code that specifies the property, such as resolution, color, size, being represented.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code that specifies the property being represented", formalDefinition="Code that specifies the property, such as resolution, color, size, being represented." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-property-type")
        protected CodeableConcept type;

        /**
         * The value of the property specified by the associated property.type code.
         */
        @Child(name = "value", type = {Quantity.class, CodeableConcept.class, StringType.class, BooleanType.class, IntegerType.class, Range.class, Attachment.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of the property", formalDefinition="The value of the property specified by the associated property.type code." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public DevicePropertyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DevicePropertyComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Code that specifies the property, such as resolution, color, size, being represented.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DevicePropertyComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Code that specifies the property, such as resolution, color, size, being represented.)
         */
        public DevicePropertyComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() { 
          return this != null && this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the property specified by the associated property.type code.)
         */
        public DevicePropertyComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof CodeableConcept || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof Range || value instanceof Attachment))
            throw new FHIRException("Not the right type for Device.property.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Code that specifies the property, such as resolution, color, size, being represented.", 0, 1, type));
          children.add(new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Attachment", "The value of the property specified by the associated property.type code.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code that specifies the property, such as resolution, color, size, being represented.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Attachment", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Attachment", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The value of the property specified by the associated property.type code.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The value of the property specified by the associated property.type code.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Quantity", "CodeableConcept", "string", "boolean", "integer", "Range", "Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public DevicePropertyComponent copy() {
        DevicePropertyComponent dst = new DevicePropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DevicePropertyComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DevicePropertyComponent))
          return false;
        DevicePropertyComponent o = (DevicePropertyComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DevicePropertyComponent))
          return false;
        DevicePropertyComponent o = (DevicePropertyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "Device.property";

  }

  }

    /**
     * Unique instance identifiers assigned to a device by manufacturers other organizations or owners.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Instance identifier", formalDefinition="Unique instance identifiers assigned to a device by manufacturers other organizations or owners." )
    protected List<Identifier> identifier;

    /**
     * The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.
     */
    @Child(name = "displayName", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The name used to display by default when the device is referenced", formalDefinition="The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name." )
    protected StringType displayName;

    /**
     * The reference to the definition for the device.
     */
    @Child(name = "definition", type = {CodeableReference.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The reference to the definition for the device", formalDefinition="The reference to the definition for the device." )
    protected CodeableReference definition;

    /**
     * Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.
     */
    @Child(name = "udiCarrier", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique Device Identifier (UDI) Barcode string", formalDefinition="Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold." )
    protected List<DeviceUdiCarrierComponent> udiCarrier;

    /**
     * The Device record status. This is not the status of the device like availability.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | inactive | entered-in-error", formalDefinition="The Device record status. This is not the status of the device like availability." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-status")
    protected Enumeration<FHIRDeviceStatus> status;

    /**
     * The availability of the device.
     */
    @Child(name = "availabilityStatus", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="lost | damaged | destroyed | available", formalDefinition="The availability of the device." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-availability-status")
    protected CodeableConcept availabilityStatus;

    /**
     * An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled.
     */
    @Child(name = "biologicalSourceEvent", type = {Identifier.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled", formalDefinition="An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled." )
    protected Identifier biologicalSourceEvent;

    /**
     * A name of the manufacturer or entity legally responsible for the device.
     */
    @Child(name = "manufacturer", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of device manufacturer", formalDefinition="A name of the manufacturer or entity legally responsible for the device." )
    protected StringType manufacturer;

    /**
     * The date and time when the device was manufactured.
     */
    @Child(name = "manufactureDate", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date when the device was made", formalDefinition="The date and time when the device was manufactured." )
    protected DateTimeType manufactureDate;

    /**
     * The date and time beyond which this device is no longer valid or should not be used (if applicable).
     */
    @Child(name = "expirationDate", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date and time of expiry of this device (if applicable)", formalDefinition="The date and time beyond which this device is no longer valid or should not be used (if applicable)." )
    protected DateTimeType expirationDate;

    /**
     * Lot number assigned by the manufacturer.
     */
    @Child(name = "lotNumber", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Lot number of manufacture", formalDefinition="Lot number assigned by the manufacturer." )
    protected StringType lotNumber;

    /**
     * The serial number assigned by the organization when the device was manufactured.
     */
    @Child(name = "serialNumber", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Serial number assigned by the manufacturer", formalDefinition="The serial number assigned by the organization when the device was manufactured." )
    protected StringType serialNumber;

    /**
     * This represents the manufacturer's name of the device as provided by the device, from a UDI label, or by a person describing the Device.  This typically would be used when a person provides the name(s) or when the device represents one of the names available from DeviceDefinition.
     */
    @Child(name = "name", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The name or names of the device as known to the manufacturer and/or patient", formalDefinition="This represents the manufacturer's name of the device as provided by the device, from a UDI label, or by a person describing the Device.  This typically would be used when a person provides the name(s) or when the device represents one of the names available from DeviceDefinition." )
    protected List<DeviceNameComponent> name;

    /**
     * The manufacturer's model number for the device.
     */
    @Child(name = "modelNumber", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The manufacturer's model number for the device", formalDefinition="The manufacturer's model number for the device." )
    protected StringType modelNumber;

    /**
     * The part number or catalog number of the device.
     */
    @Child(name = "partNumber", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The part number or catalog number of the device", formalDefinition="The part number or catalog number of the device." )
    protected StringType partNumber;

    /**
     * Devices may be associated with one or more categories.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Indicates a high-level grouping of the device", formalDefinition="Devices may be associated with one or more categories." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-category")
    protected List<CodeableConcept> category;

    /**
     * The kind or type of device. A device instance may have more than one type - in which case those are the types that apply to the specific instance of the device.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The kind or type of device", formalDefinition="The kind or type of device. A device instance may have more than one type - in which case those are the types that apply to the specific instance of the device." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-type")
    protected List<CodeableConcept> type;

    /**
     * The actual design of the device or software version running on the device.
     */
    @Child(name = "version", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The actual design of the device or software version running on the device", formalDefinition="The actual design of the device or software version running on the device." )
    protected List<DeviceVersionComponent> version;

    /**
     * Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.
     */
    @Child(name = "conformsTo", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identifies the standards, specifications, or formal guidances for the capabilities supported by the device", formalDefinition="Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards." )
    protected List<DeviceConformsToComponent> conformsTo;

    /**
     * Static or essentially fixed characteristics or features of the device (e.g., time or timing attributes, resolution, accuracy, intended use or instructions for use, and physical attributes) that are not otherwise captured in more specific attributes.
     */
    @Child(name = "property", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Inherent, essentially fixed, characteristics of the device.  e.g., time properties, size, material, etc.", formalDefinition="Static or essentially fixed characteristics or features of the device (e.g., time or timing attributes, resolution, accuracy, intended use or instructions for use, and physical attributes) that are not otherwise captured in more specific attributes." )
    protected List<DevicePropertyComponent> property;

    /**
     * The designated condition for performing a task with the device.
     */
    @Child(name = "mode", type = {CodeableConcept.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The designated condition for performing a task", formalDefinition="The designated condition for performing a task with the device." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-operation-mode")
    protected CodeableConcept mode;

    /**
     * The series of occurrences that repeats during the operation of the device.
     */
    @Child(name = "cycle", type = {Count.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The series of occurrences that repeats during the operation of the device", formalDefinition="The series of occurrences that repeats during the operation of the device." )
    protected Count cycle;

    /**
     * A measurement of time during the device's operation (e.g., days, hours, mins, etc.).
     */
    @Child(name = "duration", type = {Duration.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A measurement of time during the device's operation (e.g., days, hours, mins, etc.)", formalDefinition="A measurement of time during the device's operation (e.g., days, hours, mins, etc.)." )
    protected Duration duration;

    /**
     * An organization that is responsible for the provision and ongoing maintenance of the device.
     */
    @Child(name = "owner", type = {Organization.class}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization responsible for device", formalDefinition="An organization that is responsible for the provision and ongoing maintenance of the device." )
    protected Reference owner;

    /**
     * Contact details for an organization or a particular human that is responsible for the device.
     */
    @Child(name = "contact", type = {ContactPoint.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details for human/organization for support", formalDefinition="Contact details for an organization or a particular human that is responsible for the device." )
    protected List<ContactPoint> contact;

    /**
     * The place where the device can be found.
     */
    @Child(name = "location", type = {Location.class}, order=25, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the device is found", formalDefinition="The place where the device can be found." )
    protected Reference location;

    /**
     * A network address on which the device may be contacted directly.
     */
    @Child(name = "url", type = {UriType.class}, order=26, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Network address to contact device", formalDefinition="A network address on which the device may be contacted directly." )
    protected UriType url;

    /**
     * Technical endpoints providing access to services provided by the device defined at this resource.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Technical endpoints providing access to electronic services provided by the device", formalDefinition="Technical endpoints providing access to services provided by the device defined at this resource." )
    protected List<Reference> endpoint;

    /**
     * The linked device acting as a communication controller, data collector, translator, or concentrator for the current device (e.g., mobile phone application that relays a blood pressure device's data).
     */
    @Child(name = "gateway", type = {CodeableReference.class}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Linked device acting as a communication/data collector, translator or controller", formalDefinition="The linked device acting as a communication controller, data collector, translator, or concentrator for the current device (e.g., mobile phone application that relays a blood pressure device's data)." )
    protected List<CodeableReference> gateway;

    /**
     * Descriptive information, usage information or implantation information that is not captured in an existing element.
     */
    @Child(name = "note", type = {Annotation.class}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Device notes and comments", formalDefinition="Descriptive information, usage information or implantation information that is not captured in an existing element." )
    protected List<Annotation> note;

    /**
     * Provides additional safety characteristics about a medical device.  For example devices containing latex.
     */
    @Child(name = "safety", type = {CodeableConcept.class}, order=30, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Safety Characteristics of Device", formalDefinition="Provides additional safety characteristics about a medical device.  For example devices containing latex." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-safety")
    protected List<CodeableConcept> safety;

    /**
     * The higher level or encompassing device that this device is a logical part of.
     */
    @Child(name = "parent", type = {Device.class}, order=31, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The higher level or encompassing device that this device is a logical part of", formalDefinition="The higher level or encompassing device that this device is a logical part of." )
    protected Reference parent;

    private static final long serialVersionUID = 2120085847L;

  /**
   * Constructor
   */
    public Device() {
      super();
    }

    /**
     * @return {@link #identifier} (Unique instance identifiers assigned to a device by manufacturers other organizations or owners.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setIdentifier(List<Identifier> theIdentifier) { 
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

    public Device addIdentifier(Identifier t) { //3
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
     * @return {@link #displayName} (The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.). This is the underlying object with id, value and extensions. The accessor "getDisplayName" gives direct access to the value
     */
    public StringType getDisplayNameElement() { 
      if (this.displayName == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.displayName");
        else if (Configuration.doAutoCreate())
          this.displayName = new StringType(); // bb
      return this.displayName;
    }

    public boolean hasDisplayNameElement() { 
      return this.displayName != null && !this.displayName.isEmpty();
    }

    public boolean hasDisplayName() { 
      return this.displayName != null && !this.displayName.isEmpty();
    }

    /**
     * @param value {@link #displayName} (The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.). This is the underlying object with id, value and extensions. The accessor "getDisplayName" gives direct access to the value
     */
    public Device setDisplayNameElement(StringType value) { 
      this.displayName = value;
      return this;
    }

    /**
     * @return The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.
     */
    public String getDisplayName() { 
      return this.displayName == null ? null : this.displayName.getValue();
    }

    /**
     * @param value The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.
     */
    public Device setDisplayName(String value) { 
      if (Utilities.noString(value))
        this.displayName = null;
      else {
        if (this.displayName == null)
          this.displayName = new StringType();
        this.displayName.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #definition} (The reference to the definition for the device.)
     */
    public CodeableReference getDefinition() { 
      if (this.definition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.definition");
        else if (Configuration.doAutoCreate())
          this.definition = new CodeableReference(); // cc
      return this.definition;
    }

    public boolean hasDefinition() { 
      return this.definition != null && !this.definition.isEmpty();
    }

    /**
     * @param value {@link #definition} (The reference to the definition for the device.)
     */
    public Device setDefinition(CodeableReference value) { 
      this.definition = value;
      return this;
    }

    /**
     * @return {@link #udiCarrier} (Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.)
     */
    public List<DeviceUdiCarrierComponent> getUdiCarrier() { 
      if (this.udiCarrier == null)
        this.udiCarrier = new ArrayList<DeviceUdiCarrierComponent>();
      return this.udiCarrier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setUdiCarrier(List<DeviceUdiCarrierComponent> theUdiCarrier) { 
      this.udiCarrier = theUdiCarrier;
      return this;
    }

    public boolean hasUdiCarrier() { 
      if (this.udiCarrier == null)
        return false;
      for (DeviceUdiCarrierComponent item : this.udiCarrier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceUdiCarrierComponent addUdiCarrier() { //3
      DeviceUdiCarrierComponent t = new DeviceUdiCarrierComponent();
      if (this.udiCarrier == null)
        this.udiCarrier = new ArrayList<DeviceUdiCarrierComponent>();
      this.udiCarrier.add(t);
      return t;
    }

    public Device addUdiCarrier(DeviceUdiCarrierComponent t) { //3
      if (t == null)
        return this;
      if (this.udiCarrier == null)
        this.udiCarrier = new ArrayList<DeviceUdiCarrierComponent>();
      this.udiCarrier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #udiCarrier}, creating it if it does not already exist {3}
     */
    public DeviceUdiCarrierComponent getUdiCarrierFirstRep() { 
      if (getUdiCarrier().isEmpty()) {
        addUdiCarrier();
      }
      return getUdiCarrier().get(0);
    }

    /**
     * @return {@link #status} (The Device record status. This is not the status of the device like availability.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FHIRDeviceStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FHIRDeviceStatus>(new FHIRDeviceStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The Device record status. This is not the status of the device like availability.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Device setStatusElement(Enumeration<FHIRDeviceStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The Device record status. This is not the status of the device like availability.
     */
    public FHIRDeviceStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The Device record status. This is not the status of the device like availability.
     */
    public Device setStatus(FHIRDeviceStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<FHIRDeviceStatus>(new FHIRDeviceStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #availabilityStatus} (The availability of the device.)
     */
    public CodeableConcept getAvailabilityStatus() { 
      if (this.availabilityStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.availabilityStatus");
        else if (Configuration.doAutoCreate())
          this.availabilityStatus = new CodeableConcept(); // cc
      return this.availabilityStatus;
    }

    public boolean hasAvailabilityStatus() { 
      return this.availabilityStatus != null && !this.availabilityStatus.isEmpty();
    }

    /**
     * @param value {@link #availabilityStatus} (The availability of the device.)
     */
    public Device setAvailabilityStatus(CodeableConcept value) { 
      this.availabilityStatus = value;
      return this;
    }

    /**
     * @return {@link #biologicalSourceEvent} (An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled.)
     */
    public Identifier getBiologicalSourceEvent() { 
      if (this.biologicalSourceEvent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.biologicalSourceEvent");
        else if (Configuration.doAutoCreate())
          this.biologicalSourceEvent = new Identifier(); // cc
      return this.biologicalSourceEvent;
    }

    public boolean hasBiologicalSourceEvent() { 
      return this.biologicalSourceEvent != null && !this.biologicalSourceEvent.isEmpty();
    }

    /**
     * @param value {@link #biologicalSourceEvent} (An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled.)
     */
    public Device setBiologicalSourceEvent(Identifier value) { 
      this.biologicalSourceEvent = value;
      return this;
    }

    /**
     * @return {@link #manufacturer} (A name of the manufacturer or entity legally responsible for the device.). This is the underlying object with id, value and extensions. The accessor "getManufacturer" gives direct access to the value
     */
    public StringType getManufacturerElement() { 
      if (this.manufacturer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.manufacturer");
        else if (Configuration.doAutoCreate())
          this.manufacturer = new StringType(); // bb
      return this.manufacturer;
    }

    public boolean hasManufacturerElement() { 
      return this.manufacturer != null && !this.manufacturer.isEmpty();
    }

    public boolean hasManufacturer() { 
      return this.manufacturer != null && !this.manufacturer.isEmpty();
    }

    /**
     * @param value {@link #manufacturer} (A name of the manufacturer or entity legally responsible for the device.). This is the underlying object with id, value and extensions. The accessor "getManufacturer" gives direct access to the value
     */
    public Device setManufacturerElement(StringType value) { 
      this.manufacturer = value;
      return this;
    }

    /**
     * @return A name of the manufacturer or entity legally responsible for the device.
     */
    public String getManufacturer() { 
      return this.manufacturer == null ? null : this.manufacturer.getValue();
    }

    /**
     * @param value A name of the manufacturer or entity legally responsible for the device.
     */
    public Device setManufacturer(String value) { 
      if (Utilities.noString(value))
        this.manufacturer = null;
      else {
        if (this.manufacturer == null)
          this.manufacturer = new StringType();
        this.manufacturer.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #manufactureDate} (The date and time when the device was manufactured.). This is the underlying object with id, value and extensions. The accessor "getManufactureDate" gives direct access to the value
     */
    public DateTimeType getManufactureDateElement() { 
      if (this.manufactureDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.manufactureDate");
        else if (Configuration.doAutoCreate())
          this.manufactureDate = new DateTimeType(); // bb
      return this.manufactureDate;
    }

    public boolean hasManufactureDateElement() { 
      return this.manufactureDate != null && !this.manufactureDate.isEmpty();
    }

    public boolean hasManufactureDate() { 
      return this.manufactureDate != null && !this.manufactureDate.isEmpty();
    }

    /**
     * @param value {@link #manufactureDate} (The date and time when the device was manufactured.). This is the underlying object with id, value and extensions. The accessor "getManufactureDate" gives direct access to the value
     */
    public Device setManufactureDateElement(DateTimeType value) { 
      this.manufactureDate = value;
      return this;
    }

    /**
     * @return The date and time when the device was manufactured.
     */
    public Date getManufactureDate() { 
      return this.manufactureDate == null ? null : this.manufactureDate.getValue();
    }

    /**
     * @param value The date and time when the device was manufactured.
     */
    public Device setManufactureDate(Date value) { 
      if (value == null)
        this.manufactureDate = null;
      else {
        if (this.manufactureDate == null)
          this.manufactureDate = new DateTimeType();
        this.manufactureDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #expirationDate} (The date and time beyond which this device is no longer valid or should not be used (if applicable).). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
     */
    public DateTimeType getExpirationDateElement() { 
      if (this.expirationDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.expirationDate");
        else if (Configuration.doAutoCreate())
          this.expirationDate = new DateTimeType(); // bb
      return this.expirationDate;
    }

    public boolean hasExpirationDateElement() { 
      return this.expirationDate != null && !this.expirationDate.isEmpty();
    }

    public boolean hasExpirationDate() { 
      return this.expirationDate != null && !this.expirationDate.isEmpty();
    }

    /**
     * @param value {@link #expirationDate} (The date and time beyond which this device is no longer valid or should not be used (if applicable).). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
     */
    public Device setExpirationDateElement(DateTimeType value) { 
      this.expirationDate = value;
      return this;
    }

    /**
     * @return The date and time beyond which this device is no longer valid or should not be used (if applicable).
     */
    public Date getExpirationDate() { 
      return this.expirationDate == null ? null : this.expirationDate.getValue();
    }

    /**
     * @param value The date and time beyond which this device is no longer valid or should not be used (if applicable).
     */
    public Device setExpirationDate(Date value) { 
      if (value == null)
        this.expirationDate = null;
      else {
        if (this.expirationDate == null)
          this.expirationDate = new DateTimeType();
        this.expirationDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lotNumber} (Lot number assigned by the manufacturer.). This is the underlying object with id, value and extensions. The accessor "getLotNumber" gives direct access to the value
     */
    public StringType getLotNumberElement() { 
      if (this.lotNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.lotNumber");
        else if (Configuration.doAutoCreate())
          this.lotNumber = new StringType(); // bb
      return this.lotNumber;
    }

    public boolean hasLotNumberElement() { 
      return this.lotNumber != null && !this.lotNumber.isEmpty();
    }

    public boolean hasLotNumber() { 
      return this.lotNumber != null && !this.lotNumber.isEmpty();
    }

    /**
     * @param value {@link #lotNumber} (Lot number assigned by the manufacturer.). This is the underlying object with id, value and extensions. The accessor "getLotNumber" gives direct access to the value
     */
    public Device setLotNumberElement(StringType value) { 
      this.lotNumber = value;
      return this;
    }

    /**
     * @return Lot number assigned by the manufacturer.
     */
    public String getLotNumber() { 
      return this.lotNumber == null ? null : this.lotNumber.getValue();
    }

    /**
     * @param value Lot number assigned by the manufacturer.
     */
    public Device setLotNumber(String value) { 
      if (Utilities.noString(value))
        this.lotNumber = null;
      else {
        if (this.lotNumber == null)
          this.lotNumber = new StringType();
        this.lotNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #serialNumber} (The serial number assigned by the organization when the device was manufactured.). This is the underlying object with id, value and extensions. The accessor "getSerialNumber" gives direct access to the value
     */
    public StringType getSerialNumberElement() { 
      if (this.serialNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.serialNumber");
        else if (Configuration.doAutoCreate())
          this.serialNumber = new StringType(); // bb
      return this.serialNumber;
    }

    public boolean hasSerialNumberElement() { 
      return this.serialNumber != null && !this.serialNumber.isEmpty();
    }

    public boolean hasSerialNumber() { 
      return this.serialNumber != null && !this.serialNumber.isEmpty();
    }

    /**
     * @param value {@link #serialNumber} (The serial number assigned by the organization when the device was manufactured.). This is the underlying object with id, value and extensions. The accessor "getSerialNumber" gives direct access to the value
     */
    public Device setSerialNumberElement(StringType value) { 
      this.serialNumber = value;
      return this;
    }

    /**
     * @return The serial number assigned by the organization when the device was manufactured.
     */
    public String getSerialNumber() { 
      return this.serialNumber == null ? null : this.serialNumber.getValue();
    }

    /**
     * @param value The serial number assigned by the organization when the device was manufactured.
     */
    public Device setSerialNumber(String value) { 
      if (Utilities.noString(value))
        this.serialNumber = null;
      else {
        if (this.serialNumber == null)
          this.serialNumber = new StringType();
        this.serialNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #name} (This represents the manufacturer's name of the device as provided by the device, from a UDI label, or by a person describing the Device.  This typically would be used when a person provides the name(s) or when the device represents one of the names available from DeviceDefinition.)
     */
    public List<DeviceNameComponent> getName() { 
      if (this.name == null)
        this.name = new ArrayList<DeviceNameComponent>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setName(List<DeviceNameComponent> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (DeviceNameComponent item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceNameComponent addName() { //3
      DeviceNameComponent t = new DeviceNameComponent();
      if (this.name == null)
        this.name = new ArrayList<DeviceNameComponent>();
      this.name.add(t);
      return t;
    }

    public Device addName(DeviceNameComponent t) { //3
      if (t == null)
        return this;
      if (this.name == null)
        this.name = new ArrayList<DeviceNameComponent>();
      this.name.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #name}, creating it if it does not already exist {3}
     */
    public DeviceNameComponent getNameFirstRep() { 
      if (getName().isEmpty()) {
        addName();
      }
      return getName().get(0);
    }

    /**
     * @return {@link #modelNumber} (The manufacturer's model number for the device.). This is the underlying object with id, value and extensions. The accessor "getModelNumber" gives direct access to the value
     */
    public StringType getModelNumberElement() { 
      if (this.modelNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.modelNumber");
        else if (Configuration.doAutoCreate())
          this.modelNumber = new StringType(); // bb
      return this.modelNumber;
    }

    public boolean hasModelNumberElement() { 
      return this.modelNumber != null && !this.modelNumber.isEmpty();
    }

    public boolean hasModelNumber() { 
      return this.modelNumber != null && !this.modelNumber.isEmpty();
    }

    /**
     * @param value {@link #modelNumber} (The manufacturer's model number for the device.). This is the underlying object with id, value and extensions. The accessor "getModelNumber" gives direct access to the value
     */
    public Device setModelNumberElement(StringType value) { 
      this.modelNumber = value;
      return this;
    }

    /**
     * @return The manufacturer's model number for the device.
     */
    public String getModelNumber() { 
      return this.modelNumber == null ? null : this.modelNumber.getValue();
    }

    /**
     * @param value The manufacturer's model number for the device.
     */
    public Device setModelNumber(String value) { 
      if (Utilities.noString(value))
        this.modelNumber = null;
      else {
        if (this.modelNumber == null)
          this.modelNumber = new StringType();
        this.modelNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #partNumber} (The part number or catalog number of the device.). This is the underlying object with id, value and extensions. The accessor "getPartNumber" gives direct access to the value
     */
    public StringType getPartNumberElement() { 
      if (this.partNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.partNumber");
        else if (Configuration.doAutoCreate())
          this.partNumber = new StringType(); // bb
      return this.partNumber;
    }

    public boolean hasPartNumberElement() { 
      return this.partNumber != null && !this.partNumber.isEmpty();
    }

    public boolean hasPartNumber() { 
      return this.partNumber != null && !this.partNumber.isEmpty();
    }

    /**
     * @param value {@link #partNumber} (The part number or catalog number of the device.). This is the underlying object with id, value and extensions. The accessor "getPartNumber" gives direct access to the value
     */
    public Device setPartNumberElement(StringType value) { 
      this.partNumber = value;
      return this;
    }

    /**
     * @return The part number or catalog number of the device.
     */
    public String getPartNumber() { 
      return this.partNumber == null ? null : this.partNumber.getValue();
    }

    /**
     * @param value The part number or catalog number of the device.
     */
    public Device setPartNumber(String value) { 
      if (Utilities.noString(value))
        this.partNumber = null;
      else {
        if (this.partNumber == null)
          this.partNumber = new StringType();
        this.partNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #category} (Devices may be associated with one or more categories.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public Device addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #type} (The kind or type of device. A device instance may have more than one type - in which case those are the types that apply to the specific instance of the device.)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setType(List<CodeableConcept> theType) { 
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

    public Device addType(CodeableConcept t) { //3
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
     * @return {@link #version} (The actual design of the device or software version running on the device.)
     */
    public List<DeviceVersionComponent> getVersion() { 
      if (this.version == null)
        this.version = new ArrayList<DeviceVersionComponent>();
      return this.version;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setVersion(List<DeviceVersionComponent> theVersion) { 
      this.version = theVersion;
      return this;
    }

    public boolean hasVersion() { 
      if (this.version == null)
        return false;
      for (DeviceVersionComponent item : this.version)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceVersionComponent addVersion() { //3
      DeviceVersionComponent t = new DeviceVersionComponent();
      if (this.version == null)
        this.version = new ArrayList<DeviceVersionComponent>();
      this.version.add(t);
      return t;
    }

    public Device addVersion(DeviceVersionComponent t) { //3
      if (t == null)
        return this;
      if (this.version == null)
        this.version = new ArrayList<DeviceVersionComponent>();
      this.version.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #version}, creating it if it does not already exist {3}
     */
    public DeviceVersionComponent getVersionFirstRep() { 
      if (getVersion().isEmpty()) {
        addVersion();
      }
      return getVersion().get(0);
    }

    /**
     * @return {@link #conformsTo} (Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.)
     */
    public List<DeviceConformsToComponent> getConformsTo() { 
      if (this.conformsTo == null)
        this.conformsTo = new ArrayList<DeviceConformsToComponent>();
      return this.conformsTo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setConformsTo(List<DeviceConformsToComponent> theConformsTo) { 
      this.conformsTo = theConformsTo;
      return this;
    }

    public boolean hasConformsTo() { 
      if (this.conformsTo == null)
        return false;
      for (DeviceConformsToComponent item : this.conformsTo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceConformsToComponent addConformsTo() { //3
      DeviceConformsToComponent t = new DeviceConformsToComponent();
      if (this.conformsTo == null)
        this.conformsTo = new ArrayList<DeviceConformsToComponent>();
      this.conformsTo.add(t);
      return t;
    }

    public Device addConformsTo(DeviceConformsToComponent t) { //3
      if (t == null)
        return this;
      if (this.conformsTo == null)
        this.conformsTo = new ArrayList<DeviceConformsToComponent>();
      this.conformsTo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #conformsTo}, creating it if it does not already exist {3}
     */
    public DeviceConformsToComponent getConformsToFirstRep() { 
      if (getConformsTo().isEmpty()) {
        addConformsTo();
      }
      return getConformsTo().get(0);
    }

    /**
     * @return {@link #property} (Static or essentially fixed characteristics or features of the device (e.g., time or timing attributes, resolution, accuracy, intended use or instructions for use, and physical attributes) that are not otherwise captured in more specific attributes.)
     */
    public List<DevicePropertyComponent> getProperty() { 
      if (this.property == null)
        this.property = new ArrayList<DevicePropertyComponent>();
      return this.property;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setProperty(List<DevicePropertyComponent> theProperty) { 
      this.property = theProperty;
      return this;
    }

    public boolean hasProperty() { 
      if (this.property == null)
        return false;
      for (DevicePropertyComponent item : this.property)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DevicePropertyComponent addProperty() { //3
      DevicePropertyComponent t = new DevicePropertyComponent();
      if (this.property == null)
        this.property = new ArrayList<DevicePropertyComponent>();
      this.property.add(t);
      return t;
    }

    public Device addProperty(DevicePropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.property == null)
        this.property = new ArrayList<DevicePropertyComponent>();
      this.property.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
     */
    public DevicePropertyComponent getPropertyFirstRep() { 
      if (getProperty().isEmpty()) {
        addProperty();
      }
      return getProperty().get(0);
    }

    /**
     * @return {@link #mode} (The designated condition for performing a task with the device.)
     */
    public CodeableConcept getMode() { 
      if (this.mode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.mode");
        else if (Configuration.doAutoCreate())
          this.mode = new CodeableConcept(); // cc
      return this.mode;
    }

    public boolean hasMode() { 
      return this.mode != null && !this.mode.isEmpty();
    }

    /**
     * @param value {@link #mode} (The designated condition for performing a task with the device.)
     */
    public Device setMode(CodeableConcept value) { 
      this.mode = value;
      return this;
    }

    /**
     * @return {@link #cycle} (The series of occurrences that repeats during the operation of the device.)
     */
    public Count getCycle() { 
      if (this.cycle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.cycle");
        else if (Configuration.doAutoCreate())
          this.cycle = new Count(); // cc
      return this.cycle;
    }

    public boolean hasCycle() { 
      return this.cycle != null && !this.cycle.isEmpty();
    }

    /**
     * @param value {@link #cycle} (The series of occurrences that repeats during the operation of the device.)
     */
    public Device setCycle(Count value) { 
      this.cycle = value;
      return this;
    }

    /**
     * @return {@link #duration} (A measurement of time during the device's operation (e.g., days, hours, mins, etc.).)
     */
    public Duration getDuration() { 
      if (this.duration == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.duration");
        else if (Configuration.doAutoCreate())
          this.duration = new Duration(); // cc
      return this.duration;
    }

    public boolean hasDuration() { 
      return this.duration != null && !this.duration.isEmpty();
    }

    /**
     * @param value {@link #duration} (A measurement of time during the device's operation (e.g., days, hours, mins, etc.).)
     */
    public Device setDuration(Duration value) { 
      this.duration = value;
      return this;
    }

    /**
     * @return {@link #owner} (An organization that is responsible for the provision and ongoing maintenance of the device.)
     */
    public Reference getOwner() { 
      if (this.owner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.owner");
        else if (Configuration.doAutoCreate())
          this.owner = new Reference(); // cc
      return this.owner;
    }

    public boolean hasOwner() { 
      return this.owner != null && !this.owner.isEmpty();
    }

    /**
     * @param value {@link #owner} (An organization that is responsible for the provision and ongoing maintenance of the device.)
     */
    public Device setOwner(Reference value) { 
      this.owner = value;
      return this;
    }

    /**
     * @return {@link #contact} (Contact details for an organization or a particular human that is responsible for the device.)
     */
    public List<ContactPoint> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setContact(List<ContactPoint> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactPoint item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactPoint addContact() { //3
      ContactPoint t = new ContactPoint();
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      this.contact.add(t);
      return t;
    }

    public Device addContact(ContactPoint t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactPoint getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #location} (The place where the device can be found.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The place where the device can be found.)
     */
    public Device setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #url} (A network address on which the device may be contacted directly.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.url");
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
     * @param value {@link #url} (A network address on which the device may be contacted directly.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Device setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return A network address on which the device may be contacted directly.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value A network address on which the device may be contacted directly.
     */
    public Device setUrl(String value) { 
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
     * @return {@link #endpoint} (Technical endpoints providing access to services provided by the device defined at this resource.)
     */
    public List<Reference> getEndpoint() { 
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      return this.endpoint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setEndpoint(List<Reference> theEndpoint) { 
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

    public Device addEndpoint(Reference t) { //3
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

    /**
     * @return {@link #gateway} (The linked device acting as a communication controller, data collector, translator, or concentrator for the current device (e.g., mobile phone application that relays a blood pressure device's data).)
     */
    public List<CodeableReference> getGateway() { 
      if (this.gateway == null)
        this.gateway = new ArrayList<CodeableReference>();
      return this.gateway;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setGateway(List<CodeableReference> theGateway) { 
      this.gateway = theGateway;
      return this;
    }

    public boolean hasGateway() { 
      if (this.gateway == null)
        return false;
      for (CodeableReference item : this.gateway)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addGateway() { //3
      CodeableReference t = new CodeableReference();
      if (this.gateway == null)
        this.gateway = new ArrayList<CodeableReference>();
      this.gateway.add(t);
      return t;
    }

    public Device addGateway(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.gateway == null)
        this.gateway = new ArrayList<CodeableReference>();
      this.gateway.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #gateway}, creating it if it does not already exist {3}
     */
    public CodeableReference getGatewayFirstRep() { 
      if (getGateway().isEmpty()) {
        addGateway();
      }
      return getGateway().get(0);
    }

    /**
     * @return {@link #note} (Descriptive information, usage information or implantation information that is not captured in an existing element.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setNote(List<Annotation> theNote) { 
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

    public Device addNote(Annotation t) { //3
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

    /**
     * @return {@link #safety} (Provides additional safety characteristics about a medical device.  For example devices containing latex.)
     */
    public List<CodeableConcept> getSafety() { 
      if (this.safety == null)
        this.safety = new ArrayList<CodeableConcept>();
      return this.safety;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Device setSafety(List<CodeableConcept> theSafety) { 
      this.safety = theSafety;
      return this;
    }

    public boolean hasSafety() { 
      if (this.safety == null)
        return false;
      for (CodeableConcept item : this.safety)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSafety() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.safety == null)
        this.safety = new ArrayList<CodeableConcept>();
      this.safety.add(t);
      return t;
    }

    public Device addSafety(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.safety == null)
        this.safety = new ArrayList<CodeableConcept>();
      this.safety.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #safety}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSafetyFirstRep() { 
      if (getSafety().isEmpty()) {
        addSafety();
      }
      return getSafety().get(0);
    }

    /**
     * @return {@link #parent} (The higher level or encompassing device that this device is a logical part of.)
     */
    public Reference getParent() { 
      if (this.parent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Device.parent");
        else if (Configuration.doAutoCreate())
          this.parent = new Reference(); // cc
      return this.parent;
    }

    public boolean hasParent() { 
      return this.parent != null && !this.parent.isEmpty();
    }

    /**
     * @param value {@link #parent} (The higher level or encompassing device that this device is a logical part of.)
     */
    public Device setParent(Reference value) { 
      this.parent = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique instance identifiers assigned to a device by manufacturers other organizations or owners.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("displayName", "string", "The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.", 0, 1, displayName));
        children.add(new Property("definition", "CodeableReference(DeviceDefinition)", "The reference to the definition for the device.", 0, 1, definition));
        children.add(new Property("udiCarrier", "", "Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.", 0, java.lang.Integer.MAX_VALUE, udiCarrier));
        children.add(new Property("status", "code", "The Device record status. This is not the status of the device like availability.", 0, 1, status));
        children.add(new Property("availabilityStatus", "CodeableConcept", "The availability of the device.", 0, 1, availabilityStatus));
        children.add(new Property("biologicalSourceEvent", "Identifier", "An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled.", 0, 1, biologicalSourceEvent));
        children.add(new Property("manufacturer", "string", "A name of the manufacturer or entity legally responsible for the device.", 0, 1, manufacturer));
        children.add(new Property("manufactureDate", "dateTime", "The date and time when the device was manufactured.", 0, 1, manufactureDate));
        children.add(new Property("expirationDate", "dateTime", "The date and time beyond which this device is no longer valid or should not be used (if applicable).", 0, 1, expirationDate));
        children.add(new Property("lotNumber", "string", "Lot number assigned by the manufacturer.", 0, 1, lotNumber));
        children.add(new Property("serialNumber", "string", "The serial number assigned by the organization when the device was manufactured.", 0, 1, serialNumber));
        children.add(new Property("name", "", "This represents the manufacturer's name of the device as provided by the device, from a UDI label, or by a person describing the Device.  This typically would be used when a person provides the name(s) or when the device represents one of the names available from DeviceDefinition.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("modelNumber", "string", "The manufacturer's model number for the device.", 0, 1, modelNumber));
        children.add(new Property("partNumber", "string", "The part number or catalog number of the device.", 0, 1, partNumber));
        children.add(new Property("category", "CodeableConcept", "Devices may be associated with one or more categories.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("type", "CodeableConcept", "The kind or type of device. A device instance may have more than one type - in which case those are the types that apply to the specific instance of the device.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("version", "", "The actual design of the device or software version running on the device.", 0, java.lang.Integer.MAX_VALUE, version));
        children.add(new Property("conformsTo", "", "Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.", 0, java.lang.Integer.MAX_VALUE, conformsTo));
        children.add(new Property("property", "", "Static or essentially fixed characteristics or features of the device (e.g., time or timing attributes, resolution, accuracy, intended use or instructions for use, and physical attributes) that are not otherwise captured in more specific attributes.", 0, java.lang.Integer.MAX_VALUE, property));
        children.add(new Property("mode", "CodeableConcept", "The designated condition for performing a task with the device.", 0, 1, mode));
        children.add(new Property("cycle", "Count", "The series of occurrences that repeats during the operation of the device.", 0, 1, cycle));
        children.add(new Property("duration", "Duration", "A measurement of time during the device's operation (e.g., days, hours, mins, etc.).", 0, 1, duration));
        children.add(new Property("owner", "Reference(Organization)", "An organization that is responsible for the provision and ongoing maintenance of the device.", 0, 1, owner));
        children.add(new Property("contact", "ContactPoint", "Contact details for an organization or a particular human that is responsible for the device.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("location", "Reference(Location)", "The place where the device can be found.", 0, 1, location));
        children.add(new Property("url", "uri", "A network address on which the device may be contacted directly.", 0, 1, url));
        children.add(new Property("endpoint", "Reference(Endpoint)", "Technical endpoints providing access to services provided by the device defined at this resource.", 0, java.lang.Integer.MAX_VALUE, endpoint));
        children.add(new Property("gateway", "CodeableReference(Device)", "The linked device acting as a communication controller, data collector, translator, or concentrator for the current device (e.g., mobile phone application that relays a blood pressure device's data).", 0, java.lang.Integer.MAX_VALUE, gateway));
        children.add(new Property("note", "Annotation", "Descriptive information, usage information or implantation information that is not captured in an existing element.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("safety", "CodeableConcept", "Provides additional safety characteristics about a medical device.  For example devices containing latex.", 0, java.lang.Integer.MAX_VALUE, safety));
        children.add(new Property("parent", "Reference(Device)", "The higher level or encompassing device that this device is a logical part of.", 0, 1, parent));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique instance identifiers assigned to a device by manufacturers other organizations or owners.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 1714148973: /*displayName*/  return new Property("displayName", "string", "The name used to display by default when the device is referenced. Based on intent of use by the resource creator, this may reflect one of the names in Device.name, or may be another simple name.", 0, 1, displayName);
        case -1014418093: /*definition*/  return new Property("definition", "CodeableReference(DeviceDefinition)", "The reference to the definition for the device.", 0, 1, definition);
        case -1343558178: /*udiCarrier*/  return new Property("udiCarrier", "", "Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.", 0, java.lang.Integer.MAX_VALUE, udiCarrier);
        case -892481550: /*status*/  return new Property("status", "code", "The Device record status. This is not the status of the device like availability.", 0, 1, status);
        case 804659501: /*availabilityStatus*/  return new Property("availabilityStatus", "CodeableConcept", "The availability of the device.", 0, 1, availabilityStatus);
        case -654468482: /*biologicalSourceEvent*/  return new Property("biologicalSourceEvent", "Identifier", "An identifier that supports traceability to the event during which material in this product from one or more biological entities was obtained or pooled.", 0, 1, biologicalSourceEvent);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "string", "A name of the manufacturer or entity legally responsible for the device.", 0, 1, manufacturer);
        case 416714767: /*manufactureDate*/  return new Property("manufactureDate", "dateTime", "The date and time when the device was manufactured.", 0, 1, manufactureDate);
        case -668811523: /*expirationDate*/  return new Property("expirationDate", "dateTime", "The date and time beyond which this device is no longer valid or should not be used (if applicable).", 0, 1, expirationDate);
        case 462547450: /*lotNumber*/  return new Property("lotNumber", "string", "Lot number assigned by the manufacturer.", 0, 1, lotNumber);
        case 83787357: /*serialNumber*/  return new Property("serialNumber", "string", "The serial number assigned by the organization when the device was manufactured.", 0, 1, serialNumber);
        case 3373707: /*name*/  return new Property("name", "", "This represents the manufacturer's name of the device as provided by the device, from a UDI label, or by a person describing the Device.  This typically would be used when a person provides the name(s) or when the device represents one of the names available from DeviceDefinition.", 0, java.lang.Integer.MAX_VALUE, name);
        case 346619858: /*modelNumber*/  return new Property("modelNumber", "string", "The manufacturer's model number for the device.", 0, 1, modelNumber);
        case -731502308: /*partNumber*/  return new Property("partNumber", "string", "The part number or catalog number of the device.", 0, 1, partNumber);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Devices may be associated with one or more categories.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind or type of device. A device instance may have more than one type - in which case those are the types that apply to the specific instance of the device.", 0, java.lang.Integer.MAX_VALUE, type);
        case 351608024: /*version*/  return new Property("version", "", "The actual design of the device or software version running on the device.", 0, java.lang.Integer.MAX_VALUE, version);
        case 1014198088: /*conformsTo*/  return new Property("conformsTo", "", "Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.", 0, java.lang.Integer.MAX_VALUE, conformsTo);
        case -993141291: /*property*/  return new Property("property", "", "Static or essentially fixed characteristics or features of the device (e.g., time or timing attributes, resolution, accuracy, intended use or instructions for use, and physical attributes) that are not otherwise captured in more specific attributes.", 0, java.lang.Integer.MAX_VALUE, property);
        case 3357091: /*mode*/  return new Property("mode", "CodeableConcept", "The designated condition for performing a task with the device.", 0, 1, mode);
        case 95131878: /*cycle*/  return new Property("cycle", "Count", "The series of occurrences that repeats during the operation of the device.", 0, 1, cycle);
        case -1992012396: /*duration*/  return new Property("duration", "Duration", "A measurement of time during the device's operation (e.g., days, hours, mins, etc.).", 0, 1, duration);
        case 106164915: /*owner*/  return new Property("owner", "Reference(Organization)", "An organization that is responsible for the provision and ongoing maintenance of the device.", 0, 1, owner);
        case 951526432: /*contact*/  return new Property("contact", "ContactPoint", "Contact details for an organization or a particular human that is responsible for the device.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The place where the device can be found.", 0, 1, location);
        case 116079: /*url*/  return new Property("url", "uri", "A network address on which the device may be contacted directly.", 0, 1, url);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "Technical endpoints providing access to services provided by the device defined at this resource.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        case -189118908: /*gateway*/  return new Property("gateway", "CodeableReference(Device)", "The linked device acting as a communication controller, data collector, translator, or concentrator for the current device (e.g., mobile phone application that relays a blood pressure device's data).", 0, java.lang.Integer.MAX_VALUE, gateway);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Descriptive information, usage information or implantation information that is not captured in an existing element.", 0, java.lang.Integer.MAX_VALUE, note);
        case -909893934: /*safety*/  return new Property("safety", "CodeableConcept", "Provides additional safety characteristics about a medical device.  For example devices containing latex.", 0, java.lang.Integer.MAX_VALUE, safety);
        case -995424086: /*parent*/  return new Property("parent", "Reference(Device)", "The higher level or encompassing device that this device is a logical part of.", 0, 1, parent);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 1714148973: /*displayName*/ return this.displayName == null ? new Base[0] : new Base[] {this.displayName}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CodeableReference
        case -1343558178: /*udiCarrier*/ return this.udiCarrier == null ? new Base[0] : this.udiCarrier.toArray(new Base[this.udiCarrier.size()]); // DeviceUdiCarrierComponent
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FHIRDeviceStatus>
        case 804659501: /*availabilityStatus*/ return this.availabilityStatus == null ? new Base[0] : new Base[] {this.availabilityStatus}; // CodeableConcept
        case -654468482: /*biologicalSourceEvent*/ return this.biologicalSourceEvent == null ? new Base[0] : new Base[] {this.biologicalSourceEvent}; // Identifier
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : new Base[] {this.manufacturer}; // StringType
        case 416714767: /*manufactureDate*/ return this.manufactureDate == null ? new Base[0] : new Base[] {this.manufactureDate}; // DateTimeType
        case -668811523: /*expirationDate*/ return this.expirationDate == null ? new Base[0] : new Base[] {this.expirationDate}; // DateTimeType
        case 462547450: /*lotNumber*/ return this.lotNumber == null ? new Base[0] : new Base[] {this.lotNumber}; // StringType
        case 83787357: /*serialNumber*/ return this.serialNumber == null ? new Base[0] : new Base[] {this.serialNumber}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // DeviceNameComponent
        case 346619858: /*modelNumber*/ return this.modelNumber == null ? new Base[0] : new Base[] {this.modelNumber}; // StringType
        case -731502308: /*partNumber*/ return this.partNumber == null ? new Base[0] : new Base[] {this.partNumber}; // StringType
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // DeviceVersionComponent
        case 1014198088: /*conformsTo*/ return this.conformsTo == null ? new Base[0] : this.conformsTo.toArray(new Base[this.conformsTo.size()]); // DeviceConformsToComponent
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // DevicePropertyComponent
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // CodeableConcept
        case 95131878: /*cycle*/ return this.cycle == null ? new Base[0] : new Base[] {this.cycle}; // Count
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // Duration
        case 106164915: /*owner*/ return this.owner == null ? new Base[0] : new Base[] {this.owner}; // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactPoint
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        case -189118908: /*gateway*/ return this.gateway == null ? new Base[0] : this.gateway.toArray(new Base[this.gateway.size()]); // CodeableReference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -909893934: /*safety*/ return this.safety == null ? new Base[0] : this.safety.toArray(new Base[this.safety.size()]); // CodeableConcept
        case -995424086: /*parent*/ return this.parent == null ? new Base[0] : new Base[] {this.parent}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 1714148973: // displayName
          this.displayName = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1343558178: // udiCarrier
          this.getUdiCarrier().add((DeviceUdiCarrierComponent) value); // DeviceUdiCarrierComponent
          return value;
        case -892481550: // status
          value = new FHIRDeviceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FHIRDeviceStatus>
          return value;
        case 804659501: // availabilityStatus
          this.availabilityStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -654468482: // biologicalSourceEvent
          this.biologicalSourceEvent = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -1969347631: // manufacturer
          this.manufacturer = TypeConvertor.castToString(value); // StringType
          return value;
        case 416714767: // manufactureDate
          this.manufactureDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -668811523: // expirationDate
          this.expirationDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 462547450: // lotNumber
          this.lotNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case 83787357: // serialNumber
          this.serialNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.getName().add((DeviceNameComponent) value); // DeviceNameComponent
          return value;
        case 346619858: // modelNumber
          this.modelNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -731502308: // partNumber
          this.partNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 351608024: // version
          this.getVersion().add((DeviceVersionComponent) value); // DeviceVersionComponent
          return value;
        case 1014198088: // conformsTo
          this.getConformsTo().add((DeviceConformsToComponent) value); // DeviceConformsToComponent
          return value;
        case -993141291: // property
          this.getProperty().add((DevicePropertyComponent) value); // DevicePropertyComponent
          return value;
        case 3357091: // mode
          this.mode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 95131878: // cycle
          this.cycle = TypeConvertor.castToCount(value); // Count
          return value;
        case -1992012396: // duration
          this.duration = TypeConvertor.castToDuration(value); // Duration
          return value;
        case 106164915: // owner
          this.owner = TypeConvertor.castToReference(value); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -189118908: // gateway
          this.getGateway().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -909893934: // safety
          this.getSafety().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -995424086: // parent
          this.parent = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("displayName")) {
          this.displayName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("udiCarrier")) {
          this.getUdiCarrier().add((DeviceUdiCarrierComponent) value);
        } else if (name.equals("status")) {
          value = new FHIRDeviceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FHIRDeviceStatus>
        } else if (name.equals("availabilityStatus")) {
          this.availabilityStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("biologicalSourceEvent")) {
          this.biologicalSourceEvent = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("manufacturer")) {
          this.manufacturer = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("manufactureDate")) {
          this.manufactureDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("expirationDate")) {
          this.expirationDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("lotNumber")) {
          this.lotNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("serialNumber")) {
          this.serialNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.getName().add((DeviceNameComponent) value);
        } else if (name.equals("modelNumber")) {
          this.modelNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("partNumber")) {
          this.partNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("version")) {
          this.getVersion().add((DeviceVersionComponent) value);
        } else if (name.equals("conformsTo")) {
          this.getConformsTo().add((DeviceConformsToComponent) value);
        } else if (name.equals("property")) {
          this.getProperty().add((DevicePropertyComponent) value);
        } else if (name.equals("mode")) {
          this.mode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("cycle")) {
          this.cycle = TypeConvertor.castToCount(value); // Count
        } else if (name.equals("duration")) {
          this.duration = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("owner")) {
          this.owner = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else if (name.equals("gateway")) {
          this.getGateway().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("safety")) {
          this.getSafety().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("parent")) {
          this.parent = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 1714148973:  return getDisplayNameElement();
        case -1014418093:  return getDefinition();
        case -1343558178:  return addUdiCarrier(); 
        case -892481550:  return getStatusElement();
        case 804659501:  return getAvailabilityStatus();
        case -654468482:  return getBiologicalSourceEvent();
        case -1969347631:  return getManufacturerElement();
        case 416714767:  return getManufactureDateElement();
        case -668811523:  return getExpirationDateElement();
        case 462547450:  return getLotNumberElement();
        case 83787357:  return getSerialNumberElement();
        case 3373707:  return addName(); 
        case 346619858:  return getModelNumberElement();
        case -731502308:  return getPartNumberElement();
        case 50511102:  return addCategory(); 
        case 3575610:  return addType(); 
        case 351608024:  return addVersion(); 
        case 1014198088:  return addConformsTo(); 
        case -993141291:  return addProperty(); 
        case 3357091:  return getMode();
        case 95131878:  return getCycle();
        case -1992012396:  return getDuration();
        case 106164915:  return getOwner();
        case 951526432:  return addContact(); 
        case 1901043637:  return getLocation();
        case 116079:  return getUrlElement();
        case 1741102485:  return addEndpoint(); 
        case -189118908:  return addGateway(); 
        case 3387378:  return addNote(); 
        case -909893934:  return addSafety(); 
        case -995424086:  return getParent();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 1714148973: /*displayName*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"CodeableReference"};
        case -1343558178: /*udiCarrier*/ return new String[] {};
        case -892481550: /*status*/ return new String[] {"code"};
        case 804659501: /*availabilityStatus*/ return new String[] {"CodeableConcept"};
        case -654468482: /*biologicalSourceEvent*/ return new String[] {"Identifier"};
        case -1969347631: /*manufacturer*/ return new String[] {"string"};
        case 416714767: /*manufactureDate*/ return new String[] {"dateTime"};
        case -668811523: /*expirationDate*/ return new String[] {"dateTime"};
        case 462547450: /*lotNumber*/ return new String[] {"string"};
        case 83787357: /*serialNumber*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {};
        case 346619858: /*modelNumber*/ return new String[] {"string"};
        case -731502308: /*partNumber*/ return new String[] {"string"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 351608024: /*version*/ return new String[] {};
        case 1014198088: /*conformsTo*/ return new String[] {};
        case -993141291: /*property*/ return new String[] {};
        case 3357091: /*mode*/ return new String[] {"CodeableConcept"};
        case 95131878: /*cycle*/ return new String[] {"Count"};
        case -1992012396: /*duration*/ return new String[] {"Duration"};
        case 106164915: /*owner*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ContactPoint"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 116079: /*url*/ return new String[] {"uri"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        case -189118908: /*gateway*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -909893934: /*safety*/ return new String[] {"CodeableConcept"};
        case -995424086: /*parent*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("displayName")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.displayName");
        }
        else if (name.equals("definition")) {
          this.definition = new CodeableReference();
          return this.definition;
        }
        else if (name.equals("udiCarrier")) {
          return addUdiCarrier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.status");
        }
        else if (name.equals("availabilityStatus")) {
          this.availabilityStatus = new CodeableConcept();
          return this.availabilityStatus;
        }
        else if (name.equals("biologicalSourceEvent")) {
          this.biologicalSourceEvent = new Identifier();
          return this.biologicalSourceEvent;
        }
        else if (name.equals("manufacturer")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.manufacturer");
        }
        else if (name.equals("manufactureDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.manufactureDate");
        }
        else if (name.equals("expirationDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.expirationDate");
        }
        else if (name.equals("lotNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.lotNumber");
        }
        else if (name.equals("serialNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.serialNumber");
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("modelNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.modelNumber");
        }
        else if (name.equals("partNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.partNumber");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("version")) {
          return addVersion();
        }
        else if (name.equals("conformsTo")) {
          return addConformsTo();
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("mode")) {
          this.mode = new CodeableConcept();
          return this.mode;
        }
        else if (name.equals("cycle")) {
          this.cycle = new Count();
          return this.cycle;
        }
        else if (name.equals("duration")) {
          this.duration = new Duration();
          return this.duration;
        }
        else if (name.equals("owner")) {
          this.owner = new Reference();
          return this.owner;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property Device.url");
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else if (name.equals("gateway")) {
          return addGateway();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("safety")) {
          return addSafety();
        }
        else if (name.equals("parent")) {
          this.parent = new Reference();
          return this.parent;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Device";

  }

      public Device copy() {
        Device dst = new Device();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Device dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.displayName = displayName == null ? null : displayName.copy();
        dst.definition = definition == null ? null : definition.copy();
        if (udiCarrier != null) {
          dst.udiCarrier = new ArrayList<DeviceUdiCarrierComponent>();
          for (DeviceUdiCarrierComponent i : udiCarrier)
            dst.udiCarrier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.availabilityStatus = availabilityStatus == null ? null : availabilityStatus.copy();
        dst.biologicalSourceEvent = biologicalSourceEvent == null ? null : biologicalSourceEvent.copy();
        dst.manufacturer = manufacturer == null ? null : manufacturer.copy();
        dst.manufactureDate = manufactureDate == null ? null : manufactureDate.copy();
        dst.expirationDate = expirationDate == null ? null : expirationDate.copy();
        dst.lotNumber = lotNumber == null ? null : lotNumber.copy();
        dst.serialNumber = serialNumber == null ? null : serialNumber.copy();
        if (name != null) {
          dst.name = new ArrayList<DeviceNameComponent>();
          for (DeviceNameComponent i : name)
            dst.name.add(i.copy());
        };
        dst.modelNumber = modelNumber == null ? null : modelNumber.copy();
        dst.partNumber = partNumber == null ? null : partNumber.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (version != null) {
          dst.version = new ArrayList<DeviceVersionComponent>();
          for (DeviceVersionComponent i : version)
            dst.version.add(i.copy());
        };
        if (conformsTo != null) {
          dst.conformsTo = new ArrayList<DeviceConformsToComponent>();
          for (DeviceConformsToComponent i : conformsTo)
            dst.conformsTo.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<DevicePropertyComponent>();
          for (DevicePropertyComponent i : property)
            dst.property.add(i.copy());
        };
        dst.mode = mode == null ? null : mode.copy();
        dst.cycle = cycle == null ? null : cycle.copy();
        dst.duration = duration == null ? null : duration.copy();
        dst.owner = owner == null ? null : owner.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactPoint>();
          for (ContactPoint i : contact)
            dst.contact.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        dst.url = url == null ? null : url.copy();
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
        if (gateway != null) {
          dst.gateway = new ArrayList<CodeableReference>();
          for (CodeableReference i : gateway)
            dst.gateway.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (safety != null) {
          dst.safety = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : safety)
            dst.safety.add(i.copy());
        };
        dst.parent = parent == null ? null : parent.copy();
      }

      protected Device typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Device))
          return false;
        Device o = (Device) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(displayName, o.displayName, true)
           && compareDeep(definition, o.definition, true) && compareDeep(udiCarrier, o.udiCarrier, true) && compareDeep(status, o.status, true)
           && compareDeep(availabilityStatus, o.availabilityStatus, true) && compareDeep(biologicalSourceEvent, o.biologicalSourceEvent, true)
           && compareDeep(manufacturer, o.manufacturer, true) && compareDeep(manufactureDate, o.manufactureDate, true)
           && compareDeep(expirationDate, o.expirationDate, true) && compareDeep(lotNumber, o.lotNumber, true)
           && compareDeep(serialNumber, o.serialNumber, true) && compareDeep(name, o.name, true) && compareDeep(modelNumber, o.modelNumber, true)
           && compareDeep(partNumber, o.partNumber, true) && compareDeep(category, o.category, true) && compareDeep(type, o.type, true)
           && compareDeep(version, o.version, true) && compareDeep(conformsTo, o.conformsTo, true) && compareDeep(property, o.property, true)
           && compareDeep(mode, o.mode, true) && compareDeep(cycle, o.cycle, true) && compareDeep(duration, o.duration, true)
           && compareDeep(owner, o.owner, true) && compareDeep(contact, o.contact, true) && compareDeep(location, o.location, true)
           && compareDeep(url, o.url, true) && compareDeep(endpoint, o.endpoint, true) && compareDeep(gateway, o.gateway, true)
           && compareDeep(note, o.note, true) && compareDeep(safety, o.safety, true) && compareDeep(parent, o.parent, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Device))
          return false;
        Device o = (Device) other_;
        return compareValues(displayName, o.displayName, true) && compareValues(status, o.status, true) && compareValues(manufacturer, o.manufacturer, true)
           && compareValues(manufactureDate, o.manufactureDate, true) && compareValues(expirationDate, o.expirationDate, true)
           && compareValues(lotNumber, o.lotNumber, true) && compareValues(serialNumber, o.serialNumber, true)
           && compareValues(modelNumber, o.modelNumber, true) && compareValues(partNumber, o.partNumber, true)
           && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, displayName, definition
          , udiCarrier, status, availabilityStatus, biologicalSourceEvent, manufacturer, manufactureDate
          , expirationDate, lotNumber, serialNumber, name, modelNumber, partNumber, category
          , type, version, conformsTo, property, mode, cycle, duration, owner, contact
          , location, url, endpoint, gateway, note, safety, parent);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Device;
   }

 /**
   * Search parameter: <b>biological-source-event</b>
   * <p>
   * Description: <b>The biological source for the device</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.biologicalSourceEvent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="biological-source-event", path="Device.biologicalSourceEvent", description="The biological source for the device", type="token" )
  public static final String SP_BIOLOGICAL_SOURCE_EVENT = "biological-source-event";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>biological-source-event</b>
   * <p>
   * Description: <b>The biological source for the device</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.biologicalSourceEvent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BIOLOGICAL_SOURCE_EVENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BIOLOGICAL_SOURCE_EVENT);

 /**
   * Search parameter: <b>code-value-concept</b>
   * <p>
   * Description: <b>Code and value parameter pair</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Device</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code-value-concept", path="Device", description="Code and value parameter pair", type="composite", compositeOf={"specification", "version"} )
  public static final String SP_CODE_VALUE_CONCEPT = "code-value-concept";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code-value-concept</b>
   * <p>
   * Description: <b>Code and value parameter pair</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Device</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.StringClientParam> CODE_VALUE_CONCEPT = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.StringClientParam>(SP_CODE_VALUE_CONCEPT);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The definition / type of the device (code)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.definition.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="Device.definition.concept", description="The definition / type of the device (code)", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The definition / type of the device (code)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.definition.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>definition</b>
   * <p>
   * Description: <b>The definition / type of the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.definition.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="definition", path="Device.definition.reference", description="The definition / type of the device", type="reference", target={DeviceDefinition.class } )
  public static final String SP_DEFINITION = "definition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>definition</b>
   * <p>
   * Description: <b>The definition / type of the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.definition.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEFINITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEFINITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Device:definition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEFINITION = new ca.uhn.fhir.model.api.Include("Device:definition").toLocked();

 /**
   * Search parameter: <b>device-name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in Device.name or Device.type.</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.name.value | Device.type.coding.display | Device.type.text</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device-name", path="Device.name.value | Device.type.coding.display | Device.type.text", description="A server defined search that may match any of the string fields in Device.name or Device.type.", type="string" )
  public static final String SP_DEVICE_NAME = "device-name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device-name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in Device.name or Device.type.</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.name.value | Device.type.coding.display | Device.type.text</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DEVICE_NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DEVICE_NAME);

 /**
   * Search parameter: <b>expiration-date</b>
   * <p>
   * Description: <b>The expiration date of the device</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Device.expirationDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="expiration-date", path="Device.expirationDate", description="The expiration date of the device", type="date" )
  public static final String SP_EXPIRATION_DATE = "expiration-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>expiration-date</b>
   * <p>
   * Description: <b>The expiration date of the device</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Device.expirationDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EXPIRATION_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EXPIRATION_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Instance id from manufacturer, owner, and others</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Device.identifier", description="Instance id from manufacturer, owner, and others", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Instance id from manufacturer, owner, and others</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>A location, where the resource is found</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="Device.location", description="A location, where the resource is found", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>A location, where the resource is found</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Device:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("Device:location").toLocked();

 /**
   * Search parameter: <b>lot-number</b>
   * <p>
   * Description: <b>The lot number of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.lotNumber</b><br>
   * </p>
   */
  @SearchParamDefinition(name="lot-number", path="Device.lotNumber", description="The lot number of the device", type="string" )
  public static final String SP_LOT_NUMBER = "lot-number";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>lot-number</b>
   * <p>
   * Description: <b>The lot number of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.lotNumber</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam LOT_NUMBER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_LOT_NUMBER);

 /**
   * Search parameter: <b>manufacture-date</b>
   * <p>
   * Description: <b>The manufacture date of the device</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Device.manufactureDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacture-date", path="Device.manufactureDate", description="The manufacture date of the device", type="date" )
  public static final String SP_MANUFACTURE_DATE = "manufacture-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacture-date</b>
   * <p>
   * Description: <b>The manufacture date of the device</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Device.manufactureDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam MANUFACTURE_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_MANUFACTURE_DATE);

 /**
   * Search parameter: <b>manufacturer</b>
   * <p>
   * Description: <b>The manufacturer of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.manufacturer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacturer", path="Device.manufacturer", description="The manufacturer of the device", type="string" )
  public static final String SP_MANUFACTURER = "manufacturer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacturer</b>
   * <p>
   * Description: <b>The manufacturer of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.manufacturer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam MANUFACTURER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_MANUFACTURER);

 /**
   * Search parameter: <b>model</b>
   * <p>
   * Description: <b>The model of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.modelNumber</b><br>
   * </p>
   */
  @SearchParamDefinition(name="model", path="Device.modelNumber", description="The model of the device", type="string" )
  public static final String SP_MODEL = "model";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>model</b>
   * <p>
   * Description: <b>The model of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.modelNumber</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam MODEL = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_MODEL);

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The organization responsible for the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.owner</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="Device.owner", description="The organization responsible for the device", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The organization responsible for the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.owner</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Device:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("Device:organization").toLocked();

 /**
   * Search parameter: <b>parent</b>
   * <p>
   * Description: <b>The parent device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.parent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="parent", path="Device.parent", description="The parent device", type="reference", target={Device.class } )
  public static final String SP_PARENT = "parent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>parent</b>
   * <p>
   * Description: <b>The parent device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Device.parent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Device:parent</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARENT = new ca.uhn.fhir.model.api.Include("Device:parent").toLocked();

 /**
   * Search parameter: <b>serial-number</b>
   * <p>
   * Description: <b>The serial number of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.serialNumber | Device.identifier.where(type='SNO')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="serial-number", path="Device.serialNumber | Device.identifier.where(type='SNO')", description="The serial number of the device", type="string" )
  public static final String SP_SERIAL_NUMBER = "serial-number";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>serial-number</b>
   * <p>
   * Description: <b>The serial number of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.serialNumber | Device.identifier.where(type='SNO')</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam SERIAL_NUMBER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_SERIAL_NUMBER);

 /**
   * Search parameter: <b>specification-version</b>
   * <p>
   * Description: <b>A composite of both specification and version</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Device.conformsTo</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specification-version", path="Device.conformsTo", description="A composite of both specification and version", type="composite", compositeOf={"specification", "version"} )
  public static final String SP_SPECIFICATION_VERSION = "specification-version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specification-version</b>
   * <p>
   * Description: <b>A composite of both specification and version</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Device.conformsTo</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.StringClientParam> SPECIFICATION_VERSION = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.StringClientParam>(SP_SPECIFICATION_VERSION);

 /**
   * Search parameter: <b>specification</b>
   * <p>
   * Description: <b>The standards, specifications, or formal guidances.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.conformsTo.specification</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specification", path="Device.conformsTo.specification", description="The standards, specifications, or formal guidances.", type="token" )
  public static final String SP_SPECIFICATION = "specification";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specification</b>
   * <p>
   * Description: <b>The standards, specifications, or formal guidances.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.conformsTo.specification</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIFICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIFICATION);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>active | inactive | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Device.status", description="active | inactive | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>active | inactive | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The type of the device</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="Device.type", description="The type of the device", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The type of the device</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Device.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);

 /**
   * Search parameter: <b>udi-carrier</b>
   * <p>
   * Description: <b>UDI Barcode (RFID or other technology) string in *HRF* format.</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.udiCarrier.carrierHRF</b><br>
   * </p>
   */
  @SearchParamDefinition(name="udi-carrier", path="Device.udiCarrier.carrierHRF", description="UDI Barcode (RFID or other technology) string in *HRF* format.", type="string" )
  public static final String SP_UDI_CARRIER = "udi-carrier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>udi-carrier</b>
   * <p>
   * Description: <b>UDI Barcode (RFID or other technology) string in *HRF* format.</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.udiCarrier.carrierHRF</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam UDI_CARRIER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_UDI_CARRIER);

 /**
   * Search parameter: <b>udi-di</b>
   * <p>
   * Description: <b>The udi Device Identifier (DI)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.udiCarrier.deviceIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="udi-di", path="Device.udiCarrier.deviceIdentifier", description="The udi Device Identifier (DI)", type="string" )
  public static final String SP_UDI_DI = "udi-di";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>udi-di</b>
   * <p>
   * Description: <b>The udi Device Identifier (DI)</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.udiCarrier.deviceIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam UDI_DI = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_UDI_DI);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Network address to contact device</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Device.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="Device.url", description="Network address to contact device", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Network address to contact device</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Device.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The specific version of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.version.value</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="Device.version.value", description="The specific version of the device", type="string" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The specific version of the device</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Device.version.value</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam VERSION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_VERSION);


}

