package org.hl7.fhir.r5.context;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.context.IWorkerContext.ILoggingService.LogCategory;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.ParserType;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ResourceType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.utils.INarrativeGenerator;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.NarrativeGenerator;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

import ca.uhn.fhir.parser.DataFormatException;

/*
 * This is a stand alone implementation of worker context for use inside a tool.
 * It loads from the validation package (validation-min.xml.zip), and has a 
 * very light client to connect to an open unauthenticated terminology service
 */

public class SimpleWorkerContext extends BaseWorkerContext implements IWorkerContext, ProfileKnowledgeProvider {

  public interface ILoadFilter {

    boolean isOkToLoad(Resource resource);

  }

  public interface IValidatorFactory {
    IResourceValidator makeValidator(IWorkerContext ctxts) throws FHIRException;
  }

	private Questionnaire questionnaire;
  private String revision;
  private String date;
  private IValidatorFactory validatorFactory;
  private boolean ignoreProfileErrors;
  private boolean progress;
  private List<String> loadedPackages = new ArrayList<String>();
  
  public SimpleWorkerContext() throws FileNotFoundException, IOException, FHIRException {
    super();
  }

  public SimpleWorkerContext(Locale locale) throws FileNotFoundException, IOException, FHIRException {
    super(locale);
  }
  
  public SimpleWorkerContext(SimpleWorkerContext other) throws FileNotFoundException, IOException, FHIRException {
    super();
    copy(other);
  }

  public SimpleWorkerContext(SimpleWorkerContext other, Locale locale) throws FileNotFoundException, IOException, FHIRException {
    super(locale);
    copy(other);
  }
  
  protected void copy(SimpleWorkerContext other) {
    super.copy(other);
    questionnaire = other.questionnaire;
    binaries.putAll(other.binaries);
    version = other.version;
    revision = other.revision;
    date = other.date;
    validatorFactory = other.validatorFactory;
  }

  // -- Initializations
	/**
	 * Load the working context from the validation pack
	 * 
	 * @param path
	 *           filename of the validation pack
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws FHIRException 
	 * @throws Exception
	 */
  public static SimpleWorkerContext fromPack(String path) throws FileNotFoundException, IOException, FHIRException {
    SimpleWorkerContext res = new SimpleWorkerContext();
    res.loadFromPack(path, null);
    return res;
  }

  public static SimpleWorkerContext fromPackage(NpmPackage pi, boolean allowDuplicates) throws FileNotFoundException, IOException, FHIRException {
    return fromPackage(pi, allowDuplicates, null);
  }
  public static SimpleWorkerContext fromPackage(NpmPackage pi, boolean allowDuplicates, ILoadFilter filter) throws FileNotFoundException, IOException, FHIRException {
    SimpleWorkerContext res = new SimpleWorkerContext();
    res.setAllowLoadingDuplicates(allowDuplicates);
    res.loadFromPackage(pi, null, filter);
    return res;
  }

  public static SimpleWorkerContext fromPackage(NpmPackage pi) throws FileNotFoundException, IOException, FHIRException {
    SimpleWorkerContext res = new SimpleWorkerContext();
    res.loadFromPackage(pi, null);
    return res;
  }

