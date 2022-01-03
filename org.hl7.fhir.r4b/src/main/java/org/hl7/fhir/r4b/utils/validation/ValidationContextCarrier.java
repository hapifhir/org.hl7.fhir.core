package org.hl7.fhir.r4b.utils.validation;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.elementmodel.Element;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Questionnaire;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class ValidationContextCarrier {
  /**
   * 
   * When the validator is calling validateCode, it typically has a partially loaded resource that may provide
   * additional resources that are relevant to the validation. This is a handle back into the validator context
   * to ask for the resource to be fully loaded if it becomes relevant. Note that the resource may fail to load 
   * (e.g. if it's part of what's being validated) and if it does, the validator will record the validation 
   * issues before throwing an error
   *  
   * This is a reference back int
   *
   */
  public interface IValidationContextResourceLoader {     
    public Resource loadContainedResource(List<ValidationMessage> errors, String path, Element resource, String id, Class<? extends Resource> class1) throws FHIRException;
  }

  /**
   * A list of resources that provide context - typically, a container resource, and a bundle resource. 
   * iterate these in order looking for contained resources 
   * 
   */
  public static class ValidationContextResourceProxy {

    // either a resource
    private Resource resource;
    
    
    // or an element and a loader
    private Element element;
    private IValidationContextResourceLoader loader;
    private List<ValidationMessage> errors;
    private String path;
    
    public ValidationContextResourceProxy(Resource resource) {
      this.resource = resource;
    }

    public ValidationContextResourceProxy(List<ValidationMessage> errors, String path, Element element,  IValidationContextResourceLoader loader) {
      this.errors = errors;
      this.path = path;
      this.element = element;
      this.loader = loader;
    }

    public Resource loadContainedResource(String id, Class<? extends Resource> class1) throws FHIRException {
      if (resource == null) {
        Resource res = loader.loadContainedResource(errors, path, element, id, class1);
        return res;        
      } else {
        if (resource instanceof DomainResource) {
          for (Resource r : ((DomainResource) resource).getContained()) {
            if (r.getId().equals(id)) {
              if (class1.isInstance(r)) 
                return r;              
            }
          }
        }
        return null;       
      }
    }
  }
  
  private List<ValidationContextResourceProxy> resources = new ArrayList<>();

  public List<ValidationContextResourceProxy> getResources() {
    return resources;
  }
  
}
