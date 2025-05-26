package org.hl7.fhir.r5.openehr;


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
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Root object of a linear history, i.e. time series structure. This is a generic class whose type parameter must be a descendant of ITEM_STRUCTURE, ensuring that each Event in the events of a given instance is of the same structural type, i.e. ITEM_TREE, ITEM_LIST etc. For a periodic series of events, period will be set, and the time of each Event in the History must correspond; i.e. the EVENT.offset must be a multiple of period for each Event. Missing events in a period History are however allowed.
 */
@DatatypeDef(name="HISTORY")
public class HISTORY extends DATA_STRUCTURE implements ICompositeType {

    /**
     * Time origin of this event history. The first event is not necessarily at the origin point.
     */
    @Child(name = "origin", type = {DV_DATE_TIME.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time origin of this event history", formalDefinition="Time origin of this event history. The first event is not necessarily at the origin point." )
    protected DV_DATE_TIME origin;

    /**
     * Period between samples in this segment if periodic.
     */
    @Child(name = "period", type = {DV_DURATION.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Period between samples in this segment if periodic", formalDefinition="Period between samples in this segment if periodic." )
    protected DV_DURATION period;

    /**
     * Duration of the entire History; either corresponds to the duration of all the events, and/or the duration represented by the summary, if it exists.
     */
    @Child(name = "duration", type = {DV_DURATION.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Duration of the entire History", formalDefinition="Duration of the entire History; either corresponds to the duration of all the events, and/or the duration represented by the summary, if it exists." )
    protected DV_DURATION duration;

    /**
     * Optional summary data that aggregates, organizes, reduces and transforms the event series. This may be a text or image that presents a graphical presentation, or some data that assists with the interpretation of the data
     */
    @Child(name = "summary", type = {ITEM_STRUCTURE.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional summary data that aggregates, organizes, reduces and transforms the event series", formalDefinition="Optional summary data that aggregates, organizes, reduces and transforms the event series. This may be a text or image that presents a graphical presentation, or some data that assists with the interpretation of the data" )
    protected ITEM_STRUCTURE summary;

    /**
     * The events in the series. This attribute is of a generic type whose parameter must be a descendant of ITEM_STRUCTURE
     */
    @Child(name = "events", type = {EVENT.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The events in the series", formalDefinition="The events in the series. This attribute is of a generic type whose parameter must be a descendant of ITEM_STRUCTURE" )
    protected List<EVENT> eventsList;

    private static final long serialVersionUID = 1582352314L;

  /**
   * Constructor
   */
    public HISTORY() {
      super();
    }

  /**
   * Constructor
   */
    public HISTORY(DV_DATE_TIME origin) {
      super();
      this.setOrigin(origin);
    }

    /**
     * @return {@link #origin} (Time origin of this event history. The first event is not necessarily at the origin point.)
     */
    public DV_DATE_TIME getOrigin() { 
      if (this.origin == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HISTORY.origin");
        else if (Configuration.doAutoCreate())
          this.origin = new DV_DATE_TIME(); // cc
      return this.origin;
    }

    public boolean hasOrigin() { 
      return this.origin != null && !this.origin.isEmpty();
    }

    /**
     * @param value {@link #origin} (Time origin of this event history. The first event is not necessarily at the origin point.)
     */
    public HISTORY setOrigin(DV_DATE_TIME value) { 
      this.origin = value;
      return this;
    }

    /**
     * @return {@link #period} (Period between samples in this segment if periodic.)
     */
    public DV_DURATION getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HISTORY.period");
        else if (Configuration.doAutoCreate())
          this.period = new DV_DURATION(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Period between samples in this segment if periodic.)
     */
    public HISTORY setPeriod(DV_DURATION value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #duration} (Duration of the entire History; either corresponds to the duration of all the events, and/or the duration represented by the summary, if it exists.)
     */
    public DV_DURATION getDuration() { 
      if (this.duration == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HISTORY.duration");
        else if (Configuration.doAutoCreate())
          this.duration = new DV_DURATION(); // cc
      return this.duration;
    }

    public boolean hasDuration() { 
      return this.duration != null && !this.duration.isEmpty();
    }

    /**
     * @param value {@link #duration} (Duration of the entire History; either corresponds to the duration of all the events, and/or the duration represented by the summary, if it exists.)
     */
    public HISTORY setDuration(DV_DURATION value) { 
      this.duration = value;
      return this;
    }

    /**
     * @return {@link #summary} (Optional summary data that aggregates, organizes, reduces and transforms the event series. This may be a text or image that presents a graphical presentation, or some data that assists with the interpretation of the data)
     */
    public ITEM_STRUCTURE getSummary() { 
      return this.summary;
    }

    public boolean hasSummary() { 
      return this.summary != null && !this.summary.isEmpty();
    }

    /**
     * @param value {@link #summary} (Optional summary data that aggregates, organizes, reduces and transforms the event series. This may be a text or image that presents a graphical presentation, or some data that assists with the interpretation of the data)
     */
    public HISTORY setSummary(ITEM_STRUCTURE value) { 
      this.summary = value;
      return this;
    }

    /**
     * @return {@link #events} (The events in the series. This attribute is of a generic type whose parameter must be a descendant of ITEM_STRUCTURE)
     */
    public List<EVENT> getEventsList() { 
      if (this.eventsList == null)
        this.eventsList = new ArrayList<EVENT>();
      return this.eventsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HISTORY setEventsList(List<EVENT> theEvents) { 
      this.eventsList = theEvents;
      return this;
    }

    public boolean hasEvents() { 
      if (this.eventsList == null)
        return false;
      for (EVENT item : this.eventsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public HISTORY addEvents(EVENT t) { //3b
      if (t == null)
        return this;
      if (this.eventsList == null)
        this.eventsList = new ArrayList<EVENT>();
      this.eventsList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("origin", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time origin of this event history. The first event is not necessarily at the origin point.", 0, 1, origin));
        children.add(new Property("period", "http://openehr.org/fhir/StructureDefinition/DV-DURATION", "Period between samples in this segment if periodic.", 0, 1, period));
        children.add(new Property("duration", "http://openehr.org/fhir/StructureDefinition/DV-DURATION", "Duration of the entire History; either corresponds to the duration of all the events, and/or the duration represented by the summary, if it exists.", 0, 1, duration));
        children.add(new Property("summary", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Optional summary data that aggregates, organizes, reduces and transforms the event series. This may be a text or image that presents a graphical presentation, or some data that assists with the interpretation of the data", 0, 1, summary));
        children.add(new Property("events", "http://openehr.org/fhir/StructureDefinition/EVENT", "The events in the series. This attribute is of a generic type whose parameter must be a descendant of ITEM_STRUCTURE", 0, java.lang.Integer.MAX_VALUE, eventsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1008619738: /*origin*/  return new Property("origin", "http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME", "Time origin of this event history. The first event is not necessarily at the origin point.", 0, 1, origin);
        case -991726143: /*period*/  return new Property("period", "http://openehr.org/fhir/StructureDefinition/DV-DURATION", "Period between samples in this segment if periodic.", 0, 1, period);
        case -1992012396: /*duration*/  return new Property("duration", "http://openehr.org/fhir/StructureDefinition/DV-DURATION", "Duration of the entire History; either corresponds to the duration of all the events, and/or the duration represented by the summary, if it exists.", 0, 1, duration);
        case -1857640538: /*summary*/  return new Property("summary", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Optional summary data that aggregates, organizes, reduces and transforms the event series. This may be a text or image that presents a graphical presentation, or some data that assists with the interpretation of the data", 0, 1, summary);
        case -1291329255: /*events*/  return new Property("events", "http://openehr.org/fhir/StructureDefinition/EVENT", "The events in the series. This attribute is of a generic type whose parameter must be a descendant of ITEM_STRUCTURE", 0, java.lang.Integer.MAX_VALUE, eventsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : new Base[] {this.origin}; // DV_DATE_TIME
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // DV_DURATION
        case -1992012396: /*duration*/ return this.duration == null ? new Base[0] : new Base[] {this.duration}; // DV_DURATION
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : new Base[] {this.summary}; // ITEM_STRUCTURE
        case -1291329255: /*events*/ return this.eventsList == null ? new Base[0] : this.eventsList.toArray(new Base[this.eventsList.size()]); // EVENT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1008619738: // origin
          this.origin = (DV_DATE_TIME) value; // DV_DATE_TIME
          return value;
        case -991726143: // period
          this.period = (DV_DURATION) value; // DV_DURATION
          return value;
        case -1992012396: // duration
          this.duration = (DV_DURATION) value; // DV_DURATION
          return value;
        case -1857640538: // summary
          this.summary = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case -1291329255: // events
          this.getEventsList().add((EVENT) value); // EVENT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("origin")) {
          this.origin = (DV_DATE_TIME) value; // DV_DATE_TIME
        } else if (name.equals("period")) {
          this.period = (DV_DURATION) value; // DV_DURATION
        } else if (name.equals("duration")) {
          this.duration = (DV_DURATION) value; // DV_DURATION
        } else if (name.equals("summary")) {
          this.summary = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("events")) {
          this.getEventsList().add((EVENT) value); // EVENT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1008619738:  return getOrigin();
        case -991726143:  return getPeriod();
        case -1992012396:  return getDuration();
        case -1857640538: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'summary'");
        case -1291329255: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'events'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1008619738: /*origin*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DATE-TIME"};
        case -991726143: /*period*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DURATION"};
        case -1992012396: /*duration*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-DURATION"};
        case -1857640538: /*summary*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case -1291329255: /*events*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/EVENT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("origin")) {
          this.origin = new DV_DATE_TIME();
          return this.origin;
        }
        else if (name.equals("period")) {
          this.period = new DV_DURATION();
          return this.period;
        }
        else if (name.equals("duration")) {
          this.duration = new DV_DURATION();
          return this.duration;
        }
        else if (name.equals("summary")) {
          throw new FHIRException("Cannot call addChild on an abstract type HISTORY.summary");
        }
        else if (name.equals("events")) {
          throw new FHIRException("Cannot call addChild on an abstract type HISTORY.events");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "HISTORY";

  }

      public HISTORY copy() {
        HISTORY dst = new HISTORY();
        copyValues(dst);
        return dst;
      }

      public void copyValues(HISTORY dst) {
        super.copyValues(dst);
        dst.origin = origin == null ? null : origin.copy();
        dst.period = period == null ? null : period.copy();
        dst.duration = duration == null ? null : duration.copy();
        dst.summary = summary == null ? null : summary.copy();
        if (eventsList != null) {
          dst.eventsList = new ArrayList<EVENT>();
          for (EVENT i : eventsList)
            dst.eventsList.add(i.copy());
        };
      }

      protected HISTORY typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof HISTORY))
          return false;
        HISTORY o = (HISTORY) other_;
        return compareDeep(origin, o.origin, true) && compareDeep(period, o.period, true) && compareDeep(duration, o.duration, true)
           && compareDeep(summary, o.summary, true) && compareDeep(eventsList, o.eventsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof HISTORY))
          return false;
        HISTORY o = (HISTORY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(origin, period, duration
          , summary, eventsList);
      }


}

