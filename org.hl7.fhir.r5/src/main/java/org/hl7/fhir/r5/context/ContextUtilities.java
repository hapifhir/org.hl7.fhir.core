package org.hl7.fhir.r5.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.OIDUtils;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

public class ContextUtilities implements ProfileKnowledgeProvider {

  private IWorkerContext context;
  private boolean suppressDebugMessages;
  private XVerExtensionManager xverManager;
  private Map<String, String> oidCache = new HashMap<>();
  private List<StructureDefinition> allStructuresList = new ArrayList<StructureDefinition>();
  private List<String> canonicalResourceNames;
  private List<String> concreteResourceNames;
  
  public ContextUtilities(IWorkerContext context) {
    super();
    this.context = context;
  }

  public boolean isSuppressDebugMessages() {
    return suppressDebugMessages;
  }

  public void setSuppressDebugMessages(boolean suppressDebugMessages) {
    this.suppressDebugMessages = suppressDebugMessages;
  }
  
  public String oid2Uri(String oid) {
    if (oid != null && oid.startsWith("urn:oid:")) {
      oid = oid.substring(8);
    }
    if (oidCache.containsKey(oid)) {
      return oidCache.get(oid);
    }

    String uri = OIDUtils.getUriForOid(oid);
    if (uri != null) {
      oidCache.put(oid, uri);
      return uri;
    }
    CodeSystem cs = context.fetchCodeSystem("http://terminology.hl7.org/CodeSystem/v2-tables");
    if (cs != null) {
      for (ConceptDefinitionComponent cc : cs.getConcept()) {
        for (ConceptPropertyComponent cp : cc.getProperty()) {
          if (Utilities.existsInList(cp.getCode(), "v2-table-oid", "v2-cs-oid") && oid.equals(cp.getValue().primitiveValue())) {
            for (ConceptPropertyComponent cp2 : cc.getProperty()) {
              if ("v2-cs-uri".equals(cp2.getCode())) {
                oidCache.put(oid, cp2.getValue().primitiveValue());
                return cp2.getValue().primitiveValue();                  
              }
            }              
          }
        }
      }
    }
    for (CodeSystem css : context.fetchResourcesByType(CodeSystem.class)) {
      if (("urn:oid:"+oid).equals(css.getUrl())) {
        oidCache.put(oid, css.getUrl());
        return css.getUrl();
      }
      for (Identifier id : css.getIdentifier()) {
        if ("urn:ietf:rfc:3986".equals(id.getSystem()) && ("urn:oid:"+oid).equals(id.getValue())) {
          oidCache.put(oid, css.getUrl());
          return css.getUrl();
        }
      }
    }
    for (NamingSystem ns : context.fetchResourcesByType(NamingSystem.class)) {
      if (hasOid(ns, oid)) {
        uri = getUri(ns);
        if (uri != null) {
          oidCache.put(oid, null);
          return null;
        }
      }
    }
    oidCache.put(oid, null);
    return null;
  }    

