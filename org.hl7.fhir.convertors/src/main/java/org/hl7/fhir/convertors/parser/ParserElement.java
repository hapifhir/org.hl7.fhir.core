package org.hl7.fhir.convertors.parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.SourceRoot;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserElement {

  public static final String ELEMENT = "Element";

  private static final List<String> VERSION_FILES = Arrays.asList("10_30", "10_40", "10_50", "14_30", "14_40", "14_50", "30_40", "30_50", "40_50");
  private static final List<String> BASE_TYPES = Arrays.asList("Base64Binary", "Boolean", "Canonical", "Code",
    "Enumeration", "Date", "DateType", "Decimal", "Id", "Instant", "Integer", "Integer64",
    "Markdown", "Oid", "PositiveInt", "String", "Time", "UnsignedInt", "Uri", "Url",
    "Uuid", "XhtmlNode");
  private static final List<String> VERSION_FILES2 = Arrays.asList("30_40", "30_50", "40_50");
  private static String MODEL_BASE_PATH = "/Users/markiantorno/Documents/Development/fhir/org.hl7.fhir.core/org.hl7.fhir.%1$s/src/main/java/";

  public static void main(String[] args) {
    VERSION_FILES.forEach(version -> {
    List<String> filenames = listAllJavaFilesInDirectory(new File("").getAbsolutePath() + "/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/");
    System.out.println("Checking the following files:");
    Collections.sort(filenames);
    filenames.forEach(System.out::println);
    filenames.forEach(name -> {
      try {
        modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/", name, ".java", BASE_TYPES, version);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });
    });

//    VERSION_FILES2.forEach(version -> {
//
//      try {
//        modifyElementNotField("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/", "VersionConvertor_" + version, ".java", BASE_TYPES, version);
//      } catch (FileNotFoundException e) {
//        e.printStackTrace();
//      }
//
//    });

  }

  public static HashMap<MethodDeclaration, HashMap<ExpressionStmt, String>> masterList = new HashMap<>();

  public static void modifyElementNotField(String srcdirectory, String filename, String extension, List<String> listOfPrimitiveTypes, String version) throws FileNotFoundException {
    String projectDirectory = new File("").getAbsolutePath();
    String filePathWithExtension = projectDirectory + srcdirectory + filename + extension;
    CompilationUnit compilationUnit = getCompilationUnit(filePathWithExtension);
    ClassOrInterfaceDeclaration classOrInterfaceDeclaration = initializeTypeSovlerAndParser(compilationUnit,
      projectDirectory, srcdirectory, filename);

    List<MethodDeclaration> methods = classOrInterfaceDeclaration.getMethods();
    for (MethodDeclaration md : methods) {
      if (!masterList.containsKey(md)) {
        masterList.put(md, new HashMap<>());
      }

      if (!md.getNameAsString().contains("convert")) continue;

      Optional<Parameter> src = md.getParameters().stream()
        .filter(p -> p.getName().toString().equals("src"))
        .findAny();
      if (!src.isPresent()) {
        continue;
      }

      Type toType = md.getType();
      Type fromType = src.get().getType();

      final ClassOrInterfaceDeclaration toClass = resolveClassRefFromType(toType);
      final ClassOrInterfaceDeclaration fromClass = resolveClassRefFromType(fromType);
      if ((toClass != null) && (fromClass != null)) {
        md.accept(new ModifierVisitor<Void>() {
          @Override
          public Visitable visit(ExpressionStmt n, Void arg) {
            super.visit(n, arg);
            if (n.toString().contains("src.get") && n.toString().contains("tgt.set")) {
              try {
                if (canModifyElement(n, fromClass, toClass)) {
                  String s = generateNewIfStatement(n, fromClass, toClass, version);
                  if (masterList.get(md).containsKey(n)) throw new IllegalStateException();
                  masterList.get(md).put(n, s);
                } else {
                  String s = generateOldIfStatement(n, fromClass);
                  masterList.get(md).put(n, s);
                }
                System.gc();
              } catch (Exception e) {
                System.out.println(e.getMessage());
              }
            }
            return n;
          }
        }, null);
      } else {
        //System.out.println("At least one class dec null...");
      }
    }

    for (MethodDeclaration md : methods) {
      md.accept(new ModifierVisitor<Void>() {
        @Override
        public Visitable visit(MethodDeclaration n, Void arg) {
          super.visit(n, arg);

          String bodyString = n.getBody().get().toString();

          HashMap<ExpressionStmt, String> map = masterList.get(md);
          for (ExpressionStmt e : map.keySet()) {
            if (!bodyString.contains(e.toString())) {
              throw new IllegalStateException("Cannot find expression in method block...");
            } else {
              bodyString = bodyString.replace(e.toString(), map.get(e));
            }
          }
          BlockStmt blockStmt = StaticJavaParser.parseBlock(bodyString);
          n.removeBody();
          n.setBody(blockStmt);
          return n;
        }
      }, null);
    }

    deleteFile(filePathWithExtension);

    try {
      writeStringToFile(compilationUnit.toString(), filePathWithExtension);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static boolean methodWithNameExists(String methodName, ClassOrInterfaceDeclaration classType) {
    return methodWithNameExists(methodName, classType, new HashSet<>());
  }

  private static boolean methodWithNameExists(String methodName, ClassOrInterfaceDeclaration classType, Set<String> visited) {
    if (classType == null) return false;

    List<String> collect = classType.getMethods().stream()
      .map(NodeWithSimpleName::getNameAsString)
      .collect(Collectors.toList());

    if (collect.contains(methodName)) {
      return true;
    } else if (classType.getExtendedTypes().isEmpty()) {
      return false;
    } else {

      System.out.println("searching class :: " + classType.getNameAsString() + ", for method name :: " + methodName);
      ClassOrInterfaceType extendedType = classType.getExtendedTypes(0);
      if (extendedType.getNameAsString().contains("PrimitiveType") || extendedType.getNameAsString().contains("BackboneElement")) {
        return false;
      }
      String qualifiedName = ((ReferenceTypeImpl) extendedType.resolve()).getQualifiedName();
      ClassOrInterfaceDeclaration classOrInterfaceDeclaration = qualifiedPathToClassInterface(qualifiedName);
      if (visited.contains(classOrInterfaceDeclaration.getNameAsString())) {
        return false;
      } else {
        visited.add(classOrInterfaceDeclaration.getNameAsString());
        return methodWithNameExists(methodName, classOrInterfaceDeclaration, visited);
      }
    }
  }

  private static Type getReturnType(String methodName, ClassOrInterfaceDeclaration classType) {
    Optional<MethodDeclaration> first = classType.getMethods().stream()
      .filter(md -> md.getNameAsString().equals(methodName))
      .findFirst();
    if (first.isPresent()) {
      return first.get().getType();
    } else if (!classType.getExtendedTypes().isEmpty()) {
      String qualifiedName = ((ReferenceTypeImpl) classType.getExtendedTypes(0).resolve()).getQualifiedName();
      ClassOrInterfaceDeclaration classOrInterfaceDeclaration = qualifiedPathToClassInterface(qualifiedName);
      return getReturnType(methodName, classOrInterfaceDeclaration);
    } else {
      throw new IllegalArgumentException("Method requested, " + methodName + " doesn't exist in class type " + classType.getNameAsString());
    }
  }

  private static Type getParameterType(String methodName, ClassOrInterfaceDeclaration classType) {
    Optional<MethodDeclaration> first = classType.getMethods().stream()
      .filter(md -> md.getNameAsString().equals(methodName))
      .findFirst();
    if (!first.isPresent()) {
      if (!classType.getExtendedTypes().isEmpty()) {
        System.out.println("Method Name :: " + methodName);
        System.out.println("Class :: " + classType.getNameAsString());
        String qualifiedName = ((ReferenceTypeImpl) classType.getExtendedTypes(0).resolve()).getQualifiedName();
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = qualifiedPathToClassInterface(qualifiedName);
        return getParameterType(methodName, classOrInterfaceDeclaration);
      } else {
        throw new IllegalArgumentException("Method requested, " + methodName + " doesn't exist in class type " + classType.getNameAsString());
      }
    } else if (first.get().getParameters().isEmpty()) {
      throw new IllegalArgumentException("Method requested, " + methodName + " doesn't have parameters");
    } else {
      return first.get().getParameter(0).getType();
    }
  }

  public static final String OLD_CONDITION_STATEMENT_TEMPLATE = "src.has%1$s()";
  public static final String NEW_CONDITION_STATEMENT_TEMPLATE = "src.has%1$sElement()";
  public static final String NEW_EXPR_STATEMENT_TEMPLATE = "tgt.set%1$sElement(convert%3$s(src.get%4$sElement()));";
  public static final String NEW_EXPR_STATEMENT_TEMPLATE_SUBFILE = "tgt.set%1$sElement(VersionConvertor_convertor%2$s.convert%3$s(src.get%4$sElement()));";

  private static Statement modifyElementAccess(ExpressionStmt n, ClassOrInterfaceDeclaration fromType, ClassOrInterfaceDeclaration toType, String version) throws Exception {
    if (!canModifyElement(n, fromType, toType)) throw new IllegalArgumentException("Cannot modify passed in elements.");

    MethodCallExpr methodCallExpr = (MethodCallExpr) n.getChildNodes().get(0);
    String setMethodName = methodCallExpr.getNameAsString();
    String getMethodName = ((MethodCallExpr) ((MethodCallExpr) n.getExpression()).getArgument(0)).getNameAsString();

    String paramTypeString = getParameterType(setMethodName + ELEMENT, toType).toString();
    String returnTypeName = getReturnType(getMethodName + ELEMENT, fromType).toString();

    String expString = String.format(NEW_EXPR_STATEMENT_TEMPLATE,
      setMethodName.replace("set", ""),
      version,
      returnTypeName.replace("Type", ""),
      getMethodName.replace("get", ""));
    return StaticJavaParser.parseStatement(expString);
  }

  private static String generateNewIfStatement(ExpressionStmt n, ClassOrInterfaceDeclaration fromType, ClassOrInterfaceDeclaration toType, String version) {
    if (!canModifyElement(n, fromType, toType)) throw new IllegalArgumentException("Cannot modify passed in elements.");

    MethodCallExpr methodCallExpr = (MethodCallExpr) n.getChildNodes().get(0);
    String setMethodName = methodCallExpr.getNameAsString();
    String getMethodName = ((MethodCallExpr) ((MethodCallExpr) n.getExpression()).getArgument(0)).getNameAsString();

    String paramTypeString = getParameterType(setMethodName + ELEMENT, toType).toString();
    String returnTypeName = getReturnType(getMethodName + ELEMENT, fromType).toString();

    String condition = String.format(NEW_CONDITION_STATEMENT_TEMPLATE, getMethodName.replace("get", ""));

    String expString = String.format(NEW_EXPR_STATEMENT_TEMPLATE_SUBFILE,
      setMethodName.replace("set", ""),
      version,
      returnTypeName.replace("Type", ""),
      getMethodName.replace("get", ""));

    if (n.getParentNode().get() instanceof IfStmt) {
      return expString;
    } else {
      IfStmt ifStmt = new IfStmt();
      ifStmt.setCondition(StaticJavaParser.parseExpression(condition));
      ifStmt.setThenStmt(StaticJavaParser.parseStatement(expString));
      return ifStmt.toString();
    }
  }

  private static String generateOldIfStatement(ExpressionStmt n, ClassOrInterfaceDeclaration fromType) {
    if (n.getParentNode().get() instanceof IfStmt) {
      return n.toString();
    }
    String getMethodName = ((MethodCallExpr) ((MethodCallExpr) n.getExpression()).getArgument(0)).getNameAsString();
    if (((MethodCallExpr) n.getExpression()).getArgument(0) instanceof MethodCallExpr) {
      getMethodName = ((MethodCallExpr) ((MethodCallExpr) ((MethodCallExpr) n.getExpression()).getArgument(0)).getArgument(0)).getNameAsString();
    }
    if (methodWithNameExists("has" + getMethodName.replace("get", ""), fromType)) {
      String condition = String.format(OLD_CONDITION_STATEMENT_TEMPLATE, getMethodName.replace("get", ""));

      IfStmt ifStmt = new IfStmt();
      ifStmt.setCondition(StaticJavaParser.parseExpression(condition));
      ifStmt.setThenStmt(n);

      return ifStmt.toString();
    } else {
      return n.toString();
    }
  }

  private static boolean canModifyElement(ExpressionStmt n, ClassOrInterfaceDeclaration fromClass, ClassOrInterfaceDeclaration toClass) {
    MethodCallExpr methodCallExpr = (MethodCallExpr) n.getChildNodes().get(0);
    String setMethodName = methodCallExpr.getNameAsString();
    String getMethodName = ((MethodCallExpr) ((MethodCallExpr) n.getExpression()).getArgument(0)).getNameAsString();
    System.out.println("Can modify element: n :: " + n.toString() + ", fromClass :: " + fromClass.getNameAsString() + ", toClass :: " + toClass.getNameAsString());
    return !getMethodName.contains("convert") &&
      methodWithNameExists(setMethodName + ELEMENT, toClass)
      && methodWithNameExists(getMethodName + ELEMENT, fromClass)
      && methodWithNameExists("has" + getMethodName.replace("get", "") + ELEMENT, fromClass)
      && (getParameterType(setMethodName + ELEMENT, toClass).toString().equals(getReturnType(getMethodName + ELEMENT, fromClass).toString()));
  }

  public static ClassOrInterfaceDeclaration resolveClassRefFromType(Type type) {
    if (!(type instanceof ClassOrInterfaceType)) {
      return null; //throw new IllegalStateException("Type " + type.toString() + " is not instanceof ClassOrInterfaceType");
    }

    Optional<ClassOrInterfaceType> optionalScope = ((ClassOrInterfaceType) type).getScope();
    try {
      if (optionalScope.isPresent()) {
        ClassOrInterfaceType classOrInterfaceType = optionalScope.get();
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = qualifiedPathToClassInterface(classOrInterfaceType.toString() + "." + ((ClassOrInterfaceType) type).getNameAsString());

        if (classOrInterfaceDeclaration == null || !classOrInterfaceType.getNameAsString().equals("model")) {
          classOrInterfaceDeclaration = qualifiedPathToClassInterface(classOrInterfaceType.toString());
          Optional<ClassOrInterfaceDeclaration> any = classOrInterfaceDeclaration.getChildNodes().stream()
            .filter(node -> node instanceof ClassOrInterfaceDeclaration)
            .map(node -> (ClassOrInterfaceDeclaration) node)
            .filter(c -> c.getNameAsString().equals(((ClassOrInterfaceType) type).getNameAsString()))
            .findAny();
          if (any.isPresent()) {
            return any.get();
          } else {
            return null;
          }
        }
        return classOrInterfaceDeclaration;
      }
    }catch (NullPointerException e) {
      System.out.println();
    }
    return null;
  }

  public static ClassOrInterfaceDeclaration qualifiedPathToClassInterface(String qualifiedPath) {
    String baseDir = importStatementToAbsoluteBasePath(qualifiedPath);
    String plainName = qualifiedPath.substring(qualifiedPath.lastIndexOf('.') + 1);
    String toReturn = baseDir + qualifiedPath.replace(".", "/") + ".java";
    CompilationUnit compilationUnit = null;
    try {
      compilationUnit = StaticJavaParser.parse(new File(toReturn));
    } catch (FileNotFoundException e) {
      return null;
    }
    Optional<ClassOrInterfaceDeclaration> optionalClass = compilationUnit.getClassByName(plainName);
    return optionalClass.orElse(null);
  }

  public static String importStatementToAbsoluteBasePath(String importStatement) {
    String projectDirectory = new File("").getAbsolutePath();

    String placeholder = null;
    if (importStatement.contains("dstu2016may")) {
      placeholder = "dstu2016may";
    } else if (importStatement.contains("dstu2")) {
      placeholder = "dstu2";
    } else if (importStatement.contains("dstu3")) {
      placeholder = "dstu3";
    } else if (importStatement.contains("r4")) {
      placeholder = "r4";
    } else if (importStatement.contains("r5")) {
      placeholder = "r5";
    }

    return String.format(MODEL_BASE_PATH, placeholder);
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
        .map(ParserElement::pullFileNameFromPath)
        .collect(Collectors.toCollection(() -> result));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  private static CompilationUnit getCompilationUnit(String filePathWithExtension) {
    Optional<CompilationUnit> compilationUnit = initializeParser(filePathWithExtension);
    if (!compilationUnit.isPresent()) {
      System.out.println("\nNo compilation unit generated during class parsing...aborting.");
      System.exit(0);
    }
    return compilationUnit.get();
  }

  /**
   * Initializes the parser and runs it against the file located at the passed in path.
   *
   * @param path {@link String} path to the file.
   * @return {@link Optional <CompilationUnit>}
   */
  public static Optional<CompilationUnit> initializeParser(String path) {
    CompilationUnit compilationUnit = null;
    try {
      compilationUnit = StaticJavaParser.parse(new File(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return Optional.ofNullable(compilationUnit);
  }

  private static ClassOrInterfaceDeclaration initializeTypeSovlerAndParser(CompilationUnit compilationUnit,
                                                                           String projectDirectory,
                                                                           String codeDirectory,
                                                                           String filename) {
    try {
      initializeResolver(projectDirectory, codeDirectory);
    } catch (IOException e) {
      System.out.println("Error initializing typesolver, exiting process...");
      e.printStackTrace();
      System.exit(0);
    }
    Optional<ClassOrInterfaceDeclaration> classOrInterfaceDeclaration = loadClass(compilationUnit, filename);
    if (!classOrInterfaceDeclaration.isPresent()) {
      System.out.println("\nNo class or interface declaration loaded during parsing...aborting.");
      System.exit(0);
    }
    return classOrInterfaceDeclaration.get();
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
   * Attempts to delete the file at the given path.
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

  public static void writeStringToFile(String string, String filepath) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
    writer.write(string);
    writer.close();
  }

}
