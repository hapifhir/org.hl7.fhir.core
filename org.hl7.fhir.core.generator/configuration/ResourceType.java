{{startMark}}
package org.hl7.fhir.{{jid}}.core;

{{license}}


import org.hl7.fhir.exceptions.FHIRException;

{{generated}}
public enum ResourceType {
{{types-enum}};


    public String getPath() {;
      switch (this) {
{{types-getPath}}
    }
    return null;
  }


    public static ResourceType fromCode(String code) throws FHIRException {;
{{types-fromCode}}
    throw new FHIRException("Unknown resource type "+code);
  }

}