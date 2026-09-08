package org.hl7.fhir.r5.terminologies.utilities;

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



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * This implements a two level cache. 
 *  - a temporary cache for remembering previous local operations
 *  - a persistent cache for remembering tx server operations
 *  
 * the cache is a series of pairs: a map, and a list. the map is the loaded cache, the list is the persistent cache, carefully maintained in order for version control consistency
 * 
 * @author graha
 *
 */

@Slf4j
public class TerminologyCache {

  // TODO (thread-safety): locking in this class is inconsistent. The validation / expansion /
  // subsumption read+write paths (getValidation, cacheValidation, getExpansion, cacheExpansion,
  // getSubsumes, cacheSubsumes, store, save) all synchronize on `lock`, but several other paths
  // that mutate or iterate shared state take no lock:
  //   - getServerId() mutates serverMap (and writes servers.ini)
  //   - cacheValueSet() / cacheCodeSystem() mutate vsCache / csCache and iterate them to rewrite
  //     the vs-externals.json / cs-externals.json files
  //   - getReport() iterates caches and the per-NamedCache entry sets
  // If this cache is ever touched from more than one thread, those are data races / potential
  // ConcurrentModificationExceptions. The intended threading model needs to be decided, and then
  // either `lock` extended to cover these paths or it documented that they are single-threaded.

  public static class SourcedCodeSystem {
    private String server;
    private CodeSystem cs;
    
    public SourcedCodeSystem(String server, CodeSystem cs) {
      super();
      this.server = server;
      this.cs = cs;
    }
    public String getServer() {
      return server;
    }
    public CodeSystem getCs() {
      return cs;
    } 
  }


  public static class SourcedCodeSystemEntry {
    private String server;
    private String filename;
    
    public SourcedCodeSystemEntry(String server, String filename) {
      super();
      this.server = server;
      this.filename = filename;
    }
    public String getServer() {
      return server;
    }
    public String getFilename() {
      return filename;
    }    
  }

  
  public static class SourcedValueSet {
    private String server;
    private ValueSet vs;
    
    public SourcedValueSet(String server, ValueSet vs) {
      super();
      this.server = server;
      this.vs = vs;
    }
    public String getServer() {
      return server;
    }
    public ValueSet getVs() {
      return vs;
    } 
  }

  public static class SourcedValueSetEntry {
    private String server;
    private String filename;
    
    public SourcedValueSetEntry(String server, String filename) {
      super();
      this.server = server;
      this.filename = filename;
    }
    public String getServer() {
      return server;
    }
    public String getFilename() {
      return filename;
    }    
  }

  public static final boolean TRANSIENT = false;
  public static final boolean PERMANENT = true;
  private static final String NAME_FOR_NO_SYSTEM = "all-systems";
  private static final String ENTRY_MARKER = "-------------------------------------------------------------------------------------";
  private static final String BREAK = "####";
  private static final String CACHE_FILE_EXTENSION = ".cache";
  /**
   * Prefix of the header line that carries a cache file's nonce - a fresh random value
   * written on every save, used to detect that someone else has rewritten the file since we
   * last read or wrote it. It sits before the first {@link #ENTRY_MARKER}, and everything
   * before that marker is discarded on load, so older readers simply ignore it and a file
   * without one still loads.
   */
  private static final String NONCE_MARKER = "# nonce: ";

  /**
   * Suffix for the scratch file a save writes into before swapping it over the real one.
   * Deliberately does not end in {@link #CACHE_FILE_EXTENSION}, so {@link #load()} skips
   * any that a hard kill left behind.
   */
  private static final String TEMP_FILE_EXTENSION = ".tmp";
  private static final String CAPABILITY_STATEMENT_TITLE = ".capabilityStatement";
  private static final String TERMINOLOGY_CAPABILITIES_TITLE = ".terminologyCapabilities";
  private static final String FIXED_CACHE_VERSION = "4"; // last change: change the way tx.fhir.org handles expansions

  /**
   * Minimum interval between persistent saves of a single NamedCache. Writes within this
   * window are coalesced: the in-memory cache is updated immediately, and the entry is
   * flushed to disk on the first subsequent write past the window, or by an explicit
   * {@link #save()} call.
   *
   * <p>Five minutes, which is long enough that this is no longer the main way anything
   * reaches disk. Callers are expected to {@link #save()} when a unit of work finishes - the
   * validator at the end of a command, the IG publisher after validation and again at the end
   * of a build - and this window is the backstop for the long stretches in between, plus a
   * bound on how much is at risk if the process dies. A shutdown hook catches the ordinary
   * interruptions; see {@link #ensureShutdownHook}.
   */
  private static final long SAVE_DELAY_MS = 300000;

  /**
   * How long a JVM shutdown waits for pending cache entries to be written before giving up.
   */
  private static final long SHUTDOWN_SAVE_TIMEOUT_MS = 10000;

