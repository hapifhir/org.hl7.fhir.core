package org.hl7.fhir.core.generator.codegen.extensions;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.core.generator.analysis.AnalysisElementInfo;
import org.hl7.fhir.core.generator.codegen.Configuration;
import org.hl7.fhir.core.generator.codegen.JavaBaseGenerator;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent;
import org.hl7.fhir.utilities.Utilities;

public class JavaExtensionsFactoryGenerator extends JavaBaseGenerator {


  public class TypeTuple {

    private String javaType;
    private String fhirType;
    private String hapiType;
    private String javaRType;

    public TypeTuple(String javaType, String javaRType, String fhirType, String hapiType) {
      this.javaType = javaType;
      this.javaRType = javaRType == null ? javaType : javaRType;
      this.fhirType = fhirType;
      this.hapiType = hapiType;
    }

    public String getJavaType() {
      return javaType;
    }


    public String getJavaRType() {
      return javaRType;
    }
    
    public String getFhirType() {
      return fhirType;
    }

    public String adapt(String vn) {
      return hapiType == null ? vn : "new "+hapiType+"("+vn+")"; 
    }

    public String suffix() {
      return fhirType == null ? "" : Utilities.capitalize(javaType);
    }

    public String cast() {
      return fhirType == null ? "("+javaType+")" : "";
    }

    public String castList() {
      return fhirType == null ? "(List<"+javaType+">)" : "";
    }
  }

  private StringBuilder src;
  private Map<String, AnalysisElementInfo> elementInfo;
  private Set<String> genClassList;

