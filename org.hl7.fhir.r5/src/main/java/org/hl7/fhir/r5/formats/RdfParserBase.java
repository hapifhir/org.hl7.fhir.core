package org.hl7.fhir.r5.formats;

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



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.utils.formats.Turtle;
import org.hl7.fhir.r5.utils.formats.Turtle.Complex;
import org.hl7.fhir.r5.utils.formats.Turtle.Section;
import org.hl7.fhir.r5.utils.formats.Turtle.Subject;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public abstract class RdfParserBase extends ParserBase implements IParser  {

	protected abstract void composeResource(Complex complex, Resource resource) throws IOException;

	@Override
	public ParserType getType() {
		return ParserType.RDF_TURTLE;
	}

	@Override
	public Resource parse(InputStream input) throws IOException, FHIRFormatError {
		throw new Error("Parsing not implemented yet");
	}

  @Override
  public DataType parseType(InputStream input, String knownType) throws IOException, FHIRFormatError {
    throw new Error("Parsing not implemented yet");
  }

  @Override
  public DataType parseAnyType(InputStream input, String knownType) throws IOException, FHIRFormatError {
    throw new Error("Parsing not implemented yet");
  }

	private String url;

	@Override
	public void compose(OutputStream stream, Resource resource) throws IOException {
	  Turtle ttl = new Turtle();
		//      ttl.setFormat(FFormat);
		ttl.prefix("fhir", "http://hl7.org/fhir/");
		ttl.prefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
		Section section = ttl.section("resource");
		Subject subject;
		if (url != null) 
			subject = section.triple("<"+url+">", "a", "fhir:"+resource.getResourceType().toString());
		else
			subject = section.triple("[]", "a", "fhir:"+resource.getResourceType().toString());

		composeResource(subject, resource);
		try {
			ttl.commit(stream, false);
		} catch (Exception e) {
			throw new IOException(e); 
		}
	}

  protected void composeBase(Complex t, String parentType, String name, Base element, int index) {
  }

	@Override
	public void compose(OutputStream stream, DataType type, String rootName) throws IOException {
		throw new Error("Not supported in RDF");  
	}

	protected String ttlLiteral(String value) {
		return "\"" +Turtle.escape(value, true) + "\"";
	}

	protected void composeXhtmlNode(Complex t, String string, String string2, XhtmlNode div, int i) {
	}

	protected void decorateCode(Complex t, Enumeration<? extends Enum> value) {
	}

	protected void decorateCode(Complex t, CodeType value) {
	}

	protected void decorateCoding(Complex t, Coding element) {
		if (!element.hasSystem())
			return;
		if ("http://snomed.info/sct".equals(element.getSystem())) {
			t.prefix("sct", "http://snomed.info/sct/");
			t.predicate("a", "sct:"+element.getCode());
		} else if ("http://snomed.info/sct".equals(element.getSystem())) {
			t.prefix("loinc", "http://loinc.org/rdf#");
			t.predicate("a", "loinc:"+element.getCode());
		}  
	}

	protected void decorateCodeableConcept(Complex t, CodeableConcept element) {
		for (Coding c : element.getCoding())
			decorateCoding(t, c);
	}


}