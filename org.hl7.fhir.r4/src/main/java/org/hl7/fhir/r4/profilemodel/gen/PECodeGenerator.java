package org.hl7.fhir.r4.profilemodel.gen;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:

   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to
     endorse or promote products derived from this software without specific
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r4.profilemodel.PEBuilder;
import org.hl7.fhir.r4.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r4.profilemodel.PEDefinition;
import org.hl7.fhir.r4.profilemodel.PEType;
import org.hl7.fhir.r4.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;

/**
 * 
 * The easiest way to generate code is to use the FHIR Validator, which can generate java classes for profiles
 * using this code. Parameters:
 * 
 *   -codegen -version r4 -ig hl7.fhir.dk.core#3.2.0 -profiles http://hl7.dk/fhir/core/StructureDefinition/dk-core-gln-identifier,http://hl7.dk/fhir/core/StructureDefinition/dk-core-patient -output /Users/grahamegrieve/temp/codegen -package-name org.hl7.fhir.test
 * 
 * Parameter Documentation:
 *   -codegen: tells the validator to generate code
 *   -version {r4|5}: which version to generate for 
 *   -ig {name}: loads an IG (and it's dependencies) - see -ig documentation for the validator
 *   -profiles {list}: a comma separated list of profile URLs to generate code for 
 *   -output {folder}: the folder where to generate the output java class source code
 *   -package-name {name}: the name of the java package to generate in
 *      
 * options
 *   -option {name}: a code generation option, one of:
 *   
 *     narrative: generate code for the resource narrative (recommended: don't - leave that for the native resource level)
 *     meta: generate code the what's in meta
 *     contained: generate code for contained resources 
 *     all-elements: generate code for all elements, not just the key elements (makes the code verbose)
 */
@SuppressWarnings("checkstyle:systemout")
public class PECodeGenerator {


  public static final String DEFAULT_DATE() {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US"));
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    return sdf.format(new Date());
  }
  
  
  public enum ExtensionPolicy {
    None, Complexes, Primitives;
  }
  
  private class PEGenClass {
    private String name;
    private String base;
    private String doco;
    private String url;
    private boolean isResource;
    private Set<String> unfixed = new HashSet<>();
    private Set<String> enumNames = new HashSet<>();
    
