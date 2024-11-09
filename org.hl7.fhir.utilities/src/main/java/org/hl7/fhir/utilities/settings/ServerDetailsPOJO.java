package org.hl7.fhir.utilities.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@AllArgsConstructor
public class ServerDetailsPOJO {

    // what kind of HTTP server this is - a FHIR tx server, an NPM server, or a general web server
    String mode;
  
    String url;

    // possible values: none, basic, token, apikey
    String authenticationType;

    // npm or fhir, because the FHIR npm usage varies a little bit from general NPM usage (change over time)
    String serverType; 

    String username;

    String password;

    String token;

    String apikey;

}
