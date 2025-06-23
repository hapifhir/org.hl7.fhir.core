package org.hl7.fhir.validation.instance.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DigitalSignatureSupport {

  public static class SignedInfo {
    private String source;
    private byte[] signable;


    public SignedInfo(String source, byte[] signable) {
      super();
      this.source = source;
      this.signable = signable;
    }
    public String getSource() {
      return source;
    }
    public byte[] getSignable() {
      return signable;
    }

  }

  public static class DigitalSignatureWrapper {
    private Element doc;
    private Element contentReference;
    private Element xadesReference;

    public DigitalSignatureWrapper(Element doc) {
      super();
      this.doc = doc;      
    }

    public List<org.w3c.dom.Element> getDigSigReferences() {
      org.w3c.dom.Element sigInfo = XMLUtil.getNamedChild(doc, "SignedInfo");
      return XMLUtil.getNamedChildren(sigInfo, "Reference");
    }

    public String getDigSigSigned() {
      return XMLUtil.getNamedChildText(doc, "SignedBytes");
    }

    public String getDigSigAlg() {
      org.w3c.dom.Element sigInfo = XMLUtil.getNamedChild(doc, "SignedInfo");
      return XMLUtil.getNamedChildAttribute(sigInfo, "SignatureMethod", "Algorithm");
    }

    public String getDigSigSigValue() {
      return XMLUtil.getNamedChildText(doc, "SignatureValue");
    }

    public org.w3c.dom.Element getDigSigX509() {
      org.w3c.dom.Element keyInfo = XMLUtil.getNamedChild(doc, "KeyInfo");
      org.w3c.dom.Element x509Data = XMLUtil.getNamedChild(keyInfo, "X509Data");
      return XMLUtil.getNamedChild(x509Data, "X509Certificate");
    }

    public String getDigSigCanonicalization() {
      org.w3c.dom.Element sigInfo = XMLUtil.getNamedChild(doc, "SignedInfo");
      org.w3c.dom.Element ref = XMLUtil.getNamedChild(sigInfo, "Reference");
      org.w3c.dom.Element xforms = XMLUtil.getNamedChild(ref, "Transforms");
      return XMLUtil.getNamedChildAttribute(xforms, "Transform", "Algorithm");
    }

    public String getDigSigTime() {
      org.w3c.dom.Element object = XMLUtil.getNamedChild(doc, "Object");
      // try xades first
      org.w3c.dom.Element qualifyingProperties = XMLUtil.getNamedChild(object, "QualifyingProperties");
      org.w3c.dom.Element signedProperties = XMLUtil.getNamedChild(qualifyingProperties, "SignedProperties");
      org.w3c.dom.Element signedSignatureProperties = XMLUtil.getNamedChild(signedProperties, "SignedSignatureProperties");
      org.w3c.dom.Element signingTime = XMLUtil.getNamedChild(signedSignatureProperties, "SigningTime");
      if (signingTime != null) {
        return signingTime.getTextContent();
      }
      // fallback
      org.w3c.dom.Element signatureProperties = XMLUtil.getNamedChild(object, "SignatureProperties");
      org.w3c.dom.Element signatureProperty = XMLUtil.getNamedChild(signatureProperties, "SignatureProperty");
      return XMLUtil.getNamedChildText(signatureProperty, "SigningTime");
    }

    public Element getContentReference() {
      return contentReference;
    }

    public void setContentReference(Element contentReference) {
      this.contentReference = contentReference;
    }

    public Element getXadesReference() {
      return xadesReference;
    }

    public void setXadesReference(Element xadesReference) {
      this.xadesReference = xadesReference;
    }

    public Element getXadesSignable() {
      org.w3c.dom.Element object = XMLUtil.getNamedChild(doc, "Object");
      org.w3c.dom.Element qualifyingProperties = XMLUtil.getNamedChild(object, "QualifyingProperties");
      return XMLUtil.getNamedChild(qualifyingProperties, "SignedProperties");
    }

  }

  public static SignedInfo buildSignInfo(X509Certificate cert, byte[] signableSource, String canon, Instant instant, String name) throws NoSuchAlgorithmException, CertificateEncodingException, UnsupportedEncodingException, InvalidCanonicalizerException, CanonicalizationException, ParserConfigurationException, SAXException, IOException {

    byte[] xc = canonicalizeXml(new String(signableSource, StandardCharsets.UTF_8), "http://www.w3.org/TR/2001/REC-xml-c14n-20010315");

    // Calculate digest
    String digestB64 = getDigest(xc, name+"-source");

    String algorithm = cert.getPublicKey().getAlgorithm();
    String signatureMethod = "RSA".equals(algorithm) ? 
        "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256" :
          "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256";

    StringBuilder signedInfo = new StringBuilder();
    signedInfo.append("  <SignedInfo xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n");
    signedInfo.append("    <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n");
    signedInfo.append("    <SignatureMethod Algorithm=\"").append(signatureMethod).append("\"/>\n");
    signedInfo.append("    <Reference URI=\"#\">\n");
    signedInfo.append("      <Transforms>\n");
    signedInfo.append("        <Transform Algorithm=\""+canon+"\"/>\n");
    signedInfo.append("      </Transforms>\n");
    signedInfo.append("      <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n");
    signedInfo.append("      <DigestValue>").append(digestB64).append("</DigestValue>\n");
    signedInfo.append("    </Reference>\n");
    if (instant != null) {
      // XAdES support
      StringBuilder xades = new StringBuilder();
      xades.append("<x:SignedProperties xmlns:x=\"http://uri.etsi.org/01903/v1.3.2#\" Id=\"SignedProperties\">");
      xades.append("<x:SignedSignatureProperties>");
      xades.append("<x:SigningTime>"+DateTimeFormatter.ISO_INSTANT.format(instant)+"</x:SigningTime>");
      xades.append("</x:SignedSignatureProperties>");
      xades.append("</x:SignedProperties>");
      byte[] xxc = canonicalizeXml(xades.toString(), "http://www.w3.org/2001/10/xml-exc-c14n#");
      String xadesB64 = getDigest(xxc, name+"-xades");
      signedInfo.append("    <Reference Type=\"http://uri.etsi.org/01903#SignedProperties\" URI=\"#SignedProperties\">\n");
      signedInfo.append("      <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n");
      signedInfo.append("      <DigestValue>").append(xadesB64).append("</DigestValue>\n");
      signedInfo.append("    </Reference>\n");
    }
    signedInfo.append("  </SignedInfo>\n");

    // Canonicalize the SignedInfo (in this simple case, just get bytes)
    byte[] signedInfoBytes = canonicalizeXml(signedInfo.toString(), "http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
    return new SignedInfo(signedInfo.toString(), signedInfoBytes);
  }

  public static String getDigest(byte[] xc, String name) throws NoSuchAlgorithmException {
    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
    byte[] digestValue = sha256.digest(xc);
    String digestB64 = java.util.Base64.getEncoder().encodeToString(digestValue);
    return digestB64;
  }

  public static byte[] canonicalizeXml(String xmlString, String canonMethod) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException, InvalidCanonicalizerException, CanonicalizationException {
    // Initialize Apache Santuario (only needed once)
    if (!org.apache.xml.security.Init.isInitialized()) {
      org.apache.xml.security.Init.init();
    }

    // Parse XML
    DocumentBuilderFactory dbf = XMLUtil.newXXEProtectedDocumentBuilderFactory();
    dbf.setNamespaceAware(true);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));

    // Create canonicalizer
    org.apache.xml.security.c14n.Canonicalizer canonicalizer = 
        org.apache.xml.security.c14n.Canonicalizer.getInstance(canonMethod);

    // Canonicalize the document element
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    canonicalizer.canonicalizeSubtree(doc.getDocumentElement(), ba);
    ba.close();
    return ba.toByteArray();
  }

  public static byte[] canonicalizeXml(Element xml, String canonMethod) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException, InvalidCanonicalizerException, CanonicalizationException {
    // Initialize Apache Santuario (only needed once)
    if (!org.apache.xml.security.Init.isInitialized()) {
      org.apache.xml.security.Init.init();
    }

    // Create canonicalizer
    org.apache.xml.security.c14n.Canonicalizer canonicalizer = 
        org.apache.xml.security.c14n.Canonicalizer.getInstance(canonMethod);

    // Canonicalize the document element
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    canonicalizer.canonicalizeSubtree(xml, ba);
    ba.close();
    return ba.toByteArray();
  }

  public static SignedInfo buildSignInfoXades(X509Certificate cert, byte[] signableSource, String canon, byte[] xades, String name) throws CertificateEncodingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidCanonicalizerException, CanonicalizationException, ParserConfigurationException, SAXException, IOException, TransformerException {
    if (xades == null) {
      return buildSignInfo(cert, signableSource, canon, null, name);
    } else {

      byte[] xc = canonicalizeXml(new String(signableSource, StandardCharsets.UTF_8), "http://www.w3.org/TR/2001/REC-xml-c14n-20010315");

      // Calculate digest
      String digestB64 = getDigest(xc, name+"-source");

      String algorithm = cert.getPublicKey().getAlgorithm();
      String signatureMethod = "RSA".equals(algorithm) ? 
          "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256" :
            "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha256";

      StringBuilder signedInfo = new StringBuilder();
      signedInfo.append("  <SignedInfo xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n");
      signedInfo.append("    <CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>\n");
      signedInfo.append("    <SignatureMethod Algorithm=\"").append(signatureMethod).append("\"/>\n");
      signedInfo.append("    <Reference URI=\"#\">\n");
      signedInfo.append("      <Transforms>\n");
      signedInfo.append("        <Transform Algorithm=\""+canon+"\"/>\n");
      signedInfo.append("      </Transforms>\n");
      signedInfo.append("      <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n");
      signedInfo.append("      <DigestValue>").append(digestB64).append("</DigestValue>\n");
      signedInfo.append("    </Reference>\n");

      String xadesB64 = getDigest(xades, name+"-xades");
      signedInfo.append("    <Reference Type=\"http://uri.etsi.org/01903#SignedProperties\" URI=\"#SignedProperties\">\n");
      signedInfo.append("      <DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\"/>\n");
      signedInfo.append("      <DigestValue>").append(xadesB64).append("</DigestValue>\n");
      signedInfo.append("    </Reference>\n");

      signedInfo.append("  </SignedInfo>\n");

      // Canonicalize the SignedInfo (in this simple case, just get bytes)
      byte[] signedInfoBytes = canonicalizeXml(signedInfo.toString(), "http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
      return new SignedInfo(signedInfo.toString(), signedInfoBytes);
    }
  }


}
