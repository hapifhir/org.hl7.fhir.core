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
import org.hl7.fhir.core.generator.analysis.TypeInfo;
import org.hl7.fhir.core.generator.codegen.JavaBaseGenerator;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.utilities.Utilities;

public class JavaParserRdfGenerator extends JavaBaseGenerator {

//  private StringBuilder parser = new StringBuilder();
  private StringBuilder composer = new StringBuilder();
  private StringBuilder reg = new StringBuilder();
  private StringBuilder regt = new StringBuilder();

  public JavaParserRdfGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate);
  }
  
  public void seeClass(Analysis analysis) throws Exception {
//    generateParser(analysis);
    generateComposer(analysis);
    if (!analysis.isAbstract()) {
      if (analysis.getStructure().getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        regt.append("    } else if (value instanceof "+analysis.getClassName()+") {\r\n      compose"+analysis.getClassName()+"(parent, parentType, name, ("+analysis.getClassName()+")value, index);\r\n");
      }
      if (analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE) {
        reg.append("    } else if (resource instanceof "+analysis.getClassName()+") {\r\n      compose"+analysis.getClassName()+"(parent, null, \""+analysis.getName()+"\", ("+analysis.getClassName()+")resource, -1);\r\n");
      }
    }
  }
  
  public void generate() throws Exception {   
    String template = config.getAdornments().get("RdfParser");
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{composer}}", composer.toString());
    template = template.replace("{{compose-resource}}", reg.toString());
    template = template.replace("{{compose-type}}", regt.toString());

    write(template);
    flush();
    close();
  }


  public void generateComposer(Analysis analysis) throws Exception {
    if (analysis.isAbstract())
      genInnerAbstractComposer(analysis, analysis.getRootType());
    else
      genInnerComposer(analysis, analysis.getRootType());

    for (TypeInfo ti : analysis.getTypeList()) {
      genInnerComposer(analysis, ti);
    }

  }

  private void genInnerComposer(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();
    String stn = (ti == analysis.getRootType() ? tn : analysis.getClassName()+"."+tn);
    String pfx = (ti.getDefn().isInlineType()) && !tn.startsWith(analysis.getClassName()) ? analysis.getClassName() : "";
    
    composer.append("  protected void compose"+pfx+tn+"(Complex parent, String parentType, String name, "+stn+" element, int index) {\r\n");
    composer.append("    if (element == null) \r\n");
    composer.append("      return;\r\n");
    composer.append("    Complex t;\r\n");
    composer.append("    if (Utilities.noString(parentType))\r\n");
    composer.append("      t = parent;\r\n");
    composer.append("    else {\r\n");
    composer.append("      t = parent.predicate(\"fhir:\"+parentType+'.'+name);\r\n");
    composer.append("    }\r\n");
    composer.append("    compose"+ti.getAncestorName()+"(t, \""+ti.getDefn().getName()+"\", name, element, index);\r\n");
    if (tn.equals("Coding")) 
      composer.append("    decorateCoding(t, element);\r\n");
    else if (tn.equals("CodeableConcept")) 
      composer.append("    decorateCodeableConcept(t, element);\r\n");

    for (ElementDefinition ed : ti.getChildren()) {
      genElement(analysis, ti, ed, matchingInheritedElement(ti.getInheritedChildren(), ed));
    }
    composer.append("  }\r\n\r\n");    
  }

  private void genInnerAbstractComposer(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();

    composer.append("  protected void compose"+tn+"(Complex t, String parentType, String name, "+tn+" element, int index) {\r\n");
    composer.append("    compose"+ti.getAncestorName()+"(t, parentType, name, element, index);\r\n");

    for (ElementDefinition ed : ti.getChildren()) {
      genElement(analysis, ti, ed, null);
    }
    composer.append("  }\r\n\r\n");    
  }

  private void genElement(Analysis analysis, TypeInfo ti, ElementDefinition ed, ElementDefinition inh) throws Exception {
    String name = ed.getName();
    String gname = "get"+upFirst(checkJavaReservedWord(name))+"()";
    String tname = ed.getUserString("java.type");
//    if (tname.startsWith("@")) {
//      ElementDefn tgt = getElementForPath(root, e.typeCode().substring(1)); 
//      tname = typeNames.get(tgt).replace(".", "");
//    } else if (Utilities.noString(tname) && typeNames.containsKey(e)) {
//      tname = typeNames.get(e).replace(".", "");
//    } else if (tname.contains("("))
//      tname = tname.substring(0, tname.indexOf("("));
//    if (name.endsWith("[x]") || e.getTypes().size() > 1 || e.typeCode().equals("*")) { 
//      tname = "Type";
//      if (name.endsWith("[x]"))
//        name = name.substring(0, name.length()-3);
//      gname = "get"+upFirst(name)+"()";
//    } else if (isJavaPrimitive(e) || e.typeCode().startsWith("canonical(")) {
//      BindingSpecification cd = e.getBinding();
//      if (e.typeCode().equals("code") && cd != null && cd.getBinding() == BindingSpecification.BindingMethod.CodeList)
//        tname = "Enum"; 
//      if (e.typeCode().equals("code") && cd != null && isEnum(cd))
//        tname = "Enum"; 
//      gname = "get"+upFirst(checkJavaReservedWord(name))+"Element()";
//    }
//    else if (definitions.getConstraints().containsKey(tname)) 
//      tname = definitions.getConstraints().get(tname).getBaseType();

    if (ed.getPath().equals("Reference.reference")) {
      gname = "get"+upFirst(checkJavaReservedWord(name))+"Element_()"; // special case
      tname = tname.substring(0, tname.length()-4); 
    } else if (name.endsWith("[x]")) { 
      tname = "Type"; // not DataType
      name = name.substring(0, name.length()-3);
      gname = "get"+upFirst(name)+"()";
    } else if (ed.hasUserData("java.enum")) {
      tname = "Enum"; 
      if (!ed.unbounded()) {
        gname = "get"+upFirst(checkJavaReservedWord(name))+"Element()";
      }
    } else if (!"xhtml".equals(ed.typeSummary()) && (isPrimitive(ed) || ed.typeSummary().startsWith("canonical()"))) {
      tname = tname.substring(0, tname.length()-4); 
      if (!ed.unbounded()) {
        gname = "get"+upFirst(checkJavaReservedWord(name))+"Element()";
      }
    }
    String pfx = ((ed.hasContentReference() || ed.isInlineType()) && !tname.startsWith(analysis.getClassName())) ? analysis.getClassName() : "";

    if (ed.unbounded()) {
//      if (gname.endsWith("Element()") && !gname.equals("getElement()"))
//        gname = gname.substring(0, gname.length()-9)+"()";
      composer.append("    for (int i = 0; i < element."+gname+".size(); i++) {\r\n");
      composer.append("      compose"+pfx+tname+"(t, \""+ti.getName()+"\", \""+name+"\", element."+gname+".get(i), i);\r\n");
      composer.append("    }\r\n");
    } else if (inh != null && inh.unbounded()) {
      composer.append("    if (element.has"+gname.substring(3).replace("ReferenceElement_", "ReferenceElement")+") {\r\n");
      composer.append("      compose"+pfx+tname+"(t, \""+ti.getName()+"\", \""+name+"\", element."+gname.replace("()", "FirstRep()")+", -1);\r\n");
      composer.append("    }\r\n");
    } else {
      composer.append("    if (element.has"+gname.substring(3).replace("ReferenceElement_", "ReferenceElement")+") {\r\n");
      composer.append("      compose"+pfx+tname+"(t, \""+ti.getName()+"\", \""+name+"\", element."+gname+", -1);\r\n");
      composer.append("    }\r\n");
    }
  }

  private String checkJavaReservedWord(String name) {
    if (Utilities.existsInList(name, "class"))
      return name+"_";
    else
      return name;
  }

