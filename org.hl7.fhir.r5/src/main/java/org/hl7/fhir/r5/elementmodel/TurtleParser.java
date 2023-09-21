package org.hl7.fhir.r5.elementmodel;

import java.io.ByteArrayInputStream;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.utils.SnomedExpressions;
import org.hl7.fhir.r5.utils.SnomedExpressions.Expression;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.turtle.Turtle.Complex;
import org.hl7.fhir.utilities.turtle.Turtle.Section;
import org.hl7.fhir.utilities.turtle.Turtle.Subject;
import org.hl7.fhir.utilities.turtle.Turtle.TTLComplex;
import org.hl7.fhir.utilities.turtle.Turtle.TTLList;
import org.hl7.fhir.utilities.turtle.Turtle.TTLLiteral;
import org.hl7.fhir.utilities.turtle.Turtle.TTLObject;
import org.hl7.fhir.utilities.turtle.Turtle.TTLURL;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;


public class TurtleParser extends ParserBase {

  private String base;

  private OutputStyle style;

  public static String FHIR_URI_BASE = "http://hl7.org/fhir/";
  public static String FHIR_VERSION_BASE = "http://build.fhir.org/";

  public TurtleParser(IWorkerContext context) {
    super(context);
  }
  @Override
  public List<ValidatedFragment> parse(InputStream inStream) throws IOException, FHIRException {
    byte[] content = TextFile.streamToBytes(inStream);
    ValidatedFragment ctxt = new ValidatedFragment("focus", "ttl", content);
    ByteArrayInputStream stream = new ByteArrayInputStream(content);

    Turtle src = new Turtle();
    if (policy == ValidationPolicy.EVERYTHING) {
      try {
        src.parse(TextFile.streamToString(stream));
      } catch (Exception e) {  
        logError(ctxt.getErrors(), ValidationMessage.NO_RULE_DATE, -1, -1, "(document)", IssueType.INVALID, context.formatMessage(I18nConstants.ERROR_PARSING_TURTLE_, e.getMessage()), IssueSeverity.FATAL);
        return null;
      }
      ctxt.setElement(parse(ctxt.getErrors(), src));
    } else {
      src.parse(TextFile.streamToString(stream));
      ctxt.setElement(parse(ctxt.getErrors(), src));
    }
    List<ValidatedFragment> res = new ArrayList<>();
    res.add(ctxt);
    return res;
  }
  
  private Element parse(List<ValidationMessage> errors, Turtle src) throws FHIRException {
    // we actually ignore the stated URL here
    for (TTLComplex cmp : src.getObjects().values()) {
      for (String p : cmp.getPredicates().keySet()) {
        if ((FHIR_URI_BASE + "nodeRole").equals(p) && cmp.getPredicates().get(p).hasValue(FHIR_URI_BASE + "treeRoot")) {
          return parse(errors, src, cmp);
        }
      }
    }
    // still here: well, we didn't find a start point
    String msg = "Error parsing Turtle: unable to find any node maked as the entry point (where " + FHIR_URI_BASE + "nodeRole = " + FHIR_URI_BASE + "treeRoot)";
    if (policy == ValidationPolicy.EVERYTHING) {
      logError(errors, ValidationMessage.NO_RULE_DATE, -1, -1, "(document)", IssueType.INVALID, msg, IssueSeverity.FATAL);
      return null;
    } else {
      throw new FHIRFormatError(msg);
    } 
  }
  
