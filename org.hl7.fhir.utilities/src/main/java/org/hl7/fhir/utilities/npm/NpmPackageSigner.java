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
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
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
 * each feed in package-feeds.json), and checked with {@link #verify}.
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
  // DER of the AlgorithmIdentifier for an EC P-256 key: id-ecPublicKey, prime256v1
  private static final byte[] EC_P256_ALGORITHM = hex("301306072a8648ce3d020106082a8648ce3d030107");

  /** A key a verifier trusts: its key id, and the public key (base64 SubjectPublicKeyInfo DER) */
  public static class SigningKey {
    private final String keyId;
    private final String publicKey;

    public SigningKey(String keyId, String publicKey) {
      this.keyId = keyId;
      this.publicKey = publicKey;
    }

    public String getKeyId() {
      return keyId;
    }

    public String getPublicKey() {
      return publicKey;
    }
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

  private NpmPackageSigner(ECPrivateKey privateKey) throws GeneralSecurityException {
    ECParameterSpec params = privateKey.getParams();
    if (params.getCurve().getField().getFieldSize() != 256 || !(params.getCurve().getField() instanceof ECFieldFp)
      || !P256_P.equals(((ECFieldFp) params.getCurve().getField()).getP())) {
      throw new GeneralSecurityException("A package signing key must be an EC P-256 (prime256v1) key");
    }
    this.privateKey = privateKey;
    ECPoint q = multiply(params, privateKey.getS());
    byte[] spki = KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(q, params)).getEncoded();
    this.publicKey = Base64.getEncoder().encodeToString(spki);
    this.keyId = keyIdOf(spki);
    // make sure the public key really is this key's
    byte[] probe = "fhir package signing key check".getBytes(StandardCharsets.UTF_8);
    if (!verifySignature(publicKey, probe, signBytes(probe))) {
      throw new GeneralSecurityException("Could not work out the public key of the package signing key");
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

  public static NpmPackageSigner fromPem(String pem) throws IOException {
    byte[] pkcs8;
    if (pem.contains("-----BEGIN PRIVATE KEY-----")) {
      pkcs8 = pemBody(pem, "PRIVATE KEY");
    } else if (pem.contains("-----BEGIN EC PRIVATE KEY-----")) {
      // SEC1, as openssl ecparam -genkey writes it: wrap it as PKCS#8
      pkcs8 = der(0x30, concat(hex("020100"), EC_P256_ALGORITHM, der(0x04, pemBody(pem, "EC PRIVATE KEY"))));
    } else if (pem.contains("-----BEGIN ENCRYPTED PRIVATE KEY-----")) {
      throw new IOException("The key is encrypted; a package signing key must not have a passphrase");
    } else {
      throw new IOException("Not a PEM private key (expected BEGIN PRIVATE KEY or BEGIN EC PRIVATE KEY)");
    }
    try {
      PrivateKey key = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(pkcs8));
      return new NpmPackageSigner((ECPrivateKey) key);
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
    byte[] content = Files.readAllBytes(tgz.toPath());
    JsonObject pj = readPackageJson(content);
    String name = pj.asString("name");
    String version = pj.asString("version");
    if (name == null || version == null) {
      throw new NotAPackageException("Can't sign " + tgz + ": its package.json has no name or version");
    }
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
   * Checks a package's signature bundle against the keys trusted to sign it: the signature must be
   * by one of them, over a statement whose subject is these bytes and the name and version in the
   * package's own package.json.
   */
  public static VerifiedSignature verify(byte[] tgz, JsonObject bundle, List<SigningKey> keys) throws PackageSignatureException, IOException {
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
    String hint = bundle.has("verificationMaterial") && bundle.getJsonObject("verificationMaterial").has("publicKey")
      ? bundle.getJsonObject("verificationMaterial").getJsonObject("publicKey").asString("hint") : null;

    // a signature by a trusted key
    byte[] signed = pae(PAYLOAD_TYPE, payload);
    String signedBy = null;
    List<String> tried = new ArrayList<>();
    JsonArray sigs = envelope.getJsonArray("signatures");
    if (sigs != null) {
      for (JsonObject sig : sigs.asJsonObjects()) {
        String keyid = sig.asString("keyid") != null && !sig.asString("keyid").isEmpty() ? sig.asString("keyid") : hint;
        tried.add(keyid);
        SigningKey key = findKey(keys, keyid);
        if (key != null && sig.asString("sig") != null) {
          try {
            if (verifySignature(key.getPublicKey(), signed, Base64.getDecoder().decode(sig.asString("sig")))) {
              signedBy = key.getKeyId();
              break;
            }
          } catch (IllegalArgumentException | GeneralSecurityException e) {
            // not a valid signature; try the next
          }
        }
      }
    }
    if (signedBy == null) {
      throw new PackageSignatureException(tried.isEmpty() ? "The bundle has no signatures"
        : "No signature verifies against a trusted key (signed by " + String.join(", ", tried) + ")");
    }

    // of these bytes, as this package
    JsonObject statement;
    try {
      statement = JsonParser.parseObject(payload);
    } catch (Exception e) {
      throw new PackageSignatureException("The payload is not a JSON statement: " + e.getMessage());
    }
    if (!STATEMENT_TYPE.equals(statement.asString("_type"))) {
      throw new PackageSignatureException("The payload is not an in-toto v1 statement (_type is " + statement.asString("_type") + ")");
    }
    JsonObject pj = readPackageJson(tgz);
    String expected = purl(pj.asString("name"), pj.asString("version"));
    String digest = sha512Hex(tgz);
    JsonArray subjects = statement.getJsonArray("subject");
    boolean named = false;
    if (subjects != null) {
      for (JsonObject subject : subjects.asJsonObjects()) {
        if (expected.equals(subject.asString("name"))) {
          named = true;
          JsonObject d = subject.getJsonObject("digest");
          if (d != null && digest.equalsIgnoreCase(d.asString("sha512"))) {
            JsonObject predicate = statement.getJsonObject("predicate");
            return new VerifiedSignature(pj.asString("name"), pj.asString("version"), signedBy,
              predicate == null ? null : predicate.asString("signedAt"));
          }
        }
      }
    }
    throw new PackageSignatureException(named ? "The signature is for different content: the package's sha512 doesn't match"
      : "The signature is not for " + expected);
  }

  public static VerifiedSignature verify(File tgz, File bundle, List<SigningKey> keys) throws PackageSignatureException, IOException {
    return verify(Files.readAllBytes(tgz.toPath()), JsonParser.parseObject(bundle), keys);
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

  private static SigningKey findKey(List<SigningKey> keys, String keyId) {
    if (keyId == null || keys == null) {
      return null;
    }
    for (SigningKey k : keys) {
      if (keyId.equals(k.getKeyId())) {
        return k;
      }
    }
    return null;
  }

  /** package/package.json from a .tgz; NotAPackageException if it isn't a readable tgz with one */
  public static JsonObject readPackageJson(byte[] tgz) throws IOException {
    try (TarArchiveInputStream tar = new TarArchiveInputStream(new GzipCompressorInputStream(new ByteArrayInputStream(tgz)))) {
      TarArchiveEntry entry;
      while ((entry = tar.getNextEntry()) != null) {
        String n = entry.getName().replace('\\', '/');
        if (n.equals("package/package.json") || n.equals("./package/package.json")) {
          return JsonParser.parseObject(tar.readAllBytes());
        }
      }
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

  // --- the public key: d * G on P-256 -------------------------------------------------------------
  // Java has no API that derives an EC public key from the private one. This runs once, when the
  // key is loaded, on the signing machine.

  private static final BigInteger P256_P = new BigInteger("ffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);

  private static ECPoint multiply(ECParameterSpec params, BigInteger k) {
    BigInteger p = ((ECFieldFp) params.getCurve().getField()).getP();
    BigInteger a = params.getCurve().getA();
    ECPoint result = ECPoint.POINT_INFINITY;
    ECPoint addend = params.getGenerator();
    for (int i = 0; i < k.bitLength(); i++) {
      if (k.testBit(i)) {
        result = add(result, addend, p, a);
      }
      addend = add(addend, addend, p, a);
    }
    return result;
  }

  private static ECPoint add(ECPoint P, ECPoint Q, BigInteger p, BigInteger a) {
    if (P.equals(ECPoint.POINT_INFINITY)) {
      return Q;
    }
    if (Q.equals(ECPoint.POINT_INFINITY)) {
      return P;
    }
    BigInteger lambda;
    if (P.getAffineX().equals(Q.getAffineX())) {
      if (P.getAffineY().add(Q.getAffineY()).mod(p).signum() == 0) {
        return ECPoint.POINT_INFINITY;
      }
      BigInteger x = P.getAffineX();
      lambda = x.pow(2).multiply(BigInteger.valueOf(3)).add(a).multiply(P.getAffineY().shiftLeft(1).modInverse(p)).mod(p);
    } else {
      lambda = Q.getAffineY().subtract(P.getAffineY()).multiply(Q.getAffineX().subtract(P.getAffineX()).modInverse(p)).mod(p);
    }
    BigInteger x3 = lambda.pow(2).subtract(P.getAffineX()).subtract(Q.getAffineX()).mod(p);
    BigInteger y3 = lambda.multiply(P.getAffineX().subtract(x3)).subtract(P.getAffineY()).mod(p);
    return new ECPoint(x3, y3);
  }
}
