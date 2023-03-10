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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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
 * This is a specialized resource that defines the characteristics and capabilities of a device.
 */
@ResourceDef(name="DeviceDefinition", profile="http://hl7.org/fhir/StructureDefinition/DeviceDefinition")
public class DeviceDefinition extends DomainResource {

    public enum DeviceCorrectiveActionScope {
        /**
         * The corrective action was intended for all units of the same model.
         */
        MODEL, 
        /**
         * The corrective action was intended for a specific batch of units identified by a lot number.
         */
        LOTNUMBERS, 
        /**
         * The corrective action was intended for an individual unit (or a set of units) individually identified by serial number.
         */
        SERIALNUMBERS, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DeviceCorrectiveActionScope fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("model".equals(codeString))
          return MODEL;
        if ("lot-numbers".equals(codeString))
          return LOTNUMBERS;
        if ("serial-numbers".equals(codeString))
          return SERIALNUMBERS;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DeviceCorrectiveActionScope code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case MODEL: return "model";
            case LOTNUMBERS: return "lot-numbers";
            case SERIALNUMBERS: return "serial-numbers";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case MODEL: return "http://hl7.org/fhir/device-correctiveactionscope";
            case LOTNUMBERS: return "http://hl7.org/fhir/device-correctiveactionscope";
            case SERIALNUMBERS: return "http://hl7.org/fhir/device-correctiveactionscope";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case MODEL: return "The corrective action was intended for all units of the same model.";
            case LOTNUMBERS: return "The corrective action was intended for a specific batch of units identified by a lot number.";
            case SERIALNUMBERS: return "The corrective action was intended for an individual unit (or a set of units) individually identified by serial number.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MODEL: return "Model";
            case LOTNUMBERS: return "Lot Numbers";
            case SERIALNUMBERS: return "Serial Numbers";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DeviceCorrectiveActionScopeEnumFactory implements EnumFactory<DeviceCorrectiveActionScope> {
    public DeviceCorrectiveActionScope fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("model".equals(codeString))
          return DeviceCorrectiveActionScope.MODEL;
        if ("lot-numbers".equals(codeString))
          return DeviceCorrectiveActionScope.LOTNUMBERS;
        if ("serial-numbers".equals(codeString))
          return DeviceCorrectiveActionScope.SERIALNUMBERS;
        throw new IllegalArgumentException("Unknown DeviceCorrectiveActionScope code '"+codeString+"'");
        }
        public Enumeration<DeviceCorrectiveActionScope> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DeviceCorrectiveActionScope>(this, DeviceCorrectiveActionScope.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<DeviceCorrectiveActionScope>(this, DeviceCorrectiveActionScope.NULL, code);
        if ("model".equals(codeString))
          return new Enumeration<DeviceCorrectiveActionScope>(this, DeviceCorrectiveActionScope.MODEL, code);
        if ("lot-numbers".equals(codeString))
          return new Enumeration<DeviceCorrectiveActionScope>(this, DeviceCorrectiveActionScope.LOTNUMBERS, code);
        if ("serial-numbers".equals(codeString))
          return new Enumeration<DeviceCorrectiveActionScope>(this, DeviceCorrectiveActionScope.SERIALNUMBERS, code);
        throw new FHIRException("Unknown DeviceCorrectiveActionScope code '"+codeString+"'");
        }
    public String toCode(DeviceCorrectiveActionScope code) {
      if (code == DeviceCorrectiveActionScope.MODEL)
        return "model";
      if (code == DeviceCorrectiveActionScope.LOTNUMBERS)
        return "lot-numbers";
      if (code == DeviceCorrectiveActionScope.SERIALNUMBERS)
        return "serial-numbers";
      return "?";
      }
    public String toSystem(DeviceCorrectiveActionScope code) {
      return code.getSystem();
      }
    }

    public enum DeviceDefinitionRegulatoryIdentifierType {
        /**
         * EUDAMED's basic UDI-DI identifier.
         */
        BASIC, 
        /**
         * EUDAMED's master UDI-DI identifier.
         */
        MASTER, 
        /**
         * The identifier is a license number.
         */
        LICENSE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DeviceDefinitionRegulatoryIdentifierType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("basic".equals(codeString))
          return BASIC;
        if ("master".equals(codeString))
          return MASTER;
        if ("license".equals(codeString))
          return LICENSE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DeviceDefinitionRegulatoryIdentifierType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BASIC: return "basic";
            case MASTER: return "master";
            case LICENSE: return "license";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case BASIC: return "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type";
            case MASTER: return "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type";
            case LICENSE: return "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case BASIC: return "EUDAMED's basic UDI-DI identifier.";
            case MASTER: return "EUDAMED's master UDI-DI identifier.";
            case LICENSE: return "The identifier is a license number.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BASIC: return "Basic";
            case MASTER: return "Master";
            case LICENSE: return "License";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DeviceDefinitionRegulatoryIdentifierTypeEnumFactory implements EnumFactory<DeviceDefinitionRegulatoryIdentifierType> {
    public DeviceDefinitionRegulatoryIdentifierType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("basic".equals(codeString))
          return DeviceDefinitionRegulatoryIdentifierType.BASIC;
        if ("master".equals(codeString))
          return DeviceDefinitionRegulatoryIdentifierType.MASTER;
        if ("license".equals(codeString))
          return DeviceDefinitionRegulatoryIdentifierType.LICENSE;
        throw new IllegalArgumentException("Unknown DeviceDefinitionRegulatoryIdentifierType code '"+codeString+"'");
        }
        public Enumeration<DeviceDefinitionRegulatoryIdentifierType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(this, DeviceDefinitionRegulatoryIdentifierType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(this, DeviceDefinitionRegulatoryIdentifierType.NULL, code);
        if ("basic".equals(codeString))
          return new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(this, DeviceDefinitionRegulatoryIdentifierType.BASIC, code);
        if ("master".equals(codeString))
          return new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(this, DeviceDefinitionRegulatoryIdentifierType.MASTER, code);
        if ("license".equals(codeString))
          return new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(this, DeviceDefinitionRegulatoryIdentifierType.LICENSE, code);
        throw new FHIRException("Unknown DeviceDefinitionRegulatoryIdentifierType code '"+codeString+"'");
        }
    public String toCode(DeviceDefinitionRegulatoryIdentifierType code) {
      if (code == DeviceDefinitionRegulatoryIdentifierType.BASIC)
        return "basic";
      if (code == DeviceDefinitionRegulatoryIdentifierType.MASTER)
        return "master";
      if (code == DeviceDefinitionRegulatoryIdentifierType.LICENSE)
        return "license";
      return "?";
      }
    public String toSystem(DeviceDefinitionRegulatoryIdentifierType code) {
      return code.getSystem();
      }
    }

