package org.hl7.fhir.model.core;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.parser.DataFormatException;
import org.hl7.fhir.model.IModelContext;

import java.io.Serial;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.TimeZone;

/**
 * Represents a FHIR instant datatype. Valid precisions values for this type are:
 * <ul>
 * <li>{@link TemporalPrecisionEnum#SECOND}
 * <li>{@link TemporalPrecisionEnum#MILLI}
 * </ul>
 */
@DatatypeDef(name="instant")
public class InstantType extends BaseDateTimeType {

	@Serial
  private static final long serialVersionUID = 4L;
	
	/**
	 * The default precision for this type
	 */
	public static final ChronoUnit DEFAULT_PRECISION = ChronoUnit.MILLIS;

	/**
	 * Constructor which creates an InstantType with <b>no timne value</b>. Note
	 * that unlike the default constructor for the Java {@link Date} or
	 * {@link Calendar} objects, this constructor does not initialize the object
	 * with the current time.
	 * 
	 * @see #withCurrentTime() to create a new object that has been initialized
	 *      with the current time.
	 */
	public InstantType() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param modelContext the model context this object belongs to - all objects in a tree must share the same context
	 */
	public InstantType(IModelContext modelContext) {
	  this();
	  this.modelContext = modelContext;
	}

	/**
	 * Create a new InstantType
	 */
	public InstantType(IModelContext modelContext, Calendar theCalendar) {
		this(modelContext, toZdt(theCalendar));
	}

	public InstantType(Calendar theCalendar) {
	  this(null, theCalendar);
	}

  /**
   * Create a new instance using the given date, precision level, and time zone
   *
   * @throws DataFormatException
   *             If the specified precision is not allowed for this type
   */
  public InstantType(IModelContext modelContext, Date theDate, TemporalPrecisionEnum thePrecision, TimeZone theTimezone) {
    this(modelContext, toZdt(theDate, theTimezone), toChronoUnit(thePrecision));
  }

  /**
   * Create a new instance using the given date, precision level, and time zone
   *
   * @throws DataFormatException
   *             If the specified precision is not allowed for this type
   */
  public InstantType(Date theDate, TemporalPrecisionEnum thePrecision, TimeZone theTimezone) {
    this(toZdt(theDate, theTimezone), toChronoUnit(thePrecision));
  }


	/**
	 * Create a new InstantType using an existing value. <b>Use this constructor with caution</b>,
	 * as it may create more precision than warranted (since for example it is possible to pass in
	 * a DateTime with only a year, and this constructor will convert to an InstantType with 
	 * milliseconds precision).
	 */
	public InstantType(IModelContext modelContext, BaseDateTimeType theDateTime) {
    this.modelContext = modelContext;
		// Do not call super(foo) here, we don't want to trigger a DataFormatException
		setValue(theDateTime.getValue());
		setPrecision(DEFAULT_PRECISION);
		setTimeZone(theDateTime.getTimeZone());
	}

	public InstantType(BaseDateTimeType theDateTime) {
	  this(null, theDateTime);
	}

	/**
	 * Create a new InstantType with the given date/time and {@link TemporalPrecisionEnum#MILLI} precision
	 */
	public InstantType(IModelContext modelContext, Date theDate) {
		this(modelContext, toZdt(theDate), DEFAULT_PRECISION);
	}

	/**
	 * Create a new InstantType with the given date/time and {@link TemporalPrecisionEnum#MILLI} precision
	 */
	public InstantType(IModelContext modelContext, ZonedDateTime theDateTime) {
		super(modelContext, theDateTime, DEFAULT_PRECISION);
	}

	/**
	 * Create a new InstantType with the given date/time and precision
	 */
	public InstantType(IModelContext modelContext, ZonedDateTime theDateTime, ChronoUnit thePrecision) {
		super(modelContext, theDateTime, thePrecision);
	}

	public InstantType(Date theDate) {
	  this(null, theDate);
	}

	public InstantType(ZonedDateTime theZonedDateTime) {
	  this(null, theZonedDateTime);
	}