  private Element parse(List<ValidationMessage> errors, Turtle src, TTLComplex cmp) throws FHIRException {
    TTLObject type = cmp.getPredicates().get("http://www.w3.org/2000/01/rdf-schema#type");
    if (type == null) {
      logError(errors, ValidationMessage.NO_RULE_DATE, cmp.getLine(), cmp.getCol(), "(document)", IssueType.INVALID, context.formatMessage(I18nConstants.UNKNOWN_RESOURCE_TYPE_MISSING_RDFSTYPE), IssueSeverity.FATAL);
      return null;
    }
    if (type instanceof TTLList) {
      // this is actually broken - really we have to look through the structure definitions at this point
      for (TTLObject obj : ((TTLList) type).getList()) {
        if (obj instanceof TTLURL && ((TTLURL) obj).getUri().startsWith(FHIR_URI_BASE)) {
          type = obj;
          break;
        }
      }
    }
    if (!(type instanceof TTLURL)) {
      logError(errors, ValidationMessage.NO_RULE_DATE, cmp.getLine(), cmp.getCol(), "(document)", IssueType.INVALID, context.formatMessage(I18nConstants.UNEXPECTED_DATATYPE_FOR_RDFSTYPE), IssueSeverity.FATAL);
      return null;
    }
    String name = ((TTLURL) type).getUri();
    String ns = name.substring(0, name.lastIndexOf("/"));
    name = name.substring(name.lastIndexOf("/")+1);
    String path = "/"+name;

    StructureDefinition sd = getDefinition(errors, cmp.getLine(), cmp.getCol(), ns, name);
    if (sd == null)
      return null;

    Element result = new Element(name, new Property(context, sd.getSnapshot().getElement().get(0), sd));
    result.markLocation(cmp.getLine(), cmp.getCol());
    result.setType(name);
    parseChildren(errors, src, path, cmp, result, false);
    result.numberChildren();
    return result;  
  }
  
  private void parseChildren(List<ValidationMessage> errors, Turtle src, String path, TTLComplex object, Element element, boolean primitive) throws FHIRException {

    List<Property> properties = element.getProperty().getChildProperties(element.getName(), null);
    Set<String> processed = new HashSet<String>();
    if (primitive)
      processed.add(FHIR_URI_BASE + "value");

    // note that we do not trouble ourselves to maintain the wire format order here - we don't even know what it was anyway
    // first pass: process the properties
    for (Property property : properties) {
      if (property.isChoice()) {
        for (TypeRefComponent type : property.getDefinition().getType()) {
          String eName = property.getName().substring(0, property.getName().length()-3) + Utilities.capitalize(type.getCode());
          parseChild(errors, src, object, element, processed, property, path, getFormalName(property, eName));
        }
      } else  {
        parseChild(errors, src, object, element, processed, property, path, getFormalName(property));
      } 
    }

    // second pass: check for things not processed
    if (policy != ValidationPolicy.NONE) {
      for (String u : object.getPredicates().keySet()) {
        if (!processed.contains(u)) {
          TTLObject n = object.getPredicates().get(u);
          logError(errors, ValidationMessage.NO_RULE_DATE, n.getLine(), n.getCol(), path, IssueType.STRUCTURE, context.formatMessage(I18nConstants.UNRECOGNISED_PREDICATE_, u), IssueSeverity.ERROR);
        }
      }
    }
  }
  
  private void parseChild(List<ValidationMessage> errors, Turtle src, TTLComplex object, Element context, Set<String> processed, Property property, String path, String name) throws FHIRException {
    processed.add(name);
    String npath = path+"/"+property.getName();
    TTLObject e = object.getPredicates().get(FHIR_URI_BASE + name);
    if (e == null)
      return;
    if (property.isList() && (e instanceof TTLList)) {
      TTLList arr = (TTLList) e;
      for (TTLObject am : arr.getList()) {
        parseChildInstance(errors, src, npath, object, context, property, name, am);
      }
    } else {
      parseChildInstance(errors, src, npath, object, context, property, name, e);
    }
  }

  private void parseChildInstance(List<ValidationMessage> errors, Turtle src, String npath, TTLComplex object, Element element, Property property, String name, TTLObject e) throws FHIRException {
    if (property.isResource())
      parseResource(errors, src, npath, object, element, property, name, e);
    else  if (e instanceof TTLComplex) {
      TTLComplex child = (TTLComplex) e;
      Element n = new Element(tail(name), property).markLocation(e.getLine(), e.getCol());
      element.getChildren().add(n);
      if (property.isPrimitive(property.getType(tail(name)))) {
        parseChildren(errors, src, npath, child, n, true);
        TTLObject val = child.getPredicates().get(FHIR_URI_BASE + "value");
        if (val != null) {
          if (val instanceof TTLLiteral) {
            String value = ((TTLLiteral) val).getValue();
            String type = ((TTLLiteral) val).getType();
            // todo: check type
            n.setValue(value);
          } else
            logError(errors, ValidationMessage.NO_RULE_DATE, object.getLine(), object.getCol(), npath, IssueType.INVALID, context.formatMessage(I18nConstants.THIS_PROPERTY_MUST_BE_A_LITERAL_NOT_, "a "+e.getClass().getName()), IssueSeverity.ERROR);
        }
      } else 
        parseChildren(errors, src, npath, child, n, false);

    } else 
      logError(errors, ValidationMessage.NO_RULE_DATE, object.getLine(), object.getCol(), npath, IssueType.INVALID, context.formatMessage(I18nConstants.THIS_PROPERTY_MUST_BE_A_URI_OR_BNODE_NOT_, "a "+e.getClass().getName()), IssueSeverity.ERROR);
  }


