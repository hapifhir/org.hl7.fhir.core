package org.hl7.fhir.core.generator.codegen;
/*
Copyright (c) 2011+, HL7, Inc
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
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.core.generator.analysis.Analysis;
import org.hl7.fhir.core.generator.analysis.EnumInfo;
import org.hl7.fhir.core.generator.analysis.TypeInfo;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

public class JavaParserXmlGenerator extends JavaBaseGenerator {

  private StringBuilder parser = new StringBuilder();
  private StringBuilder pRes = new StringBuilder();
  private StringBuilder pTP = new StringBuilder();
  private StringBuilder pT = new StringBuilder();
  private StringBuilder pFrag = new StringBuilder();
  private StringBuilder pCtype   = new StringBuilder();
  private StringBuilder composer = new StringBuilder();
  private StringBuilder cRes = new StringBuilder();
  private StringBuilder cRN = new StringBuilder();
  private StringBuilder cType = new StringBuilder();

  public JavaParserXmlGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate);
  }

  public void seeClass(Analysis analysis) throws Exception {
    generateParser(analysis);
    generateComposer(analysis);
    if (!analysis.isAbstract()) {
      pFrag.append( "    } else if (type.equals(\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getClassName()+"(xpp);\r\n");
      pCtype.append("    } else if (xpp.getName().equals(prefix+\""+analysis.getName()+"\")) {\r\n      return true;\r\n");
      if (analysis.getStructure().getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        pTP.append(   "    } else if (xpp.getName().equals(prefix+\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getClassName()+"(xpp);\r\n");
        pT.append(    "    } else if (type.equals(\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getClassName()+"(xpp);\r\n");
        cType.append( "    } else if (type instanceof "+analysis.getClassName()+") {\r\n       compose"+analysis.getClassName()+"(prefix+\""+analysis.getName()+"\", ("+analysis.getClassName()+") type);\r\n");
      }
      if (analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE) {
        pRes.append("    } else if (xpp.getName().equals(\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getClassName()+"(xpp);\r\n");
        cRes.append("    } else if (resource instanceof "+analysis.getClassName()+") {\r\n      compose"+analysis.getClassName()+"(\""+analysis.getName()+"\", ("+analysis.getClassName()+")resource);\r\n");
        cRN.append( "    } else if (resource instanceof "+analysis.getClassName()+") {\r\n      compose"+analysis.getClassName()+"(name, ("+analysis.getClassName()+")resource);\r\n");
      }
    }
  }

  public void generate() throws Exception {
    
    String template = config.getAdornments().get("XmlParser");
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{parser}}", parser.toString());
    template = template.replace("{{parse-resource}}", pRes.toString());
    template = template.replace("{{parse-type-prefix}}", pTP.toString());
    template = template.replace("{{parse-type}}", pT.toString());
    template = template.replace("{{parse-fragment}}", pFrag.toString());
    template = template.replace("{{check-type}}", pCtype.toString());
    
    template = template.replace("{{composer}}", composer.toString());
    template = template.replace("{{compose-resource}}", cRes.toString());
    template = template.replace("{{compose-resource-name}}", cRN.toString());
    template = template.replace("{{compose-type}}", cType.toString());

    write(template);
    flush();
    close();
  }
  
  private void generateParser(Analysis analysis) throws Exception {
    if (analysis.isAbstract()) {
      genInnerAbstract(analysis, analysis.getRootType());
    } else {
      genInner(analysis, analysis.getRootType());
    }
    
    for (TypeInfo ti : analysis.getTypeList()) {
      genInner(analysis, ti);
    }

  }

  private void genInner(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();
    String stn = (ti == analysis.getRootType() ? tn : analysis.getClassName()+"."+tn);
    String pfx = (ti.getDefn().isInlineType()) && !tn.startsWith(analysis.getClassName()) ? analysis.getClassName() : "";

    if (!analysis.isAbstract() || ti != analysis.getRootType()) {
      parser.append("  protected "+stn+" parse"+pfx+tn+"(XmlPullParser xpp) throws XmlPullParserException, IOException, FHIRFormatError {\r\n");
      parser.append("    "+stn+" res = new "+stn+"();\r\n");
      if (ti == analysis.getRootType() && analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE) {
        parser.append("    parseResourceAttributes(xpp, res);\r\n");
      } else {
        parser.append("    parseElementAttributes(xpp, res);\r\n");
      }
      for (ElementDefinition ed : ti.getChildren()) {
        if (ed.hasRepresentation(PropertyRepresentation.XMLATTR)) {
          parser.append("    if (xpp.getAttributeValue(null, \""+ed.getName()+"\") != null)\r\n");
          parser.append("        res.set"+upFirst(getElementName(ed.getName(), true))+"(xpp.getAttributeValue(null, \""+ed.getName()+"\"));\r\n");        
        }
      }    
      parser.append("    next(xpp);\r\n");
      parser.append("    int eventType = nextNoWhitespace(xpp);\r\n");
      parser.append("    while (eventType != XmlPullParser.END_TAG) {\r\n");
      parser.append("    if (!parse"+pfx+tn+"Content(eventType, xpp, res))\r\n");
      parser.append("        unknownContent(xpp);\r\n");
      parser.append("      eventType = nextNoWhitespace(xpp);\r\n");
      parser.append("    }\r\n");
      parser.append("    next(xpp);\r\n");
      parser.append("    parseElementClose(res);\r\n");
      parser.append("    return res;\r\n");
      parser.append("  }\r\n\r\n");    
    }
    parser.append("  protected boolean parse"+pfx+tn+"Content(int eventType, XmlPullParser xpp, "+stn+" res) throws XmlPullParserException, IOException, FHIRFormatError {\r\n");
    boolean first = true;
    for (ElementDefinition ed : ti.getChildren()) {
      if (!ed.hasRepresentation(PropertyRepresentation.XMLATTR)) {
        genElement(analysis, ti, ed, matchingInheritedElement(ti.getInheritedChildren(), ed), first);
        first = false;
      }
    }
    if (!first)
      parser.append("    } else ");
    else
      parser.append("    ");
    parser.append("if (!parse"+ti.getAncestorName()+"Content(eventType, xpp, res)){ \r\n");
    parser.append("      return false;\r\n");
    parser.append("    }\r\n");
    parser.append("    return true;\r\n");
    parser.append("  }\r\n\r\n");
  }

  private void genInnerAbstract(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();
    parser.append("  protected boolean parse"+upFirst(tn).replace(".", "")+"Content(int eventType, XmlPullParser xpp, "+tn+" res) throws XmlPullParserException, IOException, FHIRFormatError {\r\n");
    boolean first = true;
    if (!analysis.isInterface()) {
      for (ElementDefinition ed : ti.getChildren()) {
        if (!ed.hasRepresentation(PropertyRepresentation.XMLATTR)) {
          genElement(analysis, ti, ed, null, first);
          first = false;
        }
      }
    }
    if (!first)
      parser.append("    } else ");
    else
      parser.append("    ");
    parser.append("if (!parse"+ti.getAncestorName()+"Content(eventType, xpp, res)){ \r\n");
    parser.append("        return false;\r\n");
    parser.append("    }\r\n");
    parser.append("    return true;\r\n");
    parser.append("  }\r\n\r\n");
  }

  private void genElement(Analysis analysis, TypeInfo ti, ElementDefinition ed, ElementDefinition inh, boolean first) throws Exception {
    String name = ed.getName();
    if (name.endsWith("[x]") || name.equals("[type]")) {
      String en = name.endsWith("[x]") && !name.equals("[x]") ? name.replace("[x]", "") : "value";
      String pfx = name.endsWith("[x]") && !name.equals("[x]") ? name.replace("[x]", "") : "";
      parser.append("    "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, \""+pfx+"\")) {\r\n");
      parser.append("      res.set"+upFirst(getElementName(en, false))+"(parseType(\""+en+"\", xpp));\r\n");
    } else {
      String prsr = null;
      if (ed.hasUserData("java.enum")) {
        EnumInfo ei = (EnumInfo) ed.getUserData("java.enum"); // getCodeListType(cd.getBinding());
        ValueSet vs = ei.getValueSet();
        boolean enShared = vs.hasUserData("shared");
        String en;
        if (enShared) {
          en = "Enumerations."+ei.getName();
        } else {
          en = analysis.getClassName()+"."+ei.getName();
        }
        prsr = "parseEnumeration(xpp, "+en+".NULL, new "+en.substring(0, en.indexOf("."))+"."+en.substring(en.indexOf(".")+1)+"EnumFactory())"; // en+".fromCode(parseString(xpp))";
        // parseEnumeration(xpp, Narrative.NarrativeStatus.additional, new Narrative.NarrativeStatusEnumFactory())
      } else {   
        String tn = ed.getUserString("java.type");
        if (name.equals("extension")) {
          name = "extension";
          tn = "Extension";
        }
        if (tn.contains("Reference("))
          prsr = "parseReference(xpp)";
        else if (tn.contains("canonical("))
          prsr = "parseCanonical(xpp)";
        else if (tn.contains("("))
          prsr = "parse"+tn+"(xpp)";
        else if (tn.startsWith(analysis.getName()) && !tn.equals(analysis.getClassName())/* && !definitions.hasType(tn)*/) {
          prsr = "parse"+upFirst(tn)+"(xpp)";
        } else if (tn.equals("Resource") || tn.equals("DomainResource"))
          prsr = "parse"+upFirst(tn)+"Contained(xpp)";
        else if (isPrimitive(ed)) {
          prsr = "parse"+upFirst(tn.substring(0, tn.length()-4))+"(xpp)";            
        } else if ((ed.hasContentReference() || ed.isInlineType()) && !tn.startsWith(analysis.getClassName()) ) {
          prsr = "parse"+analysis.getClassName()+upFirst(tn)+"(xpp)";
        } else {
          prsr = "parse"+upFirst(tn)+"(xpp)";
        }
      }
      if (ed.unbounded()) {
        parser.append("    "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+name+"\")) {\r\n");
        parser.append("      res.get"+upFirst(getElementName(name, false))+"().add("+prsr+");\r\n");
      } else if (inh != null && inh.unbounded()) {
        parser.append("    "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+name+"\")) {\r\n");
        parser.append("      res.add"+upFirst(getElementName(name, false))+(!ed.typeSummary().equals("xhtml") && (isPrimitive(ed) || ed.typeSummary().startsWith("canonical(")) ? "Element" : "")+"("+prsr+");\r\n");
      } else {
        parser.append("    "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+name+"\")) {\r\n");
        parser.append("      res.set"+upFirst(getElementName(name, false))+(!ed.typeSummary().equals("xhtml") && (isPrimitive(ed) || ed.typeSummary().startsWith("canonical(")) ? "Element" : "")+"("+prsr+");\r\n");
      }
    }
  }

  private boolean isPrimitive(ElementDefinition e) {
    return definitions.hasPrimitiveType(e.typeSummary());
  }

  private void generateComposer(Analysis analysis) throws Exception {
    if (analysis.isAbstract()) {
      genInnerAbstractComposer(analysis, analysis.getRootType());
    } else {
      genInnerComposer(analysis, analysis.getRootType());
    }
    
    for (TypeInfo ti : analysis.getTypeList()) {
      genInnerComposer(analysis, ti);
    }

  }

  private void genInnerComposer(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();
    String stn = (ti == analysis.getRootType() ? tn : analysis.getClassName()+"."+tn);
    String pfx = (ti.getDefn().isInlineType()) && !tn.startsWith(analysis.getClassName()) ? analysis.getClassName() : "";
    
    composer.append("  protected void compose"+pfx+tn+"(String name, "+stn+" element) throws IOException {\r\n");
    composer.append("    if (element != null) {\r\n");
    if (ti == analysis.getRootType() && analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE) {
      composer.append("    composeResourceAttributes(element);\r\n");
    } else {
      composer.append("    composeElementAttributes(element);\r\n");
    }
    for (ElementDefinition ed : ti.getChildren()) {
      if (ed.hasRepresentation(PropertyRepresentation.XMLATTR)) {
        composer.append("      if (element.has"+upFirst(getElementName(ed.getName(), true))+"Element())\r\n");
        composer.append("        xml.attribute(\""+ed.getName()+"\", element.get"+upFirst(getElementName(ed.getName(), true))+"Element().getValue());\r\n");
      }
    }
    
    composer.append("      xml.enter(FHIR_NS, name);\r\n");
    composer.append("      compose"+pfx+tn+"Elements(element);\r\n");
    composer.append("      composeElementClose(element);\r\n");
    composer.append("      xml.exit(FHIR_NS, name);\r\n");
    composer.append("    }\r\n");    
    composer.append("  }\r\n\r\n");    

    composer.append("  protected void compose"+pfx+tn+"Elements("+stn+" element) throws IOException {\r\n");
    composer.append("    compose"+ti.getAncestorName()+"Elements(element);\r\n");
    
    for (ElementDefinition ed : ti.getChildren()) {
      if (!ed.hasRepresentation(PropertyRepresentation.XMLATTR)) {
        genElementCompose(analysis, ti, ed, matchingInheritedElement(ti.getInheritedChildren(),  ed));
      }
    }
    composer.append("  }\r\n\r\n");    
  }

  private void genInnerAbstractComposer(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();
    
    composer.append("  protected void compose"+tn+"Elements("+tn+" element) throws IOException {\r\n");
    composer.append("    compose"+ti.getAncestorName()+"Elements(element);\r\n");

    if (!analysis.isInterface()) {
      for (ElementDefinition ed : ti.getChildren()) {
        if (!ed.hasRepresentation(PropertyRepresentation.XMLATTR)) {
          genElementCompose(analysis, ti, ed, null);
        }
      }
    }
    composer.append("  }\r\n\r\n");    
  }

  private void genElementCompose(Analysis analysis, TypeInfo ti, ElementDefinition ed, ElementDefinition inh) throws Exception {
    String name = ed.getName();
    if (name.endsWith("[x]") || name.equals("[type]")) {
      String en = name.endsWith("[x]") && !name.equals("[x]") ? name.replace("[x]", "") : "value";
      String pfx = name.endsWith("[x]") ? name.replace("[x]", "") : "";
      composer.append("    if (element.has"+upFirst(getElementName(en, false))+"()) {\r\n");
      composer.append("      composeType(\""+pfx+"\", element.get"+upFirst(getElementName(en, false))+"());\r\n");
      composer.append("    }");
    } else {
      String comp = null;
      String en = null;
      String tn = ed.getUserString("java.type");
      if (ed.hasUserData("java.enum")) {
        EnumInfo ei = (EnumInfo) ed.getUserData("java.enum");
        ValueSet vs = ei.getValueSet();
        boolean enShared = vs.hasUserData("shared");
        if (enShared) {
          en = "Enumerations."+ei.getName();
        } else {
          en = analysis.getClassName()+"."+ei.getName();
        }
      } else {   
        if (name.equals("extension")) {
          name = "extension";
          tn = "Extension";
        }
        if (tn.equals("XhtmlNode")) {
          tn = "xhtml";
          comp = "composeXhtml";
        } else if (isPrimitive(ed)) {
          comp = "compose"+tn.substring(0, tn.length()-4);
        } else if (tn.contains("Reference(")) {
          comp = "composeReference";
          tn = "Reference";
        } else if (tn.contains("canonical(")) {
          comp = "composeCanonical";
          tn = "CanonicalType";
        } else if (tn.contains("(")) {
          comp = "compose"+tn;
        } else if ((ed.hasContentReference() || ed.isInlineType()) && !tn.startsWith(analysis.getClassName()) ) {
          comp = "compose"+analysis.getClassName()+tn;
        } else {
          comp = "compose"+tn;
        }
      }
      
      if (ed.unbounded()) {
        if (en != null) {
          composer.append("      if (element.has"+upFirst(getElementName(name, false))+"()) \r\n");
          composer.append("        for (Enumeration<"+en+"> e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
          composer.append("          composeEnumeration(\""+name+"\", e, new "+en+"EnumFactory());\r\n");
        } else {
          String stn = ed.isInlineType() || ed.hasContentReference() ? analysis.getClassName()+"."+tn : tn;
//          String pfx = ed.isInlineType() || ed.hasContentReference() ? analysis.getClassName() : "";

          composer.append("    if (element.has"+upFirst(getElementName(name, false))+"()) { \r\n");
          composer.append("      for ("+stn+" e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
          if (ed.typeSummary().equals("Resource")) { 
            composer.append("        {\r\n");
            composer.append("          xml.enter(FHIR_NS, \""+name+"\");\r\n");
            composer.append("          "+comp+"(e);\r\n");
            composer.append("          xml.exit(FHIR_NS, \""+name+"\");\r\n");
            composer.append("        }\r\n");            
          } else {
            composer.append("          "+comp+"(\""+name+"\", e);\r\n");
          }
          composer.append("    }\r\n");
        }
      } else if (en != null) {
        composer.append("    if (element.has"+upFirst(getElementName(name, false))+"Element())\r\n"); 
        composer.append("      composeEnumeration(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), new "+en+"EnumFactory());\r\n");
      } else if (!"xhtml".equals(ed.typeSummary()) && (isJavaPrimitive(ed) || ed.typeSummary().startsWith("canonical("))) {
        composer.append("    if (element.has"+upFirst(getElementName(name, false))+"Element()) {\r\n");
        composer.append("      "+comp+"(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element());\r\n");
        composer.append("    }\r\n");
      } else if (ed.typeSummary().equals("Resource")) {
        composer.append("    if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("      xml.enter(FHIR_NS, \""+name+"\");\r\n");
        composer.append("      "+comp+"(element.get"+upFirst(getElementName(name, false))+"());\r\n");
        composer.append("      xml.exit(FHIR_NS, \""+name+"\");\r\n");
        composer.append("    }\r\n");
      } else if (inh != null && inh.unbounded()) {
        composer.append("    if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("      "+comp+"(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"FirstRep());\r\n");
        composer.append("    }\r\n");
      } else {
        composer.append("    if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("      "+comp+"(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"());\r\n");
        composer.append("    }\r\n");
      }
    }
  }
//
//  private boolean isPrimitive(ElementDefn e) {
//    return definitions.hasPrimitiveType(e.typeCode());
//  }
//
//
//  private String prepEnumName(String en) {
//  String[] parts = en.split("\\.");
//  if (parts.length == 1)
//    return upFirst(parts[0]);
//  else
//    return upFirst(parts[0])+'.'+upFirst(parts[1]);
//}
//
//
//  private String leaf(String tn) {
//    return tn.startsWith("java.lang.") ? tn.substring(10) : tn;
//  }
//
//  private String PrepGenericTypeName(String tn) {
//    int i = tn.indexOf('(');
//    return tn.substring(0, i)+"<"+upFirst(tn.substring(i+1).replace(")", ">"));
//  }
//
//  private String typeName(ElementDefn root, ElementDefn elem, JavaGenClass type, boolean formal) {
//    String t = elem.typeCode();
//    if ((type == JavaGenClass.Type || type == JavaGenClass.Constraint) && definitions.getPrimitives().containsKey(t)) {
////      if (t.equals("boolean"))
////        return "java.lang.Boolean";
////      else if (t.equals("integer"))
////        return "Integer";
////      else if (t.equals("decimal"))
////        return "Decimal";
////      else if (t.equals("base64Binary"))
////        return "Base64Binary";
////      else if (t.equals("instant"))
////        return "Instant";
////      else if (t.equals("uri"))
////        return "Uri";
////      else 
////        return "String";
////      else if (t.equals("string"))
////        return "StringType";
////      else
//        return upFirst(t);
//    } else if (elem.usesCompositeType()) { 
//      if (typeNames.containsKey(elem) && typeNames.get(elem) != null)
//        return typeNames.get(elem);
//      else  
//        return root.getName();      
//    } else if (elem.getTypes().size() == 0) {
//        return typeNames.get(elem);
//    } else if (typeNames.containsKey(elem))
//      return typeNames.get(elem);
//    else
//      return upFirst(t);
//  }
//  
//  private void finishComposer() throws Exception {
//    composer.append("  @Override\r\n");
//    composer.append("  protected void composeResource(Resource resource) throws IOException {\r\n");
//    composer.append("    "+reg.toString().substring(9));
//    composer.append("    else if (resource instanceof Binary)\r\n");
//    composer.append("      composeBinary(\"Binary\", (Binary)resource);\r\n");
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled resource type \"+resource.getClass().getName());\r\n");
//    composer.append("  }\r\n\r\n");
//    composer.append("  protected void composeResource(String name, Resource resource) throws IOException {\r\n");
//    composer.append("    "+regn.toString().substring(9));
//    composer.append("    else if (resource instanceof Binary)\r\n");
//    composer.append("      composeBinary(name, (Binary)resource);\r\n");
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled resource type \"+resource.getClass().getName());\r\n");
//    composer.append("  }\r\n\r\n");
//    composer.append("  protected void composeType(String prefix, Type type) throws IOException {\r\n");
//    composer.append("    if (type == null)\r\n");
//    composer.append("      ;\r\n");
//    composer.append(regtp.toString());
//    composer.append(regtn.toString());
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled type: \"+type.fhirType());\r\n");
//    composer.append("  }\r\n\r\n");
////
////    composer.append("  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) {\r\n");
////    composer.append("    "+regn.toString());
////    composer.append("    return false;\r\n");
////    composer.append("  }\r\n");
////    
//  }
//
//
//  public void finish() throws IOException {
//    composer.append("}\r\n");
//    composer.append("\r\n");
//    flush();
//  }
  
  private String upFirst(String n) {
    return n.substring(0,1).toUpperCase() + n.substring(1);
  }


}