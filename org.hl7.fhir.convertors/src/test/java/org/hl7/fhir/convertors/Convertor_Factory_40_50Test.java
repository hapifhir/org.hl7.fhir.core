package org.hl7.fhir.convertors;

import lombok.SneakyThrows;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r5.model.Resource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
  void testThreads() throws InterruptedException {
    List<ConversionContext40_50> listOfConvertors = new ArrayList<>();
    Runnable r1 = new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        JsonParser r4parser = new JsonParser();
        org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
        InputStream accountr4InputStream = this.getClass().getResourceAsStream("/account_r4.json");
        org.hl7.fhir.r4.model.Account account_r4 = (org.hl7.fhir.r4.model.Account) r4parser.parse(accountr4InputStream);
        Resource account_r5 = VersionConvertorFactory_40_50.convertResource(account_r4);
      }
    };
    Thread thread1 = new Thread(r1);
    Thread thread2 = new Thread(r1);
    Thread thread3 = new Thread(r1);
    thread1.start();
    thread2.start();
    thread3.start();
    thread1.join();
    thread2.join();
    thread3.join();
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

  @Test
  void testConvertResource() {
  }
}