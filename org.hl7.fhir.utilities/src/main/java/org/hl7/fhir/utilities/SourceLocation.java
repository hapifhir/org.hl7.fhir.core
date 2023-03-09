package org.hl7.fhir.utilities;

public class SourceLocation {
  private int line;
  private int column;
  public  SourceLocation(int line, int column) {
    super();
    this.line = line;
    this.column = column;
  }
  public int getLine() {
    return line;
  }
  public int getColumn() {
    return column;
  }
  public void setLine(int line) {
    this.line = line;
  }
  public void setColumn(int column) {
    this.column = column;
  }

  public String toString() {
    return Integer.toString(line)+", "+Integer.toString(column);
  }
  
  public void newLine() {
    setLine(getLine() + 1);
    setColumn(1);
  }
  public boolean checkChar(char ch, boolean last13) {
    if (ch == '\r') {
      newLine();
      return true;
    } else if (ch == '\n') {
      if (!last13) {
        newLine();
      }
      return false;
    } else {
      setColumn(getColumn() + 1);
      return false;
    }
  }
  public SourceLocation copy() {
    return new SourceLocation(line, column);
  }
}