  public static SimpleWorkerContext fromPackage(NpmPackage pi, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException {
    return fromPackage(pi, loader, null);  
  }
  
  public static SimpleWorkerContext fromPackage(NpmPackage pi, IContextResourceLoader loader, ILoadFilter filter) throws FileNotFoundException, IOException, FHIRException {
    SimpleWorkerContext res = new SimpleWorkerContext();
    res.setAllowLoadingDuplicates(true);
    res.version = pi.getNpm().get("version").getAsString();
    res.loadFromPackage(pi, loader, filter);
    res.finishLoading();
    return res;
  }

  public static SimpleWorkerContext fromPack(String path, boolean allowDuplicates) throws FileNotFoundException, IOException, FHIRException {
    SimpleWorkerContext res = new SimpleWorkerContext();
    res.setAllowLoadingDuplicates(allowDuplicates);
    res.loadFromPack(path, null);
    return res;
  }

  public static SimpleWorkerContext fromPack(String path, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException {
    SimpleWorkerContext res = new SimpleWorkerContext();
    res.loadFromPack(path, loader);
    return res;
  }

	public static SimpleWorkerContext fromClassPath() throws IOException, FHIRException {
		SimpleWorkerContext res = new SimpleWorkerContext();
		res.loadFromStream(SimpleWorkerContext.class.getResourceAsStream("validation.json.zip"), null);
		return res;
	}

	 public static SimpleWorkerContext fromClassPath(String name) throws IOException, FHIRException {
	   InputStream s = SimpleWorkerContext.class.getResourceAsStream("/"+name);
	    SimpleWorkerContext res = new SimpleWorkerContext();
	   res.loadFromStream(s, null);
	    return res;
	  }

//	public static SimpleWorkerContext fromDefinitions(Map<String, byte[]> source) throws IOException, FHIRException {
//		SimpleWorkerContext res = new SimpleWorkerContext();
//		for (String name : source.keySet()) {
//		  res.loadDefinitionItem(name, new ByteArrayInputStream(source.get(name)), null, null);
//		}
//		return res;
//	}

  public static SimpleWorkerContext fromDefinitions(Map<String, byte[]> source, IContextResourceLoader loader, PackageVersion pi) throws FileNotFoundException, IOException, FHIRException  {
    SimpleWorkerContext res = new SimpleWorkerContext();
    for (String name : source.keySet()) { 
      try {
        res.loadDefinitionItem(name, new ByteArrayInputStream(source.get(name)), loader, null, pi);
      } catch (Exception e) {
        System.out.println("Error loading "+name+": "+e.getMessage());
        throw new FHIRException("Error loading "+name+": "+e.getMessage(), e);
      }
    }
    return res;
  }

  private void loadDefinitionItem(String name, InputStream stream, IContextResourceLoader loader, ILoadFilter filter, PackageVersion pi) throws IOException, FHIRException {
    if (name.endsWith(".xml"))
      loadFromFile(stream, name, loader, filter);
    else if (name.endsWith(".json"))
      loadFromFileJson(stream, name, loader, filter, pi);
    else if (name.equals("version.info"))
      readVersionInfo(stream);
    else
      loadBytes(name, stream);
  }

  public String connectToTSServer(TerminologyClient client, String log) {
    try {
      tlog("Connect to "+client.getAddress());
      txClient = client;
      if (log != null && log.endsWith(".txt")) {
        txLog = new TextClientLogger(log);
      } else {
        txLog = new HTMLClientLogger(log);
      }
      txClient.setLogger(txLog);
      return txClient.getCapabilitiesStatementQuick().getSoftware().getVersion();
    } catch (Exception e) {
      throw new FHIRException(formatMessage(I18nConstants.UNABLE_TO_CONNECT_TO_TERMINOLOGY_SERVER_USE_PARAMETER_TX_NA_TUN_RUN_WITHOUT_USING_TERMINOLOGY_SERVICES_TO_VALIDATE_LOINC_SNOMED_ICDX_ETC_ERROR__, e.getMessage()), e);
    }
  }

  public void loadFromFile(InputStream stream, String name, IContextResourceLoader loader) throws IOException, FHIRException {
    loadFromFile(stream, name, null);
  }
  
	public void loadFromFile(InputStream stream, String name, IContextResourceLoader loader, ILoadFilter filter) throws IOException, FHIRException {
		Resource f;
		try {
		  if (loader != null)
		    f = loader.loadBundle(stream, false);
		  else {
		    XmlParser xml = new XmlParser();
		    f = xml.parse(stream);
		  }
    } catch (DataFormatException e1) {
      throw new org.hl7.fhir.exceptions.FHIRFormatError(formatMessage(I18nConstants.ERROR_PARSING_, name, e1.getMessage()), e1);
    } catch (Exception e1) {
			throw new org.hl7.fhir.exceptions.FHIRFormatError(formatMessage(I18nConstants.ERROR_PARSING_, name, e1.getMessage()), e1);
		}
		if (f instanceof Bundle) {
		  Bundle bnd = (Bundle) f;
		  for (BundleEntryComponent e : bnd.getEntry()) {
		    if (e.getFullUrl() == null) {
		      logger.logDebugMessage(LogCategory.CONTEXT, "unidentified resource in " + name+" (no fullUrl)");
		    }
	      if (filter == null || filter.isOkToLoad(e.getResource())) {
		      cacheResource(e.getResource());
	      }
		  }
		} else if (f instanceof CanonicalResource) {
		  if (filter == null || filter.isOkToLoad(f)) {
		    cacheResource(f);
		  }
		}
	}

  private void loadFromFileJson(InputStream stream, String name, IContextResourceLoader loader, ILoadFilter filter, PackageVersion pi) throws IOException, FHIRException {
    Bundle f = null;
    try {
      if (loader != null)
        f = loader.loadBundle(stream, true);
      else {
        JsonParser json = new JsonParser();
        Resource r = json.parse(stream);
        if (r instanceof Bundle)
          f = (Bundle) r;
        else if (filter == null || filter.isOkToLoad(f)) {
          cacheResourceFromPackage(r, pi);
        }
      }
    } catch (FHIRFormatError e1) {
      throw new org.hl7.fhir.exceptions.FHIRFormatError(e1.getMessage(), e1);
    }
    if (f != null)
      for (BundleEntryComponent e : f.getEntry()) {
        if (filter == null || filter.isOkToLoad(e.getResource())) {
          cacheResourceFromPackage(e.getResource(), pi);
        }
    }
  }

	private void loadFromPack(String path, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException {
		loadFromStream(new CSFileInputStream(path), loader);
	}
  
  public void loadFromPackage(NpmPackage pi, IContextResourceLoader loader, ILoadFilter filter) throws IOException  {
    if (progress) {
      System.out.println("Load Package "+pi.name()+"#"+pi.version());
    }
    loadedPackages.add(pi.id()+"#"+pi.version());
    for (String s : pi.listResources(loader.getTypes())) {
       try {
        loadDefinitionItem(s, pi.load("package", s), loader, filter, new PackageVersion(pi.id(), pi.version()));
      } catch (FHIRException | IOException e) {
        throw new FHIRException(formatMessage(I18nConstants.ERROR_READING__FROM_PACKAGE__, s, pi.name(), pi.version(), e.getMessage()), e);
      }
    }
    for (String s : pi.list("other")) {
      binaries.put(s, TextFile.streamToBytes(pi.load("other", s)));
    }
    if (version == null) {
      version = pi.version();
    }
  }

  @Override
	public void loadFromPackage(NpmPackage pi, IContextResourceLoader loader, String... types) throws FileNotFoundException, IOException, FHIRException {
	  if (progress) {
	    System.out.println("Load Package "+pi.name()+"#"+pi.version());
	  }
    loadedPackages.add(pi.id()+"#"+pi.version());
	  if (types.length == 0)
	    types = new String[] { "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem" };
	  for (String s : pi.listResources(types)) {
       loadDefinitionItem(s, pi.load("package", s), loader, null, new PackageVersion(pi.id(), pi.version()));
	  }
	  for (String s : pi.list("other")) {
	    binaries.put(s, TextFile.streamToBytes(pi.load("other", s)));
	  }
	  if (version == null) {
	    version = pi.version();
	  }
	}

  public void loadFromFile(String file, IContextResourceLoader loader) throws IOException, FHIRException {
    loadDefinitionItem(file, new CSFileInputStream(file), loader, null, null);
  }
  
	private void loadFromStream(InputStream stream, IContextResourceLoader loader) throws IOException, FHIRException {
		ZipInputStream zip = new ZipInputStream(stream);
		ZipEntry ze;
		while ((ze = zip.getNextEntry()) != null) {
      loadDefinitionItem(ze.getName(), zip, loader, null, null);
			zip.closeEntry();
		}
		zip.close();
	}

  private void readVersionInfo(InputStream stream) throws IOException, DefinitionException {
    byte[] bytes = IOUtils.toByteArray(stream);
    binaries.put("version.info", bytes);

    String[] vi = new String(bytes).split("\\r?\\n");
    for (String s : vi) {
      if (s.startsWith("version=")) {
        if (version == null)
        version = s.substring(8);
        else if (!version.equals(s.substring(8))) 
          throw new DefinitionException(formatMessage(I18nConstants.VERSION_MISMATCH_THE_CONTEXT_HAS_VERSION__LOADED_AND_THE_NEW_CONTENT_BEING_LOADED_IS_VERSION_, version, s.substring(8)));
      }
      if (s.startsWith("revision="))
        revision = s.substring(9);
      if (s.startsWith("date="))
        date = s.substring(5);
    }
  }

	private void loadBytes(String name, InputStream stream) throws IOException {
    byte[] bytes = IOUtils.toByteArray(stream);
	  binaries.put(name, bytes);
  }

	@Override
	public IParser getParser(ParserType type) {
		switch (type) {
		case JSON: return newJsonParser();
		case XML: return newXmlParser();
		default:
			throw new Error(formatMessage(I18nConstants.PARSER_TYPE__NOT_SUPPORTED, type.toString()));
		}
	}

	@Override
	public IParser getParser(String type) {
		if (type.equalsIgnoreCase("JSON"))
			return new JsonParser();
		if (type.equalsIgnoreCase("XML"))
			return new XmlParser();
		throw new Error(formatMessage(I18nConstants.PARSER_TYPE__NOT_SUPPORTED, type.toString()));
	}

	@Override
	public IParser newJsonParser() {
		return new JsonParser();
	}
	@Override
	public IParser newXmlParser() {
		return new XmlParser();
	}

	@Override
	public INarrativeGenerator getNarrativeGenerator(String prefix, String basePath) {
		return new NarrativeGenerator(prefix, basePath, this);
	}

	@Override
	public IResourceValidator newValidator() throws FHIRException {
	  if (validatorFactory == null)
	    throw new Error(formatMessage(I18nConstants.NO_VALIDATOR_CONFIGURED));
	  return validatorFactory.makeValidator(this);
	}




  @Override
  public List<String> getResourceNames() {
    List<String> result = new ArrayList<String>();
    for (StructureDefinition sd : listStructures()) {
      if (sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION)
        result.add(sd.getName());
    }
    Collections.sort(result);
    return result;
  }

  @Override
  public List<String> getTypeNames() {
    List<String> result = new ArrayList<String>();
    for (StructureDefinition sd : listStructures()) {
      if (sd.getKind() != StructureDefinitionKind.LOGICAL && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION)
        result.add(sd.getName());
    }
    Collections.sort(result);
    return result;
  }

  @Override
  public String getAbbreviation(String name) {
    return "xxx";
  }

  @Override
  public boolean isDatatype(String typeSimple) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isResource(String t) {
    StructureDefinition sd;
    try {
      sd = fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/"+t);
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

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  @Override
  public List<StructureDefinition> allStructures() {
    List<StructureDefinition> result = new ArrayList<StructureDefinition>();
    Set<StructureDefinition> set = new HashSet<StructureDefinition>();
    for (StructureDefinition sd : listStructures()) {
      if (!set.contains(sd)) {
        try {
          generateSnapshot(sd);
          // new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", "snapshot", tail(sd.getUrl())+".xml")), sd);
        } catch (Exception e) {
          System.out.println("Unable to generate snapshot for "+tail(sd.getUrl()) +" from "+tail(sd.getBaseDefinition())+" because "+e.getMessage());
          if (true) {
            e.printStackTrace();
          }
        }
        result.add(sd);
        set.add(sd);
      }
    }
    return result;
  }


  public void loadBinariesFromFolder(String folder) throws FileNotFoundException, Exception {
    for (String n : new File(folder).list()) {
      loadBytes(n, new FileInputStream(Utilities.path(folder, n)));
    }
  }
  
  public void loadBinariesFromFolder(NpmPackage pi) throws FileNotFoundException, Exception {
    for (String n : pi.list("other")) {
      loadBytes(n, pi.load("other", n));
    }
  }
  
  public void loadFromFolder(String folder) throws FileNotFoundException, Exception {
    for (String n : new File(folder).list()) {
      if (n.endsWith(".json")) 
        loadFromFile(Utilities.path(folder, n), new JsonParser());
      else if (n.endsWith(".xml")) 
        loadFromFile(Utilities.path(folder, n), new XmlParser());
    }
  }
  
  private void loadFromFile(String filename, IParser p) throws FileNotFoundException, Exception {
  	Resource r; 
  	try {
  		r = p.parse(new FileInputStream(filename));
      if (r.getResourceType() == ResourceType.Bundle) {
        for (BundleEntryComponent e : ((Bundle) r).getEntry()) {
          cacheResource(e.getResource());
        }
     } else {
       cacheResource(r);
     }
  	} catch (Exception e) {
    	return;
    }
  }

  @Override
  public boolean prependLinks() {
    return false;
  }

  @Override
  public boolean hasCache() {
    return true;
  }

  @Override
  public String getVersion() {
    return version;
  }

  
  public List<StructureMap> findTransformsforSource(String url) {
    List<StructureMap> res = new ArrayList<StructureMap>();
    for (StructureMap map : listTransforms()) {
      boolean match = false;
      boolean ok = true;
      for (StructureMapStructureComponent t : map.getStructure()) {
        if (t.getMode() == StructureMapModelMode.SOURCE) {
          match = match || t.getUrl().equals(url);
          ok = ok && t.getUrl().equals(url);
        }
      }
      if (match && ok)
        res.add(map);
    }
    return res;
  }

  public IValidatorFactory getValidatorFactory() {
    return validatorFactory;
  }

  public void setValidatorFactory(IValidatorFactory validatorFactory) {
    this.validatorFactory = validatorFactory;
  }

  @Override
  public <T extends Resource> T fetchResource(Class<T> class_, String uri) {
    T r = super.fetchResource(class_, uri);
    if (r instanceof StructureDefinition) {
      StructureDefinition p = (StructureDefinition)r;
      try {
        generateSnapshot(p);
      } catch (Exception e) {
        // not sure what to do in this case?
        System.out.println("Unable to generate snapshot for "+uri+": "+e.getMessage());
      }
    }
    return r;
  }
  
  @Override
  public StructureDefinition fetchRawProfile(String uri) {
    StructureDefinition r = super.fetchResource(StructureDefinition.class, uri);
    return r;
  }
  
  @Override
  public void generateSnapshot(StructureDefinition p) throws DefinitionException, FHIRException {
    generateSnapshot(p, false);
  }
  
  @Override
  public void generateSnapshot(StructureDefinition p, boolean logical) throws DefinitionException, FHIRException {
    if (!p.hasSnapshot() && (logical || p.getKind() != StructureDefinitionKind.LOGICAL)) {
      if (!p.hasBaseDefinition())
        throw new DefinitionException(formatMessage(I18nConstants.PROFILE___HAS_NO_BASE_AND_NO_SNAPSHOT, p.getName(), p.getUrl()));
      StructureDefinition sd = fetchResource(StructureDefinition.class, p.getBaseDefinition());
      if (sd == null && "http://hl7.org/fhir/StructureDefinition/Base".equals(p.getBaseDefinition())) {
        sd = ProfileUtilities.makeBaseDefinition(p.getFhirVersion());
      }
      if (sd == null) {
        throw new DefinitionException(formatMessage(I18nConstants.PROFILE___BASE__COULD_NOT_BE_RESOLVED, p.getName(), p.getUrl(), p.getBaseDefinition()));
      }
      List<ValidationMessage> msgs = new ArrayList<ValidationMessage>();
      List<String> errors = new ArrayList<String>();
      ProfileUtilities pu = new ProfileUtilities(this, msgs, this);
      pu.setAutoFixSliceNames(true);
      pu.setThrowException(false);
      if (sd.getDerivation() == TypeDerivationRule.CONSTRAINT) {
        pu.sortDifferential(sd, p, p.getUrl(), errors, true);
      }
      pu.setDebug(false);
      for (String err : errors)
        msgs.add(new ValidationMessage(Source.ProfileValidator, IssueType.EXCEPTION, p.getUserString("path"), "Error sorting Differential: "+err, ValidationMessage.IssueSeverity.ERROR));
      pu.generateSnapshot(sd, p, p.getUrl(), Utilities.extractBaseUrl(sd.getUserString("path")), p.getName());
      for (ValidationMessage msg : msgs) {
        if ((!ignoreProfileErrors && msg.getLevel() == ValidationMessage.IssueSeverity.ERROR) || msg.getLevel() == ValidationMessage.IssueSeverity.FATAL)
          throw new DefinitionException(formatMessage(I18nConstants.PROFILE___ELEMENT__ERROR_GENERATING_SNAPSHOT_, p.getName(), p.getUrl(), msg.getLocation(), msg.getMessage()));
      }
      if (!p.hasSnapshot())
        throw new FHIRException(formatMessage(I18nConstants.PROFILE___ERROR_GENERATING_SNAPSHOT, p.getName(), p.getUrl()));
      pu = null;
    }
  }

  public boolean isIgnoreProfileErrors() {
    return ignoreProfileErrors;
  }

  public void setIgnoreProfileErrors(boolean ignoreProfileErrors) {
    this.ignoreProfileErrors = ignoreProfileErrors;
  }

  public String listMapUrls() {
    return Utilities.listCanonicalUrls(transforms.keys());
  }

  public boolean isProgress() {
    return progress;
  }

  public void setProgress(boolean progress) {
    this.progress = progress;
  }

  @Override
  public boolean hasPackage(String id, String ver) {
    return loadedPackages.contains(id+"#"+ver);
  }




}