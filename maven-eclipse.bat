@echo off

set PJT_HOME=%~dp0\..\docker-java
set JAVA_HOME=%PJT_HOME%\tools\java\11

set PATH=%JAVA_HOME%\bin;%PATH%

call cd %~dp0
call mvnw -X -U eclipse:clean eclipse:eclipse -f pom.xml

pause