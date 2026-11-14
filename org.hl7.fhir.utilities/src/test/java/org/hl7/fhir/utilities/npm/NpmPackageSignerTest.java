package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;
import java.util.List;

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

  private static String pkcs8Pem(KeyPair pair) {
    return "-----BEGIN PRIVATE KEY-----\n"
      + Base64.getMimeEncoder(64, "\n".getBytes(StandardCharsets.US_ASCII)).encodeToString(pair.getPrivate().getEncoded())
      + "\n-----END PRIVATE KEY-----\n";
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
  void loadsAPkcs8KeyAndWorksOutItsPublicKey() throws Exception {
    KeyPair pair = newKeyPair("secp256r1");
    NpmPackageSigner signer = NpmPackageSigner.fromPem(pkcs8Pem(pair));
    assertEquals(Base64.getEncoder().encodeToString(pair.getPublic().getEncoded()), signer.getPublicKey());
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

    VerifiedSignature v = NpmPackageSigner.verify(pkg, partner, trust(signer));
    assertEquals("example.fhir.signed", v.getName());
    assertEquals("1.0.0", v.getVersion());
    assertEquals(signer.getKeyId(), v.getKeyId());
    assertTrue(v.getSignedAt() != null);
  }

  @Test
  void readsPackagesWithDotSlashEntries() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    File pkg = write("package.tgz", tgz("./", "example.fhir.dotslash", "1.0.0"));
    assertEquals("example.fhir.dotslash", NpmPackageSigner.verify(pkg, signer.sign(pkg, null), trust(signer)).getName());
  }

  @Test
  void anUntrustedKeyFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    NpmPackageSigner other = NpmPackageSigner.fromPem(pkcs8Pem(newKeyPair("secp256r1")));
    assertNotEquals(signer.getKeyId(), other.getKeyId());
    File pkg = write("package.tgz", tgz("", "example.fhir.signed", "1.0.0"));
    File partner = signer.sign(pkg, null);
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(pkg, partner, trust(other)));
    assertTrue(e.getMessage().contains(signer.getKeyId()), e.getMessage());
    // a trusted key id with someone else's key is no better
    assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(pkg, partner, List.of(new SigningKey(signer.getKeyId(), other.getPublicKey()))));
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
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(other, partner, trust(signer)));
    assertTrue(e.getMessage().contains("sha512"), e.getMessage());
  }

  @Test
  void aSignatureForAnotherPackageFails() throws Exception {
    NpmPackageSigner signer = NpmPackageSigner.fromPem(OPENSSL_SEC1);
    byte[] content = tgz("", "example.fhir.signed", "1.0.0");
    JsonObject bundle = signer.createBundle(content, "example.fhir.signed", "1.0.1", null);
    PackageSignatureException e = assertThrows(PackageSignatureException.class, () -> NpmPackageSigner.verify(content, bundle, trust(signer)));
    assertTrue(e.getMessage().contains("pkg:npm/example.fhir.signed@1.0.0"), e.getMessage());
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
    NpmPackageSigner other = NpmPackageSigner.fromPem(pkcs8Pem(newKeyPair("secp256r1")));
    byte[] content = tgz("", "example.fhir.signed", "1.0.0");
    JsonObject bundle = signer.createBundle(content, "example.fhir.signed", "1.0.0", null);
    assertEquals(signer.getKeyId(), NpmPackageSigner.verify(content, bundle, trust(other, signer)).getKeyId());
  }
}
