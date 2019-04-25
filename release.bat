REM replace versions before running
REM make sure you are committed

echo

echo ===============================================================
echo upgrade and release fhir.core from 3.7.28-SNAPSHOT to 3.7.29-SNAPSHOT
echo ===============================================================
pause

call mvn versions:set -DnewVersion=3.7.29-SNAPSHOT
call git commit -a -m "Release new version"
call git push origin master
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.java" --excludeFileMask "*.dll, *.exe" --includeSubDirectories --find "3.7.28-SNAPSHOT" --replace "3.7.29-SNAPSHOT"
call "C:\tools\fnr.exe" --cl --dir "C:\work\org.hl7.fhir\build" --fileMask "*.xml" --excludeFileMask "*.dll, *.exe" --find "3.7.28-SNAPSHOT" --replace "3.7.29-SNAPSHOT"
call mvn deploy

echo ===============================================================
echo all done
echo ===============================================================
pause
 