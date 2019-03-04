package org.hl7.fhir.r5.model;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;

/**
 * This enumreation is special, and hand crafted. It only supports a subset of the actual published FHIR versions, those that are still supported.
 * @author graha
 *
 */
public enum FhirPublication {
  NULL,
  DSTU1,
  DSTU2,
  DSTU2016May,
  STU3,
  R4,
  R5;

  public static FhirPublication fromCode(String v) {
    if ("1.0.2".equals(v))
      return FhirPublication.DSTU2;
    if ("1.0".equals(v))
      return FhirPublication.DSTU2;
    if ("1.4.0".equals(v))
      return FhirPublication.DSTU2016May;
    if ("1.4".equals(v))
      return FhirPublication.DSTU2016May;
    if ("3.0.1".equals(v))
      return FhirPublication.STU3;
    if ("3.0".equals(v))
      return FhirPublication.STU3;
    if ("3.5.0".equals(v))
      return FhirPublication.R4;
    if ("4.0.0".equals(v))
      return FhirPublication.R4;
    if ("3.5".equals(v))
      return FhirPublication.R4;
    if ("4.0".equals(v))
      return FhirPublication.R4;
    if ("4.1.0".equals(v))
      return FhirPublication.R5; // hack workaround build problem
    return null;
  }

  public String toCode() {
    switch (this) {
    case DSTU1: return "0.01";
    case DSTU2: return "1.0.2";
    case DSTU2016May: return "1.4.0";
    case STU3: return "3.0.1";
    case R4: return Constants.VERSION;
    default:
      return "??";
    }
  }

  public static FhirPublication fromVersion(FHIRVersion v) {
    return fromCode(v.toCode());
  }


}
