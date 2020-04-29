@echo off

set oldver=4.2.21
set newver=4.2.22

echo ..
echo =========================================================================
echo upgrade and release fhir.core from %oldver%-SNAPSHOT to %newver%-SNAPSHOT
echo =========================================================================
echo ..

call mvn versions:set -DnewVersion=%newver%-SNAPSHOT

call git commit -t v%newver% -a -m "Release new version %newver%"
call git tag v%newver%

call git push origin master
call "C:\tools\fnr.exe" -dir "C:\work\org.hl7.fhir\build" -fileMask "*.xml" -find "%oldver%-SNAPSHOT" -replace "%newver%-SNAPSHOT" -count 8
call "C:\tools\fnr.exe" -dir "C:\work\org.hl7.fhir\fhir-ig-publisher" -fileMask "*.xml" -find "%oldver%-SNAPSHOT" -replace "%newver%-SNAPSHOT" -count 2
call "C:\tools\fnr.exe" -dir "C:\work\org.hl7.fhir\latest-ig-publisher" -fileMask "*.html" -find "%oldver%" -replace "%newver%" -count 1
call "C:\tools\fnr.exe" -dir "C:\work\org.hl7.fhir\latest-ig-publisher" -fileMask "*.json" -find "%oldver%" -replace "%newver%" -count 1
call mvn clean deploy -Dmaven.test.redirectTestOutputToFile=false -DdeployAtEnd=true 
IF %ERRORLEVEL% NEQ 0 ( 
  GOTO DONE
)

call "C:\tools\versionNotes.exe" -fileName C:\work\org.hl7.fhir\latest-ig-publisher\release-notes-validator.md -version %newver% -fileDest C:\temp\current-release-notes-validator.md -url https://storage.googleapis.com/ig-build/org.hl7.fhir.validator.jar -maven https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation.cli&v=%newver%-SNAPSHOT&e=jar

call gsutil cp -a public-read org.hl7.fhir.validation.cli\target\org.hl7.fhir.validation.cli-%newver%-SNAPSHOT.jar gs://ig-build/org.hl7.fhir.validator.jar

cd ..\latest-ig-publisher
call git commit -a -m "Release new validator version %newver%-SNAPSHOT"
call git push origin master
cd ..\org.hl7.fhir.core

call python c:\tools\zulip-api\zulip\zulip\send.py --stream committers/notification --subject "java core" -m "New Java Core v%newver%-SNAPSHOT released. New Validator at https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation.cli&v=%newver%-SNAPSHOT&e=jar, and also deployed at https://storage.googleapis.com/ig-build/org.hl7.fhir.validator.jar" --config-file zuliprc
call python c:\tools\zulip-api\zulip\zulip\send.py --stream tooling/releases --subject "Validator" --config-file zuliprc < C:\temp\current-release-notes-validator.md 

del C:\temp\current-release-notes-validator.md 

:DONE
echo ===============================================================
echo all done
echo ===============================================================
pause
 