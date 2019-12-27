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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.SearchParamType;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.utils.TypesUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;


/*
changes for James
- lazy construction of lists
- getX will construct if null
- add hasX
  
*/
public class JavaResourceGenerator extends JavaBaseGenerator {

  public enum JavaGenClass { Type, Resource, Constraint }
	private JavaGenClass clss;
	
	public JavaResourceGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
		super(out, definitions, configuration, version, genDate);
	}

	private Map<ElementDefinition, String> typeNames = new HashMap<ElementDefinition, String>();
	private List<String> typeNameStrings = new ArrayList<String>();
	private List<ElementDefinition> enums = new ArrayList<ElementDefinition>();
	private List<String> enumNames = new ArrayList<String>();
	private List<ElementDefinition> strucs  = new ArrayList<ElementDefinition>();
  private String classname;
  private String allfields;
  private long hashSum;
  private String inheritedHash;
//  private String javaPatternDir;


	public Map<ElementDefinition, String> getTypeNames() {
		return typeNames;
	}

	// public void generate(ElementDefinition root, String name, JavaGenClass clss, ProfiledType cd, Date genDate, String version, boolean isAbstract, Map<String, SearchParameterDefn> nameToSearchParamDef, ElementDefinition template) throws Exception {
	public void generate(StructureDefinition structure, String name, List<SearchParameter> searchParams) throws Exception {
		typeNames.clear();
		typeNameStrings.clear();
		enums.clear();
		strucs.clear();
		enumNames.clear();
    classname = upFirst(name);

		if (structure.getKind() == StructureDefinitionKind.RESOURCE) {
		  clss = JavaGenClass.Resource;
		} else {
		  clss = JavaGenClass.Type;
		}
    boolean isRefType = structure.getName().equals("Reference");   

		write("package org.hl7.fhir.r5.model;\r\n");
    startMark(version, genDate);
		
    boolean hl = true; // hasList(root);
    boolean hh = hasXhtml(structure.getSnapshot().getElement());
    boolean hd = hasDecimal(structure.getSnapshot().getElement());
    boolean hs = hasString(structure.getSnapshot().getElement());
    boolean he = hasSharedEnums(structure.getSnapshot().getElement());
    boolean hn = hasNestedTypes(structure.getSnapshot().getElement());
    if (hl || hh || hd || he) {
      if (hl) {
        write("import java.util.ArrayList;\r\n");
        write("import java.util.Date;\r\n");
        write("import java.util.List;\r\n");
      } else {
        write("import java.util.Date;\r\n");

      }
      if (hh) {
        write("import org.hl7.fhir.utilities.xhtml.NodeType;\r\n");
        write("import org.hl7.fhir.utilities.xhtml.XhtmlNode;\r\n");
      }
      if (hd)
        write("import java.math.*;\r\n");
      if (hs)
        write("import org.hl7.fhir.utilities.Utilities;\r\n");
      if (he)
        write("import org.hl7.fhir.r5.model.Enumerations.*;\r\n");
    }
    if (hn) {
      if (clss == JavaGenClass.Resource) {
        write("import org.hl7.fhir.instance.model.api.IBaseBackboneElement;\r\n");
      } else {
        write("import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;\r\n");
      }
    }
    write("import org.hl7.fhir.exceptions.FHIRException;\r\n");
    write("import org.hl7.fhir.instance.model.api.ICompositeType;\r\n");
    if (clss == JavaGenClass.Resource) {
      write("import ca.uhn.fhir.model.api.annotation.ResourceDef;\r\n");
      write("import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;\r\n");
    } 
    if (clss == JavaGenClass.Resource || "BackboneElement".equals(name) || "BackboneType".equals(name)) {
      write("import org.hl7.fhir.instance.model.api.IBaseBackboneElement;\r\n");
    }
    write("import ca.uhn.fhir.model.api.annotation.Child;\r\n");
    write("import ca.uhn.fhir.model.api.annotation.ChildOrder;\r\n");
    if (clss != JavaGenClass.Resource) {
      write("import ca.uhn.fhir.model.api.annotation.DatatypeDef;\r\n");
    }
    write("import ca.uhn.fhir.model.api.annotation.Description;\r\n");
    write("import ca.uhn.fhir.model.api.annotation.Block;\r\n");
    
    write("\r\n");
    if (config.getIni().hasProperty("imports", classname)) {
      for (String imp : config.getIni().getStringProperty("imports", classname).split("\\,")) {
        write("import "+imp+";\r\n");
      }
    }
    
		jdoc("", replaceTitle(structure.getName(), structure.getDescription()));
		ElementDefinition root = structure.getSnapshot().getElementFirstRep();
		List<ElementDefinition> children = filterChildren(ProfileUtilities.getChildList(structure, root));
    StructureDefinition sdb = definitions.getStructures().get(structure.getBaseDefinition());
    List<ElementDefinition> inheritedChildren = getAbstractChildren(sdb);
		boolean hasChildren = children.size() > 0;
		String supertype = sdb.getName();
    boolean isAbstract = structure.getAbstract();
    boolean isInterface = structure.hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-interface");
    String hierarchy = "extends "+supertype;
    if (clss == JavaGenClass.Resource) {
      if (!isAbstract) {
        write("@ResourceDef(name=\""+upFirst(name).replace("ListResource", "List")+"\", profile=\"http://hl7.org/fhir/StructureDefinition/"+upFirst(name)+"\")\r\n");
      }
    } else {
      write("@DatatypeDef(name=\""+upFirst(name)+"\")\r\n");
      hierarchy = hierarchy + " implements ICompositeType";
    }
    
    if (config.getIni().hasProperty("hierarchy", classname)) {
      hierarchy = config.getIni().getStringProperty("hierarchy", classname).replace("{{super}}", supertype);
    }
				
    write("public "+(isAbstract? "abstract " : "")+"class "+classname+" "+hierarchy.trim()+" {\r\n");
		write("\r\n");

		for (ElementDefinition e : children) {
		  scanNestedTypes(structure, root, children, structure.getName(), e);
		}
		for (ElementDefinition n : typeNames.keySet()) {
		  String nn = typeNames.get(n);
		  if (nn.startsWith("@")) {
		    ElementDefinition er = getElementForPath(structure, nn.substring(1));
		    if (!typeNames.containsKey(er)) {
		      throw new Exception("not found: "+er); 
		    }
		    String nnn = typeNames.get(er);
		    typeNames.put(n, nnn);
		    n.setUserData("type", nnn);
		  }
		}
		for (ElementDefinition e : enums) {
		  generateEnum(e, upFirst(name));
		}
		for (ElementDefinition e : strucs) {
		  generateType(structure, e, JavaGenClass.Type, structure.getName(), isInterface);
		}

		allfields = "";
		int i = 0;
		for (ElementDefinition e : children) {
		  if (!isInterface) {
		    generateField(root, e, "    ", i++, structure);
		  }
		}
		write("    private static final long serialVersionUID = "+Long.toString(allfields.hashCode())+"L;\r\n\r\n");
		hashSum = hashSum + allfields.hashCode();

		List<ElementDefinition> mandatory = new ArrayList<ElementDefinition>();
		generateConstructor(upFirst(name), mandatory, "  ");      
		if (hasChildren) {
		  for (ElementDefinition e : children) {
		    if (e.getMin() > 0)
		      mandatory.add(e);
		  }
		  if (mandatory.size() > 0)
		    generateConstructor(upFirst(name), mandatory, "  ");

		  generateTypeSpecificConstructors(upFirst(name));

		  for (ElementDefinition e : children) {
	      if (isInterface) {
          generateAbstractAccessors(root, e, "    ", upFirst(name));
	      } else {
		      generateAccessors(root, e, "    ", upFirst(name), matchingInheritedElement(inheritedChildren, e));
	      }
		  }
		  if (!isInterface) {
		    for (ElementDefinition e : filterInherited(inheritedChildren, children)) {
		      generateUnimplementedAccessors(root, e, "    ", upFirst(name));
		    }
		  }
      
		  generateTypeSpecificAccessors(name);

		  generateChildrenRegister(root, children, "    ", isAbstract, isInterface, structure.getName());
		  generatePropertyGetterId(root, children, "    ", isInterface);
		  generatePropertySetterId(root, children, "    ", isInterface);
		  generatePropertySetterName(root, children, "    ", isInterface);
		  generatePropertyMaker(root, children, "    ", isInterface, inheritedChildren);
		  generatePropertyTypeGetter(root, children, "    ", isInterface);
		  generateChildAdder(root, children, "    ", classname, isInterface);
		}
		generateFhirType(structure.getName());
      
//      // check for mappings
//      for (String map : root.getMappings().keySet()) {
//        if ("http://hl7.org/fhir/workflow".equals(map)) {
//          String namenn = root.getMapping(map);
//          if (patterns.containsKey(namenn)) {
//            generateImpl(namenn, patterns.get(namenn), upFirst(name), root, version, genDate);
//          }
//        }
//      }

		generateCopy(root, children, classname, false, isAbstract, isInterface);
    if (hasChildren) {
		  generateEquals(root, children, classname, false, isAbstract, isInterface);
		  generateIsEmpty(root, children, classname, false, isAbstract, isInterface);
    }

		if (clss == JavaGenClass.Resource && !isAbstract) {
		  write("  @Override\r\n");
		  write("  public ResourceType getResourceType() {\r\n");
		  write("    return ResourceType."+structure.getName()+";\r\n");
		  write("   }\r\n");
		  write("\r\n"); 
		} else if (isAbstract && Utilities.noString(supertype)) {
      write("\r\n"); 
      write("  @Override\r\n"); 
      write("  public String getIdBase() {\r\n"); 
      write("    return getId();\r\n"); 
      write("  }\r\n"); 
      write("  \r\n");
      write("  @Override\r\n");
      write("  public void setIdBase(String value) {\r\n");
      write("    setId(value);\r\n");
      write("  }\r\n");
		  write("  public abstract ResourceType getResourceType();\r\n");
		} else if (isAbstract && Utilities.noString(supertype)) {
      write("  @Override\r\n"); 
      write("  public String getIdBase() {\r\n"); 
      write("    return getId();\r\n"); 
      write("  }\r\n"); 
      write("  \r\n");
      write("  @Override\r\n");
      write("  public void setIdBase(String value) {\r\n");
      write("    setId(value);\r\n");
      write("  }\r\n");
		}		

		// Write resource fields which can be used as constants in client code
		// to refer to standard search params
		Set<String> spcodes = new HashSet<>();
		for (SearchParameter sp : searchParams) {
		  String code = sp.getCode();
		  if (!spcodes.contains(code)) {
		    spcodes.add(code);

		    /* 
		     * For composite codes we want to find the two param this is a composite
		     * of. We generate search parameter constants which reference the 
		     * component parts of the composite.  
		     */
		    if (sp.getType() == SearchParamType.COMPOSITE) {
		      if (code.endsWith("-[x]")) {
		        // partialCode will have "value" in this example
		        String partialCode = code.substring(0, code.length() - 4);
		        partialCode = partialCode.substring(partialCode.lastIndexOf('-') + 1);

		        // rootCode will have "component-code"
		        String rootCode = code.substring(0, code.indexOf("-" + partialCode));

		        /*
		         * If the composite has the form "foo-bar[x]" we expand this to create 
		         * a constant for each of the possible [x] values, so that client have
		         * static binding to the individual possibilities. AFAIK this is only
		         * used right now in Observation (e.g. for code-value-[x]) 
		         */
		        for (SearchParameter nextCandidate : searchParams) {
		          if (nextCandidate.getCode().startsWith(partialCode)) {
		            String nextCompositeCode = rootCode + "-" + nextCandidate.getCode();
		            String[] compositeOf = new String[] { rootCode, nextCandidate.getCode() };
		            writeSearchParameterField(name, clss, isAbstract, sp, nextCompositeCode, compositeOf, searchParams, name);
		          }
		        }
		      } else {
		        SearchParameter comp0 = definitions.getSearchParams().get(sp.getComponent().get(0).getDefinition());
		        SearchParameter comp1 = definitions.getSearchParams().get(sp.getComponent().get(1).getDefinition());
		        if (comp0 == null) {
		          throw new Error("Couldn't find composite component " + sp.getComponent().get(0).getDefinition() + " on "+root.getName());
		        }
		        if (comp1 == null) {
		          throw new Error("Couldn't find composite component " + sp.getComponent().get(1).getDefinition() + " on "+root.getName());
		        }
		        String[] compositeOf = new String[] { comp0.getCode(), comp1.getCode() };
		        writeSearchParameterField(name, clss, isAbstract, sp, sp.getCode(), compositeOf, searchParams, name);
		      }  
		    } else if (code.contains("[x]")) {
		      /*
		       * We only know how to handle search parameters with [x] in the name
		       * where it's a composite, and the [x] comes last. Are there other possibilities?
		       */
		      throw new Exception("Unable to generate constant for search parameter: " + code);
		    } else {
		      writeSearchParameterField(name, clss, isAbstract, sp, code, null, searchParams, name);
		    }
		  }
		}

		if (config.getAdornments().containsKey(classname)) {
      write("// Manual code (from Configuration.txt)t:\r\n");
		  write(config.getAdornments().get(classname)+"\r\n");
      write("// end addition\r\n");
		}
		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();
	}

	private ElementDefinition matchingInheritedElement(List<ElementDefinition> children, ElementDefinition m) {
    String mtail = m.getPath().substring(m.getPath().indexOf("."));
    for (ElementDefinition t : children) {
      String ttail = t.getPath().substring(t.getPath().indexOf("."));
      if (ttail.equals(mtail)) {
        return t;
      }
      
    }
    return null;
  }

  private List<ElementDefinition> getAbstractChildren(StructureDefinition structure) {
	  if (!structure.hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-interface")) {
	    return new ArrayList<>();
	  }
	  List<ElementDefinition> res = new ArrayList<>();
	  StructureDefinition sdb = definitions.getStructures().get(structure.getBaseDefinition());
	  res.addAll(getAbstractChildren(sdb));
	  res.addAll(filterChildren(ProfileUtilities.getChildList(structure, structure.getSnapshot().getElementFirstRep())));
	  return res;
	}

	private List<ElementDefinition> filterInherited(List<ElementDefinition> inherited, List<ElementDefinition> children) {
	  List<ElementDefinition> res = new ArrayList<>();
	  for (ElementDefinition t : inherited) {
	    if (!hasMatchingChild(children, t)) {
	      res.add(t);
	    }
	  }
	  return res;
	}

	private boolean hasMatchingChild(List<ElementDefinition> children, ElementDefinition m) {
	  String mtail = m.getPath().substring(m.getPath().indexOf("."));
	  for (ElementDefinition t : children) {
	    String ttail = t.getPath().substring(t.getPath().indexOf("."));
	    if (ttail.equals(mtail)) {
	      return true;
	    }
	    
	  }
	  return false;
	}

