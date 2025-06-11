package org.hl7.fhir.dstu2016may.utils;

import org.hl7.fhir.dstu2016may.utils.ValueSetExpander.ETooCostly;

@Deprecated
public interface ValueSetChecker {

  boolean codeInValueSet(String system, String code) throws ETooCostly, Exception;

}