  private String tail(String name) {
    return name.substring(name.lastIndexOf(".")+1);
  }

  private void parseResource(List<ValidationMessage> errors, Turtle src, String npath, TTLComplex object, Element element, Property property, String name, TTLObject e) throws FHIRException {
    TTLComplex obj;
    if (e instanceof TTLComplex) 
      obj = (TTLComplex) e;
    else if (e instanceof TTLURL) {
      String url = ((TTLURL) e).getUri();
      obj = src.getObject(url);
      if (obj == null) {
        logError(errors, ValidationMessage.NO_RULE_DATE, e.getLine(), e.getCol(), npath, IssueType.INVALID, context.formatMessage(I18nConstants.REFERENCE_TO__CANNOT_BE_RESOLVED, url), IssueSeverity.FATAL);
        return;
      }
    } else
      throw new FHIRFormatError(context.formatMessage(I18nConstants.WRONG_TYPE_FOR_RESOURCE));
      
    TTLObject type = obj.getPredicates().get("http://www.w3.org/2000/01/rdf-schema#type");
    if (type == null) {
      logError(errors, ValidationMessage.NO_RULE_DATE, object.getLine(), object.getCol(), npath, IssueType.INVALID, context.formatMessage(I18nConstants.UNKNOWN_RESOURCE_TYPE_MISSING_RDFSTYPE), IssueSeverity.FATAL);
      return;
  }
    if (type instanceof TTLList) {
      // this is actually broken - really we have to look through the structure definitions at this point
      for (TTLObject tobj : ((TTLList) type).getList()) {
        if (tobj instanceof TTLURL && ((TTLURL) tobj).getUri().startsWith(FHIR_URI_BASE)) {
          type = tobj;
          break;
        }
      }
    }
    if (!(type instanceof TTLURL)) {
      logError(errors, ValidationMessage.NO_RULE_DATE, object.getLine(), object.getCol(), npath, IssueType.INVALID, context.formatMessage(I18nConstants.UNEXPECTED_DATATYPE_FOR_RDFSTYPE), IssueSeverity.FATAL);
      return;
    }
    String rt = ((TTLURL) type).getUri();
    String ns = rt.substring(0, rt.lastIndexOf("/"));
    rt = rt.substring(rt.lastIndexOf("/")+1);
    
    StructureDefinition sd = getDefinition(errors, object.getLine(), object.getCol(), ns, rt);
    if (sd == null)
      return;
    
    Element n = new Element(tail(name), property).markLocation(object.getLine(), object.getCol());
    element.getChildren().add(n);
    n.updateProperty(new Property(this.context, sd.getSnapshot().getElement().get(0), sd), SpecialElement.fromProperty(n.getProperty()), property);
    n.setType(rt);
    parseChildren(errors, src, npath, obj, n, false);
  }
  
  private String getFormalName(Property property) {
    String en = property.getDefinition().getBase().getPath();
    if (en == null) 
      en = property.getDefinition().getPath();
//    boolean doType = false;
//      if (en.endsWith("[x]")) {
//        en = en.substring(0, en.length()-3);
//        doType = true;        
//      }
//     if (doType || (element.getProperty().getDefinition().getType().size() > 1 && !allReference(element.getProperty().getDefinition().getType())))
//       en = en + Utilities.capitalize(element.getType());
    return en;
  }
  
