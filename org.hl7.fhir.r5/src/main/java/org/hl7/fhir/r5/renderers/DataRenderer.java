package org.hl7.fhir.r5.renderers;

import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.SignStyle;
import java.util.Currency;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Address;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.BackboneType;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Base64BinaryType;
import org.hl7.fhir.r5.model.BaseDateTimeType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.DataRequirement;
import org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent;
import org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent;
import org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent;
import org.hl7.fhir.r5.model.DataRequirement.SortDirection;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Expression;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ExtensionHelper;
import org.hl7.fhir.r5.model.HumanName;
import org.hl7.fhir.r5.model.HumanName.NameUse;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.Money;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.Period;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Range;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SampledData;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.Timing;
import org.hl7.fhir.r5.model.Timing.EventTiming;
import org.hl7.fhir.r5.model.Timing.TimingRepeatComponent;
import org.hl7.fhir.r5.model.Timing.UnitsOfTime;
import org.hl7.fhir.r5.model.TriggerDefinition;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.CodeResolver.CodeResolution;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;

public class DataRenderer extends Renderer implements CodeResolver {
  
  // -- 1. context --------------------------------------------------------------
    
  public DataRenderer(RenderingContext context) {
    super(context);
  }

  public DataRenderer(IWorkerContext worker) {
    super(worker);
  }

  // -- 2. Markdown support -------------------------------------------------------
   
  public static String processRelativeUrls(String markdown, String path) {
    if (markdown == null) {
      return "";
    }
    if (!Utilities.isAbsoluteUrl(path)) {
      return markdown;
    }
    String basePath = path.contains("/") ? path.substring(0, path.lastIndexOf("/")+1) : path+"/";
    StringBuilder b = new StringBuilder();
    int i = 0;
    while (i < markdown.length()) {
      if (i < markdown.length()-3 && markdown.substring(i, i+2).equals("](")) {
        int j = i + 2;
        while (j < markdown.length() && markdown.charAt(j) != ')')
          j++;
        if (j < markdown.length()) {
          String url = markdown.substring(i+2, j);
          if (!Utilities.isAbsoluteUrl(url) && !url.startsWith("..")) {
            // it's relative - so it's relative to the base URL
              b.append("](");
              b.append(basePath);
          } else {
            b.append("](");
          }
          i = i + 1;
        } else 
          b.append(markdown.charAt(i));
      } else {
        b.append(markdown.charAt(i));
      }
      i++;
    }
    return b.toString();
  }

  protected void addMarkdown(XhtmlNode x, String text, String path) throws FHIRFormatError, IOException, DefinitionException {
    addMarkdown(x, processRelativeUrls(text, path));
  }
  
