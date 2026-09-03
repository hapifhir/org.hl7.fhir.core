{{startMark}}
package {{pid}};

{{license}}


import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.r5.formats.JsonParserBase;
import org.hl7.fhir.r5.formats.ParserBase.IParserFactory;
import org.hl7.fhir.r5.formats.XmlParserBase;
import org.hl7.fhir.utilities.xml.IXMLWriter;

{{generated}}
public class {{jname}}Registration {

  /**
   * Register the parsers for the resources in this package with the core parsers. 
   * 
   * If overridesBase is true, these resources take precedence over any resources with the 
   * same names defined in the base specification; if it is false, they are only used for 
   * resource names that the base specification doesn't define. Whether overriding the base 
   * resources makes sense (or is the whole point) depends on the resources in this package - 
   * see the package documentation. The parameter is always present for consistency across 
   * the generated packages
   */
  public static void register(boolean overridesBase) {    
    register(org.hl7.fhir.r5.formats.CustomResourceRegistry.GLOBAL, overridesBase);
  }

  /**
   * Register the parsers for the resources in this package into the given custom resource 
   * registry, rather than the global one - so the registration only affects parsers that are 
   * given this registry, not the whole process. See register(boolean) for the meaning of 
   * overridesBase
   */
  public static void register(org.hl7.fhir.r5.formats.CustomResourceRegistry registry, boolean overridesBase) {    
{{register}}
  }

  /**
   * The versioned package id(s) of the package(s) that the code in this java package was 
   * generated from. An application that registers these resources will usually also need to 
   * load these packages into its worker context, so that the definitions in the context 
   * agree with the generated code
   */
  public static String[] packages() {    
    return new String[] { {{packages}} };
  }

  public static class {{jname}}JsonParserFactory implements IParserFactory {
    @Override
    public JsonParserBase composerJson(JsonCreator json) {
      return new {{jname}}JsonParser(json);
    }
    @Override
    public JsonParserBase parserJson(boolean allowUnknownContent, boolean allowComments) {
      return new {{jname}}JsonParser(allowUnknownContent, allowComments);
    }
    @Override
    public XmlParserBase composerXml(IXMLWriter xml) {
      return new {{jname}}XmlParser(xml);
    }
    @Override
    public XmlParserBase parserXml(boolean allowUnknownContent) {
      return new {{jname}}XmlParser(allowUnknownContent);
    }
  }
  
}
