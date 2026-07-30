package org.hl7.fhir.r5.model;

import java.util.Calendar;

import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

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



import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.parser.DataFormatException;

/**
 * Represents a Time datatype, per the FHIR specification. A time is a specification of hours and minutes (and optionally milliseconds), with NO date and NO timezone information attached. It is
 * expressed as a string in the form <code>HH:mm:ss[.SSSS]</code>
 */
@DatatypeDef(name="time")
public class TimeType extends PrimitiveType<String> {

	private static final long serialVersionUID = 3L;

	/**
	 * Constructor
	 */
	public TimeType() {
		// nothing
	}
	
	/**
	 * Constructor
	 */
	public TimeType(String theValue) {
		setValue(theValue);
	}

	@Override
	protected String parse(String theValue) {
		return theValue;
	}

	@Override
	protected String encode(String theValue) {
		return theValue;
	}

	@Override
	public TimeType copy() {
		TimeType ret = new TimeType(getValue());
    copyValues(ret);
    return ret;
	}

	public String fhirType() {
		return "time";
	}

  public int getHour() {
    String v = getValue();
    if (v.length() < 2) {
      return 0;
    }
    v = v.substring(0, 2);
    if (!Utilities.isInteger(v)) {
      return 0;
    }
    return Integer.parseInt(v);
  }

  public int getMinute() {
    String v = getValue();
    if (v.length() < 5) {
      return 0;
    }
    v = v.substring(3, 5);
    if (!Utilities.isInteger(v)) {
      return 0;
    }
    return Integer.parseInt(v);
  }

  public float getSecond() {
    String v = getValue();
    if (v.length() < 8) {
      return 0;
    }
    v = v.substring(6);
    if (!Utilities.isDecimal(v, false, true)) {
      return 0;
    }
    return Float.parseFloat(v);
  }

  public TemporalPrecisionEnum getPrecision() {
    String v = getValue();
//    if (v.length() == 2) {
//      return TemporalPrecisionEnum.HOUR;
//    }
    if (v.length() == 5) {
      return TemporalPrecisionEnum.MINUTE;
    }
    if (v.length() == 8) {
      return TemporalPrecisionEnum.SECOND;
    }
    if (v.length() > 9) {
      return TemporalPrecisionEnum.MILLI;
    }
   
    return null;
  }

  public void setPrecision(TemporalPrecisionEnum temp) {
    if (temp == TemporalPrecisionEnum.MINUTE) {
      setValue(getValue().substring(0, 5));
    }
    if (temp == TemporalPrecisionEnum.SECOND) {
      setValue(getValue().substring(0, 8));
    }
  }

	/**
	 * Adds the given amount to the field specified by theField
	 *
	 * @param theField
	 *           The field, uses constants from {@link Calendar} such as {@link Calendar#YEAR}
	 * @param theValue
	 *           The number to add (or subtract for a negative number)
	 */
	public void add(int theField, int theValue) {
    int hours = getHour();
    int minutes = getMinute();
    float seconds = getSecond();
    boolean hasMillis = getPrecision() == TemporalPrecisionEnum.MILLI;

		switch (theField) {
		case Calendar.HOUR:
			hours += theValue;
			break;
		case Calendar.MINUTE:
      minutes += theValue;
			break;
		case Calendar.SECOND:
      seconds += theValue;
			break;
		case Calendar.MILLISECOND:
      // Convert milliseconds to seconds
      seconds += theValue / 1000.0f;
      hasMillis = true;
			break;
		default:
			throw new DataFormatException("Unknown field constant: " + theField);
		}

    // Handle overflow of seconds into minutes
    if (seconds >= 60) {
      minutes += (int) seconds / 60;
      seconds = seconds % 60;
    } else if (seconds < 0) {
      minutes += ((int) seconds / 60) - 1;
      seconds = 60 + (seconds % 60);
    }
    // Handle overflow of minutes into hours
    if (minutes >= 60) {
      hours += minutes / 60;
      minutes = minutes % 60;
    } else if (minutes < 0) {
      hours += (minutes / 60) - 1;
      minutes = 60 + (minutes % 60);
    }
    // truncate hours to 24-hour format
    if (hours >= 24) {
      hours = hours % 24;
    } else if (hours < 0) {
      hours = 24 + (hours % 24);
    }

    if (hasMillis) {
      setValue(String.format("%02d:%02d:%06.3f", hours, minutes, seconds));
    } else {
      setValue(String.format("%02d:%02d:%02d", hours, minutes, (int) seconds));
    }
	}

  @Override
  public String fpValue() {
    return "@T"+primitiveValue();
  }

  public boolean before(TimeType other) {
    return primitiveValue().compareTo(other.primitiveValue()) < 0;

  }

  public boolean after(TimeType other) {
    return primitiveValue().compareTo(other.primitiveValue()) > 0;
  }
}