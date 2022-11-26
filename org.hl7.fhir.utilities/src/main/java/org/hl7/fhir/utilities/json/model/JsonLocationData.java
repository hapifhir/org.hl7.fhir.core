package org.hl7.fhir.utilities.json.model;

public class JsonLocationData {
  private int line;
  private int col;
  private int lastCol;
  
  public JsonLocationData(int line, int col) {
    super();
    this.line = line;
    this.col = col;
    this.lastCol = col;
  }
  
  public int getLine() {
    return line;
  }
  
  public int getCol() {
    return col;
  }
  
  public void newLine() {
    line++;
    lastCol = col;
    col = 1;    
  }

  public JsonLocationData copy() {
    return new JsonLocationData(line, col);
  }

  public void incCol() {
    col++;
  }

  @Override
  public String toString() {
    return "(" + line + ", " + col + ")";
  }

  public JsonLocationData prev() {
    if (col == 1) {
      return new JsonLocationData(line-1, lastCol);
    } else {
      return new JsonLocationData(line, col-1);
    }
  }

  public void back() {
    if (col == 1) {
      line--;
      col = lastCol;
    } else {
      col--;
    }
  }
  
}