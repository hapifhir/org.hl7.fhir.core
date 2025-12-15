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
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.BackboneType;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BaseDateTimeType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.terminologies.utilities.SnomedUtilities;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum; 

@MarkedToMoveToAdjunctPackage
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
            url = p.getUserString(UserDataNames.render_filename); 
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
      x.addChildNodes(m.getChildNodes()); 
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
      case "449081005": return "ES/Intl"+dt;  
      case "554471000005108": return "DK"+dt;  
      case "11000146104": return "NL"+dt;  
      case "45991000052106": return "SE"+dt;  
      case "83821000000107": return "UK"+dt; 
      case "11000172109": return "BE"+dt;  
      case "11000221109" : return "AR"+dt;      
      case "11000234105" : return "AT"+dt;  
      case "20621000087109" : return "CA-EN"+dt; 
      case "20611000087101" : return "CA"+dt; // was FR, but was repurposed for the canadian edition early 2024
      case "11000181102 " : return "EE"+dt;
      case "11000229106" : return "FI"+dt;
      case "11000274103" : return "DE"+dt;
      case "1121000189102" : return "IN"+dt;
      case "11000220105" : return "IE"+dt;
      case "21000210109" : return "NZ"+dt; 
      case "51000202101 " : return "NO"+dt;
      case "11000267109" : return "KR"+dt;
      case "900000001000122104" : return "ES-ES"+dt;
      case "2011000195101" : return "CH"+dt;
      case "999000021000000109" : return "UK+Clinical"+dt;  
      case "5631000179106" : return "UY"+dt;
      case "5991000124107" : return "US+ICD10CM"+dt;
      case "21000325107": return "CH"+dt;
      case "11000279109": return "CZ"+dt;
      case "11000181102": return "ES"+dt;
      case "51000202101": return "NO"+dt;
      case "827022005": return "IPS"+dt;
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
      return (context.formatPhrase(RenderingContext.GENERAL_UCUM)); 
    if (system.equals("http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl")) 
      return (context.formatPhrase(RenderingContext.GENERAL_NCI_THES)); 
    

    CodeSystem cs = context.getContext().fetchCodeSystem(system); 
    if (cs != null) { 
      return crPresent(cs); 
    } 
    return tails(system); 
  } 

  private String crPresent(CanonicalResource cr) { 
    if (cr.hasUserData(UserDataNames.render_presentation)) { 
      return cr.getUserString(UserDataNames.render_presentation); 
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
      if (Utilities.isValidHtmlAnchorChar(c)) {
        b.append(c);
      } else {
        b.append("|"+Integer.toHexString(c)); // not % to save double coding confusing users
      }
    } 
    return b.toString(); 
  } 

  public String lookupCode(String system, String version, String code) { 
    if (JurisdictionUtilities.isJurisdiction(system)) { 
      return JurisdictionUtilities.displayJurisdiction(system+"#"+code); 
    } 
    ValidationResult t = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions().withLanguage(context.getLocale().toLanguageTag()).withVersionFlexible(true), system, version, code, null);

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

  public String gt(ResourceWrapper value) { 
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

  public boolean hasRenderableExtensions(ResourceWrapper element) { 
    for (ResourceWrapper ext : element.extensions()) { 
      if (canRender(ext)) { 
        return true; 
      } 
    } 
    return false; 
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

  private String getExtensionLabel(ResourceWrapper ext) { 
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, ext.primitiveValue("url")); 
    if (sd != null && ext.has("value") && ext.child("value").isPrimitive() && sd.hasSnapshot()) { 
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


  private boolean canRender(ResourceWrapper ext) { 
    StructureDefinition sd = context.getWorker().fetchResource(StructureDefinition.class, ext.primitiveValue("url")); 
    if (sd != null && ext.has("value") && ext.isPrimitive("value") && sd.hasSnapshot()) { 
      for (ElementDefinition ed : sd.getSnapshot().getElement()) { 
        if (Utilities.existsInList(ed.getPath(), "Extension", "Extension.value[x]") && ed.hasLabel()) { 
          return true; 
        } 
      } 
    } 
    return false;     
  }

  public void renderExtensionsInList(RenderingStatus status, XhtmlNode ul, ResourceWrapper element) throws FHIRFormatError, DefinitionException, IOException { 
    for (ResourceWrapper ext : element.extensions()) { 
      if (canRender(ext)) { 
        String lbl = getExtensionLabel(ext); 
        XhtmlNode li = ul.li(); 
        li.tx(lbl); 
        li.tx(": "); 
        renderDataType(status, li, ext.child("value")); 
      } 
    } 
  } 

  //  public void renderExtensionsInList(XhtmlNode ul, BackboneType element) throws FHIRFormatError, DefinitionException, IOException { 
  //    for (Extension ext : element.getModifierExtension()) { 
  //      if (canRender(ext)) { 
  //        String lbl = getExtensionLabel(ext); 
  //        XhtmlNode li = ul.li(); 
  //        li = li.b(); 
  //        li.tx(lbl); 
  //        li.tx(": ");         
  //        render(li, ext.getValue()); 
  //      } else { 
  //        // somehow have to do better than this  
  //        XhtmlNode li = ul.li(); 
  //        li.b().tx(context.formatPhrase(RenderingContext.DATA_REND_UNRD_EX)); 
  //      } 
  //    } 
  //    for (Extension ext : element.getExtension()) { 
  //      if (canRender(ext)) { 
  //        String lbl = getExtensionLabel(ext); 
  //        XhtmlNode li = ul.li(); 
  //        li.tx(lbl); 
  //        li.tx(": "); 
  //        render(li, ext.getValue()); 
  //      } 
  //    } 
  //  } 
  //   
  public void renderExtensionsInText(RenderingStatus status, XhtmlNode x, ResourceWrapper element, String sep) throws FHIRFormatError, DefinitionException, IOException { 
    boolean first = true; 
    for (ResourceWrapper ext : element.extensions()) { 
      if (canRender(ext)) { 
        status.setExtensions(true);
        if (first) { 
          first = false; 
        } else { 
          x.tx(sep); 
          x.tx(" "); 
        } 

        String lbl = getExtensionLabel(ext); 
        x.tx(lbl); 
        x.tx(": "); 
        renderDataType(status, x, ext.child("value")); 
      } 
    } 
  } 
  

  protected void checkRenderExtensions(RenderingStatus status, XhtmlNode x, ResourceWrapper element) throws FHIRFormatError, DefinitionException, IOException {
    if (element.has("extension")) {
      boolean someCanRender = false;
      for (ResourceWrapper ext : element.children("extension")) {
        ResourceWrapper value = ext.child("value");
        if (canRender(ext) && value.isPrimitive()) {
          someCanRender = true;
        }
      }
      if (someCanRender) {
        status.setExtensions(true);
        x.tx(" (");
        renderExtensionsInText(status, x, element, ", ");
        x.tx(")");
      } 
    }

  }

  //  public void renderExtensionsInList(XhtmlNode div, BackboneType element, String sep) throws FHIRFormatError, DefinitionException, IOException { 
  //    boolean first = true; 
  //    for (Extension ext : element.getModifierExtension()) { 
  //      if (first) { 
  //        first = false; 
  //      } else { 
  //        div.tx(sep); 
  //        div.tx(" "); 
  //      } 
  //      if (canRender(ext)) { 
  //        String lbl = getExtensionLabel(ext); 
  //        XhtmlNode b = div.b(); 
  //        b.tx(lbl); 
  //        b.tx(": "); 
  //        render(div, ext.getValue()); 
  //      } else { 
  //        // somehow have to do better than this  
  //        div.b().tx(context.formatPhrase(RenderingContext.DATA_REND_UNRD_EX)); 
  //      } 
  //    } 
  //    for (Extension ext : element.getExtension()) { 
  //      if (canRender(ext)) { 
  //        if (first) { 
  //          first = false; 
  //        } else { 
  //          div.tx(sep); 
  //          div.tx(" "); 
  //        } 
  //          
  //        String lbl = getExtensionLabel(ext); 
  //        div.tx(lbl); 
  //        div.tx(": "); 
  //        render(div, ext.getValue()); 
  //      } 
  //    } 
  // 
  //  } 

  // -- 6. Data type Rendering ----------------------------------------------  

  public static String display(IWorkerContext context, DataType type) { 
    return new DataRenderer(new RenderingContext(context, null, null, "http://hl7.org/fhir/R4", "", context.getLocale(), ResourceRendererMode.END_USER, GenerationRules.VALID_RESOURCE)).displayDataType(type);
  } 

  public String displayBase(Base b) { 
    if (b instanceof DataType) { 
      return displayDataType((DataType) b); 
    } else { 
      return (context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, b.fhirType()) + " ");       
    } 
  } 

  public String displayDataType(DataType type) { 
    if (type == null) {
      return "";
    }
    return displayDataType(wrapNC(type));
  }

  public String displayDataType(ResourceWrapper type) { 
    if (type == null || type.isEmpty()) { 
      return ""; 
    } 

    switch (type.fhirType()) {
    case "Coding": return displayCoding(type); 
    case "CodeableConcept": return displayCodeableConcept(type); 
    case "CodeableReference": return displayCodeableReference(type); 
    case "Identifier": return displayIdentifier(type); 
    case "HumanName": return displayHumanName(type); 
    case "Address": return displayAddress(type); 
    case "ContactPoint": return displayContactPoint(type); 
    case "Quantity": return displayQuantity(type); 
    case "Range": return displayRange(type); 
    case "Period": return displayPeriod(type); 
    case "Timing": return displayTiming(type); 
    case "SampledData": return displaySampledData(type); 
    case "ContactDetail": return displayContactDetail(type); 
    case "Annotation":  return displayAnnotation(type);
    case "Ratio":  return displayRatio(type);
    case "Reference" : return displayReference(type);
    case "Money" : return displayMoney(type);
    case "dateTime":
    case "date" : 
    case "instant" :
      return displayDateTime(type);
    default:
      if (type.isPrimitive()) { 
        return context.getTranslated(type); 
      } else if (Utilities.existsInList(type.fhirType(),  "Meta", "Dosage", "Signature", "UsageContext", "RelatedArtifact", "ElementDefinition", "Base64BinaryType", "Attachment")) {
        return "";
      } else if ("Extension".equals(type.fhirType())) {
        return displayDataType(type.child("value"));
      } else {
        return (context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, type.fhirType()) + " "); 
      }
    }
  } 

  private String displayMoney(ResourceWrapper type) {
    String currency = type.primitiveValue("currency");
    String value = type.primitiveValue("value");
    return context.formatPhrase(RenderingContext.DATA_REND_CURRENCY, currency, value);
  }

  private String displayAnnotation(ResourceWrapper type) {
    return type.primitiveValue("text");
  }

  private String displayCodeableReference(ResourceWrapper type) {
    if (type.has("reference")) {
      return displayReference(type.child("reference"));
    } else {
      return displayCodeableConcept(type.child("concept"));
    }
  }


  protected String displayReference(ResourceWrapper type) {
    if (type.has("display")) {
      return type.primitiveValue("display");
    } else if (type.has("reference")) {
      //      ResourceWithReference tr = resolveReference(res, r.getReference());
      //      x.addText(tr == null ? r.getReference() : "?ngen-3"); // getDisplayForReference(tr.getReference()));
      return "?ngen-3";
    } else {
      return "?ngen-4?";
    }
  }

  private String displayRatio(ResourceWrapper type) {
    return displayQuantity(type.child("numerator"))+" / "+displayQuantity(type.child("denominator"));
  }

  protected String displayDateTime(ResourceWrapper type) { 
    if (!type.hasPrimitiveValue()) { 
      return ""; 
    } 

    BaseDateTimeType t = new DateTimeType(type.primitiveValue());
    // relevant inputs in rendering context: 
    // timeZone, dateTimeFormat, locale, mode 
    //   timezone - application specified timezone to use.  
    //        null = default to the time of the date/time itself 
    //   dateTimeFormat - application specified format for date times 
    //        null = default to ... depends on mode 
    //   mode - if rendering mode is technical, format defaults to XML format 
    //   locale - otherwise, format defaults to SHORT for the Locale (which defaults to default Locale)   
    if (isOnlyDate(t.getPrecision())) { 

      DateTimeFormatter fmt = getDateFormatForPrecision(t);       
      LocalDate date = LocalDate.of(t.getYear(), t.getMonth()+1, t.getDay()); 
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
    ZonedDateTime zdt = ZonedDateTime.parse(t.primitiveValue()); 
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


  //  public void renderDataType(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException  { 
  ////    Base base = null; 
  ////    try { 
  ////      base = type.getBase(); 
  ////    } catch (FHIRException | IOException e) { 
  ////      x.tx(context.formatPhrase(RenderingContext.DATA_REND_ERROR, e.getMessage()) + " "); // this shouldn't happen - it's an error in the library itself 
  ////      return; 
  ////    } 
  ////    if (base instanceof DataType) { 
  ////      render(x, (DataType) base); 
  ////    } else { 
  ////      x.tx(context.formatPhrase(RenderingContext.DATA_REND_TO_DO, base.fhirType())); 
  ////    } 
  //  } 

  public void renderBase(RenderingStatus status, XhtmlNode x, Base b) throws FHIRFormatError, DefinitionException, IOException { 
    if (b instanceof DataType) { 
      renderDataType(status, x, wrapNC((DataType) b)); 
    } else { 
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, b.fhirType()) + " ");       
    } 
  } 
  
  public boolean canRenderDataType(String type) {
    return context.getContextUtilities().isPrimitiveType(type) ||  Utilities.existsInList(type, "Annotation", "Coding", "CodeableConcept",  "Identifier", "HumanName", "Address", "Dosage",
          "Expression",  "Money", "ContactPoint",  "Quantity",  "Range",  "Period", "Timing", "SampledData",  "Reference", "UsageContext",  "ContactDetail",  "Ratio",  "Attachment",  "CodeableReference");
  }

  public boolean renderDataType(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException {
    return renderDataType(status, x, x, type);
  }
  
  public boolean renderDataType(RenderingStatus status, XhtmlNode parent, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException { 
    if (type == null) {
      return false;
    }
    switch (type.fhirType()) {
    case "dateTime":
    case "date" : 
    case "instant" :
      renderDateTime(status, x, type);
      break;
    case "uri" :
    case "url" :
      renderUri(status, x, type); 
      break;
    case "canonical" :
      renderCanonical(status, x, type); 
      break;
    case "Annotation": 
      renderAnnotation(status, parent, x, type); 
      break;
    case "Coding": 
      renderCodingWithDetails(status, x, type); 
      break;
    case "CodeableConcept": 
      renderCodeableConcept(status, x, type); 
      break;
    case "Identifier": 
      renderIdentifier(status, x, type); 
      break;
    case "HumanName": 
      renderHumanName(status, x, type); 
      break;
    case "Address": 
      renderAddress(status, x, type); 
      break;
    case "Expression": 
      renderExpression(status, x, type); 
      break;
    case "Money": 
      renderMoney(status, x, type); 
      break;
    case "ContactPoint": 
      renderContactPoint(status, x, type); 
      break;
    case "Quantity": 
    case "Age":
      renderQuantity(status, x, type); 
      break;
    case "Range": 
      renderRange(status, x, type); 
      break;
    case "Period": 
      renderPeriod(status, x, type); 
      break;
    case "Timing": 
      renderTiming(status, x, type); 
      break;
    case "SampledData": 
      renderSampledData(status, x, type); 
      break;
    case "Reference": 
      renderReference(status, x, type); 
      break;
    case "UsageContext": 
      renderUsageContext(status, x, type); 
      break;
    case "ContactDetail": 
      renderContactDetail(status, x, type); 
      break;
    case "Ratio": 
      renderRatio(status, x, type); 
      break;
    case "Attachment": 
      renderAttachment(status, x, type); 
      break;
    case "CodeableReference": 
      if (type.has("concept")) { 
        renderCodeableConcept(status, x, type.child("concept")); 
      } else {  
        renderReference(status, x, type.child("reference")); 
      } 
      break;
    case "code": 
      x.tx(getTranslatedCode(type)); 
      break;
    case "markdown": 
      addMarkdown(parent == null ? x : parent, context.getTranslated(type)); // note parent not focus, because of paragraph issues and markdown 
      break;
    case "base64Binary":
      int length = type.primitiveValue().length();
      if (length >= context.getBase64Limit()) {
        x.tx(context.formatPhrase(RenderingContext.DATA_REND_BASE64, length));
      } else {
        x.code(type.primitiveValue());
      }
      break;
    default:
      if (type.isPrimitive()) { 
        if (!renderPrimitiveWithNoValue(status, x, type)) {
          x.tx(context.getTranslated(type));
        }
      } else { 
        x.tx(context.formatPhrase(RenderingContext.DATA_REND_NO_DISP, type.fhirType()) + " "); 
        return false;
      }
    } 
    return true;
  } 

  // overide in ResourceRenderer
  protected void renderCanonical(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException {
    renderUri(status, x, type);
  }

  private void renderRatio(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException {
    renderQuantity(status, x, type.child("numerator"));
    x.tx("/");
    renderQuantity(status, x, type.child("denominator"));      
    checkRenderExtensions(status, x, type);
  }

  private void renderAttachment(RenderingStatus status, XhtmlNode x, ResourceWrapper att) {
    String ct = att.primitiveValue("contentType");
    if (att.has("url")) {
      x.tx(context.formatMessage(RenderingContext.DATA_REND_ATT_URL, ct, att.primitiveValue("url")));
    } else if (att.has("data")) {
      x.tx(context.formatMessage(RenderingContext.DATA_REND_ATT_DATA, ct, displayDataType(att.child("data"))));      
    }    
  }

  private void renderContactDetail(RenderingStatus status, XhtmlNode x, ResourceWrapper cd) {
    if (cd.has("name")) {
      x.tx(cd.primitiveValue("name")+": ");
    }
    boolean first = true;
    for (ResourceWrapper c : cd.children("telecom")) {
      if (first) first = false; else x.tx(",");
      renderContactPoint(status, x, c);
    }
  }

  private void renderDateTime(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException {
    if (!renderPrimitiveWithNoValue(status, x, type)) {
      x.tx(displayDateTime(type));
      checkRenderExtensions(status, x, type);
    }
  }

  /** 
   * this is overridden in ResourceRenderer where a better rendering is performed
   * @param status
   * @param x
   * @param ref
   * @throws IOException 
   * @throws DefinitionException 
   * @throws FHIRFormatError 
   */
  protected void renderReference(RenderingStatus status, XhtmlNode x, ResourceWrapper ref) throws FHIRFormatError, DefinitionException, IOException { 
    if (ref.has("display")) { 
      x.tx(context.getTranslated(ref.child("display"))); 
    } else if (ref.has("reference")) { 
      x.tx(ref.primitiveValue("reference")); 
    } else { 
      x.tx("??"); 
    } 
  } 
  // 
  //  public void renderDateTime(RenderingStatus status, XhtmlNode x, Base e) { 
  //    if (e.hasPrimitiveValue()) { 
  //      x.addText(displayDateTime((DateTimeType) e)); 
  //    } 
  //  } 
  // 
  //  public void renderDate(RenderingStatus status, XhtmlNode x, Base e) { 
  //    if (e.hasPrimitiveValue()) { 
  //      x.addText(displayDateTime((DateType) e)); 
  //    } 
  //  } 
  // 
  //  public void renderDateTime(XhtmlNode x, String s) { 
  //    if (s != null) { 
  //      DateTimeType dt = new DateTimeType(s); 
  //      x.addText(displayDateTime(dt)); 
  //    } 
  //  } 


  protected boolean renderPrimitiveWithNoValue(RenderingStatus status, XhtmlNode x, PrimitiveType<?> prim) throws FHIRFormatError, DefinitionException, IOException {
    if (prim.hasPrimitiveValue()) {
      return false;
    }
    boolean first = true;
    for (Extension ext : prim.getExtension()) {
      if (first) first = false; else x.tx(", ");
      String url = ext.getUrl();
      if (url.equals(ExtensionDefinitions.EXT_DAR)) {
        x.tx("Absent because : ");
        displayCode(x, wrapNC(ext.getValue()));
      } else if (url.equals(ExtensionDefinitions.EXT_NF)) {
        x.tx("Null because: ");
        displayCode(x, wrapNC(ext.getValue()));
      } else if (url.equals(ExtensionDefinitions.EXT_OT)) {
        x.code().tx("Text: ");
        displayCode(x, wrapNC(ext.getValue()));
      } else if (url.equals(ExtensionDefinitions.EXT_CQF_EXP)) {
        x.code().tx("Value calculated by: ");
        renderExpression(status, x, wrapNC(ext.getValue()));
      } else {
        StructureDefinition def = context.getContext().fetchResource(StructureDefinition.class, url);
        if (def == null) {
          x.code().tx(tail(url)+": ");
        } else {
          x.code().tx(def.present()+": ");
        }
        renderDataType(status, x, wrapNC(ext.getValue()));
      }
    }
    status.setExtensions(true);
    return true;
  }

  protected boolean renderPrimitiveWithNoValue(RenderingStatus status, XhtmlNode x, ResourceWrapper prim) throws FHIRFormatError, DefinitionException, IOException {
    if (prim.hasPrimitiveValue()) {
      return false;
    }
    boolean first = true;
    for (ResourceWrapper ext : prim.extensions()) {
      if (first) first = false; else x.tx(", ");
      String url = ext.primitiveValue("url");
      if (url.equals(ExtensionDefinitions.EXT_DAR)) {
        x.tx("Absent because : ");
        displayCode(x, ext.child("value"));
      } else if (url.equals(ExtensionDefinitions.EXT_NF)) {
        x.tx("Null because: ");
        displayCode(x, ext.child("value"));
      } else if (url.equals(ExtensionDefinitions.EXT_OT)) {
        x.code().tx("Text: ");
        displayCode(x, ext.child("value"));
      } else if (url.equals(ExtensionDefinitions.EXT_CQF_EXP)) {
        x.code().tx("Value calculated by: ");
        renderExpression(status, x, ext.child("value"));
      } else {
        StructureDefinition def = context.getContext().fetchResource(StructureDefinition.class, url);
        if (def == null) {
          x.code().tx(tail(url)+": ");
        } else {
          x.code().tx(def.present()+": ");
        }
        renderDataType(status, x, ext.child("value"));
      }
    }
    status.setExtensions(true);
    return true;
  }

  protected String tail(String url) {
    return url.substring(url.lastIndexOf(".")+1);
  }

  protected String utail(String url) {
    return url.contains("/") ? url.substring(url.lastIndexOf("/")+1) : url;
  }

  private void displayCode(XhtmlNode x, ResourceWrapper code) {
    x.tx(code.primitiveValue());
  }

  protected void renderUri(RenderingStatus status, XhtmlNode x, ResourceWrapper uri) throws FHIRFormatError, DefinitionException, IOException { 
    if (!renderPrimitiveWithNoValue(status, x, uri)) {
      String v = uri.primitiveValue();

      if (v != null) {
        if (context.getContextUtilities().isResource(v)) {
          v = "http://hl7.org/fhir/"+v;
        }
        if (v.startsWith("mailto:")) { 
          x.ah(v).addText(v.substring(7)); 
        } else { 
          Resource r = context.getContext().fetchResource(Resource.class, v); 
          if (r != null && r.getWebPath() != null) { 
            if (r instanceof CanonicalResource) { 
              x.ah(context.prefixLocalHref(r.getWebPath())).addText(crPresent((CanonicalResource) r));           
            } else { 
              x.ah(context.prefixLocalHref(r.getWebPath())).addText(v);           
            } 
          } else { 
            String url = context.getResolver() != null ? context.getResolver().resolveUri(context, v) : null; 
            if (url != null) {           
              x.ah(context.prefixLocalHref(url)).addText(v); 
            } else if (Utilities.isAbsoluteUrlLinkable(v) && !uri.fhirType().equals("id")) { 
              x.ah(context.prefixLocalHref(v)).addText(v); 
            } else { 
              x.addText(v); 
            } 
          } 
        } 
      }
    }      
    checkRenderExtensions(status, x, uri);
  } 
  
  protected void renderAnnotation(RenderingStatus status, XhtmlNode parent, XhtmlNode x, ResourceWrapper a) throws FHIRException, IOException { 
    if (a.has("text")) { 
      addMarkdown(parent.blockquote(), context.getTranslated(a.child("text")));
    } 

    if (a.has("author")) { 
      x.tx(context.formatPhrase(RenderingContext.DATA_REND_BY) + " "); 
      ResourceWrapper auth = a.child("author");
      if (auth.fhirType().equals("Reference")) { 
        x.tx(auth.primitiveValue("reference")); 
      } else if (auth.fhirType().equals("string")) { 
        x.tx(context.getTranslated(auth)); 
      } 
    } 


    if (a.has("time")) { 
      if (a.has("author")) { 
        x.tx(" "); 
      } 
      x.tx("@");
      x.tx(displayDateTime(a.child("time"))); 
    } 
    
  }

  public String displayCoding(ResourceWrapper c) { 
    String s = ""; 
    if (context.isTechnicalMode()) { 
      s = context.getTranslated(c.child("display")); 
      if (Utilities.noString(s)) { 
        s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code"));         
      } 
      if (Utilities.noString(s)) { 
        s = displayCodeTriple(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 
      } else if (c.has("system")) { 
        s = s + " ("+displayCodeTriple(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code"))+")"; 
      } else if (c.has("code")) { 
        s = s + " ("+c.primitiveValue("code")+")"; 
      } 
    } else { 
      if (c.has("display")) 
        return context.getTranslated(c.child("display")); 
      if (Utilities.noString(s)) 
        s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 
      if (Utilities.noString(s)) 
        s = c.primitiveValue("code"); 
    } 
    return s; 
  } 

  public String displayCodeSource(String system, String version) { 
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
      b.append(displayCoding(wrapNC(c))); 
    } 
    return b.toString(); 
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

  protected void renderCoding(HierarchicalTableGenerator gen, List<Piece> pieces, ResourceWrapper c) { 
    if (c.isEmpty()) { 
      return; 
    } 

    String url = getLinkForSystem(c.primitiveValue("system"), c.primitiveValue("version")); 
    String name = displayCodeSource(c.primitiveValue("system"), c.primitiveValue("version")); 
    if (!Utilities.noString(url)) { 
      pieces.add(gen.new Piece(url, name, c.primitiveValue("system")+(c.has("version") ? "#"+c.primitiveValue("version") : ""))); 
    } else {  
      pieces.add(gen.new Piece(null, name, c.primitiveValue("system")+(c.has("version") ? "#"+c.primitiveValue("version") : ""))); 
    } 
    pieces.add(gen.new Piece(null, "#"+c.primitiveValue("code"), null)); 
    String s = context.getTranslated(c.child("display")); 
    if (Utilities.noString(s)) { 
      s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 
    } 
    if (!Utilities.noString(s)) { 
      pieces.add(gen.new Piece(null, " \""+s+"\"", null)); 
    } 
  } 

  public String getLinkForSystem(String system, String version) { 
    if ("http://snomed.info/sct".equals(system)) {
      return "https://browser.ihtsdotools.org/";
    } else if ("http://loinc.org".equals(system)) { 
      return "https://loinc.org/";             
    } else if ("http://unitsofmeasure.org".equals(system)) { 
      return "http://ucum.org";    
    } else if ("http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl".equals(system)) { 
      return "https://ncit.nci.nih.gov/ncitbrowser/pages/home.jsf";    
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

  public String getLinkForCode(String system, String version, String code, Resource source) {
    if ("http://snomed.info/sct".equals(system)) { 
      return SnomedUtilities.getSctLink(version, code, context.getContext().getExpansionParameters());
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
    } else if ("http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl".equals(system)) { 
      if (!Utilities.noString(code)) { 
        return "https://ncit.nci.nih.gov/ncitbrowser/ConceptReport.jsp?code="+code;         
      } else { 
        return "https://ncit.nci.nih.gov/ncitbrowser/pages/home.jsf"; 
      } 
    } else if ("urn:iso:std:iso:3166".equals(system)) { 
      if (!Utilities.noString(code)) { 
        return "https://en.wikipedia.org/wiki/ISO_3166-2:"+code;         
      } else { 
        return "https://en.wikipedia.org/wiki/ISO_3166-2"; 
      } 
    } else { 
      CodeSystem cs = context.getWorker().fetchCodeSystem(system, version, source);
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

  public CodeResolution resolveCode(String system, String code, Resource source) {
    return resolveCode(new Coding().setSystem(system).setCode(code), source);
  } 

  public CodeResolution resolveCode(ResourceWrapper c) { 
    String systemName; 
    String systemLink; 
    String link; 
    String display = null; 
    String hint; 

    if (c.has("display")) 
      display = context.getTranslated(c.child("display")); 
    if (Utilities.noString(display)) 
      display = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 
    if (Utilities.noString(display)) { 
      display = c.primitiveValue("code"); 
    } 

    CodeSystem cs = context.getWorker().fetchCodeSystem(c.primitiveValue("system"));
    NamingSystem ns = null;
    if (cs == null) {
      ns = context.getContextUtilities().fetchNamingSystem(c.primitiveValue("system"));
    }
    if (ns != null) {
      systemLink = null;
      systemName = ns.present();
    } else {
      systemLink = cs != null ? cs.getWebPath() : null;
      systemName = cs != null ? crPresent(cs) : displaySystem(c.primitiveValue("system"));
    }
    link = getLinkForCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code"), c.getResourceNative());

    hint = systemName+": "+display+(c.has("version") ? " "+ context.formatPhrase(RenderingContext.DATA_REND_VERSION, c.primitiveValue("version"), ")") : ""); 
    return new CodeResolution(systemName, systemLink, link, display, hint); 
  } 

  public CodeResolution resolveCode(Coding code, Resource source) {
    return resolveCode(wrapNC(code));
  }

  public CodeResolution resolveCode(CodeableConcept code, Resource source) {
    if (code.hasCoding()) { 
      return resolveCode(code.getCodingFirstRep(), source);
    } else { 
      return new CodeResolution(null, null, null, code.getText(), code.getText()); 
    } 
  } 
  protected void renderCodingWithDetails(RenderingStatus status, XhtmlNode x, ResourceWrapper c) throws FHIRFormatError, DefinitionException, IOException { 
    String s = ""; 
    if (c.has("display")) 
      s = context.getTranslated(c.child("display")); 
    if (Utilities.noString(s)) 
      s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 

    String sn = displaySystem(c.primitiveValue("system"));
    String link = getLinkForCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code"), c.getResourceNative());
    XhtmlNode xi = link != null ? x.ah(context.prefixLocalHref(link)) : x;    
    xi.tx(sn);
    xi.tx(": ");

    xi.tx(c.primitiveValue("code"));
    
    if (!Utilities.noString(s)) { 
      x.tx(" (");
      x.tx(s);
      x.tx(")");
    }
    if (c.has("version")) { 
      x.tx(" "+context.formatPhrase(RenderingContext.DATA_REND_VERSION, c.primitiveValue("version"), ")")); 
    } 
    checkRenderExtensions(status, x, c);
  } 

  protected void renderCoding(RenderingStatus status, XhtmlNode x, ResourceWrapper c) {
    renderCoding(status, x, c, true);
  }
    
  protected void renderCoding(RenderingStatus status, XhtmlNode x, ResourceWrapper c, boolean details) { 
    String s = ""; 
    if (c.has("display")) 
      s = context.getTranslated(c.child("display")); 
    if (Utilities.noString(s)) 
      s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 

    if (Utilities.noString(s)) 
      s = c.primitiveValue("code"); 

    if (context.isTechnicalMode() && details) {
      String d = c.primitiveValue("display") == null ? lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")): c.primitiveValue("display");
      d = context.formatPhrase(d == null || d.equals(c.primitiveValue("code")) ? RenderingContext.DATA_REND_DETAILS_STATED_ND :  RenderingContext.DATA_REND_DETAILS_STATED, displaySystem(c.primitiveValue("system")), c.primitiveValue("code"), d); 
      x.addText(s+" "+d);
    } else { 
      x.span(null, "{"+c.primitiveValue("system")+" "+c.primitiveValue("code")+"}").addText(s);
    }
  } 

  public String displayCodeableConcept(ResourceWrapper cc) { 
    String s = context.getTranslated(cc.child("Text")); 
    if (Utilities.noString(s)) { 
      for (ResourceWrapper c : cc.children("coding")) { 
        if (c.has("display")) { 
          s = context.getTranslated(c.child("display")); 
          break; 
        } 
      } 
    } 
    if (Utilities.noString(s)) { 
      // still? ok, let's try looking it up 
      for (ResourceWrapper c : cc.children("coding")) { 
        if (c.has("code") && c.has("system")) { 
          s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 
          if (!Utilities.noString(s)) 
            break; 
        } 
      } 
    } 

    if (Utilities.noString(s)) { 
      if (!cc.has("coding")) 
        s = ""; 
      else 
        s = cc.children("coding").get(0).primitiveValue("code"); 
    } 
    return s; 
  } 


  protected void renderCodeableReference(RenderingStatus status, XhtmlNode x, ResourceWrapper e) throws FHIRFormatError, DefinitionException, IOException { 
    if (e.has("concept")) { 
      renderCodeableConcept(status, x, e.child("concept")); 
    } 
    if (e.has("reference")) { 
      renderReference(status, x, e.child("reference")); 
    } 
  } 

  protected void renderCodeableConcept(RenderingStatus status, XhtmlNode x, ResourceWrapper cc) throws FHIRFormatError, DefinitionException, IOException { 
    if (cc.isEmpty()) { 
      return; 
    } 

    String s = context.getTranslated(cc.child("text")); 
    if (Utilities.noString(s)) { 
      for (ResourceWrapper c : cc.children("coding")) { 
        if (c.has("display")) { 
          s = context.getTranslated(c.child("display")); 
          break; 
        } 
      } 
    } 
    if (Utilities.noString(s)) { 
      // still? ok, let's try looking it up 
      for (ResourceWrapper c : cc.children("coding")) { 
        if (c.has("code") && c.has("system")) { 
          s = lookupCode(c.primitiveValue("system"), c.primitiveValue("version"), c.primitiveValue("code")); 
          if (!Utilities.noString(s)) 
            break; 
        } 
      } 
    } 

    if (Utilities.noString(s)) { 
      if (!cc.has("coding")) 
        s = ""; 
      else 
        s = cc.children("coding").get(0).primitiveValue("code"); 
    } 

    if (status.isShowCodeDetails()) { 
      x.addTextWithLineBreaks(s+" "); 
      XhtmlNode sp = x.span("background: LightGoldenRodYellow; margin: 4px; border: 1px solid khaki", null); 
      sp.tx(" ("); 
      boolean first = true; 
      for (ResourceWrapper c : cc.children("coding")) { 
        if (first) { 
          first = false; 
        } else { 
          sp.tx("; "); 
        } 
        String url = getLinkForSystem(c.primitiveValue("system"), c.primitiveValue("version")); 
        if (url != null) { 
          sp.ah(context.prefixLocalHref(url)).tx(displayCodeSource(c.primitiveValue("system"), c.primitiveValue("version"))); 
        } else { 
          sp.tx(displayCodeSource(c.primitiveValue("system"), c.primitiveValue("version"))); 
        } 
        if (c.has("code")) { 
          sp.tx("#"+c.primitiveValue("code")); 
        } 
        if (c.has("display") && !s.equals(c.primitiveValue("display"))) { 
          sp.tx(" \""+context.getTranslated(c.child("display"))+"\""); 
        } 
      } 
      if (hasRenderableExtensions(cc)) { 
        if (!first) { 
          sp.tx("; "); 
        } 
        renderExtensionsInText(status, sp, cc, ";"); 
      } 
      sp.tx(")"); 
    } else { 

      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(); 
      for (ResourceWrapper c : cc.children("coding")) { 
        if (c.has("code") && c.has("system")) { 
          b.append("{"+c.primitiveValue("system")+" "+c.primitiveValue("code")+"}"); 
        } 
      } 

      x.span(null, context.formatPhrase(RenderingContext.DATA_REND_CODES) +b.toString()).addTextWithLineBreaks(s); 
    }       
    checkRenderExtensions(status, x, cc);
  } 

  protected String displayIdentifier(ResourceWrapper ii) { 
    String s = Utilities.noString(ii.primitiveValue("value")) ? "?ngen-9?" : ii.primitiveValue("value"); 
    if ("urn:ietf:rfc:3986".equals(ii.primitiveValue("system")) && s.startsWith("urn:oid:")) { 
      s = "OID:"+s.substring(8); 
    } else if ("urn:ietf:rfc:3986".equals(ii.primitiveValue("system")) && s.startsWith("urn:uuid:")) { 
      s = "UUID:"+s.substring(9); 
    } else {  
      NamingSystem ns = context.getContext().getNSUrlMap().get(ii.primitiveValue("system")); 
      if (ns != null) { 
        s = crPresent(ns)+"#"+s; 
      } 
      if (ii.has("type")) { 
        ResourceWrapper type = ii.child("type");
        if (type.has("text")) 
          s = context.getTranslated(type.child("text"))+":\u00A0"+s; 
        else if (type.has("coding") && type.children("coding").get(0).has("display")) 
          s = context.getTranslated(type.children("coding").get(0).child("display"))+": "+s; 
        else if (type.has("coding") && type.children("coding").get(0).has("code")) 
          s = lookupCode(type.children("coding").get(0).primitiveValue("system"), type.children("coding").get(0).primitiveValue("version"), type.children("coding").get(0).primitiveValue("code")); 
      } else if (ii.has("system")) { 
        s = ii.primitiveValue("system")+"#"+s; 
      } 
    } 

    if (ii.has("use") || ii.has("period")) { 
      s = s + "\u00A0("; 
      if (ii.has("use")) { 
        s = s + "use:\u00A0"+ii.primitiveValue("use"); 
      } 
      if (ii.has("use") || ii.has("period")) { 
        s = s + ",\u00A0"; 
      } 
      if (ii.has("period")) { 
        s = s + "period:\u00A0"+displayPeriod(ii.child("period")); 
      } 
      s = s + ")"; 
    }     
    return s; 
  } 

  protected void renderIdentifier(RenderingStatus status, XhtmlNode x, ResourceWrapper ii) throws FHIRFormatError, DefinitionException, IOException {     
    if (ii.has("type")) { 
      ResourceWrapper type = ii.child("type");
      if (type.has("text")) { 
        x.tx(context.getTranslated(type.child("text"))); 
      } else if (type.has("coding") && type.children("coding").get(0).has("display")) { 
        x.tx(context.getTranslated(type.children("coding").get(0).child("display"))); 
      } else if (type.has("coding") && type.children("coding").get(0).has("code")) { 
        x.tx(lookupCode(type.children("coding").get(0).primitiveValue("system"), type.children("coding").get(0).primitiveValue("version"), type.children("coding").get(0).primitiveValue("code"))); 
      } 
      x.tx("/"); 
    } else if (ii.has("system")) { 
      NamingSystem ns = context.getContext().getNSUrlMap().get(ii.primitiveValue("system")); 
      if (ns != null) { 
        if (ns.hasWebPath()) { 
          x.ah(context.prefixLocalHref(ns.getWebPath()), ns.getDescription()).tx(crPresent(ns));         
        } else { 
          x.tx(crPresent(ns)); 
        } 
      } else { 
        switch (ii.primitiveValue("system")) { 
        case "urn:oid:2.51.1.3": 
          x.ah("https://www.gs1.org/standards/id-keys/gln", context.formatPhrase(RenderingContext.DATA_REND_GLN)).tx("GLN"); 
          break; 
        default: 
          x.code(ii.primitiveValue("system"));       
        } 
      } 
      x.tx("/"); 
    } 
    x.tx(Utilities.noString(ii.primitiveValue("value")) ? "?ngen-9?" : ii.primitiveValue("value")); 

    if (ii.has("use") || ii.has("period")) { 
      x.nbsp(); 
      x.tx("("); 
      if (ii.has("use")) { 
        x.tx(context.formatPhrase(RenderingContext.DATA_REND_USE)); 
        x.nbsp(); 
        x.tx(ii.primitiveValue("use")); 
      } 
      if (ii.has("use") || ii.has("period")) { 
        x.tx(","); 
        x.nbsp(); 
      } 
      if (ii.has("period")) { 
        x.tx(context.formatPhrase(RenderingContext.DATA_REND_PERIOD)); 
        x.nbsp(); 
        x.tx(displayPeriod(ii.child("period"))); 
      } 
      x.tx(")"); 
    }            
    checkRenderExtensions(status, x, ii);   
  } 

  public static String displayHumanName(ResourceWrapper name) { 
    StringBuilder s = new StringBuilder(); 
    if (name.has("text")) 
      s.append(name.primitiveValue("text")); 
    else { 
      for (ResourceWrapper p : name.children("given")) { 
        s.append(p.primitiveValue()); 
        s.append(" "); 
      } 
      if (name.has("family")) { 
        s.append(name.primitiveValue("family")); 
        s.append(" "); 
      } 
    } 
    if (name.has("use") && !"usual".equals(name.primitiveValue("use"))) 
      s.append("("+name.primitiveValue("use")+")"); 
    return s.toString(); 
  } 


  protected void renderHumanName(RenderingStatus status, XhtmlNode x, ResourceWrapper name) throws FHIRFormatError, DefinitionException, IOException { 
    StringBuilder s = new StringBuilder(); 
    if (name.has("text")) 
      s.append(context.getTranslated(name.child("text"))); 
    else { 
      for (ResourceWrapper p : name.children("given")) { 
        s.append(context.getTranslated(p)); 
        s.append(" "); 
      } 
      if (name.has("family")) { 
        s.append(context.getTranslated(name.child("family"))); 
        s.append(" "); 
      } 
    } 
    if (name.has("use") && !"usual".equals(name.primitiveValue("use"))) { 
      s.append("("+context.getTranslatedCode(name.primitiveValue("use"), "http://hl7.org/fhir/name-use")+")");
    }
    x.addTextWithLineBreaks(s.toString());       
    checkRenderExtensions(status, x, name);
  } 

  private String displayAddress(ResourceWrapper address) { 
    StringBuilder s = new StringBuilder(); 
    if (address.has("text")) 
      s.append(context.getTranslated(address.child("text"))); 
    else { 
      for (ResourceWrapper p : address.children("line")) { 
        s.append(context.getTranslated(p)); 
        s.append(" "); 
      } 
      if (address.has("city")) { 
        s.append(context.getTranslated(address.child("city"))); 
        s.append(" "); 
      } 
      if (address.has("state")) { 
        s.append(context.getTranslated(address.child("state"))); 
        s.append(" "); 
      } 

      if (address.has("postalCode")) { 
        s.append(context.getTranslated(address.child("postalCode"))); 
        s.append(" "); 
      } 

      if (address.has("country")) { 
        s.append(context.getTranslated(address.child("country"))); 
        s.append(" "); 
      } 
    } 
    if (address.has("use")) {
      s.append("("+address.primitiveValue("use")+")");
    }
    return s.toString(); 
  } 

  protected void renderAddress(RenderingStatus status, XhtmlNode x, ResourceWrapper address) throws FHIRFormatError, DefinitionException, IOException { 
    x.addTextWithLineBreaks(displayAddress(address));       
    checkRenderExtensions(status, x, address);
  } 


  public String displayContactPoint(ResourceWrapper contact) { 
    StringBuilder s = new StringBuilder(); 
    s.append(describeSystem(contact.primitiveValue("system"))); 
    if (Utilities.noString(contact.primitiveValue("value"))) 
      s.append("-unknown-"); 
    else 
      s.append(contact.primitiveValue("value")); 
    if (contact.has("use")) 
      s.append("("+getTranslatedCode(contact.child("use"))+")"); 
    return s.toString(); 
  } 

  public String displayContactDetail(ResourceWrapper contact) { 
    CommaSeparatedStringBuilder s = new CommaSeparatedStringBuilder(); 
    for (ResourceWrapper cp : contact.children("telecom")) { 
      s.append(displayContactPoint(cp)); 
    } 
    return contact.primitiveValue("name")+(s.length() == 0 ? "" : " ("+s.toString()+")"); 
  } 

  protected String getLocalizedBigDecimalValue(BigDecimal input, Currency c) { 
    NumberFormat numberFormat = NumberFormat.getNumberInstance(context.getLocale()); 
    numberFormat.setGroupingUsed(true); 
    numberFormat.setMaximumFractionDigits(c.getDefaultFractionDigits()); 
    numberFormat.setMinimumFractionDigits(c.getDefaultFractionDigits()); 
    return numberFormat.format(input); 
  } 

  protected void renderMoney(RenderingStatus status, XhtmlNode x, ResourceWrapper money) { 
    if (x.getName().equals("blockquote")) { 
      x = x.para(); 
    } 
    Currency c = money.has("currency") ? Currency.getInstance(money.primitiveValue("currency")) : null; 
    if (c != null) { 
      XhtmlNode s = x.span(null, c.getDisplayName()); 
      s.tx(c.getSymbol(context.getLocale())); 
      s.tx(getLocalizedBigDecimalValue(new BigDecimal(money.primitiveValue("value")), c)); 
      x.tx(" ("+c.getCurrencyCode()+")"); 
    } else { 
      if (money.has("currency")) { 
        x.tx(money.primitiveValue("currency")); 
      } 
      x.tx(money.primitiveValue("value")); 
    } 
  } 

  protected void renderExpression(RenderingStatus status, XhtmlNode x, ResourceWrapper expr) { 
    // there's two parts: what the expression is, and how it's described.  
    // we start with what it is, and then how it's described  
    XhtmlNode p = x; 
    if (p.getName().equals("blockquote")) { 
      p = p.para(); 
    } 
    if (expr.has("expression")) { 
      if (expr.has("reference")) { 
        p = x.ah(context.prefixLocalHref(expr.primitiveValue("reference")));         
      } 
      XhtmlNode c = p; 
      if (expr.has("language")) { 
        c = c.span(null, expr.primitiveValue("language")); 
      } 
      c.code().tx(expr.primitiveValue("expression")); 
    } else if (expr.has("reference")) { 
      p.ah(context.prefixLocalHref(expr.primitiveValue("reference"))).tx(context.formatPhrase(RenderingContext.DATA_REND_SOURCE)); 
    } 
    if (expr.has("name") || expr.has("description")) { 
      p.tx("("); 
      if (expr.has("name")) { 
        p.b().tx(expr.primitiveValue("name")); 
      } 
      if (expr.has("description")) { 
        p.tx("\""); 
        p.tx(context.getTranslated(expr.child("description"))); 
        p.tx("\""); 
      } 
      p.tx(")"); 
    } 
  } 


  protected void renderContactPoint(RenderingStatus status, XhtmlNode x, ResourceWrapper contact) { 
    if (contact != null) { 
      if (!contact.has("system")) { 
        x.addText(displayContactPoint(contact));         
      } else { 
        String v = contact.primitiveValue("value");
        switch (contact.primitiveValue("system")) { 
        case "email": 
          x.ah("mailto:"+v).tx(v); 
          break; 
        case "fax": 
          x.addText(displayContactPoint(contact)); 
          break; 
        case "other": 
          x.addText(displayContactPoint(contact)); 
          break; 
        case "pager": 
          x.addText(displayContactPoint(contact)); 
          break; 
        case "phone": 
          if (contact.has("value") && v != null && v.startsWith("+")) { 
            x.ah("tel:"+v.replace(" ", "")).tx(v); 
          } else { 
            x.addText(displayContactPoint(contact)); 
          } 
          break; 
        case "sms": 
          x.addText(displayContactPoint(contact)); 
          break; 
        case "url": 
          x.ah(context.prefixLocalHref(v)).tx(v); 
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

  protected void addTelecom(XhtmlNode p, ResourceWrapper c) { 
    String sys = c.primitiveValue("system");
    String value = c.primitiveValue("value");
    if (sys.equals("phone")) { 
      p.tx(context.formatPhrase(RenderingContext.DATA_REND_PHONE, value) + " "); 
    } else if (sys.equals("fax")) { 
      p.tx(context.formatPhrase(RenderingContext.DATA_REND_FAX, value) + " "); 
    } else if (sys.equals("email")) { 
      p.ah("mailto:"+value).addText(value); 
    } else if (sys.equals("url")) { 
      if (value.length() > 30) 
        p.ah(context.prefixLocalHref(value)).addText(value.substring(0, 30)+"..."); 
      else 
        p.ah(context.prefixLocalHref(value)).addText(value); 
    } 
  } 
  private static String describeSystem(String system) { 
    if (system == null) 
      return ""; 
    switch (system) { 
    case "phone": return "ph: "; 
    case "fax": return "fax: "; 
    default: 
      return ""; 
    } 
  } 

  protected String displayQuantity(ResourceWrapper q) { 
    if (q == null) {
      return "";
    }
    StringBuilder s = new StringBuilder(); 

    s.append(q.has("value") ? q.primitiveValue("value") : "?"); 
    if (q.has("unit")) 
      s.append(" ").append(q.primitiveValue("unit")); 
    else if (q.has("code")) 
      s.append(" ").append(q.primitiveValue("code")); 

    return s.toString(); 
  }   

  protected void renderQuantity(RenderingStatus status, XhtmlNode x, ResourceWrapper q) throws FHIRFormatError, DefinitionException, IOException { 
    if (q.has("comparator")) 
      x.addText(q.primitiveValue("comparator")); 
    if (q.has("value")) { 
      x.addText(context.getTranslated(q.child("value"))); 
    } 
    if (q.has("unit")) 
      x.tx(" "+context.getTranslated(q.child("unit"))); 
    else if (q.has("code") && q.has("system")) { 
      // if there's a code there *shall* be a system, so if we've got one and not the other, things are invalid and we won't bother trying to render 
      if (q.has("system") && q.primitiveValue("system").equals("http://unitsofmeasure.org")) 
        x.tx(" "+q.primitiveValue("code")); 
      else 
        x.tx("(unit "+q.primitiveValue("code")+" from "+q.primitiveValue("system")+")"); 
    } 
    if (context.isTechnicalMode() && q.has("code")) { 
      x.span("background: LightGoldenRodYellow", null).tx(" "+ (context.formatPhrase(RenderingContext.DATA_REND_DETAILS, displaySystem(q.primitiveValue("system")))) +q.primitiveValue("code")+" = '"+lookupCode(q.primitiveValue("system"), null, q.primitiveValue("code"))+"')"); 
    }       
    checkRenderExtensions(status, x, q);
  } 


  protected void renderQuantity(HierarchicalTableGenerator gen, List<Piece> pieces, ResourceWrapper q, boolean showCodeDetails) { 
    pieces.add(gen.new Piece(null, displayQuantity(q), null)); 
  } 

  protected void renderQuantity(HierarchicalTableGenerator gen, List<Piece> pieces, Quantity q, boolean showCodeDetails) { 
    pieces.add(gen.new Piece(null, displayQuantity(wrapNC(q)), null)); 
  } 

  public String displayRange(ResourceWrapper q) { 
    if (!q.has("low") && !q.has("high")) 
      return "?"; 

    StringBuilder b = new StringBuilder(); 

    ResourceWrapper lowC = q.child("low");
    ResourceWrapper highC = q.child("high");
    boolean sameUnits = (lowC != null && highC != null) && ((lowC.has("unit") && highC.has("unit") && lowC.child("unit").matches(highC.child("unit")))  
        || (lowC.has("code") && highC.has("code") && lowC.child("code").matches(highC.child("code")))); 
    String low = "?"; 
    if (q.has("low") && lowC.has("value")) 
      low = sameUnits ? lowC.primitiveValue("value").toString() : displayQuantity(lowC); 
    String high = displayQuantity(highC); 
    if (high.isEmpty()) 
      high = "?"; 
    b.append(low).append("\u00A0to\u00A0").append(high); 
    return b.toString(); 
  } 

  protected void renderRange(RenderingStatus status, XhtmlNode x, ResourceWrapper q) { 
    if (q.has("low")) 
      x.addText(q.child("low").primitiveValue("value").toString()); 
    else 
      x.tx("?"); 
    x.tx("-"); 
    if (q.has("high")) 
      x.addText(q.child("high").primitiveValue("value").toString()); 
    else 
      x.tx("?"); 
    if (q.has("low") && q.child("low").has("unit")) 
      x.tx(" "+q.child("low").primitiveValue("unit")); 
  } 

  public String displayPeriod(ResourceWrapper p) { 
    String s = !p.has("start") ? "(?)" : displayDateTime(p.child("start")); 
    s = s + " --> "; 
    return s + (!p.has("end") ? context.formatPhrase(RenderingContext.DATA_REND_ONGOING) : displayDateTime(p.child("end"))); 
  } 

  public void renderPeriod(RenderingStatus status, XhtmlNode x, ResourceWrapper p) { 
    x.addText(!p.has("start") ? "??" : displayDateTime(p.child("start"))); 
    x.tx(" --> "); 
    x.addText(!p.has("end") ? context.formatPhrase(RenderingContext.DATA_REND_ONGOING) : displayDateTime(p.child("end"))); 
  } 

  public void renderUsageContext(RenderingStatus status, XhtmlNode x, ResourceWrapper u) throws FHIRFormatError, DefinitionException, IOException { 
    renderCoding(status, x, u.child("code"), false); 
    x.tx(" = "); 
    renderDataType(status, x, u.child("value"));     
  } 


  public void renderTriggerDefinition(RenderingStatus status, XhtmlNode x, ResourceWrapper td) throws FHIRFormatError, DefinitionException, IOException { 
    if (x.isPara()) { 
      x.b().tx(context.formatPhrase(RenderingContext.GENERAL_TYPE)); 
      x.tx(": "); 
      x.tx(td.child("type").primitiveValue("display")); 

      if (td.has("name")) {     
        x.tx(", "); 
        x.b().tx(context.formatPhrase(RenderingContext.GENERAL_NAME)); 
        x.tx(": "); 
        x.tx(context.getTranslated(td.child("name"))); 
      } 
      if (td.has("code")) {     
        x.tx(", "); 
        x.b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE)); 
        x.tx(": "); 
        renderCodeableConcept(status, x, td.child("code")); 
      } 
      if (td.has("timing")) {     
        x.tx(", "); 
        x.b().tx(context.formatPhrase(RenderingContext.DATA_REND_TIMING)); 
        x.tx(": "); 
        renderDataType(status, x, td.child("timing")); 
      } 
      if (td.has("condition")) {     
        x.tx(", "); 
        x.b().tx(context.formatPhrase(RenderingContext.DATA_REND_COND)); 
        x.tx(": "); 
        renderExpression(status, x, td.child("condition")); 
      }     
    } else { 
      XhtmlNode tbl = x.table("grid", false); 

      XhtmlNode tr = tbl.tr();   
      tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_TYPE)); 
      tr.td().tx(td.child("type").primitiveValue("display")); 

      if (td.has("name")) {     
        tr = tbl.tr();   
        tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_NAME)); 
        tr.td().tx(context.getTranslated(td.child("name"))); 
      } 
      if (td.has("code")) {     
        tr = tbl.tr();   
        tr.td().b().tx(context.formatPhrase(RenderingContext.GENERAL_CODE)); 
        renderCodeableConcept(status, tr.td(), td.child("code")); 
      } 
      if (td.has("timing")) {     
        tr = tbl.tr();   
        tr.td().b().tx(context.formatPhrase(RenderingContext.DATA_REND_TIMING)); 
        renderDataType(status, tr.td(), td.child("timing")); 
      } 
      if (td.has("condition")) {      
        tr = tbl.tr();   
        tr.td().b().tx(context.formatPhrase(RenderingContext.DATA_REND_COND)); 
        renderExpression(status, tr.td(), td.child("condition")); 
      }     
    } 
  } 

  public void renderDataRequirement(RenderingStatus status, XhtmlNode x, ResourceWrapper dr) throws FHIRFormatError, DefinitionException, IOException { 
    XhtmlNode tbl = x.table("grid", false); 
    XhtmlNode tr = tbl.tr();     
    XhtmlNode td = tr.td().colspan("2"); 
    td.b().tx(context.formatPhrase(RenderingContext.GENERAL_TYPE)); 
    td.tx(": "); 
    StructureDefinition sd = context.getWorker().fetchTypeDefinition(dr.primitiveValue("type")); 
    if (sd != null && sd.hasWebPath()) { 
      td.ah(context.prefixLocalHref(sd.getWebPath())).tx(dr.primitiveValue("type")); 
    } else { 
      td.tx(dr.primitiveValue("type")); 
    } 
    if (dr.has("profile")) { 
      td.tx(" ("); 
      boolean first = true; 
      for (ResourceWrapper p : dr.children("profile")) { 
        if (first) first = false; else td.tx(" | "); 
        sd = context.getWorker().fetchResource(StructureDefinition.class, p.primitiveValue()); 
        if (sd != null && sd.hasWebPath()) { 
          td.ah(context.prefixLocalHref(sd.getWebPath())).tx(crPresent(sd)); 
        } else { 
          td.tx(p.primitiveValue()); 
        } 
      } 
      td.tx(")"); 
    } 
    if (dr.has("subject")) { 
      tr = tbl.tr();     
      td = tr.td().colspan("2"); 
      td.b().tx(context.formatPhrase(RenderingContext.GENERAL_SUBJ)); 
      ResourceWrapper subj = dr.child("subject");
      if (subj.fhirType().equals("reference")) { 
        renderReference(status, td, subj); 
      } else { 
        renderCodeableConcept(status, td, subj); 
      } 
    } 
    if (dr.has("codeFilter") || dr.has("dateFilter")) { 
      tr = tbl.tr().backgroundColor("#efefef");     
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_FILTER)); 
      tr.td().tx(context.formatPhrase(RenderingContext.GENERAL_VALUE)); 
    } 
    for (ResourceWrapper cf : dr.children("codeFilter")) { 
      tr = tbl.tr();     
      if (cf.has("path")) { 
        tr.td().tx(cf.primitiveValue("path")); 
      } else { 
        tr.td().tx(context.formatPhrase(RenderingContext.DATA_REND_SEARCH, cf.primitiveValue("searchParam")) + " "); 
      } 
      if (cf.has("valueSet")) { 
        td = tr.td(); 
        td.tx(context.formatPhrase(RenderingContext.DATA_REND_VALUESET) + " "); 
        renderDataType(status, td, cf.child("valueSet")); 
      } else { 
        boolean first = true; 
        td = tr.td(); 
        td.tx(context.formatPhrase(RenderingContext.DATA_REND_THESE_CODES) + " "); 
        for (ResourceWrapper c : cf.children("code")) { 
          if (first) first = false; else td.tx(", "); 
          renderDataType(status, td, c); 
        } 
      } 
    } 
    for (ResourceWrapper cf : dr.children("dateFilter")) { 
      tr = tbl.tr();     
      if (cf.has("path")) { 
        tr.td().tx(cf.primitiveValue("path")); 
      } else { 
        tr.td().tx(context.formatPhrase(RenderingContext.DATA_REND_SEARCH, cf.primitiveValue("searchParam")) + " "); 
      } 
      renderDataType(status, tr.td(), cf.child("value")); 
    } 
    if (dr.has("sort") || dr.has("limit")) { 
      tr = tbl.tr();     
      td = tr.td().colspan("2"); 
      if (dr.has("limit")) { 
        td.b().tx(context.formatPhrase(RenderingContext.DATA_REND_LIMIT)); 
        td.tx(": "); 
        td.tx(dr.primitiveValue("limit")); 
        if (dr.has("sort")) { 
          td.tx(", "); 
        } 
      } 
      if (dr.has("sort")) { 
        td.b().tx(context.formatPhrase(RenderingContext.DATA_REND_SORT)); 
        td.tx(": "); 
        boolean first = true; 
        for (ResourceWrapper p : dr.children("sort")) { 
          if (first) first = false; else td.tx(" | "); 
          td.tx(p.primitiveValue("direction").equals("ascending") ? "+" : "-"); 
          td.tx(p.primitiveValue("path")); 
        } 
      } 
    } 
  } 


  private String displayTiming(ResourceWrapper s) throws FHIRException { 
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(); 
    if (s.has("code")) {
      b.append(context.formatPhrase(RenderingContext.GENERAL_CODE, displayCodeableConcept(s.child("code"))) + " "); 
    }

    if (s.has("event")) { 
      CommaSeparatedStringBuilder c = new CommaSeparatedStringBuilder(); 
      for (ResourceWrapper p : s.children("event")) { 
        if (p.hasPrimitiveValue()) { 
          c.append(displayDateTime(p)); 
        } else if (!renderExpression(c, p)) { 
          c.append("??"); 
        }         
      } 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_EVENTS, c.toString()) + " "); 
    } 

    if (s.has("repeat")) { 
      ResourceWrapper rep = s.child("repeat"); 
      if (rep.has("boundsPeriod") && rep.child("boundsPeriod").has("start")) 
        b.append(context.formatPhrase(RenderingContext.DATA_REND_STARTING, displayDateTime(rep.child("boundsPeriod").child("start"))) + " "); 
      if (rep.has("count")) 
        b.append(context.formatPhrase(RenderingContext.DATA_REND_COUNT, rep.primitiveValue("count")) + " " + " times"); 
      if (rep.has("duration")) 
        b.append(context.formatPhrase(RenderingContext.DATA_REND_DURATION, rep.primitiveValue("duration")+displayTimeUnits(rep.primitiveValue("periodUnit"), "1".equals(rep.primitiveValue("duration")))) + " "); 

      String st = ""; 
      if (rep.has("offset")) { 
        st = rep.primitiveValue("offset")+"min "; 
      } 
      if (!Utilities.noString(st)) {
        b.append(st); 
      }
      for (ResourceWrapper wh : rep.children("when"))  {
        b.append(displayEventCode(wh.primitiveValue()));
      }
      st = ""; 
      if (!rep.has("frequency") || (!rep.has("frequencyMax") && rep.primitiveValue("frequency").equals("1"))) { 
        st = context.formatPhrase(RenderingContext.DATA_REND_ONCE); 
      } else { 
        st = rep.primitiveValue("frequency"); 
        if (rep.has("frequencyMax")) 
          st = st + "-"+rep.primitiveValue("frequencyMax"); 
      } 
      if (rep.has("period")) { 
        st = st + " "+ (context.formatPhrase(RenderingContext.DATA_REND_PER))+" "+rep.primitiveValue("period"); 
        if (rep.has("periodMax")) {
          st = st + "-"+rep.primitiveValue("periodMax");
        }
        st = st + " "+displayTimeUnits(rep.primitiveValue("periodUnit"), "1".equals(rep.primitiveValue("period"))); 
      } 
      if (!Utilities.noString(st)) {
        b.append(st);
      }
      if (rep.has("boundsPeriod") && rep.child("boundsPeriod").has("end")) { 
        b.append(context.formatPhrase(RenderingContext.DATA_REND_UNTIL, displayDateTime(rep.child("boundsPeriod").child("end"))) + " ");
      }
    } 
    return b.toString(); 
  } 

  private boolean renderExpression(CommaSeparatedStringBuilder c, ResourceWrapper p) { 
    ResourceWrapper exp = p.extensionValue("http://hl7.org/fhir/StructureDefinition/cqf-expression"); 
    if (exp == null || !exp.has("value")) { 
      return false; 
    } 
    c.append(exp.child("value").primitiveValue("expression")); 
    return true; 
  } 

  private String displayEventCode(String when) { 
    if (when == null) 
      return "??"; 
    switch (when.toLowerCase()) { 
    case "c": return (context.formatPhrase(RenderingContext.DATA_REND_MEALS)); 
    case "cd": return (context.formatPhrase(RenderingContext.DATA_REND_ATLUNCH)); 
    case "cm": return (context.formatPhrase(RenderingContext.DATA_REND_ATBKFST)); 
    case "cv": return (context.formatPhrase(RenderingContext.DATA_REND_ATDINR)); 
    case "ac": return (context.formatPhrase(RenderingContext.DATA_REND_BFMEALS)); 
    case "acd": return (context.formatPhrase(RenderingContext.DATA_REND_BFLUNCH)); 
    case "acm": return (context.formatPhrase(RenderingContext.DATA_REND_BFBKFST)); 
    case "acv": return (context.formatPhrase(RenderingContext.DATA_REND_BFDINR)); 
    case "hs": return (context.formatPhrase(RenderingContext.DATA_REND_BFSLEEP)); 
    case "pc": return (context.formatPhrase(RenderingContext.DATA_REND_AFTRMEALS)); 
    case "pcd": return (context.formatPhrase(RenderingContext.DATA_REND_AFTRLUNCH)); 
    case "pcm": return (context.formatPhrase(RenderingContext.DATA_REND_AFTRBKFST)); 
    case "pcv": return (context.formatPhrase(RenderingContext.DATA_REND_AFTRDINR)); 
    case "wake": return (context.formatPhrase(RenderingContext.DATA_REND_AFTRWKNG)); 
    case "morn": return (context.formatPhrase(RenderingContext.DATA_REND_MORNING));  
    case "morn.early": return (context.formatPhrase(RenderingContext.DATA_REND_MORNING_EARLY)); 
    case "morn.late": return (context.formatPhrase(RenderingContext.DATA_REND_MORNING_LATE)); 
    case "noon": return (context.formatPhrase(RenderingContext.DATA_REND_NOON));   
    case "aft": return (context.formatPhrase(RenderingContext.DATA_REND_AFTERNOON));  
    case "aft.early": return (context.formatPhrase(RenderingContext.DATA_REND_AFTERNOON_EARLY));  
    case "aft.late": return (context.formatPhrase(RenderingContext.DATA_REND_AFTERNOON_LATE));  
    case "eve": return (context.formatPhrase(RenderingContext.DATA_REND_EVENING));   
    case "eve.early": return (context.formatPhrase(RenderingContext.DATA_REND_EVENING_EARLY)); 
    case "eve.late": return (context.formatPhrase(RenderingContext.DATA_REND_EVENING_LATE));  
    case "night": return (context.formatPhrase(RenderingContext.DATA_REND_NIGHT));   
    case "phs": return (context.formatPhrase(RenderingContext.DATA_REND_AFTER_SLEEP)); 
    case "imd": return (context.formatPhrase(RenderingContext.DATA_REND_IMMEDIATE));  
    
    default: return "?"+when+"?"; 
    } 
  } 

  private String displayTimeUnits(String units, boolean singular) { 
    if (units == null) 
      return "??"; 
    switch (units) { 
    case "a": return singular ? "year" : "years"; 
    case "d": return singular ? "day" : "days"; 
    case "h": return singular ? "hour" : "hours"; 
    case "min": return singular ? "minute" : "minutes"; 
    case "mo": return singular ? "month" : "months"; 
    case "s": return singular ? "second" : "seconds"; 
    case "wk": return singular ? "week" : "weeks"; 
    default: return "?"+units+"?"; 
    } 
  } 

  protected void renderTiming(RenderingStatus status, XhtmlNode x, ResourceWrapper s) throws FHIRException { 
    x.addText(displayTiming(s)); 
  } 


  private String displaySampledData(ResourceWrapper s) { 
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(); 
    if (s.has("origin")) 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_ORIGIN, displayQuantity(s.child("origin"))) + " "); 

    if (s.has("interval")) { 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_INT, s.primitiveValue("interval")) + " "); 

      if (s.has("intervalUnit")) 
        b.append(s.primitiveValue("intervalUnit")); 
    } 

    if (s.has("factor")) 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_FACT, s.primitiveValue("factor")) + " "); 

    if (s.has("lowerLimit")) 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_LOWER, s.primitiveValue("lowerLimit")) + " "); 

    if (s.has("upperLimit")) 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_UP, s.primitiveValue("upperLimit")) + " "); 

    if (s.has("dimensions")) 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_DIM, s.primitiveValue("dimensions")) + " "); 

    if (s.has("data")) 
      b.append(context.formatPhrase(RenderingContext.DATA_REND_DATA, s.primitiveValue("data")) + " "); 

    return b.toString(); 
  } 

  protected void renderSampledData(RenderingStatus status, XhtmlNode x, ResourceWrapper sampledData) { 
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

  protected String systemFromCanonical(String system) { 
    if (system == null) { 
      return null; 
    } else if (system.contains("|")) { 
      return system.substring(0, system.indexOf("|")); 
    } else { 
      return null; 
    } 
  } 

  protected String versionFromCanonical(String system) { 
    if (system == null) { 
      return null; 
    } else if (system.contains("|")) { 
      return system.substring(system.indexOf("|")+1); 
    } else { 
      return system; 
    } 
  } 


  /**
   * when we run into an unknown (canonical) URL, we assume that it's a pointer to something we don't 
   * know about, and render it as an 'a href=' in case it is valid. But in the 'known' domains, where 
   * we reasonably expect to know everything , we don't make them links 
   * @return
   */
  protected boolean isInKnownUrlSpace(String url) {
    return Utilities.startsWithInList(url, 
        "http://hl7.org/fhir",  "http://fhir.org/guides",  "http://ihe.net/fhir",  "http://terminology.hl7.org", 
        "https://hl7.org/fhir", "https://fhir.org/guides", "https://ihe.net/fhir", "https://terminology.hl7.org", 
        "http://www.hl7.org/fhir",  "http://www.fhir.org/guides",  "http://www.ihe.net/fhir",
        "https://www.hl7.org/fhir", "https://www.fhir.org/guides", "https://www.ihe.net/fhir"
       );
  }

  public String displayDosage(ResourceWrapper dosage) {
    String txt = dosage.primitiveValue("text");
    String details = null;
    if (VersionUtilities.isR6Plus(context.getContext().getVersion())) {
      details = displayDosageR6(dosage);
    } else if (VersionUtilities.isR5Plus(context.getContext().getVersion())) {
      details = displayDosageR5(dosage);
    } else if (VersionUtilities.isR4Plus(context.getContext().getVersion())) {
      details = displayDosageR4(dosage);
    } else {
      details = displayDosageR3(dosage);
    }
    if (txt == null && details == null) {
      return "";
    } else if (txt == null ) {
      return txt;
    } else if (details == null) {
      return details;
    } else {
      return txt+" (details: "+details + ")";
    }
  }

  public void renderDosage(ResourceWrapper dosage, XhtmlNode x) {
    if (VersionUtilities.isR6Plus(context.getContext().getVersion())) {
      renderDosageR6(dosage, x);
    } else if (VersionUtilities.isR5Plus(context.getContext().getVersion())) {
      renderDosageR6(dosage, x);
    } else if (VersionUtilities.isR4Plus(context.getContext().getVersion())) {
      renderDosageR6(dosage, x);
    } else {
      renderDosageR6(dosage, x);
    }
  }

  public String displayDosageR3(ResourceWrapper dosage) {
    return null;
  }

  public void renderDosageR3(ResourceWrapper dosage, XhtmlNode x) {
  }
  public String displayDosageR4(ResourceWrapper dosage) {
    return null;

  }

  public void renderDosageR4(ResourceWrapper dosage, XhtmlNode x) {

  }
  public String displayDosageR5(ResourceWrapper dosage) {
    return null;

  }

  public void renderDosageR5(ResourceWrapper dosage, XhtmlNode x) {

  }
  public String displayDosageR6(ResourceWrapper dosage) {
    return null;

  }

  public void renderDosageR6(ResourceWrapper dosage, XhtmlNode x) {

  }

}