package org.hl7.fhir.r5.elementmodel;

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

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.utils.SnomedExpressions;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.turtle.Turtle.Complex;
import org.hl7.fhir.utilities.turtle.Turtle.Section;
import org.hl7.fhir.utilities.turtle.Turtle.Subject;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;


/***
 * Cross-version module derived from org.hl7.fhir.r4.elementmodel.TurtleParser
 */
@MarkedToMoveToAdjunctPackage
public class TurtleParserR4 extends TurtleParserBase {

  public TurtleParserR4(IWorkerContext context) {
    super(context);
  }

  @Override
  protected String className(String element) {
    return element;
  }

  @Override
  public void compose(Element e, Turtle ttl, String base) throws FHIRException {
    ttl.prefix("fhir", FHIR_URI_BASE);
    ttl.prefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
    ttl.prefix("owl", "http://www.w3.org/2002/07/owl#");
    ttl.prefix("xsd", "http://www.w3.org/2001/XMLSchema#");

    Section section = ttl.section("resource");
    String subjId = genSubjectId(e);

    String ontologyId = subjId.replace(">", ".ttl>");

    Subject subject = section.triple(subjId, "a", "fhir:" + e.getType());
    subject.linkedPredicate("fhir:nodeRole", "fhir:treeRoot",
        linkResolver == null ? null : linkResolver.resolvePage("rdf.html#tree-root"), null);

    for (Element child : e.getChildren()) {
      composeElement(section, subject, child, null);
    }

    Section ontology = ttl.section("ontology header");
    ontology.triple(ontologyId, "a", "owl:Ontology");
    ontology.triple(ontologyId, "owl:imports", "fhir:fhir.ttl");
    if (ontologyId.startsWith("<" + FHIR_URI_BASE)) {
      ontology.triple(ontologyId, "owl:versionIRI", ontologyId.replace(FHIR_URI_BASE, FHIR_VERSION_BASE));
    }
  }

  private String genSubjectId(Element e) {
    String id = e.getChildValue("id");
    if (base == null || id == null) {
      return "";
    } else if (base.endsWith("#")) {
      return "<" + base + e.getType() + "-" + id + ">";
    } else {
      return "<" + Utilities.pathURL(base, e.getType(), id) + ">";
    }
  }

  @Override
  protected String getURIType(String uri) {
    if (uri.startsWith("<" + FHIR_URI_BASE)) {
      if (uri.substring(FHIR_URI_BASE.length() + 1).contains("/")) {
        return uri.substring(FHIR_URI_BASE.length() + 1, uri.indexOf('/', FHIR_URI_BASE.length() + 1));
      }
    }
    return null;
  }

  @Override
  protected String getReferenceURI(String ref) {
    if (ref != null && (ref.startsWith("http://") || ref.startsWith("https://"))) {
      return "<" + ref + ">";
    } else if (base != null && ref != null && ref.contains("/")) {
      return "<" + Utilities.appendForwardSlash(base) + ref + ">";
    } else {
      return null;
    }
  }

  @Override
  protected void decorateReference(Complex t, Element coding) {
    String refURI = getReferenceURI(coding.getChildValue("reference"));
    if (refURI != null) {
      t.linkedPredicate("fhir:link", refURI,
          linkResolver == null ? null : linkResolver.resolvePage("rdf.html#reference"), null);
    }
  }

  protected void decorateCanonical(Complex t, Element canonical) {
    String refURI = getReferenceURI(canonical.primitiveValue());
    if (refURI != null) {
      t.linkedPredicate("fhir:link", refURI,
          linkResolver == null ? null : linkResolver.resolvePage("rdf.html#reference"), null);
    }
  }

  private void composeElement(Section section, Complex ctxt, Element element, Element parent) throws FHIRException {
    String en = getFormalName(element);

    Complex t;
    if (element.getSpecial() == SpecialElement.BUNDLE_ENTRY && parent != null
        && parent.getNamedChildValue("fullUrl") != null) {
      String url = "<" + parent.getNamedChildValue("fullUrl") + ">";
      ctxt.linkedPredicate("fhir:" + en, url,
          linkResolver == null ? null : linkResolver.resolveProperty(element.getProperty()), null);
      t = section.subject(url);
    } else {
      t = ctxt.linkedPredicate("fhir:" + en,
          linkResolver == null ? null : linkResolver.resolveProperty(element.getProperty()), null);
    }
    if (element.getSpecial() != null) {
      t.linkedPredicate("a", "fhir:" + element.fhirType(),
          linkResolver == null ? null : linkResolver.resolveType(element.fhirType()), null);
    }
    if (element.hasValue()) {
      t.linkedPredicate("fhir:value", ttlLiteral(element.getValue(), element.getType()),
          linkResolver == null ? null : linkResolver.resolveType(element.getType()), null);
    }
    if (element.getProperty().isList() && (!element.isResource() || element.getSpecial() == SpecialElement.CONTAINED)) {
      t.linkedPredicate("fhir:index", Integer.toString(element.getIndex()),
          linkResolver == null ? null : linkResolver.resolvePage("rdf.html#index"), null);
    }

    if ("Coding".equals(element.getType())) {
      decorateCoding(t, element, section);
    }
    if (Utilities.existsInList(element.getType(), "Reference")) {
      decorateReference(t, element);
    } else if (Utilities.existsInList(element.getType(), "canonical")) {
      decorateCanonical(t, element);
    }

    if ("canonical".equals(element.getType())) {
      String refURI = element.primitiveValue();
      if (refURI != null) {
        String uriType = getURIType(refURI);
        if (uriType != null && !section.hasSubject(refURI)) {
          section.triple(refURI, "a", "fhir:" + uriType);
        }
      }
    }

    if ("Reference".equals(element.getType())) {
      String refURI = getReferenceURI(element.getChildValue("reference"));
      if (refURI != null) {
        String uriType = getURIType(refURI);
        if (uriType != null && !section.hasSubject(refURI)) {
          section.triple(refURI, "a", "fhir:" + uriType);
        }
      }
    }

    for (Element child : element.getChildren()) {
      if ("xhtml".equals(child.getType())) {
        String childfn = getFormalName(child);
        String childValue = new XhtmlComposer(XhtmlComposer.XML, false).setCanonical(true).compose(child.getXhtml());
        t.predicate("fhir:" + childfn, ttlLiteral(childValue, child.getType()));
      } else {
        composeElement(section, t, child, element);
      }
    }
  }

