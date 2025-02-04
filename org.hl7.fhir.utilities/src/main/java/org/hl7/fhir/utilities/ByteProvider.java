package org.hl7.fhir.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;


public abstract class ByteProvider {

  public abstract byte[] getBytes() throws FileNotFoundException, IOException;

  // this one needs to be deprecated - or try to to use it - get to the source
  public static ByteProvider forStream(InputStream stream) throws IOException {
    return new ByteProviderBytes(FileUtilities.streamToBytes(stream));
  }

  public static ByteProvider forBytes(byte[] bytes) {
    return new ByteProviderBytes(bytes);
  }

  public static ByteProvider forFile(File ff) {
    return new ByteProviderFile(ff);
  }

  public static ByteProvider forFile(String src) throws IOException {
    return new ByteProviderFile(ManagedFileAccess.file(src));
  }

  private static class ByteProviderBytes extends ByteProvider {

    private byte[] cnt;
    
    protected ByteProviderBytes(byte[] cnt) {
      this.cnt = cnt;
    }

    @Override
    public byte[] getBytes() {
      return cnt;
    }
    
  }

  private static class ByteProviderFile extends ByteProvider {

    private File file;
    
    protected ByteProviderFile(File file) {
      this.file = file;
    }

    @Override
    public byte[] getBytes() throws FileNotFoundException, IOException {
      return FileUtilities.fileToBytes(file);
    }
    
  }
}
