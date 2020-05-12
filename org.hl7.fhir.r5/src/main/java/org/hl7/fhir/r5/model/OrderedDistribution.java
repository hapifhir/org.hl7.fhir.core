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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

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
 * Base StructureDefinition for OrderedDistribution Type: An ordered list (distribution) of statistics.
 */
@DatatypeDef(name="OrderedDistribution")
public class OrderedDistribution extends BackboneType implements ICompositeType {

    @Block()
    public static class OrderedDistributionIntervalComponent extends Element implements IBaseDatatypeElement {
        /**
         * Relative order of interval.
         */
        @Child(name = "rankOrder", type = {IntegerType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Relative order of interval", formalDefinition="Relative order of interval." )
        protected IntegerType rankOrder;

        /**
         * Values and parameters for a single statistic related to the interval.
         */
        @Child(name = "intervalStatistic", type = {Statistic.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Values and parameters for a single statistic related to the interval", formalDefinition="Values and parameters for a single statistic related to the interval." )
        protected List<Statistic> intervalStatistic;

        private static final long serialVersionUID = 1714817635L;

    /**
     * Constructor
     */
      public OrderedDistributionIntervalComponent() {
        super();
      }

    /**
     * Constructor
     */
      public OrderedDistributionIntervalComponent(int rankOrder) {
        super();
        this.setRankOrder(rankOrder);
      }

        /**
         * @return {@link #rankOrder} (Relative order of interval.). This is the underlying object with id, value and extensions. The accessor "getRankOrder" gives direct access to the value
         */
        public IntegerType getRankOrderElement() { 
          if (this.rankOrder == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OrderedDistributionIntervalComponent.rankOrder");
            else if (Configuration.doAutoCreate())
              this.rankOrder = new IntegerType(); // bb
          return this.rankOrder;
        }

        public boolean hasRankOrderElement() { 
          return this.rankOrder != null && !this.rankOrder.isEmpty();
        }

        public boolean hasRankOrder() { 
          return this.rankOrder != null && !this.rankOrder.isEmpty();
        }

        /**
         * @param value {@link #rankOrder} (Relative order of interval.). This is the underlying object with id, value and extensions. The accessor "getRankOrder" gives direct access to the value
         */
        public OrderedDistributionIntervalComponent setRankOrderElement(IntegerType value) { 
          this.rankOrder = value;
          return this;
        }

        /**
         * @return Relative order of interval.
         */
        public int getRankOrder() { 
          return this.rankOrder == null || this.rankOrder.isEmpty() ? 0 : this.rankOrder.getValue();
        }

        /**
         * @param value Relative order of interval.
         */
        public OrderedDistributionIntervalComponent setRankOrder(int value) { 
            if (this.rankOrder == null)
              this.rankOrder = new IntegerType();
            this.rankOrder.setValue(value);
          return this;
        }

        /**
         * @return {@link #intervalStatistic} (Values and parameters for a single statistic related to the interval.)
         */
        public List<Statistic> getIntervalStatistic() { 
          if (this.intervalStatistic == null)
            this.intervalStatistic = new ArrayList<Statistic>();
          return this.intervalStatistic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public OrderedDistributionIntervalComponent setIntervalStatistic(List<Statistic> theIntervalStatistic) { 
          this.intervalStatistic = theIntervalStatistic;
          return this;
        }

        public boolean hasIntervalStatistic() { 
          if (this.intervalStatistic == null)
            return false;
          for (Statistic item : this.intervalStatistic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Statistic addIntervalStatistic() { //3
          Statistic t = new Statistic();
          if (this.intervalStatistic == null)
            this.intervalStatistic = new ArrayList<Statistic>();
          this.intervalStatistic.add(t);
          return t;
        }

        public OrderedDistributionIntervalComponent addIntervalStatistic(Statistic t) { //3
          if (t == null)
            return this;
          if (this.intervalStatistic == null)
            this.intervalStatistic = new ArrayList<Statistic>();
          this.intervalStatistic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #intervalStatistic}, creating it if it does not already exist {3}
         */
        public Statistic getIntervalStatisticFirstRep() { 
          if (getIntervalStatistic().isEmpty()) {
            addIntervalStatistic();
          }
          return getIntervalStatistic().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("rankOrder", "integer", "Relative order of interval.", 0, 1, rankOrder));
          children.add(new Property("intervalStatistic", "Statistic", "Values and parameters for a single statistic related to the interval.", 0, java.lang.Integer.MAX_VALUE, intervalStatistic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -656537982: /*rankOrder*/  return new Property("rankOrder", "integer", "Relative order of interval.", 0, 1, rankOrder);
          case 227099147: /*intervalStatistic*/  return new Property("intervalStatistic", "Statistic", "Values and parameters for a single statistic related to the interval.", 0, java.lang.Integer.MAX_VALUE, intervalStatistic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -656537982: /*rankOrder*/ return this.rankOrder == null ? new Base[0] : new Base[] {this.rankOrder}; // IntegerType
        case 227099147: /*intervalStatistic*/ return this.intervalStatistic == null ? new Base[0] : this.intervalStatistic.toArray(new Base[this.intervalStatistic.size()]); // Statistic
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -656537982: // rankOrder
          this.rankOrder = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 227099147: // intervalStatistic
          this.getIntervalStatistic().add(TypeConvertor.castToStatistic(value)); // Statistic
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("rankOrder")) {
          this.rankOrder = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("intervalStatistic")) {
          this.getIntervalStatistic().add(TypeConvertor.castToStatistic(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -656537982:  return getRankOrderElement();
        case 227099147:  return addIntervalStatistic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -656537982: /*rankOrder*/ return new String[] {"integer"};
        case 227099147: /*intervalStatistic*/ return new String[] {"Statistic"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("rankOrder")) {
          throw new FHIRException("Cannot call addChild on a primitive type OrderedDistribution.interval.rankOrder");
        }
        else if (name.equals("intervalStatistic")) {
          return addIntervalStatistic();
        }
        else
          return super.addChild(name);
      }

      public OrderedDistributionIntervalComponent copy() {
        OrderedDistributionIntervalComponent dst = new OrderedDistributionIntervalComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OrderedDistributionIntervalComponent dst) {
        super.copyValues(dst);
        dst.rankOrder = rankOrder == null ? null : rankOrder.copy();
        if (intervalStatistic != null) {
          dst.intervalStatistic = new ArrayList<Statistic>();
          for (Statistic i : intervalStatistic)
            dst.intervalStatistic.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OrderedDistributionIntervalComponent))
          return false;
        OrderedDistributionIntervalComponent o = (OrderedDistributionIntervalComponent) other_;
        return compareDeep(rankOrder, o.rankOrder, true) && compareDeep(intervalStatistic, o.intervalStatistic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OrderedDistributionIntervalComponent))
          return false;
        OrderedDistributionIntervalComponent o = (OrderedDistributionIntervalComponent) other_;
        return compareValues(rankOrder, o.rankOrder, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(rankOrder, intervalStatistic
          );
      }

  public String fhirType() {
    return "OrderedDistribution.interval";

  }

  }

    /**
     * A description of the content and value of the statistic.
     */
    @Child(name = "description", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A description of the content and value of the statistic", formalDefinition="A description of the content and value of the statistic." )
    protected StringType description;

    /**
     * Footnotes and/or explanatory notes.
     */
    @Child(name = "note", type = {Annotation.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
    protected List<Annotation> note;

    /**
     * Number of intervals in an array, eg 4 for quartiles.
     */
    @Child(name = "numberOfIntervals", type = {IntegerType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of intervals in an array, eg 4 for quartiles", formalDefinition="Number of intervals in an array, eg 4 for quartiles." )
    protected IntegerType numberOfIntervals;

    /**
     * Bottom of first interval.
     */
    @Child(name = "bottomOfFirstInterval", type = {Quantity.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Bottom of first interval", formalDefinition="Bottom of first interval." )
    protected Quantity bottomOfFirstInterval;

    /**
     * Interval.
     */
    @Child(name = "interval", type = {}, order=4, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Interval", formalDefinition="Interval." )
    protected List<OrderedDistributionIntervalComponent> interval;

    /**
     * Singular value of the statistic at the upper bound of the interval.
     */
    @Child(name = "topOfInterval", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Singular value of the statistic at the upper bound of the interval", formalDefinition="Singular value of the statistic at the upper bound of the interval." )
    protected Quantity topOfInterval;

    private static final long serialVersionUID = -1559333328L;

  /**
   * Constructor
   */
    public OrderedDistribution() {
      super();
    }

  /**
   * Constructor
   */
    public OrderedDistribution(int numberOfIntervals, OrderedDistributionIntervalComponent interval) {
      super();
      this.setNumberOfIntervals(numberOfIntervals);
      this.addInterval(interval);
    }

    /**
     * @return {@link #description} (A description of the content and value of the statistic.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OrderedDistribution.description");
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
     * @param value {@link #description} (A description of the content and value of the statistic.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public OrderedDistribution setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A description of the content and value of the statistic.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A description of the content and value of the statistic.
     */
    public OrderedDistribution setDescription(String value) { 
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
     * @return {@link #note} (Footnotes and/or explanatory notes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OrderedDistribution setNote(List<Annotation> theNote) { 
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

    public OrderedDistribution addNote(Annotation t) { //3
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
     * @return {@link #numberOfIntervals} (Number of intervals in an array, eg 4 for quartiles.). This is the underlying object with id, value and extensions. The accessor "getNumberOfIntervals" gives direct access to the value
     */
    public IntegerType getNumberOfIntervalsElement() { 
      if (this.numberOfIntervals == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OrderedDistribution.numberOfIntervals");
        else if (Configuration.doAutoCreate())
          this.numberOfIntervals = new IntegerType(); // bb
      return this.numberOfIntervals;
    }

    public boolean hasNumberOfIntervalsElement() { 
      return this.numberOfIntervals != null && !this.numberOfIntervals.isEmpty();
    }

    public boolean hasNumberOfIntervals() { 
      return this.numberOfIntervals != null && !this.numberOfIntervals.isEmpty();
    }

    /**
     * @param value {@link #numberOfIntervals} (Number of intervals in an array, eg 4 for quartiles.). This is the underlying object with id, value and extensions. The accessor "getNumberOfIntervals" gives direct access to the value
     */
    public OrderedDistribution setNumberOfIntervalsElement(IntegerType value) { 
      this.numberOfIntervals = value;
      return this;
    }

    /**
     * @return Number of intervals in an array, eg 4 for quartiles.
     */
    public int getNumberOfIntervals() { 
      return this.numberOfIntervals == null || this.numberOfIntervals.isEmpty() ? 0 : this.numberOfIntervals.getValue();
    }

    /**
     * @param value Number of intervals in an array, eg 4 for quartiles.
     */
    public OrderedDistribution setNumberOfIntervals(int value) { 
        if (this.numberOfIntervals == null)
          this.numberOfIntervals = new IntegerType();
        this.numberOfIntervals.setValue(value);
      return this;
    }

    /**
     * @return {@link #bottomOfFirstInterval} (Bottom of first interval.)
     */
    public Quantity getBottomOfFirstInterval() { 
      if (this.bottomOfFirstInterval == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OrderedDistribution.bottomOfFirstInterval");
        else if (Configuration.doAutoCreate())
          this.bottomOfFirstInterval = new Quantity(); // cc
      return this.bottomOfFirstInterval;
    }

    public boolean hasBottomOfFirstInterval() { 
      return this.bottomOfFirstInterval != null && !this.bottomOfFirstInterval.isEmpty();
    }

    /**
     * @param value {@link #bottomOfFirstInterval} (Bottom of first interval.)
     */
    public OrderedDistribution setBottomOfFirstInterval(Quantity value) { 
      this.bottomOfFirstInterval = value;
      return this;
    }

    /**
     * @return {@link #interval} (Interval.)
     */
    public List<OrderedDistributionIntervalComponent> getInterval() { 
      if (this.interval == null)
        this.interval = new ArrayList<OrderedDistributionIntervalComponent>();
      return this.interval;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OrderedDistribution setInterval(List<OrderedDistributionIntervalComponent> theInterval) { 
      this.interval = theInterval;
      return this;
    }

    public boolean hasInterval() { 
      if (this.interval == null)
        return false;
      for (OrderedDistributionIntervalComponent item : this.interval)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OrderedDistributionIntervalComponent addInterval() { //3
      OrderedDistributionIntervalComponent t = new OrderedDistributionIntervalComponent();
      if (this.interval == null)
        this.interval = new ArrayList<OrderedDistributionIntervalComponent>();
      this.interval.add(t);
      return t;
    }

    public OrderedDistribution addInterval(OrderedDistributionIntervalComponent t) { //3
      if (t == null)
        return this;
      if (this.interval == null)
        this.interval = new ArrayList<OrderedDistributionIntervalComponent>();
      this.interval.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #interval}, creating it if it does not already exist {3}
     */
    public OrderedDistributionIntervalComponent getIntervalFirstRep() { 
      if (getInterval().isEmpty()) {
        addInterval();
      }
      return getInterval().get(0);
    }

    /**
     * @return {@link #topOfInterval} (Singular value of the statistic at the upper bound of the interval.)
     */
    public Quantity getTopOfInterval() { 
      if (this.topOfInterval == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OrderedDistribution.topOfInterval");
        else if (Configuration.doAutoCreate())
          this.topOfInterval = new Quantity(); // cc
      return this.topOfInterval;
    }

    public boolean hasTopOfInterval() { 
      return this.topOfInterval != null && !this.topOfInterval.isEmpty();
    }

    /**
     * @param value {@link #topOfInterval} (Singular value of the statistic at the upper bound of the interval.)
     */
    public OrderedDistribution setTopOfInterval(Quantity value) { 
      this.topOfInterval = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("description", "string", "A description of the content and value of the statistic.", 0, 1, description));
        children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("numberOfIntervals", "integer", "Number of intervals in an array, eg 4 for quartiles.", 0, 1, numberOfIntervals));
        children.add(new Property("bottomOfFirstInterval", "Quantity", "Bottom of first interval.", 0, 1, bottomOfFirstInterval));
        children.add(new Property("interval", "", "Interval.", 0, java.lang.Integer.MAX_VALUE, interval));
        children.add(new Property("topOfInterval", "Quantity", "Singular value of the statistic at the upper bound of the interval.", 0, 1, topOfInterval));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1724546052: /*description*/  return new Property("description", "string", "A description of the content and value of the statistic.", 0, 1, description);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
        case -569541330: /*numberOfIntervals*/  return new Property("numberOfIntervals", "integer", "Number of intervals in an array, eg 4 for quartiles.", 0, 1, numberOfIntervals);
        case 37889363: /*bottomOfFirstInterval*/  return new Property("bottomOfFirstInterval", "Quantity", "Bottom of first interval.", 0, 1, bottomOfFirstInterval);
        case 570418373: /*interval*/  return new Property("interval", "", "Interval.", 0, java.lang.Integer.MAX_VALUE, interval);
        case 691816177: /*topOfInterval*/  return new Property("topOfInterval", "Quantity", "Singular value of the statistic at the upper bound of the interval.", 0, 1, topOfInterval);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -569541330: /*numberOfIntervals*/ return this.numberOfIntervals == null ? new Base[0] : new Base[] {this.numberOfIntervals}; // IntegerType
        case 37889363: /*bottomOfFirstInterval*/ return this.bottomOfFirstInterval == null ? new Base[0] : new Base[] {this.bottomOfFirstInterval}; // Quantity
        case 570418373: /*interval*/ return this.interval == null ? new Base[0] : this.interval.toArray(new Base[this.interval.size()]); // OrderedDistributionIntervalComponent
        case 691816177: /*topOfInterval*/ return this.topOfInterval == null ? new Base[0] : new Base[] {this.topOfInterval}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -569541330: // numberOfIntervals
          this.numberOfIntervals = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 37889363: // bottomOfFirstInterval
          this.bottomOfFirstInterval = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 570418373: // interval
          this.getInterval().add((OrderedDistributionIntervalComponent) value); // OrderedDistributionIntervalComponent
          return value;
        case 691816177: // topOfInterval
          this.topOfInterval = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("numberOfIntervals")) {
          this.numberOfIntervals = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("bottomOfFirstInterval")) {
          this.bottomOfFirstInterval = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("interval")) {
          this.getInterval().add((OrderedDistributionIntervalComponent) value);
        } else if (name.equals("topOfInterval")) {
          this.topOfInterval = TypeConvertor.castToQuantity(value); // Quantity
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -569541330:  return getNumberOfIntervalsElement();
        case 37889363:  return getBottomOfFirstInterval();
        case 570418373:  return addInterval(); 
        case 691816177:  return getTopOfInterval();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -569541330: /*numberOfIntervals*/ return new String[] {"integer"};
        case 37889363: /*bottomOfFirstInterval*/ return new String[] {"Quantity"};
        case 570418373: /*interval*/ return new String[] {};
        case 691816177: /*topOfInterval*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type OrderedDistribution.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("numberOfIntervals")) {
          throw new FHIRException("Cannot call addChild on a primitive type OrderedDistribution.numberOfIntervals");
        }
        else if (name.equals("bottomOfFirstInterval")) {
          this.bottomOfFirstInterval = new Quantity();
          return this.bottomOfFirstInterval;
        }
        else if (name.equals("interval")) {
          return addInterval();
        }
        else if (name.equals("topOfInterval")) {
          this.topOfInterval = new Quantity();
          return this.topOfInterval;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "OrderedDistribution";

  }

      public OrderedDistribution copy() {
        OrderedDistribution dst = new OrderedDistribution();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OrderedDistribution dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.numberOfIntervals = numberOfIntervals == null ? null : numberOfIntervals.copy();
        dst.bottomOfFirstInterval = bottomOfFirstInterval == null ? null : bottomOfFirstInterval.copy();
        if (interval != null) {
          dst.interval = new ArrayList<OrderedDistributionIntervalComponent>();
          for (OrderedDistributionIntervalComponent i : interval)
            dst.interval.add(i.copy());
        };
        dst.topOfInterval = topOfInterval == null ? null : topOfInterval.copy();
      }

      protected OrderedDistribution typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OrderedDistribution))
          return false;
        OrderedDistribution o = (OrderedDistribution) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(numberOfIntervals, o.numberOfIntervals, true)
           && compareDeep(bottomOfFirstInterval, o.bottomOfFirstInterval, true) && compareDeep(interval, o.interval, true)
           && compareDeep(topOfInterval, o.topOfInterval, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OrderedDistribution))
          return false;
        OrderedDistribution o = (OrderedDistribution) other_;
        return compareValues(description, o.description, true) && compareValues(numberOfIntervals, o.numberOfIntervals, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, numberOfIntervals
          , bottomOfFirstInterval, interval, topOfInterval);
      }


}