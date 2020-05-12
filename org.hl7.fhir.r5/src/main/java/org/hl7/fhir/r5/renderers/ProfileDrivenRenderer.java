package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.model.Address;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Attachment;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Base64BinaryType;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Dosage;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.InstantType;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.Period;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Range;
import org.hl7.fhir.r5.model.Ratio;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.RelatedArtifact;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SampledData;
import org.hl7.fhir.r5.model.Signature;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.Timing;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers.BaseWrapperDirect;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers.PropertyWrapperDirect;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers.ResourceWrapperDirect;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.DOMWrappers.ResourceWrapperElement;
import org.hl7.fhir.r5.renderers.utils.DOMWrappers.BaseWrapperElement;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.utils.XVerExtensionManager.XVerExtensionStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Element;

public class ProfileDrivenRenderer extends ResourceRenderer {

  
  public ProfileDrivenRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public ProfileDrivenRenderer(RenderingContext context) {
    super(context);
  }

  @Override
  public boolean render(XhtmlNode x, DomainResource r) throws FHIRFormatError, DefinitionException, IOException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String display(DomainResource r) throws UnsupportedEncodingException, IOException {
    return "todo";
  }

  public void inject(Element er, XhtmlNode x, NarrativeStatus status, boolean pretty) {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    Element le = XMLUtil.getNamedChild(er, "language");
    String l = le == null ? null : le.getAttribute("value");
    if (!Utilities.noString(l)) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", l);
      x.setAttribute("xml:lang", l);
    }
    Element txt = XMLUtil.getNamedChild(er, "text");
    if (txt == null) {
      txt = er.getOwnerDocument().createElementNS(FormatUtilities.FHIR_NS, "text");
      Element n = XMLUtil.getFirstChild(er);
      while (n != null && (n.getNodeName().equals("id") || n.getNodeName().equals("meta") || n.getNodeName().equals("implicitRules") || n.getNodeName().equals("language")))
        n = XMLUtil.getNextSibling(n);
      if (n == null)
        er.appendChild(txt);
      else
        er.insertBefore(txt, n);
    }
    Element st = XMLUtil.getNamedChild(txt, "status");
    if (st == null) {
      st = er.getOwnerDocument().createElementNS(FormatUtilities.FHIR_NS, "status");
      Element n = XMLUtil.getFirstChild(txt);
      if (n == null)
        txt.appendChild(st);
      else
        txt.insertBefore(st, n);
    }
    st.setAttribute("value", status.toCode());
    Element div = XMLUtil.getNamedChild(txt, "div");
    if (div == null) {
      div = er.getOwnerDocument().createElementNS(FormatUtilities.XHTML_NS, "div");
      div.setAttribute("xmlns", FormatUtilities.XHTML_NS);
      txt.appendChild(div);
    }
    if (div.hasChildNodes())
      div.appendChild(er.getOwnerDocument().createElementNS(FormatUtilities.XHTML_NS, "hr"));
    new XhtmlComposer(XhtmlComposer.XML, pretty).compose(div, x);
  }

  public void inject(org.hl7.fhir.r5.elementmodel.Element er, XhtmlNode x, NarrativeStatus status, boolean pretty) throws IOException, FHIRException {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    String l = er.getChildValue("language");
    if (!Utilities.noString(l)) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", l);
      x.setAttribute("xml:lang", l);
    }
    org.hl7.fhir.r5.elementmodel.Element txt = er.getNamedChild("text");
    if (txt == null) {
      txt = new org.hl7.fhir.r5.elementmodel.Element("text", er.getProperty().getChild(null, "text"));
      int i = 0;
      while (i < er.getChildren().size() && (er.getChildren().get(i).getName().equals("id") || er.getChildren().get(i).getName().equals("meta") || er.getChildren().get(i).getName().equals("implicitRules") || er.getChildren().get(i).getName().equals("language")))
        i++;
      if (i >= er.getChildren().size())
        er.getChildren().add(txt);
      else
        er.getChildren().add(i, txt);
    }
    org.hl7.fhir.r5.elementmodel.Element st = txt.getNamedChild("status");
    if (st == null) {
      st = new org.hl7.fhir.r5.elementmodel.Element("status", txt.getProperty().getChild(null, "status"));
      txt.getChildren().add(0, st);
    }
    st.setValue(status.toCode());
    org.hl7.fhir.r5.elementmodel.Element div = txt.getNamedChild("div");
    if (div == null) {
      div = new org.hl7.fhir.r5.elementmodel.Element("div", txt.getProperty().getChild(null, "div"));
      txt.getChildren().add(div);
      div.setValue(new XhtmlComposer(XhtmlComposer.XML, pretty).compose(x));
    }
    div.setValue(x.toString());
    div.setXhtml(x);
  }


  
  public void generateResourceSummary(XhtmlNode x, ResourceWrapper res, boolean textAlready, boolean showCodeDetails) throws FHIRException, UnsupportedEncodingException, IOException {
    if (!textAlready) {
      XhtmlNode div = res.getNarrative();
      if (div != null) {
        if (div.allChildrenAreText())
          x.getChildNodes().addAll(div.getChildNodes());
        if (div.getChildNodes().size() == 1 && div.getChildNodes().get(0).allChildrenAreText())
          x.getChildNodes().addAll(div.getChildNodes().get(0).getChildNodes());
      }
      x.tx("Generated Summary: ");
    }
    String path = res.getName();
    StructureDefinition profile = getContext().getWorker().fetchResource(StructureDefinition.class, path);
    if (profile == null)
      x.tx("unknown resource " +path);
    else {
      boolean firstElement = true;
      boolean last = false;
      for (PropertyWrapper p : res.children()) {
        ElementDefinition child = getElementDefinition(profile.getSnapshot().getElement(), path+"."+p.getName(), p);
        if (p.getValues().size() > 0 && p.getValues().get(0) != null && child != null && isPrimitive(child) && includeInSummary(child)) {
          if (firstElement)
            firstElement = false;
          else if (last)
            x.tx("; ");
          boolean first = true;
          last = false;
          for (BaseWrapper v : p.getValues()) {
            if (first)
              first = false;
            else if (last)
              x.tx(", ");
            last = displayLeaf(res, v, child, x, p.getName(), showCodeDetails) || last;
          }
        }
      }
    }
  }


  private boolean includeInSummary(ElementDefinition child) {
    if (child.getIsModifier())
      return true;
    if (child.getMustSupport())
      return true;
    if (child.getType().size() == 1) {
      String t = child.getType().get(0).getWorkingCode();
      if (t.equals("Address") || t.equals("Contact") || t.equals("Reference") || t.equals("Uri") || t.equals("Url") || t.equals("Canonical"))
        return false;
    }
    return true;
  }
  
  private ElementDefinition getElementDefinition(List<ElementDefinition> elements, String path, PropertyWrapper p) {
    for (ElementDefinition element : elements)
      if (element.getPath().equals(path))
        return element;
    if (path.endsWith("\"]") && p.getStructure() != null)
      return p.getStructure().getSnapshot().getElement().get(0);
    return null;
  }

  private void renderLeaf(ResourceWrapper res, BaseWrapper ew, ElementDefinition defn, XhtmlNode x, boolean title, boolean showCodeDetails, Map<String, String> displayHints, String path, int indent) throws FHIRException, UnsupportedEncodingException, IOException {
    if (ew == null)
      return;


    Base e = ew.getBase();

    if (e instanceof StringType)
      x.addText(((StringType) e).getValue());
    else if (e instanceof CodeType)
      x.addText(((CodeType) e).getValue());
    else if (e instanceof IdType)
      x.addText(((IdType) e).getValue());
    else if (e instanceof Extension)
      return;
    else if (e instanceof InstantType)
      x.addText(((InstantType) e).toHumanDisplay());
    else if (e instanceof DateTimeType) {
      renderDateTime(x, e);
    } else if (e instanceof Base64BinaryType)
      x.addText(new Base64().encodeAsString(((Base64BinaryType) e).getValue()));
    else if (e instanceof org.hl7.fhir.r5.model.DateType)
      x.addText(((org.hl7.fhir.r5.model.DateType) e).toHumanDisplay());
    else if (e instanceof Enumeration) {
      Object ev = ((Enumeration<?>) e).getValue();
      x.addText(ev == null ? "" : ev.toString()); // todo: look up a display name if there is one
    } else if (e instanceof BooleanType)
      x.addText(((BooleanType) e).getValue().toString());
    else if (e instanceof CodeableConcept) {
      renderCodeableConcept(x, (CodeableConcept) e, showCodeDetails);
    } else if (e instanceof Coding) {
      renderCoding(x, (Coding) e, showCodeDetails);
    } else if (e instanceof Annotation) {
      renderAnnotation(x, (Annotation) e);
    } else if (e instanceof Identifier) {
      renderIdentifier(x, (Identifier) e);
    } else if (e instanceof org.hl7.fhir.r5.model.IntegerType) {
      x.addText(Integer.toString(((org.hl7.fhir.r5.model.IntegerType) e).getValue()));
    } else if (e instanceof org.hl7.fhir.r5.model.DecimalType) {
      x.addText(((org.hl7.fhir.r5.model.DecimalType) e).getValue().toString());
    } else if (e instanceof HumanName) {
      renderHumanName(x, (HumanName) e);
    } else if (e instanceof SampledData) {
      renderSampledData(x, (SampledData) e);
    } else if (e instanceof Address) {
      renderAddress(x, (Address) e);
    } else if (e instanceof ContactPoint) {
      renderContactPoint(x, (ContactPoint) e);
    } else if (e instanceof ContactDetail) {
      ContactDetail cd = (ContactDetail) e;
      if (cd.hasName()) {
        x.tx(cd.getName()+": ");
      }
      boolean first = true;
      for (ContactPoint c : cd.getTelecom()) {
        if (first) first = false; else x.tx(",");
        renderContactPoint(x, c);
      }
    } else if (e instanceof UriType) {
      renderUri(x, (UriType) e, defn.getPath(), rcontext != null && rcontext.getResourceResource() != null ? rcontext.getResourceResource().getId() : null);
    } else if (e instanceof Timing) {
      renderTiming(x, (Timing) e);
    } else if (e instanceof Range) {
      renderRange(x, (Range) e);
    } else if (e instanceof Quantity) {
      renderQuantity(x, (Quantity) e, showCodeDetails);
    } else if (e instanceof Ratio) {
      renderQuantity(x, ((Ratio) e).getNumerator(), showCodeDetails);
      x.tx("/");
      renderQuantity(x, ((Ratio) e).getDenominator(), showCodeDetails);
    } else if (e instanceof Period) {
      Period p = (Period) e;
      renderPeriod(x, p);
    } else if (e instanceof Reference) {
      Reference r = (Reference) e;
      renderReference(res, x, r);
    } else if (e instanceof Resource) {
      return;
    } else if (e instanceof ElementDefinition) {
      x.tx("todo-bundle");
    } else if (e != null && !(e instanceof Attachment) && !(e instanceof Narrative) && !(e instanceof Meta)) {
      StructureDefinition sd = getContext().getWorker().fetchTypeDefinition(e.fhirType());
      if (sd == null)
        throw new NotImplementedException("type "+e.getClass().getName()+" not handled yet, and no structure found");
      else
        generateByProfile(res, sd, ew, sd.getSnapshot().getElement(), sd.getSnapshot().getElementFirstRep(),
            getChildrenForPath(sd.getSnapshot().getElement(), sd.getSnapshot().getElementFirstRep().getPath()), x, path, showCodeDetails, indent + 1);
    }
  }

  private boolean displayLeaf(ResourceWrapper res, BaseWrapper ew, ElementDefinition defn, XhtmlNode x, String name, boolean showCodeDetails) throws FHIRException, UnsupportedEncodingException, IOException {
    if (ew == null)
      return false;
    Base e = ew.getBase();
    if (e == null)
      return false;

    Map<String, String> displayHints = readDisplayHints(defn);

    if (name.endsWith("[x]"))
      name = name.substring(0, name.length() - 3);

    if (!showCodeDetails && e instanceof PrimitiveType && isDefault(displayHints, ((PrimitiveType) e)))
      return false;

    if (e instanceof StringType) {
      x.addText(name+": "+((StringType) e).getValue());
      return true;
    } else if (e instanceof CodeType) {
      x.addText(name+": "+((CodeType) e).getValue());
      return true;
    } else if (e instanceof IdType) {
      x.addText(name+": "+((IdType) e).getValue());
      return true;
    } else if (e instanceof UriType) {
      x.addText(name+": "+((UriType) e).getValue());
      return true;
    } else if (e instanceof DateTimeType) {
      x.addText(name+": "+((DateTimeType) e).toHumanDisplay());
      return true;
    } else if (e instanceof InstantType) {
      x.addText(name+": "+((InstantType) e).toHumanDisplay());
      return true;
    } else if (e instanceof Extension) {
      //      x.tx("Extensions: todo");
      return false;
    } else if (e instanceof org.hl7.fhir.r5.model.DateType) {
      x.addText(name+": "+((org.hl7.fhir.r5.model.DateType) e).toHumanDisplay());
      return true;
    } else if (e instanceof Enumeration) {
      x.addText(((Enumeration<?>) e).getValue().toString()); // todo: look up a display name if there is one
      return true;
    } else if (e instanceof BooleanType) {
      if (((BooleanType) e).getValue()) {
        x.addText(name);
        return true;
      }
    } else if (e instanceof CodeableConcept) {
      renderCodeableConcept(x, (CodeableConcept) e, showCodeDetails);
      return true;
    } else if (e instanceof Coding) {
      renderCoding(x, (Coding) e, showCodeDetails);
      return true;
    } else if (e instanceof Annotation) {
      renderAnnotation(x, (Annotation) e, showCodeDetails);
      return true;
    } else if (e instanceof org.hl7.fhir.r5.model.IntegerType) {
      x.addText(Integer.toString(((org.hl7.fhir.r5.model.IntegerType) e).getValue()));
      return true;
    } else if (e instanceof org.hl7.fhir.r5.model.DecimalType) {
      x.addText(((org.hl7.fhir.r5.model.DecimalType) e).getValue().toString());
      return true;
    } else if (e instanceof Identifier) {
      renderIdentifier(x, (Identifier) e);
      return true;
    } else if (e instanceof HumanName) {
      renderHumanName(x, (HumanName) e);
      return true;
    } else if (e instanceof SampledData) {
      renderSampledData(x, (SampledData) e);
      return true;
    } else if (e instanceof Address) {
      renderAddress(x, (Address) e);
      return true;
    } else if (e instanceof ContactPoint) {
      renderContactPoint(x, (ContactPoint) e);
      return true;
    } else if (e instanceof Timing) {
      renderTiming(x, (Timing) e);
      return true;
    } else if (e instanceof Quantity) {
      renderQuantity(x, (Quantity) e, showCodeDetails);
      return true;
    } else if (e instanceof Ratio) {
      renderQuantity(x, ((Ratio) e).getNumerator(), showCodeDetails);
      x.tx("/");
      renderQuantity(x, ((Ratio) e).getDenominator(), showCodeDetails);
      return true;
    } else if (e instanceof Period) {
      Period p = (Period) e;
      x.addText(name+": ");
      x.addText(!p.hasStart() ? "?ngen-2?" : p.getStartElement().toHumanDisplay());
      x.tx(" --> ");
      x.addText(!p.hasEnd() ? "(ongoing)" : p.getEndElement().toHumanDisplay());
      return true;
    } else if (e instanceof Reference) {
      Reference r = (Reference) e;
      if (r.hasDisplayElement())
        x.addText(r.getDisplay());
      else if (r.hasReferenceElement()) {
        ResourceWithReference tr = resolveReference(res, r.getReference());
        x.addText(tr == null ? r.getReference() : "?ngen-3"); // getDisplayForReference(tr.getReference()));
      } else
        x.tx("?ngen-4?");
      return true;
    } else if (e instanceof Narrative) {
      return false;
    } else if (e instanceof Resource) {
      return false;
    } else if (e instanceof ContactDetail) {
      ContactDetail cd = (ContactDetail) e;
      if (cd.hasName()) {
        x.tx(cd.getName()+": ");
      }
      boolean first = true;
      for (ContactPoint c : cd.getTelecom()) {
        if (first) first = false; else x.tx(",");
        renderContactPoint(x, c);
      }
      return true;
    } else if (e instanceof Range) {
      return false;
    } else if (e instanceof Meta) {
      return false;
    } else if (e instanceof Dosage) {
      return false;
    } else if (e instanceof Signature) {
      return false;
    } else if (e instanceof UsageContext) {
      return false;
    } else if (e instanceof RelatedArtifact) {
      return false;
    } else if (e instanceof ElementDefinition) {
      return false;
    } else if (e instanceof Base64BinaryType) {
      return false;
    } else if (!(e instanceof Attachment))
      throw new NotImplementedException("type "+e.getClass().getName()+" not handled yet");
    return false;
  }



  private boolean isPrimitive(ElementDefinition e) {
    //we can tell if e is a primitive because it has types
    if (e.getType().isEmpty())
      return false;
    if (e.getType().size() == 1 && isBase(e.getType().get(0).getWorkingCode()))
      return false;
    return true;
    //    return !e.getType().isEmpty()
  }

  private boolean isBase(String code) {
    return code.equals("Element") || code.equals("BackboneElement");
  }
  
  private List<ElementDefinition> getChildrenForPath(List<ElementDefinition> elements, String path) throws DefinitionException {
    // do we need to do a name reference substitution?
    for (ElementDefinition e : elements) {
      if (e.getPath().equals(path) && e.hasContentReference()) {
        String ref = e.getContentReference();
        ElementDefinition t = null;
        // now, resolve the name
        for (ElementDefinition e1 : elements) {
          if (ref.equals("#"+e1.getId()))
            t = e1;
        }
        if (t == null)
          throw new DefinitionException("Unable to resolve content reference "+ref+" trying to resolve "+path);
        path = t.getPath();
        break;
      }
    }

    List<ElementDefinition> results = new ArrayList<ElementDefinition>();
    for (ElementDefinition e : elements) {
      if (e.getPath().startsWith(path+".") && !e.getPath().substring(path.length()+1).contains("."))
        results.add(e);
    }
    return results;
  }


  private boolean generateByProfile(StructureDefinition profile, boolean showCodeDetails) {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.para().b().tx("Generated Narrative"+(showCodeDetails ? " with Details" : ""));
    try {
      generateByProfile(rcontext.getResourceResource(), profile, rcontext.getResourceResource(), profile.getSnapshot().getElement(), profile.getSnapshot().getElement().get(0), getChildrenForPath(profile.getSnapshot().getElement(), rcontext.getResourceResource().getResourceType().toString()), x, rcontext.getResourceResource().getResourceType().toString(), showCodeDetails);
    } catch (Exception e) {
      e.printStackTrace();
      x.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    inject(rcontext.getResourceResource(), x,  NarrativeStatus.GENERATED);
    return true;
  }

  private String generateByProfile(Element er, StructureDefinition profile, boolean showCodeDetails) throws IOException, org.hl7.fhir.exceptions.FHIRException {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    x.para().b().tx("Generated Narrative"+(showCodeDetails ? " with Details" : ""));
    try {
      generateByProfile(er, profile, er, profile.getSnapshot().getElement(), profile.getSnapshot().getElement().get(0), getChildrenForPath(profile.getSnapshot().getElement(), er.getLocalName()), x, er.getLocalName(), showCodeDetails);
    } catch (Exception e) {
      e.printStackTrace();
      x.para().b().style("color: maroon").tx("Exception generating Narrative: "+e.getMessage());
    }
    inject(er, x,  NarrativeStatus.GENERATED, false);
    String b = new XhtmlComposer(XhtmlComposer.XML, false).compose(x);
    return b;
  }

  private void generateByProfile(Element eres, StructureDefinition profile, Element ee, List<ElementDefinition> allElements, ElementDefinition defn, List<ElementDefinition> children,  XhtmlNode x, String path, boolean showCodeDetails) throws FHIRException, UnsupportedEncodingException, IOException {

    ResourceWrapperElement resw = new ResourceWrapperElement(this, eres, profile);
    BaseWrapperElement base = new BaseWrapperElement(this, ee, null, profile, profile.getSnapshot().getElement().get(0));
    generateByProfile(resw, profile, base, allElements, defn, children, x, path, showCodeDetails, 0);
  }


  private void generateByProfile(Resource res, StructureDefinition profile, Base e, List<ElementDefinition> allElements, ElementDefinition defn, List<ElementDefinition> children,  XhtmlNode x, String path, boolean showCodeDetails) throws FHIRException, UnsupportedEncodingException, IOException {
    generateByProfile(new ResourceWrapperDirect(this, res), profile, new BaseWrapperDirect(this, e), allElements, defn, children, x, path, showCodeDetails, 0);
  }

  private void generateByProfile(ResourceWrapper res, StructureDefinition profile, BaseWrapper e, List<ElementDefinition> allElements, ElementDefinition defn, List<ElementDefinition> children,  XhtmlNode x, String path, boolean showCodeDetails, int indent) throws FHIRException, UnsupportedEncodingException, IOException {
    if (children.isEmpty()) {
      renderLeaf(res, e, defn, x, false, showCodeDetails, readDisplayHints(defn), path, indent);
    } else {
      for (PropertyWrapper p : splitExtensions(profile, e.children())) {
        if (p.hasValues()) {
          ElementDefinition child = getElementDefinition(children, path+"."+p.getName(), p);
          if (child != null) {
            Map<String, String> displayHints = readDisplayHints(child);
            if (!exemptFromRendering(child)) {
              List<ElementDefinition> grandChildren = getChildrenForPath(allElements, path+"."+p.getName());
              filterGrandChildren(grandChildren, path+"."+p.getName(), p);
              if (p.getValues().size() > 0 && child != null) {
                if (isPrimitive(child)) {
                  XhtmlNode para = x.para();
                  String name = p.getName();
                  if (name.endsWith("[x]"))
                    name = name.substring(0, name.length() - 3);
                  if (showCodeDetails || !isDefaultValue(displayHints, p.getValues())) {
                    para.b().addText(name);
                    para.tx(": ");
                    if (renderAsList(child) && p.getValues().size() > 1) {
                      XhtmlNode list = x.ul();
                      for (BaseWrapper v : p.getValues())
                        renderLeaf(res, v, child, list.li(), false, showCodeDetails, displayHints, path, indent);
                    } else {
                      boolean first = true;
                      for (BaseWrapper v : p.getValues()) {
                        if (first)
                          first = false;
                        else
                          para.tx(", ");
                        renderLeaf(res, v, child, para, false, showCodeDetails, displayHints, path, indent);
                      }
                    }
                  }
                } else if (canDoTable(path, p, grandChildren)) {
                  x.addTag(getHeader()).addText(Utilities.capitalize(Utilities.camelCase(Utilities.pluralizeMe(p.getName()))));
                  XhtmlNode tbl = x.table( "grid");
                  XhtmlNode tr = tbl.tr();
                  tr.td().tx("-"); // work around problem with empty table rows
                  addColumnHeadings(tr, grandChildren);
                  for (BaseWrapper v : p.getValues()) {
                    if (v != null) {
                      tr = tbl.tr();
                      tr.td().tx("*"); // work around problem with empty table rows
                      addColumnValues(res, tr, grandChildren, v, showCodeDetails, displayHints, path, indent);
                    }
                  }
                } else {
                  for (BaseWrapper v : p.getValues()) {
                    if (v != null) {
                      XhtmlNode bq = x.addTag("blockquote");
                      bq.para().b().addText(p.getName());
                      generateByProfile(res, profile, v, allElements, child, grandChildren, bq, path+"."+p.getName(), showCodeDetails, indent+1);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }


  private String getHeader() {
    int i = 3;
    while (i <= context.getHeaderLevelContext())
      i++;
    if (i > 6)
      i = 6;
    return "h"+Integer.toString(i);
  }

  private List<PropertyWrapper> getValues(String path, PropertyWrapper p, ElementDefinition e) {
    List<PropertyWrapper> res = new ArrayList<PropertyWrapper>();
    for (BaseWrapper v : p.getValues()) {
      for (PropertyWrapper g : v.children()) {
        if ((path+"."+p.getName()+"."+g.getName()).equals(e.getPath()))
          res.add(p);
      }
    }
    return res;
  }
  
  private boolean canDoTable(String path, PropertyWrapper p, List<ElementDefinition> grandChildren) {
    for (ElementDefinition e : grandChildren) {
      List<PropertyWrapper> values = getValues(path, p, e);
      if (values.size() > 1 || !isPrimitive(e) || !canCollapse(e))
        return false;
    }
    return true;
  }


  private boolean canCollapse(ElementDefinition e) {
    // we can collapse any data type
    return !e.getType().isEmpty();
  }
  private boolean exemptFromRendering(ElementDefinition child) {
    if (child == null)
      return false;
    if ("Composition.subject".equals(child.getPath()))
      return true;
    if ("Composition.section".equals(child.getPath()))
      return true;
    return false;
  }

  private boolean renderAsList(ElementDefinition child) {
    if (child.getType().size() == 1) {
      String t = child.getType().get(0).getWorkingCode();
      if (t.equals("Address") || t.equals("Reference"))
        return true;
    }
    return false;
  }

  private void addColumnHeadings(XhtmlNode tr, List<ElementDefinition> grandChildren) {
    for (ElementDefinition e : grandChildren)
      tr.td().b().addText(Utilities.capitalize(tail(e.getPath())));
  }

  private void addColumnValues(ResourceWrapper res, XhtmlNode tr, List<ElementDefinition> grandChildren, BaseWrapper v, boolean showCodeDetails, Map<String, String> displayHints, String path, int indent) throws FHIRException, UnsupportedEncodingException, IOException {
    for (ElementDefinition e : grandChildren) {
      PropertyWrapper p = v.getChildByName(e.getPath().substring(e.getPath().lastIndexOf(".")+1));
      if (p == null || p.getValues().size() == 0 || p.getValues().get(0) == null)
        tr.td().tx(" ");
      else
        renderLeaf(res, p.getValues().get(0), e, tr.td(), false, showCodeDetails, displayHints, path, indent);
    }
  }

  private void filterGrandChildren(List<ElementDefinition> grandChildren,  String string, PropertyWrapper prop) {
    List<ElementDefinition> toRemove = new ArrayList<ElementDefinition>();
    toRemove.addAll(grandChildren);
    for (BaseWrapper b : prop.getValues()) {
      List<ElementDefinition> list = new ArrayList<ElementDefinition>();
      for (ElementDefinition ed : toRemove) {
        PropertyWrapper p = b.getChildByName(tail(ed.getPath()));
        if (p != null && p.hasValues())
          list.add(ed);
      }
      toRemove.removeAll(list);
    }
    grandChildren.removeAll(toRemove);
  }

  private List<PropertyWrapper> splitExtensions(StructureDefinition profile, List<PropertyWrapper> children) throws UnsupportedEncodingException, IOException, FHIRException {
    List<PropertyWrapper> results = new ArrayList<PropertyWrapper>();
    Map<String, PropertyWrapper> map = new HashMap<String, PropertyWrapper>();
    for (PropertyWrapper p : children)
      if (p.getName().equals("extension") || p.getName().equals("modifierExtension")) {
        // we're going to split these up, and create a property for each url
        if (p.hasValues()) {
          for (BaseWrapper v : p.getValues()) {
            Extension ex  = (Extension) v.getBase();
            String url = ex.getUrl();
            StructureDefinition ed = getContext().getWorker().fetchResource(StructureDefinition.class, url);
            if (ed == null) {
              if (xverManager == null) {
                xverManager = new XVerExtensionManager(context.getWorker());
              }
              if (xverManager.matchingUrl(url) && xverManager.status(url) == XVerExtensionStatus.Valid) {
                ed = xverManager.makeDefinition(url);
                getContext().getWorker().generateSnapshot(ed);
                getContext().getWorker().cacheResource(ed);
              }
            }
            if (p.getName().equals("modifierExtension") && ed == null)
              throw new DefinitionException("Unknown modifier extension "+url);
            PropertyWrapper pe = map.get(p.getName()+"["+url+"]");
            if (pe == null) {
              if (ed == null) {
                if (url.startsWith("http://hl7.org/fhir") && !url.startsWith("http://hl7.org/fhir/us"))
                  throw new DefinitionException("unknown extension "+url);
                // System.out.println("unknown extension "+url);
                pe = new PropertyWrapperDirect(this, new Property(p.getName()+"["+url+"]", p.getTypeCode(), p.getDefinition(), p.getMinCardinality(), p.getMaxCardinality(), ex));
              } else {
                ElementDefinition def = ed.getSnapshot().getElement().get(0);
                pe = new PropertyWrapperDirect(this, new Property(p.getName()+"["+url+"]", "Extension", def.getDefinition(), def.getMin(), def.getMax().equals("*") ? Integer.MAX_VALUE : Integer.parseInt(def.getMax()), ex));
                ((PropertyWrapperDirect) pe).getWrapped().setStructure(ed);
              }
              results.add(pe);
            } else
              pe.getValues().add(v);
          }
        }
      } else
        results.add(p);
    return results;
  }


  private Map<String, String> readDisplayHints(ElementDefinition defn) throws DefinitionException {
    Map<String, String> hints = new HashMap<String, String>();
    if (defn != null) {
      String displayHint = ToolingExtensions.getDisplayHint(defn);
      if (!Utilities.noString(displayHint)) {
        String[] list = displayHint.split(";");
        for (String item : list) {
          String[] parts = item.split(":");
          if (parts.length != 2)
            throw new DefinitionException("error reading display hint: '"+displayHint+"'");
          hints.put(parts[0].trim(), parts[1].trim());
        }
      }
    }
    return hints;
  }

  @SuppressWarnings("rawtypes")
  private boolean isDefaultValue(Map<String, String> displayHints, List<BaseWrapper> list) throws UnsupportedEncodingException, IOException, FHIRException {
    if (list.size() != 1)
      return false;
    if (list.get(0).getBase() instanceof PrimitiveType)
      return isDefault(displayHints, (PrimitiveType) list.get(0).getBase());
    else
      return false;
  }

  private boolean isDefault(Map<String, String> displayHints, PrimitiveType primitiveType) {
    String v = primitiveType.asStringValue();
    if (!Utilities.noString(v) && displayHints.containsKey("default") && v.equals(displayHints.get("default")))
      return true;
    return false;
  }


  protected String tail(String path) {
    return path.substring(path.lastIndexOf(".")+1);
  }


}