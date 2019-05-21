REM replace versions before running
REM make sure you are committed

@echo off
echo
echo =====================================================================
echo upgrade and release fhir.core from 3.7.34-SNAPSHOT to 3.7.35-SNAPSHOT
echo =====================================================================
echo
echo check versions and make sure committed...
pause

call mvn versions:set -DnewVersion=3.7.35-SNAPSHOT
call git commit -a -m "Release new version"
call git push origin master
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.java" --includeSubDirectories --find "3.7.34-SNAPSHOT" --replace "3.7.35-SNAPSHOT"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\fhir-ig-publisher" --fileMask "*.xml" --includeSubDirectories --find "3.7.34-SNAPSHOT" --replace "3.7.35-SNAPSHOT"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.xml" --find "3.7.34-SNAPSHOT" --replace "3.7.35-SNAPSHOT"
call mvn deploy
call python c:\tools\zulip-api\zulip\zulip\send.py --stream committers/notification --subject "java core" -m "New Java Core v3.7.35-SNAPSHOT released." --config-file zuliprc

echo ===============================================================
echo all done
echo ===============================================================
pause
 