//  private void generateImpl(String namenn, ResourceDefn resourceDefn, String jn, ElementDefinition root, String version, Date genDate) throws Exception {
//// TODO - restore this 
////    write("  public "+namenn+" get"+namenn+"() {\r\n"); 
////    write("    return new "+jn+namenn+"Impl(this);\r\n"); 
////    write("  }\r\n"); 
////
////    // now, generate the implementation
////    JavaPatternImplGenerator jrg = new JavaPatternImplGenerator(new FileOutputStream(javaPatternDir+jn+namenn+"Impl.java"), definitions, adornments, enumInfo);
////    jrg.generate(resourceDefn.getRoot(), jn, JavaGenClass.Resource, null, genDate, version, false, null, null, namenn, root);
////    jrg.close();
////
//  }

  private void writeSearchParameterField(String name, JavaGenClass clss, boolean isAbstract, SearchParameter sp, String code, String[] theCompositeOf, List<SearchParameter> searchParams, String rn) throws IOException {
    String constName = cleanSpName(code).toUpperCase();
    
    /*
     * SearchParamDefinition (SP_[name])
     */
    write(" /**\r\n"); 
    write("   * Search parameter: <b>" + code + "</b>\r\n"); 
    write("   * <p>\r\n");
    write("   * Description: <b>" + sp.getDescription() + "</b><br>\r\n"); 
    write("   * Type: <b>"+ sp.getType().toCode() + "</b><br>\r\n");
    write("   * Path: <b>" + sp.getExpression() + "</b><br>\r\n"); 
    write("   * </p>\r\n");
    write("   */\r\n");
    write("  @SearchParamDefinition(name=\"" + code + "\", path=\"" + defaultString(sp.getExpression()) + "\", description=\""+Utilities.escapeJava(sp.getDescription())+"\", type=\""+sp.getType().toCode() + "\"");
    if (theCompositeOf != null && theCompositeOf.length > 0) {
      write(", compositeOf={");
      for (int i = 0; i < theCompositeOf.length; i++) {
        if (i > 0) {
          write(", ");
        }
        write("\"" + theCompositeOf[i] + "\"");
      }
      write("}");
    }

    Set<String> providesMembershipIn = new TreeSet<String>();
    for (CompartmentDefinition next : this.definitions.getCompartments().getList()) {
      for (CompartmentDefinitionResourceComponent nextEntry : next.getResource()) {
        if (nextEntry.getCode().equals(upFirst(name))) {
          for (StringType nextPart : nextEntry.getParam()) {
            if (nextPart.toString().equals(code)) {
              providesMembershipIn.add(next.getName());
            }
          }
        }
      }
    }

    if (providesMembershipIn.size() > 0) {
      write(", providesMembershipIn={ ");
      boolean first = true;
      for (String next : providesMembershipIn) {
        if (first) {
          first = false;
        } else {
          write(", ");
        }
        write("@ca.uhn.fhir.model.api.annotation.Compartment(name=\"" + upFirst(next) + "\")");
      }
      write(" }");
    }

    Set<String> targets = new TreeSet<>();
    for (CodeType c : sp.getTarget()) {
      targets.add(c.toString());
    }
    if (targets != null && !targets.isEmpty() && !targets.contains("Any")) {
      write(", target={");
      boolean first = true;
      for (String nextTarget : targets) {
        if (first) {
          first = false;
        } else {
          write(", ");
        }
        write("List".equals(nextTarget) ? "ListResource" : nextTarget);
        write(".class");
      }
      write(" }");
    }
    
    write(" )\r\n");
    write("  public static final String SP_"+constName+" = \""+code+"\";\r\n");

    String genericTypes = "";
    if (theCompositeOf != null && theCompositeOf.length > 0) {
      SearchParameter typeDef0 = findSearchParam(searchParams, theCompositeOf[0]);
      SearchParameter typeDef1 = findSearchParam(searchParams, theCompositeOf[1]);
      genericTypes = "<ca.uhn.fhir.rest.gclient." + upFirst(typeDef0.getType().toCode()) + "ClientParam" + ", ca.uhn.fhir.rest.gclient." + upFirst(typeDef1.getType().toCode()) + "ClientParam>";
    }
    
    /*
     * Client parameter ([name])
     */
    write(" /**\r\n"); 
    write("   * <b>Fluent Client</b> search parameter constant for <b>" + code + "</b>\r\n"); 
    write("   * <p>\r\n");
    write("   * Description: <b>" + sp.getDescription() + "</b><br>\r\n"); 
    write("   * Type: <b>"+ sp.getType().toCode() + "</b><br>\r\n");
    write("   * Path: <b>" + sp.getExpression() + "</b><br>\r\n"); 
    write("   * </p>\r\n");
    write("   */\r\n");
    write("  public static final ca.uhn.fhir.rest.gclient." + upFirst(sp.getType().toCode()) + "ClientParam" + genericTypes + " " + constName + " = new ca.uhn.fhir.rest.gclient." + upFirst(sp.getType().toCode()) + "ClientParam" + genericTypes + "(SP_" + constName + ");\r\n\r\n"); 
    
    if (sp.getType() == SearchParamType.REFERENCE && clss == JavaGenClass.Resource && !isAbstract) {
      String incName = upFirst(name) + ":" + code;
      write("/**\r\n"); 
      write("   * Constant for fluent queries to be used to add include statements. Specifies\r\n"); 
      write("   * the path value of \"<b>" + incName + "</b>\".\r\n" );
      write("   */\r\n" );
      write("  public static final ca.uhn.fhir.model.api.Include INCLUDE_" + cleanSpName(code).toUpperCase() + " = new ca.uhn.fhir.model.api.Include(\"" + incName + "\").toLocked();\r\n\r\n");
    }
  }

  private SearchParameter findSearchParam(List<SearchParameter> searchParams, String code) {
    for (SearchParameter sp : searchParams) {
      if (sp.getCode().equals(code))
        return sp;
    }
    return null;
  }

  private List<ElementDefinition> filterChildren(List<ElementDefinition> childList) {
    List<ElementDefinition> res = new ArrayList<>();
    res.addAll(childList);
    List<ElementDefinition> r = new ArrayList<>();
    for (ElementDefinition t : childList) {
      if (!t.getPath().equals(t.getBase().getPath())) {
        r.add(t);
      }
    }
    res.removeAll(r);
    return res;
  }

  private String defaultString(String expression) {
    return expression == null ? "" : expression;
  }

  private void generateTypeSpecificConstructors(String theName) throws IOException {
    if ("Coding".equals(theName)) {
      write("    /**\r\n"); 
      write(    "     * Convenience constructor\r\n" ); 
      write(    "     * \r\n" );
      write(    "     * @param theSystem The {@link #setSystem(String) code system}\r\n"); 
      write(    "     * @param theCode The {@link #setCode(String) code}\r\n" );
      write(    "     * @param theDisplay The {@link #setDisplay(String) human readable display}\r\n"); 
      write(    "     */\r\n" );
      write(    "      public Coding(String theSystem, String theCode, String theDisplay) {\r\n"); 
      write(    "        setSystem(theSystem);\r\n");
      write(    "        setCode(theCode);\r\n");
      write(    "        setDisplay(theDisplay);\r\n"); 
      write(    "      }\r\n");
    }
    if ("Extension".equals(theName)) {
          write("    /**\r\n"); 
          write("     * Constructor\r\n"); 
          write("     */\r\n"); 
          write("    public Extension(String theUrl, IBaseDatatype theValue) {\r\n"); 
          write("      setUrl(theUrl);\r\n"); 
          write("      setValue(theValue);\r\n"); 
          write("    }\r\n"); 
          write("\r\n");
    } else if ("Reference".equals(theName)) {
      write("    /**\r\n"); 
          write("     * Constructor\r\n"); 
          write("     * \r\n"); 
          write("     * @param theReference The given reference string (e.g. \"Patient/123\" or \"http://example.com/Patient/123\")\r\n"); 
          write("     */\r\n"); 
          write("    public Reference(String theReference) {\r\n"); 
          write("      super(theReference);\r\n"); 
          write("    }\r\n"); 
          write("\r\n"); 
          write("    /**\r\n"); 
          write("     * Constructor\r\n"); 
          write("     * \r\n"); 
          write("     * @param theReference The given reference as an IdType (e.g. \"Patient/123\" or \"http://example.com/Patient/123\")\r\n"); 
          write("     */\r\n"); 
          write("    public Reference(IIdType theReference) {\r\n"); 
          write("      super(theReference);\r\n"); 
          write("    }\r\n"); 
          write("\r\n"); 
          write("    /**\r\n"); 
          write("     * Constructor\r\n"); 
          write("     * \r\n"); 
          write("     * @param theResource The resource represented by this reference\r\n"); 
          write("     */\r\n"); 
          write("    public Reference(IAnyResource theResource) {\r\n"); 
          write("      super(theResource);\r\n"); 
          write("    }\r\n"); 
          write("\r\n");
    } else if ("Quantity".equals(theName)) {
      write(" /**\r\n"); 
          write("   * Convenience constructor\r\n"); 
          write("   * \r\n"); 
          write("   * @param theValue The {@link #setValue(double) value}\r\n"); 
          write("   */\r\n"); 
          write("  public Quantity(double theValue) {\r\n"); 
          write("    setValue(theValue);\r\n"); 
          write("  }\r\n"); 
          write("\r\n"); 
          write("  /**\r\n"); 
          write("   * Convenience constructor\r\n"); 
          write("   * \r\n"); 
          write("   * @param theValue The {@link #setValue(long) value}\r\n"); 
          write("   */\r\n"); 
          write("  public Quantity(long theValue) {\r\n"); 
          write("    setValue(theValue);\r\n"); 
          write("  }\r\n"); 
          write("  \r\n"); 
          write("  /**\r\n"); 
          write("   * Convenience constructor\r\n"); 
          write("   * \r\n"); 
          write("   * @param theComparator The {@link #setComparator(QuantityComparator) comparator}\r\n"); 
          write("   * @param theValue The {@link #setValue(BigDecimal) value}\r\n"); 
          write("   * @param theSystem The {@link #setSystem(String)} (the code system for the units}\r\n"); 
          write("   * @param theCode The {@link #setCode(String)} (the code for the units}\r\n"); 
          write("   * @param theUnit The {@link #setUnit(String)} (the human readable display name for the units}\r\n"); 
          write("   */\r\n"); 
          write("  public Quantity(QuantityComparator theComparator, double theValue, String theSystem, String theCode, String theUnit) {\r\n"); 
          write("    setValue(theValue);\r\n"); 
          write("    setComparator(theComparator);\r\n"); 
          write("    setSystem(theSystem);\r\n"); 
          write("    setCode(theCode);\r\n"); 
          write("    setUnit(theUnit);\r\n"); 
          write("  }\r\n"); 
          write("\r\n"); 
          write("  /**\r\n"); 
          write("   * Convenience constructor\r\n"); 
          write("   * \r\n"); 
          write("   * @param theComparator The {@link #setComparator(QuantityComparator) comparator}\r\n"); 
          write("   * @param theValue The {@link #setValue(BigDecimal) value}\r\n"); 
          write("   * @param theSystem The {@link #setSystem(String)} (the code system for the units}\r\n"); 
          write("   * @param theCode The {@link #setCode(String)} (the code for the units}\r\n"); 
          write("   * @param theUnit The {@link #setUnit(String)} (the human readable display name for the units}\r\n"); 
          write("   */\r\n"); 
          write("  public Quantity(QuantityComparator theComparator, long theValue, String theSystem, String theCode, String theUnit) {\r\n"); 
          write("    setValue(theValue);\r\n"); 
          write("    setComparator(theComparator);\r\n"); 
          write("    setSystem(theSystem);\r\n"); 
          write("    setCode(theCode);\r\n"); 
          write("    setUnit(theUnit);\r\n"); 
          write("  }\r\n"); 
          write("");
    }
  }

  private void generateTypeSpecificAccessors(String name) throws IOException {
    if (upFirst(name).equals("DomainResource")) {
      write("    /**\r\n"); 
          write("     * Returns a list of extensions from this element which have the given URL. Note that\r\n"); 
          write("     * this list may not be modified (you can not add or remove elements from it)\r\n"); 
          write("     */\r\n"); 
          write("    public List<Extension> getExtensionsByUrl(String theUrl) {\r\n"); 
          write("      org.apache.commons.lang3.Validate.notBlank(theUrl, \"theUrl must be provided with a value\");\r\n"); 
          write("      ArrayList<Extension> retVal = new ArrayList<Extension>();\r\n"); 
          write("      for (Extension next : getExtension()) {\r\n"); 
          write("        if (theUrl.equals(next.getUrl())) {\r\n"); 
          write("          retVal.add(next);\r\n"); 
          write("        }\r\n"); 
          write("      }\r\n"); 
          write("      return Collections.unmodifiableList(retVal);\r\n"); 
          write("    }\r\n"); 
          write("\r\n"); 
          write("    /**\r\n"); 
          write("     * Returns a list of modifier extensions from this element which have the given URL. Note that\r\n"); 
          write("     * this list may not be modified (you can not add or remove elements from it)\r\n"); 
          write("     */\r\n"); 
          write("    public List<Extension> getModifierExtensionsByUrl(String theUrl) {\r\n"); 
          write("      org.apache.commons.lang3.Validate.notBlank(theUrl, \"theUrl must be provided with a value\");\r\n"); 
          write("      ArrayList<Extension> retVal = new ArrayList<Extension>();\r\n"); 
          write("      for (Extension next : getModifierExtension()) {\r\n"); 
          write("        if (theUrl.equals(next.getUrl())) {\r\n"); 
          write("          retVal.add(next);\r\n"); 
          write("        }\r\n"); 
          write("      }\r\n"); 
          write("      return Collections.unmodifiableList(retVal);\r\n"); 
          write("    }\r\n"); 
          write("\r\n");
    }
    if (upFirst(name).equals("Element")) {
      write("   /**\r\n"); 
          write("    * Returns an unmodifiable list containing all extensions on this element which \r\n"); 
          write("    * match the given URL.\r\n"); 
          write("    * \r\n"); 
          write("    * @param theUrl The URL. Must not be blank or null.\r\n"); 
          write("    * @return an unmodifiable list containing all extensions on this element which \r\n"); 
          write("    * match the given URL\r\n"); 
          write("    */\r\n"); 
          write("   public List<Extension> getExtensionsByUrl(String theUrl) {\r\n"); 
          write("     org.apache.commons.lang3.Validate.notBlank(theUrl, \"theUrl must not be blank or null\");\r\n"); 
          write("     ArrayList<Extension> retVal = new ArrayList<Extension>();\r\n"); 
          write("     for (Extension next : getExtension()) {\r\n"); 
          write("       if (theUrl.equals(next.getUrl())) {\r\n"); 
          write("         retVal.add(next);\r\n"); 
          write("       }\r\n"); 
          write("     }\r\n"); 
          write("     return java.util.Collections.unmodifiableList(retVal);\r\n"); 
          write("   }\r\n");
      write("  public boolean hasExtension(String theUrl) {\r\n");
      write("    return !getExtensionsByUrl(theUrl).isEmpty(); \r\n");
      write("  }\r\n");
      write("\r\n");
      write("  public String getExtensionString(String theUrl) throws FHIRException {\r\n");
      write("    List<Extension> ext = getExtensionsByUrl(theUrl); \r\n");
      write("    if (ext.isEmpty()) \r\n");
      write("      return null; \r\n");
      write("    if (ext.size() > 1) \r\n");
      write("      throw new FHIRException(\"Multiple matching extensions found\");\r\n");
      write("    if (!ext.get(0).getValue().isPrimitive())\r\n");
      write("      throw new FHIRException(\"Extension could not be converted to a string\");\r\n");
      write("    return ext.get(0).getValue().primitiveValue();\r\n");
      write("  }\r\n");
      write("\r\n");
    }
    if (upFirst(name).equals("Bundle") || upFirst(name).equals("BundleEntryComponent")) {
		  write(" /**\r\n"); 
		      write("   * Returns the {@link #getLink() link} which matches a given {@link BundleLinkComponent#getRelation() relation}. \r\n"); 
		      write("   * If no link is found which matches the given relation, returns <code>null</code>. If more than one\r\n"); 
		      write("   * link is found which matches the given relation, returns the first matching BundleLinkComponent.\r\n"); 
		      write("   * \r\n"); 
		      write("   * @param theRelation\r\n"); 
		      write("   *            The relation, such as \"next\", or \"self. See the constants such as {@link IBaseBundle#LINK_SELF} and {@link IBaseBundle#LINK_NEXT}.\r\n"); 
		      write("   * @return Returns a matching BundleLinkComponent, or <code>null</code>\r\n"); 
		      write("   * @see IBaseBundle#LINK_NEXT\r\n"); 
		      write("   * @see IBaseBundle#LINK_PREV\r\n"); 
		      write("   * @see IBaseBundle#LINK_SELF\r\n"); 
		      write("   */\r\n"); 
		      write("  public BundleLinkComponent getLink(String theRelation) {\r\n"); 
		      write("    org.apache.commons.lang3.Validate.notBlank(theRelation, \"theRelation may not be null or empty\");\r\n"); 
		      write("    for (BundleLinkComponent next : getLink()) {\r\n"); 
		      write("      if (theRelation.equals(next.getRelation())) {\r\n"); 
		      write("        return next;\r\n"); 
		      write("      }\r\n"); 
		      write("    }\r\n"); 
		      write("    return null;\r\n"); 
		      write("  }\r\n"); 
		      write("\r\n"); 
		      write("  /**\r\n"); 
		      write("   * Returns the {@link #getLink() link} which matches a given {@link BundleLinkComponent#getRelation() relation}. \r\n"); 
		      write("   * If no link is found which matches the given relation, creates a new BundleLinkComponent with the\r\n"); 
		      write("   * given relation and adds it to this Bundle. If more than one\r\n"); 
		      write("   * link is found which matches the given relation, returns the first matching BundleLinkComponent.\r\n"); 
		      write("   * \r\n"); 
		      write("   * @param theRelation\r\n"); 
		      write("   *            The relation, such as \"next\", or \"self. See the constants such as {@link IBaseBundle#LINK_SELF} and {@link IBaseBundle#LINK_NEXT}.\r\n"); 
		      write("   * @return Returns a matching BundleLinkComponent, or <code>null</code>\r\n"); 
		      write("   * @see IBaseBundle#LINK_NEXT\r\n"); 
		      write("   * @see IBaseBundle#LINK_PREV\r\n"); 
		      write("   * @see IBaseBundle#LINK_SELF\r\n"); 
		      write("   */\r\n"); 
		      write("  public BundleLinkComponent getLinkOrCreate(String theRelation) {\r\n"); 
		      write("    org.apache.commons.lang3.Validate.notBlank(theRelation, \"theRelation may not be null or empty\");\r\n"); 
		      write("    for (BundleLinkComponent next : getLink()) {\r\n"); 
		      write("      if (theRelation.equals(next.getRelation())) {\r\n"); 
		      write("        return next;\r\n"); 
		      write("      }\r\n"); 
		      write("    }\r\n"); 
		      write("    BundleLinkComponent retVal = new BundleLinkComponent();\r\n"); 
		      write("    retVal.setRelation(theRelation);\r\n"); 
		      write("    getLink().add(retVal);\r\n"); 
		      write("    return retVal;\r\n"); 
		      write("  }\r\n"); 
		      write("");
		}
    if (upFirst(name).equals("HumanName")) {
      write(" /**\r\n"); 
          write("  /**\r\n"); 
          write("   * Returns all repetitions of {@link #getGiven() given name} as a space separated string\r\n"); 
          write("   * \r\n"); 
          write("   * @see DatatypeUtil#joinStringsSpaceSeparated(List)\r\n"); 
          write("   */\r\n"); 
          write("  public String getGivenAsSingleString() {\r\n"); 
          write("    return joinStringsSpaceSeparated(getGiven());\r\n"); 
          write("  }\r\n"); 
          write("\r\n"); 
          write("  /**\r\n"); 
          write("   * Returns all repetitions of {@link #getPrefix() prefix name} as a space separated string\r\n"); 
          write("   * \r\n"); 
          write("   * @see DatatypeUtil#joinStringsSpaceSeparated(List)\r\n"); 
          write("   */\r\n"); 
          write("  public String getPrefixAsSingleString() {\r\n"); 
          write("    return joinStringsSpaceSeparated(getPrefix());\r\n"); 
          write("  }\r\n"); 
          write("\r\n"); 
          write("  /**\r\n"); 
          write("   * Returns all repetitions of {@link #getSuffix() suffix} as a space separated string\r\n"); 
          write("   * \r\n"); 
          write("   * @see DatatypeUtil#joinStringsSpaceSeparated(List)\r\n"); 
          write("   */\r\n"); 
          write("  public String getSuffixAsSingleString() {\r\n"); 
          write("    return joinStringsSpaceSeparated(getSuffix());\r\n"); 
          write("  }\r\n"); 
          write("\r\n"); 
          write("  /**\r\n"); 
          write("   * Returns all of the components of the name (prefix, given, family, suffix) as a single string with a single spaced\r\n"); 
          write("   * string separating each part.\r\n"); 
          write("   * <p>\r\n"); 
          write("   * If none of the parts are populated, returns the {@link #getTextElement() text} element value instead.\r\n"); 
          write("   * </p>\r\n"); 
          write("   */\r\n"); 
          write("  public String getNameAsSingleString() {\r\n"); 
          write("    List<StringType> nameParts = new ArrayList<StringType>();\r\n"); 
          write("    nameParts.addAll(getPrefix());\r\n"); 
          write("    nameParts.addAll(getGiven());\r\n"); 
          write("    nameParts.add(getFamilyElement());\r\n"); 
          write("    nameParts.addAll(getSuffix());\r\n"); 
          write("    if (nameParts.size() > 0) {\r\n"); 
          write("      return joinStringsSpaceSeparated(nameParts);\r\n"); 
          write("    } else {\r\n"); 
          write("      return getTextElement().getValue();\r\n"); 
          write("    }\r\n"); 
          write("  }\r\n"); 
          write("\r\n"); 
          write("  /**\r\n"); 
          write("   * Joins a list of strings with a single space (' ') between each string\r\n"); 
          write("   * \r\n"); 
          write("   * TODO: replace with call to ca.uhn.fhir.util.DatatypeUtil.joinStringsSpaceSeparated when HAPI upgrades to 1.4\r\n"); 
          write("   */\r\n"); 
          write("  private static String joinStringsSpaceSeparated(List<? extends IPrimitiveType<String>> theStrings) {\r\n"); 
          write("    StringBuilder b = new StringBuilder();\r\n"); 
          write("    for (IPrimitiveType<String> next : theStrings) {\r\n"); 
          write("      if (next.isEmpty()) {\r\n"); 
          write("        continue;\r\n"); 
          write("      }\r\n"); 
          write("      if (b.length() > 0) {\r\n"); 
          write("        b.append(' ');\r\n"); 
          write("      }\r\n"); 
          write("      b.append(next.getValue());\r\n"); 
          write("    }\r\n"); 
          write("    return b.toString();\r\n"); 
          write("  }\r\n"); 
          write("");
    }
    if (upFirst(name).equals("Meta")) {
      write("    /**\r\n"); 
          write("     * Convenience method which adds a tag\r\n"); 
          write("     * \r\n"); 
          write("     * @param theSystem The code system\r\n"); 
          write("     * @param theCode The code\r\n"); 
          write("     * @param theDisplay The display name\r\n"); 
          write("     * @return Returns a reference to <code>this</code> for easy chaining\r\n"); 
          write("     */\r\n"); 
          write("    public Meta addTag(String theSystem, String theCode, String theDisplay) {\r\n"); 
          write("     addTag().setSystem(theSystem).setCode(theCode).setDisplay(theDisplay);\r\n"); 
          write("     return this;\r\n"); 
          write("    }\r\n"); 
          write("");
      write("    /**\r\n"); 
          write("     * Convenience method which adds a security tag\r\n"); 
          write("     * \r\n"); 
          write("     * @param theSystem The code system\r\n"); 
          write("     * @param theCode The code\r\n"); 
          write("     * @param theDisplay The display name\r\n"); 
          write("     * @return Returns a reference to <code>this</code> for easy chaining\r\n"); 
          write("     */\r\n"); 
          write("    public Meta addSecurity(String theSystem, String theCode, String theDisplay) {\r\n"); 
          write("     addSecurity().setSystem(theSystem).setCode(theCode).setDisplay(theDisplay);\r\n"); 
          write("     return this;\r\n"); 
          write("    }\r\n"); 
          write("");
          write("   /**\r\n" );
          write(    "   * Returns the first tag (if any) that has the given system and code, or returns\r\n"); 
          write(    "   * <code>null</code> if none\r\n"); 
          write(    "   */\r\n" );
          write(    "  public Coding getTag(String theSystem, String theCode) {\r\n"); 
          write (   "    for (Coding next : getTag()) {\r\n" );
          write  (  "      if (ca.uhn.fhir.util.ObjectUtil.equals(next.getSystem(), theSystem) && ca.uhn.fhir.util.ObjectUtil.equals(next.getCode(), theCode)) {\r\n" ); 
          write (   "        return next;\r\n" ); 
          write (   "      }\r\n" ); 
          write (   "    }\r\n" );
              write(    "    return null;\r\n" ); 
              write(     "  }\r\n" ); 
              write(     "\r\n" );
              write(     "  /**\r\n" );
              write(     "   * Returns the first security label (if any) that has the given system and code, or returns\r\n" ); 
              write(     "   * <code>null</code> if none\r\n"); 
              write(     "   */\r\n" );
              write(     "  public Coding getSecurity(String theSystem, String theCode) {\r\n"); 
              write(     "    for (Coding next : getTag()) {\r\n" );
              write(      "      if (ca.uhn.fhir.util.ObjectUtil.equals(next.getSystem(), theSystem) && ca.uhn.fhir.util.ObjectUtil.equals(next.getCode(), theCode)) {\r\n" ); 
              write(      "        return next;\r\n" ); 
              write(      "      }\r\n" ); 
              write(      "    }\r\n" );
              write(      "    return null;\r\n"); 
              write(      "  }\r\n");
    }
    if (upFirst(name).equals("Period")) {
      write("   /**\r\n");
      write("   * Sets the value for <b>start</b> ()\r\n"); 
      write("   *\r\n");
      write("     * <p>\r\n");
      write("     * <b>Definition:</b>\r\n");
      write("     * The start of the period. The boundary is inclusive.\r\n"); 
      write("     * </p> \r\n"); 
      write("   */\r\n");
      write("  public Period setStart( Date theDate,  TemporalPrecisionEnum thePrecision) {\r\n"); 
      write("    start = new DateTimeType(theDate, thePrecision); \r\n"); 
      write("    return this; \r\n"); 
      write("  }\r\n"); 
      write("\r\n");
      write("   /**\r\n");
      write("   * Sets the value for <b>end</b> ()\r\n"); 
      write("   *\r\n");
      write("     * <p>\r\n");
      write("     * <b>Definition:</b>\r\n");
      write("     * The end of the period. The boundary is inclusive.\r\n"); 
      write("     * </p> \r\n"); 
      write("   */\r\n");
      write("  public Period setEnd( Date theDate,  TemporalPrecisionEnum thePrecision) {\r\n"); 
      write("    end = new DateTimeType(theDate, thePrecision); \r\n"); 
      write("    return this; \r\n"); 
      write("  }\r\n"); 
      write("\r\n");
    }
    if (upFirst(name).equals("Reference")) {
      write(" /**\r\n"); 
          write("   * Convenience setter which sets the reference to the complete {@link IIdType#getValue() value} of the given\r\n"); 
          write("   * reference.\r\n"); 
          write("   *\r\n"); 
          write("   * @param theReference The reference, or <code>null</code>\r\n"); 
          write("   * @return \r\n"); 
          write("   * @return Returns a reference to this\r\n"); 
          write("   */\r\n"); 
          write("  public Reference setReferenceElement(IIdType theReference) {\r\n"); 
          write("    if (theReference != null) {\r\n"); 
          write("      setReference(theReference.getValue());\r\n"); 
          write("    } else {\r\n"); 
          write("      setReference(null);\r\n"); 
          write("    }\r\n"); 
          write("    return this;\r\n"); 
          write("  }\r\n"); 
          write("");
    }
  }

  private void generateFhirType(String path) throws IOException {
    write("  public String fhirType() {\r\n");
    write("    return \""+path+"\";\r\n\r\n");
    write("  }\r\n\r\n");
  }

  private String cleanSpName(String code) {
    StringBuilder b = new StringBuilder();
    for (char c : code.toCharArray())
      if (Character.isLetter(c)) {
        b.append(c);
      } else if (c == '-') {
        b.append('_');
      }
    return b.toString();
  }

  private String pipeSeparate(List<String> paths) {
    StringBuilder b = new StringBuilder();
    boolean first = true;
    for (String p : paths) {
      if (first)
        first = false;
      else
        b.append("|");
      b.append(p);
    }
    return b.toString();
  }

  private void jdoc(String indent, String text) throws IOException {
    write(indent+"/**\r\n");
		write(indent+" * "+text+"\r\n");
		write(indent+" */\r\n");
  }

	private void generateChildrenRegister(ElementDefinition p, List<ElementDefinition> children, String indent, boolean isAbstract, boolean isInterface, String rn) throws Exception {
	  write(indent+"  protected void listChildren(List<Property> children) {\r\n");
    write(indent+"    super.listChildren(children);\r\n");
	  for (ElementDefinition e : children) {
      if (!isInterface && !e.typeSummary().equals("xhtml")) {
	      write(indent+"    children.add(new Property(\""+e.getName()+"\", \""+resolvedTypeCode(e)+"\", \""+Utilities.escapeJava(replaceTitle(rn, e.getDefinition()))+"\", 0, "+(e.unbounded() ? "java.lang.Integer.MAX_VALUE" : e.getMax())+", "+getElementName(e.getName(), true)+"));\r\n");
      }
	  }
	  write(indent+"  }\r\n\r\n");  
    write(indent+"  @Override\r\n");
    write(indent+"  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {\r\n");
    write(indent+"    switch (_hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface && !e.typeSummary().equals("xhtml")) {
        write(indent+"    case "+propId(e.getName())+": /*"+e.getName()+"*/ ");
        write(" return new Property(\""+e.getName()+"\", \""+resolvedTypeCode(e)+"\", \""+Utilities.escapeJava(replaceTitle(rn, e.getDefinition()))+"\", 0, "+(e.unbounded() ? "java.lang.Integer.MAX_VALUE" : e.getMax())+", "+getElementName(e.getName(), true)+");\r\n");
        if (e.getName().endsWith("[x]")) {
          String n = e.getName().substring(0, e.getName().length()-3);
          write(indent+"    case "+propId(n)+": /*"+n+"*/ ");
          write(" return new Property(\""+e.getName()+"\", \""+resolvedTypeCode(e)+"\", \""+Utilities.escapeJava(replaceTitle(rn, e.getDefinition()))+"\", 0, "+(e.unbounded() ? "java.lang.Integer.MAX_VALUE" : e.getMax())+", "+getElementName(e.getName(), true)+");\r\n");
          if (e.typeSummary().equals("*")) {
            // master list in datatypes.html
            for (String t : new String[] {
                "base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", 
                "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Annotation", "Attachment", "CodeableConcept", 
                "Coding", "ContactPoint", "HumanName", "Identifier", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", 
                "Signature", "Timing", "Dosage"
                }) {
              String tn = n + Utilities.capitalize(t);
              write(indent+"    case "+propId(tn)+": /*"+tn+"*/ ");
              write(" return new Property(\""+e.getName()+"\", \""+resolvedTypeCode(e, t)+"\", \""+Utilities.escapeJava(replaceTitle(rn, e.getDefinition()))+"\", 0, "+(e.unbounded() ? "java.lang.Integer.MAX_VALUE" : e.getMax())+", "+getElementName(e.getName(), true)+");\r\n");
            }
          } else for (TypeRefComponent tr : e.getType()) {
            String tn = n + Utilities.capitalize(checkConstraint(tr.getCode()));
            write(indent+"    case "+propId(tn)+": /*"+tn+"*/ ");
            write(" return new Property(\""+e.getName()+"\", \""+resolvedTypeCode(e, tr.getCode())+"\", \""+Utilities.escapeJava(replaceTitle(rn, e.getDefinition()))+"\", 0, "+(e.unbounded() ? "java.lang.Integer.MAX_VALUE" : e.getMax())+", "+getElementName(e.getName(), true)+");\r\n");
          }
        }
      }
    }
    write(indent+"    default: return super.getNamedProperty(_hash, _name, _checkValid);\r\n");
    write(indent+"    }\r\n\r\n");  
    write(indent+"  }\r\n\r\n");  
  }
	
  private String resolvedTypeCode(ElementDefinition e) {
    return resolvedTypeCode(e, null);
  }
  
  private String resolvedTypeCode(ElementDefinition e, String tf) {
    if (e.hasContentReference()) {
      return e.getContentReference().replace("#",  "@");
    }
    StringBuilder tn = new StringBuilder();
    boolean first = true;
    for (TypeRefComponent t : e.getType()) {
      if ((tf == null || t.getWorkingCode().equals(tf)) && !Utilities.existsInList(t.getWorkingCode(), "Element", "BackboneElement")) {
        if (!first)
          tn.append("|");
        first = false;
        tn.append(t.getWorkingCode());
        if (t.hasTargetProfile()) {
          tn.append("(");
          boolean f = true;
          for (CanonicalType s : t.getTargetProfile()) {
            //          if (definitions.hasLogicalModel(s)) {
            //            for (String sn : definitions.getLogicalModel(s).getImplementations()) {
            //              if (!f)
            //                tn.append("|");
            //              f = false;
            //              tn.append(sn);
            //            }
            //          } else {
            if (!f)
              tn.append("|");
            f = false;
            String stn = s.asStringValue().substring(40);
            tn.append("Resource".equals(stn) ? "Any" : stn);
            //          }
          }
          tn.append(")");
        }
      }
    }
    return tn.toString();
	}