  public JavaExtensionsFactoryGenerator(OutputStream out, Definitions definitions, Configuration configuration, String genDate, String version, String jid, Map<String, AnalysisElementInfo> elementInfo, Set<String> genClassList) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, jid);
    this.elementInfo = elementInfo;
    this.genClassList = genClassList;
  }

  public void start() throws Exception {
    src = new StringBuilder();    
  }

  public void generateSimple(StructureDefinition sd, String name, String constName) throws Exception {
    src.append("// -- "+sanitizeComment(name)+" -------------------------------------\r\n");
    src.append("// "+sanitizeComment(sd.getVersionedUrl())+"\r\n");
    src.append("// "+sanitizeComment(sd.getTitle())+"\r\n");
    src.append("\r\n");
    
    Set<String> contexts = new HashSet<>();
    for (StructureDefinitionContextComponent c : sd.getContext()) {
      processContext(c, contexts);
    }
    ElementDefinition edRoot = sd.getSnapshot().getElementFirstRep();
    boolean repeats = !edRoot.getMax().equals("1");
    String verb = repeats ? "add" : "set";
    ElementDefinition edValue = sd.getSnapshot().getElementByPath("Extension.value[x]");
    List<TypeTuple> types = analyseTypes(edValue);
    if (types.size() > 5) {
      if (wantGen(sd, "make"+name, "DataType")) {
        src.append("  public static Extension make"+name+"(DataType value) {\r\n");
        src.append("    return new Extension(ExtensionDefinitions.EXT_"+constName+").setValue(value);\r\n");
        src.append("  }\r\n");
        src.append("\r\n");
      }
      for (String ctxt : Utilities.sorted(contexts)) {
        if (wantGen(sd, verb+name, ctxt, "DataType")) {
          src.append("  public static "+ctxt+" "+verb+name+"("+ctxt+" context, DataType value) {\r\n");
          src.append("    ExtensionUtilities."+verb+"Extension(context, ExtensionDefinitions.EXT_"+constName+", value);\r\n");
          src.append("    return context;\r\n");
          src.append("  }\r\n");
          src.append("\r\n");
        }
        if (repeats) {
          if (wantGen(sd, "get"+name+"List", ctxt)) {
            src.append("  public static List<DataType> get"+name+"List("+ctxt+" context) {\r\n");
            src.append("    return ExtensionUtilities.getExtensionList(DataType.class, context, ExtensionDefinitions.EXT_"+constName+");\r\n");
            src.append("  }\r\n");
            src.append("\r\n");
          }
        } else {
          if (wantGen(sd, "get"+name, ctxt)) {
            src.append("  public static DataType get"+name+"("+ctxt+" context) {\r\n");
            src.append("    return ExtensionUtilities.getExtension(DataType.class, context, ExtensionDefinitions.EXT_"+constName+");\r\n");
            src.append("  }\r\n");
            src.append("\r\n");
          }
        }
      }
    } else {      
      for (TypeTuple t : types) {
        String sfx = typeCount(t.getJavaType(), types) > 1 ? Utilities.capitalize(t.getFhirType()) : "";
        if (wantGen(sd, "make"+name+sfx, t.getJavaType())) {
          src.append("  public static Extension make"+name+sfx+"("+t.getJavaType()+" value) {\r\n");
          src.append("    return new Extension(ExtensionDefinitions.EXT_"+constName+").setValue("+(t.adapt("value"))+");\r\n");
          src.append("  }\r\n");
          src.append("\r\n");
        }
      }
      for (String ctxt : Utilities.sorted(contexts)) {
        Set<String> td = new HashSet<>();
        for (TypeTuple t : types) {
          String sfx = typeCount(t.getJavaType(), types) > 1 ? Utilities.capitalize(t.getFhirType()) : "";
          if (wantGen(sd, verb+name+sfx, ctxt, t.getJavaType())) {
            src.append("  public static "+ctxt+" "+verb+name+sfx+"("+ctxt+" context, "+t.getJavaType()+" value) {\r\n");
            src.append("    ExtensionUtilities."+verb+"Extension(context, ExtensionDefinitions.EXT_"+constName+", "+(t.adapt("value"))+");\r\n");
            src.append("    return context;\r\n");
            src.append("  }\r\n");
            src.append("\r\n");
          }
          sfx = types.size() > 1 ? Utilities.capitalize(t.getJavaType()) : "";
          if (!td.contains(sfx)) {
            td.add(sfx);
            if (repeats) {
              if (wantGen(sd, "get"+name+sfx+"List", ctxt)) {
                src.append("  public static List<"+t.getJavaRType()+"> get"+name+sfx+"List("+ctxt+" context) {\r\n");
                if (t.getFhirType() == null) {
                  src.append("    return ExtensionUtilities.getExtensionList("+t.getJavaType()+".class, context, ExtensionDefinitions.EXT_"+constName+");\r\n");
                } else {
                  src.append("    return ExtensionUtilities.getExtension"+t.suffix()+"List(context, ExtensionDefinitions.EXT_"+constName+");\r\n");
                }
                src.append("  }\r\n");
                src.append("\r\n");
              }
            } else {
              if (wantGen(sd, "get"+name+sfx, ctxt)) {
                src.append("  public static "+t.getJavaRType()+" get"+name+sfx+"("+ctxt+" context) {\r\n");
                if (t.getFhirType() == null) {
                  src.append("    return ExtensionUtilities.getExtension("+t.getJavaType()+".class, context, ExtensionDefinitions.EXT_"+constName+");\r\n");
                } else {
                  src.append("    return ExtensionUtilities.getExtension"+t.suffix()+"(context, ExtensionDefinitions.EXT_"+constName+");\r\n");
                }
                src.append("  }\r\n");
                src.append("\r\n");
              }
            }
          }
        }
      }
    }
  }

  private void processContext(StructureDefinitionContextComponent c, Set<String> contexts) {
    switch (c.getType()) {
    case ELEMENT:
      if (c.getExpression().contains(".")) {
        AnalysisElementInfo info = elementInfo.get(c.getExpression());
        if (info != null && !info.getJavaType().contains("<")) {
          if (genClassList.contains(info.getJavaType()) ) {
            contexts.add(info.getJavaType());
          } else if (genClassList.contains(info.getClassFile())) {
            contexts.add("org.hl7.fhir."+jid+".core."+info.getClassFile()+"."+info.getJavaType());
          }
        }
      } else if (Character.isLowerCase(c.getExpression().charAt(0))) {
        String tn = Utilities.capitalize(c.getExpression())+"Type";
        if (genClassList.contains(tn)) {
          contexts.add(tn);
        }
      } else if ("List".equals(c.getExpression())) {
        contexts.add("ListResource");
      } else if (genClassList.contains(c.getExpression())) {
        contexts.add(c.getExpression());
      }
      break;
    case EXTENSION:
      contexts.add("Extension");
      break;
    case FHIRPATH:
      contexts.add("Element");
      contexts.add("Resource");
      break;
    default:
      break;
    }
    
  }

  private Set<String> genMethods = new HashSet<>();

  private boolean wantGen(StructureDefinition sd, String method, String... paramTypes) {
    String sig = method+"("+String.join(",", paramTypes)+")";
    if (genMethods.add(sig)) {
      return true;
    } else {
      System.out.println("Duplicate method "+sig+" from "+sd.getVersionedUrl()+" - not generated");
      return false;
    }
  }

  private int typeCount(String n, List<TypeTuple> types) {
    int i = 0;
    for (TypeTuple t : types) {
      if (n.equals(t.javaType)) {
        i++;
      }
    }
    return i;
  }

  private List<TypeTuple> analyseTypes(ElementDefinition edValue) {
    List<TypeTuple> ret = new ArrayList<>();
    for (TypeRefComponent tr : edValue.getType()) {
      if (Character.isLowerCase(tr.getWorkingCode().charAt(0))) {
        TypeTuple pt = javaPrimitive(tr.getWorkingCode());
        if (pt != null) {
          ret.add(pt);
        }
      } else {
        ret.add(new TypeTuple(tr.getWorkingCode(), tr.getWorkingCode(), null, null));        
      }
    }
    return ret;
  }


  private TypeTuple javaPrimitive(String type) {
    switch (type) {
    case "string" : return new TypeTuple("String", "String", type, "StringType");
    case "markdown" : return new TypeTuple("String", "String", type, "MarkdownType");
    case "canonical" : return new TypeTuple("String", "String", type, "CanonicalType");
    case "oid" : return new TypeTuple("String", "String", type, "OidType");
    case "uuid" : return new TypeTuple("String", "String", type, "UuidType");
    case "id" : return new TypeTuple("String", "String", type, "IdType");
    case "uri" : return new TypeTuple("String", "String", type, "UriType");
    case "url" : return new TypeTuple("String", "String", type, "UrlType");
    case "dateTime" : return new TypeTuple("String", "String",  type, "DateTimeType");
    case "instant" : return new TypeTuple("String", "String", type, "InstantType");
    case "time" : return new TypeTuple("String", "String", type, "TimeType");
    case "date" : return new TypeTuple("String", "String", type, "DateType");
    case "code" : return new TypeTuple("String", "String", type, "CodeType");
    case "boolean" : return new TypeTuple("boolean", "Boolean", type, "BooleanType");
    case "integer" : return new TypeTuple("int", "Integer", type, "IntegerType");
    case "positiveInt" : return new TypeTuple("int", "Integer",  type, "PositiveIntType");
    case "unsignedInt" : return new TypeTuple("int", "Integer",type, "UnsignedType");
    case "integer64" : return new TypeTuple("long", "UInteger", type, "Integer64Type");
    case "base64Binary" : return new TypeTuple("byte[]", "byte[]", type, "Base64BinaryType");
    case "decimal" : return new TypeTuple("float", "BigDecimal", type, "DecimalType");
    }
    return null;
  }

  public void finish() throws Exception {   

    String template = config.getAdornments().get("ExtensionUtilities");
    template = template.replace("{{jid}}", jid);
    template = template.replace("{{license}}", config.getLicense());
    template = template.replace("{{startMark}}", startVMarkValue());
    template = template.replace("{{generated}}", generatedAnnotationValue());

    template = template.replace("{{code}}", src.toString());

    write(template);
    flush();
    close();
  }

}