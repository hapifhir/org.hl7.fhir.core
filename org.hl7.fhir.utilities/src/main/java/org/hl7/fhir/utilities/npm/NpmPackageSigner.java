package org.hl7.fhir.utilities.npm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.settings.FhirSettings;

/**
 * *** WARNING: This code is not well tested; it is based on the NPM provenance specification, which is itself not well tested ***
 *
 * Packages are signed in order to allow for the ecosystem to evaluate the use of signatures at this level
 * note that this is not the same as the normal NPM signatures, which are done by the repository.
 * The code to sign and/or verify may be changed at any time, and all the generated signatures may be rewritten
 * If you want to use this code, see the ongoing discussion at
 * https://chat.fhir.org/#narrow/channel/179239-tooling/topic/Package.20Content.20Differences.20from.20Registries/with/639550204
 *
 * Signs FHIR NPM packages, and checks those signatures.
 * <p/>
 * A signature is a partner file next to the package: {@code package.tgz} is signed by
 * {@code package.tgz.sigstore.json}. It is a Sigstore bundle (v0.3) holding a DSSE envelope, whose
 * payload is an in-toto statement with one subject, the package: its purl
 * ({@code pkg:npm/{name}@{version}}) and the sha512 of the .tgz. The signature is ECDSA P-256 with
 * SHA-256 (DER) over the DSSE pre-authentication encoding of the payload. The bundle names the key
 * by its key id ({@code verificationMaterial.publicKey.hint}): {@code SHA256:} and the base64 sha256
 * of the public key (SubjectPublicKeyInfo DER), as the npm registry names its keys.
 * <p/>
 * The bundle has no transparency log entry or timestamp, so general Sigstore tools won't accept it
 * as it is; who is trusted to sign what is decided by the package registry (the keys listed for
 * each feed in package-feeds.json, each trusted for the packages that feed may publish: see
 * {@link #keysFromRegistry}), and checked with {@link #verify}. Checking a signature doesn't open
 * the package: it is a hash and a signature over the bytes, and what the signature says the bytes
 * are (the name and version) is for the caller to compare with the package it is using.
 * <p/>
 * The signing key is configured in fhir-settings.json ({@code packageSigningKey}: the path of an
 * EC P-256 private key in PEM, PKCS#8 or SEC1). There is no default and no key is ever made: a
 * pipeline that signs has to be set up to.
 * <p/>
 * What a signature says is that the holder of the key published those bytes. It is over the bytes,
 * so a copy that is unpacked and packed again is no longer signed.
 */
public class NpmPackageSigner {

  public static final String SIGNATURE_SUFFIX = ".sigstore.json";
  public static final String BUNDLE_MEDIA_TYPE = "application/vnd.dev.sigstore.bundle.v0.3+json";
  public static final String PAYLOAD_TYPE = "application/vnd.in-toto+json";
  public static final String STATEMENT_TYPE = "https://in-toto.io/Statement/v1";
  public static final String PREDICATE_TYPE = "http://hl7.org/fhir/package-signature/v1";

  private static final String SIGNATURE_ALGORITHM = "SHA256withECDSA";
  private static final long MAX_PACKAGE_JSON = 1024 * 1024;
  // DER of the AlgorithmIdentifier for an EC P-256 key: id-ecPublicKey, prime256v1
  private static final byte[] EC_P256_ALGORITHM = hex("301306072a8648ce3d020106082a8648ce3d030107");

  /**
   * A key a verifier trusts: its key id, the public key (base64 SubjectPublicKeyInfo DER), and the
   * packages it is trusted to sign. Which packages is a list of package id masks (an id, or a
   * prefix ending in *), each one allowing or refusing, the first that matches deciding; when none
   * matches, whether the key may sign the package is the default.
   */
  public static class SigningKey {
    private final String keyId;
    private final String publicKey;
    private final List<String> masks = new ArrayList<>();
    private final List<Boolean> allowed = new ArrayList<>();
    private final boolean byDefault;

