package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CanonicalPair;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
@Slf4j
public abstract class TerminologyRenderer extends ResourceRenderer {
  


  public TerminologyRenderer(RenderingContext context) {
    super(context);
  }

  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((CanonicalResource) r).present();
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


  protected XhtmlNode addMapHeaders(XhtmlNode tr, List<UsedConceptMap> maps) throws FHIRFormatError, DefinitionException, IOException {
    for (UsedConceptMap m : maps) {
      XhtmlNode td = tr.td();
      XhtmlNode b = td.b();
      String link = m.getLink();
      XhtmlNode a = b.ah(context.prefixLocalHref(link));
      a.addText(m.getDetails().getName());
      if (m.getDetails().isDoDescription() && m.getMap().hasDescription())
        addMarkdown(td, m.getMap().getDescription());
    }
    return tr;
  }

  protected String getHeader() {
    int i = 3;
    while (i <= getContext().getHeaderLevelContext())
      i++;
    if (i > 6)
      i = 6;
    return "h"+Integer.toString(i);
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
    case SOURCEISNARROWERTHANTARGET : return "<";
    case SOURCEISBROADERTHANTARGET : return ">";
    case NOTRELATEDTO : return "!=";
    default: return "?";
    }
  }

  protected void addCsRef(ConceptSetComponent inc, XhtmlNode li, CodeSystem cs) {
    String ref = null;
    boolean addHtml = true;
    if (cs != null) {
      ref = (String) cs.getUserData(UserDataNames.render_external_link);
      if (Utilities.noString(ref))
        ref = (String) cs.getUserData(UserDataNames.render_filename);
      else
        addHtml = false;
      if (Utilities.noString(ref)) {
        ref = (String) cs.getWebPath();
        if (ref != null) {
          addHtml = false;
        }
      }
    }
    String spec = getSpecialReference(inc.getSystem());
    if (spec != null) {
      XhtmlNode a = li.ah(context.prefixLocalHref(spec));
      a.code(inc.getSystem());
    } else if (cs != null && ref != null) {
      if (addHtml && !ref.contains(".html"))
        ref = ref + ".html";
      ref = context.fixReference(ref);
      XhtmlNode a = li.ah(context.prefixLocalHref(ref.replace("\\", "/")));
      a.code(inc.getSystem());
    } else {
      li.code(inc.getSystem());
    }

    XhtmlNode span = li.span();
    span.addText(" "+ context.formatPhrase(RenderingContext.GENERAL_VER_LOW) + " ");

    if (cs != null && cs.getContent() == Enumerations.CodeSystemContentMode.NOTPRESENT) {
      cs = null;
    }
    String statedVersion = inc.getVersion();
    String actualVersion = cs == null ? null : cs.getVersion();
    boolean fromPackages = cs == null ? false : cs.hasSourcePackage();
    boolean fromThisPackage = cs == null ? false : !Utilities.isAbsoluteUrlLinkable(cs.getWebPath());
    renderVersionReference(context, cs, statedVersion, actualVersion, fromPackages, span, fromThisPackage, context.formatPhrase(RenderingContext.GENERAL_CODESYSTEM), RenderingI18nContext.CS_VERSION_NOTHING_TEXT);
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

  protected XhtmlNode addTableHeaderRowStandard(XhtmlNode t, boolean hasHierarchy, boolean hasDisplay, boolean definitions, boolean comments, boolean version, boolean deprecated, List<PropertyComponent> properties, List<String> langs, Map<String, String> designations, boolean doDesignations) {
    XhtmlNode tr = t.tr();
    if (hasHierarchy) {
      tr.td().b().tx(context.formatPhrase(RenderingContext.TERMINOLOGY_LVL));
    }
    tr.td().attribute("style", "white-space:nowrap").b().tx(formatPhrase(RenderingContext.GENERAL_CODE));
    if (hasDisplay) {
      tr.td().b().tx(formatPhrase(RenderingContext.TX_DISPLAY));
    }
    if (definitions) {
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_DEFINITION));
    }
    if (deprecated) {
      tr.td().b().tx(formatPhrase(RenderingContext.CODESYSTEM_DEPRECATED));
    }
    if (comments) {
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_COMMENTS));
    }
    if (version) {
      tr.td().b().tx(formatPhrase(RenderingContext.GENERAL_VER));
    }
    if (properties != null) {
      for (PropertyComponent pc : properties) {
        String display = getDisplayForProperty(pc);
        tr.td().b().tx(display);      
      }
    }
    if (doDesignations) {
      if (designations != null) {
        for (String url : designations.keySet()) {
          tr.td().b().addText(designations.get(url));
        }
      }
      if (langs != null) {
        for (String lang : langs) {
          tr.td().b().addText(describeLang(lang));
        }
      }
    }
    return tr;
  }

  protected String getDisplayForProperty(PropertyComponent pc) {
    String display = ExtensionUtilities.getPresentation(pc, pc.getCodeElement());
    if (display == null || display.equals(pc.getCode()) && pc.hasUri()) {
      display = getDisplayForProperty(pc.getUri());
      if (display == null) {
        display = pc.getCode();
      }
    }
    return display;
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
    CodeSystem cs = getContext().getWorker().fetchCodeSystem(uri);
    if (cs == null) {
      return null;
    }
    ConceptDefinitionComponent cc = code == null ? null : CodeSystemUtilities.getCode(cs, code);
    return cc == null ? null : cc.getDisplay();
  }


  protected void AddVsRef(String value, XhtmlNode li, Resource source) {
    Resource res = null;
    if (res != null && !(res instanceof CanonicalResource)) {
      li.addText(value);
      return;      
    }      
    CanonicalResource vs = (CanonicalResource) res;
    if (vs == null)
      vs = getContext().getWorker().findTxResource(ValueSet.class, value, null, source);
    if (vs == null)
      vs = getContext().getWorker().fetchResource(StructureDefinition.class, value, null, source);
    if (vs == null)
      vs = getContext().getWorker().fetchResource(Questionnaire.class, value, null, source);
    if (vs != null) {
      String ref = (String) vs.getWebPath();

      if (ref == null) {
        li.tx(vs.present());
      } else {
        ref = context.fixReference(ref);
        XhtmlNode a = li.ah(context.prefixLocalHref(ref.replace("\\", "/")));
        a.addText(vs.present());
      }
    } else {
      CodeSystem cs = getContext().getWorker().fetchCodeSystem(value);
      if (cs != null) {
        String ref = (String) cs.getWebPath();
        ref = context.fixReference(ref);
        XhtmlNode a = li.ah(context.prefixLocalHref(ref == null ? "?ngen-12?" : ref.replace("\\", "/")));
        a.addText(value);
      } else if (value.equals("http://snomed.info/sct") || value.equals("http://snomed.info/id")) {
        XhtmlNode a = li.ah(context.prefixLocalHref(value));
        a.tx(context.formatPhrase(RenderingContext.STRUC_DEF_SNOMED));
      }
      else {
        if (value.startsWith("http://hl7.org") && !Utilities.existsInList(value, "http://hl7.org/fhir/sid/icd-10-us")) {
          log.debug("Unable to resolve value set "+value);
        }
        li.addText(value);
      }
    }
  }

  protected String getDisplayForConcept(String canonical, String value) {
    var split = CanonicalPair.of(canonical);
    return getDisplayForConcept(split.getUrl(), split.getVersion(), value);
  }
  
  protected String getDisplayForConcept(String system, String version, String value) {
    if (value == null || system == null)
      return null;
    ValidationResult cl = getContext().getWorker().validateCode(getContext().getTerminologyServiceOptions().withVersionFlexible(true), system, version, value, null);
    return cl == null ? null : cl.getDisplay();
  }


  protected void clipboard(XhtmlNode x, String img, String title, String source) {
    XhtmlNode span = x.span("cursor: pointer", formatPhrase(RenderingContext.TERM_REND_COPY, title));
    span.attribute("onClick", "navigator.clipboard.writeText('"+Utilities.escapeJson(source)+"');");
    span.img(img, "btn").setAttribute("width", "24px").setAttribute("height", "16px");
  }
  

  
}