  private String getFormalName(Element element) {
    String en = null;
    if (element.getSpecial() == null) {
      if (element.getProperty().getDefinition().hasBase()) {
        en = element.getProperty().getDefinition().getBase().getPath();
      }
    } else if (element.getSpecial() == SpecialElement.BUNDLE_ENTRY) {
      en = "Bundle.entry.resource";
    } else if (element.getSpecial() == SpecialElement.BUNDLE_OUTCOME) {
      en = "Bundle.entry.response.outcome";
    } else if (element.getSpecial() == SpecialElement.PARAMETER) {
      en = element.getElementProperty().getDefinition().getPath();
    } else { // CONTAINED
      en = "DomainResource.contained";
    }

    if (en == null) {
      en = element.getProperty().getDefinition().getPath();
    }
    boolean doType = false;
    if (en.endsWith("[x]")) {
      en = en.substring(0, en.length() - 3);
      doType = true;
    }
    if (doType || (element.getProperty().getDefinition().getType().size() > 1
        && !allReference(element.getProperty().getDefinition().getType()))) {
      en = en + Utilities.capitalize(element.getType());
    }
    return en;
  }

  private boolean allReference(List<TypeRefComponent> types) {
    for (TypeRefComponent t : types) {
      if (!t.getCode().equals("Reference")) {
        return false;
      }
    }
    return true;
  }

  public static String ttlLiteral(String value, String type) {
    String xst = "";
    if (type.equals("boolean")) {
      xst = "^^xsd:boolean";
    } else if (type.equals("integer")) {
      xst = "^^xsd:integer";
    } else if (type.equals("unsignedInt")) {
      xst = "^^xsd:nonNegativeInteger";
    } else if (type.equals("positiveInt")) {
      xst = "^^xsd:positiveInteger";
    } else if (type.equals("decimal")) {
      xst = "^^xsd:decimal";
    } else if (type.equals("base64Binary")) {
      xst = "^^xsd:base64Binary";
    } else if (type.equals("instant")) {
      xst = "^^xsd:dateTime";
    } else if (type.equals("time")) {
      xst = "^^xsd:time";
    } else if (type.equals("date") || type.equals("dateTime")) {
      String v = value;
      if (v.length() > 10) {
        int i = value.substring(10).indexOf("-");
        if (i == -1) {
          i = value.substring(10).indexOf("+");
        }
        v = i == -1 ? value : value.substring(0, 10 + i);
      }
      if (v.length() > 10) {
        xst = "^^xsd:dateTime";
      } else if (v.length() == 10) {
        xst = "^^xsd:date";
      } else if (v.length() == 7) {
        xst = "^^xsd:gYearMonth";
      } else if (v.length() == 4) {
        xst = "^^xsd:gYear";
      }
    }

    return "\"" + Turtle.escape(value, true) + "\"" + xst;
  }

  @Override
  protected void decorateCoding(Complex t, Element coding, Section section) throws FHIRException {
    String system = coding.getChildValue("system");
    String code = coding.getChildValue("code");

    if (system == null || code == null) {
      return;
    }
    if ("http://snomed.info/sct".equals(system)) {
      t.prefix("sct", "http://snomed.info/id/");
      if (code.contains(":") || code.contains("=")) {
        generateLinkedPredicate(t, code);
      } else {
        t.linkedPredicate("a", "sct:" + urlescape(code), null, null);
      }
    } else if ("http://loinc.org".equals(system)) {
      t.prefix("loinc", "http://loinc.org/rdf#");
      t.linkedPredicate("a", "loinc:" + urlescape(code).toUpperCase(), null, null);
    }
  }

  private void generateLinkedPredicate(Complex t, String code) throws FHIRException {
    SnomedExpressions.parse(code);
  }
}