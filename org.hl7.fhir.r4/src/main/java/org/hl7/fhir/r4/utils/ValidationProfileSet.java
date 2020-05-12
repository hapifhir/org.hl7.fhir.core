package org.hl7.fhir.r4.utils;

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



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r4.model.StructureDefinition;

public class ValidationProfileSet {

  public static class ProfileRegistration {
    private String profile; 
    private boolean errorOnMissing;
    
    public ProfileRegistration(String profile, boolean errorOnMissing) {
      super();
      this.profile = profile;
      this.errorOnMissing = errorOnMissing;
    }
    public String getProfile() {
      return profile;
    }
    public boolean isErrorOnMissing() {
      return errorOnMissing;
    }
    
    
  }
  private List<ProfileRegistration> canonical = new ArrayList<ProfileRegistration>();
  private List<StructureDefinition> definitions = new ArrayList<StructureDefinition>();
  
  public ValidationProfileSet(String profile, boolean isError) {
    super();
    canonical.add(new ProfileRegistration(profile, isError));
  }

  public ValidationProfileSet() {
    super();
  }

  public ValidationProfileSet(StructureDefinition profile) {
    super();
    definitions.add(profile);
    canonical.add(new ProfileRegistration(profile.getUrl(), true));
  }

  public ValidationProfileSet(List<String> profiles, boolean isError) {
    super();
    if (profiles != null)
      for (String p : profiles)
        canonical.add(new ProfileRegistration(p, isError));
  }

  public List<String> getCanonicalUrls() {
    List<String> res = new ArrayList<String>();
    for (ProfileRegistration c : canonical) {
      res.add(c.getProfile());
    }
    return res;
  }

  public List<StructureDefinition> getDefinitions() {
    return definitions;
  }

  public boolean empty() {
    return canonical.isEmpty() && definitions.isEmpty();
  }

  public List<String> getCanonicalAll() {
    Set<String> res = new HashSet<String>();
    res.addAll(getCanonicalUrls());
    for (StructureDefinition sd : definitions)
      res.add(sd.getUrl());
    return new ArrayList<String>(res);
  }

  public List<ProfileRegistration> getCanonical() {
    return canonical;
  }

  public StructureDefinition fetch(String effectiveProfile) {
    for (StructureDefinition sd : definitions) 
      if (effectiveProfile.equals(sd.getUrl()))
        return sd;
    return null;
  }

}