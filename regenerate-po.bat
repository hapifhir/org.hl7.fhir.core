@echo off
REM Regenerates .po and .properties translation files across the three FHIR repos.
REM Run after editing translations-control.ini (e.g. adding a new language) or
REM after constants change in core code.
REM
REM Build the jar once with:
REM   mvn package -DskipTests --projects org.hl7.fhir.validation.cli --also-make
setlocal
cd /d %~dp0

REM Prefer the freshly-built snapshot in target/, fall back to repo-root validator_cli.jar.
set JAR=
for %%f in (org.hl7.fhir.validation.cli\target\org.hl7.fhir.validation.cli-*-SNAPSHOT.jar) do (
  echo %%~nxf | findstr /v "tests" >nul && set JAR=%%f
)
if not defined JAR if exist validator_cli.jar set JAR=validator_cli.jar
if not defined JAR (
  echo No validator jar found. Build with:
  echo   mvn package -DskipTests --projects org.hl7.fhir.validation.cli --also-make
  exit /b 1
)

echo Using %JAR%
java -jar "%JAR%" lang-regen ^
  "C:\work\HL7\org.hl7.fhir.core" ^
  "C:\work\HL7\fhir-ig-publisher" ^
  "C:\work\ImplementationGuides\nodeserver"
