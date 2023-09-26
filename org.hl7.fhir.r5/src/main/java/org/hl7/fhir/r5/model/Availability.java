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
 * Availability Type: Availability data for an {item}.
 */
@DatatypeDef(name="Availability")
public class Availability extends DataType implements ICompositeType {

    @Block()
    public static class AvailabilityAvailableTimeComponent extends Element implements IBaseDatatypeElement {
        /**
         * mon | tue | wed | thu | fri | sat | sun.
         */
        @Child(name = "daysOfWeek", type = {CodeType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="mon | tue | wed | thu | fri | sat | sun", formalDefinition="mon | tue | wed | thu | fri | sat | sun." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/days-of-week")
        protected List<Enumeration<DaysOfWeek>> daysOfWeek;

        /**
         * Always available? i.e. 24 hour service.
         */
        @Child(name = "allDay", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Always available? i.e. 24 hour service", formalDefinition="Always available? i.e. 24 hour service." )
        protected BooleanType allDay;

        /**
         * Opening time of day (ignored if allDay = true).
         */
        @Child(name = "availableStartTime", type = {TimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Opening time of day (ignored if allDay = true)", formalDefinition="Opening time of day (ignored if allDay = true)." )
        protected TimeType availableStartTime;

        /**
         * Closing time of day (ignored if allDay = true).
         */
        @Child(name = "availableEndTime", type = {TimeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Closing time of day (ignored if allDay = true)", formalDefinition="Closing time of day (ignored if allDay = true)." )
        protected TimeType availableEndTime;

        private static final long serialVersionUID = -2139510127L;

    /**
     * Constructor
     */
      public AvailabilityAvailableTimeComponent() {
        super();
      }

        /**
         * @return {@link #daysOfWeek} (mon | tue | wed | thu | fri | sat | sun.)
         */
        public List<Enumeration<DaysOfWeek>> getDaysOfWeek() { 
          if (this.daysOfWeek == null)
            this.daysOfWeek = new ArrayList<Enumeration<DaysOfWeek>>();
          return this.daysOfWeek;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AvailabilityAvailableTimeComponent setDaysOfWeek(List<Enumeration<DaysOfWeek>> theDaysOfWeek) { 
          this.daysOfWeek = theDaysOfWeek;
          return this;
        }

        public boolean hasDaysOfWeek() { 
          if (this.daysOfWeek == null)
            return false;
          for (Enumeration<DaysOfWeek> item : this.daysOfWeek)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #daysOfWeek} (mon | tue | wed | thu | fri | sat | sun.)
         */
        public Enumeration<DaysOfWeek> addDaysOfWeekElement() {//2 
          Enumeration<DaysOfWeek> t = new Enumeration<DaysOfWeek>(new DaysOfWeekEnumFactory());
          if (this.daysOfWeek == null)
            this.daysOfWeek = new ArrayList<Enumeration<DaysOfWeek>>();
          this.daysOfWeek.add(t);
          return t;
        }

        /**
         * @param value {@link #daysOfWeek} (mon | tue | wed | thu | fri | sat | sun.)
         */
        public AvailabilityAvailableTimeComponent addDaysOfWeek(DaysOfWeek value) { //1
          Enumeration<DaysOfWeek> t = new Enumeration<DaysOfWeek>(new DaysOfWeekEnumFactory());
          t.setValue(value);
          if (this.daysOfWeek == null)
            this.daysOfWeek = new ArrayList<Enumeration<DaysOfWeek>>();
          this.daysOfWeek.add(t);
          return this;
        }

        /**
         * @param value {@link #daysOfWeek} (mon | tue | wed | thu | fri | sat | sun.)
         */
        public boolean hasDaysOfWeek(DaysOfWeek value) { 
          if (this.daysOfWeek == null)
            return false;
          for (Enumeration<DaysOfWeek> v : this.daysOfWeek)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #allDay} (Always available? i.e. 24 hour service.). This is the underlying object with id, value and extensions. The accessor "getAllDay" gives direct access to the value
         */
        public BooleanType getAllDayElement() { 
          if (this.allDay == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AvailabilityAvailableTimeComponent.allDay");
            else if (Configuration.doAutoCreate())
              this.allDay = new BooleanType(); // bb
          return this.allDay;
        }

        public boolean hasAllDayElement() { 
          return this.allDay != null && !this.allDay.isEmpty();
        }

        public boolean hasAllDay() { 
          return this.allDay != null && !this.allDay.isEmpty();
        }

        /**
         * @param value {@link #allDay} (Always available? i.e. 24 hour service.). This is the underlying object with id, value and extensions. The accessor "getAllDay" gives direct access to the value
         */
        public AvailabilityAvailableTimeComponent setAllDayElement(BooleanType value) { 
          this.allDay = value;
          return this;
        }

        /**
         * @return Always available? i.e. 24 hour service.
         */
        public boolean getAllDay() { 
          return this.allDay == null || this.allDay.isEmpty() ? false : this.allDay.getValue();
        }

        /**
         * @param value Always available? i.e. 24 hour service.
         */
        public AvailabilityAvailableTimeComponent setAllDay(boolean value) { 
            if (this.allDay == null)
              this.allDay = new BooleanType();
            this.allDay.setValue(value);
          return this;
        }

        /**
         * @return {@link #availableStartTime} (Opening time of day (ignored if allDay = true).). This is the underlying object with id, value and extensions. The accessor "getAvailableStartTime" gives direct access to the value
         */
        public TimeType getAvailableStartTimeElement() { 
          if (this.availableStartTime == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AvailabilityAvailableTimeComponent.availableStartTime");
            else if (Configuration.doAutoCreate())
              this.availableStartTime = new TimeType(); // bb
          return this.availableStartTime;
        }

        public boolean hasAvailableStartTimeElement() { 
          return this.availableStartTime != null && !this.availableStartTime.isEmpty();
        }

        public boolean hasAvailableStartTime() { 
          return this.availableStartTime != null && !this.availableStartTime.isEmpty();
        }

        /**
         * @param value {@link #availableStartTime} (Opening time of day (ignored if allDay = true).). This is the underlying object with id, value and extensions. The accessor "getAvailableStartTime" gives direct access to the value
         */
        public AvailabilityAvailableTimeComponent setAvailableStartTimeElement(TimeType value) { 
          this.availableStartTime = value;
          return this;
        }

        /**
         * @return Opening time of day (ignored if allDay = true).
         */
        public String getAvailableStartTime() { 
          return this.availableStartTime == null ? null : this.availableStartTime.getValue();
        }

        /**
         * @param value Opening time of day (ignored if allDay = true).
         */
        public AvailabilityAvailableTimeComponent setAvailableStartTime(String value) { 
          if (value == null)
            this.availableStartTime = null;
          else {
            if (this.availableStartTime == null)
              this.availableStartTime = new TimeType();
            this.availableStartTime.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #availableEndTime} (Closing time of day (ignored if allDay = true).). This is the underlying object with id, value and extensions. The accessor "getAvailableEndTime" gives direct access to the value
         */
        public TimeType getAvailableEndTimeElement() { 
          if (this.availableEndTime == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AvailabilityAvailableTimeComponent.availableEndTime");
            else if (Configuration.doAutoCreate())
              this.availableEndTime = new TimeType(); // bb
          return this.availableEndTime;
        }

        public boolean hasAvailableEndTimeElement() { 
          return this.availableEndTime != null && !this.availableEndTime.isEmpty();
        }

        public boolean hasAvailableEndTime() { 
          return this.availableEndTime != null && !this.availableEndTime.isEmpty();
        }

        /**
         * @param value {@link #availableEndTime} (Closing time of day (ignored if allDay = true).). This is the underlying object with id, value and extensions. The accessor "getAvailableEndTime" gives direct access to the value
         */
        public AvailabilityAvailableTimeComponent setAvailableEndTimeElement(TimeType value) { 
          this.availableEndTime = value;
          return this;
        }

        /**
         * @return Closing time of day (ignored if allDay = true).
         */
        public String getAvailableEndTime() { 
          return this.availableEndTime == null ? null : this.availableEndTime.getValue();
        }

        /**
         * @param value Closing time of day (ignored if allDay = true).
         */
        public AvailabilityAvailableTimeComponent setAvailableEndTime(String value) { 
          if (value == null)
            this.availableEndTime = null;
          else {
            if (this.availableEndTime == null)
              this.availableEndTime = new TimeType();
            this.availableEndTime.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("daysOfWeek", "code", "mon | tue | wed | thu | fri | sat | sun.", 0, java.lang.Integer.MAX_VALUE, daysOfWeek));
          children.add(new Property("allDay", "boolean", "Always available? i.e. 24 hour service.", 0, 1, allDay));
          children.add(new Property("availableStartTime", "time", "Opening time of day (ignored if allDay = true).", 0, 1, availableStartTime));
          children.add(new Property("availableEndTime", "time", "Closing time of day (ignored if allDay = true).", 0, 1, availableEndTime));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 68050338: /*daysOfWeek*/  return new Property("daysOfWeek", "code", "mon | tue | wed | thu | fri | sat | sun.", 0, java.lang.Integer.MAX_VALUE, daysOfWeek);
          case -1414913477: /*allDay*/  return new Property("allDay", "boolean", "Always available? i.e. 24 hour service.", 0, 1, allDay);
          case -1039453818: /*availableStartTime*/  return new Property("availableStartTime", "time", "Opening time of day (ignored if allDay = true).", 0, 1, availableStartTime);
          case 101151551: /*availableEndTime*/  return new Property("availableEndTime", "time", "Closing time of day (ignored if allDay = true).", 0, 1, availableEndTime);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 68050338: /*daysOfWeek*/ return this.daysOfWeek == null ? new Base[0] : this.daysOfWeek.toArray(new Base[this.daysOfWeek.size()]); // Enumeration<DaysOfWeek>
        case -1414913477: /*allDay*/ return this.allDay == null ? new Base[0] : new Base[] {this.allDay}; // BooleanType
        case -1039453818: /*availableStartTime*/ return this.availableStartTime == null ? new Base[0] : new Base[] {this.availableStartTime}; // TimeType
        case 101151551: /*availableEndTime*/ return this.availableEndTime == null ? new Base[0] : new Base[] {this.availableEndTime}; // TimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 68050338: // daysOfWeek
          value = new DaysOfWeekEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getDaysOfWeek().add((Enumeration) value); // Enumeration<DaysOfWeek>
          return value;
        case -1414913477: // allDay
          this.allDay = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1039453818: // availableStartTime
          this.availableStartTime = TypeConvertor.castToTime(value); // TimeType
          return value;
        case 101151551: // availableEndTime
          this.availableEndTime = TypeConvertor.castToTime(value); // TimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("daysOfWeek")) {
          value = new DaysOfWeekEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getDaysOfWeek().add((Enumeration) value);
        } else if (name.equals("allDay")) {
          this.allDay = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("availableStartTime")) {
          this.availableStartTime = TypeConvertor.castToTime(value); // TimeType
        } else if (name.equals("availableEndTime")) {
          this.availableEndTime = TypeConvertor.castToTime(value); // TimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("daysOfWeek")) {
          value = new DaysOfWeekEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getDaysOfWeek().add((Enumeration) value);
        } else if (name.equals("allDay")) {
          this.allDay = null;
        } else if (name.equals("availableStartTime")) {
          this.availableStartTime = null;
        } else if (name.equals("availableEndTime")) {
          this.availableEndTime = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 68050338:  return addDaysOfWeekElement();
        case -1414913477:  return getAllDayElement();
        case -1039453818:  return getAvailableStartTimeElement();
        case 101151551:  return getAvailableEndTimeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 68050338: /*daysOfWeek*/ return new String[] {"code"};
        case -1414913477: /*allDay*/ return new String[] {"boolean"};
        case -1039453818: /*availableStartTime*/ return new String[] {"time"};
        case 101151551: /*availableEndTime*/ return new String[] {"time"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("daysOfWeek")) {
          throw new FHIRException("Cannot call addChild on a singleton property Availability.availableTime.daysOfWeek");
        }
        else if (name.equals("allDay")) {
          throw new FHIRException("Cannot call addChild on a singleton property Availability.availableTime.allDay");
        }
        else if (name.equals("availableStartTime")) {
          throw new FHIRException("Cannot call addChild on a singleton property Availability.availableTime.availableStartTime");
        }
        else if (name.equals("availableEndTime")) {
          throw new FHIRException("Cannot call addChild on a singleton property Availability.availableTime.availableEndTime");
        }
        else
          return super.addChild(name);
      }

      public AvailabilityAvailableTimeComponent copy() {
        AvailabilityAvailableTimeComponent dst = new AvailabilityAvailableTimeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AvailabilityAvailableTimeComponent dst) {
        super.copyValues(dst);
        if (daysOfWeek != null) {
          dst.daysOfWeek = new ArrayList<Enumeration<DaysOfWeek>>();
          for (Enumeration<DaysOfWeek> i : daysOfWeek)
            dst.daysOfWeek.add(i.copy());
        };
        dst.allDay = allDay == null ? null : allDay.copy();
        dst.availableStartTime = availableStartTime == null ? null : availableStartTime.copy();
        dst.availableEndTime = availableEndTime == null ? null : availableEndTime.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AvailabilityAvailableTimeComponent))
          return false;
        AvailabilityAvailableTimeComponent o = (AvailabilityAvailableTimeComponent) other_;
        return compareDeep(daysOfWeek, o.daysOfWeek, true) && compareDeep(allDay, o.allDay, true) && compareDeep(availableStartTime, o.availableStartTime, true)
           && compareDeep(availableEndTime, o.availableEndTime, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AvailabilityAvailableTimeComponent))
          return false;
        AvailabilityAvailableTimeComponent o = (AvailabilityAvailableTimeComponent) other_;
        return compareValues(daysOfWeek, o.daysOfWeek, true) && compareValues(allDay, o.allDay, true) && compareValues(availableStartTime, o.availableStartTime, true)
           && compareValues(availableEndTime, o.availableEndTime, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(daysOfWeek, allDay, availableStartTime
          , availableEndTime);
      }

  public String fhirType() {
    return "Availability.availableTime";

  }

  }

    @Block()
    public static class AvailabilityNotAvailableTimeComponent extends Element implements IBaseDatatypeElement {
        /**
         * Reason presented to the user explaining why time not available.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reason presented to the user explaining why time not available", formalDefinition="Reason presented to the user explaining why time not available." )
        protected StringType description;

        /**
         * Service not available during this period.
         */
        @Child(name = "during", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Service not available during this period", formalDefinition="Service not available during this period." )
        protected Period during;

        private static final long serialVersionUID = 310849929L;

    /**
     * Constructor
     */
      public AvailabilityNotAvailableTimeComponent() {
        super();
      }

        /**
         * @return {@link #description} (Reason presented to the user explaining why time not available.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AvailabilityNotAvailableTimeComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (Reason presented to the user explaining why time not available.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public AvailabilityNotAvailableTimeComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Reason presented to the user explaining why time not available.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Reason presented to the user explaining why time not available.
         */
        public AvailabilityNotAvailableTimeComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #during} (Service not available during this period.)
         */
        public Period getDuring() { 
          if (this.during == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AvailabilityNotAvailableTimeComponent.during");
            else if (Configuration.doAutoCreate())
              this.during = new Period(); // cc
          return this.during;
        }

        public boolean hasDuring() { 
          return this.during != null && !this.during.isEmpty();
        }

        /**
         * @param value {@link #during} (Service not available during this period.)
         */
        public AvailabilityNotAvailableTimeComponent setDuring(Period value) { 
          this.during = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Reason presented to the user explaining why time not available.", 0, 1, description));
          children.add(new Property("during", "Period", "Service not available during this period.", 0, 1, during));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Reason presented to the user explaining why time not available.", 0, 1, description);
          case -1320499647: /*during*/  return new Property("during", "Period", "Service not available during this period.", 0, 1, during);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1320499647: /*during*/ return this.during == null ? new Base[0] : new Base[] {this.during}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1320499647: // during
          this.during = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("during")) {
          this.during = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("during")) {
          this.during = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -1320499647:  return getDuring();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1320499647: /*during*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Availability.notAvailableTime.description");
        }
        else if (name.equals("during")) {
          this.during = new Period();
          return this.during;
        }
        else
          return super.addChild(name);
      }

      public AvailabilityNotAvailableTimeComponent copy() {
        AvailabilityNotAvailableTimeComponent dst = new AvailabilityNotAvailableTimeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AvailabilityNotAvailableTimeComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.during = during == null ? null : during.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AvailabilityNotAvailableTimeComponent))
          return false;
        AvailabilityNotAvailableTimeComponent o = (AvailabilityNotAvailableTimeComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(during, o.during, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AvailabilityNotAvailableTimeComponent))
          return false;
        AvailabilityNotAvailableTimeComponent o = (AvailabilityNotAvailableTimeComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, during);
      }

  public String fhirType() {
    return "Availability.notAvailableTime";

  }

  }

    /**
     * Times the {item} is available.
     */
    @Child(name = "availableTime", type = {}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Times the {item} is available", formalDefinition="Times the {item} is available." )
    protected List<AvailabilityAvailableTimeComponent> availableTime;

    /**
     * Not available during this time due to provided reason.
     */
    @Child(name = "notAvailableTime", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Not available during this time due to provided reason", formalDefinition="Not available during this time due to provided reason." )
    protected List<AvailabilityNotAvailableTimeComponent> notAvailableTime;

    private static final long serialVersionUID = -444820754L;

  /**
   * Constructor
   */
    public Availability() {
      super();
    }

    /**
     * @return {@link #availableTime} (Times the {item} is available.)
     */
    public List<AvailabilityAvailableTimeComponent> getAvailableTime() { 
      if (this.availableTime == null)
        this.availableTime = new ArrayList<AvailabilityAvailableTimeComponent>();
      return this.availableTime;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Availability setAvailableTime(List<AvailabilityAvailableTimeComponent> theAvailableTime) { 
      this.availableTime = theAvailableTime;
      return this;
    }

    public boolean hasAvailableTime() { 
      if (this.availableTime == null)
        return false;
      for (AvailabilityAvailableTimeComponent item : this.availableTime)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AvailabilityAvailableTimeComponent addAvailableTime() { //3
      AvailabilityAvailableTimeComponent t = new AvailabilityAvailableTimeComponent();
      if (this.availableTime == null)
        this.availableTime = new ArrayList<AvailabilityAvailableTimeComponent>();
      this.availableTime.add(t);
      return t;
    }

    public Availability addAvailableTime(AvailabilityAvailableTimeComponent t) { //3
      if (t == null)
        return this;
      if (this.availableTime == null)
        this.availableTime = new ArrayList<AvailabilityAvailableTimeComponent>();
      this.availableTime.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #availableTime}, creating it if it does not already exist {3}
     */
    public AvailabilityAvailableTimeComponent getAvailableTimeFirstRep() { 
      if (getAvailableTime().isEmpty()) {
        addAvailableTime();
      }
      return getAvailableTime().get(0);
    }

    /**
     * @return {@link #notAvailableTime} (Not available during this time due to provided reason.)
     */
    public List<AvailabilityNotAvailableTimeComponent> getNotAvailableTime() { 
      if (this.notAvailableTime == null)
        this.notAvailableTime = new ArrayList<AvailabilityNotAvailableTimeComponent>();
      return this.notAvailableTime;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Availability setNotAvailableTime(List<AvailabilityNotAvailableTimeComponent> theNotAvailableTime) { 
      this.notAvailableTime = theNotAvailableTime;
      return this;
    }

    public boolean hasNotAvailableTime() { 
      if (this.notAvailableTime == null)
        return false;
      for (AvailabilityNotAvailableTimeComponent item : this.notAvailableTime)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AvailabilityNotAvailableTimeComponent addNotAvailableTime() { //3
      AvailabilityNotAvailableTimeComponent t = new AvailabilityNotAvailableTimeComponent();
      if (this.notAvailableTime == null)
        this.notAvailableTime = new ArrayList<AvailabilityNotAvailableTimeComponent>();
      this.notAvailableTime.add(t);
      return t;
    }

    public Availability addNotAvailableTime(AvailabilityNotAvailableTimeComponent t) { //3
      if (t == null)
        return this;
      if (this.notAvailableTime == null)
        this.notAvailableTime = new ArrayList<AvailabilityNotAvailableTimeComponent>();
      this.notAvailableTime.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #notAvailableTime}, creating it if it does not already exist {3}
     */
    public AvailabilityNotAvailableTimeComponent getNotAvailableTimeFirstRep() { 
      if (getNotAvailableTime().isEmpty()) {
        addNotAvailableTime();
      }
      return getNotAvailableTime().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("availableTime", "", "Times the {item} is available.", 0, java.lang.Integer.MAX_VALUE, availableTime));
        children.add(new Property("notAvailableTime", "", "Not available during this time due to provided reason.", 0, java.lang.Integer.MAX_VALUE, notAvailableTime));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1873069366: /*availableTime*/  return new Property("availableTime", "", "Times the {item} is available.", 0, java.lang.Integer.MAX_VALUE, availableTime);
        case -627853021: /*notAvailableTime*/  return new Property("notAvailableTime", "", "Not available during this time due to provided reason.", 0, java.lang.Integer.MAX_VALUE, notAvailableTime);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1873069366: /*availableTime*/ return this.availableTime == null ? new Base[0] : this.availableTime.toArray(new Base[this.availableTime.size()]); // AvailabilityAvailableTimeComponent
        case -627853021: /*notAvailableTime*/ return this.notAvailableTime == null ? new Base[0] : this.notAvailableTime.toArray(new Base[this.notAvailableTime.size()]); // AvailabilityNotAvailableTimeComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1873069366: // availableTime
          this.getAvailableTime().add((AvailabilityAvailableTimeComponent) value); // AvailabilityAvailableTimeComponent
          return value;
        case -627853021: // notAvailableTime
          this.getNotAvailableTime().add((AvailabilityNotAvailableTimeComponent) value); // AvailabilityNotAvailableTimeComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("availableTime")) {
          this.getAvailableTime().add((AvailabilityAvailableTimeComponent) value);
        } else if (name.equals("notAvailableTime")) {
          this.getNotAvailableTime().add((AvailabilityNotAvailableTimeComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("availableTime")) {
          this.getAvailableTime().add((AvailabilityAvailableTimeComponent) value);
        } else if (name.equals("notAvailableTime")) {
          this.getNotAvailableTime().add((AvailabilityNotAvailableTimeComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1873069366:  return addAvailableTime(); 
        case -627853021:  return addNotAvailableTime(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1873069366: /*availableTime*/ return new String[] {};
        case -627853021: /*notAvailableTime*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("availableTime")) {
          return addAvailableTime();
        }
        else if (name.equals("notAvailableTime")) {
          return addNotAvailableTime();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Availability";

  }

      public Availability copy() {
        Availability dst = new Availability();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Availability dst) {
        super.copyValues(dst);
        if (availableTime != null) {
          dst.availableTime = new ArrayList<AvailabilityAvailableTimeComponent>();
          for (AvailabilityAvailableTimeComponent i : availableTime)
            dst.availableTime.add(i.copy());
        };
        if (notAvailableTime != null) {
          dst.notAvailableTime = new ArrayList<AvailabilityNotAvailableTimeComponent>();
          for (AvailabilityNotAvailableTimeComponent i : notAvailableTime)
            dst.notAvailableTime.add(i.copy());
        };
      }

      protected Availability typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Availability))
          return false;
        Availability o = (Availability) other_;
        return compareDeep(availableTime, o.availableTime, true) && compareDeep(notAvailableTime, o.notAvailableTime, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Availability))
          return false;
        Availability o = (Availability) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(availableTime, notAvailableTime
          );
      }


}

