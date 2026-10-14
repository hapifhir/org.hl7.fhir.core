{{startMark}}
package {{pid}};

{{license}}


import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.formats.JsonParserBase;
import org.hl7.fhir.model.core.formats.ParserBase;
import org.hl7.fhir.model.core.formats.ParserBase.IParserFactory;
import org.hl7.fhir.model.core.formats.XmlParserBase;
import org.hl7.fhir.model.utilities.formats.JsonCreator;
import org.hl7.fhir.utilities.xml.IXMLWriter;

{{generated}}
public class {{jname}}Registration {

  /**
   * Register the resources in this package with the given model context, so that its parsers 
   * and serialisers can handle them. The registration only affects this model context, not 
   * the whole process.
   * 
   * If overridesBase is true, these resources take precedence over any resources with the 
   * same names defined in the base specification; if it is false, they are only used for 
   * resource names that the base specification doesn't define. Whether overriding the base 
   * resources makes sense (or is the whole point) depends on the resources in this package - 
   * see the package documentation. The parameter is always present for consistency across 
   * the generated packages
   * 
   * @return the versioned package id the code in this java package was generated from
   */
  public static String register(IModelContext modelContext, boolean overridesBase) {    
    String packageName = Constants.PACKAGE_NAME+"#"+Constants.VERSION;

{{register}}

    return packageName;
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
    public JsonParserBase composerJson(IModelContext modelContext, JsonCreator json) {
      return new {{jname}}JsonParser(modelContext, json);
    }
    @Override
    public JsonParserBase parserJson(IModelContext modelContext, boolean allowUnknownContent, boolean allowComments) {
      return new {{jname}}JsonParser(modelContext, allowUnknownContent, allowComments);
    }
    @Override
    public XmlParserBase composerXml(IModelContext modelContext, IXMLWriter xml) {
      return new {{jname}}XmlParser(modelContext, xml);
    }
    @Override
    public XmlParserBase parserXml(IModelContext modelContext, boolean allowUnknownContent) {
      return new {{jname}}XmlParser(modelContext, allowUnknownContent);
    }
  }
  
}
