package org.hl7.fhir.utilities.graphql;

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
import java.util.List;

public class Field {
  private String name;
  private List<Selection> selectionSet = new ArrayList<Selection>();
  private String alias;
  private List<Argument> arguments = new ArrayList<Argument>();
  private List<Directive> directives = new ArrayList<Directive>();

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getAlias() {
    return alias;
  }


  public void setAlias(String alias) {
    this.alias = alias;
  }


  public List<Selection> getSelectionSet() {
    return selectionSet;
  }


  public List<Argument> getArguments() {
    return arguments;
  }


  public List<Directive> getDirectives() {
    return directives;
  }


  public Argument argument(String name) {
    for (Argument p : arguments) {
      if (p.name.equals(name))
        return p;
    }
    return null;
  }


  public boolean hasDirective(String name) {
    for (Directive d : directives)
      if (d.getName().equals(name))
        return true;
    return false;
  }

  public Directive directive(String name) {
    for (Directive d : directives)
      if (d.getName().equals(name))
        return d;
    return null;
  }
}