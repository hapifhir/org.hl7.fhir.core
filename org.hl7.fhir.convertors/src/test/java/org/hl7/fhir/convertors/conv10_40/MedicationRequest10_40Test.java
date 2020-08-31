package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertorAdvisor40;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MedicationRequest10_40Test {
    @Test
    @DisplayName("Test 10_40 MedicationRequest conversion")
    public void testMedicationRequestConversion() throws IOException {
        String dstu2_string =
            "{'resourceType': 'MedicationOrder',"+
            " 'dateWritten': '2016-11-13',"+
            " 'status': 'active',"+
            " 'id': 'T5YI1tCzs--JEvCICFbx8zgB',"+
            " 'identifier': [{'use': 'usual',"+
            "   'system': 'urn:oid:1.2.840.114350.1.13.0.1.7.2.798268',"+
            "   'value': '988736'},"+
            "  {'use': 'usual',"+
            "   'system': 'urn:oid:1.2.840.114350.1.13.0.1.7.3.798268.801',"+
            "   'value': '988736:2150291843'}],"+
            " 'patient': {'display': 'Jason Argonaut',"+
            "  'reference': 'https://open-ic.epic.com/Argonaut/api/FHIR/DSTU2/Patient/Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB'},"+
            " 'prescriber': {'display': 'Historical Provider, MD',"+
            "  'reference': 'https://open-ic.epic.com/Argonaut/api/FHIR/DSTU2/Practitioner/T-kmjPGEVPAmnBfmx56HsKgB'},"+
            " 'medicationReference': {'display': 'amitriptyline 10 MG tablet',"+
            "  'reference': 'https://open-ic.epic.com/Argonaut/api/FHIR/DSTU2/Medication/T0eKLT7EB2ApMM8HCEURdMAB'},"+
            " 'dosageInstruction': [{'text': 'Take 10 mg by mouth nightly.',"+
            "   'asNeededBoolean': False,"+
            "   'route': {'text': 'Oral',"+
            "    'coding': [{'system': 'urn:oid:1.2.840.114350.1.13.0.1.7.4.698288.330',"+
            "      'code': '15',"+
            "      'display': 'Oral'}]},"+
            "   'method': {'text': 'Take',"+
            "    'coding': [{'system': 'urn:oid:1.2.840.114350.1.13.0.1.7.4.798268.8600',"+
            "      'code': '11',"+
            "      'display': 'Take'}]},"+
            "   'timing': {'repeat': {'frequency': 1,"+
            "     'period': 1.0,"+
            "     'periodUnits': 'd',"+
            "     'boundsPeriod': {'start': '2016-11-15T00:00:00Z',"+
            "      'end': '2016-11-23T00:00:00Z'}}},"+
            "   'doseQuantity': {'value': 10.0,"+
            "    'unit': 'mg',"+
            "    'code': 'mg',"+
            "    'system': 'http://unitsofmeasure.org'}}],"+
            " 'dispenseRequest': {'validityPeriod': {'start': '2016-11-15T00:00:00Z',"+
            "   'end': '2016-11-23T00:00:00Z'}}}";
        String r4_expected_string =
            "{\"resourceType\": \"MedicationRequest\","+
            " \"id\": \"T5YI1tCzs--JEvCICFbx8zgB\","+
            " \"identifier\": [{\"use\": \"usual\","+
            "   \"system\": \"urn:oid:1.2.840.114350.1.13.0.1.7.2.798268\","+
            "   \"value\": \"988736\"},"+
            "  {\"use\": \"usual\","+
            "   \"system\": \"urn:oid:1.2.840.114350.1.13.0.1.7.3.798268.801\","+
            "   \"value\": \"988736:2150291843\"}],"+
            " \"status\": \"active\","+
            " \"intent\": \"order\","+
            " \"medicationReference\": {\"reference\": \"https://open-ic.epic.com/Argonaut/api/FHIR/DSTU2/Medication/T0eKLT7EB2ApMM8HCEURdMAB\","+
            "  \"display\": \"amitriptyline 10 MG tablet\"},"+
            " \"subject\": {\"reference\": \"https://open-ic.epic.com/Argonaut/api/FHIR/DSTU2/Patient/Tbt3KuCY0B5PSrJvCu2j-PlK.aiHsu2xUjUM8bWpetXoB\","+
            "  \"display\": \"Jason Argonaut\"},"+
            " \"authoredOn\": \"2016-11-13T00:00:00\","+
            " \"requester\": {\"reference\": \"https://open-ic.epic.com/Argonaut/api/FHIR/DSTU2/Practitioner/T-kmjPGEVPAmnBfmx56HsKgB\","+
            "  \"display\": \"Historical Provider, MD\"},"+
            " \"dosageInstruction\": [{\"text\": \"Take 10 mg by mouth nightly.\","+
            "   \"timing\": {\"repeat\": {\"boundsPeriod\": {\"start\": \"2016-11-15T00:00:00Z\","+
            "      \"end\": \"2016-11-23T00:00:00Z\"},"+
            "     \"count\": 0,"+
            "     \"frequency\": 1,"+
            "     \"frequencyMax\": 0,"+
            "     \"period\": 1.0,"+
            "     \"periodUnit\": \"d\"}},"+
            "   \"asNeededBoolean\": \"False\","+
            "   \"route\": {\"coding\": [{\"system\": \"urn:oid:1.2.840.114350.1.13.0.1.7.4.698288.330\","+
            "      \"code\": \"15\","+
            "      \"display\": \"Oral\"}],"+
            "    \"text\": \"Oral\"},"+
            "   \"method\": {\"coding\": [{\"system\": \"urn:oid:1.2.840.114350.1.13.0.1.7.4.798268.8600\","+
            "      \"code\": \"11\","+
            "      \"display\": \"Take\"}],"+
            "    \"text\": \"Take\"},"+
            "   \"doseAndRate\": [{\"doseQuantity\": {\"value\": 10.0,"+
            "      \"unit\": \"mg\","+
            "      \"system\": \"http://unitsofmeasure.org\","+
            "      \"code\": \"mg\"}}]}],"+
            " \"dispenseRequest\": {\"validityPeriod\": {\"start\": \"2016-11-15T00:00:00Z\","+
            "   \"end\": \"2016-11-23T00:00:00Z\"}}}";

        InputStream input = org.apache.commons.io.IOUtils.toInputStream(dstu2_string, "UTF-8");
        org.hl7.fhir.dstu2.model.MedicationOrder dstu2 = (org.hl7.fhir.dstu2.model.MedicationOrder) new org.hl7.fhir.dstu2.formats.JsonParser().parse(input);
        VersionConvertorAdvisor40 advisor = new IGR2ConvertorAdvisor();
        org.hl7.fhir.r4.model.Resource r4_actual = VersionConvertor_10_40.convertResource(dstu2, advisor);

        org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
        org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(r4_expected_string);

        Assertions.assertTrue(r4_expected.equalsDeep(r4_actual),
            "Failed comparing\n" + r4_parser.composeString(r4_actual) + "\nand\n" + r4_parser.composeString(r4_expected));
    }

}