    public enum DeviceProductionIdentifierInUDI {
        /**
         * The label includes the lot number.
         */
        LOTNUMBER, 
        /**
         * The label includes the manufacture date.
         */
        MANUFACTUREDDATE, 
        /**
         * The label includes the serial number.
         */
        SERIALNUMBER, 
        /**
         * The label includes the expiration date.
         */
        EXPIRATIONDATE, 
        /**
         * The label includes the biological source identifier.
         */
        BIOLOGICALSOURCE, 
        /**
         * The label includes the software version.
         */
        SOFTWAREVERSION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DeviceProductionIdentifierInUDI fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("lot-number".equals(codeString))
          return LOTNUMBER;
        if ("manufactured-date".equals(codeString))
          return MANUFACTUREDDATE;
        if ("serial-number".equals(codeString))
          return SERIALNUMBER;
        if ("expiration-date".equals(codeString))
          return EXPIRATIONDATE;
        if ("biological-source".equals(codeString))
          return BIOLOGICALSOURCE;
        if ("software-version".equals(codeString))
          return SOFTWAREVERSION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DeviceProductionIdentifierInUDI code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case LOTNUMBER: return "lot-number";
            case MANUFACTUREDDATE: return "manufactured-date";
            case SERIALNUMBER: return "serial-number";
            case EXPIRATIONDATE: return "expiration-date";
            case BIOLOGICALSOURCE: return "biological-source";
            case SOFTWAREVERSION: return "software-version";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case LOTNUMBER: return "http://hl7.org/fhir/device-productidentifierinudi";
            case MANUFACTUREDDATE: return "http://hl7.org/fhir/device-productidentifierinudi";
            case SERIALNUMBER: return "http://hl7.org/fhir/device-productidentifierinudi";
            case EXPIRATIONDATE: return "http://hl7.org/fhir/device-productidentifierinudi";
            case BIOLOGICALSOURCE: return "http://hl7.org/fhir/device-productidentifierinudi";
            case SOFTWAREVERSION: return "http://hl7.org/fhir/device-productidentifierinudi";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case LOTNUMBER: return "The label includes the lot number.";
            case MANUFACTUREDDATE: return "The label includes the manufacture date.";
            case SERIALNUMBER: return "The label includes the serial number.";
            case EXPIRATIONDATE: return "The label includes the expiration date.";
            case BIOLOGICALSOURCE: return "The label includes the biological source identifier.";
            case SOFTWAREVERSION: return "The label includes the software version.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case LOTNUMBER: return "Lot Number";
            case MANUFACTUREDDATE: return "Manufactured date";
            case SERIALNUMBER: return "Serial Number";
            case EXPIRATIONDATE: return "Expiration date";
            case BIOLOGICALSOURCE: return "Biological source";
            case SOFTWAREVERSION: return "Software Version";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DeviceProductionIdentifierInUDIEnumFactory implements EnumFactory<DeviceProductionIdentifierInUDI> {
    public DeviceProductionIdentifierInUDI fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("lot-number".equals(codeString))
          return DeviceProductionIdentifierInUDI.LOTNUMBER;
        if ("manufactured-date".equals(codeString))
          return DeviceProductionIdentifierInUDI.MANUFACTUREDDATE;
        if ("serial-number".equals(codeString))
          return DeviceProductionIdentifierInUDI.SERIALNUMBER;
        if ("expiration-date".equals(codeString))
          return DeviceProductionIdentifierInUDI.EXPIRATIONDATE;
        if ("biological-source".equals(codeString))
          return DeviceProductionIdentifierInUDI.BIOLOGICALSOURCE;
        if ("software-version".equals(codeString))
          return DeviceProductionIdentifierInUDI.SOFTWAREVERSION;
        throw new IllegalArgumentException("Unknown DeviceProductionIdentifierInUDI code '"+codeString+"'");
        }
        public Enumeration<DeviceProductionIdentifierInUDI> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.NULL, code);
        if ("lot-number".equals(codeString))
          return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.LOTNUMBER, code);
        if ("manufactured-date".equals(codeString))
          return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.MANUFACTUREDDATE, code);
        if ("serial-number".equals(codeString))
          return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.SERIALNUMBER, code);
        if ("expiration-date".equals(codeString))
          return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.EXPIRATIONDATE, code);
        if ("biological-source".equals(codeString))
          return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.BIOLOGICALSOURCE, code);
        if ("software-version".equals(codeString))
          return new Enumeration<DeviceProductionIdentifierInUDI>(this, DeviceProductionIdentifierInUDI.SOFTWAREVERSION, code);
        throw new FHIRException("Unknown DeviceProductionIdentifierInUDI code '"+codeString+"'");
        }
    public String toCode(DeviceProductionIdentifierInUDI code) {
      if (code == DeviceProductionIdentifierInUDI.LOTNUMBER)
        return "lot-number";
      if (code == DeviceProductionIdentifierInUDI.MANUFACTUREDDATE)
        return "manufactured-date";
      if (code == DeviceProductionIdentifierInUDI.SERIALNUMBER)
        return "serial-number";
      if (code == DeviceProductionIdentifierInUDI.EXPIRATIONDATE)
        return "expiration-date";
      if (code == DeviceProductionIdentifierInUDI.BIOLOGICALSOURCE)
        return "biological-source";
      if (code == DeviceProductionIdentifierInUDI.SOFTWAREVERSION)
        return "software-version";
      return "?";
      }
    public String toSystem(DeviceProductionIdentifierInUDI code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DeviceDefinitionUdiDeviceIdentifierComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.
         */
        @Child(name = "deviceIdentifier", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier", formalDefinition="The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier." )
        protected StringType deviceIdentifier;

        /**
         * The organization that assigns the identifier algorithm.
         */
        @Child(name = "issuer", type = {UriType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The organization that assigns the identifier algorithm", formalDefinition="The organization that assigns the identifier algorithm." )
        protected UriType issuer;

        /**
         * The jurisdiction to which the deviceIdentifier applies.
         */
        @Child(name = "jurisdiction", type = {UriType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The jurisdiction to which the deviceIdentifier applies", formalDefinition="The jurisdiction to which the deviceIdentifier applies." )
        protected UriType jurisdiction;

        /**
         * Indicates where and when the device is available on the market.
         */
        @Child(name = "marketDistribution", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Indicates whether and when the device is available on the market", formalDefinition="Indicates where and when the device is available on the market." )
        protected List<UdiDeviceIdentifierMarketDistributionComponent> marketDistribution;

        private static final long serialVersionUID = -1819796108L;

    /**
     * Constructor
     */
      public DeviceDefinitionUdiDeviceIdentifierComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionUdiDeviceIdentifierComponent(String deviceIdentifier, String issuer, String jurisdiction) {
        super();
        this.setDeviceIdentifier(deviceIdentifier);
        this.setIssuer(issuer);
        this.setJurisdiction(jurisdiction);
      }

        /**
         * @return {@link #deviceIdentifier} (The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.). This is the underlying object with id, value and extensions. The accessor "getDeviceIdentifier" gives direct access to the value
         */
        public StringType getDeviceIdentifierElement() { 
          if (this.deviceIdentifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionUdiDeviceIdentifierComponent.deviceIdentifier");
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
         * @param value {@link #deviceIdentifier} (The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.). This is the underlying object with id, value and extensions. The accessor "getDeviceIdentifier" gives direct access to the value
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setDeviceIdentifierElement(StringType value) { 
          this.deviceIdentifier = value;
          return this;
        }

        /**
         * @return The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.
         */
        public String getDeviceIdentifier() { 
          return this.deviceIdentifier == null ? null : this.deviceIdentifier.getValue();
        }

        /**
         * @param value The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setDeviceIdentifier(String value) { 
            if (this.deviceIdentifier == null)
              this.deviceIdentifier = new StringType();
            this.deviceIdentifier.setValue(value);
          return this;
        }

        /**
         * @return {@link #issuer} (The organization that assigns the identifier algorithm.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
         */
        public UriType getIssuerElement() { 
          if (this.issuer == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionUdiDeviceIdentifierComponent.issuer");
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
         * @param value {@link #issuer} (The organization that assigns the identifier algorithm.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setIssuerElement(UriType value) { 
          this.issuer = value;
          return this;
        }

        /**
         * @return The organization that assigns the identifier algorithm.
         */
        public String getIssuer() { 
          return this.issuer == null ? null : this.issuer.getValue();
        }

        /**
         * @param value The organization that assigns the identifier algorithm.
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setIssuer(String value) { 
            if (this.issuer == null)
              this.issuer = new UriType();
            this.issuer.setValue(value);
          return this;
        }

        /**
         * @return {@link #jurisdiction} (The jurisdiction to which the deviceIdentifier applies.). This is the underlying object with id, value and extensions. The accessor "getJurisdiction" gives direct access to the value
         */
        public UriType getJurisdictionElement() { 
          if (this.jurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionUdiDeviceIdentifierComponent.jurisdiction");
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
         * @param value {@link #jurisdiction} (The jurisdiction to which the deviceIdentifier applies.). This is the underlying object with id, value and extensions. The accessor "getJurisdiction" gives direct access to the value
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setJurisdictionElement(UriType value) { 
          this.jurisdiction = value;
          return this;
        }

        /**
         * @return The jurisdiction to which the deviceIdentifier applies.
         */
        public String getJurisdiction() { 
          return this.jurisdiction == null ? null : this.jurisdiction.getValue();
        }

        /**
         * @param value The jurisdiction to which the deviceIdentifier applies.
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setJurisdiction(String value) { 
            if (this.jurisdiction == null)
              this.jurisdiction = new UriType();
            this.jurisdiction.setValue(value);
          return this;
        }

        /**
         * @return {@link #marketDistribution} (Indicates where and when the device is available on the market.)
         */
        public List<UdiDeviceIdentifierMarketDistributionComponent> getMarketDistribution() { 
          if (this.marketDistribution == null)
            this.marketDistribution = new ArrayList<UdiDeviceIdentifierMarketDistributionComponent>();
          return this.marketDistribution;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent setMarketDistribution(List<UdiDeviceIdentifierMarketDistributionComponent> theMarketDistribution) { 
          this.marketDistribution = theMarketDistribution;
          return this;
        }

        public boolean hasMarketDistribution() { 
          if (this.marketDistribution == null)
            return false;
          for (UdiDeviceIdentifierMarketDistributionComponent item : this.marketDistribution)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public UdiDeviceIdentifierMarketDistributionComponent addMarketDistribution() { //3
          UdiDeviceIdentifierMarketDistributionComponent t = new UdiDeviceIdentifierMarketDistributionComponent();
          if (this.marketDistribution == null)
            this.marketDistribution = new ArrayList<UdiDeviceIdentifierMarketDistributionComponent>();
          this.marketDistribution.add(t);
          return t;
        }

        public DeviceDefinitionUdiDeviceIdentifierComponent addMarketDistribution(UdiDeviceIdentifierMarketDistributionComponent t) { //3
          if (t == null)
            return this;
          if (this.marketDistribution == null)
            this.marketDistribution = new ArrayList<UdiDeviceIdentifierMarketDistributionComponent>();
          this.marketDistribution.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #marketDistribution}, creating it if it does not already exist {3}
         */
        public UdiDeviceIdentifierMarketDistributionComponent getMarketDistributionFirstRep() { 
          if (getMarketDistribution().isEmpty()) {
            addMarketDistribution();
          }
          return getMarketDistribution().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("deviceIdentifier", "string", "The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.", 0, 1, deviceIdentifier));
          children.add(new Property("issuer", "uri", "The organization that assigns the identifier algorithm.", 0, 1, issuer));
          children.add(new Property("jurisdiction", "uri", "The jurisdiction to which the deviceIdentifier applies.", 0, 1, jurisdiction));
          children.add(new Property("marketDistribution", "", "Indicates where and when the device is available on the market.", 0, java.lang.Integer.MAX_VALUE, marketDistribution));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1322005407: /*deviceIdentifier*/  return new Property("deviceIdentifier", "string", "The identifier that is to be associated with every Device that references this DeviceDefintiion for the issuer and jurisdiction provided in the DeviceDefinition.udiDeviceIdentifier.", 0, 1, deviceIdentifier);
          case -1179159879: /*issuer*/  return new Property("issuer", "uri", "The organization that assigns the identifier algorithm.", 0, 1, issuer);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "uri", "The jurisdiction to which the deviceIdentifier applies.", 0, 1, jurisdiction);
          case 530037984: /*marketDistribution*/  return new Property("marketDistribution", "", "Indicates where and when the device is available on the market.", 0, java.lang.Integer.MAX_VALUE, marketDistribution);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1322005407: /*deviceIdentifier*/ return this.deviceIdentifier == null ? new Base[0] : new Base[] {this.deviceIdentifier}; // StringType
        case -1179159879: /*issuer*/ return this.issuer == null ? new Base[0] : new Base[] {this.issuer}; // UriType
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : new Base[] {this.jurisdiction}; // UriType
        case 530037984: /*marketDistribution*/ return this.marketDistribution == null ? new Base[0] : this.marketDistribution.toArray(new Base[this.marketDistribution.size()]); // UdiDeviceIdentifierMarketDistributionComponent
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
        case 530037984: // marketDistribution
          this.getMarketDistribution().add((UdiDeviceIdentifierMarketDistributionComponent) value); // UdiDeviceIdentifierMarketDistributionComponent
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
        } else if (name.equals("marketDistribution")) {
          this.getMarketDistribution().add((UdiDeviceIdentifierMarketDistributionComponent) value);
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
        case 530037984:  return addMarketDistribution(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1322005407: /*deviceIdentifier*/ return new String[] {"string"};
        case -1179159879: /*issuer*/ return new String[] {"uri"};
        case -507075711: /*jurisdiction*/ return new String[] {"uri"};
        case 530037984: /*marketDistribution*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("deviceIdentifier")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.udiDeviceIdentifier.deviceIdentifier");
        }
        else if (name.equals("issuer")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.udiDeviceIdentifier.issuer");
        }
        else if (name.equals("jurisdiction")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.udiDeviceIdentifier.jurisdiction");
        }
        else if (name.equals("marketDistribution")) {
          return addMarketDistribution();
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionUdiDeviceIdentifierComponent copy() {
        DeviceDefinitionUdiDeviceIdentifierComponent dst = new DeviceDefinitionUdiDeviceIdentifierComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionUdiDeviceIdentifierComponent dst) {
        super.copyValues(dst);
        dst.deviceIdentifier = deviceIdentifier == null ? null : deviceIdentifier.copy();
        dst.issuer = issuer == null ? null : issuer.copy();
        dst.jurisdiction = jurisdiction == null ? null : jurisdiction.copy();
        if (marketDistribution != null) {
          dst.marketDistribution = new ArrayList<UdiDeviceIdentifierMarketDistributionComponent>();
          for (UdiDeviceIdentifierMarketDistributionComponent i : marketDistribution)
            dst.marketDistribution.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionUdiDeviceIdentifierComponent))
          return false;
        DeviceDefinitionUdiDeviceIdentifierComponent o = (DeviceDefinitionUdiDeviceIdentifierComponent) other_;
        return compareDeep(deviceIdentifier, o.deviceIdentifier, true) && compareDeep(issuer, o.issuer, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(marketDistribution, o.marketDistribution, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionUdiDeviceIdentifierComponent))
          return false;
        DeviceDefinitionUdiDeviceIdentifierComponent o = (DeviceDefinitionUdiDeviceIdentifierComponent) other_;
        return compareValues(deviceIdentifier, o.deviceIdentifier, true) && compareValues(issuer, o.issuer, true)
           && compareValues(jurisdiction, o.jurisdiction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(deviceIdentifier, issuer, jurisdiction
          , marketDistribution);
      }

  public String fhirType() {
    return "DeviceDefinition.udiDeviceIdentifier";

  }

  }

    @Block()
    public static class UdiDeviceIdentifierMarketDistributionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Begin and end dates for the commercial distribution of the device.
         */
        @Child(name = "marketPeriod", type = {Period.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Begin and end dates for the commercial distribution of the device", formalDefinition="Begin and end dates for the commercial distribution of the device." )
        protected Period marketPeriod;

        /**
         * National state or territory to which the marketDistribution recers, typically where the device is commercialized.
         */
        @Child(name = "subJurisdiction", type = {UriType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="National state or territory where the device is commercialized", formalDefinition="National state or territory to which the marketDistribution recers, typically where the device is commercialized." )
        protected UriType subJurisdiction;

        private static final long serialVersionUID = -1459036847L;

    /**
     * Constructor
     */
      public UdiDeviceIdentifierMarketDistributionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public UdiDeviceIdentifierMarketDistributionComponent(Period marketPeriod, String subJurisdiction) {
        super();
        this.setMarketPeriod(marketPeriod);
        this.setSubJurisdiction(subJurisdiction);
      }

        /**
         * @return {@link #marketPeriod} (Begin and end dates for the commercial distribution of the device.)
         */
        public Period getMarketPeriod() { 
          if (this.marketPeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create UdiDeviceIdentifierMarketDistributionComponent.marketPeriod");
            else if (Configuration.doAutoCreate())
              this.marketPeriod = new Period(); // cc
          return this.marketPeriod;
        }

        public boolean hasMarketPeriod() { 
          return this.marketPeriod != null && !this.marketPeriod.isEmpty();
        }

        /**
         * @param value {@link #marketPeriod} (Begin and end dates for the commercial distribution of the device.)
         */
        public UdiDeviceIdentifierMarketDistributionComponent setMarketPeriod(Period value) { 
          this.marketPeriod = value;
          return this;
        }

        /**
         * @return {@link #subJurisdiction} (National state or territory to which the marketDistribution recers, typically where the device is commercialized.). This is the underlying object with id, value and extensions. The accessor "getSubJurisdiction" gives direct access to the value
         */
        public UriType getSubJurisdictionElement() { 
          if (this.subJurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create UdiDeviceIdentifierMarketDistributionComponent.subJurisdiction");
            else if (Configuration.doAutoCreate())
              this.subJurisdiction = new UriType(); // bb
          return this.subJurisdiction;
        }

        public boolean hasSubJurisdictionElement() { 
          return this.subJurisdiction != null && !this.subJurisdiction.isEmpty();
        }

        public boolean hasSubJurisdiction() { 
          return this.subJurisdiction != null && !this.subJurisdiction.isEmpty();
        }

        /**
         * @param value {@link #subJurisdiction} (National state or territory to which the marketDistribution recers, typically where the device is commercialized.). This is the underlying object with id, value and extensions. The accessor "getSubJurisdiction" gives direct access to the value
         */
        public UdiDeviceIdentifierMarketDistributionComponent setSubJurisdictionElement(UriType value) { 
          this.subJurisdiction = value;
          return this;
        }

        /**
         * @return National state or territory to which the marketDistribution recers, typically where the device is commercialized.
         */
        public String getSubJurisdiction() { 
          return this.subJurisdiction == null ? null : this.subJurisdiction.getValue();
        }

        /**
         * @param value National state or territory to which the marketDistribution recers, typically where the device is commercialized.
         */
        public UdiDeviceIdentifierMarketDistributionComponent setSubJurisdiction(String value) { 
            if (this.subJurisdiction == null)
              this.subJurisdiction = new UriType();
            this.subJurisdiction.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("marketPeriod", "Period", "Begin and end dates for the commercial distribution of the device.", 0, 1, marketPeriod));
          children.add(new Property("subJurisdiction", "uri", "National state or territory to which the marketDistribution recers, typically where the device is commercialized.", 0, 1, subJurisdiction));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -183772899: /*marketPeriod*/  return new Property("marketPeriod", "Period", "Begin and end dates for the commercial distribution of the device.", 0, 1, marketPeriod);
          case -777497119: /*subJurisdiction*/  return new Property("subJurisdiction", "uri", "National state or territory to which the marketDistribution recers, typically where the device is commercialized.", 0, 1, subJurisdiction);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -183772899: /*marketPeriod*/ return this.marketPeriod == null ? new Base[0] : new Base[] {this.marketPeriod}; // Period
        case -777497119: /*subJurisdiction*/ return this.subJurisdiction == null ? new Base[0] : new Base[] {this.subJurisdiction}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -183772899: // marketPeriod
          this.marketPeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -777497119: // subJurisdiction
          this.subJurisdiction = TypeConvertor.castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("marketPeriod")) {
          this.marketPeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("subJurisdiction")) {
          this.subJurisdiction = TypeConvertor.castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -183772899:  return getMarketPeriod();
        case -777497119:  return getSubJurisdictionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -183772899: /*marketPeriod*/ return new String[] {"Period"};
        case -777497119: /*subJurisdiction*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("marketPeriod")) {
          this.marketPeriod = new Period();
          return this.marketPeriod;
        }
        else if (name.equals("subJurisdiction")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.udiDeviceIdentifier.marketDistribution.subJurisdiction");
        }
        else
          return super.addChild(name);
      }

      public UdiDeviceIdentifierMarketDistributionComponent copy() {
        UdiDeviceIdentifierMarketDistributionComponent dst = new UdiDeviceIdentifierMarketDistributionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(UdiDeviceIdentifierMarketDistributionComponent dst) {
        super.copyValues(dst);
        dst.marketPeriod = marketPeriod == null ? null : marketPeriod.copy();
        dst.subJurisdiction = subJurisdiction == null ? null : subJurisdiction.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof UdiDeviceIdentifierMarketDistributionComponent))
          return false;
        UdiDeviceIdentifierMarketDistributionComponent o = (UdiDeviceIdentifierMarketDistributionComponent) other_;
        return compareDeep(marketPeriod, o.marketPeriod, true) && compareDeep(subJurisdiction, o.subJurisdiction, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof UdiDeviceIdentifierMarketDistributionComponent))
          return false;
        UdiDeviceIdentifierMarketDistributionComponent o = (UdiDeviceIdentifierMarketDistributionComponent) other_;
        return compareValues(subJurisdiction, o.subJurisdiction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(marketPeriod, subJurisdiction
          );
      }

  public String fhirType() {
    return "DeviceDefinition.udiDeviceIdentifier.marketDistribution";

  }

  }

    @Block()
    public static class DeviceDefinitionRegulatoryIdentifierComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of identifier itself.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="basic | master | license", formalDefinition="The type of identifier itself." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/devicedefinition-regulatory-identifier-type")
        protected Enumeration<DeviceDefinitionRegulatoryIdentifierType> type;

        /**
         * The identifier itself.
         */
        @Child(name = "deviceIdentifier", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The identifier itself", formalDefinition="The identifier itself." )
        protected StringType deviceIdentifier;

        /**
         * The organization that issued this identifier.
         */
        @Child(name = "issuer", type = {UriType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The organization that issued this identifier", formalDefinition="The organization that issued this identifier." )
        protected UriType issuer;

        /**
         * The jurisdiction to which the deviceIdentifier applies.
         */
        @Child(name = "jurisdiction", type = {UriType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The jurisdiction to which the deviceIdentifier applies", formalDefinition="The jurisdiction to which the deviceIdentifier applies." )
        protected UriType jurisdiction;

        private static final long serialVersionUID = 1438058623L;

    /**
     * Constructor
     */
      public DeviceDefinitionRegulatoryIdentifierComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionRegulatoryIdentifierComponent(DeviceDefinitionRegulatoryIdentifierType type, String deviceIdentifier, String issuer, String jurisdiction) {
        super();
        this.setType(type);
        this.setDeviceIdentifier(deviceIdentifier);
        this.setIssuer(issuer);
        this.setJurisdiction(jurisdiction);
      }

        /**
         * @return {@link #type} (The type of identifier itself.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<DeviceDefinitionRegulatoryIdentifierType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionRegulatoryIdentifierComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(new DeviceDefinitionRegulatoryIdentifierTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of identifier itself.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setTypeElement(Enumeration<DeviceDefinitionRegulatoryIdentifierType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of identifier itself.
         */
        public DeviceDefinitionRegulatoryIdentifierType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of identifier itself.
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setType(DeviceDefinitionRegulatoryIdentifierType value) { 
            if (this.type == null)
              this.type = new Enumeration<DeviceDefinitionRegulatoryIdentifierType>(new DeviceDefinitionRegulatoryIdentifierTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #deviceIdentifier} (The identifier itself.). This is the underlying object with id, value and extensions. The accessor "getDeviceIdentifier" gives direct access to the value
         */
        public StringType getDeviceIdentifierElement() { 
          if (this.deviceIdentifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionRegulatoryIdentifierComponent.deviceIdentifier");
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
         * @param value {@link #deviceIdentifier} (The identifier itself.). This is the underlying object with id, value and extensions. The accessor "getDeviceIdentifier" gives direct access to the value
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setDeviceIdentifierElement(StringType value) { 
          this.deviceIdentifier = value;
          return this;
        }

        /**
         * @return The identifier itself.
         */
        public String getDeviceIdentifier() { 
          return this.deviceIdentifier == null ? null : this.deviceIdentifier.getValue();
        }

        /**
         * @param value The identifier itself.
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setDeviceIdentifier(String value) { 
            if (this.deviceIdentifier == null)
              this.deviceIdentifier = new StringType();
            this.deviceIdentifier.setValue(value);
          return this;
        }

        /**
         * @return {@link #issuer} (The organization that issued this identifier.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
         */
        public UriType getIssuerElement() { 
          if (this.issuer == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionRegulatoryIdentifierComponent.issuer");
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
         * @param value {@link #issuer} (The organization that issued this identifier.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setIssuerElement(UriType value) { 
          this.issuer = value;
          return this;
        }

        /**
         * @return The organization that issued this identifier.
         */
        public String getIssuer() { 
          return this.issuer == null ? null : this.issuer.getValue();
        }

        /**
         * @param value The organization that issued this identifier.
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setIssuer(String value) { 
            if (this.issuer == null)
              this.issuer = new UriType();
            this.issuer.setValue(value);
          return this;
        }

        /**
         * @return {@link #jurisdiction} (The jurisdiction to which the deviceIdentifier applies.). This is the underlying object with id, value and extensions. The accessor "getJurisdiction" gives direct access to the value
         */
        public UriType getJurisdictionElement() { 
          if (this.jurisdiction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionRegulatoryIdentifierComponent.jurisdiction");
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
         * @param value {@link #jurisdiction} (The jurisdiction to which the deviceIdentifier applies.). This is the underlying object with id, value and extensions. The accessor "getJurisdiction" gives direct access to the value
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setJurisdictionElement(UriType value) { 
          this.jurisdiction = value;
          return this;
        }

        /**
         * @return The jurisdiction to which the deviceIdentifier applies.
         */
        public String getJurisdiction() { 
          return this.jurisdiction == null ? null : this.jurisdiction.getValue();
        }

        /**
         * @param value The jurisdiction to which the deviceIdentifier applies.
         */
        public DeviceDefinitionRegulatoryIdentifierComponent setJurisdiction(String value) { 
            if (this.jurisdiction == null)
              this.jurisdiction = new UriType();
            this.jurisdiction.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The type of identifier itself.", 0, 1, type));
          children.add(new Property("deviceIdentifier", "string", "The identifier itself.", 0, 1, deviceIdentifier));
          children.add(new Property("issuer", "uri", "The organization that issued this identifier.", 0, 1, issuer));
          children.add(new Property("jurisdiction", "uri", "The jurisdiction to which the deviceIdentifier applies.", 0, 1, jurisdiction));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The type of identifier itself.", 0, 1, type);
          case 1322005407: /*deviceIdentifier*/  return new Property("deviceIdentifier", "string", "The identifier itself.", 0, 1, deviceIdentifier);
          case -1179159879: /*issuer*/  return new Property("issuer", "uri", "The organization that issued this identifier.", 0, 1, issuer);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "uri", "The jurisdiction to which the deviceIdentifier applies.", 0, 1, jurisdiction);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<DeviceDefinitionRegulatoryIdentifierType>
        case 1322005407: /*deviceIdentifier*/ return this.deviceIdentifier == null ? new Base[0] : new Base[] {this.deviceIdentifier}; // StringType
        case -1179159879: /*issuer*/ return this.issuer == null ? new Base[0] : new Base[] {this.issuer}; // UriType
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : new Base[] {this.jurisdiction}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new DeviceDefinitionRegulatoryIdentifierTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DeviceDefinitionRegulatoryIdentifierType>
          return value;
        case 1322005407: // deviceIdentifier
          this.deviceIdentifier = TypeConvertor.castToString(value); // StringType
          return value;
        case -1179159879: // issuer
          this.issuer = TypeConvertor.castToUri(value); // UriType
          return value;
        case -507075711: // jurisdiction
          this.jurisdiction = TypeConvertor.castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new DeviceDefinitionRegulatoryIdentifierTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DeviceDefinitionRegulatoryIdentifierType>
        } else if (name.equals("deviceIdentifier")) {
          this.deviceIdentifier = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("issuer")) {
          this.issuer = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("jurisdiction")) {
          this.jurisdiction = TypeConvertor.castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 1322005407:  return getDeviceIdentifierElement();
        case -1179159879:  return getIssuerElement();
        case -507075711:  return getJurisdictionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 1322005407: /*deviceIdentifier*/ return new String[] {"string"};
        case -1179159879: /*issuer*/ return new String[] {"uri"};
        case -507075711: /*jurisdiction*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.regulatoryIdentifier.type");
        }
        else if (name.equals("deviceIdentifier")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.regulatoryIdentifier.deviceIdentifier");
        }
        else if (name.equals("issuer")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.regulatoryIdentifier.issuer");
        }
        else if (name.equals("jurisdiction")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.regulatoryIdentifier.jurisdiction");
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionRegulatoryIdentifierComponent copy() {
        DeviceDefinitionRegulatoryIdentifierComponent dst = new DeviceDefinitionRegulatoryIdentifierComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionRegulatoryIdentifierComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.deviceIdentifier = deviceIdentifier == null ? null : deviceIdentifier.copy();
        dst.issuer = issuer == null ? null : issuer.copy();
        dst.jurisdiction = jurisdiction == null ? null : jurisdiction.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionRegulatoryIdentifierComponent))
          return false;
        DeviceDefinitionRegulatoryIdentifierComponent o = (DeviceDefinitionRegulatoryIdentifierComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(deviceIdentifier, o.deviceIdentifier, true)
           && compareDeep(issuer, o.issuer, true) && compareDeep(jurisdiction, o.jurisdiction, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionRegulatoryIdentifierComponent))
          return false;
        DeviceDefinitionRegulatoryIdentifierComponent o = (DeviceDefinitionRegulatoryIdentifierComponent) other_;
        return compareValues(type, o.type, true) && compareValues(deviceIdentifier, o.deviceIdentifier, true)
           && compareValues(issuer, o.issuer, true) && compareValues(jurisdiction, o.jurisdiction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, deviceIdentifier, issuer
          , jurisdiction);
      }

  public String fhirType() {
    return "DeviceDefinition.regulatoryIdentifier";

  }

  }

    @Block()
    public static class DeviceDefinitionDeviceNameComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A name that is used to refer to the device", formalDefinition="A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other." )
        protected StringType name;

        /**
         * The type of deviceName.
RegisteredName | UserFriendlyName | PatientReportedName.
         */
        @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="registered-name | user-friendly-name | patient-reported-name", formalDefinition="The type of deviceName.\nRegisteredName | UserFriendlyName | PatientReportedName." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-nametype")
        protected Enumeration<DeviceNameType> type;

        private static final long serialVersionUID = 918983440L;

    /**
     * Constructor
     */
      public DeviceDefinitionDeviceNameComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionDeviceNameComponent(String name, DeviceNameType type) {
        super();
        this.setName(name);
        this.setType(type);
      }

        /**
         * @return {@link #name} (A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionDeviceNameComponent.name");
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
         * @param value {@link #name} (A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public DeviceDefinitionDeviceNameComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.
         */
        public DeviceDefinitionDeviceNameComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (The type of deviceName.
RegisteredName | UserFriendlyName | PatientReportedName.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<DeviceNameType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionDeviceNameComponent.type");
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
         * @param value {@link #type} (The type of deviceName.
RegisteredName | UserFriendlyName | PatientReportedName.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public DeviceDefinitionDeviceNameComponent setTypeElement(Enumeration<DeviceNameType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of deviceName.
RegisteredName | UserFriendlyName | PatientReportedName.
         */
        public DeviceNameType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of deviceName.
RegisteredName | UserFriendlyName | PatientReportedName.
         */
        public DeviceDefinitionDeviceNameComponent setType(DeviceNameType value) { 
            if (this.type == null)
              this.type = new Enumeration<DeviceNameType>(new DeviceNameTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.", 0, 1, name));
          children.add(new Property("type", "code", "The type of deviceName.\nRegisteredName | UserFriendlyName | PatientReportedName.", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "A human-friendly name that is used to refer to the device - depending on the type, it can be the brand name, the common name or alias, or other.", 0, 1, name);
          case 3575610: /*type*/  return new Property("type", "code", "The type of deviceName.\nRegisteredName | UserFriendlyName | PatientReportedName.", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<DeviceNameType>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new DeviceNameTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DeviceNameType>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new DeviceNameTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DeviceNameType>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3575610:  return getTypeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.deviceName.name");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.deviceName.type");
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionDeviceNameComponent copy() {
        DeviceDefinitionDeviceNameComponent dst = new DeviceDefinitionDeviceNameComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionDeviceNameComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionDeviceNameComponent))
          return false;
        DeviceDefinitionDeviceNameComponent o = (DeviceDefinitionDeviceNameComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionDeviceNameComponent))
          return false;
        DeviceDefinitionDeviceNameComponent o = (DeviceDefinitionDeviceNameComponent) other_;
        return compareValues(name, o.name, true) && compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, type);
      }

  public String fhirType() {
    return "DeviceDefinition.deviceName";

  }

  }

    @Block()
    public static class DeviceDefinitionClassificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A classification or risk class of the device model.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A classification or risk class of the device model", formalDefinition="A classification or risk class of the device model." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-type")
        protected CodeableConcept type;

        /**
         * Further information qualifying this classification of the device model.
         */
        @Child(name = "justification", type = {RelatedArtifact.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Further information qualifying this classification of the device model", formalDefinition="Further information qualifying this classification of the device model." )
        protected List<RelatedArtifact> justification;

        private static final long serialVersionUID = -1343788026L;

    /**
     * Constructor
     */
      public DeviceDefinitionClassificationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionClassificationComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A classification or risk class of the device model.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionClassificationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A classification or risk class of the device model.)
         */
        public DeviceDefinitionClassificationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #justification} (Further information qualifying this classification of the device model.)
         */
        public List<RelatedArtifact> getJustification() { 
          if (this.justification == null)
            this.justification = new ArrayList<RelatedArtifact>();
          return this.justification;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionClassificationComponent setJustification(List<RelatedArtifact> theJustification) { 
          this.justification = theJustification;
          return this;
        }

        public boolean hasJustification() { 
          if (this.justification == null)
            return false;
          for (RelatedArtifact item : this.justification)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RelatedArtifact addJustification() { //3
          RelatedArtifact t = new RelatedArtifact();
          if (this.justification == null)
            this.justification = new ArrayList<RelatedArtifact>();
          this.justification.add(t);
          return t;
        }

        public DeviceDefinitionClassificationComponent addJustification(RelatedArtifact t) { //3
          if (t == null)
            return this;
          if (this.justification == null)
            this.justification = new ArrayList<RelatedArtifact>();
          this.justification.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #justification}, creating it if it does not already exist {3}
         */
        public RelatedArtifact getJustificationFirstRep() { 
          if (getJustification().isEmpty()) {
            addJustification();
          }
          return getJustification().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A classification or risk class of the device model.", 0, 1, type));
          children.add(new Property("justification", "RelatedArtifact", "Further information qualifying this classification of the device model.", 0, java.lang.Integer.MAX_VALUE, justification));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A classification or risk class of the device model.", 0, 1, type);
          case 1864993522: /*justification*/  return new Property("justification", "RelatedArtifact", "Further information qualifying this classification of the device model.", 0, java.lang.Integer.MAX_VALUE, justification);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 1864993522: /*justification*/ return this.justification == null ? new Base[0] : this.justification.toArray(new Base[this.justification.size()]); // RelatedArtifact
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1864993522: // justification
          this.getJustification().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("justification")) {
          this.getJustification().add(TypeConvertor.castToRelatedArtifact(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 1864993522:  return addJustification(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1864993522: /*justification*/ return new String[] {"RelatedArtifact"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("justification")) {
          return addJustification();
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionClassificationComponent copy() {
        DeviceDefinitionClassificationComponent dst = new DeviceDefinitionClassificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionClassificationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (justification != null) {
          dst.justification = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : justification)
            dst.justification.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionClassificationComponent))
          return false;
        DeviceDefinitionClassificationComponent o = (DeviceDefinitionClassificationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(justification, o.justification, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionClassificationComponent))
          return false;
        DeviceDefinitionClassificationComponent o = (DeviceDefinitionClassificationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, justification);
      }

  public String fhirType() {
    return "DeviceDefinition.classification";

  }

  }

    @Block()
    public static class DeviceDefinitionConformsToComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes the type of the standard, specification, or formal guidance.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Describes the common type of the standard, specification, or formal guidance", formalDefinition="Describes the type of the standard, specification, or formal guidance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-specification-category")
        protected CodeableConcept category;

        /**
         * Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.
         */
        @Child(name = "specification", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifies the standard, specification, or formal guidance that the device adheres to the Device Specification type", formalDefinition="Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-specification-type")
        protected CodeableConcept specification;

        /**
         * Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.
         */
        @Child(name = "version", type = {StringType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The specific form or variant of the standard, specification or formal guidance", formalDefinition="Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label." )
        protected List<StringType> version;

        /**
         * Standard, regulation, certification, or guidance website, document, or other publication, or similar, supporting the conformance.
         */
        @Child(name = "source", type = {RelatedArtifact.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Standard, regulation, certification, or guidance website, document, or other publication, or similar, supporting the conformance", formalDefinition="Standard, regulation, certification, or guidance website, document, or other publication, or similar, supporting the conformance." )
        protected List<RelatedArtifact> source;

        private static final long serialVersionUID = -370906560L;

    /**
     * Constructor
     */
      public DeviceDefinitionConformsToComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionConformsToComponent(CodeableConcept specification) {
        super();
        this.setSpecification(specification);
      }

        /**
         * @return {@link #category} (Describes the type of the standard, specification, or formal guidance.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionConformsToComponent.category");
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
        public DeviceDefinitionConformsToComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #specification} (Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.)
         */
        public CodeableConcept getSpecification() { 
          if (this.specification == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionConformsToComponent.specification");
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
        public DeviceDefinitionConformsToComponent setSpecification(CodeableConcept value) { 
          this.specification = value;
          return this;
        }

        /**
         * @return {@link #version} (Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.)
         */
        public List<StringType> getVersion() { 
          if (this.version == null)
            this.version = new ArrayList<StringType>();
          return this.version;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionConformsToComponent setVersion(List<StringType> theVersion) { 
          this.version = theVersion;
          return this;
        }

        public boolean hasVersion() { 
          if (this.version == null)
            return false;
          for (StringType item : this.version)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #version} (Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.)
         */
        public StringType addVersionElement() {//2 
          StringType t = new StringType();
          if (this.version == null)
            this.version = new ArrayList<StringType>();
          this.version.add(t);
          return t;
        }

        /**
         * @param value {@link #version} (Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.)
         */
        public DeviceDefinitionConformsToComponent addVersion(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.version == null)
            this.version = new ArrayList<StringType>();
          this.version.add(t);
          return this;
        }

        /**
         * @param value {@link #version} (Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.)
         */
        public boolean hasVersion(String value) { 
          if (this.version == null)
            return false;
          for (StringType v : this.version)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #source} (Standard, regulation, certification, or guidance website, document, or other publication, or similar, supporting the conformance.)
         */
        public List<RelatedArtifact> getSource() { 
          if (this.source == null)
            this.source = new ArrayList<RelatedArtifact>();
          return this.source;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionConformsToComponent setSource(List<RelatedArtifact> theSource) { 
          this.source = theSource;
          return this;
        }

        public boolean hasSource() { 
          if (this.source == null)
            return false;
          for (RelatedArtifact item : this.source)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RelatedArtifact addSource() { //3
          RelatedArtifact t = new RelatedArtifact();
          if (this.source == null)
            this.source = new ArrayList<RelatedArtifact>();
          this.source.add(t);
          return t;
        }

        public DeviceDefinitionConformsToComponent addSource(RelatedArtifact t) { //3
          if (t == null)
            return this;
          if (this.source == null)
            this.source = new ArrayList<RelatedArtifact>();
          this.source.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
         */
        public RelatedArtifact getSourceFirstRep() { 
          if (getSource().isEmpty()) {
            addSource();
          }
          return getSource().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "Describes the type of the standard, specification, or formal guidance.", 0, 1, category));
          children.add(new Property("specification", "CodeableConcept", "Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.", 0, 1, specification));
          children.add(new Property("version", "string", "Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.", 0, java.lang.Integer.MAX_VALUE, version));
          children.add(new Property("source", "RelatedArtifact", "Standard, regulation, certification, or guidance website, document, or other publication, or similar, supporting the conformance.", 0, java.lang.Integer.MAX_VALUE, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Describes the type of the standard, specification, or formal guidance.", 0, 1, category);
          case 1307197699: /*specification*/  return new Property("specification", "CodeableConcept", "Code that identifies the specific standard, specification, protocol, formal guidance, regulation, legislation, or certification scheme to which the device adheres.", 0, 1, specification);
          case 351608024: /*version*/  return new Property("version", "string", "Identifies the specific form or variant of the standard, specification, or formal guidance. This may be a 'version number', release, document edition, publication year, or other label.", 0, java.lang.Integer.MAX_VALUE, version);
          case -896505829: /*source*/  return new Property("source", "RelatedArtifact", "Standard, regulation, certification, or guidance website, document, or other publication, or similar, supporting the conformance.", 0, java.lang.Integer.MAX_VALUE, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case 1307197699: /*specification*/ return this.specification == null ? new Base[0] : new Base[] {this.specification}; // CodeableConcept
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // StringType
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // RelatedArtifact
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
          this.getVersion().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -896505829: // source
          this.getSource().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
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
          this.getVersion().add(TypeConvertor.castToString(value));
        } else if (name.equals("source")) {
          this.getSource().add(TypeConvertor.castToRelatedArtifact(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case 1307197699:  return getSpecification();
        case 351608024:  return addVersionElement();
        case -896505829:  return addSource(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 1307197699: /*specification*/ return new String[] {"CodeableConcept"};
        case 351608024: /*version*/ return new String[] {"string"};
        case -896505829: /*source*/ return new String[] {"RelatedArtifact"};
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
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.conformsTo.version");
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionConformsToComponent copy() {
        DeviceDefinitionConformsToComponent dst = new DeviceDefinitionConformsToComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionConformsToComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.specification = specification == null ? null : specification.copy();
        if (version != null) {
          dst.version = new ArrayList<StringType>();
          for (StringType i : version)
            dst.version.add(i.copy());
        };
        if (source != null) {
          dst.source = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : source)
            dst.source.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionConformsToComponent))
          return false;
        DeviceDefinitionConformsToComponent o = (DeviceDefinitionConformsToComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(specification, o.specification, true)
           && compareDeep(version, o.version, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionConformsToComponent))
          return false;
        DeviceDefinitionConformsToComponent o = (DeviceDefinitionConformsToComponent) other_;
        return compareValues(version, o.version, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, specification, version
          , source);
      }

  public String fhirType() {
    return "DeviceDefinition.conformsTo";

  }

  }

    @Block()
    public static class DeviceDefinitionHasPartComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Reference to the device that is part of the current device.
         */
        @Child(name = "reference", type = {DeviceDefinition.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to the part", formalDefinition="Reference to the device that is part of the current device." )
        protected Reference reference;

        /**
         * Number of instances of the component device in the current device.
         */
        @Child(name = "count", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of occurrences of the part", formalDefinition="Number of instances of the component device in the current device." )
        protected IntegerType count;

        private static final long serialVersionUID = -1166127369L;

    /**
     * Constructor
     */
      public DeviceDefinitionHasPartComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionHasPartComponent(Reference reference) {
        super();
        this.setReference(reference);
      }

        /**
         * @return {@link #reference} (Reference to the device that is part of the current device.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionHasPartComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (Reference to the device that is part of the current device.)
         */
        public DeviceDefinitionHasPartComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        /**
         * @return {@link #count} (Number of instances of the component device in the current device.). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public IntegerType getCountElement() { 
          if (this.count == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionHasPartComponent.count");
            else if (Configuration.doAutoCreate())
              this.count = new IntegerType(); // bb
          return this.count;
        }

        public boolean hasCountElement() { 
          return this.count != null && !this.count.isEmpty();
        }

        public boolean hasCount() { 
          return this.count != null && !this.count.isEmpty();
        }

        /**
         * @param value {@link #count} (Number of instances of the component device in the current device.). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public DeviceDefinitionHasPartComponent setCountElement(IntegerType value) { 
          this.count = value;
          return this;
        }

        /**
         * @return Number of instances of the component device in the current device.
         */
        public int getCount() { 
          return this.count == null || this.count.isEmpty() ? 0 : this.count.getValue();
        }

        /**
         * @param value Number of instances of the component device in the current device.
         */
        public DeviceDefinitionHasPartComponent setCount(int value) { 
            if (this.count == null)
              this.count = new IntegerType();
            this.count.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("reference", "Reference(DeviceDefinition)", "Reference to the device that is part of the current device.", 0, 1, reference));
          children.add(new Property("count", "integer", "Number of instances of the component device in the current device.", 0, 1, count));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -925155509: /*reference*/  return new Property("reference", "Reference(DeviceDefinition)", "Reference to the device that is part of the current device.", 0, 1, reference);
          case 94851343: /*count*/  return new Property("count", "integer", "Number of instances of the component device in the current device.", 0, 1, count);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        case 94851343: /*count*/ return this.count == null ? new Base[0] : new Base[] {this.count}; // IntegerType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 94851343: // count
          this.count = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("count")) {
          this.count = TypeConvertor.castToInteger(value); // IntegerType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -925155509:  return getReference();
        case 94851343:  return getCountElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -925155509: /*reference*/ return new String[] {"Reference"};
        case 94851343: /*count*/ return new String[] {"integer"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else if (name.equals("count")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.hasPart.count");
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionHasPartComponent copy() {
        DeviceDefinitionHasPartComponent dst = new DeviceDefinitionHasPartComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionHasPartComponent dst) {
        super.copyValues(dst);
        dst.reference = reference == null ? null : reference.copy();
        dst.count = count == null ? null : count.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionHasPartComponent))
          return false;
        DeviceDefinitionHasPartComponent o = (DeviceDefinitionHasPartComponent) other_;
        return compareDeep(reference, o.reference, true) && compareDeep(count, o.count, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionHasPartComponent))
          return false;
        DeviceDefinitionHasPartComponent o = (DeviceDefinitionHasPartComponent) other_;
        return compareValues(count, o.count, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(reference, count);
      }

  public String fhirType() {
    return "DeviceDefinition.hasPart";

  }

  }

    @Block()
    public static class DeviceDefinitionPackagingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The business identifier of the packaged medication.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Business identifier of the packaged medication", formalDefinition="The business identifier of the packaged medication." )
        protected Identifier identifier;

        /**
         * A code that defines the specific type of packaging.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A code that defines the specific type of packaging", formalDefinition="A code that defines the specific type of packaging." )
        protected CodeableConcept type;

        /**
         * The number of items contained in the package (devices or sub-packages).
         */
        @Child(name = "count", type = {IntegerType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The number of items contained in the package (devices or sub-packages)", formalDefinition="The number of items contained in the package (devices or sub-packages)." )
        protected IntegerType count;

        /**
         * An organization that distributes the packaged device.
         */
        @Child(name = "distributor", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An organization that distributes the packaged device", formalDefinition="An organization that distributes the packaged device." )
        protected List<PackagingDistributorComponent> distributor;

        /**
         * Unique Device Identifier (UDI) Barcode string on the packaging.
         */
        @Child(name = "udiDeviceIdentifier", type = {DeviceDefinitionUdiDeviceIdentifierComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Unique Device Identifier (UDI) Barcode string on the packaging", formalDefinition="Unique Device Identifier (UDI) Barcode string on the packaging." )
        protected List<DeviceDefinitionUdiDeviceIdentifierComponent> udiDeviceIdentifier;

        /**
         * Allows packages within packages.
         */
        @Child(name = "packaging", type = {DeviceDefinitionPackagingComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Allows packages within packages", formalDefinition="Allows packages within packages." )
        protected List<DeviceDefinitionPackagingComponent> packaging;

        private static final long serialVersionUID = 1022373074L;

    /**
     * Constructor
     */
      public DeviceDefinitionPackagingComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (The business identifier of the packaged medication.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionPackagingComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (The business identifier of the packaged medication.)
         */
        public DeviceDefinitionPackagingComponent setIdentifier(Identifier value) { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #type} (A code that defines the specific type of packaging.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionPackagingComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code that defines the specific type of packaging.)
         */
        public DeviceDefinitionPackagingComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #count} (The number of items contained in the package (devices or sub-packages).). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public IntegerType getCountElement() { 
          if (this.count == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionPackagingComponent.count");
            else if (Configuration.doAutoCreate())
              this.count = new IntegerType(); // bb
          return this.count;
        }

        public boolean hasCountElement() { 
          return this.count != null && !this.count.isEmpty();
        }

        public boolean hasCount() { 
          return this.count != null && !this.count.isEmpty();
        }

        /**
         * @param value {@link #count} (The number of items contained in the package (devices or sub-packages).). This is the underlying object with id, value and extensions. The accessor "getCount" gives direct access to the value
         */
        public DeviceDefinitionPackagingComponent setCountElement(IntegerType value) { 
          this.count = value;
          return this;
        }

        /**
         * @return The number of items contained in the package (devices or sub-packages).
         */
        public int getCount() { 
          return this.count == null || this.count.isEmpty() ? 0 : this.count.getValue();
        }

        /**
         * @param value The number of items contained in the package (devices or sub-packages).
         */
        public DeviceDefinitionPackagingComponent setCount(int value) { 
            if (this.count == null)
              this.count = new IntegerType();
            this.count.setValue(value);
          return this;
        }

        /**
         * @return {@link #distributor} (An organization that distributes the packaged device.)
         */
        public List<PackagingDistributorComponent> getDistributor() { 
          if (this.distributor == null)
            this.distributor = new ArrayList<PackagingDistributorComponent>();
          return this.distributor;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionPackagingComponent setDistributor(List<PackagingDistributorComponent> theDistributor) { 
          this.distributor = theDistributor;
          return this;
        }

        public boolean hasDistributor() { 
          if (this.distributor == null)
            return false;
          for (PackagingDistributorComponent item : this.distributor)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PackagingDistributorComponent addDistributor() { //3
          PackagingDistributorComponent t = new PackagingDistributorComponent();
          if (this.distributor == null)
            this.distributor = new ArrayList<PackagingDistributorComponent>();
          this.distributor.add(t);
          return t;
        }

        public DeviceDefinitionPackagingComponent addDistributor(PackagingDistributorComponent t) { //3
          if (t == null)
            return this;
          if (this.distributor == null)
            this.distributor = new ArrayList<PackagingDistributorComponent>();
          this.distributor.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #distributor}, creating it if it does not already exist {3}
         */
        public PackagingDistributorComponent getDistributorFirstRep() { 
          if (getDistributor().isEmpty()) {
            addDistributor();
          }
          return getDistributor().get(0);
        }

        /**
         * @return {@link #udiDeviceIdentifier} (Unique Device Identifier (UDI) Barcode string on the packaging.)
         */
        public List<DeviceDefinitionUdiDeviceIdentifierComponent> getUdiDeviceIdentifier() { 
          if (this.udiDeviceIdentifier == null)
            this.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
          return this.udiDeviceIdentifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionPackagingComponent setUdiDeviceIdentifier(List<DeviceDefinitionUdiDeviceIdentifierComponent> theUdiDeviceIdentifier) { 
          this.udiDeviceIdentifier = theUdiDeviceIdentifier;
          return this;
        }

        public boolean hasUdiDeviceIdentifier() { 
          if (this.udiDeviceIdentifier == null)
            return false;
          for (DeviceDefinitionUdiDeviceIdentifierComponent item : this.udiDeviceIdentifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public DeviceDefinitionUdiDeviceIdentifierComponent addUdiDeviceIdentifier() { //3
          DeviceDefinitionUdiDeviceIdentifierComponent t = new DeviceDefinitionUdiDeviceIdentifierComponent();
          if (this.udiDeviceIdentifier == null)
            this.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
          this.udiDeviceIdentifier.add(t);
          return t;
        }

        public DeviceDefinitionPackagingComponent addUdiDeviceIdentifier(DeviceDefinitionUdiDeviceIdentifierComponent t) { //3
          if (t == null)
            return this;
          if (this.udiDeviceIdentifier == null)
            this.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
          this.udiDeviceIdentifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #udiDeviceIdentifier}, creating it if it does not already exist {3}
         */
        public DeviceDefinitionUdiDeviceIdentifierComponent getUdiDeviceIdentifierFirstRep() { 
          if (getUdiDeviceIdentifier().isEmpty()) {
            addUdiDeviceIdentifier();
          }
          return getUdiDeviceIdentifier().get(0);
        }

        /**
         * @return {@link #packaging} (Allows packages within packages.)
         */
        public List<DeviceDefinitionPackagingComponent> getPackaging() { 
          if (this.packaging == null)
            this.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
          return this.packaging;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionPackagingComponent setPackaging(List<DeviceDefinitionPackagingComponent> thePackaging) { 
          this.packaging = thePackaging;
          return this;
        }

        public boolean hasPackaging() { 
          if (this.packaging == null)
            return false;
          for (DeviceDefinitionPackagingComponent item : this.packaging)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public DeviceDefinitionPackagingComponent addPackaging() { //3
          DeviceDefinitionPackagingComponent t = new DeviceDefinitionPackagingComponent();
          if (this.packaging == null)
            this.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
          this.packaging.add(t);
          return t;
        }

        public DeviceDefinitionPackagingComponent addPackaging(DeviceDefinitionPackagingComponent t) { //3
          if (t == null)
            return this;
          if (this.packaging == null)
            this.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
          this.packaging.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #packaging}, creating it if it does not already exist {3}
         */
        public DeviceDefinitionPackagingComponent getPackagingFirstRep() { 
          if (getPackaging().isEmpty()) {
            addPackaging();
          }
          return getPackaging().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "The business identifier of the packaged medication.", 0, 1, identifier));
          children.add(new Property("type", "CodeableConcept", "A code that defines the specific type of packaging.", 0, 1, type));
          children.add(new Property("count", "integer", "The number of items contained in the package (devices or sub-packages).", 0, 1, count));
          children.add(new Property("distributor", "", "An organization that distributes the packaged device.", 0, java.lang.Integer.MAX_VALUE, distributor));
          children.add(new Property("udiDeviceIdentifier", "@DeviceDefinition.udiDeviceIdentifier", "Unique Device Identifier (UDI) Barcode string on the packaging.", 0, java.lang.Integer.MAX_VALUE, udiDeviceIdentifier));
          children.add(new Property("packaging", "@DeviceDefinition.packaging", "Allows packages within packages.", 0, java.lang.Integer.MAX_VALUE, packaging));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "The business identifier of the packaged medication.", 0, 1, identifier);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code that defines the specific type of packaging.", 0, 1, type);
          case 94851343: /*count*/  return new Property("count", "integer", "The number of items contained in the package (devices or sub-packages).", 0, 1, count);
          case 1334482919: /*distributor*/  return new Property("distributor", "", "An organization that distributes the packaged device.", 0, java.lang.Integer.MAX_VALUE, distributor);
          case -99121287: /*udiDeviceIdentifier*/  return new Property("udiDeviceIdentifier", "@DeviceDefinition.udiDeviceIdentifier", "Unique Device Identifier (UDI) Barcode string on the packaging.", 0, java.lang.Integer.MAX_VALUE, udiDeviceIdentifier);
          case 1802065795: /*packaging*/  return new Property("packaging", "@DeviceDefinition.packaging", "Allows packages within packages.", 0, java.lang.Integer.MAX_VALUE, packaging);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 94851343: /*count*/ return this.count == null ? new Base[0] : new Base[] {this.count}; // IntegerType
        case 1334482919: /*distributor*/ return this.distributor == null ? new Base[0] : this.distributor.toArray(new Base[this.distributor.size()]); // PackagingDistributorComponent
        case -99121287: /*udiDeviceIdentifier*/ return this.udiDeviceIdentifier == null ? new Base[0] : this.udiDeviceIdentifier.toArray(new Base[this.udiDeviceIdentifier.size()]); // DeviceDefinitionUdiDeviceIdentifierComponent
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : this.packaging.toArray(new Base[this.packaging.size()]); // DeviceDefinitionPackagingComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 94851343: // count
          this.count = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 1334482919: // distributor
          this.getDistributor().add((PackagingDistributorComponent) value); // PackagingDistributorComponent
          return value;
        case -99121287: // udiDeviceIdentifier
          this.getUdiDeviceIdentifier().add((DeviceDefinitionUdiDeviceIdentifierComponent) value); // DeviceDefinitionUdiDeviceIdentifierComponent
          return value;
        case 1802065795: // packaging
          this.getPackaging().add((DeviceDefinitionPackagingComponent) value); // DeviceDefinitionPackagingComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("count")) {
          this.count = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("distributor")) {
          this.getDistributor().add((PackagingDistributorComponent) value);
        } else if (name.equals("udiDeviceIdentifier")) {
          this.getUdiDeviceIdentifier().add((DeviceDefinitionUdiDeviceIdentifierComponent) value);
        } else if (name.equals("packaging")) {
          this.getPackaging().add((DeviceDefinitionPackagingComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case 3575610:  return getType();
        case 94851343:  return getCountElement();
        case 1334482919:  return addDistributor(); 
        case -99121287:  return addUdiDeviceIdentifier(); 
        case 1802065795:  return addPackaging(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 94851343: /*count*/ return new String[] {"integer"};
        case 1334482919: /*distributor*/ return new String[] {};
        case -99121287: /*udiDeviceIdentifier*/ return new String[] {"@DeviceDefinition.udiDeviceIdentifier"};
        case 1802065795: /*packaging*/ return new String[] {"@DeviceDefinition.packaging"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("count")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.packaging.count");
        }
        else if (name.equals("distributor")) {
          return addDistributor();
        }
        else if (name.equals("udiDeviceIdentifier")) {
          return addUdiDeviceIdentifier();
        }
        else if (name.equals("packaging")) {
          return addPackaging();
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionPackagingComponent copy() {
        DeviceDefinitionPackagingComponent dst = new DeviceDefinitionPackagingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionPackagingComponent dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.type = type == null ? null : type.copy();
        dst.count = count == null ? null : count.copy();
        if (distributor != null) {
          dst.distributor = new ArrayList<PackagingDistributorComponent>();
          for (PackagingDistributorComponent i : distributor)
            dst.distributor.add(i.copy());
        };
        if (udiDeviceIdentifier != null) {
          dst.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
          for (DeviceDefinitionUdiDeviceIdentifierComponent i : udiDeviceIdentifier)
            dst.udiDeviceIdentifier.add(i.copy());
        };
        if (packaging != null) {
          dst.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
          for (DeviceDefinitionPackagingComponent i : packaging)
            dst.packaging.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionPackagingComponent))
          return false;
        DeviceDefinitionPackagingComponent o = (DeviceDefinitionPackagingComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(count, o.count, true)
           && compareDeep(distributor, o.distributor, true) && compareDeep(udiDeviceIdentifier, o.udiDeviceIdentifier, true)
           && compareDeep(packaging, o.packaging, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionPackagingComponent))
          return false;
        DeviceDefinitionPackagingComponent o = (DeviceDefinitionPackagingComponent) other_;
        return compareValues(count, o.count, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, count
          , distributor, udiDeviceIdentifier, packaging);
      }

  public String fhirType() {
    return "DeviceDefinition.packaging";

  }

  }

    @Block()
    public static class PackagingDistributorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distributor's human-readable name.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Distributor's human-readable name", formalDefinition="Distributor's human-readable name." )
        protected StringType name;

        /**
         * Distributor as an Organization resource.
         */
        @Child(name = "organizationReference", type = {Organization.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Distributor as an Organization resource", formalDefinition="Distributor as an Organization resource." )
        protected List<Reference> organizationReference;

        private static final long serialVersionUID = 1587433419L;

    /**
     * Constructor
     */
      public PackagingDistributorComponent() {
        super();
      }

        /**
         * @return {@link #name} (Distributor's human-readable name.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PackagingDistributorComponent.name");
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
         * @param value {@link #name} (Distributor's human-readable name.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public PackagingDistributorComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Distributor's human-readable name.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Distributor's human-readable name.
         */
        public PackagingDistributorComponent setName(String value) { 
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
         * @return {@link #organizationReference} (Distributor as an Organization resource.)
         */
        public List<Reference> getOrganizationReference() { 
          if (this.organizationReference == null)
            this.organizationReference = new ArrayList<Reference>();
          return this.organizationReference;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PackagingDistributorComponent setOrganizationReference(List<Reference> theOrganizationReference) { 
          this.organizationReference = theOrganizationReference;
          return this;
        }

        public boolean hasOrganizationReference() { 
          if (this.organizationReference == null)
            return false;
          for (Reference item : this.organizationReference)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addOrganizationReference() { //3
          Reference t = new Reference();
          if (this.organizationReference == null)
            this.organizationReference = new ArrayList<Reference>();
          this.organizationReference.add(t);
          return t;
        }

        public PackagingDistributorComponent addOrganizationReference(Reference t) { //3
          if (t == null)
            return this;
          if (this.organizationReference == null)
            this.organizationReference = new ArrayList<Reference>();
          this.organizationReference.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #organizationReference}, creating it if it does not already exist {3}
         */
        public Reference getOrganizationReferenceFirstRep() { 
          if (getOrganizationReference().isEmpty()) {
            addOrganizationReference();
          }
          return getOrganizationReference().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Distributor's human-readable name.", 0, 1, name));
          children.add(new Property("organizationReference", "Reference(Organization)", "Distributor as an Organization resource.", 0, java.lang.Integer.MAX_VALUE, organizationReference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Distributor's human-readable name.", 0, 1, name);
          case 1860475736: /*organizationReference*/  return new Property("organizationReference", "Reference(Organization)", "Distributor as an Organization resource.", 0, java.lang.Integer.MAX_VALUE, organizationReference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 1860475736: /*organizationReference*/ return this.organizationReference == null ? new Base[0] : this.organizationReference.toArray(new Base[this.organizationReference.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 1860475736: // organizationReference
          this.getOrganizationReference().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("organizationReference")) {
          this.getOrganizationReference().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 1860475736:  return addOrganizationReference(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 1860475736: /*organizationReference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.packaging.distributor.name");
        }
        else if (name.equals("organizationReference")) {
          return addOrganizationReference();
        }
        else
          return super.addChild(name);
      }

      public PackagingDistributorComponent copy() {
        PackagingDistributorComponent dst = new PackagingDistributorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PackagingDistributorComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (organizationReference != null) {
          dst.organizationReference = new ArrayList<Reference>();
          for (Reference i : organizationReference)
            dst.organizationReference.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PackagingDistributorComponent))
          return false;
        PackagingDistributorComponent o = (PackagingDistributorComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(organizationReference, o.organizationReference, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PackagingDistributorComponent))
          return false;
        PackagingDistributorComponent o = (PackagingDistributorComponent) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, organizationReference
          );
      }

  public String fhirType() {
    return "DeviceDefinition.packaging.distributor";

  }

  }

    @Block()
    public static class DeviceDefinitionVersionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of the device version, e.g. manufacturer, approved, internal.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of the device version, e.g. manufacturer, approved, internal", formalDefinition="The type of the device version, e.g. manufacturer, approved, internal." )
        protected CodeableConcept type;

        /**
         * The hardware or software module of the device to which the version applies.
         */
        @Child(name = "component", type = {Identifier.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The hardware or software module of the device to which the version applies", formalDefinition="The hardware or software module of the device to which the version applies." )
        protected Identifier component;

        /**
         * The version text.
         */
        @Child(name = "value", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The version text", formalDefinition="The version text." )
        protected StringType value;

        private static final long serialVersionUID = 645214295L;

    /**
     * Constructor
     */
      public DeviceDefinitionVersionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionVersionComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #type} (The type of the device version, e.g. manufacturer, approved, internal.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionVersionComponent.type");
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
        public DeviceDefinitionVersionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #component} (The hardware or software module of the device to which the version applies.)
         */
        public Identifier getComponent() { 
          if (this.component == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionVersionComponent.component");
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
        public DeviceDefinitionVersionComponent setComponent(Identifier value) { 
          this.component = value;
          return this;
        }

        /**
         * @return {@link #value} (The version text.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionVersionComponent.value");
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
        public DeviceDefinitionVersionComponent setValueElement(StringType value) { 
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
        public DeviceDefinitionVersionComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type of the device version, e.g. manufacturer, approved, internal.", 0, 1, type));
          children.add(new Property("component", "Identifier", "The hardware or software module of the device to which the version applies.", 0, 1, component));
          children.add(new Property("value", "string", "The version text.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of the device version, e.g. manufacturer, approved, internal.", 0, 1, type);
          case -1399907075: /*component*/  return new Property("component", "Identifier", "The hardware or software module of the device to which the version applies.", 0, 1, component);
          case 111972721: /*value*/  return new Property("value", "string", "The version text.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : new Base[] {this.component}; // Identifier
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
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1399907075: /*component*/ return new String[] {"Identifier"};
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
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.version.value");
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionVersionComponent copy() {
        DeviceDefinitionVersionComponent dst = new DeviceDefinitionVersionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionVersionComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.component = component == null ? null : component.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionVersionComponent))
          return false;
        DeviceDefinitionVersionComponent o = (DeviceDefinitionVersionComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(component, o.component, true) && compareDeep(value, o.value, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionVersionComponent))
          return false;
        DeviceDefinitionVersionComponent o = (DeviceDefinitionVersionComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, component, value);
      }

  public String fhirType() {
    return "DeviceDefinition.version";

  }

  }

    @Block()
    public static class DeviceDefinitionPropertyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code that specifies the property.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code that specifies the property", formalDefinition="Code that specifies the property." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-property-type")
        protected CodeableConcept type;

        /**
         * Property value - the data type depends on the property type.
         */
        @Child(name = "value", type = {Quantity.class, CodeableConcept.class, StringType.class, BooleanType.class, IntegerType.class, Range.class, Attachment.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Property value - as a code or quantity", formalDefinition="Property value - the data type depends on the property type." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public DeviceDefinitionPropertyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionPropertyComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Code that specifies the property.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionPropertyComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Code that specifies the property.)
         */
        public DeviceDefinitionPropertyComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (Property value - the data type depends on the property type.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @return {@link #value} (Property value - the data type depends on the property type.)
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
         * @param value {@link #value} (Property value - the data type depends on the property type.)
         */
        public DeviceDefinitionPropertyComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof CodeableConcept || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof Range || value instanceof Attachment))
            throw new FHIRException("Not the right type for DeviceDefinition.property.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Code that specifies the property.", 0, 1, type));
          children.add(new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Attachment", "Property value - the data type depends on the property type.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code that specifies the property.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Attachment", "Property value - the data type depends on the property type.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Attachment", "Property value - the data type depends on the property type.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Property value - the data type depends on the property type.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Property value - the data type depends on the property type.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "Property value - the data type depends on the property type.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Property value - the data type depends on the property type.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "Property value - the data type depends on the property type.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Property value - the data type depends on the property type.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "Property value - the data type depends on the property type.", 0, 1, value);
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

      public DeviceDefinitionPropertyComponent copy() {
        DeviceDefinitionPropertyComponent dst = new DeviceDefinitionPropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionPropertyComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionPropertyComponent))
          return false;
        DeviceDefinitionPropertyComponent o = (DeviceDefinitionPropertyComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionPropertyComponent))
          return false;
        DeviceDefinitionPropertyComponent o = (DeviceDefinitionPropertyComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "DeviceDefinition.property";

  }

  }

    @Block()
    public static class DeviceDefinitionLinkComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type indicates the relationship of the related device to the device instance.
         */
        @Child(name = "relation", type = {Coding.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type indicates the relationship of the related device to the device instance", formalDefinition="The type indicates the relationship of the related device to the device instance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/devicedefinition-relationtype")
        protected Coding relation;

        /**
         * A reference to the linked device.
         */
        @Child(name = "relatedDevice", type = {CodeableReference.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A reference to the linked device", formalDefinition="A reference to the linked device." )
        protected CodeableReference relatedDevice;

        private static final long serialVersionUID = 627614461L;

    /**
     * Constructor
     */
      public DeviceDefinitionLinkComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionLinkComponent(Coding relation, CodeableReference relatedDevice) {
        super();
        this.setRelation(relation);
        this.setRelatedDevice(relatedDevice);
      }

        /**
         * @return {@link #relation} (The type indicates the relationship of the related device to the device instance.)
         */
        public Coding getRelation() { 
          if (this.relation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionLinkComponent.relation");
            else if (Configuration.doAutoCreate())
              this.relation = new Coding(); // cc
          return this.relation;
        }

        public boolean hasRelation() { 
          return this.relation != null && !this.relation.isEmpty();
        }

        /**
         * @param value {@link #relation} (The type indicates the relationship of the related device to the device instance.)
         */
        public DeviceDefinitionLinkComponent setRelation(Coding value) { 
          this.relation = value;
          return this;
        }

        /**
         * @return {@link #relatedDevice} (A reference to the linked device.)
         */
        public CodeableReference getRelatedDevice() { 
          if (this.relatedDevice == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionLinkComponent.relatedDevice");
            else if (Configuration.doAutoCreate())
              this.relatedDevice = new CodeableReference(); // cc
          return this.relatedDevice;
        }

        public boolean hasRelatedDevice() { 
          return this.relatedDevice != null && !this.relatedDevice.isEmpty();
        }

        /**
         * @param value {@link #relatedDevice} (A reference to the linked device.)
         */
        public DeviceDefinitionLinkComponent setRelatedDevice(CodeableReference value) { 
          this.relatedDevice = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("relation", "Coding", "The type indicates the relationship of the related device to the device instance.", 0, 1, relation));
          children.add(new Property("relatedDevice", "CodeableReference(DeviceDefinition)", "A reference to the linked device.", 0, 1, relatedDevice));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -554436100: /*relation*/  return new Property("relation", "Coding", "The type indicates the relationship of the related device to the device instance.", 0, 1, relation);
          case -296314271: /*relatedDevice*/  return new Property("relatedDevice", "CodeableReference(DeviceDefinition)", "A reference to the linked device.", 0, 1, relatedDevice);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -554436100: /*relation*/ return this.relation == null ? new Base[0] : new Base[] {this.relation}; // Coding
        case -296314271: /*relatedDevice*/ return this.relatedDevice == null ? new Base[0] : new Base[] {this.relatedDevice}; // CodeableReference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -554436100: // relation
          this.relation = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -296314271: // relatedDevice
          this.relatedDevice = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("relation")) {
          this.relation = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("relatedDevice")) {
          this.relatedDevice = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -554436100:  return getRelation();
        case -296314271:  return getRelatedDevice();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -554436100: /*relation*/ return new String[] {"Coding"};
        case -296314271: /*relatedDevice*/ return new String[] {"CodeableReference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("relation")) {
          this.relation = new Coding();
          return this.relation;
        }
        else if (name.equals("relatedDevice")) {
          this.relatedDevice = new CodeableReference();
          return this.relatedDevice;
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionLinkComponent copy() {
        DeviceDefinitionLinkComponent dst = new DeviceDefinitionLinkComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionLinkComponent dst) {
        super.copyValues(dst);
        dst.relation = relation == null ? null : relation.copy();
        dst.relatedDevice = relatedDevice == null ? null : relatedDevice.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionLinkComponent))
          return false;
        DeviceDefinitionLinkComponent o = (DeviceDefinitionLinkComponent) other_;
        return compareDeep(relation, o.relation, true) && compareDeep(relatedDevice, o.relatedDevice, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionLinkComponent))
          return false;
        DeviceDefinitionLinkComponent o = (DeviceDefinitionLinkComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(relation, relatedDevice);
      }

  public String fhirType() {
    return "DeviceDefinition.link";

  }

  }

    @Block()
    public static class DeviceDefinitionMaterialComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A substance that the device contains, may contain, or is made of - for example latex - to be used to determine patient compatibility. This is not intended to represent the composition of the device, only the clinically relevant materials.
         */
        @Child(name = "substance", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A relevant substance that the device contains, may contain, or is made of", formalDefinition="A substance that the device contains, may contain, or is made of - for example latex - to be used to determine patient compatibility. This is not intended to represent the composition of the device, only the clinically relevant materials." )
        protected CodeableConcept substance;

        /**
         * Indicates an alternative material of the device.
         */
        @Child(name = "alternate", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates an alternative material of the device", formalDefinition="Indicates an alternative material of the device." )
        protected BooleanType alternate;

        /**
         * Whether the substance is a known or suspected allergen.
         */
        @Child(name = "allergenicIndicator", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the substance is a known or suspected allergen", formalDefinition="Whether the substance is a known or suspected allergen." )
        protected BooleanType allergenicIndicator;

        private static final long serialVersionUID = 1232736508L;

    /**
     * Constructor
     */
      public DeviceDefinitionMaterialComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionMaterialComponent(CodeableConcept substance) {
        super();
        this.setSubstance(substance);
      }

        /**
         * @return {@link #substance} (A substance that the device contains, may contain, or is made of - for example latex - to be used to determine patient compatibility. This is not intended to represent the composition of the device, only the clinically relevant materials.)
         */
        public CodeableConcept getSubstance() { 
          if (this.substance == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionMaterialComponent.substance");
            else if (Configuration.doAutoCreate())
              this.substance = new CodeableConcept(); // cc
          return this.substance;
        }

        public boolean hasSubstance() { 
          return this.substance != null && !this.substance.isEmpty();
        }

        /**
         * @param value {@link #substance} (A substance that the device contains, may contain, or is made of - for example latex - to be used to determine patient compatibility. This is not intended to represent the composition of the device, only the clinically relevant materials.)
         */
        public DeviceDefinitionMaterialComponent setSubstance(CodeableConcept value) { 
          this.substance = value;
          return this;
        }

        /**
         * @return {@link #alternate} (Indicates an alternative material of the device.). This is the underlying object with id, value and extensions. The accessor "getAlternate" gives direct access to the value
         */
        public BooleanType getAlternateElement() { 
          if (this.alternate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionMaterialComponent.alternate");
            else if (Configuration.doAutoCreate())
              this.alternate = new BooleanType(); // bb
          return this.alternate;
        }

        public boolean hasAlternateElement() { 
          return this.alternate != null && !this.alternate.isEmpty();
        }

        public boolean hasAlternate() { 
          return this.alternate != null && !this.alternate.isEmpty();
        }

        /**
         * @param value {@link #alternate} (Indicates an alternative material of the device.). This is the underlying object with id, value and extensions. The accessor "getAlternate" gives direct access to the value
         */
        public DeviceDefinitionMaterialComponent setAlternateElement(BooleanType value) { 
          this.alternate = value;
          return this;
        }

        /**
         * @return Indicates an alternative material of the device.
         */
        public boolean getAlternate() { 
          return this.alternate == null || this.alternate.isEmpty() ? false : this.alternate.getValue();
        }

        /**
         * @param value Indicates an alternative material of the device.
         */
        public DeviceDefinitionMaterialComponent setAlternate(boolean value) { 
            if (this.alternate == null)
              this.alternate = new BooleanType();
            this.alternate.setValue(value);
          return this;
        }

        /**
         * @return {@link #allergenicIndicator} (Whether the substance is a known or suspected allergen.). This is the underlying object with id, value and extensions. The accessor "getAllergenicIndicator" gives direct access to the value
         */
        public BooleanType getAllergenicIndicatorElement() { 
          if (this.allergenicIndicator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionMaterialComponent.allergenicIndicator");
            else if (Configuration.doAutoCreate())
              this.allergenicIndicator = new BooleanType(); // bb
          return this.allergenicIndicator;
        }

        public boolean hasAllergenicIndicatorElement() { 
          return this.allergenicIndicator != null && !this.allergenicIndicator.isEmpty();
        }

        public boolean hasAllergenicIndicator() { 
          return this.allergenicIndicator != null && !this.allergenicIndicator.isEmpty();
        }

        /**
         * @param value {@link #allergenicIndicator} (Whether the substance is a known or suspected allergen.). This is the underlying object with id, value and extensions. The accessor "getAllergenicIndicator" gives direct access to the value
         */
        public DeviceDefinitionMaterialComponent setAllergenicIndicatorElement(BooleanType value) { 
          this.allergenicIndicator = value;
          return this;
        }

        /**
         * @return Whether the substance is a known or suspected allergen.
         */
        public boolean getAllergenicIndicator() { 
          return this.allergenicIndicator == null || this.allergenicIndicator.isEmpty() ? false : this.allergenicIndicator.getValue();
        }

        /**
         * @param value Whether the substance is a known or suspected allergen.
         */
        public DeviceDefinitionMaterialComponent setAllergenicIndicator(boolean value) { 
            if (this.allergenicIndicator == null)
              this.allergenicIndicator = new BooleanType();
            this.allergenicIndicator.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("substance", "CodeableConcept", "A substance that the device contains, may contain, or is made of - for example latex - to be used to determine patient compatibility. This is not intended to represent the composition of the device, only the clinically relevant materials.", 0, 1, substance));
          children.add(new Property("alternate", "boolean", "Indicates an alternative material of the device.", 0, 1, alternate));
          children.add(new Property("allergenicIndicator", "boolean", "Whether the substance is a known or suspected allergen.", 0, 1, allergenicIndicator));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 530040176: /*substance*/  return new Property("substance", "CodeableConcept", "A substance that the device contains, may contain, or is made of - for example latex - to be used to determine patient compatibility. This is not intended to represent the composition of the device, only the clinically relevant materials.", 0, 1, substance);
          case -1408024454: /*alternate*/  return new Property("alternate", "boolean", "Indicates an alternative material of the device.", 0, 1, alternate);
          case 75406931: /*allergenicIndicator*/  return new Property("allergenicIndicator", "boolean", "Whether the substance is a known or suspected allergen.", 0, 1, allergenicIndicator);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 530040176: /*substance*/ return this.substance == null ? new Base[0] : new Base[] {this.substance}; // CodeableConcept
        case -1408024454: /*alternate*/ return this.alternate == null ? new Base[0] : new Base[] {this.alternate}; // BooleanType
        case 75406931: /*allergenicIndicator*/ return this.allergenicIndicator == null ? new Base[0] : new Base[] {this.allergenicIndicator}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 530040176: // substance
          this.substance = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1408024454: // alternate
          this.alternate = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 75406931: // allergenicIndicator
          this.allergenicIndicator = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("substance")) {
          this.substance = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("alternate")) {
          this.alternate = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("allergenicIndicator")) {
          this.allergenicIndicator = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 530040176:  return getSubstance();
        case -1408024454:  return getAlternateElement();
        case 75406931:  return getAllergenicIndicatorElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 530040176: /*substance*/ return new String[] {"CodeableConcept"};
        case -1408024454: /*alternate*/ return new String[] {"boolean"};
        case 75406931: /*allergenicIndicator*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("substance")) {
          this.substance = new CodeableConcept();
          return this.substance;
        }
        else if (name.equals("alternate")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.material.alternate");
        }
        else if (name.equals("allergenicIndicator")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.material.allergenicIndicator");
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionMaterialComponent copy() {
        DeviceDefinitionMaterialComponent dst = new DeviceDefinitionMaterialComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionMaterialComponent dst) {
        super.copyValues(dst);
        dst.substance = substance == null ? null : substance.copy();
        dst.alternate = alternate == null ? null : alternate.copy();
        dst.allergenicIndicator = allergenicIndicator == null ? null : allergenicIndicator.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionMaterialComponent))
          return false;
        DeviceDefinitionMaterialComponent o = (DeviceDefinitionMaterialComponent) other_;
        return compareDeep(substance, o.substance, true) && compareDeep(alternate, o.alternate, true) && compareDeep(allergenicIndicator, o.allergenicIndicator, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionMaterialComponent))
          return false;
        DeviceDefinitionMaterialComponent o = (DeviceDefinitionMaterialComponent) other_;
        return compareValues(alternate, o.alternate, true) && compareValues(allergenicIndicator, o.allergenicIndicator, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(substance, alternate, allergenicIndicator
          );
      }

  public String fhirType() {
    return "DeviceDefinition.material";

  }

  }

    @Block()
    public static class DeviceDefinitionGuidelineComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The circumstances that form the setting for using the device.
         */
        @Child(name = "useContext", type = {UsageContext.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The circumstances that form the setting for using the device", formalDefinition="The circumstances that form the setting for using the device." )
        protected List<UsageContext> useContext;

        /**
         * Detailed written and visual directions for the user on how to use the device.
         */
        @Child(name = "usageInstruction", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Detailed written and visual directions for the user on how to use the device", formalDefinition="Detailed written and visual directions for the user on how to use the device." )
        protected MarkdownType usageInstruction;

        /**
         * A source of information or reference for this guideline.
         */
        @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A source of information or reference for this guideline", formalDefinition="A source of information or reference for this guideline." )
        protected List<RelatedArtifact> relatedArtifact;

        /**
         * A clinical condition for which the device was designed to be used.
         */
        @Child(name = "indication", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A clinical condition for which the device was designed to be used", formalDefinition="A clinical condition for which the device was designed to be used." )
        protected List<CodeableConcept> indication;

        /**
         * A specific situation when a device should not be used because it may cause harm.
         */
        @Child(name = "contraindication", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A specific situation when a device should not be used because it may cause harm", formalDefinition="A specific situation when a device should not be used because it may cause harm." )
        protected List<CodeableConcept> contraindication;

        /**
         * Specific hazard alert information that a user needs to know before using the device.
         */
        @Child(name = "warning", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specific hazard alert information that a user needs to know before using the device", formalDefinition="Specific hazard alert information that a user needs to know before using the device." )
        protected List<CodeableConcept> warning;

        /**
         * A description of the general purpose or medical use of the device or its function.
         */
        @Child(name = "intendedUse", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A description of the general purpose or medical use of the device or its function", formalDefinition="A description of the general purpose or medical use of the device or its function." )
        protected StringType intendedUse;

        private static final long serialVersionUID = -1323961659L;

    /**
     * Constructor
     */
      public DeviceDefinitionGuidelineComponent() {
        super();
      }

        /**
         * @return {@link #useContext} (The circumstances that form the setting for using the device.)
         */
        public List<UsageContext> getUseContext() { 
          if (this.useContext == null)
            this.useContext = new ArrayList<UsageContext>();
          return this.useContext;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionGuidelineComponent setUseContext(List<UsageContext> theUseContext) { 
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

        public DeviceDefinitionGuidelineComponent addUseContext(UsageContext t) { //3
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
         * @return {@link #usageInstruction} (Detailed written and visual directions for the user on how to use the device.). This is the underlying object with id, value and extensions. The accessor "getUsageInstruction" gives direct access to the value
         */
        public MarkdownType getUsageInstructionElement() { 
          if (this.usageInstruction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionGuidelineComponent.usageInstruction");
            else if (Configuration.doAutoCreate())
              this.usageInstruction = new MarkdownType(); // bb
          return this.usageInstruction;
        }

        public boolean hasUsageInstructionElement() { 
          return this.usageInstruction != null && !this.usageInstruction.isEmpty();
        }

        public boolean hasUsageInstruction() { 
          return this.usageInstruction != null && !this.usageInstruction.isEmpty();
        }

        /**
         * @param value {@link #usageInstruction} (Detailed written and visual directions for the user on how to use the device.). This is the underlying object with id, value and extensions. The accessor "getUsageInstruction" gives direct access to the value
         */
        public DeviceDefinitionGuidelineComponent setUsageInstructionElement(MarkdownType value) { 
          this.usageInstruction = value;
          return this;
        }

        /**
         * @return Detailed written and visual directions for the user on how to use the device.
         */
        public String getUsageInstruction() { 
          return this.usageInstruction == null ? null : this.usageInstruction.getValue();
        }

        /**
         * @param value Detailed written and visual directions for the user on how to use the device.
         */
        public DeviceDefinitionGuidelineComponent setUsageInstruction(String value) { 
          if (Utilities.noString(value))
            this.usageInstruction = null;
          else {
            if (this.usageInstruction == null)
              this.usageInstruction = new MarkdownType();
            this.usageInstruction.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #relatedArtifact} (A source of information or reference for this guideline.)
         */
        public List<RelatedArtifact> getRelatedArtifact() { 
          if (this.relatedArtifact == null)
            this.relatedArtifact = new ArrayList<RelatedArtifact>();
          return this.relatedArtifact;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionGuidelineComponent setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
          this.relatedArtifact = theRelatedArtifact;
          return this;
        }

        public boolean hasRelatedArtifact() { 
          if (this.relatedArtifact == null)
            return false;
          for (RelatedArtifact item : this.relatedArtifact)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RelatedArtifact addRelatedArtifact() { //3
          RelatedArtifact t = new RelatedArtifact();
          if (this.relatedArtifact == null)
            this.relatedArtifact = new ArrayList<RelatedArtifact>();
          this.relatedArtifact.add(t);
          return t;
        }

        public DeviceDefinitionGuidelineComponent addRelatedArtifact(RelatedArtifact t) { //3
          if (t == null)
            return this;
          if (this.relatedArtifact == null)
            this.relatedArtifact = new ArrayList<RelatedArtifact>();
          this.relatedArtifact.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
         */
        public RelatedArtifact getRelatedArtifactFirstRep() { 
          if (getRelatedArtifact().isEmpty()) {
            addRelatedArtifact();
          }
          return getRelatedArtifact().get(0);
        }

        /**
         * @return {@link #indication} (A clinical condition for which the device was designed to be used.)
         */
        public List<CodeableConcept> getIndication() { 
          if (this.indication == null)
            this.indication = new ArrayList<CodeableConcept>();
          return this.indication;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionGuidelineComponent setIndication(List<CodeableConcept> theIndication) { 
          this.indication = theIndication;
          return this;
        }

        public boolean hasIndication() { 
          if (this.indication == null)
            return false;
          for (CodeableConcept item : this.indication)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addIndication() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.indication == null)
            this.indication = new ArrayList<CodeableConcept>();
          this.indication.add(t);
          return t;
        }

        public DeviceDefinitionGuidelineComponent addIndication(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.indication == null)
            this.indication = new ArrayList<CodeableConcept>();
          this.indication.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #indication}, creating it if it does not already exist {3}
         */
        public CodeableConcept getIndicationFirstRep() { 
          if (getIndication().isEmpty()) {
            addIndication();
          }
          return getIndication().get(0);
        }

        /**
         * @return {@link #contraindication} (A specific situation when a device should not be used because it may cause harm.)
         */
        public List<CodeableConcept> getContraindication() { 
          if (this.contraindication == null)
            this.contraindication = new ArrayList<CodeableConcept>();
          return this.contraindication;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionGuidelineComponent setContraindication(List<CodeableConcept> theContraindication) { 
          this.contraindication = theContraindication;
          return this;
        }

        public boolean hasContraindication() { 
          if (this.contraindication == null)
            return false;
          for (CodeableConcept item : this.contraindication)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addContraindication() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.contraindication == null)
            this.contraindication = new ArrayList<CodeableConcept>();
          this.contraindication.add(t);
          return t;
        }

        public DeviceDefinitionGuidelineComponent addContraindication(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.contraindication == null)
            this.contraindication = new ArrayList<CodeableConcept>();
          this.contraindication.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #contraindication}, creating it if it does not already exist {3}
         */
        public CodeableConcept getContraindicationFirstRep() { 
          if (getContraindication().isEmpty()) {
            addContraindication();
          }
          return getContraindication().get(0);
        }

        /**
         * @return {@link #warning} (Specific hazard alert information that a user needs to know before using the device.)
         */
        public List<CodeableConcept> getWarning() { 
          if (this.warning == null)
            this.warning = new ArrayList<CodeableConcept>();
          return this.warning;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionGuidelineComponent setWarning(List<CodeableConcept> theWarning) { 
          this.warning = theWarning;
          return this;
        }

        public boolean hasWarning() { 
          if (this.warning == null)
            return false;
          for (CodeableConcept item : this.warning)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addWarning() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.warning == null)
            this.warning = new ArrayList<CodeableConcept>();
          this.warning.add(t);
          return t;
        }

        public DeviceDefinitionGuidelineComponent addWarning(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.warning == null)
            this.warning = new ArrayList<CodeableConcept>();
          this.warning.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #warning}, creating it if it does not already exist {3}
         */
        public CodeableConcept getWarningFirstRep() { 
          if (getWarning().isEmpty()) {
            addWarning();
          }
          return getWarning().get(0);
        }

        /**
         * @return {@link #intendedUse} (A description of the general purpose or medical use of the device or its function.). This is the underlying object with id, value and extensions. The accessor "getIntendedUse" gives direct access to the value
         */
        public StringType getIntendedUseElement() { 
          if (this.intendedUse == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionGuidelineComponent.intendedUse");
            else if (Configuration.doAutoCreate())
              this.intendedUse = new StringType(); // bb
          return this.intendedUse;
        }

        public boolean hasIntendedUseElement() { 
          return this.intendedUse != null && !this.intendedUse.isEmpty();
        }

        public boolean hasIntendedUse() { 
          return this.intendedUse != null && !this.intendedUse.isEmpty();
        }

        /**
         * @param value {@link #intendedUse} (A description of the general purpose or medical use of the device or its function.). This is the underlying object with id, value and extensions. The accessor "getIntendedUse" gives direct access to the value
         */
        public DeviceDefinitionGuidelineComponent setIntendedUseElement(StringType value) { 
          this.intendedUse = value;
          return this;
        }

        /**
         * @return A description of the general purpose or medical use of the device or its function.
         */
        public String getIntendedUse() { 
          return this.intendedUse == null ? null : this.intendedUse.getValue();
        }

        /**
         * @param value A description of the general purpose or medical use of the device or its function.
         */
        public DeviceDefinitionGuidelineComponent setIntendedUse(String value) { 
          if (Utilities.noString(value))
            this.intendedUse = null;
          else {
            if (this.intendedUse == null)
              this.intendedUse = new StringType();
            this.intendedUse.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("useContext", "UsageContext", "The circumstances that form the setting for using the device.", 0, java.lang.Integer.MAX_VALUE, useContext));
          children.add(new Property("usageInstruction", "markdown", "Detailed written and visual directions for the user on how to use the device.", 0, 1, usageInstruction));
          children.add(new Property("relatedArtifact", "RelatedArtifact", "A source of information or reference for this guideline.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
          children.add(new Property("indication", "CodeableConcept", "A clinical condition for which the device was designed to be used.", 0, java.lang.Integer.MAX_VALUE, indication));
          children.add(new Property("contraindication", "CodeableConcept", "A specific situation when a device should not be used because it may cause harm.", 0, java.lang.Integer.MAX_VALUE, contraindication));
          children.add(new Property("warning", "CodeableConcept", "Specific hazard alert information that a user needs to know before using the device.", 0, java.lang.Integer.MAX_VALUE, warning));
          children.add(new Property("intendedUse", "string", "A description of the general purpose or medical use of the device or its function.", 0, 1, intendedUse));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The circumstances that form the setting for using the device.", 0, java.lang.Integer.MAX_VALUE, useContext);
          case 2138372141: /*usageInstruction*/  return new Property("usageInstruction", "markdown", "Detailed written and visual directions for the user on how to use the device.", 0, 1, usageInstruction);
          case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "A source of information or reference for this guideline.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
          case -597168804: /*indication*/  return new Property("indication", "CodeableConcept", "A clinical condition for which the device was designed to be used.", 0, java.lang.Integer.MAX_VALUE, indication);
          case 107135229: /*contraindication*/  return new Property("contraindication", "CodeableConcept", "A specific situation when a device should not be used because it may cause harm.", 0, java.lang.Integer.MAX_VALUE, contraindication);
          case 1124446108: /*warning*/  return new Property("warning", "CodeableConcept", "Specific hazard alert information that a user needs to know before using the device.", 0, java.lang.Integer.MAX_VALUE, warning);
          case -1618671268: /*intendedUse*/  return new Property("intendedUse", "string", "A description of the general purpose or medical use of the device or its function.", 0, 1, intendedUse);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case 2138372141: /*usageInstruction*/ return this.usageInstruction == null ? new Base[0] : new Base[] {this.usageInstruction}; // MarkdownType
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : this.indication.toArray(new Base[this.indication.size()]); // CodeableConcept
        case 107135229: /*contraindication*/ return this.contraindication == null ? new Base[0] : this.contraindication.toArray(new Base[this.contraindication.size()]); // CodeableConcept
        case 1124446108: /*warning*/ return this.warning == null ? new Base[0] : this.warning.toArray(new Base[this.warning.size()]); // CodeableConcept
        case -1618671268: /*intendedUse*/ return this.intendedUse == null ? new Base[0] : new Base[] {this.intendedUse}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case 2138372141: // usageInstruction
          this.usageInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case -597168804: // indication
          this.getIndication().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 107135229: // contraindication
          this.getContraindication().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1124446108: // warning
          this.getWarning().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1618671268: // intendedUse
          this.intendedUse = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("usageInstruction")) {
          this.usageInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("indication")) {
          this.getIndication().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("contraindication")) {
          this.getContraindication().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("warning")) {
          this.getWarning().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("intendedUse")) {
          this.intendedUse = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -669707736:  return addUseContext(); 
        case 2138372141:  return getUsageInstructionElement();
        case 666807069:  return addRelatedArtifact(); 
        case -597168804:  return addIndication(); 
        case 107135229:  return addContraindication(); 
        case 1124446108:  return addWarning(); 
        case -1618671268:  return getIntendedUseElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case 2138372141: /*usageInstruction*/ return new String[] {"markdown"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -597168804: /*indication*/ return new String[] {"CodeableConcept"};
        case 107135229: /*contraindication*/ return new String[] {"CodeableConcept"};
        case 1124446108: /*warning*/ return new String[] {"CodeableConcept"};
        case -1618671268: /*intendedUse*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("usageInstruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.guideline.usageInstruction");
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("indication")) {
          return addIndication();
        }
        else if (name.equals("contraindication")) {
          return addContraindication();
        }
        else if (name.equals("warning")) {
          return addWarning();
        }
        else if (name.equals("intendedUse")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.guideline.intendedUse");
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionGuidelineComponent copy() {
        DeviceDefinitionGuidelineComponent dst = new DeviceDefinitionGuidelineComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionGuidelineComponent dst) {
        super.copyValues(dst);
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        dst.usageInstruction = usageInstruction == null ? null : usageInstruction.copy();
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        if (indication != null) {
          dst.indication = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : indication)
            dst.indication.add(i.copy());
        };
        if (contraindication != null) {
          dst.contraindication = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : contraindication)
            dst.contraindication.add(i.copy());
        };
        if (warning != null) {
          dst.warning = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : warning)
            dst.warning.add(i.copy());
        };
        dst.intendedUse = intendedUse == null ? null : intendedUse.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionGuidelineComponent))
          return false;
        DeviceDefinitionGuidelineComponent o = (DeviceDefinitionGuidelineComponent) other_;
        return compareDeep(useContext, o.useContext, true) && compareDeep(usageInstruction, o.usageInstruction, true)
           && compareDeep(relatedArtifact, o.relatedArtifact, true) && compareDeep(indication, o.indication, true)
           && compareDeep(contraindication, o.contraindication, true) && compareDeep(warning, o.warning, true)
           && compareDeep(intendedUse, o.intendedUse, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionGuidelineComponent))
          return false;
        DeviceDefinitionGuidelineComponent o = (DeviceDefinitionGuidelineComponent) other_;
        return compareValues(usageInstruction, o.usageInstruction, true) && compareValues(intendedUse, o.intendedUse, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(useContext, usageInstruction
          , relatedArtifact, indication, contraindication, warning, intendedUse);
      }

  public String fhirType() {
    return "DeviceDefinition.guideline";

  }

  }

    @Block()
    public static class DeviceDefinitionCorrectiveActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether the last corrective action known for this device was a recall.
         */
        @Child(name = "recall", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the corrective action was a recall", formalDefinition="Whether the last corrective action known for this device was a recall." )
        protected BooleanType recall;

        /**
         * The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.
         */
        @Child(name = "scope", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="model | lot-numbers | serial-numbers", formalDefinition="The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-correctiveactionscope")
        protected Enumeration<DeviceCorrectiveActionScope> scope;

        /**
         * Start and end dates of the  corrective action.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Start and end dates of the  corrective action", formalDefinition="Start and end dates of the  corrective action." )
        protected Period period;

        private static final long serialVersionUID = -1936691252L;

    /**
     * Constructor
     */
      public DeviceDefinitionCorrectiveActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionCorrectiveActionComponent(boolean recall, Period period) {
        super();
        this.setRecall(recall);
        this.setPeriod(period);
      }

        /**
         * @return {@link #recall} (Whether the last corrective action known for this device was a recall.). This is the underlying object with id, value and extensions. The accessor "getRecall" gives direct access to the value
         */
        public BooleanType getRecallElement() { 
          if (this.recall == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionCorrectiveActionComponent.recall");
            else if (Configuration.doAutoCreate())
              this.recall = new BooleanType(); // bb
          return this.recall;
        }

        public boolean hasRecallElement() { 
          return this.recall != null && !this.recall.isEmpty();
        }

        public boolean hasRecall() { 
          return this.recall != null && !this.recall.isEmpty();
        }

        /**
         * @param value {@link #recall} (Whether the last corrective action known for this device was a recall.). This is the underlying object with id, value and extensions. The accessor "getRecall" gives direct access to the value
         */
        public DeviceDefinitionCorrectiveActionComponent setRecallElement(BooleanType value) { 
          this.recall = value;
          return this;
        }

        /**
         * @return Whether the last corrective action known for this device was a recall.
         */
        public boolean getRecall() { 
          return this.recall == null || this.recall.isEmpty() ? false : this.recall.getValue();
        }

        /**
         * @param value Whether the last corrective action known for this device was a recall.
         */
        public DeviceDefinitionCorrectiveActionComponent setRecall(boolean value) { 
            if (this.recall == null)
              this.recall = new BooleanType();
            this.recall.setValue(value);
          return this;
        }

        /**
         * @return {@link #scope} (The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.). This is the underlying object with id, value and extensions. The accessor "getScope" gives direct access to the value
         */
        public Enumeration<DeviceCorrectiveActionScope> getScopeElement() { 
          if (this.scope == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionCorrectiveActionComponent.scope");
            else if (Configuration.doAutoCreate())
              this.scope = new Enumeration<DeviceCorrectiveActionScope>(new DeviceCorrectiveActionScopeEnumFactory()); // bb
          return this.scope;
        }

        public boolean hasScopeElement() { 
          return this.scope != null && !this.scope.isEmpty();
        }

        public boolean hasScope() { 
          return this.scope != null && !this.scope.isEmpty();
        }

        /**
         * @param value {@link #scope} (The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.). This is the underlying object with id, value and extensions. The accessor "getScope" gives direct access to the value
         */
        public DeviceDefinitionCorrectiveActionComponent setScopeElement(Enumeration<DeviceCorrectiveActionScope> value) { 
          this.scope = value;
          return this;
        }

        /**
         * @return The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.
         */
        public DeviceCorrectiveActionScope getScope() { 
          return this.scope == null ? null : this.scope.getValue();
        }

        /**
         * @param value The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.
         */
        public DeviceDefinitionCorrectiveActionComponent setScope(DeviceCorrectiveActionScope value) { 
          if (value == null)
            this.scope = null;
          else {
            if (this.scope == null)
              this.scope = new Enumeration<DeviceCorrectiveActionScope>(new DeviceCorrectiveActionScopeEnumFactory());
            this.scope.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #period} (Start and end dates of the  corrective action.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionCorrectiveActionComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Start and end dates of the  corrective action.)
         */
        public DeviceDefinitionCorrectiveActionComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("recall", "boolean", "Whether the last corrective action known for this device was a recall.", 0, 1, recall));
          children.add(new Property("scope", "code", "The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.", 0, 1, scope));
          children.add(new Property("period", "Period", "Start and end dates of the  corrective action.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -934922479: /*recall*/  return new Property("recall", "boolean", "Whether the last corrective action known for this device was a recall.", 0, 1, recall);
          case 109264468: /*scope*/  return new Property("scope", "code", "The scope of the corrective action - whether the action targeted all units of a given device model, or only a specific set of batches identified by lot numbers, or individually identified devices identified by the serial name.", 0, 1, scope);
          case -991726143: /*period*/  return new Property("period", "Period", "Start and end dates of the  corrective action.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -934922479: /*recall*/ return this.recall == null ? new Base[0] : new Base[] {this.recall}; // BooleanType
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : new Base[] {this.scope}; // Enumeration<DeviceCorrectiveActionScope>
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -934922479: // recall
          this.recall = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 109264468: // scope
          value = new DeviceCorrectiveActionScopeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.scope = (Enumeration) value; // Enumeration<DeviceCorrectiveActionScope>
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("recall")) {
          this.recall = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("scope")) {
          value = new DeviceCorrectiveActionScopeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.scope = (Enumeration) value; // Enumeration<DeviceCorrectiveActionScope>
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -934922479:  return getRecallElement();
        case 109264468:  return getScopeElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -934922479: /*recall*/ return new String[] {"boolean"};
        case 109264468: /*scope*/ return new String[] {"code"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("recall")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.correctiveAction.recall");
        }
        else if (name.equals("scope")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.correctiveAction.scope");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionCorrectiveActionComponent copy() {
        DeviceDefinitionCorrectiveActionComponent dst = new DeviceDefinitionCorrectiveActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionCorrectiveActionComponent dst) {
        super.copyValues(dst);
        dst.recall = recall == null ? null : recall.copy();
        dst.scope = scope == null ? null : scope.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionCorrectiveActionComponent))
          return false;
        DeviceDefinitionCorrectiveActionComponent o = (DeviceDefinitionCorrectiveActionComponent) other_;
        return compareDeep(recall, o.recall, true) && compareDeep(scope, o.scope, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionCorrectiveActionComponent))
          return false;
        DeviceDefinitionCorrectiveActionComponent o = (DeviceDefinitionCorrectiveActionComponent) other_;
        return compareValues(recall, o.recall, true) && compareValues(scope, o.scope, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(recall, scope, period);
      }

  public String fhirType() {
    return "DeviceDefinition.correctiveAction";

  }

  }

    @Block()
    public static class DeviceDefinitionChargeItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The code or reference for the charge item.
         */
        @Child(name = "chargeItemCode", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The code or reference for the charge item", formalDefinition="The code or reference for the charge item." )
        protected CodeableReference chargeItemCode;

        /**
         * Coefficient applicable to the billing code.
         */
        @Child(name = "count", type = {Quantity.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Coefficient applicable to the billing code", formalDefinition="Coefficient applicable to the billing code." )
        protected Quantity count;

        /**
         * A specific time period in which this charge item applies.
         */
        @Child(name = "effectivePeriod", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A specific time period in which this charge item applies", formalDefinition="A specific time period in which this charge item applies." )
        protected Period effectivePeriod;

        /**
         * The context to which this charge item applies.
         */
        @Child(name = "useContext", type = {UsageContext.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The context to which this charge item applies", formalDefinition="The context to which this charge item applies." )
        protected List<UsageContext> useContext;

        private static final long serialVersionUID = 1312166907L;

    /**
     * Constructor
     */
      public DeviceDefinitionChargeItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDefinitionChargeItemComponent(CodeableReference chargeItemCode, Quantity count) {
        super();
        this.setChargeItemCode(chargeItemCode);
        this.setCount(count);
      }

        /**
         * @return {@link #chargeItemCode} (The code or reference for the charge item.)
         */
        public CodeableReference getChargeItemCode() { 
          if (this.chargeItemCode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionChargeItemComponent.chargeItemCode");
            else if (Configuration.doAutoCreate())
              this.chargeItemCode = new CodeableReference(); // cc
          return this.chargeItemCode;
        }

        public boolean hasChargeItemCode() { 
          return this.chargeItemCode != null && !this.chargeItemCode.isEmpty();
        }

        /**
         * @param value {@link #chargeItemCode} (The code or reference for the charge item.)
         */
        public DeviceDefinitionChargeItemComponent setChargeItemCode(CodeableReference value) { 
          this.chargeItemCode = value;
          return this;
        }

        /**
         * @return {@link #count} (Coefficient applicable to the billing code.)
         */
        public Quantity getCount() { 
          if (this.count == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionChargeItemComponent.count");
            else if (Configuration.doAutoCreate())
              this.count = new Quantity(); // cc
          return this.count;
        }

        public boolean hasCount() { 
          return this.count != null && !this.count.isEmpty();
        }

        /**
         * @param value {@link #count} (Coefficient applicable to the billing code.)
         */
        public DeviceDefinitionChargeItemComponent setCount(Quantity value) { 
          this.count = value;
          return this;
        }

        /**
         * @return {@link #effectivePeriod} (A specific time period in which this charge item applies.)
         */
        public Period getEffectivePeriod() { 
          if (this.effectivePeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDefinitionChargeItemComponent.effectivePeriod");
            else if (Configuration.doAutoCreate())
              this.effectivePeriod = new Period(); // cc
          return this.effectivePeriod;
        }

        public boolean hasEffectivePeriod() { 
          return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
        }

        /**
         * @param value {@link #effectivePeriod} (A specific time period in which this charge item applies.)
         */
        public DeviceDefinitionChargeItemComponent setEffectivePeriod(Period value) { 
          this.effectivePeriod = value;
          return this;
        }

        /**
         * @return {@link #useContext} (The context to which this charge item applies.)
         */
        public List<UsageContext> getUseContext() { 
          if (this.useContext == null)
            this.useContext = new ArrayList<UsageContext>();
          return this.useContext;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceDefinitionChargeItemComponent setUseContext(List<UsageContext> theUseContext) { 
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

        public DeviceDefinitionChargeItemComponent addUseContext(UsageContext t) { //3
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("chargeItemCode", "CodeableReference(ChargeItemDefinition)", "The code or reference for the charge item.", 0, 1, chargeItemCode));
          children.add(new Property("count", "Quantity", "Coefficient applicable to the billing code.", 0, 1, count));
          children.add(new Property("effectivePeriod", "Period", "A specific time period in which this charge item applies.", 0, 1, effectivePeriod));
          children.add(new Property("useContext", "UsageContext", "The context to which this charge item applies.", 0, java.lang.Integer.MAX_VALUE, useContext));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -2001375628: /*chargeItemCode*/  return new Property("chargeItemCode", "CodeableReference(ChargeItemDefinition)", "The code or reference for the charge item.", 0, 1, chargeItemCode);
          case 94851343: /*count*/  return new Property("count", "Quantity", "Coefficient applicable to the billing code.", 0, 1, count);
          case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "A specific time period in which this charge item applies.", 0, 1, effectivePeriod);
          case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The context to which this charge item applies.", 0, java.lang.Integer.MAX_VALUE, useContext);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -2001375628: /*chargeItemCode*/ return this.chargeItemCode == null ? new Base[0] : new Base[] {this.chargeItemCode}; // CodeableReference
        case 94851343: /*count*/ return this.count == null ? new Base[0] : new Base[] {this.count}; // Quantity
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -2001375628: // chargeItemCode
          this.chargeItemCode = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 94851343: // count
          this.count = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("chargeItemCode")) {
          this.chargeItemCode = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("count")) {
          this.count = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2001375628:  return getChargeItemCode();
        case 94851343:  return getCount();
        case -403934648:  return getEffectivePeriod();
        case -669707736:  return addUseContext(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2001375628: /*chargeItemCode*/ return new String[] {"CodeableReference"};
        case 94851343: /*count*/ return new String[] {"Quantity"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("chargeItemCode")) {
          this.chargeItemCode = new CodeableReference();
          return this.chargeItemCode;
        }
        else if (name.equals("count")) {
          this.count = new Quantity();
          return this.count;
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else
          return super.addChild(name);
      }

      public DeviceDefinitionChargeItemComponent copy() {
        DeviceDefinitionChargeItemComponent dst = new DeviceDefinitionChargeItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinitionChargeItemComponent dst) {
        super.copyValues(dst);
        dst.chargeItemCode = chargeItemCode == null ? null : chargeItemCode.copy();
        dst.count = count == null ? null : count.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionChargeItemComponent))
          return false;
        DeviceDefinitionChargeItemComponent o = (DeviceDefinitionChargeItemComponent) other_;
        return compareDeep(chargeItemCode, o.chargeItemCode, true) && compareDeep(count, o.count, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(useContext, o.useContext, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinitionChargeItemComponent))
          return false;
        DeviceDefinitionChargeItemComponent o = (DeviceDefinitionChargeItemComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(chargeItemCode, count, effectivePeriod
          , useContext);
      }

  public String fhirType() {
    return "DeviceDefinition.chargeItem";

  }

  }

    /**
     * Additional information to describe the device.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Additional information to describe the device", formalDefinition="Additional information to describe the device." )
    protected MarkdownType description;

    /**
     * Unique instance identifiers assigned to a device by the software, manufacturers, other organizations or owners. For example: handle ID. The identifier is typically valued if the udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type of identifier.  However, it is permissible to still include those identifiers in DeviceDefinition.identifier with the appropriate identifier.type.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instance identifier", formalDefinition="Unique instance identifiers assigned to a device by the software, manufacturers, other organizations or owners. For example: handle ID. The identifier is typically valued if the udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type of identifier.  However, it is permissible to still include those identifiers in DeviceDefinition.identifier with the appropriate identifier.type." )
    protected List<Identifier> identifier;

    /**
     * Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.
     */
    @Child(name = "udiDeviceIdentifier", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Unique Device Identifier (UDI) Barcode string", formalDefinition="Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold." )
    protected List<DeviceDefinitionUdiDeviceIdentifierComponent> udiDeviceIdentifier;

    /**
     * Identifier associated with the regulatory documentation (certificates, technical documentation, post-market surveillance documentation and reports) of a set of device models sharing the same intended purpose, risk class and essential design and manufacturing characteristics. One example is the Basic UDI-DI in Europe.
     */
    @Child(name = "regulatoryIdentifier", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Regulatory identifier(s) associated with this device", formalDefinition="Identifier associated with the regulatory documentation (certificates, technical documentation, post-market surveillance documentation and reports) of a set of device models sharing the same intended purpose, risk class and essential design and manufacturing characteristics. One example is the Basic UDI-DI in Europe." )
    protected List<DeviceDefinitionRegulatoryIdentifierComponent> regulatoryIdentifier;

    /**
     * The part number or catalog number of the device.
     */
    @Child(name = "partNumber", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The part number or catalog number of the device", formalDefinition="The part number or catalog number of the device." )
    protected StringType partNumber;

    /**
     * A name of the manufacturer  or legal representative e.g. labeler. Whether this is the actual manufacturer or the labeler or responsible depends on implementation and jurisdiction.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of device manufacturer", formalDefinition="A name of the manufacturer  or legal representative e.g. labeler. Whether this is the actual manufacturer or the labeler or responsible depends on implementation and jurisdiction." )
    protected Reference manufacturer;

    /**
     * The name or names of the device as given by the manufacturer.
     */
    @Child(name = "deviceName", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The name or names of the device as given by the manufacturer", formalDefinition="The name or names of the device as given by the manufacturer." )
    protected List<DeviceDefinitionDeviceNameComponent> deviceName;

    /**
     * The model number for the device for example as defined by the manufacturer or labeler, or other agency.
     */
    @Child(name = "modelNumber", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The catalog or model number for the device for example as defined by the manufacturer", formalDefinition="The model number for the device for example as defined by the manufacturer or labeler, or other agency." )
    protected StringType modelNumber;

    /**
     * What kind of device or device system this is.
     */
    @Child(name = "classification", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What kind of device or device system this is", formalDefinition="What kind of device or device system this is." )
    protected List<DeviceDefinitionClassificationComponent> classification;

    /**
     * Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.
     */
    @Child(name = "conformsTo", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifies the standards, specifications, or formal guidances for the capabilities supported by the device", formalDefinition="Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards." )
    protected List<DeviceDefinitionConformsToComponent> conformsTo;

    /**
     * A device that is part (for example a component) of the present device.
     */
    @Child(name = "hasPart", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A device, part of the current one", formalDefinition="A device that is part (for example a component) of the present device." )
    protected List<DeviceDefinitionHasPartComponent> hasPart;

    /**
     * Information about the packaging of the device, i.e. how the device is packaged.
     */
    @Child(name = "packaging", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information about the packaging of the device, i.e. how the device is packaged", formalDefinition="Information about the packaging of the device, i.e. how the device is packaged." )
    protected List<DeviceDefinitionPackagingComponent> packaging;

    /**
     * The version of the device or software.
     */
    @Child(name = "version", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The version of the device or software", formalDefinition="The version of the device or software." )
    protected List<DeviceDefinitionVersionComponent> version;

    /**
     * Safety characteristics of the device.
     */
    @Child(name = "safety", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Safety characteristics of the device", formalDefinition="Safety characteristics of the device." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-safety")
    protected List<CodeableConcept> safety;

    /**
     * Shelf Life and storage information.
     */
    @Child(name = "shelfLifeStorage", type = {ProductShelfLife.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Shelf Life and storage information", formalDefinition="Shelf Life and storage information." )
    protected List<ProductShelfLife> shelfLifeStorage;

    /**
     * Language code for the human-readable text strings produced by the device (all supported).
     */
    @Child(name = "languageCode", type = {CodeableConcept.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Language code for the human-readable text strings produced by the device (all supported)", formalDefinition="Language code for the human-readable text strings produced by the device (all supported)." )
    protected List<CodeableConcept> languageCode;

    /**
     * The potential, valid configuration settings of a device, e.g., regulation status, time properties.
     */
    @Child(name = "property", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The potential, valid configuration settings of a device, e.g., regulation status, time properties", formalDefinition="The potential, valid configuration settings of a device, e.g., regulation status, time properties." )
    protected List<DeviceDefinitionPropertyComponent> property;

    /**
     * An organization that is responsible for the provision and ongoing maintenance of the device.
     */
    @Child(name = "owner", type = {Organization.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization responsible for device", formalDefinition="An organization that is responsible for the provision and ongoing maintenance of the device." )
    protected Reference owner;

    /**
     * Contact details for an organization or a particular human that is responsible for the device.
     */
    @Child(name = "contact", type = {ContactPoint.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details for human/organization for support", formalDefinition="Contact details for an organization or a particular human that is responsible for the device." )
    protected List<ContactPoint> contact;

    /**
     * An associated device, attached to, used with, communicating with or linking a previous or new device model to the focal device.
     */
    @Child(name = "link", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An associated device, attached to, used with, communicating with or linking a previous or new device model to the focal device", formalDefinition="An associated device, attached to, used with, communicating with or linking a previous or new device model to the focal device." )
    protected List<DeviceDefinitionLinkComponent> link;

    /**
     * Descriptive information, usage information or implantation information that is not captured in an existing element.
     */
    @Child(name = "note", type = {Annotation.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Device notes and comments", formalDefinition="Descriptive information, usage information or implantation information that is not captured in an existing element." )
    protected List<Annotation> note;

    /**
     * A substance used to create the material(s) of which the device is made.
     */
    @Child(name = "material", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A substance used to create the material(s) of which the device is made", formalDefinition="A substance used to create the material(s) of which the device is made." )
    protected List<DeviceDefinitionMaterialComponent> material;

    /**
     * Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.
     */
    @Child(name = "productionIdentifierInUDI", type = {CodeType.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="lot-number | manufactured-date | serial-number | expiration-date | biological-source | software-version", formalDefinition="Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-productidentifierinudi")
    protected List<Enumeration<DeviceProductionIdentifierInUDI>> productionIdentifierInUDI;

    /**
     * Information aimed at providing directions for the usage of this model of device.
     */
    @Child(name = "guideline", type = {}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Information aimed at providing directions for the usage of this model of device", formalDefinition="Information aimed at providing directions for the usage of this model of device." )
    protected DeviceDefinitionGuidelineComponent guideline;

    /**
     * Tracking of latest field safety corrective action.
     */
    @Child(name = "correctiveAction", type = {}, order=24, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Tracking of latest field safety corrective action", formalDefinition="Tracking of latest field safety corrective action." )
    protected DeviceDefinitionCorrectiveActionComponent correctiveAction;

    /**
     * Billing code or reference associated with the device.
     */
    @Child(name = "chargeItem", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Billing code or reference associated with the device", formalDefinition="Billing code or reference associated with the device." )
    protected List<DeviceDefinitionChargeItemComponent> chargeItem;

    private static final long serialVersionUID = -260935704L;

  /**
   * Constructor
   */
    public DeviceDefinition() {
      super();
    }

    /**
     * @return {@link #description} (Additional information to describe the device.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.description");
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
     * @param value {@link #description} (Additional information to describe the device.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public DeviceDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Additional information to describe the device.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Additional information to describe the device.
     */
    public DeviceDefinition setDescription(String value) { 
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
     * @return {@link #identifier} (Unique instance identifiers assigned to a device by the software, manufacturers, other organizations or owners. For example: handle ID. The identifier is typically valued if the udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type of identifier.  However, it is permissible to still include those identifiers in DeviceDefinition.identifier with the appropriate identifier.type.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public DeviceDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #udiDeviceIdentifier} (Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.)
     */
    public List<DeviceDefinitionUdiDeviceIdentifierComponent> getUdiDeviceIdentifier() { 
      if (this.udiDeviceIdentifier == null)
        this.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
      return this.udiDeviceIdentifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setUdiDeviceIdentifier(List<DeviceDefinitionUdiDeviceIdentifierComponent> theUdiDeviceIdentifier) { 
      this.udiDeviceIdentifier = theUdiDeviceIdentifier;
      return this;
    }

    public boolean hasUdiDeviceIdentifier() { 
      if (this.udiDeviceIdentifier == null)
        return false;
      for (DeviceDefinitionUdiDeviceIdentifierComponent item : this.udiDeviceIdentifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionUdiDeviceIdentifierComponent addUdiDeviceIdentifier() { //3
      DeviceDefinitionUdiDeviceIdentifierComponent t = new DeviceDefinitionUdiDeviceIdentifierComponent();
      if (this.udiDeviceIdentifier == null)
        this.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
      this.udiDeviceIdentifier.add(t);
      return t;
    }

    public DeviceDefinition addUdiDeviceIdentifier(DeviceDefinitionUdiDeviceIdentifierComponent t) { //3
      if (t == null)
        return this;
      if (this.udiDeviceIdentifier == null)
        this.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
      this.udiDeviceIdentifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #udiDeviceIdentifier}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionUdiDeviceIdentifierComponent getUdiDeviceIdentifierFirstRep() { 
      if (getUdiDeviceIdentifier().isEmpty()) {
        addUdiDeviceIdentifier();
      }
      return getUdiDeviceIdentifier().get(0);
    }

    /**
     * @return {@link #regulatoryIdentifier} (Identifier associated with the regulatory documentation (certificates, technical documentation, post-market surveillance documentation and reports) of a set of device models sharing the same intended purpose, risk class and essential design and manufacturing characteristics. One example is the Basic UDI-DI in Europe.)
     */
    public List<DeviceDefinitionRegulatoryIdentifierComponent> getRegulatoryIdentifier() { 
      if (this.regulatoryIdentifier == null)
        this.regulatoryIdentifier = new ArrayList<DeviceDefinitionRegulatoryIdentifierComponent>();
      return this.regulatoryIdentifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setRegulatoryIdentifier(List<DeviceDefinitionRegulatoryIdentifierComponent> theRegulatoryIdentifier) { 
      this.regulatoryIdentifier = theRegulatoryIdentifier;
      return this;
    }

    public boolean hasRegulatoryIdentifier() { 
      if (this.regulatoryIdentifier == null)
        return false;
      for (DeviceDefinitionRegulatoryIdentifierComponent item : this.regulatoryIdentifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionRegulatoryIdentifierComponent addRegulatoryIdentifier() { //3
      DeviceDefinitionRegulatoryIdentifierComponent t = new DeviceDefinitionRegulatoryIdentifierComponent();
      if (this.regulatoryIdentifier == null)
        this.regulatoryIdentifier = new ArrayList<DeviceDefinitionRegulatoryIdentifierComponent>();
      this.regulatoryIdentifier.add(t);
      return t;
    }

    public DeviceDefinition addRegulatoryIdentifier(DeviceDefinitionRegulatoryIdentifierComponent t) { //3
      if (t == null)
        return this;
      if (this.regulatoryIdentifier == null)
        this.regulatoryIdentifier = new ArrayList<DeviceDefinitionRegulatoryIdentifierComponent>();
      this.regulatoryIdentifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #regulatoryIdentifier}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionRegulatoryIdentifierComponent getRegulatoryIdentifierFirstRep() { 
      if (getRegulatoryIdentifier().isEmpty()) {
        addRegulatoryIdentifier();
      }
      return getRegulatoryIdentifier().get(0);
    }

    /**
     * @return {@link #partNumber} (The part number or catalog number of the device.). This is the underlying object with id, value and extensions. The accessor "getPartNumber" gives direct access to the value
     */
    public StringType getPartNumberElement() { 
      if (this.partNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.partNumber");
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
    public DeviceDefinition setPartNumberElement(StringType value) { 
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
    public DeviceDefinition setPartNumber(String value) { 
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
     * @return {@link #manufacturer} (A name of the manufacturer  or legal representative e.g. labeler. Whether this is the actual manufacturer or the labeler or responsible depends on implementation and jurisdiction.)
     */
    public Reference getManufacturer() { 
      if (this.manufacturer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.manufacturer");
        else if (Configuration.doAutoCreate())
          this.manufacturer = new Reference(); // cc
      return this.manufacturer;
    }

    public boolean hasManufacturer() { 
      return this.manufacturer != null && !this.manufacturer.isEmpty();
    }

    /**
     * @param value {@link #manufacturer} (A name of the manufacturer  or legal representative e.g. labeler. Whether this is the actual manufacturer or the labeler or responsible depends on implementation and jurisdiction.)
     */
    public DeviceDefinition setManufacturer(Reference value) { 
      this.manufacturer = value;
      return this;
    }

    /**
     * @return {@link #deviceName} (The name or names of the device as given by the manufacturer.)
     */
    public List<DeviceDefinitionDeviceNameComponent> getDeviceName() { 
      if (this.deviceName == null)
        this.deviceName = new ArrayList<DeviceDefinitionDeviceNameComponent>();
      return this.deviceName;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setDeviceName(List<DeviceDefinitionDeviceNameComponent> theDeviceName) { 
      this.deviceName = theDeviceName;
      return this;
    }

    public boolean hasDeviceName() { 
      if (this.deviceName == null)
        return false;
      for (DeviceDefinitionDeviceNameComponent item : this.deviceName)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionDeviceNameComponent addDeviceName() { //3
      DeviceDefinitionDeviceNameComponent t = new DeviceDefinitionDeviceNameComponent();
      if (this.deviceName == null)
        this.deviceName = new ArrayList<DeviceDefinitionDeviceNameComponent>();
      this.deviceName.add(t);
      return t;
    }

    public DeviceDefinition addDeviceName(DeviceDefinitionDeviceNameComponent t) { //3
      if (t == null)
        return this;
      if (this.deviceName == null)
        this.deviceName = new ArrayList<DeviceDefinitionDeviceNameComponent>();
      this.deviceName.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #deviceName}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionDeviceNameComponent getDeviceNameFirstRep() { 
      if (getDeviceName().isEmpty()) {
        addDeviceName();
      }
      return getDeviceName().get(0);
    }

    /**
     * @return {@link #modelNumber} (The model number for the device for example as defined by the manufacturer or labeler, or other agency.). This is the underlying object with id, value and extensions. The accessor "getModelNumber" gives direct access to the value
     */
    public StringType getModelNumberElement() { 
      if (this.modelNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.modelNumber");
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
     * @param value {@link #modelNumber} (The model number for the device for example as defined by the manufacturer or labeler, or other agency.). This is the underlying object with id, value and extensions. The accessor "getModelNumber" gives direct access to the value
     */
    public DeviceDefinition setModelNumberElement(StringType value) { 
      this.modelNumber = value;
      return this;
    }

    /**
     * @return The model number for the device for example as defined by the manufacturer or labeler, or other agency.
     */
    public String getModelNumber() { 
      return this.modelNumber == null ? null : this.modelNumber.getValue();
    }

    /**
     * @param value The model number for the device for example as defined by the manufacturer or labeler, or other agency.
     */
    public DeviceDefinition setModelNumber(String value) { 
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
     * @return {@link #classification} (What kind of device or device system this is.)
     */
    public List<DeviceDefinitionClassificationComponent> getClassification() { 
      if (this.classification == null)
        this.classification = new ArrayList<DeviceDefinitionClassificationComponent>();
      return this.classification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setClassification(List<DeviceDefinitionClassificationComponent> theClassification) { 
      this.classification = theClassification;
      return this;
    }

    public boolean hasClassification() { 
      if (this.classification == null)
        return false;
      for (DeviceDefinitionClassificationComponent item : this.classification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionClassificationComponent addClassification() { //3
      DeviceDefinitionClassificationComponent t = new DeviceDefinitionClassificationComponent();
      if (this.classification == null)
        this.classification = new ArrayList<DeviceDefinitionClassificationComponent>();
      this.classification.add(t);
      return t;
    }

    public DeviceDefinition addClassification(DeviceDefinitionClassificationComponent t) { //3
      if (t == null)
        return this;
      if (this.classification == null)
        this.classification = new ArrayList<DeviceDefinitionClassificationComponent>();
      this.classification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classification}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionClassificationComponent getClassificationFirstRep() { 
      if (getClassification().isEmpty()) {
        addClassification();
      }
      return getClassification().get(0);
    }

    /**
     * @return {@link #conformsTo} (Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.)
     */
    public List<DeviceDefinitionConformsToComponent> getConformsTo() { 
      if (this.conformsTo == null)
        this.conformsTo = new ArrayList<DeviceDefinitionConformsToComponent>();
      return this.conformsTo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setConformsTo(List<DeviceDefinitionConformsToComponent> theConformsTo) { 
      this.conformsTo = theConformsTo;
      return this;
    }

    public boolean hasConformsTo() { 
      if (this.conformsTo == null)
        return false;
      for (DeviceDefinitionConformsToComponent item : this.conformsTo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionConformsToComponent addConformsTo() { //3
      DeviceDefinitionConformsToComponent t = new DeviceDefinitionConformsToComponent();
      if (this.conformsTo == null)
        this.conformsTo = new ArrayList<DeviceDefinitionConformsToComponent>();
      this.conformsTo.add(t);
      return t;
    }

    public DeviceDefinition addConformsTo(DeviceDefinitionConformsToComponent t) { //3
      if (t == null)
        return this;
      if (this.conformsTo == null)
        this.conformsTo = new ArrayList<DeviceDefinitionConformsToComponent>();
      this.conformsTo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #conformsTo}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionConformsToComponent getConformsToFirstRep() { 
      if (getConformsTo().isEmpty()) {
        addConformsTo();
      }
      return getConformsTo().get(0);
    }

    /**
     * @return {@link #hasPart} (A device that is part (for example a component) of the present device.)
     */
    public List<DeviceDefinitionHasPartComponent> getHasPart() { 
      if (this.hasPart == null)
        this.hasPart = new ArrayList<DeviceDefinitionHasPartComponent>();
      return this.hasPart;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setHasPart(List<DeviceDefinitionHasPartComponent> theHasPart) { 
      this.hasPart = theHasPart;
      return this;
    }

    public boolean hasHasPart() { 
      if (this.hasPart == null)
        return false;
      for (DeviceDefinitionHasPartComponent item : this.hasPart)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionHasPartComponent addHasPart() { //3
      DeviceDefinitionHasPartComponent t = new DeviceDefinitionHasPartComponent();
      if (this.hasPart == null)
        this.hasPart = new ArrayList<DeviceDefinitionHasPartComponent>();
      this.hasPart.add(t);
      return t;
    }

    public DeviceDefinition addHasPart(DeviceDefinitionHasPartComponent t) { //3
      if (t == null)
        return this;
      if (this.hasPart == null)
        this.hasPart = new ArrayList<DeviceDefinitionHasPartComponent>();
      this.hasPart.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #hasPart}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionHasPartComponent getHasPartFirstRep() { 
      if (getHasPart().isEmpty()) {
        addHasPart();
      }
      return getHasPart().get(0);
    }

    /**
     * @return {@link #packaging} (Information about the packaging of the device, i.e. how the device is packaged.)
     */
    public List<DeviceDefinitionPackagingComponent> getPackaging() { 
      if (this.packaging == null)
        this.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
      return this.packaging;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setPackaging(List<DeviceDefinitionPackagingComponent> thePackaging) { 
      this.packaging = thePackaging;
      return this;
    }

    public boolean hasPackaging() { 
      if (this.packaging == null)
        return false;
      for (DeviceDefinitionPackagingComponent item : this.packaging)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionPackagingComponent addPackaging() { //3
      DeviceDefinitionPackagingComponent t = new DeviceDefinitionPackagingComponent();
      if (this.packaging == null)
        this.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
      this.packaging.add(t);
      return t;
    }

    public DeviceDefinition addPackaging(DeviceDefinitionPackagingComponent t) { //3
      if (t == null)
        return this;
      if (this.packaging == null)
        this.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
      this.packaging.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #packaging}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionPackagingComponent getPackagingFirstRep() { 
      if (getPackaging().isEmpty()) {
        addPackaging();
      }
      return getPackaging().get(0);
    }

    /**
     * @return {@link #version} (The version of the device or software.)
     */
    public List<DeviceDefinitionVersionComponent> getVersion() { 
      if (this.version == null)
        this.version = new ArrayList<DeviceDefinitionVersionComponent>();
      return this.version;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setVersion(List<DeviceDefinitionVersionComponent> theVersion) { 
      this.version = theVersion;
      return this;
    }

    public boolean hasVersion() { 
      if (this.version == null)
        return false;
      for (DeviceDefinitionVersionComponent item : this.version)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionVersionComponent addVersion() { //3
      DeviceDefinitionVersionComponent t = new DeviceDefinitionVersionComponent();
      if (this.version == null)
        this.version = new ArrayList<DeviceDefinitionVersionComponent>();
      this.version.add(t);
      return t;
    }

    public DeviceDefinition addVersion(DeviceDefinitionVersionComponent t) { //3
      if (t == null)
        return this;
      if (this.version == null)
        this.version = new ArrayList<DeviceDefinitionVersionComponent>();
      this.version.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #version}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionVersionComponent getVersionFirstRep() { 
      if (getVersion().isEmpty()) {
        addVersion();
      }
      return getVersion().get(0);
    }

    /**
     * @return {@link #safety} (Safety characteristics of the device.)
     */
    public List<CodeableConcept> getSafety() { 
      if (this.safety == null)
        this.safety = new ArrayList<CodeableConcept>();
      return this.safety;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setSafety(List<CodeableConcept> theSafety) { 
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

    public DeviceDefinition addSafety(CodeableConcept t) { //3
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
     * @return {@link #shelfLifeStorage} (Shelf Life and storage information.)
     */
    public List<ProductShelfLife> getShelfLifeStorage() { 
      if (this.shelfLifeStorage == null)
        this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
      return this.shelfLifeStorage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setShelfLifeStorage(List<ProductShelfLife> theShelfLifeStorage) { 
      this.shelfLifeStorage = theShelfLifeStorage;
      return this;
    }

    public boolean hasShelfLifeStorage() { 
      if (this.shelfLifeStorage == null)
        return false;
      for (ProductShelfLife item : this.shelfLifeStorage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ProductShelfLife addShelfLifeStorage() { //3
      ProductShelfLife t = new ProductShelfLife();
      if (this.shelfLifeStorage == null)
        this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
      this.shelfLifeStorage.add(t);
      return t;
    }

    public DeviceDefinition addShelfLifeStorage(ProductShelfLife t) { //3
      if (t == null)
        return this;
      if (this.shelfLifeStorage == null)
        this.shelfLifeStorage = new ArrayList<ProductShelfLife>();
      this.shelfLifeStorage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #shelfLifeStorage}, creating it if it does not already exist {3}
     */
    public ProductShelfLife getShelfLifeStorageFirstRep() { 
      if (getShelfLifeStorage().isEmpty()) {
        addShelfLifeStorage();
      }
      return getShelfLifeStorage().get(0);
    }

    /**
     * @return {@link #languageCode} (Language code for the human-readable text strings produced by the device (all supported).)
     */
    public List<CodeableConcept> getLanguageCode() { 
      if (this.languageCode == null)
        this.languageCode = new ArrayList<CodeableConcept>();
      return this.languageCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setLanguageCode(List<CodeableConcept> theLanguageCode) { 
      this.languageCode = theLanguageCode;
      return this;
    }

    public boolean hasLanguageCode() { 
      if (this.languageCode == null)
        return false;
      for (CodeableConcept item : this.languageCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addLanguageCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.languageCode == null)
        this.languageCode = new ArrayList<CodeableConcept>();
      this.languageCode.add(t);
      return t;
    }

    public DeviceDefinition addLanguageCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.languageCode == null)
        this.languageCode = new ArrayList<CodeableConcept>();
      this.languageCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #languageCode}, creating it if it does not already exist {3}
     */
    public CodeableConcept getLanguageCodeFirstRep() { 
      if (getLanguageCode().isEmpty()) {
        addLanguageCode();
      }
      return getLanguageCode().get(0);
    }

    /**
     * @return {@link #property} (The potential, valid configuration settings of a device, e.g., regulation status, time properties.)
     */
    public List<DeviceDefinitionPropertyComponent> getProperty() { 
      if (this.property == null)
        this.property = new ArrayList<DeviceDefinitionPropertyComponent>();
      return this.property;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setProperty(List<DeviceDefinitionPropertyComponent> theProperty) { 
      this.property = theProperty;
      return this;
    }

    public boolean hasProperty() { 
      if (this.property == null)
        return false;
      for (DeviceDefinitionPropertyComponent item : this.property)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionPropertyComponent addProperty() { //3
      DeviceDefinitionPropertyComponent t = new DeviceDefinitionPropertyComponent();
      if (this.property == null)
        this.property = new ArrayList<DeviceDefinitionPropertyComponent>();
      this.property.add(t);
      return t;
    }

    public DeviceDefinition addProperty(DeviceDefinitionPropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.property == null)
        this.property = new ArrayList<DeviceDefinitionPropertyComponent>();
      this.property.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionPropertyComponent getPropertyFirstRep() { 
      if (getProperty().isEmpty()) {
        addProperty();
      }
      return getProperty().get(0);
    }

    /**
     * @return {@link #owner} (An organization that is responsible for the provision and ongoing maintenance of the device.)
     */
    public Reference getOwner() { 
      if (this.owner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.owner");
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
    public DeviceDefinition setOwner(Reference value) { 
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
    public DeviceDefinition setContact(List<ContactPoint> theContact) { 
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

    public DeviceDefinition addContact(ContactPoint t) { //3
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
     * @return {@link #link} (An associated device, attached to, used with, communicating with or linking a previous or new device model to the focal device.)
     */
    public List<DeviceDefinitionLinkComponent> getLink() { 
      if (this.link == null)
        this.link = new ArrayList<DeviceDefinitionLinkComponent>();
      return this.link;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setLink(List<DeviceDefinitionLinkComponent> theLink) { 
      this.link = theLink;
      return this;
    }

    public boolean hasLink() { 
      if (this.link == null)
        return false;
      for (DeviceDefinitionLinkComponent item : this.link)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionLinkComponent addLink() { //3
      DeviceDefinitionLinkComponent t = new DeviceDefinitionLinkComponent();
      if (this.link == null)
        this.link = new ArrayList<DeviceDefinitionLinkComponent>();
      this.link.add(t);
      return t;
    }

    public DeviceDefinition addLink(DeviceDefinitionLinkComponent t) { //3
      if (t == null)
        return this;
      if (this.link == null)
        this.link = new ArrayList<DeviceDefinitionLinkComponent>();
      this.link.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #link}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionLinkComponent getLinkFirstRep() { 
      if (getLink().isEmpty()) {
        addLink();
      }
      return getLink().get(0);
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
    public DeviceDefinition setNote(List<Annotation> theNote) { 
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

    public DeviceDefinition addNote(Annotation t) { //3
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
     * @return {@link #material} (A substance used to create the material(s) of which the device is made.)
     */
    public List<DeviceDefinitionMaterialComponent> getMaterial() { 
      if (this.material == null)
        this.material = new ArrayList<DeviceDefinitionMaterialComponent>();
      return this.material;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setMaterial(List<DeviceDefinitionMaterialComponent> theMaterial) { 
      this.material = theMaterial;
      return this;
    }

    public boolean hasMaterial() { 
      if (this.material == null)
        return false;
      for (DeviceDefinitionMaterialComponent item : this.material)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionMaterialComponent addMaterial() { //3
      DeviceDefinitionMaterialComponent t = new DeviceDefinitionMaterialComponent();
      if (this.material == null)
        this.material = new ArrayList<DeviceDefinitionMaterialComponent>();
      this.material.add(t);
      return t;
    }

    public DeviceDefinition addMaterial(DeviceDefinitionMaterialComponent t) { //3
      if (t == null)
        return this;
      if (this.material == null)
        this.material = new ArrayList<DeviceDefinitionMaterialComponent>();
      this.material.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #material}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionMaterialComponent getMaterialFirstRep() { 
      if (getMaterial().isEmpty()) {
        addMaterial();
      }
      return getMaterial().get(0);
    }

    /**
     * @return {@link #productionIdentifierInUDI} (Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.)
     */
    public List<Enumeration<DeviceProductionIdentifierInUDI>> getProductionIdentifierInUDI() { 
      if (this.productionIdentifierInUDI == null)
        this.productionIdentifierInUDI = new ArrayList<Enumeration<DeviceProductionIdentifierInUDI>>();
      return this.productionIdentifierInUDI;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setProductionIdentifierInUDI(List<Enumeration<DeviceProductionIdentifierInUDI>> theProductionIdentifierInUDI) { 
      this.productionIdentifierInUDI = theProductionIdentifierInUDI;
      return this;
    }

    public boolean hasProductionIdentifierInUDI() { 
      if (this.productionIdentifierInUDI == null)
        return false;
      for (Enumeration<DeviceProductionIdentifierInUDI> item : this.productionIdentifierInUDI)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #productionIdentifierInUDI} (Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.)
     */
    public Enumeration<DeviceProductionIdentifierInUDI> addProductionIdentifierInUDIElement() {//2 
      Enumeration<DeviceProductionIdentifierInUDI> t = new Enumeration<DeviceProductionIdentifierInUDI>(new DeviceProductionIdentifierInUDIEnumFactory());
      if (this.productionIdentifierInUDI == null)
        this.productionIdentifierInUDI = new ArrayList<Enumeration<DeviceProductionIdentifierInUDI>>();
      this.productionIdentifierInUDI.add(t);
      return t;
    }

    /**
     * @param value {@link #productionIdentifierInUDI} (Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.)
     */
    public DeviceDefinition addProductionIdentifierInUDI(DeviceProductionIdentifierInUDI value) { //1
      Enumeration<DeviceProductionIdentifierInUDI> t = new Enumeration<DeviceProductionIdentifierInUDI>(new DeviceProductionIdentifierInUDIEnumFactory());
      t.setValue(value);
      if (this.productionIdentifierInUDI == null)
        this.productionIdentifierInUDI = new ArrayList<Enumeration<DeviceProductionIdentifierInUDI>>();
      this.productionIdentifierInUDI.add(t);
      return this;
    }

    /**
     * @param value {@link #productionIdentifierInUDI} (Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.)
     */
    public boolean hasProductionIdentifierInUDI(DeviceProductionIdentifierInUDI value) { 
      if (this.productionIdentifierInUDI == null)
        return false;
      for (Enumeration<DeviceProductionIdentifierInUDI> v : this.productionIdentifierInUDI)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #guideline} (Information aimed at providing directions for the usage of this model of device.)
     */
    public DeviceDefinitionGuidelineComponent getGuideline() { 
      if (this.guideline == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.guideline");
        else if (Configuration.doAutoCreate())
          this.guideline = new DeviceDefinitionGuidelineComponent(); // cc
      return this.guideline;
    }

    public boolean hasGuideline() { 
      return this.guideline != null && !this.guideline.isEmpty();
    }

    /**
     * @param value {@link #guideline} (Information aimed at providing directions for the usage of this model of device.)
     */
    public DeviceDefinition setGuideline(DeviceDefinitionGuidelineComponent value) { 
      this.guideline = value;
      return this;
    }

    /**
     * @return {@link #correctiveAction} (Tracking of latest field safety corrective action.)
     */
    public DeviceDefinitionCorrectiveActionComponent getCorrectiveAction() { 
      if (this.correctiveAction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDefinition.correctiveAction");
        else if (Configuration.doAutoCreate())
          this.correctiveAction = new DeviceDefinitionCorrectiveActionComponent(); // cc
      return this.correctiveAction;
    }

    public boolean hasCorrectiveAction() { 
      return this.correctiveAction != null && !this.correctiveAction.isEmpty();
    }

    /**
     * @param value {@link #correctiveAction} (Tracking of latest field safety corrective action.)
     */
    public DeviceDefinition setCorrectiveAction(DeviceDefinitionCorrectiveActionComponent value) { 
      this.correctiveAction = value;
      return this;
    }

    /**
     * @return {@link #chargeItem} (Billing code or reference associated with the device.)
     */
    public List<DeviceDefinitionChargeItemComponent> getChargeItem() { 
      if (this.chargeItem == null)
        this.chargeItem = new ArrayList<DeviceDefinitionChargeItemComponent>();
      return this.chargeItem;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDefinition setChargeItem(List<DeviceDefinitionChargeItemComponent> theChargeItem) { 
      this.chargeItem = theChargeItem;
      return this;
    }

    public boolean hasChargeItem() { 
      if (this.chargeItem == null)
        return false;
      for (DeviceDefinitionChargeItemComponent item : this.chargeItem)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDefinitionChargeItemComponent addChargeItem() { //3
      DeviceDefinitionChargeItemComponent t = new DeviceDefinitionChargeItemComponent();
      if (this.chargeItem == null)
        this.chargeItem = new ArrayList<DeviceDefinitionChargeItemComponent>();
      this.chargeItem.add(t);
      return t;
    }

    public DeviceDefinition addChargeItem(DeviceDefinitionChargeItemComponent t) { //3
      if (t == null)
        return this;
      if (this.chargeItem == null)
        this.chargeItem = new ArrayList<DeviceDefinitionChargeItemComponent>();
      this.chargeItem.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #chargeItem}, creating it if it does not already exist {3}
     */
    public DeviceDefinitionChargeItemComponent getChargeItemFirstRep() { 
      if (getChargeItem().isEmpty()) {
        addChargeItem();
      }
      return getChargeItem().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("description", "markdown", "Additional information to describe the device.", 0, 1, description));
        children.add(new Property("identifier", "Identifier", "Unique instance identifiers assigned to a device by the software, manufacturers, other organizations or owners. For example: handle ID. The identifier is typically valued if the udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type of identifier.  However, it is permissible to still include those identifiers in DeviceDefinition.identifier with the appropriate identifier.type.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("udiDeviceIdentifier", "", "Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.", 0, java.lang.Integer.MAX_VALUE, udiDeviceIdentifier));
        children.add(new Property("regulatoryIdentifier", "", "Identifier associated with the regulatory documentation (certificates, technical documentation, post-market surveillance documentation and reports) of a set of device models sharing the same intended purpose, risk class and essential design and manufacturing characteristics. One example is the Basic UDI-DI in Europe.", 0, java.lang.Integer.MAX_VALUE, regulatoryIdentifier));
        children.add(new Property("partNumber", "string", "The part number or catalog number of the device.", 0, 1, partNumber));
        children.add(new Property("manufacturer", "Reference(Organization)", "A name of the manufacturer  or legal representative e.g. labeler. Whether this is the actual manufacturer or the labeler or responsible depends on implementation and jurisdiction.", 0, 1, manufacturer));
        children.add(new Property("deviceName", "", "The name or names of the device as given by the manufacturer.", 0, java.lang.Integer.MAX_VALUE, deviceName));
        children.add(new Property("modelNumber", "string", "The model number for the device for example as defined by the manufacturer or labeler, or other agency.", 0, 1, modelNumber));
        children.add(new Property("classification", "", "What kind of device or device system this is.", 0, java.lang.Integer.MAX_VALUE, classification));
        children.add(new Property("conformsTo", "", "Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.", 0, java.lang.Integer.MAX_VALUE, conformsTo));
        children.add(new Property("hasPart", "", "A device that is part (for example a component) of the present device.", 0, java.lang.Integer.MAX_VALUE, hasPart));
        children.add(new Property("packaging", "", "Information about the packaging of the device, i.e. how the device is packaged.", 0, java.lang.Integer.MAX_VALUE, packaging));
        children.add(new Property("version", "", "The version of the device or software.", 0, java.lang.Integer.MAX_VALUE, version));
        children.add(new Property("safety", "CodeableConcept", "Safety characteristics of the device.", 0, java.lang.Integer.MAX_VALUE, safety));
        children.add(new Property("shelfLifeStorage", "ProductShelfLife", "Shelf Life and storage information.", 0, java.lang.Integer.MAX_VALUE, shelfLifeStorage));
        children.add(new Property("languageCode", "CodeableConcept", "Language code for the human-readable text strings produced by the device (all supported).", 0, java.lang.Integer.MAX_VALUE, languageCode));
        children.add(new Property("property", "", "The potential, valid configuration settings of a device, e.g., regulation status, time properties.", 0, java.lang.Integer.MAX_VALUE, property));
        children.add(new Property("owner", "Reference(Organization)", "An organization that is responsible for the provision and ongoing maintenance of the device.", 0, 1, owner));
        children.add(new Property("contact", "ContactPoint", "Contact details for an organization or a particular human that is responsible for the device.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("link", "", "An associated device, attached to, used with, communicating with or linking a previous or new device model to the focal device.", 0, java.lang.Integer.MAX_VALUE, link));
        children.add(new Property("note", "Annotation", "Descriptive information, usage information or implantation information that is not captured in an existing element.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("material", "", "A substance used to create the material(s) of which the device is made.", 0, java.lang.Integer.MAX_VALUE, material));
        children.add(new Property("productionIdentifierInUDI", "code", "Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.", 0, java.lang.Integer.MAX_VALUE, productionIdentifierInUDI));
        children.add(new Property("guideline", "", "Information aimed at providing directions for the usage of this model of device.", 0, 1, guideline));
        children.add(new Property("correctiveAction", "", "Tracking of latest field safety corrective action.", 0, 1, correctiveAction));
        children.add(new Property("chargeItem", "", "Billing code or reference associated with the device.", 0, java.lang.Integer.MAX_VALUE, chargeItem));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1724546052: /*description*/  return new Property("description", "markdown", "Additional information to describe the device.", 0, 1, description);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique instance identifiers assigned to a device by the software, manufacturers, other organizations or owners. For example: handle ID. The identifier is typically valued if the udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type of identifier.  However, it is permissible to still include those identifiers in DeviceDefinition.identifier with the appropriate identifier.type.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -99121287: /*udiDeviceIdentifier*/  return new Property("udiDeviceIdentifier", "", "Unique device identifier (UDI) assigned to device label or package.  Note that the Device may include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction it is sold, or for multiple jurisdictions it could have been sold.", 0, java.lang.Integer.MAX_VALUE, udiDeviceIdentifier);
        case 455683425: /*regulatoryIdentifier*/  return new Property("regulatoryIdentifier", "", "Identifier associated with the regulatory documentation (certificates, technical documentation, post-market surveillance documentation and reports) of a set of device models sharing the same intended purpose, risk class and essential design and manufacturing characteristics. One example is the Basic UDI-DI in Europe.", 0, java.lang.Integer.MAX_VALUE, regulatoryIdentifier);
        case -731502308: /*partNumber*/  return new Property("partNumber", "string", "The part number or catalog number of the device.", 0, 1, partNumber);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "A name of the manufacturer  or legal representative e.g. labeler. Whether this is the actual manufacturer or the labeler or responsible depends on implementation and jurisdiction.", 0, 1, manufacturer);
        case 780988929: /*deviceName*/  return new Property("deviceName", "", "The name or names of the device as given by the manufacturer.", 0, java.lang.Integer.MAX_VALUE, deviceName);
        case 346619858: /*modelNumber*/  return new Property("modelNumber", "string", "The model number for the device for example as defined by the manufacturer or labeler, or other agency.", 0, 1, modelNumber);
        case 382350310: /*classification*/  return new Property("classification", "", "What kind of device or device system this is.", 0, java.lang.Integer.MAX_VALUE, classification);
        case 1014198088: /*conformsTo*/  return new Property("conformsTo", "", "Identifies the standards, specifications, or formal guidances for the capabilities supported by the device. The device may be certified as conformant to these specifications e.g., communication, performance, process, measurement, or specialization standards.", 0, java.lang.Integer.MAX_VALUE, conformsTo);
        case 696815021: /*hasPart*/  return new Property("hasPart", "", "A device that is part (for example a component) of the present device.", 0, java.lang.Integer.MAX_VALUE, hasPart);
        case 1802065795: /*packaging*/  return new Property("packaging", "", "Information about the packaging of the device, i.e. how the device is packaged.", 0, java.lang.Integer.MAX_VALUE, packaging);
        case 351608024: /*version*/  return new Property("version", "", "The version of the device or software.", 0, java.lang.Integer.MAX_VALUE, version);
        case -909893934: /*safety*/  return new Property("safety", "CodeableConcept", "Safety characteristics of the device.", 0, java.lang.Integer.MAX_VALUE, safety);
        case 172049237: /*shelfLifeStorage*/  return new Property("shelfLifeStorage", "ProductShelfLife", "Shelf Life and storage information.", 0, java.lang.Integer.MAX_VALUE, shelfLifeStorage);
        case -2092349083: /*languageCode*/  return new Property("languageCode", "CodeableConcept", "Language code for the human-readable text strings produced by the device (all supported).", 0, java.lang.Integer.MAX_VALUE, languageCode);
        case -993141291: /*property*/  return new Property("property", "", "The potential, valid configuration settings of a device, e.g., regulation status, time properties.", 0, java.lang.Integer.MAX_VALUE, property);
        case 106164915: /*owner*/  return new Property("owner", "Reference(Organization)", "An organization that is responsible for the provision and ongoing maintenance of the device.", 0, 1, owner);
        case 951526432: /*contact*/  return new Property("contact", "ContactPoint", "Contact details for an organization or a particular human that is responsible for the device.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 3321850: /*link*/  return new Property("link", "", "An associated device, attached to, used with, communicating with or linking a previous or new device model to the focal device.", 0, java.lang.Integer.MAX_VALUE, link);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Descriptive information, usage information or implantation information that is not captured in an existing element.", 0, java.lang.Integer.MAX_VALUE, note);
        case 299066663: /*material*/  return new Property("material", "", "A substance used to create the material(s) of which the device is made.", 0, java.lang.Integer.MAX_VALUE, material);
        case 312405811: /*productionIdentifierInUDI*/  return new Property("productionIdentifierInUDI", "code", "Indicates the production identifier(s) that are expected to appear in the UDI carrier on the device label.", 0, java.lang.Integer.MAX_VALUE, productionIdentifierInUDI);
        case -2075718416: /*guideline*/  return new Property("guideline", "", "Information aimed at providing directions for the usage of this model of device.", 0, 1, guideline);
        case 1354575876: /*correctiveAction*/  return new Property("correctiveAction", "", "Tracking of latest field safety corrective action.", 0, 1, correctiveAction);
        case 1417779175: /*chargeItem*/  return new Property("chargeItem", "", "Billing code or reference associated with the device.", 0, java.lang.Integer.MAX_VALUE, chargeItem);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -99121287: /*udiDeviceIdentifier*/ return this.udiDeviceIdentifier == null ? new Base[0] : this.udiDeviceIdentifier.toArray(new Base[this.udiDeviceIdentifier.size()]); // DeviceDefinitionUdiDeviceIdentifierComponent
        case 455683425: /*regulatoryIdentifier*/ return this.regulatoryIdentifier == null ? new Base[0] : this.regulatoryIdentifier.toArray(new Base[this.regulatoryIdentifier.size()]); // DeviceDefinitionRegulatoryIdentifierComponent
        case -731502308: /*partNumber*/ return this.partNumber == null ? new Base[0] : new Base[] {this.partNumber}; // StringType
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : new Base[] {this.manufacturer}; // Reference
        case 780988929: /*deviceName*/ return this.deviceName == null ? new Base[0] : this.deviceName.toArray(new Base[this.deviceName.size()]); // DeviceDefinitionDeviceNameComponent
        case 346619858: /*modelNumber*/ return this.modelNumber == null ? new Base[0] : new Base[] {this.modelNumber}; // StringType
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : this.classification.toArray(new Base[this.classification.size()]); // DeviceDefinitionClassificationComponent
        case 1014198088: /*conformsTo*/ return this.conformsTo == null ? new Base[0] : this.conformsTo.toArray(new Base[this.conformsTo.size()]); // DeviceDefinitionConformsToComponent
        case 696815021: /*hasPart*/ return this.hasPart == null ? new Base[0] : this.hasPart.toArray(new Base[this.hasPart.size()]); // DeviceDefinitionHasPartComponent
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : this.packaging.toArray(new Base[this.packaging.size()]); // DeviceDefinitionPackagingComponent
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // DeviceDefinitionVersionComponent
        case -909893934: /*safety*/ return this.safety == null ? new Base[0] : this.safety.toArray(new Base[this.safety.size()]); // CodeableConcept
        case 172049237: /*shelfLifeStorage*/ return this.shelfLifeStorage == null ? new Base[0] : this.shelfLifeStorage.toArray(new Base[this.shelfLifeStorage.size()]); // ProductShelfLife
        case -2092349083: /*languageCode*/ return this.languageCode == null ? new Base[0] : this.languageCode.toArray(new Base[this.languageCode.size()]); // CodeableConcept
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // DeviceDefinitionPropertyComponent
        case 106164915: /*owner*/ return this.owner == null ? new Base[0] : new Base[] {this.owner}; // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactPoint
        case 3321850: /*link*/ return this.link == null ? new Base[0] : this.link.toArray(new Base[this.link.size()]); // DeviceDefinitionLinkComponent
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 299066663: /*material*/ return this.material == null ? new Base[0] : this.material.toArray(new Base[this.material.size()]); // DeviceDefinitionMaterialComponent
        case 312405811: /*productionIdentifierInUDI*/ return this.productionIdentifierInUDI == null ? new Base[0] : this.productionIdentifierInUDI.toArray(new Base[this.productionIdentifierInUDI.size()]); // Enumeration<DeviceProductionIdentifierInUDI>
        case -2075718416: /*guideline*/ return this.guideline == null ? new Base[0] : new Base[] {this.guideline}; // DeviceDefinitionGuidelineComponent
        case 1354575876: /*correctiveAction*/ return this.correctiveAction == null ? new Base[0] : new Base[] {this.correctiveAction}; // DeviceDefinitionCorrectiveActionComponent
        case 1417779175: /*chargeItem*/ return this.chargeItem == null ? new Base[0] : this.chargeItem.toArray(new Base[this.chargeItem.size()]); // DeviceDefinitionChargeItemComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -99121287: // udiDeviceIdentifier
          this.getUdiDeviceIdentifier().add((DeviceDefinitionUdiDeviceIdentifierComponent) value); // DeviceDefinitionUdiDeviceIdentifierComponent
          return value;
        case 455683425: // regulatoryIdentifier
          this.getRegulatoryIdentifier().add((DeviceDefinitionRegulatoryIdentifierComponent) value); // DeviceDefinitionRegulatoryIdentifierComponent
          return value;
        case -731502308: // partNumber
          this.partNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -1969347631: // manufacturer
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 780988929: // deviceName
          this.getDeviceName().add((DeviceDefinitionDeviceNameComponent) value); // DeviceDefinitionDeviceNameComponent
          return value;
        case 346619858: // modelNumber
          this.modelNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case 382350310: // classification
          this.getClassification().add((DeviceDefinitionClassificationComponent) value); // DeviceDefinitionClassificationComponent
          return value;
        case 1014198088: // conformsTo
          this.getConformsTo().add((DeviceDefinitionConformsToComponent) value); // DeviceDefinitionConformsToComponent
          return value;
        case 696815021: // hasPart
          this.getHasPart().add((DeviceDefinitionHasPartComponent) value); // DeviceDefinitionHasPartComponent
          return value;
        case 1802065795: // packaging
          this.getPackaging().add((DeviceDefinitionPackagingComponent) value); // DeviceDefinitionPackagingComponent
          return value;
        case 351608024: // version
          this.getVersion().add((DeviceDefinitionVersionComponent) value); // DeviceDefinitionVersionComponent
          return value;
        case -909893934: // safety
          this.getSafety().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 172049237: // shelfLifeStorage
          this.getShelfLifeStorage().add(TypeConvertor.castToProductShelfLife(value)); // ProductShelfLife
          return value;
        case -2092349083: // languageCode
          this.getLanguageCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -993141291: // property
          this.getProperty().add((DeviceDefinitionPropertyComponent) value); // DeviceDefinitionPropertyComponent
          return value;
        case 106164915: // owner
          this.owner = TypeConvertor.castToReference(value); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case 3321850: // link
          this.getLink().add((DeviceDefinitionLinkComponent) value); // DeviceDefinitionLinkComponent
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 299066663: // material
          this.getMaterial().add((DeviceDefinitionMaterialComponent) value); // DeviceDefinitionMaterialComponent
          return value;
        case 312405811: // productionIdentifierInUDI
          value = new DeviceProductionIdentifierInUDIEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getProductionIdentifierInUDI().add((Enumeration) value); // Enumeration<DeviceProductionIdentifierInUDI>
          return value;
        case -2075718416: // guideline
          this.guideline = (DeviceDefinitionGuidelineComponent) value; // DeviceDefinitionGuidelineComponent
          return value;
        case 1354575876: // correctiveAction
          this.correctiveAction = (DeviceDefinitionCorrectiveActionComponent) value; // DeviceDefinitionCorrectiveActionComponent
          return value;
        case 1417779175: // chargeItem
          this.getChargeItem().add((DeviceDefinitionChargeItemComponent) value); // DeviceDefinitionChargeItemComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("udiDeviceIdentifier")) {
          this.getUdiDeviceIdentifier().add((DeviceDefinitionUdiDeviceIdentifierComponent) value);
        } else if (name.equals("regulatoryIdentifier")) {
          this.getRegulatoryIdentifier().add((DeviceDefinitionRegulatoryIdentifierComponent) value);
        } else if (name.equals("partNumber")) {
          this.partNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("manufacturer")) {
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("deviceName")) {
          this.getDeviceName().add((DeviceDefinitionDeviceNameComponent) value);
        } else if (name.equals("modelNumber")) {
          this.modelNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("classification")) {
          this.getClassification().add((DeviceDefinitionClassificationComponent) value);
        } else if (name.equals("conformsTo")) {
          this.getConformsTo().add((DeviceDefinitionConformsToComponent) value);
        } else if (name.equals("hasPart")) {
          this.getHasPart().add((DeviceDefinitionHasPartComponent) value);
        } else if (name.equals("packaging")) {
          this.getPackaging().add((DeviceDefinitionPackagingComponent) value);
        } else if (name.equals("version")) {
          this.getVersion().add((DeviceDefinitionVersionComponent) value);
        } else if (name.equals("safety")) {
          this.getSafety().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("shelfLifeStorage")) {
          this.getShelfLifeStorage().add(TypeConvertor.castToProductShelfLife(value));
        } else if (name.equals("languageCode")) {
          this.getLanguageCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("property")) {
          this.getProperty().add((DeviceDefinitionPropertyComponent) value);
        } else if (name.equals("owner")) {
          this.owner = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("link")) {
          this.getLink().add((DeviceDefinitionLinkComponent) value);
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("material")) {
          this.getMaterial().add((DeviceDefinitionMaterialComponent) value);
        } else if (name.equals("productionIdentifierInUDI")) {
          value = new DeviceProductionIdentifierInUDIEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getProductionIdentifierInUDI().add((Enumeration) value);
        } else if (name.equals("guideline")) {
          this.guideline = (DeviceDefinitionGuidelineComponent) value; // DeviceDefinitionGuidelineComponent
        } else if (name.equals("correctiveAction")) {
          this.correctiveAction = (DeviceDefinitionCorrectiveActionComponent) value; // DeviceDefinitionCorrectiveActionComponent
        } else if (name.equals("chargeItem")) {
          this.getChargeItem().add((DeviceDefinitionChargeItemComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -1618432855:  return addIdentifier(); 
        case -99121287:  return addUdiDeviceIdentifier(); 
        case 455683425:  return addRegulatoryIdentifier(); 
        case -731502308:  return getPartNumberElement();
        case -1969347631:  return getManufacturer();
        case 780988929:  return addDeviceName(); 
        case 346619858:  return getModelNumberElement();
        case 382350310:  return addClassification(); 
        case 1014198088:  return addConformsTo(); 
        case 696815021:  return addHasPart(); 
        case 1802065795:  return addPackaging(); 
        case 351608024:  return addVersion(); 
        case -909893934:  return addSafety(); 
        case 172049237:  return addShelfLifeStorage(); 
        case -2092349083:  return addLanguageCode(); 
        case -993141291:  return addProperty(); 
        case 106164915:  return getOwner();
        case 951526432:  return addContact(); 
        case 3321850:  return addLink(); 
        case 3387378:  return addNote(); 
        case 299066663:  return addMaterial(); 
        case 312405811:  return addProductionIdentifierInUDIElement();
        case -2075718416:  return getGuideline();
        case 1354575876:  return getCorrectiveAction();
        case 1417779175:  return addChargeItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -99121287: /*udiDeviceIdentifier*/ return new String[] {};
        case 455683425: /*regulatoryIdentifier*/ return new String[] {};
        case -731502308: /*partNumber*/ return new String[] {"string"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case 780988929: /*deviceName*/ return new String[] {};
        case 346619858: /*modelNumber*/ return new String[] {"string"};
        case 382350310: /*classification*/ return new String[] {};
        case 1014198088: /*conformsTo*/ return new String[] {};
        case 696815021: /*hasPart*/ return new String[] {};
        case 1802065795: /*packaging*/ return new String[] {};
        case 351608024: /*version*/ return new String[] {};
        case -909893934: /*safety*/ return new String[] {"CodeableConcept"};
        case 172049237: /*shelfLifeStorage*/ return new String[] {"ProductShelfLife"};
        case -2092349083: /*languageCode*/ return new String[] {"CodeableConcept"};
        case -993141291: /*property*/ return new String[] {};
        case 106164915: /*owner*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ContactPoint"};
        case 3321850: /*link*/ return new String[] {};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 299066663: /*material*/ return new String[] {};
        case 312405811: /*productionIdentifierInUDI*/ return new String[] {"code"};
        case -2075718416: /*guideline*/ return new String[] {};
        case 1354575876: /*correctiveAction*/ return new String[] {};
        case 1417779175: /*chargeItem*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.description");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("udiDeviceIdentifier")) {
          return addUdiDeviceIdentifier();
        }
        else if (name.equals("regulatoryIdentifier")) {
          return addRegulatoryIdentifier();
        }
        else if (name.equals("partNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.partNumber");
        }
        else if (name.equals("manufacturer")) {
          this.manufacturer = new Reference();
          return this.manufacturer;
        }
        else if (name.equals("deviceName")) {
          return addDeviceName();
        }
        else if (name.equals("modelNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.modelNumber");
        }
        else if (name.equals("classification")) {
          return addClassification();
        }
        else if (name.equals("conformsTo")) {
          return addConformsTo();
        }
        else if (name.equals("hasPart")) {
          return addHasPart();
        }
        else if (name.equals("packaging")) {
          return addPackaging();
        }
        else if (name.equals("version")) {
          return addVersion();
        }
        else if (name.equals("safety")) {
          return addSafety();
        }
        else if (name.equals("shelfLifeStorage")) {
          return addShelfLifeStorage();
        }
        else if (name.equals("languageCode")) {
          return addLanguageCode();
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("owner")) {
          this.owner = new Reference();
          return this.owner;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("link")) {
          return addLink();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("material")) {
          return addMaterial();
        }
        else if (name.equals("productionIdentifierInUDI")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceDefinition.productionIdentifierInUDI");
        }
        else if (name.equals("guideline")) {
          this.guideline = new DeviceDefinitionGuidelineComponent();
          return this.guideline;
        }
        else if (name.equals("correctiveAction")) {
          this.correctiveAction = new DeviceDefinitionCorrectiveActionComponent();
          return this.correctiveAction;
        }
        else if (name.equals("chargeItem")) {
          return addChargeItem();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DeviceDefinition";

  }

      public DeviceDefinition copy() {
        DeviceDefinition dst = new DeviceDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDefinition dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (udiDeviceIdentifier != null) {
          dst.udiDeviceIdentifier = new ArrayList<DeviceDefinitionUdiDeviceIdentifierComponent>();
          for (DeviceDefinitionUdiDeviceIdentifierComponent i : udiDeviceIdentifier)
            dst.udiDeviceIdentifier.add(i.copy());
        };
        if (regulatoryIdentifier != null) {
          dst.regulatoryIdentifier = new ArrayList<DeviceDefinitionRegulatoryIdentifierComponent>();
          for (DeviceDefinitionRegulatoryIdentifierComponent i : regulatoryIdentifier)
            dst.regulatoryIdentifier.add(i.copy());
        };
        dst.partNumber = partNumber == null ? null : partNumber.copy();
        dst.manufacturer = manufacturer == null ? null : manufacturer.copy();
        if (deviceName != null) {
          dst.deviceName = new ArrayList<DeviceDefinitionDeviceNameComponent>();
          for (DeviceDefinitionDeviceNameComponent i : deviceName)
            dst.deviceName.add(i.copy());
        };
        dst.modelNumber = modelNumber == null ? null : modelNumber.copy();
        if (classification != null) {
          dst.classification = new ArrayList<DeviceDefinitionClassificationComponent>();
          for (DeviceDefinitionClassificationComponent i : classification)
            dst.classification.add(i.copy());
        };
        if (conformsTo != null) {
          dst.conformsTo = new ArrayList<DeviceDefinitionConformsToComponent>();
          for (DeviceDefinitionConformsToComponent i : conformsTo)
            dst.conformsTo.add(i.copy());
        };
        if (hasPart != null) {
          dst.hasPart = new ArrayList<DeviceDefinitionHasPartComponent>();
          for (DeviceDefinitionHasPartComponent i : hasPart)
            dst.hasPart.add(i.copy());
        };
        if (packaging != null) {
          dst.packaging = new ArrayList<DeviceDefinitionPackagingComponent>();
          for (DeviceDefinitionPackagingComponent i : packaging)
            dst.packaging.add(i.copy());
        };
        if (version != null) {
          dst.version = new ArrayList<DeviceDefinitionVersionComponent>();
          for (DeviceDefinitionVersionComponent i : version)
            dst.version.add(i.copy());
        };
        if (safety != null) {
          dst.safety = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : safety)
            dst.safety.add(i.copy());
        };
        if (shelfLifeStorage != null) {
          dst.shelfLifeStorage = new ArrayList<ProductShelfLife>();
          for (ProductShelfLife i : shelfLifeStorage)
            dst.shelfLifeStorage.add(i.copy());
        };
        if (languageCode != null) {
          dst.languageCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : languageCode)
            dst.languageCode.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<DeviceDefinitionPropertyComponent>();
          for (DeviceDefinitionPropertyComponent i : property)
            dst.property.add(i.copy());
        };
        dst.owner = owner == null ? null : owner.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactPoint>();
          for (ContactPoint i : contact)
            dst.contact.add(i.copy());
        };
        if (link != null) {
          dst.link = new ArrayList<DeviceDefinitionLinkComponent>();
          for (DeviceDefinitionLinkComponent i : link)
            dst.link.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (material != null) {
          dst.material = new ArrayList<DeviceDefinitionMaterialComponent>();
          for (DeviceDefinitionMaterialComponent i : material)
            dst.material.add(i.copy());
        };
        if (productionIdentifierInUDI != null) {
          dst.productionIdentifierInUDI = new ArrayList<Enumeration<DeviceProductionIdentifierInUDI>>();
          for (Enumeration<DeviceProductionIdentifierInUDI> i : productionIdentifierInUDI)
            dst.productionIdentifierInUDI.add(i.copy());
        };
        dst.guideline = guideline == null ? null : guideline.copy();
        dst.correctiveAction = correctiveAction == null ? null : correctiveAction.copy();
        if (chargeItem != null) {
          dst.chargeItem = new ArrayList<DeviceDefinitionChargeItemComponent>();
          for (DeviceDefinitionChargeItemComponent i : chargeItem)
            dst.chargeItem.add(i.copy());
        };
      }

      protected DeviceDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDefinition))
          return false;
        DeviceDefinition o = (DeviceDefinition) other_;
        return compareDeep(description, o.description, true) && compareDeep(identifier, o.identifier, true)
           && compareDeep(udiDeviceIdentifier, o.udiDeviceIdentifier, true) && compareDeep(regulatoryIdentifier, o.regulatoryIdentifier, true)
           && compareDeep(partNumber, o.partNumber, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(deviceName, o.deviceName, true) && compareDeep(modelNumber, o.modelNumber, true)
           && compareDeep(classification, o.classification, true) && compareDeep(conformsTo, o.conformsTo, true)
           && compareDeep(hasPart, o.hasPart, true) && compareDeep(packaging, o.packaging, true) && compareDeep(version, o.version, true)
           && compareDeep(safety, o.safety, true) && compareDeep(shelfLifeStorage, o.shelfLifeStorage, true)
           && compareDeep(languageCode, o.languageCode, true) && compareDeep(property, o.property, true) && compareDeep(owner, o.owner, true)
           && compareDeep(contact, o.contact, true) && compareDeep(link, o.link, true) && compareDeep(note, o.note, true)
           && compareDeep(material, o.material, true) && compareDeep(productionIdentifierInUDI, o.productionIdentifierInUDI, true)
           && compareDeep(guideline, o.guideline, true) && compareDeep(correctiveAction, o.correctiveAction, true)
           && compareDeep(chargeItem, o.chargeItem, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDefinition))
          return false;
        DeviceDefinition o = (DeviceDefinition) other_;
        return compareValues(description, o.description, true) && compareValues(partNumber, o.partNumber, true)
           && compareValues(modelNumber, o.modelNumber, true) && compareValues(productionIdentifierInUDI, o.productionIdentifierInUDI, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, identifier, udiDeviceIdentifier
          , regulatoryIdentifier, partNumber, manufacturer, deviceName, modelNumber, classification
          , conformsTo, hasPart, packaging, version, safety, shelfLifeStorage, languageCode
          , property, owner, contact, link, note, material, productionIdentifierInUDI, guideline
          , correctiveAction, chargeItem);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DeviceDefinition;
   }

 /**
   * Search parameter: <b>device-name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in DeviceDefinition.name or DeviceDefinition.classification.type - the latter to search for 'generic' devices.</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DeviceDefinition.deviceName.name | DeviceDefinition.classification.type.coding.display | DeviceDefinition.classification.type.text</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device-name", path="DeviceDefinition.deviceName.name | DeviceDefinition.classification.type.coding.display | DeviceDefinition.classification.type.text", description="A server defined search that may match any of the string fields in DeviceDefinition.name or DeviceDefinition.classification.type - the latter to search for 'generic' devices.", type="string" )
  public static final String SP_DEVICE_NAME = "device-name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device-name</b>
   * <p>
   * Description: <b>A server defined search that may match any of the string fields in DeviceDefinition.name or DeviceDefinition.classification.type - the latter to search for 'generic' devices.</b><br>
   * Type: <b>string</b><br>
   * Path: <b>DeviceDefinition.deviceName.name | DeviceDefinition.classification.type.coding.display | DeviceDefinition.classification.type.text</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DEVICE_NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DEVICE_NAME);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the component</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="DeviceDefinition.identifier", description="The identifier of the component", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the component</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>manufacturer</b>
   * <p>
   * Description: <b>The manufacturer of the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDefinition.manufacturer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacturer", path="DeviceDefinition.manufacturer", description="The manufacturer of the device", type="reference", target={Organization.class } )
  public static final String SP_MANUFACTURER = "manufacturer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacturer</b>
   * <p>
   * Description: <b>The manufacturer of the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDefinition.manufacturer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANUFACTURER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANUFACTURER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceDefinition:manufacturer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANUFACTURER = new ca.uhn.fhir.model.api.Include("DeviceDefinition:manufacturer").toLocked();

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The organization responsible for the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDefinition.owner</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="DeviceDefinition.owner", description="The organization responsible for the device", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The organization responsible for the device</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDefinition.owner</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceDefinition:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("DeviceDefinition:organization").toLocked();

 /**
   * Search parameter: <b>specification</b>
   * <p>
   * Description: <b>The specification that the device conforms to</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDefinition.conformsTo.specification</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specification", path="DeviceDefinition.conformsTo.specification", description="The specification that the device conforms to", type="token" )
  public static final String SP_SPECIFICATION = "specification";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specification</b>
   * <p>
   * Description: <b>The specification that the device conforms to</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDefinition.conformsTo.specification</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIFICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIFICATION);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The device type</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDefinition.conformsTo.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="DeviceDefinition.conformsTo.category", description="The device type", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The device type</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDefinition.conformsTo.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