  private String getFormalName(Property property, String elementName) {
    String en = property.getDefinition().getBase().getPath();
    if (en == null)
      en = property.getDefinition().getPath();
    if (!en.endsWith("[x]")) 
      throw new Error(context.formatMessage(I18nConstants.ATTEMPT_TO_REPLACE_ELEMENT_NAME_FOR_A_NONCHOICE_TYPE));
    return en.substring(0, en.lastIndexOf(".")+1)+elementName;
  }
  
  @Override
  public void compose(Element e, OutputStream stream, OutputStyle style, String base) throws IOException, FHIRException {
    this.base = base;
    this.style = style;
    
		Turtle ttl = new Turtle();
		compose(e, ttl, base);
		ttl.commit(stream, false);
  }

  public void compose(Element e, Turtle ttl, String base) throws FHIRException {
    if (e.getPath() == null) {
      e.populatePaths(null);
    }
    
    ttl.prefix("fhir", FHIR_URI_BASE);
    ttl.prefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
    ttl.prefix("owl", "http://www.w3.org/2002/07/owl#");
    ttl.prefix("xsd", "http://www.w3.org/2001/XMLSchema#");

    Section section = ttl.section("resource");
    if (style == OutputStyle.PRETTY) {
      for (String s : e.getComments()) {
        section.stringComment(s);
      }
    }
    String subjId = genSubjectId(e);

    Subject subject;
    if (hasModifierExtension(e)) 
    	subject = section.triple(subjId, "a", "fhir:_" + e.getType());
     else 
    	subject = section.triple(subjId, "a", "fhir:" + e.getType());
     
	subject.linkedPredicate("fhir:nodeRole", "fhir:treeRoot", linkResolver == null ? null : linkResolver.resolvePage("rdf.html#tree-root"), null);

	for (Element child : e.getChildren()) {
		composeElement(section, subject, child, null);
	}

  }
  
  private boolean hasModifierExtension(Element e) {
	  return e.getChildren().stream().anyMatch(p -> p.getName().equals("modifierExtension"));
  }
  
  protected String getURIType(String uri) {
    if(uri.startsWith("<" + FHIR_URI_BASE))
      if(uri.substring(FHIR_URI_BASE.length() + 1).contains("/"))
        return uri.substring(FHIR_URI_BASE.length() + 1, uri.indexOf('/', FHIR_URI_BASE.length() + 1));
    return null;
  }

  protected String getReferenceURI(String ref) {
    if (ref != null && (ref.startsWith("http://") || ref.startsWith("https://")))
      return "<" + ref + ">";
    else if (base != null && ref != null && ref.contains("/"))
      return "<" + Utilities.appendForwardSlash(base) + ref + ">";
    else
      return null;
    }

  protected void decorateReference(Complex t, Element coding) {
    String refURI = getReferenceURI(coding.getChildValue("reference"));
    if(refURI != null)
      t.linkedPredicate("fhir:link", refURI, linkResolver == null ? null : linkResolver.resolvePage("rdf.html#reference"), null);
  }
  
  protected void decorateCanonical(Complex t, Element canonical) {
    String refURI = getReferenceURI(canonical.primitiveValue());
    if(refURI != null)
      t.linkedPredicate("fhir:link", refURI, linkResolver == null ? null : linkResolver.resolvePage("rdf.html#reference"), null);
  }
  
  private String genSubjectId(Element e) {
    String id = e.getChildValue("id");
    if (base == null || id == null)
      return "";
    else if (base.endsWith("#"))
      return "<" + base + e.getType() + "-" + id + ">";
    else
      return "<" + Utilities.pathURL(base, e.getType(), id) + ">";
  }

	private String urlescape(String s) {
	  StringBuilder b = new StringBuilder();
	  for (char ch : s.toCharArray()) {
	    if (Utilities.charInSet(ch,  ':', ';', '=', ','))
	      b.append("%"+Integer.toHexString(ch));
	    else
	      b.append(ch);
	  }
	  return b.toString();
  }

