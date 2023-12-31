package org.hl7.fhir.utilities;

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



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Set of static helper functions to read lines from files, create files from lists of lines,
 * read files into a single string and create files from a single string.
 * @author Ewout
 *
 */
public class TextFile {

	public static List<String> readAllLines(String path) throws IOException
	{
		List<String> result = new ArrayList<String>();
		
		File file = new CSFile(path);
		FileInputStream fs = new FileInputStream(file);
		try {
		  BufferedReader reader = new BufferedReader(new InputStreamReader(fs,"UTF-8"));

		  while( reader.ready() )
		    result.add(reader.readLine());

		  reader.close();
		  return result;
		} finally {
		  fs.close();
		}
	}
	
	public static void writeAllLines(String path, List<String> lines) throws IOException
	{
		File file = new CSFile(path);
		FileOutputStream s = new FileOutputStream(file);
		OutputStreamWriter sw = new OutputStreamWriter(s, "UTF-8");
		for( String line : lines )
			sw.write(line + "\r\n");
		
		sw.flush();
		s.close();
	}
	
	
  public static void stringToFile(String content, File file) throws IOException {
    FileOutputStream fs = new FileOutputStream(file);
    try {
      OutputStreamWriter sw = new OutputStreamWriter(fs, "UTF-8");
      sw.write('\ufeff');  // Unicode BOM, translates to UTF-8 with the configured outputstreamwriter
      sw.write(content);
      sw.flush();
      sw.close();
    } finally {
      fs.close();
    }
  }
  
  public static void stringToStream(String content, OutputStream stream, boolean bom) throws IOException {
    OutputStreamWriter sw = new OutputStreamWriter(stream, "UTF-8");
    if (bom) {
      sw.write('\ufeff');  // Unicode BOM, translates to UTF-8 with the configured outputstreamwriter
    }
    sw.write(content);
    sw.flush();
    sw.close();
  }
  
  public static byte[] stringToBytes(String content, boolean bom) throws IOException {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    OutputStreamWriter sw = new OutputStreamWriter(bs, "UTF-8");
    if (bom)
      sw.write('\ufeff');  // Unicode BOM, translates to UTF-8 with the configured outputstreamwriter
    sw.write(content);
    sw.flush();
    sw.close();
    return bs.toByteArray(); 
  }
  
  public static void stringToFile(String content, String path) throws IOException  {
    File file = new CSFile(path);
    stringToFile(content, file);
  }

  public static void stringToFile(String content, File file, boolean bom) throws IOException  {
    FileOutputStream fs = new FileOutputStream(file);
    OutputStreamWriter sw = new OutputStreamWriter(fs, "UTF-8");
    if (bom)
      sw.write('\ufeff');  // Unicode BOM, translates to UTF-8 with the configured outputstreamwriter
    sw.write(content);
    sw.flush();
    sw.close();
  }
  
  public static void stringToFile(String content, String path, boolean bom) throws IOException  {
    File file = new CSFile(path);
    stringToFile(content, file, bom);
  }

  public static void stringToFileNoPrefix(String content, String path) throws IOException  {
    File file = new CSFile(path);
    OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
    sw.write(content);
    sw.flush();
    sw.close();
  }

  public static String fileToString(File f) throws FileNotFoundException, IOException {
    FileInputStream fs = new FileInputStream(f);
    try {
      return streamToString(fs);
    } finally {
      fs.close();
    }
  }
  
  public static String fileToString(String src) throws FileNotFoundException, IOException  {
    CSFile f = new CSFile(src);
    if (!f.exists()) {
      throw new IOException("File "+src+" not found");
    }
    FileInputStream fs = new FileInputStream(f);
    try {
      return streamToString(fs);
    } finally {
      fs.close();
    }
  }

  public static String streamToString(InputStream input) throws IOException  {
    InputStreamReader sr = new InputStreamReader(input, "UTF-8");    
    StringBuilder b = new StringBuilder();
    //while (sr.ready()) { Commented out by Claude Nanjo (1/14/2014) - sr.ready() always returns false - please remove if change does not impact other areas of codebase
    int i = -1;
    while((i = sr.read()) > -1) {
      char c = (char) i;
      b.append(c);
    }
    sr.close();
    
    return  b.toString().replace("\uFEFF", ""); 
  }

  public static byte[] streamToBytes(InputStream input) throws IOException  {
    if (input== null) {
      return null;
    }
    ByteArrayOutputStream r = new ByteArrayOutputStream(2048);
    byte[] read = new byte[512]; 
    for (int i; -1 != (i = input.read(read)); r.write(read, 0, i));
    input.close();
    return r.toByteArray();
  }

  public static byte[] streamToBytesNoClose(InputStream input) throws IOException  {
    if (input== null) {
      return null;
    }
    ByteArrayOutputStream r = new ByteArrayOutputStream(2048);
    byte[] read = new byte[512]; 
    for (int i; -1 != (i = input.read(read)); r.write(read, 0, i));
    return r.toByteArray();
  }

  public static void bytesToFile(byte[] bytes, String path) throws IOException {
    File file = new CSFile(path);
    OutputStream sw = new FileOutputStream(file);
    sw.write(bytes);
    sw.flush();
    sw.close(); 
  }
  
  public static void bytesToFile(byte[] bytes, File f) throws IOException {
    OutputStream sw = new FileOutputStream(f);
    sw.write(bytes);
    sw.flush();
    sw.close(); 
  }
  
  public static void appendBytesToFile(byte[] bytes, String path) throws IOException {
    byte[] linebreak = new byte[] {13, 10};
    Files.write(Paths.get(path), linebreak, StandardOpenOption.APPEND);
    Files.write(Paths.get(path), bytes, StandardOpenOption.APPEND);
  }

  public static byte[] fileToBytes(String srcFile) throws FileNotFoundException, IOException {
    FileInputStream fs = new FileInputStream(new CSFile(srcFile));
    try {
      return streamToBytes(fs);
    } finally {
      fs.close();
    }
  }

  /**
   * 
   * fileToBytes insists in case correctness to ensure that stuff works across linux and windows, but it's not always appropriate to ceheck case (e.g. validator parameters)
   * 
   * @param srcFile
   * @return
   * @throws FileNotFoundException
   * @throws IOException
   */
  public static byte[] fileToBytesNCS(String srcFile) throws FileNotFoundException, IOException {
    FileInputStream fs = new FileInputStream(new File(srcFile));
    try {
      return streamToBytes(fs);
    } finally {
      fs.close();
    }
  }

  public static byte[] fileToBytes(File file) throws FileNotFoundException, IOException {
    FileInputStream fs = new FileInputStream(file);
    try {
      return streamToBytes(fs);
    } finally {
      fs.close();
    }
  }

  public static String bytesToString(byte[] bs) throws IOException {
    return streamToString(new ByteArrayInputStream(bs));
  }

  public static String bytesToString(byte[] bs, boolean removeBOM) throws IOException {
    if (removeBOM)
      return streamToString(new ByteArrayInputStream(bs)).replace("\uFEFF", "");
    else
      return streamToString(new ByteArrayInputStream(bs));
  }

  public static void streamToFile(InputStream stream, String filename) throws IOException {
    byte[] cnt = streamToBytes(stream);
    bytesToFile(cnt, filename);
  }

  public static void streamToFileNoClose(InputStream stream, String filename) throws IOException {
    byte[] cnt = streamToBytesNoClose(stream);
    bytesToFile(cnt, filename);
  }
}