  protected void addMarkdown(XhtmlNode x, String text) throws FHIRFormatError, IOException, DefinitionException {
    if (text != null) {
      // 1. custom FHIR extensions
      while (text.contains("[[[")) {
        String left = text.substring(0, text.indexOf("[[["));
        String link = text.substring(text.indexOf("[[[")+3, text.indexOf("]]]"));
        String right = text.substring(text.indexOf("]]]")+3);
        String path = null;
        String url = link;
        String[] parts = link.split("\\#");
        if (parts[0].contains(".")) {
          path = parts[0];
          parts[0] = parts[0].substring(0, parts[0].indexOf("."));
        }
        StructureDefinition p = getContext().getWorker().fetchResource(StructureDefinition.class, parts[0]);
        if (p == null) {
          p = getContext().getWorker().fetchTypeDefinition(parts[0]);
        }
        if (context.getTypeMap().containsKey(parts[0])) {
          p = getContext().getWorker().fetchTypeDefinition(context.getTypeMap().get(parts[0]));          
        }
        if (p == null) {
          p = getContext().getWorker().fetchResource(StructureDefinition.class, link);
        }
        if (p != null) {
          if ("Extension".equals(p.getType())) {
            path = null;
          } else if (p.hasSnapshot()) {
            path = p.getSnapshot().getElementFirstRep().getPath();
          } else if (Utilities.isAbsoluteUrl(path)) {
            path = null;
          }
          url = p.getWebPath();
          if (url == null) {
            url = p.getUserString("filename");
          }
        } else {
          throw new DefinitionException(context.formatPhrase(RenderingContext.DATA_REND_MKDWN_LNK, link) + " ");
        }
        
        text = left+"["+link+"]("+url+(path == null ? "" : "#"+path)+")"+right;
      }
  
      // 2. markdown
      String s = getContext().getMarkdown().process(text, "narrative generator");
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

  private static String snMonth(String m) {
    switch (m) {
    case "1" : return "Jan";
    case "2" : return "Feb";
    case "3" : return "Mar";
    case "4" : return "Apr";
    case "5" : return "May";
    case "6" : return "Jun";
    case "7" : return "Jul";
    case "8" : return "Aug";
    case "9" : return "Sep";
    case "10" : return "Oct";
    case "11" : return "Nov";
    case "12" : return "Dec";
    default: return null;
    }
  }
  
  public static String describeVersion(String version) {
    if (version.startsWith("http://snomed.info/sct")) {
      String[] p = version.split("\\/");
      String ed = null;
      String dt = "";

      if (p[p.length-2].equals("version")) {
        ed = p[p.length-3];
        String y = p[p.length-3].substring(4, 8);
        String m = p[p.length-3].substring(2, 4); 
        dt = " rel. "+snMonth(m)+" "+y;
      } else {
        ed = p[p.length-1];
      }
      switch (ed) {
      case "900000000000207008": return "Intl"+dt; 
      case "731000124108": return "US"+dt; 
      case "32506021000036107": return "AU"+dt; 
      case "449081005": return "ES"+dt; 
      case "554471000005108": return "DK"+dt; 
      case "11000146104": return "NL"+dt; 
      case "45991000052106": return "SE"+dt; 
      case "999000041000000102": return "UK"+dt; 
      case "20611000087101": return "CA"+dt; 
      case "11000172109": return "BE"+dt; 
      default: return "??"+dt; 
      }      
    } else {
      return version;
    }
  }
  
  public String displaySystem(String system) {
    if (system == null)
    	return (context.formatPhrase(RenderingContext.DATA_REND_NOT_STAT));
    if (system.equals("http://loinc.org"))
    	return (context.formatPhrase(RenderingContext.DATA_REND_LOINC));
    if (system.startsWith("http://snomed.info"))
    	 return (context.formatPhrase(RenderingContext.DATA_REND_SNOMED));
    if (system.equals("http://www.nlm.nih.gov/research/umls/rxnorm"))
    	return (context.formatPhrase(RenderingContext.DATA_REND_RXNORM));
    if (system.equals("http://hl7.org/fhir/sid/icd-9"))
    	return (context.formatPhrase(RenderingContext.DATA_REND_ICD));
    if (system.equals("http://dicom.nema.org/resources/ontology/DCM"))
    	return (context.formatPhrase(RenderingContext.DATA_REND_DICOM));
    if (system.equals("http://unitsofmeasure.org"))
    	return (context.formatPhrase(RenderingContext.DATA_REND_UCUM));

    CodeSystem cs = context.getContext().fetchCodeSystem(system);
    if (cs != null) {
      return crPresent(cs);
    }
    return tails(system);
  }

  private String crPresent(CanonicalResource cr) {
    if (cr.hasUserData("presentation")) {
      return cr.getUserString("presentation");
    }
    if (cr.hasTitle())
      return context.getTranslated(cr.getTitleElement());
    if (cr.hasName())
      return context.getTranslated(cr.getNameElement());
    return cr.toString();
  }

  private String tails(String system) {
    if (system.contains("/")) {
      return system.substring(system.lastIndexOf("/")+1);
    } else {
      return (context.formatPhrase(RenderingContext.DATA_REND_UNKNWN));
    }
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

  private String lookupCode(String system, String version, String code) {
    if (JurisdictionUtilities.isJurisdiction(system)) {
      return JurisdictionUtilities.displayJurisdiction(system+"#"+code);
    }
    ValidationResult t = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions().withLanguage(context.getLocale().toString().replace("_", "-")).withVersionFlexible(true), system, version, code, null);

    if (t != null && t.getDisplay() != null)
      return t.getDisplay();
    else
      return code;
  }

  protected String describeLang(String lang) {
    // special cases:
    if ("fr-CA".equals(lang)) {
      return "French (Canadian)"; // this one was omitted from the value set
    }
    ValueSet v = getContext().getWorker().findTxResource(ValueSet.class, "http://hl7.org/fhir/ValueSet/languages");
    if (v != null) {
      ConceptReferenceComponent l = null;
      for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) {
        if (cc.getCode().equals(lang))
          l = cc;
      }
      if (l == null) {
        if (lang.contains("-")) {
          lang = lang.substring(0, lang.indexOf("-"));
        }
        for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) {
          if (cc.getCode().equals(lang)) {
            l = cc;
            break;
          }
        }
        if (l == null) {
          for (ConceptReferenceComponent cc : v.getCompose().getIncludeFirstRep().getConcept()) {
            if (cc.getCode().startsWith(lang+"-")) {
              l = cc;
              break;
            }
          }
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
    String t = path.substring(0, path.length()-4);
    StructureDefinition sd = getContext().getWorker().fetchTypeDefinition(t);
    if (sd == null)
      return false;
    if (VersionUtilities.getCanonicalResourceNames(getContext().getWorker().getVersion()).contains(t)) {
      return true;
    }
    if (Utilities.existsInList(t, 
        "ActivityDefinition", "CapabilityStatement", "ChargeItemDefinition", "Citation", "CodeSystem",
        "CompartmentDefinition", "ConceptMap", "ConditionDefinition", "EventDefinition", "Evidence", "EvidenceReport", "EvidenceVariable",
        "ExampleScenario", "GraphDefinition", "ImplementationGuide", "Library", "Measure", "MessageDefinition", "NamingSystem", "PlanDefinition"
        ))
      return true;
    return false;
  }

  // -- 4. Language support ------------------------------------------------------
  
  public String gt(@SuppressWarnings("rawtypes") PrimitiveType value) {
    return context.getTranslated(value);
  }
  
  // -- 6. General purpose extension rendering ---------------------------------------------- 

  public boolean hasRenderableExtensions(DataType element) {
    for (Extension ext : element.getExtension()) {
      if (canRender(ext)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasRenderableExtensions(BackboneType element) {
    for (Extension ext : element.getExtension()) {
      if (canRender(ext)) {
        return true;
      }
    }
    return element.hasModifierExtension();  
  }
  
  private String getExtensionLabel(Extension ext) {
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, ext.getUrl());
    if (sd != null && ext.hasValue() && ext.getValue().isPrimitive() && sd.hasSnapshot()) {
      for (ElementDefinition ed : sd.getSnapshot().getElement()) {
        if (Utilities.existsInList(ed.getPath(), "Extension", "Extension.value[x]") && ed.hasLabel()) {
          return context.getTranslated(ed.getLabelElement());
        }
      }
    }
    return null;    
  }
  
  private boolean canRender(Extension ext) {
    return getExtensionLabel(ext) != null;
  }

  public void renderExtensionsInList(XhtmlNode ul, DataType element) throws FHIRFormatError, DefinitionException, IOException {
    for (Extension ext : element.getExtension()) {
      if (canRender(ext)) {
        String lbl = getExtensionLabel(ext);
        XhtmlNode li = ul.li();
        li.tx(lbl);
        li.tx(": ");
        render(li, ext.getValue());
      }
    }
  }
  
  public void renderExtensionsInList(XhtmlNode ul, BackboneType element) throws FHIRFormatError, DefinitionException, IOException {
    for (Extension ext : element.getModifierExtension()) {
      if (canRender(ext)) {
        String lbl = getExtensionLabel(ext);
        XhtmlNode li = ul.li();
        li = li.b();
        li.tx(lbl);
        li.tx(": ");        
        render(li, ext.getValue());
      } else {
        // somehow have to do better than this 
        XhtmlNode li = ul.li();
        li.b().tx(context.formatPhrase(RenderingContext.DATA_REND_UNRD_EX));
      }
    }
    for (Extension ext : element.getExtension()) {
      if (canRender(ext)) {
        String lbl = getExtensionLabel(ext);
        XhtmlNode li = ul.li();
        li.tx(lbl);
        li.tx(": ");
        render(li, ext.getValue());
      }
    }
  }
  
  public void renderExtensionsInText(XhtmlNode div, DataType element, String sep) throws FHIRFormatError, DefinitionException, IOException {
    boolean first = true;
    for (Extension ext : element.getExtension()) {
      if (canRender(ext)) {
        if (first) {
          first = false;
        } else {
          div.tx(sep);
          div.tx(" ");
        }
         
        String lbl = getExtensionLabel(ext);
        div.tx(lbl);
        div.tx(": ");
        render(div, ext.getValue());
      }
    }
  }
  
  public void renderExtensionsInList(XhtmlNode div, BackboneType element, String sep) throws FHIRFormatError, DefinitionException, IOException {
    boolean first = true;
    for (Extension ext : element.getModifierExtension()) {
      if (first) {
        first = false;
      } else {
        div.tx(sep);
        div.tx(" ");
      }
      if (canRender(ext)) {
        String lbl = getExtensionLabel(ext);
        XhtmlNode b = div.b();
        b.tx(lbl);
        b.tx(": ");
        render(div, ext.getValue());
      } else {
        // somehow have to do better than this 
        div.b().tx(context.formatPhrase(RenderingContext.DATA_REND_UNRD_EX));
      }
    }
    for (Extension ext : element.getExtension()) {
      if (canRender(ext)) {
        if (first) {
          first = false;
        } else {
          div.tx(sep);
          div.tx(" ");
        }
         
        String lbl = getExtensionLabel(ext);
        div.tx(lbl);
        div.tx(": ");
        render(div, ext.getValue());
      }
    }

  }
  
  // -- 6. Data type Rendering ---------------------------------------------- 

  public static String display(IWorkerContext context, DataType type) {
    return new DataRenderer(new RenderingContext(context, null, null, "http://hl7.org/fhir/R4", "", null, ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE)).display(type);
  }
  
  public String displayBase(Base b) {
    if (b instanceof DataType) {
      return display((DataType) b);
    } else {
      return (context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, b.fhirType()) + " ");      
    }
  }
  
  public String display(DataType type) {
    if (type == null || type.isEmpty()) {
      return "";
    }
    
    if (type instanceof Coding) {
      return displayCoding((Coding) type);
    } else if (type instanceof CodeableConcept) {
      return displayCodeableConcept((CodeableConcept) type);
    } else if (type instanceof Identifier) {
      return displayIdentifier((Identifier) type);
    } else if (type instanceof HumanName) {
      return displayHumanName((HumanName) type);
    } else if (type instanceof Address) {
      return displayAddress((Address) type);
    } else if (type instanceof ContactPoint) {
      return displayContactPoint((ContactPoint) type);
    } else if (type instanceof Quantity) {
      return displayQuantity((Quantity) type);
    } else if (type instanceof Range) {
      return displayRange((Range) type);
    } else if (type instanceof Period) {
      return displayPeriod((Period) type);
    } else if (type instanceof Timing) {
      return displayTiming((Timing) type);
    } else if (type instanceof SampledData) {
      return displaySampledData((SampledData) type);
    } else if (type instanceof ContactDetail) {
      return displayContactDetail((ContactDetail) type);
    } else if (type.isDateTime()) {
      return displayDateTime((BaseDateTimeType) type);
    } else if (type.isPrimitive()) {
      return context.getTranslated((PrimitiveType<?>) type);
    } else {
      return (context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, type.fhirType()) + " ");
    }
  }

  protected String displayDateTime(BaseDateTimeType type) {
    if (!type.hasPrimitiveValue()) {
      return "";
    }
    
    // relevant inputs in rendering context:
    // timeZone, dateTimeFormat, locale, mode
    //   timezone - application specified timezone to use. 
    //        null = default to the time of the date/time itself
    //   dateTimeFormat - application specified format for date times
    //        null = default to ... depends on mode
    //   mode - if rendering mode is technical, format defaults to XML format
    //   locale - otherwise, format defaults to SHORT for the Locale (which defaults to default Locale)  
    if (isOnlyDate(type.getPrecision())) {
      
      DateTimeFormatter fmt = getDateFormatForPrecision(type);      
      LocalDate date = LocalDate.of(type.getYear(), type.getMonth()+1, type.getDay());
      return fmt.format(date);
    }

    DateTimeFormatter fmt = context.getDateTimeFormat();
    if (fmt == null) {
      if (context.isTechnicalMode()) {
        fmt = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
      } else {
        fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(context.getLocale());
      }
    }
    ZonedDateTime zdt = ZonedDateTime.parse(type.primitiveValue());
    ZoneId zone = context.getTimeZoneId();
    if (zone != null) {
      zdt = zdt.withZoneSameInstant(zone);
    }
    return fmt.format(zdt);
  }

  private DateTimeFormatter getDateFormatForPrecision(BaseDateTimeType type) {
    DateTimeFormatter fmt = getContextDateFormat(type);
    if (fmt != null) {
      return fmt;
    }
    if (context.isTechnicalMode()) {
      switch (type.getPrecision()) {
      case YEAR:
        return new DateTimeFormatterBuilder().appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
      case MONTH:
        return  new DateTimeFormatterBuilder().appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral('-').appendValue(MONTH_OF_YEAR, 2).toFormatter();
      default:
        return DateTimeFormatter.ISO_DATE;
      }
    } else {
      switch (type.getPrecision()) {
      case YEAR:
        return DateTimeFormatter.ofPattern("uuuu");
      case MONTH:
        return DateTimeFormatter.ofPattern("MMM uuuu");
      default:
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(context.getLocale());
      }
    }
  }

  private DateTimeFormatter getContextDateFormat(BaseDateTimeType type) {
    switch (type.getPrecision()) {
    case YEAR:
      return context.getDateYearFormat();
    case MONTH:
      return context.getDateYearMonthFormat();
    default:
      return context.getDateFormat();
    }
  }   
  
  private boolean isOnlyDate(TemporalPrecisionEnum temporalPrecisionEnum) {
    return temporalPrecisionEnum == TemporalPrecisionEnum.YEAR || temporalPrecisionEnum == TemporalPrecisionEnum.MONTH || temporalPrecisionEnum == TemporalPrecisionEnum.DAY;
  }

  public String display(BaseWrapper type) {
    return (context.formatPhrase(RenderingContext.DATA_REND_TO_DO));   
  }

  public void render(XhtmlNode x, BaseWrapper type) throws FHIRFormatError, DefinitionException, IOException  {
    Base base = null;
    try {
      base = type.getBase();
    } catch (FHIRException | IOException e) {
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_ERROR, e.getMessage()) + " "); // this shouldn't happen - it's an error in the library itself
      return;
    }
    if (base instanceof DataType) {
      render(x, (DataType) base);
    } else {
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_TO_DO, base.fhirType()));
    }
  }
  
  public void renderBase(XhtmlNode x, Base b) throws FHIRFormatError, DefinitionException, IOException {
    if (b instanceof DataType) {
      render(x, (DataType) b);
    } else {
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, b.fhirType()) + " ");      
    }
  }
  
  public void render(XhtmlNode x, DataType type) throws FHIRFormatError, DefinitionException, IOException {
    if (type instanceof BaseDateTimeType) {
      x.tx(displayDateTime((BaseDateTimeType) type));
    } else if (type instanceof UriType) {
      renderUri(x, (UriType) type);
    } else if (type instanceof Annotation) {
      renderAnnotation(x, (Annotation) type);
    } else if (type instanceof Coding) {
      renderCodingWithDetails(x, (Coding) type);
    } else if (type instanceof CodeableConcept) {
      renderCodeableConcept(x, (CodeableConcept) type);
    } else if (type instanceof Identifier) {
      renderIdentifier(x, (Identifier) type);
    } else if (type instanceof HumanName) {
      renderHumanName(x, (HumanName) type);
    } else if (type instanceof Address) {
      renderAddress(x, (Address) type);
    } else if (type instanceof Expression) {
      renderExpression(x, (Expression) type);
    } else if (type instanceof Money) {
      renderMoney(x, (Money) type);
    } else if (type instanceof ContactPoint) {
      renderContactPoint(x, (ContactPoint) type);
    } else if (type instanceof Quantity) {
      renderQuantity(x, (Quantity) type);
    } else if (type instanceof Range) {
      renderRange(x, (Range) type);
    } else if (type instanceof Period) {
      renderPeriod(x, (Period) type);
    } else if (type instanceof Timing) {
      renderTiming(x, (Timing) type);
    } else if (type instanceof SampledData) {
      renderSampledData(x, (SampledData) type);
    } else if (type instanceof Reference) {
      renderReference(x, (Reference) type);
    } else if (type instanceof UsageContext) {
      renderUsageContext(x, (UsageContext) type);
    } else if (type instanceof CodeableReference) {
      CodeableReference cr = (CodeableReference) type;
      if (cr.hasConcept()) {
        renderCodeableConcept(x, cr.getConcept());
      } else { 
        renderReference(x, cr.getReference());
      }
    } else if (type instanceof MarkdownType) {
      addMarkdown(x, context.getTranslated((MarkdownType) type));
    } else if (type instanceof Base64BinaryType) {
      Base64BinaryType b64 = (Base64BinaryType) type;
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_BASE64, (b64.getValue() == null ? "0" : b64.getValue().length)));
    } else if (type.isPrimitive()) {
      x.tx(context.getTranslated((PrimitiveType<?>) type));
    } else {
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, type.fhirType()) + " ");      
    }
  }

  protected void renderReference(XhtmlNode x, Reference ref) {
     if (ref.hasDisplay()) {
       x.tx(context.getTranslated(ref.getDisplayElement()));
     } else if (ref.hasReference()) {
       x.tx(ref.getReference());
     } else {
       x.tx("??");
     }
  }

  public void renderDateTime(XhtmlNode x, Base e) {
    if (e.hasPrimitiveValue()) {
      x.addText(displayDateTime((DateTimeType) e));
    }
  }

  public void renderDate(XhtmlNode x, Base e) {
    if (e.hasPrimitiveValue()) {
      x.addText(displayDateTime((DateType) e));
    }
  }

  public void renderDateTime(XhtmlNode x, String s) {
    if (s != null) {
      DateTimeType dt = new DateTimeType(s);
      x.addText(displayDateTime(dt));
    }
  }

  protected void renderUri(XhtmlNode x, UriType uri) {
    if (uri.getValue().startsWith("mailto:")) {
      x.ah(uri.getValue()).addText(uri.getValue().substring(7));
    } else {
      Resource r = context.getContext().fetchResource(Resource.class, uri.getValue());
      if (r != null && r.getWebPath() != null) {
        if (r instanceof CanonicalResource) {
          x.ah(r.getWebPath()).addText(crPresent((CanonicalResource) r));          
        } else {
          x.ah(r.getWebPath()).addText(uri.getValue());          
        }
      } else {
        String url = context.getResolver() != null ? context.getResolver().resolveUri(context, uri.getValue()) : null;
        if (url != null) {          
          x.ah(url).addText(uri.getValue());
        } else if (Utilities.isAbsoluteUrlLinkable(uri.getValue()) && !(uri instanceof IdType)) {
          x.ah(uri.getValue()).addText(uri.getValue());
        } else {
          x.addText(uri.getValue());
        }
      }
    }
  }
  
  protected void renderUri(XhtmlNode x, UriType uriD, String path, String id, Resource src) {
    String uri = uriD.getValue();
    if (isCanonical(path)) {
      x.code().tx(uri);
    } else {
      if (uri == null) {
        x.b().tx(uri);
      } else if (uri.startsWith("mailto:")) {
        x.ah(uri).addText(uri.substring(7));
      } else {
        Resource target = context.getContext().fetchResource(Resource.class, uri, src);
        if (target != null && target.hasWebPath()) {
          String title = target instanceof CanonicalResource ? crPresent((CanonicalResource) target) : uri;
          x.ah(target.getWebPath()).addText(title);
        } else {
          String url = context.getResolver() != null ? context.getResolver().resolveUri(context, uri) : null;
          if (url != null) {          
            x.ah(url).addText(uri);
          } else if (uri.contains("|")) {
            x.ah(uri.substring(0, uri.indexOf("|"))).addText(uri);
          } else if (uri.startsWith("http:") || uri.startsWith("https:") || uri.startsWith("ftp:")) {
            x.ah(uri).addText(uri);        
          } else {
            x.code().addText(uri);        
          }
        }
      }
    }
  }

  protected void renderAnnotation(XhtmlNode x, Annotation annot) {
    renderAnnotation(x, annot, false);
  }

  protected void renderAnnotation(XhtmlNode x, Annotation a, boolean showCodeDetails) throws FHIRException {
    StringBuilder b = new StringBuilder();
    if (a.hasText()) {
      b.append(context.getTranslated(a.getTextElement()));
    }

    if (a.hasText() && (a.hasAuthor() || a.hasTimeElement())) {
      b.append(" (");
    }

    if (a.hasAuthor()) {
      b.append(context.formatPhrase(RenderingContext.DATA_REND_BY) + " ");
      if (a.hasAuthorReference()) {
        b.append(a.getAuthorReference().getReference());
      } else if (a.hasAuthorStringType()) {
        b.append(context.getTranslated(a.getAuthorStringType()));
      }
    }


    if (a.hasTimeElement()) {
      if (b.length() > 0) {
        b.append(" ");
      }
      b.append("@").append(a.getTimeElement().toHumanDisplay());
    }
    if (a.hasText() && (a.hasAuthor() || a.hasTimeElement())) {
      b.append(")");
    }


    x.addText(b.toString());
  }

  public String displayCoding(Coding c) {
    String s = "";
    if (context.isTechnicalMode()) {
      s = context.getTranslated(c.getDisplayElement());
      if (Utilities.noString(s)) {
        s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());        
      }
      if (Utilities.noString(s)) {
        s = displayCodeTriple(c.getSystem(), c.getVersion(), c.getCode());
      } else if (c.hasSystem()) {
        s = s + " ("+displayCodeTriple(c.getSystem(), c.getVersion(), c.getCode())+")";
      } else if (c.hasCode()) {
        s = s + " ("+c.getCode()+")";
      }
    } else {
    if (c.hasDisplayElement())
      return context.getTranslated(c.getDisplayElement());
    if (Utilities.noString(s))
      s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());
    if (Utilities.noString(s))
      s = c.getCode();
    }
    return s;
  }

  private String displayCodeSource(String system, String version) {
    String s = displaySystem(system);
    if (version != null) {
      s = s + "["+describeVersion(version)+"]";
    }
    return s;    
  }
  
  private String displayCodeTriple(String system, String version, String code) {
    if (system == null) {
      if (code == null) {
        return "";
      } else {
        return "#"+code;
      }
    } else {
      String s = displayCodeSource(system, version);
      if (code != null) {
        s = s + "#"+code;
      }
      return s;
    }
  }

  public String displayCoding(List<Coding> list) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (Coding c : list) {
      b.append(displayCoding(c));
    }
    return b.toString();
  }

  protected void renderCoding(XhtmlNode x, Coding c) {
    renderCoding(x, c, false);
  }
  
  protected void renderCoding(HierarchicalTableGenerator gen, List<Piece> pieces, Coding c) {
    if (c.isEmpty()) {
      return;
    }

    String url = getLinkForSystem(c.getSystem(), c.getVersion());
    String name = displayCodeSource(c.getSystem(), c.getVersion());
    if (!Utilities.noString(url)) {
      pieces.add(gen.new Piece(url, name, c.getSystem()+(c.hasVersion() ? "#"+c.getVersion() : "")));
    } else { 
      pieces.add(gen.new Piece(null, name, c.getSystem()+(c.hasVersion() ? "#"+c.getVersion() : "")));
    }
    pieces.add(gen.new Piece(null, "#"+c.getCode(), null));
    String s = context.getTranslated(c.getDisplayElement());
    if (Utilities.noString(s)) {
      s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());
    }
    if (!Utilities.noString(s)) {
      pieces.add(gen.new Piece(null, " \""+s+"\"", null));
    }
  }
  
  private String getLinkForSystem(String system, String version) {
    if ("http://snomed.info/sct".equals(system)) {
      return "https://browser.ihtsdotools.org/";      
    } else if ("http://loinc.org".equals(system)) {
      return "https://loinc.org/";            
    } else if ("http://unitsofmeasure.org".equals(system)) {
      return "http://ucum.org";            
    } else {
      String url = system;
      if (version != null) {
        url = url + "|"+version;
      }
      CodeSystem cs = context.getWorker().fetchCodeSystem(url);
      if (cs != null && cs.hasWebPath()) {
        return cs.getWebPath();
      }
      return null;
    }
  }
  
  protected String getLinkForCode(String system, String version, String code) {
    if ("http://snomed.info/sct".equals(system)) {
      if (!Utilities.noString(code)) {
        return "http://snomed.info/id/"+code;        
      } else {
        return "https://browser.ihtsdotools.org/";
      }
    } else if ("http://loinc.org".equals(system)) {
      if (!Utilities.noString(code)) {
        return "https://loinc.org/"+code;
      } else {
        return "https://loinc.org/";
      }
    } else if ("http://www.nlm.nih.gov/research/umls/rxnorm".equals(system)) {
      if (!Utilities.noString(code)) {
        return "https://mor.nlm.nih.gov/RxNav/search?searchBy=RXCUI&searchTerm="+code;        
      } else {
        return "https://www.nlm.nih.gov/research/umls/rxnorm/index.html";
      }
    } else if ("urn:iso:std:iso:3166".equals(system)) {
      if (!Utilities.noString(code)) {
        return "https://en.wikipedia.org/wiki/ISO_3166-2:"+code;        
      } else {
        return "https://en.wikipedia.org/wiki/ISO_3166-2";
      }
    } else {
      CodeSystem cs = context.getWorker().fetchCodeSystem(system, version);
      if (cs != null && cs.hasWebPath()) {
        if (!Utilities.noString(code)) {
          return cs.getWebPath()+"#"+cs.getId()+"-"+Utilities.nmtokenize(code);
        } else {
          return cs.getWebPath();
        }
      }
    }  
    return null;
  }
  
  public CodeResolution resolveCode(String system, String code) {
    return resolveCode(new Coding().setSystem(system).setCode(code));
  }

  public CodeResolution resolveCode(Coding c) {
    String systemName;
    String systemLink;
    String link;
    String display = null;
    String hint;
    
    if (c.hasDisplayElement())
      display = context.getTranslated(c.getDisplayElement());
    if (Utilities.noString(display))
      display = lookupCode(c.getSystem(), c.getVersion(), c.getCode());
    if (Utilities.noString(display)) {
      display = c.getCode();
    }
    
    CodeSystem cs = context.getWorker().fetchCodeSystem(c.getSystem());
    systemLink = cs != null ? cs.getWebPath() : null;
    systemName = cs != null ? crPresent(cs) : displaySystem(c.getSystem());
    link = getLinkForCode(c.getSystem(), c.getVersion(), c.getCode());

    hint = systemName+": "+display+(c.hasVersion() ? " "+ context.formatPhrase(RenderingContext.DATA_REND_VERSION, c.getVersion(), ")") : "");
    return new CodeResolution(systemName, systemLink, link, display, hint);
  }
  
  public CodeResolution resolveCode(CodeableConcept code) {
    if (code.hasCoding()) {
      return resolveCode(code.getCodingFirstRep());
    } else {
      return new CodeResolution(null, null, null, code.getText(), code.getText());
    }
  }
  protected void renderCodingWithDetails(XhtmlNode x, Coding c) {
    String s = "";
    if (c.hasDisplayElement())
      s = context.getTranslated(c.getDisplayElement());
    if (Utilities.noString(s))
      s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());

    CodeSystem cs = context.getWorker().fetchCodeSystem(c.getSystem());

    String sn = cs != null ? crPresent(cs) : displaySystem(c.getSystem());
    String link = getLinkForCode(c.getSystem(), c.getVersion(), c.getCode());
    if (link != null) {
      x.ah(link).tx(sn);
    } else {
      x.tx(sn);
    }
    
    x.tx(" ");
    x.tx(c.getCode());
    if (!Utilities.noString(s)) {
      x.tx(": ");
      x.tx(s);
    }
    if (c.hasVersion()) {
      x.tx(" "+context.formatPhrase(RenderingContext.DATA_REND_VERSION, c.getVersion(), ")"));
    }
  }
  
  protected void renderCoding(XhtmlNode x, Coding c, boolean showCodeDetails) {
    String s = "";
    if (c.hasDisplayElement())
      s = context.getTranslated(c.getDisplayElement());
    if (Utilities.noString(s))
      s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());

    if (Utilities.noString(s))
      s = c.getCode();

    if (showCodeDetails) {
      x.addText(s+" "+context.formatPhrase(RenderingContext.DATA_REND_DETAILS_STATED, displaySystem(c.getSystem()), c.getCode(), " = '", lookupCode(c.getSystem(), c.getVersion(), c.getCode()), c.getDisplay(), "')"));
    } else
      x.span(null, "{"+c.getSystem()+" "+c.getCode()+"}").addText(s);
  }

  public String displayCodeableConcept(CodeableConcept cc) {
    String s = context.getTranslated(cc.getTextElement());
    if (Utilities.noString(s)) {
      for (Coding c : cc.getCoding()) {
        if (c.hasDisplayElement()) {
          s = context.getTranslated(c.getDisplayElement());
          break;
        }
      }
    }
    if (Utilities.noString(s)) {
      // still? ok, let's try looking it up
      for (Coding c : cc.getCoding()) {
        if (c.hasCode() && c.hasSystem()) {
          s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());
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

  protected void renderCodeableConcept(XhtmlNode x, CodeableConcept cc) throws FHIRFormatError, DefinitionException, IOException {
    renderCodeableConcept(x, cc, false);
  }
  
  protected void renderCodeableReference(XhtmlNode x, CodeableReference e, boolean showCodeDetails) throws FHIRFormatError, DefinitionException, IOException {
    if (e.hasConcept()) {
      renderCodeableConcept(x, e.getConcept(), showCodeDetails);
    }
    if (e.hasReference()) {
      renderReference(x, e.getReference());
    }
  }

  protected void renderCodeableConcept(XhtmlNode x, CodeableConcept cc, boolean showCodeDetails) throws FHIRFormatError, DefinitionException, IOException {
    if (cc.isEmpty()) {
      return;
    }

    String s = context.getTranslated(cc.getTextElement());
    if (Utilities.noString(s)) {
      for (Coding c : cc.getCoding()) {
        if (c.hasDisplayElement()) {
          s = context.getTranslated(c.getDisplayElement());
          break;
        }
      }
    }
    if (Utilities.noString(s)) {
      // still? ok, let's try looking it up
      for (Coding c : cc.getCoding()) {
        if (c.hasCodeElement() && c.hasSystemElement()) {
          s = lookupCode(c.getSystem(), c.getVersion(), c.getCode());
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
      XhtmlNode sp = x.span("background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki", null);
      sp.tx(" (");
      boolean first = true;
      for (Coding c : cc.getCoding()) {
        if (first) {
          first = false;
        } else {
          sp.tx("; ");
        }
        String url = getLinkForSystem(c.getSystem(), c.getVersion());
        if (url != null) {
          sp.ah(url).tx(displayCodeSource(c.getSystem(), c.getVersion()));
        } else {
          sp.tx(displayCodeSource(c.getSystem(), c.getVersion()));
        }
        if (c.hasCode()) {
          sp.tx("#"+c.getCode());
        }
        if (c.hasDisplay() && !s.equals(c.getDisplay())) {
          sp.tx(" \""+context.getTranslated(c.getDisplayElement())+"\"");
        }
      }
      if (hasRenderableExtensions(cc)) {
        if (!first) {
          sp.tx("; ");
        }
        renderExtensionsInText(sp, cc, ";");
      }
      sp.tx(")");
    } else {

      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (Coding c : cc.getCoding()) {
        if (c.hasCodeElement() && c.hasSystemElement()) {
          b.append("{"+c.getSystem()+" "+c.getCode()+"}");
        }
      }

      x.span(null, context.formatPhrase(RenderingContext.GENERAL_CODES) +b.toString()).addText(s);
    }
  }

  protected String displayIdentifier(Identifier ii) {
    String s = Utilities.noString(ii.getValue()) ? "?ngen-9?" : ii.getValue();
    if ("urn:ietf:rfc:3986".equals(ii.getSystem()) && s.startsWith("urn:oid:")) {
      s = "OID:"+s.substring(8);
    } else if ("urn:ietf:rfc:3986".equals(ii.getSystem()) && s.startsWith("urn:uuid:")) {
      s = "UUID:"+s.substring(9);
    } else { 
      NamingSystem ns = context.getContext().getNSUrlMap().get(ii.getSystem());
      if (ns != null) {
        s = crPresent(ns)+"#"+s;
      }
      if (ii.hasType()) {
        if (ii.getType().hasText())
          s = context.getTranslated(ii.getType().getTextElement())+":\u00A0"+s;
        else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasDisplay())
          s = context.getTranslated(ii.getType().getCoding().get(0).getDisplayElement())+": "+s;
        else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasCode())
          s = lookupCode(ii.getType().getCoding().get(0).getSystem(), ii.getType().getCoding().get(0).getVersion(), ii.getType().getCoding().get(0).getCode())+": "+s;
      } else if (ii.hasSystem()) {
        s = ii.getSystem()+"#"+s;
      }
    }

    if (ii.hasUse() || ii.hasPeriod()) {
      s = s + "\u00A0(";
      if (ii.hasUse()) {
        s = s + "use:\u00A0"+ii.getUse().toCode();
      }
      if (ii.hasUse() && ii.hasPeriod()) {
        s = s + ",\u00A0";
      }
      if (ii.hasPeriod()) {
        s = s + "period:\u00A0"+displayPeriod(ii.getPeriod());
      }
      s = s + ")";
    }    
    return s;
  }
  
  protected void renderIdentifier(XhtmlNode x, Identifier ii) {
    boolean pfx = true;
    if (ii.hasType()) {
      if (ii.getType().hasText()) {
        x.tx(context.getTranslated(ii.getType().getTextElement()));
      } else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasDisplay()) {
        x.tx(context.getTranslated(ii.getType().getCoding().get(0).getDisplayElement()));
      } else if (ii.getType().hasCoding() && ii.getType().getCoding().get(0).hasCode()) {
        x.tx(lookupCode(ii.getType().getCoding().get(0).getSystem(), ii.getType().getCoding().get(0).getVersion(), ii.getType().getCoding().get(0).getCode()));
      } else {
        pfx = false;
      }
    } else if (ii.hasSystem()) {
      NamingSystem ns = context.getContext().getNSUrlMap().get(ii.getSystem());
      if (ns != null) {
        if (ns.hasWebPath()) {
          x.ah(ns.getWebPath(), ns.getDescription()).tx(crPresent(ns));        
        } else {
          x.tx(crPresent(ns));
        }
      } else {
        switch (ii.getSystem()) {
        case "urn:oid:2.51.1.3":
          x.ah("https://www.gs1.org/standards/id-keys/gln", context.formatPhrase(RenderingContext.DATA_REND_GLN)).tx("GLN");
          break;
        default:
          x.code(ii.getSystem());      
        }
      }
    }
    if (!Utilities.noString(ii.getValue())) {
      if (pfx) {
        x.tx("/");
      }
      x.tx(ii.getValue());
    }

    if (ii.hasUse() || ii.hasPeriod()) {
      x.nbsp();
      x.tx("(");
      if (ii.hasUse()) {
        x.tx(context.formatPhrase(RenderingContext.DATA_REND_USE));
        x.nbsp();
        x.tx(ii.getUse().toCode());
      }
      if (ii.hasUse() && ii.hasPeriod()) {
        x.tx(",");
        x.nbsp();
      }
      if (ii.hasPeriod()) {
        x.tx(context.formatPhrase(RenderingContext.DATA_REND_PERIOD));
        x.nbsp();
        x.tx(displayPeriod(ii.getPeriod()));
      }
      x.tx(")");
    }        
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
    StringBuilder s = new StringBuilder();
    if (name.hasText())
      s.append(context.getTranslated(name.getTextElement()));
    else {
      for (StringType p : name.getGiven()) {
        s.append(context.getTranslated(p));
        s.append(" ");
      }
      if (name.hasFamily()) {
        s.append(context.getTranslated(name.getFamilyElement()));
        s.append(" ");
      }
    }
    if (name.hasUse() && name.getUse() != NameUse.USUAL)
      s.append("("+context.getTranslatedCode(name.getUseElement(), "http://hl7.org/fhir/name-use")+")");
    
    x.addText(s.toString());
  }

  private String displayAddress(Address address) {
    StringBuilder s = new StringBuilder();
    if (address.hasText())
      s.append(context.getTranslated(address.getTextElement()));
    else {
      for (StringType p : address.getLine()) {
        s.append(context.getTranslated(p));
        s.append(" ");
      }
      if (address.hasCity()) {
        s.append(context.getTranslated(address.getCityElement()));
        s.append(" ");
      }
      if (address.hasState()) {
        s.append(context.getTranslated(address.getStateElement()));
        s.append(" ");
      }

      if (address.hasPostalCode()) {
        s.append(context.getTranslated(address.getPostalCodeElement()));
        s.append(" ");
      }

      if (address.hasCountry()) {
        s.append(context.getTranslated(address.getCountryElement()));
        s.append(" ");
      }
    }
    if (address.hasUse())
      s.append("("+address.getUse().toCode()+")");
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

  public static String displayContactDetail(ContactDetail contact) {
    CommaSeparatedStringBuilder s = new CommaSeparatedStringBuilder();
    for (ContactPoint cp : contact.getTelecom()) {
      s.append(displayContactPoint(cp));
    }
    return contact.getName()+(s.length() == 0 ? "" : " ("+s.toString()+")");
  }

  protected String getLocalizedBigDecimalValue(BigDecimal input, Currency c) {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(context.getLocale());
    numberFormat.setGroupingUsed(true);
    numberFormat.setMaximumFractionDigits(c.getDefaultFractionDigits());
    numberFormat.setMinimumFractionDigits(c.getDefaultFractionDigits());
    return numberFormat.format(input);
}
  
  protected void renderMoney(XhtmlNode x, Money money) {
    if (x.getName().equals("blockquote")) {
      x = x.para();
    }
    Currency c = money.hasCurrency() ? Currency.getInstance(money.getCurrency()) : null;
    if (c != null) {
      XhtmlNode s = x.span(null, c.getDisplayName());
      s.tx(c.getSymbol(context.getLocale()));
      s.tx(getLocalizedBigDecimalValue(money.getValue(), c));
      x.tx(" ("+c.getCurrencyCode()+")");
    } else {
      if (money.getCurrency() != null) {
        x.tx(money.getCurrency());
      }
      x.tx(money.getValue().toPlainString());
    }
  }
  
  protected void renderExpression(XhtmlNode x, Expression expr) {
  // there's two parts: what the expression is, and how it's described. 
    // we start with what it is, and then how it's described 
    XhtmlNode p = x;
    if (p.getName().equals("blockquote")) {
      p = p.para();
    }
    if (expr.hasExpression()) {
      if (expr.hasReference()) {
        p = x.ah(expr.getReference());        
      }
      XhtmlNode c = p;
      if (expr.hasLanguage()) {
        c = c.span(null, expr.getLanguage());
      }
      c.code().tx(expr.getExpression());
    } else if (expr.hasReference()) {
      p.ah(expr.getReference()).tx(context.formatPhrase(RenderingContext.DATA_REND_SOURCE));
    }
    if (expr.hasName() || expr.hasDescription()) {
      p.tx("(");
      if (expr.hasName()) {
        p.b().tx(expr.getName());
      }
      if (expr.hasDescription()) {
        p.tx("\"");
        p.tx(context.getTranslated(expr.getDescriptionElement()));
        p.tx("\"");
      }
      p.tx(")");
    }
  }
  
  
  protected void renderContactPoint(XhtmlNode x, ContactPoint contact) {
    if (contact != null) {
      if (!contact.hasSystem()) {
        x.addText(displayContactPoint(contact));        
      } else {
        switch (contact.getSystem()) {
        case EMAIL:
          x.ah("mailto:"+contact.getValue()).tx(contact.getValue());
          break;
        case FAX:
          x.addText(displayContactPoint(contact));
          break;
        case NULL:
          x.addText(displayContactPoint(contact));
          break;
        case OTHER:
          x.addText(displayContactPoint(contact));
          break;
        case PAGER:
          x.addText(displayContactPoint(contact));
          break;
        case PHONE:
          if (contact.hasValue() && contact.getValue().startsWith("+")) {
            x.ah("tel:"+contact.getValue().replace(" ", "")).tx(contact.getValue());
          } else {
            x.addText(displayContactPoint(contact));
          }
          break;
        case SMS:
          x.addText(displayContactPoint(contact));
          break;
        case URL:
          x.ah(contact.getValue()).tx(contact.getValue());
          break;
        default:
          break;      
        }
      }
    }
  }

  protected void displayContactPoint(XhtmlNode p, ContactPoint c) {
    if (c != null) {
      if (c.getSystem() == ContactPointSystem.PHONE) {
        p.tx(context.formatPhrase(RenderingContext.DATA_REND_PHONE, c.getValue()) + " ");
      } else if (c.getSystem() == ContactPointSystem.FAX) {
        p.tx(context.formatPhrase(RenderingContext.DATA_REND_FAX, c.getValue()) + " ");
      } else if (c.getSystem() == ContactPointSystem.EMAIL) {
        p.tx(c.getValue());
      } else if (c.getSystem() == ContactPointSystem.URL) {
        if (c.getValue().length() > 30) {
          p.addText(c.getValue().substring(0, 30)+"...");
        } else {
          p.addText(c.getValue());
        }
      }
    }
  }

  protected void addTelecom(XhtmlNode p, ContactPoint c) {
    if (c.getSystem() == ContactPointSystem.PHONE) {
      p.tx(context.formatPhrase(RenderingContext.DATA_REND_PHONE, c.getValue()) + " ");
    } else if (c.getSystem() == ContactPointSystem.FAX) {
      p.tx(context.formatPhrase(RenderingContext.DATA_REND_FAX, c.getValue()) + " ");
    } else if (c.getSystem() == ContactPointSystem.EMAIL) {
      p.ah("mailto:"+c.getValue()).addText(c.getValue());
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

    s.append(q.hasValue() ? q.getValue() : "?");
    if (q.hasUnit())
      s.append(" ").append(q.getUnit());
    else if (q.hasCode())
      s.append(" ").append(q.getCode());

    return s.toString();
  }  
  
  protected void renderQuantity(XhtmlNode x, Quantity q) {
    renderQuantity(x, q, false);
  }
  
  protected void renderQuantity(XhtmlNode x, Quantity q, boolean showCodeDetails) {
    if (q.hasComparator())
      x.addText(q.getComparator().toCode());
    if (q.hasValue()) {
      x.addText(context.getTranslated(q.getValueElement()));
    }
    if (q.hasUnit())
      x.tx(" "+context.getTranslated(q.getUnitElement()));
    else if (q.hasCode() && q.hasSystem()) {
      // if there's a code there *shall* be a system, so if we've got one and not the other, things are invalid and we won't bother trying to render
      if (q.hasSystem() && q.getSystem().equals("http://unitsofmeasure.org"))
        x.tx(" "+q.getCode());
      else
        x.tx("(unit "+q.getCode()+" from "+q.getSystem()+")");
    }
    if (showCodeDetails && q.hasCode()) {
      x.span("background: LightGoldenRodYellow", null).tx(" "+ (context.formatPhrase(RenderingContext.DATA_REND_DETAILS, displaySystem(q.getSystem()))) +q.getCode()+" = '"+lookupCode(q.getSystem(), null, q.getCode())+"')");
    }
  }

  
  protected void renderQuantity(HierarchicalTableGenerator gen, List<Piece> pieces, Quantity q, boolean showCodeDetails) {
    pieces.add(gen.new Piece(null, displayQuantity(q), null));
  }

  public String displayRange(Range q) {
    if (!q.hasLow() && !q.hasHigh())
      return "?";

    StringBuilder b = new StringBuilder();

    boolean sameUnits = (q.getLow().hasUnit() && q.getHigh().hasUnit() && q.getLow().getUnit().equals(q.getHigh().getUnit())) 
        || (q.getLow().hasCode() && q.getHigh().hasCode() && q.getLow().getCode().equals(q.getHigh().getCode()));
    String low = "?";
    if (q.hasLow() && q.getLow().hasValue())
      low = sameUnits ? q.getLow().getValue().toString() : displayQuantity(q.getLow());
    String high = displayQuantity(q.getHigh());
    if (high.isEmpty())
      high = "?";
    b.append(low).append("\u00A0to\u00A0").append(high);
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

  public String displayPeriod(Period p) {
    String s = !p.hasStart() ? "(?)" : displayDateTime(p.getStartElement());
    s = s + " --> ";
    return s + (!p.hasEnd() ? context.formatPhrase(RenderingContext.DATA_REND_ONGOING) : displayDateTime(p.getEndElement()));
  }

  public void renderPeriod(XhtmlNode x, Period p) {
    x.addText(!p.hasStart() ? "??" : displayDateTime(p.getStartElement()));
    x.tx(" --> ");
    x.addText(!p.hasEnd() ? context.formatPhrase(RenderingContext.DATA_REND_ONGOING) : displayDateTime(p.getEndElement()));
  }
  
  public void renderUsageContext(XhtmlNode x, UsageContext u) throws FHIRFormatError, DefinitionException, IOException {
    renderCoding(x,  u.getCode());
    x.tx(": ");
    render(x, u.getValue());    
  }
  
  
  public void renderTriggerDefinition(XhtmlNode x, TriggerDefinition td) throws FHIRFormatError, DefinitionException, IOException {
    if (x.isPara()) {
      x.b().tx(context.formatPhrase(RenderingContext.DATA_REND_TYPE));
      x.tx(": ");
      x.tx(td.getType().getDisplay());

      if (td.hasName()) {    
        x.tx(", ");
        x.b().tx(context.formatPhrase(RenderingContext.DATA_REND_NAME));
        x.tx(": ");
        x.tx(context.getTranslated(td.getNameElement()));
      }
      if (td.hasCode()) {    
        x.tx(", ");
        x.b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
        x.tx(": ");
        renderCodeableConcept(x, td.getCode());
      }
      if (td.hasTiming()) {    
        x.tx(", ");
        x.b().tx(context.formatPhrase(RenderingContext.DATA_REND_TIMING));
        x.tx(": ");
        render(x, td.getTiming());
      }
      if (td.hasCondition()) {    
        x.tx(", ");
        x.b().tx(context.formatPhrase(RenderingContext.DATA_REND_COND));
        x.tx(": ");
        renderExpression(x, td.getCondition());
      }    
    } else {
      XhtmlNode tbl = x.table("grid");

      XhtmlNode tr = tbl.tr();  
      tr.td().b().tx(context.formatPhrase(RenderingContext.DATA_REND_TYPE));
      tr.td().tx(td.getType().getDisplay());

      if (td.hasName()) {    
        tr = tbl.tr();  
        tr.td().b().tx(context.formatPhrase(RenderingContext.DATA_REND_NAME));
        tr.td().tx(context.getTranslated(td.getNameElement()));
      }
      if (td.hasCode()) {    
        tr = tbl.tr();  
        tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE));
        renderCodeableConcept(tr.td(), td.getCode());
      }
      if (td.hasTiming()) {    
        tr = tbl.tr();  
        tr.td().b().tx(context.formatPhrase(RenderingContext.DATA_REND_TIMING));
        render(tr.td(), td.getTiming());
      }
      if (td.hasCondition()) {    
        tr = tbl.tr();  
        tr.td().b().tx(context.formatPhrase(RenderingContext.DATA_REND_COND));
        renderExpression(tr.td(), td.getCondition());
      }    
    }
  }
  
  public void renderDataRequirement(XhtmlNode x, DataRequirement dr) throws FHIRFormatError, DefinitionException, IOException {
    XhtmlNode tbl = x.table("grid");
    XhtmlNode tr = tbl.tr();    
    XhtmlNode td = tr.td().colspan("2");
    td.b().tx(context.formatPhrase(RenderingContext.DATA_REND_TYPE));
    td.tx(": ");
    StructureDefinition sd = context.getWorker().fetchTypeDefinition(dr.getType().toCode());
    if (sd != null && sd.hasWebPath()) {
      td.ah(sd.getWebPath()).tx(dr.getType().toCode());
    } else {
      td.tx(dr.getType().toCode());
    }
    if (dr.hasProfile()) {
      td.tx(" (");
      boolean first = true;
      for (CanonicalType p : dr.getProfile()) {
        if (first) first = false; else td.tx(" | ");
        sd = context.getWorker().fetchResource(StructureDefinition.class, p.getValue());
        if (sd != null && sd.hasWebPath()) {
          td.ah(sd.getWebPath()).tx(crPresent(sd));
        } else {
            td.tx(p.asStringValue());
        }
      }
      td.tx(")");
    }
    if (dr.hasSubject()) {
      tr = tbl.tr();    
      td = tr.td().colspan("2");
      td.b().tx(context.formatPhrase(RenderingContext.DATA_REND_SUB));
      if (dr.hasSubjectReference()) {
        renderReference(td,  dr.getSubjectReference());
      } else {
        renderCodeableConcept(td, dr.getSubjectCodeableConcept());
      }
    }
    if (dr.hasCodeFilter() || dr.hasDateFilter()) {
      tr = tbl.tr().backgroundColor("#efefef");    
      tr.td().tx(context.formatPhrase(RenderingContext.DATA_REND_FILT));
      tr.td().tx(context.formatPhrase(RenderingContext.DATA_REND_VALUE));
    }
    for (DataRequirementCodeFilterComponent cf : dr.getCodeFilter()) {
      tr = tbl.tr();    
      if (cf.hasPath()) {
        tr.td().tx(cf.getPath());
      } else {
        tr.td().tx(context.formatPhrase(RenderingContext.DATA_REND_SEARCH, cf.getSearchParam()) + " ");
      }
      if (cf.hasValueSet()) {
        td = tr.td();
        td.tx(context.formatPhrase(RenderingContext.DATA_REND_VALUESET) + " ");
        render(td, cf.getValueSetElement());
      } else {
        boolean first = true;
        td = tr.td();
        td.tx(context.formatPhrase(RenderingContext.DATA_REND_THESE_CODES) + " ");
        for (Coding c : cf.getCode()) {
          if (first) first = false; else td.tx(", ");
          render(td, c);
        }
      }
    }
    for (DataRequirementDateFilterComponent cf : dr.getDateFilter()) {
      tr = tbl.tr();    
      if (cf.hasPath()) {
        tr.td().tx(cf.getPath());
      } else {
        tr.td().tx(context.formatPhrase(RenderingContext.DATA_REND_SEARCH, cf.getSearchParam()) + " ");
      }
      render(tr.td(), cf.getValue());
    }
    if (dr.hasSort() || dr.hasLimit()) {
      tr = tbl.tr();    
      td = tr.td().colspan("2");
      if (dr.hasLimit()) {
        td.b().tx(context.formatPhrase(RenderingContext.DATA_REND_LIMIT));
        td.tx(": ");
        td.tx(dr.getLimit());
        if (dr.hasSort()) {
          td.tx(", ");
        }
      }
      if (dr.hasSort()) {
        td.b().tx(context.formatPhrase(RenderingContext.DATA_REND_SORT));
        td.tx(": ");
        boolean first = true;
        for (DataRequirementSortComponent p : dr.getSort()) {
          if (first) first = false; else td.tx(" | ");
          td.tx(p.getDirection() == SortDirection.ASCENDING ? "+" : "-");
          td.tx(p.getPath());
        }
      }
    }
  }
  
  
  private String displayTiming(Timing s) throws FHIRException {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    if (s.hasCode())
      b.append(context.formatPhrase(RenderingContext.GENERAL_CODE, displayCodeableConcept(s.getCode())) + " ");

    if (s.getEvent().size() > 0) {
      CommaSeparatedStringBuilder c = new CommaSeparatedStringBuilder();
      for (DateTimeType p : s.getEvent()) {
        if (p.hasValue()) {
          c.append(displayDateTime(p));
        } else if (!renderExpression(c, p)) {
          c.append("??");
        }        
      }
      b.append(context.formatPhrase(RenderingContext.DATA_REND_EVENTS, c.toString()) + " ");
    }

    if (s.hasRepeat()) {
      TimingRepeatComponent rep = s.getRepeat();
      if (rep.hasBoundsPeriod() && rep.getBoundsPeriod().hasStart())
        b.append(context.formatPhrase(RenderingContext.DATA_REND_STARTING, displayDateTime(rep.getBoundsPeriod().getStartElement())) + " ");
      if (rep.hasCount())
        b.append(context.formatPhrase(RenderingContext.DATA_REND_COUNT, Integer.toString(rep.getCount())) + " " + " times");
      if (rep.hasDuration())
        b.append(context.formatPhrase(RenderingContext.DATA_REND_DURATION, rep.getDuration().toPlainString()+displayTimeUnits(rep.getPeriodUnit())) + " ");

      if (rep.hasWhen()) {
        String st = "";
        if (rep.hasOffset()) {
          st = Integer.toString(rep.getOffset())+"min ";
        }
        b.append(st);
        for (Enumeration<EventTiming> wh : rep.getWhen())
          b.append(displayEventCode(wh.getValue()));
      } else {
        String st = "";
        if (!rep.hasFrequency() || (!rep.hasFrequencyMax() && rep.getFrequency() == 1) )
          st = context.formatPhrase(RenderingContext.DATA_REND_ONCE);
        else {
          st = Integer.toString(rep.getFrequency());
          if (rep.hasFrequencyMax())
            st = st + "-"+Integer.toString(rep.getFrequency());
        }
        if (rep.hasPeriod()) {
          st = st + " "+ (context.formatPhrase(RenderingContext.DATA_REND_PER))+rep.getPeriod().toPlainString();
          if (rep.hasPeriodMax())
            st = st + "-"+rep.getPeriodMax().toPlainString();
          st = st + " "+displayTimeUnits(rep.getPeriodUnit());
        }
        b.append(st);
      }
      if (rep.hasBoundsPeriod() && rep.getBoundsPeriod().hasEnd())
        b.append(context.formatPhrase(RenderingContext.DATA_REND_UNTIL, displayDateTime(rep.getBoundsPeriod().getEndElement())) + " ");
    }
    return b.toString();
  }

  private boolean renderExpression(CommaSeparatedStringBuilder c, PrimitiveType p) {
    Extension exp = p.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/cqf-expression");
    if (exp == null) {
      return false;
    }
    c.append(exp.getValueExpression().getExpression());
    return true;
  }

  private String displayEventCode(EventTiming when) {
    switch (when) {
    case C: return (context.formatPhrase(RenderingContext.DATA_REND_MEALS));
    case CD: return (context.formatPhrase(RenderingContext.DATA_REND_ATLUNCH));
    case CM: return (context.formatPhrase(RenderingContext.DATA_REND_ATBKFST));
    case CV: return (context.formatPhrase(RenderingContext.DATA_REND_ATDINR));
    case AC: return (context.formatPhrase(RenderingContext.DATA_REND_BFMEALS));
    case ACD: return (context.formatPhrase(RenderingContext.DATA_REND_BFLUNCH));
    case ACM: return (context.formatPhrase(RenderingContext.DATA_REND_BFBKFST));
    case ACV: return (context.formatPhrase(RenderingContext.DATA_REND_BFDINR));
    case HS: return (context.formatPhrase(RenderingContext.DATA_REND_BFSLEEP));
    case PC: return (context.formatPhrase(RenderingContext.DATA_REND_AFTRMEALS));
    case PCD: return (context.formatPhrase(RenderingContext.DATA_REND_AFTRLUNCH));
    case PCM: return (context.formatPhrase(RenderingContext.DATA_REND_AFTRBKFST));
    case PCV: return (context.formatPhrase(RenderingContext.DATA_REND_AFTRDINR));
    case WAKE: return (context.formatPhrase(RenderingContext.DATA_REND_AFTRWKNG));
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
      b.append(context.formatPhrase(RenderingContext.DATA_REND_ORIGIN, displayQuantity(s.getOrigin())) + " ");

    if (s.hasInterval()) {
      b.append(context.formatPhrase(RenderingContext.DATA_REND_INT, s.getInterval().toString()) + " ");

      if (s.hasIntervalUnit())
        b.append(s.getIntervalUnit().toString());
    }

    if (s.hasFactor())
      b.append(context.formatPhrase(RenderingContext.DATA_REND_FACT, s.getFactor().toString()) + " ");

    if (s.hasLowerLimit())
      b.append(context.formatPhrase(RenderingContext.DATA_REND_LOWER, s.getLowerLimit().toString()) + " ");

    if (s.hasUpperLimit())
      b.append(context.formatPhrase(RenderingContext.DATA_REND_UP, s.getUpperLimit().toString()) + " ");

    if (s.hasDimensions())
      b.append(context.formatPhrase(RenderingContext.DATA_REND_DIM, s.getDimensions()) + " ");

    if (s.hasData())
      b.append(context.formatPhrase(RenderingContext.DATA_REND_DATA, s.getData()) + " ");

    return b.toString();
  }

  protected void renderSampledData(XhtmlNode x, SampledData sampledData) {
    x.addText(displaySampledData(sampledData));
  }

  public RenderingContext getContext() {
    return context;
  }
  

  public XhtmlNode makeExceptionXhtml(Exception e, String function) {
    XhtmlNode xn;
    xn = new XhtmlNode(NodeType.Element, "div");
    XhtmlNode p = xn.para();
    p.b().tx((context.formatPhrase(RenderingContext.DATA_REND_EXCEPTION)) +function+": "+e.getMessage());
    p.addComment(getStackTrace(e));
    return xn;
  }

  private String getStackTrace(Exception e) {
    StringBuilder b = new StringBuilder();
    b.append("\r\n");
    for (StackTraceElement t : e.getStackTrace()) {
      b.append(t.getClassName()+"."+t.getMethodName()+" ("+t.getFileName()+":"+t.getLineNumber());
      b.append("\r\n");
    }
    return b.toString();
  }

  protected String versionFromCanonical(String system) {
    if (system == null) {
      return null;
    } else if (system.contains("|")) {
      return system.substring(0, system.indexOf("|"));
    } else {
      return null;
    }
  }

  protected String systemFromCanonical(String system) {
    if (system == null) {
      return null;
    } else if (system.contains("|")) {
      return system.substring(system.indexOf("|")+1);
    } else {
      return system;
    }
  }


}