private void generatePropertyMaker(ElementDefinition p, List<ElementDefinition> children, String indent, boolean isInterface, List<ElementDefinition> inheritedChildren) throws Exception {
    write(indent+"  @Override\r\n");
    write(indent+"  public Base makeProperty(int hash, String name) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        ElementDefinition inh = inheritedChildren == null ? null : matchingInheritedElement(inheritedChildren, e);
        String tn = typeNames.get(e);
        if (!e.typeSummary().equals("xhtml")) {
          genPropMaker(indent, e, tn, e.getName(), inh);
        } else {
          write(indent+"    case "+propId("div")+": /*div*/\r\n");
          write("          if (div == null)\r\n");
          write("            div = new XhtmlNode(NodeType.Element, \"div\");\r\n");
          write("          return new StringType(new org.hl7.fhir.utilities.xhtml.XhtmlComposer(true).composeEx(this.div));\r\n");
        }
        if (e.getName().endsWith("[x]"))
          genPropMaker(indent, e, tn, e.getName().replace("[x]", ""), inh);
      }
    }
    write(indent+"    default: return super.makeProperty(hash, name);\r\n");
    write(indent+"    }\r\n\r\n");  
    write(indent+"  }\r\n\r\n");  
  }

  private void genPropMaker(String indent, ElementDefinition e, String tn, String elementname, ElementDefinition inh) throws IOException {
    write(indent+"    case "+propId(elementname)+": ");
    String name = e.getName().replace("[x]", "");
    if (isPrimitive(e.typeSummary()) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
      if (e.unbounded())
        write(" return add"+upFirst(getElementName(name, false))+"Element();\r\n");
      else if ("Reference.reference".equals(e.getPath()) && "Reference".equals(upFirst(getElementName(name, false))))
        write(" return get"+upFirst(getElementName(name, false))+"Element_();\r\n");
      else
        write(" return get"+upFirst(getElementName(name, false))+"Element();\r\n");
    } else if (e.typeSummary().equals("Resource") || e.typeSummary().equals("DomainResource")) {
      write("throw new FHIRException(\"Cannot make property "+e.getName()+" as it is not a complex type\"); // "+tn+"\r\n");
    } else if (e.unbounded()) {
      write(" return add"+upFirst(getElementName(name, false))+"(); \r\n");
    } else if (inh != null && inh.unbounded()) {
      write(" return get"+upFirst(getElementName(name, false))+"FirstRep();\r\n");
    } else  {
      write(" return get"+upFirst(getElementName(name, false))+"();\r\n");
    }
  }

  private void generatePropertySetterName(ElementDefinition p, List<ElementDefinition> children, String indent, boolean isInterface) throws Exception {
    write(indent+"  @Override\r\n");
    write(indent+"  public Base setProperty(String name, Base value) throws FHIRException {\r\n");
    boolean first = true;
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String tn = typeNames.get(e);
        if (first) 
          write(indent+"    ");
        else
          write(indent+"    } else ");
        first = false;
        write(           "if (name.equals(\""+e.getName()+"\")) {\r\n");
        String name = e.getName().replace("[x]", "");
        String cn = "("+tn+") value";
        if (!Utilities.existsInList(e.typeSummary(), "Element", "BackboneElement")) {
          if (e.typeSummary().equals("xhtml")) {
            cn = "TypeConvertor.castToXhtml(value)";
          } else if (tn.contains("Enumeration<")) { // enumeration
            write(indent+"      value = new "+tn.substring(tn.indexOf("<")+1, tn.length()-1)+"EnumFactory().fromType(TypeConvertor.castToCode(value));\r\n");
            cn = "(Enumeration) value";
          } else if (e.getType().size() == 1 && !e.typeSummary().equals("*") && !e.getType().get(0).getCode().startsWith("@")) { 
            cn = "TypeConvertor.castTo"+upFirst(checkConstraint(e.getType().get(0).getWorkingCode()))+"(value)";
          } else if (e.getType().size() > 0 && !e.getType().get(0).getCode().startsWith("@")) { 
            cn = "TypeConvertor.castToType(value)";
          }
        }
        if (e.unbounded()) {
          write(indent+"      this.get"+upFirst(getElementName(name, false))+"().add("+cn+");\r\n");
        } else {
          write(indent+"      this."+getElementName(name, true)+" = "+cn+"; // "+tn+"\r\n");
        }
      }
    }
    if (!first)
      write(indent+"    } else\r\n");
    write(indent+"      return super.setProperty(name, value);\r\n");
    if (!first)
      write(indent+"    return value;\r\n");
    write(indent+"  }\r\n\r\n");  
  }

  private void generatePropertySetterId(ElementDefinition p, List<ElementDefinition> children, String indent, boolean isInterface) throws Exception {
    write(indent+"  @Override\r\n");
    write(indent+"  public Base setProperty(int hash, String name, Base value) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String tn = typeNames.get(e);
        String name = e.getName().replace("[x]", "");
        write(indent+"    case "+propId(name)+": // "+name+"\r\n");
        String cn = "("+tn+") value";
        if (!Utilities.existsInList(e.typeSummary(), "Element", "BackboneElement")) {
          if (e.typeSummary().equals("xhtml")) {
            cn = "TypeConvertor.castToXhtml(value)";
          } if (tn.contains("Enumeration<")) { // enumeration
            write(indent+"      value = new "+tn.substring(tn.indexOf("<")+1, tn.length()-1)+"EnumFactory().fromType(TypeConvertor.castToCode(value));\r\n");
            cn = "(Enumeration) value";
          } else if (e.getType().size() == 1 && !e.typeSummary().equals("*") && !e.getType().get(0).getName().startsWith("@")) { 
            cn = "TypeConvertor.castTo"+upFirst(checkConstraint(e.getType().get(0).getWorkingCode()))+"(value)";
          } else if (e.getType().size() > 0 && !e.getType().get(0).getCode().startsWith("@")) { 
            cn = "TypeConvertor.castToType(value)";
          }
        }
        if (e.unbounded()) {
          write(indent+"      this.get"+upFirst(getElementName(name, false))+"().add("+cn+"); // "+tn+"\r\n");
        } else {
          write(indent+"      this."+getElementName(name, true)+" = "+cn+"; // "+tn+"\r\n");
        }
        write(indent+"      return value;\r\n");
      }
    }
    write(indent+"    default: return super.setProperty(hash, name, value);\r\n");
    write(indent+"    }\r\n\r\n");  
    write(indent+"  }\r\n\r\n");  
  }

  private void generatePropertyGetterId(ElementDefinition p, List<ElementDefinition> children, String indent, boolean isInterface) throws Exception {
    write(indent+"  @Override\r\n");
    write(indent+"  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String tn = typeNames.get(e);
        String name = e.getName().replace("[x]", "");
        write(indent+"    case "+propId(name)+": /*"+name+"*/ ");
        if (e.unbounded()) {
          write("return this."+getElementName(name, true)+" == null ? new Base[0] : this."+getElementName(name, true)+".toArray(new Base[this."+getElementName(name, true)+".size()]); // "+tn+"\r\n");
        } else if (e.typeSummary().equals("xhtml")) {
          write("return this."+getElementName(name, true)+" == null ? new Base[0] : new Base[] {new StringType(new org.hl7.fhir.utilities.xhtml.XhtmlComposer(true).composeEx(this."+getElementName(name, true)+"))}; // "+tn+"\r\n");
        } else {
          write("return this."+getElementName(name, true)+" == null ? new Base[0] : new Base[] {this."+getElementName(name, true)+"}; // "+tn+"\r\n");
        }
      }
    }
    write(indent+"    default: return super.getProperty(hash, name, checkValid);\r\n");
    write(indent+"    }\r\n\r\n");  
    write(indent+"  }\r\n\r\n");  
  }

  private void generatePropertyTypeGetter(ElementDefinition p, List<ElementDefinition> children, String indent, boolean isInterface) throws Exception {
    write(indent+"  @Override\r\n");
    write(indent+"  public String[] getTypesForProperty(int hash, String name) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String name = e.getName().replace("[x]", "");
        write(indent+"    case "+propId(name)+": /*"+name+"*/ ");
        if (e.hasContentReference()) {
          write("return new String[] {\""+e.getContentReference().replace("#", "@")+"\"};\r\n");
        } else {
          write("return new String[] {"+asCommaText(e.getType())+"};\r\n");
        }
      }
    }
    write(indent+"    default: return super.getTypesForProperty(hash, name);\r\n");
    write(indent+"    }\r\n\r\n");  
    write(indent+"  }\r\n\r\n");  
  }

  private String asCommaText(List<TypeRefComponent> types) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    Set<String> tset = new HashSet<String>();
    for (TypeRefComponent t : types) {
      if (!Utilities.existsInList(t.getWorkingCode(),  "Element", "BackboneElement") && !tset.contains(t.getName())) {
        b.append("\""+t.getName()+"\"");
        tset.add(t.getName());
      }
    }
    return b.toString();
  }

  private String propId(String name) {
    return Integer.toString(name.hashCode());
  }

  private void generateChildAdder(ElementDefinition p, List<ElementDefinition> children, String indent, String parent, boolean isInterface) throws Exception {
    write(indent+"  @Override\r\n");
    write(indent+"  public Base addChild(String name) throws FHIRException {\r\n");
    boolean first = true;
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        if (!e.typeSummary().equals("xhtml")) { 
          if (e.getType().size() <= 1 && !e.typeSummary().equals("*")) {
            String tn = typeNames.get(e);
            String name = e.getName();
            String namet = e.getName();
            first = generateChildAddItem(indent, parent, first, e, tn, name, namet);
          } else {
            for (TypeRefComponent t : getTypes(e.getType())) {
              String tn = getTypename(t);
              String name = e.getName().replace("[x]", "");
              String namet = e.getName().replace("[x]", upFirst(checkConstraint(t.getName())));
              first = generateChildAddItem(indent, parent, first, e, tn, name, namet);
            }
          }
        }
      }
    }
    if (!first)
      write(indent+"    else\r\n");
    write(indent+"      return super.addChild(name);\r\n");
    write(indent+"  }\r\n\r\n");  
  }

  private String checkConstraint(String name) {
    if ("SimpleQuantity".equals(name))
      return "Quantity";
    else
      return name;
  }

  private boolean generateChildAddItem(String indent, String parent, boolean first, ElementDefinition e, String tn, String name, String namet) throws IOException {
    if (first) 
      write(indent+"    ");
    else
      write(indent+"    else ");
    first = false;
    write(           "if (name.equals(\""+namet+"\")) {\r\n");
    if (isPrimitive(e.typeSummary()) || e.typeSummary().startsWith("canonical("))
      write(indent+"      throw new FHIRException(\"Cannot call addChild on a primitive type "+parent+"."+e.getName()+"\");\r\n"); 
    else if (isAbstract(e.typeSummary()))
      write(indent+"      throw new FHIRException(\"Cannot call addChild on an abstract type "+parent+"."+e.getName()+"\");\r\n"); 
    else if (e.unbounded()) {
      write(indent+"      return add"+upFirst(getElementName(name, false))+"();\r\n");
    } else {
      write(indent+"      this."+getElementName(name, true)+" = new "+tn+"();\r\n");
      write(indent+"      return this."+getElementName(name, true)+";\r\n");
    }
    write(indent+"    }\r\n");
    return first;
  }

  private List<TypeRefComponent> getTypes(List<TypeRefComponent> types) {
    if (types.size() == 1 && types.get(0).getName().equals("*")) {
      List<TypeRefComponent> t = new ArrayList<TypeRefComponent>();
      for (String s : TypesUtilities.wildcardTypes()) {
        t.add(new TypeRefComponent(new UriType(s)));
      }
      return t;
    }
    else
      return types;
  }

  private boolean isAbstract(String typeCode) {
    if (typeCode.equals("Resource"))
      return true;
    else
      return false;
  }

  private void generateConstructor(String className, List<ElementDefinition> params, String indent) throws IOException {
    write(indent+"/**\r\n");
    write(indent+" * Constructor\r\n");
    write(indent+" */\r\n");
    write(indent+"  public "+className+"(");
    boolean first = true;
    for (ElementDefinition e : params) {
      if (!first)
        write(", ");
      first = false;
      String tn = typeNames.get(e);
      if (definitions.hasPrimitiveType(e.typeSummary()) && !enums.contains(e)) {
        if ("xhtml".equals(e.typeSummary())) {
          tn = "XhtmlNode";
        } else {
          tn = getSimpleType(tn);
        }
       
      } else if (tn.startsWith("Enumeration<")) {
        tn = tn.substring(12, tn.length()-1);
      }
      String en = getElementName(e.getName(), true);
      write(tn +" "+en);
    }
    write(") {\r\n");
    write(indent+"    super();\r\n");
    for (ElementDefinition e : params) {
      String en = getElementName(e.getName(), true);
      if (e.unbounded()) {
        write(indent+"    this.add"+Utilities.capitalize(en)+"("+en+");\r\n");      
      } else {
        write(indent+"    this.set"+Utilities.capitalize(en).replace("Abstract_", "Abstract")+"("+en+");\r\n");
      }
    }
    write(indent+"  }\r\n\r\n");
  }

  private String upFirst(String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}
  
	private boolean hasList(List<ElementDefinition>  list) {
		for (ElementDefinition e : list) {
			if (!e.getName().equals("text")) {
				if (e.unbounded())
					return true;
			}
		}
		return false;
	}

  private boolean hasDecimal(List<ElementDefinition>  list) {
    for (ElementDefinition e : list) {
      if (isDefinedInThisClass(e)) {
        if (e.typeSummary().equals("decimal")) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasString(List<ElementDefinition>  list) {
    for (ElementDefinition e : list) {
      if (isDefinedInThisClass(e)) {
       if (Utilities.existsInList(e.typeSummary(), "string", "id", "code", "uri", "oid", "uuid", "url", "canonical"))
          return true;
      }
    }
    return false;
  }

  private boolean hasNestedTypes(List<ElementDefinition> list) {
    for (ElementDefinition e : list) {
      if (isDefinedInThisClass(e)) {
        if (Utilities.charCount(e.getPath(), '.') >= 2);
          return true;
      }
    } 
    return false;
  }

  private boolean hasSharedEnums(List<ElementDefinition> list) {
    for (ElementDefinition e : list) {
      if (isDefinedInThisClass(e)) {
        if (e.getBinding() != null && e.getBinding().hasUserData("shared"));
          return true;
      }
    } 
    return false;
  }

  private boolean hasXhtml(List<ElementDefinition>  list) {
    for (ElementDefinition e : list) {
      if (isDefinedInThisClass(e)) {
        if (e.typeSummary().contains("xhtml"))
          return true;
      }
    }
    return false;
  }


	private boolean isDefinedInThisClass(ElementDefinition e) {
    return e.getPath().equals(e.getBase().getPath());
  }

  private void generateEnum(ElementDefinition e, String name) throws Exception {
		String tn = typeNames.get(e);
		String tns = tn.substring(tn.indexOf("<")+1);
		tns = tns.substring(0, tns.length()-1);
		if (e.getBinding().hasUserData("shared"))
		  return;
    if (!e.getBinding().hasUserData("expansion")) {
      return;
    }
    
		ValueSet vs = (ValueSet) e.getBinding().getUserData("expansion");
		vs.setUserData("java-generated", true);
		List<ValueSetExpansionContainsComponent> codes = vs.getExpansion().getContains();
    String url = vs.getUrl();
    CommaSeparatedStringBuilder el = new CommaSeparatedStringBuilder();

		write("    public enum "+tns+" {\r\n");
		int l = codes.size();
		int i = 0;
		for (ValueSetExpansionContainsComponent c : codes) {
			i++;
			String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      el.append(cc);
      String definition = definitions.getCodeDefinition(c.getSystem(), c.getCode());
      write("        /**\r\n");
      write("         * "+Utilities.escapeJava(definition)+"\r\n");
      write("         */\r\n");      
			write("        "+cc.toUpperCase()+", \r\n");
		}
    write("        /**\r\n");
    write("         * added to help the parsers with the generic types\r\n");
    write("         */\r\n");      
    write("        NULL;\r\n");
    el.append("NULL");


		write("        public static "+tns+" fromCode(String codeString) throws FHIRException {\r\n");
		write("            if (codeString == null || \"\".equals(codeString))\r\n");
		write("                return null;\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
			String cc = Utilities.camelCase(c.getCode());
			cc = makeConst(cc);
			write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
			write("          return "+cc+";\r\n");
		}		
    write("        if (Configuration.isAcceptInvalidEnums())\r\n");
    write("          return null;\r\n");
    write("        else\r\n");
    write("          throw new FHIRException(\"Unknown "+tns+" code '\"+codeString+\"'\");\r\n");
		write("        }\r\n");	

		write("        public String toCode() {\r\n");
		write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
			String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
			write("            case "+cc+": return \""+c.getCode()+"\";\r\n");
		}   
		write("            default: return \"?\";\r\n");
		write("          }\r\n"); 
		write("        }\r\n"); 

    write("        public String getSystem() {\r\n");
    write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("            case "+cc+": return \""+c.getSystem()+"\";\r\n");
    }   
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getDefinition() {\r\n");
    write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      String definition = definitions.getCodeDefinition(c.getSystem(), c.getCode());
      write("            case "+cc+": return \""+Utilities.escapeJava(definition)+"\";\r\n");
    }   
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

    write("        public String getDisplay() {\r\n");
    write("          switch (this) {\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("            case "+cc+": return \""+Utilities.escapeJava(Utilities.noString(c.getDisplay()) ? c.getCode() : c.getDisplay())+"\";\r\n");
    }   
    write("            default: return \"?\";\r\n");
    write("          }\r\n"); 
    write("        }\r\n"); 

		write("    }\r\n");
		write("\r\n");

		
		write("  public static class "+tns+"EnumFactory implements EnumFactory<"+tns+"> {\r\n");
		write("    public "+tns+" fromCode(String codeString) throws IllegalArgumentException {\r\n");
		
		write("      if (codeString == null || \"\".equals(codeString))\r\n");
    write("            if (codeString == null || \"\".equals(codeString))\r\n");
    write("                return null;\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
      write("          return "+tns+"."+cc+";\r\n");
    }   
    write("        throw new IllegalArgumentException(\"Unknown "+tns+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 
    write("        public Enumeration<"+tns+"> fromType(Base code) throws FHIRException {\r\n");
    write("          if (code == null)\r\n");
    write("            return null;\r\n");
    write("          if (code.isEmpty())\r\n");
    write("            return new Enumeration<"+tns+">(this);\r\n");
    write("          String codeString = ((PrimitiveType) code).asStringValue();\r\n");
    write("          if (codeString == null || \"\".equals(codeString))\r\n");
    write("            return null;\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
      write("          return new Enumeration<"+tns+">(this, "+tns+"."+cc+");\r\n");
    }   
    write("        throw new FHIRException(\"Unknown "+tns+" code '\"+codeString+\"'\");\r\n");
    write("        }\r\n"); 

    write("    public String toCode("+tns+" code) {\r\n");
    for (ValueSetExpansionContainsComponent c : codes) {
      String cc = Utilities.camelCase(c.getCode());
      cc = makeConst(cc);
      write("      if (code == "+tns+"."+cc+")\r\n        return \""+c.getCode()+"\";\r\n");
    }
    write("      return \"?\";\r\n"); 
    write("      }\r\n"); 
    
    write("    public String toSystem("+tns+" code) {\r\n");
    write("      return code.getSystem();\r\n");
    write("      }\r\n"); 
    write("    }\r\n"); 
    write("\r\n");
//    enumInfo.put("org.hl7.fhir.r5.model."+name+"."+tns, url+"|"+el.toString());
	}

  private void generateType(StructureDefinition structure, ElementDefinition e, JavaGenClass clss, String rn, boolean isInterface) throws Exception {
		String tn = typeNames.get(e);

		StructureDefinition sd = definitions.getType(e.typeSummary());
		List<ElementDefinition> children = filterChildren(ProfileUtilities.getChildList(structure, e));
		write("    @Block()\r\n");
		write("    public static class "+tn+" extends "+sd.getName()+" implements "+(sd.getName().equals("Element") ? "IBaseDatatypeElement" : "IBaseBackboneElement")+" {\r\n");

		allfields = "";
		int i = 1;
		for (ElementDefinition c : children) {
			generateField(e, c, "        ", i++, structure);
		}
		write("        private static final long serialVersionUID = "+Long.toString(allfields.hashCode())+"L;\r\n\r\n");
    hashSum = hashSum + allfields.hashCode();

    List<ElementDefinition> mandatory = new ArrayList<ElementDefinition>();
    generateConstructor(tn, mandatory, "    ");
    for (ElementDefinition c : children) {
      if (c.isMandatory())
        mandatory.add(c);
    }
    if (mandatory.size() > 0)
      generateConstructor(tn, mandatory, "    ");
		
		for (ElementDefinition c : children) {
			generateAccessors(e, c, "        ", tn, null);
		}
		generateTypeSpecificAccessors(tn);
    generateChildrenRegister(e, children, "      ", false, isInterface, rn);
    generatePropertyGetterId(e, children, "    ", isInterface);
    generatePropertySetterId(e, children, "    ", isInterface);
    generatePropertySetterName(e, children, "    ", isInterface);
    generatePropertyMaker(e, children, "    ", isInterface, null);
    generatePropertyTypeGetter(e, children, "    ", isInterface);
    generateChildAdder(e, children, "    ", classname, isInterface);
    generateCopy(e, children, tn, true, false, isInterface);
    generateEquals(e, children, tn, true, false, isInterface);
    generateIsEmpty(e, children, tn, true, false, isInterface);
    generateFhirType(e.getPath());
    if (config.getAdornments().containsKey(tn)) {
      write("// added from java-adornments.txt:\r\n");
      write(config.getAdornments().get(tn)+"\r\n");
      write("// end addition\r\n");
    }
    write("  }\r\n");
		write("\r\n");

	}

  
  private void generateEquals(ElementDefinition e, List<ElementDefinition> children, String tn, boolean owner, boolean isAbstract, boolean isInterface) throws Exception {
    write("      @Override\r\n");
    write("      public boolean equalsDeep(Base other_) {\r\n");
    write("        if (!super.equalsDeep(other_))\r\n");
    write("          return false;\r\n");
    write("        if (!(other_ instanceof "+tn+"))\r\n");
    write("          return false;\r\n");
    write("        "+tn+" o = ("+tn+") other_;\r\n");
    write("        return ");
    boolean first = true;
    int col = 18;
    for (ElementDefinition c : children) {
      if (!isInterface) {
        if (first)
          first = false;
        else {
          write(" && ");
          col = col+4;
        }
        String name = getElementName(c.getName(), true);
        if (name.endsWith("[x]"))
          name = name.substring(0, name.length()-3);
        write("compareDeep("+name+", o."+name+", true)");
        col = col+21 + name.length()*2;
        if (col > 100) {
          col = 10;
          write("\r\n          ");
        }
      }
    }
    if (first)
      write("true"); 
    write(";\r\n");
    write("      }\r\n\r\n");  
    write("      @Override\r\n");
    write("      public boolean equalsShallow(Base other_) {\r\n");
    write("        if (!super.equalsShallow(other_))\r\n");
    write("          return false;\r\n");
    write("        if (!(other_ instanceof "+tn+"))\r\n");
    write("          return false;\r\n");
    write("        "+tn+" o = ("+tn+") other_;\r\n");
    write("        return ");
    first = true;
    col = 18;
    for (ElementDefinition c : children) {
      if (!isInterface) {
        if (isJavaPrimitive(c) && !"xhtml".equals(c.typeSummary())) {
          if (first)
            first = false;
          else {
            write(" && ");
            col = col+4;
          }
          String name = getElementName(c.getName(), true);
          if (name.endsWith("[x]"))
            name = name.substring(0, name.length()-3);
          write("compareValues("+name+", o."+name+", true)");
          col = col+21 + name.length()*2;
          if (col > 100) {
            col = 10;
            write("\r\n          ");
          }
        }
      }
    }
    if (first)
      write("true"); 
    write(";\r\n");
    write("      }\r\n\r\n");  
  }
  
	private void generateCopy(ElementDefinition e, List<ElementDefinition> children, String tn, boolean owner, boolean isAbstract, boolean isInterface) throws Exception {
	  if (isAbstract) {
      write("      public abstract "+tn+" copy();\r\n\r\n");
      write("      public void copyValues("+tn+" dst) {\r\n");
      if (!e.getName().equals("Element") && !e.getName().equals("Resource"))
        write("        super.copyValues(dst);\r\n");
	  } else {
      write("      public "+tn+" copy() {\r\n");
      write("        "+tn+" dst = new "+tn+"();\r\n");
      write("        copyValues(dst);\r\n");
      write("        return dst;\r\n");
      write("      }\r\n\r\n");
      write("      public void copyValues("+tn+" dst) {\r\n");
      write("        super.copyValues(dst);\r\n");
	  }
    for (ElementDefinition c : children) {
      if (!isInterface) {
	      String name = getElementName(c.getName(), true);
	      if (c.unbounded()) {
	        write("        if ("+name+" != null) {\r\n");
	        write("          dst."+name+" = new ArrayList<"+typeNames.get(c)+">();\r\n");
	        write("          for ("+typeNames.get(c)+" i : "+name+")\r\n");
	        write("            dst."+name+".add(i.copy());\r\n");
	        write("        };\r\n");
	      } else {
	        if (name.endsWith("[x]"))
	          name = name.substring(0, name.length()-3);
	        write("        dst."+name+" = "+name+" == null ? null : "+name+".copy();\r\n");
	      }
	    }
	  }
    write("      }\r\n\r\n");
    if (!owner && !isAbstract) {
      write("      protected "+tn+" typedCopy() {\r\n");
      write("        return copy();\r\n");
      write("      }\r\n\r\n");      
    }
  }

  private void generateIsEmpty(ElementDefinition e, List<ElementDefinition> children, String tn, boolean owner, boolean isAbstract, boolean isInterface) throws Exception {
    write("      public boolean isEmpty() {\r\n");
    write("        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(");
    int col = 70;
    boolean first = true;
    for (ElementDefinition c : children) {
      if (!isInterface) {
        if (first) {
          first = false;
        } else {
          write(", ");
        }
        col = col + 2;
        String name = getElementName(c.getName(), true);
        if (name.endsWith("[x]"))
          name = name.substring(0, name.length()-3);
        write(name);
        col = col + name.length() + 2;
        if (col > 100) {
          col = 10;
          write("\r\n          ");
        }
      }
    }
    write(");\r\n");
    write("      }\r\n\r\n");
  }

  private void scanNestedTypes(StructureDefinition structure, ElementDefinition root, List<ElementDefinition> children, String path, ElementDefinition e) throws Exception {
    String tn = null;
    if (e.typeSummary().equals("code") && e.hasBinding()) {
      ElementDefinitionBindingComponent cd = e.getBinding();
      if (isEnum(cd)) {
        ValueSet vs = definitions.getValuesets().get(cd.getValueSet()); 	
        if (vs != null) {
          tn = getCodeListType(vs.getName());
          if (!enumNames.contains(tn)) {
            enumNames.add(tn);
            enums.add(e);
          }
          typeNames.put(e,  "Enumeration<"+tn+">");
          e.setUserData("type", "Enumeration<"+tn+">");
        }
      }
		}
		if (tn == null) {
			if (e.getType().size() > 0 && !e.hasContentReference() && (!Utilities.existsInList(e.getType().get(0).getCode(), "Element", "BackboneElement"))) {
				tn = e.typeSummary();
//				if (clss != JavaGenClass.Resource) {
//					if (tn.equals("boolean")) tn = "Boolean";
//					else if (tn.equals("integer")) tn = "Integer";
//					else if (tn.equals("decimal")) tn = "Decimal";
//					else if (tn.equals("base64Binary")) tn = "Base64Binary";
//					else if (tn.equals("instant")) tn = "Instant";
//					else if (tn.equals("string")) tn = "StringType";
//          else if (tn.equals("uri")) tn = "Uri";
//          else if (tn.equals("xml:lang")) tn = "Code";
//					else if (tn.equals("code")) tn = "Code";
//					else if (tn.equals("oid")) tn = "Oid";
//          else if (tn.equals("uuid")) tn = "Uuid";
//					else if (tn.equals("sid")) tn = "Sid";
//					else if (tn.equals("id")) tn = "Id";
//					else if (tn.equals("date")) tn = "Date";
//					else if (tn.equals("dateTime")) tn = "DateTime";
//					else 
//						tn = getTypeName(e);
//				} else 
				tn = getTypeName(e);
				if (e.typeSummary().equals("xml:lang"))
				  tn = "CodeType";
				if (e.typeSummary().equals("xhtml")) 
					tn = "XhtmlNode";
				else if (e.getType().size() > 1)
					tn ="DataType";
				else if (definitions.hasPrimitiveType(tn))
				  tn = upFirst(tn)+"Type";

				typeNames.put(e,  tn);
				e.setUserData("type", tn);
			} else {
				if (e.hasContentReference()) {
				  ElementDefinition er = getElementForPath(structure, e.getContentReference().substring(1));
				  if (typeNames.containsKey(er)) {
  					tn = typeNames.get(er);
				  } else {
				    tn = "@"+er.getPath(); // have to resolve this later
				  }
					typeNames.put(e,  tn);
					e.setUserData("type", tn);
//				} else if (e.getDeclaredTypeName() != null) {
//					tn = e.getDeclaredTypeName();
//					typeNames.put(e,  tn);
//					System.out.println(tn);
				} else {
					if (e.hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-explicit-type-name")) 
						tn = e.getExtensionString("http://hl7.org/fhir/StructureDefinition/structuredefinition-explicit-type-name")+"Component";
					else if (config.getIni().hasProperty("typenames", e.getPath())) {
            tn = config.getIni().getStringProperty("typenames", e.getPath())+"Component";
					} else {
						tn = path+getTitle(e.getName())+"Component";
					}
					if (tn.equals("Element"))
						tn = "Element_";
					strucs.add(e);
					if (typeNameStrings.contains(tn)) {
						char i = 'A';
						while (typeNameStrings.contains(tn+i))
							i++;
						tn = tn + i;
					}
					typeNames.put(e,  tn);
					e.setUserData("type", tn);
					typeNameStrings.add(tn);
					List<ElementDefinition> gcl = filterChildren(ProfileUtilities.getChildList(structure, e));
					for (ElementDefinition c : gcl) {
						scanNestedTypes(structure, root, filterChildren(ProfileUtilities.getChildList(structure, c)), path+getTitle(e.getName()), c);
					}
				}
			}
		}
	}

	private ElementDefinition getElementForPath(StructureDefinition structure, String pathname) throws Exception {
	  String[] path = pathname.split("\\.");
	  if (!path[0].equals(structure.getName()))
	    throw new Exception("Element Path '"+pathname+"' is not legal in this context");
	  ElementDefinition res = null;
	  for (ElementDefinition t : structure.getSnapshot().getElement()) {
	    if (t.getPath().equals(pathname)) {
	      res = t;
	    }
	  }
	  if (res == null) {
	    throw new Exception("unable to resolve "+pathname);
	  }

	  return res;

	}


	private void generateField(ElementDefinition root, ElementDefinition e, String indent, int order, StructureDefinition structure) throws Exception {
		String tn = typeNames.get(e);

		if (e.unbounded()) {
		  jdoc(indent, replaceTitle(root.getName(), e.getDefinition()));
      writeAttributeAnnotation(indent, e, order, tn, root.getName(), structure, root);
			if (tn == null && e.hasContentReference())
				writeWithHash(indent+"protected List<"+root.getName()+"> "+getElementName(e.getName(), true)+";\r\n");
			else {
			  writeWithHash(indent+"protected List<"+tn+"> "+getElementName(e.getName(), true)+";\r\n");
			}
			write("\r\n");
		} else {
      jdoc(indent, replaceTitle(root.getName(), e.getDefinition()));
      writeAttributeAnnotation(indent, e, order, tn, root.getName(), structure, root);
      writeWithHash(indent+"protected "+tn+" "+getElementName(e.getName(), true)+";\r\n");
      write("\r\n");
		}
	}

  public String getReferenceType(ElementDefinition e) {
    String rn = "Resource";
    if (e.getType().size() == 1 && e.typeSummary().startsWith("Reference(")) {
      List<CanonicalType> params = e.getType().get(0).getTargetProfile();
      rn = params.size() == 1 ? params.get(0).getValue() : "Resource";
      if (rn.equals("Any"))
        rn = "Resource";
      else if (rn.equals("List"))
        rn = "ListResource";
    }
    return rn;
  }

  private void writeAttributeAnnotation(String indent, ElementDefinition e, int order, String tn, String rn, StructureDefinition structure, ElementDefinition root) throws Exception {
    String elementName = getElementName(e.getName(), true);
    if (elementName.endsWith("_")) {
      // The annotation doesn't need trailing _
      elementName = elementName.substring(0, elementName.length() - 1);
    }
    
    StringBuilder childB = new StringBuilder();
    childB.append(indent);
    childB.append("@Child(name = \"");
    childB.append(elementName);
    childB.append("\", type = {");
    childB.append(getTypeClassList(e, tn, structure));
    childB.append("}, order=");
    childB.append(Integer.toString(order));
    childB.append(", min=");
    childB.append(Integer.toString(e.getMin()));
    childB.append(", max=");
    childB.append((e.getMax().equals("*") ?  "Child.MAX_UNLIMITED" : e.getMax().toString()));
    childB.append(", modifier=");
    childB.append(e.getIsModifier());
    childB.append(", summary=");
    childB.append(e.getIsSummary());
    childB.append(")\r\n");
    write(childB.toString());
    
    write(indent+"@Description(shortDefinition=\""+Utilities.escapeJava(replaceTitle(rn, e.getShort()))+"\", formalDefinition=\""+Utilities.escapeJava(replaceTitle(rn, e.getDefinition()))+"\" )\r\n");
    
    if (e.getBinding() != null) {
      if (e.getBinding().getValueSet() != null && !Utilities.noString(e.getBinding().getValueSet())) {
        write(indent+"@ca.uhn.fhir.model.api.annotation.Binding(valueSet=\"" + noVer(e.getBinding().getValueSet()) + "\")\r\n");
      }
    }    
  }


  private String noVer(String url) {
    return url.contains("|") ? url.substring(0, url.indexOf("|")) : url;
  }

  private String replaceTitle(String rn, String cnt) {
    String[] title = Utilities.splitByCamelCase(rn);
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" ");
    for (String s : title) {
      b.append(s);
    }
    return cnt.replace("{{title}}", b.toString());
  }

  private String getTypeClassList(ElementDefinition e, String tn, StructureDefinition structure) throws Exception {
    if (e.hasContentReference()) {
      ElementDefinition er = getElementForPath(structure, e.getContentReference().substring(1));
      String s = typeNames.get(er);
      return s+".class";
    }
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (TypeRefComponent tr : e.getType()) {
      if (!Utilities.existsInList(tr.getCode(), "Element", "BackboneElement")) {
        if (tr.isResourceReference()) {
          for (CanonicalType p : tr.getTargetProfile()) {
            String s = p.getValue().substring(40);
            if (s.equalsIgnoreCase("Resource")) {
              b.append("Reference.class");
            } else {
              if (s.equals("List")) {
                b.append(s+"Resource.class");
                //            else if (definitions.hasLogicalModel(p)) {
                //              for (String s : definitions.getLogicalModel(p).getImplementations())
                //                b.append(s+".class");
              } else
                b.append(s+".class");
            }
          }
        } else if (definitions.hasPrimitiveType(tr.getWorkingCode())) {
          b.append(upFirst(tr.getWorkingCode())+"Type.class");
//        } else if (tr.getName().startsWith("@")){
//          b.append(tn+".class");
        } else if (!tr.getName().equalsIgnoreCase("*") && !tr.getName().equalsIgnoreCase("xhtml")) {
          b.append(getTypename(tr)+".class");
        }
      }
    }
    return b.toString();
  }

  private void writeWithHash(String string) throws IOException {
    allfields = allfields + string;
    write(string);
  }

  private String getSimpleType(String n) {
    if (n.equals("StringType"))
      return "String";
    if (n.equals("CodeType"))
      return "String";
    if (n.equals("MarkdownType"))
      return "String";
    if (n.equals("Base64BinaryType"))
      return "byte[]";
    if (n.equals("UriType"))
      return "String";
    if (n.equals("UrlType"))
      return "String";
    if (n.equals("CanonicalType"))
      return "String";
    if (n.equals("OidType"))
      return "String";
    if (n.equals("IntegerType"))
      return "int";
    if (n.equals("Integer64Type"))
      return "long";
    if (n.equals("UnsignedIntType"))
      return "int";
    if (n.equals("PositiveIntType"))
      return "int";
    if (n.equals("BooleanType"))
      return "boolean";
    if (n.equals("DecimalType"))
      return "BigDecimal";
    if (n.equals("DateTimeType"))
      return "Date";
    if (n.equals("DateType"))
      return "Date";
    if (n.equals("IdType"))
      return "String";
    if (n.equals("InstantType"))
      return "Date";
    if (n.equals("TimeType"))
      return "String";
    
    String tns = null;
    if (n.indexOf("<") > 0) {
      tns = n.substring(n.indexOf("<")+1);
      tns = tns.substring(0, tns.length()-1);
    }

    if (tns != null && enumNames.contains(tns))
      return tns;
    
    return "??";
  }
	private void generateAccessors(ElementDefinition root, ElementDefinition e, String indent, String className, ElementDefinition inh) throws Exception {
		String tn = typeNames.get(e);

		if (Utilities.noString(tn)) {
		  throw new Error("??");
		}
		boolean isReferenceRefField = (root.getName().equals("Reference") && e.getName().equals("reference"));
		
		String simpleType = getSimpleType(tn);
		if (e.unbounded() || (inh != null && inh.unbounded())) {
		  /*
		   * getXXX()for repeatable type
		   */
		  jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
		  String listGenericType;
		  if (tn == null && e.hasContentReference()) {
		    listGenericType = root.getName();
		  } else {
		    listGenericType = tn;
		  }
		  write(indent+"public List<"+listGenericType+"> get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
		  if (!e.unbounded()) {
        write(indent+"  List<"+listGenericType+"> list = new ArrayList<"+listGenericType+">();\r\n");
        write(indent+"  if (this."+getElementName(e.getName(), true)+" == null) {\r\n");
        write(indent+"    list.add("+getElementName(e.getName(), true)+");\r\n");
        write(indent+"  }\r\n");
        write(indent+"  return list;\r\n");
		  } else {
		    write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
		    write(indent+"    this."+getElementName(e.getName(), true)+" = new ArrayList<"+listGenericType+">();\r\n");
		    write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
		  }
		  write(indent+"}\r\n\r\n");

		  /*
		   * setXXX(List<foo>) for repeating type
		   */
		  jdoc(indent, "@return Returns a reference to <code>this</code> for easy method chaining");
		  write(indent+"public " + className + " set"+getTitle(getElementName(e.getName(), false))+"(" + "List<"+listGenericType+"> the" + getTitle(getElementName(e.getName(), false)) + ") { \r\n");
		  if (!e.unbounded()) {
        write(indent+"  if (the" + getTitle(getElementName(e.getName(), false)) + ".size() == 0) {\r\n");
        write(indent+"    this."+getElementName(e.getName(), true)+" = null;\r\n");
        write(indent+"  } else if (the" + getTitle(getElementName(e.getName(), false)) + ".size() == 1) {\r\n");
        write(indent+"    this."+getElementName(e.getName(), true)+" = the" + getTitle(getElementName(e.getName(), false)) + ".get(0);\r\n");
        write(indent+"  } else {\r\n");
        write(indent+"    throw new Error(\"Cannot have more than one "+e.getPath()+"\");\r\n");
        write(indent+"  }\r\n");
		  } else {
		    write(indent+"  this."+getElementName(e.getName(), true)+" = the" + getTitle(getElementName(e.getName(), false)) + ";\r\n");
		  }
      write(indent+"  return this;\r\n");
		  write(indent+"}\r\n\r\n");

		  /*
		   * hasXXX() for repeatable type
		   */
		  write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
		  if (!e.unbounded()) {
        write(indent+"  return this."+getElementName(e.getName(), true)+" != null && !this."+getElementName(e.getName(), true)+".isEmpty();\r\n");	    
		  } else {
  		  write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
  		  write(indent+"    return false;\r\n");
  		  write(indent+"  for ("+tn+" item : this."+getElementName(e.getName(), true)+")\r\n");
  		  write(indent+"    if (!item.isEmpty())\r\n");
  		  write(indent+"      return true;\r\n");
  		  write(indent+"  return false;\r\n");
		  }
		  write(indent+"}\r\n");

		  write("\r\n");
		  if (e.getType().size() == 1 && (definitions.hasPrimitiveType(e.typeSummary()) || e.typeSummary().equals("xml:lang") || e.typeSummary().startsWith("canonical("))) {
		    /*
		     * addXXXElement() for repeatable primitive
		     */
		    jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
		    write(indent+"public "+tn+" add"+getTitle(getElementName(e.getName(), false))+"Element() {//2 \r\n");
		    if (!e.unbounded()) {
          write(indent+"  if (this."+getElementName(e.getName(), true)+" == null) {\r\n");
          write(indent+"    this."+getElementName(e.getName(), true)+" = new "+tn+"();\r\n");
          write(indent+"  } else {\r\n");
          write(indent+"    throw new Error(\"Cannot have more than one "+e.getPath()+"\");\r\n");
          write(indent+"  }\r\n");
          write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
		    } else {
  		    write(indent+"  "+tn+" t = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+");\r\n");
  		    write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
  		    write(indent+"    this."+getElementName(e.getName(), true)+" = new ArrayList<"+tn+">();\r\n");
  		    write(indent+"  this."+getElementName(e.getName(), true)+".add(t);\r\n");
  		    write(indent+"  return t;\r\n");
		    }
		    write(indent+"}\r\n");
		    write("\r\n");

		    /*
		     * addXXX(foo) for repeatable primitive
		     */
		    jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
		    write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { //1\r\n");
		    write(indent+"  "+tn+" t = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+");\r\n");
		    write(indent+"  t.setValue(value);\r\n");
		    write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
		    write(indent+"    this."+getElementName(e.getName(), true)+" = new ArrayList<"+tn+">();\r\n");
		    write(indent+"  this."+getElementName(e.getName(), true)+".add(t);\r\n");
		    write(indent+"  return this;\r\n");
		    write(indent+"}\r\n");
		    write("\r\n");

		    /*
		     * hasXXX(foo) for repeatable primitive
		     */
		    jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
		    write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { \r\n");
		    write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
		    write(indent+"    return false;\r\n");
		    write(indent+"  for ("+tn+" v : this."+getElementName(e.getName(), true)+")\r\n");
		    if (isJavaPrimitive(e) && !tn.startsWith("Enum")) // GG: not sure why this is different? 
		      write(indent+"    if (v.getValue().equals(value)) // "+e.typeSummary()+"\r\n");
		    else
		      write(indent+"    if (v.getValue().equals(value)) // "+e.typeSummary()+"\r\n");
		    write(indent+"      return true;\r\n");
		    write(indent+"  return false;\r\n");
		    write(indent+"}\r\n");
		    write("\r\n");
		  } else {
		    if (!definitions.hasResource(tn)) {
		      /*
		       * addXXX() for repeatable composite
		       */
		      write(indent+"public "+tn+" add"+getTitle(getElementName(e.getName(), false))+"() { //3\r\n");
		      if (!e.unbounded()) {
            write(indent+"  if (this."+getElementName(e.getName(), true)+" == null) {\r\n");
            write(indent+"    this."+getElementName(e.getName(), true)+" = new "+tn+"();\r\n");
            write(indent+"  } else {\r\n");
            write(indent+"    throw new Error(\"Cannot have more than one "+e.getPath()+"\");\r\n");
            write(indent+"  }\r\n");
            write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");		        
		      } else {
  		      write(indent+"  "+tn+" t = new "+tn+"();\r\n");
  		      write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
  		      write(indent+"    this."+getElementName(e.getName(), true)+" = new ArrayList<"+tn+">();\r\n");
  		      write(indent+"  this."+getElementName(e.getName(), true)+".add(t);\r\n");
  		      write(indent+"  return t;\r\n");
		      }
          write(indent+"}\r\n");
		      write("\r\n");

		      /*
		       * addXXX(foo) for repeatable composite
		       */
		      write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t) { //3\r\n");
		      if (!e.unbounded()) {
            write(indent+"  if (this."+getElementName(e.getName(), true)+" == null) {\r\n");
            write(indent+"    this."+getElementName(e.getName(), true)+" = t;\r\n");
            write(indent+"  } else {\r\n");
            write(indent+"    throw new Error(\"Cannot have more than one "+e.getPath()+"\");\r\n");
            write(indent+"  }\r\n");
		      } else {
		        write(indent+"  if (t == null)\r\n");
		        write(indent+"    return this;\r\n");
		        write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
		        write(indent+"    this."+getElementName(e.getName(), true)+" = new ArrayList<"+tn+">();\r\n");
		        write(indent+"  this."+getElementName(e.getName(), true)+".add(t);\r\n");
		      }
          write(indent+"  return this;\r\n");
		      write(indent+"}\r\n");
		      write("\r\n");
		    } else {
		      /*
		       * addXXX(foo) for repeatable composite
		       */
		      write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t) { //3\r\n");
		      write(indent+"  if (t == null)\r\n");
		      write(indent+"    return this;\r\n");
		      write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
		      write(indent+"    this."+getElementName(e.getName(), true)+" = new ArrayList<"+tn+">();\r\n");
		      write(indent+"  this."+getElementName(e.getName(), true)+".add(t);\r\n");
		      write(indent+"  return this;\r\n");
		      write(indent+"}\r\n");
		      write("\r\n");          
		    }

		    /*
		     * getXXXFirstRep() for repeatable element
		     */
		    if (!"DomainResource".equals(className)) {
		      jdoc(indent, "@return The first repetition of repeating field {@link #"+getElementName(e.getName(), true)+"}, creating it if it does not already exist");
		      write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"FirstRep() { \r\n");
		      write(indent+"  if (get"+getTitle(getElementName(e.getName(), false))+"().isEmpty()) {\r\n");
		      if ((definitions.hasPrimitiveType(e.typeSummary()))) {
		        write(indent+"    add" + getTitle(getElementName(e.getName(), false)) + "Element();\r\n");
		      } else {
		        write(indent+"    add" + getTitle(getElementName(e.getName(), false)) + "();\r\n");
		      }
		      write(indent+"  }\r\n");
		      write(indent+"  return get"+getTitle(getElementName(e.getName(), false))+"().get(0);\r\n");
		      write(indent+"}\r\n\r\n");
		    }

		  }
		} else {
      if (!"xhtml".equals(e.typeSummary()) && isJavaPrimitive(e) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        if (isReferenceRefField) {
          /*
           * Reference#getReferenceElement is defined differently in BaseReference.java?
           */
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element_() { \r\n");
          write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
          write(indent+"    if (Configuration.errorOnAutoCreate())\r\n");
          write(indent+"      throw new Error(\"Attempt to auto-create "+className+"."+getElementName(e.getName(), true)+"\");\r\n");
          write(indent+"    else if (Configuration.doAutoCreate())\r\n");
          write(indent+"      this."+getElementName(e.getName(), true)+" = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+"); // bb\r\n");
          write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
          write(indent+"}\r\n");
        } else { 
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element() { \r\n");
          write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
          write(indent+"    if (Configuration.errorOnAutoCreate())\r\n");
          write(indent+"      throw new Error(\"Attempt to auto-create "+className+"."+getElementName(e.getName(), true)+"\");\r\n");
          write(indent+"    else if (Configuration.doAutoCreate())\r\n");
          write(indent+"      this."+getElementName(e.getName(), true)+" = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+"); // bb\r\n");
          write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
          write(indent+"}\r\n");
        }
        write("\r\n");

        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"Element() { \r\n");
        write(indent+"  return this."+getElementName(e.getName(), true)+" != null && !this."+getElementName(e.getName(), true)+".isEmpty();\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  return this."+getElementName(e.getName(), true)+" != null && !this."+getElementName(e.getName(), true)+".isEmpty();\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"Element("+tn+" value) { \r\n");
        write(indent+"  this."+getElementName(e.getName(), true)+" = value;\r\n");
        write(indent+"  return this;\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        jdoc(indent, "@return "+replaceTitle(root.getName(), e.getDefinition()));
        write(indent+"public "+simpleType+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        if (e.typeSummary().equals("boolean"))
          write(indent+"  return this."+getElementName(e.getName(), true)+" == null || this."+getElementName(e.getName(), true)+".isEmpty() ? false : this."+getElementName(e.getName(), true)+".getValue();\r\n");
        else if (e.typeSummary().equals("integer") || e.typeSummary().equals("unsignedInt") || e.typeSummary().equals("positiveInt"))
          write(indent+"  return this."+getElementName(e.getName(), true)+" == null || this."+getElementName(e.getName(), true)+".isEmpty() ? 0 : this."+getElementName(e.getName(), true)+".getValue();\r\n");
        else if (e.typeSummary().equals("integer64"))
          write(indent+"  return this."+getElementName(e.getName(), true)+" == null || this."+getElementName(e.getName(), true)+".isEmpty() ? 0 : this."+getElementName(e.getName(), true)+".getValue();\r\n");
        else
          write(indent+"  return this."+getElementName(e.getName(), true)+" == null ? null : this."+getElementName(e.getName(), true)+".getValue();\r\n");
        write(indent+"}\r\n");
        write("\r\n");
	      generateSetter(e, indent, className, tn, simpleType, root.getName());

	      // BigDecimal sugar methods 
	      if (simpleType.equals("BigDecimal")) {
          generateSetter(e, indent, className, tn, "long", root.getName());
	        generateSetter(e, indent, className, tn, "double", root.getName());
	      }
//	      // code sugar methods
//	      if (e.typeSummary().equals("code")) {
//          jdoc(indent, "@return a string code value for "+replaceTitle(rn, e.getDefinition()));
//          write(indent+"public "+simpleType+" get"+getTitle(getElementName(e.getName(), false))+"AsCode() { \r\n");
//          write(indent+"  return this."+getElementName(e.getName(), true)+" == null ? null : this."+getElementName(e.getName(), true)+".getValue();\r\n");
//          write(indent+"}\r\n");
//          write("\r\n");
//          
//          jdoc(indent, "@param value String value for "+replaceTitle(rn, e.getDefinition()));
//          write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"AsCode(String value) throws FHIRException { \r\n");
//          write(indent+"  if (!Utilities.noString(value)) \r\n");
//          write(indent+"    this."+getElementName(e.getName(), true)+" = null;\r\n");
//          write(indent+"  else {\r\n");
//          write(indent+"    if (this."+getElementName(e.getName(), true)+" == null)\r\n");
//          write(indent+"      this."+getElementName(e.getName(), true)+" = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+");\r\n");
//          write(indent+"    this."+getElementName(e.getName(), true)+".setValue("+(tn.startsWith("Enum") ? tn.substring(12, tn.length()-1)+".fromCode(value)" : "value")+");\r\n");
//          write(indent+"  }\r\n");
//          write(indent+"  return this;\r\n");
//          write(indent+"}\r\n");
//          write("\r\n");
//          
//        }
	      
      } else {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        if (!tn.equals("Resource") && !tn.equals("DataType") && !tn.endsWith(".DataType")) {
          write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
          write(indent+"    if (Configuration.errorOnAutoCreate())\r\n");
          write(indent+"      throw new Error(\"Attempt to auto-create "+className+"."+getElementName(e.getName(), true)+"\");\r\n");
          write(indent+"    else if (Configuration.doAutoCreate())\r\n");
          if ("XhtmlNode".equals(tn))
            write(indent+"      this."+getElementName(e.getName(), true)+" = new XhtmlNode(NodeType.Element, \"div\"); // cc.1\r\n");
          else
          write(indent+"      this."+getElementName(e.getName(), true)+" = new "+tn+"(); // cc\r\n");
        }
        write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        if (e.getType().size() > 1 && (tn.equals("DataType") || !tn.endsWith(".DataType"))) {
          for (TypeRefComponent t : e.getType()) {
            jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
            String ttn = getTypename(t);
            write(indent+"public "+ttn+" get"+getTitle(getElementName(e.getName(), false))+ttn+"() throws FHIRException { \r\n");
            write(indent+"  if (this."+getElementName(e.getName(), true)+" == null)\r\n");
            write(indent+"    this."+getElementName(e.getName(), true)+" = new "+ttn+"();\r\n");
            write(indent+"  if (!(this."+getElementName(e.getName(), true)+" instanceof "+ttn+"))\r\n");
            write(indent+"    throw new FHIRException(\"Type mismatch: the type "+ttn+" was expected, but \"+this."+getElementName(e.getName(), true)+".getClass().getName()+\" was encountered\");\r\n");
            write(indent+"  return ("+ttn+") this."+getElementName(e.getName(), true)+";\r\n");
            write(indent+"}\r\n");
            write("\r\n");
            write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+ttn+"() { \r\n");
            write(indent+"  return this != null && this."+getElementName(e.getName(), true)+" instanceof "+ttn+";\r\n");
            write(indent+"}\r\n");
            write("\r\n");
          }
        }
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  return this."+getElementName(e.getName(), true)+" != null && !this."+getElementName(e.getName(), true)+".isEmpty();\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+tn+" value) { \r\n");
        if (e.getType().size() > 1 && (tn.equals("DataType") || !tn.endsWith(".DataType"))) {
          write(indent+"  if (value != null && !(");
          boolean first = true;
          for (TypeRefComponent t : e.getType()) {
            if (first) first = false; else write(" || ");
            write("value instanceof ");
            write(getTypename(t));            
          }
          write("))\r\n");
          write(indent+"    throw new Error(\"Not the right type for "+e.getPath()+": \"+value.fhirType());\r\n");         
        }
        write(indent+"  this."+getElementName(e.getName(), true)+" = value;\r\n");
        write(indent+"  return this;\r\n");
        write(indent+"}\r\n");
        write("\r\n");
			}
		}

	}

  private void generateAbstractAccessors(ElementDefinition root, ElementDefinition e, String indent, String className) throws Exception {
    String tn = typeNames.get(e);

    if (Utilities.noString(tn)) {
      throw new Error("??");
    }
    boolean isReferenceRefField = (root.getName().equals("Reference") && e.getName().equals("reference"));
    
    String simpleType = getSimpleType(tn);
    if (e.unbounded()) {
      /*
       * getXXX()for repeatable type
       */
      jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
      String listGenericType;
      if (tn == null && e.hasContentReference()) {
        listGenericType = root.getName();
      } else {
        listGenericType = tn;
      }
      write(indent+"public abstract List<"+listGenericType+"> get"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
      /*
       * setXXX(List<foo>) for repeating type
       */
      jdoc(indent, "@return Returns a reference to <code>this</code> for easy method chaining");
      write(indent+"public abstract " + className + " set"+getTitle(getElementName(e.getName(), false))+"(" + "List<"+listGenericType+"> the" + getTitle(getElementName(e.getName(), false)) + "); \r\n");

      /*
       * hasXXX() for repeatable type
       */
      write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
      write("\r\n");
      if (e.getType().size() == 1 && (definitions.hasPrimitiveType(e.typeSummary()) || e.typeSummary().equals("xml:lang") || e.typeSummary().startsWith("canonical("))) {
        /*
         * addXXXElement() for repeatable primitive
         */
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+tn+" add"+getTitle(getElementName(e.getName(), false))+"Element();//2 \r\n");

        /*
         * addXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value); //1\r\n");

        /*
         * hasXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value); \r\n");
      } else {
        if (!definitions.hasResource(tn)) {
          /*
           * addXXX() for repeatable composite
           */
          write(indent+"public abstract "+tn+" add"+getTitle(getElementName(e.getName(), false))+"(); //3\r\n");

          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public abstract "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t); //3\r\n");
        } else {
          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public abstract "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t); //3\r\n");
        }

        /*
         * getXXXFirstRep() for repeatable element
         */
        if (!"DomainResource".equals(className)) {
          jdoc(indent, "@return The first repetition of repeating field {@link #"+getElementName(e.getName(), true)+"}, creating it if it does not already exist");
          write(indent+"public abstract "+tn+" get"+getTitle(getElementName(e.getName(), false))+"FirstRep(); \r\n");
        }
      }
    } else {
      if (!"xhtml".equals(e.typeSummary()) && isJavaPrimitive(e) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        if (isReferenceRefField) {
          /*
           * Reference#getReferenceElement is defined differently in BaseReference.java?
           */
          write(indent+"public abstract "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element_(); \r\n");
        } else { 
          write(indent+"public abstract "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element(); \r\n");
        }
        write("\r\n");

        write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"Element(); \r\n");
        write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        write("\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        write(indent+"public abstract "+className+" set"+getTitle(getElementName(e.getName(), false))+"Element("+tn+" value); \r\n");
        jdoc(indent, "@return "+replaceTitle(root.getName(), e.getDefinition()));
        write(indent+"public abstract "+simpleType+" get"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        generateAbstractSetter(e, indent, className, tn, simpleType, root.getName());

        // BigDecimal sugar methods 
        if (simpleType.equals("BigDecimal")) {
          generateAbstractSetter(e, indent, className, tn, "long", root.getName());
          generateAbstractSetter(e, indent, className, tn, "double", root.getName());
        }        
      } else {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+tn+" get"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        if (e.getType().size() > 1 && (tn.equals("DataType") || !tn.endsWith(".DataType"))) {
          for (TypeRefComponent t : e.getType()) {
            jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
            String ttn = getTypename(t);
            write(indent+"public abstract "+ttn+" get"+getTitle(getElementName(e.getName(), false))+ttn+"() throws FHIRException; \r\n");
            write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+ttn+"(); \r\n");
          }
        }
        write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+tn+" value); \r\n");
        write("\r\n");
      }
    }

  }

  private void generateSetter(ElementDefinition e, String indent, String className, String tn, String simpleType, String rn) throws IOException {
    jdoc(indent, "@param value "+replaceTitle(rn, e.getDefinition()));
    write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { \r\n");
    if ("long".equals(simpleType) || "double".equals(simpleType)) {
      write(indent+"      this."+getElementName(e.getName(), true)+" = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+");\r\n");
      write(indent+"    this."+getElementName(e.getName(), true)+".setValue(value);\r\n");      
    } else {
      if (e.getMin() == 0 && !tn.equals("IntegerType") && !tn.equals("PositiveIntType") && !tn.equals("UnsignedIntType") && !tn.equals("BooleanType")) {
        if (isString(tn))
          write(indent+"  if (Utilities.noString(value))\r\n");
        else
          write(indent+"  if (value == null)\r\n");
        write(indent+"    this."+getElementName(e.getName(), true)+" = null;\r\n");
        write(indent+"  else {\r\n");
      }
      write(indent+"    if (this."+getElementName(e.getName(), true)+" == null)\r\n");
      write(indent+"      this."+getElementName(e.getName(), true)+" = new "+tn+"("+( tn.startsWith("Enum") ? "new "+tn.substring(12, tn.length()-1)+"EnumFactory()" : "")+");\r\n");
      write(indent+"    this."+getElementName(e.getName(), true)+".setValue(value);\r\n");
      if (e.getMin() == 0 && !tn.equals("IntegerType") && !tn.equals("PositiveIntType") && !tn.equals("UnsignedIntType") && !tn.equals("BooleanType")) {
        write(indent+"  }\r\n");
      }
    }
    write(indent+"  return this;\r\n");
    write(indent+"}\r\n");
    write("\r\n");
  }

  private void generateAbstractSetter(ElementDefinition e, String indent, String className, String tn, String simpleType, String rn) throws IOException {
    jdoc(indent, "@param value "+replaceTitle(rn, e.getDefinition()));
    write(indent+"public abstract "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value); \r\n");
  }

  private boolean isString(String tn) {
    return tn.equals("StringType") || tn.equals("CodeType") || tn.equals("IdType") || tn.equals("UriType") || tn.equals("OidType") || tn.equals("CanonicalType") || tn.equals("UrlType") || tn.equals("UuidType");
  }

  public long getHashSum() {
    return hashSum;
  }

  public void setInheritedHash(String value) {
    inheritedHash = value;
    
  }

  private void generateUnimplementedAccessors(ElementDefinition root, ElementDefinition e, String indent, String className) throws Exception {
    String tn = typeNames.get(e);

    if (Utilities.noString(tn)) {
      tn = e.getUserString("type");
      if (Utilities.noString(tn)) {
        throw new Error("??");
      }
    }
    boolean isReferenceRefField = (root.getName().equals("Reference") && e.getName().equals("reference"));
    
    String simpleType = getSimpleType(tn);
    if (e.unbounded()) {
      /*
       * getXXX()for repeatable type
       */
      jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
      String listGenericType;
      if (tn == null && e.hasContentReference()) {
        listGenericType = root.getName();
      } else {
        listGenericType = tn;
      }
      write(indent+"public List<"+listGenericType+"> get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
      write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
      write(indent+"}\r\n");
      /*
       * setXXX(List<foo>) for repeating type
       */
      jdoc(indent, "@return Returns a reference to <code>this</code> for easy method chaining");
      write(indent+"public " + className + " set"+getTitle(getElementName(e.getName(), false))+"(" + "List<"+listGenericType+"> the" + getTitle(getElementName(e.getName(), false)) + ") { \r\n");
      write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
      write(indent+"}\r\n");

      /*
       * hasXXX() for repeatable type
       */
      write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
      write(indent+"  return false;\r\n");
      write(indent+"}\r\n");
      write("\r\n");
      if (e.getType().size() == 1 && (definitions.hasPrimitiveType(e.typeSummary()) || e.typeSummary().equals("xml:lang") || e.typeSummary().startsWith("canonical("))) {
        /*
         * addXXXElement() for repeatable primitive
         */
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public "+tn+" add"+getTitle(getElementName(e.getName(), false))+"Element(){//2 \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");

        /*
         * addXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { //1\r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");

        /*
         * hasXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value); \r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
      } else {
        if (!definitions.hasResource(tn)) {
          /*
           * addXXX() for repeatable composite
           */
          write(indent+"public "+tn+" add"+getTitle(getElementName(e.getName(), false))+"() { //3\r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");

          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t) { //3\r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");
        } else {
          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t) { //3\r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");
        }

        /*
         * getXXXFirstRep() for repeatable element
         */
        if (!"DomainResource".equals(className)) {
          jdoc(indent, "@return The first repetition of repeating field {@link #"+getElementName(e.getName(), true)+"}, creating it if it does not already exist");
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"FirstRep() { \r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");
        }
      }
    } else {
      if (!"xhtml".equals(e.typeSummary()) && isJavaPrimitive(e) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        if (isReferenceRefField) {
          /*
           * Reference#getReferenceElement is defined differently in BaseReference.java?
           */
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element_() { \r\n");
        } else { 
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element() { \r\n");
        }
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        write("\r\n");

        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"Element() { \r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() {\r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"Element("+tn+" value) { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        write(indent+"public "+simpleType+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        generateUnimplementedSetter(root, e, indent, className, tn, simpleType, root.getName());

        // BigDecimal sugar methods 
        if (simpleType.equals("BigDecimal")) {
          generateUnimplementedSetter(root, e, indent, className, tn, "long", root.getName());
          generateUnimplementedSetter(root, e, indent, className, tn, "double", root.getName());
        }        
      } else {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        if (e.getType().size() > 1 && (tn.equals("DataType") || !tn.endsWith(".DataType"))) {
          for (TypeRefComponent t : e.getType()) {
            jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
            String ttn = getTypename(t);
            write(indent+"public "+ttn+" get"+getTitle(getElementName(e.getName(), false))+ttn+"() { throws FHIRException; \r\n");
            write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
            write(indent+"}\r\n");
            write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+ttn+"() { \r\n");
          }
        }
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(root.getName(), e.getDefinition())+")");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+tn+" value) { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        write("\r\n");
      }
    }

  }


  private void generateUnimplementedSetter(ElementDefinition root, ElementDefinition e, String indent, String className, String tn, String simpleType, String rn) throws IOException {
    jdoc(indent, "@param value "+replaceTitle(rn, e.getDefinition()));
    write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { \r\n");
    write(indent+"  throw new Error(\"The resource type \\\""+root.getPath()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
    write(indent+"}\r\n");
  }
}
