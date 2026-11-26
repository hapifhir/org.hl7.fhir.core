package org.hl7.fhir.utilities.npm;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackageSigner.PackageSignatureException;
import org.hl7.fhir.utilities.npm.NpmPackageSigner.SigningKey;
import org.hl7.fhir.utilities.npm.NpmPackageSigner.VerifiedSignature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NpmPackageSignerTest {

  // made with: openssl ecparam -name prime256v1 -genkey -noout; its public key from
  // openssl ec -pubout -outform DER | base64
  private static final String OPENSSL_SEC1 = "-----BEGIN EC PRIVATE KEY-----\n"
    + "MHcCAQEEIPEgIL4aC9TFi0XJzShb2GNAtILZ8y8xOdMxpO2yXyLGoAoGCCqGSM49\n"
    + "AwEHoUQDQgAE+PZysQ6hndaxSux52XxpNztbOD4zettPu0PIn061s0NFlC/yYSDE\n"
    + "tSQ8a5bvnSYIEKQypUYda2LF09+1CiFKLQ==\n"
    + "-----END EC PRIVATE KEY-----\n";
  private static final String OPENSSL_PUBLIC = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE+PZysQ6hndaxSux52XxpNztbOD4zettPu0PIn061s0NFlC/yYSDEtSQ8a5bvnSYIEKQypUYda2LF09+1CiFKLQ==";

  @TempDir
  Path tmp;

  private static byte[] tgz(String prefix, String name, String version) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try (TarArchiveOutputStream tar = new TarArchiveOutputStream(new GzipCompressorOutputStream(out))) {
      addEntry(tar, prefix + "package/package.json", "{\"name\":\"" + name + "\",\"version\":\"" + version + "\",\"fhirVersions\":[\"4.0.1\"]}");
      addEntry(tar, prefix + "package/StructureDefinition-x.json", "{\"resourceType\":\"StructureDefinition\"}");
    }
    return out.toByteArray();
  }

  private static void addEntry(TarArchiveOutputStream tar, String name, String content) throws IOException {
    byte[] b = content.getBytes(StandardCharsets.UTF_8);
    TarArchiveEntry e = new TarArchiveEntry(name);
    e.setSize(b.length);
    tar.putArchiveEntry(e);
    tar.write(b);
    tar.closeArchiveEntry();
  }

  // as Java encodes it, which has no public key in it
  private static String pkcs8Pem(KeyPair pair) {
    return pem("PRIVATE KEY", pair.getPrivate().getEncoded());
  }

  private static String pem(String label, byte[] der) {
    return "-----BEGIN " + label + "-----\n"
      + Base64.getMimeEncoder(64, "\n".getBytes(StandardCharsets.US_ASCII)).encodeToString(der)
      + "\n-----END " + label + "-----\n";
  }

  private static byte[] der(int tag, byte[]... parts) {
    ByteArrayOutputStream content = new ByteArrayOutputStream();
    for (byte[] p : parts) {
      content.write(p, 0, p.length);
    }
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    b.write(tag);
    if (content.size() >= 0x80) {
      b.write(0x81);
    }
    b.write(content.size());
    b.write(content.toByteArray(), 0, content.size());
    return b.toByteArray();
  }

  // SEC1 ECPrivateKey, as openssl writes it, with a public key (the pair's, or another)
  private static byte[] sec1(KeyPair pair, KeyPair publicFrom) {
    byte[] d = ((ECPrivateKey) pair.getPrivate()).getS().toByteArray();
    byte[] d32 = new byte[32];
    System.arraycopy(d, Math.max(0, d.length - 32), d32, Math.max(0, 32 - d.length), Math.min(32, d.length));
    byte[] spki = publicFrom.getPublic().getEncoded();
    byte[] point = java.util.Arrays.copyOfRange(spki, spki.length - 65, spki.length);
    return der(0x30, new byte[] {2, 1, 1}, der(0x04, d32), der(0xa1, der(0x03, new byte[] {0}, point)));
  }

  // PKCS#8 holding a SEC1 key with its public key, as openssl genpkey writes it
  private static String opensslPkcs8Pem(KeyPair pair) {
    byte[] alg = Base64.getDecoder().decode("MBMGByqGSM49AgEGCCqGSM49AwEH");
    return pem("PRIVATE KEY", der(0x30, new byte[] {2, 1, 0}, alg, der(0x04, sec1(pair, pair))));
  }

  private static KeyPair newKeyPair(String curve) throws Exception {
    KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
    g.initialize(new ECGenParameterSpec(curve));
    return g.generateKeyPair();
  }

  private static List<SigningKey> trust(NpmPackageSigner... signers) {
    return java.util.Arrays.stream(signers).map(s -> new SigningKey(s.getKeyId(), s.getPublicKey())).toList();
  }

  private File write(String name, byte[] content) throws IOException {
    File f = tmp.resolve(name).toFile();
    Files.write(f.toPath(), content);
    return f;
  }

  @Test
  void loadsAPkcs8KeyAndReadsItsPublicKey() throws Exception {
    KeyPair pair = newKeyPair("secp256r1");
    NpmPackageSigner signer = NpmPackageSigner.fromPem(opensslPkcs8Pem(pair));
    assertEquals(Base64.getEncoder().encodeToString(pair.getPublic().getEncoded()), signer.getPublicKey());
    assertEquals(signer.getPublicKey(), NpmPackageSigner.fromPem(pem("EC PRIVATE KEY", sec1(pair, pair))).getPublicKey());
  }

  /** The public key is read from the key file, not worked out: a file without one, or with another key's, is refused */
  @Test
  void refusesAKeyFileWithoutItsPublicKey() throws Exception {
    KeyPair pair = newKeyPair("secp256r1");
    IOException e = assertThrows(IOException.class, () -> NpmPackageSigner.fromPem(pkcs8Pem(pair)));
    assertTrue(e.getMessage().contains("no public key"), e.getMessage());
    e = assertThrows(IOException.class, () -> NpmPackageSigner.fromPem(pem("EC PRIVATE KEY", sec1(pair, newKeyPair("secp256r1")))));
    assertTrue(e.getMessage().contains("not the private key's"), e.getMessage());
  }

  @Test
  void loadsAnOpensslSec1Key() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    assertEquals(OPENSSL_PUBLIC, signer.getPublicKey());
  }

  @Test
  void keyIdIsSha256OfThePublicKey() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] spki = Base64.getDecoder().decode(OPENSSL_PUBLIC);
    assertEquals("SHA256:" + Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(spki)), signer.getKeyId());
  }

  @Test
  void refusesOtherKeys() throws Exception {
    assertThrows(IOException.class, () -> NpmPackageSigner.fromPem(pkcs8Pem(newKeyPair("secp384r1"))));
    KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
    rsa.initialize(2048);
    assertThrows(IOException.class, () -> NpmPackageSigner.fromPem(pkcs8Pem(rsa.generateKeyPair())));
    assertThrows(IOException.class, () -> NpmPackageSigner.fromPem("-----BEGIN ENCRYPTED PRIVATE KEY-----\nAAAA\n-----END ENCRYPTED PRIVATE KEY-----\n"));
    assertThrows(IOException.class, () -> NpmPackageSigner.fromPem("not a key"));
  }

  @Test
  void paeIsDsseV1() {
    // the example in the DSSE protocol spec
    assertEquals("DSSEv1 29 http://example.com/HelloWorld 11 hello world",
      new String(NpmPackageSigner.pae("http://example.com/HelloWorld", "hello world".getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
  }

  @Test
  void purl() {
    assertEquals("pkg:npm/hl7.fhir.uv.ips@2.0.0", NpmPackageSigner.purl("hl7.fhir.uv.ips", "2.0.0"));
    assertEquals("pkg:npm/%40scope/name@1.0.0", NpmPackageSigner.purl("@scope/name", "1.0.0"));
  }

  @Test
  void signsAPackageWithAPartnerFileThatVerifies() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    File pkg = write("package.tgz", tgz("", "example.fhir.signed", "1.0.0"));
    File partner = signer.sign(pkg, "test 1.0");
    assertEquals(new File(tmp.toFile(), "package.tgz.sigstore.json").getAbsolutePath(), partner.getAbsolutePath());

    JsonObject bundle = JsonParser.parseObject(partner);
    assertEquals(NpmPackageSigner.BUNDLE_MEDIA_TYPE, bundle.asString("mediaType"));
    assertEquals(signer.getKeyId(), bundle.getJsonObject("verificationMaterial").getJsonObject("publicKey").asString("hint"));
    JsonObject statement = JsonParser.parseObject(Base64.getDecoder().decode(bundle.getJsonObject("dsseEnvelope").asString("payload")));
    assertEquals("pkg:npm/example.fhir.signed@1.0.0", statement.getJsonArray("subject").get(0).asJsonObject().asString("name"));
    assertEquals("test 1.0", statement.getJsonObject("predicate").asString("tool"));

    VerifiedSignature v = NpmPackageSigner.verify(pkg, partner, trust(signer), "example.fhir.signed", "1.0.0");
    assertEquals("example.fhir.signed", v.getName());
    assertEquals("1.0.0", v.getVersion());
    assertEquals(signer.getKeyId(), v.getKeyId());
    assertTrue(v.getSignedAt() != null);
  }

  @Test
  void readsPackagesWithDotSlashEntries() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    File pkg = write("package.tgz", tgz("./", "example.fhir.dotslash", "1.0.0"));
    assertEquals("example.fhir.dotslash", NpmPackageSigner.verify(pkg, signer.sign(pkg, null), trust(signer), "example.fhir.dotslash", "1.0.0").getName());
  }

  @Test
  void signsWithTheNameAndVersionGiven() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    File pkg = write("package.tgz", tgz("", "example.fhir.given", "2.0.0"));
    File partner = signer.sign(pkg, "example.fhir.given", "2.0.0", null);
    assertEquals("2.0.0", NpmPackageSigner.verify(pkg, partner, trust(signer), "example.fhir.given", "2.0.0").getVersion());
  }

  /** Checking a signature is a hash and a signature over the bytes: the package is never opened */
  @Test
  void verifyingDoesntOpenThePackage() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] notATgz = "these bytes are not a tgz at all".getBytes(StandardCharsets.UTF_8);
    JsonObject bundle = signer.createBundle(notATgz, "example.fhir.bytes", "1.0.0", null);
    VerifiedSignature v = NpmPackageSigner.verify(notATgz, bundle, trust(signer));
    assertEquals("example.fhir.bytes", v.getName());
    assertEquals("1.0.0", v.getVersion());
  }

  @Test
  void aPackageJsonOverOneMegabyteIsNotRead() throws Exception {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try (TarArchiveOutputStream tar = new TarArchiveOutputStream(new GzipCompressorOutputStream(out))) {
      addEntry(tar, "package/package.json", "{\"name\":\"" + "x".repeat(1100000) + "\"}");
    }
    assertThrows(NpmPackageSigner.NotAPackageException.class, () -> NpmPackageSigner.readPackageJson(out.toByteArray()));
  }

  @Test
  void anUntrustedKeyFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    NpmPackageSigner other = NpmPackageSigner.fromPem(opensslPkcs8Pem(newKeyPair("secp256r1")));
    assertNotEquals(signer.getKeyId(), other.getKeyId());
    File pkg = write("package.tgz", tgz("", "example.fhir.signed", "1.0.0"));
    File partner = signer.sign(pkg, null);
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(pkg, partner, trust(other), "example.fhir.signed", "1.0.0"));
    assertTrue(e.getMessage().contains(signer.getKeyId()), e.getMessage());
    // a trusted key id with someone else's key is no better
    assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(pkg, partner, List.of(new SigningKey(signer.getKeyId(), other.getPublicKey())), "example.fhir.signed", "1.0.0"));
  }

  @Test
  void otherContentFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    File pkg = write("package.tgz", tgz("", "example.fhir.signed", "1.0.0"));
    File partner = signer.sign(pkg, null);
    // the same package.json, other bytes
    byte[] changed = tgz("", "example.fhir.signed", "1.0.0");
    changed = java.util.Arrays.copyOf(changed, changed.length + 1);
    File other = write("other.tgz", changed);
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(other, partner, trust(signer), "example.fhir.signed", "1.0.0"));
    assertTrue(e.getMessage().contains("sha512"), e.getMessage());
  }

  @Test
  void aSignatureForAnotherPackageFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] content = tgz("", "example.fhir.signed", "1.0.0");
    JsonObject bundle = signer.createBundle(content, "example.fhir.signed", "1.0.1", null);
    // the signature is good, and says these bytes are 1.0.1: the caller loading 1.0.0 refuses it
    assertEquals("1.0.1", NpmPackageSigner.verify(content, bundle, trust(signer)).getVersion());
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(content, bundle, trust(signer), "example.fhir.signed", "1.0.0"));
    assertTrue(e.getMessage().contains("is for example.fhir.signed#1.0.1, not example.fhir.signed#1.0.0"), e.getMessage());
  }

  @Test
  void aChangedPayloadFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] content = tgz("", "example.fhir.signed", "1.0.0");
    JsonObject bundle = signer.createBundle(content, "example.fhir.signed", "1.0.0", "honest");
    JsonObject envelope = bundle.getJsonObject("dsseEnvelope");
    String payload = new String(Base64.getDecoder().decode(envelope.asString("payload")), StandardCharsets.UTF_8);
    envelope.set("payload", Base64.getEncoder().encodeToString(payload.replace("honest", "forged").getBytes(StandardCharsets.UTF_8)));
    assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(content, bundle, trust(signer)));
  }

  @Test
  void anyTrustedKeyWillDo() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    NpmPackageSigner other = NpmPackageSigner.fromPem(opensslPkcs8Pem(newKeyPair("secp256r1")));
    byte[] content = tgz("", "example.fhir.signed", "1.0.0");
    JsonObject bundle = signer.createBundle(content, "example.fhir.signed", "1.0.0", null);
    assertEquals(signer.getKeyId(), NpmPackageSigner.verify(content, bundle, trust(other, signer)).getKeyId());
  }

  /** S5: a statement of another kind (SLSA provenance, say) signed with the same key is not a package signature */
  @Test
  void anotherKindOfStatementFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] content = tgz("", "example.fhir.signed", "1.0.0");
    JsonObject bundle = signer.createBundle(content, "example.fhir.signed", "1.0.0", null);
    JsonObject envelope = bundle.getJsonObject("dsseEnvelope");
    JsonObject statement = JsonParser.parseObject(Base64.getDecoder().decode(envelope.asString("payload")));
    statement.set("predicateType", "https://slsa.dev/provenance/v1");
    envelope.set("payload", Base64.getEncoder().encodeToString(JsonParser.composeBytes(statement, false)));
    // (the predicateType is checked before the signature, which no longer matches the payload either)
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(content, bundle, trust(signer)));
    assertTrue(e.getMessage().contains("predicateType is https://slsa.dev/provenance/v1"), e.getMessage());
  }

  /** S3: a key is trusted to sign some packages, not all */
  @Test
  void aKeyOnlySignsThePackagesItIsTrustedFor() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] content = tgz("", "hl7.fhir.r4.core", "4.0.1");
    JsonObject bundle = signer.createBundle(content, "hl7.fhir.r4.core", "4.0.1", null);
    List<SigningKey> scoped = List.of(SigningKey.forPackages(signer.getKeyId(), signer.getPublicKey(), "example.*", "other.package"));
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(content, bundle, scoped));
    assertTrue(e.getMessage().contains("not trusted to sign it"), e.getMessage());
    assertTrue(scoped.get(0).mayPublish("example.fhir.x"));
    assertTrue(scoped.get(0).mayPublish("other.package"));
    assertFalse(scoped.get(0).mayPublish("other.package2"));
    assertEquals("hl7.fhir.r4.core", NpmPackageSigner.verify(content, bundle, List.of(SigningKey.forPackages(signer.getKeyId(), signer.getPublicKey(), "hl7.fhir.*"))).getName());
  }

  /** S3: the registry's keys are trusted for what their feed may publish (package-restrictions, the first that matches) */
  @Test
  void keysFromTheRegistryAreTrustedForTheirFeedsPackages() throws Exception {
    NpmPackageSigner hl7 = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    NpmPackageSigner other = NpmPackageSigner.fromPem(opensslPkcs8Pem(newKeyPair("secp256r1")));
    JsonObject registry = JsonParser.parseObject("{\"feeds\": ["
      + "{\"url\": \"http://hl7.org/fhir/package-feed.xml\", \"signing\": {\"keys\": [{\"keyid\": \"" + hl7.getKeyId() + "\", \"key\": \"" + hl7.getPublicKey() + "\"}]}},"
      + "{\"url\": \"https://example.org/package-feed.xml\", \"signing\": {\"keys\": [{\"keyid\": \"" + other.getKeyId() + "\", \"key\": \"" + other.getPublicKey() + "\"}]}},"
      + "{\"url\": \"https://unsigned.org/package-feed.xml\"}],"
      + "\"package-restrictions\": [{\"mask\": \"hl7.fhir.uv.example.*\", \"feeds\": [\"https://example.org/package-feed.xml\"]},"
      + "{\"mask\": \"hl7.*\", \"feeds\": [\"https://hl7.org/fhir/package-feed.xml\"]}]}");
    List<SigningKey> keys = NpmPackageSigner.keysFromRegistry(registry);
    assertEquals(2, keys.size());
    SigningKey hl7Key = keys.get(0);
    SigningKey otherKey = keys.get(1);
    assertTrue(hl7Key.mayPublish("hl7.fhir.r4.core"));
    assertFalse(hl7Key.mayPublish("hl7.fhir.uv.example.thing")); // the first restriction that matches names only example.org
    assertTrue(hl7Key.mayPublish("example.fhir.x")); // no restriction: any feed
    assertFalse(otherKey.mayPublish("hl7.fhir.r4.core"));
    assertTrue(otherKey.mayPublish("hl7.fhir.uv.example.thing"));
    assertTrue(otherKey.mayPublish("example.fhir.x"));

    byte[] content = tgz("", "hl7.fhir.r4.core", "4.0.1");
    assertEquals(hl7.getKeyId(), NpmPackageSigner.verify(content, hl7.createBundle(content, "hl7.fhir.r4.core", "4.0.1", null), keys).getKeyId());
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(content, other.createBundle(content, "hl7.fhir.r4.core", "4.0.1", null), keys));
    assertTrue(e.getMessage().contains("not trusted to sign it"), e.getMessage());
  }

  @Test
  void parsesPackageUrls() {
    assertEquals(List.of("hl7.fhir.uv.ips", "2.0.0"), List.of(NpmPackageSigner.parsePurl("pkg:npm/hl7.fhir.uv.ips@2.0.0")));
    assertEquals(List.of("@scope/name", "1.0.0-ballot"), List.of(NpmPackageSigner.parsePurl("pkg:npm/%40scope/name@1.0.0-ballot")));
    assertEquals(null, NpmPackageSigner.parsePurl("pkg:maven/x@1"));
    assertEquals(null, NpmPackageSigner.parsePurl("pkg:npm/noversion"));
  }
}
