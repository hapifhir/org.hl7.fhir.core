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
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

public class JavaParserJsonGenerator extends JavaBaseGenerator {


  private StringBuilder parser = new StringBuilder();
  private StringBuilder pregt = new StringBuilder();
  private StringBuilder pregt2 = new StringBuilder();
  private StringBuilder pregf = new StringBuilder();
  private StringBuilder pregn = new StringBuilder();

  private StringBuilder composer = new StringBuilder();
  private StringBuilder creg = new StringBuilder();
  private StringBuilder cregn = new StringBuilder();
  private StringBuilder cregtn = new StringBuilder();
  private StringBuilder cregtp = new StringBuilder();
  private StringBuilder cregti = new StringBuilder();

  public JavaParserJsonGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate);
  }

  public void seeClass(Analysis analysis) throws Exception {
    generateParser(analysis);
    generateComposer(analysis);
    if (!analysis.isAbstract()) {
      if (analysis.getStructure().getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        pregt.append("    } else if (json.has(prefix+\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getRootType().getName()+"(json.getAsJsonObject(prefix+\""+analysis.getName()+"\"));\r\n");
        pregt2.append("   } else if (type.equals(\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getName()+"(json);\r\n");
        cregtn.append("    } else if (type instanceof "+analysis.getName()+") {\r\n       compose"+analysis.getName()+"(prefix+\""+analysis.getName()+"\", ("+analysis.getClassName()+") type);\r\n");
        cregti.append("    } else if (type instanceof "+analysis.getName()+") {\r\n       compose"+analysis.getName()+"Properties(("+analysis.getName()+") type);\r\n");
      }
      pregn.append("    if (json.has(prefix+\""+analysis.getName()+"\")) {\r\n      return true;\r\n    };\r\n");
      if (analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE) {
        pregf.append("    } else if (t.equals(\""+analysis.getName()+"\")) {\r\n      return parse"+analysis.getClassName()+"(json);\r\n");
        creg.append("    } else if (resource instanceof "+analysis.getClassName()+") {\r\n      compose"+analysis.getClassName()+"(\""+analysis.getName()+"\", ("+analysis.getClassName()+")resource);\r\n");
        cregn.append("    } else if (resource instanceof "+analysis.getClassName()+") {\r\n      compose"+analysis.getClassName()+"(name, ("+analysis.getClassName()+")resource);\r\n");
      }
    }
  }
  
  public void generate() throws Exception {
    
    String template = config.getAdornments().get("JsonParser");
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());

    template = template.replace("{{parser}}", parser.toString());
    template = template.replace("{{parse-resource}}", pregf.toString());
    template = template.replace("{{parse-type-pfx}}", pregt.toString());
    template = template.replace("{{parse-type}}", pregt2.toString());
    template = template.replace("{{parse-has-type}}", pregn.toString());
    
    template = template.replace("{{composer}}", composer.toString());
    template = template.replace("{{compose-resource}}", creg.toString());
    template = template.replace("{{compose-resource-named}}", cregn.toString());
    template = template.replace("{{compose-type}}", cregtp.toString() + cregtn.toString());
    template = template.replace("{{compose-type-inner}}", cregti.toString());

    write(template);
    flush();
    close();
  }
  

  private String getAsJsonPrimitive(String code, boolean shrt) {
    if ("boolean".equals(code))
      return shrt ? "Boolean" : "java.lang.Boolean";
    if ("decimal".equals(code))
      return shrt ? "BigDecimal" : "java.math.BigDecimal";
    if ("integer".equals(code) || "integer64".equals(code) )
      return shrt ? "Long" : "java.lang.Long";
    else
      return "String";
  }


  private void generateParser(Analysis analysis) throws Exception {

    if (analysis.isAbstract()) {
      genInnerAbstract(analysis);
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
    String pn = "parse"+tn;
    if (stn.contains(".") && !pn.startsWith("parse"+analysis.getClassName())) {
      pn = "parse"+analysis.getClassName()+tn;
    }
    boolean bUseOwner = false;

    parser.append("  protected "+stn+" "+pn+"(JsonObject json) throws IOException, FHIRFormatError {\r\n");
    parser.append("    "+stn+" res = new "+stn+"();\r\n");
    parser.append("    "+pn+"Properties(json, res);\r\n");
    parser.append("    return res;\r\n");
    parser.append("  }\r\n\r\n");
    
    parser.append("  protected void "+pn+"Properties(JsonObject json, "+stn+" res) throws IOException, FHIRFormatError {\r\n");
    parser.append("    parse"+ti.getAncestorName()+"Properties(json, res);\r\n");
    for (ElementDefinition e : ti.getChildren()) {
      genElementParser(analysis, ti, e, bUseOwner, matchingInheritedElement(ti.getInheritedChildren(), e));
    }
    parser.append("  }\r\n\r\n");
  }

  private void genInnerAbstract(Analysis analysis) throws IOException, Exception {
    String tn = analysis.getRootType().getName();
    boolean bUseOwner = false;

    parser.append("  protected void parse"+upFirst(tn).replace(".", "")+"Properties(JsonObject json, "+tn+" res) throws IOException, FHIRFormatError {\r\n");

    parser.append("    parse"+analysis.getAncestor().getName()+"Properties(json, res);\r\n");
    if (!analysis.isInterface()) {
      for (ElementDefinition e : analysis.getRootType().getChildren()) {
        genElementParser(analysis, analysis.getRootType(), e, bUseOwner, null);
      }
    }
    parser.append("  }\r\n\r\n");
  }

  private void genElementParser(Analysis analysis, TypeInfo ti, ElementDefinition ed, boolean bUseOwner, ElementDefinition inh) throws Exception {
    String name = ed.getName();
    String tn = ed.getUserString("java.type");
    if (name.endsWith("[x]") || name.equals("[type]")) {
      String en = name.endsWith("[x]") && !name.equals("[x]") ? name.replace("[x]", "") : "value";
      String pfx = name.endsWith("[x]") ? name.replace("[x]", "") : "";
      parser.append("    DataType "+getElementName(en, false)+" = parseType(\""+en+"\", json);\r\n");
      parser.append("    if ("+getElementName(en, false)+" != null)\r\n");
      parser.append("      res.set"+upFirst(getElementName(en, false))+"("+getElementName(en, false)+");\r\n");
    } else {
      String prsr = null;
      String aprsr = null;
      String anprsr = null;
      EnumInfo ei = null;
      String en = null;
      if (ed.hasUserData("java.enum")) {
        ei = (EnumInfo) ed.getUserData("java.enum"); // getCodeListType(cd.getBinding());
        ValueSet vs = ei.getValueSet();
        if (vs.hasUserData("shared")) {
          en = "Enumerations."+ei.getName();
        } else {
          en = analysis.getClassName()+"."+ei.getName();
        }
        prsr = "parseEnumeration(json.get(\""+name+"\").getAsString(), "+en+".NULL, new "+en.substring(0, en.indexOf("."))+"."+en.substring(en.indexOf(".")+1)+"EnumFactory())"; // en+".fromCode(parseString(xpp))";
        aprsr = "parseEnumeration(array.get(i).getAsString(), "+en+".NULL, new "+en.substring(0, en.indexOf("."))+"."+en.substring(en.indexOf(".")+1)+"EnumFactory())"; // en+".fromCode(parseString(xpp))";
        anprsr = "parseEnumeration(null, "+en+".NULL, new "+en.substring(0, en.indexOf("."))+"."+en.substring(en.indexOf(".")+1)+"EnumFactory())"; // en+".fromCode(parseString(xpp))";
        // parseEnumeration(xpp, Narratived.NarrativeStatus.additional, new Narratived.NarrativeStatusEnumFactory())
      } else {
        if (name.equals("extension")) {
          name = "extension";
          tn = "Extension";
        }
        if (tn.equals("XhtmlNode")) {
          prsr = "parseXhtml(json.get(\""+name+"\").getAsString())";
        } else if (tn.contains("Reference(")) {
          prsr = "parseReference(json.getAsJsonObject(\""+name+"\"))";
          aprsr = "parseReference(array.get(i).getAsJsonObject())";
          anprsr = "parseReference(null)";
        } else if (tn.contains("canonical(")) {
          prsr = "parseCanonical(json.get(\""+name+"\").getAsString())";
          aprsr = "parseCanonical(array.get(i).getAsString())";
          anprsr = "parseCanonical(null)";
        } else if (isPrimitive(ed.typeSummary())){
          if (tn.endsWith("Type")) {
            tn = tn.substring(0, tn.length()-4);
          }
          prsr = "parse"+upFirst(tn)+"(json.get(\""+name+"\").getAs"+getAsJsonPrimitive(ed.typeSummary(), true)+"())";
          aprsr = "parse"+upFirst(tn)+"(array.get(i).getAs"+getAsJsonPrimitive(ed.typeSummary(), true)+"())";
          anprsr = "parse"+upFirst(tn)+"(null)";
        } else {
          String pn = tn;
          if ((ed.isInlineType() || ed.hasContentReference()) && !pn.startsWith(analysis.getClassName())) {
            pn = analysis.getClassName()+pn;            
          }
          prsr = "parse"+pn+"(json.getAsJsonObject(\""+name+"\"))";
          aprsr = "parse"+pn+"(array.get(i).getAsJsonObject())";
          anprsr = "parse"+pn+"(null)";
        }
      }

      if (ed.unbounded()) {
        if (isPrimitive(ed.typeSummary()) || ed.typeSummary().startsWith("canonical(")) {
          parser.append("    if (json.has(\""+name+"\")) {\r\n");
          parser.append("      JsonArray array = json.getAsJsonArray(\""+name+"\");\r\n");
          parser.append("      for (int i = 0; i < array.size(); i++) {\r\n");
          parser.append("        if (array.get(i).isJsonNull()) {\r\n");
          if (en == null) {
            parser.append("          res.get"+upFirst(name)+"().add(new "+tn+"Type());\r\n");
          } else {
            parser.append("          res.get"+upFirst(name)+"().add(new Enumeration<"+en+">(new "+en+"EnumFactory(), "+en+".NULL));\r\n");
          }

          parser.append("        } else {;\r\n");
          parser.append("          res.get"+upFirst(name)+"().add("+aprsr+");\r\n");
          parser.append("        }\r\n");
          parser.append("      }\r\n");
          parser.append("    };\r\n");
          parser.append("    if (json.has(\"_"+name+"\")) {\r\n");
          parser.append("      JsonArray array = json.getAsJsonArray(\"_"+name+"\");\r\n");
          parser.append("      for (int i = 0; i < array.size(); i++) {\r\n");
          parser.append("        if (i == res.get"+upFirst(name)+"().size())\r\n");
          parser.append("          res.get"+upFirst(name)+"().add("+anprsr+");\r\n");
          parser.append("        if (array.get(i) instanceof JsonObject) \r\n");
          parser.append("          parseElementProperties(array.get(i).getAsJsonObject(), res.get"+upFirst(name)+"().get(i));\r\n");
          parser.append("      }\r\n");
          parser.append("    };\r\n");
        } else {
          parser.append("    if (json.has(\""+name+"\")) {\r\n");
          parser.append("      JsonArray array = json.getAsJsonArray(\""+name+"\");\r\n");
          parser.append("      for (int i = 0; i < array.size(); i++) {\r\n");
          parser.append("        res.get"+upFirst(getElementName(name, false))+"().add("+aprsr+");\r\n");
          parser.append("      }\r\n");
          parser.append("    };\r\n");
        }
      } else if (inh != null && inh.unbounded()){
        parser.append("    if (json.has(\""+name+"\"))\r\n");
        if ((isPrimitive(ed.typeSummary()) || ed.typeSummary().startsWith("canonical(")) && !tn.equals("XhtmlNode")) {
          parser.append("      res.add"+upFirst(getElementName(name, false))+"Element("+prsr+");\r\n");
          parser.append("    if (json.has(\"_"+name+"\"))\r\n");
          parser.append("      parseElementProperties(json.getAsJsonObject(\"_"+name+"\"), res.get"+upFirst(getElementName(name, false))+"ElementFirstRep());\r\n");
        } else {
          parser.append("      res.add"+upFirst(getElementName(name, false))+"("+prsr+");\r\n");
        }        
      } else {
        parser.append("    if (json.has(\""+name+"\"))\r\n");
        if ((isPrimitive(ed.typeSummary()) || ed.typeSummary().startsWith("canonical(")) && !tn.equals("XhtmlNode")) {
          parser.append("      res.set"+upFirst(getElementName(name, false))+"Element("+prsr+");\r\n");
          parser.append("    if (json.has(\"_"+name+"\"))\r\n");
          parser.append("      parseElementProperties(json.getAsJsonObject(\"_"+name+"\"), res.get"+upFirst(getElementName(name, false))+"Element());\r\n");
        } else {
          parser.append("      res.set"+upFirst(getElementName(name, false))+"("+prsr+");\r\n");
        }
      }
    }
  }

  private String upFirst(String n) {
    return n.substring(0,1).toUpperCase() + n.substring(1);
  }

  private void generateComposer(Analysis analysis) throws Exception {
    if (analysis.isAbstract())
      genInnerAbstractComposer(analysis);
    else
      genInnerComposer(analysis, analysis.getRootType());

    for (TypeInfo ti : analysis.getTypeList()) {
      genInnerComposer(analysis, ti);
    }
  }
  
  private void genInnerAbstractComposer(Analysis analysis) throws IOException, Exception {
    String tn = analysis.getRootType().getName();

    composer.append("  protected void compose"+tn+"Properties("+tn+" element) throws IOException {\r\n");
    composer.append("      compose"+analysis.getAncestor().getName()+"Properties(element);\r\n");
    if (!analysis.isInterface()) {
      for (ElementDefinition e : analysis.getRootType().getChildren()) {
        genElementComposer(analysis, analysis.getRootType(), e, null);
      }
    }
    composer.append("  }\r\n\r\n");
  }


  private void genInnerComposer(Analysis analysis, TypeInfo ti) throws IOException, Exception {
    String tn = ti.getName();
    String stn = (ti == analysis.getRootType() ? tn : analysis.getClassName()+"."+tn);

    composer.append("  protected void compose"+tn+"(String name, "+stn+" element) throws IOException {\r\n");
    composer.append("    if (element != null) {\r\n");
    boolean isResource = ti == analysis.getRootType() && analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE;
    if (isResource) {
      composer.append("      prop(\"resourceType\", name);\r\n");
    } else {
      composer.append("      open(name);\r\n");
    }
    composer.append("      compose"+upFirst(tn).replace(".", "")+"Properties(element);\r\n");
    if (!isResource) {
      composer.append("      close();\r\n");
    }
    composer.append("    }\r\n");
    composer.append("  }\r\n\r\n");
    
    composer.append("  protected void compose"+tn+"Properties("+stn+" element) throws IOException {\r\n");
    composer.append("    compose"+ti.getAncestorName()+"Properties(element);\r\n");
    for (ElementDefinition e : ti.getChildren()) {
      genElementComposer(analysis, analysis.getRootType(), e, matchingInheritedElement(ti.getInheritedChildren(), e));
    }
    composer.append("  }\r\n\r\n");
  }

  private String pathClass(String tn) {
    return tn.substring(0, tn.indexOf('.'));
  }

  private String pathNode(String tn) {
    return tn.substring(tn.indexOf('.')+1);
  }

  private void genElementComposer(Analysis analysis, TypeInfo ti, ElementDefinition ed, ElementDefinition inh) throws Exception {
    String name = ed.getName();
    if (name.endsWith("[x]") || name.equals("[type]")) {
      String en = name.endsWith("[x]") && !name.equals("[x]") ? name.replace("[x]", "") : "value";
      String pfx = name.endsWith("[x]") ? name.replace("[x]", "") : "";
      composer.append("      if (element.has"+upFirst(en)+"()) {\r\n");
      composer.append("        composeType(\""+pfx+"\", element.get"+upFirst(en)+"());\r\n");
      composer.append("      }\r\n");
    } else {
      String tn = ed.getUserString("java.type");
      String comp = null;
      String en = null;
      boolean enShared = false;
      if (ed.hasUserData("java.enum")) {
        EnumInfo ei = (EnumInfo) ed.getUserData("java.enum"); // getCodeListType(cd.getBinding());
        ValueSet vs = ei.getValueSet();
        enShared = vs.hasUserData("shared");
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
        } else if (tn.equals("code")) {
          tn = "Code";
          comp = "composeCode";
        } else if (tn.equals("instant")) {
          tn = "Instant";
        } else if (tn.contains("Reference(")) {
          comp = "composeReference";
          tn = "Reference";
        } else if (tn.contains("canonical(")) {
          comp = "composeCanonical";
          tn = "CanonicalType"; 
        } else if (tn.contains("(")) {
          comp = "compose"+tn;
        } else if (tn.startsWith(analysis.getName()) && !tn.equals(analysis.getClassName())) {
          comp = "compose"+leaf(tn);
        } else if (isPrimitive(ed)){
          comp = "compose"+leaf(tn);
          comp = comp.substring(0, comp.length()-4); // remove Type"
        } else {
          comp = "compose"+leaf(tn);
        }
      }
      //      if ((!contentsHaveId && typeIsSimple(e)) || ed.typeSummary().equals("xml:lang"))
      //        comp = comp+"Simple";

      if (ed.unbounded()) {
        tn = ed.getUserString("java.type");
        if (tn.contains("Reference(")) {
          comp = "composeReference";
          tn = "Reference";
        } else if (tn.contains("canonical(")) {
          comp = "composeCanonical";
          tn = "CanonicalType";
        }

        String stn = tn;
        if (ed.isInlineType() || ed.hasContentReference()) {
          stn = analysis.getClassName()+"."+tn;
        }
        
        composer.append("      if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        if (en == null) {
          if (tn.equals("String"))
            tn = "StringType";
          if (definitions.hasPrimitiveType(tn)) {
            tn = upFirst(tn)+"Type";
          }

          if (isPrimitive(ed) || ed.typeSummary().startsWith("canonical(")) {
            composer.append("        openArray(\""+name+"\");\r\n");
            composer.append("        for ("+(tn.contains("(") ? stn : upFirst(tn))+" e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
            composer.append("          "+comp+"Core(null, e, true);\r\n");
            composer.append("        closeArray();\r\n");
            composer.append("        if (anyHasExtras(element.get"+upFirst(getElementName(name, false))+"())) {\r\n");
            composer.append("          openArray(\"_"+name+"\");\r\n");
            composer.append("          for ("+(stn.contains("(") ? stn : upFirst(stn))+" e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
            composer.append("            "+comp+"Extras(null, e, true);\r\n");
            composer.append("          closeArray();\r\n");
            composer.append("        }\r\n");
          } else if (ed.typeSummary().equals("Resource")){
            composer.append("        openArray(\""+name+"\");\r\n");
            composer.append("        for ("+(stn.contains("(") ? tn : upFirst(tn))+" e : element.get"+upFirst(getElementName(name, false))+"()) {\r\n");
            composer.append("          open(null);\r\n");
            composer.append("          "+comp+"(e);\r\n");
            composer.append("          close();\r\n");
            composer.append("        }\r\n");
            composer.append("        closeArray();\r\n");

          } else {
            composer.append("        openArray(\""+name+"\");\r\n");
            composer.append("        for ("+(stn.contains("(") ? stn : upFirst(stn))+" e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
            composer.append("          "+comp+"(null, e);\r\n");
            composer.append("        closeArray();\r\n");
          }
        } else {
          composer.append("        openArray(\""+name+"\");\r\n");
          composer.append("        for (Enumeration<"+prepEnumName(en)+"> e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
          composer.append("          composeEnumerationCore(null, e, new "+prepEnumName(en)+"EnumFactory(), true);\r\n");
          composer.append("        closeArray();\r\n");
          composer.append("        if (anyHasExtras(element.get"+upFirst(getElementName(name, false))+"())) {\r\n");
          composer.append("          openArray(\"_"+name+"\");\r\n");
          composer.append("          for (Enumeration<"+prepEnumName(en)+"> e : element.get"+upFirst(getElementName(name, false))+"()) \r\n");
          composer.append("            composeEnumerationExtras(null, e, new "+prepEnumName(en)+"EnumFactory(), true);\r\n");
          composer.append("          closeArray();\r\n");
          composer.append("        }\r\n");
        }
        composer.append("      };\r\n");
      } else if (en != null) {
        composer.append("      if (element.has"+upFirst(getElementName(name, false))+"Element()) {\r\n");
        if (enShared) {
          composer.append("        composeEnumerationCore(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), new "+prepEnumName(en)+"EnumFactory(), false);\r\n");
          composer.append("        composeEnumerationExtras(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), new "+prepEnumName(en)+"EnumFactory(), false);\r\n");
        } else {
          composer.append("        composeEnumerationCore(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), new "+prepEnumName(en)+"EnumFactory(), false);\r\n");
          composer.append("        composeEnumerationExtras(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), new "+prepEnumName(en)+"EnumFactory(), false);\r\n");
        }
        composer.append("      }\r\n");
        //composer.append("        composeString(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"().toCode());\r\n");
      } else if (ed.typeSummary().equals("Resource")){
        composer.append("        if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("          open(\""+name+"\");\r\n");
        composer.append("          "+comp+"(element.get"+upFirst(getElementName(name, false))+"());\r\n");
        composer.append("          close();\r\n");
        composer.append("        }\r\n");
      } else if (!"xhtml".equals(ed.typeSummary()) && (isPrimitive(ed) || ed.typeSummary().startsWith("canonical("))) {
        composer.append("      if (element.has"+upFirst(getElementName(name, false))+"Element()) {\r\n");
        composer.append("        "+comp+"Core(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), false);\r\n");
        composer.append("        "+comp+"Extras(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"Element(), false);\r\n");
        composer.append("      }\r\n");
      } else if (tn.equals("xhtml")) {
        composer.append("      if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("        XhtmlNode node = element.getDiv();\r\n");
        composer.append("        if (node.getNsDecl() == null) {\r\n");
        composer.append("          node.attribute(\"xmlns\", XHTML_NS);\r\n");
        composer.append("        }\r\n");
        composer.append("        "+comp+"(\""+name+"\", node);\r\n");
        composer.append("      }\r\n");
      } else if (inh != null && inh.unbounded()){
        composer.append("      if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("        "+comp+"(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"FirstRep());\r\n");
        composer.append("      }\r\n");
      } else {
        composer.append("      if (element.has"+upFirst(getElementName(name, false))+"()) {\r\n");
        composer.append("        "+comp+"(\""+name+"\", element.get"+upFirst(getElementName(name, false))+"());\r\n");
        composer.append("      }\r\n");
      }
    }
  }

  private boolean isPrimitive(ElementDefinition e) {
    return definitions.hasPrimitiveType(e.typeSummary());
  }


  private String prepEnumName(String en) {
    String[] parts = en.split("\\.");
    if (parts.length == 1)
      return upFirst(parts[0]);
    else
      return upFirst(parts[0])+'.'+upFirst(parts[1]);
  }

  private String leaf(String tn) {
    return tn.startsWith("java.lang.") ? tn.substring(10) : tn;
  }
//
//  private boolean typeIsSimple(ElementDefn e) {
//    String t = ed.typeSummary();
//    return definitions.getPrimitives().containsKey(t);
//  }
//
//  private String typeName(ElementDefn root, ElementDefn elem, boolean formal) throws Exception {
//    String t = elem.typeSummary();
//    //    if (usePrimitive && definitions.getPrimitives().containsKey(t)) {
//    //      if (t.equals("boolean"))
//    //        return formal ? "boolean" : "java.lang.Boolean";
//    //      else if (t.equals("integer"))
//    //        return "int";
//    //      else if (t.equals("integer64"))
//    //        return "long";
//    //      else if (t.equals("decimal"))
//    //        return formal ? "BigDecimal" : "BigDecimal";
//    //      else if (t.equals("base64Binary"))
//    //        return formal ? "byte[]" : "bytes";
//    //      else if (t.equals("instant"))
//    //        return formal ? "java.util.Calendar" : "Date";
//    //      else if (t.equals("uri"))
//    //        return formal ? "java.net.URI" : "Uri";
//    //      else if (t.equals("dateTime"))
//    //        return "DateTime";
//    //      else if (t.equals("date"))
//    //        return "Date";
//    //      else
//    //        return "String";
//    ////        return upFirst(t);
//    //    }  else if (t.equals("xml:lang"))
//    //        return formal ? "string" : "Code";
//    //    else
//    if (elem.usesCompositeType()) {
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
//    composer.append("  protected void composeResource(Resource resource) throws IOException {\r\n");
//    composer.append("    "+reg.toString().substring(9));
//    composer.append("    else if (resource instanceof Binary)\r\n");
//    composer.append("      composeBinary(\"Binary\", (Binary)resource);\r\n");
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled resource type \"+resourced.getClass().getName());\r\n");
//    composer.append("  }\r\n\r\n");
//    composer.append("  protected void composeNamedReference(String name, Resource resource) throws IOException {\r\n");
//    composer.append("    "+regn.toString().substring(9));
//    composer.append("    else if (resource instanceof Binary)\r\n");
//    composer.append("      composeBinary(name, (Binary)resource);\r\n");
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled resource type \"+resourced.getClass().getName());\r\n");
//    composer.append("  }\r\n\r\n");
//    composer.append("  protected void composeType(String prefix, Type type) throws IOException {\r\n");
//    composer.append("    if (type == null)\r\n");
//    composer.append("      ;\r\n");
//    composer.append(regtp.toString());
//    composer.append(regtn.toString());
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled type\");\r\n");
//    composer.append("  }\r\n\r\n");
//    composer.append("  protected void composeTypeInner(Type type) throws IOException {\r\n");
//    composer.append("    if (type == null)\r\n");
//    composer.append("      ;\r\n");
//    composer.append(regti.toString());
//    composer.append("    else\r\n");
//    composer.append("      throw new Error(\"Unhandled type: \"+typed.fhirType());\r\n");
//    composer.append("  }\r\n\r\n");
//    //
//    //    composer.append("  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) {\r\n");
//    //    composer.append("    "+regn.toString());
//    //    composer.append("    return false;\r\n");
//    //    composer.append("  }\r\n");
//    //
//  }
//
//  private void scanNestedTypesComposer(ElementDefn root, String path, ElementDefn e) throws Exception {
//    String tn = null;
//    if (ed.typeSummary().equals("code") && ed.hasBinding()) {
//      BindingSpecification cd = ed.getBinding();
//      if (cd != null && cd.getBinding() == BindingSpecification.BindingMethod.CodeList) {
//        tn = getCodeListType(cd.getValueSet().getName());
//        if (!enumNames.contains(tn)) {
//          enumNames.add(tn);
//          enums.add(e);
//        }
//        typeNames.put(e,  rootOf(path)+"."+tn);
//      }
//      if (cd != null && isEnum(cd)) {
//        tn = getCodeListType(cd.getName());
//        if (!enumNames.contains(tn)) {
//          enumNames.add(tn);
//          enums.add(e);
//        }
//        typeNames.put(e,  rootOf(path)+"."+tn);
//      }
//    }
//    if (tn == null) {
//      if (ed.usesCompositeType()) {
//        tn = typeNames.get(getElementForPath(root, ed.typeSummary().substring(1)));
//        typeNames.put(e,  tn);
//      } else if (ed.getTypes().size() > 0) {
//        tn = ed.typeSummary();
//        TypeRef tr = ed.getTypes().get(0);
//
//        if (tr.isUnboundGenericParam())
//          tn = genparam;
//        else if (tr.isXhtml())
//          tn = "char[]";
//        else if (tr.isWildcardType())
//          tn ="Type";
//        else if (tn.equals("xml:lang"))
//          tn = "Code";
//        else if (tn.equals("string"))
//          tn = "String";
//        if (tn.contains("<"))
//          tn = tn.substring(0, tn.indexOf('<')+1)+tn.substring(tn.indexOf('<')+1, tn.indexOf('<')+2).toUpperCase()+tn.substring(tn.indexOf('<')+2);
//        typeNames.put(e,  tn);
//      } else {
//        if (ed.getDeclaredTypeName() != null)
//          tn = ed.getDeclaredTypeName();
//        else
//          tn = upFirst(ed.getName());
//        if (tn.equals("Element"))
//          tn = "Element_";
//        if (!ed.getName().equals("extension"))
//          strucs.add(e);
//        if (typeNameStrings.contains(tn)) {
//          char i = 'A';
//          while (typeNameStrings.contains(tn+i))
//            i++;
//          tn = tn + i;
//        }
//        typeNameStrings.add(tn);
//        tn = path+"."+tn;
//        typeNames.put(e,  tn);
//        for (ElementDefn c : ed.getElements()) {
//          scanNestedTypesComposer(root, path, c);
//        }
//      }
//    }
//  }
//
//  private String rootOf(String path) {
//    int i = path.indexOf('.');
//    return i == -1 ? path : path.substring(0, i);
//  }
//
//  @Override
//  protected String getElementName(String name, boolean alone) {
//    if (name.equals("[type]"))
//      return "value";
//    else if ((alone && GeneratorUtils.isJavaReservedWord(name)) || (!alone && name.equals("class")))
//      return name+"_";
//    else
//      return name.replace("[x]", "");
//  }

}
