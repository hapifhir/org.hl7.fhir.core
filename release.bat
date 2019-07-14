@echo off

set oldver=3.8.10
set newver=3.8.11

echo ..
echo =====================================================================
echo upgrade and release fhir.core from %oldver%-SNAPSHOT to %newver%-SNAPSHOT
echo =====================================================================
echo ..
echo check versions and make sure committed...
pause

call mvn versions:set -DnewVersion=%newver%-SNAPSHOT
call git commit -a -m "Release new version"
call git push origin master
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.xml" --find "%oldver%-SNAPSHOT" --replace "%newver%-SNAPSHOT"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\fhir-ig-publisher" --fileMask "*.xml" --find "%oldver%-SNAPSHOT" --replace "%newver%-SNAPSHOT"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\latest-ig-publisher" --fileMask "*.html" --find "%oldver%" --replace "%newver%"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\latest-ig-publisher" --fileMask "*.json" --find "%oldver%" --replace "%newver%"
call mvn deploy
copy org.hl7.fhir.validation.cli\target\org.hl7.fhir.validation.cli-%newver%-SNAPSHOT.jar ..\latest-ig-publisher\org.hl7.fhir.validator.jar
cd ..\latest-ig-publisher
call git commit -a -m "Release new version %newver%-SNAPSHOT"
call git push origin master
cd ..\org.hl7.fhir.core
call python c:\tools\zulip-api\zulip\zulip\send.py --stream committers/notification --subject "java core" -m "New Java Core v%newver%-SNAPSHOT released. New Validator at https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation.cli&v=%newver%-SNAPSHOT&e=jar, and also deployed at https://fhir.github.io/latest-ig-publisher/org.hl7.fhir.validator.jar" --config-file zuliprc

echo ===============================================================
echo all done
echo ===============================================================
pause
 