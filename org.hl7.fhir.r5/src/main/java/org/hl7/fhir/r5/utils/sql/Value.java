package org.hl7.fhir.r5.utils.sql;

import java.math.BigDecimal;
import java.util.Date;

import org.hl7.fhir.r5.model.Base;


/**
 * String value is always provided, and a more specific value may also be provided
 */

public class Value {

  private String valueString;
  private Boolean valueBoolean;
  private Date valueDate;
  private Integer valueInt;
  private BigDecimal valueDecimal;
  private byte[] valueBinary;
  private Base valueComplex;
  
  private Value() {
    super();
  }
  
  public static Value makeString(String s) {
    Value v = new Value();
    v.valueString = s;
    return v;
  }
  
  public static Value makeBoolean(String s, Boolean b) {
    Value v = new Value();
    v.valueString = s;
    v.valueBoolean = b;
    return v;
  }
  
  public static Value makeDate(String s, Date d) {
    Value v = new Value();
    v.valueString = s;
    v.valueDate = d;
    return v;
  }
  
  public static Value makeInteger(String s, Integer i) {
    Value v = new Value();
    v.valueString = s;
    v.valueInt = i;
    return v;
  }
  

  public static Value makeDecimal(String s, BigDecimal bigDecimal) {
    Value v = new Value();
    v.valueString = s;
    v.valueDecimal = bigDecimal;
    return v;
  }
  
  public static Value makeBinary(String s, byte[] b) {
    Value v = new Value();
    v.valueString = s;
    v.valueBinary = b;
    return v;
  }

  public static Value makeComplex(Base b) {
    Value v = new Value();
    v.valueComplex = b;
    return v;
  }
  public String getValueString() {
    return valueString;
  }

  public Date getValueDate() {
    return valueDate;
  }

  public Integer getValueInt() {
    return valueInt;
  }
  
  public BigDecimal getValueDecimal() {
    return valueDecimal;
  }

  public byte[] getValueBinary() {
    return valueBinary;
  }

  public Boolean getValueBoolean() {
    return valueBoolean;
  }

  public Base getValueComplex() {
    return valueComplex;
  }

  public boolean hasValueString() {
    return valueString != null;
  }

  public boolean hasValueDate() {
    return valueDate != null;
  }

  public boolean hasValueInt() {
    return valueInt != null;
  }
  
  public boolean hasValueDecimal() {
    return valueDecimal != null;
  }

  public boolean hasValueBinary() {
    return valueBinary != null;
  }

  public boolean hasValueBoolean() {
    return valueBoolean != null;
  }

  public boolean hasValueComplex() {
    return valueComplex != null;
  }
}
