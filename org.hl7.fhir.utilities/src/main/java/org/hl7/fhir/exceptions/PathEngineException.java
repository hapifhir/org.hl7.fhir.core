package org.hl7.fhir.exceptions;

import org.hl7.fhir.utilities.SourceLocation;
import org.hl7.fhir.utilities.Utilities;

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



public class PathEngineException extends FHIRException {

  private static final long serialVersionUID = 31969342112856390L;
  private SourceLocation location;
  private String expression;
  private String id;


  public PathEngineException(String message, Throwable cause) {
    super(message, cause);
  }

  public PathEngineException(String message) {
    super(message);
  }

  public PathEngineException(String message, SourceLocation location, String expression, Throwable cause) {
    super(message+rep(location, expression), cause);
  }

  public PathEngineException(String message, SourceLocation location, String expression) {
    super(message+rep(location, expression));
  }
  
  public PathEngineException(String message, String id, Throwable cause) {
    super(message, cause);
    this.id = id;
  }

  public PathEngineException(String message, String id) {
    super(message);
    this.id = id;
  }

  public PathEngineException(String message, String id, SourceLocation location, String expression, Throwable cause) {
    super(message+rep(location, expression), cause);
    this.id = id;
  }

  public PathEngineException(String message, String id, SourceLocation location, String expression) {
    super(message+rep(location, expression));
    this.id = id;
  }

	private static String rep(SourceLocation loc, String expr) {
	  if (loc != null) {
	    if (loc.getLine() == 1) {
	      return " (@char "+loc.getColumn()+")";
	    } else { 
	      return " (@line "+loc.getLine()+" char "+loc.getColumn()+")";
	    }
	  } else if (Utilities.noString(expr)) { // can happen in some contexts...
	    return " (@~"+expr+")";
	  } else {
	    return "";
	  }
  }

  public PathEngineException(Throwable cause) {
		super(cause);
	}

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public SourceLocation getLocation() {
    return location;
  }

  public void setLocation(SourceLocation location) {
    this.location = location;
  }

  public String getId() {
    return id;
  }

}