    private StringBuilder inits = new StringBuilder();
    private StringBuilder fields = new StringBuilder();
    private StringBuilder enums = new StringBuilder();
    private StringBuilder load = new StringBuilder();
    private StringBuilder save = new StringBuilder();
    private StringBuilder clear = new StringBuilder();
    private StringBuilder copy = new StringBuilder();
    private StringBuilder accessors = new StringBuilder();
    private StringBuilder hash = new StringBuilder();
    public void genId() {
      if (isResource) {
        genField(true, "id", "String", "id", "", false, "", 0, 1, null);
        genAccessors(true, false, "id", "id", "String", "", "String", "String", "Id", "Ids", false, "", false, false, null);   
        genLoad(true, false, "id", "id", "id", "IdType", "", "String", "String", "Id", "Ids", false, false, null, false);
        genSave(true, false, "id", "id", "id", "IdType", "", "String", "String", "Id", "Ids", false, false, false, null, false);
        genClear(false, "id", "String");
      }
    }
    public void write(StringBuilder b, String copyright) {
      w(b);
      if (copyright != null) {
        w(b, "/*");
        w(b, copyright);
        w(b, " */");
        w(b);
      }
      w(b, "// Generated by the HAPI Java Profile Generator, "+genDate);      
      w(b);      
      jdoc(b, doco, 0, true);
      w(b, "public class "+name+" extends PEGeneratedBase {");
      w(b);
      if (url != null) {
        w(b, "  public static final String CANONICAL_URL = \""+url+"\";");
        w(b);        
      }
      if (enums.length() > 0) {
        w(b, enums.toString());
      }
      w(b, fields.toString());
      if (unfixed.isEmpty()) {
        jdoc(b, "Parameter-less constructor.", 2, true);
      } else {
        jdoc(b, "Parameter-less constructor. If you use this, the fixed values on "+CommaSeparatedStringBuilder.join(",", unfixed)+" won't be filled out - they'll be missing. They'll be filled in if/when you call build, so they won't be missing from the resource, only from this particular object model", 2, true);
      }
      w(b, "  public "+name+"() {");
      if (inits.length() > 0) {
        w(b, "    initFixedValues();");
      }
      w(b, "  }");
      w(b);
      if (isResource) {
        jdoc(b, "Construct an instance of the object, and fill out all the fixed values ", 2, true);
        w(b, "  public "+name+"(IWorkerContext context) {");
        if (inits.length() > 0) {
          w(b, "    initFixedValues();");
        }
        w(b, "    workerContext = context;");
        w(b, "    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);");
        w(b, "    PEInstance src = builder.buildPEInstance(CANONICAL_URL, builder.createResource(CANONICAL_URL, false));");
        w(b, "    load(src);");
        w(b, "  }");
        w(b);
        jdoc(b, "Populate an instance of the object based on this source object ", 2, true);
        if(base.equalsIgnoreCase("List"))
            w(b, "  public static "+name+" fromSource(IWorkerContext context, "+base+"Resource source) {");
        else
            w(b, "  public static "+name+" fromSource(IWorkerContext context, "+base+" source) {");
        w(b, "    "+name+" theThing = new "+name+"();");
        w(b, "    theThing.workerContext = context;");
        w(b, "    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);");
        w(b, "    PEInstance src = builder.buildPEInstance(CANONICAL_URL, source);");
        w(b, "    theThing.load(src);");
        w(b, "    return theThing;");
        w(b, "  }");  
        w(b);
      } else {
        jdoc(b, "Used when loading other models ", 2, true);
        w(b, "  public static "+name+" fromSource(PEInstance source) {");
        w(b, "    "+name+" theThing = new "+name+"();");
        w(b, "    theThing.workerContext = source.getContext();");
        w(b, "    theThing.load(source);");
        w(b, "    return theThing;");
        w(b, "  }");  
      }
      w(b);
      w(b, "  public void load(PEInstance src) {");
      w(b, "    clear();");
      w(b, load.toString());
      w(b, "  }");  
      w(b);

      if (isResource) {
        jdoc(b, "Build a instance of the underlying object based on this wrapping object ", 2, true);
        if(base.equalsIgnoreCase("List"))
            w(b, "  public "+base+"Resource build(IWorkerContext context) {");
        else
            w(b, "  public "+base+" build(IWorkerContext context) {");
        w(b, "    workerContext = context;");
        w(b, "    return build();");
        w(b, "  }");
        w(b);
        jdoc(b, "Build a instance of the underlying object based on this wrapping object ", 2, true);
        if(base.equalsIgnoreCase("List"))
            w(b, "  public "+base+"Resource build() {");
        else
            w(b, "  public "+base+" build() {");
        if(base.equalsIgnoreCase("List"))
            w(b, "    "+base+"Resource theThing = new "+base+"Resource();");
        else
            w(b, "    "+base+" theThing = new "+base+"();");
        w(b, "    PEBuilder builder = new PEBuilder(workerContext, PEElementPropertiesPolicy.EXTENSION, true);");
        w(b, "    PEInstance tgt = builder.buildPEInstance(CANONICAL_URL, theThing);");      
        w(b, "    save(tgt, false);");
        w(b, "    return theThing;");
        w(b, "  }");
        w(b);
        jdoc(b, "Save this profile class into an existing resource (overwriting anything that exists in the profile) ", 2, true);
        if(base.equalsIgnoreCase("List"))
            w(b, "  public void save(IWorkerContext context, "+base+"Resource dest, boolean nulls) {");
        else
            w(b, "  public void save(IWorkerContext context, "+base+" dest, boolean nulls) {");
        w(b, "    workerContext = context;");
        w(b, "    PEBuilder builder = new PEBuilder(context, PEElementPropertiesPolicy.EXTENSION, true);");
        w(b, "    PEInstance tgt = builder.buildPEInstance(CANONICAL_URL, dest);");
        w(b, "    save(tgt, nulls);");
        w(b, "  }");
        w(b);
      }
      w(b, "  public void save(PEInstance tgt, boolean nulls) {");
      w(b, save.toString());
      w(b, "  }");  
      w(b);
      if (inits.length() > 0) {
        w(b, "  private void initFixedValues() {");
        w(b, inits.toString());
        w(b, "  }");  
        w(b);
      }
      w(b, accessors.toString());
      w(b);
      w(b, "  public void clear() {");
      w(b, clear.toString());
      w(b, "  }");  
      w(b);
      w(b, "}");  
    }