    /** A key trusted to sign any package */
    public SigningKey(String keyId, String publicKey) {
      this(keyId, publicKey, true);
    }

    private SigningKey(String keyId, String publicKey, boolean byDefault) {
      this.keyId = keyId;
      this.publicKey = publicKey;
      this.byDefault = byDefault;
    }

    /** A key trusted to sign only the packages that match one of the masks (an id, or a prefix ending in *) */
    public static SigningKey forPackages(String keyId, String publicKey, String... masks) {
      SigningKey key = new SigningKey(keyId, publicKey, false);
      for (String mask : masks) {
        key.rule(mask, true);
      }
      return key;
    }

    private SigningKey rule(String mask, boolean allow) {
      masks.add(mask);
      allowed.add(allow);
      return this;
    }

    public String getKeyId() {
      return keyId;
    }

    public String getPublicKey() {
      return publicKey;
    }

    /** Whether this key is trusted to sign the package with this id */
    public boolean mayPublish(String packageId) {
      for (int i = 0; i < masks.size(); i++) {
        if (matchesMask(packageId, masks.get(i))) {
          return allowed.get(i);
        }
      }
      return byDefault;
    }
  }

  /** A package id mask, as package-feeds.json has them: an id, or a prefix ending in * */
  static boolean matchesMask(String packageId, String mask) {
    int star = mask.indexOf('*');
    return star >= 0 ? packageId.startsWith(mask.substring(0, star)) : packageId.equals(mask);
  }

  /**
   * The keys the package registry (package-feeds.json) lists, each trusted to sign the packages its
   * feed may publish. A feed lists its keys in feeds[].signing.keys ({keyid, key}). A package that
   * matches a package-restrictions mask (the first that matches) may only be published by the feeds
   * that restriction names; one that matches none may be published by any feed. The key's
   * expiry (expires) is not checked here.
   */
  public static List<SigningKey> keysFromRegistry(JsonObject packageFeeds) {
    List<SigningKey> keys = new ArrayList<>();
    JsonArray feeds = packageFeeds.getJsonArray("feeds");
    JsonArray restrictions = packageFeeds.getJsonArray("package-restrictions");
    if (feeds == null) {
      return keys;
    }
    for (JsonObject feed : feeds.asJsonObjects()) {
      JsonObject signing = feed.getJsonObject("signing");
      JsonArray list = signing == null ? null : signing.getJsonArray("keys");
      if (list == null || feed.asString("url") == null) {
        continue;
      }
      String url = httpsOf(feed.asString("url"));
      for (JsonObject k : list.asJsonObjects()) {
        if (k.asString("keyid") == null || k.asString("key") == null) {
          continue;
        }
        SigningKey key = new SigningKey(k.asString("keyid"), k.asString("key"), true);
        if (restrictions != null) {
          for (JsonObject r : restrictions.asJsonObjects()) {
            JsonArray rfeeds = r.getJsonArray("feeds");
            if (r.asString("mask") != null && rfeeds != null) {
              boolean listed = false;
              for (String f : rfeeds.asStrings()) {
                listed = listed || url.equals(httpsOf(f));
              }
              key.rule(r.asString("mask"), listed);
            }
          }
        }
        keys.add(key);
      }
    }
    return keys;
  }

  private static String httpsOf(String url) {
    return url.startsWith("http:") ? "https:" + url.substring(5) : url;
  }

  /** What a good signature says */
  public static class VerifiedSignature {
    private final String name;
    private final String version;
    private final String keyId;
    private final String signedAt;

    VerifiedSignature(String name, String version, String keyId, String signedAt) {
      this.name = name;
      this.version = version;
      this.keyId = keyId;
      this.signedAt = signedAt;
    }

    public String getName() {
      return name;
    }

    public String getVersion() {
      return version;
    }

    public String getKeyId() {
      return keyId;
    }

    /** When the signer says it signed, or null: the signer's claim, not a trusted timestamp */
    public String getSignedAt() {
      return signedAt;
    }
  }

