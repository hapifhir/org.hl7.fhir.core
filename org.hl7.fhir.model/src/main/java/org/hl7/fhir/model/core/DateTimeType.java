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



import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.Base.CopyObjectOptions;
import org.hl7.fhir.model.Base;
import java.util.EnumSet;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.DataFormatException;

/**
 * Represents a FHIR dateTime datatype. Valid precisions values for this type are:
 * <ul>
 * <li>{@link TemporalPrecisionEnum#YEAR}
 * <li>{@link TemporalPrecisionEnum#MONTH}
 * <li>{@link TemporalPrecisionEnum#DAY}
 * <li>{@link TemporalPrecisionEnum#SECOND}
 * <li>{@link TemporalPrecisionEnum#MILLI}
 * </ul>
 */
@DatatypeDef(name = "dateTime")
public class DateTimeType extends BaseDateTimeType {

	private static final long serialVersionUID = 3L;
	
	/**
	 * The default precision for this type
	 */
	public static final TemporalPrecisionEnum DEFAULT_PRECISION = TemporalPrecisionEnum.SECOND;

	/**
	 * Constructor
	 */
	public DateTimeType() {
		super();
	}

	/**
	 * Constructor
	 *
	 * @param context the model context this object belongs to - all objects in a tree must share the same context
	 */
	public DateTimeType(IModelContext modelContext) {
	  this();
	  this.modelContext = modelContext;
	}

  /**
   * Create a new DateTimeDt with seconds precision and the local time zone
   */
  public DateTimeType(IModelContext modelContext, Date theDate) {
    super(modelContext, theDate, DEFAULT_PRECISION, TimeZone.getDefault());
  }
  /**
   * Create a new DateTimeDt with seconds precision and the local time zone
   */
  public DateTimeType(Date theDate) {
    super(theDate, DEFAULT_PRECISION, TimeZone.getDefault());
  }

  /**
   * Constructor which accepts a date value and a precision value. Valid precisions values for this type are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#YEAR}
   * <li>{@link TemporalPrecisionEnum#MONTH}
   * <li>{@link TemporalPrecisionEnum#DAY}
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   *
   * @throws DataFormatException
   *             If the specified precision is not allowed for this type
   */
  public DateTimeType(IModelContext modelContext, Date theDate, TemporalPrecisionEnum thePrecision) {
    super(modelContext, theDate, thePrecision, TimeZone.getDefault());
  }

  /**
   * Constructor which accepts a date value and a precision value. Valid precisions values for this type are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#YEAR}
   * <li>{@link TemporalPrecisionEnum#MONTH}
   * <li>{@link TemporalPrecisionEnum#DAY}
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   *
   * @throws DataFormatException
   *             If the specified precision is not allowed for this type
   */
  public DateTimeType(Date theDate, TemporalPrecisionEnum thePrecision) {
    super(theDate, thePrecision, TimeZone.getDefault());
  }

  /**
   * Create a new instance using a string date/time
   *
   * @throws DataFormatException
   *             If the specified precision is not allowed for this type
   */
  public DateTimeType(IModelContext modelContext, String theValue) {
    super(modelContext, theValue);
  }

  /**
   * Create a new instance using a string date/time
   *
   * @throws DataFormatException
   *             If the specified precision is not allowed for this type
   */
  public DateTimeType(String theValue) {
    super(theValue);
  }

  /**
   * Constructor which accepts a date value, precision value, and time zone. Valid precisions values for this type
   * are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#YEAR}
   * <li>{@link TemporalPrecisionEnum#MONTH}
   * <li>{@link TemporalPrecisionEnum#DAY}
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   */
  public DateTimeType(IModelContext modelContext, Date theDate, TemporalPrecisionEnum thePrecision, TimeZone theTimezone) {
    super(modelContext, theDate, thePrecision, theTimezone);
  }

  /**
   * Constructor which accepts a date value, precision value, and time zone. Valid precisions values for this type
   * are:
   * <ul>
   * <li>{@link TemporalPrecisionEnum#YEAR}
   * <li>{@link TemporalPrecisionEnum#MONTH}
   * <li>{@link TemporalPrecisionEnum#DAY}
   * <li>{@link TemporalPrecisionEnum#SECOND}
   * <li>{@link TemporalPrecisionEnum#MILLI}
   * </ul>
   */
  public DateTimeType(Date theDate, TemporalPrecisionEnum thePrecision, TimeZone theTimezone) {
    super(theDate, thePrecision, theTimezone);
  }

  /**
   * Constructor
   */
  public DateTimeType(IModelContext modelContext, Calendar theCalendar) {
    this.modelContext = modelContext;
    if (theCalendar != null) {
      setValue(theCalendar.getTime());
      setPrecision(DEFAULT_PRECISION);
      setTimeZone(theCalendar.getTimeZone());
    }
  }
  /**
   * Constructor
   */
  public DateTimeType(Calendar theCalendar) {
    if (theCalendar != null) {
      setValue(theCalendar.getTime());
      setPrecision(DEFAULT_PRECISION);
      setTimeZone(theCalendar.getTimeZone());
    }
  }

	@Override
	boolean isPrecisionAllowed(TemporalPrecisionEnum thePrecision) {
		switch (thePrecision) {
		case YEAR:
		case MONTH:
		case DAY:
		case SECOND:
		case MILLI:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Returns a new instance of DateTimeType with the current system time and SECOND precision and the system local time
	 * zone
	 */
	public static DateTimeType now() {
		return new DateTimeType(new Date(), TemporalPrecisionEnum.SECOND, TimeZone.getDefault());
	}

	/**
	 * Returns the default precision for this datatype
	 * 
	 * @see #DEFAULT_PRECISION
	 */
	@Override
	protected TemporalPrecisionEnum getDefaultPrecisionForDatatype() {
		return DEFAULT_PRECISION;
	}

	@Override
	public DateTimeType copy(EnumSet<CopyObjectOptions> options) {
		DateTimeType ret = new DateTimeType(modelContext, getValueAsString());
    copyValues(ret, options);
    return ret;
	}

	/**
	 * Creates a new instance by parsing an HL7 v3 format date time string
	 */
	public static DateTimeType parseV3(String theV3String) {
		DateTimeType retVal = new DateTimeType();
		retVal.setValueAsV3String(theV3String);
		return retVal;
	}

	public static DateTimeType today() {
		DateTimeType retVal = now();
		retVal.setPrecision(TemporalPrecisionEnum.DAY);
		return retVal;
	}

	public boolean getTzSign() {
		return getTimeZone().getRawOffset() >= 0;
	}

	public int getTzHour() {
		return (int) (getTimeZone().getRawOffset() / DateUtils.MILLIS_PER_MINUTE) / 60;
	}

	public int getTzMin() {
		return (int) (getTimeZone().getRawOffset() / DateUtils.MILLIS_PER_MINUTE) % 60;
	}

	
	public String fhirType() {
		return "dateTime";		
	}

  public String getAsV3() {
    String r = getValueAsString();
    r = stripChar(r, 16, ':');
    r = stripChar(r, 13, ':');
    r = stripChar(r, 10, 'T');
    r = stripChar(r, 7, '-');
    r = stripChar(r, 4, '-');
    r = r.replace(":", ""); // might be in the timezone
    return r;
  }

  private String stripChar(String r, int i, char c) {
    if (r.length() <= i || r.charAt(i) != c)
      return r;
    return r.substring(0, i)+r.substring(i+1);
  }

  @Override
  public boolean isDateTime() {
    return true;
  }

}