    private String generateEnum(PEDefinition source, PEDefinition field) {
      if (field.definition().hasBinding() && !field.hasFixedValue()) {
        ElementDefinitionBindingComponent binding = field.definition().getBinding();
        if (binding.getStrength() == org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED && binding.hasValueSet()) {
          org.hl7.fhir.r4.model.ValueSet vs = workerContext.fetchResource(org.hl7.fhir.r4.model.ValueSet.class, binding.getValueSet());
          if (vs != null) {
            ValueSetExpansionOutcome vse = workerContext.expandVS(vs, false, false);
            Set<String> codes = new HashSet<>();
            boolean hasDups = false;
            if (vse.isOk()) {
              String baseName = Utilities.nmtokenize(Utilities.singularise(vs.getName()));
              String name = baseName;
              if (workerContext.getResourceNames().contains(name)) {
                name = name+"Type";
              }
              int c = 0;
              while (enumNames.contains(name)) {
                c++;
                name = baseName+c;
              }
              w(enums, "  public enum "+name+" {");
              for (int i = 0; i < vse.getValueset().getExpansion().getContains().size(); i++) {
                ValueSetExpansionContainsComponent cc = vse.getValueset().getExpansion().getContains().get(i);
                String code = Utilities.javaTokenize(cc.getCode(), true).toUpperCase();
                if (Utilities.isInteger(code)) {
                  code = "C_"+code;
                }
                if (cc.getAbstract()) {
                  code = "_"+code;
                }
                if (codes.contains(code)) {
                  char sfx = 'A';
                  while (codes.contains(code+sfx)) {
                    sfx++;
                  }
                  code = code + sfx;
                  hasDups = true;
                }
                codes.add(code);
                cc.setUserData("java.code", code);
                w(enums, "    "+code+(i < vse.getValueset().getExpansion().getContains().size() - 1 ? "," : ";")+" // \""+cc.getDisplay()+"\" = "+cc.getSystem()+"#"+cc.getCode());
              }
              w(enums, "");
              if (!hasDups) {
                w(enums, "    public static "+name+" fromCode(String s) {");
                w(enums, "      switch (s) {");
                for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
                  w(enums, "      case \""+cc.getCode()+"\": return "+cc.getUserString("java.code")+";");                
                }
                w(enums, "      default: return null;");
                w(enums, "      }");
                w(enums, "    }");
                w(enums, "");
              }
              w(enums, "    public static "+name+" fromCoding(Coding c) {");
              for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
                if (cc.hasVersion()) {
                  w(enums, "      if (\""+cc.getSystem()+"\".equals(c.getSystem()) && \""+cc.getCode()+"\".equals(c.getCode()) && (!c.hasVersion() || \""+cc.getVersion()+"\".equals(c.getVersion()))) {");                  
                } else {
                  w(enums, "      if (\""+cc.getSystem()+"\".equals(c.getSystem()) && \""+cc.getCode()+"\".equals(c.getCode())) {");
                }
                w(enums, "        return "+cc.getUserString("java.code")+";");
                w(enums, "      }");
              }
              w(enums, "      return null;");
              w(enums, "    }");
              w(enums, "");
              w(enums, "    public static "+name+" fromCodeableConcept(CodeableConcept cc) {");
              w(enums, "      for (Coding c : cc.getCoding()) {");
              w(enums, "        "+name+" v = fromCoding(c);");
              w(enums, "        if (v != null) {");
              w(enums, "          return v;");
              w(enums, "        }");
              w(enums, "      }");
              w(enums, "      return null;");
              w(enums, "    }");
              w(enums, "");

              w(enums, "    public String toDisplay() {");
              w(enums, "      switch (this) {");
              for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
                w(enums, "      case "+cc.getUserString("java.code")+": return \""+Utilities.escapeJava(cc.getDisplay())+"\";");
              }
              w(enums, "      default: return null;");
              w(enums, "      }");
              w(enums, "    }");
              w(enums, "");
              
              if (!hasDups) {
                w(enums, "    public String toCode() {");
                w(enums, "      switch (this) {");
                for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
                  w(enums, "      case "+cc.getUserString("java.code")+": return \""+cc.getCode()+"\";");                
                }
                w(enums, "      default: return null;");
                w(enums, "      }");
                w(enums, "    }");
                w(enums, "");
              }
              w(enums, "    public Coding toCoding() {");
              w(enums, "      switch (this) {");
              for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
                if (cc.hasVersion()) {
                  w(enums, "      case "+cc.getUserString("java.code")+": return new Coding().setSystem(\""+cc.getSystem()+"\").setVersion(\""+cc.getVersion()+"\").setCode()\""+cc.getCode()+"\";");
                } else {
                  w(enums, "      case "+cc.getUserString("java.code")+": return new Coding().setSystem(\""+cc.getSystem()+"\").setCode(\""+cc.getCode()+"\");");
                }
              }
              w(enums, "      default: return null;");
              w(enums, "      }");
              w(enums, "    }");
              w(enums, "");
              w(enums, "    public CodeableConcept toCodeableConcept() {");
              w(enums, "      Coding c = toCoding();");
              w(enums, "      return c == null ? null : new CodeableConcept().addCoding(c);");
              w(enums, "    }");
              w(enums, "  }");
              return name;
            }
          }
        }
      }
      return null;
    }
    
    private void defineField(PEDefinition source, PEDefinition field) {
      if (field.types().size() == 1) {
        StructureDefinition sd = workerContext.fetchTypeDefinition(field.types().get(0).getUrl());
        if (sd != null) {
          String enumName = generateEnum(source, field);
          boolean isPrim = sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
          boolean isAbstract = sd.getAbstract();
          String name = Utilities.javaTokenize(field.name().replace("[x]", ""), false);
          String sname = name;
          String type = null;
          String init = "";
          String ptype = type;
          boolean isEnum = false;
          if (enumName != null) {
            type = enumName;
            ptype = enumName;
            isEnum = true;
          } else if (isPrim) {
            // todo: are we extension-less?
            type = Utilities.capitalize(field.types().get(0).getName()+"Type");
            ptype = getPrimitiveType(sd);
          } else {
            type = Utilities.javaTokenize(field.types().get(0).getName(), true);
          }
          String ltype = type;
          if (field.isList()) {
            ltype = "List<"+type+">";
            init = "new ArrayList<>()";
            if (!Utilities.existsInList(name, "contained")) {
              name = Utilities.pluralize(name, 2);
            }
          }
          String cname = Utilities.capitalize(name);
          String csname = Utilities.capitalize(sname);
          String nn = field.min() == 1 ? "// @NotNull" : "";
          boolean isExtension = field.isExtension();
          genField(isPrim, name, ptype, ltype, nn, field.isList(), field.shortDocumentation(), field.min(), field.max(), field.definition());
          if (isPrim && field.hasFixedValue()) {
            genFixed(name, ptype, field.getFixedValue());
          }
          genAccessors(isPrim, isAbstract, name, field.name(), type, init, ptype, ltype, cname, csname, field.isList(), field.documentation(), field.hasFixedValue(), isEnum, field.definition());   
          genLoad(isPrim, isAbstract, name, sname, field.name(), type, init, ptype, ltype, cname, csname, field.isList(), field.hasFixedValue(), field.types().get(0), isEnum); 
          genSave(isPrim, isAbstract, name, sname, field.name(), type, init, ptype, ltype, cname, csname, field.isList(), field.hasFixedValue(), isExtension, field.types().get(0), isEnum);
          genClear(field.isList(), name, ptype);
        }
      } else {
        // ignoring polymorphics for now
      }
    }
    
    private void genClear(boolean list, String name, String ptype) {
      if (list) {
        w(clear, "    "+name+".clear();");        
      } else if ("boolean".equals(ptype)) {
        w(clear, "    "+name+" = false;");
      } else if ("int".equals(ptype)) {
        w(clear, "    "+name+" = 0;");
      } else {
        w(clear, "    "+name+" = null;");
      }
    }
    
    private void genLoad(boolean isPrim, boolean isAbstract, String name, String sname, String fname, String type, String init, String ptype, String ltype, String cname, String csname, boolean isList, boolean isFixed, PEType typeInfo, boolean isEnum) {
      if (isList) {
        w(load, "    for (PEInstance item : src.children(\""+fname+"\")) {");
        if (typeInfo != null && typeInfo.getUrl() != null && !typeInfo.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition")) {
          w(load, "      "+name+".add("+type+".fromSource(src.child(\""+fname+"\")));");

        } else if ("BackboneElement".equals(type)) {
          w(load, "      "+name+".add(("+type+") item.asElement());");          
        } else if (isEnum) {
          if ("CodeableConcept".equals(typeInfo.getName())) {
            w(load, "      "+name+".add("+type+".fromCodeableConcept((CodeableConcept) item.asDataType()));");
          } else if ("Coding".equals(typeInfo.getName())) {
            w(load, "      "+name+".add("+type+".fromCoding((Coding) item.asDataType()));");
          } else {
            w(load, "      "+name+".add("+type+".fromCode(item.asDataType().primitiveValue()));");
          }
        } else {
          w(load, "      "+name+".add(("+type+") item.asDataType());");
        }
        w(load, "    }");
      } else if (isEnum) {
        w(load, "    if (src.hasChild(\""+fname+"\")) {");
        if ("CodeableConcept".equals(typeInfo.getName())) {
          w(load, "      "+name+" = "+type+".fromCodeableConcept((CodeableConcept) src.child(\""+fname+"\").asDataType());");
        } else if ("Coding".equals(typeInfo.getName())) {
          w(load, "      "+name+" = "+type+".fromCoding((Coding) src.child(\""+fname+"\").asDataType());");
        } else {
          w(load, "      "+name+" = "+type+".fromCode(src.child(\""+fname+"\").asDataType().primitiveValue());");
        }  
        w(load, "    }");      
      } else if (isPrim) {
        w(load, "    if (src.hasChild(\""+fname+"\")) {");
        if ("CodeType".equals(type)) {
          // might be code or enum 
          w(load, "      "+name+" = src.child(\""+fname+"\").asDataType().primitiveValue();");
        } else {
          w(load, "      "+name+" = (("+type+") src.child(\""+fname+"\").asDataType()).getValue();");
        }
        w(load, "    }");      
      } else if (typeInfo != null && typeInfo.getUrl() != null && !typeInfo.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition")) {
        w(load, "    if (src.hasChild(\""+fname+"\")) {");
        w(load, "      "+name+" = "+type+".fromSource(src.child(\""+fname+"\"));");
        w(load, "    }");
      } else {
        w(load, "    if (src.hasChild(\""+fname+"\")) {");      
        if ("BackboneElement".equals(type)) {
          w(load, "      "+name+" = ("+type+") src.child(\""+fname+"\").asElement();");
        } else if (Utilities.existsInList(type, workerContext.getResourceNames())) {
          w(load, "      "+name+" = ("+type+") src.child(\""+fname+"\").asResource();");
        } else if("Reference".equals(type)) {
          w(load, "      "+type+" ref = ("+type+") src.child(\""+fname+"\").asDataType();");
          w(load, "      if(!ref.isEmpty())");
          w(load, "        "+name+" = ref;");
        } else {
          w(load, "      "+name+" = ("+type+") src.child(\""+fname+"\").asDataType();");
        }
        w(load, "    }");
      }
    }

    private void genSave(boolean isPrim, boolean isAbstract, String name, String sname, String fname, String type, String init, String ptype, String ltype, String cname, String csname, boolean isList, boolean isFixed, boolean isExtension, PEType typeInfo, boolean isEnum) {
      w(save, "    tgt.clear(\""+fname+"\");");
      if (isList) {
        w(save, "    for ("+type+" item : "+name+") {");
        if (isExtension) {
          if (typeInfo != null && typeInfo.getUrl() != null && !typeInfo.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition")) {
            w(save, "      item.save(tgt.makeChild(\""+fname+"\"), false);");
          } else {
            w(save, "      tgt.makeChild(\""+fname+"\").data().setProperty(\"value[x]\", item);");
          }
        } else if (isEnum) {
          if ("CodeableConcept".equals(typeInfo.getName())) {
            w(save, "      tgt.addChild(\""+fname+"\", item.toCodeableConcept());");
          } else if ("Coding".equals(typeInfo.getName())) {
            w(save, "      tgt.addChild(\""+fname+"\", item.toCoding());");
          } else {
            w(save, "      tgt.addChild(\""+fname+"\", item.toCode());");
          }  
        } else {
            if(typeInfo.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition"))
                w(save, "      tgt.addChild(\""+fname+"\", item);");
            else
                w(save, "      tgt.addChild(\""+fname+"\",(Type) item.getData());");

        }
        w(save, "    }");
      } else if (isEnum) {
        w(save, "    if ("+name+" != null) {");
        if ("CodeableConcept".equals(typeInfo.getName())) {
          w(save, "      tgt.addChild(\""+fname+"\", "+name+".toCodeableConcept());");
        } else if ("Coding".equals(typeInfo.getName())) {
          w(save, "      tgt.addChild(\""+fname+"\", "+name+".toCoding());");
        } else {
          w(save, "      tgt.addChild(\""+fname+"\", "+name+".toCode());");
        }  
        w(save, "    }");      
      } else if (isPrim) {
        if ("boolean".equals(ptype)) {
          w(save, "    if (true) { // for now, at least");
        } else if ("int".equals(ptype)) {
          w(save, "    if ("+name+" != 0) {");
        } else {
          w(save, "    if ("+name+" != null) {");
        }
        if (isExtension) {
          w(save, "      tgt.makeChild(\""+fname+"\").data().setProperty(\"value[x]\", new "+type+"("+name+"));");
        } else if (Utilities.existsInList(type, "DateType", "InstantType", "DateTimeType")) {
          w(save, "      tgt.addChild(\""+fname+"\", new "+type+"("+name+"));");          
        } else {
          w(save, "      tgt.makeChild(\""+fname+"\").data().setProperty(\"value\", new "+type+"("+name+"));");
        }
        w(save, "    }");
      } else if (typeInfo != null && typeInfo.getUrl() != null && !typeInfo.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition")) {
        w(save, "    if ("+name+" != null) {");
        w(save, "      "+name+".save(tgt.makeChild(\""+fname+"\"), nulls);");
        w(save, "    }");
      } else if (isExtension) {
        w(save, "    if ("+name+" != null) {");
        w(save, "      tgt.makeChild(\""+fname+"\").data().setProperty(\"value[x]\", "+name+");");
        w(save, "    }");
      } else {
        w(save, "    if ("+name+" != null) {");
        w(save, "      tgt.addChild(\""+fname+"\", "+name+");");
        w(save, "    }");
      }
    }

    private void genAccessors(boolean isPrim, boolean isAbstract, String name, String fname, String type, String init, String ptype, String ltype, String cname, String csname, boolean isList, String shortDoco, boolean isFixed, boolean isEnum, ElementDefinition ed) {
      if (ed != null) {
        jdoc(accessors, ed.getDefinition(), 2, true);
      }
      if ((isEnum || isPrim) && extensionPolicy != ExtensionPolicy.Primitives && !isList) {
        w(accessors, "  public "+ptype+" get"+cname+"() {");
        w(accessors, "    return "+name+";");
        w(accessors, "  }");
        w(accessors);
        if (isFixed) {
          w(accessors, "  public boolean has"+cname+"() {");
          w(accessors, "    return true;");
          w(accessors, "  }");  
        } else {
          w(accessors, "  public "+this.name+" set"+cname+"("+ptype+" value) {");
          w(accessors, "    this."+name+" = value;");
          w(accessors, "    return this;");
          w(accessors, "  }");
          w(accessors);
          w(accessors, "  public boolean has"+cname+"() {");
          if ("boolean".equals(ptype)) {
            w(accessors, "    return true; // not "+name+" != false ?");             
          } else if ("int".equals(ptype)) {
            w(accessors, "    return "+name+" != 0;");            
          } else {
            w(accessors, "    return "+name+" != null;");
          }
          w(accessors, "  }");  
        }
      } else {
        if (isPrim && !isList) {
          w(accessors, "  public "+ptype+" get"+cname+"() {");
          w(accessors, "    if ("+name+" == null) { "+name+" = new "+type+"(); }");
          w(accessors, "    return "+name+".getValue();");
          w(accessors, "  }");
          w(accessors, "  public "+ltype+" get"+cname+"Element() {");
        } else if (isAbstract && !isList) {
          w(accessors, "  public @Nullable "+ltype+" get"+cname+"() { // "+ltype+" is abstract ");
        } else {
          w(accessors, "  public "+ltype+" get"+cname+"() {");
        }
        if (isList) {
          w(accessors, "    if ("+name+" == null) { "+name+" = "+init+"; }");
        } else if (!isAbstract) {
          w(accessors, "    if ("+name+" == null) { "+name+" = new "+type+"(); }");
        }
        w(accessors, "    return "+name+";");
        w(accessors, "  }");
        w(accessors);
        if (isList) {
          w(accessors, "  public boolean has"+cname+"() {");
          w(accessors, "    return "+name+" != null && !"+name+".isEmpty();");
          w(accessors, "  }");
          w(accessors);
          if (!isAbstract) { 
            if (!isEnum) {
              w(accessors, "  public "+this.name+" add"+csname+"("+type+ " theThing) {");
              w(accessors, "    get"+cname+"().add(theThing);");
              w(accessors, "    return this;");
              w(accessors, "  }");
              w(accessors); 
            } else {
              w(accessors, "  public void add"+csname+"("+type+" theThing) {");
              w(accessors, "    get"+cname+"().add(theThing);");
              w(accessors, "  }");
              w(accessors); 
            }
          }
          w(accessors, "  public boolean has"+csname+"("+type+" item) {");
          w(accessors, "    return has"+cname+"() && "+name+".contains(item);");
          w(accessors, "  }");
          w(accessors);        
          w(accessors, "  public void remove"+csname+"("+type+" item) {");
          w(accessors, "    if (has"+csname+"(item)) {");
          w(accessors, "      "+name+".remove(item);");
          w(accessors, "    }");
          w(accessors, "  }");
          w(accessors);        
        } else if (isPrim) {
          if (!isFixed) {
            w(accessors, "  public "+this.name+" set"+cname+"("+ptype+" value) {");
            w(accessors, "    if ("+name+" == null) { "+name+" = new "+type+"(); }");
            w(accessors, "    "+name+".setValue(value);");
            w(accessors, "    return this;");
            w(accessors, "  }");
            w(accessors, "  public "+this.name+" set"+cname+"Element("+type+" value) {");
            w(accessors, "    this."+name+" = value;");
            w(accessors, "    return this;");
            w(accessors, "  }");
          }
          w(accessors, "  public boolean has"+cname+"() {");
          w(accessors, "    return "+name+" != null && "+name+".hasValue();");
          w(accessors, "  }");
          w(accessors); 
        } else {
          if (!isFixed) {
            w(accessors, "  public "+this.name+" set"+cname+"("+type+" value) {");
            w(accessors, "    this."+name+" = value;");
            w(accessors, "    return this;");
            w(accessors, "  }");
          }
          w(accessors, "  public boolean has"+cname+"() {");
          w(accessors, "    return "+name+" != null;");
          w(accessors, "  }");
        }
      }
      w(accessors);
    }

    private void genField(boolean isPrim, String name, String ptype, String ltype, String nn, boolean isList, String shortDoco, int min, int max, ElementDefinition ed) {
//      jdoc(fields, shortDoco, 2, true);
      w(fields, "  @Min(\""+min+"\") @Max(\""+(max == Integer.MAX_VALUE ? "*" : max) +"\")"+(" @Doco(\""+Utilities.escapeJava(shortDoco)+"\")"));
      if (ed != null) {
        if (ed.hasBinding() && ed.getBinding().hasValueSet()) {
          w(fields, "  @BindingStrength(\""+ed.getBinding().getStrength().toCode()+"\") @ValueSet(\""+ed.getBinding().getValueSet()+"\")");
        }
        if (ed.getMustSupport()) {
          w(fields, "  @MustSupport(true)");          
        }
        if (ed.hasLabel() || ed.hasDefinition()) {
          String s = "";
          if (ed.hasLabel()) {
            s = s + " @Label(\""+Utilities.escapeJava(ed.getLabel())+"\")";
          }
          if (ed.hasDefinition()) {
            s = s + " @Definition(\""+Utilities.escapeJava(ed.getDefinition())+"\")";
          }
          w(fields, " "+s);          
        }
      }
      if (isPrim && extensionPolicy != ExtensionPolicy.Primitives && !isList) {
        w(fields, "  private "+ptype+" "+name+";"+nn+"  // "+shortDoco);
      } else if (isList) {
        w(fields, "  private "+ltype+" "+name+" = new ArrayList<>();"+nn+"  // "+shortDoco);
      } else {
        w(fields, "  private "+ltype+" "+name+";"+nn+"  // "+shortDoco);             
      }
      w(fields, "");
    }


    private void genFixed(String name, String pType, Type fixedValue) {
      if ("String".equals(pType)) {
        w(inits, "    "+name+" = \""+Utilities.escapeJava(fixedValue.primitiveValue())+"\";");
      } else {
        unfixed.add(name);
        System.out.println("Unable to handle the fixed value for "+name+" of type "+pType+" = "+fixedValue.toString());
      }
    }
  }

  private String folder;
  private IWorkerContext workerContext;
  private String canonical;
  private String pkgName;
  private String version = "r4";

  // options:
  private ExtensionPolicy extensionPolicy;
  private boolean narrative;
  private boolean contained;
  private boolean meta;
  private String language;
  private boolean keyElementsOnly;
  private String genDate = DEFAULT_DATE();


  public PECodeGenerator(IWorkerContext workerContext) {
    super();
    this.workerContext = workerContext;
  }

  public String getFolder() {
    return folder;
  }


  public void setFolder(String folder) {
    this.folder = folder;
  }


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getCanonical() {
    return canonical;
  }

  public void setCanonical(String canonical) {
    this.canonical = canonical;
  }


  public String getPkgName() {
    return pkgName;
  }

  public void setPkgName(String pkgName) {
    this.pkgName = pkgName;
  }

  public ExtensionPolicy getExtensionPolicy() {
    return extensionPolicy;
  }

  public void setExtensionPolicy(ExtensionPolicy extensionPolicy) {
    this.extensionPolicy = extensionPolicy;
  }

  public boolean isNarrative() {
    return narrative;
  }

  public void setNarrative(boolean narrative) {
    this.narrative = narrative;
  }

  public boolean isMeta() {
    return meta;
  }

  public void setMeta(boolean meta) {
    this.meta = meta;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public boolean isKeyElementsOnly() {
    return keyElementsOnly;
  }

  public void setKeyElementsOnly(boolean keyElementsOnly) {
    this.keyElementsOnly = keyElementsOnly;
  }

  public boolean isContained() {
    return contained;
  }

  public void setContained(boolean contained) {
    this.contained = contained;
  }

  public String getGenDate() {
    return genDate;
  }

  public void setGenDate(String genDate) {
    this.genDate = genDate;
  }

  private StringBuilder imports = new StringBuilder();

  /**
   * @throws IOException
   *
   */
  public String execute() throws IOException {
    imports = new StringBuilder();

    PEDefinition source = new PEBuilder(workerContext, PEElementPropertiesPolicy.EXTENSION, true).buildPEDefinition(canonical);
    w(imports, "import java.util.List;");
    w(imports, "import java.util.ArrayList;");
    w(imports, "import java.util.Date;\r\n");
    w(imports, "import java.math.BigDecimal;");
    w(imports, "import javax.annotation.Nullable;");
    w(imports);
    w(imports, "import org.hl7.fhir."+version+".context.IWorkerContext;");
    w(imports, "import org.hl7.fhir."+version+".model.*;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.PEBuilder;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.PEInstance;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.PEBuilder.PEElementPropertiesPolicy;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.PEGeneratedBase;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.Min;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.Max;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.Label;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.Doco;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.BindingStrength;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.ValueSet;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.MustSupport;");
    w(imports, "import org.hl7.fhir."+version+".profilemodel.gen.Definition;");
      

    PEGenClass cls = genClass(source);
    StringBuilder b = new StringBuilder();
    w(b, "package "+pkgName+";");
    w(b);
    if (source.getProfile().hasCopyright()) {
      jdoc(b, source.getProfile().getCopyright(), 0, false);
    }
    w(b, imports.toString());
    cls.write(b, source.getProfile().getCopyright());
    FileUtilities.stringToFile(b.toString(), Utilities.path(folder, cls.name+".java"));
    return cls.name+".java";
  }

  public void jdoc(StringBuilder b, String doco, int indent, boolean jdoc) {
    if (!Utilities.noString(doco)) {
      String pfx = Utilities.padLeft("", ' ', indent);
      w(b, pfx+"/*"+(jdoc ? "*" : ""));
      for (String line : doco.split("\\R")) {
        for (String nl : naturalLines(line))
          w(b, pfx+" * "+nl);
        w(b, pfx+" *");
      }
      w(b, pfx+" */");
    }    
  }

  private List<String> naturalLines(String line) {
    List<String> lines = new ArrayList<>();
    while (line.length() > 80) {
      int cutpoint = 80;
      while (cutpoint > 0 && line.charAt(cutpoint) != ' ') {
        cutpoint--;
      }
      if (cutpoint == 0) {
        cutpoint = 80;
      } else {
        cutpoint++;
      }
      lines.add(line.substring(0, cutpoint));
      line = line.substring(cutpoint);
    }
    lines.add(line);
    return lines;
  }

  private void w(StringBuilder b) {
    b.append("\r\n");

  }

  private void w(StringBuilder b, String line) {
    b.append(line);
    w(b);    
  }

  private PEGenClass genClass(PEDefinition source) {
    PEGenClass cls = new PEGenClass();
    cls.name = Utilities.javaTokenize(source.getProfile().getName(), true);
    cls.base = source.getProfile().getType();
    cls.doco = source.documentation();
    cls.url = source.getProfile().getVersionedUrl();
    cls.isResource = source.getProfile().getKind() == StructureDefinitionKind.RESOURCE;
    cls.genId();
    for (PEDefinition child : source.children()) {
      if (genForField(source, child)) {
        cls.defineField(source, child);
      }
    }    
    return cls;
  }

  private boolean genForField(PEDefinition source, PEDefinition child) {
    if (child.definition().getBase().getPath().equals("Resource.meta")) {
      return meta;
    }
    if (child.definition().getBase().getPath().equals("DomainResource.text")) {
      return narrative;
    }
    if (child.definition().getBase().getPath().equals("Resource.language")) {
      return language == null;
    }
    if (child.definition().getBase().getPath().endsWith(".extension") || child.definition().getBase().getPath().endsWith(".modifierExtension")) {
      return extensionPolicy == ExtensionPolicy.Complexes;
    }
    if (child.definition().getBase().getPath().equals("DomainResource.contained")) {
      return contained;
    }
    return !keyElementsOnly || (child.isKeyElement());
  }


  private String getPrimitiveType(StructureDefinition sd) {

    if (sd.getType().equals("string"))
      return "String";
    if (sd.getType().equals("code"))
      return "String";
    if (sd.getType().equals("markdown"))
      return "String";
    if (sd.getType().equals("base64Binary"))
      return "byte[]";
    if (sd.getType().equals("uri"))
      return "String";
    if (sd.getType().equals("url"))
      return "String";
    if (sd.getType().equals("canonical"))
      return "String";
    if (sd.getType().equals("oid"))
      return "String";
    if (sd.getType().equals("integer"))
      return "int";
    if (sd.getType().equals("integer64"))
      return "long";
    if (sd.getType().equals("unsignedInt"))
      return "int";
    if (sd.getType().equals("positiveInt"))
      return "int";
    if (sd.getType().equals("boolean"))
      return "boolean";
    if (sd.getType().equals("decimal"))
      return "BigDecimal";
    if (sd.getType().equals("dateTime"))
      return "Date";
    if (sd.getType().equals("date"))
      return "Date";
    if (sd.getType().equals("id"))
      return "String";
    if (sd.getType().equals("instant"))
      return "Date";
    if (sd.getType().equals("time"))
      return "String";

    return "??";
  }

}
