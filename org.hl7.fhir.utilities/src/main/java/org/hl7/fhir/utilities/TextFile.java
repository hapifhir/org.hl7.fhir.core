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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
	  final File file = new CSFile(path);
    return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
	}
	
	public static void writeAllLines(String path, List<String> lines) throws IOException
	{
	  final File file = new CSFile(path);
    Files.write(file.toPath(), lines, StandardCharsets.UTF_8);
	}
	
  public static void stringToStream(final String content, final OutputStream stream) throws IOException {
    stream.write(content.getBytes(StandardCharsets.UTF_8));
  }
  
  public static byte[] stringToBytes(final String content) throws IOException {
    return content.getBytes(StandardCharsets.UTF_8);
  }
  
  public static void stringToFile(final String content, final String path) throws IOException  {
    final File file = new CSFile(path);
    stringToFile(content, file);
  }


  public static void stringToFile(final String content, final File file) throws IOException {
    try (final OutputStream output = Files.newOutputStream(file.toPath())) {
      output.write(content.getBytes(StandardCharsets.UTF_8));
    }
  }  
  
  public static void stringToFileWithBOM(final String content, final File file) throws IOException  {
    try (final OutputStream output = Files.newOutputStream(file.toPath())) {
      output.write(new byte[]{(byte)239, (byte)187, (byte)191});
      output.write(content.getBytes(StandardCharsets.UTF_8));
    }
  }
  
  public static void stringToFileWithBom(final String content, final String path) throws IOException  {
    final File file = new CSFile(path);
    stringToFileWithBOM(content, file);
  }
  

  public static String fileToString(final File f) throws FileNotFoundException, IOException {
    // Files.readString(Path) will fail on invalid UTF-8 byte sequences, so we use Files.readAllBytes() instead.
    // This would happen when reading an XSLX file, for example.
    return new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
  }
  
  public static String fileToString(final String src) throws FileNotFoundException, IOException  {
    final CSFile f = new CSFile(src);
    if (!f.exists()) {
      throw new IOException("File "+src+" not found");
    }
    return fileToString(f);
  }

  public static String streamToString(final InputStream input) throws IOException  {
    return new String(input.readAllBytes(), StandardCharsets.UTF_8).replace("\uFEFF", "");
  }

  public static byte[] streamToBytes(final InputStream input) throws IOException  {
    if (input == null) {
      return null;
    }
    final byte[] read = input.readAllBytes();
    input.close();
    return read;
  }

  public static byte[] streamToBytesNoClose(final InputStream input) throws IOException  {
    if (input == null) {
      return null;
    }
    return input.readAllBytes();
  }

  public static void bytesToFile(final byte[] bytes, final String path) throws IOException {
    try (final OutputStream sw = new FileOutputStream(new CSFile(path))) {
      sw.write(bytes);
    }
  }
  
  public static void bytesToFile(final byte[] bytes, final File f) throws IOException {
    try (final OutputStream sw = new FileOutputStream(f)) {
      sw.write(bytes);
    }
  }
  
  public static void appendBytesToFile(final byte[] bytes, final String path) throws IOException {
    byte[] linebreak = new byte[] {13, 10};
    Files.write(Paths.get(path), linebreak, StandardOpenOption.APPEND);
    Files.write(Paths.get(path), bytes, StandardOpenOption.APPEND);
  }

  public static byte[] fileToBytes(final String srcFile) throws FileNotFoundException, IOException {
    final File f = new CSFile(srcFile);
    return Files.readAllBytes(f.toPath());
  }

  /**
   * 
   * fileToBytes insists in case correctness to ensure that stuff works across linux and windows, but it's not always appropriate to check case (e.g. validator parameters)
   * 
   * @param srcFile
   * @return
   * @throws FileNotFoundException
   * @throws IOException
   */
  public static byte[] fileToBytesNCS(final String srcFile) throws FileNotFoundException, IOException {
    return Files.readAllBytes(Path.of(srcFile));
  }

  public static byte[] fileToBytes(final File file) throws FileNotFoundException, IOException {
    return Files.readAllBytes(file.toPath());
  }

  public static String bytesToString(final byte[] bs) throws IOException {
    return new String(bs, StandardCharsets.UTF_8);
  }

  public static String bytesToString(final byte[] bs, final boolean removeBOM) throws IOException {
    final String read = new String(bs, StandardCharsets.UTF_8);
    if (removeBOM)
      return read.replace("\uFEFF", "");
    else
      return read;
  }

  public static void streamToFile(final InputStream stream, final String filename) throws IOException {
    Files.copy(stream, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
    stream.close();
  }

  public static void streamToFileNoClose(final InputStream stream, final String filename) throws IOException {
    Files.copy(stream, Path.of(filename), StandardCopyOption.REPLACE_EXISTING);
  }
}