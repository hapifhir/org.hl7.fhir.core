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
import java.util.Map.Entry;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.graphql.Argument.ArgumentListStatus;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ObjectValue extends Value {
  private List<Argument> fields = new ArrayList<Argument>();

  public ObjectValue() {
    super();
  }

  public ObjectValue(JsonObject json) throws EGraphQLException {
    super();
    for (Entry<String, JsonElement> n : json.entrySet()) 
      fields.add(new Argument(n.getKey(), n.getValue()));      
  }

  public List<Argument> getFields() {
    return fields;
  }

  public Argument addField(String name, ArgumentListStatus listStatus) throws FHIRException {
    Argument result = null;
    for (Argument t : fields)
      if ((t.name.equals(name)))
        result = t;
    if (result == null) {
      result = new Argument();
      result.setName(name);
      result.setListStatus(listStatus);
      fields.add(result);
    } else if (result.getListStatus() == ArgumentListStatus.SINGLETON)
        throw new FHIRException("Error: Attempt to make '+name+' into a repeating field when it is constrained by @singleton");
    else
      result.setListStatus(ArgumentListStatus.REPEATING);
    return result;
  }

  /**
   * Write the output using the system default line separator (as defined in {@link System#lineSeparator}
   * @param b The StringBuilder to populate
   * @param indent The indent level, or <code>-1</code> for no indent
   */
  public void write(StringBuilder b, int indent) throws EGraphQLException, EGraphEngine {
    write(b, indent, System.lineSeparator());
  }

  public String getValue() {
    return null;
  }

  /**
   * Write the output using the system default line separator (as defined in {@link System#lineSeparator}
   * @param b The StringBuilder to populate
   * @param indent The indent level, or <code>-1</code> for no indent
   * @param lineSeparator The line separator
   */
  public void write(StringBuilder b, Integer indent, String lineSeparator) throws EGraphQLException, EGraphEngine {

    // Write the GraphQL output
    b.append("{");
    String s = "";
    String se = "";
    if ((indent > -1))
    {
      se = lineSeparator + Utilities.padLeft("",' ', indent*2);
      indent++;
      s = lineSeparator + Utilities.padLeft("",' ', indent*2);
    }
    boolean first = true;
    for (Argument a : fields) {
      if (first) first = false; else b.append(",");
      b.append(s);
      a.write(b, indent);
    }
    b.append(se);
    b.append("}");
  }
}