  /**
   * Constructor which accepts a date value and a precision value. Valid
   * precisions values for this type are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   */
  public InstantType(IModelContext modelContext, Date theDate, TemporalPrecisionEnum thePrecision) {
    this(modelContext, toZdt(theDate), toChronoUnit(thePrecision));
  }

  /**
   * Constructor which accepts a date value and a precision value. Valid
   * precisions values for this type are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   */
  public InstantType(Date theDate, TemporalPrecisionEnum thePrecision) {
    this(toZdt(theDate), toChronoUnit(thePrecision));
  }

  /**
   * Constructor which accepts a date value and a precision value. Valid
   * precisions values for this type are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   */
  public InstantType(ZonedDateTime theDateTime, ChronoUnit thePrecision) {
    super(theDateTime, thePrecision);
  }

  /**
   * Create a new InstantType from a string value
   *
   * @param theString
   *            The string representation of the string. Must be in a valid
   *            format according to the FHIR specification
   * @throws DataFormatException If the string is not in a valid format for the datatype
   */
  public InstantType(IModelContext modelContext, String theString) throws DataFormatException {
    super(modelContext, theString);
  }

  /**
   * Create a new InstantType from a string value
   *
   * @param theString
   *            The string representation of the string. Must be in a valid
   *            format according to the FHIR specification
   * @throws DataFormatException If the string is not in a valid format for the datatype
   */
  public InstantType(String theString) throws DataFormatException {
    super(theString);
  }

	/**
	 * Invokes {@link Date#after(Date)} on the contained Date against the given
	 * date
	 * 
	 * @throws NullPointerException
	 *             If the {@link #getValue() contained Date} is null
	 */
	public boolean after(Date theDate) {
		return getValue().toInstant().isAfter(theDate.toInstant());
	}

	/**
	 * Invokes {@link Date#before(Date)} on the contained Date against the given
	 * date
	 * 
	 * @throws NullPointerException
	 *             If the {@link #getValue() contained Date} is null
	 */
	public boolean before(Date theDate) {
		return getValue().toInstant().isAfter(theDate.toInstant());
	}

	/**
	 * Sets the value of this instant to the current time (from the system
	 * clock) and the local/default timezone (as retrieved using
	 * {@link TimeZone#getDefault()}. This TimeZone is generally obtained from
	 * the underlying OS.
	 */
	public void setToCurrentTimeInLocalTimeZone() {
		setValue(ZonedDateTime.now());
	}

	@Override
	boolean isPrecisionAllowed(ChronoUnit thePrecision) {
    return switch (thePrecision) {
      case SECONDS, MILLIS, NANOS -> true;
      default -> false;
    };
	}

	/**
	 * Factory method which creates a new InstantType with millisecond precision and initializes it with the
	 * current time and the system local timezone.
	 */
	public static InstantType withCurrentTime() {
		return new InstantType(new Date(), TemporalPrecisionEnum.MILLI, TimeZone.getDefault());
	}

	/**
	 * Returns the default precision for this datatype
	 * 
	 * @see #DEFAULT_PRECISION
	 */
	@Override
	protected ChronoUnit getDefaultPrecisionForDatatype() {
		return DEFAULT_PRECISION;
	}


	@Override
	public InstantType copy(EnumSet<CopyObjectOptions> options) {
    InstantType ret = new InstantType();
    ret.setValueAsString(getValueAsString());
    copyValues(ret, options);
    return ret;
	}

	/**
	 * Returns a new instance of DateTimeType with the current system time and MILLI precision and the system local time
	 * zone
	 */
	public static InstantType now() {
		return new InstantType(new Date(), TemporalPrecisionEnum.MILLI, TimeZone.getDefault());
	}

	/**
	 * Creates a new instance by parsing an HL7 v3 format date time string
	 */
	public static InstantType parseV3(String theV3String) {
		InstantType retVal = new InstantType();
		retVal.setValueAsV3String(theV3String);
		return retVal;
	}

	public String fhirType() {
		return "instant";
	}
}