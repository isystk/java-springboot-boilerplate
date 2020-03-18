@echo off

set PJT_HOME=%~dp0\..
set JAVA_HOME=%PJT_HOME%\tools\java\8
set MAVEN_HOME=%PJT_HOME%\tools\maven

set PATH=%JAVA_HOME%\bin;%PATH%
set PATH=%MAVEN_HOME%\bin;%PATH%

call cd %~dp0
call mvn -X -U -f pom.xml clean package assembly:assembly

pause