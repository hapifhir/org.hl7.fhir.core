package org.hl7.fhir.r5.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;import lombok.Setter;import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType;
import org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.OIDUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class ContextUtilities implements ProfileKnowledgeProvider {

  private IWorkerContext context;
  private XVerExtensionManager xverManager;
  private Map<String, String> oidCache = new HashMap<>();
  private List<StructureDefinition> allStructuresList = new ArrayList<StructureDefinition>();
  private List<String> canonicalResourceNames;
  private List<String> concreteResourceNames;
  private Set<String> concreteResourceNameSet;
  @Setter private List<String> suppressedMappings;
  @Getter@Setter private Set<String> localFileNames;
  @Getter@Setter private Set<String> masterSourceNames;

  public ContextUtilities(IWorkerContext context) {
    super();
    this.context = context;
    this.suppressedMappings = new ArrayList<String>();
  }

  public ContextUtilities(IWorkerContext context, List<String> suppressedMappings) {
    super();
    this.context = context;
    this.suppressedMappings = suppressedMappings;
  }

  @Deprecated
  public boolean isSuppressDebugMessages() {
    return false;
  }

  @Deprecated
  public void setSuppressDebugMessages(boolean suppressDebugMessages) {
    //DO NOTHING
  }
  
  public String oid2Uri(String oid) {
    if (oid != null && oid.startsWith("urn:oid:")) {
      oid = oid.substring(8);
    }
    if (oidCache.containsKey(oid)) {
      return oidCache.get(oid);
    }

    String uri = OIDUtilities.getUriForOid(oid);
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
            // new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path("[tmp]", "snapshot", tail(sd.getUrl())+".xml")), sd);
          } catch (Exception e) {
            log.debug("Unable to generate snapshot @2 for "+tail(sd.getUrl()) +" from "+tail(sd.getBaseDefinition())+" because "+e.getMessage());
            context.getLogger().logDebugMessage(ILoggingService.LogCategory.GENERATE, ExceptionUtils.getStackTrace(e));
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
    if ((!p.hasSnapshot() || isProfileNeedsRegenerate(p))) {
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
      pu.setSuppressedMappings(suppressedMappings);
      pu.setLocalFileNames(localFileNames);
      pu.setMasterSourceFileNames(masterSourceNames);
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
      pu.generateSnapshot(sd, p, p.getUrl(), sd.getUserString(UserDataNames.render_webroot), p.getName());
      for (ValidationMessage msg : msgs) {
        if ((!ProfileUtilities.isSuppressIgnorableExceptions() && msg.getLevel() == ValidationMessage.IssueSeverity.ERROR) || msg.getLevel() == ValidationMessage.IssueSeverity.FATAL) {
          if (!msg.isIgnorableError()) {
            throw new DefinitionException(context.formatMessage(I18nConstants.PROFILE___ELEMENT__ERROR_GENERATING_SNAPSHOT_, p.getName(), p.getUrl(), msg.getLocation(), msg.getMessage()));
          } else {
            log.error(msg.getMessage());
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
    boolean needs = !p.hasUserData(UserDataNames.SNAPSHOT_regeneration_tracker) && Utilities.existsInList(p.getUrl(), "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaireresponse");
    if (needs) {
      p.setUserData(UserDataNames.SNAPSHOT_regeneration_tracker, "yes");
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
    if (getConcreteResourceSet().contains(t)) {
      return true;
    }
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
      if (/*sd.getKind() == StructureDefinitionKind.LOGICAL && */ 
          // this is turned off because it's valid to use a FHIR type directly in
          // an extension of this kind, and that can't be a logical model. Any profile on
          // a type is acceptable as long as it has the json name on it  
          ed != null && ed.hasExtension(ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED) &&
          key.equals(ExtensionUtilities.readStringExtension(ed, ExtensionDefinitions.EXT_JSON_NAME, ExtensionDefinitions.EXT_JSON_NAME_DEPRECATED))) {
        return sd;
      }
    }
    return null;
  }

  public Set<String> getConcreteResourceSet() {
    if (concreteResourceNameSet == null) {
      concreteResourceNameSet =  new HashSet<>();
      for (StructureDefinition sd : getStructures()) {
        if (sd.getKind() == StructureDefinitionKind.RESOURCE && !sd.getAbstract() && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
          concreteResourceNameSet.add(sd.getType());
        }
      }
    }
    return concreteResourceNameSet;
  }

  public List<String> getConcreteResources() {
    if (concreteResourceNames == null) {
      concreteResourceNames =  new ArrayList<>();
      concreteResourceNames.addAll(Utilities.sorted(getConcreteResourceSet()));
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
    for (CodeSystem cs : context.fetchResourceVersionsByTypeAndUrl(CodeSystem.class, system)) {
      if (cs.hasVersion()) {
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

  public StructureDefinition fetchProfileByIdentifier(String tid) {
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      for (Identifier ii : sd.getIdentifier()) {
        if (tid.equals(ii.getValue())) {
          return sd;
        }
      }
    }
    return null;
  }

  public boolean isAbstractType(String typeName) {
    StructureDefinition sd = context.fetchTypeDefinition(typeName);
    if (sd != null) {
      return sd.getAbstract();
    }
    return false;
  }

  public boolean isDomainResource(String typeName) {
    StructureDefinition sd = context.fetchTypeDefinition(typeName);
    while (sd != null) {
      if ("DomainResource".equals(sd.getType())) {
        return true;
      }
      sd = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());  
    }
    return false;
  }

  public IWorkerContext getWorker() {
    return context;     
  }

  @Override
  public String getCanonicalForDefaultContext() {
    // TODO Auto-generated method stub
    return null;
  }

  public String pinValueSet(String valueSet) {
    return pinValueSet(valueSet, context.getExpansionParameters());
  }

  public String pinValueSet(String value, Parameters expParams) {
    if (value.contains("|")) {
      return value;
    }
    for (ParametersParameterComponent p : expParams.getParameter()) {
      if ("default-valueset-version".equals(p.getName())) {
        String s = p.getValue().primitiveValue();
        if (s.startsWith(value+"|")) {
          return s;
        }
      }
    }
    return value;
  }

  public List<StructureDefinition> allBaseStructures() {
    List<StructureDefinition> res = new ArrayList<>();
    for (StructureDefinition sd : allStructures()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.LOGICAL) {
        res.add(sd);
      }
    }
    return res;
  }

  public <T extends Resource> List<T> fetchByIdentifier(Class<T> class_, String system) {
    List<T> list = new ArrayList<>();
    for (T t : context.fetchResourcesByType(class_)) {
      if (t instanceof CanonicalResource) {
        CanonicalResource cr = (CanonicalResource) t;
        for (Identifier id : cr.getIdentifier()) {
          if (system.equals(id.getValue())) {
            list.add(t);
          }
        }
      }
    }
    return list;
  }

  public StructureDefinition fetchStructureByName(String name) {
    StructureDefinition sd = null;
    for (StructureDefinition t : context.fetchResourcesByType(StructureDefinition.class)) {
      if (name.equals(t.getName())) {
        if (sd == null) {
          sd = t;
        } else {
          throw new FHIRException("Duplicate Structure name "+name+": found both "+t.getVersionedUrl()+" and "+sd.getVersionedUrl());
        }
      }
    }
    return sd;
  }

  @Override
  public String getDefinitionsName(Resource r) {
    // TODO Auto-generated method stub
    return null;
  }

  }

