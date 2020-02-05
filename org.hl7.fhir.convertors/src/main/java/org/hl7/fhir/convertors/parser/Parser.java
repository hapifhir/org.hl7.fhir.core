package org.hl7.fhir.convertors.parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.nodeTypes.NodeWithIdentifier;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithStaticModifier;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.VarType;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserMethodDeclaration;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import jdk.nashorn.internal.runtime.options.Option;
import org.checkerframework.checker.nullness.Opt;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.dstu3.model.MedicationAdministration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Line auditing function, try copying based on line numbers and based on MethodDeclr, and compare the outputs
 */
public class Parser {

  public static final String ELEMENT = "Element";
  private static final String RESOURCE_FILE_FORMAT = "_%s"; //TODO fix
  private static final List<String> VERSION_FILES = Arrays.asList("10_30", "10_40", "10_50", "14_30", "14_40", "14_50", "30_40", "30_50", "40_50");
  private static final List<String> BASE_TYPES = Arrays.asList("Base64Binary", "Boolean", "Canonical", "Code",
    "Enumeration", "Date", "DateType", "Decimal", "Id", "Instant", "Integer", "Integer64",
    "Markdown", "Oid", "PositiveInt", "String", "Time", "UnsignedInt", "Uri", "Url",
    "Uuid", "XhtmlNode");

