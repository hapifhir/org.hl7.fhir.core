package org.hl7.fhir.r4b.model;

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


import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.instance.model.api.INarrative;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public abstract class BaseNarrative extends DataType implements INarrative {

	/**
	 * Sets the value of
	 *
	 * @param theString
	 * @throws Exception
	 */
	public void setDivAsString(String theString) {
		XhtmlNode div;
		if (StringUtils.isNotBlank(theString)) {
			div = new XhtmlNode(NodeType.Element, "div");
			div.setValueAsString(theString);
		} else {
			div = null;
		}
		setDiv(div);
	}

	protected abstract BaseNarrative setDiv(XhtmlNode theDiv);

	public String getDivAsString() {
		XhtmlNode div = getDiv();
		if (div != null && !div.isEmpty()) {
			return div.getValueAsString();
		} else {
			return null;
		}
	}

	protected abstract XhtmlNode getDiv();

   public abstract Enumeration<?> getStatusElement();

	public INarrative setStatusAsString(String theString) {
		getStatusElement().setValueAsString(theString);
		return this;
	}

	public String getStatusAsString() {
		return getStatusElement().getValueAsString();
	} 

}