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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.hl7.fhir.core.generator.analysis.Analysis;
import org.hl7.fhir.core.generator.analysis.EnumInfo;
import org.hl7.fhir.core.generator.analysis.TypeInfo;
import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.ResourceTypeEnum;
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
  private String allfields;
  private long hashSum;

	
	public JavaResourceGenerator(OutputStream out, Definitions definitions, Configuration configuration, Date genDate, String version) throws UnsupportedEncodingException {
		super(out, definitions, configuration, version, genDate);
	}

	// public void generate(ElementDefinition root, String name, JavaGenClass clss, ProfiledType cd, Date genDate, String version, boolean isAbstract, Map<String, SearchParameterDefn> nameToSearchParamDef, ElementDefinition template) throws Exception {
	public void generate(Analysis analysis) throws Exception {   
		if (analysis.getStructure().getKind() == StructureDefinitionKind.RESOURCE) {
		  clss = JavaGenClass.Resource;
		} else {
		  clss = JavaGenClass.Type;
		}    
		write("package org.hl7.fhir.r5.model;\r\n");
    startMark(version, genDate);
		
    boolean hl = true; // hasList(root);
    boolean hh = hasXhtml(analysis.getStructure().getSnapshot().getElement());
    boolean hd = hasDecimal(analysis.getStructure().getSnapshot().getElement());
    boolean hs = hasString(analysis.getStructure().getSnapshot().getElement());
    boolean he = hasSharedEnums(analysis.getStructure().getSnapshot().getElement());
    boolean hn = hasNestedTypes(analysis.getStructure().getSnapshot().getElement());
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
    if (clss == JavaGenClass.Resource || "BackboneElement".equals(analysis.getName()) || "BackboneType".equals(analysis.getName())) {
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
    if (config.getIni().hasProperty("imports", analysis.getName())) {
      for (String imp : config.getIni().getStringProperty("imports", analysis.getName()).split("\\,")) {
        write("import "+imp+";\r\n");
      }
    }
    
		jdoc("", replaceTitle(analysis.getName(), analysis.getStructure().getDescription()));
		TypeInfo ti = analysis.getRootType();
		boolean hasChildren = ti.getChildren().size() > 0;
    String hierarchy = "extends "+analysis.getAncestor().getName();
    if (clss == JavaGenClass.Resource) {
      if (!analysis.isAbstract()) {
        write("@ResourceDef(name=\""+upFirst(analysis.getName()).replace("ListResource", "List")+"\", profile=\"http://hl7.org/fhir/StructureDefinition/"+upFirst(analysis.getName())+"\")\r\n");
      }
    } else {
      write("@DatatypeDef(name=\""+upFirst(analysis.getName())+"\")\r\n");
      hierarchy = hierarchy + " implements ICompositeType";
    }
    
    if (config.getIni().hasProperty("hierarchy", analysis.getName())) {
      hierarchy = config.getIni().getStringProperty("hierarchy", analysis.getName()).replace("{{super}}", analysis.getAncestor().getName());
    }
				
    write("public "+(analysis.isAbstract()? "abstract " : "")+"class "+analysis.getClassName()+" "+hierarchy.trim()+" {\r\n");
		write("\r\n");

		for (String s : sorted(analysis.getEnums().keySet())) {
  		EnumInfo e = analysis.getEnums().get(s);
		  generateEnum(e);
		}
    for (TypeInfo t : analysis.getTypeList()) {
		  generateType(analysis, t);
		}

		allfields = "";
		int i = 0;
		for (ElementDefinition e : ti.getChildren()) {
		  if (!analysis.isInterface()) {
		    generateField(analysis, ti, e, "    ", i++);
		  }
		}
		write("    private static final long serialVersionUID = "+Long.toString(allfields.hashCode())+"L;\r\n\r\n");
		hashSum = hashSum + allfields.hashCode();

		List<ElementDefinition> mandatory = new ArrayList<ElementDefinition>();
		generateConstructor(analysis.getClassName(), mandatory, "  ");      
		if (hasChildren) {
		  for (ElementDefinition e : ti.getChildren()) {
		    if (e.getMin() > 0)
		      mandatory.add(e);
		  }
		  if (mandatory.size() > 0)
		    generateConstructor(analysis.getClassName(), mandatory, "  ");

		  generateTypeSpecificConstructors(analysis.getClassName());

		  for (ElementDefinition e : ti.getChildren()) {
	      if (analysis.isInterface()) {
          generateAbstractAccessors(analysis, ti, e, "    ");
	      } else {
		      generateAccessors(analysis, ti, e, "    ", matchingInheritedElement(ti.getInheritedChildren(), e));
	      }
		  }
		  if (!analysis.isInterface()) {
		    for (ElementDefinition e : filterInherited(ti.getInheritedChildren(), ti.getChildren())) {
		      generateUnimplementedAccessors(analysis, ti, e, "    ");
		    }
		  }

		  generateChildrenRegister(analysis, ti, "    ");
		  generatePropertyGetterId(analysis, ti, "    ");
		  generatePropertySetterId(analysis, ti, "    ");
		  generatePropertySetterName(analysis, ti, "    ");
		  generatePropertyMaker(analysis, ti, "    ");
		  generatePropertyTypeGetter(analysis, ti, "    ");
		  generateChildAdder(analysis, ti, "    ");
		}
		generateFhirType(analysis.getName());
      
//      // check for mappings
//      for (String map : root.getMappings().keySet()) {
//        if ("http://hl7.org/fhir/workflow".equals(map)) {
//          String namenn = root.getMapping(map);
//          if (patterns.containsKey(namenn)) {
//            generateImpl(namenn, patterns.get(namenn), upFirst(name), root, version, genDate);
//          }
//        }
//      }

		generateCopy(analysis, ti, false);
    if (hasChildren) {
		  generateEquals(analysis, ti, false);
		  generateIsEmpty(analysis, ti, false);
    }

		if (clss == JavaGenClass.Resource && !analysis.isAbstract()) {
		  write("  @Override\r\n");
		  write("  public ResourceType getResourceType() {\r\n");
		  write("    return ResourceType."+analysis.getName()+";\r\n");
		  write("   }\r\n");
		  write("\r\n"); 
		} else if (analysis.isAbstract() && Utilities.noString(analysis.getAncestor().getName())) {
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
		} else if (analysis.isAbstract() && Utilities.noString(analysis.getAncestor().getName())) {
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
		for (SearchParameter sp : analysis.getSearchParams()) {
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
		        for (SearchParameter nextCandidate : analysis.getSearchParams()) {
		          if (nextCandidate.getCode().startsWith(partialCode)) {
		            String nextCompositeCode = rootCode + "-" + nextCandidate.getCode();
		            String[] compositeOf = new String[] { rootCode, nextCandidate.getCode() };
		            writeSearchParameterField(analysis.getName(), clss, analysis.isAbstract(), sp, nextCompositeCode, compositeOf, analysis.getSearchParams(), analysis.getName());
		          }
		        }
		      } else {
		        SearchParameter comp0 = definitions.getSearchParams().get(sp.getComponent().get(0).getDefinition());
		        SearchParameter comp1 = definitions.getSearchParams().get(sp.getComponent().get(1).getDefinition());
		        if (comp0 == null) {
		          throw new Error("Couldn't find composite component " + sp.getComponent().get(0).getDefinition() + " on "+analysis.getName());
		        }
		        if (comp1 == null) {
		          throw new Error("Couldn't find composite component " + sp.getComponent().get(1).getDefinition() + " on "+analysis.getName());
		        }
		        String[] compositeOf = new String[] { comp0.getCode(), comp1.getCode() };
		        writeSearchParameterField(analysis.getName(), clss, analysis.isAbstract(), sp, sp.getCode(), compositeOf, analysis.getSearchParams(), analysis.getName());
		      }  
		    } else if (code.contains("[x]")) {
		      /*
		       * We only know how to handle search parameters with [x] in the name
		       * where it's a composite, and the [x] comes last. Are there other possibilities?
		       */
		      throw new Exception("Unable to generate constant for search parameter: " + code);
		    } else {
		      writeSearchParameterField(analysis.getName(), clss, analysis.isAbstract(), sp, code, null, analysis.getSearchParams(), analysis.getName());
		    }
		  }
		}

		if (config.getAdornments().containsKey(analysis.getClassName())) {
      write("// Manual code (from Configuration.txt)t:\r\n");
		  write(config.getAdornments().get(analysis.getClassName())+"\r\n");
      write("// end addition\r\n");
		}
		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();
}

	private List<String> sorted(Set<String> keys) {
	  List<String> res = new ArrayList<>();
	  res.addAll(keys);
	  Collections.sort(res);
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
      targets.add(c.asStringValue());
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

	private void generateChildrenRegister(Analysis analysis, TypeInfo ti, String indent) throws Exception {
	  String rn = analysis.getName();
	  boolean isInterface = analysis.isInterface();
	  List<ElementDefinition> children = ti.getChildren();
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

private void generatePropertyMaker(Analysis analysis, TypeInfo ti, String indent) throws Exception {
  List<ElementDefinition> children = ti.getChildren();
  boolean isInterface = analysis.isInterface();
  List<ElementDefinition> inheritedChildren = ti.getInheritedChildren();
  
    write(indent+"  @Override\r\n");
    write(indent+"  public Base makeProperty(int hash, String name) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        ElementDefinition inh = inheritedChildren == null ? null : matchingInheritedElement(inheritedChildren, e);
        String tn = e.getUserString("java.type");
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

  private void generatePropertySetterName(Analysis analysis, TypeInfo ti, String indent) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    boolean isInterface = analysis.isInterface();
    write(indent+"  @Override\r\n");
    write(indent+"  public Base setProperty(String name, Base value) throws FHIRException {\r\n");
    boolean first = true;
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String tn = e.getUserString("java.type");
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

  private void generatePropertySetterId(Analysis analysis, TypeInfo ti, String indent) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    boolean isInterface = analysis.isInterface();
    write(indent+"  @Override\r\n");
    write(indent+"  public Base setProperty(int hash, String name, Base value) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String tn = e.getUserString("java.type");
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

  private void generatePropertyGetterId(Analysis analysis, TypeInfo ti, String indent) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    boolean isInterface = analysis.isInterface();
    write(indent+"  @Override\r\n");
    write(indent+"  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {\r\n");
    write(indent+"    switch (hash) {\r\n");
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        String tn = e.getUserString("java.type");
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

  private void generatePropertyTypeGetter(Analysis analysis, TypeInfo ti, String indent) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    boolean isInterface = analysis.isInterface();
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

  private void generateChildAdder(Analysis analysis, TypeInfo ti, String indent) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    boolean isInterface = analysis.isInterface();
    String parent = ti.getDefn().getPath();
    
    write(indent+"  @Override\r\n");
    write(indent+"  public Base addChild(String name) throws FHIRException {\r\n");
    boolean first = true;
    for (ElementDefinition e : children) {
      if (!isInterface) { 
        if (!e.typeSummary().equals("xhtml")) { 
          if (e.getType().size() <= 1 && !e.typeSummary().equals("*")) {
            String tn = e.getUserString("java.type");
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
        t.add(new TypeRefComponent(s));
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
      String tn = e.getUserString("java.type");
      if (definitions.hasPrimitiveType(e.typeSummary()) && !e.hasUserData("java.enum")) {
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

  private void generateEnum(EnumInfo e) throws Exception {
		String tn = e.getName();
		String tns = tn;
		if (tn.startsWith("Enumeration<")) {
		  tns = tn.substring(tn.indexOf("<")+1);
		  tns = tns.substring(0, tns.length()-1);
		} else {
		  tn = "Enumeration<"+tn+">";
		}
		ValueSet vs = e.getValueSet();
		ValueSet vse = (ValueSet) vs.getUserData("expansion");
		if (vs.hasUserData("shared")) {
		  return;
		}
    if (vse == null) {
      return;
    }
    
		List<ValueSetExpansionContainsComponent> codes = vse.getExpansion().getContains();
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

  private void generateType(Analysis analysis, TypeInfo ti) throws Exception {
		String tn = ti.getName();
		ElementDefinition e = ti.getDefn();

		StructureDefinition sd = definitions.getType(e.typeSummary());
		List<ElementDefinition> children = ti.getChildren();
		write("    @Block()\r\n");
		write("    public static class "+tn+" extends "+sd.getName()+" implements "+(sd.getName().equals("Element") ? "IBaseDatatypeElement" : "IBaseBackboneElement")+" {\r\n");

		allfields = "";
		int i = 1;
		for (ElementDefinition c : children) {
			generateField(analysis, ti, c, "        ", i++);
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
			generateAccessors(analysis, ti, c, "        ", null);
		}

    generateChildrenRegister(analysis, ti,"      ");
    generatePropertyGetterId(analysis, ti,"    ");
    generatePropertySetterId(analysis, ti,"    ");
    generatePropertySetterName(analysis, ti,"    ");
    generatePropertyMaker(analysis, ti,"    ");
    generatePropertyTypeGetter(analysis, ti,"    ");
    generateChildAdder(analysis, ti,"    ");
    generateCopy(analysis, ti, true);
    generateEquals(analysis, ti, true);
    generateIsEmpty(analysis, ti, true);
    generateFhirType(e.getPath());
    if (config.getAdornments().containsKey(tn)) {
      write("// added from java-adornments.txt:\r\n");
      write(config.getAdornments().get(tn)+"\r\n");
      write("// end addition\r\n");
    }
    write("  }\r\n");
		write("\r\n");

	}

  
  private void generateEquals(Analysis analysis, TypeInfo ti, boolean owner) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    String tn = ti.getName();
    boolean isAbstract = analysis.isAbstract(); 
    boolean isInterface = analysis.isInterface();
    
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
  
	private void generateCopy(Analysis analysis, TypeInfo ti, boolean owner) throws Exception {
	  List<ElementDefinition> children = ti.getChildren();
	  String tn = ti.getName();
	  boolean isAbstract = analysis.isAbstract();
	  boolean isInterface = analysis.isInterface();
	      
	  
	  if (isAbstract) {
      write("      public abstract "+tn+" copy();\r\n\r\n");
      write("      public void copyValues("+tn+" dst) {\r\n");
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
	        String ctn = c.getUserString("java.type");
	        write("        if ("+name+" != null) {\r\n");
	        write("          dst."+name+" = new ArrayList<"+ctn+">();\r\n");
	        write("          for ("+ctn+" i : "+name+")\r\n");
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

  private void generateIsEmpty(Analysis analysis, TypeInfo ti, boolean owner) throws Exception {
    List<ElementDefinition> children = ti.getChildren();
    String tn = ti.getName();
    boolean isAbstract = analysis.isAbstract();
    boolean isInterface = analysis.isInterface();
    
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


	private void generateField(Analysis analysis, TypeInfo ti, ElementDefinition e, String indent, int order) throws Exception {
		String tn = e.getUserString("java.type");

		if (e.unbounded()) {
		  jdoc(indent, replaceTitle(analysis.getName(), e.getDefinition()));
      writeAttributeAnnotation(indent, e, order, tn, analysis.getName(), analysis.getStructure());
//			if (tn == null && e.hasContentReference())
//				writeWithHash(indent+"protected List<"+tn+"> "+getElementName(e.getName(), true)+";\r\n");
//			else {
			  writeWithHash(indent+"protected List<"+tn+"> "+getElementName(e.getName(), true)+";\r\n");
//			}
			write("\r\n");
		} else {
      jdoc(indent, replaceTitle(analysis.getName(), e.getDefinition()));
      writeAttributeAnnotation(indent, e, order, tn, analysis.getName(), analysis.getStructure());
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

  private void writeAttributeAnnotation(String indent, ElementDefinition e, int order, String tn, String rn, StructureDefinition structure) throws Exception {
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
      String s = er.getUserString("java.type");
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

    if (tns != null /*&& enumNames.contains(tns)*/)
      return tns;
    
    return "??";
  }
	private void generateAccessors(Analysis analysis, TypeInfo ti, ElementDefinition e, String indent, ElementDefinition inh) throws Exception {
		String tn = e.getUserString("java.type");
		String className = ti.getName();

		if (Utilities.noString(tn)) {
		  throw new Error("??");
		}
		boolean isReferenceRefField = (analysis.getName().equals("Reference") && e.getName().equals("reference"));


		String simpleType = getSimpleType(tn);
		if (e.unbounded() || (inh != null && inh.unbounded())) {
		  if (!e.unbounded()) {
		    jdoc(indent, "only one on this implementation");
		    write(indent+"@Override\r\n");
		    write(indent+"public int get"+getTitle(getElementName(e.getName(), false))+"Max() { \r\n");
		    write(indent+"  return 1;\r\n");
		    write(indent+"}\r\n");
		  }
		  /*
		   * getXXX()for repeatable type
		   */
		  jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
		  String listGenericType;
		  if (tn == null && e.hasContentReference()) {
		    listGenericType = analysis.getName();
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
		    jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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
		    jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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
		    jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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
		      jdoc(indent, "@return The first repetition of repeating field {@link #"+getElementName(e.getName(), true)+"}, creating it if it does not already exist {3}");
		      write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"FirstRep() { \r\n");
		      if (e.unbounded()) {
		        write(indent+"  if (get"+getTitle(getElementName(e.getName(), false))+"().isEmpty()) {\r\n");
		      } else {
            write(indent+"  if ("+getElementName(e.getName(), false)+" == null) {\r\n");
		      }
		      if ((definitions.hasPrimitiveType(e.typeSummary()))) {
		        write(indent+"    add" + getTitle(getElementName(e.getName(), false)) + "Element();\r\n");
		      } else {
		        write(indent+"    add" + getTitle(getElementName(e.getName(), false)) + "();\r\n");
		      }
		      write(indent+"  }\r\n");
          if (e.unbounded()) {
  		      write(indent+"  return get"+getTitle(getElementName(e.getName(), false))+"().get(0);\r\n");
          } else {
            write(indent+"  return "+getElementName(e.getName(), false)+";\r\n");            
          }
		      write(indent+"}\r\n\r\n");
		    }

		  }
		} else {
      if (!"xhtml".equals(e.typeSummary()) && isJavaPrimitive(e) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
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
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"Element("+tn+" value) { \r\n");
        write(indent+"  this."+getElementName(e.getName(), true)+" = value;\r\n");
        write(indent+"  return this;\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        jdoc(indent, "@return "+replaceTitle(analysis.getName(), e.getDefinition()));
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
	      generateSetter(e, indent, className, tn, simpleType, analysis.getName());

	      // BigDecimal sugar methods 
	      if (simpleType.equals("BigDecimal")) {
          generateSetter(e, indent, className, tn, "long", analysis.getName());
	        generateSetter(e, indent, className, tn, "double", analysis.getName());
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
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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
            jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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

  private void generateAbstractAccessors(Analysis analysis, TypeInfo ti, ElementDefinition e, String indent) throws Exception {
    String tn = e.getUserString("java.type");

    if (Utilities.noString(tn)) {
      throw new Error("??");
    }
    boolean isReferenceRefField = (ti.getDefn().getName().equals("Reference") && e.getName().equals("reference"));

    jdoc(indent, "How many allowed for this property by the implementation");
    write(indent+"public int get"+getTitle(getElementName(e.getName(), false))+"Max() { \r\n");
    write(indent+"  return "+(e.getMax().equals("*") ? "Integer.MAX_VALUE" : "1")+";\r\n");
    write(indent+"}\r\n");
    
    String simpleType = getSimpleType(tn);
    if (e.unbounded()) {
      /*
       * getXXX()for repeatable type
       */
      jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
      String listGenericType;
//      if (tn == null && e.hasContentReference()) {
//        listGenericType = root.getName();
//      } else {
        listGenericType = tn;
//      }
      write(indent+"public abstract List<"+listGenericType+"> get"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
      /*
       * setXXX(List<foo>) for repeating type
       */
      jdoc(indent, "@return Returns a reference to <code>this</code> for easy method chaining");
      write(indent+"public abstract " + ti.getName() + " set"+getTitle(getElementName(e.getName(), false))+"(" + "List<"+listGenericType+"> the" + getTitle(getElementName(e.getName(), false)) + "); \r\n");

      /*
       * hasXXX() for repeatable type
       */
      write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
      write("\r\n");
      if (e.getType().size() == 1 && (definitions.hasPrimitiveType(e.typeSummary()) || e.typeSummary().equals("xml:lang") || e.typeSummary().startsWith("canonical("))) {
        /*
         * addXXXElement() for repeatable primitive
         */
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+tn+" add"+getTitle(getElementName(e.getName(), false))+"Element();//2 \r\n");

        /*
         * addXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+ti.getName()+" add"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value); //1\r\n");

        /*
         * hasXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
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
          write(indent+"public abstract "+ti.getName()+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t); //3\r\n");
        } else {
          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public abstract "+ti.getName()+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t); //3\r\n");
        }

        /*
         * getXXXFirstRep() for repeatable element
         */
        if (!"DomainResource".equals(ti.getName())) {
          jdoc(indent, "@return The first repetition of repeating field {@link #"+getElementName(e.getName(), true)+"}, creating it if it does not already exist {1}");
          write(indent+"public abstract "+tn+" get"+getTitle(getElementName(e.getName(), false))+"FirstRep(); \r\n");
        }
      }
    } else {
      if (!"xhtml".equals(e.typeSummary()) && isJavaPrimitive(e) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
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
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        write(indent+"public abstract "+ti.getName()+" set"+getTitle(getElementName(e.getName(), false))+"Element("+tn+" value); \r\n");
        jdoc(indent, "@return "+replaceTitle(analysis.getName(), e.getDefinition()));
        write(indent+"public abstract "+simpleType+" get"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        generateAbstractSetter(e, indent, ti.getName(), tn, simpleType, analysis.getName());

        // BigDecimal sugar methods 
        if (simpleType.equals("BigDecimal")) {
          generateAbstractSetter(e, indent, ti.getName(), tn, "long", analysis.getName());
          generateAbstractSetter(e, indent, ti.getName(), tn, "double", analysis.getName());
        }        
      } else {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+tn+" get"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        if (e.getType().size() > 1 && (tn.equals("DataType") || !tn.endsWith(".DataType"))) {
          for (TypeRefComponent t : e.getType()) {
            jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
            String ttn = getTypename(t);
            write(indent+"public abstract "+ttn+" get"+getTitle(getElementName(e.getName(), false))+ttn+"() throws FHIRException; \r\n");
            write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+ttn+"(); \r\n");
          }
        }
        write(indent+"public abstract boolean has"+getTitle(getElementName(e.getName(), false))+"(); \r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public abstract "+ti.getName()+" set"+getTitle(getElementName(e.getName(), false))+"("+tn+" value); \r\n");
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

  private void generateUnimplementedAccessors(Analysis analysis, TypeInfo ti, ElementDefinition e, String indent) throws Exception {
    System.out.println("   .. unimplemented: "+e.getPath());
    String tn = e.getUserString("java.type");
    String className = ti.getName();

    if (Utilities.noString(tn)) {
      tn = e.getUserString("type");
      if (Utilities.noString(tn)) {
        throw new Error("??");
      }
    }
    boolean isReferenceRefField = (analysis.getName().equals("Reference") && e.getName().equals("reference"));
    
    jdoc(indent, "not supported on this implementation");
    write(indent+"@Override\r\n");
    write(indent+"public int get"+getTitle(getElementName(e.getName(), false))+"Max() { \r\n");
    write(indent+"  return 0;\r\n");
    write(indent+"}\r\n");
    
    String simpleType = getSimpleType(tn);
    if (e.unbounded()) {

      /*
       * getXXX()for repeatable type
       */
      jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
      String listGenericType;
      if (tn == null && e.hasContentReference()) {
        listGenericType = analysis.getName();
      } else {
        listGenericType = tn;
      }
      write(indent+"public List<"+listGenericType+"> get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
      write(indent+"  return new ArrayList<>();\r\n");
      write(indent+"}\r\n");
      /*
       * setXXX(List<foo>) for repeating type
       */
      jdoc(indent, "@return Returns a reference to <code>this</code> for easy method chaining");
      write(indent+"public " + className + " set"+getTitle(getElementName(e.getName(), false))+"(" + "List<"+listGenericType+"> the" + getTitle(getElementName(e.getName(), false)) + ") { \r\n");
      write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
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
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public "+tn+" add"+getTitle(getElementName(e.getName(), false))+"Element(){//2 \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");

        /*
         * addXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { //1\r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");

        /*
         * hasXXX(foo) for repeatable primitive
         */
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value); \r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
      } else {
        if (!definitions.hasResource(tn)) {
          /*
           * addXXX() for repeatable composite
           */
          write(indent+"public "+tn+" add"+getTitle(getElementName(e.getName(), false))+"() { //3\r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");

          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t) { //3\r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");
        } else {
          /*
           * addXXX(foo) for repeatable composite
           */
          write(indent+"public "+className+" add"+getTitle(getElementName(e.getName(), false))+"("+tn+" t) { //3\r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");
        }

        /*
         * getXXXFirstRep() for repeatable element
         */
        if (!"DomainResource".equals(className)) {
          jdoc(indent, "@return The first repetition of repeating field {@link #"+getElementName(e.getName(), true)+"}, creating it if it does not already exist {2}");
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"FirstRep() { \r\n");
          write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
          write(indent+"}\r\n");
        }
      }
    } else {
      if (!"xhtml".equals(e.typeSummary()) && isJavaPrimitive(e) || (e.getType().size() == 1 && e.typeSummary().startsWith("canonical("))) {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        if (isReferenceRefField) {
          /*
           * Reference#getReferenceElement is defined differently in BaseReference.java?
           */
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element_() { \r\n");
        } else { 
          write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"Element() { \r\n");
        }
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        write("\r\n");

        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"Element() { \r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() {\r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
        write("\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+"). This is the underlying object with id, value and extensions. The accessor \"get"+getTitle(getElementName(e.getName(), false))+"\" gives direct access to the value");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"Element("+tn+" value) { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        write(indent+"public "+simpleType+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        generateUnimplementedSetter(analysis, e, indent, className, tn, simpleType, analysis.getName());

        // BigDecimal sugar methods 
        if (simpleType.equals("BigDecimal")) {
          generateUnimplementedSetter(analysis, e, indent, className, tn, "long", analysis.getName());
          generateUnimplementedSetter(analysis, e, indent, className, tn, "double", analysis.getName());
        }        
      } else {
        jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        if (e.getType().size() > 1 && (tn.equals("DataType") || !tn.endsWith(".DataType"))) {
          for (TypeRefComponent t : e.getType()) {
            jdoc(indent, "@return {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
            String ttn = getTypename(t);
            write(indent+"public "+ttn+" get"+getTitle(getElementName(e.getName(), false))+ttn+"() { throws FHIRException; \r\n");
            write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
            write(indent+"}\r\n");
            write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+ttn+"() { \r\n");
          }
        }
        write(indent+"public boolean has"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
        write(indent+"  return false;\r\n");
        write(indent+"}\r\n");
        jdoc(indent, "@param value {@link #"+getElementName(e.getName(), true)+"} ("+replaceTitle(analysis.getName(), e.getDefinition())+")");
        write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+tn+" value) { \r\n");
        write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
        write(indent+"}\r\n");
        write("\r\n");
      }
    }

  }


  private void generateUnimplementedSetter(Analysis analysis, ElementDefinition e, String indent, String className, String tn, String simpleType, String rn) throws IOException {
    jdoc(indent, "@param value "+replaceTitle(rn, e.getDefinition()));
    write(indent+"public "+className+" set"+getTitle(getElementName(e.getName(), false))+"("+simpleType+" value) { \r\n");
    write(indent+"  throw new Error(\"The resource type \\\""+analysis.getName()+"\\\" does not implement the property \\\""+e.getName()+"\\\"\");\r\n");
    write(indent+"}\r\n");
  }
}