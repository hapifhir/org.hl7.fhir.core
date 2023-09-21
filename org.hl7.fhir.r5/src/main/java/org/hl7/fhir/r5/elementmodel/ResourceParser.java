package org.hl7.fhir.r5.elementmodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;

public class ResourceParser extends ParserBase {

  public ResourceParser(IWorkerContext context) {
    super(context);
  }

  @Override
  public List<ValidatedFragment> parse(InputStream stream) throws IOException, FHIRFormatError, DefinitionException, FHIRException {
    throw new NotImplementedException("parse(InputStream stream)"); // doesns't make sense
  }

  @Override
  public void compose(Element e, OutputStream destination, OutputStyle style, String base)
      throws FHIRException, IOException {
    throw new NotImplementedException("compose(Element e, OutputStream destination, OutputStyle style, String base)"); // doesns't make sense    
  }

  /**
   * It's possible to get an element model from an resource by writing it to a stream, and reading it, 
   * but this loads it directly, and links to the element model from the resource model
   * 
   * @param resource
   * @return
   * @throws IOException 
   */
  public Element parse(Resource resource) {
    StructureDefinition sd = context.fetchTypeDefinition(resource.fhirType());
    if (sd == null) {
      throw new FHIRException("No definition exists for "+resource.fhirType());
    }
    Property p = new Property(context, sd.getSnapshot().getElement().get(0), sd, new ProfileUtilities(context, null, null));
    String path = resource.fhirType();
    
    Element e = new Element(resource.fhirType(), p);
    e.setPath(path);
    e.setType(resource.fhirType());
    parseChildren(path, resource, e);
    e.numberChildren();
    return e;
  }

  private void parseChildren(String path, Base src, Element dst) {
    dst.setSource(src);
    dst.copyFormatComments(src);
    List<Property> properties = dst.getProperty().getChildProperties(dst.getName(), null);
    for (org.hl7.fhir.r5.model.Property c : src.children()) {
      if (c.hasValues()) {
        Property p = getPropertyByName(properties, c.getName());
        if (p == null) {
          throw new FHIRException("Unable to find property for "+path+"."+c.getName());
        }
        int i = 0;
        for (Base v : c.getValues()) {
          String npath = path+"."+c.getName()+(p.isList() ? "["+i+"]" : "");
          i++;
          String name = c.getName();
          if (name.endsWith("[x]")) {
            name = name.substring(0, name.length()-3)+Utilities.capitalize(v.fhirType());
          }
          Element n = new Element(name, p);
          dst.getChildren().add(n);
          if (v.isPrimitive()) {
            if (v.fhirType().equals("xhtml")) {
              n.setXhtml(v.getXhtml());
              try {
                n.setValue(new XhtmlComposer(true).compose(n.getXhtml()));
              } catch (Exception e) {
                // won't happen here
              }
            } else {
              n.setValue(v.primitiveValue());
            }
//            if (!n.getProperty().isChoice() && n.getType().equals("xhtml")) {
//                try {
//                  n.setXhtml(new XhtmlParser().setValidatorMode(policy == ValidationPolicy.EVERYTHING).parse(n.getValue(), null).getDocumentElement());
//                } catch (Exception e) {
//                  logError(line(main), col(main), npath, IssueType.INVALID, context.formatMessage(I18nConstants.ERROR_PARSING_XHTML_, e.getMessage()), IssueSeverity.ERROR);
//                }
//              }
//            }
          }      
          n.setPath(npath);
          if (p.isResource()) {
            StructureDefinition sd = context.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(v.fhirType(), null));
            if (sd == null)
              throw new FHIRFormatError(context.formatMessage(I18nConstants.CONTAINED_RESOURCE_DOES_NOT_APPEAR_TO_BE_A_FHIR_RESOURCE_UNKNOWN_NAME_, v.fhirType()));
            n.updateProperty(new Property(context, sd.getSnapshot().getElement().get(0), sd), SpecialElement.fromProperty(n.getProperty()), p);
            n.setType(v.fhirType());
            parseChildren(npath, v, n);
          } else {
            parseChildren(npath, v, n);
          }
        }       
      }
    }

  }

  private Property getPropertyByName(List<Property> properties, String name) {
    for (Property p : properties) {
      if (p.getName().equals(name)) {
        return p;
      }
    }
    return null;

  }
}

