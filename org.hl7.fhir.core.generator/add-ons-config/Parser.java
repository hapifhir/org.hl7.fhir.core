package {{pid}};

// generated

{{license}}

{{startMark}}

import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.r5.formats.JsonParserBase;
import org.hl7.fhir.r5.formats.ParserBase.IParserFactory;
import org.hl7.fhir.r5.formats.XmlParserBase;
import org.hl7.fhir.utilities.xml.IXMLWriter;

public class {{jname}}Parser {

  public static void register() {    
{{register}}
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
