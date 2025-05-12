package {{pid}};

{{license}}

{{startMark}}
  
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Base;

public class TypeFactory extends Factory {

    public static Base createType(String name) throws FHIRException {
      switch (name.hashCode()) {
{{case-factory}}
      default:
        throw new FHIRException("Unknown Resource or Type Name '"+name+"'");
    }
  }


}