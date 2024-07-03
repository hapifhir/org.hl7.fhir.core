package org.hl7.fhir.r5.elementmodel;

import java.io.ByteArrayInputStream;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonCreator;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;


public class NDJsonParser extends ParserBase {

  public NDJsonParser(IWorkerContext context, ProfileUtilities utilities) {
    super(context, utilities);
  }

  public NDJsonParser(IWorkerContext context) {
    super(context);
  }
  
  private ValidatedFragment processLine(int lineCount, String line) throws FHIRException, IOException {
    List<ValidatedFragment> list = new JsonParser(context).parse(new ByteArrayInputStream(line.getBytes(StandardCharsets.UTF_8)), lineCount);
    return list.get(0);
  }

  @Override
  public List<ValidatedFragment> parse(InputStream inStream) throws IOException, FHIRException {
    String source = TextFile.streamToString(inStream);
    int length = source.length();
    int start = 0;
    int cursor = start;
    int lineCount = 0;

    List<ValidatedFragment> res = new ArrayList<>();
    while (cursor < length) {
      while (cursor < length && source.charAt(cursor) != '\n') {
        cursor++;
      }
      if (cursor < length) {
        String line = source.substring(start, cursor);
        if (line.endsWith("\r")) {
          line = line.substring(0, line.length()-1);
        }
        if (Utilities.noString(line.trim())) {
          ValidatedFragment vf = new ValidatedFragment(ValidatedFragment.ITEM_NAME, null, null, false);
          logError(vf.getErrors(), "2024-06-30", lineCount+1, 1, null, IssueType.INFORMATIONAL, context.formatMessage(I18nConstants.NDJSON_EMPTY_LINE_WARNING), IssueSeverity.WARNING);
          res.add(vf);
        } else {
          res.add(processLine(lineCount, line));
        }
        start = cursor+1;
      } else if (cursor > start) {
        String line = source.substring(start, cursor);
        if (line.endsWith("\r")) {
          line = line.substring(0, line.length()-1);
        }
        if (Utilities.noString(line.trim())) {
          ValidatedFragment vf = new ValidatedFragment(ValidatedFragment.ITEM_NAME, null, null, false);
          logError(vf.getErrors(), "2024-06-30", lineCount+1, 1, null, IssueType.INFORMATIONAL, context.formatMessage(I18nConstants.NDJSON_EMPTY_LINE_WARNING), IssueSeverity.WARNING);
          res.add(vf);
        } else {
          res.add(processLine(lineCount, line));
        }
        start = cursor+1;
      }
      lineCount++;
      cursor++;
    }
    return res;
  }
  
  @Override
  public void compose(Element e, OutputStream stream, OutputStyle style, String identity) throws FHIRException, IOException {
    throw new Error("Not done yet");
  }

}