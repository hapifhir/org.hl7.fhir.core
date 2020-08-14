package org.hl7.fhir.r5.utils;

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
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hl7.fhir.utilities.xml.XmlGenerator;
import org.w3c.dom.Document;

public class DigitalSignatures {

  public static PrivateKey getPrivateKey(String filename) throws Exception {

    byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

    PKCS8EncodedKeySpec spec =
        new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePrivate(spec);
  }

  public static PublicKey getPublicKey(String filename) throws Exception {

    byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePublic(spec);
  }

  public static void main(String[] args) throws Exception {
    // http://docs.oracle.com/javase/7/docs/technotes/guides/security/xmldsig/XMLDigitalSignature.html
    //
    byte[] inputXml = "<Envelope xmlns=\"urn:envelope\">\r\n</Envelope>\r\n".getBytes();
    // load the document that's going to be signed
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
    dbf.setNamespaceAware(true);
    DocumentBuilder builder = dbf.newDocumentBuilder();  
    Document doc = builder.parse(new ByteArrayInputStream(inputXml)); 
    
//    // create a key pair
//    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
//    kpg.initialize(512);
//    KeyPair kp = kpg.generateKeyPair(); 
    PublicKey pub = getPublicKey("C:\\work\\fhirserver\\tests\\signatures\\public_key.der");
    PrivateKey priv = getPrivateKey("C:\\work\\fhirserver\\tests\\signatures\\private_key.der");
    
    // sign the document
    DOMSignContext dsc = new DOMSignContext(priv, doc.getDocumentElement()); 
    XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM"); 
   
    Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null), Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null, null);
    SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
    
    KeyInfoFactory kif = fac.getKeyInfoFactory(); 
    KeyValue kv = kif.newKeyValue(pub);
    KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));
    XMLSignature signature = fac.newXMLSignature(si, ki); 
    signature.sign(dsc);
    
    OutputStream os = new FileOutputStream("c:\\temp\\java-digsig.xml");
    new XmlGenerator().generate(doc.getDocumentElement(), os);
  }
}