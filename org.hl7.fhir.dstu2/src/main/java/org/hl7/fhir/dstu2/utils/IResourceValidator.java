package org.hl7.fhir.dstu2.utils;

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



import java.util.List;

import org.hl7.fhir.dstu2.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonObject;

public interface IResourceValidator {

  /**
   * whether the validator should enforce best practice guidelines
   * as defined by various HL7 committees 
   *  
   *  
   * @author Grahame Grieve
   *
   */
  public enum BestPracticeWarningLevel {
    Ignore,
    Hint,
    Warning,
    Error
  }

  public enum CheckDisplayOption {
    Ignore,
    Check,
    CheckCaseAndSpace,
    CheckCase,
    CheckSpace
  }

  /**
   * how much to check displays for coded elements 
   * @return
   */
  CheckDisplayOption getCheckDisplay();

  /**
   * how much to check displays for coded elements 
   * @return
   */
  void setCheckDisplay(CheckDisplayOption checkDisplay);

	enum IdStatus {
		OPTIONAL, REQUIRED, PROHIBITED
	}
	
  /**
   * whether the resource must have an id or not (depends on context)
   * 
   * @return
   */

	IdStatus getResourceIdRule();
	void setResourceIdRule(IdStatus resourceIdRule);
  
  BestPracticeWarningLevel getBasePracticeWarningLevel();
  void setBestPracticeWarningLevel(BestPracticeWarningLevel value);
  
  
  /**
   * Given a DOM element, return a list of errors in the resource
   * 
   * @param errors
   * @param elem
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, Element element) throws Exception;

  /**
   * Given a JSON Object, return a list of errors in the resource
   * 
   * @param errors
   * @param elem
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, JsonObject object) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource
   * 
   * @param errors
   * @param elem
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  List<ValidationMessage> validate(Element element) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource
   * 
   * @param errors
   * @param elem
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  List<ValidationMessage> validate(JsonObject object) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile (by logical identifier)
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails, or the profile can't be found (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, Element element, String profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile (by logical identifier)
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails, or the profile can't be found (not if the resource is invalid)
   */
	List<ValidationMessage> validate(Element element, String profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile (by logical identifier)
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails, or the profile can't be found (not if the resource is invalid)
   */
  List<ValidationMessage> validate(JsonObject object, StructureDefinition profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile (by logical identifier)
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails, or the profile can't be found (not if the resource is invalid)
   */
  List<ValidationMessage> validate(JsonObject object, String profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile 
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, Element element, StructureDefinition profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile 
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, JsonObject object, StructureDefinition profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile 
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, JsonObject object, String profile) throws Exception;

  /**
   * Given a DOM element, return a list of errors in the resource 
   * with regard to the specified profile
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  List<ValidationMessage> validate(Element element, StructureDefinition profile) throws Exception;


  /**
   * Given a DOM document, return a list of errors in the resource
   * 
   * @param errors
   * @param elem
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, Document document) throws Exception;

  /**
   * Given a DOM document, return a list of errors in the resource
   * 
   * @param errors
   * @param elem
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  List<ValidationMessage> validate(Document document) throws Exception;

  /**
   * Given a DOM document, return a list of errors in the resource 
   * with regard to the specified profile (by logical identifier)
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails, or the profile can't be found (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, Document document, String profile) throws Exception;

  /**
   * Given a DOM document, return a list of errors in the resource 
   * with regard to the specified profile (by logical identifier)
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails, or the profile can't be found (not if the resource is invalid)
   */
	List<ValidationMessage> validate(Document document, String profile) throws Exception;

  /**
   * Given a DOM document, return a list of errors in the resource 
   * with regard to the specified profile 
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  void validate(List<ValidationMessage> errors, Document document, StructureDefinition profile) throws Exception;

  /**
   * Given a DOM document, return a list of errors in the resource 
   * with regard to the specified profile
   *  
   * @param errors
   * @param element
   * @param profile
   * @- if the underlying infrastructure fails (not if the resource is invalid)
   */
  List<ValidationMessage> validate(Document document, StructureDefinition profile) throws Exception;

}