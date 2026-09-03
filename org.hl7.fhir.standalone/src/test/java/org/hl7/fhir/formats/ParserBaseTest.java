package org.hl7.fhir.formats;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.formats.ParserBase;
import org.hl7.fhir.model.core.formats.ParserType;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ParserBaseTest {

  public static final String SLASHED_O = "ø";
  private ParserBase parserBase;

    @BeforeEach
    public void beforeEach() {
    parserBase = new ParserBase(TestingUtilities.getSharedWorkerContext()) {
      @Override
      public ParserType getType() {
        return null;
      }

      @Override
      public Resource parse(InputStream input) throws IOException, FHIRFormatError {
        return null;
      }

      @Override
      public DataType parseType(InputStream input, String knownType) throws IOException, FHIRFormatError {
        return null;
      }

      @Override
      public DataType parseAnyType(InputStream input, String knownType) throws IOException, FHIRFormatError {
        return null;
      }

      @Override
      public void compose(OutputStream stream, Resource resource) throws IOException {
        stream.write(SLASHED_O.getBytes("UTF-8"));
      }

      @Override
      public void compose(OutputStream stream, DataType type, String rootName) throws IOException {
        stream.write(SLASHED_O.getBytes("UTF-8"));
      }
    };
    }

    @Test
    public void composeString_forResource_worksForCurrentEncoding() throws IOException {
      String actualString = parserBase.composeString(mock(Resource.class));
      assertEquals(SLASHED_O, actualString);
    }

    @Test
    public void composeString_forDataType_worksForCurrentEncoding() throws IOException {
      String actualString = parserBase.composeString(mock(DataType.class), "dummyName");
      assertEquals(SLASHED_O, actualString);
    }
}