  /**
   * Every cache that has a folder, so a shutdown can flush them all. Held weakly, so a cache
   * that is simply dropped without {@link #unload()} being called does not leak; synchronized,
   * because the shutdown thread walks it while the rest of the program may still be creating
   * caches.
   */
  private static final Set<TerminologyCache> liveCaches =
      Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<TerminologyCache, Boolean>()));

  /** Guarded by {@link #liveCaches}. */
  private static boolean shutdownHookInstalled = false;

  /**
   * Upper bound on the number of persistent entries kept in a single NamedCache, both in
   * memory and (after the next save) on disk. Without a bound, these caches accumulate
   * entries without limit as validation/expansion results pile up over a long run - and
   * across runs, since they persist - until reloading them exhausts the heap. When the
   * limit is exceeded the oldest entries are evicted (FIFO), which both caps memory and
   * lets an already-oversized file shrink to the cap on its next save. Tune as needed;
   * entries are large (~12KB+ on disk, several times that parsed).
   */
  private static int maxEntriesPerCache = 5000;

  public static int getMaxEntriesPerCache() {
    return maxEntriesPerCache;
  }

  public static void setMaxEntriesPerCache(int value) {
    maxEntriesPerCache = value;
  }


  private SystemNameKeyGenerator systemNameKeyGenerator = new SystemNameKeyGenerator();

  public class CacheToken {
    @Getter
    private String name;
    private String key;
    @Getter
    private String request;

    public void setName(String n) {
      String systemName = getSystemNameKeyGenerator().getNameForSystem(n);
      if (name == null)
        name = systemName;
      else if (!systemName.equals(name))
        name = NAME_FOR_NO_SYSTEM;
    }
  }

  public static class SubsumesResult {
    
    private Boolean result;

    protected SubsumesResult(Boolean result) {
      super();
      this.result = result;
    }

    public Boolean getResult() {
      return result;
    }
    
  }
  
  protected SystemNameKeyGenerator getSystemNameKeyGenerator() {
    return systemNameKeyGenerator;
  }
  public class SystemNameKeyGenerator {
    public static final String SNOMED_SCT_CODESYSTEM_URL = "http://snomed.info/sct";
    public static final String RXNORM_CODESYSTEM_URL = "http://www.nlm.nih.gov/research/umls/rxnorm";
    public static final String LOINC_CODESYSTEM_URL = "http://loinc.org";
    public static final String UCUM_CODESYSTEM_URL = "http://unitsofmeasure.org";

    public static final String HL7_TERMINOLOGY_CODESYSTEM_BASE_URL = "http://terminology.hl7.org/CodeSystem/";
    public static final String HL7_SID_CODESYSTEM_BASE_URL = "http://hl7.org/fhir/sid/";
    public static final String HL7_FHIR_CODESYSTEM_BASE_URL = "http://hl7.org/fhir/";

    public static final String ISO_CODESYSTEM_URN = "urn:iso:std:iso:";
    public static final String LANG_CODESYSTEM_URN = "urn:ietf:bcp:47";
    public static final String MIMETYPES_CODESYSTEM_URN = "urn:ietf:bcp:13";

    public static final String _11073_CODESYSTEM_URN = "urn:iso:std:iso:11073:10101";
    public static final String DICOM_CODESYSTEM_URL = "http://dicom.nema.org/resources/ontology/DCM";

    public String getNameForSystem(String system) {
      final int lastPipe = system.lastIndexOf('|');
      final String systemBaseName = lastPipe == -1 ? system : system.substring(0,lastPipe);
      String systemVersion = lastPipe == -1 ? null : system.substring(lastPipe + 1);

      if (systemVersion != null) {
        if (systemVersion.startsWith("http://snomed.info/sct/")) {
          systemVersion = systemVersion.substring(23);
        }
        systemVersion = systemVersion.replace(":", "").replace("/", "").replace("\\", "").replace("?", "").replace("$", "").replace("*", "").replace("#", "").replace("%", "");
      }
      if (systemBaseName.equals(SNOMED_SCT_CODESYSTEM_URL))
        return getVersionedSystem("snomed", systemVersion);
      if (systemBaseName.equals(RXNORM_CODESYSTEM_URL))
        return getVersionedSystem("rxnorm", systemVersion);
      if (systemBaseName.equals(LOINC_CODESYSTEM_URL))
        return getVersionedSystem("loinc", systemVersion);
      if (systemBaseName.equals(UCUM_CODESYSTEM_URL))
        return getVersionedSystem("ucum", systemVersion);
      if (systemBaseName.startsWith(HL7_SID_CODESYSTEM_BASE_URL))
        return getVersionedSystem(normalizeBaseURL(HL7_SID_CODESYSTEM_BASE_URL, systemBaseName), systemVersion);
      if (systemBaseName.equals(_11073_CODESYSTEM_URN))
        return getVersionedSystem("11073", systemVersion);
      if (systemBaseName.startsWith(ISO_CODESYSTEM_URN))
        return getVersionedSystem("iso"+systemBaseName.substring(ISO_CODESYSTEM_URN.length()).replace(":", ""), systemVersion);
      if (systemBaseName.startsWith(HL7_TERMINOLOGY_CODESYSTEM_BASE_URL))
        return getVersionedSystem(normalizeBaseURL(HL7_TERMINOLOGY_CODESYSTEM_BASE_URL, systemBaseName), systemVersion);
      if (systemBaseName.startsWith(HL7_FHIR_CODESYSTEM_BASE_URL))
        return getVersionedSystem(normalizeBaseURL(HL7_FHIR_CODESYSTEM_BASE_URL, systemBaseName), systemVersion);
      if (systemBaseName.equals(LANG_CODESYSTEM_URN))
        return getVersionedSystem("lang", systemVersion);
      if (systemBaseName.equals(MIMETYPES_CODESYSTEM_URN))
        return getVersionedSystem("mimetypes", systemVersion);
      if (systemBaseName.equals(DICOM_CODESYSTEM_URL))
        return getVersionedSystem("dicom", systemVersion);
      return getVersionedSystem(systemBaseName.replace("/", "_").replace(":", "_").replace("?", "X").replace("#", "X"), systemVersion);
    }

    public String normalizeBaseURL(String baseUrl, String fullUrl) {
      return fullUrl.substring(baseUrl.length()).replace("/", "");
    }

    public String getVersionedSystem(String baseSystem, String version) {
      if (version != null) {
        return baseSystem + "_" + version;
      }
      return baseSystem;
    }
  }


  private class CacheEntry {
    private String request;
    private boolean persistent;
    private ValidationResult v;
    private ValueSetExpansionOutcome e;
    private SubsumesResult s;
  }

  private class NamedCache {
    private String name;
    private Set<CacheEntry> list = new LinkedHashSet<CacheEntry>(); // persistent entries, in insertion order
    private Map<String, CacheEntry> map = new HashMap<String, CacheEntry>();
    /** True when {@link #list} has persistent entries that haven't yet been flushed to disk. */
    private boolean dirty = false;
    /** Wall-clock time of the last on-disk save for this cache (0 = never saved this session). */
    private long lastSaveAt = 0;
    /**
     * The nonce in the copy of this cache we last read or wrote. Null when we have never
     * touched the file. If what is on disk no longer carries this value, another process has
     * rewritten it and we must merge before saving over the top - see {@link #mergeFromDisk}.
     */
    private String nonce = null;
  }


  private final Object lock;
  private final String folder;
  @Getter private int requestCount;
  @Getter private int hitCount;
  @Getter private int networkCount;
  /** Set by {@link #unload()}; once true the cache rejects all reads and writes. */
  private boolean unloaded = false;

  private final static long CAPABILITY_CACHE_EXPIRATION_HOURS = 24;
  private final static long CAPABILITY_CACHE_EXPIRATION_MILLISECONDS = CAPABILITY_CACHE_EXPIRATION_HOURS * 60 * 60 * 1000;
  private final long capabilityCacheExpirationMilliseconds;
  private final TerminologyCapabilitiesCache<CapabilityStatement> capabilityStatementCache;
  private final TerminologyCapabilitiesCache<TerminologyCapabilities> terminologyCapabilitiesCache;
  private Map<String, NamedCache> caches = new HashMap<String, NamedCache>();

  // Memoised pretty-JSON of the expansion Parameters used in every validation /
  // subsumes cache key. The Parameters are effectively constant for a whole run
  // (they only change when the context replaces them), but their JSON was being
  // recomposed on every validateCode call - including the ones that go on to hit
  // the cache. We key the memo on object identity: callers pass the context's
  // stable master Parameters, so a hit is the common case; when the context
  // swaps in a new Parameters instance the identity changes and we recompose
  // once. Held in a single AtomicReference so concurrent readers never see a
  // params/json pair torn apart (a benign recompute race is the worst case).
  // The produced string is byte-identical to the old inline composeString, so
  // existing on-disk .cache keys remain valid.
  private final AtomicReference<ExpParamsJson> expParamsJsonCache = new AtomicReference<>();

  private static final class ExpParamsJson {
    final Parameters params;
    final String json;
    ExpParamsJson(Parameters params, String json) {
      this.params = params;
      this.json = json;
    }
  }

  private Map<String, SourcedValueSetEntry> vsCache = new HashMap<>();
  private Map<String, SourcedCodeSystemEntry> csCache = new HashMap<>();
  private Map<String, String> serverMap = new HashMap<>();

  @Getter @Setter private static boolean noCaching;
  @Getter @Setter private static boolean cacheErrors;

  protected TerminologyCache(Object lock, String folder, Long capabilityCacheExpirationMilliseconds) throws FileNotFoundException, IOException, FHIRException {
    super();
   this.lock = lock;
   this.capabilityCacheExpirationMilliseconds = capabilityCacheExpirationMilliseconds;
   capabilityStatementCache = new CommonsTerminologyCapabilitiesCache<>(capabilityCacheExpirationMilliseconds, TimeUnit.MILLISECONDS);
   terminologyCapabilitiesCache = new CommonsTerminologyCapabilitiesCache<>(capabilityCacheExpirationMilliseconds, TimeUnit.MILLISECONDS);
    if (folder == null) {
      folder = Utilities.path("[tmp]", "default-tx-cache");
    } else if ("n/a".equals(folder)) {
      // this is a weird way to do things but it maintains the legacy interface
      folder = null;
    }
    this.folder = folder;
    requestCount = 0;
    hitCount = 0;
    networkCount = 0;

    if (folder != null) {
      File f = ManagedFileAccess.file(folder);
      if (!f.exists()) {
        FileUtilities.createDirectory(folder);
      }
      if (!f.exists()) {
        throw new IOException("Unable to create terminology cache at "+folder);
      }
      checkVersion();
      load();
      liveCaches.add(this);
      ensureShutdownHook();
    }
  }

  // use lock from the context
  public TerminologyCache(Object lock, String folder) throws IOException, FHIRException {
    this(lock, folder, CAPABILITY_CACHE_EXPIRATION_MILLISECONDS);
  }

  private void checkVersion() throws IOException {
    File verFile = ManagedFileAccess.file(Utilities.path(folder, "version.ctl"));
    if (verFile.exists()) {
      String ver = FileUtilities.fileToString(verFile);
      if (!ver.equals(FIXED_CACHE_VERSION)) {
        log.info("Terminology Cache Version has changed from 1 to "+FIXED_CACHE_VERSION+", so clearing txCache");
        clear();
      }
      FileUtilities.stringToFile(FIXED_CACHE_VERSION, verFile);
    } else {
      FileUtilities.stringToFile(FIXED_CACHE_VERSION, verFile);
    }
  }

  public String getServerId(String address) throws IOException  {
    if (serverMap.containsKey(address)) {
      return serverMap.get(address);
    }
    String base = serverIdBase(address);
    String id = base;
    int i = 1;
    while (serverMap.containsValue(id)) {
      i++;
      id = base + i;
    }
    serverMap.put(address, id);
    if (folder != null) {
      IniFile ini = new IniFile(Utilities.path(folder, "servers.ini"));
      ini.setStringProperty("servers", id, address, null);
      ini.save();
    }
    return id;
  }

  /**
   * Derive the base server id from an address: strip the leading http(s):// scheme (always a
   * prefix, so startsWith/substring is faster and safer than replacing every occurrence), then
   * turn the remaining path separators into dots.
   */
  private String serverIdBase(String address) {
    String s = address;
    if (s.startsWith("http://")) {
      s = s.substring("http://".length());
    } else if (s.startsWith("https://")) {
      s = s.substring("https://".length());
    }
    return s.replace("/", ".");
  }
  
  /**
   * Arrange for pending entries to be written when the JVM goes down.
   *
   * <p>Saves are coalesced into {@value #SAVE_DELAY_MS}ms windows, so a run that is interrupted
   * - Ctrl-C on a long IG build, a CI job that hits its time limit - would otherwise discard
   * terminology work that has already been paid for. {@link #unload()} saves, but nothing
   * guarantees it is ever reached.
   *
   * <p>The writing happens on a separate thread that the hook waits a bounded time for, because
   * {@link #save()} takes the context lock: if another thread holds it as the JVM starts to shut
   * down, doing this inline would hang the exit instead of merely losing a cache entry. Timing
   * out leaves us exactly where we would have been without a hook, and a partial flush is safe
   * because each file is swapped into place atomically.
   */
  private static void ensureShutdownHook() {
    synchronized (liveCaches) {
      if (shutdownHookInstalled) {
        return;
      }
      shutdownHookInstalled = true;
    }
    try {
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        Thread saver = new Thread(TerminologyCache::saveAll, "terminology-cache-shutdown-save");
        saver.setDaemon(true);
        saver.start();
        try {
          saver.join(SHUTDOWN_SAVE_TIMEOUT_MS);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }, "terminology-cache-shutdown"));
    } catch (IllegalStateException e) {
      // shutdown is already under way; there is nothing left to register with
    }
  }

  private static void saveAll() {
    List<TerminologyCache> caches;
    synchronized (liveCaches) {
      caches = new ArrayList<TerminologyCache>(liveCaches);
    }
    for (TerminologyCache cache : caches) {
      try {
        cache.save();
      } catch (Throwable t) {
        // Throwable, not Exception, and deliberately: the most likely way to get here is a
        // JVM going down under memory pressure, where writing a large cache throws
        // OutOfMemoryError. That must not stop the smaller caches from being written. We are
        // on the way out and there is nothing left to protect, so there is nowhere useful for
        // this to go either.
      }
    }
  }

  public void unload() {
    // not useable after this is called — flush any pending writes first so we don't lose
    // entries that were waiting out the SAVE_DELAY_MS coalescing window.
    save();
    liveCaches.remove(this);
    caches.clear();
    vsCache.clear();
    csCache.clear();
    unloaded = true;
  }

  public void clear() throws IOException {
    if (folder != null) {
      FileUtilities.clearDirectory(folder);
    }
    caches.clear();
    vsCache.clear();
    csCache.clear();
  }
  
  public boolean hasCapabilityStatement(String address) {
    return capabilityStatementCache.containsKey(address);
  }

  public CapabilityStatement getCapabilityStatement(String address) {
    return capabilityStatementCache.get(address);
  }

  public void cacheCapabilityStatement(String address, CapabilityStatement capabilityStatement) throws IOException {
    if (noCaching) {
      return;
    } 
    this.capabilityStatementCache.put(address, capabilityStatement);
    save(capabilityStatement, CAPABILITY_STATEMENT_TITLE+"."+getServerId(address));
  }


  public boolean hasTerminologyCapabilities(String address) {
    return terminologyCapabilitiesCache.containsKey(address);
  }

  public TerminologyCapabilities getTerminologyCapabilities(String address) {
    return terminologyCapabilitiesCache.get(address);
  }

  public void cacheTerminologyCapabilities(String address, TerminologyCapabilities terminologyCapabilities) throws IOException {
    if (noCaching) {
      return;
    }
    this.terminologyCapabilitiesCache.put(address, terminologyCapabilities);
    save(terminologyCapabilities, TERMINOLOGY_CAPABILITIES_TITLE+"."+getServerId(address));
  }


  public CacheToken generateValidationToken(ValidationOptions options, Coding code, ValueSet vs, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      if (code.hasSystem()) {
        ct.setName(code.getSystem());
      }
      else
        ct.name = NAME_FOR_NO_SYSTEM;
      nameCacheToken(vs, ct);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = expParamsJson(json, expParameters);

      if (vs != null && vs.hasUrl() && vs.hasVersion()) {
        ct.request = "{\"code\" : " + json.composeString(code, "codeableConcept") + ", \"url\": \"" + Utilities.escapeJson(vs.getUrl())
          + "\", \"version\": \"" + Utilities.escapeJson(vs.getVersion()) + "\"" + (options == null ? "" : ", " + options.toJson()) + ", \"profile\": " + expJS + "}\r\n";
      } else if (vs != null && vs.hasUrl()) {
          ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())
            +"\""+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}\r\n";
      } else if (options.getVsAsUrl()) {
        ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+extracted(json, vs)+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      } else {
        ValueSet vsc = getVSEssense(vs);
        ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+(vsc == null ? "null" : extracted(json, vsc))+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      }
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
  }

  public CacheToken generateValidationToken(ValidationOptions options, Coding code, String vsUrl, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      if (code.hasSystem()) {
        ct.setName(code.getSystem());
      } else {
        ct.name = NAME_FOR_NO_SYSTEM;
      }
      ct.setName(vsUrl);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = expParamsJson(json, expParameters);

      ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+(vsUrl == null ? "null" : vsUrl)+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
  }

  /**
   * Pretty-JSON of the expansion Parameters for use in a cache key, memoised on
   * the Parameters' object identity. Returns "" for null (matching the previous
   * inline behaviour). The output is identical to {@code json.composeString(expParameters)},
   * so cache keys are unchanged.
   */
  private String expParamsJson(JsonParser json, Parameters expParameters) throws IOException {
    if (expParameters == null) {
      return "";
    }
    final ExpParamsJson cached = expParamsJsonCache.get();
    if (cached != null && cached.params == expParameters) {
      return cached.json;
    }
    final String s = json.composeString(expParameters);
    expParamsJsonCache.set(new ExpParamsJson(expParameters, s));
    return s;
  }

  public String extracted(JsonParser json, ValueSet vsc) throws IOException {
    String s = null;
    if (vsc.getExpansion().getContains().size() > 1000 || vsc.getCompose().getIncludeFirstRep().getConcept().size() > 1000) {      
      s =  vsc.getUrl();
    } else {
      s = json.composeString(vsc);
    }
    return s;
  }

  public CacheToken generateValidationToken(ValidationOptions options, CodeableConcept code, ValueSet vs, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      for (Coding c : code.getCoding()) {
        if (c.hasSystem()) {
          ct.setName(c.getSystem());
        }
      }
      nameCacheToken(vs, ct);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = expParamsJson(json, expParameters);
      if (vs != null && vs.hasUrl() && vs.hasVersion()) {
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())+
            "\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\""+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}\r\n";      
      } else if (vs == null) { 
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";        
      } else {
        ValueSet vsc = getVSEssense(vs);
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"valueSet\" :"+extracted(json, vsc)+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      }
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
  }

  public ValueSet getVSEssense(ValueSet vs) {
    if (vs == null)
      return null;
    ValueSet vsc = new ValueSet();
    vsc.setCompose(vs.getCompose());
    if (vs.hasExpansion()) {
      vsc.getExpansion().getParameter().addAll(vs.getExpansion().getParameter());
      vsc.getExpansion().getContains().addAll(vs.getExpansion().getContains());
    }
    return vsc;
  }

  public CacheToken generateExpandToken(ValueSet vs, ExpansionOptions options) {
    CacheToken ct = new CacheToken();
    nameCacheToken(vs, ct);
    if (vs.hasUrl() && vs.hasVersion()) {
      ct.request = "{\"hierarchical\" : "+(options.isHierarchical() ? "true" : "false")+(options.hasLanguage() ?  ", \"language\": \""+options.getLanguage()+"\"" : "")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())+"\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\"}\r\n";
    } else {
      ValueSet vsc = getVSEssense(vs);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      try {
        ct.request = "{\"hierarchical\" : "+(options.isHierarchical() ? "true" : "false")+(options.hasLanguage() ?  ", \"language\": \""+options.getLanguage()+"\"" : "")+", \"valueSet\" :"+extracted(json, vsc)+"}\r\n";
      } catch (IOException e) {
        throw new Error(e);
      }
    }
    ct.key = String.valueOf(hashJson(ct.request));
    return ct;
  }
  
  public CacheToken generateExpandToken(String url, ExpansionOptions options) {
    CacheToken ct = new CacheToken();
    ct.request = "{\"hierarchical\" : "+(options.isHierarchical() ? "true" : "false")+(options.hasLanguage() ?  ", \"language\": \""+options.getLanguage()+"\"" : "")+", \"url\": \""+Utilities.escapeJson(url)+"\"}\r\n";
    ct.key = String.valueOf(hashJson(ct.request));
    return ct;
  }

  public void nameCacheToken(ValueSet vs, CacheToken ct) {
    if (vs != null) {
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        if (inc.hasSystem()) {
          ct.setName(inc.getSystem());
        }
      }
      for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
        if (inc.hasSystem()) {
          ct.setName(inc.getSystem());
        }
      }
      for (ValueSetExpansionContainsComponent inc : vs.getExpansion().getContains()) {
        if (inc.hasSystem()) {
          ct.setName(inc.getSystem());
        }
      }
    }
  }

  private String normalizeSystemPath(String path) {
    return path.replace("/", "").replace('|','X');
  }



  /**
   * Guard against use after {@link #unload()}. All cache reads and writes route through
   * {@link #getNamedCache}, so checking here rejects the whole read/write surface.
   */
  private void checkUsable() {
    if (unloaded) {
      throw new IllegalStateException("This TerminologyCache has been unloaded and can no longer be read from or written to");
    }
  }

  public NamedCache getNamedCache(CacheToken cacheToken) {
    checkUsable();

    final String cacheName = cacheToken.name == null ? "null" : cacheToken.name;

    NamedCache nc = caches.get(cacheName);

    if (nc == null) {
      nc = new NamedCache();
      nc.name = cacheName;
      caches.put(nc.name, nc);
    }
    return nc;
  }

  public ValueSetExpansionOutcome getExpansion(CacheToken cacheToken) {
    synchronized (lock) {
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null)
        return null;
      else
        return e.e;
    }
  }

  public void cacheExpansion(CacheToken cacheToken, ValueSetExpansionOutcome res, boolean persistent) {
    synchronized (lock) {      
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = new CacheEntry();
      e.request = cacheToken.request;
      e.persistent = persistent;
      e.e = res;
      store(cacheToken, persistent, nc, e);
    }    
  }

  public void store(CacheToken cacheToken, boolean persistent, NamedCache nc, CacheEntry e) {
    if (noCaching) {
      return;
    }

    // Two kinds of result describe the state of the terminology server rather than the content
    // being validated, and so must not outlive this session:
    //  - SERVER_ERROR / NOSERVICE: the server could not be reached this time. Written to disk,
    //    a single timeout becomes permanent for every later run and every later version of the
    //    validator, with no recovery short of deleting the cache directory by hand (see #2524).
    //  - CODESYSTEM_UNSUPPORTED: the server does not have that code system. Load it and the
    //    answer changes, so it is no more durable than the one above (see #2262).
    // Both are still held in memory, so repeat validation of the same code stays cheap within
    // the run; they are simply asked again next time.
    if (persistent && (isTransientFailure(e) || (!cacheErrors && isCodeSystemUnsupported(e)))) {
      persistent = false;
      e.persistent = false;
    }

    // map.put returns the entry this key previously held (or null). Removing that exact
    // object from the ordered set is O(1), replacing the old O(n) backward scan that
    // compared full request strings on every persistent write. (remove() is a harmless
    // no-op when the previous entry was transient and so was never in the list.)
    CacheEntry previous = nc.map.put(cacheToken.key, e);
    if (persistent) {
      if (previous != null) {
        nc.list.remove(previous);
      }
      nc.list.add(e);
      enforceEntryLimit(nc);
      nc.dirty = true;
      long now = System.currentTimeMillis();
      // Coalesce frequent writes: only flush if it's been at least SAVE_DELAY_MS since
      // the last save for this NamedCache. Entries that miss the window stay in memory
      // until the next write past the deadline, or until save() is called explicitly.
      if (now - nc.lastSaveAt >= SAVE_DELAY_MS) {
        save(nc, now);
      }
    }
  }

  private boolean isCodeSystemUnsupported(CacheEntry e) {
    return errorClassOf(e) == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED;
  }

  /**
   * The error class of whatever kind of answer this entry holds - a validation, or an expansion.
   */
  private TerminologyServiceErrorClass errorClassOf(CacheEntry e) {
    if (e.v != null) {
      return e.v.getErrorClass();
    } else if (e.e != null) {
      return e.e.getErrorClass();
    } else {
      return null;
    }
  }

  /**
   * Is this a failure to reach the terminology server, rather than an answer about the content?
   *
   * Deliberately not {@link TerminologyServiceErrorClass#isInfrastructure()}, which also covers
   * VALUESET_UNSUPPORTED: that describes the request the server was asked to answer, and is
   * reproducible, where these two describe the connection at one moment in time.
   */
  private boolean isTransientFailure(CacheEntry e) {
    TerminologyServiceErrorClass ec = errorClassOf(e);
    return ec == TerminologyServiceErrorClass.SERVER_ERROR || ec == TerminologyServiceErrorClass.NOSERVICE;
  }

  /**
   * Evict oldest persistent entries (FIFO) until the cache is within {@link #maxEntriesPerCache}.
   * Keeps both {@link NamedCache#list} and {@link NamedCache#map} bounded. Only entries whose
   * map slot still points at the evicted object are removed from the map, so a transient or
   * re-stored entry sharing a key is left intact.
   */
  private void enforceEntryLimit(NamedCache nc) {
    // LinkedHashSet iterates in insertion order, so the iterator yields oldest-first; remove
    // through it to evict FIFO in O(1) each (no indexed removal from the front).
    Iterator<CacheEntry> it = nc.list.iterator();
    while (nc.list.size() > maxEntriesPerCache && it.hasNext()) {
      CacheEntry evicted = it.next();
      it.remove();
      String key = String.valueOf(hashJson(evicted.request));
      if (nc.map.get(key) == evicted) {
        nc.map.remove(key);
      }
    }
  }

  public ValidationResult getValidation(CacheToken cacheToken) {
    if (cacheToken.key == null) {
      return null;
    }
    synchronized (lock) {
      requestCount++;
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null) {
        networkCount++;
        return null;
      } else {
        hitCount++;
        return new ValidationResult(e.v);
      }
    }
  }

  public void cacheValidation(CacheToken cacheToken, ValidationResult res, boolean persistent) {
    if (cacheToken.key != null) {
      synchronized (lock) {      
        NamedCache nc = getNamedCache(cacheToken);
        CacheEntry e = new CacheEntry();
        e.request = cacheToken.request;
        e.persistent = persistent;
        e.v = new ValidationResult(res);
        store(cacheToken, persistent, nc, e);
      }    
    }
  }


  // persistence

  /**
   * Flush any NamedCaches that have unsaved persistent entries.
   *
   * <p>{@link #store} coalesces writes into ~{@value #SAVE_DELAY_MS}ms windows, so a
   * NamedCache that has just been written to may still be holding entries in memory.
   * Call this on shutdown (or any other moment you need on-disk consistency) to make
   * sure nothing in flight is lost.
   */
  public void save() {
    synchronized (lock) {
      long now = System.currentTimeMillis();
      for (NamedCache nc : caches.values()) {
        if (nc.dirty) {
          save(nc, now);
        }
      }
    }
  }

  private <K extends Resource> void save(K resource, String title) {
    if (folder == null)
      return;

    String temp = null;
    OutputStreamWriter sw = null;
    try {
      String target = Utilities.path(folder, title + CACHE_FILE_EXTENSION);
      temp = tempFileFor(target);
      sw = new OutputStreamWriter(ManagedFileAccess.outStream(temp), "UTF-8");

      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);

      sw.write(json.composeString(resource).trim());
      sw.close();
      sw = null;
      FileUtilities.replaceFileAtomically(ManagedFileAccess.file(temp), ManagedFileAccess.file(target));
      temp = null;
    } catch (Exception e) {
      log.error("error saving capability statement "+e.getMessage(), e);
    } finally {
      closeQuietly(sw);
      deleteQuietly(temp);
    }
  }

  /**
   * The scratch file a save writes into before swapping it over {@code target}.
   *
   * <p>It sits beside the target - the swap can only be atomic within one filesystem - and
   * carries a random discriminator so that two processes saving the same cache at the same
   * moment write to different scratch files. Without that they would interleave into one
   * shared temp file and swap the mess into place. With it, the only contended operation is
   * the swap itself, which is atomic, so the loser is simply overwritten.
   */
  private String tempFileFor(String target) {
    return target + "." + UUID.randomUUID().toString() + TEMP_FILE_EXTENSION;
  }

  private void closeQuietly(Closeable c) {
    if (c != null) {
      try {
        c.close();
      } catch (IOException e) {
        // the save has already failed; nothing useful to do with this
      }
    }
  }

  /**
   * Remove a scratch file that never made it into place. Best effort: an orphan is harmless
   * (load() ignores it) and only survives a hard kill mid-save.
   */
  private void deleteQuietly(String path) {
    if (path != null) {
      try {
        ManagedFileAccess.file(path).delete();
      } catch (Exception e) {
        // nothing useful to do
      }
    }
  }

  /**
   * Has the file behind this cache been rewritten by someone else since we last read or wrote
   * it?
   *
   * <p>Answered from a nonce in the file's header rather than from its timestamp: mtime
   * granularity is a whole second on some filesystems, which sits well inside the window in
   * which two processes can both save, whereas the nonce is exact. Answering costs one line.
   *
   * <p>A file carrying no nonce was written by a version of this code from before the header
   * existed, so it counts as changed. That happens once: our own save writes a nonce, so it
   * converges immediately.
   */
  private boolean isChangedOnDisk(NamedCache nc) {
    try {
      String path = Utilities.path(folder, nc.name+CACHE_FILE_EXTENSION);
      if (!ManagedFileAccess.file(path).exists()) {
        return false;
      }
      String nonce = null;
      try (BufferedReader r = new BufferedReader(new InputStreamReader(
          ManagedFileAccess.inStream(path), StandardCharsets.UTF_8))) {
        String line = r.readLine();
        if (line != null && line.startsWith(NONCE_MARKER)) {
          nonce = line.substring(NONCE_MARKER.length()).trim();
        }
      }
      return nonce == null || !nonce.equals(nc.nonce);
    } catch (Exception e) {
      // if we can't tell, assume it changed: re-reading a file needlessly is cheap, and
      // dropping another process's entries is not
      log.debug("Unable to check "+nc.name+" for concurrent changes ("+e.getMessage()+") - merging anyway");
      return true;
    }
  }

  /**
   * Fold the on-disk copy of this cache into our in-memory one, so that saving over the top
   * does not discard what another process learned.
   *
   * <p>Direction matters, and it is this way round: start from what is on disk, then replay
   * our own entries on top. For a request we both hold, ours wins - we just got it from the
   * server, so it is the fresher answer - and it lands at the tail of the insertion order.
   * {@link #enforceEntryLimit} evicts oldest-first, so a merge that overflows the cap discards
   * stale entries from disk rather than anything we just fetched.
   *
   * <p>Transient entries are the one wrinkle. They live in the map but never in the list, so
   * they are never written; where disk has a persistent answer for a request we only hold
   * transiently, we take the disk entry - a real answer beats a local outage, and keeping it
   * is also what stops our save from dropping it from the file.
   */
  private void mergeFromDisk(NamedCache nc) {
    NamedCache disk = readNamedCache(nc.name+CACHE_FILE_EXTENSION, nc.name);
    if (disk == null) {
      return; // unreadable: keep what we have rather than losing that too
    }
    Set<CacheEntry> merged = new LinkedHashSet<CacheEntry>();
    for (CacheEntry ce : disk.list) {
      String key = String.valueOf(hashJson(ce.request));
      CacheEntry ours = nc.map.get(key);
      if (ours != null && ours.persistent) {
        continue; // ours is newer; it goes in below, after everything from disk
      }
      merged.add(ce);
      nc.map.put(key, ce);
    }
    merged.addAll(nc.list);
    nc.list = merged;
    enforceEntryLimit(nc);
    nc.nonce = disk.nonce;
  }

  private void save(NamedCache nc, long lastSaveAt) {
    if (folder == null)
      return;

    // Another process sharing this cache folder may have rewritten this file since we last
    // read or wrote it; fold what it learned in before we save over the top. Costs one line
    // read unless the file really has changed.
    if (isChangedOnDisk(nc)) {
      mergeFromDisk(nc);
    }

    // Write the whole file into a scratch file beside it and swap that into place once it is
    // complete, rather than writing over the live file. Anything reading concurrently - another
    // validator process sharing this cache folder, our own load(), TerminologyCacheManager
    // zipping the folder up, a git add in the auto-builder - then sees either the old file or
    // the new one, never a truncated one. See FileUtilities.replaceFileAtomically.
    boolean saved = false;
    String temp = null;
    BufferedWriter sw = null;
    try {
      String target = Utilities.path(folder, nc.name+CACHE_FILE_EXTENSION);
      temp = tempFileFor(target);
      sw = new BufferedWriter(new OutputStreamWriter(ManagedFileAccess.outStream(temp), "UTF-8"));
      String nonce = UUID.randomUUID().toString();
      sw.write(NONCE_MARKER+nonce+"\r\n");
      sw.write(ENTRY_MARKER+"\r\n");
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      for (CacheEntry ce : nc.list) {
        sw.write(ce.request.trim());
        sw.write(BREAK+"\r\n");
        if (ce.e != null) {
          sw.write("e: {\r\n");
          if (ce.e.isFromServer()) {
            sw.write("  \"from-server\" : true,\r\n");
          }
          if (ce.e.getErrorClass() != null) {
            sw.write("  \"class\" : \""+ce.e.getErrorClass().toString()+"\",\r\n");
          }
          if (ce.e.getValueset() != null) {
            if (ce.e.getValueset().hasUserData(UserDataNames.VS_EXPANSION_SOURCE)) {
              sw.write("  \"source\" : "+Utilities.escapeJson(ce.e.getValueset().getUserString(UserDataNames.VS_EXPANSION_SOURCE)).trim()+",\r\n");              
            }
            sw.write("  \"valueSet\" : "+json.composeString(ce.e.getValueset()).trim()+",\r\n");
          }
          sw.write("  \"error\" : \""+Utilities.escapeJson(ce.e.getError()).trim()+"\"\r\n}\r\n");
        } else if (ce.s != null) {
          sw.write("s: {\r\n");
          sw.write("  \"result\" : "+ce.s.result+"\r\n}\r\n");
        } else {
          sw.write("v: {\r\n");
          boolean first = true;
          if (ce.v.getDisplay() != null) {            
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"display\" : \""+Utilities.escapeJson(ce.v.getDisplay()).trim()+"\"");
          }
          if (ce.v.getCode() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"code\" : \""+Utilities.escapeJson(ce.v.getCode()).trim()+"\"");
          }
          if (ce.v.getSystem() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"system\" : \""+Utilities.escapeJson(ce.v.getSystem()).trim()+"\"");
          }
          if (ce.v.getVersion() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"version\" : \""+Utilities.escapeJson(ce.v.getVersion()).trim()+"\"");
          }
          if (ce.v.getSeverity() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"severity\" : "+"\""+ce.v.getSeverity().toCode().trim()+"\""+"");
          }
          if (ce.v.getMessage() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"error\" : \""+Utilities.escapeJson(ce.v.getMessage()).trim()+"\"");
          }
          if (ce.v.getErrorClass() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"class\" : \""+Utilities.escapeJson(ce.v.getErrorClass().toString())+"\"");
          }
          if (ce.v.getDefinition() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"definition\" : \""+Utilities.escapeJson(ce.v.getDefinition()).trim()+"\"");
          }
          if (ce.v.getStatus() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"status\" : \""+Utilities.escapeJson(ce.v.getStatus()).trim()+"\"");
          }
          if (ce.v.getServer() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"server\" : \""+Utilities.escapeJson(ce.v.getServer()).trim()+"\"");
          }
          if (ce.v.isInactive()) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"inactive\" : true");
          }
          if (ce.v.getDiagnostics() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"diagnostics\" : \""+Utilities.escapeJson(ce.v.getDiagnostics()).trim()+"\"");
          }
          if (ce.v.getUnknownSystems() != null && ce.v.getUnknownSystems().size() > 0) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"unknown-systems\" : \""+Utilities.escapeJson(CommaSeparatedStringBuilder.join(",", ce.v.getUnknownSystems())).trim()+"\"");
          }
          if (ce.v.getParameters() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"parameters\" : "+json.composeString(ce.v.getParameters()).trim()+"\r\n");
          }
          if (ce.v.getIssues() != null) {
            if (first) first = false; else sw.write(",\r\n");
            OperationOutcome oo = new OperationOutcome();
            oo.setIssue(ce.v.getIssues());
            sw.write("  \"issues\" : "+json.composeString(oo).trim()+"\r\n");
          }
          sw.write("\r\n}\r\n");
        }
        sw.write(ENTRY_MARKER+"\r\n");
      }      
      sw.close();
      sw = null;
      FileUtilities.replaceFileAtomically(ManagedFileAccess.file(temp), ManagedFileAccess.file(target));
      temp = null;
      nc.nonce = nonce;
      saved = true;
    } catch (Exception e) {
      log.error("error saving "+nc.name+": "+e.getMessage(), e);
    } finally {
      closeQuietly(sw);
      deleteQuietly(temp);
    }
    // A failed write leaves the cache dirty so that the next save retries these entries,
    // instead of clearing the flag and dropping them silently. lastSaveAt is advanced either
    // way, so a write that keeps failing (a read-only folder, say) retries once per
    // SAVE_DELAY_MS window rather than on every single store.
    nc.dirty = !saved;
    nc.lastSaveAt = lastSaveAt;
  }

  private boolean isCapabilityCache(String fn) {
    if (fn == null) {
      return false;
    }
    return fn.startsWith(CAPABILITY_STATEMENT_TITLE) || fn.startsWith(TERMINOLOGY_CAPABILITIES_TITLE);
  }

  private void loadCapabilityCache(String fn) throws IOException {
    if (TerminologyCapabilitiesCache.cacheFileHasExpired(Utilities.path(folder, fn), capabilityCacheExpirationMilliseconds)) {
      return;
    }
    try {
      String src = FileUtilities.fileToString(Utilities.path(folder, fn));
      String serverId = Utilities.getFileNameForName(fn).replace(CACHE_FILE_EXTENSION, "");
      serverId = serverId.substring(serverId.indexOf(".")+1);
      serverId = serverId.substring(serverId.indexOf(".")+1);
      String address = getServerForId(serverId);
      if (address != null) {
        JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(src);
        Resource resource = new JsonParser().parse(o);

        if (fn.startsWith(CAPABILITY_STATEMENT_TITLE)) {
          this.capabilityStatementCache.put(address, (CapabilityStatement) resource);
        } else if (fn.startsWith(TERMINOLOGY_CAPABILITIES_TITLE)) {
          this.terminologyCapabilitiesCache.put(address, (TerminologyCapabilities) resource);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new FHIRException("Error loading " + fn + ": " + e.getMessage(), e);
    }
  }

  private String getServerForId(String serverId) {
    for (String n : serverMap.keySet()) {
      if (serverMap.get(n).equals(serverId)) {
        return n;
      }
    }
    return null;
  }

  private CacheEntry getCacheEntry(String request, String resultString) throws IOException {
    CacheEntry ce = new CacheEntry();
    ce.persistent = true;
    ce.request = request;
    char e = resultString.charAt(0);
    resultString = resultString.substring(3);
    JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(resultString);
    String error = loadJS(o.get("error"));
    if (e == 'e') {
      TerminologyServiceErrorClass errorClass = o.has("class") ? TerminologyServiceErrorClass.valueOf(o.get("class").getAsString()) : TerminologyServiceErrorClass.UNKNOWN;
      if (o.has("valueSet")) {
        ce.e = new ValueSetExpansionOutcome((ValueSet) new JsonParser().parse(o.getAsJsonObject("valueSet")), error, errorClass, o.has("from-server"));
        if (o.has("source")) {
          ce.e.getValueset().setUserData(UserDataNames.VS_EXPANSION_SOURCE, o.get("source").getAsString());
        }
      } else {
        ce.e = new ValueSetExpansionOutcome(error, errorClass, o.has("from-server"));
      }
    } else if (e == 's') {
      ce.s = new SubsumesResult(o.get("result").getAsBoolean());
    } else {
      String t = loadJS(o.get("severity"));
      IssueSeverity severity = t == null ? null :  IssueSeverity.fromCode(t);
      String display = loadJS(o.get("display"));
      String code = loadJS(o.get("code"));
      String system = loadJS(o.get("system"));
      String version = loadJS(o.get("version"));
      String definition = loadJS(o.get("definition"));
      String server = loadJS(o.get("server"));
      String status = loadJS(o.get("status"));
      boolean inactive = "true".equals(loadJS(o.get("inactive")));
      String unknownSystems = loadJS(o.get("unknown-systems"));
      OperationOutcome oo = o.has("issues") ? (OperationOutcome) new JsonParser().parse(o.getAsJsonObject("issues")) : null;
      Parameters p = o.has("parameters") ? (Parameters) new JsonParser().parse(o.getAsJsonObject("parameters")) : null;
      t = loadJS(o.get("class")); 
      TerminologyServiceErrorClass errorClass = t == null ? null : TerminologyServiceErrorClass.valueOf(t) ;
      ce.v = new ValidationResult(severity, error, system, version, new ConceptDefinitionComponent().setDisplay(display).setDefinition(definition).setCode(code), display, null).setErrorClass(errorClass);
      ce.v.setUnknownSystems(CommaSeparatedStringBuilder.toSet(unknownSystems));
      ce.v.setServer(server);
      ce.v.setStatus(inactive, status);
      ce.v.setDiagnostics(loadJS(o.get("diagnostics")));
      if (oo != null) {
        ce.v.setIssues(oo.getIssue());
      }
      if (p != null) {
        ce.v.setParameters(p);
      }
    }
    return ce;
  }

  private void loadNamedCache(String fn) throws IOException {
    NamedCache nc = readNamedCache(fn, fn.substring(0, fn.lastIndexOf(".")));
    if (nc != null) {
      caches.put(nc.name, nc);
    }
  }

  /**
   * Read a cache file into a fresh NamedCache, without registering it in {@link #caches}.
   *
   * @return the loaded cache, or null if the file could not be read at all
   */
  private NamedCache readNamedCache(String fn, String name) {
    int c = 0;
    NamedCache nc = new NamedCache();
    nc.name = name;

    // Stream the file one entry at a time. Cache files can be very large (e.g. the ICD-11
    // cache), and reading the whole file into a single String (as FileUtilities.fileToString
    // does) needs 2-3x the file size in transient heap just for the read - enough to OOM.
    // Streaming keeps peak memory at one entry plus a line buffer. Lines are rejoined with
    // \r\n to preserve the on-disk request bytes so re-saving doesn't churn line endings;
    // keys are line-ending- and whitespace-insensitive via hashJson regardless.
    try (BufferedReader r = new BufferedReader(new InputStreamReader(
        ManagedFileAccess.inStream(Utilities.path(folder, fn)), StandardCharsets.UTF_8))) {
      StringBuilder segment = new StringBuilder();
      boolean seenMarker = false;
      String line;
      while ((line = r.readLine()) != null) {
        if (line.equals(ENTRY_MARKER)) {
          if (seenMarker) {
            loadCacheEntry(nc, segment.toString(), fn, ++c);
          }
          // Content before the first marker (including any legacy '?' prefix) is discarded,
          // apart from the nonce header, which is picked out on the way past.
          seenMarker = true;
          segment.setLength(0);
        } else {
          if (!seenMarker && line.startsWith(NONCE_MARKER)) {
            nc.nonce = line.substring(NONCE_MARKER.length()).trim();
          }
          segment.append(line).append("\r\n");
        }
      }
      // Trailing content after the last marker is intentionally ignored: only
      // marker-terminated entries are loaded (matching the original behavior).
    } catch (Exception e) {
      log.error("Error loading "+fn+": "+e.getMessage()+" entry "+c+" - ignoring it", e);
      return null;
    }
    return nc;
  }

  private void loadCacheEntry(NamedCache nc, String s, String fn, int c) {
    if (Utilities.noString(s)) {
      return;
    }
    try {
      int breakIndex = s.indexOf(BREAK);
      if (breakIndex < 0) {
        log.warn("Malformed entry "+c+" in "+fn+" (no break marker) - ignoring it");
        return;
      }
      String request = s.substring(0, breakIndex);
      String resultString = s.substring(breakIndex + BREAK.length() + 1).trim();

      CacheEntry cacheEntry = getCacheEntry(request, resultString);

      // Caches written before #2524 can hold transient failures. Drop them on the way in
      // rather than serving a stale outage back: the file is rewritten without them the
      // next time this cache saves.
      if (isTransientFailure(cacheEntry)) {
        return;
      }

      // Mirror store()'s dedup so the set and map stay consistent even if a file somehow
      // holds the same request twice: the last occurrence wins, no orphan is left behind.
      CacheEntry previous = nc.map.put(String.valueOf(hashJson(cacheEntry.request)), cacheEntry);
      if (previous != null) {
        nc.list.remove(previous);
      }
      nc.list.add(cacheEntry);
      // Bound memory while loading: an already-oversized file keeps only its newest
      // maxEntriesPerCache entries (oldest evicted as we stream). The trimmed cache is
      // written back the next time it saves.
      enforceEntryLimit(nc);
    } catch (Exception e) {
      log.error("Error loading entry "+c+" in "+fn+": "+e.getMessage()+" - ignoring it", e);
    }
  }

  private void load() throws FHIRException, IOException {
    IniFile ini = new IniFile(Utilities.path(folder, "servers.ini"));
    if (ini.hasSection("servers")) {
      for (String n : ini.getPropertyNames("servers")) {
        serverMap.put(ini.getStringProperty("servers", n), n);
      }
    }

    for (String fn : ManagedFileAccess.file(folder).list()) {
      if (fn.endsWith(CACHE_FILE_EXTENSION) && !fn.equals("validation" + CACHE_FILE_EXTENSION)) {
        try {
          if (isCapabilityCache(fn)) {
            loadCapabilityCache(fn);
          } else {
            loadNamedCache(fn);
          }
        } catch (FHIRException e) {
          throw e;
        }
      }
    }
    try {
      File f = ManagedFileAccess.file(Utilities.path(folder, "vs-externals.json"));
      if (f.exists()) {
        org.hl7.fhir.utilities.json.model.JsonObject json = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(f);
        for (JsonProperty p : json.getProperties()) {
          if (p.getValue().isJsonNull()) {
            vsCache.put(p.getName(), null);
          } else {
            org.hl7.fhir.utilities.json.model.JsonObject j = p.getValue().asJsonObject();
            vsCache.put(p.getName(), new SourcedValueSetEntry(j.asString("server"), j.asString("filename")));        
          }
        }
      }
    } catch (Exception e) {
      log.error("Error loading vs external cache: "+e.getMessage(), e);
    }
    try {
      File f = ManagedFileAccess.file(Utilities.path(folder, "cs-externals.json"));
      if (f.exists()) {
        org.hl7.fhir.utilities.json.model.JsonObject json = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(f);
        for (JsonProperty p : json.getProperties()) {
          if (p.getValue().isJsonNull()) {
            csCache.put(p.getName(), null);
          } else {
            org.hl7.fhir.utilities.json.model.JsonObject j = p.getValue().asJsonObject();
            csCache.put(p.getName(), new SourcedCodeSystemEntry(j.asString("server"), j.asString("filename")));        
          }
        }
      }
    } catch (Exception e) {
      log.error("Error loading vs external cache: "+e.getMessage(), e);
    }
  }

  private String loadJS(JsonElement e) {
    if (e == null)
      return null;
    if (!(e instanceof JsonPrimitive))
      return null;
    String s = e.getAsString();
    if ("".equals(s))
      return null;
    return s;
  }

  public String hashJson(String s) {
    // The cache key must be insensitive to line endings (requests are built with \r\n
    // but round-trip through cache files that may use \n) and to surrounding whitespace.
    // This computes a 64-bit FNV-1a hash over the trimmed, line-ending-normalized
    // characters, without allocating an intermediate normalized string. A 32-bit hash
    // (e.g. String.hashCode) collides far too readily for use as a cache key - a collision
    // returns the wrong cached result - so the key is widened to 64 bits. Keys are held
    // in memory only (recomputed on every load), so the algorithm can change freely.
    int start = 0;
    int end = s.length();

    //Trim leading and trailing whitespace.
    while (start < end && s.charAt(start) <= ' ') start++;     // trim() leading
    while (end > start && s.charAt(end - 1) <= ' ') end--;     // trim() trailing

    long hash = 0xcbf29ce484222325L;                             // FNV-1a 64-bit offset basis
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);

      //Normalize returns and newlines
      if (c == '\r') {                                         // \r and \r\n both become \n
        c = '\n';
        if (i + 1 < end && s.charAt(i + 1) == '\n') i++;
      }

      //Iterate FNV-1a hash
      hash *= 0x100000001b3L; // FNV-1a 64-bit prime
      hash ^= c;
    }
    return Long.toString(hash);
  }

  // management

  public String summary(ValueSet vs) {
    if (vs == null)
      return "null";

    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ConceptSetComponent cc : vs.getCompose().getInclude())
      b.append("Include "+getIncSummary(cc));
    for (ConceptSetComponent cc : vs.getCompose().getExclude())
      b.append("Exclude "+getIncSummary(cc));
    return b.toString();
  }

  private String getIncSummary(ConceptSetComponent cc) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (UriType vs : cc.getValueSet())
      b.append(vs.asStringValue());
    String vsd = b.length() > 0 ? " where the codes are in the value sets ("+b.toString()+")" : "";
    String system = cc.getSystem();
    if (cc.hasConcept())
      return Integer.toString(cc.getConcept().size())+" codes from "+system+vsd;
    if (cc.hasFilter()) {
      String s = "";
      for (ConceptSetFilterComponent f : cc.getFilter()) {
        if (!Utilities.noString(s))
          s = s + " & ";
        s = s + f.getProperty()+" "+(f.hasOp() ? f.getOp().toCode() : "?")+" "+f.getValue();
      }
      return "from "+system+" where "+s+vsd;
    }
    return "All codes from "+system+vsd;
  }

  public String summary(Coding code) {
    return code.getSystem()+"#"+code.getCode()+(code.hasDisplay() ? ": \""+code.getDisplay()+"\"" : "");
  }

  public String summary(CodeableConcept code) {
    StringBuilder b = new StringBuilder();
    b.append("{");
    boolean first = true;
    for (Coding c : code.getCoding()) {
      if (first) first = false; else b.append(",");
      b.append(summary(c));
    }
    b.append("}: \"");
    b.append(code.getText());
    b.append("\"");
    return b.toString();
  }

  public void removeCS(String url) {
    synchronized (lock) {
      String name = getSystemNameKeyGenerator().getNameForSystem(url);
      if (caches.containsKey(name)) {
        caches.remove(name);
      }
    }   
  }

  public String getFolder() {
    return folder;
  }

  public Map<String, String> servers() {
    Map<String, String> servers = new HashMap<>();
//    servers.put("http://local.fhir.org/r2", "tx.fhir.org");
//    servers.put("http://local.fhir.org/r3", "tx.fhir.org");
//    servers.put("http://local.fhir.org/r4", "tx.fhir.org");
//    servers.put("http://local.fhir.org/r5", "tx.fhir.org");
//
//    servers.put("https://tx-dev.fhir.org/r2", "tx.fhir.org");
//    servers.put("https://tx-dev.fhir.org/r3", "tx.fhir.org");
//    servers.put("https://tx-dev.fhir.org/r4", "tx.fhir.org");
//    servers.put("https://tx-dev.fhir.org/r5", "tx.fhir.org");

    servers.put("https://tx.fhir.org/r2", "tx.fhir.org");
    servers.put("https://tx.fhir.org/r3", "tx.fhir.org");
    servers.put("https://tx.fhir.org/r4", "tx.fhir.org");
    servers.put("https://tx.fhir.org/r5", "tx.fhir.org");

    return servers;
  }

  public boolean hasValueSet(String canonical) {
    return vsCache.containsKey(canonical);
  }

  public boolean hasCodeSystem(String canonical) {
    return csCache.containsKey(canonical);
  }

  public SourcedValueSet getValueSet(String canonical) {
    SourcedValueSetEntry sp = vsCache.get(canonical);
    if (sp == null || folder == null) {
      return null;
    } else {
      try {
        return new SourcedValueSet(sp.getServer(), sp.getFilename() == null ? null : (ValueSet) new JsonParser().parse(ManagedFileAccess.inStream(Utilities.path(folder, sp.getFilename()))));
      } catch (Exception e) {
        return null;
      }
    }
  }

  public SourcedCodeSystem getCodeSystem(String canonical) {
    SourcedCodeSystemEntry sp = csCache.get(canonical);
    if (sp == null || folder == null) {
      return null;
    } else {
      try {
        return new SourcedCodeSystem(sp.getServer(), sp.getFilename() == null ? null : (CodeSystem) new JsonParser().parse(ManagedFileAccess.inStream(Utilities.path(folder, sp.getFilename()))));
      } catch (Exception e) {
        return null;
      }
    }
  }

  public void cacheValueSet(String canonical, SourcedValueSet svs) {
    if (canonical == null) {
      return;
    }
    try {
      if (svs == null) {
        vsCache.put(canonical, null);
      } else {
        String uuid = UUIDUtilities.makeUuidLC();
        String fn = "vs-"+uuid+".json";
        if (folder != null) {
          new JsonParser().compose(ManagedFileAccess.outStream(Utilities.path(folder, fn)), svs.getVs());
        }
        vsCache.put(canonical, new SourcedValueSetEntry(svs.getServer(), fn));
      }    
      org.hl7.fhir.utilities.json.model.JsonObject j = new org.hl7.fhir.utilities.json.model.JsonObject();
      for (String k : vsCache.keySet()) {
        SourcedValueSetEntry sve = vsCache.get(k);
        if (sve == null) {
          j.add(k, new JsonNull());
        } else {
          org.hl7.fhir.utilities.json.model.JsonObject e = new org.hl7.fhir.utilities.json.model.JsonObject();
          e.set("server", sve.getServer());
          if (sve.getFilename() != null) {
            e.set("filename", sve.getFilename());
          }
          j.add(k, e);
        }
      }
      if (folder != null) {
        org.hl7.fhir.utilities.json.parser.JsonParser.compose(j, ManagedFileAccess.file(Utilities.path(folder, "vs-externals.json")), true);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void cacheCodeSystem(String canonical, SourcedCodeSystem scs) {
    if (canonical == null) {
      return;
    }
    try {
      if (scs == null) {
        csCache.put(canonical, null);
      } else {
        String uuid = UUIDUtilities.makeUuidLC();
        String fn = "cs-"+uuid+".json";
        if (folder != null) {
          new JsonParser().compose(ManagedFileAccess.outStream(Utilities.path(folder, fn)), scs.getCs());
        }
        csCache.put(canonical, new SourcedCodeSystemEntry(scs.getServer(), fn));
      }    
      org.hl7.fhir.utilities.json.model.JsonObject j = new org.hl7.fhir.utilities.json.model.JsonObject();
      for (String k : csCache.keySet()) {
        SourcedCodeSystemEntry sve = csCache.get(k);
        if (sve == null) {
          j.add(k, new JsonNull());
        } else {
          org.hl7.fhir.utilities.json.model.JsonObject e = new org.hl7.fhir.utilities.json.model.JsonObject();
          e.set("server", sve.getServer());
          if (sve.getFilename() != null) {
            e.set("filename", sve.getFilename());
          }
          j.add(k, e);
        }
      }
      if (folder != null) {
        org.hl7.fhir.utilities.json.parser.JsonParser.compose(j, ManagedFileAccess.file(Utilities.path(folder, "cs-externals.json")), true);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public CacheToken generateSubsumesToken(ValidationOptions options, Coding parent, Coding child, Parameters expParameters) {
    try {
      CacheToken ct = new CacheToken();
      if (parent.hasSystem()) {
        ct.setName(parent.getSystem());
      }
      if (child.hasSystem()) {
        ct.setName(child.getSystem());
      }
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      String expJS = expParamsJson(json, expParameters);
      ct.request = "{\"op\": \"subsumes\", \"parent\" : "+json.composeString(parent, "code")+", \"child\" :"+json.composeString(child, "code")+(options == null ? "" : ", "+options.toJson())+", \"profile\": "+expJS+"}";
      ct.key = String.valueOf(hashJson(ct.request));
      return ct;
    } catch (IOException e) {
      throw new Error(e);
    }
  }

  public Boolean getSubsumes(CacheToken cacheToken) {
   if (cacheToken.key == null) {
     return null;
   }
   synchronized (lock) {
     requestCount++;
     NamedCache nc = getNamedCache(cacheToken);
     CacheEntry e = nc.map.get(cacheToken.key);
     if (e == null) {
       networkCount++;
       return null;
     } else {
       hitCount++;
       return e.s.result;
     }
   }
   
  }

  public void cacheSubsumes(CacheToken cacheToken, Boolean b, boolean persistent) {
    if (cacheToken.key != null) {
      synchronized (lock) {      
        NamedCache nc = getNamedCache(cacheToken);
        CacheEntry e = new CacheEntry();
        e.request = cacheToken.request;
        e.persistent = persistent;
        e.s = new SubsumesResult(b);
        store(cacheToken, persistent, nc, e);
      }    
    }
  }


  public String getReport() {
    int c = 0;
    for (NamedCache nc : caches.values()) {
      c += nc.list.size();
    }
    return "txCache report: "+
      c+" entries in "+caches.size()+" buckets + "+vsCache.size()+" VS, "+csCache.size()+" CS & "+serverMap.size()+" SM. Hitcount = "+hitCount+"/"+requestCount+", "+networkCount;
  }
}