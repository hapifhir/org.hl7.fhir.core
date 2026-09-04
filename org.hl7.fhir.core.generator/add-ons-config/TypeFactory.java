{{startMark}}
package {{pid}};

{{license}}

  
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Base;

{{generated}}
public class TypeFactory extends Factory {

    public static Base createType(String name) throws FHIRException {
      switch (name) {
{{case-factory}}
      default:
        throw new FHIRException("Unknown Resource or Type Name '"+name+"'");
    }
  }


}