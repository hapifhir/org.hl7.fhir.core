package org.hl7.fhir.dstu2016may.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import org.hl7.fhir.exceptions.FHIRException;

/**
 * in a language with helper classes, this would be a helper class (at least, the base exgtension helpers would be)
 * @author Grahame
 *
 */
public class ExtensionHelper {

  
  /**
   * @param name the identity of the extension of interest
   * @return true if the named extension is on this element. Will check modifier extensions too if appropriate
   */
  public static boolean hasExtension(Element element, String name) {
  	if (element != null && element instanceof BackboneElement) 
  		return hasExtension((BackboneElement) element, name);
  	
    if (name == null || element == null || !element.hasExtension())
      return false;
    for (Extension e : element.getExtension()) {
      if (name.equals(e.getUrl()))
        return true;
    }
    return false;
  }
  
  /**
   * @param name the identity of the extension of interest
   * @return true if the named extension is on this element. Will check modifier extensions
   */
  public static boolean hasExtension(BackboneElement element, String name) {
    if (name == null || element == null || !(element.hasExtension() || element.hasModifierExtension()))
      return false;
    for (Extension e : element.getModifierExtension()) {
      if (name.equals(e.getUrl()))
        return true;
    }
    for (Extension e : element.getExtension()) {
      if (name.equals(e.getUrl()))
        return true;
    }
    return false;
  }
  
  
  /**
   * @param name the identity of the extension of interest
   * @return The extension, if on this element, else null. will check modifier extensions too, if appropriate
   */
  public static Extension getExtension(Element element, String name) {
  	if (element != null && element instanceof BackboneElement) 
  		return getExtension((BackboneElement) element, name);
  	
    if (name == null || element == null || !element.hasExtension())
      return null;
    for (Extension e : element.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }
  
  /**
   * @param name the identity of the extension of interest
   * @return The extension, if on this element, else null. will check modifier extensions too
   */
  public static Extension getExtension(BackboneElement element, String name) {
    if (name == null || element == null || !element.hasExtension())
      return null;
    for (Extension e : element.getModifierExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    for (Extension e : element.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  /**
   * set the value of an extension on the element. if value == null, make sure it doesn't exist
   * 
   * @param element - the element to act on. Can also be a backbone element 
   * @param modifier - whether this is a modifier. Note that this is a definitional property of the extension; don't alternate
   * @param uri - the identifier for the extension
   * @param value - the value of the extension. Delete if this is null
   * @throws Exception - if the modifier logic is incorrect
   */
  public static void setExtension(Element element, boolean modifier, String uri, Type value) throws FHIRException {
  	if (value == null) {
    	// deleting the extension
  		if (element instanceof BackboneElement)
  			for (Extension e : ((BackboneElement) element).getModifierExtension()) {
  				if (uri.equals(e.getUrl()))
  					((BackboneElement) element).getModifierExtension().remove(e);
  			}
  		for (Extension e : element.getExtension()) {
  			if (uri.equals(e.getUrl()))
  				element.getExtension().remove(e);
  		}
  	} else {
  		// it would probably be easier to delete and then create, but this would re-order the extensions
  		// not that order matters, but we'll preserve it anyway
  		boolean found = false;
  		if (element instanceof BackboneElement)
  			for (Extension e : ((BackboneElement) element).getModifierExtension()) {
  				if (uri.equals(e.getUrl())) {
  					if (!modifier)
  						throw new FHIRException("Error adding extension \""+uri+"\": found an existing modifier extension, and the extension is not marked as a modifier");
  					e.setValue(value);
  					found = true;
  				}
  			}
  		for (Extension e : element.getExtension()) {
  			if (uri.equals(e.getUrl())) {
					if (modifier)
						throw new FHIRException("Error adding extension \""+uri+"\": found an existing extension, and the extension is marked as a modifier");
					e.setValue(value);
					found = true;
  			}
  		}
  		if (!found) {
  			Extension ex = new Extension().setUrl(uri).setValue(value);
  			if (modifier) {
  	  		if (!(element instanceof BackboneElement))
						throw new FHIRException("Error adding extension \""+uri+"\": extension is marked as a modifier, but element is not a backbone element");
  				((BackboneElement) element).getModifierExtension().add(ex);
  				
  			} else {
  				element.getExtension().add(ex);
  			}
  		}
  	}
  }

  public static boolean hasExtensions(Element element) {
  	if (element instanceof BackboneElement)
  		return element.hasExtension() || ((BackboneElement) element).hasModifierExtension();
  	else
  		return element.hasExtension();
  }


}