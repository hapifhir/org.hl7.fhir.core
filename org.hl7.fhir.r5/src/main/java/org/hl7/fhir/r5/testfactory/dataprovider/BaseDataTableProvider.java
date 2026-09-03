package org.hl7.fhir.r5.testfactory.dataprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;




public class BaseDataTableProvider {
  private Connection connection;
  Map<String, String> elements = new HashMap<>();
  Map<String, String> types = new HashMap<>();
  private boolean testing; 
  
  public BaseDataTableProvider(String filename) throws SQLException {
    super();
    connection = DriverManager.getConnection("jdbc:sqlite:"+filename);
    
    ResultSet rs = connection.createStatement().executeQuery("select * from TestElements");
    while (rs.next()) {
      elements.put(rs.getString("ElementId"), rs.getString("ElementKey"));
    }
    
    rs = connection.createStatement().executeQuery("select * from TestTypes");
    while (rs.next()) {
      types.put(rs.getString("TypeName"), rs.getString("TypeKey"));
    }
  }
  
  public String getPrimitiveValue(String elementId, String typeName) throws SQLException {
    String ek = elements.get(elementId);
    String tk = types.get(typeName);
    if (tk == null) {
      return null;
    }
    if (ek != null) {
      ResultSet rs = connection.createStatement().executeQuery("select ValueData from TestValues where ElementKey = "+ek+" and TypeKey = "+tk+(testing ? " ORDER BY ValueKey" : " ORDER BY RANDOM() LIMIT 1" ));
      if (rs.next()) {
        return rs.getString(1);
      }
    }
    ResultSet rs = connection.createStatement().executeQuery("select ValueData from TestValues where TypeKey = "+tk+(testing ? " ORDER BY ValueKey" : " ORDER BY RANDOM() LIMIT 1" ));
    if (rs.next()) {
      return rs.getString(1);
    }
    return null;
  }

  public Map<String, String> getComplexValue(String elementId, String typeName) throws SQLException {
    return getComplexValue(elementId, typeName, null);
  }

  /**
   * Fetch a (random) complex value from the base data. If system is not null, only rows whose
   * encoded value carries that system (e.g. system:http://loinc.org|:|...) are candidates - this
   * keeps randomly drawn values (unit, version, value etc) coherent with a system that the profile
   * has already fixed. If no row matches the system, returns null rather than an incoherent row.
   */
  public Map<String, String> getComplexValue(String elementId, String typeName, String system) throws SQLException {
    String ek = elements.get(elementId);
    String tk = types.get(typeName);
    if (tk == null) {
      return null;
    }
    String optionalSystemPredicate = systemFilter(system);
    if (ek != null) {
      String sql = "select ValueData from TestValues where ElementKey = "+ek+" and TypeKey = "+tk+optionalSystemPredicate+(testing ? " ORDER BY ValueKey" : " ORDER BY RANDOM() LIMIT 1" );
      ResultSet rs = connection.createStatement().executeQuery(sql);
      if (rs.next()) {
        return parse(rs.getString(1));
      }
    }
    String sql = "select ValueData from TestValues where TypeKey = "+tk+optionalSystemPredicate+(testing ? " ORDER BY ValueKey" : " ORDER BY RANDOM() LIMIT 1" );
    ResultSet rs = connection.createStatement().executeQuery(sql);
    if (rs.next()) {
      return parse(rs.getString(1));
    }
    return null;
  }

  private String systemFilter(String system) {
    if (system == null) {
      return "";
    }
    String s = system.replace("'", "''");
    // values are encoded name:value|:|name:value - the system field is either followed by the
    // |:| separator or is the last field in the row
    return " and (ValueData like '%system:"+s+"|%' or ValueData like '%system:"+s+"')";
  }

  private Map<String, String> parse(String value) {
    Map<String, String> map = new HashMap<>();
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //fixed-width separator, safe
    String[] parts = value.split("\\|\\:\\|");
    for (String p : parts) {
      String n = p.substring(0, p.indexOf(":"));
      String v = p.substring(p.indexOf(":")+1);
      
      map.put(n.trim(), v.trim());
    }
    return map;
  }

  public boolean isTesting() {
    return testing;
  }

  public void setTesting(boolean testing) {
    this.testing = testing;
  }
  
}