package org.hl7.fhir.dstu2016may.terminologies;

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



import java.util.List;

import org.hl7.fhir.dstu2016may.model.CodeSystem;
import org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu2016may.model.UriType;
import org.hl7.fhir.dstu2016may.model.ValueSet;
import org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.dstu2016may.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.dstu2016may.utils.EOperationOutcome;
import org.hl7.fhir.dstu2016may.utils.IWorkerContext;
import org.hl7.fhir.dstu2016may.utils.IWorkerContext.ValidationResult;

public class ValueSetCheckerSimple implements ValueSetChecker {

  private ValueSet valueset;
  private ValueSetExpanderFactory factory;
  private IWorkerContext context;

  public ValueSetCheckerSimple(ValueSet source, ValueSetExpanderFactory factory, IWorkerContext context) {
    this.valueset = source;
    this.factory = factory;
    this.context = context;
  }

  @Override
  public boolean codeInValueSet(String system, String code) throws EOperationOutcome, Exception {

    if (valueset.hasCompose()) {
      boolean ok = false;
      for (UriType uri : valueset.getCompose().getImport()) {
        ok = ok || inImport(uri.getValue(), system, code);
      }
      for (ConceptSetComponent vsi : valueset.getCompose().getInclude()) {
        ok = ok || inComponent(vsi, system, code);
      }
      for (ConceptSetComponent vsi : valueset.getCompose().getExclude()) {
        ok = ok && !inComponent(vsi, system, code);
      }
    }
    
    return false;
  }

  private boolean inImport(String uri, String system, String code) throws EOperationOutcome, Exception {
    ValueSet vs = context.fetchResource(ValueSet.class, uri);
    if (vs == null) 
      return false ; // we can't tell
    return codeInExpansion(factory.getExpander().expand(vs), system, code);
  }

  private boolean codeInExpansion(ValueSetExpansionOutcome vso, String system, String code) throws EOperationOutcome, Exception {
    if (vso.getService() != null) {
      return vso.getService().codeInValueSet(system, code);
    } else {
      for (ValueSetExpansionContainsComponent c : vso.getValueset().getExpansion().getContains()) {
        if (code.equals(c.getCode()) && (system == null || system.equals(c.getSystem())))
          return true;
        if (codeinExpansion(c, system, code)) 
          return true;
      }
    }
    return false;
  }

  private boolean codeinExpansion(ValueSetExpansionContainsComponent cnt, String system, String code) {
    for (ValueSetExpansionContainsComponent c : cnt.getContains()) {
      if (code.equals(c.getCode()) && system.equals(c.getSystem().toString()))
        return true;
      if (codeinExpansion(c, system, code)) 
        return true;
    }
    return false;
  }


  private boolean inComponent(ConceptSetComponent vsi, String system, String code) {
    if (!vsi.getSystem().equals(system))
      return false; 
    // whether we know the system or not, we'll accept the stated codes at face value
    for (ConceptReferenceComponent cc : vsi.getConcept())
      if (cc.getCode().equals(code)) {
        return true;
      }
      
    CodeSystem def = context.fetchCodeSystem(system);
    if (def != null) {
      if (!def.getCaseSensitive()) {
        // well, ok, it's not case sensitive - we'll check that too now
        for (ConceptReferenceComponent cc : vsi.getConcept())
          if (cc.getCode().equalsIgnoreCase(code)) {
            return false;
          }
      }
      if (vsi.getConcept().isEmpty() && vsi.getFilter().isEmpty()) {
        return codeInDefine(def.getConcept(), code, def.getCaseSensitive());
      }
      for (ConceptSetFilterComponent f: vsi.getFilter())
        throw new Error("not done yet: "+f.getValue());

      return false;
    } else if (context.supportsSystem(system)) {
      ValidationResult vv = context.validateCode(system, code, null, vsi);
      return vv.isOk();
    } else
      // we don't know this system, and can't resolve it
      return false;
  }

  private boolean codeInDefine(List<ConceptDefinitionComponent> concepts, String code, boolean caseSensitive) {
    for (ConceptDefinitionComponent c : concepts) {
      if (caseSensitive && code.equals(c.getCode()))
        return true;
      if (!caseSensitive && code.equalsIgnoreCase(c.getCode()))
        return true;
      if (codeInDefine(c.getConcept(), code, caseSensitive))
        return true;
    }
    return false;
  }

}