//  private boolean isPrimitive(ElementDefn e) {
//    return definitions.hasPrimitiveType(e.typeCode());
//  }

//
//  private String prepEnumName(String en) {
//    String[] parts = en.split("\\.");
//    if (parts.length == 1)
//      return upFirst(parts[0]);
//    else
//      return upFirst(parts[0])+'.'+upFirst(parts[1]);
//  }
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
//      //      if (t.equals("boolean"))
//      //        return "java.lang.Boolean";
//      //      else if (t.equals("integer"))
//      //        return "Integer";
//      //      else if (t.equals("integer64"))
//      //        return "Integer64?";
//      //      else if (t.equals("decimal"))
//      //        return "Decimal";
//      //      else if (t.equals("base64Binary"))
//      //        return "Base64Binary";
//      //      else if (t.equals("instant"))
//      //        return "Instant";
//      //      else if (t.equals("uri"))
//      //        return "Uri";
//      //      else 
//      //        return "String";
//      //      else if (t.equals("string"))
//      //        return "StringType";
//      //      else
//      return upFirst(t);
//    } else if (elem.usesCompositeType()) { 
//      if (typeNames.containsKey(elem) && typeNames.get(elem) != null)
//        return typeNames.get(elem);
//      else  
//        return root.getName();      
//    } else if (elem.getTypes().size() == 0) {
//      return typeNames.get(elem);
//    } else if (typeNames.containsKey(elem))
//      return typeNames.get(elem);
//    else
//      return upFirst(t);
//  }
//
//  private void finishComposer() throws Exception {
//    composer.append("  @Override\r\n");
//    composer.append("  protected void composeResource(Complex parent, Resource resource) {\r\n");
//    composer.append("    "+reg.toString().substring(9));
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled resource type \"+resource.getClass().getName());\r\n");
//    composer.append("  }\r\n\r\n");
//
//    composer.append("  protected void composeType(Complex parent, String parentType, String name, Type value, int index) {\r\n");
//    composer.append("    if (value == null)\r\n");
//    composer.append("      return;\r\n");
//    composer.append(regtn.toString());
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled type\");\r\n");
//    composer.append("  }\r\n\r\n");
//    //
//    //    composer.append("  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) {\r\n");
//    //    composer.append("    "+regn.toString());
//    //    composer.append("    return false;\r\n");
//    //    composer.append("  }\r\n");
//    //    
//  }
//
//
//  public void finish() throws IOException {
//    composer.append("}\r\n");
//    composer.append("\r\n");
//    flush();
//  }
//  private String getPrimitiveTypeModelName(String code) {
//    if (code.equals("string"))
//      return "StringType";
//    if (definitions.hasPrimitiveType(code))
//      return upFirst(code)+"Type";
//    return upFirst(code);
//  }

  private boolean isPrimitive(ElementDefinition e) {
    return definitions.hasPrimitiveType(e.typeSummary());
  }

  private String upFirst(String n) {
    return n.substring(0,1).toUpperCase() + n.substring(1);
  }


}
