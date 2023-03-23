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
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * VirtualServiceDetail Type: Virtual Service Contact Details.
 */
@DatatypeDef(name="VirtualServiceDetail")
public class VirtualServiceDetail extends DataType implements ICompositeType {

    /**
     * The type of virtual service to connect to (i.e. Teams, Zoom, Specific VMR technology, WhatsApp).
     */
    @Child(name = "channelType", type = {Coding.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Channel Type", formalDefinition="The type of virtual service to connect to (i.e. Teams, Zoom, Specific VMR technology, WhatsApp)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/virtual-service-type")
    protected Coding channelType;

    /**
     * What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).
     */
    @Child(name = "address", type = {UrlType.class, StringType.class, ContactPoint.class, ExtendedContactDetail.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Contact address/number", formalDefinition="What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type)." )
    protected DataType address;

    /**
     * Address to see alternative connection details.
     */
    @Child(name = "additionalInfo", type = {UrlType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Address to see alternative connection details", formalDefinition="Address to see alternative connection details." )
    protected List<UrlType> additionalInfo;

    /**
     * Maximum number of participants supported by the virtual service.
     */
    @Child(name = "maxParticipants", type = {PositiveIntType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Maximum number of participants supported by the virtual service", formalDefinition="Maximum number of participants supported by the virtual service." )
    protected PositiveIntType maxParticipants;

    /**
     * Session Key required by the virtual service.
     */
    @Child(name = "sessionKey", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Session Key required by the virtual service", formalDefinition="Session Key required by the virtual service." )
    protected StringType sessionKey;

    private static final long serialVersionUID = -514931977L;

  /**
   * Constructor
   */
    public VirtualServiceDetail() {
      super();
    }

    /**
     * @return {@link #channelType} (The type of virtual service to connect to (i.e. Teams, Zoom, Specific VMR technology, WhatsApp).)
     */
    public Coding getChannelType() { 
      if (this.channelType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VirtualServiceDetail.channelType");
        else if (Configuration.doAutoCreate())
          this.channelType = new Coding(); // cc
      return this.channelType;
    }

    public boolean hasChannelType() { 
      return this.channelType != null && !this.channelType.isEmpty();
    }

    /**
     * @param value {@link #channelType} (The type of virtual service to connect to (i.e. Teams, Zoom, Specific VMR technology, WhatsApp).)
     */
    public VirtualServiceDetail setChannelType(Coding value) { 
      this.channelType = value;
      return this;
    }

    /**
     * @return {@link #address} (What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).)
     */
    public DataType getAddress() { 
      return this.address;
    }

    /**
     * @return {@link #address} (What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).)
     */
    public UrlType getAddressUrlType() throws FHIRException { 
      if (this.address == null)
        this.address = new UrlType();
      if (!(this.address instanceof UrlType))
        throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.address.getClass().getName()+" was encountered");
      return (UrlType) this.address;
    }

    public boolean hasAddressUrlType() { 
      return this != null && this.address instanceof UrlType;
    }

    /**
     * @return {@link #address} (What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).)
     */
    public StringType getAddressStringType() throws FHIRException { 
      if (this.address == null)
        this.address = new StringType();
      if (!(this.address instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.address.getClass().getName()+" was encountered");
      return (StringType) this.address;
    }

    public boolean hasAddressStringType() { 
      return this != null && this.address instanceof StringType;
    }

    /**
     * @return {@link #address} (What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).)
     */
    public ContactPoint getAddressContactPoint() throws FHIRException { 
      if (this.address == null)
        this.address = new ContactPoint();
      if (!(this.address instanceof ContactPoint))
        throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.address.getClass().getName()+" was encountered");
      return (ContactPoint) this.address;
    }

    public boolean hasAddressContactPoint() { 
      return this != null && this.address instanceof ContactPoint;
    }

    /**
     * @return {@link #address} (What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).)
     */
    public ExtendedContactDetail getAddressExtendedContactDetail() throws FHIRException { 
      if (this.address == null)
        this.address = new ExtendedContactDetail();
      if (!(this.address instanceof ExtendedContactDetail))
        throw new FHIRException("Type mismatch: the type ExtendedContactDetail was expected, but "+this.address.getClass().getName()+" was encountered");
      return (ExtendedContactDetail) this.address;
    }

    public boolean hasAddressExtendedContactDetail() { 
      return this != null && this.address instanceof ExtendedContactDetail;
    }

    public boolean hasAddress() { 
      return this.address != null && !this.address.isEmpty();
    }

    /**
     * @param value {@link #address} (What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).)
     */
    public VirtualServiceDetail setAddress(DataType value) { 
      if (value != null && !(value instanceof UrlType || value instanceof StringType || value instanceof ContactPoint || value instanceof ExtendedContactDetail))
        throw new FHIRException("Not the right type for VirtualServiceDetail.address[x]: "+value.fhirType());
      this.address = value;
      return this;
    }

    /**
     * @return {@link #additionalInfo} (Address to see alternative connection details.)
     */
    public List<UrlType> getAdditionalInfo() { 
      if (this.additionalInfo == null)
        this.additionalInfo = new ArrayList<UrlType>();
      return this.additionalInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public VirtualServiceDetail setAdditionalInfo(List<UrlType> theAdditionalInfo) { 
      this.additionalInfo = theAdditionalInfo;
      return this;
    }

    public boolean hasAdditionalInfo() { 
      if (this.additionalInfo == null)
        return false;
      for (UrlType item : this.additionalInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #additionalInfo} (Address to see alternative connection details.)
     */
    public UrlType addAdditionalInfoElement() {//2 
      UrlType t = new UrlType();
      if (this.additionalInfo == null)
        this.additionalInfo = new ArrayList<UrlType>();
      this.additionalInfo.add(t);
      return t;
    }

    /**
     * @param value {@link #additionalInfo} (Address to see alternative connection details.)
     */
    public VirtualServiceDetail addAdditionalInfo(String value) { //1
      UrlType t = new UrlType();
      t.setValue(value);
      if (this.additionalInfo == null)
        this.additionalInfo = new ArrayList<UrlType>();
      this.additionalInfo.add(t);
      return this;
    }

    /**
     * @param value {@link #additionalInfo} (Address to see alternative connection details.)
     */
    public boolean hasAdditionalInfo(String value) { 
      if (this.additionalInfo == null)
        return false;
      for (UrlType v : this.additionalInfo)
        if (v.getValue().equals(value)) // url
          return true;
      return false;
    }

    /**
     * @return {@link #maxParticipants} (Maximum number of participants supported by the virtual service.). This is the underlying object with id, value and extensions. The accessor "getMaxParticipants" gives direct access to the value
     */
    public PositiveIntType getMaxParticipantsElement() { 
      if (this.maxParticipants == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VirtualServiceDetail.maxParticipants");
        else if (Configuration.doAutoCreate())
          this.maxParticipants = new PositiveIntType(); // bb
      return this.maxParticipants;
    }

    public boolean hasMaxParticipantsElement() { 
      return this.maxParticipants != null && !this.maxParticipants.isEmpty();
    }

    public boolean hasMaxParticipants() { 
      return this.maxParticipants != null && !this.maxParticipants.isEmpty();
    }

    /**
     * @param value {@link #maxParticipants} (Maximum number of participants supported by the virtual service.). This is the underlying object with id, value and extensions. The accessor "getMaxParticipants" gives direct access to the value
     */
    public VirtualServiceDetail setMaxParticipantsElement(PositiveIntType value) { 
      this.maxParticipants = value;
      return this;
    }

    /**
     * @return Maximum number of participants supported by the virtual service.
     */
    public int getMaxParticipants() { 
      return this.maxParticipants == null || this.maxParticipants.isEmpty() ? 0 : this.maxParticipants.getValue();
    }

    /**
     * @param value Maximum number of participants supported by the virtual service.
     */
    public VirtualServiceDetail setMaxParticipants(int value) { 
        if (this.maxParticipants == null)
          this.maxParticipants = new PositiveIntType();
        this.maxParticipants.setValue(value);
      return this;
    }

    /**
     * @return {@link #sessionKey} (Session Key required by the virtual service.). This is the underlying object with id, value and extensions. The accessor "getSessionKey" gives direct access to the value
     */
    public StringType getSessionKeyElement() { 
      if (this.sessionKey == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VirtualServiceDetail.sessionKey");
        else if (Configuration.doAutoCreate())
          this.sessionKey = new StringType(); // bb
      return this.sessionKey;
    }

    public boolean hasSessionKeyElement() { 
      return this.sessionKey != null && !this.sessionKey.isEmpty();
    }

    public boolean hasSessionKey() { 
      return this.sessionKey != null && !this.sessionKey.isEmpty();
    }

    /**
     * @param value {@link #sessionKey} (Session Key required by the virtual service.). This is the underlying object with id, value and extensions. The accessor "getSessionKey" gives direct access to the value
     */
    public VirtualServiceDetail setSessionKeyElement(StringType value) { 
      this.sessionKey = value;
      return this;
    }

    /**
     * @return Session Key required by the virtual service.
     */
    public String getSessionKey() { 
      return this.sessionKey == null ? null : this.sessionKey.getValue();
    }

    /**
     * @param value Session Key required by the virtual service.
     */
    public VirtualServiceDetail setSessionKey(String value) { 
      if (Utilities.noString(value))
        this.sessionKey = null;
      else {
        if (this.sessionKey == null)
          this.sessionKey = new StringType();
        this.sessionKey.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("channelType", "Coding", "The type of virtual service to connect to (i.e. Teams, Zoom, Specific VMR technology, WhatsApp).", 0, 1, channelType));
        children.add(new Property("address[x]", "url|string|ContactPoint|ExtendedContactDetail", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address));
        children.add(new Property("additionalInfo", "url", "Address to see alternative connection details.", 0, java.lang.Integer.MAX_VALUE, additionalInfo));
        children.add(new Property("maxParticipants", "positiveInt", "Maximum number of participants supported by the virtual service.", 0, 1, maxParticipants));
        children.add(new Property("sessionKey", "string", "Session Key required by the virtual service.", 0, 1, sessionKey));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 274155229: /*channelType*/  return new Property("channelType", "Coding", "The type of virtual service to connect to (i.e. Teams, Zoom, Specific VMR technology, WhatsApp).", 0, 1, channelType);
        case 1341051916: /*address[x]*/  return new Property("address[x]", "url|string|ContactPoint|ExtendedContactDetail", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address);
        case -1147692044: /*address*/  return new Property("address[x]", "url|string|ContactPoint|ExtendedContactDetail", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address);
        case 1341045979: /*addressUrl*/  return new Property("address[x]", "url", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address);
        case -740155099: /*addressString*/  return new Property("address[x]", "string", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address);
        case 269121380: /*addressContactPoint*/  return new Property("address[x]", "ContactPoint", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address);
        case -834417596: /*addressExtendedContactDetail*/  return new Property("address[x]", "ExtendedContactDetail", "What address or number needs to be used for a user to connect to the virtual service to join. The channelType informs as to which datatype is appropriate to use (requires knowledge of the specific type).", 0, 1, address);
        case -974297739: /*additionalInfo*/  return new Property("additionalInfo", "url", "Address to see alternative connection details.", 0, java.lang.Integer.MAX_VALUE, additionalInfo);
        case 950795044: /*maxParticipants*/  return new Property("maxParticipants", "positiveInt", "Maximum number of participants supported by the virtual service.", 0, 1, maxParticipants);
        case 1661834217: /*sessionKey*/  return new Property("sessionKey", "string", "Session Key required by the virtual service.", 0, 1, sessionKey);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 274155229: /*channelType*/ return this.channelType == null ? new Base[0] : new Base[] {this.channelType}; // Coding
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : new Base[] {this.address}; // DataType
        case -974297739: /*additionalInfo*/ return this.additionalInfo == null ? new Base[0] : this.additionalInfo.toArray(new Base[this.additionalInfo.size()]); // UrlType
        case 950795044: /*maxParticipants*/ return this.maxParticipants == null ? new Base[0] : new Base[] {this.maxParticipants}; // PositiveIntType
        case 1661834217: /*sessionKey*/ return this.sessionKey == null ? new Base[0] : new Base[] {this.sessionKey}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 274155229: // channelType
          this.channelType = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -1147692044: // address
          this.address = TypeConvertor.castToType(value); // DataType
          return value;
        case -974297739: // additionalInfo
          this.getAdditionalInfo().add(TypeConvertor.castToUrl(value)); // UrlType
          return value;
        case 950795044: // maxParticipants
          this.maxParticipants = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 1661834217: // sessionKey
          this.sessionKey = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("channelType")) {
          this.channelType = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("address[x]")) {
          this.address = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("additionalInfo")) {
          this.getAdditionalInfo().add(TypeConvertor.castToUrl(value));
        } else if (name.equals("maxParticipants")) {
          this.maxParticipants = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("sessionKey")) {
          this.sessionKey = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 274155229:  return getChannelType();
        case 1341051916:  return getAddress();
        case -1147692044:  return getAddress();
        case -974297739:  return addAdditionalInfoElement();
        case 950795044:  return getMaxParticipantsElement();
        case 1661834217:  return getSessionKeyElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 274155229: /*channelType*/ return new String[] {"Coding"};
        case -1147692044: /*address*/ return new String[] {"url", "string", "ContactPoint", "ExtendedContactDetail"};
        case -974297739: /*additionalInfo*/ return new String[] {"url"};
        case 950795044: /*maxParticipants*/ return new String[] {"positiveInt"};
        case 1661834217: /*sessionKey*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("channelType")) {
          this.channelType = new Coding();
          return this.channelType;
        }
        else if (name.equals("addressUrl")) {
          this.address = new UrlType();
          return this.address;
        }
        else if (name.equals("addressString")) {
          this.address = new StringType();
          return this.address;
        }
        else if (name.equals("addressContactPoint")) {
          this.address = new ContactPoint();
          return this.address;
        }
        else if (name.equals("addressExtendedContactDetail")) {
          this.address = new ExtendedContactDetail();
          return this.address;
        }
        else if (name.equals("additionalInfo")) {
          throw new FHIRException("Cannot call addChild on a primitive type VirtualServiceDetail.additionalInfo");
        }
        else if (name.equals("maxParticipants")) {
          throw new FHIRException("Cannot call addChild on a primitive type VirtualServiceDetail.maxParticipants");
        }
        else if (name.equals("sessionKey")) {
          throw new FHIRException("Cannot call addChild on a primitive type VirtualServiceDetail.sessionKey");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "VirtualServiceDetail";

  }

      public VirtualServiceDetail copy() {
        VirtualServiceDetail dst = new VirtualServiceDetail();
        copyValues(dst);
        return dst;
      }

      public void copyValues(VirtualServiceDetail dst) {
        super.copyValues(dst);
        dst.channelType = channelType == null ? null : channelType.copy();
        dst.address = address == null ? null : address.copy();
        if (additionalInfo != null) {
          dst.additionalInfo = new ArrayList<UrlType>();
          for (UrlType i : additionalInfo)
            dst.additionalInfo.add(i.copy());
        };
        dst.maxParticipants = maxParticipants == null ? null : maxParticipants.copy();
        dst.sessionKey = sessionKey == null ? null : sessionKey.copy();
      }

      protected VirtualServiceDetail typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof VirtualServiceDetail))
          return false;
        VirtualServiceDetail o = (VirtualServiceDetail) other_;
        return compareDeep(channelType, o.channelType, true) && compareDeep(address, o.address, true) && compareDeep(additionalInfo, o.additionalInfo, true)
           && compareDeep(maxParticipants, o.maxParticipants, true) && compareDeep(sessionKey, o.sessionKey, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof VirtualServiceDetail))
          return false;
        VirtualServiceDetail o = (VirtualServiceDetail) other_;
        return compareValues(additionalInfo, o.additionalInfo, true) && compareValues(maxParticipants, o.maxParticipants, true)
           && compareValues(sessionKey, o.sessionKey, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(channelType, address, additionalInfo
          , maxParticipants, sessionKey);
      }


}

