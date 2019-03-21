REM replace versions before running
REM make sure you are committed

echo

echo ===============================================================
echo upgrade and release fhir.core from 3.7.17-SNAPSHOT to 3.7.18-SNAPSHOT
echo ===============================================================
pause

call mvn versions:set -DnewVersion=3.7.18-SNAPSHOT

echo ===============================================================
echo upgraded version number using maven
echo next: do git commit / push
echo ===============================================================
pause

call git commit -a -m "Release new version"
call git push origin master

echo ===============================================================
echo done git commit / push
echo next: replace references in java code + ivy
echo ===============================================================
pause

call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.java" --excludeFileMask "*.dll, *.exe" --includeSubDirectories --find "3.7.17-SNAPSHOT" --replace "3.7.18-SNAPSHOT"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.xml" --excludeFileMask "*.dll, *.exe" --find "3.7.17-SNAPSHOT" --replace "3.7.18-SNAPSHOT"

echo ===============================================================
echo done replacing references
echo next: do maven release
echo ===============================================================
pause

call mvn deploy

echo ===============================================================
echo all done
echo ===============================================================
pause
 