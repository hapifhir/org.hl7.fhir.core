package org.hl7.fhir.r5.testfactory.dataprovider;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

/**
 * Concrete implementation of TableDataProvider that reads data from a SQL database table.
 */
@MarkedToMoveToAdjunctPackage
public class SQLDataProvider extends TableDataProvider {

  private Connection connection;
  private String tableName;
  private List<String> columnHeaders;
  private ResultSet resultSet;
  private ResultSetMetaData metaData;
  private Map<String, Integer> columnIndexMap = new HashMap<>();
  private int counter;

  /**
   * Constructs an SQLDataProvider.
   *
   * @param connection The SQL database connection.
   * @param tableName  The name of the table to read.
   * @throws IOException If a database access error occurs.
   */
  public SQLDataProvider(Connection connection, String tableName) throws IOException {
    this.connection = connection;
    this.tableName = tableName;

    reset();
  }

  /**
   * Loads the column headers from the table's metadata.
   *
   * @throws IOException If a database access error occurs.
   */
  private void loadColumnHeaders() throws IOException {
    try (Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + " WHERE 1=0")) {
      metaData = rs.getMetaData();
      columnHeaders = new ArrayList<>();
      columnHeaders.add("counter");
      for (int i = 1; i <= metaData.getColumnCount(); i++) {
        String columnName = metaData.getColumnName(i);
        columnHeaders.add(columnName);
        columnIndexMap.put(columnName, i);
      }
    } catch (SQLException e) {
      throw new FHIRException("Error loading column headers: " + e.getMessage(), e);
    }
  }

  /**
   * Prepares the ResultSet for iterating over the table's rows.
   *
   * @throws IOException If a database access error occurs.
   */
  private void prepareResultSet() throws IOException {
    try {
      Statement statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM " + tableName);
    } catch (SQLException e) {
      throw new IOException("Error preparing result set: " + e.getMessage(), e);
    }
  }

  @Override
  public List<String> columns() {
    return columnHeaders;
  }

  @Override
  public boolean nextRow() throws FHIRException {
    try {
      counter++;
      return resultSet.next();
    } catch (SQLException e) {
      throw new FHIRException("Error moving to next row: " + e.getMessage(), e);
    }
  }

  @Override
  public List<String> cells() throws FHIRException {
    try {
      List<String> cellValues = new ArrayList<>();
      cellValues.add(""+counter);
      for (int i = 1; i <= metaData.getColumnCount(); i++) {
        cellValues.add(resultSet.getString(i));
      }
      return cellValues;
    } catch (SQLException e) {
      throw new FHIRException("Error retrieving row cells: " + e.getMessage(), e);
    }
  }

  @Override
  public String cell(String name) throws FHIRException {
    if ("counter".equals(name)) {
      return ""+counter;      
    } else {
      try {
        Integer columnIndex = columnIndexMap.get(name);
        if (columnIndex == null) {
          return null;
        }
        return resultSet.getString(columnIndex);
      } catch (SQLException e) {
        throw new FHIRException("Error retrieving cell value: " + e.getMessage(), e);
      }
    }
  }

  /**
   * Closes the ResultSet and releases the database resources.
   *
   * @throws IOException If a database access error occurs.
   */
  public void close() throws IOException {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      throw new IOException("Error closing resources: " + e.getMessage(), e);
    }
  }

  @Override
  public void reset() throws FHIRException {
    try {
      loadColumnHeaders();
      prepareResultSet();
    } catch (Exception e) {
      throw new FHIRException("Error closing resources: " + e.getMessage(), e);
    }
  }
}
