package org.hl7.fhir.validation.instance.utils;

import java.io.*;
import java.nio.file.*;
import java.security.cert.*;
import java.security.KeyStore;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import com.nimbusds.jose.jwk.*;
import com.nimbusds.jose.util.X509CertUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CertificateScanner {
    
    /**
     * Result class to hold both JWK and X509Certificate
     */
    public static class CertificateResult {
        private final JWK jwk;
        private final X509Certificate certificate;
        private final String source;
        
        public CertificateResult(JWK jwk, X509Certificate certificate, String source) {
            this.jwk = jwk;
            this.certificate = certificate;
            this.source = source;
        }
        
        public JWK getJwk() {
            return jwk;
        }
        
        public X509Certificate getCertificate() {
            return certificate;
        }
        
        public String getSource() {
            return source;
        }
        
        public boolean hasJwk() {
            return jwk != null;
        }
        
        public boolean hasCertificate() {
            return certificate != null;
        }
    }
    
    private final CertificateFactory certificateFactory;
    private final ObjectMapper objectMapper;
    
    public CertificateScanner() throws CertificateException {
        this.certificateFactory = CertificateFactory.getInstance("X.509");
        this.objectMapper = new ObjectMapper();
    }
    
    /**
     * Scans loaded certificates and folders for certificates matching the specified key ID
     * @param loadedCertificates Map of filename to certificate bytes (will be updated with newly loaded files)
     * @param foldersToScan List of folder paths to scan for certificate files
     * @param targetKid Key ID to match
     * @return CertificateResult if found, null otherwise
     */
    public CertificateResult findCertificateByKid(Map<String, byte[]> loadedCertificates, 
                                                 List<String> foldersToScan, 
                                                 String targetKid) {
        // First, scan the already loaded certificates
        CertificateResult result = scanLoadedCertificates(loadedCertificates, targetKid);
        if (result != null) {
            return result;
        }
        
        // Then scan folders, loading files as we go
        if (foldersToScan != null) {
            for (String folderPath : foldersToScan) {
                result = scanFolderWithCaching(folderPath, loadedCertificates, targetKid);
                if (result != null) {
                    return result;
                }
            }
        }
        
        return null;
    }
    
    
    /**
     * Scans already loaded certificates in memory
     */
    private CertificateResult scanLoadedCertificates(Map<String, byte[]> loadedCertificates, String targetKid) {
        if (loadedCertificates == null || loadedCertificates.isEmpty()) {
            return null;
        }
        
        for (Map.Entry<String, byte[]> entry : loadedCertificates.entrySet()) {
            String filename = entry.getKey();
            byte[] fileBytes = entry.getValue();
            
            log.info("Scanning loaded certificate: " + filename);
            
            CertificateResult result = scanFileBytes(filename, fileBytes, targetKid);
            if (result != null) {
                return result;
            }
        }
        
        return null;
    }
    
    /**
     * Scans a folder for certificates, caching loaded files
     */
    private CertificateResult scanFolderWithCaching(String folderPath, 
                                                   Map<String, byte[]> loadedCertificates, 
                                                   String targetKid) {
        try {
            Path folder = Paths.get(folderPath);
            if (!Files.exists(folder) || !Files.isDirectory(folder)) {
                log.warn("Invalid folder path: " + folderPath);
                return null;
            }
            
            try (Stream<Path> files = Files.walk(folder)) {
                return files.filter(Files::isRegularFile)
                           .map(file -> scanFileWithCaching(file, loadedCertificates, targetKid))
                           .filter(Objects::nonNull)
                           .findFirst()
                           .orElse(null);
            }
            
        } catch (Exception e) {
            log.error("Error scanning folder: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Scans a single file, caching its contents
     */
    private CertificateResult scanFileWithCaching(Path filePath, 
                                                 Map<String, byte[]> loadedCertificates, 
                                                 String targetKid) {
        String filename = filePath.toString();
        
        // Check if we've already loaded this file
        byte[] fileBytes = loadedCertificates.get(filename);
        if (fileBytes == null) {
            // Load the file and cache it
            try {
                fileBytes = Files.readAllBytes(filePath);
                loadedCertificates.put(filename, fileBytes);
                log.info("Loaded and cached file: " + filename);
            } catch (Exception e) {
                log.error("Error reading file " + filename + ": " + e.getMessage());
                return null;
            }
        }
        
        return scanFileBytes(filename, fileBytes, targetKid);
    }
    
    /**
     * Scans file bytes for certificates matching the target kid
     */
    private CertificateResult scanFileBytes(String filename, byte[] fileBytes, String targetKid) {
        String fileName = Paths.get(filename).getFileName().toString().toLowerCase();
        String extension = getFileExtension(fileName);
        
        log.info("Scanning file: " + filename);
        
        try {
            // Try different formats based on file extension and content
            switch (extension) {
                case "json":
                case "jwks":
                    return scanJWKSBytes(filename, fileBytes, targetKid);
                    
                case "pem":
                case "crt":
                case "cer":
                    return scanPEMBytes(filename, fileBytes, targetKid);
                    
                case "der":
                    return scanDERBytes(filename, fileBytes, targetKid);
                    
                case "p12":
                case "pfx":
                    return scanPKCS12Bytes(filename, fileBytes, targetKid);
                    
                case "jks":
                    return scanJKSBytes(filename, fileBytes, targetKid);
                    
                default:
                    // Try to auto-detect format
                    return autoDetectAndScanBytes(filename, fileBytes, targetKid);
            }
            
        } catch (Exception e) {
            log.error("Error processing file " + filename + ": " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Scan JWKS JSON bytes using Nimbus
     */
    private CertificateResult scanJWKSBytes(String filename, byte[] fileBytes, String targetKid) throws Exception {
        String content = new String(fileBytes);
        
        try {
            // Try as JWKS first
            JWKSet jwkSet = JWKSet.parse(content);
            JWK jwk = jwkSet.getKeyByKeyId(targetKid);
            if (jwk != null) {
                log.info("Found matching JWK in JWKS file: " + filename);
                // Try to extract certificate from JWK if it has x5c
                X509Certificate cert = extractCertificateFromJWK(jwk);
                return new CertificateResult(jwk, cert, filename);
            }
        } catch (Exception e) {
            // Try as single JWK
            try {
                JWK jwk = JWK.parse(content);
                if (targetKid.equals(jwk.getKeyID())) {
                    log.info("Found matching JWK in JSON file: " + filename);
                    X509Certificate cert = extractCertificateFromJWK(jwk);
                    return new CertificateResult(jwk, cert, filename);
                }
            } catch (Exception e2) {
                // Not a valid JWK/JWKS
            }
        }
        
        return null;
    }
    
    /**
     * Extract X509Certificate from JWK if it contains x5c (certificate chain)
     */
    private X509Certificate extractCertificateFromJWK(JWK jwk) {
        try {
            List<com.nimbusds.jose.util.Base64> certChain = jwk.getX509CertChain();
            if (certChain != null && !certChain.isEmpty()) {
                // Get the first certificate in the chain
                byte[] certBytes = certChain.get(0).decode();
                try (ByteArrayInputStream bis = new ByteArrayInputStream(certBytes)) {
                    return (X509Certificate) certificateFactory.generateCertificate(bis);
                }
            }
        } catch (Exception e) {
            // No certificate in JWK
        }
        return null;
    }
    
    /**
     * Scan PEM format bytes using only Nimbus
     */
    private CertificateResult scanPEMBytes(String filename, byte[] fileBytes, String targetKid) throws Exception {
        String pemContent = new String(fileBytes);
        
        // Extract all certificate blocks from PEM content
        List<X509Certificate> certificates = extractCertificatesFromPEM(pemContent);
        
        for (X509Certificate cert : certificates) {
            JWK jwk = createJWKFromCertificate(cert, targetKid);
            if (jwk != null) {
                log.info("Found matching certificate in PEM file: " + filename);
                return new CertificateResult(jwk, cert, filename);
            }
        }
        
        return null;
    }
    
    /**
     * Extract X509 certificates from PEM content using Nimbus utilities
     */
    private List<X509Certificate> extractCertificatesFromPEM(String pemContent) {
        // Pattern to match certificate blocks
        Pattern certPattern = Pattern.compile(
            "-----BEGIN CERTIFICATE-----\\s*([A-Za-z0-9+/\\s=]+)\\s*-----END CERTIFICATE-----",
            Pattern.MULTILINE | Pattern.DOTALL
        );
        
        List<X509Certificate> certificates = new ArrayList<>();
        Matcher matcher = certPattern.matcher(pemContent);
        
        while (matcher.find()) {
            String base64Cert = matcher.group(1).replaceAll("\\s", ""); // Remove whitespace
            
            try {
                // Use Nimbus X509CertUtils to parse the certificate
                X509Certificate cert = X509CertUtils.parse(base64Cert);
                if (cert != null) {
                    certificates.add(cert);
                }
            } catch (Exception e) {
                log.info("Failed to parse certificate block: " + e.getMessage());
                // Continue with next certificate
            }
        }
        
        return certificates;
    }
    
    /**
     * Scan DER format bytes using standard Java libraries
     */
    private CertificateResult scanDERBytes(String filename, byte[] fileBytes, String targetKid) throws Exception {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(fileBytes)) {
            X509Certificate cert = (X509Certificate) certificateFactory.generateCertificate(bis);
            JWK jwk = createJWKFromCertificate(cert, targetKid);
            if (jwk != null) {
                log.info("Found matching certificate in DER file: " + filename);
                return new CertificateResult(jwk, cert, filename);
            }
        }
        
        return null;
    }
    
    /**
     * Scan PKCS#12 format bytes
     */
    private CertificateResult scanPKCS12Bytes(String filename, byte[] fileBytes, String targetKid) throws Exception {
        // Try common passwords
        String[] passwords = {"", "password", "changeit", "123456"};
        
        for (String password : passwords) {
            try {
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                try (ByteArrayInputStream bis = new ByteArrayInputStream(fileBytes)) {
                    keyStore.load(bis, password.toCharArray());
                }
                
                CertificateResult result = scanKeyStore(keyStore, targetKid, filename);
                if (result != null) {
                    log.info("Found matching certificate in PKCS12 file: " + filename);
                    return result;
                }
                
            } catch (Exception e) {
                // Try next password
            }
        }
        
        return null;
    }
    
    /**
     * Scan JKS (Java KeyStore) format bytes
     */
    private CertificateResult scanJKSBytes(String filename, byte[] fileBytes, String targetKid) throws Exception {
        // Try common passwords
        String[] passwords = {"", "password", "changeit", "123456"};
        
        for (String password : passwords) {
            try {
                KeyStore keyStore = KeyStore.getInstance("JKS");
                try (ByteArrayInputStream bis = new ByteArrayInputStream(fileBytes)) {
                    keyStore.load(bis, password.toCharArray());
                }
                
                CertificateResult result = scanKeyStore(keyStore, targetKid, filename);
                if (result != null) {
                    log.info("Found matching certificate in JKS file: " + filename);
                    return result;
                }
                
            } catch (Exception e) {
                // Try next password
            }
        }
        
        return null;
    }
    
    /**
     * Scan KeyStore for matching certificate using Nimbus
     */
    private CertificateResult scanKeyStore(KeyStore keyStore, String targetKid, String source) throws Exception {
        Enumeration<String> aliases = keyStore.aliases();
        
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            
            if (keyStore.isCertificateEntry(alias)) {
                X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
                JWK jwk = createJWKFromCertificate(cert, targetKid);
                if (jwk != null) {
                    return new CertificateResult(jwk, cert, source);
                }
            }
        }
        
        return null;
    }
    
    /**
     * Auto-detect file format and scan bytes
     */
    private CertificateResult autoDetectAndScanBytes(String filename, byte[] fileBytes, String targetKid) throws Exception {
        // Check if it's text (PEM/JSON)
        if (isProbablyText(fileBytes)) {
            String content = new String(fileBytes);
            
            // Try JSON/JWKS
            if (content.trim().startsWith("{") || content.trim().startsWith("[")) {
                return scanJWKSBytes(filename, fileBytes, targetKid);
            }
            
            // Try PEM
            if (content.contains("-----BEGIN")) {
                return scanPEMBytes(filename, fileBytes, targetKid);
            }
        } else {
            // Try DER
            try {
                return scanDERBytes(filename, fileBytes, targetKid);
            } catch (Exception e) {
                // Not DER, try PKCS12
                try {
                    return scanPKCS12Bytes(filename, fileBytes, targetKid);
                } catch (Exception e2) {
                    // Not PKCS12 either
                }
            }
        }
        
        return null;
    }
    
    /**
     * Create JWK from X509Certificate using Nimbus, checking if kid matches
     */
    private JWK createJWKFromCertificate(X509Certificate cert, String targetKid) {
        try {
            // Create JWK from certificate using Nimbus
            JWK jwk = JWK.parse(cert);
            
            // Check if the key ID matches directly
            String certKid = jwk.getKeyID();
            if (targetKid.equals(certKid)) {
                return jwk;
            }
            
            // Try thumbprint as kid (SHA-256)
            String thumbprint = jwk.computeThumbprint().toString();
            if (targetKid.equals(thumbprint)) {
                return createJWKWithKid(jwk, targetKid);
            }
            
            // Try SHA-1 thumbprint
            String sha1Thumbprint = jwk.computeThumbprint("SHA-1").toString();
            if (targetKid.equals(sha1Thumbprint)) {
                return createJWKWithKid(jwk, targetKid);
            }
            
            // Try certificate serial number (hex format)
            String serialNumber = cert.getSerialNumber().toString(16);
            if (targetKid.equals(serialNumber)) {
                return createJWKWithKid(jwk, targetKid);
            }
            
            // Try certificate serial number (decimal format)
            String serialDecimal = cert.getSerialNumber().toString(10);
            if (targetKid.equals(serialDecimal)) {
                return createJWKWithKid(jwk, targetKid);
            }
            
            // Try Subject Key Identifier extension
            byte[] skiExtension = cert.getExtensionValue("2.5.29.14");
            if (skiExtension != null && skiExtension.length > 4) {
                // Skip ASN.1 OCTET STRING wrapper (first 4 bytes typically)
                byte[] ski = Arrays.copyOfRange(skiExtension, 4, skiExtension.length);
                
                // Convert to hex string
                StringBuilder hexString = new StringBuilder();
                for (byte b : ski) {
                    hexString.append(String.format("%02x", b));
                }
                
                if (targetKid.equals(hexString.toString())) {
                    return createJWKWithKid(jwk, targetKid);
                }
                
                // Also try uppercase hex
                if (targetKid.equals(hexString.toString().toUpperCase())) {
                    return createJWKWithKid(jwk, targetKid);
                }
            }
            
            // Try subject common name
            String subjectDN = cert.getSubjectX500Principal().getName();
            if (subjectDN.contains("CN=")) {
                String cn = extractCN(subjectDN);
                if (targetKid.equals(cn)) {
                    return createJWKWithKid(jwk, targetKid);
                }
            }
            
        } catch (Exception e) {
            log.error("Error creating JWK from certificate: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * Create a new JWK with the specified kid by recreating from JSON
     */
    private JWK createJWKWithKid(JWK originalJwk, String newKid) throws Exception {
        // Get the JWK as JSON
        Map<String, Object> jwkMap = originalJwk.toJSONObject();
        
        // Set the new kid
        jwkMap.put("kid", newKid);
        
        // Parse back to JWK
        return JWK.parse(jwkMap);
    }
    
    /**
     * Extract Common Name from Distinguished Name
     */
    private String extractCN(String dn) {
        Pattern cnPattern = Pattern.compile("CN=([^,]+)");
        Matcher matcher = cnPattern.matcher(dn);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
    
    /**
     * Check if file content is probably text
     */
    private boolean isProbablyText(byte[] bytes) {
        if (bytes.length == 0) return false;
        
        int textChars = 0;
        int sampleSize = Math.min(1024, bytes.length);
        
        for (int i = 0; i < sampleSize; i++) {
            byte b = bytes[i];
            if ((b >= 32 && b <= 126) || b == 9 || b == 10 || b == 13) {
                textChars++;
            }
        }
        
        return (double) textChars / sampleSize > 0.95;
    }
    
    /**
     * Get file extension from filename
     */
    private String getFileExtension(String fileName) {
        int lastDot = fileName.lastIndexOf('.');
        return lastDot > 0 ? fileName.substring(lastDot + 1) : "";
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            log.info("Usage: java CertificateScanner <folder_path1> [folder_path2...] <kid>");
            return;
        }
        
        // Last argument is the kid
        String targetKid = args[args.length - 1];
        
        // All other arguments are folder paths
        List<String> folderPaths = new ArrayList<>();
        for (int i = 0; i < args.length - 1; i++) {
            folderPaths.add(args[i]);
        }
        
        try {
            CertificateScanner scanner = new CertificateScanner();
            Map<String, byte[]> loadedCertificates = new HashMap<>();
            CertificateResult result = scanner.findCertificateByKid(loadedCertificates, folderPaths, targetKid);
            
            if (result != null) {
                log.info("\nFound matching certificate!");
                log.info("Source: " + result.getSource());
                
                if (result.hasJwk()) {
                    JWK jwk = result.getJwk();
                    log.info("Key ID: " + jwk.getKeyID());
                    log.info("Key Type: " + jwk.getKeyType());
                    log.info("Algorithm: " + jwk.getAlgorithm());
                    log.info("JWK: " + jwk.toJSONString());
                }
                
                if (result.hasCertificate()) {
                    X509Certificate cert = result.getCertificate();
                    log.info("\nX509 Certificate Details:");
                    log.info("Subject: " + cert.getSubjectX500Principal().getName());
                    log.info("Issuer: " + cert.getIssuerX500Principal().getName());
                    log.info("Serial Number: " + cert.getSerialNumber().toString(16));
                    log.info("Valid From: " + cert.getNotBefore());
                    log.info("Valid Until: " + cert.getNotAfter());
                    log.info("Signature Algorithm: " + cert.getSigAlgName());
                }
                
                log.info("\nLoaded certificates cache now contains " + loadedCertificates.size() + " files");
            } else {
                log.info("\nNo matching certificate found for kid: " + targetKid);
                log.info("Scanned " + loadedCertificates.size() + " files total");
            }
            
        } catch (Exception e) {
            log.error("Error: " + e.getMessage(), e);
        }
    }
}