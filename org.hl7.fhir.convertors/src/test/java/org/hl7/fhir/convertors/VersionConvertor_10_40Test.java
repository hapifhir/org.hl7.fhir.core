package org.hl7.fhir.convertors;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_40;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

public class VersionConvertor_10_40Test {

    private final FhirContext r4Ctx = FhirContext.forR4();

    @Test
    @DisplayName("Test 10_40 Bundle conversion.")
    public void testBundleConversion() throws IOException {
        InputStream dstu2_input = this.getClass().getResourceAsStream("/bundle-dstu2-cerner.json");

        org.hl7.fhir.dstu2.model.Bundle dstu2 = (org.hl7.fhir.dstu2.model.Bundle) new org.hl7.fhir.dstu2.formats.JsonParser()
                .parse(dstu2_input);
        //VersionConvertorAdvisor40 advisor = new IGR2ConvertorAdvisor();
        org.hl7.fhir.r4.model.Bundle result = new org.hl7.fhir.r4.model.Bundle()
                .setType(org.hl7.fhir.r4.model.Bundle.BundleType.COLLECTION);
        for (org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent entry : dstu2.getEntry()) {

            org.hl7.fhir.r4.model.Resource r4_actual = VersionConvertorFactory_10_40.convertResource(entry.getResource());
            if (r4_actual != null) {
                result.addEntry(new org.hl7.fhir.r4.model.Bundle.BundleEntryComponent().setResource(r4_actual));
            }
        }

        IParser r4Parser = r4Ctx.newJsonParser();
        String serialized = result != null ? r4Parser.encodeResourceToString(result) : null;
        System.out.println(serialized);

    }
}
