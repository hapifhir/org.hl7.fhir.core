package org.hl7.fhir.utilities.graphql;

public class GraphQLResponse extends ObjectValue {
  private boolean writeWrapper = true;

  /**
   * Should the "data" wrapper br written along with the output
   */
  public void setWriteWrapper(boolean theWriteWrapper) {
    writeWrapper = theWriteWrapper;
  }

  @Override
  public void write(StringBuilder b, Integer indent, String lineSeparator) throws EGraphQLException, EGraphEngine {

    if (writeWrapper) {
      // Write the wrapper
      b.append("{ \"data\": ");
    }

    super.write(b, indent, lineSeparator);

    if (writeWrapper) {
      // Terminate the wrapper
      b.append("}");
    }

  }
}