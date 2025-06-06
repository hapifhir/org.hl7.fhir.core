package org.hl7.fhir.utilities;

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
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;

/**
 * Baseclass for readers that read data from files in comma separated file format
 * @author Ewout
 *
 */
public class CSVReader extends InputStreamReader {
	
	public CSVReader(InputStream in) throws FHIRException, IOException {
		super(in, "UTF-8");
		checkBOM();
	}

	private void checkBOM() throws FHIRException, IOException {
    if (peek() == '\uFEFF')
      next();
    
  }

  private String[] cols;
  private String[] cells;
  private char delimiter = ',';
  private boolean multiline;
  private boolean doingQuotes = true;
  
	public String[] readHeaders() throws IOException, FHIRException {
    cols = parseLine();  
    return cols;
	}

  public boolean line() throws IOException, FHIRException {
    if (ready()) {
      cells = parseLine();
      return true;
    }  else
      return false;
  }

  public boolean has(String name) {
    for (int i = 0; i < cols.length; i++) {
      if (name.equals(cols[i].trim()))
        return cell(name) != null;
    }
    return false;
  }
  

  public String cell(String name) {
    int index = -1;
    for (int i = 0; i < cols.length; i++) {
      if (name.equals(cols[i].trim())) {
        index = i;
        break;
      }
    }
    if (index == -1)
      throw new FHIRException("no cell "+name+" in "+cols);
    return cell(index);
  }

  public String cell(int index) {
    String s = cells.length > index ? cells[index] : null;
    if (Utilities.noString(s))
      return null;
    if (s.startsWith("\"") && s.endsWith("\"")) {
      return s.substring(1, s.length()-2);     
    } else {
      return s;
    }
  }
    
	protected boolean parseBoolean(String column) {
		if (column == null)
			return false;
		else if (column.equalsIgnoreCase("y") || column.equalsIgnoreCase("yes") || column.equalsIgnoreCase("true") || column.equalsIgnoreCase("1"))
			return true;
		else
			return false;
	}

	protected static String getColumn(String[] titles, String[] values, String column)  {
		int c = -1;
	//	String s = "";
		for (int i = 0; i < titles.length; i++) {
		//	s = s + ","+titles[i];
			if (titles[i].equalsIgnoreCase(column))
				c = i;
		}
		if (c == -1)
			return ""; // throw new Exception("unable to find column "+column+" in "+s.substring(1));
		else if (values.length <= c)
			return "";
		else
			return values[c];
	}

	
	/**
	 * Split one line in a CSV file into its cells. Comma's appearing in double quoted strings will
	 * not be seen as a separator.
	 * @return
	 * @throws IOException 
	 * @throws FHIRException 
	 * @
	 */
	public String[] parseLine() throws IOException, FHIRException  {
		List<String> res = new ArrayList<String>();
		StringBuilder b = new StringBuilder();
		boolean inQuote = false;

		while (more() && !finished(inQuote, res.size())) {
			char c = peek();
			next();
			if (c == '"' && doingQuotes) {
				if (ready() && peek() == '"') {
	        b.append(c);
          next();
				} else {
			    inQuote = !inQuote;
				}
			}
			else if (!inQuote && c == delimiter ) {
				res.add(b.toString().trim());
				b = new StringBuilder();
			}
			else 
				b.append(c);
		}
		res.add(b.toString().trim());
		while (ready() && (peek() == '\r' || peek() == '\n')) {
			next();
		}
		
		String[] r = new String[] {};
		r = res.toArray(r);
		return r;
	}

	private boolean more() throws IOException {
    return state == 1 || ready();
  }

  private boolean finished(boolean inQuote, int size) throws FHIRException, IOException {
	  if (multiline && cols != null) {
	    return size == cols.length || (size == cols.length - 1 && !(inQuote || (peek() != '\r' && peek() != '\n')));
	  } else {
	    return !(inQuote || (peek() != '\r' && peek() != '\n'));
	  }
  }

  private int state = 0;
	private char pc;
	
	private char peek() throws FHIRException, IOException 
	{
	  if (state == 0)
		  next();
	  if (state == 1)
		  return pc;
	  else
		  throw new FHIRException("read past end of source");
	}
	
	private void next() throws FHIRException, IOException 
	{
		  if (state == 2)
			  throw new FHIRException("read past end of source");
          state = 1;
		  int i = read();
		  if (i == -1)
			  state = 2;
		  else 
			  pc = (char) i;
	}


  public void checkColumn(int i, String name, String desc) throws FHIRException {
    if (cols.length < i)
      throw new FHIRException("Error parsing "+desc+": expected column "+name+" at col "+i+" but only found "+cols.length+" cols");
    if (!cols[i-1].equals(name))
      throw new FHIRException("Error parsing "+desc+": expected column "+name+" at col "+i+" but found '"+cols[i-1]+"'");
  }


  public String value(int i) {
    if (i > cells.length)
      return null;
    if (Utilities.noString(cells[i-1]))
      return null;
    return cells[i-1];
  }

  public char getDelimiter() {
    return delimiter;
  }

  public void setDelimiter(char delimiter) {
    this.delimiter = delimiter;
  }

  public boolean isMultiline() {
    return multiline;
  }

  public void setMultiline(boolean multiline) {
    this.multiline = multiline;
  }

  public boolean isDoingQuotes() {
    return doingQuotes;
  }

  public void setDoingQuotes(boolean doingQuotes) {
    this.doingQuotes = doingQuotes;
  }

  public String[] getCells() {
    return cells;
  }

  public static List<String> splitString(String text) {
    InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
    CSVReader csv;
    try {
      csv = new CSVReader(inputStream);
      return Arrays.asList(csv.readHeaders());
    } catch (FHIRException | IOException e) {
     return new ArrayList<>();
    }    
  }



}