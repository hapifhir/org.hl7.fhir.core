package org.hl7.fhir.r5.renderers;

import java.io.IOException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.model.Address;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.Timing;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.HumanName.NameUse;
import org.hl7.fhir.r5.model.Timing.EventTiming;
import org.hl7.fhir.r5.model.Timing.TimingRepeatComponent;
import org.hl7.fhir.r5.model.Timing.UnitsOfTime;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Period;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Range;
import org.hl7.fhir.r5.model.SampledData;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class DataRenderer {
  
  // -- 1. context --------------------------------------------------------------
  
  protected RenderingContext context;
  
  public DataRenderer(RenderingContext context) {
    super();
    this.context = context;
  }

  // -- 2. Markdown support -------------------------------------------------------
  
  protected void addMarkdown(XhtmlNode x, String text) throws FHIRFormatError, IOException, DefinitionException {
    if (text != null) {
      // 1. custom FHIR extensions
      while (text.contains("[[[")) {
        String left = text.substring(0, text.indexOf("[[["));
        String link = text.substring(text.indexOf("[[[")+3, text.indexOf("]]]"));
        String right = text.substring(text.indexOf("]]]")+3);
        String url = link;
        String[] parts = link.split("\\#");
        StructureDefinition p = getContext().getWorker().fetchResource(StructureDefinition.class, parts[0]);
        if (p == null)
          p = getContext().getWorker().fetchTypeDefinition(parts[0]);
        if (p == null)
          p = getContext().getWorker().fetchResource(StructureDefinition.class, link);
        if (p != null) {
          url = p.getUserString("path");
          if (url == null)
            url = p.getUserString("filename");
        } else
          throw new DefinitionException("Unable to resolve markdown link "+link);
  
        text = left+"["+link+"]("+url+")"+right;
      }
  
      // 2. markdown
      String s = getContext().getMarkdown().process(Utilities.escapeXml(text), "narrative generator");
      XhtmlParser p = new XhtmlParser();
      XhtmlNode m;
      try {
        m = p.parse("<div>"+s+"</div>", "div");
      } catch (org.hl7.fhir.exceptions.FHIRFormatError e) {
        throw new FHIRFormatError(e.getMessage(), e);
      }
      x.getChildNodes().addAll(m.getChildNodes());
    }
  }

  protected void smartAddText(XhtmlNode p, String text) {
    if (text == null)
      return;
  
    String[] lines = text.split("\\r\\n");
    for (int i = 0; i < lines.length; i++) {
      if (i > 0)
        p.br();
      p.addText(lines[i]);
    }
  }
 
  // -- 3. General Purpose Terminology Support -----------------------------------------

  public static String describeSystem(String system) {
    if (system == null)
      return "[not stated]";
    if (system.equals("http://loinc.org"))
      return "LOINC";
    if (system.startsWith("http://snomed.info"))
      return "SNOMED CT";
    if (system.equals("http://www.nlm.nih.gov/research/umls/rxnorm"))
      return "RxNorm";
    if (system.equals("http://hl7.org/fhir/sid/icd-9"))
      return "ICD-9";
    if (system.equals("http://dicom.nema.org/resources/ontology/DCM"))
      return "DICOM";
    if (system.equals("http://unitsofmeasure.org"))
      return "UCUM";
  
    return system;
  }

  protected String makeAnchor(String codeSystem, String code) {
    String s = codeSystem+'-'+code;
    StringBuilder b = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '.')
        b.append(c);
      else
        b.append('-');
    }
    return b.toString();
  }

  private String lookupCode(String system, String code) {
    ValidationResult t = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions(), system, code, null);

    if (t != null && t.getDisplay() != null)
      return t.getDisplay();
    else
      return code;
  }

  protected String describeLang(String lang) {
    ValueSet v = getContext().getWorker().fetchResource(ValueSet.class, "http://hl7.org/fhir/ValueSet/languages");
    if (v != null) {
      ConceptReferenceComponent l = null;
      for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) {
        if (cc.getCode().equals(lang))
          l = cc;
      }
      if (l == null) {
        if (lang.contains("-"))
          lang = lang.substring(0, lang.indexOf("-"));
        for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) {
          if (cc.getCode().equals(lang) || cc.getCode().startsWith(lang+"-"))
            l = cc;
        }
      }
      if (l != null) {
        if (lang.contains("-"))
          lang = lang.substring(0, lang.indexOf("-"));
        String en = l.getDisplay();
        String nativelang = null;
        for (ConceptReferenceDesignationComponent cd : l.getDesignation()) {
          if (cd.getLanguage().equals(lang))
            nativelang = cd.getValue();
        }
        if (nativelang == null)
          return en+" ("+lang+")";
        else
          return nativelang+" ("+en+", "+lang+")";
      }
    }
    return lang;
  }


  private boolean isCanonical(String path) {
    if (!path.endsWith(".url")) 
      return false;
    StructureDefinition sd = getContext().getWorker().fetchTypeDefinition(path.substring(0, path.length()-4));
    if (sd == null)
      return false;
    if (Utilities.existsInList(path.substring(0, path.length()-4), "CapabilityStatement", "StructureDefinition", "ImplementationGuide", "SearchParameter", "MessageDefinition", "OperationDefinition", "CompartmentDefinition", "StructureMap", "GraphDefinition", 
        "ExampleScenario", "CodeSystem", "ValueSet", "ConceptMap", "NamingSystem", "TerminologyCapabilities"))
      return true;
    return sd.getBaseDefinitionElement().hasExtension("http://hl7.org/fhir/StructureDefinition/structuredefinition-codegen-super");
  }

  // -- 4. Data type Rendering ---------------------------------------------- 

  public static String display(IWorkerContext context, DataType type) {
    return new DataRenderer(new RenderingContext(context, null, null, "", null, ResourceRendererMode.RESOURCE)).display(type);
  }
  
  public String display(DataType type) {
    return null;
  }

  public void render(XhtmlNode x, DataType type) {
    
  }

  public void renderDateTime(XhtmlNode x, Base e) {
    if (e.hasPrimitiveValue())
      x.addText(((DateTimeType) e).toHumanDisplay());
  }

  protected void renderUri(XhtmlNode x, UriType uri) {
    if (uri.getValue().startsWith("mailto:"))
      x.ah(uri.getValue()).addText(uri.getValue().substring(7));
    else
      x.ah(uri.getValue()).addText(uri.getValue());
  }
  
  protected void renderUri(XhtmlNode x, UriType uri, String path, String id) {
    String url = uri.getValue();
    if (isCanonical(path)) {
      CanonicalResource mr = getContext().getWorker().fetchResource(null, url);
      if (mr != null) {
        if (path.startsWith(mr.fhirType()+".") && mr.getId().equals(id)) {
          url = null; // don't link to self whatever
        } else if (mr.hasUserData("path"))
          url = mr.getUserString("path");
      } else if (!getContext().isCanonicalUrlsAsLinks())
        url = null;
    }
    if (url == null)
      x.b().tx(uri.getValue());
    else if (uri.getValue().startsWith("mailto:"))
      x.ah(uri.getValue()).addText(uri.getValue().substring(7));
    else
      x.ah(uri.getValue()).addText(uri.getValue());
  }

  protected void renderAnnotation(XhtmlNode x, Annotation annot) {
    renderAnnotation(x, annot, false);
  }

  protected void renderAnnotation(XhtmlNode x, Annotation a, boolean showCodeDetails) throws FHIRException {
    StringBuilder s = new StringBuilder();
    if (a.hasAuthor()) {
      s.append("Author: ");

      if (a.hasAuthorReference())
        s.append(a.getAuthorReference().getReference());
      else if (a.hasAuthorStringType())
        s.append(a.getAuthorStringType().getValue());
    }


    if (a.hasTimeElement()) {
      if (s.length() > 0)
        s.append("; ");

      s.append("Made: ").append(a.getTimeElement().toHumanDisplay());
    }

    if (a.hasText()) {
      if (s.length() > 0)
        s.append("; ");

      s.append("Annotation: ").append(a.getText());
    }
    x.addText(s.toString());
  }
  
  protected void renderCoding(XhtmlNode x, Coding c) {
    renderCoding(x, c, false);
  }
  
  protected void renderCoding(XhtmlNode x, Coding c, boolean showCodeDetails) {
    String s = "";
    if (c.hasDisplayElement())
      s = c.getDisplay();
    if (Utilities.noString(s))
      s = lookupCode(c.getSystem(), c.getCode());

    if (Utilities.noString(s))
      s = c.getCode();

    if (showCodeDetails) {
      x.addText(s+" (Details: "+TerminologyRenderer.describeSystem(c.getSystem())+" code "+c.getCode()+" = '"+lookupCode(c.getSystem(), c.getCode())+"', stated as '"+c.getDisplay()+"')");
    } else
      x.span(null, "{"+c.getSystem()+" "+c.getCode()+"}").addText(s);
  }

  public String displayCodeableConcept(CodeableConcept cc) {
    String s = cc.getText();
    if (Utilities.noString(s)) {
      for (Coding c : cc.getCoding()) {
        if (c.hasDisplayElement()) {
          s = c.getDisplay();
          break;
        }
      }
    }
    if (Utilities.noString(s)) {
      // still? ok, let's try looking it up
      for (Coding c : cc.getCoding()) {
        if (c.hasCode() && c.hasSystem()) {
          s = lookupCode(c.getSystem(), c.getCode());
          if (!Utilities.noString(s))
            break;
        }
      }
    }

    if (Utilities.noString(s)) {
      if (cc.getCoding().isEmpty())
        s = "";
      else
        s = cc.getCoding().get(0).getCode();
    }
    return s;
  }

  protected void renderCodeableConcept(XhtmlNode x, CodeableConcept cc) {
    renderCodeableConcept(x, cc, false);
  }
  
  protected void renderCodeableConcept(XhtmlNode x, CodeableConcept cc, boolean showCodeDetails) {
    if (cc.isEmpty()) {
      return;
    }

    String s = cc.getText();
    if (Utilities.noString(s)) {
      for (Coding c : cc.getCoding()) {
        if (c.hasDisplayElement()) {
          s = c.getDisplay();
          break;
        }
      }
    }
    if (Utilities.noString(s)) {
      // still? ok, let's try looking it up
      for (Coding c : cc.getCoding()) {
        if (c.hasCodeElement() && c.hasSystemElement()) {
          s = lookupCode(c.getSystem(), c.getCode());
          if (!Utilities.noString(s))
            break;
        }
      }
    }

    if (Utilities.noString(s)) {
      if (cc.getCoding().isEmpty())
        s = "";
      else
        s = cc.getCoding().get(0).getCode();
    }

    if (showCodeDetails) {
      x.addText(s+" ");
      XhtmlNode sp = x.span("background: LightGoldenRodYellow", null);
      sp.tx("(Details ");
      boolean first = true;
      for (Coding c : cc.getCoding()) {
        if (first) {
          sp.tx(": ");
          first = false;
        } else
          sp.tx("; ");
        sp.tx("{"+TerminologyRenderer.describeSystem(c.getSystem())+" code '"+c.getCode()+"' = '"+lookupCode(c.getSystem(), c.getCode())+(c.hasDisplay() ? "', given as '"+c.getDisplay()+"'}" : ""));
      }
      sp.tx(")");
    } else {

      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (Coding c : cc.getCoding()) {
        if (c.hasCodeElement() && c.hasSystemElement()) {
          b.append("{"+c.getSystem()+" "+c.getCode()+"}");
        }
      }

      x.span(null, "Codes: "+b.toString()).addText(s);
    }
  }

  private String displayIdentifier(Identifier ii) {
    String s = Utilities.noString(ii.getValue()) ? "?ngen-9?" : ii.getValue();

    if (ii.hasType()) {
      if (ii.getType().hasText())
        s = ii.getType().getText()+" = "+s;
      else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasDisplay())
        s = ii.getType().getCoding().get(0).getDisplay()+" = "+s;
      else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasCode())
        s = lookupCode(ii.getType().getCoding().get(0).getSystem(), ii.getType().getCoding().get(0).getCode())+" = "+s;
    }

    if (ii.hasUse())
      s = s + " ("+ii.getUse().toString()+")";
    return s;
  }
  
  protected void renderIdentifier(XhtmlNode x, Identifier ii) {
    x.addText(displayIdentifier(ii));
  }

  public static String displayHumanName(HumanName name) {
    StringBuilder s = new StringBuilder();
    if (name.hasText())
      s.append(name.getText());
    else {
      for (StringType p : name.getGiven()) {
        s.append(p.getValue());
        s.append(" ");
      }
      if (name.hasFamily()) {
        s.append(name.getFamily());
        s.append(" ");
      }
    }
    if (name.hasUse() && name.getUse() != NameUse.USUAL)
      s.append("("+name.getUse().toString()+")");
    return s.toString();
  }


  protected void renderHumanName(XhtmlNode x, HumanName name) {
    x.addText(displayHumanName(name));
  }

  private String displayAddress(Address address) {
    StringBuilder s = new StringBuilder();
    if (address.hasText())
      s.append(address.getText());
    else {
      for (StringType p : address.getLine()) {
        s.append(p.getValue());
        s.append(" ");
      }
      if (address.hasCity()) {
        s.append(address.getCity());
        s.append(" ");
      }
      if (address.hasState()) {
        s.append(address.getState());
        s.append(" ");
      }

      if (address.hasPostalCode()) {
        s.append(address.getPostalCode());
        s.append(" ");
      }

      if (address.hasCountry()) {
        s.append(address.getCountry());
        s.append(" ");
      }
    }
    if (address.hasUse())
      s.append("("+address.getUse().toString()+")");
    return s.toString();
  }
  
  protected void renderAddress(XhtmlNode x, Address address) {
    x.addText(displayAddress(address));
  }


  public static String displayContactPoint(ContactPoint contact) {
    StringBuilder s = new StringBuilder();
    s.append(describeSystem(contact.getSystem()));
    if (Utilities.noString(contact.getValue()))
      s.append("-unknown-");
    else
      s.append(contact.getValue());
    if (contact.hasUse())
      s.append("("+contact.getUse().toString()+")");
    return s.toString();
  }

  protected void renderContactPoint(XhtmlNode x, ContactPoint contact) {
    x.addText(displayContactPoint(contact));
  }


  protected void addTelecom(XhtmlNode p, ContactPoint c) {
    if (c.getSystem() == ContactPointSystem.PHONE) {
      p.tx("Phone: "+c.getValue());
    } else if (c.getSystem() == ContactPointSystem.FAX) {
      p.tx("Fax: "+c.getValue());
    } else if (c.getSystem() == ContactPointSystem.EMAIL) {
      p.ah( "mailto:"+c.getValue()).addText(c.getValue());
    } else if (c.getSystem() == ContactPointSystem.URL) {
      if (c.getValue().length() > 30)
        p.ah(c.getValue()).addText(c.getValue().substring(0, 30)+"...");
      else
        p.ah(c.getValue()).addText(c.getValue());
    }
  }
  private static String describeSystem(ContactPointSystem system) {
    if (system == null)
      return "";
    switch (system) {
    case PHONE: return "ph: ";
    case FAX: return "fax: ";
    default:
      return "";
    }
  }


  protected String displayQuantity(Quantity q) {
    StringBuilder s = new StringBuilder();

    s.append("(system = '").append(TerminologyRenderer.describeSystem(q.getSystem()))
    .append("' code ").append(q.getCode())
    .append(" = '").append(lookupCode(q.getSystem(), q.getCode())).append("')");

    return s.toString();
  }  
  
  protected void renderQuantity(XhtmlNode x, Quantity q) {
    renderQuantity(x, q, false);
  }
  
  protected void renderQuantity(XhtmlNode x, Quantity q, boolean showCodeDetails) {
    if (q.hasComparator())
      x.addText(q.getComparator().toCode());
    x.addText(q.getValue().toString());
    if (q.hasUnit())
      x.tx(" "+q.getUnit());
    else if (q.hasCode())
      x.tx(" "+q.getCode());
    if (showCodeDetails && q.hasCode()) {
      x.span("background: LightGoldenRodYellow", null).tx(" (Details: "+TerminologyRenderer.describeSystem(q.getSystem())+" code "+q.getCode()+" = '"+lookupCode(q.getSystem(), q.getCode())+"')");
    }
  }

  public String displayRange(Range q) {
    StringBuilder b = new StringBuilder();
    if (q.hasLow())
      b.append(q.getLow().getValue().toString());
    else
      b.append("?");
    b.append("-");
    if (q.hasHigh())
      b.append(q.getHigh().getValue().toString());
    else
      b.append("?");
    if (q.getLow().hasUnit())
      b.append(" "+q.getLow().getUnit());
    return b.toString();
  }

  protected void renderRange(XhtmlNode x, Range q) {
    if (q.hasLow())
      x.addText(q.getLow().getValue().toString());
    else
      x.tx("?");
    x.tx("-");
    if (q.hasHigh())
      x.addText(q.getHigh().getValue().toString());
    else
      x.tx("?");
    if (q.getLow().hasUnit())
      x.tx(" "+q.getLow().getUnit());
  }

  public static String displayPeriod(Period p) {
    String s = !p.hasStart() ? "?ngen-5?" : p.getStartElement().toHumanDisplay();
    s = s + " --> ";
    return s + (!p.hasEnd() ? "(ongoing)" : p.getEndElement().toHumanDisplay());
  }

  public void renderPeriod(XhtmlNode x, Period p) {
    x.addText(!p.hasStart() ? "??" : p.getStartElement().toHumanDisplay());
    x.tx(" --> ");
    x.addText(!p.hasEnd() ? "(ongoing)" : p.getEndElement().toHumanDisplay());
  }
  
  private String displayTiming(Timing s) throws FHIRException {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (s.hasCode())
      b.append("Code: "+displayCodeableConcept(s.getCode()));

    if (s.getEvent().size() > 0) {
      CommaSeparatedStringBuilder c = new CommaSeparatedStringBuilder();
      for (DateTimeType p : s.getEvent()) {
        c.append(p.toHumanDisplay());
      }
      b.append("Events: "+ c.toString());
    }

    if (s.hasRepeat()) {
      TimingRepeatComponent rep = s.getRepeat();
      if (rep.hasBoundsPeriod() && rep.getBoundsPeriod().hasStart())
        b.append("Starting "+rep.getBoundsPeriod().getStartElement().toHumanDisplay());
      if (rep.hasCount())
        b.append("Count "+Integer.toString(rep.getCount())+" times");
      if (rep.hasDuration())
        b.append("Duration "+rep.getDuration().toPlainString()+displayTimeUnits(rep.getPeriodUnit()));

      if (rep.hasWhen()) {
        String st = "";
        if (rep.hasOffset()) {
          st = Integer.toString(rep.getOffset())+"min ";
        }
        b.append("Do "+st);
        for (Enumeration<EventTiming> wh : rep.getWhen())
          b.append(displayEventCode(wh.getValue()));
      } else {
        String st = "";
        if (!rep.hasFrequency() || (!rep.hasFrequencyMax() && rep.getFrequency() == 1) )
          st = "Once";
        else {
          st = Integer.toString(rep.getFrequency());
          if (rep.hasFrequencyMax())
            st = st + "-"+Integer.toString(rep.getFrequency());
        }
        if (rep.hasPeriod()) {
          st = st + " per "+rep.getPeriod().toPlainString();
          if (rep.hasPeriodMax())
            st = st + "-"+rep.getPeriodMax().toPlainString();
          st = st + " "+displayTimeUnits(rep.getPeriodUnit());
        }
        b.append("Do "+st);
      }
      if (rep.hasBoundsPeriod() && rep.getBoundsPeriod().hasEnd())
        b.append("Until "+rep.getBoundsPeriod().getEndElement().toHumanDisplay());
    }
    return b.toString();
  }

  private String displayEventCode(EventTiming when) {
    switch (when) {
    case C: return "at meals";
    case CD: return "at lunch";
    case CM: return "at breakfast";
    case CV: return "at dinner";
    case AC: return "before meals";
    case ACD: return "before lunch";
    case ACM: return "before breakfast";
    case ACV: return "before dinner";
    case HS: return "before sleeping";
    case PC: return "after meals";
    case PCD: return "after lunch";
    case PCM: return "after breakfast";
    case PCV: return "after dinner";
    case WAKE: return "after waking";
    default: return "?ngen-6?";
    }
  }

  private String displayTimeUnits(UnitsOfTime units) {
    if (units == null)
      return "?ngen-7?";
    switch (units) {
    case A: return "years";
    case D: return "days";
    case H: return "hours";
    case MIN: return "minutes";
    case MO: return "months";
    case S: return "seconds";
    case WK: return "weeks";
    default: return "?ngen-8?";
    }
  }
  
  protected void renderTiming(XhtmlNode x, Timing s) throws FHIRException {
    x.addText(displayTiming(s));
  }


  private String displaySampledData(SampledData s) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (s.hasOrigin())
      b.append("Origin: "+displayQuantity(s.getOrigin()));

    if (s.hasPeriod())
      b.append("Period: "+s.getPeriod().toString());

    if (s.hasFactor())
      b.append("Factor: "+s.getFactor().toString());

    if (s.hasLowerLimit())
      b.append("Lower: "+s.getLowerLimit().toString());

    if (s.hasUpperLimit())
      b.append("Upper: "+s.getUpperLimit().toString());

    if (s.hasDimensions())
      b.append("Dimensions: "+s.getDimensions());

    if (s.hasData())
      b.append("Data: "+s.getData());

    return b.toString();
  }

  protected void renderSampledData(XhtmlNode x, SampledData sampledData) {
    x.addText(displaySampledData(sampledData));
  }

  public RenderingContext getContext() {
    return context;
  }
  



}