  private String getUri(NamingSystem ns) {
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      if (id.getType() == NamingSystemIdentifierType.URI)
        return id.getValue();
    }
    return null;
  }

  private boolean hasOid(NamingSystem ns, String oid) {
    for (NamingSystemUniqueIdComponent id : ns.getUniqueId()) {
      if (id.getType() == NamingSystemIdentifierType.OID && id.getValue().equals(oid))
        return true;
    }
    return false;
  }

  /**
   * @return a list of the resource and type names defined for this version
   */
  public List<String> getTypeNames() {
    Set<String> result = new HashSet<String>();
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getKind() != StructureDefinitionKind.LOGICAL && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION)
        result.add(sd.getName());
    }
    return Utilities.sorted(result);
  }


  /**
   * @return a set of the resource and type names defined for this version
   */
  public Set<String> getTypeNameSet() {
    Set<String> result = new HashSet<String>();
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getKind() != StructureDefinitionKind.LOGICAL && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && 
          VersionUtilities.versionsCompatible(context.getVersion(), sd.getFhirVersion().toCode())) {
        result.add(sd.getName());
      }
    }
    return result;
  }

  public String getLinkForUrl(String corePath, String url) {
    if (url == null) {
      return null;
    }
    
    if (context.hasResource(CanonicalResource.class, url)) {
      CanonicalResource  cr = context.fetchResource(CanonicalResource.class, url);
      return cr.getWebPath();
    }
    return null;
  }
  

  protected String tail(String url) {
    if (Utilities.noString(url)) {
      return "noname";
    }
    if (url.contains("/")) {
      return url.substring(url.lastIndexOf("/")+1);
    }
    return url;
  }
  
  private boolean hasUrlProperty(StructureDefinition sd) {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (ed.getPath().equals(sd.getType()+".url")) {
        return true;
      }
    }
    return false;
  }
  
  // -- profile services ---------------------------------------------------------
  

  /**
   * @return a list of the resource names that are canonical resources defined for this version
   */
  public List<String> getCanonicalResourceNames() {
    if (canonicalResourceNames == null) {
      canonicalResourceNames =  new ArrayList<>();
      Set<String> names = new HashSet<>();
      for (StructureDefinition sd : allStructures()) {
        if (sd.getKind() == StructureDefinitionKind.RESOURCE && !sd.getAbstract() && hasUrlProperty(sd)) {
          names.add(sd.getType());
        }
      }
      canonicalResourceNames.addAll(Utilities.sorted(names));
    }
    return canonicalResourceNames;
  }

  /**
   * @return a list of all structure definitions, with snapshots generated (if possible)
   */
  public List<StructureDefinition> allStructures(){
    if (allStructuresList.isEmpty()) {
      Set<StructureDefinition> set = new HashSet<StructureDefinition>();
      for (StructureDefinition sd : getStructures()) {
        if (!set.contains(sd)) {
          try {
            generateSnapshot(sd);
            // new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "snapshot", tail(sd.getUrl())+".xml")), sd);
          } catch (Exception e) {
            if (!isSuppressDebugMessages()) {
              System.out.println("Unable to generate snapshot @2 for "+tail(sd.getUrl()) +" from "+tail(sd.getBaseDefinition())+" because "+e.getMessage());
              if (context.getLogger() != null && context.getLogger().isDebugLogging()) {
                e.printStackTrace();
              }
            }
          }
          allStructuresList.add(sd);
          set.add(sd);
        }
      }
    }
    return allStructuresList;
  }

  /**
   * @return a list of all structure definitions, without trying to generate snapshots
   */
  public List<StructureDefinition> getStructures() {
    return context.fetchResourcesByType(StructureDefinition.class);
  }
    
  /**
   * Given a structure definition, generate a snapshot (or regenerate it)
   * @param p
   * @throws DefinitionException
   * @throws FHIRException
   */
  public void generateSnapshot(StructureDefinition p) throws DefinitionException, FHIRException {
    generateSnapshot(p, false);
  }
  
  public void generateSnapshot(StructureDefinition p, boolean ifLogical) {
    if ((!p.hasSnapshot() || isProfileNeedsRegenerate(p) ) && (ifLogical || p.getKind() != StructureDefinitionKind.LOGICAL)) {
      if (!p.hasBaseDefinition())
        throw new DefinitionException(context.formatMessage(I18nConstants.PROFILE___HAS_NO_BASE_AND_NO_SNAPSHOT, p.getName(), p.getUrl()));
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, p.getBaseDefinition(), p);
      if (sd == null && "http://hl7.org/fhir/StructureDefinition/Base".equals(p.getBaseDefinition())) {
        sd = ProfileUtilities.makeBaseDefinition(p.getFhirVersion());
      }
      if (sd == null) {
        throw new DefinitionException(context.formatMessage(I18nConstants.PROFILE___BASE__COULD_NOT_BE_RESOLVED, p.getName(), p.getUrl(), p.getBaseDefinition()));
      }
      List<ValidationMessage> msgs = new ArrayList<ValidationMessage>();
      List<String> errors = new ArrayList<String>();
      ProfileUtilities pu = new ProfileUtilities(context, msgs, this);
      pu.setAutoFixSliceNames(true);
      pu.setThrowException(false);
      pu.setForPublication(context.isForPublication());
      if (xverManager == null) {
        xverManager = new XVerExtensionManager(context);
      }
      pu.setXver(xverManager);
      if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
        pu.sortDifferential(sd, p, p.getUrl(), errors, true);
      }
      pu.setDebug(false);
      for (String err : errors) {
        msgs.add(new ValidationMessage(Source.ProfileValidator, IssueType.EXCEPTION, p.getWebPath(), "Error sorting Differential: "+err, ValidationMessage.IssueSeverity.ERROR));
      }
      pu.generateSnapshot(sd, p, p.getUrl(), sd.getUserString("webroot"), p.getName());
      for (ValidationMessage msg : msgs) {
        if ((!ProfileUtilities.isSuppressIgnorableExceptions() && msg.getLevel() == ValidationMessage.IssueSeverity.ERROR) || msg.getLevel() == ValidationMessage.IssueSeverity.FATAL) {
          if (!msg.isIgnorableError()) {
            throw new DefinitionException(context.formatMessage(I18nConstants.PROFILE___ELEMENT__ERROR_GENERATING_SNAPSHOT_, p.getName(), p.getUrl(), msg.getLocation(), msg.getMessage()));
          } else {
            System.err.println(msg.getMessage());
          }
        }
      }
      if (!p.hasSnapshot())
        throw new FHIRException(context.formatMessage(I18nConstants.PROFILE___ERROR_GENERATING_SNAPSHOT, p.getName(), p.getUrl()));
      pu = null;
    }
    p.setGeneratedSnapshot(true);
  }
  

  // work around the fact that some Implementation guides were published with old snapshot generators that left invalid snapshots behind.
  private boolean isProfileNeedsRegenerate(StructureDefinition p) {
    boolean needs = !p.hasUserData("hack.regnerated") && Utilities.existsInList(p.getUrl(), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaireresponse");
    if (needs) {
      p.setUserData("hack.regnerated", "yes");
    }
    return needs;
  }

  @Override
  public boolean isPrimitiveType(String type) {
    return context.isPrimitiveType(type);
  }

  @Override
  public boolean isDatatype(String type) {
    StructureDefinition sd = context.fetchTypeDefinition(type);
    return sd != null && (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE || sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION;
  }

  @Override
  public boolean isResource(String t) {
    StructureDefinition sd;
    try {
      sd = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/"+t);
    } catch (Exception e) {
      return false;
    }
    if (sd == null)
      return false;
    if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT)
      return false;
    return sd.getKind() == StructureDefinitionKind.RESOURCE;
  }

  @Override
  public boolean hasLinkFor(String typeSimple) {
    return false;
  }

  @Override
  public String getLinkFor(String corePath, String typeSimple) {
    return null;
  }

  @Override
  public BindingResolution resolveBinding(StructureDefinition profile, ElementDefinitionBindingComponent binding, String path) {
    return null;
  }

  @Override
  public BindingResolution resolveBinding(StructureDefinition profile, String url, String path) {
    return null;
  }

  @Override
  public String getLinkForProfile(StructureDefinition profile, String url) {
    return null;
  }
  @Override
  public boolean prependLinks() {
    return false;
  }

  public StructureDefinition fetchByJsonName(String key) {
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      ElementDefinition ed = sd.getSnapshot().getElementFirstRep();
      if (sd.getKind() == StructureDefinitionKind.LOGICAL && ed != null && ed.hasExtension(ToolingExtensions.EXT_JSON_NAME) && 
          key.equals(ToolingExtensions.readStringExtension(ed, ToolingExtensions.EXT_JSON_NAME))) {
        return sd;
      }
    }
    return null;
  }

  public List<String>  getConcreteResources() {
    if (concreteResourceNames == null) {
      concreteResourceNames =  new ArrayList<>();
      Set<String> names = new HashSet<>();
      for (StructureDefinition sd : allStructures()) {
        if (sd.getKind() == StructureDefinitionKind.RESOURCE && !sd.getAbstract()) {
          names.add(sd.getType());
        }
      }
      concreteResourceNames.addAll(Utilities.sorted(names));
    }
    return concreteResourceNames;
  }

  public List<StructureMap> listMaps(String url) {
    List<StructureMap> res = new ArrayList<>();
    String start = url.substring(0, url.indexOf("*"));
    String end = url.substring(url.indexOf("*")+1);
    for (StructureMap map : context.fetchResourcesByType(StructureMap.class)) {
      String u = map.getUrl();
      if (u.startsWith(start) && u.endsWith(end)) {
        res.add(map);
      }
    }
    return res;
  }

  public List<String> fetchCodeSystemVersions(String system) {
    List<String> res = new ArrayList<>();
    for (CodeSystem cs : context.fetchResourcesByType(CodeSystem.class)) {
      if (system.equals(cs.getUrl()) && cs.hasVersion()) {
        res.add(cs.getVersion());
      }
    }
    return res;
  }

  public StructureDefinition findType(String typeName) {
    StructureDefinition t = context.fetchTypeDefinition(typeName);
    if (t != null) {
      return t;
    }
    List<StructureDefinition> candidates = new ArrayList<>();
    for (StructureDefinition sd : getStructures()) {
      if (sd.getType().equals(typeName)) {
        candidates.add(sd);
      }
    }
    if (candidates.size() == 1) {
      return candidates.get(0);
    }
    return null;
  }

}

