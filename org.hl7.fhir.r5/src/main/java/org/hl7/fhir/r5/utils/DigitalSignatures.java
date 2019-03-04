package org.hl7.fhir.r5.utils;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
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
