package org.hl7.fhir.r5.elementmodel;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Test;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.util.Base64URL;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;



public class SignatureTest {

  private static final String JWKS_JSON = "{\n"
      + "    \"p\": \"93dPpZDAt7KN7OdwForp4Xr9q3FU23gUO9Ate_uoc7liaB7CNxKZVE5ZKJ33p_bczIAKzeuQjxSCgR8LXFT6uvHUuCH8oxBXC182EWlWljhbselqCGN7YQShSM7suSeVzif6CXUeafsR-XcBERxHHy5dSoh5zYq7JRdARzZCg78\",\n"
      + "    \"kty\": \"RSA\",\n"
      + "    \"q\": \"ku2zF8DQrfiXBuzlk0KC_xJGDKQfb07VEidzFYE1C-uBRqQytTlT6BGTF90UDcsZ_CjD3x6dp78Ec13GbF_WVzzZNrjIMsVSEC5dPsXdheLqdKLt8fRG35-hLl3DwYu6d55vVhDbP-QAfRE60bX0yScMkBjP20O_0mpUJjCDoas\",\n"
      + "    \"d\": \"DHy_h_C-zhPhPg7dvUJJc3HvnLtuQxCD_215WqJBrOZ6cbZX1Cwd6cp2QVEK7p5U4jbHdZpsKuRLQKDlpkSqjxNiVRmP8_5MHzs0oi7m40OKdOQ8HTw39lhTxzJx9XT2VWEdXwYwyNM9tGYcnml61fiBXHqXt-DSXpNkGrf1fht2fQacTF7oFG28VVWrGbAiitcir5JdAUW3MpZjSgWra3P3H7Dku_AjO_XfT5WGGpiUeXUEqLQxWjVSxZSonKgRmuKE3snaDUNJzd66k0Cvjm4irFtb0owJC0LZf9nVzkF-uqWeEIBzDXGDK604vLhWj6cCMYRvvgQnw5hlG6PSWQ\",\n"
      + "    \"e\": \"AQAB\",\n"
      + "    \"use\": \"sig\",\n"
      + "    \"kid\": \"K_E0WTm6hVrXvYFrK4hJjF0etvhRsh0LAPUFsS6gzKg\",\n"
      + "    \"qi\": \"KZXSpxETiz4ILyxzwI_pMIm1E8P0cMaMuDjoTy2IvClgdkCBBcFZ0W37hOMXaoIM5Hy72uYydV1lljYGMwc8_VQMZLh_22xSSFJnV8PPjTzW5do4ryfizJUg52AsPBhNn_i6pa2L5jkmb98muD2HbDHXOFCEV57YuEEiSWRVCJA\",\n"
      + "    \"dp\": \"xTFWz0jkuLzYqWHXCK-TJTD7eKUriGNMRElkJTrpBaZBC1UPUBFLC0oPc_VExpxJX8_cTDCdFdazE68oP2AcF-HirwOuLEY2BoLNM9yrubKZJtEnxB150Fp_JuR08CniDs_-R5EDNlJyBUbWG8tbxTYN8vmDjc0xyaGYf-Z15EM\",\n"
      + "    \"alg\": \"RS256\",\n"
      + "    \"dq\": \"Dtrdeo9SCeTSUC7vXx4gZG2Si4CkdPqBbF50sj3oARaEcYH0ZoIvS41LU-RUPLjGHcp5UzujMOyNJKTchOSDpTpPs8qm4ws0KtKlNs2GghzZG4XFjOrnp4BaKXftbMoVxjZMh2UY5bLFod92FPHSl-vMx1za1w5YfIunilzpUhU\",\n"
      + "    \"n\": \"jgfSAIuhDB14fR3vp9qfT4AuJaIfCJCehSy69kwTguUMARntGJx7mPD8K1Te10Uywx4E_je0LHMT2zgrrlp-hbqTWR6z6vOnYzl8MkXj1uC1pSEC0eXAUFcs2igJl6H6mEc1aOv_mdB8B6I2DIiKmBh-wVpgnA8HK7UfdercdbJOQmem-FG0uP98_CSiCw8NpWtq5ci7nEqf_ylneeL7pqOkQtL_huDZCShgW0WK7vTgYtp_zHZH0OQ17WCWYdqAaJ7Q964JPnvWYlNEMA8uSH0z5hd5lVTC4FKr5gSGFAyEg99RwXGw4usJjmHvhnxi9RJ_7elN7MbAwi_ITgYflQ\"\n"
      + "}";

  @Test
  void testSignature() {
    assertDoesNotThrow(() -> {
      IWorkerContext context = TestingUtilities.getSharedWorkerContext();
      Element bnd = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("r5", "bundle-resource-element-test.json"), FhirFormat.JSON);
      ByteArrayOutputStream ba = new ByteArrayOutputStream();
      Manager.compose(context, bnd, ba, FhirFormat.JSON, OutputStyle.CANONICAL, null);
      byte[] toSign = ba.toByteArray();

      Element sig = bnd.addElement("signature");
      sig.setChildValue("targetFormat", "application/fhir+json");
      sig.setChildValue("sigFormat", "application/jose");
      sig.setChildValue("data", createJWSWithNimbus(toSign, loadJWKFromJWKS(JWKS_JSON), "http://hl7.org/fhir/canonicalization/json"));

      FileOutputStream f = new FileOutputStream(ManagedFileAccess.file(Utilities.path("[tmp]", "signed-bundle.json")));
      Manager.compose(context, bnd, f, FhirFormat.JSON, OutputStyle.PRETTY, null);
      f.close();
    });
  }

  public JWK loadJWKFromJWKS(String jwksJson) throws ParseException{
    return JWK.parse(jwksJson);
  }

  public String createJWSWithNimbus(byte[] canon, JWK key, Object canonMethod) throws JOSEException {
    // Create JWS header
    JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
        .type(JOSEObjectType.JOSE)
        .customParam("canon", canonMethod) 
        .build();

    // Create payload from bytes
    Payload payload = new Payload(Base64URL.encode(canon));

    // Create JWS object
    JWSObject jwsObject = new JWSObject(header, payload);

    // Create signer based on key type
    JWSSigner signer;
    if (key.getKeyType().toString().equals("RSA")) {
      signer = new RSASSASigner(key.toRSAKey());
    } else if (key.getKeyType().toString().equals("EC")) {
      signer = new ECDSASigner(key.toECKey());
    } else {
      throw new IllegalArgumentException("Unsupported key type: " + key.getKeyType());
    }

    // Sign the JWS
    jwsObject.sign(signer);

    // Return compact serialization
    return jwsObject.serialize();
  }

  
}
