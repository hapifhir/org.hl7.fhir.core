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

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.instance.model.api.INarrative;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public abstract class BaseNarrative extends Type implements INarrative {

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
