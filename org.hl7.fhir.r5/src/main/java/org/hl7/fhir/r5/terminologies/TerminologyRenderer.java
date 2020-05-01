package org.hl7.fhir.r5.terminologies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.TerminologyServiceException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.NarrativeGenerator.ResourceContext;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class TerminologyRenderer {

  public enum TerminologyRendererMode {
    RESOURCE, IG
  }

  protected class TargetElementComponentWrapper {
    protected ConceptMapGroupComponent group;
    protected TargetElementComponent comp;
    protected TargetElementComponentWrapper(ConceptMapGroupComponent group, TargetElementComponent comp) {
      super();
      this.group = group;
      this.comp = comp;
    }

  }

  public class UsedConceptMap {

    private ConceptMapRenderInstructions details;
    private String link;
    private ConceptMap map;
    public UsedConceptMap(ConceptMapRenderInstructions details, String link, ConceptMap map) {
      super();
      this.details = details;
      this.link = link;
      this.map = map;
    }
    public ConceptMapRenderInstructions getDetails() {
      return details;
    }
    public ConceptMap getMap() {
      return map;
    }
    public String getLink() {
      return link;
    }    
  }

  public class ConceptMapRenderInstructions {
    private String name;
    private String url;
    private boolean doDescription;
    public ConceptMapRenderInstructions(String name, String url, boolean doDescription) {
      super();
      this.name = name;
      this.url = url;
      this.doDescription = doDescription;
    }
    public String getName() {
      return name;
    }
    public String getUrl() {
      return url;
    }
    public boolean isDoDescription() {
      return doDescription;
    }

  }

  protected TerminologyRendererMode mode;
  protected IWorkerContext context;
  protected MarkDownProcessor markdown;
  protected String lang;
  protected String prefix;
  protected int headerLevelContext;
  protected ValidationOptions terminologyServiceOptions = new ValidationOptions();
  protected boolean noSlowLookup;

  /**
   * 
   * @param mode - whether we are rendering for a resource directly, or for an IG
   * @param context - common services (terminology server, code system cache etc)
   * @param markdown - markdown processing engine of the correct sort for the version applicable 
   * @param prefix - the path to the base FHIR specification
   * @param lang - the language to use (null for the default)
   */
  public TerminologyRenderer(TerminologyRendererMode mode, IWorkerContext context, MarkDownProcessor markdown, String prefix, String lang) {
    super();
    this.mode = mode;
    this.context = context;
    this.markdown = markdown;
    this.lang = lang;
    this.prefix = prefix;
  }

  public TerminologyRendererMode getMode() {
    return mode;
  }

  public int getHeaderLevelContext() {
    return headerLevelContext;
  }

  public void setHeaderLevelContext(int headerLevelContext) {
    this.headerLevelContext = headerLevelContext;
  }

  public ValidationOptions getTerminologyServiceOptions() {
    return terminologyServiceOptions;
  }

  public void setTerminologyServiceOptions(ValidationOptions terminologyServiceOptions) {
    this.terminologyServiceOptions = terminologyServiceOptions;
  }

  
  
  public boolean isNoSlowLookup() {
    return noSlowLookup;
  }

  public void setNoSlowLookup(boolean noSlowLookup) {
    this.noSlowLookup = noSlowLookup;
  }

  protected void addMarkdown(XhtmlNode x, String text) throws FHIRFormatError, IOException, DefinitionException {
    if (text != null) {
      // 1. custom FHIR extensions
      while (text.contains("[[[")) {
        String left = text.substring(0, text.indexOf("[[["));
        String link = text.substring(text.indexOf("[[[")+3, text.indexOf("]]]"));
        String right = text.substring(text.indexOf("]]]")+3);
        String url = link;
        String[] parts = link.split("\\#");
        StructureDefinition p = context.fetchResource(StructureDefinition.class, parts[0]);
        if (p == null)
          p = context.fetchTypeDefinition(parts[0]);
        if (p == null)
          p = context.fetchResource(StructureDefinition.class, link);
        if (p != null) {
          url = p.getUserString("path");
          if (url == null)
            url = p.getUserString("filename");
        } else
          throw new DefinitionException("Unable to resolve markdown link "+link);

        text = left+"["+link+"]("+url+")"+right;
      }

      // 2. markdown
      String s = markdown.process(Utilities.escapeXml(text), "narrative generator");
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

  protected void generateCopyright(XhtmlNode x, CanonicalResource cs) {
    XhtmlNode p = x.para();
    p.b().tx(context.translator().translate("xhtml-gen-cs", "Copyright Statement:", lang));
    smartAddText(p, " " + cs.getCopyright());
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

  protected void addMapHeaders(XhtmlNode tr, List<UsedConceptMap> maps) throws FHIRFormatError, DefinitionException, IOException {
    for (UsedConceptMap m : maps) {
      XhtmlNode td = tr.td();
      XhtmlNode b = td.b();
      XhtmlNode a = b.ah(prefix+m.getLink());
      a.addText(m.getDetails().getName());
      if (m.getDetails().isDoDescription() && m.getMap().hasDescription())
        addMarkdown(td, m.getMap().getDescription());
    }
  }

  protected String getHeader() {
    int i = 3;
    while (i <= headerLevelContext)
      i++;
    if (i > 6)
      i = 6;
    return "h"+Integer.toString(i);
  }

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

  protected List<TargetElementComponentWrapper> findMappingsForCode(String code, ConceptMap map) {
    List<TargetElementComponentWrapper> mappings = new ArrayList<TargetElementComponentWrapper>();

    for (ConceptMapGroupComponent g : map.getGroup()) {
      for (SourceElementComponent c : g.getElement()) {
        if (c.getCode().equals(code))
          for (TargetElementComponent cc : c.getTarget())
            mappings.add(new TargetElementComponentWrapper(g, cc));
      }
    }
    return mappings;
  }



  protected String getCharForRelationship(TargetElementComponent mapping) {
    if (!mapping.hasRelationship())
      return "";
    switch (mapping.getRelationship()) {
    case EQUIVALENT : return "~";
    case SOURCENARROWERTARGET : return "<";
    case SOURCEBROADERTARGET : return ">";
    case NOTRELATEDTO : return "!=";
    default: return "?";
    }
  }

  protected <T extends Resource> void addCsRef(ConceptSetComponent inc, XhtmlNode li, T cs) {
    String ref = null;
    boolean addHtml = true;
    if (cs != null) {
      ref = (String) cs.getUserData("external.url");
      if (Utilities.noString(ref))
        ref = (String) cs.getUserData("filename");
      else
        addHtml = false;
      if (Utilities.noString(ref))
        ref = (String) cs.getUserData("path");
    }
    String spec = getSpecialReference(inc.getSystem());
    if (spec != null) {
      XhtmlNode a = li.ah(spec);
      a.code(inc.getSystem());
    } else if (cs != null && ref != null) {
      if (!Utilities.noString(prefix) && ref.startsWith("http://hl7.org/fhir/"))
        ref = ref.substring(20)+"/index.html";
      else if (addHtml && !ref.contains(".html"))
        ref = ref + ".html";
      XhtmlNode a = li.ah(prefix+ref.replace("\\", "/"));
      a.code(inc.getSystem());
    } else {
      li.code(inc.getSystem());
    }
  }


  private String getSpecialReference(String system) {
    if ("http://snomed.info/sct".equals(system))
      return "http://www.snomed.org/";
    if (Utilities.existsInList(system, "http://loinc.org", "http://unitsofmeasure.org", "http://www.nlm.nih.gov/research/umls/rxnorm", "http://ncimeta.nci.nih.gov", "http://fdasis.nlm.nih.gov", 
        "http://www.radlex.org", "http://www.whocc.no/atc", "http://dicom.nema.org/resources/ontology/DCM", "http://www.genenames.org", "http://www.ensembl.org", "http://www.ncbi.nlm.nih.gov/nuccore", 
        "http://www.ncbi.nlm.nih.gov/clinvar", "http://sequenceontology.org", "http://www.hgvs.org/mutnomen", "http://www.ncbi.nlm.nih.gov/projects/SNP", "http://cancer.sanger.ac.uk/cancergenome/projects/cosmic", 
        "http://www.lrg-sequence.org", "http://www.omim.org", "http://www.ncbi.nlm.nih.gov/pubmed", "http://www.pharmgkb.org", "http://clinicaltrials.gov", "http://www.ebi.ac.uk/ipd/imgt/hla/")) 
      return system;

    return null;
  }

  protected XhtmlNode addTableHeaderRowStandard(XhtmlNode t, boolean hasHierarchy, boolean hasDisplay, boolean definitions, boolean comments, boolean version, boolean deprecated, List<PropertyComponent> properties) {
    XhtmlNode tr = t.tr();
    if (hasHierarchy)
      tr.td().b().tx("Lvl");
    tr.td().attribute("style", "white-space:nowrap").b().tx(context.translator().translate("xhtml-gen-cs", "Code", lang));
    if (hasDisplay)
      tr.td().b().tx(context.translator().translate("xhtml-gen-cs", "Display", lang));
    if (definitions)
      tr.td().b().tx(context.translator().translate("xhtml-gen-cs", "Definition", lang));
    if (deprecated)
      tr.td().b().tx(context.translator().translate("xhtml-gen-cs", "Deprecated", lang));
    if (comments)
      tr.td().b().tx(context.translator().translate("xhtml-gen-cs", "Comments", lang));
    if (version)
      tr.td().b().tx(context.translator().translate("xhtml-gen-cs", "Version", lang));
    if (properties != null) {
      for (PropertyComponent pc : properties) {
        String display = ToolingExtensions.getPresentation(pc, pc.getCodeElement());
        if (display == null || display.equals(pc.getCode()) && pc.hasUri()) {
          display = getDisplayForProperty(pc.getUri());
          if (display == null) {
            display = pc.getCode();
          }
        }
        tr.td().b().tx(context.translator().translate("xhtml-gen-cs", display, lang));      
      }
    }
    return tr;
  }


  protected String getDisplayForProperty(String uri) {
    if (Utilities.noString(uri)){
      return null;
    }
    String code = null;
    if (uri.contains("#")) {
      code = uri.substring(uri.indexOf("#")+1);
      uri = uri.substring(0, uri.indexOf("#"));
    }
    CodeSystem cs = context.fetchCodeSystem(uri);
    if (cs == null) {
      return null;
    }
    ConceptDefinitionComponent cc = CodeSystemUtilities.getCode(cs, code);
    return cc == null ? null : cc.getDisplay();
  }


  protected void AddVsRef(ResourceContext rcontext, String value, XhtmlNode li) {
    Resource res = null;
    if (rcontext != null) {
      BundleEntryComponent be = rcontext.resolve(value);
      if (be != null) {
        res = be.getResource(); 
      }
    }
    if (res != null && !(res instanceof CanonicalResource)) {
      li.addText(value);
      return;      
    }      
    CanonicalResource vs = (CanonicalResource) res;
    if (vs == null)
      vs = context.fetchResource(ValueSet.class, value);
    if (vs == null)
      vs = context.fetchResource(StructureDefinition.class, value);
    //    if (vs == null)
    //      vs = context.fetchResource(DataElement.class, value);
    if (vs == null)
      vs = context.fetchResource(Questionnaire.class, value);
    if (vs != null) {
      String ref = (String) vs.getUserData("path");

      ref = adjustForPath(ref);
      XhtmlNode a = li.ah(ref == null ? "?ngen-11?" : ref.replace("\\", "/"));
      a.addText(value);
    } else {
      CodeSystem cs = context.fetchCodeSystem(value);
      if (cs != null) {
        String ref = (String) cs.getUserData("path");
        ref = adjustForPath(ref);
        XhtmlNode a = li.ah(ref == null ? "?ngen-12?" : ref.replace("\\", "/"));
        a.addText(value);
      } else if (value.equals("http://snomed.info/sct") || value.equals("http://snomed.info/id")) {
        XhtmlNode a = li.ah(value);
        a.tx("SNOMED-CT");
      }
      else {
        if (value.startsWith("http://hl7.org") && !Utilities.existsInList(value, "http://hl7.org/fhir/sid/icd-10-us"))
          System.out.println("Unable to resolve value set "+value);
        li.addText(value);
      }
    }
  }

  private String adjustForPath(String ref) {
    if (prefix == null)
      return ref;
    else
      return prefix+ref;
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


  protected String getDisplayForConcept(String system, String value) {
    if (value == null || system == null)
      return null;
    ValidationResult cl = context.validateCode(terminologyServiceOptions, system, value, null);
    return cl == null ? null : cl.getDisplay();
  }



  protected String describeLang(String lang) {
    ValueSet v = context.fetchResource(ValueSet.class, "http://hl7.org/fhir/ValueSet/languages");
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
}