  private void composeElement(Section section, Complex ctxt, Element element, Element parent) throws FHIRException {
//    "Extension".equals(element.getType())?
//            (element.getProperty().getDefinition().getIsModifier()? "modifierExtension" : "extension") ; 
   
    String en = getFormalName(element);

    if (!wantCompose(parent == null ? "" : parent.getPath(), element)) {
      return;
    }
    
    String comment = null;
    if (style == OutputStyle.PRETTY) {
      comment = String.join(", ", element.getComments());
    }
	  Complex t;
	  if (element.getSpecial() == SpecialElement.BUNDLE_ENTRY && parent != null && parent.getNamedChildValue("fullUrl") != null) {
	    String url = "<"+parent.getNamedChildValue("fullUrl")+">";
	    ctxt.linkedPredicate("fhir:"+en, url, linkResolver == null ? null : linkResolver.resolveProperty(element.getProperty()), comment, element.getProperty().isList());
	    t = section.subject(url);
	  } else {
	    t = ctxt.linkedPredicate("fhir:"+en, linkResolver == null ? null : linkResolver.resolveProperty(element.getProperty()), comment, element.getProperty().isList());
	  }
	if (element.getProperty().getName().endsWith("[x]") && !element.hasValue()) {
	  t.linkedPredicate("a", "fhir:" + element.fhirType(), linkResolver == null ? null : linkResolver.resolveType(element.fhirType()), null);
	}
    if (element.getSpecial() != null)
      t.linkedPredicate("a", "fhir:"+element.fhirType(), linkResolver == null ? null : linkResolver.resolveType(element.fhirType()), null);
	  if (element.hasValue())
	  	t.linkedPredicate("fhir:v", ttlLiteral(element.getValue(), element.getType()), linkResolver == null ? null : linkResolver.resolveType(element.getType()), null);

	  if ("Coding".equals(element.getType()))
	  	decorateCoding(t, element, section);
    if (Utilities.existsInList(element.getType(), "Reference"))
      decorateReference(t, element);
    else if (Utilities.existsInList(element.getType(), "canonical"))
      decorateCanonical(t, element);
	  		
    if("canonical".equals(element.getType())) {
      String refURI = element.primitiveValue();
      if (refURI != null) {
        String uriType = getURIType(refURI);
        if(uriType != null && !section.hasSubject(refURI))
          section.triple(refURI, "a", "fhir:" + uriType);
      }
    }

    if("Reference".equals(element.getType())) {
      String refURI = getReferenceURI(element.getChildValue("reference"));
      if (refURI != null) {
        String uriType = getURIType(refURI);
        if(uriType != null && !section.hasSubject(refURI))
          section.triple(refURI, "a", "fhir:" + uriType);
      }
    }

		for (Element child : element.getChildren()) {
      if ("xhtml".equals(child.getType())) {
        String childfn = getFormalName(child);
        t.predicate("fhir:" + childfn, ttlLiteral(child.getValue(), child.getType()));
      } else
			composeElement(section, t, child, element);
		}
	}

  private String getFormalName(Element element) {
    String en = null;
    if (element.getSpecial() == null) 
    	en = element.getProperty().getName();
    else if (element.getSpecial() == SpecialElement.BUNDLE_ENTRY)
      en = "resource";
    else if (element.getSpecial() == SpecialElement.BUNDLE_OUTCOME)
      en = "outcome";
    else if (element.getSpecial() == SpecialElement.BUNDLE_ISSUES)
      en = "issues";
    else if (element.getSpecial() == SpecialElement.PARAMETER)
      en = element.getElementProperty().getDefinition().getPath();
    else // CONTAINED
      en = "contained";

    if (en == null) 
      en = element.getProperty().getName();
    
    if (en.endsWith("[x]")) 
      en = en.substring(0, en.length()-3);
    
    if (hasModifierExtension(element))
    	return "_" + en;
    else
      return en;
  }

