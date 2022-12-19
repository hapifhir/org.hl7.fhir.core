package org.hl7.fhir.r5.profilemodel;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Resource;

import kotlin.NotImplementedError;

public class ProfiledElementBuilder {

  private IWorkerContext context;

  public ProfiledElementBuilder(IWorkerContext context) {
    super();
    this.context = context;
  }
  

  /**
   * Given a profile, return a tree of elements in the profile model. This builds the profile model
   * for the latest version of the nominated profile
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public ProfiledElement buildProfileElement(String url) {
    throw new NotImplementedError("NOt done yet");
  }
  
  /**
   * Given a profile, return a tree of elements in the profile model. This builds the profile model
   * for the nominated version of the nominated profile
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public ProfiledElement buildProfileElement(String url, String version) {
    throw new NotImplementedError("NOt done yet");
  }
  
  /**
   * Given a profile, return a tree of elements in the profile model with matching instance data. 
   * This builds the profile model for the latest version of the nominated profile and matches 
   * the data in the resource against the profile. Data can be added or read from the profile element
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until it you get 
   * to the leaves because you will never get to a child that doesn't have children
   * 
   */
  public ProfiledElement buildProfileElement(String url, Resource resource) {
    throw new NotImplementedError("NOt done yet");
  }
  
  /**
   * Given a profile, return a tree of elements in the profile model with matching instance data. 
   * This builds the profile model for the nominated version of the nominated profile and matches 
   * the data in the resource against the profile. Data can be added or read from the profile element
   * 
   * THe tree of elements in the profile model is different to the the base resource:
   *  - some elements are removed (max = 0)
   *  - extensions are turned into named elements 
   *  - slices are turned into named elements 
   *  - element properties - doco, cardinality, binding etc is updated for what the profile says
   * 
   * When built with this method, the profile element can't have instance data
   * 
   */
  public ProfiledElement buildProfileElement(String url, String version, Resource resource) {
    throw new NotImplementedError("NOt done yet");
  }
  
  /**
   * Given a profile, construct an empty resource of the type being profiled (to use as input 
   * to the buildProfileElement method
   * 
   * No version, because the version doesn't change the type of the resource
   */
  public Resource makeProfileBase(String url) {
    throw new NotImplementedError("NOt done yet");
  }
 
}