  private static final String ONE_TO_ONE = "tgt.set%1$sElement((%3$s%4$s) VersionConvertor_%2$s.convertType(src.get%1$sElement()));";
  private static final String ONE_TO_MANY = "tgt.set%1$s(Collections.singletonList((%3$s%4$s) VersionConvertor_%2$s.convertType(src.get%1$sElement())));";
  private static final String MANY_TO_ONE = "tgt.set%1$sElement((%3$s%4$s) VersionConvertor_%2$s.convertType(src.get%1$s().get(0)));";
  private static final String MANY_TO_MANY = "tgt.set%1$s(src.get%1$s().stream()\n" +
    ".map(toConvert -> (%3$s%4$s) VersionConvertor_%2$s.convertType(toConvert))\n" +
    ".collect(Collectors.toList())\n" +
    ");";

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes>
  convertMedicationAdministrationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> tgt
      = new org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes>();
    copyElement(src, tgt);
    tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(src.getValueAsString()));
    return tgt;
  }

  private static void copyElement(Enumeration<MedicationAdministration.MedicationAdministrationStatus> src,
                                  org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> tgt) {

  }


  /**
   * @param args
   */
  public static void main(String[] args) {
    /*
     * every tgt.setX(convertT(src.getX)) should be dependent on a hasX  - in principle that doesn't matter when you're
     * dealing with singleton elements if convertT checks for null and setX accepts null - which *should* be the case.
     * But there's enough special cases and other things that I have a lot less bugs where we always do if (src.hasX())
     */

    List<String> listOfPrimitiveTypes = BASE_TYPES;//getListOfPrimitiveTypes();

    try {
      initializeResolver(new File("").getAbsolutePath(), DIRECTORY_WHERE_THE_CODE_LIVES);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("get to version AuditEvent10_30 :: " + getModelImportToVersion("AuditEvent10_30"));
    System.out.println("get from version AuditEvent10_30 :: " + getModelImportFromVersion("AuditEvent10_30"));


//    VERSION_FILES.forEach(version -> {
      String version = "10_30";
      List<String> filenames = listAllJavaFilesInDirectory(new File("").getAbsolutePath() + "/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/");
      Collections.sort(filenames);
      filenames.forEach(name -> {
        try {
          modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/", name, ".java", listOfPrimitiveTypes, version);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      });
//    });
//
    try {
//    modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv40_50/", "Account40_50", ".java", listOfPrimitiveTypes, "10_30");
//    modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30/", "AuditEvent10_30", ".java", listOfPrimitiveTypes, "10_30");
//    modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30/", "Binary10_30", ".java", listOfPrimitiveTypes, "10_30");
//    modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30/", "Bundle10_30", ".java", listOfPrimitiveTypes, "10_30");
//    modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30/", "ClinicalImpression10_30", ".java", listOfPrimitiveTypes, "10_30");
//    modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv10_30/", "Communication10_30", ".java", listOfPrimitiveTypes, "10_30");
    } catch (Exception e) {
      System.out.println();
    }
    System.out.println();
  }

  public static void modifyElementNotField(String srcdirectory, String filename, String extension, List<String> listOfPrimitiveTypes, String version) throws FileNotFoundException {
    System.out.println("File :: " + filename);

    String projectDirectory = new File("").getAbsolutePath();
    long start = System.currentTimeMillis();

    CompilationUnit compilationUnit = getCompilationUnit(projectDirectory + srcdirectory + filename + extension);
    ClassOrInterfaceDeclaration classOrInterfaceDeclaration = initializeTypeSovlerAndParser(compilationUnit,
      projectDirectory, srcdirectory, filename);

    MethodDeclaration declaration;

    Optional<MethodDeclaration> declarationOption = classOrInterfaceDeclaration.getMethods().stream()
      .filter(md -> md.getNameAsString().equals("convert" + extractName(filename)))
      .findFirst();
    if (!declarationOption.isPresent()) {
      return;
    } else {
      declaration = declarationOption.get(); // Can't find
    }

    String lowerVersionTypeAbsPath = getLowerVersionAbsPathFromImportStatement(declaration.getTypeAsString(), declaration.getParameter(0).getTypeAsString(), version);
    String higherVersionTypeAbsPath = getHigherVersionAbsPath(declaration.getTypeAsString(), declaration.getParameter(0).getTypeAsString(), version);

    CompilationUnit lowerCU = StaticJavaParser.parse(new File(lowerVersionTypeAbsPath));
    CompilationUnit higherCU = StaticJavaParser.parse(new File(higherVersionTypeAbsPath));

    List<MethodDeclaration> methods = classOrInterfaceDeclaration.getMethods();
    for (MethodDeclaration md : methods) {

      String type = resolveInnerType(md.getType()).asString();
      String param = resolveInnerType(md.getParameter(0).getType()).asString();
      if (type == "void") continue;
      try {
        type = !type.contains(".") ? resolveInnerType(md.getType()).resolve().asReferenceType().getQualifiedName() : type;
      } catch (Exception e) {
        System.out.println();
      }

      param = !param.contains(".") ? resolveInnerType(md.getParameter(0).getType()).resolve().asReferenceType().getQualifiedName() : param;

      String absFilePathOfClassMethodIsConvertingTo = importStatementToAbsolutePath(type);
      String absFilePathOfClassMethodIsConvertingFrom = importStatementToAbsolutePath(param);
      String classNameMethodIsConvertingTo = absFilePathOfClassMethodIsConvertingTo.substring(absFilePathOfClassMethodIsConvertingTo.lastIndexOf('/') + 1, absFilePathOfClassMethodIsConvertingTo.lastIndexOf('.'));
      String classNameMethodIsConvertingFrom = absFilePathOfClassMethodIsConvertingFrom.substring(absFilePathOfClassMethodIsConvertingFrom.lastIndexOf('/') + 1, absFilePathOfClassMethodIsConvertingFrom.lastIndexOf('.'));

      ClassOrInterfaceDeclaration toTypeClass = null;
      ClassOrInterfaceDeclaration fromTypeClass = null;

      String highBackupModelDirectoryToSearch = higherVersionTypeAbsPath.substring(0, higherVersionTypeAbsPath.lastIndexOf('/') + 1);
      String lowBackupModelDirectoryToSearch = lowerVersionTypeAbsPath.substring(0, lowerVersionTypeAbsPath.lastIndexOf('/') + 1);

      Node declaration1 = null;
      Node declaration2 = null;
      boolean isEnum = false;

      try {
        if (getVersionStringFromPath(lowerVersionTypeAbsPath).equals(getVersionStringFromPath(absFilePathOfClassMethodIsConvertingTo))) {
          declaration1 = getDeclaration(lowerCU, classNameMethodIsConvertingTo, lowBackupModelDirectoryToSearch);
        } else {
          declaration1 = getDeclaration(higherCU, classNameMethodIsConvertingTo, highBackupModelDirectoryToSearch);
        }

        if (getVersionStringFromPath(lowerVersionTypeAbsPath).equals(getVersionStringFromPath(absFilePathOfClassMethodIsConvertingFrom))) {
          declaration2 = getDeclaration(lowerCU, classNameMethodIsConvertingFrom, lowBackupModelDirectoryToSearch);
        } else {
          declaration2 = getDeclaration(higherCU, classNameMethodIsConvertingFrom, highBackupModelDirectoryToSearch);
        }
      } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
      }

      if (declaration1 instanceof ClassOrInterfaceDeclaration) {
        toTypeClass = (ClassOrInterfaceDeclaration) declaration1;
      } else if (declaration1 instanceof EnumDeclaration) {
        isEnum = true;
        System.out.println("Filename " + filename + " target String " + classNameMethodIsConvertingTo + ", is an EnumDeclaration");
      }
      if (declaration2 instanceof ClassOrInterfaceDeclaration) {
        fromTypeClass = (ClassOrInterfaceDeclaration) declaration2;
      } else if (declaration2 instanceof EnumDeclaration) {
        isEnum = true;
        System.out.println("Filename " + filename + " target String " + classNameMethodIsConvertingTo + ", is an EnumDeclaration");
      }

      if ((toTypeClass == null || fromTypeClass == null) && !isEnum) {
        System.out.println();
      } else if (!isEnum) {
        System.out.println("FROM " + fromTypeClass.getNameAsString());
        System.out.println("TO " + toTypeClass.getNameAsString());
      }

      if (toTypeClass != null && fromTypeClass != null) {
        ClassOrInterfaceDeclaration finalFromTypeClass = fromTypeClass;
        ClassOrInterfaceDeclaration finalToTypeClass = toTypeClass;
        md.accept(new ModifierVisitor<Void>() {
          @Override
          public Visitable visit(IfStmt ifStmt, Void arg) {
            super.visit(ifStmt, arg);
            processIfStatement(ifStmt);



            return ifStmt;
          }

        }, null);
      }

      //System.out.println("Execution time :: " + (System.currentTimeMillis() - start) / 1000);

    }
  }

  public static void processIfStatement(IfStmt ifStmt) {
    Expression condition = ifStmt.getCondition();
    Statement thenStmt = ifStmt.getThenStmt();
    //Handle multiple big if blocks
    if ((thenStmt instanceof BlockStmt) && (thenStmt.getChildNodes().size() > 1)) {
      thenStmt.getChildNodes().forEach(n -> {
        if (n instanceof IfStmt) {
          processIfStatement((IfStmt) n);
        } else {
          System.out.println();
        }
      });
    } else if (thenStmt instanceof IfStmt) {
      processIfStatement((IfStmt) thenStmt);
    } else {
      Expression expression = processGetStatement(thenStmt);
      if (expression != null && !expression.toString().contains("get")) {
        System.out.println();
      } else if (expression == null) {
        System.out.println("Logger :: was not able to get a getStatement for if statement :: " + ifStmt.toString());
      }
    }
  }

  public static Expression processGetStatement(Node stmt) {

    if ((stmt instanceof ReturnStmt) || (stmt instanceof ThrowStmt) || (stmt instanceof TryStmt)
      || (stmt instanceof NameExpr) || (stmt instanceof FieldAccessExpr) || (stmt instanceof BooleanLiteralExpr)
      || (stmt instanceof ConditionalExpr) || (stmt instanceof StringLiteralExpr)) {
      // ignore
    } else if (stmt instanceof IfStmt) {
      System.out.println();
    } else if (stmt instanceof ForEachStmt) {
      return ((ForEachStmt) stmt).getIterable();
    } else if (stmt instanceof BlockStmt) {
      if (stmt.getChildNodes().size() > 1) {
        System.out.println();
      } else {
        return processGetStatement(stmt.getChildNodes().get(0));
      }
    } else if (stmt instanceof ExpressionStmt) {
      return processGetStatement(((ExpressionStmt) stmt).getExpression());
    } else if (stmt instanceof MethodCallExpr) {
      if (((MethodCallExpr) stmt).getArguments().size() > 0) {
        return processGetStatement(((MethodCallExpr) stmt).getArgument(0));
      } else {
        return containsOrReturnNull((Expression) stmt, "get");
      }
    } else if (stmt instanceof AssignExpr) {
      if (((AssignExpr) stmt).getOperator().equals(AssignExpr.Operator.ASSIGN)) {
        return (processGetStatement(stmt.getChildNodes().get(1)));
      } else {
        System.out.println();
      }
    } else if (stmt instanceof UnaryExpr) {
      return containsOrReturnNull((Expression) stmt, "get");
    } else if (stmt instanceof BinaryExpr) {
      if (((BinaryExpr) stmt).getLeft().toString().contains("get")) {
        return processGetStatement(((BinaryExpr) stmt).getLeft());
      } else {
        return processGetStatement(((BinaryExpr) stmt).getRight());
      }
    } else if (stmt instanceof CastExpr) {
      return processGetStatement(((CastExpr) stmt).getExpression());
    } else if (stmt instanceof Expression) {
      System.out.println();
    } else {
      System.out.println("You haven't caught this then statement case yet.");
      System.exit(0);
    }

    return null;
  }

  public static Expression containsOrReturnNull(Expression e, String keyWord) {
    if (e.toString().contains(keyWord)) {
      return e;
    } else {
      return null;
    }
  }

  public static Type resolveInnerType(Type type) {
    Type toReturn = type;
    if (type.toString().contains("List") && !type.toString().contains("List_")
      && !type.toString().contains("ListResource") && !type.toString().contains("ListMode")) {
      try {
        toReturn = (Type) type.getChildNodes().get(1);
      } catch (Exception e) {
        System.out.println();
      }
    }
    return toReturn;
  }

  public static String removeListToGetTypeString(String type) {
    if (type.contains("List")) {
      type = type.replaceAll("List", "").replaceAll("<", "").replaceAll(">", "");
    }
    return type;
  }

  public static boolean methodExistsInClass(ClassOrInterfaceDeclaration c, String methodName) {
    Optional<MethodDeclaration> first = c.getMethods().stream()
      .filter(md -> md.getNameAsString().equals(methodName))
      .findAny();
    return first.isPresent();
  }

  public static MethodDeclaration getMethod(ClassOrInterfaceDeclaration c, String methodName) {
    if (!methodExistsInClass(c, methodName)) {
      throw new IllegalStateException("Cannot get a method " + methodName + " in class " + c.getNameAsString() + " doesn't exist in class.");
    }
    return c.getMethods().stream()
      .filter(md -> md.getNameAsString().equals(methodName))
      .findFirst().get();
  }

  public static TypeDeclaration getDeclaration(CompilationUnit cu, String targetNodeString, String backupModelDirectory) throws FileNotFoundException {
    if (targetNodeString.contains(".")) {
      return null;
      // not handling this
    }

    if (cu.getClassByName(targetNodeString).isPresent()) {
      return (TypeDeclaration) cu.getClassByName(targetNodeString).get();
    }

    TypeDeclaration td = getClassOrEnumNodeThatExistsWithin(cu, targetNodeString);
    if (td == null) {
      File target = new File(backupModelDirectory + targetNodeString + ".java");
      if (!target.exists()) {
        target = new File(backupModelDirectory + "Enumerations" + ".java");
      }
      cu = StaticJavaParser.parse(target);
      td = getClassOrEnumNodeThatExistsWithin(cu, targetNodeString);
    }
    if (td == null) {
      System.out.println("No target with name " + targetNodeString + " found");
    }
    return td;
  }

  public static TypeDeclaration getClassOrEnumNodeThatExistsWithin(CompilationUnit cu, String targetName) {
    List<TypeDeclaration> collect = cu.getChildNodes().stream()
      .filter(node -> node instanceof TypeDeclaration)
      .map(node -> (TypeDeclaration) node)
      .collect(Collectors.toList());
    for (TypeDeclaration td : collect) {
      TypeDeclaration search = getClassOrEnumNodeThatExistsWithin(td, targetName);
      if (search != null) {
        return search;
      }
    }
    return null;
  }

  public static TypeDeclaration getClassOrEnumNodeThatExistsWithin(TypeDeclaration c, String targetName) {
    if (c.getNameAsString().equals(targetName)) return c;
    List<TypeDeclaration> collect = c.getChildNodes().stream()
      .filter(node -> node instanceof TypeDeclaration)
      .map(node -> (TypeDeclaration) node)
      .collect(Collectors.toList());
    for (TypeDeclaration td : collect) {
      TypeDeclaration search = getClassOrEnumNodeThatExistsWithin(td, targetName);
      if (search != null) {
        return search;
      }
    }
    return null;
  }

  public static class ElementParserEntry {

    public boolean hasGet = false;
    public boolean hasCheck = false;
    public boolean hasSet = false;
    public boolean hasAdd = false;

    public String baseNoun = "";

    public String getType = "";
    public String checkType = "";
    public String setType = "";
    public String addType = "";

    public void setGetType(String type) {
      hasGet = true;
      this.getType = type;
    }

    public void setSetType(String type) {
      hasSet = true;
      this.setType = type;
    }

    public void setHasCheck(String type) {
      hasCheck = true;
      this.checkType = type;
    }

    public void setAddType(String type) {
      hasAdd = true;
      this.addType = type;
    }

    public ElementParserEntry() {
    }

  }


  public static List<String> getListOfPrimitiveTypes() {
    String path = "/Users/markiantorno/Documents/Development/fhir/org.hl7.fhir.core/org.hl7.fhir.r5/src/main/java/org/hl7/fhir/r5/model/";

    List<String> result = new ArrayList<>();

    try (Stream<Path> walk = Files.walk(Paths.get(path))) {
      walk.map(Path::toString)
        .filter(f -> f.endsWith(".java"))
        .collect(Collectors.toCollection(() -> result));
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> primitiveTypes = new ArrayList<>();
    result.forEach(filePath -> {
      try {
        CompilationUnit cu = StaticJavaParser.parse(new File(filePath));
        String className = pullFileNameFromPath(filePath);
        cu.getClassByName(className).ifPresent(classOrInterfaceDeclaration -> {
          if (classOrInterfaceDeclaration.getExtendedTypes().stream()
            .map(NodeWithSimpleName::getNameAsString)
            .collect(Collectors.toList()).contains("PrimitiveType")) {
            primitiveTypes.add(className.replace("Type", ""));
          }
        });
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });
    primitiveTypes.forEach(System.out::println);
    return primitiveTypes;
  }

  public static void cleanAccessorsForFile(String srcdirectory, String filename, String extension) {
    String projectDirectory = new File("").getAbsolutePath();
    String srcFilePathWithExtension = projectDirectory + srcdirectory + filename + extension;

    CompilationUnit compilationUnit = getCompilationUnit(projectDirectory + srcdirectory + filename + extension);
    ClassOrInterfaceDeclaration classOrInterfaceDeclaration = initializeTypeSovlerAndParser(compilationUnit,
      projectDirectory, srcdirectory, filename);

    String ifStatementTemplate = "if(%1$s){%2$s;}";
    String ifStatementTemplate2 = "if(%1$s){%2$s}";

    final HashMap<String, String> replacementMap = new HashMap<>();
    final HashMap<MethodDeclaration, BlockStmt> generatedBlockStmt = new HashMap<>();

    List<MethodDeclaration> methods = classOrInterfaceDeclaration.getMethods();
    methods.forEach(md -> {
      String assembledMethod = "";
      md.accept(new ModifierVisitor<String>() {
        @Override
        public Visitable visit(MethodCallExpr n, String arg) {
          super.visit(n, arg);
          if (n.getTokenRange().toString().contains("src.get")) {

            Node getStatement = getRootGetMethodCall(n);
            String topLevelMethodExpr = getTopLevelMethodExpr(n).toString();
            if (topLevelMethodExpr != null) {
              String condition = "src.has" + getStatement.toString().replace("FirstRep", "").replaceFirst("get", "") + "()";

              String statement = topLevelMethodExpr;
              String ifStmt = String.format(statement.startsWith("for") ? ifStatementTemplate2 : ifStatementTemplate, condition, statement);
              if (!replacementMap.containsKey(topLevelMethodExpr)) {
                replacementMap.put(topLevelMethodExpr, ifStmt);
              }
            }
          }
          return n;
        }
      }, assembledMethod);
      String body = md.getBody().get().toString();
      Set<String> keySet = replacementMap.keySet();
      for (String key : keySet) {
        if (key.startsWith("for")) {
          body = body.replace(key, replacementMap.get(key));
        } else {
          body = body.replace(key + ";", replacementMap.get(key));
        }
      }
      replacementMap.clear();
      try {
        generatedBlockStmt.put(md, StaticJavaParser.parseBlock(body));
      } catch (Exception e) {
        System.out.println();
      }
    });

    classOrInterfaceDeclaration.accept(new ModifierVisitor<Void>() {
      @Override
      public MethodDeclaration visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);
        if (generatedBlockStmt.containsKey(md)) {
          return md.setBody(generatedBlockStmt.get(md));
        } else {
          return md;
        }
      }
    }, null);

    deleteFile(srcFilePathWithExtension);

    try {
      writeStringToFile(compilationUnit.toString(), srcFilePathWithExtension);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Node getRootGetMethodCall(Node n) {
    if (n.getChildNodes().size() == 0) return n;

    Optional<Node> get = n.getChildNodes().stream()
      .filter(node -> node.toString().contains("get"))
      .findFirst();

    return get.map(Parser::getRootGetMethodCall).orElse(null);
  }

  private static Node getTopLevelMethodExpr(Node exp) {
    Optional<Node> node = exp.getParentNode();
    if (node.isPresent() && node.get() instanceof ExpressionStmt && node.get().getParentNode().get() instanceof IfStmt) {
      return null;
    } else if ((node.isPresent()) && ((node.get() instanceof MethodCallExpr) || (node.get() instanceof ForEachStmt))) {
      return getTopLevelMethodExpr(node.get());
    }
    return exp;
  }

  private static Node getTopLevelIfStatement(Node exp) {
    Optional<Node> node = exp.getParentNode();
    if (!node.isPresent() || (node.get() instanceof ClassOrInterfaceDeclaration)) {
      return null;
    } else if (node.get() instanceof IfStmt) {
      return node.get();
    }
    return getTopLevelIfStatement(node.get());
  }

  // ================== OLD CODE ======================


  private static final String COMMON_FILENAME = "Common";
  private static final String DEST_DIRECTORY_FORMAT = "conv%s";
  private static final String SRC_FILE_FORMAT = "VersionConvertor_%s";

  private static final String KEYWORD_CONVERT = "convert";
  private static final String KEYWORD_COPY = "copy";
  private static final String KEYWORD_FIND = "find";
  private static final String KEYWORD_GOD_METHOD = "convertResource";

  private static final String DIRECTORY_WHERE_THE_CODE_LIVES = "/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/";
  private static final String COMMENT_REPORT = "comment_report%s.txt";

  //Exception case variables
  public static final String DSTU = "dstu";
  public static final String R = "r";

  public static final String MODEL_RESOURCE = "org.hl7.fhir.%1$s%2$s.model.Resource";
  public static final String MODEL_VALUESET = "org.hl7.fhir.%1$s%2$s.model.ValueSet";
  public static final String MODEL_BUNDLECOMP = "org.hl7.fhir.%1$s%2$s.model.Bundle.BundleEntryComponent";
  public static final String MODEL_BUNDLE = "org.hl7.fhir.%1$s%2$s.model.Bundle";
  public static final String VERSION_CONVERTOR_IMPORT = "org.hl7.fhir.convertors.VersionConvertorAdvisor%s0";
  public static final String VERSION_CONVERTOR = "VersionConvertorAdvisor%s0";
  public static final String ADVISOR_VARIABLE = "advisor";

  public static String convertPath(String path, String version) {
    String versionloc = (version.equals("2") || version.equals("3")) ? DSTU : R;
    return String.format(path, versionloc, version);
  }

  public static void parseAllTheCodes() {
    String projectDirectory = new File("").getAbsolutePath();

    VERSION_FILES.forEach(version -> {

      String srcFilePathWithExtension = projectDirectory + DIRECTORY_WHERE_THE_CODE_LIVES + String.format(SRC_FILE_FORMAT, version) + ".java";
      String destDirectoryName = String.format(DEST_DIRECTORY_FORMAT, version);

      CompilationUnit compilationUnit = getCompilationUnit(srcFilePathWithExtension);
      ClassOrInterfaceDeclaration classOrInterfaceDeclaration
        = initializeTypeSovlerAndParser(compilationUnit, projectDirectory, DIRECTORY_WHERE_THE_CODE_LIVES, String.format(SRC_FILE_FORMAT, version));

      if (version.contains("10"))
        dealWithV2ExceptionCasesPreProcessing(compilationUnit, classOrInterfaceDeclaration, version);

      List<String> externalClassNames = getAdditionalClassDeclarations(classOrInterfaceDeclaration).stream()
        .filter(c -> !c.getNameAsString().equals(classOrInterfaceDeclaration.getNameAsString()))
        .map(NodeWithSimpleName::getNameAsString)
        .collect(Collectors.toList());

      HashMap<String, List<MethodDeclaration>> generatedTopLevelMethodMap = generateMapOfTopLevelMethods(classOrInterfaceDeclaration);
      HashMap<MethodDeclaration, String> generatedMethodMap = new HashMap<>();
      HashMap<String, List<FieldDeclaration>> generatedStaticFieldMappings = new HashMap<>();
      populateMethodAndFieldMaps(classOrInterfaceDeclaration, generatedTopLevelMethodMap, generatedMethodMap, generatedStaticFieldMappings);

      if (version.equals("10_40") || version.equals("10_50")) {
        generatedMethodMap.keySet().stream()
          .filter(methodDeclaration -> methodDeclaration.getNameAsString().equals("hasConcept"))
          .collect(Collectors.toList())
          .forEach(methodDeclaration -> {
            generatedMethodMap.put(methodDeclaration, COMMON_FILENAME);
          });
      }

      populateClassMappings(generatedTopLevelMethodMap, generatedMethodMap);

      createCommentReport(srcFilePathWithExtension,
        projectDirectory + DIRECTORY_WHERE_THE_CODE_LIVES + String.format(COMMENT_REPORT, version));

      modifySourceFile(compilationUnit, classOrInterfaceDeclaration, srcFilePathWithExtension,
        generatedTopLevelMethodMap, generatedStaticFieldMappings, version);

      String packageDeclaration = compilationUnit.getPackageDeclaration().get().getNameAsString() + "."
        + destDirectoryName;
      System.out.println("Files will be generated with the package :: " + packageDeclaration);
      NodeList<ImportDeclaration> imports = compilationUnit.getImports();
      System.out.println("Imports will be taken from the top level file <" + String.format(SRC_FILE_FORMAT, version) + ".java>, you will have to " +
        "optimize imports on the generated files. Import list as follows :: \n-----");
      imports.stream().map(NodeWithName::getNameAsString).forEach(System.out::println);
      System.out.println("-----\n");
      String directoryPath = projectDirectory + DIRECTORY_WHERE_THE_CODE_LIVES + destDirectoryName + "/";
      createDirectory(directoryPath);
      System.out.println("Generated type conversion files will be stored in :: " + directoryPath);

      createJavaFiles(classOrInterfaceDeclaration, generatedTopLevelMethodMap, generatedStaticFieldMappings,
        String.format(SRC_FILE_FORMAT, version), packageDeclaration, imports, directoryPath, externalClassNames, version);
    });


  }

  private static List<ClassOrInterfaceDeclaration> getAdditionalClassDeclarations(ClassOrInterfaceDeclaration
                                                                                    classOrInterfaceDeclaration) {
    List<ClassOrInterfaceDeclaration> collect = new ArrayList<>();
    classOrInterfaceDeclaration.accept(new VoidVisitorAdapter<Void>() {
      @Override
      public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        super.visit(n, arg);
        collect.add(n);
      }
    }, null);
    return collect;
  }

  private static CompilationUnit getCompilationUnit(String filePathWithExtension) {
    Optional<CompilationUnit> compilationUnit = initializeParser(filePathWithExtension);
    if (!compilationUnit.isPresent()) {
      System.out.println("\nNo compilation unit generated during class parsing...aborting.");
      System.exit(0);
    }
    return compilationUnit.get();
  }

  private static ClassOrInterfaceDeclaration initializeTypeSovlerAndParser(CompilationUnit compilationUnit,
                                                                           String projectDirectory,
                                                                           String codeDirectory,
                                                                           String filename) {
//    System.out.println("==================== Initializing TypeSolver and Parser ====================\n");

    try {
      initializeResolver(projectDirectory, codeDirectory);
    } catch (IOException e) {
      System.out.println("Error initializing typesolver, exiting process...");
      e.printStackTrace();
      System.exit(0);
    }

//    System.out.println("Loading class: " + filename);
    Optional<ClassOrInterfaceDeclaration> classOrInterfaceDeclaration = loadClass(compilationUnit, filename);
    if (!classOrInterfaceDeclaration.isPresent()) {
      System.out.println("\nNo class or interface declaration loaded during parsing...aborting.");
      System.exit(0);
    }

//    System.out.println("\n");

    return classOrInterfaceDeclaration.get();
  }

  private static HashMap<String, List<MethodDeclaration>> generateMapOfTopLevelMethods(ClassOrInterfaceDeclaration
                                                                                         classOrInterfaceDeclaration) {
    System.out.println("==================== Generating List of Parsable Types ====================\n");

    HashMap<String, List<MethodDeclaration>> mapToReturn = new HashMap<>();

    System.out.println("Fetching list of top level parsing methods...");
    System.out.println("---------------------------------------------");
    List<String> listOfParsableMethodCalls = getListOfParsableTypes(classOrInterfaceDeclaration).stream()
      .map(methodCallExpr -> methodCallExpr.getName().toString())
      .sorted(Comparator.comparing(Function.identity()))
      .distinct()
      .collect(Collectors.toList());
    listOfParsableMethodCalls.forEach(System.out::println);
    System.out.println("---------------------------------------------");
    System.out.println("\n");

    System.out.println("==================== Generate Map of Top Level Method Names ====================\n");
    System.out.println("Pulling all top level methods from the parsed class --> " + classOrInterfaceDeclaration.getNameAsString());
    List<MethodDeclaration> topLevelMethods = getTopLevelMethods(classOrInterfaceDeclaration, listOfParsableMethodCalls);
    System.out.println("\nFetched the following top level methods:");
    System.out.println("------------------------------------------");
    topLevelMethods.forEach(md -> System.out.println(md.getSignature().toString()));
    System.out.println("------------------------------------------\n");
    System.out.println("\n");

    for (String type : listOfParsableMethodCalls) {
      topLevelMethods.stream()
        .filter(methodDeclaration -> type.equals(methodDeclaration.getName().asString()))
        .forEach(md -> {
          if (!mapToReturn.containsKey(type.replaceFirst(KEYWORD_CONVERT, ""))) {
            mapToReturn.put(type.replaceFirst(KEYWORD_CONVERT, ""), new ArrayList<>());
          }
          mapToReturn.get(type.replaceFirst(KEYWORD_CONVERT, "")).add(md);
        });
    }
    return mapToReturn;
  }

  public static void populateMethodAndFieldMaps(ClassOrInterfaceDeclaration classOrInterfaceDeclaration,
                                                HashMap<String, List<MethodDeclaration>> generatedTopLevelMethodMap,
                                                HashMap<MethodDeclaration, String> methodMapToPopulate,
                                                HashMap<String, List<FieldDeclaration>> fieldMapToPopulate) {

    System.out.println("==================== Generate Method and Field Maps ====================\n");

    HashMap<FieldDeclaration, String> fieldDeclarationMap = new HashMap<>();

    List<FieldDeclaration> fieldDeclarations = classOrInterfaceDeclaration.getFields().stream()
      .filter(NodeWithStaticModifier::isStatic)
      .collect(Collectors.toList());

    for (String key : generatedTopLevelMethodMap.keySet()) {
      for (MethodDeclaration md : generatedTopLevelMethodMap.get(key)) {
        recursiveSearchAndAdd(classOrInterfaceDeclaration, methodMapToPopulate, fieldDeclarationMap, fieldDeclarations, md, key);
      }
    }

    fieldDeclarationMap.keySet().forEach(key -> {
      if (!fieldMapToPopulate.containsKey(fieldDeclarationMap.get(key))) {
        fieldMapToPopulate.put(fieldDeclarationMap.get(key), new ArrayList<>());
      }
      fieldMapToPopulate.get(fieldDeclarationMap.get(key)).add(key);
    });
  }

  public static void populateClassMappings(HashMap<String, List<MethodDeclaration>> generatedTopLevelMethodMap,
                                           HashMap<MethodDeclaration, String> generatedMethodMap) {
    System.out.println("==================== Generate Method to Class Mappings ====================\n");

    generatedTopLevelMethodMap.put(COMMON_FILENAME, new ArrayList<>());
    generatedTopLevelMethodMap.clear();
    generatedMethodMap.keySet().forEach(md -> {
      if (!generatedTopLevelMethodMap.containsKey(generatedMethodMap.get(md))) {
        generatedTopLevelMethodMap.put(generatedMethodMap.get(md), new ArrayList<>());
      }
      generatedTopLevelMethodMap.get(generatedMethodMap.get(md)).add(md);
    });

    for (String className : generatedTopLevelMethodMap.keySet()) {
      System.out.println("Class :: " + className);
      generatedTopLevelMethodMap.get(className).stream()
        .sorted(Comparator.comparing(methodDeclaration -> methodDeclaration.getName().toString()))
        .forEach(md -> System.out.println("\t" + md.getSignature()));
      System.out.println("\n");
    }
  }

  public static void createCommentReport(String fullSrcFilePath, String fullDstFilePath) {
    try {
      List<CommentReportEntry> commentReportEntries = generateCommentReportData(fullSrcFilePath);
      String report = commentReportEntries.stream()
        .map(Object::toString).collect(Collectors.joining("\n"));
      writeStringToFile(report, fullDstFilePath);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void dealWithV2ExceptionCasesPreProcessing(CompilationUnit cu, ClassOrInterfaceDeclaration
    classOrInterfaceDeclaration, String version) {
    String from = "2";//version.substring(0, version.indexOf('_'));
    String to = version.substring(version.indexOf('_') + 1, version.indexOf('_') + 2);


    modifyConvertResourceCalls(classOrInterfaceDeclaration, to, from, to, MODEL_VALUESET, "convertValueSet");
    modifyConvertResourceCalls(classOrInterfaceDeclaration, from, to, to, MODEL_VALUESET, "convertValueSet");
    modifyConvertResourceCalls(classOrInterfaceDeclaration, to, from, to, MODEL_BUNDLECOMP, "convertBundleEntryComponent");
    modifyConvertResourceCalls(classOrInterfaceDeclaration, to, from, to, MODEL_BUNDLE, "convertBundle");

    addAdvisorToMethodCalls(classOrInterfaceDeclaration, "convertBundle", MODEL_BUNDLE, from, "convertBundleEntryComponent");

  }

  public static void dealWithV2ExceptionCasesPostProcessing(ClassOrInterfaceDeclaration
                                                              classOrInterfaceDeclaration, String version) {
    String from = "2";//version.substring(0, version.indexOf('_'));
    String to = version.substring(version.indexOf('_') + 1, version.indexOf('_') + 2);

    Optional<VariableDeclarator> advisorOptional = classOrInterfaceDeclaration.getFields().stream()
      .map(FieldDeclaration::getVariables)
      .flatMap(Collection::stream)
      .filter(v -> v.getNameAsString().equals(ADVISOR_VARIABLE))
      .findFirst();

    if (advisorOptional.isPresent()) {
      VariableDeclarator advisorVariable = advisorOptional.get();
      Type advisorType = advisorVariable.getType();
      advisorOptional.get().getParentNode().ifPresent(Node::remove);

      modifyConvertResourceCalls(classOrInterfaceDeclaration, from, to, to, MODEL_RESOURCE, "convertResource");
      modifyConvertResourceCalls(classOrInterfaceDeclaration, to, from, to, MODEL_RESOURCE, "convertResource");

      addAdvisorToMethodCalls(classOrInterfaceDeclaration, "convertResource", MODEL_RESOURCE, from, "convertBundle");
      addAdvisorToMethodCalls(classOrInterfaceDeclaration, "convertResource", MODEL_RESOURCE, from, "convertValueSet");
      addAdvisorToMethodCalls(classOrInterfaceDeclaration, "convertResource", MODEL_RESOURCE, to, "convertValueSet");

      classOrInterfaceDeclaration.getConstructors().forEach(Node::remove);

      System.out.println();
//    classOrInterfaceDeclaration.addMethod();

    }

    System.out.println();
  }

  public static void modifyConvertResourceCalls(ClassOrInterfaceDeclaration classOrInterfaceDeclaration,
                                                String parameterVersionNo,
                                                String typeVersionNo,
                                                String convertorVersionNumber,
                                                String typeFormat,
                                                String methodName) {
    MethodDeclaration oldConvertResource = getConvertResourceMethodForVersion(classOrInterfaceDeclaration, methodName, typeFormat, typeVersionNo);
    oldConvertResource.addParameter(String.format(VERSION_CONVERTOR, convertorVersionNumber), ADVISOR_VARIABLE);

    MethodDeclaration newConvertResource = classOrInterfaceDeclaration.addMethod(methodName);
    newConvertResource.setModifier(Modifier.Keyword.PUBLIC, true);
    newConvertResource.setModifier(Modifier.Keyword.STATIC, true);
    newConvertResource.setType(convertPath(typeFormat, typeVersionNo));
    newConvertResource.setThrownExceptions(oldConvertResource.getThrownExceptions());
    newConvertResource.addParameter(convertPath(typeFormat, parameterVersionNo), "src");
    newConvertResource.setBody(new BlockStmt().addStatement("return " + methodName + "(src, null);"));
  }

  public static void addAdvisorToMethodCalls(ClassOrInterfaceDeclaration classOrInterfaceDeclaration,
                                             String parentMethodName,
                                             String modelType,
                                             String version,
                                             String subMethodCall) {

    Optional<MethodDeclaration> methodDeclaration = classOrInterfaceDeclaration.getMethods().stream()
      .filter(md -> md.getNameAsString().equals(parentMethodName))
      .filter(md -> md.getType().toString().equals(convertPath(modelType, version)))
      .findAny();

    methodDeclaration.ifPresent(declaration -> declaration.accept(new ModifierVisitor<Void>() {
      @Override
      public Visitable visit(MethodCallExpr n, Void arg) {
        super.visit(n, arg);
        if (n.getNameAsString().contains(subMethodCall)) {
          n.addArgument("advisor");
        }
        return n;
      }
    }, null));

  }

  public static MethodDeclaration getConvertResourceMethodForVersion(ClassOrInterfaceDeclaration
                                                                       classOrInterfaceDeclaration,
                                                                     String methodName,
                                                                     String modelType,
                                                                     String version) {
    Optional<MethodDeclaration> methodDeclaration = classOrInterfaceDeclaration.getMethods().stream()
      .filter(md -> md.getNameAsString().equals(methodName))
      .filter(md -> md.getType().toString().equals(convertPath(modelType, version)))
      .findAny();

    if (methodDeclaration.isPresent()) {
      return methodDeclaration.get();
    } else {
      System.out.println("Cannot find method " + methodName + " that returns type " + convertPath(modelType, version));
      System.exit(0);
    }
    return null;
  }

  public static void modifySourceFile(CompilationUnit compilationUnit,
                                      ClassOrInterfaceDeclaration classOrInterfaceDeclaration,
                                      String srcFilePathWithExtension,
                                      HashMap<String, List<MethodDeclaration>> generatedTopLevelMethodMap,
                                      HashMap<String, List<FieldDeclaration>> generatedStaticFieldMappings,
                                      String version) {


    List<String> listOfParsableMethodCalls = getListOfParsableTypes(classOrInterfaceDeclaration).stream()
      .map(methodCallExpr -> methodCallExpr.getName().toString())
      .sorted(Comparator.comparing(Function.identity()))
      .distinct()
      .collect(Collectors.toList());

    modifyMainFile(compilationUnit,
      classOrInterfaceDeclaration,
      generatedTopLevelMethodMap.get(COMMON_FILENAME),
      generatedTopLevelMethodMap.keySet().stream()
        .filter(key -> !key.equals(COMMON_FILENAME))
        .map(generatedTopLevelMethodMap::get)
        .flatMap(Collection::stream)
        .collect(Collectors.toList()),
      listOfParsableMethodCalls,
      generatedStaticFieldMappings.keySet().stream()
        .filter(key -> !key.equals(COMMON_FILENAME))
        .map(generatedStaticFieldMappings::get)
        .flatMap(Collection::stream)
        .collect(Collectors.toList()),
      generatedStaticFieldMappings.keySet().stream()
        .filter(key -> key.equals(COMMON_FILENAME))
        .map(generatedStaticFieldMappings::get)
        .flatMap(Collection::stream)
        .collect(Collectors.toList()),
      version);

    deleteFile(srcFilePathWithExtension);

    try {
      writeStringToFile(compilationUnit.toString(), srcFilePathWithExtension);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void modifyMainFile(CompilationUnit compilationUnit,
                                    ClassOrInterfaceDeclaration classOrInterfaceDeclaration,
                                    List<MethodDeclaration> methodsToExpose,
                                    List<MethodDeclaration> methodsToDelete,
                                    List<String> methodsToAddStaticAccess,
                                    List<FieldDeclaration> fieldsToDelete,
                                    List<FieldDeclaration> fieldsToExpose,
                                    String versionCode) {

    compilationUnit.getAllContainedComments().stream()
      .filter(Comment::isLineComment)
      .forEach(Comment::remove);

    compilationUnit.accept(new MethodDeleter(methodsToDelete), null);
    compilationUnit.accept(new MethodExposer(methodsToExpose), null);

    compilationUnit.addImport("org.hl7.fhir.convertors." + String.format(DEST_DIRECTORY_FORMAT, versionCode), false, true);

    fieldsToDelete.forEach(classOrInterfaceDeclaration::remove);
    classOrInterfaceDeclaration.getFields().stream()
      .filter(NodeWithStaticModifier::isStatic)
      .filter(fieldsToExpose::contains)
      .forEach(fd -> {
        fd.setModifier(Modifier.Keyword.PRIVATE, false);
        fd.setModifier(Modifier.Keyword.PUBLIC, true);
      });

    List<MethodDeclaration> listOfClassMethods = getListOfClassMethods(KEYWORD_GOD_METHOD, classOrInterfaceDeclaration);
    listOfClassMethods.forEach(md -> {
      md.accept(new MethodStaticCallAdder(methodsToAddStaticAccess, versionCode), null);
    });

    //Deal with the old, non static access convertors (1-3, 1-4, 1-5)
    compilationUnit.accept(new ModifierVisitor<Void>() {
      @Override
      public MethodDeclaration visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);

        md.setModifier(Modifier.Keyword.PRIVATE, false);
        md.setModifier(Modifier.Keyword.STATIC, true);
        md.setModifier(Modifier.Keyword.PUBLIC, true);

        return md;
      }
    }, null);

    classOrInterfaceDeclaration.accept(new ModifierVisitor<Void>() {
      @Override
      public ClassOrInterfaceDeclaration visit(ClassOrInterfaceDeclaration n, Void arg) {
        super.visit(n, arg);
        if (!n.getNameAsString().equals(String.format(SRC_FILE_FORMAT, versionCode))) {
          n.setModifier(Modifier.Keyword.PRIVATE, false);
          n.setModifier(Modifier.Keyword.STATIC, true);
          n.setModifier(Modifier.Keyword.PUBLIC, true);
          n.accept(new ModifierVisitor<Void>() {
            @Override
            public FieldDeclaration visit(FieldDeclaration md, Void arg) {
              super.visit(md, arg);
              md.setModifier(Modifier.Keyword.PRIVATE, false);
              md.setModifier(Modifier.Keyword.STATIC, false);
              md.setModifier(Modifier.Keyword.PUBLIC, true);
              return md;
            }
          }, null);
        }
        return n;
      }
    }, null);

    if (versionCode.contains("10")) dealWithV2ExceptionCasesPostProcessing(classOrInterfaceDeclaration, versionCode);

  }

  public static void createJavaFiles(ClassOrInterfaceDeclaration classOrInterfaceDeclaration,
                                     HashMap<String, List<MethodDeclaration>> generatedTopLevelMethodMap,
                                     HashMap<String, List<FieldDeclaration>> generatedStaticFieldMappings,
                                     String filename,
                                     String packageDeclaration,
                                     NodeList<ImportDeclaration> imports,
                                     String outputDirectoryPath,
                                     List<String> externalClassNames,
                                     String version) {
    System.out.println("==================== Create Java Files ====================\n");

    generatedTopLevelMethodMap.keySet().stream()
      .filter(s -> !s.equals(COMMON_FILENAME))
      .forEach(s -> {
        String generatedCode = generateFileContents(classOrInterfaceDeclaration,
          filename,
          s + version,
          packageDeclaration,
          imports,
          generatedStaticFieldMappings.get(s),
          generatedStaticFieldMappings.get(COMMON_FILENAME),
          generatedTopLevelMethodMap.get(s).stream()
            .sorted(Comparator.comparing(methodDeclaration -> methodDeclaration.getName().toString()))
            .collect(Collectors.toList()),
          externalClassNames,
          version);

        try {
          String filePath = outputDirectoryPath + s + version + ".java";
          System.out.println("Attempting to write file -> " + filePath);
          writeStringToFile(generatedCode, filePath);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
  }

  public static void writeStringToFile(String string, String filepath) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
    writer.write(string);
    writer.close();
  }

  public static String generateFileContents(ClassOrInterfaceDeclaration oldInterfaceDec,
                                            String commonMethodClassName,
                                            String className,
                                            String packageDeclaration,
                                            NodeList<ImportDeclaration> imports,
                                            List<FieldDeclaration> fieldDeclarations,
                                            List<FieldDeclaration> externalFieldDeclarations,
                                            List<MethodDeclaration> methods,
                                            List<String> externalClassNames,
                                            String version) {

    CompilationUnit cu = new CompilationUnit();


    cu.setPackageDeclaration(packageDeclaration);
    cu.setImports(imports);
    cu.addImport("org.hl7.fhir.convertors." + String.format(SRC_FILE_FORMAT, version));
    cu.addImport("org.hl7.fhir.convertors.VersionConvertorConstants");
    if (version.contains("10"))
      cu.addImport(String.format(VERSION_CONVERTOR_IMPORT, version.substring(version.indexOf('_') + 1, version.indexOf('_') + 2)));

    ClassOrInterfaceDeclaration generatedClass = cu.addClass(className);
    if (fieldDeclarations != null) {
      fieldDeclarations.forEach(generatedClass::addMember);
    }

    methods.forEach(method -> {

      MethodDeclaration methodDeclaration = generatedClass.addMethod(method.getNameAsString());

      if (method.getBody().isPresent()) {
        BlockStmt blockStmt = method.getBody().get();
        if (externalFieldDeclarations != null) {
          blockStmt.accept(new VarAccessChanger(externalFieldDeclarations.stream()
            .map(fd -> fd.getVariable(0).getNameAsString())
            .collect(Collectors.toList()), String.format(SRC_FILE_FORMAT, version)), null);
        }
        List<MethodDeclaration> allCalledMethods = getAllCalledMethods(oldInterfaceDec, method);

        allCalledMethods.stream()
          .filter(md -> !methods.contains(md))
          .map(NodeWithSimpleName::getNameAsString)
          .distinct()
          .forEach(methodName -> {
            List<MethodCallExpr> methodCallExprs = new ArrayList<>();
            blockStmt.accept(new MethodCallVisitor(methodName, true), methodCallExprs);
            methodCallExprs.stream()
              .distinct()
              .forEach(methodCallExpr -> {
                methodCallExpr.setName(commonMethodClassName + "." + methodCallExpr.getNameAsString());
              });
          });
        methodDeclaration.setBody(blockStmt);

      }

      methodDeclaration.setParameters(method.getParameters());
      methodDeclaration.setModifiers(method.getModifiers());
      methodDeclaration.addModifier(Modifier.Keyword.STATIC);
      methodDeclaration.setModifier(Modifier.Keyword.PRIVATE, false);
      methodDeclaration.setModifier(Modifier.Keyword.PUBLIC, true);
      methodDeclaration.setThrownExceptions(method.getThrownExceptions());
      methodDeclaration.setType(method.getType());
      methodDeclaration.setTypeParameters(method.getTypeParameters());
    });


    generatedClass.walk(node -> {
      String identifier = "";
      if (node instanceof NodeWithIdentifier)
        if (externalClassNames.contains(((NodeWithIdentifier<?>) node).getIdentifier())) {
          ((NodeWithIdentifier<?>) node).setIdentifier(String.format(SRC_FILE_FORMAT, version) + "." + ((NodeWithIdentifier<?>) node).getIdentifier());
        }
    });

    return cu.toString();
  }

  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }

  private static void recursiveSearchAndAdd(ClassOrInterfaceDeclaration cd,
                                            HashMap<MethodDeclaration, String> methodDeclarationMap,
                                            HashMap<FieldDeclaration, String> fieldDeclarationMap,
                                            List<FieldDeclaration> globalStaticFields,
                                            MethodDeclaration key,
                                            String value) {
    if (methodDeclarationMap.containsKey(key) && (methodDeclarationMap.get(key).equals(COMMON_FILENAME) || methodDeclarationMap.get(key).equals(value)))
      return;
    if (key.getName().toString().equals("convertResource")) return;

    addMethodDeclarationToMap(methodDeclarationMap, value, key);
    searchAndSortMethodFields(key, value, fieldDeclarationMap, globalStaticFields);

    getAllCalledMethods(cd, key).forEach(md -> {
      recursiveSearchAndAdd(cd, methodDeclarationMap, fieldDeclarationMap, globalStaticFields, md, value);
    });

  }

  private static void searchAndSortMethodFields(MethodDeclaration md,
                                                String classKey,
                                                HashMap<FieldDeclaration, String> fieldToClassMap,
                                                List<FieldDeclaration> fieldDeclarations) {

    List<NameExpr> collector = new ArrayList<>();
    md.accept(new MethodFieldVisitor(), collector);

    md.accept(new VoidVisitorAdapter<Void>() {
      @Override
      public void visit(VarType n, Void arg) {
        super.visit(n, arg);
      }
    }, null);

    List<String> staticFieldLabels = fieldDeclarations.stream()
      .map(fd -> fd.getVariable(0).getName().asString())
      .collect(Collectors.toList());

    collector.stream()
      .filter(ne -> staticFieldLabels.contains(ne.getNameAsString()))
      .map(ne -> fieldDeclarations.stream()
        .filter(fd -> fd.getVariable(0).getName().asString().equals(ne.getNameAsString()))
        .findFirst()
        .get())
      .forEach(fd -> {
        if (!fieldToClassMap.containsKey(fd)) {
          fieldToClassMap.put(fd, classKey);
        } else if (!fieldToClassMap.get(fd).equals(classKey)) {
          fieldToClassMap.put(fd, COMMON_FILENAME);
        }
      });
  }


  private static void createDirectory(String path) {
    File file = new File(path);
    //Creating the directory
    boolean bool = file.mkdir();
    if (bool) {
      System.out.println("Directory created successfully");
    } else {
      System.out.println("Sorry couldn’t create specified directory");
    }
  }

  /**
   * Attempts to delete the file at the given path.)
   *
   * @param path
   */
  public static void deleteFile(String path) {
    File file = new File(path);
    if (file.delete()) {
      System.out.println("File <" + path + "> deleted successfully");
    } else {
      System.out.println("Failed to delete the file <" + path + ">");
    }
  }

  /**
   * Finds the god method in the given convertor, and parses out all the method calls that method makes.
   *
   * @param classOrInterfaceDeclaration
   * @return
   */
  protected static List<MethodCallExpr> getListOfParsableTypes(ClassOrInterfaceDeclaration
                                                                 classOrInterfaceDeclaration) {
    List<MethodDeclaration> listOfClassMethods = getListOfClassMethods(KEYWORD_GOD_METHOD, classOrInterfaceDeclaration);
    List<MethodCallExpr> calledMethods = new ArrayList<>();
    listOfClassMethods.forEach(md -> md.accept(new MethodCallVisitor(KEYWORD_CONVERT), calledMethods));
    return calledMethods;
  }

  /**
   * Pulls all internal conversion method calls out of the passed in method and maps those calls to the corresponding
   * {@link MethodDeclaration} and returns those as a list.
   *
   * @param classOrInterfaceDeclaration
   * @param method
   * @return List of all {@link MethodDeclaration}
   */
  public static List<MethodDeclaration> getAllCalledMethods(ClassOrInterfaceDeclaration
                                                              classOrInterfaceDeclaration, MethodDeclaration method) {
    List<MethodDeclaration> result = new ArrayList<>();

    List<MethodCallExpr> methodCallExprs = new ArrayList<>();
    method.accept(new VoidVisitorAdapter<List<MethodCallExpr>>() {
      @Override
      public void visit(MethodCallExpr methodCallExpr, List<MethodCallExpr> collector) {
        collector.add(methodCallExpr);
        super.visit(methodCallExpr, collector);
      }
    }, methodCallExprs);

    Set<String> methodExpressionNames = methodCallExprs.stream()
      .filter(methodCallExpr -> !methodCallExpr.getScope().isPresent())
      .map(me -> me.getName().toString())
      .collect(Collectors.toSet());

    classOrInterfaceDeclaration.getMethods().stream()
      .filter(e -> methodExpressionNames.contains(e.getName().toString()))
      .collect(Collectors.toCollection(() -> result));

    return result;
  }

  /**
   * Searches the passed in {@link ClassOrInterfaceDeclaration} for any method declaration matching any of the method
   * names in the passed in List.
   *
   * @param classOrInterfaceDeclaration {@link ClassOrInterfaceDeclaration} to search
   * @param methodNames                 {@link List} of method names
   * @return {@link List <MethodDeclaration>} containing any of the keywords
   */
  protected static List<MethodDeclaration> getTopLevelMethods(ClassOrInterfaceDeclaration
                                                                classOrInterfaceDeclaration, List<String> methodNames) {
    List<MethodDeclaration> toReturn = new ArrayList<>();
    methodNames.stream()
      .map(s -> getListOfClassMethods(s, classOrInterfaceDeclaration))
      .flatMap(List::stream)
      .collect(Collectors.toCollection(() -> toReturn));
    return toReturn;
  }

  /**
   * Searched the generated declaration map for the matching {@link MethodDeclaration}, if it already exists within the
   * map and is not currently pointing the class label we pass in, it will mark it with the {@link Parser#COMMON_FILENAME}
   *
   * @param className         {@link String} class label we want to associate the method with
   * @param methodDeclaration {@link MethodDeclaration}
   */
  protected static void addMethodDeclarationToMap(HashMap<MethodDeclaration, String> map,
                                                  String className, MethodDeclaration methodDeclaration) {
    if (!map.containsKey(methodDeclaration)) {
      map.put(methodDeclaration, className);
    } else if (!map.get(methodDeclaration).equals(className)) {
      map.put(methodDeclaration, COMMON_FILENAME);
    }
  }

  /**
   * Returns a list of all java files within the passed in directory path, without extension.
   *
   * @param path {@link String} filepath
   * @return {@link List < String >} of all filenames
   */
  protected static List<String> listAllJavaFilesInDirectory(String path) {
    List<String> result = new ArrayList<>();

    try (Stream<Path> walk = Files.walk(Paths.get(path))) {
      walk.map(Path::toString)
        .filter(f -> f.endsWith(".java"))
        .map(Parser::pullFileNameFromPath)
        .collect(Collectors.toCollection(() -> result));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  /**
   * Takes the passed in file path and extracts the filename without extension.
   *
   * @param path
   * @return
   */
  protected static String pullFileNameFromPath(String path) {
    int lastSlashIndex = path.lastIndexOf('/');
    int lastPeriodIndex = path.lastIndexOf('.');
    return path.substring(lastSlashIndex + 1, lastPeriodIndex);
  }

  /**
   * The parser works by listing method calls within the individual resource conversion methods as
   * {@link MethodCallExpr}. To extract the information we need to refactor the code,
   * such as method body, references, signature, etc, we rely on the javaparser {@link TypeSolver} to parse the code
   * library and convert the expressions to concrete {@link MethodDeclaration}.
   * <p>
   * NB. The more source files in the directory you pass in (this will search recursively), the longer the
   * MethodDeclaration lookups will take. Be smart, choose S-Mart.
   *
   * @param rootProjectDirectory
   * @param projectDirectory     {@link String} path to the directory that contains the souce files we want to be available for
   */
  public static void initializeResolver(String rootProjectDirectory, String projectDirectory) throws IOException {
    System.out.println("Initializing resolver against the following root directory:\n" + rootProjectDirectory);
    System.out.println("Project codebase located here:\n" + projectDirectory);

    TypeSolver myTypeSolver = new CombinedTypeSolver(
      new ReflectionTypeSolver(),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.convertors/src/main/java/")),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.utilities/src/main/java/")),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.dstu2/src/main/java/")),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.dstu3/src/main/java/")),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.dstu2016may/src/main/java/")),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.r4/src/main/java/")),
      new JavaParserTypeSolver(new File(rootProjectDirectory + "/org.hl7.fhir.r5/src/main/java/")),
      new JarTypeSolver("/Users/markiantorno/.m2/repository/ca/uhn/hapi/fhir/hapi-fhir-structures-r4/4.1.0/hapi-fhir-structures-r4-4.1.0.jar"),
      new JarTypeSolver("/Users/markiantorno/.m2/repository/ca/uhn/hapi/fhir/hapi-fhir-base/4.1.0/hapi-fhir-base-4.1.0.jar")
    );

    JavaSymbolSolver symbolSolver = new JavaSymbolSolver(myTypeSolver);
    StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
  }

  /**
   * Initializes the parser and runs it against the file located at the passed in path.
   *
   * @param path {@link String} path to the file.
   * @return {@link Optional <CompilationUnit>}
   */
  public static Optional<CompilationUnit> initializeParser(String path) {
    System.out.println("Initializing parser, and parsing the following file:\n" + path);
    CompilationUnit compilationUnit = null;
    try {
      compilationUnit = StaticJavaParser.parse(new File(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return Optional.ofNullable(compilationUnit);
  }

  /**
   * Loads a class using the {@link CompilationUnit} passed in and returns the resulting declaration for parsing. This
   * class must exist within the directory parsed originally in {@link #initializeParser(String)}
   *
   * @param cu        {@link CompilationUnit}
   * @param classname {@link String} The name of the class to load.
   * @return {@link Optional <ClassOrInterfaceDeclaration>} for the named class.
   */
  protected static Optional<ClassOrInterfaceDeclaration> loadClass(CompilationUnit cu, String classname) {
    return cu.getClassByName(classname);
  }

  /**
   * Takes a given {@link MethodCallExpr} and uses the initialized {@link JavaSymbolSolver} to search the source code
   * for the appropriate {@link MethodDeclaration}.
   *
   * @param methodCallExpr {@link MethodCallExpr}
   * @return An {@link Optional}, containing the corresponding {@link MethodDeclaration}
   */
  protected static Optional<MethodDeclaration> resolveMethodDeclaration(MethodCallExpr methodCallExpr) {
    MethodDeclaration wrappedDeclaration = null;
    ResolvedMethodDeclaration correspondingDeclaration = methodCallExpr.resolve();

    if (correspondingDeclaration instanceof JavaParserMethodDeclaration) {
      JavaParserMethodDeclaration declaration = (JavaParserMethodDeclaration) correspondingDeclaration;
      Node wrappedNode = declaration.getWrappedNode();
      wrappedDeclaration = (MethodDeclaration) wrappedNode;
      System.out.println();
    }

    return Optional.ofNullable(wrappedDeclaration);
  }

  /**
   * Takes the content {@link String} passed in, and writes it to a java file with the provided name, in the provided
   * directory location.
   *
   * @param filename  Name of the file, including extension, ex: "Book.java"
   * @param directory Path to directory to create the file
   * @param content   {@link String} content of the file
   * @throws IOException
   */
  public static void writeJavaCodeToFile(String filename, String directory, String content) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(directory + filename));
    writer.write(content);
    writer.close();
  }

  /**
   * Returns the list of class methods.
   *
   * @param classOrInterfaceDeclaration {@link ClassOrInterfaceDeclaration}
   * @return {@link List} of all {@link MethodDeclaration}
   */
  protected static List<MethodDeclaration> getListOfClassMethods(ClassOrInterfaceDeclaration
                                                                   classOrInterfaceDeclaration) {
    return getListOfClassMethods("", classOrInterfaceDeclaration);
  }

  /**
   * Returns the list of class methods containing the passed in method name.
   *
   * @param methodName                  {@link String} method name to search for
   * @param classOrInterfaceDeclaration {@link ClassOrInterfaceDeclaration}
   * @return {@link List} of all matching {@link MethodDeclaration}
   */
  protected static List<MethodDeclaration> getListOfClassMethods(String methodName, ClassOrInterfaceDeclaration
    classOrInterfaceDeclaration) {
    List<MethodDeclaration> result = new ArrayList<>();
    classOrInterfaceDeclaration.getMethods().stream()
      .filter(method -> method.getName().toString().equals(methodName))
      .collect(Collectors.toCollection(() -> result));
    return result;
  }

  private static List<CommentReportEntry> generateCommentReportData(String filepath) throws FileNotFoundException {

    CompilationUnit cu = StaticJavaParser.parse(new File(filepath));

    return cu.getAllContainedComments().stream()
      .filter(Comment::isOrphan)
      .filter(Comment::isLineComment)
      .map(p -> new CommentReportEntry(filepath.substring(filepath.lastIndexOf('/') + 1),
        p.getClass().getSimpleName(), p.getContent(), p.getRange().get().begin.line,
        !p.getCommentedNode().isPresent()))
      .collect(Collectors.toList());
  }

  /**
   * Class that visits all method calls within a given method and returns the results as a list.
   */
  public static class MethodCallVisitor extends VoidVisitorAdapter<List<MethodCallExpr>> {

    private final String keyword;
    private final boolean strict;

    public MethodCallVisitor(String keywords) {
      super();
      this.keyword = keywords;
      this.strict = false;
    }

    public MethodCallVisitor(String keywords, boolean strict) {
      super();
      this.keyword = keywords;
      this.strict = strict;
    }

    @Override
    public void visit(MethodCallExpr methodCallExpr, List<MethodCallExpr> collector) {
      if (strict) {
        if (methodCallExpr.getName().asString().equals(keyword)) {
          collector.add(methodCallExpr);
        }
      } else {
        if (methodCallExpr.getName().asString().contains(keyword)) {
          collector.add(methodCallExpr);
        }
      }
      super.visit(methodCallExpr, collector);
    }
  }

  /**
   * Class that visits all method calls within a given method and returns the results as a list.
   */
  public static class MethodFieldVisitor extends VoidVisitorAdapter<List<NameExpr>> {

    public MethodFieldVisitor() {
      super();
    }

    @Override
    public void visit(NameExpr fieldAccessExpr, List<NameExpr> collector) {
      super.visit(fieldAccessExpr, collector);
      collector.add(fieldAccessExpr);
    }
  }

  /**
   * Class that visits all method calls within a given method and returns the results as a list.
   */
  public static class VarAccessChanger extends ModifierVisitor<Void> {

    private final List<String> varsToAccessInMainFile;
    private final String parentClassName;

    public VarAccessChanger(List<String> varsToAccessInMainFile, String parentClassName) {
      super();
      this.varsToAccessInMainFile = varsToAccessInMainFile;
      this.parentClassName = parentClassName;
    }

    @Override
    public NameExpr visit(NameExpr nameExpr, Void arg) {
      super.visit(nameExpr, arg);
      if (varsToAccessInMainFile.contains(nameExpr.getNameAsString())) {
        nameExpr.setName(parentClassName + "." + nameExpr.getNameAsString());
      }
      return nameExpr;
    }
  }

  /**
   * Class that visits all methods and deletes them if they are in the list of passed in MethodDeclarations
   */
  public static class MethodDeleter extends ModifierVisitor<Void> {

    private List<MethodDeclaration> toDelete;

    public MethodDeleter(List<MethodDeclaration> toDelete) {
      this.toDelete = toDelete;
    }

    @Override
    public MethodDeclaration visit(MethodDeclaration md, Void arg) {
      super.visit(md, arg);
      if (toDelete.contains(md)) {
        return null;
      }
      return md;
    }
  }

  /**
   * Class that visits all methods and deletes them if they are in the list of passed in MethodDeclarations
   */
  public static class MethodExposer extends ModifierVisitor<Void> {

    private List<MethodDeclaration> toModify;

    public MethodExposer(List<MethodDeclaration> toModify) {
      this.toModify = toModify;
    }

    @Override
    public MethodDeclaration visit(MethodDeclaration md, Void arg) {
      super.visit(md, arg);
      if (toModify.contains(md)) {
        md.setModifier(Modifier.Keyword.PRIVATE, false);
        md.setModifier(Modifier.Keyword.STATIC, true);
        md.setModifier(Modifier.Keyword.PUBLIC, true);
      }
      return md;
    }
  }

  /**
   * Class that visits all calls in calls and changes the access to an external class if it matches one of the passed
   * in labels.
   */
  public static class MethodStaticCallAdder extends ModifierVisitor<Void> {

    private List<String> methodNames;
    private String versionCode;

    public MethodStaticCallAdder(List<String> methodNames, String versionCode) {
      this.methodNames = methodNames;
      this.versionCode = versionCode;
    }

    @Override
    public MethodCallExpr visit(MethodCallExpr methodCallExpr, Void arg) {
      super.visit(methodCallExpr, arg);
      if (methodNames.contains(methodCallExpr.getNameAsString())) {
        //eg. convertPatient -> Patient30_50.convertPatient
        methodCallExpr.setName(methodCallExpr.getNameAsString().replace(KEYWORD_CONVERT, "")
          + versionCode + "." + methodCallExpr.getNameAsString());
      }
      return methodCallExpr;
    }
  }

  private static class CommentReportEntry {
    public String filename;
    public String type;
    public String text;
    public int lineNumber;
    public boolean isOrphan;

    CommentReportEntry(String filename, String type, String text, int lineNumber,
                       boolean isOrphan) {
      this.filename = filename;
      this.type = type;
      this.text = text;
      this.lineNumber = lineNumber;
      this.isOrphan = isOrphan;
    }

    @Override
    public String toString() {
      return filename + " | " + lineNumber + " | " + type + " | " + text.replaceAll("\\n", "").trim();
    }
  }

  // ------------- Version String Manipulation Stuff

  public static final String MODEL_IMPORT_PATH = "org.hl7.fhir.%1$s.model.%2$s";
  public static final String MODEL_ABSOLUTE_PATH = "/org.hl7.fhir.%1$s/src/main/java/org/hl7/fhir/%1$s/model/%2$s.java";
  public static final String MODEL_PATH_WITHOUT_IMPORT = "/org.hl7.fhir.%1$s/src/main/java/";

  public static String getVersionStringFromPath(String path) {
    if (path.contains("dstu2")) return "dstu2";
    if (path.contains("dstu2016may")) return "dstu2016may";
    if (path.contains("dstu3")) return "dstu3";
    if (path.contains("r4")) return "r4";
    if (path.contains("r5")) return "r5";

    return null;
  }

  public static String getVersionString(String version) {
    switch (version) {
      case ("10"):
        return "dstu2";
      case ("14"):
        return "dstu2016may";
      case ("30"):
        return "dstu3";
      case ("40"):
        return "r4";
      case ("50"):
        return "r5";
      default:
        throw new IllegalArgumentException("Passed in version " + version + ", no such mapping exists...");
    }
  }

  public static String getModelAbsolutePathFromVersion(String convertorClassName) {
    String projectDirectory = new File("").getAbsolutePath();
    String version = getFromVersion(convertorClassName);
    return projectDirectory + String.format(MODEL_ABSOLUTE_PATH, getVersionString(version), extractName(convertorClassName));
  }

  public static String getModelAbsolutePathToVersion(String convertorClassName) {
    String projectDirectory = new File("").getAbsolutePath();
    String version = getToVersion(convertorClassName);
    return projectDirectory + String.format(MODEL_ABSOLUTE_PATH, getVersionString(version), extractName(convertorClassName));
  }

  public static String importStatementToAbsolutePath(String importStatement) {
    String projectDirectory = new File("").getAbsolutePath();

    String placeholder = null;
    if (importStatement.contains("dstu2")) {
      placeholder = "dstu2";
    } else if (importStatement.contains("dstu2016may")) {
      placeholder = "dstu2016may";
    } else if (importStatement.contains("dstu3")) {
      placeholder = "dstu3";
    } else if (importStatement.contains("r4")) {
      placeholder = "r4";
    } else if (importStatement.contains("r5")) {
      placeholder = "r5";
    }

    return projectDirectory + String.format(MODEL_PATH_WITHOUT_IMPORT, placeholder) + importStatement.replace('.', '/') + ".java";
  }

  private static String extractName(String convertorClassName) {
    return convertorClassName.substring(0, convertorClassName.length() - 5);
  }

  public static String getModelImportToVersion(String convertorClassName) {
    String version = getToVersion(convertorClassName);
    return String.format(MODEL_IMPORT_PATH, getVersionString(version), extractName(convertorClassName));
  }

  public static String getModelImportFromVersion(String convertorClassName) {
    String version = getFromVersion(convertorClassName);
    return String.format(MODEL_IMPORT_PATH, getVersionString(version), extractName(convertorClassName));
  }

  public static String getFromVersion(String className) {
    String version = className.substring(className.length() - 5);
    return version.substring(0, version.indexOf('_'));
  }

  public static String getToVersion(String className) {
    String version = className.substring(className.length() - 5);
    return version.substring(version.indexOf('_') + 1, version.indexOf('_') + 3);
  }

  public static String getLowerVersionAbsPathFromAbsPath(String type1Path, String type2Path, String version) {
    String lowVersionString = getVersionString(version.substring(0, version.indexOf('_')));
    if (type1Path.contains(lowVersionString)) {
      return type1Path;
    } else {
      return type2Path;
    }
  }

  public static String getDirectoryOfOppositeModel(String importStatement, String version) {
    String lowVersionString = getVersionString(version.substring(0, version.indexOf('_')));
    String highVersionString = getVersionString(version.substring(version.indexOf('_') + 1, version.indexOf('_') + 3));

    if (importStatement.contains(lowVersionString)) {
      String temp = String.format(MODEL_IMPORT_PATH, highVersionString, "");
      return temp.substring(0, temp.lastIndexOf("model.") + "model.".length());
    } else {
      String temp = String.format(MODEL_IMPORT_PATH, lowVersionString, "");
      return temp.substring(0, temp.lastIndexOf("model.") + "model.".length());
    }
  }

  public static String getLowerVersionAbsPathFromImportStatement(String type1ImportStatement, String
    type2ImportStatement, String version) {
    String type1Path = importStatementToAbsolutePath(type1ImportStatement);
    String type2Path = importStatementToAbsolutePath(type2ImportStatement);
    return getLowerVersionAbsPathFromAbsPath(type1Path, type2Path, version);
  }

  public static String getHigherVersionAbsPath(String type1ImportStatement, String type2ImportStatement, String
    version) {
    String type1Path = importStatementToAbsolutePath(type1ImportStatement);
    String type2Path = importStatementToAbsolutePath(type2ImportStatement);

    String lowVersionString = getVersionString(version.substring(0, version.indexOf('_')));
    if (type1Path.contains(lowVersionString)) {
      return type2Path;
    } else {
      return type1Path;
    }
  }
}