  static public String ttlLiteral(String value, String type) {
	  String xst = "";
	  if (type.equals("boolean"))
	    xst = "^^xsd:boolean";
    else if (type.equals("integer"))
      xst = "^^xsd:integer";
    else if (type.equals("integer64"))
      xst = "^^xsd:long";	  
    else if (type.equals("unsignedInt"))
      xst = "^^xsd:nonNegativeInteger";
    else if (type.equals("positiveInt"))
      xst = "^^xsd:positiveInteger";
    else if (type.equals("decimal"))
      xst = "^^xsd:decimal";
    else if (type.equals("base64Binary"))
      xst = "^^xsd:base64Binary";
    else if (type.equals("canonical") || type.equals("oid") || type.equals("uri") || type.equals("url") || type.equals("uuid"))
  	  xst = "^^xsd:anyURI";
    else if (type.equals("instant"))
      xst = "^^xsd:dateTime";
    else if (type.equals("time"))
      xst = "^^xsd:time";
    else if (type.equals("date") || type.equals("dateTime") ) {
      String v = value;
      if (v.length() > 10) {
        int i = value.substring(10).indexOf("-");
        if (i == -1)
          i = value.substring(10).indexOf("+");
        v = i == -1 ? value : value.substring(0,  10+i);
      }
      if (v.length() > 10)
        xst = "^^xsd:dateTime";
      else if (v.length() == 10)
        xst = "^^xsd:date";
      else if (v.length() == 7)
        xst = "^^xsd:gYearMonth";
      else if (v.length() == 4)
        xst = "^^xsd:gYear";
    }
	  
		return "\"" +Turtle.escape(value, true) + "\""+xst;
	}

  protected void decorateCoding(Complex t, Element coding, Section section) throws FHIRException {
    String system = coding.getChildValue("system");
    String code = coding.getChildValue("code");
    
    if (system == null || code == null)
      return;
    if ("http://snomed.info/sct".equals(system)) {
      t.prefix("sct", "http://snomed.info/id/");
      if (code.contains(":") || code.contains("="))
        generateLinkedPredicate(t, code);
      else
        t.linkedPredicate("a", "sct:" + urlescape(code), null, null);
    } else if ("http://loinc.org".equals(system)) {
      t.prefix("loinc", "https://loinc.org/rdf/");
      t.linkedPredicate("a", "loinc:"+urlescape(code).toUpperCase(), null, null);
    } else if ("https://www.nlm.nih.gov/mesh".equals(system)) {
    	t.prefix("mesh", "http://id.nlm.nih.gov/mesh/");
    	t.linkedPredicate("a", "mesh:"+urlescape(code), null, null);
    }  
  }

  private void generateLinkedPredicate(Complex t, String code) throws FHIRException {
    Expression expression = SnomedExpressions.parse(code);
    
  }
  public OutputStyle getStyle() {
    return style;
  }
  public void setStyle(OutputStyle style) {
    this.style = style;
  }


//    128045006|cellulitis (disorder)|:{363698007|finding site|=56459004|foot structure|}
//    Grahame Grieve: or
//
//    64572001|disease|:{116676008|associated morphology|=72704001|fracture|,363698007|finding site|=(12611008|bone structure of  tibia|:272741003|laterality|=7771000|left|)}
//    Harold Solbrig:
//    a sct:128045006,
//      rdfs:subClassOf [
//          a owl:Restriction;
//          owl:onProperty sct:609096000 ;
//          owl:someValuesFrom [
//                a owl:Restriction;
//                 owl:onProperty sct:363698007 ;
//                owl:someValuesFrom sct:56459004 ] ] ;
//    and
//
//    a sct:64572001,
//       rdfs:subclassOf  [
//           a owl:Restriction ;
//           owl:onProperty sct:60909600 ;
//           owl:someValuesFrom [ 
//                 a owl:Class ;
//                 owl:intersectionOf ( [
//                      a owl:Restriction;
//                      owl:onProperty sct:116676008;
//                     owl:someValuesFrom sct:72704001 ] 
//                 [  a owl:Restriction;
//                      owl:onProperty sct:363698007 
//                      owl:someValuesFrom [
//                            a owl:Class ;
//                            owl:intersectionOf(
//                                 sct:12611008
//                                 owl:someValuesFrom [
//                                         a owl:Restriction;
//                                         owl:onProperty sct:272741003;
//                                         owl:someValuesFrom sct:7771000
//                                  ] ) ] ] ) ] ]
//    (an approximation -- I'll have to feed it into a translator to be sure I've got it 100% right)
//
  
}