  /** A file that isn't a FHIR package: not a tgz, or no package/package.json with a name and version */
  public static class NotAPackageException extends IOException {
    public NotAPackageException(String message) {
      super(message);
    }
  }

  /** A signature that is missing something, or doesn't verify */
  public static class PackageSignatureException extends Exception {
    public PackageSignatureException(String message) {
      super(message);
    }
  }

  private final PrivateKey privateKey;
  private final String publicKey;
  private final String keyId;

  private NpmPackageSigner(ECPrivateKey privateKey, byte[] publicPoint) throws GeneralSecurityException {
    ECParameterSpec params = privateKey.getParams();
    if (params.getCurve().getField().getFieldSize() != 256 || !(params.getCurve().getField() instanceof ECFieldFp)
      || !P256_P.equals(((ECFieldFp) params.getCurve().getField()).getP())) {
      throw new GeneralSecurityException("A package signing key must be an EC P-256 (prime256v1) key");
    }
    this.privateKey = privateKey;
    // the public key is the one in the key file: SubjectPublicKeyInfo of id-ecPublicKey/prime256v1
    // and the point. KeyFactory refuses a point that isn't on the curve
    byte[] spki = der(0x30, concat(EC_P256_ALGORITHM, der(0x03, concat(new byte[] {0}, publicPoint))));
    KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(spki));
    this.publicKey = Base64.getEncoder().encodeToString(spki);
    this.keyId = keyIdOf(spki);
    // make sure the public key in the file really is this key's
    byte[] probe = "fhir package signing key check".getBytes(StandardCharsets.UTF_8);
    if (!verifySignature(publicKey, probe, signBytes(probe))) {
      throw new GeneralSecurityException("The public key in the key file is not the private key's");
    }
  }

  /**
   * The signer for the key configured in fhir-settings.json (packageSigningKey), or null if none
   * is configured. A key that is configured but missing or unusable is an error, not a reason to
   * carry on unsigned.
   */
  public static NpmPackageSigner fromSettings() throws IOException {
    if (!FhirSettings.hasPackageSigningKey()) {
      return null;
    }
    String path = FhirSettings.getPackageSigningKey();
    File file = new File(path);
    if (!file.exists()) {
      throw new IOException("The package signing key configured in " + FhirSettings.getFilePath() + " (packageSigningKey) was not found: " + path);
    }
    try {
      return load(file);
    } catch (IOException e) {
      throw new IOException("The package signing key configured in " + FhirSettings.getFilePath() + " (packageSigningKey) can't be used: " + e.getMessage(), e);
    }
  }

  /** Loads an EC P-256 private key from a PEM file: PKCS#8 (BEGIN PRIVATE KEY) or SEC1 (BEGIN EC PRIVATE KEY) */
  public static NpmPackageSigner load(File pemFile) throws IOException {
    return fromPem(new String(Files.readAllBytes(pemFile.toPath()), StandardCharsets.US_ASCII));
  }

  /**
   * Loads an EC P-256 private key from PEM: PKCS#8 (BEGIN PRIVATE KEY) or SEC1 (BEGIN EC PRIVATE KEY).
   * The key must carry its public key, as openssl writes them (openssl ecparam -name prime256v1
   * -genkey -noout, or openssl genpkey -algorithm EC -pkeyopt ec_paramgen_curve:P-256): the public
   * key is read from the file, not worked out from the private key
   */
  public static NpmPackageSigner fromPem(String pem) throws IOException {
    byte[] pkcs8;
    byte[] point;
    if (pem.contains("-----BEGIN PRIVATE KEY-----")) {
      pkcs8 = pemBody(pem, "PRIVATE KEY");
      point = publicPointOfPkcs8(pkcs8);
    } else if (pem.contains("-----BEGIN EC PRIVATE KEY-----")) {
      // SEC1, as openssl ecparam -genkey writes it: wrap it as PKCS#8
      byte[] sec1 = pemBody(pem, "EC PRIVATE KEY");
      pkcs8 = der(0x30, concat(hex("020100"), EC_P256_ALGORITHM, der(0x04, sec1)));
      point = publicPointOfSec1(sec1);
    } else if (pem.contains("-----BEGIN ENCRYPTED PRIVATE KEY-----")) {
      throw new IOException("The key is encrypted; a package signing key must not have a passphrase");
    } else {
      throw new IOException("Not a PEM private key (expected BEGIN PRIVATE KEY or BEGIN EC PRIVATE KEY)");
    }
    PrivateKey key;
    try {
      key = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(pkcs8));
    } catch (GeneralSecurityException | ClassCastException e) {
      throw new IOException("Not an EC P-256 private key: " + e.getMessage(), e);
    }
    if (point == null) {
      throw new IOException("The key file has no public key in it. Make the key with openssl (openssl ecparam -name prime256v1 -genkey -noout -out key.pem), which writes both");
    }
    try {
      return new NpmPackageSigner((ECPrivateKey) key, point);
    } catch (GeneralSecurityException | ClassCastException e) {
      throw new IOException("Not an EC P-256 private key: " + e.getMessage(), e);
    }
  }

  /** The key id: SHA256: and the base64 sha256 of the public key */
  public String getKeyId() {
    return keyId;
  }

  /** The public key, base64 SubjectPublicKeyInfo DER: what a registry lists for this key */
  public String getPublicKey() {
    return publicKey;
  }

  /**
   * Signs a package file, writing its partner file ({package}.tgz.sigstore.json) next to it. The
   * name and version are read from the package's package.json. tool says what signed it (e.g. the
   * IG Publisher and its version); it may be null. Returns the partner file.
   */
  public File sign(File tgz, String tool) throws IOException {
    JsonObject pj = readPackageJson(Files.readAllBytes(tgz.toPath()));
    String name = pj.asString("name");
    String version = pj.asString("version");
    if (name == null || version == null) {
      throw new NotAPackageException("Can't sign " + tgz + ": its package.json has no name or version");
    }
    return sign(tgz, name, version, tool);
  }

  /**
   * Signs a package file as the package name#version, writing its partner file next to it,
   * without opening the package: the caller knows what the package is. Returns the partner file.
   */
  public File sign(File tgz, String name, String version, String tool) throws IOException {
    byte[] content = Files.readAllBytes(tgz.toPath());
    File partner = new File(tgz.getAbsolutePath() + SIGNATURE_SUFFIX);
    JsonParser.compose(createBundle(content, name, version, tool), partner, true);
    return partner;
  }

  /** The signature bundle for a package's bytes */
  public JsonObject createBundle(byte[] tgz, String name, String version, String tool) throws IOException {
    JsonObject subject = new JsonObject();
    subject.add("name", purl(name, version));
    subject.add("digest", new JsonObject().add("sha512", sha512Hex(tgz)));
    JsonObject predicate = new JsonObject();
    if (tool != null) {
      predicate.add("tool", tool);
    }
    predicate.add("signedAt", Instant.now().toString());
    JsonObject statement = new JsonObject();
    statement.add("_type", STATEMENT_TYPE);
    statement.add("subject", new JsonArray().add(subject));
    statement.add("predicateType", PREDICATE_TYPE);
    statement.add("predicate", predicate);
    byte[] payload = JsonParser.composeBytes(statement, false);

    JsonObject sig = new JsonObject();
    sig.add("sig", Base64.getEncoder().encodeToString(signBytes(pae(PAYLOAD_TYPE, payload))));
    sig.add("keyid", keyId);
    JsonObject envelope = new JsonObject();
    envelope.add("payload", Base64.getEncoder().encodeToString(payload));
    envelope.add("payloadType", PAYLOAD_TYPE);
    envelope.add("signatures", new JsonArray().add(sig));

    JsonObject bundle = new JsonObject();
    bundle.add("mediaType", BUNDLE_MEDIA_TYPE);
    bundle.add("verificationMaterial", new JsonObject()
      .add("publicKey", new JsonObject().add("hint", keyId))
      .add("tlogEntries", new JsonArray()));
    bundle.add("dsseEnvelope", envelope);
    return bundle;
  }

  /**
   * Checks a package's signature bundle against the keys trusted to sign it, without opening the
   * package: the signature must be by one of the keys, over an in-toto statement of this kind
   * (predicateType), one of whose subjects is these bytes (their sha512), and the key must be
   * trusted to sign the package that subject names. Returns the name and version the signature
   * says these bytes are: a caller using the package must check they are the package's own (see
   * {@link #verify(byte[], JsonObject, List, String, String)}).
   */
  public static VerifiedSignature verify(byte[] tgz, JsonObject bundle, List<SigningKey> keys) throws PackageSignatureException {
    if (bundle.asString("mediaType") == null || !bundle.asString("mediaType").startsWith("application/vnd.dev.sigstore.bundle")) {
      throw new PackageSignatureException("Not a Sigstore bundle (mediaType is " + bundle.asString("mediaType") + ")");
    }
    JsonObject envelope = bundle.getJsonObject("dsseEnvelope");
    if (envelope == null) {
      throw new PackageSignatureException("The bundle has no dsseEnvelope");
    }
    if (!PAYLOAD_TYPE.equals(envelope.asString("payloadType"))) {
      throw new PackageSignatureException("The payload is not an in-toto statement (payloadType is " + envelope.asString("payloadType") + ")");
    }
    byte[] payload;
    try {
      payload = Base64.getDecoder().decode(envelope.asString("payload") == null ? "" : envelope.asString("payload"));
    } catch (IllegalArgumentException e) {
      throw new PackageSignatureException("The payload is not base64");
    }

    // what the statement says these bytes are (the signature over it is checked next)
    JsonObject statement;
    try {
      statement = JsonParser.parseObject(payload);
    } catch (Exception e) {
      throw new PackageSignatureException("The payload is not a JSON statement: " + e.getMessage());
    }
    if (!STATEMENT_TYPE.equals(statement.asString("_type"))) {
      throw new PackageSignatureException("The payload is not an in-toto v1 statement (_type is " + statement.asString("_type") + ")");
    }
    if (!PREDICATE_TYPE.equals(statement.asString("predicateType"))) {
      throw new PackageSignatureException("The statement is not a FHIR package signature (predicateType is " + statement.asString("predicateType") + ")");
    }
    String digest = sha512Hex(tgz);
    String purl = null;
    JsonArray subjects = statement.getJsonArray("subject");
    if (subjects != null) {
      for (JsonObject subject : subjects.asJsonObjects()) {
        JsonObject d = subject.getJsonObject("digest");
        if (purl == null && d != null && digest.equalsIgnoreCase(d.asString("sha512"))) {
          purl = subject.asString("name");
        }
      }
    }
    if (purl == null) {
      throw new PackageSignatureException("The signature is for different content: no subject's sha512 is the package's");
    }
    String[] nameAndVersion = parsePurl(purl);
    if (nameAndVersion == null) {
      throw new PackageSignatureException("The signature's subject is not an npm package (" + purl + ")");
    }

    // a signature by a key that is trusted, and trusted to sign this package
    String hint = bundle.has("verificationMaterial") && bundle.getJsonObject("verificationMaterial").has("publicKey")
      ? bundle.getJsonObject("verificationMaterial").getJsonObject("publicKey").asString("hint") : null;
    byte[] signed = pae(PAYLOAD_TYPE, payload);
    List<String> tried = new ArrayList<>();
    List<String> outOfScope = new ArrayList<>();
    JsonArray sigs = envelope.getJsonArray("signatures");
    if (sigs != null) {
      for (JsonObject sig : sigs.asJsonObjects()) {
        String keyid = sig.asString("keyid") != null && !sig.asString("keyid").isEmpty() ? sig.asString("keyid") : hint;
        tried.add(keyid);
        for (SigningKey key : findKeys(keys, keyid)) {
          boolean good;
          try {
            good = sig.asString("sig") != null && verifySignature(key.getPublicKey(), signed, Base64.getDecoder().decode(sig.asString("sig")));
          } catch (IllegalArgumentException | GeneralSecurityException e) {
            good = false; // not a valid signature
          }
          if (good && key.mayPublish(nameAndVersion[0])) {
            JsonObject predicate = statement.getJsonObject("predicate");
            return new VerifiedSignature(nameAndVersion[0], nameAndVersion[1], key.getKeyId(),
              predicate == null ? null : predicate.asString("signedAt"));
          } else if (good) {
            outOfScope.add(key.getKeyId());
          }
        }
      }
    }
    if (!outOfScope.isEmpty()) {
      throw new PackageSignatureException("The package " + nameAndVersion[0] + " is signed by " + String.join(", ", outOfScope) + ", which is not trusted to sign it");
    }
    throw new PackageSignatureException(tried.isEmpty() ? "The bundle has no signatures"
      : "No signature verifies against a trusted key (signed by " + String.join(", ", tried) + ")");
  }

  /**
   * As {@link #verify(byte[], JsonObject, List)}, and the signature must say the bytes are this
   * package: the name and version of the package as the caller loaded it
   */
  public static VerifiedSignature verify(byte[] tgz, JsonObject bundle, List<SigningKey> keys, String name, String version) throws PackageSignatureException {
    VerifiedSignature v = verify(tgz, bundle, keys);
    if (!v.getName().equals(name) || !v.getVersion().equals(version)) {
      throw new PackageSignatureException("The signature is for " + v.getName() + "#" + v.getVersion() + ", not " + name + "#" + version);
    }
    return v;
  }

  public static VerifiedSignature verify(File tgz, File bundle, List<SigningKey> keys, String name, String version) throws PackageSignatureException, IOException {
    return verify(Files.readAllBytes(tgz.toPath()), JsonParser.parseObject(bundle), keys, name, version);
  }

  /** The name and version in an npm package URL (pkg:npm/{name}@{version}), or null if it isn't one */
  static String[] parsePurl(String purl) {
    if (purl == null || !purl.startsWith("pkg:npm/")) {
      return null;
    }
    String rest = purl.substring(8);
    int at = rest.lastIndexOf('@');
    if (at <= 0 || at == rest.length() - 1) {
      return null;
    }
    String name = rest.substring(0, at);
    return new String[] {name.startsWith("%40") ? "@" + name.substring(3) : name, rest.substring(at + 1)};
  }

  /** The npm package URL of a package version: pkg:npm/{name}@{version}, with a scope's @ escaped */
  public static String purl(String name, String version) {
    return "pkg:npm/" + (name.startsWith("@") ? "%40" + name.substring(1) : name) + "@" + version;
  }

  /** The key id of a public key (SubjectPublicKeyInfo DER): SHA256: and its base64 sha256 */
  public static String keyIdOf(byte[] spki) {
    try {
      return "SHA256:" + Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(spki));
    } catch (GeneralSecurityException e) {
      throw new IllegalStateException(e);
    }
  }

  // DSSE pre-authentication encoding: "DSSEv1" SP LEN(type) SP type SP LEN(body) SP body
  static byte[] pae(String payloadType, byte[] payload) {
    byte[] type = payloadType.getBytes(StandardCharsets.UTF_8);
    String head = "DSSEv1 " + type.length + " " + payloadType + " " + payload.length + " ";
    return concat(head.getBytes(StandardCharsets.UTF_8), payload);
  }

  private byte[] signBytes(byte[] data) {
    try {
      Signature s = Signature.getInstance(SIGNATURE_ALGORITHM);
      s.initSign(privateKey);
      s.update(data);
      return s.sign();
    } catch (GeneralSecurityException e) {
      throw new IllegalStateException(e);
    }
  }

  private static boolean verifySignature(String publicKey, byte[] data, byte[] sig) throws GeneralSecurityException {
    PublicKey key = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
    Signature s = Signature.getInstance(SIGNATURE_ALGORITHM);
    s.initVerify(key);
    s.update(data);
    try {
      return s.verify(sig);
    } catch (java.security.SignatureException e) {
      return false; // a malformed signature
    }
  }

  // a registry can list the same key for more than one feed, each trusted for different packages
  private static List<SigningKey> findKeys(List<SigningKey> keys, String keyId) {
    List<SigningKey> found = new ArrayList<>();
    if (keyId != null && keys != null) {
      for (SigningKey k : keys) {
        if (keyId.equals(k.getKeyId())) {
          found.add(k);
        }
      }
    }
    return found;
  }

  /**
   * package/package.json from a .tgz; NotAPackageException if it isn't a readable tgz with one. For
   * signing a package file whose name and version the caller doesn't know; verifying never opens
   * the package. A package.json over 1 MB, or one not found within the decompressed size limit
   * ({@link NpmPackage#getDefaultMaxLoadSize()}), is refused
   */
  public static JsonObject readPackageJson(byte[] tgz) throws IOException {
    long read = 0;
    try (TarArchiveInputStream tar = new TarArchiveInputStream(new GzipCompressorInputStream(new ByteArrayInputStream(tgz)))) {
      TarArchiveEntry entry;
      while ((entry = tar.getNextEntry()) != null) {
        String n = entry.getName().replace('\\', '/');
        if (n.equals("package/package.json") || n.equals("./package/package.json")) {
          if (entry.getSize() > MAX_PACKAGE_JSON) {
            throw new NotAPackageException("Not a package: its package.json is more than 1 MB");
          }
          return JsonParser.parseObject(tar.readAllBytes());
        }
        read += entry.getSize();
        NpmPackage.checkLoadedSize(read, NpmPackage.getDefaultMaxLoadSize(), null);
      }
    } catch (NotAPackageException e) {
      throw e;
    } catch (IOException e) {
      throw new NotAPackageException("Not a readable .tgz: " + e.getMessage());
    }
    throw new NotAPackageException("Not a package: there is no package/package.json");
  }

  private static String sha512Hex(byte[] content) {
    try {
      byte[] d = MessageDigest.getInstance("SHA-512").digest(content);
      StringBuilder b = new StringBuilder();
      for (byte x : d) {
        b.append(String.format(Locale.ROOT, "%02x", x));
      }
      return b.toString();
    } catch (GeneralSecurityException e) {
      throw new IllegalStateException(e);
    }
  }

  private static byte[] pemBody(String pem, String label) throws IOException {
    String begin = "-----BEGIN " + label + "-----";
    String end = "-----END " + label + "-----";
    int s = pem.indexOf(begin);
    int e = pem.indexOf(end, s);
    if (s < 0 || e < 0) {
      throw new IOException("Not a PEM " + label);
    }
    try {
      return Base64.getMimeDecoder().decode(pem.substring(s + begin.length(), e));
    } catch (IllegalArgumentException ex) {
      throw new IOException("The PEM " + label + " is not valid base64");
    }
  }

  // --- DER --------------------------------------------------------------------------------------

  private static byte[] der(int tag, byte[] content) {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    b.write(tag);
    int len = content.length;
    if (len < 0x80) {
      b.write(len);
    } else if (len < 0x100) {
      b.write(0x81);
      b.write(len);
    } else {
      b.write(0x82);
      b.write(len >> 8);
      b.write(len & 0xff);
    }
    b.write(content, 0, content.length);
    return b.toByteArray();
  }

  private static byte[] concat(byte[]... parts) {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    for (byte[] p : parts) {
      b.write(p, 0, p.length);
    }
    return b.toByteArray();
  }

  private static byte[] hex(String s) {
    byte[] r = new byte[s.length() / 2];
    for (int i = 0; i < r.length; i++) {
      r[i] = (byte) Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
    }
    return r;
  }

  private static final BigInteger P256_P = new BigInteger("ffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);

  // --- the public key in the key file -------------------------------------------------------------
  // SEC1 ECPrivateKey: SEQUENCE { INTEGER 1, OCTET STRING d, [0] parameters OPTIONAL, [1] BIT STRING
  // publicKey OPTIONAL }. PKCS#8 PrivateKeyInfo: SEQUENCE { INTEGER, AlgorithmIdentifier, OCTET
  // STRING (the SEC1 ECPrivateKey), [0] attributes OPTIONAL, [1] publicKey OPTIONAL (v2) }. The
  // public key is the uncompressed point (04 x y), in the ECPrivateKey or the v2 PrivateKeyInfo

  private static byte[] publicPointOfPkcs8(byte[] pkcs8) throws IOException {
    List<byte[]> info = derSequence(pkcs8);
    if (info.size() < 3 || info.get(2)[0] != 0x04) {
      throw new IOException("Not a PKCS#8 private key");
    }
    byte[] point = publicPointOfSec1(derContent(info.get(2)));
    for (int i = 3; point == null && i < info.size(); i++) {
      if ((info.get(i)[0] & 0xff) == 0x81) { // [1] IMPLICIT BIT STRING
        point = pointOf(derContent(info.get(i)));
      }
    }
    return point;
  }

  private static byte[] publicPointOfSec1(byte[] sec1) throws IOException {
    for (byte[] item : derSequence(sec1)) {
      if ((item[0] & 0xff) == 0xa1) { // [1] EXPLICIT BIT STRING
        byte[] bitString = derContent(item);
        if (bitString.length == 0 || bitString[0] != 0x03) {
          throw new IOException("The key's public key is not a BIT STRING");
        }
        return pointOf(derContent(bitString));
      }
    }
    return null;
  }

  // a BIT STRING's content: no unused bits, then an uncompressed P-256 point
  private static byte[] pointOf(byte[] bits) throws IOException {
    if (bits.length != 66 || bits[0] != 0 || bits[1] != 0x04) {
      throw new IOException("The key's public key is not an uncompressed P-256 point");
    }
    return java.util.Arrays.copyOfRange(bits, 1, bits.length);
  }

  // the items (each a whole TLV) of a DER SEQUENCE
  private static List<byte[]> derSequence(byte[] der) throws IOException {
    if (der.length == 0 || der[0] != 0x30) {
      throw new IOException("Not a DER SEQUENCE");
    }
    byte[] content = derContent(der);
    List<byte[]> items = new ArrayList<>();
    int pos = 0;
    while (pos < content.length) {
      int len = derLength(content, pos);
      items.add(java.util.Arrays.copyOfRange(content, pos, pos + len));
      pos += len;
    }
    return items;
  }

  // the content of one DER TLV at the start of der
  private static byte[] derContent(byte[] der) throws IOException {
    int total = derLength(der, 0);
    int header = headerLength(der, 0);
    return java.util.Arrays.copyOfRange(der, header, total);
  }

  private static int headerLength(byte[] der, int pos) throws IOException {
    if (pos + 1 >= der.length) {
      throw new IOException("Truncated DER");
    }
    int b = der[pos + 1] & 0xff;
    return b < 0x80 ? 2 : 2 + (b & 0x7f);
  }

  // the length of the whole TLV (tag, length and content) at pos
  private static int derLength(byte[] der, int pos) throws IOException {
    int header = headerLength(der, pos);
    int b = der[pos + 1] & 0xff;
    long len;
    if (b < 0x80) {
      len = b;
    } else {
      int n = b & 0x7f;
      if (n == 0 || n > 3 || pos + header > der.length) {
        throw new IOException("Unsupported DER length");
      }
      len = 0;
      for (int i = 0; i < n; i++) {
        len = (len << 8) | (der[pos + 2 + i] & 0xff);
      }
    }
    if (pos + header + len > der.length) {
      throw new IOException("Truncated DER");
    }
    return (int) (header + len);
  }
}
