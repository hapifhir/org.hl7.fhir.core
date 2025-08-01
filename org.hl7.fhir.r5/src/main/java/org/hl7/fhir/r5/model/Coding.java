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
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

import org.hl7.fhir.instance.model.api.IBaseCoding;
/**
 * Coding Type: A reference to a code defined by a terminology system.
 */
@DatatypeDef(name="Coding")
public class Coding extends DataType implements IBaseCoding, ICompositeType, ICoding {

    /**
     * The identification of the code system that defines the meaning of the symbol in the code.
     */
    @Child(name = "system", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identity of the terminology system", formalDefinition="The identification of the code system that defines the meaning of the symbol in the code." )
    protected UriType system;

    /**
     * The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Version of the system - if relevant", formalDefinition="The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged." )
    protected StringType version;

    /**
     * A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).
     */
    @Child(name = "code", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Symbol in syntax defined by the system", formalDefinition="A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination)." )
    protected CodeType code;

    /**
     * A representation of the meaning of the code in the system, following the rules of the system.
     */
    @Child(name = "display", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Representation defined by the system", formalDefinition="A representation of the meaning of the code in the system, following the rules of the system." )
    protected StringType display;

    /**
     * Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).
     */
    @Child(name = "userSelected", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this coding was chosen directly by the user", formalDefinition="Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays)." )
    protected BooleanType userSelected;

    private static final long serialVersionUID = -1417514061L;

  /**
   * Constructor
   */
    public Coding() {
      super();
    }

    /**
     * Convenience constructor
     * 
     * @param theSystem The {@link #setSystem(String) code system}
     * @param theCode The {@link #setCode(String) code}
     * @param theDisplay The {@link #setDisplay(String) human readable display}
     */
      public Coding(String theSystem, String theCode, String theDisplay) {
        setSystem(theSystem);
        setCode(theCode);
        setDisplay(theDisplay);
      }
    /**
     * @return {@link #system} (The identification of the code system that defines the meaning of the symbol in the code.). This is the underlying object with id, value and extensions. The accessor "getSystem" gives direct access to the value
     */
    public UriType getSystemElement() { 
      if (this.system == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Coding.system");
        else if (Configuration.doAutoCreate())
          this.system = new UriType(); // bb
      return this.system;
    }

    public boolean hasSystemElement() { 
      return this.system != null && !this.system.isEmpty();
    }

    public boolean hasSystem() { 
      return this.system != null && !this.system.isEmpty();
    }

    /**
     * @param value {@link #system} (The identification of the code system that defines the meaning of the symbol in the code.). This is the underlying object with id, value and extensions. The accessor "getSystem" gives direct access to the value
     */
    public Coding setSystemElement(UriType value) { 
      this.system = value;
      return this;
    }

    /**
     * @return The identification of the code system that defines the meaning of the symbol in the code.
     */
    public String getSystem() { 
      return this.system == null ? null : this.system.getValue();
    }

    /**
     * @param value The identification of the code system that defines the meaning of the symbol in the code.
     */
    public Coding setSystem(String value) { 
      if (Utilities.noString(value))
        this.system = null;
      else {
        if (this.system == null)
          this.system = new UriType();
        this.system.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #version} (The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Coding.version");
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
     * @param value {@link #version} (The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Coding setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.
     */
    public Coding setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #code} (A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
     */
    public CodeType getCodeElement() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Coding.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeType(); // bb
      return this.code;
    }

    public boolean hasCodeElement() { 
      return this.code != null && !this.code.isEmpty();
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
     */
    public Coding setCodeElement(CodeType value) { 
      this.code = value;
      return this;
    }

    /**
     * @return A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).
     */
    public String getCode() { 
      return this.code == null ? null : this.code.getValue();
    }

    /**
     * @param value A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).
     */
    public Coding setCode(String value) { 
      if (Utilities.noString(value))
        this.code = null;
      else {
        if (this.code == null)
          this.code = new CodeType();
        this.code.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #display} (A representation of the meaning of the code in the system, following the rules of the system.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
     */
    public StringType getDisplayElement() { 
      if (this.display == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Coding.display");
        else if (Configuration.doAutoCreate())
          this.display = new StringType(); // bb
      return this.display;
    }

    public boolean hasDisplayElement() { 
      return this.display != null && !this.display.isEmpty();
    }

    public boolean hasDisplay() { 
      return this.display != null && !this.display.isEmpty();
    }

    /**
     * @param value {@link #display} (A representation of the meaning of the code in the system, following the rules of the system.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
     */
    public Coding setDisplayElement(StringType value) { 
      this.display = value;
      return this;
    }

    /**
     * @return A representation of the meaning of the code in the system, following the rules of the system.
     */
    public String getDisplay() { 
      return this.display == null ? null : this.display.getValue();
    }

    /**
     * @param value A representation of the meaning of the code in the system, following the rules of the system.
     */
    public Coding setDisplay(String value) { 
      if (Utilities.noString(value))
        this.display = null;
      else {
        if (this.display == null)
          this.display = new StringType();
        this.display.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #userSelected} (Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).). This is the underlying object with id, value and extensions. The accessor "getUserSelected" gives direct access to the value
     */
    public BooleanType getUserSelectedElement() { 
      if (this.userSelected == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Coding.userSelected");
        else if (Configuration.doAutoCreate())
          this.userSelected = new BooleanType(); // bb
      return this.userSelected;
    }

    public boolean hasUserSelectedElement() { 
      return this.userSelected != null && !this.userSelected.isEmpty();
    }

    public boolean hasUserSelected() { 
      return this.userSelected != null && !this.userSelected.isEmpty();
    }

    /**
     * @param value {@link #userSelected} (Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).). This is the underlying object with id, value and extensions. The accessor "getUserSelected" gives direct access to the value
     */
    public Coding setUserSelectedElement(BooleanType value) { 
      this.userSelected = value;
      return this;
    }

    /**
     * @return Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).
     */
    public boolean getUserSelected() { 
      return this.userSelected == null || this.userSelected.isEmpty() ? false : this.userSelected.getValue();
    }

    /**
     * @param value Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).
     */
    public Coding setUserSelected(boolean value) { 
        if (this.userSelected == null)
          this.userSelected = new BooleanType();
        this.userSelected.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("system", "uri", "The identification of the code system that defines the meaning of the symbol in the code.", 0, 1, system));
        children.add(new Property("version", "string", "The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.", 0, 1, version));
        children.add(new Property("code", "code", "A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).", 0, 1, code));
        children.add(new Property("display", "string", "A representation of the meaning of the code in the system, following the rules of the system.", 0, 1, display));
        children.add(new Property("userSelected", "boolean", "Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).", 0, 1, userSelected));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -887328209: /*system*/  return new Property("system", "uri", "The identification of the code system that defines the meaning of the symbol in the code.", 0, 1, system);
        case 351608024: /*version*/  return new Property("version", "string", "The version of the code system which was used when choosing this code. Note that a well-maintained code system does not need the version reported, because the meaning of codes is consistent across versions. However this cannot consistently be assured, and when the meaning is not guaranteed to be consistent, the version SHOULD be exchanged.", 0, 1, version);
        case 3059181: /*code*/  return new Property("code", "code", "A symbol in syntax defined by the system. The symbol may be a predefined code or an expression in a syntax defined by the coding system (e.g. post-coordination).", 0, 1, code);
        case 1671764162: /*display*/  return new Property("display", "string", "A representation of the meaning of the code in the system, following the rules of the system.", 0, 1, display);
        case 423643014: /*userSelected*/  return new Property("userSelected", "boolean", "Indicates that this coding was chosen by a user directly - e.g. off a pick list of available items (codes or displays).", 0, 1, userSelected);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -887328209: /*system*/ return this.system == null ? new Base[0] : new Base[] {this.system}; // UriType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case 423643014: /*userSelected*/ return this.userSelected == null ? new Base[0] : new Base[] {this.userSelected}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -887328209: // system
          this.system = TypeConvertor.castToUri(value); // UriType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 1671764162: // display
          this.display = TypeConvertor.castToString(value); // StringType
          return value;
        case 423643014: // userSelected
          this.userSelected = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("system")) {
          this.system = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("display")) {
          this.display = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("userSelected")) {
          this.userSelected = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("system")) {
          this.system = null;
        } else if (name.equals("version")) {
          this.version = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("display")) {
          this.display = null;
        } else if (name.equals("userSelected")) {
          this.userSelected = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -887328209:  return getSystemElement();
        case 351608024:  return getVersionElement();
        case 3059181:  return getCodeElement();
        case 1671764162:  return getDisplayElement();
        case 423643014:  return getUserSelectedElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -887328209: /*system*/ return new String[] {"uri"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"code"};
        case 1671764162: /*display*/ return new String[] {"string"};
        case 423643014: /*userSelected*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("system")) {
          throw new FHIRException("Cannot call addChild on a singleton property Coding.system");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property Coding.version");
        }
        else if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a singleton property Coding.code");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a singleton property Coding.display");
        }
        else if (name.equals("userSelected")) {
          throw new FHIRException("Cannot call addChild on a singleton property Coding.userSelected");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Coding";

  }

      public Coding copy() {
        Coding dst = new Coding();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Coding dst) {
        super.copyValues(dst);
        dst.system = system == null ? null : system.copy();
        dst.version = version == null ? null : version.copy();
        dst.code = code == null ? null : code.copy();
        dst.display = display == null ? null : display.copy();
        dst.userSelected = userSelected == null ? null : userSelected.copy();
      }

      protected Coding typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Coding))
          return false;
        Coding o = (Coding) other_;
        return compareDeep(system, o.system, true) && compareDeep(version, o.version, true) && compareDeep(code, o.code, true)
           && compareDeep(display, o.display, true) && compareDeep(userSelected, o.userSelected, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Coding))
          return false;
        Coding o = (Coding) other_;
        return compareValues(system, o.system, true) && compareValues(version, o.version, true) && compareValues(code, o.code, true)
           && compareValues(display, o.display, true) && compareValues(userSelected, o.userSelected, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(system, version, code, display
          , userSelected);
      }

// Manual code (from Configuration.txt):
@Override
      public boolean supportsVersion() {
        return true;
      }

      @Override
      public boolean supportsDisplay() {
        return true;
      }


      public boolean is(String system, String code) {
        return hasSystem() && hasCode() &&  this.getSystem().equals(system) && this.getCode().equals(code);
      }

  public String toString() {
    String base = hasSystem() ? getSystem() : "";
    if (hasVersion())
      base = base+"|"+getVersion();
    base = base + "#"+getCode();
    if (hasDisplay())
      base = base+": '"+getDisplay()+"'";
    return base;
  }

  public String toToken() {
    String base = hasSystem() ? getSystem() : "";
    if (hasVersion())
      base = base+"|"+getVersion();
    base = base + "#"+getCode();
    return base;
  }

  public static Coding fromLiteral(String value) {
        String sv = value.contains("#") ? value.substring(0, value.indexOf("#")) : value; 
        String cp = value.contains("#") ? value.substring(value.indexOf("#")+1) : null;
        
        String system = sv.contains("|") ? sv.substring(0, sv.indexOf("|")) : sv;
        String version = sv.contains("|") ? sv.substring(sv.indexOf("|")+1) : null;
        
        String code = cp != null && cp.contains("'") ? cp.substring(0, cp.indexOf("'")) : cp;
        String display = cp != null && cp.contains("'") ? cp.substring(cp.indexOf("'")+1) : null;
        if (display != null) {
          display = display.trim();
          display = display.substring(0, display.length() -1);
        }
        if ((system == null || !Utilities.isAbsoluteUrl(system)) && code == null) {
          return null;
        } else {
          return new Coding(system, version, code, display);
        }
      }

      public boolean matches(Coding other) {
        return other.hasCode() && this.hasCode() && other.hasSystem() && this.hasSystem() && this.getCode().equals(other.getCode()) && this.getSystem().equals(other.getSystem()) ;
      }
      

      public static Coding merge(Coding l, Coding r) {
        Coding res = new Coding();
        if (l.hasSystem()) {
          res.setSystem(l.getSystem());
        } else {
          res.setSystem(r.getSystem());
        }
        if (l.hasVersion()) {
          res.setVersion(l.getVersion());
        } else {
          res.setVersion(r.getVersion());
        }
        if (l.hasCode()) {
          res.setCode(l.getCode());
        } else {
          res.setCode(r.getCode());
        }
        if (l.hasDisplay()) {
          res.setDisplay(l.getDisplay());
        } else {
          res.setDisplay(r.getDisplay());
        }
        if (l.hasUserSelected()) {
          res.setUserSelected(l.getUserSelected());
        } else {
          res.setUserSelected(r.getUserSelected());
        }
        return res;
      }

      public static Coding intersect(Coding l, Coding r) {
        Coding res = new Coding();
        if (l.hasSystem() && l.getSystem().equals(r.getSystem())) {
          res.setSystem(l.getSystem());
        }
        if (l.hasVersion() && l.getVersion().equals(r.getVersion())) {
          res.setVersion(l.getVersion());
        }
        if (l.hasCode() && l.getCode().equals(r.getCode())) {
          res.setCode(l.getCode());
        }
        if (l.hasDisplay() && l.getDisplay().equals(r.getDisplay())) {
          res.setDisplay(l.getDisplay());
        }
        if (l.hasUserSelected() && l.getUserSelected() == r.getUserSelected()) {
          res.setUserSelected(l.getUserSelected());
        }
        return res;
      } 
            
      public Coding(String theSystem, String theVersion, String theCode, String theDisplay) {
        setSystem(theSystem);
        setVersion(theVersion);
        setCode(theCode);
        setDisplay(theDisplay);
      }      
// end addition

      public Coding(ValueSetExpansionContainsComponent cc) {
        super();
        setSystem(cc.getSystem());
        setVersion(cc.getVersion());
        setCode(cc.getCode());
        setDisplay(cc.getDisplay());
      }

      public String getVersionedSystem() {
        return hasVersion() ? getSystem()+"|"+getVersion() : getSystem();
      }

}

