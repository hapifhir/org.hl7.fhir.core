package org.hl7.fhir.validation.instance.type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IssueMessage;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.r5.utils.sql.Column;
import org.hl7.fhir.r5.utils.sql.ColumnKind;
import org.hl7.fhir.r5.utils.sql.Runner;
import org.hl7.fhir.r5.utils.validation.ValidatorSession;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

// see also org.hl7.fhir.r5.utils.sql.Validator
public class ViewDefinitionValidator extends BaseValidator {

  private static class VersionEvaluationContext {
    private IWorkerContext context;
    private Runner runner;
    private FHIRPathEngine fpe;
    public VersionEvaluationContext(IWorkerContext context) {
      this.context = context;
      runner = new Runner();
      runner.setContext(context);

      fpe = new FHIRPathEngine(context); // we need our own customised one
      fpe.setHostServices(runner);
      fpe.setEmitSQLonFHIRWarning(true);
    }
  }

  public ViewDefinitionValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateViewDefinition(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, NodeStack stack) throws FHIRException {
    boolean ok = true;
    if (warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, vd.hasChild("name"), I18nConstants.VIEWDEFINITION_SHOULD_HAVE_NAME)) {
      warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, isValidName(vd.getNamedChildValue("name")), I18nConstants.VIEWDEFINITION_NAME_INVALID, "view", vd.getNamedChildValue("name"));
    }

    List<Column> columns = new ArrayList<>();    
    vd.setUserData(UserDataNames.db_columns, columns);

    List<VersionEvaluationContext> versions = new ArrayList<>();
    if (vd.hasChildren("fhirVersion")) {
      for (Element v : vd.getChildren("fhirVersion")) {
        String ver = v.primitiveValue();
        if (ver.equals(context.getVersion())) {
          makeDefaultContext(versions);
        } else {
          try {
            makeVersionSpecificContext(versions, ver);
          } catch (IOException e) {
            throw new FHIRException(e);
          }
        }
      }
    } else {
      makeDefaultContext(versions);
    }

    boolean first = true;
    for (VersionEvaluationContext vec : versions) {
      String vdesc = versions.size() == 1 ? "" : " for version "+VersionUtilities.getNameForVersion(vec.context.getVersion());

      String resourceName = vd.getNamedChildValue("resource");
      if (resourceName != null) {
        if (rule(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, context.getResourceNamesAsSet().contains(resourceName), I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE, resourceName)) {
          int i = 0;
          if (first) {
            for (Element constant : vd.getChildren("constant")) {
              ok = checkConstant(hostContext, errors, stack.push(constant, i, null, null), constant) && ok;
              i++;
            }
          }
          i = 0;
          for (Element where : vd.getChildren("where")) {
            ok = checkWhere(hostContext, errors, vd, stack.push(where, i, null, null), where, resourceName, vec, vdesc, first) && ok;
            i++;
          }

          TypeDetails t = new TypeDetails(CollectionStatus.SINGLETON, resourceName);
          i = 0;
          for (Element select : vd.getChildren("select")) {
            ok = checkSelect(hostContext, errors, vd, vd, stack.push(select, i, null, null), select, resourceName, t, columns, vec, vdesc, first) && ok;
            i++;
          }
        } 
      } else {
        ok = false;
      }
      first = false;
    }
    return ok;
  }

  private void makeVersionSpecificContext(List<VersionEvaluationContext> versions, String ver) throws FHIRException, IOException {
    if (session.getObjects().containsKey(ValidatorSession.VIEW_DEFINITION_CONTEXT+"."+ver)) {
      versions.add((VersionEvaluationContext) session.getObjects().get(ValidatorSession.VIEW_DEFINITION_CONTEXT+"."+ver));
    } else {
      FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
      NpmPackage npm = pcm.loadPackage(VersionUtilities.packageForVersion(ver));
      SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm);
      var vec = new VersionEvaluationContext(context);
      session.getObjects().put(ValidatorSession.VIEW_DEFINITION_CONTEXT+"."+context.getVersion(), vec);
      versions.add(vec);
    }
  }

  private void makeDefaultContext(List<VersionEvaluationContext> versions) {
    if (session.getObjects().containsKey(ValidatorSession.VIEW_DEFINITION_CONTEXT+"."+context.getVersion())) {
      versions.add((VersionEvaluationContext) session.getObjects().get(ValidatorSession.VIEW_DEFINITION_CONTEXT+"."+context.getVersion()));
    } else {
      var vec = new VersionEvaluationContext(context);
      session.getObjects().put(ValidatorSession.VIEW_DEFINITION_CONTEXT+"."+context.getVersion(), vec);
      versions.add(vec);
    }
  }

  private boolean checkSelect(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, Element parent, NodeStack stack, Element select, 
      String resourceName, TypeDetails t, List<Column> columns, VersionEvaluationContext vec, String vdesc, boolean first) {
    select.setUserData(UserDataNames.db_columns, columns);
    boolean ok = true;

    if (select.hasChild("forEach")) {
      Element e = select.getNamedChild("forEach");
      t = checkForEach(hostContext, errors, vd, select, stack.push(e, -1, null, null), e, resourceName, t, vec, vdesc, first);
    } else if (select.hasChild("forEachOrNull")) {
      Element e = select.getNamedChild("forEachOrNull");
      t = checkForEachOrNull(hostContext, errors, vd, select, stack.push(e, -1, null, null), e, resourceName, t, vec, vdesc, first);
    } 

    if (t == null) {
      ok = false;
    } else {

      if (select.hasChildren("column")) {      
        int i = 0;
        for (Element e : select.getChildren("column")) {
          ok = checkColumn(hostContext, errors, vd,select, stack.push(e,  i,  null, null), e, resourceName, t, columns, vec, vdesc, first) && ok;
          i++;
        }      
      }     

      if (select.hasChildren("select")) {    
        int i = 0;
        for (Element e : select.getChildren("select")) {
          ok = checkSelect(hostContext, errors, vd, select, stack.push(e,  i,  null, null), e, resourceName, t, columns, vec, vdesc, first) && ok;
          i++;
        }      
      }     

      if (select.hasChildren("unionAll")) {
        int i = 0;
        for (Element e : select.getChildren("unionAll")) {
          ok = checkUnion(hostContext, errors, vd, parent, stack.push(e,  i,  null, null), e, resourceName, t, columns, vec, vdesc, first)  && ok;
          i++;
        }
      } 
      checkColumnNamesUnique(errors, stack, columns);
    }
    return ok;
  }


  private void checkColumnNamesUnique(List<ValidationMessage> errors, NodeStack stack, List<Column> columns) {
    Set<String> names = new HashSet<>();
    for (Column col : columns) {
      if (col != null) {
        String name = col.getName();
        if (!names.contains(name)) {
          names.add(name);       
        } else if (!col.isDuplicateReported()) {
          col.setDuplicateReported(true);
          rule(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, false, I18nConstants.VIEWDEFINITION_DUPL_COL_NAME, name);
        }
      }
    }    
  }

  private boolean checkUnion(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, Element parent, NodeStack stack, 
      Element unionAll, String resourceName,  TypeDetails t, List<Column> columns, VersionEvaluationContext vec, String vdesc, boolean first) {
    return false;
    //      List<List<Column>> unionColumns = new ArrayList<>();
    //      int i = 0;
    //      for (JsonElement e : ((JsonArray) a)) {
    //        if (!(e instanceof JsonObject)) {
    //          error(path+".unionAll["+i+"]", e, "unionAll["+i+"] is not an object", IssueType.INVALID);
    //        } else { 
    //          unionColumns.add(checkSelect(vd, path+".unionAll["+i+"]", (JsonObject) e, t));
    //        }
    //        i++;
    //      }  
    //      if (i < 2) {
    //        warning(path+".unionAll", a, "unionAll should have more than one item");        
    //      }
    //      if (unionColumns.size() > 1) {
    //        List<Column> columns = unionColumns.get(0);
    //        for (int ic = 1; ic < unionColumns.size(); ic++) {
    //          String diff = columnDiffs(columns, unionColumns.get(ic));
    //          if (diff != null) {
    //            error(path+".unionAll["+i+"]", ((JsonArray) a).get(ic), "unionAll["+i+"] column definitions do not match: "+diff, IssueType.INVALID);            
    //          }
    //        }
    //        a.setUserData(UserDataNames.db_columns, columns);
    //        return columns;
    //      }
    //    }     
    //    return null;
  }

  private String columnDiffs(List<Column> list1, List<Column> list2) {
    if (list1.size() == list2.size()) {
      for (int i = 0; i < list1.size(); i++) {
        if (list1.get(i) == null || list2.get(i) == null) {
          return null; // just suppress any addition errors
        }
        String diff = list1.get(i).diff(list2.get(i));
        if (diff != null) {
          return diff+" at #"+i;
        }
      }
      return null;
    } else {
      return "Column counts differ: "+list1.size()+" vs "+list2.size();
    }
  }

  private boolean checkColumn(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, Element parent, NodeStack stack, Element column, String resourceName, 
      TypeDetails t, List<Column> columns, VersionEvaluationContext vec, String vdesc, boolean first) {
    boolean ok = false;
    String expr = column.getNamedChildValue("path");
    if (expr != null) {
      ExpressionNode n = getParsedExpression(column, vec.fpe, expr, errors, stack, UserDataNames.db_path);
      if (n != null) {
        ok = true;
        CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("; ");
        List<IssueMessage> warnings = new ArrayList<>();
        TypeDetails td = null;
        try {
          td = vec.fpe.checkOnTypes(vd, "Resource", resourceName, t, n, warnings);
        } catch (Exception e) {
          rule(errors, "2024-11-14", IssueType.EXCEPTION, stack, false, I18nConstants.VIEWDEFINITION_PATH_ERROR, e.getMessage(), vdesc);
          ok = false;
        }
        if (td != null) {
          for (IssueMessage s : warnings) {
            warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, false, I18nConstants.VIEWDEFINITION_PATH_WARNING, s.getMessage(), vdesc);
          }
          String columnName = column.getNamedChildValue("name");
          if (columnName == null) {
            List<String> names = n.getDistalNames();
            if (names.size() == 1 && names.get(0) != null) {
              columnName = names.get(0);
              ok = rule(errors, "2024-11-14", IssueType.INVALID, stack, isValidName(columnName), I18nConstants.VIEWDEFINITION_NAME_REQUIRED_HINT, columnName) && ok;
            } else {
              ok = false;
              rule(errors, "2024-11-14", IssueType.INVALID, stack, false, I18nConstants.VIEWDEFINITION_NAME_REQUIRED);
            }
          }
          if (columnName != null) {
            //            ok = rule(errors, "2024-11-14", IssueType.INVALID, stack, false, I18nConstants.VIEWDEFINITION_NAME_  REQUIRED) && ok;
            column.setUserData(UserDataNames.db_name, columnName);
            Boolean isColl = null;
            if (column.hasChild("collection")) {
              isColl = "true".equals(column.getNamedChildValue("collection"));
            }
            if (isColl != null && isColl) {
              if (td.getCollectionStatus() == CollectionStatus.SINGLETON) {
                if (!hint(errors, "2024-11-14", IssueType.INFORMATIONAL, stack, false, I18nConstants.VIEWDEFINITION_COLLECTION_NOT_NEEDED, expr, columnName)) {
                  b.append(context.formatMessage(I18nConstants.VIEWDEFINITION_COLLECTION_NOT_NEEDED, expr, columnName));
                }
              }
              if (!hint(errors, "2024-11-14", IssueType.INFORMATIONAL, stack, false, I18nConstants.VIEWDEFINITION_COLLECTION_NOT_ALWAYS)) {         
                b.append(context.formatMessage(I18nConstants.VIEWDEFINITION_COLLECTION_NOT_ALWAYS));   
              }
            } else if (isColl == null) {
              if (!hint(errors, "2024-11-14", IssueType.INFORMATIONAL, stack, td.getCollectionStatus() == CollectionStatus.SINGLETON, I18nConstants.VIEWDEFINITION_COLLECTION_NEEDED1, expr, columnName, vdesc)) {
                b.append(context.formatMessage(I18nConstants.VIEWDEFINITION_COLLECTION_NEEDED1, expr, columnName, vdesc));                          
              }
            } else {
              if (!hint(errors, "2024-11-14", IssueType.INFORMATIONAL, stack, td.getCollectionStatus() == CollectionStatus.SINGLETON, I18nConstants.VIEWDEFINITION_COLLECTION_NEEDED1, expr, columnName, vdesc)) {
                b.append(context.formatMessage(I18nConstants.VIEWDEFINITION_COLLECTION_NEEDED2, expr, columnName, vdesc));                          
              }              
            }
            Set<String> types = new HashSet<>();
            if (n.isNullSet()) {
              types.add("null");
            } else {
              // ok collection is sorted
              for (String type : td.getTypes()) {
                types.add(simpleType(type));
              }

              String type = column.getNamedChildValue("type");
              if (type != null) {
                if (td.hasType(type)) {
                  types.clear();
                  types.add(simpleType(type));
                } else {
                  ok = rule(errors, "2024-11-14", IssueType.INVALID, stack, false, I18nConstants.VIEWDEFINITION_TYPE_MISMATCH, expr, type, td.describe(), vdesc) && ok;
                }
              }
            }        
            if (types.size() != 1) {
              ok = rule(errors, "2024-11-14", IssueType.INVALID, stack, false, I18nConstants.VIEWDEFINITION_UNABLE_TO_TYPE, td.describe(), vdesc) && ok;
            } else {
              String type = types.iterator().next();
              boolean tok = false;
              if (!isSimpleType(type) && !"null".equals(type)) {
                hint(errors, "2024-11-14", IssueType.INFORMATIONAL, stack, false, I18nConstants.VIEWDEFINITION_COMPLEX_TYPE, expr, type, vdesc);    
              } else {
                tok = true;
              }
              if (tok) {
                if (first) {
                  Column col = new Column(columnName, isColl, type, kindForType(type));
                  column.setUserData(UserDataNames.db_column, col);
                  col.setNotes(b.toString());
                  columns.add(col);
                } else if (b.count() > 0){
                  Column col = null;
                  for (Column c : columns) {
                    if (c.getName().equals(columnName)) {
                      col = c;
                    }
                  }
                  if (col != null) {
                    col.addNote(b.toString());
                  }
                }
              } else {
                ok = false;
              }
            }
          }
        }
      }
    }
    return ok;
  }

  private ColumnKind kindForType(String type) {
    switch (type) {
    case "null": return ColumnKind.Null;
    case "dateTime": return ColumnKind.DateTime;
    case "boolean": return ColumnKind.Boolean;
    case "integer": return ColumnKind.Integer;
    case "decimal": return ColumnKind.Decimal;
    case "string": return ColumnKind.String;
    case "canonical": return ColumnKind.String;
    case "url": return ColumnKind.String;
    case "uri": return ColumnKind.String;
    case "oid": return ColumnKind.String;
    case "uuid": return ColumnKind.String;
    case "id": return ColumnKind.String;
    case "code": return ColumnKind.String;
    case "base64Binary": return ColumnKind.Binary;
    case "time": return ColumnKind.Time;
    default: return ColumnKind.Complex;
    }
  }

  private boolean isSimpleType(String type) {
    return Utilities.existsInList(type, "dateTime", "boolean", "integer", "decimal", "string", "base64Binary", "id", "code", "date", "time", "canonical", "uri", "url");
  }

  private String simpleType(String type) {
    type = type.replace("http://hl7.org/fhirpath/System.", "").replace("http://hl7.org/fhir/StructureDefinition/", "");
    if (Utilities.existsInList(type, "date", "dateTime", "instant")) {
      return "dateTime";
    }
    if (Utilities.existsInList(type, "Boolean", "boolean")) {
      return "boolean";
    }
    if (Utilities.existsInList(type, "Integer", "integer", "integer64")) {
      return "integer";
    }
    if (Utilities.existsInList(type, "Decimal", "decimal")) {
      return "decimal";
    }
    if (Utilities.existsInList(type, "String", "string", "code")) {
      return "string";
    }
    if (Utilities.existsInList(type, "Time", "time")) {
      return "time";
    }
    if (Utilities.existsInList(type, "base64Binary")) {
      return "base64Binary";
    }
    return type;
  }

  private TypeDetails checkForEach(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, Element parent, NodeStack stack, 
      Element expression, String resourceName, TypeDetails t, VersionEvaluationContext vec, String vdesc, boolean first) {
    String expr = expression.primitiveValue();
    if (expr != null) {
      ExpressionNode n = getParsedExpression(parent, vec.fpe, expr, errors, stack, UserDataNames.db_forEach);
      if (n != null) {

        List<IssueMessage> warnings = new ArrayList<>();
        TypeDetails td = null;
        try {
          td = vec.fpe.checkOnTypes(vd, "Resource", resourceName, t, n, warnings);
        } catch (Exception e) {        
          rule(errors, "2024-11-14", IssueType.EXCEPTION, stack, false, I18nConstants.VIEWDEFINITION_PATH_ERROR, e.getMessage(), vdesc);
          return null;
        }
        if (td != null) {
          for (IssueMessage s : warnings) {
            warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, false, I18nConstants.VIEWDEFINITION_PATH_WARNING, s.getMessage(), vdesc);
          }
        }
        return td;
      }
    }
    return null;

  }

  private TypeDetails checkForEachOrNull(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, Element parent, NodeStack stack, 
      Element  expression, String resourceName,  TypeDetails t, VersionEvaluationContext vec, String vdesc, boolean first) {
    String expr = expression.primitiveValue();
    if (expr != null) {
      ExpressionNode n = getParsedExpression(parent, vec.fpe, expr, errors, stack, UserDataNames.db_forEachOrNull);
      if (n != null) {
        List<IssueMessage> warnings = new ArrayList<>();
        TypeDetails td = null;
        try {
          td = vec.fpe.checkOnTypes(vd, "Resource", resourceName, t, n, warnings);
        } catch (Exception e) {     
          rule(errors, "2024-11-14", IssueType.EXCEPTION, stack, false, I18nConstants.VIEWDEFINITION_PATH_ERROR, e.getMessage(), vdesc);
          return null;
        }
        if (td != null) {
          for (IssueMessage s : warnings) {        
            warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, false, I18nConstants.VIEWDEFINITION_PATH_WARNING, s.getMessage(), vdesc);
          }
        }
        return td;
      }
    }
    return null;
  }

  private boolean checkConstant(ValidationContext hostContext, List<ValidationMessage> errors, NodeStack stack, Element constant) {
    String name = constant.getNamedChildValue("name");
    warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, isValidName(name), I18nConstants.VIEWDEFINITION_NAME_INVALID, "constant", name);
    return true;
  }

  private boolean checkWhere(ValidationContext hostContext, List<ValidationMessage> errors, Element vd, NodeStack stack, Element where, 
      String resourceName, VersionEvaluationContext vec, String vdesc, boolean first) {
    boolean ok = true;
    String expr = where.getNamedChildValue("path");
    if (expr != null) {
      ExpressionNode n = getParsedExpression(where, vec.fpe, expr, errors, stack, UserDataNames.db_path);
      if (n != null) {
        List<String> types = new ArrayList<>();
        List<IssueMessage> warnings = new ArrayList<>();
        types.add(resourceName);
        TypeDetails td = null;
        try {
          td = vec.fpe.checkOnTypes(vd, "Resource", resourceName, types, n, warnings);} 
        catch (Exception e) {
          rule(errors, "2024-11-14", IssueType.EXCEPTION, stack, false, I18nConstants.VIEWDEFINITION_PATH_ERROR, e.getMessage(), vdesc);
          ok = false;
        }
        if (td != null) {
          if (td.getCollectionStatus() != CollectionStatus.SINGLETON || td.getTypes().size() != 1 || !td.hasType("boolean")) {
            rule(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, false, I18nConstants.VIEWDEFINITION_PATH_WRONG_RETURN, expr, td.describe(), vdesc);
            ok = false;
          } else {
            for (IssueMessage s : warnings) {
              warning(errors, "2024-11-14", IssueType.BUSINESSRULE, stack, false, I18nConstants.VIEWDEFINITION_PATH_WARNING, s.getMessage(), vdesc);
            }
          }
        }
      }
    }
    return ok;
  }

  private ExpressionNode getParsedExpression(Element focus, FHIRPathEngine fpe, String expr, List<ValidationMessage> errors, NodeStack stack, String udName) {
    if (focus.hasUserData(UserDataNames.db_path)) {
      return (ExpressionNode) focus.getUserData(udName);
    }

    ExpressionNode n = null;
    try {
      n = fpe.parse(expr);
    } catch (Exception e) {
      rule(errors, "2024-11-14", IssueType.EXCEPTION, stack, false, I18nConstants.VIEWDEFINITION_PATH_ERROR, e.getMessage(), "");
    }
    focus.setUserData(udName, n);
    return n;
  }

  private boolean isValidName(String name) {
    boolean first = true;
    for (char c : name.toCharArray()) {
      if (!(Character.isAlphabetic(c) || Character.isDigit(c) || (!first && c == '_'))) {
        return false;
      }
      first = false;
    }
    return true;
  }

}