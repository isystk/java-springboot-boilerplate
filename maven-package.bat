@echo off

set PJT_HOME=%~dp0\..\docker-java
set JAVA_HOME=%PJT_HOME%\tools\java\11
set MAVEN_HOME=%PJT_HOME%\tools\maven

set PATH=%JAVA_HOME%\bin;%PATH%
set PATH=%MAVEN_HOME%\bin;%PATH%

call cd %~dp0
call mvn clean package -Dmaven.test.skip=true -Dspring.profiles.active="local"
rem call mvn clean package -Dmaven.test.skip=true -Dspring.profiles.active="staging"
rem call mvn clean package -Dmaven.test.skip=true -Dspring.profiles.active="production"

pause