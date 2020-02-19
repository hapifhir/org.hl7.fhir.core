package org.hl7.fhir.convertors.parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.MedicationRequest;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumerations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserEnumeration {

    public static final String ELEMENT = "Element";

    private static final List<String> VERSION_FILES = Arrays.asList("10_30", "10_40", "10_50", "14_30", "14_40", "14_50", "30_40", "30_50", "40_50");
    private static String MODEL_BASE_PATH = "/Users/markiantorno/Documents/Development/fhir/org.hl7.fhir.core/org.hl7.fhir.%1$s/src/main/java/";

    public static HashMap<MethodDeclaration, HashMap<ExpressionStmt, String>> masterList = new HashMap<>();

    public static final Set<String> methodNames = new HashSet<>();

    /*
     * %1$s - dstu version src, example r5
     * %2$s - dstu version tgt, example dstu3
     * %3$s - src enum name, with enclosing class, if applicable, eg Account.AccountStatus
     * %4$s - tgt enum name, with enclosing class, if applicable, eg Account.AccountStatus
     * %5$s - version string, eg 10_30
     * %6$s - method name, eg convertAccountStatus
     * %7$s - new switch statement body
     */
    public static final String ENUM_TEMPLATE = "static public org.hl7.fhir.%2$s.model.Enumeration<org.hl7.fhir.%2$s.model.%4$s> %6$s(org.hl7.fhir.%1$s.model.Enumeration<org.hl7.fhir.%1$s.model.%3$s> src) throws FHIRException { " +
            "if (src == null || src.isEmpty()) " +
            "return null; " +
            "org.hl7.fhir.%2$s.model.Enumeration<org.hl7.fhir.%2$s.model.%4$s> tgt = new org.hl7.fhir.%2$s.model.Enumeration<>(new org.hl7.fhir.%2$s.model.%4$sEnumFactory()); " +
            "VersionConvertor_%5$s.copyElement(src, tgt); " +
            "%7$s" +
            "return tgt;" +
            "}";

    /*
     * %1$s - dstu version tgt, example dstu3
     * %2$s - tgt enum name, with enclosing class, if applicable, eg Account.AccountStatus
     * %3$s - ENUM label, eg ACTIVE
     */
    public static final String SWITCH_STATEMENT_TEMPLATE = "tgt.setValue(org.hl7.fhir.%1$s.model.%2$s.%3$s);";
    public static final String SWITCH_BREAK = " break;";

/**
 *             case ACTIVE:
 *                 tgt.setValue(org.hl7.fhir.%2$s.model.%4$s.ACTIVE);
 *                 break;
 *             case INACTIVE:
 *                 tgt.setValue(org.hl7.fhir.%2$s.model.%4$s.INACTIVE);
 *                 break;
 *             default:
 *                 tgt.setValue(org.hl7.fhir.%2$s.model.%4$s.NULL);
 *                 break;
 */

    public static void main(String[] args) {
//        VERSION_FILES.forEach(version -> {
            String version = "10_30";
            List<String> filenames = listAllJavaFilesInDirectory(new File("").getAbsolutePath() + "/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/");
            //System.out.println("Checking the following files:");
            Collections.sort(filenames);
            //filenames.forEach(System.out::println);
            filenames.forEach(name -> {
                try {
                    modifyEnumMethods("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/", name, ".java", version);
                    modifyExpressionsCallingEnums("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + version + "/", name, ".java", version);
                    methodNames.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
//        });

//    VERSION_FILES2.forEach(version -> {
//
//        try {
//            modifyEnumMethods("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + "10_30" + "/", "Account10_30", ".java", "10_30");
//            modifyExpressionsCallingEnums("/org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv" + "10_30" + "/", "Account10_30", ".java", "10_30");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    });

    }

    public static void modifyExpressionsCallingEnums(String srcdirectory, String filename, String extension, String version) {
        String projectDirectory = new File("").getAbsolutePath();
        String filePathWithExtension = projectDirectory + srcdirectory + filename + extension;
        CompilationUnit compilationUnit = getCompilationUnit(filePathWithExtension);
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = initializeTypeSovlerAndParser(compilationUnit,
                projectDirectory, srcdirectory, filename);

        List<MethodDeclaration> methods = classOrInterfaceDeclaration.getMethods();
        for (MethodDeclaration md : methods) {
            md.accept(new ModifierVisitor<Void>() {
                @Override
                public Visitable visit(ExpressionStmt exp, Void arg) {
                    super.visit(exp, arg);
                    Optional<String> methodNameOpt = methodNames.stream()
                            .filter(s -> exp.toString().contains(s + "("))
                            .findFirst();
                    if (methodNameOpt.isPresent()) {
                        try {
                            String outerName = ((MethodCallExpr) exp.getExpression()).getNameAsString();
                            String innerName = ((MethodCallExpr) ((MethodCallExpr) ((MethodCallExpr) exp.getExpression()).getArgument(0)).getArgument(0)).getNameAsString();
                            ((MethodCallExpr) exp.getExpression()).setName(outerName + ELEMENT);
                            ((MethodCallExpr) ((MethodCallExpr) ((MethodCallExpr) exp.getExpression()).getArgument(0)).getArgument(0)).setName(innerName + ELEMENT);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    return exp;
                }
            }, null);
        }

        try {
            writeStringToFile(compilationUnit.toString(), filePathWithExtension);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifyEnumMethods(String srcdirectory, String filename, String extension, String version) {
        String projectDirectory = new File("").getAbsolutePath();
        String filePathWithExtension = projectDirectory + srcdirectory + filename + extension;
        CompilationUnit compilationUnit = getCompilationUnit(filePathWithExtension);
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = initializeTypeSovlerAndParser(compilationUnit,
                projectDirectory, srcdirectory, filename);

        classOrInterfaceDeclaration.accept(new ModifierVisitor<Void>() {
            @Override
            public Visitable visit(MethodDeclaration md, Void arg) {
                super.visit(md, arg);
                Optional<Parameter> src = md.getParameters().stream()
                        .filter(p -> p.getName().toString().equals("src"))
                        .findAny();

                if ((md.getNameAsString().contains("convert")) && (src.isPresent()) && (md.getParameters().size() == 1)) {

                    Type tgtType = md.getType();
                    Type srcType = src.get().getType();

                    final EnumDeclaration toEnum = resolveEnumRefFromType(tgtType);
                    final EnumDeclaration fromEnum = resolveEnumRefFromType(srcType);

                    if (toEnum != null && fromEnum != null) {
                        System.out.println("toEnum :: " + toEnum.getNameAsString());
                        System.out.println("fromEnum :: " + fromEnum.getNameAsString());

                        String dstuVersionSrc = getVersionIdString(srcType.toString());
                        String dstuVersionTgt = getVersionIdString(tgtType.toString());
                        String classNameSrc = srcType.toString().substring(srcType.toString().indexOf("model.") + "model.".length());
                        String classNameTgt = tgtType.toString().substring(tgtType.toString().indexOf("model.") + "model.".length());
                        String methodName = md.getNameAsString();

                        methodNames.add(methodName);

                        final String[] switchStatement = {"PARSING SWITCH DIDN'T WORK"};

                        md.accept(new VoidVisitorAdapter<Void>() {
                            @Override
                            public void visit(SwitchStmt n, Void arg) {
                                System.out.println();
                                n.setSelector(StaticJavaParser.parseExpression("src.getValue()"));
                                for (SwitchEntry switchEntry : n.getEntries()) {
                                    String enumLabel = switchEntry.getStatement(0).toString();
                                    enumLabel = enumLabel.substring(enumLabel.lastIndexOf('.') + 1, enumLabel.indexOf(';'));

                                    String switchStatement = String.format(SWITCH_STATEMENT_TEMPLATE, dstuVersionTgt, classNameTgt, enumLabel);
                                    Statement statement = StaticJavaParser.parseStatement(switchStatement);
                                    Statement breakStatement = StaticJavaParser.parseStatement(SWITCH_BREAK);
                                    switchEntry.setStatement(0, statement);
                                    switchEntry.addStatement(breakStatement);
                                }
                                switchStatement[0] = n.toString();
                            }
                        }, null);

                        String newMethodBody = String.format(ENUM_TEMPLATE, dstuVersionSrc, dstuVersionTgt, classNameSrc, classNameTgt, version, methodName, switchStatement[0]);
                        md = StaticJavaParser.parseMethodDeclaration(newMethodBody);
                    }
                }
                return md;
            }
        }, null);

        try {
            writeStringToFile(compilationUnit.toString(), filePathWithExtension);
        } catch (IOException e) {
            e.printStackTrace();
        }
        methodNames.forEach(System.out::println);
    }

    public static EnumDeclaration resolveEnumRefFromType(Type type) {
        if (!(type instanceof ClassOrInterfaceType)) {
            return null; //throw new IllegalStateException("Type " + type.toString() + " is not instanceof ClassOrInterfaceType");
        }

        Optional<ClassOrInterfaceType> optionalScope = ((ClassOrInterfaceType) type).getScope();
        try {
            if (optionalScope.isPresent()) {
                ClassOrInterfaceType classOrInterfaceType = optionalScope.get();
                EnumDeclaration classOrInterfaceDeclaration = qualifiedPathToEnum(classOrInterfaceType.toString() + "." + ((ClassOrInterfaceType) type).getNameAsString(),
                        ((ClassOrInterfaceType) type).getNameAsString());

                if (classOrInterfaceDeclaration == null || !classOrInterfaceType.getNameAsString().equals("model")) {
                    classOrInterfaceDeclaration = qualifiedPathToEnum(classOrInterfaceType.toString(), ((ClassOrInterfaceType) type).getNameAsString());
                }
                return classOrInterfaceDeclaration;
            }
        } catch (NullPointerException e) {
            System.out.println();
        }
        return null;
    }

    public static EnumDeclaration qualifiedPathToEnum(String qualifiedPath, String enumName) {
        String baseDir = importStatementToAbsoluteBasePath(qualifiedPath);
        String plainName = qualifiedPath.substring(qualifiedPath.lastIndexOf('.') + 1);
        String toReturn = baseDir + qualifiedPath.replace(".", "/") + ".java";
        CompilationUnit compilationUnit = null;
        try {
            compilationUnit = StaticJavaParser.parse(new File(toReturn));
        } catch (FileNotFoundException e) {
            return null;
        }
        Optional<ClassOrInterfaceDeclaration> classByName = compilationUnit.getClassByName(plainName);
        if (classByName.isPresent()) {
            Optional<EnumDeclaration> first = classByName.get().getChildNodes()
                    .stream()
                    .filter(node -> node instanceof EnumDeclaration)
                    .map(node -> (EnumDeclaration) node)
                    .filter(e -> e.getNameAsString().equals(enumName))
                    .findFirst();
            return first.orElse(null);
        } else {
            return null;
        }
    }

    public static String getVersionIdString(String importStatement) {

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

        return placeholder;
    }

    public static String importStatementToAbsoluteBasePath(String importStatement) {
        String placeholder = getVersionIdString(importStatement);
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
                    .map(ParserEnumeration::pullFileNameFromPath)
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
