@echo off

set PJT_HOME=%~dp0\..\docker-java
set JAVA_HOME=%PJT_HOME%\tools\java\11
set MAVEN_HOME=%PJT_HOME%\tools\maven

set PATH=%JAVA_HOME%\bin;%PATH%
set PATH=%MAVEN_HOME%\bin;%PATH%

call cd %~dp0
java -jar  -Dspring.profiles.active=local web-front/target/web-front.jar
rem java -jar  -Dspring.profiles.active=staging web-front/target/web-front.jar
rem java -jar  -Dspring.profiles.active=production web-front/target/web-front.jar

pause