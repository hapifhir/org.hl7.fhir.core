package org.hl7.fhir.r4.utils.sql;

import java.util.List;

import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;

/**
 * Test implementation of Storage interface for SQL on FHIR tests.
 * Extends StorageJson to capture results as JSON for comparison.
 *
 * @author John Grimes
 */
public class TestStorage extends StorageJson {

  private JsonArray results;
  private List<Column> columns;

  @Override
  public Store createStore(String name, List<Column> columns) {
    this.columns = columns;
    this.results = new JsonArray();
    // Call parent to initialise internal state.
    Store store = super.createStore(name, columns);
    // Override the parent's rows array with our own.
    this.results = super.getRows();
    return store;
  }

  /**
   * Get the captured results as a JsonArray.
   */
  public JsonArray getResults() {
    return results != null ? results : new JsonArray();
  }

  /**
   * Get the column definitions.
   */
  public List<Column> getColumns() {
    return columns;
  }

  /**
   * Clear all results.
   */
  public void clear() {
    if (results != null) {
      results = new JsonArray();
    }
    columns = null;
  }

  @Override
  public String getKeyForSourceResource(Base res) {
    // Return a simple key for testing.
    if (res != null) {
      return res.fhirType() + "/" + res.getIdBase();
    }
    return null;
  }

  @Override
  public String getKeyForTargetResource(Base res) {
    // Return a simple key for testing.
    if (res != null) {
      return res.fhirType() + "/" + res.getIdBase();
    }
    return null;
  }
}