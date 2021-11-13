package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r5.model.Resource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class Convertor_Factory_40_50Test {
  @Test
  void convertResource() throws IOException {
    JsonParser r4parser = new JsonParser();
    org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
    InputStream accountr4InputStream = this.getClass().getResourceAsStream("/account_r4.json");
    org.hl7.fhir.r4.model.Account account_r4 = (org.hl7.fhir.r4.model.Account) r4parser.parse(accountr4InputStream);
    Resource account_r5 = VersionConvertorFactory_40_50.convertResource(account_r4);
    System.out.println(r5parser.composeString(account_r5));
  }

  @Test
  void convertBundleContainingAccountsToTestPathing() throws IOException {
    JsonParser r4parser = new JsonParser();
    org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
    InputStream accountr4InputStream = this.getClass().getResourceAsStream("/bundle_of_accounts_path_test_r4.json");
    org.hl7.fhir.r4.model.Bundle bundle_r4 = (org.hl7.fhir.r4.model.Bundle) r4parser.parse(accountr4InputStream);
    Resource account_r5 = VersionConvertorFactory_40_50.convertResource(bundle_r4);
    System.out.println(r5parser.composeString(account_r5));
  }
}